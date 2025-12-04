package com.contentsquare.android.sdk;

import android.view.View;
import androidx.core.util.Predicate;
import com.contentsquare.android.sdk.InterfaceC0703i2;
import com.contentsquare.android.sdk.x8;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.i3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0704i3 implements InterfaceC0703i2 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object] */
    @Override // com.contentsquare.android.sdk.InterfaceC0703i2
    @Nullable
    public final C0693h2 a(@NotNull InterfaceC0703i2.a request) {
        C0693h2 c0693h2;
        Object obj;
        View view;
        Intrinsics.checkNotNullParameter(request, "request");
        x8<View> x8Var = request.a;
        Predicate filter = new Predicate() { // from class: com.contentsquare.android.sdk.i3$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj2) {
                return C0704i3.a((View) obj2);
            }
        };
        x8Var.getClass();
        Intrinsics.checkNotNullParameter(filter, "filter");
        x8.a aVar = x8Var.b;
        while (true) {
            c0693h2 = null;
            if (aVar == null) {
                obj = null;
                break;
            }
            obj = aVar.a.get();
            if (obj != null && filter.test(obj)) {
                break;
            }
            aVar = aVar.c;
        }
        View view2 = (View) obj;
        if (view2 == null) {
            x8.a aVar2 = request.a.b;
            while (true) {
                if (aVar2 == null) {
                    view = 0;
                    break;
                }
                view = aVar2.a.get();
                if (view != 0) {
                    break;
                }
                aVar2 = aVar2.c;
            }
            view2 = view;
        }
        if (view2 != null) {
            c0693h2 = new C0693h2(view2, C0693h2.d, (view2.isClickable() && view2.hasOnClickListeners()) ? false : true);
        }
        return c0693h2;
    }

    public static final boolean a(View view) {
        return view != null && view.isClickable();
    }
}
