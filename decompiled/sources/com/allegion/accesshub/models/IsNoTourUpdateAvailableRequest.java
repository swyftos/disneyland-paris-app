package com.allegion.accesshub.models;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/allegion/accesshub/models/IsNoTourUpdateAvailableRequest;", "Ljava/io/Serializable;", "", "", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "[Ljava/lang/String;", "getAccessRights", "()[Ljava/lang/String;", "accessRights", "<init>", "([Ljava/lang/String;)V", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public class IsNoTourUpdateAvailableRequest implements Serializable {

    /* renamed from: a, reason: from kotlin metadata */
    @SerializedName("accessRightIds")
    @NotNull
    private final String[] accessRights;

    public IsNoTourUpdateAvailableRequest(@JsonProperty("accessRightIds") @NotNull String[] accessRights) {
        Intrinsics.checkParameterIsNotNull(accessRights, "accessRights");
        this.accessRights = accessRights;
    }

    @NotNull
    public final String[] getAccessRights() {
        return this.accessRights;
    }
}
