package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.common.base.Ascii;

/* loaded from: classes3.dex */
abstract class zzcv {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static volatile int zzb = 100;

    static int zza(byte[] bArr, int i, zzcu zzcuVar) throws zzer {
        int iZzj = zzj(bArr, i, zzcuVar);
        int i2 = zzcuVar.zza;
        if (i2 < 0) {
            throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 > bArr.length - iZzj) {
            throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i2 == 0) {
            zzcuVar.zzc = zzdf.zzb;
            return iZzj;
        }
        zzcuVar.zzc = zzdf.zzr(bArr, iZzj, i2);
        return iZzj + i2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static int zzb(int i, byte[] bArr, int i2, int i3, zzed zzedVar, zzef zzefVar, zzgs zzgsVar, zzcu zzcuVar) throws zzer {
        int i4;
        zzdx zzdxVar = zzedVar.zzb;
        zzhf zzhfVar = zzefVar.zzb.zzb;
        Object objValueOf = null;
        if (zzhfVar == zzhf.zzn) {
            zzj(bArr, i2, zzcuVar);
            throw null;
        }
        switch (zzhfVar.ordinal()) {
            case 0:
                i4 = i2 + 8;
                objValueOf = Double.valueOf(Double.longBitsToDouble(zzq(bArr, i2)));
                i2 = i4;
                zzdxVar.zzi(zzefVar.zzb, objValueOf);
                return i2;
            case 1:
                i4 = i2 + 4;
                objValueOf = Float.valueOf(Float.intBitsToFloat(zzc(bArr, i2)));
                i2 = i4;
                zzdxVar.zzi(zzefVar.zzb, objValueOf);
                return i2;
            case 2:
            case 3:
                i2 = zzm(bArr, i2, zzcuVar);
                objValueOf = Long.valueOf(zzcuVar.zzb);
                zzdxVar.zzi(zzefVar.zzb, objValueOf);
                return i2;
            case 4:
            case 12:
                i2 = zzj(bArr, i2, zzcuVar);
                objValueOf = Integer.valueOf(zzcuVar.zza);
                zzdxVar.zzi(zzefVar.zzb, objValueOf);
                return i2;
            case 5:
            case 15:
                i4 = i2 + 8;
                objValueOf = Long.valueOf(zzq(bArr, i2));
                i2 = i4;
                zzdxVar.zzi(zzefVar.zzb, objValueOf);
                return i2;
            case 6:
            case 14:
                i4 = i2 + 4;
                objValueOf = Integer.valueOf(zzc(bArr, i2));
                i2 = i4;
                zzdxVar.zzi(zzefVar.zzb, objValueOf);
                return i2;
            case 7:
                i2 = zzm(bArr, i2, zzcuVar);
                objValueOf = Boolean.valueOf(zzcuVar.zzb != 0);
                zzdxVar.zzi(zzefVar.zzb, objValueOf);
                return i2;
            case 8:
                i2 = zzh(bArr, i2, zzcuVar);
                objValueOf = zzcuVar.zzc;
                zzdxVar.zzi(zzefVar.zzb, objValueOf);
                return i2;
            case 9:
                int i5 = ((i >>> 3) << 3) | 4;
                zzge zzgeVarZzb = zzfu.zza().zzb(zzefVar.zza.getClass());
                Object objZze = zzdxVar.zze(zzefVar.zzb);
                if (objZze == null) {
                    objZze = zzgeVarZzb.zze();
                    zzdxVar.zzi(zzefVar.zzb, objZze);
                }
                return zzn(objZze, zzgeVarZzb, bArr, i2, i3, i5, zzcuVar);
            case 10:
                zzge zzgeVarZzb2 = zzfu.zza().zzb(zzefVar.zza.getClass());
                Object objZze2 = zzdxVar.zze(zzefVar.zzb);
                if (objZze2 == null) {
                    objZze2 = zzgeVarZzb2.zze();
                    zzdxVar.zzi(zzefVar.zzb, objZze2);
                }
                return zzo(objZze2, zzgeVarZzb2, bArr, i2, i3, zzcuVar);
            case 11:
                i2 = zza(bArr, i2, zzcuVar);
                objValueOf = zzcuVar.zzc;
                zzdxVar.zzi(zzefVar.zzb, objValueOf);
                return i2;
            case 13:
                throw new IllegalStateException("Shouldn't reach here.");
            case 16:
                i2 = zzj(bArr, i2, zzcuVar);
                objValueOf = Integer.valueOf(zzdj.zzb(zzcuVar.zza));
                zzdxVar.zzi(zzefVar.zzb, objValueOf);
                return i2;
            case 17:
                i2 = zzm(bArr, i2, zzcuVar);
                objValueOf = Long.valueOf(zzdj.zzc(zzcuVar.zzb));
                zzdxVar.zzi(zzefVar.zzb, objValueOf);
                return i2;
            default:
                zzdxVar.zzi(zzefVar.zzb, objValueOf);
                return i2;
        }
    }

    static int zzc(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    static int zzd(zzge zzgeVar, byte[] bArr, int i, int i2, int i3, zzcu zzcuVar) throws zzer {
        Object objZze = zzgeVar.zze();
        int iZzn = zzn(objZze, zzgeVar, bArr, i, i2, i3, zzcuVar);
        zzgeVar.zzf(objZze);
        zzcuVar.zzc = objZze;
        return iZzn;
    }

    static int zze(zzge zzgeVar, byte[] bArr, int i, int i2, zzcu zzcuVar) throws zzer {
        Object objZze = zzgeVar.zze();
        int iZzo = zzo(objZze, zzgeVar, bArr, i, i2, zzcuVar);
        zzgeVar.zzf(objZze);
        zzcuVar.zzc = objZze;
        return iZzo;
    }

    static int zzf(zzge zzgeVar, int i, byte[] bArr, int i2, int i3, zzeo zzeoVar, zzcu zzcuVar) throws zzer {
        int iZze = zze(zzgeVar, bArr, i2, i3, zzcuVar);
        zzeoVar.add(zzcuVar.zzc);
        while (iZze < i3) {
            int iZzj = zzj(bArr, iZze, zzcuVar);
            if (i != zzcuVar.zza) {
                break;
            }
            iZze = zze(zzgeVar, bArr, iZzj, i3, zzcuVar);
            zzeoVar.add(zzcuVar.zzc);
        }
        return iZze;
    }

    static int zzg(byte[] bArr, int i, zzeo zzeoVar, zzcu zzcuVar) throws zzer {
        zzei zzeiVar = (zzei) zzeoVar;
        int iZzj = zzj(bArr, i, zzcuVar);
        int i2 = zzcuVar.zza + iZzj;
        while (iZzj < i2) {
            iZzj = zzj(bArr, iZzj, zzcuVar);
            zzeiVar.zzg(zzcuVar.zza);
        }
        if (iZzj == i2) {
            return iZzj;
        }
        throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int zzh(byte[] bArr, int i, zzcu zzcuVar) throws zzer {
        int iZzj = zzj(bArr, i, zzcuVar);
        int i2 = zzcuVar.zza;
        if (i2 < 0) {
            throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 == 0) {
            zzcuVar.zzc = "";
            return iZzj;
        }
        zzcuVar.zzc = new String(bArr, iZzj, i2, zzep.zza);
        return iZzj + i2;
    }

    static int zzi(int i, byte[] bArr, int i2, int i3, zzgt zzgtVar, zzcu zzcuVar) throws zzer {
        if ((i >>> 3) == 0) {
            throw new zzer("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzm = zzm(bArr, i2, zzcuVar);
            zzgtVar.zzj(i, Long.valueOf(zzcuVar.zzb));
            return iZzm;
        }
        if (i4 == 1) {
            zzgtVar.zzj(i, Long.valueOf(zzq(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzj = zzj(bArr, i2, zzcuVar);
            int i5 = zzcuVar.zza;
            if (i5 < 0) {
                throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i5 > bArr.length - iZzj) {
                throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i5 == 0) {
                zzgtVar.zzj(i, zzdf.zzb);
            } else {
                zzgtVar.zzj(i, zzdf.zzr(bArr, iZzj, i5));
            }
            return iZzj + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new zzer("Protocol message contained an invalid tag (zero).");
            }
            zzgtVar.zzj(i, Integer.valueOf(zzc(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzgt zzgtVarZzf = zzgt.zzf();
        int i7 = zzcuVar.zze + 1;
        zzcuVar.zze = i7;
        zzr(i7);
        int i8 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZzj2 = zzj(bArr, i2, zzcuVar);
            i8 = zzcuVar.zza;
            if (i8 == i6) {
                i2 = iZzj2;
                break;
            }
            i2 = zzi(i8, bArr, iZzj2, i3, zzgtVarZzf, zzcuVar);
        }
        zzcuVar.zze--;
        if (i2 > i3 || i8 != i6) {
            throw new zzer("Failed to parse the message.");
        }
        zzgtVar.zzj(i, zzgtVarZzf);
        return i2;
    }

    static int zzj(byte[] bArr, int i, zzcu zzcuVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zzcuVar);
        }
        zzcuVar.zza = b;
        return i2;
    }

    static int zzk(int i, byte[] bArr, int i2, zzcu zzcuVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzcuVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzcuVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzcuVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzcuVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzcuVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzl(int i, byte[] bArr, int i2, int i3, zzeo zzeoVar, zzcu zzcuVar) {
        zzei zzeiVar = (zzei) zzeoVar;
        int iZzj = zzj(bArr, i2, zzcuVar);
        zzeiVar.zzg(zzcuVar.zza);
        while (iZzj < i3) {
            int iZzj2 = zzj(bArr, iZzj, zzcuVar);
            if (i != zzcuVar.zza) {
                break;
            }
            iZzj = zzj(bArr, iZzj2, zzcuVar);
            zzeiVar.zzg(zzcuVar.zza);
        }
        return iZzj;
    }

    static int zzm(byte[] bArr, int i, zzcu zzcuVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzcuVar.zzb = j;
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
        zzcuVar.zzb = j2;
        return i3;
    }

    static int zzn(Object obj, zzge zzgeVar, byte[] bArr, int i, int i2, int i3, zzcu zzcuVar) throws zzer {
        zzfp zzfpVar = (zzfp) zzgeVar;
        int i4 = zzcuVar.zze + 1;
        zzcuVar.zze = i4;
        zzr(i4);
        int iZzc = zzfpVar.zzc(obj, bArr, i, i2, i3, zzcuVar);
        zzcuVar.zze--;
        zzcuVar.zzc = obj;
        return iZzc;
    }

    static int zzo(Object obj, zzge zzgeVar, byte[] bArr, int i, int i2, zzcu zzcuVar) throws zzer {
        int iZzk = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzk = zzk(i3, bArr, iZzk, zzcuVar);
            i3 = zzcuVar.zza;
        }
        int i4 = iZzk;
        if (i3 < 0 || i3 > i2 - i4) {
            throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i5 = zzcuVar.zze + 1;
        zzcuVar.zze = i5;
        zzr(i5);
        int i6 = i3 + i4;
        zzgeVar.zzh(obj, bArr, i4, i6, zzcuVar);
        zzcuVar.zze--;
        zzcuVar.zzc = obj;
        return i6;
    }

    static int zzp(int i, byte[] bArr, int i2, int i3, zzcu zzcuVar) throws zzer {
        if ((i >>> 3) == 0) {
            throw new zzer("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzm(bArr, i2, zzcuVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zzj(bArr, i2, zzcuVar) + zzcuVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw new zzer("Protocol message contained an invalid tag (zero).");
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zzj(bArr, i2, zzcuVar);
            i6 = zzcuVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zzp(i6, bArr, i2, i3, zzcuVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw new zzer("Failed to parse the message.");
        }
        return i2;
    }

    static long zzq(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }

    private static void zzr(int i) throws zzer {
        if (i >= zzb) {
            throw new zzer("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
