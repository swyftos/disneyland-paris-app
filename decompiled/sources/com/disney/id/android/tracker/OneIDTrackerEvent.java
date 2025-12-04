package com.disney.id.android.tracker;

import android.os.SystemClock;
import com.disney.id.android.tracker.Tracker;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.picocontainer.Characteristics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u0000 U2\u00020\u0001:\u0001UBC\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bB\u001d\b\u0016\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r¢\u0006\u0002\u0010\u000fB\u0005¢\u0006\u0002\u0010\u0010J1\u0010G\u001a\u00020H2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\bIJ\u0013\u0010J\u001a\u00020\u00052\b\u0010K\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010L\u001a\u00020MH\u0016J\u0018\u0010N\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\u0003H\u0002J\u001d\u0010P\u001a\u00020H2\u0006\u0010*\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0000¢\u0006\u0002\bQJ\r\u0010R\u001a\u00020HH\u0000¢\u0006\u0002\bSJ\b\u0010T\u001a\u00020\u0003H\u0016R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0019X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R(\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u00038@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\"R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0013R\u001a\u0010$\u001a\u00020%X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010\n\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u00010\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0013\"\u0004\b2\u0010\"R(\u00103\u001a\u0004\u0018\u00010\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u00038@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b4\u0010\u0013\"\u0004\b5\u0010\"R(\u00106\u001a\u0004\u0018\u00010\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u00038@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b7\u0010\u0013\"\u0004\b8\u0010\"R(\u00109\u001a\u0004\u0018\u00010\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u00038@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b:\u0010\u0013\"\u0004\b;\u0010\"R\u001a\u0010<\u001a\u00020=X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR(\u0010B\u001a\u0004\u0018\u00010\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u00038@@@X\u0080\u000e¢\u0006\f\u001a\u0004\bC\u0010\u0013\"\u0004\bD\u0010\"R\u0016\u0010E\u001a\u0004\u0018\u00010\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u0013¨\u0006V"}, d2 = {"Lcom/disney/id/android/tracker/OneIDTrackerEvent;", "Ljava/io/Serializable;", "existingConversationId", "", "addTransactionId", "", "action", "Lcom/disney/id/android/tracker/EventAction;", "swid", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, OneIDTrackerEvent.EVENT_PARAM_PROBLEM, "(Ljava/lang/String;ZLcom/disney/id/android/tracker/EventAction;Ljava/lang/String;Ljava/lang/String;Z)V", "webEvent", "", "", "(Ljava/util/Map;)V", "()V", "category", "getCategory$OneID_release", "()Ljava/lang/String;", "codes", "getCodes$OneID_release", "conversationId", "getConversationId$OneID_release", "currentStateParam", "", "getCurrentStateParam$OneID_release", "()Ljava/util/Map;", "detectedCountry", "getDetectedCountry$OneID_release", "value", "idToken", "getIdToken$OneID_release", "setIdToken$OneID_release", "(Ljava/lang/String;)V", "getInfo$OneID_release", "initialElapsedTimeInMillis", "", "getInitialElapsedTimeInMillis$OneID_release", "()J", "setInitialElapsedTimeInMillis$OneID_release", "(J)V", "key", "Lcom/disney/id/android/tracker/TrackerEventKey;", "getKey$OneID_release", "()Lcom/disney/id/android/tracker/TrackerEventKey;", "getProblem$OneID_release", "()Z", "reportBase64", "getReportBase64$OneID_release", "setReportBase64$OneID_release", "reportingContext", "getReportingContext$OneID_release", "setReportingContext$OneID_release", "reportingData", "getReportingData$OneID_release", "setReportingData$OneID_release", "reportingSource", "getReportingSource$OneID_release", "setReportingSource$OneID_release", "throttle", "Lcom/disney/id/android/tracker/Tracker$Throttle;", "getThrottle$OneID_release", "()Lcom/disney/id/android/tracker/Tracker$Throttle;", "setThrottle$OneID_release", "(Lcom/disney/id/android/tracker/Tracker$Throttle;)V", "throttleLevel", "getThrottleLevel$OneID_release", "setThrottleLevel$OneID_release", "transactionId", "getTransactionId$OneID_release", "appendCodes", "", "appendCodes$OneID_release", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "mostSevereErrorCategory", "oldCategory", "setParameter", "setParameter$OneID_release", "stopTiming", "stopTiming$OneID_release", "toString", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOneIDTrackerEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OneIDTrackerEvent.kt\ncom/disney/id/android/tracker/OneIDTrackerEvent\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,488:1\n1#2:489\n215#3,2:490\n*S KotlinDebug\n*F\n+ 1 OneIDTrackerEvent.kt\ncom/disney/id/android/tracker/OneIDTrackerEvent\n*L\n369#1:490,2\n*E\n"})
/* loaded from: classes3.dex */
public final class OneIDTrackerEvent implements Serializable {

    @NotNull
    public static final String ERROR_CATEGORY_CLIENT_FAILURE = "CLIENT_FAILURE";

    @NotNull
    public static final String ERROR_CATEGORY_PPU_ACTIONABLE_INPUT = "PPU_ACTIONABLE_INPUT";

    @NotNull
    public static final String ERROR_CATEGORY_SERVICE_INTERACTION_ERROR = "SERVICE_INTERACTION_ERROR";

    @NotNull
    public static final String ERROR_CATEGORY_TIMED_OUT = "TIMED_OUT";

    @NotNull
    public static final String ERROR_CATEGORY_UNKNOWN = "UNKNOWN_ERROR";

    @NotNull
    public static final String ERROR_CODE_AGE_GATED = "AGE_GATED";

    @NotNull
    public static final String ERROR_CODE_ALREADY_OPT_IN = "ALREADY_OPT_IN";

    @NotNull
    public static final String ERROR_CODE_AUTHORIZATION_INVALID_REFRESH_TOKEN = "AUTHORIZATION_INVALID_REFRESH_TOKEN";

    @NotNull
    public static final String ERROR_CODE_BIOMETRICS_ERROR = "BIOMETRICS_ERROR";

    @NotNull
    public static final String ERROR_CODE_BROWSER_LAUNCH_FAILURE = "BROWSER_LAUNCH_FAILURE";

    @NotNull
    public static final String ERROR_CODE_BUNDLE_LOAD_ERROR = "BUNDLE_LOAD_ERROR";

    @NotNull
    public static final String ERROR_CODE_BUNDLE_READ_ERROR = "BUNDLE_READ_ERROR";

    @NotNull
    public static final String ERROR_CODE_CRYPTOGRAPHY_ERROR = "CRYPTOGRAPHY_ERROR";

    @NotNull
    public static final String ERROR_CODE_EMAIL_MISMATCH = "EMAIL_MISMATCH";

    @NotNull
    public static final String ERROR_CODE_EMAIL_VERIFY_ERROR = "EMAIL_VERIFY_ERROR";

    @NotNull
    public static final String ERROR_CODE_EXTRA_RESUME = "EXTRA_RESUME";

    @NotNull
    public static final String ERROR_CODE_GUEST_HANDLER_ERROR = "GUEST_HANDLER_ERROR";

    @NotNull
    public static final String ERROR_CODE_HEADLESS_DISALLOWED = "HEADLESS_DISALLOWED";

    @NotNull
    public static final String ERROR_CODE_HIGH_TRUST_REQUIRED = "HIGH_TRUST_REQUIRED";

    @NotNull
    public static final String ERROR_CODE_INVALID_EMAIL = "INVALID_EMAIL";

    @NotNull
    public static final String ERROR_CODE_INVALID_JSON = "INVALID_JSON";

    @NotNull
    public static final String ERROR_CODE_INVALID_LOCATION = "INVALID_LOCATION";

    @NotNull
    public static final String ERROR_CODE_INVALID_LOGIN_VALUE = "INVALID_LOGIN_VALUE";

    @NotNull
    public static final String ERROR_CODE_INVALID_PROMOTION_ID = "INVALID_PROMOTION_ID";

    @NotNull
    public static final String ERROR_CODE_INVALID_RESPONSE = "INVALID_RESPONSE";

    @NotNull
    public static final String ERROR_CODE_INVALID_VALUE = "INVALID_VALUE";

    @NotNull
    public static final String ERROR_CODE_LIGHTBOX_ALREADY_IN_USE = "LIGHTBOX_ALREADY_IN_USE";

    @NotNull
    public static final String ERROR_CODE_LOGGING_CONTEXT_FAILURE = "LOGGING_CONTEXT_FAILURE";

    @NotNull
    public static final String ERROR_CODE_MISSING_VALUE = "MISSING_VALUE";

    @NotNull
    public static final String ERROR_CODE_NOT_LOGGED_IN = "NOT_LOGGED_IN";

    @NotNull
    public static final String ERROR_CODE_NO_CONNECTION = "NO_CONNECTION";

    @NotNull
    public static final String ERROR_CODE_NO_VALID_CAMPAIGN = "NO_VALID_CAMPAIGN";

    @NotNull
    public static final String ERROR_CODE_UNEXPECTED_RESPONSE = "UNEXPECTED_RESPONSE";

    @NotNull
    public static final String ERROR_CODE_USER_CANCELLED = "USER_CANCELLED";

    @NotNull
    public static final String ERROR_CODE_WEAK_REFERENCE_MISSING = "WEAK_REFERENCE_MISSING";

    @NotNull
    public static final String EVENT_PARAM_ACTION_NAME = "action_name";

    @NotNull
    public static final String EVENT_PARAM_ANON = "anon";

    @NotNull
    public static final String EVENT_PARAM_BROWSER = "browser";

    @NotNull
    public static final String EVENT_PARAM_CLIENT_ID = "client_id";

    @NotNull
    public static final String EVENT_PARAM_CONNECTION_TYPE = "connection_type";

    @NotNull
    public static final String EVENT_PARAM_CONVERSATION_ID = "conversation_id";

    @NotNull
    public static final String EVENT_PARAM_DETECTED_COUNTRY = "detected_country";

    @NotNull
    public static final String EVENT_PARAM_DEVICE_TIMESTAMP = "device_timestamp";

    @NotNull
    public static final String EVENT_PARAM_DIRECT_FLOW_VERSION = "direct_flow_version";

    @NotNull
    public static final String EVENT_PARAM_ERROR_CATEGORY = "error_category";

    @NotNull
    public static final String EVENT_PARAM_ERROR_CODES = "error_codes";

    @NotNull
    public static final String EVENT_PARAM_ERROR_INFO = "info";

    @NotNull
    public static final String EVENT_PARAM_ID_TOKEN = "id_token";

    @NotNull
    public static final String EVENT_PARAM_LIGHTBOX_VERSION = "lightbox_version";

    @NotNull
    public static final String EVENT_PARAM_MAKE_MODEL = "make_model";

    @NotNull
    public static final String EVENT_PARAM_MOBILE_LAUNCH_ID = "mobile_launch_id";

    @NotNull
    public static final String EVENT_PARAM_OS = "os";

    @NotNull
    public static final String EVENT_PARAM_PROBLEM = "problem";

    @NotNull
    public static final String EVENT_PARAM_PROCESS_TIME = "process_time";

    @NotNull
    public static final String EVENT_PARAM_REPORTING = "reporting";

    @NotNull
    public static final String EVENT_PARAM_REPORTING_CONTEXT = "context";

    @NotNull
    public static final String EVENT_PARAM_REPORTING_SOURCE = "source";

    @NotNull
    public static final String EVENT_PARAM_SDK_INSTALL_UUID = "mobile_install_id";

    @NotNull
    public static final String EVENT_PARAM_SDK_VERSION = "sdk_version";

    @NotNull
    public static final String EVENT_PARAM_SUCCESS = "success";

    @NotNull
    public static final String EVENT_PARAM_SWID = "swid";

    @NotNull
    public static final String EVENT_PARAM_THROTTLE_LEVEL = "throttle_level";

    @NotNull
    public static final String EVENT_PARAM_TIMESTAMP = "timestamp";

    @NotNull
    public static final String EVENT_PARAM_TRANSACTION_ID = "transaction_id";
    private final Map currentStateParam;
    private long initialElapsedTimeInMillis;
    private String reportBase64;
    private Tracker.Throttle throttle;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String ERROR_CODE_PPU_LEGAL = "PPU_LEGAL";
    private static final String[] LEGAL_PPU_CODES = {ERROR_CODE_PPU_LEGAL};

    @NotNull
    public static final String ERROR_CODE_PPU_SECURITY = "PPU_SECURITY";

    @NotNull
    public static final String ERROR_CODE_PROFILE_MISSING_EMAIL = "PROFILE_MISSING_EMAIL";
    private static final String[] PROFILE_PPU_CODES = {ERROR_CODE_PPU_SECURITY, "MISSING_VALUE", ERROR_CODE_PROFILE_MISSING_EMAIL};

    @NotNull
    public static final String ERROR_CATEGORY_FAILURE_BY_DESIGN = "FAILURE_BY_DESIGN";

    @NotNull
    public static final String ERROR_CATEGORY_GUEST_BLOCKED = "GUEST_BLOCKED";

    @NotNull
    public static final String ERROR_CATEGORY_ACTIONABLE_INPUT = "ACTIONABLE_INPUT";

    @NotNull
    public static final String ERROR_CATEGORY_ADVISORY = "ADVISORY";
    private static final String[] ERROR_CATEGORY_SEVERITIES = {"GC_CODE_OR_CONFIG_ERROR", "SYSTEM_UNAVAILABLE", "UNKNOWN_ERROR", ERROR_CATEGORY_FAILURE_BY_DESIGN, ERROR_CATEGORY_GUEST_BLOCKED, "FAILURE_CONTACT_CSR", ERROR_CATEGORY_ACTIONABLE_INPUT, ERROR_CATEGORY_ADVISORY};

    public OneIDTrackerEvent() {
        this.throttle = Tracker.Throttle.NONE;
        this.initialElapsedTimeInMillis = SystemClock.elapsedRealtime();
        this.currentStateParam = new HashMap();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\bG\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00040\f¢\u0006\n\n\u0002\u0010\r\u001a\u0004\bO\u0010PR\u0019\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00040\f¢\u0006\n\n\u0002\u0010\r\u001a\u0004\bR\u0010P¨\u0006S"}, d2 = {"Lcom/disney/id/android/tracker/OneIDTrackerEvent$Companion;", "", "()V", "ERROR_CATEGORY_ACTIONABLE_INPUT", "", "ERROR_CATEGORY_ADVISORY", "ERROR_CATEGORY_CLIENT_FAILURE", "ERROR_CATEGORY_FAILURE_BY_DESIGN", "ERROR_CATEGORY_GUEST_BLOCKED", "ERROR_CATEGORY_PPU_ACTIONABLE_INPUT", "ERROR_CATEGORY_SERVICE_INTERACTION_ERROR", "ERROR_CATEGORY_SEVERITIES", "", "[Ljava/lang/String;", "ERROR_CATEGORY_TIMED_OUT", "ERROR_CATEGORY_UNKNOWN", "ERROR_CODE_AGE_GATED", "ERROR_CODE_ALREADY_OPT_IN", "ERROR_CODE_AUTHORIZATION_INVALID_REFRESH_TOKEN", "ERROR_CODE_BIOMETRICS_ERROR", "ERROR_CODE_BROWSER_LAUNCH_FAILURE", "ERROR_CODE_BUNDLE_LOAD_ERROR", "ERROR_CODE_BUNDLE_READ_ERROR", "ERROR_CODE_CRYPTOGRAPHY_ERROR", "ERROR_CODE_EMAIL_MISMATCH", "ERROR_CODE_EMAIL_VERIFY_ERROR", "ERROR_CODE_EXTRA_RESUME", "ERROR_CODE_GUEST_HANDLER_ERROR", "ERROR_CODE_HEADLESS_DISALLOWED", "ERROR_CODE_HIGH_TRUST_REQUIRED", "ERROR_CODE_INVALID_EMAIL", "ERROR_CODE_INVALID_JSON", "ERROR_CODE_INVALID_LOCATION", "ERROR_CODE_INVALID_LOGIN_VALUE", "ERROR_CODE_INVALID_PROMOTION_ID", "ERROR_CODE_INVALID_RESPONSE", "ERROR_CODE_INVALID_VALUE", "ERROR_CODE_LIGHTBOX_ALREADY_IN_USE", "ERROR_CODE_LOGGING_CONTEXT_FAILURE", "ERROR_CODE_MISSING_VALUE", "ERROR_CODE_NOT_LOGGED_IN", "ERROR_CODE_NO_CONNECTION", "ERROR_CODE_NO_VALID_CAMPAIGN", "ERROR_CODE_PPU_LEGAL", "ERROR_CODE_PPU_SECURITY", "ERROR_CODE_PROFILE_MISSING_EMAIL", "ERROR_CODE_UNEXPECTED_RESPONSE", "ERROR_CODE_USER_CANCELLED", "ERROR_CODE_WEAK_REFERENCE_MISSING", "EVENT_PARAM_ACTION_NAME", "EVENT_PARAM_ANON", "EVENT_PARAM_BROWSER", "EVENT_PARAM_CLIENT_ID", "EVENT_PARAM_CONNECTION_TYPE", "EVENT_PARAM_CONVERSATION_ID", "EVENT_PARAM_DETECTED_COUNTRY", "EVENT_PARAM_DEVICE_TIMESTAMP", "EVENT_PARAM_DIRECT_FLOW_VERSION", "EVENT_PARAM_ERROR_CATEGORY", "EVENT_PARAM_ERROR_CODES", "EVENT_PARAM_ERROR_INFO", "EVENT_PARAM_ID_TOKEN", "EVENT_PARAM_LIGHTBOX_VERSION", "EVENT_PARAM_MAKE_MODEL", "EVENT_PARAM_MOBILE_LAUNCH_ID", "EVENT_PARAM_OS", "EVENT_PARAM_PROBLEM", "EVENT_PARAM_PROCESS_TIME", "EVENT_PARAM_REPORTING", "EVENT_PARAM_REPORTING_CONTEXT", "EVENT_PARAM_REPORTING_SOURCE", "EVENT_PARAM_SDK_INSTALL_UUID", "EVENT_PARAM_SDK_VERSION", "EVENT_PARAM_SUCCESS", "EVENT_PARAM_SWID", "EVENT_PARAM_THROTTLE_LEVEL", "EVENT_PARAM_TIMESTAMP", "EVENT_PARAM_TRANSACTION_ID", "LEGAL_PPU_CODES", "getLEGAL_PPU_CODES", "()[Ljava/lang/String;", "PROFILE_PPU_CODES", "getPROFILE_PPU_CODES", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final String[] getLEGAL_PPU_CODES() {
            return OneIDTrackerEvent.LEGAL_PPU_CODES;
        }

        @NotNull
        public final String[] getPROFILE_PPU_CODES() {
            return OneIDTrackerEvent.PROFILE_PPU_CODES;
        }
    }

    @NotNull
    public final TrackerEventKey getKey$OneID_release() {
        String transactionId$OneID_release = getTransactionId$OneID_release();
        if (transactionId$OneID_release == null) {
            transactionId$OneID_release = getConversationId$OneID_release();
        }
        String str = (String) this.currentStateParam.get(EVENT_PARAM_ACTION_NAME);
        if (str == null) {
            str = "actionNameMissing";
        }
        return new TrackerEventKey(transactionId$OneID_release, str);
    }

    @NotNull
    /* renamed from: getThrottle$OneID_release, reason: from getter */
    public final Tracker.Throttle getThrottle() {
        return this.throttle;
    }

    public final void setThrottle$OneID_release(@NotNull Tracker.Throttle throttle) {
        Intrinsics.checkNotNullParameter(throttle, "<set-?>");
        this.throttle = throttle;
    }

    /* renamed from: getInitialElapsedTimeInMillis$OneID_release, reason: from getter */
    public final long getInitialElapsedTimeInMillis() {
        return this.initialElapsedTimeInMillis;
    }

    public final void setInitialElapsedTimeInMillis$OneID_release(long j) {
        this.initialElapsedTimeInMillis = j;
    }

    @NotNull
    public final Map<String, String> getCurrentStateParam$OneID_release() {
        return this.currentStateParam;
    }

    @NotNull
    public final String getConversationId$OneID_release() {
        String str = (String) this.currentStateParam.get(EVENT_PARAM_CONVERSATION_ID);
        return str == null ? "" : str;
    }

    @Nullable
    public final String getTransactionId$OneID_release() {
        return (String) this.currentStateParam.get("transaction_id");
    }

    public final boolean getProblem$OneID_release() {
        return Intrinsics.areEqual(Characteristics.TRUE, this.currentStateParam.get(EVENT_PARAM_PROBLEM));
    }

    @Nullable
    /* renamed from: getReportBase64$OneID_release, reason: from getter */
    public final String getReportBase64() {
        return this.reportBase64;
    }

    public final void setReportBase64$OneID_release(@Nullable String str) {
        this.reportBase64 = str;
    }

    @Nullable
    public final String getReportingData$OneID_release() {
        return (String) this.currentStateParam.get(EVENT_PARAM_REPORTING);
    }

    public final void setReportingData$OneID_release(@Nullable String str) {
        if (str == null) {
            this.currentStateParam.remove(EVENT_PARAM_REPORTING);
        } else {
            this.currentStateParam.put(EVENT_PARAM_REPORTING, str);
        }
    }

    @Nullable
    public final String getReportingSource$OneID_release() {
        return (String) this.currentStateParam.get("source");
    }

    public final void setReportingSource$OneID_release(@Nullable String str) {
        if (str == null) {
            this.currentStateParam.remove("source");
        } else {
            this.currentStateParam.put("source", str);
        }
    }

    @Nullable
    public final String getReportingContext$OneID_release() {
        return (String) this.currentStateParam.get("context");
    }

    public final void setReportingContext$OneID_release(@Nullable String str) {
        if (str == null) {
            this.currentStateParam.remove("context");
        } else {
            this.currentStateParam.put("context", str);
        }
    }

    @Nullable
    public final String getCategory$OneID_release() {
        return (String) this.currentStateParam.get(EVENT_PARAM_ERROR_CATEGORY);
    }

    @Nullable
    public final String getCodes$OneID_release() {
        return (String) this.currentStateParam.get(EVENT_PARAM_ERROR_CODES);
    }

    @Nullable
    public final String getInfo$OneID_release() {
        return (String) this.currentStateParam.get(EVENT_PARAM_ERROR_INFO);
    }

    @Nullable
    public final String getIdToken$OneID_release() {
        return (String) this.currentStateParam.get(EVENT_PARAM_ID_TOKEN);
    }

    public final void setIdToken$OneID_release(@Nullable String str) {
        if (str == null) {
            return;
        }
        if (StringsKt.isBlank(str)) {
            str = "blank";
        }
        if (str.length() <= 6) {
            this.currentStateParam.put(EVENT_PARAM_ID_TOKEN, str);
            return;
        }
        Map map = this.currentStateParam;
        String strSubstring = str.substring(str.length() - 6);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        map.put(EVENT_PARAM_ID_TOKEN, "..." + strSubstring);
    }

    @Nullable
    public final String getDetectedCountry$OneID_release() {
        return (String) this.currentStateParam.get(EVENT_PARAM_DETECTED_COUNTRY);
    }

    @Nullable
    public final String getThrottleLevel$OneID_release() {
        return (String) this.currentStateParam.get(EVENT_PARAM_THROTTLE_LEVEL);
    }

    public final void setThrottleLevel$OneID_release(@Nullable String str) {
        if (str == null) {
            this.currentStateParam.remove(EVENT_PARAM_THROTTLE_LEVEL);
        } else {
            this.currentStateParam.put(EVENT_PARAM_THROTTLE_LEVEL, str);
        }
    }

    public /* synthetic */ OneIDTrackerEvent(String str, boolean z, EventAction eventAction, String str2, String str3, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z, eventAction, str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? false : z2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OneIDTrackerEvent(@Nullable String str, boolean z, @NotNull EventAction action, @NotNull String swid, @Nullable String str2, boolean z2) {
        this();
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(swid, "swid");
        this.throttle = action.getThrottle();
        this.initialElapsedTimeInMillis = SystemClock.elapsedRealtime();
        if (str != null) {
            this.currentStateParam.put(EVENT_PARAM_CONVERSATION_ID, str);
        } else {
            Map map = this.currentStateParam;
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            map.put(EVENT_PARAM_CONVERSATION_ID, string);
        }
        if (z) {
            Map map2 = this.currentStateParam;
            String string2 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            map2.put("transaction_id", string2);
        }
        this.currentStateParam.put("swid", swid);
        if (StringsKt.contains$default((CharSequence) swid, '{', false, 2, (Object) null)) {
            this.currentStateParam.put(EVENT_PARAM_ANON, "false");
        } else {
            this.currentStateParam.put(EVENT_PARAM_ANON, Characteristics.TRUE);
        }
        this.currentStateParam.put(EVENT_PARAM_ACTION_NAME, action.getActionName());
        this.currentStateParam.put(EVENT_PARAM_PROCESS_TIME, "1");
        this.currentStateParam.put(EVENT_PARAM_THROTTLE_LEVEL, this.throttle.name());
        this.currentStateParam.put(EVENT_PARAM_PROBLEM, String.valueOf(z2));
        if (str2 != null) {
            this.currentStateParam.put(EVENT_PARAM_ERROR_INFO, str2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OneIDTrackerEvent(@NotNull Map<String, ? extends Object> webEvent) {
        this();
        Intrinsics.checkNotNullParameter(webEvent, "webEvent");
        for (Map.Entry<String, ? extends Object> entry : webEvent.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                this.currentStateParam.put(entry.getKey(), value.toString());
            }
        }
        String str = (String) this.currentStateParam.remove(EVENT_PARAM_SDK_VERSION);
        if (str != null) {
            this.currentStateParam.put(EVENT_PARAM_DIRECT_FLOW_VERSION, str);
        }
    }

    public final void setParameter$OneID_release(@NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.currentStateParam.put(key, value);
    }

    public static /* synthetic */ void appendCodes$OneID_release$default(OneIDTrackerEvent oneIDTrackerEvent, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        oneIDTrackerEvent.appendCodes$OneID_release(str, str2, str3);
    }

    public final void appendCodes$OneID_release(@Nullable String codes, @Nullable String category, @Nullable String info) {
        if (info != null && info.length() != 0) {
            if (this.currentStateParam.get(EVENT_PARAM_ERROR_INFO) != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("%s,%s", Arrays.copyOf(new Object[]{String.valueOf(this.currentStateParam.get(EVENT_PARAM_ERROR_INFO)), info}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                this.currentStateParam.put(EVENT_PARAM_ERROR_INFO, str);
            } else {
                this.currentStateParam.put(EVENT_PARAM_ERROR_INFO, info);
            }
        }
        if (codes != null && codes.length() != 0) {
            if (this.currentStateParam.get(EVENT_PARAM_ERROR_CODES) != null) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String str2 = String.format("%s,%s", Arrays.copyOf(new Object[]{String.valueOf(this.currentStateParam.get(EVENT_PARAM_ERROR_CODES)), codes}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                this.currentStateParam.put(EVENT_PARAM_ERROR_CODES, str2);
            } else {
                this.currentStateParam.put(EVENT_PARAM_ERROR_CODES, codes);
            }
        }
        if (category == null || category.length() == 0) {
            return;
        }
        if (this.currentStateParam.get(EVENT_PARAM_ERROR_CATEGORY) != null) {
            this.currentStateParam.put(EVENT_PARAM_ERROR_CATEGORY, mostSevereErrorCategory(category, String.valueOf(this.currentStateParam.get(EVENT_PARAM_ERROR_CATEGORY))));
        } else {
            this.currentStateParam.put(EVENT_PARAM_ERROR_CATEGORY, category);
        }
    }

    private final String mostSevereErrorCategory(String category, String oldCategory) {
        String[] strArr = ERROR_CATEGORY_SEVERITIES;
        int iIndexOf = ArraysKt.indexOf(strArr, category);
        return (iIndexOf == -1 || iIndexOf > ArraysKt.indexOf(strArr, oldCategory)) ? oldCategory : category;
    }

    public final void stopTiming$OneID_release() {
        this.currentStateParam.put(EVENT_PARAM_PROCESS_TIME, String.valueOf(SystemClock.elapsedRealtime() - this.initialElapsedTimeInMillis));
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (String str : this.currentStateParam.keySet()) {
            sb.append(str);
            sb.append(" : ");
            sb.append(this.currentStateParam.get(str) != null ? String.valueOf(this.currentStateParam.get(str)) : "null");
            sb.append(", ");
        }
        sb.append("}");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(OneIDTrackerEvent.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.disney.id.android.tracker.OneIDTrackerEvent");
        OneIDTrackerEvent oneIDTrackerEvent = (OneIDTrackerEvent) other;
        return this.throttle == oneIDTrackerEvent.throttle && this.initialElapsedTimeInMillis == oneIDTrackerEvent.initialElapsedTimeInMillis && Intrinsics.areEqual(this.currentStateParam, oneIDTrackerEvent.currentStateParam);
    }

    public int hashCode() {
        return (((this.throttle.hashCode() * 31) + Long.hashCode(this.initialElapsedTimeInMillis)) * 31) + this.currentStateParam.hashCode();
    }
}
