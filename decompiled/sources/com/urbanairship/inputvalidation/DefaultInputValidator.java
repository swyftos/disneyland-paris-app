package com.urbanairship.inputvalidation;

import com.urbanairship.channel.SmsValidationHandler;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.inputvalidation.AirshipInputValidation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ0\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010\u0018J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0016J\u0016\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010!J\u001e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010$R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/urbanairship/inputvalidation/DefaultInputValidator;", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Validator;", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;)V", "apiClient", "Lcom/urbanairship/inputvalidation/SmsValidatorApiInterface;", "overrides", "Lcom/urbanairship/inputvalidation/AirshipValidationOverride;", "(Lcom/urbanairship/inputvalidation/SmsValidatorApiInterface;Lcom/urbanairship/inputvalidation/AirshipValidationOverride;)V", "_smsDelegate", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/urbanairship/channel/SmsValidationHandler;", "legacySmsDelegate", "Lkotlinx/coroutines/flow/StateFlow;", "getLegacySmsDelegate", "()Lkotlinx/coroutines/flow/StateFlow;", "legacySmsValidation", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Result;", "address", "", "senderId", "prefix", "delegate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/channel/SmsValidationHandler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setLegacySmsDelegate", "", "validate", "request", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request;", "(Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "email", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Email;", "(Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Email;Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sms", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Sms;", "(Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Sms;Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDefaultInputValidator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultInputValidator.kt\ncom/urbanairship/inputvalidation/DefaultInputValidator\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,218:1\n230#2,5:219\n*S KotlinDebug\n*F\n+ 1 DefaultInputValidator.kt\ncom/urbanairship/inputvalidation/DefaultInputValidator\n*L\n39#1:219,5\n*E\n"})
/* loaded from: classes5.dex */
public final class DefaultInputValidator implements AirshipInputValidation.Validator {
    private static final Regex EMAIL_REGEX = new Regex("^[^@\\s]+@[^@\\s]+\\.[^@\\s.]+$");
    private final MutableStateFlow _smsDelegate;
    private final SmsValidatorApiInterface apiClient;
    private final AirshipValidationOverride overrides;

    /* renamed from: com.urbanairship.inputvalidation.DefaultInputValidator$legacySmsValidation$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultInputValidator.this.legacySmsValidation(null, null, null, null, this);
        }
    }

    /* renamed from: com.urbanairship.inputvalidation.DefaultInputValidator$validate$1, reason: invalid class name and case insensitive filesystem */
    static final class C11501 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11501(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultInputValidator.this.validate(null, this);
        }
    }

    /* renamed from: com.urbanairship.inputvalidation.DefaultInputValidator$validate$6, reason: invalid class name */
    static final class AnonymousClass6 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass6(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultInputValidator.this.validate((AirshipInputValidation.Request.Sms) null, (AirshipInputValidation.Request) null, this);
        }
    }

    public DefaultInputValidator(@NotNull SmsValidatorApiInterface apiClient, @Nullable AirshipValidationOverride airshipValidationOverride) {
        Intrinsics.checkNotNullParameter(apiClient, "apiClient");
        this.apiClient = apiClient;
        this.overrides = airshipValidationOverride;
        this._smsDelegate = StateFlowKt.MutableStateFlow(null);
    }

    public /* synthetic */ DefaultInputValidator(SmsValidatorApiInterface smsValidatorApiInterface, AirshipValidationOverride airshipValidationOverride, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(smsValidatorApiInterface, (i & 2) != 0 ? null : airshipValidationOverride);
    }

    public DefaultInputValidator(@NotNull AirshipRuntimeConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        SmsValidatorApiClient smsValidatorApiClient = new SmsValidatorApiClient(config, null, 2, null);
        int i = 0;
        this(new CachingSmsValidatorApiClient(smsValidatorApiClient, i, 2, null), config.getConfigOptions().validationOverride);
    }

    @Override // com.urbanairship.inputvalidation.AirshipInputValidation.Validator
    @NotNull
    public StateFlow<SmsValidationHandler> getLegacySmsDelegate() {
        return FlowKt.asStateFlow(this._smsDelegate);
    }

    @Override // com.urbanairship.inputvalidation.AirshipInputValidation.Validator
    public void setLegacySmsDelegate(@Nullable SmsValidationHandler delegate) {
        Object value;
        MutableStateFlow mutableStateFlow = this._smsDelegate;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, delegate));
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ca A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.urbanairship.inputvalidation.AirshipInputValidation.Validator
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object validate(@org.jetbrains.annotations.NotNull final com.urbanairship.inputvalidation.AirshipInputValidation.Request r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.inputvalidation.AirshipInputValidation.Result> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.inputvalidation.DefaultInputValidator.validate(com.urbanairship.inputvalidation.AirshipInputValidation$Request, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object validate(AirshipInputValidation.Request.Email email, AirshipInputValidation.Request request, Continuation continuation) {
        String strTrimSpaceAndNewLine = DefaultInputValidatorKt.trimSpaceAndNewLine(email.getRawInput());
        if (EMAIL_REGEX.containsMatchIn(strTrimSpaceAndNewLine)) {
            return new AirshipInputValidation.Result.Valid(strTrimSpaceAndNewLine);
        }
        return AirshipInputValidation.Result.Invalid.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object validate(com.urbanairship.inputvalidation.AirshipInputValidation.Request.Sms r8, final com.urbanairship.inputvalidation.AirshipInputValidation.Request r9, kotlin.coroutines.Continuation r10) throws java.security.InvalidParameterException {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.inputvalidation.DefaultInputValidator.validate(com.urbanairship.inputvalidation.AirshipInputValidation$Request$Sms, com.urbanairship.inputvalidation.AirshipInputValidation$Request, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object legacySmsValidation(java.lang.String r5, java.lang.String r6, java.lang.String r7, com.urbanairship.channel.SmsValidationHandler r8, kotlin.coroutines.Continuation r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.urbanairship.inputvalidation.DefaultInputValidator.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            com.urbanairship.inputvalidation.DefaultInputValidator$legacySmsValidation$1 r0 = (com.urbanairship.inputvalidation.DefaultInputValidator.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.inputvalidation.DefaultInputValidator$legacySmsValidation$1 r0 = new com.urbanairship.inputvalidation.DefaultInputValidator$legacySmsValidation$1
            r0.<init>(r9)
        L18:
            java.lang.Object r4 = r0.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r4)
            goto L78
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.throwOnFailure(r4)
            java.lang.String r4 = com.urbanairship.inputvalidation.DefaultInputValidatorKt.access$trimSpaceAndNewLine(r5)
            kotlin.text.Regex r5 = new kotlin.text.Regex
            java.lang.String r1 = "[^0-9]"
            r5.<init>(r1)
            java.lang.String r3 = ""
            java.lang.String r4 = r5.replace(r4, r3)
            if (r7 == 0) goto L6c
            kotlin.text.Regex r5 = new kotlin.text.Regex
            r5.<init>(r1)
            java.lang.String r5 = r5.replace(r7, r3)
            r7 = 2
            r1 = 0
            r3 = 0
            boolean r7 = kotlin.text.StringsKt.startsWith$default(r4, r5, r3, r7, r1)
            if (r7 != 0) goto L6c
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r5)
            r7.append(r4)
            java.lang.String r4 = r7.toString()
        L6c:
            r5 = r4
            r0.L$0 = r5
            r0.label = r2
            java.lang.Object r4 = r8.validateSms(r5, r6, r0)
            if (r4 != r9) goto L78
            return r9
        L78:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L86
            com.urbanairship.inputvalidation.AirshipInputValidation$Result$Valid r4 = new com.urbanairship.inputvalidation.AirshipInputValidation$Result$Valid
            r4.<init>(r5)
            goto L88
        L86:
            com.urbanairship.inputvalidation.AirshipInputValidation$Result$Invalid r4 = com.urbanairship.inputvalidation.AirshipInputValidation.Result.Invalid.INSTANCE
        L88:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.inputvalidation.DefaultInputValidator.legacySmsValidation(java.lang.String, java.lang.String, java.lang.String, com.urbanairship.channel.SmsValidationHandler, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
