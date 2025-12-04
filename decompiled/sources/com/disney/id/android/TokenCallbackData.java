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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/disney/id/android/TokenCallbackData;", "Lcom/disney/id/android/OneIDCallbackData;", "token", "Lcom/disney/id/android/Token;", "success", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/disney/id/android/OneIDError;", "(Lcom/disney/id/android/Token;ZLcom/disney/id/android/OneIDError;)V", "getError", "()Lcom/disney/id/android/OneIDError;", "getSuccess", "()Z", "getToken", "()Lcom/disney/id/android/Token;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TokenCallbackData extends OneIDCallbackData {

    @Nullable
    private final OneIDError error;
    private final boolean success;

    @Nullable
    private final Token token;

    public static /* synthetic */ TokenCallbackData copy$default(TokenCallbackData tokenCallbackData, Token token, boolean z, OneIDError oneIDError, int i, Object obj) {
        if ((i & 1) != 0) {
            token = tokenCallbackData.token;
        }
        if ((i & 2) != 0) {
            z = tokenCallbackData.success;
        }
        if ((i & 4) != 0) {
            oneIDError = tokenCallbackData.error;
        }
        return tokenCallbackData.copy(token, z, oneIDError);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Token getToken() {
        return this.token;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final OneIDError getError() {
        return this.error;
    }

    @NotNull
    public final TokenCallbackData copy(@Nullable Token token, boolean success, @Nullable OneIDError error) {
        return new TokenCallbackData(token, success, error);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TokenCallbackData)) {
            return false;
        }
        TokenCallbackData tokenCallbackData = (TokenCallbackData) other;
        return Intrinsics.areEqual(this.token, tokenCallbackData.token) && this.success == tokenCallbackData.success && Intrinsics.areEqual(this.error, tokenCallbackData.error);
    }

    public int hashCode() {
        Token token = this.token;
        int iHashCode = (((token == null ? 0 : token.hashCode()) * 31) + Boolean.hashCode(this.success)) * 31;
        OneIDError oneIDError = this.error;
        return iHashCode + (oneIDError != null ? oneIDError.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "TokenCallbackData(token=" + this.token + ", success=" + this.success + ", error=" + this.error + ")";
    }

    public /* synthetic */ TokenCallbackData(Token token, boolean z, OneIDError oneIDError, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(token, z, (i & 4) != 0 ? null : oneIDError);
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

    @Nullable
    public final Token getToken() {
        return this.token;
    }

    public TokenCallbackData(@Nullable Token token, boolean z, @Nullable OneIDError oneIDError) {
        super(z, oneIDError);
        this.token = token;
        this.success = z;
        this.error = oneIDError;
    }
}
