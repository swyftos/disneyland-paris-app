package com.urbanairship.embedded;

import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.joran.action.Action;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPurchaseStatus;
import com.urbanairship.UALog;
import com.urbanairship.android.layout.AirshipEmbeddedViewManager;
import com.urbanairship.android.layout.EmbeddedDisplayRequest;
import com.urbanairship.android.layout.EmbeddedDisplayRequestResult;
import com.urbanairship.android.layout.display.DisplayArgs;
import com.urbanairship.android.layout.info.LayoutInfo;
import com.urbanairship.json.JsonMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017H\u0016J\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u001cH\u0017J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J:\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001c2\u0006\u0010\u0010\u001a\u00020\u00052\u001a\u0010!\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010\"j\n\u0012\u0004\u0012\u00020#\u0018\u0001`$2\u0006\u0010%\u001a\u00020&H\u0017R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/urbanairship/embedded/EmbeddedViewManager;", "Lcom/urbanairship/android/layout/AirshipEmbeddedViewManager;", "()V", "lastViewed", "", "", "lastViewedLock", "Ljava/util/concurrent/locks/ReentrantLock;", ETCPurchaseStatus.PENDING, "", "Lcom/urbanairship/android/layout/EmbeddedDisplayRequest;", "viewsFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "addPending", "", "embeddedViewId", "viewInstanceId", Constants.FirelogAnalytics.PARAM_PRIORITY, "", "extras", "Lcom/urbanairship/json/JsonMap;", "layoutInfoProvider", "Lkotlin/Function0;", "Lcom/urbanairship/android/layout/info/LayoutInfo;", "displayArgsProvider", "Lcom/urbanairship/android/layout/display/DisplayArgs;", "allPending", "Lkotlinx/coroutines/flow/Flow;", "dismiss", "dismissAll", "displayRequests", "Lcom/urbanairship/android/layout/EmbeddedDisplayRequestResult;", "comparator", "Ljava/util/Comparator;", "Lcom/urbanairship/embedded/AirshipEmbeddedInfo;", "Lkotlin/Comparator;", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nEmbeddedViewManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EmbeddedViewManager.kt\ncom/urbanairship/embedded/EmbeddedViewManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 5 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,145:1\n819#2:146\n847#2,2:147\n49#3:149\n51#3:153\n49#3:154\n51#3:158\n46#4:150\n51#4:152\n46#4:155\n51#4:157\n105#5:151\n105#5:156\n*S KotlinDebug\n*F\n+ 1 EmbeddedViewManager.kt\ncom/urbanairship/embedded/EmbeddedViewManager\n*L\n77#1:146\n77#1:147,2\n106#1:149\n106#1:153\n127#1:154\n127#1:158\n106#1:150\n106#1:152\n127#1:155\n127#1:157\n106#1:151\n127#1:156\n*E\n"})
/* loaded from: classes5.dex */
public final class EmbeddedViewManager implements AirshipEmbeddedViewManager {

    @NotNull
    public static final EmbeddedViewManager INSTANCE = new EmbeddedViewManager();
    private static final Map pending = new LinkedHashMap();
    private static final MutableStateFlow viewsFlow = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
    private static final Map lastViewed = new LinkedHashMap();
    private static final ReentrantLock lastViewedLock = new ReentrantLock();

    private EmbeddedViewManager() {
    }

