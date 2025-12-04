package com.urbanairship.iam.coordinator;

import com.urbanairship.PreferenceDataStore;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.iam.InAppMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/iam/coordinator/DisplayCoordinatorManager;", "", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "immediateCoordinator", "Lcom/urbanairship/iam/coordinator/ImmediateDisplayCoordinator;", "defaultCoordinator", "Lcom/urbanairship/iam/coordinator/DefaultDisplayCoordinator;", "(Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/iam/coordinator/ImmediateDisplayCoordinator;Lcom/urbanairship/iam/coordinator/DefaultDisplayCoordinator;)V", "value", "", "displayInterval", "getDisplayInterval", "()J", "setDisplayInterval", "(J)V", "displayCoordinator", "Lcom/urbanairship/iam/coordinator/DisplayCoordinator;", "message", "Lcom/urbanairship/iam/InAppMessage;", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DisplayCoordinatorManager {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    public static final String DISPLAY_INTERVAL_KEY = "UAInAppMessageManagerDisplayInterval";
    private final PreferenceDataStore dataStore;
    private final DefaultDisplayCoordinator defaultCoordinator;
    private final ImmediateDisplayCoordinator immediateCoordinator;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InAppMessage.DisplayBehavior.values().length];
            try {
                iArr[InAppMessage.DisplayBehavior.IMMEDIATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DisplayCoordinatorManager(@NotNull PreferenceDataStore dataStore, @NotNull ActivityMonitor activityMonitor, @NotNull ImmediateDisplayCoordinator immediateCoordinator, @NotNull DefaultDisplayCoordinator defaultCoordinator) {
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
        Intrinsics.checkNotNullParameter(immediateCoordinator, "immediateCoordinator");
        Intrinsics.checkNotNullParameter(defaultCoordinator, "defaultCoordinator");
        this.dataStore = dataStore;
        this.immediateCoordinator = immediateCoordinator;
        this.defaultCoordinator = defaultCoordinator;
    }

    public /* synthetic */ DisplayCoordinatorManager(PreferenceDataStore preferenceDataStore, ActivityMonitor activityMonitor, ImmediateDisplayCoordinator immediateDisplayCoordinator, DefaultDisplayCoordinator defaultDisplayCoordinator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(preferenceDataStore, activityMonitor, (i & 4) != 0 ? new ImmediateDisplayCoordinator(activityMonitor) : immediateDisplayCoordinator, (i & 8) != 0 ? Companion.defaultCoordinator(preferenceDataStore, activityMonitor) : defaultDisplayCoordinator);
    }

    public final long getDisplayInterval() {
        return this.dataStore.getLong(DISPLAY_INTERVAL_KEY, 0L);
    }

    public final void setDisplayInterval(long j) {
        this.dataStore.put(DISPLAY_INTERVAL_KEY, j);
        DefaultDisplayCoordinator defaultDisplayCoordinator = this.defaultCoordinator;
        Duration.Companion companion = Duration.INSTANCE;
        defaultDisplayCoordinator.m2893setDisplayIntervalLRDsOJo(DurationKt.toDuration(j, DurationUnit.SECONDS));
    }

    @NotNull
    public final DisplayCoordinator displayCoordinator(@NotNull InAppMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.isEmbedded$urbanairship_automation_release()) {
            return this.immediateCoordinator;
        }
        InAppMessage.DisplayBehavior displayBehavior = message.getDisplayBehavior();
        if ((displayBehavior == null ? -1 : WhenMappings.$EnumSwitchMapping$0[displayBehavior.ordinal()]) == 1) {
            return this.immediateCoordinator;
        }
        return this.defaultCoordinator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DefaultDisplayCoordinator defaultCoordinator(PreferenceDataStore dataStore, ActivityMonitor activityMonitor) {
            Intrinsics.checkNotNullParameter(dataStore, "dataStore");
            Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
            Duration.Companion companion = Duration.INSTANCE;
            return new DefaultDisplayCoordinator(DurationKt.toDuration(dataStore.getLong(DisplayCoordinatorManager.DISPLAY_INTERVAL_KEY, 0L), DurationUnit.SECONDS), activityMonitor, null, null, 12, null);
        }
    }
}
