package com.mrousavy.camera.react;

import android.hardware.camera2.CameraManager;
import android.os.Handler;
import android.util.Log;
import androidx.camera.core.CameraInfo;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.lifecycle.ProcessCameraProvider;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.common.util.concurrent.ListenableFuture;
import com.mrousavy.camera.core.CameraDeviceDetails;
import com.mrousavy.camera.core.CameraQueues;
import com.mrousavy.camera.core.extensions.ListenableFuture_awaitKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0011\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u0016J\u0016\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0014H\u0007J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006$"}, d2 = {"Lcom/mrousavy/camera/react/CameraDevicesManager;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "executor", "Ljava/util/concurrent/ExecutorService;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "cameraProvider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "extensionsManager", "Landroidx/camera/extensions/ExtensionsManager;", "callback", "com/mrousavy/camera/react/CameraDevicesManager$callback$1", "Lcom/mrousavy/camera/react/CameraDevicesManager$callback$1;", "getName", "", "initialize", "", "invalidate", "getDevicesJson", "Lcom/facebook/react/bridge/ReadableArray;", "sendAvailableDevicesChangedEvent", "getConstants", "", "", "addListener", "eventName", "removeListeners", "count", "", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCameraDevicesManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CameraDevicesManager.kt\ncom/mrousavy/camera/react/CameraDevicesManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,126:1\n1863#2,2:127\n*S KotlinDebug\n*F\n+ 1 CameraDevicesManager.kt\ncom/mrousavy/camera/react/CameraDevicesManager\n*L\n94#1:127,2\n*E\n"})
/* loaded from: classes4.dex */
public final class CameraDevicesManager extends ReactContextBaseJavaModule {

    @NotNull
    private static final String TAG = "CameraDevices";

    @NotNull
    private final CameraDevicesManager$callback$1 callback;

    @NotNull
    private final CameraManager cameraManager;

    @Nullable
    private ProcessCameraProvider cameraProvider;

    @NotNull
    private final CoroutineScope coroutineScope;

    @NotNull
    private final ExecutorService executor;

    @Nullable
    private ExtensionsManager extensionsManager;

    @NotNull
    private final ReactApplicationContext reactContext;

