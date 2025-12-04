package com.allegion.accesssdk.models;

import com.disney.id.android.OneIDRecoveryContext;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u0018R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/allegion/accesssdk/models/AlAuthenticationResponse;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", OneIDRecoveryContext.ACCESS_TOKEN, "idToken", "integrationId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/allegion/accesssdk/models/AlAuthenticationResponse;", "toString", "", "hashCode", "()I", "", ETCPaymentMethod.OTHER, "", ExactValueMatcher.EQUALS_VALUE_KEY, "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getIntegrationId", "setIntegrationId", "(Ljava/lang/String;)V", "getAccessToken", "setAccessToken", "getIdToken", "setIdToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final /* data */ class AlAuthenticationResponse implements Serializable {

    @NotNull
    private String accessToken;

    @NotNull
    private String idToken;

    @NotNull
    private String integrationId;

    public AlAuthenticationResponse() {
        this(null, null, null, 7, null);
    }

    public AlAuthenticationResponse(@NotNull String accessToken, @NotNull String idToken, @NotNull String integrationId) {
        Intrinsics.checkParameterIsNotNull(accessToken, "accessToken");
        Intrinsics.checkParameterIsNotNull(idToken, "idToken");
        Intrinsics.checkParameterIsNotNull(integrationId, "integrationId");
        this.accessToken = accessToken;
        this.idToken = idToken;
        this.integrationId = integrationId;
    }

    public static /* synthetic */ AlAuthenticationResponse copy$default(AlAuthenticationResponse alAuthenticationResponse, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = alAuthenticationResponse.accessToken;
        }
        if ((i & 2) != 0) {
            str2 = alAuthenticationResponse.idToken;
        }
        if ((i & 4) != 0) {
            str3 = alAuthenticationResponse.integrationId;
        }
        return alAuthenticationResponse.copy(str, str2, str3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getIdToken() {
        return this.idToken;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getIntegrationId() {
        return this.integrationId;
    }

    @NotNull
    public final AlAuthenticationResponse copy(@NotNull String accessToken, @NotNull String idToken, @NotNull String integrationId) {
        Intrinsics.checkParameterIsNotNull(accessToken, "accessToken");
        Intrinsics.checkParameterIsNotNull(idToken, "idToken");
        Intrinsics.checkParameterIsNotNull(integrationId, "integrationId");
        return new AlAuthenticationResponse(accessToken, idToken, integrationId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlAuthenticationResponse)) {
            return false;
        }
        AlAuthenticationResponse alAuthenticationResponse = (AlAuthenticationResponse) other;
        return Intrinsics.areEqual(this.accessToken, alAuthenticationResponse.accessToken) && Intrinsics.areEqual(this.idToken, alAuthenticationResponse.idToken) && Intrinsics.areEqual(this.integrationId, alAuthenticationResponse.integrationId);
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

    public int hashCode() {
        String str = this.accessToken;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.idToken;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.integrationId;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setAccessToken(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.accessToken = str;
    }

    public final void setIdToken(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.idToken = str;
    }

    public final void setIntegrationId(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.integrationId = str;
    }

    @NotNull
    public String toString() {
        return "AlAuthenticationResponse(accessToken=" + this.accessToken + ", idToken=" + this.idToken + ", integrationId=" + this.integrationId + ")";
    }

    public /* synthetic */ AlAuthenticationResponse(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }
}
