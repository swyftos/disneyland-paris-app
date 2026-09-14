package com.allegion.accesshub.models;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.disney.p026id.android.OneIDRecoveryContext;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1834bv = {1, 0, 3}, m1835d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0001\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0010"}, m1836d2 = {"Lcom/allegion/accesshub/models/AuthenticationMAHResponse;", "Ljava/io/Serializable;", "", "b", "Ljava/lang/String;", "getAccessToken", "()Ljava/lang/String;", OneIDRecoveryContext.ACCESS_TOKEN, CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "getIdToken", "idToken", "c", "getIntegrationId", "integrationId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "AccessHub_prodRelease"}, m1837k = 1, m1838mv = {1, 4, 0})
public final class AuthenticationMAHResponse implements Serializable {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @SerializedName("idToken")
    @NotNull
    private final String idToken;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @SerializedName(OneIDRecoveryContext.ACCESS_TOKEN)
    @NotNull
    private final String accessToken;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @SerializedName("integrationId")
    @NotNull
    private final String integrationId;

    public AuthenticationMAHResponse(@JsonProperty("idToken") @NotNull String idToken, @JsonProperty(OneIDRecoveryContext.ACCESS_TOKEN) @NotNull String accessToken, @JsonProperty("integrationId") @NotNull String integrationId) {
        Intrinsics.checkParameterIsNotNull(idToken, "idToken");
        Intrinsics.checkParameterIsNotNull(accessToken, "accessToken");
        Intrinsics.checkParameterIsNotNull(integrationId, "integrationId");
        this.idToken = idToken;
        this.accessToken = accessToken;
        this.integrationId = integrationId;
    }

    @NotNull
    public final String getAccessToken() {
        return this.accessToken;
    }

    @NotNull
    public final String getIdToken() {
        return this.idToken;
    }

    @NotNull
    public final String getIntegrationId() {
        return this.integrationId;
    }
}
