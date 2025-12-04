package com.disney.id.android.tracker;

import com.disney.id.android.OptionalConfigs;
import com.disney.id.android.lightbox.LightboxActivity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001:\u0001'JH\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u0007H&J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH&J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\tH&J\u0014\u0010\u0013\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J<\u0010\u001c\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001bH&J<\u0010!\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001bH&Jh\u0010\"\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010#\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u001e\u0010$\u001a\u00020\u00032\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010&H&¨\u0006("}, d2 = {"Lcom/disney/id/android/tracker/Tracker;", "", "finishEvent", "", "trackerEventKey", "Lcom/disney/id/android/tracker/TrackerEventKey;", OneIDTrackerEvent.EVENT_PARAM_PROBLEM, "", "codes", "", "category", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "disableThrottling", "getEvent", "Lcom/disney/id/android/tracker/OneIDTrackerEvent;", "getEventFromConversationIdAndEventType", "conversationId", LightboxActivity.ACTION_NAME_EXTRA, "getEventFromEventType", "launchCheck", LightboxActivity.UI_VERSION_EXTRA, "setBrowser", OneIDTrackerEvent.EVENT_PARAM_BROWSER, "setLightboxVersion", "version", "setOptionalConfigData", "optionalConfig", "Lcom/disney/id/android/OptionalConfigs;", "startConversationEvent", "action", "Lcom/disney/id/android/tracker/EventAction;", "swid", "config", "startTransactionEvent", "trackInstantEvent", "addTransactionId", "trackWebEvent", "webEvent", "", "Throttle", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface Tracker {
    void finishEvent(@NotNull TrackerEventKey trackerEventKey, boolean problem, @Nullable String codes, @Nullable String category, @Nullable String info, boolean disableThrottling);

    @Nullable
    OneIDTrackerEvent getEvent(@Nullable TrackerEventKey trackerEventKey);

    @Nullable
    TrackerEventKey getEventFromConversationIdAndEventType(@NotNull String conversationId, @NotNull String actionName);

    @Nullable
    TrackerEventKey getEventFromEventType(@NotNull String actionName);

    void launchCheck(@Nullable String uiVersion);

    void setBrowser(@Nullable String browser);

    void setLightboxVersion(@Nullable String version);

    void setOptionalConfigData(@Nullable OptionalConfigs optionalConfig);

    @NotNull
    TrackerEventKey startConversationEvent(@Nullable String conversationId, @NotNull EventAction action, @NotNull String swid, @Nullable String info, @Nullable OptionalConfigs config);

    @NotNull
    TrackerEventKey startTransactionEvent(@Nullable String conversationId, @NotNull EventAction action, @NotNull String swid, @Nullable String info, @Nullable OptionalConfigs config);

    void trackInstantEvent(@Nullable String conversationId, boolean addTransactionId, @NotNull EventAction action, @NotNull String swid, @Nullable String category, @Nullable String codes, @Nullable String info, @Nullable OptionalConfigs config, boolean problem);

    void trackWebEvent(@NotNull Map<String, ? extends Object> webEvent);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/disney/id/android/tracker/Tracker$Throttle;", "", "value", "", "(Ljava/lang/String;ID)V", "shouldNotThrottle", "", "getShouldNotThrottle", "()Z", "getValue", "()D", "NONE", "NORMAL", "HIGH", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Throttle {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Throttle[] $VALUES;
        private final double value;
        public static final Throttle NONE = new Throttle("NONE", 0, 1.0d);
        public static final Throttle NORMAL = new Throttle("NORMAL", 1, 0.02d);
        public static final Throttle HIGH = new Throttle("HIGH", 2, 2.0E-4d);

        private static final /* synthetic */ Throttle[] $values() {
            return new Throttle[]{NONE, NORMAL, HIGH};
        }

        @NotNull
        public static EnumEntries<Throttle> getEntries() {
            return $ENTRIES;
        }

        public static Throttle valueOf(String str) {
            return (Throttle) Enum.valueOf(Throttle.class, str);
        }

        public static Throttle[] values() {
            return (Throttle[]) $VALUES.clone();
        }

        private Throttle(String str, int i, double d) {
            this.value = d;
        }

        public final double getValue() {
            return this.value;
        }

        static {
            Throttle[] throttleArr$values = $values();
            $VALUES = throttleArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(throttleArr$values);
        }

        public final boolean getShouldNotThrottle() {
            return this.value > Random.INSTANCE.nextDouble();
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void launchCheck$default(Tracker tracker, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchCheck");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            tracker.launchCheck(str);
        }

        public static /* synthetic */ void trackInstantEvent$default(Tracker tracker, String str, boolean z, EventAction eventAction, String str2, String str3, String str4, String str5, OptionalConfigs optionalConfigs, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackInstantEvent");
            }
            tracker.trackInstantEvent((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z, eventAction, str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : optionalConfigs, (i & 256) != 0 ? false : z2);
        }

        public static /* synthetic */ TrackerEventKey startConversationEvent$default(Tracker tracker, String str, EventAction eventAction, String str2, String str3, OptionalConfigs optionalConfigs, int i, Object obj) {
            if (obj == null) {
                return tracker.startConversationEvent((i & 1) != 0 ? null : str, eventAction, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : optionalConfigs);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startConversationEvent");
        }

        public static /* synthetic */ TrackerEventKey startTransactionEvent$default(Tracker tracker, String str, EventAction eventAction, String str2, String str3, OptionalConfigs optionalConfigs, int i, Object obj) {
            if (obj == null) {
                return tracker.startTransactionEvent((i & 1) != 0 ? null : str, eventAction, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : optionalConfigs);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startTransactionEvent");
        }

        public static /* synthetic */ void finishEvent$default(Tracker tracker, TrackerEventKey trackerEventKey, boolean z, String str, String str2, String str3, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishEvent");
            }
            tracker.finishEvent(trackerEventKey, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) == 0 ? str3 : null, (i & 32) == 0 ? z2 : false);
        }
    }
}
