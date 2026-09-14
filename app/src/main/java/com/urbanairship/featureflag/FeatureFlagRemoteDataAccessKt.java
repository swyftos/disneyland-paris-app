package com.urbanairship.featureflag;

import com.urbanairship.remotedata.RemoteData;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, m1836d2 = {"toFeatureFlagStatus", "Lcom/urbanairship/featureflag/FeatureFlagRemoteDataStatus;", "Lcom/urbanairship/remotedata/RemoteData$Status;", "urbanairship-feature-flag_release"}, m1837k = 2, m1838mv = {1, 9, 0}, m1840xi = 48)
public final class FeatureFlagRemoteDataAccessKt {

    @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
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
    public static final FeatureFlagRemoteDataStatus toFeatureFlagStatus(RemoteData.Status status) {
        int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        if (i == 1) {
            return FeatureFlagRemoteDataStatus.UP_TO_DATE;
        }
        if (i == 2) {
            return FeatureFlagRemoteDataStatus.STALE;
        }
        if (i == 3) {
            return FeatureFlagRemoteDataStatus.OUT_OF_DATE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
