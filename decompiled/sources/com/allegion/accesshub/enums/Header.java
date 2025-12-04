package com.allegion.accesshub.enums;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/allegion/accesshub/enums/Header;", "", "", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "CONTENT_TYPE_JSON", "SUBSCRIPTION_KEY", "DEVICE_SIG", "AUTH", "AUTOMATED_TEST", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public enum Header {
    CONTENT_TYPE_JSON("content_type"),
    SUBSCRIPTION_KEY("alle-subscription-key"),
    DEVICE_SIG("device-signature"),
    AUTH("authorization"),
    AUTOMATED_TEST("automated-api-test");


    /* renamed from: a, reason: from kotlin metadata */
    @NotNull
    private final String value;

    Header(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
