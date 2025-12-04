package com.urbanairship.meteredusage;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
final class UsageTypeConverter {
    public final MeteredUsageType toUsageType(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return MeteredUsageType.INSTANCE.fromString(value);
    }

    public final String fromUsageType(MeteredUsageType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return type.getValue();
    }
}
