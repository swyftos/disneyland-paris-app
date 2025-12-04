package com.urbanairship.embedded;

import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.joran.action.Action;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.android.layout.AirshipEmbeddedViewManager;
import com.urbanairship.android.layout.EmbeddedDisplayRequest;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001$B\u001b\b\u0016\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u001b\b\u0016\u0012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u000b\"\u00020\b¢\u0006\u0002\u0010\fB-\b\u0001\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R(\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/urbanairship/embedded/AirshipEmbeddedObserver;", "", ViewProps.FILTER, "Lkotlin/Function1;", "Lcom/urbanairship/embedded/AirshipEmbeddedInfo;", "", "(Lkotlin/jvm/functions/Function1;)V", "embeddedId", "", "(Ljava/lang/String;)V", "embeddedIds", "", "([Ljava/lang/String;)V", "manager", "Lcom/urbanairship/android/layout/AirshipEmbeddedViewManager;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlin/jvm/functions/Function1;Lcom/urbanairship/android/layout/AirshipEmbeddedViewManager;Lkotlinx/coroutines/CoroutineDispatcher;)V", "embeddedViewInfoFlow", "Lkotlinx/coroutines/flow/Flow;", "", "getEmbeddedViewInfoFlow", "()Lkotlinx/coroutines/flow/Flow;", "getFilter", "()Lkotlin/jvm/functions/Function1;", "value", "Lcom/urbanairship/embedded/AirshipEmbeddedObserver$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getListener", "()Lcom/urbanairship/embedded/AirshipEmbeddedObserver$Listener;", "setListener", "(Lcom/urbanairship/embedded/AirshipEmbeddedObserver$Listener;)V", "listenerJob", "Lkotlinx/coroutines/Job;", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "Listener", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAirshipEmbeddedObserver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirshipEmbeddedObserver.kt\ncom/urbanairship/embedded/AirshipEmbeddedObserver\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,68:1\n49#2:69\n51#2:73\n46#3:70\n51#3:72\n105#4:71\n*S KotlinDebug\n*F\n+ 1 AirshipEmbeddedObserver.kt\ncom/urbanairship/embedded/AirshipEmbeddedObserver\n*L\n58#1:69\n58#1:73\n58#1:70\n58#1:72\n58#1:71\n*E\n"})
/* loaded from: classes5.dex */
public final class AirshipEmbeddedObserver {
    private final /* synthetic */ Flow embeddedViewInfoFlow;
    private final Function1 filter;
    private Listener listener;
    private Job listenerJob;
    private final AirshipEmbeddedViewManager manager;
    private final CoroutineScope scope;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/urbanairship/embedded/AirshipEmbeddedObserver$Listener;", "", "onEmbeddedViewInfoUpdate", "", "views", "", "Lcom/urbanairship/embedded/AirshipEmbeddedInfo;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener {
        void onEmbeddedViewInfoUpdate(@NotNull List<AirshipEmbeddedInfo> views);
    }

