package com.facebook.soloader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.StrictMode;
import com.facebook.soloader.observer.ObserverHolder;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDeps {
    private static final int LIB_PREFIX_LEN = 3;
    private static final int LIB_SUFFIX_LEN = 3;
    private static byte[] sEncodedDeps = null;
    private static volatile boolean sInitialized = false;
    private static Map sPrecomputedDeps = null;
    private static List sPrecomputedLibs = null;
    private static volatile boolean sUseDepsFileAsync = false;
    private static final int LIB_PREFIX_SUFFIX_LEN = 3 + 3;
    private static final ReentrantReadWriteLock sWaitForDepsFileLock = new ReentrantReadWriteLock();
    private static final HashSet STANDARD_SYSTEM_LIBS = new HashSet() { // from class: com.facebook.soloader.NativeDeps.1
        {
            add("libEGL.so");
            add("libGLESv2.so");
            add("libGLESv3.so");
            add("libOpenSLES.so");
            add("libandroid.so");
            add("libc.so");
            add("libdl.so");
            add("libjnigraphics.so");
            add("liblog.so");
            add("libm.so");
            add("libstdc++.so");
            add("libz.so");
        }
    };

    public static void loadDependencies(String str, ElfByteChannel elfByteChannel, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        String[] dependencies = getDependencies(str, elfByteChannel);
        LogUtil.m1403d(SoLoader.TAG, "Loading " + str + "'s dependencies: " + Arrays.toString(dependencies));
        for (String str2 : dependencies) {
            if (!str2.startsWith("/") && !STANDARD_SYSTEM_LIBS.contains(str2)) {
                SoLoader.loadDependency(str2, i, threadPolicy);
            }
        }
    }

    @SuppressLint({"CatchGeneralException", "EmptyCatchBlock"})
    public static String[] getDependencies(String str, ElfByteChannel elfByteChannel) throws IOException {
        boolean z = SoLoader.SYSTRACE_LIBRARY_LOADING;
        if (z) {
            Api18TraceUtils.beginTraceSection("soloader.NativeDeps.getDependencies[", str, "]");
        }
        ObserverHolder.onGetDependenciesStart();
        try {
            try {
                try {
                    String[] strArrAwaitGetDepsFromPrecomputedDeps = awaitGetDepsFromPrecomputedDeps(str);
                    if (strArrAwaitGetDepsFromPrecomputedDeps == null) {
                        String[] strArrExtract_DT_NEEDED = MinElf.extract_DT_NEEDED(elfByteChannel);
                        ObserverHolder.onGetDependenciesEnd(null);
                        if (z) {
                            Api18TraceUtils.endSection();
                        }
                        return strArrExtract_DT_NEEDED;
                    }
                    ObserverHolder.onGetDependenciesEnd(null);
                    if (z) {
                        Api18TraceUtils.endSection();
                    }
                    return strArrAwaitGetDepsFromPrecomputedDeps;
                } catch (Error | RuntimeException e) {
                    throw e;
                }
            } catch (MinElf.ElfError e2) {
                throw SoLoaderULErrorFactory.create(str, e2);
            }
        } catch (Throwable th) {
            ObserverHolder.onGetDependenciesEnd(null);
            if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                Api18TraceUtils.endSection();
            }
            throw th;
        }
    }

    private static String[] awaitGetDepsFromPrecomputedDeps(String str) {
        if (sInitialized) {
            return tryGetDepsFromPrecomputedDeps(str);
        }
        if (!sUseDepsFileAsync) {
            return null;
        }
        sWaitForDepsFileLock.readLock().lock();
        try {
            return tryGetDepsFromPrecomputedDeps(str);
        } finally {
            sWaitForDepsFileLock.readLock().unlock();
        }
    }

    public static boolean useDepsFile(final Context context, boolean z, final boolean z2) {
        if (!z) {
            return useDepsFileFromApkSync(context, z2);
        }
        new Thread(new Runnable() { // from class: com.facebook.soloader.NativeDeps.2
            @Override // java.lang.Runnable
            public void run() {
                NativeDeps.sWaitForDepsFileLock.writeLock().lock();
                boolean unused = NativeDeps.sUseDepsFileAsync = true;
                try {
                    NativeDeps.useDepsFileFromApkSync(context, z2);
                } finally {
                    int readLockCount = NativeDeps.sWaitForDepsFileLock.getReadLockCount();
                    if (readLockCount >= 3) {
                        LogUtil.m1411w("NativeDeps", "NativeDeps initialization finished with " + Integer.toString(readLockCount) + " threads waiting.");
                    }
                    NativeDeps.sWaitForDepsFileLock.writeLock().unlock();
                    boolean unused2 = NativeDeps.sUseDepsFileAsync = false;
                }
            }
        }, "soloader-nativedeps-init").start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean useDepsFileFromApkSync(Context context, boolean z) throws Throwable {
        boolean zInitDeps;
        try {
            zInitDeps = initDeps(context, z);
        } catch (IOException unused) {
            zInitDeps = false;
        }
        if (!zInitDeps && z) {
            try {
                NativeDepsUnpacker.ensureNativeDepsAvailable(context);
                zInitDeps = initDeps(context, z);
            } catch (IOException unused2) {
            }
        }
        if (!zInitDeps) {
            LogUtil.m1411w("NativeDeps", "Failed to extract native deps from APK, falling back to using MinElf to get library dependencies.");
        }
        return zInitDeps;
    }

    private static boolean initDeps(Context context, boolean z) throws IOException {
        byte[] nativeDepsFromApk;
        byte[] bArrMakeApkDepBlock;
        verifyUninitialized();
        if (z) {
            bArrMakeApkDepBlock = SysUtil.makeApkDepBlock(new File(context.getApplicationInfo().sourceDir), context);
            nativeDepsFromApk = NativeDepsUnpacker.readNativeDepsFromDisk(context);
        } else {
            nativeDepsFromApk = NativeDepsUnpacker.readNativeDepsFromApk(context);
            bArrMakeApkDepBlock = null;
        }
        return processDepsBytes(bArrMakeApkDepBlock, nativeDepsFromApk);
    }

    private static void indexLib(int i, int i2) {
        sPrecomputedLibs.add(Integer.valueOf(i2));
        List arrayList = (List) sPrecomputedDeps.get(Integer.valueOf(i));
        if (arrayList == null) {
            arrayList = new ArrayList();
            sPrecomputedDeps.put(Integer.valueOf(i), arrayList);
        }
        arrayList.add(Integer.valueOf(i2));
    }

    private static void indexDepsBytes(byte[] bArr, int i) {
        int i2;
        byte b;
        boolean z = true;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (z) {
                i3 = 5381;
                i2 = i;
                while (true) {
                    try {
                        b = bArr[i2];
                        if (b <= 32) {
                            break;
                        }
                        i3 = (i3 << 5) + i3 + b;
                        i2++;
                    } catch (IndexOutOfBoundsException unused) {
                        if (z) {
                            return;
                        } else {
                            return;
                        }
                    }
                }
                indexLib(i3, i);
                z = b != 32;
            } else {
                while (bArr[i] != 10) {
                    try {
                        i++;
                    } catch (IndexOutOfBoundsException unused2) {
                        i = i4;
                        if (z || i == bArr.length) {
                            return;
                        }
                        indexLib(i3, i);
                        return;
                    }
                }
                z = true;
                int i5 = i4;
                i2 = i;
                i = i5;
            }
            int i6 = i2 + 1;
            i4 = i;
            i = i6;
        }
    }

    private static int verifyBytesAndGetOffset(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2.length < bArr.length + 4) {
            return -1;
        }
        if (bArr2.length != bArr.length + 4 + ByteBuffer.wrap(bArr2, bArr.length, 4).getInt()) {
            return -1;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return -1;
            }
        }
        return bArr.length + 4;
    }

    private static int findNextLine(byte[] bArr, int i) {
        while (i < bArr.length && bArr[i] != 10) {
            i++;
        }
        return i < bArr.length ? i + 1 : i;
    }

    private static int parseLibCount(byte[] bArr, int i, int i2) {
        try {
            return Integer.parseInt(new String(bArr, i, i2));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    static boolean processDepsBytes(byte[] bArr, byte[] bArr2) {
        int iVerifyBytesAndGetOffset;
        int libCount;
        if (bArr != null) {
            iVerifyBytesAndGetOffset = verifyBytesAndGetOffset(bArr, bArr2);
            if (iVerifyBytesAndGetOffset == -1) {
                return false;
            }
        } else {
            iVerifyBytesAndGetOffset = 0;
        }
        int iFindNextLine = findNextLine(bArr2, iVerifyBytesAndGetOffset);
        if (iFindNextLine >= bArr2.length || (libCount = parseLibCount(bArr2, iVerifyBytesAndGetOffset, (iFindNextLine - iVerifyBytesAndGetOffset) - 1)) <= 0) {
            return false;
        }
        sPrecomputedDeps = new HashMap(((int) (libCount / 1.0f)) + 1, 1.0f);
        sPrecomputedLibs = new ArrayList(libCount);
        indexDepsBytes(bArr2, iFindNextLine);
        if (sPrecomputedLibs.size() != libCount) {
            return false;
        }
        sEncodedDeps = bArr2;
        sInitialized = true;
        return true;
    }

    private static boolean libIsAtOffset(String str, int i) {
        int i2;
        int i3 = LIB_PREFIX_LEN;
        while (true) {
            int length = str.length();
            i2 = LIB_SUFFIX_LEN;
            if (i3 >= length - i2 || i >= sEncodedDeps.length || (str.codePointAt(i3) & 255) != sEncodedDeps[i]) {
                break;
            }
            i3++;
            i++;
        }
        return i3 == str.length() - i2;
    }

    private static int hashLib(String str) {
        int iCodePointAt = 5381;
        for (int i = LIB_PREFIX_LEN; i < str.length() - LIB_SUFFIX_LEN; i++) {
            iCodePointAt = str.codePointAt(i) + (iCodePointAt << 5) + iCodePointAt;
        }
        return iCodePointAt;
    }

    private static int getOffsetForLib(String str) {
        List list = (List) sPrecomputedDeps.get(Integer.valueOf(hashLib(str)));
        if (list == null) {
            return -1;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            if (libIsAtOffset(str, iIntValue)) {
                return iIntValue;
            }
        }
        return -1;
    }

    private static String getLibString(int i) {
        if (i >= sPrecomputedLibs.size()) {
            return null;
        }
        int iIntValue = ((Integer) sPrecomputedLibs.get(i)).intValue();
        int i2 = iIntValue;
        while (true) {
            byte[] bArr = sEncodedDeps;
            if (i2 >= bArr.length || bArr[i2] <= 32) {
                break;
            }
            i2++;
        }
        int i3 = (i2 - iIntValue) + LIB_PREFIX_SUFFIX_LEN;
        char[] cArr = new char[i3];
        cArr[0] = 'l';
        cArr[1] = 'i';
        cArr[2] = 'b';
        for (int i4 = 0; i4 < i3 - LIB_PREFIX_SUFFIX_LEN; i4++) {
            cArr[LIB_PREFIX_LEN + i4] = (char) sEncodedDeps[iIntValue + i4];
        }
        cArr[i3 - 3] = '.';
        cArr[i3 - 2] = 's';
        cArr[i3 - 1] = 'o';
        return new String(cArr);
    }

    private static String[] getDepsForLibAtOffset(int i, int i2) {
        byte b;
        ArrayList arrayList = new ArrayList();
        int i3 = (i + i2) - LIB_PREFIX_SUFFIX_LEN;
        int i4 = 0;
        boolean z = false;
        while (true) {
            byte[] bArr = sEncodedDeps;
            if (i3 >= bArr.length || (b = bArr[i3]) == 10) {
                break;
            }
            if (b == 32) {
                if (z) {
                    String libString = getLibString(i4);
                    if (libString == null) {
                        return null;
                    }
                    arrayList.add(libString);
                    i4 = 0;
                    z = false;
                } else {
                    continue;
                }
            } else {
                if (b < 48 || b > 57) {
                    return null;
                }
                i4 = (i4 * 10) + (b - 48);
                z = true;
            }
            i3++;
        }
        if (z) {
            String libString2 = getLibString(i4);
            if (libString2 == null) {
                return null;
            }
            arrayList.add(libString2);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    static String[] tryGetDepsFromPrecomputedDeps(String str) {
        int offsetForLib;
        if (sInitialized && str.length() > LIB_PREFIX_SUFFIX_LEN && (offsetForLib = getOffsetForLib(str)) != -1) {
            return getDepsForLibAtOffset(offsetForLib, str.length());
        }
        return null;
    }

    private static void verifyUninitialized() {
        if (sInitialized) {
            synchronized (NativeDeps.class) {
                try {
                    if (sInitialized) {
                        throw new IllegalStateException("Trying to initialize NativeDeps but it was already initialized");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
