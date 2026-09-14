package kotlin.collections.unsigned;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.WasExperimental;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.UArraySortingKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class UArraysKt___UArraysKt extends UArraysKt___UArraysJvmKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: getIndices--ajY-9A$annotations, reason: not valid java name */
    public static /* synthetic */ void m5492getIndicesajY9A$annotations(int[] iArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: getIndices-GBYM_sE$annotations, reason: not valid java name */
    public static /* synthetic */ void m5494getIndicesGBYM_sE$annotations(byte[] bArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: getIndices-QwZRm1k$annotations, reason: not valid java name */
    public static /* synthetic */ void m5496getIndicesQwZRm1k$annotations(long[] jArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: getIndices-rL5Bavg$annotations, reason: not valid java name */
    public static /* synthetic */ void m5498getIndicesrL5Bavg$annotations(short[] sArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: getLastIndex--ajY-9A$annotations, reason: not valid java name */
    public static /* synthetic */ void m5500getLastIndexajY9A$annotations(int[] iArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: getLastIndex-GBYM_sE$annotations, reason: not valid java name */
    public static /* synthetic */ void m5502getLastIndexGBYM_sE$annotations(byte[] bArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: getLastIndex-QwZRm1k$annotations, reason: not valid java name */
    public static /* synthetic */ void m5504getLastIndexQwZRm1k$annotations(long[] jArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: getLastIndex-rL5Bavg$annotations, reason: not valid java name */
    public static /* synthetic */ void m5506getLastIndexrL5Bavg$annotations(short[] sArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: firstOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m5487firstOrNullajY9A(@NotNull int[] firstOrNull) {
        Intrinsics.checkNotNullParameter(firstOrNull, "$this$firstOrNull");
        if (UIntArray.m5328isEmptyimpl(firstOrNull)) {
            return null;
        }
        return UInt.m5311boximpl(UIntArray.m5325getpVg5ArA(firstOrNull, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: firstOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m5489firstOrNullQwZRm1k(@NotNull long[] firstOrNull) {
        Intrinsics.checkNotNullParameter(firstOrNull, "$this$firstOrNull");
        if (ULongArray.m5353isEmptyimpl(firstOrNull)) {
            return null;
        }
        return ULong.m5336boximpl(ULongArray.m5350getsVKNKU(firstOrNull, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: firstOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m5488firstOrNullGBYM_sE(@NotNull byte[] firstOrNull) {
        Intrinsics.checkNotNullParameter(firstOrNull, "$this$firstOrNull");
        if (UByteArray.m5303isEmptyimpl(firstOrNull)) {
            return null;
        }
        return UByte.m5286boximpl(UByteArray.m5300getw2LRezQ(firstOrNull, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: firstOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m5490firstOrNullrL5Bavg(@NotNull short[] firstOrNull) {
        Intrinsics.checkNotNullParameter(firstOrNull, "$this$firstOrNull");
        if (UShortArray.m5378isEmptyimpl(firstOrNull)) {
            return null;
        }
        return UShort.m5361boximpl(UShortArray.m5375getMh2AYeg(firstOrNull, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: getOrNull-qFRl0hI, reason: not valid java name */
    public static final UInt m5509getOrNullqFRl0hI(@NotNull int[] getOrNull, int i) {
        Intrinsics.checkNotNullParameter(getOrNull, "$this$getOrNull");
        if (i < 0 || i >= UIntArray.m5326getSizeimpl(getOrNull)) {
            return null;
        }
        return UInt.m5311boximpl(UIntArray.m5325getpVg5ArA(getOrNull, i));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: getOrNull-r7IrZao, reason: not valid java name */
    public static final ULong m5510getOrNullr7IrZao(@NotNull long[] getOrNull, int i) {
        Intrinsics.checkNotNullParameter(getOrNull, "$this$getOrNull");
        if (i < 0 || i >= ULongArray.m5351getSizeimpl(getOrNull)) {
            return null;
        }
        return ULong.m5336boximpl(ULongArray.m5350getsVKNKU(getOrNull, i));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: getOrNull-PpDY95g, reason: not valid java name */
    public static final UByte m5507getOrNullPpDY95g(@NotNull byte[] getOrNull, int i) {
        Intrinsics.checkNotNullParameter(getOrNull, "$this$getOrNull");
        if (i < 0 || i >= UByteArray.m5301getSizeimpl(getOrNull)) {
            return null;
        }
        return UByte.m5286boximpl(UByteArray.m5300getw2LRezQ(getOrNull, i));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: getOrNull-nggk6HY, reason: not valid java name */
    public static final UShort m5508getOrNullnggk6HY(@NotNull short[] getOrNull, int i) {
        Intrinsics.checkNotNullParameter(getOrNull, "$this$getOrNull");
        if (i < 0 || i >= UShortArray.m5376getSizeimpl(getOrNull)) {
            return null;
        }
        return UShort.m5361boximpl(UShortArray.m5375getMh2AYeg(getOrNull, i));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: lastOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m5511lastOrNullajY9A(@NotNull int[] lastOrNull) {
        Intrinsics.checkNotNullParameter(lastOrNull, "$this$lastOrNull");
        if (UIntArray.m5328isEmptyimpl(lastOrNull)) {
            return null;
        }
        return UInt.m5311boximpl(UIntArray.m5325getpVg5ArA(lastOrNull, UIntArray.m5326getSizeimpl(lastOrNull) - 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: lastOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m5513lastOrNullQwZRm1k(@NotNull long[] lastOrNull) {
        Intrinsics.checkNotNullParameter(lastOrNull, "$this$lastOrNull");
        if (ULongArray.m5353isEmptyimpl(lastOrNull)) {
            return null;
        }
        return ULong.m5336boximpl(ULongArray.m5350getsVKNKU(lastOrNull, ULongArray.m5351getSizeimpl(lastOrNull) - 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: lastOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m5512lastOrNullGBYM_sE(@NotNull byte[] lastOrNull) {
        Intrinsics.checkNotNullParameter(lastOrNull, "$this$lastOrNull");
        if (UByteArray.m5303isEmptyimpl(lastOrNull)) {
            return null;
        }
        return UByte.m5286boximpl(UByteArray.m5300getw2LRezQ(lastOrNull, UByteArray.m5301getSizeimpl(lastOrNull) - 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: lastOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m5514lastOrNullrL5Bavg(@NotNull short[] lastOrNull) {
        Intrinsics.checkNotNullParameter(lastOrNull, "$this$lastOrNull");
        if (UShortArray.m5378isEmptyimpl(lastOrNull)) {
            return null;
        }
        return UShort.m5361boximpl(UShortArray.m5375getMh2AYeg(lastOrNull, UShortArray.m5376getSizeimpl(lastOrNull) - 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: random-2D5oskM, reason: not valid java name */
    public static final int m5551random2D5oskM(@NotNull int[] random, @NotNull Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        if (UIntArray.m5328isEmptyimpl(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return UIntArray.m5325getpVg5ArA(random, random2.nextInt(UIntArray.m5326getSizeimpl(random)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: random-JzugnMA, reason: not valid java name */
    public static final long m5552randomJzugnMA(@NotNull long[] random, @NotNull Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        if (ULongArray.m5353isEmptyimpl(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return ULongArray.m5350getsVKNKU(random, random2.nextInt(ULongArray.m5351getSizeimpl(random)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: random-oSF2wD8, reason: not valid java name */
    public static final byte m5553randomoSF2wD8(@NotNull byte[] random, @NotNull Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        if (UByteArray.m5303isEmptyimpl(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return UByteArray.m5300getw2LRezQ(random, random2.nextInt(UByteArray.m5301getSizeimpl(random)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: random-s5X_as8, reason: not valid java name */
    public static final short m5554randoms5X_as8(@NotNull short[] random, @NotNull Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        if (UShortArray.m5378isEmptyimpl(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return UShortArray.m5375getMh2AYeg(random, random2.nextInt(UShortArray.m5376getSizeimpl(random)));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: randomOrNull-2D5oskM, reason: not valid java name */
    public static final UInt m5555randomOrNull2D5oskM(@NotNull int[] randomOrNull, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (UIntArray.m5328isEmptyimpl(randomOrNull)) {
            return null;
        }
        return UInt.m5311boximpl(UIntArray.m5325getpVg5ArA(randomOrNull, random.nextInt(UIntArray.m5326getSizeimpl(randomOrNull))));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: randomOrNull-JzugnMA, reason: not valid java name */
    public static final ULong m5556randomOrNullJzugnMA(@NotNull long[] randomOrNull, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (ULongArray.m5353isEmptyimpl(randomOrNull)) {
            return null;
        }
        return ULong.m5336boximpl(ULongArray.m5350getsVKNKU(randomOrNull, random.nextInt(ULongArray.m5351getSizeimpl(randomOrNull))));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: randomOrNull-oSF2wD8, reason: not valid java name */
    public static final UByte m5557randomOrNulloSF2wD8(@NotNull byte[] randomOrNull, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (UByteArray.m5303isEmptyimpl(randomOrNull)) {
            return null;
        }
        return UByte.m5286boximpl(UByteArray.m5300getw2LRezQ(randomOrNull, random.nextInt(UByteArray.m5301getSizeimpl(randomOrNull))));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: randomOrNull-s5X_as8, reason: not valid java name */
    public static final UShort m5558randomOrNulls5X_as8(@NotNull short[] randomOrNull, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (UShortArray.m5378isEmptyimpl(randomOrNull)) {
            return null;
        }
        return UShort.m5361boximpl(UShortArray.m5375getMh2AYeg(randomOrNull, random.nextInt(UShortArray.m5376getSizeimpl(randomOrNull))));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: singleOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m5571singleOrNullajY9A(@NotNull int[] singleOrNull) {
        Intrinsics.checkNotNullParameter(singleOrNull, "$this$singleOrNull");
        if (UIntArray.m5326getSizeimpl(singleOrNull) == 1) {
            return UInt.m5311boximpl(UIntArray.m5325getpVg5ArA(singleOrNull, 0));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: singleOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m5573singleOrNullQwZRm1k(@NotNull long[] singleOrNull) {
        Intrinsics.checkNotNullParameter(singleOrNull, "$this$singleOrNull");
        if (ULongArray.m5351getSizeimpl(singleOrNull) == 1) {
            return ULong.m5336boximpl(ULongArray.m5350getsVKNKU(singleOrNull, 0));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: singleOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m5572singleOrNullGBYM_sE(@NotNull byte[] singleOrNull) {
        Intrinsics.checkNotNullParameter(singleOrNull, "$this$singleOrNull");
        if (UByteArray.m5301getSizeimpl(singleOrNull) == 1) {
            return UByte.m5286boximpl(UByteArray.m5300getw2LRezQ(singleOrNull, 0));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: singleOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m5574singleOrNullrL5Bavg(@NotNull short[] singleOrNull) {
        Intrinsics.checkNotNullParameter(singleOrNull, "$this$singleOrNull");
        if (UShortArray.m5376getSizeimpl(singleOrNull) == 1) {
            return UShort.m5361boximpl(UShortArray.m5375getMh2AYeg(singleOrNull, 0));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: drop-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m5473dropqFRl0hI(@NotNull int[] drop, int i) {
        Intrinsics.checkNotNullParameter(drop, "$this$drop");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m5633takeLastqFRl0hI(drop, RangesKt.coerceAtLeast(UIntArray.m5326getSizeimpl(drop) - i, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: drop-r7IrZao, reason: not valid java name */
    public static final List<ULong> m5474dropr7IrZao(@NotNull long[] drop, int i) {
        Intrinsics.checkNotNullParameter(drop, "$this$drop");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m5634takeLastr7IrZao(drop, RangesKt.coerceAtLeast(ULongArray.m5351getSizeimpl(drop) - i, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: drop-PpDY95g, reason: not valid java name */
    public static final List<UByte> m5471dropPpDY95g(@NotNull byte[] drop, int i) {
        Intrinsics.checkNotNullParameter(drop, "$this$drop");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m5631takeLastPpDY95g(drop, RangesKt.coerceAtLeast(UByteArray.m5301getSizeimpl(drop) - i, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: drop-nggk6HY, reason: not valid java name */
    public static final List<UShort> m5472dropnggk6HY(@NotNull short[] drop, int i) {
        Intrinsics.checkNotNullParameter(drop, "$this$drop");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m5632takeLastnggk6HY(drop, RangesKt.coerceAtLeast(UShortArray.m5376getSizeimpl(drop) - i, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: dropLast-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m5477dropLastqFRl0hI(@NotNull int[] dropLast, int i) {
        Intrinsics.checkNotNullParameter(dropLast, "$this$dropLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m5629takeqFRl0hI(dropLast, RangesKt.coerceAtLeast(UIntArray.m5326getSizeimpl(dropLast) - i, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: dropLast-r7IrZao, reason: not valid java name */
    public static final List<ULong> m5478dropLastr7IrZao(@NotNull long[] dropLast, int i) {
        Intrinsics.checkNotNullParameter(dropLast, "$this$dropLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m5630taker7IrZao(dropLast, RangesKt.coerceAtLeast(ULongArray.m5351getSizeimpl(dropLast) - i, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: dropLast-PpDY95g, reason: not valid java name */
    public static final List<UByte> m5475dropLastPpDY95g(@NotNull byte[] dropLast, int i) {
        Intrinsics.checkNotNullParameter(dropLast, "$this$dropLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m5627takePpDY95g(dropLast, RangesKt.coerceAtLeast(UByteArray.m5301getSizeimpl(dropLast) - i, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: dropLast-nggk6HY, reason: not valid java name */
    public static final List<UShort> m5476dropLastnggk6HY(@NotNull short[] dropLast, int i) {
        Intrinsics.checkNotNullParameter(dropLast, "$this$dropLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m5628takenggk6HY(dropLast, RangesKt.coerceAtLeast(UShortArray.m5376getSizeimpl(dropLast) - i, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: slice-tAntMlw, reason: not valid java name */
    public static final List<UInt> m5582slicetAntMlw(@NotNull int[] slice, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt.emptyList() : UArraysKt___UArraysJvmKt.m5415asListajY9A(UIntArray.m5320constructorimpl(ArraysKt.copyOfRange(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: slice-ZRhS8yI, reason: not valid java name */
    public static final List<ULong> m5580sliceZRhS8yI(@NotNull long[] slice, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt.emptyList() : UArraysKt___UArraysJvmKt.m5417asListQwZRm1k(ULongArray.m5345constructorimpl(ArraysKt.copyOfRange(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: slice-c0bezYM, reason: not valid java name */
    public static final List<UByte> m5581slicec0bezYM(@NotNull byte[] slice, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt.emptyList() : UArraysKt___UArraysJvmKt.m5416asListGBYM_sE(UByteArray.m5295constructorimpl(ArraysKt.copyOfRange(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: slice-Q6IL4kU, reason: not valid java name */
    public static final List<UShort> m5579sliceQ6IL4kU(@NotNull short[] slice, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt.emptyList() : UArraysKt___UArraysJvmKt.m5418asListrL5Bavg(UShortArray.m5370constructorimpl(ArraysKt.copyOfRange(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: slice-HwE9HBo, reason: not valid java name */
    public static final List<UInt> m5576sliceHwE9HBo(@NotNull int[] slice, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(UInt.m5311boximpl(UIntArray.m5325getpVg5ArA(slice, it.next().intValue())));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: slice-F7u83W8, reason: not valid java name */
    public static final List<ULong> m5575sliceF7u83W8(@NotNull long[] slice, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(ULong.m5336boximpl(ULongArray.m5350getsVKNKU(slice, it.next().intValue())));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: slice-JQknh5Q, reason: not valid java name */
    public static final List<UByte> m5578sliceJQknh5Q(@NotNull byte[] slice, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(UByte.m5286boximpl(UByteArray.m5300getw2LRezQ(slice, it.next().intValue())));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: slice-JGPC0-M, reason: not valid java name */
    public static final List<UShort> m5577sliceJGPC0M(@NotNull short[] slice, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(UShort.m5361boximpl(UShortArray.m5375getMh2AYeg(slice, it.next().intValue())));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sliceArray-CFIt9YE, reason: not valid java name */
    public static final int[] m5583sliceArrayCFIt9YE(@NotNull int[] sliceArray, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UIntArray.m5320constructorimpl(ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sliceArray-kzHmqpY, reason: not valid java name */
    public static final long[] m5587sliceArraykzHmqpY(@NotNull long[] sliceArray, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return ULongArray.m5345constructorimpl(ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sliceArray-xo_DsdI, reason: not valid java name */
    public static final byte[] m5590sliceArrayxo_DsdI(@NotNull byte[] sliceArray, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UByteArray.m5295constructorimpl(ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sliceArray-ojwP5H8, reason: not valid java name */
    public static final short[] m5588sliceArrayojwP5H8(@NotNull short[] sliceArray, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UShortArray.m5370constructorimpl(ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sliceArray-tAntMlw, reason: not valid java name */
    public static final int[] m5589sliceArraytAntMlw(@NotNull int[] sliceArray, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UIntArray.m5320constructorimpl(ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sliceArray-ZRhS8yI, reason: not valid java name */
    public static final long[] m5585sliceArrayZRhS8yI(@NotNull long[] sliceArray, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return ULongArray.m5345constructorimpl(ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sliceArray-c0bezYM, reason: not valid java name */
    public static final byte[] m5586sliceArrayc0bezYM(@NotNull byte[] sliceArray, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UByteArray.m5295constructorimpl(ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sliceArray-Q6IL4kU, reason: not valid java name */
    public static final short[] m5584sliceArrayQ6IL4kU(@NotNull short[] sliceArray, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UShortArray.m5370constructorimpl(ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: take-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m5629takeqFRl0hI(@NotNull int[] take, int i) {
        Intrinsics.checkNotNullParameter(take, "$this$take");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        if (i >= UIntArray.m5326getSizeimpl(take)) {
            return CollectionsKt.toList(UIntArray.m5318boximpl(take));
        }
        if (i == 1) {
            return CollectionsKt.listOf(UInt.m5311boximpl(UIntArray.m5325getpVg5ArA(take, 0)));
        }
        ArrayList arrayList = new ArrayList(i);
        int iM5326getSizeimpl = UIntArray.m5326getSizeimpl(take);
        int i2 = 0;
        for (int i3 = 0; i3 < iM5326getSizeimpl; i3++) {
            arrayList.add(UInt.m5311boximpl(UIntArray.m5325getpVg5ArA(take, i3)));
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: take-r7IrZao, reason: not valid java name */
    public static final List<ULong> m5630taker7IrZao(@NotNull long[] take, int i) {
        Intrinsics.checkNotNullParameter(take, "$this$take");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        if (i >= ULongArray.m5351getSizeimpl(take)) {
            return CollectionsKt.toList(ULongArray.m5343boximpl(take));
        }
        if (i == 1) {
            return CollectionsKt.listOf(ULong.m5336boximpl(ULongArray.m5350getsVKNKU(take, 0)));
        }
        ArrayList arrayList = new ArrayList(i);
        int iM5351getSizeimpl = ULongArray.m5351getSizeimpl(take);
        int i2 = 0;
        for (int i3 = 0; i3 < iM5351getSizeimpl; i3++) {
            arrayList.add(ULong.m5336boximpl(ULongArray.m5350getsVKNKU(take, i3)));
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: take-PpDY95g, reason: not valid java name */
    public static final List<UByte> m5627takePpDY95g(@NotNull byte[] take, int i) {
        Intrinsics.checkNotNullParameter(take, "$this$take");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        if (i >= UByteArray.m5301getSizeimpl(take)) {
            return CollectionsKt.toList(UByteArray.m5293boximpl(take));
        }
        if (i == 1) {
            return CollectionsKt.listOf(UByte.m5286boximpl(UByteArray.m5300getw2LRezQ(take, 0)));
        }
        ArrayList arrayList = new ArrayList(i);
        int iM5301getSizeimpl = UByteArray.m5301getSizeimpl(take);
        int i2 = 0;
        for (int i3 = 0; i3 < iM5301getSizeimpl; i3++) {
            arrayList.add(UByte.m5286boximpl(UByteArray.m5300getw2LRezQ(take, i3)));
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: take-nggk6HY, reason: not valid java name */
    public static final List<UShort> m5628takenggk6HY(@NotNull short[] take, int i) {
        Intrinsics.checkNotNullParameter(take, "$this$take");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        if (i >= UShortArray.m5376getSizeimpl(take)) {
            return CollectionsKt.toList(UShortArray.m5368boximpl(take));
        }
        if (i == 1) {
            return CollectionsKt.listOf(UShort.m5361boximpl(UShortArray.m5375getMh2AYeg(take, 0)));
        }
        ArrayList arrayList = new ArrayList(i);
        int iM5376getSizeimpl = UShortArray.m5376getSizeimpl(take);
        int i2 = 0;
        for (int i3 = 0; i3 < iM5376getSizeimpl; i3++) {
            arrayList.add(UShort.m5361boximpl(UShortArray.m5375getMh2AYeg(take, i3)));
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: takeLast-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m5633takeLastqFRl0hI(@NotNull int[] takeLast, int i) {
        Intrinsics.checkNotNullParameter(takeLast, "$this$takeLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        int iM5326getSizeimpl = UIntArray.m5326getSizeimpl(takeLast);
        if (i >= iM5326getSizeimpl) {
            return CollectionsKt.toList(UIntArray.m5318boximpl(takeLast));
        }
        if (i == 1) {
            return CollectionsKt.listOf(UInt.m5311boximpl(UIntArray.m5325getpVg5ArA(takeLast, iM5326getSizeimpl - 1)));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = iM5326getSizeimpl - i; i2 < iM5326getSizeimpl; i2++) {
            arrayList.add(UInt.m5311boximpl(UIntArray.m5325getpVg5ArA(takeLast, i2)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: takeLast-r7IrZao, reason: not valid java name */
    public static final List<ULong> m5634takeLastr7IrZao(@NotNull long[] takeLast, int i) {
        Intrinsics.checkNotNullParameter(takeLast, "$this$takeLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        int iM5351getSizeimpl = ULongArray.m5351getSizeimpl(takeLast);
        if (i >= iM5351getSizeimpl) {
            return CollectionsKt.toList(ULongArray.m5343boximpl(takeLast));
        }
        if (i == 1) {
            return CollectionsKt.listOf(ULong.m5336boximpl(ULongArray.m5350getsVKNKU(takeLast, iM5351getSizeimpl - 1)));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = iM5351getSizeimpl - i; i2 < iM5351getSizeimpl; i2++) {
            arrayList.add(ULong.m5336boximpl(ULongArray.m5350getsVKNKU(takeLast, i2)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: takeLast-PpDY95g, reason: not valid java name */
    public static final List<UByte> m5631takeLastPpDY95g(@NotNull byte[] takeLast, int i) {
        Intrinsics.checkNotNullParameter(takeLast, "$this$takeLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        int iM5301getSizeimpl = UByteArray.m5301getSizeimpl(takeLast);
        if (i >= iM5301getSizeimpl) {
            return CollectionsKt.toList(UByteArray.m5293boximpl(takeLast));
        }
        if (i == 1) {
            return CollectionsKt.listOf(UByte.m5286boximpl(UByteArray.m5300getw2LRezQ(takeLast, iM5301getSizeimpl - 1)));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = iM5301getSizeimpl - i; i2 < iM5301getSizeimpl; i2++) {
            arrayList.add(UByte.m5286boximpl(UByteArray.m5300getw2LRezQ(takeLast, i2)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: takeLast-nggk6HY, reason: not valid java name */
    public static final List<UShort> m5632takeLastnggk6HY(@NotNull short[] takeLast, int i) {
        Intrinsics.checkNotNullParameter(takeLast, "$this$takeLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        int iM5376getSizeimpl = UShortArray.m5376getSizeimpl(takeLast);
        if (i >= iM5376getSizeimpl) {
            return CollectionsKt.toList(UShortArray.m5368boximpl(takeLast));
        }
        if (i == 1) {
            return CollectionsKt.listOf(UShort.m5361boximpl(UShortArray.m5375getMh2AYeg(takeLast, iM5376getSizeimpl - 1)));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = iM5376getSizeimpl - i; i2 < iM5376getSizeimpl; i2++) {
            arrayList.add(UShort.m5361boximpl(UShortArray.m5375getMh2AYeg(takeLast, i2)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: reversed--ajY-9A, reason: not valid java name */
    public static final List<UInt> m5559reversedajY9A(@NotNull int[] reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        if (UIntArray.m5328isEmptyimpl(reversed)) {
            return CollectionsKt.emptyList();
        }
        List<UInt> mutableList = CollectionsKt.toMutableList((Collection) UIntArray.m5318boximpl(reversed));
        CollectionsKt.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: reversed-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m5561reversedQwZRm1k(@NotNull long[] reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        if (ULongArray.m5353isEmptyimpl(reversed)) {
            return CollectionsKt.emptyList();
        }
        List<ULong> mutableList = CollectionsKt.toMutableList((Collection) ULongArray.m5343boximpl(reversed));
        CollectionsKt.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: reversed-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m5560reversedGBYM_sE(@NotNull byte[] reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        if (UByteArray.m5303isEmptyimpl(reversed)) {
            return CollectionsKt.emptyList();
        }
        List<UByte> mutableList = CollectionsKt.toMutableList((Collection) UByteArray.m5293boximpl(reversed));
        CollectionsKt.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: reversed-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m5562reversedrL5Bavg(@NotNull short[] reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        if (UShortArray.m5378isEmptyimpl(reversed)) {
            return CollectionsKt.emptyList();
        }
        List<UShort> mutableList = CollectionsKt.toMutableList((Collection) UShortArray.m5368boximpl(reversed));
        CollectionsKt.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: shuffle--ajY-9A, reason: not valid java name */
    public static final void m5563shuffleajY9A(@NotNull int[] shuffle) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        m5564shuffle2D5oskM(shuffle, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: shuffle-QwZRm1k, reason: not valid java name */
    public static final void m5567shuffleQwZRm1k(@NotNull long[] shuffle) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        m5566shuffleJzugnMA(shuffle, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: shuffle-GBYM_sE, reason: not valid java name */
    public static final void m5565shuffleGBYM_sE(@NotNull byte[] shuffle) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        m5568shuffleoSF2wD8(shuffle, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: shuffle-rL5Bavg, reason: not valid java name */
    public static final void m5569shufflerL5Bavg(@NotNull short[] shuffle) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        m5570shuffles5X_as8(shuffle, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortDescending--ajY-9A, reason: not valid java name */
    public static final void m5603sortDescendingajY9A(@NotNull int[] sortDescending) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        if (UIntArray.m5326getSizeimpl(sortDescending) > 1) {
            m5591sortajY9A(sortDescending);
            ArraysKt.reverse(sortDescending);
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortDescending-QwZRm1k, reason: not valid java name */
    public static final void m5608sortDescendingQwZRm1k(@NotNull long[] sortDescending) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        if (ULongArray.m5351getSizeimpl(sortDescending) > 1) {
            m5599sortQwZRm1k(sortDescending);
            ArraysKt.reverse(sortDescending);
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortDescending-GBYM_sE, reason: not valid java name */
    public static final void m5607sortDescendingGBYM_sE(@NotNull byte[] sortDescending) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        if (UByteArray.m5301getSizeimpl(sortDescending) > 1) {
            m5598sortGBYM_sE(sortDescending);
            ArraysKt.reverse(sortDescending);
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortDescending-rL5Bavg, reason: not valid java name */
    public static final void m5610sortDescendingrL5Bavg(@NotNull short[] sortDescending) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        if (UShortArray.m5376getSizeimpl(sortDescending) > 1) {
            m5602sortrL5Bavg(sortDescending);
            ArraysKt.reverse(sortDescending);
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sorted--ajY-9A, reason: not valid java name */
    public static final List<UInt> m5611sortedajY9A(@NotNull int[] sorted) {
        Intrinsics.checkNotNullParameter(sorted, "$this$sorted");
        int[] iArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        int[] iArrM5320constructorimpl = UIntArray.m5320constructorimpl(iArrCopyOf);
        m5591sortajY9A(iArrM5320constructorimpl);
        return UArraysKt___UArraysJvmKt.m5415asListajY9A(iArrM5320constructorimpl);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sorted-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m5613sortedQwZRm1k(@NotNull long[] sorted) {
        Intrinsics.checkNotNullParameter(sorted, "$this$sorted");
        long[] jArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        long[] jArrM5345constructorimpl = ULongArray.m5345constructorimpl(jArrCopyOf);
        m5599sortQwZRm1k(jArrM5345constructorimpl);
        return UArraysKt___UArraysJvmKt.m5417asListQwZRm1k(jArrM5345constructorimpl);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sorted-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m5612sortedGBYM_sE(@NotNull byte[] sorted) {
        Intrinsics.checkNotNullParameter(sorted, "$this$sorted");
        byte[] bArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        byte[] bArrM5295constructorimpl = UByteArray.m5295constructorimpl(bArrCopyOf);
        m5598sortGBYM_sE(bArrM5295constructorimpl);
        return UArraysKt___UArraysJvmKt.m5416asListGBYM_sE(bArrM5295constructorimpl);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sorted-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m5614sortedrL5Bavg(@NotNull short[] sorted) {
        Intrinsics.checkNotNullParameter(sorted, "$this$sorted");
        short[] sArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        short[] sArrM5370constructorimpl = UShortArray.m5370constructorimpl(sArrCopyOf);
        m5602sortrL5Bavg(sArrM5370constructorimpl);
        return UArraysKt___UArraysJvmKt.m5418asListrL5Bavg(sArrM5370constructorimpl);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sortedArray--ajY-9A, reason: not valid java name */
    public static final int[] m5615sortedArrayajY9A(@NotNull int[] sortedArray) {
        Intrinsics.checkNotNullParameter(sortedArray, "$this$sortedArray");
        if (UIntArray.m5328isEmptyimpl(sortedArray)) {
            return sortedArray;
        }
        int[] iArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        int[] iArrM5320constructorimpl = UIntArray.m5320constructorimpl(iArrCopyOf);
        m5591sortajY9A(iArrM5320constructorimpl);
        return iArrM5320constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sortedArray-QwZRm1k, reason: not valid java name */
    public static final long[] m5617sortedArrayQwZRm1k(@NotNull long[] sortedArray) {
        Intrinsics.checkNotNullParameter(sortedArray, "$this$sortedArray");
        if (ULongArray.m5353isEmptyimpl(sortedArray)) {
            return sortedArray;
        }
        long[] jArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        long[] jArrM5345constructorimpl = ULongArray.m5345constructorimpl(jArrCopyOf);
        m5599sortQwZRm1k(jArrM5345constructorimpl);
        return jArrM5345constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sortedArray-GBYM_sE, reason: not valid java name */
    public static final byte[] m5616sortedArrayGBYM_sE(@NotNull byte[] sortedArray) {
        Intrinsics.checkNotNullParameter(sortedArray, "$this$sortedArray");
        if (UByteArray.m5303isEmptyimpl(sortedArray)) {
            return sortedArray;
        }
        byte[] bArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        byte[] bArrM5295constructorimpl = UByteArray.m5295constructorimpl(bArrCopyOf);
        m5598sortGBYM_sE(bArrM5295constructorimpl);
        return bArrM5295constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sortedArray-rL5Bavg, reason: not valid java name */
    public static final short[] m5618sortedArrayrL5Bavg(@NotNull short[] sortedArray) {
        Intrinsics.checkNotNullParameter(sortedArray, "$this$sortedArray");
        if (UShortArray.m5378isEmptyimpl(sortedArray)) {
            return sortedArray;
        }
        short[] sArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        short[] sArrM5370constructorimpl = UShortArray.m5370constructorimpl(sArrCopyOf);
        m5602sortrL5Bavg(sArrM5370constructorimpl);
        return sArrM5370constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sortedArrayDescending--ajY-9A, reason: not valid java name */
    public static final int[] m5619sortedArrayDescendingajY9A(@NotNull int[] sortedArrayDescending) {
        Intrinsics.checkNotNullParameter(sortedArrayDescending, "$this$sortedArrayDescending");
        if (UIntArray.m5328isEmptyimpl(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        int[] iArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        int[] iArrM5320constructorimpl = UIntArray.m5320constructorimpl(iArrCopyOf);
        m5603sortDescendingajY9A(iArrM5320constructorimpl);
        return iArrM5320constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sortedArrayDescending-QwZRm1k, reason: not valid java name */
    public static final long[] m5621sortedArrayDescendingQwZRm1k(@NotNull long[] sortedArrayDescending) {
        Intrinsics.checkNotNullParameter(sortedArrayDescending, "$this$sortedArrayDescending");
        if (ULongArray.m5353isEmptyimpl(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        long[] jArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        long[] jArrM5345constructorimpl = ULongArray.m5345constructorimpl(jArrCopyOf);
        m5608sortDescendingQwZRm1k(jArrM5345constructorimpl);
        return jArrM5345constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sortedArrayDescending-GBYM_sE, reason: not valid java name */
    public static final byte[] m5620sortedArrayDescendingGBYM_sE(@NotNull byte[] sortedArrayDescending) {
        Intrinsics.checkNotNullParameter(sortedArrayDescending, "$this$sortedArrayDescending");
        if (UByteArray.m5303isEmptyimpl(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        byte[] bArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        byte[] bArrM5295constructorimpl = UByteArray.m5295constructorimpl(bArrCopyOf);
        m5607sortDescendingGBYM_sE(bArrM5295constructorimpl);
        return bArrM5295constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sortedArrayDescending-rL5Bavg, reason: not valid java name */
    public static final short[] m5622sortedArrayDescendingrL5Bavg(@NotNull short[] sortedArrayDescending) {
        Intrinsics.checkNotNullParameter(sortedArrayDescending, "$this$sortedArrayDescending");
        if (UShortArray.m5378isEmptyimpl(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        short[] sArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        short[] sArrM5370constructorimpl = UShortArray.m5370constructorimpl(sArrCopyOf);
        m5610sortDescendingrL5Bavg(sArrM5370constructorimpl);
        return sArrM5370constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sortedDescending--ajY-9A, reason: not valid java name */
    public static final List<UInt> m5623sortedDescendingajY9A(@NotNull int[] sortedDescending) {
        Intrinsics.checkNotNullParameter(sortedDescending, "$this$sortedDescending");
        int[] iArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        int[] iArrM5320constructorimpl = UIntArray.m5320constructorimpl(iArrCopyOf);
        m5591sortajY9A(iArrM5320constructorimpl);
        return m5559reversedajY9A(iArrM5320constructorimpl);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sortedDescending-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m5625sortedDescendingQwZRm1k(@NotNull long[] sortedDescending) {
        Intrinsics.checkNotNullParameter(sortedDescending, "$this$sortedDescending");
        long[] jArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        long[] jArrM5345constructorimpl = ULongArray.m5345constructorimpl(jArrCopyOf);
        m5599sortQwZRm1k(jArrM5345constructorimpl);
        return m5561reversedQwZRm1k(jArrM5345constructorimpl);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sortedDescending-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m5624sortedDescendingGBYM_sE(@NotNull byte[] sortedDescending) {
        Intrinsics.checkNotNullParameter(sortedDescending, "$this$sortedDescending");
        byte[] bArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        byte[] bArrM5295constructorimpl = UByteArray.m5295constructorimpl(bArrCopyOf);
        m5598sortGBYM_sE(bArrM5295constructorimpl);
        return m5560reversedGBYM_sE(bArrM5295constructorimpl);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: sortedDescending-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m5626sortedDescendingrL5Bavg(@NotNull short[] sortedDescending) {
        Intrinsics.checkNotNullParameter(sortedDescending, "$this$sortedDescending");
        short[] sArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        short[] sArrM5370constructorimpl = UShortArray.m5370constructorimpl(sArrCopyOf);
        m5602sortrL5Bavg(sArrM5370constructorimpl);
        return m5562reversedrL5Bavg(sArrM5370constructorimpl);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: contentEquals-KJPZfPQ, reason: not valid java name */
    public static boolean m5460contentEqualsKJPZfPQ(@Nullable int[] iArr, @Nullable int[] iArr2) {
        if (iArr == null) {
            iArr = null;
        }
        if (iArr2 == null) {
            iArr2 = null;
        }
        return Arrays.equals(iArr, iArr2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: contentEquals-lec5QzE, reason: not valid java name */
    public static boolean m5462contentEqualslec5QzE(@Nullable long[] jArr, @Nullable long[] jArr2) {
        if (jArr == null) {
            jArr = null;
        }
        if (jArr2 == null) {
            jArr2 = null;
        }
        return Arrays.equals(jArr, jArr2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: contentEquals-kV0jMPg, reason: not valid java name */
    public static boolean m5461contentEqualskV0jMPg(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            bArr = null;
        }
        if (bArr2 == null) {
            bArr2 = null;
        }
        return Arrays.equals(bArr, bArr2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: contentEquals-FGO6Aew, reason: not valid java name */
    public static boolean m5459contentEqualsFGO6Aew(@Nullable short[] sArr, @Nullable short[] sArr2) {
        if (sArr == null) {
            sArr = null;
        }
        if (sArr2 == null) {
            sArr2 = null;
        }
        return Arrays.equals(sArr, sArr2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: contentHashCode-XUkPCBk, reason: not valid java name */
    public static final int m5464contentHashCodeXUkPCBk(@Nullable int[] iArr) {
        if (iArr == null) {
            iArr = null;
        }
        return Arrays.hashCode(iArr);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: contentHashCode-uLth9ew, reason: not valid java name */
    public static final int m5466contentHashCodeuLth9ew(@Nullable long[] jArr) {
        if (jArr == null) {
            jArr = null;
        }
        return Arrays.hashCode(jArr);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: contentHashCode-2csIQuQ, reason: not valid java name */
    public static final int m5463contentHashCode2csIQuQ(@Nullable byte[] bArr) {
        if (bArr == null) {
            bArr = null;
        }
        return Arrays.hashCode(bArr);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: contentHashCode-d-6D3K8, reason: not valid java name */
    public static final int m5465contentHashCoded6D3K8(@Nullable short[] sArr) {
        if (sArr == null) {
            sArr = null;
        }
        return Arrays.hashCode(sArr);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: contentToString-XUkPCBk, reason: not valid java name */
    public static String m5468contentToStringXUkPCBk(@Nullable int[] iArr) {
        String strJoinToString$default;
        return (iArr == null || (strJoinToString$default = CollectionsKt.joinToString$default(UIntArray.m5318boximpl(iArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strJoinToString$default;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: contentToString-uLth9ew, reason: not valid java name */
    public static String m5470contentToStringuLth9ew(@Nullable long[] jArr) {
        String strJoinToString$default;
        return (jArr == null || (strJoinToString$default = CollectionsKt.joinToString$default(ULongArray.m5343boximpl(jArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strJoinToString$default;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: contentToString-2csIQuQ, reason: not valid java name */
    public static String m5467contentToString2csIQuQ(@Nullable byte[] bArr) {
        String strJoinToString$default;
        return (bArr == null || (strJoinToString$default = CollectionsKt.joinToString$default(UByteArray.m5293boximpl(bArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strJoinToString$default;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: contentToString-d-6D3K8, reason: not valid java name */
    public static String m5469contentToStringd6D3K8(@Nullable short[] sArr) {
        String strJoinToString$default;
        return (sArr == null || (strJoinToString$default = CollectionsKt.joinToString$default(UShortArray.m5368boximpl(sArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strJoinToString$default;
    }

    /* JADX INFO: renamed from: fill-2fe2U9s$default, reason: not valid java name */
    public static /* synthetic */ void m5480fill2fe2U9s$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UIntArray.m5326getSizeimpl(iArr);
        }
        m5479fill2fe2U9s(iArr, i, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: fill-2fe2U9s, reason: not valid java name */
    public static final void m5479fill2fe2U9s(@NotNull int[] fill, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        ArraysKt.fill(fill, i, i2, i3);
    }

    /* JADX INFO: renamed from: fill-K6DWlUc$default, reason: not valid java name */
    public static /* synthetic */ void m5484fillK6DWlUc$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m5351getSizeimpl(jArr);
        }
        m5483fillK6DWlUc(jArr, j, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: fill-K6DWlUc, reason: not valid java name */
    public static final void m5483fillK6DWlUc(@NotNull long[] fill, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        ArraysKt.fill(fill, j, i, i2);
    }

    /* JADX INFO: renamed from: fill-WpHrYlw$default, reason: not valid java name */
    public static /* synthetic */ void m5486fillWpHrYlw$default(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m5301getSizeimpl(bArr);
        }
        m5485fillWpHrYlw(bArr, b, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: fill-WpHrYlw, reason: not valid java name */
    public static final void m5485fillWpHrYlw(@NotNull byte[] fill, byte b, int i, int i2) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        ArraysKt.fill(fill, b, i, i2);
    }

    /* JADX INFO: renamed from: fill-EtDCXyQ$default, reason: not valid java name */
    public static /* synthetic */ void m5482fillEtDCXyQ$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m5376getSizeimpl(sArr);
        }
        m5481fillEtDCXyQ(sArr, s, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: fill-EtDCXyQ, reason: not valid java name */
    public static final void m5481fillEtDCXyQ(@NotNull short[] fill, short s, int i, int i2) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        ArraysKt.fill(fill, s, i, i2);
    }

    @NotNull
    /* JADX INFO: renamed from: getIndices--ajY-9A, reason: not valid java name */
    public static final IntRange m5491getIndicesajY9A(@NotNull int[] indices) {
        Intrinsics.checkNotNullParameter(indices, "$this$indices");
        return ArraysKt.getIndices(indices);
    }

    @NotNull
    /* JADX INFO: renamed from: getIndices-QwZRm1k, reason: not valid java name */
    public static final IntRange m5495getIndicesQwZRm1k(@NotNull long[] indices) {
        Intrinsics.checkNotNullParameter(indices, "$this$indices");
        return ArraysKt.getIndices(indices);
    }

    @NotNull
    /* JADX INFO: renamed from: getIndices-GBYM_sE, reason: not valid java name */
    public static final IntRange m5493getIndicesGBYM_sE(@NotNull byte[] indices) {
        Intrinsics.checkNotNullParameter(indices, "$this$indices");
        return ArraysKt.getIndices(indices);
    }

    @NotNull
    /* JADX INFO: renamed from: getIndices-rL5Bavg, reason: not valid java name */
    public static final IntRange m5497getIndicesrL5Bavg(@NotNull short[] indices) {
        Intrinsics.checkNotNullParameter(indices, "$this$indices");
        return ArraysKt.getIndices(indices);
    }

    /* JADX INFO: renamed from: getLastIndex--ajY-9A, reason: not valid java name */
    public static final int m5499getLastIndexajY9A(@NotNull int[] lastIndex) {
        Intrinsics.checkNotNullParameter(lastIndex, "$this$lastIndex");
        return ArraysKt.getLastIndex(lastIndex);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: shuffle-2D5oskM, reason: not valid java name */
    public static final void m5564shuffle2D5oskM(@NotNull int[] shuffle, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt.getLastIndex(shuffle); lastIndex > 0; lastIndex--) {
            int iNextInt = random.nextInt(lastIndex + 1);
            int iM5325getpVg5ArA = UIntArray.m5325getpVg5ArA(shuffle, lastIndex);
            UIntArray.m5330setVXSXFK8(shuffle, lastIndex, UIntArray.m5325getpVg5ArA(shuffle, iNextInt));
            UIntArray.m5330setVXSXFK8(shuffle, iNextInt, iM5325getpVg5ArA);
        }
    }

    /* JADX INFO: renamed from: getLastIndex-QwZRm1k, reason: not valid java name */
    public static final int m5503getLastIndexQwZRm1k(@NotNull long[] lastIndex) {
        Intrinsics.checkNotNullParameter(lastIndex, "$this$lastIndex");
        return ArraysKt.getLastIndex(lastIndex);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: shuffle-JzugnMA, reason: not valid java name */
    public static final void m5566shuffleJzugnMA(@NotNull long[] shuffle, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt.getLastIndex(shuffle); lastIndex > 0; lastIndex--) {
            int iNextInt = random.nextInt(lastIndex + 1);
            long jM5350getsVKNKU = ULongArray.m5350getsVKNKU(shuffle, lastIndex);
            ULongArray.m5355setk8EXiF4(shuffle, lastIndex, ULongArray.m5350getsVKNKU(shuffle, iNextInt));
            ULongArray.m5355setk8EXiF4(shuffle, iNextInt, jM5350getsVKNKU);
        }
    }

    /* JADX INFO: renamed from: getLastIndex-GBYM_sE, reason: not valid java name */
    public static final int m5501getLastIndexGBYM_sE(@NotNull byte[] lastIndex) {
        Intrinsics.checkNotNullParameter(lastIndex, "$this$lastIndex");
        return ArraysKt.getLastIndex(lastIndex);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: shuffle-oSF2wD8, reason: not valid java name */
    public static final void m5568shuffleoSF2wD8(@NotNull byte[] shuffle, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt.getLastIndex(shuffle); lastIndex > 0; lastIndex--) {
            int iNextInt = random.nextInt(lastIndex + 1);
            byte bM5300getw2LRezQ = UByteArray.m5300getw2LRezQ(shuffle, lastIndex);
            UByteArray.m5305setVurrAj0(shuffle, lastIndex, UByteArray.m5300getw2LRezQ(shuffle, iNextInt));
            UByteArray.m5305setVurrAj0(shuffle, iNextInt, bM5300getw2LRezQ);
        }
    }

    /* JADX INFO: renamed from: getLastIndex-rL5Bavg, reason: not valid java name */
    public static final int m5505getLastIndexrL5Bavg(@NotNull short[] lastIndex) {
        Intrinsics.checkNotNullParameter(lastIndex, "$this$lastIndex");
        return ArraysKt.getLastIndex(lastIndex);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: shuffle-s5X_as8, reason: not valid java name */
    public static final void m5570shuffles5X_as8(@NotNull short[] shuffle, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt.getLastIndex(shuffle); lastIndex > 0; lastIndex--) {
            int iNextInt = random.nextInt(lastIndex + 1);
            short sM5375getMh2AYeg = UShortArray.m5375getMh2AYeg(shuffle, lastIndex);
            UShortArray.m5380set01HTLdE(shuffle, lastIndex, UShortArray.m5375getMh2AYeg(shuffle, iNextInt));
            UShortArray.m5380set01HTLdE(shuffle, iNextInt, sM5375getMh2AYeg);
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: plus-CFIt9YE, reason: not valid java name */
    public static final int[] m5547plusCFIt9YE(@NotNull int[] plus, @NotNull Collection<UInt> elements) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int iM5326getSizeimpl = UIntArray.m5326getSizeimpl(plus);
        int[] iArrCopyOf = Arrays.copyOf(plus, UIntArray.m5326getSizeimpl(plus) + elements.size());
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        Iterator<UInt> it = elements.iterator();
        while (it.hasNext()) {
            iArrCopyOf[iM5326getSizeimpl] = it.next().getData();
            iM5326getSizeimpl++;
        }
        return UIntArray.m5320constructorimpl(iArrCopyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: plus-kzHmqpY, reason: not valid java name */
    public static final long[] m5548pluskzHmqpY(@NotNull long[] plus, @NotNull Collection<ULong> elements) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int iM5351getSizeimpl = ULongArray.m5351getSizeimpl(plus);
        long[] jArrCopyOf = Arrays.copyOf(plus, ULongArray.m5351getSizeimpl(plus) + elements.size());
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        Iterator<ULong> it = elements.iterator();
        while (it.hasNext()) {
            jArrCopyOf[iM5351getSizeimpl] = it.next().getData();
            iM5351getSizeimpl++;
        }
        return ULongArray.m5345constructorimpl(jArrCopyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: plus-xo_DsdI, reason: not valid java name */
    public static final byte[] m5550plusxo_DsdI(@NotNull byte[] plus, @NotNull Collection<UByte> elements) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int iM5301getSizeimpl = UByteArray.m5301getSizeimpl(plus);
        byte[] bArrCopyOf = Arrays.copyOf(plus, UByteArray.m5301getSizeimpl(plus) + elements.size());
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        Iterator<UByte> it = elements.iterator();
        while (it.hasNext()) {
            bArrCopyOf[iM5301getSizeimpl] = it.next().getData();
            iM5301getSizeimpl++;
        }
        return UByteArray.m5295constructorimpl(bArrCopyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: plus-ojwP5H8, reason: not valid java name */
    public static final short[] m5549plusojwP5H8(@NotNull short[] plus, @NotNull Collection<UShort> elements) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int iM5376getSizeimpl = UShortArray.m5376getSizeimpl(plus);
        short[] sArrCopyOf = Arrays.copyOf(plus, UShortArray.m5376getSizeimpl(plus) + elements.size());
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        Iterator<UShort> it = elements.iterator();
        while (it.hasNext()) {
            sArrCopyOf[iM5376getSizeimpl] = it.next().getData();
            iM5376getSizeimpl++;
        }
        return UShortArray.m5370constructorimpl(sArrCopyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sort--ajY-9A, reason: not valid java name */
    public static final void m5591sortajY9A(@NotNull int[] sort) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        if (UIntArray.m5326getSizeimpl(sort) > 1) {
            UArraySortingKt.m5413sortArrayoBK06Vg(sort, 0, UIntArray.m5326getSizeimpl(sort));
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sort-QwZRm1k, reason: not valid java name */
    public static final void m5599sortQwZRm1k(@NotNull long[] sort) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        if (ULongArray.m5351getSizeimpl(sort) > 1) {
            UArraySortingKt.m5410sortArraynroSd4(sort, 0, ULongArray.m5351getSizeimpl(sort));
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sort-GBYM_sE, reason: not valid java name */
    public static final void m5598sortGBYM_sE(@NotNull byte[] sort) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        if (UByteArray.m5301getSizeimpl(sort) > 1) {
            UArraySortingKt.m5411sortArray4UcCI2c(sort, 0, UByteArray.m5301getSizeimpl(sort));
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sort-rL5Bavg, reason: not valid java name */
    public static final void m5602sortrL5Bavg(@NotNull short[] sort) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        if (UShortArray.m5376getSizeimpl(sort) > 1) {
            UArraySortingKt.m5412sortArrayAa5vz7o(sort, 0, UShortArray.m5376getSizeimpl(sort));
        }
    }

    /* JADX INFO: renamed from: sort-oBK06Vg$default, reason: not valid java name */
    public static /* synthetic */ void m5601sortoBK06Vg$default(int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = UIntArray.m5326getSizeimpl(iArr);
        }
        m5600sortoBK06Vg(iArr, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sort-oBK06Vg, reason: not valid java name */
    public static final void m5600sortoBK06Vg(@NotNull int[] sort, int i, int i2) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, UIntArray.m5326getSizeimpl(sort));
        UArraySortingKt.m5413sortArrayoBK06Vg(sort, i, i2);
    }

    /* JADX INFO: renamed from: sort--nroSd4$default, reason: not valid java name */
    public static /* synthetic */ void m5593sortnroSd4$default(long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = ULongArray.m5351getSizeimpl(jArr);
        }
        m5592sortnroSd4(jArr, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sort--nroSd4, reason: not valid java name */
    public static final void m5592sortnroSd4(@NotNull long[] sort, int i, int i2) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, ULongArray.m5351getSizeimpl(sort));
        UArraySortingKt.m5410sortArraynroSd4(sort, i, i2);
    }

    /* JADX INFO: renamed from: sort-4UcCI2c$default, reason: not valid java name */
    public static /* synthetic */ void m5595sort4UcCI2c$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = UByteArray.m5301getSizeimpl(bArr);
        }
        m5594sort4UcCI2c(bArr, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sort-4UcCI2c, reason: not valid java name */
    public static final void m5594sort4UcCI2c(@NotNull byte[] sort, int i, int i2) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, UByteArray.m5301getSizeimpl(sort));
        UArraySortingKt.m5411sortArray4UcCI2c(sort, i, i2);
    }

    /* JADX INFO: renamed from: sort-Aa5vz7o$default, reason: not valid java name */
    public static /* synthetic */ void m5597sortAa5vz7o$default(short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = UShortArray.m5376getSizeimpl(sArr);
        }
        m5596sortAa5vz7o(sArr, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sort-Aa5vz7o, reason: not valid java name */
    public static final void m5596sortAa5vz7o(@NotNull short[] sort, int i, int i2) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, UShortArray.m5376getSizeimpl(sort));
        UArraySortingKt.m5412sortArrayAa5vz7o(sort, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortDescending-oBK06Vg, reason: not valid java name */
    public static final void m5609sortDescendingoBK06Vg(@NotNull int[] sortDescending, int i, int i2) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        m5600sortoBK06Vg(sortDescending, i, i2);
        ArraysKt.reverse(sortDescending, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortDescending--nroSd4, reason: not valid java name */
    public static final void m5604sortDescendingnroSd4(@NotNull long[] sortDescending, int i, int i2) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        m5592sortnroSd4(sortDescending, i, i2);
        ArraysKt.reverse(sortDescending, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortDescending-4UcCI2c, reason: not valid java name */
    public static final void m5605sortDescending4UcCI2c(@NotNull byte[] sortDescending, int i, int i2) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        m5594sort4UcCI2c(sortDescending, i, i2);
        ArraysKt.reverse(sortDescending, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortDescending-Aa5vz7o, reason: not valid java name */
    public static final void m5606sortDescendingAa5vz7o(@NotNull short[] sortDescending, int i, int i2) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        m5596sortAa5vz7o(sortDescending, i, i2);
        ArraysKt.reverse(sortDescending, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: toTypedArray--ajY-9A, reason: not valid java name */
    public static final UInt[] m5635toTypedArrayajY9A(@NotNull int[] toTypedArray) {
        Intrinsics.checkNotNullParameter(toTypedArray, "$this$toTypedArray");
        int iM5326getSizeimpl = UIntArray.m5326getSizeimpl(toTypedArray);
        UInt[] uIntArr = new UInt[iM5326getSizeimpl];
        for (int i = 0; i < iM5326getSizeimpl; i++) {
            uIntArr[i] = UInt.m5311boximpl(UIntArray.m5325getpVg5ArA(toTypedArray, i));
        }
        return uIntArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: toTypedArray-QwZRm1k, reason: not valid java name */
    public static final ULong[] m5637toTypedArrayQwZRm1k(@NotNull long[] toTypedArray) {
        Intrinsics.checkNotNullParameter(toTypedArray, "$this$toTypedArray");
        int iM5351getSizeimpl = ULongArray.m5351getSizeimpl(toTypedArray);
        ULong[] uLongArr = new ULong[iM5351getSizeimpl];
        for (int i = 0; i < iM5351getSizeimpl; i++) {
            uLongArr[i] = ULong.m5336boximpl(ULongArray.m5350getsVKNKU(toTypedArray, i));
        }
        return uLongArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: toTypedArray-GBYM_sE, reason: not valid java name */
    public static final UByte[] m5636toTypedArrayGBYM_sE(@NotNull byte[] toTypedArray) {
        Intrinsics.checkNotNullParameter(toTypedArray, "$this$toTypedArray");
        int iM5301getSizeimpl = UByteArray.m5301getSizeimpl(toTypedArray);
        UByte[] uByteArr = new UByte[iM5301getSizeimpl];
        for (int i = 0; i < iM5301getSizeimpl; i++) {
            uByteArr[i] = UByte.m5286boximpl(UByteArray.m5300getw2LRezQ(toTypedArray, i));
        }
        return uByteArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: toTypedArray-rL5Bavg, reason: not valid java name */
    public static final UShort[] m5638toTypedArrayrL5Bavg(@NotNull short[] toTypedArray) {
        Intrinsics.checkNotNullParameter(toTypedArray, "$this$toTypedArray");
        int iM5376getSizeimpl = UShortArray.m5376getSizeimpl(toTypedArray);
        UShort[] uShortArr = new UShort[iM5376getSizeimpl];
        for (int i = 0; i < iM5376getSizeimpl; i++) {
            uShortArr[i] = UShort.m5361boximpl(UShortArray.m5375getMh2AYeg(toTypedArray, i));
        }
        return uShortArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] toUByteArray(@NotNull UByte[] uByteArr) {
        Intrinsics.checkNotNullParameter(uByteArr, "<this>");
        int length = uByteArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = uByteArr[i].getData();
        }
        return UByteArray.m5295constructorimpl(bArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final int[] toUIntArray(@NotNull UInt[] uIntArr) {
        Intrinsics.checkNotNullParameter(uIntArr, "<this>");
        int length = uIntArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = uIntArr[i].getData();
        }
        return UIntArray.m5320constructorimpl(iArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final long[] toULongArray(@NotNull ULong[] uLongArr) {
        Intrinsics.checkNotNullParameter(uLongArr, "<this>");
        int length = uLongArr.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = uLongArr[i].getData();
        }
        return ULongArray.m5345constructorimpl(jArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final short[] toUShortArray(@NotNull UShort[] uShortArr) {
        Intrinsics.checkNotNullParameter(uShortArr, "<this>");
        int length = uShortArr.length;
        short[] sArr = new short[length];
        for (int i = 0; i < length; i++) {
            sArr[i] = uShortArr[i].getData();
        }
        return UShortArray.m5370constructorimpl(sArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: withIndex--ajY-9A, reason: not valid java name */
    public static final Iterable<IndexedValue<UInt>> m5639withIndexajY9A(@NotNull final int[] withIndex) {
        Intrinsics.checkNotNullParameter(withIndex, "$this$withIndex");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.unsigned.UArraysKt___UArraysKt$withIndex$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Iterator invoke() {
                return UIntArray.m5329iteratorimpl(withIndex);
            }
        });
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: withIndex-QwZRm1k, reason: not valid java name */
    public static final Iterable<IndexedValue<ULong>> m5641withIndexQwZRm1k(@NotNull final long[] withIndex) {
        Intrinsics.checkNotNullParameter(withIndex, "$this$withIndex");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.unsigned.UArraysKt___UArraysKt$withIndex$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Iterator invoke() {
                return ULongArray.m5354iteratorimpl(withIndex);
            }
        });
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: withIndex-GBYM_sE, reason: not valid java name */
    public static final Iterable<IndexedValue<UByte>> m5640withIndexGBYM_sE(@NotNull final byte[] withIndex) {
        Intrinsics.checkNotNullParameter(withIndex, "$this$withIndex");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.unsigned.UArraysKt___UArraysKt$withIndex$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Iterator invoke() {
                return UByteArray.m5304iteratorimpl(withIndex);
            }
        });
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: withIndex-rL5Bavg, reason: not valid java name */
    public static final Iterable<IndexedValue<UShort>> m5642withIndexrL5Bavg(@NotNull final short[] withIndex) {
        Intrinsics.checkNotNullParameter(withIndex, "$this$withIndex");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.unsigned.UArraysKt___UArraysKt$withIndex$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Iterator invoke() {
                return UShortArray.m5379iteratorimpl(withIndex);
            }
        });
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxOrThrow-U")
    /* JADX INFO: renamed from: maxOrThrow-U, reason: not valid java name */
    public static final int m5520maxOrThrowU(@NotNull int[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        if (UIntArray.m5328isEmptyimpl(max)) {
            throw new NoSuchElementException();
        }
        int iM5325getpVg5ArA = UIntArray.m5325getpVg5ArA(max, 0);
        int lastIndex = ArraysKt.getLastIndex(max);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM5325getpVg5ArA2 = UIntArray.m5325getpVg5ArA(max, i);
                if (Integer.compareUnsigned(iM5325getpVg5ArA, iM5325getpVg5ArA2) < 0) {
                    iM5325getpVg5ArA = iM5325getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return iM5325getpVg5ArA;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxOrThrow-U")
    /* JADX INFO: renamed from: maxOrThrow-U, reason: not valid java name */
    public static final long m5521maxOrThrowU(@NotNull long[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        if (ULongArray.m5353isEmptyimpl(max)) {
            throw new NoSuchElementException();
        }
        long jM5350getsVKNKU = ULongArray.m5350getsVKNKU(max, 0);
        int lastIndex = ArraysKt.getLastIndex(max);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM5350getsVKNKU2 = ULongArray.m5350getsVKNKU(max, i);
                if (Long.compareUnsigned(jM5350getsVKNKU, jM5350getsVKNKU2) < 0) {
                    jM5350getsVKNKU = jM5350getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return jM5350getsVKNKU;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxOrThrow-U")
    /* JADX INFO: renamed from: maxOrThrow-U, reason: not valid java name */
    public static final byte m5519maxOrThrowU(@NotNull byte[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        if (UByteArray.m5303isEmptyimpl(max)) {
            throw new NoSuchElementException();
        }
        byte bM5300getw2LRezQ = UByteArray.m5300getw2LRezQ(max, 0);
        int lastIndex = ArraysKt.getLastIndex(max);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM5300getw2LRezQ2 = UByteArray.m5300getw2LRezQ(max, i);
                if (Intrinsics.compare(bM5300getw2LRezQ & 255, bM5300getw2LRezQ2 & 255) < 0) {
                    bM5300getw2LRezQ = bM5300getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return bM5300getw2LRezQ;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxOrThrow-U")
    /* JADX INFO: renamed from: maxOrThrow-U, reason: not valid java name */
    public static final short m5522maxOrThrowU(@NotNull short[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        if (UShortArray.m5378isEmptyimpl(max)) {
            throw new NoSuchElementException();
        }
        short sM5375getMh2AYeg = UShortArray.m5375getMh2AYeg(max, 0);
        int lastIndex = ArraysKt.getLastIndex(max);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM5375getMh2AYeg2 = UShortArray.m5375getMh2AYeg(max, i);
                if (Intrinsics.compare(sM5375getMh2AYeg & UShort.MAX_VALUE, 65535 & sM5375getMh2AYeg2) < 0) {
                    sM5375getMh2AYeg = sM5375getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return sM5375getMh2AYeg;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: maxOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m5515maxOrNullajY9A(@NotNull int[] maxOrNull) {
        Intrinsics.checkNotNullParameter(maxOrNull, "$this$maxOrNull");
        if (UIntArray.m5328isEmptyimpl(maxOrNull)) {
            return null;
        }
        int iM5325getpVg5ArA = UIntArray.m5325getpVg5ArA(maxOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(maxOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM5325getpVg5ArA2 = UIntArray.m5325getpVg5ArA(maxOrNull, i);
                if (Integer.compareUnsigned(iM5325getpVg5ArA, iM5325getpVg5ArA2) < 0) {
                    iM5325getpVg5ArA = iM5325getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m5311boximpl(iM5325getpVg5ArA);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: maxOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m5517maxOrNullQwZRm1k(@NotNull long[] maxOrNull) {
        Intrinsics.checkNotNullParameter(maxOrNull, "$this$maxOrNull");
        if (ULongArray.m5353isEmptyimpl(maxOrNull)) {
            return null;
        }
        long jM5350getsVKNKU = ULongArray.m5350getsVKNKU(maxOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(maxOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM5350getsVKNKU2 = ULongArray.m5350getsVKNKU(maxOrNull, i);
                if (Long.compareUnsigned(jM5350getsVKNKU, jM5350getsVKNKU2) < 0) {
                    jM5350getsVKNKU = jM5350getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m5336boximpl(jM5350getsVKNKU);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: maxOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m5516maxOrNullGBYM_sE(@NotNull byte[] maxOrNull) {
        Intrinsics.checkNotNullParameter(maxOrNull, "$this$maxOrNull");
        if (UByteArray.m5303isEmptyimpl(maxOrNull)) {
            return null;
        }
        byte bM5300getw2LRezQ = UByteArray.m5300getw2LRezQ(maxOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(maxOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM5300getw2LRezQ2 = UByteArray.m5300getw2LRezQ(maxOrNull, i);
                if (Intrinsics.compare(bM5300getw2LRezQ & 255, bM5300getw2LRezQ2 & 255) < 0) {
                    bM5300getw2LRezQ = bM5300getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m5286boximpl(bM5300getw2LRezQ);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: maxOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m5518maxOrNullrL5Bavg(@NotNull short[] maxOrNull) {
        Intrinsics.checkNotNullParameter(maxOrNull, "$this$maxOrNull");
        if (UShortArray.m5378isEmptyimpl(maxOrNull)) {
            return null;
        }
        short sM5375getMh2AYeg = UShortArray.m5375getMh2AYeg(maxOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(maxOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM5375getMh2AYeg2 = UShortArray.m5375getMh2AYeg(maxOrNull, i);
                if (Intrinsics.compare(sM5375getMh2AYeg & UShort.MAX_VALUE, 65535 & sM5375getMh2AYeg2) < 0) {
                    sM5375getMh2AYeg = sM5375getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m5361boximpl(sM5375getMh2AYeg);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxWithOrThrow-U")
    /* JADX INFO: renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final int m5528maxWithOrThrowU(@NotNull int[] maxWith, @NotNull Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UIntArray.m5328isEmptyimpl(maxWith)) {
            throw new NoSuchElementException();
        }
        int iM5325getpVg5ArA = UIntArray.m5325getpVg5ArA(maxWith, 0);
        int lastIndex = ArraysKt.getLastIndex(maxWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM5325getpVg5ArA2 = UIntArray.m5325getpVg5ArA(maxWith, i);
                if (comparator.compare(UInt.m5311boximpl(iM5325getpVg5ArA), UInt.m5311boximpl(iM5325getpVg5ArA2)) < 0) {
                    iM5325getpVg5ArA = iM5325getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return iM5325getpVg5ArA;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxWithOrThrow-U")
    /* JADX INFO: renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final long m5529maxWithOrThrowU(@NotNull long[] maxWith, @NotNull Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (ULongArray.m5353isEmptyimpl(maxWith)) {
            throw new NoSuchElementException();
        }
        long jM5350getsVKNKU = ULongArray.m5350getsVKNKU(maxWith, 0);
        int lastIndex = ArraysKt.getLastIndex(maxWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM5350getsVKNKU2 = ULongArray.m5350getsVKNKU(maxWith, i);
                if (comparator.compare(ULong.m5336boximpl(jM5350getsVKNKU), ULong.m5336boximpl(jM5350getsVKNKU2)) < 0) {
                    jM5350getsVKNKU = jM5350getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return jM5350getsVKNKU;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxWithOrThrow-U")
    /* JADX INFO: renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final byte m5527maxWithOrThrowU(@NotNull byte[] maxWith, @NotNull Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UByteArray.m5303isEmptyimpl(maxWith)) {
            throw new NoSuchElementException();
        }
        byte bM5300getw2LRezQ = UByteArray.m5300getw2LRezQ(maxWith, 0);
        int lastIndex = ArraysKt.getLastIndex(maxWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM5300getw2LRezQ2 = UByteArray.m5300getw2LRezQ(maxWith, i);
                if (comparator.compare(UByte.m5286boximpl(bM5300getw2LRezQ), UByte.m5286boximpl(bM5300getw2LRezQ2)) < 0) {
                    bM5300getw2LRezQ = bM5300getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return bM5300getw2LRezQ;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxWithOrThrow-U")
    /* JADX INFO: renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final short m5530maxWithOrThrowU(@NotNull short[] maxWith, @NotNull Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UShortArray.m5378isEmptyimpl(maxWith)) {
            throw new NoSuchElementException();
        }
        short sM5375getMh2AYeg = UShortArray.m5375getMh2AYeg(maxWith, 0);
        int lastIndex = ArraysKt.getLastIndex(maxWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM5375getMh2AYeg2 = UShortArray.m5375getMh2AYeg(maxWith, i);
                if (comparator.compare(UShort.m5361boximpl(sM5375getMh2AYeg), UShort.m5361boximpl(sM5375getMh2AYeg2)) < 0) {
                    sM5375getMh2AYeg = sM5375getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return sM5375getMh2AYeg;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: maxWithOrNull-YmdZ_VM, reason: not valid java name */
    public static final UInt m5524maxWithOrNullYmdZ_VM(@NotNull int[] maxWithOrNull, @NotNull Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(maxWithOrNull, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UIntArray.m5328isEmptyimpl(maxWithOrNull)) {
            return null;
        }
        int iM5325getpVg5ArA = UIntArray.m5325getpVg5ArA(maxWithOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(maxWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM5325getpVg5ArA2 = UIntArray.m5325getpVg5ArA(maxWithOrNull, i);
                if (comparator.compare(UInt.m5311boximpl(iM5325getpVg5ArA), UInt.m5311boximpl(iM5325getpVg5ArA2)) < 0) {
                    iM5325getpVg5ArA = iM5325getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m5311boximpl(iM5325getpVg5ArA);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: maxWithOrNull-zrEWJaI, reason: not valid java name */
    public static final ULong m5526maxWithOrNullzrEWJaI(@NotNull long[] maxWithOrNull, @NotNull Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(maxWithOrNull, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (ULongArray.m5353isEmptyimpl(maxWithOrNull)) {
            return null;
        }
        long jM5350getsVKNKU = ULongArray.m5350getsVKNKU(maxWithOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(maxWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM5350getsVKNKU2 = ULongArray.m5350getsVKNKU(maxWithOrNull, i);
                if (comparator.compare(ULong.m5336boximpl(jM5350getsVKNKU), ULong.m5336boximpl(jM5350getsVKNKU2)) < 0) {
                    jM5350getsVKNKU = jM5350getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m5336boximpl(jM5350getsVKNKU);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: maxWithOrNull-XMRcp5o, reason: not valid java name */
    public static final UByte m5523maxWithOrNullXMRcp5o(@NotNull byte[] maxWithOrNull, @NotNull Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(maxWithOrNull, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UByteArray.m5303isEmptyimpl(maxWithOrNull)) {
            return null;
        }
        byte bM5300getw2LRezQ = UByteArray.m5300getw2LRezQ(maxWithOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(maxWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM5300getw2LRezQ2 = UByteArray.m5300getw2LRezQ(maxWithOrNull, i);
                if (comparator.compare(UByte.m5286boximpl(bM5300getw2LRezQ), UByte.m5286boximpl(bM5300getw2LRezQ2)) < 0) {
                    bM5300getw2LRezQ = bM5300getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m5286boximpl(bM5300getw2LRezQ);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: maxWithOrNull-eOHTfZs, reason: not valid java name */
    public static final UShort m5525maxWithOrNulleOHTfZs(@NotNull short[] maxWithOrNull, @NotNull Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(maxWithOrNull, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UShortArray.m5378isEmptyimpl(maxWithOrNull)) {
            return null;
        }
        short sM5375getMh2AYeg = UShortArray.m5375getMh2AYeg(maxWithOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(maxWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM5375getMh2AYeg2 = UShortArray.m5375getMh2AYeg(maxWithOrNull, i);
                if (comparator.compare(UShort.m5361boximpl(sM5375getMh2AYeg), UShort.m5361boximpl(sM5375getMh2AYeg2)) < 0) {
                    sM5375getMh2AYeg = sM5375getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m5361boximpl(sM5375getMh2AYeg);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minOrThrow-U")
    /* JADX INFO: renamed from: minOrThrow-U, reason: not valid java name */
    public static final int m5536minOrThrowU(@NotNull int[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        if (UIntArray.m5328isEmptyimpl(min)) {
            throw new NoSuchElementException();
        }
        int iM5325getpVg5ArA = UIntArray.m5325getpVg5ArA(min, 0);
        int lastIndex = ArraysKt.getLastIndex(min);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM5325getpVg5ArA2 = UIntArray.m5325getpVg5ArA(min, i);
                if (Integer.compareUnsigned(iM5325getpVg5ArA, iM5325getpVg5ArA2) > 0) {
                    iM5325getpVg5ArA = iM5325getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return iM5325getpVg5ArA;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minOrThrow-U")
    /* JADX INFO: renamed from: minOrThrow-U, reason: not valid java name */
    public static final long m5537minOrThrowU(@NotNull long[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        if (ULongArray.m5353isEmptyimpl(min)) {
            throw new NoSuchElementException();
        }
        long jM5350getsVKNKU = ULongArray.m5350getsVKNKU(min, 0);
        int lastIndex = ArraysKt.getLastIndex(min);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM5350getsVKNKU2 = ULongArray.m5350getsVKNKU(min, i);
                if (Long.compareUnsigned(jM5350getsVKNKU, jM5350getsVKNKU2) > 0) {
                    jM5350getsVKNKU = jM5350getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return jM5350getsVKNKU;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minOrThrow-U")
    /* JADX INFO: renamed from: minOrThrow-U, reason: not valid java name */
    public static final byte m5535minOrThrowU(@NotNull byte[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        if (UByteArray.m5303isEmptyimpl(min)) {
            throw new NoSuchElementException();
        }
        byte bM5300getw2LRezQ = UByteArray.m5300getw2LRezQ(min, 0);
        int lastIndex = ArraysKt.getLastIndex(min);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM5300getw2LRezQ2 = UByteArray.m5300getw2LRezQ(min, i);
                if (Intrinsics.compare(bM5300getw2LRezQ & 255, bM5300getw2LRezQ2 & 255) > 0) {
                    bM5300getw2LRezQ = bM5300getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return bM5300getw2LRezQ;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minOrThrow-U")
    /* JADX INFO: renamed from: minOrThrow-U, reason: not valid java name */
    public static final short m5538minOrThrowU(@NotNull short[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        if (UShortArray.m5378isEmptyimpl(min)) {
            throw new NoSuchElementException();
        }
        short sM5375getMh2AYeg = UShortArray.m5375getMh2AYeg(min, 0);
        int lastIndex = ArraysKt.getLastIndex(min);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM5375getMh2AYeg2 = UShortArray.m5375getMh2AYeg(min, i);
                if (Intrinsics.compare(sM5375getMh2AYeg & UShort.MAX_VALUE, 65535 & sM5375getMh2AYeg2) > 0) {
                    sM5375getMh2AYeg = sM5375getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return sM5375getMh2AYeg;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: minOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m5531minOrNullajY9A(@NotNull int[] minOrNull) {
        Intrinsics.checkNotNullParameter(minOrNull, "$this$minOrNull");
        if (UIntArray.m5328isEmptyimpl(minOrNull)) {
            return null;
        }
        int iM5325getpVg5ArA = UIntArray.m5325getpVg5ArA(minOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(minOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM5325getpVg5ArA2 = UIntArray.m5325getpVg5ArA(minOrNull, i);
                if (Integer.compareUnsigned(iM5325getpVg5ArA, iM5325getpVg5ArA2) > 0) {
                    iM5325getpVg5ArA = iM5325getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m5311boximpl(iM5325getpVg5ArA);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: minOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m5533minOrNullQwZRm1k(@NotNull long[] minOrNull) {
        Intrinsics.checkNotNullParameter(minOrNull, "$this$minOrNull");
        if (ULongArray.m5353isEmptyimpl(minOrNull)) {
            return null;
        }
        long jM5350getsVKNKU = ULongArray.m5350getsVKNKU(minOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(minOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM5350getsVKNKU2 = ULongArray.m5350getsVKNKU(minOrNull, i);
                if (Long.compareUnsigned(jM5350getsVKNKU, jM5350getsVKNKU2) > 0) {
                    jM5350getsVKNKU = jM5350getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m5336boximpl(jM5350getsVKNKU);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: minOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m5532minOrNullGBYM_sE(@NotNull byte[] minOrNull) {
        Intrinsics.checkNotNullParameter(minOrNull, "$this$minOrNull");
        if (UByteArray.m5303isEmptyimpl(minOrNull)) {
            return null;
        }
        byte bM5300getw2LRezQ = UByteArray.m5300getw2LRezQ(minOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(minOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM5300getw2LRezQ2 = UByteArray.m5300getw2LRezQ(minOrNull, i);
                if (Intrinsics.compare(bM5300getw2LRezQ & 255, bM5300getw2LRezQ2 & 255) > 0) {
                    bM5300getw2LRezQ = bM5300getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m5286boximpl(bM5300getw2LRezQ);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: minOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m5534minOrNullrL5Bavg(@NotNull short[] minOrNull) {
        Intrinsics.checkNotNullParameter(minOrNull, "$this$minOrNull");
        if (UShortArray.m5378isEmptyimpl(minOrNull)) {
            return null;
        }
        short sM5375getMh2AYeg = UShortArray.m5375getMh2AYeg(minOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(minOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM5375getMh2AYeg2 = UShortArray.m5375getMh2AYeg(minOrNull, i);
                if (Intrinsics.compare(sM5375getMh2AYeg & UShort.MAX_VALUE, 65535 & sM5375getMh2AYeg2) > 0) {
                    sM5375getMh2AYeg = sM5375getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m5361boximpl(sM5375getMh2AYeg);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minWithOrThrow-U")
    /* JADX INFO: renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final int m5544minWithOrThrowU(@NotNull int[] minWith, @NotNull Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UIntArray.m5328isEmptyimpl(minWith)) {
            throw new NoSuchElementException();
        }
        int iM5325getpVg5ArA = UIntArray.m5325getpVg5ArA(minWith, 0);
        int lastIndex = ArraysKt.getLastIndex(minWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM5325getpVg5ArA2 = UIntArray.m5325getpVg5ArA(minWith, i);
                if (comparator.compare(UInt.m5311boximpl(iM5325getpVg5ArA), UInt.m5311boximpl(iM5325getpVg5ArA2)) > 0) {
                    iM5325getpVg5ArA = iM5325getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return iM5325getpVg5ArA;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minWithOrThrow-U")
    /* JADX INFO: renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final long m5545minWithOrThrowU(@NotNull long[] minWith, @NotNull Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (ULongArray.m5353isEmptyimpl(minWith)) {
            throw new NoSuchElementException();
        }
        long jM5350getsVKNKU = ULongArray.m5350getsVKNKU(minWith, 0);
        int lastIndex = ArraysKt.getLastIndex(minWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM5350getsVKNKU2 = ULongArray.m5350getsVKNKU(minWith, i);
                if (comparator.compare(ULong.m5336boximpl(jM5350getsVKNKU), ULong.m5336boximpl(jM5350getsVKNKU2)) > 0) {
                    jM5350getsVKNKU = jM5350getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return jM5350getsVKNKU;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minWithOrThrow-U")
    /* JADX INFO: renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final byte m5543minWithOrThrowU(@NotNull byte[] minWith, @NotNull Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UByteArray.m5303isEmptyimpl(minWith)) {
            throw new NoSuchElementException();
        }
        byte bM5300getw2LRezQ = UByteArray.m5300getw2LRezQ(minWith, 0);
        int lastIndex = ArraysKt.getLastIndex(minWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM5300getw2LRezQ2 = UByteArray.m5300getw2LRezQ(minWith, i);
                if (comparator.compare(UByte.m5286boximpl(bM5300getw2LRezQ), UByte.m5286boximpl(bM5300getw2LRezQ2)) > 0) {
                    bM5300getw2LRezQ = bM5300getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return bM5300getw2LRezQ;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minWithOrThrow-U")
    /* JADX INFO: renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final short m5546minWithOrThrowU(@NotNull short[] minWith, @NotNull Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UShortArray.m5378isEmptyimpl(minWith)) {
            throw new NoSuchElementException();
        }
        short sM5375getMh2AYeg = UShortArray.m5375getMh2AYeg(minWith, 0);
        int lastIndex = ArraysKt.getLastIndex(minWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM5375getMh2AYeg2 = UShortArray.m5375getMh2AYeg(minWith, i);
                if (comparator.compare(UShort.m5361boximpl(sM5375getMh2AYeg), UShort.m5361boximpl(sM5375getMh2AYeg2)) > 0) {
                    sM5375getMh2AYeg = sM5375getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return sM5375getMh2AYeg;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: minWithOrNull-YmdZ_VM, reason: not valid java name */
    public static final UInt m5540minWithOrNullYmdZ_VM(@NotNull int[] minWithOrNull, @NotNull Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(minWithOrNull, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UIntArray.m5328isEmptyimpl(minWithOrNull)) {
            return null;
        }
        int iM5325getpVg5ArA = UIntArray.m5325getpVg5ArA(minWithOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(minWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM5325getpVg5ArA2 = UIntArray.m5325getpVg5ArA(minWithOrNull, i);
                if (comparator.compare(UInt.m5311boximpl(iM5325getpVg5ArA), UInt.m5311boximpl(iM5325getpVg5ArA2)) > 0) {
                    iM5325getpVg5ArA = iM5325getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m5311boximpl(iM5325getpVg5ArA);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: minWithOrNull-zrEWJaI, reason: not valid java name */
    public static final ULong m5542minWithOrNullzrEWJaI(@NotNull long[] minWithOrNull, @NotNull Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(minWithOrNull, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (ULongArray.m5353isEmptyimpl(minWithOrNull)) {
            return null;
        }
        long jM5350getsVKNKU = ULongArray.m5350getsVKNKU(minWithOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(minWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM5350getsVKNKU2 = ULongArray.m5350getsVKNKU(minWithOrNull, i);
                if (comparator.compare(ULong.m5336boximpl(jM5350getsVKNKU), ULong.m5336boximpl(jM5350getsVKNKU2)) > 0) {
                    jM5350getsVKNKU = jM5350getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m5336boximpl(jM5350getsVKNKU);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: minWithOrNull-XMRcp5o, reason: not valid java name */
    public static final UByte m5539minWithOrNullXMRcp5o(@NotNull byte[] minWithOrNull, @NotNull Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(minWithOrNull, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UByteArray.m5303isEmptyimpl(minWithOrNull)) {
            return null;
        }
        byte bM5300getw2LRezQ = UByteArray.m5300getw2LRezQ(minWithOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(minWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM5300getw2LRezQ2 = UByteArray.m5300getw2LRezQ(minWithOrNull, i);
                if (comparator.compare(UByte.m5286boximpl(bM5300getw2LRezQ), UByte.m5286boximpl(bM5300getw2LRezQ2)) > 0) {
                    bM5300getw2LRezQ = bM5300getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m5286boximpl(bM5300getw2LRezQ);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* JADX INFO: renamed from: minWithOrNull-eOHTfZs, reason: not valid java name */
    public static final UShort m5541minWithOrNulleOHTfZs(@NotNull short[] minWithOrNull, @NotNull Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(minWithOrNull, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UShortArray.m5378isEmptyimpl(minWithOrNull)) {
            return null;
        }
        short sM5375getMh2AYeg = UShortArray.m5375getMh2AYeg(minWithOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(minWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM5375getMh2AYeg2 = UShortArray.m5375getMh2AYeg(minWithOrNull, i);
                if (comparator.compare(UShort.m5361boximpl(sM5375getMh2AYeg), UShort.m5361boximpl(sM5375getMh2AYeg2)) > 0) {
                    sM5375getMh2AYeg = sM5375getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m5361boximpl(sM5375getMh2AYeg);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: zip-C-E_24M, reason: not valid java name */
    public static final <R> List<Pair<UInt, R>> m5643zipCE_24M(@NotNull int[] zip, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(UIntArray.m5326getSizeimpl(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            int iM5325getpVg5ArA = UIntArray.m5325getpVg5ArA(zip, i);
            arrayList.add(TuplesKt.m1842to(UInt.m5311boximpl(iM5325getpVg5ArA), other[i]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: zip-f7H3mmw, reason: not valid java name */
    public static final <R> List<Pair<ULong, R>> m5649zipf7H3mmw(@NotNull long[] zip, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(ULongArray.m5351getSizeimpl(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            long jM5350getsVKNKU = ULongArray.m5350getsVKNKU(zip, i);
            arrayList.add(TuplesKt.m1842to(ULong.m5336boximpl(jM5350getsVKNKU), other[i]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: zip-nl983wc, reason: not valid java name */
    public static final <R> List<Pair<UByte, R>> m5652zipnl983wc(@NotNull byte[] zip, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(UByteArray.m5301getSizeimpl(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            byte bM5300getw2LRezQ = UByteArray.m5300getw2LRezQ(zip, i);
            arrayList.add(TuplesKt.m1842to(UByte.m5286boximpl(bM5300getw2LRezQ), other[i]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: zip-uaTIQ5s, reason: not valid java name */
    public static final <R> List<Pair<UShort, R>> m5653zipuaTIQ5s(@NotNull short[] zip, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(UShortArray.m5376getSizeimpl(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            short sM5375getMh2AYeg = UShortArray.m5375getMh2AYeg(zip, i);
            arrayList.add(TuplesKt.m1842to(UShort.m5361boximpl(sM5375getMh2AYeg), other[i]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: zip-HwE9HBo, reason: not valid java name */
    public static final <R> List<Pair<UInt, R>> m5645zipHwE9HBo(@NotNull int[] zip, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iM5326getSizeimpl = UIntArray.m5326getSizeimpl(zip);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(other, 10), iM5326getSizeimpl));
        int i = 0;
        for (R r : other) {
            if (i >= iM5326getSizeimpl) {
                break;
            }
            arrayList.add(TuplesKt.m1842to(UInt.m5311boximpl(UIntArray.m5325getpVg5ArA(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: zip-F7u83W8, reason: not valid java name */
    public static final <R> List<Pair<ULong, R>> m5644zipF7u83W8(@NotNull long[] zip, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iM5351getSizeimpl = ULongArray.m5351getSizeimpl(zip);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(other, 10), iM5351getSizeimpl));
        int i = 0;
        for (R r : other) {
            if (i >= iM5351getSizeimpl) {
                break;
            }
            arrayList.add(TuplesKt.m1842to(ULong.m5336boximpl(ULongArray.m5350getsVKNKU(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: zip-JQknh5Q, reason: not valid java name */
    public static final <R> List<Pair<UByte, R>> m5647zipJQknh5Q(@NotNull byte[] zip, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iM5301getSizeimpl = UByteArray.m5301getSizeimpl(zip);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(other, 10), iM5301getSizeimpl));
        int i = 0;
        for (R r : other) {
            if (i >= iM5301getSizeimpl) {
                break;
            }
            arrayList.add(TuplesKt.m1842to(UByte.m5286boximpl(UByteArray.m5300getw2LRezQ(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: zip-JGPC0-M, reason: not valid java name */
    public static final <R> List<Pair<UShort, R>> m5646zipJGPC0M(@NotNull short[] zip, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iM5376getSizeimpl = UShortArray.m5376getSizeimpl(zip);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(other, 10), iM5376getSizeimpl));
        int i = 0;
        for (R r : other) {
            if (i >= iM5376getSizeimpl) {
                break;
            }
            arrayList.add(TuplesKt.m1842to(UShort.m5361boximpl(UShortArray.m5375getMh2AYeg(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: zip-ctEhBpI, reason: not valid java name */
    public static final List<Pair<UInt, UInt>> m5648zipctEhBpI(@NotNull int[] zip, @NotNull int[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(UIntArray.m5326getSizeimpl(zip), UIntArray.m5326getSizeimpl(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(TuplesKt.m1842to(UInt.m5311boximpl(UIntArray.m5325getpVg5ArA(zip, i)), UInt.m5311boximpl(UIntArray.m5325getpVg5ArA(other, i))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: zip-us8wMrg, reason: not valid java name */
    public static final List<Pair<ULong, ULong>> m5654zipus8wMrg(@NotNull long[] zip, @NotNull long[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(ULongArray.m5351getSizeimpl(zip), ULongArray.m5351getSizeimpl(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(TuplesKt.m1842to(ULong.m5336boximpl(ULongArray.m5350getsVKNKU(zip, i)), ULong.m5336boximpl(ULongArray.m5350getsVKNKU(other, i))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: zip-kdPth3s, reason: not valid java name */
    public static final List<Pair<UByte, UByte>> m5650zipkdPth3s(@NotNull byte[] zip, @NotNull byte[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(UByteArray.m5301getSizeimpl(zip), UByteArray.m5301getSizeimpl(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(TuplesKt.m1842to(UByte.m5286boximpl(UByteArray.m5300getw2LRezQ(zip, i)), UByte.m5286boximpl(UByteArray.m5300getw2LRezQ(other, i))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* JADX INFO: renamed from: zip-mazbYpA, reason: not valid java name */
    public static final List<Pair<UShort, UShort>> m5651zipmazbYpA(@NotNull short[] zip, @NotNull short[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(UShortArray.m5376getSizeimpl(zip), UShortArray.m5376getSizeimpl(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(TuplesKt.m1842to(UShort.m5361boximpl(UShortArray.m5375getMh2AYeg(zip, i)), UShort.m5361boximpl(UShortArray.m5375getMh2AYeg(other, i))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUInt")
    public static final int sumOfUInt(@NotNull UInt[] uIntArr) {
        Intrinsics.checkNotNullParameter(uIntArr, "<this>");
        int iM5312constructorimpl = 0;
        for (UInt uInt : uIntArr) {
            iM5312constructorimpl = UInt.m5312constructorimpl(iM5312constructorimpl + uInt.getData());
        }
        return iM5312constructorimpl;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfULong")
    public static final long sumOfULong(@NotNull ULong[] uLongArr) {
        Intrinsics.checkNotNullParameter(uLongArr, "<this>");
        long jM5337constructorimpl = 0;
        for (ULong uLong : uLongArr) {
            jM5337constructorimpl = ULong.m5337constructorimpl(jM5337constructorimpl + uLong.getData());
        }
        return jM5337constructorimpl;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(@NotNull UByte[] uByteArr) {
        Intrinsics.checkNotNullParameter(uByteArr, "<this>");
        int iM5312constructorimpl = 0;
        for (UByte uByte : uByteArr) {
            iM5312constructorimpl = UInt.m5312constructorimpl(iM5312constructorimpl + UInt.m5312constructorimpl(uByte.getData() & 255));
        }
        return iM5312constructorimpl;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUShort")
    public static final int sumOfUShort(@NotNull UShort[] uShortArr) {
        Intrinsics.checkNotNullParameter(uShortArr, "<this>");
        int iM5312constructorimpl = 0;
        for (UShort uShort : uShortArr) {
            iM5312constructorimpl = UInt.m5312constructorimpl(iM5312constructorimpl + UInt.m5312constructorimpl(uShort.getData() & UShort.MAX_VALUE));
        }
        return iM5312constructorimpl;
    }
}