    @VisibleForTesting
    public AirshipEmbeddedObserver(@NotNull Function1<? super AirshipEmbeddedInfo, Boolean> filter, @NotNull AirshipEmbeddedViewManager manager, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.filter = filter;
        this.manager = manager;
        this.scope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        final Flow<List<EmbeddedDisplayRequest>> flowAllPending = manager.allPending();
        this.embeddedViewInfoFlow = new Flow<List<? extends AirshipEmbeddedInfo>>() { // from class: com.urbanairship.embedded.AirshipEmbeddedObserver$special$$inlined$map$1

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AirshipEmbeddedObserver.kt\ncom/urbanairship/embedded/AirshipEmbeddedObserver\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,218:1\n50#2:219\n59#3:220\n60#3,4:224\n65#3:229\n1549#4:221\n1620#4,2:222\n1622#4:228\n766#4:230\n857#4,2:231\n*S KotlinDebug\n*F\n+ 1 AirshipEmbeddedObserver.kt\ncom/urbanairship/embedded/AirshipEmbeddedObserver\n*L\n59#1:221\n59#1:222,2\n59#1:228\n65#1:230\n65#1:231,2\n*E\n"})
            /* renamed from: com.urbanairship.embedded.AirshipEmbeddedObserver$special$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ AirshipEmbeddedObserver this$0;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.embedded.AirshipEmbeddedObserver$special$$inlined$map$1$2", f = "AirshipEmbeddedObserver.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                /* renamed from: com.urbanairship.embedded.AirshipEmbeddedObserver$special$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, AirshipEmbeddedObserver airshipEmbeddedObserver) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = airshipEmbeddedObserver;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r15) {
                    /*
                        r13 = this;
                        boolean r0 = r15 instanceof com.urbanairship.embedded.AirshipEmbeddedObserver$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r15
                        com.urbanairship.embedded.AirshipEmbeddedObserver$special$$inlined$map$1$2$1 r0 = (com.urbanairship.embedded.AirshipEmbeddedObserver$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.embedded.AirshipEmbeddedObserver$special$$inlined$map$1$2$1 r0 = new com.urbanairship.embedded.AirshipEmbeddedObserver$special$$inlined$map$1$2$1
                        r0.<init>(r15)
                    L18:
                        java.lang.Object r15 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r15)
                        goto L9f
                    L2a:
                        java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                        java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                        r13.<init>(r14)
                        throw r13
                    L32:
                        kotlin.ResultKt.throwOnFailure(r15)
                        kotlinx.coroutines.flow.FlowCollector r15 = r13.$this_unsafeFlow
                        java.util.List r14 = (java.util.List) r14
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r4 = 10
                        int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r14, r4)
                        r2.<init>(r4)
                        java.util.Iterator r14 = r14.iterator()
                    L48:
                        boolean r4 = r14.hasNext()
                        if (r4 == 0) goto L6d
                        java.lang.Object r4 = r14.next()
                        com.urbanairship.android.layout.EmbeddedDisplayRequest r4 = (com.urbanairship.android.layout.EmbeddedDisplayRequest) r4
                        com.urbanairship.embedded.AirshipEmbeddedInfo r12 = new com.urbanairship.embedded.AirshipEmbeddedInfo
                        java.lang.String r6 = r4.getViewInstanceId()
                        java.lang.String r7 = r4.getEmbeddedViewId()
                        com.urbanairship.json.JsonMap r9 = r4.getExtras()
                        r10 = 4
                        r11 = 0
                        r8 = 0
                        r5 = r12
                        r5.<init>(r6, r7, r8, r9, r10, r11)
                        r2.add(r12)
                        goto L48
                    L6d:
                        com.urbanairship.embedded.AirshipEmbeddedObserver r13 = r13.this$0
                        kotlin.jvm.functions.Function1 r13 = r13.getFilter()
                        java.util.ArrayList r14 = new java.util.ArrayList
                        r14.<init>()
                        java.util.Iterator r2 = r2.iterator()
                    L7c:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto L96
                        java.lang.Object r4 = r2.next()
                        java.lang.Object r5 = r13.invoke(r4)
                        java.lang.Boolean r5 = (java.lang.Boolean) r5
                        boolean r5 = r5.booleanValue()
                        if (r5 == 0) goto L7c
                        r14.add(r4)
                        goto L7c
                    L96:
                        r0.label = r3
                        java.lang.Object r13 = r15.emit(r14, r0)
                        if (r13 != r1) goto L9f
                        return r1
                    L9f:
                        kotlin.Unit r13 = kotlin.Unit.INSTANCE
                        return r13
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.embedded.AirshipEmbeddedObserver$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super List<? extends AirshipEmbeddedInfo>> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = flowAllPending.collect(new AnonymousClass2(flowCollector, this), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public final Function1<AirshipEmbeddedInfo, Boolean> getFilter() {
        return this.filter;
    }

    public /* synthetic */ AirshipEmbeddedObserver(Function1 function1, AirshipEmbeddedViewManager airshipEmbeddedViewManager, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, airshipEmbeddedViewManager, (i & 4) != 0 ? Dispatchers.getDefault() : coroutineDispatcher);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AirshipEmbeddedObserver(@NotNull Function1<? super AirshipEmbeddedInfo, Boolean> filter) {
        this(filter, EmbeddedViewManager.INSTANCE, null, 4, null);
        Intrinsics.checkNotNullParameter(filter, "filter");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AirshipEmbeddedObserver(@NotNull final String embeddedId) {
        this((Function1<? super AirshipEmbeddedInfo, Boolean>) new Function1() { // from class: com.urbanairship.embedded.AirshipEmbeddedObserver.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(AirshipEmbeddedInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(Intrinsics.areEqual(it.getEmbeddedId(), embeddedId));
            }
        });
        Intrinsics.checkNotNullParameter(embeddedId, "embeddedId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AirshipEmbeddedObserver(@NotNull final String... embeddedIds) {
        this((Function1<? super AirshipEmbeddedInfo, Boolean>) new Function1() { // from class: com.urbanairship.embedded.AirshipEmbeddedObserver.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(AirshipEmbeddedInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(ArraysKt.contains(embeddedIds, it.getEmbeddedId()));
            }
        });
        Intrinsics.checkNotNullParameter(embeddedIds, "embeddedIds");
    }

    @Nullable
    public final Listener getListener() {
        return this.listener;
    }

    public final void setListener(@Nullable Listener listener) {
        this.listener = listener;
        Job job = this.listenerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (listener != null) {
            this.listenerJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AirshipEmbeddedObserver$listener$1(this, listener, null), 3, null);
        }
    }

    @NotNull
    public final Flow<List<AirshipEmbeddedInfo>> getEmbeddedViewInfoFlow() {
        return this.embeddedViewInfoFlow;
    }
}
