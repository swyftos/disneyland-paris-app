package com.urbanairship.automation.engine;

import androidx.camera.video.AudioStats;
import com.urbanairship.analytics.AirshipEventFeed;
import com.urbanairship.analytics.EventType;
import com.urbanairship.automation.EventAutomationTriggerType;
import com.urbanairship.automation.engine.AutomationEvent;
import com.urbanairship.json.JsonValue;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\" \u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"toAutomationEvents", "", "Lcom/urbanairship/automation/engine/AutomationEvent$Event;", "Lcom/urbanairship/analytics/AirshipEventFeed$Event;", "getToAutomationEvents", "(Lcom/urbanairship/analytics/AirshipEventFeed$Event;)Ljava/util/List;", "urbanairship-automation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AutomationEventFeedKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventType.values().length];
            try {
                iArr[EventType.REGION_ENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EventType.REGION_EXIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EventType.CUSTOM_EVENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EventType.FEATURE_FLAG_INTERACTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EventType.IN_APP_DISPLAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EventType.IN_APP_RESOLUTION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EventType.IN_APP_BUTTON_TAP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[EventType.IN_APP_PERMISSION_RESULT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[EventType.IN_APP_FORM_DISPLAY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[EventType.IN_APP_FORM_RESULT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[EventType.IN_APP_GESTURE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[EventType.IN_APP_PAGER_COMPLETED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[EventType.IN_APP_PAGER_SUMMARY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[EventType.IN_APP_PAGE_SWIPE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[EventType.IN_APP_PAGE_VIEW.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[EventType.IN_APP_PAGE_ACTION.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Nullable
    public static final List<AutomationEvent.Event> getToAutomationEvents(@NotNull AirshipEventFeed.Event event) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        if (event instanceof AirshipEventFeed.Event.Screen) {
            return CollectionsKt.listOf(new AutomationEvent.Event(EventAutomationTriggerType.SCREEN, JsonValue.wrap(((AirshipEventFeed.Event.Screen) event).getScreen()), AudioStats.AUDIO_AMPLITUDE_NONE, 4, null));
        }
        if (event instanceof AirshipEventFeed.Event.Analytics) {
            AirshipEventFeed.Event.Analytics analytics = (AirshipEventFeed.Event.Analytics) event;
            switch (WhenMappings.$EnumSwitchMapping$0[analytics.getEventType().ordinal()]) {
                case 1:
                    return CollectionsKt.listOf(new AutomationEvent.Event(EventAutomationTriggerType.REGION_ENTER, analytics.getData(), AudioStats.AUDIO_AMPLITUDE_NONE, 4, null));
                case 2:
                    return CollectionsKt.listOf(new AutomationEvent.Event(EventAutomationTriggerType.REGION_EXIT, analytics.getData(), AudioStats.AUDIO_AMPLITUDE_NONE, 4, null));
                case 3:
                    AutomationEvent.Event event2 = new AutomationEvent.Event(EventAutomationTriggerType.CUSTOM_EVENT_COUNT, analytics.getData(), AudioStats.AUDIO_AMPLITUDE_NONE, 4, null);
                    EventAutomationTriggerType eventAutomationTriggerType = EventAutomationTriggerType.CUSTOM_EVENT_VALUE;
                    JsonValue data = analytics.getData();
                    Double value = analytics.getValue();
                    return CollectionsKt.listOf((Object[]) new AutomationEvent.Event[]{event2, new AutomationEvent.Event(eventAutomationTriggerType, data, value != null ? value.doubleValue() : 1.0d)});
                case 4:
                    return CollectionsKt.listOf(new AutomationEvent.Event(EventAutomationTriggerType.FEATURE_FLAG_INTERACTION, analytics.getData(), AudioStats.AUDIO_AMPLITUDE_NONE, 4, null));
                case 5:
                    return CollectionsKt.listOf(new AutomationEvent.Event(EventAutomationTriggerType.IN_APP_DISPLAY, analytics.getData(), AudioStats.AUDIO_AMPLITUDE_NONE, 4, null));
                case 6:
                    return CollectionsKt.listOf(new AutomationEvent.Event(EventAutomationTriggerType.IN_APP_RESOLUTION, analytics.getData(), AudioStats.AUDIO_AMPLITUDE_NONE, 4, null));
                case 7:
                    return CollectionsKt.listOf(new AutomationEvent.Event(EventAutomationTriggerType.IN_APP_BUTTON_TAP, analytics.getData(), AudioStats.AUDIO_AMPLITUDE_NONE, 4, null));
                case 8:
                    return CollectionsKt.listOf(new AutomationEvent.Event(EventAutomationTriggerType.IN_APP_PERMISSION_RESULT, analytics.getData(), AudioStats.AUDIO_AMPLITUDE_NONE, 4, null));
                case 9:
                    return CollectionsKt.listOf(new AutomationEvent.Event(EventAutomationTriggerType.IN_APP_FORM_DISPLAY, analytics.getData(), AudioStats.AUDIO_AMPLITUDE_NONE, 4, null));
                case 10:
                    return CollectionsKt.listOf(new AutomationEvent.Event(EventAutomationTriggerType.IN_APP_FORM_RESULT, analytics.getData(), AudioStats.AUDIO_AMPLITUDE_NONE, 4, null));
                case 11:
                    return CollectionsKt.listOf(new AutomationEvent.Event(EventAutomationTriggerType.IN_APP_GESTURE, analytics.getData(), AudioStats.AUDIO_AMPLITUDE_NONE, 4, null));
                case 12:
                    return CollectionsKt.listOf(new AutomationEvent.Event(EventAutomationTriggerType.IN_APP_PAGER_COMPLETED, analytics.getData(), AudioStats.AUDIO_AMPLITUDE_NONE, 4, null));
                case 13:
                    return CollectionsKt.listOf(new AutomationEvent.Event(EventAutomationTriggerType.IN_APP_PAGER_SUMMARY, analytics.getData(), AudioStats.AUDIO_AMPLITUDE_NONE, 4, null));
                case 14:
                    return CollectionsKt.listOf(new AutomationEvent.Event(EventAutomationTriggerType.IN_APP_PAGE_SWIPE, analytics.getData(), AudioStats.AUDIO_AMPLITUDE_NONE, 4, null));
                case 15:
                    return CollectionsKt.listOf(new AutomationEvent.Event(EventAutomationTriggerType.IN_APP_PAGE_VIEW, analytics.getData(), AudioStats.AUDIO_AMPLITUDE_NONE, 4, null));
                case 16:
                    return CollectionsKt.listOf(new AutomationEvent.Event(EventAutomationTriggerType.IN_APP_PAGE_ACTION, analytics.getData(), AudioStats.AUDIO_AMPLITUDE_NONE, 4, null));
                default:
                    return null;
            }
        }
        throw new NoWhenBranchMatchedException();
    }
}
