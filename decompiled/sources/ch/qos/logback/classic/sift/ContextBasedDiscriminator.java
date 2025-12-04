package ch.qos.logback.classic.sift;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.sift.AbstractDiscriminator;

/* loaded from: classes2.dex */
public class ContextBasedDiscriminator extends AbstractDiscriminator<ILoggingEvent> {
    private String defaultValue;

    public String getDefaultValue() {
        return this.defaultValue;
    }

    @Override // ch.qos.logback.core.sift.Discriminator
    public String getDiscriminatingValue(ILoggingEvent iLoggingEvent) {
        String name = iLoggingEvent.getLoggerContextVO().getName();
        return name == null ? this.defaultValue : name;
    }

    @Override // ch.qos.logback.core.sift.Discriminator
    public String getKey() {
        return "contextName";
    }

    public void setDefaultValue(String str) {
        this.defaultValue = str;
    }

    public void setKey(String str) {
        throw new UnsupportedOperationException("Key cannot be set. Using fixed key contextName");
    }
}
