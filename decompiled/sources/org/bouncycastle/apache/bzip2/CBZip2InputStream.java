package org.bouncycastle.apache.bzip2;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

/* loaded from: classes6.dex */
public class CBZip2InputStream extends InputStream implements BZip2Constants {
    private int[][] base;
    private boolean blockRandomised;
    private int blockSize100k;
    private int bsBuff;
    private int bsLive;
    private InputStream bsStream;
    int ch2;
    int chPrev;
    private int computedBlockCRC;
    private int computedCombinedCRC;
    int count;
    private int currentChar;
    private int currentState;
    int i;
    int i2;
    int j2;
    private int last;
    private int[][] limit;
    private char[] ll8;
    private int[] minLens;
    private int nInUse;
    private int origPtr;
    private int[][] perm;
    int rNToGo;
    int rTPos;
    private int storedBlockCRC;
    private int storedCombinedCRC;
    private boolean streamEnd;
    int tPos;
    private int[] tt;
    char z;
    private CRC mCrc = new CRC();
    private boolean[] inUse = new boolean[256];
    private char[] seqToUnseq = new char[256];
    private char[] unseqToSeq = new char[256];
    private char[] selector = new char[BZip2Constants.MAX_SELECTORS];
    private char[] selectorMtf = new char[BZip2Constants.MAX_SELECTORS];
    private int[] unzftab = new int[256];

    public CBZip2InputStream(InputStream inputStream) throws IOException {
        int[] iArr = {6, BZip2Constants.MAX_ALPHA_SIZE};
        Class cls = Integer.TYPE;
        this.limit = (int[][]) Array.newInstance((Class<?>) cls, iArr);
        this.base = (int[][]) Array.newInstance((Class<?>) cls, 6, BZip2Constants.MAX_ALPHA_SIZE);
        this.perm = (int[][]) Array.newInstance((Class<?>) cls, 6, BZip2Constants.MAX_ALPHA_SIZE);
        this.minLens = new int[6];
        this.streamEnd = false;
        this.currentChar = -1;
        this.currentState = 1;
        this.rNToGo = 0;
        this.rTPos = 0;
        this.ll8 = null;
        this.tt = null;
        bsSetStream(inputStream);
        initialize();
        initBlock();
        setupBlock();
    }

    private static void badBlockHeader() {
        cadvise();
    }

    private static void blockOverrun() {
        cadvise();
    }

    private void bsFinishedWithStream() throws IOException {
        try {
            InputStream inputStream = this.bsStream;
            if (inputStream == null || inputStream == System.in) {
                return;
            }
            inputStream.close();
            this.bsStream = null;
        } catch (IOException unused) {
        }
    }

    private int bsGetInt32() {
        return bsGetint();
    }

    private int bsGetIntVS(int i) {
        return bsR(i);
    }

    private char bsGetUChar() {
        return (char) bsR(8);
    }

    private int bsGetint() {
        return bsR(8) | (((((bsR(8) << 8) | bsR(8)) << 8) | bsR(8)) << 8);
    }

    private int bsR(int i) {
        char c;
        while (true) {
            int i2 = this.bsLive;
            if (i2 >= i) {
                int i3 = (this.bsBuff >> (i2 - i)) & ((1 << i) - 1);
                this.bsLive = i2 - i;
                return i3;
            }
            try {
                c = (char) this.bsStream.read();
            } catch (IOException unused) {
                compressedStreamEOF();
                c = 0;
            }
            if (c == 65535) {
                compressedStreamEOF();
            }
            this.bsBuff = (c & 255) | (this.bsBuff << 8);
            this.bsLive += 8;
        }
    }

    private void bsSetStream(InputStream inputStream) {
        this.bsStream = inputStream;
        this.bsLive = 0;
        this.bsBuff = 0;
    }

    private static void cadvise() {
        System.out.println("CRC Error");
    }

    private void complete() throws IOException {
        int iBsGetInt32 = bsGetInt32();
        this.storedCombinedCRC = iBsGetInt32;
        if (iBsGetInt32 != this.computedCombinedCRC) {
            crcError();
        }
        bsFinishedWithStream();
        this.streamEnd = true;
    }

    private static void compressedStreamEOF() {
        cadvise();
    }

    private static void crcError() {
        cadvise();
    }

