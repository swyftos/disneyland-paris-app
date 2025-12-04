package com.google.android.gms.internal.measurement;

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
public class zziu {
    public static final zziu zza;
    public static final zziu zzb;
    public static final zziu zzc;
    public static final zziu zzd;
    public static final zziu zze;
    public static final zziu zzf;
    public static final zziu zzg;
    public static final zziu zzh;
    public static final zziu zzi;
    public static final zziu zzj;
    public static final zziu zzk;
    public static final zziu zzl;
    public static final zziu zzm;
    public static final zziu zzn;
    public static final zziu zzo;
    public static final zziu zzp;
    public static final zziu zzq;
    public static final zziu zzr;
    private static final /* synthetic */ zziu[] zzu;
    private final zzjb zzs;
    private final int zzt;

    public static zziu[] values() {
        return (zziu[]) zzu.clone();
    }

    private zziu(String str, int i, zzjb zzjbVar, int i2) {
        this.zzs = zzjbVar;
        this.zzt = i2;
    }

    public final zzjb zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }

    static {
        zziu zziuVar = new zziu("DOUBLE", 0, zzjb.DOUBLE, 1);
        zza = zziuVar;
        zziu zziuVar2 = new zziu("FLOAT", 1, zzjb.FLOAT, 5);
        zzb = zziuVar2;
        zzjb zzjbVar = zzjb.LONG;
        final int i = 2;
        zziu zziuVar3 = new zziu("INT64", 2, zzjbVar, 0);
        zzc = zziuVar3;
        final int i2 = 3;
        zziu zziuVar4 = new zziu("UINT64", 3, zzjbVar, 0);
        zzd = zziuVar4;
        zzjb zzjbVar2 = zzjb.INT;
        zziu zziuVar5 = new zziu("INT32", 4, zzjbVar2, 0);
        zze = zziuVar5;
        zziu zziuVar6 = new zziu("FIXED64", 5, zzjbVar, 1);
        zzf = zziuVar6;
        zziu zziuVar7 = new zziu("FIXED32", 6, zzjbVar2, 5);
        zzg = zziuVar7;
        zziu zziuVar8 = new zziu("BOOL", 7, zzjb.BOOLEAN, 0);
        zzh = zziuVar8;
        final int i3 = 8;
        final zzjb zzjbVar3 = zzjb.STRING;
        final String str = "STRING";
        zziu zziuVar9 = new zziu(str, i3, zzjbVar3, i) { // from class: com.google.android.gms.internal.measurement.zzix
            {
                int i4 = 2;
                int i5 = 8;
            }
        };
        zzi = zziuVar9;
        final zzjb zzjbVar4 = zzjb.MESSAGE;
        final String str2 = "GROUP";
        final int i4 = 9;
        zziu zziuVar10 = new zziu(str2, i4, zzjbVar4, i2) { // from class: com.google.android.gms.internal.measurement.zziw
            {
                int i5 = 3;
                int i6 = 9;
            }
        };
        zzj = zziuVar10;
        final String str3 = "MESSAGE";
        final int i5 = 10;
        final int i6 = 2;
        zziu zziuVar11 = new zziu(str3, i5, zzjbVar4, i6) { // from class: com.google.android.gms.internal.measurement.zziz
            {
                int i7 = 2;
                int i8 = 10;
            }
        };
        zzk = zziuVar11;
        final int i7 = 11;
        final zzjb zzjbVar5 = zzjb.BYTE_STRING;
        final String str4 = "BYTES";
        zziu zziuVar12 = new zziu(str4, i7, zzjbVar5, i6) { // from class: com.google.android.gms.internal.measurement.zziy
            {
                int i8 = 2;
                int i9 = 11;
            }
        };
        zzl = zziuVar12;
        zziu zziuVar13 = new zziu("UINT32", 12, zzjbVar2, 0);
        zzm = zziuVar13;
        zziu zziuVar14 = new zziu("ENUM", 13, zzjb.ENUM, 0);
        zzn = zziuVar14;
        zziu zziuVar15 = new zziu("SFIXED32", 14, zzjbVar2, 5);
        zzo = zziuVar15;
        zziu zziuVar16 = new zziu("SFIXED64", 15, zzjbVar, 1);
        zzp = zziuVar16;
        zziu zziuVar17 = new zziu("SINT32", 16, zzjbVar2, 0);
        zzq = zziuVar17;
        zziu zziuVar18 = new zziu("SINT64", 17, zzjbVar, 0);
        zzr = zziuVar18;
        zzu = new zziu[]{zziuVar, zziuVar2, zziuVar3, zziuVar4, zziuVar5, zziuVar6, zziuVar7, zziuVar8, zziuVar9, zziuVar10, zziuVar11, zziuVar12, zziuVar13, zziuVar14, zziuVar15, zziuVar16, zziuVar17, zziuVar18};
    }
}
