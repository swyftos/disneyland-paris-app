package com.tagcommander.lib.serverside.schemas;

import com.tagcommander.lib.core.TCAdditionalProperties;
import com.tagcommander.lib.core.TCCoreConstants;
import com.tagcommander.lib.core.TCCoreVariables;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCNetwork;
import com.tagcommander.lib.core.TCUtils;
import com.tagcommander.lib.serverside.TCPredefinedVariables;
import com.tagcommander.lib.serverside.TCServerSideConstants;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCDevice extends TCAdditionalProperties {
    private static volatile TCDevice INSTANCE;
    public String IDFA;
    public String adTrackingEnabled;
    public String language;
    public String manufacturer;
    public String model;
    public String name;
    public String osName;
    private final TCOsProperties osProperties;
    public String osVersion;
    public String region;
    public Float screenDensity;
    public Integer screenHeight;
    private final TCScreenProperties screenProperties;
    public Integer screenWidth;
    public String sdkID;
    public String timezone;
    public String type;
    public String user_agent;

    private TCDevice() {
        TCPredefinedVariables tCPredefinedVariables = TCPredefinedVariables.getInstance();
        this.sdkID = tCPredefinedVariables.getData(TCCoreConstants.kTCPredefinedVariable_SDKID);
        this.manufacturer = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_Manufacturer);
        this.model = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_Model);
        this.name = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_Device);
        this.type = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_RuntimeName);
        this.osName = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_RuntimeName);
        this.osVersion = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_SystemVersion);
        this.screenWidth = Integer.valueOf(Integer.parseInt(tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_ScreenWidth)));
        this.screenHeight = Integer.valueOf(Integer.parseInt(tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_ScreenHeight)));
        this.screenDensity = Float.valueOf(Float.parseFloat(tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_ScreenDensity)));
        this.language = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_Language);
        this.region = tCPredefinedVariables.getData(TCServerSideConstants.kTCPredefinedVariable_Region);
        this.osProperties = new TCOsProperties();
        this.screenProperties = new TCScreenProperties();
        this.timezone = TimeZone.getDefault().getID();
    }

    public static TCDevice getInstance() {
        if (INSTANCE == null) {
            synchronized (TCDevice.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new TCDevice();
                    }
                } finally {
                }
            }
        }
        return INSTANCE;
    }

    public JSONObject getJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject(getAdditionalProperties());
        try {
            TCUtils.setString(TCEventPropertiesNames.TCD_SDK_ID, this.sdkID, jSONObject);
            TCUtils.setString("advertising_id", this.IDFA, jSONObject);
            TCUtils.setString(TCEventPropertiesNames.TCD_ADTRACKING, this.adTrackingEnabled, jSONObject);
            String data = TCCoreVariables.getInstance().getData(TCCoreConstants.kTCPredefinedVariable_UserAgent);
            if (this.user_agent == null) {
                this.user_agent = data;
            }
            TCUtils.setString(TCEventPropertiesNames.TCD_USER_AGENT, this.user_agent, jSONObject);
            TCUtils.setString(TCEventPropertiesNames.TCD_MANUFACTURER, this.manufacturer, jSONObject);
            TCUtils.setString(TCEventPropertiesNames.TCD_LANGUAGE, this.language, jSONObject);
            TCUtils.setString("region", this.region, jSONObject);
            TCUtils.setString(TCEventPropertiesNames.TCD_MODEL, this.model, jSONObject);
            TCUtils.setString("name", this.name, jSONObject);
            TCUtils.setString("type", this.type, jSONObject);
            JSONObject jsonObject = TCNetwork.getInstance().getJsonObject();
            if (jsonObject != null) {
                jSONObject.put(TCEventPropertiesNames.TCN_NETWORK, jsonObject);
            }
            JSONObject jsonObject2 = getOsProperties().getJsonObject();
            jsonObject2.put("name", this.osName);
            jsonObject2.put("version", this.osVersion);
            if (jsonObject2.length() > 0) {
                jSONObject.put("os", jsonObject2);
            }
            JSONObject jsonObject3 = getScreenProperties().getJsonObject();
            jsonObject3.put("width", this.screenWidth);
            jsonObject3.put("height", this.screenHeight);
            jsonObject3.put(TCEventPropertiesNames.TCD_SCREEN_DENSITY, this.screenDensity);
            if (jsonObject3.length() > 0) {
                jSONObject.put(TCEventPropertiesNames.TCD_SCREEN, jsonObject3);
            }
            TCUtils.setString(TCEventPropertiesNames.TCD_TIMEZONE, this.timezone, jSONObject);
            jSONObject.put(TCEventPropertiesNames.TCL_LIFECYCLE, TCLifecycle.getInstance().getJsonObject());
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCDevice: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jSONObject;
    }

    public void setAdvertisingIds() {
        TCCoreVariables tCCoreVariables = TCCoreVariables.getInstance();
        this.adTrackingEnabled = tCCoreVariables.getData(TCCoreConstants.kTCPredefinedVariable_AddTrackingEnabled);
        this.IDFA = tCCoreVariables.getData(TCCoreConstants.kTCPredefinedVariable_IDFA);
    }

    public class TCScreenProperties extends TCAdditionalProperties {
        public TCScreenProperties() {
        }

        public JSONObject getJsonObject() {
            return new JSONObject(getAdditionalProperties());
        }
    }

    public TCScreenProperties getScreenProperties() {
        return this.screenProperties;
    }

    public class TCOsProperties extends TCAdditionalProperties {
        public TCOsProperties() {
        }

        public JSONObject getJsonObject() {
            return new JSONObject(getAdditionalProperties());
        }
    }

    public TCOsProperties getOsProperties() {
        return this.osProperties;
    }
}
