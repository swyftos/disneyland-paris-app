package com.allegion.accesshub.models;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0001\u0010\u0018\u001a\u00020\r\u0012\u000e\b\u0001\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u0010\u0012\b\b\u0001\u0010\u001a\u001a\u00020\r\u0012(\b\u0001\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u0015¢\u0006\u0004\b)\u0010*J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000fJ0\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J^\u0010\u001c\u001a\u00020\u00002\b\b\u0003\u0010\u0018\u001a\u00020\r2\u000e\b\u0003\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\b\b\u0003\u0010\u001a\u001a\u00020\r2(\b\u0003\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u0015HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001a\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u000fR<\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0017R\u001c\u0010\u0018\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010\u000fR\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0012¨\u0006+"}, d2 = {"Lcom/allegion/accesshub/models/GetRightsMAHResponse;", "Ljava/io/Serializable;", "", ETCPaymentMethod.OTHER, "", ExactValueMatcher.EQUALS_VALUE_KEY, "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/UUID;", "component1", "()Ljava/util/UUID;", "", "component2", "()[Ljava/lang/String;", "component3", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "component4", "()Ljava/util/HashMap;", "id", "payloadTypes", "connectedAccountId", "attributes", "copy", "(Ljava/util/UUID;[Ljava/lang/String;Ljava/util/UUID;Ljava/util/HashMap;)Lcom/allegion/accesshub/models/GetRightsMAHResponse;", "c", "Ljava/util/UUID;", "getConnectedAccountId", "d", "Ljava/util/HashMap;", "getAttributes", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "getId", "b", "[Ljava/lang/String;", "getPayloadTypes", "<init>", "(Ljava/util/UUID;[Ljava/lang/String;Ljava/util/UUID;Ljava/util/HashMap;)V", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final /* data */ class GetRightsMAHResponse implements Serializable {

    /* renamed from: a, reason: from kotlin metadata */
    @SerializedName("id")
    @NotNull
    private final UUID id;

    /* renamed from: b, reason: from kotlin metadata */
    @SerializedName("payloadTypes")
    @NotNull
    private final String[] payloadTypes;

    /* renamed from: c, reason: from kotlin metadata */
    @SerializedName("connectedAccountId")
    @NotNull
    private final UUID connectedAccountId;

    /* renamed from: d, reason: from kotlin metadata */
    @SerializedName("attributes")
    @Nullable
    private final HashMap<String, String> attributes;

    public GetRightsMAHResponse(@JsonProperty("id") @NotNull UUID id, @JsonProperty("payloadTypes") @NotNull String[] payloadTypes, @JsonProperty("connectedAccountId") @NotNull UUID connectedAccountId, @JsonProperty("attributes") @Nullable HashMap<String, String> map) {
        Intrinsics.checkParameterIsNotNull(id, "id");
        Intrinsics.checkParameterIsNotNull(payloadTypes, "payloadTypes");
        Intrinsics.checkParameterIsNotNull(connectedAccountId, "connectedAccountId");
        this.id = id;
        this.payloadTypes = payloadTypes;
        this.connectedAccountId = connectedAccountId;
        this.attributes = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetRightsMAHResponse copy$default(GetRightsMAHResponse getRightsMAHResponse, UUID uuid, String[] strArr, UUID uuid2, HashMap map, int i, Object obj) {
        if ((i & 1) != 0) {
            uuid = getRightsMAHResponse.id;
        }
        if ((i & 2) != 0) {
            strArr = getRightsMAHResponse.payloadTypes;
        }
        if ((i & 4) != 0) {
            uuid2 = getRightsMAHResponse.connectedAccountId;
        }
        if ((i & 8) != 0) {
            map = getRightsMAHResponse.attributes;
        }
        return getRightsMAHResponse.copy(uuid, strArr, uuid2, map);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final UUID getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String[] getPayloadTypes() {
        return this.payloadTypes;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final UUID getConnectedAccountId() {
        return this.connectedAccountId;
    }

    @Nullable
    public final HashMap<String, String> component4() {
        return this.attributes;
    }

    @NotNull
    public final GetRightsMAHResponse copy(@JsonProperty("id") @NotNull UUID id, @JsonProperty("payloadTypes") @NotNull String[] payloadTypes, @JsonProperty("connectedAccountId") @NotNull UUID connectedAccountId, @JsonProperty("attributes") @Nullable HashMap<String, String> attributes) {
        Intrinsics.checkParameterIsNotNull(id, "id");
        Intrinsics.checkParameterIsNotNull(payloadTypes, "payloadTypes");
        Intrinsics.checkParameterIsNotNull(connectedAccountId, "connectedAccountId");
        return new GetRightsMAHResponse(id, payloadTypes, connectedAccountId, attributes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(GetRightsMAHResponse.class, other != null ? other.getClass() : null)) {
            return false;
        }
        if (other == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.allegion.accesshub.models.GetRightsMAHResponse");
        }
        GetRightsMAHResponse getRightsMAHResponse = (GetRightsMAHResponse) other;
        return Intrinsics.areEqual(this.id, getRightsMAHResponse.id) && Arrays.equals(this.payloadTypes, getRightsMAHResponse.payloadTypes) && Intrinsics.areEqual(this.connectedAccountId, getRightsMAHResponse.connectedAccountId) && Intrinsics.areEqual(this.attributes, getRightsMAHResponse.attributes);
    }

    @Nullable
    public final HashMap<String, String> getAttributes() {
        return this.attributes;
    }

    @NotNull
    public final UUID getConnectedAccountId() {
        return this.connectedAccountId;
    }

    @NotNull
    public final UUID getId() {
        return this.id;
    }

    @NotNull
    public final String[] getPayloadTypes() {
        return this.payloadTypes;
    }

    public int hashCode() {
        int iHashCode = ((((this.id.hashCode() * 31) + Arrays.hashCode(this.payloadTypes)) * 31) + this.connectedAccountId.hashCode()) * 31;
        HashMap<String, String> map = this.attributes;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "GetRightsResponse: id: [" + this.id + "], payloadTypes: [" + this.payloadTypes + "], connectedAccountId: [" + this.connectedAccountId + "], attributes: [" + this.attributes + AbstractJsonLexerKt.END_LIST;
    }
}
