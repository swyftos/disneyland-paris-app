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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/disney/id/android/SetInlineNewslettersCallbackData;", "Lcom/disney/id/android/OneIDCallbackData;", "data", "(Lcom/disney/id/android/OneIDCallbackData;)V", "success", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/disney/id/android/OneIDError;", "(ZLcom/disney/id/android/OneIDError;)V", "getError", "()Lcom/disney/id/android/OneIDError;", "getSuccess", "()Z", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SetInlineNewslettersCallbackData extends OneIDCallbackData {

    @Nullable
    private final OneIDError error;
    private final boolean success;

    public static /* synthetic */ SetInlineNewslettersCallbackData copy$default(SetInlineNewslettersCallbackData setInlineNewslettersCallbackData, boolean z, OneIDError oneIDError, int i, Object obj) {
        if ((i & 1) != 0) {
            z = setInlineNewslettersCallbackData.success;
        }
        if ((i & 2) != 0) {
            oneIDError = setInlineNewslettersCallbackData.error;
        }
        return setInlineNewslettersCallbackData.copy(z, oneIDError);
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
    public final SetInlineNewslettersCallbackData copy(boolean success, @Nullable OneIDError error) {
        return new SetInlineNewslettersCallbackData(success, error);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SetInlineNewslettersCallbackData)) {
            return false;
        }
        SetInlineNewslettersCallbackData setInlineNewslettersCallbackData = (SetInlineNewslettersCallbackData) other;
        return this.success == setInlineNewslettersCallbackData.success && Intrinsics.areEqual(this.error, setInlineNewslettersCallbackData.error);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.success) * 31;
        OneIDError oneIDError = this.error;
        return iHashCode + (oneIDError == null ? 0 : oneIDError.hashCode());
    }

    @NotNull
    public String toString() {
        return "SetInlineNewslettersCallbackData(success=" + this.success + ", error=" + this.error + ")";
    }

    public /* synthetic */ SetInlineNewslettersCallbackData(boolean z, OneIDError oneIDError, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : oneIDError);
    }

    @Override // com.disney.id.android.OneIDCallbackData
    @Nullable
    public OneIDError getError() {
        return this.error;
    }

    @Override // com.disney.id.android.OneIDCallbackData
    public boolean getSuccess() {
        return this.success;
    }

    public SetInlineNewslettersCallbackData(boolean z, @Nullable OneIDError oneIDError) {
        super(z, oneIDError);
        this.success = z;
        this.error = oneIDError;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SetInlineNewslettersCallbackData(@NotNull OneIDCallbackData data) {
        this(data.getSuccess(), data.getError());
        Intrinsics.checkNotNullParameter(data, "data");
    }
}
