package com.allegion.accesssdk.models;

import com.allegion.accesssdk.models.responses.EnrollmentResponse;
import com.disney.id.android.OneIDRecoveryContext;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u001cB\u0019\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ$\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\nR\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007¨\u0006!"}, d2 = {"Lcom/allegion/accesssdk/models/EnrollmentResult;", "Ljava/io/Serializable;", "", "toString", "()Ljava/lang/String;", "Lcom/allegion/accesssdk/models/Account;", "component1", "()Lcom/allegion/accesssdk/models/Account;", "Lcom/allegion/accesssdk/models/ConnectedAccount;", "component2", "()Lcom/allegion/accesssdk/models/ConnectedAccount;", "account", "connectedAccount", "copy", "(Lcom/allegion/accesssdk/models/Account;Lcom/allegion/accesssdk/models/ConnectedAccount;)Lcom/allegion/accesssdk/models/EnrollmentResult;", "", "hashCode", "()I", "", ETCPaymentMethod.OTHER, "", ExactValueMatcher.EQUALS_VALUE_KEY, "(Ljava/lang/Object;)Z", "Lcom/allegion/accesssdk/models/ConnectedAccount;", "getConnectedAccount", "Lcom/allegion/accesssdk/models/Account;", "getAccount", "<init>", "(Lcom/allegion/accesssdk/models/Account;Lcom/allegion/accesssdk/models/ConnectedAccount;)V", "Lcom/allegion/accesssdk/models/responses/EnrollmentResponse;", "enrollmentResponse", OneIDRecoveryContext.ACCESS_TOKEN, "(Lcom/allegion/accesssdk/models/responses/EnrollmentResponse;Ljava/lang/String;)V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final /* data */ class EnrollmentResult implements Serializable {

    @NotNull
    private final Account account;

    @NotNull
    private final ConnectedAccount connectedAccount;

    public EnrollmentResult(@NotNull Account account, @NotNull ConnectedAccount connectedAccount) {
        Intrinsics.checkParameterIsNotNull(account, "account");
        Intrinsics.checkParameterIsNotNull(connectedAccount, "connectedAccount");
        this.account = account;
        this.connectedAccount = connectedAccount;
    }

    public static /* synthetic */ EnrollmentResult copy$default(EnrollmentResult enrollmentResult, Account account, ConnectedAccount connectedAccount, int i, Object obj) {
        if ((i & 1) != 0) {
            account = enrollmentResult.account;
        }
        if ((i & 2) != 0) {
            connectedAccount = enrollmentResult.connectedAccount;
        }
        return enrollmentResult.copy(account, connectedAccount);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Account getAccount() {
        return this.account;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final ConnectedAccount getConnectedAccount() {
        return this.connectedAccount;
    }

    @NotNull
    public final EnrollmentResult copy(@NotNull Account account, @NotNull ConnectedAccount connectedAccount) {
        Intrinsics.checkParameterIsNotNull(account, "account");
        Intrinsics.checkParameterIsNotNull(connectedAccount, "connectedAccount");
        return new EnrollmentResult(account, connectedAccount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnrollmentResult)) {
            return false;
        }
        EnrollmentResult enrollmentResult = (EnrollmentResult) other;
        return Intrinsics.areEqual(this.account, enrollmentResult.account) && Intrinsics.areEqual(this.connectedAccount, enrollmentResult.connectedAccount);
    }

    @NotNull
    public final Account getAccount() {
        return this.account;
    }

    @NotNull
    public final ConnectedAccount getConnectedAccount() {
        return this.connectedAccount;
    }

    public int hashCode() {
        Account account = this.account;
        int iHashCode = (account != null ? account.hashCode() : 0) * 31;
        ConnectedAccount connectedAccount = this.connectedAccount;
        return iHashCode + (connectedAccount != null ? connectedAccount.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "EnrollmentResult: account: [" + this.account + "] connectedAccount: [" + this.connectedAccount + AbstractJsonLexerKt.END_LIST;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnrollmentResult(@NotNull EnrollmentResponse enrollmentResponse, @NotNull String accessToken) {
        this(new Account(enrollmentResponse.getAccount().getDeviceID(), enrollmentResponse.getAccount().getAccountID()), new ConnectedAccount(enrollmentResponse.getConnectedAccountCore(), accessToken));
        Intrinsics.checkParameterIsNotNull(enrollmentResponse, "enrollmentResponse");
        Intrinsics.checkParameterIsNotNull(accessToken, "accessToken");
    }
}
