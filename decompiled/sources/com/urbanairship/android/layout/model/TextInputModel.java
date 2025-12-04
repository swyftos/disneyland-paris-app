package com.urbanairship.android.layout.model;

import android.content.Context;
import com.urbanairship.UAirship;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.environment.ThomasForm;
import com.urbanairship.android.layout.environment.ThomasState;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.info.TextInputInfo;
import com.urbanairship.android.layout.info.ThomasChannelRegistration;
import com.urbanairship.android.layout.info.ThomasEmailRegistrationOptions;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.property.EventHandlerKt;
import com.urbanairship.android.layout.property.FormInputType;
import com.urbanairship.android.layout.property.SmsLocale;
import com.urbanairship.android.layout.reporting.AttributeName;
import com.urbanairship.android.layout.reporting.ThomasFormField;
import com.urbanairship.android.layout.view.TextInputView;
import com.urbanairship.inputvalidation.AirshipInputValidation;
import com.urbanairship.json.JsonValue;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u000201B%\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0002J*\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u000eH\u0002J\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110 2\b\u0010!\u001a\u0004\u0018\u00010\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0002J\"\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J\u0015\u0010)\u001a\u00020*2\u0006\u0010\u001c\u001a\u00020\u000fH\u0000¢\u0006\u0002\b+J\u0015\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\u0002H\u0010¢\u0006\u0002\b.J\u0010\u0010/\u001a\u00020*2\u0006\u0010-\u001a\u00020\u0002H\u0014R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u00062"}, d2 = {"Lcom/urbanairship/android/layout/model/TextInputModel;", "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/view/TextInputView;", "Lcom/urbanairship/android/layout/info/TextInputInfo;", "Lcom/urbanairship/android/layout/model/TextInputModel$Listener;", "viewInfo", "formState", "Lcom/urbanairship/android/layout/environment/ThomasForm;", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "(Lcom/urbanairship/android/layout/info/TextInputInfo;Lcom/urbanairship/android/layout/environment/ThomasForm;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;)V", "_smsLocale", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/urbanairship/android/layout/property/SmsLocale;", "currentInput", "", "inputValidator", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Validator;", "getInputValidator", "()Lcom/urbanairship/inputvalidation/AirshipInputValidation$Validator;", "channelRegistration", "Lcom/urbanairship/android/layout/info/ThomasChannelRegistration;", "address", "makeFormField", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$TextInput;", "input", "smsLocale", "validationStatus", "Lcom/urbanairship/android/layout/model/TextInputModel$ValidationState;", "makeResolveMethod", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$FieldType;", "text", "onCreateView", "context", "Landroid/content/Context;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "itemProperties", "Lcom/urbanairship/android/layout/model/ItemProperties;", "onNewLocale", "", "onNewLocale$urbanairship_layout_release", "onViewAttached", "view", "onViewAttached$urbanairship_layout_release", "onViewCreated", "Listener", "ValidationState", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTextInputModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextInputModel.kt\ncom/urbanairship/android/layout/model/TextInputModel\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n226#2,5:311\n226#2,5:316\n226#2,5:322\n226#2,5:327\n1#3:321\n*S KotlinDebug\n*F\n+ 1 TextInputModel.kt\ncom/urbanairship/android/layout/model/TextInputModel\n*L\n36#1:311,5\n97#1:316,5\n275#1:322,5\n296#1:327,5\n*E\n"})
/* loaded from: classes5.dex */
public final class TextInputModel extends BaseModel<TextInputView, TextInputInfo, Listener> {
    private final MutableStateFlow _smsLocale;
    private final MutableStateFlow currentInput;
    private final ThomasForm formState;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FormInputType.values().length];
            try {
                iArr[FormInputType.EMAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FormInputType.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FormInputType.SMS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FormInputType.TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FormInputType.TEXT_MULTILINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextInputModel(@NotNull final TextInputInfo viewInfo, @NotNull ThomasForm formState, @NotNull ModelEnvironment environment, @NotNull ModelProperties properties) {
        super(viewInfo, environment, properties, null, 8, null);
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(formState, "formState");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.formState = formState;
        this._smsLocale = StateFlowKt.MutableStateFlow(null);
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow("");
        this.currentInput = MutableStateFlow;
        formState.updateFormInput(new ThomasFormField.TextInput(viewInfo.getInputType(), viewInfo.getIdentifier(), null, ThomasFormField.FieldType.Companion.just$default(ThomasFormField.FieldType.INSTANCE, "", new Function1() { // from class: com.urbanairship.android.layout.model.TextInputModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(!viewInfo.isRequired());
            }
        }, null, ThomasFormField.INSTANCE.makeAttributes(viewInfo.getAttributeName(), null), 4, null)), properties.getPagerPageId());
        BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new AnonymousClass2(null), 3, null);
        wireValidationActions(viewInfo.getIdentifier(), formState, MutableStateFlow.getValue(), MutableStateFlow, viewInfo);
    }

    public final void onNewLocale$urbanairship_layout_release(@NotNull SmsLocale smsLocale) {
        Object value;
        Intrinsics.checkNotNullParameter(smsLocale, "smsLocale");
        MutableStateFlow mutableStateFlow = this._smsLocale;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, smsLocale));
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/model/TextInputModel$Listener;", "Lcom/urbanairship/android/layout/model/BaseModel$Listener;", "restoreValue", "", "value", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener extends BaseModel.Listener {
        void restoreValue(@NotNull String value);

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            public static void onStateUpdated(@NotNull Listener listener, @NotNull ThomasState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Listener.super.onStateUpdated(state);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AirshipInputValidation.Validator getInputValidator() {
        if (UAirship.isFlying()) {
            return UAirship.shared().getInputValidator();
        }
        return null;
    }

    /* renamed from: com.urbanairship.android.layout.model.TextInputModel$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return TextInputModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<State.Form> formUpdates = TextInputModel.this.formState.getFormUpdates();
                final TextInputModel textInputModel = TextInputModel.this;
                FlowCollector<? super State.Form> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.TextInputModel.2.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(State.Form form, Continuation continuation) {
                        Listener listener = textInputModel.getListener();
                        if (listener != null) {
                            listener.setEnabled(form.isEnabled());
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (formUpdates.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.urbanairship.android.layout.model.BaseModel
    @NotNull
    public TextInputView onCreateView(@NotNull Context context, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties) {
        String originalValue;
        Object value;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        TextInputView textInputView = new TextInputView(context, this);
        textInputView.setId(getViewId());
        ThomasFormField.TextInput textInput = (ThomasFormField.TextInput) this.formState.inputData$urbanairship_layout_release(getViewInfo().getIdentifier());
        if (textInput != null && (originalValue = textInput.getOriginalValue()) != null) {
            MutableStateFlow mutableStateFlow = this.currentInput;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, originalValue));
            Listener listener = getListener();
            if (listener != null) {
                listener.restoreValue(originalValue);
            }
        }
        return textInputView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.urbanairship.android.layout.model.BaseModel
    public void onViewCreated(@NotNull TextInputView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated((TextInputModel) view);
        onFormInputDisplayed(new C09541(null));
    }

    /* renamed from: com.urbanairship.android.layout.model.TextInputModel$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    static final class C09541 extends SuspendLambda implements Function2 {
        /* synthetic */ boolean Z$0;
        int label;

        C09541(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C09541 c09541 = TextInputModel.this.new C09541(continuation);
            c09541.Z$0 = ((Boolean) obj).booleanValue();
            return c09541;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
        }

        public final Object invoke(boolean z, Continuation continuation) {
            return ((C09541) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TextInputModel.this.formState.updateWithDisplayState(TextInputModel.this.getViewInfo().getIdentifier(), this.Z$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final ThomasFormField.FieldType makeResolveMethod(String text, SmsLocale smsLocale) {
        Map<AttributeName, JsonValue> mapMakeAttributes = ThomasFormField.INSTANCE.makeAttributes(getViewInfo().getAttributeName(), (text == null || text.length() <= 0) ? null : JsonValue.wrap(text));
        if (text == null || text.length() == 0) {
            ThomasFormField.FieldType.Companion companion = ThomasFormField.FieldType.INSTANCE;
            String str = text == null ? "" : text;
            ThomasChannelRegistration thomasChannelRegistrationChannelRegistration = channelRegistration(text);
            return companion.just(str, new Function1() { // from class: com.urbanairship.android.layout.model.TextInputModel.makeResolveMethod.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(!TextInputModel.this.getViewInfo().isRequired());
                }
            }, thomasChannelRegistrationChannelRegistration != null ? CollectionsKt.listOf(thomasChannelRegistrationChannelRegistration) : null, mapMakeAttributes);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[getViewInfo().getInputType().ordinal()];
        if (i == 1) {
            AirshipInputValidation.Request.ValidateEmail validateEmail = new AirshipInputValidation.Request.ValidateEmail(new AirshipInputValidation.Request.Email(text));
            Duration.Companion companion2 = Duration.INSTANCE;
            return new ThomasFormField.FieldType.Async(new ThomasFormField.AsyncValueFetcher(new AnonymousClass3(validateEmail, mapMakeAttributes, null), DurationKt.toDuration(1.5d, DurationUnit.SECONDS), null, null, 12, null));
        }
        if (i == 2) {
            ThomasFormField.FieldType.Companion companion3 = ThomasFormField.FieldType.INSTANCE;
            ThomasChannelRegistration thomasChannelRegistrationChannelRegistration2 = channelRegistration(text);
            return ThomasFormField.FieldType.Companion.just$default(companion3, text, null, thomasChannelRegistrationChannelRegistration2 != null ? CollectionsKt.listOf(thomasChannelRegistrationChannelRegistration2) : null, mapMakeAttributes, 2, null);
        }
        if (i == 3) {
            if (smsLocale == null) {
                return ThomasFormField.FieldType.Companion.just$default(ThomasFormField.FieldType.INSTANCE, text, new Function1() { // from class: com.urbanairship.android.layout.model.TextInputModel$makeResolveMethod$selectedLocale$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.FALSE;
                    }
                }, null, null, 12, null);
            }
            AirshipInputValidation.Request.Sms.ValidationOptions.Prefix prefix = new AirshipInputValidation.Request.Sms.ValidationOptions.Prefix(smsLocale.getPrefix());
            SmsLocale.ValidationHints validationHints = smsLocale.getValidationHints();
            Integer minDigits = validationHints != null ? validationHints.getMinDigits() : null;
            SmsLocale.ValidationHints validationHints2 = smsLocale.getValidationHints();
            return new ThomasFormField.FieldType.Async(new ThomasFormField.AsyncValueFetcher(new AnonymousClass5(new AirshipInputValidation.Request.ValidateSms(new AirshipInputValidation.Request.Sms(text, prefix, new AirshipInputValidation.Request.Sms.ValidationHints(minDigits, validationHints2 != null ? validationHints2.getMaxDigits() : null))), mapMakeAttributes, null), 0L, null, null, 14, null));
        }
        if (i == 4) {
            ThomasFormField.FieldType.Companion companion4 = ThomasFormField.FieldType.INSTANCE;
            ThomasChannelRegistration thomasChannelRegistrationChannelRegistration3 = channelRegistration(text);
            return ThomasFormField.FieldType.Companion.just$default(companion4, text, null, thomasChannelRegistrationChannelRegistration3 != null ? CollectionsKt.listOf(thomasChannelRegistrationChannelRegistration3) : null, mapMakeAttributes, 2, null);
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        ThomasFormField.FieldType.Companion companion5 = ThomasFormField.FieldType.INSTANCE;
        ThomasChannelRegistration thomasChannelRegistrationChannelRegistration4 = channelRegistration(text);
        return ThomasFormField.FieldType.Companion.just$default(companion5, text, null, thomasChannelRegistrationChannelRegistration4 != null ? CollectionsKt.listOf(thomasChannelRegistrationChannelRegistration4) : null, mapMakeAttributes, 2, null);
    }

    /* renamed from: com.urbanairship.android.layout.model.TextInputModel$makeResolveMethod$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function1 {
        final /* synthetic */ Map $attributes;
        final /* synthetic */ AirshipInputValidation.Request.ValidateEmail $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(AirshipInputValidation.Request.ValidateEmail validateEmail, Map map, Continuation continuation) {
            super(1, continuation);
            this.$request = validateEmail;
            this.$attributes = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return TextInputModel.this.new AnonymousClass3(this.$request, this.$attributes, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AirshipInputValidation.Validator inputValidator = TextInputModel.this.getInputValidator();
                if (inputValidator == null) {
                    return new ThomasFormField.AsyncValueFetcher.PendingResult.Invalid();
                }
                AirshipInputValidation.Request.ValidateEmail validateEmail = this.$request;
                this.label = 1;
                obj = inputValidator.validate(validateEmail, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            AirshipInputValidation.Result result = (AirshipInputValidation.Result) obj;
            if (Intrinsics.areEqual(result, AirshipInputValidation.Result.Invalid.INSTANCE)) {
                return new ThomasFormField.AsyncValueFetcher.PendingResult.Invalid();
            }
            if (!(result instanceof AirshipInputValidation.Result.Valid)) {
                throw new NoWhenBranchMatchedException();
            }
            AirshipInputValidation.Result.Valid valid = (AirshipInputValidation.Result.Valid) result;
            String address = valid.getAddress();
            ThomasChannelRegistration thomasChannelRegistrationChannelRegistration = TextInputModel.this.channelRegistration(valid.getAddress());
            return new ThomasFormField.AsyncValueFetcher.PendingResult.Valid(new ThomasFormField.Result(address, thomasChannelRegistrationChannelRegistration != null ? CollectionsKt.listOf(thomasChannelRegistrationChannelRegistration) : null, this.$attributes));
        }
    }

    /* renamed from: com.urbanairship.android.layout.model.TextInputModel$makeResolveMethod$5, reason: invalid class name */
    static final class AnonymousClass5 extends SuspendLambda implements Function1 {
        final /* synthetic */ Map $attributes;
        final /* synthetic */ AirshipInputValidation.Request.ValidateSms $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(AirshipInputValidation.Request.ValidateSms validateSms, Map map, Continuation continuation) {
            super(1, continuation);
            this.$request = validateSms;
            this.$attributes = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return TextInputModel.this.new AnonymousClass5(this.$request, this.$attributes, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass5) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AirshipInputValidation.Validator inputValidator = TextInputModel.this.getInputValidator();
                if (inputValidator == null) {
                    return new ThomasFormField.AsyncValueFetcher.PendingResult.Invalid();
                }
                AirshipInputValidation.Request.ValidateSms validateSms = this.$request;
                this.label = 1;
                obj = inputValidator.validate(validateSms, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            AirshipInputValidation.Result result = (AirshipInputValidation.Result) obj;
            if (Intrinsics.areEqual(result, AirshipInputValidation.Result.Invalid.INSTANCE)) {
                return new ThomasFormField.AsyncValueFetcher.PendingResult.Invalid();
            }
            if (!(result instanceof AirshipInputValidation.Result.Valid)) {
                throw new NoWhenBranchMatchedException();
            }
            AirshipInputValidation.Result.Valid valid = (AirshipInputValidation.Result.Valid) result;
            String address = valid.getAddress();
            ThomasChannelRegistration thomasChannelRegistrationChannelRegistration = TextInputModel.this.channelRegistration(valid.getAddress());
            return new ThomasFormField.AsyncValueFetcher.PendingResult.Valid(new ThomasFormField.Result(address, thomasChannelRegistrationChannelRegistration != null ? CollectionsKt.listOf(thomasChannelRegistrationChannelRegistration) : null, this.$attributes));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ThomasChannelRegistration channelRegistration(String address) {
        SmsLocale.Registration registration;
        if (address == null || address.length() == 0) {
            return null;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[getViewInfo().getInputType().ordinal()];
        if (i == 1) {
            ThomasEmailRegistrationOptions emailRegistrationOptions = getViewInfo().getEmailRegistrationOptions();
            if (emailRegistrationOptions != null) {
                return new ThomasChannelRegistration.Email(address, emailRegistrationOptions);
            }
            return null;
        }
        if (i == 2) {
            return null;
        }
        if (i != 3) {
            if (i == 4 || i == 5) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
        SmsLocale smsLocale = (SmsLocale) this._smsLocale.getValue();
        if (smsLocale == null || (registration = smsLocale.getRegistration()) == null) {
            return null;
        }
        return new ThomasChannelRegistration.Sms(address, registration);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/android/layout/model/TextInputModel$ValidationState;", "", "(Ljava/lang/String;I)V", "VALIDATING", "VALID", "INVALID", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ValidationState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ValidationState[] $VALUES;
        public static final ValidationState VALIDATING = new ValidationState("VALIDATING", 0);
        public static final ValidationState VALID = new ValidationState("VALID", 1);
        public static final ValidationState INVALID = new ValidationState("INVALID", 2);

        private static final /* synthetic */ ValidationState[] $values() {
            return new ValidationState[]{VALIDATING, VALID, INVALID};
        }

        @NotNull
        public static EnumEntries<ValidationState> getEntries() {
            return $ENTRIES;
        }

        public static ValidationState valueOf(String str) {
            return (ValidationState) Enum.valueOf(ValidationState.class, str);
        }

        public static ValidationState[] values() {
            return (ValidationState[]) $VALUES.clone();
        }

        private ValidationState(String str, int i) {
        }

        static {
            ValidationState[] validationStateArr$values = $values();
            $VALUES = validationStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(validationStateArr$values);
        }
    }

    @Override // com.urbanairship.android.layout.model.BaseModel
    public void onViewAttached$urbanairship_layout_release(@NotNull TextInputView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        BuildersKt__Builders_commonKt.launch$default(getViewScope(), null, null, new TextInputModel$onViewAttached$1(view, this, StateFlowKt.MutableStateFlow(null), null), 3, null);
        if (EventHandlerKt.hasTapHandler(getViewInfo().getEventHandlers())) {
            BuildersKt__Builders_commonKt.launch$default(getViewScope(), null, null, new TextInputModel$onViewAttached$2(view, this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ThomasFormField.TextInput makeFormField(String input, SmsLocale smsLocale, MutableStateFlow validationStatus) {
        Object value;
        Object value2;
        if (input.length() > 0 || validationStatus.getValue() != null) {
            do {
                value = validationStatus.getValue();
            } while (!validationStatus.compareAndSet(value, ValidationState.VALIDATING));
        }
        ThomasFormField.FieldType fieldTypeMakeResolveMethod = makeResolveMethod(StringsKt.trim(input).toString(), smsLocale);
        if (fieldTypeMakeResolveMethod instanceof ThomasFormField.FieldType.Async) {
            BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new C09522(fieldTypeMakeResolveMethod, validationStatus, null), 3, null);
        } else if (fieldTypeMakeResolveMethod instanceof ThomasFormField.FieldType.Instant) {
            do {
                value2 = validationStatus.getValue();
            } while (!validationStatus.compareAndSet(value2, ((ThomasFormField.FieldType.Instant) fieldTypeMakeResolveMethod).getResult() != null ? ValidationState.VALID : ValidationState.INVALID));
        }
        return new ThomasFormField.TextInput(getViewInfo().getInputType(), getViewInfo().getIdentifier(), input, fieldTypeMakeResolveMethod);
    }

    /* renamed from: com.urbanairship.android.layout.model.TextInputModel$makeFormField$2, reason: invalid class name and case insensitive filesystem */
    static final class C09522 extends SuspendLambda implements Function2 {
        final /* synthetic */ ThomasFormField.FieldType $method;
        final /* synthetic */ MutableStateFlow $validationStatus;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09522(ThomasFormField.FieldType fieldType, MutableStateFlow mutableStateFlow, Continuation continuation) {
            super(2, continuation);
            this.$method = fieldType;
            this.$validationStatus = mutableStateFlow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C09522(this.$method, this.$validationStatus, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09522) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* renamed from: com.urbanairship.android.layout.model.TextInputModel$makeFormField$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2 {
            /* synthetic */ Object L$0;
            int label;

            AnonymousClass1(Continuation continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(ThomasFormField.AsyncValueFetcher.PendingResult pendingResult, Continuation continuation) {
                return ((AnonymousClass1) create(pendingResult, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(((ThomasFormField.AsyncValueFetcher.PendingResult) this.L$0) != null);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object value2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow results = ((ThomasFormField.FieldType.Async) this.$method).getFetcher().getResults();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
                this.label = 1;
                obj = FlowKt.first(results, anonymousClass1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ThomasFormField.AsyncValueFetcher.PendingResult pendingResult = (ThomasFormField.AsyncValueFetcher.PendingResult) obj;
            if (!(pendingResult instanceof ThomasFormField.AsyncValueFetcher.PendingResult.Error)) {
                if (pendingResult instanceof ThomasFormField.AsyncValueFetcher.PendingResult.Invalid) {
                    MutableStateFlow mutableStateFlow = this.$validationStatus;
                    do {
                        value2 = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value2, ValidationState.INVALID));
                } else if (pendingResult instanceof ThomasFormField.AsyncValueFetcher.PendingResult.Valid) {
                    MutableStateFlow mutableStateFlow2 = this.$validationStatus;
                    do {
                        value = mutableStateFlow2.getValue();
                    } while (!mutableStateFlow2.compareAndSet(value, ValidationState.VALID));
                }
            }
            return Unit.INSTANCE;
        }
    }
}
