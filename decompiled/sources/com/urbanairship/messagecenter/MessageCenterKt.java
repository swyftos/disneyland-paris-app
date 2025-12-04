package com.urbanairship.messagecenter;

import com.urbanairship.job.JobDispatcher;
import com.urbanairship.job.JobInfo;
import com.urbanairship.messagecenter.Inbox;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"scheduleInboxUpdateJob", "", "Lcom/urbanairship/job/JobDispatcher;", "reason", "Lcom/urbanairship/messagecenter/Inbox$UpdateType;", "urbanairship-message-center_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MessageCenterKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Inbox.UpdateType.values().length];
            try {
                iArr[Inbox.UpdateType.BEST_ATTEMPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Inbox.UpdateType.REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void scheduleInboxUpdateJob(@NotNull JobDispatcher jobDispatcher, @NotNull Inbox.UpdateType reason) {
        JobInfo.Builder conflictStrategy;
        Intrinsics.checkNotNullParameter(jobDispatcher, "<this>");
        Intrinsics.checkNotNullParameter(reason, "reason");
        JobInfo.Builder airshipComponent = JobInfo.newBuilder().setAction(MessageCenter.ACTION_UPDATE_INBOX).setAirshipComponent(MessageCenter.class);
        int i = WhenMappings.$EnumSwitchMapping$0[reason.ordinal()];
        if (i == 1) {
            conflictStrategy = airshipComponent.setNetworkAccessRequired(true).setConflictStrategy(2);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            conflictStrategy = airshipComponent.setConflictStrategy(0);
        }
        JobInfo jobInfoBuild = conflictStrategy.build();
        Intrinsics.checkNotNullExpressionValue(jobInfoBuild, "build(...)");
        jobDispatcher.dispatch(jobInfoBuild);
    }
}
