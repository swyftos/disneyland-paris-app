package com.allegion.accesshub.models;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.disney.id.android.OneIDRecoveryContext;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u000e\u001a\u00020\t\u0012\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\t8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/allegion/accesshub/models/AccessPayloadsMAHWebRequest;", "Ljava/io/Serializable;", "", "Lcom/allegion/accesshub/models/AccessPayloadsMAHWebRequestData;", "b", "[Lcom/allegion/accesshub/models/AccessPayloadsMAHWebRequestData;", "getPayloadRequests", "()[Lcom/allegion/accesshub/models/AccessPayloadsMAHWebRequestData;", "payloadRequests", "", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getAccessToken", "()Ljava/lang/String;", OneIDRecoveryContext.ACCESS_TOKEN, "<init>", "(Ljava/lang/String;[Lcom/allegion/accesshub/models/AccessPayloadsMAHWebRequestData;)V", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public class AccessPayloadsMAHWebRequest implements Serializable {

    /* renamed from: a, reason: from kotlin metadata */
    @SerializedName(OneIDRecoveryContext.ACCESS_TOKEN)
    @NotNull
    private final String accessToken;

    /* renamed from: b, reason: from kotlin metadata */
    @SerializedName("payloadRequests")
    @NotNull
    private final AccessPayloadsMAHWebRequestData[] payloadRequests;

    public AccessPayloadsMAHWebRequest(@JsonProperty(OneIDRecoveryContext.ACCESS_TOKEN) @NotNull String accessToken, @JsonProperty("payloadRequests") @NotNull AccessPayloadsMAHWebRequestData[] payloadRequests) {
        Intrinsics.checkParameterIsNotNull(accessToken, "accessToken");
        Intrinsics.checkParameterIsNotNull(payloadRequests, "payloadRequests");
        this.accessToken = accessToken;
        this.payloadRequests = payloadRequests;
    }

    @NotNull
    public final String getAccessToken() {
        return this.accessToken;
    }

    @NotNull
    public final AccessPayloadsMAHWebRequestData[] getPayloadRequests() {
        return this.payloadRequests;
    }
}
