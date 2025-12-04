package ch.qos.logback.core.net.server;

import ch.qos.logback.core.net.server.Client;
import ch.qos.logback.core.spi.ContextAwareBase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
public abstract class ConcurrentServerRunner<T extends Client> extends ContextAwareBase implements Runnable, ServerRunner<T> {
    private final Executor executor;
    private final ServerListener listener;
    private boolean running;
    private final Lock clientsLock = new ReentrantLock();
    private final Collection clients = new ArrayList();

    private class ClientWrapper implements Client {
        private final Client delegate;

        public ClientWrapper(Client client) {
            this.delegate = client;
        }

        @Override // ch.qos.logback.core.net.server.Client, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }

        @Override // java.lang.Runnable
        public void run() {
            ConcurrentServerRunner.this.addClient(this.delegate);
            try {
                this.delegate.run();
            } finally {
                ConcurrentServerRunner.this.removeClient(this.delegate);
            }
        }
    }

    public ConcurrentServerRunner(ServerListener<T> serverListener, Executor executor) {
        this.listener = serverListener;
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addClient(Client client) {
        this.clientsLock.lock();
        try {
            this.clients.add(client);
        } finally {
            this.clientsLock.unlock();
        }
    }

    private Collection copyClients() {
        this.clientsLock.lock();
        try {
            return new ArrayList(this.clients);
        } finally {
            this.clientsLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeClient(Client client) {
        this.clientsLock.lock();
        try {
            this.clients.remove(client);
        } finally {
            this.clientsLock.unlock();
        }
    }

    @Override // ch.qos.logback.core.net.server.ServerRunner
    public void accept(ClientVisitor<T> clientVisitor) {
        for (Client client : copyClients()) {
            try {
                clientVisitor.visit(client);
            } catch (RuntimeException e) {
                addError(client + ": " + e);
            }
        }
    }

    protected abstract boolean configureClient(T t);

    @Override // ch.qos.logback.core.net.server.ServerRunner
    public boolean isRunning() {
        return this.running;
    }

    @Override // java.lang.Runnable
    public void run() {
        setRunning(true);
        try {
            addInfo("listening on " + this.listener);
            while (!Thread.currentThread().isInterrupted()) {
                Client clientAcceptClient = this.listener.acceptClient();
                if (configureClient(clientAcceptClient)) {
                    try {
                        this.executor.execute(new ClientWrapper(clientAcceptClient));
                    } catch (RejectedExecutionException unused) {
                        addError(clientAcceptClient + ": connection dropped");
                    }
                } else {
                    addError(clientAcceptClient + ": connection dropped");
                }
                clientAcceptClient.close();
            }
        } catch (InterruptedException unused2) {
        } catch (Exception e) {
            addError("listener: " + e);
        }
        setRunning(false);
        addInfo("shutting down");
        this.listener.close();
    }

    protected void setRunning(boolean z) {
        this.running = z;
    }

    @Override // ch.qos.logback.core.net.server.ServerRunner
    public void stop() throws IOException {
        this.listener.close();
        accept(new ClientVisitor() { // from class: ch.qos.logback.core.net.server.ConcurrentServerRunner.1
            @Override // ch.qos.logback.core.net.server.ClientVisitor
            public void visit(Client client) {
                client.close();
            }
        });
    }
}
