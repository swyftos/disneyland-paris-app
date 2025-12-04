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
import com.contentsquare.android.sdk.T4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class T4 {

    @SuppressLint({"NewApi"})
    @NotNull
    public final b a;

    public static final class a implements b {
        @Override // com.contentsquare.android.sdk.T4.b
        @UiThread
        @NotNull
        public final C0622a1<d> a(@NotNull Window window, float f) {
            Intrinsics.checkNotNullParameter(window, "window");
            d dVar = new d();
            C0622a1<d> c0622a1 = new C0622a1<>();
            Intrinsics.checkNotNullParameter(window, "window");
            dVar.c = window.getContext().getResources().getDisplayMetrics().density * f;
            Intrinsics.checkNotNullExpressionValue(window.getDecorView(), "window.decorView");
            dVar.a.a(MathKt.roundToInt(r4.getWidth() / dVar.c), MathKt.roundToInt(r4.getHeight() / dVar.c));
            View view = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(view, "window.decorView");
            if (ViewCompat.isLaidOut(view)) {
                Intrinsics.checkNotNullParameter(view, "view");
                J4 j4 = dVar.a;
                float f2 = dVar.c;
                j4.getClass();
                Intrinsics.checkNotNullParameter(view, "view");
                float f3 = 1.0f / f2;
                Canvas canvas = j4.b;
                canvas.save();
                canvas.translate(view.getScrollX(), view.getScrollY());
                canvas.scale(f3, f3);
                view.draw(canvas);
                canvas.restore();
                c0622a1.a((C0622a1<d>) dVar);
            } else {
                c0622a1.a("CanvasCapturer: root view is not laid out yet.");
            }
            return c0622a1;
        }
    }

    public interface b {
        @UiThread
        @NotNull
        C0622a1<d> a(@NotNull Window window, float f);
    }

    public static final class d {

        @NotNull
        public final J4 a = new J4(1, 1);

        @NotNull
        public final J4 b = new J4(1, 1);
        public float c;

        @UiThread
        public d() {
        }
    }

    public T4() {
        S3 pixelCopyInstantiable = new S3();
        Intrinsics.checkNotNullParameter(pixelCopyInstantiable, "pixelCopyInstantiable");
        this.a = new c(pixelCopyInstantiable);
    }

    @RequiresApi(api = 26)
    public static final class c implements b {

        @NotNull
        public final S3 a;

        public c(@NotNull S3 pixelCopyInstantiable) {
            Intrinsics.checkNotNullParameter(pixelCopyInstantiable, "pixelCopyInstantiable");
            this.a = pixelCopyInstantiable;
        }

        @Override // com.contentsquare.android.sdk.T4.b
        @UiThread
        @NotNull
        public final C0622a1<d> a(@NotNull Window window, float f) {
            Intrinsics.checkNotNullParameter(window, "window");
            final d dVar = new d();
            final C0622a1<d> c0622a1 = new C0622a1<>();
            Intrinsics.checkNotNullParameter(window, "window");
            dVar.c = window.getContext().getResources().getDisplayMetrics().density * f;
            Intrinsics.checkNotNullExpressionValue(window.getDecorView(), "window.decorView");
            dVar.a.a(MathKt.roundToInt(r7.getWidth() / dVar.c), MathKt.roundToInt(r7.getHeight() / dVar.c));
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
            try {
                S3 s3 = this.a;
                Bitmap bitmap = dVar.a.c;
                PixelCopy.OnPixelCopyFinishedListener onPixelCopyFinishedListener = new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.contentsquare.android.sdk.T4$c$$ExternalSyntheticLambda0
                    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                    public final void onPixelCopyFinished(int i) {
                        T4.c.a(c0622a1, dVar, i);
                    }
                };
                Handler handler = decorView.getHandler();
                s3.getClass();
                S3.a(window, bitmap, onPixelCopyFinishedListener, handler);
            } catch (IllegalArgumentException e) {
                c0622a1.a("PixelCopy capture failed: window is not drawn yet. " + e);
            }
            return c0622a1;
        }

        public static final void a(C0622a1 screenCaptureDeferredResult, d screenCaptureResult, int i) {
            Intrinsics.checkNotNullParameter(screenCaptureDeferredResult, "$screenCaptureDeferredResult");
            Intrinsics.checkNotNullParameter(screenCaptureResult, "$screenCaptureResult");
            if (i == 0) {
                screenCaptureDeferredResult.a((C0622a1) screenCaptureResult);
                return;
            }
            screenCaptureDeferredResult.a("PixelCopy capture failed: error " + i);
        }
    }
}
