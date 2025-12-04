package com.mrousavy.camera.react;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/mrousavy/camera/react/CameraView;", "Lcom/facebook/react/bridge/ReadableMap;", "optionsMap", "Lcom/facebook/react/bridge/WritableMap;", "takePhoto", "(Lcom/mrousavy/camera/react/CameraView;Lcom/facebook/react/bridge/ReadableMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "react-native-vision-camera_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CameraView_TakePhotoKt {

    /* renamed from: com.mrousavy.camera.react.CameraView_TakePhotoKt$takePhoto$1, reason: invalid class name */
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
            return CameraView_TakePhotoKt.takePhoto(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @android.annotation.SuppressLint({"UnsafeOptInUsageError"})
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object takePhoto(@org.jetbrains.annotations.NotNull com.mrousavy.camera.react.CameraView r6, @org.jetbrains.annotations.NotNull com.facebook.react.bridge.ReadableMap r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.facebook.react.bridge.WritableMap> r8) {
        /*
            boolean r0 = r8 instanceof com.mrousavy.camera.react.CameraView_TakePhotoKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.mrousavy.camera.react.CameraView_TakePhotoKt$takePhoto$1 r0 = (com.mrousavy.camera.react.CameraView_TakePhotoKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.mrousavy.camera.react.CameraView_TakePhotoKt$takePhoto$1 r0 = new com.mrousavy.camera.react.CameraView_TakePhotoKt$takePhoto$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "CameraView.takePhoto"
            r4 = 1
            if (r2 == 0) goto L33
            if (r2 != r4) goto L2b
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6a
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.HashMap r8 = r7.toHashMap()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "Taking photo... Options: "
            r2.append(r5)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            android.util.Log.i(r3, r8)
            com.mrousavy.camera.core.types.TakePhotoOptions$Companion r8 = com.mrousavy.camera.core.types.TakePhotoOptions.INSTANCE
            android.content.Context r2 = r6.getContext()
            java.lang.String r5 = "getContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.mrousavy.camera.core.types.TakePhotoOptions r7 = r8.fromJS(r2, r7)
            com.mrousavy.camera.core.CameraSession r6 = r6.getCameraSession()
            r0.label = r4
            java.lang.Object r8 = com.mrousavy.camera.core.CameraSession_PhotoKt.takePhoto(r6, r7, r0)
            if (r8 != r1) goto L6a
            return r1
        L6a:
            com.mrousavy.camera.core.Photo r8 = (com.mrousavy.camera.core.Photo) r8
            int r6 = r8.getWidth()
            int r7 = r8.getHeight()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Successfully captured "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = " x "
            r0.append(r6)
            r0.append(r7)
            java.lang.String r6 = " photo!"
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            android.util.Log.i(r3, r6)
            com.facebook.react.bridge.WritableMap r6 = com.facebook.react.bridge.Arguments.createMap()
            java.lang.String r7 = "path"
            java.lang.String r0 = r8.getPath()
            r6.putString(r7, r0)
            java.lang.String r7 = "width"
            int r0 = r8.getWidth()
            r6.putInt(r7, r0)
            java.lang.String r7 = "height"
            int r0 = r8.getHeight()
            r6.putInt(r7, r0)
            com.mrousavy.camera.core.types.Orientation r7 = r8.getOrientation()
            java.lang.String r7 = r7.getUnionValue()
            java.lang.String r0 = "orientation"
            r6.putString(r0, r7)
            java.lang.String r7 = "isRawPhoto"
            r0 = 0
            r6.putBoolean(r7, r0)
            java.lang.String r7 = "isMirrored"
            boolean r8 = r8.isMirrored()
            r6.putBoolean(r7, r8)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.react.CameraView_TakePhotoKt.takePhoto(com.mrousavy.camera.react.CameraView, com.facebook.react.bridge.ReadableMap, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
