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

@SourceDebugExtension({"SMAP\nMaskingParameter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MaskingParameter.kt\ncom/contentsquare/android/internal/features/sessionreplay/privacy/MaskingParameter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,123:1\n766#2:124\n857#2,2:125\n1747#2,3:127\n*S KotlinDebug\n*F\n+ 1 MaskingParameter.kt\ncom/contentsquare/android/internal/features/sessionreplay/privacy/MaskingParameter\n*L\n116#1:124\n116#1:125,2\n120#1:127,3\n*E\n"})
/* loaded from: classes2.dex */
public final class Z2 {

    @NotNull
    public final PreferencesStore a;

    @NotNull
    public final WeakHashMap b;

    @NotNull
    public final List<a> c;

    public static final class a {

        @NotNull
        public final Class<?> a;
        public final boolean b;

        public a(@NotNull Class<?> clazz, boolean z) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            this.a = clazz;
            this.b = z;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.areEqual(a.class, obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual(this.a, ((a) obj).a);
        }

        public final int hashCode() {
            return this.a.hashCode();
        }
    }

    public Z2(@NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        this.a = preferencesStore;
        this.b = new WeakHashMap();
        this.c = CollectionsKt.mutableListOf(new a(EditText.class, true));
    }
}
