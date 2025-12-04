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
import com.contentsquare.android.sdk.M;
import com.contentsquare.android.sdk.M2;
import com.contentsquare.android.sdk.N;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/android/internal/features/initialize/AutoStart;", "Landroid/content/ContentProvider;", "<init>", "()V", "library_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public class AutoStart extends ContentProvider {

    @NotNull
    public final Lazy a = LazyKt.lazy(new a());

    @NotNull
    public final AutoStart$lifecycleObserver$1 b = new DefaultLifecycleObserver() { // from class: com.contentsquare.android.internal.features.initialize.AutoStart$lifecycleObserver$1
        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public final void onCreate(@NotNull LifecycleOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Context context = this.a.getContext();
            if (context == null || !M.a(context)) {
                return;
            }
            Contentsquare.start(context);
        }
    };

    public static final class a extends Lambda implements Function0<N> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final N invoke() {
            Context context = AutoStart.this.getContext();
            if (context == null) {
                return null;
            }
            return new N(context);
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
        N n = (N) this.a.getValue();
        if (n != null) {
            LifecycleRegistry lifecycleRegistry = n.b;
            if (lifecycleRegistry == null) {
                Intrinsics.throwUninitializedPropertyAccessException("registry");
                lifecycleRegistry = null;
            }
            if (lifecycleRegistry != null) {
                lifecycleRegistry.addObserver(this.b);
            }
        }
        Context context = getContext();
        if (context == null) {
            return true;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (M2.b != null) {
            return true;
        }
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        M2.b = new M2((Application) applicationContext);
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
