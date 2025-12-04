package androidx.test.espresso.base;

import android.content.Context;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DefaultFailureHandler_Factory implements Provider<DefaultFailureHandler> {
    private final Provider appContextProvider;

    public DefaultFailureHandler_Factory(Provider<Context> provider) {
        this.appContextProvider = provider;
    }

    public static DefaultFailureHandler_Factory create(Provider<Context> provider) {
        return new DefaultFailureHandler_Factory(provider);
    }

    public static DefaultFailureHandler newInstance(Context context) {
        return new DefaultFailureHandler(context);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // javax.inject.Provider
    /* renamed from: get */
    public DefaultFailureHandler get2() {
        return newInstance((Context) this.appContextProvider.get2());
    }
}
