package com.google.android.gms.internal.measurement;

import androidx.camera.video.AudioStats;
import androidx.slidingpanelayout.widget.SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.asn1.eac.EACTags;
import org.bouncycastle.bcpg.PacketTags;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
final class zzha implements zzhp {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzin.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgw zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzhe zzo;
    private final zzgg zzp;
    private final zzih zzq;
    private final zzfd zzr;
    private final zzgt zzs;

    private zzha(int[] iArr, Object[] objArr, int i, int i2, zzgw zzgwVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzhe zzheVar, zzgg zzggVar, zzih zzihVar, zzfd zzfdVar, zzgt zzgtVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzgwVar instanceof zzfo;
        this.zzj = z;
        this.zzh = zzfdVar != null && zzfdVar.zza(zzgwVar);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzheVar;
        this.zzp = zzggVar;
        this.zzq = zzihVar;
        this.zzr = zzfdVar;
        this.zzg = zzgwVar;
        this.zzs = zzgtVar;
    }

    private static boolean zzf(int i) {
        return (i & 536870912) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:163:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x038b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.google.android.gms.internal.measurement.zzha zza(java.lang.Class r31, com.google.android.gms.internal.measurement.zzgu r32, com.google.android.gms.internal.measurement.zzhe r33, com.google.android.gms.internal.measurement.zzgg r34, com.google.android.gms.internal.measurement.zzih r35, com.google.android.gms.internal.measurement.zzfd r36, com.google.android.gms.internal.measurement.zzgt r37) {
        /*
            Method dump skipped, instructions count: 1032
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzha.zza(java.lang.Class, com.google.android.gms.internal.measurement.zzgu, com.google.android.gms.internal.measurement.zzhe, com.google.android.gms.internal.measurement.zzgg, com.google.android.gms.internal.measurement.zzih, com.google.android.gms.internal.measurement.zzfd, com.google.android.gms.internal.measurement.zzgt):com.google.android.gms.internal.measurement.zzha");
    }

    private static Field zza(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + name.length() + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(string);
            throw new RuntimeException(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhp
    public final Object zza() {
        return this.zzo.zza(this.zzg);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    @Override // com.google.android.gms.internal.measurement.zzhp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zza(java.lang.Object r10, java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 642
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzha.zza(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.measurement.zzhp
    public final int zza(Object obj) {
        int i;
        int iZza;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzd = zzd(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzd;
            int iHashCode = 37;
            switch ((iZzd & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    iZza = zzfr.zza(Double.doubleToLongBits(zzin.zze(obj, j)));
                    i2 = i + iZza;
                    break;
                case 1:
                    i = i2 * 53;
                    iZza = Float.floatToIntBits(zzin.zzd(obj, j));
                    i2 = i + iZza;
                    break;
                case 2:
                    i = i2 * 53;
                    iZza = zzfr.zza(zzin.zzb(obj, j));
                    i2 = i + iZza;
                    break;
                case 3:
                    i = i2 * 53;
                    iZza = zzfr.zza(zzin.zzb(obj, j));
                    i2 = i + iZza;
                    break;
                case 4:
                    i = i2 * 53;
                    iZza = zzin.zza(obj, j);
                    i2 = i + iZza;
                    break;
                case 5:
                    i = i2 * 53;
                    iZza = zzfr.zza(zzin.zzb(obj, j));
                    i2 = i + iZza;
                    break;
                case 6:
                    i = i2 * 53;
                    iZza = zzin.zza(obj, j);
                    i2 = i + iZza;
                    break;
                case 7:
                    i = i2 * 53;
                    iZza = zzfr.zza(zzin.zzc(obj, j));
                    i2 = i + iZza;
                    break;
                case 8:
                    i = i2 * 53;
                    iZza = ((String) zzin.zzf(obj, j)).hashCode();
                    i2 = i + iZza;
                    break;
                case 9:
                    Object objZzf = zzin.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZza = zzin.zzf(obj, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 11:
                    i = i2 * 53;
                    iZza = zzin.zza(obj, j);
                    i2 = i + iZza;
                    break;
                case 12:
                    i = i2 * 53;
                    iZza = zzin.zza(obj, j);
                    i2 = i + iZza;
                    break;
                case 13:
                    i = i2 * 53;
                    iZza = zzin.zza(obj, j);
                    i2 = i + iZza;
                    break;
                case 14:
                    i = i2 * 53;
                    iZza = zzfr.zza(zzin.zzb(obj, j));
                    i2 = i + iZza;
                    break;
                case 15:
                    i = i2 * 53;
                    iZza = zzin.zza(obj, j);
                    i2 = i + iZza;
                    break;
                case 16:
                    i = i2 * 53;
                    iZza = zzfr.zza(zzin.zzb(obj, j));
                    i2 = i + iZza;
                    break;
                case 17:
                    Object objZzf2 = zzin.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iZza = zzin.zzf(obj, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 50:
                    i = i2 * 53;
                    iZza = zzin.zzf(obj, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 51:
                    if (zza(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzfr.zza(Double.doubleToLongBits(zzb(obj, j)));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zza(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = Float.floatToIntBits(zzc(obj, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case EACTags.SEX /* 53 */:
                    if (zza(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzfr.zza(zze(obj, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case EACTags.CURRENCY_EXPONENT /* 54 */:
                    if (zza(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzfr.zza(zze(obj, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zza(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(obj, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zza(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzfr.zza(zze(obj, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zza(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(obj, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zza(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzfr.zza(zzf(obj, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (zza(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = ((String) zzin.zzf(obj, j)).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zza(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzin.zzf(obj, j).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zza(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzin.zzf(obj, j).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case PacketTags.EXPERIMENTAL_3 /* 62 */:
                    if (zza(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(obj, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zza(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(obj, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zza(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(obj, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case EACTags.ELEMENT_LIST /* 65 */:
                    if (zza(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzfr.zza(zze(obj, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case EACTags.ADDRESS /* 66 */:
                    if (zza(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(obj, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zza(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzfr.zza(zze(obj, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zza(obj, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzin.zzf(obj, j).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzq.zzb(obj).hashCode();
        return this.zzh ? (iHashCode2 * 53) + this.zzr.zza(obj).hashCode() : iHashCode2;
    }

    @Override // com.google.android.gms.internal.measurement.zzhp
    public final void zzb(Object obj, Object obj2) {
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzd = zzd(i);
            long j = 1048575 & iZzd;
            int i2 = this.zzc[i];
            switch ((iZzd & 267386880) >>> 20) {
                case 0:
                    if (zza(obj2, i)) {
                        zzin.zza(obj, j, zzin.zze(obj2, j));
                        zzb(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zza(obj2, i)) {
                        zzin.zza(obj, j, zzin.zzd(obj2, j));
                        zzb(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zza(obj2, i)) {
                        zzin.zza(obj, j, zzin.zzb(obj2, j));
                        zzb(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zza(obj2, i)) {
                        zzin.zza(obj, j, zzin.zzb(obj2, j));
                        zzb(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zza(obj2, i)) {
                        zzin.zza(obj, j, zzin.zza(obj2, j));
                        zzb(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zza(obj2, i)) {
                        zzin.zza(obj, j, zzin.zzb(obj2, j));
                        zzb(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zza(obj2, i)) {
                        zzin.zza(obj, j, zzin.zza(obj2, j));
                        zzb(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zza(obj2, i)) {
                        zzin.zza(obj, j, zzin.zzc(obj2, j));
                        zzb(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zza(obj2, i)) {
                        zzin.zza(obj, j, zzin.zzf(obj2, j));
                        zzb(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(obj, obj2, i);
                    break;
                case 10:
                    if (zza(obj2, i)) {
                        zzin.zza(obj, j, zzin.zzf(obj2, j));
                        zzb(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zza(obj2, i)) {
                        zzin.zza(obj, j, zzin.zza(obj2, j));
                        zzb(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zza(obj2, i)) {
                        zzin.zza(obj, j, zzin.zza(obj2, j));
                        zzb(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zza(obj2, i)) {
                        zzin.zza(obj, j, zzin.zza(obj2, j));
                        zzb(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zza(obj2, i)) {
                        zzin.zza(obj, j, zzin.zzb(obj2, j));
                        zzb(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zza(obj2, i)) {
                        zzin.zza(obj, j, zzin.zza(obj2, j));
                        zzb(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zza(obj2, i)) {
                        zzin.zza(obj, j, zzin.zzb(obj2, j));
                        zzb(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zza(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzp.zza(obj, obj2, j);
                    break;
                case 50:
                    zzhr.zza(this.zzs, obj, obj2, j);
                    break;
                case 51:
                case 52:
                case EACTags.SEX /* 53 */:
                case EACTags.CURRENCY_EXPONENT /* 54 */:
                case 55:
                case 56:
                case 57:
                case 58:
                case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (zza(obj2, i2, i)) {
                        zzin.zza(obj, j, zzin.zzf(obj2, j));
                        zzb(obj, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzb(obj, obj2, i);
                    break;
                case 61:
                case PacketTags.EXPERIMENTAL_3 /* 62 */:
                case 63:
                case 64:
                case EACTags.ELEMENT_LIST /* 65 */:
                case EACTags.ADDRESS /* 66 */:
                case 67:
                    if (zza(obj2, i2, i)) {
                        zzin.zza(obj, j, zzin.zzf(obj2, j));
                        zzb(obj, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzb(obj, obj2, i);
                    break;
            }
        }
        zzhr.zza(this.zzq, obj, obj2);
        if (this.zzh) {
            zzhr.zza(this.zzr, obj, obj2);
        }
    }

    private final void zza(Object obj, Object obj2, int i) {
        long jZzd = zzd(i) & 1048575;
        if (zza(obj2, i)) {
            Object objZzf = zzin.zzf(obj, jZzd);
            Object objZzf2 = zzin.zzf(obj2, jZzd);
            if (objZzf != null && objZzf2 != null) {
                zzin.zza(obj, jZzd, zzfr.zza(objZzf, objZzf2));
                zzb(obj, i);
            } else if (objZzf2 != null) {
                zzin.zza(obj, jZzd, objZzf2);
                zzb(obj, i);
            }
        }
    }

    private final void zzb(Object obj, Object obj2, int i) {
        int iZzd = zzd(i);
        int i2 = this.zzc[i];
        long j = iZzd & 1048575;
        if (zza(obj2, i2, i)) {
            Object objZzf = zzin.zzf(obj, j);
            Object objZzf2 = zzin.zzf(obj2, j);
            if (objZzf != null && objZzf2 != null) {
                zzin.zza(obj, j, zzfr.zza(objZzf, objZzf2));
                zzb(obj, i2, i);
            } else if (objZzf2 != null) {
                zzin.zza(obj, j, objZzf2);
                zzb(obj, i2, i);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0569 A[PHI: r4
  0x0569: PHI (r4v4 int) = 
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v14 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v1 int)
  (r4v15 int)
  (r4v1 int)
 binds: [B:256:0x0550, B:461:0x09c5, B:458:0x09bb, B:452:0x099f, B:449:0x098d, B:446:0x097d, B:443:0x096f, B:440:0x0961, B:437:0x0956, B:434:0x094a, B:431:0x093c, B:428:0x092e, B:425:0x091a, B:401:0x0829, B:395:0x080b, B:389:0x07ed, B:383:0x07cf, B:377:0x07b1, B:371:0x0793, B:365:0x0775, B:359:0x0757, B:353:0x0739, B:347:0x071c, B:341:0x06ff, B:335:0x06e2, B:329:0x06c5, B:322:0x06a5, B:317:0x0671, B:314:0x0664, B:311:0x0654, B:308:0x0644, B:305:0x0634, B:302:0x0626, B:299:0x061a, B:296:0x060e, B:290:0x05f0, B:287:0x05dc, B:284:0x05cb, B:281:0x05bc, B:278:0x05ad, B:276:0x05a7, B:274:0x05a0, B:271:0x0593, B:268:0x0584, B:265:0x0575, B:261:0x0568, B:259:0x0558] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.measurement.zzhp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzb(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 2986
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzha.zzb(java.lang.Object):int");
    }

    private static int zza(zzih zzihVar, Object obj) {
        return zzihVar.zzf(zzihVar.zzb(obj));
    }

    private static List zza(Object obj, long j) {
        return (List) zzin.zzf(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    @Override // com.google.android.gms.internal.measurement.zzhp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.lang.Object r14, com.google.android.gms.internal.measurement.zzja r15) {
        /*
            Method dump skipped, instructions count: 2916
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzha.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzja):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzb(java.lang.Object r18, com.google.android.gms.internal.measurement.zzja r19) {
        /*
            Method dump skipped, instructions count: 1338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzha.zzb(java.lang.Object, com.google.android.gms.internal.measurement.zzja):void");
    }

    private final void zza(zzja zzjaVar, int i, Object obj, int i2) {
        if (obj != null) {
            this.zzs.zzb(zzb(i2));
            zzjaVar.zza(i, (zzgr) null, this.zzs.zzc(obj));
        }
    }

    private static void zza(zzih zzihVar, Object obj, zzja zzjaVar) {
        zzihVar.zza(zzihVar.zzb(obj), zzjaVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:168:0x05ce A[LOOP:5: B:166:0x05ca->B:168:0x05ce, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x05db  */
    @Override // com.google.android.gms.internal.measurement.zzhp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.lang.Object r13, com.google.android.gms.internal.measurement.zzhm r14, com.google.android.gms.internal.measurement.zzfb r15) {
        /*
            Method dump skipped, instructions count: 1646
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzha.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzhm, com.google.android.gms.internal.measurement.zzfb):void");
    }

    private static zzig zze(Object obj) {
        zzfo zzfoVar = (zzfo) obj;
        zzig zzigVar = zzfoVar.zzb;
        if (zzigVar != zzig.zza()) {
            return zzigVar;
        }
        zzig zzigVarZzb = zzig.zzb();
        zzfoVar.zzb = zzigVarZzb;
        return zzigVarZzb;
    }

    private final int zza(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzeb zzebVar) throws zzfw {
        int iZza;
        int iZza2;
        int iZza3 = i;
        Unsafe unsafe = zzb;
        zzfx zzfxVarZza = (zzfx) unsafe.getObject(obj, j2);
        if (!zzfxVarZza.zza()) {
            int size = zzfxVarZza.size();
            zzfxVarZza = zzfxVarZza.zza(size == 0 ? 10 : size << 1);
            unsafe.putObject(obj, j2, zzfxVarZza);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m(zzfxVarZza);
                    int iZza4 = zzec.zza(bArr, iZza3, zzebVar);
                    int i8 = zzebVar.zza + iZza4;
                    if (iZza4 < i8) {
                        zzec.zzc(bArr, iZza4);
                        throw null;
                    }
                    if (iZza4 == i8) {
                        return iZza4;
                    }
                    throw zzfw.zza();
                }
                if (i5 == 1) {
                    SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m(zzfxVarZza);
                    zzec.zzc(bArr, i);
                    throw null;
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m(zzfxVarZza);
                    int iZza5 = zzec.zza(bArr, iZza3, zzebVar);
                    int i9 = zzebVar.zza + iZza5;
                    if (iZza5 < i9) {
                        zzec.zzd(bArr, iZza5);
                        throw null;
                    }
                    if (iZza5 == i9) {
                        return iZza5;
                    }
                    throw zzfw.zza();
                }
                if (i5 == 5) {
                    SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m(zzfxVarZza);
                    zzec.zzd(bArr, i);
                    throw null;
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzgk zzgkVar = (zzgk) zzfxVarZza;
                    int iZza6 = zzec.zza(bArr, iZza3, zzebVar);
                    int i10 = zzebVar.zza + iZza6;
                    while (iZza6 < i10) {
                        iZza6 = zzec.zzb(bArr, iZza6, zzebVar);
                        zzgkVar.zza(zzebVar.zzb);
                    }
                    if (iZza6 == i10) {
                        return iZza6;
                    }
                    throw zzfw.zza();
                }
                if (i5 == 0) {
                    zzgk zzgkVar2 = (zzgk) zzfxVarZza;
                    int iZzb = zzec.zzb(bArr, iZza3, zzebVar);
                    zzgkVar2.zza(zzebVar.zzb);
                    while (iZzb < i2) {
                        int iZza7 = zzec.zza(bArr, iZzb, zzebVar);
                        if (i3 != zzebVar.zza) {
                            return iZzb;
                        }
                        iZzb = zzec.zzb(bArr, iZza7, zzebVar);
                        zzgkVar2.zza(zzebVar.zzb);
                    }
                    return iZzb;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzec.zza(bArr, iZza3, zzfxVarZza, zzebVar);
                }
                if (i5 == 0) {
                    return zzec.zza(i3, bArr, i, i2, zzfxVarZza, zzebVar);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzgk zzgkVar3 = (zzgk) zzfxVarZza;
                    int iZza8 = zzec.zza(bArr, iZza3, zzebVar);
                    int i11 = zzebVar.zza + iZza8;
                    while (iZza8 < i11) {
                        zzgkVar3.zza(zzec.zzb(bArr, iZza8));
                        iZza8 += 8;
                    }
                    if (iZza8 == i11) {
                        return iZza8;
                    }
                    throw zzfw.zza();
                }
                if (i5 == 1) {
                    zzgk zzgkVar4 = (zzgk) zzfxVarZza;
                    zzgkVar4.zza(zzec.zzb(bArr, i));
                    int i12 = iZza3 + 8;
                    while (i12 < i2) {
                        int iZza9 = zzec.zza(bArr, i12, zzebVar);
                        if (i3 != zzebVar.zza) {
                            return i12;
                        }
                        zzgkVar4.zza(zzec.zzb(bArr, iZza9));
                        i12 = iZza9 + 8;
                    }
                    return i12;
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzfp zzfpVar = (zzfp) zzfxVarZza;
                    int iZza10 = zzec.zza(bArr, iZza3, zzebVar);
                    int i13 = zzebVar.zza + iZza10;
                    while (iZza10 < i13) {
                        zzfpVar.zzd(zzec.zza(bArr, iZza10));
                        iZza10 += 4;
                    }
                    if (iZza10 == i13) {
                        return iZza10;
                    }
                    throw zzfw.zza();
                }
                if (i5 == 5) {
                    zzfp zzfpVar2 = (zzfp) zzfxVarZza;
                    zzfpVar2.zzd(zzec.zza(bArr, i));
                    int i14 = iZza3 + 4;
                    while (i14 < i2) {
                        int iZza11 = zzec.zza(bArr, i14, zzebVar);
                        if (i3 != zzebVar.zza) {
                            return i14;
                        }
                        zzfpVar2.zzd(zzec.zza(bArr, iZza11));
                        i14 = iZza11 + 4;
                    }
                    return i14;
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m(zzfxVarZza);
                    int iZza12 = zzec.zza(bArr, iZza3, zzebVar);
                    int i15 = zzebVar.zza + iZza12;
                    if (iZza12 < i15) {
                        zzec.zzb(bArr, iZza12, zzebVar);
                        throw null;
                    }
                    if (iZza12 == i15) {
                        return iZza12;
                    }
                    throw zzfw.zza();
                }
                if (i5 == 0) {
                    SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m(zzfxVarZza);
                    zzec.zzb(bArr, iZza3, zzebVar);
                    long j3 = zzebVar.zzb;
                    throw null;
                }
                break;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int iZza13 = zzec.zza(bArr, iZza3, zzebVar);
                        int i16 = zzebVar.zza;
                        if (i16 < 0) {
                            throw zzfw.zzb();
                        }
                        if (i16 == 0) {
                            zzfxVarZza.add("");
                        } else {
                            zzfxVarZza.add(new String(bArr, iZza13, i16, zzfr.zza));
                            iZza13 += i16;
                        }
                        while (iZza13 < i2) {
                            int iZza14 = zzec.zza(bArr, iZza13, zzebVar);
                            if (i3 != zzebVar.zza) {
                                return iZza13;
                            }
                            iZza13 = zzec.zza(bArr, iZza14, zzebVar);
                            int i17 = zzebVar.zza;
                            if (i17 < 0) {
                                throw zzfw.zzb();
                            }
                            if (i17 == 0) {
                                zzfxVarZza.add("");
                            } else {
                                zzfxVarZza.add(new String(bArr, iZza13, i17, zzfr.zza));
                                iZza13 += i17;
                            }
                        }
                        return iZza13;
                    }
                    int iZza15 = zzec.zza(bArr, iZza3, zzebVar);
                    int i18 = zzebVar.zza;
                    if (i18 < 0) {
                        throw zzfw.zzb();
                    }
                    if (i18 == 0) {
                        zzfxVarZza.add("");
                        iZza = iZza15;
                    } else {
                        iZza = iZza15 + i18;
                        if (!zzip.zza(bArr, iZza15, iZza)) {
                            throw zzfw.zzh();
                        }
                        zzfxVarZza.add(new String(bArr, iZza15, i18, zzfr.zza));
                    }
                    while (iZza < i2) {
                        int iZza16 = zzec.zza(bArr, iZza, zzebVar);
                        if (i3 != zzebVar.zza) {
                            return iZza;
                        }
                        iZza = zzec.zza(bArr, iZza16, zzebVar);
                        int i19 = zzebVar.zza;
                        if (i19 < 0) {
                            throw zzfw.zzb();
                        }
                        if (i19 == 0) {
                            zzfxVarZza.add("");
                        } else {
                            int i20 = iZza + i19;
                            if (!zzip.zza(bArr, iZza, i20)) {
                                throw zzfw.zzh();
                            }
                            zzfxVarZza.add(new String(bArr, iZza, i19, zzfr.zza));
                            iZza = i20;
                        }
                    }
                    return iZza;
                }
                break;
            case 27:
                if (i5 == 2) {
                    return zzec.zza(zza(i6), i3, bArr, i, i2, zzfxVarZza, zzebVar);
                }
                break;
            case 28:
                if (i5 == 2) {
                    int iZza17 = zzec.zza(bArr, iZza3, zzebVar);
                    int i21 = zzebVar.zza;
                    if (i21 < 0) {
                        throw zzfw.zzb();
                    }
                    if (i21 > bArr.length - iZza17) {
                        throw zzfw.zza();
                    }
                    if (i21 == 0) {
                        zzfxVarZza.add(zzeg.zza);
                    } else {
                        zzfxVarZza.add(zzeg.zza(bArr, iZza17, i21));
                        iZza17 += i21;
                    }
                    while (iZza17 < i2) {
                        int iZza18 = zzec.zza(bArr, iZza17, zzebVar);
                        if (i3 != zzebVar.zza) {
                            return iZza17;
                        }
                        iZza17 = zzec.zza(bArr, iZza18, zzebVar);
                        int i22 = zzebVar.zza;
                        if (i22 < 0) {
                            throw zzfw.zzb();
                        }
                        if (i22 > bArr.length - iZza17) {
                            throw zzfw.zza();
                        }
                        if (i22 == 0) {
                            zzfxVarZza.add(zzeg.zza);
                        } else {
                            zzfxVarZza.add(zzeg.zza(bArr, iZza17, i22));
                            iZza17 += i22;
                        }
                    }
                    return iZza17;
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    iZza2 = zzec.zza(bArr, iZza3, zzfxVarZza, zzebVar);
                } else if (i5 == 0) {
                    iZza2 = zzec.zza(i3, bArr, i, i2, zzfxVarZza, zzebVar);
                }
                zzfo zzfoVar = (zzfo) obj;
                zzig zzigVar = zzfoVar.zzb;
                zzig zzigVar2 = (zzig) zzhr.zza(i4, zzfxVarZza, zzc(i6), zzigVar != zzig.zza() ? zzigVar : null, this.zzq);
                if (zzigVar2 != null) {
                    zzfoVar.zzb = zzigVar2;
                }
                return iZza2;
            case 33:
            case 47:
                if (i5 == 2) {
                    zzfp zzfpVar3 = (zzfp) zzfxVarZza;
                    int iZza19 = zzec.zza(bArr, iZza3, zzebVar);
                    int i23 = zzebVar.zza + iZza19;
                    while (iZza19 < i23) {
                        iZza19 = zzec.zza(bArr, iZza19, zzebVar);
                        zzfpVar3.zzd(zzes.zze(zzebVar.zza));
                    }
                    if (iZza19 == i23) {
                        return iZza19;
                    }
                    throw zzfw.zza();
                }
                if (i5 == 0) {
                    zzfp zzfpVar4 = (zzfp) zzfxVarZza;
                    int iZza20 = zzec.zza(bArr, iZza3, zzebVar);
                    zzfpVar4.zzd(zzes.zze(zzebVar.zza));
                    while (iZza20 < i2) {
                        int iZza21 = zzec.zza(bArr, iZza20, zzebVar);
                        if (i3 != zzebVar.zza) {
                            return iZza20;
                        }
                        iZza20 = zzec.zza(bArr, iZza21, zzebVar);
                        zzfpVar4.zzd(zzes.zze(zzebVar.zza));
                    }
                    return iZza20;
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    zzgk zzgkVar5 = (zzgk) zzfxVarZza;
                    int iZza22 = zzec.zza(bArr, iZza3, zzebVar);
                    int i24 = zzebVar.zza + iZza22;
                    while (iZza22 < i24) {
                        iZza22 = zzec.zzb(bArr, iZza22, zzebVar);
                        zzgkVar5.zza(zzes.zza(zzebVar.zzb));
                    }
                    if (iZza22 == i24) {
                        return iZza22;
                    }
                    throw zzfw.zza();
                }
                if (i5 == 0) {
                    zzgk zzgkVar6 = (zzgk) zzfxVarZza;
                    int iZzb2 = zzec.zzb(bArr, iZza3, zzebVar);
                    zzgkVar6.zza(zzes.zza(zzebVar.zzb));
                    while (iZzb2 < i2) {
                        int iZza23 = zzec.zza(bArr, iZzb2, zzebVar);
                        if (i3 != zzebVar.zza) {
                            return iZzb2;
                        }
                        iZzb2 = zzec.zzb(bArr, iZza23, zzebVar);
                        zzgkVar6.zza(zzes.zza(zzebVar.zzb));
                    }
                    return iZzb2;
                }
                break;
            case 49:
                if (i5 == 3) {
                    zzhp zzhpVarZza = zza(i6);
                    int i25 = (i3 & (-8)) | 4;
                    iZza3 = zzec.zza(zzhpVarZza, bArr, i, i2, i25, zzebVar);
                    zzfxVarZza.add(zzebVar.zzc);
                    while (iZza3 < i2) {
                        int iZza24 = zzec.zza(bArr, iZza3, zzebVar);
                        if (i3 != zzebVar.zza) {
                            break;
                        } else {
                            iZza3 = zzec.zza(zzhpVarZza, bArr, iZza24, i2, i25, zzebVar);
                            zzfxVarZza.add(zzebVar.zzc);
                        }
                    }
                    break;
                }
                break;
        }
        return iZza3;
    }

    private final int zza(Object obj, byte[] bArr, int i, int i2, int i3, long j, zzeb zzebVar) throws zzfw {
        Unsafe unsafe = zzb;
        Object objZzb = zzb(i3);
        Object object = unsafe.getObject(obj, j);
        if (this.zzs.zzd(object)) {
            Object objZzf = this.zzs.zzf(objZzb);
            this.zzs.zza(objZzf, object);
            unsafe.putObject(obj, j, objZzf);
            object = objZzf;
        }
        this.zzs.zzb(objZzb);
        this.zzs.zza(object);
        int iZza = zzec.zza(bArr, i, zzebVar);
        int i4 = zzebVar.zza;
        if (i4 < 0 || i4 > i2 - iZza) {
            throw zzfw.zza();
        }
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int zza(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzeb zzebVar) throws zzfw {
        int iZzb;
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Double.valueOf(zzec.zzc(bArr, i)));
                    iZzb = i + 8;
                    unsafe.putInt(obj, j2, i4);
                    return iZzb;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Float.valueOf(zzec.zzd(bArr, i)));
                    iZzb = i + 4;
                    unsafe.putInt(obj, j2, i4);
                    return iZzb;
                }
                return i;
            case EACTags.SEX /* 53 */:
            case EACTags.CURRENCY_EXPONENT /* 54 */:
                if (i5 == 0) {
                    iZzb = zzec.zzb(bArr, i, zzebVar);
                    unsafe.putObject(obj, j, Long.valueOf(zzebVar.zzb));
                    unsafe.putInt(obj, j2, i4);
                    return iZzb;
                }
                return i;
            case 55:
            case PacketTags.EXPERIMENTAL_3 /* 62 */:
                if (i5 == 0) {
                    iZzb = zzec.zza(bArr, i, zzebVar);
                    unsafe.putObject(obj, j, Integer.valueOf(zzebVar.zza));
                    unsafe.putInt(obj, j2, i4);
                    return iZzb;
                }
                return i;
            case 56:
            case EACTags.ELEMENT_LIST /* 65 */:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Long.valueOf(zzec.zzb(bArr, i)));
                    iZzb = i + 8;
                    unsafe.putInt(obj, j2, i4);
                    return iZzb;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Integer.valueOf(zzec.zza(bArr, i)));
                    iZzb = i + 4;
                    unsafe.putInt(obj, j2, i4);
                    return iZzb;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    iZzb = zzec.zzb(bArr, i, zzebVar);
                    unsafe.putObject(obj, j, Boolean.valueOf(zzebVar.zzb != 0));
                    unsafe.putInt(obj, j2, i4);
                    return iZzb;
                }
                return i;
            case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                if (i5 == 2) {
                    int iZza = zzec.zza(bArr, i, zzebVar);
                    int i9 = zzebVar.zza;
                    if (i9 == 0) {
                        unsafe.putObject(obj, j, "");
                    } else {
                        if ((i6 & 536870912) != 0 && !zzip.zza(bArr, iZza, iZza + i9)) {
                            throw zzfw.zzh();
                        }
                        unsafe.putObject(obj, j, new String(bArr, iZza, i9, zzfr.zza));
                        iZza += i9;
                    }
                    unsafe.putInt(obj, j2, i4);
                    return iZza;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int iZza2 = zzec.zza(zza(i8), bArr, i, i2, zzebVar);
                    Object object = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                    if (object == null) {
                        unsafe.putObject(obj, j, zzebVar.zzc);
                    } else {
                        unsafe.putObject(obj, j, zzfr.zza(object, zzebVar.zzc));
                    }
                    unsafe.putInt(obj, j2, i4);
                    return iZza2;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    iZzb = zzec.zze(bArr, i, zzebVar);
                    unsafe.putObject(obj, j, zzebVar.zzc);
                    unsafe.putInt(obj, j2, i4);
                    return iZzb;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int iZza3 = zzec.zza(bArr, i, zzebVar);
                    int i10 = zzebVar.zza;
                    zzfs zzfsVarZzc = zzc(i8);
                    if (zzfsVarZzc == null || zzfsVarZzc.zza(i10)) {
                        unsafe.putObject(obj, j, Integer.valueOf(i10));
                        iZzb = iZza3;
                        unsafe.putInt(obj, j2, i4);
                        return iZzb;
                    }
                    zze(obj).zza(i3, Long.valueOf(i10));
                    return iZza3;
                }
                return i;
            case EACTags.ADDRESS /* 66 */:
                if (i5 == 0) {
                    iZzb = zzec.zza(bArr, i, zzebVar);
                    unsafe.putObject(obj, j, Integer.valueOf(zzes.zze(zzebVar.zza)));
                    unsafe.putInt(obj, j2, i4);
                    return iZzb;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    iZzb = zzec.zzb(bArr, i, zzebVar);
                    unsafe.putObject(obj, j, Long.valueOf(zzes.zza(zzebVar.zzb)));
                    unsafe.putInt(obj, j2, i4);
                    return iZzb;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    iZzb = zzec.zza(zza(i8), bArr, i, i2, (i3 & (-8)) | 4, zzebVar);
                    Object object2 = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(obj, j, zzebVar.zzc);
                    } else {
                        unsafe.putObject(obj, j, zzfr.zza(object2, zzebVar.zzc));
                    }
                    unsafe.putInt(obj, j2, i4);
                    return iZzb;
                }
                return i;
            default:
                return i;
        }
    }

    private final zzhp zza(int i) {
        int i2 = (i / 3) << 1;
        zzhp zzhpVar = (zzhp) this.zzd[i2];
        if (zzhpVar != null) {
            return zzhpVar;
        }
        zzhp zzhpVarZza = zzhl.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zzhpVarZza;
        return zzhpVarZza;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final zzfs zzc(int i) {
        return (zzfs) this.zzd[((i / 3) << 1) + 1];
    }

    /* JADX WARN: Code restructure failed: missing block: B:151:0x0458, code lost:
    
        if (r7 == 1048575) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x045a, code lost:
    
        r29.putInt(r13, r7, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0460, code lost:
    
        r1 = r9.zzm;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0465, code lost:
    
        if (r1 >= r9.zzn) goto L224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0467, code lost:
    
        r2 = (com.google.android.gms.internal.measurement.zzig) r9.zza(r13, r9.zzl[r1], r2, r9.zzq);
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0476, code lost:
    
        if (r2 == null) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0478, code lost:
    
        r9.zzq.zzb(r13, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x047d, code lost:
    
        if (r10 != 0) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0481, code lost:
    
        if (r0 != r34) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0488, code lost:
    
        throw com.google.android.gms.internal.measurement.zzfw.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x048b, code lost:
    
        if (r0 > r34) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x048d, code lost:
    
        if (r3 != r10) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x048f, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0494, code lost:
    
        throw com.google.android.gms.internal.measurement.zzfw.zzg();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zza(java.lang.Object r31, byte[] r32, int r33, int r34, int r35, com.google.android.gms.internal.measurement.zzeb r36) throws com.google.android.gms.internal.measurement.zzfw {
        /*
            Method dump skipped, instructions count: 1214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzha.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzeb):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x02ce, code lost:
    
        if (r0 == r5) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02d0, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02d7, code lost:
    
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r2 = r18;
        r10 = r19;
        r1 = r25;
        r6 = r27;
        r7 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0321, code lost:
    
        if (r0 == r15) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0340, code lost:
    
        if (r0 == r15) goto L102;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0094. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzhp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.lang.Object r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.measurement.zzeb r35) throws com.google.android.gms.internal.measurement.zzfw {
        /*
            Method dump skipped, instructions count: 952
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzha.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzeb):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzhp
    public final void zzc(Object obj) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long jZzd = zzd(this.zzl[i2]) & 1048575;
            Object objZzf = zzin.zzf(obj, jZzd);
            if (objZzf != null) {
                zzin.zza(obj, jZzd, this.zzs.zze(objZzf));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zzb(obj, this.zzl[i]);
            i++;
        }
        this.zzq.zzd(obj);
        if (this.zzh) {
            this.zzr.zzc(obj);
        }
    }

    private final Object zza(Object obj, int i, Object obj2, zzih zzihVar) {
        zzfs zzfsVarZzc;
        int i2 = this.zzc[i];
        Object objZzf = zzin.zzf(obj, zzd(i) & 1048575);
        return (objZzf == null || (zzfsVarZzc = zzc(i)) == null) ? obj2 : zza(i, i2, this.zzs.zza(objZzf), zzfsVarZzc, obj2, zzihVar);
    }

    private final Object zza(int i, int i2, Map map, zzfs zzfsVar, Object obj, zzih zzihVar) {
        this.zzs.zzb(zzb(i));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!zzfsVar.zza(((Integer) entry.getValue()).intValue())) {
                if (obj == null) {
                    obj = zzihVar.zza();
                }
                zzeo zzeoVarZzc = zzeg.zzc(zzgo.zza(null, entry.getKey(), entry.getValue()));
                try {
                    zzgo.zza(zzeoVarZzc.zzb(), null, entry.getKey(), entry.getValue());
                    zzihVar.zza(obj, i2, zzeoVarZzc.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a2  */
    @Override // com.google.android.gms.internal.measurement.zzhp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzd(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzha.zzd(java.lang.Object):boolean");
    }

    private static boolean zza(Object obj, int i, zzhp zzhpVar) {
        return zzhpVar.zzd(zzin.zzf(obj, i & 1048575));
    }

    private static void zza(int i, Object obj, zzja zzjaVar) {
        if (obj instanceof String) {
            zzjaVar.zza(i, (String) obj);
        } else {
            zzjaVar.zza(i, (zzeg) obj);
        }
    }

    private final void zza(Object obj, int i, zzhm zzhmVar) {
        if (zzf(i)) {
            zzin.zza(obj, i & 1048575, zzhmVar.zzm());
        } else if (this.zzi) {
            zzin.zza(obj, i & 1048575, zzhmVar.zzl());
        } else {
            zzin.zza(obj, i & 1048575, zzhmVar.zzn());
        }
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    private static double zzb(Object obj, long j) {
        return ((Double) zzin.zzf(obj, j)).doubleValue();
    }

    private static float zzc(Object obj, long j) {
        return ((Float) zzin.zzf(obj, j)).floatValue();
    }

    private static int zzd(Object obj, long j) {
        return ((Integer) zzin.zzf(obj, j)).intValue();
    }

    private static long zze(Object obj, long j) {
        return ((Long) zzin.zzf(obj, j)).longValue();
    }

    private static boolean zzf(Object obj, long j) {
        return ((Boolean) zzin.zzf(obj, j)).booleanValue();
    }

    private final boolean zzc(Object obj, Object obj2, int i) {
        return zza(obj, i) == zza(obj2, i);
    }

    private final boolean zza(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zza(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zza(Object obj, int i) {
        int iZze = zze(i);
        long j = iZze & 1048575;
        if (j != 1048575) {
            return ((1 << (iZze >>> 20)) & zzin.zza(obj, j)) != 0;
        }
        int iZzd = zzd(i);
        long j2 = iZzd & 1048575;
        switch ((iZzd & 267386880) >>> 20) {
            case 0:
                return zzin.zze(obj, j2) != AudioStats.AUDIO_AMPLITUDE_NONE;
            case 1:
                return zzin.zzd(obj, j2) != BitmapDescriptorFactory.HUE_RED;
            case 2:
                return zzin.zzb(obj, j2) != 0;
            case 3:
                return zzin.zzb(obj, j2) != 0;
            case 4:
                return zzin.zza(obj, j2) != 0;
            case 5:
                return zzin.zzb(obj, j2) != 0;
            case 6:
                return zzin.zza(obj, j2) != 0;
            case 7:
                return zzin.zzc(obj, j2);
            case 8:
                Object objZzf = zzin.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzeg) {
                    return !zzeg.zza.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzin.zzf(obj, j2) != null;
            case 10:
                return !zzeg.zza.equals(zzin.zzf(obj, j2));
            case 11:
                return zzin.zza(obj, j2) != 0;
            case 12:
                return zzin.zza(obj, j2) != 0;
            case 13:
                return zzin.zza(obj, j2) != 0;
            case 14:
                return zzin.zzb(obj, j2) != 0;
            case 15:
                return zzin.zza(obj, j2) != 0;
            case 16:
                return zzin.zzb(obj, j2) != 0;
            case 17:
                return zzin.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzb(Object obj, int i) {
        int iZze = zze(i);
        long j = 1048575 & iZze;
        if (j == 1048575) {
            return;
        }
        zzin.zza(obj, j, (1 << (iZze >>> 20)) | zzin.zza(obj, j));
    }

    private final boolean zza(Object obj, int i, int i2) {
        return zzin.zza(obj, (long) (zze(i2) & 1048575)) == i;
    }

    private final void zzb(Object obj, int i, int i2) {
        zzin.zza(obj, zze(i2) & 1048575, i);
    }

    private final int zzg(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, 0);
    }

    private final int zza(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, i2);
    }

    private final int zzb(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
