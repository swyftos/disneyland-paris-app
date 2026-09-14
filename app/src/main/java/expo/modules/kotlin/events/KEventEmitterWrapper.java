package expo.modules.kotlin.events;

import android.os.Bundle;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.JSTypeConverter;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001$B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0013H\u0016J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0010\u0010\u0011\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0014H\u0016J1\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010\u0019J1\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010\u001cJ.\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n \u001d*\u0004\u0018\u00010\u00100\u00102\u000e\u0010\u0011\u001a\n \u001d*\u0004\u0018\u00010\u001e0\u001eH\u0096\u0001¢\u0006\u0002\u0010\u001fJ&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u000e\u0010 \u001a\n \u001d*\u0004\u0018\u00010!0!H\u0096\u0001¢\u0006\u0002\u0010\"J6\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u000f\u001a\n \u001d*\u0004\u0018\u00010\u00100\u00102\u000e\u0010\u0011\u001a\n \u001d*\u0004\u0018\u00010\u001e0\u001eH\u0096\u0001¢\u0006\u0002\u0010#R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006%"}, m1836d2 = {"Lexpo/modules/kotlin/events/KEventEmitterWrapper;", "Lexpo/modules/kotlin/events/EventEmitter;", "Lexpo/modules/core/interfaces/services/EventEmitter;", "legacyEventEmitter", "reactContextHolder", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lexpo/modules/core/interfaces/services/EventEmitter;Ljava/lang/ref/WeakReference;)V", "deviceEventEmitter", "Lcom/facebook/react/modules/core/DeviceEventManagerModule$RCTDeviceEventEmitter;", "getDeviceEventEmitter", "()Lcom/facebook/react/modules/core/DeviceEventManagerModule$RCTDeviceEventEmitter;", "emit", "", "eventName", "", "eventBody", "Lcom/facebook/react/bridge/WritableMap;", "Lexpo/modules/kotlin/records/Record;", "", "viewId", "", "coalescingKey", "", "(ILjava/lang/String;Lcom/facebook/react/bridge/WritableMap;Ljava/lang/Short;)V", "view", "Landroid/view/View;", "(Landroid/view/View;Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;Ljava/lang/Short;)V", "kotlin.jvm.PlatformType", "Landroid/os/Bundle;", "(Ljava/lang/String;Landroid/os/Bundle;)V", "event", "Lexpo/modules/core/interfaces/services/EventEmitter$Event;", "(ILexpo/modules/core/interfaces/services/EventEmitter$Event;)V", "(ILjava/lang/String;Landroid/os/Bundle;)V", "UIEvent", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public class KEventEmitterWrapper implements EventEmitter, expo.modules.core.interfaces.services.EventEmitter {
    private final expo.modules.core.interfaces.services.EventEmitter legacyEventEmitter;
    private final WeakReference reactContextHolder;

    @Override // expo.modules.core.interfaces.services.EventEmitter
    public void emit(int viewId, expo.modules.core.interfaces.services.EventEmitter.Event event) {
        this.legacyEventEmitter.emit(viewId, event);
    }

    @Override // expo.modules.core.interfaces.services.EventEmitter
    public void emit(int viewId, String eventName, Bundle eventBody) {
        this.legacyEventEmitter.emit(viewId, eventName, eventBody);
    }

    @Override // expo.modules.core.interfaces.services.EventEmitter
    public void emit(String eventName, Bundle eventBody) {
        this.legacyEventEmitter.emit(eventName, eventBody);
    }

    public KEventEmitterWrapper(@NotNull expo.modules.core.interfaces.services.EventEmitter legacyEventEmitter, @NotNull WeakReference<ReactApplicationContext> reactContextHolder) {
        Intrinsics.checkNotNullParameter(legacyEventEmitter, "legacyEventEmitter");
        Intrinsics.checkNotNullParameter(reactContextHolder, "reactContextHolder");
        this.legacyEventEmitter = legacyEventEmitter;
        this.reactContextHolder = reactContextHolder;
    }

    private final DeviceEventManagerModule.RCTDeviceEventEmitter getDeviceEventEmitter() {
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) this.reactContextHolder.get();
        if (reactApplicationContext != null) {
            return (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        }
        return null;
    }

    @Override // expo.modules.kotlin.events.EventEmitter
    public void emit(@NotNull String eventName, @Nullable WritableMap eventBody) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        DeviceEventManagerModule.RCTDeviceEventEmitter deviceEventEmitter = getDeviceEventEmitter();
        if (deviceEventEmitter != null) {
            deviceEventEmitter.emit(eventName, eventBody);
        }
    }

    @Override // expo.modules.kotlin.events.EventEmitter
    public void emit(@NotNull String eventName, @Nullable Record eventBody) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        DeviceEventManagerModule.RCTDeviceEventEmitter deviceEventEmitter = getDeviceEventEmitter();
        if (deviceEventEmitter != null) {
            deviceEventEmitter.emit(eventName, JSTypeConverter.legacyConvertToJSValue$default(JSTypeConverter.INSTANCE, eventBody, null, 2, null));
        }
    }

    @Override // expo.modules.kotlin.events.EventEmitter
    public void emit(@NotNull String eventName, @Nullable Map<?, ?> eventBody) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        DeviceEventManagerModule.RCTDeviceEventEmitter deviceEventEmitter = getDeviceEventEmitter();
        if (deviceEventEmitter != null) {
            deviceEventEmitter.emit(eventName, JSTypeConverter.legacyConvertToJSValue$default(JSTypeConverter.INSTANCE, eventBody, null, 2, null));
        }
    }

    @Override // expo.modules.kotlin.events.EventEmitter
    public void emit(int viewId, @NotNull String eventName, @Nullable WritableMap eventBody, @Nullable Short coalescingKey) {
        EventDispatcher eventDispatcherForReactTag;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) this.reactContextHolder.get();
        if (reactApplicationContext == null || (eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactApplicationContext, viewId)) == null) {
            return;
        }
        eventDispatcherForReactTag.dispatchEvent(new UIEvent(-1, viewId, eventName, eventBody, coalescingKey));
    }

    @Override // expo.modules.kotlin.events.EventEmitter
    public void emit(@NotNull View view, @NotNull String eventName, @Nullable WritableMap eventBody, @Nullable Short coalescingKey) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) this.reactContextHolder.get();
        if (reactApplicationContext == null) {
            return;
        }
        int surfaceId = UIManagerHelper.getSurfaceId(view);
        int id = view.getId();
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactApplicationContext, view.getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new UIEvent(surfaceId, id, eventName, eventBody, coalescingKey));
        }
    }

    private static final class UIEvent extends Event {
        private final Short coalescingKey;
        private final WritableMap eventBody;
        private final String eventName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UIEvent(int i, int i2, String eventName, WritableMap writableMap, Short sh) {
            super(i, i2);
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            this.eventName = eventName;
            this.eventBody = writableMap;
            this.coalescingKey = sh;
        }

        @Override // com.facebook.react.uimanager.events.Event
        public String getEventName() {
            return KModuleEventEmitterWrapperKt.normalizeEventName(this.eventName);
        }

        @Override // com.facebook.react.uimanager.events.Event
        public boolean canCoalesce() {
            return this.coalescingKey != null;
        }

        @Override // com.facebook.react.uimanager.events.Event
        public short getCoalescingKey() {
            Short sh = this.coalescingKey;
            if (sh != null) {
                return sh.shortValue();
            }
            return (short) 0;
        }

        @Override // com.facebook.react.uimanager.events.Event
        /* JADX INFO: renamed from: getEventData */
        protected WritableMap getExtraData() {
            WritableMap writableMap = this.eventBody;
            if (writableMap != null) {
                return writableMap;
            }
            WritableMap writableMapCreateMap = Arguments.createMap();
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
            return writableMapCreateMap;
        }
    }
}
