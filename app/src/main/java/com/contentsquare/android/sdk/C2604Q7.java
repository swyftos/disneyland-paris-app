package com.contentsquare.android.sdk;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.communication.compose.ComposeInterface;
import com.contentsquare.android.core.communication.compose.ViewNode;
import com.contentsquare.android.core.features.logging.Logger;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.bouncycastle.asn1.eac.EACTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.Q7 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nVerticalComposeLazyScreenRecorder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerticalComposeLazyScreenRecorder.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/VerticalComposeLazyScreenRecorder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,257:1\n1549#2:258\n1620#2,3:259\n1549#2:262\n1620#2,3:263\n1549#2:267\n1620#2,3:268\n1549#2:271\n1620#2,3:272\n1#3:266\n*S KotlinDebug\n*F\n+ 1 VerticalComposeLazyScreenRecorder.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/VerticalComposeLazyScreenRecorder\n*L\n112#1:258\n112#1:259,3\n119#1:262\n119#1:263,3\n184#1:267\n184#1:268,3\n199#1:271\n199#1:272,3\n*E\n"})
public final class C2604Q7 extends AbstractC2696a5<AbstractC2727d6.a> {

    /* JADX INFO: renamed from: e */
    @NotNull
    public final C2538K1 f2015e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final C2514H7 f2016f;

    /* JADX INFO: renamed from: g */
    @NotNull
    public final C2739e8 f2017g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public final InterfaceC2567N0 f2018h;

    /* JADX INFO: renamed from: i */
    @NotNull
    public final C2705b4 f2019i;

    /* JADX INFO: renamed from: j */
    @NotNull
    public final C2704b3 f2020j;

    /* JADX INFO: renamed from: k */
    @NotNull
    public final InterfaceC2735e4<ComposeInterface> f2021k;

    /* JADX INFO: renamed from: l */
    @NotNull
    public final CoroutineDispatcher f2022l;

    /* JADX INFO: renamed from: m */
    @NotNull
    public final ArrayList f2023m;

    /* JADX INFO: renamed from: n */
    @NotNull
    public final Logger f2024n;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.Q7$a */
    @VisibleForTesting
    @SourceDebugExtension({"SMAP\nVerticalComposeLazyScreenRecorder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerticalComposeLazyScreenRecorder.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/VerticalComposeLazyScreenRecorder$LazyListComposeJsonViewProcessor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,257:1\n1549#2:258\n1620#2,3:259\n1855#2,2:262\n*S KotlinDebug\n*F\n+ 1 VerticalComposeLazyScreenRecorder.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/VerticalComposeLazyScreenRecorder$LazyListComposeJsonViewProcessor\n*L\n235#1:258\n235#1:259,3\n245#1:262,2\n*E\n"})
    public static final class a extends C2901v0 {

        /* JADX INFO: renamed from: b */
        @NotNull
        public final List<ViewNode> f2025b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull InterfaceC2735e4<ComposeInterface> composeInterfaceProvider, @NotNull List<ViewNode> lazyListItems) {
            super(composeInterfaceProvider);
            Intrinsics.checkNotNullParameter(composeInterfaceProvider, "composeInterfaceProvider");
            Intrinsics.checkNotNullParameter(lazyListItems, "lazyListItems");
            this.f2025b = lazyListItems;
        }

        @Override // com.contentsquare.android.sdk.C2901v0
        @VisibleForTesting(otherwise = 4)
        /* JADX INFO: renamed from: a */
        public final void mo1018a(@NotNull ViewNode rootNode) {
            Intrinsics.checkNotNullParameter(rootNode, "rootNode");
            m1019b(rootNode);
        }

