package com.mrousavy.camera.core;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import androidx.camera.core.Camera;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.media3.common.MimeTypes;
import com.facebook.react.bridge.UiThreadUtil;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.messaging.Constants;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.mrousavy.camera.core.OrientationManager;
import com.mrousavy.camera.core.types.Orientation;
import com.mrousavy.camera.core.types.ShutterType;
import com.mrousavy.camera.frameprocessors.Frame;
import com.rumax.reactnative.pdfviewer.PDFView;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.reactnative.ReactMessageView;
import java.io.Closeable;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u0086\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0086\u0001\u0087\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010r\u001a\u00020sH\u0016J1\u0010x\u001a\u00020s2!\u0010y\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b{\u0012\b\b|\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020s0zH\u0087@¢\u0006\u0002\u0010}J\r\u0010~\u001a\u00020sH\u0000¢\u0006\u0002\b\u007fJ\u000f\u0010\u0080\u0001\u001a\u00020sH\u0000¢\u0006\u0003\b\u0081\u0001J\u0011\u0010\u0082\u0001\u001a\u00020s2\u0006\u0010n\u001a\u00020oH\u0016J\u0012\u0010\u0083\u0001\u001a\u00020s2\u0007\u0010\u0084\u0001\u001a\u00020oH\u0016J\t\u0010\u0085\u0001\u001a\u00020sH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000103X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00105\"\u0004\b:\u00107R \u0010;\u001a\b\u0012\u0004\u0012\u00020=0<X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020CX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0014\u0010F\u001a\u00020GX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u001c\u0010J\u001a\u0004\u0018\u00010-X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0014\u0010O\u001a\u00020PX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020TX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0014\u0010Y\u001a\u00020ZX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u001c\u0010]\u001a\u0004\u0018\u00010^X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001a\u0010c\u001a\u00020TX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010V\"\u0004\be\u0010XR\u0014\u0010f\u001a\u00020gX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0014\u0010j\u001a\u00020kX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0011\u0010n\u001a\u00020o8F¢\u0006\u0006\u001a\u0004\bp\u0010qR\u0014\u0010t\u001a\u00020u8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bv\u0010w¨\u0006\u0088\u0001"}, d2 = {"Lcom/mrousavy/camera/core/CameraSession;", "Ljava/io/Closeable;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/mrousavy/camera/core/OrientationManager$Callback;", "context", "Landroid/content/Context;", "callback", "Lcom/mrousavy/camera/core/CameraSession$Callback;", "<init>", "(Landroid/content/Context;Lcom/mrousavy/camera/core/CameraSession$Callback;)V", "getContext$react_native_vision_camera_release", "()Landroid/content/Context;", "getCallback$react_native_vision_camera_release", "()Lcom/mrousavy/camera/core/CameraSession$Callback;", "configuration", "Lcom/mrousavy/camera/core/CameraConfiguration;", "getConfiguration$react_native_vision_camera_release", "()Lcom/mrousavy/camera/core/CameraConfiguration;", "setConfiguration$react_native_vision_camera_release", "(Lcom/mrousavy/camera/core/CameraConfiguration;)V", "cameraProvider", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "getCameraProvider$react_native_vision_camera_release", "()Lcom/google/common/util/concurrent/ListenableFuture;", "camera", "Landroidx/camera/core/Camera;", "getCamera$react_native_vision_camera_release", "()Landroidx/camera/core/Camera;", "setCamera$react_native_vision_camera_release", "(Landroidx/camera/core/Camera;)V", "previewOutput", "Landroidx/camera/core/Preview;", "getPreviewOutput$react_native_vision_camera_release", "()Landroidx/camera/core/Preview;", "setPreviewOutput$react_native_vision_camera_release", "(Landroidx/camera/core/Preview;)V", "photoOutput", "Landroidx/camera/core/ImageCapture;", "getPhotoOutput$react_native_vision_camera_release", "()Landroidx/camera/core/ImageCapture;", "setPhotoOutput$react_native_vision_camera_release", "(Landroidx/camera/core/ImageCapture;)V", "videoOutput", "Landroidx/camera/video/VideoCapture;", "Landroidx/camera/video/Recorder;", "getVideoOutput$react_native_vision_camera_release", "()Landroidx/camera/video/VideoCapture;", "setVideoOutput$react_native_vision_camera_release", "(Landroidx/camera/video/VideoCapture;)V", "frameProcessorOutput", "Landroidx/camera/core/ImageAnalysis;", "getFrameProcessorOutput$react_native_vision_camera_release", "()Landroidx/camera/core/ImageAnalysis;", "setFrameProcessorOutput$react_native_vision_camera_release", "(Landroidx/camera/core/ImageAnalysis;)V", "codeScannerOutput", "getCodeScannerOutput$react_native_vision_camera_release", "setCodeScannerOutput$react_native_vision_camera_release", "currentUseCases", "", "Landroidx/camera/core/UseCase;", "getCurrentUseCases$react_native_vision_camera_release", "()Ljava/util/List;", "setCurrentUseCases$react_native_vision_camera_release", "(Ljava/util/List;)V", "metadataProvider", "Lcom/mrousavy/camera/core/MetadataProvider;", "getMetadataProvider$react_native_vision_camera_release", "()Lcom/mrousavy/camera/core/MetadataProvider;", "orientationManager", "Lcom/mrousavy/camera/core/OrientationManager;", "getOrientationManager$react_native_vision_camera_release", "()Lcom/mrousavy/camera/core/OrientationManager;", "recorderOutput", "getRecorderOutput$react_native_vision_camera_release", "()Landroidx/camera/video/Recorder;", "setRecorderOutput$react_native_vision_camera_release", "(Landroidx/camera/video/Recorder;)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "getMutex$react_native_vision_camera_release", "()Lkotlinx/coroutines/sync/Mutex;", "isDestroyed", "", "isDestroyed$react_native_vision_camera_release", "()Z", "setDestroyed$react_native_vision_camera_release", "(Z)V", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycleRegistry$react_native_vision_camera_release", "()Landroidx/lifecycle/LifecycleRegistry;", "recording", "Landroidx/camera/video/Recording;", "getRecording$react_native_vision_camera_release", "()Landroidx/camera/video/Recording;", "setRecording$react_native_vision_camera_release", "(Landroidx/camera/video/Recording;)V", "isRecordingCanceled", "isRecordingCanceled$react_native_vision_camera_release", "setRecordingCanceled$react_native_vision_camera_release", "audioManager", "Landroid/media/AudioManager;", "getAudioManager$react_native_vision_camera_release", "()Landroid/media/AudioManager;", "mainExecutor", "Ljava/util/concurrent/Executor;", "getMainExecutor$react_native_vision_camera_release", "()Ljava/util/concurrent/Executor;", "outputOrientation", "Lcom/mrousavy/camera/core/types/Orientation;", "getOutputOrientation", "()Lcom/mrousavy/camera/core/types/Orientation;", ReactMessageView.EVENT_CLOSE, "", TCEventPropertiesNames.TCL_LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "configure", "lambda", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkCameraPermission", "checkCameraPermission$react_native_vision_camera_release", "checkMicrophonePermission", "checkMicrophonePermission$react_native_vision_camera_release", "onOutputOrientationChanged", "onPreviewOrientationChanged", "previewOrientation", "configureOrientation", "Companion", "Callback", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCameraSession.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CameraSession.kt\ncom/mrousavy/camera/core/CameraSession\n+ 2 runOnUiThread.kt\ncom/mrousavy/camera/core/utils/RunOnUiThreadKt\n+ 3 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,226:1\n24#2,9:227\n116#3,11:236\n*S KotlinDebug\n*F\n+ 1 CameraSession.kt\ncom/mrousavy/camera/core/CameraSession\n*L\n88#1:227,9\n115#1:236,11\n*E\n"})
/* loaded from: classes4.dex */
public final class CameraSession implements Closeable, LifecycleOwner, OrientationManager.Callback {

