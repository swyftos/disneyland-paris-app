package org.bouncycastle.openpgp.operator;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.bcpg.HashAlgorithmTags;
import org.bouncycastle.bcpg.S2K;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes6.dex */
abstract class PGPUtil implements HashAlgorithmTags {
    /* JADX WARN: Code duplicated, block: B:50:0x00e1 A[Catch: IOException -> 0x0062, TryCatch #0 {IOException -> 0x0062, blocks: (B:23:0x005c, B:26:0x0065, B:31:0x0074, B:32:0x0081, B:35:0x0089, B:37:0x008f, B:38:0x0094, B:40:0x00a0, B:41:0x00a6, B:48:0x00d5, B:50:0x00e1, B:52:0x00e9, B:51:0x00e5, B:42:0x00ab, B:43:0x00c5, B:44:0x00c6, B:45:0x00c9, B:47:0x00cf), top: B:63:0x005c }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00e5 A[Catch: IOException -> 0x0062, TryCatch #0 {IOException -> 0x0062, blocks: (B:23:0x005c, B:26:0x0065, B:31:0x0074, B:32:0x0081, B:35:0x0089, B:37:0x008f, B:38:0x0094, B:40:0x00a0, B:41:0x00a6, B:48:0x00d5, B:50:0x00e1, B:52:0x00e9, B:51:0x00e5, B:42:0x00ab, B:43:0x00c5, B:44:0x00c6, B:45:0x00c9, B:47:0x00cf), top: B:63:0x005c }] */
    static byte[] makeKeyFromPassPhrase(PGPDigestCalculator pGPDigestCalculator, int i, S2K s2k, char[] cArr) throws PGPException {
        byte[] digest;
        int i2;
        int i3 = 192;
        switch (i) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 7:
            case 11:
                i3 = 128;
                break;
            case 2:
            case 8:
            case 12:
                break;
            case 6:
                i3 = 64;
                break;
            case 9:
            case 10:
            case 13:
                i3 = 256;
                break;
            default:
                throw new PGPException("unknown symmetric algorithm: " + i);
        }
        byte[] uTF8ByteArray = Strings.toUTF8ByteArray(cArr);
        int i4 = (i3 + 7) / 8;
        byte[] bArr = new byte[i4];
        if (s2k != null) {
            if (s2k.getHashAlgorithm() != pGPDigestCalculator.getAlgorithm()) {
                throw new PGPException("s2k/digestCalculator mismatch");
            }
        } else if (pGPDigestCalculator.getAlgorithm() != 1) {
            throw new PGPException("digestCalculator not for MD5");
        }
        OutputStream outputStream = pGPDigestCalculator.getOutputStream();
        int length = 0;
        int i5 = 0;
        while (length < i4) {
            int i6 = 0;
            if (s2k != null) {
                while (i6 != i5) {
                    try {
                        outputStream.write(0);
                        i6++;
                    } catch (IOException e) {
                        throw new PGPException("exception calculating digest: " + e.getMessage(), e);
                    }
                }
                byte[] iv = s2k.getIV();
                int type = s2k.getType();
                if (type != 0) {
                    if (type == 1) {
                        outputStream.write(iv);
                    } else {
                        if (type != 3) {
                            throw new PGPException("unknown S2K type: " + s2k.getType());
                        }
                        long iterationCount = s2k.getIterationCount();
                        outputStream.write(iv);
                        outputStream.write(uTF8ByteArray);
                        int length2 = iv.length + uTF8ByteArray.length;
                        while (true) {
                            long j = iterationCount - ((long) length2);
                            while (true) {
                                if (j > 0) {
                                    if (j < iv.length) {
                                        outputStream.write(iv, 0, (int) j);
                                    } else {
                                        outputStream.write(iv);
                                        iterationCount = j - ((long) iv.length);
                                        if (iterationCount < uTF8ByteArray.length) {
                                            outputStream.write(uTF8ByteArray, 0, (int) iterationCount);
                                            j = 0;
                                        } else {
                                            outputStream.write(uTF8ByteArray);
                                            length2 = uTF8ByteArray.length;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                outputStream.close();
                digest = pGPDigestCalculator.getDigest();
                i2 = i4 - length;
                if (digest.length > i2) {
                    System.arraycopy(digest, 0, bArr, length, i2);
                } else {
                    System.arraycopy(digest, 0, bArr, length, digest.length);
                }
                length += digest.length;
                i5++;
            } else {
                while (i6 != i5) {
                    outputStream.write(0);
                    i6++;
                }
            }
            outputStream.write(uTF8ByteArray);
            outputStream.close();
            digest = pGPDigestCalculator.getDigest();
            i2 = i4 - length;
            if (digest.length > i2) {
                System.arraycopy(digest, 0, bArr, length, i2);
            } else {
                System.arraycopy(digest, 0, bArr, length, digest.length);
            }
            length += digest.length;
            i5++;
        }
        for (int i7 = 0; i7 != uTF8ByteArray.length; i7++) {
            uTF8ByteArray[i7] = 0;
        }
        return bArr;
    }

    public static byte[] makeKeyFromPassPhrase(PGPDigestCalculatorProvider pGPDigestCalculatorProvider, int i, S2K s2k, char[] cArr) {
        return makeKeyFromPassPhrase(pGPDigestCalculatorProvider.get(s2k != null ? s2k.getHashAlgorithm() : 1), i, s2k, cArr);
    }
}
