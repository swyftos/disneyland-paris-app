package com.urbanairship.util;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes5.dex */
public abstract class FileUtils {
    public static boolean deleteRecursively(@NonNull File file) {
        if (!file.exists()) {
            return false;
        }
        if (!file.isDirectory()) {
            return file.delete();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (!deleteRecursively(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static class DownloadResult {
        public final boolean isSuccess;
        public final int statusCode;

        DownloadResult(boolean z, int i) {
            this.isSuccess = z;
            this.statusCode = i;
        }
    }

    @NonNull
    @WorkerThread
    public static DownloadResult downloadFile(@NonNull URL url, @NonNull File file) throws Throwable {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        Exception e;
        int responseCode;
        UALog.v("Downloading file from: %s to: %s", url, file.getAbsolutePath());
        URLConnection uRLConnection = null;
        try {
            URLConnection uRLConnectionOpenSecureConnection = ConnectionUtils.openSecureConnection(UAirship.getApplicationContext(), url);
            try {
                uRLConnectionOpenSecureConnection.setConnectTimeout(2000);
                uRLConnectionOpenSecureConnection.setUseCaches(true);
                if (uRLConnectionOpenSecureConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenSecureConnection;
                    InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
                    try {
                        responseCode = httpURLConnection.getResponseCode();
                        InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                        if (!UAHttpStatusUtil.inSuccessRange(responseCode)) {
                            DownloadResult downloadResult = new DownloadResult(false, responseCode);
                            endRequest(uRLConnectionOpenSecureConnection, null, null);
                            return downloadResult;
                        }
                    } catch (IOException e2) {
                        InstrumentationCallbacks.networkError(httpURLConnection, e2);
                        throw e2;
                    }
                } else {
                    responseCode = 0;
                }
                inputStream = InstrumentationCallbacks.getInputStream(uRLConnectionOpenSecureConnection);
                try {
                    if (inputStream == null) {
                        DownloadResult downloadResult2 = new DownloadResult(false, responseCode);
                        endRequest(uRLConnectionOpenSecureConnection, inputStream, null);
                        return downloadResult2;
                    }
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = inputStream.read(bArr);
                            if (i == -1) {
                                fileOutputStream.close();
                                inputStream.close();
                                DownloadResult downloadResult3 = new DownloadResult(true, responseCode);
                                endRequest(uRLConnectionOpenSecureConnection, inputStream, fileOutputStream);
                                return downloadResult3;
                            }
                            fileOutputStream.write(bArr, 0, i);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        uRLConnection = uRLConnectionOpenSecureConnection;
                        try {
                            file.delete();
                            UALog.e(e, "Failed to download file from: %s", url);
                            DownloadResult downloadResult4 = new DownloadResult(false, -1);
                            endRequest(uRLConnection, inputStream, fileOutputStream);
                            return downloadResult4;
                        } catch (Throwable th) {
                            th = th;
                            endRequest(uRLConnection, inputStream, fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        uRLConnection = uRLConnectionOpenSecureConnection;
                        endRequest(uRLConnection, inputStream, fileOutputStream);
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (Exception e5) {
                fileOutputStream = null;
                e = e5;
                inputStream = null;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                fileOutputStream = null;
            }
        } catch (Exception e6) {
            fileOutputStream = null;
            e = e6;
            inputStream = null;
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            fileOutputStream = null;
        }
    }

    private static void endRequest(URLConnection uRLConnection, Closeable... closeableArr) throws IOException {
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e) {
                    UALog.e(e);
                }
            }
        }
        if (uRLConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            if (InstrumentationCallbacks.getErrorStream(httpURLConnection) != null) {
                try {
                    InstrumentationCallbacks.getErrorStream(httpURLConnection).close();
                } catch (Exception e2) {
                    UALog.e(e2);
                }
            }
            httpURLConnection.disconnect();
        }
    }
}
