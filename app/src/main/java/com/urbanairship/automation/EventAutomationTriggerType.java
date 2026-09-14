package com.urbanairship.automation;

import androidx.media3.exoplayer.offline.DownloadService;
import com.facebook.react.modules.appstate.AppStateModule;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\u0081\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001!B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006\""}, m1836d2 = {"Lcom/urbanairship/automation/EventAutomationTriggerType;", "", "Lcom/urbanairship/json/JsonSerializable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue$urbanairship_automation_release", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "FOREGROUND", "BACKGROUND", "SCREEN", "VERSION", "APP_INIT", "REGION_ENTER", "REGION_EXIT", "CUSTOM_EVENT_COUNT", "CUSTOM_EVENT_VALUE", "FEATURE_FLAG_INTERACTION", "ACTIVE_SESSION", "IN_APP_DISPLAY", "IN_APP_RESOLUTION", "IN_APP_BUTTON_TAP", "IN_APP_PERMISSION_RESULT", "IN_APP_FORM_DISPLAY", "IN_APP_FORM_RESULT", "IN_APP_GESTURE", "IN_APP_PAGER_COMPLETED", "IN_APP_PAGER_SUMMARY", "IN_APP_PAGE_SWIPE", "IN_APP_PAGE_VIEW", "IN_APP_PAGE_ACTION", "Companion", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public enum EventAutomationTriggerType implements JsonSerializable {
    FOREGROUND(DownloadService.KEY_FOREGROUND),
    BACKGROUND(AppStateModule.APP_STATE_BACKGROUND),
    SCREEN(TCEventPropertiesNames.TCD_SCREEN),
    VERSION("version"),
    APP_INIT("app_init"),
    REGION_ENTER("region_enter"),
    REGION_EXIT("region_exit"),
    CUSTOM_EVENT_COUNT("custom_event_count"),
    CUSTOM_EVENT_VALUE("custom_event_value"),
    FEATURE_FLAG_INTERACTION("feature_flag_interaction"),
    ACTIVE_SESSION("active_session"),
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

    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static EnumEntries<EventAutomationTriggerType> getEntries() {
        return $ENTRIES;
    }

    EventAutomationTriggerType(String str) {
        this.value = str;
    }

    @NotNull
    /* JADX INFO: renamed from: getValue$urbanairship_automation_release, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/automation/EventAutomationTriggerType$Companion;", "", "()V", "from", "Lcom/urbanairship/automation/EventAutomationTriggerType;", "value", "", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nAutomationTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationTrigger.kt\ncom/urbanairship/automation/EventAutomationTriggerType$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,574:1\n288#2,2:575\n*S KotlinDebug\n*F\n+ 1 AutomationTrigger.kt\ncom/urbanairship/automation/EventAutomationTriggerType$Companion\n*L\n147#1:575,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final EventAutomationTriggerType from(@NotNull String value) throws JsonException {
            EventAutomationTriggerType next;
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator<EventAutomationTriggerType> it = EventAutomationTriggerType.getEntries().iterator();
            while (it.hasNext()) {
                next = it.next();
                if (Intrinsics.areEqual(next.getValue(), value)) {
                    return next;
                }
            }
            next = null;
            return next;
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() {
        JsonValue jsonValueWrap = JsonValue.wrap(this.value);
        Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
        return jsonValueWrap;
    }
}
