package com.microsoft.appcenter.utils.storage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

/* loaded from: classes4.dex */
public class FileManager {
    private static Context sContext;

    public static synchronized void initialize(Context context) {
        if (sContext == null) {
            sContext = context;
        }
    }

    public static String read(@NonNull String str) {
        return read(new File(str));
    }

    public static String read(@NonNull File file) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                String property = System.getProperty("line.separator");
                StringBuilder sb = new StringBuilder();
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                    while (true) {
                        String line2 = bufferedReader.readLine();
                        if (line2 == null) {
                            break;
                        }
                        sb.append(property);
                        sb.append(line2);
                    }
                }
                bufferedReader.close();
                return sb.toString();
            } catch (Throwable th) {
                bufferedReader.close();
                throw th;
            }
        } catch (IOException e) {
            AppCenterLog.error("AppCenter", "Could not read file " + file.getAbsolutePath(), e);
            return null;
        }
    }

    public static byte[] readBytes(@NonNull File file) throws IOException {
        byte[] bArr = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                new DataInputStream(fileInputStream).readFully(bArr);
                return bArr;
            } finally {
                fileInputStream.close();
            }
        } catch (IOException e) {
            AppCenterLog.error("AppCenter", "Could not read file " + file.getAbsolutePath(), e);
            return null;
        }
    }

    public static void write(@NonNull String str, @NonNull String str2) throws IOException {
        write(new File(str), str2);
    }

    public static void write(@NonNull File file, @NonNull String str) throws IOException {
        if (TextUtils.isEmpty(str) || TextUtils.getTrimmedLength(str) <= 0) {
            return;
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        try {
            bufferedWriter.write(str);
        } finally {
            bufferedWriter.close();
        }
    }

    @NonNull
    public static String[] getFilenames(@NonNull String str, @Nullable FilenameFilter filenameFilter) {
        File file = new File(str);
        if (file.exists()) {
            return file.list(filenameFilter);
        }
        return new String[0];
    }

    @Nullable
    public static File lastModifiedFile(@NonNull String str, @Nullable FilenameFilter filenameFilter) {
        return lastModifiedFile(new File(str), filenameFilter);
    }

    @Nullable
    public static File lastModifiedFile(@NonNull File file, @Nullable FilenameFilter filenameFilter) {
        File[] fileArrListFiles;
        File file2 = null;
        if (file.exists() && (fileArrListFiles = file.listFiles(filenameFilter)) != null) {
            long jLastModified = 0;
            for (File file3 : fileArrListFiles) {
                if (file3.lastModified() > jLastModified) {
                    jLastModified = file3.lastModified();
                    file2 = file3;
                }
            }
        }
        return file2;
    }

    public static boolean delete(@NonNull String str) {
        return delete(new File(str));
    }

    public static boolean delete(@NonNull File file) {
        return file.delete();
    }

    public static boolean deleteDirectory(@NonNull File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                deleteDirectory(file2);
            }
        }
        return file.delete();
    }

    public static void cleanDirectory(@NonNull File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                deleteDirectory(file2);
            }
        }
    }

    public static void mkdir(@NonNull String str) {
        new File(str).mkdirs();
    }
}
