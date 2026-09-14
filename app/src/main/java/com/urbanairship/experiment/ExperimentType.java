package com.urbanairship.experiment;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\t"}, m1836d2 = {"Lcom/urbanairship/experiment/ExperimentType;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsonValue", "()Ljava/lang/String;", "HOLDOUT_GROUP", "Companion", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public enum ExperimentType {
    HOLDOUT_GROUP("holdout");

    private final String jsonValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static EnumEntries<ExperimentType> getEntries() {
        return $ENTRIES;
    }

    ExperimentType(String str) {
        this.jsonValue = str;
    }

    @NotNull
    public final String getJsonValue() {
        return this.jsonValue;
    }

    @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/experiment/ExperimentType$Companion;", "", "()V", "from", "Lcom/urbanairship/experiment/ExperimentType;", "value", "", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nExperiment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Experiment.kt\ncom/urbanairship/experiment/ExperimentType$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,254:1\n1282#2,2:255\n*S KotlinDebug\n*F\n+ 1 Experiment.kt\ncom/urbanairship/experiment/ExperimentType$Companion\n*L\n26#1:255,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final ExperimentType from(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            for (ExperimentType experimentType : ExperimentType.values()) {
                if (Intrinsics.areEqual(experimentType.getJsonValue(), value)) {
                    return experimentType;
                }
            }
            return null;
        }
    }
}
