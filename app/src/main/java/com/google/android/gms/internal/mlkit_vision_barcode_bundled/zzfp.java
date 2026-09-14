package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import androidx.slidingpanelayout.widget.SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.asn1.eac.EACTags;
import org.bouncycastle.bcpg.PacketTags;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
final class zzfp implements zzge {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzgz.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfm zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzgs zzl;
    private final zzdt zzm;

    private zzfp(int[] iArr, Object[] objArr, int i, int i2, zzfm zzfmVar, boolean z, int[] iArr2, int i3, int i4, zzfs zzfsVar, zzez zzezVar, zzgs zzgsVar, zzdt zzdtVar, zzfh zzfhVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzdtVar != null && (zzfmVar instanceof zzed)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzgsVar;
        this.zzm = zzdtVar;
        this.zzg = zzfmVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzge zzgeVarZzv = zzv(i);
            if (!zzI(obj, i)) {
                if (zzL(object)) {
                    Object objZze = zzgeVarZzv.zze();
                    zzgeVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzgeVarZzv.zze();
                zzgeVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzgeVarZzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzM(obj2, i2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzge zzgeVarZzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (zzL(object)) {
                    Object objZze = zzgeVarZzv.zze();
                    zzgeVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzgeVarZzv.zze();
                zzgeVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzgeVarZzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int iZzp = zzp(i);
        long j = 1048575 & iZzp;
        if (j == 1048575) {
            return;
        }
        zzgz.zzq(obj, j, (1 << (iZzp >>> 20)) | zzgz.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzgz.zzq(obj, zzp(i2) & 1048575, i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int iZzp = zzp(i);
        long j = iZzp & 1048575;
        if (j != 1048575) {
            return ((1 << (iZzp >>> 20)) & zzgz.zzc(obj, j)) != 0;
        }
        int iZzs = zzs(i);
        long j2 = iZzs & 1048575;
        switch (zzr(iZzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzgz.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzgz.zzb(obj, j2)) != 0;
            case 2:
                return zzgz.zzd(obj, j2) != 0;
            case 3:
                return zzgz.zzd(obj, j2) != 0;
            case 4:
                return zzgz.zzc(obj, j2) != 0;
            case 5:
                return zzgz.zzd(obj, j2) != 0;
            case 6:
                return zzgz.zzc(obj, j2) != 0;
            case 7:
                return zzgz.zzw(obj, j2);
            case 8:
                Object objZzf = zzgz.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzdf) {
                    return !zzdf.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzgz.zzf(obj, j2) != null;
            case 10:
                return !zzdf.zzb.equals(zzgz.zzf(obj, j2));
            case 11:
                return zzgz.zzc(obj, j2) != 0;
            case 12:
                return zzgz.zzc(obj, j2) != 0;
            case 13:
                return zzgz.zzc(obj, j2) != 0;
            case 14:
                return zzgz.zzd(obj, j2) != 0;
            case 15:
                return zzgz.zzc(obj, j2) != 0;
            case 16:
                return zzgz.zzd(obj, j2) != 0;
            case 17:
                return zzgz.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzI(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzge zzgeVar) {
        return zzgeVar.zzk(zzgz.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzeh) {
            return ((zzeh) obj).zzY();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzgz.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzgz.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzhh zzhhVar) {
        if (obj instanceof String) {
            zzhhVar.zzG(i, (String) obj);
        } else {
            zzhhVar.zzd(i, (zzdf) obj);
        }
    }

    static zzgt zzd(Object obj) {
        zzeh zzehVar = (zzeh) obj;
        zzgt zzgtVar = zzehVar.zzc;
        if (zzgtVar != zzgt.zzc()) {
            return zzgtVar;
        }
        zzgt zzgtVarZzf = zzgt.zzf();
        zzehVar.zzc = zzgtVarZzf;
        return zzgtVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0266  */
    /* JADX WARN: Code duplicated, block: B:126:0x0269  */
    /* JADX WARN: Code duplicated, block: B:129:0x0280  */
    /* JADX WARN: Code duplicated, block: B:131:0x0284  */
    /* JADX WARN: Code duplicated, block: B:170:0x0349  */
    /* JADX WARN: Code duplicated, block: B:185:0x0396  */
    /* JADX WARN: Code duplicated, block: B:188:0x039f  */
    static zzfp zzl(Class cls, zzfj zzfjVar, zzfs zzfsVar, zzez zzezVar, zzgs zzgsVar, zzdt zzdtVar, zzfh zzfhVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        int i7;
        char cCharAt;
        int i8;
        char cCharAt2;
        int i9;
        char cCharAt3;
        int i10;
        char cCharAt4;
        int i11;
        char cCharAt5;
        int i12;
        char cCharAt6;
        int i13;
        char cCharAt7;
        int i14;
        char cCharAt8;
        int i15;
        int i16;
        int i17;
        int i18;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i19;
        int i20;
        int i21;
        Field fieldZzz;
        int i22;
        char cCharAt9;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        Object obj;
        Field fieldZzz2;
        int i28;
        Object obj2;
        Field fieldZzz3;
        int i29;
        char cCharAt10;
        int i30;
        char cCharAt11;
        int i31;
        char cCharAt12;
        int i32;
        char cCharAt13;
        if (!(zzfjVar instanceof zzfw)) {
            SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m377m(zzfjVar);
            throw null;
        }
        zzfw zzfwVar = (zzfw) zzfjVar;
        String strZzd = zzfwVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i33 = 1;
            while (true) {
                i = i33 + 1;
                if (strZzd.charAt(i33) < 55296) {
                    break;
                }
                i33 = i;
            }
        } else {
            i = 1;
        }
        int i34 = i + 1;
        int iCharAt3 = strZzd.charAt(i);
        if (iCharAt3 >= 55296) {
            int i35 = iCharAt3 & 8191;
            int i36 = 13;
            while (true) {
                i32 = i34 + 1;
                cCharAt13 = strZzd.charAt(i34);
                if (cCharAt13 < 55296) {
                    break;
                }
                i35 |= (cCharAt13 & 8191) << i36;
                i36 += 13;
                i34 = i32;
            }
            iCharAt3 = i35 | (cCharAt13 << i36);
            i34 = i32;
        }
        if (iCharAt3 == 0) {
            i4 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            i2 = 0;
            i5 = 0;
            i3 = 0;
            iArr = zza;
            i6 = 0;
        } else {
            int i37 = i34 + 1;
            int iCharAt4 = strZzd.charAt(i34);
            if (iCharAt4 >= 55296) {
                int i38 = iCharAt4 & 8191;
                int i39 = 13;
                while (true) {
                    i14 = i37 + 1;
                    cCharAt8 = strZzd.charAt(i37);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt8 & 8191) << i39;
                    i39 += 13;
                    i37 = i14;
                }
                iCharAt4 = i38 | (cCharAt8 << i39);
                i37 = i14;
            }
            int i40 = i37 + 1;
            int iCharAt5 = strZzd.charAt(i37);
            if (iCharAt5 >= 55296) {
                int i41 = iCharAt5 & 8191;
                int i42 = 13;
                while (true) {
                    i13 = i40 + 1;
                    cCharAt7 = strZzd.charAt(i40);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt7 & 8191) << i42;
                    i42 += 13;
                    i40 = i13;
                }
                iCharAt5 = i41 | (cCharAt7 << i42);
                i40 = i13;
            }
            int i43 = i40 + 1;
            int iCharAt6 = strZzd.charAt(i40);
            if (iCharAt6 >= 55296) {
                int i44 = iCharAt6 & 8191;
                int i45 = 13;
                while (true) {
                    i12 = i43 + 1;
                    cCharAt6 = strZzd.charAt(i43);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt6 & 8191) << i45;
                    i45 += 13;
                    i43 = i12;
                }
                iCharAt6 = i44 | (cCharAt6 << i45);
                i43 = i12;
            }
            int i46 = i43 + 1;
            int iCharAt7 = strZzd.charAt(i43);
            if (iCharAt7 >= 55296) {
                int i47 = iCharAt7 & 8191;
                int i48 = 13;
                while (true) {
                    i11 = i46 + 1;
                    cCharAt5 = strZzd.charAt(i46);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt5 & 8191) << i48;
                    i48 += 13;
                    i46 = i11;
                }
                iCharAt7 = i47 | (cCharAt5 << i48);
                i46 = i11;
            }
            int i49 = i46 + 1;
            iCharAt = strZzd.charAt(i46);
            if (iCharAt >= 55296) {
                int i50 = iCharAt & 8191;
                int i51 = 13;
                while (true) {
                    i10 = i49 + 1;
                    cCharAt4 = strZzd.charAt(i49);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt4 & 8191) << i51;
                    i51 += 13;
                    i49 = i10;
                }
                iCharAt = i50 | (cCharAt4 << i51);
                i49 = i10;
            }
            int i52 = i49 + 1;
            iCharAt2 = strZzd.charAt(i49);
            if (iCharAt2 >= 55296) {
                int i53 = iCharAt2 & 8191;
                int i54 = 13;
                while (true) {
                    i9 = i52 + 1;
                    cCharAt3 = strZzd.charAt(i52);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt3 & 8191) << i54;
                    i54 += 13;
                    i52 = i9;
                }
                iCharAt2 = i53 | (cCharAt3 << i54);
                i52 = i9;
            }
            int i55 = i52 + 1;
            int iCharAt8 = strZzd.charAt(i52);
            if (iCharAt8 >= 55296) {
                int i56 = iCharAt8 & 8191;
                int i57 = 13;
                while (true) {
                    i8 = i55 + 1;
                    cCharAt2 = strZzd.charAt(i55);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i56 |= (cCharAt2 & 8191) << i57;
                    i57 += 13;
                    i55 = i8;
                }
                iCharAt8 = i56 | (cCharAt2 << i57);
                i55 = i8;
            }
            int i58 = i55 + 1;
            int iCharAt9 = strZzd.charAt(i55);
            if (iCharAt9 >= 55296) {
                int i59 = iCharAt9 & 8191;
                int i60 = 13;
                while (true) {
                    i7 = i58 + 1;
                    cCharAt = strZzd.charAt(i58);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i59 |= (cCharAt & 8191) << i60;
                    i60 += 13;
                    i58 = i7;
                }
                iCharAt9 = i59 | (cCharAt << i60);
                i58 = i7;
            }
            int i61 = iCharAt4 + iCharAt4 + iCharAt5;
            int[] iArr2 = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i2 = iCharAt6;
            i3 = iCharAt9;
            i4 = i61;
            iArr = iArr2;
            i5 = iCharAt7;
            i6 = iCharAt4;
            i34 = i58;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzfwVar.zze();
        Class<?> cls2 = zzfwVar.zza().getClass();
        int i62 = i3 + iCharAt2;
        int i63 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[i63];
        int i64 = i3;
        int i65 = i62;
        int i66 = 0;
        int i67 = 0;
        while (i34 < length) {
            int i68 = i34 + 1;
            int iCharAt10 = strZzd.charAt(i34);
            if (iCharAt10 >= c) {
                int i69 = iCharAt10 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i31 = i70 + 1;
                    cCharAt12 = strZzd.charAt(i70);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i69 |= (cCharAt12 & 8191) << i71;
                    i71 += 13;
                    i70 = i31;
                }
                iCharAt10 = i69 | (cCharAt12 << i71);
                i15 = i31;
            } else {
                i15 = i68;
            }
            int i72 = i15 + 1;
            int iCharAt11 = strZzd.charAt(i15);
            if (iCharAt11 >= c) {
                int i73 = iCharAt11 & 8191;
                int i74 = i72;
                int i75 = 13;
                while (true) {
                    i30 = i74 + 1;
                    cCharAt11 = strZzd.charAt(i74);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i73 |= (cCharAt11 & 8191) << i75;
                    i75 += 13;
                    i74 = i30;
                }
                iCharAt11 = i73 | (cCharAt11 << i75);
                i16 = i30;
            } else {
                i16 = i72;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i67] = i66;
                i67++;
            }
            int i76 = iCharAt11 & 255;
            int i77 = length;
            int i78 = iCharAt11 & 2048;
            int i79 = i5;
            if (i76 >= 51) {
                int i80 = i16 + 1;
                int iCharAt12 = strZzd.charAt(i16);
                if (iCharAt12 >= 55296) {
                    int i81 = iCharAt12 & 8191;
                    int i82 = i80;
                    int i83 = 13;
                    while (true) {
                        i29 = i82 + 1;
                        cCharAt10 = strZzd.charAt(i82);
                        i17 = i2;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i81 |= (cCharAt10 & 8191) << i83;
                        i83 += 13;
                        i82 = i29;
                        i2 = i17;
                    }
                    iCharAt12 = i81 | (cCharAt10 << i83);
                    i25 = i29;
                } else {
                    i17 = i2;
                    i25 = i80;
                }
                int i84 = i76 - 51;
                int i85 = i25;
                if (i84 == 9 || i84 == 17) {
                    i26 = i4 + 1;
                    int i86 = i66 / 3;
                    objArr[i86 + i86 + 1] = objArrZze[i4];
                } else {
                    if (i84 == 12) {
                        if (zzfwVar.zzc() == 1 || i78 != 0) {
                            i26 = i4 + 1;
                            int i87 = i66 / 3;
                            objArr[i87 + i87 + 1] = objArrZze[i4];
                        } else {
                            i78 = 0;
                        }
                    }
                    i27 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i27];
                    if (obj instanceof Field) {
                        fieldZzz2 = (Field) obj;
                    } else {
                        fieldZzz2 = zzz(cls2, (String) obj);
                        objArrZze[i27] = fieldZzz2;
                    }
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzz2);
                    i28 = i27 + 1;
                    obj2 = objArrZze[i28];
                    int i88 = i78;
                    if (obj2 instanceof Field) {
                        fieldZzz3 = (Field) obj2;
                    } else {
                        fieldZzz3 = zzz(cls2, (String) obj2);
                        objArrZze[i28] = fieldZzz3;
                    }
                    i18 = i4;
                    i19 = i85;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz3);
                    i20 = 0;
                    strZzd = strZzd;
                    zzfwVar = zzfwVar;
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i21 = i88;
                }
                i4 = i26;
                i27 = iCharAt12 + iCharAt12;
                obj = objArrZze[i27];
                if (obj instanceof Field) {
                    fieldZzz2 = (Field) obj;
                } else {
                    fieldZzz2 = zzz(cls2, (String) obj);
                    objArrZze[i27] = fieldZzz2;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzz2);
                i28 = i27 + 1;
                obj2 = objArrZze[i28];
                int i89 = i78;
                if (obj2 instanceof Field) {
                    fieldZzz3 = (Field) obj2;
                } else {
                    fieldZzz3 = zzz(cls2, (String) obj2);
                    objArrZze[i28] = fieldZzz3;
                }
                i18 = i4;
                i19 = i85;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz3);
                i20 = 0;
                strZzd = strZzd;
                zzfwVar = zzfwVar;
                iObjectFieldOffset = iObjectFieldOffset4;
                i21 = i89;
            } else {
                i17 = i2;
                i18 = i4 + 1;
                Field fieldZzz4 = zzz(cls2, (String) objArrZze[i4]);
                if (i76 == 9 || i76 == 17) {
                    int i90 = i66 / 3;
                    objArr[i90 + i90 + 1] = fieldZzz4.getType();
                } else {
                    if (i76 != 27) {
                        if (i76 == 49) {
                            i24 = i4 + 2;
                            i23 = 1;
                        } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                            zzfwVar = zzfwVar;
                            if (zzfwVar.zzc() == 1 || i78 != 0) {
                                i24 = i4 + 2;
                                int i91 = i66 / 3;
                                objArr[i91 + i91 + 1] = objArrZze[i18];
                                i18 = i24;
                            } else {
                                i78 = 0;
                            }
                        } else if (i76 == 50) {
                            int i92 = i4 + 2;
                            int i93 = i64 + 1;
                            iArr[i64] = i66;
                            int i94 = i66 / 3;
                            int i95 = i94 + i94;
                            objArr[i95] = objArrZze[i18];
                            if (i78 != 0) {
                                i18 = i4 + 3;
                                objArr[i95 + 1] = objArrZze[i92];
                                i64 = i93;
                                zzfwVar = zzfwVar;
                            } else {
                                i18 = i92;
                                i64 = i93;
                                i78 = 0;
                            }
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                        iObjectFieldOffset2 = 1048575;
                        if ((iCharAt11 & 4096) != 0 || i76 > 17) {
                            i19 = i16;
                            i20 = 0;
                        } else {
                            int i96 = i16 + 1;
                            int iCharAt13 = strZzd.charAt(i16);
                            if (iCharAt13 >= 55296) {
                                int i97 = iCharAt13 & 8191;
                                int i98 = 13;
                                while (true) {
                                    i22 = i96 + 1;
                                    cCharAt9 = strZzd.charAt(i96);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i97 |= (cCharAt9 & 8191) << i98;
                                    i98 += 13;
                                    i96 = i22;
                                }
                                iCharAt13 = i97 | (cCharAt9 << i98);
                                i96 = i22;
                            }
                            int i99 = i6 + i6 + (iCharAt13 / 32);
                            Object obj3 = objArrZze[i99];
                            i19 = i96;
                            if (obj3 instanceof Field) {
                                fieldZzz = (Field) obj3;
                            } else {
                                fieldZzz = zzz(cls2, (String) obj3);
                                objArrZze[i99] = fieldZzz;
                            }
                            i20 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz);
                        }
                        if (i76 >= 18 && i76 <= 49) {
                            iArr[i65] = iObjectFieldOffset;
                            i65++;
                        }
                        i21 = i78;
                    } else {
                        i23 = 1;
                        i24 = i4 + 2;
                    }
                    int i100 = i66 / 3;
                    objArr[i100 + i100 + i23] = objArrZze[i18];
                    i18 = i24;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                    iObjectFieldOffset2 = 1048575;
                    if ((iCharAt11 & 4096) != 0) {
                        i19 = i16;
                        i20 = 0;
                    } else {
                        i19 = i16;
                        i20 = 0;
                    }
                    if (i76 >= 18) {
                        iArr[i65] = iObjectFieldOffset;
                        i65++;
                    }
                    i21 = i78;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                iObjectFieldOffset2 = 1048575;
                if ((iCharAt11 & 4096) != 0) {
                    i19 = i16;
                    i20 = 0;
                } else {
                    i19 = i16;
                    i20 = 0;
                }
                if (i76 >= 18) {
                    iArr[i65] = iObjectFieldOffset;
                    i65++;
                }
                i21 = i78;
            }
            int i101 = i66 + 1;
            iArr3[i66] = iCharAt10;
            int i102 = i66 + 2;
            Class<?> cls3 = cls2;
            iArr3[i101] = iObjectFieldOffset | (i21 != 0 ? Integer.MIN_VALUE : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i76 << 20);
            i66 += 3;
            iArr3[i102] = (i20 << 20) | iObjectFieldOffset2;
            strZzd = strZzd;
            i4 = i18;
            length = i77;
            i5 = i79;
            cls2 = cls3;
            zzfwVar = zzfwVar;
            i34 = i19;
            i2 = i17;
            c = 55296;
        }
        return new zzfp(iArr3, objArr, i2, i5, zzfwVar.zza(), false, iArr, i3, i62, zzfsVar, zzezVar, zzgsVar, zzdtVar, zzfhVar);
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzgz.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzgz.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzgz.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
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

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzgz.zzf(obj, j)).longValue();
    }

    private final zzel zzu(int i) {
        int i2 = i / 3;
        return (zzel) this.zzd[i2 + i2 + 1];
    }

    private final zzge zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzge zzgeVar = (zzge) objArr[i3];
        if (zzgeVar != null) {
            return zzgeVar;
        }
        zzge zzgeVarZzb = zzfu.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzgeVarZzb;
        return zzgeVarZzb;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzge zzgeVarZzv = zzv(i);
        int iZzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzgeVarZzv.zze();
        }
        Object object = zzb.getObject(obj, iZzs);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzgeVarZzv.zze();
        if (object != null) {
            zzgeVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzge zzgeVarZzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzgeVarZzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzgeVarZzv.zze();
        if (object != null) {
            zzgeVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    /* JADX WARN: Code duplicated, block: B:143:0x038d  */
    /* JADX WARN: Code duplicated, block: B:180:0x0481  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v115, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v118, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v120, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v137 */
    /* JADX WARN: Type inference failed for: r0v185, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v256, types: [int] */
    /* JADX WARN: Type inference failed for: r0v265 */
    /* JADX WARN: Type inference failed for: r0v266 */
    /* JADX WARN: Type inference failed for: r0v267 */
    /* JADX WARN: Type inference failed for: r0v268 */
    /* JADX WARN: Type inference failed for: r0v269 */
    /* JADX WARN: Type inference failed for: r0v270 */
    /* JADX WARN: Type inference failed for: r0v271 */
    /* JADX WARN: Type inference failed for: r0v272 */
    /* JADX WARN: Type inference failed for: r0v273 */
    /* JADX WARN: Type inference failed for: r0v274 */
    /* JADX WARN: Type inference failed for: r0v275 */
    /* JADX WARN: Type inference failed for: r0v276 */
    /* JADX WARN: Type inference failed for: r0v277 */
    /* JADX WARN: Type inference failed for: r0v278 */
    /* JADX WARN: Type inference failed for: r0v279 */
    /* JADX WARN: Type inference failed for: r0v280 */
    /* JADX WARN: Type inference failed for: r13v4, types: [int] */
    /* JADX WARN: Type inference failed for: r13v5, types: [int] */
    /* JADX WARN: Type inference failed for: r13v6, types: [int] */
    /* JADX WARN: Type inference failed for: r13v7, types: [int] */
    /* JADX WARN: Type inference failed for: r13v9, types: [int] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v118, types: [int] */
    /* JADX WARN: Type inference failed for: r1v121, types: [int] */
    /* JADX WARN: Type inference failed for: r1v160 */
    /* JADX WARN: Type inference failed for: r1v163 */
    /* JADX WARN: Type inference failed for: r1v164 */
    /* JADX WARN: Type inference failed for: r1v165 */
    /* JADX WARN: Type inference failed for: r1v166 */
    /* JADX WARN: Type inference failed for: r1v167 */
    /* JADX WARN: Type inference failed for: r1v168 */
    /* JADX WARN: Type inference failed for: r1v169 */
    /* JADX WARN: Type inference failed for: r1v170 */
    /* JADX WARN: Type inference failed for: r1v78, types: [int] */
    /* JADX WARN: Type inference failed for: r1v80 */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v37, types: [int] */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v42, types: [int] */
    /* JADX WARN: Type inference failed for: r2v46, types: [int] */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55, types: [int] */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27, types: [int] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30, types: [int] */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v39, types: [int] */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v46, types: [int] */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31, types: [int] */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v38, types: [int] */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v61 */
    /* JADX WARN: Type inference failed for: r4v62 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zza(Object obj) {
        int i;
        ?? r16;
        ?? r5;
        int iZzA;
        int iZzA2;
        int iZzA3;
        int iZzB;
        int iZzA4;
        int iZzA5;
        int iZzd;
        int iZzA6;
        ?? Zzg;
        int size;
        int iZzA7;
        int iZzz;
        int iZzz2;
        ?? r3;
        int iZzy;
        ?? ZzA;
        ?? Zzh;
        int iZze;
        int iZzA8;
        int iZzA9;
        ?? r4;
        ?? r6;
        ?? r1;
        Unsafe unsafe = zzb;
        boolean z = false;
        int i2 = 1048575;
        ?? r2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i3 < this.zzc.length) {
            int iZzs = zzs(i3);
            int iZzr = zzr(iZzs);
            int[] iArr = this.zzc;
            int i6 = iArr[i3];
            int i7 = iArr[i3 + 2];
            int i8 = i7 & i2;
            if (iZzr <= 17) {
                if (i8 != i5) {
                    i5 = i8;
                    r1 = i8 == i2 ? z : unsafe.getInt(obj, i8);
                }
                i = i5;
                r16 = r1;
                r5 = 1 << (i7 >>> 20);
            } else {
                r1 = r2;
                i = i5;
                r16 = r2;
                r5 = z;
            }
            int i9 = iZzs & i2;
            if (iZzr >= zzdy.zzJ.zza()) {
                zzdy.zzW.zza();
            }
            long j = i9;
            switch (iZzr) {
                case 0:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzA = zzdn.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 1:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzA2 = zzdn.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 2:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB(j2);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 3:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB(j3);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 4:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j4 = unsafe.getInt(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB(j4);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 5:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzA = zzdn.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 6:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzA2 = zzdn.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 7:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzA4 = zzdn.zzA(i6 << 3);
                        Zzh = iZzA4 + 1;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 8:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i10 = i6 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzdf) {
                            iZzA5 = zzdn.zzA(i10);
                            iZzd = ((zzdf) object).zzd();
                            iZzA6 = zzdn.zzA(iZzd);
                            Zzh = iZzA5 + iZzA6 + iZzd;
                            i4 += Zzh;
                        } else {
                            iZzA3 = zzdn.zzA(i10);
                            iZzB = zzdn.zzz((String) object);
                            Zzh = iZzA3 + iZzB;
                            i4 += Zzh;
                        }
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 9:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        Zzh = zzgg.zzh(i6, unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 10:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        zzdf zzdfVar = (zzdf) unsafe.getObject(obj, j);
                        iZzA5 = zzdn.zzA(i6 << 3);
                        iZzd = zzdfVar.zzd();
                        iZzA6 = zzdn.zzA(iZzd);
                        Zzh = iZzA5 + iZzA6 + iZzd;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 11:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i11 = unsafe.getInt(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzA(i11);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 12:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j5 = unsafe.getInt(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB(j5);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 13:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzA2 = zzdn.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 14:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzA = zzdn.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 15:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzA((i12 >> 31) ^ (i12 + i12));
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 16:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j6 = unsafe.getLong(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB((j6 >> 63) ^ (j6 + j6));
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 17:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        Zzh = zzdn.zzw(i6, (zzfm) unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 18:
                    Zzh = zzgg.zzd(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 19:
                    Zzh = zzgg.zzb(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i13 = zzgg.$r8$clinit;
                    if (list.size() == 0) {
                        Zzg = z;
                    } else {
                        Zzg = zzgg.zzg(list) + (list.size() * zzdn.zzA(i6 << 3));
                    }
                    i4 += Zzg;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i14 = zzgg.$r8$clinit;
                    size = list2.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzgg.zzl(list2);
                        iZzA7 = zzdn.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i15 = zzgg.$r8$clinit;
                    size = list3.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzgg.zzf(list3);
                        iZzA7 = zzdn.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 23:
                    Zzh = zzgg.zzd(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 24:
                    Zzh = zzgg.zzb(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i16 = zzgg.$r8$clinit;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        Zzh = z;
                    } else {
                        Zzh = size2 * (zzdn.zzA(i6 << 3) + 1);
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 26:
                    ?? r0 = (List) unsafe.getObject(obj, j);
                    int i17 = zzgg.$r8$clinit;
                    int size3 = r0.size();
                    if (size3 == 0) {
                        Zzg = z;
                    } else {
                        int iZzA10 = zzdn.zzA(i6 << 3) * size3;
                        if (r0 instanceof zzey) {
                            zzey zzeyVar = (zzey) r0;
                            for (?? r7 = z; r7 < size3; r7++) {
                                Object objZza = zzeyVar.zza();
                                if (objZza instanceof zzdf) {
                                    Zzg = iZzA10;
                                    int iZzd2 = ((zzdf) objZza).zzd();
                                    iZzz2 = Zzg + zzdn.zzA(iZzd2) + iZzd2;
                                } else {
                                    Zzg = iZzA10;
                                    iZzz2 = Zzg + zzdn.zzz((String) objZza);
                                }
                                Zzg = iZzz2;
                            }
                            Zzg = iZzA10;
                        } else {
                            for (?? r8 = z; r8 < size3; r8++) {
                                Object obj2 = r0.get(r8);
                                if (obj2 instanceof zzdf) {
                                    Zzg = iZzA10;
                                    int iZzd3 = ((zzdf) obj2).zzd();
                                    iZzz = Zzg + zzdn.zzA(iZzd3) + iZzd3;
                                } else {
                                    Zzg = iZzA10;
                                    iZzz = Zzg + zzdn.zzz((String) obj2);
                                }
                                Zzg = iZzz;
                            }
                            Zzg = iZzA10;
                        }
                    }
                    i4 += Zzg;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 27:
                    ?? r9 = (List) unsafe.getObject(obj, j);
                    zzge zzgeVarZzv = zzv(i3);
                    int i18 = zzgg.$r8$clinit;
                    int size4 = r9.size();
                    if (size4 == 0) {
                        r3 = z;
                    } else {
                        int iZzA11 = zzdn.zzA(i6 << 3) * size4;
                        for (?? r10 = z; r10 < size4; r10++) {
                            Object obj3 = r9.get(r10);
                            if (obj3 instanceof zzex) {
                                r3 = iZzA11;
                                int iZza = ((zzex) obj3).zza();
                                iZzy = (r3 == true ? 1 : 0) + zzdn.zzA(iZza) + iZza;
                            } else {
                                r3 = iZzA11;
                                iZzy = (r3 == true ? 1 : 0) + zzdn.zzy((zzfm) obj3, zzgeVarZzv);
                            }
                            r3 = iZzy;
                        }
                        r3 = iZzA11;
                    }
                    i4 += r3;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 28:
                    ?? r11 = (List) unsafe.getObject(obj, j);
                    int i19 = zzgg.$r8$clinit;
                    int size5 = r11.size();
                    if (size5 == 0) {
                        ZzA = z;
                    } else {
                        ZzA = size5 * zzdn.zzA(i6 << 3);
                        for (?? r12 = z; r12 < r11.size(); r12++) {
                            int iZzd4 = ((zzdf) r11.get(r12)).zzd();
                            ZzA += zzdn.zzA(iZzd4) + iZzd4;
                        }
                    }
                    i4 += ZzA;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 29:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i20 = zzgg.$r8$clinit;
                    size = list5.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzgg.zzk(list5);
                        iZzA7 = zzdn.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 30:
                    List list6 = (List) unsafe.getObject(obj, j);
                    int i21 = zzgg.$r8$clinit;
                    size = list6.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzgg.zza(list6);
                        iZzA7 = zzdn.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 31:
                    Zzh = zzgg.zzb(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 32:
                    Zzh = zzgg.zzd(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 33:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i22 = zzgg.$r8$clinit;
                    size = list7.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzgg.zzi(list7);
                        iZzA7 = zzdn.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 34:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i23 = zzgg.$r8$clinit;
                    size = list8.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzgg.zzj(list8);
                        iZzA7 = zzdn.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 35:
                    iZze = zzgg.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzdn.zzA(i6 << 3);
                        iZzA9 = zzdn.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 36:
                    iZze = zzgg.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzdn.zzA(i6 << 3);
                        iZzA9 = zzdn.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 37:
                    iZze = zzgg.zzg((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzdn.zzA(i6 << 3);
                        iZzA9 = zzdn.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 38:
                    iZze = zzgg.zzl((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzdn.zzA(i6 << 3);
                        iZzA9 = zzdn.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 39:
                    iZze = zzgg.zzf((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzdn.zzA(i6 << 3);
                        iZzA9 = zzdn.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 40:
                    iZze = zzgg.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzdn.zzA(i6 << 3);
                        iZzA9 = zzdn.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 41:
                    iZze = zzgg.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzdn.zzA(i6 << 3);
                        iZzA9 = zzdn.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 42:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i24 = zzgg.$r8$clinit;
                    iZze = list9.size();
                    if (iZze > 0) {
                        iZzA8 = zzdn.zzA(i6 << 3);
                        iZzA9 = zzdn.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 43:
                    iZze = zzgg.zzk((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzdn.zzA(i6 << 3);
                        iZzA9 = zzdn.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 44:
                    iZze = zzgg.zza((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzdn.zzA(i6 << 3);
                        iZzA9 = zzdn.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 45:
                    iZze = zzgg.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzdn.zzA(i6 << 3);
                        iZzA9 = zzdn.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 46:
                    iZze = zzgg.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzdn.zzA(i6 << 3);
                        iZzA9 = zzdn.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 47:
                    iZze = zzgg.zzi((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzdn.zzA(i6 << 3);
                        iZzA9 = zzdn.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 48:
                    iZze = zzgg.zzj((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzdn.zzA(i6 << 3);
                        iZzA9 = zzdn.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 49:
                    ?? r13 = (List) unsafe.getObject(obj, j);
                    zzge zzgeVarZzv2 = zzv(i3);
                    int i25 = zzgg.$r8$clinit;
                    int size6 = r13.size();
                    if (size6 == 0) {
                        r4 = z;
                    } else {
                        boolean z2 = z;
                        r4 = z2;
                        while (r6 < size6) {
                            r6 = z2;
                            int iZzw = zzdn.zzw(i6, (zzfm) r13.get(r6), zzgeVarZzv2);
                            r6++;
                            r4 = (r4 == true ? 1 : 0) + iZzw;
                        }
                        r6 = z2;
                    }
                    i4 += r4;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 50:
                    zzfg zzfgVar = (zzfg) unsafe.getObject(obj, j);
                    if (zzfgVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzfgVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                case 51:
                    if (zzM(obj, i6, i3)) {
                        iZzA = zzdn.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 52:
                    if (zzM(obj, i6, i3)) {
                        iZzA2 = zzdn.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case EACTags.SEX /* 53 */:
                    if (zzM(obj, i6, i3)) {
                        long jZzt = zzt(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB(jZzt);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case EACTags.CURRENCY_EXPONENT /* 54 */:
                    if (zzM(obj, i6, i3)) {
                        long jZzt2 = zzt(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB(jZzt2);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 55:
                    if (zzM(obj, i6, i3)) {
                        long jZzo = zzo(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB(jZzo);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 56:
                    if (zzM(obj, i6, i3)) {
                        iZzA = zzdn.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 57:
                    if (zzM(obj, i6, i3)) {
                        iZzA2 = zzdn.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 58:
                    if (zzM(obj, i6, i3)) {
                        iZzA4 = zzdn.zzA(i6 << 3);
                        Zzh = iZzA4 + 1;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (zzM(obj, i6, i3)) {
                        int i26 = i6 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzdf) {
                            iZzA5 = zzdn.zzA(i26);
                            iZzd = ((zzdf) object2).zzd();
                            iZzA6 = zzdn.zzA(iZzd);
                            Zzh = iZzA5 + iZzA6 + iZzd;
                            i4 += Zzh;
                        } else {
                            iZzA3 = zzdn.zzA(i26);
                            iZzB = zzdn.zzz((String) object2);
                            Zzh = iZzA3 + iZzB;
                            i4 += Zzh;
                        }
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 60:
                    if (zzM(obj, i6, i3)) {
                        Zzh = zzgg.zzh(i6, unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 61:
                    if (zzM(obj, i6, i3)) {
                        zzdf zzdfVar2 = (zzdf) unsafe.getObject(obj, j);
                        iZzA5 = zzdn.zzA(i6 << 3);
                        iZzd = zzdfVar2.zzd();
                        iZzA6 = zzdn.zzA(iZzd);
                        Zzh = iZzA5 + iZzA6 + iZzd;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case PacketTags.EXPERIMENTAL_3 /* 62 */:
                    if (zzM(obj, i6, i3)) {
                        int iZzo = zzo(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzA(iZzo);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 63:
                    if (zzM(obj, i6, i3)) {
                        long jZzo2 = zzo(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB(jZzo2);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 64:
                    if (zzM(obj, i6, i3)) {
                        iZzA2 = zzdn.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case EACTags.ELEMENT_LIST /* 65 */:
                    if (zzM(obj, i6, i3)) {
                        iZzA = zzdn.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case EACTags.ADDRESS /* 66 */:
                    if (zzM(obj, i6, i3)) {
                        int iZzo2 = zzo(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzA((iZzo2 >> 31) ^ (iZzo2 + iZzo2));
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 67:
                    if (zzM(obj, i6, i3)) {
                        long jZzt3 = zzt(obj, j);
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB((jZzt3 >> 63) ^ (jZzt3 + jZzt3));
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 68:
                    if (zzM(obj, i6, i3)) {
                        Zzh = zzdn.zzw(i6, (zzfm) unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                default:
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
            }
        }
        int iZza2 = i4 + ((zzeh) obj).zzc.zza();
        if (!this.zzh) {
            return iZza2;
        }
        zzdx zzdxVar = ((zzed) obj).zzb;
        int iZzc = zzdxVar.zza.zzc();
        int iZza3 = 0;
        for (int i27 = 0; i27 < iZzc; i27++) {
            Map.Entry entryZzg = zzdxVar.zza.zzg(i27);
            iZza3 += zzdx.zza((zzdw) ((zzgi) entryZzg).zza(), entryZzg.getValue());
        }
        for (Map.Entry entry2 : zzdxVar.zza.zzd()) {
            iZza3 += zzdx.zza((zzdw) entry2.getKey(), entry2.getValue());
        }
        return iZza2 + iZza3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int iZzs = zzs(i4);
            int[] iArr = this.zzc;
            int i5 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            int i6 = iArr[i4];
            long j = i5;
            int iHashCode = 37;
            switch (iZzr) {
                case 0:
                    i = i3 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzgz.zza(obj, j));
                    byte[] bArr = zzep.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i3 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzgz.zzb(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i3 * 53;
                    jDoubleToLongBits = zzgz.zzd(obj, j);
                    byte[] bArr2 = zzep.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i3 * 53;
                    jDoubleToLongBits = zzgz.zzd(obj, j);
                    byte[] bArr3 = zzep.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i3 * 53;
                    iFloatToIntBits = zzgz.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i3 * 53;
                    jDoubleToLongBits = zzgz.zzd(obj, j);
                    byte[] bArr4 = zzep.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i3 * 53;
                    iFloatToIntBits = zzgz.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i3 * 53;
                    iFloatToIntBits = zzep.zza(zzgz.zzw(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i3 * 53;
                    iFloatToIntBits = ((String) zzgz.zzf(obj, j)).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i3 * 53;
                    Object objZzf = zzgz.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i3 = i2 + iHashCode;
                    break;
                case 10:
                    i = i3 * 53;
                    iFloatToIntBits = zzgz.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i3 * 53;
                    iFloatToIntBits = zzgz.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i3 * 53;
                    iFloatToIntBits = zzgz.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i3 * 53;
                    iFloatToIntBits = zzgz.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i3 * 53;
                    jDoubleToLongBits = zzgz.zzd(obj, j);
                    byte[] bArr5 = zzep.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i3 * 53;
                    iFloatToIntBits = zzgz.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i3 * 53;
                    jDoubleToLongBits = zzgz.zzd(obj, j);
                    byte[] bArr6 = zzep.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i3 * 53;
                    Object objZzf2 = zzgz.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i3 = i2 + iHashCode;
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
                    i = i3 * 53;
                    iFloatToIntBits = zzgz.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i3 * 53;
                    iFloatToIntBits = zzgz.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzep.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case EACTags.SEX /* 53 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr8 = zzep.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case EACTags.CURRENCY_EXPONENT /* 54 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr9 = zzep.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr10 = zzep.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzep.zza(zzN(obj, j));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = ((String) zzgz.zzf(obj, j)).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzgz.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzgz.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case PacketTags.EXPERIMENTAL_3 /* 62 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case EACTags.ELEMENT_LIST /* 65 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr11 = zzep.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case EACTags.ADDRESS /* 66 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr12 = zzep.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzgz.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
            }
        }
        int iHashCode2 = (i3 * 53) + ((zzeh) obj).zzc.hashCode();
        return this.zzh ? (iHashCode2 * 53) + ((zzed) obj).zzb.zza.hashCode() : iHashCode2;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0306  */
    /* JADX WARN: Code duplicated, block: B:105:0x030e  */
    /* JADX WARN: Code duplicated, block: B:107:0x0312  */
    /* JADX WARN: Code duplicated, block: B:110:0x032e  */
    /* JADX WARN: Code duplicated, block: B:112:0x0333  */
    /* JADX WARN: Code duplicated, block: B:121:0x038c  */
    /* JADX WARN: Code duplicated, block: B:129:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:130:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:162:0x0539  */
    /* JADX WARN: Code duplicated, block: B:165:0x0542  */
    /* JADX WARN: Code duplicated, block: B:173:0x05ad  */
    /* JADX WARN: Code duplicated, block: B:176:0x05b8  */
    /* JADX WARN: Code duplicated, block: B:178:0x05c4  */
    /* JADX WARN: Code duplicated, block: B:181:0x05cc  */
    /* JADX WARN: Code duplicated, block: B:183:0x05cf  */
    /* JADX WARN: Code duplicated, block: B:185:0x05f0  */
    /* JADX WARN: Code duplicated, block: B:187:0x05f8 A[LOOP:2: B:184:0x05ee->B:187:0x05f8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:189:0x0615  */
    /* JADX WARN: Code duplicated, block: B:190:0x0620  */
    /* JADX WARN: Code duplicated, block: B:192:0x0625  */
    /* JADX WARN: Code duplicated, block: B:194:0x0633 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:200:0x0646 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:204:0x0661  */
    /* JADX WARN: Code duplicated, block: B:206:0x0666  */
    /* JADX WARN: Code duplicated, block: B:208:0x0673 A[LOOP:3: B:207:0x0671->B:208:0x0673, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:213:0x068a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:214:0x068c  */
    /* JADX WARN: Code duplicated, block: B:216:0x069f  */
    /* JADX WARN: Code duplicated, block: B:218:0x06a7 A[LOOP:4: B:215:0x069d->B:218:0x06a7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:219:0x06b5  */
    /* JADX WARN: Code duplicated, block: B:221:0x06ba  */
    /* JADX WARN: Code duplicated, block: B:222:0x06bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:223:0x06c1  */
    /* JADX WARN: Code duplicated, block: B:226:0x06d8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:227:0x06da  */
    /* JADX WARN: Code duplicated, block: B:229:0x06e5  */
    /* JADX WARN: Code duplicated, block: B:231:0x06f9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:232:0x06fb  */
    /* JADX WARN: Code duplicated, block: B:234:0x0709  */
    /* JADX WARN: Code duplicated, block: B:238:0x072b  */
    /* JADX WARN: Code duplicated, block: B:239:0x0733  */
    /* JADX WARN: Code duplicated, block: B:242:0x0749  */
    /* JADX WARN: Code duplicated, block: B:245:0x0761  */
    /* JADX WARN: Code duplicated, block: B:247:0x0779  */
    /* JADX WARN: Code duplicated, block: B:249:0x0789  */
    /* JADX WARN: Code duplicated, block: B:251:0x0793  */
    /* JADX WARN: Code duplicated, block: B:253:0x079b  */
    /* JADX WARN: Code duplicated, block: B:255:0x079f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:256:0x07a1  */
    /* JADX WARN: Code duplicated, block: B:257:0x07a7  */
    /* JADX WARN: Code duplicated, block: B:259:0x07b1  */
    /* JADX WARN: Code duplicated, block: B:25:0x006b  */
    /* JADX WARN: Code duplicated, block: B:261:0x07bb  */
    /* JADX WARN: Code duplicated, block: B:263:0x07c3  */
    /* JADX WARN: Code duplicated, block: B:265:0x07c7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:266:0x07c9  */
    /* JADX WARN: Code duplicated, block: B:268:0x07d1  */
    /* JADX WARN: Code duplicated, block: B:279:0x0804  */
    /* JADX WARN: Code duplicated, block: B:280:0x0810  */
    /* JADX WARN: Code duplicated, block: B:282:0x0818  */
    /* JADX WARN: Code duplicated, block: B:284:0x083f  */
    /* JADX WARN: Code duplicated, block: B:285:0x084a  */
    /* JADX WARN: Code duplicated, block: B:287:0x0859  */
    /* JADX WARN: Code duplicated, block: B:289:0x0862  */
    /* JADX WARN: Code duplicated, block: B:291:0x086c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:292:0x086e  */
    /* JADX WARN: Code duplicated, block: B:293:0x0874  */
    /* JADX WARN: Code duplicated, block: B:296:0x0883  */
    /* JADX WARN: Code duplicated, block: B:298:0x088b  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:300:0x0893 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:308:0x08b7  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:310:0x08c3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:311:0x08c5  */
    /* JADX WARN: Code duplicated, block: B:312:0x08c9  */
    /* JADX WARN: Code duplicated, block: B:314:0x08d1  */
    /* JADX WARN: Code duplicated, block: B:316:0x08de  */
    /* JADX WARN: Code duplicated, block: B:318:0x08e6  */
    /* JADX WARN: Code duplicated, block: B:320:0x08ee A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:324:0x08fc  */
    /* JADX WARN: Code duplicated, block: B:32:0x00af  */
    /* JADX WARN: Code duplicated, block: B:333:0x0924  */
    /* JADX WARN: Code duplicated, block: B:334:0x092e  */
    /* JADX WARN: Code duplicated, block: B:336:0x093c  */
    /* JADX WARN: Code duplicated, block: B:338:0x094a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:345:0x095f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:349:0x0973  */
    /* JADX WARN: Code duplicated, block: B:351:0x0981  */
    /* JADX WARN: Code duplicated, block: B:353:0x098e A[LOOP:10: B:352:0x098c->B:353:0x098e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:358:0x09a1  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:360:0x09a4  */
    /* JADX WARN: Code duplicated, block: B:362:0x09b3  */
    /* JADX WARN: Code duplicated, block: B:364:0x09bb A[LOOP:11: B:361:0x09b1->B:364:0x09bb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:366:0x09cb  */
    /* JADX WARN: Code duplicated, block: B:368:0x09d9  */
    /* JADX WARN: Code duplicated, block: B:370:0x09e7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:376:0x09f4  */
    /* JADX WARN: Code duplicated, block: B:378:0x09f7  */
    /* JADX WARN: Code duplicated, block: B:381:0x0a08  */
    /* JADX WARN: Code duplicated, block: B:383:0x0a16  */
    /* JADX WARN: Code duplicated, block: B:384:0x0a1b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:385:0x0a1d  */
    /* JADX WARN: Code duplicated, block: B:386:0x0a31  */
    /* JADX WARN: Code duplicated, block: B:388:0x0a3c  */
    /* JADX WARN: Code duplicated, block: B:390:0x0a4a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:396:0x0a59 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:400:0x0a68  */
    /* JADX WARN: Code duplicated, block: B:402:0x0a73  */
    /* JADX WARN: Code duplicated, block: B:404:0x0a80 A[LOOP:12: B:403:0x0a7e->B:404:0x0a80, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:409:0x0a97  */
    /* JADX WARN: Code duplicated, block: B:411:0x0a9a  */
    /* JADX WARN: Code duplicated, block: B:413:0x0aad  */
    /* JADX WARN: Code duplicated, block: B:415:0x0ab5 A[LOOP:13: B:412:0x0aab->B:415:0x0ab5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:417:0x0ac6  */
    /* JADX WARN: Code duplicated, block: B:419:0x0ad1  */
    /* JADX WARN: Code duplicated, block: B:421:0x0adf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:427:0x0af1  */
    /* JADX WARN: Code duplicated, block: B:441:0x0b50  */
    /* JADX WARN: Code duplicated, block: B:444:0x0b61  */
    /* JADX WARN: Code duplicated, block: B:446:0x0b6f  */
    /* JADX WARN: Code duplicated, block: B:448:0x0b85  */
    /* JADX WARN: Code duplicated, block: B:450:0x0b91  */
    /* JADX WARN: Code duplicated, block: B:452:0x0b94  */
    /* JADX WARN: Code duplicated, block: B:453:0x0bbf  */
    /* JADX WARN: Code duplicated, block: B:454:0x0bc6  */
    /* JADX WARN: Code duplicated, block: B:456:0x0bd2  */
    /* JADX WARN: Code duplicated, block: B:458:0x0bf4  */
    /* JADX WARN: Code duplicated, block: B:460:0x0bfc  */
    /* JADX WARN: Code duplicated, block: B:462:0x0c06  */
    /* JADX WARN: Code duplicated, block: B:465:0x0c22  */
    /* JADX WARN: Code duplicated, block: B:467:0x0c2c  */
    /* JADX WARN: Code duplicated, block: B:473:0x0c4f  */
    /* JADX WARN: Code duplicated, block: B:475:0x0c5c  */
    /* JADX WARN: Code duplicated, block: B:477:0x0c61  */
    /* JADX WARN: Code duplicated, block: B:479:0x0c68  */
    /* JADX WARN: Code duplicated, block: B:480:0x0c78  */
    /* JADX WARN: Code duplicated, block: B:482:0x0c80  */
    /* JADX WARN: Code duplicated, block: B:483:0x0ca8  */
    /* JADX WARN: Code duplicated, block: B:484:0x0cb2  */
    /* JADX WARN: Code duplicated, block: B:486:0x0cbf  */
    /* JADX WARN: Code duplicated, block: B:488:0x0cc7  */
    /* JADX WARN: Code duplicated, block: B:489:0x0ccf  */
    /* JADX WARN: Code duplicated, block: B:498:0x0cfa  */
    /* JADX WARN: Code duplicated, block: B:499:0x0cfe  */
    /* JADX WARN: Code duplicated, block: B:501:0x0d0b  */
    /* JADX WARN: Code duplicated, block: B:503:0x0d16  */
    /* JADX WARN: Code duplicated, block: B:504:0x0d18  */
    /* JADX WARN: Code duplicated, block: B:507:0x0d27  */
    /* JADX WARN: Code duplicated, block: B:509:0x0d35  */
    /* JADX WARN: Code duplicated, block: B:511:0x0d48  */
    /* JADX WARN: Code duplicated, block: B:513:0x0d56  */
    /* JADX WARN: Code duplicated, block: B:514:0x0d68  */
    /* JADX WARN: Code duplicated, block: B:516:0x0d76  */
    /* JADX WARN: Code duplicated, block: B:517:0x0d88  */
    /* JADX WARN: Code duplicated, block: B:519:0x0d96  */
    /* JADX WARN: Code duplicated, block: B:520:0x0da9  */
    /* JADX WARN: Code duplicated, block: B:522:0x0db7  */
    /* JADX WARN: Code duplicated, block: B:523:0x0dcd  */
    /* JADX WARN: Code duplicated, block: B:525:0x0ddb  */
    /* JADX WARN: Code duplicated, block: B:526:0x0df1 A[PHI: r6 r8 r10 r11 r21 r49
  0x0df1: PHI (r6v111 java.lang.Object) = 
  (r6v93 java.lang.Object)
  (r6v94 java.lang.Object)
  (r6v95 java.lang.Object)
  (r6v96 java.lang.Object)
  (r6v97 java.lang.Object)
  (r6v99 java.lang.Object)
  (r6v101 java.lang.Object)
  (r6v102 java.lang.Object)
  (r6v103 java.lang.Object)
  (r6v106 java.lang.Object)
  (r6v112 java.lang.Object)
 binds: [B:524:0x0dd9, B:521:0x0db5, B:518:0x0d94, B:515:0x0d74, B:512:0x0d54, B:508:0x0d33, B:500:0x0d09, B:498:0x0cfa, B:483:0x0ca8, B:459:0x0bf9, B:449:0x0b8b] A[DONT_GENERATE, DONT_INLINE]
  0x0df1: PHI (r8v137 int) = 
  (r8v111 int)
  (r8v112 int)
  (r8v113 int)
  (r8v114 int)
  (r8v115 int)
  (r8v117 int)
  (r8v119 int)
  (r8v120 int)
  (r8v121 int)
  (r8v128 int)
  (r10v75 int)
 binds: [B:524:0x0dd9, B:521:0x0db5, B:518:0x0d94, B:515:0x0d74, B:512:0x0d54, B:508:0x0d33, B:500:0x0d09, B:498:0x0cfa, B:483:0x0ca8, B:459:0x0bf9, B:449:0x0b8b] A[DONT_GENERATE, DONT_INLINE]
  0x0df1: PHI (r10v103 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu) = 
  (r10v76 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r10v77 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r10v78 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r10v79 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r10v80 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r10v82 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r10v84 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r10v85 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r10v86 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r10v96 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
  (r10v104 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu)
 binds: [B:524:0x0dd9, B:521:0x0db5, B:518:0x0d94, B:515:0x0d74, B:512:0x0d54, B:508:0x0d33, B:500:0x0d09, B:498:0x0cfa, B:483:0x0ca8, B:459:0x0bf9, B:449:0x0b8b] A[DONT_GENERATE, DONT_INLINE]
  0x0df1: PHI (r11v106 int) = 
  (r11v81 int)
  (r11v82 int)
  (r11v83 int)
  (r11v84 int)
  (r11v85 int)
  (r11v87 int)
  (r11v89 int)
  (r11v90 int)
  (r11v91 int)
  (r6v76 int)
  (r6v76 int)
 binds: [B:524:0x0dd9, B:521:0x0db5, B:518:0x0d94, B:515:0x0d74, B:512:0x0d54, B:508:0x0d33, B:500:0x0d09, B:498:0x0cfa, B:483:0x0ca8, B:459:0x0bf9, B:449:0x0b8b] A[DONT_GENERATE, DONT_INLINE]
  0x0df1: PHI (r21v32 int) = 
  (r21v13 int)
  (r21v14 int)
  (r21v15 int)
  (r21v16 int)
  (r21v17 int)
  (r21v19 int)
  (r21v21 int)
  (r21v22 int)
  (r21v23 int)
  (r21v26 int)
  (r21v33 int)
 binds: [B:524:0x0dd9, B:521:0x0db5, B:518:0x0d94, B:515:0x0d74, B:512:0x0d54, B:508:0x0d33, B:500:0x0d09, B:498:0x0cfa, B:483:0x0ca8, B:459:0x0bf9, B:449:0x0b8b] A[DONT_GENERATE, DONT_INLINE]
  0x0df1: PHI (r49v36 int) = 
  (r49v13 int)
  (r49v14 int)
  (r49v15 int)
  (r49v16 int)
  (r49v17 int)
  (r49v19 int)
  (r49v21 int)
  (r49v22 int)
  (r49v26 int)
  (r5v76 int)
  (r5v76 int)
 binds: [B:524:0x0dd9, B:521:0x0db5, B:518:0x0d94, B:515:0x0d74, B:512:0x0d54, B:508:0x0d33, B:500:0x0d09, B:498:0x0cfa, B:483:0x0ca8, B:459:0x0bf9, B:449:0x0b8b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:535:0x0e2e  */
    /* JADX WARN: Code duplicated, block: B:537:0x0e38  */
    /* JADX WARN: Code duplicated, block: B:539:0x0e44  */
    /* JADX WARN: Code duplicated, block: B:540:0x0e60  */
    /* JADX WARN: Code duplicated, block: B:541:0x0e85  */
    /* JADX WARN: Code duplicated, block: B:573:0x0df4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:575:0x00c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:576:0x011c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:577:0x016f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:578:0x01ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:579:0x0203 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:580:0x0238 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:581:0x027a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:582:0x03c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:583:0x03fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:584:0x0413 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:585:0x0452 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:586:0x0482 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:587:0x04bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:588:0x04f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:589:0x052d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:590:0x063d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:591:0x0637 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:592:0x0653 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:593:0x0684 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:594:0x07fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:595:0x07f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:596:0x07e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:597:0x07da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:598:0x08b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:599:0x08a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:600:0x091e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:601:0x0916 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:602:0x0910 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:603:0x0908 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:604:0x095b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:605:0x0955 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:606:0x0968 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:607:0x099b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:608:0x09f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:609:0x09ea A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:610:0x09ff A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:611:0x0a55 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:612:0x0a4f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:613:0x0a5d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:614:0x0a91 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:0x0ae9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:616:0x0ae3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:0x0b1a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:618:0x0af7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:619:0x0b3b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:621:0x0056 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:622:0x0515 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:623:0x010f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:624:0x0160 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:625:0x019e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:626:0x01f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:627:0x0229 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:628:0x026b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:629:0x03b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:630:0x03ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:631:0x0406 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:632:0x0442 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:633:0x0472 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:634:0x04aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:635:0x04e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:636:0x00ff A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:637:0x043b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:638:0x046f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:639:0x00c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:640:0x0151 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:641:0x046f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:642:0x0197 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:643:0x021f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:644:0x03e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:645:0x01f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:646:0x021f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:647:0x03e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:648:0x03b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:649:0x0384 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:650:0x0368 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:651:0x02fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:652:0x0328 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:653:0x0351 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:654:0x0502 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:655:0x0502 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:0x008e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:657:0x0589 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:0x0579 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:659:0x052a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:660:0x0b27 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:661:0x0b0e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:662:0x0e10 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:663:0x0598 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:664:0x0b38 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:680:0x060a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:683:0x060a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:688:0x0759 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:690:0x0743 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:692:0x07e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:693:0x07ea A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:698:0x08aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:699:0x0899 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:700:0x0895 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:705:0x08f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:707:0x08aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:708:0x08f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:715:0x09c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:718:0x0ac3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:720:0x02b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:722:0x02e4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:723:0x02c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:729:0x02e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x027e  */
    /* JADX WARN: Code duplicated, block: B:77:0x0286  */
    /* JADX WARN: Code duplicated, block: B:79:0x028a  */
    /* JADX WARN: Code duplicated, block: B:80:0x0296  */
    /* JADX WARN: Code duplicated, block: B:82:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:84:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:86:0x02b0 A[LOOP:14: B:83:0x02a6->B:86:0x02b0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:88:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:92:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:94:0x02d8 A[LOOP:16: B:91:0x02ce->B:94:0x02d8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:98:0x02ec A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:99:0x02ee  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v47 */
    /* JADX WARN: Type inference failed for: r12v48, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v49, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v43 */
    /* JADX WARN: Type inference failed for: r17v21 */
    /* JADX WARN: Type inference failed for: r17v56 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r6v118 */
    /* JADX WARN: Type inference failed for: r9v15 */
    final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzcu zzcuVar) {
        zzfp zzfpVar;
        Unsafe unsafe;
        Object obj2;
        int i4;
        int i5;
        int i6;
        int iZzq;
        int i7;
        int i8;
        zzcu zzcuVar2;
        Object obj3;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        zzfp zzfpVar2;
        zzds zzdsVar;
        zzgs zzgsVar;
        zzef zzefVarZzb;
        ?? r9;
        int[] iArr;
        int i15;
        int iZzr;
        long j;
        String str;
        int i16;
        int i17;
        int i18;
        int i19;
        Unsafe unsafe2;
        int i20;
        int i21;
        int i22;
        zzcu zzcuVar3;
        ?? r14;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int iZzh;
        int i28;
        boolean z;
        int i29;
        int i30;
        int length;
        int i31;
        char[] cArr;
        int i32;
        int i33;
        int i34;
        byte b;
        byte b2;
        ?? r17;
        String str2;
        byte b3;
        int i35;
        int i36;
        int i37;
        ?? r2;
        int i38;
        int i39;
        int i40;
        int i41;
        int i42;
        int i43;
        Unsafe unsafe3;
        int i44;
        int i45;
        zzcu zzcuVar4;
        Object obj4;
        int i46;
        int i47;
        zzeo zzeoVarZzd;
        int i48;
        int i49;
        long j2;
        Unsafe unsafe4;
        zzeo zzeoVar;
        zzeo zzeoVar2;
        int i50;
        zzcu zzcuVar5;
        int i51;
        int iZzj;
        int i52;
        int i53;
        zzdz zzdzVar;
        int iZzl;
        int iZzj2;
        zzdz zzdzVar2;
        int i54;
        int i55;
        int i56;
        int i57;
        int i58;
        zzcu zzcuVar6;
        int iZzj3;
        int i59;
        zzei zzeiVar;
        int iZzj4;
        zzei zzeiVar2;
        int i60;
        int i61;
        int i62;
        zzcu zzcuVar7;
        int iZzj5;
        int i63;
        int i64;
        int iZzj6;
        int i65;
        int i66;
        int i67;
        ?? r12;
        int iZzj7;
        int i68;
        int i69;
        int i70;
        int i71;
        int iZzj8;
        int i72;
        int i73;
        int iZzj9;
        int i74;
        int i75;
        int i76;
        int iZzl2;
        zzel zzelVarZzu;
        zzgs zzgsVar2;
        int i77;
        int i78;
        int i79;
        boolean z2;
        Iterator it;
        Object objZzn;
        int iIntValue;
        int size;
        Object objZzn2;
        int i80;
        int i81;
        Integer num;
        int iIntValue2;
        int i82;
        int i83;
        int i84;
        zzei zzeiVar3;
        int iZzj10;
        zzei zzeiVar4;
        int iZzj11;
        int i85;
        int i86;
        int i87;
        zzge zzgeVarZzv;
        int iZzj12;
        Unsafe unsafe5;
        Object object;
        Unsafe unsafe6;
        long j3;
        int i88;
        int iZzm;
        int iZzj13;
        boolean z3;
        int iZzj14;
        int i89;
        int i90;
        int i91;
        Object obj5;
        int iZza;
        int i92;
        zzel zzelVarZzu2;
        zzfp zzfpVar3 = this;
        Object obj6 = obj;
        byte[] bArr2 = bArr;
        i2 = i2;
        zzcu zzcuVar8 = zzcuVar;
        int i93 = 3;
        zzA(obj);
        Unsafe unsafe7 = zzb;
        int i94 = 0;
        int i95 = -1;
        int i96 = 1048575;
        int iZzi = i;
        int i97 = 1048575;
        int i98 = -1;
        int i99 = 0;
        int i100 = 0;
        int i101 = 0;
        while (true) {
            if (iZzi < i2) {
                int iZzk = iZzi + 1;
                int i102 = bArr2[iZzi];
                if (i102 < 0) {
                    iZzk = zzcv.zzk(i102, bArr2, iZzk, zzcuVar8);
                    i102 = zzcuVar8.zza;
                }
                i101 = i102;
                int i103 = (i101 == true ? 1 : 0) >>> 3;
                if (i103 > i98) {
                    iZzq = (i103 < zzfpVar3.zze || i103 > zzfpVar3.zzf) ? i95 : zzfpVar3.zzq(i103, i99 / i93);
                } else {
                    if (i103 < zzfpVar3.zze || i103 > zzfpVar3.zzf) {
                        i99 = i95;
                    } else {
                        iZzq = zzfpVar3.zzq(i103, i94);
                    }
                    if (i99 == i95) {
                        r9 = (i101 == true ? 1 : 0) & 7;
                        iArr = zzfpVar3.zzc;
                        i15 = iArr[i99 + 1];
                        iZzr = zzr(i15);
                        j = i15 & i96;
                        str = "Protocol message had invalid UTF-8.";
                        if (iZzr <= 17) {
                            int i104 = iArr[i99 + 2];
                            i16 = 1 << (i104 >>> 20);
                            i17 = 1048575;
                            i18 = i104 & 1048575;
                            if (i18 != i97) {
                                if (i97 != 1048575) {
                                    unsafe7.putInt(obj6, i97, i100);
                                    i17 = 1048575;
                                }
                                if (i18 == i17) {
                                    i19 = 0;
                                } else {
                                    i19 = unsafe7.getInt(obj6, i18);
                                }
                                i97 = i18;
                            } else {
                                i19 = i100;
                                i97 = i97;
                            }
                            switch (iZzr) {
                                case 0:
                                    unsafe2 = unsafe7;
                                    i21 = i103;
                                    i22 = i101 == true ? 1 : 0;
                                    r14 = true;
                                    i20 = 3;
                                    i11 = -1;
                                    i13 = 0;
                                    zzcuVar3 = zzcuVar;
                                    if (r9 == 1) {
                                        i23 = iZzk + 8;
                                        i24 = i19 | i16;
                                        zzgz.zzo(obj6, j, Double.longBitsToDouble(zzcv.zzq(bArr2, iZzk)));
                                        i2 = i2;
                                        i101 = i22;
                                        zzcuVar8 = zzcuVar3;
                                        i95 = i11;
                                        i98 = i21;
                                        i96 = 1048575;
                                        iZzi = i23;
                                        unsafe7 = unsafe2;
                                        i97 = i97;
                                        i100 = i24;
                                        i93 = i20;
                                        i94 = i13;
                                    } else {
                                        i7 = i20;
                                        i8 = iZzk;
                                        i12 = i99;
                                        unsafe = unsafe2;
                                        i10 = i97;
                                        i100 = i19;
                                        i14 = i22;
                                        obj3 = obj6;
                                        zzcuVar2 = zzcuVar3;
                                        i9 = i21;
                                    }
                                    break;
                                case 1:
                                    unsafe2 = unsafe7;
                                    i21 = i103;
                                    i22 = i101 == true ? 1 : 0;
                                    r14 = true;
                                    i20 = 3;
                                    i11 = -1;
                                    i13 = 0;
                                    zzcuVar3 = zzcuVar;
                                    if (r9 == 5) {
                                        i23 = iZzk + 4;
                                        i24 = i19 | i16;
                                        zzgz.zzp(obj6, j, Float.intBitsToFloat(zzcv.zzc(bArr2, iZzk)));
                                        i2 = i2;
                                        i101 = i22;
                                        zzcuVar8 = zzcuVar3;
                                        i95 = i11;
                                        i98 = i21;
                                        i96 = 1048575;
                                        iZzi = i23;
                                        unsafe7 = unsafe2;
                                        i97 = i97;
                                        i100 = i24;
                                        i93 = i20;
                                        i94 = i13;
                                    } else {
                                        i7 = i20;
                                        i8 = iZzk;
                                        i12 = i99;
                                        unsafe = unsafe2;
                                        i10 = i97;
                                        i100 = i19;
                                        i14 = i22;
                                        obj3 = obj6;
                                        zzcuVar2 = zzcuVar3;
                                        i9 = i21;
                                    }
                                    break;
                                case 2:
                                case 3:
                                    unsafe2 = unsafe7;
                                    i21 = i103;
                                    i22 = i101 == true ? 1 : 0;
                                    i93 = 3;
                                    i11 = -1;
                                    i13 = 0;
                                    zzcuVar3 = zzcuVar;
                                    if (r9 == 0) {
                                        int iZzm2 = zzcv.zzm(bArr2, iZzk, zzcuVar3);
                                        unsafe7 = unsafe2;
                                        unsafe7.putLong(obj, j, zzcuVar3.zzb);
                                        zzcuVar8 = zzcuVar3;
                                        i93 = 3;
                                        iZzi = iZzm2;
                                        i95 = -1;
                                        i94 = 0;
                                        i100 = i19 | i16;
                                        i101 = i22 == true ? 1 : 0;
                                        i98 = i21;
                                        i96 = 1048575;
                                    } else {
                                        i20 = i93;
                                        i7 = i20;
                                        i8 = iZzk;
                                        i12 = i99;
                                        unsafe = unsafe2;
                                        i10 = i97;
                                        i100 = i19;
                                        i14 = i22;
                                        obj3 = obj6;
                                        zzcuVar2 = zzcuVar3;
                                        i9 = i21;
                                    }
                                    break;
                                case 4:
                                case 11:
                                    unsafe2 = unsafe7;
                                    i21 = i103;
                                    i22 = i101 == true ? 1 : 0;
                                    i93 = 3;
                                    i11 = -1;
                                    i13 = 0;
                                    zzcuVar3 = zzcuVar;
                                    if (r9 == 0) {
                                        i25 = i19 | i16;
                                        int iZzj15 = zzcv.zzj(bArr2, iZzk, zzcuVar3);
                                        unsafe2.putInt(obj6, j, zzcuVar3.zza);
                                        i101 = i22 == true ? 1 : 0;
                                        zzcuVar8 = zzcuVar3;
                                        i95 = -1;
                                        i98 = i21;
                                        i96 = 1048575;
                                        iZzi = iZzj15;
                                        i94 = 0;
                                        int i105 = i97;
                                        i100 = i25;
                                        unsafe7 = unsafe2;
                                        i97 = i105;
                                    } else {
                                        i20 = i93;
                                        i7 = i20;
                                        i8 = iZzk;
                                        i12 = i99;
                                        unsafe = unsafe2;
                                        i10 = i97;
                                        i100 = i19;
                                        i14 = i22;
                                        obj3 = obj6;
                                        zzcuVar2 = zzcuVar3;
                                        i9 = i21;
                                    }
                                    break;
                                case 5:
                                case 14:
                                    unsafe2 = unsafe7;
                                    i21 = i103;
                                    i11 = -1;
                                    zzcuVar3 = zzcuVar;
                                    if (r9 == 1) {
                                        unsafe7 = unsafe2;
                                        unsafe7.putLong(obj, j, zzcv.zzq(bArr2, iZzk));
                                        zzcuVar8 = zzcuVar3;
                                        iZzi = iZzk + 8;
                                        i93 = 3;
                                        i100 = i19 | i16;
                                        i95 = -1;
                                        i94 = 0;
                                        i98 = i21;
                                        i96 = 1048575;
                                    } else {
                                        i13 = 0;
                                        i20 = 3;
                                        i22 = i101 == true ? 1 : 0;
                                        i7 = i20;
                                        i8 = iZzk;
                                        i12 = i99;
                                        unsafe = unsafe2;
                                        i10 = i97;
                                        i100 = i19;
                                        i14 = i22;
                                        obj3 = obj6;
                                        zzcuVar2 = zzcuVar3;
                                        i9 = i21;
                                    }
                                    break;
                                case 6:
                                case 13:
                                    unsafe2 = unsafe7;
                                    i21 = i103;
                                    i26 = 0;
                                    i27 = 3;
                                    i11 = -1;
                                    zzcuVar3 = zzcuVar;
                                    if (r9 == 5) {
                                        iZzh = iZzk + 4;
                                        i28 = i19 | i16;
                                        unsafe2.putInt(obj6, j, zzcv.zzc(bArr2, iZzk));
                                        i2 = i2;
                                        i94 = i26;
                                        i93 = i27;
                                        zzcuVar8 = zzcuVar3;
                                        i95 = i11;
                                        i98 = i21;
                                        i96 = 1048575;
                                        iZzi = iZzh;
                                        unsafe7 = unsafe2;
                                        i97 = i97;
                                        i100 = i28;
                                    } else {
                                        i13 = i26;
                                        i20 = i27;
                                        i22 = i101 == true ? 1 : 0;
                                        i7 = i20;
                                        i8 = iZzk;
                                        i12 = i99;
                                        unsafe = unsafe2;
                                        i10 = i97;
                                        i100 = i19;
                                        i14 = i22;
                                        obj3 = obj6;
                                        zzcuVar2 = zzcuVar3;
                                        i9 = i21;
                                    }
                                    break;
                                case 7:
                                    unsafe2 = unsafe7;
                                    i21 = i103;
                                    i26 = 0;
                                    i27 = 3;
                                    i11 = -1;
                                    zzcuVar3 = zzcuVar;
                                    if (r9 == 0) {
                                        i25 = i19 | i16;
                                        int iZzm3 = zzcv.zzm(bArr2, iZzk, zzcuVar3);
                                        if (zzcuVar3.zzb != 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        zzgz.zzm(obj6, j, z);
                                        i94 = 0;
                                        i93 = 3;
                                        zzcuVar8 = zzcuVar3;
                                        i95 = -1;
                                        i98 = i21;
                                        i96 = 1048575;
                                        iZzi = iZzm3;
                                        int i106 = i97;
                                        i100 = i25;
                                        unsafe7 = unsafe2;
                                        i97 = i106;
                                    } else {
                                        i13 = i26;
                                        i20 = i27;
                                        i22 = i101 == true ? 1 : 0;
                                        i7 = i20;
                                        i8 = iZzk;
                                        i12 = i99;
                                        unsafe = unsafe2;
                                        i10 = i97;
                                        i100 = i19;
                                        i14 = i22;
                                        obj3 = obj6;
                                        zzcuVar2 = zzcuVar3;
                                        i9 = i21;
                                    }
                                    break;
                                case 8:
                                    unsafe2 = unsafe7;
                                    i21 = i103;
                                    i22 = i101 == true ? 1 : 0;
                                    i11 = -1;
                                    zzcuVar3 = zzcuVar;
                                    if (r9 == 2) {
                                        if ((i15 & 536870912) != 0) {
                                            iZzh = zzcv.zzj(bArr2, iZzk, zzcuVar3);
                                            i29 = zzcuVar3.zza;
                                            if (i29 >= 0) {
                                                throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            i30 = i19 | i16;
                                            if (i29 == 0) {
                                                zzcuVar3.zzc = "";
                                                i33 = i30;
                                                i101 = i22 == true ? 1 : 0;
                                                i26 = 0;
                                                i27 = 3;
                                            } else {
                                                length = bArr2.length;
                                                int i107 = zzhe.$r8$clinit;
                                                if ((iZzh | i29 | ((length - iZzh) - i29)) >= 0) {
                                                    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZzh), Integer.valueOf(i29)));
                                                }
                                                i31 = iZzh + i29;
                                                cArr = new char[i29];
                                                i32 = 0;
                                                while (iZzh < i31) {
                                                    b3 = bArr2[iZzh];
                                                    if (zzha.zzd(b3)) {
                                                        iZzh++;
                                                        cArr[i32] = (char) b3;
                                                        i32++;
                                                    } else {
                                                        while (iZzh < i31) {
                                                            i34 = iZzh + 1;
                                                            b = bArr2[iZzh];
                                                            if (zzha.zzd(b)) {
                                                                cArr[i32] = (char) b;
                                                                i32++;
                                                                iZzh = i34;
                                                                while (iZzh < i31) {
                                                                    b2 = bArr2[iZzh];
                                                                    if (zzha.zzd(b2)) {
                                                                        iZzh++;
                                                                        cArr[i32] = (char) b2;
                                                                        i32++;
                                                                    }
                                                                }
                                                            } else {
                                                                int i108 = i30;
                                                                if (b < -32) {
                                                                    r17 = i22 == true ? 1 : 0;
                                                                    str2 = str;
                                                                    if (b < -16) {
                                                                        if (i34 < i31 - 1) {
                                                                            throw new zzer(str2);
                                                                        }
                                                                        int i109 = iZzh + 2;
                                                                        iZzh += 3;
                                                                        zzha.zzb(b, bArr2[i34], bArr2[i109], cArr, i32);
                                                                        str = str2;
                                                                        i22 = r17 == true ? 1 : 0;
                                                                        i32++;
                                                                    } else {
                                                                        if (i34 < i31 - 2) {
                                                                            throw new zzer(str2);
                                                                        }
                                                                        byte b4 = bArr2[i34];
                                                                        int i110 = iZzh + 3;
                                                                        byte b5 = bArr2[iZzh + 2];
                                                                        iZzh += 4;
                                                                        zzha.zza(b, b4, b5, bArr2[i110], cArr, i32);
                                                                        i32 += 2;
                                                                        str = str2;
                                                                        i22 = r17 == true ? 1 : 0;
                                                                    }
                                                                } else {
                                                                    if (i34 < i31) {
                                                                        throw new zzer(str);
                                                                    }
                                                                    iZzh += 2;
                                                                    zzha.zzc(b, bArr2[i34], cArr, i32);
                                                                    i32++;
                                                                }
                                                                i30 = i108;
                                                            }
                                                        }
                                                        i33 = i30;
                                                        i101 = i22 == true ? 1 : 0;
                                                        i27 = 3;
                                                        i26 = 0;
                                                        zzcuVar3.zzc = new String(cArr, 0, i32);
                                                        iZzh = i31;
                                                    }
                                                }
                                                while (iZzh < i31) {
                                                    i34 = iZzh + 1;
                                                    b = bArr2[iZzh];
                                                    if (zzha.zzd(b)) {
                                                        cArr[i32] = (char) b;
                                                        i32++;
                                                        iZzh = i34;
                                                        while (iZzh < i31) {
                                                            b2 = bArr2[iZzh];
                                                            if (zzha.zzd(b2)) {
                                                                iZzh++;
                                                                cArr[i32] = (char) b2;
                                                                i32++;
                                                            }
                                                        }
                                                    } else {
                                                        int i1010 = i30;
                                                        if (b < -32) {
                                                            r17 = i22 == true ? 1 : 0;
                                                            str2 = str;
                                                            if (b < -16) {
                                                                if (i34 < i31 - 1) {
                                                                    throw new zzer(str2);
                                                                }
                                                                int i1011 = iZzh + 2;
                                                                iZzh += 3;
                                                                zzha.zzb(b, bArr2[i34], bArr2[i1011], cArr, i32);
                                                                str = str2;
                                                                i22 = r17 == true ? 1 : 0;
                                                                i32++;
                                                            } else {
                                                                if (i34 < i31 - 2) {
                                                                    throw new zzer(str2);
                                                                }
                                                                byte b6 = bArr2[i34];
                                                                int i111 = iZzh + 3;
                                                                byte b7 = bArr2[iZzh + 2];
                                                                iZzh += 4;
                                                                zzha.zza(b, b6, b7, bArr2[i111], cArr, i32);
                                                                i32 += 2;
                                                                str = str2;
                                                                i22 = r17 == true ? 1 : 0;
                                                            }
                                                        } else {
                                                            if (i34 < i31) {
                                                                throw new zzer(str);
                                                            }
                                                            iZzh += 2;
                                                            zzha.zzc(b, bArr2[i34], cArr, i32);
                                                            i32++;
                                                        }
                                                        i30 = i1010;
                                                    }
                                                }
                                                i33 = i30;
                                                i101 = i22 == true ? 1 : 0;
                                                i27 = 3;
                                                i26 = 0;
                                                zzcuVar3.zzc = new String(cArr, 0, i32);
                                                iZzh = i31;
                                            }
                                            i28 = i33;
                                        } else {
                                            i101 = i22 == true ? 1 : 0;
                                            i26 = 0;
                                            i27 = 3;
                                            i28 = i19 | i16;
                                            iZzh = zzcv.zzh(bArr2, iZzk, zzcuVar3);
                                        }
                                        unsafe2.putObject(obj6, j, zzcuVar3.zzc);
                                        i2 = i2;
                                        i94 = i26;
                                        i93 = i27;
                                        zzcuVar8 = zzcuVar3;
                                        i95 = i11;
                                        i98 = i21;
                                        i96 = 1048575;
                                        iZzi = iZzh;
                                        unsafe7 = unsafe2;
                                        i97 = i97;
                                        i100 = i28;
                                    } else {
                                        i20 = 3;
                                        i13 = 0;
                                        i7 = i20;
                                        i8 = iZzk;
                                        i12 = i99;
                                        unsafe = unsafe2;
                                        i10 = i97;
                                        i100 = i19;
                                        i14 = i22;
                                        obj3 = obj6;
                                        zzcuVar2 = zzcuVar3;
                                        i9 = i21;
                                    }
                                    break;
                                case 9:
                                    unsafe2 = unsafe7;
                                    i35 = i103;
                                    i36 = i99;
                                    i37 = i101 == true ? 1 : 0;
                                    r2 = true;
                                    i11 = -1;
                                    zzcuVar3 = zzcuVar;
                                    if (r9 == 2) {
                                        int i112 = i19 | i16;
                                        Object objZzx = zzfpVar3.zzx(obj6, i36);
                                        i99 = i36;
                                        i2 = i2;
                                        int iZzo = zzcv.zzo(objZzx, zzfpVar3.zzv(i36), bArr, iZzk, i2, zzcuVar);
                                        zzfpVar3.zzF(obj6, i99, objZzx);
                                        zzcuVar8 = zzcuVar3;
                                        i101 = i37 == true ? 1 : 0;
                                        i95 = -1;
                                        i93 = 3;
                                        i96 = 1048575;
                                        i94 = 0;
                                        iZzi = iZzo;
                                        unsafe7 = unsafe2;
                                        i97 = i97;
                                        i100 = i112;
                                        i98 = i35;
                                    } else {
                                        i99 = i36;
                                        i21 = i35;
                                        i22 = i37;
                                        i13 = 0;
                                        i20 = 3;
                                        i7 = i20;
                                        i8 = iZzk;
                                        i12 = i99;
                                        unsafe = unsafe2;
                                        i10 = i97;
                                        i100 = i19;
                                        i14 = i22;
                                        obj3 = obj6;
                                        zzcuVar2 = zzcuVar3;
                                        i9 = i21;
                                    }
                                    break;
                                case 10:
                                    unsafe2 = unsafe7;
                                    i35 = i103;
                                    i36 = i99;
                                    i37 = i101 == true ? 1 : 0;
                                    r2 = true;
                                    i11 = -1;
                                    zzcuVar3 = zzcuVar;
                                    if (r9 == 2) {
                                        i25 = i19 | i16;
                                        int iZza2 = zzcv.zza(bArr2, iZzk, zzcuVar3);
                                        unsafe2.putObject(obj6, j, zzcuVar3.zzc);
                                        i99 = i36;
                                        i98 = i35;
                                        zzcuVar8 = zzcuVar3;
                                        i101 = i37 == true ? 1 : 0;
                                        i95 = -1;
                                        i93 = 3;
                                        i96 = 1048575;
                                        i94 = 0;
                                        iZzi = iZza2;
                                        int i1012 = i97;
                                        i100 = i25;
                                        unsafe7 = unsafe2;
                                        i97 = i1012;
                                    } else {
                                        i99 = i36;
                                        i21 = i35;
                                        i22 = i37;
                                        i13 = 0;
                                        i20 = 3;
                                        i7 = i20;
                                        i8 = iZzk;
                                        i12 = i99;
                                        unsafe = unsafe2;
                                        i10 = i97;
                                        i100 = i19;
                                        i14 = i22;
                                        obj3 = obj6;
                                        zzcuVar2 = zzcuVar3;
                                        i9 = i21;
                                    }
                                    break;
                                case 12:
                                    unsafe2 = unsafe7;
                                    i38 = i103;
                                    i39 = i99;
                                    i40 = i101 == true ? 1 : 0;
                                    i11 = -1;
                                    zzcuVar3 = zzcuVar;
                                    if (r9 == 0) {
                                        int iZzj16 = zzcv.zzj(bArr2, iZzk, zzcuVar3);
                                        i41 = zzcuVar3.zza;
                                        zzel zzelVarZzu3 = zzfpVar3.zzu(i39);
                                        if ((i15 & Integer.MIN_VALUE) != 0 || zzelVarZzu3 == null || zzelVarZzu3.zza(i41)) {
                                            i42 = i40 == true ? 1 : 0;
                                            i19 |= i16;
                                            unsafe2.putInt(obj6, j, i41);
                                        } else {
                                            zzgt zzgtVarZzd = zzd(obj);
                                            Long lValueOf = Long.valueOf(i41);
                                            i42 = i40 == true ? 1 : 0;
                                            zzgtVarZzd.zzj(i42 == true ? 1 : 0, lValueOf);
                                        }
                                        i99 = i39;
                                        i98 = i38;
                                        zzcuVar8 = zzcuVar3;
                                        i101 = i42;
                                        i95 = -1;
                                        i93 = 3;
                                        i96 = 1048575;
                                        i94 = 0;
                                        iZzi = iZzj16;
                                        unsafe7 = unsafe2;
                                        i97 = i97;
                                        i100 = i19;
                                        i2 = i2;
                                    } else {
                                        i99 = i39;
                                        i21 = i38;
                                        i22 = i40;
                                        i20 = 3;
                                        i13 = 0;
                                        i7 = i20;
                                        i8 = iZzk;
                                        i12 = i99;
                                        unsafe = unsafe2;
                                        i10 = i97;
                                        i100 = i19;
                                        i14 = i22;
                                        obj3 = obj6;
                                        zzcuVar2 = zzcuVar3;
                                        i9 = i21;
                                    }
                                    break;
                                case 15:
                                    unsafe2 = unsafe7;
                                    i38 = i103;
                                    i39 = i99;
                                    i40 = i101 == true ? 1 : 0;
                                    i11 = -1;
                                    zzcuVar3 = zzcuVar;
                                    if (r9 == 0) {
                                        i25 = i19 | i16;
                                        int iZzj17 = zzcv.zzj(bArr2, iZzk, zzcuVar3);
                                        unsafe2.putInt(obj6, j, zzdj.zzb(zzcuVar3.zza));
                                        i99 = i39;
                                        i98 = i38;
                                        zzcuVar8 = zzcuVar3;
                                        i95 = -1;
                                        i101 = i40 == true ? 1 : 0;
                                        i93 = 3;
                                        i96 = 1048575;
                                        iZzi = iZzj17;
                                        i94 = 0;
                                        int i1013 = i97;
                                        i100 = i25;
                                        unsafe7 = unsafe2;
                                        i97 = i1013;
                                    } else {
                                        i99 = i39;
                                        i21 = i38;
                                        i22 = i40;
                                        i20 = 3;
                                        i13 = 0;
                                        i7 = i20;
                                        i8 = iZzk;
                                        i12 = i99;
                                        unsafe = unsafe2;
                                        i10 = i97;
                                        i100 = i19;
                                        i14 = i22;
                                        obj3 = obj6;
                                        zzcuVar2 = zzcuVar3;
                                        i9 = i21;
                                    }
                                    break;
                                case 16:
                                    i43 = i99;
                                    i11 = -1;
                                    if (r9 == 0) {
                                        int i113 = i19 | i16;
                                        int iZzm4 = zzcv.zzm(bArr2, iZzk, zzcuVar);
                                        unsafe7.putLong(obj, j, zzdj.zzc(zzcuVar.zzb));
                                        i2 = i2;
                                        zzcuVar8 = zzcuVar;
                                        i99 = i43;
                                        i97 = i97;
                                        i95 = -1;
                                        i101 = i101 == true ? 1 : 0;
                                        i93 = 3;
                                        i94 = 0;
                                        i100 = i113;
                                        iZzi = iZzm4;
                                        i98 = i103;
                                        i96 = 1048575;
                                    } else {
                                        unsafe2 = unsafe7;
                                        i21 = i103;
                                        zzcuVar3 = zzcuVar;
                                        i20 = 3;
                                        i99 = i43;
                                        i22 = i101 == true ? 1 : 0;
                                        i13 = 0;
                                        i7 = i20;
                                        i8 = iZzk;
                                        i12 = i99;
                                        unsafe = unsafe2;
                                        i10 = i97;
                                        i100 = i19;
                                        i14 = i22;
                                        obj3 = obj6;
                                        zzcuVar2 = zzcuVar3;
                                        i9 = i21;
                                    }
                                    break;
                                default:
                                    i93 = 3;
                                    if (r9 == 3) {
                                        int i114 = i19 | i16;
                                        Object objZzx2 = zzfpVar3.zzx(obj6, i99);
                                        int i115 = i99;
                                        iZzi = zzcv.zzn(objZzx2, zzfpVar3.zzv(i99), bArr, iZzk, i2, (i103 << 3) | 4, zzcuVar);
                                        zzfpVar3.zzF(obj6, i115, objZzx2);
                                        i98 = i103;
                                        i2 = i2;
                                        i96 = 1048575;
                                        i99 = i115;
                                        i97 = i97;
                                        i95 = -1;
                                        i94 = 0;
                                        zzcuVar8 = zzcuVar;
                                        i100 = i114;
                                    } else {
                                        i11 = -1;
                                        unsafe2 = unsafe7;
                                        i20 = 3;
                                        i21 = i103;
                                        i22 = i101 == true ? 1 : 0;
                                        i13 = 0;
                                        zzcuVar3 = zzcuVar;
                                        i7 = i20;
                                        i8 = iZzk;
                                        i12 = i99;
                                        unsafe = unsafe2;
                                        i10 = i97;
                                        i100 = i19;
                                        i14 = i22;
                                        obj3 = obj6;
                                        zzcuVar2 = zzcuVar3;
                                        i9 = i21;
                                    }
                                    break;
                            }
                        } else {
                            unsafe3 = unsafe7;
                            i44 = i103;
                            i45 = i97;
                            i14 = i101 == true ? 1 : 0;
                            i11 = -1;
                            i13 = 0;
                            if (iZzr == 27) {
                                i48 = i2;
                                i49 = i99;
                                i10 = i45;
                                if (iZzr <= 49) {
                                    j2 = i15;
                                    unsafe4 = zzb;
                                    zzeoVar = (zzeo) unsafe4.getObject(obj6, j);
                                    if (zzeoVar.zzc()) {
                                        zzeoVar2 = zzeoVar;
                                    } else {
                                        int size2 = zzeoVar.size();
                                        zzeo zzeoVarZzd2 = zzeoVar.zzd(size2 != 0 ? size2 + size2 : 10);
                                        unsafe4.putObject(obj6, j, zzeoVarZzd2);
                                        zzeoVar2 = zzeoVarZzd2;
                                    }
                                    switch (iZzr) {
                                        case 18:
                                        case 35:
                                            i14 = i14 == true ? 1 : 0;
                                            i50 = i49;
                                            zzcuVar5 = zzcuVar;
                                            unsafe = unsafe3;
                                            i9 = i44;
                                            i51 = iZzk;
                                            if (r9 == 2) {
                                                int i116 = zzcv.$r8$clinit;
                                                SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m377m(zzeoVar2);
                                                iZzj = zzcv.zzj(bArr2, i51, zzcuVar5);
                                                i52 = zzcuVar5.zza + iZzj;
                                                if (iZzj >= i52) {
                                                    Double.longBitsToDouble(zzcv.zzq(bArr2, iZzj));
                                                    throw null;
                                                }
                                                if (iZzj != i52) {
                                                    throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                iZzl = iZzj;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            } else {
                                                if (r9 == 1) {
                                                    int i117 = zzcv.$r8$clinit;
                                                    SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m377m(zzeoVar2);
                                                    Double.longBitsToDouble(zzcv.zzq(bArr2, i51));
                                                    throw null;
                                                }
                                                iZzl = i51;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            }
                                            break;
                                        case 19:
                                        case 36:
                                            i14 = i14 == true ? 1 : 0;
                                            i50 = i49;
                                            zzcuVar5 = zzcuVar;
                                            unsafe = unsafe3;
                                            i9 = i44;
                                            i51 = iZzk;
                                            if (r9 == 2) {
                                                if (r9 == 5) {
                                                    i53 = i51 + 4;
                                                    int i118 = zzcv.$r8$clinit;
                                                    zzdzVar = (zzdz) zzeoVar2;
                                                    zzdzVar.zzh(Float.intBitsToFloat(zzcv.zzc(bArr2, i51)));
                                                    while (i53 < i48) {
                                                        iZzj2 = zzcv.zzj(bArr2, i53, zzcuVar5);
                                                        if (i14 == zzcuVar5.zza) {
                                                            zzdzVar.zzh(Float.intBitsToFloat(zzcv.zzc(bArr2, iZzj2)));
                                                            i53 = iZzj2 + 4;
                                                        } else {
                                                            iZzl = i53;
                                                        }
                                                    }
                                                    iZzl = i53;
                                                }
                                                iZzl = i51;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            } else {
                                                int i119 = zzcv.$r8$clinit;
                                                zzdzVar2 = (zzdz) zzeoVar2;
                                                iZzj = zzcv.zzj(bArr2, i51, zzcuVar5);
                                                i54 = zzcuVar5.zza + iZzj;
                                                while (iZzj < i54) {
                                                    zzdzVar2.zzh(Float.intBitsToFloat(zzcv.zzc(bArr2, iZzj)));
                                                    iZzj += 4;
                                                }
                                                if (iZzj != i54) {
                                                    throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                iZzl = iZzj;
                                            }
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case 37:
                                        case 38:
                                            i14 = i14 == true ? 1 : 0;
                                            i50 = i49;
                                            zzcuVar5 = zzcuVar;
                                            unsafe = unsafe3;
                                            i9 = i44;
                                            i51 = iZzk;
                                            if (r9 == 2) {
                                                int i120 = zzcv.$r8$clinit;
                                                SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m377m(zzeoVar2);
                                                iZzj = zzcv.zzj(bArr2, i51, zzcuVar5);
                                                i55 = zzcuVar5.zza + iZzj;
                                                if (iZzj >= i55) {
                                                    zzcv.zzm(bArr2, iZzj, zzcuVar5);
                                                    throw null;
                                                }
                                                if (iZzj != i55) {
                                                    throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                iZzl = iZzj;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            } else {
                                                if (r9 == 0) {
                                                    int i121 = zzcv.$r8$clinit;
                                                    SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m377m(zzeoVar2);
                                                    zzcv.zzm(bArr2, i51, zzcuVar5);
                                                    long j4 = zzcuVar5.zzb;
                                                    throw null;
                                                }
                                                iZzl = i51;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case 39:
                                        case 43:
                                            i56 = i49;
                                            i57 = i48;
                                            unsafe = unsafe3;
                                            i58 = i44;
                                            i51 = iZzk;
                                            zzcuVar6 = zzcuVar;
                                            if (r9 == 2) {
                                                if (r9 == 0) {
                                                    i9 = i58;
                                                    i48 = i57;
                                                    zzcuVar5 = zzcuVar6;
                                                    i50 = i56;
                                                    i14 = i14 == true ? 1 : 0;
                                                    iZzl = zzcv.zzl(i14 == true ? 1 : 0, bArr, i51, i2, zzeoVar2, zzcuVar);
                                                }
                                                i9 = i58;
                                                i48 = i57;
                                                zzcuVar5 = zzcuVar6;
                                                i50 = i56;
                                                i14 = i14 == true ? 1 : 0;
                                                iZzl = i51;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            } else {
                                                iZzl = zzcv.zzg(bArr2, i51, zzeoVar2, zzcuVar6);
                                                i9 = i58;
                                                i48 = i57;
                                                zzcuVar5 = zzcuVar6;
                                                i50 = i56;
                                                i14 = i14 == true ? 1 : 0;
                                            }
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case 40:
                                        case 46:
                                            i56 = i49;
                                            i57 = i48;
                                            unsafe = unsafe3;
                                            i58 = i44;
                                            i51 = iZzk;
                                            zzcuVar6 = zzcuVar;
                                            if (r9 == 2) {
                                                if (r9 != 1) {
                                                    int i122 = zzcv.$r8$clinit;
                                                    SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m377m(zzeoVar2);
                                                    zzcv.zzq(bArr2, i51);
                                                    throw null;
                                                }
                                                i9 = i58;
                                                i48 = i57;
                                                zzcuVar5 = zzcuVar6;
                                                i50 = i56;
                                                i14 = i14 == true ? 1 : 0;
                                                iZzl = i51;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            } else {
                                                int i123 = zzcv.$r8$clinit;
                                                SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m377m(zzeoVar2);
                                                iZzj3 = zzcv.zzj(bArr2, i51, zzcuVar6);
                                                i59 = zzcuVar6.zza + iZzj3;
                                                if (iZzj3 >= i59) {
                                                    zzcv.zzq(bArr2, iZzj3);
                                                    throw null;
                                                }
                                                if (iZzj3 != i59) {
                                                    throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                i48 = i57;
                                                zzcuVar5 = zzcuVar6;
                                                i50 = i56;
                                                i14 = i14 == true ? 1 : 0;
                                                iZzl = iZzj3;
                                                i9 = i58;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            }
                                            break;
                                        case 24:
                                        case 31:
                                        case 41:
                                        case 45:
                                            i56 = i49;
                                            i57 = i48;
                                            unsafe = unsafe3;
                                            i58 = i44;
                                            i51 = iZzk;
                                            zzcuVar6 = zzcuVar;
                                            if (r9 == 2) {
                                                if (r9 == 5) {
                                                    iZzl = i51 + 4;
                                                    int i124 = zzcv.$r8$clinit;
                                                    zzeiVar = (zzei) zzeoVar2;
                                                    zzeiVar.zzg(zzcv.zzc(bArr2, i51));
                                                    while (iZzl < i57) {
                                                        iZzj4 = zzcv.zzj(bArr2, iZzl, zzcuVar6);
                                                        if (i14 == zzcuVar6.zza) {
                                                            i9 = i58;
                                                            i48 = i57;
                                                            zzcuVar5 = zzcuVar6;
                                                            i50 = i56;
                                                            i14 = i14 == true ? 1 : 0;
                                                            if (iZzl != i51) {
                                                                i98 = i9;
                                                                zzcuVar8 = zzcuVar5;
                                                                i2 = i48;
                                                                i99 = i50;
                                                                i101 = i14;
                                                                i97 = i10;
                                                                i95 = -1;
                                                                i94 = 0;
                                                                i93 = 3;
                                                                i96 = 1048575;
                                                                obj6 = obj;
                                                                iZzi = iZzl;
                                                                unsafe7 = unsafe;
                                                            } else {
                                                                obj3 = obj;
                                                                i8 = iZzl;
                                                                zzcuVar2 = zzcuVar5;
                                                                i12 = i50;
                                                                i14 = i14;
                                                                i7 = 3;
                                                            }
                                                        } else {
                                                            zzeiVar.zzg(zzcv.zzc(bArr2, iZzj4));
                                                            iZzl = iZzj4 + 4;
                                                        }
                                                        break;
                                                    }
                                                    i9 = i58;
                                                    i48 = i57;
                                                    zzcuVar5 = zzcuVar6;
                                                    i50 = i56;
                                                    i14 = i14 == true ? 1 : 0;
                                                    if (iZzl != i51) {
                                                        i98 = i9;
                                                        zzcuVar8 = zzcuVar5;
                                                        i2 = i48;
                                                        i99 = i50;
                                                        i101 = i14;
                                                        i97 = i10;
                                                        i95 = -1;
                                                        i94 = 0;
                                                        i93 = 3;
                                                        i96 = 1048575;
                                                        obj6 = obj;
                                                        iZzi = iZzl;
                                                        unsafe7 = unsafe;
                                                    } else {
                                                        obj3 = obj;
                                                        i8 = iZzl;
                                                        zzcuVar2 = zzcuVar5;
                                                        i12 = i50;
                                                        i14 = i14;
                                                        i7 = 3;
                                                    }
                                                }
                                                i9 = i58;
                                                i48 = i57;
                                                zzcuVar5 = zzcuVar6;
                                                i50 = i56;
                                                i14 = i14 == true ? 1 : 0;
                                                iZzl = i51;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                                break;
                                            } else {
                                                int i125 = zzcv.$r8$clinit;
                                                zzeiVar2 = (zzei) zzeoVar2;
                                                iZzj3 = zzcv.zzj(bArr2, i51, zzcuVar6);
                                                i60 = zzcuVar6.zza + iZzj3;
                                                while (iZzj3 < i60) {
                                                    zzeiVar2.zzg(zzcv.zzc(bArr2, iZzj3));
                                                    iZzj3 += 4;
                                                }
                                                if (iZzj3 != i60) {
                                                    throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                i48 = i57;
                                                zzcuVar5 = zzcuVar6;
                                                i50 = i56;
                                                i14 = i14 == true ? 1 : 0;
                                                iZzl = iZzj3;
                                                i9 = i58;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            }
                                            break;
                                        case 25:
                                        case 42:
                                            i56 = i49;
                                            i57 = i48;
                                            unsafe = unsafe3;
                                            i58 = i44;
                                            i51 = iZzk;
                                            zzcuVar6 = zzcuVar;
                                            if (r9 == 2) {
                                                int i126 = zzcv.$r8$clinit;
                                                SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m377m(zzeoVar2);
                                                iZzj3 = zzcv.zzj(bArr2, i51, zzcuVar6);
                                                i61 = zzcuVar6.zza + iZzj3;
                                                if (iZzj3 >= i61) {
                                                    zzcv.zzm(bArr2, iZzj3, zzcuVar6);
                                                    throw null;
                                                }
                                                if (iZzj3 != i61) {
                                                    throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                i48 = i57;
                                                zzcuVar5 = zzcuVar6;
                                                i50 = i56;
                                                i14 = i14 == true ? 1 : 0;
                                                iZzl = iZzj3;
                                                i9 = i58;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            } else {
                                                if (r9 == 0) {
                                                    int i127 = zzcv.$r8$clinit;
                                                    SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m377m(zzeoVar2);
                                                    zzcv.zzm(bArr2, i51, zzcuVar6);
                                                    long j5 = zzcuVar6.zzb;
                                                    throw null;
                                                }
                                                i9 = i58;
                                                i48 = i57;
                                                zzcuVar5 = zzcuVar6;
                                                i50 = i56;
                                                i14 = i14 == true ? 1 : 0;
                                                iZzl = i51;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            }
                                            break;
                                        case 26:
                                            i62 = iZzk;
                                            zzcuVar7 = zzcuVar;
                                            unsafe = unsafe3;
                                            if (r9 == 2) {
                                                if ((j2 & 536870912) == 0) {
                                                    i51 = i62;
                                                    iZzj5 = zzcv.zzj(bArr2, i51, zzcuVar7);
                                                    i67 = zzcuVar7.zza;
                                                    if (i67 >= 0) {
                                                        throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i67 == 0) {
                                                        r12 = "";
                                                        zzeoVar2.add(r12);
                                                    } else {
                                                        r12 = "";
                                                        zzeoVar2.add(new String(bArr2, iZzj5, i67, zzep.zza));
                                                        iZzj5 += i67;
                                                    }
                                                    while (iZzj5 < i48) {
                                                        iZzj7 = zzcv.zzj(bArr2, iZzj5, zzcuVar7);
                                                        if (i14 == zzcuVar7.zza) {
                                                            iZzj5 = zzcv.zzj(bArr2, iZzj7, zzcuVar7);
                                                            i68 = zzcuVar7.zza;
                                                            if (i68 >= 0) {
                                                                throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                            if (i68 == 0) {
                                                                zzeoVar2.add(r12);
                                                            } else {
                                                                zzeoVar2.add(new String(bArr2, iZzj5, i68, zzep.zza));
                                                                iZzj5 += i68;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    i51 = i62;
                                                    iZzj5 = zzcv.zzj(bArr2, i51, zzcuVar7);
                                                    i63 = zzcuVar7.zza;
                                                    if (i63 >= 0) {
                                                        throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i63 == 0) {
                                                        zzeoVar2.add("");
                                                    } else {
                                                        i64 = iZzj5 + i63;
                                                        if (zzhe.zzg(bArr2, iZzj5, i64)) {
                                                            throw new zzer(str);
                                                        }
                                                        zzeoVar2.add(new String(bArr2, iZzj5, i63, zzep.zza));
                                                        iZzj5 = i64;
                                                    }
                                                    while (iZzj5 < i48) {
                                                        iZzj6 = zzcv.zzj(bArr2, iZzj5, zzcuVar7);
                                                        if (i14 == zzcuVar7.zza) {
                                                            iZzj5 = zzcv.zzj(bArr2, iZzj6, zzcuVar7);
                                                            i65 = zzcuVar7.zza;
                                                            if (i65 >= 0) {
                                                                throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                            if (i65 == 0) {
                                                                zzeoVar2.add("");
                                                            } else {
                                                                i66 = iZzj5 + i65;
                                                                if (zzhe.zzg(bArr2, iZzj5, i66)) {
                                                                    throw new zzer(str);
                                                                }
                                                                zzeoVar2.add(new String(bArr2, iZzj5, i65, zzep.zza));
                                                                iZzj5 = i66;
                                                            }
                                                        }
                                                    }
                                                }
                                                i9 = i44;
                                                i48 = i48;
                                                i50 = i49;
                                                iZzl = iZzj5;
                                                zzcuVar5 = zzcuVar7;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            } else {
                                                i51 = i62;
                                                i9 = i44;
                                                zzcuVar5 = zzcuVar7;
                                                i50 = i49;
                                                i14 = i14 == true ? 1 : 0;
                                                i48 = i48;
                                                iZzl = i51;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            }
                                            break;
                                        case 27:
                                            i69 = iZzk;
                                            if (r9 == 2) {
                                                zzcuVar7 = zzcuVar;
                                                unsafe = unsafe3;
                                                i9 = i44;
                                                i48 = i48;
                                                i50 = i49;
                                                i51 = i69;
                                                iZzl = zzcv.zzf(zzfpVar3.zzv(i49), i14 == true ? 1 : 0, bArr, i69, i2, zzeoVar2, zzcuVar);
                                                zzcuVar5 = zzcuVar7;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            } else {
                                                unsafe = unsafe3;
                                                i9 = i44;
                                                i50 = i49;
                                                zzcuVar5 = zzcuVar;
                                                i51 = i69;
                                                i14 = i14 == true ? 1 : 0;
                                                iZzl = i51;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            }
                                            break;
                                        case 28:
                                            i70 = iZzk;
                                            i71 = i14 == true ? 1 : 0;
                                            if (r9 == 2) {
                                                iZzj8 = zzcv.zzj(bArr2, i70, zzcuVar);
                                                i72 = zzcuVar.zza;
                                                if (i72 >= 0) {
                                                    throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i72 <= bArr2.length - iZzj8) {
                                                    throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                if (i72 == 0) {
                                                    zzeoVar2.add(zzdf.zzb);
                                                } else {
                                                    zzeoVar2.add(zzdf.zzr(bArr2, iZzj8, i72));
                                                    iZzj8 += i72;
                                                }
                                                while (true) {
                                                    if (iZzj8 < i48) {
                                                        iZzj9 = zzcv.zzj(bArr2, iZzj8, zzcuVar);
                                                        i73 = i71;
                                                        if (i73 == zzcuVar.zza) {
                                                            iZzj8 = zzcv.zzj(bArr2, iZzj9, zzcuVar);
                                                            i74 = zzcuVar.zza;
                                                            if (i74 >= 0) {
                                                                throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                            if (i74 <= bArr2.length - iZzj8) {
                                                                throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                            }
                                                            if (i74 == 0) {
                                                                zzeoVar2.add(zzdf.zzb);
                                                            } else {
                                                                zzeoVar2.add(zzdf.zzr(bArr2, iZzj8, i74));
                                                                iZzj8 += i74;
                                                            }
                                                            i71 = i73 == true ? 1 : 0;
                                                        }
                                                    } else {
                                                        i73 = i71;
                                                    }
                                                }
                                                iZzl = iZzj8;
                                                i9 = i44;
                                                unsafe = unsafe3;
                                                i50 = i49;
                                                zzcuVar5 = zzcuVar;
                                                i51 = i70;
                                                i14 = i73;
                                            } else {
                                                i9 = i44;
                                                unsafe = unsafe3;
                                                i50 = i49;
                                                zzcuVar5 = zzcuVar;
                                                i51 = i70;
                                                i14 = i71 == true ? 1 : 0;
                                                iZzl = i51;
                                            }
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                            break;
                                        case 30:
                                        case 44:
                                            i75 = iZzk;
                                            i76 = i14 == true ? 1 : 0;
                                            if (r9 == 2) {
                                                iZzl2 = zzcv.zzg(bArr2, i75, zzeoVar2, zzcuVar);
                                            } else if (r9 == 0) {
                                                i50 = i49;
                                                zzcuVar5 = zzcuVar;
                                                i51 = i75;
                                                unsafe = unsafe3;
                                                i9 = i44;
                                                i14 = i76 == true ? 1 : 0;
                                                iZzl = i51;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            } else {
                                                iZzl2 = zzcv.zzl(i76 == true ? 1 : 0, bArr, i75, i2, zzeoVar2, zzcuVar);
                                            }
                                            zzelVarZzu = zzfpVar3.zzu(i49);
                                            zzgsVar2 = zzfpVar3.zzl;
                                            int i128 = zzgg.$r8$clinit;
                                            if (zzelVarZzu != null) {
                                                i77 = iZzl2;
                                                i78 = i76 == true ? 1 : 0;
                                                i79 = i44;
                                                z2 = true;
                                            } else if (zzeoVar2 != null) {
                                                size = zzeoVar2.size();
                                                objZzn2 = null;
                                                i80 = 0;
                                                i81 = 0;
                                                while (i80 < size) {
                                                    num = (Integer) zzeoVar2.get(i80);
                                                    int i129 = iZzl2;
                                                    iIntValue2 = num.intValue();
                                                    if (zzelVarZzu.zza(iIntValue2)) {
                                                        if (i80 != i81) {
                                                            zzeoVar2.set(i81, num);
                                                        }
                                                        i81++;
                                                        i82 = i44;
                                                    } else {
                                                        i82 = i44;
                                                        objZzn2 = zzgg.zzn(obj, i82, iIntValue2, objZzn2, zzgsVar2);
                                                    }
                                                    i80++;
                                                    iZzl2 = i129;
                                                    i44 = i82;
                                                    i76 = i76;
                                                }
                                                i77 = iZzl2;
                                                i78 = i76;
                                                i79 = i44;
                                                z2 = true;
                                                if (i81 != size) {
                                                    zzeoVar2.subList(i81, size).clear();
                                                }
                                            } else {
                                                i77 = iZzl2;
                                                i78 = i76 == true ? 1 : 0;
                                                i79 = i44;
                                                z2 = true;
                                                it = zzeoVar2.iterator();
                                                objZzn = null;
                                                while (it.hasNext()) {
                                                    iIntValue = ((Integer) it.next()).intValue();
                                                    if (!zzelVarZzu.zza(iIntValue)) {
                                                        objZzn = zzgg.zzn(obj, i79, iIntValue, objZzn, zzgsVar2);
                                                        it.remove();
                                                    }
                                                }
                                            }
                                            iZzl = i77;
                                            i9 = i79;
                                            unsafe = unsafe3;
                                            i50 = i49;
                                            zzcuVar5 = zzcuVar;
                                            i51 = i75;
                                            i14 = i78;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                            break;
                                        case 33:
                                        case 47:
                                            i83 = iZzk;
                                            i84 = i14 == true ? 1 : 0;
                                            if (r9 == 2) {
                                                if (r9 == 0) {
                                                    int i130 = zzcv.$r8$clinit;
                                                    zzeiVar3 = (zzei) zzeoVar2;
                                                    iZzl = zzcv.zzj(bArr2, i83, zzcuVar);
                                                    zzeiVar3.zzg(zzdj.zzb(zzcuVar.zza));
                                                    while (iZzl < i48) {
                                                        iZzj10 = zzcv.zzj(bArr2, iZzl, zzcuVar);
                                                        if (i84 == zzcuVar.zza) {
                                                            iZzl = zzcv.zzj(bArr2, iZzj10, zzcuVar);
                                                            zzeiVar3.zzg(zzdj.zzb(zzcuVar.zza));
                                                        }
                                                    }
                                                }
                                                i50 = i49;
                                                zzcuVar5 = zzcuVar;
                                                i51 = i83;
                                                unsafe = unsafe3;
                                                i14 = i84;
                                                i9 = i44;
                                                iZzl = i51;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            } else {
                                                int i131 = zzcv.$r8$clinit;
                                                zzeiVar4 = (zzei) zzeoVar2;
                                                iZzj11 = zzcv.zzj(bArr2, i83, zzcuVar);
                                                i85 = zzcuVar.zza + iZzj11;
                                                while (iZzj11 < i85) {
                                                    iZzj11 = zzcv.zzj(bArr2, iZzj11, zzcuVar);
                                                    zzeiVar4.zzg(zzdj.zzb(zzcuVar.zza));
                                                }
                                                if (iZzj11 != i85) {
                                                    throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                iZzl = iZzj11;
                                            }
                                            i50 = i49;
                                            zzcuVar5 = zzcuVar;
                                            i51 = i83;
                                            unsafe = unsafe3;
                                            i14 = i84;
                                            i9 = i44;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                            break;
                                        case 34:
                                        case 48:
                                            i83 = iZzk;
                                            i84 = i14 == true ? 1 : 0;
                                            if (r9 == 2) {
                                                int i132 = zzcv.$r8$clinit;
                                                SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m377m(zzeoVar2);
                                                iZzj11 = zzcv.zzj(bArr2, i83, zzcuVar);
                                                i86 = zzcuVar.zza + iZzj11;
                                                if (iZzj11 >= i86) {
                                                    zzcv.zzm(bArr2, iZzj11, zzcuVar);
                                                    zzdj.zzc(zzcuVar.zzb);
                                                    throw null;
                                                }
                                                if (iZzj11 != i86) {
                                                    throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                iZzl = iZzj11;
                                                i50 = i49;
                                                zzcuVar5 = zzcuVar;
                                                i51 = i83;
                                                unsafe = unsafe3;
                                                i14 = i84;
                                                i9 = i44;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            } else {
                                                if (r9 == 0) {
                                                    int i133 = zzcv.$r8$clinit;
                                                    SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m377m(zzeoVar2);
                                                    zzcv.zzm(bArr2, i83, zzcuVar);
                                                    zzdj.zzc(zzcuVar.zzb);
                                                    throw null;
                                                }
                                                i50 = i49;
                                                zzcuVar5 = zzcuVar;
                                                i51 = i83;
                                                unsafe = unsafe3;
                                                i14 = i84;
                                                i9 = i44;
                                                iZzl = i51;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            }
                                            break;
                                        default:
                                            if (r9 == 3) {
                                                i87 = ((i14 == true ? 1 : 0) & (-8)) | 4;
                                                zzgeVarZzv = zzfpVar3.zzv(i49);
                                                i83 = iZzk;
                                                i84 = i14 == true ? 1 : 0;
                                                iZzl = zzcv.zzd(zzgeVarZzv, bArr, iZzk, i2, i87, zzcuVar);
                                                zzeoVar2.add(zzcuVar.zzc);
                                                while (iZzl < i48) {
                                                    iZzj12 = zzcv.zzj(bArr2, iZzl, zzcuVar);
                                                    if (i84 == zzcuVar.zza) {
                                                        i50 = i49;
                                                        zzcuVar5 = zzcuVar;
                                                        i51 = i83;
                                                        unsafe = unsafe3;
                                                        i14 = i84;
                                                        i9 = i44;
                                                        if (iZzl != i51) {
                                                            i98 = i9;
                                                            zzcuVar8 = zzcuVar5;
                                                            i2 = i48;
                                                            i99 = i50;
                                                            i101 = i14;
                                                            i97 = i10;
                                                            i95 = -1;
                                                            i94 = 0;
                                                            i93 = 3;
                                                            i96 = 1048575;
                                                            obj6 = obj;
                                                            iZzi = iZzl;
                                                            unsafe7 = unsafe;
                                                        } else {
                                                            obj3 = obj;
                                                            i8 = iZzl;
                                                            zzcuVar2 = zzcuVar5;
                                                            i12 = i50;
                                                            i14 = i14;
                                                            i7 = 3;
                                                        }
                                                    } else {
                                                        iZzl = zzcv.zzd(zzgeVarZzv, bArr, iZzj12, i2, i87, zzcuVar);
                                                        zzeoVar2.add(zzcuVar.zzc);
                                                    }
                                                    break;
                                                }
                                                i50 = i49;
                                                zzcuVar5 = zzcuVar;
                                                i51 = i83;
                                                unsafe = unsafe3;
                                                i14 = i84;
                                                i9 = i44;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            } else {
                                                i14 = i14 == true ? 1 : 0;
                                                i50 = i49;
                                                zzcuVar5 = zzcuVar;
                                                unsafe = unsafe3;
                                                i9 = i44;
                                                i51 = iZzk;
                                                iZzl = i51;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            }
                                            break;
                                    }
                                } else {
                                    unsafe = unsafe3;
                                    i9 = i44;
                                    i47 = iZzk;
                                    i46 = i49;
                                    zzcuVar4 = zzcuVar;
                                    if (iZzr == 50) {
                                        unsafe6 = zzb;
                                        j3 = iArr[i46 + 2] & 1048575;
                                        switch (iZzr) {
                                            case 51:
                                                i46 = i46;
                                                i14 = i14 == true ? 1 : 0;
                                                i47 = i47;
                                                i7 = 3;
                                                obj3 = obj;
                                                zzcuVar2 = zzcuVar;
                                                if (r9 == 1) {
                                                    i88 = i47 + 8;
                                                    unsafe6.putObject(obj3, j, Double.valueOf(Double.longBitsToDouble(zzcv.zzq(bArr2, i47))));
                                                    unsafe6.putInt(obj3, j3, i9);
                                                    iZzj13 = i88;
                                                } else {
                                                    iZzj13 = i47;
                                                }
                                                if (iZzj13 != i47) {
                                                    zzfpVar3 = this;
                                                    i2 = i2;
                                                    iZzi = iZzj13;
                                                    i98 = i9;
                                                    i101 = i14 == true ? 1 : 0;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i93 = i7;
                                                    i94 = 0;
                                                    unsafe7 = unsafe;
                                                    i96 = 1048575;
                                                    obj6 = obj3;
                                                    zzcuVar8 = zzcuVar2;
                                                    i99 = i46;
                                                } else {
                                                    i12 = i46;
                                                    i8 = iZzj13;
                                                }
                                                break;
                                            case 52:
                                                i46 = i46;
                                                i14 = i14 == true ? 1 : 0;
                                                i47 = i47;
                                                i7 = 3;
                                                obj3 = obj;
                                                zzcuVar2 = zzcuVar;
                                                if (r9 == 5) {
                                                    i88 = i47 + 4;
                                                    unsafe6.putObject(obj3, j, Float.valueOf(Float.intBitsToFloat(zzcv.zzc(bArr2, i47))));
                                                    unsafe6.putInt(obj3, j3, i9);
                                                    iZzj13 = i88;
                                                } else {
                                                    iZzj13 = i47;
                                                }
                                                if (iZzj13 != i47) {
                                                    zzfpVar3 = this;
                                                    i2 = i2;
                                                    iZzi = iZzj13;
                                                    i98 = i9;
                                                    i101 = i14 == true ? 1 : 0;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i93 = i7;
                                                    i94 = 0;
                                                    unsafe7 = unsafe;
                                                    i96 = 1048575;
                                                    obj6 = obj3;
                                                    zzcuVar8 = zzcuVar2;
                                                    i99 = i46;
                                                } else {
                                                    i12 = i46;
                                                    i8 = iZzj13;
                                                }
                                                break;
                                            case EACTags.SEX /* 53 */:
                                            case EACTags.CURRENCY_EXPONENT /* 54 */:
                                                i46 = i46;
                                                i14 = i14 == true ? 1 : 0;
                                                i47 = i47;
                                                i7 = 3;
                                                obj3 = obj;
                                                zzcuVar2 = zzcuVar;
                                                if (r9 == 0) {
                                                    iZzm = zzcv.zzm(bArr2, i47, zzcuVar2);
                                                    unsafe6.putObject(obj3, j, Long.valueOf(zzcuVar2.zzb));
                                                    unsafe6.putInt(obj3, j3, i9);
                                                    iZzj13 = iZzm;
                                                } else {
                                                    iZzj13 = i47;
                                                }
                                                if (iZzj13 != i47) {
                                                    zzfpVar3 = this;
                                                    i2 = i2;
                                                    iZzi = iZzj13;
                                                    i98 = i9;
                                                    i101 = i14 == true ? 1 : 0;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i93 = i7;
                                                    i94 = 0;
                                                    unsafe7 = unsafe;
                                                    i96 = 1048575;
                                                    obj6 = obj3;
                                                    zzcuVar8 = zzcuVar2;
                                                    i99 = i46;
                                                } else {
                                                    i12 = i46;
                                                    i8 = iZzj13;
                                                }
                                                break;
                                            case 55:
                                            case PacketTags.EXPERIMENTAL_3 /* 62 */:
                                                i46 = i46;
                                                i14 = i14 == true ? 1 : 0;
                                                i47 = i47;
                                                i7 = 3;
                                                obj3 = obj;
                                                zzcuVar2 = zzcuVar;
                                                if (r9 == 0) {
                                                    iZzj13 = zzcv.zzj(bArr2, i47, zzcuVar2);
                                                    unsafe6.putObject(obj3, j, Integer.valueOf(zzcuVar2.zza));
                                                    unsafe6.putInt(obj3, j3, i9);
                                                } else {
                                                    iZzj13 = i47;
                                                }
                                                if (iZzj13 != i47) {
                                                    zzfpVar3 = this;
                                                    i2 = i2;
                                                    iZzi = iZzj13;
                                                    i98 = i9;
                                                    i101 = i14 == true ? 1 : 0;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i93 = i7;
                                                    i94 = 0;
                                                    unsafe7 = unsafe;
                                                    i96 = 1048575;
                                                    obj6 = obj3;
                                                    zzcuVar8 = zzcuVar2;
                                                    i99 = i46;
                                                } else {
                                                    i12 = i46;
                                                    i8 = iZzj13;
                                                }
                                                break;
                                            case 56:
                                            case EACTags.ELEMENT_LIST /* 65 */:
                                                i46 = i46;
                                                i14 = i14 == true ? 1 : 0;
                                                i47 = i47;
                                                i7 = 3;
                                                obj3 = obj;
                                                zzcuVar2 = zzcuVar;
                                                if (r9 == 1) {
                                                    iZzj13 = i47 + 8;
                                                    unsafe6.putObject(obj3, j, Long.valueOf(zzcv.zzq(bArr2, i47)));
                                                    unsafe6.putInt(obj3, j3, i9);
                                                } else {
                                                    iZzj13 = i47;
                                                }
                                                if (iZzj13 != i47) {
                                                    zzfpVar3 = this;
                                                    i2 = i2;
                                                    iZzi = iZzj13;
                                                    i98 = i9;
                                                    i101 = i14 == true ? 1 : 0;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i93 = i7;
                                                    i94 = 0;
                                                    unsafe7 = unsafe;
                                                    i96 = 1048575;
                                                    obj6 = obj3;
                                                    zzcuVar8 = zzcuVar2;
                                                    i99 = i46;
                                                } else {
                                                    i12 = i46;
                                                    i8 = iZzj13;
                                                }
                                                break;
                                            case 57:
                                            case 64:
                                                i46 = i46;
                                                i14 = i14 == true ? 1 : 0;
                                                i47 = i47;
                                                i7 = 3;
                                                obj3 = obj;
                                                zzcuVar2 = zzcuVar;
                                                if (r9 == 5) {
                                                    i88 = i47 + 4;
                                                    unsafe6.putObject(obj3, j, Integer.valueOf(zzcv.zzc(bArr2, i47)));
                                                    unsafe6.putInt(obj3, j3, i9);
                                                    iZzj13 = i88;
                                                } else {
                                                    iZzj13 = i47;
                                                }
                                                if (iZzj13 != i47) {
                                                    zzfpVar3 = this;
                                                    i2 = i2;
                                                    iZzi = iZzj13;
                                                    i98 = i9;
                                                    i101 = i14 == true ? 1 : 0;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i93 = i7;
                                                    i94 = 0;
                                                    unsafe7 = unsafe;
                                                    i96 = 1048575;
                                                    obj6 = obj3;
                                                    zzcuVar8 = zzcuVar2;
                                                    i99 = i46;
                                                } else {
                                                    i12 = i46;
                                                    i8 = iZzj13;
                                                }
                                                break;
                                            case 58:
                                                i46 = i46;
                                                i14 = i14 == true ? 1 : 0;
                                                i47 = i47;
                                                i7 = 3;
                                                obj3 = obj;
                                                zzcuVar2 = zzcuVar;
                                                if (r9 == 0) {
                                                    iZzm = zzcv.zzm(bArr2, i47, zzcuVar2);
                                                    if (zzcuVar2.zzb != 0) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    unsafe6.putObject(obj3, j, Boolean.valueOf(z3));
                                                    unsafe6.putInt(obj3, j3, i9);
                                                    iZzj13 = iZzm;
                                                } else {
                                                    iZzj13 = i47;
                                                }
                                                if (iZzj13 != i47) {
                                                    zzfpVar3 = this;
                                                    i2 = i2;
                                                    iZzi = iZzj13;
                                                    i98 = i9;
                                                    i101 = i14 == true ? 1 : 0;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i93 = i7;
                                                    i94 = 0;
                                                    unsafe7 = unsafe;
                                                    i96 = 1048575;
                                                    obj6 = obj3;
                                                    zzcuVar8 = zzcuVar2;
                                                    i99 = i46;
                                                } else {
                                                    i12 = i46;
                                                    i8 = iZzj13;
                                                }
                                                break;
                                            case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                                                i46 = i46;
                                                i14 = i14 == true ? 1 : 0;
                                                i47 = i47;
                                                i7 = 3;
                                                obj3 = obj;
                                                zzcuVar2 = zzcuVar;
                                                if (r9 == 2) {
                                                    iZzj14 = zzcv.zzj(bArr2, i47, zzcuVar2);
                                                    i89 = zzcuVar2.zza;
                                                    if (i89 == 0) {
                                                        unsafe6.putObject(obj3, j, "");
                                                    } else {
                                                        i90 = i15 & 536870912;
                                                        i91 = iZzj14 + i89;
                                                        if (i90 == 0 && !zzhe.zzg(bArr2, iZzj14, i91)) {
                                                            throw new zzer(str);
                                                        }
                                                        unsafe6.putObject(obj3, j, new String(bArr2, iZzj14, i89, zzep.zza));
                                                        iZzj14 = i91;
                                                    }
                                                    unsafe6.putInt(obj3, j3, i9);
                                                    iZzj13 = iZzj14;
                                                } else {
                                                    i46 = i46;
                                                    iZzj13 = i47;
                                                }
                                                if (iZzj13 != i47) {
                                                    zzfpVar3 = this;
                                                    i2 = i2;
                                                    iZzi = iZzj13;
                                                    i98 = i9;
                                                    i101 = i14 == true ? 1 : 0;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i93 = i7;
                                                    i94 = 0;
                                                    unsafe7 = unsafe;
                                                    i96 = 1048575;
                                                    obj6 = obj3;
                                                    zzcuVar8 = zzcuVar2;
                                                    i99 = i46;
                                                } else {
                                                    i12 = i46;
                                                    i8 = iZzj13;
                                                }
                                                break;
                                            case 60:
                                                i47 = i47;
                                                zzcuVar2 = zzcuVar;
                                                if (r9 == 2) {
                                                    Object objZzy = zzy(obj, i9, i46);
                                                    zzge zzgeVarZzv2 = zzv(i46);
                                                    i7 = 3;
                                                    i14 = i14 == true ? 1 : 0;
                                                    iZzj13 = zzcv.zzo(objZzy, zzgeVarZzv2, bArr, i47, i2, zzcuVar);
                                                    zzG(obj, i9, i46, objZzy);
                                                    obj3 = obj;
                                                    i46 = i46;
                                                } else {
                                                    i14 = i14 == true ? 1 : 0;
                                                    i7 = 3;
                                                    obj3 = obj;
                                                    i46 = i46;
                                                    iZzj13 = i47;
                                                }
                                                if (iZzj13 != i47) {
                                                    zzfpVar3 = this;
                                                    i2 = i2;
                                                    iZzi = iZzj13;
                                                    i98 = i9;
                                                    i101 = i14 == true ? 1 : 0;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i93 = i7;
                                                    i94 = 0;
                                                    unsafe7 = unsafe;
                                                    i96 = 1048575;
                                                    obj6 = obj3;
                                                    zzcuVar8 = zzcuVar2;
                                                    i99 = i46;
                                                } else {
                                                    i12 = i46;
                                                    i8 = iZzj13;
                                                }
                                                break;
                                            case 61:
                                                i47 = i47;
                                                obj5 = obj;
                                                if (r9 == 2) {
                                                    zzcuVar2 = zzcuVar;
                                                    iZza = zzcv.zza(bArr2, i47, zzcuVar2);
                                                    unsafe6.putObject(obj5, j, zzcuVar2.zzc);
                                                    unsafe6.putInt(obj5, j3, i9);
                                                    iZzj13 = iZza;
                                                    i46 = i46;
                                                    i14 = i14 == true ? 1 : 0;
                                                    i7 = 3;
                                                    obj3 = obj5;
                                                    if (iZzj13 != i47) {
                                                        zzfpVar3 = this;
                                                        i2 = i2;
                                                        iZzi = iZzj13;
                                                        i98 = i9;
                                                        i101 = i14 == true ? 1 : 0;
                                                        i97 = i10;
                                                        i95 = -1;
                                                        i93 = i7;
                                                        i94 = 0;
                                                        unsafe7 = unsafe;
                                                        i96 = 1048575;
                                                        obj6 = obj3;
                                                        zzcuVar8 = zzcuVar2;
                                                        i99 = i46;
                                                    } else {
                                                        i12 = i46;
                                                        i8 = iZzj13;
                                                    }
                                                }
                                                zzcuVar2 = zzcuVar;
                                                i7 = 3;
                                                obj3 = obj5;
                                                iZzj13 = i47;
                                                if (iZzj13 != i47) {
                                                    zzfpVar3 = this;
                                                    i2 = i2;
                                                    iZzi = iZzj13;
                                                    i98 = i9;
                                                    i101 = i14 == true ? 1 : 0;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i93 = i7;
                                                    i94 = 0;
                                                    unsafe7 = unsafe;
                                                    i96 = 1048575;
                                                    obj6 = obj3;
                                                    zzcuVar8 = zzcuVar2;
                                                    i99 = i46;
                                                } else {
                                                    i12 = i46;
                                                    i8 = iZzj13;
                                                }
                                                break;
                                            case 63:
                                                i47 = i47;
                                                obj5 = obj;
                                                if (r9 == 0) {
                                                    iZza = zzcv.zzj(bArr2, i47, zzcuVar);
                                                    i92 = zzcuVar.zza;
                                                    zzelVarZzu2 = zzu(i46);
                                                    if (zzelVarZzu2 != null || zzelVarZzu2.zza(i92)) {
                                                        unsafe6.putObject(obj5, j, Integer.valueOf(i92));
                                                        unsafe6.putInt(obj5, j3, i9);
                                                    } else {
                                                        zzd(obj).zzj(i14 == true ? 1 : 0, Long.valueOf(i92));
                                                    }
                                                    zzcuVar2 = zzcuVar;
                                                    iZzj13 = iZza;
                                                    i46 = i46;
                                                    i14 = i14 == true ? 1 : 0;
                                                    i7 = 3;
                                                    obj3 = obj5;
                                                    if (iZzj13 != i47) {
                                                        zzfpVar3 = this;
                                                        i2 = i2;
                                                        iZzi = iZzj13;
                                                        i98 = i9;
                                                        i101 = i14 == true ? 1 : 0;
                                                        i97 = i10;
                                                        i95 = -1;
                                                        i93 = i7;
                                                        i94 = 0;
                                                        unsafe7 = unsafe;
                                                        i96 = 1048575;
                                                        obj6 = obj3;
                                                        zzcuVar8 = zzcuVar2;
                                                        i99 = i46;
                                                    } else {
                                                        i12 = i46;
                                                        i8 = iZzj13;
                                                    }
                                                } else {
                                                    zzcuVar2 = zzcuVar;
                                                    i7 = 3;
                                                    obj3 = obj5;
                                                    iZzj13 = i47;
                                                    if (iZzj13 != i47) {
                                                        zzfpVar3 = this;
                                                        i2 = i2;
                                                        iZzi = iZzj13;
                                                        i98 = i9;
                                                        i101 = i14 == true ? 1 : 0;
                                                        i97 = i10;
                                                        i95 = -1;
                                                        i93 = i7;
                                                        i94 = 0;
                                                        unsafe7 = unsafe;
                                                        i96 = 1048575;
                                                        obj6 = obj3;
                                                        zzcuVar8 = zzcuVar2;
                                                        i99 = i46;
                                                    } else {
                                                        i12 = i46;
                                                        i8 = iZzj13;
                                                    }
                                                }
                                                break;
                                            case EACTags.ADDRESS /* 66 */:
                                                i47 = i47;
                                                obj5 = obj;
                                                zzcuVar2 = zzcuVar;
                                                if (r9 == 0) {
                                                    iZza = zzcv.zzj(bArr2, i47, zzcuVar2);
                                                    unsafe6.putObject(obj5, j, Integer.valueOf(zzdj.zzb(zzcuVar2.zza)));
                                                    unsafe6.putInt(obj5, j3, i9);
                                                    iZzj13 = iZza;
                                                    i46 = i46;
                                                    i14 = i14 == true ? 1 : 0;
                                                    i7 = 3;
                                                    obj3 = obj5;
                                                    if (iZzj13 != i47) {
                                                        zzfpVar3 = this;
                                                        i2 = i2;
                                                        iZzi = iZzj13;
                                                        i98 = i9;
                                                        i101 = i14 == true ? 1 : 0;
                                                        i97 = i10;
                                                        i95 = -1;
                                                        i93 = i7;
                                                        i94 = 0;
                                                        unsafe7 = unsafe;
                                                        i96 = 1048575;
                                                        obj6 = obj3;
                                                        zzcuVar8 = zzcuVar2;
                                                        i99 = i46;
                                                    } else {
                                                        i12 = i46;
                                                        i8 = iZzj13;
                                                    }
                                                }
                                                i7 = 3;
                                                obj3 = obj5;
                                                iZzj13 = i47;
                                                if (iZzj13 != i47) {
                                                    zzfpVar3 = this;
                                                    i2 = i2;
                                                    iZzi = iZzj13;
                                                    i98 = i9;
                                                    i101 = i14 == true ? 1 : 0;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i93 = i7;
                                                    i94 = 0;
                                                    unsafe7 = unsafe;
                                                    i96 = 1048575;
                                                    obj6 = obj3;
                                                    zzcuVar8 = zzcuVar2;
                                                    i99 = i46;
                                                } else {
                                                    i12 = i46;
                                                    i8 = iZzj13;
                                                }
                                                break;
                                            case 67:
                                                i47 = i47;
                                                obj5 = obj;
                                                zzcuVar2 = zzcuVar;
                                                if (r9 == 0) {
                                                    iZzj13 = zzcv.zzm(bArr2, i47, zzcuVar2);
                                                    unsafe6.putObject(obj5, j, Long.valueOf(zzdj.zzc(zzcuVar2.zzb)));
                                                    unsafe6.putInt(obj5, j3, i9);
                                                    i46 = i46;
                                                    i14 = i14 == true ? 1 : 0;
                                                    i7 = 3;
                                                    obj3 = obj5;
                                                    if (iZzj13 != i47) {
                                                        zzfpVar3 = this;
                                                        i2 = i2;
                                                        iZzi = iZzj13;
                                                        i98 = i9;
                                                        i101 = i14 == true ? 1 : 0;
                                                        i97 = i10;
                                                        i95 = -1;
                                                        i93 = i7;
                                                        i94 = 0;
                                                        unsafe7 = unsafe;
                                                        i96 = 1048575;
                                                        obj6 = obj3;
                                                        zzcuVar8 = zzcuVar2;
                                                        i99 = i46;
                                                    } else {
                                                        i12 = i46;
                                                        i8 = iZzj13;
                                                    }
                                                } else {
                                                    i7 = 3;
                                                    obj3 = obj5;
                                                    iZzj13 = i47;
                                                    if (iZzj13 != i47) {
                                                        zzfpVar3 = this;
                                                        i2 = i2;
                                                        iZzi = iZzj13;
                                                        i98 = i9;
                                                        i101 = i14 == true ? 1 : 0;
                                                        i97 = i10;
                                                        i95 = -1;
                                                        i93 = i7;
                                                        i94 = 0;
                                                        unsafe7 = unsafe;
                                                        i96 = 1048575;
                                                        obj6 = obj3;
                                                        zzcuVar8 = zzcuVar2;
                                                        i99 = i46;
                                                    } else {
                                                        i12 = i46;
                                                        i8 = iZzj13;
                                                    }
                                                }
                                                break;
                                            case 68:
                                                if (r9 == 3) {
                                                    int i134 = ((i14 == true ? 1 : 0) & (-8)) | 4;
                                                    Object objZzy2 = zzfpVar3.zzy(obj, i9, i46);
                                                    int iZzn = zzcv.zzn(objZzy2, zzfpVar3.zzv(i46), bArr, i47, i2, i134, zzcuVar);
                                                    zzfpVar3.zzG(obj, i9, i46, objZzy2);
                                                    zzcuVar2 = zzcuVar;
                                                    i7 = 3;
                                                    i46 = i46;
                                                    i14 = i14 == true ? 1 : 0;
                                                    iZzj13 = iZzn;
                                                    obj3 = obj;
                                                    i47 = i47;
                                                } else {
                                                    i7 = 3;
                                                    obj3 = obj;
                                                    zzcuVar2 = zzcuVar;
                                                    iZzj13 = i47;
                                                }
                                                if (iZzj13 != i47) {
                                                    zzfpVar3 = this;
                                                    i2 = i2;
                                                    iZzi = iZzj13;
                                                    i98 = i9;
                                                    i101 = i14 == true ? 1 : 0;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i93 = i7;
                                                    i94 = 0;
                                                    unsafe7 = unsafe;
                                                    i96 = 1048575;
                                                    obj6 = obj3;
                                                    zzcuVar8 = zzcuVar2;
                                                    i99 = i46;
                                                } else {
                                                    i12 = i46;
                                                    i8 = iZzj13;
                                                }
                                                break;
                                            default:
                                                i7 = 3;
                                                obj3 = obj;
                                                zzcuVar2 = zzcuVar;
                                                iZzj13 = i47;
                                                if (iZzj13 != i47) {
                                                    zzfpVar3 = this;
                                                    i2 = i2;
                                                    iZzi = iZzj13;
                                                    i98 = i9;
                                                    i101 = i14 == true ? 1 : 0;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i93 = i7;
                                                    i94 = 0;
                                                    unsafe7 = unsafe;
                                                    i96 = 1048575;
                                                    obj6 = obj3;
                                                    zzcuVar8 = zzcuVar2;
                                                    i99 = i46;
                                                } else {
                                                    i12 = i46;
                                                    i8 = iZzj13;
                                                }
                                                break;
                                        }
                                    } else {
                                        if (r9 == 2) {
                                            unsafe5 = zzb;
                                            Object objZzw = zzfpVar3.zzw(i46);
                                            object = unsafe5.getObject(obj, j);
                                            if (!((zzfg) object).zze()) {
                                                zzfg zzfgVarZzb = zzfg.zza().zzb();
                                                zzfh.zza(zzfgVarZzb, object);
                                                unsafe5.putObject(obj, j, zzfgVarZzb);
                                            }
                                            throw null;
                                        }
                                        obj4 = obj;
                                        i12 = i46;
                                        i14 = i14 == true ? 1 : 0;
                                        i8 = i47;
                                        i7 = 3;
                                        obj3 = obj4;
                                        zzcuVar2 = zzcuVar4;
                                    }
                                }
                            } else if (r9 == 2) {
                                zzeoVarZzd = (zzeo) unsafe3.getObject(obj6, j);
                                if (!zzeoVarZzd.zzc()) {
                                    int size3 = zzeoVarZzd.size();
                                    zzeoVarZzd = zzeoVarZzd.zzd(size3 != 0 ? size3 + size3 : 10);
                                    unsafe3.putObject(obj6, j, zzeoVarZzd);
                                }
                                iZzi = zzcv.zzf(zzfpVar3.zzv(i99), i14 == true ? 1 : 0, bArr, iZzk, i2, zzeoVarZzd, zzcuVar);
                                i2 = i2;
                                i96 = 1048575;
                                unsafe7 = unsafe3;
                                i99 = i99;
                                i101 = i14 == true ? 1 : 0;
                                i97 = i45;
                                i95 = -1;
                                i94 = 0;
                                i98 = i44;
                                i93 = 3;
                                zzcuVar8 = zzcuVar;
                            } else {
                                i10 = i45;
                                zzcuVar4 = zzcuVar;
                                unsafe = unsafe3;
                                obj4 = obj6;
                                i46 = i99;
                                i9 = i44;
                                i47 = iZzk;
                                i12 = i46;
                                i14 = i14 == true ? 1 : 0;
                                i8 = i47;
                                i7 = 3;
                                obj3 = obj4;
                                zzcuVar2 = zzcuVar4;
                            }
                        }
                    } else {
                        unsafe = unsafe7;
                        i7 = i93;
                        i8 = iZzk;
                        zzcuVar2 = zzcuVar8;
                        obj3 = obj6;
                        i9 = i103;
                        i10 = i97;
                        i11 = i95;
                        i12 = i94;
                        i13 = i12;
                        i14 = i101 == true ? 1 : 0;
                    }
                    if (i14 == i3 || i3 == 0) {
                        if (this.zzh) {
                            zzdsVar = zzcuVar2.zzd;
                            int i135 = zzds.zzb;
                            int i136 = zzfu.$r8$clinit;
                            if (zzdsVar != zzds.zza) {
                                zzfm zzfmVar = this.zzg;
                                zzgsVar = this.zzl;
                                int i137 = zzcv.$r8$clinit;
                                zzefVarZzb = zzdsVar.zzb(zzfmVar, i9);
                                if (zzefVarZzb == null) {
                                    iZzi = zzcv.zzi(i14 == true ? 1 : 0, bArr, i8, i2, zzd(obj), zzcuVar);
                                    i101 = i14;
                                    zzfpVar2 = this;
                                    i96 = 1048575;
                                } else {
                                    zzed zzedVar = (zzed) obj;
                                    zzedVar.zzc();
                                    i101 = i14;
                                    zzfpVar2 = this;
                                    iZzi = zzcv.zzb(i14 == true ? 1 : 0, bArr, i8, i2, zzedVar, zzefVarZzb, zzgsVar, zzcuVar);
                                    i96 = 1048575;
                                }
                            } else {
                                i101 = i14;
                                zzfpVar2 = this;
                                i96 = 1048575;
                                iZzi = zzcv.zzi(i101 == true ? 1 : 0, bArr, i8, i2, zzd(obj), zzcuVar);
                            }
                        } else {
                            i101 = i14;
                            zzfpVar2 = this;
                            i96 = 1048575;
                            iZzi = zzcv.zzi(i101 == true ? 1 : 0, bArr, i8, i2, zzd(obj), zzcuVar);
                        }
                        bArr2 = bArr;
                        i2 = i2;
                        zzcuVar8 = zzcuVar;
                        i97 = i10;
                        i95 = i11;
                        i93 = i7;
                        i94 = i13;
                        unsafe7 = unsafe;
                        i99 = i12;
                        zzfpVar3 = zzfpVar2;
                        i98 = i9;
                        obj6 = obj;
                    } else {
                        zzfpVar = this;
                        iZzi = i8;
                        obj2 = obj3;
                        i5 = i14;
                        i4 = i100;
                        i6 = i10;
                        i96 = 1048575;
                    }
                }
                i99 = iZzq;
                if (i99 == i95) {
                    r9 = (i101 == true ? 1 : 0) & 7;
                    iArr = zzfpVar3.zzc;
                    i15 = iArr[i99 + 1];
                    iZzr = zzr(i15);
                    j = i15 & i96;
                    str = "Protocol message had invalid UTF-8.";
                    if (iZzr <= 17) {
                        int i1014 = iArr[i99 + 2];
                        i16 = 1 << (i1014 >>> 20);
                        i17 = 1048575;
                        i18 = i1014 & 1048575;
                        if (i18 != i97) {
                            if (i97 != 1048575) {
                                unsafe7.putInt(obj6, i97, i100);
                                i17 = 1048575;
                            }
                            if (i18 == i17) {
                                i19 = 0;
                            } else {
                                i19 = unsafe7.getInt(obj6, i18);
                            }
                            i97 = i18;
                        } else {
                            i19 = i100;
                            i97 = i97;
                        }
                        switch (iZzr) {
                            case 0:
                                unsafe2 = unsafe7;
                                i21 = i103;
                                i22 = i101 == true ? 1 : 0;
                                r14 = true;
                                i20 = 3;
                                i11 = -1;
                                i13 = 0;
                                zzcuVar3 = zzcuVar;
                                if (r9 == 1) {
                                    i23 = iZzk + 8;
                                    i24 = i19 | i16;
                                    zzgz.zzo(obj6, j, Double.longBitsToDouble(zzcv.zzq(bArr2, iZzk)));
                                    i2 = i2;
                                    i101 = i22;
                                    zzcuVar8 = zzcuVar3;
                                    i95 = i11;
                                    i98 = i21;
                                    i96 = 1048575;
                                    iZzi = i23;
                                    unsafe7 = unsafe2;
                                    i97 = i97;
                                    i100 = i24;
                                    i93 = i20;
                                    i94 = i13;
                                } else {
                                    i7 = i20;
                                    i8 = iZzk;
                                    i12 = i99;
                                    unsafe = unsafe2;
                                    i10 = i97;
                                    i100 = i19;
                                    i14 = i22;
                                    obj3 = obj6;
                                    zzcuVar2 = zzcuVar3;
                                    i9 = i21;
                                }
                                break;
                            case 1:
                                unsafe2 = unsafe7;
                                i21 = i103;
                                i22 = i101 == true ? 1 : 0;
                                r14 = true;
                                i20 = 3;
                                i11 = -1;
                                i13 = 0;
                                zzcuVar3 = zzcuVar;
                                if (r9 == 5) {
                                    i23 = iZzk + 4;
                                    i24 = i19 | i16;
                                    zzgz.zzp(obj6, j, Float.intBitsToFloat(zzcv.zzc(bArr2, iZzk)));
                                    i2 = i2;
                                    i101 = i22;
                                    zzcuVar8 = zzcuVar3;
                                    i95 = i11;
                                    i98 = i21;
                                    i96 = 1048575;
                                    iZzi = i23;
                                    unsafe7 = unsafe2;
                                    i97 = i97;
                                    i100 = i24;
                                    i93 = i20;
                                    i94 = i13;
                                } else {
                                    i7 = i20;
                                    i8 = iZzk;
                                    i12 = i99;
                                    unsafe = unsafe2;
                                    i10 = i97;
                                    i100 = i19;
                                    i14 = i22;
                                    obj3 = obj6;
                                    zzcuVar2 = zzcuVar3;
                                    i9 = i21;
                                }
                                break;
                            case 2:
                            case 3:
                                unsafe2 = unsafe7;
                                i21 = i103;
                                i22 = i101 == true ? 1 : 0;
                                i93 = 3;
                                i11 = -1;
                                i13 = 0;
                                zzcuVar3 = zzcuVar;
                                if (r9 == 0) {
                                    int iZzm5 = zzcv.zzm(bArr2, iZzk, zzcuVar3);
                                    unsafe7 = unsafe2;
                                    unsafe7.putLong(obj, j, zzcuVar3.zzb);
                                    zzcuVar8 = zzcuVar3;
                                    i93 = 3;
                                    iZzi = iZzm5;
                                    i95 = -1;
                                    i94 = 0;
                                    i100 = i19 | i16;
                                    i101 = i22 == true ? 1 : 0;
                                    i98 = i21;
                                    i96 = 1048575;
                                } else {
                                    i20 = i93;
                                    i7 = i20;
                                    i8 = iZzk;
                                    i12 = i99;
                                    unsafe = unsafe2;
                                    i10 = i97;
                                    i100 = i19;
                                    i14 = i22;
                                    obj3 = obj6;
                                    zzcuVar2 = zzcuVar3;
                                    i9 = i21;
                                }
                                break;
                            case 4:
                            case 11:
                                unsafe2 = unsafe7;
                                i21 = i103;
                                i22 = i101 == true ? 1 : 0;
                                i93 = 3;
                                i11 = -1;
                                i13 = 0;
                                zzcuVar3 = zzcuVar;
                                if (r9 == 0) {
                                    i25 = i19 | i16;
                                    int iZzj18 = zzcv.zzj(bArr2, iZzk, zzcuVar3);
                                    unsafe2.putInt(obj6, j, zzcuVar3.zza);
                                    i101 = i22 == true ? 1 : 0;
                                    zzcuVar8 = zzcuVar3;
                                    i95 = -1;
                                    i98 = i21;
                                    i96 = 1048575;
                                    iZzi = iZzj18;
                                    i94 = 0;
                                    int i1015 = i97;
                                    i100 = i25;
                                    unsafe7 = unsafe2;
                                    i97 = i1015;
                                } else {
                                    i20 = i93;
                                    i7 = i20;
                                    i8 = iZzk;
                                    i12 = i99;
                                    unsafe = unsafe2;
                                    i10 = i97;
                                    i100 = i19;
                                    i14 = i22;
                                    obj3 = obj6;
                                    zzcuVar2 = zzcuVar3;
                                    i9 = i21;
                                }
                                break;
                            case 5:
                            case 14:
                                unsafe2 = unsafe7;
                                i21 = i103;
                                i11 = -1;
                                zzcuVar3 = zzcuVar;
                                if (r9 == 1) {
                                    unsafe7 = unsafe2;
                                    unsafe7.putLong(obj, j, zzcv.zzq(bArr2, iZzk));
                                    zzcuVar8 = zzcuVar3;
                                    iZzi = iZzk + 8;
                                    i93 = 3;
                                    i100 = i19 | i16;
                                    i95 = -1;
                                    i94 = 0;
                                    i98 = i21;
                                    i96 = 1048575;
                                } else {
                                    i13 = 0;
                                    i20 = 3;
                                    i22 = i101 == true ? 1 : 0;
                                    i7 = i20;
                                    i8 = iZzk;
                                    i12 = i99;
                                    unsafe = unsafe2;
                                    i10 = i97;
                                    i100 = i19;
                                    i14 = i22;
                                    obj3 = obj6;
                                    zzcuVar2 = zzcuVar3;
                                    i9 = i21;
                                }
                                break;
                            case 6:
                            case 13:
                                unsafe2 = unsafe7;
                                i21 = i103;
                                i26 = 0;
                                i27 = 3;
                                i11 = -1;
                                zzcuVar3 = zzcuVar;
                                if (r9 == 5) {
                                    iZzh = iZzk + 4;
                                    i28 = i19 | i16;
                                    unsafe2.putInt(obj6, j, zzcv.zzc(bArr2, iZzk));
                                    i2 = i2;
                                    i94 = i26;
                                    i93 = i27;
                                    zzcuVar8 = zzcuVar3;
                                    i95 = i11;
                                    i98 = i21;
                                    i96 = 1048575;
                                    iZzi = iZzh;
                                    unsafe7 = unsafe2;
                                    i97 = i97;
                                    i100 = i28;
                                } else {
                                    i13 = i26;
                                    i20 = i27;
                                    i22 = i101 == true ? 1 : 0;
                                    i7 = i20;
                                    i8 = iZzk;
                                    i12 = i99;
                                    unsafe = unsafe2;
                                    i10 = i97;
                                    i100 = i19;
                                    i14 = i22;
                                    obj3 = obj6;
                                    zzcuVar2 = zzcuVar3;
                                    i9 = i21;
                                }
                                break;
                            case 7:
                                unsafe2 = unsafe7;
                                i21 = i103;
                                i26 = 0;
                                i27 = 3;
                                i11 = -1;
                                zzcuVar3 = zzcuVar;
                                if (r9 == 0) {
                                    i25 = i19 | i16;
                                    int iZzm6 = zzcv.zzm(bArr2, iZzk, zzcuVar3);
                                    if (zzcuVar3.zzb != 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    zzgz.zzm(obj6, j, z);
                                    i94 = 0;
                                    i93 = 3;
                                    zzcuVar8 = zzcuVar3;
                                    i95 = -1;
                                    i98 = i21;
                                    i96 = 1048575;
                                    iZzi = iZzm6;
                                    int i1016 = i97;
                                    i100 = i25;
                                    unsafe7 = unsafe2;
                                    i97 = i1016;
                                } else {
                                    i13 = i26;
                                    i20 = i27;
                                    i22 = i101 == true ? 1 : 0;
                                    i7 = i20;
                                    i8 = iZzk;
                                    i12 = i99;
                                    unsafe = unsafe2;
                                    i10 = i97;
                                    i100 = i19;
                                    i14 = i22;
                                    obj3 = obj6;
                                    zzcuVar2 = zzcuVar3;
                                    i9 = i21;
                                }
                                break;
                            case 8:
                                unsafe2 = unsafe7;
                                i21 = i103;
                                i22 = i101 == true ? 1 : 0;
                                i11 = -1;
                                zzcuVar3 = zzcuVar;
                                if (r9 == 2) {
                                    if ((i15 & 536870912) != 0) {
                                        iZzh = zzcv.zzj(bArr2, iZzk, zzcuVar3);
                                        i29 = zzcuVar3.zza;
                                        if (i29 >= 0) {
                                            throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                        }
                                        i30 = i19 | i16;
                                        if (i29 == 0) {
                                            zzcuVar3.zzc = "";
                                            i33 = i30;
                                            i101 = i22 == true ? 1 : 0;
                                            i26 = 0;
                                            i27 = 3;
                                        } else {
                                            length = bArr2.length;
                                            int i1017 = zzhe.$r8$clinit;
                                            if ((iZzh | i29 | ((length - iZzh) - i29)) >= 0) {
                                                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZzh), Integer.valueOf(i29)));
                                            }
                                            i31 = iZzh + i29;
                                            cArr = new char[i29];
                                            i32 = 0;
                                            while (iZzh < i31) {
                                                b3 = bArr2[iZzh];
                                                if (zzha.zzd(b3)) {
                                                    iZzh++;
                                                    cArr[i32] = (char) b3;
                                                    i32++;
                                                } else {
                                                    while (iZzh < i31) {
                                                        i34 = iZzh + 1;
                                                        b = bArr2[iZzh];
                                                        if (zzha.zzd(b)) {
                                                            cArr[i32] = (char) b;
                                                            i32++;
                                                            iZzh = i34;
                                                            while (iZzh < i31) {
                                                                b2 = bArr2[iZzh];
                                                                if (zzha.zzd(b2)) {
                                                                    iZzh++;
                                                                    cArr[i32] = (char) b2;
                                                                    i32++;
                                                                }
                                                            }
                                                        } else {
                                                            int i1018 = i30;
                                                            if (b < -32) {
                                                                r17 = i22 == true ? 1 : 0;
                                                                str2 = str;
                                                                if (b < -16) {
                                                                    if (i34 < i31 - 1) {
                                                                        throw new zzer(str2);
                                                                    }
                                                                    int i1019 = iZzh + 2;
                                                                    iZzh += 3;
                                                                    zzha.zzb(b, bArr2[i34], bArr2[i1019], cArr, i32);
                                                                    str = str2;
                                                                    i22 = r17 == true ? 1 : 0;
                                                                    i32++;
                                                                } else {
                                                                    if (i34 < i31 - 2) {
                                                                        throw new zzer(str2);
                                                                    }
                                                                    byte b8 = bArr2[i34];
                                                                    int i1110 = iZzh + 3;
                                                                    byte b9 = bArr2[iZzh + 2];
                                                                    iZzh += 4;
                                                                    zzha.zza(b, b8, b9, bArr2[i1110], cArr, i32);
                                                                    i32 += 2;
                                                                    str = str2;
                                                                    i22 = r17 == true ? 1 : 0;
                                                                }
                                                            } else {
                                                                if (i34 < i31) {
                                                                    throw new zzer(str);
                                                                }
                                                                iZzh += 2;
                                                                zzha.zzc(b, bArr2[i34], cArr, i32);
                                                                i32++;
                                                            }
                                                            i30 = i1018;
                                                        }
                                                    }
                                                    i33 = i30;
                                                    i101 = i22 == true ? 1 : 0;
                                                    i27 = 3;
                                                    i26 = 0;
                                                    zzcuVar3.zzc = new String(cArr, 0, i32);
                                                    iZzh = i31;
                                                }
                                            }
                                            while (iZzh < i31) {
                                                i34 = iZzh + 1;
                                                b = bArr2[iZzh];
                                                if (zzha.zzd(b)) {
                                                    cArr[i32] = (char) b;
                                                    i32++;
                                                    iZzh = i34;
                                                    while (iZzh < i31) {
                                                        b2 = bArr2[iZzh];
                                                        if (zzha.zzd(b2)) {
                                                            iZzh++;
                                                            cArr[i32] = (char) b2;
                                                            i32++;
                                                        }
                                                    }
                                                } else {
                                                    int i10110 = i30;
                                                    if (b < -32) {
                                                        r17 = i22 == true ? 1 : 0;
                                                        str2 = str;
                                                        if (b < -16) {
                                                            if (i34 < i31 - 1) {
                                                                throw new zzer(str2);
                                                            }
                                                            int i10111 = iZzh + 2;
                                                            iZzh += 3;
                                                            zzha.zzb(b, bArr2[i34], bArr2[i10111], cArr, i32);
                                                            str = str2;
                                                            i22 = r17 == true ? 1 : 0;
                                                            i32++;
                                                        } else {
                                                            if (i34 < i31 - 2) {
                                                                throw new zzer(str2);
                                                            }
                                                            byte b10 = bArr2[i34];
                                                            int i1111 = iZzh + 3;
                                                            byte b11 = bArr2[iZzh + 2];
                                                            iZzh += 4;
                                                            zzha.zza(b, b10, b11, bArr2[i1111], cArr, i32);
                                                            i32 += 2;
                                                            str = str2;
                                                            i22 = r17 == true ? 1 : 0;
                                                        }
                                                    } else {
                                                        if (i34 < i31) {
                                                            throw new zzer(str);
                                                        }
                                                        iZzh += 2;
                                                        zzha.zzc(b, bArr2[i34], cArr, i32);
                                                        i32++;
                                                    }
                                                    i30 = i10110;
                                                }
                                            }
                                            i33 = i30;
                                            i101 = i22 == true ? 1 : 0;
                                            i27 = 3;
                                            i26 = 0;
                                            zzcuVar3.zzc = new String(cArr, 0, i32);
                                            iZzh = i31;
                                        }
                                        i28 = i33;
                                    } else {
                                        i101 = i22 == true ? 1 : 0;
                                        i26 = 0;
                                        i27 = 3;
                                        i28 = i19 | i16;
                                        iZzh = zzcv.zzh(bArr2, iZzk, zzcuVar3);
                                    }
                                    unsafe2.putObject(obj6, j, zzcuVar3.zzc);
                                    i2 = i2;
                                    i94 = i26;
                                    i93 = i27;
                                    zzcuVar8 = zzcuVar3;
                                    i95 = i11;
                                    i98 = i21;
                                    i96 = 1048575;
                                    iZzi = iZzh;
                                    unsafe7 = unsafe2;
                                    i97 = i97;
                                    i100 = i28;
                                } else {
                                    i20 = 3;
                                    i13 = 0;
                                    i7 = i20;
                                    i8 = iZzk;
                                    i12 = i99;
                                    unsafe = unsafe2;
                                    i10 = i97;
                                    i100 = i19;
                                    i14 = i22;
                                    obj3 = obj6;
                                    zzcuVar2 = zzcuVar3;
                                    i9 = i21;
                                }
                                break;
                            case 9:
                                unsafe2 = unsafe7;
                                i35 = i103;
                                i36 = i99;
                                i37 = i101 == true ? 1 : 0;
                                r2 = true;
                                i11 = -1;
                                zzcuVar3 = zzcuVar;
                                if (r9 == 2) {
                                    int i1112 = i19 | i16;
                                    Object objZzx3 = zzfpVar3.zzx(obj6, i36);
                                    i99 = i36;
                                    i2 = i2;
                                    int iZzo2 = zzcv.zzo(objZzx3, zzfpVar3.zzv(i36), bArr, iZzk, i2, zzcuVar);
                                    zzfpVar3.zzF(obj6, i99, objZzx3);
                                    zzcuVar8 = zzcuVar3;
                                    i101 = i37 == true ? 1 : 0;
                                    i95 = -1;
                                    i93 = 3;
                                    i96 = 1048575;
                                    i94 = 0;
                                    iZzi = iZzo2;
                                    unsafe7 = unsafe2;
                                    i97 = i97;
                                    i100 = i1112;
                                    i98 = i35;
                                } else {
                                    i99 = i36;
                                    i21 = i35;
                                    i22 = i37;
                                    i13 = 0;
                                    i20 = 3;
                                    i7 = i20;
                                    i8 = iZzk;
                                    i12 = i99;
                                    unsafe = unsafe2;
                                    i10 = i97;
                                    i100 = i19;
                                    i14 = i22;
                                    obj3 = obj6;
                                    zzcuVar2 = zzcuVar3;
                                    i9 = i21;
                                }
                                break;
                            case 10:
                                unsafe2 = unsafe7;
                                i35 = i103;
                                i36 = i99;
                                i37 = i101 == true ? 1 : 0;
                                r2 = true;
                                i11 = -1;
                                zzcuVar3 = zzcuVar;
                                if (r9 == 2) {
                                    i25 = i19 | i16;
                                    int iZza3 = zzcv.zza(bArr2, iZzk, zzcuVar3);
                                    unsafe2.putObject(obj6, j, zzcuVar3.zzc);
                                    i99 = i36;
                                    i98 = i35;
                                    zzcuVar8 = zzcuVar3;
                                    i101 = i37 == true ? 1 : 0;
                                    i95 = -1;
                                    i93 = 3;
                                    i96 = 1048575;
                                    i94 = 0;
                                    iZzi = iZza3;
                                    int i10112 = i97;
                                    i100 = i25;
                                    unsafe7 = unsafe2;
                                    i97 = i10112;
                                } else {
                                    i99 = i36;
                                    i21 = i35;
                                    i22 = i37;
                                    i13 = 0;
                                    i20 = 3;
                                    i7 = i20;
                                    i8 = iZzk;
                                    i12 = i99;
                                    unsafe = unsafe2;
                                    i10 = i97;
                                    i100 = i19;
                                    i14 = i22;
                                    obj3 = obj6;
                                    zzcuVar2 = zzcuVar3;
                                    i9 = i21;
                                }
                                break;
                            case 12:
                                unsafe2 = unsafe7;
                                i38 = i103;
                                i39 = i99;
                                i40 = i101 == true ? 1 : 0;
                                i11 = -1;
                                zzcuVar3 = zzcuVar;
                                if (r9 == 0) {
                                    int iZzj19 = zzcv.zzj(bArr2, iZzk, zzcuVar3);
                                    i41 = zzcuVar3.zza;
                                    zzel zzelVarZzu4 = zzfpVar3.zzu(i39);
                                    if ((i15 & Integer.MIN_VALUE) != 0) {
                                        i42 = i40 == true ? 1 : 0;
                                        i19 |= i16;
                                        unsafe2.putInt(obj6, j, i41);
                                    } else {
                                        i42 = i40 == true ? 1 : 0;
                                        i19 |= i16;
                                        unsafe2.putInt(obj6, j, i41);
                                    }
                                    i99 = i39;
                                    i98 = i38;
                                    zzcuVar8 = zzcuVar3;
                                    i101 = i42;
                                    i95 = -1;
                                    i93 = 3;
                                    i96 = 1048575;
                                    i94 = 0;
                                    iZzi = iZzj19;
                                    unsafe7 = unsafe2;
                                    i97 = i97;
                                    i100 = i19;
                                    i2 = i2;
                                } else {
                                    i99 = i39;
                                    i21 = i38;
                                    i22 = i40;
                                    i20 = 3;
                                    i13 = 0;
                                    i7 = i20;
                                    i8 = iZzk;
                                    i12 = i99;
                                    unsafe = unsafe2;
                                    i10 = i97;
                                    i100 = i19;
                                    i14 = i22;
                                    obj3 = obj6;
                                    zzcuVar2 = zzcuVar3;
                                    i9 = i21;
                                }
                                break;
                            case 15:
                                unsafe2 = unsafe7;
                                i38 = i103;
                                i39 = i99;
                                i40 = i101 == true ? 1 : 0;
                                i11 = -1;
                                zzcuVar3 = zzcuVar;
                                if (r9 == 0) {
                                    i25 = i19 | i16;
                                    int iZzj110 = zzcv.zzj(bArr2, iZzk, zzcuVar3);
                                    unsafe2.putInt(obj6, j, zzdj.zzb(zzcuVar3.zza));
                                    i99 = i39;
                                    i98 = i38;
                                    zzcuVar8 = zzcuVar3;
                                    i95 = -1;
                                    i101 = i40 == true ? 1 : 0;
                                    i93 = 3;
                                    i96 = 1048575;
                                    iZzi = iZzj110;
                                    i94 = 0;
                                    int i10113 = i97;
                                    i100 = i25;
                                    unsafe7 = unsafe2;
                                    i97 = i10113;
                                } else {
                                    i99 = i39;
                                    i21 = i38;
                                    i22 = i40;
                                    i20 = 3;
                                    i13 = 0;
                                    i7 = i20;
                                    i8 = iZzk;
                                    i12 = i99;
                                    unsafe = unsafe2;
                                    i10 = i97;
                                    i100 = i19;
                                    i14 = i22;
                                    obj3 = obj6;
                                    zzcuVar2 = zzcuVar3;
                                    i9 = i21;
                                }
                                break;
                            case 16:
                                i43 = i99;
                                i11 = -1;
                                if (r9 == 0) {
                                    int i1113 = i19 | i16;
                                    int iZzm7 = zzcv.zzm(bArr2, iZzk, zzcuVar);
                                    unsafe7.putLong(obj, j, zzdj.zzc(zzcuVar.zzb));
                                    i2 = i2;
                                    zzcuVar8 = zzcuVar;
                                    i99 = i43;
                                    i97 = i97;
                                    i95 = -1;
                                    i101 = i101 == true ? 1 : 0;
                                    i93 = 3;
                                    i94 = 0;
                                    i100 = i1113;
                                    iZzi = iZzm7;
                                    i98 = i103;
                                    i96 = 1048575;
                                } else {
                                    unsafe2 = unsafe7;
                                    i21 = i103;
                                    zzcuVar3 = zzcuVar;
                                    i20 = 3;
                                    i99 = i43;
                                    i22 = i101 == true ? 1 : 0;
                                    i13 = 0;
                                    i7 = i20;
                                    i8 = iZzk;
                                    i12 = i99;
                                    unsafe = unsafe2;
                                    i10 = i97;
                                    i100 = i19;
                                    i14 = i22;
                                    obj3 = obj6;
                                    zzcuVar2 = zzcuVar3;
                                    i9 = i21;
                                }
                                break;
                            default:
                                i93 = 3;
                                if (r9 == 3) {
                                    int i1114 = i19 | i16;
                                    Object objZzx4 = zzfpVar3.zzx(obj6, i99);
                                    int i1115 = i99;
                                    iZzi = zzcv.zzn(objZzx4, zzfpVar3.zzv(i99), bArr, iZzk, i2, (i103 << 3) | 4, zzcuVar);
                                    zzfpVar3.zzF(obj6, i1115, objZzx4);
                                    i98 = i103;
                                    i2 = i2;
                                    i96 = 1048575;
                                    i99 = i1115;
                                    i97 = i97;
                                    i95 = -1;
                                    i94 = 0;
                                    zzcuVar8 = zzcuVar;
                                    i100 = i1114;
                                } else {
                                    i11 = -1;
                                    unsafe2 = unsafe7;
                                    i20 = 3;
                                    i21 = i103;
                                    i22 = i101 == true ? 1 : 0;
                                    i13 = 0;
                                    zzcuVar3 = zzcuVar;
                                    i7 = i20;
                                    i8 = iZzk;
                                    i12 = i99;
                                    unsafe = unsafe2;
                                    i10 = i97;
                                    i100 = i19;
                                    i14 = i22;
                                    obj3 = obj6;
                                    zzcuVar2 = zzcuVar3;
                                    i9 = i21;
                                }
                                break;
                        }
                    } else {
                        unsafe3 = unsafe7;
                        i44 = i103;
                        i45 = i97;
                        i14 = i101 == true ? 1 : 0;
                        i11 = -1;
                        i13 = 0;
                        if (iZzr == 27) {
                            i48 = i2;
                            i49 = i99;
                            i10 = i45;
                            if (iZzr <= 49) {
                                j2 = i15;
                                unsafe4 = zzb;
                                zzeoVar = (zzeo) unsafe4.getObject(obj6, j);
                                if (zzeoVar.zzc()) {
                                    int size4 = zzeoVar.size();
                                    zzeo zzeoVarZzd3 = zzeoVar.zzd(size4 != 0 ? size4 + size4 : 10);
                                    unsafe4.putObject(obj6, j, zzeoVarZzd3);
                                    zzeoVar2 = zzeoVarZzd3;
                                } else {
                                    zzeoVar2 = zzeoVar;
                                }
                                switch (iZzr) {
                                    case 18:
                                    case 35:
                                        i14 = i14 == true ? 1 : 0;
                                        i50 = i49;
                                        zzcuVar5 = zzcuVar;
                                        unsafe = unsafe3;
                                        i9 = i44;
                                        i51 = iZzk;
                                        if (r9 == 2) {
                                            int i1116 = zzcv.$r8$clinit;
                                            SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m377m(zzeoVar2);
                                            iZzj = zzcv.zzj(bArr2, i51, zzcuVar5);
                                            i52 = zzcuVar5.zza + iZzj;
                                            if (iZzj >= i52) {
                                                Double.longBitsToDouble(zzcv.zzq(bArr2, iZzj));
                                                throw null;
                                            }
                                            if (iZzj != i52) {
                                                throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            iZzl = iZzj;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                        } else {
                                            if (r9 == 1) {
                                                int i1117 = zzcv.$r8$clinit;
                                                SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m377m(zzeoVar2);
                                                Double.longBitsToDouble(zzcv.zzq(bArr2, i51));
                                                throw null;
                                            }
                                            iZzl = i51;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                        }
                                        break;
                                    case 19:
                                    case 36:
                                        i14 = i14 == true ? 1 : 0;
                                        i50 = i49;
                                        zzcuVar5 = zzcuVar;
                                        unsafe = unsafe3;
                                        i9 = i44;
                                        i51 = iZzk;
                                        if (r9 == 2) {
                                            if (r9 == 5) {
                                                i53 = i51 + 4;
                                                int i1118 = zzcv.$r8$clinit;
                                                zzdzVar = (zzdz) zzeoVar2;
                                                zzdzVar.zzh(Float.intBitsToFloat(zzcv.zzc(bArr2, i51)));
                                                while (i53 < i48) {
                                                    iZzj2 = zzcv.zzj(bArr2, i53, zzcuVar5);
                                                    if (i14 == zzcuVar5.zza) {
                                                        zzdzVar.zzh(Float.intBitsToFloat(zzcv.zzc(bArr2, iZzj2)));
                                                        i53 = iZzj2 + 4;
                                                    } else {
                                                        iZzl = i53;
                                                    }
                                                }
                                                iZzl = i53;
                                            }
                                            iZzl = i51;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                        } else {
                                            int i1119 = zzcv.$r8$clinit;
                                            zzdzVar2 = (zzdz) zzeoVar2;
                                            iZzj = zzcv.zzj(bArr2, i51, zzcuVar5);
                                            i54 = zzcuVar5.zza + iZzj;
                                            while (iZzj < i54) {
                                                zzdzVar2.zzh(Float.intBitsToFloat(zzcv.zzc(bArr2, iZzj)));
                                                iZzj += 4;
                                            }
                                            if (iZzj != i54) {
                                                throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            iZzl = iZzj;
                                        }
                                        if (iZzl != i51) {
                                            i98 = i9;
                                            zzcuVar8 = zzcuVar5;
                                            i2 = i48;
                                            i99 = i50;
                                            i101 = i14;
                                            i97 = i10;
                                            i95 = -1;
                                            i94 = 0;
                                            i93 = 3;
                                            i96 = 1048575;
                                            obj6 = obj;
                                            iZzi = iZzl;
                                            unsafe7 = unsafe;
                                        } else {
                                            obj3 = obj;
                                            i8 = iZzl;
                                            zzcuVar2 = zzcuVar5;
                                            i12 = i50;
                                            i14 = i14;
                                            i7 = 3;
                                        }
                                        break;
                                    case 20:
                                    case 21:
                                    case 37:
                                    case 38:
                                        i14 = i14 == true ? 1 : 0;
                                        i50 = i49;
                                        zzcuVar5 = zzcuVar;
                                        unsafe = unsafe3;
                                        i9 = i44;
                                        i51 = iZzk;
                                        if (r9 == 2) {
                                            int i1210 = zzcv.$r8$clinit;
                                            SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m377m(zzeoVar2);
                                            iZzj = zzcv.zzj(bArr2, i51, zzcuVar5);
                                            i55 = zzcuVar5.zza + iZzj;
                                            if (iZzj >= i55) {
                                                zzcv.zzm(bArr2, iZzj, zzcuVar5);
                                                throw null;
                                            }
                                            if (iZzj != i55) {
                                                throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            iZzl = iZzj;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                        } else {
                                            if (r9 == 0) {
                                                int i1211 = zzcv.$r8$clinit;
                                                SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m377m(zzeoVar2);
                                                zzcv.zzm(bArr2, i51, zzcuVar5);
                                                long j6 = zzcuVar5.zzb;
                                                throw null;
                                            }
                                            iZzl = i51;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                        }
                                        break;
                                    case 22:
                                    case 29:
                                    case 39:
                                    case 43:
                                        i56 = i49;
                                        i57 = i48;
                                        unsafe = unsafe3;
                                        i58 = i44;
                                        i51 = iZzk;
                                        zzcuVar6 = zzcuVar;
                                        if (r9 == 2) {
                                            if (r9 == 0) {
                                                i9 = i58;
                                                i48 = i57;
                                                zzcuVar5 = zzcuVar6;
                                                i50 = i56;
                                                i14 = i14 == true ? 1 : 0;
                                                iZzl = zzcv.zzl(i14 == true ? 1 : 0, bArr, i51, i2, zzeoVar2, zzcuVar);
                                            }
                                            i9 = i58;
                                            i48 = i57;
                                            zzcuVar5 = zzcuVar6;
                                            i50 = i56;
                                            i14 = i14 == true ? 1 : 0;
                                            iZzl = i51;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                        } else {
                                            iZzl = zzcv.zzg(bArr2, i51, zzeoVar2, zzcuVar6);
                                            i9 = i58;
                                            i48 = i57;
                                            zzcuVar5 = zzcuVar6;
                                            i50 = i56;
                                            i14 = i14 == true ? 1 : 0;
                                        }
                                        if (iZzl != i51) {
                                            i98 = i9;
                                            zzcuVar8 = zzcuVar5;
                                            i2 = i48;
                                            i99 = i50;
                                            i101 = i14;
                                            i97 = i10;
                                            i95 = -1;
                                            i94 = 0;
                                            i93 = 3;
                                            i96 = 1048575;
                                            obj6 = obj;
                                            iZzi = iZzl;
                                            unsafe7 = unsafe;
                                        } else {
                                            obj3 = obj;
                                            i8 = iZzl;
                                            zzcuVar2 = zzcuVar5;
                                            i12 = i50;
                                            i14 = i14;
                                            i7 = 3;
                                        }
                                        break;
                                    case 23:
                                    case 32:
                                    case 40:
                                    case 46:
                                        i56 = i49;
                                        i57 = i48;
                                        unsafe = unsafe3;
                                        i58 = i44;
                                        i51 = iZzk;
                                        zzcuVar6 = zzcuVar;
                                        if (r9 == 2) {
                                            if (r9 != 1) {
                                                int i1212 = zzcv.$r8$clinit;
                                                SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m377m(zzeoVar2);
                                                zzcv.zzq(bArr2, i51);
                                                throw null;
                                            }
                                            i9 = i58;
                                            i48 = i57;
                                            zzcuVar5 = zzcuVar6;
                                            i50 = i56;
                                            i14 = i14 == true ? 1 : 0;
                                            iZzl = i51;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                        } else {
                                            int i1213 = zzcv.$r8$clinit;
                                            SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m377m(zzeoVar2);
                                            iZzj3 = zzcv.zzj(bArr2, i51, zzcuVar6);
                                            i59 = zzcuVar6.zza + iZzj3;
                                            if (iZzj3 >= i59) {
                                                zzcv.zzq(bArr2, iZzj3);
                                                throw null;
                                            }
                                            if (iZzj3 != i59) {
                                                throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            i48 = i57;
                                            zzcuVar5 = zzcuVar6;
                                            i50 = i56;
                                            i14 = i14 == true ? 1 : 0;
                                            iZzl = iZzj3;
                                            i9 = i58;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                        }
                                        break;
                                    case 24:
                                    case 31:
                                    case 41:
                                    case 45:
                                        i56 = i49;
                                        i57 = i48;
                                        unsafe = unsafe3;
                                        i58 = i44;
                                        i51 = iZzk;
                                        zzcuVar6 = zzcuVar;
                                        if (r9 == 2) {
                                            if (r9 == 5) {
                                                iZzl = i51 + 4;
                                                int i1214 = zzcv.$r8$clinit;
                                                zzeiVar = (zzei) zzeoVar2;
                                                zzeiVar.zzg(zzcv.zzc(bArr2, i51));
                                                while (iZzl < i57) {
                                                    iZzj4 = zzcv.zzj(bArr2, iZzl, zzcuVar6);
                                                    if (i14 == zzcuVar6.zza) {
                                                        i9 = i58;
                                                        i48 = i57;
                                                        zzcuVar5 = zzcuVar6;
                                                        i50 = i56;
                                                        i14 = i14 == true ? 1 : 0;
                                                        if (iZzl != i51) {
                                                            i98 = i9;
                                                            zzcuVar8 = zzcuVar5;
                                                            i2 = i48;
                                                            i99 = i50;
                                                            i101 = i14;
                                                            i97 = i10;
                                                            i95 = -1;
                                                            i94 = 0;
                                                            i93 = 3;
                                                            i96 = 1048575;
                                                            obj6 = obj;
                                                            iZzi = iZzl;
                                                            unsafe7 = unsafe;
                                                        } else {
                                                            obj3 = obj;
                                                            i8 = iZzl;
                                                            zzcuVar2 = zzcuVar5;
                                                            i12 = i50;
                                                            i14 = i14;
                                                            i7 = 3;
                                                        }
                                                    } else {
                                                        zzeiVar.zzg(zzcv.zzc(bArr2, iZzj4));
                                                        iZzl = iZzj4 + 4;
                                                    }
                                                    break;
                                                }
                                                i9 = i58;
                                                i48 = i57;
                                                zzcuVar5 = zzcuVar6;
                                                i50 = i56;
                                                i14 = i14 == true ? 1 : 0;
                                                if (iZzl != i51) {
                                                    i98 = i9;
                                                    zzcuVar8 = zzcuVar5;
                                                    i2 = i48;
                                                    i99 = i50;
                                                    i101 = i14;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i94 = 0;
                                                    i93 = 3;
                                                    i96 = 1048575;
                                                    obj6 = obj;
                                                    iZzi = iZzl;
                                                    unsafe7 = unsafe;
                                                } else {
                                                    obj3 = obj;
                                                    i8 = iZzl;
                                                    zzcuVar2 = zzcuVar5;
                                                    i12 = i50;
                                                    i14 = i14;
                                                    i7 = 3;
                                                }
                                            }
                                            i9 = i58;
                                            i48 = i57;
                                            zzcuVar5 = zzcuVar6;
                                            i50 = i56;
                                            i14 = i14 == true ? 1 : 0;
                                            iZzl = i51;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                            break;
                                        } else {
                                            int i1215 = zzcv.$r8$clinit;
                                            zzeiVar2 = (zzei) zzeoVar2;
                                            iZzj3 = zzcv.zzj(bArr2, i51, zzcuVar6);
                                            i60 = zzcuVar6.zza + iZzj3;
                                            while (iZzj3 < i60) {
                                                zzeiVar2.zzg(zzcv.zzc(bArr2, iZzj3));
                                                iZzj3 += 4;
                                            }
                                            if (iZzj3 != i60) {
                                                throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            i48 = i57;
                                            zzcuVar5 = zzcuVar6;
                                            i50 = i56;
                                            i14 = i14 == true ? 1 : 0;
                                            iZzl = iZzj3;
                                            i9 = i58;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                        }
                                        break;
                                    case 25:
                                    case 42:
                                        i56 = i49;
                                        i57 = i48;
                                        unsafe = unsafe3;
                                        i58 = i44;
                                        i51 = iZzk;
                                        zzcuVar6 = zzcuVar;
                                        if (r9 == 2) {
                                            int i1216 = zzcv.$r8$clinit;
                                            SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m377m(zzeoVar2);
                                            iZzj3 = zzcv.zzj(bArr2, i51, zzcuVar6);
                                            i61 = zzcuVar6.zza + iZzj3;
                                            if (iZzj3 >= i61) {
                                                zzcv.zzm(bArr2, iZzj3, zzcuVar6);
                                                throw null;
                                            }
                                            if (iZzj3 != i61) {
                                                throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            i48 = i57;
                                            zzcuVar5 = zzcuVar6;
                                            i50 = i56;
                                            i14 = i14 == true ? 1 : 0;
                                            iZzl = iZzj3;
                                            i9 = i58;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                        } else {
                                            if (r9 == 0) {
                                                int i1217 = zzcv.$r8$clinit;
                                                SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m377m(zzeoVar2);
                                                zzcv.zzm(bArr2, i51, zzcuVar6);
                                                long j7 = zzcuVar6.zzb;
                                                throw null;
                                            }
                                            i9 = i58;
                                            i48 = i57;
                                            zzcuVar5 = zzcuVar6;
                                            i50 = i56;
                                            i14 = i14 == true ? 1 : 0;
                                            iZzl = i51;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                        }
                                        break;
                                    case 26:
                                        i62 = iZzk;
                                        zzcuVar7 = zzcuVar;
                                        unsafe = unsafe3;
                                        if (r9 == 2) {
                                            if ((j2 & 536870912) == 0) {
                                                i51 = i62;
                                                iZzj5 = zzcv.zzj(bArr2, i51, zzcuVar7);
                                                i67 = zzcuVar7.zza;
                                                if (i67 >= 0) {
                                                    throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i67 == 0) {
                                                    r12 = "";
                                                    zzeoVar2.add(r12);
                                                } else {
                                                    r12 = "";
                                                    zzeoVar2.add(new String(bArr2, iZzj5, i67, zzep.zza));
                                                    iZzj5 += i67;
                                                }
                                                while (iZzj5 < i48) {
                                                    iZzj7 = zzcv.zzj(bArr2, iZzj5, zzcuVar7);
                                                    if (i14 == zzcuVar7.zza) {
                                                        iZzj5 = zzcv.zzj(bArr2, iZzj7, zzcuVar7);
                                                        i68 = zzcuVar7.zza;
                                                        if (i68 >= 0) {
                                                            throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i68 == 0) {
                                                            zzeoVar2.add(r12);
                                                        } else {
                                                            zzeoVar2.add(new String(bArr2, iZzj5, i68, zzep.zza));
                                                            iZzj5 += i68;
                                                        }
                                                    }
                                                }
                                            } else {
                                                i51 = i62;
                                                iZzj5 = zzcv.zzj(bArr2, i51, zzcuVar7);
                                                i63 = zzcuVar7.zza;
                                                if (i63 >= 0) {
                                                    throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i63 == 0) {
                                                    zzeoVar2.add("");
                                                } else {
                                                    i64 = iZzj5 + i63;
                                                    if (zzhe.zzg(bArr2, iZzj5, i64)) {
                                                        throw new zzer(str);
                                                    }
                                                    zzeoVar2.add(new String(bArr2, iZzj5, i63, zzep.zza));
                                                    iZzj5 = i64;
                                                }
                                                while (iZzj5 < i48) {
                                                    iZzj6 = zzcv.zzj(bArr2, iZzj5, zzcuVar7);
                                                    if (i14 == zzcuVar7.zza) {
                                                        iZzj5 = zzcv.zzj(bArr2, iZzj6, zzcuVar7);
                                                        i65 = zzcuVar7.zza;
                                                        if (i65 >= 0) {
                                                            throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i65 == 0) {
                                                            zzeoVar2.add("");
                                                        } else {
                                                            i66 = iZzj5 + i65;
                                                            if (zzhe.zzg(bArr2, iZzj5, i66)) {
                                                                throw new zzer(str);
                                                            }
                                                            zzeoVar2.add(new String(bArr2, iZzj5, i65, zzep.zza));
                                                            iZzj5 = i66;
                                                        }
                                                    }
                                                }
                                            }
                                            i9 = i44;
                                            i48 = i48;
                                            i50 = i49;
                                            iZzl = iZzj5;
                                            zzcuVar5 = zzcuVar7;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                        } else {
                                            i51 = i62;
                                            i9 = i44;
                                            zzcuVar5 = zzcuVar7;
                                            i50 = i49;
                                            i14 = i14 == true ? 1 : 0;
                                            i48 = i48;
                                            iZzl = i51;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                        }
                                        break;
                                    case 27:
                                        i69 = iZzk;
                                        if (r9 == 2) {
                                            zzcuVar7 = zzcuVar;
                                            unsafe = unsafe3;
                                            i9 = i44;
                                            i48 = i48;
                                            i50 = i49;
                                            i51 = i69;
                                            iZzl = zzcv.zzf(zzfpVar3.zzv(i49), i14 == true ? 1 : 0, bArr, i69, i2, zzeoVar2, zzcuVar);
                                            zzcuVar5 = zzcuVar7;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                        } else {
                                            unsafe = unsafe3;
                                            i9 = i44;
                                            i50 = i49;
                                            zzcuVar5 = zzcuVar;
                                            i51 = i69;
                                            i14 = i14 == true ? 1 : 0;
                                            iZzl = i51;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                        }
                                        break;
                                    case 28:
                                        i70 = iZzk;
                                        i71 = i14 == true ? 1 : 0;
                                        if (r9 == 2) {
                                            iZzj8 = zzcv.zzj(bArr2, i70, zzcuVar);
                                            i72 = zzcuVar.zza;
                                            if (i72 >= 0) {
                                                throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            if (i72 <= bArr2.length - iZzj8) {
                                                throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            if (i72 == 0) {
                                                zzeoVar2.add(zzdf.zzb);
                                            } else {
                                                zzeoVar2.add(zzdf.zzr(bArr2, iZzj8, i72));
                                                iZzj8 += i72;
                                            }
                                            while (true) {
                                                if (iZzj8 < i48) {
                                                    iZzj9 = zzcv.zzj(bArr2, iZzj8, zzcuVar);
                                                    i73 = i71;
                                                    if (i73 == zzcuVar.zza) {
                                                        iZzj8 = zzcv.zzj(bArr2, iZzj9, zzcuVar);
                                                        i74 = zzcuVar.zza;
                                                        if (i74 >= 0) {
                                                            throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i74 <= bArr2.length - iZzj8) {
                                                            throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                        if (i74 == 0) {
                                                            zzeoVar2.add(zzdf.zzb);
                                                        } else {
                                                            zzeoVar2.add(zzdf.zzr(bArr2, iZzj8, i74));
                                                            iZzj8 += i74;
                                                        }
                                                        i71 = i73 == true ? 1 : 0;
                                                    }
                                                } else {
                                                    i73 = i71;
                                                }
                                            }
                                            iZzl = iZzj8;
                                            i9 = i44;
                                            unsafe = unsafe3;
                                            i50 = i49;
                                            zzcuVar5 = zzcuVar;
                                            i51 = i70;
                                            i14 = i73;
                                        } else {
                                            i9 = i44;
                                            unsafe = unsafe3;
                                            i50 = i49;
                                            zzcuVar5 = zzcuVar;
                                            i51 = i70;
                                            i14 = i71 == true ? 1 : 0;
                                            iZzl = i51;
                                        }
                                        if (iZzl != i51) {
                                            i98 = i9;
                                            zzcuVar8 = zzcuVar5;
                                            i2 = i48;
                                            i99 = i50;
                                            i101 = i14;
                                            i97 = i10;
                                            i95 = -1;
                                            i94 = 0;
                                            i93 = 3;
                                            i96 = 1048575;
                                            obj6 = obj;
                                            iZzi = iZzl;
                                            unsafe7 = unsafe;
                                        } else {
                                            obj3 = obj;
                                            i8 = iZzl;
                                            zzcuVar2 = zzcuVar5;
                                            i12 = i50;
                                            i14 = i14;
                                            i7 = 3;
                                        }
                                        break;
                                    case 30:
                                    case 44:
                                        i75 = iZzk;
                                        i76 = i14 == true ? 1 : 0;
                                        if (r9 == 2) {
                                            iZzl2 = zzcv.zzg(bArr2, i75, zzeoVar2, zzcuVar);
                                        } else if (r9 == 0) {
                                            i50 = i49;
                                            zzcuVar5 = zzcuVar;
                                            i51 = i75;
                                            unsafe = unsafe3;
                                            i9 = i44;
                                            i14 = i76 == true ? 1 : 0;
                                            iZzl = i51;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                        } else {
                                            iZzl2 = zzcv.zzl(i76 == true ? 1 : 0, bArr, i75, i2, zzeoVar2, zzcuVar);
                                        }
                                        zzelVarZzu = zzfpVar3.zzu(i49);
                                        zzgsVar2 = zzfpVar3.zzl;
                                        int i1218 = zzgg.$r8$clinit;
                                        if (zzelVarZzu != null) {
                                            i77 = iZzl2;
                                            i78 = i76 == true ? 1 : 0;
                                            i79 = i44;
                                            z2 = true;
                                        } else if (zzeoVar2 != null) {
                                            size = zzeoVar2.size();
                                            objZzn2 = null;
                                            i80 = 0;
                                            i81 = 0;
                                            while (i80 < size) {
                                                num = (Integer) zzeoVar2.get(i80);
                                                int i1219 = iZzl2;
                                                iIntValue2 = num.intValue();
                                                if (zzelVarZzu.zza(iIntValue2)) {
                                                    if (i80 != i81) {
                                                        zzeoVar2.set(i81, num);
                                                    }
                                                    i81++;
                                                    i82 = i44;
                                                } else {
                                                    i82 = i44;
                                                    objZzn2 = zzgg.zzn(obj, i82, iIntValue2, objZzn2, zzgsVar2);
                                                }
                                                i80++;
                                                iZzl2 = i1219;
                                                i44 = i82;
                                                i76 = i76;
                                            }
                                            i77 = iZzl2;
                                            i78 = i76;
                                            i79 = i44;
                                            z2 = true;
                                            if (i81 != size) {
                                                zzeoVar2.subList(i81, size).clear();
                                            }
                                        } else {
                                            i77 = iZzl2;
                                            i78 = i76 == true ? 1 : 0;
                                            i79 = i44;
                                            z2 = true;
                                            it = zzeoVar2.iterator();
                                            objZzn = null;
                                            while (it.hasNext()) {
                                                iIntValue = ((Integer) it.next()).intValue();
                                                if (!zzelVarZzu.zza(iIntValue)) {
                                                    objZzn = zzgg.zzn(obj, i79, iIntValue, objZzn, zzgsVar2);
                                                    it.remove();
                                                }
                                            }
                                        }
                                        iZzl = i77;
                                        i9 = i79;
                                        unsafe = unsafe3;
                                        i50 = i49;
                                        zzcuVar5 = zzcuVar;
                                        i51 = i75;
                                        i14 = i78;
                                        if (iZzl != i51) {
                                            i98 = i9;
                                            zzcuVar8 = zzcuVar5;
                                            i2 = i48;
                                            i99 = i50;
                                            i101 = i14;
                                            i97 = i10;
                                            i95 = -1;
                                            i94 = 0;
                                            i93 = 3;
                                            i96 = 1048575;
                                            obj6 = obj;
                                            iZzi = iZzl;
                                            unsafe7 = unsafe;
                                        } else {
                                            obj3 = obj;
                                            i8 = iZzl;
                                            zzcuVar2 = zzcuVar5;
                                            i12 = i50;
                                            i14 = i14;
                                            i7 = 3;
                                        }
                                        break;
                                    case 33:
                                    case 47:
                                        i83 = iZzk;
                                        i84 = i14 == true ? 1 : 0;
                                        if (r9 == 2) {
                                            if (r9 == 0) {
                                                int i138 = zzcv.$r8$clinit;
                                                zzeiVar3 = (zzei) zzeoVar2;
                                                iZzl = zzcv.zzj(bArr2, i83, zzcuVar);
                                                zzeiVar3.zzg(zzdj.zzb(zzcuVar.zza));
                                                while (iZzl < i48) {
                                                    iZzj10 = zzcv.zzj(bArr2, iZzl, zzcuVar);
                                                    if (i84 == zzcuVar.zza) {
                                                        iZzl = zzcv.zzj(bArr2, iZzj10, zzcuVar);
                                                        zzeiVar3.zzg(zzdj.zzb(zzcuVar.zza));
                                                    }
                                                }
                                            }
                                            i50 = i49;
                                            zzcuVar5 = zzcuVar;
                                            i51 = i83;
                                            unsafe = unsafe3;
                                            i14 = i84;
                                            i9 = i44;
                                            iZzl = i51;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                        } else {
                                            int i139 = zzcv.$r8$clinit;
                                            zzeiVar4 = (zzei) zzeoVar2;
                                            iZzj11 = zzcv.zzj(bArr2, i83, zzcuVar);
                                            i85 = zzcuVar.zza + iZzj11;
                                            while (iZzj11 < i85) {
                                                iZzj11 = zzcv.zzj(bArr2, iZzj11, zzcuVar);
                                                zzeiVar4.zzg(zzdj.zzb(zzcuVar.zza));
                                            }
                                            if (iZzj11 != i85) {
                                                throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            iZzl = iZzj11;
                                        }
                                        i50 = i49;
                                        zzcuVar5 = zzcuVar;
                                        i51 = i83;
                                        unsafe = unsafe3;
                                        i14 = i84;
                                        i9 = i44;
                                        if (iZzl != i51) {
                                            i98 = i9;
                                            zzcuVar8 = zzcuVar5;
                                            i2 = i48;
                                            i99 = i50;
                                            i101 = i14;
                                            i97 = i10;
                                            i95 = -1;
                                            i94 = 0;
                                            i93 = 3;
                                            i96 = 1048575;
                                            obj6 = obj;
                                            iZzi = iZzl;
                                            unsafe7 = unsafe;
                                        } else {
                                            obj3 = obj;
                                            i8 = iZzl;
                                            zzcuVar2 = zzcuVar5;
                                            i12 = i50;
                                            i14 = i14;
                                            i7 = 3;
                                        }
                                        break;
                                    case 34:
                                    case 48:
                                        i83 = iZzk;
                                        i84 = i14 == true ? 1 : 0;
                                        if (r9 == 2) {
                                            int i1310 = zzcv.$r8$clinit;
                                            SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m377m(zzeoVar2);
                                            iZzj11 = zzcv.zzj(bArr2, i83, zzcuVar);
                                            i86 = zzcuVar.zza + iZzj11;
                                            if (iZzj11 >= i86) {
                                                zzcv.zzm(bArr2, iZzj11, zzcuVar);
                                                zzdj.zzc(zzcuVar.zzb);
                                                throw null;
                                            }
                                            if (iZzj11 != i86) {
                                                throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            iZzl = iZzj11;
                                            i50 = i49;
                                            zzcuVar5 = zzcuVar;
                                            i51 = i83;
                                            unsafe = unsafe3;
                                            i14 = i84;
                                            i9 = i44;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                        } else {
                                            if (r9 == 0) {
                                                int i1311 = zzcv.$r8$clinit;
                                                SlidingPaneLayout$$ExternalSyntheticThrowCCEIfNotNull0.m377m(zzeoVar2);
                                                zzcv.zzm(bArr2, i83, zzcuVar);
                                                zzdj.zzc(zzcuVar.zzb);
                                                throw null;
                                            }
                                            i50 = i49;
                                            zzcuVar5 = zzcuVar;
                                            i51 = i83;
                                            unsafe = unsafe3;
                                            i14 = i84;
                                            i9 = i44;
                                            iZzl = i51;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                        }
                                        break;
                                    default:
                                        if (r9 == 3) {
                                            i87 = ((i14 == true ? 1 : 0) & (-8)) | 4;
                                            zzgeVarZzv = zzfpVar3.zzv(i49);
                                            i83 = iZzk;
                                            i84 = i14 == true ? 1 : 0;
                                            iZzl = zzcv.zzd(zzgeVarZzv, bArr, iZzk, i2, i87, zzcuVar);
                                            zzeoVar2.add(zzcuVar.zzc);
                                            while (iZzl < i48) {
                                                iZzj12 = zzcv.zzj(bArr2, iZzl, zzcuVar);
                                                if (i84 == zzcuVar.zza) {
                                                    i50 = i49;
                                                    zzcuVar5 = zzcuVar;
                                                    i51 = i83;
                                                    unsafe = unsafe3;
                                                    i14 = i84;
                                                    i9 = i44;
                                                    if (iZzl != i51) {
                                                        i98 = i9;
                                                        zzcuVar8 = zzcuVar5;
                                                        i2 = i48;
                                                        i99 = i50;
                                                        i101 = i14;
                                                        i97 = i10;
                                                        i95 = -1;
                                                        i94 = 0;
                                                        i93 = 3;
                                                        i96 = 1048575;
                                                        obj6 = obj;
                                                        iZzi = iZzl;
                                                        unsafe7 = unsafe;
                                                    } else {
                                                        obj3 = obj;
                                                        i8 = iZzl;
                                                        zzcuVar2 = zzcuVar5;
                                                        i12 = i50;
                                                        i14 = i14;
                                                        i7 = 3;
                                                    }
                                                } else {
                                                    iZzl = zzcv.zzd(zzgeVarZzv, bArr, iZzj12, i2, i87, zzcuVar);
                                                    zzeoVar2.add(zzcuVar.zzc);
                                                }
                                                break;
                                            }
                                            i50 = i49;
                                            zzcuVar5 = zzcuVar;
                                            i51 = i83;
                                            unsafe = unsafe3;
                                            i14 = i84;
                                            i9 = i44;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                        } else {
                                            i14 = i14 == true ? 1 : 0;
                                            i50 = i49;
                                            zzcuVar5 = zzcuVar;
                                            unsafe = unsafe3;
                                            i9 = i44;
                                            i51 = iZzk;
                                            iZzl = i51;
                                            if (iZzl != i51) {
                                                i98 = i9;
                                                zzcuVar8 = zzcuVar5;
                                                i2 = i48;
                                                i99 = i50;
                                                i101 = i14;
                                                i97 = i10;
                                                i95 = -1;
                                                i94 = 0;
                                                i93 = 3;
                                                i96 = 1048575;
                                                obj6 = obj;
                                                iZzi = iZzl;
                                                unsafe7 = unsafe;
                                            } else {
                                                obj3 = obj;
                                                i8 = iZzl;
                                                zzcuVar2 = zzcuVar5;
                                                i12 = i50;
                                                i14 = i14;
                                                i7 = 3;
                                            }
                                        }
                                        break;
                                }
                            } else {
                                unsafe = unsafe3;
                                i9 = i44;
                                i47 = iZzk;
                                i46 = i49;
                                zzcuVar4 = zzcuVar;
                                if (iZzr == 50) {
                                    unsafe6 = zzb;
                                    j3 = iArr[i46 + 2] & 1048575;
                                    switch (iZzr) {
                                        case 51:
                                            i46 = i46;
                                            i14 = i14 == true ? 1 : 0;
                                            i47 = i47;
                                            i7 = 3;
                                            obj3 = obj;
                                            zzcuVar2 = zzcuVar;
                                            if (r9 == 1) {
                                                i88 = i47 + 8;
                                                unsafe6.putObject(obj3, j, Double.valueOf(Double.longBitsToDouble(zzcv.zzq(bArr2, i47))));
                                                unsafe6.putInt(obj3, j3, i9);
                                                iZzj13 = i88;
                                            } else {
                                                iZzj13 = i47;
                                            }
                                            if (iZzj13 != i47) {
                                                zzfpVar3 = this;
                                                i2 = i2;
                                                iZzi = iZzj13;
                                                i98 = i9;
                                                i101 = i14 == true ? 1 : 0;
                                                i97 = i10;
                                                i95 = -1;
                                                i93 = i7;
                                                i94 = 0;
                                                unsafe7 = unsafe;
                                                i96 = 1048575;
                                                obj6 = obj3;
                                                zzcuVar8 = zzcuVar2;
                                                i99 = i46;
                                            } else {
                                                i12 = i46;
                                                i8 = iZzj13;
                                            }
                                            break;
                                        case 52:
                                            i46 = i46;
                                            i14 = i14 == true ? 1 : 0;
                                            i47 = i47;
                                            i7 = 3;
                                            obj3 = obj;
                                            zzcuVar2 = zzcuVar;
                                            if (r9 == 5) {
                                                i88 = i47 + 4;
                                                unsafe6.putObject(obj3, j, Float.valueOf(Float.intBitsToFloat(zzcv.zzc(bArr2, i47))));
                                                unsafe6.putInt(obj3, j3, i9);
                                                iZzj13 = i88;
                                            } else {
                                                iZzj13 = i47;
                                            }
                                            if (iZzj13 != i47) {
                                                zzfpVar3 = this;
                                                i2 = i2;
                                                iZzi = iZzj13;
                                                i98 = i9;
                                                i101 = i14 == true ? 1 : 0;
                                                i97 = i10;
                                                i95 = -1;
                                                i93 = i7;
                                                i94 = 0;
                                                unsafe7 = unsafe;
                                                i96 = 1048575;
                                                obj6 = obj3;
                                                zzcuVar8 = zzcuVar2;
                                                i99 = i46;
                                            } else {
                                                i12 = i46;
                                                i8 = iZzj13;
                                            }
                                            break;
                                        case EACTags.SEX /* 53 */:
                                        case EACTags.CURRENCY_EXPONENT /* 54 */:
                                            i46 = i46;
                                            i14 = i14 == true ? 1 : 0;
                                            i47 = i47;
                                            i7 = 3;
                                            obj3 = obj;
                                            zzcuVar2 = zzcuVar;
                                            if (r9 == 0) {
                                                iZzm = zzcv.zzm(bArr2, i47, zzcuVar2);
                                                unsafe6.putObject(obj3, j, Long.valueOf(zzcuVar2.zzb));
                                                unsafe6.putInt(obj3, j3, i9);
                                                iZzj13 = iZzm;
                                            } else {
                                                iZzj13 = i47;
                                            }
                                            if (iZzj13 != i47) {
                                                zzfpVar3 = this;
                                                i2 = i2;
                                                iZzi = iZzj13;
                                                i98 = i9;
                                                i101 = i14 == true ? 1 : 0;
                                                i97 = i10;
                                                i95 = -1;
                                                i93 = i7;
                                                i94 = 0;
                                                unsafe7 = unsafe;
                                                i96 = 1048575;
                                                obj6 = obj3;
                                                zzcuVar8 = zzcuVar2;
                                                i99 = i46;
                                            } else {
                                                i12 = i46;
                                                i8 = iZzj13;
                                            }
                                            break;
                                        case 55:
                                        case PacketTags.EXPERIMENTAL_3 /* 62 */:
                                            i46 = i46;
                                            i14 = i14 == true ? 1 : 0;
                                            i47 = i47;
                                            i7 = 3;
                                            obj3 = obj;
                                            zzcuVar2 = zzcuVar;
                                            if (r9 == 0) {
                                                iZzj13 = zzcv.zzj(bArr2, i47, zzcuVar2);
                                                unsafe6.putObject(obj3, j, Integer.valueOf(zzcuVar2.zza));
                                                unsafe6.putInt(obj3, j3, i9);
                                            } else {
                                                iZzj13 = i47;
                                            }
                                            if (iZzj13 != i47) {
                                                zzfpVar3 = this;
                                                i2 = i2;
                                                iZzi = iZzj13;
                                                i98 = i9;
                                                i101 = i14 == true ? 1 : 0;
                                                i97 = i10;
                                                i95 = -1;
                                                i93 = i7;
                                                i94 = 0;
                                                unsafe7 = unsafe;
                                                i96 = 1048575;
                                                obj6 = obj3;
                                                zzcuVar8 = zzcuVar2;
                                                i99 = i46;
                                            } else {
                                                i12 = i46;
                                                i8 = iZzj13;
                                            }
                                            break;
                                        case 56:
                                        case EACTags.ELEMENT_LIST /* 65 */:
                                            i46 = i46;
                                            i14 = i14 == true ? 1 : 0;
                                            i47 = i47;
                                            i7 = 3;
                                            obj3 = obj;
                                            zzcuVar2 = zzcuVar;
                                            if (r9 == 1) {
                                                iZzj13 = i47 + 8;
                                                unsafe6.putObject(obj3, j, Long.valueOf(zzcv.zzq(bArr2, i47)));
                                                unsafe6.putInt(obj3, j3, i9);
                                            } else {
                                                iZzj13 = i47;
                                            }
                                            if (iZzj13 != i47) {
                                                zzfpVar3 = this;
                                                i2 = i2;
                                                iZzi = iZzj13;
                                                i98 = i9;
                                                i101 = i14 == true ? 1 : 0;
                                                i97 = i10;
                                                i95 = -1;
                                                i93 = i7;
                                                i94 = 0;
                                                unsafe7 = unsafe;
                                                i96 = 1048575;
                                                obj6 = obj3;
                                                zzcuVar8 = zzcuVar2;
                                                i99 = i46;
                                            } else {
                                                i12 = i46;
                                                i8 = iZzj13;
                                            }
                                            break;
                                        case 57:
                                        case 64:
                                            i46 = i46;
                                            i14 = i14 == true ? 1 : 0;
                                            i47 = i47;
                                            i7 = 3;
                                            obj3 = obj;
                                            zzcuVar2 = zzcuVar;
                                            if (r9 == 5) {
                                                i88 = i47 + 4;
                                                unsafe6.putObject(obj3, j, Integer.valueOf(zzcv.zzc(bArr2, i47)));
                                                unsafe6.putInt(obj3, j3, i9);
                                                iZzj13 = i88;
                                            } else {
                                                iZzj13 = i47;
                                            }
                                            if (iZzj13 != i47) {
                                                zzfpVar3 = this;
                                                i2 = i2;
                                                iZzi = iZzj13;
                                                i98 = i9;
                                                i101 = i14 == true ? 1 : 0;
                                                i97 = i10;
                                                i95 = -1;
                                                i93 = i7;
                                                i94 = 0;
                                                unsafe7 = unsafe;
                                                i96 = 1048575;
                                                obj6 = obj3;
                                                zzcuVar8 = zzcuVar2;
                                                i99 = i46;
                                            } else {
                                                i12 = i46;
                                                i8 = iZzj13;
                                            }
                                            break;
                                        case 58:
                                            i46 = i46;
                                            i14 = i14 == true ? 1 : 0;
                                            i47 = i47;
                                            i7 = 3;
                                            obj3 = obj;
                                            zzcuVar2 = zzcuVar;
                                            if (r9 == 0) {
                                                iZzm = zzcv.zzm(bArr2, i47, zzcuVar2);
                                                if (zzcuVar2.zzb != 0) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                unsafe6.putObject(obj3, j, Boolean.valueOf(z3));
                                                unsafe6.putInt(obj3, j3, i9);
                                                iZzj13 = iZzm;
                                            } else {
                                                iZzj13 = i47;
                                            }
                                            if (iZzj13 != i47) {
                                                zzfpVar3 = this;
                                                i2 = i2;
                                                iZzi = iZzj13;
                                                i98 = i9;
                                                i101 = i14 == true ? 1 : 0;
                                                i97 = i10;
                                                i95 = -1;
                                                i93 = i7;
                                                i94 = 0;
                                                unsafe7 = unsafe;
                                                i96 = 1048575;
                                                obj6 = obj3;
                                                zzcuVar8 = zzcuVar2;
                                                i99 = i46;
                                            } else {
                                                i12 = i46;
                                                i8 = iZzj13;
                                            }
                                            break;
                                        case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                                            i46 = i46;
                                            i14 = i14 == true ? 1 : 0;
                                            i47 = i47;
                                            i7 = 3;
                                            obj3 = obj;
                                            zzcuVar2 = zzcuVar;
                                            if (r9 == 2) {
                                                iZzj14 = zzcv.zzj(bArr2, i47, zzcuVar2);
                                                i89 = zzcuVar2.zza;
                                                if (i89 == 0) {
                                                    unsafe6.putObject(obj3, j, "");
                                                } else {
                                                    i90 = i15 & 536870912;
                                                    i91 = iZzj14 + i89;
                                                    if (i90 == 0) {
                                                    }
                                                    unsafe6.putObject(obj3, j, new String(bArr2, iZzj14, i89, zzep.zza));
                                                    iZzj14 = i91;
                                                }
                                                unsafe6.putInt(obj3, j3, i9);
                                                iZzj13 = iZzj14;
                                            } else {
                                                i46 = i46;
                                                iZzj13 = i47;
                                            }
                                            if (iZzj13 != i47) {
                                                zzfpVar3 = this;
                                                i2 = i2;
                                                iZzi = iZzj13;
                                                i98 = i9;
                                                i101 = i14 == true ? 1 : 0;
                                                i97 = i10;
                                                i95 = -1;
                                                i93 = i7;
                                                i94 = 0;
                                                unsafe7 = unsafe;
                                                i96 = 1048575;
                                                obj6 = obj3;
                                                zzcuVar8 = zzcuVar2;
                                                i99 = i46;
                                            } else {
                                                i12 = i46;
                                                i8 = iZzj13;
                                            }
                                            break;
                                        case 60:
                                            i47 = i47;
                                            zzcuVar2 = zzcuVar;
                                            if (r9 == 2) {
                                                Object objZzy3 = zzy(obj, i9, i46);
                                                zzge zzgeVarZzv3 = zzv(i46);
                                                i7 = 3;
                                                i14 = i14 == true ? 1 : 0;
                                                iZzj13 = zzcv.zzo(objZzy3, zzgeVarZzv3, bArr, i47, i2, zzcuVar);
                                                zzG(obj, i9, i46, objZzy3);
                                                obj3 = obj;
                                                i46 = i46;
                                            } else {
                                                i14 = i14 == true ? 1 : 0;
                                                i7 = 3;
                                                obj3 = obj;
                                                i46 = i46;
                                                iZzj13 = i47;
                                            }
                                            if (iZzj13 != i47) {
                                                zzfpVar3 = this;
                                                i2 = i2;
                                                iZzi = iZzj13;
                                                i98 = i9;
                                                i101 = i14 == true ? 1 : 0;
                                                i97 = i10;
                                                i95 = -1;
                                                i93 = i7;
                                                i94 = 0;
                                                unsafe7 = unsafe;
                                                i96 = 1048575;
                                                obj6 = obj3;
                                                zzcuVar8 = zzcuVar2;
                                                i99 = i46;
                                            } else {
                                                i12 = i46;
                                                i8 = iZzj13;
                                            }
                                            break;
                                        case 61:
                                            i47 = i47;
                                            obj5 = obj;
                                            if (r9 == 2) {
                                                zzcuVar2 = zzcuVar;
                                                iZza = zzcv.zza(bArr2, i47, zzcuVar2);
                                                unsafe6.putObject(obj5, j, zzcuVar2.zzc);
                                                unsafe6.putInt(obj5, j3, i9);
                                                iZzj13 = iZza;
                                                i46 = i46;
                                                i14 = i14 == true ? 1 : 0;
                                                i7 = 3;
                                                obj3 = obj5;
                                                if (iZzj13 != i47) {
                                                    zzfpVar3 = this;
                                                    i2 = i2;
                                                    iZzi = iZzj13;
                                                    i98 = i9;
                                                    i101 = i14 == true ? 1 : 0;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i93 = i7;
                                                    i94 = 0;
                                                    unsafe7 = unsafe;
                                                    i96 = 1048575;
                                                    obj6 = obj3;
                                                    zzcuVar8 = zzcuVar2;
                                                    i99 = i46;
                                                } else {
                                                    i12 = i46;
                                                    i8 = iZzj13;
                                                }
                                            }
                                            zzcuVar2 = zzcuVar;
                                            i7 = 3;
                                            obj3 = obj5;
                                            iZzj13 = i47;
                                            if (iZzj13 != i47) {
                                                zzfpVar3 = this;
                                                i2 = i2;
                                                iZzi = iZzj13;
                                                i98 = i9;
                                                i101 = i14 == true ? 1 : 0;
                                                i97 = i10;
                                                i95 = -1;
                                                i93 = i7;
                                                i94 = 0;
                                                unsafe7 = unsafe;
                                                i96 = 1048575;
                                                obj6 = obj3;
                                                zzcuVar8 = zzcuVar2;
                                                i99 = i46;
                                            } else {
                                                i12 = i46;
                                                i8 = iZzj13;
                                            }
                                            break;
                                        case 63:
                                            i47 = i47;
                                            obj5 = obj;
                                            if (r9 == 0) {
                                                iZza = zzcv.zzj(bArr2, i47, zzcuVar);
                                                i92 = zzcuVar.zza;
                                                zzelVarZzu2 = zzu(i46);
                                                if (zzelVarZzu2 != null) {
                                                    unsafe6.putObject(obj5, j, Integer.valueOf(i92));
                                                    unsafe6.putInt(obj5, j3, i9);
                                                } else {
                                                    unsafe6.putObject(obj5, j, Integer.valueOf(i92));
                                                    unsafe6.putInt(obj5, j3, i9);
                                                }
                                                zzcuVar2 = zzcuVar;
                                                iZzj13 = iZza;
                                                i46 = i46;
                                                i14 = i14 == true ? 1 : 0;
                                                i7 = 3;
                                                obj3 = obj5;
                                                if (iZzj13 != i47) {
                                                    zzfpVar3 = this;
                                                    i2 = i2;
                                                    iZzi = iZzj13;
                                                    i98 = i9;
                                                    i101 = i14 == true ? 1 : 0;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i93 = i7;
                                                    i94 = 0;
                                                    unsafe7 = unsafe;
                                                    i96 = 1048575;
                                                    obj6 = obj3;
                                                    zzcuVar8 = zzcuVar2;
                                                    i99 = i46;
                                                } else {
                                                    i12 = i46;
                                                    i8 = iZzj13;
                                                }
                                            } else {
                                                zzcuVar2 = zzcuVar;
                                                i7 = 3;
                                                obj3 = obj5;
                                                iZzj13 = i47;
                                                if (iZzj13 != i47) {
                                                    zzfpVar3 = this;
                                                    i2 = i2;
                                                    iZzi = iZzj13;
                                                    i98 = i9;
                                                    i101 = i14 == true ? 1 : 0;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i93 = i7;
                                                    i94 = 0;
                                                    unsafe7 = unsafe;
                                                    i96 = 1048575;
                                                    obj6 = obj3;
                                                    zzcuVar8 = zzcuVar2;
                                                    i99 = i46;
                                                } else {
                                                    i12 = i46;
                                                    i8 = iZzj13;
                                                }
                                            }
                                            break;
                                        case EACTags.ADDRESS /* 66 */:
                                            i47 = i47;
                                            obj5 = obj;
                                            zzcuVar2 = zzcuVar;
                                            if (r9 == 0) {
                                                iZza = zzcv.zzj(bArr2, i47, zzcuVar2);
                                                unsafe6.putObject(obj5, j, Integer.valueOf(zzdj.zzb(zzcuVar2.zza)));
                                                unsafe6.putInt(obj5, j3, i9);
                                                iZzj13 = iZza;
                                                i46 = i46;
                                                i14 = i14 == true ? 1 : 0;
                                                i7 = 3;
                                                obj3 = obj5;
                                                if (iZzj13 != i47) {
                                                    zzfpVar3 = this;
                                                    i2 = i2;
                                                    iZzi = iZzj13;
                                                    i98 = i9;
                                                    i101 = i14 == true ? 1 : 0;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i93 = i7;
                                                    i94 = 0;
                                                    unsafe7 = unsafe;
                                                    i96 = 1048575;
                                                    obj6 = obj3;
                                                    zzcuVar8 = zzcuVar2;
                                                    i99 = i46;
                                                } else {
                                                    i12 = i46;
                                                    i8 = iZzj13;
                                                }
                                            }
                                            i7 = 3;
                                            obj3 = obj5;
                                            iZzj13 = i47;
                                            if (iZzj13 != i47) {
                                                zzfpVar3 = this;
                                                i2 = i2;
                                                iZzi = iZzj13;
                                                i98 = i9;
                                                i101 = i14 == true ? 1 : 0;
                                                i97 = i10;
                                                i95 = -1;
                                                i93 = i7;
                                                i94 = 0;
                                                unsafe7 = unsafe;
                                                i96 = 1048575;
                                                obj6 = obj3;
                                                zzcuVar8 = zzcuVar2;
                                                i99 = i46;
                                            } else {
                                                i12 = i46;
                                                i8 = iZzj13;
                                            }
                                            break;
                                        case 67:
                                            i47 = i47;
                                            obj5 = obj;
                                            zzcuVar2 = zzcuVar;
                                            if (r9 == 0) {
                                                iZzj13 = zzcv.zzm(bArr2, i47, zzcuVar2);
                                                unsafe6.putObject(obj5, j, Long.valueOf(zzdj.zzc(zzcuVar2.zzb)));
                                                unsafe6.putInt(obj5, j3, i9);
                                                i46 = i46;
                                                i14 = i14 == true ? 1 : 0;
                                                i7 = 3;
                                                obj3 = obj5;
                                                if (iZzj13 != i47) {
                                                    zzfpVar3 = this;
                                                    i2 = i2;
                                                    iZzi = iZzj13;
                                                    i98 = i9;
                                                    i101 = i14 == true ? 1 : 0;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i93 = i7;
                                                    i94 = 0;
                                                    unsafe7 = unsafe;
                                                    i96 = 1048575;
                                                    obj6 = obj3;
                                                    zzcuVar8 = zzcuVar2;
                                                    i99 = i46;
                                                } else {
                                                    i12 = i46;
                                                    i8 = iZzj13;
                                                }
                                            } else {
                                                i7 = 3;
                                                obj3 = obj5;
                                                iZzj13 = i47;
                                                if (iZzj13 != i47) {
                                                    zzfpVar3 = this;
                                                    i2 = i2;
                                                    iZzi = iZzj13;
                                                    i98 = i9;
                                                    i101 = i14 == true ? 1 : 0;
                                                    i97 = i10;
                                                    i95 = -1;
                                                    i93 = i7;
                                                    i94 = 0;
                                                    unsafe7 = unsafe;
                                                    i96 = 1048575;
                                                    obj6 = obj3;
                                                    zzcuVar8 = zzcuVar2;
                                                    i99 = i46;
                                                } else {
                                                    i12 = i46;
                                                    i8 = iZzj13;
                                                }
                                            }
                                            break;
                                        case 68:
                                            if (r9 == 3) {
                                                int i1312 = ((i14 == true ? 1 : 0) & (-8)) | 4;
                                                Object objZzy4 = zzfpVar3.zzy(obj, i9, i46);
                                                int iZzn2 = zzcv.zzn(objZzy4, zzfpVar3.zzv(i46), bArr, i47, i2, i1312, zzcuVar);
                                                zzfpVar3.zzG(obj, i9, i46, objZzy4);
                                                zzcuVar2 = zzcuVar;
                                                i7 = 3;
                                                i46 = i46;
                                                i14 = i14 == true ? 1 : 0;
                                                iZzj13 = iZzn2;
                                                obj3 = obj;
                                                i47 = i47;
                                            } else {
                                                i7 = 3;
                                                obj3 = obj;
                                                zzcuVar2 = zzcuVar;
                                                iZzj13 = i47;
                                            }
                                            if (iZzj13 != i47) {
                                                zzfpVar3 = this;
                                                i2 = i2;
                                                iZzi = iZzj13;
                                                i98 = i9;
                                                i101 = i14 == true ? 1 : 0;
                                                i97 = i10;
                                                i95 = -1;
                                                i93 = i7;
                                                i94 = 0;
                                                unsafe7 = unsafe;
                                                i96 = 1048575;
                                                obj6 = obj3;
                                                zzcuVar8 = zzcuVar2;
                                                i99 = i46;
                                            } else {
                                                i12 = i46;
                                                i8 = iZzj13;
                                            }
                                            break;
                                        default:
                                            i7 = 3;
                                            obj3 = obj;
                                            zzcuVar2 = zzcuVar;
                                            iZzj13 = i47;
                                            if (iZzj13 != i47) {
                                                zzfpVar3 = this;
                                                i2 = i2;
                                                iZzi = iZzj13;
                                                i98 = i9;
                                                i101 = i14 == true ? 1 : 0;
                                                i97 = i10;
                                                i95 = -1;
                                                i93 = i7;
                                                i94 = 0;
                                                unsafe7 = unsafe;
                                                i96 = 1048575;
                                                obj6 = obj3;
                                                zzcuVar8 = zzcuVar2;
                                                i99 = i46;
                                            } else {
                                                i12 = i46;
                                                i8 = iZzj13;
                                            }
                                            break;
                                    }
                                } else {
                                    if (r9 == 2) {
                                        unsafe5 = zzb;
                                        Object objZzw2 = zzfpVar3.zzw(i46);
                                        object = unsafe5.getObject(obj, j);
                                        if (!((zzfg) object).zze()) {
                                            zzfg zzfgVarZzb2 = zzfg.zza().zzb();
                                            zzfh.zza(zzfgVarZzb2, object);
                                            unsafe5.putObject(obj, j, zzfgVarZzb2);
                                        }
                                        throw null;
                                    }
                                    obj4 = obj;
                                    i12 = i46;
                                    i14 = i14 == true ? 1 : 0;
                                    i8 = i47;
                                    i7 = 3;
                                    obj3 = obj4;
                                    zzcuVar2 = zzcuVar4;
                                }
                            }
                        } else if (r9 == 2) {
                            zzeoVarZzd = (zzeo) unsafe3.getObject(obj6, j);
                            if (!zzeoVarZzd.zzc()) {
                                int size5 = zzeoVarZzd.size();
                                zzeoVarZzd = zzeoVarZzd.zzd(size5 != 0 ? size5 + size5 : 10);
                                unsafe3.putObject(obj6, j, zzeoVarZzd);
                            }
                            iZzi = zzcv.zzf(zzfpVar3.zzv(i99), i14 == true ? 1 : 0, bArr, iZzk, i2, zzeoVarZzd, zzcuVar);
                            i2 = i2;
                            i96 = 1048575;
                            unsafe7 = unsafe3;
                            i99 = i99;
                            i101 = i14 == true ? 1 : 0;
                            i97 = i45;
                            i95 = -1;
                            i94 = 0;
                            i98 = i44;
                            i93 = 3;
                            zzcuVar8 = zzcuVar;
                        } else {
                            i10 = i45;
                            zzcuVar4 = zzcuVar;
                            unsafe = unsafe3;
                            obj4 = obj6;
                            i46 = i99;
                            i9 = i44;
                            i47 = iZzk;
                            i12 = i46;
                            i14 = i14 == true ? 1 : 0;
                            i8 = i47;
                            i7 = 3;
                            obj3 = obj4;
                            zzcuVar2 = zzcuVar4;
                        }
                    }
                } else {
                    unsafe = unsafe7;
                    i7 = i93;
                    i8 = iZzk;
                    zzcuVar2 = zzcuVar8;
                    obj3 = obj6;
                    i9 = i103;
                    i10 = i97;
                    i11 = i95;
                    i12 = i94;
                    i13 = i12;
                    i14 = i101 == true ? 1 : 0;
                }
                if (i14 == i3) {
                }
                if (this.zzh) {
                    zzdsVar = zzcuVar2.zzd;
                    int i1313 = zzds.zzb;
                    int i1314 = zzfu.$r8$clinit;
                    if (zzdsVar != zzds.zza) {
                        zzfm zzfmVar2 = this.zzg;
                        zzgsVar = this.zzl;
                        int i1315 = zzcv.$r8$clinit;
                        zzefVarZzb = zzdsVar.zzb(zzfmVar2, i9);
                        if (zzefVarZzb == null) {
                            iZzi = zzcv.zzi(i14 == true ? 1 : 0, bArr, i8, i2, zzd(obj), zzcuVar);
                            i101 = i14;
                            zzfpVar2 = this;
                            i96 = 1048575;
                        } else {
                            zzed zzedVar2 = (zzed) obj;
                            zzedVar2.zzc();
                            i101 = i14;
                            zzfpVar2 = this;
                            iZzi = zzcv.zzb(i14 == true ? 1 : 0, bArr, i8, i2, zzedVar2, zzefVarZzb, zzgsVar, zzcuVar);
                            i96 = 1048575;
                        }
                    } else {
                        i101 = i14;
                        zzfpVar2 = this;
                        i96 = 1048575;
                        iZzi = zzcv.zzi(i101 == true ? 1 : 0, bArr, i8, i2, zzd(obj), zzcuVar);
                    }
                } else {
                    i101 = i14;
                    zzfpVar2 = this;
                    i96 = 1048575;
                    iZzi = zzcv.zzi(i101 == true ? 1 : 0, bArr, i8, i2, zzd(obj), zzcuVar);
                }
                bArr2 = bArr;
                i2 = i2;
                zzcuVar8 = zzcuVar;
                i97 = i10;
                i95 = i11;
                i93 = i7;
                i94 = i13;
                unsafe7 = unsafe;
                i99 = i12;
                zzfpVar3 = zzfpVar2;
                i98 = i9;
                obj6 = obj;
            } else {
                zzfpVar = zzfpVar3;
                unsafe = unsafe7;
                obj2 = obj6;
                i4 = i100;
                i5 = i101;
                i6 = i97;
            }
        }
        if (i6 != i96) {
            unsafe.putInt(obj2, i6, i4);
        }
        for (int i140 = zzfpVar.zzj; i140 < zzfpVar.zzk; i140++) {
            int[] iArr2 = zzfpVar.zzi;
            int[] iArr3 = zzfpVar.zzc;
            int i141 = iArr2[i140];
            int i142 = iArr3[i141];
            Object objZzf = zzgz.zzf(obj2, zzfpVar.zzs(i141) & i96);
            if (objZzf != null && zzfpVar.zzu(i141) != null) {
                throw null;
            }
        }
        if (i3 == 0) {
            if (iZzi != i2) {
                throw new zzer("Failed to parse the message.");
            }
        } else if (iZzi > i2 || i5 != i3) {
            throw new zzer("Failed to parse the message.");
        }
        return iZzi;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final Object zze() {
        return ((zzeh) this.zzg).zzK();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0071  */
    /* JADX WARN: Code duplicated, block: B:28:0x0077  */
    /* JADX WARN: Code duplicated, block: B:41:0x0084 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzeh) {
                zzeh zzehVar = (zzeh) obj;
                zzehVar.zzW(Integer.MAX_VALUE);
                zzehVar.zza = 0;
                zzehVar.zzU();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZzs = zzs(i);
                int i2 = 1048575 & iZzs;
                int iZzr = zzr(iZzs);
                long j = i2;
                if (iZzr != 9) {
                    if (iZzr != 60 && iZzr != 68) {
                        switch (iZzr) {
                            case 17:
                                if (zzI(obj, i)) {
                                    zzv(i).zzf(zzb.getObject(obj, j));
                                }
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
                                ((zzeo) zzgz.zzf(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzfg) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzM(obj, this.zzc[i], i)) {
                        zzv(i).zzf(zzb.getObject(obj, j));
                    }
                } else if (zzI(obj, i)) {
                    zzv(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzl.zza(obj);
            if (this.zzh) {
                this.zzm.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzs = zzs(i);
            int i2 = 1048575 & iZzs;
            int[] iArr = this.zzc;
            int iZzr = zzr(iZzs);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzr) {
                case 0:
                    if (zzI(obj2, i)) {
                        zzgz.zzo(obj, j, zzgz.zza(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 1:
                    if (zzI(obj2, i)) {
                        zzgz.zzp(obj, j, zzgz.zzb(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 2:
                    if (zzI(obj2, i)) {
                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 3:
                    if (zzI(obj2, i)) {
                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 4:
                    if (zzI(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 5:
                    if (zzI(obj2, i)) {
                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 6:
                    if (zzI(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 7:
                    if (zzI(obj2, i)) {
                        zzgz.zzm(obj, j, zzgz.zzw(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 8:
                    if (zzI(obj2, i)) {
                        zzgz.zzs(obj, j, zzgz.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (zzI(obj2, i)) {
                        zzgz.zzs(obj, j, zzgz.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 11:
                    if (zzI(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 12:
                    if (zzI(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 13:
                    if (zzI(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 14:
                    if (zzI(obj2, i)) {
                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 15:
                    if (zzI(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 16:
                    if (zzI(obj2, i)) {
                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 17:
                    zzB(obj, obj2, i);
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
                    zzeo zzeoVarZzd = (zzeo) zzgz.zzf(obj, j);
                    zzeo zzeoVar = (zzeo) zzgz.zzf(obj2, j);
                    int size = zzeoVarZzd.size();
                    int size2 = zzeoVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzeoVarZzd.zzc()) {
                            zzeoVarZzd = zzeoVarZzd.zzd(size2 + size);
                        }
                        zzeoVarZzd.addAll(zzeoVar);
                    }
                    if (size > 0) {
                        zzeoVar = zzeoVarZzd;
                    }
                    zzgz.zzs(obj, j, zzeoVar);
                    break;
                case 50:
                    int i4 = zzgg.$r8$clinit;
                    zzgz.zzs(obj, j, zzfh.zza(zzgz.zzf(obj, j), zzgz.zzf(obj2, j)));
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
                    if (zzM(obj2, i3, i)) {
                        zzgz.zzs(obj, j, zzgz.zzf(obj2, j));
                        zzE(obj, i3, i);
                    }
                    break;
                case 60:
                    zzC(obj, obj2, i);
                    break;
                case 61:
                case PacketTags.EXPERIMENTAL_3 /* 62 */:
                case 63:
                case 64:
                case EACTags.ELEMENT_LIST /* 65 */:
                case EACTags.ADDRESS /* 66 */:
                case 67:
                    if (zzM(obj2, i3, i)) {
                        zzgz.zzs(obj, j, zzgz.zzf(obj2, j));
                        zzE(obj, i3, i);
                    }
                    break;
                case 68:
                    zzC(obj, obj2, i);
                    break;
            }
        }
        zzgg.zzp(this.zzl, obj, obj2);
        if (this.zzh) {
            zzgg.zzo(this.zzm, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzcu zzcuVar) {
        zzc(obj, bArr, i, i2, 0, zzcuVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzi(Object obj, zzhh zzhhVar) throws IOException {
        Map.Entry entry;
        Iterator it;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        if (this.zzh) {
            zzdx zzdxVar = ((zzed) obj).zzb;
            if (zzdxVar.zza.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator itZzf = zzdxVar.zzf();
                entry = (Map.Entry) itZzf.next();
                it = itZzf;
            }
        } else {
            entry = null;
            it = null;
        }
        int[] iArr = this.zzc;
        Unsafe unsafe = zzb;
        int i5 = 1048575;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        while (i8 < iArr.length) {
            int iZzs = zzs(i8);
            int[] iArr2 = this.zzc;
            int iZzr = zzr(iZzs);
            int i9 = iArr2[i8];
            if (iZzr <= 17) {
                int i10 = iArr2[i8 + 2];
                int i11 = i10 & i5;
                if (i11 != i6) {
                    i7 = i11 == i5 ? 0 : unsafe.getInt(obj, i11);
                    i6 = i11;
                } else {
                    iZzr = iZzr;
                }
                i = i6;
                i2 = i7;
                i3 = 1 << (i10 >>> 20);
            } else {
                iZzr = iZzr;
                i = i6;
                i2 = i7;
                i3 = 0;
            }
            while (entry != null && ((zzee) entry.getKey()).zza <= i9) {
                this.zzm.zzb(zzhhVar, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long j = iZzs & 1048575;
            switch (iZzr) {
                case 0:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzhhVar.zzf(i9, zzgz.zza(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 1:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzhhVar.zzo(i9, zzgz.zzb(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 2:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzhhVar.zzt(i9, unsafe.getLong(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 3:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzhhVar.zzK(i9, unsafe.getLong(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 4:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzhhVar.zzr(i9, unsafe.getInt(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 5:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzhhVar.zzm(i9, unsafe.getLong(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 6:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzhhVar.zzk(i9, unsafe.getInt(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 7:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzhhVar.zzb(i9, zzgz.zzw(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 8:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzO(i9, unsafe.getObject(obj, j), zzhhVar);
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 9:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzhhVar.zzv(i9, unsafe.getObject(obj, j), zzv(i4));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 10:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzhhVar.zzd(i9, (zzdf) unsafe.getObject(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 11:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzhhVar.zzI(i9, unsafe.getInt(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 12:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzhhVar.zzi(i9, unsafe.getInt(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 13:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzhhVar.zzx(i9, unsafe.getInt(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 14:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzhhVar.zzz(i9, unsafe.getLong(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 15:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzhhVar.zzB(i9, unsafe.getInt(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 16:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzhhVar.zzD(i9, unsafe.getLong(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 17:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i8, i, i2, i3)) {
                        zzhhVar.zzq(i9, unsafe.getObject(obj, j), zzv(i4));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 18:
                    z = false;
                    zzgg.zzr(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 19:
                    z = false;
                    zzgg.zzv(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 20:
                    z = false;
                    zzgg.zzx(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 21:
                    z = false;
                    zzgg.zzD(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 22:
                    z = false;
                    zzgg.zzw(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 23:
                    z = false;
                    zzgg.zzu(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 24:
                    z = false;
                    zzgg.zzt(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 25:
                    z = false;
                    zzgg.zzq(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 26:
                    int i12 = this.zzc[i8];
                    List list = (List) unsafe.getObject(obj, j);
                    int i13 = zzgg.$r8$clinit;
                    if (list != null && !list.isEmpty()) {
                        zzhhVar.zzH(i12, list);
                    }
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 27:
                    int i14 = this.zzc[i8];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zzge zzgeVarZzv = zzv(i8);
                    int i15 = zzgg.$r8$clinit;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i16 = 0; i16 < list2.size(); i16++) {
                            ((zzdo) zzhhVar).zzv(i14, list2.get(i16), zzgeVarZzv);
                        }
                    }
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 28:
                    int i17 = this.zzc[i8];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i18 = zzgg.$r8$clinit;
                    if (list3 != null && !list3.isEmpty()) {
                        zzhhVar.zze(i17, list3);
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 29:
                    z2 = false;
                    zzgg.zzC(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 30:
                    z2 = false;
                    zzgg.zzs(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 31:
                    z2 = false;
                    zzgg.zzy(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 32:
                    z2 = false;
                    zzgg.zzz(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 33:
                    z2 = false;
                    zzgg.zzA(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 34:
                    z2 = false;
                    zzgg.zzB(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 35:
                    z3 = true;
                    zzgg.zzr(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 36:
                    z3 = true;
                    zzgg.zzv(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 37:
                    z3 = true;
                    zzgg.zzx(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 38:
                    z3 = true;
                    zzgg.zzD(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 39:
                    z3 = true;
                    zzgg.zzw(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 40:
                    z3 = true;
                    zzgg.zzu(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 41:
                    z3 = true;
                    zzgg.zzt(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 42:
                    z3 = true;
                    zzgg.zzq(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 43:
                    z3 = true;
                    zzgg.zzC(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 44:
                    z3 = true;
                    zzgg.zzs(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 45:
                    z3 = true;
                    zzgg.zzy(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 46:
                    z3 = true;
                    zzgg.zzz(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 47:
                    z3 = true;
                    zzgg.zzA(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 48:
                    z3 = true;
                    zzgg.zzB(this.zzc[i8], (List) unsafe.getObject(obj, j), zzhhVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 49:
                    int i19 = this.zzc[i8];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zzge zzgeVarZzv2 = zzv(i8);
                    int i20 = zzgg.$r8$clinit;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i21 = 0; i21 < list4.size(); i21++) {
                            ((zzdo) zzhhVar).zzq(i19, list4.get(i21), zzgeVarZzv2);
                        }
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        throw null;
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 51:
                    if (zzM(obj, i9, i8)) {
                        zzhhVar.zzf(i9, zzm(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 52:
                    if (zzM(obj, i9, i8)) {
                        zzhhVar.zzo(i9, zzn(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case EACTags.SEX /* 53 */:
                    if (zzM(obj, i9, i8)) {
                        zzhhVar.zzt(i9, zzt(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case EACTags.CURRENCY_EXPONENT /* 54 */:
                    if (zzM(obj, i9, i8)) {
                        zzhhVar.zzK(i9, zzt(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 55:
                    if (zzM(obj, i9, i8)) {
                        zzhhVar.zzr(i9, zzo(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 56:
                    if (zzM(obj, i9, i8)) {
                        zzhhVar.zzm(i9, zzt(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 57:
                    if (zzM(obj, i9, i8)) {
                        zzhhVar.zzk(i9, zzo(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 58:
                    if (zzM(obj, i9, i8)) {
                        zzhhVar.zzb(i9, zzN(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (zzM(obj, i9, i8)) {
                        zzO(i9, unsafe.getObject(obj, j), zzhhVar);
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 60:
                    if (zzM(obj, i9, i8)) {
                        zzhhVar.zzv(i9, unsafe.getObject(obj, j), zzv(i8));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 61:
                    if (zzM(obj, i9, i8)) {
                        zzhhVar.zzd(i9, (zzdf) unsafe.getObject(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case PacketTags.EXPERIMENTAL_3 /* 62 */:
                    if (zzM(obj, i9, i8)) {
                        zzhhVar.zzI(i9, zzo(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 63:
                    if (zzM(obj, i9, i8)) {
                        zzhhVar.zzi(i9, zzo(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 64:
                    if (zzM(obj, i9, i8)) {
                        zzhhVar.zzx(i9, zzo(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case EACTags.ELEMENT_LIST /* 65 */:
                    if (zzM(obj, i9, i8)) {
                        zzhhVar.zzz(i9, zzt(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case EACTags.ADDRESS /* 66 */:
                    if (zzM(obj, i9, i8)) {
                        zzhhVar.zzB(i9, zzo(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 67:
                    if (zzM(obj, i9, i8)) {
                        zzhhVar.zzD(i9, zzt(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 68:
                    if (zzM(obj, i9, i8)) {
                        zzhhVar.zzq(i9, unsafe.getObject(obj, j), zzv(i8));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                default:
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
            }
        }
        Iterator it2 = it;
        while (entry != null) {
            this.zzm.zzb(zzhhVar, entry);
            entry = it2.hasNext() ? (Map.Entry) it2.next() : null;
        }
        ((zzeh) obj).zzc.zzl(zzhhVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzE;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzs = zzs(i);
            long j = iZzs & 1048575;
            switch (zzr(iZzs)) {
                case 0:
                    if (!zzH(obj, obj2, i) || Double.doubleToLongBits(zzgz.zza(obj, j)) != Double.doubleToLongBits(zzgz.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzH(obj, obj2, i) || Float.floatToIntBits(zzgz.zzb(obj, j)) != Float.floatToIntBits(zzgz.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzH(obj, obj2, i) || zzgz.zzd(obj, j) != zzgz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzH(obj, obj2, i) || zzgz.zzd(obj, j) != zzgz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzH(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzH(obj, obj2, i) || zzgz.zzd(obj, j) != zzgz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzH(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzH(obj, obj2, i) || zzgz.zzw(obj, j) != zzgz.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzH(obj, obj2, i) || !zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzH(obj, obj2, i) || !zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzH(obj, obj2, i) || !zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzH(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzH(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzH(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzH(obj, obj2, i) || zzgz.zzd(obj, j) != zzgz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzH(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzH(obj, obj2, i) || zzgz.zzd(obj, j) != zzgz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzH(obj, obj2, i) || !zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
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
                    zZzE = zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j));
                    break;
                case 50:
                    zZzE = zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j));
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
                case 60:
                case 61:
                case PacketTags.EXPERIMENTAL_3 /* 62 */:
                case 63:
                case 64:
                case EACTags.ELEMENT_LIST /* 65 */:
                case EACTags.ADDRESS /* 66 */:
                case 67:
                case 68:
                    long jZzp = zzp(i) & 1048575;
                    if (zzgz.zzc(obj, jZzp) != zzgz.zzc(obj2, jZzp) || !zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzE) {
                return false;
            }
        }
        if (!((zzeh) obj).zzc.equals(((zzeh) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzed) obj).zzb.equals(((zzed) obj2).zzb);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009b  */
    /* JADX WARN: Code duplicated, block: B:44:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c0 A[LOOP:1: B:45:0x00af->B:50:0x00c0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00dd A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        List list;
        zzge zzgeVarZzv;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i7 = iArr[i5];
            int i8 = iArr2[i7];
            int iZzs = zzs(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i6) {
                if (i10 != 1048575) {
                    i4 = zzb.getInt(obj, i10);
                }
                i2 = i4;
                i = i10;
            } else {
                i = i6;
                i2 = i4;
            }
            if ((268435456 & iZzs) != 0 && !zzJ(obj, i7, i, i2, i11)) {
                return false;
            }
            int iZzr = zzr(iZzs);
            if (iZzr == 9 || iZzr == 17) {
                if (zzJ(obj, i7, i, i2, i11) && !zzK(obj, iZzs, zzv(i7))) {
                    return false;
                }
            } else if (iZzr == 27) {
                list = (List) zzgz.zzf(obj, iZzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgeVarZzv = zzv(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzgeVarZzv.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzr == 60 || iZzr == 68) {
                if (zzM(obj, i8, i7) && !zzK(obj, iZzs, zzv(i7))) {
                    return false;
                }
            } else if (iZzr == 49) {
                list = (List) zzgz.zzf(obj, iZzs & 1048575);
                if (list.isEmpty()) {
                    zzgeVarZzv = zzv(i7);
                    while (i3 < list.size()) {
                        if (!zzgeVarZzv.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzr == 50 && !((zzfg) zzgz.zzf(obj, iZzs & 1048575)).isEmpty()) {
                throw null;
            }
            i5++;
            i6 = i;
            i4 = i2;
        }
        return !this.zzh || ((zzed) obj).zzb.zzk();
    }
}
