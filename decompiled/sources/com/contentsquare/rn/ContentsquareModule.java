package com.contentsquare.rn;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import com.contentsquare.android.Contentsquare;
import com.contentsquare.android.api.bridge.xpf.ExternalBridgeInterface;
import com.contentsquare.android.api.bridge.xpf.ExternalBridgeSessionReplayCapture;
import com.contentsquare.android.api.bridge.xpf.ExternalBridgeType;
import com.contentsquare.android.api.bridge.xpf.XpfMasker;
import com.contentsquare.android.api.model.CustomVar;
import com.contentsquare.android.api.model.Transaction;
import com.contentsquare.rn.eventEmitter.CSEventEmitter;
import com.contentsquare.rn.externalbridge.ExternalBridgeInterfaceImpl;
import com.contentsquare.rn.externalbridge.XpfInterfaceBridge;
import com.contentsquare.rn.masking.ViewMasker;
import com.contentsquare.rn.utils.LogMonitorUtil;
import com.contentsquare.rn.utils.MapUtil;
import com.contentsquare.rn.utils.ReactNativeUiThreadUtil;
import com.contentsquare.rn.webview.WebViewInjector;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ContentsquareModule extends ReactContextBaseJavaModule {
    private ExternalBridgeInterface externalBridgeInterface;

    @NonNull
    private final CSEventEmitter mCSEventEmitter;
    private ExternalBridgeSessionReplayCapture mExternalBridgeSessionReplayCapture;

    @NonNull
    private final ReactApplicationContext mReactContext;

    @NonNull
    private final ReactNativeUiThreadUtil mReactNativeUiThreadUtil;

    @NonNull
    private final ViewMasker mViewMasker;

    @NonNull
    private final WebViewInjector mWebViewInjector;

    ContentsquareModule(@NonNull ReactApplicationContext reactApplicationContext, @NonNull WebViewInjector webViewInjector, @NonNull ViewMasker viewMasker, CSEventEmitter cSEventEmitter, @NonNull ReactNativeUiThreadUtil reactNativeUiThreadUtil) {
        super(reactApplicationContext);
        this.mReactContext = reactApplicationContext;
        this.mWebViewInjector = webViewInjector;
        this.mViewMasker = viewMasker;
        this.mCSEventEmitter = cSEventEmitter;
        this.mReactNativeUiThreadUtil = reactNativeUiThreadUtil;
        XpfInterfaceBridge xpfInterfaceBridgeDefaultInstance = XpfInterfaceBridge.Factory.defaultInstance();
        ExternalBridgeInterfaceImpl externalBridgeInterfaceImpl = new ExternalBridgeInterfaceImpl(this, cSEventEmitter, ExternalBridgeType.REACT_NATIVE);
        this.externalBridgeInterface = externalBridgeInterfaceImpl;
        xpfInterfaceBridgeDefaultInstance.registerExternalBridge(externalBridgeInterfaceImpl);
    }

    public void setExternalBridgeSessionReplayCapture(ExternalBridgeSessionReplayCapture externalBridgeSessionReplayCapture) {
        this.mExternalBridgeSessionReplayCapture = externalBridgeSessionReplayCapture;
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return "ContentsquareModule";
    }

    @ReactMethod
    public void start() {
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$start$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$0() {
        Contentsquare.start(this.mReactContext);
    }

    @ReactMethod
    public void send(final String str, ReadableArray readableArray) {
        if (readableArray == null) {
            this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    Contentsquare.send(str);
                }
            });
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            if (readableArray.getType(i) == ReadableType.Map) {
                MapUtil.convertAndAddToCustomVarList(readableArray.getMap(i), arrayList);
            } else {
                Log.i("CSLIB", "The provided Custom Var does not match the expected format type.");
            }
        }
        final CustomVar[] customVarArr = (CustomVar[]) arrayList.toArray(new CustomVar[0]);
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                Contentsquare.send(str, customVarArr);
            }
        });
    }

    @ReactMethod
    public void optIn() {
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$optIn$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$optIn$3() {
        Contentsquare.optIn(this.mReactContext);
    }

    @ReactMethod
    public void optOut() {
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$optOut$4();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$optOut$4() {
        Contentsquare.optOut(this.mReactContext);
    }

    @ReactMethod
    public void forgetMe() {
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                Contentsquare.forgetMe();
            }
        });
    }

    @ReactMethod
    public void setDefaultMasking(final boolean z) {
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda24
            @Override // java.lang.Runnable
            public final void run() {
                Contentsquare.setDefaultMasking(z);
            }
        });
    }

    @ReactMethod
    public void sendTransaction(@Nullable String str, float f, int i) {
        final Transaction.TransactionBuilder transactionBuilderBuilder = Transaction.INSTANCE.builder(f, i);
        if (str != null) {
            transactionBuilderBuilder.id(str);
        }
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                ContentsquareModule.lambda$sendTransaction$7(transactionBuilderBuilder);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendTransaction$7(Transaction.TransactionBuilder transactionBuilder) {
        Contentsquare.send(transactionBuilder.build());
    }

    @ReactMethod
    public void sendTransactionWithStringCurrency(@Nullable String str, float f, @NonNull String str2) {
        final Transaction.TransactionBuilder transactionBuilderBuilder = Transaction.INSTANCE.builder(f, str2);
        if (str != null) {
            transactionBuilderBuilder.id(str);
        }
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                ContentsquareModule.lambda$sendTransactionWithStringCurrency$8(transactionBuilderBuilder);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendTransactionWithStringCurrency$8(Transaction.TransactionBuilder transactionBuilder) {
        Contentsquare.send(transactionBuilder.build());
    }

    @ReactMethod
    public void sendDynamicStringVar(@NonNull final String str, @NonNull final String str2) {
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                Contentsquare.send(str, str2);
            }
        });
    }

    @ReactMethod
    public void sendDynamicIntVar(@NonNull final String str, final int i) {
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                ContentsquareModule.lambda$sendDynamicIntVar$10(str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendDynamicIntVar$10(String str, int i) {
        Contentsquare.send(str, i);
    }

    @ReactMethod
    public void stopTracking() {
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Contentsquare.stopTracking();
            }
        });
    }

    @ReactMethod
    public void resumeTracking() {
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                Contentsquare.resumeTracking();
            }
        });
    }

    @ReactMethod
    public void getUserId(final Callback callback) {
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                ContentsquareModule.lambda$getUserId$13(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getUserId$13(Callback callback) {
        callback.invoke(Contentsquare.getUserId());
    }

    @ReactMethod
    public void getCurrentSessionReplayLink(final Callback callback) {
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                ContentsquareModule.lambda$getCurrentSessionReplayLink$14(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getCurrentSessionReplayLink$14(Callback callback) {
        String strCurrentSessionReplayLink = Contentsquare.currentSessionReplayLink();
        if (strCurrentSessionReplayLink == null || strCurrentSessionReplayLink.equals("INACTIVE")) {
            callback.invoke(null);
        } else {
            callback.invoke(strCurrentSessionReplayLink);
        }
    }

    @ReactMethod
    public void setOnSessionReplayLinkChange() {
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setOnSessionReplayLinkChange$16();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnSessionReplayLinkChange$16() {
        Contentsquare.onSessionReplayLinkChange(new Consumer() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda21
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$setOnSessionReplayLinkChange$15((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnSessionReplayLinkChange$15(String str) {
        this.mCSEventEmitter.sendSessionReplayLink(str);
    }

    @ReactMethod
    public void initComponents(@NonNull final ReadableMap readableMap) {
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
                ContentsquareModule.lambda$initComponents$17(readableMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void lambda$initComponents$17(com.facebook.react.bridge.ReadableMap r9) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            java.lang.String r0 = "CSLIB"
            com.facebook.react.bridge.WritableMap r1 = com.facebook.react.bridge.Arguments.createMap()     // Catch: java.lang.Exception -> L42
            r1.merge(r9)     // Catch: java.lang.Exception -> L42
            java.lang.String r9 = "xpf_rn_new_arch_enabled"
            r2 = 1
            r1.putBoolean(r9, r2)     // Catch: java.lang.Exception -> L42
            java.lang.Class<com.contentsquare.android.api.bridge.telemetry.TelemetryInterface> r9 = com.contentsquare.android.api.bridge.telemetry.TelemetryInterface.class
            java.lang.Object r3 = r9.newInstance()     // Catch: java.lang.Exception -> L42
            com.facebook.react.bridge.ReadableMapKeySetIterator r4 = r1.keySetIterator()     // Catch: java.lang.Exception -> L42
        L19:
            boolean r5 = r4.hasNextKey()     // Catch: java.lang.Exception -> L42
            if (r5 == 0) goto Le5
            java.lang.String r5 = r4.nextKey()     // Catch: java.lang.Exception -> L42
            int r6 = r5.hashCode()     // Catch: java.lang.Exception -> L42
            r7 = -1983476629(0xffffffff89c68c6b, float:-4.7798815E-33)
            r8 = 2
            if (r6 == r7) goto L4f
            r7 = 264356371(0xfc1c213, float:1.9106024E-29)
            if (r6 == r7) goto L45
            r7 = 1612596743(0x601e4607, float:4.5619243E19)
            if (r6 == r7) goto L38
            goto L59
        L38:
            java.lang.String r6 = "xpf_version"
            boolean r6 = r5.equals(r6)     // Catch: java.lang.Exception -> L42
            if (r6 == 0) goto L59
            r6 = r2
            goto L5a
        L42:
            r9 = move-exception
            goto Ldd
        L45:
            java.lang.String r6 = "xpf_bridge_version"
            boolean r6 = r5.equals(r6)     // Catch: java.lang.Exception -> L42
            if (r6 == 0) goto L59
            r6 = r8
            goto L5a
        L4f:
            java.lang.String r6 = "xpf_type"
            boolean r6 = r5.equals(r6)     // Catch: java.lang.Exception -> L42
            if (r6 == 0) goto L59
            r6 = 0
            goto L5a
        L59:
            r6 = -1
        L5a:
            java.lang.Class<java.lang.Object> r7 = java.lang.Object.class
            if (r6 == 0) goto Lbe
            if (r6 == r2) goto L9f
            if (r6 == r8) goto L81
            java.lang.String r6 = "telemetryCollect"
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            java.lang.Class[] r7 = new java.lang.Class[]{r8, r7}     // Catch: java.lang.Exception -> L7a
            java.lang.reflect.Method r6 = r9.getDeclaredMethod(r6, r7)     // Catch: java.lang.Exception -> L7a
            java.lang.Object r7 = com.contentsquare.rn.utils.MapUtil.getValueForKey(r1, r5)     // Catch: java.lang.Exception -> L7a
            java.lang.Object[] r5 = new java.lang.Object[]{r5, r7}     // Catch: java.lang.Exception -> L7a
            r6.invoke(r3, r5)     // Catch: java.lang.Exception -> L7a
            goto L19
        L7a:
            r5 = move-exception
            java.lang.String r6 = "Exception failure while calling telemetryCollect"
            android.util.Log.d(r0, r6, r5)     // Catch: java.lang.Exception -> L42
            goto L19
        L81:
            java.lang.String r6 = "setXPFBridgeVersion"
            java.lang.Class[] r7 = new java.lang.Class[]{r7}     // Catch: java.lang.Exception -> L97
            java.lang.reflect.Method r6 = r9.getDeclaredMethod(r6, r7)     // Catch: java.lang.Exception -> L97
            java.lang.String r5 = r1.getString(r5)     // Catch: java.lang.Exception -> L97
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch: java.lang.Exception -> L97
            r6.invoke(r3, r5)     // Catch: java.lang.Exception -> L97
            goto L19
        L97:
            r5 = move-exception
            java.lang.String r6 = "Exception failure while calling setXPFBridgeVersion"
            android.util.Log.d(r0, r6, r5)     // Catch: java.lang.Exception -> L42
            goto L19
        L9f:
            java.lang.String r6 = "setXPFVersion"
            java.lang.Class[] r7 = new java.lang.Class[]{r7}     // Catch: java.lang.Exception -> Lb6
            java.lang.reflect.Method r6 = r9.getDeclaredMethod(r6, r7)     // Catch: java.lang.Exception -> Lb6
            java.lang.String r5 = r1.getString(r5)     // Catch: java.lang.Exception -> Lb6
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch: java.lang.Exception -> Lb6
            r6.invoke(r3, r5)     // Catch: java.lang.Exception -> Lb6
            goto L19
        Lb6:
            r5 = move-exception
            java.lang.String r6 = "Exception failure while calling setXPFVersion"
            android.util.Log.d(r0, r6, r5)     // Catch: java.lang.Exception -> L42
            goto L19
        Lbe:
            java.lang.String r6 = "setXPFType"
            java.lang.Class[] r7 = new java.lang.Class[]{r7}     // Catch: java.lang.Exception -> Ld5
            java.lang.reflect.Method r6 = r9.getDeclaredMethod(r6, r7)     // Catch: java.lang.Exception -> Ld5
            java.lang.String r5 = r1.getString(r5)     // Catch: java.lang.Exception -> Ld5
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch: java.lang.Exception -> Ld5
            r6.invoke(r3, r5)     // Catch: java.lang.Exception -> Ld5
            goto L19
        Ld5:
            r5 = move-exception
            java.lang.String r6 = "Exception failure while calling setXPFType"
            android.util.Log.d(r0, r6, r5)     // Catch: java.lang.Exception -> L42
            goto L19
        Ldd:
            java.lang.String r1 = "Exception failure while initializing components"
            android.util.Log.e(r0, r1, r9)
            r9.printStackTrace()
        Le5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.rn.ContentsquareModule.lambda$initComponents$17(com.facebook.react.bridge.ReadableMap):void");
    }

    @ReactMethod
    public void injectWebView(final int i) {
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$injectWebView$18(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$injectWebView$18(int i) {
        this.mWebViewInjector.injectWebView(this.mReactContext, i);
    }

    @ReactMethod
    public void removeWebViewInjection(final int i) {
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeWebViewInjection$19(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeWebViewInjection$19(int i) {
        this.mWebViewInjector.removeWebViewInjection(this.mReactContext, i);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        for (Map.Entry<String, Integer> entry : Constants.currencies.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    @ReactMethod
    public void maskView(final int i) {
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$maskView$20(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$maskView$20(int i) {
        this.mViewMasker.maskView(this.mReactContext, i);
    }

    @ReactMethod
    public void unmaskView(final int i) {
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$unmaskView$21(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$unmaskView$21(int i) {
        this.mViewMasker.unmaskView(this.mReactContext, i);
    }

    @ReactMethod
    public void sendUserIdentifier(@NonNull final String str) {
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Contentsquare.sendUserIdentifier(str);
            }
        });
    }

    @ReactMethod
    public void monitorWarn(@NonNull final ReadableMap readableMap) {
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
                LogMonitorUtil.monitorWarn(readableMap);
            }
        });
    }

    @ReactMethod
    public void monitorError(@NonNull final ReadableMap readableMap) {
        this.mReactNativeUiThreadUtil.runOnUiThread(new Runnable() { // from class: com.contentsquare.rn.ContentsquareModule$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
                LogMonitorUtil.monitorError(readableMap);
            }
        });
    }

    @ReactMethod
    public void setSessionReplayCapture() {
        ExternalBridgeSessionReplayCapture externalBridgeSessionReplayCapture = this.mExternalBridgeSessionReplayCapture;
        if (externalBridgeSessionReplayCapture != null) {
            externalBridgeSessionReplayCapture.captureFrame();
        } else {
            Log.d("CSLIB", "ExternalBridgeSessionReplayCapture instance is null");
        }
    }

    @ReactMethod
    public void addMaskedView() {
        XpfMasker.INSTANCE.addMaskedView();
    }

    @ReactMethod
    public void removeMaskedView() {
        XpfMasker.INSTANCE.removeMaskedView();
    }
}
