package com.urbanairship.android.layout.model;

import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.android.layout.environment.SharedState;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.model.StoryIndicatorModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes5.dex */
final class StoryIndicatorModel$onViewAttached$1 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ StoryIndicatorModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryIndicatorModel$onViewAttached$1(StoryIndicatorModel storyIndicatorModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = storyIndicatorModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StoryIndicatorModel$onViewAttached$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StoryIndicatorModel$onViewAttached$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final StateFlow<State.Pager> changes;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SharedState<State.Pager> pager = this.this$0.getLayoutState().getPager();
            if (pager != null && (changes = pager.getChanges()) != null) {
                final StoryIndicatorModel storyIndicatorModel = this.this$0;
                Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<StoryIndicatorModel.StoryIndicatorUpdate>() { // from class: com.urbanairship.android.layout.model.StoryIndicatorModel$onViewAttached$1$invokeSuspend$$inlined$map$1

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 StoryIndicatorModel.kt\ncom/urbanairship/android/layout/model/StoryIndicatorModel$onViewAttached$1\n*L\n1#1,218:1\n50#2:219\n71#3,6:220\n*E\n"})
                    /* renamed from: com.urbanairship.android.layout.model.StoryIndicatorModel$onViewAttached$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;
                        final /* synthetic */ StoryIndicatorModel this$0;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.android.layout.model.StoryIndicatorModel$onViewAttached$1$invokeSuspend$$inlined$map$1$2", f = "StoryIndicatorModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        /* renamed from: com.urbanairship.android.layout.model.StoryIndicatorModel$onViewAttached$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
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

                        public AnonymousClass2(FlowCollector flowCollector, StoryIndicatorModel storyIndicatorModel) {
                            this.$this_unsafeFlow = flowCollector;
                            this.this$0 = storyIndicatorModel;
                        }

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
                                boolean r0 = r12 instanceof com.urbanairship.android.layout.model.StoryIndicatorModel$onViewAttached$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r12
                                com.urbanairship.android.layout.model.StoryIndicatorModel$onViewAttached$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.urbanairship.android.layout.model.StoryIndicatorModel$onViewAttached$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.android.layout.model.StoryIndicatorModel$onViewAttached$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.urbanairship.android.layout.model.StoryIndicatorModel$onViewAttached$1$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r12)
                            L18:
                                java.lang.Object r12 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.ResultKt.throwOnFailure(r12)
                                goto L61
                            L29:
                                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                                r10.<init>(r11)
                                throw r10
                            L31:
                                kotlin.ResultKt.throwOnFailure(r12)
                                kotlinx.coroutines.flow.FlowCollector r12 = r10.$this_unsafeFlow
                                com.urbanairship.android.layout.environment.State$Pager r11 = (com.urbanairship.android.layout.environment.State.Pager) r11
                                com.urbanairship.android.layout.model.StoryIndicatorModel$StoryIndicatorUpdate r2 = new com.urbanairship.android.layout.model.StoryIndicatorModel$StoryIndicatorUpdate
                                java.util.List r4 = r11.getPageIds()
                                int r5 = r4.size()
                                int r6 = r11.getPageIndex()
                                int r7 = r11.getProgress()
                                java.util.List r8 = r11.getDurations()
                                com.urbanairship.android.layout.model.StoryIndicatorModel r10 = r10.this$0
                                boolean r9 = r10.getAnnouncePage()
                                r4 = r2
                                r4.<init>(r5, r6, r7, r8, r9)
                                r0.label = r3
                                java.lang.Object r10 = r12.emit(r2, r0)
                                if (r10 != r1) goto L61
                                return r1
                            L61:
                                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                                return r10
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.model.StoryIndicatorModel$onViewAttached$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super StoryIndicatorModel.StoryIndicatorUpdate> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = changes.collect(new AnonymousClass2(flowCollector, storyIndicatorModel), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                });
                if (flowDistinctUntilChanged != null) {
                    final StoryIndicatorModel storyIndicatorModel2 = this.this$0;
                    FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.StoryIndicatorModel$onViewAttached$1.2
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(StoryIndicatorModel.StoryIndicatorUpdate storyIndicatorUpdate, Continuation continuation) {
                            int iComponent1 = storyIndicatorUpdate.getSize();
                            int iComponent2 = storyIndicatorUpdate.getPageIndex();
                            int iComponent3 = storyIndicatorUpdate.getProgress();
                            List<Integer> listComponent4 = storyIndicatorUpdate.component4();
                            boolean zComponent5 = storyIndicatorUpdate.getAnnouncePage();
                            StoryIndicatorModel.Listener listener = storyIndicatorModel2.getListener();
                            if (listener != null) {
                                listener.onUpdate(iComponent1, iComponent2, iComponent3, listComponent4, zComponent5);
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    this.label = 1;
                    if (flowDistinctUntilChanged.collect(flowCollector, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
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