    private void endBlock() {
        int finalCRC = this.mCrc.getFinalCRC();
        this.computedBlockCRC = finalCRC;
        if (this.storedBlockCRC != finalCRC) {
            crcError();
        }
        int i = this.computedCombinedCRC;
        this.computedCombinedCRC = ((i >>> 31) | (i << 1)) ^ this.computedBlockCRC;
    }

    private void getAndMoveToFrontDecode() {
        char c;
        int i;
        char c2;
        int i2;
        char c3;
        int i3;
        char c4;
        char[] cArr = new char[256];
        int i4 = this.blockSize100k * 100000;
        this.origPtr = bsGetIntVS(24);
        recvDecodingTables();
        int i5 = this.nInUse + 1;
        int i6 = 0;
        while (true) {
            c = 255;
            if (i6 > 255) {
                break;
            }
            this.unzftab[i6] = 0;
            i6++;
        }
        for (int i7 = 0; i7 <= 255; i7++) {
            cArr[i7] = (char) i7;
        }
        char c5 = 65535;
        this.last = -1;
        char c6 = this.selector[0];
        int i8 = this.minLens[c6];
        int iBsR = bsR(i8);
        while (iBsR > this.limit[c6][i8]) {
            i8++;
            while (true) {
                i3 = this.bsLive;
                if (i3 < 1) {
                    try {
                        c4 = (char) this.bsStream.read();
                    } catch (IOException unused) {
                        compressedStreamEOF();
                        c4 = 0;
                    }
                    if (c4 == 65535) {
                        compressedStreamEOF();
                    }
                    this.bsBuff = (c4 & 255) | (this.bsBuff << 8);
                    this.bsLive += 8;
                }
            }
            int i9 = (this.bsBuff >> (i3 - 1)) & 1;
            this.bsLive = i3 - 1;
            iBsR = (iBsR << 1) | i9;
        }
        int i10 = this.perm[c6][iBsR - this.base[c6][i8]];
        int i11 = 49;
        int i12 = 0;
        while (i10 != i5) {
            if (i10 == 0 || i10 == 1) {
                int i13 = 1;
                int i14 = c5;
                while (true) {
                    if (i10 == 0) {
                        i14 += i13;
                    } else if (i10 == 1) {
                        i14 += i13 * 2;
                    }
                    i13 *= 2;
                    if (i11 == 0) {
                        i12++;
                        i11 = 50;
                    }
                    i11 += c5;
                    char c7 = this.selector[i12];
                    int i15 = this.minLens[c7];
                    int iBsR2 = bsR(i15);
                    while (iBsR2 > this.limit[c7][i15]) {
                        i15++;
                        while (true) {
                            i = this.bsLive;
                            if (i < 1) {
                                try {
                                    c2 = (char) this.bsStream.read();
                                } catch (IOException unused2) {
                                    compressedStreamEOF();
                                    c2 = 0;
                                }
                                if (c2 == c5) {
                                    compressedStreamEOF();
                                }
                                this.bsBuff = (this.bsBuff << 8) | (c2 & 255);
                                this.bsLive += 8;
                                c5 = 65535;
                            }
                        }
                        int i16 = (this.bsBuff >> (i - 1)) & 1;
                        this.bsLive = i - 1;
                        iBsR2 = (iBsR2 << 1) | i16;
                        c5 = 65535;
                    }
                    i10 = this.perm[c7][iBsR2 - this.base[c7][i15]];
                    if (i10 != 0 && i10 != 1) {
                        break;
                    } else {
                        c5 = 65535;
                    }
                }
                int i17 = i14 + 1;
                char c8 = this.seqToUnseq[cArr[0]];
                int[] iArr = this.unzftab;
                iArr[c8] = iArr[c8] + i17;
                while (i17 > 0) {
                    int i18 = this.last + 1;
                    this.last = i18;
                    this.ll8[i18] = c8;
                    i17--;
                }
                if (this.last >= i4) {
                    blockOverrun();
                }
                c5 = 65535;
                c = 255;
            } else {
                int i19 = this.last + 1;
                this.last = i19;
                if (i19 >= i4) {
                    blockOverrun();
                }
                int i20 = i10 - 1;
                char c9 = cArr[i20];
                int[] iArr2 = this.unzftab;
                char c10 = this.seqToUnseq[c9];
                iArr2[c10] = iArr2[c10] + 1;
                this.ll8[this.last] = c10;
                while (i20 > 3) {
                    int i21 = i20 - 1;
                    cArr[i20] = cArr[i21];
                    int i22 = i20 - 2;
                    cArr[i21] = cArr[i22];
                    int i23 = i20 - 3;
                    cArr[i22] = cArr[i23];
                    cArr[i23] = cArr[i20 - 4];
                    i20 -= 4;
                }
                while (i20 > 0) {
                    cArr[i20] = cArr[i20 - 1];
                    i20--;
                }
                cArr[0] = c9;
                if (i11 == 0) {
                    i12++;
                    i11 = 50;
                }
                i11 += c5;
                char c11 = this.selector[i12];
                int i24 = this.minLens[c11];
                int iBsR3 = bsR(i24);
                while (iBsR3 > this.limit[c11][i24]) {
                    i24++;
                    while (true) {
                        i2 = this.bsLive;
                        if (i2 < 1) {
                            try {
                                c3 = (char) this.bsStream.read();
                            } catch (IOException unused3) {
                                compressedStreamEOF();
                                c3 = 0;
                            }
                            this.bsBuff = (c3 & c) | (this.bsBuff << 8);
                            this.bsLive += 8;
                        }
                    }
                    int i25 = (this.bsBuff >> (i2 - 1)) & 1;
                    this.bsLive = i2 - 1;
                    iBsR3 = (iBsR3 << 1) | i25;
                }
                i10 = this.perm[c11][iBsR3 - this.base[c11][i24]];
            }
        }
    }

