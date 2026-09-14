package com.urbanairship.inputvalidation;

import com.urbanairship.http.RequestResult;
import java.security.InvalidParameterException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\bJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\b¨\u0006\u000bÀ\u0006\u0003"}, m1836d2 = {"Lcom/urbanairship/inputvalidation/SmsValidatorApiInterface;", "", "validateSmsWithPrefix", "Lcom/urbanairship/http/RequestResult;", "Lcom/urbanairship/inputvalidation/SmsValidatorApiClient$Result;", "msisdn", "", "prefix", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateSmsWithSender", "sender", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public interface SmsValidatorApiInterface {
    @Nullable
    Object validateSmsWithPrefix(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super RequestResult<SmsValidatorApiClient.Result>> continuation) throws InvalidParameterException;

    @Nullable
    Object validateSmsWithSender(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super RequestResult<SmsValidatorApiClient.Result>> continuation) throws InvalidParameterException;
}
