package com.contentsquare.android.sdk;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.sdk.AbstractC0657d6;
import com.contentsquare.android.sdk.C4;
import com.contentsquare.android.sdk.Z4;
import com.google.mlkit.common.MlKitException;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nRecyclerViewCaptureUseCase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecyclerViewCaptureUseCase.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/overlay/captureusecase/RecyclerViewCaptureUseCase\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,303:1\n1549#2:304\n1620#2,3:305\n1549#2:308\n1620#2,3:309\n1549#2:312\n1620#2,3:313\n658#3:316\n739#3,4:317\n1#4:321\n*S KotlinDebug\n*F\n+ 1 RecyclerViewCaptureUseCase.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/overlay/captureusecase/RecyclerViewCaptureUseCase\n*L\n174#1:304\n174#1:305,3\n175#1:308\n175#1:309,3\n176#1:312\n176#1:313,3\n241#1:316\n241#1:317,4\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.v4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0834v4 {

    @NotNull
    public static final Logger i = new Logger("RecyclerViewCaptureUseCase");

    @NotNull
    public final C0629a8 a;

    @NotNull
    public final C4 b;

    @NotNull
    public final C0667e6 c;

    @NotNull
    public final PreferencesStore d;

    @Nullable
    public C4.a e;

    @NotNull
    public final ArrayList f;

    @NotNull
    public Map<Integer, Integer> g;

    @NotNull
    public final int[] h;

    /* renamed from: com.contentsquare.android.sdk.v4$a */
    public static final class a {

        @NotNull
        public final View a;
        public final int b;

        @NotNull
        public final Rect c;

        public a(@NotNull View view, int i, @NotNull Rect bounds) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            this.a = view;
            this.b = i;
            this.c = bounds;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && this.b == aVar.b && Intrinsics.areEqual(this.c, aVar.c);
        }

        public final int hashCode() {
            return this.c.hashCode() + ((Integer.hashCode(this.b) + (this.a.hashCode() * 31)) * 31);
        }

        @NotNull
        public final String toString() {
            return "ItemView(view=" + this.a + ", indexInParent=" + this.b + ", bounds=" + this.c + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.RecyclerViewCaptureUseCase", f = "RecyclerViewCaptureUseCase.kt", i = {0, 0, 0, 1}, l = {MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED, 210}, m = "onScrollCalculated", n = {"this", "itemIndexes", "context", "itemIndexes"}, s = {"L$0", "L$1", "L$2", "L$0"})
    /* renamed from: com.contentsquare.android.sdk.v4$b */
    public static final class b extends ContinuationImpl {
        public Object a;
        public ArrayList b;
        public AbstractC0657d6.d c;
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
            return C0834v4.this.a(null, null, null, null, 0, this);
        }
    }

    /* renamed from: com.contentsquare.android.sdk.v4$c */
    public static final class c extends Lambda implements Function0<Unit> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            C0834v4.this.a.a.tryEmit(Z4.d.a);
            return Unit.INSTANCE;
        }
    }

    public C0834v4(@NotNull C0629a8 verticalRecyclerViewScreenRecorder, @NotNull C4 recyclerViewScroller, @NotNull C0667e6 snapshotPausingController, @NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(verticalRecyclerViewScreenRecorder, "verticalRecyclerViewScreenRecorder");
        Intrinsics.checkNotNullParameter(recyclerViewScroller, "recyclerViewScroller");
        Intrinsics.checkNotNullParameter(snapshotPausingController, "snapshotPausingController");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        this.a = verticalRecyclerViewScreenRecorder;
        this.b = recyclerViewScroller;
        this.c = snapshotPausingController;
        this.d = preferencesStore;
        this.f = new ArrayList();
        this.g = MapsKt.emptyMap();
        this.h = new int[2];
    }

    public static final void a(C0834v4 c0834v4) {
        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        c0834v4.getClass();
        i.d("restoring initial position");
        C4 c4 = c0834v4.b;
        C4.a aVar = c0834v4.e;
        c4.getClass();
        if ((aVar != null ? aVar.b : null) != null && (recyclerView = aVar.a.get()) != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
            layoutManager.onRestoreInstanceState(aVar.b);
        }
        c0834v4.e = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00a0 -> B:17:0x0069). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00bc -> B:17:0x0069). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(com.contentsquare.android.sdk.C0834v4 r13, com.contentsquare.android.sdk.AbstractC0844w5 r14, java.lang.String r15, androidx.recyclerview.widget.RecyclerView r16, android.graphics.Rect r17, int r18, int r19, kotlin.coroutines.Continuation r20) {
        /*
            r0 = r20
            r13.getClass()
            boolean r1 = r0 instanceof com.contentsquare.android.sdk.A4
            if (r1 == 0) goto L19
            r1 = r0
            com.contentsquare.android.sdk.A4 r1 = (com.contentsquare.android.sdk.A4) r1
            int r2 = r1.j
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L19
            int r2 = r2 - r3
            r1.j = r2
            r2 = r13
            goto L1f
        L19:
            com.contentsquare.android.sdk.A4 r1 = new com.contentsquare.android.sdk.A4
            r2 = r13
            r1.<init>(r13, r0)
        L1f:
            java.lang.Object r0 = r1.h
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.j
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L5b
            if (r4 == r6) goto L49
            if (r4 != r5) goto L41
            int r2 = r1.g
            int r4 = r1.f
            android.graphics.Rect r7 = r1.e
            androidx.recyclerview.widget.RecyclerView r8 = r1.d
            java.lang.String r9 = r1.c
            com.contentsquare.android.sdk.w5 r10 = r1.b
            com.contentsquare.android.sdk.v4 r11 = r1.a
            kotlin.ResultKt.throwOnFailure(r0)
            goto L69
        L41:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L49:
            int r2 = r1.g
            int r4 = r1.f
            android.graphics.Rect r7 = r1.e
            androidx.recyclerview.widget.RecyclerView r8 = r1.d
            java.lang.String r9 = r1.c
            com.contentsquare.android.sdk.w5 r10 = r1.b
            com.contentsquare.android.sdk.v4 r11 = r1.a
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
            java.util.ArrayList r0 = r11.f
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Lbf
            r1.a = r11
            r1.b = r10
            r1.c = r9
            r1.d = r8
            r1.e = r7
            r1.f = r4
            r1.g = r2
            r1.j = r6
            r13 = r11
            r14 = r10
            r15 = r8
            r16 = r9
            r17 = r7
            r18 = r4
            r19 = r1
            java.lang.Object r0 = r13.a(r14, r15, r16, r17, r18, r19)
            if (r0 != r3) goto L93
            goto Lc1
        L93:
            java.util.List r0 = (java.util.List) r0
            java.util.ArrayList r12 = r11.f
            r12.removeAll(r0)
            java.util.ArrayList r0 = r11.f
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L69
            com.contentsquare.android.sdk.C4 r0 = r11.b
            int r12 = r7.height()
            r1.a = r11
            r1.b = r10
            r1.c = r9
            r1.d = r8
            r1.e = r7
            r1.f = r4
            r1.g = r2
            r1.j = r5
            java.lang.Object r0 = r0.a(r8, r12, r2, r1)
            if (r0 != r3) goto L69
            goto Lc1
        Lbf:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        Lc1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0834v4.a(com.contentsquare.android.sdk.v4, com.contentsquare.android.sdk.w5, java.lang.String, androidx.recyclerview.widget.RecyclerView, android.graphics.Rect, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @VisibleForTesting
    public static int a(@NotNull RecyclerView scrollContainer) {
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

    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    @androidx.annotation.VisibleForTesting
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull com.contentsquare.android.sdk.AbstractC0844w5 r18, @org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView r19, @org.jetbrains.annotations.NotNull java.lang.String r20, @org.jetbrains.annotations.NotNull android.graphics.Rect r21, int r22, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<java.lang.Integer>> r23) {
        /*
            Method dump skipped, instructions count: 635
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0834v4.a(com.contentsquare.android.sdk.w5, androidx.recyclerview.widget.RecyclerView, java.lang.String, android.graphics.Rect, int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
