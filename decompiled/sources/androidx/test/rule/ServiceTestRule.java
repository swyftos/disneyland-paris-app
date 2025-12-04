package androidx.test.rule;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.test.annotation.Beta;
import androidx.test.internal.util.Checks;
import androidx.test.platform.app.InstrumentationRegistry;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

@Beta
/* loaded from: classes2.dex */
public class ServiceTestRule implements TestRule {
    private IBinder binder;
    boolean serviceBound;
    private ServiceConnection serviceConn;
    private Intent serviceIntent;
    boolean serviceStarted;
    private final TimeUnit timeUnit;
    private final long timeout;

    protected void afterService() {
    }

    protected void beforeService() {
    }

    public ServiceTestRule() {
        this(5L, TimeUnit.SECONDS);
    }

    protected ServiceTestRule(long j, TimeUnit timeUnit) {
        this.serviceStarted = false;
        this.serviceBound = false;
        this.timeout = j;
        this.timeUnit = timeUnit;
    }

    public static ServiceTestRule withTimeout(long j, TimeUnit timeUnit) {
        return new ServiceTestRule(j, timeUnit);
    }

    public void startService(@NonNull Intent intent) throws TimeoutException {
        this.serviceIntent = (Intent) Checks.checkNotNull(intent, "intent can't be null");
        InstrumentationRegistry.getInstrumentation().getTargetContext().startService(this.serviceIntent);
        this.serviceStarted = true;
        this.serviceBound = bindServiceAndWait(this.serviceIntent, null, 1);
    }

    public IBinder bindService(@NonNull Intent intent) throws TimeoutException {
        this.serviceIntent = ((Intent) Checks.checkNotNull(intent, "intent can't be null")).cloneFilter();
        this.serviceBound = bindServiceAndWait(intent, null, 1);
        return this.binder;
    }

    public IBinder bindService(@NonNull Intent intent, @NonNull ServiceConnection serviceConnection, int i) throws TimeoutException {
        this.serviceIntent = ((Intent) Checks.checkNotNull(intent, "intent can't be null")).cloneFilter();
        this.serviceBound = bindServiceAndWait(this.serviceIntent, (ServiceConnection) Checks.checkNotNull(serviceConnection, "connection can't be null"), i);
        return this.binder;
    }

    boolean bindServiceAndWait(Intent intent, ServiceConnection serviceConnection, int i) throws TimeoutException {
        ProxyServiceConnection proxyServiceConnection = new ProxyServiceConnection(serviceConnection);
        boolean zBindService = InstrumentationRegistry.getInstrumentation().getTargetContext().bindService(intent, proxyServiceConnection, i);
        if (zBindService) {
            waitOnLatch(proxyServiceConnection.connectedLatch, "connected");
            this.serviceConn = proxyServiceConnection;
        } else {
            Log.e("ServiceTestRule", "Failed to bind to service! Is your service declared in the manifest?");
        }
        return zBindService;
    }

    public void unbindService() {
        if (this.serviceBound) {
            InstrumentationRegistry.getInstrumentation().getTargetContext().unbindService(this.serviceConn);
            this.binder = null;
            this.serviceBound = false;
        }
    }

    class ProxyServiceConnection implements ServiceConnection {
        private ServiceConnection callerConnection;
        public CountDownLatch connectedLatch;

        private ProxyServiceConnection(ServiceConnection serviceConnection) {
            this.connectedLatch = new CountDownLatch(1);
            this.callerConnection = serviceConnection;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ServiceTestRule.this.binder = iBinder;
            ServiceConnection serviceConnection = this.callerConnection;
            if (serviceConnection != null) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.connectedLatch.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e("ServiceTestRule", "Connection to the Service has been lost!");
            ServiceTestRule.this.binder = null;
            ServiceConnection serviceConnection = this.callerConnection;
            if (serviceConnection != null) {
                serviceConnection.onServiceDisconnected(componentName);
            }
        }
    }

    private void waitOnLatch(CountDownLatch countDownLatch, String str) throws TimeoutException {
        try {
            if (countDownLatch.await(this.timeout, this.timeUnit)) {
                return;
            }
            long j = this.timeout;
            String strName = this.timeUnit.name();
            StringBuilder sb = new StringBuilder(String.valueOf(strName).length() + 56 + String.valueOf(str).length());
            sb.append("Waited for ");
            sb.append(j);
            sb.append(" ");
            sb.append(strName);
            sb.append(", but service was never ");
            sb.append(str);
            throw new TimeoutException(sb.toString());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            String strValueOf = String.valueOf(str);
            throw new RuntimeException(strValueOf.length() != 0 ? "Interrupted while waiting for service to be ".concat(strValueOf) : new String("Interrupted while waiting for service to be "), e);
        }
    }

    void shutdownService() {
        if (this.serviceStarted) {
            InstrumentationRegistry.getInstrumentation().getTargetContext().stopService(this.serviceIntent);
            this.serviceStarted = false;
        }
        unbindService();
    }

    @Override // org.junit.rules.TestRule
    public Statement apply(Statement statement, Description description) {
        return new ServiceStatement(statement);
    }

    private class ServiceStatement extends Statement {
        private final Statement base;

        public ServiceStatement(Statement statement) {
            this.base = statement;
        }

        @Override // org.junit.runners.model.Statement
        public void evaluate() {
            try {
                ServiceTestRule.this.beforeService();
                this.base.evaluate();
            } finally {
                ServiceTestRule.this.shutdownService();
                ServiceTestRule.this.afterService();
            }
        }
    }
}
