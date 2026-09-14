package com.urbanairship.embedded;

import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.android.layout.AirshipEmbeddedViewManager;
import com.urbanairship.android.layout.EmbeddedDisplayRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
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

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001$B\u001b\b\u0016\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u001b\b\u0016\u0012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u000b\"\u00020\b¢\u0006\u0002\u0010\fB-\b\u0001\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R(\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m1836d2 = {"Lcom/urbanairship/embedded/AirshipEmbeddedObserver;", "", ViewProps.FILTER, "Lkotlin/Function1;", "Lcom/urbanairship/embedded/AirshipEmbeddedInfo;", "", "(Lkotlin/jvm/functions/Function1;)V", "embeddedId", "", "(Ljava/lang/String;)V", "embeddedIds", "", "([Ljava/lang/String;)V", "manager", "Lcom/urbanairship/android/layout/AirshipEmbeddedViewManager;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlin/jvm/functions/Function1;Lcom/urbanairship/android/layout/AirshipEmbeddedViewManager;Lkotlinx/coroutines/CoroutineDispatcher;)V", "embeddedViewInfoFlow", "Lkotlinx/coroutines/flow/Flow;", "", "getEmbeddedViewInfoFlow", "()Lkotlinx/coroutines/flow/Flow;", "getFilter", "()Lkotlin/jvm/functions/Function1;", "value", "Lcom/urbanairship/embedded/AirshipEmbeddedObserver$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getListener", "()Lcom/urbanairship/embedded/AirshipEmbeddedObserver$Listener;", "setListener", "(Lcom/urbanairship/embedded/AirshipEmbeddedObserver$Listener;)V", "listenerJob", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Listener", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nAirshipEmbeddedObserver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirshipEmbeddedObserver.kt\ncom/urbanairship/embedded/AirshipEmbeddedObserver\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,68:1\n49#2:69\n51#2:73\n46#3:70\n51#3:72\n105#4:71\n*S KotlinDebug\n*F\n+ 1 AirshipEmbeddedObserver.kt\ncom/urbanairship/embedded/AirshipEmbeddedObserver\n*L\n58#1:69\n58#1:73\n58#1:70\n58#1:72\n58#1:71\n*E\n"})
public final class AirshipEmbeddedObserver {
    private final /* synthetic */ Flow embeddedViewInfoFlow;
    private final Function1 filter;
    private Listener listener;
    private Job listenerJob;
    private final AirshipEmbeddedViewManager manager;
    private final CoroutineScope scope;

    @Metadata(m1835d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007À\u0006\u0003"}, m1836d2 = {"Lcom/urbanairship/embedded/AirshipEmbeddedObserver$Listener;", "", "onEmbeddedViewInfoUpdate", "", "views", "", "Lcom/urbanairship/embedded/AirshipEmbeddedInfo;", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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

            /* JADX INFO: renamed from: com.urbanairship.embedded.AirshipEmbeddedObserver$special$$inlined$map$1$2 */
            @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AirshipEmbeddedObserver.kt\ncom/urbanairship/embedded/AirshipEmbeddedObserver\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,218:1\n50#2:219\n59#3:220\n60#3,4:224\n65#3:229\n1549#4:221\n1620#4,2:222\n1622#4:228\n766#4:230\n857#4,2:231\n*S KotlinDebug\n*F\n+ 1 AirshipEmbeddedObserver.kt\ncom/urbanairship/embedded/AirshipEmbeddedObserver\n*L\n59#1:221\n59#1:222,2\n59#1:228\n65#1:230\n65#1:231,2\n*E\n"})
            public static final class C52682<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ AirshipEmbeddedObserver this$0;

                /* JADX INFO: renamed from: com.urbanairship.embedded.AirshipEmbeddedObserver$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                @DebugMetadata(m1844c = "com.urbanairship.embedded.AirshipEmbeddedObserver$special$$inlined$map$1$2", m1845f = "AirshipEmbeddedObserver.kt", m1846i = {}, m1847l = {219}, m1848m = "emit", m1849n = {}, m1850s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
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
                        return C52682.this.emit(null, this);
                    }
                }

                public C52682(FlowCollector flowCollector, AirshipEmbeddedObserver airshipEmbeddedObserver) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = airshipEmbeddedObserver;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                public final Object emit(Object obj, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = anonymousClass1.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        List<EmbeddedDisplayRequest> list = (List) obj;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        for (EmbeddedDisplayRequest embeddedDisplayRequest : list) {
                            arrayList.add(new AirshipEmbeddedInfo(embeddedDisplayRequest.getViewInstanceId(), embeddedDisplayRequest.getEmbeddedViewId(), 0, embeddedDisplayRequest.getExtras(), 4, null));
                        }
                        Function1<AirshipEmbeddedInfo, Boolean> filter = this.this$0.getFilter();
                        ArrayList arrayList2 = new ArrayList();
                        for (T t : arrayList) {
                            if (filter.invoke(t).booleanValue()) {
                                arrayList2.add(t);
                            }
                        }
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(arrayList2, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super List<? extends AirshipEmbeddedInfo>> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = flowAllPending.collect(new C52682(flowCollector, this), continuation);
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
