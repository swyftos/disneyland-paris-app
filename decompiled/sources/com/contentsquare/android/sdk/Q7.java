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
import com.contentsquare.android.sdk.AbstractC0657d6;
import com.contentsquare.android.sdk.C0699h8;
import com.contentsquare.android.sdk.G2;
import com.contentsquare.android.sdk.Z4;
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
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.bouncycastle.asn1.eac.EACTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nVerticalComposeLazyScreenRecorder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerticalComposeLazyScreenRecorder.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/VerticalComposeLazyScreenRecorder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,257:1\n1549#2:258\n1620#2,3:259\n1549#2:262\n1620#2,3:263\n1549#2:267\n1620#2,3:268\n1549#2:271\n1620#2,3:272\n1#3:266\n*S KotlinDebug\n*F\n+ 1 VerticalComposeLazyScreenRecorder.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/VerticalComposeLazyScreenRecorder\n*L\n112#1:258\n112#1:259,3\n119#1:262\n119#1:263,3\n184#1:267\n184#1:268,3\n199#1:271\n199#1:272,3\n*E\n"})
/* loaded from: classes2.dex */
public final class Q7 extends AbstractC0626a5<AbstractC0657d6.a> {

    @NotNull
    public final K1 e;

    @NotNull
    public final H7 f;

    @NotNull
    public final C0669e8 g;

    @NotNull
    public final N0 h;

    @NotNull
    public final C0635b4 i;

    @NotNull
    public final C0634b3 j;

    @NotNull
    public final InterfaceC0665e4<ComposeInterface> k;

    @NotNull
    public final CoroutineDispatcher l;

    @NotNull
    public final ArrayList m;

    @NotNull
    public final Logger n;

    @VisibleForTesting
    @SourceDebugExtension({"SMAP\nVerticalComposeLazyScreenRecorder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerticalComposeLazyScreenRecorder.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/VerticalComposeLazyScreenRecorder$LazyListComposeJsonViewProcessor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,257:1\n1549#2:258\n1620#2,3:259\n1855#2,2:262\n*S KotlinDebug\n*F\n+ 1 VerticalComposeLazyScreenRecorder.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/VerticalComposeLazyScreenRecorder$LazyListComposeJsonViewProcessor\n*L\n235#1:258\n235#1:259,3\n245#1:262,2\n*E\n"})
    public static final class a extends C0830v0 {

        @NotNull
        public final List<ViewNode> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull InterfaceC0665e4<ComposeInterface> composeInterfaceProvider, @NotNull List<ViewNode> lazyListItems) {
            super(composeInterfaceProvider);
            Intrinsics.checkNotNullParameter(composeInterfaceProvider, "composeInterfaceProvider");
            Intrinsics.checkNotNullParameter(lazyListItems, "lazyListItems");
            this.b = lazyListItems;
        }

        @Override // com.contentsquare.android.sdk.C0830v0
        @VisibleForTesting(otherwise = 4)
        public final void a(@NotNull ViewNode rootNode) {
            Intrinsics.checkNotNullParameter(rootNode, "rootNode");
            b(rootNode);
        }

