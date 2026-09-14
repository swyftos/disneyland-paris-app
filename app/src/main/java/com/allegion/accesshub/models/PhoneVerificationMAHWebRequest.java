package com.allegion.accesshub.models;

import androidx.autofill.HintConstants;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1834bv = {1, 0, 3}, m1835d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, m1836d2 = {"Lcom/allegion/accesshub/models/PhoneVerificationMAHWebRequest;", "Ljava/io/Serializable;", "", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getPhoneNumber", "()Ljava/lang/String;", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "<init>", "(Ljava/lang/String;)V", "AccessHub_prodRelease"}, m1837k = 1, m1838mv = {1, 4, 0})
public final class PhoneVerificationMAHWebRequest implements Serializable {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @SerializedName(HintConstants.AUTOFILL_HINT_PHONE_NUMBER)
    @NotNull
    private final String phoneNumber;

    public PhoneVerificationMAHWebRequest(@NotNull String phoneNumber) {
        Intrinsics.checkParameterIsNotNull(phoneNumber, "phoneNumber");
        this.phoneNumber = phoneNumber;
    }

    @NotNull
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }
}
