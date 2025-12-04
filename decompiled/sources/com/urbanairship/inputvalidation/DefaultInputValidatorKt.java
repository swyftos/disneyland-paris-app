package com.urbanairship.inputvalidation;

import com.urbanairship.inputvalidation.AirshipInputValidation;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\f\u0010\u000b\u001a\u00020\n*\u00020\nH\u0002¨\u0006\f"}, d2 = {"getSuspending", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Override;", "Lcom/urbanairship/inputvalidation/AirshipValidationOverride;", "request", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request;", "(Lcom/urbanairship/inputvalidation/AirshipValidationOverride;Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "matches", "", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Sms$ValidationHints;", "input", "", "trimSpaceAndNewLine", "urbanairship-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDefaultInputValidator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultInputValidator.kt\ncom/urbanairship/inputvalidation/DefaultInputValidatorKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,218:1\n429#2:219\n502#2,5:220\n*S KotlinDebug\n*F\n+ 1 DefaultInputValidator.kt\ncom/urbanairship/inputvalidation/DefaultInputValidatorKt\n*L\n207#1:219\n207#1:220,5\n*E\n"})
/* loaded from: classes5.dex */
public final class DefaultInputValidatorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getSuspending(AirshipValidationOverride airshipValidationOverride, AirshipInputValidation.Request request, Continuation continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        safeContinuation.resumeWith(Result.m2968constructorimpl(airshipValidationOverride.getOverrides(request).get()));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String trimSpaceAndNewLine(String str) {
        return StringsKt.trim(StringsKt.replace$default(str, "\n", "", false, 4, (Object) null)).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean matches(AirshipInputValidation.Request.Sms.ValidationHints validationHints, String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Character.isDigit(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        int minDigits = validationHints.getMinDigits();
        int maxDigits = validationHints.getMaxDigits();
        int length2 = string.length();
        return minDigits <= length2 && length2 <= maxDigits;
    }
}
