package ch.qos.logback.core.net.server;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
class RemoteReceiverServerRunner extends ConcurrentServerRunner {
    private final int clientQueueSize;

    public RemoteReceiverServerRunner(ServerListener serverListener, Executor executor, int i) {
        super(serverListener, executor);
        this.clientQueueSize = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ch.qos.logback.core.net.server.ConcurrentServerRunner
    public boolean configureClient(RemoteReceiverClient remoteReceiverClient) {
        remoteReceiverClient.setContext(getContext());
        remoteReceiverClient.setQueue(new ArrayBlockingQueue(this.clientQueueSize));
        return true;
    }
}
