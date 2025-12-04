package com.allegion.accesshub.models;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/allegion/accesshub/models/AccessPayloadsMAHResponseData;", "Ljava/io/Serializable;", "", "b", "Ljava/lang/String;", "getPayload", "()Ljava/lang/String;", "payload", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "getPayloadType", "payloadType", "c", "getDeviceId", "deviceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AccessPayloadsMAHResponseData implements Serializable {

    /* renamed from: a, reason: from kotlin metadata */
    @SerializedName("payloadType")
    @NotNull
    private final String payloadType;

    /* renamed from: b, reason: from kotlin metadata */
    @SerializedName("payload")
    @NotNull
    private final String payload;

    /* renamed from: c, reason: from kotlin metadata */
    @SerializedName("deviceId")
    @Nullable
    private final String deviceId;

    public AccessPayloadsMAHResponseData(@JsonProperty("payloadType") @NotNull String payloadType, @JsonProperty("payload") @NotNull String payload, @JsonProperty("deviceId") @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(payloadType, "payloadType");
        Intrinsics.checkParameterIsNotNull(payload, "payload");
        this.payloadType = payloadType;
        this.payload = payload;
        this.deviceId = str;
    }

    @Nullable
    public final String getDeviceId() {
        return this.deviceId;
    }

    @NotNull
    public final String getPayload() {
        return this.payload;
    }

    @NotNull
    public final String getPayloadType() {
        return this.payloadType;
    }

    public /* synthetic */ AccessPayloadsMAHResponseData(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3);
    }
}
