package com.urbanairship.liveupdate;

import android.app.Notification;
import androidx.exifinterface.media.ExifInterface;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.facebook.react.animated.InterpolationAnimatedNode;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u0005*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0004\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "Cancel", "Companion", "NotificationExtender", "Ok", "Lcom/urbanairship/liveupdate/LiveUpdateResult$Cancel;", "Lcom/urbanairship/liveupdate/LiveUpdateResult$Ok;", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class LiveUpdateResult<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateResult$NotificationExtender;", "", InterpolationAnimatedNode.EXTRAPOLATE_TYPE_EXTEND, "", TransferService.INTENT_KEY_NOTIFICATION, "Landroid/app/Notification;", "notificationId", "", "notificationTag", "", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface NotificationExtender {
        void extend(@NotNull Notification notification, int notificationId, @NotNull String notificationTag);
    }

    public /* synthetic */ LiveUpdateResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final <T> Cancel<T> cancel() {
        return INSTANCE.cancel();
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final <T> Ok<T> ok() {
        return INSTANCE.ok();
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final <T> Ok<T> ok(@Nullable T t) {
        return INSTANCE.ok(t);
    }

    private LiveUpdateResult() {
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\b\u0000\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u0004J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u0006R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateResult$Ok;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/liveupdate/LiveUpdateResult;", "value", "(Ljava/lang/Object;)V", "extender", "Lcom/urbanairship/liveupdate/LiveUpdateResult$NotificationExtender;", "getExtender$urbanairship_live_update_release", "()Lcom/urbanairship/liveupdate/LiveUpdateResult$NotificationExtender;", "setExtender$urbanairship_live_update_release", "(Lcom/urbanairship/liveupdate/LiveUpdateResult$NotificationExtender;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", InterpolationAnimatedNode.EXTRAPOLATE_TYPE_EXTEND, "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Ok<T> extends LiveUpdateResult<T> {
        private NotificationExtender extender;
        private final Object value;

        /* JADX WARN: Illegal instructions before constructor call */
        public Ok() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            this(defaultConstructorMarker, 1, defaultConstructorMarker);
        }

        public /* synthetic */ Ok(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : obj);
        }

        @Nullable
        public final T getValue() {
            return (T) this.value;
        }

        public Ok(@Nullable T t) {
            super(null);
            this.value = t;
        }

        @Nullable
        /* renamed from: getExtender$urbanairship_live_update_release, reason: from getter */
        public final NotificationExtender getExtender() {
            return this.extender;
        }

        public final void setExtender$urbanairship_live_update_release(@Nullable NotificationExtender notificationExtender) {
            this.extender = notificationExtender;
        }

        @NotNull
        public final Ok<T> extend(@NotNull NotificationExtender extender) {
            Intrinsics.checkNotNullParameter(extender, "extender");
            this.extender = extender;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007\b\u0000¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateResult$Cancel;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/liveupdate/LiveUpdateResult;", "()V", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Cancel<T> extends LiveUpdateResult<T> {
        public Cancel() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u0005H\u0007J%\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007\"\u0004\b\u0001\u0010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u0001H\u0005H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateResult$Companion;", "", "()V", "cancel", "Lcom/urbanairship/liveupdate/LiveUpdateResult$Cancel;", ExifInterface.GPS_DIRECTION_TRUE, "ok", "Lcom/urbanairship/liveupdate/LiveUpdateResult$Ok;", "value", "(Ljava/lang/Object;)Lcom/urbanairship/liveupdate/LiveUpdateResult$Ok;", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final <T> Ok<T> ok() {
            return ok$default(this, null, 1, null);
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Ok ok$default(Companion companion, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = null;
            }
            return companion.ok(obj);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final <T> Ok<T> ok(@Nullable T value) {
            return new Ok<>(value);
        }

        @JvmStatic
        @NotNull
        public final <T> Cancel<T> cancel() {
            return new Cancel<>();
        }
    }
}
