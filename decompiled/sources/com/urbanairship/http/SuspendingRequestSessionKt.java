package com.urbanairship.http;

import androidx.annotation.RestrictTo;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0007¨\u0006\t"}, d2 = {"log", "", "Lcom/urbanairship/http/RequestResult;", "message", "Lkotlin/Function0;", "", "toSuspendingRequestSession", "Lcom/urbanairship/http/SuspendingRequestSession;", "Lcom/urbanairship/http/RequestSession;", "urbanairship-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SuspendingRequestSessionKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final SuspendingRequestSession toSuspendingRequestSession(@NotNull RequestSession requestSession) {
        Intrinsics.checkNotNullParameter(requestSession, "<this>");
        return new SuspendingRequestSession(requestSession);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final void log(@NotNull RequestResult<?> requestResult, @NotNull Function0<String> message) {
        Intrinsics.checkNotNullParameter(requestResult, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        if (requestResult.getException() != null) {
            Throwable exception = requestResult.getException();
            if (exception instanceof JsonException) {
                UALog.log(6, requestResult.getException(), message);
                return;
            } else if (exception instanceof RequestException) {
                UALog.log(3, requestResult.getException(), message);
                return;
            } else {
                UALog.log(5, requestResult.getException(), message);
                return;
            }
        }
        if (requestResult.isClientError()) {
            UALog.log(6, null, message);
        } else {
            UALog.log(3, null, message);
        }
    }
}
