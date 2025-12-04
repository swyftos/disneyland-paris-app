package androidx.test.internal.runner.intercepting;

import android.app.Activity;
import android.content.Intent;
import androidx.test.runner.intercepting.InterceptingActivityFactory;

/* loaded from: classes2.dex */
public final class DefaultInterceptingActivityFactory implements InterceptingActivityFactory {
    @Override // androidx.test.runner.intercepting.InterceptingActivityFactory
    public boolean shouldIntercept(ClassLoader classLoader, String str, Intent intent) {
        return false;
    }

    @Override // androidx.test.runner.intercepting.InterceptingActivityFactory
    public Activity create(ClassLoader classLoader, String str, Intent intent) {
        throw new UnsupportedOperationException();
    }
}
