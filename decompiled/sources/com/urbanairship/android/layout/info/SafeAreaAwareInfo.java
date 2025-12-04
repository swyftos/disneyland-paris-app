package com.urbanairship.android.layout.info;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/info/SafeAreaAwareInfo;", "Lcom/urbanairship/android/layout/info/SafeAreaAware;", "ignoreSafeArea", "", "(Z)V", "getIgnoreSafeArea", "()Z", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SafeAreaAwareInfo implements SafeAreaAware {
    private final boolean ignoreSafeArea;

    public SafeAreaAwareInfo(boolean z) {
        this.ignoreSafeArea = z;
    }

    @Override // com.urbanairship.android.layout.info.SafeAreaAware
    public boolean getIgnoreSafeArea() {
        return this.ignoreSafeArea;
    }
}
