package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNSScreenManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenManagerInterface;
import com.swmansion.rnscreens.events.HeaderBackButtonClickedEvent;
import com.swmansion.rnscreens.events.HeaderHeightChangeEvent;
import com.swmansion.rnscreens.events.ScreenAppearEvent;
import com.swmansion.rnscreens.events.ScreenDisappearEvent;
import com.swmansion.rnscreens.events.ScreenDismissedEvent;
import com.swmansion.rnscreens.events.ScreenTransitionProgressEvent;
import com.swmansion.rnscreens.events.SheetDetentChangedEvent;
import com.swmansion.rnscreens.gamma.tabs.event.TabScreenWillAppearEvent;
import com.swmansion.rnscreens.gamma.tabs.event.TabScreenWillDisappearEvent;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.json.matchers.ArrayContainsMatcher;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0003\b\u0017\u0018\u0000 U2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001UB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0015H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0014J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0017H\u0007J\u001a\u0010!\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\tH\u0017J\u001a\u0010#\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\tH\u0017J\u0018\u0010%\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010&\u001a\u00020'H\u0017J\u001a\u0010(\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\tH\u0017J\u001a\u0010)\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010\tH\u0017J\u001a\u0010+\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010,\u001a\u0004\u0018\u00010\tH\u0017J\u001f\u0010-\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010.\u001a\u0004\u0018\u00010\u0017H\u0017¢\u0006\u0002\u0010/J\u001a\u00100\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u00101\u001a\u0004\u0018\u00010\tH\u0017J\u0018\u00102\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u00103\u001a\u00020'H\u0017J\u0018\u00104\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u00105\u001a\u00020'H\u0017J\u001f\u00106\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u00107\u001a\u0004\u0018\u00010\u0017H\u0017¢\u0006\u0002\u0010/J\u0018\u00108\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u00109\u001a\u00020'H\u0017J\u0018\u0010:\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010;\u001a\u00020'H\u0017J\u0018\u0010<\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010=\u001a\u00020'H\u0017J\u001a\u0010>\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010?\u001a\u00020\u0017H\u0017J\u001a\u0010@\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010?\u001a\u00020'H\u0016J\u001a\u0010A\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010?\u001a\u00020'H\u0016J\u001a\u0010B\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010?\u001a\u00020\u0017H\u0016J\u001a\u0010C\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010?\u001a\u00020'H\u0016J\u001a\u0010D\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010?\u001a\u00020'H\u0016J\u001c\u0010E\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010?\u001a\u0004\u0018\u00010FH\u0016J\u001a\u0010G\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010?\u001a\u00020'H\u0016J\u001a\u0010H\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010?\u001a\u00020'H\u0016J\u001c\u0010I\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010?\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010J\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010?\u001a\u0004\u0018\u00010KH\u0017J\u0018\u0010L\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u0017H\u0017J\u0018\u0010M\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010?\u001a\u00020'H\u0017J\u0018\u0010N\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u0011H\u0017J\u0018\u0010O\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010?\u001a\u00020'H\u0017J\u0018\u0010P\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u0017H\u0017J\u001a\u0010Q\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010?\u001a\u0004\u0018\u00010\tH\u0016J\u0014\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001b0SH\u0016J\u000e\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, m1836d2 = {"Lcom/swmansion/rnscreens/ScreenViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/Screen;", "Lcom/facebook/react/viewmanagers/RNSScreenManagerInterface;", "<init>", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getName", "", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "setActivityState", "", "view", "activityState", "", "addView", "parent", "child", "Landroid/view/View;", ArrayContainsMatcher.INDEX_KEY, "", "removeViewAt", "removeView", "updateState", "", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "onAfterUpdateTransaction", "setStackPresentation", "presentation", "setStackAnimation", "animation", "setGestureEnabled", "gestureEnabled", "", "setReplaceAnimation", "setScreenOrientation", "screenOrientation", "setStatusBarAnimation", "statusBarAnimation", "setStatusBarColor", "statusBarColor", "(Lcom/swmansion/rnscreens/Screen;Ljava/lang/Integer;)V", "setStatusBarStyle", "statusBarStyle", "setStatusBarTranslucent", "statusBarTranslucent", "setStatusBarHidden", "statusBarHidden", "setNavigationBarColor", "navigationBarColor", "setNavigationBarTranslucent", "navigationBarTranslucent", "setNavigationBarHidden", "navigationBarHidden", "setNativeBackButtonDismissalEnabled", "nativeBackButtonDismissalEnabled", "setSheetElevation", "value", "setFullScreenSwipeEnabled", "setFullScreenSwipeShadowEnabled", "setTransitionDuration", "setHideKeyboardOnSwipe", "setCustomAnimationOnSwipe", "setGestureResponseDistance", "Lcom/facebook/react/bridge/ReadableMap;", "setHomeIndicatorHidden", "setPreventNativeDismiss", "setSwipeDirection", "setSheetAllowedDetents", "Lcom/facebook/react/bridge/ReadableArray;", "setSheetLargestUndimmedDetent", "setSheetGrabberVisible", "setSheetCornerRadius", "setSheetExpandsWhenScrolledToEdge", "setSheetInitialDetent", "setScreenId", "getExportedCustomDirectEventTypeConstants", "", "getDelegate", "Companion", "react-native-screens_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@ReactModule(name = ScreenViewManager.REACT_CLASS)
@SourceDebugExtension({"SMAP\nScreenViewManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScreenViewManager.kt\ncom/swmansion/rnscreens/ScreenViewManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,405:1\n1#2:406\n*E\n"})
public class ScreenViewManager extends ViewGroupManager<Screen> implements RNSScreenManagerInterface<Screen> {

