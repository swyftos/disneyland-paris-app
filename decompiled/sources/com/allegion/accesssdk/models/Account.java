package com.allegion.accesssdk.models;

import com.allegion.accesssdk.utilities.UUIDUtility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.io.Serializable;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001b\u0012\b\b\u0001\u0010\t\u001a\u00020\u0005\u0012\b\b\u0001\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J$\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\t\u001a\u00020\u00052\b\b\u0003\u0010\n\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u00020\u00128G@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/allegion/accesssdk/models/Account;", "Ljava/io/Serializable;", "", "toString", "()Ljava/lang/String;", "Ljava/util/UUID;", "component1", "()Ljava/util/UUID;", "component2", "deviceID", "accountID", "copy", "(Ljava/util/UUID;Ljava/util/UUID;)Lcom/allegion/accesssdk/models/Account;", "", "hashCode", "()I", "", ETCPaymentMethod.OTHER, "", ExactValueMatcher.EQUALS_VALUE_KEY, "(Ljava/lang/Object;)Z", "isEmpty", "()Z", "Ljava/util/UUID;", "getDeviceID", "getAccountID", "<init>", "(Ljava/util/UUID;Ljava/util/UUID;)V", "Companion", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final /* data */ class Account implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Account empty;

    @NotNull
    private final UUID accountID;

    @NotNull
    private final UUID deviceID;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/allegion/accesssdk/models/Account$Companion;", "", "Lcom/allegion/accesssdk/models/Account;", "empty", "Lcom/allegion/accesssdk/models/Account;", "getEmpty", "()Lcom/allegion/accesssdk/models/Account;", "empty$annotations", "()V", "<init>", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void empty$annotations() {
        }

        @NotNull
        public final Account getEmpty() {
            return Account.empty;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        UUIDUtility.Companion companion = UUIDUtility.INSTANCE;
        empty = new Account(companion.empty(), companion.empty());
    }

    public Account(@JsonProperty("deviceID") @NotNull UUID deviceID, @JsonProperty("accountID") @NotNull UUID accountID) {
        Intrinsics.checkParameterIsNotNull(deviceID, "deviceID");
        Intrinsics.checkParameterIsNotNull(accountID, "accountID");
        this.deviceID = deviceID;
        this.accountID = accountID;
    }

    public static /* synthetic */ Account copy$default(Account account, UUID uuid, UUID uuid2, int i, Object obj) {
        if ((i & 1) != 0) {
            uuid = account.deviceID;
        }
        if ((i & 2) != 0) {
            uuid2 = account.accountID;
        }
        return account.copy(uuid, uuid2);
    }

    @NotNull
    public static final Account getEmpty() {
        return empty;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final UUID getDeviceID() {
        return this.deviceID;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final UUID getAccountID() {
        return this.accountID;
    }

    @NotNull
    public final Account copy(@JsonProperty("deviceID") @NotNull UUID deviceID, @JsonProperty("accountID") @NotNull UUID accountID) {
        Intrinsics.checkParameterIsNotNull(deviceID, "deviceID");
        Intrinsics.checkParameterIsNotNull(accountID, "accountID");
        return new Account(deviceID, accountID);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Account)) {
            return false;
        }
        Account account = (Account) other;
        return Intrinsics.areEqual(this.deviceID, account.deviceID) && Intrinsics.areEqual(this.accountID, account.accountID);
    }

    @NotNull
    public final UUID getAccountID() {
        return this.accountID;
    }

    @NotNull
    public final UUID getDeviceID() {
        return this.deviceID;
    }

    public int hashCode() {
        UUID uuid = this.deviceID;
        int iHashCode = (uuid != null ? uuid.hashCode() : 0) * 31;
        UUID uuid2 = this.accountID;
        return iHashCode + (uuid2 != null ? uuid2.hashCode() : 0);
    }

    @JsonIgnore
    public final boolean isEmpty() {
        UUID uuid = this.deviceID;
        UUIDUtility.Companion companion = UUIDUtility.INSTANCE;
        return Intrinsics.areEqual(uuid, companion.empty()) || Intrinsics.areEqual(this.accountID, companion.empty());
    }

    @NotNull
    public String toString() {
        return "Account: deviceID: " + this.deviceID + ", accountID: " + this.accountID;
    }
}
