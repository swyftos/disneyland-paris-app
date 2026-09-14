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
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.W7 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nVerticalComposeScrollRecorder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerticalComposeScrollRecorder.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/VerticalComposeScrollRecorder\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,277:1\n215#2,2:278\n1#3:280\n1#3:291\n1603#4,9:281\n1855#4:290\n1856#4:292\n1612#4:293\n*S KotlinDebug\n*F\n+ 1 VerticalComposeScrollRecorder.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/VerticalComposeScrollRecorder\n*L\n114#1:278,2\n248#1:291\n248#1:281,9\n248#1:290\n248#1:292\n248#1:293\n*E\n"})
public final class C2662W7 extends AbstractC2696a5<AbstractC2727d6.b> {

    /* JADX INFO: renamed from: e */
    @NotNull
    public final C2538K1 f2216e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final C2514H7 f2217f;

    /* JADX INFO: renamed from: g */
    @NotNull
    public final C2739e8 f2218g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public final InterfaceC2567N0 f2219h;

    /* JADX INFO: renamed from: i */
    @NotNull
    public final C2901v0 f2220i;

    /* JADX INFO: renamed from: j */
    @NotNull
    public final C2796k5 f2221j;

    /* JADX INFO: renamed from: k */
    @NotNull
    public final InterfaceC2591P4<C2526J> f2222k;

    /* JADX INFO: renamed from: l */
    @NotNull
    public final Logger f2223l;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.W7$a */
    @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.screencapture.screenrecorder.VerticalComposeScrollRecorder", m1845f = "VerticalComposeScrollRecorder.kt", m1846i = {0, 0, 0}, m1847l = {64}, m1848m = "runRecorder", m1849n = {"this", "context", "root"}, m1850s = {"L$0", "L$1", "L$2"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        public C2662W7 f2224a;

        /* JADX INFO: renamed from: b */
        public AbstractC2727d6.b f2225b;

        /* JADX INFO: renamed from: c */
        public ViewGroup f2226c;

        /* JADX INFO: renamed from: d */
        public /* synthetic */ Object f2227d;

        /* JADX INFO: renamed from: f */
        public int f2229f;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f2227d = obj;
            this.f2229f |= Integer.MIN_VALUE;
            return C2662W7.this.m1062a((AbstractC2727d6.b) null, (Continuation<? super Unit>) this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2662W7(@NotNull MutableStateFlow snapshotStateFlow, @NotNull C2538K1 externalViewsProcessor, @NotNull C2514H7 treeTraverser, @NotNull C2739e8 viewBitmapProviderFactory, @NotNull C2682Z0 callback, @NotNull InterfaceC2903v2 glassPane, @NotNull C2901v0 composeJsonViewProcessor, @NotNull C2796k5 screenWiseGraphHelper, @NotNull C2689Z7 screenAppendStrategy) {
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
        this.f2216e = externalViewsProcessor;
        this.f2217f = treeTraverser;
        this.f2218g = viewBitmapProviderFactory;
        this.f2219h = callback;
        this.f2220i = composeJsonViewProcessor;
        this.f2221j = screenWiseGraphHelper;
        this.f2222k = screenAppendStrategy;
        this.f2223l = new Logger("VerticalComposeScrollRecorder");
    }

    @Override // com.contentsquare.android.sdk.AbstractC2696a5
    /* JADX INFO: renamed from: a */
    public final void mo907a(AbstractC2727d6 abstractC2727d6) {
        AbstractC2727d6.b context = (AbstractC2727d6.b) abstractC2727d6;
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual(this.f2371c, context.f2507a)) {
            return;
        }
        this.f2372d = null;
        this.f2371c = context.f2507a;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2696a5
    /* JADX INFO: renamed from: b */
    public final boolean mo909b(AbstractC2727d6 abstractC2727d6) {
        AbstractC2727d6.b context = (AbstractC2727d6.b) abstractC2727d6;
        Intrinsics.checkNotNullParameter(context, "context");
        return context.f2508b == 0;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2696a5
    /* JADX INFO: renamed from: e */
    public final void mo910e() {
    }

    @Override // com.contentsquare.android.sdk.AbstractC2696a5
    /* JADX INFO: renamed from: b */
    public final /* bridge */ /* synthetic */ Object mo908b(AbstractC2727d6 abstractC2727d6, Continuation continuation) {
        return m1062a((AbstractC2727d6.b) abstractC2727d6, (Continuation<? super Unit>) continuation);
    }

    /* JADX INFO: renamed from: a */
    public static C2499G2 m1061a(List list, String str) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C2499G2 c2499g2M1061a = (C2499G2) it.next();
                if (!Intrinsics.areEqual(c2499g2M1061a.f1637a, str)) {
                    c2499g2M1061a = m1061a(c2499g2M1061a.f1639c, str);
                }
                if (c2499g2M1061a != null) {
                    return c2499g2M1061a;
                }
            }
        }
        return null;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2696a5
    @NotNull
    /* JADX INFO: renamed from: a */
    public final Logger mo906a() {
        return this.f2223l;
    }