        /* JADX INFO: renamed from: b */
        public final void m1019b(ViewNode viewNode) {
            if (!(viewNode.getNodeType() instanceof ViewNode.NodeType.VerticalLazyContainer)) {
                Iterator<T> it = viewNode.getChildren().iterator();
                while (it.hasNext()) {
                    m1019b((ViewNode) it.next());
                }
                return;
            }
            viewNode.getChildren().clear();
            List<ViewNode> children = viewNode.getChildren();
            List<ViewNode> list = this.f2025b;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ViewNode viewNode2 : list) {
                arrayList.add(viewNode2.copy((32763 & 1) != 0 ? viewNode2.id : null, (32763 & 2) != 0 ? viewNode2.name : null, (32763 & 4) != 0 ? viewNode2.parent : viewNode, (32763 & 8) != 0 ? viewNode2.bounds : null, (32763 & 16) != 0 ? viewNode2.posZ : BitmapDescriptorFactory.HUE_RED, (32763 & 32) != 0 ? viewNode2.isVisible : false, (32763 & 64) != 0 ? viewNode2.childOrder : 0, (32763 & 128) != 0 ? viewNode2.viewAlpha : BitmapDescriptorFactory.HUE_RED, (32763 & 256) != 0 ? viewNode2.background : null, (32763 & 512) != 0 ? viewNode2.bitmap : null, (32763 & 1024) != 0 ? viewNode2.children : null, (32763 & 2048) != 0 ? viewNode2.nodeType : null, (32763 & 4096) != 0 ? viewNode2.isClickable : false, (32763 & 8192) != 0 ? viewNode2.isEmptyOverlay : false, (32763 & 16384) != 0 ? viewNode2.excludeFromGestureRecognition : false));
            }
            children.addAll(arrayList);
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.Q7$b */
    @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.screencapture.screenrecorder.VerticalComposeLazyScreenRecorder", m1845f = "VerticalComposeLazyScreenRecorder.kt", m1846i = {0, 0}, m1847l = {140, 148}, m1848m = "handleLastSnapshot", m1849n = {"this", "previewBitmap"}, m1850s = {"L$0", "L$1"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        public C2604Q7 f2026a;

        /* JADX INFO: renamed from: b */
        public Bitmap f2027b;

        /* JADX INFO: renamed from: c */
        public /* synthetic */ Object f2028c;

