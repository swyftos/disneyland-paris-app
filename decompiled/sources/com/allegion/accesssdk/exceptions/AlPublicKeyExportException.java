package com.allegion.accesssdk.exceptions;

import com.allegion.accesssdk.enums.AlErrorCode;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B;\b\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/allegion/accesssdk/exceptions/AlPublicKeyExportException;", "Lcom/allegion/accesssdk/exceptions/AlException;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "", "cause", "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "Lcom/allegion/accesssdk/enums/AlErrorCode;", "errorCode", "title", "status", "<init>", "(Lcom/allegion/accesssdk/enums/AlErrorCode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "Companion", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlPublicKeyExportException extends AlException {

    @NotNull
    private final Throwable cause;

    @NotNull
    private final String message;

    @JvmOverloads
    public AlPublicKeyExportException() {
        this(null, null, null, null, null, 31, null);
    }

    @JvmOverloads
    public AlPublicKeyExportException(@NotNull AlErrorCode alErrorCode) {
        this(alErrorCode, null, null, null, null, 30, null);
    }

    @JvmOverloads
    public AlPublicKeyExportException(@NotNull AlErrorCode alErrorCode, @NotNull String str) {
        this(alErrorCode, str, null, null, null, 28, null);
    }

    @JvmOverloads
    public AlPublicKeyExportException(@NotNull AlErrorCode alErrorCode, @NotNull String str, @NotNull String str2) {
        this(alErrorCode, str, str2, null, null, 24, null);
    }

    @JvmOverloads
    public AlPublicKeyExportException(@NotNull AlErrorCode alErrorCode, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        this(alErrorCode, str, str2, str3, null, 16, null);
    }

    public /* synthetic */ AlPublicKeyExportException(AlErrorCode alErrorCode, String str, String str2, String str3, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AlErrorCode.DEVICE_PUBLIC_KEY_EXPORT_ERROR : alErrorCode, (i & 2) != 0 ? "Failure When Exporting ECC Public Key" : str, (i & 4) != 0 ? "SDK was unable to export the device public key. Please re-enroll your device or re-attempt to request access payloads." : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? new Exception() : th);
    }

    @Override // java.lang.Throwable
    @NotNull
    public Throwable getCause() {
        return this.cause;
    }

    @Override // java.lang.Throwable
    @NotNull
    public String getMessage() {
        return this.message;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AlPublicKeyExportException(@NotNull AlErrorCode errorCode, @NotNull String title, @NotNull String message, @NotNull String status, @NotNull Throwable cause) {
        super(errorCode, title, status, cause);
        Intrinsics.checkParameterIsNotNull(errorCode, "errorCode");
        Intrinsics.checkParameterIsNotNull(title, "title");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(status, "status");
        Intrinsics.checkParameterIsNotNull(cause, "cause");
        this.message = message;
        this.cause = cause;
    }
}
