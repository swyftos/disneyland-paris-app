package com.facebook.react.uimanager;

import android.widget.ImageView;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.events.TouchEventType;
import com.facebook.react.views.textinput.ReactContentSizeChangedEvent;
import com.reactnativecommunity.webview.events.TopLoadingErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingFinishEvent;
import com.reactnativecommunity.webview.events.TopLoadingStartEvent;
import com.reactnativecommunity.webview.events.TopMessageEvent;
import com.rnmaps.fabric.event.OnSelectEvent;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@Nullsafe(Nullsafe.Mode.LOCAL)
class UIManagerModuleConstants {
    public static final String ACTION_DISMISSED = "dismissed";
    public static final String ACTION_ITEM_SELECTED = "itemSelected";

    UIManagerModuleConstants() {
    }

    static Map getBubblingEventTypeConstants() {
        return MapBuilder.builder().put("topChange", MapBuilder.m1373of("phasedRegistrationNames", MapBuilder.m1374of("bubbled", "onChange", "captured", "onChangeCapture"))).put(OnSelectEvent.EVENT_NAME, MapBuilder.m1373of("phasedRegistrationNames", MapBuilder.m1374of("bubbled", "onSelect", "captured", "onSelectCapture"))).put(TouchEventType.getJSEventName(TouchEventType.START), MapBuilder.m1373of("phasedRegistrationNames", MapBuilder.m1374of("bubbled", "onTouchStart", "captured", "onTouchStartCapture"))).put(TouchEventType.getJSEventName(TouchEventType.MOVE), MapBuilder.m1373of("phasedRegistrationNames", MapBuilder.m1374of("bubbled", "onTouchMove", "captured", "onTouchMoveCapture"))).put(TouchEventType.getJSEventName(TouchEventType.END), MapBuilder.m1373of("phasedRegistrationNames", MapBuilder.m1374of("bubbled", "onTouchEnd", "captured", "onTouchEndCapture"))).put(TouchEventType.getJSEventName(TouchEventType.CANCEL), MapBuilder.m1373of("phasedRegistrationNames", MapBuilder.m1374of("bubbled", "onTouchCancel", "captured", "onTouchCancelCapture"))).build();
    }

    static Map getDirectEventTypeConstants() {
        return MapBuilder.builder().put(ReactContentSizeChangedEvent.EVENT_NAME, MapBuilder.m1373of("registrationName", "onContentSizeChange")).put("topLayout", MapBuilder.m1373of("registrationName", "onLayout")).put(TopLoadingErrorEvent.EVENT_NAME, MapBuilder.m1373of("registrationName", "onLoadingError")).put(TopLoadingFinishEvent.EVENT_NAME, MapBuilder.m1373of("registrationName", "onLoadingFinish")).put(TopLoadingStartEvent.EVENT_NAME, MapBuilder.m1373of("registrationName", "onLoadingStart")).put("topSelectionChange", MapBuilder.m1373of("registrationName", "onSelectionChange")).put(TopMessageEvent.EVENT_NAME, MapBuilder.m1373of("registrationName", "onMessage")).put("topScrollBeginDrag", MapBuilder.m1373of("registrationName", "onScrollBeginDrag")).put("topScrollEndDrag", MapBuilder.m1373of("registrationName", "onScrollEndDrag")).put("topScroll", MapBuilder.m1373of("registrationName", "onScroll")).put("topMomentumScrollBegin", MapBuilder.m1373of("registrationName", "onMomentumScrollBegin")).put("topMomentumScrollEnd", MapBuilder.m1373of("registrationName", "onMomentumScrollEnd")).build();
    }

    public static Map<String, Object> getConstants() {
        HashMap mapNewHashMap = MapBuilder.newHashMap();
        mapNewHashMap.put("UIView", MapBuilder.m1373of("ContentMode", MapBuilder.m1375of("ScaleAspectFit", Integer.valueOf(ImageView.ScaleType.FIT_CENTER.ordinal()), "ScaleAspectFill", Integer.valueOf(ImageView.ScaleType.CENTER_CROP.ordinal()), "ScaleAspectCenter", Integer.valueOf(ImageView.ScaleType.CENTER_INSIDE.ordinal()))));
        mapNewHashMap.put("StyleConstants", MapBuilder.m1373of("PointerEventsValues", MapBuilder.m1376of("none", Integer.valueOf(PointerEvents.NONE.ordinal()), "boxNone", Integer.valueOf(PointerEvents.BOX_NONE.ordinal()), "boxOnly", Integer.valueOf(PointerEvents.BOX_ONLY.ordinal()), "unspecified", Integer.valueOf(PointerEvents.AUTO.ordinal()))));
        mapNewHashMap.put("AccessibilityEventTypes", MapBuilder.m1375of("typeWindowStateChanged", 32, "typeViewFocused", 8, "typeViewClicked", 1));
        return mapNewHashMap;
    }
}
