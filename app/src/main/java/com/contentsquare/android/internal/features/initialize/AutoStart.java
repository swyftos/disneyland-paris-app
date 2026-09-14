package com.contentsquare.android.internal.features.initialize;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.contentsquare.android.Contentsquare;
import com.contentsquare.android.sdk.C2556M;
import com.contentsquare.android.sdk.C2559M2;
import com.contentsquare.android.sdk.C2566N;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1836d2 = {"Lcom/contentsquare/android/internal/features/initialize/AutoStart;", "Landroid/content/ContentProvider;", "<init>", "()V", "library_release"}, m1837k = 1, m1838mv = {1, 8, 0})
public class AutoStart extends ContentProvider {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Lazy f1286a = LazyKt.lazy(new C2423a());

    /* JADX INFO: renamed from: b */
    @NotNull
    public final AutoStart$lifecycleObserver$1 f1287b = new DefaultLifecycleObserver() { // from class: com.contentsquare.android.internal.features.initialize.AutoStart$lifecycleObserver$1
        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public final void onCreate(@NotNull LifecycleOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Context context = this.f1289a.getContext();
            if (context == null || !C2556M.m980a(context)) {
                return;
            }
            Contentsquare.start(context);
        }
    };

    /* JADX INFO: renamed from: com.contentsquare.android.internal.features.initialize.AutoStart$a */
    public static final class C2423a extends Lambda implements Function0<C2566N> {
        public C2423a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final C2566N invoke() {
            Context context = AutoStart.this.getContext();
            if (context == null) {
                return null;
            }
            return new C2566N(context);
        }
    }

    @Override // android.content.ContentProvider
    public final int delete(@NotNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public final String getType(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public final Uri insert(@NotNull Uri uri, @Nullable ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        C2566N c2566n = (C2566N) this.f1286a.getValue();
        if (c2566n != null) {
            LifecycleRegistry lifecycleRegistry = c2566n.f1877b;
            if (lifecycleRegistry == null) {
                Intrinsics.throwUninitializedPropertyAccessException("registry");
                lifecycleRegistry = null;
            }
            if (lifecycleRegistry != null) {
                lifecycleRegistry.addObserver(this.f1287b);
            }
        }
        Context context = getContext();
        if (context == null) {
            return true;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (C2559M2.f1855b != null) {
            return true;
        }
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        C2559M2.f1855b = new C2559M2((Application) applicationContext);
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public final Cursor query(@NotNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(@NotNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }
}
