package com.urbanairship;

import android.content.Context;
import com.urbanairship.app.GlobalActivityMonitor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/AirshipAppBootstrap;", "", "()V", "init", "", "context", "Landroid/content/Context;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public final class AirshipAppBootstrap {

    @NotNull
    public static final AirshipAppBootstrap INSTANCE = new AirshipAppBootstrap();

    private AirshipAppBootstrap() {
    }

    @JvmStatic
    public static final void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        GlobalActivityMonitor.INSTANCE.shared(context);
    }
}
