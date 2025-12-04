package com.contentsquare.android.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.contentsquare.android.core.features.logging.Logger;
import java.util.Comparator;
import java.util.PriorityQueue;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class v8 {

    @NotNull
    public final Logger a = new Logger("ViewUtil");

    public static final class a {
        public static int a(int i, @Nullable Context context) {
            Resources resources;
            DisplayMetrics displayMetrics;
            return (int) ((i / (((context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? 160 : displayMetrics.densityDpi) / 160)) + 0.5f);
        }
    }

    public static final class b extends Lambda implements Function2<Pair<? extends View, ? extends Integer>, Pair<? extends View, ? extends Integer>, Integer> {
        public static final b a = new b();

        public b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Integer invoke(Pair<? extends View, ? extends Integer> pair, Pair<? extends View, ? extends Integer> pair2) {
            return Integer.valueOf(C0624a3.a(pair.getSecond().intValue(), pair2.getSecond().intValue()));
        }
    }

    @Nullable
    public final View a(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        final b bVar = b.a;
        PriorityQueue priorityQueue = new PriorityQueue(10, new Comparator() { // from class: com.contentsquare.android.sdk.v8$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return v8.a(bVar, obj, obj2);
            }
        });
        int childCount = viewGroup.getChildCount();
        if (childCount == 0) {
            this.a.d("View Group without children detected, returning " + viewGroup);
            return null;
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt == null || childAt.getVisibility() != 0) {
                this.a.e("Child was null or invisible, skipping, " + childAt);
            } else {
                priorityQueue.add(new Pair(childAt, Integer.valueOf(childAt.getHeight() * childAt.getWidth())));
            }
        }
        Pair pair = (Pair) priorityQueue.poll();
        if (pair != null) {
            return (View) pair.getFirst();
        }
        return null;
    }

    public static final int a(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }
}
