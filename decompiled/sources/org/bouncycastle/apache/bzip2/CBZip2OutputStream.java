package org.bouncycastle.apache.bzip2;

import com.contentsquare.android.api.Currencies;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;

/* loaded from: classes6.dex */
public class CBZip2OutputStream extends OutputStream implements BZip2Constants {
    protected static final int CLEARMASK = -2097153;
    protected static final int DEPTH_THRESH = 10;
    protected static final int GREATER_ICOST = 15;
    protected static final int LESSER_ICOST = 0;
    protected static final int QSORT_STACK_SIZE = 1000;
    protected static final int SETMASK = 2097152;
    protected static final int SMALL_THRESH = 20;
    private int allowableBlockSize;
    private char[] block;
    private int blockCRC;
    boolean blockRandomised;
    int blockSize100k;
    int bsBuff;
    int bsLive;
    private OutputStream bsStream;
    int bytesOut;
    boolean closed;
    private int combinedCRC;
    private int currentChar;
    private boolean finished;
    private boolean firstAttempt;
    private int[] ftab;
    private boolean[] inUse;
    private int[] incs;
    int last;
    CRC mCrc;
    private int[] mtfFreq;
    private int nBlocksRandomised;
    private int nInUse;
    private int nMTF;
    int origPtr;
    private int[] quadrant;
    private int runLength;
    private char[] selector;
    private char[] selectorMtf;
    private char[] seqToUnseq;
    private short[] szptr;
    private char[] unseqToSeq;
    private int workDone;
    private int workFactor;
    private int workLimit;
    private int[] zptr;

    private static class StackElem {
        int dd;
        int hh;
        int ll;

        private StackElem() {
        }
    }

