package com.contentsquare.android.core.features.preferences;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'CLIENT_MODE_LONG_SNAPSHOT_SCROLL_DELAY_MILLISECONDS' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b7\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9¨\u0006:"}, d2 = {"Lcom/contentsquare/android/core/features/preferences/PreferencesKey;", "", "isGdpr", "", "(Ljava/lang/String;IZ)V", "()Z", "CLIENT_MODE_ACTIVATION_STATE", "CLIENT_MODE_LONG_SNAPSHOT_SCROLL_DELAY_MILLISECONDS", "CLIENT_MODE_SCREENGRAPH_OPTIMIZATION_MODE", "LOCAL_SESSION_REPLAY_MODE", "LOCAL_LOG_VISUALIZER_MODE", "CLIENT_MODE_TUTORIAL", "USER_ID", "INAPP_USER_ID", "SESSION_ID", "SCREEN_NUMBER", "PAUSED_SESSION_ID", "PAUSED_SCREEN_NUMBER", "SCREEN_TIMESTAMP", "DEVELOPER_MODE_ACTIVATION_STATE", "SESSION_REPLAY_GET_REPLAY_LINK", "SESSION_REPLAY_FORCE_START", "SESSION_REPLAY_DEFAULT_MASKING", "SESSION_REPLAY_ETR_ENABLED", "DEVELOPER_SESSION_REPLAY_FORCE_QUALITY_LEVEL", "DEVELOPER_SESSION_REPLAY_FORCE_ANIMATION_DETECTION", "DEVELOPER_SESSION_REPLAY_LOG_VIEWLIGHT_TREE", "DEVELOPER_SESSION_REPLAY_IMAGE_QUALITY_VALUE", "DEVELOPER_SESSION_REPLAY_FPS_VALUE", "DEVELOPER_SESSION_REPLAY_MAXIMUM_USAGE_ON_UI_THREAD_IN_MILLI_SEC", "DEVELOPER_SESSION_REPLAY_URL", "DEVELOPER_SESSION_REPLAY_PRESET_URL", "DEVELOPER_SESSION_TIMEOUT_TO_0", "DEVELOPER_OVERRIDE_FEATURE_FLAGS_ENABLED", "DEVELOPER_OVERRIDE_FEATURE_FLAGS_STATES", "TRACKING_ENABLE", "FORGET_ME", "PAUSE_TRACKING", "VERBOSE_LOG", "RECORDING_SEGMENT_SAMPLE", "RECORDING_RATE_CONFIG", "RAW_CONFIGURATION_AS_JSON", "TELEMETRY_IS_REPORT_SENT", "TELEMETRY_IS_FORCED_REPORT_SENT", "LONG_SNAPSHOT_EXPLANATION_SHOWN", "TELEMETRY_CUSTOMER_APP_CODE_VERSION", "TELEMETRY_LAST_REPORT_SENT_TIME_STAMP", "TELEMETRY_NETWORK_MONITORING_RATE", "TELEMETRY_PUBLIC_USAGE_RATE", "LAST_APP_VERSION_NUMBER", "LAST_SDK_VERSION_NUMBER", "IS_MIGRATED_FROM_PREFS_HELPER", "LAST_SEGMENT", "IS_TRACKABLE", "IS_OPT_OUT", "LAST_EVENT_TIMESTAMP", "IS_HIDE_EVENT_PENDING", "SCHEDULED_APP_HIDE_EVENT", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PreferencesKey {
    public static final PreferencesKey CLIENT_MODE_LONG_SNAPSHOT_SCROLL_DELAY_MILLISECONDS;
    public static final PreferencesKey CLIENT_MODE_SCREENGRAPH_OPTIMIZATION_MODE;
    public static final PreferencesKey CLIENT_MODE_TUTORIAL;
    public static final PreferencesKey DEVELOPER_MODE_ACTIVATION_STATE;
    public static final PreferencesKey DEVELOPER_OVERRIDE_FEATURE_FLAGS_ENABLED;
    public static final PreferencesKey DEVELOPER_OVERRIDE_FEATURE_FLAGS_STATES;
    public static final PreferencesKey DEVELOPER_SESSION_REPLAY_FORCE_ANIMATION_DETECTION;
    public static final PreferencesKey DEVELOPER_SESSION_REPLAY_FORCE_QUALITY_LEVEL;
    public static final PreferencesKey DEVELOPER_SESSION_REPLAY_FPS_VALUE;
    public static final PreferencesKey DEVELOPER_SESSION_REPLAY_IMAGE_QUALITY_VALUE;
    public static final PreferencesKey DEVELOPER_SESSION_REPLAY_LOG_VIEWLIGHT_TREE;
    public static final PreferencesKey DEVELOPER_SESSION_REPLAY_MAXIMUM_USAGE_ON_UI_THREAD_IN_MILLI_SEC;
    public static final PreferencesKey DEVELOPER_SESSION_REPLAY_PRESET_URL;
    public static final PreferencesKey DEVELOPER_SESSION_REPLAY_URL;
    public static final PreferencesKey DEVELOPER_SESSION_TIMEOUT_TO_0;
    public static final PreferencesKey FORGET_ME;
    public static final PreferencesKey INAPP_USER_ID;
    public static final PreferencesKey IS_MIGRATED_FROM_PREFS_HELPER;
    public static final PreferencesKey IS_OPT_OUT;
    public static final PreferencesKey LAST_APP_VERSION_NUMBER;
    public static final PreferencesKey LAST_SDK_VERSION_NUMBER;
    public static final PreferencesKey LOCAL_LOG_VISUALIZER_MODE;
    public static final PreferencesKey LOCAL_SESSION_REPLAY_MODE;
    public static final PreferencesKey LONG_SNAPSHOT_EXPLANATION_SHOWN;
    public static final PreferencesKey PAUSE_TRACKING;
    public static final PreferencesKey RAW_CONFIGURATION_AS_JSON;
    public static final PreferencesKey RECORDING_RATE_CONFIG;
    public static final PreferencesKey RECORDING_SEGMENT_SAMPLE;
    public static final PreferencesKey SCREEN_TIMESTAMP;
    public static final PreferencesKey SESSION_REPLAY_DEFAULT_MASKING;
    public static final PreferencesKey SESSION_REPLAY_ETR_ENABLED;
    public static final PreferencesKey SESSION_REPLAY_FORCE_START;
    public static final PreferencesKey SESSION_REPLAY_GET_REPLAY_LINK;
    public static final PreferencesKey TELEMETRY_CUSTOMER_APP_CODE_VERSION;
    public static final PreferencesKey TELEMETRY_IS_FORCED_REPORT_SENT;
    public static final PreferencesKey TELEMETRY_IS_REPORT_SENT;
    public static final PreferencesKey TELEMETRY_LAST_REPORT_SENT_TIME_STAMP;
    public static final PreferencesKey TELEMETRY_NETWORK_MONITORING_RATE;
    public static final PreferencesKey TELEMETRY_PUBLIC_USAGE_RATE;
    public static final PreferencesKey TRACKING_ENABLE;
    public static final PreferencesKey VERBOSE_LOG;
    private final boolean isGdpr;
    public static final PreferencesKey CLIENT_MODE_ACTIVATION_STATE = new PreferencesKey("CLIENT_MODE_ACTIVATION_STATE", 0, false, 1, null);
    public static final PreferencesKey USER_ID = new PreferencesKey("USER_ID", 6, true);
    public static final PreferencesKey SESSION_ID = new PreferencesKey("SESSION_ID", 8, true);
    public static final PreferencesKey SCREEN_NUMBER = new PreferencesKey("SCREEN_NUMBER", 9, true);
    public static final PreferencesKey PAUSED_SESSION_ID = new PreferencesKey("PAUSED_SESSION_ID", 10, true);
    public static final PreferencesKey PAUSED_SCREEN_NUMBER = new PreferencesKey("PAUSED_SCREEN_NUMBER", 11, true);
    public static final PreferencesKey LAST_SEGMENT = new PreferencesKey("LAST_SEGMENT", 46, true);
    public static final PreferencesKey IS_TRACKABLE = new PreferencesKey("IS_TRACKABLE", 47, true);
    public static final PreferencesKey LAST_EVENT_TIMESTAMP = new PreferencesKey("LAST_EVENT_TIMESTAMP", 49, true);
    public static final PreferencesKey IS_HIDE_EVENT_PENDING = new PreferencesKey("IS_HIDE_EVENT_PENDING", 50, true);
    public static final PreferencesKey SCHEDULED_APP_HIDE_EVENT = new PreferencesKey("SCHEDULED_APP_HIDE_EVENT", 51, true);
    private static final /* synthetic */ PreferencesKey[] $VALUES = $values();

    private static final /* synthetic */ PreferencesKey[] $values() {
        return new PreferencesKey[]{CLIENT_MODE_ACTIVATION_STATE, CLIENT_MODE_LONG_SNAPSHOT_SCROLL_DELAY_MILLISECONDS, CLIENT_MODE_SCREENGRAPH_OPTIMIZATION_MODE, LOCAL_SESSION_REPLAY_MODE, LOCAL_LOG_VISUALIZER_MODE, CLIENT_MODE_TUTORIAL, USER_ID, INAPP_USER_ID, SESSION_ID, SCREEN_NUMBER, PAUSED_SESSION_ID, PAUSED_SCREEN_NUMBER, SCREEN_TIMESTAMP, DEVELOPER_MODE_ACTIVATION_STATE, SESSION_REPLAY_GET_REPLAY_LINK, SESSION_REPLAY_FORCE_START, SESSION_REPLAY_DEFAULT_MASKING, SESSION_REPLAY_ETR_ENABLED, DEVELOPER_SESSION_REPLAY_FORCE_QUALITY_LEVEL, DEVELOPER_SESSION_REPLAY_FORCE_ANIMATION_DETECTION, DEVELOPER_SESSION_REPLAY_LOG_VIEWLIGHT_TREE, DEVELOPER_SESSION_REPLAY_IMAGE_QUALITY_VALUE, DEVELOPER_SESSION_REPLAY_FPS_VALUE, DEVELOPER_SESSION_REPLAY_MAXIMUM_USAGE_ON_UI_THREAD_IN_MILLI_SEC, DEVELOPER_SESSION_REPLAY_URL, DEVELOPER_SESSION_REPLAY_PRESET_URL, DEVELOPER_SESSION_TIMEOUT_TO_0, DEVELOPER_OVERRIDE_FEATURE_FLAGS_ENABLED, DEVELOPER_OVERRIDE_FEATURE_FLAGS_STATES, TRACKING_ENABLE, FORGET_ME, PAUSE_TRACKING, VERBOSE_LOG, RECORDING_SEGMENT_SAMPLE, RECORDING_RATE_CONFIG, RAW_CONFIGURATION_AS_JSON, TELEMETRY_IS_REPORT_SENT, TELEMETRY_IS_FORCED_REPORT_SENT, LONG_SNAPSHOT_EXPLANATION_SHOWN, TELEMETRY_CUSTOMER_APP_CODE_VERSION, TELEMETRY_LAST_REPORT_SENT_TIME_STAMP, TELEMETRY_NETWORK_MONITORING_RATE, TELEMETRY_PUBLIC_USAGE_RATE, LAST_APP_VERSION_NUMBER, LAST_SDK_VERSION_NUMBER, IS_MIGRATED_FROM_PREFS_HELPER, LAST_SEGMENT, IS_TRACKABLE, IS_OPT_OUT, LAST_EVENT_TIMESTAMP, IS_HIDE_EVENT_PENDING, SCHEDULED_APP_HIDE_EVENT};
    }

    static {
        int i = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        boolean z = false;
        CLIENT_MODE_LONG_SNAPSHOT_SCROLL_DELAY_MILLISECONDS = new PreferencesKey("CLIENT_MODE_LONG_SNAPSHOT_SCROLL_DELAY_MILLISECONDS", 1, z, i, defaultConstructorMarker);
        int i2 = 1;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        boolean z2 = false;
        CLIENT_MODE_SCREENGRAPH_OPTIMIZATION_MODE = new PreferencesKey("CLIENT_MODE_SCREENGRAPH_OPTIMIZATION_MODE", 2, z2, i2, defaultConstructorMarker2);
        LOCAL_SESSION_REPLAY_MODE = new PreferencesKey("LOCAL_SESSION_REPLAY_MODE", 3, z, i, defaultConstructorMarker);
        LOCAL_LOG_VISUALIZER_MODE = new PreferencesKey("LOCAL_LOG_VISUALIZER_MODE", 4, z2, i2, defaultConstructorMarker2);
        CLIENT_MODE_TUTORIAL = new PreferencesKey("CLIENT_MODE_TUTORIAL", 5, z, i, defaultConstructorMarker);
        int i3 = 1;
        DefaultConstructorMarker defaultConstructorMarker3 = null;
        boolean z3 = false;
        INAPP_USER_ID = new PreferencesKey("INAPP_USER_ID", 7, z3, i3, defaultConstructorMarker3);
        SCREEN_TIMESTAMP = new PreferencesKey("SCREEN_TIMESTAMP", 12, z3, i3, defaultConstructorMarker3);
        int i4 = 1;
        DefaultConstructorMarker defaultConstructorMarker4 = null;
        boolean z4 = false;
        DEVELOPER_MODE_ACTIVATION_STATE = new PreferencesKey("DEVELOPER_MODE_ACTIVATION_STATE", 13, z4, i4, defaultConstructorMarker4);
        SESSION_REPLAY_GET_REPLAY_LINK = new PreferencesKey("SESSION_REPLAY_GET_REPLAY_LINK", 14, z3, i3, defaultConstructorMarker3);
        SESSION_REPLAY_FORCE_START = new PreferencesKey("SESSION_REPLAY_FORCE_START", 15, z4, i4, defaultConstructorMarker4);
        SESSION_REPLAY_DEFAULT_MASKING = new PreferencesKey("SESSION_REPLAY_DEFAULT_MASKING", 16, z3, i3, defaultConstructorMarker3);
        SESSION_REPLAY_ETR_ENABLED = new PreferencesKey("SESSION_REPLAY_ETR_ENABLED", 17, z4, i4, defaultConstructorMarker4);
        DEVELOPER_SESSION_REPLAY_FORCE_QUALITY_LEVEL = new PreferencesKey("DEVELOPER_SESSION_REPLAY_FORCE_QUALITY_LEVEL", 18, z3, i3, defaultConstructorMarker3);
        DEVELOPER_SESSION_REPLAY_FORCE_ANIMATION_DETECTION = new PreferencesKey("DEVELOPER_SESSION_REPLAY_FORCE_ANIMATION_DETECTION", 19, z4, i4, defaultConstructorMarker4);
        DEVELOPER_SESSION_REPLAY_LOG_VIEWLIGHT_TREE = new PreferencesKey("DEVELOPER_SESSION_REPLAY_LOG_VIEWLIGHT_TREE", 20, z3, i3, defaultConstructorMarker3);
        DEVELOPER_SESSION_REPLAY_IMAGE_QUALITY_VALUE = new PreferencesKey("DEVELOPER_SESSION_REPLAY_IMAGE_QUALITY_VALUE", 21, z4, i4, defaultConstructorMarker4);
        DEVELOPER_SESSION_REPLAY_FPS_VALUE = new PreferencesKey("DEVELOPER_SESSION_REPLAY_FPS_VALUE", 22, z3, i3, defaultConstructorMarker3);
        DEVELOPER_SESSION_REPLAY_MAXIMUM_USAGE_ON_UI_THREAD_IN_MILLI_SEC = new PreferencesKey("DEVELOPER_SESSION_REPLAY_MAXIMUM_USAGE_ON_UI_THREAD_IN_MILLI_SEC", 23, z4, i4, defaultConstructorMarker4);
        DEVELOPER_SESSION_REPLAY_URL = new PreferencesKey("DEVELOPER_SESSION_REPLAY_URL", 24, z3, i3, defaultConstructorMarker3);
        DEVELOPER_SESSION_REPLAY_PRESET_URL = new PreferencesKey("DEVELOPER_SESSION_REPLAY_PRESET_URL", 25, z4, i4, defaultConstructorMarker4);
        DEVELOPER_SESSION_TIMEOUT_TO_0 = new PreferencesKey("DEVELOPER_SESSION_TIMEOUT_TO_0", 26, z3, i3, defaultConstructorMarker3);
        DEVELOPER_OVERRIDE_FEATURE_FLAGS_ENABLED = new PreferencesKey("DEVELOPER_OVERRIDE_FEATURE_FLAGS_ENABLED", 27, z4, i4, defaultConstructorMarker4);
        DEVELOPER_OVERRIDE_FEATURE_FLAGS_STATES = new PreferencesKey("DEVELOPER_OVERRIDE_FEATURE_FLAGS_STATES", 28, z3, i3, defaultConstructorMarker3);
        TRACKING_ENABLE = new PreferencesKey("TRACKING_ENABLE", 29, z4, i4, defaultConstructorMarker4);
        FORGET_ME = new PreferencesKey("FORGET_ME", 30, z3, i3, defaultConstructorMarker3);
        PAUSE_TRACKING = new PreferencesKey("PAUSE_TRACKING", 31, z4, i4, defaultConstructorMarker4);
        VERBOSE_LOG = new PreferencesKey("VERBOSE_LOG", 32, z3, i3, defaultConstructorMarker3);
        RECORDING_SEGMENT_SAMPLE = new PreferencesKey("RECORDING_SEGMENT_SAMPLE", 33, z4, i4, defaultConstructorMarker4);
        RECORDING_RATE_CONFIG = new PreferencesKey("RECORDING_RATE_CONFIG", 34, z3, i3, defaultConstructorMarker3);
        RAW_CONFIGURATION_AS_JSON = new PreferencesKey("RAW_CONFIGURATION_AS_JSON", 35, z4, i4, defaultConstructorMarker4);
        TELEMETRY_IS_REPORT_SENT = new PreferencesKey("TELEMETRY_IS_REPORT_SENT", 36, z3, i3, defaultConstructorMarker3);
        TELEMETRY_IS_FORCED_REPORT_SENT = new PreferencesKey("TELEMETRY_IS_FORCED_REPORT_SENT", 37, z4, i4, defaultConstructorMarker4);
        LONG_SNAPSHOT_EXPLANATION_SHOWN = new PreferencesKey("LONG_SNAPSHOT_EXPLANATION_SHOWN", 38, z3, i3, defaultConstructorMarker3);
        TELEMETRY_CUSTOMER_APP_CODE_VERSION = new PreferencesKey("TELEMETRY_CUSTOMER_APP_CODE_VERSION", 39, z4, i4, defaultConstructorMarker4);
        TELEMETRY_LAST_REPORT_SENT_TIME_STAMP = new PreferencesKey("TELEMETRY_LAST_REPORT_SENT_TIME_STAMP", 40, z3, i3, defaultConstructorMarker3);
        TELEMETRY_NETWORK_MONITORING_RATE = new PreferencesKey("TELEMETRY_NETWORK_MONITORING_RATE", 41, z4, i4, defaultConstructorMarker4);
        TELEMETRY_PUBLIC_USAGE_RATE = new PreferencesKey("TELEMETRY_PUBLIC_USAGE_RATE", 42, z3, i3, defaultConstructorMarker3);
        LAST_APP_VERSION_NUMBER = new PreferencesKey("LAST_APP_VERSION_NUMBER", 43, z4, i4, defaultConstructorMarker4);
        LAST_SDK_VERSION_NUMBER = new PreferencesKey("LAST_SDK_VERSION_NUMBER", 44, z3, i3, defaultConstructorMarker3);
        IS_MIGRATED_FROM_PREFS_HELPER = new PreferencesKey("IS_MIGRATED_FROM_PREFS_HELPER", 45, z4, i4, defaultConstructorMarker4);
        IS_OPT_OUT = new PreferencesKey("IS_OPT_OUT", 48, z3, i3, defaultConstructorMarker3);
    }

    private PreferencesKey(String str, int i, boolean z) {
        this.isGdpr = z;
    }

    public static PreferencesKey valueOf(String str) {
        return (PreferencesKey) Enum.valueOf(PreferencesKey.class, str);
    }

    public static PreferencesKey[] values() {
        return (PreferencesKey[]) $VALUES.clone();
    }

    /* renamed from: isGdpr, reason: from getter */
    public final boolean getIsGdpr() {
        return this.isGdpr;
    }

    public /* synthetic */ PreferencesKey(String str, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 1) != 0 ? false : z);
    }
}
