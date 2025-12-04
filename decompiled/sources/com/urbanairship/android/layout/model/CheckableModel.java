package com.urbanairship.android.layout.model;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.ThomasState;
import com.urbanairship.android.layout.info.CheckableInfo;
import com.urbanairship.android.layout.model.BaseModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00060\u0005:\u0001\u0018B\u001d\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/android/layout/model/CheckableModel;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "I", "Lcom/urbanairship/android/layout/info/CheckableInfo;", "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/model/CheckableModel$Listener;", "viewInfo", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "(Lcom/urbanairship/android/layout/info/CheckableInfo;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;)V", "checkableViewId", "", "getCheckableViewId", "()I", "setChecked", "", "isChecked", "", "(Z)Lkotlin/Unit;", "setEnabled", "isEnabled", "Listener", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class CheckableModel<T extends View, I extends CheckableInfo> extends BaseModel<T, I, Listener> {
    private final int checkableViewId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckableModel(@NotNull I viewInfo, @NotNull ModelEnvironment environment, @NotNull ModelProperties properties) {
        super(viewInfo, environment, properties, null, 8, null);
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.checkableViewId = View.generateViewId();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/model/CheckableModel$Listener;", "Lcom/urbanairship/android/layout/model/BaseModel$Listener;", "setChecked", "", "checked", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener extends BaseModel.Listener {
        void setChecked(boolean checked);

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            public static void onStateUpdated(@NotNull Listener listener, @NotNull ThomasState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Listener.super.onStateUpdated(state);
            }
        }
    }

    public final int getCheckableViewId() {
        return this.checkableViewId;
    }

    @Nullable
    public final Unit setChecked(boolean isChecked) {
        Listener listener = getListener();
        if (listener == null) {
            return null;
        }
        listener.setChecked(isChecked);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Unit setEnabled(boolean isEnabled) {
        Listener listener = getListener();
        if (listener == null) {
            return null;
        }
        listener.setEnabled(isEnabled);
        return Unit.INSTANCE;
    }
}
