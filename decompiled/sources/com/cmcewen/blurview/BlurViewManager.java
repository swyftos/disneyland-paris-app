package com.cmcewen.blurview;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;
import java.util.Objects;
import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
class BlurViewManager extends ViewGroupManager<BlurView> {
    private static final String REACT_CLASS = "BlurView";
    private static final int defaultRadius = 10;
    private static final int defaultSampling = 10;

    @ReactProp(defaultInt = 10, name = "downsampleFactor")
    public void setDownsampleFactor(BlurView blurView, int i) {
    }

    BlurViewManager() {
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nonnull
    public BlurView createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
        BlurView blurView = new BlurView(themedReactContext);
        Activity currentActivity = themedReactContext.getCurrentActivity();
        Objects.requireNonNull(currentActivity);
        View decorView = currentActivity.getWindow().getDecorView();
        ViewGroup viewGroup = (ViewGroup) decorView.findViewById(android.R.id.content);
        blurView.setupWith(viewGroup).setFrameClearDrawable(decorView.getBackground()).setBlurAlgorithm(new RenderScriptBlur(themedReactContext)).setBlurRadius(10.0f).setHasFixedTransformationMatrix(false);
        return blurView;
    }

    @ReactProp(defaultInt = 10, name = "blurRadius")
    public void setRadius(BlurView blurView, int i) {
        blurView.setBlurRadius(i);
        blurView.invalidate();
    }

    @ReactProp(customType = "Color", name = "overlayColor")
    public void setColor(BlurView blurView, int i) {
        blurView.setOverlayColor(i);
        blurView.invalidate();
    }
}
