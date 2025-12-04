package androidx.media3.extractor.mp4;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.SniffFailure;
import java.io.IOException;

/* loaded from: classes.dex */
abstract class Sniffer {
    private static final int[] COMPATIBLE_BRANDS = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static SniffFailure sniffFragmented(ExtractorInput extractorInput) {
        return sniffInternal(extractorInput, true, false);
    }

    public static SniffFailure sniffUnfragmented(ExtractorInput extractorInput, boolean z) {
        return sniffInternal(extractorInput, false, z);
    }

    private static SniffFailure sniffInternal(ExtractorInput extractorInput, boolean z, boolean z2) throws IOException {
        int i;
        int i2;
        int i3;
        boolean z3;
        int[] iArr;
        long length = extractorInput.getLength();
        long j = -1;
        long j2 = 4096;
        if (length != -1 && length <= 4096) {
            j2 = length;
        }
        int i4 = (int) j2;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        int i5 = 0;
        int i6 = 0;
        boolean z4 = false;
        while (i6 < i4) {
            parsableByteArray.reset(8);
            if (!extractorInput.peekFully(parsableByteArray.getData(), i5, 8, true)) {
                break;
            }
            long unsignedInt = parsableByteArray.readUnsignedInt();
            int i7 = parsableByteArray.readInt();
            if (unsignedInt == 1) {
                extractorInput.peekFully(parsableByteArray.getData(), 8, 8);
                i2 = 16;
                parsableByteArray.setLimit(16);
                unsignedInt = parsableByteArray.readLong();
            } else {
                if (unsignedInt == 0) {
                    long length2 = extractorInput.getLength();
                    if (length2 != j) {
                        unsignedInt = (length2 - extractorInput.getPeekPosition()) + 8;
                    }
                }
                i2 = 8;
            }
            long j3 = unsignedInt;
            long j4 = i2;
            if (j3 < j4) {
                return new AtomSizeTooSmallSniffFailure(i7, j3, i2);
            }
            i6 += i2;
            if (i7 == 1836019574) {
                i4 += (int) j3;
                if (length != -1 && i4 > length) {
                    i4 = (int) length;
                }
            } else {
                if (i7 == 1836019558 || i7 == 1836475768) {
                    i = 1;
                    break;
                }
                long j5 = length;
                if (i7 == 1835295092) {
                    z4 = true;
                }
                if ((i6 + j3) - j4 >= i4) {
                    i = 0;
                    break;
                }
                int i8 = (int) (j3 - j4);
                i6 += i8;
                if (i7 != 1718909296) {
                    i3 = 0;
                    if (i8 != 0) {
                        extractorInput.advancePeekPosition(i8);
                    }
                } else {
                    if (i8 < 8) {
                        return new AtomSizeTooSmallSniffFailure(i7, i8, 8);
                    }
                    parsableByteArray.reset(i8);
                    i3 = 0;
                    extractorInput.peekFully(parsableByteArray.getData(), 0, i8);
                    int i9 = parsableByteArray.readInt();
                    if (isCompatibleBrand(i9, z2)) {
                        z4 = true;
                    }
                    parsableByteArray.skipBytes(4);
                    int iBytesLeft = parsableByteArray.bytesLeft() / 4;
                    if (!z4 && iBytesLeft > 0) {
                        iArr = new int[iBytesLeft];
                        int i10 = 0;
                        while (true) {
                            if (i10 >= iBytesLeft) {
                                z3 = z4;
                                break;
                            }
                            int i11 = parsableByteArray.readInt();
                            iArr[i10] = i11;
                            if (isCompatibleBrand(i11, z2)) {
                                z3 = true;
                                break;
                            }
                            i10++;
                        }
                    } else {
                        z3 = z4;
                        iArr = null;
                    }
                    if (!z3) {
                        return new UnsupportedBrandsSniffFailure(i9, iArr);
                    }
                    z4 = z3;
                }
                i5 = i3;
                length = j5;
            }
            j = -1;
        }
        i = i5;
        if (!z4) {
            return NoDeclaredBrandSniffFailure.INSTANCE;
        }
        if (z == i) {
            return null;
        }
        if (i != 0) {
            return IncorrectFragmentationSniffFailure.FILE_FRAGMENTED;
        }
        return IncorrectFragmentationSniffFailure.FILE_NOT_FRAGMENTED;
    }

    private static boolean isCompatibleBrand(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z) {
            return true;
        }
        for (int i2 : COMPATIBLE_BRANDS) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
