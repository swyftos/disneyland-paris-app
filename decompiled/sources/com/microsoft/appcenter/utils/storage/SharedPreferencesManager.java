package com.microsoft.appcenter.utils.storage;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Set;

/* loaded from: classes4.dex */
public class SharedPreferencesManager {
    private static Context sContext;
    private static SharedPreferences sSharedPreferences;

    public static synchronized void initialize(Context context) {
        if (sContext == null) {
            sContext = context;
            sSharedPreferences = context.getSharedPreferences("AppCenter", 0);
        }
    }

    public static boolean getBoolean(@NonNull String str) {
        return getBoolean(str, false);
    }

    public static boolean getBoolean(@NonNull String str, boolean z) {
        return sSharedPreferences.getBoolean(str, z);
    }

    public static void putBoolean(@NonNull String str, boolean z) {
        SharedPreferences.Editor editorEdit = sSharedPreferences.edit();
        editorEdit.putBoolean(str, z);
        editorEdit.apply();
    }

    public static float getFloat(@NonNull String str) {
        return getFloat(str, BitmapDescriptorFactory.HUE_RED);
    }

    public static float getFloat(@NonNull String str, float f) {
        return sSharedPreferences.getFloat(str, f);
    }

    public static void putFloat(@NonNull String str, float f) {
        SharedPreferences.Editor editorEdit = sSharedPreferences.edit();
        editorEdit.putFloat(str, f);
        editorEdit.apply();
    }

    public static int getInt(@NonNull String str) {
        return getInt(str, 0);
    }

    public static int getInt(@NonNull String str, int i) {
        return sSharedPreferences.getInt(str, i);
    }

    public static void putInt(@NonNull String str, int i) {
        SharedPreferences.Editor editorEdit = sSharedPreferences.edit();
        editorEdit.putInt(str, i);
        editorEdit.apply();
    }

    public static long getLong(@NonNull String str) {
        return getLong(str, 0L);
    }

    public static long getLong(@NonNull String str, long j) {
        return sSharedPreferences.getLong(str, j);
    }

    public static void putLong(@NonNull String str, long j) {
        SharedPreferences.Editor editorEdit = sSharedPreferences.edit();
        editorEdit.putLong(str, j);
        editorEdit.apply();
    }

    @Nullable
    public static String getString(@NonNull String str) {
        return getString(str, null);
    }

    public static String getString(@NonNull String str, String str2) {
        return sSharedPreferences.getString(str, str2);
    }

    public static void putString(@NonNull String str, String str2) {
        SharedPreferences.Editor editorEdit = sSharedPreferences.edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public static Set<String> getStringSet(@NonNull String str) {
        return getStringSet(str, null);
    }

    public static Set<String> getStringSet(@NonNull String str, Set<String> set) {
        return sSharedPreferences.getStringSet(str, set);
    }

    public static void putStringSet(@NonNull String str, Set<String> set) {
        SharedPreferences.Editor editorEdit = sSharedPreferences.edit();
        editorEdit.putStringSet(str, set);
        editorEdit.apply();
    }

    public static void remove(@NonNull String str) {
        SharedPreferences.Editor editorEdit = sSharedPreferences.edit();
        editorEdit.remove(str);
        editorEdit.apply();
    }

    public static void clear() {
        SharedPreferences.Editor editorEdit = sSharedPreferences.edit();
        editorEdit.clear();
        editorEdit.apply();
    }
}
