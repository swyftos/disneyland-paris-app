package com.contentsquare.android.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.contentsquare.android.R;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.SettingsActivity;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.components.ContentsquareSwitchPreference;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/android/sdk/N1;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "library_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFeatureFlagsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeatureFlagsFragment.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/settings/FeatureFlagsFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,92:1\n766#2:93\n857#2,2:94\n1855#2,2:96\n*S KotlinDebug\n*F\n+ 1 FeatureFlagsFragment.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/settings/FeatureFlagsFragment\n*L\n55#1:93\n55#1:94,2\n65#1:96,2\n*E\n"})
/* loaded from: classes2.dex */
public final class N1 extends Fragment {
    public Y5 a;

    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ Set<String> a;
        public final /* synthetic */ String b;
        public final /* synthetic */ N1 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Set<String> set, String str, N1 n1) {
            super(1);
            this.a = set;
            this.b = str;
            this.c = n1;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Boolean bool) {
            if (bool.booleanValue()) {
                this.a.add(this.b);
            } else {
                this.a.remove(this.b);
            }
            Y5 y5 = this.c.a;
            if (y5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                y5 = null;
            }
            Set<String> value = this.a;
            y5.getClass();
            Intrinsics.checkNotNullParameter(value, "value");
            y5.a.putStringSet(PreferencesKey.DEVELOPER_OVERRIDE_FEATURE_FLAGS_STATES, value);
            return Unit.INSTANCE;
        }
    }

    public final void a(View view) throws Resources.NotFoundException {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.contentsquare_override_feature_flags_list);
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            Y5 y5 = this.a;
            Y5 y52 = null;
            if (y5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                y5 = null;
            }
            Set<String> stringSet = y5.a.getStringSet(PreferencesKey.DEVELOPER_OVERRIDE_FEATURE_FLAGS_STATES, SetsKt.emptySet());
            if (stringSet == null) {
                stringSet = SetsKt.emptySet();
            }
            Set mutableSet = CollectionsKt.toMutableSet(stringSet);
            Y5 y53 = this.a;
            if (y53 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                y53 = null;
            }
            for (String str : y53.i) {
                Context context = linearLayout.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ContentsquareSwitchPreference contentsquareSwitchPreference = new ContentsquareSwitchPreference(context, null, 0, 6, null);
                contentsquareSwitchPreference.setSwitchContentDescription("contentsquare_switch_" + str);
                ((TextView) contentsquareSwitchPreference.findViewById(R.id.contentsquare_preference_title)).setText(str);
                contentsquareSwitchPreference.setPadding(0, 0, 0, contentsquareSwitchPreference.getResources().getDimensionPixelSize(R.dimen.contentsquare_value_24dp));
                contentsquareSwitchPreference.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                contentsquareSwitchPreference.setChecked(mutableSet.contains(str));
                contentsquareSwitchPreference.setOnSwitchStateChangeListener(new a(mutableSet, str, this));
                linearLayout.addView(contentsquareSwitchPreference);
            }
            Y5 y54 = this.a;
            if (y54 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            } else {
                y52 = y54;
            }
            if (y52.a.getBoolean(PreferencesKey.DEVELOPER_OVERRIDE_FEATURE_FLAGS_ENABLED, false)) {
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
        return inflater.inflate(R.layout.contentsquare_feature_flags_settings, viewGroup, false);
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
    public final void onViewCreated(@NotNull View view, @Nullable Bundle bundle) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.SettingsActivity");
        Y5 y5 = ((SettingsActivity) fragmentActivityRequireActivity).d;
        Y5 y52 = null;
        if (y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            y5 = null;
        }
        this.a = y5;
        ContentsquareSwitchPreference contentsquareSwitchPreference = (ContentsquareSwitchPreference) view.findViewById(R.id.contentsquare_override_feature_flags_preference);
        if (contentsquareSwitchPreference != null) {
            contentsquareSwitchPreference.setSwitchContentDescription("contentsquare_switch_override_feature_flags");
            Y5 y53 = this.a;
            if (y53 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            } else {
                y52 = y53;
            }
            contentsquareSwitchPreference.setChecked(y52.a.getBoolean(PreferencesKey.DEVELOPER_OVERRIDE_FEATURE_FLAGS_ENABLED, false));
            contentsquareSwitchPreference.setOnSwitchStateChangeListener(new O1(this, view));
        }
        a(view);
    }
}
