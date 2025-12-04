package com.contentsquare.android.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.contentsquare.android.R;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.deactivationdialog.DeactivationActivity;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.SettingsActivity;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.components.ContentsquareSeekBarPreference;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.components.ContentsquareSwitchPreference;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.components.ContentsquareTextPreference;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/android/sdk/V5;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "library_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class V5 extends Fragment {
    public Y5 a;

    public static final class a extends Lambda implements Function1<Intent, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Intent intent) {
            Intent intent2 = intent;
            Intrinsics.checkNotNullParameter(intent2, "intent");
            FragmentActivity activity = V5.this.getActivity();
            if (activity != null) {
                activity.startActivity(Intent.createChooser(intent2, null));
            }
            return Unit.INSTANCE;
        }
    }

    public final void a(View view, boolean z) {
        ContentsquareTextPreference contentsquareTextPreference = (ContentsquareTextPreference) view.findViewById(R.id.contentsquare_log_visualizer_identifier);
        if (contentsquareTextPreference != null) {
            if (!z) {
                contentsquareTextPreference.setVisibility(8);
                return;
            }
            contentsquareTextPreference.setVisibility(0);
            Y5 y5 = this.a;
            if (y5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                y5 = null;
            }
            String strA = new L7(y5.a).a();
            if (strA.length() > 6) {
                strA = strA.substring(strA.length() - 6);
                Intrinsics.checkNotNullExpressionValue(strA, "this as java.lang.String).substring(startIndex)");
            }
            contentsquareTextPreference.setSummaryText(strA);
        }
    }

    public final void b(View view) {
        Button button = (Button) view.findViewById(R.id.contentsquare_feature_flags_preferences);
        if (button != null) {
            InstrumentationCallbacks.setOnClickListenerCalled(button, new View.OnClickListener() { // from class: com.contentsquare.android.sdk.V5$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    V5.b(this.f$0, view2);
                }
            });
        }
    }

    public final void c(View view) {
        ContentsquareTextPreference contentsquareTextPreference = (ContentsquareTextPreference) view.findViewById(R.id.contentsquare_session_replay_link_copy_preference);
        if (contentsquareTextPreference != null) {
            if (C5.k == null) {
                contentsquareTextPreference.setEnabled(false);
                contentsquareTextPreference.setSummaryVisible(false);
                contentsquareTextPreference.setTitle(R.string.contentsquare_settings_replay_link_summary_disabled);
            } else {
                contentsquareTextPreference.setTitle(R.string.contentsquare_settings_replay_link_title);
                contentsquareTextPreference.setSummary(R.string.contentsquare_settings_replay_link_summary_enabled);
                contentsquareTextPreference.setSummaryVisible(true);
                InstrumentationCallbacks.setOnClickListenerCalled(contentsquareTextPreference, new View.OnClickListener() { // from class: com.contentsquare.android.sdk.V5$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        V5.c(this.f$0, view2);
                    }
                });
            }
        }
    }

    public final void d(View view) {
        ContentsquareTextPreference contentsquareTextPreference = (ContentsquareTextPreference) view.findViewById(R.id.contentsquare_send_debug_log_button);
        if (contentsquareTextPreference != null) {
            InstrumentationCallbacks.setOnClickListenerCalled(contentsquareTextPreference, new View.OnClickListener() { // from class: com.contentsquare.android.sdk.V5$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    V5.d(this.f$0, view2);
                }
            });
        }
    }

    public final void e(View view) {
        Button button = (Button) view.findViewById(R.id.contentsquare_sr_preferences);
        if (button != null) {
            InstrumentationCallbacks.setOnClickListenerCalled(button, new View.OnClickListener() { // from class: com.contentsquare.android.sdk.V5$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    V5.e(this.f$0, view2);
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public final View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.contentsquare_settings, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        InstrumentationCallbacks.onPauseCalled(this);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() throws Resources.NotFoundException {
        InstrumentationCallbacks.onResumeCalled(this);
        super.onResume();
        View view = getView();
        if (view != null) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.SettingsActivity");
            Y5 y5 = ((SettingsActivity) fragmentActivityRequireActivity).d;
            Y5 y52 = null;
            if (y5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                y5 = null;
            }
            this.a = y5;
            d(view);
            ContentsquareSeekBarPreference contentsquareSeekBarPreference = (ContentsquareSeekBarPreference) view.findViewById(R.id.contentsquare_long_snapshot_scroll_delay_preference);
            Y5 y53 = this.a;
            if (y53 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                y53 = null;
            }
            contentsquareSeekBarPreference.setCurrentValue(y53.a.getInt(PreferencesKey.CLIENT_MODE_LONG_SNAPSHOT_SCROLL_DELAY_MILLISECONDS, 0));
            contentsquareSeekBarPreference.setOnSeekBarChangeListener(new T5(this));
            a(view);
            c(view);
            Y5 y54 = this.a;
            if (y54 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                y54 = null;
            }
            boolean zIsFeatureFlagEnabled = y54.d.isFeatureFlagEnabled(JsonConfigFeatureFlagNames.SESSION_RECORDING_ENABLED);
            ContentsquareSwitchPreference contentsquareSwitchPreference = (ContentsquareSwitchPreference) view.findViewById(R.id.contentsquare_session_replay_mode_preference);
            if (contentsquareSwitchPreference != null) {
                if (zIsFeatureFlagEnabled) {
                    Y5 y55 = this.a;
                    if (y55 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                        y55 = null;
                    }
                    contentsquareSwitchPreference.setChecked(y55.a.getBoolean(PreferencesKey.LOCAL_SESSION_REPLAY_MODE, false));
                    contentsquareSwitchPreference.setOnSwitchStateChangeListener(new R5(this));
                } else {
                    contentsquareSwitchPreference.setVisibility(8);
                }
            }
            ContentsquareSwitchPreference contentsquareSwitchPreference2 = (ContentsquareSwitchPreference) view.findViewById(R.id.contentsquare_log_visualizer_preference);
            if (contentsquareSwitchPreference2 != null) {
                Y5 y56 = this.a;
                if (y56 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                    y56 = null;
                }
                contentsquareSwitchPreference2.setChecked(y56.a.getBoolean(PreferencesKey.LOCAL_LOG_VISUALIZER_MODE, false));
                contentsquareSwitchPreference2.setOnSwitchStateChangeListener(new S5(this, view));
            }
            Y5 y57 = this.a;
            if (y57 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                y57 = null;
            }
            a(view, y57.a.getBoolean(PreferencesKey.LOCAL_LOG_VISUALIZER_MODE, false));
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.contentsquare_developer_category);
            Y5 y58 = this.a;
            if (y58 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                y58 = null;
            }
            if (y58.a.getBoolean(PreferencesKey.DEVELOPER_MODE_ACTIVATION_STATE, false)) {
                ContentsquareSwitchPreference contentsquareSwitchPreference3 = (ContentsquareSwitchPreference) view.findViewById(R.id.contentsquare_screengraph_optimization_preference);
                if (contentsquareSwitchPreference3 != null) {
                    Y5 y59 = this.a;
                    if (y59 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                        y59 = null;
                    }
                    contentsquareSwitchPreference3.setChecked(y59.a.getBoolean(PreferencesKey.CLIENT_MODE_SCREENGRAPH_OPTIMIZATION_MODE, false));
                    contentsquareSwitchPreference3.setOnSwitchStateChangeListener(new U5(this));
                }
                ContentsquareSwitchPreference contentsquareSwitchPreference4 = (ContentsquareSwitchPreference) view.findViewById(R.id.contentsquare_session_timeout_zero_seconds_preference);
                if (contentsquareSwitchPreference4 != null) {
                    Y5 y510 = this.a;
                    if (y510 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                    } else {
                        y52 = y510;
                    }
                    contentsquareSwitchPreference4.setChecked(y52.a.getBoolean(PreferencesKey.DEVELOPER_SESSION_TIMEOUT_TO_0, false));
                    contentsquareSwitchPreference4.setOnSwitchStateChangeListener(new W5(this));
                }
                e(view);
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
            } else if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            b(view);
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

    public static final void b(V5 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getParentFragmentManager().beginTransaction().replace(R.id.container, new N1()).addToBackStack(null).commit();
    }

    public static final void d(V5 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            Y5 y5 = this$0.a;
            if (y5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                y5 = null;
            }
            Y5 y52 = y5;
            String appFilesDir = context.getFilesDir().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(appFilesDir, "safeContext.filesDir.absolutePath");
            a onIntentReady = this$0.new a();
            y52.getClass();
            Intrinsics.checkNotNullParameter(appFilesDir, "appFilesDir");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(onIntentReady, "onIntentReady");
            BuildersKt__Builders_commonKt.launch$default(y52.h, null, null, new X5(appFilesDir, y52, context, onIntentReady, null), 3, null);
        }
    }

    public static final void e(V5 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getParentFragmentManager().beginTransaction().replace(R.id.container, new C0727k6()).addToBackStack(null).commit();
    }

    public static final void c(V5 this$0, View view) {
        String strA;
        C0717j6 c0717j6;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getClass();
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        Y5 y5 = this$0.a;
        if (y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            y5 = null;
        }
        C5 c5 = y5.e;
        if (c5 == null || (c0717j6 = c5.i) == null || (strA = c0717j6.a()) == null) {
            strA = "INACTIVE";
        }
        intent.putExtra("android.intent.extra.TEXT", strA);
        intent.setType("text/plain");
        this$0.startActivity(Intent.createChooser(intent, null));
    }

    public final void a(View view) {
        TextView textView = (TextView) view.findViewById(R.id.contentsquare_disable_in_app_features);
        if (textView != null) {
            InstrumentationCallbacks.setOnClickListenerCalled(textView, new View.OnClickListener() { // from class: com.contentsquare.android.sdk.V5$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    V5.a(this.f$0, view2);
                }
            });
        }
    }

    public static final void a(V5 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.getActivity(), (Class<?>) DeactivationActivity.class));
    }
}