    @NotNull
    public static final String REACT_CLASS = "RNSScreen";

    @NotNull
    private final ViewManagerDelegate<Screen> delegate = new RNSScreenManagerDelegate(this);

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setCustomAnimationOnSwipe(@Nullable Screen view, boolean value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setFullScreenSwipeEnabled(@Nullable Screen view, boolean value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setFullScreenSwipeShadowEnabled(@Nullable Screen view, boolean value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setGestureResponseDistance(@Nullable Screen view, @Nullable ReadableMap value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setHideKeyboardOnSwipe(@Nullable Screen view, boolean value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setHomeIndicatorHidden(@Nullable Screen view, boolean value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setPreventNativeDismiss(@Nullable Screen view, boolean value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setSwipeDirection(@Nullable Screen view, @Nullable String value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setTransitionDuration(@Nullable Screen view, int value) {
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public Screen createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new Screen(reactContext);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setActivityState(@NotNull Screen view, float activityState) {
        Intrinsics.checkNotNullParameter(view, "view");
        setActivityState(view, (int) activityState);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(@NotNull Screen parent, @NotNull View child, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (child instanceof ScreenContentWrapper) {
            parent.registerLayoutCallbackForWrapper((ScreenContentWrapper) child);
        } else if (child instanceof ScreenFooter) {
            parent.setFooter((ScreenFooter) child);
        }
        super.addView(parent, child, index);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(@NotNull Screen parent, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (parent.getChildAt(index) instanceof ScreenFooter) {
            parent.setFooter(null);
        }
        super.removeViewAt(parent, index);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeView(@NotNull Screen parent, @NotNull View view) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(view, "view");
        super.removeView(parent, view);
        if (view instanceof ScreenFooter) {
            parent.setFooter(null);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    public Object updateState(@NotNull Screen view, @Nullable ReactStylesDiffMap props, @Nullable StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStateWrapper(stateWrapper);
        return super.updateState(view, props, stateWrapper);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(@NotNull Screen view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction(view);
        view.onFinalizePropsUpdate$react_native_screens_release();
    }

    @ReactProp(name = "activityState")
    public final void setActivityState(@NotNull Screen view, int activityState) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (activityState == -1) {
            return;
        }
        if (activityState == 0) {
            view.setActivityState(Screen.ActivityState.INACTIVE);
        } else if (activityState == 1) {
            view.setActivityState(Screen.ActivityState.TRANSITIONING_OR_BELOW_TOP);
        } else {
            if (activityState != 2) {
                return;
            }
            view.setActivityState(Screen.ActivityState.ON_TOP);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r3.equals("fullScreenModal") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r3.equals("containedTransparentModal") != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        if (r3.equals("pageSheet") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        if (r3.equals("containedModal") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0044, code lost:
    
        if (r3.equals("modal") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        r1 = com.swmansion.rnscreens.Screen.StackPresentation.MODAL;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
    
        if (r3.equals("transparentModal") != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
    
        r1 = com.swmansion.rnscreens.Screen.StackPresentation.TRANSPARENT_MODAL;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "stackPresentation")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setStackPresentation(@NotNull Screen view, @Nullable String presentation) {
        Screen.StackPresentation stackPresentation;
        Intrinsics.checkNotNullParameter(view, "view");
        if (presentation != null) {
            switch (presentation.hashCode()) {
                case -76271493:
                    break;
                case 3452698:
                    if (presentation.equals(AirshipConfigOptions.FEATURE_PUSH)) {
                        stackPresentation = Screen.StackPresentation.PUSH;
                        view.setStackPresentation(stackPresentation);
                        return;
                    }
                    break;
                case 104069805:
                    break;
                case 438078970:
                    break;
                case 872434704:
                    break;
                case 955284238:
                    break;
                case 1171936146:
                    break;
                case 1798290171:
                    if (presentation.equals("formSheet")) {
                        stackPresentation = Screen.StackPresentation.FORM_SHEET;
                        view.setStackPresentation(stackPresentation);
                        return;
                    }
                    break;
            }
        }
        throw new JSApplicationIllegalArgumentException("Unknown presentation type " + presentation);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        if (r3.equals("default") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:
    
        if (r3.equals("flip") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0083, code lost:
    
        if (r3.equals("simple_push") != false) goto L42;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "stackAnimation")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setStackAnimation(@NotNull Screen view, @Nullable String animation) {
        Screen.StackAnimation stackAnimation;
        Intrinsics.checkNotNullParameter(view, "view");
        if (animation != null) {
            switch (animation.hashCode()) {
                case -1418955385:
                    break;
                case -1198710326:
                    if (animation.equals("ios_from_left")) {
                        stackAnimation = Screen.StackAnimation.IOS_FROM_LEFT;
                        break;
                    }
                    throw new JSApplicationIllegalArgumentException("Unknown animation type " + animation);
                case -427095442:
                    if (animation.equals("slide_from_left")) {
                        stackAnimation = Screen.StackAnimation.SLIDE_FROM_LEFT;
                        break;
                    }
                    throw new JSApplicationIllegalArgumentException("Unknown animation type " + animation);
                case -349395819:
                    if (animation.equals("slide_from_right")) {
                        stackAnimation = Screen.StackAnimation.SLIDE_FROM_RIGHT;
                        break;
                    }
                    throw new JSApplicationIllegalArgumentException("Unknown animation type " + animation);
                case 3135100:
                    if (animation.equals("fade")) {
                        stackAnimation = Screen.StackAnimation.FADE;
                        break;
                    }
                    throw new JSApplicationIllegalArgumentException("Unknown animation type " + animation);
                case 3145837:
                    break;
                case 3387192:
                    if (animation.equals("none")) {
                        stackAnimation = Screen.StackAnimation.NONE;
                        break;
                    }
                    throw new JSApplicationIllegalArgumentException("Unknown animation type " + animation);
                case 182437661:
                    if (animation.equals("fade_from_bottom")) {
                        stackAnimation = Screen.StackAnimation.FADE_FROM_BOTTOM;
                        break;
                    }
                    throw new JSApplicationIllegalArgumentException("Unknown animation type " + animation);
                case 1500346553:
                    if (animation.equals("ios_from_right")) {
                        stackAnimation = Screen.StackAnimation.IOS_FROM_RIGHT;
                        break;
                    }
                    throw new JSApplicationIllegalArgumentException("Unknown animation type " + animation);
                case 1544803905:
                    break;
                case 1601504978:
                    if (animation.equals("slide_from_bottom")) {
                        stackAnimation = Screen.StackAnimation.SLIDE_FROM_BOTTOM;
                        break;
                    }
                    throw new JSApplicationIllegalArgumentException("Unknown animation type " + animation);
                default:
                    throw new JSApplicationIllegalArgumentException("Unknown animation type " + animation);
            }
        } else {
            stackAnimation = Screen.StackAnimation.DEFAULT;
        }
        view.setStackAnimation(stackAnimation);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(defaultBoolean = true, name = "gestureEnabled")
    public void setGestureEnabled(@NotNull Screen view, boolean gestureEnabled) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setGestureEnabled(gestureEnabled);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "replaceAnimation")
    public void setReplaceAnimation(@NotNull Screen view, @Nullable String animation) {
        Screen.ReplaceAnimation replaceAnimation;
        Intrinsics.checkNotNullParameter(view, "view");
        if (animation == null || Intrinsics.areEqual(animation, "pop")) {
            replaceAnimation = Screen.ReplaceAnimation.POP;
        } else {
            if (!Intrinsics.areEqual(animation, AirshipConfigOptions.FEATURE_PUSH)) {
                throw new JSApplicationIllegalArgumentException("Unknown replace animation type " + animation);
            }
            replaceAnimation = Screen.ReplaceAnimation.PUSH;
        }
        view.setReplaceAnimation(replaceAnimation);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "screenOrientation")
    public void setScreenOrientation(@NotNull Screen view, @Nullable String screenOrientation) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScreenOrientation(screenOrientation);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "statusBarAnimation")
    public void setStatusBarAnimation(@NotNull Screen view, @Nullable String statusBarAnimation) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarAnimated(Boolean.valueOf((statusBarAnimation == null || Intrinsics.areEqual("none", statusBarAnimation)) ? false : true));
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @Deprecated(message = "For apps targeting SDK 35 or above this prop has no effect. Since the edge-to-edge is enabled by default the color is always translucent.")
    @ReactProp(customType = "Color", name = "statusBarColor")
    public void setStatusBarColor(@NotNull Screen view, @Nullable Integer statusBarColor) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarColor(statusBarColor);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "statusBarStyle")
    public void setStatusBarStyle(@NotNull Screen view, @Nullable String statusBarStyle) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarStyle(statusBarStyle);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @Deprecated(message = "For apps targeting SDK 35 or above edge-to-edge is enabled by default and will be enforced in the future.")
    @ReactProp(name = "statusBarTranslucent")
    public void setStatusBarTranslucent(@NotNull Screen view, boolean statusBarTranslucent) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarTranslucent(Boolean.valueOf(statusBarTranslucent));
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "statusBarHidden")
    public void setStatusBarHidden(@NotNull Screen view, boolean statusBarHidden) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarHidden(Boolean.valueOf(statusBarHidden));
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @Deprecated(message = "For apps targeting SDK 35 or above this prop has no effect")
    @ReactProp(customType = "Color", name = "navigationBarColor")
    public void setNavigationBarColor(@NotNull Screen view, @Nullable Integer navigationBarColor) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNavigationBarColor(navigationBarColor);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @Deprecated(message = "For apps targeting SDK 35 or above edge-to-edge is enabled by default")
    @ReactProp(name = "navigationBarTranslucent")
    public void setNavigationBarTranslucent(@NotNull Screen view, boolean navigationBarTranslucent) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNavigationBarTranslucent(Boolean.valueOf(navigationBarTranslucent));
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "navigationBarHidden")
    public void setNavigationBarHidden(@NotNull Screen view, boolean navigationBarHidden) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNavigationBarHidden(Boolean.valueOf(navigationBarHidden));
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "nativeBackButtonDismissalEnabled")
    public void setNativeBackButtonDismissalEnabled(@NotNull Screen view, boolean nativeBackButtonDismissalEnabled) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNativeBackButtonDismissalEnabled(nativeBackButtonDismissalEnabled);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "sheetElevation")
    public void setSheetElevation(@Nullable Screen view, int value) {
        if (view != null) {
            view.setSheetElevation(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "sheetAllowedDetents")
    public void setSheetAllowedDetents(@NotNull Screen view, @Nullable final ReadableArray value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.getSheetDetents().clear();
        if (value == null || value.size() == 0) {
            view.getSheetDetents().add(Double.valueOf(1.0d));
        } else {
            SequencesKt.toCollection(SequencesKt.map(CollectionsKt.asSequence(IntProgression.INSTANCE.fromClosedRange(0, value.size() - 1, 1)), new Function1() { // from class: com.swmansion.rnscreens.ScreenViewManager$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Double.valueOf(value.getDouble(((Integer) obj).intValue()));
                }
            }), view.getSheetDetents());
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "sheetLargestUndimmedDetent")
    public void setSheetLargestUndimmedDetent(@NotNull Screen view, int value) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (-1 > value || value >= 3) {
            throw new IllegalStateException("[RNScreens] sheetLargestUndimmedDetent on Android supports values between -1 and 2");
        }
        view.setSheetLargestUndimmedDetentIndex(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "sheetGrabberVisible")
    public void setSheetGrabberVisible(@NotNull Screen view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSheetGrabberVisible(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "sheetCornerRadius")
    public void setSheetCornerRadius(@NotNull Screen view, float value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSheetCornerRadius(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "sheetExpandsWhenScrolledToEdge")
    public void setSheetExpandsWhenScrolledToEdge(@NotNull Screen view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSheetExpandsWhenScrolledToEdge(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    @ReactProp(name = "sheetInitialDetent")
    public void setSheetInitialDetent(@NotNull Screen view, int value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSheetInitialDetentIndex(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSScreenManagerInterface
    public void setScreenId(@NotNull Screen view, @Nullable String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (value == null || value.length() == 0) {
            value = null;
        }
        view.setScreenId(value);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @NotNull
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapsKt.mutableMapOf(TuplesKt.m1842to(ScreenDismissedEvent.EVENT_NAME, MapsKt.hashMapOf(TuplesKt.m1842to("registrationName", "onDismissed"))), TuplesKt.m1842to("topWillAppear", MapsKt.hashMapOf(TuplesKt.m1842to("registrationName", TabScreenWillAppearEvent.EVENT_REGISTRATION_NAME))), TuplesKt.m1842to(ScreenAppearEvent.EVENT_NAME, MapsKt.hashMapOf(TuplesKt.m1842to("registrationName", "onAppear"))), TuplesKt.m1842to("topWillDisappear", MapsKt.hashMapOf(TuplesKt.m1842to("registrationName", TabScreenWillDisappearEvent.EVENT_REGISTRATION_NAME))), TuplesKt.m1842to(ScreenDisappearEvent.EVENT_NAME, MapsKt.hashMapOf(TuplesKt.m1842to("registrationName", "onDisappear"))), TuplesKt.m1842to(HeaderHeightChangeEvent.EVENT_NAME, MapsKt.hashMapOf(TuplesKt.m1842to("registrationName", "onHeaderHeightChange"))), TuplesKt.m1842to(HeaderBackButtonClickedEvent.EVENT_NAME, MapsKt.hashMapOf(TuplesKt.m1842to("registrationName", "onHeaderBackButtonClicked"))), TuplesKt.m1842to(ScreenTransitionProgressEvent.EVENT_NAME, MapsKt.hashMapOf(TuplesKt.m1842to("registrationName", "onTransitionProgress"))), TuplesKt.m1842to(SheetDetentChangedEvent.EVENT_NAME, MapsKt.hashMapOf(TuplesKt.m1842to("registrationName", "onSheetDetentChanged"))));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    protected ViewManagerDelegate<Screen> getDelegate() {
        return this.delegate;
    }
}
