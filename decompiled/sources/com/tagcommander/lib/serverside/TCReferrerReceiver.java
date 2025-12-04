package com.tagcommander.lib.serverside;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCSharedPreferences;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import gherkin.GherkinLanguageConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* loaded from: classes4.dex */
public class TCReferrerReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(TCEventPropertiesNames.TCE_REFERRER);
        if (stringExtra != null) {
            TCLogger.getInstance().logMessage("Referrer received: " + stringExtra, 3);
            cutReferrer(stringExtra);
            TCPredefinedVariables.getInstance().addData(TCServerSideConstants.kTCPredefinedVariable_InstallReferrer, stringExtra);
            TCSharedPreferences.saveInfoToSharedPreferences("loggingReferrer", stringExtra, context);
        }
    }

    public static void cutReferrer(String str) {
        TCPredefinedVariables tCPredefinedVariables = TCPredefinedVariables.getInstance();
        try {
            for (String str2 : URLDecoder.decode(str, "utf-8").split("&")) {
                String[] strArrSplit = str2.split("=");
                if (strArrSplit.length > 1) {
                    tCPredefinedVariables.addData(GherkinLanguageConstants.COMMENT_PREFIX + strArrSplit[0] + GherkinLanguageConstants.COMMENT_PREFIX, strArrSplit[1]);
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
