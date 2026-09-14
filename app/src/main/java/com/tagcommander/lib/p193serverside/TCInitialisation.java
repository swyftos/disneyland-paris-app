package com.tagcommander.lib.p193serverside;

import android.content.Context;
import com.tagcommander.lib.core.TCCoreInitialisation;

/* JADX INFO: loaded from: classes4.dex */
public class TCInitialisation {
    public TCInitialisation(Context context) {
        new TCCoreInitialisation(context);
        TCPredefinedVariables.getInstance().setContext(context);
    }
}
