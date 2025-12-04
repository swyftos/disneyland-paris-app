package com.contentsquare.rn.eventEmitter;

import com.contentsquare.android.core.utils.UriBuilder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0007J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000bH\u0007J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0007J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nJ\u0018\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/contentsquare/rn/eventEmitter/CSEventEmitter;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "mReactContext", "Lcom/facebook/react/bridge/ReactContext;", "listenerCounts", "", "", "", "addListener", "", "eventName", "removeListeners", "count", "removeListener", "sendSessionReplayLink", "url", "sendFeatureFlags", "", "data", "sendEvent", "", "isEventSupported", "event", "getName", "Companion", "contentsquare_react-native-bridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCSEventEmitter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CSEventEmitter.kt\ncom/contentsquare/rn/eventEmitter/CSEventEmitter\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,81:1\n12574#2,2:82\n*S KotlinDebug\n*F\n+ 1 CSEventEmitter.kt\ncom/contentsquare/rn/eventEmitter/CSEventEmitter\n*L\n64#1:82,2\n*E\n"})
/* loaded from: classes3.dex */
public final class CSEventEmitter extends ReactContextBaseJavaModule {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Companion.CSEmitterEvents[] events = Companion.CSEmitterEvents.values();

    @NotNull
    private final Map<String, Integer> listenerCounts;

    @NotNull
    private final ReactContext mReactContext;

    @ReactMethod
    public final void removeListeners(int count) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CSEventEmitter(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.listenerCounts = new LinkedHashMap();
        for (Companion.CSEmitterEvents cSEmitterEvents : events) {
            this.listenerCounts.put(cSEmitterEvents.getEvent(), 0);
        }
        this.mReactContext = reactContext;
    }

    @ReactMethod
    public final void addListener(@Nullable String eventName) {
        if (eventName == null || !isEventSupported(eventName)) {
            return;
        }
        Map<String, Integer> map = this.listenerCounts;
        Integer num = map.get(eventName);
        map.put(eventName, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
    }

    @ReactMethod
    public final void removeListener(@NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (isEventSupported(eventName)) {
            this.listenerCounts.put(eventName, Integer.valueOf(Math.max(0, (this.listenerCounts.get(eventName) != null ? r0.intValue() : 0) - 1)));
        }
    }

    public final void sendSessionReplayLink(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        sendEvent(Companion.CSEmitterEvents.SESSION_REPLAY_LINK_CHANGE.getEvent(), url);
    }

    public final boolean sendFeatureFlags(@NotNull String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return sendEvent(Companion.CSEmitterEvents.GET_FEATURE_FLAGS.getEvent(), data);
    }

    private final boolean sendEvent(String eventName, Object data) {
        Integer num = this.listenerCounts.get(eventName);
        if ((num != null ? num.intValue() : 0) <= 0) {
            return false;
        }
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(eventName, data);
        return true;
    }

    private final boolean isEventSupported(String event) {
        for (Companion.CSEmitterEvents cSEmitterEvents : events) {
            if (Intrinsics.areEqual(cSEmitterEvents.getEvent(), event)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "CSEventEmitter";
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/contentsquare/rn/eventEmitter/CSEventEmitter$Companion;", "", "<init>", "()V", UriBuilder.ANALYTICS_EVENT_ENDPOINT, "", "Lcom/contentsquare/rn/eventEmitter/CSEventEmitter$Companion$CSEmitterEvents;", "getEvents", "()[Lcom/contentsquare/rn/eventEmitter/CSEventEmitter$Companion$CSEmitterEvents;", "[Lcom/contentsquare/rn/eventEmitter/CSEventEmitter$Companion$CSEmitterEvents;", "CSEmitterEvents", "contentsquare_react-native-bridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/contentsquare/rn/eventEmitter/CSEventEmitter$Companion$CSEmitterEvents;", "", "event", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEvent", "()Ljava/lang/String;", "SESSION_REPLAY_LINK_CHANGE", "GET_FEATURE_FLAGS", "contentsquare_react-native-bridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class CSEmitterEvents {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ CSEmitterEvents[] $VALUES;

            @NotNull
            private final String event;
            public static final CSEmitterEvents SESSION_REPLAY_LINK_CHANGE = new CSEmitterEvents("SESSION_REPLAY_LINK_CHANGE", 0, "onSessionReplayLinkChange");
            public static final CSEmitterEvents GET_FEATURE_FLAGS = new CSEmitterEvents("GET_FEATURE_FLAGS", 1, "getFeatureFlags");

            private static final /* synthetic */ CSEmitterEvents[] $values() {
                return new CSEmitterEvents[]{SESSION_REPLAY_LINK_CHANGE, GET_FEATURE_FLAGS};
            }

            @NotNull
            public static EnumEntries<CSEmitterEvents> getEntries() {
                return $ENTRIES;
            }

            private CSEmitterEvents(String str, int i, String str2) {
                this.event = str2;
            }

            @NotNull
            public final String getEvent() {
                return this.event;
            }

            static {
                CSEmitterEvents[] cSEmitterEventsArr$values = $values();
                $VALUES = cSEmitterEventsArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(cSEmitterEventsArr$values);
            }

            public static CSEmitterEvents valueOf(String str) {
                return (CSEmitterEvents) Enum.valueOf(CSEmitterEvents.class, str);
            }

            public static CSEmitterEvents[] values() {
                return (CSEmitterEvents[]) $VALUES.clone();
            }
        }

        private Companion() {
        }

        @NotNull
        public final CSEmitterEvents[] getEvents() {
            return CSEventEmitter.events;
        }
    }
}
