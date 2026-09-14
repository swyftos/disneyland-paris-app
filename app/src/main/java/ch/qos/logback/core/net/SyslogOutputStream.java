package ch.qos.logback.core.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes2.dex */
public class SyslogOutputStream extends OutputStream {
    private InetAddress address;
    private ByteArrayOutputStream baos = new ByteArrayOutputStream();

    /* JADX INFO: renamed from: ds */
    private DatagramSocket f192ds = new DatagramSocket();
    private final int port;

    public SyslogOutputStream(String str, int i) throws SocketException, UnknownHostException {
        this.address = InetAddress.getByName(str);
        this.port = i;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DatagramSocket datagramSocket = this.f192ds;
        if (datagramSocket != null) {
            datagramSocket.close();
        }
        this.address = null;
        this.f192ds = null;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        DatagramSocket datagramSocket;
        byte[] byteArray = this.baos.toByteArray();
        DatagramPacket datagramPacket = new DatagramPacket(byteArray, byteArray.length, this.address, this.port);
        if (this.baos.size() > 1024) {
            this.baos = new ByteArrayOutputStream();
        } else {
            this.baos.reset();
        }
        if (byteArray.length == 0 || (datagramSocket = this.f192ds) == null) {
            return;
        }
        datagramSocket.send(datagramPacket);
    }

    public int getPort() {
        return this.port;
    }

    int getSendBufferSize() {
        return this.f192ds.getSendBufferSize();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.baos.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.baos.write(bArr, i, i2);
    }
}
