package com.allegion.accessblecredential.enums;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/allegion/accessblecredential/enums/AlReply;", "", "", "lockReplyValue", "Ljava/lang/String;", "getLockReplyValue", "()Ljava/lang/String;", "setLockReplyValue", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "DATA_SUCCESS", "DATA_FAILURE", "SUCCESS", "FAIL", "UNKNOWN", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public enum AlReply {
    DATA_SUCCESS("dataSuccess"),
    DATA_FAILURE("dataFailure"),
    SUCCESS("credAccepted"),
    FAIL("credDenied"),
    UNKNOWN("credStatusUnknown");


    @NotNull
    private String lockReplyValue;

    AlReply(String str) {
        this.lockReplyValue = str;
    }

    @NotNull
    public final String getLockReplyValue() {
        return this.lockReplyValue;
    }

    public final void setLockReplyValue(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.lockReplyValue = str;
    }
}
