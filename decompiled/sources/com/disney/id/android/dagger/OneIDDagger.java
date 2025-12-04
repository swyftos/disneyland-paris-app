package com.disney.id.android.dagger;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0001J\b\u0010\b\u001a\u00020\tH\u0001J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/disney/id/android/dagger/OneIDDagger;", "", "()V", "component", "Lcom/disney/id/android/dagger/OneIDComponent;", "testing", "", "getComponent", "resetComponent", "", "setComponent", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OneIDDagger {

    @NotNull
    public static final OneIDDagger INSTANCE = new OneIDDagger();
    private static OneIDComponent component;
    private static boolean testing;

    private OneIDDagger() {
    }

    static {
        resetComponent();
    }

    @JvmStatic
    @JvmName(name = "resetComponent")
    public static final void resetComponent() {
        if (testing) {
            return;
        }
        OneIDComponent oneIDComponentBuild = DaggerOneIDComponent.builder().oneIDModule(new OneIDModule()).build();
        Intrinsics.checkNotNullExpressionValue(oneIDComponentBuild, "build(...)");
        component = oneIDComponentBuild;
    }

    @JvmStatic
    @JvmName(name = "getComponent")
    @NotNull
    public static final OneIDComponent getComponent() {
        OneIDComponent oneIDComponent = component;
        if (oneIDComponent != null) {
            return oneIDComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("component");
        return null;
    }

    @JvmStatic
    @JvmName(name = "setComponent")
    public static final void setComponent(@NotNull OneIDComponent component2) {
        Intrinsics.checkNotNullParameter(component2, "component");
        testing = true;
        component = component2;
    }
}
