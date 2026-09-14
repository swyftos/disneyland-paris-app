package com.contentsquare.android.sdk;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.contentsquare.android.C2362R;
import com.contentsquare.android.analytics.internal.features.clientmode.p018ui.settings.SettingsActivity;
import com.contentsquare.android.analytics.internal.features.clientmode.p018ui.settings.components.ContentsquareSwitchPreference;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.N1 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1836d2 = {"Lcom/contentsquare/android/sdk/N1;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "library_release"}, m1837k = 1, m1838mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFeatureFlagsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeatureFlagsFragment.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/settings/FeatureFlagsFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,92:1\n766#2:93\n857#2,2:94\n1855#2,2:96\n*S KotlinDebug\n*F\n+ 1 FeatureFlagsFragment.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/settings/FeatureFlagsFragment\n*L\n55#1:93\n55#1:94,2\n65#1:96,2\n*E\n"})
public final class C2568N1 extends Fragment {

    /* JADX INFO: renamed from: a */
    public C2678Y5 f1879a;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.N1$a */
    public static final class a extends Lambda implements Function1<Boolean, Unit> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Set<String> f1880a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ String f1881b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ C2568N1 f1882c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Set<String> set, String str, C2568N1 c2568n1) {
            super(1);
            this.f1880a = set;
            this.f1881b = str;
            this.f1882c = c2568n1;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Boolean bool) {
            if (bool.booleanValue()) {
                this.f1880a.add(this.f1881b);
            } else {
                this.f1880a.remove(this.f1881b);
            }
            C2678Y5 c2678y5 = this.f1882c.f1879a;
            if (c2678y5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                c2678y5 = null;
            }
            Set<String> value = this.f1880a;
            c2678y5.getClass();
            Intrinsics.checkNotNullParameter(value, "value");
            c2678y5.f2301a.putStringSet(PreferencesKey.DEVELOPER_OVERRIDE_FEATURE_FLAGS_STATES, value);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m990a(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C2362R.id.contentsquare_override_feature_flags_list);
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            C2678Y5 c2678y5 = this.f1879a;
            C2678Y5 c2678y6 = null;
            if (c2678y5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                c2678y5 = null;
            }
            Set<String> stringSet = c2678y5.f2301a.getStringSet(PreferencesKey.DEVELOPER_OVERRIDE_FEATURE_FLAGS_STATES, SetsKt.emptySet());
            if (stringSet == null) {
                stringSet = SetsKt.emptySet();
            }
            Set mutableSet = CollectionsKt.toMutableSet(stringSet);
            C2678Y5 c2678y7 = this.f1879a;
            if (c2678y7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                c2678y7 = null;
            }
            for (String str : c2678y7.f2309i) {
                Context context = linearLayout.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ContentsquareSwitchPreference contentsquareSwitchPreference = new ContentsquareSwitchPreference(context, null, 0, 6, null);
                contentsquareSwitchPreference.setSwitchContentDescription("contentsquare_switch_" + str);
                ((TextView) contentsquareSwitchPreference.findViewById(C2362R.id.contentsquare_preference_title)).setText(str);
                contentsquareSwitchPreference.setPadding(0, 0, 0, contentsquareSwitchPreference.getResources().getDimensionPixelSize(C2362R.dimen.contentsquare_value_24dp));
                contentsquareSwitchPreference.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                contentsquareSwitchPreference.setChecked(mutableSet.contains(str));
                contentsquareSwitchPreference.setOnSwitchStateChangeListener(new a(mutableSet, str, this));
                linearLayout.addView(contentsquareSwitchPreference);
            }
            C2678Y5 c2678y8 = this.f1879a;
            if (c2678y8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            } else {
                c2678y6 = c2678y8;
            }
            if (c2678y6.f2301a.getBoolean(PreferencesKey.DEVELOPER_OVERRIDE_FEATURE_FLAGS_ENABLED, false)) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(8);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public final View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C2362R.layout.contentsquare_feature_flags_settings, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        InstrumentationCallbacks.onPauseCalled(this);
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        InstrumentationCallbacks.onResumeCalled(this);
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        InstrumentationCallbacks.onStartCalled(this);
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        InstrumentationCallbacks.onStopCalled(this);
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.SettingsActivity");
        C2678Y5 c2678y5 = ((SettingsActivity) fragmentActivityRequireActivity).f1182d;
        C2678Y5 c2678y6 = null;
        if (c2678y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            c2678y5 = null;
        }
        this.f1879a = c2678y5;
        ContentsquareSwitchPreference contentsquareSwitchPreference = (ContentsquareSwitchPreference) view.findViewById(C2362R.id.contentsquare_override_feature_flags_preference);
        if (contentsquareSwitchPreference != null) {
            contentsquareSwitchPreference.setSwitchContentDescription("contentsquare_switch_override_feature_flags");
            C2678Y5 c2678y7 = this.f1879a;
            if (c2678y7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            } else {
                c2678y6 = c2678y7;
            }
            contentsquareSwitchPreference.setChecked(c2678y6.f2301a.getBoolean(PreferencesKey.DEVELOPER_OVERRIDE_FEATURE_FLAGS_ENABLED, false));
            contentsquareSwitchPreference.setOnSwitchStateChangeListener(new C2578O1(this, view));
        }
        m990a(view);
    }
}
