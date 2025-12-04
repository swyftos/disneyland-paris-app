package androidx.test.rule;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.internal.runner.junit4.statement.UiThreadStatement;
import androidx.test.internal.util.Checks;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.MonitoringInstrumentation;
import androidx.test.runner.intercepting.SingleActivityFactory;
import androidx.test.runner.lifecycle.ActivityLifecycleCallback;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.Stage;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

@Deprecated
/* loaded from: classes2.dex */
public class ActivityTestRule<T extends Activity> implements TestRule {
    volatile WeakReference activity;
    private final Class activityClass;
    private SingleActivityFactory activityFactory;
    private volatile Instrumentation.ActivityResult activityResult;
    private boolean initialTouchMode;
    private Instrumentation instrumentation;
    private boolean launchActivity;
    private final int launchFlags;
    private final ActivityLifecycleCallback lifecycleCallback;
    private final String targetPackage;

    protected void afterActivityFinished() {
    }

    protected void afterActivityLaunched() {
    }

    protected void beforeActivityLaunched() {
    }

    protected Intent getActivityIntent() {
        return null;
    }

    public ActivityTestRule(Class<T> cls) {
        this(cls, false);
    }

    public ActivityTestRule(Class<T> cls, boolean z) {
        this((Class) cls, z, true);
    }

    public ActivityTestRule(Class<T> cls, boolean z, boolean z2) {
        this(cls, InstrumentationRegistry.getInstrumentation().getTargetContext().getPackageName(), 268435456, z, z2);
    }

    public ActivityTestRule(SingleActivityFactory<T> singleActivityFactory, boolean z, boolean z2) {
        this(singleActivityFactory.getActivityClassToIntercept(), z, z2);
        this.activityFactory = singleActivityFactory;
    }

    public ActivityTestRule(Class<T> cls, @NonNull String str, int i, boolean z, boolean z2) {
        this.lifecycleCallback = new LifecycleCallback();
        this.initialTouchMode = false;
        this.launchActivity = false;
        this.activity = makeWeakReference(null);
        this.instrumentation = InstrumentationRegistry.getInstrumentation();
        this.activityClass = cls;
        this.targetPackage = (String) Checks.checkNotNull(str, "targetPackage cannot be null!");
        this.launchFlags = i;
        this.initialTouchMode = z;
        this.launchActivity = z2;
    }

    public T getActivity() {
        T t = (T) this.activity.get();
        if (t == null) {
            Log.w("ActivityTestRule", "Activity wasn't created yet or already stopped");
        }
        return t;
    }

    @Override // org.junit.rules.TestRule
    public Statement apply(Statement statement, Description description) {
        return new ActivityStatement(statement);
    }

    public T launchActivity(@Nullable Intent intent) {
        this.instrumentation.setInTouchMode(this.initialTouchMode);
        if (intent == null && (intent = getActivityIntent()) == null) {
            Log.w("ActivityTestRule", "getActivityIntent() returned null using default: Intent(Intent.ACTION_MAIN)");
            intent = new Intent("android.intent.action.MAIN");
        }
        if (intent.getComponent() == null) {
            intent.setClassName(this.targetPackage, this.activityClass.getName());
        }
        if (intent.getFlags() == 0) {
            intent.addFlags(this.launchFlags);
        }
        beforeActivityLaunched();
        T t = (T) this.activityClass.cast(this.instrumentation.startActivitySync(intent));
        this.activity = makeWeakReference(t);
        this.instrumentation.waitForIdleSync();
        if (t != null) {
            ActivityLifecycleMonitorRegistry.getInstance().addLifecycleCallback(this.lifecycleCallback);
            afterActivityLaunched();
        } else {
            String str = String.format("Activity %s, failed to launch", intent.getComponent());
            Bundle bundle = new Bundle();
            bundle.putString("stream", str.length() != 0 ? "ActivityTestRule ".concat(str) : new String("ActivityTestRule "));
            this.instrumentation.sendStatus(0, bundle);
            Log.e("ActivityTestRule", str);
        }
        return t;
    }

    public void finishActivity() {
        try {
            if (this.activity.get() != null) {
                callFinishOnMainSync();
            }
        } finally {
            this.activity = makeWeakReference(null);
            afterActivityFinished();
        }
    }

    void callFinishOnMainSync() {
        try {
            final Activity activity = (Activity) this.activity.get();
            runOnUiThread(new Runnable() { // from class: androidx.test.rule.ActivityTestRule.1
                @Override // java.lang.Runnable
                public void run() throws NoSuchFieldException, SecurityException {
                    Checks.checkState(activity != null, "Activity was not launched. If you manually finished it, you must launch it again before finishing it. ");
                    activity.finish();
                    ActivityTestRule.this.setActivityResultForActivity(activity);
                }
            });
            this.instrumentation.waitForIdleSync();
        } catch (Throwable th) {
            Log.e("ActivityTestRule", "Failed to execute activity.finish() on the main thread", th);
            throw new IllegalStateException("Failed to execute activity.finish() on the main thread", th);
        }
    }

