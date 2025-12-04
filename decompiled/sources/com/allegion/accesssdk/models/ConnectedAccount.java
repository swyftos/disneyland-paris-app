package com.allegion.accesssdk.models;

import com.allegion.accesssdk.utilities.UUIDUtility;
import com.disney.id.android.OneIDRecoveryContext;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\b\u0000\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/allegion/accesssdk/models/ConnectedAccount;", "Lcom/allegion/accesssdk/models/ConnectedAccountCore;", "Ljava/io/Serializable;", "", OneIDRecoveryContext.ACCESS_TOKEN, "", "updateAccessToken", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "isEmpty", "()Z", "Ljava/lang/String;", "getAccessToken", "setAccessToken", "connectedAccountCore", "Lcom/allegion/accesssdk/models/ConnectedAccountCore;", "getConnectedAccountCore", "()Lcom/allegion/accesssdk/models/ConnectedAccountCore;", "<init>", "(Lcom/allegion/accesssdk/models/ConnectedAccountCore;Ljava/lang/String;)V", "Companion", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class ConnectedAccount extends ConnectedAccountCore implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ConnectedAccount empty;

    @NotNull
    private String accessToken;

    @NotNull
    private final ConnectedAccountCore connectedAccountCore;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/allegion/accesssdk/models/ConnectedAccount$Companion;", "", "Lcom/allegion/accesssdk/models/ConnectedAccount;", "empty", "Lcom/allegion/accesssdk/models/ConnectedAccount;", "getEmpty", "()Lcom/allegion/accesssdk/models/ConnectedAccount;", "empty$annotations", "()V", "<init>", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void empty$annotations() {
        }

        @NotNull
        public final ConnectedAccount getEmpty() {
            return ConnectedAccount.empty;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        UUIDUtility.Companion companion = UUIDUtility.INSTANCE;
        empty = new ConnectedAccount(new ConnectedAccountCore(companion.empty(), "", "", companion.empty()), "");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectedAccount(@NotNull ConnectedAccountCore connectedAccountCore, @NotNull String accessToken) {
        super(connectedAccountCore.getID(), connectedAccountCore.getDisplayName(), connectedAccountCore.getAssignmentIdentity(), connectedAccountCore.getIntegrationId());
        Intrinsics.checkParameterIsNotNull(connectedAccountCore, "connectedAccountCore");
        Intrinsics.checkParameterIsNotNull(accessToken, "accessToken");
        this.connectedAccountCore = connectedAccountCore;
        this.accessToken = accessToken;
    }

    @NotNull
    public static final ConnectedAccount getEmpty() {
        return empty;
    }

    @NotNull
    public final String getAccessToken() {
        return this.accessToken;
    }

    @NotNull
    public final ConnectedAccountCore getConnectedAccountCore() {
        return this.connectedAccountCore;
    }

    @Override // com.allegion.accesssdk.models.ConnectedAccountCore
    public boolean isEmpty() {
        return super.isEmpty() || this.accessToken.length() == 0;
    }

    public final void setAccessToken(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.accessToken = str;
    }

    @Override // com.allegion.accesssdk.models.ConnectedAccountCore
    @NotNull
    public String toString() {
        return "ConnectedAccount: connectedAccountCore[" + this.connectedAccountCore + "], accessToken: [" + this.accessToken + AbstractJsonLexerKt.END_LIST;
    }

    public final void updateAccessToken(@NotNull String accessToken) {
        Intrinsics.checkParameterIsNotNull(accessToken, "accessToken");
        this.accessToken = accessToken;
    }
}
