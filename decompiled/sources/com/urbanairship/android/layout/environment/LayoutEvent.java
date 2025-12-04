package com.urbanairship.android.layout.environment;

import ch.qos.logback.core.CoreConstants;
import com.dlp.BluetoothManager;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.android.layout.event.ReportingEvent;
import com.urbanairship.android.layout.model.PagerNextFallback;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/android/layout/environment/LayoutEvent;", "", "()V", "Finish", "PagerNext", "PagerPrevious", "Report", "StateUpdate", "SubmitForm", "ValidateForm", "Lcom/urbanairship/android/layout/environment/LayoutEvent$Finish;", "Lcom/urbanairship/android/layout/environment/LayoutEvent$PagerNext;", "Lcom/urbanairship/android/layout/environment/LayoutEvent$PagerPrevious;", "Lcom/urbanairship/android/layout/environment/LayoutEvent$Report;", "Lcom/urbanairship/android/layout/environment/LayoutEvent$StateUpdate;", "Lcom/urbanairship/android/layout/environment/LayoutEvent$SubmitForm;", "Lcom/urbanairship/android/layout/environment/LayoutEvent$ValidateForm;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class LayoutEvent {
    public /* synthetic */ LayoutEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LayoutEvent() {
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001e\b\u0002\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J$\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ8\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001e\b\u0002\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR)\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/android/layout/environment/LayoutEvent$SubmitForm;", "Lcom/urbanairship/android/layout/environment/LayoutEvent;", "buttonIdentifier", "", "onSubmitted", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getButtonIdentifier", "()Ljava/lang/String;", "getOnSubmitted", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lcom/urbanairship/android/layout/environment/LayoutEvent$SubmitForm;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class SubmitForm extends LayoutEvent {
        private final String buttonIdentifier;
        private final Function1 onSubmitted;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SubmitForm copy$default(SubmitForm submitForm, String str, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                str = submitForm.buttonIdentifier;
            }
            if ((i & 2) != 0) {
                function1 = submitForm.onSubmitted;
            }
            return submitForm.copy(str, function1);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getButtonIdentifier() {
            return this.buttonIdentifier;
        }

        @NotNull
        public final Function1<Continuation<? super Unit>, Object> component2() {
            return this.onSubmitted;
        }

        @NotNull
        public final SubmitForm copy(@NotNull String buttonIdentifier, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object> onSubmitted) {
            Intrinsics.checkNotNullParameter(buttonIdentifier, "buttonIdentifier");
            Intrinsics.checkNotNullParameter(onSubmitted, "onSubmitted");
            return new SubmitForm(buttonIdentifier, onSubmitted);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubmitForm)) {
                return false;
            }
            SubmitForm submitForm = (SubmitForm) other;
            return Intrinsics.areEqual(this.buttonIdentifier, submitForm.buttonIdentifier) && Intrinsics.areEqual(this.onSubmitted, submitForm.onSubmitted);
        }

        public int hashCode() {
            return (this.buttonIdentifier.hashCode() * 31) + this.onSubmitted.hashCode();
        }

        @NotNull
        public String toString() {
            return "SubmitForm(buttonIdentifier=" + this.buttonIdentifier + ", onSubmitted=" + this.onSubmitted + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* renamed from: com.urbanairship.android.layout.environment.LayoutEvent$SubmitForm$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function1 {
            int label;

            AnonymousClass1(Continuation continuation) {
                super(1, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation) {
                return new AnonymousClass1(continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
        }

        @NotNull
        public final String getButtonIdentifier() {
            return this.buttonIdentifier;
        }

        public /* synthetic */ SubmitForm(String str, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? new AnonymousClass1(null) : function1);
        }

        @NotNull
        public final Function1<Continuation<? super Unit>, Object> getOnSubmitted() {
            return this.onSubmitted;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubmitForm(@NotNull String buttonIdentifier, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object> onSubmitted) {
            super(null);
            Intrinsics.checkNotNullParameter(buttonIdentifier, "buttonIdentifier");
            Intrinsics.checkNotNullParameter(onSubmitted, "onSubmitted");
            this.buttonIdentifier = buttonIdentifier;
            this.onSubmitted = onSubmitted;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001e\b\u0002\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J$\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ8\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001e\b\u0002\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR)\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/android/layout/environment/LayoutEvent$ValidateForm;", "Lcom/urbanairship/android/layout/environment/LayoutEvent;", "buttonIdentifier", "", "onValidated", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getButtonIdentifier", "()Ljava/lang/String;", "getOnValidated", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lcom/urbanairship/android/layout/environment/LayoutEvent$ValidateForm;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ValidateForm extends LayoutEvent {
        private final String buttonIdentifier;
        private final Function1 onValidated;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ValidateForm copy$default(ValidateForm validateForm, String str, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                str = validateForm.buttonIdentifier;
            }
            if ((i & 2) != 0) {
                function1 = validateForm.onValidated;
            }
            return validateForm.copy(str, function1);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getButtonIdentifier() {
            return this.buttonIdentifier;
        }

        @NotNull
        public final Function1<Continuation<? super Unit>, Object> component2() {
            return this.onValidated;
        }

        @NotNull
        public final ValidateForm copy(@NotNull String buttonIdentifier, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object> onValidated) {
            Intrinsics.checkNotNullParameter(buttonIdentifier, "buttonIdentifier");
            Intrinsics.checkNotNullParameter(onValidated, "onValidated");
            return new ValidateForm(buttonIdentifier, onValidated);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ValidateForm)) {
                return false;
            }
            ValidateForm validateForm = (ValidateForm) other;
            return Intrinsics.areEqual(this.buttonIdentifier, validateForm.buttonIdentifier) && Intrinsics.areEqual(this.onValidated, validateForm.onValidated);
        }

        public int hashCode() {
            return (this.buttonIdentifier.hashCode() * 31) + this.onValidated.hashCode();
        }

        @NotNull
        public String toString() {
            return "ValidateForm(buttonIdentifier=" + this.buttonIdentifier + ", onValidated=" + this.onValidated + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* renamed from: com.urbanairship.android.layout.environment.LayoutEvent$ValidateForm$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function1 {
            int label;

            AnonymousClass1(Continuation continuation) {
                super(1, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation) {
                return new AnonymousClass1(continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
        }

        @NotNull
        public final String getButtonIdentifier() {
            return this.buttonIdentifier;
        }

        public /* synthetic */ ValidateForm(String str, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? new AnonymousClass1(null) : function1);
        }

        @NotNull
        public final Function1<Continuation<? super Unit>, Object> getOnValidated() {
            return this.onValidated;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ValidateForm(@NotNull String buttonIdentifier, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object> onValidated) {
            super(null);
            Intrinsics.checkNotNullParameter(buttonIdentifier, "buttonIdentifier");
            Intrinsics.checkNotNullParameter(onValidated, "onValidated");
            this.buttonIdentifier = buttonIdentifier;
            this.onValidated = onValidated;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/android/layout/environment/LayoutEvent$Report;", "Lcom/urbanairship/android/layout/environment/LayoutEvent;", "event", "Lcom/urbanairship/android/layout/event/ReportingEvent;", "(Lcom/urbanairship/android/layout/event/ReportingEvent;)V", "getEvent", "()Lcom/urbanairship/android/layout/event/ReportingEvent;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Report extends LayoutEvent {
        private final ReportingEvent event;

        public static /* synthetic */ Report copy$default(Report report, ReportingEvent reportingEvent, int i, Object obj) {
            if ((i & 1) != 0) {
                reportingEvent = report.event;
            }
            return report.copy(reportingEvent);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final ReportingEvent getEvent() {
            return this.event;
        }

        @NotNull
        public final Report copy(@NotNull ReportingEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return new Report(event);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Report) && Intrinsics.areEqual(this.event, ((Report) other).event);
        }

        public int hashCode() {
            return this.event.hashCode();
        }

        @NotNull
        public String toString() {
            return "Report(event=" + this.event + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @NotNull
        public final ReportingEvent getEvent() {
            return this.event;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Report(@NotNull ReportingEvent event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.event = event;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/android/layout/environment/LayoutEvent$StateUpdate;", "Lcom/urbanairship/android/layout/environment/LayoutEvent;", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/android/layout/environment/ThomasState;", "(Lcom/urbanairship/android/layout/environment/ThomasState;)V", "getState", "()Lcom/urbanairship/android/layout/environment/ThomasState;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class StateUpdate extends LayoutEvent {
        private final ThomasState state;

        public static /* synthetic */ StateUpdate copy$default(StateUpdate stateUpdate, ThomasState thomasState, int i, Object obj) {
            if ((i & 1) != 0) {
                thomasState = stateUpdate.state;
            }
            return stateUpdate.copy(thomasState);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final ThomasState getState() {
            return this.state;
        }

        @NotNull
        public final StateUpdate copy(@NotNull ThomasState state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new StateUpdate(state);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StateUpdate) && Intrinsics.areEqual(this.state, ((StateUpdate) other).state);
        }

        public int hashCode() {
            return this.state.hashCode();
        }

        @NotNull
        public String toString() {
            return "StateUpdate(state=" + this.state + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @NotNull
        public final ThomasState getState() {
            return this.state;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StateUpdate(@NotNull ThomasState state) {
            super(null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/android/layout/environment/LayoutEvent$PagerNext;", "Lcom/urbanairship/android/layout/environment/LayoutEvent;", "fallback", "Lcom/urbanairship/android/layout/model/PagerNextFallback;", "(Lcom/urbanairship/android/layout/model/PagerNextFallback;)V", "getFallback", "()Lcom/urbanairship/android/layout/model/PagerNextFallback;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PagerNext extends LayoutEvent {
        private final PagerNextFallback fallback;

        public static /* synthetic */ PagerNext copy$default(PagerNext pagerNext, PagerNextFallback pagerNextFallback, int i, Object obj) {
            if ((i & 1) != 0) {
                pagerNextFallback = pagerNext.fallback;
            }
            return pagerNext.copy(pagerNextFallback);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final PagerNextFallback getFallback() {
            return this.fallback;
        }

        @NotNull
        public final PagerNext copy(@NotNull PagerNextFallback fallback) {
            Intrinsics.checkNotNullParameter(fallback, "fallback");
            return new PagerNext(fallback);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PagerNext) && this.fallback == ((PagerNext) other).fallback;
        }

        public int hashCode() {
            return this.fallback.hashCode();
        }

        @NotNull
        public String toString() {
            return "PagerNext(fallback=" + this.fallback + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @NotNull
        public final PagerNextFallback getFallback() {
            return this.fallback;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PagerNext(@NotNull PagerNextFallback fallback) {
            super(null);
            Intrinsics.checkNotNullParameter(fallback, "fallback");
            this.fallback = fallback;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/android/layout/environment/LayoutEvent$PagerPrevious;", "Lcom/urbanairship/android/layout/environment/LayoutEvent;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PagerPrevious extends LayoutEvent {

        @NotNull
        public static final PagerPrevious INSTANCE = new PagerPrevious();

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof PagerPrevious);
        }

        public int hashCode() {
            return 845440905;
        }

        @NotNull
        public String toString() {
            return "PagerPrevious";
        }

        private PagerPrevious() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/android/layout/environment/LayoutEvent$Finish;", "Lcom/urbanairship/android/layout/environment/LayoutEvent;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Finish extends LayoutEvent {

        @NotNull
        public static final Finish INSTANCE = new Finish();

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof Finish);
        }

        public int hashCode() {
            return 1523054532;
        }

        @NotNull
        public String toString() {
            return "Finish";
        }

        private Finish() {
            super(null);
        }
    }
}
