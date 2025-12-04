package com.urbanairship.automation.audiencecheck;

import com.urbanairship.audience.DeviceInfoProvider;
import com.urbanairship.automation.AdditionalAudienceCheckOverrides;
import com.urbanairship.json.JsonValue;
import com.urbanairship.remoteconfig.AdditionalAudienceCheckConfig;
import java.security.InvalidParameterException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
final class AdditionalAudienceCheckerResolver$resolve$3 extends SuspendLambda implements Function1 {
    final /* synthetic */ AdditionalAudienceCheckConfig $config;
    final /* synthetic */ DeviceInfoProvider $deviceInfoProvider;
    final /* synthetic */ AdditionalAudienceCheckOverrides $overrides;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ AdditionalAudienceCheckerResolver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdditionalAudienceCheckerResolver$resolve$3(AdditionalAudienceCheckerResolver additionalAudienceCheckerResolver, String str, AdditionalAudienceCheckOverrides additionalAudienceCheckOverrides, AdditionalAudienceCheckConfig additionalAudienceCheckConfig, DeviceInfoProvider deviceInfoProvider, Continuation continuation) {
        super(1, continuation);
        this.this$0 = additionalAudienceCheckerResolver;
        this.$url = str;
        this.$overrides = additionalAudienceCheckOverrides;
        this.$config = additionalAudienceCheckConfig;
        this.$deviceInfoProvider = deviceInfoProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new AdditionalAudienceCheckerResolver$resolve$3(this.this$0, this.$url, this.$overrides, this.$config, this.$deviceInfoProvider, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((AdditionalAudienceCheckerResolver$resolve$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws InvalidParameterException {
        JsonValue context;
        Object objM2797doResolveBWLJW6A;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AdditionalAudienceCheckerResolver additionalAudienceCheckerResolver = this.this$0;
            String str = this.$url;
            AdditionalAudienceCheckOverrides additionalAudienceCheckOverrides = this.$overrides;
            if (additionalAudienceCheckOverrides == null || (context = additionalAudienceCheckOverrides.getContext()) == null) {
                context = this.$config.getContext();
            }
            DeviceInfoProvider deviceInfoProvider = this.$deviceInfoProvider;
            this.label = 1;
            objM2797doResolveBWLJW6A = additionalAudienceCheckerResolver.m2797doResolveBWLJW6A(str, context, deviceInfoProvider, this);
            if (objM2797doResolveBWLJW6A == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objM2797doResolveBWLJW6A = ((Result) obj).getValue();
        }
        return Result.m2967boximpl(objM2797doResolveBWLJW6A);
    }
}
