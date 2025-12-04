package com.mrousavy.camera.core.extensions;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a<\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/camera/core/CameraSelector;", "Landroid/content/Context;", "context", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "provider", "", "needsImageAnalysis", "", "extension", "", "extensionDebugName", "withExtension", "(Landroidx/camera/core/CameraSelector;Landroid/content/Context;Landroidx/camera/lifecycle/ProcessCameraProvider;ZILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "react-native-vision-camera_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CameraSelector_withExtensionKt {

    /* renamed from: com.mrousavy.camera.core.extensions.CameraSelector_withExtensionKt$withExtension$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CameraSelector_withExtensionKt.withExtension(null, null, null, false, 0, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object withExtension(@org.jetbrains.annotations.NotNull androidx.camera.core.CameraSelector r5, @org.jetbrains.annotations.NotNull android.content.Context r6, @org.jetbrains.annotations.NotNull androidx.camera.lifecycle.ProcessCameraProvider r7, boolean r8, int r9, @org.jetbrains.annotations.NotNull java.lang.String r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.camera.core.CameraSelector> r11) {
        /*
            boolean r0 = r11 instanceof com.mrousavy.camera.core.extensions.CameraSelector_withExtensionKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            com.mrousavy.camera.core.extensions.CameraSelector_withExtensionKt$withExtension$1 r0 = (com.mrousavy.camera.core.extensions.CameraSelector_withExtensionKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.mrousavy.camera.core.extensions.CameraSelector_withExtensionKt$withExtension$1 r0 = new com.mrousavy.camera.core.extensions.CameraSelector_withExtensionKt$withExtension$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = "CameraSelector"
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            int r9 = r0.I$0
            boolean r8 = r0.Z$0
            java.lang.Object r5 = r0.L$1
            r10 = r5
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r5 = r0.L$0
            androidx.camera.core.CameraSelector r5 = (androidx.camera.core.CameraSelector) r5
            kotlin.ResultKt.throwOnFailure(r11)
            goto L82
        L38:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L40:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r10)
            java.lang.String r2 = " is enabled, looking up vendor "
            r11.append(r2)
            r11.append(r10)
            java.lang.String r2 = " extension..."
            r11.append(r2)
            java.lang.String r11 = r11.toString()
            android.util.Log.i(r4, r11)
            java.util.concurrent.Executor r11 = androidx.core.content.ContextCompat.getMainExecutor(r6)
            java.lang.String r2 = "getMainExecutor(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r2)
            com.google.common.util.concurrent.ListenableFuture r6 = androidx.camera.extensions.ExtensionsManager.getInstanceAsync(r6, r7)
            java.lang.String r7 = "getInstanceAsync(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r0.L$0 = r5
            r0.L$1 = r10
            r0.Z$0 = r8
            r0.I$0 = r9
            r0.label = r3
            java.lang.Object r11 = com.mrousavy.camera.core.extensions.ListenableFuture_awaitKt.await(r6, r11, r0)
            if (r11 != r1) goto L82
            return r1
        L82:
            androidx.camera.extensions.ExtensionsManager r11 = (androidx.camera.extensions.ExtensionsManager) r11
            boolean r6 = r11.isExtensionAvailable(r5, r9)
            if (r6 == 0) goto Lcc
            java.lang.String r6 = "Device supports a "
            if (r8 == 0) goto Lac
            boolean r7 = r11.isImageAnalysisSupported(r5, r9)
            if (r7 != 0) goto Lac
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            r7.append(r10)
            java.lang.String r6 = " vendor extension, but we cannot use it since we need ImageAnalysis and this extension does not work with ImageAnalysis use-cases."
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            android.util.Log.i(r4, r6)
            return r5
        Lac:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            r7.append(r10)
            java.lang.String r6 = " vendor extension! Enabling..."
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            android.util.Log.i(r4, r6)
            androidx.camera.core.CameraSelector r5 = r11.getExtensionEnabledCameraSelector(r5, r9)
            java.lang.String r6 = "getExtensionEnabledCameraSelector(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
        Lcc:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.extensions.CameraSelector_withExtensionKt.withExtension(androidx.camera.core.CameraSelector, android.content.Context, androidx.camera.lifecycle.ProcessCameraProvider, boolean, int, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
