package com.facebook.soloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes3.dex */
public class SoFileLoaderImpl implements SoFileLoader {
    private final Runtime mRuntime = null;
    private final Method mNativeLoadRuntimeMethod = null;
    private final String mLocalLdLibraryPath = null;
    private final String mLocalLdLibraryPathNoZips = null;

    @Override // com.facebook.soloader.SoFileLoader
    public void loadBytes(String str, ElfByteChannel elfByteChannel, int i) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        if (r2 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
    
        com.facebook.soloader.LogUtil.e("SoFileLoaderImpl", "Error when loading library: " + r2 + ", library hash is " + getLibHash(r7) + ", LD_LIBRARY_PATH is " + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ac  */
    @Override // com.facebook.soloader.SoFileLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void load(java.lang.String r7, int r8) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.reflect.Method r0 = r6.mNativeLoadRuntimeMethod
            if (r0 != 0) goto L8
            java.lang.System.load(r7)
            return
        L8:
            r0 = 4
            r8 = r8 & r0
            if (r8 != r0) goto Lf
            java.lang.String r8 = r6.mLocalLdLibraryPath
            goto L11
        Lf:
            java.lang.String r8 = r6.mLocalLdLibraryPathNoZips
        L11:
            r0 = 0
            java.lang.Runtime r1 = r6.mRuntime     // Catch: java.lang.Throwable -> L84 java.lang.Throwable -> L88
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L84 java.lang.Throwable -> L88
            java.lang.reflect.Method r2 = r6.mNativeLoadRuntimeMethod     // Catch: java.lang.Throwable -> L7a
            java.lang.Runtime r3 = r6.mRuntime     // Catch: java.lang.Throwable -> L7a
            java.lang.Class<com.facebook.soloader.SoLoader> r4 = com.facebook.soloader.SoLoader.class
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch: java.lang.Throwable -> L7a
            java.lang.Object[] r4 = new java.lang.Object[]{r7, r4, r8}     // Catch: java.lang.Throwable -> L7a
            java.lang.Object r2 = r2.invoke(r3, r4)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L7a
            if (r2 != 0) goto L5b
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L59
            if (r2 == 0) goto L58
            java.lang.String r0 = "SoFileLoaderImpl"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Error when loading library: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r2 = ", library hash is "
            r1.append(r2)
            java.lang.String r6 = r6.getLibHash(r7)
            r1.append(r6)
            java.lang.String r6 = ", LD_LIBRARY_PATH is "
            r1.append(r6)
            r1.append(r8)
            java.lang.String r6 = r1.toString()
            com.facebook.soloader.LogUtil.e(r0, r6)
        L58:
            return
        L59:
            r0 = move-exception
            goto L7e
        L5b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59
            r0.<init>()     // Catch: java.lang.Throwable -> L59
            java.lang.String r3 = "nativeLoad() returned error for "
            r0.append(r3)     // Catch: java.lang.Throwable -> L59
            r0.append(r7)     // Catch: java.lang.Throwable -> L59
            java.lang.String r3 = ": "
            r0.append(r3)     // Catch: java.lang.Throwable -> L59
            r0.append(r2)     // Catch: java.lang.Throwable -> L59
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L59
            com.facebook.soloader.SoLoaderULError r2 = new com.facebook.soloader.SoLoaderULError     // Catch: java.lang.Throwable -> L7a
            r2.<init>(r7, r0)     // Catch: java.lang.Throwable -> L7a
            throw r2     // Catch: java.lang.Throwable -> L7a
        L7a:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
        L7e:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L59
            throw r0     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L82
        L80:
            r0 = move-exception
            goto Laa
        L82:
            r0 = move-exception
            goto L8b
        L84:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto Laa
        L88:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L8b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r1.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = "nativeLoad() error during invocation for "
            r1.append(r3)     // Catch: java.lang.Throwable -> L80
            r1.append(r7)     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = ": "
            r1.append(r3)     // Catch: java.lang.Throwable -> L80
            r1.append(r0)     // Catch: java.lang.Throwable -> L80
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L80
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L84
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L84
            throw r1     // Catch: java.lang.Throwable -> L84
        Laa:
            if (r2 == 0) goto Ld6
            java.lang.String r1 = "SoFileLoaderImpl"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Error when loading library: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = ", library hash is "
            r3.append(r2)
            java.lang.String r6 = r6.getLibHash(r7)
            r3.append(r6)
            java.lang.String r6 = ", LD_LIBRARY_PATH is "
            r3.append(r6)
            r3.append(r8)
            java.lang.String r6 = r3.toString()
            com.facebook.soloader.LogUtil.e(r1, r6)
        Ld6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoFileLoaderImpl.load(java.lang.String, int):void");
    }

    private String getLibHash(String str) throws NoSuchAlgorithmException, IOException {
        try {
            File file = new File(str);
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i > 0) {
                        messageDigest.update(bArr, 0, i);
                    } else {
                        String str2 = String.format("%32x", new BigInteger(1, messageDigest.digest()));
                        fileInputStream.close();
                        return str2;
                    }
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException | SecurityException | NoSuchAlgorithmException e) {
            return e.toString();
        }
    }
}
