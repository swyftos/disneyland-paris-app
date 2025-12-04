package com.tagcommander.lib.core;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCNetwork extends TCAdditionalProperties {
    private static volatile TCNetwork INSTANCE;
    public Boolean bluetooth;
    public String carrier;
    public Boolean cellular;
    public Boolean wifi;

    private TCNetwork() {
        Boolean bool = Boolean.FALSE;
        this.bluetooth = bool;
        this.cellular = bool;
        this.wifi = bool;
        this.carrier = "";
    }

    public static TCNetwork getInstance() {
        if (INSTANCE == null) {
            synchronized (TCNetwork.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new TCNetwork();
                    }
                } finally {
                }
            }
        }
        return INSTANCE;
    }

    public JSONObject getJsonObject() {
        JSONObject jSONObject = new JSONObject(getAdditionalProperties());
        try {
            TCUtils.setBool(TCCoreConstants.TCN_BLUETOOTH, this.bluetooth, jSONObject);
            TCUtils.setString(TCCoreConstants.TCN_CARRIER, this.carrier, jSONObject);
            TCUtils.setBool(TCCoreConstants.TCN_CELLULAR, this.cellular, jSONObject);
            TCUtils.setBool(TCCoreConstants.TCN_WIFI, this.wifi, jSONObject);
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCNetwork: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jSONObject;
    }
}
