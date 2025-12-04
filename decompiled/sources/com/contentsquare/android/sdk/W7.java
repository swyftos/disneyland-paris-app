package com.contentsquare.android.sdk;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.api.bridge.flutter.ExternalViewGraphListener;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.AbstractC0657d6;
import com.contentsquare.android.sdk.C0699h8;
import com.contentsquare.android.sdk.K1;
import com.contentsquare.android.sdk.Z4;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;

@SourceDebugExtension({"SMAP\nVerticalComposeScrollRecorder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerticalComposeScrollRecorder.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/VerticalComposeScrollRecorder\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,277:1\n215#2,2:278\n1#3:280\n1#3:291\n1603#4,9:281\n1855#4:290\n1856#4:292\n1612#4:293\n*S KotlinDebug\n*F\n+ 1 VerticalComposeScrollRecorder.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/VerticalComposeScrollRecorder\n*L\n114#1:278,2\n248#1:291\n248#1:281,9\n248#1:290\n248#1:292\n248#1:293\n*E\n"})
/* loaded from: classes2.dex */
public final class W7 extends AbstractC0626a5<AbstractC0657d6.b> {

    @NotNull
    public final K1 e;

    @NotNull
    public final H7 f;

    @NotNull
    public final C0669e8 g;

    @NotNull
    public final N0 h;

    @NotNull
    public final C0830v0 i;

    @NotNull
    public final C0726k5 j;

    @NotNull
    public final P4<J> k;

