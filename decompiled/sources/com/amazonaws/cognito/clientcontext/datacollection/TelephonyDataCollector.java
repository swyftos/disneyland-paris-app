package com.amazonaws.cognito.clientcontext.datacollection;

import android.content.Context;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class TelephonyDataCollector extends DataCollector {
    @Override // com.amazonaws.cognito.clientcontext.datacollection.DataCollector
    public Map<String, String> collect(Context context) {
        HashMap map = new HashMap();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        if (telephonyManager != null) {
            map.put(DataRecordKey.HAS_ICC_CARD, String.valueOf(telephonyManager.hasIccCard()));
            map.put(DataRecordKey.IS_NETWORK_ROAMING, String.valueOf(telephonyManager.isNetworkRoaming()));
            map.put(DataRecordKey.NETWORK_OPERATOR, telephonyManager.getNetworkOperatorName());
            map.put(DataRecordKey.NETWORK_TYPE, String.valueOf(telephonyManager.getNetworkType()));
            map.put(DataRecordKey.PHONE_TYPE, String.valueOf(telephonyManager.getPhoneType()));
            if (telephonyManager.getSimState() == 5) {
                map.put(DataRecordKey.SIM_COUNTRY_ISO, String.valueOf(telephonyManager.getSimCountryIso()));
                map.put(DataRecordKey.SIM_OPERATOR, String.valueOf(telephonyManager.getSimOperatorName()));
            }
        }
        return map;
    }
}
