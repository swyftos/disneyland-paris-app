package androidx.camera.video.internal.utils;

import androidx.annotation.NonNull;
import java.io.File;

/* loaded from: classes.dex */
public final class OutputUtil {
    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getAbsolutePathFromUri(@androidx.annotation.NonNull android.content.ContentResolver r7, @androidx.annotation.NonNull android.net.Uri r8, @androidx.annotation.NonNull java.lang.String r9) throws java.lang.Throwable {
        /*
            r0 = 0
            java.lang.String[] r3 = new java.lang.String[]{r9}     // Catch: java.lang.Throwable -> L2a java.lang.RuntimeException -> L2c
            r5 = 0
            r6 = 0
            r4 = 0
            r1 = r7
            r2 = r8
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L2a java.lang.RuntimeException -> L2c
            if (r7 != 0) goto L16
            if (r7 == 0) goto L15
            r7.close()
        L15:
            return r0
        L16:
            int r9 = r7.getColumnIndexOrThrow(r9)     // Catch: java.lang.Throwable -> L25 java.lang.RuntimeException -> L28
            r7.moveToFirst()     // Catch: java.lang.Throwable -> L25 java.lang.RuntimeException -> L28
            java.lang.String r8 = r7.getString(r9)     // Catch: java.lang.Throwable -> L25 java.lang.RuntimeException -> L28
            r7.close()
            return r8
        L25:
            r8 = move-exception
            r0 = r7
            goto L4b
        L28:
            r9 = move-exception
            goto L2e
        L2a:
            r8 = move-exception
            goto L4b
        L2c:
            r9 = move-exception
            r7 = r0
        L2e:
            java.lang.String r1 = "OutputUtil"
            java.lang.String r2 = "Failed in getting absolute path for Uri %s with Exception %s"
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L25
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L25
            java.lang.Object[] r8 = new java.lang.Object[]{r8, r9}     // Catch: java.lang.Throwable -> L25
            java.lang.String r8 = java.lang.String.format(r2, r8)     // Catch: java.lang.Throwable -> L25
            androidx.camera.core.Logger.e(r1, r8)     // Catch: java.lang.Throwable -> L25
            if (r7 == 0) goto L4a
            r7.close()
        L4a:
            return r0
        L4b:
            if (r0 == 0) goto L50
            r0.close()
        L50:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.utils.OutputUtil.getAbsolutePathFromUri(android.content.ContentResolver, android.net.Uri, java.lang.String):java.lang.String");
    }

    public static boolean createParentFolder(@NonNull File file) {
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return false;
        }
        return parentFile.exists() ? parentFile.isDirectory() : parentFile.mkdirs();
    }
}
