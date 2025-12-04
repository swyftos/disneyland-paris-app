package com.microsoft.appcenter.crashes.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.microsoft.appcenter.Constants;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.appcenter.crashes.ingestion.models.Exception;
import com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog;
import com.microsoft.appcenter.crashes.ingestion.models.StackFrame;
import com.microsoft.appcenter.crashes.ingestion.models.Thread;
import com.microsoft.appcenter.crashes.model.ErrorReport;
import com.microsoft.appcenter.ingestion.models.Device;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.DeviceInfoHelper;
import com.microsoft.appcenter.utils.context.UserIdContext;
import com.microsoft.appcenter.utils.storage.FileManager;
import com.tagcommander.lib.serverside.ETCPurchaseStatus;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes4.dex */
public class ErrorLogHelper {
    public static final String DEVICE_INFO_FILE = "deviceInfo";
    public static final String ERROR_LOG_FILE_EXTENSION = ".json";

    @VisibleForTesting
    public static final int FRAME_LIMIT = 256;
    public static final int MAX_PROPERTY_ITEM_LENGTH = 125;
    public static final String MINIDUMP_FILE_EXTENSION = ".dmp";
    public static final String THROWABLE_FILE_EXTENSION = ".throwable";
    private static File sErrorLogDirectory;
    private static File sNewMinidumpDirectory;
    private static File sPendingMinidumpDirectory;

    @NonNull
    public static ManagedErrorLog createErrorLog(@NonNull Context context, @NonNull Thread thread, @NonNull Throwable th, @NonNull Map<Thread, StackTraceElement[]> map, long j) {
        return createErrorLog(context, thread, getModelExceptionFromThrowable(th), map, j, true);
    }

