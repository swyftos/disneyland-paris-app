package com.facebook.react.views.view;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0007J\b\u0010\u000e\u001a\u00020\nH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/react/views/view/CanvasUtil;", "", "<init>", "()V", "reorderBarrierMethod", "Ljava/lang/reflect/Method;", "inorderBarrierMethod", "orderMethodsFetched", "", "enableZ", "", "canvas", "Landroid/graphics/Canvas;", "enable", "fetchOrderMethods", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CanvasUtil {

    @NotNull
    public static final CanvasUtil INSTANCE = new CanvasUtil();

    @Nullable
    private static Method inorderBarrierMethod;
    private static boolean orderMethodsFetched;

    @Nullable
    private static Method reorderBarrierMethod;

    private CanvasUtil() {
    }

    @JvmStatic
    @SuppressLint({"SoonBlockedPrivateApi", "PrivateApi"})
    public static final void enableZ(@NotNull Canvas canvas, boolean enable) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (enable) {
            canvas.enableZ();
        } else {
            canvas.disableZ();
        }
    }

    private final void fetchOrderMethods() throws NoSuchMethodException, SecurityException {
        Method declaredMethod;
        Method method;
        if (orderMethodsFetched) {
            return;
        }
        try {
            reorderBarrierMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
            declaredMethod = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
            inorderBarrierMethod = declaredMethod;
            method = reorderBarrierMethod;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        if (method != null && declaredMethod != null) {
            if (method != null) {
                method.setAccessible(true);
            }
            Method method2 = inorderBarrierMethod;
            if (method2 != null) {
                method2.setAccessible(true);
            }
            orderMethodsFetched = true;
        }
    }
}
