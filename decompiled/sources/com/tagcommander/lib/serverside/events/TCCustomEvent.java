package com.tagcommander.lib.serverside.events;

import com.tagcommander.lib.serverside.events.base.TCEvent;

/* loaded from: classes4.dex */
public class TCCustomEvent extends TCEvent {
    public TCCustomEvent(String str) {
        this.name = str;
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return testString(this.name);
    }
}
