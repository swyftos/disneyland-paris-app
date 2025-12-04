package com.allegion.accesshub.models;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.disney.id.android.OneIDRecoveryContext;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u00002\u00020\u0001BC\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0001\u0010\r\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0013\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/allegion/accesshub/models/CommissionRequest;", "Ljava/io/Serializable;", "", "e", "Ljava/lang/String;", "getSerialNumber", "()Ljava/lang/String;", "serialNumber", "f", "getZone", "zone", "d", "getPayload", "payload", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "getAccessToken", OneIDRecoveryContext.ACCESS_TOKEN, "c", "getDuid", "duid", "b", "getSiteId", "siteId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class CommissionRequest implements Serializable {

    /* renamed from: a, reason: from kotlin metadata */
    @SerializedName(OneIDRecoveryContext.ACCESS_TOKEN)
    @NotNull
    private final String accessToken;

    /* renamed from: b, reason: from kotlin metadata */
    @SerializedName("siteId")
    @NotNull
    private final String siteId;

    /* renamed from: c, reason: from kotlin metadata */
    @SerializedName("duid")
    @NotNull
    private final String duid;

    /* renamed from: d, reason: from kotlin metadata */
    @SerializedName("payload")
    @NotNull
    private final String payload;

    /* renamed from: e, reason: from kotlin metadata */
    @SerializedName("serialNumber")
    @NotNull
    private final String serialNumber;

    /* renamed from: f, reason: from kotlin metadata */
    @SerializedName("zone")
    @NotNull
    private final String zone;

    public CommissionRequest(@JsonProperty(OneIDRecoveryContext.ACCESS_TOKEN) @NotNull String accessToken, @JsonProperty("siteId") @NotNull String siteId, @JsonProperty("duid") @NotNull String duid, @JsonProperty("payload") @NotNull String payload, @JsonProperty("serialNumber") @NotNull String serialNumber, @JsonProperty("zone") @NotNull String zone) {
        Intrinsics.checkParameterIsNotNull(accessToken, "accessToken");
        Intrinsics.checkParameterIsNotNull(siteId, "siteId");
        Intrinsics.checkParameterIsNotNull(duid, "duid");
        Intrinsics.checkParameterIsNotNull(payload, "payload");
        Intrinsics.checkParameterIsNotNull(serialNumber, "serialNumber");
        Intrinsics.checkParameterIsNotNull(zone, "zone");
        this.accessToken = accessToken;
        this.siteId = siteId;
        this.duid = duid;
        this.payload = payload;
        this.serialNumber = serialNumber;
        this.zone = zone;
    }

    @NotNull
    public final String getAccessToken() {
        return this.accessToken;
    }

    @NotNull
    public final String getDuid() {
        return this.duid;
    }

    @NotNull
    public final String getPayload() {
        return this.payload;
    }

    @NotNull
    public final String getSerialNumber() {
        return this.serialNumber;
    }

    @NotNull
    public final String getSiteId() {
        return this.siteId;
    }

    @NotNull
    public final String getZone() {
        return this.zone;
    }
}
