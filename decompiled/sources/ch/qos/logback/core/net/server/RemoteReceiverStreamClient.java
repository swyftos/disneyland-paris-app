package ch.qos.logback.core.net.server;

import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.util.CloseUtil;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes2.dex */
class RemoteReceiverStreamClient extends ContextAwareBase implements RemoteReceiverClient {
    private final String clientId;
    private final OutputStream outputStream = null;
    private BlockingQueue queue;
    private final Socket socket;

    public RemoteReceiverStreamClient(String str, Socket socket) {
        this.clientId = "client " + str + ": ";
        this.socket = socket;
    }

    private ObjectOutputStream createObjectOutputStream() {
        return this.socket == null ? new ObjectOutputStream(this.outputStream) : new ObjectOutputStream(this.socket.getOutputStream());
    }

    @Override // ch.qos.logback.core.net.server.Client, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Socket socket = this.socket;
        if (socket == null) {
            return;
        }
        CloseUtil.closeQuietly(socket);
    }

    @Override // ch.qos.logback.core.net.server.RemoteReceiverClient
    public boolean offer(Serializable serializable) {
        BlockingQueue blockingQueue = this.queue;
        if (blockingQueue != null) {
            return blockingQueue.offer(serializable);
        }
        throw new IllegalStateException("client has no event queue");
    }

    @Override // java.lang.Runnable
    public void run() throws IOException {
        StringBuilder sb;
        addInfo(this.clientId + "connected");
        ObjectOutputStream objectOutputStreamCreateObjectOutputStream = null;
        try {
            try {
                try {
                    try {
                        objectOutputStreamCreateObjectOutputStream = createObjectOutputStream();
                        loop0: while (true) {
                            int i = 0;
                            while (!Thread.currentThread().isInterrupted()) {
                                try {
                                    objectOutputStreamCreateObjectOutputStream.writeObject((Serializable) this.queue.take());
                                    objectOutputStreamCreateObjectOutputStream.flush();
                                    i++;
                                } catch (InterruptedException unused) {
                                }
                                if (i >= 70) {
                                    try {
                                        objectOutputStreamCreateObjectOutputStream.reset();
                                        break;
                                    } catch (InterruptedException unused2) {
                                        i = 0;
                                        Thread.currentThread().interrupt();
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                        if (objectOutputStreamCreateObjectOutputStream != null) {
                            CloseUtil.closeQuietly(objectOutputStreamCreateObjectOutputStream);
                        }
                        close();
                        sb = new StringBuilder();
                    } catch (RuntimeException e) {
                        addError(this.clientId + e);
                        if (objectOutputStreamCreateObjectOutputStream != null) {
                            CloseUtil.closeQuietly(objectOutputStreamCreateObjectOutputStream);
                        }
                        close();
                        sb = new StringBuilder();
                    }
                } catch (IOException e2) {
                    addError(this.clientId + e2);
                    if (objectOutputStreamCreateObjectOutputStream != null) {
                        CloseUtil.closeQuietly(objectOutputStreamCreateObjectOutputStream);
                    }
                    close();
                    sb = new StringBuilder();
                }
            } catch (SocketException e3) {
                addInfo(this.clientId + e3);
                if (objectOutputStreamCreateObjectOutputStream != null) {
                    CloseUtil.closeQuietly(objectOutputStreamCreateObjectOutputStream);
                }
                close();
                sb = new StringBuilder();
            }
            sb.append(this.clientId);
            sb.append("connection closed");
            addInfo(sb.toString());
        } catch (Throwable th) {
            if (objectOutputStreamCreateObjectOutputStream != null) {
                CloseUtil.closeQuietly(objectOutputStreamCreateObjectOutputStream);
            }
            close();
            addInfo(this.clientId + "connection closed");
            throw th;
        }
    }

    @Override // ch.qos.logback.core.net.server.RemoteReceiverClient
    public void setQueue(BlockingQueue blockingQueue) {
        this.queue = blockingQueue;
    }
}
