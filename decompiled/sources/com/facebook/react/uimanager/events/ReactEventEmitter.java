package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.common.ViewUtil;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\"\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0017J*\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J \u0010\u0016\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0017J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0017J\n\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0002JB\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010 \u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/facebook/react/uimanager/events/ReactEventEmitter;", "Lcom/facebook/react/uimanager/events/RCTModernEventEmitter;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "fabricEventEmitter", "defaultEventEmitter", "Lcom/facebook/react/uimanager/events/RCTEventEmitter;", "register", "", "uiManagerType", "", "eventEmitter", "unregister", "receiveEvent", "targetTag", "eventName", "", "params", "Lcom/facebook/react/bridge/WritableMap;", "surfaceId", "receiveTouches", "touches", "Lcom/facebook/react/bridge/WritableArray;", "changedIndices", "event", "Lcom/facebook/react/uimanager/events/TouchEvent;", "ensureDefaultEventEmitter", "canCoalesceEvent", "", "customCoalesceKey", "category", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nReactEventEmitter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReactEventEmitter.kt\ncom/facebook/react/uimanager/events/ReactEventEmitter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,131:1\n1#2:132\n*E\n"})
/* loaded from: classes3.dex */
public final class ReactEventEmitter implements RCTModernEventEmitter {

    @NotNull
    private static final String TAG = "ReactEventEmitter";

    @Nullable
    private RCTEventEmitter defaultEventEmitter;

    @Nullable
    private RCTModernEventEmitter fabricEventEmitter;

    @NotNull
    private final ReactApplicationContext reactContext;

    public ReactEventEmitter(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
    }

    public final void register(int uiManagerType, @Nullable RCTModernEventEmitter eventEmitter) {
        if (uiManagerType != 2) {
            throw new IllegalStateException("Check failed.");
        }
        this.fabricEventEmitter = eventEmitter;
    }

    public final void register(int uiManagerType, @Nullable RCTEventEmitter eventEmitter) {
        if (uiManagerType != 1) {
            throw new IllegalStateException("Check failed.");
        }
        this.defaultEventEmitter = eventEmitter;
    }

    public final void unregister(int uiManagerType) {
        if (uiManagerType == 1) {
            this.defaultEventEmitter = null;
        } else {
            this.fabricEventEmitter = null;
        }
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    @Deprecated(message = "Please use RCTModernEventEmitter")
    public void receiveEvent(int targetTag, @NotNull String eventName, @Nullable WritableMap params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        receiveEvent(-1, targetTag, eventName, params);
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    public void receiveEvent(int surfaceId, int targetTag, @NotNull String eventName, @Nullable WritableMap params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        receiveEvent(surfaceId, targetTag, eventName, false, 0, params, 2);
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    @Deprecated(message = "Please use RCTModernEventEmitter")
    public void receiveTouches(@NotNull String eventName, @NotNull WritableArray touches, @NotNull WritableArray changedIndices) {
        RCTEventEmitter rCTEventEmitterEnsureDefaultEventEmitter;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(touches, "touches");
        Intrinsics.checkNotNullParameter(changedIndices, "changedIndices");
        if (touches.size() <= 0) {
            throw new IllegalStateException("Check failed.");
        }
        ReadableMap map = touches.getMap(0);
        if (ViewUtil.getUIManagerType(map != null ? map.getInt(TouchesHelper.TARGET_KEY) : 0) != 1 || (rCTEventEmitterEnsureDefaultEventEmitter = ensureDefaultEventEmitter()) == null) {
            return;
        }
        rCTEventEmitterEnsureDefaultEventEmitter.receiveTouches(eventName, touches, changedIndices);
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    @Deprecated(message = "Please use RCTModernEventEmitter")
    public void receiveTouches(@NotNull TouchEvent event) {
        RCTModernEventEmitter rCTModernEventEmitter;
        Intrinsics.checkNotNullParameter(event, "event");
        int uIManagerType = ViewUtil.getUIManagerType(event.getViewTag(), event.getSurfaceId());
        if (uIManagerType != 1) {
            if (uIManagerType == 2 && (rCTModernEventEmitter = this.fabricEventEmitter) != null) {
                TouchesHelper.sendTouchEvent(rCTModernEventEmitter, event);
                return;
            }
            return;
        }
        RCTEventEmitter rCTEventEmitterEnsureDefaultEventEmitter = ensureDefaultEventEmitter();
        if (rCTEventEmitterEnsureDefaultEventEmitter != null) {
            TouchesHelper.sendTouchesLegacy(rCTEventEmitterEnsureDefaultEventEmitter, event);
        }
    }

    private final RCTEventEmitter ensureDefaultEventEmitter() {
        if (this.defaultEventEmitter == null) {
            if (this.reactContext.hasActiveReactInstance()) {
                this.defaultEventEmitter = (RCTEventEmitter) this.reactContext.getJSModule(RCTEventEmitter.class);
            } else {
                ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Cannot get RCTEventEmitter from Context, no active Catalyst instance!"));
            }
        }
        return this.defaultEventEmitter;
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    public void receiveEvent(int surfaceId, int targetTag, @NotNull String eventName, boolean canCoalesceEvent, int customCoalesceKey, @Nullable WritableMap params, int category) {
        RCTModernEventEmitter rCTModernEventEmitter;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        int uIManagerType = ViewUtil.getUIManagerType(targetTag, surfaceId);
        if (uIManagerType != 1) {
            if (uIManagerType == 2 && (rCTModernEventEmitter = this.fabricEventEmitter) != null) {
                rCTModernEventEmitter.receiveEvent(surfaceId, targetTag, eventName, canCoalesceEvent, customCoalesceKey, params, category);
                return;
            }
            return;
        }
        RCTEventEmitter rCTEventEmitterEnsureDefaultEventEmitter = ensureDefaultEventEmitter();
        if (rCTEventEmitterEnsureDefaultEventEmitter != null) {
            rCTEventEmitterEnsureDefaultEventEmitter.receiveEvent(targetTag, eventName, params);
        }
    }
}