        public final void b(ViewNode viewNode) {
            if (!(viewNode.getNodeType() instanceof ViewNode.NodeType.VerticalLazyContainer)) {
                Iterator<T> it = viewNode.getChildren().iterator();
                while (it.hasNext()) {
                    b((ViewNode) it.next());
                }
                return;
            }
            viewNode.getChildren().clear();
            List<ViewNode> children = viewNode.getChildren();
            List<ViewNode> list = this.b;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ViewNode viewNode2 : list) {
                arrayList.add(viewNode2.copy((32763 & 1) != 0 ? viewNode2.id : null, (32763 & 2) != 0 ? viewNode2.name : null, (32763 & 4) != 0 ? viewNode2.parent : viewNode, (32763 & 8) != 0 ? viewNode2.bounds : null, (32763 & 16) != 0 ? viewNode2.posZ : BitmapDescriptorFactory.HUE_RED, (32763 & 32) != 0 ? viewNode2.isVisible : false, (32763 & 64) != 0 ? viewNode2.childOrder : 0, (32763 & 128) != 0 ? viewNode2.viewAlpha : BitmapDescriptorFactory.HUE_RED, (32763 & 256) != 0 ? viewNode2.background : null, (32763 & 512) != 0 ? viewNode2.bitmap : null, (32763 & 1024) != 0 ? viewNode2.children : null, (32763 & 2048) != 0 ? viewNode2.nodeType : null, (32763 & 4096) != 0 ? viewNode2.isClickable : false, (32763 & 8192) != 0 ? viewNode2.isEmptyOverlay : false, (32763 & 16384) != 0 ? viewNode2.excludeFromGestureRecognition : false));
            }
            children.addAll(arrayList);
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.screencapture.screenrecorder.VerticalComposeLazyScreenRecorder", f = "VerticalComposeLazyScreenRecorder.kt", i = {0, 0}, l = {140, 148}, m = "handleLastSnapshot", n = {"this", "previewBitmap"}, s = {"L$0", "L$1"})
    public static final class b extends ContinuationImpl {
        public Q7 a;
        public Bitmap b;
        public /* synthetic */ Object c;
        public int e;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return Q7.this.a((String) null, (InterfaceC0679f8) null, this);
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.screencapture.screenrecorder.VerticalComposeLazyScreenRecorder$handleLastSnapshot$2", f = "VerticalComposeLazyScreenRecorder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ U4 b;
        public final /* synthetic */ Bitmap c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(U4 u4, Bitmap bitmap, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = u4;
            this.c = bitmap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return Q7.this.new c(this.b, this.c, continuation);
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
            Q7.a(Q7.this, this.b, this.c);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function2<View, G2, Unit> {
        public final /* synthetic */ List<G2> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ArrayList arrayList) {
            super(2);
            this.a = arrayList;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(View view, G2 g2) {
            G2 json = g2;
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(json, "json");
            if (json.h == G2.a.ANDROID_COMPOSE_VIEW) {
                this.a.add(json);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.screencapture.screenrecorder.VerticalComposeLazyScreenRecorder", f = "VerticalComposeLazyScreenRecorder.kt", i = {0, 0, 0, 1, 1}, l = {80, EACTags.HISTORICAL_BYTES}, m = "runRecorder", n = {"this", "context", "root", "root", "result"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    public static final class e extends ContinuationImpl {
        public Object a;
        public Object b;
        public ViewGroup c;
        public /* synthetic */ Object d;
        public int f;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return Q7.this.a((AbstractC0657d6.a) null, (Continuation<? super Unit>) this);
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.screencapture.screenrecorder.VerticalComposeLazyScreenRecorder$runRecorder$2$1", f = "VerticalComposeLazyScreenRecorder.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ ViewGroup c;
        public final /* synthetic */ AbstractC0657d6.a d;
        public final /* synthetic */ InterfaceC0679f8 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ViewGroup viewGroup, AbstractC0657d6.a aVar, InterfaceC0679f8 interfaceC0679f8, Continuation<? super f> continuation) {
            super(2, continuation);
            this.c = viewGroup;
            this.d = aVar;
            this.e = interfaceC0679f8;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return Q7.this.new f(this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x018c  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 404
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.Q7.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public Q7() {
        throw null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q7(MutableStateFlow snapshotStateFlow, K1 externalViewsProcessor, H7 treeTraverser, C0669e8 viewBitmapProviderFactory, Z0 callback, InterfaceC0832v2 glassPane, C0635b4 previewBitmapBuilder, C0634b3 mergedScreenshotsBitmapBuilder, T2 composeInterfaceProvider) {
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
        this.e = externalViewsProcessor;
        this.f = treeTraverser;
        this.g = viewBitmapProviderFactory;
        this.h = callback;
        this.i = previewBitmapBuilder;
        this.j = mergedScreenshotsBitmapBuilder;
        this.k = composeInterfaceProvider;
        this.l = recorderDispatcher;
        this.m = new ArrayList();
        this.n = new Logger("VerticalComposeLazyRecorder");
    }

    public static final void a(Q7 q7, U4 u4, Bitmap bitmap) {
        String strEncodeToString = "";
        if (!q7.e.b()) {
            q7.a.tryEmit(Z4.g.a);
            N0 n0 = q7.h;
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
            n0.a(u4, strEncodeToString, false);
            return;
        }
        q7.n.d("sending to external processor");
        C0699h8.a aVar = new C0699h8.a(bitmap, false);
        K1 k1 = q7.e;
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
        k1.a(u4, strEncodeToString, aVar, q7.h, q7.a);
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    public final boolean b(AbstractC0657d6 abstractC0657d6) {
        AbstractC0657d6.a context = (AbstractC0657d6.a) abstractC0657d6;
        Intrinsics.checkNotNullParameter(context, "context");
        return context.d == 0;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    public final void e() {
        this.m.clear();
        C0635b4 c0635b4 = this.i;
        c0635b4.c = null;
        c0635b4.d = 0;
        c0635b4.a = 0;
        c0635b4.b = 0;
        C0634b3 c0634b3 = this.j;
        c0634b3.a = null;
        c0634b3.b = 0;
        c0634b3.c = 0;
        c0634b3.d = 0;
        ViewGroup viewGroupB = b();
        if (viewGroupB != null) {
            C0635b4 c0635b42 = this.i;
            int width = viewGroupB.getWidth();
            int height = viewGroupB.getHeight();
            c0635b42.a = width;
            c0635b42.b = height;
        }
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    public final /* bridge */ /* synthetic */ Object b(AbstractC0657d6 abstractC0657d6, Continuation continuation) {
        return a((AbstractC0657d6.a) abstractC0657d6, (Continuation<? super Unit>) continuation);
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    public final void a(AbstractC0657d6 abstractC0657d6) {
        AbstractC0657d6.a context = (AbstractC0657d6.a) abstractC0657d6;
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual(this.c, context.a)) {
            return;
        }
        this.d = null;
        this.c = context.a;
    }

    public static ViewNode a(ViewNode viewNode, C0719j8 c0719j8) {
        Rect bounds = viewNode.getBounds();
        String strA = c0719j8.a(bounds.left, bounds.top, bounds.width(), bounds.height());
        List<ViewNode> children = viewNode.getChildren();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(children, 10));
        String str = strA;
        for (ViewNode viewNode2 : children) {
            if (Intrinsics.areEqual(viewNode2.getBounds(), viewNode.getBounds())) {
                str = null;
            }
            arrayList.add(a(viewNode2, c0719j8));
        }
        return viewNode.copy((32763 & 1) != 0 ? viewNode.id : null, (32763 & 2) != 0 ? viewNode.name : null, (32763 & 4) != 0 ? viewNode.parent : null, (32763 & 8) != 0 ? viewNode.bounds : null, (32763 & 16) != 0 ? viewNode.posZ : BitmapDescriptorFactory.HUE_RED, (32763 & 32) != 0 ? viewNode.isVisible : false, (32763 & 64) != 0 ? viewNode.childOrder : 0, (32763 & 128) != 0 ? viewNode.viewAlpha : BitmapDescriptorFactory.HUE_RED, (32763 & 256) != 0 ? viewNode.background : null, (32763 & 512) != 0 ? viewNode.bitmap : str, (32763 & 1024) != 0 ? viewNode.children : CollectionsKt.toMutableList((Collection) arrayList), (32763 & 2048) != 0 ? viewNode.nodeType : null, (32763 & 4096) != 0 ? viewNode.isClickable : false, (32763 & 8192) != 0 ? viewNode.isEmptyOverlay : false, (32763 & 16384) != 0 ? viewNode.excludeFromGestureRecognition : false);
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    @NotNull
    public final Logger a() {
        return this.n;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r13, com.contentsquare.android.sdk.InterfaceC0679f8 r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof com.contentsquare.android.sdk.Q7.b
            if (r0 == 0) goto L13
            r0 = r15
            com.contentsquare.android.sdk.Q7$b r0 = (com.contentsquare.android.sdk.Q7.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.Q7$b r0 = new com.contentsquare.android.sdk.Q7$b
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r15)
            goto Lb6
        L2d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L35:
            android.graphics.Bitmap r12 = r0.b
            com.contentsquare.android.sdk.Q7 r13 = r0.a
            kotlin.ResultKt.throwOnFailure(r15)
            r11 = r15
            r15 = r12
            r12 = r13
            r13 = r11
            goto L7a
        L41:
            kotlin.ResultKt.throwOnFailure(r15)
            com.contentsquare.android.core.features.logging.Logger r15 = r12.n
            java.lang.String r2 = "creating screen graph"
            r15.d(r2)
            com.contentsquare.android.sdk.b4 r15 = r12.i
            android.graphics.Bitmap r15 = r15.c
            if (r15 == 0) goto Lc1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            if (r13 != 0) goto L5a
            java.lang.String r13 = ""
        L5a:
            r9 = r13
            com.contentsquare.android.sdk.Q7$d r8 = new com.contentsquare.android.sdk.Q7$d
            r8.<init>(r2)
            r0.a = r12
            r0.b = r15
            r0.e = r4
            kotlinx.coroutines.MainCoroutineDispatcher r13 = kotlinx.coroutines.Dispatchers.getMain()
            com.contentsquare.android.sdk.R7 r2 = new com.contentsquare.android.sdk.R7
            r10 = 0
            r5 = r2
            r6 = r12
            r7 = r14
            r5.<init>(r6, r7, r8, r9, r10)
            java.lang.Object r13 = kotlinx.coroutines.BuildersKt.withContext(r13, r2, r0)
            if (r13 != r1) goto L7a
            return r1
        L7a:
            com.contentsquare.android.sdk.U4 r13 = (com.contentsquare.android.sdk.U4) r13
            if (r13 == 0) goto Lb9
            java.util.ArrayList r14 = r12.m
            r14.clear()
            com.contentsquare.android.sdk.b4 r14 = r12.i
            r2 = 0
            r14.c = r2
            r4 = 0
            r14.d = r4
            r14.a = r4
            r14.b = r4
            com.contentsquare.android.sdk.b3 r14 = r12.j
            r14.a = r2
            r14.b = r4
            r14.c = r4
            r14.d = r4
            com.contentsquare.android.core.features.logging.Logger r14 = r12.n
            java.lang.String r4 = "sending screen graph"
            r14.d(r4)
            kotlinx.coroutines.MainCoroutineDispatcher r14 = kotlinx.coroutines.Dispatchers.getMain()
            com.contentsquare.android.sdk.Q7$c r4 = new com.contentsquare.android.sdk.Q7$c
            r4.<init>(r13, r15, r2)
            r0.a = r2
            r0.b = r2
            r0.e = r3
            java.lang.Object r12 = kotlinx.coroutines.BuildersKt.withContext(r14, r4, r0)
            if (r12 != r1) goto Lb6
            return r1
        Lb6:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        Lb9:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "Can not generate screen graph!"
            r12.<init>(r13)
            throw r12
        Lc1:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "Can not generate screen preview!"
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.Q7.a(java.lang.String, com.contentsquare.android.sdk.f8, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static ViewNode a(ViewNode viewNode, int i, int i2) {
        Rect rect = new Rect(viewNode.getBounds());
        rect.offset(i, i2);
        List<ViewNode> children = viewNode.getChildren();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(children, 10));
        Iterator<T> it = children.iterator();
        while (it.hasNext()) {
            arrayList.add(a((ViewNode) it.next(), i, i2));
        }
        return viewNode.copy((32763 & 1) != 0 ? viewNode.id : null, (32763 & 2) != 0 ? viewNode.name : null, (32763 & 4) != 0 ? viewNode.parent : null, (32763 & 8) != 0 ? viewNode.bounds : rect, (32763 & 16) != 0 ? viewNode.posZ : BitmapDescriptorFactory.HUE_RED, (32763 & 32) != 0 ? viewNode.isVisible : false, (32763 & 64) != 0 ? viewNode.childOrder : 0, (32763 & 128) != 0 ? viewNode.viewAlpha : BitmapDescriptorFactory.HUE_RED, (32763 & 256) != 0 ? viewNode.background : null, (32763 & 512) != 0 ? viewNode.bitmap : null, (32763 & 1024) != 0 ? viewNode.children : CollectionsKt.toMutableList((Collection) arrayList), (32763 & 2048) != 0 ? viewNode.nodeType : null, (32763 & 4096) != 0 ? viewNode.isClickable : false, (32763 & 8192) != 0 ? viewNode.isEmptyOverlay : false, (32763 & 16384) != 0 ? viewNode.excludeFromGestureRecognition : false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
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
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull com.contentsquare.android.sdk.AbstractC0657d6.a r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.contentsquare.android.sdk.Q7.e
            if (r0 == 0) goto L13
            r0 = r12
            com.contentsquare.android.sdk.Q7$e r0 = (com.contentsquare.android.sdk.Q7.e) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.Q7$e r0 = new com.contentsquare.android.sdk.Q7$e
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L51
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r10 = r0.b
            com.contentsquare.android.sdk.f8 r10 = (com.contentsquare.android.sdk.InterfaceC0679f8) r10
            java.lang.Object r11 = r0.a
            android.view.ViewGroup r11 = (android.view.ViewGroup) r11
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Throwable -> L35
            goto L99
        L35:
            r12 = move-exception
            goto La1
        L38:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L40:
            android.view.ViewGroup r10 = r0.c
            java.lang.Object r11 = r0.b
            com.contentsquare.android.sdk.d6$a r11 = (com.contentsquare.android.sdk.AbstractC0657d6.a) r11
            java.lang.Object r2 = r0.a
            com.contentsquare.android.sdk.Q7 r2 = (com.contentsquare.android.sdk.Q7) r2
            kotlin.ResultKt.throwOnFailure(r12)
            r7 = r11
            r5 = r2
            r11 = r10
            goto L7b
        L51:
            kotlin.ResultKt.throwOnFailure(r12)
            android.view.ViewGroup r12 = r10.b()
            if (r12 == 0) goto La9
            com.contentsquare.android.sdk.e8 r2 = r10.g
            com.contentsquare.android.sdk.h8 r5 = new com.contentsquare.android.sdk.h8
            com.contentsquare.android.sdk.S3 r6 = new com.contentsquare.android.sdk.S3
            r6.<init>()
            com.contentsquare.android.sdk.M2 r2 = r2.a
            r5.<init>(r6, r2)
            r0.a = r10
            r0.b = r11
            r0.c = r12
            r0.f = r4
            java.lang.Object r2 = r5.a(r0)
            if (r2 != r1) goto L77
            return r1
        L77:
            r5 = r10
            r7 = r11
            r11 = r12
            r12 = r2
        L7b:
            r10 = r12
            com.contentsquare.android.sdk.f8 r10 = (com.contentsquare.android.sdk.InterfaceC0679f8) r10
            kotlinx.coroutines.CoroutineDispatcher r12 = r5.l     // Catch: java.lang.Throwable -> L35
            com.contentsquare.android.sdk.Q7$f r2 = new com.contentsquare.android.sdk.Q7$f     // Catch: java.lang.Throwable -> L35
            r9 = 0
            r4 = r2
            r6 = r11
            r8 = r10
            r4.<init>(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L35
            r0.a = r11     // Catch: java.lang.Throwable -> L35
            r0.b = r10     // Catch: java.lang.Throwable -> L35
            r4 = 0
            r0.c = r4     // Catch: java.lang.Throwable -> L35
            r0.f = r3     // Catch: java.lang.Throwable -> L35
            java.lang.Object r12 = kotlinx.coroutines.BuildersKt.withContext(r12, r2, r0)     // Catch: java.lang.Throwable -> L35
            if (r12 != r1) goto L99
            return r1
        L99:
            android.graphics.Bitmap r10 = r10.a(r11)
            r10.recycle()
            goto La9
        La1:
            android.graphics.Bitmap r10 = r10.a(r11)
            r10.recycle()
            throw r12
        La9:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.Q7.a(com.contentsquare.android.sdk.d6$a, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
