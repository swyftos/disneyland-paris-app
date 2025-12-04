package com.google.android.odml.image;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class ByteBufferMlImageBuilder {
    private final ByteBuffer zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private int zze = 0;
    private Rect zzf;

    public ByteBufferMlImageBuilder(@NonNull ByteBuffer byteBuffer, int i, int i2, int i3) {
        this.zza = byteBuffer;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zzf = new Rect(0, 0, i, i2);
    }

    @NonNull
    public MlImage build() {
        return new MlImage(new zzf(this.zza, this.zzd), this.zze, this.zzf, 0L, this.zzb, this.zzc);
    }

    @NonNull
    public ByteBufferMlImageBuilder setRotation(int i) {
        MlImage.zzc(i);
        this.zze = i;
        return this;
    }
}
