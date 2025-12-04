package com.contentsquare.rn;

import androidx.annotation.NonNull;
import com.contentsquare.rn.erroranalysis.ErrorAnalysisModule;
import com.contentsquare.rn.eventEmitter.CSEventEmitter;
import com.contentsquare.rn.masking.ViewMasker;
import com.contentsquare.rn.utils.ReactNativeUiThreadUtil;
import com.contentsquare.rn.utils.ReactNativeViewFinder;
import com.contentsquare.rn.webview.WebViewInjector;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class ContentsquareModulePackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    @NonNull
    public List<NativeModule> createNativeModules(@NonNull ReactApplicationContext reactApplicationContext) {
        ReactNativeUiThreadUtil reactNativeUiThreadUtil = new ReactNativeUiThreadUtil();
        ReactNativeViewFinder reactNativeViewFinder = new ReactNativeViewFinder(reactNativeUiThreadUtil);
        WebViewInjector webViewInjector = new WebViewInjector(reactNativeViewFinder, new WebViewInjector.SDKWebViewManager());
        ViewMasker viewMasker = new ViewMasker(reactNativeViewFinder);
        CSEventEmitter cSEventEmitter = new CSEventEmitter(reactApplicationContext);
        return Arrays.asList(new ContentsquareModule(reactApplicationContext, webViewInjector, viewMasker, cSEventEmitter, reactNativeUiThreadUtil), new ErrorAnalysisModule(reactApplicationContext), cSEventEmitter);
    }

    @Override // com.facebook.react.ReactPackage
    @NonNull
    public List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