    @NotNull
    public static final String TAG = "CameraSession";
    private final AudioManager audioManager;
    private final Callback callback;
    private Camera camera;
    private final ListenableFuture cameraProvider;
    private ImageAnalysis codeScannerOutput;
    private CameraConfiguration configuration;
    private final Context context;
    private List currentUseCases;
    private ImageAnalysis frameProcessorOutput;
    private boolean isDestroyed;
    private boolean isRecordingCanceled;
    private final LifecycleRegistry lifecycleRegistry;
    private final Executor mainExecutor;
    private final MetadataProvider metadataProvider;
    private final Mutex mutex;
    private final OrientationManager orientationManager;
    private ImageCapture photoOutput;
    private Preview previewOutput;
    private Recorder recorderOutput;
    private Recording recording;
    private VideoCapture videoOutput;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0011H&J\u001e\u0010\u0014\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0019H&¨\u0006\u001a"}, d2 = {"Lcom/mrousavy/camera/core/CameraSession$Callback;", "", PDFView.EVENT_ON_ERROR, "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "", "onFrame", TypedValues.AttributesType.S_FRAME, "Lcom/mrousavy/camera/frameprocessors/Frame;", "onInitialized", "onStarted", "onStopped", "onShutter", "type", "Lcom/mrousavy/camera/core/types/ShutterType;", "onOutputOrientationChanged", "outputOrientation", "Lcom/mrousavy/camera/core/types/Orientation;", "onPreviewOrientationChanged", "previewOrientation", "onCodeScanned", "codes", "", "Lcom/google/mlkit/vision/barcode/common/Barcode;", "scannerFrame", "Lcom/mrousavy/camera/core/CodeScannerFrame;", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Callback {
        void onCodeScanned(@NotNull List<? extends Barcode> codes, @NotNull CodeScannerFrame scannerFrame);

        void onError(@NotNull Throwable error);

        void onFrame(@NotNull Frame frame);

        void onInitialized();

        void onOutputOrientationChanged(@NotNull Orientation outputOrientation);

        void onPreviewOrientationChanged(@NotNull Orientation previewOrientation);

        void onShutter(@NotNull ShutterType type);

        void onStarted();

        void onStopped();
    }

