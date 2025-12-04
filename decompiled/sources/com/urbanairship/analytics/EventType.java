package com.urbanairship.analytics;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/urbanairship/analytics/EventType;", "", "reportingName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getReportingName", "()Ljava/lang/String;", "APP_FOREGROUND", "APP_BACKGROUND", "SCREEN_TRACKING", "ASSOCIATE_IDENTIFIERS", "INSTALL_ATTRIBUTION", "INTERACTIVE_NOTIFICATION_ACTION", "PUSH_ARRIVED", "REGION_ENTER", "REGION_EXIT", "CUSTOM_EVENT", "FEATURE_FLAG_INTERACTION", "IN_APP_DISPLAY", "IN_APP_RESOLUTION", "IN_APP_BUTTON_TAP", "IN_APP_PERMISSION_RESULT", "IN_APP_FORM_DISPLAY", "IN_APP_FORM_RESULT", "IN_APP_GESTURE", "IN_APP_PAGER_COMPLETED", "IN_APP_PAGER_SUMMARY", "IN_APP_PAGE_SWIPE", "IN_APP_PAGE_VIEW", "IN_APP_PAGE_ACTION", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EventType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EventType[] $VALUES;
    private final String reportingName;
    public static final EventType APP_FOREGROUND = new EventType("APP_FOREGROUND", 0, "app_foreground");
    public static final EventType APP_BACKGROUND = new EventType("APP_BACKGROUND", 1, "app_background");
    public static final EventType SCREEN_TRACKING = new EventType("SCREEN_TRACKING", 2, "screen_tracking");
    public static final EventType ASSOCIATE_IDENTIFIERS = new EventType("ASSOCIATE_IDENTIFIERS", 3, "associate_identifiers");
    public static final EventType INSTALL_ATTRIBUTION = new EventType("INSTALL_ATTRIBUTION", 4, "install_attribution");
    public static final EventType INTERACTIVE_NOTIFICATION_ACTION = new EventType("INTERACTIVE_NOTIFICATION_ACTION", 5, "interactive_notification_action");
    public static final EventType PUSH_ARRIVED = new EventType("PUSH_ARRIVED", 6, "push_arrived");
    public static final EventType REGION_ENTER = new EventType("REGION_ENTER", 7, "region_event");
    public static final EventType REGION_EXIT = new EventType("REGION_EXIT", 8, "region_event");
    public static final EventType CUSTOM_EVENT = new EventType("CUSTOM_EVENT", 9, "enhanced_custom_event");
    public static final EventType FEATURE_FLAG_INTERACTION = new EventType("FEATURE_FLAG_INTERACTION", 10, "feature_flag_interaction");
    public static final EventType IN_APP_DISPLAY = new EventType("IN_APP_DISPLAY", 11, "in_app_display");
    public static final EventType IN_APP_RESOLUTION = new EventType("IN_APP_RESOLUTION", 12, "in_app_resolution");
    public static final EventType IN_APP_BUTTON_TAP = new EventType("IN_APP_BUTTON_TAP", 13, "in_app_button_tap");
    public static final EventType IN_APP_PERMISSION_RESULT = new EventType("IN_APP_PERMISSION_RESULT", 14, "in_app_permission_result");
    public static final EventType IN_APP_FORM_DISPLAY = new EventType("IN_APP_FORM_DISPLAY", 15, "in_app_form_display");
    public static final EventType IN_APP_FORM_RESULT = new EventType("IN_APP_FORM_RESULT", 16, "in_app_form_result");
    public static final EventType IN_APP_GESTURE = new EventType("IN_APP_GESTURE", 17, "in_app_gesture");
    public static final EventType IN_APP_PAGER_COMPLETED = new EventType("IN_APP_PAGER_COMPLETED", 18, "in_app_pager_completed");
    public static final EventType IN_APP_PAGER_SUMMARY = new EventType("IN_APP_PAGER_SUMMARY", 19, "in_app_pager_summary");
    public static final EventType IN_APP_PAGE_SWIPE = new EventType("IN_APP_PAGE_SWIPE", 20, "in_app_page_swipe");
    public static final EventType IN_APP_PAGE_VIEW = new EventType("IN_APP_PAGE_VIEW", 21, "in_app_page_view");
    public static final EventType IN_APP_PAGE_ACTION = new EventType("IN_APP_PAGE_ACTION", 22, "in_app_page_action");

    private static final /* synthetic */ EventType[] $values() {
        return new EventType[]{APP_FOREGROUND, APP_BACKGROUND, SCREEN_TRACKING, ASSOCIATE_IDENTIFIERS, INSTALL_ATTRIBUTION, INTERACTIVE_NOTIFICATION_ACTION, PUSH_ARRIVED, REGION_ENTER, REGION_EXIT, CUSTOM_EVENT, FEATURE_FLAG_INTERACTION, IN_APP_DISPLAY, IN_APP_RESOLUTION, IN_APP_BUTTON_TAP, IN_APP_PERMISSION_RESULT, IN_APP_FORM_DISPLAY, IN_APP_FORM_RESULT, IN_APP_GESTURE, IN_APP_PAGER_COMPLETED, IN_APP_PAGER_SUMMARY, IN_APP_PAGE_SWIPE, IN_APP_PAGE_VIEW, IN_APP_PAGE_ACTION};
    }

    @NotNull
    public static EnumEntries<EventType> getEntries() {
        return $ENTRIES;
    }

    public static EventType valueOf(String str) {
        return (EventType) Enum.valueOf(EventType.class, str);
    }

    public static EventType[] values() {
        return (EventType[]) $VALUES.clone();
    }

    private EventType(String str, int i, String str2) {
        this.reportingName = str2;
    }

    @NotNull
    public final String getReportingName() {
        return this.reportingName;
    }

    static {
        EventType[] eventTypeArr$values = $values();
        $VALUES = eventTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(eventTypeArr$values);
    }
}
