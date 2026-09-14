package com.contentsquare.android.sdk;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.google.mlkit.common.MlKitException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.v4 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nRecyclerViewCaptureUseCase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecyclerViewCaptureUseCase.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/overlay/captureusecase/RecyclerViewCaptureUseCase\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,303:1\n1549#2:304\n1620#2,3:305\n1549#2:308\n1620#2,3:309\n1549#2:312\n1620#2,3:313\n658#3:316\n739#3,4:317\n1#4:321\n*S KotlinDebug\n*F\n+ 1 RecyclerViewCaptureUseCase.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/overlay/captureusecase/RecyclerViewCaptureUseCase\n*L\n174#1:304\n174#1:305,3\n175#1:308\n175#1:309,3\n176#1:312\n176#1:313,3\n241#1:316\n241#1:317,4\n*E\n"})
public final class C2905v4 {

    /* JADX INFO: renamed from: i */
    @NotNull
    public static final Logger f3173i = new Logger("RecyclerViewCaptureUseCase");

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2699a8 f3174a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2461C4 f3175b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final C2737e6 f3176c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final PreferencesStore f3177d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public C2461C4.a f3178e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final ArrayList f3179f;

    /* JADX INFO: renamed from: g */
    @NotNull
    public Map<Integer, Integer> f3180g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public final int[] f3181h;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.v4$a */
    public static final class a {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final View f3182a;

        /* JADX INFO: renamed from: b */
        public final int f3183b;

        /* JADX INFO: renamed from: c */
        @NotNull
        public final Rect f3184c;

