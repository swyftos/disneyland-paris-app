package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbt;
import com.google.android.gms.internal.measurement.zzfo;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class zzby {

    public static final class zza extends zzfo<zza, C0064zza> implements zzgy {
        private static final zza zzh;
        private static volatile zzhj<zza> zzi;
        private int zzc;
        private String zzd = "";
        private boolean zze;
        private boolean zzf;
        private int zzg;

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.measurement.zzby$zza$zza, reason: collision with other inner class name */
        public static final class C0064zza extends zzfo.zza<zza, C0064zza> implements zzgy {
            private C0064zza() {
                super(zza.zzh);
            }

            public final String zza() {
                return ((zza) this.zza).zza();
            }

            public final C0064zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(str);
                return this;
            }

            public final boolean zzb() {
                return ((zza) this.zza).zzb();
            }

            public final boolean zzc() {
                return ((zza) this.zza).zzc();
            }

            public final boolean zzd() {
                return ((zza) this.zza).zzd();
            }

            public final int zze() {
                return ((zza) this.zza).zze();
            }

            /* synthetic */ C0064zza(zzca zzcaVar) {
                this();
            }
        }

        public final String zza() {
            return this.zzd;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        public final boolean zzb() {
            return this.zze;
        }

        public final boolean zzc() {
            return this.zzf;
        }

        public final boolean zzd() {
            return (this.zzc & 8) != 0;
        }

        public final int zze() {
            return this.zzg;
        }

        @Override // com.google.android.gms.internal.measurement.zzfo
        protected final Object zza(int i, Object obj, Object obj2) {
            int i2 = zzca.zza[i - 1];
            zzca zzcaVar = null;
            switch (i2) {
                case 1:
                    return new zza();
                case 2:
                    return new C0064zza(zzcaVar);
                case 3:
                    return zzfo.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzhj<zza> zzcVar = zzi;
                    if (zzcVar == null) {
                        synchronized (zza.class) {
                            try {
                                zzcVar = zzi;
                                if (zzcVar == null) {
                                    zzcVar = new zzfo.zzc<>(zzh);
                                    zzi = zzcVar;
                                }
                            } finally {
                            }
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zza zzaVar = new zza();
            zzh = zzaVar;
            zzfo.zza((Class<zza>) zza.class, zzaVar);
        }
    }

    public static final class zzb extends zzfo<zzb, zza> implements zzgy {
        private static final zzb zzl;
        private static volatile zzhj<zzb> zzm;
        private int zzc;
        private long zzd;
        private int zzf;
        private boolean zzk;
        private String zze = "";
        private zzfx<zzc> zzg = zzfo.zzbp();
        private zzfx<zza> zzh = zzfo.zzbp();
        private zzfx<zzbt.zza> zzi = zzfo.zzbp();
        private String zzj = "";

        private zzb() {
        }

        public static final class zza extends zzfo.zza<zzb, zza> implements zzgy {
            private zza() {
                super(zzb.zzl);
            }

            public final int zza() {
                return ((zzb) this.zza).zzf();
            }

            public final zza zza(int i) {
                return ((zzb) this.zza).zza(i);
            }

            public final zza zza(int i, zza.C0064zza c0064zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(i, (zza) ((zzfo) c0064zza.zzv()));
                return this;
            }

            public final List<zzbt.zza> zzb() {
                return Collections.unmodifiableList(((zzb) this.zza).zzg());
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zzl();
                return this;
            }

            /* synthetic */ zza(zzca zzcaVar) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final long zzb() {
            return this.zzd;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final String zzd() {
            return this.zze;
        }

        public final List<zzc> zze() {
            return this.zzg;
        }

        public final int zzf() {
            return this.zzh.size();
        }

        public final zza zza(int i) {
            return this.zzh.get(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i, zza zzaVar) {
            zzaVar.getClass();
            zzfx<zza> zzfxVar = this.zzh;
            if (!zzfxVar.zza()) {
                this.zzh = zzfo.zza(zzfxVar);
            }
            this.zzh.set(i, zzaVar);
        }

        public final List<zzbt.zza> zzg() {
            return this.zzi;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl() {
            this.zzi = zzfo.zzbp();
        }

        public final boolean zzh() {
            return this.zzk;
        }

        public static zza zzi() {
            return zzl.zzbk();
        }

        @Override // com.google.android.gms.internal.measurement.zzfo
        protected final Object zza(int i, Object obj, Object obj2) {
            int i2 = zzca.zza[i - 1];
            zzca zzcaVar = null;
            switch (i2) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzcaVar);
                case 3:
                    return zzfo.zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0003\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzc.class, "zzh", zza.class, "zzi", zzbt.zza.class, "zzj", "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzhj<zzb> zzcVar = zzm;
                    if (zzcVar == null) {
                        synchronized (zzb.class) {
                            try {
                                zzcVar = zzm;
                                if (zzcVar == null) {
                                    zzcVar = new zzfo.zzc<>(zzl);
                                    zzm = zzcVar;
                                }
                            } finally {
                            }
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzb zzj() {
            return zzl;
        }

        static {
            zzb zzbVar = new zzb();
            zzl = zzbVar;
            zzfo.zza((Class<zzb>) zzb.class, zzbVar);
        }
    }

    public static final class zzc extends zzfo<zzc, zza> implements zzgy {
        private static final zzc zzf;
        private static volatile zzhj<zzc> zzg;
        private int zzc;
        private String zzd = "";
        private String zze = "";

        private zzc() {
        }

        public static final class zza extends zzfo.zza<zzc, zza> implements zzgy {
            private zza() {
                super(zzc.zzf);
            }

            /* synthetic */ zza(zzca zzcaVar) {
                this();
            }
        }

        public final String zza() {
            return this.zzd;
        }

        public final String zzb() {
            return this.zze;
        }

        @Override // com.google.android.gms.internal.measurement.zzfo
        protected final Object zza(int i, Object obj, Object obj2) {
            int i2 = zzca.zza[i - 1];
            zzca zzcaVar = null;
            switch (i2) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzcaVar);
                case 3:
                    return zzfo.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzhj<zzc> zzcVar = zzg;
                    if (zzcVar == null) {
                        synchronized (zzc.class) {
                            try {
                                zzcVar = zzg;
                                if (zzcVar == null) {
                                    zzcVar = new zzfo.zzc<>(zzf);
                                    zzg = zzcVar;
                                }
                            } finally {
                            }
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzf = zzcVar;
            zzfo.zza((Class<zzc>) zzc.class, zzcVar);
        }
    }
}
