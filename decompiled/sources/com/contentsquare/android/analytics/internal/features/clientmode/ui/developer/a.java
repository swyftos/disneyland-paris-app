package com.contentsquare.android.analytics.internal.features.clientmode.ui.developer;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nDeveloperActivationViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperActivationViewModel.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/developer/DeveloperActivationViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,67:1\n1549#2:68\n1620#2,3:69\n*S KotlinDebug\n*F\n+ 1 DeveloperActivationViewModel.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/developer/DeveloperActivationViewModel\n*L\n24#1:68\n24#1:69,3\n*E\n"})
/* loaded from: classes2.dex */
public final class a extends ViewModel {

    @NotNull
    public final PreferencesStore a;

    /* renamed from: com.contentsquare.android.analytics.internal.features.clientmode.ui.developer.a$a, reason: collision with other inner class name */
    public static final class C0037a implements ViewModelProvider.Factory {

        @NotNull
        public final PreferencesStore a;

        public C0037a(@NotNull PreferencesStore preferencesStore) {
            Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
            this.a = preferencesStore;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public final <T extends ViewModel> T create(@NotNull Class<T> modelClass) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            if (Intrinsics.areEqual(modelClass, a.class)) {
                return new a(this.a);
            }
            T tNewInstance = modelClass.getDeclaredConstructor(null).newInstance(null);
            Intrinsics.checkNotNullExpressionValue(tNewInstance, "{\n                    mo…tance()\n                }");
            return tNewInstance;
        }
    }

    public a(@NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        this.a = preferencesStore;
    }
}
