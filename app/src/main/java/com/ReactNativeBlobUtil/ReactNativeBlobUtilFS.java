package com.ReactNativeBlobUtil;

import android.content.res.AssetFileDescriptor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import androidx.work.Data;
import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes2.dex */
class ReactNativeBlobUtilFS {
    private DeviceEventManagerModule.RCTDeviceEventEmitter emitter;
    private ReactApplicationContext mCtx;

    ReactNativeBlobUtilFS(ReactApplicationContext reactApplicationContext) {
        this.mCtx = reactApplicationContext;
        this.emitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    static void writeFile(String str, String str2, String str3, boolean z, boolean z2, Promise promise) {
        int length;
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!file.exists()) {
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
                    promise.reject("EUNSPECIFIED", "Failed to create parent directory of '" + str + "'");
                    return;
                }
                if (!file.createNewFile()) {
                    promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created");
                    return;
                }
            }
            if (str2.equalsIgnoreCase(ReactNativeBlobUtilConst.DATA_ENCODE_URI)) {
                String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str3);
                File file2 = new File(strNormalizePath);
                if (!file2.exists()) {
                    promise.reject("ENOENT", "No such file '" + str + "' ('" + strNormalizePath + "')");
                    return;
                }
                byte[] bArr = new byte[Data.MAX_DATA_BYTES];
                FileInputStream fileInputStream = null;
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file2);
                    try {
                        fileOutputStream = new FileOutputStream(file, z2);
                        length = 0;
                        while (true) {
                            try {
                                int i = fileInputStream2.read(bArr);
                                if (i <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i);
                                length += i;
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th;
                            }
                        }
                        fileInputStream2.close();
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } else {
                byte[] bArrStringToBytes = ReactNativeBlobUtilUtils.stringToBytes(str3, str2);
                if (z) {
                    ReactNativeBlobUtilFileTransformer.FileTransformer fileTransformer = ReactNativeBlobUtilFileTransformer.sharedFileTransformer;
                    if (fileTransformer == null) {
                        throw new IllegalStateException("Write file with transform was specified but the shared file transformer is not set");
                    }
                    bArrStringToBytes = fileTransformer.onWriteFile(bArrStringToBytes);
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, z2);
                try {
                    fileOutputStream2.write(bArrStringToBytes);
                    length = bArrStringToBytes.length;
                    fileOutputStream2.close();
                } catch (Throwable th4) {
                    fileOutputStream2.close();
                    throw th4;
                }
            }
            promise.resolve(Integer.valueOf(length));
        } catch (FileNotFoundException unused) {
            promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created, or it is a directory");
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void writeFile(String str, ReadableArray readableArray, boolean z, Promise promise) {
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!file.exists()) {
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
                    promise.reject("ENOTDIR", "Failed to create parent directory of '" + str + "'");
                    return;
                }
                if (!file.createNewFile()) {
                    promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created");
                    return;
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, z);
            try {
                byte[] bArr = new byte[readableArray.size()];
                for (int i = 0; i < readableArray.size(); i++) {
                    bArr[i] = (byte) readableArray.getInt(i);
                }
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                promise.resolve(Integer.valueOf(readableArray.size()));
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (FileNotFoundException unused) {
            promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created");
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0038 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:15:0x003a A[Catch: Exception -> 0x0032, FileNotFoundException -> 0x0035, TryCatch #2 {FileNotFoundException -> 0x0035, Exception -> 0x0032, blocks: (B:7:0x000e, B:9:0x0014, B:18:0x0071, B:21:0x0090, B:23:0x0094, B:24:0x0099, B:25:0x00a0, B:26:0x00a1, B:46:0x00e3, B:47:0x00ed, B:48:0x00f6, B:50:0x00fd, B:51:0x0105, B:52:0x0109, B:33:0x00bd, B:36:0x00c7, B:39:0x00d2, B:15:0x003a, B:16:0x0056), top: B:60:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:16:0x0056 A[Catch: Exception -> 0x0032, FileNotFoundException -> 0x0035, TryCatch #2 {FileNotFoundException -> 0x0035, Exception -> 0x0032, blocks: (B:7:0x000e, B:9:0x0014, B:18:0x0071, B:21:0x0090, B:23:0x0094, B:24:0x0099, B:25:0x00a0, B:26:0x00a1, B:46:0x00e3, B:47:0x00ed, B:48:0x00f6, B:50:0x00fd, B:51:0x0105, B:52:0x0109, B:33:0x00bd, B:36:0x00c7, B:39:0x00d2, B:15:0x003a, B:16:0x0056), top: B:60:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00dc  */
    static void readFile(String str, String str2, boolean z, Promise promise) {
        int iAvailable;
        byte[] bArrOnReadFile;
        int i;
        byte b;
        String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        if (strNormalizePath != null) {
            str = strNormalizePath;
        }
        if (strNormalizePath != null) {
            try {
                if (strNormalizePath.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)) {
                    InputStream inputStreamOpen = ReactNativeBlobUtilImpl.RCTContext.getAssets().open(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
                    iAvailable = inputStreamOpen.available();
                    bArrOnReadFile = new byte[iAvailable];
                    i = inputStreamOpen.read(bArrOnReadFile, 0, iAvailable);
                    inputStreamOpen.close();
                } else if (strNormalizePath == null) {
                    InputStream inputStreamOpenInputStream = ReactNativeBlobUtilImpl.RCTContext.getContentResolver().openInputStream(Uri.parse(str));
                    iAvailable = inputStreamOpenInputStream.available();
                    bArrOnReadFile = new byte[iAvailable];
                    i = inputStreamOpenInputStream.read(bArrOnReadFile);
                    inputStreamOpenInputStream.close();
                } else {
                    File file = new File(str);
                    iAvailable = (int) file.length();
                    bArrOnReadFile = new byte[iAvailable];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    int i2 = fileInputStream.read(bArrOnReadFile);
                    fileInputStream.close();
                    i = i2;
                }
            } catch (FileNotFoundException e) {
                String localizedMessage = e.getLocalizedMessage();
                if (localizedMessage.contains("EISDIR")) {
                    promise.reject("EISDIR", "Expecting a file but '" + str + "' is a directory; " + localizedMessage);
                    return;
                }
                promise.reject("ENOENT", "No such file '" + str + "'; " + localizedMessage);
                return;
            } catch (Exception e2) {
                promise.reject("EUNSPECIFIED", e2.getLocalizedMessage());
                return;
            }
        } else if (strNormalizePath == null) {
            InputStream inputStreamOpenInputStream2 = ReactNativeBlobUtilImpl.RCTContext.getContentResolver().openInputStream(Uri.parse(str));
            iAvailable = inputStreamOpenInputStream2.available();
            bArrOnReadFile = new byte[iAvailable];
            i = inputStreamOpenInputStream2.read(bArrOnReadFile);
            inputStreamOpenInputStream2.close();
        } else {
            File file2 = new File(str);
            iAvailable = (int) file2.length();
            bArrOnReadFile = new byte[iAvailable];
            FileInputStream fileInputStream2 = new FileInputStream(file2);
            int i3 = fileInputStream2.read(bArrOnReadFile);
            fileInputStream2.close();
            i = i3;
        }
        if (i < iAvailable) {
            promise.reject("EUNSPECIFIED", "Read only " + i + " bytes of " + iAvailable);
            return;
        }
        if (z) {
            ReactNativeBlobUtilFileTransformer.FileTransformer fileTransformer = ReactNativeBlobUtilFileTransformer.sharedFileTransformer;
            if (fileTransformer == null) {
                throw new IllegalStateException("Read file with transform was specified but the shared file transformer is not set");
            }
            bArrOnReadFile = fileTransformer.onReadFile(bArrOnReadFile);
        }
        String lowerCase = str2.toLowerCase(Locale.ROOT);
        int iHashCode = lowerCase.hashCode();
        if (iHashCode != -1396204209) {
            if (iHashCode != 3600241) {
                if (iHashCode == 93106001 && lowerCase.equals("ascii")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (lowerCase.equals(ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8)) {
                b = 2;
            } else {
                b = -1;
            }
        } else if (lowerCase.equals("base64")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            promise.resolve(Base64.encodeToString(bArrOnReadFile, 2));
            return;
        }
        if (b != 1) {
            if (b == 2) {
                promise.resolve(new String(bArrOnReadFile));
                return;
            } else {
                promise.resolve(new String(bArrOnReadFile));
                return;
            }
        }
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (byte b2 : bArrOnReadFile) {
            writableArrayCreateArray.pushInt(b2);
        }
        promise.resolve(writableArrayCreateArray);
    }

    static Map getSystemfolders(ReactApplicationContext reactApplicationContext) {
        HashMap map = new HashMap();
        map.put("DocumentDir", getFilesDirPath(reactApplicationContext));
        map.put("CacheDir", getCacheDirPath(reactApplicationContext));
        map.put("DCIMDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_DCIM));
        map.put("PictureDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_PICTURES));
        map.put("MusicDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_MUSIC));
        map.put("DownloadDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_DOWNLOADS));
        map.put("MovieDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_MOVIES));
        map.put("RingtoneDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_RINGTONES));
        if (Environment.getExternalStorageState().equals("mounted")) {
            map.put("SDCardDir", getExternalFilesDirPath(reactApplicationContext, null));
            File externalFilesDir = reactApplicationContext.getExternalFilesDir(null);
            if (externalFilesDir != null && externalFilesDir.getParentFile() != null) {
                map.put("SDCardApplicationDir", externalFilesDir.getParentFile().getAbsolutePath());
            } else {
                map.put("SDCardApplicationDir", "");
            }
        } else {
            map.put("SDCardDir", "");
            map.put("SDCardApplicationDir", "");
        }
        map.put("MainBundleDir", reactApplicationContext.getApplicationInfo().dataDir);
        map.put("LibraryDir", "");
        map.put("ApplicationSupportDir", "");
        return map;
    }

    static Map getLegacySystemfolders(ReactApplicationContext reactApplicationContext) {
        HashMap map = new HashMap();
        map.put("LegacyDCIMDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath());
        map.put("LegacyPictureDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());
        map.put("LegacyMusicDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath());
        map.put("LegacyDownloadDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
        map.put("LegacyMovieDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath());
        map.put("LegacyRingtoneDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES).getAbsolutePath());
        if (Environment.getExternalStorageState().equals("mounted")) {
            map.put("LegacySDCardDir", Environment.getExternalStorageDirectory().getAbsolutePath());
        } else {
            map.put("LegacySDCardDir", "");
        }
        return map;
    }

    static String getExternalFilesDirPath(ReactApplicationContext reactApplicationContext, String str) {
        File externalFilesDir = reactApplicationContext.getExternalFilesDir(str);
        if (externalFilesDir != null) {
            return externalFilesDir.getAbsolutePath();
        }
        return "";
    }

    static String getFilesDirPath(ReactApplicationContext reactApplicationContext) {
        File filesDir = reactApplicationContext.getFilesDir();
        if (filesDir != null) {
            return filesDir.getAbsolutePath();
        }
        return "";
    }

    static String getCacheDirPath(ReactApplicationContext reactApplicationContext) {
        File cacheDir = reactApplicationContext.getCacheDir();
        if (cacheDir != null) {
            return cacheDir.getAbsolutePath();
        }
        return "";
    }

    public static void getSDCardDir(ReactApplicationContext reactApplicationContext, Promise promise) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                promise.resolve(reactApplicationContext.getExternalFilesDir(null).getAbsolutePath());
                return;
            } catch (Exception e) {
                promise.reject("ReactNativeBlobUtil.getSDCardDir", e.getLocalizedMessage());
                return;
            }
        }
        promise.reject("ReactNativeBlobUtil.getSDCardDir", "External storage not mounted");
    }

    public static void getSDCardApplicationDir(ReactApplicationContext reactApplicationContext, Promise promise) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                promise.resolve(reactApplicationContext.getExternalFilesDir(null).getParentFile().getAbsolutePath());
                return;
            } catch (Exception e) {
                promise.reject("ReactNativeBlobUtil.getSDCardApplicationDir", e.getLocalizedMessage());
                return;
            }
        }
        promise.reject("ReactNativeBlobUtil.getSDCardApplicationDir", "External storage not mounted");
    }

    static String getTmpPath(String str) {
        return ReactNativeBlobUtilImpl.RCTContext.getFilesDir() + "/ReactNativeBlobUtilTmp_" + str;
    }

    static void unlink(String str, Callback callback) {
        try {
            deleteRecursive(new File(ReactNativeBlobUtilUtils.normalizePath(str)));
            callback.invoke(null, Boolean.TRUE);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage(), Boolean.FALSE);
        }
    }

    private static void deleteRecursive(File file) throws IOException {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new NullPointerException("Received null trying to list files of directory '" + file + "'");
            }
            for (File file2 : fileArrListFiles) {
                deleteRecursive(file2);
            }
        }
        if (file.delete()) {
            return;
        }
        throw new IOException("Failed to delete '" + file + "'");
    }

    static void mkdir(String str, Promise promise) {
        String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        File file = new File(strNormalizePath);
        if (file.exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append(file.isDirectory() ? "Folder" : "File");
            sb.append(" '");
            sb.append(strNormalizePath);
            sb.append("' already exists");
            promise.reject("EEXIST", sb.toString());
            return;
        }
        try {
            if (!file.mkdirs()) {
                promise.reject("EUNSPECIFIED", "mkdir failed to create some or all directories in '" + strNormalizePath + "'");
                return;
            }
            promise.resolve(Boolean.TRUE);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00db A[Catch: Exception -> 0x00d7, TRY_LEAVE, TryCatch #5 {Exception -> 0x00d7, blocks: (B:47:0x00d3, B:51:0x00db), top: B:72:0x00d3 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x010b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x010d A[Catch: Exception -> 0x0109, TRY_LEAVE, TryCatch #4 {Exception -> 0x0109, blocks: (B:60:0x0105, B:64:0x010d), top: B:70:0x0105 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: cp */
    static void m424cp(String str, String str2, Callback callback) {
        FileOutputStream fileOutputStream;
        String str3;
        String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str2);
        InputStream inputStream = null;
        try {
            InputStream inputStreamInputStreamFromPath = inputStreamFromPath(str);
            try {
                if (inputStreamInputStreamFromPath == null) {
                    callback.invoke("Source file at path`" + str + "` does not exist or can not be opened");
                    if (inputStreamInputStreamFromPath != null) {
                        try {
                            inputStreamInputStreamFromPath.close();
                            return;
                        } catch (Exception e) {
                            e.getLocalizedMessage();
                            return;
                        }
                    }
                    return;
                }
                if (!new File(strNormalizePath).exists() && !new File(strNormalizePath).createNewFile()) {
                    callback.invoke("Destination file at '" + strNormalizePath + "' already exists");
                    try {
                        inputStreamInputStreamFromPath.close();
                        return;
                    } catch (Exception e2) {
                        e2.getLocalizedMessage();
                        return;
                    }
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(strNormalizePath);
                try {
                    byte[] bArr = new byte[Data.MAX_DATA_BYTES];
                    while (true) {
                        int i = inputStreamInputStreamFromPath.read(bArr);
                        if (i > 0) {
                            fileOutputStream2.write(bArr, 0, i);
                        } else {
                            try {
                                break;
                            } catch (Exception e3) {
                                str3 = "" + e3.getLocalizedMessage();
                            }
                        }
                    }
                    inputStreamInputStreamFromPath.close();
                    fileOutputStream2.close();
                    str3 = "";
                } catch (Exception e4) {
                    inputStream = inputStreamInputStreamFromPath;
                    fileOutputStream = fileOutputStream2;
                    e = e4;
                    try {
                        str3 = "" + e.getLocalizedMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } catch (Exception e5) {
                                str3 = str3 + e5.getLocalizedMessage();
                            }
                        } else if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } catch (Exception e6) {
                                e6.getLocalizedMessage();
                                throw th;
                            }
                        } else if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    inputStream = inputStreamInputStreamFromPath;
                    fileOutputStream = fileOutputStream2;
                    th = th2;
                    if (inputStream != null) {
                        inputStream.close();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } else if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
                if (str3 != "") {
                    callback.invoke(str3);
                } else {
                    callback.invoke(new Object[0]);
                }
            } catch (Exception e7) {
                e = e7;
                fileOutputStream = null;
                inputStream = inputStreamInputStreamFromPath;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                inputStream = inputStreamInputStreamFromPath;
            }
        } catch (Exception e8) {
            e = e8;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    /* JADX INFO: renamed from: mv */
    static void m427mv(String str, String str2, Callback callback) {
        String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        String strNormalizePath2 = ReactNativeBlobUtilUtils.normalizePath(str2);
        File file = new File(strNormalizePath);
        if (!file.exists()) {
            callback.invoke("Source file at path `" + strNormalizePath + "` does not exist");
            return;
        }
        try {
            File file2 = new File(strNormalizePath2);
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                callback.invoke("mv failed because the destination directory doesn't exist");
                return;
            }
            if (file2.exists()) {
                file2.delete();
            }
            if (!file.renameTo(file2)) {
                callback.invoke("mv failed for unknown reasons");
            } else {
                callback.invoke(new Object[0]);
            }
        } catch (Exception e) {
            callback.invoke(e.toString());
        }
    }

    static void exists(String str, Callback callback) {
        if (isAsset(str)) {
            try {
                ReactNativeBlobUtilImpl.RCTContext.getAssets().openFd(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
                callback.invoke(Boolean.TRUE, Boolean.FALSE);
                return;
            } catch (IOException unused) {
                Boolean bool = Boolean.FALSE;
                callback.invoke(bool, bool);
                return;
            }
        }
        String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        if (strNormalizePath != null) {
            callback.invoke(Boolean.valueOf(new File(strNormalizePath).exists()), Boolean.valueOf(new File(strNormalizePath).isDirectory()));
        } else {
            Boolean bool2 = Boolean.FALSE;
            callback.invoke(bool2, bool2);
        }
    }

    /* JADX INFO: renamed from: ls */
    static void m426ls(String str, Promise promise) {
        try {
            String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            File file = new File(strNormalizePath);
            if (!file.exists()) {
                promise.reject("ENOENT", "No such file '" + strNormalizePath + "'");
                return;
            }
            if (!file.isDirectory()) {
                promise.reject("ENOTDIR", "Not a directory '" + strNormalizePath + "'");
                return;
            }
            String[] list = new File(strNormalizePath).list();
            WritableArray writableArrayCreateArray = Arguments.createArray();
            for (String str2 : list) {
                writableArrayCreateArray.pushString(str2);
            }
            promise.resolve(writableArrayCreateArray);
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void slice(String str, String str2, long j, long j2, String str3, Promise promise) {
        try {
            String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str2);
            if (!str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_CONTENT) && new File(ReactNativeBlobUtilUtils.normalizePath(str)).isDirectory()) {
                promise.reject("EISDIR", "Expecting a file but '" + str + "' is a directory");
                return;
            }
            InputStream inputStreamInputStreamFromPath = inputStreamFromPath(str);
            if (inputStreamInputStreamFromPath == null) {
                promise.reject("ENOENT", "No such file '" + str + "'");
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(strNormalizePath));
            long jSkip = inputStreamInputStreamFromPath.skip(j);
            if (jSkip != j) {
                promise.reject("EUNSPECIFIED", "Skipped " + jSkip + " instead of the specified " + j + " bytes");
                return;
            }
            byte[] bArr = new byte[Data.MAX_DATA_BYTES];
            int i = (int) (j2 - j);
            while (i > 0) {
                int i2 = inputStreamInputStreamFromPath.read(bArr, 0, Data.MAX_DATA_BYTES);
                if (i2 <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, Math.min(i, i2));
                i -= i2;
            }
            inputStreamInputStreamFromPath.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            promise.resolve(strNormalizePath);
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void lstat(String str, final Callback callback) {
        new AsyncTask() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Integer doInBackground(String... strArr) {
                WritableArray writableArrayCreateArray = Arguments.createArray();
                if (strArr[0] == null) {
                    callback.invoke("the path specified for lstat is either `null` or `undefined`.");
                    return 0;
                }
                File file = new File(strArr[0]);
                if (!file.exists()) {
                    callback.invoke("failed to lstat path `" + strArr[0] + "` because it does not exist or it is not a folder");
                    return 0;
                }
                if (file.isDirectory()) {
                    for (String str2 : file.list()) {
                        writableArrayCreateArray.pushMap(ReactNativeBlobUtilFS.statFile(file.getPath() + "/" + str2));
                    }
                } else {
                    writableArrayCreateArray.pushMap(ReactNativeBlobUtilFS.statFile(file.getAbsolutePath()));
                }
                callback.invoke(null, writableArrayCreateArray);
                return 0;
            }
        }.execute(ReactNativeBlobUtilUtils.normalizePath(str));
    }

    static void stat(String str, Callback callback) {
        try {
            String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            WritableMap writableMapStatFile = statFile(strNormalizePath);
            if (writableMapStatFile == null) {
                callback.invoke("failed to stat path `" + strNormalizePath + "` because it does not exist or it is not a folder", null);
            } else {
                callback.invoke(null, writableMapStatFile);
            }
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static WritableMap statFile(String str) {
        try {
            String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            WritableMap writableMapCreateMap = Arguments.createMap();
            if (isAsset(strNormalizePath)) {
                String strReplace = strNormalizePath.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "");
                AssetFileDescriptor assetFileDescriptorOpenFd = ReactNativeBlobUtilImpl.RCTContext.getAssets().openFd(strReplace);
                writableMapCreateMap.putString("filename", strReplace);
                writableMapCreateMap.putString("path", strNormalizePath);
                writableMapCreateMap.putString("type", UriUtil.LOCAL_ASSET_SCHEME);
                writableMapCreateMap.putString(TCEventPropertiesNames.TCP_SIZE, String.valueOf(assetFileDescriptorOpenFd.getLength()));
                writableMapCreateMap.putInt("lastModified", 0);
            } else {
                File file = new File(strNormalizePath);
                if (!file.exists()) {
                    return null;
                }
                writableMapCreateMap.putString("filename", file.getName());
                writableMapCreateMap.putString("path", file.getPath());
                writableMapCreateMap.putString("type", file.isDirectory() ? "directory" : "file");
                writableMapCreateMap.putString(TCEventPropertiesNames.TCP_SIZE, String.valueOf(file.length()));
                writableMapCreateMap.putString("lastModified", String.valueOf(file.lastModified()));
            }
            return writableMapCreateMap;
        } catch (Exception unused) {
            return null;
        }
    }

    void scanFile(String[] strArr, String[] strArr2, final Callback callback) {
        try {
            MediaScannerConnection.scanFile(this.mCtx, strArr, strArr2, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.2
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str, Uri uri) {
                    callback.invoke(null, Boolean.TRUE);
                }
            });
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage(), null);
        }
    }

    static void hash(String str, String str2, Promise promise) {
        int i;
        try {
            HashMap map = new HashMap();
            map.put("md5", MessageDigestAlgorithms.MD5);
            map.put("sha1", "SHA-1");
            map.put("sha224", "SHA-224");
            map.put("sha256", "SHA-256");
            map.put("sha384", "SHA-384");
            map.put("sha512", "SHA-512");
            if (!map.containsKey(str2)) {
                promise.reject("EINVAL", "Invalid algorithm '" + str2 + "', must be one of md5, sha1, sha224, sha256, sha384, sha512");
                return;
            }
            if (!str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_CONTENT) && new File(ReactNativeBlobUtilUtils.normalizePath(str)).isDirectory()) {
                promise.reject("EISDIR", "Expecting a file but '" + str + "' is a directory");
                return;
            }
            MessageDigest messageDigest = MessageDigest.getInstance((String) map.get(str2));
            InputStream inputStreamInputStreamFromPath = inputStreamFromPath(str);
            if (inputStreamInputStreamFromPath == null) {
                promise.reject("ENOENT", "No such file '" + str + "'");
                return;
            }
            byte[] bArr = new byte[1048576];
            while (true) {
                int i2 = inputStreamInputStreamFromPath.read(bArr);
                if (i2 == -1) {
                    break;
                } else {
                    messageDigest.update(bArr, 0, i2);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest.digest()) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            promise.resolve(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void createFile(String str, String str2, String str3, Promise promise) {
        try {
            String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            File file = new File(strNormalizePath);
            boolean zCreateNewFile = file.createNewFile();
            if (str3.equals(ReactNativeBlobUtilConst.DATA_ENCODE_URI)) {
                File file2 = new File(str2.replace(ReactNativeBlobUtilConst.FILE_PREFIX, ""));
                if (!file2.exists()) {
                    promise.reject("ENOENT", "Source file : " + str2 + " does not exist");
                    return;
                }
                FileInputStream fileInputStream = new FileInputStream(file2);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[Data.MAX_DATA_BYTES];
                for (int i = fileInputStream.read(bArr); i > 0; i = fileInputStream.read(bArr)) {
                    fileOutputStream.write(bArr, 0, i);
                }
                fileInputStream.close();
                fileOutputStream.close();
            } else {
                if (!zCreateNewFile) {
                    promise.reject("EEXIST", "File `" + strNormalizePath + "` already exists");
                    return;
                }
                new FileOutputStream(file).write(ReactNativeBlobUtilUtils.stringToBytes(str2, str3));
            }
            promise.resolve(strNormalizePath);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void createFileASCII(String str, ReadableArray readableArray, Promise promise) {
        try {
            String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            File file = new File(strNormalizePath);
            if (!file.createNewFile()) {
                promise.reject("EEXIST", "File at path `" + strNormalizePath + "` already exists");
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            fileOutputStream.write(bArr);
            promise.resolve(strNormalizePath);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    /* JADX INFO: renamed from: df */
    static void m425df(Callback callback, ReactApplicationContext reactApplicationContext) {
        StatFs statFs = new StatFs(reactApplicationContext.getFilesDir().getPath());
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("internal_free", String.valueOf(statFs.getFreeBytes()));
        writableMapCreateMap.putString("internal_total", String.valueOf(statFs.getTotalBytes()));
        File externalFilesDir = reactApplicationContext.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            StatFs statFs2 = new StatFs(externalFilesDir.getPath());
            writableMapCreateMap.putString("external_free", String.valueOf(statFs2.getFreeBytes()));
            writableMapCreateMap.putString("external_total", String.valueOf(statFs2.getTotalBytes()));
        } else {
            writableMapCreateMap.putString("external_free", "-1");
            writableMapCreateMap.putString("external_total", "-1");
        }
        callback.invoke(null, writableMapCreateMap);
    }

    static void removeSession(ReadableArray readableArray, final Callback callback) {
        new AsyncTask() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Integer doInBackground(ReadableArray... readableArrayArr) {
                try {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < readableArrayArr[0].size(); i++) {
                        String string = readableArrayArr[0].getString(i);
                        File file = new File(string);
                        if (file.exists() && !file.delete()) {
                            arrayList.add(string);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        callback.invoke(null, Boolean.TRUE);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to delete: ");
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            sb.append((String) it.next());
                            sb.append(", ");
                        }
                        callback.invoke(sb.toString());
                    }
                } catch (Exception e) {
                    callback.invoke(e.getLocalizedMessage());
                }
                return Integer.valueOf(readableArrayArr[0].size());
            }
        }.execute(readableArray);
    }

    private static InputStream inputStreamFromPath(String str) {
        if (str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)) {
            return ReactNativeBlobUtilImpl.RCTContext.getAssets().open(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
        }
        if (str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_CONTENT)) {
            return ReactNativeBlobUtilImpl.RCTContext.getContentResolver().openInputStream(Uri.parse(str));
        }
        return new FileInputStream(new File(ReactNativeBlobUtilUtils.normalizePath(str)));
    }

    static boolean isAsset(String str) {
        return str != null && str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET);
    }
}
