package com.urbanairship.automation.remotedata;

import com.urbanairship.automation.InAppAutomationRemoteDataStatus;
import com.urbanairship.remotedata.RemoteData;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"toInAppDataSource", "Lcom/urbanairship/automation/InAppAutomationRemoteDataStatus;", "Lcom/urbanairship/remotedata/RemoteData$Status;", "urbanairship-automation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AutomationRemoteDataAccessKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RemoteData.Status.values().length];
            try {
                iArr[RemoteData.Status.UP_TO_DATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RemoteData.Status.STALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RemoteData.Status.OUT_OF_DATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InAppAutomationRemoteDataStatus toInAppDataSource(RemoteData.Status status) {
        int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        if (i == 1) {
            return InAppAutomationRemoteDataStatus.UP_TO_DATE;
        }
        if (i == 2) {
            return InAppAutomationRemoteDataStatus.STALE;
        }
        if (i == 3) {
            return InAppAutomationRemoteDataStatus.OUT_OF_DATE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
