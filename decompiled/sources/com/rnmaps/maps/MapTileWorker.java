package com.rnmaps.maps;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes4.dex */
public class MapTileWorker extends Worker {
    public MapTileWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() throws Throwable {
        String string = getInputData().getString("filename");
        try {
            int i = getInputData().getInt("maxAge", 0);
            if (i >= 0) {
                if ((System.currentTimeMillis() - new File(string).lastModified()) / 1000 < i) {
                    return ListenableWorker.Result.failure();
                }
            }
            try {
                byte[] bArrFetchTile = fetchTile(new URL(getInputData().getString("url")));
                if (bArrFetchTile != null) {
                    if (!writeTileImage(bArrFetchTile, string)) {
                        return ListenableWorker.Result.failure();
                    }
                    Log.d("urlTile", "Worker fetched " + string);
                    return ListenableWorker.Result.success();
                }
                return ListenableWorker.Result.retry();
            } catch (MalformedURLException e) {
                throw new AssertionError(e);
            }
        } catch (Error unused) {
            return ListenableWorker.Result.failure();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] fetchTile(java.net.URL r8) throws java.lang.Throwable {
        /*
            r7 = this;
            r7 = 0
            java.io.InputStream r8 = r8.openStream()     // Catch: java.lang.Throwable -> L34 java.lang.Throwable -> L39
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L2c java.lang.Throwable -> L31
            r0.<init>()     // Catch: java.lang.Throwable -> L2c java.lang.Throwable -> L31
            r1 = 16384(0x4000, float:2.2959E-41)
            byte[] r2 = new byte[r1]     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1c
        Le:
            r3 = 0
            int r4 = r8.read(r2, r3, r1)     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1c
            r5 = -1
            if (r4 == r5) goto L1e
            r0.write(r2, r3, r4)     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1c
            goto Le
        L1a:
            r7 = move-exception
            goto L4a
        L1c:
            r1 = move-exception
            goto L3c
        L1e:
            r0.flush()     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1c
            byte[] r7 = r0.toByteArray()     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1c
            r8.close()     // Catch: java.lang.Exception -> L28
        L28:
            r0.close()     // Catch: java.lang.Exception -> L2b
        L2b:
            return r7
        L2c:
            r0 = move-exception
            r6 = r0
            r0 = r7
            r7 = r6
            goto L4a
        L31:
            r1 = move-exception
            r0 = r7
            goto L3c
        L34:
            r8 = move-exception
            r0 = r7
            r7 = r8
            r8 = r0
            goto L4a
        L39:
            r1 = move-exception
            r8 = r7
            r0 = r8
        L3c:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L1a
            if (r8 == 0) goto L44
            r8.close()     // Catch: java.lang.Exception -> L44
        L44:
            if (r0 == 0) goto L49
            r0.close()     // Catch: java.lang.Exception -> L49
        L49:
            return r7
        L4a:
            if (r8 == 0) goto L4f
            r8.close()     // Catch: java.lang.Exception -> L4f
        L4f:
            if (r0 == 0) goto L54
            r0.close()     // Catch: java.lang.Exception -> L54
        L54:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnmaps.maps.MapTileWorker.fetchTile(java.net.URL):byte[]");
    }

    private boolean writeTileImage(byte[] bArr, String str) throws Throwable {
        if (str == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                file.getParentFile().mkdirs();
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (Exception unused) {
                        return true;
                    }
                } catch (IOException | OutOfMemoryError e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (IOException | OutOfMemoryError e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
