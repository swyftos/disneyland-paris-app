package com.contentsquare.android.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.contentsquare.android.C2362R;
import com.contentsquare.android.analytics.internal.features.clientmode.p018ui.deactivationdialog.DeactivationActivity;
import com.contentsquare.android.analytics.internal.features.clientmode.p018ui.settings.SettingsActivity;
import com.contentsquare.android.analytics.internal.features.clientmode.p018ui.settings.components.ContentsquareSeekBarPreference;
import com.contentsquare.android.analytics.internal.features.clientmode.p018ui.settings.components.ContentsquareSwitchPreference;
import com.contentsquare.android.analytics.internal.features.clientmode.p018ui.settings.components.ContentsquareTextPreference;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.V5 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1836d2 = {"Lcom/contentsquare/android/sdk/V5;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "library_release"}, m1837k = 1, m1838mv = {1, 8, 0})
public final class C2651V5 extends Fragment {

    /* JADX INFO: renamed from: a */
    public C2678Y5 f2193a;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.V5$a */
    public static final class a extends Lambda implements Function1<Intent, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Intent intent) {
            Intent intent2 = intent;
            Intrinsics.checkNotNullParameter(intent2, "intent");
            FragmentActivity activity = C2651V5.this.getActivity();
            if (activity != null) {
                activity.startActivity(Intent.createChooser(intent2, null));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1051a(View view, boolean z) {
        ContentsquareTextPreference contentsquareTextPreference = (ContentsquareTextPreference) view.findViewById(C2362R.id.contentsquare_log_visualizer_identifier);
        if (contentsquareTextPreference != null) {
            if (!z) {
                contentsquareTextPreference.setVisibility(8);
                return;
            }
            contentsquareTextPreference.setVisibility(0);
            C2678Y5 c2678y5 = this.f2193a;
            if (c2678y5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                c2678y5 = null;
            }
            String strM979a = new C2554L7(c2678y5.f2301a).m979a();
            if (strM979a.length() > 6) {
                strM979a = strM979a.substring(strM979a.length() - 6);
                Intrinsics.checkNotNullExpressionValue(strM979a, "this as java.lang.String).substring(startIndex)");
            }
            contentsquareTextPreference.setSummaryText(strM979a);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m1052b(View view) {
        Button button = (Button) view.findViewById(C2362R.id.contentsquare_feature_flags_preferences);
        if (button != null) {
            InstrumentationCallbacks.setOnClickListenerCalled(button, new View.OnClickListener() { // from class: com.contentsquare.android.sdk.V5$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    C2651V5.m1046b(this.f$0, view2);
                }
            });
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m1053c(View view) {
        ContentsquareTextPreference contentsquareTextPreference = (ContentsquareTextPreference) view.findViewById(C2362R.id.contentsquare_session_replay_link_copy_preference);
        if (contentsquareTextPreference != null) {
            if (C2462C5.f1468k == null) {
                contentsquareTextPreference.setEnabled(false);
                contentsquareTextPreference.setSummaryVisible(false);
                contentsquareTextPreference.setTitle(C2362R.string.contentsquare_settings_replay_link_summary_disabled);
            } else {
                contentsquareTextPreference.setTitle(C2362R.string.contentsquare_settings_replay_link_title);
                contentsquareTextPreference.setSummary(C2362R.string.contentsquare_settings_replay_link_summary_enabled);
                contentsquareTextPreference.setSummaryVisible(true);
                InstrumentationCallbacks.setOnClickListenerCalled(contentsquareTextPreference, new View.OnClickListener() { // from class: com.contentsquare.android.sdk.V5$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        C2651V5.m1047c(this.f$0, view2);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m1054d(View view) {
        ContentsquareTextPreference contentsquareTextPreference = (ContentsquareTextPreference) view.findViewById(C2362R.id.contentsquare_send_debug_log_button);
        if (contentsquareTextPreference != null) {
            InstrumentationCallbacks.setOnClickListenerCalled(contentsquareTextPreference, new View.OnClickListener() { // from class: com.contentsquare.android.sdk.V5$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    C2651V5.m1048d(this.f$0, view2);
                }
            });
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m1055e(View view) {
        Button button = (Button) view.findViewById(C2362R.id.contentsquare_sr_preferences);
        if (button != null) {
            InstrumentationCallbacks.setOnClickListenerCalled(button, new View.OnClickListener() { // from class: com.contentsquare.android.sdk.V5$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    C2651V5.m1049e(this.f$0, view2);
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public final View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C2362R.layout.contentsquare_settings, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        InstrumentationCallbacks.onPauseCalled(this);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        InstrumentationCallbacks.onResumeCalled(this);
        super.onResume();
        View view = getView();
        if (view != null) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.SettingsActivity");
            C2678Y5 c2678y5 = ((SettingsActivity) fragmentActivityRequireActivity).f1182d;
            C2678Y5 c2678y6 = null;
            if (c2678y5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                c2678y5 = null;
            }
            this.f2193a = c2678y5;
            m1054d(view);
            ContentsquareSeekBarPreference contentsquareSeekBarPreference = (ContentsquareSeekBarPreference) view.findViewById(C2362R.id.contentsquare_long_snapshot_scroll_delay_preference);
            C2678Y5 c2678y7 = this.f2193a;
            if (c2678y7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                c2678y7 = null;
            }
            contentsquareSeekBarPreference.setCurrentValue(c2678y7.f2301a.getInt(PreferencesKey.CLIENT_MODE_LONG_SNAPSHOT_SCROLL_DELAY_MILLISECONDS, 0));
            contentsquareSeekBarPreference.setOnSeekBarChangeListener(new C2631T5(this));
            m1050a(view);
            m1053c(view);
            C2678Y5 c2678y8 = this.f2193a;
            if (c2678y8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                c2678y8 = null;
            }
            boolean zIsFeatureFlagEnabled = c2678y8.f2304d.isFeatureFlagEnabled(JsonConfigFeatureFlagNames.SESSION_RECORDING_ENABLED);
            ContentsquareSwitchPreference contentsquareSwitchPreference = (ContentsquareSwitchPreference) view.findViewById(C2362R.id.contentsquare_session_replay_mode_preference);
            if (contentsquareSwitchPreference != null) {
                if (zIsFeatureFlagEnabled) {
                    C2678Y5 c2678y9 = this.f2193a;
                    if (c2678y9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                        c2678y9 = null;
                    }
                    contentsquareSwitchPreference.setChecked(c2678y9.f2301a.getBoolean(PreferencesKey.LOCAL_SESSION_REPLAY_MODE, false));
                    contentsquareSwitchPreference.setOnSwitchStateChangeListener(new C2611R5(this));
                } else {
                    contentsquareSwitchPreference.setVisibility(8);
                }
            }
            ContentsquareSwitchPreference contentsquareSwitchPreference2 = (ContentsquareSwitchPreference) view.findViewById(C2362R.id.contentsquare_log_visualizer_preference);
            if (contentsquareSwitchPreference2 != null) {
                C2678Y5 c2678y10 = this.f2193a;
                if (c2678y10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                    c2678y10 = null;
                }
                contentsquareSwitchPreference2.setChecked(c2678y10.f2301a.getBoolean(PreferencesKey.LOCAL_LOG_VISUALIZER_MODE, false));
                contentsquareSwitchPreference2.setOnSwitchStateChangeListener(new C2621S5(this, view));
            }
            C2678Y5 c2678y11 = this.f2193a;
            if (c2678y11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                c2678y11 = null;
            }
            m1051a(view, c2678y11.f2301a.getBoolean(PreferencesKey.LOCAL_LOG_VISUALIZER_MODE, false));
            ViewGroup viewGroup = (ViewGroup) view.findViewById(C2362R.id.contentsquare_developer_category);
            C2678Y5 c2678y12 = this.f2193a;
            if (c2678y12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                c2678y12 = null;
            }
            if (c2678y12.f2301a.getBoolean(PreferencesKey.DEVELOPER_MODE_ACTIVATION_STATE, false)) {
                ContentsquareSwitchPreference contentsquareSwitchPreference3 = (ContentsquareSwitchPreference) view.findViewById(C2362R.id.contentsquare_screengraph_optimization_preference);
                if (contentsquareSwitchPreference3 != null) {
                    C2678Y5 c2678y13 = this.f2193a;
                    if (c2678y13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                        c2678y13 = null;
                    }
                    contentsquareSwitchPreference3.setChecked(c2678y13.f2301a.getBoolean(PreferencesKey.CLIENT_MODE_SCREENGRAPH_OPTIMIZATION_MODE, false));
                    contentsquareSwitchPreference3.setOnSwitchStateChangeListener(new C2641U5(this));
                }
                ContentsquareSwitchPreference contentsquareSwitchPreference4 = (ContentsquareSwitchPreference) view.findViewById(C2362R.id.contentsquare_session_timeout_zero_seconds_preference);
                if (contentsquareSwitchPreference4 != null) {
                    C2678Y5 c2678y14 = this.f2193a;
                    if (c2678y14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                    } else {
                        c2678y6 = c2678y14;
                    }
                    contentsquareSwitchPreference4.setChecked(c2678y6.f2301a.getBoolean(PreferencesKey.DEVELOPER_SESSION_TIMEOUT_TO_0, false));
                    contentsquareSwitchPreference4.setOnSwitchStateChangeListener(new C2660W5(this));
                }
                m1055e(view);
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
            } else if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            m1052b(view);
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

    /* JADX INFO: renamed from: b */
    public static final void m1046b(C2651V5 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getParentFragmentManager().beginTransaction().replace(C2362R.id.container, new C2568N1()).addToBackStack(null).commit();
    }

    /* JADX INFO: renamed from: d */
    public static final void m1048d(C2651V5 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            C2678Y5 c2678y5 = this$0.f2193a;
            if (c2678y5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                c2678y5 = null;
            }
            C2678Y5 c2678y6 = c2678y5;
            String appFilesDir = context.getFilesDir().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(appFilesDir, "safeContext.filesDir.absolutePath");
            a onIntentReady = this$0.new a();
            c2678y6.getClass();
            Intrinsics.checkNotNullParameter(appFilesDir, "appFilesDir");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(onIntentReady, "onIntentReady");
            BuildersKt__Builders_commonKt.launch$default(c2678y6.f2308h, null, null, new C2669X5(appFilesDir, c2678y6, context, onIntentReady, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: e */
    public static final void m1049e(C2651V5 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getParentFragmentManager().beginTransaction().replace(C2362R.id.container, new C2797k6()).addToBackStack(null).commit();
    }

    /* JADX INFO: renamed from: c */
    public static final void m1047c(C2651V5 this$0, View view) {
        String strM1164a;
        C2787j6 c2787j6;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getClass();
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        C2678Y5 c2678y5 = this$0.f2193a;
        if (c2678y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            c2678y5 = null;
        }
        C2462C5 c2462c5 = c2678y5.f2305e;
        if (c2462c5 == null || (c2787j6 = c2462c5.f1481i) == null || (strM1164a = c2787j6.m1164a()) == null) {
            strM1164a = "INACTIVE";
        }
        intent.putExtra("android.intent.extra.TEXT", strM1164a);
        intent.setType("text/plain");
        this$0.startActivity(Intent.createChooser(intent, null));
    }

    /* JADX INFO: renamed from: a */
    public final void m1050a(View view) {
        TextView textView = (TextView) view.findViewById(C2362R.id.contentsquare_disable_in_app_features);
        if (textView != null) {
            InstrumentationCallbacks.setOnClickListenerCalled(textView, new View.OnClickListener() { // from class: com.contentsquare.android.sdk.V5$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    C2651V5.m1045a(this.f$0, view2);
                }
            });
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m1045a(C2651V5 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.getActivity(), (Class<?>) DeactivationActivity.class));
    }
}
