package com.google.android.gms.maps.model;

import androidx.annotation.Nullable;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.google.android.gms.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* loaded from: classes4.dex */
public abstract class UrlTileProvider implements TileProvider {
    private final int zza;
    private final int zzb;

    public UrlTileProvider(int i, int i2) {
        this.zza = i;
        this.zzb = i2;
    }

    @Override // com.google.android.gms.maps.model.TileProvider
    @Nullable
    public final Tile getTile(int i, int i2, int i3) {
        URL tileUrl = getTileUrl(i, i2, i3);
        if (tileUrl == null) {
            return TileProvider.NO_TILE;
        }
        try {
            com.google.android.gms.internal.maps.zzh.zzb(4352);
            int i4 = this.zza;
            int i5 = this.zzb;
            int i6 = com.google.android.gms.internal.maps.zze.zzb;
            InputStream inputStream = InstrumentationCallbacks.getInputStream(tileUrl.openConnection());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Preconditions.checkNotNull(inputStream, "from must not be null.");
            Preconditions.checkNotNull(byteArrayOutputStream, "to must not be null.");
            byte[] bArr = new byte[4096];
            while (true) {
                int i7 = inputStream.read(bArr);
                if (i7 == -1) {
                    Tile tile = new Tile(i4, i5, byteArrayOutputStream.toByteArray());
                    com.google.android.gms.internal.maps.zzh.zza();
                    return tile;
                }
                byteArrayOutputStream.write(bArr, 0, i7);
            }
        } catch (IOException unused) {
            com.google.android.gms.internal.maps.zzh.zza();
            return null;
        } catch (Throwable th) {
            com.google.android.gms.internal.maps.zzh.zza();
            throw th;
        }
    }

    @Nullable
    public abstract URL getTileUrl(int i, int i2, int i3);
}
