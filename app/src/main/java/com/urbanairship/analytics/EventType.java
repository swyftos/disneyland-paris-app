package com.urbanairship.analytics;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, m1836d2 = {"Lcom/urbanairship/analytics/EventType;", "", "reportingName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getReportingName", "()Ljava/lang/String;", "APP_FOREGROUND", "APP_BACKGROUND", "SCREEN_TRACKING", "ASSOCIATE_IDENTIFIERS", "INSTALL_ATTRIBUTION", "INTERACTIVE_NOTIFICATION_ACTION", "PUSH_ARRIVED", "REGION_ENTER", "REGION_EXIT", "CUSTOM_EVENT", "FEATURE_FLAG_INTERACTION", "IN_APP_DISPLAY", "IN_APP_RESOLUTION", "IN_APP_BUTTON_TAP", "IN_APP_PERMISSION_RESULT", "IN_APP_FORM_DISPLAY", "IN_APP_FORM_RESULT", "IN_APP_GESTURE", "IN_APP_PAGER_COMPLETED", "IN_APP_PAGER_SUMMARY", "IN_APP_PAGE_SWIPE", "IN_APP_PAGE_VIEW", "IN_APP_PAGE_ACTION", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public enum EventType {
    APP_FOREGROUND("app_foreground"),
    APP_BACKGROUND("app_background"),
    SCREEN_TRACKING("screen_tracking"),
    ASSOCIATE_IDENTIFIERS("associate_identifiers"),
    INSTALL_ATTRIBUTION("install_attribution"),
    INTERACTIVE_NOTIFICATION_ACTION("interactive_notification_action"),
    PUSH_ARRIVED("push_arrived"),
    REGION_ENTER("region_event"),
    REGION_EXIT("region_event"),
    CUSTOM_EVENT("enhanced_custom_event"),
    FEATURE_FLAG_INTERACTION("feature_flag_interaction"),
    IN_APP_DISPLAY("in_app_display"),
    IN_APP_RESOLUTION("in_app_resolution"),
    IN_APP_BUTTON_TAP("in_app_button_tap"),
    IN_APP_PERMISSION_RESULT("in_app_permission_result"),
    IN_APP_FORM_DISPLAY("in_app_form_display"),
    IN_APP_FORM_RESULT("in_app_form_result"),
    IN_APP_GESTURE("in_app_gesture"),
    IN_APP_PAGER_COMPLETED("in_app_pager_completed"),
    IN_APP_PAGER_SUMMARY("in_app_pager_summary"),
    IN_APP_PAGE_SWIPE("in_app_page_swipe"),
    IN_APP_PAGE_VIEW("in_app_page_view"),
    IN_APP_PAGE_ACTION("in_app_page_action");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String reportingName;

    @NotNull
    public static EnumEntries<EventType> getEntries() {
        return $ENTRIES;
    }

    EventType(String str) {
        this.reportingName = str;
    }

    @NotNull
    public final String getReportingName() {
        return this.reportingName;
    }
}
