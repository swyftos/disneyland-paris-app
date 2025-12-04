package com.tagcommander.lib.serverside.events.base;

import com.tagcommander.lib.serverside.schemas.TCItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class TCECommerceEvent extends TCEvent {
    public String currency;
    public List<TCItem> items = new ArrayList();

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return true;
    }

    protected TCECommerceEvent() {
    }
}
