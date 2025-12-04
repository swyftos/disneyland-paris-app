package com.google.android.gms.common.api.internal;

/* loaded from: classes3.dex */
final class zaak implements Runnable {
    final /* synthetic */ zaaw zaa;

    zaak(zaaw zaawVar) {
        this.zaa = zaawVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zaaw zaawVar = this.zaa;
        zaawVar.zad.cancelAvailabilityErrorNotifications(zaawVar.zac);
    }
}
