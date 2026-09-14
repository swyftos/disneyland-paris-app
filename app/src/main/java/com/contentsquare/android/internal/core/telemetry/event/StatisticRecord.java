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

/* JADX INFO: loaded from: classes2.dex */
@Serializable
public final class StatisticRecord {

    @NotNull
    public static final C2420a Companion = new C2420a();

    /* JADX INFO: renamed from: a */
    public final double f1273a;

    /* JADX INFO: renamed from: b */
    public final float f1274b;

    /* JADX INFO: renamed from: c */
    public final float f1275c;

    /* JADX INFO: renamed from: d */
    public final int f1276d;

    /* JADX INFO: renamed from: e */
    public final double f1277e;

    /* JADX INFO: renamed from: f */
    public final float f1278f;

    /* JADX INFO: renamed from: g */
    public final float f1279g;

    /* JADX INFO: renamed from: com.contentsquare.android.internal.core.telemetry.event.StatisticRecord$a */
    @SourceDebugExtension({"SMAP\nStatisticRecord.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StatisticRecord.kt\ncom/contentsquare/android/internal/core/telemetry/event/StatisticRecord$Companion\n+ 2 Statistics.kt\ncom/contentsquare/android/core/utils/StatisticsKt\n*L\n1#1,95:1\n44#2,11:96\n15#2,2:107\n63#2,8:109\n17#2,17:117\n63#2,8:134\n15#2,2:142\n63#2,8:144\n17#2,17:152\n63#2,8:169\n44#2,11:177\n15#2,2:188\n63#2,8:190\n17#2,17:198\n63#2,8:215\n15#2,2:223\n63#2,8:225\n17#2,17:233\n63#2,8:250\n*S KotlinDebug\n*F\n+ 1 StatisticRecord.kt\ncom/contentsquare/android/internal/core/telemetry/event/StatisticRecord$Companion\n*L\n42#1:96,11\n44#1:107,2\n44#1:109,8\n44#1:117,17\n44#1:134,8\n47#1:142,2\n47#1:144,8\n47#1:152,17\n47#1:169,8\n57#1:177,11\n59#1:188,2\n59#1:190,8\n59#1:198,17\n59#1:215,8\n62#1:223,2\n62#1:225,8\n62#1:233,17\n62#1:250,8\n*E\n"})
    public static final class C2420a {
        @NotNull
        /* JADX INFO: renamed from: a */
        public static StatisticRecord m841a(@NotNull StatisticRecord statisticRecord, @Nullable StatisticRecord statisticRecord2) {
            Intrinsics.checkNotNullParameter(statisticRecord, "<this>");
            if (statisticRecord2 == null || Intrinsics.areEqual(statisticRecord2, statisticRecord)) {
                return statisticRecord;
            }
            double d = 2;
            return new StatisticRecord((statisticRecord.f1273a + statisticRecord2.f1273a) / d, Math.min(statisticRecord.f1274b, statisticRecord2.f1274b), Math.min(statisticRecord.f1275c, statisticRecord2.f1275c), statisticRecord.f1276d + statisticRecord2.f1276d, (statisticRecord.f1277e + statisticRecord2.f1277e) / d, Math.max(statisticRecord.f1278f, statisticRecord2.f1278f), Math.max(statisticRecord.f1279g, statisticRecord2.f1279g));
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
        return Double.compare(this.f1273a, statisticRecord.f1273a) == 0 && Float.compare(this.f1274b, statisticRecord.f1274b) == 0 && Float.compare(this.f1275c, statisticRecord.f1275c) == 0 && this.f1276d == statisticRecord.f1276d && Double.compare(this.f1277e, statisticRecord.f1277e) == 0 && Float.compare(this.f1278f, statisticRecord.f1278f) == 0 && Float.compare(this.f1279g, statisticRecord.f1279g) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f1279g) + ((Float.hashCode(this.f1278f) + ((Double.hashCode(this.f1277e) + ((Integer.hashCode(this.f1276d) + ((Float.hashCode(this.f1275c) + ((Float.hashCode(this.f1274b) + (Double.hashCode(this.f1273a) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    @NotNull
    public final String toString() {
        return "StatisticRecord(median=" + this.f1273a + ", min=" + this.f1274b + ", p10=" + this.f1275c + ", count=" + this.f1276d + ", avg=" + this.f1277e + ", p90=" + this.f1278f + ", max=" + this.f1279g + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public StatisticRecord(double d, float f, float f2, int i, double d2, float f3, float f4) {
        this.f1273a = d;
        this.f1274b = f;
        this.f1275c = f2;
        this.f1276d = i;
        this.f1277e = d2;
        this.f1278f = f3;
        this.f1279g = f4;
    }

    public /* synthetic */ StatisticRecord(int i) {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0, AudioStats.AUDIO_AMPLITUDE_NONE, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public StatisticRecord(int i, double d, float f, float f2, int i2, double d2, float f3, float f4) {
        if ((i & 1) == 0) {
            this.f1273a = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.f1273a = d;
        }
        if ((i & 2) == 0) {
            this.f1274b = BitmapDescriptorFactory.HUE_RED;
        } else {
            this.f1274b = f;
        }
        if ((i & 4) == 0) {
            this.f1275c = BitmapDescriptorFactory.HUE_RED;
        } else {
            this.f1275c = f2;
        }
        if ((i & 8) == 0) {
            this.f1276d = 0;
        } else {
            this.f1276d = i2;
        }
        if ((i & 16) == 0) {
            this.f1277e = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.f1277e = d2;
        }
        if ((i & 32) == 0) {
            this.f1278f = BitmapDescriptorFactory.HUE_RED;
        } else {
            this.f1278f = f3;
        }
        if ((i & 64) == 0) {
            this.f1279g = BitmapDescriptorFactory.HUE_RED;
        } else {
            this.f1279g = f4;
        }
    }
}
