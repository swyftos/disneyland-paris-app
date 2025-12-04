package com.allegion.accesssdk.models.responses;

import com.allegion.accesssdk.models.Account;
import com.allegion.accesssdk.models.ConnectedAccountCore;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ$\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/allegion/accesssdk/models/responses/EnrollmentResponse;", "", "", "toString", "()Ljava/lang/String;", "Lcom/allegion/accesssdk/models/Account;", "component1", "()Lcom/allegion/accesssdk/models/Account;", "Lcom/allegion/accesssdk/models/ConnectedAccountCore;", "component2", "()Lcom/allegion/accesssdk/models/ConnectedAccountCore;", "account", "connectedAccountCore", "copy", "(Lcom/allegion/accesssdk/models/Account;Lcom/allegion/accesssdk/models/ConnectedAccountCore;)Lcom/allegion/accesssdk/models/responses/EnrollmentResponse;", "", "hashCode", "()I", ETCPaymentMethod.OTHER, "", ExactValueMatcher.EQUALS_VALUE_KEY, "(Ljava/lang/Object;)Z", "Lcom/allegion/accesssdk/models/Account;", "getAccount", "Lcom/allegion/accesssdk/models/ConnectedAccountCore;", "getConnectedAccountCore", "<init>", "(Lcom/allegion/accesssdk/models/Account;Lcom/allegion/accesssdk/models/ConnectedAccountCore;)V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final /* data */ class EnrollmentResponse {

    @NotNull
    private final Account account;

    @NotNull
    private final ConnectedAccountCore connectedAccountCore;

    public EnrollmentResponse(@NotNull Account account, @NotNull ConnectedAccountCore connectedAccountCore) {
        Intrinsics.checkParameterIsNotNull(account, "account");
        Intrinsics.checkParameterIsNotNull(connectedAccountCore, "connectedAccountCore");
        this.account = account;
        this.connectedAccountCore = connectedAccountCore;
    }

    public static /* synthetic */ EnrollmentResponse copy$default(EnrollmentResponse enrollmentResponse, Account account, ConnectedAccountCore connectedAccountCore, int i, Object obj) {
        if ((i & 1) != 0) {
            account = enrollmentResponse.account;
        }
        if ((i & 2) != 0) {
            connectedAccountCore = enrollmentResponse.connectedAccountCore;
        }
        return enrollmentResponse.copy(account, connectedAccountCore);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Account getAccount() {
        return this.account;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final ConnectedAccountCore getConnectedAccountCore() {
        return this.connectedAccountCore;
    }

    @NotNull
    public final EnrollmentResponse copy(@NotNull Account account, @NotNull ConnectedAccountCore connectedAccountCore) {
        Intrinsics.checkParameterIsNotNull(account, "account");
        Intrinsics.checkParameterIsNotNull(connectedAccountCore, "connectedAccountCore");
        return new EnrollmentResponse(account, connectedAccountCore);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnrollmentResponse)) {
            return false;
        }
        EnrollmentResponse enrollmentResponse = (EnrollmentResponse) other;
        return Intrinsics.areEqual(this.account, enrollmentResponse.account) && Intrinsics.areEqual(this.connectedAccountCore, enrollmentResponse.connectedAccountCore);
    }

    @NotNull
    public final Account getAccount() {
        return this.account;
    }

    @NotNull
    public final ConnectedAccountCore getConnectedAccountCore() {
        return this.connectedAccountCore;
    }

    public int hashCode() {
        Account account = this.account;
        int iHashCode = (account != null ? account.hashCode() : 0) * 31;
        ConnectedAccountCore connectedAccountCore = this.connectedAccountCore;
        return iHashCode + (connectedAccountCore != null ? connectedAccountCore.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "EnrollmentResponse: account:[" + this.account + "] connectedAccountCore:[" + this.connectedAccountCore + AbstractJsonLexerKt.END_LIST;
    }
}
