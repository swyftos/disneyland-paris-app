package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfo.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public abstract class zzfo<MessageType extends zzfo<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdw<MessageType, BuilderType> {
    private static Map<Object, zzfo<?, ?>> zzd = new ConcurrentHashMap();
    protected zzig zzb = zzig.zza();
    private int zzc = -1;

    public static class zzc<T extends zzfo<T, ?>> extends zzdx<T> {
        private final zzfo zza;

        public zzc(T t) {
            this.zza = t;
        }
    }

    public static class zzd<ContainingType extends zzgw, Type> extends zzez<ContainingType, Type> {
    }

    public enum zzf {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzl = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzh = 1;
        public static final int zzi = 2;
        private static final /* synthetic */ int[] zzm = {1, 2};
        public static final int zzj = 1;
        public static final int zzk = 2;
        private static final /* synthetic */ int[] zzn = {1, 2};

        public static int[] zza() {
            return (int[]) zzl.clone();
        }
    }

    protected abstract Object zza(int i, Object obj, Object obj2);

    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzfo<MessageType, BuilderType> implements zzgy {
        protected zzfe zzc = zzfe.zza();

        final zzfe zza() {
            if (this.zzc.zzc()) {
                this.zzc = (zzfe) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    public String toString() {
        return zzhb.zza(this, super.toString());
    }

    public int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZza = zzhl.zza().zza(this).zza(this);
        this.zza = iZza;
        return iZza;
    }

    public static abstract class zza<MessageType extends zzfo<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdv<MessageType, BuilderType> {
        protected MessageType zza;
        protected boolean zzb = false;
        private final zzfo zzc;

        protected zza(MessageType messagetype) {
            this.zzc = messagetype;
            this.zza = (MessageType) messagetype.zza(zzf.zzd, null, null);
        }

        protected void zzq() {
            MessageType messagetype = (MessageType) this.zza.zza(zzf.zzd, null, null);
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        @Override // com.google.android.gms.internal.measurement.zzgy
        public final boolean g_() {
            return zzfo.zza(this.zza, false);
        }

        @Override // com.google.android.gms.internal.measurement.zzgz
        /* renamed from: zzs, reason: merged with bridge method [inline-methods] */
        public MessageType zzu() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzhl.zza().zza(messagetype).zzc(messagetype);
            this.zzb = true;
            return this.zza;
        }

        @Override // com.google.android.gms.internal.measurement.zzgz
        /* renamed from: zzt, reason: merged with bridge method [inline-methods] */
        public final MessageType zzv() {
            MessageType messagetype = (MessageType) zzu();
            if (messagetype.g_()) {
                return messagetype;
            }
            throw new zzie(messagetype);
        }

        @Override // com.google.android.gms.internal.measurement.zzdv
        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            zza(this.zza, messagetype);
            return this;
        }

        private static void zza(zzfo zzfoVar, zzfo zzfoVar2) {
            zzhl.zza().zza(zzfoVar).zzb(zzfoVar, zzfoVar2);
        }

        private final zza zzb(byte[] bArr, int i, int i2, zzfb zzfbVar) throws zzfw {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            try {
                zzhl.zza().zza(this.zza).zza(this.zza, bArr, 0, i2, new zzeb(zzfbVar));
                return this;
            } catch (zzfw e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            } catch (IndexOutOfBoundsException unused) {
                throw zzfw.zza();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.google.android.gms.internal.measurement.zzdv
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public final zza zza(zzes zzesVar, zzfb zzfbVar) throws IOException {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            try {
                zzhl.zza().zza(this.zza).zza(this.zza, zzet.zza(zzesVar), zzfbVar);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzdv
        public final /* synthetic */ zzdv zza(byte[] bArr, int i, int i2, zzfb zzfbVar) throws zzfw {
            return zzb(bArr, 0, i2, zzfbVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzdv
        public final /* synthetic */ zzdv zza(byte[] bArr, int i, int i2) throws zzfw {
            return zzb(bArr, 0, i2, zzfb.zza());
        }

        @Override // com.google.android.gms.internal.measurement.zzdv
        /* renamed from: zzp */
        public final /* synthetic */ zzdv clone() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.measurement.zzgy
        public final /* synthetic */ zzgw h_() {
            return this.zzc;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.measurement.zzdv
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zzaVar = (zza) this.zzc.zza(zzf.zze, (Object) null, (Object) null);
            zzaVar.zza((zza) zzu());
            return zzaVar;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzhl.zza().zza(this).zza(this, (zzfo) obj);
        }
        return false;
    }

    protected final <MessageType extends zzfo<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzbk() {
        return (BuilderType) zza(zzf.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzgy
    public final boolean g_() {
        return zza(this, true);
    }

    public final BuilderType zzbl() {
        BuilderType buildertype = (BuilderType) zza(zzf.zze, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.measurement.zzdw
    final int zzbj() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzdw
    final void zzc(int i) {
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzgw
    public final void zza(zzev zzevVar) throws IOException {
        zzhl.zza().zza(this).zza((Object) this, (zzja) zzey.zza(zzevVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzgw
    public final int zzbm() {
        if (this.zzc == -1) {
            this.zzc = zzhl.zza().zza(this).zzb(this);
        }
        return this.zzc;
    }

    static zzfo zza(Class cls) throws ClassNotFoundException {
        zzfo<?, ?> zzfoVar = zzd.get(cls);
        if (zzfoVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzfoVar = zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzfoVar == null) {
            zzfoVar = (zzfo) ((zzfo) zzin.zza(cls)).zza(zzf.zzf, (Object) null, (Object) null);
            if (zzfoVar == null) {
                throw new IllegalStateException();
            }
            zzd.put(cls, zzfoVar);
        }
        return zzfoVar;
    }

    protected static <T extends zzfo<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static Object zza(zzgw zzgwVar, String str, Object[] objArr) {
        return new zzhn(zzgwVar, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static final <T extends zzfo<T, ?>> boolean zza(T t, boolean z) {
        byte bByteValue = ((Byte) t.zza(zzf.zza, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzd = zzhl.zza().zza(t).zzd(t);
        if (z) {
            t.zza(zzf.zzb, zZzd ? t : null, null);
        }
        return zZzd;
    }

    protected static zzfv zzbn() {
        return zzfp.zzd();
    }

    protected static zzfu zzbo() {
        return zzgk.zzd();
    }

    protected static zzfu zza(zzfu zzfuVar) {
        int size = zzfuVar.size();
        return zzfuVar.zza(size == 0 ? 10 : size << 1);
    }

    protected static <E> zzfx<E> zzbp() {
        return zzhk.zzd();
    }

    protected static <E> zzfx<E> zza(zzfx<E> zzfxVar) {
        int size = zzfxVar.size();
        return zzfxVar.zza(size == 0 ? 10 : size << 1);
    }

    @Override // com.google.android.gms.internal.measurement.zzgw
    public final /* synthetic */ zzgz zzbq() {
        zza zzaVar = (zza) zza(zzf.zze, (Object) null, (Object) null);
        zzaVar.zza((zza) this);
        return zzaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzgw
    public final /* synthetic */ zzgz zzbr() {
        return (zza) zza(zzf.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzgy
    public final /* synthetic */ zzgw h_() {
        return (zzfo) zza(zzf.zzf, (Object) null, (Object) null);
    }
}
