package androidx.test.espresso.remote;

import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public interface Bindable {
    IBinder getIBinder();

    String getId();

    void setIBinder(IBinder iBinder);
}
