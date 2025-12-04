package com.mrousavy.camera.react;

import android.content.ComponentCallbacks2;
import android.util.Log;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.facebook.react.uimanager.UIManagerHelper;
import com.mrousavy.camera.core.CameraError;
import com.mrousavy.camera.core.CameraQueues;
import com.mrousavy.camera.core.UnknownCameraError;
import com.mrousavy.camera.core.ViewNotFoundError;
import com.mrousavy.camera.core.types.PermissionStatus;
import com.mrousavy.camera.core.types.RecordVideoOptions;
import com.mrousavy.camera.core.types.TakeSnapshotOptions;
import com.mrousavy.camera.frameprocessors.VisionCameraInstaller;
import com.mrousavy.camera.frameprocessors.VisionCameraProxy;
import com.mrousavy.camera.react.utils.CallbackPromiseKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;

@ReactModule(name = "CameraView")
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0007J \u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J \u0010\u0019\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J \u0010\u001b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0018\u0010 \u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0018\u0010!\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J \u0010\"\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u000bH\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010%\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020\u000bH\u0007J\b\u0010)\u001a\u00020\u000bH\u0007J\b\u0010*\u001a\u00020\u000bH\u0007J\u0018\u0010+\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010,\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010-\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010.\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/mrousavy/camera/react/CameraViewModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "backgroundCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "invalidate", "", "getName", "", "findCameraView", "Lcom/mrousavy/camera/react/CameraView;", "viewId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "installFrameProcessorBindings", "", "takePhoto", "viewTag", "options", "Lcom/facebook/react/bridge/ReadableMap;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "takeSnapshot", "jsOptions", "startRecording", "onRecordCallback", "Lcom/facebook/react/bridge/Callback;", "pauseRecording", "resumeRecording", "stopRecording", "cancelRecording", "focus", "point", "canRequestPermission", "permission", "getPermission", "Lcom/mrousavy/camera/core/types/PermissionStatus;", "getCameraPermissionStatus", "getMicrophonePermissionStatus", "getLocationPermissionStatus", "requestPermission", "requestCameraPermission", "requestMicrophonePermission", "requestLocationPermission", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCameraViewModule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CameraViewModule.kt\ncom/mrousavy/camera/react/CameraViewModule\n+ 2 runOnUiThread.kt\ncom/mrousavy/camera/core/utils/RunOnUiThreadKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,262:1\n9#2,6:263\n15#2,6:278\n351#3,9:269\n360#3,2:284\n*S KotlinDebug\n*F\n+ 1 CameraViewModule.kt\ncom/mrousavy/camera/react/CameraViewModule\n*L\n68#1:263,6\n68#1:278,6\n68#1:269,9\n68#1:284,2\n*E\n"})
/* loaded from: classes4.dex */
public final class CameraViewModule extends ReactContextBaseJavaModule {

    @NotNull
    public static final String TAG = "CameraView";

    @NotNull
    private final CoroutineScope backgroundCoroutineScope;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static int sharedRequestCode = 10;

