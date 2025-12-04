package com.tagcommander.lib.core;

import android.content.Context;
import com.tagcommander.lib.core.TCEventManager;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCConfigurationFile implements TCEventManager.TCConfigurationListener {
    protected Context appContext;
    protected String baseURL;
    protected int fileID;
    protected String offlineName;
    protected String sharedName;
    protected int siteID;
    public int version;
    protected String versionPath;

    @Override // com.tagcommander.lib.core.TCEventManager.TCConfigurationListener
    public void onConfigurationChanged(String str, Boolean bool, Boolean bool2) {
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCConfigurationListener
    public void onConfigurationRequest(String str, String str2) {
    }

    public boolean specificUpdate(String str, String str2) {
        return false;
    }

    public TCConfigurationFile(int i, int i2, String str, String str2, String str3, Context context) throws IOException {
        this.baseURL = "https://cdn.tagcommander.com/mobile/%d/%d/%s%s";
        this.siteID = i;
        this.fileID = i2;
        this.offlineName = str;
        this.versionPath = str2;
        this.sharedName = TCCoreConstants.kTCConfigurationFilesPrefix + this.offlineName;
        this.appContext = context;
        TCEventManager.getInstance().registerConfigurationListener(this);
        new Random(System.currentTimeMillis()).setSeed(System.currentTimeMillis());
        if (str3 == null) {
            this.baseURL = String.format(this.baseURL, Integer.valueOf(i), Integer.valueOf(i2), str, ".json");
        } else {
            this.baseURL = str3;
        }
        preSaveOfflineJSON();
        downloadConfigurationUpdate();
    }

    TCConfigurationFile(int i, int i2, String str, String str2, Context context) {
        this(i, i2, str, str2, null, context);
    }

    TCConfigurationFile(int i, int i2, String str, Context context) {
        this(i, i2, str, "information/version", null, context);
    }

    TCConfigurationFile(String str, String str2, String str3, Context context) {
        this(0, 0, str, str2, str3, context);
    }

    void preSaveOfflineJSON() throws IOException {
        String strRetrieveInfoFromSharedPreferences = TCSharedPreferences.retrieveInfoFromSharedPreferences(this.sharedName, this.appContext);
        try {
            InputStream inputStreamOpen = this.appContext.getAssets().open(this.offlineName + ".json");
            byte[] bArr = new byte[inputStreamOpen.available()];
            inputStreamOpen.read(bArr);
            inputStreamOpen.close();
            String str = new String(bArr, "UTF-8");
            if (strRetrieveInfoFromSharedPreferences.isEmpty() && !str.isEmpty()) {
                saveConfIntoSDK(str);
            } else if (!str.isEmpty()) {
                updateConfiguration(strRetrieveInfoFromSharedPreferences, str);
            }
        } catch (IOException e) {
            TCLogger.getInstance().logMessage("Couldn't find configuration " + this.offlineName + " in assets: " + e.getLocalizedMessage(), 4);
        }
    }

    int getVersionFromJSONObject(JSONObject jSONObject) throws JSONException {
        String leaf = getLeaf(jSONObject, this.versionPath);
        if (isInteger(leaf)) {
            return Integer.parseInt(leaf);
        }
        return (int) (parseTimestamp(leaf) / 86400);
    }

    long parseTimestamp(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz").parse(str).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    private static boolean isInteger(String str) {
        if (str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (Character.digit(str.charAt(i), 10) < 0) {
                return false;
            }
        }
        return true;
    }

    String getLeaf(JSONObject jSONObject, String str) throws JSONException {
        String[] strArrSplit = str.split("/");
        String string = "0";
        JSONObject jSONObject2 = jSONObject;
        for (int i = 0; i < strArrSplit.length; i++) {
            try {
                String str2 = strArrSplit[i];
                if (jSONObject2.has(str2)) {
                    if (i < strArrSplit.length - 1) {
                        jSONObject2 = jSONObject.getJSONObject(str2);
                    } else {
                        string = jSONObject2.getString(str2);
                    }
                }
            } catch (JSONException e) {
                TCLogger.getInstance().logMessage("Error getting branch in JSON: " + e.getLocalizedMessage(), 6);
            }
        }
        return string;
    }

    void downloadConfigurationUpdate() {
        TCLogger.getInstance().logMessage("Checking for update in privacy configuration: " + this.offlineName, 4);
        TCEventManager.getInstance().callOnConfigurationRequest(this.offlineName, this.baseURL);
    }

    void updateConfiguration(String str, String str2) {
        if (!str.trim().equals(str2.trim())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = new JSONObject(str2);
                int versionFromJSONObject = getVersionFromJSONObject(jSONObject);
                int versionFromJSONObject2 = getVersionFromJSONObject(jSONObject2);
                boolean zCheckSpecificationVersionUpgrade = checkSpecificationVersionUpgrade(jSONObject, jSONObject2);
                boolean zCheckSpecificationVersionChange = checkSpecificationVersionChange(jSONObject, jSONObject2);
                if ((versionFromJSONObject < versionFromJSONObject2 && !zCheckSpecificationVersionChange) || zCheckSpecificationVersionUpgrade) {
                    saveConfIntoSDK(str2);
                    specificUpdate(str, str2);
                } else {
                    updateConfigurationAttributes(str);
                }
                return;
            } catch (JSONException unused) {
                TCLogger.getInstance().logMessage("Either the offline or the new configuration is not a valid JSON", 6);
                TCLogger.getInstance().logMessage("Saved one: " + str, 6);
                TCLogger.getInstance().logMessage("New one: " + str2, 6);
                return;
            }
        }
        updateConfigurationAttributes(str2);
    }

    private boolean checkSpecificationVersionUpgrade(JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.offlineName.equals(TCCoreConstants.kTCVendorListConfiguration)) {
            try {
                return ((Integer) jSONObject2.get("tcfPolicyVersion")).intValue() > ((Integer) jSONObject.get("tcfPolicyVersion")).intValue();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        if (!this.offlineName.contains(TCCoreConstants.IAB_TRANSLATE_FILE_PREFIX) || jSONObject.has("dataCategories") || !jSONObject2.has("dataCategories")) {
            return false;
        }
        TCEventManager.getInstance().callOnPolicySpeceficationUpgrade();
        return false;
    }

    private boolean checkSpecificationVersionChange(JSONObject jSONObject, JSONObject jSONObject2) {
        if (!this.offlineName.equals(TCCoreConstants.kTCVendorListConfiguration)) {
            return false;
        }
        try {
            return ((Integer) jSONObject2.get("tcfPolicyVersion")).intValue() != ((Integer) jSONObject.get("tcfPolicyVersion")).intValue();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveConfIntoSDK(String str) {
        TCSharedPreferences.saveInfoToSharedPreferences(this.sharedName, str, this.appContext);
        updateConfigurationAttributes(str);
    }

    private void updateConfigurationAttributes(String str) {
        try {
            this.version = getVersionFromJSONObject(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getFullJson() {
        return TCSharedPreferences.retrieveInfoFromSharedPreferences(this.sharedName, this.appContext);
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCConfigurationListener
    public void onConfigurationResponse(String str, String str2) {
        if (!str.equals(this.offlineName) || str2 == null) {
            return;
        }
        String strRetrieveInfoFromSharedPreferences = TCSharedPreferences.retrieveInfoFromSharedPreferences(this.sharedName, this.appContext);
        if (strRetrieveInfoFromSharedPreferences.isEmpty()) {
            saveConfIntoSDK(str2);
        } else {
            updateConfiguration(strRetrieveInfoFromSharedPreferences, str2);
        }
    }
}
