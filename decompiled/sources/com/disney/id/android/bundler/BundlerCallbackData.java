package com.disney.id.android.bundler;

import androidx.annotation.Keep;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u0001:\u0001!BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\u0011\u0010\u001a\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bHÆ\u0003JI\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0019\u0010\t\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/disney/id/android/bundler/BundlerCallbackData;", "", "bundleString", "", "bundlerURL", "errorType", "Lcom/disney/id/android/bundler/BundlerCallbackData$ErrorType;", "success", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/String;Ljava/lang/String;Lcom/disney/id/android/bundler/BundlerCallbackData$ErrorType;ZLjava/lang/Exception;)V", "getBundleString", "()Ljava/lang/String;", "getBundlerURL", "getError", "()Ljava/lang/Exception;", "getErrorType", "()Lcom/disney/id/android/bundler/BundlerCallbackData$ErrorType;", "getSuccess", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "ErrorType", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BundlerCallbackData {

    @Nullable
    private final String bundleString;

    @Nullable
    private final String bundlerURL;

    @Nullable
    private final Exception error;

    @Nullable
    private final ErrorType errorType;
    private final boolean success;

    public static /* synthetic */ BundlerCallbackData copy$default(BundlerCallbackData bundlerCallbackData, String str, String str2, ErrorType errorType, boolean z, Exception exc, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bundlerCallbackData.bundleString;
        }
        if ((i & 2) != 0) {
            str2 = bundlerCallbackData.bundlerURL;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            errorType = bundlerCallbackData.errorType;
        }
        ErrorType errorType2 = errorType;
        if ((i & 8) != 0) {
            z = bundlerCallbackData.success;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            exc = bundlerCallbackData.error;
        }
        return bundlerCallbackData.copy(str, str3, errorType2, z2, exc);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getBundleString() {
        return this.bundleString;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getBundlerURL() {
        return this.bundlerURL;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final ErrorType getErrorType() {
        return this.errorType;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Exception getError() {
        return this.error;
    }

    @NotNull
    public final BundlerCallbackData copy(@Nullable String bundleString, @Nullable String bundlerURL, @Nullable ErrorType errorType, boolean success, @Nullable Exception error) {
        return new BundlerCallbackData(bundleString, bundlerURL, errorType, success, error);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BundlerCallbackData)) {
            return false;
        }
        BundlerCallbackData bundlerCallbackData = (BundlerCallbackData) other;
        return Intrinsics.areEqual(this.bundleString, bundlerCallbackData.bundleString) && Intrinsics.areEqual(this.bundlerURL, bundlerCallbackData.bundlerURL) && this.errorType == bundlerCallbackData.errorType && this.success == bundlerCallbackData.success && Intrinsics.areEqual(this.error, bundlerCallbackData.error);
    }

    public int hashCode() {
        String str = this.bundleString;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.bundlerURL;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ErrorType errorType = this.errorType;
        int iHashCode3 = (((iHashCode2 + (errorType == null ? 0 : errorType.hashCode())) * 31) + Boolean.hashCode(this.success)) * 31;
        Exception exc = this.error;
        return iHashCode3 + (exc != null ? exc.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "BundlerCallbackData(bundleString=" + this.bundleString + ", bundlerURL=" + this.bundlerURL + ", errorType=" + this.errorType + ", success=" + this.success + ", error=" + this.error + ")";
    }

    public BundlerCallbackData(@Nullable String str, @Nullable String str2, @Nullable ErrorType errorType, boolean z, @Nullable Exception exc) {
        this.bundleString = str;
        this.bundlerURL = str2;
        this.errorType = errorType;
        this.success = z;
        this.error = exc;
    }

    public /* synthetic */ BundlerCallbackData(String str, String str2, ErrorType errorType, boolean z, Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : errorType, z, (i & 16) != 0 ? null : exc);
    }

    @Nullable
    public final String getBundleString() {
        return this.bundleString;
    }

    @Nullable
    public final String getBundlerURL() {
        return this.bundlerURL;
    }

    @Nullable
    public final ErrorType getErrorType() {
        return this.errorType;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    @Nullable
    public final Exception getError() {
        return this.error;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/disney/id/android/bundler/BundlerCallbackData$ErrorType;", "", "(Ljava/lang/String;I)V", "RuntimeError", "HTTPError", "WriteError", "ReadError", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ErrorType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ErrorType[] $VALUES;
        public static final ErrorType RuntimeError = new ErrorType("RuntimeError", 0);
        public static final ErrorType HTTPError = new ErrorType("HTTPError", 1);
        public static final ErrorType WriteError = new ErrorType("WriteError", 2);
        public static final ErrorType ReadError = new ErrorType("ReadError", 3);

        private static final /* synthetic */ ErrorType[] $values() {
            return new ErrorType[]{RuntimeError, HTTPError, WriteError, ReadError};
        }

        @NotNull
        public static EnumEntries<ErrorType> getEntries() {
            return $ENTRIES;
        }

        public static ErrorType valueOf(String str) {
            return (ErrorType) Enum.valueOf(ErrorType.class, str);
        }

        public static ErrorType[] values() {
            return (ErrorType[]) $VALUES.clone();
        }

        private ErrorType(String str, int i) {
        }

        static {
            ErrorType[] errorTypeArr$values = $values();
            $VALUES = errorTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(errorTypeArr$values);
        }
    }
}
