package androidx.media3.session;

import android.os.Handler;
import android.os.Looper;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaController;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class MediaControllerHolder extends AbstractFuture implements MediaController.ConnectionCallback {
    private boolean accepted;
    private MediaController controller;
    private final Handler handler;

    public MediaControllerHolder(Looper looper) {
        this.handler = new Handler(looper);
    }

    public void setController(final MediaController mediaController) {
        this.controller = mediaController;
        maybeSetFutureResult();
        addListener(new Runnable() { // from class: androidx.media3.session.MediaControllerHolder$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setController$0(mediaController);
            }
        }, new Executor() { // from class: androidx.media3.session.MediaControllerHolder$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                this.f$0.lambda$setController$1(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setController$0(MediaController mediaController) {
        if (isCancelled()) {
            mediaController.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setController$1(Runnable runnable) {
        Util.postOrRun(this.handler, runnable);
    }

    @Override // androidx.media3.session.MediaController.ConnectionCallback
    public void onAccepted() {
        this.accepted = true;
        maybeSetFutureResult();
    }

    @Override // androidx.media3.session.MediaController.ConnectionCallback
    public void onRejected() {
        maybeSetException();
    }

    private void maybeSetFutureResult() {
        MediaController mediaController = this.controller;
        if (mediaController == null || !this.accepted) {
            return;
        }
        set(mediaController);
    }

    private void maybeSetException() {
        setException(new SecurityException("Session rejected the connection request."));
    }
}
