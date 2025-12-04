package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.maps.model.Tile;

/* loaded from: classes3.dex */
public interface zzaz extends IInterface {
    @Nullable
    Tile zzb(int i, int i2, int i3) throws RemoteException;
}
