package com.contentsquare.android.analytics.internal.features.clientmode.p018ui.developer;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.analytics.internal.features.clientmode.ui.developer.a */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nDeveloperActivationViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperActivationViewModel.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/developer/DeveloperActivationViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,67:1\n1549#2:68\n1620#2,3:69\n*S KotlinDebug\n*F\n+ 1 DeveloperActivationViewModel.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/developer/DeveloperActivationViewModel\n*L\n24#1:68\n24#1:69,3\n*E\n"})
public final class C2364a extends ViewModel {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final PreferencesStore f1135a;

    /* JADX INFO: renamed from: com.contentsquare.android.analytics.internal.features.clientmode.ui.developer.a$a */
    public static final class a implements ViewModelProvider.Factory {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final PreferencesStore f1136a;

        public a(@NotNull PreferencesStore preferencesStore) {
            Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
            this.f1136a = preferencesStore;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public final <T extends ViewModel> T create(@NotNull Class<T> modelClass) throws IllegalAccessException, InstantiationException, InvocationTargetException {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            if (Intrinsics.areEqual(modelClass, C2364a.class)) {
                return new C2364a(this.f1136a);
            }
            T tNewInstance = modelClass.getDeclaredConstructor(null).newInstance(null);
            Intrinsics.checkNotNullExpressionValue(tNewInstance, "{\n                    mo…tance()\n                }");
            return tNewInstance;
        }
    }

    public C2364a(@NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        this.f1135a = preferencesStore;
    }
}
