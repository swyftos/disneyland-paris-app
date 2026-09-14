package com.contentsquare.android.sdk;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Predicate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.K2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2539K2 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final a f1785a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Predicate<View> f1786b;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.K2$a */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo913a(@NotNull View view);
    }

    public C2539K2(a aVar, Predicate predicate) {
        this.f1785a = aVar;
        this.f1786b = predicate;
    }

    /* JADX INFO: renamed from: a */
    public final void m964a(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        if (this.f1786b.test(viewGroup)) {
            return;
        }
        this.f1785a.mo913a(viewGroup);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = viewGroup.getChildAt(i);
            if (child.getVisibility() == 0) {
                if (child instanceof ViewGroup) {
                    m964a((ViewGroup) child);
                } else if (!this.f1786b.test(child)) {
                    a aVar = this.f1785a;
                    Intrinsics.checkNotNullExpressionValue(child, "child");
                    aVar.mo913a(child);
                }
            }
        }
    }
}
