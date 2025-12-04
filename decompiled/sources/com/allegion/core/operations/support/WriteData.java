package com.allegion.core.operations.support;

import com.allegion.logging.AlLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Queue;

/* loaded from: classes2.dex */
public abstract class WriteData {
    private ByteBuffer bbPack;
    protected int maxOffset;
    protected int offset;
    protected byte[] subData;
    protected Queue<byte[]> writeCharList;
    protected byte[] writeData;
    protected boolean isMultiPackageDataWrite = false;
    protected int currentWritePackage = -1;
    protected int totalWritePackages = 1;

    public abstract int getBlockSize();

    public WriteData(byte[] bArr) {
        this.writeData = bArr;
    }

    public WriteData(URI uri) throws IOException {
        extractData(uri);
    }

    private void extractData(URI uri) throws IOException {
        int i;
        if (uri != null && uri.isAbsolute()) {
            File file = new File(uri);
            int length = (int) file.length();
            AlLog.d(".createSendList: file length: " + length + " name: " + file.getName(), new Object[0]);
            this.isMultiPackageDataWrite = false;
            if (length > getBlockSize()) {
                this.isMultiPackageDataWrite = true;
                this.totalWritePackages = (int) Math.ceil(length / getBlockSize());
                AlLog.d(".createSendList: Number of packages to write: " + this.totalWritePackages, new Object[0]);
            }
            this.bbPack = ByteBuffer.allocate(length);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                byte[] bArr = new byte[16];
                for (int i2 = 0; i2 < this.totalWritePackages; i2++) {
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(getBlockSize());
                    int i3 = 0;
                    while (i3 < getBlockSize() && (i = bufferedInputStream.read(bArr, 0, 16)) != -1) {
                        byteBufferAllocate.put(bArr, 0, i);
                        i3 += i;
                    }
                    this.bbPack.put(byteBufferAllocate.array(), 0, byteBufferAllocate.position());
                }
                bufferedInputStream.close();
                AlLog.d(".createSendList: Stream is closed", new Object[0]);
                this.writeData = this.bbPack.array();
                return;
            } catch (Throwable th) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        throw new IOException("File Not Found");
    }

    public byte[] getSendCharPacket() {
        Queue<byte[]> queue = this.writeCharList;
        if (queue != null && !queue.isEmpty()) {
            return this.writeCharList.remove();
        }
        return new byte[0];
    }

    public boolean sendRemainingCharacteristics() {
        Queue<byte[]> queue = this.writeCharList;
        return (queue == null || queue.isEmpty()) ? false : true;
    }

    public boolean sendRemainingPackages() {
        AlLog.d(".sendRemainingPackages: " + this.currentWritePackage + " of " + this.totalWritePackages, new Object[0]);
        return this.currentWritePackage < this.totalWritePackages;
    }

    public boolean isMultiPackageDataWrite() {
        return this.isMultiPackageDataWrite;
    }

    public int totalWritePackages() {
        return this.totalWritePackages;
    }

    public int currentWritePackage() {
        return this.currentWritePackage;
    }

    public void setCurrentWritePackage(int i) {
        this.currentWritePackage = i;
    }

    public byte[] getSendCRC() {
        int iCrc = CRC16.crc(this.subData);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt(iCrc);
        byte[] bArr = {byteBufferAllocate.get(3), byteBufferAllocate.get(2)};
        AlLog.d(".getSendCRC: CRC hex: " + HexConverter.bytesToString(bArr), new Object[0]);
        return bArr;
    }
}
