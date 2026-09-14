package com.tagcommander.lib.p193serverside.events;

import com.tagcommander.lib.p193serverside.events.base.TCEvent;

/* JADX INFO: loaded from: classes4.dex */
public class TCCustomEvent extends TCEvent {
    public TCCustomEvent(String str) {
        this.name = str;
    }

    @Override // com.tagcommander.lib.p193serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return testString(this.name);
    }
}
