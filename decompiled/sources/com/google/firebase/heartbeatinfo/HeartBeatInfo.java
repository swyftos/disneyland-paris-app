package com.google.firebase.heartbeatinfo;

import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
public interface HeartBeatInfo {
    @NonNull
    HeartBeat getHeartBeatCode(@NonNull String str);

    public enum HeartBeat {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);

        private final int code;

        HeartBeat(int i) {
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }
    }
}
