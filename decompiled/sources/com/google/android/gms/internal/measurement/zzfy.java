package com.google.android.gms.internal.measurement;

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
public final class zzfy {
    public static final zzfy zza;
    public static final zzfy zzb;
    public static final zzfy zzc;
    public static final zzfy zzd;
    public static final zzfy zze;
    public static final zzfy zzf;
    public static final zzfy zzg;
    public static final zzfy zzh;
    public static final zzfy zzi;
    public static final zzfy zzj;
    private static final /* synthetic */ zzfy[] zzn;
    private final Class zzk;
    private final Class zzl;
    private final Object zzm;

    public static zzfy[] values() {
        return (zzfy[]) zzn.clone();
    }

    private zzfy(String str, int i, Class cls, Class cls2, Object obj) {
        this.zzk = cls;
        this.zzl = cls2;
        this.zzm = obj;
    }

    public final Class<?> zza() {
        return this.zzl;
    }

    static {
        zzfy zzfyVar = new zzfy("VOID", 0, Void.class, Void.class, null);
        zza = zzfyVar;
        Class cls = Integer.TYPE;
        zzfy zzfyVar2 = new zzfy("INT", 1, cls, Integer.class, 0);
        zzb = zzfyVar2;
        zzfy zzfyVar3 = new zzfy("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzfyVar3;
        zzfy zzfyVar4 = new zzfy("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(BitmapDescriptorFactory.HUE_RED));
        zzd = zzfyVar4;
        zzfy zzfyVar5 = new zzfy("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        zze = zzfyVar5;
        zzfy zzfyVar6 = new zzfy("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzfyVar6;
        zzfy zzfyVar7 = new zzfy("STRING", 6, String.class, String.class, "");
        zzg = zzfyVar7;
        zzfy zzfyVar8 = new zzfy("BYTE_STRING", 7, zzeg.class, zzeg.class, zzeg.zza);
        zzh = zzfyVar8;
        zzfy zzfyVar9 = new zzfy("ENUM", 8, cls, Integer.class, null);
        zzi = zzfyVar9;
        zzfy zzfyVar10 = new zzfy("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzfyVar10;
        zzn = new zzfy[]{zzfyVar, zzfyVar2, zzfyVar3, zzfyVar4, zzfyVar5, zzfyVar6, zzfyVar7, zzfyVar8, zzfyVar9, zzfyVar10};
    }
}
