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
/* loaded from: classes5.dex */
public abstract class UArraysKt___UArraysKt extends UArraysKt___UArraysJvmKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getIndices--ajY-9A$annotations, reason: not valid java name */
    public static /* synthetic */ void m3183getIndicesajY9A$annotations(int[] iArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getIndices-GBYM_sE$annotations, reason: not valid java name */
    public static /* synthetic */ void m3185getIndicesGBYM_sE$annotations(byte[] bArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getIndices-QwZRm1k$annotations, reason: not valid java name */
    public static /* synthetic */ void m3187getIndicesQwZRm1k$annotations(long[] jArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getIndices-rL5Bavg$annotations, reason: not valid java name */
    public static /* synthetic */ void m3189getIndicesrL5Bavg$annotations(short[] sArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getLastIndex--ajY-9A$annotations, reason: not valid java name */
    public static /* synthetic */ void m3191getLastIndexajY9A$annotations(int[] iArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getLastIndex-GBYM_sE$annotations, reason: not valid java name */
    public static /* synthetic */ void m3193getLastIndexGBYM_sE$annotations(byte[] bArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getLastIndex-QwZRm1k$annotations, reason: not valid java name */
    public static /* synthetic */ void m3195getLastIndexQwZRm1k$annotations(long[] jArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: getLastIndex-rL5Bavg$annotations, reason: not valid java name */
    public static /* synthetic */ void m3197getLastIndexrL5Bavg$annotations(short[] sArr) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: firstOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m3178firstOrNullajY9A(@NotNull int[] firstOrNull) {
        Intrinsics.checkNotNullParameter(firstOrNull, "$this$firstOrNull");
        if (UIntArray.m3019isEmptyimpl(firstOrNull)) {
            return null;
        }
        return UInt.m3002boximpl(UIntArray.m3016getpVg5ArA(firstOrNull, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: firstOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m3180firstOrNullQwZRm1k(@NotNull long[] firstOrNull) {
        Intrinsics.checkNotNullParameter(firstOrNull, "$this$firstOrNull");
        if (ULongArray.m3044isEmptyimpl(firstOrNull)) {
            return null;
        }
        return ULong.m3027boximpl(ULongArray.m3041getsVKNKU(firstOrNull, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: firstOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m3179firstOrNullGBYM_sE(@NotNull byte[] firstOrNull) {
        Intrinsics.checkNotNullParameter(firstOrNull, "$this$firstOrNull");
        if (UByteArray.m2994isEmptyimpl(firstOrNull)) {
            return null;
        }
        return UByte.m2977boximpl(UByteArray.m2991getw2LRezQ(firstOrNull, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: firstOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m3181firstOrNullrL5Bavg(@NotNull short[] firstOrNull) {
        Intrinsics.checkNotNullParameter(firstOrNull, "$this$firstOrNull");
        if (UShortArray.m3069isEmptyimpl(firstOrNull)) {
            return null;
        }
        return UShort.m3052boximpl(UShortArray.m3066getMh2AYeg(firstOrNull, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: getOrNull-qFRl0hI, reason: not valid java name */
    public static final UInt m3200getOrNullqFRl0hI(@NotNull int[] getOrNull, int i) {
        Intrinsics.checkNotNullParameter(getOrNull, "$this$getOrNull");
        if (i < 0 || i >= UIntArray.m3017getSizeimpl(getOrNull)) {
            return null;
        }
        return UInt.m3002boximpl(UIntArray.m3016getpVg5ArA(getOrNull, i));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: getOrNull-r7IrZao, reason: not valid java name */
    public static final ULong m3201getOrNullr7IrZao(@NotNull long[] getOrNull, int i) {
        Intrinsics.checkNotNullParameter(getOrNull, "$this$getOrNull");
        if (i < 0 || i >= ULongArray.m3042getSizeimpl(getOrNull)) {
            return null;
        }
        return ULong.m3027boximpl(ULongArray.m3041getsVKNKU(getOrNull, i));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: getOrNull-PpDY95g, reason: not valid java name */
    public static final UByte m3198getOrNullPpDY95g(@NotNull byte[] getOrNull, int i) {
        Intrinsics.checkNotNullParameter(getOrNull, "$this$getOrNull");
        if (i < 0 || i >= UByteArray.m2992getSizeimpl(getOrNull)) {
            return null;
        }
        return UByte.m2977boximpl(UByteArray.m2991getw2LRezQ(getOrNull, i));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: getOrNull-nggk6HY, reason: not valid java name */
    public static final UShort m3199getOrNullnggk6HY(@NotNull short[] getOrNull, int i) {
        Intrinsics.checkNotNullParameter(getOrNull, "$this$getOrNull");
        if (i < 0 || i >= UShortArray.m3067getSizeimpl(getOrNull)) {
            return null;
        }
        return UShort.m3052boximpl(UShortArray.m3066getMh2AYeg(getOrNull, i));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: lastOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m3202lastOrNullajY9A(@NotNull int[] lastOrNull) {
        Intrinsics.checkNotNullParameter(lastOrNull, "$this$lastOrNull");
        if (UIntArray.m3019isEmptyimpl(lastOrNull)) {
            return null;
        }
        return UInt.m3002boximpl(UIntArray.m3016getpVg5ArA(lastOrNull, UIntArray.m3017getSizeimpl(lastOrNull) - 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: lastOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m3204lastOrNullQwZRm1k(@NotNull long[] lastOrNull) {
        Intrinsics.checkNotNullParameter(lastOrNull, "$this$lastOrNull");
        if (ULongArray.m3044isEmptyimpl(lastOrNull)) {
            return null;
        }
        return ULong.m3027boximpl(ULongArray.m3041getsVKNKU(lastOrNull, ULongArray.m3042getSizeimpl(lastOrNull) - 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: lastOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m3203lastOrNullGBYM_sE(@NotNull byte[] lastOrNull) {
        Intrinsics.checkNotNullParameter(lastOrNull, "$this$lastOrNull");
        if (UByteArray.m2994isEmptyimpl(lastOrNull)) {
            return null;
        }
        return UByte.m2977boximpl(UByteArray.m2991getw2LRezQ(lastOrNull, UByteArray.m2992getSizeimpl(lastOrNull) - 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: lastOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m3205lastOrNullrL5Bavg(@NotNull short[] lastOrNull) {
        Intrinsics.checkNotNullParameter(lastOrNull, "$this$lastOrNull");
        if (UShortArray.m3069isEmptyimpl(lastOrNull)) {
            return null;
        }
        return UShort.m3052boximpl(UShortArray.m3066getMh2AYeg(lastOrNull, UShortArray.m3067getSizeimpl(lastOrNull) - 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: random-2D5oskM, reason: not valid java name */
    public static final int m3242random2D5oskM(@NotNull int[] random, @NotNull Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        if (UIntArray.m3019isEmptyimpl(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return UIntArray.m3016getpVg5ArA(random, random2.nextInt(UIntArray.m3017getSizeimpl(random)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: random-JzugnMA, reason: not valid java name */
    public static final long m3243randomJzugnMA(@NotNull long[] random, @NotNull Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        if (ULongArray.m3044isEmptyimpl(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return ULongArray.m3041getsVKNKU(random, random2.nextInt(ULongArray.m3042getSizeimpl(random)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: random-oSF2wD8, reason: not valid java name */
    public static final byte m3244randomoSF2wD8(@NotNull byte[] random, @NotNull Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        if (UByteArray.m2994isEmptyimpl(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return UByteArray.m2991getw2LRezQ(random, random2.nextInt(UByteArray.m2992getSizeimpl(random)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: random-s5X_as8, reason: not valid java name */
    public static final short m3245randoms5X_as8(@NotNull short[] random, @NotNull Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        if (UShortArray.m3069isEmptyimpl(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return UShortArray.m3066getMh2AYeg(random, random2.nextInt(UShortArray.m3067getSizeimpl(random)));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: randomOrNull-2D5oskM, reason: not valid java name */
    public static final UInt m3246randomOrNull2D5oskM(@NotNull int[] randomOrNull, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (UIntArray.m3019isEmptyimpl(randomOrNull)) {
            return null;
        }
        return UInt.m3002boximpl(UIntArray.m3016getpVg5ArA(randomOrNull, random.nextInt(UIntArray.m3017getSizeimpl(randomOrNull))));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: randomOrNull-JzugnMA, reason: not valid java name */
    public static final ULong m3247randomOrNullJzugnMA(@NotNull long[] randomOrNull, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (ULongArray.m3044isEmptyimpl(randomOrNull)) {
            return null;
        }
        return ULong.m3027boximpl(ULongArray.m3041getsVKNKU(randomOrNull, random.nextInt(ULongArray.m3042getSizeimpl(randomOrNull))));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: randomOrNull-oSF2wD8, reason: not valid java name */
    public static final UByte m3248randomOrNulloSF2wD8(@NotNull byte[] randomOrNull, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (UByteArray.m2994isEmptyimpl(randomOrNull)) {
            return null;
        }
        return UByte.m2977boximpl(UByteArray.m2991getw2LRezQ(randomOrNull, random.nextInt(UByteArray.m2992getSizeimpl(randomOrNull))));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: randomOrNull-s5X_as8, reason: not valid java name */
    public static final UShort m3249randomOrNulls5X_as8(@NotNull short[] randomOrNull, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (UShortArray.m3069isEmptyimpl(randomOrNull)) {
            return null;
        }
        return UShort.m3052boximpl(UShortArray.m3066getMh2AYeg(randomOrNull, random.nextInt(UShortArray.m3067getSizeimpl(randomOrNull))));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: singleOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m3262singleOrNullajY9A(@NotNull int[] singleOrNull) {
        Intrinsics.checkNotNullParameter(singleOrNull, "$this$singleOrNull");
        if (UIntArray.m3017getSizeimpl(singleOrNull) == 1) {
            return UInt.m3002boximpl(UIntArray.m3016getpVg5ArA(singleOrNull, 0));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: singleOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m3264singleOrNullQwZRm1k(@NotNull long[] singleOrNull) {
        Intrinsics.checkNotNullParameter(singleOrNull, "$this$singleOrNull");
        if (ULongArray.m3042getSizeimpl(singleOrNull) == 1) {
            return ULong.m3027boximpl(ULongArray.m3041getsVKNKU(singleOrNull, 0));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: singleOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m3263singleOrNullGBYM_sE(@NotNull byte[] singleOrNull) {
        Intrinsics.checkNotNullParameter(singleOrNull, "$this$singleOrNull");
        if (UByteArray.m2992getSizeimpl(singleOrNull) == 1) {
            return UByte.m2977boximpl(UByteArray.m2991getw2LRezQ(singleOrNull, 0));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: singleOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m3265singleOrNullrL5Bavg(@NotNull short[] singleOrNull) {
        Intrinsics.checkNotNullParameter(singleOrNull, "$this$singleOrNull");
        if (UShortArray.m3067getSizeimpl(singleOrNull) == 1) {
            return UShort.m3052boximpl(UShortArray.m3066getMh2AYeg(singleOrNull, 0));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: drop-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m3164dropqFRl0hI(@NotNull int[] drop, int i) {
        Intrinsics.checkNotNullParameter(drop, "$this$drop");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m3324takeLastqFRl0hI(drop, RangesKt.coerceAtLeast(UIntArray.m3017getSizeimpl(drop) - i, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: drop-r7IrZao, reason: not valid java name */
    public static final List<ULong> m3165dropr7IrZao(@NotNull long[] drop, int i) {
        Intrinsics.checkNotNullParameter(drop, "$this$drop");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m3325takeLastr7IrZao(drop, RangesKt.coerceAtLeast(ULongArray.m3042getSizeimpl(drop) - i, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: drop-PpDY95g, reason: not valid java name */
    public static final List<UByte> m3162dropPpDY95g(@NotNull byte[] drop, int i) {
        Intrinsics.checkNotNullParameter(drop, "$this$drop");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m3322takeLastPpDY95g(drop, RangesKt.coerceAtLeast(UByteArray.m2992getSizeimpl(drop) - i, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: drop-nggk6HY, reason: not valid java name */
    public static final List<UShort> m3163dropnggk6HY(@NotNull short[] drop, int i) {
        Intrinsics.checkNotNullParameter(drop, "$this$drop");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m3323takeLastnggk6HY(drop, RangesKt.coerceAtLeast(UShortArray.m3067getSizeimpl(drop) - i, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: dropLast-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m3168dropLastqFRl0hI(@NotNull int[] dropLast, int i) {
        Intrinsics.checkNotNullParameter(dropLast, "$this$dropLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m3320takeqFRl0hI(dropLast, RangesKt.coerceAtLeast(UIntArray.m3017getSizeimpl(dropLast) - i, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: dropLast-r7IrZao, reason: not valid java name */
    public static final List<ULong> m3169dropLastr7IrZao(@NotNull long[] dropLast, int i) {
        Intrinsics.checkNotNullParameter(dropLast, "$this$dropLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m3321taker7IrZao(dropLast, RangesKt.coerceAtLeast(ULongArray.m3042getSizeimpl(dropLast) - i, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: dropLast-PpDY95g, reason: not valid java name */
    public static final List<UByte> m3166dropLastPpDY95g(@NotNull byte[] dropLast, int i) {
        Intrinsics.checkNotNullParameter(dropLast, "$this$dropLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m3318takePpDY95g(dropLast, RangesKt.coerceAtLeast(UByteArray.m2992getSizeimpl(dropLast) - i, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: dropLast-nggk6HY, reason: not valid java name */
    public static final List<UShort> m3167dropLastnggk6HY(@NotNull short[] dropLast, int i) {
        Intrinsics.checkNotNullParameter(dropLast, "$this$dropLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        return m3319takenggk6HY(dropLast, RangesKt.coerceAtLeast(UShortArray.m3067getSizeimpl(dropLast) - i, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-tAntMlw, reason: not valid java name */
    public static final List<UInt> m3273slicetAntMlw(@NotNull int[] slice, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt.emptyList() : UArraysKt___UArraysJvmKt.m3106asListajY9A(UIntArray.m3011constructorimpl(ArraysKt.copyOfRange(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-ZRhS8yI, reason: not valid java name */
    public static final List<ULong> m3271sliceZRhS8yI(@NotNull long[] slice, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt.emptyList() : UArraysKt___UArraysJvmKt.m3108asListQwZRm1k(ULongArray.m3036constructorimpl(ArraysKt.copyOfRange(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-c0bezYM, reason: not valid java name */
    public static final List<UByte> m3272slicec0bezYM(@NotNull byte[] slice, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt.emptyList() : UArraysKt___UArraysJvmKt.m3107asListGBYM_sE(UByteArray.m2986constructorimpl(ArraysKt.copyOfRange(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-Q6IL4kU, reason: not valid java name */
    public static final List<UShort> m3270sliceQ6IL4kU(@NotNull short[] slice, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt.emptyList() : UArraysKt___UArraysJvmKt.m3109asListrL5Bavg(UShortArray.m3061constructorimpl(ArraysKt.copyOfRange(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-HwE9HBo, reason: not valid java name */
    public static final List<UInt> m3267sliceHwE9HBo(@NotNull int[] slice, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(UInt.m3002boximpl(UIntArray.m3016getpVg5ArA(slice, it.next().intValue())));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-F7u83W8, reason: not valid java name */
    public static final List<ULong> m3266sliceF7u83W8(@NotNull long[] slice, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(ULong.m3027boximpl(ULongArray.m3041getsVKNKU(slice, it.next().intValue())));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-JQknh5Q, reason: not valid java name */
    public static final List<UByte> m3269sliceJQknh5Q(@NotNull byte[] slice, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(UByte.m2977boximpl(UByteArray.m2991getw2LRezQ(slice, it.next().intValue())));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: slice-JGPC0-M, reason: not valid java name */
    public static final List<UShort> m3268sliceJGPC0M(@NotNull short[] slice, @NotNull Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(slice, "$this$slice");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int iCollectionSizeOrDefault = CollectionsKt.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(UShort.m3052boximpl(UShortArray.m3066getMh2AYeg(slice, it.next().intValue())));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-CFIt9YE, reason: not valid java name */
    public static final int[] m3274sliceArrayCFIt9YE(@NotNull int[] sliceArray, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UIntArray.m3011constructorimpl(ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-kzHmqpY, reason: not valid java name */
    public static final long[] m3278sliceArraykzHmqpY(@NotNull long[] sliceArray, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return ULongArray.m3036constructorimpl(ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-xo_DsdI, reason: not valid java name */
    public static final byte[] m3281sliceArrayxo_DsdI(@NotNull byte[] sliceArray, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UByteArray.m2986constructorimpl(ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-ojwP5H8, reason: not valid java name */
    public static final short[] m3279sliceArrayojwP5H8(@NotNull short[] sliceArray, @NotNull Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UShortArray.m3061constructorimpl(ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-tAntMlw, reason: not valid java name */
    public static final int[] m3280sliceArraytAntMlw(@NotNull int[] sliceArray, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UIntArray.m3011constructorimpl(ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-ZRhS8yI, reason: not valid java name */
    public static final long[] m3276sliceArrayZRhS8yI(@NotNull long[] sliceArray, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return ULongArray.m3036constructorimpl(ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-c0bezYM, reason: not valid java name */
    public static final byte[] m3277sliceArrayc0bezYM(@NotNull byte[] sliceArray, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UByteArray.m2986constructorimpl(ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sliceArray-Q6IL4kU, reason: not valid java name */
    public static final short[] m3275sliceArrayQ6IL4kU(@NotNull short[] sliceArray, @NotNull IntRange indices) {
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return UShortArray.m3061constructorimpl(ArraysKt.sliceArray(sliceArray, indices));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: take-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m3320takeqFRl0hI(@NotNull int[] take, int i) {
        Intrinsics.checkNotNullParameter(take, "$this$take");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        if (i >= UIntArray.m3017getSizeimpl(take)) {
            return CollectionsKt.toList(UIntArray.m3009boximpl(take));
        }
        if (i == 1) {
            return CollectionsKt.listOf(UInt.m3002boximpl(UIntArray.m3016getpVg5ArA(take, 0)));
        }
        ArrayList arrayList = new ArrayList(i);
        int iM3017getSizeimpl = UIntArray.m3017getSizeimpl(take);
        int i2 = 0;
        for (int i3 = 0; i3 < iM3017getSizeimpl; i3++) {
            arrayList.add(UInt.m3002boximpl(UIntArray.m3016getpVg5ArA(take, i3)));
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
    /* renamed from: take-r7IrZao, reason: not valid java name */
    public static final List<ULong> m3321taker7IrZao(@NotNull long[] take, int i) {
        Intrinsics.checkNotNullParameter(take, "$this$take");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        if (i >= ULongArray.m3042getSizeimpl(take)) {
            return CollectionsKt.toList(ULongArray.m3034boximpl(take));
        }
        if (i == 1) {
            return CollectionsKt.listOf(ULong.m3027boximpl(ULongArray.m3041getsVKNKU(take, 0)));
        }
        ArrayList arrayList = new ArrayList(i);
        int iM3042getSizeimpl = ULongArray.m3042getSizeimpl(take);
        int i2 = 0;
        for (int i3 = 0; i3 < iM3042getSizeimpl; i3++) {
            arrayList.add(ULong.m3027boximpl(ULongArray.m3041getsVKNKU(take, i3)));
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
    /* renamed from: take-PpDY95g, reason: not valid java name */
    public static final List<UByte> m3318takePpDY95g(@NotNull byte[] take, int i) {
        Intrinsics.checkNotNullParameter(take, "$this$take");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        if (i >= UByteArray.m2992getSizeimpl(take)) {
            return CollectionsKt.toList(UByteArray.m2984boximpl(take));
        }
        if (i == 1) {
            return CollectionsKt.listOf(UByte.m2977boximpl(UByteArray.m2991getw2LRezQ(take, 0)));
        }
        ArrayList arrayList = new ArrayList(i);
        int iM2992getSizeimpl = UByteArray.m2992getSizeimpl(take);
        int i2 = 0;
        for (int i3 = 0; i3 < iM2992getSizeimpl; i3++) {
            arrayList.add(UByte.m2977boximpl(UByteArray.m2991getw2LRezQ(take, i3)));
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
    /* renamed from: take-nggk6HY, reason: not valid java name */
    public static final List<UShort> m3319takenggk6HY(@NotNull short[] take, int i) {
        Intrinsics.checkNotNullParameter(take, "$this$take");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        if (i >= UShortArray.m3067getSizeimpl(take)) {
            return CollectionsKt.toList(UShortArray.m3059boximpl(take));
        }
        if (i == 1) {
            return CollectionsKt.listOf(UShort.m3052boximpl(UShortArray.m3066getMh2AYeg(take, 0)));
        }
        ArrayList arrayList = new ArrayList(i);
        int iM3067getSizeimpl = UShortArray.m3067getSizeimpl(take);
        int i2 = 0;
        for (int i3 = 0; i3 < iM3067getSizeimpl; i3++) {
            arrayList.add(UShort.m3052boximpl(UShortArray.m3066getMh2AYeg(take, i3)));
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
    /* renamed from: takeLast-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m3324takeLastqFRl0hI(@NotNull int[] takeLast, int i) {
        Intrinsics.checkNotNullParameter(takeLast, "$this$takeLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        int iM3017getSizeimpl = UIntArray.m3017getSizeimpl(takeLast);
        if (i >= iM3017getSizeimpl) {
            return CollectionsKt.toList(UIntArray.m3009boximpl(takeLast));
        }
        if (i == 1) {
            return CollectionsKt.listOf(UInt.m3002boximpl(UIntArray.m3016getpVg5ArA(takeLast, iM3017getSizeimpl - 1)));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = iM3017getSizeimpl - i; i2 < iM3017getSizeimpl; i2++) {
            arrayList.add(UInt.m3002boximpl(UIntArray.m3016getpVg5ArA(takeLast, i2)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: takeLast-r7IrZao, reason: not valid java name */
    public static final List<ULong> m3325takeLastr7IrZao(@NotNull long[] takeLast, int i) {
        Intrinsics.checkNotNullParameter(takeLast, "$this$takeLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        int iM3042getSizeimpl = ULongArray.m3042getSizeimpl(takeLast);
        if (i >= iM3042getSizeimpl) {
            return CollectionsKt.toList(ULongArray.m3034boximpl(takeLast));
        }
        if (i == 1) {
            return CollectionsKt.listOf(ULong.m3027boximpl(ULongArray.m3041getsVKNKU(takeLast, iM3042getSizeimpl - 1)));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = iM3042getSizeimpl - i; i2 < iM3042getSizeimpl; i2++) {
            arrayList.add(ULong.m3027boximpl(ULongArray.m3041getsVKNKU(takeLast, i2)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: takeLast-PpDY95g, reason: not valid java name */
    public static final List<UByte> m3322takeLastPpDY95g(@NotNull byte[] takeLast, int i) {
        Intrinsics.checkNotNullParameter(takeLast, "$this$takeLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        int iM2992getSizeimpl = UByteArray.m2992getSizeimpl(takeLast);
        if (i >= iM2992getSizeimpl) {
            return CollectionsKt.toList(UByteArray.m2984boximpl(takeLast));
        }
        if (i == 1) {
            return CollectionsKt.listOf(UByte.m2977boximpl(UByteArray.m2991getw2LRezQ(takeLast, iM2992getSizeimpl - 1)));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = iM2992getSizeimpl - i; i2 < iM2992getSizeimpl; i2++) {
            arrayList.add(UByte.m2977boximpl(UByteArray.m2991getw2LRezQ(takeLast, i2)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: takeLast-nggk6HY, reason: not valid java name */
    public static final List<UShort> m3323takeLastnggk6HY(@NotNull short[] takeLast, int i) {
        Intrinsics.checkNotNullParameter(takeLast, "$this$takeLast");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        int iM3067getSizeimpl = UShortArray.m3067getSizeimpl(takeLast);
        if (i >= iM3067getSizeimpl) {
            return CollectionsKt.toList(UShortArray.m3059boximpl(takeLast));
        }
        if (i == 1) {
            return CollectionsKt.listOf(UShort.m3052boximpl(UShortArray.m3066getMh2AYeg(takeLast, iM3067getSizeimpl - 1)));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = iM3067getSizeimpl - i; i2 < iM3067getSizeimpl; i2++) {
            arrayList.add(UShort.m3052boximpl(UShortArray.m3066getMh2AYeg(takeLast, i2)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: reversed--ajY-9A, reason: not valid java name */
    public static final List<UInt> m3250reversedajY9A(@NotNull int[] reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        if (UIntArray.m3019isEmptyimpl(reversed)) {
            return CollectionsKt.emptyList();
        }
        List<UInt> mutableList = CollectionsKt.toMutableList((Collection) UIntArray.m3009boximpl(reversed));
        CollectionsKt.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: reversed-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m3252reversedQwZRm1k(@NotNull long[] reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        if (ULongArray.m3044isEmptyimpl(reversed)) {
            return CollectionsKt.emptyList();
        }
        List<ULong> mutableList = CollectionsKt.toMutableList((Collection) ULongArray.m3034boximpl(reversed));
        CollectionsKt.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: reversed-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m3251reversedGBYM_sE(@NotNull byte[] reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        if (UByteArray.m2994isEmptyimpl(reversed)) {
            return CollectionsKt.emptyList();
        }
        List<UByte> mutableList = CollectionsKt.toMutableList((Collection) UByteArray.m2984boximpl(reversed));
        CollectionsKt.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: reversed-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m3253reversedrL5Bavg(@NotNull short[] reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        if (UShortArray.m3069isEmptyimpl(reversed)) {
            return CollectionsKt.emptyList();
        }
        List<UShort> mutableList = CollectionsKt.toMutableList((Collection) UShortArray.m3059boximpl(reversed));
        CollectionsKt.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle--ajY-9A, reason: not valid java name */
    public static final void m3254shuffleajY9A(@NotNull int[] shuffle) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        m3255shuffle2D5oskM(shuffle, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle-QwZRm1k, reason: not valid java name */
    public static final void m3258shuffleQwZRm1k(@NotNull long[] shuffle) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        m3257shuffleJzugnMA(shuffle, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle-GBYM_sE, reason: not valid java name */
    public static final void m3256shuffleGBYM_sE(@NotNull byte[] shuffle) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        m3259shuffleoSF2wD8(shuffle, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle-rL5Bavg, reason: not valid java name */
    public static final void m3260shufflerL5Bavg(@NotNull short[] shuffle) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        m3261shuffles5X_as8(shuffle, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending--ajY-9A, reason: not valid java name */
    public static final void m3294sortDescendingajY9A(@NotNull int[] sortDescending) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        if (UIntArray.m3017getSizeimpl(sortDescending) > 1) {
            m3282sortajY9A(sortDescending);
            ArraysKt.reverse(sortDescending);
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending-QwZRm1k, reason: not valid java name */
    public static final void m3299sortDescendingQwZRm1k(@NotNull long[] sortDescending) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        if (ULongArray.m3042getSizeimpl(sortDescending) > 1) {
            m3290sortQwZRm1k(sortDescending);
            ArraysKt.reverse(sortDescending);
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending-GBYM_sE, reason: not valid java name */
    public static final void m3298sortDescendingGBYM_sE(@NotNull byte[] sortDescending) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        if (UByteArray.m2992getSizeimpl(sortDescending) > 1) {
            m3289sortGBYM_sE(sortDescending);
            ArraysKt.reverse(sortDescending);
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending-rL5Bavg, reason: not valid java name */
    public static final void m3301sortDescendingrL5Bavg(@NotNull short[] sortDescending) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        if (UShortArray.m3067getSizeimpl(sortDescending) > 1) {
            m3293sortrL5Bavg(sortDescending);
            ArraysKt.reverse(sortDescending);
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sorted--ajY-9A, reason: not valid java name */
    public static final List<UInt> m3302sortedajY9A(@NotNull int[] sorted) {
        Intrinsics.checkNotNullParameter(sorted, "$this$sorted");
        int[] iArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        int[] iArrM3011constructorimpl = UIntArray.m3011constructorimpl(iArrCopyOf);
        m3282sortajY9A(iArrM3011constructorimpl);
        return UArraysKt___UArraysJvmKt.m3106asListajY9A(iArrM3011constructorimpl);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sorted-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m3304sortedQwZRm1k(@NotNull long[] sorted) {
        Intrinsics.checkNotNullParameter(sorted, "$this$sorted");
        long[] jArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        long[] jArrM3036constructorimpl = ULongArray.m3036constructorimpl(jArrCopyOf);
        m3290sortQwZRm1k(jArrM3036constructorimpl);
        return UArraysKt___UArraysJvmKt.m3108asListQwZRm1k(jArrM3036constructorimpl);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sorted-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m3303sortedGBYM_sE(@NotNull byte[] sorted) {
        Intrinsics.checkNotNullParameter(sorted, "$this$sorted");
        byte[] bArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        byte[] bArrM2986constructorimpl = UByteArray.m2986constructorimpl(bArrCopyOf);
        m3289sortGBYM_sE(bArrM2986constructorimpl);
        return UArraysKt___UArraysJvmKt.m3107asListGBYM_sE(bArrM2986constructorimpl);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sorted-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m3305sortedrL5Bavg(@NotNull short[] sorted) {
        Intrinsics.checkNotNullParameter(sorted, "$this$sorted");
        short[] sArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        short[] sArrM3061constructorimpl = UShortArray.m3061constructorimpl(sArrCopyOf);
        m3293sortrL5Bavg(sArrM3061constructorimpl);
        return UArraysKt___UArraysJvmKt.m3109asListrL5Bavg(sArrM3061constructorimpl);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArray--ajY-9A, reason: not valid java name */
    public static final int[] m3306sortedArrayajY9A(@NotNull int[] sortedArray) {
        Intrinsics.checkNotNullParameter(sortedArray, "$this$sortedArray");
        if (UIntArray.m3019isEmptyimpl(sortedArray)) {
            return sortedArray;
        }
        int[] iArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        int[] iArrM3011constructorimpl = UIntArray.m3011constructorimpl(iArrCopyOf);
        m3282sortajY9A(iArrM3011constructorimpl);
        return iArrM3011constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArray-QwZRm1k, reason: not valid java name */
    public static final long[] m3308sortedArrayQwZRm1k(@NotNull long[] sortedArray) {
        Intrinsics.checkNotNullParameter(sortedArray, "$this$sortedArray");
        if (ULongArray.m3044isEmptyimpl(sortedArray)) {
            return sortedArray;
        }
        long[] jArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        long[] jArrM3036constructorimpl = ULongArray.m3036constructorimpl(jArrCopyOf);
        m3290sortQwZRm1k(jArrM3036constructorimpl);
        return jArrM3036constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArray-GBYM_sE, reason: not valid java name */
    public static final byte[] m3307sortedArrayGBYM_sE(@NotNull byte[] sortedArray) {
        Intrinsics.checkNotNullParameter(sortedArray, "$this$sortedArray");
        if (UByteArray.m2994isEmptyimpl(sortedArray)) {
            return sortedArray;
        }
        byte[] bArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        byte[] bArrM2986constructorimpl = UByteArray.m2986constructorimpl(bArrCopyOf);
        m3289sortGBYM_sE(bArrM2986constructorimpl);
        return bArrM2986constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArray-rL5Bavg, reason: not valid java name */
    public static final short[] m3309sortedArrayrL5Bavg(@NotNull short[] sortedArray) {
        Intrinsics.checkNotNullParameter(sortedArray, "$this$sortedArray");
        if (UShortArray.m3069isEmptyimpl(sortedArray)) {
            return sortedArray;
        }
        short[] sArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        short[] sArrM3061constructorimpl = UShortArray.m3061constructorimpl(sArrCopyOf);
        m3293sortrL5Bavg(sArrM3061constructorimpl);
        return sArrM3061constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArrayDescending--ajY-9A, reason: not valid java name */
    public static final int[] m3310sortedArrayDescendingajY9A(@NotNull int[] sortedArrayDescending) {
        Intrinsics.checkNotNullParameter(sortedArrayDescending, "$this$sortedArrayDescending");
        if (UIntArray.m3019isEmptyimpl(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        int[] iArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        int[] iArrM3011constructorimpl = UIntArray.m3011constructorimpl(iArrCopyOf);
        m3294sortDescendingajY9A(iArrM3011constructorimpl);
        return iArrM3011constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArrayDescending-QwZRm1k, reason: not valid java name */
    public static final long[] m3312sortedArrayDescendingQwZRm1k(@NotNull long[] sortedArrayDescending) {
        Intrinsics.checkNotNullParameter(sortedArrayDescending, "$this$sortedArrayDescending");
        if (ULongArray.m3044isEmptyimpl(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        long[] jArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        long[] jArrM3036constructorimpl = ULongArray.m3036constructorimpl(jArrCopyOf);
        m3299sortDescendingQwZRm1k(jArrM3036constructorimpl);
        return jArrM3036constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArrayDescending-GBYM_sE, reason: not valid java name */
    public static final byte[] m3311sortedArrayDescendingGBYM_sE(@NotNull byte[] sortedArrayDescending) {
        Intrinsics.checkNotNullParameter(sortedArrayDescending, "$this$sortedArrayDescending");
        if (UByteArray.m2994isEmptyimpl(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        byte[] bArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        byte[] bArrM2986constructorimpl = UByteArray.m2986constructorimpl(bArrCopyOf);
        m3298sortDescendingGBYM_sE(bArrM2986constructorimpl);
        return bArrM2986constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedArrayDescending-rL5Bavg, reason: not valid java name */
    public static final short[] m3313sortedArrayDescendingrL5Bavg(@NotNull short[] sortedArrayDescending) {
        Intrinsics.checkNotNullParameter(sortedArrayDescending, "$this$sortedArrayDescending");
        if (UShortArray.m3069isEmptyimpl(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        short[] sArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        short[] sArrM3061constructorimpl = UShortArray.m3061constructorimpl(sArrCopyOf);
        m3301sortDescendingrL5Bavg(sArrM3061constructorimpl);
        return sArrM3061constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedDescending--ajY-9A, reason: not valid java name */
    public static final List<UInt> m3314sortedDescendingajY9A(@NotNull int[] sortedDescending) {
        Intrinsics.checkNotNullParameter(sortedDescending, "$this$sortedDescending");
        int[] iArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        int[] iArrM3011constructorimpl = UIntArray.m3011constructorimpl(iArrCopyOf);
        m3282sortajY9A(iArrM3011constructorimpl);
        return m3250reversedajY9A(iArrM3011constructorimpl);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedDescending-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m3316sortedDescendingQwZRm1k(@NotNull long[] sortedDescending) {
        Intrinsics.checkNotNullParameter(sortedDescending, "$this$sortedDescending");
        long[] jArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        long[] jArrM3036constructorimpl = ULongArray.m3036constructorimpl(jArrCopyOf);
        m3290sortQwZRm1k(jArrM3036constructorimpl);
        return m3252reversedQwZRm1k(jArrM3036constructorimpl);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedDescending-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m3315sortedDescendingGBYM_sE(@NotNull byte[] sortedDescending) {
        Intrinsics.checkNotNullParameter(sortedDescending, "$this$sortedDescending");
        byte[] bArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        byte[] bArrM2986constructorimpl = UByteArray.m2986constructorimpl(bArrCopyOf);
        m3289sortGBYM_sE(bArrM2986constructorimpl);
        return m3251reversedGBYM_sE(bArrM2986constructorimpl);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: sortedDescending-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m3317sortedDescendingrL5Bavg(@NotNull short[] sortedDescending) {
        Intrinsics.checkNotNullParameter(sortedDescending, "$this$sortedDescending");
        short[] sArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        short[] sArrM3061constructorimpl = UShortArray.m3061constructorimpl(sArrCopyOf);
        m3293sortrL5Bavg(sArrM3061constructorimpl);
        return m3253reversedrL5Bavg(sArrM3061constructorimpl);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: contentEquals-KJPZfPQ, reason: not valid java name */
    public static boolean m3151contentEqualsKJPZfPQ(@Nullable int[] iArr, @Nullable int[] iArr2) {
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
    /* renamed from: contentEquals-lec5QzE, reason: not valid java name */
    public static boolean m3153contentEqualslec5QzE(@Nullable long[] jArr, @Nullable long[] jArr2) {
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
    /* renamed from: contentEquals-kV0jMPg, reason: not valid java name */
    public static boolean m3152contentEqualskV0jMPg(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
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
    /* renamed from: contentEquals-FGO6Aew, reason: not valid java name */
    public static boolean m3150contentEqualsFGO6Aew(@Nullable short[] sArr, @Nullable short[] sArr2) {
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
    /* renamed from: contentHashCode-XUkPCBk, reason: not valid java name */
    public static final int m3155contentHashCodeXUkPCBk(@Nullable int[] iArr) {
        if (iArr == null) {
            iArr = null;
        }
        return Arrays.hashCode(iArr);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode-uLth9ew, reason: not valid java name */
    public static final int m3157contentHashCodeuLth9ew(@Nullable long[] jArr) {
        if (jArr == null) {
            jArr = null;
        }
        return Arrays.hashCode(jArr);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode-2csIQuQ, reason: not valid java name */
    public static final int m3154contentHashCode2csIQuQ(@Nullable byte[] bArr) {
        if (bArr == null) {
            bArr = null;
        }
        return Arrays.hashCode(bArr);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode-d-6D3K8, reason: not valid java name */
    public static final int m3156contentHashCoded6D3K8(@Nullable short[] sArr) {
        if (sArr == null) {
            sArr = null;
        }
        return Arrays.hashCode(sArr);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: contentToString-XUkPCBk, reason: not valid java name */
    public static String m3159contentToStringXUkPCBk(@Nullable int[] iArr) {
        String strJoinToString$default;
        return (iArr == null || (strJoinToString$default = CollectionsKt.joinToString$default(UIntArray.m3009boximpl(iArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strJoinToString$default;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: contentToString-uLth9ew, reason: not valid java name */
    public static String m3161contentToStringuLth9ew(@Nullable long[] jArr) {
        String strJoinToString$default;
        return (jArr == null || (strJoinToString$default = CollectionsKt.joinToString$default(ULongArray.m3034boximpl(jArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strJoinToString$default;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: contentToString-2csIQuQ, reason: not valid java name */
    public static String m3158contentToString2csIQuQ(@Nullable byte[] bArr) {
        String strJoinToString$default;
        return (bArr == null || (strJoinToString$default = CollectionsKt.joinToString$default(UByteArray.m2984boximpl(bArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strJoinToString$default;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: contentToString-d-6D3K8, reason: not valid java name */
    public static String m3160contentToStringd6D3K8(@Nullable short[] sArr) {
        String strJoinToString$default;
        return (sArr == null || (strJoinToString$default = CollectionsKt.joinToString$default(UShortArray.m3059boximpl(sArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strJoinToString$default;
    }

    /* renamed from: fill-2fe2U9s$default, reason: not valid java name */
    public static /* synthetic */ void m3171fill2fe2U9s$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UIntArray.m3017getSizeimpl(iArr);
        }
        m3170fill2fe2U9s(iArr, i, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: fill-2fe2U9s, reason: not valid java name */
    public static final void m3170fill2fe2U9s(@NotNull int[] fill, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        ArraysKt.fill(fill, i, i2, i3);
    }

    /* renamed from: fill-K6DWlUc$default, reason: not valid java name */
    public static /* synthetic */ void m3175fillK6DWlUc$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m3042getSizeimpl(jArr);
        }
        m3174fillK6DWlUc(jArr, j, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: fill-K6DWlUc, reason: not valid java name */
    public static final void m3174fillK6DWlUc(@NotNull long[] fill, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        ArraysKt.fill(fill, j, i, i2);
    }

    /* renamed from: fill-WpHrYlw$default, reason: not valid java name */
    public static /* synthetic */ void m3177fillWpHrYlw$default(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m2992getSizeimpl(bArr);
        }
        m3176fillWpHrYlw(bArr, b, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: fill-WpHrYlw, reason: not valid java name */
    public static final void m3176fillWpHrYlw(@NotNull byte[] fill, byte b, int i, int i2) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        ArraysKt.fill(fill, b, i, i2);
    }

    /* renamed from: fill-EtDCXyQ$default, reason: not valid java name */
    public static /* synthetic */ void m3173fillEtDCXyQ$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m3067getSizeimpl(sArr);
        }
        m3172fillEtDCXyQ(sArr, s, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: fill-EtDCXyQ, reason: not valid java name */
    public static final void m3172fillEtDCXyQ(@NotNull short[] fill, short s, int i, int i2) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        ArraysKt.fill(fill, s, i, i2);
    }

    @NotNull
    /* renamed from: getIndices--ajY-9A, reason: not valid java name */
    public static final IntRange m3182getIndicesajY9A(@NotNull int[] indices) {
        Intrinsics.checkNotNullParameter(indices, "$this$indices");
        return ArraysKt.getIndices(indices);
    }

    @NotNull
    /* renamed from: getIndices-QwZRm1k, reason: not valid java name */
    public static final IntRange m3186getIndicesQwZRm1k(@NotNull long[] indices) {
        Intrinsics.checkNotNullParameter(indices, "$this$indices");
        return ArraysKt.getIndices(indices);
    }

    @NotNull
    /* renamed from: getIndices-GBYM_sE, reason: not valid java name */
    public static final IntRange m3184getIndicesGBYM_sE(@NotNull byte[] indices) {
        Intrinsics.checkNotNullParameter(indices, "$this$indices");
        return ArraysKt.getIndices(indices);
    }

    @NotNull
    /* renamed from: getIndices-rL5Bavg, reason: not valid java name */
    public static final IntRange m3188getIndicesrL5Bavg(@NotNull short[] indices) {
        Intrinsics.checkNotNullParameter(indices, "$this$indices");
        return ArraysKt.getIndices(indices);
    }

    /* renamed from: getLastIndex--ajY-9A, reason: not valid java name */
    public static final int m3190getLastIndexajY9A(@NotNull int[] lastIndex) {
        Intrinsics.checkNotNullParameter(lastIndex, "$this$lastIndex");
        return ArraysKt.getLastIndex(lastIndex);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle-2D5oskM, reason: not valid java name */
    public static final void m3255shuffle2D5oskM(@NotNull int[] shuffle, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt.getLastIndex(shuffle); lastIndex > 0; lastIndex--) {
            int iNextInt = random.nextInt(lastIndex + 1);
            int iM3016getpVg5ArA = UIntArray.m3016getpVg5ArA(shuffle, lastIndex);
            UIntArray.m3021setVXSXFK8(shuffle, lastIndex, UIntArray.m3016getpVg5ArA(shuffle, iNextInt));
            UIntArray.m3021setVXSXFK8(shuffle, iNextInt, iM3016getpVg5ArA);
        }
    }

    /* renamed from: getLastIndex-QwZRm1k, reason: not valid java name */
    public static final int m3194getLastIndexQwZRm1k(@NotNull long[] lastIndex) {
        Intrinsics.checkNotNullParameter(lastIndex, "$this$lastIndex");
        return ArraysKt.getLastIndex(lastIndex);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle-JzugnMA, reason: not valid java name */
    public static final void m3257shuffleJzugnMA(@NotNull long[] shuffle, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt.getLastIndex(shuffle); lastIndex > 0; lastIndex--) {
            int iNextInt = random.nextInt(lastIndex + 1);
            long jM3041getsVKNKU = ULongArray.m3041getsVKNKU(shuffle, lastIndex);
            ULongArray.m3046setk8EXiF4(shuffle, lastIndex, ULongArray.m3041getsVKNKU(shuffle, iNextInt));
            ULongArray.m3046setk8EXiF4(shuffle, iNextInt, jM3041getsVKNKU);
        }
    }

    /* renamed from: getLastIndex-GBYM_sE, reason: not valid java name */
    public static final int m3192getLastIndexGBYM_sE(@NotNull byte[] lastIndex) {
        Intrinsics.checkNotNullParameter(lastIndex, "$this$lastIndex");
        return ArraysKt.getLastIndex(lastIndex);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle-oSF2wD8, reason: not valid java name */
    public static final void m3259shuffleoSF2wD8(@NotNull byte[] shuffle, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt.getLastIndex(shuffle); lastIndex > 0; lastIndex--) {
            int iNextInt = random.nextInt(lastIndex + 1);
            byte bM2991getw2LRezQ = UByteArray.m2991getw2LRezQ(shuffle, lastIndex);
            UByteArray.m2996setVurrAj0(shuffle, lastIndex, UByteArray.m2991getw2LRezQ(shuffle, iNextInt));
            UByteArray.m2996setVurrAj0(shuffle, iNextInt, bM2991getw2LRezQ);
        }
    }

    /* renamed from: getLastIndex-rL5Bavg, reason: not valid java name */
    public static final int m3196getLastIndexrL5Bavg(@NotNull short[] lastIndex) {
        Intrinsics.checkNotNullParameter(lastIndex, "$this$lastIndex");
        return ArraysKt.getLastIndex(lastIndex);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: shuffle-s5X_as8, reason: not valid java name */
    public static final void m3261shuffles5X_as8(@NotNull short[] shuffle, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(shuffle, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = ArraysKt.getLastIndex(shuffle); lastIndex > 0; lastIndex--) {
            int iNextInt = random.nextInt(lastIndex + 1);
            short sM3066getMh2AYeg = UShortArray.m3066getMh2AYeg(shuffle, lastIndex);
            UShortArray.m3071set01HTLdE(shuffle, lastIndex, UShortArray.m3066getMh2AYeg(shuffle, iNextInt));
            UShortArray.m3071set01HTLdE(shuffle, iNextInt, sM3066getMh2AYeg);
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: plus-CFIt9YE, reason: not valid java name */
    public static final int[] m3238plusCFIt9YE(@NotNull int[] plus, @NotNull Collection<UInt> elements) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int iM3017getSizeimpl = UIntArray.m3017getSizeimpl(plus);
        int[] iArrCopyOf = Arrays.copyOf(plus, UIntArray.m3017getSizeimpl(plus) + elements.size());
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        Iterator<UInt> it = elements.iterator();
        while (it.hasNext()) {
            iArrCopyOf[iM3017getSizeimpl] = it.next().getData();
            iM3017getSizeimpl++;
        }
        return UIntArray.m3011constructorimpl(iArrCopyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: plus-kzHmqpY, reason: not valid java name */
    public static final long[] m3239pluskzHmqpY(@NotNull long[] plus, @NotNull Collection<ULong> elements) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int iM3042getSizeimpl = ULongArray.m3042getSizeimpl(plus);
        long[] jArrCopyOf = Arrays.copyOf(plus, ULongArray.m3042getSizeimpl(plus) + elements.size());
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        Iterator<ULong> it = elements.iterator();
        while (it.hasNext()) {
            jArrCopyOf[iM3042getSizeimpl] = it.next().getData();
            iM3042getSizeimpl++;
        }
        return ULongArray.m3036constructorimpl(jArrCopyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: plus-xo_DsdI, reason: not valid java name */
    public static final byte[] m3241plusxo_DsdI(@NotNull byte[] plus, @NotNull Collection<UByte> elements) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int iM2992getSizeimpl = UByteArray.m2992getSizeimpl(plus);
        byte[] bArrCopyOf = Arrays.copyOf(plus, UByteArray.m2992getSizeimpl(plus) + elements.size());
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        Iterator<UByte> it = elements.iterator();
        while (it.hasNext()) {
            bArrCopyOf[iM2992getSizeimpl] = it.next().getData();
            iM2992getSizeimpl++;
        }
        return UByteArray.m2986constructorimpl(bArrCopyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: plus-ojwP5H8, reason: not valid java name */
    public static final short[] m3240plusojwP5H8(@NotNull short[] plus, @NotNull Collection<UShort> elements) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int iM3067getSizeimpl = UShortArray.m3067getSizeimpl(plus);
        short[] sArrCopyOf = Arrays.copyOf(plus, UShortArray.m3067getSizeimpl(plus) + elements.size());
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        Iterator<UShort> it = elements.iterator();
        while (it.hasNext()) {
            sArrCopyOf[iM3067getSizeimpl] = it.next().getData();
            iM3067getSizeimpl++;
        }
        return UShortArray.m3061constructorimpl(sArrCopyOf);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sort--ajY-9A, reason: not valid java name */
    public static final void m3282sortajY9A(@NotNull int[] sort) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        if (UIntArray.m3017getSizeimpl(sort) > 1) {
            UArraySortingKt.m3104sortArrayoBK06Vg(sort, 0, UIntArray.m3017getSizeimpl(sort));
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sort-QwZRm1k, reason: not valid java name */
    public static final void m3290sortQwZRm1k(@NotNull long[] sort) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        if (ULongArray.m3042getSizeimpl(sort) > 1) {
            UArraySortingKt.m3101sortArraynroSd4(sort, 0, ULongArray.m3042getSizeimpl(sort));
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sort-GBYM_sE, reason: not valid java name */
    public static final void m3289sortGBYM_sE(@NotNull byte[] sort) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        if (UByteArray.m2992getSizeimpl(sort) > 1) {
            UArraySortingKt.m3102sortArray4UcCI2c(sort, 0, UByteArray.m2992getSizeimpl(sort));
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: sort-rL5Bavg, reason: not valid java name */
    public static final void m3293sortrL5Bavg(@NotNull short[] sort) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        if (UShortArray.m3067getSizeimpl(sort) > 1) {
            UArraySortingKt.m3103sortArrayAa5vz7o(sort, 0, UShortArray.m3067getSizeimpl(sort));
        }
    }

    /* renamed from: sort-oBK06Vg$default, reason: not valid java name */
    public static /* synthetic */ void m3292sortoBK06Vg$default(int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = UIntArray.m3017getSizeimpl(iArr);
        }
        m3291sortoBK06Vg(iArr, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sort-oBK06Vg, reason: not valid java name */
    public static final void m3291sortoBK06Vg(@NotNull int[] sort, int i, int i2) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, UIntArray.m3017getSizeimpl(sort));
        UArraySortingKt.m3104sortArrayoBK06Vg(sort, i, i2);
    }

    /* renamed from: sort--nroSd4$default, reason: not valid java name */
    public static /* synthetic */ void m3284sortnroSd4$default(long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = ULongArray.m3042getSizeimpl(jArr);
        }
        m3283sortnroSd4(jArr, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sort--nroSd4, reason: not valid java name */
    public static final void m3283sortnroSd4(@NotNull long[] sort, int i, int i2) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, ULongArray.m3042getSizeimpl(sort));
        UArraySortingKt.m3101sortArraynroSd4(sort, i, i2);
    }

    /* renamed from: sort-4UcCI2c$default, reason: not valid java name */
    public static /* synthetic */ void m3286sort4UcCI2c$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = UByteArray.m2992getSizeimpl(bArr);
        }
        m3285sort4UcCI2c(bArr, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sort-4UcCI2c, reason: not valid java name */
    public static final void m3285sort4UcCI2c(@NotNull byte[] sort, int i, int i2) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, UByteArray.m2992getSizeimpl(sort));
        UArraySortingKt.m3102sortArray4UcCI2c(sort, i, i2);
    }

    /* renamed from: sort-Aa5vz7o$default, reason: not valid java name */
    public static /* synthetic */ void m3288sortAa5vz7o$default(short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = UShortArray.m3067getSizeimpl(sArr);
        }
        m3287sortAa5vz7o(sArr, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sort-Aa5vz7o, reason: not valid java name */
    public static final void m3287sortAa5vz7o(@NotNull short[] sort, int i, int i2) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(i, i2, UShortArray.m3067getSizeimpl(sort));
        UArraySortingKt.m3103sortArrayAa5vz7o(sort, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending-oBK06Vg, reason: not valid java name */
    public static final void m3300sortDescendingoBK06Vg(@NotNull int[] sortDescending, int i, int i2) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        m3291sortoBK06Vg(sortDescending, i, i2);
        ArraysKt.reverse(sortDescending, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending--nroSd4, reason: not valid java name */
    public static final void m3295sortDescendingnroSd4(@NotNull long[] sortDescending, int i, int i2) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        m3283sortnroSd4(sortDescending, i, i2);
        ArraysKt.reverse(sortDescending, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending-4UcCI2c, reason: not valid java name */
    public static final void m3296sortDescending4UcCI2c(@NotNull byte[] sortDescending, int i, int i2) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        m3285sort4UcCI2c(sortDescending, i, i2);
        ArraysKt.reverse(sortDescending, i, i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: sortDescending-Aa5vz7o, reason: not valid java name */
    public static final void m3297sortDescendingAa5vz7o(@NotNull short[] sortDescending, int i, int i2) {
        Intrinsics.checkNotNullParameter(sortDescending, "$this$sortDescending");
        m3287sortAa5vz7o(sortDescending, i, i2);
        ArraysKt.reverse(sortDescending, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: toTypedArray--ajY-9A, reason: not valid java name */
    public static final UInt[] m3326toTypedArrayajY9A(@NotNull int[] toTypedArray) {
        Intrinsics.checkNotNullParameter(toTypedArray, "$this$toTypedArray");
        int iM3017getSizeimpl = UIntArray.m3017getSizeimpl(toTypedArray);
        UInt[] uIntArr = new UInt[iM3017getSizeimpl];
        for (int i = 0; i < iM3017getSizeimpl; i++) {
            uIntArr[i] = UInt.m3002boximpl(UIntArray.m3016getpVg5ArA(toTypedArray, i));
        }
        return uIntArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: toTypedArray-QwZRm1k, reason: not valid java name */
    public static final ULong[] m3328toTypedArrayQwZRm1k(@NotNull long[] toTypedArray) {
        Intrinsics.checkNotNullParameter(toTypedArray, "$this$toTypedArray");
        int iM3042getSizeimpl = ULongArray.m3042getSizeimpl(toTypedArray);
        ULong[] uLongArr = new ULong[iM3042getSizeimpl];
        for (int i = 0; i < iM3042getSizeimpl; i++) {
            uLongArr[i] = ULong.m3027boximpl(ULongArray.m3041getsVKNKU(toTypedArray, i));
        }
        return uLongArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: toTypedArray-GBYM_sE, reason: not valid java name */
    public static final UByte[] m3327toTypedArrayGBYM_sE(@NotNull byte[] toTypedArray) {
        Intrinsics.checkNotNullParameter(toTypedArray, "$this$toTypedArray");
        int iM2992getSizeimpl = UByteArray.m2992getSizeimpl(toTypedArray);
        UByte[] uByteArr = new UByte[iM2992getSizeimpl];
        for (int i = 0; i < iM2992getSizeimpl; i++) {
            uByteArr[i] = UByte.m2977boximpl(UByteArray.m2991getw2LRezQ(toTypedArray, i));
        }
        return uByteArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: toTypedArray-rL5Bavg, reason: not valid java name */
    public static final UShort[] m3329toTypedArrayrL5Bavg(@NotNull short[] toTypedArray) {
        Intrinsics.checkNotNullParameter(toTypedArray, "$this$toTypedArray");
        int iM3067getSizeimpl = UShortArray.m3067getSizeimpl(toTypedArray);
        UShort[] uShortArr = new UShort[iM3067getSizeimpl];
        for (int i = 0; i < iM3067getSizeimpl; i++) {
            uShortArr[i] = UShort.m3052boximpl(UShortArray.m3066getMh2AYeg(toTypedArray, i));
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
        return UByteArray.m2986constructorimpl(bArr);
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
        return UIntArray.m3011constructorimpl(iArr);
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
        return ULongArray.m3036constructorimpl(jArr);
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
        return UShortArray.m3061constructorimpl(sArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: withIndex--ajY-9A, reason: not valid java name */
    public static final Iterable<IndexedValue<UInt>> m3330withIndexajY9A(@NotNull final int[] withIndex) {
        Intrinsics.checkNotNullParameter(withIndex, "$this$withIndex");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.unsigned.UArraysKt___UArraysKt$withIndex$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Iterator invoke() {
                return UIntArray.m3020iteratorimpl(withIndex);
            }
        });
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: withIndex-QwZRm1k, reason: not valid java name */
    public static final Iterable<IndexedValue<ULong>> m3332withIndexQwZRm1k(@NotNull final long[] withIndex) {
        Intrinsics.checkNotNullParameter(withIndex, "$this$withIndex");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.unsigned.UArraysKt___UArraysKt$withIndex$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Iterator invoke() {
                return ULongArray.m3045iteratorimpl(withIndex);
            }
        });
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: withIndex-GBYM_sE, reason: not valid java name */
    public static final Iterable<IndexedValue<UByte>> m3331withIndexGBYM_sE(@NotNull final byte[] withIndex) {
        Intrinsics.checkNotNullParameter(withIndex, "$this$withIndex");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.unsigned.UArraysKt___UArraysKt$withIndex$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Iterator invoke() {
                return UByteArray.m2995iteratorimpl(withIndex);
            }
        });
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: withIndex-rL5Bavg, reason: not valid java name */
    public static final Iterable<IndexedValue<UShort>> m3333withIndexrL5Bavg(@NotNull final short[] withIndex) {
        Intrinsics.checkNotNullParameter(withIndex, "$this$withIndex");
        return new IndexingIterable(new Function0() { // from class: kotlin.collections.unsigned.UArraysKt___UArraysKt$withIndex$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Iterator invoke() {
                return UShortArray.m3070iteratorimpl(withIndex);
            }
        });
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxOrThrow-U")
    /* renamed from: maxOrThrow-U, reason: not valid java name */
    public static final int m3211maxOrThrowU(@NotNull int[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        if (UIntArray.m3019isEmptyimpl(max)) {
            throw new NoSuchElementException();
        }
        int iM3016getpVg5ArA = UIntArray.m3016getpVg5ArA(max, 0);
        int lastIndex = ArraysKt.getLastIndex(max);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM3016getpVg5ArA2 = UIntArray.m3016getpVg5ArA(max, i);
                if (Integer.compareUnsigned(iM3016getpVg5ArA, iM3016getpVg5ArA2) < 0) {
                    iM3016getpVg5ArA = iM3016getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return iM3016getpVg5ArA;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxOrThrow-U")
    /* renamed from: maxOrThrow-U, reason: not valid java name */
    public static final long m3212maxOrThrowU(@NotNull long[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        if (ULongArray.m3044isEmptyimpl(max)) {
            throw new NoSuchElementException();
        }
        long jM3041getsVKNKU = ULongArray.m3041getsVKNKU(max, 0);
        int lastIndex = ArraysKt.getLastIndex(max);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM3041getsVKNKU2 = ULongArray.m3041getsVKNKU(max, i);
                if (Long.compareUnsigned(jM3041getsVKNKU, jM3041getsVKNKU2) < 0) {
                    jM3041getsVKNKU = jM3041getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return jM3041getsVKNKU;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxOrThrow-U")
    /* renamed from: maxOrThrow-U, reason: not valid java name */
    public static final byte m3210maxOrThrowU(@NotNull byte[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        if (UByteArray.m2994isEmptyimpl(max)) {
            throw new NoSuchElementException();
        }
        byte bM2991getw2LRezQ = UByteArray.m2991getw2LRezQ(max, 0);
        int lastIndex = ArraysKt.getLastIndex(max);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM2991getw2LRezQ2 = UByteArray.m2991getw2LRezQ(max, i);
                if (Intrinsics.compare(bM2991getw2LRezQ & 255, bM2991getw2LRezQ2 & 255) < 0) {
                    bM2991getw2LRezQ = bM2991getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return bM2991getw2LRezQ;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxOrThrow-U")
    /* renamed from: maxOrThrow-U, reason: not valid java name */
    public static final short m3213maxOrThrowU(@NotNull short[] max) {
        Intrinsics.checkNotNullParameter(max, "$this$max");
        if (UShortArray.m3069isEmptyimpl(max)) {
            throw new NoSuchElementException();
        }
        short sM3066getMh2AYeg = UShortArray.m3066getMh2AYeg(max, 0);
        int lastIndex = ArraysKt.getLastIndex(max);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM3066getMh2AYeg2 = UShortArray.m3066getMh2AYeg(max, i);
                if (Intrinsics.compare(sM3066getMh2AYeg & UShort.MAX_VALUE, 65535 & sM3066getMh2AYeg2) < 0) {
                    sM3066getMh2AYeg = sM3066getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return sM3066getMh2AYeg;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m3206maxOrNullajY9A(@NotNull int[] maxOrNull) {
        Intrinsics.checkNotNullParameter(maxOrNull, "$this$maxOrNull");
        if (UIntArray.m3019isEmptyimpl(maxOrNull)) {
            return null;
        }
        int iM3016getpVg5ArA = UIntArray.m3016getpVg5ArA(maxOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(maxOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM3016getpVg5ArA2 = UIntArray.m3016getpVg5ArA(maxOrNull, i);
                if (Integer.compareUnsigned(iM3016getpVg5ArA, iM3016getpVg5ArA2) < 0) {
                    iM3016getpVg5ArA = iM3016getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m3002boximpl(iM3016getpVg5ArA);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m3208maxOrNullQwZRm1k(@NotNull long[] maxOrNull) {
        Intrinsics.checkNotNullParameter(maxOrNull, "$this$maxOrNull");
        if (ULongArray.m3044isEmptyimpl(maxOrNull)) {
            return null;
        }
        long jM3041getsVKNKU = ULongArray.m3041getsVKNKU(maxOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(maxOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM3041getsVKNKU2 = ULongArray.m3041getsVKNKU(maxOrNull, i);
                if (Long.compareUnsigned(jM3041getsVKNKU, jM3041getsVKNKU2) < 0) {
                    jM3041getsVKNKU = jM3041getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m3027boximpl(jM3041getsVKNKU);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m3207maxOrNullGBYM_sE(@NotNull byte[] maxOrNull) {
        Intrinsics.checkNotNullParameter(maxOrNull, "$this$maxOrNull");
        if (UByteArray.m2994isEmptyimpl(maxOrNull)) {
            return null;
        }
        byte bM2991getw2LRezQ = UByteArray.m2991getw2LRezQ(maxOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(maxOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM2991getw2LRezQ2 = UByteArray.m2991getw2LRezQ(maxOrNull, i);
                if (Intrinsics.compare(bM2991getw2LRezQ & 255, bM2991getw2LRezQ2 & 255) < 0) {
                    bM2991getw2LRezQ = bM2991getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m2977boximpl(bM2991getw2LRezQ);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m3209maxOrNullrL5Bavg(@NotNull short[] maxOrNull) {
        Intrinsics.checkNotNullParameter(maxOrNull, "$this$maxOrNull");
        if (UShortArray.m3069isEmptyimpl(maxOrNull)) {
            return null;
        }
        short sM3066getMh2AYeg = UShortArray.m3066getMh2AYeg(maxOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(maxOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM3066getMh2AYeg2 = UShortArray.m3066getMh2AYeg(maxOrNull, i);
                if (Intrinsics.compare(sM3066getMh2AYeg & UShort.MAX_VALUE, 65535 & sM3066getMh2AYeg2) < 0) {
                    sM3066getMh2AYeg = sM3066getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m3052boximpl(sM3066getMh2AYeg);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxWithOrThrow-U")
    /* renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final int m3219maxWithOrThrowU(@NotNull int[] maxWith, @NotNull Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UIntArray.m3019isEmptyimpl(maxWith)) {
            throw new NoSuchElementException();
        }
        int iM3016getpVg5ArA = UIntArray.m3016getpVg5ArA(maxWith, 0);
        int lastIndex = ArraysKt.getLastIndex(maxWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM3016getpVg5ArA2 = UIntArray.m3016getpVg5ArA(maxWith, i);
                if (comparator.compare(UInt.m3002boximpl(iM3016getpVg5ArA), UInt.m3002boximpl(iM3016getpVg5ArA2)) < 0) {
                    iM3016getpVg5ArA = iM3016getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return iM3016getpVg5ArA;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxWithOrThrow-U")
    /* renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final long m3220maxWithOrThrowU(@NotNull long[] maxWith, @NotNull Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (ULongArray.m3044isEmptyimpl(maxWith)) {
            throw new NoSuchElementException();
        }
        long jM3041getsVKNKU = ULongArray.m3041getsVKNKU(maxWith, 0);
        int lastIndex = ArraysKt.getLastIndex(maxWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM3041getsVKNKU2 = ULongArray.m3041getsVKNKU(maxWith, i);
                if (comparator.compare(ULong.m3027boximpl(jM3041getsVKNKU), ULong.m3027boximpl(jM3041getsVKNKU2)) < 0) {
                    jM3041getsVKNKU = jM3041getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return jM3041getsVKNKU;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxWithOrThrow-U")
    /* renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final byte m3218maxWithOrThrowU(@NotNull byte[] maxWith, @NotNull Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UByteArray.m2994isEmptyimpl(maxWith)) {
            throw new NoSuchElementException();
        }
        byte bM2991getw2LRezQ = UByteArray.m2991getw2LRezQ(maxWith, 0);
        int lastIndex = ArraysKt.getLastIndex(maxWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM2991getw2LRezQ2 = UByteArray.m2991getw2LRezQ(maxWith, i);
                if (comparator.compare(UByte.m2977boximpl(bM2991getw2LRezQ), UByte.m2977boximpl(bM2991getw2LRezQ2)) < 0) {
                    bM2991getw2LRezQ = bM2991getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return bM2991getw2LRezQ;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxWithOrThrow-U")
    /* renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final short m3221maxWithOrThrowU(@NotNull short[] maxWith, @NotNull Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(maxWith, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UShortArray.m3069isEmptyimpl(maxWith)) {
            throw new NoSuchElementException();
        }
        short sM3066getMh2AYeg = UShortArray.m3066getMh2AYeg(maxWith, 0);
        int lastIndex = ArraysKt.getLastIndex(maxWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM3066getMh2AYeg2 = UShortArray.m3066getMh2AYeg(maxWith, i);
                if (comparator.compare(UShort.m3052boximpl(sM3066getMh2AYeg), UShort.m3052boximpl(sM3066getMh2AYeg2)) < 0) {
                    sM3066getMh2AYeg = sM3066getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return sM3066getMh2AYeg;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxWithOrNull-YmdZ_VM, reason: not valid java name */
    public static final UInt m3215maxWithOrNullYmdZ_VM(@NotNull int[] maxWithOrNull, @NotNull Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(maxWithOrNull, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UIntArray.m3019isEmptyimpl(maxWithOrNull)) {
            return null;
        }
        int iM3016getpVg5ArA = UIntArray.m3016getpVg5ArA(maxWithOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(maxWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM3016getpVg5ArA2 = UIntArray.m3016getpVg5ArA(maxWithOrNull, i);
                if (comparator.compare(UInt.m3002boximpl(iM3016getpVg5ArA), UInt.m3002boximpl(iM3016getpVg5ArA2)) < 0) {
                    iM3016getpVg5ArA = iM3016getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m3002boximpl(iM3016getpVg5ArA);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxWithOrNull-zrEWJaI, reason: not valid java name */
    public static final ULong m3217maxWithOrNullzrEWJaI(@NotNull long[] maxWithOrNull, @NotNull Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(maxWithOrNull, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (ULongArray.m3044isEmptyimpl(maxWithOrNull)) {
            return null;
        }
        long jM3041getsVKNKU = ULongArray.m3041getsVKNKU(maxWithOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(maxWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM3041getsVKNKU2 = ULongArray.m3041getsVKNKU(maxWithOrNull, i);
                if (comparator.compare(ULong.m3027boximpl(jM3041getsVKNKU), ULong.m3027boximpl(jM3041getsVKNKU2)) < 0) {
                    jM3041getsVKNKU = jM3041getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m3027boximpl(jM3041getsVKNKU);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxWithOrNull-XMRcp5o, reason: not valid java name */
    public static final UByte m3214maxWithOrNullXMRcp5o(@NotNull byte[] maxWithOrNull, @NotNull Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(maxWithOrNull, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UByteArray.m2994isEmptyimpl(maxWithOrNull)) {
            return null;
        }
        byte bM2991getw2LRezQ = UByteArray.m2991getw2LRezQ(maxWithOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(maxWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM2991getw2LRezQ2 = UByteArray.m2991getw2LRezQ(maxWithOrNull, i);
                if (comparator.compare(UByte.m2977boximpl(bM2991getw2LRezQ), UByte.m2977boximpl(bM2991getw2LRezQ2)) < 0) {
                    bM2991getw2LRezQ = bM2991getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m2977boximpl(bM2991getw2LRezQ);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: maxWithOrNull-eOHTfZs, reason: not valid java name */
    public static final UShort m3216maxWithOrNulleOHTfZs(@NotNull short[] maxWithOrNull, @NotNull Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(maxWithOrNull, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UShortArray.m3069isEmptyimpl(maxWithOrNull)) {
            return null;
        }
        short sM3066getMh2AYeg = UShortArray.m3066getMh2AYeg(maxWithOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(maxWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM3066getMh2AYeg2 = UShortArray.m3066getMh2AYeg(maxWithOrNull, i);
                if (comparator.compare(UShort.m3052boximpl(sM3066getMh2AYeg), UShort.m3052boximpl(sM3066getMh2AYeg2)) < 0) {
                    sM3066getMh2AYeg = sM3066getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m3052boximpl(sM3066getMh2AYeg);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minOrThrow-U")
    /* renamed from: minOrThrow-U, reason: not valid java name */
    public static final int m3227minOrThrowU(@NotNull int[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        if (UIntArray.m3019isEmptyimpl(min)) {
            throw new NoSuchElementException();
        }
        int iM3016getpVg5ArA = UIntArray.m3016getpVg5ArA(min, 0);
        int lastIndex = ArraysKt.getLastIndex(min);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM3016getpVg5ArA2 = UIntArray.m3016getpVg5ArA(min, i);
                if (Integer.compareUnsigned(iM3016getpVg5ArA, iM3016getpVg5ArA2) > 0) {
                    iM3016getpVg5ArA = iM3016getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return iM3016getpVg5ArA;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minOrThrow-U")
    /* renamed from: minOrThrow-U, reason: not valid java name */
    public static final long m3228minOrThrowU(@NotNull long[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        if (ULongArray.m3044isEmptyimpl(min)) {
            throw new NoSuchElementException();
        }
        long jM3041getsVKNKU = ULongArray.m3041getsVKNKU(min, 0);
        int lastIndex = ArraysKt.getLastIndex(min);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM3041getsVKNKU2 = ULongArray.m3041getsVKNKU(min, i);
                if (Long.compareUnsigned(jM3041getsVKNKU, jM3041getsVKNKU2) > 0) {
                    jM3041getsVKNKU = jM3041getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return jM3041getsVKNKU;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minOrThrow-U")
    /* renamed from: minOrThrow-U, reason: not valid java name */
    public static final byte m3226minOrThrowU(@NotNull byte[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        if (UByteArray.m2994isEmptyimpl(min)) {
            throw new NoSuchElementException();
        }
        byte bM2991getw2LRezQ = UByteArray.m2991getw2LRezQ(min, 0);
        int lastIndex = ArraysKt.getLastIndex(min);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM2991getw2LRezQ2 = UByteArray.m2991getw2LRezQ(min, i);
                if (Intrinsics.compare(bM2991getw2LRezQ & 255, bM2991getw2LRezQ2 & 255) > 0) {
                    bM2991getw2LRezQ = bM2991getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return bM2991getw2LRezQ;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minOrThrow-U")
    /* renamed from: minOrThrow-U, reason: not valid java name */
    public static final short m3229minOrThrowU(@NotNull short[] min) {
        Intrinsics.checkNotNullParameter(min, "$this$min");
        if (UShortArray.m3069isEmptyimpl(min)) {
            throw new NoSuchElementException();
        }
        short sM3066getMh2AYeg = UShortArray.m3066getMh2AYeg(min, 0);
        int lastIndex = ArraysKt.getLastIndex(min);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM3066getMh2AYeg2 = UShortArray.m3066getMh2AYeg(min, i);
                if (Intrinsics.compare(sM3066getMh2AYeg & UShort.MAX_VALUE, 65535 & sM3066getMh2AYeg2) > 0) {
                    sM3066getMh2AYeg = sM3066getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return sM3066getMh2AYeg;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m3222minOrNullajY9A(@NotNull int[] minOrNull) {
        Intrinsics.checkNotNullParameter(minOrNull, "$this$minOrNull");
        if (UIntArray.m3019isEmptyimpl(minOrNull)) {
            return null;
        }
        int iM3016getpVg5ArA = UIntArray.m3016getpVg5ArA(minOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(minOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM3016getpVg5ArA2 = UIntArray.m3016getpVg5ArA(minOrNull, i);
                if (Integer.compareUnsigned(iM3016getpVg5ArA, iM3016getpVg5ArA2) > 0) {
                    iM3016getpVg5ArA = iM3016getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m3002boximpl(iM3016getpVg5ArA);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m3224minOrNullQwZRm1k(@NotNull long[] minOrNull) {
        Intrinsics.checkNotNullParameter(minOrNull, "$this$minOrNull");
        if (ULongArray.m3044isEmptyimpl(minOrNull)) {
            return null;
        }
        long jM3041getsVKNKU = ULongArray.m3041getsVKNKU(minOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(minOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM3041getsVKNKU2 = ULongArray.m3041getsVKNKU(minOrNull, i);
                if (Long.compareUnsigned(jM3041getsVKNKU, jM3041getsVKNKU2) > 0) {
                    jM3041getsVKNKU = jM3041getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m3027boximpl(jM3041getsVKNKU);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m3223minOrNullGBYM_sE(@NotNull byte[] minOrNull) {
        Intrinsics.checkNotNullParameter(minOrNull, "$this$minOrNull");
        if (UByteArray.m2994isEmptyimpl(minOrNull)) {
            return null;
        }
        byte bM2991getw2LRezQ = UByteArray.m2991getw2LRezQ(minOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(minOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM2991getw2LRezQ2 = UByteArray.m2991getw2LRezQ(minOrNull, i);
                if (Intrinsics.compare(bM2991getw2LRezQ & 255, bM2991getw2LRezQ2 & 255) > 0) {
                    bM2991getw2LRezQ = bM2991getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m2977boximpl(bM2991getw2LRezQ);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m3225minOrNullrL5Bavg(@NotNull short[] minOrNull) {
        Intrinsics.checkNotNullParameter(minOrNull, "$this$minOrNull");
        if (UShortArray.m3069isEmptyimpl(minOrNull)) {
            return null;
        }
        short sM3066getMh2AYeg = UShortArray.m3066getMh2AYeg(minOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(minOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM3066getMh2AYeg2 = UShortArray.m3066getMh2AYeg(minOrNull, i);
                if (Intrinsics.compare(sM3066getMh2AYeg & UShort.MAX_VALUE, 65535 & sM3066getMh2AYeg2) > 0) {
                    sM3066getMh2AYeg = sM3066getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m3052boximpl(sM3066getMh2AYeg);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minWithOrThrow-U")
    /* renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final int m3235minWithOrThrowU(@NotNull int[] minWith, @NotNull Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UIntArray.m3019isEmptyimpl(minWith)) {
            throw new NoSuchElementException();
        }
        int iM3016getpVg5ArA = UIntArray.m3016getpVg5ArA(minWith, 0);
        int lastIndex = ArraysKt.getLastIndex(minWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM3016getpVg5ArA2 = UIntArray.m3016getpVg5ArA(minWith, i);
                if (comparator.compare(UInt.m3002boximpl(iM3016getpVg5ArA), UInt.m3002boximpl(iM3016getpVg5ArA2)) > 0) {
                    iM3016getpVg5ArA = iM3016getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return iM3016getpVg5ArA;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minWithOrThrow-U")
    /* renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final long m3236minWithOrThrowU(@NotNull long[] minWith, @NotNull Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (ULongArray.m3044isEmptyimpl(minWith)) {
            throw new NoSuchElementException();
        }
        long jM3041getsVKNKU = ULongArray.m3041getsVKNKU(minWith, 0);
        int lastIndex = ArraysKt.getLastIndex(minWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM3041getsVKNKU2 = ULongArray.m3041getsVKNKU(minWith, i);
                if (comparator.compare(ULong.m3027boximpl(jM3041getsVKNKU), ULong.m3027boximpl(jM3041getsVKNKU2)) > 0) {
                    jM3041getsVKNKU = jM3041getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return jM3041getsVKNKU;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minWithOrThrow-U")
    /* renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final byte m3234minWithOrThrowU(@NotNull byte[] minWith, @NotNull Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UByteArray.m2994isEmptyimpl(minWith)) {
            throw new NoSuchElementException();
        }
        byte bM2991getw2LRezQ = UByteArray.m2991getw2LRezQ(minWith, 0);
        int lastIndex = ArraysKt.getLastIndex(minWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM2991getw2LRezQ2 = UByteArray.m2991getw2LRezQ(minWith, i);
                if (comparator.compare(UByte.m2977boximpl(bM2991getw2LRezQ), UByte.m2977boximpl(bM2991getw2LRezQ2)) > 0) {
                    bM2991getw2LRezQ = bM2991getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return bM2991getw2LRezQ;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minWithOrThrow-U")
    /* renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final short m3237minWithOrThrowU(@NotNull short[] minWith, @NotNull Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UShortArray.m3069isEmptyimpl(minWith)) {
            throw new NoSuchElementException();
        }
        short sM3066getMh2AYeg = UShortArray.m3066getMh2AYeg(minWith, 0);
        int lastIndex = ArraysKt.getLastIndex(minWith);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM3066getMh2AYeg2 = UShortArray.m3066getMh2AYeg(minWith, i);
                if (comparator.compare(UShort.m3052boximpl(sM3066getMh2AYeg), UShort.m3052boximpl(sM3066getMh2AYeg2)) > 0) {
                    sM3066getMh2AYeg = sM3066getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return sM3066getMh2AYeg;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minWithOrNull-YmdZ_VM, reason: not valid java name */
    public static final UInt m3231minWithOrNullYmdZ_VM(@NotNull int[] minWithOrNull, @NotNull Comparator<? super UInt> comparator) {
        Intrinsics.checkNotNullParameter(minWithOrNull, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UIntArray.m3019isEmptyimpl(minWithOrNull)) {
            return null;
        }
        int iM3016getpVg5ArA = UIntArray.m3016getpVg5ArA(minWithOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(minWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iM3016getpVg5ArA2 = UIntArray.m3016getpVg5ArA(minWithOrNull, i);
                if (comparator.compare(UInt.m3002boximpl(iM3016getpVg5ArA), UInt.m3002boximpl(iM3016getpVg5ArA2)) > 0) {
                    iM3016getpVg5ArA = iM3016getpVg5ArA2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m3002boximpl(iM3016getpVg5ArA);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minWithOrNull-zrEWJaI, reason: not valid java name */
    public static final ULong m3233minWithOrNullzrEWJaI(@NotNull long[] minWithOrNull, @NotNull Comparator<? super ULong> comparator) {
        Intrinsics.checkNotNullParameter(minWithOrNull, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (ULongArray.m3044isEmptyimpl(minWithOrNull)) {
            return null;
        }
        long jM3041getsVKNKU = ULongArray.m3041getsVKNKU(minWithOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(minWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long jM3041getsVKNKU2 = ULongArray.m3041getsVKNKU(minWithOrNull, i);
                if (comparator.compare(ULong.m3027boximpl(jM3041getsVKNKU), ULong.m3027boximpl(jM3041getsVKNKU2)) > 0) {
                    jM3041getsVKNKU = jM3041getsVKNKU2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m3027boximpl(jM3041getsVKNKU);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minWithOrNull-XMRcp5o, reason: not valid java name */
    public static final UByte m3230minWithOrNullXMRcp5o(@NotNull byte[] minWithOrNull, @NotNull Comparator<? super UByte> comparator) {
        Intrinsics.checkNotNullParameter(minWithOrNull, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UByteArray.m2994isEmptyimpl(minWithOrNull)) {
            return null;
        }
        byte bM2991getw2LRezQ = UByteArray.m2991getw2LRezQ(minWithOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(minWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte bM2991getw2LRezQ2 = UByteArray.m2991getw2LRezQ(minWithOrNull, i);
                if (comparator.compare(UByte.m2977boximpl(bM2991getw2LRezQ), UByte.m2977boximpl(bM2991getw2LRezQ2)) > 0) {
                    bM2991getw2LRezQ = bM2991getw2LRezQ2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m2977boximpl(bM2991getw2LRezQ);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    /* renamed from: minWithOrNull-eOHTfZs, reason: not valid java name */
    public static final UShort m3232minWithOrNulleOHTfZs(@NotNull short[] minWithOrNull, @NotNull Comparator<? super UShort> comparator) {
        Intrinsics.checkNotNullParameter(minWithOrNull, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (UShortArray.m3069isEmptyimpl(minWithOrNull)) {
            return null;
        }
        short sM3066getMh2AYeg = UShortArray.m3066getMh2AYeg(minWithOrNull, 0);
        int lastIndex = ArraysKt.getLastIndex(minWithOrNull);
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short sM3066getMh2AYeg2 = UShortArray.m3066getMh2AYeg(minWithOrNull, i);
                if (comparator.compare(UShort.m3052boximpl(sM3066getMh2AYeg), UShort.m3052boximpl(sM3066getMh2AYeg2)) > 0) {
                    sM3066getMh2AYeg = sM3066getMh2AYeg2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m3052boximpl(sM3066getMh2AYeg);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-C-E_24M, reason: not valid java name */
    public static final <R> List<Pair<UInt, R>> m3334zipCE_24M(@NotNull int[] zip, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(UIntArray.m3017getSizeimpl(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            int iM3016getpVg5ArA = UIntArray.m3016getpVg5ArA(zip, i);
            arrayList.add(TuplesKt.to(UInt.m3002boximpl(iM3016getpVg5ArA), other[i]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-f7H3mmw, reason: not valid java name */
    public static final <R> List<Pair<ULong, R>> m3340zipf7H3mmw(@NotNull long[] zip, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(ULongArray.m3042getSizeimpl(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            long jM3041getsVKNKU = ULongArray.m3041getsVKNKU(zip, i);
            arrayList.add(TuplesKt.to(ULong.m3027boximpl(jM3041getsVKNKU), other[i]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-nl983wc, reason: not valid java name */
    public static final <R> List<Pair<UByte, R>> m3343zipnl983wc(@NotNull byte[] zip, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(UByteArray.m2992getSizeimpl(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            byte bM2991getw2LRezQ = UByteArray.m2991getw2LRezQ(zip, i);
            arrayList.add(TuplesKt.to(UByte.m2977boximpl(bM2991getw2LRezQ), other[i]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-uaTIQ5s, reason: not valid java name */
    public static final <R> List<Pair<UShort, R>> m3344zipuaTIQ5s(@NotNull short[] zip, @NotNull R[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(UShortArray.m3067getSizeimpl(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            short sM3066getMh2AYeg = UShortArray.m3066getMh2AYeg(zip, i);
            arrayList.add(TuplesKt.to(UShort.m3052boximpl(sM3066getMh2AYeg), other[i]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-HwE9HBo, reason: not valid java name */
    public static final <R> List<Pair<UInt, R>> m3336zipHwE9HBo(@NotNull int[] zip, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iM3017getSizeimpl = UIntArray.m3017getSizeimpl(zip);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(other, 10), iM3017getSizeimpl));
        int i = 0;
        for (R r : other) {
            if (i >= iM3017getSizeimpl) {
                break;
            }
            arrayList.add(TuplesKt.to(UInt.m3002boximpl(UIntArray.m3016getpVg5ArA(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-F7u83W8, reason: not valid java name */
    public static final <R> List<Pair<ULong, R>> m3335zipF7u83W8(@NotNull long[] zip, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iM3042getSizeimpl = ULongArray.m3042getSizeimpl(zip);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(other, 10), iM3042getSizeimpl));
        int i = 0;
        for (R r : other) {
            if (i >= iM3042getSizeimpl) {
                break;
            }
            arrayList.add(TuplesKt.to(ULong.m3027boximpl(ULongArray.m3041getsVKNKU(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-JQknh5Q, reason: not valid java name */
    public static final <R> List<Pair<UByte, R>> m3338zipJQknh5Q(@NotNull byte[] zip, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iM2992getSizeimpl = UByteArray.m2992getSizeimpl(zip);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(other, 10), iM2992getSizeimpl));
        int i = 0;
        for (R r : other) {
            if (i >= iM2992getSizeimpl) {
                break;
            }
            arrayList.add(TuplesKt.to(UByte.m2977boximpl(UByteArray.m2991getw2LRezQ(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-JGPC0-M, reason: not valid java name */
    public static final <R> List<Pair<UShort, R>> m3337zipJGPC0M(@NotNull short[] zip, @NotNull Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iM3067getSizeimpl = UShortArray.m3067getSizeimpl(zip);
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(other, 10), iM3067getSizeimpl));
        int i = 0;
        for (R r : other) {
            if (i >= iM3067getSizeimpl) {
                break;
            }
            arrayList.add(TuplesKt.to(UShort.m3052boximpl(UShortArray.m3066getMh2AYeg(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-ctEhBpI, reason: not valid java name */
    public static final List<Pair<UInt, UInt>> m3339zipctEhBpI(@NotNull int[] zip, @NotNull int[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(UIntArray.m3017getSizeimpl(zip), UIntArray.m3017getSizeimpl(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(TuplesKt.to(UInt.m3002boximpl(UIntArray.m3016getpVg5ArA(zip, i)), UInt.m3002boximpl(UIntArray.m3016getpVg5ArA(other, i))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-us8wMrg, reason: not valid java name */
    public static final List<Pair<ULong, ULong>> m3345zipus8wMrg(@NotNull long[] zip, @NotNull long[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(ULongArray.m3042getSizeimpl(zip), ULongArray.m3042getSizeimpl(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(TuplesKt.to(ULong.m3027boximpl(ULongArray.m3041getsVKNKU(zip, i)), ULong.m3027boximpl(ULongArray.m3041getsVKNKU(other, i))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-kdPth3s, reason: not valid java name */
    public static final List<Pair<UByte, UByte>> m3341zipkdPth3s(@NotNull byte[] zip, @NotNull byte[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(UByteArray.m2992getSizeimpl(zip), UByteArray.m2992getSizeimpl(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(TuplesKt.to(UByte.m2977boximpl(UByteArray.m2991getw2LRezQ(zip, i)), UByte.m2977boximpl(UByteArray.m2991getw2LRezQ(other, i))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: zip-mazbYpA, reason: not valid java name */
    public static final List<Pair<UShort, UShort>> m3342zipmazbYpA(@NotNull short[] zip, @NotNull short[] other) {
        Intrinsics.checkNotNullParameter(zip, "$this$zip");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(UShortArray.m3067getSizeimpl(zip), UShortArray.m3067getSizeimpl(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(TuplesKt.to(UShort.m3052boximpl(UShortArray.m3066getMh2AYeg(zip, i)), UShort.m3052boximpl(UShortArray.m3066getMh2AYeg(other, i))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUInt")
    public static final int sumOfUInt(@NotNull UInt[] uIntArr) {
        Intrinsics.checkNotNullParameter(uIntArr, "<this>");
        int iM3003constructorimpl = 0;
        for (UInt uInt : uIntArr) {
            iM3003constructorimpl = UInt.m3003constructorimpl(iM3003constructorimpl + uInt.getData());
        }
        return iM3003constructorimpl;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfULong")
    public static final long sumOfULong(@NotNull ULong[] uLongArr) {
        Intrinsics.checkNotNullParameter(uLongArr, "<this>");
        long jM3028constructorimpl = 0;
        for (ULong uLong : uLongArr) {
            jM3028constructorimpl = ULong.m3028constructorimpl(jM3028constructorimpl + uLong.getData());
        }
        return jM3028constructorimpl;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(@NotNull UByte[] uByteArr) {
        Intrinsics.checkNotNullParameter(uByteArr, "<this>");
        int iM3003constructorimpl = 0;
        for (UByte uByte : uByteArr) {
            iM3003constructorimpl = UInt.m3003constructorimpl(iM3003constructorimpl + UInt.m3003constructorimpl(uByte.getData() & 255));
        }
        return iM3003constructorimpl;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUShort")
    public static final int sumOfUShort(@NotNull UShort[] uShortArr) {
        Intrinsics.checkNotNullParameter(uShortArr, "<this>");
        int iM3003constructorimpl = 0;
        for (UShort uShort : uShortArr) {
            iM3003constructorimpl = UInt.m3003constructorimpl(iM3003constructorimpl + UInt.m3003constructorimpl(uShort.getData() & UShort.MAX_VALUE));
        }
        return iM3003constructorimpl;
    }
}
