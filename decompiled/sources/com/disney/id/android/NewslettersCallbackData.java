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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/disney/id/android/NewslettersCallbackData;", "Lcom/disney/id/android/OneIDCallbackData;", "success", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/disney/id/android/OneIDError;", "result", "Lcom/disney/id/android/NewslettersResult;", "(ZLcom/disney/id/android/OneIDError;Lcom/disney/id/android/NewslettersResult;)V", "getError", "()Lcom/disney/id/android/OneIDError;", "getResult", "()Lcom/disney/id/android/NewslettersResult;", "getSuccess", "()Z", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class NewslettersCallbackData extends OneIDCallbackData {

    @Nullable
    private final OneIDError error;

    @Nullable
    private final NewslettersResult result;
    private final boolean success;

    public static /* synthetic */ NewslettersCallbackData copy$default(NewslettersCallbackData newslettersCallbackData, boolean z, OneIDError oneIDError, NewslettersResult newslettersResult, int i, Object obj) {
        if ((i & 1) != 0) {
            z = newslettersCallbackData.success;
        }
        if ((i & 2) != 0) {
            oneIDError = newslettersCallbackData.error;
        }
        if ((i & 4) != 0) {
            newslettersResult = newslettersCallbackData.result;
        }
        return newslettersCallbackData.copy(z, oneIDError, newslettersResult);
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

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final NewslettersResult getResult() {
        return this.result;
    }

    @NotNull
    public final NewslettersCallbackData copy(boolean success, @Nullable OneIDError error, @Nullable NewslettersResult result) {
        return new NewslettersCallbackData(success, error, result);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewslettersCallbackData)) {
            return false;
        }
        NewslettersCallbackData newslettersCallbackData = (NewslettersCallbackData) other;
        return this.success == newslettersCallbackData.success && Intrinsics.areEqual(this.error, newslettersCallbackData.error) && Intrinsics.areEqual(this.result, newslettersCallbackData.result);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.success) * 31;
        OneIDError oneIDError = this.error;
        int iHashCode2 = (iHashCode + (oneIDError == null ? 0 : oneIDError.hashCode())) * 31;
        NewslettersResult newslettersResult = this.result;
        return iHashCode2 + (newslettersResult != null ? newslettersResult.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "NewslettersCallbackData(success=" + this.success + ", error=" + this.error + ", result=" + this.result + ")";
    }

    public /* synthetic */ NewslettersCallbackData(boolean z, OneIDError oneIDError, NewslettersResult newslettersResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : oneIDError, (i & 4) != 0 ? null : newslettersResult);
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

    @Nullable
    public final NewslettersResult getResult() {
        return this.result;
    }

    public NewslettersCallbackData(boolean z, @Nullable OneIDError oneIDError, @Nullable NewslettersResult newslettersResult) {
        super(z, oneIDError);
        this.success = z;
        this.error = oneIDError;
        this.result = newslettersResult;
    }
}
