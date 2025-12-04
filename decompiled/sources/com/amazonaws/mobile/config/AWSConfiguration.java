package com.amazonaws.mobile.config;

import android.content.Context;
import androidx.webkit.Profile;
import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class AWSConfiguration {
    private String configName;
    private JSONObject mJSONObject;

    public AWSConfiguration(JSONObject jSONObject) {
        this(jSONObject, Profile.DEFAULT_PROFILE_NAME);
    }

    public AWSConfiguration(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("JSONObject cannot be null.");
        }
        this.configName = str;
        this.mJSONObject = jSONObject;
    }

    public AWSConfiguration(Context context) {
        this(context, getConfigResourceId(context));
    }

    private static int getConfigResourceId(Context context) {
        try {
            return context.getResources().getIdentifier("awsconfiguration", "raw", context.getPackageName());
        } catch (Exception e) {
            throw new RuntimeException("Failed to read awsconfiguration.json please check that it is correctly formed.", e);
        }
    }

    public AWSConfiguration(Context context, int i) {
        this(context, i, Profile.DEFAULT_PROFILE_NAME);
    }

    public AWSConfiguration(Context context, int i, String str) {
        this.configName = str;
        readInputJson(context, i);
    }

    private void readInputJson(Context context, int i) {
        try {
            Scanner scanner = new Scanner(context.getResources().openRawResource(i));
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
            }
            scanner.close();
            this.mJSONObject = new JSONObject(sb.toString());
        } catch (Exception e) {
            throw new RuntimeException("Failed to read awsconfiguration.json please check that it is correctly formed.", e);
        }
    }

    public JSONObject optJsonObject(String str) throws JSONException {
        try {
            JSONObject jSONObject = this.mJSONObject.getJSONObject(str);
            if (jSONObject.has(this.configName)) {
                jSONObject = jSONObject.getJSONObject(this.configName);
            }
            return new JSONObject(jSONObject.toString());
        } catch (JSONException unused) {
            return null;
        }
    }

    public String getUserAgent() {
        try {
            return this.mJSONObject.getString("UserAgent");
        } catch (JSONException unused) {
            return "";
        }
    }

    public String getUserAgentOverride() {
        try {
            return this.mJSONObject.getString("UserAgentOverride");
        } catch (JSONException unused) {
            return null;
        }
    }

    public void setConfiguration(String str) {
        this.configName = str;
    }

    public String getConfiguration() {
        return this.configName;
    }

    public String toString() {
        return this.mJSONObject.toString();
    }
}
