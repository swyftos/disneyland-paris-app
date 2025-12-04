package com.urbanairship.android.layout.model;

import com.urbanairship.android.layout.property.SmsLocale;
import com.urbanairship.android.layout.view.TextInputView;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* loaded from: classes5.dex */
final class TextInputModel$onViewAttached$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ MutableStateFlow $validationState;
    final /* synthetic */ TextInputView $view;
    int label;
    final /* synthetic */ TextInputModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextInputModel$onViewAttached$1(TextInputView textInputView, TextInputModel textInputModel, MutableStateFlow mutableStateFlow, Continuation continuation) {
        super(2, continuation);
        this.$view = textInputView;
        this.this$0 = textInputModel;
        this.$validationState = mutableStateFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TextInputModel$onViewAttached$1(this.$view, this.this$0, this.$validationState, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((TextInputModel$onViewAttached$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* renamed from: com.urbanairship.android.layout.model.TextInputModel$onViewAttached$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function3 {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass1(Continuation continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(String str, SmsLocale smsLocale, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = str;
            anonymousClass1.L$1 = smsLocale;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new Pair((String) this.L$0, (SmsLocale) this.L$1);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow flowCombine = FlowKt.combine(this.$view.textChanges$urbanairship_layout_release(), this.this$0._smsLocale, new AnonymousClass1(null));
            final TextInputModel textInputModel = this.this$0;
            final MutableStateFlow mutableStateFlow = this.$validationState;
            FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.TextInputModel$onViewAttached$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Pair pair, Continuation continuation) {
                    Object value;
                    String str = (String) pair.component1();
                    SmsLocale smsLocale = (SmsLocale) pair.component2();
                    MutableStateFlow mutableStateFlow2 = textInputModel.currentInput;
                    do {
                        value = mutableStateFlow2.getValue();
                    } while (!mutableStateFlow2.compareAndSet(value, str));
                    textInputModel.formState.updateFormInput(textInputModel.makeFormField(str, smsLocale, mutableStateFlow), textInputModel.getProperties().getPagerPageId());
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (flowCombine.collect(flowCollector, this) == coroutine_suspended) {
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