        /* JADX INFO: renamed from: e */
        public int f2030e;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f2028c = obj;
            this.f2030e |= Integer.MIN_VALUE;
            return C2604Q7.this.m1017a((String) null, (InterfaceC2749f8) null, this);
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.Q7$c */
    @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.screencapture.screenrecorder.VerticalComposeLazyScreenRecorder$handleLastSnapshot$2", m1845f = "VerticalComposeLazyScreenRecorder.kt", m1846i = {}, m1847l = {}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ C2640U4 f2032b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ Bitmap f2033c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(C2640U4 c2640u4, Bitmap bitmap, Continuation<? super c> continuation) {
            super(2, continuation);
            this.f2032b = c2640u4;
            this.f2033c = bitmap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return C2604Q7.this.new c(this.f2032b, this.f2033c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            C2604Q7.m1015a(C2604Q7.this, this.f2032b, this.f2033c);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.Q7$d */
    public static final class d extends Lambda implements Function2<View, C2499G2, Unit> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ List<C2499G2> f2034a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ArrayList arrayList) {
            super(2);
            this.f2034a = arrayList;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(View view, C2499G2 c2499g2) {
            C2499G2 json = c2499g2;
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(json, "json");
            if (json.f1644h == C2499G2.a.ANDROID_COMPOSE_VIEW) {
                this.f2034a.add(json);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.Q7$e */
    @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.screencapture.screenrecorder.VerticalComposeLazyScreenRecorder", m1845f = "VerticalComposeLazyScreenRecorder.kt", m1846i = {0, 0, 0, 1, 1}, m1847l = {80, EACTags.HISTORICAL_BYTES}, m1848m = "runRecorder", m1849n = {"this", "context", "root", "root", "result"}, m1850s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    public static final class e extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        public Object f2035a;

        /* JADX INFO: renamed from: b */
        public Object f2036b;

        /* JADX INFO: renamed from: c */
        public ViewGroup f2037c;

        /* JADX INFO: renamed from: d */
        public /* synthetic */ Object f2038d;

        /* JADX INFO: renamed from: f */
        public int f2040f;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f2038d = obj;
            this.f2040f |= Integer.MIN_VALUE;
            return C2604Q7.this.m1016a((AbstractC2727d6.a) null, (Continuation<? super Unit>) this);
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.Q7$f */
    @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.screencapture.screenrecorder.VerticalComposeLazyScreenRecorder$runRecorder$2$1", m1845f = "VerticalComposeLazyScreenRecorder.kt", m1846i = {}, m1847l = {83}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        public int f2041a;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ ViewGroup f2043c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ AbstractC2727d6.a f2044d;

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ InterfaceC2749f8 f2045e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ViewGroup viewGroup, AbstractC2727d6.a aVar, InterfaceC2749f8 interfaceC2749f8, Continuation<? super f> continuation) {
            super(2, continuation);
            this.f2043c = viewGroup;
            this.f2044d = aVar;
            this.f2045e = interfaceC2749f8;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return C2604Q7.this.new f(this.f2043c, this.f2044d, this.f2045e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:36:0x018c  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Integer num;
            Object objM1017a;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2041a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C2604Q7 c2604q7 = C2604Q7.this;
                ViewGroup viewGroup = this.f2043c;
                String strM1090d = c2604q7.m1090d();
                AbstractC2727d6.a aVar = this.f2044d;
                InterfaceC2749f8 interfaceC2749f8 = this.f2045e;
                this.f2041a = 1;
                Bitmap screenshot = interfaceC2749f8.mo1133a((View) viewGroup);
                if (aVar.f2502d == 0) {
                    C2705b4 c2705b4 = c2604q7.f2019i;
                    Rect scrollContainerRect = aVar.f2503e;
                    c2705b4.getClass();
                    Intrinsics.checkNotNullParameter(screenshot, "screenshot");
                    Intrinsics.checkNotNullParameter(scrollContainerRect, "scrollContainerRect");
                    c2705b4.m1097a(screenshot, new Rect(0, 0, screenshot.getWidth(), scrollContainerRect.top));
                    C2704b3 c2704b3 = c2604q7.f2020j;
                    Rect scrollContainerRect2 = aVar.f2503e;
                    c2704b3.getClass();
                    Intrinsics.checkNotNullParameter(screenshot, "screenshot");
                    Intrinsics.checkNotNullParameter(scrollContainerRect2, "scrollContainerRect");
                    Rect rect = new Rect(0, 0, screenshot.getWidth(), scrollContainerRect2.top);
                    c2704b3.m1095a(screenshot, rect);
                    c2704b3.f2404b = rect.height() + c2704b3.f2404b;
                }
                C2705b4 c2705b5 = c2604q7.f2019i;
                Rect pageRect = aVar.f2505g;
                c2705b5.getClass();
                Intrinsics.checkNotNullParameter(screenshot, "screenshot");
                Intrinsics.checkNotNullParameter(pageRect, "pageRect");
                c2705b5.m1097a(screenshot, new Rect(0, pageRect.top, screenshot.getWidth(), pageRect.bottom));
                c2604q7.f2020j.m1096b(screenshot, aVar.f2505g);
                C2704b3 c2704b4 = c2604q7.f2020j;
                c2704b4.getClass();
                Bitmap bitmap = c2704b4.f2403a;
                Intrinsics.checkNotNull(bitmap);
                C2789j8 c2789j8 = new C2789j8(bitmap, c2704b4.f2405c);
                int i2 = c2604q7.f2020j.f2406d;
                List<ViewNode> list = aVar.f2504f;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(C2604Q7.m1013a(C2604Q7.m1014a((ViewNode) it.next(), c2789j8), 0, i2));
                }
                Logger logger = c2604q7.f2024n;
                StringBuilder sb = new StringBuilder("processed items: ");
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(Boxing.boxInt(((ViewNode) it2.next()).getChildOrder()));
                }
                sb.append(arrayList2);
                logger.m827d(sb.toString());
                c2604q7.f2023m.addAll(arrayList);
                Iterator<T> it3 = aVar.f2504f.iterator();
                if (it3.hasNext()) {
                    Integer numBoxInt = Boxing.boxInt(((ViewNode) it3.next()).getBounds().bottom);
                    while (it3.hasNext()) {
                        Integer numBoxInt2 = Boxing.boxInt(((ViewNode) it3.next()).getBounds().bottom);
                        if (numBoxInt.compareTo(numBoxInt2) < 0) {
                            numBoxInt = numBoxInt2;
                        }
                    }
                    num = numBoxInt;
                } else {
                    num = null;
                }
                if (num != null) {
                    c2604q7.f2020j.m1094a(num.intValue());
                }
                if (aVar.f2506h) {
                    C2705b4 c2705b6 = c2604q7.f2019i;
                    Rect scrollContainerRect3 = aVar.f2503e;
                    c2705b6.getClass();
                    Intrinsics.checkNotNullParameter(screenshot, "screenshot");
                    Intrinsics.checkNotNullParameter(scrollContainerRect3, "scrollContainerRect");
                    c2705b6.m1097a(screenshot, new Rect(0, scrollContainerRect3.bottom, screenshot.getWidth(), screenshot.getHeight()));
                    objM1017a = c2604q7.m1017a(strM1090d, interfaceC2749f8, this);
                    if (objM1017a != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        objM1017a = Unit.INSTANCE;
                    }
                } else {
                    objM1017a = Unit.INSTANCE;
                }
                if (objM1017a == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public C2604Q7() {
        throw null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2604Q7(MutableStateFlow snapshotStateFlow, C2538K1 externalViewsProcessor, C2514H7 treeTraverser, C2739e8 viewBitmapProviderFactory, C2682Z0 callback, InterfaceC2903v2 glassPane, C2705b4 previewBitmapBuilder, C2704b3 mergedScreenshotsBitmapBuilder, C2628T2 composeInterfaceProvider) {
        super(snapshotStateFlow, glassPane);
        CoroutineDispatcher recorderDispatcher = Dispatchers.getDefault();
        Intrinsics.checkNotNullParameter(snapshotStateFlow, "snapshotStateFlow");
        Intrinsics.checkNotNullParameter(externalViewsProcessor, "externalViewsProcessor");
        Intrinsics.checkNotNullParameter(treeTraverser, "treeTraverser");
        Intrinsics.checkNotNullParameter(viewBitmapProviderFactory, "viewBitmapProviderFactory");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(glassPane, "glassPane");
        Intrinsics.checkNotNullParameter(previewBitmapBuilder, "previewBitmapBuilder");
        Intrinsics.checkNotNullParameter(mergedScreenshotsBitmapBuilder, "mergedScreenshotsBitmapBuilder");
        Intrinsics.checkNotNullParameter(composeInterfaceProvider, "composeInterfaceProvider");
        Intrinsics.checkNotNullParameter(recorderDispatcher, "recorderDispatcher");
        this.f2015e = externalViewsProcessor;
        this.f2016f = treeTraverser;
        this.f2017g = viewBitmapProviderFactory;
        this.f2018h = callback;
        this.f2019i = previewBitmapBuilder;
        this.f2020j = mergedScreenshotsBitmapBuilder;
        this.f2021k = composeInterfaceProvider;
        this.f2022l = recorderDispatcher;
        this.f2023m = new ArrayList();
        this.f2024n = new Logger("VerticalComposeLazyRecorder");
    }

    /* JADX INFO: renamed from: a */
    public static final void m1015a(C2604Q7 c2604q7, C2640U4 c2640u4, Bitmap bitmap) {
        String strEncodeToString = "";
        if (!c2604q7.f2015e.m962b()) {
            c2604q7.f2369a.tryEmit(AbstractC2686Z4.g.f2342a);
            InterfaceC2567N0 interfaceC2567N0 = c2604q7.f2018h;
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
            interfaceC2567N0.mo988a(c2640u4, strEncodeToString, false);
            return;
        }
        c2604q7.f2024n.m827d("sending to external processor");
        C2769h8.a aVar = new C2769h8.a(bitmap, false);
        C2538K1 c2538k1 = c2604q7.f2015e;
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
        c2538k1.m961a(c2640u4, strEncodeToString, aVar, c2604q7.f2018h, c2604q7.f2369a);
    }

    @Override // com.contentsquare.android.sdk.AbstractC2696a5
    /* JADX INFO: renamed from: b */
    public final boolean mo909b(AbstractC2727d6 abstractC2727d6) {
        AbstractC2727d6.a context = (AbstractC2727d6.a) abstractC2727d6;
        Intrinsics.checkNotNullParameter(context, "context");
        return context.f2502d == 0;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2696a5
    /* JADX INFO: renamed from: e */
    public final void mo910e() {
        this.f2023m.clear();
        C2705b4 c2705b4 = this.f2019i;
        c2705b4.f2409c = null;
        c2705b4.f2410d = 0;
        c2705b4.f2407a = 0;
        c2705b4.f2408b = 0;
        C2704b3 c2704b3 = this.f2020j;
        c2704b3.f2403a = null;
        c2704b3.f2404b = 0;
        c2704b3.f2405c = 0;
        c2704b3.f2406d = 0;
        ViewGroup viewGroupM1088b = m1088b();
        if (viewGroupM1088b != null) {
            C2705b4 c2705b5 = this.f2019i;
            int width = viewGroupM1088b.getWidth();
            int height = viewGroupM1088b.getHeight();
            c2705b5.f2407a = width;
            c2705b5.f2408b = height;
        }
    }

    @Override // com.contentsquare.android.sdk.AbstractC2696a5
    /* JADX INFO: renamed from: b */
    public final /* bridge */ /* synthetic */ Object mo908b(AbstractC2727d6 abstractC2727d6, Continuation continuation) {
        return m1016a((AbstractC2727d6.a) abstractC2727d6, (Continuation<? super Unit>) continuation);
    }

    @Override // com.contentsquare.android.sdk.AbstractC2696a5
    /* JADX INFO: renamed from: a */
    public final void mo907a(AbstractC2727d6 abstractC2727d6) {
        AbstractC2727d6.a context = (AbstractC2727d6.a) abstractC2727d6;
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual(this.f2371c, context.f2499a)) {
            return;
        }
        this.f2372d = null;
        this.f2371c = context.f2499a;
    }

    /* JADX INFO: renamed from: a */
    public static ViewNode m1014a(ViewNode viewNode, C2789j8 c2789j8) {
        Rect bounds = viewNode.getBounds();
        String strMo1134a = c2789j8.mo1134a(bounds.left, bounds.top, bounds.width(), bounds.height());
        List<ViewNode> children = viewNode.getChildren();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(children, 10));
        String str = strMo1134a;
        for (ViewNode viewNode2 : children) {
            if (Intrinsics.areEqual(viewNode2.getBounds(), viewNode.getBounds())) {
                str = null;
            }
            arrayList.add(m1014a(viewNode2, c2789j8));
        }
        return viewNode.copy((32763 & 1) != 0 ? viewNode.id : null, (32763 & 2) != 0 ? viewNode.name : null, (32763 & 4) != 0 ? viewNode.parent : null, (32763 & 8) != 0 ? viewNode.bounds : null, (32763 & 16) != 0 ? viewNode.posZ : BitmapDescriptorFactory.HUE_RED, (32763 & 32) != 0 ? viewNode.isVisible : false, (32763 & 64) != 0 ? viewNode.childOrder : 0, (32763 & 128) != 0 ? viewNode.viewAlpha : BitmapDescriptorFactory.HUE_RED, (32763 & 256) != 0 ? viewNode.background : null, (32763 & 512) != 0 ? viewNode.bitmap : str, (32763 & 1024) != 0 ? viewNode.children : CollectionsKt.toMutableList((Collection) arrayList), (32763 & 2048) != 0 ? viewNode.nodeType : null, (32763 & 4096) != 0 ? viewNode.isClickable : false, (32763 & 8192) != 0 ? viewNode.isEmptyOverlay : false, (32763 & 16384) != 0 ? viewNode.excludeFromGestureRecognition : false);
    }

    @Override // com.contentsquare.android.sdk.AbstractC2696a5
    @NotNull
    /* JADX INFO: renamed from: a */
    public final Logger mo906a() {
        return this.f2024n;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: a */
    public final Object m1017a(String str, InterfaceC2749f8 interfaceC2749f8, Continuation<? super Unit> continuation) {
        b bVar;
        Bitmap bitmap;
        Object objWithContext;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.f2030e;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.f2030e = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object obj = bVar.f2028c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.f2030e;
        if (i2 != 0) {
            if (i2 == 1) {
                Bitmap bitmap2 = bVar.f2027b;
                C2604Q7 c2604q7 = bVar.f2026a;
                ResultKt.throwOnFailure(obj);
                bitmap = bitmap2;
                this = c2604q7;
                objWithContext = obj;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        this.f2024n.m827d("creating screen graph");
        bitmap = this.f2019i.f2409c;
        if (bitmap == null) {
            throw new IllegalStateException("Can not generate screen preview!");
        }
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            str = "";
        }
        d dVar = new d(arrayList);
        bVar.f2026a = this;
        bVar.f2027b = bitmap;
        bVar.f2030e = 1;
        objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new C2613R7(this, interfaceC2749f8, dVar, str, null), bVar);
        if (objWithContext == coroutine_suspended) {
            return coroutine_suspended;
        }
        C2640U4 c2640u4 = (C2640U4) objWithContext;
        if (c2640u4 == null) {
            throw new IllegalStateException("Can not generate screen graph!");
        }
        this.f2023m.clear();
        C2705b4 c2705b4 = this.f2019i;
        c2705b4.f2409c = null;
        c2705b4.f2410d = 0;
        c2705b4.f2407a = 0;
        c2705b4.f2408b = 0;
        C2704b3 c2704b3 = this.f2020j;
        c2704b3.f2403a = null;
        c2704b3.f2404b = 0;
        c2704b3.f2405c = 0;
        c2704b3.f2406d = 0;
        this.f2024n.m827d("sending screen graph");
        MainCoroutineDispatcher main = Dispatchers.getMain();
        c cVar = this.new c(c2640u4, bitmap, null);
        bVar.f2026a = null;
        bVar.f2027b = null;
        bVar.f2030e = 2;
        if (BuildersKt.withContext(main, cVar, bVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: a */
    public static ViewNode m1013a(ViewNode viewNode, int i, int i2) {
        Rect rect = new Rect(viewNode.getBounds());
        rect.offset(i, i2);
        List<ViewNode> children = viewNode.getChildren();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(children, 10));
        Iterator<T> it = children.iterator();
        while (it.hasNext()) {
            arrayList.add(m1013a((ViewNode) it.next(), i, i2));
        }
        return viewNode.copy((32763 & 1) != 0 ? viewNode.id : null, (32763 & 2) != 0 ? viewNode.name : null, (32763 & 4) != 0 ? viewNode.parent : null, (32763 & 8) != 0 ? viewNode.bounds : rect, (32763 & 16) != 0 ? viewNode.posZ : BitmapDescriptorFactory.HUE_RED, (32763 & 32) != 0 ? viewNode.isVisible : false, (32763 & 64) != 0 ? viewNode.childOrder : 0, (32763 & 128) != 0 ? viewNode.viewAlpha : BitmapDescriptorFactory.HUE_RED, (32763 & 256) != 0 ? viewNode.background : null, (32763 & 512) != 0 ? viewNode.bitmap : null, (32763 & 1024) != 0 ? viewNode.children : CollectionsKt.toMutableList((Collection) arrayList), (32763 & 2048) != 0 ? viewNode.nodeType : null, (32763 & 4096) != 0 ? viewNode.isClickable : false, (32763 & 8192) != 0 ? viewNode.isEmptyOverlay : false, (32763 & 16384) != 0 ? viewNode.excludeFromGestureRecognition : false);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.contentsquare.android.sdk.Q7, com.contentsquare.android.sdk.a5, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.contentsquare.android.sdk.f8] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v6, types: [com.contentsquare.android.sdk.f8] */
    /* JADX WARN: Type inference failed for: r10v7, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.contentsquare.android.sdk.d6$a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v4, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.contentsquare.android.sdk.Q7] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.contentsquare.android.sdk.d6$a] */
    /* JADX WARN: Type inference failed for: r7v2 */
    @Nullable
    /* JADX INFO: renamed from: a */
    public final Object m1016a(@NotNull AbstractC2727d6.a aVar, @NotNull Continuation<? super Unit> continuation) {
        e eVar;
        ?? r5;
        ?? r7;
        ViewGroup viewGroup;
        ?? r10;
        if (continuation instanceof e) {
            eVar = (e) continuation;
            int i = eVar.f2040f;
            if ((i & Integer.MIN_VALUE) != 0) {
                eVar.f2040f = i - Integer.MIN_VALUE;
            } else {
                eVar = new e(continuation);
            }
        } else {
            eVar = new e(continuation);
        }
        Object obj = eVar.f2038d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = eVar.f2040f;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                ViewGroup viewGroupM1088b = m1088b();
                if (viewGroupM1088b != null) {
                    C2769h8 c2769h8 = new C2769h8(new C2619S3(), this.f2017g.f2586a);
                    eVar.f2035a = this;
                    eVar.f2036b = aVar;
                    eVar.f2037c = viewGroupM1088b;
                    eVar.f2040f = 1;
                    Object objM1152a = c2769h8.m1152a(eVar);
                    if (objM1152a == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    r5 = this;
                    r7 = aVar;
                    viewGroup = viewGroupM1088b;
                    obj = objM1152a;
                }
                return Unit.INSTANCE;
            }
            if (i2 == 1) {
                ViewGroup viewGroup2 = eVar.f2037c;
                AbstractC2727d6.a aVar2 = (AbstractC2727d6.a) eVar.f2036b;
                C2604Q7 c2604q7 = (C2604Q7) eVar.f2035a;
                ResultKt.throwOnFailure(obj);
                r7 = aVar2;
                r5 = c2604q7;
                viewGroup = viewGroup2;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                InterfaceC2749f8 interfaceC2749f8 = (InterfaceC2749f8) eVar.f2036b;
                ViewGroup viewGroup3 = (ViewGroup) eVar.f2035a;
                ResultKt.throwOnFailure(obj);
                r10 = interfaceC2749f8;
                aVar = viewGroup3;
            }
            this = r10.mo1133a(aVar);
            this.recycle();
            return Unit.INSTANCE;
            InterfaceC2749f8 interfaceC2749f9 = (InterfaceC2749f8) obj;
            CoroutineDispatcher coroutineDispatcher = r5.f2022l;
            f fVar = new f(viewGroup, r7, interfaceC2749f9, null);
            eVar.f2035a = viewGroup;
            eVar.f2036b = interfaceC2749f9;
            eVar.f2037c = null;
            eVar.f2040f = 2;
            r10 = interfaceC2749f9;
            aVar = viewGroup;
            if (BuildersKt.withContext(coroutineDispatcher, fVar, eVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            this = r10.mo1133a(aVar);
            this.recycle();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            this.mo1133a(aVar).recycle();
            throw th;
        }
    }
}
