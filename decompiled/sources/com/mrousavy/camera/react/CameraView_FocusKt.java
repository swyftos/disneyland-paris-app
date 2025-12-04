package com.mrousavy.camera.react;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"focus", "", "Lcom/mrousavy/camera/react/CameraView;", "pointMap", "Lcom/facebook/react/bridge/ReadableMap;", "(Lcom/mrousavy/camera/react/CameraView;Lcom/facebook/react/bridge/ReadableMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "react-native-vision-camera_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCameraView+Focus.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CameraView+Focus.kt\ncom/mrousavy/camera/react/CameraView_FocusKt\n+ 2 runOnUiThread.kt\ncom/mrousavy/camera/core/utils/RunOnUiThreadKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,20:1\n9#2,6:21\n15#2,6:36\n351#3,9:27\n360#3,2:42\n*S KotlinDebug\n*F\n+ 1 CameraView+Focus.kt\ncom/mrousavy/camera/react/CameraView_FocusKt\n*L\n14#1:21,6\n14#1:36,6\n14#1:27,9\n14#1:42,2\n*E\n"})
/* loaded from: classes4.dex */
public final class CameraView_FocusKt {

    /* renamed from: com.mrousavy.camera.react.CameraView_FocusKt$focus$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        double D$0;
        double D$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CameraView_FocusKt.focus(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.lang.Object] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object focus(@org.jetbrains.annotations.NotNull com.mrousavy.camera.react.CameraView r12, @org.jetbrains.annotations.NotNull com.facebook.react.bridge.ReadableMap r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r14) throws com.mrousavy.camera.core.FocusRequiresPreviewError {
        /*
            boolean r0 = r14 instanceof com.mrousavy.camera.react.CameraView_FocusKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r14
            com.mrousavy.camera.react.CameraView_FocusKt$focus$1 r0 = (com.mrousavy.camera.react.CameraView_FocusKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.mrousavy.camera.react.CameraView_FocusKt$focus$1 r0 = new com.mrousavy.camera.react.CameraView_FocusKt$focus$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r14)
            goto Lbd
        L2d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L35:
            java.lang.Object r12 = r0.L$1
            androidx.camera.view.PreviewView r12 = (androidx.camera.view.PreviewView) r12
            java.lang.Object r12 = r0.L$0
            com.mrousavy.camera.react.CameraView r12 = (com.mrousavy.camera.react.CameraView) r12
            kotlin.ResultKt.throwOnFailure(r14)
            goto La3
        L41:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.String r14 = "x"
            double r8 = r13.getDouble(r14)
            java.lang.String r14 = "y"
            double r10 = r13.getDouble(r14)
            androidx.camera.view.PreviewView r7 = r12.getPreviewView()
            if (r7 == 0) goto Lc0
            boolean r13 = com.facebook.react.bridge.UiThreadUtil.isOnUiThread()
            if (r13 == 0) goto L73
            android.content.res.Resources r13 = android.content.res.Resources.getSystem()
            android.util.DisplayMetrics r13 = r13.getDisplayMetrics()
            float r13 = r13.density
            androidx.camera.core.MeteringPointFactory r14 = r7.getMeteringPointFactory()
            float r2 = (float) r8
            float r2 = r2 * r13
            float r4 = (float) r10
            float r4 = r4 * r13
            androidx.camera.core.MeteringPoint r13 = r14.createPoint(r2, r4)
            goto La4
        L73:
            r0.L$0 = r12
            r0.L$1 = r7
            r0.D$0 = r8
            r0.D$1 = r10
            r0.label = r4
            kotlinx.coroutines.CancellableContinuationImpl r13 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r14 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            r13.<init>(r14, r4)
            r13.initCancellability()
            com.mrousavy.camera.react.CameraView_FocusKt$focus$$inlined$runOnUiThreadAndWait$1 r14 = new com.mrousavy.camera.react.CameraView_FocusKt$focus$$inlined$runOnUiThreadAndWait$1
            r5 = r14
            r6 = r13
            r5.<init>()
            com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r14)
            java.lang.Object r14 = r13.getResult()
            java.lang.Object r13 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r14 != r13) goto La0
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        La0:
            if (r14 != r1) goto La3
            return r1
        La3:
            r13 = r14
        La4:
            java.lang.String r14 = "runOnUiThreadAndWait(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            androidx.camera.core.MeteringPoint r13 = (androidx.camera.core.MeteringPoint) r13
            com.mrousavy.camera.core.CameraSession r12 = r12.getCameraSession()
            r14 = 0
            r0.L$0 = r14
            r0.L$1 = r14
            r0.label = r3
            java.lang.Object r12 = com.mrousavy.camera.core.CameraSession_FocusKt.focus(r12, r13, r0)
            if (r12 != r1) goto Lbd
            return r1
        Lbd:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        Lc0:
            com.mrousavy.camera.core.FocusRequiresPreviewError r12 = new com.mrousavy.camera.core.FocusRequiresPreviewError
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.react.CameraView_FocusKt.focus(com.mrousavy.camera.react.CameraView, com.facebook.react.bridge.ReadableMap, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
