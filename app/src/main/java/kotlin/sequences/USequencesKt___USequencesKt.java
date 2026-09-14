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

/* JADX INFO: loaded from: classes6.dex */
abstract class USequencesKt___USequencesKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUInt")
    public static final int sumOfUInt(@NotNull Sequence<UInt> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<UInt> it = sequence.iterator();
        int iM5312constructorimpl = 0;
        while (it.hasNext()) {
            iM5312constructorimpl = UInt.m5312constructorimpl(iM5312constructorimpl + it.next().getData());
        }
        return iM5312constructorimpl;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfULong")
    public static final long sumOfULong(@NotNull Sequence<ULong> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<ULong> it = sequence.iterator();
        long jM5337constructorimpl = 0;
        while (it.hasNext()) {
            jM5337constructorimpl = ULong.m5337constructorimpl(jM5337constructorimpl + it.next().getData());
        }
        return jM5337constructorimpl;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(@NotNull Sequence<UByte> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<UByte> it = sequence.iterator();
        int iM5312constructorimpl = 0;
        while (it.hasNext()) {
            iM5312constructorimpl = UInt.m5312constructorimpl(iM5312constructorimpl + UInt.m5312constructorimpl(it.next().getData() & 255));
        }
        return iM5312constructorimpl;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUShort")
    public static final int sumOfUShort(@NotNull Sequence<UShort> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<UShort> it = sequence.iterator();
        int iM5312constructorimpl = 0;
        while (it.hasNext()) {
            iM5312constructorimpl = UInt.m5312constructorimpl(iM5312constructorimpl + UInt.m5312constructorimpl(it.next().getData() & UShort.MAX_VALUE));
        }
        return iM5312constructorimpl;
    }
}
