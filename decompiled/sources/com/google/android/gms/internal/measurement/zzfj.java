package com.google.android.gms.internal.measurement;

import java.lang.reflect.Type;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzc' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class zzfj {
    public static final zzfj zza;
    private static final zzfj zzaa;
    private static final zzfj zzab;
    private static final zzfj zzac;
    private static final zzfj zzad;
    private static final zzfj zzae;
    private static final zzfj zzaf;
    private static final zzfj zzag;
    private static final zzfj zzah;
    private static final zzfj zzai;
    private static final zzfj zzaj;
    private static final zzfj zzak;
    private static final zzfj zzal;
    private static final zzfj zzam;
    private static final zzfj zzan;
    private static final zzfj zzao;
    private static final zzfj zzap;
    private static final zzfj zzaq;
    private static final zzfj zzar;
    private static final zzfj zzas;
    private static final zzfj zzat;
    private static final zzfj zzau;
    private static final zzfj zzav;
    private static final zzfj zzaw;
    private static final zzfj zzax;
    private static final zzfj zzay;
    public static final zzfj zzb;
    private static final zzfj[] zzbe;
    private static final Type[] zzbf;
    private static final /* synthetic */ zzfj[] zzbg;
    private static final zzfj zzc;
    private static final zzfj zzd;
    private static final zzfj zze;
    private static final zzfj zzf;
    private static final zzfj zzg;
    private static final zzfj zzh;
    private static final zzfj zzi;
    private static final zzfj zzj;
    private static final zzfj zzk;
    private static final zzfj zzl;
    private static final zzfj zzm;
    private static final zzfj zzn;
    private static final zzfj zzo;
    private static final zzfj zzp;
    private static final zzfj zzq;
    private static final zzfj zzr;
    private static final zzfj zzs;
    private static final zzfj zzt;
    private static final zzfj zzu;
    private static final zzfj zzv;
    private static final zzfj zzw;
    private static final zzfj zzx;
    private static final zzfj zzy;
    private static final zzfj zzz;
    private final zzfy zzaz;
    private final int zzba;
    private final zzfl zzbb;
    private final Class zzbc;
    private final boolean zzbd;

    public static zzfj[] values() {
        return (zzfj[]) zzbg.clone();
    }

    private zzfj(String str, int i, int i2, zzfl zzflVar, zzfy zzfyVar) {
        int i3;
        this.zzba = i2;
        this.zzbb = zzflVar;
        this.zzaz = zzfyVar;
        int i4 = zzfi.zza[zzflVar.ordinal()];
        if (i4 == 1 || i4 == 2) {
            this.zzbc = zzfyVar.zza();
        } else {
            this.zzbc = null;
        }
        this.zzbd = (zzflVar != zzfl.SCALAR || (i3 = zzfi.zzb[zzfyVar.ordinal()]) == 1 || i3 == 2 || i3 == 3) ? false : true;
    }

    public final int zza() {
        return this.zzba;
    }

    static {
        zzfl zzflVar = zzfl.SCALAR;
        zzfy zzfyVar = zzfy.zze;
        zzfj zzfjVar = new zzfj("DOUBLE", 0, 0, zzflVar, zzfyVar);
        zzc = zzfjVar;
        zzfy zzfyVar2 = zzfy.zzd;
        zzfj zzfjVar2 = new zzfj("FLOAT", 1, 1, zzflVar, zzfyVar2);
        zzd = zzfjVar2;
        zzfy zzfyVar3 = zzfy.zzc;
        zzfj zzfjVar3 = new zzfj("INT64", 2, 2, zzflVar, zzfyVar3);
        zze = zzfjVar3;
        zzfj zzfjVar4 = new zzfj("UINT64", 3, 3, zzflVar, zzfyVar3);
        zzf = zzfjVar4;
        zzfy zzfyVar4 = zzfy.zzb;
        zzfj zzfjVar5 = new zzfj("INT32", 4, 4, zzflVar, zzfyVar4);
        zzg = zzfjVar5;
        zzfj zzfjVar6 = new zzfj("FIXED64", 5, 5, zzflVar, zzfyVar3);
        zzh = zzfjVar6;
        zzfj zzfjVar7 = new zzfj("FIXED32", 6, 6, zzflVar, zzfyVar4);
        zzi = zzfjVar7;
        zzfy zzfyVar5 = zzfy.zzf;
        zzfj zzfjVar8 = new zzfj("BOOL", 7, 7, zzflVar, zzfyVar5);
        zzj = zzfjVar8;
        zzfy zzfyVar6 = zzfy.zzg;
        zzfj zzfjVar9 = new zzfj("STRING", 8, 8, zzflVar, zzfyVar6);
        zzk = zzfjVar9;
        zzfy zzfyVar7 = zzfy.zzj;
        zzfj zzfjVar10 = new zzfj("MESSAGE", 9, 9, zzflVar, zzfyVar7);
        zzl = zzfjVar10;
        zzfy zzfyVar8 = zzfy.zzh;
        zzfj zzfjVar11 = new zzfj("BYTES", 10, 10, zzflVar, zzfyVar8);
        zzm = zzfjVar11;
        zzfj zzfjVar12 = new zzfj("UINT32", 11, 11, zzflVar, zzfyVar4);
        zzn = zzfjVar12;
        zzfy zzfyVar9 = zzfy.zzi;
        zzfj zzfjVar13 = new zzfj("ENUM", 12, 12, zzflVar, zzfyVar9);
        zzo = zzfjVar13;
        zzfj zzfjVar14 = new zzfj("SFIXED32", 13, 13, zzflVar, zzfyVar4);
        zzp = zzfjVar14;
        zzfj zzfjVar15 = new zzfj("SFIXED64", 14, 14, zzflVar, zzfyVar3);
        zzq = zzfjVar15;
        zzfj zzfjVar16 = new zzfj("SINT32", 15, 15, zzflVar, zzfyVar4);
        zzr = zzfjVar16;
        zzfj zzfjVar17 = new zzfj("SINT64", 16, 16, zzflVar, zzfyVar3);
        zzs = zzfjVar17;
        zzfj zzfjVar18 = new zzfj("GROUP", 17, 17, zzflVar, zzfyVar7);
        zzt = zzfjVar18;
        zzfl zzflVar2 = zzfl.VECTOR;
        zzfj zzfjVar19 = new zzfj("DOUBLE_LIST", 18, 18, zzflVar2, zzfyVar);
        zzu = zzfjVar19;
        zzfj zzfjVar20 = new zzfj("FLOAT_LIST", 19, 19, zzflVar2, zzfyVar2);
        zzv = zzfjVar20;
        zzfj zzfjVar21 = new zzfj("INT64_LIST", 20, 20, zzflVar2, zzfyVar3);
        zzw = zzfjVar21;
        zzfj zzfjVar22 = new zzfj("UINT64_LIST", 21, 21, zzflVar2, zzfyVar3);
        zzx = zzfjVar22;
        zzfj zzfjVar23 = new zzfj("INT32_LIST", 22, 22, zzflVar2, zzfyVar4);
        zzy = zzfjVar23;
        zzfj zzfjVar24 = new zzfj("FIXED64_LIST", 23, 23, zzflVar2, zzfyVar3);
        zzz = zzfjVar24;
        zzfj zzfjVar25 = new zzfj("FIXED32_LIST", 24, 24, zzflVar2, zzfyVar4);
        zzaa = zzfjVar25;
        zzfj zzfjVar26 = new zzfj("BOOL_LIST", 25, 25, zzflVar2, zzfyVar5);
        zzab = zzfjVar26;
        zzfj zzfjVar27 = new zzfj("STRING_LIST", 26, 26, zzflVar2, zzfyVar6);
        zzac = zzfjVar27;
        zzfj zzfjVar28 = new zzfj("MESSAGE_LIST", 27, 27, zzflVar2, zzfyVar7);
        zzad = zzfjVar28;
        zzfj zzfjVar29 = new zzfj("BYTES_LIST", 28, 28, zzflVar2, zzfyVar8);
        zzae = zzfjVar29;
        zzfj zzfjVar30 = new zzfj("UINT32_LIST", 29, 29, zzflVar2, zzfyVar4);
        zzaf = zzfjVar30;
        zzfj zzfjVar31 = new zzfj("ENUM_LIST", 30, 30, zzflVar2, zzfyVar9);
        zzag = zzfjVar31;
        zzfj zzfjVar32 = new zzfj("SFIXED32_LIST", 31, 31, zzflVar2, zzfyVar4);
        zzah = zzfjVar32;
        zzfj zzfjVar33 = new zzfj("SFIXED64_LIST", 32, 32, zzflVar2, zzfyVar3);
        zzai = zzfjVar33;
        zzfj zzfjVar34 = new zzfj("SINT32_LIST", 33, 33, zzflVar2, zzfyVar4);
        zzaj = zzfjVar34;
        zzfj zzfjVar35 = new zzfj("SINT64_LIST", 34, 34, zzflVar2, zzfyVar3);
        zzak = zzfjVar35;
        zzfl zzflVar3 = zzfl.PACKED_VECTOR;
        zzfj zzfjVar36 = new zzfj("DOUBLE_LIST_PACKED", 35, 35, zzflVar3, zzfyVar);
        zza = zzfjVar36;
        zzfj zzfjVar37 = new zzfj("FLOAT_LIST_PACKED", 36, 36, zzflVar3, zzfyVar2);
        zzal = zzfjVar37;
        zzfj zzfjVar38 = new zzfj("INT64_LIST_PACKED", 37, 37, zzflVar3, zzfyVar3);
        zzam = zzfjVar38;
        zzfj zzfjVar39 = new zzfj("UINT64_LIST_PACKED", 38, 38, zzflVar3, zzfyVar3);
        zzan = zzfjVar39;
        zzfj zzfjVar40 = new zzfj("INT32_LIST_PACKED", 39, 39, zzflVar3, zzfyVar4);
        zzao = zzfjVar40;
        zzfj zzfjVar41 = new zzfj("FIXED64_LIST_PACKED", 40, 40, zzflVar3, zzfyVar3);
        zzap = zzfjVar41;
        zzfj zzfjVar42 = new zzfj("FIXED32_LIST_PACKED", 41, 41, zzflVar3, zzfyVar4);
        zzaq = zzfjVar42;
        zzfj zzfjVar43 = new zzfj("BOOL_LIST_PACKED", 42, 42, zzflVar3, zzfyVar5);
        zzar = zzfjVar43;
        zzfj zzfjVar44 = new zzfj("UINT32_LIST_PACKED", 43, 43, zzflVar3, zzfyVar4);
        zzas = zzfjVar44;
        zzfj zzfjVar45 = new zzfj("ENUM_LIST_PACKED", 44, 44, zzflVar3, zzfyVar9);
        zzat = zzfjVar45;
        zzfj zzfjVar46 = new zzfj("SFIXED32_LIST_PACKED", 45, 45, zzflVar3, zzfyVar4);
        zzau = zzfjVar46;
        zzfj zzfjVar47 = new zzfj("SFIXED64_LIST_PACKED", 46, 46, zzflVar3, zzfyVar3);
        zzav = zzfjVar47;
        zzfj zzfjVar48 = new zzfj("SINT32_LIST_PACKED", 47, 47, zzflVar3, zzfyVar4);
        zzaw = zzfjVar48;
        zzfj zzfjVar49 = new zzfj("SINT64_LIST_PACKED", 48, 48, zzflVar3, zzfyVar3);
        zzb = zzfjVar49;
        zzfj zzfjVar50 = new zzfj("GROUP_LIST", 49, 49, zzflVar2, zzfyVar7);
        zzax = zzfjVar50;
        zzfj zzfjVar51 = new zzfj("MAP", 50, 50, zzfl.MAP, zzfy.zza);
        zzay = zzfjVar51;
        zzbg = new zzfj[]{zzfjVar, zzfjVar2, zzfjVar3, zzfjVar4, zzfjVar5, zzfjVar6, zzfjVar7, zzfjVar8, zzfjVar9, zzfjVar10, zzfjVar11, zzfjVar12, zzfjVar13, zzfjVar14, zzfjVar15, zzfjVar16, zzfjVar17, zzfjVar18, zzfjVar19, zzfjVar20, zzfjVar21, zzfjVar22, zzfjVar23, zzfjVar24, zzfjVar25, zzfjVar26, zzfjVar27, zzfjVar28, zzfjVar29, zzfjVar30, zzfjVar31, zzfjVar32, zzfjVar33, zzfjVar34, zzfjVar35, zzfjVar36, zzfjVar37, zzfjVar38, zzfjVar39, zzfjVar40, zzfjVar41, zzfjVar42, zzfjVar43, zzfjVar44, zzfjVar45, zzfjVar46, zzfjVar47, zzfjVar48, zzfjVar49, zzfjVar50, zzfjVar51};
        zzbf = new Type[0];
        zzfj[] zzfjVarArrValues = values();
        zzbe = new zzfj[zzfjVarArrValues.length];
        for (zzfj zzfjVar52 : zzfjVarArrValues) {
            zzbe[zzfjVar52.zzba] = zzfjVar52;
        }
    }
}