    public CBZip2OutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, 9);
    }

    public CBZip2OutputStream(OutputStream outputStream, int i) throws IOException {
        this.mCrc = new CRC();
        this.inUse = new boolean[256];
        this.seqToUnseq = new char[256];
        this.unseqToSeq = new char[256];
        this.selector = new char[BZip2Constants.MAX_SELECTORS];
        this.selectorMtf = new char[BZip2Constants.MAX_SELECTORS];
        this.mtfFreq = new int[BZip2Constants.MAX_ALPHA_SIZE];
        this.currentChar = -1;
        this.runLength = 0;
        this.closed = false;
        this.incs = new int[]{1, 4, 13, 40, 121, Currencies.IRR, 1093, 3280, 9841, 29524, 88573, 265720, 797161, 2391484};
        this.block = null;
        this.quadrant = null;
        this.zptr = null;
        this.ftab = null;
        outputStream.write(66);
        outputStream.write(90);
        bsSetStream(outputStream);
        this.workFactor = 50;
        i = i > 9 ? 9 : i;
        this.blockSize100k = i >= 1 ? i : 1;
        allocateCompressStructures();
        initialize();
        initBlock();
    }

    private void allocateCompressStructures() {
        int i = this.blockSize100k;
        int i2 = 100000 * i;
        this.block = new char[i2 + 21];
        this.quadrant = new int[i2 + 20];
        this.zptr = new int[i2];
        this.ftab = new int[65537];
        this.szptr = new short[i * 200000];
    }

    private void bsFinishedWithStream() throws IOException {
        while (this.bsLive > 0) {
            this.bsStream.write(this.bsBuff >> 24);
            this.bsBuff <<= 8;
            this.bsLive -= 8;
            this.bytesOut++;
        }
    }

    private void bsPutIntVS(int i, int i2) throws IOException {
        bsW(i, i2);
    }

    private void bsPutUChar(int i) throws IOException {
        bsW(8, i);
    }

    private void bsPutint(int i) throws IOException {
        bsW(8, (i >> 24) & 255);
        bsW(8, (i >> 16) & 255);
        bsW(8, (i >> 8) & 255);
        bsW(8, i & 255);
    }

    private void bsSetStream(OutputStream outputStream) {
        this.bsStream = outputStream;
        this.bsLive = 0;
        this.bsBuff = 0;
        this.bytesOut = 0;
    }

    private void bsW(int i, int i2) throws IOException {
        while (true) {
            int i3 = this.bsLive;
            if (i3 < 8) {
                this.bsBuff = (i2 << ((32 - i3) - i)) | this.bsBuff;
                this.bsLive = i3 + i;
                return;
            } else {
                this.bsStream.write(this.bsBuff >> 24);
                this.bsBuff <<= 8;
                this.bsLive -= 8;
                this.bytesOut++;
            }
        }
    }

    private void doReversibleTransformation() {
        this.workLimit = this.workFactor * this.last;
        int i = 0;
        this.workDone = 0;
        this.blockRandomised = false;
        this.firstAttempt = true;
        mainSort();
        if (this.workDone > this.workLimit && this.firstAttempt) {
            randomiseBlock();
            this.workDone = 0;
            this.workLimit = 0;
            this.blockRandomised = true;
            this.firstAttempt = false;
            mainSort();
        }
        this.origPtr = -1;
        while (true) {
            if (i > this.last) {
                break;
            }
            if (this.zptr[i] == 0) {
                this.origPtr = i;
                break;
            }
            i++;
        }
        if (this.origPtr == -1) {
            panic();
        }
    }

    private void endBlock() throws IOException {
        int finalCRC = this.mCrc.getFinalCRC();
        this.blockCRC = finalCRC;
        int i = this.combinedCRC;
        this.combinedCRC = finalCRC ^ ((i >>> 31) | (i << 1));
        doReversibleTransformation();
        bsPutUChar(49);
        bsPutUChar(65);
        bsPutUChar(89);
        bsPutUChar(38);
        bsPutUChar(83);
        bsPutUChar(89);
        bsPutint(this.blockCRC);
        if (this.blockRandomised) {
            bsW(1, 1);
            this.nBlocksRandomised++;
        } else {
            bsW(1, 0);
        }
        moveToFrontCodeAndSend();
    }

    private void endCompression() throws IOException {
        bsPutUChar(23);
        bsPutUChar(114);
        bsPutUChar(69);
        bsPutUChar(56);
        bsPutUChar(80);
        bsPutUChar(144);
        bsPutint(this.combinedCRC);
        bsFinishedWithStream();
    }

    private boolean fullGtU(int i, int i2) {
        char[] cArr = this.block;
        char c = cArr[i + 1];
        char c2 = cArr[i2 + 1];
        if (c != c2) {
            return c > c2;
        }
        char c3 = cArr[i + 2];
        char c4 = cArr[i2 + 2];
        if (c3 != c4) {
            return c3 > c4;
        }
        char c5 = cArr[i + 3];
        char c6 = cArr[i2 + 3];
        if (c5 != c6) {
            return c5 > c6;
        }
        char c7 = cArr[i + 4];
        char c8 = cArr[i2 + 4];
        if (c7 != c8) {
            return c7 > c8;
        }
        char c9 = cArr[i + 5];
        char c10 = cArr[i2 + 5];
        if (c9 != c10) {
            return c9 > c10;
        }
        int i3 = i + 6;
        char c11 = cArr[i3];
        int i4 = i2 + 6;
        char c12 = cArr[i4];
        if (c11 != c12) {
            return c11 > c12;
        }
        int i5 = this.last + 1;
        do {
            char[] cArr2 = this.block;
            int i6 = i3 + 1;
            char c13 = cArr2[i6];
            int i7 = i4 + 1;
            char c14 = cArr2[i7];
            if (c13 != c14) {
                return c13 > c14;
            }
            int[] iArr = this.quadrant;
            int i8 = iArr[i3];
            int i9 = iArr[i4];
            if (i8 != i9) {
                return i8 > i9;
            }
            int i10 = i3 + 2;
            char c15 = cArr2[i10];
            int i11 = i4 + 2;
            char c16 = cArr2[i11];
            if (c15 != c16) {
                return c15 > c16;
            }
            int i12 = iArr[i6];
            int i13 = iArr[i7];
            if (i12 != i13) {
                return i12 > i13;
            }
            int i14 = i3 + 3;
            char c17 = cArr2[i14];
            int i15 = i4 + 3;
            char c18 = cArr2[i15];
            if (c17 != c18) {
                return c17 > c18;
            }
            int i16 = iArr[i10];
            int i17 = iArr[i11];
            if (i16 != i17) {
                return i16 > i17;
            }
            i3 += 4;
            char c19 = cArr2[i3];
            i4 += 4;
            char c20 = cArr2[i4];
            if (c19 != c20) {
                return c19 > c20;
            }
            int i18 = iArr[i14];
            int i19 = iArr[i15];
            if (i18 != i19) {
                return i18 > i19;
            }
            int i20 = this.last;
            if (i3 > i20) {
                i3 = (i3 - i20) - 1;
            }
            if (i4 > i20) {
                i4 = (i4 - i20) - 1;
            }
            i5 -= 4;
            this.workDone++;
        } while (i5 >= 0);
        return false;
    }

    private void generateMTFValues() {
        char[] cArr = new char[256];
        makeMaps();
        int i = this.nInUse + 1;
        for (int i2 = 0; i2 <= i; i2++) {
            this.mtfFreq[i2] = 0;
        }
        for (int i3 = 0; i3 < this.nInUse; i3++) {
            cArr[i3] = (char) i3;
        }
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 <= this.last; i6++) {
            char c = this.unseqToSeq[this.block[this.zptr[i6]]];
            char c2 = cArr[0];
            int i7 = 0;
            while (c != c2) {
                i7++;
                char c3 = cArr[i7];
                cArr[i7] = c2;
                c2 = c3;
            }
            cArr[0] = c2;
            if (i7 == 0) {
                i4++;
            } else {
                if (i4 > 0) {
                    int i8 = i4 - 1;
                    while (true) {
                        int i9 = i8 % 2;
                        if (i9 == 0) {
                            this.szptr[i5] = 0;
                            i5++;
                            int[] iArr = this.mtfFreq;
                            iArr[0] = iArr[0] + 1;
                        } else if (i9 == 1) {
                            this.szptr[i5] = 1;
                            i5++;
                            int[] iArr2 = this.mtfFreq;
                            iArr2[1] = iArr2[1] + 1;
                        }
                        if (i8 < 2) {
                            break;
                        } else {
                            i8 = (i8 - 2) / 2;
                        }
                    }
                    i4 = 0;
                }
                int i10 = i7 + 1;
                this.szptr[i5] = (short) i10;
                i5++;
                int[] iArr3 = this.mtfFreq;
                iArr3[i10] = iArr3[i10] + 1;
            }
        }
        if (i4 > 0) {
            int i11 = i4 - 1;
            while (true) {
                int i12 = i11 % 2;
                if (i12 == 0) {
                    this.szptr[i5] = 0;
                    i5++;
                    int[] iArr4 = this.mtfFreq;
                    iArr4[0] = iArr4[0] + 1;
                } else if (i12 == 1) {
                    this.szptr[i5] = 1;
                    i5++;
                    int[] iArr5 = this.mtfFreq;
                    iArr5[1] = iArr5[1] + 1;
                }
                if (i11 < 2) {
                    break;
                } else {
                    i11 = (i11 - 2) / 2;
                }
            }
        }
        this.szptr[i5] = (short) i;
        int[] iArr6 = this.mtfFreq;
        iArr6[i] = iArr6[i] + 1;
        this.nMTF = i5 + 1;
    }

    private void hbAssignCodes(int[] iArr, char[] cArr, int i, int i2, int i3) {
        int i4 = 0;
        while (i <= i2) {
            for (int i5 = 0; i5 < i3; i5++) {
                if (cArr[i5] == i) {
                    iArr[i5] = i4;
                    i4++;
                }
            }
            i4 <<= 1;
            i++;
        }
    }

    protected static void hbMakeCodeLengths(char[] cArr, int[] iArr, int i, int i2) {
        int i3 = 260;
        int[] iArr2 = new int[260];
        int i4 = Currencies.NAD;
        int[] iArr3 = new int[Currencies.NAD];
        int[] iArr4 = new int[Currencies.NAD];
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = 1;
            if (i6 >= i) {
                break;
            }
            int i8 = i6 + 1;
            int i9 = iArr[i6];
            if (i9 != 0) {
                i7 = i9;
            }
            iArr3[i8] = i7 << 8;
            i6 = i8;
        }
        while (true) {
            iArr2[i5] = i5;
            iArr3[i5] = i5;
            iArr4[i5] = -2;
            int i10 = i5;
            for (int i11 = 1; i11 <= i; i11++) {
                iArr4[i11] = -1;
                i10++;
                iArr2[i10] = i11;
                int i12 = i10;
                while (true) {
                    int i13 = iArr3[i11];
                    int i14 = i12 >> 1;
                    int i15 = iArr2[i14];
                    if (i13 < iArr3[i15]) {
                        iArr2[i12] = i15;
                        i12 = i14;
                    }
                }
                iArr2[i12] = i11;
            }
            if (i10 >= i3) {
                panic();
            }
            int i16 = i;
            while (i10 > 1) {
                int i17 = iArr2[1];
                int i18 = iArr2[i10];
                iArr2[1] = i18;
                int i19 = i10 - 1;
                int i20 = 1;
                while (true) {
                    int i21 = i20 << 1;
                    if (i21 > i19) {
                        break;
                    }
                    if (i21 < i19) {
                        int i22 = i21 + 1;
                        if (iArr3[iArr2[i22]] < iArr3[iArr2[i21]]) {
                            i21 = i22;
                        }
                    }
                    int i23 = iArr3[i18];
                    int i24 = iArr2[i21];
                    if (i23 < iArr3[i24]) {
                        break;
                    }
                    iArr2[i20] = i24;
                    i20 = i21;
                }
                iArr2[i20] = i18;
                int i25 = iArr2[1];
                int i26 = iArr2[i19];
                iArr2[1] = i26;
                int i27 = i10 - 2;
                int i28 = 1;
                while (true) {
                    int i29 = i28 << 1;
                    if (i29 > i27) {
                        break;
                    }
                    if (i29 < i27) {
                        int i30 = i29 + 1;
                        if (iArr3[iArr2[i30]] < iArr3[iArr2[i29]]) {
                            i29 = i30;
                        }
                    }
                    int i31 = iArr3[i26];
                    int i32 = iArr2[i29];
                    if (i31 < iArr3[i32]) {
                        break;
                    }
                    iArr2[i28] = i32;
                    i28 = i29;
                }
                iArr2[i28] = i26;
                i16++;
                iArr4[i25] = i16;
                iArr4[i17] = i16;
                int i33 = iArr3[i17];
                int i34 = iArr3[i25];
                iArr3[i16] = (((i33 & 255) > (i34 & 255) ? i33 & 255 : i34 & 255) + 1) | ((i33 & (-256)) + (i34 & (-256)));
                iArr4[i16] = -1;
                i10--;
                iArr2[i10] = i16;
                int i35 = i10;
                while (true) {
                    int i36 = iArr3[i16];
                    int i37 = i35 >> 1;
                    int i38 = iArr2[i37];
                    if (i36 < iArr3[i38]) {
                        iArr2[i35] = i38;
                        i35 = i37;
                    }
                }
                iArr2[i35] = i16;
                i4 = Currencies.NAD;
            }
            int i39 = i4;
            if (i16 >= i39) {
                panic();
            }
            boolean z = false;
            for (int i40 = 1; i40 <= i; i40++) {
                int i41 = i40;
                int i42 = 0;
                while (true) {
                    i41 = iArr4[i41];
                    if (i41 < 0) {
                        break;
                    } else {
                        i42++;
                    }
                }
                cArr[i40 - 1] = (char) i42;
                if (i42 > i2) {
                    z = true;
                }
            }
            if (!z) {
                return;
            }
            for (int i43 = 1; i43 < i; i43++) {
                iArr3[i43] = (((iArr3[i43] >> 8) / 2) + 1) << 8;
            }
            i4 = i39;
            i3 = 260;
            i5 = 0;
        }
    }

    private void initBlock() {
        this.mCrc.initialiseCRC();
        this.last = -1;
        for (int i = 0; i < 256; i++) {
            this.inUse[i] = false;
        }
        this.allowableBlockSize = (this.blockSize100k * 100000) - 20;
    }

    private void initialize() throws IOException {
        this.bytesOut = 0;
        this.nBlocksRandomised = 0;
        bsPutUChar(104);
        bsPutUChar(this.blockSize100k + 48);
        this.combinedCRC = 0;
    }

    private void mainSort() {
        int i;
        int i2;
        int i3;
        int i4;
        int[] iArr = new int[256];
        int[] iArr2 = new int[256];
        boolean[] zArr = new boolean[256];
        int i5 = 0;
        while (true) {
            i = 2;
            if (i5 >= 20) {
                break;
            }
            char[] cArr = this.block;
            int i6 = this.last;
            cArr[i6 + i5 + 2] = cArr[(i5 % (i6 + 1)) + 1];
            i5++;
        }
        int i7 = 0;
        while (true) {
            i2 = this.last;
            if (i7 > i2 + 20) {
                break;
            }
            this.quadrant[i7] = 0;
            i7++;
        }
        char[] cArr2 = this.block;
        cArr2[0] = cArr2[i2 + 1];
        if (i2 >= 4000) {
            for (int i8 = 0; i8 <= 255; i8++) {
                zArr[i8] = false;
            }
            for (int i9 = 0; i9 <= 65536; i9++) {
                this.ftab[i9] = 0;
            }
            char c = this.block[0];
            int i10 = 0;
            while (i10 <= this.last) {
                i10++;
                char c2 = this.block[i10];
                int[] iArr3 = this.ftab;
                int i11 = (c << '\b') + c2;
                iArr3[i11] = iArr3[i11] + 1;
                c = c2;
            }
            for (int i12 = 1; i12 <= 65536; i12++) {
                int[] iArr4 = this.ftab;
                iArr4[i12] = iArr4[i12] + iArr4[i12 - 1];
            }
            char c3 = this.block[1];
            int i13 = 0;
            while (true) {
                i3 = this.last;
                if (i13 >= i3) {
                    break;
                }
                char c4 = this.block[i13 + 2];
                int i14 = (c3 << '\b') + c4;
                int[] iArr5 = this.ftab;
                int i15 = iArr5[i14] - 1;
                iArr5[i14] = i15;
                this.zptr[i15] = i13;
                i13++;
                c3 = c4;
            }
            char[] cArr3 = this.block;
            int i16 = (cArr3[i3 + 1] << '\b') + cArr3[1];
            int[] iArr6 = this.ftab;
            int i17 = iArr6[i16] - 1;
            iArr6[i16] = i17;
            this.zptr[i17] = i3;
            for (int i18 = 0; i18 <= 255; i18++) {
                iArr[i18] = i18;
            }
            int i19 = 1;
            do {
                i19 = (i19 * 3) + 1;
            } while (i19 <= 256);
            do {
                i19 /= 3;
                for (int i20 = i19; i20 <= 255; i20++) {
                    int i21 = iArr[i20];
                    int i22 = i20;
                    do {
                        int[] iArr7 = this.ftab;
                        i4 = i22 - i19;
                        int i23 = iArr[i4];
                        if (iArr7[(i23 + 1) << 8] - iArr7[i23 << 8] > iArr7[(i21 + 1) << 8] - iArr7[i21 << 8]) {
                            iArr[i22] = i23;
                            i22 = i4;
                        }
                        iArr[i22] = i21;
                    } while (i4 > i19 - 1);
                    iArr[i22] = i21;
                }
            } while (i19 != 1);
            int i24 = 0;
            while (i24 <= 255) {
                int i25 = iArr[i24];
                for (int i26 = 0; i26 <= 255; i26++) {
                    int i27 = (i25 << 8) + i26;
                    int[] iArr8 = this.ftab;
                    int i28 = iArr8[i27];
                    if ((i28 & 2097152) != 2097152) {
                        int i29 = i28 & CLEARMASK;
                        int i30 = (CLEARMASK & iArr8[i27 + 1]) - 1;
                        if (i30 > i29) {
                            qSort3(i29, i30, i);
                            if (this.workDone > this.workLimit && this.firstAttempt) {
                                return;
                            }
                        }
                        int[] iArr9 = this.ftab;
                        iArr9[i27] = 2097152 | iArr9[i27];
                    }
                }
                zArr[i25] = true;
                if (i24 < 255) {
                    int[] iArr10 = this.ftab;
                    int i31 = iArr10[i25 << 8] & CLEARMASK;
                    int i32 = (iArr10[(i25 + 1) << 8] & CLEARMASK) - i31;
                    int i33 = 0;
                    while ((i32 >> i33) > 65534) {
                        i33++;
                    }
                    for (int i34 = 0; i34 < i32; i34++) {
                        int i35 = this.zptr[i31 + i34];
                        int i36 = i34 >> i33;
                        int[] iArr11 = this.quadrant;
                        iArr11[i35] = i36;
                        if (i35 < 20) {
                            iArr11[i35 + this.last + 1] = i36;
                        }
                    }
                    if (((i32 - 1) >> i33) > 65535) {
                        panic();
                    }
                }
                for (int i37 = 0; i37 <= 255; i37++) {
                    iArr2[i37] = this.ftab[(i37 << 8) + i25] & CLEARMASK;
                }
                for (int i38 = this.ftab[i25 << 8] & CLEARMASK; i38 < (this.ftab[(i25 + 1) << 8] & CLEARMASK); i38++) {
                    char[] cArr4 = this.block;
                    int[] iArr12 = this.zptr;
                    int i39 = iArr12[i38];
                    char c5 = cArr4[i39];
                    if (!zArr[c5]) {
                        iArr12[iArr2[c5]] = i39 == 0 ? this.last : i39 - 1;
                        iArr2[c5] = iArr2[c5] + 1;
                    }
                }
                for (int i40 = 0; i40 <= 255; i40++) {
                    int[] iArr13 = this.ftab;
                    int i41 = (i40 << 8) + i25;
                    iArr13[i41] = iArr13[i41] | 2097152;
                }
                i24++;
                i = 2;
            }
            return;
        }
        int i42 = 0;
        while (true) {
            int i43 = this.last;
            if (i42 > i43) {
                this.firstAttempt = false;
                this.workLimit = 0;
                this.workDone = 0;
                simpleSort(0, i43, 0);
                return;
            }
            this.zptr[i42] = i42;
            i42++;
        }
    }

    private void makeMaps() {
        this.nInUse = 0;
        for (int i = 0; i < 256; i++) {
            if (this.inUse[i]) {
                char[] cArr = this.seqToUnseq;
                int i2 = this.nInUse;
                cArr[i2] = (char) i;
                this.unseqToSeq[i] = (char) i2;
                this.nInUse = i2 + 1;
            }
        }
    }

    private char med3(char c, char c2, char c3) {
        if (c <= c2) {
            c2 = c;
            c = c2;
        }
        if (c <= c3) {
            c3 = c;
        }
        return c2 > c3 ? c2 : c3;
    }

    private void moveToFrontCodeAndSend() throws IOException {
        bsPutIntVS(24, this.origPtr);
        generateMTFValues();
        sendMTFValues();
    }

    private static void panic() {
        System.out.println("panic");
    }

    private void qSort3(int i, int i2, int i3) {
        StackElem[] stackElemArr = new StackElem[1000];
        for (int i4 = 0; i4 < 1000; i4++) {
            stackElemArr[i4] = new StackElem();
        }
        StackElem stackElem = stackElemArr[0];
        stackElem.ll = i;
        stackElem.hh = i2;
        stackElem.dd = i3;
        int i5 = 1;
        while (i5 > 0) {
            if (i5 >= 1000) {
                panic();
            }
            int i6 = i5 - 1;
            StackElem stackElem2 = stackElemArr[i6];
            int i7 = stackElem2.ll;
            int i8 = stackElem2.hh;
            int i9 = stackElem2.dd;
            if (i8 - i7 < 20 || i9 > 10) {
                simpleSort(i7, i8, i9);
                if (this.workDone > this.workLimit && this.firstAttempt) {
                    return;
                } else {
                    i5 = i6;
                }
            } else {
                char[] cArr = this.block;
                int[] iArr = this.zptr;
                char cMed3 = med3(cArr[iArr[i7] + i9 + 1], cArr[iArr[i8] + i9 + 1], cArr[iArr[(i7 + i8) >> 1] + i9 + 1]);
                int i10 = i7;
                int i11 = i10;
                int i12 = i8;
                int i13 = i12;
                while (true) {
                    if (i10 <= i12) {
                        char[] cArr2 = this.block;
                        int[] iArr2 = this.zptr;
                        int i14 = iArr2[i10];
                        int i15 = cArr2[(i14 + i9) + 1] - cMed3;
                        if (i15 == 0) {
                            iArr2[i10] = iArr2[i11];
                            iArr2[i11] = i14;
                            i11++;
                        } else if (i15 > 0) {
                        }
                        i10++;
                    }
                    while (i10 <= i12) {
                        char[] cArr3 = this.block;
                        int[] iArr3 = this.zptr;
                        int i16 = iArr3[i12];
                        int i17 = cArr3[(i16 + i9) + 1] - cMed3;
                        if (i17 != 0) {
                            if (i17 < 0) {
                                break;
                            }
                        } else {
                            iArr3[i12] = iArr3[i13];
                            iArr3[i13] = i16;
                            i13--;
                        }
                        i12--;
                    }
                    if (i10 > i12) {
                        break;
                    }
                    int[] iArr4 = this.zptr;
                    int i18 = iArr4[i10];
                    iArr4[i10] = iArr4[i12];
                    iArr4[i12] = i18;
                    i10++;
                    i12--;
                }
                if (i13 < i11) {
                    StackElem stackElem3 = stackElemArr[i6];
                    stackElem3.ll = i7;
                    stackElem3.hh = i8;
                    stackElem3.dd = i9 + 1;
                } else {
                    int i19 = i11 - i7;
                    int i20 = i10 - i11;
                    if (i19 >= i20) {
                        i19 = i20;
                    }
                    vswap(i7, i10 - i19, i19);
                    int i21 = i8 - i13;
                    int i22 = i13 - i12;
                    if (i21 >= i22) {
                        i21 = i22;
                    }
                    vswap(i10, (i8 - i21) + 1, i21);
                    int i23 = (i10 + i7) - i11;
                    int i24 = i8 - i22;
                    StackElem stackElem4 = stackElemArr[i6];
                    stackElem4.ll = i7;
                    stackElem4.hh = i23 - 1;
                    stackElem4.dd = i9;
                    StackElem stackElem5 = stackElemArr[i5];
                    stackElem5.ll = i23;
                    stackElem5.hh = i24;
                    stackElem5.dd = i9 + 1;
                    StackElem stackElem6 = stackElemArr[i5 + 1];
                    stackElem6.ll = i24 + 1;
                    stackElem6.hh = i8;
                    stackElem6.dd = i9;
                    i5 += 2;
                }
            }
        }
    }

    private void randomiseBlock() {
        for (int i = 0; i < 256; i++) {
            this.inUse[i] = false;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 <= this.last) {
            if (i3 == 0) {
                i3 = (char) BZip2Constants.rNums[i4];
                i4++;
                if (i4 == 512) {
                    i4 = 0;
                }
            }
            i3--;
            char[] cArr = this.block;
            i2++;
            char c = (char) (cArr[i2] ^ (i3 == 1 ? (char) 1 : (char) 0));
            cArr[i2] = c;
            char c2 = (char) (c & 255);
            cArr[i2] = c2;
            this.inUse[c2] = true;
        }
    }

    private void sendMTFValues() throws IOException {
        int i;
        int i2;
        char c = 2;
        char c2 = 1;
        short s = 0;
        char[][] cArr = (char[][]) Array.newInstance((Class<?>) Character.TYPE, 6, BZip2Constants.MAX_ALPHA_SIZE);
        int i3 = this.nInUse;
        int i4 = i3 + 2;
        for (int i5 = 0; i5 < 6; i5++) {
            for (int i6 = 0; i6 < i4; i6++) {
                cArr[i5][i6] = 15;
            }
        }
        if (this.nMTF <= 0) {
            panic();
        }
        int i7 = this.nMTF;
        int i8 = i7 < 200 ? 2 : i7 < 600 ? 3 : i7 < 1200 ? 4 : i7 < 2400 ? 5 : 6;
        int i9 = 0;
        int i10 = i8;
        while (i10 > 0) {
            int i11 = i7 / i10;
            int i12 = 0;
            int i13 = i9 - 1;
            while (i12 < i11 && i13 < i3 + 1) {
                i13++;
                i12 += this.mtfFreq[i13];
            }
            if (i13 > i9 && i10 != i8 && i10 != 1 && (i8 - i10) % 2 == 1) {
                i12 -= this.mtfFreq[i13];
                i13--;
            }
            for (int i14 = 0; i14 < i4; i14++) {
                if (i14 < i9 || i14 > i13) {
                    cArr[i10 - 1][i14] = 15;
                } else {
                    cArr[i10 - 1][i14] = 0;
                }
            }
            i10--;
            i9 = i13 + 1;
            i7 -= i12;
        }
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 6, BZip2Constants.MAX_ALPHA_SIZE);
        int[] iArr2 = new int[6];
        short[] sArr = new short[6];
        int i15 = 0;
        int i16 = 0;
        while (true) {
            int i17 = 20;
            if (i15 >= 4) {
                break;
            }
            for (int i18 = s; i18 < i8; i18++) {
                iArr2[i18] = s;
            }
            for (int i19 = s; i19 < i8; i19++) {
                for (int i20 = s; i20 < i4; i20++) {
                    iArr[i19][i20] = s;
                }
            }
            int i21 = s;
            i16 = i21;
            while (true) {
                int i22 = this.nMTF;
                if (i21 >= i22) {
                    break;
                }
                int i23 = i21 + 49;
                if (i23 >= i22) {
                    i23 = i22 - 1;
                }
                for (int i24 = s; i24 < i8; i24++) {
                    sArr[i24] = s;
                }
                if (i8 == 6) {
                    int i25 = i21;
                    short s2 = s;
                    short s3 = s2;
                    short s4 = s3;
                    short s5 = s4;
                    short s6 = s5;
                    short s7 = s6;
                    while (i25 <= i23) {
                        short s8 = this.szptr[i25];
                        short s9 = (short) (s2 + cArr[s][s8]);
                        short s10 = (short) (s3 + cArr[c2][s8]);
                        short s11 = (short) (s4 + cArr[c][s8]);
                        int i26 = i15;
                        short s12 = (short) (s5 + cArr[3][s8]);
                        i25++;
                        s6 = (short) (s6 + cArr[4][s8]);
                        s4 = s11;
                        s2 = s9;
                        s7 = (short) (s7 + cArr[5][s8]);
                        s5 = s12;
                        i15 = i26;
                        c = 2;
                        s = 0;
                        s3 = s10;
                        c2 = 1;
                    }
                    i2 = i15;
                    sArr[s] = s2;
                    sArr[1] = s3;
                    sArr[2] = s4;
                    sArr[3] = s5;
                    sArr[4] = s6;
                    sArr[5] = s7;
                } else {
                    i2 = i15;
                    for (int i27 = i21; i27 <= i23; i27++) {
                        short s13 = this.szptr[i27];
                        for (int i28 = 0; i28 < i8; i28++) {
                            sArr[i28] = (short) (sArr[i28] + cArr[i28][s13]);
                        }
                    }
                }
                int i29 = -1;
                short s14 = 999999999;
                for (int i30 = 0; i30 < i8; i30++) {
                    short s15 = sArr[i30];
                    if (s15 < s14) {
                        i29 = i30;
                        s14 = s15;
                    }
                }
                iArr2[i29] = iArr2[i29] + 1;
                this.selector[i16] = (char) i29;
                i16++;
                while (i21 <= i23) {
                    int[] iArr3 = iArr[i29];
                    short s16 = this.szptr[i21];
                    iArr3[s16] = iArr3[s16] + 1;
                    i21++;
                }
                i21 = i23 + 1;
                i15 = i2;
                c = 2;
                c2 = 1;
                s = 0;
                i17 = 20;
            }
            for (int i31 = s; i31 < i8; i31++) {
                hbMakeCodeLengths(cArr[i31], iArr[i31], i4, i17);
            }
            i15++;
        }
        if (i8 >= 8) {
            panic();
        }
        if (i16 >= 32768 || i16 > 18002) {
            panic();
        }
        char[] cArr2 = new char[6];
        for (int i32 = 0; i32 < i8; i32++) {
            cArr2[i32] = (char) i32;
        }
        for (int i33 = 0; i33 < i16; i33++) {
            char c3 = this.selector[i33];
            char c4 = cArr2[0];
            int i34 = 0;
            while (c3 != c4) {
                i34++;
                char c5 = cArr2[i34];
                cArr2[i34] = c4;
                c4 = c5;
            }
            cArr2[0] = c4;
            this.selectorMtf[i33] = (char) i34;
        }
        int[][] iArr4 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 6, BZip2Constants.MAX_ALPHA_SIZE);
        for (int i35 = 0; i35 < i8; i35++) {
            char c6 = ' ';
            char c7 = 0;
            for (int i36 = 0; i36 < i4; i36++) {
                char c8 = cArr[i35][i36];
                if (c8 > c7) {
                    c7 = c8;
                }
                if (c8 < c6) {
                    c6 = c8;
                }
            }
            if (c7 > 20) {
                panic();
            }
            if (c6 < 1) {
                panic();
            }
            hbAssignCodes(iArr4[i35], cArr[i35], c6, c7, i4);
        }
        boolean[] zArr = new boolean[16];
        for (int i37 = 0; i37 < 16; i37++) {
            zArr[i37] = false;
            for (int i38 = 0; i38 < 16; i38++) {
                if (this.inUse[(i37 * 16) + i38]) {
                    zArr[i37] = true;
                }
            }
        }
        for (int i39 = 0; i39 < 16; i39++) {
            if (zArr[i39]) {
                bsW(1, 1);
            } else {
                bsW(1, 0);
            }
        }
        for (int i40 = 0; i40 < 16; i40++) {
            if (zArr[i40]) {
                for (int i41 = 0; i41 < 16; i41++) {
                    if (this.inUse[(i40 * 16) + i41]) {
                        bsW(1, 1);
                    } else {
                        bsW(1, 0);
                    }
                }
            }
        }
        bsW(3, i8);
        bsW(15, i16);
        int i42 = 0;
        while (true) {
            i = 0;
            if (i42 >= i16) {
                break;
            }
            while (i < this.selectorMtf[i42]) {
                bsW(1, 1);
                i++;
            }
            bsW(1, 0);
            i42++;
        }
        int i43 = 0;
        while (i43 < i8) {
            char c9 = cArr[i43][i];
            bsW(5, c9);
            int i44 = c9;
            for (int i45 = 0; i45 < i4; i45++) {
                while (i44 < cArr[i43][i45]) {
                    bsW(2, 2);
                    i44++;
                }
                while (i44 > cArr[i43][i45]) {
                    bsW(2, 3);
                    i44--;
                }
                bsW(1, 0);
            }
            i43++;
            i = 0;
        }
        int i46 = i;
        int i47 = i46;
        while (true) {
            int i48 = this.nMTF;
            if (i46 >= i48) {
                break;
            }
            int i49 = i46 + 49;
            if (i49 >= i48) {
                i49 = i48 - 1;
            }
            while (i46 <= i49) {
                char c10 = this.selector[i47];
                char[] cArr3 = cArr[c10];
                short s17 = this.szptr[i46];
                bsW(cArr3[s17], iArr4[c10][s17]);
                i46++;
            }
            i46 = i49 + 1;
            i47++;
        }
        if (i47 != i16) {
            panic();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0012, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0012, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void simpleSort(int r10, int r11, int r12) {
        /*
            r9 = this;
            int r0 = r11 - r10
            int r0 = r0 + 1
            r1 = 2
            if (r0 >= r1) goto L8
            return
        L8:
            r1 = 0
        L9:
            int[] r2 = r9.incs
            r2 = r2[r1]
            if (r2 >= r0) goto L12
            int r1 = r1 + 1
            goto L9
        L12:
            int r1 = r1 + (-1)
            if (r1 < 0) goto La2
            int[] r0 = r9.incs
            r0 = r0[r1]
            int r2 = r10 + r0
            r3 = r2
        L1d:
            if (r3 <= r11) goto L20
            goto L72
        L20:
            int[] r4 = r9.zptr
            r4 = r4[r3]
            r5 = r3
        L25:
            int[] r6 = r9.zptr
            int r7 = r5 - r0
            r6 = r6[r7]
            int r6 = r6 + r12
            int r8 = r4 + r12
            boolean r6 = r9.fullGtU(r6, r8)
            if (r6 == 0) goto L42
            int[] r6 = r9.zptr
            r8 = r6[r7]
            r6[r5] = r8
            int r5 = r2 + (-1)
            if (r7 > r5) goto L40
            r5 = r7
            goto L42
        L40:
            r5 = r7
            goto L25
        L42:
            int[] r6 = r9.zptr
            r6[r5] = r4
            int r4 = r3 + 1
            if (r4 <= r11) goto L4b
            goto L72
        L4b:
            r5 = r6[r4]
        L4d:
            int[] r6 = r9.zptr
            int r7 = r4 - r0
            r6 = r6[r7]
            int r6 = r6 + r12
            int r8 = r5 + r12
            boolean r6 = r9.fullGtU(r6, r8)
            if (r6 == 0) goto L6a
            int[] r6 = r9.zptr
            r8 = r6[r7]
            r6[r4] = r8
            int r4 = r2 + (-1)
            if (r7 > r4) goto L68
            r4 = r7
            goto L6a
        L68:
            r4 = r7
            goto L4d
        L6a:
            int[] r6 = r9.zptr
            r6[r4] = r5
            int r4 = r3 + 2
            if (r4 <= r11) goto L73
        L72:
            goto L12
        L73:
            r5 = r6[r4]
        L75:
            int[] r6 = r9.zptr
            int r7 = r4 - r0
            r6 = r6[r7]
            int r6 = r6 + r12
            int r8 = r5 + r12
            boolean r6 = r9.fullGtU(r6, r8)
            if (r6 == 0) goto L92
            int[] r6 = r9.zptr
            r8 = r6[r7]
            r6[r4] = r8
            int r4 = r2 + (-1)
            if (r7 > r4) goto L90
            r4 = r7
            goto L92
        L90:
            r4 = r7
            goto L75
        L92:
            int[] r6 = r9.zptr
            r6[r4] = r5
            int r3 = r3 + 3
            int r4 = r9.workDone
            int r5 = r9.workLimit
            if (r4 <= r5) goto L1d
            boolean r4 = r9.firstAttempt
            if (r4 == 0) goto L1d
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.apache.bzip2.CBZip2OutputStream.simpleSort(int, int, int):void");
    }

    private void vswap(int i, int i2, int i3) {
        while (i3 > 0) {
            int[] iArr = this.zptr;
            int i4 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i4;
            i++;
            i2++;
            i3--;
        }
    }

    private void writeRun() throws IOException {
        int i;
        if (this.last >= this.allowableBlockSize) {
            endBlock();
            initBlock();
            writeRun();
            return;
        }
        this.inUse[this.currentChar] = true;
        int i2 = 0;
        while (true) {
            i = this.runLength;
            if (i2 >= i) {
                break;
            }
            this.mCrc.updateCRC((char) this.currentChar);
            i2++;
        }
        if (i == 1) {
            int i3 = this.last;
            this.last = i3 + 1;
            this.block[i3 + 2] = (char) this.currentChar;
            return;
        }
        if (i == 2) {
            int i4 = this.last;
            this.last = i4 + 1;
            char[] cArr = this.block;
            int i5 = this.currentChar;
            cArr[i4 + 2] = (char) i5;
            this.last = i4 + 2;
            cArr[i4 + 3] = (char) i5;
            return;
        }
        if (i == 3) {
            int i6 = this.last;
            this.last = i6 + 1;
            char[] cArr2 = this.block;
            int i7 = this.currentChar;
            cArr2[i6 + 2] = (char) i7;
            this.last = i6 + 2;
            cArr2[i6 + 3] = (char) i7;
            this.last = i6 + 3;
            cArr2[i6 + 4] = (char) i7;
            return;
        }
        this.inUse[i - 4] = true;
        int i8 = this.last;
        this.last = i8 + 1;
        char[] cArr3 = this.block;
        int i9 = this.currentChar;
        cArr3[i8 + 2] = (char) i9;
        this.last = i8 + 2;
        cArr3[i8 + 3] = (char) i9;
        this.last = i8 + 3;
        cArr3[i8 + 4] = (char) i9;
        this.last = i8 + 4;
        cArr3[i8 + 5] = (char) i9;
        this.last = i8 + 5;
        cArr3[i8 + 6] = (char) (i - 4);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        finish();
        this.closed = true;
        super.close();
        this.bsStream.close();
    }

    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }

    public void finish() throws IOException {
        if (this.finished) {
            return;
        }
        if (this.runLength > 0) {
            writeRun();
        }
        this.currentChar = -1;
        endBlock();
        endCompression();
        this.finished = true;
        flush();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        super.flush();
        this.bsStream.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        int i2;
        int i3 = (i + 256) % 256;
        int i4 = this.currentChar;
        if (i4 == -1) {
            this.currentChar = i3;
            i2 = this.runLength + 1;
        } else if (i4 != i3) {
            writeRun();
            this.runLength = 1;
            this.currentChar = i3;
            return;
        } else {
            int i5 = this.runLength + 1;
            this.runLength = i5;
            if (i5 <= 254) {
                return;
            }
            writeRun();
            this.currentChar = -1;
            i2 = 0;
        }
        this.runLength = i2;
    }
}