    /* renamed from: com.mrousavy.camera.core.CameraSession$configure$1, reason: invalid class name and case insensitive filesystem */
    static final class C09001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C09001(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CameraSession.this.configure(null, this);
        }
    }

    public CameraSession(@NotNull Context context, @NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.context = context;
        this.callback = callback;
        this.cameraProvider = ProcessCameraProvider.INSTANCE.getInstance(context);
        this.currentUseCases = CollectionsKt.emptyList();
        this.metadataProvider = new MetadataProvider(context);
        this.orientationManager = new OrientationManager(context, this);
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        this.lifecycleRegistry = lifecycleRegistry;
        Object systemService = context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.audioManager = (AudioManager) systemService;
        Executor mainExecutor = ContextCompat.getMainExecutor(context);
        Intrinsics.checkNotNullExpressionValue(mainExecutor, "getMainExecutor(...)");
        this.mainExecutor = mainExecutor;
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.mrousavy.camera.core.CameraSession.1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                Log.i(CameraSession.TAG, "Camera Lifecycle changed to " + event.getTargetState() + "!");
            }
        });
    }

    @NotNull
    /* renamed from: getCallback$react_native_vision_camera_release, reason: from getter */
    public final Callback getCallback() {
        return this.callback;
    }

    @NotNull
    /* renamed from: getContext$react_native_vision_camera_release, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    /* renamed from: getConfiguration$react_native_vision_camera_release, reason: from getter */
    public final CameraConfiguration getConfiguration() {
        return this.configuration;
    }

    public final void setConfiguration$react_native_vision_camera_release(@Nullable CameraConfiguration cameraConfiguration) {
        this.configuration = cameraConfiguration;
    }

    @NotNull
    public final ListenableFuture<ProcessCameraProvider> getCameraProvider$react_native_vision_camera_release() {
        return this.cameraProvider;
    }

    @Nullable
    /* renamed from: getCamera$react_native_vision_camera_release, reason: from getter */
    public final Camera getCamera() {
        return this.camera;
    }

    public final void setCamera$react_native_vision_camera_release(@Nullable Camera camera) {
        this.camera = camera;
    }

    @Nullable
    /* renamed from: getPreviewOutput$react_native_vision_camera_release, reason: from getter */
    public final Preview getPreviewOutput() {
        return this.previewOutput;
    }

    public final void setPreviewOutput$react_native_vision_camera_release(@Nullable Preview preview) {
        this.previewOutput = preview;
    }

    @Nullable
    /* renamed from: getPhotoOutput$react_native_vision_camera_release, reason: from getter */
    public final ImageCapture getPhotoOutput() {
        return this.photoOutput;
    }

    public final void setPhotoOutput$react_native_vision_camera_release(@Nullable ImageCapture imageCapture) {
        this.photoOutput = imageCapture;
    }

    @Nullable
    public final VideoCapture<Recorder> getVideoOutput$react_native_vision_camera_release() {
        return this.videoOutput;
    }

    public final void setVideoOutput$react_native_vision_camera_release(@Nullable VideoCapture<Recorder> videoCapture) {
        this.videoOutput = videoCapture;
    }

    @Nullable
    /* renamed from: getFrameProcessorOutput$react_native_vision_camera_release, reason: from getter */
    public final ImageAnalysis getFrameProcessorOutput() {
        return this.frameProcessorOutput;
    }

    public final void setFrameProcessorOutput$react_native_vision_camera_release(@Nullable ImageAnalysis imageAnalysis) {
        this.frameProcessorOutput = imageAnalysis;
    }

    @Nullable
    /* renamed from: getCodeScannerOutput$react_native_vision_camera_release, reason: from getter */
    public final ImageAnalysis getCodeScannerOutput() {
        return this.codeScannerOutput;
    }

    public final void setCodeScannerOutput$react_native_vision_camera_release(@Nullable ImageAnalysis imageAnalysis) {
        this.codeScannerOutput = imageAnalysis;
    }

    @NotNull
    public final List<UseCase> getCurrentUseCases$react_native_vision_camera_release() {
        return this.currentUseCases;
    }

    public final void setCurrentUseCases$react_native_vision_camera_release(@NotNull List<? extends UseCase> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.currentUseCases = list;
    }

    @NotNull
    /* renamed from: getMetadataProvider$react_native_vision_camera_release, reason: from getter */
    public final MetadataProvider getMetadataProvider() {
        return this.metadataProvider;
    }

    @NotNull
    /* renamed from: getOrientationManager$react_native_vision_camera_release, reason: from getter */
    public final OrientationManager getOrientationManager() {
        return this.orientationManager;
    }

    @Nullable
    /* renamed from: getRecorderOutput$react_native_vision_camera_release, reason: from getter */
    public final Recorder getRecorderOutput() {
        return this.recorderOutput;
    }

    public final void setRecorderOutput$react_native_vision_camera_release(@Nullable Recorder recorder) {
        this.recorderOutput = recorder;
    }

    @NotNull
    /* renamed from: getMutex$react_native_vision_camera_release, reason: from getter */
    public final Mutex getMutex() {
        return this.mutex;
    }

    /* renamed from: isDestroyed$react_native_vision_camera_release, reason: from getter */
    public final boolean getIsDestroyed() {
        return this.isDestroyed;
    }

    public final void setDestroyed$react_native_vision_camera_release(boolean z) {
        this.isDestroyed = z;
    }

    @NotNull
    /* renamed from: getLifecycleRegistry$react_native_vision_camera_release, reason: from getter */
    public final LifecycleRegistry getLifecycleRegistry() {
        return this.lifecycleRegistry;
    }

    @Nullable
    /* renamed from: getRecording$react_native_vision_camera_release, reason: from getter */
    public final Recording getRecording() {
        return this.recording;
    }

    public final void setRecording$react_native_vision_camera_release(@Nullable Recording recording) {
        this.recording = recording;
    }

    /* renamed from: isRecordingCanceled$react_native_vision_camera_release, reason: from getter */
    public final boolean getIsRecordingCanceled() {
        return this.isRecordingCanceled;
    }

    public final void setRecordingCanceled$react_native_vision_camera_release(boolean z) {
        this.isRecordingCanceled = z;
    }

    @NotNull
    /* renamed from: getAudioManager$react_native_vision_camera_release, reason: from getter */
    public final AudioManager getAudioManager() {
        return this.audioManager;
    }

    @NotNull
    /* renamed from: getMainExecutor$react_native_vision_camera_release, reason: from getter */
    public final Executor getMainExecutor() {
        return this.mainExecutor;
    }

    @NotNull
    public final Orientation getOutputOrientation() {
        return this.orientationManager.getOutputOrientation();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Log.i(TAG, "Closing CameraSession...");
        this.isDestroyed = true;
        this.orientationManager.stopOrientationUpdates();
        if (!UiThreadUtil.isOnUiThread()) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.mrousavy.camera.core.CameraSession$close$$inlined$runOnUiThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    this.this$0.getLifecycleRegistry().setCurrentState(Lifecycle.State.DESTROYED);
                }
            });
        } else {
            getLifecycleRegistry().setCurrentState(Lifecycle.State.DESTROYED);
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c5 A[Catch: all -> 0x00cc, TryCatch #4 {all -> 0x00cc, blocks: (B:77:0x019a, B:37:0x00ac, B:38:0x00b4, B:39:0x00b7, B:41:0x00c5, B:44:0x00cf, B:46:0x00d3, B:47:0x00da, B:82:0x01a5), top: B:99:0x00ac, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cf A[Catch: all -> 0x00cc, TryCatch #4 {all -> 0x00cc, blocks: (B:77:0x019a, B:37:0x00ac, B:38:0x00b4, B:39:0x00b7, B:41:0x00c5, B:44:0x00cf, B:46:0x00d3, B:47:0x00da, B:82:0x01a5), top: B:99:0x00ac, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0127 A[Catch: all -> 0x0043, TryCatch #2 {all -> 0x0043, blocks: (B:14:0x003e, B:61:0x0121, B:63:0x0127, B:64:0x012a, B:66:0x0130, B:67:0x0133, B:69:0x0139, B:70:0x0142, B:72:0x0148, B:73:0x0151), top: B:95:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0130 A[Catch: all -> 0x0043, TryCatch #2 {all -> 0x0043, blocks: (B:14:0x003e, B:61:0x0121, B:63:0x0127, B:64:0x012a, B:66:0x0130, B:67:0x0133, B:69:0x0139, B:70:0x0142, B:72:0x0148, B:73:0x0151), top: B:95:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0139 A[Catch: all -> 0x0043, TryCatch #2 {all -> 0x0043, blocks: (B:14:0x003e, B:61:0x0121, B:63:0x0127, B:64:0x012a, B:66:0x0130, B:67:0x0133, B:69:0x0139, B:70:0x0142, B:72:0x0148, B:73:0x0151), top: B:95:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0148 A[Catch: all -> 0x0043, TryCatch #2 {all -> 0x0043, blocks: (B:14:0x003e, B:61:0x0121, B:63:0x0127, B:64:0x012a, B:66:0x0130, B:67:0x0133, B:69:0x0139, B:70:0x0142, B:72:0x0148, B:73:0x0151), top: B:95:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.annotation.MainThread
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object configure(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.mrousavy.camera.core.CameraConfiguration, kotlin.Unit> r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession.configure(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void checkCameraPermission$react_native_vision_camera_release() {
        if (ContextCompat.checkSelfPermission(this.context, "android.permission.CAMERA") != 0) {
            throw new CameraPermissionError();
        }
    }

    public final void checkMicrophonePermission$react_native_vision_camera_release() throws MicrophonePermissionError {
        if (ContextCompat.checkSelfPermission(this.context, "android.permission.RECORD_AUDIO") != 0) {
            throw new MicrophonePermissionError();
        }
    }

    @Override // com.mrousavy.camera.core.OrientationManager.Callback
    public void onOutputOrientationChanged(@NotNull Orientation outputOrientation) {
        Intrinsics.checkNotNullParameter(outputOrientation, "outputOrientation");
        Log.i(TAG, "Output orientation changed! " + outputOrientation);
        configureOrientation();
        this.callback.onOutputOrientationChanged(outputOrientation);
    }

    @Override // com.mrousavy.camera.core.OrientationManager.Callback
    public void onPreviewOrientationChanged(@NotNull Orientation previewOrientation) {
        Intrinsics.checkNotNullParameter(previewOrientation, "previewOrientation");
        Log.i(TAG, "Preview orientation changed! " + previewOrientation);
        configureOrientation();
        this.callback.onPreviewOrientationChanged(previewOrientation);
    }

    private final void configureOrientation() {
        int surfaceRotation = this.orientationManager.getPreviewOrientation().toSurfaceRotation();
        Preview preview = this.previewOutput;
        if (preview != null) {
            preview.setTargetRotation(surfaceRotation);
        }
        ImageAnalysis imageAnalysis = this.codeScannerOutput;
        if (imageAnalysis != null) {
            imageAnalysis.setTargetRotation(surfaceRotation);
        }
        int surfaceRotation2 = this.orientationManager.getOutputOrientation().toSurfaceRotation();
        ImageCapture imageCapture = this.photoOutput;
        if (imageCapture != null) {
            imageCapture.setTargetRotation(surfaceRotation2);
        }
        VideoCapture videoCapture = this.videoOutput;
        if (videoCapture != null) {
            videoCapture.setTargetRotation(surfaceRotation2);
        }
    }
}
