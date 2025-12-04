package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/allegion/accesssdk/exceptions/AlAuthenticationException;", "Lcom/allegion/accesssdk/exceptions/AlException;", "<init>", "()V", "", "message", "(Ljava/lang/String;)V", "", "cause", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "Companion", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlAuthenticationException extends AlException {
    public AlAuthenticationException() {
        super(AlErrorCode.UNKNOWN_ERROR, "An unknown error occurred while attempting to authenticate the user", "");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlAuthenticationException(@NotNull String message) {
        super(AlErrorCode.UNKNOWN_ERROR, message, "");
        Intrinsics.checkParameterIsNotNull(message, "message");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlAuthenticationException(@NotNull String message, @NotNull Throwable cause) {
        super(AlErrorCode.UNKNOWN_ERROR, message, "", cause);
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(cause, "cause");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlAuthenticationException(@NotNull Throwable cause) {
        super(AlErrorCode.UNKNOWN_ERROR, "An unknown error occurred while attempting to authenticate the user", "", cause);
        Intrinsics.checkParameterIsNotNull(cause, "cause");
    }
}
