package com.google.android.gms.internal.measurement;

import androidx.media3.extractor.ts.PsExtractor;
import com.contentsquare.android.api.Currencies;

/* loaded from: classes3.dex */
final class zzis extends zzir {
    zzis() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x005f, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
    
        return -1;
     */
    @Override // com.google.android.gms.internal.measurement.zzir
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zza(int r16, byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzis.zza(int, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.measurement.zzir
    final String zza(byte[] bArr, int i, int i2) throws zzfw {
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte bZza = zzin.zza(bArr, i);
            if (!zzio.zzd(bZza)) {
                break;
            }
            i++;
            zzio.zzb(bZza, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte bZza2 = zzin.zza(bArr, i);
            if (zzio.zzd(bZza2)) {
                int i7 = i5 + 1;
                zzio.zzb(bZza2, cArr, i5);
                while (i6 < i3) {
                    byte bZza3 = zzin.zza(bArr, i6);
                    if (!zzio.zzd(bZza3)) {
                        break;
                    }
                    i6++;
                    zzio.zzb(bZza3, cArr, i7);
                    i7++;
                }
                i5 = i7;
                i = i6;
            } else if (zzio.zze(bZza2)) {
                if (i6 >= i3) {
                    throw zzfw.zzh();
                }
                i += 2;
                zzio.zzb(bZza2, zzin.zza(bArr, i6), cArr, i5);
                i5++;
            } else if (zzio.zzf(bZza2)) {
                if (i6 < i3 - 1) {
                    int i8 = i + 2;
                    i += 3;
                    zzio.zzb(bZza2, zzin.zza(bArr, i6), zzin.zza(bArr, i8), cArr, i5);
                    i5++;
                } else {
                    throw zzfw.zzh();
                }
            } else {
                if (i6 >= i3 - 2) {
                    throw zzfw.zzh();
                }
                byte bZza4 = zzin.zza(bArr, i6);
                int i9 = i + 3;
                byte bZza5 = zzin.zza(bArr, i + 2);
                i += 4;
                zzio.zzb(bZza2, bZza4, bZza5, zzin.zza(bArr, i9), cArr, i5);
                i5 += 2;
            }
        }
        return new String(cArr, 0, i5);
    }

    @Override // com.google.android.gms.internal.measurement.zzir
    final int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        String str;
        String str2;
        int i3;
        long j2;
        long j3;
        char cCharAt;
        long j4 = i;
        long j5 = i2 + j4;
        int length = charSequence.length();
        String str3 = " at index ";
        String str4 = "Failed writing ";
        if (length > i2 || bArr.length - i2 < i) {
            char cCharAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(cCharAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (true) {
            j = 1;
            if (i4 >= length || (cCharAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            zzin.zza(bArr, j4, (byte) cCharAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char cCharAt3 = charSequence.charAt(i4);
            if (cCharAt3 >= 128 || j4 >= j5) {
                if (cCharAt3 >= 2048 || j4 > j5 - 2) {
                    str = str3;
                    str2 = str4;
                    if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || j4 > j5 - 3) {
                        if (j4 <= j5 - 4) {
                            int i5 = i4 + 1;
                            if (i5 != length) {
                                char cCharAt4 = charSequence.charAt(i5);
                                if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                    int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                    j2 = 1;
                                    zzin.zza(bArr, j4, (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK));
                                    j3 = j5;
                                    zzin.zza(bArr, j4 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j6 = j4 + 3;
                                    zzin.zza(bArr, j4 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j4 += 4;
                                    zzin.zza(bArr, j6, (byte) ((codePoint & 63) | 128));
                                    i4 = i5;
                                } else {
                                    i4 = i5;
                                }
                            }
                            throw new zzit(i4 - 1, length);
                        }
                        if (55296 <= cCharAt3 && cCharAt3 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(cCharAt3, charSequence.charAt(i3)))) {
                            throw new zzit(i4, length);
                        }
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append(str2);
                        sb2.append(cCharAt3);
                        sb2.append(str);
                        sb2.append(j4);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                    zzin.zza(bArr, j4, (byte) ((cCharAt3 >>> '\f') | Currencies.MUR));
                    long j7 = j4 + 2;
                    zzin.zza(bArr, j4 + 1, (byte) (((cCharAt3 >>> 6) & 63) | 128));
                    j4 += 3;
                    zzin.zza(bArr, j7, (byte) ((cCharAt3 & '?') | 128));
                } else {
                    str = str3;
                    str2 = str4;
                    long j8 = j4 + j;
                    zzin.zza(bArr, j4, (byte) ((cCharAt3 >>> 6) | Currencies.XDR));
                    j4 += 2;
                    zzin.zza(bArr, j8, (byte) ((cCharAt3 & '?') | 128));
                }
                j3 = j5;
                j2 = 1;
            } else {
                zzin.zza(bArr, j4, (byte) cCharAt3);
                j3 = j5;
                str = str3;
                j2 = j;
                j4 += j;
                str2 = str4;
            }
            i4++;
            str3 = str;
            str4 = str2;
            j = j2;
            j5 = j3;
        }
        return (int) j4;
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return zzip.zzb(i);
        }
        if (i2 == 1) {
            return zzip.zzb(i, zzin.zza(bArr, j));
        }
        if (i2 == 2) {
            return zzip.zzb(i, zzin.zza(bArr, j), zzin.zza(bArr, j + 1));
        }
        throw new AssertionError();
    }
}
