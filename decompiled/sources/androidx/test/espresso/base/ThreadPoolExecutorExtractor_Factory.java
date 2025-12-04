package androidx.test.espresso.base;

import android.os.Looper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ThreadPoolExecutorExtractor_Factory implements Provider<ThreadPoolExecutorExtractor> {
    private final Provider looperProvider;

    public ThreadPoolExecutorExtractor_Factory(Provider<Looper> provider) {
        this.looperProvider = provider;
    }

    public static ThreadPoolExecutorExtractor_Factory create(Provider<Looper> provider) {
        return new ThreadPoolExecutorExtractor_Factory(provider);
    }

    public static ThreadPoolExecutorExtractor newInstance(Looper looper) {
        return new ThreadPoolExecutorExtractor(looper);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // javax.inject.Provider
    public ThreadPoolExecutorExtractor get() {
        return newInstance((Looper) this.looperProvider.get());
    }
}
