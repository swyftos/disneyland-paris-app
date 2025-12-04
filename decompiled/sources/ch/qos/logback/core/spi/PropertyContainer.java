package ch.qos.logback.core.spi;

import java.util.Map;

/* loaded from: classes2.dex */
public interface PropertyContainer {
    Map<String, String> getCopyOfPropertyMap();

    String getProperty(String str);
}
