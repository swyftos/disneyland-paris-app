package com.contentsquare.android.sdk;

import android.content.Context;
import android.content.res.Resources;
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
import com.contentsquare.android.R;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.SettingsActivity;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.components.ContentsquareSeekBarPreference;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.components.ContentsquareSwitchPreference;
import com.contentsquare.android.core.features.config.model.QualityLevel;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.sdk.F5;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/android/sdk/k6;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "library_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSrSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SrSettingsFragment.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/settings/SrSettingsFragment\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,248:1\n49#2:249\n65#2,16:250\n93#2,3:266\n13579#3,2:269\n*S KotlinDebug\n*F\n+ 1 SrSettingsFragment.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/settings/SrSettingsFragment\n*L\n172#1:249\n172#1:250,16\n172#1:266,3\n200#1:269,2\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.k6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0727k6 extends Fragment {
    public Y5 a;

    /* renamed from: com.contentsquare.android.sdk.k6$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[F5.b.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    /* renamed from: com.contentsquare.android.sdk.k6$b */
    public static final class b extends Lambda implements Function1<Integer, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Integer num) {
            int iIntValue = num.intValue();
            Y5 y5 = C0727k6.this.a;
            if (y5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                y5 = null;
            }
            y5.a.putInt(PreferencesKey.DEVELOPER_SESSION_REPLAY_FPS_VALUE, iIntValue);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.contentsquare.android.sdk.k6$c */
    public static final class c extends Lambda implements Function1<Integer, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Integer num) {
            int iIntValue = num.intValue();
            Y5 y5 = C0727k6.this.a;
            if (y5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                y5 = null;
            }
            y5.a.putInt(PreferencesKey.DEVELOPER_SESSION_REPLAY_IMAGE_QUALITY_VALUE, iIntValue);
            return Unit.INSTANCE;
        }
    }

    public final void a(View view) {
        ContentsquareSeekBarPreference contentsquareSeekBarPreference = (ContentsquareSeekBarPreference) view.findViewById(R.id.contentsquare_session_replay_force_fps_preference);
        Y5 y5 = this.a;
        Y5 y52 = null;
        if (y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            y5 = null;
        }
        if (!y5.a.getBoolean(PreferencesKey.DEVELOPER_SESSION_REPLAY_FORCE_QUALITY_LEVEL, false)) {
            if (contentsquareSeekBarPreference == null) {
                return;
            }
            contentsquareSeekBarPreference.setVisibility(8);
            return;
        }
        Y5 y53 = this.a;
        if (y53 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
        } else {
            y52 = y53;
        }
        contentsquareSeekBarPreference.setCurrentValue(y52.a.getInt(PreferencesKey.DEVELOPER_SESSION_REPLAY_FPS_VALUE, QualityLevel.INSTANCE.valueOfIgnoreCase(y52.a()).getFPS()));
        contentsquareSeekBarPreference.setOnSeekBarChangeListener(new b());
        contentsquareSeekBarPreference.setVisibility(0);
    }

    public final void b(View view) {
        ContentsquareSeekBarPreference contentsquareSeekBarPreference = (ContentsquareSeekBarPreference) view.findViewById(R.id.contentsquare_session_replay_image_quality_preference);
        Y5 y5 = this.a;
        Y5 y52 = null;
        if (y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            y5 = null;
        }
        if (!y5.a.getBoolean(PreferencesKey.DEVELOPER_SESSION_REPLAY_FORCE_QUALITY_LEVEL, false)) {
            if (contentsquareSeekBarPreference == null) {
                return;
            }
            contentsquareSeekBarPreference.setVisibility(8);
            return;
        }
        Y5 y53 = this.a;
        if (y53 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
        } else {
            y52 = y53;
        }
        contentsquareSeekBarPreference.setCurrentValue(y52.a.getInt(PreferencesKey.DEVELOPER_SESSION_REPLAY_IMAGE_QUALITY_VALUE, QualityLevel.INSTANCE.valueOfIgnoreCase(y52.a()).ordinal()));
        contentsquareSeekBarPreference.setOnSeekBarChangeListener(new c());
        contentsquareSeekBarPreference.setVisibility(0);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public final View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.contentsquare_sr_settings, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        InstrumentationCallbacks.onPauseCalled(this);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() throws Resources.NotFoundException {
        Y5 y5;
        boolean zContains;
        InstrumentationCallbacks.onResumeCalled(this);
        super.onResume();
        View view = getView();
        if (view != null) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.SettingsActivity");
            Y5 y52 = ((SettingsActivity) fragmentActivityRequireActivity).d;
            if (y52 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                y52 = null;
            }
            this.a = y52;
            ContentsquareSwitchPreference contentsquareSwitchPreference = (ContentsquareSwitchPreference) view.findViewById(R.id.contentsquare_session_replay_force_start_preference);
            if (contentsquareSwitchPreference != null) {
                Y5 y53 = this.a;
                if (y53 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                    y53 = null;
                }
                contentsquareSwitchPreference.setChecked(y53.a.getBoolean(PreferencesKey.SESSION_REPLAY_FORCE_START, false));
                contentsquareSwitchPreference.setOnSwitchStateChangeListener(new C0757n6(this));
            }
            ContentsquareSwitchPreference contentsquareSwitchPreference2 = (ContentsquareSwitchPreference) view.findViewById(R.id.contentsquare_session_replay_default_masking_preference);
            if (contentsquareSwitchPreference2 != null) {
                Y5 y54 = this.a;
                if (y54 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                    y54 = null;
                }
                contentsquareSwitchPreference2.setChecked(y54.a.getBoolean(PreferencesKey.SESSION_REPLAY_DEFAULT_MASKING, false));
                contentsquareSwitchPreference2.setOnSwitchStateChangeListener(new C0747m6(this));
            }
            ContentsquareSwitchPreference contentsquareSwitchPreference3 = (ContentsquareSwitchPreference) view.findViewById(R.id.contentsquare_session_replay_animation_detection_preference);
            if (contentsquareSwitchPreference3 != null) {
                Y5 y55 = this.a;
                if (y55 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                    y55 = null;
                }
                contentsquareSwitchPreference3.setChecked(y55.a.getBoolean(PreferencesKey.DEVELOPER_SESSION_REPLAY_FORCE_ANIMATION_DETECTION, false));
                contentsquareSwitchPreference3.setOnSwitchStateChangeListener(new C0737l6(this));
            }
            ContentsquareSwitchPreference contentsquareSwitchPreference4 = (ContentsquareSwitchPreference) view.findViewById(R.id.contentsquare_session_replay_force_quality_preference);
            if (contentsquareSwitchPreference4 != null) {
                Y5 y56 = this.a;
                if (y56 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                    y56 = null;
                }
                contentsquareSwitchPreference4.setChecked(y56.a.getBoolean(PreferencesKey.DEVELOPER_SESSION_REPLAY_FORCE_QUALITY_LEVEL, false));
                contentsquareSwitchPreference4.setOnSwitchStateChangeListener(new C0767o6(this, view));
            }
            AppCompatSpinner appCompatSpinner = (AppCompatSpinner) view.findViewById(R.id.contentsquare_session_replay_preset_url_preference);
            ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(appCompatSpinner.getContext(), R.array.contentsquare_developer_session_replay_preset_url_types, android.R.layout.simple_spinner_item);
            arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            appCompatSpinner.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource);
            String[] stringArray = appCompatSpinner.getContext().getResources().getStringArray(R.array.contentsquare_developer_session_replay_preset_url_values);
            Intrinsics.checkNotNullExpressionValue(stringArray, "context.resources\n      …replay_preset_url_values)");
            List list = ArraysKt.toList(stringArray);
            Y5 y57 = this.a;
            if (y57 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                y57 = null;
            }
            String string = y57.a.getString(PreferencesKey.DEVELOPER_SESSION_REPLAY_PRESET_URL, PreferencesStore.DefaultValue.SR_URL_PRESET_FROM_CONFIG);
            Intrinsics.checkNotNull(string);
            appCompatSpinner.setSelection(list.indexOf(string));
            appCompatSpinner.setOnItemSelectedListener(new C0796r6(this, list, view));
            a(view);
            b(view);
            ContentsquareSeekBarPreference contentsquareSeekBarPreference = (ContentsquareSeekBarPreference) view.findViewById(R.id.contentsquare_session_replay_ui_thread_usage_preference);
            Y5 y58 = this.a;
            if (y58 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                y58 = null;
            }
            contentsquareSeekBarPreference.setCurrentValue(y58.a.getInt(PreferencesKey.DEVELOPER_SESSION_REPLAY_MAXIMUM_USAGE_ON_UI_THREAD_IN_MILLI_SEC, 40));
            contentsquareSeekBarPreference.setOnSeekBarChangeListener(new C0787q6(this));
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.contentsquare_session_replay_profiler_switches);
            ContentsquareSwitchPreference contentsquareSwitchPreference5 = (ContentsquareSwitchPreference) view.findViewById(R.id.contentsquare_session_replay_profiler_enabled);
            Y5 y59 = this.a;
            if (y59 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                y59 = null;
            }
            contentsquareSwitchPreference5.setChecked(y59.g.b);
            contentsquareSwitchPreference5.setOnSwitchStateChangeListener(new C0806s6(this, linearLayout));
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.contentsquare_session_replay_profiler_switches);
            if (linearLayout2 != null) {
                for (F5.b bVar : F5.b.values()) {
                    if (a.a[bVar.ordinal()] != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Pair pair = TuplesKt.to(Integer.valueOf(R.string.contentsquare_session_replay_profiler_key_android_view_to_view_light_process_title), Integer.valueOf(R.string.contentsquare_session_replay_profiler_key_android_view_to_view_light_process_summary));
                    int iIntValue = ((Number) pair.component1()).intValue();
                    int iIntValue2 = ((Number) pair.component2()).intValue();
                    Context context = linearLayout2.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "container.context");
                    ContentsquareSwitchPreference contentsquareSwitchPreference6 = new ContentsquareSwitchPreference(context, null, 0, 6, null);
                    Y5 y510 = this.a;
                    if (y510 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                        y510 = null;
                    }
                    F5 f5 = y510.g;
                    synchronized (f5) {
                        zContains = f5.a.contains(bVar);
                    }
                    contentsquareSwitchPreference6.setChecked(zContains);
                    contentsquareSwitchPreference6.setTitle(iIntValue);
                    contentsquareSwitchPreference6.setSummary(iIntValue2);
                    contentsquareSwitchPreference6.setOnSwitchStateChangeListener(new C0816t6(this, bVar));
                    contentsquareSwitchPreference6.setPadding(0, 0, 0, contentsquareSwitchPreference6.getResources().getDimensionPixelSize(R.dimen.contentsquare_value_24dp));
                    contentsquareSwitchPreference6.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    linearLayout2.addView(contentsquareSwitchPreference6);
                }
                Y5 y511 = this.a;
                if (y511 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                    y511 = null;
                }
                if (y511.g.b) {
                    linearLayout2.setVisibility(0);
                } else {
                    linearLayout2.setVisibility(8);
                }
            }
            ContentsquareSwitchPreference contentsquareSwitchPreference7 = (ContentsquareSwitchPreference) view.findViewById(R.id.contentsquare_session_replay_logs_tree);
            Y5 y512 = this.a;
            if (y512 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                y5 = null;
            } else {
                y5 = y512;
            }
            contentsquareSwitchPreference7.setChecked(y5.a.getBoolean(PreferencesKey.DEVELOPER_SESSION_REPLAY_LOG_VIEWLIGHT_TREE, false));
            contentsquareSwitchPreference7.setOnSwitchStateChangeListener(new C0777p6(this));
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
