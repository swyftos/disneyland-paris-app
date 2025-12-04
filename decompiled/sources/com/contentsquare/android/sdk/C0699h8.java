package com.contentsquare.android.sdk;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Base64;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewGroupKt;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.ExtensionsKt;
import com.contentsquare.android.sdk.C0794r4;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.h8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0699h8 {

    @NotNull
    public final S3 a;

    @NotNull
    public final M2 b;

    @NotNull
    public final ArrayList c;
    public int d;

    @NotNull
    public final Logger e;

    @RequiresApi(api = 26)
    public C0699h8(@NotNull S3 pixelCopyInstantiable, @NotNull M2 liveActivityProvider) {
        Intrinsics.checkNotNullParameter(pixelCopyInstantiable, "pixelCopyInstantiable");
        Intrinsics.checkNotNullParameter(liveActivityProvider, "liveActivityProvider");
        this.a = pixelCopyInstantiable;
        this.b = liveActivityProvider;
        this.c = new ArrayList();
        this.e = new Logger("ViewBitmapProviderPixelCopy");
    }

    @RequiresApi(api = 26)
    public final void a(final C0709i8 c0709i8, final SurfaceView surfaceView) {
        this.e.d("Start capturing SurfaceView: " + surfaceView);
        final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(\n          …onfig.ARGB_8888\n        )");
        this.d++;
        S3 s3 = this.a;
        PixelCopy.OnPixelCopyFinishedListener onPixelCopyFinishedListener = new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.contentsquare.android.sdk.h8$$ExternalSyntheticLambda0
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public final void onPixelCopyFinished(int i) {
                C0699h8.a(this.f$0, surfaceView, bitmapCreateBitmap, c0709i8, i);
            }
        };
        Handler handler = surfaceView.getHandler();
        s3.getClass();
        S3.a(surfaceView, bitmapCreateBitmap, onPixelCopyFinishedListener, handler);
    }

    public static final void a(C0699h8 this$0, SurfaceView surfaceView, Bitmap currentBitmap, C0709i8 viewBitmapProviderListener, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(surfaceView, "$surfaceView");
        Intrinsics.checkNotNullParameter(currentBitmap, "$currentBitmap");
        Intrinsics.checkNotNullParameter(viewBitmapProviderListener, "$viewBitmapProviderListener");
        if (i == 0) {
            this$0.e.d("Successful captured SurfaceView: " + surfaceView);
            int[] iArr = new int[2];
            surfaceView.getLocationInWindow(iArr);
            this$0.c.add(new Pair(currentBitmap, iArr));
        } else {
            this$0.e.w("Child SurfaceView capture failed: ".concat(i != 2 ? i != 3 ? i != 4 ? i != 5 ? "Error Unknown" : "Error destination invalid" : "Error source invalid" : "Error source no data" : "Error timeout"));
            this$0.d--;
        }
        if (this$0.c.size() == this$0.d) {
            a(this$0.c, viewBitmapProviderListener);
        }
    }

    @RequiresApi(api = 26)
    @Nullable
    public final Object a(@NotNull ContinuationImpl continuationImpl) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuationImpl));
        C0709i8 viewBitmapProviderListener = new C0709i8(safeContinuation);
        Intrinsics.checkNotNullParameter(viewBitmapProviderListener, "viewBitmapProviderListener");
        Activity activity = this.b.a.get();
        Window window = activity != null ? activity.getWindow() : null;
        Pair pair = window != null ? new Pair(window, window.getDecorView()) : null;
        if ((pair != null ? (Window) pair.getFirst() : null) == null || pair.getSecond() == null) {
            viewBitmapProviderListener.a("window or decorView is null");
        } else {
            Intrinsics.checkNotNull(pair, "null cannot be cast to non-null type kotlin.Pair<android.view.Window, android.view.View>");
            a(viewBitmapProviderListener, pair);
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuationImpl);
        }
        return orThrow;
    }

    /* renamed from: com.contentsquare.android.sdk.h8$a */
    public static class a implements InterfaceC0679f8 {

        @NotNull
        public static final Bitmap d;

        @NotNull
        public final Bitmap a;
        public final boolean b;

        @NotNull
        public final C0794r4 c;

        /* renamed from: com.contentsquare.android.sdk.h8$a$a, reason: collision with other inner class name */
        public static final class C0047a {
        }

        static {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
            d = bitmapCreateBitmap;
        }

        public a(@NotNull Bitmap bitmap, boolean z) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            this.a = bitmap;
            this.b = z;
            this.c = new C0794r4();
        }

        @Override // com.contentsquare.android.sdk.InterfaceC0679f8
        @NotNull
        public String a(int i, int i2, int i3, int i4) {
            Bitmap bitmapCreateBitmap;
            C0794r4 c0794r4 = this.c;
            int width = this.a.getWidth();
            int height = this.a.getHeight();
            c0794r4.getClass();
            boolean z = i + i3 > 0 && i2 + i4 > 0 && i < width && i2 < height;
            this.c.getClass();
            if (i3 <= 0 || i4 <= 0 || !z) {
                Bitmap bitmap = d;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "getByteArrayOutputStream…ULT_BITMAP).toByteArray()");
                return C0641c0.a(byteArray);
            }
            C0794r4.a aVarA = this.c.a(i, i2, i3, i4, 0, 0, this.a.getWidth(), this.a.getHeight());
            Intrinsics.checkNotNullExpressionValue(aVarA, "rectangleMaths\n         ….height\n                )");
            if (aVarA.b == BitmapDescriptorFactory.HUE_RED) {
                bitmapCreateBitmap = Bitmap.createBitmap(this.a, i, i2, i3, i4);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "{\n                Bitmap…th, height)\n            }");
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap2, "createBitmap(\n          …GB_8888\n                )");
                Bitmap bitmap2 = this.a;
                Rect rect = aVarA.a;
                Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(bitmap2, rect.left, rect.top, rect.width(), aVarA.a.height());
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap3, "createBitmap(\n          …t()\n                    )");
                C0794r4 c0794r42 = this.c;
                Rect rect2 = aVarA.a;
                int i5 = rect2.left;
                int i6 = rect2.top;
                Point point = c0794r42.b;
                point.x = i5 - i;
                point.y = i6 - i2;
                Intrinsics.checkNotNullExpressionValue(point, "rectangleMaths.offset(cl…sXOnScreen, posYOnScreen)");
                new Canvas(bitmapCreateBitmap2).drawBitmap(bitmapCreateBitmap3, point.x, point.y, (Paint) null);
                bitmapCreateBitmap = bitmapCreateBitmap2;
            }
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream2);
            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray2, "stream.toByteArray()");
            return C0641c0.a(byteArray2);
        }

        @Override // com.contentsquare.android.sdk.InterfaceC0679f8
        @NotNull
        public final String b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            return a(iArr[0], iArr[1], view.getWidth(), view.getHeight());
        }

        @Override // com.contentsquare.android.sdk.InterfaceC0679f8
        @NotNull
        public final String a(@NotNull ViewGroup root) {
            Intrinsics.checkNotNullParameter(root, "root");
            Bitmap bitmap = this.a;
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            if (bitmap.getHeight() > 0 && bitmap.getWidth() > 0) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] imageByteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.checkNotNullExpressionValue(imageByteArray, "stream.toByteArray()");
                Intrinsics.checkNotNullParameter(imageByteArray, "imageByteArray");
                String strEncodeToString = Base64.encodeToString(imageByteArray, 2);
                Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(imageByteArray, Base64.NO_WRAP)");
                return strEncodeToString;
            }
            return "";
        }

        @Override // com.contentsquare.android.sdk.InterfaceC0679f8
        @NotNull
        public final Bitmap a(@NotNull View root) {
            Intrinsics.checkNotNullParameter(root, "root");
            return this.a;
        }

        @Override // com.contentsquare.android.sdk.InterfaceC0679f8
        public final boolean a() {
            return this.b;
        }
    }

    @RequiresApi(api = 26)
    public final void a(final C0709i8 c0709i8, final Pair pair) {
        final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((View) pair.getSecond()).getWidth(), ((View) pair.getSecond()).getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(\n          …onfig.ARGB_8888\n        )");
        this.d++;
        S3 s3 = this.a;
        Window window = (Window) pair.getFirst();
        PixelCopy.OnPixelCopyFinishedListener onPixelCopyFinishedListener = new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.contentsquare.android.sdk.h8$$ExternalSyntheticLambda1
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public final void onPixelCopyFinished(int i) {
                C0699h8.a(this.f$0, bitmapCreateBitmap, pair, c0709i8, i);
            }
        };
        Handler handler = ((View) pair.getSecond()).getHandler();
        s3.getClass();
        S3.a(window, bitmapCreateBitmap, onPixelCopyFinishedListener, handler);
    }

    public static final void a(C0699h8 this$0, Bitmap currentBitmap, Pair windowAndRoot, C0709i8 viewBitmapProviderListener, int i) {
        String str;
        Sequence<View> children;
        Sequence map;
        Sequence sequenceFlattenSequenceOfIterable;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentBitmap, "$currentBitmap");
        Intrinsics.checkNotNullParameter(windowAndRoot, "$windowAndRoot");
        Intrinsics.checkNotNullParameter(viewBitmapProviderListener, "$viewBitmapProviderListener");
        if (i == 0) {
            this$0.c.add(new Pair(currentBitmap, new int[2]));
            View decorView = ((Window) windowAndRoot.getFirst()).getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
            List listEmptyList = null;
            ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
            if (viewGroup != null && (children = ViewGroupKt.getChildren(viewGroup)) != null && (map = SequencesKt.map(children, C0689g8.a)) != null && (sequenceFlattenSequenceOfIterable = SequencesKt.flattenSequenceOfIterable(map)) != null) {
                listEmptyList = SequencesKt.toList(sequenceFlattenSequenceOfIterable);
            }
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            if (listEmptyList.isEmpty()) {
                a(this$0.c, viewBitmapProviderListener);
                return;
            }
            try {
                Iterator it = listEmptyList.iterator();
                while (it.hasNext()) {
                    this$0.a(viewBitmapProviderListener, (SurfaceView) it.next());
                }
                return;
            } catch (IllegalArgumentException e) {
                this$0.e.e(e, "Capture surface failed: not attached yet.");
                viewBitmapProviderListener.a("Capture surface failed: not attached yet.");
                return;
            }
        }
        this$0.getClass();
        if (i == 2) {
            str = "Error timeout";
        } else if (i == 3) {
            str = "Error source no data";
        } else if (i != 4) {
            str = i != 5 ? "Error Unknown" : "Error destination invalid";
        } else {
            str = "Error source invalid";
        }
        viewBitmapProviderListener.a("Capture window failed: ".concat(str));
    }

    public static void a(ArrayList arrayList, C0709i8 c0709i8) {
        Bitmap bitmap = (Bitmap) ((Pair) arrayList.get(0)).getFirst();
        int size = arrayList.size();
        for (int i = 1; i < size; i++) {
            ExtensionsKt.drawOnTop(bitmap, (Bitmap) ((Pair) arrayList.get(i)).getFirst(), ((int[]) ((Pair) arrayList.get(i)).getSecond())[0], ((int[]) ((Pair) arrayList.get(i)).getSecond())[1]);
        }
        c0709i8.a(new a(bitmap, true));
    }
}
