package com.contentsquare.android.sdk;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.api.model.CustomVar;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.AbstractC0657d6;
import com.contentsquare.android.sdk.AbstractC0844w5;
import com.contentsquare.android.sdk.C0699h8;
import com.contentsquare.android.sdk.Z4;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@SourceDebugExtension({"SMAP\nVerticalRecyclerViewScreenRecorder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerticalRecyclerViewScreenRecorder.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/VerticalRecyclerViewScreenRecorder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,276:1\n1#2:277\n1#2:293\n1#2:299\n1549#3:278\n1620#3,3:279\n1360#3:282\n1446#3,5:283\n1549#3:288\n1620#3,3:289\n2634#3:292\n1549#3:294\n1620#3,3:295\n2634#3:298\n*S KotlinDebug\n*F\n+ 1 VerticalRecyclerViewScreenRecorder.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/VerticalRecyclerViewScreenRecorder\n*L\n245#1:293\n247#1:299\n178#1:278\n178#1:279,3\n226#1:282\n226#1:283,5\n238#1:288\n238#1:289,3\n245#1:292\n247#1:294\n247#1:295,3\n247#1:298\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.a8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0629a8 extends AbstractC0626a5<AbstractC0657d6.d> {

    @NotNull
    public final K1 e;

    @NotNull
    public final H7 f;

    @NotNull
    public final C0669e8 g;

    @NotNull
    public final N0 h;

    @NotNull
    public final Function2<View, InterfaceC0679f8, AbstractC0645c4> i;

    @NotNull
    public final C0635b4 j;

    @NotNull
    public final C0634b3 k;

    @NotNull
    public final Logger l;

    @Nullable
    public U4 m;

    @Nullable
    public G2 n;

    /* renamed from: com.contentsquare.android.sdk.a8$a */
    public static final class a extends Lambda implements Function2<View, G2, Unit> {
        public final /* synthetic */ View a;
        public final /* synthetic */ C0629a8 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view, C0629a8 c0629a8) {
            super(2);
            this.a = view;
            this.b = c0629a8;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(View view, G2 g2) {
            View view2 = view;
            G2 jsonView = g2;
            Intrinsics.checkNotNullParameter(view2, "view");
            Intrinsics.checkNotNullParameter(jsonView, "jsonView");
            if (Intrinsics.areEqual(view2, this.a)) {
                this.b.n = jsonView;
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.screencapture.screenrecorder.VerticalRecyclerViewScreenRecorder", f = "VerticalRecyclerViewScreenRecorder.kt", i = {0, 0, 0}, l = {73}, m = "runRecorder", n = {"this", "context", "root"}, s = {"L$0", "L$1", "L$2"})
    /* renamed from: com.contentsquare.android.sdk.a8$b */
    public static final class b extends ContinuationImpl {
        public C0629a8 a;
        public AbstractC0657d6.d b;
        public ViewGroup c;
        public /* synthetic */ Object d;
        public int f;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return C0629a8.this.a((AbstractC0657d6.d) null, (Continuation<? super Unit>) this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0629a8(@NotNull MutableStateFlow snapshotStateFlow, @NotNull K1 externalViewsProcessor, @NotNull H7 treeTraverser, @NotNull C0669e8 viewBitmapProviderFactory, @NotNull Z0 callback, @NotNull InterfaceC0832v2 glassPane, @NotNull C0830v0 composeScreenGraphGenerator, @NotNull C0635b4 previewBitmapBuilder, @NotNull C0634b3 mergedScreenshotsBitmapBuilder) {
        super(snapshotStateFlow, glassPane);
        Intrinsics.checkNotNullParameter(snapshotStateFlow, "snapshotStateFlow");
        Intrinsics.checkNotNullParameter(externalViewsProcessor, "externalViewsProcessor");
        Intrinsics.checkNotNullParameter(treeTraverser, "treeTraverser");
        Intrinsics.checkNotNullParameter(viewBitmapProviderFactory, "viewBitmapProviderFactory");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(glassPane, "glassPane");
        Intrinsics.checkNotNullParameter(composeScreenGraphGenerator, "composeScreenGraphGenerator");
        Intrinsics.checkNotNullParameter(previewBitmapBuilder, "previewBitmapBuilder");
        Intrinsics.checkNotNullParameter(mergedScreenshotsBitmapBuilder, "mergedScreenshotsBitmapBuilder");
        this.e = externalViewsProcessor;
        this.f = treeTraverser;
        this.g = viewBitmapProviderFactory;
        this.h = callback;
        this.i = composeScreenGraphGenerator;
        this.j = previewBitmapBuilder;
        this.k = mergedScreenshotsBitmapBuilder;
        this.l = new Logger("VerticalRecyclerViewScreenRecorder");
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    public final void a(AbstractC0657d6 abstractC0657d6) {
        AbstractC0657d6.d context = (AbstractC0657d6.d) abstractC0657d6;
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual(this.c, context.a)) {
            return;
        }
        this.c = null;
        this.d = null;
        this.m = null;
        this.n = null;
        C0635b4 c0635b4 = this.j;
        c0635b4.c = null;
        c0635b4.d = 0;
        c0635b4.a = 0;
        c0635b4.b = 0;
        C0634b3 c0634b3 = this.k;
        c0634b3.a = null;
        c0634b3.b = 0;
        c0634b3.c = 0;
        c0634b3.d = 0;
        this.c = context.a;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    public final boolean b(AbstractC0657d6 abstractC0657d6) {
        AbstractC0657d6.d context = (AbstractC0657d6.d) abstractC0657d6;
        Intrinsics.checkNotNullParameter(context, "context");
        return context.e.contains(0);
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    public final void e() {
        ViewGroup viewGroupB = b();
        if (viewGroupB != null) {
            C0635b4 c0635b4 = this.j;
            int width = viewGroupB.getWidth();
            int height = viewGroupB.getHeight();
            c0635b4.a = width;
            c0635b4.b = height;
        }
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    public final /* bridge */ /* synthetic */ Object b(AbstractC0657d6 abstractC0657d6, Continuation continuation) {
        return a((AbstractC0657d6.d) abstractC0657d6, (Continuation<? super Unit>) continuation);
    }

    @VisibleForTesting
    @NotNull
    public static ArrayList a(@NotNull G2 view) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(view, "view");
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        List<G2> list = view.c;
        if (list != null) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(a((G2) it.next()));
            }
            listEmptyList = CollectionsKt.flatten(arrayList2);
        } else {
            listEmptyList = null;
        }
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        arrayList.addAll(listEmptyList);
        return arrayList;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    @NotNull
    public final Logger a() {
        return this.l;
    }

    @VisibleForTesting
    public final void a(@NotNull ViewGroup root, @Nullable String str, @NotNull AbstractC0657d6.d context, @NotNull InterfaceC0679f8 result) throws JSONException {
        String str2;
        Bitmap bitmap;
        String str3;
        String str4;
        List arrayList;
        Integer num;
        int i;
        U4 u4A;
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(result, "result");
        Bitmap screenshot = result.a((View) root);
        if (context.e.contains(0)) {
            C0635b4 c0635b4 = this.j;
            Rect scrollContainerRect = context.d;
            c0635b4.getClass();
            Intrinsics.checkNotNullParameter(screenshot, "screenshot");
            Intrinsics.checkNotNullParameter(scrollContainerRect, "scrollContainerRect");
            c0635b4.a(screenshot, new Rect(0, 0, screenshot.getWidth(), scrollContainerRect.top));
            C0634b3 c0634b3 = this.k;
            Rect scrollContainerRect2 = context.d;
            c0634b3.getClass();
            Intrinsics.checkNotNullParameter(screenshot, "screenshot");
            Intrinsics.checkNotNullParameter(scrollContainerRect2, "scrollContainerRect");
            Rect rect = new Rect(0, 0, screenshot.getWidth(), scrollContainerRect2.top);
            c0634b3.a(screenshot, rect);
            c0634b3.b = rect.height() + c0634b3.b;
        }
        C0635b4 c0635b42 = this.j;
        Rect pageRect = context.i;
        c0635b42.getClass();
        Intrinsics.checkNotNullParameter(screenshot, "screenshot");
        Intrinsics.checkNotNullParameter(pageRect, "pageRect");
        c0635b42.a(screenshot, new Rect(0, pageRect.top, screenshot.getWidth(), pageRect.bottom));
        this.k.b(screenshot, context.i);
        if (this.m == null) {
            AbstractC0844w5 abstractC0844w5 = context.h;
            AbstractC0844w5.b bVar = abstractC0844w5 instanceof AbstractC0844w5.b ? (AbstractC0844w5.b) abstractC0844w5 : null;
            if (bVar == null) {
                throw new IllegalStateException("context.config should be ScrollableSnapshotConfig.LongVertical!");
            }
            View view = bVar.a;
            String strC = c();
            str3 = "scrollContainerRect";
            bitmap = screenshot;
            str4 = "<set-?>";
            str2 = "screenshot";
            U4 u4A2 = this.f.a(root, ((C0723k2) this.b).f, this.e, result, new W4(root, false), this.i, new a(view, this));
            u4A2.a = str;
            Intrinsics.checkNotNullParameter(strC, str4);
            u4A2.b = strC;
            this.m = u4A2;
        } else {
            str2 = "screenshot";
            bitmap = screenshot;
            str3 = "scrollContainerRect";
            str4 = "<set-?>";
        }
        C0634b3 c0634b32 = this.k;
        c0634b32.getClass();
        Bitmap bitmap2 = c0634b32.a;
        Intrinsics.checkNotNull(bitmap2);
        C0719j8 viewBitmapProviderResult = new C0719j8(bitmap2, c0634b32.c);
        List<View> itemViews = context.c;
        Intrinsics.checkNotNullParameter(viewBitmapProviderResult, "result");
        Intrinsics.checkNotNullParameter(itemViews, "itemViews");
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(itemViews, 10));
        for (View view2 : itemViews) {
            if (view2 instanceof ViewGroup) {
                u4A = this.f.a((ViewGroup) view2, ((C0723k2) this.b).f, this.e, viewBitmapProviderResult, new W4(view2, false), this.i, I7.a);
            } else {
                H7 h7 = this.f;
                CustomVar[] cVars = ((C0723k2) this.b).f;
                W4 screenGraphParameters = new W4(view2, false);
                h7.getClass();
                Intrinsics.checkNotNullParameter(view2, "view");
                Intrinsics.checkNotNullParameter(cVars, "cVars");
                Intrinsics.checkNotNullParameter(viewBitmapProviderResult, "viewBitmapProviderResult");
                Intrinsics.checkNotNullParameter(screenGraphParameters, "screenGraphParameters");
                U4 u4 = new U4();
                List<G2> listListOf = CollectionsKt.listOf(H2.a(view2, viewBitmapProviderResult, screenGraphParameters, h7.b.get()));
                Intrinsics.checkNotNullParameter(listListOf, str4);
                u4.d = listListOf;
                Intrinsics.checkNotNullParameter(cVars, str4);
                u4.c = cVars;
                u4A = u4;
            }
            arrayList2.add(u4A);
        }
        List itemGraphs = CollectionsKt.toList(arrayList2);
        U4 current = this.m;
        if (current != null && this.n != null) {
            Intrinsics.checkNotNull(current);
            G2 recyclerView = this.n;
            Intrinsics.checkNotNull(recyclerView);
            int i2 = this.k.d;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(current, "current");
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(itemGraphs, "itemGraphs");
            if (context.e.contains(0)) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                recyclerView.c = CollectionsKt.emptyList();
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(itemGraphs, "itemGraphs");
            List<G2> list = recyclerView.c;
            if (list == null || (arrayList = CollectionsKt.toMutableList((Collection) list)) == null) {
                arrayList = new ArrayList();
            }
            ArrayList items = new ArrayList();
            Iterator it = itemGraphs.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(items, ((U4) it.next()).d);
            }
            Intrinsics.checkNotNullParameter(items, "items");
            Iterator it2 = items.iterator();
            while (it2.hasNext()) {
                G2 g2 = (G2) it2.next();
                JSONObject jSONObject = g2.f;
                jSONObject.put("y", jSONObject.getInt("y") + i2);
                List<G2> list2 = g2.c;
                if (list2 != null) {
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    Iterator<T> it3 = list2.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(a((G2) it3.next()));
                    }
                    List listFlatten = CollectionsKt.flatten(arrayList3);
                    if (listFlatten != null) {
                        Iterator it4 = listFlatten.iterator();
                        while (it4.hasNext()) {
                            JSONObject jSONObject2 = ((G2) it4.next()).f;
                            jSONObject2.put("y", jSONObject2.getInt("y") + i2);
                        }
                    }
                }
            }
            arrayList.addAll(items);
            recyclerView.c = arrayList;
            this.m = current;
            Iterator<T> it5 = context.b.iterator();
            if (it5.hasNext()) {
                Integer numValueOf = Integer.valueOf(((Rect) it5.next()).bottom);
                loop5: while (true) {
                    num = numValueOf;
                    while (it5.hasNext()) {
                        numValueOf = Integer.valueOf(((Rect) it5.next()).bottom);
                        if (num.compareTo(numValueOf) < 0) {
                            break;
                        }
                    }
                }
            } else {
                num = null;
            }
            if (num != null) {
                this.k.a(num.intValue());
            }
            if (context.e.contains(Integer.valueOf(context.f - 1))) {
                C0635b4 c0635b43 = this.j;
                Rect rect2 = context.d;
                c0635b43.getClass();
                Bitmap bitmap3 = bitmap;
                Intrinsics.checkNotNullParameter(bitmap3, str2);
                Intrinsics.checkNotNullParameter(rect2, str3);
                c0635b43.a(bitmap3, new Rect(0, rect2.bottom, bitmap3.getWidth(), bitmap3.getHeight()));
                Bitmap bitmap4 = this.j.c;
                U4 screenGraph = this.m;
                if (screenGraph != null && bitmap4 != null) {
                    Intrinsics.checkNotNull(screenGraph);
                    Intrinsics.checkNotNullParameter(screenGraph, "screenGraph");
                    Intrinsics.checkNotNullParameter(bitmap4, str2);
                    String strEncodeToString = "";
                    if (this.e.b()) {
                        C0699h8.a aVar = new C0699h8.a(bitmap4, false);
                        K1 k1 = this.e;
                        Intrinsics.checkNotNullParameter(bitmap4, "bitmap");
                        if (bitmap4.getHeight() > 0 && bitmap4.getWidth() > 0) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            bitmap4.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                            byte[] imageByteArray = byteArrayOutputStream.toByteArray();
                            Intrinsics.checkNotNullExpressionValue(imageByteArray, "stream.toByteArray()");
                            Intrinsics.checkNotNullParameter(imageByteArray, "imageByteArray");
                            String strEncodeToString2 = Base64.encodeToString(imageByteArray, 2);
                            Intrinsics.checkNotNullExpressionValue(strEncodeToString2, "encodeToString(imageByteArray, Base64.NO_WRAP)");
                            strEncodeToString = strEncodeToString2;
                        }
                        k1.a(screenGraph, strEncodeToString, aVar, this.h, this.a);
                        i = 0;
                    } else {
                        this.a.tryEmit(Z4.g.a);
                        N0 n0 = this.h;
                        Intrinsics.checkNotNullParameter(bitmap4, "bitmap");
                        if (bitmap4.getHeight() > 0 && bitmap4.getWidth() > 0) {
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            bitmap4.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
                            byte[] imageByteArray2 = byteArrayOutputStream2.toByteArray();
                            Intrinsics.checkNotNullExpressionValue(imageByteArray2, "stream.toByteArray()");
                            Intrinsics.checkNotNullParameter(imageByteArray2, "imageByteArray");
                            strEncodeToString = Base64.encodeToString(imageByteArray2, 2);
                            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(imageByteArray, Base64.NO_WRAP)");
                        }
                        i = 0;
                        n0.a(screenGraph, strEncodeToString, false);
                    }
                    this.c = null;
                    this.d = null;
                    this.m = null;
                    this.n = null;
                    C0635b4 c0635b44 = this.j;
                    c0635b44.c = null;
                    c0635b44.d = i;
                    c0635b44.a = i;
                    c0635b44.b = i;
                    C0634b3 c0634b33 = this.k;
                    c0634b33.a = null;
                    c0634b33.b = i;
                    c0634b33.c = i;
                    c0634b33.d = i;
                    return;
                }
                throw new IllegalStateException("Invalid screen graph");
            }
            return;
        }
        throw new IllegalStateException("Invalid item screen graph");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.annotation.VisibleForTesting(otherwise = 4)
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull com.contentsquare.android.sdk.AbstractC0657d6.d r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.contentsquare.android.sdk.C0629a8.b
            if (r0 == 0) goto L13
            r0 = r9
            com.contentsquare.android.sdk.a8$b r0 = (com.contentsquare.android.sdk.C0629a8.b) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.a8$b r0 = new com.contentsquare.android.sdk.a8$b
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            android.view.ViewGroup r7 = r0.c
            com.contentsquare.android.sdk.d6$d r8 = r0.b
            com.contentsquare.android.sdk.a8 r0 = r0.a
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
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0629a8.a(com.contentsquare.android.sdk.d6$d, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
