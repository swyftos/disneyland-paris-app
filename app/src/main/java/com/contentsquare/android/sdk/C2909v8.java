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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.v8 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2909v8 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Logger f3197a = new Logger("ViewUtil");

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.v8$a */
    public static final class a {
        /* JADX INFO: renamed from: a */
        public static int m1224a(int i, @Nullable Context context) {
            Resources resources;
            DisplayMetrics displayMetrics;
            return (int) ((i / (((context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? 160 : displayMetrics.densityDpi) / 160)) + 0.5f);
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.v8$b */
    public static final class b extends Lambda implements Function2<Pair<? extends View, ? extends Integer>, Pair<? extends View, ? extends Integer>, Integer> {

        /* JADX INFO: renamed from: a */
        public static final b f3198a = new b();

        public b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Integer invoke(Pair<? extends View, ? extends Integer> pair, Pair<? extends View, ? extends Integer> pair2) {
            return Integer.valueOf(C2694a3.m1085a(pair.getSecond().intValue(), pair2.getSecond().intValue()));
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public final View m1223a(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        final b bVar = b.f3198a;
        PriorityQueue priorityQueue = new PriorityQueue(10, new Comparator() { // from class: com.contentsquare.android.sdk.v8$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C2909v8.m1222a(bVar, obj, obj2);
            }
        });
        int childCount = viewGroup.getChildCount();
        if (childCount == 0) {
            this.f3197a.m827d("View Group without children detected, returning " + viewGroup);
            return null;
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt == null || childAt.getVisibility() != 0) {
                this.f3197a.m829e("Child was null or invisible, skipping, " + childAt);
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

    /* JADX INFO: renamed from: a */
    public static final int m1222a(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }
}
