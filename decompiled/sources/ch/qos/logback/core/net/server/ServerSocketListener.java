package ch.qos.logback.core.net.server;

import ch.qos.logback.core.net.server.Client;
import ch.qos.logback.core.util.CloseUtil;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/* loaded from: classes2.dex */
public abstract class ServerSocketListener<T extends Client> implements ServerListener<T> {
    private final ServerSocket serverSocket;

    public ServerSocketListener(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    private String socketAddressToString(SocketAddress socketAddress) {
        String string = socketAddress.toString();
        int iIndexOf = string.indexOf("/");
        return iIndexOf >= 0 ? string.substring(iIndexOf + 1) : string;
    }

    @Override // ch.qos.logback.core.net.server.ServerListener
    public T acceptClient() throws IOException {
        Socket socketAccept = this.serverSocket.accept();
        return (T) createClient(socketAddressToString(socketAccept.getRemoteSocketAddress()), socketAccept);
    }

    @Override // ch.qos.logback.core.net.server.ServerListener, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        CloseUtil.closeQuietly(this.serverSocket);
    }

    protected abstract T createClient(String str, Socket socket) throws IOException;

    public String toString() {
        return socketAddressToString(this.serverSocket.getLocalSocketAddress());
    }
}
