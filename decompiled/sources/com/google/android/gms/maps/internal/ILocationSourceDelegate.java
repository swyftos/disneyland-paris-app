package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public interface ILocationSourceDelegate extends IInterface {
    void activate(zzaj zzajVar) throws RemoteException;

    void deactivate() throws RemoteException;
}
