package com.allegion.accesshub.models;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B5\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0002\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0001\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/allegion/accesshub/models/AccessPayloadsMAHWebRequestData;", "Ljava/io/Serializable;", "", "b", "Ljava/lang/String;", "getMobileDevicePropertyBag", "()Ljava/lang/String;", "mobileDevicePropertyBag", "", "c", "Ljava/util/Map;", "getPayloadArgs", "()Ljava/util/Map;", "payloadArgs", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "getPayloadType", "payloadType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public class AccessPayloadsMAHWebRequestData implements Serializable {

    /* renamed from: a, reason: from kotlin metadata */
    @SerializedName("payloadType")
    @NotNull
    private final String payloadType;

    /* renamed from: b, reason: from kotlin metadata */
    @SerializedName("mobileDevicePropertyBag")
    @Nullable
    private final String mobileDevicePropertyBag;

    /* renamed from: c, reason: from kotlin metadata */
    @SerializedName("payloadArgs")
    @NotNull
    private final Map<String, Serializable> payloadArgs;

    /* JADX WARN: Multi-variable type inference failed */
    public AccessPayloadsMAHWebRequestData(@JsonProperty("payloadType") @NotNull String payloadType, @JsonProperty("mobileDevicePropertyBag") @Nullable String str, @JsonProperty("payloadArgs") @NotNull Map<String, ? extends Serializable> payloadArgs) {
        Intrinsics.checkParameterIsNotNull(payloadType, "payloadType");
        Intrinsics.checkParameterIsNotNull(payloadArgs, "payloadArgs");
        this.payloadType = payloadType;
        this.mobileDevicePropertyBag = str;
        this.payloadArgs = payloadArgs;
    }

    @Nullable
    public final String getMobileDevicePropertyBag() {
        return this.mobileDevicePropertyBag;
    }

    @NotNull
    public final Map<String, Serializable> getPayloadArgs() {
        return this.payloadArgs;
    }

    @NotNull
    public final String getPayloadType() {
        return this.payloadType;
    }
}
