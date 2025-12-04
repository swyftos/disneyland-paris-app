package com.urbanairship.automation;

import androidx.media3.exoplayer.offline.DownloadService;
import com.facebook.react.modules.appstate.AppStateModule;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
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

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\u0081\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001!B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006\""}, d2 = {"Lcom/urbanairship/automation/EventAutomationTriggerType;", "", "Lcom/urbanairship/json/JsonSerializable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue$urbanairship_automation_release", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "FOREGROUND", "BACKGROUND", "SCREEN", "VERSION", "APP_INIT", "REGION_ENTER", "REGION_EXIT", "CUSTOM_EVENT_COUNT", "CUSTOM_EVENT_VALUE", "FEATURE_FLAG_INTERACTION", "ACTIVE_SESSION", "IN_APP_DISPLAY", "IN_APP_RESOLUTION", "IN_APP_BUTTON_TAP", "IN_APP_PERMISSION_RESULT", "IN_APP_FORM_DISPLAY", "IN_APP_FORM_RESULT", "IN_APP_GESTURE", "IN_APP_PAGER_COMPLETED", "IN_APP_PAGER_SUMMARY", "IN_APP_PAGE_SWIPE", "IN_APP_PAGE_VIEW", "IN_APP_PAGE_ACTION", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EventAutomationTriggerType implements JsonSerializable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EventAutomationTriggerType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final String value;
    public static final EventAutomationTriggerType FOREGROUND = new EventAutomationTriggerType("FOREGROUND", 0, DownloadService.KEY_FOREGROUND);
    public static final EventAutomationTriggerType BACKGROUND = new EventAutomationTriggerType("BACKGROUND", 1, AppStateModule.APP_STATE_BACKGROUND);
    public static final EventAutomationTriggerType SCREEN = new EventAutomationTriggerType("SCREEN", 2, TCEventPropertiesNames.TCD_SCREEN);
    public static final EventAutomationTriggerType VERSION = new EventAutomationTriggerType("VERSION", 3, "version");
    public static final EventAutomationTriggerType APP_INIT = new EventAutomationTriggerType("APP_INIT", 4, "app_init");
    public static final EventAutomationTriggerType REGION_ENTER = new EventAutomationTriggerType("REGION_ENTER", 5, "region_enter");
    public static final EventAutomationTriggerType REGION_EXIT = new EventAutomationTriggerType("REGION_EXIT", 6, "region_exit");
    public static final EventAutomationTriggerType CUSTOM_EVENT_COUNT = new EventAutomationTriggerType("CUSTOM_EVENT_COUNT", 7, "custom_event_count");
    public static final EventAutomationTriggerType CUSTOM_EVENT_VALUE = new EventAutomationTriggerType("CUSTOM_EVENT_VALUE", 8, "custom_event_value");
    public static final EventAutomationTriggerType FEATURE_FLAG_INTERACTION = new EventAutomationTriggerType("FEATURE_FLAG_INTERACTION", 9, "feature_flag_interaction");
    public static final EventAutomationTriggerType ACTIVE_SESSION = new EventAutomationTriggerType("ACTIVE_SESSION", 10, "active_session");
    public static final EventAutomationTriggerType IN_APP_DISPLAY = new EventAutomationTriggerType("IN_APP_DISPLAY", 11, "in_app_display");
    public static final EventAutomationTriggerType IN_APP_RESOLUTION = new EventAutomationTriggerType("IN_APP_RESOLUTION", 12, "in_app_resolution");
    public static final EventAutomationTriggerType IN_APP_BUTTON_TAP = new EventAutomationTriggerType("IN_APP_BUTTON_TAP", 13, "in_app_button_tap");
    public static final EventAutomationTriggerType IN_APP_PERMISSION_RESULT = new EventAutomationTriggerType("IN_APP_PERMISSION_RESULT", 14, "in_app_permission_result");
    public static final EventAutomationTriggerType IN_APP_FORM_DISPLAY = new EventAutomationTriggerType("IN_APP_FORM_DISPLAY", 15, "in_app_form_display");
    public static final EventAutomationTriggerType IN_APP_FORM_RESULT = new EventAutomationTriggerType("IN_APP_FORM_RESULT", 16, "in_app_form_result");
    public static final EventAutomationTriggerType IN_APP_GESTURE = new EventAutomationTriggerType("IN_APP_GESTURE", 17, "in_app_gesture");
    public static final EventAutomationTriggerType IN_APP_PAGER_COMPLETED = new EventAutomationTriggerType("IN_APP_PAGER_COMPLETED", 18, "in_app_pager_completed");
    public static final EventAutomationTriggerType IN_APP_PAGER_SUMMARY = new EventAutomationTriggerType("IN_APP_PAGER_SUMMARY", 19, "in_app_pager_summary");
    public static final EventAutomationTriggerType IN_APP_PAGE_SWIPE = new EventAutomationTriggerType("IN_APP_PAGE_SWIPE", 20, "in_app_page_swipe");
    public static final EventAutomationTriggerType IN_APP_PAGE_VIEW = new EventAutomationTriggerType("IN_APP_PAGE_VIEW", 21, "in_app_page_view");
    public static final EventAutomationTriggerType IN_APP_PAGE_ACTION = new EventAutomationTriggerType("IN_APP_PAGE_ACTION", 22, "in_app_page_action");

    private static final /* synthetic */ EventAutomationTriggerType[] $values() {
        return new EventAutomationTriggerType[]{FOREGROUND, BACKGROUND, SCREEN, VERSION, APP_INIT, REGION_ENTER, REGION_EXIT, CUSTOM_EVENT_COUNT, CUSTOM_EVENT_VALUE, FEATURE_FLAG_INTERACTION, ACTIVE_SESSION, IN_APP_DISPLAY, IN_APP_RESOLUTION, IN_APP_BUTTON_TAP, IN_APP_PERMISSION_RESULT, IN_APP_FORM_DISPLAY, IN_APP_FORM_RESULT, IN_APP_GESTURE, IN_APP_PAGER_COMPLETED, IN_APP_PAGER_SUMMARY, IN_APP_PAGE_SWIPE, IN_APP_PAGE_VIEW, IN_APP_PAGE_ACTION};
    }

    @NotNull
    public static EnumEntries<EventAutomationTriggerType> getEntries() {
        return $ENTRIES;
    }

    public static EventAutomationTriggerType valueOf(String str) {
        return (EventAutomationTriggerType) Enum.valueOf(EventAutomationTriggerType.class, str);
    }

    public static EventAutomationTriggerType[] values() {
        return (EventAutomationTriggerType[]) $VALUES.clone();
    }

    private EventAutomationTriggerType(String str, int i, String str2) {
        this.value = str2;
    }

    @NotNull
    /* renamed from: getValue$urbanairship_automation_release, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    static {
        EventAutomationTriggerType[] eventAutomationTriggerTypeArr$values = $values();
        $VALUES = eventAutomationTriggerTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(eventAutomationTriggerTypeArr$values);
        INSTANCE = new Companion(null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/automation/EventAutomationTriggerType$Companion;", "", "()V", "from", "Lcom/urbanairship/automation/EventAutomationTriggerType;", "value", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(next.getValue(), value)) {
                    break;
                }
            }
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
