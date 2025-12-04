package com.mrousavy.camera.core;

import android.media.AudioManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005\"\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\t¨\u0006\n"}, d2 = {"takePhoto", "Lcom/mrousavy/camera/core/Photo;", "Lcom/mrousavy/camera/core/CameraSession;", "options", "Lcom/mrousavy/camera/core/types/TakePhotoOptions;", "(Lcom/mrousavy/camera/core/CameraSession;Lcom/mrousavy/camera/core/types/TakePhotoOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSilent", "", "Landroid/media/AudioManager;", "(Landroid/media/AudioManager;)Z", "react-native-vision-camera_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCameraSession+Photo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CameraSession+Photo.kt\ncom/mrousavy/camera/core/CameraSession_PhotoKt\n+ 2 ImageCapture+takePicture.kt\ncom/mrousavy/camera/core/extensions/ImageCapture_takePictureKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,46:1\n30#2:47\n32#2,20:57\n76#2:77\n351#3,9:48\n360#3,2:78\n*S KotlinDebug\n*F\n+ 1 CameraSession+Photo.kt\ncom/mrousavy/camera/core/CameraSession_PhotoKt\n*L\n27#1:47\n27#1:57,20\n27#1:77\n27#1:48,9\n27#1:78,2\n*E\n"})
/* loaded from: classes4.dex */
public final class CameraSession_PhotoKt {

    /* renamed from: com.mrousavy.camera.core.CameraSession_PhotoKt$takePhoto$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
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
            return CameraSession_PhotoKt.takePhoto(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v2 */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object takePhoto(@org.jetbrains.annotations.NotNull com.mrousavy.camera.core.CameraSession r18, @org.jetbrains.annotations.NotNull com.mrousavy.camera.core.types.TakePhotoOptions r19, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.mrousavy.camera.core.Photo> r20) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession_PhotoKt.takePhoto(com.mrousavy.camera.core.CameraSession, com.mrousavy.camera.core.types.TakePhotoOptions, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final boolean isSilent(AudioManager audioManager) {
        return audioManager.getRingerMode() != 2;
    }
}