    @NonNull
    public static ManagedErrorLog createErrorLog(@NonNull Context context, @NonNull Thread thread, @NonNull Exception exception, @NonNull Map<Thread, StackTraceElement[]> map, long j, boolean z) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ManagedErrorLog managedErrorLog = new ManagedErrorLog();
        managedErrorLog.setId(UUID.randomUUID());
        managedErrorLog.setTimestamp(new Date());
        managedErrorLog.setUserId(UserIdContext.getInstance().getUserId());
        try {
            managedErrorLog.setDevice(DeviceInfoHelper.getDeviceInfo(context));
        } catch (DeviceInfoHelper.DeviceInfoException e) {
            AppCenterLog.error(Crashes.LOG_TAG, "Could not attach device properties snapshot to error log, will attach at sending time", e);
        }
        managedErrorLog.setProcessId(Integer.valueOf(Process.myPid()));
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == Process.myPid()) {
                    managedErrorLog.setProcessName(runningAppProcessInfo.processName);
                }
            }
        }
        if (managedErrorLog.getProcessName() == null) {
            managedErrorLog.setProcessName("");
        }
        managedErrorLog.setArchitecture(getArchitecture());
        managedErrorLog.setErrorThreadId(Long.valueOf(thread.getId()));
        managedErrorLog.setErrorThreadName(thread.getName());
        managedErrorLog.setFatal(Boolean.valueOf(z));
        managedErrorLog.setAppLaunchTimestamp(new Date(j));
        managedErrorLog.setException(exception);
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<Thread, StackTraceElement[]> entry : map.entrySet()) {
            Thread thread2 = new Thread();
            thread2.setId(entry.getKey().getId());
            thread2.setName(entry.getKey().getName());
            thread2.setFrames(getModelFramesFromStackTrace(entry.getValue()));
            arrayList.add(thread2);
        }
        managedErrorLog.setThreads(arrayList);
        return managedErrorLog;
    }

    private static String getArchitecture() {
        return Build.SUPPORTED_ABIS[0];
    }

    @NonNull
    public static synchronized File getErrorStorageDirectory() {
        try {
            if (sErrorLogDirectory == null) {
                File file = new File(Constants.FILES_PATH, com.google.firebase.messaging.Constants.IPC_BUNDLE_KEY_SEND_ERROR);
                sErrorLogDirectory = file;
                FileManager.mkdir(file.getAbsolutePath());
            }
        } catch (Throwable th) {
            throw th;
        }
        return sErrorLogDirectory;
    }

    @NonNull
    public static synchronized File getNewMinidumpDirectory() {
        return new File(new File(getErrorStorageDirectory().getAbsolutePath(), "minidump"), "new");
    }

    @NonNull
    public static synchronized File getNewMinidumpSubfolder() {
        try {
            if (sNewMinidumpDirectory == null) {
                File file = new File(getNewMinidumpDirectory(), UUID.randomUUID().toString());
                sNewMinidumpDirectory = file;
                FileManager.mkdir(file.getPath());
            }
        } catch (Throwable th) {
            throw th;
        }
        return sNewMinidumpDirectory;
    }

    @NonNull
    public static synchronized File getNewMinidumpSubfolderWithContextData(Context context) {
        File newMinidumpSubfolder;
        newMinidumpSubfolder = getNewMinidumpSubfolder();
        File file = new File(newMinidumpSubfolder, DEVICE_INFO_FILE);
        try {
            Device deviceInfo = DeviceInfoHelper.getDeviceInfo(context);
            deviceInfo.setWrapperSdkName(Constants.WRAPPER_SDK_NAME_NDK);
            JSONStringer jSONStringer = new JSONStringer();
            jSONStringer.object();
            deviceInfo.write(jSONStringer);
            jSONStringer.endObject();
            FileManager.write(file, jSONStringer.toString());
        } catch (DeviceInfoHelper.DeviceInfoException | IOException | JSONException e) {
            AppCenterLog.error(Crashes.LOG_TAG, "Failed to store device info in a minidump folder.", e);
            file.delete();
        }
        return newMinidumpSubfolder;
    }

    @NonNull
    public static synchronized File getPendingMinidumpDirectory() {
        try {
            if (sPendingMinidumpDirectory == null) {
                File file = new File(new File(getErrorStorageDirectory().getAbsolutePath(), "minidump"), ETCPurchaseStatus.PENDING);
                sPendingMinidumpDirectory = file;
                FileManager.mkdir(file.getPath());
            }
        } catch (Throwable th) {
            throw th;
        }
        return sPendingMinidumpDirectory;
    }

    @NonNull
    public static File[] getStoredErrorLogFiles() {
        File[] fileArrListFiles = getErrorStorageDirectory().listFiles(new FilenameFilter() { // from class: com.microsoft.appcenter.crashes.utils.ErrorLogHelper.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.endsWith(".json");
            }
        });
        return fileArrListFiles != null ? fileArrListFiles : new File[0];
    }

    @NonNull
    public static File[] getNewMinidumpFiles() {
        File[] fileArrListFiles = getNewMinidumpDirectory().listFiles();
        return fileArrListFiles != null ? fileArrListFiles : new File[0];
    }

    @Nullable
    public static Device getStoredDeviceInfo(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: com.microsoft.appcenter.crashes.utils.ErrorLogHelper.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return str.equals(ErrorLogHelper.DEVICE_INFO_FILE);
            }
        });
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            AppCenterLog.warn(Crashes.LOG_TAG, "No stored deviceinfo file found in a minidump folder.");
            return null;
        }
        String str = FileManager.read(fileArrListFiles[0]);
        if (str == null) {
            AppCenterLog.error(Crashes.LOG_TAG, "Failed to read stored device info.");
            return null;
        }
        return parseDevice(str);
    }

    static Device parseDevice(String str) {
        try {
            Device device = new Device();
            device.read(new JSONObject(str));
            return device;
        } catch (JSONException e) {
            AppCenterLog.error(Crashes.LOG_TAG, "Failed to deserialize device info.", e);
            return null;
        }
    }

    public static void removeStaleMinidumpSubfolders() {
        File[] fileArrListFiles = getNewMinidumpDirectory().listFiles(new FilenameFilter() { // from class: com.microsoft.appcenter.crashes.utils.ErrorLogHelper.3
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                if (ErrorLogHelper.sNewMinidumpDirectory != null) {
                    return !str.equals(ErrorLogHelper.sNewMinidumpDirectory.getName());
                }
                return true;
            }
        });
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            AppCenterLog.debug(Crashes.LOG_TAG, "No previous minidump sub-folders.");
            return;
        }
        for (File file : fileArrListFiles) {
            FileManager.deleteDirectory(file);
        }
    }

    public static void removeMinidumpFolder() {
        FileManager.deleteDirectory(new File(getErrorStorageDirectory().getAbsolutePath(), "minidump"));
    }

    @Nullable
    public static File getLastErrorLogFile() {
        return FileManager.lastModifiedFile(getErrorStorageDirectory(), new FilenameFilter() { // from class: com.microsoft.appcenter.crashes.utils.ErrorLogHelper.4
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.endsWith(".json");
            }
        });
    }

    @Nullable
    public static File getStoredThrowableFile(@NonNull UUID uuid) {
        return getStoredFile(uuid, THROWABLE_FILE_EXTENSION);
    }

    public static void removeStoredThrowableFile(@NonNull UUID uuid) {
        File storedThrowableFile = getStoredThrowableFile(uuid);
        if (storedThrowableFile != null) {
            AppCenterLog.info(Crashes.LOG_TAG, "Deleting throwable file " + storedThrowableFile.getName());
            FileManager.delete(storedThrowableFile);
        }
    }

    static File getStoredErrorLogFile(UUID uuid) {
        return getStoredFile(uuid, ".json");
    }

    public static void removeStoredErrorLogFile(@NonNull UUID uuid) {
        File storedErrorLogFile = getStoredErrorLogFile(uuid);
        if (storedErrorLogFile != null) {
            AppCenterLog.info(Crashes.LOG_TAG, "Deleting error log file " + storedErrorLogFile.getName());
            FileManager.delete(storedErrorLogFile);
        }
    }

    @NonNull
    public static ErrorReport getErrorReportFromErrorLog(@NonNull ManagedErrorLog managedErrorLog, String str) {
        ErrorReport errorReport = new ErrorReport();
        errorReport.setId(managedErrorLog.getId().toString());
        errorReport.setThreadName(managedErrorLog.getErrorThreadName());
        errorReport.setStackTrace(str);
        errorReport.setAppStartTime(managedErrorLog.getAppLaunchTimestamp());
        errorReport.setAppErrorTime(managedErrorLog.getTimestamp());
        errorReport.setDevice(managedErrorLog.getDevice());
        return errorReport;
    }

    private static File getStoredFile(final UUID uuid, final String str) {
        File[] fileArrListFiles = getErrorStorageDirectory().listFiles(new FilenameFilter() { // from class: com.microsoft.appcenter.crashes.utils.ErrorLogHelper.5
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str2) {
                return str2.startsWith(uuid.toString()) && str2.endsWith(str);
            }
        });
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            return null;
        }
        return fileArrListFiles[0];
    }

    @NonNull
    public static Exception getModelExceptionFromThrowable(@NonNull Throwable th) {
        LinkedList<Throwable> linkedList = new LinkedList();
        while (th != null) {
            linkedList.add(th);
            th = th.getCause();
        }
        if (linkedList.size() > 16) {
            AppCenterLog.warn(Crashes.LOG_TAG, "Crash causes truncated from " + linkedList.size() + " to 16 causes.");
            linkedList.subList(8, linkedList.size() - 8).clear();
        }
        Exception exception = null;
        Exception exception2 = null;
        for (Throwable th2 : linkedList) {
            Exception exception3 = new Exception();
            exception3.setType(th2.getClass().getName());
            exception3.setMessage(th2.getMessage());
            exception3.setFrames(getModelFramesFromStackTrace(th2));
            if (exception == null) {
                exception = exception3;
            } else {
                exception2.setInnerExceptions(Collections.singletonList(exception3));
            }
            exception2 = exception3;
        }
        return exception;
    }

    private static List getModelFramesFromStackTrace(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace.length > 256) {
            StackTraceElement[] stackTraceElementArr = new StackTraceElement[256];
            System.arraycopy(stackTrace, 0, stackTraceElementArr, 0, 128);
            System.arraycopy(stackTrace, stackTrace.length - 128, stackTraceElementArr, 128, 128);
            th.setStackTrace(stackTraceElementArr);
            AppCenterLog.warn(Crashes.LOG_TAG, "Crash frames truncated from " + stackTrace.length + " to 256 frames.");
            stackTrace = stackTraceElementArr;
        }
        return getModelFramesFromStackTrace(stackTrace);
    }

    private static List getModelFramesFromStackTrace(StackTraceElement[] stackTraceElementArr) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            arrayList.add(getModelStackFrame(stackTraceElement));
        }
        return arrayList;
    }

    private static StackFrame getModelStackFrame(StackTraceElement stackTraceElement) {
        StackFrame stackFrame = new StackFrame();
        stackFrame.setClassName(stackTraceElement.getClassName());
        stackFrame.setMethodName(stackTraceElement.getMethodName());
        stackFrame.setLineNumber(Integer.valueOf(stackTraceElement.getLineNumber()));
        stackFrame.setFileName(stackTraceElement.getFileName());
        return stackFrame;
    }

    public static Map<String, String> validateProperties(Map<String, String> map, String str) {
        if (map == null) {
            return null;
        }
        HashMap map2 = new HashMap();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, String> next = it.next();
            String key = next.getKey();
            String value = next.getValue();
            if (map2.size() >= 20) {
                AppCenterLog.warn(Crashes.LOG_TAG, String.format("%s : properties cannot contain more than %s items. Skipping other properties.", str, 20));
                break;
            }
            if (key == null || key.isEmpty()) {
                AppCenterLog.warn(Crashes.LOG_TAG, String.format("%s : a property key cannot be null or empty. Property will be skipped.", str));
            } else if (value == null) {
                AppCenterLog.warn(Crashes.LOG_TAG, String.format("%s : property '%s' : property value cannot be null. Property '%s' will be skipped.", str, key, key));
            } else {
                if (key.length() > 125) {
                    AppCenterLog.warn(Crashes.LOG_TAG, String.format("%s : property '%s' : property key length cannot be longer than %s characters. Property key will be truncated.", str, key, Integer.valueOf(MAX_PROPERTY_ITEM_LENGTH)));
                    key = key.substring(0, MAX_PROPERTY_ITEM_LENGTH);
                }
                if (value.length() > 125) {
                    AppCenterLog.warn(Crashes.LOG_TAG, String.format("%s : property '%s' : property value cannot be longer than %s characters. Property value will be truncated.", str, key, Integer.valueOf(MAX_PROPERTY_ITEM_LENGTH)));
                    value = value.substring(0, MAX_PROPERTY_ITEM_LENGTH);
                }
                map2.put(key, value);
            }
        }
        return map2;
    }

    public static void cleanPendingMinidumps() {
        FileManager.cleanDirectory(getPendingMinidumpDirectory());
    }

    @NonNull
    public static UUID parseLogFolderUuid(File file) {
        UUID uuidFromString;
        if (file.isDirectory()) {
            try {
                uuidFromString = UUID.fromString(file.getName());
            } catch (IllegalArgumentException e) {
                AppCenterLog.warn(Crashes.LOG_TAG, "Cannot parse minidump folder name to UUID.", e);
            }
        } else {
            uuidFromString = null;
        }
        return uuidFromString == null ? UUID.randomUUID() : uuidFromString;
    }

    @VisibleForTesting
    public static void clearStaticState() {
        sNewMinidumpDirectory = null;
        sErrorLogDirectory = null;
        sPendingMinidumpDirectory = null;
    }
}