    public Instrumentation.ActivityResult getActivityResult() {
        if (this.activityResult == null) {
            final Activity activity = (Activity) this.activity.get();
            Checks.checkNotNull(activity, "Activity wasn't created yet or already destroyed!");
            try {
                runOnUiThread(new Runnable() { // from class: androidx.test.rule.ActivityTestRule.2
                    @Override // java.lang.Runnable
                    public void run() throws NoSuchFieldException, SecurityException {
                        Checks.checkState(activity.isFinishing(), "Activity is not finishing!");
                        ActivityTestRule.this.setActivityResultForActivity(activity);
                    }
                });
            } catch (Throwable th) {
                throw new IllegalStateException(th);
            }
        }
        return this.activityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActivityResultForActivity(Activity activity) throws NoSuchFieldException, SecurityException {
        Checks.checkState(Looper.myLooper() == Looper.getMainLooper(), "Must be called on the main thread!");
        Checks.checkNotNull(activity, "Activity wasn't created yet or already destroyed!");
        try {
            Field declaredField = Activity.class.getDeclaredField("mResultCode");
            declaredField.setAccessible(true);
            Field declaredField2 = Activity.class.getDeclaredField("mResultData");
            declaredField2.setAccessible(true);
            this.activityResult = new Instrumentation.ActivityResult(((Integer) declaredField.get(activity)).intValue(), (Intent) declaredField2.get(activity));
        } catch (IllegalAccessException e) {
            Log.e("ActivityTestRule", "Field mResultCode or mResultData is not accessible", e);
            throw new RuntimeException("Field mResultCode or mResultData is not accessible", e);
        } catch (NoSuchFieldException e2) {
            Log.e("ActivityTestRule", "Looks like the Android Activity class has changed itsprivate fields for mResultCode or mResultData. Time to update the reflection code.", e2);
            throw new RuntimeException("Looks like the Android Activity class has changed itsprivate fields for mResultCode or mResultData. Time to update the reflection code.", e2);
        }
    }

    public void runOnUiThread(Runnable runnable) throws Throwable {
        UiThreadStatement.runOnUiThread(runnable);
    }

    private class ActivityStatement extends Statement {
        private final Statement base;

        public ActivityStatement(Statement statement) {
            this.base = statement;
        }

        @Override // org.junit.runners.model.Statement
        public void evaluate() {
            MonitoringInstrumentation monitoringInstrumentation = ActivityTestRule.this.instrumentation instanceof MonitoringInstrumentation ? (MonitoringInstrumentation) ActivityTestRule.this.instrumentation : null;
            try {
                if (ActivityTestRule.this.activityFactory != null && monitoringInstrumentation != null) {
                    monitoringInstrumentation.interceptActivityUsing(ActivityTestRule.this.activityFactory);
                }
                if (ActivityTestRule.this.launchActivity) {
                    ActivityTestRule activityTestRule = ActivityTestRule.this;
                    activityTestRule.launchActivity(activityTestRule.getActivityIntent());
                }
                this.base.evaluate();
                if (monitoringInstrumentation != null) {
                    monitoringInstrumentation.useDefaultInterceptingActivityFactory();
                }
                if (((Activity) ActivityTestRule.this.activity.get()) != null) {
                    ActivityTestRule.this.finishActivity();
                }
                ActivityTestRule.this.activityResult = null;
                ActivityLifecycleMonitorRegistry.getInstance().removeLifecycleCallback(ActivityTestRule.this.lifecycleCallback);
            } catch (Throwable th) {
                if (monitoringInstrumentation != null) {
                    monitoringInstrumentation.useDefaultInterceptingActivityFactory();
                }
                if (((Activity) ActivityTestRule.this.activity.get()) != null) {
                    ActivityTestRule.this.finishActivity();
                }
                ActivityTestRule.this.activityResult = null;
                ActivityLifecycleMonitorRegistry.getInstance().removeLifecycleCallback(ActivityTestRule.this.lifecycleCallback);
                throw th;
            }
        }
    }

    WeakReference makeWeakReference(Activity activity) {
        return new WeakReference(activity);
    }

    private class LifecycleCallback implements ActivityLifecycleCallback {
        private LifecycleCallback() {
        }

        @Override // androidx.test.runner.lifecycle.ActivityLifecycleCallback
        public void onActivityLifecycleChanged(Activity activity, Stage stage) throws NoSuchFieldException, SecurityException {
            if (ActivityTestRule.this.activityClass.isInstance(activity)) {
                if (Stage.RESUMED == stage) {
                    ActivityTestRule activityTestRule = ActivityTestRule.this;
                    activityTestRule.activity = activityTestRule.makeWeakReference((Activity) activityTestRule.activityClass.cast(activity));
                } else if (Stage.PAUSED == stage && activity.isFinishing() && ActivityTestRule.this.activityResult != null) {
                    ActivityTestRule activityTestRule2 = ActivityTestRule.this;
                    activityTestRule2.setActivityResultForActivity((Activity) activityTestRule2.activityClass.cast(activity));
                }
            }
        }
    }
}
