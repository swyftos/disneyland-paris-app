package kotlin.sequences;

import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.WasExperimental;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
abstract class USequencesKt___USequencesKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUInt")
    public static final int sumOfUInt(@NotNull Sequence<UInt> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<UInt> it = sequence.iterator();
        int iM3003constructorimpl = 0;
        while (it.hasNext()) {
            iM3003constructorimpl = UInt.m3003constructorimpl(iM3003constructorimpl + it.next().getData());
        }
        return iM3003constructorimpl;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfULong")
    public static final long sumOfULong(@NotNull Sequence<ULong> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<ULong> it = sequence.iterator();
        long jM3028constructorimpl = 0;
        while (it.hasNext()) {
            jM3028constructorimpl = ULong.m3028constructorimpl(jM3028constructorimpl + it.next().getData());
        }
        return jM3028constructorimpl;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(@NotNull Sequence<UByte> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<UByte> it = sequence.iterator();
        int iM3003constructorimpl = 0;
        while (it.hasNext()) {
            iM3003constructorimpl = UInt.m3003constructorimpl(iM3003constructorimpl + UInt.m3003constructorimpl(it.next().getData() & 255));
        }
        return iM3003constructorimpl;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUShort")
    public static final int sumOfUShort(@NotNull Sequence<UShort> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<UShort> it = sequence.iterator();
        int iM3003constructorimpl = 0;
        while (it.hasNext()) {
            iM3003constructorimpl = UInt.m3003constructorimpl(iM3003constructorimpl + UInt.m3003constructorimpl(it.next().getData() & UShort.MAX_VALUE));
        }
        return iM3003constructorimpl;
    }
}
