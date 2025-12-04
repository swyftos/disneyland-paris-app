package com.urbanairship.audience;

import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/urbanairship/audience/HashIdentifiers;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsonValue", "()Ljava/lang/String;", "CHANNEL", "CONTACT", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HashIdentifiers {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HashIdentifiers[] $VALUES;
    public static final HashIdentifiers CHANNEL = new HashIdentifiers("CHANNEL", 0, TCVideoEventPropertiesNames.TCV_CHANNEL);
    public static final HashIdentifiers CONTACT = new HashIdentifiers("CONTACT", 1, "contact");

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final String jsonValue;

    private static final /* synthetic */ HashIdentifiers[] $values() {
        return new HashIdentifiers[]{CHANNEL, CONTACT};
    }

    @NotNull
    public static EnumEntries<HashIdentifiers> getEntries() {
        return $ENTRIES;
    }

    public static HashIdentifiers valueOf(String str) {
        return (HashIdentifiers) Enum.valueOf(HashIdentifiers.class, str);
    }

    public static HashIdentifiers[] values() {
        return (HashIdentifiers[]) $VALUES.clone();
    }

    private HashIdentifiers(String str, int i, String str2) {
        this.jsonValue = str2;
    }

    @NotNull
    public final String getJsonValue() {
        return this.jsonValue;
    }

    static {
        HashIdentifiers[] hashIdentifiersArr$values = $values();
        $VALUES = hashIdentifiersArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(hashIdentifiersArr$values);
        INSTANCE = new Companion(null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/audience/HashIdentifiers$Companion;", "", "()V", "from", "Lcom/urbanairship/audience/HashIdentifiers;", "value", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAudienceHash.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudienceHash.kt\ncom/urbanairship/audience/HashIdentifiers$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,119:1\n1282#2,2:120\n*S KotlinDebug\n*F\n+ 1 AudienceHash.kt\ncom/urbanairship/audience/HashIdentifiers$Companion\n*L\n22#1:120,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final HashIdentifiers from(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            for (HashIdentifiers hashIdentifiers : HashIdentifiers.values()) {
                if (Intrinsics.areEqual(hashIdentifiers.getJsonValue(), value)) {
                    return hashIdentifiers;
                }
            }
            return null;
        }
    }
}
