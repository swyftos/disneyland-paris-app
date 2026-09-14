package kotlin.collections;

import com.facebook.react.uimanager.ViewProps;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001e\u0010\u0014\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001f\u0010\u0016\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b \u0010\u0018\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, m1836d2 = {"partition", "", "array", "Lkotlin/UByteArray;", ViewProps.LEFT, ViewProps.RIGHT, "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, m1837k = 2, m1838mv = {1, 9, 0}, m1840xi = 48)
public final class UArraySortingKt {
    /* JADX INFO: renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m5403partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte bM5300getw2LRezQ = UByteArray.m5300getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = bM5300getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m5300getw2LRezQ(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m5300getw2LRezQ(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte bM5300getw2LRezQ2 = UByteArray.m5300getw2LRezQ(bArr, i);
                UByteArray.m5305setVurrAj0(bArr, i, UByteArray.m5300getw2LRezQ(bArr, i2));
                UByteArray.m5305setVurrAj0(bArr, i2, bM5300getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m5407quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int iM5403partition4UcCI2c = m5403partition4UcCI2c(bArr, i, i2);
        int i3 = iM5403partition4UcCI2c - 1;
        if (i < i3) {
            m5407quickSort4UcCI2c(bArr, i, i3);
        }
        if (iM5403partition4UcCI2c < i2) {
            m5407quickSort4UcCI2c(bArr, iM5403partition4UcCI2c, i2);
        }
    }

    /* JADX INFO: renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m5404partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short sM5375getMh2AYeg = UShortArray.m5375getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int iM5375getMh2AYeg = UShortArray.m5375getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i3 = sM5375getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(iM5375getMh2AYeg, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m5375getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short sM5375getMh2AYeg2 = UShortArray.m5375getMh2AYeg(sArr, i);
                UShortArray.m5380set01HTLdE(sArr, i, UShortArray.m5375getMh2AYeg(sArr, i2));
                UShortArray.m5380set01HTLdE(sArr, i2, sM5375getMh2AYeg2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m5408quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int iM5404partitionAa5vz7o = m5404partitionAa5vz7o(sArr, i, i2);
        int i3 = iM5404partitionAa5vz7o - 1;
        if (i < i3) {
            m5408quickSortAa5vz7o(sArr, i, i3);
        }
        if (iM5404partitionAa5vz7o < i2) {
            m5408quickSortAa5vz7o(sArr, iM5404partitionAa5vz7o, i2);
        }
    }

    /* JADX INFO: renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m5405partitionoBK06Vg(int[] iArr, int i, int i2) {
        int iM5325getpVg5ArA = UIntArray.m5325getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (Integer.compareUnsigned(UIntArray.m5325getpVg5ArA(iArr, i), iM5325getpVg5ArA) < 0) {
                i++;
            }
            while (Integer.compareUnsigned(UIntArray.m5325getpVg5ArA(iArr, i2), iM5325getpVg5ArA) > 0) {
                i2--;
            }
            if (i <= i2) {
                int iM5325getpVg5ArA2 = UIntArray.m5325getpVg5ArA(iArr, i);
                UIntArray.m5330setVXSXFK8(iArr, i, UIntArray.m5325getpVg5ArA(iArr, i2));
                UIntArray.m5330setVXSXFK8(iArr, i2, iM5325getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m5409quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int iM5405partitionoBK06Vg = m5405partitionoBK06Vg(iArr, i, i2);
        int i3 = iM5405partitionoBK06Vg - 1;
        if (i < i3) {
            m5409quickSortoBK06Vg(iArr, i, i3);
        }
        if (iM5405partitionoBK06Vg < i2) {
            m5409quickSortoBK06Vg(iArr, iM5405partitionoBK06Vg, i2);
        }
    }

    /* JADX INFO: renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m5402partitionnroSd4(long[] jArr, int i, int i2) {
        long jM5350getsVKNKU = ULongArray.m5350getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (Long.compareUnsigned(ULongArray.m5350getsVKNKU(jArr, i), jM5350getsVKNKU) < 0) {
                i++;
            }
            while (Long.compareUnsigned(ULongArray.m5350getsVKNKU(jArr, i2), jM5350getsVKNKU) > 0) {
                i2--;
            }
            if (i <= i2) {
                long jM5350getsVKNKU2 = ULongArray.m5350getsVKNKU(jArr, i);
                ULongArray.m5355setk8EXiF4(jArr, i, ULongArray.m5350getsVKNKU(jArr, i2));
                ULongArray.m5355setk8EXiF4(jArr, i2, jM5350getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m5406quickSortnroSd4(long[] jArr, int i, int i2) {
        int iM5402partitionnroSd4 = m5402partitionnroSd4(jArr, i, i2);
        int i3 = iM5402partitionnroSd4 - 1;
        if (i < i3) {
            m5406quickSortnroSd4(jArr, i, i3);
        }
        if (iM5402partitionnroSd4 < i2) {
            m5406quickSortnroSd4(jArr, iM5402partitionnroSd4, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m5411sortArray4UcCI2c(@NotNull byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m5407quickSort4UcCI2c(array, i, i2 - 1);
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m5412sortArrayAa5vz7o(@NotNull short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m5408quickSortAa5vz7o(array, i, i2 - 1);
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m5413sortArrayoBK06Vg(@NotNull int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m5409quickSortoBK06Vg(array, i, i2 - 1);
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m5410sortArraynroSd4(@NotNull long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m5406quickSortnroSd4(array, i, i2 - 1);
    }
}
