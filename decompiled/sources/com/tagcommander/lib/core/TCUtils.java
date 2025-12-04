package com.tagcommander.lib.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.picocontainer.Characteristics;

/* loaded from: classes4.dex */
public class TCUtils {
    public static boolean testString(String str) {
        return (str == null || str.equals("")) ? false : true;
    }

    public static BigDecimal stringToPreciseDouble(String str) throws NumberFormatException {
        return BigDecimal.valueOf(new Double(str).doubleValue()).setScale(3, RoundingMode.HALF_UP);
    }

    public static Boolean stringToBoolean(String str) {
        return Boolean.valueOf(str.equalsIgnoreCase(Characteristics.TRUE) || str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("1"));
    }

    public static void setBool(String str, Boolean bool, JSONObject jSONObject) throws JSONException {
        jSONObject.put(str, bool);
    }

    public static void setString(String str, String str2, JSONObject jSONObject) throws JSONException {
        if (testString(str2)) {
            jSONObject.put(str, str2);
        }
    }

    public static void setIntFromString(String str, String str2, JSONObject jSONObject) throws JSONException {
        if (testString(str2)) {
            jSONObject.put(str, Integer.parseInt(str2));
        }
    }

    public static void setBigDecimalFromString(String str, String str2, JSONObject jSONObject) throws JSONException {
        if (testString(str2)) {
            try {
                jSONObject.put(str, stringToPreciseDouble(str2));
            } catch (NumberFormatException unused) {
                TCLogger.getInstance().logMessage("Please provide a number format for key : " + str, 6);
            }
        }
    }

    public static void setFloat(String str, Float f, JSONObject jSONObject) throws JSONException {
        jSONObject.put(str, f);
    }

    public static void setInteger(String str, Integer num, JSONObject jSONObject) throws JSONException {
        jSONObject.put(str, num);
    }

    public static void setList(List<String> list, String str, JSONObject jSONObject) throws JSONException {
        if (list == null || list.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            try {
                jSONArray.put(i, list.get(i));
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        jSONObject.put(str, jSONArray);
    }
}
