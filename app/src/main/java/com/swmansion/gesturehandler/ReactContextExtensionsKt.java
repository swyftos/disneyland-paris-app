package com.swmansion.gesturehandler;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¨\u0006\u0005"}, m1836d2 = {"dispatchEvent", "", "Lcom/facebook/react/bridge/ReactContext;", "event", "Lcom/facebook/react/uimanager/events/Event;", "react-native-gesture-handler_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ReactContextExtensionsKt {
    public static final void dispatchEvent(@NotNull ReactContext reactContext, @NotNull Event<?> event) {
        Intrinsics.checkNotNullParameter(reactContext, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        UIManager uIManager = UIManagerHelper.getUIManager(reactContext, 2);
        Intrinsics.checkNotNull(uIManager, "null cannot be cast to non-null type com.facebook.react.fabric.FabricUIManager");
        ((FabricUIManager) uIManager).getEventDispatcher().dispatchEvent(event);
    }
}
