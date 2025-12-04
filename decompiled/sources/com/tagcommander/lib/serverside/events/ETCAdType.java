package com.tagcommander.lib.serverside.events;

import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
public enum ETCAdType {
    pre_roll("pre-roll"),
    mid_roll("mid-roll"),
    post_roll("post-roll");

    private String value;

    ETCAdType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return this.value;
    }
}
