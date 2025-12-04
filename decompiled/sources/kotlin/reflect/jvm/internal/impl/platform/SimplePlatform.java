package kotlin.reflect.jvm.internal.impl.platform;

import ch.qos.logback.core.CoreConstants;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public abstract class SimplePlatform {
    private final String platformName;
    private final TargetPlatformVersion targetPlatformVersion;

    @NotNull
    public String toString() {
        String targetName = getTargetName();
        if (targetName.length() <= 0) {
            return this.platformName;
        }
        return this.platformName + " (" + targetName + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @NotNull
    public String getTargetName() {
        return getTargetPlatformVersion().getDescription();
    }

    @NotNull
    public TargetPlatformVersion getTargetPlatformVersion() {
        return this.targetPlatformVersion;
    }
}
