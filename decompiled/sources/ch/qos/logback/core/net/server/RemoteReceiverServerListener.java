package ch.qos.logback.core.net.server;

import java.net.ServerSocket;
import java.net.Socket;

/* loaded from: classes2.dex */
class RemoteReceiverServerListener extends ServerSocketListener {
    public RemoteReceiverServerListener(ServerSocket serverSocket) {
        super(serverSocket);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ch.qos.logback.core.net.server.ServerSocketListener
    public RemoteReceiverClient createClient(String str, Socket socket) {
        return new RemoteReceiverStreamClient(str, socket);
    }
}
