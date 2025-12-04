package com.contentsquare.android.internal.core.telemetry.event;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
/* loaded from: classes2.dex */
public final class StatisticRecord {

    @NotNull
    public static final a Companion = new a();
    public final double a;
    public final float b;
    public final float c;
    public final int d;
    public final double e;
    public final float f;
    public final float g;

    @SourceDebugExtension({"SMAP\nStatisticRecord.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StatisticRecord.kt\ncom/contentsquare/android/internal/core/telemetry/event/StatisticRecord$Companion\n+ 2 Statistics.kt\ncom/contentsquare/android/core/utils/StatisticsKt\n*L\n1#1,95:1\n44#2,11:96\n15#2,2:107\n63#2,8:109\n17#2,17:117\n63#2,8:134\n15#2,2:142\n63#2,8:144\n17#2,17:152\n63#2,8:169\n44#2,11:177\n15#2,2:188\n63#2,8:190\n17#2,17:198\n63#2,8:215\n15#2,2:223\n63#2,8:225\n17#2,17:233\n63#2,8:250\n*S KotlinDebug\n*F\n+ 1 StatisticRecord.kt\ncom/contentsquare/android/internal/core/telemetry/event/StatisticRecord$Companion\n*L\n42#1:96,11\n44#1:107,2\n44#1:109,8\n44#1:117,17\n44#1:134,8\n47#1:142,2\n47#1:144,8\n47#1:152,17\n47#1:169,8\n57#1:177,11\n59#1:188,2\n59#1:190,8\n59#1:198,17\n59#1:215,8\n62#1:223,2\n62#1:225,8\n62#1:233,17\n62#1:250,8\n*E\n"})
    public static final class a {
        @NotNull
        public static StatisticRecord a(@NotNull StatisticRecord statisticRecord, @Nullable StatisticRecord statisticRecord2) {
            Intrinsics.checkNotNullParameter(statisticRecord, "<this>");
            if (statisticRecord2 == null || Intrinsics.areEqual(statisticRecord2, statisticRecord)) {
                return statisticRecord;
            }
            double d = 2;
            return new StatisticRecord((statisticRecord.a + statisticRecord2.a) / d, Math.min(statisticRecord.b, statisticRecord2.b), Math.min(statisticRecord.c, statisticRecord2.c), statisticRecord.d + statisticRecord2.d, (statisticRecord.e + statisticRecord2.e) / d, Math.max(statisticRecord.f, statisticRecord2.f), Math.max(statisticRecord.g, statisticRecord2.g));
        }

        @NotNull
        public final KSerializer<StatisticRecord> serializer() {
            return StatisticRecord$$serializer.INSTANCE;
        }
    }

    public StatisticRecord() {
        this(0);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StatisticRecord)) {
            return false;
        }
        StatisticRecord statisticRecord = (StatisticRecord) obj;
        return Double.compare(this.a, statisticRecord.a) == 0 && Float.compare(this.b, statisticRecord.b) == 0 && Float.compare(this.c, statisticRecord.c) == 0 && this.d == statisticRecord.d && Double.compare(this.e, statisticRecord.e) == 0 && Float.compare(this.f, statisticRecord.f) == 0 && Float.compare(this.g, statisticRecord.g) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.g) + ((Float.hashCode(this.f) + ((Double.hashCode(this.e) + ((Integer.hashCode(this.d) + ((Float.hashCode(this.c) + ((Float.hashCode(this.b) + (Double.hashCode(this.a) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    @NotNull
    public final String toString() {
        return "StatisticRecord(median=" + this.a + ", min=" + this.b + ", p10=" + this.c + ", count=" + this.d + ", avg=" + this.e + ", p90=" + this.f + ", max=" + this.g + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public StatisticRecord(double d, float f, float f2, int i, double d2, float f3, float f4) {
        this.a = d;
        this.b = f;
        this.c = f2;
        this.d = i;
        this.e = d2;
        this.f = f3;
        this.g = f4;
    }

    public /* synthetic */ StatisticRecord(int i) {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0, AudioStats.AUDIO_AMPLITUDE_NONE, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public StatisticRecord(int i, double d, float f, float f2, int i2, double d2, float f3, float f4) {
        if ((i & 1) == 0) {
            this.a = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.a = d;
        }
        if ((i & 2) == 0) {
            this.b = BitmapDescriptorFactory.HUE_RED;
        } else {
            this.b = f;
        }
        if ((i & 4) == 0) {
            this.c = BitmapDescriptorFactory.HUE_RED;
        } else {
            this.c = f2;
        }
        if ((i & 8) == 0) {
            this.d = 0;
        } else {
            this.d = i2;
        }
        if ((i & 16) == 0) {
            this.e = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.e = d2;
        }
        if ((i & 32) == 0) {
            this.f = BitmapDescriptorFactory.HUE_RED;
        } else {
            this.f = f3;
        }
        if ((i & 64) == 0) {
            this.g = BitmapDescriptorFactory.HUE_RED;
        } else {
            this.g = f4;
        }
    }
}
