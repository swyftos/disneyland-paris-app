package io.cucumber.junit;

import java.util.Locale;

/* loaded from: classes5.dex */
final class SkippedThrowable extends Throwable {
    private static final long serialVersionUID = 1;

    SkippedThrowable(NotificationLevel notificationLevel) {
        super(String.format("This %s is skipped", notificationLevel.lowerCaseName()), null, false, false);
    }

    enum NotificationLevel {
        SCENARIO,
        STEP;

        String lowerCaseName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }
}
