package androidx.emoji2.text.flatbuffer;

/* loaded from: classes.dex */
interface ReadWriteBuf extends ReadBuf {
    void put(byte b);

    void put(byte[] bArr, int i, int i2);

    void putDouble(double d);

    void putFloat(float f);

    void putInt(int i);

    void putLong(long j);

    void putShort(short s);

    int writePosition();
}
