package com.urbanairship.audience;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/urbanairship/audience/HashAlgorithm;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsonValue", "()Ljava/lang/String;", "FARM", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HashAlgorithm {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HashAlgorithm[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final HashAlgorithm FARM = new HashAlgorithm("FARM", 0, "farm_hash");
    private final String jsonValue;

    private static final /* synthetic */ HashAlgorithm[] $values() {
        return new HashAlgorithm[]{FARM};
    }

    @NotNull
    public static EnumEntries<HashAlgorithm> getEntries() {
        return $ENTRIES;
    }

    public static HashAlgorithm valueOf(String str) {
        return (HashAlgorithm) Enum.valueOf(HashAlgorithm.class, str);
    }

    public static HashAlgorithm[] values() {
        return (HashAlgorithm[]) $VALUES.clone();
    }

    private HashAlgorithm(String str, int i, String str2) {
        this.jsonValue = str2;
    }

    @NotNull
    public final String getJsonValue() {
        return this.jsonValue;
    }

    static {
        HashAlgorithm[] hashAlgorithmArr$values = $values();
        $VALUES = hashAlgorithmArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(hashAlgorithmArr$values);
        INSTANCE = new Companion(null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/audience/HashAlgorithm$Companion;", "", "()V", "from", "Lcom/urbanairship/audience/HashAlgorithm;", "value", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAudienceHash.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudienceHash.kt\ncom/urbanairship/audience/HashAlgorithm$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,119:1\n1282#2,2:120\n*S KotlinDebug\n*F\n+ 1 AudienceHash.kt\ncom/urbanairship/audience/HashAlgorithm$Companion\n*L\n32#1:120,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final HashAlgorithm from(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            for (HashAlgorithm hashAlgorithm : HashAlgorithm.values()) {
                if (Intrinsics.areEqual(hashAlgorithm.getJsonValue(), value)) {
                    return hashAlgorithm;
                }
            }
            return null;
        }
    }
}
