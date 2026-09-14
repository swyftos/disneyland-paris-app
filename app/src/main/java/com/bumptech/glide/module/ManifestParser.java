package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class ManifestParser {
    private final Context context;

    public ManifestParser(Context context) {
        this.context = context;
    }

    private ApplicationInfo getOurApplicationInfo() {
        return this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
    }

    public List<GlideModule> parse() {
        if (Log.isLoggable("ManifestParser", 3)) {
            Log.d("ManifestParser", "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo ourApplicationInfo = getOurApplicationInfo();
            if (ourApplicationInfo != null && ourApplicationInfo.metaData != null) {
                if (Log.isLoggable("ManifestParser", 2)) {
                    Log.v("ManifestParser", "Got app info metadata: " + ourApplicationInfo.metaData);
                }
                for (String str : ourApplicationInfo.metaData.keySet()) {
                    if ("GlideModule".equals(ourApplicationInfo.metaData.get(str))) {
                        arrayList.add(parseModule(str));
                        if (Log.isLoggable("ManifestParser", 3)) {
                            Log.d("ManifestParser", "Loaded Glide module: " + str);
                        }
                    }
                }
                if (Log.isLoggable("ManifestParser", 3)) {
                    Log.d("ManifestParser", "Finished loading Glide modules");
                }
                return arrayList;
            }
            if (Log.isLoggable("ManifestParser", 3)) {
                Log.d("ManifestParser", "Got null app info metadata");
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            if (Log.isLoggable("ManifestParser", 6)) {
                Log.e("ManifestParser", "Failed to parse glide modules", e);
            }
        }
    }

    private static GlideModule parseModule(String str) {
        Object objNewInstance;
        try {
            Class<?> cls = Class.forName(str);
            try {
                objNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (IllegalAccessException e) {
                throwInstantiateGlideModuleException(cls, e);
                objNewInstance = null;
            } catch (InstantiationException e2) {
                throwInstantiateGlideModuleException(cls, e2);
                objNewInstance = null;
            } catch (NoSuchMethodException e3) {
                throwInstantiateGlideModuleException(cls, e3);
                objNewInstance = null;
            } catch (InvocationTargetException e4) {
                throwInstantiateGlideModuleException(cls, e4);
                objNewInstance = null;
            }
            if (!(objNewInstance instanceof GlideModule)) {
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + objNewInstance);
            }
            return (GlideModule) objNewInstance;
        } catch (ClassNotFoundException e5) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e5);
        }
    }

    private static void throwInstantiateGlideModuleException(Class cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }
}
