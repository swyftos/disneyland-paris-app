package com.allegion.accesshub.models;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u000e\u001a\u00020\t\u0012\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\t8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/allegion/accesshub/models/AccessPayloadsMAHResponse;", "Ljava/io/Serializable;", "", "Lcom/allegion/accesshub/models/AccessPayloadsMAHResponseData;", "b", "[Lcom/allegion/accesshub/models/AccessPayloadsMAHResponseData;", "getPayloads", "()[Lcom/allegion/accesshub/models/AccessPayloadsMAHResponseData;", "payloads", "Ljava/util/UUID;", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "Ljava/util/UUID;", "getAccessRightId", "()Ljava/util/UUID;", "accessRightId", "<init>", "(Ljava/util/UUID;[Lcom/allegion/accesshub/models/AccessPayloadsMAHResponseData;)V", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AccessPayloadsMAHResponse implements Serializable {

    /* renamed from: a, reason: from kotlin metadata */
    @SerializedName("accessRightId")
    @NotNull
    private final UUID accessRightId;

    /* renamed from: b, reason: from kotlin metadata */
    @SerializedName("payloads")
    @NotNull
    private final AccessPayloadsMAHResponseData[] payloads;

    public AccessPayloadsMAHResponse(@JsonProperty("accessRightId") @NotNull UUID accessRightId, @JsonProperty("payloads") @NotNull AccessPayloadsMAHResponseData[] payloads) {
        Intrinsics.checkParameterIsNotNull(accessRightId, "accessRightId");
        Intrinsics.checkParameterIsNotNull(payloads, "payloads");
        this.accessRightId = accessRightId;
        this.payloads = payloads;
    }

    @NotNull
    public final UUID getAccessRightId() {
        return this.accessRightId;
    }

    @NotNull
    public final AccessPayloadsMAHResponseData[] getPayloads() {
        return this.payloads;
    }
}
