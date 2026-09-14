package com.contentsquare.android.sdk;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import androidx.annotation.RequiresApi;
import androidx.annotation.UiThread;
import androidx.core.view.ViewCompat;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.T4 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2630T4 {

    /* JADX INFO: renamed from: a */
    @SuppressLint({"NewApi"})
    @NotNull
    public final b f2147a;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.T4$a */
    public static final class a implements b {
        @Override // com.contentsquare.android.sdk.C2630T4.b
        @UiThread
        @NotNull
        /* JADX INFO: renamed from: a */
        public final C2692a1<d> mo1033a(@NotNull Window window, float f) {
            Intrinsics.checkNotNullParameter(window, "window");
            d dVar = new d();
            C2692a1<d> c2692a1 = new C2692a1<>();
            Intrinsics.checkNotNullParameter(window, "window");
            dVar.f2151c = window.getContext().getResources().getDisplayMetrics().density * f;
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
            dVar.f2149a.m956a(MathKt.roundToInt(decorView.getWidth() / dVar.f2151c), MathKt.roundToInt(decorView.getHeight() / dVar.f2151c));
            View view = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(view, "window.decorView");
            if (ViewCompat.isLaidOut(view)) {
                Intrinsics.checkNotNullParameter(view, "view");
                C2531J4 c2531j4 = dVar.f2149a;
                float f2 = dVar.f2151c;
                c2531j4.getClass();
                Intrinsics.checkNotNullParameter(view, "view");
                float f3 = 1.0f / f2;
                Canvas canvas = c2531j4.f1745b;
                canvas.save();
                canvas.translate(view.getScrollX(), view.getScrollY());
                canvas.scale(f3, f3);
                view.draw(canvas);
                canvas.restore();
                c2692a1.m1082a(dVar);
            } else {
                c2692a1.m1083a("CanvasCapturer: root view is not laid out yet.");
            }
            return c2692a1;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.T4$b */
    public interface b {
        @UiThread
        @NotNull
        /* JADX INFO: renamed from: a */
        C2692a1<d> mo1033a(@NotNull Window window, float f);
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.T4$d */
    public static final class d {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final C2531J4 f2149a = new C2531J4(1, 1);

        /* JADX INFO: renamed from: b */
        @NotNull
        public final C2531J4 f2150b = new C2531J4(1, 1);

        /* JADX INFO: renamed from: c */
        public float f2151c;

        @UiThread
        public d() {
        }
    }

    public C2630T4() {
        C2619S3 pixelCopyInstantiable = new C2619S3();
        Intrinsics.checkNotNullParameter(pixelCopyInstantiable, "pixelCopyInstantiable");
        this.f2147a = new c(pixelCopyInstantiable);
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.T4$c */
    @RequiresApi(api = 26)
    public static final class c implements b {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final C2619S3 f2148a;

        public c(@NotNull C2619S3 pixelCopyInstantiable) {
            Intrinsics.checkNotNullParameter(pixelCopyInstantiable, "pixelCopyInstantiable");
            this.f2148a = pixelCopyInstantiable;
        }

        @Override // com.contentsquare.android.sdk.C2630T4.b
        @UiThread
        @NotNull
        /* JADX INFO: renamed from: a */
        public final C2692a1<d> mo1033a(@NotNull Window window, float f) {
            Intrinsics.checkNotNullParameter(window, "window");
            final d dVar = new d();
            final C2692a1<d> c2692a1 = new C2692a1<>();
            Intrinsics.checkNotNullParameter(window, "window");
            dVar.f2151c = window.getContext().getResources().getDisplayMetrics().density * f;
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
            dVar.f2149a.m956a(MathKt.roundToInt(decorView.getWidth() / dVar.f2151c), MathKt.roundToInt(decorView.getHeight() / dVar.f2151c));
            View decorView2 = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView2, "window.decorView");
            try {
                C2619S3 c2619s3 = this.f2148a;
                Bitmap bitmap = dVar.f2149a.f1746c;
                PixelCopy.OnPixelCopyFinishedListener onPixelCopyFinishedListener = new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.contentsquare.android.sdk.T4$c$$ExternalSyntheticLambda0
                    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                    public final void onPixelCopyFinished(int i) {
                        C2630T4.c.m1034a(c2692a1, dVar, i);
                    }
                };
                Handler handler = decorView2.getHandler();
                c2619s3.getClass();
                C2619S3.m1028a(window, bitmap, onPixelCopyFinishedListener, handler);
            } catch (IllegalArgumentException e) {
                c2692a1.m1083a("PixelCopy capture failed: window is not drawn yet. " + e);
            }
            return c2692a1;
        }

        /* JADX INFO: renamed from: a */
        public static final void m1034a(C2692a1 screenCaptureDeferredResult, d screenCaptureResult, int i) {
            Intrinsics.checkNotNullParameter(screenCaptureDeferredResult, "$screenCaptureDeferredResult");
            Intrinsics.checkNotNullParameter(screenCaptureResult, "$screenCaptureResult");
            if (i == 0) {
                screenCaptureDeferredResult.m1082a(screenCaptureResult);
                return;
            }
            screenCaptureDeferredResult.m1083a("PixelCopy capture failed: error " + i);
        }
    }
}
