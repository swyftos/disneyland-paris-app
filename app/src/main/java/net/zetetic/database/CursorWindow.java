package net.zetetic.database;

import android.database.CharArrayBuffer;
import net.zetetic.database.sqlcipher.SQLiteClosable;

/* JADX INFO: loaded from: classes6.dex */
public class CursorWindow extends SQLiteClosable {
    public static final int DEFAULT_CURSOR_WINDOW_SIZE = 16384;
    public static int PREFERRED_CURSOR_WINDOW_SIZE = 16384;
    private final String mName;
    private int mStartPos;
    public long mWindowPtr;
    private final int mWindowSizeBytes;

    private static native boolean nativeAllocRow(long j);

    private static native void nativeClear(long j);

    private static native long nativeCreate(String str, int i);

    private static native void nativeDispose(long j);

    private static native void nativeFreeLastRow(long j);

    private static native byte[] nativeGetBlob(long j, int i, int i2);

    private static native double nativeGetDouble(long j, int i, int i2);

    private static native long nativeGetLong(long j, int i, int i2);

    private static native String nativeGetName(long j);

    private static native int nativeGetNumRows(long j);

    private static native String nativeGetString(long j, int i, int i2);

    private static native int nativeGetType(long j, int i, int i2);

    private static native boolean nativePutBlob(long j, byte[] bArr, int i, int i2);

    private static native boolean nativePutDouble(long j, double d, int i, int i2);

    private static native boolean nativePutLong(long j, long j2, int i, int i2);

    private static native boolean nativePutNull(long j, int i, int i2);

    private static native boolean nativePutString(long j, String str, int i, int i2);

    private static native boolean nativeSetNumColumns(long j, int i);

    public CursorWindow(String str) {
        this(str, 16384);
    }

    public CursorWindow(String str, int i) {
        this.mStartPos = 0;
        this.mWindowSizeBytes = i;
        str = (str == null || str.length() == 0) ? "<unnamed>" : str;
        this.mName = str;
        long jNativeCreate = nativeCreate(str, i);
        this.mWindowPtr = jNativeCreate;
        if (jNativeCreate != 0) {
            return;
        }
        throw new CursorWindowAllocationException("Cursor window allocation of " + (i / 1024) + " kb failed. ");
    }

    protected void finalize() throws Throwable {
        try {
            dispose();
        } finally {
            super.finalize();
        }
    }

    private void dispose() {
        long j = this.mWindowPtr;
        if (j != 0) {
            nativeDispose(j);
            this.mWindowPtr = 0L;
        }
    }

    public String getName() {
        return this.mName;
    }

    public void clear() {
        this.mStartPos = 0;
        nativeClear(this.mWindowPtr);
    }

    public int getStartPosition() {
        return this.mStartPos;
    }

    public void setStartPosition(int i) {
        this.mStartPos = i;
    }

    public int getNumRows() {
        return nativeGetNumRows(this.mWindowPtr);
    }

    public boolean setNumColumns(int i) {
        return nativeSetNumColumns(this.mWindowPtr, i);
    }

    public boolean allocRow() {
        return nativeAllocRow(this.mWindowPtr);
    }

    public void freeLastRow() {
        nativeFreeLastRow(this.mWindowPtr);
    }

    public int getType(int i, int i2) {
        return nativeGetType(this.mWindowPtr, i - this.mStartPos, i2);
    }

    public byte[] getBlob(int i, int i2) {
        return nativeGetBlob(this.mWindowPtr, i - this.mStartPos, i2);
    }

    public String getString(int i, int i2) {
        return nativeGetString(this.mWindowPtr, i - this.mStartPos, i2);
    }

    public void copyStringToBuffer(int i, int i2, CharArrayBuffer charArrayBuffer) {
        if (charArrayBuffer == null) {
            throw new IllegalArgumentException("CharArrayBuffer should not be null");
        }
        char[] charArray = getString(i, i2).toCharArray();
        charArrayBuffer.data = charArray;
        charArrayBuffer.sizeCopied = charArray.length;
    }

    public long getLong(int i, int i2) {
        return nativeGetLong(this.mWindowPtr, i - this.mStartPos, i2);
    }

    public double getDouble(int i, int i2) {
        return nativeGetDouble(this.mWindowPtr, i - this.mStartPos, i2);
    }

    public short getShort(int i, int i2) {
        return (short) getLong(i, i2);
    }

    public int getInt(int i, int i2) {
        return (int) getLong(i, i2);
    }

    public float getFloat(int i, int i2) {
        return (float) getDouble(i, i2);
    }

    public boolean putBlob(byte[] bArr, int i, int i2) {
        return nativePutBlob(this.mWindowPtr, bArr, i - this.mStartPos, i2);
    }

    public boolean putString(String str, int i, int i2) {
        return nativePutString(this.mWindowPtr, str, i - this.mStartPos, i2);
    }

    public boolean putLong(long j, int i, int i2) {
        return nativePutLong(this.mWindowPtr, j, i - this.mStartPos, i2);
    }

    public boolean putDouble(double d, int i, int i2) {
        return nativePutDouble(this.mWindowPtr, d, i - this.mStartPos, i2);
    }

    public boolean putNull(int i, int i2) {
        return nativePutNull(this.mWindowPtr, i - this.mStartPos, i2);
    }

    public boolean isNull(int i, int i2) {
        return getType(i, i2) == 0;
    }

    public boolean isBlob(int i, int i2) {
        int type = getType(i, i2);
        return type == 4 || type == 0;
    }

    @Override // net.zetetic.database.sqlcipher.SQLiteClosable
    protected void onAllReferencesReleased() {
        dispose();
    }

    public String toString() {
        return getName() + " {" + Long.toHexString(this.mWindowPtr) + "}";
    }

    public int getWindowSizeBytes() {
        return this.mWindowSizeBytes;
    }
}
