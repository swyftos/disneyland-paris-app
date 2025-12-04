package com.tagcommander.lib.serverside;

import android.content.Context;
import com.tagcommander.lib.core.TCCoreInitialisation;

/* loaded from: classes4.dex */
public class TCInitialisation {
    public TCInitialisation(Context context) throws NumberFormatException {
        new TCCoreInitialisation(context);
        TCPredefinedVariables.getInstance().setContext(context);
    }
}
