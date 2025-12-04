package com.tagcommander.lib.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class TCSharedPreferences {
    private static SharedPreferences getSharePreferences(boolean z, Context context) {
        if (z) {
            return PreferenceManager.getDefaultSharedPreferences(context);
        }
        return context.getSharedPreferences(TCCoreConstants.kTCSharedPreferencesName, 0);
    }

    public static void saveInfoToSharedPreferences(String str, boolean z, boolean z2, Context context) {
        if (context == null) {
            TCLogger.getInstance().logMessage("Trying to save information to the shared preferences with a null context", 6);
            return;
        }
        SharedPreferences.Editor editorEdit = getSharePreferences(z2, context).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.apply();
    }

    public static void saveInfoToSharedPreferences(String str, int i, boolean z, Context context) {
        if (context == null) {
            TCLogger.getInstance().logMessage("Trying to save information to the shared preferences with a null context", 6);
            return;
        }
        SharedPreferences.Editor editorEdit = getSharePreferences(z, context).edit();
        editorEdit.putInt(str, i);
        editorEdit.apply();
    }

    public static void saveInfoToSharedPreferences(String str, String str2, boolean z, Context context) {
        if (context == null) {
            TCLogger.getInstance().logMessage("Trying to save information to the shared preferences with a null context", 6);
            return;
        }
        SharedPreferences.Editor editorEdit = getSharePreferences(z, context).edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public static String retrieveInfoFromSharedPreferences(String str, boolean z, Context context) {
        if (context == null) {
            TCLogger.getInstance().logMessage("Trying to retrieve information from the shared preferences with a null context", 6);
            return "";
        }
        return getSharePreferences(z, context).getString(str, "");
    }

    public static int retrieveIntFromSharedPreferences(String str, boolean z, Context context) {
        if (context == null) {
            TCLogger.getInstance().logMessage("Trying to retrieve information from the shared preferences with a null context", 6);
            return 0;
        }
        return getSharePreferences(z, context).getInt(str, 0);
    }

    public static void saveInfoToSharedPreferences(String str, String str2, Context context) {
        saveInfoToSharedPreferences(str, str2, false, context);
    }

    public static void saveInfoToSharedPreferences(String str, Integer num, Context context) {
        saveInfoToSharedPreferences(str, num.intValue(), false, context);
    }

    public static String retrieveInfoFromSharedPreferences(String str, Context context) {
        return retrieveInfoFromSharedPreferences(str, false, context);
    }

    public static int retrieveIntFromSharedPreferences(String str, Context context) {
        return retrieveIntFromSharedPreferences(str, false, context);
    }

    public static void removeFromSharedPreferences(String str, boolean z, Context context) {
        SharedPreferences.Editor editorEdit = getSharePreferences(z, context).edit();
        editorEdit.remove(str);
        editorEdit.apply();
    }

    public static void saveMapToSharedPreferences(HashMap<String, String> map, Context context, boolean z) {
        if (context == null) {
            TCLogger.getInstance().logMessage("Trying to save information to the shared preferences with a null context", 6);
            return;
        }
        SharedPreferences.Editor editorEdit = getSharePreferences(z, context).edit();
        for (String str : map.keySet()) {
            editorEdit.putString(str, map.get(str));
        }
        editorEdit.apply();
    }
}