        public a(@NotNull View view, int i, @NotNull Rect bounds) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            this.f3182a = view;
            this.f3183b = i;
            this.f3184c = bounds;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f3182a, aVar.f3182a) && this.f3183b == aVar.f3183b && Intrinsics.areEqual(this.f3184c, aVar.f3184c);
        }

        public final int hashCode() {
            return this.f3184c.hashCode() + ((Integer.hashCode(this.f3183b) + (this.f3182a.hashCode() * 31)) * 31);
        }

        @NotNull
        public final String toString() {
            return "ItemView(view=" + this.f3182a + ", indexInParent=" + this.f3183b + ", bounds=" + this.f3184c + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.v4$b */
    @DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.RecyclerViewCaptureUseCase", m1845f = "RecyclerViewCaptureUseCase.kt", m1846i = {0, 0, 0, 1}, m1847l = {MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED, 210}, m1848m = "onScrollCalculated", m1849n = {"this", "itemIndexes", "context", "itemIndexes"}, m1850s = {"L$0", "L$1", "L$2", "L$0"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        public Object f3185a;

        /* JADX INFO: renamed from: b */
        public ArrayList f3186b;

        /* JADX INFO: renamed from: c */
        public AbstractC2727d6.d f3187c;

        /* JADX INFO: renamed from: d */
        public /* synthetic */ Object f3188d;

        /* JADX INFO: renamed from: f */
        public int f3190f;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f3188d = obj;
            this.f3190f |= Integer.MIN_VALUE;
            return C2905v4.this.m1219a(null, null, null, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.v4$c */
    public static final class c extends Lambda implements Function0<Unit> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            C2905v4.this.f3174a.f2369a.tryEmit(AbstractC2686Z4.d.f2337a);
            return Unit.INSTANCE;
        }
    }

    public C2905v4(@NotNull C2699a8 verticalRecyclerViewScreenRecorder, @NotNull C2461C4 recyclerViewScroller, @NotNull C2737e6 snapshotPausingController, @NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(verticalRecyclerViewScreenRecorder, "verticalRecyclerViewScreenRecorder");
        Intrinsics.checkNotNullParameter(recyclerViewScroller, "recyclerViewScroller");
        Intrinsics.checkNotNullParameter(snapshotPausingController, "snapshotPausingController");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        this.f3174a = verticalRecyclerViewScreenRecorder;
        this.f3175b = recyclerViewScroller;
        this.f3176c = snapshotPausingController;
        this.f3177d = preferencesStore;
        this.f3179f = new ArrayList();
        this.f3180g = MapsKt.emptyMap();
        this.f3181h = new int[2];
    }

    /* JADX INFO: renamed from: a */
    public static final void m1218a(C2905v4 c2905v4) {
        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        c2905v4.getClass();
        f3173i.m827d("restoring initial position");
        C2461C4 c2461c4 = c2905v4.f3175b;
        C2461C4.a aVar = c2905v4.f3178e;
        c2461c4.getClass();
        if ((aVar != null ? aVar.f1463b : null) != null && (recyclerView = aVar.f1462a.get()) != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
            layoutManager.onRestoreInstanceState(aVar.f1463b);
        }
        c2905v4.f3178e = null;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0071  */
    /* JADX WARN: Code duplicated, block: B:24:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00a0 -> B:17:0x0069). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00bc -> B:17:0x0069). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: a */
    public static final java.lang.Object m1217a(com.contentsquare.android.sdk.C2905v4 r13, com.contentsquare.android.sdk.AbstractC2916w5 r14, java.lang.String r15, androidx.recyclerview.widget.RecyclerView r16, android.graphics.Rect r17, int r18, int r19, kotlin.coroutines.Continuation r20) {
        /*
            r0 = r20
            r13.getClass()
            boolean r1 = r0 instanceof com.contentsquare.android.sdk.C2441A4
            if (r1 == 0) goto L19
            r1 = r0
            com.contentsquare.android.sdk.A4 r1 = (com.contentsquare.android.sdk.C2441A4) r1
            int r2 = r1.f1399j
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L19
            int r2 = r2 - r3
            r1.f1399j = r2
            r2 = r13
            goto L1f
        L19:
            com.contentsquare.android.sdk.A4 r1 = new com.contentsquare.android.sdk.A4
            r2 = r13
            r1.<init>(r13, r0)
        L1f:
            java.lang.Object r0 = r1.f1397h
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.f1399j
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L5b
            if (r4 == r6) goto L49
            if (r4 != r5) goto L41
            int r2 = r1.f1396g
            int r4 = r1.f1395f
            android.graphics.Rect r7 = r1.f1394e
            androidx.recyclerview.widget.RecyclerView r8 = r1.f1393d
            java.lang.String r9 = r1.f1392c
            com.contentsquare.android.sdk.w5 r10 = r1.f1391b
            com.contentsquare.android.sdk.v4 r11 = r1.f1390a
            kotlin.ResultKt.throwOnFailure(r0)
            goto L69
        L41:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L49:
            int r2 = r1.f1396g
            int r4 = r1.f1395f
            android.graphics.Rect r7 = r1.f1394e
            androidx.recyclerview.widget.RecyclerView r8 = r1.f1393d
            java.lang.String r9 = r1.f1392c
            com.contentsquare.android.sdk.w5 r10 = r1.f1391b
            com.contentsquare.android.sdk.v4 r11 = r1.f1390a
            kotlin.ResultKt.throwOnFailure(r0)
            goto L93
        L5b:
            kotlin.ResultKt.throwOnFailure(r0)
            r10 = r14
            r9 = r15
            r8 = r16
            r7 = r17
            r4 = r18
            r11 = r2
            r2 = r19
        L69:
            java.util.ArrayList r0 = r11.f3179f
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Lbf
            r1.f1390a = r11
            r1.f1391b = r10
            r1.f1392c = r9
            r1.f1393d = r8
            r1.f1394e = r7
            r1.f1395f = r4
            r1.f1396g = r2
            r1.f1399j = r6
            r13 = r11
            r14 = r10
            r15 = r8
            r16 = r9
            r17 = r7
            r18 = r4
            r19 = r1
            java.lang.Object r0 = r13.m1219a(r14, r15, r16, r17, r18, r19)
            if (r0 != r3) goto L93
            goto Lc1
        L93:
            java.util.List r0 = (java.util.List) r0
            java.util.ArrayList r12 = r11.f3179f
            r12.removeAll(r0)
            java.util.ArrayList r0 = r11.f3179f
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L69
            com.contentsquare.android.sdk.C4 r0 = r11.f3175b
            int r12 = r7.height()
            r1.f1390a = r11
            r1.f1391b = r10
            r1.f1392c = r9
            r1.f1393d = r8
            r1.f1394e = r7
            r1.f1395f = r4
            r1.f1396g = r2
            r1.f1399j = r5
            java.lang.Object r0 = r0.m883a(r8, r12, r2, r1)
            if (r0 != r3) goto L69
            goto Lc1
        Lbf:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        Lc1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C2905v4.m1217a(com.contentsquare.android.sdk.v4, com.contentsquare.android.sdk.w5, java.lang.String, androidx.recyclerview.widget.RecyclerView, android.graphics.Rect, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: a */
    public static int m1216a(@NotNull RecyclerView scrollContainer) {
        Intrinsics.checkNotNullParameter(scrollContainer, "scrollContainer");
        RecyclerView.LayoutManager layoutManager = scrollContainer.getLayoutManager();
        if (layoutManager != null) {
            if (layoutManager instanceof LinearLayoutManager) {
                return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            }
            float right = scrollContainer.getRight();
            float bottom = right / scrollContainer.getBottom();
            View viewFindChildViewUnder = null;
            for (int bottom2 = scrollContainer.getBottom(); -1 < bottom2 && (viewFindChildViewUnder = scrollContainer.findChildViewUnder(right, bottom2)) == null; bottom2--) {
                right -= bottom;
            }
            if (viewFindChildViewUnder != null) {
                RecyclerView.ViewHolder viewHolderFindContainingViewHolder = scrollContainer.findContainingViewHolder(viewFindChildViewUnder);
                Integer numValueOf = viewHolderFindContainingViewHolder != null ? Integer.valueOf(viewHolderFindContainingViewHolder.getLayoutPosition()) : null;
                if (numValueOf != null) {
                    return numValueOf.intValue();
                }
            }
            return -1;
        }
        throw new IllegalStateException("RecyclerView should have a LayoutManager");
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    @VisibleForTesting
    @Nullable
    /* JADX INFO: renamed from: a */
    public final Object m1219a(@NotNull AbstractC2916w5 abstractC2916w5, @NotNull RecyclerView scrollContainer, @NotNull String str, @NotNull Rect scrollRect, int i, @NotNull Continuation<? super List<Integer>> continuation) {
        b bVar;
        Rect rect;
        AbstractC2727d6.d dVar;
        ArrayList arrayList;
        Integer numValueOf;
        C2905v4 c2905v4 = this;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i2 = bVar.f3190f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                bVar.f3190f = i2 - Integer.MIN_VALUE;
            } else {
                bVar = c2905v4.new b(continuation);
            }
        } else {
            bVar = c2905v4.new b(continuation);
        }
        b bVar2 = bVar;
        Object obj = bVar2.f3188d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = bVar2.f3190f;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Intrinsics.checkNotNullParameter(scrollContainer, "recyclerView");
            Intrinsics.checkNotNullParameter(scrollRect, "scrollContainerVisibleRect");
            List list = SequencesKt.toList(SequencesKt.filter(SequencesKt.filter(SequencesKt.map(ViewGroupKt.getChildren(scrollContainer), new C2925x4(c2905v4, scrollContainer)), new C2935y4(c2905v4)), new C2945z4(scrollRect)));
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(((a) it.next()).f3182a);
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList3.add(Boxing.boxInt(((a) it2.next()).f3183b));
            }
            ArrayList itemRectangles = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                itemRectangles.add(((a) it3.next()).f3184c);
            }
            int size = i - c2905v4.f3179f.size();
            Logger logger = f3173i;
            logger.m827d("processed items: " + size + " of " + i);
            StringBuilder sb = new StringBuilder("items on this page: ");
            sb.append(arrayList3);
            logger.m827d(sb.toString());
            boolean zContains = arrayList3.contains(Boxing.boxInt(i + (-1)));
            Intrinsics.checkNotNullParameter(scrollContainer, "scrollContainer");
            Intrinsics.checkNotNullParameter(scrollRect, "scrollRect");
            Intrinsics.checkNotNullParameter(itemRectangles, "itemRectangles");
            Sequence<View> children = ViewGroupKt.getChildren(scrollContainer);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (View view : children) {
                int childAdapterPosition = scrollContainer.getChildAdapterPosition(view);
                view.getLocationOnScreen(c2905v4.f3181h);
                Pair pairM1842to = TuplesKt.m1842to(Integer.valueOf(childAdapterPosition), Integer.valueOf(c2905v4.f3181h[1]));
                linkedHashMap.put(pairM1842to.getFirst(), pairM1842to.getSecond());
            }
            Map<Integer, Integer> map = c2905v4.f3180g;
            int iHeight = scrollRect.height();
            Integer num = (Integer) CollectionsKt.firstOrNull(CollectionsKt.intersect(linkedHashMap.keySet(), map.keySet()));
            if (num != null) {
                Integer num2 = map.get(num);
                if (num2 != null) {
                    iHeight = num2.intValue();
                }
                Integer num3 = (Integer) linkedHashMap.get(num);
                iHeight -= num3 != null ? num3.intValue() : 0;
            }
            f3173i.m827d("scrolledBy: " + iHeight);
            c2905v4.f3180g = linkedHashMap;
            if (zContains) {
                Rect rect2 = new Rect(scrollRect);
                rect2.top = rect2.bottom - iHeight;
                Iterator it4 = itemRectangles.iterator();
                if (it4.hasNext()) {
                    numValueOf = Integer.valueOf(((Rect) it4.next()).bottom);
                    while (it4.hasNext()) {
                        Integer numValueOf2 = Integer.valueOf(((Rect) it4.next()).bottom);
                        if (numValueOf.compareTo(numValueOf2) < 0) {
                            numValueOf = numValueOf2;
                        }
                    }
                } else {
                    numValueOf = null;
                }
                int iMin = Math.min(rect2.bottom, numValueOf != null ? numValueOf.intValue() : rect2.bottom);
                rect2.bottom = iMin;
                rect2.top = Math.min(rect2.top, iMin);
                rect = rect2;
            } else {
                rect = scrollRect;
            }
            f3173i.m827d("pageRect: " + rect);
            arrayList = arrayList3;
            dVar = new AbstractC2727d6.d(str, itemRectangles, arrayList2, scrollRect, arrayList3, i, size, abstractC2916w5, rect);
            C2737e6 c2737e6 = c2905v4.f3176c;
            c cVar = c2905v4.new c();
            bVar2.f3185a = c2905v4;
            bVar2.f3186b = arrayList;
            bVar2.f3187c = dVar;
            bVar2.f3190f = 1;
            if (c2737e6.m1123a(cVar, bVar2) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                List list2 = (List) bVar2.f3185a;
                ResultKt.throwOnFailure(obj);
                return list2;
            }
            AbstractC2727d6.d dVar2 = bVar2.f3187c;
            ArrayList arrayList4 = bVar2.f3186b;
            C2905v4 c2905v5 = (C2905v4) bVar2.f3185a;
            ResultKt.throwOnFailure(obj);
            dVar = dVar2;
            arrayList = arrayList4;
            c2905v4 = c2905v5;
        }
        c2905v4.f3174a.f2369a.tryEmit(new AbstractC2686Z4.e(dVar.f2517g, dVar.f2516f));
        C2699a8 c2699a8 = c2905v4.f3174a;
        bVar2.f3185a = arrayList;
        bVar2.f3186b = null;
        bVar2.f3187c = null;
        bVar2.f3190f = 2;
        return c2699a8.m1086a(dVar, (Continuation<? super Unit>) bVar2) == coroutine_suspended ? coroutine_suspended : arrayList;
    }
}
