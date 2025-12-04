package ch.qos.logback.core.android;

import android.annotation.TargetApi;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.Environment;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.CoreConstants;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/* loaded from: classes2.dex */
public class AndroidContextUtil {
    private ContextWrapper context;

    public AndroidContextUtil() {
        this(getContext());
    }

    public AndroidContextUtil(ContextWrapper contextWrapper) {
        this.context = contextWrapper;
    }

    private String absPath(File file) {
        return file != null ? file.getAbsolutePath() : "";
    }

    private static ContextWrapper getContext() throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.app.AppGlobals");
            return (ContextWrapper) cls.getDeclaredMethod("getInitialApplication", new Class[0]).invoke(cls, new Object[0]);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public String getCacheDirectoryPath() {
        ContextWrapper contextWrapper = this.context;
        return contextWrapper != null ? absPath(contextWrapper.getCacheDir()) : "";
    }

    public String getDatabaseDirectoryPath() {
        ContextWrapper contextWrapper = this.context;
        return (contextWrapper == null || contextWrapper.getDatabasePath("x") == null) ? "" : this.context.getDatabasePath("x").getParent();
    }

    public String getDatabasePath(String str) {
        ContextWrapper contextWrapper = this.context;
        return contextWrapper != null ? absPath(contextWrapper.getDatabasePath(str)) : "";
    }

    public String getExternalCacheDirectoryPath() {
        ContextWrapper contextWrapper = this.context;
        return contextWrapper != null ? absPath(contextWrapper.getExternalCacheDir()) : "";
    }

    public String getExternalFilesDirectoryPath() {
        ContextWrapper contextWrapper = this.context;
        return contextWrapper != null ? absPath(contextWrapper.getExternalFilesDir(null)) : "";
    }

    public String getExternalStorageDirectoryPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public String getFilesDirectoryPath() {
        ContextWrapper contextWrapper = this.context;
        return contextWrapper != null ? absPath(contextWrapper.getFilesDir()) : "";
    }

    public String getMountedExternalStorageDirectoryPath() {
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals("mounted") || externalStorageState.equals("mounted_ro")) {
            return absPath(Environment.getExternalStorageDirectory());
        }
        return null;
    }

    @TargetApi(21)
    public String getNoBackupFilesDirectoryPath() {
        ContextWrapper contextWrapper = this.context;
        return contextWrapper != null ? absPath(contextWrapper.getNoBackupFilesDir()) : "";
    }

    public String getPackageName() {
        ContextWrapper contextWrapper = this.context;
        return contextWrapper != null ? contextWrapper.getPackageName() : "";
    }

    public String getVersionCode() throws PackageManager.NameNotFoundException {
        ContextWrapper contextWrapper = this.context;
        if (contextWrapper == null) {
            return "";
        }
        try {
            return "" + contextWrapper.getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public String getVersionName() {
        String str;
        ContextWrapper contextWrapper = this.context;
        if (contextWrapper != null) {
            try {
                str = contextWrapper.getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } else {
            str = "";
        }
        return str != null ? str : "";
    }

    public void setupProperties(LoggerContext loggerContext) {
        Properties properties = new Properties();
        properties.setProperty(CoreConstants.DATA_DIR_KEY, getFilesDirectoryPath());
        String mountedExternalStorageDirectoryPath = getMountedExternalStorageDirectoryPath();
        if (mountedExternalStorageDirectoryPath != null) {
            properties.setProperty(CoreConstants.EXT_DIR_KEY, mountedExternalStorageDirectoryPath);
        }
        properties.setProperty(CoreConstants.PACKAGE_NAME_KEY, getPackageName());
        properties.setProperty(CoreConstants.VERSION_CODE_KEY, getVersionCode());
        properties.setProperty(CoreConstants.VERSION_NAME_KEY, getVersionName());
        loggerContext.putProperties(properties);
    }
}
