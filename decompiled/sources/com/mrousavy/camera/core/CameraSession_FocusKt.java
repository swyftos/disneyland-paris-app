package com.mrousavy.camera.core;

import androidx.camera.core.MeteringPoint;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"focus", "", "Lcom/mrousavy/camera/core/CameraSession;", "meteringPoint", "Landroidx/camera/core/MeteringPoint;", "(Lcom/mrousavy/camera/core/CameraSession;Landroidx/camera/core/MeteringPoint;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "react-native-vision-camera_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CameraSession_FocusKt {

    /* renamed from: com.mrousavy.camera.core.CameraSession_FocusKt$focus$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CameraSession_FocusKt.focus(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @android.annotation.SuppressLint({"RestrictedApi"})
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object focus(@org.jetbrains.annotations.NotNull com.mrousavy.camera.core.CameraSession r16, @org.jetbrains.annotations.NotNull androidx.camera.core.MeteringPoint r17, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r18) throws java.lang.Throwable {
        /*
            r0 = r18
            boolean r1 = r0 instanceof com.mrousavy.camera.core.CameraSession_FocusKt.AnonymousClass1
            if (r1 == 0) goto L15
            r1 = r0
            com.mrousavy.camera.core.CameraSession_FocusKt$focus$1 r1 = (com.mrousavy.camera.core.CameraSession_FocusKt.AnonymousClass1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.mrousavy.camera.core.CameraSession_FocusKt$focus$1 r1 = new com.mrousavy.camera.core.CameraSession_FocusKt$focus$1
            r1.<init>(r0)
        L1a:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            java.lang.String r5 = "CameraSession"
            if (r3 == 0) goto L36
            if (r3 != r4) goto L2e
            kotlin.ResultKt.throwOnFailure(r0)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            goto La8
        L2e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L36:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.camera.core.Camera r0 = r16.getCamera()
            if (r0 == 0) goto Lca
            androidx.camera.core.FocusMeteringAction$Builder r3 = new androidx.camera.core.FocusMeteringAction$Builder
            r6 = r17
            r3.<init>(r6)
            androidx.camera.core.FocusMeteringAction r3 = r3.build()
            java.lang.String r6 = "build(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            androidx.camera.core.CameraInfo r6 = r0.getCameraInfo()
            boolean r6 = r6.isFocusMeteringSupported(r3)
            if (r6 == 0) goto Lc4
            java.util.List r7 = r3.getMeteringPointsAf()     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            java.lang.String r6 = "getMeteringPointsAf(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            com.mrousavy.camera.core.CameraSession_FocusKt$$ExternalSyntheticLambda0 r13 = new com.mrousavy.camera.core.CameraSession_FocusKt$$ExternalSyntheticLambda0     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            r13.<init>()     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            r14 = 31
            r15 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            java.lang.String r6 = kotlin.collections.CollectionsKt.joinToString$default(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            r7.<init>()     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            java.lang.String r8 = "Focusing to "
            r7.append(r8)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            r7.append(r6)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            java.lang.String r6 = "..."
            r7.append(r6)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            java.lang.String r6 = r7.toString()     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            android.util.Log.i(r5, r6)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            androidx.camera.core.CameraControl r0 = r0.getCameraControl()     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            com.google.common.util.concurrent.ListenableFuture r0 = r0.startFocusAndMetering(r3)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            java.lang.String r3 = "startFocusAndMetering(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            com.mrousavy.camera.core.CameraQueues$Companion r3 = com.mrousavy.camera.core.CameraQueues.INSTANCE     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            java.util.concurrent.ExecutorService r3 = r3.getCameraExecutor()     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            r1.label = r4     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            java.lang.Object r0 = com.mrousavy.camera.core.extensions.ListenableFuture_awaitKt.await(r0, r3, r1)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            if (r0 != r2) goto La8
            return r2
        La8:
            androidx.camera.core.FocusMeteringResult r0 = (androidx.camera.core.FocusMeteringResult) r0     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            boolean r0 = r0.isFocusSuccessful()     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            if (r0 == 0) goto Lb6
            java.lang.String r0 = "Focused successfully!"
            android.util.Log.i(r5, r0)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
            goto Lbb
        Lb6:
            java.lang.String r0 = "Focus failed."
            android.util.Log.i(r5, r0)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lbe
        Lbb:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        Lbe:
            com.mrousavy.camera.core.FocusCanceledError r0 = new com.mrousavy.camera.core.FocusCanceledError
            r0.<init>()
            throw r0
        Lc4:
            com.mrousavy.camera.core.FocusNotSupportedError r0 = new com.mrousavy.camera.core.FocusNotSupportedError
            r0.<init>()
            throw r0
        Lca:
            com.mrousavy.camera.core.CameraNotReadyError r0 = new com.mrousavy.camera.core.CameraNotReadyError
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession_FocusKt.focus(com.mrousavy.camera.core.CameraSession, androidx.camera.core.MeteringPoint, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence focus$lambda$0(MeteringPoint meteringPoint) {
        return "(" + meteringPoint.getX() + ", " + meteringPoint.getY() + ")";
    }
}
