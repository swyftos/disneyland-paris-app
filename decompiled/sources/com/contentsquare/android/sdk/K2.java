package com.contentsquare.android.sdk;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Predicate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class K2 {

    @NotNull
    public final a a;

    @NotNull
    public final Predicate<View> b;

    public interface a {
        void a(@NotNull View view);
    }

    public K2(a aVar, Predicate predicate) {
        this.a = aVar;
        this.b = predicate;
    }

    public final void a(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        if (this.b.test(viewGroup)) {
            return;
        }
        this.a.a(viewGroup);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = viewGroup.getChildAt(i);
            if (child.getVisibility() == 0) {
                if (child instanceof ViewGroup) {
                    a((ViewGroup) child);
                } else if (!this.b.test(child)) {
                    a aVar = this.a;
                    Intrinsics.checkNotNullExpressionValue(child, "child");
                    aVar.a(child);
                }
            }
        }
    }
}
