package androidx.test.runner.intercepting;

import android.app.Activity;
import android.content.Intent;
import androidx.test.internal.util.Checks;

/* loaded from: classes2.dex */
public abstract class SingleActivityFactory<T extends Activity> implements InterceptingActivityFactory {
    private final Class activityClassToIntercept;

    protected abstract T create(Intent intent);

    public SingleActivityFactory(Class<T> cls) {
        Checks.checkNotNull(cls);
        this.activityClassToIntercept = (Class) Checks.checkNotNull(cls);
    }

    @Override // androidx.test.runner.intercepting.InterceptingActivityFactory
    public final boolean shouldIntercept(ClassLoader classLoader, String str, Intent intent) {
        return this.activityClassToIntercept.getName().equals(str);
    }

    @Override // androidx.test.runner.intercepting.InterceptingActivityFactory
    public final Activity create(ClassLoader classLoader, String str, Intent intent) {
        if (!shouldIntercept(classLoader, str, intent)) {
            throw new UnsupportedOperationException(String.format("Can't create instance of %s", str));
        }
        return create(intent);
    }

    public final Class<T> getActivityClassToIntercept() {
        return this.activityClassToIntercept;
    }
}
