package androidx.test.rule;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.test.annotation.Beta;
import androidx.test.internal.util.Checks;
import java.util.Properties;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

@Beta
/* loaded from: classes2.dex */
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
        this.prop.setProperty("http.proxyHost", this.proxyHost);
        this.prop.setProperty("https.proxyHost", this.proxyHost);
        this.prop.setProperty("http.proxyPort", String.valueOf(this.proxyPort));
        this.prop.setProperty("https.proxyPort", String.valueOf(this.proxyPort));
        afterPortForwarding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restorePortForwarding() {
        try {
            beforeRestoreForwarding();
        } finally {
            restoreOneProperty(this.prop, this.backUpProp, "http.proxyHost");
            restoreOneProperty(this.prop, this.backUpProp, "https.proxyHost");
            restoreOneProperty(this.prop, this.backUpProp, "http.proxyPort");
            restoreOneProperty(this.prop, this.backUpProp, "https.proxyPort");
            afterRestoreForwarding();
        }
    }

    private void backUpProperties() {
        if (this.prop.getProperty("http.proxyHost") != null) {
            this.backUpProp.setProperty("http.proxyHost", this.prop.getProperty("http.proxyHost"));
        }
        if (this.prop.getProperty("https.proxyHost") != null) {
            this.backUpProp.setProperty("https.proxyHost", this.prop.getProperty("https.proxyHost"));
        }
        if (this.prop.getProperty("http.proxyPort") != null) {
            this.backUpProp.setProperty("http.proxyPort", this.prop.getProperty("http.proxyPort"));
        }
        if (this.prop.getProperty("https.proxyPort") != null) {
            this.backUpProp.setProperty("https.proxyPort", this.prop.getProperty("https.proxyPort"));
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
