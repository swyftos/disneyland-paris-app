package com.tagcommander.lib.core;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public class TCCoreInitialisation {
    public TCCoreInitialisation(Context context) {
        TCLogger.getInstance();
        TCNetworkManager.getInstance().registerContextAndListeners(context);
        TCCoreVariables.getInstance().setContext(context);
    }
}
