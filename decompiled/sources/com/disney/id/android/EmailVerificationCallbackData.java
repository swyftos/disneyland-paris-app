package com.disney.id.android;

import androidx.annotation.Keep;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/disney/id/android/EmailVerificationCallbackData;", "Lcom/disney/id/android/OneIDCallbackData;", "success", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/disney/id/android/OneIDError;", "(ZLcom/disney/id/android/OneIDError;)V", "getError", "()Lcom/disney/id/android/OneIDError;", "getSuccess", "()Z", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class EmailVerificationCallbackData extends OneIDCallbackData {

    @Nullable
    private final OneIDError error;
    private final boolean success;

    public static /* synthetic */ EmailVerificationCallbackData copy$default(EmailVerificationCallbackData emailVerificationCallbackData, boolean z, OneIDError oneIDError, int i, Object obj) {
        if ((i & 1) != 0) {
            z = emailVerificationCallbackData.success;
        }
        if ((i & 2) != 0) {
            oneIDError = emailVerificationCallbackData.error;
        }
        return emailVerificationCallbackData.copy(z, oneIDError);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final OneIDError getError() {
        return this.error;
    }

    @NotNull
    public final EmailVerificationCallbackData copy(boolean success, @Nullable OneIDError error) {
        return new EmailVerificationCallbackData(success, error);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmailVerificationCallbackData)) {
            return false;
        }
        EmailVerificationCallbackData emailVerificationCallbackData = (EmailVerificationCallbackData) other;
        return this.success == emailVerificationCallbackData.success && Intrinsics.areEqual(this.error, emailVerificationCallbackData.error);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.success) * 31;
        OneIDError oneIDError = this.error;
        return iHashCode + (oneIDError == null ? 0 : oneIDError.hashCode());
    }

    @NotNull
    public String toString() {
        return "EmailVerificationCallbackData(success=" + this.success + ", error=" + this.error + ")";
    }

    public /* synthetic */ EmailVerificationCallbackData(boolean z, OneIDError oneIDError, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : oneIDError);
    }

    @Override // com.disney.id.android.OneIDCallbackData
    public boolean getSuccess() {
        return this.success;
    }

    @Override // com.disney.id.android.OneIDCallbackData
    @Nullable
    public OneIDError getError() {
        return this.error;
    }

    public EmailVerificationCallbackData(boolean z, @Nullable OneIDError oneIDError) {
        super(z, oneIDError);
        this.success = z;
        this.error = oneIDError;
    }
}
