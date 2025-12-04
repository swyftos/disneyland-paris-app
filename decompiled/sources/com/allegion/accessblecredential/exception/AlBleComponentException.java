package com.allegion.accessblecredential.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\tB\u0015\b\u0016\u0012\n\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0010\u0010\u000fB\u001d\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0010\u0010\u0012R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/allegion/accessblecredential/exception/AlBleComponentException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "errorMessage", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "exception", "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", "setException", "(Ljava/lang/Exception;)V", "<init>", "e", "(Ljava/lang/String;Ljava/lang/Exception;)V", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlBleComponentException extends Exception {

    @Nullable
    private String errorMessage;

    @Nullable
    private Exception exception;

    public AlBleComponentException(@NotNull String errorMessage) {
        Intrinsics.checkParameterIsNotNull(errorMessage, "errorMessage");
        this.errorMessage = errorMessage;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @Nullable
    public final Exception getException() {
        return this.exception;
    }

    public final void setErrorMessage(@Nullable String str) {
        this.errorMessage = str;
    }

    public final void setException(@Nullable Exception exc) {
        this.exception = exc;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlBleComponentException(@NotNull Exception e) {
        super(e);
        Intrinsics.checkParameterIsNotNull(e, "e");
    }

    public AlBleComponentException(@NotNull String errorMessage, @NotNull Exception e) {
        Intrinsics.checkParameterIsNotNull(errorMessage, "errorMessage");
        Intrinsics.checkParameterIsNotNull(e, "e");
        this.errorMessage = errorMessage;
        this.exception = e;
    }
}
