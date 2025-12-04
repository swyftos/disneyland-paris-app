package com.urbanairship.android.layout.model;

import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.info.AccessibilityAction;
import com.urbanairship.android.layout.model.PagerModel;
import com.urbanairship.android.layout.view.PagerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes5.dex */
final class PagerModel$onViewAttached$6 extends SuspendLambda implements Function2 {
    final /* synthetic */ PagerView $view;
    int label;
    final /* synthetic */ PagerModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagerModel$onViewAttached$6(PagerModel pagerModel, PagerView pagerView, Continuation continuation) {
        super(2, continuation);
        this.this$0 = pagerModel;
        this.$view = pagerView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PagerModel$onViewAttached$6(this.this$0, this.$view, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PagerModel$onViewAttached$6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final StateFlow changes = this.this$0.pagerState.getChanges();
            final PagerModel pagerModel = this.this$0;
            Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<Pair<? extends State.Pager, ? extends PagerModel.Item>>() { // from class: com.urbanairship.android.layout.model.PagerModel$onViewAttached$6$invokeSuspend$$inlined$map$1

                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 PagerModel.kt\ncom/urbanairship/android/layout/model/PagerModel$onViewAttached$6\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,218:1\n50#2:219\n296#3:220\n288#4,2:221\n*S KotlinDebug\n*F\n+ 1 PagerModel.kt\ncom/urbanairship/android/layout/model/PagerModel$onViewAttached$6\n*L\n296#1:221,2\n*E\n"})
                /* renamed from: com.urbanairship.android.layout.model.PagerModel$onViewAttached$6$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ PagerModel this$0;

                    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "com.urbanairship.android.layout.model.PagerModel$onViewAttached$6$invokeSuspend$$inlined$map$1$2", f = "PagerModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                    /* renamed from: com.urbanairship.android.layout.model.PagerModel$onViewAttached$6$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
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

                    public AnonymousClass2(FlowCollector flowCollector, PagerModel pagerModel) {
                        this.$this_unsafeFlow = flowCollector;
                        this.this$0 = pagerModel;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    @org.jetbrains.annotations.Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.lang.Object r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r8) {
                        /*
                            r6 = this;
                            boolean r0 = r8 instanceof com.urbanairship.android.layout.model.PagerModel$onViewAttached$6$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r8
                            com.urbanairship.android.layout.model.PagerModel$onViewAttached$6$invokeSuspend$$inlined$map$1$2$1 r0 = (com.urbanairship.android.layout.model.PagerModel$onViewAttached$6$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.urbanairship.android.layout.model.PagerModel$onViewAttached$6$invokeSuspend$$inlined$map$1$2$1 r0 = new com.urbanairship.android.layout.model.PagerModel$onViewAttached$6$invokeSuspend$$inlined$map$1$2$1
                            r0.<init>(r8)
                        L18:
                            java.lang.Object r8 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.throwOnFailure(r8)
                            goto L6c
                        L29:
                            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                            r6.<init>(r7)
                            throw r6
                        L31:
                            kotlin.ResultKt.throwOnFailure(r8)
                            kotlinx.coroutines.flow.FlowCollector r8 = r6.$this_unsafeFlow
                            com.urbanairship.android.layout.environment.State$Pager r7 = (com.urbanairship.android.layout.environment.State.Pager) r7
                            com.urbanairship.android.layout.model.PagerModel r6 = r6.this$0
                            java.util.List r6 = com.urbanairship.android.layout.model.PagerModel.access$get_allPages$p(r6)
                            java.util.Iterator r6 = r6.iterator()
                        L42:
                            boolean r2 = r6.hasNext()
                            if (r2 == 0) goto L5e
                            java.lang.Object r2 = r6.next()
                            r4 = r2
                            com.urbanairship.android.layout.model.PagerModel$Item r4 = (com.urbanairship.android.layout.model.PagerModel.Item) r4
                            java.lang.String r4 = r4.getIdentifier()
                            java.lang.String r5 = r7.getCurrentPageId()
                            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
                            if (r4 == 0) goto L42
                            goto L5f
                        L5e:
                            r2 = 0
                        L5f:
                            kotlin.Pair r6 = kotlin.TuplesKt.to(r7, r2)
                            r0.label = r3
                            java.lang.Object r6 = r8.emit(r6, r0)
                            if (r6 != r1) goto L6c
                            return r1
                        L6c:
                            kotlin.Unit r6 = kotlin.Unit.INSTANCE
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.model.PagerModel$onViewAttached$6$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @Nullable
                public Object collect(@NotNull FlowCollector<? super Pair<? extends State.Pager, ? extends PagerModel.Item>> flowCollector, @NotNull Continuation continuation) {
                    Object objCollect = changes.collect(new AnonymousClass2(flowCollector, pagerModel), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            });
            final PagerView pagerView = this.$view;
            final PagerModel pagerModel2 = this.this$0;
            FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.PagerModel$onViewAttached$6.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Pair pair, Continuation continuation) {
                    final State.Pager pager = (State.Pager) pair.component1();
                    PagerModel.Item item = (PagerModel.Item) pair.component2();
                    PagerView pagerView2 = pagerView;
                    List<AccessibilityAction> accessibilityActions = item != null ? item.getAccessibilityActions() : null;
                    final PagerModel pagerModel3 = pagerModel2;
                    pagerView2.setAccessibilityActions(accessibilityActions, new Function1() { // from class: com.urbanairship.android.layout.model.PagerModel.onViewAttached.6.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            invoke((AccessibilityAction) obj2);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AccessibilityAction action) {
                            Intrinsics.checkNotNullParameter(action, "action");
                            pagerModel3.handleAccessibilityAction(action, pager);
                        }
                    });
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (flowDistinctUntilChanged.collect(flowCollector, this) == coroutine_suspended) {
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
