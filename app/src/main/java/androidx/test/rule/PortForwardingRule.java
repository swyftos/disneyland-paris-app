package androidx.test.rule;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.test.annotation.Beta;
import androidx.test.internal.util.Checks;
import java.util.Properties;
import org.apache.commons.lang3.SystemProperties;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/* JADX INFO: loaded from: classes2.dex */
@Beta
public class PortForwardingRule implements TestRule {
    public static final int MAX_PORT = 65535;
    public static final int MIN_PORT = 1024;
    private Properties backUpProp;
    Properties prop;
    final String proxyHost;
    final int proxyPort;

    protected static int getDefaultPort() {
        return 8080;
    }

    protected void afterPortForwarding() {
    }

    protected void afterRestoreForwarding() {
    }

    protected void beforePortForwarding() {
    }

    protected void beforeRestoreForwarding() {
    }

    public static class Builder {
        private String proxyHost = "127.0.0.1";
        private int proxyPort = 8080;
        private Properties prop = System.getProperties();

        public Builder withProxyHost(@NonNull String str) {
            this.proxyHost = (String) Checks.checkNotNull(str);
            return this;
        }

        public Builder withProxyPort(int i) {
            Checks.checkArgument(i >= 1024 && i <= 65535, "%d is used as a proxy port, must in range [%d, %d]", Integer.valueOf(i), 1024, 65535);
            this.proxyPort = i;
            return this;
        }

        public Builder withProperties(@NonNull Properties properties) {
            this.prop = (Properties) Checks.checkNotNull(properties);
            return this;
        }

        public PortForwardingRule build() {
            return new PortForwardingRule(this);
        }
    }

    private PortForwardingRule(Builder builder) {
        this(builder.proxyHost, builder.proxyPort, builder.prop);
    }

    protected PortForwardingRule(int i) {
        this("127.0.0.1", i, System.getProperties());
    }

    PortForwardingRule(String str, int i, Properties properties) {
        this.proxyHost = str;
        this.proxyPort = i;
        this.prop = (Properties) Checks.checkNotNull(properties);
        this.backUpProp = new Properties();
        backUpProperties();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPortForwarding() {
        beforePortForwarding();
        this.prop.setProperty(SystemProperties.HTTP_PROXY_HOST, this.proxyHost);
        this.prop.setProperty(SystemProperties.HTTPS_PROXY_HOST, this.proxyHost);
        this.prop.setProperty(SystemProperties.HTTP_PROXY_PORT, String.valueOf(this.proxyPort));
        this.prop.setProperty(SystemProperties.HTTPS_PROXY_PORT, String.valueOf(this.proxyPort));
        afterPortForwarding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restorePortForwarding() {
        try {
            beforeRestoreForwarding();
        } finally {
            restoreOneProperty(this.prop, this.backUpProp, SystemProperties.HTTP_PROXY_HOST);
            restoreOneProperty(this.prop, this.backUpProp, SystemProperties.HTTPS_PROXY_HOST);
            restoreOneProperty(this.prop, this.backUpProp, SystemProperties.HTTP_PROXY_PORT);
            restoreOneProperty(this.prop, this.backUpProp, SystemProperties.HTTPS_PROXY_PORT);
            afterRestoreForwarding();
        }
    }

    private void backUpProperties() {
        if (this.prop.getProperty(SystemProperties.HTTP_PROXY_HOST) != null) {
            this.backUpProp.setProperty(SystemProperties.HTTP_PROXY_HOST, this.prop.getProperty(SystemProperties.HTTP_PROXY_HOST));
        }
        if (this.prop.getProperty(SystemProperties.HTTPS_PROXY_HOST) != null) {
            this.backUpProp.setProperty(SystemProperties.HTTPS_PROXY_HOST, this.prop.getProperty(SystemProperties.HTTPS_PROXY_HOST));
        }
        if (this.prop.getProperty(SystemProperties.HTTP_PROXY_PORT) != null) {
            this.backUpProp.setProperty(SystemProperties.HTTP_PROXY_PORT, this.prop.getProperty(SystemProperties.HTTP_PROXY_PORT));
        }
        if (this.prop.getProperty(SystemProperties.HTTPS_PROXY_PORT) != null) {
            this.backUpProp.setProperty(SystemProperties.HTTPS_PROXY_PORT, this.prop.getProperty(SystemProperties.HTTPS_PROXY_PORT));
        }
    }

    private void restoreOneProperty(Properties properties, Properties properties2, String str) {
        if (properties2.getProperty(str) != null) {
            properties.setProperty(str, properties2.getProperty(str));
        } else {
            properties.remove(str);
        }
    }

    @Override // org.junit.rules.TestRule
    public Statement apply(Statement statement, Description description) {
        return new PortForwardingStatement(statement);
    }

    private class PortForwardingStatement extends Statement {
        private final Statement base;

        public PortForwardingStatement(Statement statement) {
            this.base = statement;
        }

        @Override // org.junit.runners.model.Statement
        public void evaluate() {
            try {
                PortForwardingRule.this.setPortForwarding();
                PortForwardingRule portForwardingRule = PortForwardingRule.this;
                Log.i("PortForwardingRule", String.format("The current process traffic is forwarded to %s:%d", portForwardingRule.proxyHost, Integer.valueOf(portForwardingRule.proxyPort)));
                this.base.evaluate();
            } finally {
                PortForwardingRule.this.restorePortForwarding();
                Log.i("PortForwardingRule", "Current process traffic forwarding is cancelled");
            }
        }
    }
}
