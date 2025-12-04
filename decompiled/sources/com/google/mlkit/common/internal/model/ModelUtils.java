package com.google.mlkit.common.internal.model;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzu;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@KeepForSdk
@WorkerThread
/* loaded from: classes4.dex */
public class ModelUtils {
    private static final GmsLogger zza = new GmsLogger("ModelUtils", "");

    @KeepForSdk
    public static abstract class AutoMLManifest {
        @NonNull
        @KeepForSdk
        public abstract String getLabelsFile();

        @NonNull
        @KeepForSdk
        public abstract String getModelFile();

        @NonNull
        @KeepForSdk
        public abstract String getModelType();
    }

    @KeepForSdk
    public static abstract class ModelLoggingInfo {
        static ModelLoggingInfo zza(long j, String str, boolean z) {
            return new AutoValue_ModelUtils_ModelLoggingInfo(j, zzu.zzb(str), z);
        }

        @NonNull
        @KeepForSdk
        public abstract String getHash();

        @KeepForSdk
        public abstract long getSize();

        @KeepForSdk
        public abstract boolean isManifestModel();
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0109 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo getModelLoggingInfo(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.NonNull com.google.mlkit.common.model.LocalModel r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.internal.model.ModelUtils.getModelLoggingInfo(android.content.Context, com.google.mlkit.common.model.LocalModel):com.google.mlkit.common.internal.model.ModelUtils$ModelLoggingInfo");
    }

    @Nullable
    @KeepForSdk
    public static String getSHA256(@NonNull File file) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                String strZzc = zzc(fileInputStream);
                fileInputStream.close();
                return strZzc;
            } finally {
            }
        } catch (IOException e) {
            zza.e("ModelUtils", "Failed to create FileInputStream for model: ".concat(e.toString()));
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002b, code lost:
    
        if (new java.io.File(r5).exists() == false) goto L10;
     */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest parseManifestFile(@androidx.annotation.NonNull java.lang.String r5, boolean r6, @androidx.annotation.NonNull android.content.Context r7) throws java.io.IOException {
        /*
            java.lang.String r0 = java.lang.String.valueOf(r5)
            com.google.android.gms.common.internal.GmsLogger r1 = com.google.mlkit.common.internal.model.ModelUtils.zza
            java.lang.String r2 = "Manifest file path: "
            java.lang.String r0 = r2.concat(r0)
            java.lang.String r2 = "ModelUtils"
            r1.d(r2, r0)
            r0 = 0
            if (r6 == 0) goto L22
            android.content.res.AssetManager r3 = r7.getAssets()     // Catch: java.io.IOException -> L2d
            java.io.InputStream r3 = r3.open(r5)     // Catch: java.io.IOException -> L2d
            if (r3 == 0) goto L35
            r3.close()     // Catch: java.io.IOException -> L2d
            goto L35
        L22:
            java.io.File r3 = new java.io.File
            r3.<init>(r5)
            boolean r3 = r3.exists()
            if (r3 != 0) goto L35
        L2d:
            com.google.android.gms.common.internal.GmsLogger r5 = com.google.mlkit.common.internal.model.ModelUtils.zza
            java.lang.String r6 = "Manifest file does not exist."
            r5.e(r2, r6)
            return r0
        L35:
            boolean r3 = r5.isEmpty()     // Catch: java.lang.Throwable -> L3f
            r4 = 0
            if (r3 == 0) goto L41
            byte[] r5 = new byte[r4]     // Catch: java.lang.Throwable -> L3f
            goto L64
        L3f:
            r5 = move-exception
            goto La8
        L41:
            if (r6 == 0) goto L4c
            android.content.res.AssetManager r6 = r7.getAssets()     // Catch: java.lang.Throwable -> L3f
            java.io.InputStream r5 = r6.open(r5)     // Catch: java.lang.Throwable -> L3f
            goto L57
        L4c:
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3f
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L3f
            r7.<init>(r5)     // Catch: java.lang.Throwable -> L3f
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L3f
            r5 = r6
        L57:
            int r6 = r5.available()     // Catch: java.lang.Throwable -> L9c
            byte[] r7 = new byte[r6]     // Catch: java.lang.Throwable -> L9c
            r5.read(r7, r4, r6)     // Catch: java.lang.Throwable -> L9c
            r5.close()     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L3f
            r5 = r7
        L64:
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L3f
            java.lang.String r7 = "UTF-8"
            r6.<init>(r5, r7)     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L3f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L3f
            r5.<init>()     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L3f
            java.lang.String r7 = "Json string from the manifest file: "
            r5.append(r7)     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L3f
            r5.append(r6)     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L3f
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L3f
            r1.d(r2, r5)     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L3f
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L3f
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L3f
            java.lang.String r6 = "modelType"
            java.lang.String r6 = r5.getString(r6)     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L3f
            java.lang.String r7 = "modelFile"
            java.lang.String r7 = r5.getString(r7)     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L3f
            java.lang.String r1 = "labelsFile"
            java.lang.String r5 = r5.getString(r1)     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L3f
            com.google.mlkit.common.internal.model.AutoValue_ModelUtils_AutoMLManifest r1 = new com.google.mlkit.common.internal.model.AutoValue_ModelUtils_AutoMLManifest     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L3f
            r1.<init>(r6, r7, r5)     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L3f
            return r1
        L9c:
            r6 = move-exception
            if (r5 == 0) goto La7
            r5.close()     // Catch: java.lang.Throwable -> La3
            goto La7
        La3:
            r5 = move-exception
            r6.addSuppressed(r5)     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L3f
        La7:
            throw r6     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L3f
        La8:
            com.google.android.gms.common.internal.GmsLogger r6 = com.google.mlkit.common.internal.model.ModelUtils.zza
            java.lang.String r7 = "Error parsing the manifest file."
            r6.e(r2, r7, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.internal.model.ModelUtils.parseManifestFile(java.lang.String, boolean, android.content.Context):com.google.mlkit.common.internal.model.ModelUtils$AutoMLManifest");
    }

    public static boolean zza(@NonNull File file, @NonNull String str) throws IOException {
        String sha256 = getSHA256(file);
        zza.d("ModelUtils", "Calculated hash value is: ".concat(String.valueOf(sha256)));
        return str.equals(sha256);
    }

    private static String zzb(Context context, String str, boolean z) throws IOException {
        AutoMLManifest manifestFile = parseManifestFile(str, z, context);
        if (manifestFile != null) {
            return new File(new File(str).getParent(), manifestFile.getModelFile()).toString();
        }
        zza.e("ModelUtils", "Failed to parse manifest file.");
        return null;
    }

    private static String zzc(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
        int i;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bArr = new byte[1048576];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i2);
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (IOException unused) {
            zza.e("ModelUtils", "Failed to read model file");
            return null;
        } catch (NoSuchAlgorithmException unused2) {
            zza.e("ModelUtils", "Do not have SHA-256 algorithm");
            return null;
        }
    }
}
