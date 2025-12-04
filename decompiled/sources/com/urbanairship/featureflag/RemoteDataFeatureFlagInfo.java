package com.urbanairship.featureflag;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.remotedata.RemoteDataInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/featureflag/RemoteDataFeatureFlagInfo;", "", "flagInfoList", "", "Lcom/urbanairship/featureflag/FeatureFlagInfo;", "remoteDataInfo", "Lcom/urbanairship/remotedata/RemoteDataInfo;", "(Ljava/util/List;Lcom/urbanairship/remotedata/RemoteDataInfo;)V", "getFlagInfoList", "()Ljava/util/List;", "getRemoteDataInfo", "()Lcom/urbanairship/remotedata/RemoteDataInfo;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RemoteDataFeatureFlagInfo {
    private final List flagInfoList;
    private final RemoteDataInfo remoteDataInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RemoteDataFeatureFlagInfo copy$default(RemoteDataFeatureFlagInfo remoteDataFeatureFlagInfo, List list, RemoteDataInfo remoteDataInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            list = remoteDataFeatureFlagInfo.flagInfoList;
        }
        if ((i & 2) != 0) {
            remoteDataInfo = remoteDataFeatureFlagInfo.remoteDataInfo;
        }
        return remoteDataFeatureFlagInfo.copy(list, remoteDataInfo);
    }

    @NotNull
    public final List<FeatureFlagInfo> component1() {
        return this.flagInfoList;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final RemoteDataInfo getRemoteDataInfo() {
        return this.remoteDataInfo;
    }

    @NotNull
    public final RemoteDataFeatureFlagInfo copy(@NotNull List<FeatureFlagInfo> flagInfoList, @Nullable RemoteDataInfo remoteDataInfo) {
        Intrinsics.checkNotNullParameter(flagInfoList, "flagInfoList");
        return new RemoteDataFeatureFlagInfo(flagInfoList, remoteDataInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoteDataFeatureFlagInfo)) {
            return false;
        }
        RemoteDataFeatureFlagInfo remoteDataFeatureFlagInfo = (RemoteDataFeatureFlagInfo) other;
        return Intrinsics.areEqual(this.flagInfoList, remoteDataFeatureFlagInfo.flagInfoList) && Intrinsics.areEqual(this.remoteDataInfo, remoteDataFeatureFlagInfo.remoteDataInfo);
    }

    public int hashCode() {
        int iHashCode = this.flagInfoList.hashCode() * 31;
        RemoteDataInfo remoteDataInfo = this.remoteDataInfo;
        return iHashCode + (remoteDataInfo == null ? 0 : remoteDataInfo.hashCode());
    }

    @NotNull
    public String toString() {
        return "RemoteDataFeatureFlagInfo(flagInfoList=" + this.flagInfoList + ", remoteDataInfo=" + this.remoteDataInfo + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public RemoteDataFeatureFlagInfo(@NotNull List<FeatureFlagInfo> flagInfoList, @Nullable RemoteDataInfo remoteDataInfo) {
        Intrinsics.checkNotNullParameter(flagInfoList, "flagInfoList");
        this.flagInfoList = flagInfoList;
        this.remoteDataInfo = remoteDataInfo;
    }

    @NotNull
    public final List<FeatureFlagInfo> getFlagInfoList() {
        return this.flagInfoList;
    }

    @Nullable
    public final RemoteDataInfo getRemoteDataInfo() {
        return this.remoteDataInfo;
    }
}
