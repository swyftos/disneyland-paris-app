package com.allegion.accesshub.models;

import androidx.autofill.HintConstants;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002\u0012\b\b\u0001\u0010\r\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/allegion/accesshub/models/PhoneVerificationMAHResponse;", "Ljava/io/Serializable;", "", "c", "Ljava/lang/String;", "getCreatedTime", "()Ljava/lang/String;", "createdTime", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "getPhoneNumber", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "b", "getId", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class PhoneVerificationMAHResponse implements Serializable {

    /* renamed from: a, reason: from kotlin metadata */
    @SerializedName(HintConstants.AUTOFILL_HINT_PHONE_NUMBER)
    @NotNull
    private final String phoneNumber;

    /* renamed from: b, reason: from kotlin metadata */
    @SerializedName("id")
    @NotNull
    private final String id;

    /* renamed from: c, reason: from kotlin metadata */
    @SerializedName("createdTime")
    @NotNull
    private final String createdTime;

    public PhoneVerificationMAHResponse(@JsonProperty(HintConstants.AUTOFILL_HINT_PHONE_NUMBER) @NotNull String phoneNumber, @JsonProperty("id") @NotNull String id, @JsonProperty("createdTime") @NotNull String createdTime) {
        Intrinsics.checkParameterIsNotNull(phoneNumber, "phoneNumber");
        Intrinsics.checkParameterIsNotNull(id, "id");
        Intrinsics.checkParameterIsNotNull(createdTime, "createdTime");
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.createdTime = createdTime;
    }

    @NotNull
    public final String getCreatedTime() {
        return this.createdTime;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }
}
