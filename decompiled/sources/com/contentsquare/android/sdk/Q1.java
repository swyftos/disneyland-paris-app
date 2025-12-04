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

/* loaded from: classes2.dex */
public final class Q1 {

    @NotNull
    public static final HashSet<Class<? extends Activity>> a = new HashSet<>();

    @NotNull
    public static final HashSet<Class<? extends View>> b = new HashSet<>();

    @NotNull
    public static final WeakHashMap<View, Object> c = new WeakHashMap<>();

    @NotNull
    public static final Predicate<Activity> d = new Predicate() { // from class: com.contentsquare.android.sdk.Q1$$ExternalSyntheticLambda0
        @Override // androidx.core.util.Predicate
        public final boolean test(Object obj) {
            return Q1.a((Activity) obj);
        }
    };

    @NotNull
    public static final Predicate<View> e = new Predicate() { // from class: com.contentsquare.android.sdk.Q1$$ExternalSyntheticLambda1
        @Override // androidx.core.util.Predicate
        public final boolean test(Object obj) {
            return Q1.b((View) obj);
        }
    };

    @NotNull
    public static final Predicate<View> f = new Predicate() { // from class: com.contentsquare.android.sdk.Q1$$ExternalSyntheticLambda2
        @Override // androidx.core.util.Predicate
        public final boolean test(Object obj) {
            return Q1.a((View) obj);
        }
    };

    public static final boolean a(View view) {
        return c.containsKey(view);
    }

    public static final boolean b(View view) {
        return b.contains(view.getClass()) || view.getId() == 16908336;
    }

    public static final boolean a(Activity activity) {
        return a.contains(activity.getClass());
    }

    @SafeVarargs
    @JvmStatic
    public static final void b(@NotNull Class<? extends View>... viewsClasses) {
        Intrinsics.checkNotNullParameter(viewsClasses, "viewsClasses");
        Collections.addAll(b, Arrays.copyOf(viewsClasses, viewsClasses.length));
    }

    @SafeVarargs
    @JvmStatic
    public static final void a(@NotNull Class<? extends Activity>... activitiesClasses) {
        Intrinsics.checkNotNullParameter(activitiesClasses, "activitiesClasses");
        Collections.addAll(a, Arrays.copyOf(activitiesClasses, activitiesClasses.length));
    }
}
