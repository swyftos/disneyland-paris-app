package ch.qos.logback.core.util;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.rolling.helper.FileNamePattern;
import ch.qos.logback.core.spi.ContextAwareBase;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import java.util.Map;
import java.util.Properties;

/* loaded from: classes2.dex */
public class ContextUtil extends ContextAwareBase {
    public ContextUtil(Context context) {
        setContext(context);
    }

    public static Map<String, String> getFilenameCollisionMap(Context context) {
        if (context == null) {
            return null;
        }
        return (Map) context.getObject(CoreConstants.FA_FILENAME_COLLISION_MAP);
    }

    public static Map<String, FileNamePattern> getFilenamePatternCollisionMap(Context context) {
        if (context == null) {
            return null;
        }
        return (Map) context.getObject(CoreConstants.RFA_FILENAME_PATTERN_COLLISION_MAP);
    }

    public void addHostNameAsProperty() {
        this.context.putProperty(CoreConstants.HOSTNAME_KEY, AndroidInfoHelpers.DEVICE_LOCALHOST);
    }

    public void addProperties(Properties properties) {
        if (properties == null) {
            return;
        }
        for (String str : properties.keySet()) {
            this.context.putProperty(str, properties.getProperty(str));
        }
    }
}
