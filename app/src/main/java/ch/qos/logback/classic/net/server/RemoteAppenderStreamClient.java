package ch.qos.logback.classic.net.server;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.net.HardenedObjectInputStream;
import ch.qos.logback.core.util.CloseUtil;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/* JADX INFO: loaded from: classes2.dex */
class RemoteAppenderStreamClient implements RemoteAppenderClient {

    /* JADX INFO: renamed from: id */
    private final String f186id;
    private final InputStream inputStream = null;

    /* JADX INFO: renamed from: lc */
    private LoggerContext f187lc;
    private Logger logger;
    private final Socket socket;

    public RemoteAppenderStreamClient(String str, Socket socket) {
        this.f186id = str;
        this.socket = socket;
    }

    private HardenedObjectInputStream createObjectInputStream() {
        return this.inputStream != null ? new HardenedLoggingEventInputStream(this.inputStream) : new HardenedLoggingEventInputStream(this.socket.getInputStream());
    }

    @Override // ch.qos.logback.core.net.server.Client, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Socket socket = this.socket;
        if (socket == null) {
            return;
        }
        CloseUtil.closeQuietly(socket);
    }

    @Override // java.lang.Runnable
    public void run() {
        Logger logger;
        StringBuilder sb;
        this.logger.info(this + ": connected");
        HardenedObjectInputStream hardenedObjectInputStreamCreateObjectInputStream = null;
        try {
            try {
                try {
                    hardenedObjectInputStreamCreateObjectInputStream = createObjectInputStream();
                    while (true) {
                        ILoggingEvent iLoggingEvent = (ILoggingEvent) hardenedObjectInputStreamCreateObjectInputStream.readObject();
                        Logger logger2 = this.f187lc.getLogger(iLoggingEvent.getLoggerName());
                        if (logger2.isEnabledFor(iLoggingEvent.getLevel())) {
                            logger2.callAppenders(iLoggingEvent);
                        }
                    }
                } catch (IOException e) {
                    this.logger.info(this + ": " + e);
                    if (hardenedObjectInputStreamCreateObjectInputStream != null) {
                        CloseUtil.closeQuietly(hardenedObjectInputStreamCreateObjectInputStream);
                    }
                    close();
                    logger = this.logger;
                    sb = new StringBuilder();
                    sb.append(this);
                    sb.append(": connection closed");
                    logger.info(sb.toString());
                } catch (RuntimeException e2) {
                    this.logger.error(this + ": " + e2);
                    if (hardenedObjectInputStreamCreateObjectInputStream != null) {
                        CloseUtil.closeQuietly(hardenedObjectInputStreamCreateObjectInputStream);
                    }
                    close();
                    logger = this.logger;
                    sb = new StringBuilder();
                    sb.append(this);
                    sb.append(": connection closed");
                    logger.info(sb.toString());
                }
            } catch (EOFException unused) {
                if (hardenedObjectInputStreamCreateObjectInputStream != null) {
                    CloseUtil.closeQuietly(hardenedObjectInputStreamCreateObjectInputStream);
                }
                close();
                logger = this.logger;
                sb = new StringBuilder();
                sb.append(this);
                sb.append(": connection closed");
                logger.info(sb.toString());
            } catch (ClassNotFoundException unused2) {
                this.logger.error(this + ": unknown event class");
                if (hardenedObjectInputStreamCreateObjectInputStream != null) {
                    CloseUtil.closeQuietly(hardenedObjectInputStreamCreateObjectInputStream);
                }
                close();
                logger = this.logger;
                sb = new StringBuilder();
                sb.append(this);
                sb.append(": connection closed");
                logger.info(sb.toString());
            }
        } catch (Throwable th) {
            if (hardenedObjectInputStreamCreateObjectInputStream != null) {
                CloseUtil.closeQuietly(hardenedObjectInputStreamCreateObjectInputStream);
            }
            close();
            this.logger.info(this + ": connection closed");
            throw th;
        }
    }

    @Override // ch.qos.logback.classic.net.server.RemoteAppenderClient
    public void setLoggerContext(LoggerContext loggerContext) {
        this.f187lc = loggerContext;
        this.logger = loggerContext.getLogger(getClass().getPackage().getName());
    }

    public String toString() {
        return "client " + this.f186id;
    }
}
