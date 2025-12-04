package com.urbanairship.liveupdate.notification;

import android.app.AlarmManager;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.urbanairship.UAirship;
import com.urbanairship.util.Clock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/liveupdate/notification/NotificationTimeoutCompat;", "", "Landroid/content/Context;", "context", "Lcom/urbanairship/util/Clock;", "clock", "<init>", "(Landroid/content/Context;Lcom/urbanairship/util/Clock;)V", "Landroidx/core/app/NotificationCompat$Builder;", "builder", "", "timeoutAt", "", "name", "setTimeoutAt$urbanairship_live_update_release", "(Landroidx/core/app/NotificationCompat$Builder;JLjava/lang/String;)Landroidx/core/app/NotificationCompat$Builder;", "setTimeoutAt", "Landroid/content/Context;", "Lcom/urbanairship/util/Clock;", "Landroid/app/AlarmManager;", "alarmManager$delegate", "Lkotlin/Lazy;", "getAlarmManager", "()Landroid/app/AlarmManager;", "alarmManager", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationTimeoutCompat {

    /* renamed from: alarmManager$delegate, reason: from kotlin metadata */
    private final Lazy alarmManager;
    private final Clock clock;
    private final Context context;

    public NotificationTimeoutCompat() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public NotificationTimeoutCompat(@NotNull Context context, @NotNull Clock clock) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.context = context;
        this.clock = clock;
        this.alarmManager = LazyKt.lazy(new Function0() { // from class: com.urbanairship.liveupdate.notification.NotificationTimeoutCompat$alarmManager$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final AlarmManager invoke() {
                Object systemService = this.this$0.context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
                return (AlarmManager) systemService;
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ NotificationTimeoutCompat(Context context, Clock DEFAULT_CLOCK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            context = UAirship.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(context, "getApplicationContext(...)");
        }
        if ((i & 2) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(context, DEFAULT_CLOCK);
    }

    @NotNull
    public final NotificationCompat.Builder setTimeoutAt$urbanairship_live_update_release(@NotNull NotificationCompat.Builder builder, long timeoutAt, @NotNull String name) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(name, "name");
        builder.setTimeoutAfter(timeoutAt - this.clock.currentTimeMillis());
        return builder;
    }
}
