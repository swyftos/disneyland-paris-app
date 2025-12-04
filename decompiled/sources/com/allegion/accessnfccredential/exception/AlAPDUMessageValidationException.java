package com.allegion.accessnfccredential.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0013\b\u0016\u0012\n\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0002\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0002\u0010\bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0005R\"\u0010\f\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/allegion/accessnfccredential/exception/AlAPDUMessageValidationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorMessage", "", "(Ljava/lang/String;)V", "e", "(Ljava/lang/Exception;)V", "(Ljava/lang/String;Ljava/lang/Exception;)V", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "exception", "getException", "()Ljava/lang/Exception;", "setException", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlAPDUMessageValidationException extends Exception {

    @NotNull
    private String errorMessage;

    @Nullable
    private Exception exception;

    @NotNull
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.errorMessage = str;
    }

    @Nullable
    public final Exception getException() {
        return this.exception;
    }

    public final void setException(@Nullable Exception exc) {
        this.exception = exc;
    }

    public AlAPDUMessageValidationException(@NotNull String errorMessage) {
        Intrinsics.checkParameterIsNotNull(errorMessage, "errorMessage");
        this.errorMessage = errorMessage;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlAPDUMessageValidationException(@NotNull Exception e) {
        super(e);
        Intrinsics.checkParameterIsNotNull(e, "e");
        this.errorMessage = "Error validating ISO 7816 Message";
    }

    public AlAPDUMessageValidationException(@NotNull String errorMessage, @NotNull Exception e) {
        Intrinsics.checkParameterIsNotNull(errorMessage, "errorMessage");
        Intrinsics.checkParameterIsNotNull(e, "e");
        this.errorMessage = errorMessage;
        this.exception = e;
    }
}
