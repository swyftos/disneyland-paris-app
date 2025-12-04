package com.urbanairship.experiment;

import androidx.annotation.RestrictTo;
import java.util.Iterator;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/urbanairship/experiment/ResolutionType;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsonValue", "()Ljava/lang/String;", "DEFERRED", "STATIC", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public final class ResolutionType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ResolutionType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final ResolutionType DEFERRED = new ResolutionType("DEFERRED", 0, "deferred");
    public static final ResolutionType STATIC = new ResolutionType("STATIC", 1, "static");
    private final String jsonValue;

    private static final /* synthetic */ ResolutionType[] $values() {
        return new ResolutionType[]{DEFERRED, STATIC};
    }

    @NotNull
    public static EnumEntries<ResolutionType> getEntries() {
        return $ENTRIES;
    }

    public static ResolutionType valueOf(String str) {
        return (ResolutionType) Enum.valueOf(ResolutionType.class, str);
    }

    public static ResolutionType[] values() {
        return (ResolutionType[]) $VALUES.clone();
    }

    private ResolutionType(String str, int i, String str2) {
        this.jsonValue = str2;
    }

    @NotNull
    public final String getJsonValue() {
        return this.jsonValue;
    }

    static {
        ResolutionType[] resolutionTypeArr$values = $values();
        $VALUES = resolutionTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(resolutionTypeArr$values);
        INSTANCE = new Companion(null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/experiment/ResolutionType$Companion;", "", "()V", "from", "Lcom/urbanairship/experiment/ResolutionType;", "value", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @SourceDebugExtension({"SMAP\nExperiment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Experiment.kt\ncom/urbanairship/experiment/ResolutionType$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,254:1\n288#2,2:255\n*S KotlinDebug\n*F\n+ 1 Experiment.kt\ncom/urbanairship/experiment/ResolutionType$Companion\n*L\n41#1:255,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final ResolutionType from(@NotNull String value) {
            ResolutionType next;
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator<ResolutionType> it = ResolutionType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(next.getJsonValue(), value)) {
                    break;
                }
            }
            return next;
        }
    }
}
