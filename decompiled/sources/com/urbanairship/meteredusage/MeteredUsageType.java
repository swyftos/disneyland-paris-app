package com.urbanairship.meteredusage;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/urbanairship/meteredusage/MeteredUsageType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IN_APP_EXPERIENCE_IMPRESSION", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class MeteredUsageType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MeteredUsageType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final MeteredUsageType IN_APP_EXPERIENCE_IMPRESSION = new MeteredUsageType("IN_APP_EXPERIENCE_IMPRESSION", 0, "iax_impression");
    private final String value;

    private static final /* synthetic */ MeteredUsageType[] $values() {
        return new MeteredUsageType[]{IN_APP_EXPERIENCE_IMPRESSION};
    }

    @NotNull
    public static EnumEntries<MeteredUsageType> getEntries() {
        return $ENTRIES;
    }

    public static MeteredUsageType valueOf(String str) {
        return (MeteredUsageType) Enum.valueOf(MeteredUsageType.class, str);
    }

    public static MeteredUsageType[] values() {
        return (MeteredUsageType[]) $VALUES.clone();
    }

    private MeteredUsageType(String str, int i, String str2) {
        this.value = str2;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    static {
        MeteredUsageType[] meteredUsageTypeArr$values = $values();
        $VALUES = meteredUsageTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(meteredUsageTypeArr$values);
        INSTANCE = new Companion(null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/meteredusage/MeteredUsageType$Companion;", "", "()V", "fromString", "Lcom/urbanairship/meteredusage/MeteredUsageType;", "string", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final MeteredUsageType fromString(@NotNull String string) throws IllegalStateException {
            Intrinsics.checkNotNullParameter(string, "string");
            MeteredUsageType meteredUsageType = MeteredUsageType.IN_APP_EXPERIENCE_IMPRESSION;
            if (Intrinsics.areEqual(string, meteredUsageType.getValue())) {
                return meteredUsageType;
            }
            throw new IllegalStateException("Invalid metered usage type");
        }
    }
}
