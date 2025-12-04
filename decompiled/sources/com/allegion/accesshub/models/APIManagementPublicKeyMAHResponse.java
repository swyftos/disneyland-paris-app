package com.allegion.accesshub.models;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/allegion/accesshub/models/APIManagementPublicKeyMAHResponse;", "Ljava/io/Serializable;", "", "b", "Ljava/lang/String;", "getPublicKey1", "()Ljava/lang/String;", "publicKey1", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "getPublicKey0", "publicKey0", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class APIManagementPublicKeyMAHResponse implements Serializable {

    /* renamed from: a, reason: from kotlin metadata */
    @SerializedName("publicKey0")
    @NotNull
    private final String publicKey0;

    /* renamed from: b, reason: from kotlin metadata */
    @SerializedName("publicKey1")
    @NotNull
    private final String publicKey1;

    public APIManagementPublicKeyMAHResponse(@JsonProperty("publicKey0") @NotNull String publicKey0, @JsonProperty("publicKey1") @NotNull String publicKey1) {
        Intrinsics.checkParameterIsNotNull(publicKey0, "publicKey0");
        Intrinsics.checkParameterIsNotNull(publicKey1, "publicKey1");
        this.publicKey0 = publicKey0;
        this.publicKey1 = publicKey1;
    }

    @NotNull
    public final String getPublicKey0() {
        return this.publicKey0;
    }

    @NotNull
    public final String getPublicKey1() {
        return this.publicKey1;
    }
}