    @VisibleForTesting
    @Nullable
    /* JADX INFO: renamed from: a */
    public static C2499G2 m1060a(@NotNull ArrayList androidComposeViewJsonList, @NotNull AbstractC2727d6.b context) {
        Intrinsics.checkNotNullParameter(androidComposeViewJsonList, "androidComposeViewJsonList");
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        Iterator it = androidComposeViewJsonList.iterator();
        while (it.hasNext()) {
            List<C2499G2> list = ((C2499G2) it.next()).f1639c;
            C2499G2 c2499g2 = list != null ? list.get(0) : null;
            if (c2499g2 != null) {
                arrayList.add(c2499g2);
            }
        }
        return m1061a(arrayList, context.f2509c.getContainerId());
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: a */
    public final void m1063a(@NotNull ViewGroup root, @Nullable String screenUrl, @NotNull AbstractC2727d6.b context, @NotNull InterfaceC2749f8 result) throws JSONException {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(result, "result");
        Bitmap bitmap = this.f2372d;
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(result, "result");
        Bitmap bitmapMo1133a = result.mo1133a((View) root);
        if (context.f2509c.getNumberOfPages() != 1) {
            bitmapMo1133a = this.f2222k.mo1002a(bitmap, bitmapMo1133a, new C2526J(context.f2509c.getScrollabeRect(), context.f2509c.getInitialOffset(), context.f2509c.getNumberOfPages(), context.f2508b == 0, context.f2509c.getNumberOfPages() == context.f2508b + 1));
        }
        this.f2372d = bitmapMo1133a;
        if (context.f2509c.getNumberOfPages() == context.f2508b + 1) {
            if (screenUrl == null) {
                throw new IllegalStateException("Screen url is null!");
            }
            Intrinsics.checkNotNullParameter(root, "root");
            Intrinsics.checkNotNullParameter(screenUrl, "screenUrl");
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(context, "context");
            ArrayList arrayList = new ArrayList();
            C2643U7 c2643u7 = new C2643U7(arrayList);
            String strM1089c = m1089c();
            C2640U4 screenGraph = this.f2217f.m935a(root, ((C2793k2) this.f2370b).f2811f, this.f2216e, result, new C2659W4(root, false), this.f2220i, c2643u7);
            screenGraph.f2176a = screenUrl;
            Intrinsics.checkNotNullParameter(strM1089c, "<set-?>");
            screenGraph.f2177b = strM1089c;
            C2499G2 c2499g2M1060a = m1060a(arrayList, context);
            C2538K1 c2538k1 = this.f2216e;
            c2538k1.getClass();
            LinkedHashMap externalJsonViewsMap = new LinkedHashMap();
            externalJsonViewsMap.putAll(c2538k1.f1776e);
            for (Map.Entry<View, C2538K1.b> entry : c2538k1.f1777f.entrySet()) {
                View key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                externalJsonViewsMap.put(key, entry.getValue().f1783a);
            }
            Intrinsics.checkNotNullParameter(screenGraph, "screenGraph");
            Intrinsics.checkNotNullParameter(externalJsonViewsMap, "externalJsonViewsMap");
            Bitmap bitmap2 = this.f2372d;
            if (bitmap2 == null) {
                throw new IllegalStateException("Merged screenshot is null!");
            }
            C2769h8.a resultFullScreen = new C2769h8.a(bitmap2, true);
            Intrinsics.checkNotNullParameter(root, "root");
            Intrinsics.checkNotNullParameter(screenUrl, "screenUrl");
            Intrinsics.checkNotNullParameter(resultFullScreen, "resultFullScreen");
            Intrinsics.checkNotNullParameter(context, "context");
            ArrayList arrayList2 = new ArrayList();
            C2653V7 c2653v7 = new C2653V7(arrayList2);
            String strM1089c2 = m1089c();
            C2640U4 c2640u4M935a = this.f2217f.m935a(root, ((C2793k2) this.f2370b).f2811f, this.f2216e, resultFullScreen, new C2659W4(root, false), this.f2220i, c2653v7);
            c2640u4M935a.f2176a = screenUrl;
            Intrinsics.checkNotNullParameter(strM1089c2, "<set-?>");
            c2640u4M935a.f2177b = strM1089c2;
            C2499G2 c2499g2M1060a2 = m1060a(arrayList2, context);
            for (Map.Entry entry2 : externalJsonViewsMap.entrySet()) {
                C2538K1 c2538k2 = this.f2216e;
                View view = (View) entry2.getKey();
                C2499G2 jsonView = (C2499G2) entry2.getValue();
                c2538k2.getClass();
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(jsonView, "jsonView");
                if (view instanceof WebView) {
                    c2538k2.f1776e.put((WebView) view, jsonView);
                } else {
                    ExternalViewGraphListener externalViewGraphListener = C2538K1.f1771g.get(view);
                    if (externalViewGraphListener != null) {
                        c2538k2.f1777f.put(view, new C2538K1.b(jsonView, externalViewGraphListener));
                    }
                }
            }
            if (c2499g2M1060a == null) {
                m1064a(screenGraph, bitmap2);
                return;
            }
            if (this.f2372d == null || c2499g2M1060a2 == null) {
                throw new IllegalStateException("Invalid snapshot");
            }
            C2796k5 c2796k5 = this.f2221j;
            C2526J c2526j = new C2526J(context.f2509c.getScrollabeRect(), context.f2509c.getInitialOffset(), context.f2509c.getNumberOfPages(), context.f2508b == 0, context.f2509c.getNumberOfPages() == context.f2508b + 1);
            Rect rect = new Rect();
            root.getGlobalVisibleRect(rect);
            Unit unit = Unit.INSTANCE;
            c2796k5.m1173a(c2526j, rect, bitmap2, c2499g2M1060a2);
            c2499g2M1060a.f1639c = c2499g2M1060a2.f1639c;
            m1064a(screenGraph, bitmap2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    /* JADX INFO: renamed from: a */
    public final Object m1062a(@NotNull AbstractC2727d6.b bVar, @NotNull Continuation<? super Unit> continuation) {
        a aVar;
        C2662W7 c2662w7;
        ViewGroup viewGroup;
        InterfaceC2749f8 interfaceC2749f8;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.f2229f;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.f2229f = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object obj = aVar.f2227d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.f2229f;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                ViewGroup viewGroupM1088b = m1088b();
                if (viewGroupM1088b != null) {
                    C2769h8 c2769h8 = new C2769h8(new C2619S3(), this.f2218g.f2586a);
                    aVar.f2224a = this;
                    aVar.f2225b = bVar;
                    aVar.f2226c = viewGroupM1088b;
                    aVar.f2229f = 1;
                    Object objM1152a = c2769h8.m1152a(aVar);
                    if (objM1152a == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c2662w7 = this;
                    viewGroup = viewGroupM1088b;
                    obj = objM1152a;
                }
                return Unit.INSTANCE;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            viewGroup = aVar.f2226c;
            bVar = aVar.f2225b;
            c2662w7 = aVar.f2224a;
            ResultKt.throwOnFailure(obj);
            c2662w7.m1063a(viewGroup, c2662w7.m1090d(), bVar, interfaceC2749f8);
            return Unit.INSTANCE;
        } finally {
            interfaceC2749f8.mo1133a((View) viewGroup).recycle();
        }
        interfaceC2749f8 = (InterfaceC2749f8) obj;
    }

    /* JADX INFO: renamed from: a */
    public final void m1064a(C2640U4 c2640u4, Bitmap bitmap) {
        String strEncodeToString = "";
        if (this.f2216e.m962b()) {
            C2769h8.a aVar = new C2769h8.a(bitmap, false);
            C2538K1 c2538k1 = this.f2216e;
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
            c2538k1.m961a(c2640u4, strEncodeToString, aVar, this.f2219h, this.f2369a);
            return;
        }
        this.f2369a.tryEmit(AbstractC2686Z4.g.f2342a);
        InterfaceC2567N0 interfaceC2567N0 = this.f2219h;
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
        interfaceC2567N0.mo988a(c2640u4, strEncodeToString, false);
    }
}
