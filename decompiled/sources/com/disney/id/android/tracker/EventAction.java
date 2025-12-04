package com.disney.id.android.tracker;

import com.disney.id.android.lightbox.LightboxActivity;
import com.disney.id.android.tracker.Tracker;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\bJ\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bN¨\u0006O"}, d2 = {"Lcom/disney/id/android/tracker/EventAction;", "", LightboxActivity.ACTION_NAME_EXTRA, "", "throttle", "Lcom/disney/id/android/tracker/Tracker$Throttle;", "(Ljava/lang/String;ILjava/lang/String;Lcom/disney/id/android/tracker/Tracker$Throttle;)V", "getActionName", "()Ljava/lang/String;", "throttleAmount", "API_BEGIN_RECOVERY", "API_COMPLETE_RECOVERY", "API_GET_EDITABLE_PROFILE_FIELDS", "API_GET_GUEST", "API_GET_GUESTFLOW", "API_GET_GUEST_SYNC", "API_GET_IDENTITYFLOWCONFIG", "API_GET_INLINE_NEWSLETTERS", "API_GET_LOGGED_IN_STATUS", "API_GET_REGISTER_FLOW_CONFIG", "API_GET_SITECONFIG", "API_GET_SWID", "API_GET_TOKEN", "API_GET_TRUST_STATE_STATUS", "API_GET_UNID", "API_GET_UNID_ASYNC", "API_GET_PASSWORD_SCORE", "API_INIT", "API_LAUNCH_EMAIL_VERIFICATION", "API_LAUNCH_IDENTITYFLOW", "API_LAUNCH_LOGIN", "API_LAUNCH_NEWSLETTERS", "API_LAUNCH_PROFILE", "API_LAUNCH_REAUTH", "API_LAUNCH_REGISTRATION", "API_LOGIN", "API_LOGOUT", "API_REGISTER", "API_RESOLVE_PPU", "API_SET_DEFAULT_OPTIONS", "API_SET_DELEGATE", "API_SET_EDITABLE_PROFILE_FIELDS", "API_SET_INLINE_NEWSLETTERS", "API_UPDATE_MARKETING", "API_VALIDATE_OTP", "EVENT_CREATE", "EVENT_EXTERNAL_LINK", "EVENT_INITIALIZED", "EVENT_LAUNCH_EXPIRED_SESSION", "EVENT_LAUNCH_PPU", "EVENT_LOGIN", "LOG_BIOMETRIC_CHECK", "LOG_BIOMETRIC_OPTOUT", "LOG_BIOMETRIC_WEAK", "LOG_CLEAR_STORAGE", "LOG_ERROR_RESUME_COROUTINE", "LOG_EXTERNAL_REFRESH", "LOG_GET_BUNDLE", "LOG_GET_CONFIG_CACHED", "LOG_GET_CONFIG_DATA", "LOG_INSTALL", "LOG_INSTANTIATE_WEBVIEW", "LOG_LIGHTBOX_CLOSE", "LOG_LIGHTBOX_TIMEOUT", "LOG_MIGRATE", "SERVICE_CLICKBACK_CHANGE_PASSWORD", "SERVICE_DOWNLOAD_BUNDLE", "SERVICE_DOWNLOAD_CONFIG", "SERVICE_GUESTFLOW", "SERVICE_LOGIN", "SERVICE_LOGIN_RECOVERY", "SERVICE_LOGOUT", "SERVICE_OTP_REDEEM", "SERVICE_REFRESH_GUEST", "SERVICE_REFRESH_TOKEN", "SERVICE_REGISTER", "SERVICE_OTP_RECOVERY", "SERVICE_UPDATE_GUEST", "SERVICE_UPDATE_MARKETING", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EventAction {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EventAction[] $VALUES;
    public static final EventAction API_BEGIN_RECOVERY;
    public static final EventAction API_COMPLETE_RECOVERY;
    public static final EventAction API_GET_EDITABLE_PROFILE_FIELDS;
    public static final EventAction API_GET_GUEST;
    public static final EventAction API_GET_GUESTFLOW;
    public static final EventAction API_GET_GUEST_SYNC;
    public static final EventAction API_GET_IDENTITYFLOWCONFIG;
    public static final EventAction API_GET_INLINE_NEWSLETTERS;
    public static final EventAction API_GET_LOGGED_IN_STATUS;
    public static final EventAction API_GET_PASSWORD_SCORE;
    public static final EventAction API_GET_REGISTER_FLOW_CONFIG;
    public static final EventAction API_GET_SITECONFIG;
    public static final EventAction API_GET_SWID;
    public static final EventAction API_GET_TOKEN;
    public static final EventAction API_GET_TRUST_STATE_STATUS;
    public static final EventAction API_GET_UNID;
    public static final EventAction API_GET_UNID_ASYNC;
    public static final EventAction API_INIT;
    public static final EventAction API_LAUNCH_EMAIL_VERIFICATION;
    public static final EventAction API_LAUNCH_IDENTITYFLOW;
    public static final EventAction API_LAUNCH_LOGIN;
    public static final EventAction API_LAUNCH_NEWSLETTERS;
    public static final EventAction API_LAUNCH_PROFILE;
    public static final EventAction API_LAUNCH_REAUTH;
    public static final EventAction API_LAUNCH_REGISTRATION;
    public static final EventAction API_LOGIN;
    public static final EventAction API_LOGOUT;
    public static final EventAction API_REGISTER;
    public static final EventAction API_RESOLVE_PPU;
    public static final EventAction API_SET_DEFAULT_OPTIONS;
    public static final EventAction API_SET_DELEGATE;
    public static final EventAction API_SET_EDITABLE_PROFILE_FIELDS;
    public static final EventAction API_SET_INLINE_NEWSLETTERS;
    public static final EventAction API_UPDATE_MARKETING;
    public static final EventAction API_VALIDATE_OTP;
    public static final EventAction EVENT_CREATE;
    public static final EventAction EVENT_EXTERNAL_LINK;
    public static final EventAction EVENT_INITIALIZED;
    public static final EventAction EVENT_LAUNCH_EXPIRED_SESSION;
    public static final EventAction EVENT_LAUNCH_PPU;
    public static final EventAction EVENT_LOGIN;
    public static final EventAction LOG_BIOMETRIC_CHECK;
    public static final EventAction LOG_BIOMETRIC_OPTOUT;
    public static final EventAction LOG_BIOMETRIC_WEAK;
    public static final EventAction LOG_CLEAR_STORAGE;
    public static final EventAction LOG_ERROR_RESUME_COROUTINE;
    public static final EventAction LOG_EXTERNAL_REFRESH;
    public static final EventAction LOG_GET_BUNDLE;
    public static final EventAction LOG_GET_CONFIG_CACHED;
    public static final EventAction LOG_GET_CONFIG_DATA;
    public static final EventAction LOG_INSTALL;
    public static final EventAction LOG_INSTANTIATE_WEBVIEW;
    public static final EventAction LOG_LIGHTBOX_CLOSE;
    public static final EventAction LOG_LIGHTBOX_TIMEOUT;
    public static final EventAction LOG_MIGRATE;
    public static final EventAction SERVICE_CLICKBACK_CHANGE_PASSWORD;
    public static final EventAction SERVICE_DOWNLOAD_BUNDLE;
    public static final EventAction SERVICE_DOWNLOAD_CONFIG;
    public static final EventAction SERVICE_GUESTFLOW;
    public static final EventAction SERVICE_LOGIN;
    public static final EventAction SERVICE_LOGIN_RECOVERY;
    public static final EventAction SERVICE_LOGOUT;
    public static final EventAction SERVICE_OTP_RECOVERY;
    public static final EventAction SERVICE_OTP_REDEEM;
    public static final EventAction SERVICE_REFRESH_GUEST;
    public static final EventAction SERVICE_REFRESH_TOKEN;
    public static final EventAction SERVICE_REGISTER;
    public static final EventAction SERVICE_UPDATE_GUEST;
    public static final EventAction SERVICE_UPDATE_MARKETING;
    private final String actionName;
    private final Tracker.Throttle throttle;

    private static final /* synthetic */ EventAction[] $values() {
        return new EventAction[]{API_BEGIN_RECOVERY, API_COMPLETE_RECOVERY, API_GET_EDITABLE_PROFILE_FIELDS, API_GET_GUEST, API_GET_GUESTFLOW, API_GET_GUEST_SYNC, API_GET_IDENTITYFLOWCONFIG, API_GET_INLINE_NEWSLETTERS, API_GET_LOGGED_IN_STATUS, API_GET_REGISTER_FLOW_CONFIG, API_GET_SITECONFIG, API_GET_SWID, API_GET_TOKEN, API_GET_TRUST_STATE_STATUS, API_GET_UNID, API_GET_UNID_ASYNC, API_GET_PASSWORD_SCORE, API_INIT, API_LAUNCH_EMAIL_VERIFICATION, API_LAUNCH_IDENTITYFLOW, API_LAUNCH_LOGIN, API_LAUNCH_NEWSLETTERS, API_LAUNCH_PROFILE, API_LAUNCH_REAUTH, API_LAUNCH_REGISTRATION, API_LOGIN, API_LOGOUT, API_REGISTER, API_RESOLVE_PPU, API_SET_DEFAULT_OPTIONS, API_SET_DELEGATE, API_SET_EDITABLE_PROFILE_FIELDS, API_SET_INLINE_NEWSLETTERS, API_UPDATE_MARKETING, API_VALIDATE_OTP, EVENT_CREATE, EVENT_EXTERNAL_LINK, EVENT_INITIALIZED, EVENT_LAUNCH_EXPIRED_SESSION, EVENT_LAUNCH_PPU, EVENT_LOGIN, LOG_BIOMETRIC_CHECK, LOG_BIOMETRIC_OPTOUT, LOG_BIOMETRIC_WEAK, LOG_CLEAR_STORAGE, LOG_ERROR_RESUME_COROUTINE, LOG_EXTERNAL_REFRESH, LOG_GET_BUNDLE, LOG_GET_CONFIG_CACHED, LOG_GET_CONFIG_DATA, LOG_INSTALL, LOG_INSTANTIATE_WEBVIEW, LOG_LIGHTBOX_CLOSE, LOG_LIGHTBOX_TIMEOUT, LOG_MIGRATE, SERVICE_CLICKBACK_CHANGE_PASSWORD, SERVICE_DOWNLOAD_BUNDLE, SERVICE_DOWNLOAD_CONFIG, SERVICE_GUESTFLOW, SERVICE_LOGIN, SERVICE_LOGIN_RECOVERY, SERVICE_LOGOUT, SERVICE_OTP_REDEEM, SERVICE_REFRESH_GUEST, SERVICE_REFRESH_TOKEN, SERVICE_REGISTER, SERVICE_OTP_RECOVERY, SERVICE_UPDATE_GUEST, SERVICE_UPDATE_MARKETING};
    }

    @NotNull
    public static EnumEntries<EventAction> getEntries() {
        return $ENTRIES;
    }

    public static EventAction valueOf(String str) {
        return (EventAction) Enum.valueOf(EventAction.class, str);
    }

    public static EventAction[] values() {
        return (EventAction[]) $VALUES.clone();
    }

    private EventAction(String str, int i, String str2, Tracker.Throttle throttle) {
        this.actionName = str2;
        this.throttle = throttle;
    }

    @NotNull
    public final String getActionName() {
        return this.actionName;
    }

    static {
        Tracker.Throttle throttle = Tracker.Throttle.NONE;
        API_BEGIN_RECOVERY = new EventAction("API_BEGIN_RECOVERY", 0, "api:begin:recovery", throttle);
        API_COMPLETE_RECOVERY = new EventAction("API_COMPLETE_RECOVERY", 1, "api:complete:recovery", throttle);
        API_GET_EDITABLE_PROFILE_FIELDS = new EventAction("API_GET_EDITABLE_PROFILE_FIELDS", 2, "api:get:editableprofilefields", throttle);
        Tracker.Throttle throttle2 = Tracker.Throttle.HIGH;
        API_GET_GUEST = new EventAction("API_GET_GUEST", 3, "api:get:guest", throttle2);
        API_GET_GUESTFLOW = new EventAction("API_GET_GUESTFLOW", 4, "api:get:guestflow", throttle);
        API_GET_GUEST_SYNC = new EventAction("API_GET_GUEST_SYNC", 5, "api:get:guest:sync", throttle2);
        API_GET_IDENTITYFLOWCONFIG = new EventAction("API_GET_IDENTITYFLOWCONFIG", 6, "api:get:identityflowconfig", throttle);
        API_GET_INLINE_NEWSLETTERS = new EventAction("API_GET_INLINE_NEWSLETTERS", 7, "api:get:inlinenewsletters", throttle);
        API_GET_LOGGED_IN_STATUS = new EventAction("API_GET_LOGGED_IN_STATUS", 8, "api:get:loggedinstatus", throttle2);
        API_GET_REGISTER_FLOW_CONFIG = new EventAction("API_GET_REGISTER_FLOW_CONFIG", 9, "api:get:registerflowconfig", throttle);
        API_GET_SITECONFIG = new EventAction("API_GET_SITECONFIG", 10, "api:get:siteconfig", throttle);
        API_GET_SWID = new EventAction("API_GET_SWID", 11, "api:get:swid", throttle2);
        Tracker.Throttle throttle3 = Tracker.Throttle.NORMAL;
        API_GET_TOKEN = new EventAction("API_GET_TOKEN", 12, "api:get:token", throttle3);
        API_GET_TRUST_STATE_STATUS = new EventAction("API_GET_TRUST_STATE_STATUS", 13, "api:get:truststatestatus", throttle2);
        API_GET_UNID = new EventAction("API_GET_UNID", 14, "api:get:unid", throttle3);
        API_GET_UNID_ASYNC = new EventAction("API_GET_UNID_ASYNC", 15, "api:get:unid:async", throttle3);
        API_GET_PASSWORD_SCORE = new EventAction("API_GET_PASSWORD_SCORE", 16, "api:get:passwordscore", throttle2);
        API_INIT = new EventAction("API_INIT", 17, "api:init", throttle);
        API_LAUNCH_EMAIL_VERIFICATION = new EventAction("API_LAUNCH_EMAIL_VERIFICATION", 18, "api:launch:emailverification", throttle);
        API_LAUNCH_IDENTITYFLOW = new EventAction("API_LAUNCH_IDENTITYFLOW", 19, "api:launch:identityflow", throttle);
        API_LAUNCH_LOGIN = new EventAction("API_LAUNCH_LOGIN", 20, "api:launch:login", throttle);
        API_LAUNCH_NEWSLETTERS = new EventAction("API_LAUNCH_NEWSLETTERS", 21, "api:launch:newsletters", throttle);
        API_LAUNCH_PROFILE = new EventAction("API_LAUNCH_PROFILE", 22, "api:launch:profile", throttle);
        API_LAUNCH_REAUTH = new EventAction("API_LAUNCH_REAUTH", 23, "api:launch:reauth", throttle);
        API_LAUNCH_REGISTRATION = new EventAction("API_LAUNCH_REGISTRATION", 24, "api:launch:registration", throttle);
        API_LOGIN = new EventAction("API_LOGIN", 25, "api:login", throttle);
        API_LOGOUT = new EventAction("API_LOGOUT", 26, "api:logout", throttle);
        API_REGISTER = new EventAction("API_REGISTER", 27, "api:register", throttle);
        API_RESOLVE_PPU = new EventAction("API_RESOLVE_PPU", 28, "api:resolve:ppu", throttle);
        API_SET_DEFAULT_OPTIONS = new EventAction("API_SET_DEFAULT_OPTIONS", 29, "api:set:defaultoptions", throttle2);
        API_SET_DELEGATE = new EventAction("API_SET_DELEGATE", 30, "api:set:delegate", throttle2);
        API_SET_EDITABLE_PROFILE_FIELDS = new EventAction("API_SET_EDITABLE_PROFILE_FIELDS", 31, "api:set:editableprofilefields", throttle);
        API_SET_INLINE_NEWSLETTERS = new EventAction("API_SET_INLINE_NEWSLETTERS", 32, "api:set:inlinenewsletters", throttle);
        API_UPDATE_MARKETING = new EventAction("API_UPDATE_MARKETING", 33, "api:update:marketing", throttle);
        API_VALIDATE_OTP = new EventAction("API_VALIDATE_OTP", 34, "api:validate:otp", throttle);
        EVENT_CREATE = new EventAction("EVENT_CREATE", 35, "event:create", throttle);
        EVENT_EXTERNAL_LINK = new EventAction("EVENT_EXTERNAL_LINK", 36, "event:externallink", throttle);
        EVENT_INITIALIZED = new EventAction("EVENT_INITIALIZED", 37, "event:initialized", throttle3);
        EVENT_LAUNCH_EXPIRED_SESSION = new EventAction("EVENT_LAUNCH_EXPIRED_SESSION", 38, "event:launch:expiredsession", throttle);
        EVENT_LAUNCH_PPU = new EventAction("EVENT_LAUNCH_PPU", 39, "event:launch:ppu", throttle);
        EVENT_LOGIN = new EventAction("EVENT_LOGIN", 40, "event:login", throttle);
        LOG_BIOMETRIC_CHECK = new EventAction("LOG_BIOMETRIC_CHECK", 41, "log:biometric:check", throttle);
        LOG_BIOMETRIC_OPTOUT = new EventAction("LOG_BIOMETRIC_OPTOUT", 42, "log:biometric:optout", throttle);
        LOG_BIOMETRIC_WEAK = new EventAction("LOG_BIOMETRIC_WEAK", 43, "log:biometric:weak", throttle);
        LOG_CLEAR_STORAGE = new EventAction("LOG_CLEAR_STORAGE", 44, "log:clear:storage", throttle);
        LOG_ERROR_RESUME_COROUTINE = new EventAction("LOG_ERROR_RESUME_COROUTINE", 45, "log:error:resumecoroutine", throttle);
        LOG_EXTERNAL_REFRESH = new EventAction("LOG_EXTERNAL_REFRESH", 46, "log:external:refresh", throttle);
        LOG_GET_BUNDLE = new EventAction("LOG_GET_BUNDLE", 47, "log:get:bundle", throttle3);
        LOG_GET_CONFIG_CACHED = new EventAction("LOG_GET_CONFIG_CACHED", 48, "log:get:config:cached", throttle3);
        LOG_GET_CONFIG_DATA = new EventAction("LOG_GET_CONFIG_DATA", 49, "log:get:config:data", throttle3);
        LOG_INSTALL = new EventAction("LOG_INSTALL", 50, "log:install", throttle);
        LOG_INSTANTIATE_WEBVIEW = new EventAction("LOG_INSTANTIATE_WEBVIEW", 51, "log:instantiate:webview", throttle);
        LOG_LIGHTBOX_CLOSE = new EventAction("LOG_LIGHTBOX_CLOSE", 52, "log:lightbox:close", throttle);
        LOG_LIGHTBOX_TIMEOUT = new EventAction("LOG_LIGHTBOX_TIMEOUT", 53, "log:lightbox:timeout", throttle);
        LOG_MIGRATE = new EventAction("LOG_MIGRATE", 54, "log:migrate", throttle);
        SERVICE_CLICKBACK_CHANGE_PASSWORD = new EventAction("SERVICE_CLICKBACK_CHANGE_PASSWORD", 55, "service:clickback:changepassword", throttle);
        SERVICE_DOWNLOAD_BUNDLE = new EventAction("SERVICE_DOWNLOAD_BUNDLE", 56, "service:download:bundle", throttle3);
        SERVICE_DOWNLOAD_CONFIG = new EventAction("SERVICE_DOWNLOAD_CONFIG", 57, "service:download:config", throttle3);
        SERVICE_GUESTFLOW = new EventAction("SERVICE_GUESTFLOW", 58, "service:guestflow", throttle);
        SERVICE_LOGIN = new EventAction("SERVICE_LOGIN", 59, "service:login", throttle);
        SERVICE_LOGIN_RECOVERY = new EventAction("SERVICE_LOGIN_RECOVERY", 60, "service:login:recovery", throttle);
        SERVICE_LOGOUT = new EventAction("SERVICE_LOGOUT", 61, "service:logout", throttle);
        SERVICE_OTP_REDEEM = new EventAction("SERVICE_OTP_REDEEM", 62, "service:otpredeem", throttle);
        SERVICE_REFRESH_GUEST = new EventAction("SERVICE_REFRESH_GUEST", 63, "service:refresh:guest", throttle);
        SERVICE_REFRESH_TOKEN = new EventAction("SERVICE_REFRESH_TOKEN", 64, "service:refresh:token", throttle);
        SERVICE_REGISTER = new EventAction("SERVICE_REGISTER", 65, "service:register", throttle);
        SERVICE_OTP_RECOVERY = new EventAction("SERVICE_OTP_RECOVERY", 66, "service:otprecovery", throttle);
        SERVICE_UPDATE_GUEST = new EventAction("SERVICE_UPDATE_GUEST", 67, "service:update:guest", throttle);
        SERVICE_UPDATE_MARKETING = new EventAction("SERVICE_UPDATE_MARKETING", 68, "service:update:marketing", throttle);
        EventAction[] eventActionArr$values = $values();
        $VALUES = eventActionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(eventActionArr$values);
    }

    @NotNull
    /* renamed from: throttleAmount, reason: from getter */
    public final Tracker.Throttle getThrottle() {
        return this.throttle;
    }
}
