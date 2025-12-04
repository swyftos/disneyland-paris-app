package com.allegion.accesssdk.models;

import com.allegion.accesshub.models.CreateConnectedAccountMAHResponse;
import com.allegion.accesssdk.utilities.UUIDUtility;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0014\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0019\u0010\t\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u00118V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/allegion/accesssdk/models/ConnectedAccountCore;", "", "", "toString", "()Ljava/lang/String;", "displayName", "Ljava/lang/String;", "getDisplayName", "Ljava/util/UUID;", "integrationId", "Ljava/util/UUID;", "getIntegrationId", "()Ljava/util/UUID;", "ID", "getID", "assignmentIdentity", "getAssignmentIdentity", "", "isEmpty", "()Z", "<init>", "(Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/util/UUID;)V", "Lcom/allegion/accesshub/models/CreateConnectedAccountMAHResponse;", "connectedAccountMAHResponse", "(Lcom/allegion/accesshub/models/CreateConnectedAccountMAHResponse;)V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public class ConnectedAccountCore {

    @NotNull
    private final UUID ID;

    @NotNull
    private final String assignmentIdentity;

    @NotNull
    private final String displayName;

    @NotNull
    private final UUID integrationId;

    public ConnectedAccountCore(@NotNull UUID ID, @NotNull String displayName, @NotNull String assignmentIdentity, @NotNull UUID integrationId) {
        Intrinsics.checkParameterIsNotNull(ID, "ID");
        Intrinsics.checkParameterIsNotNull(displayName, "displayName");
        Intrinsics.checkParameterIsNotNull(assignmentIdentity, "assignmentIdentity");
        Intrinsics.checkParameterIsNotNull(integrationId, "integrationId");
        this.ID = ID;
        this.displayName = displayName;
        this.assignmentIdentity = assignmentIdentity;
        this.integrationId = integrationId;
    }

    @NotNull
    public final String getAssignmentIdentity() {
        return this.assignmentIdentity;
    }

    @NotNull
    public final String getDisplayName() {
        return this.displayName;
    }

    @NotNull
    public final UUID getID() {
        return this.ID;
    }

    @NotNull
    public final UUID getIntegrationId() {
        return this.integrationId;
    }

    public boolean isEmpty() {
        UUID uuid = this.ID;
        UUIDUtility.Companion companion = UUIDUtility.INSTANCE;
        return Intrinsics.areEqual(uuid, companion.empty()) || this.displayName.length() == 0 || this.assignmentIdentity.length() == 0 || Intrinsics.areEqual(this.integrationId, companion.empty());
    }

    @NotNull
    public String toString() {
        return "ConnectedAccountCore: identifier: [" + this.ID + "], displayName: [" + this.displayName + "], assignmentIdentity: [" + this.assignmentIdentity + "], integrationId: [" + this.integrationId + AbstractJsonLexerKt.END_LIST;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectedAccountCore(@NotNull CreateConnectedAccountMAHResponse connectedAccountMAHResponse) {
        this(connectedAccountMAHResponse.getId(), connectedAccountMAHResponse.getIntegrationDisplayName(), connectedAccountMAHResponse.getAssignmentIdentity(), connectedAccountMAHResponse.getIntegrationID());
        Intrinsics.checkParameterIsNotNull(connectedAccountMAHResponse, "connectedAccountMAHResponse");
    }
}
