package androidx.camera.lifecycle;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraProvider;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.ConcurrentCamera;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.lifecycle.LifecycleCameraProvider;
import androidx.concurrent.futures.ListenableFutureKt;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J5\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000b\"\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010\rJ\u0018\u0010\u0002\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H&J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH&J%\u0010\u0015\u001a\u00020\u00162\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000b\"\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0016H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Landroidx/camera/lifecycle/LifecycleCameraProvider;", "Landroidx/camera/core/CameraProvider;", "bindToLifecycle", "Landroidx/camera/core/Camera;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "cameraSelector", "Landroidx/camera/core/CameraSelector;", "useCaseGroup", "Landroidx/camera/core/UseCaseGroup;", "useCases", "", "Landroidx/camera/core/UseCase;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/camera/core/CameraSelector;[Landroidx/camera/core/UseCase;)Landroidx/camera/core/Camera;", "Landroidx/camera/core/ConcurrentCamera;", "singleCameraConfigs", "", "Landroidx/camera/core/ConcurrentCamera$SingleCameraConfig;", "isBound", "", "useCase", "unbind", "", "([Landroidx/camera/core/UseCase;)V", "unbindAll", "Companion", "camera-lifecycle_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public interface LifecycleCameraProvider extends CameraProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @JvmStatic
    @JvmOverloads
    @Nullable
    static Object createInstance(@NotNull Context context, @Nullable CameraXConfig cameraXConfig, @NotNull Continuation<? super LifecycleCameraProvider> continuation) {
        return INSTANCE.createInstance(context, cameraXConfig, continuation);
    }

    @JvmStatic
    @JvmOverloads
    @Nullable
    static Object createInstance(@NotNull Context context, @NotNull Continuation<? super LifecycleCameraProvider> continuation) {
        return INSTANCE.createInstance(context, continuation);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    static ListenableFuture<LifecycleCameraProvider> createInstanceAsync(@NotNull Context context) {
        return INSTANCE.createInstanceAsync(context);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    static ListenableFuture<LifecycleCameraProvider> createInstanceAsync(@NotNull Context context, @Nullable CameraXConfig cameraXConfig) {
        return INSTANCE.createInstanceAsync(context, cameraXConfig);
    }

    @NotNull
    Camera bindToLifecycle(@NotNull LifecycleOwner lifecycleOwner, @NotNull CameraSelector cameraSelector, @NotNull UseCaseGroup useCaseGroup);

    @NotNull
    Camera bindToLifecycle(@NotNull LifecycleOwner lifecycleOwner, @NotNull CameraSelector cameraSelector, @NotNull UseCase... useCases);

    @NotNull
    ConcurrentCamera bindToLifecycle(@NotNull List<ConcurrentCamera.SingleCameraConfig> singleCameraConfigs);

    boolean isBound(@NotNull UseCase useCase);

    void unbind(@NotNull UseCase... useCases);

    void unbindAll();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0087@¢\u0006\u0002\u0010\tJ\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\f"}, d2 = {"Landroidx/camera/lifecycle/LifecycleCameraProvider$Companion;", "", "()V", "createInstance", "Landroidx/camera/lifecycle/LifecycleCameraProvider;", "context", "Landroid/content/Context;", "cameraXConfig", "Landroidx/camera/core/CameraXConfig;", "(Landroid/content/Context;Landroidx/camera/core/CameraXConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createInstanceAsync", "Lcom/google/common/util/concurrent/ListenableFuture;", "camera-lifecycle_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @JvmStatic
        @JvmOverloads
        @Nullable
        public final Object createInstance(@NotNull Context context, @NotNull Continuation<? super LifecycleCameraProvider> continuation) {
            return createInstance$default(this, context, null, continuation, 2, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final ListenableFuture<LifecycleCameraProvider> createInstanceAsync(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return createInstanceAsync$default(this, context, null, 2, null);
        }

        private Companion() {
        }

        public static /* synthetic */ Object createInstance$default(Companion companion, Context context, CameraXConfig cameraXConfig, Continuation continuation, int i, Object obj) {
            if ((i & 2) != 0) {
                cameraXConfig = null;
            }
            return companion.createInstance(context, cameraXConfig, continuation);
        }

        @JvmStatic
        @JvmOverloads
        @Nullable
        public final Object createInstance(@NotNull Context context, @Nullable CameraXConfig cameraXConfig, @NotNull Continuation<? super LifecycleCameraProvider> continuation) {
            return ListenableFutureKt.await(createInstanceAsync(context, cameraXConfig), continuation);
        }

        public static /* synthetic */ ListenableFuture createInstanceAsync$default(Companion companion, Context context, CameraXConfig cameraXConfig, int i, Object obj) {
            if ((i & 2) != 0) {
                cameraXConfig = null;
            }
            return companion.createInstanceAsync(context, cameraXConfig);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final ListenableFuture<LifecycleCameraProvider> createInstanceAsync(@NotNull Context context, @Nullable CameraXConfig cameraXConfig) {
            Intrinsics.checkNotNullParameter(context, "context");
            Preconditions.checkNotNull(context);
            final LifecycleCameraProviderImpl lifecycleCameraProviderImpl = new LifecycleCameraProviderImpl();
            ListenableFuture<Void> listenableFutureInitAsync$camera_lifecycle_release = lifecycleCameraProviderImpl.initAsync$camera_lifecycle_release(context, cameraXConfig);
            final Function1 function1 = new Function1() { // from class: androidx.camera.lifecycle.LifecycleCameraProvider$Companion$createInstanceAsync$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final LifecycleCameraProvider invoke(Void r1) {
                    return lifecycleCameraProviderImpl;
                }
            };
            ListenableFuture<LifecycleCameraProvider> listenableFutureTransform = Futures.transform(listenableFutureInitAsync$camera_lifecycle_release, new Function() { // from class: androidx.camera.lifecycle.LifecycleCameraProvider$Companion$$ExternalSyntheticLambda0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return LifecycleCameraProvider.Companion.createInstanceAsync$lambda$0(function1, obj);
                }
            }, CameraXExecutors.directExecutor());
            Intrinsics.checkNotNullExpressionValue(listenableFutureTransform, "lifecycleCameraProvider …tExecutor()\n            )");
            return listenableFutureTransform;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final LifecycleCameraProvider createInstanceAsync$lambda$0(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (LifecycleCameraProvider) tmp0.invoke(obj);
        }
    }
}
