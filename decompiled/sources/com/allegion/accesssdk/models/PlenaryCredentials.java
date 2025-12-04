package com.allegion.accesssdk.models;

import com.disney.id.android.OneIDRecoveryContext;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.io.Serializable;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\b\u0018\u0000 ,2\u00020\u0001:\u0001,B'\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b%\u0010&B\u0019\b\u0016\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b%\u0010+J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J8\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\u001fR\u0019\u0010\u000f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\nR\u0019\u0010\u000e\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b\"\u0010\nR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b#\u0010\nR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b$\u0010\u0007¨\u0006-"}, d2 = {"Lcom/allegion/accesssdk/models/PlenaryCredentials;", "Ljava/io/Serializable;", "", "isEmpty", "()Z", "", "toString", "()Ljava/lang/String;", "Ljava/util/UUID;", "component1", "()Ljava/util/UUID;", "component2", "component3", "component4", "deviceID", "accountID", "connectedAccountID", OneIDRecoveryContext.ACCESS_TOKEN, "copy", "(Ljava/util/UUID;Ljava/util/UUID;Ljava/util/UUID;Ljava/lang/String;)Lcom/allegion/accesssdk/models/PlenaryCredentials;", "", "hashCode", "()I", "", ETCPaymentMethod.OTHER, ExactValueMatcher.EQUALS_VALUE_KEY, "(Ljava/lang/Object;)Z", "maskedAccessToken", "Ljava/lang/String;", "getMaskedAccessToken", "setMaskedAccessToken", "(Ljava/lang/String;)V", "Ljava/util/UUID;", "getAccountID", "getDeviceID", "getConnectedAccountID", "getAccessToken", "<init>", "(Ljava/util/UUID;Ljava/util/UUID;Ljava/util/UUID;Ljava/lang/String;)V", "Lcom/allegion/accesssdk/models/Account;", "account", "Lcom/allegion/accesssdk/models/ConnectedAccount;", "connectedAccount", "(Lcom/allegion/accesssdk/models/Account;Lcom/allegion/accesssdk/models/ConnectedAccount;)V", "Companion", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final /* data */ class PlenaryCredentials implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String accessToken;

    @NotNull
    private final UUID accountID;

    @NotNull
    private final UUID connectedAccountID;

    @NotNull
    private final UUID deviceID;

    @NotNull
    private String maskedAccessToken;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/allegion/accesssdk/models/PlenaryCredentials$Companion;", "", "Lcom/allegion/accesssdk/models/PlenaryCredentials;", "empty", "()Lcom/allegion/accesssdk/models/PlenaryCredentials;", "", "emptyUUIDString", "Ljava/lang/String;", "<init>", "()V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final PlenaryCredentials empty() {
            UUID uuidFromString = UUID.fromString("00000000-0000-0000-0000-000000000000");
            Intrinsics.checkExpressionValueIsNotNull(uuidFromString, "UUID.fromString(emptyUUIDString)");
            UUID uuidFromString2 = UUID.fromString("00000000-0000-0000-0000-000000000000");
            Intrinsics.checkExpressionValueIsNotNull(uuidFromString2, "UUID.fromString(emptyUUIDString)");
            UUID uuidFromString3 = UUID.fromString("00000000-0000-0000-0000-000000000000");
            Intrinsics.checkExpressionValueIsNotNull(uuidFromString3, "UUID.fromString(emptyUUIDString)");
            return new PlenaryCredentials(uuidFromString, uuidFromString2, uuidFromString3, "");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PlenaryCredentials(@NotNull UUID deviceID, @NotNull UUID accountID, @NotNull UUID connectedAccountID, @NotNull String accessToken) {
        Intrinsics.checkParameterIsNotNull(deviceID, "deviceID");
        Intrinsics.checkParameterIsNotNull(accountID, "accountID");
        Intrinsics.checkParameterIsNotNull(connectedAccountID, "connectedAccountID");
        Intrinsics.checkParameterIsNotNull(accessToken, "accessToken");
        this.deviceID = deviceID;
        this.accountID = accountID;
        this.connectedAccountID = connectedAccountID;
        this.accessToken = accessToken;
        this.maskedAccessToken = "repeating: X, count: " + accessToken.length();
    }

    public static /* synthetic */ PlenaryCredentials copy$default(PlenaryCredentials plenaryCredentials, UUID uuid, UUID uuid2, UUID uuid3, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            uuid = plenaryCredentials.deviceID;
        }
        if ((i & 2) != 0) {
            uuid2 = plenaryCredentials.accountID;
        }
        if ((i & 4) != 0) {
            uuid3 = plenaryCredentials.connectedAccountID;
        }
        if ((i & 8) != 0) {
            str = plenaryCredentials.accessToken;
        }
        return plenaryCredentials.copy(uuid, uuid2, uuid3, str);
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
    /* renamed from: component3, reason: from getter */
    public final UUID getConnectedAccountID() {
        return this.connectedAccountID;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    @NotNull
    public final PlenaryCredentials copy(@NotNull UUID deviceID, @NotNull UUID accountID, @NotNull UUID connectedAccountID, @NotNull String accessToken) {
        Intrinsics.checkParameterIsNotNull(deviceID, "deviceID");
        Intrinsics.checkParameterIsNotNull(accountID, "accountID");
        Intrinsics.checkParameterIsNotNull(connectedAccountID, "connectedAccountID");
        Intrinsics.checkParameterIsNotNull(accessToken, "accessToken");
        return new PlenaryCredentials(deviceID, accountID, connectedAccountID, accessToken);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlenaryCredentials)) {
            return false;
        }
        PlenaryCredentials plenaryCredentials = (PlenaryCredentials) other;
        return Intrinsics.areEqual(this.deviceID, plenaryCredentials.deviceID) && Intrinsics.areEqual(this.accountID, plenaryCredentials.accountID) && Intrinsics.areEqual(this.connectedAccountID, plenaryCredentials.connectedAccountID) && Intrinsics.areEqual(this.accessToken, plenaryCredentials.accessToken);
    }

    @NotNull
    public final String getAccessToken() {
        return this.accessToken;
    }

    @NotNull
    public final UUID getAccountID() {
        return this.accountID;
    }

    @NotNull
    public final UUID getConnectedAccountID() {
        return this.connectedAccountID;
    }

    @NotNull
    public final UUID getDeviceID() {
        return this.deviceID;
    }

    @NotNull
    public final String getMaskedAccessToken() {
        return this.maskedAccessToken;
    }

    public int hashCode() {
        UUID uuid = this.deviceID;
        int iHashCode = (uuid != null ? uuid.hashCode() : 0) * 31;
        UUID uuid2 = this.accountID;
        int iHashCode2 = (iHashCode + (uuid2 != null ? uuid2.hashCode() : 0)) * 31;
        UUID uuid3 = this.connectedAccountID;
        int iHashCode3 = (iHashCode2 + (uuid3 != null ? uuid3.hashCode() : 0)) * 31;
        String str = this.accessToken;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public final boolean isEmpty() {
        return Intrinsics.areEqual(this.deviceID, UUID.fromString("00000000-0000-0000-0000-000000000000")) && Intrinsics.areEqual(this.accountID, UUID.fromString("00000000-0000-0000-0000-000000000000")) && Intrinsics.areEqual(this.connectedAccountID, UUID.fromString("00000000-0000-0000-0000-000000000000")) && this.accessToken.length() == 0;
    }

    public final void setMaskedAccessToken(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.maskedAccessToken = str;
    }

    @NotNull
    public String toString() {
        return "PlenaryCredentials: deviceId:[" + this.deviceID + "] accountId:[" + this.accountID + "] connectedAccountId:[" + this.connectedAccountID + "] accessToken:[" + this.maskedAccessToken + AbstractJsonLexerKt.END_LIST;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlenaryCredentials(@NotNull Account account, @NotNull ConnectedAccount connectedAccount) {
        this(account.getDeviceID(), account.getAccountID(), connectedAccount.getID(), connectedAccount.getAccessToken());
        Intrinsics.checkParameterIsNotNull(account, "account");
        Intrinsics.checkParameterIsNotNull(connectedAccount, "connectedAccount");
    }
}
