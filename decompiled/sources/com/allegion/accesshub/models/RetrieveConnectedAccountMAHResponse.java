package com.allegion.accesshub.models;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.io.Serializable;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0001\u0010\f\u001a\u00020\u0002\u0012\b\b\u0001\u0010\r\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J8\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u000b\u001a\u00020\u00052\b\b\u0003\u0010\f\u001a\u00020\u00022\b\b\u0003\u0010\r\u001a\u00020\u00052\b\b\u0003\u0010\u000e\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\r\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010\u0007¨\u0006%"}, d2 = {"Lcom/allegion/accesshub/models/RetrieveConnectedAccountMAHResponse;", "Ljava/io/Serializable;", "", "toString", "()Ljava/lang/String;", "Ljava/util/UUID;", "component1", "()Ljava/util/UUID;", "component2", "component3", "component4", "id", "integrationDisplayName", "integrationID", "assignmentIdentity", "copy", "(Ljava/util/UUID;Ljava/lang/String;Ljava/util/UUID;Ljava/lang/String;)Lcom/allegion/accesshub/models/RetrieveConnectedAccountMAHResponse;", "", "hashCode", "()I", "", ETCPaymentMethod.OTHER, "", ExactValueMatcher.EQUALS_VALUE_KEY, "(Ljava/lang/Object;)Z", "d", "Ljava/lang/String;", "getAssignmentIdentity", "b", "getIntegrationDisplayName", "c", "Ljava/util/UUID;", "getIntegrationID", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "getId", "<init>", "(Ljava/util/UUID;Ljava/lang/String;Ljava/util/UUID;Ljava/lang/String;)V", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final /* data */ class RetrieveConnectedAccountMAHResponse implements Serializable {

    /* renamed from: a, reason: from kotlin metadata */
    @SerializedName("id")
    @NotNull
    private final UUID id;

    /* renamed from: b, reason: from kotlin metadata */
    @SerializedName("integrationDisplayName")
    @NotNull
    private final String integrationDisplayName;

    /* renamed from: c, reason: from kotlin metadata */
    @SerializedName("integrationId")
    @NotNull
    private final UUID integrationID;

    /* renamed from: d, reason: from kotlin metadata */
    @SerializedName("assignmentIdentity")
    @NotNull
    private final String assignmentIdentity;

    public RetrieveConnectedAccountMAHResponse(@JsonProperty("id") @NotNull UUID id, @JsonProperty("integrationDisplayName") @NotNull String integrationDisplayName, @JsonProperty("integrationId") @NotNull UUID integrationID, @JsonProperty("assignmentIdentity") @NotNull String assignmentIdentity) {
        Intrinsics.checkParameterIsNotNull(id, "id");
        Intrinsics.checkParameterIsNotNull(integrationDisplayName, "integrationDisplayName");
        Intrinsics.checkParameterIsNotNull(integrationID, "integrationID");
        Intrinsics.checkParameterIsNotNull(assignmentIdentity, "assignmentIdentity");
        this.id = id;
        this.integrationDisplayName = integrationDisplayName;
        this.integrationID = integrationID;
        this.assignmentIdentity = assignmentIdentity;
    }

    public static /* synthetic */ RetrieveConnectedAccountMAHResponse copy$default(RetrieveConnectedAccountMAHResponse retrieveConnectedAccountMAHResponse, UUID uuid, String str, UUID uuid2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            uuid = retrieveConnectedAccountMAHResponse.id;
        }
        if ((i & 2) != 0) {
            str = retrieveConnectedAccountMAHResponse.integrationDisplayName;
        }
        if ((i & 4) != 0) {
            uuid2 = retrieveConnectedAccountMAHResponse.integrationID;
        }
        if ((i & 8) != 0) {
            str2 = retrieveConnectedAccountMAHResponse.assignmentIdentity;
        }
        return retrieveConnectedAccountMAHResponse.copy(uuid, str, uuid2, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final UUID getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getIntegrationDisplayName() {
        return this.integrationDisplayName;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final UUID getIntegrationID() {
        return this.integrationID;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getAssignmentIdentity() {
        return this.assignmentIdentity;
    }

    @NotNull
    public final RetrieveConnectedAccountMAHResponse copy(@JsonProperty("id") @NotNull UUID id, @JsonProperty("integrationDisplayName") @NotNull String integrationDisplayName, @JsonProperty("integrationId") @NotNull UUID integrationID, @JsonProperty("assignmentIdentity") @NotNull String assignmentIdentity) {
        Intrinsics.checkParameterIsNotNull(id, "id");
        Intrinsics.checkParameterIsNotNull(integrationDisplayName, "integrationDisplayName");
        Intrinsics.checkParameterIsNotNull(integrationID, "integrationID");
        Intrinsics.checkParameterIsNotNull(assignmentIdentity, "assignmentIdentity");
        return new RetrieveConnectedAccountMAHResponse(id, integrationDisplayName, integrationID, assignmentIdentity);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RetrieveConnectedAccountMAHResponse)) {
            return false;
        }
        RetrieveConnectedAccountMAHResponse retrieveConnectedAccountMAHResponse = (RetrieveConnectedAccountMAHResponse) other;
        return Intrinsics.areEqual(this.id, retrieveConnectedAccountMAHResponse.id) && Intrinsics.areEqual(this.integrationDisplayName, retrieveConnectedAccountMAHResponse.integrationDisplayName) && Intrinsics.areEqual(this.integrationID, retrieveConnectedAccountMAHResponse.integrationID) && Intrinsics.areEqual(this.assignmentIdentity, retrieveConnectedAccountMAHResponse.assignmentIdentity);
    }

    @NotNull
    public final String getAssignmentIdentity() {
        return this.assignmentIdentity;
    }

    @NotNull
    public final UUID getId() {
        return this.id;
    }

    @NotNull
    public final String getIntegrationDisplayName() {
        return this.integrationDisplayName;
    }

    @NotNull
    public final UUID getIntegrationID() {
        return this.integrationID;
    }

    public int hashCode() {
        UUID uuid = this.id;
        int iHashCode = (uuid != null ? uuid.hashCode() : 0) * 31;
        String str = this.integrationDisplayName;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        UUID uuid2 = this.integrationID;
        int iHashCode3 = (iHashCode2 + (uuid2 != null ? uuid2.hashCode() : 0)) * 31;
        String str2 = this.assignmentIdentity;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "RetrieveConnectedAccountMAHResponse: id: [" + this.id + "], integrationDisplayName: [" + this.integrationDisplayName + "], integrationID: [" + this.integrationID + "], assignmentIdentity: [" + this.assignmentIdentity + AbstractJsonLexerKt.END_LIST;
    }
}
