package com.urbanairship.http;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\u0005H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u0006\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/http/AuthTokenProvider;", "", "expireToken", "", "token", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchToken", "Lkotlin/Result;", "identifier", "fetchToken-gIAlu-s", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface AuthTokenProvider {
    @Nullable
    Object expireToken(@NotNull String str, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    /* renamed from: fetchToken-gIAlu-s */
    Object mo2833fetchTokengIAlus(@NotNull String str, @NotNull Continuation<? super Result<String>> continuation);
}
