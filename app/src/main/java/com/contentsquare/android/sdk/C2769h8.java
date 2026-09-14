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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.h8 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2769h8 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2619S3 f2719a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2559M2 f2720b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final ArrayList f2721c;

    /* JADX INFO: renamed from: d */
    public int f2722d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final Logger f2723e;

    @RequiresApi(api = 26)
    public C2769h8(@NotNull C2619S3 pixelCopyInstantiable, @NotNull C2559M2 liveActivityProvider) {
        Intrinsics.checkNotNullParameter(pixelCopyInstantiable, "pixelCopyInstantiable");
        Intrinsics.checkNotNullParameter(liveActivityProvider, "liveActivityProvider");
        this.f2719a = pixelCopyInstantiable;
        this.f2720b = liveActivityProvider;
        this.f2721c = new ArrayList();
        this.f2723e = new Logger("ViewBitmapProviderPixelCopy");
    }

    @RequiresApi(api = 26)
    /* JADX INFO: renamed from: a */
    public final void m1153a(final C2779i8 c2779i8, final SurfaceView surfaceView) {
        this.f2723e.m827d("Start capturing SurfaceView: " + surfaceView);
        final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(\n          …onfig.ARGB_8888\n        )");
        this.f2722d++;
        C2619S3 c2619s3 = this.f2719a;
        PixelCopy.OnPixelCopyFinishedListener onPixelCopyFinishedListener = new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.contentsquare.android.sdk.h8$$ExternalSyntheticLambda0
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public final void onPixelCopyFinished(int i) {
                C2769h8.m1150a(this.f$0, surfaceView, bitmapCreateBitmap, c2779i8, i);
            }
        };
        Handler handler = surfaceView.getHandler();
        c2619s3.getClass();
        C2619S3.m1027a(surfaceView, bitmapCreateBitmap, onPixelCopyFinishedListener, handler);
    }

    /* JADX INFO: renamed from: a */
    public static final void m1150a(C2769h8 this$0, SurfaceView surfaceView, Bitmap currentBitmap, C2779i8 viewBitmapProviderListener, int i) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(surfaceView, "$surfaceView");
        Intrinsics.checkNotNullParameter(currentBitmap, "$currentBitmap");
        Intrinsics.checkNotNullParameter(viewBitmapProviderListener, "$viewBitmapProviderListener");
        if (i == 0) {
            this$0.f2723e.m827d("Successful captured SurfaceView: " + surfaceView);
            int[] iArr = new int[2];
            surfaceView.getLocationInWindow(iArr);
            this$0.f2721c.add(new Pair(currentBitmap, iArr));
        } else {
            Logger logger = this$0.f2723e;
            if (i == 2) {
                str = "Error timeout";
            } else if (i == 3) {
                str = "Error source no data";
            } else if (i != 4) {
                str = i != 5 ? "Error Unknown" : "Error destination invalid";
            } else {
                str = "Error source invalid";
            }
            logger.m834w("Child SurfaceView capture failed: ".concat(str));
            this$0.f2722d--;
        }
        if (this$0.f2721c.size() == this$0.f2722d) {
            m1151a(this$0.f2721c, viewBitmapProviderListener);
        }
    }

    @RequiresApi(api = 26)
    @Nullable
    /* JADX INFO: renamed from: a */
    public final Object m1152a(@NotNull ContinuationImpl continuationImpl) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuationImpl));
        C2779i8 viewBitmapProviderListener = new C2779i8(safeContinuation);
        Intrinsics.checkNotNullParameter(viewBitmapProviderListener, "viewBitmapProviderListener");
        Activity activity = this.f2720b.f1856a.get();
        Window window = activity != null ? activity.getWindow() : null;
        Pair pair = window != null ? new Pair(window, window.getDecorView()) : null;
        if ((pair != null ? (Window) pair.getFirst() : null) == null || pair.getSecond() == null) {
            viewBitmapProviderListener.m1158a("window or decorView is null");
        } else {
            Intrinsics.checkNotNull(pair, "null cannot be cast to non-null type kotlin.Pair<android.view.Window, android.view.View>");
            m1154a(viewBitmapProviderListener, pair);
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuationImpl);
        }
        return orThrow;
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.h8$a */
    public static class a implements InterfaceC2749f8 {

        /* JADX INFO: renamed from: d */
        @NotNull
        public static final Bitmap f2724d;

        /* JADX INFO: renamed from: a */
        @NotNull
        public final Bitmap f2725a;

        /* JADX INFO: renamed from: b */
        public final boolean f2726b;

        /* JADX INFO: renamed from: c */
        @NotNull
        public final C2865r4 f2727c;

        /* JADX INFO: renamed from: com.contentsquare.android.sdk.h8$a$a, reason: collision with other inner class name */
        public static final class C8143a {
        }

        static {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
            f2724d = bitmapCreateBitmap;
        }

        public a(@NotNull Bitmap bitmap, boolean z) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            this.f2725a = bitmap;
            this.f2726b = z;
            this.f2727c = new C2865r4();
        }

        @Override // com.contentsquare.android.sdk.InterfaceC2749f8
        @NotNull
        /* JADX INFO: renamed from: a */
        public String mo1134a(int i, int i2, int i3, int i4) {
            Bitmap bitmapCreateBitmap;
            C2865r4 c2865r4 = this.f2727c;
            int width = this.f2725a.getWidth();
            int height = this.f2725a.getHeight();
            c2865r4.getClass();
            boolean z = i + i3 > 0 && i2 + i4 > 0 && i < width && i2 < height;
            this.f2727c.getClass();
            if (i3 <= 0 || i4 <= 0 || !z) {
                Bitmap bitmap = f2724d;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "getByteArrayOutputStream…ULT_BITMAP).toByteArray()");
                return C2711c0.m1100a(byteArray);
            }
            C2865r4.a aVarM1196a = this.f2727c.m1196a(i, i2, i3, i4, 0, 0, this.f2725a.getWidth(), this.f2725a.getHeight());
            Intrinsics.checkNotNullExpressionValue(aVarM1196a, "rectangleMaths\n         ….height\n                )");
            if (aVarM1196a.f3078b == BitmapDescriptorFactory.HUE_RED) {
                bitmapCreateBitmap = Bitmap.createBitmap(this.f2725a, i, i2, i3, i4);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "{\n                Bitmap…th, height)\n            }");
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap2, "createBitmap(\n          …GB_8888\n                )");
                Bitmap bitmap2 = this.f2725a;
                Rect rect = aVarM1196a.f3077a;
                Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(bitmap2, rect.left, rect.top, rect.width(), aVarM1196a.f3077a.height());
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap3, "createBitmap(\n          …t()\n                    )");
                C2865r4 c2865r5 = this.f2727c;
                Rect rect2 = aVarM1196a.f3077a;
                int i5 = rect2.left;
                int i6 = rect2.top;
                Point point = c2865r5.f3076b;
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
            return C2711c0.m1100a(byteArray2);
        }

        @Override // com.contentsquare.android.sdk.InterfaceC2749f8
        @NotNull
        /* JADX INFO: renamed from: b */
        public final String mo1137b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            return mo1134a(iArr[0], iArr[1], view.getWidth(), view.getHeight());
        }

        @Override // com.contentsquare.android.sdk.InterfaceC2749f8
        @NotNull
        /* JADX INFO: renamed from: a */
        public final String mo1135a(@NotNull ViewGroup root) {
            Intrinsics.checkNotNullParameter(root, "root");
            Bitmap bitmap = this.f2725a;
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

        @Override // com.contentsquare.android.sdk.InterfaceC2749f8
        @NotNull
        /* JADX INFO: renamed from: a */
        public final Bitmap mo1133a(@NotNull View root) {
            Intrinsics.checkNotNullParameter(root, "root");
            return this.f2725a;
        }

        @Override // com.contentsquare.android.sdk.InterfaceC2749f8
        /* JADX INFO: renamed from: a */
        public final boolean mo1136a() {
            return this.f2726b;
        }
    }

    @RequiresApi(api = 26)
    /* JADX INFO: renamed from: a */
    public final void m1154a(final C2779i8 c2779i8, final Pair pair) {
        final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((View) pair.getSecond()).getWidth(), ((View) pair.getSecond()).getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(\n          …onfig.ARGB_8888\n        )");
        this.f2722d++;
        C2619S3 c2619s3 = this.f2719a;
        Window window = (Window) pair.getFirst();
        PixelCopy.OnPixelCopyFinishedListener onPixelCopyFinishedListener = new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.contentsquare.android.sdk.h8$$ExternalSyntheticLambda1
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public final void onPixelCopyFinished(int i) {
                C2769h8.m1149a(this.f$0, bitmapCreateBitmap, pair, c2779i8, i);
            }
        };
        Handler handler = ((View) pair.getSecond()).getHandler();
        c2619s3.getClass();
        C2619S3.m1028a(window, bitmapCreateBitmap, onPixelCopyFinishedListener, handler);
    }

    /* JADX INFO: renamed from: a */
    public static final void m1149a(C2769h8 this$0, Bitmap currentBitmap, Pair windowAndRoot, C2779i8 viewBitmapProviderListener, int i) {
        String str;
        Sequence<View> children;
        Sequence map;
        Sequence sequenceFlattenSequenceOfIterable;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentBitmap, "$currentBitmap");
        Intrinsics.checkNotNullParameter(windowAndRoot, "$windowAndRoot");
        Intrinsics.checkNotNullParameter(viewBitmapProviderListener, "$viewBitmapProviderListener");
        if (i == 0) {
            this$0.f2721c.add(new Pair(currentBitmap, new int[2]));
            View decorView = ((Window) windowAndRoot.getFirst()).getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
            List listEmptyList = null;
            ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
            if (viewGroup != null && (children = ViewGroupKt.getChildren(viewGroup)) != null && (map = SequencesKt.map(children, C2759g8.f2671a)) != null && (sequenceFlattenSequenceOfIterable = SequencesKt.flattenSequenceOfIterable(map)) != null) {
                listEmptyList = SequencesKt.toList(sequenceFlattenSequenceOfIterable);
            }
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            if (listEmptyList.isEmpty()) {
                m1151a(this$0.f2721c, viewBitmapProviderListener);
                return;
            }
            try {
                Iterator it = listEmptyList.iterator();
                while (it.hasNext()) {
                    this$0.m1153a(viewBitmapProviderListener, (SurfaceView) it.next());
                }
                return;
            } catch (IllegalArgumentException e) {
                this$0.f2723e.m830e(e, "Capture surface failed: not attached yet.");
                viewBitmapProviderListener.m1158a("Capture surface failed: not attached yet.");
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
        viewBitmapProviderListener.m1158a("Capture window failed: ".concat(str));
    }

    /* JADX INFO: renamed from: a */
    public static void m1151a(ArrayList arrayList, C2779i8 c2779i8) {
        Bitmap bitmap = (Bitmap) ((Pair) arrayList.get(0)).getFirst();
        int size = arrayList.size();
        for (int i = 1; i < size; i++) {
            ExtensionsKt.drawOnTop(bitmap, (Bitmap) ((Pair) arrayList.get(i)).getFirst(), ((int[]) ((Pair) arrayList.get(i)).getSecond())[0], ((int[]) ((Pair) arrayList.get(i)).getSecond())[1]);
        }
        c2779i8.m1157a(new a(bitmap, true));
    }
}
