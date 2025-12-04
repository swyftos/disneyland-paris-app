package androidx.media3.session;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final /* synthetic */ class MediaLibrarySessionImpl$$ExternalSyntheticLambda3 implements Executor {
    public final /* synthetic */ MediaLibrarySessionImpl f$0;

    public /* synthetic */ MediaLibrarySessionImpl$$ExternalSyntheticLambda3(MediaLibrarySessionImpl mediaLibrarySessionImpl) {
        this.f$0 = mediaLibrarySessionImpl;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f$0.postOrRunOnApplicationHandler(runnable);
    }
}
