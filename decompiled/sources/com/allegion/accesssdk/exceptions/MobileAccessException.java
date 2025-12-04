package com.allegion.accesssdk.exceptions;

import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003BA\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b+\u0010,J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0006JL\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0011\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010\tR\u0019\u0010\u0012\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\fR\u0019\u0010\u0014\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b&\u0010\u0006R\u0019\u0010\u0015\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b'\u0010\u0006R\u0019\u0010\u0013\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b(\u0010\u0006R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b)\u0010%R\u0019\u0010\u0016\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b*\u0010\u0006¨\u0006-"}, d2 = {"Lcom/allegion/accesssdk/exceptions/MobileAccessException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Ljava/io/Serializable;", "", "toString", "()Ljava/lang/String;", "", "component1", "()Ljava/lang/Throwable;", "Lcom/allegion/accesssdk/exceptions/MobileAccessExceptionType;", "component2", "()Lcom/allegion/accesssdk/exceptions/MobileAccessExceptionType;", "component3", "component4", "component5", "component6", "source", "mobileAccessExceptionType", "errorDescription", "failureReason", "recoverySuggestion", "helpAnchor", "copy", "(Ljava/lang/Throwable;Lcom/allegion/accesssdk/exceptions/MobileAccessExceptionType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/allegion/accesssdk/exceptions/MobileAccessException;", "", "hashCode", "()I", "", ETCPaymentMethod.OTHER, "", ExactValueMatcher.EQUALS_VALUE_KEY, "(Ljava/lang/Object;)Z", "Ljava/lang/Throwable;", "getSource", "Lcom/allegion/accesssdk/exceptions/MobileAccessExceptionType;", "getMobileAccessExceptionType", "Ljava/lang/String;", "getFailureReason", "getRecoverySuggestion", "getErrorDescription", "domain", "getHelpAnchor", "<init>", "(Ljava/lang/Throwable;Lcom/allegion/accesssdk/exceptions/MobileAccessExceptionType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final /* data */ class MobileAccessException extends RuntimeException implements Serializable {
    private final String domain;

    @NotNull
    private final String errorDescription;

    @NotNull
    private final String failureReason;

    @NotNull
    private final String helpAnchor;

    @NotNull
    private final MobileAccessExceptionType mobileAccessExceptionType;

    @NotNull
    private final String recoverySuggestion;

    @NotNull
    private final Throwable source;

    @JvmOverloads
    public MobileAccessException(@NotNull Throwable th, @NotNull MobileAccessExceptionType mobileAccessExceptionType) {
        this(th, mobileAccessExceptionType, null, null, null, null, 60, null);
    }

    @JvmOverloads
    public MobileAccessException(@NotNull Throwable th, @NotNull MobileAccessExceptionType mobileAccessExceptionType, @NotNull String str) {
        this(th, mobileAccessExceptionType, str, null, null, null, 56, null);
    }

    @JvmOverloads
    public MobileAccessException(@NotNull Throwable th, @NotNull MobileAccessExceptionType mobileAccessExceptionType, @NotNull String str, @NotNull String str2) {
        this(th, mobileAccessExceptionType, str, str2, null, null, 48, null);
    }

    @JvmOverloads
    public MobileAccessException(@NotNull Throwable th, @NotNull MobileAccessExceptionType mobileAccessExceptionType, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        this(th, mobileAccessExceptionType, str, str2, str3, null, 32, null);
    }

    public /* synthetic */ MobileAccessException(Throwable th, MobileAccessExceptionType mobileAccessExceptionType, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, mobileAccessExceptionType, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? "" : str3, (i & 32) != 0 ? "" : str4);
    }

    public static /* synthetic */ MobileAccessException copy$default(MobileAccessException mobileAccessException, Throwable th, MobileAccessExceptionType mobileAccessExceptionType, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            th = mobileAccessException.source;
        }
        if ((i & 2) != 0) {
            mobileAccessExceptionType = mobileAccessException.mobileAccessExceptionType;
        }
        MobileAccessExceptionType mobileAccessExceptionType2 = mobileAccessExceptionType;
        if ((i & 4) != 0) {
            str = mobileAccessException.errorDescription;
        }
        String str5 = str;
        if ((i & 8) != 0) {
            str2 = mobileAccessException.failureReason;
        }
        String str6 = str2;
        if ((i & 16) != 0) {
            str3 = mobileAccessException.recoverySuggestion;
        }
        String str7 = str3;
        if ((i & 32) != 0) {
            str4 = mobileAccessException.helpAnchor;
        }
        return mobileAccessException.copy(th, mobileAccessExceptionType2, str5, str6, str7, str4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Throwable getSource() {
        return this.source;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final MobileAccessExceptionType getMobileAccessExceptionType() {
        return this.mobileAccessExceptionType;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getErrorDescription() {
        return this.errorDescription;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getFailureReason() {
        return this.failureReason;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getRecoverySuggestion() {
        return this.recoverySuggestion;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getHelpAnchor() {
        return this.helpAnchor;
    }

    @NotNull
    public final MobileAccessException copy(@NotNull Throwable source, @NotNull MobileAccessExceptionType mobileAccessExceptionType, @NotNull String errorDescription, @NotNull String failureReason, @NotNull String recoverySuggestion, @NotNull String helpAnchor) {
        Intrinsics.checkParameterIsNotNull(source, "source");
        Intrinsics.checkParameterIsNotNull(mobileAccessExceptionType, "mobileAccessExceptionType");
        Intrinsics.checkParameterIsNotNull(errorDescription, "errorDescription");
        Intrinsics.checkParameterIsNotNull(failureReason, "failureReason");
        Intrinsics.checkParameterIsNotNull(recoverySuggestion, "recoverySuggestion");
        Intrinsics.checkParameterIsNotNull(helpAnchor, "helpAnchor");
        return new MobileAccessException(source, mobileAccessExceptionType, errorDescription, failureReason, recoverySuggestion, helpAnchor);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MobileAccessException)) {
            return false;
        }
        MobileAccessException mobileAccessException = (MobileAccessException) other;
        return Intrinsics.areEqual(this.source, mobileAccessException.source) && Intrinsics.areEqual(this.mobileAccessExceptionType, mobileAccessException.mobileAccessExceptionType) && Intrinsics.areEqual(this.errorDescription, mobileAccessException.errorDescription) && Intrinsics.areEqual(this.failureReason, mobileAccessException.failureReason) && Intrinsics.areEqual(this.recoverySuggestion, mobileAccessException.recoverySuggestion) && Intrinsics.areEqual(this.helpAnchor, mobileAccessException.helpAnchor);
    }

    @NotNull
    public final String getErrorDescription() {
        return this.errorDescription;
    }

    @NotNull
    public final String getFailureReason() {
        return this.failureReason;
    }

    @NotNull
    public final String getHelpAnchor() {
        return this.helpAnchor;
    }

    @NotNull
    public final MobileAccessExceptionType getMobileAccessExceptionType() {
        return this.mobileAccessExceptionType;
    }

    @NotNull
    public final String getRecoverySuggestion() {
        return this.recoverySuggestion;
    }

    @NotNull
    public final Throwable getSource() {
        return this.source;
    }

    public int hashCode() {
        Throwable th = this.source;
        int iHashCode = (th != null ? th.hashCode() : 0) * 31;
        MobileAccessExceptionType mobileAccessExceptionType = this.mobileAccessExceptionType;
        int iHashCode2 = (iHashCode + (mobileAccessExceptionType != null ? mobileAccessExceptionType.hashCode() : 0)) * 31;
        String str = this.errorDescription;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.failureReason;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.recoverySuggestion;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.helpAnchor;
        return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    @NotNull
    public String toString() {
        return "domain: [" + this.domain + "] errorcode: [" + this.mobileAccessExceptionType.getErrorCode() + "] status: [" + this.errorDescription + "], error: [" + this.source.getLocalizedMessage() + "], errorDescription: [" + this.errorDescription + "], failureReason: [" + this.failureReason + "], recoverySuggestion: [" + this.recoverySuggestion + "], helpAnchor: [" + this.helpAnchor + AbstractJsonLexerKt.END_LIST;
    }

    @JvmOverloads
    public MobileAccessException(@NotNull Throwable source, @NotNull MobileAccessExceptionType mobileAccessExceptionType, @NotNull String errorDescription, @NotNull String failureReason, @NotNull String recoverySuggestion, @NotNull String helpAnchor) {
        Intrinsics.checkParameterIsNotNull(source, "source");
        Intrinsics.checkParameterIsNotNull(mobileAccessExceptionType, "mobileAccessExceptionType");
        Intrinsics.checkParameterIsNotNull(errorDescription, "errorDescription");
        Intrinsics.checkParameterIsNotNull(failureReason, "failureReason");
        Intrinsics.checkParameterIsNotNull(recoverySuggestion, "recoverySuggestion");
        Intrinsics.checkParameterIsNotNull(helpAnchor, "helpAnchor");
        this.source = source;
        this.mobileAccessExceptionType = mobileAccessExceptionType;
        this.errorDescription = errorDescription;
        this.failureReason = failureReason;
        this.recoverySuggestion = recoverySuggestion;
        this.helpAnchor = helpAnchor;
        this.domain = "com.allegion.MobileAccessSDK";
    }
}
