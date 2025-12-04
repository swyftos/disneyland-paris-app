package com.facebook.react.uimanager;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.ReadableArray;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J)\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0003H'¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0017¢\u0006\u0004\b\u0004\u0010\u000bJ)\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H'¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017¢\u0006\u0004\b\r\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagerDelegate;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "", "setProperty", "", "view", "propName", "", "value", "kotlinCompat$setProperty", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/Object;)V", "javaCompat_setProperty", "receiveCommand", "commandName", "args", "Lcom/facebook/react/bridge/ReadableArray;", "kotlinCompat$receiveCommand", "(Landroid/view/View;Ljava/lang/String;Lcom/facebook/react/bridge/ReadableArray;)V", "javaCompat_receiveCommand", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ViewManagerDelegate<T extends View> {
    @JvmName(name = "kotlinCompat$receiveCommand")
    /* synthetic */ void kotlinCompat$receiveCommand(View view, String commandName, ReadableArray args);

    @JvmName(name = "kotlinCompat$setProperty")
    /* synthetic */ void kotlinCompat$setProperty(View view, String propName, Object value);

    @Deprecated(message = "propName is not nullable, please update your method signature")
    @JvmName(name = "setProperty")
    default void setProperty(@NotNull T view, @Nullable String propName, @Nullable Object value) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (propName == null) {
            throw new IllegalStateException("Required value was null.");
        }
        kotlinCompat$setProperty(view, propName, value);
    }

    @Deprecated(message = "commandName is not nullable, please update your method signature")
    @JvmName(name = "receiveCommand")
    default void receiveCommand(@NotNull T view, @Nullable String commandName, @Nullable ReadableArray args) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (commandName == null) {
            throw new IllegalStateException("Required value was null.");
        }
        kotlinCompat$receiveCommand(view, commandName, args);
    }
}