    private void hbCreateDecodeTables(int[] iArr, int[] iArr2, int[] iArr3, char[] cArr, int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        for (int i6 = i; i6 <= i2; i6++) {
            for (int i7 = 0; i7 < i3; i7++) {
                if (cArr[i7] == i6) {
                    iArr3[i5] = i7;
                    i5++;
                }
            }
        }
        for (int i8 = 0; i8 < 23; i8++) {
            iArr2[i8] = 0;
        }
        for (int i9 = 0; i9 < i3; i9++) {
            int i10 = cArr[i9] + 1;
            iArr2[i10] = iArr2[i10] + 1;
        }
        for (int i11 = 1; i11 < 23; i11++) {
            iArr2[i11] = iArr2[i11] + iArr2[i11 - 1];
        }
        for (int i12 = 0; i12 < 23; i12++) {
            iArr[i12] = 0;
        }
        int i13 = i;
        while (i13 <= i2) {
            int i14 = i13 + 1;
            int i15 = i4 + (iArr2[i14] - iArr2[i13]);
            iArr[i13] = i15 - 1;
            i4 = i15 << 1;
            i13 = i14;
        }
        for (int i16 = i + 1; i16 <= i2; i16++) {
            iArr2[i16] = ((iArr[i16 - 1] + 1) << 1) - iArr2[i16];
        }
    }

    private void initBlock() throws IOException {
        char cBsGetUChar = bsGetUChar();
        char cBsGetUChar2 = bsGetUChar();
        char cBsGetUChar3 = bsGetUChar();
        char cBsGetUChar4 = bsGetUChar();
        char cBsGetUChar5 = bsGetUChar();
        char cBsGetUChar6 = bsGetUChar();
        if (cBsGetUChar == 23 && cBsGetUChar2 == 'r' && cBsGetUChar3 == 'E' && cBsGetUChar4 == '8' && cBsGetUChar5 == 'P' && cBsGetUChar6 == 144) {
            complete();
            return;
        }
        if (cBsGetUChar != '1' || cBsGetUChar2 != 'A' || cBsGetUChar3 != 'Y' || cBsGetUChar4 != '&' || cBsGetUChar5 != 'S' || cBsGetUChar6 != 'Y') {
            badBlockHeader();
            this.streamEnd = true;
            return;
        }
        this.storedBlockCRC = bsGetInt32();
        if (bsR(1) == 1) {
            this.blockRandomised = true;
        } else {
            this.blockRandomised = false;
        }
        getAndMoveToFrontDecode();
        this.mCrc.initialiseCRC();
        this.currentState = 1;
    }

