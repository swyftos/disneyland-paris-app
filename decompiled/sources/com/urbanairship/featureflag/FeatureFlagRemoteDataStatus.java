package com.urbanairship.featureflag;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagRemoteDataStatus;", "", "(Ljava/lang/String;I)V", "UP_TO_DATE", "STALE", "OUT_OF_DATE", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeatureFlagRemoteDataStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FeatureFlagRemoteDataStatus[] $VALUES;
    public static final FeatureFlagRemoteDataStatus UP_TO_DATE = new FeatureFlagRemoteDataStatus("UP_TO_DATE", 0);
    public static final FeatureFlagRemoteDataStatus STALE = new FeatureFlagRemoteDataStatus("STALE", 1);
    public static final FeatureFlagRemoteDataStatus OUT_OF_DATE = new FeatureFlagRemoteDataStatus("OUT_OF_DATE", 2);

    private static final /* synthetic */ FeatureFlagRemoteDataStatus[] $values() {
        return new FeatureFlagRemoteDataStatus[]{UP_TO_DATE, STALE, OUT_OF_DATE};
    }

    @NotNull
    public static EnumEntries<FeatureFlagRemoteDataStatus> getEntries() {
        return $ENTRIES;
    }

    public static FeatureFlagRemoteDataStatus valueOf(String str) {
        return (FeatureFlagRemoteDataStatus) Enum.valueOf(FeatureFlagRemoteDataStatus.class, str);
    }

    public static FeatureFlagRemoteDataStatus[] values() {
        return (FeatureFlagRemoteDataStatus[]) $VALUES.clone();
    }

    private FeatureFlagRemoteDataStatus(String str, int i) {
    }

    static {
        FeatureFlagRemoteDataStatus[] featureFlagRemoteDataStatusArr$values = $values();
        $VALUES = featureFlagRemoteDataStatusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(featureFlagRemoteDataStatusArr$values);
    }
}