    @ReactMethod
    public final void addListener(@NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    @ReactMethod
    public final void removeListeners(int count) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r8v3, types: [com.mrousavy.camera.react.CameraDevicesManager$callback$1] */
    public CameraDevicesManager(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        ExecutorService cameraExecutor = CameraQueues.INSTANCE.getCameraExecutor();
        this.executor = cameraExecutor;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(cameraExecutor));
        this.coroutineScope = CoroutineScope;
        Object systemService = reactContext.getSystemService("camera");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        this.cameraManager = (CameraManager) systemService;
        this.callback = new CameraManager.AvailabilityCallback() { // from class: com.mrousavy.camera.react.CameraDevicesManager$callback$1
            private List deviceIds;

            {
                String[] cameraIdList = this.this$0.cameraManager.getCameraIdList();
                Intrinsics.checkNotNullExpressionValue(cameraIdList, "getCameraIdList(...)");
                this.deviceIds = ArraysKt.toMutableList(cameraIdList);
            }

            private final boolean isDeviceConnected(String cameraId) {
                try {
                    this.this$0.cameraManager.getCameraCharacteristics(cameraId);
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }

            @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
            public void onCameraAvailable(String cameraId) {
                Intrinsics.checkNotNullParameter(cameraId, "cameraId");
                Log.i("CameraDevices", "Camera #" + cameraId + " is now available.");
                if (this.deviceIds.contains(cameraId)) {
                    return;
                }
                this.deviceIds.add(cameraId);
                this.this$0.sendAvailableDevicesChangedEvent();
            }

            @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
            public void onCameraUnavailable(String cameraId) {
                Intrinsics.checkNotNullParameter(cameraId, "cameraId");
                Log.i("CameraDevices", "Camera #" + cameraId + " is now unavailable.");
                if (!this.deviceIds.contains(cameraId) || isDeviceConnected(cameraId)) {
                    return;
                }
                this.deviceIds.remove(cameraId);
                this.this$0.sendAvailableDevicesChangedEvent();
            }
        };
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return TAG;
    }

    /* renamed from: com.mrousavy.camera.react.CameraDevicesManager$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        Object L$0;
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return CameraDevicesManager.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CameraDevicesManager cameraDevicesManager;
            CameraDevicesManager cameraDevicesManager2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (Throwable th) {
                Log.e(CameraDevicesManager.TAG, "Failed to initialize ProcessCameraProvider/ExtensionsManager! Error: " + th.getMessage(), th);
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Log.i(CameraDevicesManager.TAG, "Initializing ProcessCameraProvider...");
                cameraDevicesManager = CameraDevicesManager.this;
                ListenableFuture<ProcessCameraProvider> companion = ProcessCameraProvider.INSTANCE.getInstance(cameraDevicesManager.reactContext);
                ExecutorService executorService = CameraDevicesManager.this.executor;
                this.L$0 = cameraDevicesManager;
                this.label = 1;
                obj = ListenableFuture_awaitKt.await(companion, executorService, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    cameraDevicesManager2 = (CameraDevicesManager) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    cameraDevicesManager2.extensionsManager = (ExtensionsManager) obj;
                    Log.i(CameraDevicesManager.TAG, "Successfully initialized!");
                    CameraDevicesManager.this.sendAvailableDevicesChangedEvent();
                    return Unit.INSTANCE;
                }
                cameraDevicesManager = (CameraDevicesManager) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            cameraDevicesManager.cameraProvider = (ProcessCameraProvider) obj;
            Log.i(CameraDevicesManager.TAG, "Initializing ExtensionsManager...");
            CameraDevicesManager cameraDevicesManager3 = CameraDevicesManager.this;
            ReactApplicationContext reactApplicationContext = cameraDevicesManager3.reactContext;
            ProcessCameraProvider processCameraProvider = CameraDevicesManager.this.cameraProvider;
            Intrinsics.checkNotNull(processCameraProvider);
            ListenableFuture<ExtensionsManager> instanceAsync = ExtensionsManager.getInstanceAsync(reactApplicationContext, processCameraProvider);
            Intrinsics.checkNotNullExpressionValue(instanceAsync, "getInstanceAsync(...)");
            ExecutorService executorService2 = CameraDevicesManager.this.executor;
            this.L$0 = cameraDevicesManager3;
            this.label = 2;
            Object objAwait = ListenableFuture_awaitKt.await(instanceAsync, executorService2, this);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
            cameraDevicesManager2 = cameraDevicesManager3;
            obj = objAwait;
            cameraDevicesManager2.extensionsManager = (ExtensionsManager) obj;
            Log.i(CameraDevicesManager.TAG, "Successfully initialized!");
            CameraDevicesManager.this.sendAvailableDevicesChangedEvent();
            return Unit.INSTANCE;
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        super.initialize();
        this.cameraManager.registerAvailabilityCallback(this.callback, (Handler) null);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        this.cameraManager.unregisterAvailabilityCallback(this.callback);
        super.invalidate();
    }

    private final ReadableArray getDevicesJson() {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        ProcessCameraProvider processCameraProvider = this.cameraProvider;
        if (processCameraProvider == null) {
            Intrinsics.checkNotNull(writableArrayCreateArray);
            return writableArrayCreateArray;
        }
        ExtensionsManager extensionsManager = this.extensionsManager;
        if (extensionsManager == null) {
            Intrinsics.checkNotNull(writableArrayCreateArray);
            return writableArrayCreateArray;
        }
        Iterator<T> it = processCameraProvider.getAvailableCameraInfos().iterator();
        while (it.hasNext()) {
            writableArrayCreateArray.pushMap(new CameraDeviceDetails((CameraInfo) it.next(), extensionsManager).toMap());
        }
        Intrinsics.checkNotNull(writableArrayCreateArray);
        return writableArrayCreateArray;
    }

    public final void sendAvailableDevicesChangedEvent() {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("CameraDevicesChanged", getDevicesJson());
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    @NotNull
    public Map<String, Object> getConstants() {
        ReadableArray devicesJson = getDevicesJson();
        ReadableMap map = devicesJson.size() > 0 ? devicesJson.getMap(0) : null;
        return MapsKt.mutableMapOf(TuplesKt.to("availableCameraDevices", devicesJson), TuplesKt.to("userPreferredCameraDevice", map != null ? map.toHashMap() : null));
    }
}
