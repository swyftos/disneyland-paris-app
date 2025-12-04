package com.mrousavy.camera.core.utils;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a$\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u000e\b\u0004\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086H¢\u0006\u0002\u0010\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u00062\u000e\b\u0004\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2 = {"runOnUiThreadAndWait", ExifInterface.GPS_DIRECTION_TRUE, "function", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runOnUiThread", "", "react-native-vision-camera_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nrunOnUiThread.kt\nKotlin\n*S Kotlin\n*F\n+ 1 runOnUiThread.kt\ncom/mrousavy/camera/core/utils/RunOnUiThreadKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,33:1\n351#2,11:34\n*S KotlinDebug\n*F\n+ 1 runOnUiThread.kt\ncom/mrousavy/camera/core/utils/RunOnUiThreadKt\n*L\n14#1:34,11\n*E\n"})
/* loaded from: classes4.dex */
public final class RunOnUiThreadKt {
    @Nullable
    public static final <T> Object runOnUiThreadAndWait(@NotNull final Function0<? extends T> function0, @NotNull Continuation<? super T> continuation) {
        if (UiThreadUtil.isOnUiThread()) {
            return function0.invoke();
        }
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.mrousavy.camera.core.utils.RunOnUiThreadKt$runOnUiThreadAndWait$2$1
            @Override // java.lang.Runnable
            public final void run() {
                if (cancellableContinuationImpl.isCancelled()) {
                    throw new CancellationException();
                }
                cancellableContinuationImpl.resumeWith(Result.m2968constructorimpl(function0.invoke()));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final void runOnUiThread(@NotNull final Function0<Unit> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        if (UiThreadUtil.isOnUiThread()) {
            function.invoke();
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.mrousavy.camera.core.utils.RunOnUiThreadKt.runOnUiThread.1
                @Override // java.lang.Runnable
                public final void run() {
                    function.invoke();
                }
            });
        }
    }
}
