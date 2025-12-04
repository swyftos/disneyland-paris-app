package com.urbanairship.messagecenter.ui;

import android.view.accessibility.AccessibilityManager;

/* loaded from: classes5.dex */
public final /* synthetic */ class MessageCenterListFragment$$ExternalSyntheticLambda0 implements AccessibilityManager.TouchExplorationStateChangeListener {
    public final /* synthetic */ MessageCenterListFragment f$0;

    public /* synthetic */ MessageCenterListFragment$$ExternalSyntheticLambda0(MessageCenterListFragment messageCenterListFragment) {
        this.f$0 = messageCenterListFragment;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        this.f$0.updateTouchExplorationEnabled(z);
    }
}
