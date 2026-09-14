package com.contentsquare.android.sdk;

import android.widget.EditText;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.Z2 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nMaskingParameter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MaskingParameter.kt\ncom/contentsquare/android/internal/features/sessionreplay/privacy/MaskingParameter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,123:1\n766#2:124\n857#2,2:125\n1747#2,3:127\n*S KotlinDebug\n*F\n+ 1 MaskingParameter.kt\ncom/contentsquare/android/internal/features/sessionreplay/privacy/MaskingParameter\n*L\n116#1:124\n116#1:125,2\n120#1:127,3\n*E\n"})
public final class C2684Z2 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final PreferencesStore f2322a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final WeakHashMap f2323b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final List<a> f2324c;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.Z2$a */
    public static final class a {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final Class<?> f2325a;

        /* JADX INFO: renamed from: b */
        public final boolean f2326b;

        public a(@NotNull Class<?> clazz, boolean z) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            this.f2325a = clazz;
            this.f2326b = z;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.areEqual(a.class, obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual(this.f2325a, ((a) obj).f2325a);
        }

        public final int hashCode() {
            return this.f2325a.hashCode();
        }
    }

    public C2684Z2(@NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        this.f2322a = preferencesStore;
        this.f2323b = new WeakHashMap();
        this.f2324c = CollectionsKt.mutableListOf(new a(EditText.class, true));
    }
}
