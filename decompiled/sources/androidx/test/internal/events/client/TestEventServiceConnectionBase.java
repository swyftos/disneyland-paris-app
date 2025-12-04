package androidx.test.internal.events.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.internal.util.Checks;
import com.amazonaws.services.s3.model.InstructionFileId;

/* loaded from: classes2.dex */
public class TestEventServiceConnectionBase<T extends IInterface> implements TestEventServiceConnection {
    private final TestEventClientConnectListener listener;
    private final ServiceFromBinder serviceFromBinder;
    private final String serviceName;
    private final String servicePackageName;

    @Nullable
    public T service = null;
    private final ServiceConnection connection = new ServiceConnection() { // from class: androidx.test.internal.events.client.TestEventServiceConnectionBase.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            TestEventServiceConnectionBase testEventServiceConnectionBase = TestEventServiceConnectionBase.this;
            testEventServiceConnectionBase.service = (T) testEventServiceConnectionBase.serviceFromBinder.asInterface(iBinder);
            String strValueOf = String.valueOf(TestEventServiceConnectionBase.this.serviceName);
            Log.d("ConnectionBase", strValueOf.length() != 0 ? "Connected to ".concat(strValueOf) : new String("Connected to "));
            TestEventServiceConnectionBase.this.listener.onTestEventClientConnect();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            TestEventServiceConnectionBase testEventServiceConnectionBase = TestEventServiceConnectionBase.this;
            testEventServiceConnectionBase.service = null;
            String strValueOf = String.valueOf(testEventServiceConnectionBase.serviceName);
            Log.d("ConnectionBase", strValueOf.length() != 0 ? "Disconnected from ".concat(strValueOf) : new String("Disconnected from "));
        }
    };

    public interface ServiceFromBinder<T extends IInterface> {
        T asInterface(IBinder iBinder);
    }

    public TestEventServiceConnectionBase(@NonNull String str, @NonNull ServiceFromBinder<T> serviceFromBinder, @NonNull TestEventClientConnectListener testEventClientConnectListener) {
        this.serviceName = (String) Checks.checkNotNull(getServiceNameOnly(str), "serviceName cannot be null");
        this.servicePackageName = (String) Checks.checkNotNull(getServicePackage(str), "servicePackageName cannot be null");
        this.listener = (TestEventClientConnectListener) Checks.checkNotNull(testEventClientConnectListener, "listener cannot be null");
        this.serviceFromBinder = (ServiceFromBinder) Checks.checkNotNull(serviceFromBinder, "serviceFromBinder cannot be null");
    }

    @Override // androidx.test.internal.events.client.TestEventServiceConnection
    public void connect(@NonNull Context context) {
        Intent intent = new Intent(this.serviceName);
        intent.setPackage(this.servicePackageName);
        if (context.bindService(intent, this.connection, 1)) {
            return;
        }
        String strValueOf = String.valueOf(this.serviceName);
        throw new IllegalStateException(strValueOf.length() != 0 ? "Cannot connect to ".concat(strValueOf) : new String("Cannot connect to "));
    }

    static String getServiceNameOnly(String str) {
        String[] strArrSplit = str.split("/");
        if (strArrSplit.length == 2) {
            if (!strArrSplit[1].startsWith(InstructionFileId.DOT)) {
                return strArrSplit[1];
            }
            String strValueOf = String.valueOf(strArrSplit[0]);
            String strValueOf2 = String.valueOf(strArrSplit[1]);
            return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
        }
        if (strArrSplit.length == 1) {
            return strArrSplit[0];
        }
        StringBuilder sb = new StringBuilder(str.length() + 22);
        sb.append("Invalid serviceName [");
        sb.append(str);
        sb.append("]");
        throw new IllegalArgumentException(sb.toString());
    }

    static String getServicePackage(String str) {
        String[] strArrSplit = str.split("/");
        if (strArrSplit.length >= 2) {
            return strArrSplit[0];
        }
        return null;
    }
}
