package com.google.android.gms.internal.identity;

import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes3.dex */
public interface zzz extends IInterface {
    void zzb(Status status, Location location) throws RemoteException;
}