    @NotNull
    public final Logger l;

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.screencapture.screenrecorder.VerticalComposeScrollRecorder", f = "VerticalComposeScrollRecorder.kt", i = {0, 0, 0}, l = {64}, m = "runRecorder", n = {"this", "context", "root"}, s = {"L$0", "L$1", "L$2"})
    public static final class a extends ContinuationImpl {
        public W7 a;
        public AbstractC0657d6.b b;
        public ViewGroup c;
        public /* synthetic */ Object d;
        public int f;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return W7.this.a((AbstractC0657d6.b) null, (Continuation<? super Unit>) this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W7(@NotNull MutableStateFlow snapshotStateFlow, @NotNull K1 externalViewsProcessor, @NotNull H7 treeTraverser, @NotNull C0669e8 viewBitmapProviderFactory, @NotNull Z0 callback, @NotNull InterfaceC0832v2 glassPane, @NotNull C0830v0 composeJsonViewProcessor, @NotNull C0726k5 screenWiseGraphHelper, @NotNull Z7 screenAppendStrategy) {
        super(snapshotStateFlow, glassPane);
        Intrinsics.checkNotNullParameter(snapshotStateFlow, "snapshotStateFlow");
        Intrinsics.checkNotNullParameter(externalViewsProcessor, "externalViewsProcessor");
        Intrinsics.checkNotNullParameter(treeTraverser, "treeTraverser");
        Intrinsics.checkNotNullParameter(viewBitmapProviderFactory, "viewBitmapProviderFactory");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(glassPane, "glassPane");
        Intrinsics.checkNotNullParameter(composeJsonViewProcessor, "composeJsonViewProcessor");
        Intrinsics.checkNotNullParameter(screenWiseGraphHelper, "screenWiseGraphHelper");
        Intrinsics.checkNotNullParameter(screenAppendStrategy, "screenAppendStrategy");
        this.e = externalViewsProcessor;
        this.f = treeTraverser;
        this.g = viewBitmapProviderFactory;
        this.h = callback;
        this.i = composeJsonViewProcessor;
        this.j = screenWiseGraphHelper;
        this.k = screenAppendStrategy;
        this.l = new Logger("VerticalComposeScrollRecorder");
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    public final void a(AbstractC0657d6 abstractC0657d6) {
        AbstractC0657d6.b context = (AbstractC0657d6.b) abstractC0657d6;
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual(this.c, context.a)) {
            return;
        }
        this.d = null;
        this.c = context.a;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    public final boolean b(AbstractC0657d6 abstractC0657d6) {
        AbstractC0657d6.b context = (AbstractC0657d6.b) abstractC0657d6;
        Intrinsics.checkNotNullParameter(context, "context");
        return context.b == 0;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    public final void e() {
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    public final /* bridge */ /* synthetic */ Object b(AbstractC0657d6 abstractC0657d6, Continuation continuation) {
        return a((AbstractC0657d6.b) abstractC0657d6, (Continuation<? super Unit>) continuation);
    }

    public static G2 a(List list, String str) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                G2 g2A = (G2) it.next();
                if (!Intrinsics.areEqual(g2A.a, str)) {
                    g2A = a(g2A.c, str);
                }
                if (g2A != null) {
                    return g2A;
                }
            }
        }
        return null;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    @NotNull
    public final Logger a() {
        return this.l;
    }

    @VisibleForTesting
    @Nullable
    public static G2 a(@NotNull ArrayList androidComposeViewJsonList, @NotNull AbstractC0657d6.b context) {
        Intrinsics.checkNotNullParameter(androidComposeViewJsonList, "androidComposeViewJsonList");
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        Iterator it = androidComposeViewJsonList.iterator();
        while (it.hasNext()) {
            List<G2> list = ((G2) it.next()).c;
            G2 g2 = list != null ? list.get(0) : null;
            if (g2 != null) {
                arrayList.add(g2);
            }
        }
        return a(arrayList, context.c.getContainerId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @VisibleForTesting
    public final void a(@NotNull ViewGroup root, @Nullable String screenUrl, @NotNull AbstractC0657d6.b context, @NotNull InterfaceC0679f8 result) throws JSONException {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(result, "result");
        Bitmap bitmap = this.d;
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(result, "result");
        Bitmap bitmapA = result.a((View) root);
        if (context.c.getNumberOfPages() != 1) {
            bitmapA = this.k.a(bitmap, bitmapA, new J(context.c.getScrollabeRect(), context.c.getInitialOffset(), context.c.getNumberOfPages(), context.b == 0, context.c.getNumberOfPages() == context.b + 1));
        }
        this.d = bitmapA;
        if (context.c.getNumberOfPages() == context.b + 1) {
            if (screenUrl == null) {
                throw new IllegalStateException("Screen url is null!");
            }
            Intrinsics.checkNotNullParameter(root, "root");
            Intrinsics.checkNotNullParameter(screenUrl, "screenUrl");
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(context, "context");
            ArrayList arrayList = new ArrayList();
            U7 u7 = new U7(arrayList);
            String strC = c();
            U4 screenGraph = this.f.a(root, ((C0723k2) this.b).f, this.e, result, new W4(root, false), this.i, u7);
            screenGraph.a = screenUrl;
            Intrinsics.checkNotNullParameter(strC, "<set-?>");
            screenGraph.b = strC;
            G2 g2A = a(arrayList, context);
            K1 k1 = this.e;
            k1.getClass();
            LinkedHashMap externalJsonViewsMap = new LinkedHashMap();
            externalJsonViewsMap.putAll(k1.e);
            for (Map.Entry<View, K1.b> entry : k1.f.entrySet()) {
                View key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                externalJsonViewsMap.put(key, entry.getValue().a);
            }
            Intrinsics.checkNotNullParameter(screenGraph, "screenGraph");
            Intrinsics.checkNotNullParameter(externalJsonViewsMap, "externalJsonViewsMap");
            Bitmap bitmap2 = this.d;
            if (bitmap2 == null) {
                throw new IllegalStateException("Merged screenshot is null!");
            }
            C0699h8.a resultFullScreen = new C0699h8.a(bitmap2, true);
            Intrinsics.checkNotNullParameter(root, "root");
            Intrinsics.checkNotNullParameter(screenUrl, "screenUrl");
            Intrinsics.checkNotNullParameter(resultFullScreen, "resultFullScreen");
            Intrinsics.checkNotNullParameter(context, "context");
            ArrayList arrayList2 = new ArrayList();
            V7 v7 = new V7(arrayList2);
            String strC2 = c();
            U4 u4A = this.f.a(root, ((C0723k2) this.b).f, this.e, resultFullScreen, new W4(root, false), this.i, v7);
            u4A.a = screenUrl;
            Intrinsics.checkNotNullParameter(strC2, "<set-?>");
            u4A.b = strC2;
            G2 g2A2 = a(arrayList2, context);
            for (Map.Entry entry2 : externalJsonViewsMap.entrySet()) {
                K1 k12 = this.e;
                View view = (View) entry2.getKey();
                G2 jsonView = (G2) entry2.getValue();
                k12.getClass();
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(jsonView, "jsonView");
                if (view instanceof WebView) {
                    k12.e.put(view, jsonView);
                } else {
                    ExternalViewGraphListener externalViewGraphListener = K1.g.get(view);
                    if (externalViewGraphListener != null) {
                        k12.f.put(view, new K1.b(jsonView, externalViewGraphListener));
                    }
                }
            }
            if (g2A == null) {
                a(screenGraph, bitmap2);
                return;
            }
            if (this.d == null || g2A2 == null) {
                throw new IllegalStateException("Invalid snapshot");
            }
            C0726k5 c0726k5 = this.j;
            J j = new J(context.c.getScrollabeRect(), context.c.getInitialOffset(), context.c.getNumberOfPages(), context.b == 0, context.c.getNumberOfPages() == context.b + 1);
            Rect rect = new Rect();
            root.getGlobalVisibleRect(rect);
            Unit unit = Unit.INSTANCE;
            c0726k5.a(j, rect, bitmap2, g2A2);
            g2A.c = g2A2.c;
            a(screenGraph, bitmap2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull com.contentsquare.android.sdk.AbstractC0657d6.b r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.contentsquare.android.sdk.W7.a
            if (r0 == 0) goto L13
            r0 = r9
            com.contentsquare.android.sdk.W7$a r0 = (com.contentsquare.android.sdk.W7.a) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.W7$a r0 = new com.contentsquare.android.sdk.W7$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            android.view.ViewGroup r7 = r0.c
            com.contentsquare.android.sdk.d6$b r8 = r0.b
            com.contentsquare.android.sdk.W7 r0 = r0.a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L61
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            kotlin.ResultKt.throwOnFailure(r9)
            android.view.ViewGroup r9 = r7.b()
            if (r9 == 0) goto L7b
            com.contentsquare.android.sdk.e8 r2 = r7.g
            com.contentsquare.android.sdk.h8 r4 = new com.contentsquare.android.sdk.h8
            com.contentsquare.android.sdk.S3 r5 = new com.contentsquare.android.sdk.S3
            r5.<init>()
            com.contentsquare.android.sdk.M2 r2 = r2.a
            r4.<init>(r5, r2)
            r0.a = r7
            r0.b = r8
            r0.c = r9
            r0.f = r3
            java.lang.Object r0 = r4.a(r0)
            if (r0 != r1) goto L5d
            return r1
        L5d:
            r6 = r0
            r0 = r7
            r7 = r9
            r9 = r6
        L61:
            com.contentsquare.android.sdk.f8 r9 = (com.contentsquare.android.sdk.InterfaceC0679f8) r9
            java.lang.String r1 = r0.d()     // Catch: java.lang.Throwable -> L72
            r0.a(r7, r1, r8, r9)     // Catch: java.lang.Throwable -> L72
            android.graphics.Bitmap r7 = r9.a(r7)
            r7.recycle()
            goto L7b
        L72:
            r8 = move-exception
            android.graphics.Bitmap r7 = r9.a(r7)
            r7.recycle()
            throw r8
        L7b:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.W7.a(com.contentsquare.android.sdk.d6$b, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void a(U4 u4, Bitmap bitmap) {
        String strEncodeToString = "";
        if (this.e.b()) {
            C0699h8.a aVar = new C0699h8.a(bitmap, false);
            K1 k1 = this.e;
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            if (bitmap.getHeight() > 0 && bitmap.getWidth() > 0) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] imageByteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.checkNotNullExpressionValue(imageByteArray, "stream.toByteArray()");
                Intrinsics.checkNotNullParameter(imageByteArray, "imageByteArray");
                strEncodeToString = Base64.encodeToString(imageByteArray, 2);
                Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(imageByteArray, Base64.NO_WRAP)");
            }
            k1.a(u4, strEncodeToString, aVar, this.h, this.a);
            return;
        }
        this.a.tryEmit(Z4.g.a);
        N0 n0 = this.h;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (bitmap.getHeight() > 0 && bitmap.getWidth() > 0) {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
            byte[] imageByteArray2 = byteArrayOutputStream2.toByteArray();
            Intrinsics.checkNotNullExpressionValue(imageByteArray2, "stream.toByteArray()");
            Intrinsics.checkNotNullParameter(imageByteArray2, "imageByteArray");
            strEncodeToString = Base64.encodeToString(imageByteArray2, 2);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(imageByteArray, Base64.NO_WRAP)");
        }
        n0.a(u4, strEncodeToString, false);
    }
}