    @Override // com.urbanairship.android.layout.AirshipEmbeddedViewManager
    public void addPending(@NotNull final String embeddedViewId, @NotNull String viewInstanceId, int priority, @NotNull JsonMap extras, @NotNull Function0<LayoutInfo> layoutInfoProvider, @NotNull Function0<DisplayArgs> displayArgsProvider) {
        Intrinsics.checkNotNullParameter(embeddedViewId, "embeddedViewId");
        Intrinsics.checkNotNullParameter(viewInstanceId, "viewInstanceId");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(layoutInfoProvider, "layoutInfoProvider");
        Intrinsics.checkNotNullParameter(displayArgsProvider, "displayArgsProvider");
        Map map = pending;
        List list = (List) map.get(embeddedViewId);
        EmbeddedDisplayRequest embeddedDisplayRequest = new EmbeddedDisplayRequest(embeddedViewId, viewInstanceId, priority, extras, layoutInfoProvider, displayArgsProvider);
        if (list == null || list.isEmpty()) {
            map.put(embeddedViewId, CollectionsKt.listOf(embeddedDisplayRequest));
        } else {
            map.put(embeddedViewId, CollectionsKt.plus((Collection<? extends EmbeddedDisplayRequest>) list, embeddedDisplayRequest));
        }
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.embedded.EmbeddedViewManager.addPending.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append("Embedded view '");
                sb.append(embeddedViewId);
                sb.append("' has ");
                List list2 = (List) EmbeddedViewManager.pending.get(embeddedViewId);
                sb.append(list2 != null ? Integer.valueOf(list2.size()) : null);
                sb.append(" pending");
                return sb.toString();
            }
        }, 1, null);
        viewsFlow.setValue(MapsKt.toMap(map));
    }

    @Override // com.urbanairship.android.layout.AirshipEmbeddedViewManager
    public void dismissAll(@NotNull final String embeddedViewId) {
        Intrinsics.checkNotNullParameter(embeddedViewId, "embeddedViewId");
        Map map = pending;
        map.put(embeddedViewId, CollectionsKt.emptyList());
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.embedded.EmbeddedViewManager.dismissAll.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append("Embedded view '");
                sb.append(embeddedViewId);
                sb.append("' has ");
                List list = (List) EmbeddedViewManager.pending.get(embeddedViewId);
                sb.append(list != null ? Integer.valueOf(list.size()) : null);
                sb.append(" pending");
                return sb.toString();
            }
        }, 1, null);
        viewsFlow.setValue(MapsKt.toMap(map));
    }

    @Override // com.urbanairship.android.layout.AirshipEmbeddedViewManager
    public void dismiss(@NotNull final String embeddedViewId, @NotNull String viewInstanceId) {
        Intrinsics.checkNotNullParameter(embeddedViewId, "embeddedViewId");
        Intrinsics.checkNotNullParameter(viewInstanceId, "viewInstanceId");
        Map map = pending;
        List list = (List) map.get(embeddedViewId);
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!Intrinsics.areEqual(((EmbeddedDisplayRequest) obj).getViewInstanceId(), viewInstanceId)) {
                arrayList.add(obj);
            }
        }
        map.put(embeddedViewId, arrayList);
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.embedded.EmbeddedViewManager.dismiss.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append("Embedded view '");
                sb.append(embeddedViewId);
                sb.append("' has ");
                List list2 = (List) EmbeddedViewManager.pending.get(embeddedViewId);
                sb.append(list2 != null ? Integer.valueOf(list2.size()) : null);
                sb.append(" pending");
                return sb.toString();
            }
        }, 1, null);
        viewsFlow.setValue(MapsKt.toMap(pending));
    }

    /* renamed from: com.urbanairship.embedded.EmbeddedViewManager$allPending$1, reason: invalid class name and case insensitive filesystem */
    static final class C11211 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        C11211(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C11211 c11211 = new C11211(continuation);
            c11211.L$0 = obj;
            return c11211;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Map map, Continuation continuation) {
            return ((C11211) create(map, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return FlowKt.flowOf(CollectionsKt.flatten(((Map) this.L$0).values()));
        }
    }

    @Override // com.urbanairship.android.layout.AirshipEmbeddedViewManager
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public Flow<List<EmbeddedDisplayRequest>> allPending() {
        return FlowKt.flatMapConcat(viewsFlow, new C11211(null));
    }

    @Override // com.urbanairship.android.layout.AirshipEmbeddedViewManager
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public Flow<EmbeddedDisplayRequestResult> displayRequests(@NotNull final String embeddedViewId, @Nullable final Comparator<AirshipEmbeddedInfo> comparator, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(embeddedViewId, "embeddedViewId");
        Intrinsics.checkNotNullParameter(scope, "scope");
        final MutableStateFlow mutableStateFlow = viewsFlow;
        final Flow<List<? extends EmbeddedDisplayRequest>> flow = new Flow<List<? extends EmbeddedDisplayRequest>>() { // from class: com.urbanairship.embedded.EmbeddedViewManager$displayRequests$$inlined$map$1

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 EmbeddedViewManager.kt\ncom/urbanairship/embedded/EmbeddedViewManager\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,218:1\n50#2:219\n107#3,4:220\n111#3,6:227\n118#3,3:234\n122#3,4:241\n1549#4:224\n1620#4,2:225\n1622#4:233\n1549#4:237\n1620#4,3:238\n*S KotlinDebug\n*F\n+ 1 EmbeddedViewManager.kt\ncom/urbanairship/embedded/EmbeddedViewManager\n*L\n110#1:224\n110#1:225,2\n110#1:233\n120#1:237\n120#1:238,3\n*E\n"})
            /* renamed from: com.urbanairship.embedded.EmbeddedViewManager$displayRequests$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ Comparator $comparator$inlined;
                final /* synthetic */ String $embeddedViewId$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.embedded.EmbeddedViewManager$displayRequests$$inlined$map$1$2", f = "EmbeddedViewManager.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                /* renamed from: com.urbanairship.embedded.EmbeddedViewManager$displayRequests$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Comparator comparator, String str) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$comparator$inlined = comparator;
                    this.$embeddedViewId$inlined = str;
                }

                /* JADX WARN: Removed duplicated region for block: B:28:0x00c0  */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r18, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r19) {
                    /*
                        r17 = this;
                        r0 = r17
                        r1 = r19
                        boolean r2 = r1 instanceof com.urbanairship.embedded.EmbeddedViewManager$displayRequests$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r2 == 0) goto L17
                        r2 = r1
                        com.urbanairship.embedded.EmbeddedViewManager$displayRequests$$inlined$map$1$2$1 r2 = (com.urbanairship.embedded.EmbeddedViewManager$displayRequests$$inlined$map$1.AnonymousClass2.AnonymousClass1) r2
                        int r3 = r2.label
                        r4 = -2147483648(0xffffffff80000000, float:-0.0)
                        r5 = r3 & r4
                        if (r5 == 0) goto L17
                        int r3 = r3 - r4
                        r2.label = r3
                        goto L1c
                    L17:
                        com.urbanairship.embedded.EmbeddedViewManager$displayRequests$$inlined$map$1$2$1 r2 = new com.urbanairship.embedded.EmbeddedViewManager$displayRequests$$inlined$map$1$2$1
                        r2.<init>(r1)
                    L1c:
                        java.lang.Object r1 = r2.result
                        java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r4 = r2.label
                        r5 = 1
                        if (r4 == 0) goto L36
                        if (r4 != r5) goto L2e
                        kotlin.ResultKt.throwOnFailure(r1)
                        goto Ldb
                    L2e:
                        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                        java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                        r0.<init>(r1)
                        throw r0
                    L36:
                        kotlin.ResultKt.throwOnFailure(r1)
                        kotlinx.coroutines.flow.FlowCollector r1 = r0.$this_unsafeFlow
                        r4 = r18
                        java.util.Map r4 = (java.util.Map) r4
                        java.util.Comparator r6 = r0.$comparator$inlined
                        if (r6 == 0) goto Lc2
                        java.lang.String r6 = r0.$embeddedViewId$inlined
                        java.lang.Object r4 = r4.get(r6)
                        java.util.List r4 = (java.util.List) r4
                        if (r4 == 0) goto Lc0
                        java.util.ArrayList r6 = new java.util.ArrayList
                        r7 = 10
                        int r8 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r7)
                        r6.<init>(r8)
                        java.util.Iterator r4 = r4.iterator()
                    L5c:
                        boolean r8 = r4.hasNext()
                        if (r8 == 0) goto L8b
                        java.lang.Object r8 = r4.next()
                        com.urbanairship.android.layout.EmbeddedDisplayRequest r8 = (com.urbanairship.android.layout.EmbeddedDisplayRequest) r8
                        com.urbanairship.embedded.AirshipEmbeddedInfo r15 = new com.urbanairship.embedded.AirshipEmbeddedInfo
                        java.lang.String r10 = r8.getViewInstanceId()
                        java.lang.String r11 = r8.getEmbeddedViewId()
                        com.urbanairship.json.JsonMap r13 = r8.getExtras()
                        r14 = 4
                        r16 = 0
                        r12 = 0
                        r9 = r15
                        r5 = r15
                        r15 = r16
                        r9.<init>(r10, r11, r12, r13, r14, r15)
                        kotlin.Pair r9 = new kotlin.Pair
                        r9.<init>(r5, r8)
                        r6.add(r9)
                        r5 = 1
                        goto L5c
                    L8b:
                        com.urbanairship.embedded.EmbeddedViewManager$displayRequests$1$sorted$2 r4 = new com.urbanairship.embedded.EmbeddedViewManager$displayRequests$1$sorted$2
                        java.util.Comparator r0 = r0.$comparator$inlined
                        r4.<init>(r0)
                        com.urbanairship.embedded.EmbeddedViewManager$sam$java_util_Comparator$0 r0 = new com.urbanairship.embedded.EmbeddedViewManager$sam$java_util_Comparator$0
                        r0.<init>(r4)
                        java.util.List r0 = kotlin.collections.CollectionsKt.sortedWith(r6, r0)
                        if (r0 == 0) goto Lc0
                        java.util.ArrayList r4 = new java.util.ArrayList
                        int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r7)
                        r4.<init>(r5)
                        java.util.Iterator r0 = r0.iterator()
                    Laa:
                        boolean r5 = r0.hasNext()
                        if (r5 == 0) goto Lcb
                        java.lang.Object r5 = r0.next()
                        kotlin.Pair r5 = (kotlin.Pair) r5
                        java.lang.Object r5 = r5.getSecond()
                        com.urbanairship.android.layout.EmbeddedDisplayRequest r5 = (com.urbanairship.android.layout.EmbeddedDisplayRequest) r5
                        r4.add(r5)
                        goto Laa
                    Lc0:
                        r4 = 0
                        goto Lcb
                    Lc2:
                        java.lang.String r0 = r0.$embeddedViewId$inlined
                        java.lang.Object r0 = r4.get(r0)
                        r4 = r0
                        java.util.List r4 = (java.util.List) r4
                    Lcb:
                        if (r4 != 0) goto Ld1
                        java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
                    Ld1:
                        r0 = 1
                        r2.label = r0
                        java.lang.Object r0 = r1.emit(r4, r2)
                        if (r0 != r3) goto Ldb
                        return r3
                    Ldb:
                        kotlin.Unit r0 = kotlin.Unit.INSTANCE
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.embedded.EmbeddedViewManager$displayRequests$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super List<? extends EmbeddedDisplayRequest>> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = mutableStateFlow.collect(new AnonymousClass2(flowCollector, comparator, embeddedViewId), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        return FlowKt.shareIn(FlowKt.distinctUntilChanged(new Flow<EmbeddedDisplayRequestResult>() { // from class: com.urbanairship.embedded.EmbeddedViewManager$displayRequests$$inlined$map$2

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 EmbeddedViewManager.kt\ncom/urbanairship/embedded/EmbeddedViewManager\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,218:1\n50#2:219\n128#3,6:220\n134#3:227\n135#3,4:242\n1#4:226\n2333#5,14:228\n*S KotlinDebug\n*F\n+ 1 EmbeddedViewManager.kt\ncom/urbanairship/embedded/EmbeddedViewManager\n*L\n134#1:228,14\n*E\n"})
            /* renamed from: com.urbanairship.embedded.EmbeddedViewManager$displayRequests$$inlined$map$2$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ Comparator $comparator$inlined;
                final /* synthetic */ String $embeddedViewId$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.embedded.EmbeddedViewManager$displayRequests$$inlined$map$2$2", f = "EmbeddedViewManager.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                /* renamed from: com.urbanairship.embedded.EmbeddedViewManager$displayRequests$$inlined$map$2$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Comparator comparator, String str) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$comparator$inlined = comparator;
                    this.$embeddedViewId$inlined = str;
                }

                /* JADX WARN: Finally extract failed */
                /* JADX WARN: Removed duplicated region for block: B:35:0x0090  */
                /* JADX WARN: Removed duplicated region for block: B:36:0x0092 A[Catch: all -> 0x007c, TryCatch #0 {all -> 0x007c, blocks: (B:18:0x0051, B:20:0x0060, B:21:0x0064, B:23:0x006a, B:29:0x007f, B:33:0x0086, B:45:0x00b9, B:47:0x00bd, B:36:0x0092, B:39:0x009d, B:40:0x00a4, B:43:0x00b3), top: B:57:0x0051 }] */
                /* JADX WARN: Removed duplicated region for block: B:47:0x00bd A[Catch: all -> 0x007c, TRY_LEAVE, TryCatch #0 {all -> 0x007c, blocks: (B:18:0x0051, B:20:0x0060, B:21:0x0064, B:23:0x006a, B:29:0x007f, B:33:0x0086, B:45:0x00b9, B:47:0x00bd, B:36:0x0092, B:39:0x009d, B:40:0x00a4, B:43:0x00b3), top: B:57:0x0051 }] */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r12) {
                    /*
                        r10 = this;
                        boolean r0 = r12 instanceof com.urbanairship.embedded.EmbeddedViewManager$displayRequests$$inlined$map$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r12
                        com.urbanairship.embedded.EmbeddedViewManager$displayRequests$$inlined$map$2$2$1 r0 = (com.urbanairship.embedded.EmbeddedViewManager$displayRequests$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.embedded.EmbeddedViewManager$displayRequests$$inlined$map$2$2$1 r0 = new com.urbanairship.embedded.EmbeddedViewManager$displayRequests$$inlined$map$2$2$1
                        r0.<init>(r12)
                    L18:
                        java.lang.Object r12 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r12)
                        goto Ldc
                    L2a:
                        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                        java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                        r10.<init>(r11)
                        throw r10
                    L32:
                        kotlin.ResultKt.throwOnFailure(r12)
                        kotlinx.coroutines.flow.FlowCollector r12 = r10.$this_unsafeFlow
                        java.util.List r11 = (java.util.List) r11
                        java.util.Comparator r2 = r10.$comparator$inlined
                        if (r2 == 0) goto L4a
                        com.urbanairship.android.layout.EmbeddedDisplayRequestResult r10 = new com.urbanairship.android.layout.EmbeddedDisplayRequestResult
                        java.lang.Object r2 = kotlin.collections.CollectionsKt.firstOrNull(r11)
                        com.urbanairship.android.layout.EmbeddedDisplayRequest r2 = (com.urbanairship.android.layout.EmbeddedDisplayRequest) r2
                        r10.<init>(r2, r11)
                        goto Ld3
                    L4a:
                        java.util.concurrent.locks.ReentrantLock r2 = com.urbanairship.embedded.EmbeddedViewManager.access$getLastViewedLock$p()
                        r2.lock()
                        java.util.Map r4 = com.urbanairship.embedded.EmbeddedViewManager.access$getLastViewed$p()     // Catch: java.lang.Throwable -> L7c
                        java.lang.String r5 = r10.$embeddedViewId$inlined     // Catch: java.lang.Throwable -> L7c
                        java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L7c
                        java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L7c
                        r5 = 0
                        if (r4 == 0) goto L86
                        java.util.Iterator r6 = r11.iterator()     // Catch: java.lang.Throwable -> L7c
                    L64:
                        boolean r7 = r6.hasNext()     // Catch: java.lang.Throwable -> L7c
                        if (r7 == 0) goto L7e
                        java.lang.Object r7 = r6.next()     // Catch: java.lang.Throwable -> L7c
                        r8 = r7
                        com.urbanairship.android.layout.EmbeddedDisplayRequest r8 = (com.urbanairship.android.layout.EmbeddedDisplayRequest) r8     // Catch: java.lang.Throwable -> L7c
                        java.lang.String r8 = r8.getViewInstanceId()     // Catch: java.lang.Throwable -> L7c
                        boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r4)     // Catch: java.lang.Throwable -> L7c
                        if (r8 == 0) goto L64
                        goto L7f
                    L7c:
                        r10 = move-exception
                        goto Ldf
                    L7e:
                        r7 = r5
                    L7f:
                        com.urbanairship.android.layout.EmbeddedDisplayRequest r7 = (com.urbanairship.android.layout.EmbeddedDisplayRequest) r7     // Catch: java.lang.Throwable -> L7c
                        if (r7 != 0) goto L84
                        goto L86
                    L84:
                        r5 = r7
                        goto Lcb
                    L86:
                        java.util.Iterator r4 = r11.iterator()     // Catch: java.lang.Throwable -> L7c
                        boolean r6 = r4.hasNext()     // Catch: java.lang.Throwable -> L7c
                        if (r6 != 0) goto L92
                        r6 = r5
                        goto Lb9
                    L92:
                        java.lang.Object r6 = r4.next()     // Catch: java.lang.Throwable -> L7c
                        boolean r7 = r4.hasNext()     // Catch: java.lang.Throwable -> L7c
                        if (r7 != 0) goto L9d
                        goto Lb9
                    L9d:
                        r7 = r6
                        com.urbanairship.android.layout.EmbeddedDisplayRequest r7 = (com.urbanairship.android.layout.EmbeddedDisplayRequest) r7     // Catch: java.lang.Throwable -> L7c
                        int r7 = r7.getPriority()     // Catch: java.lang.Throwable -> L7c
                    La4:
                        java.lang.Object r8 = r4.next()     // Catch: java.lang.Throwable -> L7c
                        r9 = r8
                        com.urbanairship.android.layout.EmbeddedDisplayRequest r9 = (com.urbanairship.android.layout.EmbeddedDisplayRequest) r9     // Catch: java.lang.Throwable -> L7c
                        int r9 = r9.getPriority()     // Catch: java.lang.Throwable -> L7c
                        if (r7 <= r9) goto Lb3
                        r6 = r8
                        r7 = r9
                    Lb3:
                        boolean r8 = r4.hasNext()     // Catch: java.lang.Throwable -> L7c
                        if (r8 != 0) goto La4
                    Lb9:
                        com.urbanairship.android.layout.EmbeddedDisplayRequest r6 = (com.urbanairship.android.layout.EmbeddedDisplayRequest) r6     // Catch: java.lang.Throwable -> L7c
                        if (r6 == 0) goto Lcb
                        java.util.Map r4 = com.urbanairship.embedded.EmbeddedViewManager.access$getLastViewed$p()     // Catch: java.lang.Throwable -> L7c
                        java.lang.String r10 = r10.$embeddedViewId$inlined     // Catch: java.lang.Throwable -> L7c
                        java.lang.String r5 = r6.getViewInstanceId()     // Catch: java.lang.Throwable -> L7c
                        r4.put(r10, r5)     // Catch: java.lang.Throwable -> L7c
                        r5 = r6
                    Lcb:
                        r2.unlock()
                        com.urbanairship.android.layout.EmbeddedDisplayRequestResult r10 = new com.urbanairship.android.layout.EmbeddedDisplayRequestResult
                        r10.<init>(r5, r11)
                    Ld3:
                        r0.label = r3
                        java.lang.Object r10 = r12.emit(r10, r0)
                        if (r10 != r1) goto Ldc
                        return r1
                    Ldc:
                        kotlin.Unit r10 = kotlin.Unit.INSTANCE
                        return r10
                    Ldf:
                        r2.unlock()
                        throw r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.embedded.EmbeddedViewManager$displayRequests$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super EmbeddedDisplayRequestResult> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector, comparator, embeddedViewId), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }), scope, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), 1);
    }
}
