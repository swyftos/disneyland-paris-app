package com.contentsquare.android.sdk;

import android.view.View;
import androidx.core.util.Predicate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.i3 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2774i3 implements InterfaceC2773i2 {
    @Override // com.contentsquare.android.sdk.InterfaceC2773i2
    @Nullable
    /* JADX INFO: renamed from: a */
    public final C2763h2 mo1155a(@NotNull InterfaceC2773i2.a request) {
        C2763h2 c2763h2;
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(request, "request");
        C2929x8<View> c2929x8 = request.f2739a;
        Predicate filter = new Predicate() { // from class: com.contentsquare.android.sdk.i3$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj3) {
                return C2774i3.m1156a((View) obj3);
            }
        };
        c2929x8.getClass();
        Intrinsics.checkNotNullParameter(filter, "filter");
        C2929x8.a aVar = c2929x8.f3248b;
        while (true) {
            c2763h2 = null;
            if (aVar == null) {
                obj = null;
                break;
            }
            obj = aVar.f3249a.get();
            if (obj != null && filter.test(obj)) {
                break;
            }
            aVar = aVar.f3251c;
        }
        View view = (View) obj;
        if (view == null) {
            C2929x8.a aVar2 = request.f2739a.f3248b;
            while (true) {
                if (aVar2 == null) {
                    obj2 = null;
                    break;
                }
                obj2 = aVar2.f3249a.get();
                if (obj2 != null) {
                    break;
                }
                aVar2 = aVar2.f3251c;
            }
            view = (View) obj2;
        }
        if (view != null) {
            c2763h2 = new C2763h2(view, C2763h2.f2684d, (view.isClickable() && view.hasOnClickListeners()) ? false : true);
        }
        return c2763h2;
    }

    /* JADX INFO: renamed from: a */
    public static final boolean m1156a(View view) {
        return view != null && view.isClickable();
    }
}
