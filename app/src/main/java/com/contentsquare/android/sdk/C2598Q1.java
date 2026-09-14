package com.contentsquare.android.sdk;

import android.app.Activity;
import android.view.View;
import androidx.core.util.Predicate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.WeakHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.Q1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2598Q1 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final HashSet<Class<? extends Activity>> f1988a = new HashSet<>();

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final HashSet<Class<? extends View>> f1989b = new HashSet<>();

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final WeakHashMap<View, Object> f1990c = new WeakHashMap<>();

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final Predicate<Activity> f1991d = new Predicate() { // from class: com.contentsquare.android.sdk.Q1$$ExternalSyntheticLambda0
        @Override // androidx.core.util.Predicate
        public final boolean test(Object obj) {
            return C2598Q1.m1007a((Activity) obj);
        }
    };

    /* JADX INFO: renamed from: e */
    @NotNull
    public static final Predicate<View> f1992e = new Predicate() { // from class: com.contentsquare.android.sdk.Q1$$ExternalSyntheticLambda1
        @Override // androidx.core.util.Predicate
        public final boolean test(Object obj) {
            return C2598Q1.m1010b((View) obj);
        }
    };

    /* JADX INFO: renamed from: f */
    @NotNull
    public static final Predicate<View> f1993f = new Predicate() { // from class: com.contentsquare.android.sdk.Q1$$ExternalSyntheticLambda2
        @Override // androidx.core.util.Predicate
        public final boolean test(Object obj) {
            return C2598Q1.m1008a((View) obj);
        }
    };

    /* JADX INFO: renamed from: a */
    public static final boolean m1008a(View view) {
        return f1990c.containsKey(view);
    }

    /* JADX INFO: renamed from: b */
    public static final boolean m1010b(View view) {
        return f1989b.contains(view.getClass()) || view.getId() == 16908336;
    }

    /* JADX INFO: renamed from: a */
    public static final boolean m1007a(Activity activity) {
        return f1988a.contains(activity.getClass());
    }

    @SafeVarargs
    @JvmStatic
    /* JADX INFO: renamed from: b */
    public static final void m1009b(@NotNull Class<? extends View>... viewsClasses) {
        Intrinsics.checkNotNullParameter(viewsClasses, "viewsClasses");
        Collections.addAll(f1989b, Arrays.copyOf(viewsClasses, viewsClasses.length));
    }

    @SafeVarargs
    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final void m1006a(@NotNull Class<? extends Activity>... activitiesClasses) {
        Intrinsics.checkNotNullParameter(activitiesClasses, "activitiesClasses");
        Collections.addAll(f1988a, Arrays.copyOf(activitiesClasses, activitiesClasses.length));
    }
}
