package com.disney.id.android;

import androidx.annotation.Keep;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00192\u00060\u0001j\u0002`\u0002:\u0001\u0019B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/disney/id/android/OneIDError;", "Ljava/lang/Error;", "Lkotlin/Error;", "code", "", "message", "throwable", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "getCode", "()Ljava/lang/String;", "getMessage", "getThrowable", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OneIDError extends Error {

    @NotNull
    public static final String AGE_GATED = "AGE_GATED";

    @NotNull
    public static final String ALREADY_OPT_IN = "ALREADY_OPT_IN";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String EMAIL_MISMATCH = "EMAIL_MISMATCH";

    @NotNull
    public static final String EMAIL_VERIFICATION_FAILURE = "EMAIL_VERIFICATION_FAILURE";

    @NotNull
    public static final String GUEST_MISSING = "GUEST_MISSING";

    @NotNull
    public static final String HEADLESS_DISALLOWED = "HEADLESS_DISALLOWED";

    @NotNull
    public static final String INVALID_CONFIG = "INVALID_CONFIG";

    @NotNull
    public static final String INVALID_EMAIL = "INVALID_EMAIL";

    @NotNull
    public static final String INVALID_JSON = "INVALID_JSON";

    @NotNull
    public static final String INVALID_LOCATION = "INVALID_LOCATION";

    @NotNull
    public static final String INVALID_LOGIN_VALUE = "INVALID_LOGIN_VALUE";

    @NotNull
    public static final String INVALID_PASSWORD = "INVALID_PASSWORD";

    @NotNull
    public static final String INVALID_PROMOTION_ID = "INVALID_PROMOTION_ID";

    @NotNull
    public static final String INVALID_STATE = "INVALID_STATE";

    @NotNull
    public static final String INVALID_VALUE = "INVALID_VALUE";

    @NotNull
    public static final String LOW_TRUST = "LOW_TRUST";

    @NotNull
    public static final String MISSING_VALUE = "MISSING_VALUE";

    @NotNull
    public static final String NOT_LOGGED_IN = "NOT_LOGGED_IN";

    @NotNull
    public static final String NO_CONNECTION = "NO_CONNECTION";

    @NotNull
    public static final String NO_VALID_CAMPAIGN = "NO_VALID_CAMPAIGN";

    @NotNull
    public static final String PASSWORD_IS_EMPTY = "PASSWORD_IS_EMPTY";

    @NotNull
    private static final String PASSWORD_IS_INVALID = "PASSWORD_IS_INVALID";

    @NotNull
    public static final String PASSWORD_IS_MISSING_SPECIAL_CHARACTERS = "PASSWORD_IS_MISSING_SPECIAL_CHARACTERS";

    @NotNull
    public static final String PASSWORD_IS_TOO_LONG = "PASSWORD_IS_TOO_LONG";

    @NotNull
    public static final String PASSWORD_IS_TOO_SHORT = "PASSWORD_IS_TOO_SHORT";

    @NotNull
    public static final String TIMED_OUT = "TIMED_OUT";

    @NotNull
    public static final String UNKNOWN = "UNKNOWN_ERROR";

    @NotNull
    public static final String USER_CANCELLED = "USER_CANCELLED";

    @NotNull
    public static final String USER_LOGGED_OUT = "USER_LOGGED_OUT";

    @NotNull
    private final String code;

    @Nullable
    private final String message;

    @Nullable
    private final Throwable throwable;

    public static /* synthetic */ OneIDError copy$default(OneIDError oneIDError, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            str = oneIDError.code;
        }
        if ((i & 2) != 0) {
            str2 = oneIDError.message;
        }
        if ((i & 4) != 0) {
            th = oneIDError.throwable;
        }
        return oneIDError.copy(str, str2, th);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Throwable getThrowable() {
        return this.throwable;
    }

    @NotNull
    public final OneIDError copy(@NotNull String code, @Nullable String message, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(code, "code");
        return new OneIDError(code, message, throwable);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OneIDError)) {
            return false;
        }
        OneIDError oneIDError = (OneIDError) other;
        return Intrinsics.areEqual(this.code, oneIDError.code) && Intrinsics.areEqual(this.message, oneIDError.message) && Intrinsics.areEqual(this.throwable, oneIDError.throwable);
    }

    public int hashCode() {
        int iHashCode = this.code.hashCode() * 31;
        String str = this.message;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Throwable th = this.throwable;
        return iHashCode2 + (th != null ? th.hashCode() : 0);
    }

    public /* synthetic */ OneIDError(String str, String str2, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : th);
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    @Nullable
    public String getMessage() {
        return this.message;
    }

    @Nullable
    public final Throwable getThrowable() {
        return this.throwable;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneIDError(@NotNull String code, @Nullable String str, @Nullable Throwable th) {
        super(str == null ? "" : str, th);
        Intrinsics.checkNotNullParameter(code, "code");
        this.code = code;
        this.message = str;
        this.throwable = th;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010!\u001a\u00020\"H\u0000¢\u0006\u0002\b#J\r\u0010$\u001a\u00020\"H\u0000¢\u0006\u0002\b%J\r\u0010&\u001a\u00020\"H\u0000¢\u0006\u0002\b'J\r\u0010(\u001a\u00020\"H\u0000¢\u0006\u0002\b)J\u0019\u0010*\u001a\u00020\"2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,H\u0000¢\u0006\u0002\b-J\r\u0010.\u001a\u00020\"H\u0000¢\u0006\u0002\b/J\r\u00100\u001a\u00020\"H\u0000¢\u0006\u0002\b1R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/disney/id/android/OneIDError$Companion;", "", "()V", "AGE_GATED", "", "ALREADY_OPT_IN", "EMAIL_MISMATCH", OneIDError.EMAIL_VERIFICATION_FAILURE, OneIDError.GUEST_MISSING, "HEADLESS_DISALLOWED", OneIDError.INVALID_CONFIG, "INVALID_EMAIL", "INVALID_JSON", "INVALID_LOCATION", "INVALID_LOGIN_VALUE", OneIDError.INVALID_PASSWORD, "INVALID_PROMOTION_ID", OneIDError.INVALID_STATE, "INVALID_VALUE", OneIDError.LOW_TRUST, "MISSING_VALUE", "NOT_LOGGED_IN", "NO_CONNECTION", "NO_VALID_CAMPAIGN", OneIDError.PASSWORD_IS_EMPTY, OneIDError.PASSWORD_IS_INVALID, OneIDError.PASSWORD_IS_MISSING_SPECIAL_CHARACTERS, OneIDError.PASSWORD_IS_TOO_LONG, OneIDError.PASSWORD_IS_TOO_SHORT, "TIMED_OUT", "UNKNOWN", "USER_CANCELLED", OneIDError.USER_LOGGED_OUT, "buildAlreadyOptIn", "Lcom/disney/id/android/OneIDError;", "buildAlreadyOptIn$OneID_release", "buildHeadlessDisallowed", "buildHeadlessDisallowed$OneID_release", "buildPasswordIsEmpty", "buildPasswordIsEmpty$OneID_release", "buildPasswordIsInvalid", "buildPasswordIsInvalid$OneID_release", "buildPasswordIsMissingSpecialCharacters", "throwable", "", "buildPasswordIsMissingSpecialCharacters$OneID_release", "buildPasswordIsTooLong", "buildPasswordIsTooLong$OneID_release", "buildPasswordIsTooShort", "buildPasswordIsTooShort$OneID_release", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final OneIDError buildHeadlessDisallowed$OneID_release() {
            return new OneIDError("HEADLESS_DISALLOWED", "Headless is not allowed", null, 4, null);
        }

        @NotNull
        public final OneIDError buildAlreadyOptIn$OneID_release() {
            return new OneIDError("ALREADY_OPT_IN", "Guest is already opted into all marketing", null, 4, null);
        }

        @NotNull
        public final OneIDError buildPasswordIsEmpty$OneID_release() {
            return new OneIDError(OneIDError.PASSWORD_IS_EMPTY, "Password must contain non-blank characters", null, 4, null);
        }

        @NotNull
        public final OneIDError buildPasswordIsTooShort$OneID_release() {
            return new OneIDError(OneIDError.PASSWORD_IS_TOO_SHORT, "Password must be at least 6 characters long", null, 4, null);
        }

        @NotNull
        public final OneIDError buildPasswordIsTooLong$OneID_release() {
            return new OneIDError(OneIDError.PASSWORD_IS_TOO_LONG, "Password must be less than 256 characters long", null, 4, null);
        }

        public static /* synthetic */ OneIDError buildPasswordIsMissingSpecialCharacters$OneID_release$default(Companion companion, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = null;
            }
            return companion.buildPasswordIsMissingSpecialCharacters$OneID_release(th);
        }

        @NotNull
        public final OneIDError buildPasswordIsMissingSpecialCharacters$OneID_release(@Nullable Throwable throwable) {
            return new OneIDError(OneIDError.PASSWORD_IS_MISSING_SPECIAL_CHARACTERS, "Password does not contain any special characters", throwable);
        }

        @NotNull
        public final OneIDError buildPasswordIsInvalid$OneID_release() {
            return new OneIDError(OneIDError.PASSWORD_IS_INVALID, "Password is not valid", null, 4, null);
        }
    }

    @Override // java.lang.Throwable
    @NotNull
    public String toString() {
        String str;
        Throwable th = this.throwable;
        if (th != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintWriter printWriter = new PrintWriter(byteArrayOutputStream);
            th.printStackTrace(printWriter);
            printWriter.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
            str = new String(byteArray, Charsets.UTF_8);
        } else {
            str = null;
        }
        return CollectionsKt.joinToString$default(ArraysKt.filterNotNull(new String[]{this.code, getMessage(), str}), " ", null, null, 0, null, null, 62, null);
    }
}
