package com.tagcommander.lib.core;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCUser extends TCAdditionalProperties {
    private static volatile TCUser INSTANCE;
    public String ID;
    public String birthdate;
    public String city;
    public String country;
    public String email;
    public String email_md5;
    public String email_sha256;
    public String firstName;
    public String gender;
    public String lastName;
    public String phoneNumber;
    public String state;
    public String zipcode;
    ConcurrentHashMap consent_categories = new ConcurrentHashMap();
    ConcurrentHashMap consent_vendors = new ConcurrentHashMap();
    ConcurrentHashMap external_consent = new ConcurrentHashMap();
    ConcurrentHashMap google_consent_mode = new ConcurrentHashMap();
    public String consentID = TCCoreVariables.getInstance().getData(TCCoreConstants.kTCPredefinedVariable_SDKID);
    public String anonymous_id = TCCoreVariables.getInstance().getData(TCCoreConstants.kTCPredefinedVariable_SDKID);

    private TCUser() {
    }

    public static TCUser getInstance() {
        if (INSTANCE == null) {
            synchronized (TCUser.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new TCUser();
                    }
                } finally {
                }
            }
        }
        return INSTANCE;
    }

    public boolean verifyUser() {
        if (TCUtils.testString(this.ID)) {
            return true;
        }
        return TCUtils.testString(this.email);
    }

    public void resetConsent() {
        this.consent_categories.clear();
        this.consent_vendors.clear();
        this.external_consent.clear();
    }

    public void setFullConsent(Map<String, String> map) {
        resetConsent();
        for (String str : map.keySet()) {
            String str2 = map.get(str);
            if (str2 != null) {
                if (str.startsWith(TCCoreConstants.kTCCategoryPrefix) || str.startsWith(TCCoreConstants.kTCFeaturePrefix)) {
                    this.consent_categories.put(str, str2);
                } else if (str.startsWith(TCCoreConstants.kTCVendorPrefix) || str.startsWith(TCCoreConstants.kTCGoogleVendorPrefix)) {
                    this.consent_vendors.put(str, str2);
                }
            }
        }
    }

    public void setConsentCategories(Map<String, String> map) {
        this.consent_categories.clear();
        if (map != null) {
            this.consent_categories.putAll(map);
        }
    }

    public Map<String, String> getConsentCategories() {
        return this.consent_categories;
    }

    public void setConsentVendors(Map<String, String> map) {
        this.consent_vendors.clear();
        this.consent_vendors.putAll(map);
    }

    public Map<String, String> getConsentVendors() {
        return this.consent_vendors;
    }

    public void setExternalConsent(Map<String, String> map) {
        this.external_consent.clear();
        this.external_consent.putAll(map);
    }

    public Map<String, String> getExternalConsent() {
        return this.external_consent;
    }

    public JSONObject getJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject(getAdditionalProperties());
        try {
            TCUtils.setString(TCCoreConstants.TCU_ID, this.ID, jSONObject);
            TCUtils.setString(TCCoreConstants.TCU_EMAIL, this.email, jSONObject);
            TCUtils.setString(TCCoreConstants.TCU_EMAIL_MD5, this.email_md5, jSONObject);
            TCUtils.setString(TCCoreConstants.TCU_EMAIL_SHA256, this.email_sha256, jSONObject);
            TCUtils.setString(TCCoreConstants.TCU_PHONE, this.phoneNumber, jSONObject);
            TCUtils.setString(TCCoreConstants.TCU_FIRSTNAME, this.firstName, jSONObject);
            TCUtils.setString(TCCoreConstants.TCU_LASTNAME, this.lastName, jSONObject);
            TCUtils.setString(TCCoreConstants.TCU_GENDER, this.gender, jSONObject);
            TCUtils.setString(TCCoreConstants.TCU_BIRTHDATE, this.birthdate, jSONObject);
            TCUtils.setString(TCCoreConstants.TCU_CITY, this.city, jSONObject);
            TCUtils.setString(TCCoreConstants.TCU_STATE, this.state, jSONObject);
            TCUtils.setString(TCCoreConstants.TCU_ZIPCODE, this.zipcode, jSONObject);
            TCUtils.setString(TCCoreConstants.TCU_COUNTRY, this.country, jSONObject);
            TCUtils.setString(TCCoreConstants.TCU_ANONYMOUS_ID, this.anonymous_id, jSONObject);
            if (this.consent_categories.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String str : this.consent_categories.keySet()) {
                    String str2 = (String) this.consent_categories.get(str);
                    if (str2 != null && !str2.equals("0")) {
                        jSONArray.put(str.replace(TCCoreConstants.kTCCategoryPrefix, "").replace(TCCoreConstants.kTCFeaturePrefix, ""));
                    }
                }
                jSONObject.put(TCCoreConstants.TCU_CONSENTCATEGORIES, jSONArray);
            }
            if (this.consent_vendors.size() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                boolean z = true;
                for (String str3 : this.consent_vendors.keySet()) {
                    String str4 = (String) this.consent_vendors.get(str3);
                    if (str4 != null) {
                        if (str4.equals("0")) {
                            jSONArray2.put(str3.replace(TCCoreConstants.kTCVendorPrefix, "").replace(TCCoreConstants.kTCGoogleVendorPrefix, ""));
                        } else {
                            z = false;
                        }
                    }
                }
                if (z) {
                    jSONObject.put(TCCoreConstants.TCU_CONSENTVENDORS, "ALL");
                } else if (jSONArray2.length() > 0) {
                    jSONObject.put(TCCoreConstants.TCU_CONSENTVENDORS, jSONArray2);
                }
            }
            if (this.external_consent.size() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                for (String str5 : this.external_consent.keySet()) {
                    String str6 = (String) this.external_consent.get(str5);
                    if (str6 != null) {
                        jSONObject2.put(str5, str6);
                    }
                }
                jSONObject.put(TCCoreConstants.TCU_EXTERNALCONSENT, jSONObject2);
            }
            if (this.google_consent_mode.size() > 0) {
                jSONObject.put(TCCoreConstants.TCU_GOOGLE_CONSENT_MODE, new JSONObject(this.google_consent_mode));
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("Error converting TCUser to JSON: " + e.getLocalizedMessage(), 6);
        }
        return jSONObject;
    }

    public void setFirebaseConsent(HashMap<String, String> map) {
        this.google_consent_mode.clear();
        this.google_consent_mode.putAll(map);
    }
}
