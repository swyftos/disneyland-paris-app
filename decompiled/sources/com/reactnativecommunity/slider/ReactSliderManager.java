package com.reactnativecommunity.slider;

import android.content.Context;
import android.view.View;
import android.widget.SeekBar;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNCSliderManagerDelegate;
import com.facebook.react.viewmanagers.RNCSliderManagerInterface;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Map;

@ReactModule(name = ReactSliderManagerImpl.REACT_CLASS)
/* loaded from: classes4.dex */
public class ReactSliderManager extends SimpleViewManager<ReactSlider> implements RNCSliderManagerInterface<ReactSlider> {
    private static final SeekBar.OnSeekBarChangeListener ON_CHANGE_LISTENER = new SeekBar.OnSeekBarChangeListener() { // from class: com.reactnativecommunity.slider.ReactSliderManager.1
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            ReactSlider reactSlider = (ReactSlider) seekBar;
            int validProgressValue = reactSlider.getValidProgressValue(i);
            seekBar.setProgress(validProgressValue);
            ReactContext reactContext = (ReactContext) seekBar.getContext();
            int id = seekBar.getId();
            UIManagerHelper.getEventDispatcherForReactTag(reactContext, id).dispatchEvent(new ReactSliderEvent(id, reactSlider.toRealProgress(validProgressValue), z));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            ReactContext reactContext = (ReactContext) seekBar.getContext();
            int id = seekBar.getId();
            ReactSlider reactSlider = (ReactSlider) seekBar;
            reactSlider.isSliding(true);
            UIManagerHelper.getEventDispatcherForReactTag(reactContext, id).dispatchEvent(new ReactSlidingStartEvent(id, reactSlider.toRealProgress(seekBar.getProgress())));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            ReactContext reactContext = (ReactContext) seekBar.getContext();
            ReactSlider reactSlider = (ReactSlider) seekBar;
            reactSlider.isSliding(false);
            int id = seekBar.getId();
            UIManagerHelper.getEventDispatcherForReactTag(reactContext, id).dispatchEvent(new ReactSlidingCompleteEvent(id, reactSlider.toRealProgress(seekBar.getProgress())));
        }
    };
    private final ViewManagerDelegate<ReactSlider> mDelegate = new RNCSliderManagerDelegate(this);

    @Override // com.facebook.react.viewmanagers.RNCSliderManagerInterface
    public void setMaximumTrackImage(ReactSlider reactSlider, @Nullable ReadableMap readableMap) {
    }

    @Override // com.facebook.react.viewmanagers.RNCSliderManagerInterface
    public void setMinimumTrackImage(ReactSlider reactSlider, @Nullable ReadableMap readableMap) {
    }

    @Override // com.facebook.react.viewmanagers.RNCSliderManagerInterface
    public void setTapToSeek(ReactSlider reactSlider, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCSliderManagerInterface
    public void setTrackImage(ReactSlider reactSlider, @Nullable ReadableMap readableMap) {
    }

    @Override // com.facebook.react.viewmanagers.RNCSliderManagerInterface
    public void setVertical(ReactSlider reactSlider, boolean z) {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    protected ViewManagerDelegate<ReactSlider> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return ReactSliderManagerImpl.REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ReactSlider createViewInstance(ThemedReactContext themedReactContext) {
        return ReactSliderManagerImpl.createViewInstance(themedReactContext);
    }

    @Override // com.facebook.react.viewmanagers.RNCSliderManagerInterface
    @ReactProp(defaultBoolean = false, name = "disabled")
    public void setDisabled(ReactSlider reactSlider, boolean z) {
        ReactSliderManagerImpl.setDisabled(reactSlider, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCSliderManagerInterface
    @ReactProp(defaultFloat = BitmapDescriptorFactory.HUE_RED, name = "value")
    public void setValue(ReactSlider reactSlider, float f) {
        ReactSliderManagerImpl.setValue(reactSlider, f);
    }

    @Override // com.facebook.react.viewmanagers.RNCSliderManagerInterface
    @ReactProp(defaultFloat = BitmapDescriptorFactory.HUE_RED, name = "minimumValue")
    public void setMinimumValue(ReactSlider reactSlider, double d) {
        ReactSliderManagerImpl.setMinimumValue(reactSlider, d);
    }

    @Override // com.facebook.react.viewmanagers.RNCSliderManagerInterface
    @ReactProp(defaultFloat = BitmapDescriptorFactory.HUE_RED, name = "maximumValue")
    public void setMaximumValue(ReactSlider reactSlider, double d) {
        ReactSliderManagerImpl.setMaximumValue(reactSlider, d);
    }

    @Override // com.facebook.react.viewmanagers.RNCSliderManagerInterface
    @ReactProp(defaultFloat = BitmapDescriptorFactory.HUE_RED, name = "step")
    public void setStep(ReactSlider reactSlider, double d) {
        ReactSliderManagerImpl.setStep(reactSlider, d);
    }

    @Override // com.facebook.react.viewmanagers.RNCSliderManagerInterface
    @ReactProp(customType = "Color", name = "thumbTintColor")
    public void setThumbTintColor(ReactSlider reactSlider, Integer num) {
        ReactSliderManagerImpl.setThumbTintColor(reactSlider, num);
    }

    @Override // com.facebook.react.viewmanagers.RNCSliderManagerInterface
    @ReactProp(customType = "Color", name = "minimumTrackTintColor")
    public void setMinimumTrackTintColor(ReactSlider reactSlider, Integer num) {
        ReactSliderManagerImpl.setMinimumTrackTintColor(reactSlider, num);
    }

    @Override // com.facebook.react.viewmanagers.RNCSliderManagerInterface
    @ReactProp(customType = "Color", name = "maximumTrackTintColor")
    public void setMaximumTrackTintColor(ReactSlider reactSlider, Integer num) {
        ReactSliderManagerImpl.setMaximumTrackTintColor(reactSlider, num);
    }

    @Override // com.facebook.react.viewmanagers.RNCSliderManagerInterface
    @ReactProp(defaultBoolean = false, name = "inverted")
    public void setInverted(ReactSlider reactSlider, boolean z) {
        ReactSliderManagerImpl.setInverted(reactSlider, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCSliderManagerInterface
    @ReactProp(name = "accessibilityUnits")
    public void setAccessibilityUnits(ReactSlider reactSlider, String str) {
        ReactSliderManagerImpl.setAccessibilityUnits(reactSlider, str);
    }

    @Override // com.facebook.react.viewmanagers.RNCSliderManagerInterface
    @ReactProp(name = "accessibilityIncrements")
    public void setAccessibilityIncrements(ReactSlider reactSlider, ReadableArray readableArray) {
        ReactSliderManagerImpl.setAccessibilityIncrements(reactSlider, readableArray);
    }

    @Override // com.facebook.react.viewmanagers.RNCSliderManagerInterface
    @ReactProp(name = "lowerLimit")
    public void setLowerLimit(ReactSlider reactSlider, float f) {
        ReactSliderManagerImpl.setLowerLimit(reactSlider, f);
    }

    @Override // com.facebook.react.viewmanagers.RNCSliderManagerInterface
    @ReactProp(name = "upperLimit")
    public void setUpperLimit(ReactSlider reactSlider, float f) {
        ReactSliderManagerImpl.setUpperLimit(reactSlider, f);
    }

    @Override // com.facebook.react.viewmanagers.RNCSliderManagerInterface
    @ReactProp(name = "thumbImage")
    public void setThumbImage(ReactSlider reactSlider, @Nullable ReadableMap readableMap) {
        ReactSliderManagerImpl.setThumbImage(reactSlider, readableMap);
    }

    @Override // com.facebook.react.viewmanagers.RNCSliderManagerInterface
    public void setTestID(ReactSlider reactSlider, @Nullable String str) {
        super.setTestId(reactSlider, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(ThemedReactContext themedReactContext, ReactSlider reactSlider) {
        reactSlider.setOnSeekBarChangeListener(ON_CHANGE_LISTENER);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2, @Nullable float[] fArr) {
        ReactSlider reactSlider = new ReactSlider(context, null);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        reactSlider.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        return YogaMeasureOutput.make(PixelUtil.toDIPFromPixel(reactSlider.getMeasuredWidth()), PixelUtil.toDIPFromPixel(reactSlider.getMeasuredHeight()));
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return ReactSliderManagerImpl.getExportedCustomBubblingEventTypeConstants();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return ReactSliderManagerImpl.getExportedCustomDirectEventTypeConstants();
    }
}
