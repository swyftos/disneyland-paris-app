package com.contentsquare.android.core.system;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/contentsquare/android/core/system/ConnectionType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "OFFLINE", "CONNECTIVITY_ERROR", "WIFI", "MOBILE_2G", "MOBILE_3G", "MOBILE_4G", "MOBILE_5G", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public enum ConnectionType {
    OFFLINE(-1),
    CONNECTIVITY_ERROR(0),
    WIFI(1),
    MOBILE_2G(2),
    MOBILE_3G(3),
    MOBILE_4G(4),
    MOBILE_5G(5);

    private final int value;

    ConnectionType(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
