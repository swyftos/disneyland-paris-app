package com.microsoft.appcenter.ingestion.models;

import com.facebook.hermes.intl.Constants;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes4.dex */
public class Device extends WrapperSdk {
    private String appBuild;
    private String appNamespace;
    private String appVersion;
    private String carrierCountry;
    private String carrierName;
    private String locale;
    private String model;
    private String oemName;
    private Integer osApiLevel;
    private String osBuild;
    private String osName;
    private String osVersion;
    private String screenSize;
    private String sdkName;
    private String sdkVersion;
    private Integer timeZoneOffset;

    public String getSdkName() {
        return this.sdkName;
    }

    public void setSdkName(String str) {
        this.sdkName = str;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public String getOemName() {
        return this.oemName;
    }

    public void setOemName(String str) {
        this.oemName = str;
    }

    public String getOsName() {
        return this.osName;
    }

    public void setOsName(String str) {
        this.osName = str;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public String getOsBuild() {
        return this.osBuild;
    }

    public void setOsBuild(String str) {
        this.osBuild = str;
    }

    public Integer getOsApiLevel() {
        return this.osApiLevel;
    }

    public void setOsApiLevel(Integer num) {
        this.osApiLevel = num;
    }

    public String getLocale() {
        return this.locale;
    }

    public void setLocale(String str) {
        this.locale = str;
    }

    public Integer getTimeZoneOffset() {
        return this.timeZoneOffset;
    }

    public void setTimeZoneOffset(Integer num) {
        this.timeZoneOffset = num;
    }

    public String getScreenSize() {
        return this.screenSize;
    }

    public void setScreenSize(String str) {
        this.screenSize = str;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public String getCarrierName() {
        return this.carrierName;
    }

    public void setCarrierName(String str) {
        this.carrierName = str;
    }

    public String getCarrierCountry() {
        return this.carrierCountry;
    }

    public void setCarrierCountry(String str) {
        this.carrierCountry = str;
    }

    public String getAppBuild() {
        return this.appBuild;
    }

    public void setAppBuild(String str) {
        this.appBuild = str;
    }

    public String getAppNamespace() {
        return this.appNamespace;
    }

    public void setAppNamespace(String str) {
        this.appNamespace = str;
    }

    @Override // com.microsoft.appcenter.ingestion.models.WrapperSdk, com.microsoft.appcenter.ingestion.models.Model
    public void read(JSONObject jSONObject) throws JSONException {
        super.read(jSONObject);
        setSdkName(jSONObject.getString("sdkName"));
        setSdkVersion(jSONObject.getString("sdkVersion"));
        setModel(jSONObject.getString(TCEventPropertiesNames.TCD_MODEL));
        setOemName(jSONObject.getString("oemName"));
        setOsName(jSONObject.getString("osName"));
        setOsVersion(jSONObject.getString("osVersion"));
        setOsBuild(jSONObject.optString("osBuild", null));
        setOsApiLevel(JSONUtils.readInteger(jSONObject, "osApiLevel"));
        setLocale(jSONObject.getString(Constants.LOCALE));
        setTimeZoneOffset(Integer.valueOf(jSONObject.getInt("timeZoneOffset")));
        setScreenSize(jSONObject.getString("screenSize"));
        setAppVersion(jSONObject.getString("appVersion"));
        setCarrierName(jSONObject.optString("carrierName", null));
        setCarrierCountry(jSONObject.optString("carrierCountry", null));
        setAppBuild(jSONObject.getString("appBuild"));
        setAppNamespace(jSONObject.optString("appNamespace", null));
    }

    @Override // com.microsoft.appcenter.ingestion.models.WrapperSdk, com.microsoft.appcenter.ingestion.models.Model
    public void write(JSONStringer jSONStringer) throws JSONException {
        super.write(jSONStringer);
        jSONStringer.key("sdkName").value(getSdkName());
        jSONStringer.key("sdkVersion").value(getSdkVersion());
        jSONStringer.key(TCEventPropertiesNames.TCD_MODEL).value(getModel());
        jSONStringer.key("oemName").value(getOemName());
        jSONStringer.key("osName").value(getOsName());
        jSONStringer.key("osVersion").value(getOsVersion());
        JSONUtils.write(jSONStringer, "osBuild", getOsBuild());
        JSONUtils.write(jSONStringer, "osApiLevel", getOsApiLevel());
        jSONStringer.key(Constants.LOCALE).value(getLocale());
        jSONStringer.key("timeZoneOffset").value(getTimeZoneOffset());
        jSONStringer.key("screenSize").value(getScreenSize());
        jSONStringer.key("appVersion").value(getAppVersion());
        JSONUtils.write(jSONStringer, "carrierName", getCarrierName());
        JSONUtils.write(jSONStringer, "carrierCountry", getCarrierCountry());
        jSONStringer.key("appBuild").value(getAppBuild());
        JSONUtils.write(jSONStringer, "appNamespace", getAppNamespace());
    }

    @Override // com.microsoft.appcenter.ingestion.models.WrapperSdk
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        Device device = (Device) obj;
        String str = this.sdkName;
        if (str == null ? device.sdkName != null : !str.equals(device.sdkName)) {
            return false;
        }
        String str2 = this.sdkVersion;
        if (str2 == null ? device.sdkVersion != null : !str2.equals(device.sdkVersion)) {
            return false;
        }
        String str3 = this.model;
        if (str3 == null ? device.model != null : !str3.equals(device.model)) {
            return false;
        }
        String str4 = this.oemName;
        if (str4 == null ? device.oemName != null : !str4.equals(device.oemName)) {
            return false;
        }
        String str5 = this.osName;
        if (str5 == null ? device.osName != null : !str5.equals(device.osName)) {
            return false;
        }
        String str6 = this.osVersion;
        if (str6 == null ? device.osVersion != null : !str6.equals(device.osVersion)) {
            return false;
        }
        String str7 = this.osBuild;
        if (str7 == null ? device.osBuild != null : !str7.equals(device.osBuild)) {
            return false;
        }
        Integer num = this.osApiLevel;
        if (num == null ? device.osApiLevel != null : !num.equals(device.osApiLevel)) {
            return false;
        }
        String str8 = this.locale;
        if (str8 == null ? device.locale != null : !str8.equals(device.locale)) {
            return false;
        }
        Integer num2 = this.timeZoneOffset;
        if (num2 == null ? device.timeZoneOffset != null : !num2.equals(device.timeZoneOffset)) {
            return false;
        }
        String str9 = this.screenSize;
        if (str9 == null ? device.screenSize != null : !str9.equals(device.screenSize)) {
            return false;
        }
        String str10 = this.appVersion;
        if (str10 == null ? device.appVersion != null : !str10.equals(device.appVersion)) {
            return false;
        }
        String str11 = this.carrierName;
        if (str11 == null ? device.carrierName != null : !str11.equals(device.carrierName)) {
            return false;
        }
        String str12 = this.carrierCountry;
        if (str12 == null ? device.carrierCountry != null : !str12.equals(device.carrierCountry)) {
            return false;
        }
        String str13 = this.appBuild;
        if (str13 == null ? device.appBuild != null : !str13.equals(device.appBuild)) {
            return false;
        }
        String str14 = this.appNamespace;
        return str14 != null ? str14.equals(device.appNamespace) : device.appNamespace == null;
    }

    @Override // com.microsoft.appcenter.ingestion.models.WrapperSdk
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.sdkName;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.sdkVersion;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.model;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.oemName;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.osName;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.osVersion;
        int iHashCode7 = (iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.osBuild;
        int iHashCode8 = (iHashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Integer num = this.osApiLevel;
        int iHashCode9 = (iHashCode8 + (num != null ? num.hashCode() : 0)) * 31;
        String str8 = this.locale;
        int iHashCode10 = (iHashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Integer num2 = this.timeZoneOffset;
        int iHashCode11 = (iHashCode10 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str9 = this.screenSize;
        int iHashCode12 = (iHashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.appVersion;
        int iHashCode13 = (iHashCode12 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.carrierName;
        int iHashCode14 = (iHashCode13 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.carrierCountry;
        int iHashCode15 = (iHashCode14 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.appBuild;
        int iHashCode16 = (iHashCode15 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.appNamespace;
        return iHashCode16 + (str14 != null ? str14.hashCode() : 0);
    }
}
