package com.facebook.soloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes3.dex */
public class SoFileLoaderImpl implements SoFileLoader {
    private final Runtime mRuntime = null;
    private final Method mNativeLoadRuntimeMethod = null;
    private final String mLocalLdLibraryPath = null;
    private final String mLocalLdLibraryPathNoZips = null;

    @Override // com.facebook.soloader.SoFileLoader
    public void loadBytes(String str, ElfByteChannel elfByteChannel, int i) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00ac  */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        if (r2 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
    
        com.facebook.soloader.LogUtil.m1405e("SoFileLoaderImpl", "Error when loading library: " + r2 + ", library hash is " + getLibHash(r7) + ", LD_LIBRARY_PATH is " + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
    
        return;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:40:0x00ac, please report this as an issue */
    @Override // com.facebook.soloader.SoFileLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void load(String str, int i) throws Throwable {
        String str2;
        Throwable th;
        Object e;
        if (this.mNativeLoadRuntimeMethod == null) {
            System.load(str);
            return;
        }
        String str3 = (i & 4) == 4 ? this.mLocalLdLibraryPath : this.mLocalLdLibraryPathNoZips;
        String str4 = null;
        try {
            try {
                try {
                    try {
                        synchronized (this.mRuntime) {
                            try {
                                String str5 = (String) this.mNativeLoadRuntimeMethod.invoke(this.mRuntime, str, SoLoader.class.getClassLoader(), str3);
                                if (str5 != null) {
                                    str4 = "nativeLoad() returned error for " + str + ": " + str5;
                                    throw new SoLoaderULError(str, str4);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    try {
                        throw th;
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                        e = e2;
                        str4 = "nativeLoad() error during invocation for " + str + ": " + e;
                        throw new RuntimeException(str4);
                    }
                } catch (Throwable th4) {
                    str2 = str4;
                    th = th4;
                    if (str2 != null) {
                        LogUtil.m1405e("SoFileLoaderImpl", "Error when loading library: " + str2 + ", library hash is " + getLibHash(str) + ", LD_LIBRARY_PATH is " + str3);
                    }
                    throw th;
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
                e = e3;
            }
        } catch (Throwable th5) {
            th = th5;
            if (str2 != null) {
                LogUtil.m1405e("SoFileLoaderImpl", "Error when loading library: " + str2 + ", library hash is " + getLibHash(str) + ", LD_LIBRARY_PATH is " + str3);
            }
            throw th;
        }
    }

    private String getLibHash(String str) {
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
