package com.contentsquare.android.sdk;

import android.app.Activity;
import androidx.core.util.Consumer;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.sdk.C0680g;
import com.contentsquare.android.sdk.G;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class I0 implements Consumer<Activity> {
    public final /* synthetic */ J0 a;

    public I0(J0 j0) {
        this.a = j0;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Activity activity) {
        Activity activity2 = activity;
        this.a.b.a.remove(PreferencesKey.IS_HIDE_EVENT_PENDING);
        this.a.b.a.remove(PreferencesKey.SCHEDULED_APP_HIDE_EVENT);
        J0 j0 = this.a;
        Runnable runnable = j0.o;
        if (runnable != null) {
            j0.l.d("canceling hide event event");
            j0.n.removeCallbacks(runnable);
        } else {
            G.a aVar = (G.a) E1.a(j0.f, 1);
            j0.l.i("Starting with Session number: " + aVar.h);
            j0.l.d("sending show event");
            j0.c.a(aVar);
        }
        J0 j02 = this.a;
        j02.m = activity2;
        if (activity2 == null) {
            j02.l.d("[onActivityResumed]: the activity was null when trying to call interceptors");
            return;
        }
        C0696h5 c0696h5 = j02.h;
        j02.e.getClass();
        c0696h5.b(C0676f5.b);
        ((C0723k2) this.a.g).a(activity2);
        this.a.k.a(activity2);
        String name = activity2.getClass().getCanonicalName();
        if (name != null) {
            L2 l2 = this.a.a;
            l2.getClass();
            Intrinsics.checkNotNullParameter(name, "name");
            E1 eventsBuildersFactory = l2.k.getEventsBuildersFactory();
            Intrinsics.checkNotNullExpressionValue(eventsBuildersFactory, "csApplicationModule.eventsBuildersFactory");
            C0680g.a aVar2 = (C0680g.a) E1.a(eventsBuildersFactory, 30);
            aVar2.k = name;
            l2.c.a(aVar2);
        }
    }
}
