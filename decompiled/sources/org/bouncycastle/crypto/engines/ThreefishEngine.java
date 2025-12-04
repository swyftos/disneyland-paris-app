package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.TweakableBlockCipherParameters;

/* loaded from: classes6.dex */
public class ThreefishEngine implements BlockCipher {
    public static final int BLOCKSIZE_1024 = 1024;
    public static final int BLOCKSIZE_256 = 256;
    public static final int BLOCKSIZE_512 = 512;
    private static int[] MOD17;
    private static int[] MOD3;
    private static int[] MOD5;
    private static int[] MOD9;
    private int blocksizeBytes;
    private int blocksizeWords;
    private ThreefishCipher cipher;
    private long[] currentBlock;
    private boolean forEncryption;
    private long[] kw;
    private long[] t;

    private static final class Threefish1024Cipher extends ThreefishCipher {
        public Threefish1024Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        void decryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] iArr = ThreefishEngine.MOD17;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 33) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j = jArr[0];
            int i = 1;
            long j2 = jArr[1];
            long j3 = jArr[2];
            long j4 = jArr[3];
            long j5 = jArr[4];
            long j6 = jArr[5];
            long j7 = jArr[6];
            long j8 = jArr[7];
            long j9 = jArr[8];
            long j10 = jArr[9];
            long j11 = jArr[10];
            long j12 = jArr[11];
            long j13 = jArr[12];
            long j14 = jArr[13];
            long j15 = jArr[14];
            long jXorRotr = jArr[15];
            int i2 = 19;
            while (i2 >= i) {
                int i3 = iArr[i2];
                int i4 = iArr2[i2];
                int i5 = i3 + 1;
                long j16 = j - jArr3[i5];
                int i6 = i3 + 2;
                long j17 = j2 - jArr3[i6];
                int i7 = i3 + 3;
                long j18 = j3 - jArr3[i7];
                int i8 = i3 + 4;
                long j19 = j4 - jArr3[i8];
                int i9 = i3 + 5;
                long j20 = j5 - jArr3[i9];
                int i10 = i3 + 6;
                long j21 = j6 - jArr3[i10];
                int i11 = i3 + 7;
                int[] iArr3 = iArr;
                long j22 = j7 - jArr3[i11];
                int i12 = i3 + 8;
                long j23 = j8 - jArr3[i12];
                int i13 = i3 + 9;
                long j24 = j9 - jArr3[i13];
                int i14 = i3 + 10;
                long j25 = j10 - jArr3[i14];
                int i15 = i3 + 11;
                long j26 = j11 - jArr3[i15];
                int i16 = i3 + 12;
                long j27 = j12 - jArr3[i16];
                int i17 = i3 + 13;
                long j28 = j13 - jArr3[i17];
                int i18 = i3 + 14;
                int i19 = i4 + 1;
                long j29 = j14 - (jArr3[i18] + jArr4[i19]);
                int i20 = i3 + 15;
                long j30 = j15 - (jArr3[i20] + jArr4[i4 + 2]);
                long[] jArr5 = jArr4;
                long[] jArr6 = jArr3;
                long j31 = i2;
                long jXorRotr2 = ThreefishEngine.xorRotr(jXorRotr - ((jArr3[i3 + 16] + j31) + 1), 9, j16);
                long j32 = j16 - jXorRotr2;
                long jXorRotr3 = ThreefishEngine.xorRotr(j27, 48, j18);
                long j33 = j18 - jXorRotr3;
                long jXorRotr4 = ThreefishEngine.xorRotr(j29, 35, j22);
                long j34 = j22 - jXorRotr4;
                long jXorRotr5 = ThreefishEngine.xorRotr(j25, 52, j20);
                long j35 = j20 - jXorRotr5;
                long jXorRotr6 = ThreefishEngine.xorRotr(j17, 23, j30);
                long j36 = j30 - jXorRotr6;
                long jXorRotr7 = ThreefishEngine.xorRotr(j21, 31, j24);
                long j37 = j24 - jXorRotr7;
                long jXorRotr8 = ThreefishEngine.xorRotr(j19, 37, j26);
                long j38 = j26 - jXorRotr8;
                long jXorRotr9 = ThreefishEngine.xorRotr(j23, 20, j28);
                long j39 = j28 - jXorRotr9;
                long jXorRotr10 = ThreefishEngine.xorRotr(jXorRotr9, 31, j32);
                long j40 = j32 - jXorRotr10;
                long jXorRotr11 = ThreefishEngine.xorRotr(jXorRotr7, 44, j33);
                long j41 = j33 - jXorRotr11;
                long jXorRotr12 = ThreefishEngine.xorRotr(jXorRotr8, 47, j35);
                long j42 = j35 - jXorRotr12;
                long jXorRotr13 = ThreefishEngine.xorRotr(jXorRotr6, 46, j34);
                long j43 = j34 - jXorRotr13;
                long jXorRotr14 = ThreefishEngine.xorRotr(jXorRotr2, 19, j39);
                long j44 = j39 - jXorRotr14;
                long jXorRotr15 = ThreefishEngine.xorRotr(jXorRotr4, 42, j36);
                long j45 = j36 - jXorRotr15;
                long jXorRotr16 = ThreefishEngine.xorRotr(jXorRotr3, 44, j37);
                long j46 = j37 - jXorRotr16;
                long jXorRotr17 = ThreefishEngine.xorRotr(jXorRotr5, 25, j38);
                long j47 = j38 - jXorRotr17;
                long jXorRotr18 = ThreefishEngine.xorRotr(jXorRotr17, 16, j40);
                long j48 = j40 - jXorRotr18;
                long jXorRotr19 = ThreefishEngine.xorRotr(jXorRotr15, 34, j41);
                long j49 = j41 - jXorRotr19;
                long jXorRotr20 = ThreefishEngine.xorRotr(jXorRotr16, 56, j43);
                long j50 = j43 - jXorRotr20;
                long jXorRotr21 = ThreefishEngine.xorRotr(jXorRotr14, 51, j42);
                long j51 = j42 - jXorRotr21;
                long jXorRotr22 = ThreefishEngine.xorRotr(jXorRotr10, 4, j47);
                long j52 = j47 - jXorRotr22;
                long jXorRotr23 = ThreefishEngine.xorRotr(jXorRotr12, 53, j44);
                long j53 = j44 - jXorRotr23;
                long jXorRotr24 = ThreefishEngine.xorRotr(jXorRotr11, 42, j45);
                long j54 = j45 - jXorRotr24;
                long jXorRotr25 = ThreefishEngine.xorRotr(jXorRotr13, 41, j46);
                long j55 = j46 - jXorRotr25;
                long jXorRotr26 = ThreefishEngine.xorRotr(jXorRotr25, 41, j48);
                long jXorRotr27 = ThreefishEngine.xorRotr(jXorRotr23, 9, j49);
                long jXorRotr28 = ThreefishEngine.xorRotr(jXorRotr24, 37, j51);
                long j56 = j51 - jXorRotr28;
                long jXorRotr29 = ThreefishEngine.xorRotr(jXorRotr22, 31, j50);
                long j57 = j50 - jXorRotr29;
                long jXorRotr30 = ThreefishEngine.xorRotr(jXorRotr18, 12, j55);
                long j58 = j55 - jXorRotr30;
                long jXorRotr31 = ThreefishEngine.xorRotr(jXorRotr20, 47, j52);
                long j59 = j52 - jXorRotr31;
                long jXorRotr32 = ThreefishEngine.xorRotr(jXorRotr19, 44, j53);
                long j60 = j53 - jXorRotr32;
                long jXorRotr33 = ThreefishEngine.xorRotr(jXorRotr21, 30, j54);
                long j61 = j54 - jXorRotr33;
                long j62 = (j48 - jXorRotr26) - jArr6[i3];
                long j63 = jXorRotr26 - jArr6[i5];
                long j64 = (j49 - jXorRotr27) - jArr6[i6];
                long j65 = jXorRotr27 - jArr6[i7];
                long j66 = j56 - jArr6[i8];
                long j67 = jXorRotr28 - jArr6[i9];
                long j68 = j57 - jArr6[i10];
                long j69 = jXorRotr29 - jArr6[i11];
                long j70 = j58 - jArr6[i12];
                long j71 = jXorRotr30 - jArr6[i13];
                long j72 = j59 - jArr6[i14];
                long j73 = jXorRotr31 - jArr6[i15];
                long j74 = j60 - jArr6[i16];
                long j75 = jXorRotr32 - (jArr6[i17] + jArr5[i4]);
                long j76 = j61 - (jArr6[i18] + jArr5[i19]);
                long jXorRotr34 = ThreefishEngine.xorRotr(jXorRotr33 - (jArr6[i20] + j31), 5, j62);
                long j77 = j62 - jXorRotr34;
                long jXorRotr35 = ThreefishEngine.xorRotr(j73, 20, j64);
                long j78 = j64 - jXorRotr35;
                long jXorRotr36 = ThreefishEngine.xorRotr(j75, 48, j68);
                long j79 = j68 - jXorRotr36;
                long jXorRotr37 = ThreefishEngine.xorRotr(j71, 41, j66);
                long j80 = j66 - jXorRotr37;
                long jXorRotr38 = ThreefishEngine.xorRotr(j63, 47, j76);
                long j81 = j76 - jXorRotr38;
                long jXorRotr39 = ThreefishEngine.xorRotr(j67, 28, j70);
                long j82 = j70 - jXorRotr39;
                long jXorRotr40 = ThreefishEngine.xorRotr(j65, 16, j72);
                long j83 = j72 - jXorRotr40;
                long jXorRotr41 = ThreefishEngine.xorRotr(j69, 25, j74);
                long j84 = j74 - jXorRotr41;
                long jXorRotr42 = ThreefishEngine.xorRotr(jXorRotr41, 33, j77);
                long j85 = j77 - jXorRotr42;
                long jXorRotr43 = ThreefishEngine.xorRotr(jXorRotr39, 4, j78);
                long j86 = j78 - jXorRotr43;
                long jXorRotr44 = ThreefishEngine.xorRotr(jXorRotr40, 51, j80);
                long j87 = j80 - jXorRotr44;
                long jXorRotr45 = ThreefishEngine.xorRotr(jXorRotr38, 13, j79);
                long j88 = j79 - jXorRotr45;
                long jXorRotr46 = ThreefishEngine.xorRotr(jXorRotr34, 34, j84);
                long j89 = j84 - jXorRotr46;
                long jXorRotr47 = ThreefishEngine.xorRotr(jXorRotr36, 41, j81);
                long j90 = j81 - jXorRotr47;
                long jXorRotr48 = ThreefishEngine.xorRotr(jXorRotr35, 59, j82);
                long j91 = j82 - jXorRotr48;
                long jXorRotr49 = ThreefishEngine.xorRotr(jXorRotr37, 17, j83);
                long j92 = j83 - jXorRotr49;
                long jXorRotr50 = ThreefishEngine.xorRotr(jXorRotr49, 38, j85);
                long j93 = j85 - jXorRotr50;
                long jXorRotr51 = ThreefishEngine.xorRotr(jXorRotr47, 19, j86);
                long j94 = j86 - jXorRotr51;
                long jXorRotr52 = ThreefishEngine.xorRotr(jXorRotr48, 10, j88);
                long j95 = j88 - jXorRotr52;
                long jXorRotr53 = ThreefishEngine.xorRotr(jXorRotr46, 55, j87);
                long j96 = j87 - jXorRotr53;
                long jXorRotr54 = ThreefishEngine.xorRotr(jXorRotr42, 49, j92);
                long j97 = j92 - jXorRotr54;
                long jXorRotr55 = ThreefishEngine.xorRotr(jXorRotr44, 18, j89);
                long j98 = j89 - jXorRotr55;
                long jXorRotr56 = ThreefishEngine.xorRotr(jXorRotr43, 23, j90);
                long j99 = j90 - jXorRotr56;
                long jXorRotr57 = ThreefishEngine.xorRotr(jXorRotr45, 52, j91);
                long j100 = j91 - jXorRotr57;
                long jXorRotr58 = ThreefishEngine.xorRotr(jXorRotr57, 24, j93);
                j = j93 - jXorRotr58;
                long jXorRotr59 = ThreefishEngine.xorRotr(jXorRotr55, 13, j94);
                j3 = j94 - jXorRotr59;
                long jXorRotr60 = ThreefishEngine.xorRotr(jXorRotr56, 8, j96);
                long j101 = j96 - jXorRotr60;
                long jXorRotr61 = ThreefishEngine.xorRotr(jXorRotr54, 47, j95);
                long j102 = j95 - jXorRotr61;
                long jXorRotr62 = ThreefishEngine.xorRotr(jXorRotr50, 8, j100);
                long j103 = j100 - jXorRotr62;
                long jXorRotr63 = ThreefishEngine.xorRotr(jXorRotr52, 17, j97);
                long j104 = j97 - jXorRotr63;
                long jXorRotr64 = ThreefishEngine.xorRotr(jXorRotr51, 22, j98);
                long j105 = j98 - jXorRotr64;
                jXorRotr = ThreefishEngine.xorRotr(jXorRotr53, 37, j99);
                j15 = j99 - jXorRotr;
                j12 = jXorRotr63;
                iArr = iArr3;
                iArr2 = iArr2;
                jArr3 = jArr6;
                j9 = j103;
                j4 = jXorRotr59;
                i2 -= 2;
                jArr4 = jArr5;
                i = 1;
                j2 = jXorRotr58;
                j8 = jXorRotr61;
                j11 = j104;
                j14 = jXorRotr64;
                j7 = j102;
                j13 = j105;
                j6 = jXorRotr60;
                j5 = j101;
                j10 = jXorRotr62;
            }
            long[] jArr7 = jArr4;
            long[] jArr8 = jArr3;
            long j106 = j - jArr8[0];
            long j107 = j2 - jArr8[1];
            long j108 = j3 - jArr8[2];
            long j109 = j4 - jArr8[3];
            long j110 = j5 - jArr8[4];
            long j111 = j6 - jArr8[5];
            long j112 = j7 - jArr8[6];
            long j113 = j8 - jArr8[7];
            long j114 = j9 - jArr8[8];
            long j115 = j10 - jArr8[9];
            long j116 = j11 - jArr8[10];
            long j117 = j12 - jArr8[11];
            long j118 = j13 - jArr8[12];
            long j119 = j14 - (jArr8[13] + jArr7[0]);
            long j120 = j15 - (jArr8[14] + jArr7[1]);
            long j121 = jXorRotr - jArr8[15];
            jArr2[0] = j106;
            jArr2[1] = j107;
            jArr2[2] = j108;
            jArr2[3] = j109;
            jArr2[4] = j110;
            jArr2[5] = j111;
            jArr2[6] = j112;
            jArr2[7] = j113;
            jArr2[8] = j114;
            jArr2[9] = j115;
            jArr2[10] = j116;
            jArr2[11] = j117;
            jArr2[12] = j118;
            jArr2[13] = j119;
            jArr2[14] = j120;
            jArr2[15] = j121;
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        void encryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] iArr = ThreefishEngine.MOD17;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 33) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j = jArr[0];
            int i = 1;
            long j2 = jArr[1];
            long j3 = jArr[2];
            long j4 = jArr[3];
            long j5 = jArr[4];
            long j6 = jArr[5];
            long j7 = jArr[6];
            long j8 = jArr[7];
            long j9 = jArr[8];
            long j10 = jArr[9];
            long j11 = jArr[10];
            long j12 = jArr[11];
            long j13 = jArr[12];
            int i2 = 13;
            long j14 = jArr[13];
            long j15 = jArr[14];
            long j16 = jArr[15];
            long j17 = j + jArr3[0];
            long j18 = j2 + jArr3[1];
            long j19 = j3 + jArr3[2];
            long j20 = j4 + jArr3[3];
            long j21 = j5 + jArr3[4];
            long j22 = j6 + jArr3[5];
            long j23 = j7 + jArr3[6];
            long j24 = j8 + jArr3[7];
            long j25 = j9 + jArr3[8];
            long j26 = j10 + jArr3[9];
            long j27 = j11 + jArr3[10];
            long j28 = j12 + jArr3[11];
            long j29 = j13 + jArr3[12];
            long j30 = j14 + jArr3[13] + jArr4[0];
            long j31 = j15 + jArr3[14] + jArr4[1];
            long j32 = j20;
            long j33 = j22;
            long j34 = j24;
            long j35 = j26;
            long j36 = j28;
            long j37 = j30;
            long j38 = j16 + jArr3[15];
            while (i < 20) {
                int i3 = iArr[i];
                int i4 = iArr2[i];
                long j39 = j17 + j18;
                long jRotlXor = ThreefishEngine.rotlXor(j18, 24, j39);
                long j40 = j19 + j32;
                long jRotlXor2 = ThreefishEngine.rotlXor(j32, i2, j40);
                long j41 = j33;
                long j42 = j21 + j41;
                long jRotlXor3 = ThreefishEngine.rotlXor(j41, 8, j42);
                long j43 = j34;
                int[] iArr3 = iArr;
                long j44 = j23 + j43;
                long jRotlXor4 = ThreefishEngine.rotlXor(j43, 47, j44);
                long[] jArr5 = jArr4;
                long[] jArr6 = jArr3;
                int i5 = i;
                long j45 = j35;
                long j46 = j25 + j45;
                long jRotlXor5 = ThreefishEngine.rotlXor(j45, 8, j46);
                long j47 = j36;
                long j48 = j27 + j47;
                long jRotlXor6 = ThreefishEngine.rotlXor(j47, 17, j48);
                long j49 = j37;
                long j50 = j29 + j49;
                long jRotlXor7 = ThreefishEngine.rotlXor(j49, 22, j50);
                long j51 = j38;
                long j52 = j31 + j51;
                long jRotlXor8 = ThreefishEngine.rotlXor(j51, 37, j52);
                long j53 = j39 + jRotlXor5;
                long jRotlXor9 = ThreefishEngine.rotlXor(jRotlXor5, 38, j53);
                long j54 = j40 + jRotlXor7;
                long jRotlXor10 = ThreefishEngine.rotlXor(jRotlXor7, 19, j54);
                long j55 = j44 + jRotlXor6;
                long jRotlXor11 = ThreefishEngine.rotlXor(jRotlXor6, 10, j55);
                long j56 = j42 + jRotlXor8;
                long jRotlXor12 = ThreefishEngine.rotlXor(jRotlXor8, 55, j56);
                long j57 = j48 + jRotlXor4;
                long jRotlXor13 = ThreefishEngine.rotlXor(jRotlXor4, 49, j57);
                long j58 = j50 + jRotlXor2;
                long jRotlXor14 = ThreefishEngine.rotlXor(jRotlXor2, 18, j58);
                long j59 = j52 + jRotlXor3;
                long jRotlXor15 = ThreefishEngine.rotlXor(jRotlXor3, 23, j59);
                long j60 = j46 + jRotlXor;
                long jRotlXor16 = ThreefishEngine.rotlXor(jRotlXor, 52, j60);
                long j61 = j53 + jRotlXor13;
                long jRotlXor17 = ThreefishEngine.rotlXor(jRotlXor13, 33, j61);
                long j62 = j54 + jRotlXor15;
                long jRotlXor18 = ThreefishEngine.rotlXor(jRotlXor15, 4, j62);
                long j63 = j56 + jRotlXor14;
                long jRotlXor19 = ThreefishEngine.rotlXor(jRotlXor14, 51, j63);
                long j64 = j55 + jRotlXor16;
                long jRotlXor20 = ThreefishEngine.rotlXor(jRotlXor16, 13, j64);
                long j65 = j58 + jRotlXor12;
                long jRotlXor21 = ThreefishEngine.rotlXor(jRotlXor12, 34, j65);
                long j66 = j59 + jRotlXor10;
                long jRotlXor22 = ThreefishEngine.rotlXor(jRotlXor10, 41, j66);
                long j67 = j60 + jRotlXor11;
                long jRotlXor23 = ThreefishEngine.rotlXor(jRotlXor11, 59, j67);
                long j68 = j57 + jRotlXor9;
                long jRotlXor24 = ThreefishEngine.rotlXor(jRotlXor9, 17, j68);
                long j69 = j61 + jRotlXor21;
                long jRotlXor25 = ThreefishEngine.rotlXor(jRotlXor21, 5, j69);
                long j70 = j62 + jRotlXor23;
                long jRotlXor26 = ThreefishEngine.rotlXor(jRotlXor23, 20, j70);
                long j71 = j64 + jRotlXor22;
                long jRotlXor27 = ThreefishEngine.rotlXor(jRotlXor22, 48, j71);
                long j72 = j63 + jRotlXor24;
                long jRotlXor28 = ThreefishEngine.rotlXor(jRotlXor24, 41, j72);
                long j73 = j66 + jRotlXor20;
                long jRotlXor29 = ThreefishEngine.rotlXor(jRotlXor20, 47, j73);
                long j74 = j67 + jRotlXor18;
                long jRotlXor30 = ThreefishEngine.rotlXor(jRotlXor18, 28, j74);
                long j75 = j68 + jRotlXor19;
                long jRotlXor31 = ThreefishEngine.rotlXor(jRotlXor19, 16, j75);
                long j76 = j65 + jRotlXor17;
                long jRotlXor32 = ThreefishEngine.rotlXor(jRotlXor17, 25, j76);
                long j77 = j69 + jArr6[i3];
                int i6 = i3 + 1;
                long j78 = jRotlXor29 + jArr6[i6];
                int i7 = i3 + 2;
                long j79 = j70 + jArr6[i7];
                int i8 = i3 + 3;
                long j80 = jRotlXor31 + jArr6[i8];
                int i9 = i3 + 4;
                long j81 = j72 + jArr6[i9];
                int i10 = i3 + 5;
                long j82 = jRotlXor30 + jArr6[i10];
                int i11 = i3 + 6;
                long j83 = j71 + jArr6[i11];
                int i12 = i3 + 7;
                long j84 = jRotlXor32 + jArr6[i12];
                int i13 = i3 + 8;
                long j85 = j74 + jArr6[i13];
                int i14 = i3 + 9;
                long j86 = jRotlXor28 + jArr6[i14];
                int i15 = i3 + 10;
                long j87 = j75 + jArr6[i15];
                int i16 = i3 + 11;
                long j88 = jRotlXor26 + jArr6[i16];
                int i17 = i3 + 12;
                long j89 = j76 + jArr6[i17];
                int i18 = i3 + 13;
                long j90 = jRotlXor27 + jArr6[i18] + jArr5[i4];
                int i19 = i3 + 14;
                int i20 = i4 + 1;
                long j91 = j73 + jArr6[i19] + jArr5[i20];
                int i21 = i3 + 15;
                long j92 = i5;
                long j93 = jRotlXor25 + jArr6[i21] + j92;
                long j94 = j77 + j78;
                long jRotlXor33 = ThreefishEngine.rotlXor(j78, 41, j94);
                long j95 = j79 + j80;
                long jRotlXor34 = ThreefishEngine.rotlXor(j80, 9, j95);
                long j96 = j81 + j82;
                long jRotlXor35 = ThreefishEngine.rotlXor(j82, 37, j96);
                long j97 = j83 + j84;
                long jRotlXor36 = ThreefishEngine.rotlXor(j84, 31, j97);
                long j98 = j85 + j86;
                long jRotlXor37 = ThreefishEngine.rotlXor(j86, 12, j98);
                long j99 = j87 + j88;
                long jRotlXor38 = ThreefishEngine.rotlXor(j88, 47, j99);
                long j100 = j89 + j90;
                long jRotlXor39 = ThreefishEngine.rotlXor(j90, 44, j100);
                long j101 = j91 + j93;
                long jRotlXor40 = ThreefishEngine.rotlXor(j93, 30, j101);
                long j102 = j94 + jRotlXor37;
                long jRotlXor41 = ThreefishEngine.rotlXor(jRotlXor37, 16, j102);
                long j103 = j95 + jRotlXor39;
                long jRotlXor42 = ThreefishEngine.rotlXor(jRotlXor39, 34, j103);
                long j104 = j97 + jRotlXor38;
                long jRotlXor43 = ThreefishEngine.rotlXor(jRotlXor38, 56, j104);
                long j105 = j96 + jRotlXor40;
                long jRotlXor44 = ThreefishEngine.rotlXor(jRotlXor40, 51, j105);
                long j106 = j99 + jRotlXor36;
                long jRotlXor45 = ThreefishEngine.rotlXor(jRotlXor36, 4, j106);
                long j107 = j100 + jRotlXor34;
                long jRotlXor46 = ThreefishEngine.rotlXor(jRotlXor34, 53, j107);
                long j108 = j101 + jRotlXor35;
                long jRotlXor47 = ThreefishEngine.rotlXor(jRotlXor35, 42, j108);
                long j109 = j98 + jRotlXor33;
                long jRotlXor48 = ThreefishEngine.rotlXor(jRotlXor33, 41, j109);
                long j110 = j102 + jRotlXor45;
                long jRotlXor49 = ThreefishEngine.rotlXor(jRotlXor45, 31, j110);
                long j111 = j103 + jRotlXor47;
                long jRotlXor50 = ThreefishEngine.rotlXor(jRotlXor47, 44, j111);
                long j112 = j105 + jRotlXor46;
                long jRotlXor51 = ThreefishEngine.rotlXor(jRotlXor46, 47, j112);
                long j113 = j104 + jRotlXor48;
                long jRotlXor52 = ThreefishEngine.rotlXor(jRotlXor48, 46, j113);
                long j114 = j107 + jRotlXor44;
                long jRotlXor53 = ThreefishEngine.rotlXor(jRotlXor44, 19, j114);
                long j115 = j108 + jRotlXor42;
                long jRotlXor54 = ThreefishEngine.rotlXor(jRotlXor42, 42, j115);
                long j116 = j109 + jRotlXor43;
                long jRotlXor55 = ThreefishEngine.rotlXor(jRotlXor43, 44, j116);
                long j117 = j106 + jRotlXor41;
                long jRotlXor56 = ThreefishEngine.rotlXor(jRotlXor41, 25, j117);
                long j118 = j110 + jRotlXor53;
                long jRotlXor57 = ThreefishEngine.rotlXor(jRotlXor53, 9, j118);
                long j119 = j111 + jRotlXor55;
                long jRotlXor58 = ThreefishEngine.rotlXor(jRotlXor55, 48, j119);
                long j120 = j113 + jRotlXor54;
                long jRotlXor59 = ThreefishEngine.rotlXor(jRotlXor54, 35, j120);
                long j121 = j112 + jRotlXor56;
                long jRotlXor60 = ThreefishEngine.rotlXor(jRotlXor56, 52, j121);
                long j122 = j115 + jRotlXor52;
                long jRotlXor61 = ThreefishEngine.rotlXor(jRotlXor52, 23, j122);
                long j123 = j116 + jRotlXor50;
                long jRotlXor62 = ThreefishEngine.rotlXor(jRotlXor50, 31, j123);
                long j124 = j117 + jRotlXor51;
                long jRotlXor63 = ThreefishEngine.rotlXor(jRotlXor51, 37, j124);
                long j125 = j114 + jRotlXor49;
                long jRotlXor64 = ThreefishEngine.rotlXor(jRotlXor49, 20, j125);
                j17 = j118 + jArr6[i6];
                long j126 = jRotlXor61 + jArr6[i7];
                long j127 = j119 + jArr6[i8];
                j32 = jArr6[i9] + jRotlXor63;
                long j128 = jArr6[i10] + j121;
                long j129 = jRotlXor62 + jArr6[i11];
                j23 = j120 + jArr6[i12];
                long j130 = jRotlXor64 + jArr6[i13];
                long j131 = j123 + jArr6[i14];
                long j132 = jRotlXor60 + jArr6[i15];
                long j133 = j124 + jArr6[i16];
                j36 = jRotlXor58 + jArr6[i17];
                long j134 = j125 + jArr6[i18];
                j37 = jRotlXor59 + jArr6[i19] + jArr5[i20];
                j31 = j122 + jArr6[i21] + jArr5[i4 + 2];
                j38 = jRotlXor57 + jArr6[i3 + 16] + j92 + 1;
                j29 = j134;
                j25 = j131;
                j35 = j132;
                j27 = j133;
                j34 = j130;
                j21 = j128;
                j33 = j129;
                i = i5 + 2;
                i2 = 13;
                j19 = j127;
                j18 = j126;
                iArr2 = iArr2;
                iArr = iArr3;
                jArr3 = jArr6;
                jArr4 = jArr5;
            }
            jArr2[0] = j17;
            jArr2[1] = j18;
            jArr2[2] = j19;
            jArr2[3] = j32;
            jArr2[4] = j21;
            jArr2[5] = j33;
            jArr2[6] = j23;
            jArr2[7] = j34;
            jArr2[8] = j25;
            jArr2[9] = j35;
            jArr2[10] = j27;
            jArr2[11] = j36;
            jArr2[12] = j29;
            jArr2[13] = j37;
            jArr2[14] = j31;
            jArr2[15] = j38;
        }
    }

    private static final class Threefish256Cipher extends ThreefishCipher {
        public Threefish256Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        void decryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] iArr = ThreefishEngine.MOD5;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            boolean z = false;
            long j = jArr[0];
            long j2 = jArr[1];
            long j3 = jArr[2];
            long jXorRotr = jArr[3];
            int i = 17;
            for (int i2 = 1; i >= i2; i2 = 1) {
                int i3 = iArr[i];
                int i4 = iArr2[i];
                int i5 = i3 + 1;
                long j4 = j - jArr3[i5];
                int i6 = i3 + 2;
                int i7 = i4 + 1;
                long j5 = j2 - (jArr3[i6] + jArr4[i7]);
                int i8 = i3 + 3;
                long j6 = j3 - (jArr3[i8] + jArr4[i4 + 2]);
                long j7 = i;
                long jXorRotr2 = ThreefishEngine.xorRotr(jXorRotr - ((jArr3[i3 + 4] + j7) + 1), 32, j4);
                long j8 = j4 - jXorRotr2;
                int[] iArr3 = iArr;
                long jXorRotr3 = ThreefishEngine.xorRotr(j5, 32, j6);
                long j9 = j6 - jXorRotr3;
                long jXorRotr4 = ThreefishEngine.xorRotr(jXorRotr3, 58, j8);
                long j10 = j8 - jXorRotr4;
                long jXorRotr5 = ThreefishEngine.xorRotr(jXorRotr2, 22, j9);
                long j11 = j9 - jXorRotr5;
                long jXorRotr6 = ThreefishEngine.xorRotr(jXorRotr5, 46, j10);
                long j12 = j10 - jXorRotr6;
                long jXorRotr7 = ThreefishEngine.xorRotr(jXorRotr4, 12, j11);
                long j13 = j11 - jXorRotr7;
                long jXorRotr8 = ThreefishEngine.xorRotr(jXorRotr7, 25, j12);
                long jXorRotr9 = ThreefishEngine.xorRotr(jXorRotr6, 33, j13);
                long j14 = (j12 - jXorRotr8) - jArr3[i3];
                long j15 = jXorRotr8 - (jArr3[i5] + jArr4[i4]);
                long j16 = (j13 - jXorRotr9) - (jArr3[i6] + jArr4[i7]);
                long jXorRotr10 = ThreefishEngine.xorRotr(jXorRotr9 - (jArr3[i8] + j7), 5, j14);
                long j17 = j14 - jXorRotr10;
                long jXorRotr11 = ThreefishEngine.xorRotr(j15, 37, j16);
                long j18 = j16 - jXorRotr11;
                long jXorRotr12 = ThreefishEngine.xorRotr(jXorRotr11, 23, j17);
                long j19 = j17 - jXorRotr12;
                long jXorRotr13 = ThreefishEngine.xorRotr(jXorRotr10, 40, j18);
                long j20 = j18 - jXorRotr13;
                long jXorRotr14 = ThreefishEngine.xorRotr(jXorRotr13, 52, j19);
                long j21 = j19 - jXorRotr14;
                long jXorRotr15 = ThreefishEngine.xorRotr(jXorRotr12, 57, j20);
                long j22 = j20 - jXorRotr15;
                long jXorRotr16 = ThreefishEngine.xorRotr(jXorRotr15, 14, j21);
                j = j21 - jXorRotr16;
                jXorRotr = ThreefishEngine.xorRotr(jXorRotr14, 16, j22);
                j3 = j22 - jXorRotr;
                i -= 2;
                j2 = jXorRotr16;
                iArr = iArr3;
                iArr2 = iArr2;
                z = false;
            }
            boolean z2 = z;
            long j23 = j - jArr3[z2 ? 1 : 0];
            long j24 = j2 - (jArr3[1] + jArr4[z2 ? 1 : 0]);
            long j25 = j3 - (jArr3[2] + jArr4[1]);
            long j26 = jXorRotr - jArr3[3];
            jArr2[z2 ? 1 : 0] = j23;
            jArr2[1] = j24;
            jArr2[2] = j25;
            jArr2[3] = j26;
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        void encryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] iArr = ThreefishEngine.MOD5;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            }
            int i = 5;
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j = jArr[0];
            int i2 = 1;
            long j2 = jArr[1];
            long j3 = jArr[2];
            long j4 = jArr[3];
            long j5 = j + jArr3[0];
            long j6 = j2 + jArr3[1] + jArr4[0];
            long j7 = j3 + jArr3[2] + jArr4[1];
            long j8 = j4 + jArr3[3];
            while (i2 < 18) {
                int i3 = iArr[i2];
                int i4 = iArr2[i2];
                long j9 = j5 + j6;
                long jRotlXor = ThreefishEngine.rotlXor(j6, 14, j9);
                long j10 = j7 + j8;
                long jRotlXor2 = ThreefishEngine.rotlXor(j8, 16, j10);
                long j11 = j9 + jRotlXor2;
                long jRotlXor3 = ThreefishEngine.rotlXor(jRotlXor2, 52, j11);
                long j12 = j10 + jRotlXor;
                long jRotlXor4 = ThreefishEngine.rotlXor(jRotlXor, 57, j12);
                long j13 = j11 + jRotlXor4;
                long jRotlXor5 = ThreefishEngine.rotlXor(jRotlXor4, 23, j13);
                long j14 = j12 + jRotlXor3;
                long jRotlXor6 = ThreefishEngine.rotlXor(jRotlXor3, 40, j14);
                long j15 = j13 + jRotlXor6;
                long jRotlXor7 = ThreefishEngine.rotlXor(jRotlXor6, i, j15);
                long j16 = j14 + jRotlXor5;
                long jRotlXor8 = ThreefishEngine.rotlXor(jRotlXor5, 37, j16);
                long j17 = j15 + jArr3[i3];
                int i5 = i3 + 1;
                long j18 = jRotlXor8 + jArr3[i5] + jArr4[i4];
                int i6 = i3 + 2;
                int i7 = i4 + 1;
                long j19 = j16 + jArr3[i6] + jArr4[i7];
                int i8 = i3 + 3;
                long j20 = i2;
                long j21 = jRotlXor7 + jArr3[i8] + j20;
                int[] iArr3 = iArr;
                long j22 = j17 + j18;
                long jRotlXor9 = ThreefishEngine.rotlXor(j18, 25, j22);
                long j23 = j19 + j21;
                long jRotlXor10 = ThreefishEngine.rotlXor(j21, 33, j23);
                long j24 = j22 + jRotlXor10;
                long jRotlXor11 = ThreefishEngine.rotlXor(jRotlXor10, 46, j24);
                long j25 = j23 + jRotlXor9;
                long jRotlXor12 = ThreefishEngine.rotlXor(jRotlXor9, 12, j25);
                long j26 = j24 + jRotlXor12;
                long jRotlXor13 = ThreefishEngine.rotlXor(jRotlXor12, 58, j26);
                long j27 = j25 + jRotlXor11;
                long jRotlXor14 = ThreefishEngine.rotlXor(jRotlXor11, 22, j27);
                long j28 = j26 + jRotlXor14;
                long jRotlXor15 = ThreefishEngine.rotlXor(jRotlXor14, 32, j28);
                long j29 = j27 + jRotlXor13;
                long jRotlXor16 = ThreefishEngine.rotlXor(jRotlXor13, 32, j29);
                long j30 = j28 + jArr3[i5];
                j6 = jRotlXor16 + jArr3[i6] + jArr4[i7];
                j7 = j29 + jArr3[i8] + jArr4[i4 + 2];
                j8 = jRotlXor15 + jArr3[i3 + 4] + j20 + 1;
                i2 += 2;
                j5 = j30;
                iArr = iArr3;
                iArr2 = iArr2;
                i = 5;
            }
            jArr2[0] = j5;
            jArr2[1] = j6;
            jArr2[2] = j7;
            jArr2[3] = j8;
        }
    }

    private static final class Threefish512Cipher extends ThreefishCipher {
        protected Threefish512Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void decryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] iArr = ThreefishEngine.MOD9;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            boolean z = false;
            long j = jArr[0];
            int i = 1;
            long j2 = jArr[1];
            long j3 = jArr[2];
            long j4 = jArr[3];
            long j5 = jArr[4];
            long jXorRotr = jArr[5];
            long j6 = jArr[6];
            long jXorRotr2 = jArr[7];
            int i2 = 17;
            while (i2 >= i) {
                int i3 = iArr[i2];
                int i4 = iArr2[i2];
                int i5 = i3 + 1;
                long j7 = j - jArr3[i5];
                int i6 = i3 + 2;
                long j8 = j2 - jArr3[i6];
                int i7 = i3 + 3;
                long j9 = j3 - jArr3[i7];
                int i8 = i3 + 4;
                long j10 = j4 - jArr3[i8];
                int i9 = i3 + 5;
                long j11 = j5 - jArr3[i9];
                int i10 = i3 + 6;
                int i11 = i4 + 1;
                long j12 = jXorRotr - (jArr3[i10] + jArr4[i11]);
                int i12 = i3 + 7;
                int[] iArr3 = iArr;
                long j13 = j6 - (jArr3[i12] + jArr4[i4 + 2]);
                long j14 = i2;
                long j15 = jXorRotr2 - ((jArr3[i3 + 8] + j14) + 1);
                long[] jArr5 = jArr4;
                long[] jArr6 = jArr3;
                long jXorRotr3 = ThreefishEngine.xorRotr(j8, 8, j13);
                long j16 = j13 - jXorRotr3;
                long jXorRotr4 = ThreefishEngine.xorRotr(j15, 35, j7);
                long j17 = j7 - jXorRotr4;
                long jXorRotr5 = ThreefishEngine.xorRotr(j12, 56, j9);
                long j18 = j9 - jXorRotr5;
                long jXorRotr6 = ThreefishEngine.xorRotr(j10, 22, j11);
                long j19 = j11 - jXorRotr6;
                long jXorRotr7 = ThreefishEngine.xorRotr(jXorRotr3, 25, j19);
                long j20 = j19 - jXorRotr7;
                long jXorRotr8 = ThreefishEngine.xorRotr(jXorRotr6, 29, j16);
                long j21 = j16 - jXorRotr8;
                long jXorRotr9 = ThreefishEngine.xorRotr(jXorRotr5, 39, j17);
                long j22 = j17 - jXorRotr9;
                long jXorRotr10 = ThreefishEngine.xorRotr(jXorRotr4, 43, j18);
                long j23 = j18 - jXorRotr10;
                long jXorRotr11 = ThreefishEngine.xorRotr(jXorRotr7, 13, j23);
                long j24 = j23 - jXorRotr11;
                long jXorRotr12 = ThreefishEngine.xorRotr(jXorRotr10, 50, j20);
                long j25 = j20 - jXorRotr12;
                long jXorRotr13 = ThreefishEngine.xorRotr(jXorRotr9, 10, j21);
                long j26 = j21 - jXorRotr13;
                long jXorRotr14 = ThreefishEngine.xorRotr(jXorRotr8, 17, j22);
                long j27 = j22 - jXorRotr14;
                long jXorRotr15 = ThreefishEngine.xorRotr(jXorRotr11, 39, j27);
                long jXorRotr16 = ThreefishEngine.xorRotr(jXorRotr14, 30, j24);
                long jXorRotr17 = ThreefishEngine.xorRotr(jXorRotr13, 34, j25);
                long j28 = j25 - jXorRotr17;
                long jXorRotr18 = ThreefishEngine.xorRotr(jXorRotr12, 24, j26);
                long j29 = j26 - jXorRotr18;
                long j30 = (j27 - jXorRotr15) - jArr6[i3];
                long j31 = jXorRotr15 - jArr6[i5];
                long j32 = (j24 - jXorRotr16) - jArr6[i6];
                long j33 = jXorRotr16 - jArr6[i7];
                long j34 = j28 - jArr6[i8];
                long j35 = jXorRotr17 - (jArr6[i9] + jArr5[i4]);
                long j36 = j29 - (jArr6[i10] + jArr5[i11]);
                long j37 = jXorRotr18 - (jArr6[i12] + j14);
                long jXorRotr19 = ThreefishEngine.xorRotr(j31, 44, j36);
                long j38 = j36 - jXorRotr19;
                long jXorRotr20 = ThreefishEngine.xorRotr(j37, 9, j30);
                long j39 = j30 - jXorRotr20;
                long jXorRotr21 = ThreefishEngine.xorRotr(j35, 54, j32);
                long j40 = j32 - jXorRotr21;
                long jXorRotr22 = ThreefishEngine.xorRotr(j33, 56, j34);
                long j41 = j34 - jXorRotr22;
                long jXorRotr23 = ThreefishEngine.xorRotr(jXorRotr19, 17, j41);
                long j42 = j41 - jXorRotr23;
                long jXorRotr24 = ThreefishEngine.xorRotr(jXorRotr22, 49, j38);
                long j43 = j38 - jXorRotr24;
                long jXorRotr25 = ThreefishEngine.xorRotr(jXorRotr21, 36, j39);
                long j44 = j39 - jXorRotr25;
                long jXorRotr26 = ThreefishEngine.xorRotr(jXorRotr20, 39, j40);
                long j45 = j40 - jXorRotr26;
                long jXorRotr27 = ThreefishEngine.xorRotr(jXorRotr23, 33, j45);
                long j46 = j45 - jXorRotr27;
                long jXorRotr28 = ThreefishEngine.xorRotr(jXorRotr26, 27, j42);
                long j47 = j42 - jXorRotr28;
                long jXorRotr29 = ThreefishEngine.xorRotr(jXorRotr25, 14, j43);
                long j48 = j43 - jXorRotr29;
                long jXorRotr30 = ThreefishEngine.xorRotr(jXorRotr24, 42, j44);
                long j49 = j44 - jXorRotr30;
                long jXorRotr31 = ThreefishEngine.xorRotr(jXorRotr27, 46, j49);
                j = j49 - jXorRotr31;
                long jXorRotr32 = ThreefishEngine.xorRotr(jXorRotr30, 36, j46);
                jXorRotr = ThreefishEngine.xorRotr(jXorRotr29, 19, j47);
                j5 = j47 - jXorRotr;
                jXorRotr2 = ThreefishEngine.xorRotr(jXorRotr28, 37, j48);
                j6 = j48 - jXorRotr2;
                i2 -= 2;
                j3 = j46 - jXorRotr32;
                j2 = jXorRotr31;
                iArr = iArr3;
                iArr2 = iArr2;
                jArr3 = jArr6;
                jArr4 = jArr5;
                i = 1;
                j4 = jXorRotr32;
                z = false;
            }
            long[] jArr7 = jArr4;
            long[] jArr8 = jArr3;
            boolean z2 = z;
            long j50 = j - jArr8[z2 ? 1 : 0];
            long j51 = j2 - jArr8[1];
            long j52 = j3 - jArr8[2];
            long j53 = j4 - jArr8[3];
            long j54 = j5 - jArr8[4];
            long j55 = jXorRotr - (jArr8[5] + jArr7[z2 ? 1 : 0]);
            long j56 = j6 - (jArr8[6] + jArr7[1]);
            long j57 = jXorRotr2 - jArr8[7];
            jArr2[z2 ? 1 : 0] = j50;
            jArr2[1] = j51;
            jArr2[2] = j52;
            jArr2[3] = j53;
            jArr2[4] = j54;
            jArr2[5] = j55;
            jArr2[6] = j56;
            jArr2[7] = j57;
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void encryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] iArr = ThreefishEngine.MOD9;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j = jArr[0];
            long j2 = jArr[1];
            long j3 = jArr[2];
            long j4 = jArr[3];
            long j5 = jArr[4];
            long j6 = jArr[5];
            long j7 = jArr[6];
            long j8 = jArr[7];
            long j9 = j + jArr3[0];
            long j10 = j2 + jArr3[1];
            long j11 = j3 + jArr3[2];
            long j12 = j4 + jArr3[3];
            long j13 = j5 + jArr3[4];
            long j14 = j6 + jArr3[5] + jArr4[0];
            long j15 = j7 + jArr3[6] + jArr4[1];
            int i = 1;
            long j16 = j12;
            long j17 = j14;
            long j18 = j8 + jArr3[7];
            while (i < 18) {
                int i2 = iArr[i];
                int i3 = iArr2[i];
                long j19 = j9 + j10;
                long jRotlXor = ThreefishEngine.rotlXor(j10, 46, j19);
                long j20 = j11 + j16;
                long jRotlXor2 = ThreefishEngine.rotlXor(j16, 36, j20);
                int[] iArr3 = iArr;
                long j21 = j17;
                long j22 = j13 + j21;
                int i4 = i;
                long jRotlXor3 = ThreefishEngine.rotlXor(j21, 19, j22);
                long[] jArr5 = jArr4;
                long[] jArr6 = jArr3;
                long j23 = j18;
                long j24 = j15 + j23;
                long jRotlXor4 = ThreefishEngine.rotlXor(j23, 37, j24);
                long j25 = j20 + jRotlXor;
                long jRotlXor5 = ThreefishEngine.rotlXor(jRotlXor, 33, j25);
                long j26 = j22 + jRotlXor4;
                long jRotlXor6 = ThreefishEngine.rotlXor(jRotlXor4, 27, j26);
                long j27 = j24 + jRotlXor3;
                long jRotlXor7 = ThreefishEngine.rotlXor(jRotlXor3, 14, j27);
                long j28 = j19 + jRotlXor2;
                long jRotlXor8 = ThreefishEngine.rotlXor(jRotlXor2, 42, j28);
                long j29 = j26 + jRotlXor5;
                long jRotlXor9 = ThreefishEngine.rotlXor(jRotlXor5, 17, j29);
                long j30 = j27 + jRotlXor8;
                long jRotlXor10 = ThreefishEngine.rotlXor(jRotlXor8, 49, j30);
                long j31 = j28 + jRotlXor7;
                long jRotlXor11 = ThreefishEngine.rotlXor(jRotlXor7, 36, j31);
                long j32 = j25 + jRotlXor6;
                long jRotlXor12 = ThreefishEngine.rotlXor(jRotlXor6, 39, j32);
                long j33 = j30 + jRotlXor9;
                long jRotlXor13 = ThreefishEngine.rotlXor(jRotlXor9, 44, j33);
                long j34 = j31 + jRotlXor12;
                long jRotlXor14 = ThreefishEngine.rotlXor(jRotlXor12, 9, j34);
                long j35 = j32 + jRotlXor11;
                long jRotlXor15 = ThreefishEngine.rotlXor(jRotlXor11, 54, j35);
                long j36 = j29 + jRotlXor10;
                long jRotlXor16 = ThreefishEngine.rotlXor(jRotlXor10, 56, j36);
                long j37 = j34 + jArr6[i2];
                int i5 = i2 + 1;
                long j38 = jRotlXor13 + jArr6[i5];
                int i6 = i2 + 2;
                long j39 = j35 + jArr6[i6];
                int i7 = i2 + 3;
                long j40 = jRotlXor16 + jArr6[i7];
                int i8 = i2 + 4;
                long j41 = j36 + jArr6[i8];
                int i9 = i2 + 5;
                long j42 = jRotlXor15 + jArr6[i9] + jArr5[i3];
                int i10 = i2 + 6;
                int i11 = i3 + 1;
                long j43 = j33 + jArr6[i10] + jArr5[i11];
                int i12 = i2 + 7;
                long j44 = i4;
                long j45 = jRotlXor14 + jArr6[i12] + j44;
                long j46 = j37 + j38;
                long jRotlXor17 = ThreefishEngine.rotlXor(j38, 39, j46);
                long j47 = j39 + j40;
                long jRotlXor18 = ThreefishEngine.rotlXor(j40, 30, j47);
                long j48 = j41 + j42;
                long jRotlXor19 = ThreefishEngine.rotlXor(j42, 34, j48);
                long j49 = j43 + j45;
                long jRotlXor20 = ThreefishEngine.rotlXor(j45, 24, j49);
                long j50 = j47 + jRotlXor17;
                long jRotlXor21 = ThreefishEngine.rotlXor(jRotlXor17, 13, j50);
                long j51 = j48 + jRotlXor20;
                long jRotlXor22 = ThreefishEngine.rotlXor(jRotlXor20, 50, j51);
                long j52 = j49 + jRotlXor19;
                long jRotlXor23 = ThreefishEngine.rotlXor(jRotlXor19, 10, j52);
                long j53 = j46 + jRotlXor18;
                long jRotlXor24 = ThreefishEngine.rotlXor(jRotlXor18, 17, j53);
                long j54 = j51 + jRotlXor21;
                long jRotlXor25 = ThreefishEngine.rotlXor(jRotlXor21, 25, j54);
                long j55 = j52 + jRotlXor24;
                long jRotlXor26 = ThreefishEngine.rotlXor(jRotlXor24, 29, j55);
                long j56 = j53 + jRotlXor23;
                long jRotlXor27 = ThreefishEngine.rotlXor(jRotlXor23, 39, j56);
                long j57 = j50 + jRotlXor22;
                long jRotlXor28 = ThreefishEngine.rotlXor(jRotlXor22, 43, j57);
                long j58 = j55 + jRotlXor25;
                long jRotlXor29 = ThreefishEngine.rotlXor(jRotlXor25, 8, j58);
                long j59 = j56 + jRotlXor28;
                long jRotlXor30 = ThreefishEngine.rotlXor(jRotlXor28, 35, j59);
                long j60 = j57 + jRotlXor27;
                long jRotlXor31 = ThreefishEngine.rotlXor(jRotlXor27, 56, j60);
                long j61 = j54 + jRotlXor26;
                long jRotlXor32 = ThreefishEngine.rotlXor(jRotlXor26, 22, j61);
                j9 = j59 + jArr6[i5];
                long j62 = jRotlXor29 + jArr6[i6];
                j11 = j60 + jArr6[i7];
                j16 = jRotlXor32 + jArr6[i8];
                long j63 = j61 + jArr6[i9];
                j17 = jRotlXor31 + jArr6[i10] + jArr5[i11];
                j15 = j58 + jArr6[i12] + jArr5[i3 + 2];
                long j64 = jRotlXor30 + jArr6[i2 + 8] + j44 + 1;
                i = i4 + 2;
                j13 = j63;
                j10 = j62;
                iArr = iArr3;
                iArr2 = iArr2;
                jArr4 = jArr5;
                jArr3 = jArr6;
                j18 = j64;
            }
            jArr2[0] = j9;
            jArr2[1] = j10;
            jArr2[2] = j11;
            jArr2[3] = j16;
            jArr2[4] = j13;
            jArr2[5] = j17;
            jArr2[6] = j15;
            jArr2[7] = j18;
        }
    }

    private static abstract class ThreefishCipher {
        protected final long[] kw;
        protected final long[] t;

        protected ThreefishCipher(long[] jArr, long[] jArr2) {
            this.kw = jArr;
            this.t = jArr2;
        }

        abstract void decryptBlock(long[] jArr, long[] jArr2);

        abstract void encryptBlock(long[] jArr, long[] jArr2);
    }

    static {
        int[] iArr = new int[80];
        MOD9 = iArr;
        MOD17 = new int[iArr.length];
        MOD5 = new int[iArr.length];
        MOD3 = new int[iArr.length];
        int i = 0;
        while (true) {
            int[] iArr2 = MOD9;
            if (i >= iArr2.length) {
                return;
            }
            MOD17[i] = i % 17;
            iArr2[i] = i % 9;
            MOD5[i] = i % 5;
            MOD3[i] = i % 3;
            i++;
        }
    }

    public ThreefishEngine(int i) {
        ThreefishCipher threefish256Cipher;
        long[] jArr = new long[5];
        this.t = jArr;
        int i2 = i / 8;
        this.blocksizeBytes = i2;
        int i3 = i2 / 8;
        this.blocksizeWords = i3;
        this.currentBlock = new long[i3];
        long[] jArr2 = new long[(i3 * 2) + 1];
        this.kw = jArr2;
        if (i == 256) {
            threefish256Cipher = new Threefish256Cipher(jArr2, jArr);
        } else if (i == 512) {
            threefish256Cipher = new Threefish512Cipher(jArr2, jArr);
        } else {
            if (i != 1024) {
                throw new IllegalArgumentException("Invalid blocksize - Threefish is defined with block size of 256, 512, or 1024 bits");
            }
            threefish256Cipher = new Threefish1024Cipher(jArr2, jArr);
        }
        this.cipher = threefish256Cipher;
    }

    public static long bytesToWord(byte[] bArr, int i) {
        if (i + 8 > bArr.length) {
            throw new IllegalArgumentException();
        }
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    static long rotlXor(long j, int i, long j2) {
        return ((j >>> (-i)) | (j << i)) ^ j2;
    }

    private void setKey(long[] jArr) {
        if (jArr.length != this.blocksizeWords) {
            throw new IllegalArgumentException("Threefish key must be same size as block (" + this.blocksizeWords + " words)");
        }
        long j = 2004413935125273122L;
        int i = 0;
        while (true) {
            int i2 = this.blocksizeWords;
            if (i >= i2) {
                long[] jArr2 = this.kw;
                jArr2[i2] = j;
                System.arraycopy(jArr2, 0, jArr2, i2 + 1, i2);
                return;
            } else {
                long[] jArr3 = this.kw;
                long j2 = jArr[i];
                jArr3[i] = j2;
                j ^= j2;
                i++;
            }
        }
    }

    private void setTweak(long[] jArr) {
        if (jArr.length != 2) {
            throw new IllegalArgumentException("Tweak must be 2 words.");
        }
        long[] jArr2 = this.t;
        long j = jArr[0];
        jArr2[0] = j;
        long j2 = jArr[1];
        jArr2[1] = j2;
        jArr2[2] = j ^ j2;
        jArr2[3] = j;
        jArr2[4] = j2;
    }

    public static void wordToBytes(long j, byte[] bArr, int i) {
        if (i + 8 > bArr.length) {
            throw new IllegalArgumentException();
        }
        bArr[i] = (byte) j;
        bArr[i + 1] = (byte) (j >> 8);
        bArr[i + 2] = (byte) (j >> 16);
        bArr[i + 3] = (byte) (j >> 24);
        bArr[i + 4] = (byte) (j >> 32);
        bArr[i + 5] = (byte) (j >> 40);
        bArr[i + 6] = (byte) (j >> 48);
        bArr[i + 7] = (byte) (j >> 56);
    }

    static long xorRotr(long j, int i, long j2) {
        long j3 = j ^ j2;
        return (j3 << (-i)) | (j3 >>> i);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Threefish-" + (this.blocksizeBytes * 8);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.blocksizeBytes;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        byte[] key;
        byte[] tweak;
        long[] jArr;
        long[] jArr2 = null;
        if (cipherParameters instanceof TweakableBlockCipherParameters) {
            TweakableBlockCipherParameters tweakableBlockCipherParameters = (TweakableBlockCipherParameters) cipherParameters;
            key = tweakableBlockCipherParameters.getKey().getKey();
            tweak = tweakableBlockCipherParameters.getTweak();
        } else {
            if (!(cipherParameters instanceof KeyParameter)) {
                throw new IllegalArgumentException("Invalid parameter passed to Threefish init - " + cipherParameters.getClass().getName());
            }
            key = ((KeyParameter) cipherParameters).getKey();
            tweak = null;
        }
        if (key == null) {
            jArr = null;
        } else {
            if (key.length != this.blocksizeBytes) {
                throw new IllegalArgumentException("Threefish key must be same size as block (" + this.blocksizeBytes + " bytes)");
            }
            int i = this.blocksizeWords;
            jArr = new long[i];
            for (int i2 = 0; i2 < i; i2++) {
                jArr[i2] = bytesToWord(key, i2 * 8);
            }
        }
        if (tweak != null) {
            if (tweak.length != 16) {
                throw new IllegalArgumentException("Threefish tweak must be 16 bytes");
            }
            jArr2 = new long[]{bytesToWord(tweak, 0), bytesToWord(tweak, 8)};
        }
        init(z, jArr, jArr2);
    }

    public void init(boolean z, long[] jArr, long[] jArr2) {
        this.forEncryption = z;
        if (jArr != null) {
            setKey(jArr);
        }
        if (jArr2 != null) {
            setTweak(jArr2);
        }
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws IllegalStateException, DataLengthException {
        int i3 = this.blocksizeBytes;
        if (i + i3 > bArr.length) {
            throw new DataLengthException("Input buffer too short");
        }
        if (i3 + i2 > bArr2.length) {
            throw new OutputLengthException("Output buffer too short");
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.blocksizeBytes; i5 += 8) {
            this.currentBlock[i5 >> 3] = bytesToWord(bArr, i + i5);
        }
        long[] jArr = this.currentBlock;
        processBlock(jArr, jArr);
        while (true) {
            int i6 = this.blocksizeBytes;
            if (i4 >= i6) {
                return i6;
            }
            wordToBytes(this.currentBlock[i4 >> 3], bArr2, i2 + i4);
            i4 += 8;
        }
    }

    public int processBlock(long[] jArr, long[] jArr2) throws IllegalStateException, DataLengthException {
        long[] jArr3 = this.kw;
        int i = this.blocksizeWords;
        if (jArr3[i] == 0) {
            throw new IllegalStateException("Threefish engine not initialised");
        }
        if (jArr.length != i) {
            throw new DataLengthException("Input buffer too short");
        }
        if (jArr2.length != i) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (this.forEncryption) {
            this.cipher.encryptBlock(jArr, jArr2);
        } else {
            this.cipher.decryptBlock(jArr, jArr2);
        }
        return this.blocksizeWords;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
