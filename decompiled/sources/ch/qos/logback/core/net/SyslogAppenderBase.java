package ch.qos.logback.core.net;

import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.Layout;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public abstract class SyslogAppenderBase<E> extends AppenderBase<E> {
    Charset charset;
    String facilityStr;
    Layout layout;
    int maxMessageSize;
    protected SyslogOutputStream sos;
    protected String suffixPattern;
    String syslogHost;
    int port = SyslogConstants.SYSLOG_PORT;
    boolean initialized = false;
    private boolean lazyInit = false;

    private boolean connect() {
        try {
            SyslogOutputStream syslogOutputStreamCreateOutputStream = createOutputStream();
            this.sos = syslogOutputStreamCreateOutputStream;
            int sendBufferSize = syslogOutputStreamCreateOutputStream.getSendBufferSize();
            int i = this.maxMessageSize;
            if (i == 0) {
                this.maxMessageSize = Math.min(sendBufferSize, 65000);
                addInfo("Defaulting maxMessageSize to [" + this.maxMessageSize + "]");
            } else if (i > sendBufferSize) {
                addWarn("maxMessageSize of [" + this.maxMessageSize + "] is larger than the system defined datagram size of [" + sendBufferSize + "].");
                addWarn("This may result in dropped logs.");
            }
        } catch (SocketException e) {
            addWarn("Failed to bind to a random datagram socket. Will try to reconnect later.", e);
        } catch (UnknownHostException e2) {
            addError("Could not create SyslogWriter", e2);
        }
        return this.sos != null;
    }

    public static int facilityStringToint(String str) {
        if ("KERN".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("USER".equalsIgnoreCase(str)) {
            return 8;
        }
        if ("MAIL".equalsIgnoreCase(str)) {
            return 16;
        }
        if ("DAEMON".equalsIgnoreCase(str)) {
            return 24;
        }
        if ("AUTH".equalsIgnoreCase(str)) {
            return 32;
        }
        if ("SYSLOG".equalsIgnoreCase(str)) {
            return 40;
        }
        if ("LPR".equalsIgnoreCase(str)) {
            return 48;
        }
        if ("NEWS".equalsIgnoreCase(str)) {
            return 56;
        }
        if ("UUCP".equalsIgnoreCase(str)) {
            return 64;
        }
        if ("CRON".equalsIgnoreCase(str)) {
            return 72;
        }
        if ("AUTHPRIV".equalsIgnoreCase(str)) {
            return 80;
        }
        if ("FTP".equalsIgnoreCase(str)) {
            return 88;
        }
        if ("NTP".equalsIgnoreCase(str)) {
            return 96;
        }
        if ("AUDIT".equalsIgnoreCase(str)) {
            return 104;
        }
        if ("ALERT".equalsIgnoreCase(str)) {
            return SyslogConstants.LOG_ALERT;
        }
        if ("CLOCK".equalsIgnoreCase(str)) {
            return SyslogConstants.LOG_CLOCK;
        }
        if ("LOCAL0".equalsIgnoreCase(str)) {
            return 128;
        }
        if ("LOCAL1".equalsIgnoreCase(str)) {
            return 136;
        }
        if ("LOCAL2".equalsIgnoreCase(str)) {
            return 144;
        }
        if ("LOCAL3".equalsIgnoreCase(str)) {
            return 152;
        }
        if ("LOCAL4".equalsIgnoreCase(str)) {
            return 160;
        }
        if ("LOCAL5".equalsIgnoreCase(str)) {
            return SyslogConstants.LOG_LOCAL5;
        }
        if ("LOCAL6".equalsIgnoreCase(str)) {
            return SyslogConstants.LOG_LOCAL6;
        }
        if ("LOCAL7".equalsIgnoreCase(str)) {
            return SyslogConstants.LOG_LOCAL7;
        }
        throw new IllegalArgumentException(str + " is not a valid syslog facility string");
    }

    @Override // ch.qos.logback.core.AppenderBase
    protected void append(E e) throws IOException {
        if (isStarted()) {
            if (!this.initialized && this.lazyInit) {
                this.initialized = true;
                connect();
            }
            if (this.sos == null) {
                return;
            }
            try {
                String strDoLayout = this.layout.doLayout(e);
                if (strDoLayout == null) {
                    return;
                }
                int length = strDoLayout.length();
                int i = this.maxMessageSize;
                if (length > i) {
                    strDoLayout = strDoLayout.substring(0, i);
                }
                this.sos.write(strDoLayout.getBytes(this.charset));
                this.sos.flush();
                postProcess(e, this.sos);
            } catch (IOException e2) {
                addError("Failed to send diagram to " + this.syslogHost, e2);
            }
        }
    }

    public abstract Layout<E> buildLayout();

    public abstract SyslogOutputStream createOutputStream() throws SocketException, UnknownHostException;

    public Charset getCharset() {
        return this.charset;
    }

    public String getFacility() {
        return this.facilityStr;
    }

    public Layout<E> getLayout() {
        return this.layout;
    }

    public boolean getLazy() {
        return this.lazyInit;
    }

    public int getMaxMessageSize() {
        return this.maxMessageSize;
    }

    public int getPort() {
        return this.port;
    }

    public abstract int getSeverityForEvent(Object obj);

    public String getSuffixPattern() {
        return this.suffixPattern;
    }

    public String getSyslogHost() {
        return this.syslogHost;
    }

    protected void postProcess(Object obj, OutputStream outputStream) {
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public void setFacility(String str) {
        if (str != null) {
            str = str.trim();
        }
        this.facilityStr = str;
    }

    public void setLayout(Layout<E> layout) {
        addWarn("The layout of a SyslogAppender cannot be set directly. See also http://logback.qos.ch/codes.html#syslog_layout");
    }

    public void setLazy(boolean z) {
        this.lazyInit = z;
    }

    public void setMaxMessageSize(int i) {
        this.maxMessageSize = i;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public void setSuffixPattern(String str) {
        this.suffixPattern = str;
    }

    public void setSyslogHost(String str) {
        this.syslogHost = str;
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        int i;
        if (this.facilityStr == null) {
            addError("The Facility option is mandatory");
            i = 1;
        } else {
            i = 0;
        }
        if (this.charset == null) {
            this.charset = Charset.defaultCharset();
        }
        if (!this.lazyInit && !connect()) {
            i++;
        }
        if (this.layout == null) {
            this.layout = buildLayout();
        }
        if (i == 0) {
            super.start();
        }
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        SyslogOutputStream syslogOutputStream = this.sos;
        if (syslogOutputStream != null) {
            syslogOutputStream.close();
        }
        super.stop();
    }
}
