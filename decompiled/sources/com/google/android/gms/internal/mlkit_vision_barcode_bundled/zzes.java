package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import androidx.camera.video.AudioStats;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzb' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class zzes {
    public static final zzes zza;
    public static final zzes zzb;
    public static final zzes zzc;
    public static final zzes zzd;
    public static final zzes zze;
    public static final zzes zzf;
    public static final zzes zzg;
    public static final zzes zzh;
    public static final zzes zzi;
    public static final zzes zzj;
    private static final /* synthetic */ zzes[] zzk;
    private final Class zzl;

    static {
        zzes zzesVar = new zzes("VOID", 0, Void.class, Void.class, null);
        zza = zzesVar;
        Class cls = Integer.TYPE;
        zzes zzesVar2 = new zzes("INT", 1, cls, Integer.class, 0);
        zzb = zzesVar2;
        zzes zzesVar3 = new zzes("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzesVar3;
        zzes zzesVar4 = new zzes("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(BitmapDescriptorFactory.HUE_RED));
        zzd = zzesVar4;
        zzes zzesVar5 = new zzes("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        zze = zzesVar5;
        zzes zzesVar6 = new zzes("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzesVar6;
        zzes zzesVar7 = new zzes("STRING", 6, String.class, String.class, "");
        zzg = zzesVar7;
        zzes zzesVar8 = new zzes("BYTE_STRING", 7, zzdf.class, zzdf.class, zzdf.zzb);
        zzh = zzesVar8;
        zzes zzesVar9 = new zzes("ENUM", 8, cls, Integer.class, null);
        zzi = zzesVar9;
        zzes zzesVar10 = new zzes("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzesVar10;
        zzk = new zzes[]{zzesVar, zzesVar2, zzesVar3, zzesVar4, zzesVar5, zzesVar6, zzesVar7, zzesVar8, zzesVar9, zzesVar10};
    }

    private zzes(String str, int i, Class cls, Class cls2, Object obj) {
        this.zzl = cls2;
    }

    public static zzes[] values() {
        return (zzes[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzl;
    }
}