    private void initialize() throws IOException {
        char cBsGetUChar = bsGetUChar();
        char cBsGetUChar2 = bsGetUChar();
        if (cBsGetUChar != 'B' && cBsGetUChar2 != 'Z') {
            throw new IOException("Not a BZIP2 marked stream");
        }
        char cBsGetUChar3 = bsGetUChar();
        char cBsGetUChar4 = bsGetUChar();
        if (cBsGetUChar3 != 'h' || cBsGetUChar4 < '1' || cBsGetUChar4 > '9') {
            bsFinishedWithStream();
            this.streamEnd = true;
        } else {
            setDecompressStructureSizes(cBsGetUChar4 - '0');
            this.computedCombinedCRC = 0;
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

    private void recvDecodingTables() {
        char[][] cArr = (char[][]) Array.newInstance((Class<?>) Character.TYPE, 6, BZip2Constants.MAX_ALPHA_SIZE);
        boolean[] zArr = new boolean[16];
        for (int i = 0; i < 16; i++) {
            if (bsR(1) == 1) {
                zArr[i] = true;
            } else {
                zArr[i] = false;
            }
        }
        for (int i2 = 0; i2 < 256; i2++) {
            this.inUse[i2] = false;
        }
        for (int i3 = 0; i3 < 16; i3++) {
            if (zArr[i3]) {
                for (int i4 = 0; i4 < 16; i4++) {
                    if (bsR(1) == 1) {
                        this.inUse[(i3 * 16) + i4] = true;
                    }
                }
            }
        }
        makeMaps();
        int i5 = this.nInUse + 2;
        int iBsR = bsR(3);
        int iBsR2 = bsR(15);
        for (int i6 = 0; i6 < iBsR2; i6++) {
            int i7 = 0;
            while (bsR(1) == 1) {
                i7++;
            }
            this.selectorMtf[i6] = (char) i7;
        }
        char[] cArr2 = new char[6];
        for (char c = 0; c < iBsR; c = (char) (c + 1)) {
            cArr2[c] = c;
        }
        for (int i8 = 0; i8 < iBsR2; i8++) {
            char c2 = this.selectorMtf[i8];
            char c3 = cArr2[c2];
            while (c2 > 0) {
                int i9 = c2 - 1;
                cArr2[c2] = cArr2[i9];
                c2 = (char) i9;
            }
            cArr2[0] = c3;
            this.selector[i8] = c3;
        }
        for (int i10 = 0; i10 < iBsR; i10++) {
            int iBsR3 = bsR(5);
            for (int i11 = 0; i11 < i5; i11++) {
                while (bsR(1) == 1) {
                    iBsR3 = bsR(1) == 0 ? iBsR3 + 1 : iBsR3 - 1;
                }
                cArr[i10][i11] = (char) iBsR3;
            }
        }
        for (int i12 = 0; i12 < iBsR; i12++) {
            char c4 = ' ';
            char c5 = 0;
            for (int i13 = 0; i13 < i5; i13++) {
                char c6 = cArr[i12][i13];
                if (c6 > c5) {
                    c5 = c6;
                }
                if (c6 < c4) {
                    c4 = c6;
                }
            }
            hbCreateDecodeTables(this.limit[i12], this.base[i12], this.perm[i12], cArr[i12], c4, c5, i5);
            this.minLens[i12] = c4;
        }
    }

    private void setDecompressStructureSizes(int i) {
        this.blockSize100k = i;
        if (i == 0) {
            return;
        }
        int i2 = i * 100000;
        this.ll8 = new char[i2];
        this.tt = new int[i2];
    }

    private void setupBlock() throws IOException {
        int[] iArr = new int[257];
        iArr[0] = 0;
        this.i = 1;
        while (true) {
            int i = this.i;
            if (i > 256) {
                break;
            }
            iArr[i] = this.unzftab[i - 1];
            this.i = i + 1;
        }
        this.i = 1;
        while (true) {
            int i2 = this.i;
            if (i2 > 256) {
                break;
            }
            iArr[i2] = iArr[i2] + iArr[i2 - 1];
            this.i = i2 + 1;
        }
        this.i = 0;
        while (true) {
            int i3 = this.i;
            if (i3 > this.last) {
                break;
            }
            char c = this.ll8[i3];
            this.tt[iArr[c]] = i3;
            iArr[c] = iArr[c] + 1;
            this.i = i3 + 1;
        }
        this.tPos = this.tt[this.origPtr];
        this.count = 0;
        this.i2 = 0;
        this.ch2 = 256;
        if (!this.blockRandomised) {
            setupNoRandPartA();
            return;
        }
        this.rNToGo = 0;
        this.rTPos = 0;
        setupRandPartA();
    }

    private void setupNoRandPartA() throws IOException {
        int i = this.i2;
        if (i > this.last) {
            endBlock();
            initBlock();
            setupBlock();
            return;
        }
        this.chPrev = this.ch2;
        char[] cArr = this.ll8;
        int i2 = this.tPos;
        char c = cArr[i2];
        this.ch2 = c;
        this.tPos = this.tt[i2];
        this.i2 = i + 1;
        this.currentChar = c;
        this.currentState = 6;
        this.mCrc.updateCRC(c);
    }

    private void setupNoRandPartB() throws IOException {
        if (this.ch2 != this.chPrev) {
            this.currentState = 5;
            this.count = 1;
        } else {
            int i = this.count + 1;
            this.count = i;
            if (i >= 4) {
                char[] cArr = this.ll8;
                int i2 = this.tPos;
                this.z = cArr[i2];
                this.tPos = this.tt[i2];
                this.currentState = 7;
                this.j2 = 0;
                setupNoRandPartC();
                return;
            }
            this.currentState = 5;
        }
        setupNoRandPartA();
    }

    private void setupNoRandPartC() throws IOException {
        if (this.j2 < this.z) {
            int i = this.ch2;
            this.currentChar = i;
            this.mCrc.updateCRC(i);
            this.j2++;
            return;
        }
        this.currentState = 5;
        this.i2++;
        this.count = 0;
        setupNoRandPartA();
    }

    private void setupRandPartA() throws IOException {
        int i = this.i2;
        if (i > this.last) {
            endBlock();
            initBlock();
            setupBlock();
            return;
        }
        this.chPrev = this.ch2;
        char[] cArr = this.ll8;
        int i2 = this.tPos;
        char c = cArr[i2];
        this.ch2 = c;
        this.tPos = this.tt[i2];
        if (this.rNToGo == 0) {
            int[] iArr = BZip2Constants.rNums;
            int i3 = this.rTPos;
            this.rNToGo = iArr[i3];
            int i4 = i3 + 1;
            this.rTPos = i4;
            if (i4 == 512) {
                this.rTPos = 0;
            }
        }
        int i5 = this.rNToGo - 1;
        this.rNToGo = i5;
        int i6 = c ^ (i5 == 1 ? (char) 1 : (char) 0);
        this.ch2 = i6;
        this.i2 = i + 1;
        this.currentChar = i6;
        this.currentState = 3;
        this.mCrc.updateCRC(i6);
    }

    private void setupRandPartB() throws IOException {
        if (this.ch2 != this.chPrev) {
            this.currentState = 2;
            this.count = 1;
        } else {
            int i = this.count + 1;
            this.count = i;
            if (i >= 4) {
                char[] cArr = this.ll8;
                int i2 = this.tPos;
                char c = cArr[i2];
                this.z = c;
                this.tPos = this.tt[i2];
                if (this.rNToGo == 0) {
                    int[] iArr = BZip2Constants.rNums;
                    int i3 = this.rTPos;
                    this.rNToGo = iArr[i3];
                    int i4 = i3 + 1;
                    this.rTPos = i4;
                    if (i4 == 512) {
                        this.rTPos = 0;
                    }
                }
                int i5 = this.rNToGo - 1;
                this.rNToGo = i5;
                this.z = (char) (c ^ (i5 != 1 ? (char) 0 : (char) 1));
                this.j2 = 0;
                this.currentState = 4;
                setupRandPartC();
                return;
            }
            this.currentState = 2;
        }
        setupRandPartA();
    }

    private void setupRandPartC() throws IOException {
        if (this.j2 < this.z) {
            int i = this.ch2;
            this.currentChar = i;
            this.mCrc.updateCRC(i);
            this.j2++;
            return;
        }
        this.currentState = 2;
        this.i2++;
        this.count = 0;
        setupRandPartA();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.streamEnd) {
            return -1;
        }
        int i = this.currentChar;
        int i2 = this.currentState;
        if (i2 == 3) {
            setupRandPartB();
        } else if (i2 == 4) {
            setupRandPartC();
        } else if (i2 == 6) {
            setupNoRandPartB();
        } else if (i2 == 7) {
            setupNoRandPartC();
        }
        return i;
    }
}
