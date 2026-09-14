package com.contentsquare.android.sdk;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.contentsquare.android.C2362R;
import com.contentsquare.android.analytics.internal.features.clientmode.p018ui.settings.SettingsActivity;
import com.contentsquare.android.analytics.internal.features.clientmode.p018ui.settings.components.ContentsquareSeekBarPreference;
import com.contentsquare.android.analytics.internal.features.clientmode.p018ui.settings.components.ContentsquareSwitchPreference;
import com.contentsquare.android.core.features.config.model.QualityLevel;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.k6 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1836d2 = {"Lcom/contentsquare/android/sdk/k6;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "library_release"}, m1837k = 1, m1838mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSrSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SrSettingsFragment.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/settings/SrSettingsFragment\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,248:1\n49#2:249\n65#2,16:250\n93#2,3:266\n13579#3,2:269\n*S KotlinDebug\n*F\n+ 1 SrSettingsFragment.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/settings/SrSettingsFragment\n*L\n172#1:249\n172#1:250,16\n172#1:266,3\n200#1:269,2\n*E\n"})
public final class C2797k6 extends Fragment {

    /* JADX INFO: renamed from: a */
    public C2678Y5 f2828a;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.k6$a */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int[] f2829a;

        static {
            int[] iArr = new int[C2492F5.b.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f2829a = iArr;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.k6$b */
    public static final class b extends Lambda implements Function1<Integer, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Integer num) {
            int iIntValue = num.intValue();
            C2678Y5 c2678y5 = C2797k6.this.f2828a;
            if (c2678y5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                c2678y5 = null;
            }
            c2678y5.f2301a.putInt(PreferencesKey.DEVELOPER_SESSION_REPLAY_FPS_VALUE, iIntValue);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.k6$c */
    public static final class c extends Lambda implements Function1<Integer, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Integer num) {
            int iIntValue = num.intValue();
            C2678Y5 c2678y5 = C2797k6.this.f2828a;
            if (c2678y5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                c2678y5 = null;
            }
            c2678y5.f2301a.putInt(PreferencesKey.DEVELOPER_SESSION_REPLAY_IMAGE_QUALITY_VALUE, iIntValue);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1174a(View view) {
        ContentsquareSeekBarPreference contentsquareSeekBarPreference = (ContentsquareSeekBarPreference) view.findViewById(C2362R.id.contentsquare_session_replay_force_fps_preference);
        C2678Y5 c2678y5 = this.f2828a;
        C2678Y5 c2678y6 = null;
        if (c2678y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            c2678y5 = null;
        }
        if (!c2678y5.f2301a.getBoolean(PreferencesKey.DEVELOPER_SESSION_REPLAY_FORCE_QUALITY_LEVEL, false)) {
            if (contentsquareSeekBarPreference == null) {
                return;
            }
            contentsquareSeekBarPreference.setVisibility(8);
            return;
        }
        C2678Y5 c2678y7 = this.f2828a;
        if (c2678y7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
        } else {
            c2678y6 = c2678y7;
        }
        contentsquareSeekBarPreference.setCurrentValue(c2678y6.f2301a.getInt(PreferencesKey.DEVELOPER_SESSION_REPLAY_FPS_VALUE, QualityLevel.INSTANCE.valueOfIgnoreCase(c2678y6.m1074a()).getFPS()));
        contentsquareSeekBarPreference.setOnSeekBarChangeListener(new b());
        contentsquareSeekBarPreference.setVisibility(0);
    }

    /* JADX INFO: renamed from: b */
    public final void m1175b(View view) {
        ContentsquareSeekBarPreference contentsquareSeekBarPreference = (ContentsquareSeekBarPreference) view.findViewById(C2362R.id.contentsquare_session_replay_image_quality_preference);
        C2678Y5 c2678y5 = this.f2828a;
        C2678Y5 c2678y6 = null;
        if (c2678y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            c2678y5 = null;
        }
        if (!c2678y5.f2301a.getBoolean(PreferencesKey.DEVELOPER_SESSION_REPLAY_FORCE_QUALITY_LEVEL, false)) {
            if (contentsquareSeekBarPreference == null) {
                return;
            }
            contentsquareSeekBarPreference.setVisibility(8);
            return;
        }
        C2678Y5 c2678y7 = this.f2828a;
        if (c2678y7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
        } else {
            c2678y6 = c2678y7;
        }
        contentsquareSeekBarPreference.setCurrentValue(c2678y6.f2301a.getInt(PreferencesKey.DEVELOPER_SESSION_REPLAY_IMAGE_QUALITY_VALUE, QualityLevel.INSTANCE.valueOfIgnoreCase(c2678y6.m1074a()).ordinal()));
        contentsquareSeekBarPreference.setOnSeekBarChangeListener(new c());
        contentsquareSeekBarPreference.setVisibility(0);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public final View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C2362R.layout.contentsquare_sr_settings, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        InstrumentationCallbacks.onPauseCalled(this);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        C2678Y5 c2678y5;
        boolean zContains;
        InstrumentationCallbacks.onResumeCalled(this);
        super.onResume();
        View view = getView();
        if (view != null) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.SettingsActivity");
            C2678Y5 c2678y6 = ((SettingsActivity) fragmentActivityRequireActivity).f1182d;
            if (c2678y6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                c2678y6 = null;
            }
            this.f2828a = c2678y6;
            ContentsquareSwitchPreference contentsquareSwitchPreference = (ContentsquareSwitchPreference) view.findViewById(C2362R.id.contentsquare_session_replay_force_start_preference);
            if (contentsquareSwitchPreference != null) {
                C2678Y5 c2678y7 = this.f2828a;
                if (c2678y7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                    c2678y7 = null;
                }
                contentsquareSwitchPreference.setChecked(c2678y7.f2301a.getBoolean(PreferencesKey.SESSION_REPLAY_FORCE_START, false));
                contentsquareSwitchPreference.setOnSwitchStateChangeListener(new C2827n6(this));
            }
            ContentsquareSwitchPreference contentsquareSwitchPreference2 = (ContentsquareSwitchPreference) view.findViewById(C2362R.id.contentsquare_session_replay_default_masking_preference);
            if (contentsquareSwitchPreference2 != null) {
                C2678Y5 c2678y8 = this.f2828a;
                if (c2678y8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                    c2678y8 = null;
                }
                contentsquareSwitchPreference2.setChecked(c2678y8.f2301a.getBoolean(PreferencesKey.SESSION_REPLAY_DEFAULT_MASKING, false));
                contentsquareSwitchPreference2.setOnSwitchStateChangeListener(new C2817m6(this));
            }
            ContentsquareSwitchPreference contentsquareSwitchPreference3 = (ContentsquareSwitchPreference) view.findViewById(C2362R.id.contentsquare_session_replay_animation_detection_preference);
            if (contentsquareSwitchPreference3 != null) {
                C2678Y5 c2678y9 = this.f2828a;
                if (c2678y9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                    c2678y9 = null;
                }
                contentsquareSwitchPreference3.setChecked(c2678y9.f2301a.getBoolean(PreferencesKey.DEVELOPER_SESSION_REPLAY_FORCE_ANIMATION_DETECTION, false));
                contentsquareSwitchPreference3.setOnSwitchStateChangeListener(new C2807l6(this));
            }
            ContentsquareSwitchPreference contentsquareSwitchPreference4 = (ContentsquareSwitchPreference) view.findViewById(C2362R.id.contentsquare_session_replay_force_quality_preference);
            if (contentsquareSwitchPreference4 != null) {
                C2678Y5 c2678y10 = this.f2828a;
                if (c2678y10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                    c2678y10 = null;
                }
                contentsquareSwitchPreference4.setChecked(c2678y10.f2301a.getBoolean(PreferencesKey.DEVELOPER_SESSION_REPLAY_FORCE_QUALITY_LEVEL, false));
                contentsquareSwitchPreference4.setOnSwitchStateChangeListener(new C2837o6(this, view));
            }
            AppCompatSpinner appCompatSpinner = (AppCompatSpinner) view.findViewById(C2362R.id.contentsquare_session_replay_preset_url_preference);
            ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(appCompatSpinner.getContext(), C2362R.array.contentsquare_developer_session_replay_preset_url_types, R.layout.simple_spinner_item);
            arrayAdapterCreateFromResource.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            appCompatSpinner.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource);
            String[] stringArray = appCompatSpinner.getContext().getResources().getStringArray(C2362R.array.contentsquare_developer_session_replay_preset_url_values);
            Intrinsics.checkNotNullExpressionValue(stringArray, "context.resources\n      …replay_preset_url_values)");
            List list = ArraysKt.toList(stringArray);
            C2678Y5 c2678y11 = this.f2828a;
            if (c2678y11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                c2678y11 = null;
            }
            String string = c2678y11.f2301a.getString(PreferencesKey.DEVELOPER_SESSION_REPLAY_PRESET_URL, PreferencesStore.DefaultValue.SR_URL_PRESET_FROM_CONFIG);
            Intrinsics.checkNotNull(string);
            appCompatSpinner.setSelection(list.indexOf(string));
            appCompatSpinner.setOnItemSelectedListener(new C2867r6(this, list, view));
            m1174a(view);
            m1175b(view);
            ContentsquareSeekBarPreference contentsquareSeekBarPreference = (ContentsquareSeekBarPreference) view.findViewById(C2362R.id.contentsquare_session_replay_ui_thread_usage_preference);
            C2678Y5 c2678y12 = this.f2828a;
            if (c2678y12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                c2678y12 = null;
            }
            contentsquareSeekBarPreference.setCurrentValue(c2678y12.f2301a.getInt(PreferencesKey.DEVELOPER_SESSION_REPLAY_MAXIMUM_USAGE_ON_UI_THREAD_IN_MILLI_SEC, 40));
            contentsquareSeekBarPreference.setOnSeekBarChangeListener(new C2857q6(this));
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C2362R.id.contentsquare_session_replay_profiler_switches);
            ContentsquareSwitchPreference contentsquareSwitchPreference5 = (ContentsquareSwitchPreference) view.findViewById(C2362R.id.contentsquare_session_replay_profiler_enabled);
            C2678Y5 c2678y13 = this.f2828a;
            if (c2678y13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                c2678y13 = null;
            }
            contentsquareSwitchPreference5.setChecked(c2678y13.f2307g.f1950b);
            contentsquareSwitchPreference5.setOnSwitchStateChangeListener(new C2877s6(this, linearLayout));
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C2362R.id.contentsquare_session_replay_profiler_switches);
            if (linearLayout2 != null) {
                for (C2492F5.b bVar : C2492F5.b.values()) {
                    if (a.f2829a[bVar.ordinal()] != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Pair pairM1842to = TuplesKt.m1842to(Integer.valueOf(C2362R.string.f1123x741ffef), Integer.valueOf(C2362R.string.f1122x1df37b7d));
                    int iIntValue = ((Number) pairM1842to.component1()).intValue();
                    int iIntValue2 = ((Number) pairM1842to.component2()).intValue();
                    Context context = linearLayout2.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "container.context");
                    ContentsquareSwitchPreference contentsquareSwitchPreference6 = new ContentsquareSwitchPreference(context, null, 0, 6, null);
                    C2678Y5 c2678y14 = this.f2828a;
                    if (c2678y14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                        c2678y14 = null;
                    }
                    C2492F5 c2492f5 = c2678y14.f2307g;
                    synchronized (c2492f5) {
                        zContains = c2492f5.f1949a.contains(bVar);
                    }
                    contentsquareSwitchPreference6.setChecked(zContains);
                    contentsquareSwitchPreference6.setTitle(iIntValue);
                    contentsquareSwitchPreference6.setSummary(iIntValue2);
                    contentsquareSwitchPreference6.setOnSwitchStateChangeListener(new C2887t6(this, bVar));
                    contentsquareSwitchPreference6.setPadding(0, 0, 0, contentsquareSwitchPreference6.getResources().getDimensionPixelSize(C2362R.dimen.contentsquare_value_24dp));
                    contentsquareSwitchPreference6.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    linearLayout2.addView(contentsquareSwitchPreference6);
                }
                C2678Y5 c2678y15 = this.f2828a;
                if (c2678y15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                    c2678y15 = null;
                }
                if (c2678y15.f2307g.f1950b) {
                    linearLayout2.setVisibility(0);
                } else {
                    linearLayout2.setVisibility(8);
                }
            }
            ContentsquareSwitchPreference contentsquareSwitchPreference7 = (ContentsquareSwitchPreference) view.findViewById(C2362R.id.contentsquare_session_replay_logs_tree);
            C2678Y5 c2678y16 = this.f2828a;
            if (c2678y16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                c2678y5 = null;
            } else {
                c2678y5 = c2678y16;
            }
            contentsquareSwitchPreference7.setChecked(c2678y5.f2301a.getBoolean(PreferencesKey.DEVELOPER_SESSION_REPLAY_LOG_VIEWLIGHT_TREE, false));
            contentsquareSwitchPreference7.setOnSwitchStateChangeListener(new C2847p6(this));
        }
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
}
