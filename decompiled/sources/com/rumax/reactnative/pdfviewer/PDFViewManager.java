package com.rumax.reactnative.pdfviewer;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.io.IOException;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes4.dex */
public class PDFViewManager extends SimpleViewManager<PDFView> {
    private static final int COMMAND_RELOAD = 1;
    private static final String EVENT_BUBBLED = "bubbled";
    private static final String REACT_CLASS = "PDFView";

    @ReactProp(name = "fileFrom")
    public void setFileFrom(PDFView pDFView, String str) {
    }

    @ReactProp(name = "textEncoding")
    public void setTextEncoding(PDFView pDFView, String str) {
    }

    PDFViewManager(ReactApplicationContext reactApplicationContext) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder().put(PDFView.EVENT_ON_LOAD, MapBuilder.of("phasedRegistrationNames", MapBuilder.of(EVENT_BUBBLED, PDFView.EVENT_ON_LOAD))).put(PDFView.EVENT_ON_ERROR, MapBuilder.of("phasedRegistrationNames", MapBuilder.of(EVENT_BUBBLED, PDFView.EVENT_ON_ERROR))).put(PDFView.EVENT_ON_PAGE_CHANGED, MapBuilder.of("phasedRegistrationNames", MapBuilder.of(EVENT_BUBBLED, PDFView.EVENT_ON_PAGE_CHANGED))).put(PDFView.EVENT_ON_SCROLLED, MapBuilder.of("phasedRegistrationNames", MapBuilder.of(EVENT_BUBBLED, PDFView.EVENT_ON_SCROLLED))).build();
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public PDFView createViewInstance(ThemedReactContext themedReactContext) {
        return new PDFView(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(PDFView pDFView) {
        pDFView.onDrop();
    }

    @ReactProp(name = "resource")
    public void setResource(PDFView pDFView, String str) {
        pDFView.setResource(str);
    }

    @ReactProp(name = "resourceType")
    public void setResourceType(PDFView pDFView, String str) {
        pDFView.setResourceType(str);
    }

    @ReactProp(name = "urlProps")
    public void setUrlProps(PDFView pDFView, ReadableMap readableMap) {
        pDFView.setUrlProps(readableMap);
    }

    @ReactProp(name = "fadeInDuration")
    public void setFadeInDuration(PDFView pDFView, int i) {
        pDFView.setFadeInDuration(i);
    }

    @ReactProp(name = "enableAnnotations")
    public void setEnableAnnotations(PDFView pDFView, boolean z) {
        pDFView.setEnableAnnotations(z);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(PDFView pDFView) throws IOException {
        super.onAfterUpdateTransaction((PDFViewManager) pDFView);
        pDFView.render();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("reload", 1);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(PDFView pDFView, int i, ReadableArray readableArray) throws IOException {
        if (i != 1) {
            return;
        }
        pDFView.reload();
    }
}
