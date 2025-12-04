package com.allegion.accesshub.models;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/allegion/accesshub/models/CreateAccountMAHResponse;", "Ljava/io/Serializable;", "Ljava/util/UUID;", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "Ljava/util/UUID;", "getId", "()Ljava/util/UUID;", "id", "<init>", "(Ljava/util/UUID;)V", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class CreateAccountMAHResponse implements Serializable {

    /* renamed from: a, reason: from kotlin metadata */
    @SerializedName("id")
    @NotNull
    private final UUID id;

    public CreateAccountMAHResponse(@JsonProperty("id") @NotNull UUID id) {
        Intrinsics.checkParameterIsNotNull(id, "id");
        this.id = id;
    }

    @NotNull
    public final UUID getId() {
        return this.id;
    }
}
