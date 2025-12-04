package com.contentsquare.android.sdk;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.ExtensionsKt;
import com.contentsquare.android.sdk.AbstractC0657d6;
import com.contentsquare.android.sdk.AbstractC0844w5;
import com.contentsquare.android.sdk.C0699h8;
import com.contentsquare.android.sdk.Z4;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.bouncycastle.asn1.eac.EACTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@SourceDebugExtension({"SMAP\nVerticalScrollViewScreenRecorder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerticalScrollViewScreenRecorder.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/VerticalScrollViewScreenRecorder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,251:1\n1#2:252\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.d8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0659d8 extends AbstractC0626a5<AbstractC0657d6.e> {

    @NotNull
    public final X2 e;

    @NotNull
    public final K1 f;

    @NotNull
    public final H7 g;

    @NotNull
    public final C0669e8 h;

    @NotNull
    public final N0 i;

    @NotNull
    public final C0726k5 j;

    @NotNull
    public final P4<J> k;

    @NotNull
    public final Function2<View, InterfaceC0679f8, AbstractC0645c4> l;

    @NotNull
    public final Logger m;

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.screencapture.screenrecorder.VerticalScrollViewScreenRecorder", f = "VerticalScrollViewScreenRecorder.kt", i = {0, 0, 0}, l = {EACTags.DISPLAY_IMAGE}, m = "runRecorder", n = {"this", "context", "root"}, s = {"L$0", "L$1", "L$2"})
    /* renamed from: com.contentsquare.android.sdk.d8$a */
    public static final class a extends ContinuationImpl {
        public C0659d8 a;
        public AbstractC0657d6.e b;
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
            return C0659d8.this.a((AbstractC0657d6.e) null, (Continuation<? super Unit>) this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0659d8(@NotNull MutableStateFlow snapshotStateFlow, @NotNull X2 pauseStateGetter, @NotNull K1 externalViewsProcessor, @NotNull H7 treeTraverser, @NotNull C0669e8 viewBitmapProviderFactory, @NotNull Z0 callback, @NotNull InterfaceC0832v2 glassPane, @NotNull C0726k5 screenWiseGraphHelper, @NotNull Z7 screenAppendStrategy, @NotNull C0830v0 composeScreenGraphGenerator) {
        super(snapshotStateFlow, glassPane);
        Intrinsics.checkNotNullParameter(snapshotStateFlow, "snapshotStateFlow");
        Intrinsics.checkNotNullParameter(pauseStateGetter, "pauseStateGetter");
        Intrinsics.checkNotNullParameter(externalViewsProcessor, "externalViewsProcessor");
        Intrinsics.checkNotNullParameter(treeTraverser, "treeTraverser");
        Intrinsics.checkNotNullParameter(viewBitmapProviderFactory, "viewBitmapProviderFactory");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(glassPane, "glassPane");
        Intrinsics.checkNotNullParameter(screenWiseGraphHelper, "screenWiseGraphHelper");
        Intrinsics.checkNotNullParameter(screenAppendStrategy, "screenAppendStrategy");
        Intrinsics.checkNotNullParameter(composeScreenGraphGenerator, "composeScreenGraphGenerator");
        this.e = pauseStateGetter;
        this.f = externalViewsProcessor;
        this.g = treeTraverser;
        this.h = viewBitmapProviderFactory;
        this.i = callback;
        this.j = screenWiseGraphHelper;
        this.k = screenAppendStrategy;
        this.l = composeScreenGraphGenerator;
        this.m = new Logger("VerticalScrollViewScreenRecorder");
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    public final void a(AbstractC0657d6 abstractC0657d6) {
        AbstractC0657d6.e context = (AbstractC0657d6.e) abstractC0657d6;
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual(this.c, context.a)) {
            return;
        }
        this.d = null;
        this.c = context.a;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    public final boolean b(AbstractC0657d6 abstractC0657d6) {
        AbstractC0657d6.e context = (AbstractC0657d6.e) abstractC0657d6;
        Intrinsics.checkNotNullParameter(context, "context");
        return context.d == 0;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    public final void e() {
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    public final /* bridge */ /* synthetic */ Object b(AbstractC0657d6 abstractC0657d6, Continuation continuation) {
        return a((AbstractC0657d6.e) abstractC0657d6, (Continuation<? super Unit>) continuation);
    }

    @Override // com.contentsquare.android.sdk.AbstractC0626a5
    @NotNull
    public final Logger a() {
        return this.m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @VisibleForTesting
    public final void a(@NotNull ViewGroup root, @Nullable String str, @NotNull AbstractC0657d6.e context, @NotNull InterfaceC0679f8 result) throws JSONException {
        boolean z;
        int i;
        Object obj;
        int childCount;
        JSONObject jSONObject;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(result, "result");
        Bitmap bitmap = this.d;
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(result, "result");
        Bitmap bitmapA = result.a((View) root);
        if (context.f instanceof AbstractC0844w5.b) {
            int i2 = context.e;
            if (i2 != 1) {
                P4<J> p4 = this.k;
                Rect rect = context.c;
                int i3 = context.b.y;
                int i4 = context.d;
                bitmapA = p4.a(bitmap, bitmapA, new J(rect, i3, i2, i4 == 0, i2 == i4 + 1));
            }
            this.d = bitmapA;
            if (this.e.a.a.get()) {
                this.a.tryEmit(Z4.d.a);
            } else {
                this.a.tryEmit(new Z4.e(context.d, context.e));
            }
            if (context.e == context.d + 1) {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                C0639b8 c0639b8 = new C0639b8(context, objectRef);
                String strC = c();
                U4 fullScreenGraph = this.g.a(root, ((C0723k2) this.b).f, this.f, result, new W4(root, false), this.l, c0639b8);
                fullScreenGraph.a = str;
                Intrinsics.checkNotNullParameter(strC, "<set-?>");
                fullScreenGraph.b = strC;
                Bitmap bitmap2 = this.d;
                if (bitmap2 == null) {
                    throw new IllegalStateException("Merged screenshot missing");
                }
                C0699h8.a aVar = new C0699h8.a(bitmap2, true);
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                View viewA = context.f.a();
                ViewGroup viewGroup = viewA instanceof ViewGroup ? (ViewGroup) viewA : null;
                if (viewGroup == null) {
                    viewGroup = root;
                }
                C0649c8 c0649c8 = new C0649c8(context, objectRef2);
                String strC2 = c();
                U4 u4A = this.g.a(viewGroup, ((C0723k2) this.b).f, this.f, aVar, new W4(viewGroup, false), this.l, c0649c8);
                u4A.a = str;
                Intrinsics.checkNotNullParameter(strC2, "<set-?>");
                u4A.b = strC2;
                if (objectRef.element == 0) {
                    View viewA2 = context.f.a();
                    ViewGroup viewGroup2 = viewA2 instanceof ViewGroup ? (ViewGroup) viewA2 : null;
                    if (viewGroup2 != null && (childCount = viewGroup2.getChildCount()) != 0) {
                        if (childCount == 1) {
                            View childAt = viewGroup2.getChildAt(0);
                            G2 replacement = u4A.d.size() == 1 ? u4A.d.get(0) : null;
                            if ((childAt instanceof ViewGroup) || replacement == null || (jSONObject = replacement.b) == null || !jSONObject.has("fullpath")) {
                                throw new IllegalStateException("Invalid single child snapshot");
                            }
                            this.j.getClass();
                            Intrinsics.checkNotNullParameter(fullScreenGraph, "fullScreenGraph");
                            Intrinsics.checkNotNullParameter(replacement, "replacement");
                            String stringOrNull = ExtensionsKt.getStringOrNull(replacement.b, "fullpath");
                            if (stringOrNull != null) {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.addAll(fullScreenGraph.d);
                                boolean z2 = false;
                                while (!arrayList2.isEmpty() && !z2) {
                                    G2 g2 = (G2) arrayList2.remove(0);
                                    List<G2> list = g2.c;
                                    if (list != null) {
                                        for (G2 g22 : list) {
                                            if (Intrinsics.areEqual(stringOrNull, ExtensionsKt.getStringOrNull(g22.b, "fullpath"))) {
                                                List<G2> list2 = g2.c;
                                                if (list2 != null) {
                                                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                                                    for (G2 g23 : list2) {
                                                        if (Intrinsics.areEqual(g23, g22)) {
                                                            g23 = replacement;
                                                        }
                                                        arrayList.add(g23);
                                                    }
                                                } else {
                                                    arrayList = null;
                                                }
                                                g2.c = arrayList;
                                                z2 = true;
                                            }
                                            arrayList2.add(g22);
                                        }
                                    }
                                }
                            }
                            a(fullScreenGraph, bitmap2);
                            return;
                        }
                        throw new IllegalStateException("Invalid scroll container content");
                    }
                } else if (this.d != null && objectRef2.element != 0) {
                    C0726k5 c0726k5 = this.j;
                    Rect rect2 = context.c;
                    int i5 = context.b.y;
                    int i6 = context.e;
                    int i7 = context.d;
                    if (i7 == 0) {
                        i = 1;
                        z = true;
                    } else {
                        z = false;
                        i = 1;
                    }
                    J j = new J(rect2, i5, i6, z, i6 == i7 + i ? i : 0);
                    Rect rect3 = new Rect();
                    root.getGlobalVisibleRect(rect3);
                    Unit unit = Unit.INSTANCE;
                    Bitmap bitmap3 = this.d;
                    Intrinsics.checkNotNull(bitmap3);
                    T t = objectRef2.element;
                    Intrinsics.checkNotNull(t);
                    c0726k5.a(j, rect3, bitmap3, (G2) t);
                    T t2 = objectRef.element;
                    Intrinsics.checkNotNull(t2);
                    T t3 = objectRef2.element;
                    Intrinsics.checkNotNull(t3);
                    ((G2) t2).c = ((G2) t3).c;
                    C0726k5 c0726k52 = this.j;
                    T t4 = objectRef.element;
                    Intrinsics.checkNotNull(t4);
                    G2 containerViewJson = (G2) t4;
                    c0726k52.getClass();
                    Intrinsics.checkNotNullParameter(containerViewJson, "containerViewJson");
                    List<G2> list3 = containerViewJson.c;
                    if (list3 != null) {
                        Iterator<T> it = list3.iterator();
                        if (it.hasNext()) {
                            Object next = it.next();
                            if (it.hasNext()) {
                                G2 g24 = (G2) next;
                                int i8 = g24.f.getInt("height") + g24.f.getInt("y");
                                do {
                                    Object next2 = it.next();
                                    G2 g25 = (G2) next2;
                                    int i9 = g25.f.getInt("height") + g25.f.getInt("y");
                                    if (i8 < i9) {
                                        next = next2;
                                        i8 = i9;
                                    }
                                } while (it.hasNext());
                            }
                            obj = next;
                        } else {
                            obj = null;
                        }
                        G2 g26 = (G2) obj;
                        if (g26 != null) {
                            containerViewJson.f.put("height", (g26.f.getInt("height") + g26.f.getInt("y")) - containerViewJson.f.getInt("y"));
                        }
                    }
                } else {
                    throw new IllegalStateException("Invalid snapshot");
                }
                a(fullScreenGraph, bitmap2);
                return;
            }
            return;
        }
        throw new IllegalStateException(("SnapshotConfig not supported: " + context.f).toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull com.contentsquare.android.sdk.AbstractC0657d6.e r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.contentsquare.android.sdk.C0659d8.a
            if (r0 == 0) goto L13
            r0 = r9
            com.contentsquare.android.sdk.d8$a r0 = (com.contentsquare.android.sdk.C0659d8.a) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.d8$a r0 = new com.contentsquare.android.sdk.d8$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            android.view.ViewGroup r7 = r0.c
            com.contentsquare.android.sdk.d6$e r8 = r0.b
            com.contentsquare.android.sdk.d8 r0 = r0.a
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
            com.contentsquare.android.sdk.e8 r2 = r7.h
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
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0659d8.a(com.contentsquare.android.sdk.d6$e, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void a(U4 u4, Bitmap bitmap) {
        String strEncodeToString = "";
        if (this.f.b()) {
            C0699h8.a aVar = new C0699h8.a(bitmap, false);
            K1 k1 = this.f;
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
            k1.a(u4, strEncodeToString, aVar, this.i, this.a);
            return;
        }
        this.a.tryEmit(Z4.g.a);
        N0 n0 = this.i;
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
