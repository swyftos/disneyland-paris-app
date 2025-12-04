package androidx.test.rule.provider;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import androidx.test.internal.util.Checks;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
class DelegatingContext extends ContextWrapper {
    private final ContentResolver contentResolver;
    private final Context context;
    private Set databases;
    private Set files;
    private final String prefix;
    private Set revokedPermissions;

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return this;
    }

    public DelegatingContext(Context context, String str, ContentResolver contentResolver) {
        super((Context) Checks.checkNotNull(context));
        this.databases = new HashSet();
        this.files = new HashSet();
        this.revokedPermissions = new HashSet();
        this.context = context;
        this.prefix = (String) Checks.checkNotNull(str);
        this.contentResolver = (ContentResolver) Checks.checkNotNull(contentResolver);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ContentResolver getContentResolver() {
        return this.contentResolver;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i) {
        Checks.checkArgument(!TextUtils.isEmpty(str), "Directory name cannot be empty or null");
        return this.context.getDir(getPrefixName(str), i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        Checks.checkArgument(!TextUtils.isEmpty(str), "Database name cannot be empty or null");
        if (!this.databases.contains(str)) {
            addDatabase(str);
            String prefixName = getPrefixName(str);
            if (this.context.getDatabasePath(prefixName).exists() && !this.context.deleteDatabase(prefixName)) {
                StringBuilder sb = new StringBuilder(String.valueOf(prefixName).length() + 65);
                sb.append("Database with prefixed name ");
                sb.append(prefixName);
                sb.append(" already exists but failed to delete.");
                Log.w("DelegatingContext", sb.toString());
            }
        }
        return this.context.openOrCreateDatabase(getPrefixName(str), i, cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        Checks.checkArgument(!TextUtils.isEmpty(str), "Database name cannot be empty or null");
        String prefixName = getPrefixName(str);
        if (!this.databases.contains(str)) {
            addDatabase(str);
            if (this.context.getDatabasePath(prefixName).exists() && !this.context.deleteDatabase(prefixName)) {
                StringBuilder sb = new StringBuilder(String.valueOf(prefixName).length() + 66);
                sb.append("Database with prefixed name ");
                sb.append(prefixName);
                sb.append(" already exists and cannot be deleted.");
                Log.w("DelegatingContext", sb.toString());
            }
        }
        return this.context.openOrCreateDatabase(prefixName, i, cursorFactory, databaseErrorHandler);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        Set set = this.databases;
        return (String[]) set.toArray(new String[set.size()]);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String str) {
        Checks.checkArgument(!TextUtils.isEmpty(str), "Database name cannot be empty or null");
        if (!this.databases.contains(str) || !this.context.deleteDatabase(getPrefixName(str))) {
            return false;
        }
        this.databases.remove(str);
        return true;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        Checks.checkArgument(!TextUtils.isEmpty(str), "Database name cannot be empty or null");
        return this.context.getDatabasePath(getPrefixName(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        Checks.checkArgument(!TextUtils.isEmpty(str), "File name cannot be empty or null");
        if (!this.files.contains(str)) {
            throw new FileNotFoundException(String.format("File %s is not found in current context", str));
        }
        return this.context.openFileInput(getPrefixName(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i) throws FileNotFoundException {
        Checks.checkArgument(!TextUtils.isEmpty(str), "File name cannot be empty or null");
        FileOutputStream fileOutputStreamOpenFileOutput = this.context.openFileOutput(getPrefixName(str), i);
        if (fileOutputStreamOpenFileOutput != null) {
            this.files.add(str);
        }
        return fileOutputStreamOpenFileOutput;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] fileList() {
        Set set = this.files;
        return (String[]) set.toArray(new String[set.size()]);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFileStreamPath(String str) {
        Checks.checkArgument(!TextUtils.isEmpty(str), "File name cannot be empty or null");
        return this.context.getFileStreamPath(getPrefixName(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        Checks.checkArgument(!TextUtils.isEmpty(str), "File name cannot be empty or null");
        if (!this.files.contains(str) || !this.context.deleteFile(getPrefixName(str))) {
            return false;
        }
        this.files.remove(str);
        return true;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        Checks.checkArgument(!TextUtils.isEmpty(str), "name cannot be empty or null");
        if ("appops".equals(str)) {
            return this.context.getSystemService("appops");
        }
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkPermission(String str, int i, int i2) {
        Checks.checkArgument(!TextUtils.isEmpty(str), "permission cannot be null or empty");
        return this.revokedPermissions.contains(str) ? -1 : 0;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkCallingPermission(String str) {
        return checkPermission(str, -1, -1);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkCallingOrSelfPermission(String str) {
        return checkPermission(str, -1, -1);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkSelfPermission(String str) {
        return checkPermission(str, -1, -1);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforcePermission(String str, int i, int i2, String str2) {
        if (checkPermission(str, i, i2) != 0) {
            String strConcat = str2 != null ? str2.concat(": ") : "";
            StringBuilder sb = new StringBuilder(String.valueOf(strConcat).length() + 14 + String.valueOf(str).length());
            sb.append(strConcat);
            sb.append("No permission ");
            sb.append(str);
            throw new SecurityException(sb.toString());
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceCallingPermission(String str, String str2) {
        enforcePermission(str, -1, -1, str2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceCallingOrSelfPermission(String str, String str2) {
        enforcePermission(str, -1, -1, str2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkUriPermission(Uri uri, int i, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkCallingUriPermission(Uri uri, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkCallingOrSelfUriPermission(Uri uri, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkUriPermission(Uri uri, String str, String str2, int i, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceUriPermission(Uri uri, int i, int i2, int i3, String str) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceCallingUriPermission(Uri uri, int i, String str) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceCallingOrSelfUriPermission(Uri uri, int i, String str) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceUriPermission(Uri uri, String str, String str2, int i, int i2, int i3, String str3) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getNoBackupFilesDir() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCodeCacheDir() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalMediaDirs() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Looper getMainLooper() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageResourcePath() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageCodePath() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str2, Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str2, Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcastAsUser(Intent intent, UserHandle userHandle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcastAsUser(Intent intent, UserHandle userHandle, String str) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyBroadcast(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str, Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str, Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void removeStickyBroadcast(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void removeStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void grantUriPermission(String str, Uri uri, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void revokeUriPermission(Uri uri, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Drawable getWallpaper() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Drawable peekWallpaper() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumHeight() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumWidth() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setWallpaper(Bitmap bitmap) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setWallpaper(InputStream inputStream) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void clearWallpaper() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3, Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean startInstrumentation(ComponentName componentName, String str, Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getSystemServiceName(Class cls) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createPackageContext(String str, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createConfigurationContext(Configuration configuration) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createDisplayContext(Display display) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean isRestricted() {
        throw new UnsupportedOperationException();
    }

    boolean addDatabase(String str) {
        Checks.checkArgument(!TextUtils.isEmpty(str), "Database name cannot be empty or null");
        return this.databases.add(str);
    }

    void addRevokedPermission(String str) {
        Checks.checkArgument(!TextUtils.isEmpty(str), "permission cannot be null or empty");
        this.revokedPermissions.add(str);
    }

    private String getPrefixName(String str) {
        Checks.checkArgument(!TextUtils.isEmpty(str), "Name cannot be empty or null");
        String strValueOf = String.valueOf(this.prefix);
        String strValueOf2 = String.valueOf(str);
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }
}
