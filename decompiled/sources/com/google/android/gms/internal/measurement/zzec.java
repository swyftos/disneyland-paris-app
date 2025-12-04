package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;

/* loaded from: classes3.dex */
abstract class zzec {
    static int zza(byte[] bArr, int i, zzeb zzebVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza(b, bArr, i2, zzebVar);
        }
        zzebVar.zza = b;
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, zzeb zzebVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzebVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzebVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzebVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzebVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzebVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzb(byte[] bArr, int i, zzeb zzebVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzebVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & 127) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & 127) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        zzebVar.zzb = j2;
        return i3;
    }

    static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    static long zzb(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    static double zzc(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzb(bArr, i));
    }

    static float zzd(byte[] bArr, int i) {
        return Float.intBitsToFloat(zza(bArr, i));
    }

    static int zzc(byte[] bArr, int i, zzeb zzebVar) {
        int iZza = zza(bArr, i, zzebVar);
        int i2 = zzebVar.zza;
        if (i2 < 0) {
            throw zzfw.zzb();
        }
        if (i2 == 0) {
            zzebVar.zzc = "";
            return iZza;
        }
        zzebVar.zzc = new String(bArr, iZza, i2, zzfr.zza);
        return iZza + i2;
    }

    static int zzd(byte[] bArr, int i, zzeb zzebVar) {
        int iZza = zza(bArr, i, zzebVar);
        int i2 = zzebVar.zza;
        if (i2 < 0) {
            throw zzfw.zzb();
        }
        if (i2 == 0) {
            zzebVar.zzc = "";
            return iZza;
        }
        zzebVar.zzc = zzip.zzb(bArr, iZza, i2);
        return iZza + i2;
    }

    static int zze(byte[] bArr, int i, zzeb zzebVar) {
        int iZza = zza(bArr, i, zzebVar);
        int i2 = zzebVar.zza;
        if (i2 < 0) {
            throw zzfw.zzb();
        }
        if (i2 > bArr.length - iZza) {
            throw zzfw.zza();
        }
        if (i2 == 0) {
            zzebVar.zzc = zzeg.zza;
            return iZza;
        }
        zzebVar.zzc = zzeg.zza(bArr, iZza, i2);
        return iZza + i2;
    }

    static int zza(zzhp zzhpVar, byte[] bArr, int i, int i2, zzeb zzebVar) {
        int iZza = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZza = zza(i3, bArr, iZza, zzebVar);
            i3 = zzebVar.zza;
        }
        int i4 = iZza;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzfw.zza();
        }
        Object objZza = zzhpVar.zza();
        int i5 = i3 + i4;
        zzhpVar.zza(objZza, bArr, i4, i5, zzebVar);
        zzhpVar.zzc(objZza);
        zzebVar.zzc = objZza;
        return i5;
    }

    static int zza(zzhp zzhpVar, byte[] bArr, int i, int i2, int i3, zzeb zzebVar) {
        zzha zzhaVar = (zzha) zzhpVar;
        Object objZza = zzhaVar.zza();
        int iZza = zzhaVar.zza(objZza, bArr, i, i2, i3, zzebVar);
        zzhaVar.zzc(objZza);
        zzebVar.zzc = objZza;
        return iZza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzfx zzfxVar, zzeb zzebVar) {
        zzfp zzfpVar = (zzfp) zzfxVar;
        int iZza = zza(bArr, i2, zzebVar);
        zzfpVar.zzd(zzebVar.zza);
        while (iZza < i3) {
            int iZza2 = zza(bArr, iZza, zzebVar);
            if (i != zzebVar.zza) {
                break;
            }
            iZza = zza(bArr, iZza2, zzebVar);
            zzfpVar.zzd(zzebVar.zza);
        }
        return iZza;
    }

    static int zza(byte[] bArr, int i, zzfx zzfxVar, zzeb zzebVar) {
        zzfp zzfpVar = (zzfp) zzfxVar;
        int iZza = zza(bArr, i, zzebVar);
        int i2 = zzebVar.zza + iZza;
        while (iZza < i2) {
            iZza = zza(bArr, iZza, zzebVar);
            zzfpVar.zzd(zzebVar.zza);
        }
        if (iZza == i2) {
            return iZza;
        }
        throw zzfw.zza();
    }

    static int zza(zzhp zzhpVar, int i, byte[] bArr, int i2, int i3, zzfx zzfxVar, zzeb zzebVar) {
        int iZza = zza(zzhpVar, bArr, i2, i3, zzebVar);
        zzfxVar.add(zzebVar.zzc);
        while (iZza < i3) {
            int iZza2 = zza(bArr, iZza, zzebVar);
            if (i != zzebVar.zza) {
                break;
            }
            iZza = zza(zzhpVar, bArr, iZza2, i3, zzebVar);
            zzfxVar.add(zzebVar.zzc);
        }
        return iZza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzig zzigVar, zzeb zzebVar) {
        if ((i >>> 3) == 0) {
            throw zzfw.zzd();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzb = zzb(bArr, i2, zzebVar);
            zzigVar.zza(i, Long.valueOf(zzebVar.zzb));
            return iZzb;
        }
        if (i4 == 1) {
            zzigVar.zza(i, Long.valueOf(zzb(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZza = zza(bArr, i2, zzebVar);
            int i5 = zzebVar.zza;
            if (i5 < 0) {
                throw zzfw.zzb();
            }
            if (i5 > bArr.length - iZza) {
                throw zzfw.zza();
            }
            if (i5 == 0) {
                zzigVar.zza(i, zzeg.zza);
            } else {
                zzigVar.zza(i, zzeg.zza(bArr, iZza, i5));
            }
            return iZza + i5;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                zzigVar.zza(i, Integer.valueOf(zza(bArr, i2)));
                return i2 + 4;
            }
            throw zzfw.zzd();
        }
        zzig zzigVarZzb = zzig.zzb();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZza2 = zza(bArr, i2, zzebVar);
            int i8 = zzebVar.zza;
            i7 = i8;
            if (i8 == i6) {
                i2 = iZza2;
                break;
            }
            int iZza3 = zza(i7, bArr, iZza2, i3, zzigVarZzb, zzebVar);
            i7 = i8;
            i2 = iZza3;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzfw.zzg();
        }
        zzigVar.zza(i, zzigVarZzb);
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzeb zzebVar) {
        if ((i >>> 3) == 0) {
            throw zzfw.zzd();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzb(bArr, i2, zzebVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zza(bArr, i2, zzebVar) + zzebVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzfw.zzd();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zza(bArr, i2, zzebVar);
            i6 = zzebVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zza(i6, bArr, i2, i3, zzebVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzfw.zzg();
        }
        return i2;
    }
}
