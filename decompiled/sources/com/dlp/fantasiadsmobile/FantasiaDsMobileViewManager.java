package com.dlp.fantasiadsmobile;

import android.graphics.Color;
import android.view.View;
import androidx.annotation.NonNull;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

/* loaded from: classes3.dex */
public class FantasiaDsMobileViewManager extends SimpleViewManager<View> {
    public static final String REACT_CLASS = "FantasiaDsMobileView";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NonNull
    public View createViewInstance(ThemedReactContext themedReactContext) {
        return new View(themedReactContext);
    }

    @ReactProp(name = "color")
    public void setColor(View view, String str) {
        view.setBackgroundColor(Color.parseColor(str));
    }
}