    /* JADX INFO: Access modifiers changed from: private */
    public final Object findCameraView(final int i, Continuation<? super CameraView> continuation) throws ViewNotFoundError {
        Object result;
        if (UiThreadUtil.isOnUiThread()) {
            Log.d("CameraView", "Finding view " + i + "...");
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            if (reactApplicationContext == null) {
                throw new Error("React Context was null!");
            }
            UIManager uIManager = UIManagerHelper.getUIManager(reactApplicationContext, 2);
            if (uIManager == null) {
                throw new Error("UIManager not found!");
            }
            View viewResolveView = uIManager.resolveView(i);
            result = viewResolveView instanceof CameraView ? (CameraView) viewResolveView : null;
            if (result == null) {
                throw new ViewNotFoundError(i);
            }
            Log.d("CameraView", "Found view " + i + "!");
        } else {
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.mrousavy.camera.react.CameraViewModule$findCameraView$$inlined$runOnUiThreadAndWait$1
                @Override // java.lang.Runnable
                public final void run() throws ViewNotFoundError {
                    if (cancellableContinuationImpl.isCancelled()) {
                        throw new CancellationException();
                    }
                    Log.d("CameraView", "Finding view " + i + "...");
                    ReactApplicationContext reactApplicationContext2 = this.getReactApplicationContext();
                    if (reactApplicationContext2 == null) {
                        throw new Error("React Context was null!");
                    }
                    UIManager uIManager2 = UIManagerHelper.getUIManager(reactApplicationContext2, 2);
                    if (uIManager2 == null) {
                        throw new Error("UIManager not found!");
                    }
                    View viewResolveView2 = uIManager2.resolveView(i);
                    CameraView cameraView = viewResolveView2 instanceof CameraView ? (CameraView) viewResolveView2 : null;
                    if (cameraView == null) {
                        throw new ViewNotFoundError(i);
                    }
                    Log.d("CameraView", "Found view " + i + "!");
                    cancellableContinuationImpl.resumeWith(Result.m2968constructorimpl(cameraView));
                }
            });
            result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
        }
        return result;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/mrousavy/camera/react/CameraViewModule$Companion;", "", "<init>", "()V", "TAG", "", "sharedRequestCode", "", "getSharedRequestCode", "()I", "setSharedRequestCode", "(I)V", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getSharedRequestCode() {
            return CameraViewModule.sharedRequestCode;
        }

        public final void setSharedRequestCode(int i) {
            CameraViewModule.sharedRequestCode = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraViewModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.backgroundCoroutineScope = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(CameraQueues.INSTANCE.getCameraExecutor()));
    }

    static {
        try {
            System.loadLibrary("VisionCamera");
        } catch (UnsatisfiedLinkError e) {
            Log.e(VisionCameraProxy.TAG, "Failed to load VisionCamera C++ library!", e);
            throw e;
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        if (CoroutineScopeKt.isActive(this.backgroundCoroutineScope)) {
            CoroutineScopeKt.cancel$default(this.backgroundCoroutineScope, "CameraViewModule has been destroyed.", null, 2, null);
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "CameraView";
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final boolean installFrameProcessorBindings() {
        try {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
            VisionCameraInstaller.install(new VisionCameraProxy(reactApplicationContext));
            return true;
        } catch (Error e) {
            Log.e("CameraView", "Failed to install Frame Processor JSI Bindings!", e);
            return false;
        }
    }

    /* renamed from: com.mrousavy.camera.react.CameraViewModule$takePhoto$1, reason: invalid class name and case insensitive filesystem */
    static final class C09071 extends SuspendLambda implements Function2 {
        final /* synthetic */ ReadableMap $options;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $viewTag;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09071(int i, Promise promise, ReadableMap readableMap, Continuation continuation) {
            super(2, continuation);
            this.$viewTag = i;
            this.$promise = promise;
            this.$options = readableMap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return CameraViewModule.this.new C09071(this.$viewTag, this.$promise, this.$options, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(1:(1:(6:6|33|7|22|31|32)(2:11|12))(1:13))(2:14|(1:16))|17|35|18|(1:20)(4:21|22|31|32)|(1:(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
        
            r5 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
        
            r4 = r1;
         */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0056  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) throws com.mrousavy.camera.core.ViewNotFoundError {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L24
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                java.lang.Object r4 = r4.L$0
                com.facebook.react.bridge.Promise r4 = (com.facebook.react.bridge.Promise) r4
                kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L16
                goto L46
            L16:
                r5 = move-exception
                goto L4c
            L18:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L20:
                kotlin.ResultKt.throwOnFailure(r5)
                goto L34
            L24:
                kotlin.ResultKt.throwOnFailure(r5)
                com.mrousavy.camera.react.CameraViewModule r5 = com.mrousavy.camera.react.CameraViewModule.this
                int r1 = r4.$viewTag
                r4.label = r3
                java.lang.Object r5 = com.mrousavy.camera.react.CameraViewModule.access$findCameraView(r5, r1, r4)
                if (r5 != r0) goto L34
                return r0
            L34:
                com.mrousavy.camera.react.CameraView r5 = (com.mrousavy.camera.react.CameraView) r5
                com.facebook.react.bridge.Promise r1 = r4.$promise
                com.facebook.react.bridge.ReadableMap r3 = r4.$options
                r4.L$0 = r1     // Catch: java.lang.Throwable -> L4a
                r4.label = r2     // Catch: java.lang.Throwable -> L4a
                java.lang.Object r5 = com.mrousavy.camera.react.CameraView_TakePhotoKt.takePhoto(r5, r3, r4)     // Catch: java.lang.Throwable -> L4a
                if (r5 != r0) goto L45
                return r0
            L45:
                r4 = r1
            L46:
                r4.resolve(r5)     // Catch: java.lang.Throwable -> L16
                goto L83
            L4a:
                r5 = move-exception
                r4 = r1
            L4c:
                r5.printStackTrace()
                boolean r0 = r5 instanceof com.mrousavy.camera.core.CameraError
                if (r0 == 0) goto L56
                com.mrousavy.camera.core.CameraError r5 = (com.mrousavy.camera.core.CameraError) r5
                goto L5c
            L56:
                com.mrousavy.camera.core.UnknownCameraError r0 = new com.mrousavy.camera.core.UnknownCameraError
                r0.<init>(r5)
                r5 = r0
            L5c:
                java.lang.String r0 = r5.getDomain()
                java.lang.String r1 = r5.getId()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r0)
                java.lang.String r0 = "/"
                r2.append(r0)
                r2.append(r1)
                java.lang.String r0 = r2.toString()
                java.lang.String r1 = r5.getMessage()
                java.lang.Throwable r5 = r5.getCause()
                r4.reject(r0, r1, r5)
            L83:
                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.react.CameraViewModule.C09071.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @ReactMethod
    public final void takePhoto(int viewTag, @NotNull ReadableMap options, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new C09071(viewTag, promise, options, null), 3, null);
    }

    /* renamed from: com.mrousavy.camera.react.CameraViewModule$takeSnapshot$1, reason: invalid class name and case insensitive filesystem */
    static final class C09081 extends SuspendLambda implements Function2 {
        final /* synthetic */ ReadableMap $jsOptions;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $viewTag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09081(int i, ReadableMap readableMap, Promise promise, Continuation continuation) {
            super(2, continuation);
            this.$viewTag = i;
            this.$jsOptions = readableMap;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return CameraViewModule.this.new C09081(this.$viewTag, this.$jsOptions, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09081) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws ViewNotFoundError {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CameraViewModule cameraViewModule = CameraViewModule.this;
                int i2 = this.$viewTag;
                this.label = 1;
                obj = cameraViewModule.findCameraView(i2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            final CameraView cameraView = (CameraView) obj;
            final CameraViewModule cameraViewModule2 = CameraViewModule.this;
            final ReadableMap readableMap = this.$jsOptions;
            final Promise promise = this.$promise;
            if (!UiThreadUtil.isOnUiThread()) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.mrousavy.camera.react.CameraViewModule$takeSnapshot$1$invokeSuspend$$inlined$runOnUiThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            TakeSnapshotOptions.Companion companion = TakeSnapshotOptions.INSTANCE;
                            ReactApplicationContext reactApplicationContext = cameraViewModule2.getReactApplicationContext();
                            Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "access$getReactApplicationContext(...)");
                            promise.resolve(CameraView_TakeSnapshotKt.takeSnapshot(cameraView, companion.fromJSValue(reactApplicationContext, readableMap)));
                        } catch (Throwable th) {
                            promise.reject(th);
                        }
                    }
                });
            } else {
                try {
                    TakeSnapshotOptions.Companion companion = TakeSnapshotOptions.INSTANCE;
                    ReactApplicationContext reactApplicationContext = cameraViewModule2.getReactApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "access$getReactApplicationContext(...)");
                    promise.resolve(CameraView_TakeSnapshotKt.takeSnapshot(cameraView, companion.fromJSValue(reactApplicationContext, readableMap)));
                } catch (Throwable th) {
                    promise.reject(th);
                }
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void takeSnapshot(int viewTag, @NotNull ReadableMap jsOptions, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(jsOptions, "jsOptions");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new C09081(viewTag, jsOptions, promise, null), 3, null);
    }

    /* renamed from: com.mrousavy.camera.react.CameraViewModule$startRecording$1, reason: invalid class name and case insensitive filesystem */
    static final class C09051 extends SuspendLambda implements Function2 {
        final /* synthetic */ ReadableMap $jsOptions;
        final /* synthetic */ Callback $onRecordCallback;
        final /* synthetic */ int $viewTag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09051(int i, ReadableMap readableMap, Callback callback, Continuation continuation) {
            super(2, continuation);
            this.$viewTag = i;
            this.$jsOptions = readableMap;
            this.$onRecordCallback = callback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return CameraViewModule.this.new C09051(this.$viewTag, this.$jsOptions, this.$onRecordCallback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws ViewNotFoundError {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CameraViewModule cameraViewModule = CameraViewModule.this;
                int i2 = this.$viewTag;
                this.label = 1;
                obj = cameraViewModule.findCameraView(i2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            CameraView cameraView = (CameraView) obj;
            try {
                RecordVideoOptions.Companion companion = RecordVideoOptions.INSTANCE;
                ReactApplicationContext reactApplicationContext = CameraViewModule.this.getReactApplicationContext();
                Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "access$getReactApplicationContext(...)");
                CameraView_RecordVideoKt.startRecording(cameraView, companion.fromJSValue(reactApplicationContext, this.$jsOptions), this.$onRecordCallback);
            } catch (CameraError e) {
                this.$onRecordCallback.invoke(null, CallbackPromiseKt.makeErrorMap$default(e.getDomain() + "/" + e.getId(), e.getMessage(), e, null, 8, null));
            } catch (Throwable th) {
                this.$onRecordCallback.invoke(null, CallbackPromiseKt.makeErrorMap$default("capture/unknown", "An unknown error occurred while trying to start a video recording! " + th.getMessage(), th, null, 8, null));
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void startRecording(int viewTag, @NotNull ReadableMap jsOptions, @NotNull Callback onRecordCallback) {
        Intrinsics.checkNotNullParameter(jsOptions, "jsOptions");
        Intrinsics.checkNotNullParameter(onRecordCallback, "onRecordCallback");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new C09051(viewTag, jsOptions, onRecordCallback, null), 3, null);
    }

    /* renamed from: com.mrousavy.camera.react.CameraViewModule$pauseRecording$1, reason: invalid class name and case insensitive filesystem */
    static final class C09031 extends SuspendLambda implements Function2 {
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $viewTag;
        Object L$0;
        int label;
        final /* synthetic */ CameraViewModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09031(Promise promise, CameraViewModule cameraViewModule, int i, Continuation continuation) {
            super(2, continuation);
            this.$promise = promise;
            this.this$0 = cameraViewModule;
            this.$viewTag = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C09031(this.$promise, this.this$0, this.$viewTag, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 1
                if (r1 == 0) goto L1d
                if (r1 != r2) goto L15
                java.lang.Object r5 = r5.L$0
                com.facebook.react.bridge.Promise r5 = (com.facebook.react.bridge.Promise) r5
                kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L13
                goto L34
            L13:
                r6 = move-exception
                goto L42
            L15:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1d:
                kotlin.ResultKt.throwOnFailure(r6)
                com.facebook.react.bridge.Promise r6 = r5.$promise
                com.mrousavy.camera.react.CameraViewModule r1 = r5.this$0
                int r3 = r5.$viewTag
                r5.L$0 = r6     // Catch: java.lang.Throwable -> L3e
                r5.label = r2     // Catch: java.lang.Throwable -> L3e
                java.lang.Object r5 = com.mrousavy.camera.react.CameraViewModule.access$findCameraView(r1, r3, r5)     // Catch: java.lang.Throwable -> L3e
                if (r5 != r0) goto L31
                return r0
            L31:
                r4 = r6
                r6 = r5
                r5 = r4
            L34:
                com.mrousavy.camera.react.CameraView r6 = (com.mrousavy.camera.react.CameraView) r6     // Catch: java.lang.Throwable -> L13
                com.mrousavy.camera.react.CameraView_RecordVideoKt.pauseRecording(r6)     // Catch: java.lang.Throwable -> L13
                r6 = 0
                r5.resolve(r6)     // Catch: java.lang.Throwable -> L13
                goto L79
            L3e:
                r5 = move-exception
                r4 = r6
                r6 = r5
                r5 = r4
            L42:
                r6.printStackTrace()
                boolean r0 = r6 instanceof com.mrousavy.camera.core.CameraError
                if (r0 == 0) goto L4c
                com.mrousavy.camera.core.CameraError r6 = (com.mrousavy.camera.core.CameraError) r6
                goto L52
            L4c:
                com.mrousavy.camera.core.UnknownCameraError r0 = new com.mrousavy.camera.core.UnknownCameraError
                r0.<init>(r6)
                r6 = r0
            L52:
                java.lang.String r0 = r6.getDomain()
                java.lang.String r1 = r6.getId()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r0)
                java.lang.String r0 = "/"
                r2.append(r0)
                r2.append(r1)
                java.lang.String r0 = r2.toString()
                java.lang.String r1 = r6.getMessage()
                java.lang.Throwable r6 = r6.getCause()
                r5.reject(r0, r1, r6)
            L79:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.react.CameraViewModule.C09031.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @ReactMethod
    public final void pauseRecording(int viewTag, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new C09031(promise, this, viewTag, null), 3, null);
    }

    /* renamed from: com.mrousavy.camera.react.CameraViewModule$resumeRecording$1, reason: invalid class name and case insensitive filesystem */
    static final class C09041 extends SuspendLambda implements Function2 {
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $viewTag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09041(int i, Promise promise, Continuation continuation) {
            super(2, continuation);
            this.$viewTag = i;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return CameraViewModule.this.new C09041(this.$viewTag, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws ViewNotFoundError {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CameraViewModule cameraViewModule = CameraViewModule.this;
                int i2 = this.$viewTag;
                this.label = 1;
                obj = cameraViewModule.findCameraView(i2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            CameraView cameraView = (CameraView) obj;
            Promise promise = this.$promise;
            try {
                CameraView_RecordVideoKt.resumeRecording(cameraView);
                promise.resolve(null);
            } catch (Throwable th) {
                th.printStackTrace();
                CameraError unknownCameraError = th instanceof CameraError ? th : new UnknownCameraError(th);
                promise.reject(unknownCameraError.getDomain() + "/" + unknownCameraError.getId(), unknownCameraError.getMessage(), unknownCameraError.getCause());
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void resumeRecording(int viewTag, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new C09041(viewTag, promise, null), 3, null);
    }

    /* renamed from: com.mrousavy.camera.react.CameraViewModule$stopRecording$1, reason: invalid class name and case insensitive filesystem */
    static final class C09061 extends SuspendLambda implements Function2 {
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $viewTag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09061(int i, Promise promise, Continuation continuation) {
            super(2, continuation);
            this.$viewTag = i;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return CameraViewModule.this.new C09061(this.$viewTag, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09061) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws ViewNotFoundError {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CameraViewModule cameraViewModule = CameraViewModule.this;
                int i2 = this.$viewTag;
                this.label = 1;
                obj = cameraViewModule.findCameraView(i2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            CameraView cameraView = (CameraView) obj;
            Promise promise = this.$promise;
            try {
                CameraView_RecordVideoKt.stopRecording(cameraView);
                promise.resolve(null);
            } catch (Throwable th) {
                th.printStackTrace();
                CameraError unknownCameraError = th instanceof CameraError ? th : new UnknownCameraError(th);
                promise.reject(unknownCameraError.getDomain() + "/" + unknownCameraError.getId(), unknownCameraError.getMessage(), unknownCameraError.getCause());
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void stopRecording(int viewTag, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new C09061(viewTag, promise, null), 3, null);
    }

    /* renamed from: com.mrousavy.camera.react.CameraViewModule$cancelRecording$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $viewTag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, Promise promise, Continuation continuation) {
            super(2, continuation);
            this.$viewTag = i;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return CameraViewModule.this.new AnonymousClass1(this.$viewTag, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws ViewNotFoundError {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CameraViewModule cameraViewModule = CameraViewModule.this;
                int i2 = this.$viewTag;
                this.label = 1;
                obj = cameraViewModule.findCameraView(i2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            CameraView cameraView = (CameraView) obj;
            Promise promise = this.$promise;
            try {
                CameraView_RecordVideoKt.cancelRecording(cameraView);
                promise.resolve(null);
            } catch (Throwable th) {
                th.printStackTrace();
                CameraError unknownCameraError = th instanceof CameraError ? th : new UnknownCameraError(th);
                promise.reject(unknownCameraError.getDomain() + "/" + unknownCameraError.getId(), unknownCameraError.getMessage(), unknownCameraError.getCause());
            }
            return Unit.INSTANCE;
        }
    }

    @ReactMethod
    public final void cancelRecording(int viewTag, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new AnonymousClass1(viewTag, promise, null), 3, null);
    }

    /* renamed from: com.mrousavy.camera.react.CameraViewModule$focus$1, reason: invalid class name and case insensitive filesystem */
    static final class C09021 extends SuspendLambda implements Function2 {
        final /* synthetic */ ReadableMap $point;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $viewTag;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09021(int i, Promise promise, ReadableMap readableMap, Continuation continuation) {
            super(2, continuation);
            this.$viewTag = i;
            this.$promise = promise;
            this.$point = readableMap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return CameraViewModule.this.new C09021(this.$viewTag, this.$promise, this.$point, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(1:(1:(7:6|34|7|22|23|32|33)(2:11|12))(1:13))(2:14|(1:16))|17|36|18|(1:20)(5:21|22|23|32|33)|(1:(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
        
            r5 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004c, code lost:
        
            r4 = r1;
         */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0057  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) throws com.mrousavy.camera.core.ViewNotFoundError {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L24
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                java.lang.Object r4 = r4.L$0
                com.facebook.react.bridge.Promise r4 = (com.facebook.react.bridge.Promise) r4
                kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L16
                goto L46
            L16:
                r5 = move-exception
                goto L4d
            L18:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L20:
                kotlin.ResultKt.throwOnFailure(r5)
                goto L34
            L24:
                kotlin.ResultKt.throwOnFailure(r5)
                com.mrousavy.camera.react.CameraViewModule r5 = com.mrousavy.camera.react.CameraViewModule.this
                int r1 = r4.$viewTag
                r4.label = r3
                java.lang.Object r5 = com.mrousavy.camera.react.CameraViewModule.access$findCameraView(r5, r1, r4)
                if (r5 != r0) goto L34
                return r0
            L34:
                com.mrousavy.camera.react.CameraView r5 = (com.mrousavy.camera.react.CameraView) r5
                com.facebook.react.bridge.Promise r1 = r4.$promise
                com.facebook.react.bridge.ReadableMap r3 = r4.$point
                r4.L$0 = r1     // Catch: java.lang.Throwable -> L4b
                r4.label = r2     // Catch: java.lang.Throwable -> L4b
                java.lang.Object r4 = com.mrousavy.camera.react.CameraView_FocusKt.focus(r5, r3, r4)     // Catch: java.lang.Throwable -> L4b
                if (r4 != r0) goto L45
                return r0
            L45:
                r4 = r1
            L46:
                r5 = 0
                r4.resolve(r5)     // Catch: java.lang.Throwable -> L16
                goto L84
            L4b:
                r5 = move-exception
                r4 = r1
            L4d:
                r5.printStackTrace()
                boolean r0 = r5 instanceof com.mrousavy.camera.core.CameraError
                if (r0 == 0) goto L57
                com.mrousavy.camera.core.CameraError r5 = (com.mrousavy.camera.core.CameraError) r5
                goto L5d
            L57:
                com.mrousavy.camera.core.UnknownCameraError r0 = new com.mrousavy.camera.core.UnknownCameraError
                r0.<init>(r5)
                r5 = r0
            L5d:
                java.lang.String r0 = r5.getDomain()
                java.lang.String r1 = r5.getId()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r0)
                java.lang.String r0 = "/"
                r2.append(r0)
                r2.append(r1)
                java.lang.String r0 = r2.toString()
                java.lang.String r1 = r5.getMessage()
                java.lang.Throwable r5 = r5.getCause()
                r4.reject(r0, r1, r5)
            L84:
                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.react.CameraViewModule.C09021.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @ReactMethod
    public final void focus(int viewTag, @NotNull ReadableMap point, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(point, "point");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new C09021(viewTag, promise, point, null), 3, null);
    }

    private final boolean canRequestPermission(String permission) {
        ComponentCallbacks2 currentActivity = getCurrentActivity();
        PermissionAwareActivity permissionAwareActivity = currentActivity instanceof PermissionAwareActivity ? (PermissionAwareActivity) currentActivity : null;
        if (permissionAwareActivity != null) {
            return permissionAwareActivity.shouldShowRequestPermissionRationale(permission);
        }
        return false;
    }

    private final PermissionStatus getPermission(String permission) {
        PermissionStatus permissionStatusFromPermissionStatus = PermissionStatus.INSTANCE.fromPermissionStatus(ContextCompat.checkSelfPermission(getReactApplicationContext(), permission));
        return (permissionStatusFromPermissionStatus == PermissionStatus.DENIED && canRequestPermission(permission)) ? PermissionStatus.NOT_DETERMINED : permissionStatusFromPermissionStatus;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    @NotNull
    public final String getCameraPermissionStatus() {
        return getPermission("android.permission.CAMERA").getUnionValue();
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    @NotNull
    public final String getMicrophonePermissionStatus() {
        return getPermission("android.permission.RECORD_AUDIO").getUnionValue();
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    @NotNull
    public final String getLocationPermissionStatus() {
        PermissionStatus permission = getPermission("android.permission.ACCESS_FINE_LOCATION");
        if (permission == PermissionStatus.GRANTED) {
            return permission.getUnionValue();
        }
        return getPermission("android.permission.ACCESS_COARSE_LOCATION").getUnionValue();
    }

    private final void requestPermission(String permission, final Promise promise) {
        ComponentCallbacks2 currentActivity = getReactApplicationContext().getCurrentActivity();
        if (currentActivity instanceof PermissionAwareActivity) {
            final int i = sharedRequestCode;
            sharedRequestCode = i + 1;
            ((PermissionAwareActivity) currentActivity).requestPermissions(new String[]{permission}, i, new PermissionListener() { // from class: com.mrousavy.camera.react.CameraViewModule$$ExternalSyntheticLambda0
                @Override // com.facebook.react.modules.core.PermissionListener
                public final boolean onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                    return CameraViewModule.requestPermission$lambda$1(i, promise, i2, strArr, iArr);
                }
            });
            return;
        }
        promise.reject("NO_ACTIVITY", "No PermissionAwareActivity was found! Make sure the app has launched before calling this function.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean requestPermission$lambda$1(int i, Promise promise, int i2, String[] strArr, int[] grantResults) {
        Intrinsics.checkNotNullParameter(strArr, "<unused var>");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (i2 != i) {
            return false;
        }
        promise.resolve(PermissionStatus.INSTANCE.fromPermissionStatus(!(grantResults.length == 0) ? grantResults[0] : -1).getUnionValue());
        return true;
    }

    @ReactMethod
    public final void requestCameraPermission(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        requestPermission("android.permission.CAMERA", promise);
    }

    @ReactMethod
    public final void requestMicrophonePermission(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        requestPermission("android.permission.RECORD_AUDIO", promise);
    }

    @ReactMethod
    public final void requestLocationPermission(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        requestPermission("android.permission.ACCESS_FINE_LOCATION", promise);
    }
}
