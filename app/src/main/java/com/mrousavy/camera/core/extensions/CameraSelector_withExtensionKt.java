package com.mrousavy.camera.core.extensions;

import android.content.Context;
import android.util.Log;
import androidx.camera.core.CameraSelector;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.core.content.ContextCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a<\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, m1836d2 = {"Landroidx/camera/core/CameraSelector;", "Landroid/content/Context;", "context", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "provider", "", "needsImageAnalysis", "", "extension", "", "extensionDebugName", "withExtension", "(Landroidx/camera/core/CameraSelector;Landroid/content/Context;Landroidx/camera/lifecycle/ProcessCameraProvider;ZILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "react-native-vision-camera_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class CameraSelector_withExtensionKt {

    /* JADX INFO: renamed from: com.mrousavy.camera.core.extensions.CameraSelector_withExtensionKt$withExtension$1 */
    static final class C45101 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C45101(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CameraSelector_withExtensionKt.withExtension(null, null, null, false, 0, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public static final Object withExtension(@NotNull CameraSelector cameraSelector, @NotNull Context context, @NotNull ProcessCameraProvider processCameraProvider, boolean z, int i, @NotNull String str, @NotNull Continuation<? super CameraSelector> continuation) {
        C45101 c45101;
        if (continuation instanceof C45101) {
            c45101 = (C45101) continuation;
            int i2 = c45101.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c45101.label = i2 - Integer.MIN_VALUE;
            } else {
                c45101 = new C45101(continuation);
            }
        } else {
            c45101 = new C45101(continuation);
        }
        Object objAwait = c45101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c45101.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objAwait);
            Log.i("CameraSelector", str + " is enabled, looking up vendor " + str + " extension...");
            Executor mainExecutor = ContextCompat.getMainExecutor(context);
            Intrinsics.checkNotNullExpressionValue(mainExecutor, "getMainExecutor(...)");
            ListenableFuture<ExtensionsManager> instanceAsync = ExtensionsManager.getInstanceAsync(context, processCameraProvider);
            Intrinsics.checkNotNullExpressionValue(instanceAsync, "getInstanceAsync(...)");
            c45101.L$0 = cameraSelector;
            c45101.L$1 = str;
            c45101.Z$0 = z;
            c45101.I$0 = i;
            c45101.label = 1;
            objAwait = ListenableFuture_awaitKt.await(instanceAsync, mainExecutor, c45101);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = c45101.I$0;
            z = c45101.Z$0;
            str = (String) c45101.L$1;
            cameraSelector = (CameraSelector) c45101.L$0;
            ResultKt.throwOnFailure(objAwait);
        }
        ExtensionsManager extensionsManager = (ExtensionsManager) objAwait;
        if (!extensionsManager.isExtensionAvailable(cameraSelector, i)) {
            return cameraSelector;
        }
        if (z && !extensionsManager.isImageAnalysisSupported(cameraSelector, i)) {
            Log.i("CameraSelector", "Device supports a " + str + " vendor extension, but we cannot use it since we need ImageAnalysis and this extension does not work with ImageAnalysis use-cases.");
            return cameraSelector;
        }
        Log.i("CameraSelector", "Device supports a " + str + " vendor extension! Enabling...");
        CameraSelector extensionEnabledCameraSelector = extensionsManager.getExtensionEnabledCameraSelector(cameraSelector, i);
        Intrinsics.checkNotNullExpressionValue(extensionEnabledCameraSelector, "getExtensionEnabledCameraSelector(...)");
        return extensionEnabledCameraSelector;
    }
}
