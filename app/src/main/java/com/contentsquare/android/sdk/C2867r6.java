package com.contentsquare.android.sdk;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.AppCompatEditText;
import com.contentsquare.android.C2362R;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.r6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2867r6 implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2797k6 f3079a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ List<String> f3080b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ View f3081c;

    public C2867r6(C2797k6 c2797k6, List<String> list, View view) {
        this.f3079a = c2797k6;
        this.f3080b = list;
        this.f3081c = view;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(@Nullable AdapterView<?> adapterView, @Nullable View view, int i, long j) {
        C2678Y5 c2678y5 = this.f3079a.f2828a;
        C2678Y5 c2678y6 = null;
        if (c2678y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            c2678y5 = null;
        }
        String str = this.f3080b.get(i);
        Intrinsics.checkNotNullExpressionValue(str, "presets[position]");
        String value = str;
        c2678y5.getClass();
        Intrinsics.checkNotNullParameter(value, "value");
        PreferencesStore preferencesStore = c2678y5.f2301a;
        PreferencesKey preferencesKey = PreferencesKey.DEVELOPER_SESSION_REPLAY_PRESET_URL;
        preferencesStore.putString(preferencesKey, value);
        boolean z = i == 1;
        C2797k6 c2797k6 = this.f3079a;
        View view2 = this.f3081c;
        String str2 = this.f3080b.get(i);
        Intrinsics.checkNotNullExpressionValue(str2, "presets[position]");
        String value2 = str2;
        c2797k6.getClass();
        AppCompatEditText setupSessionReplayUrl$lambda$11 = (AppCompatEditText) view2.findViewById(C2362R.id.contentsquare_session_replay_url_preference);
        setupSessionReplayUrl$lambda$11.setEnabled(z);
        if (!z) {
            setupSessionReplayUrl$lambda$11.setText(value2);
            C2678Y5 c2678y7 = c2797k6.f2828a;
            if (c2678y7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            } else {
                c2678y6 = c2678y7;
            }
            c2678y6.getClass();
            Intrinsics.checkNotNullParameter(value2, "value");
            c2678y6.f2301a.putString(PreferencesKey.DEVELOPER_SESSION_REPLAY_URL, value2);
            return;
        }
        C2678Y5 c2678y8 = c2797k6.f2828a;
        if (c2678y8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
        } else {
            c2678y6 = c2678y8;
        }
        PreferencesStore preferencesStore2 = c2678y6.f2301a;
        PreferencesKey preferencesKey2 = PreferencesKey.DEVELOPER_SESSION_REPLAY_URL;
        String string = preferencesStore2.getString(preferencesKey, PreferencesStore.DefaultValue.SR_URL_PRESET_FROM_CONFIG);
        Intrinsics.checkNotNull(string);
        String string2 = preferencesStore2.getString(preferencesKey2, string);
        Intrinsics.checkNotNull(string2);
        setupSessionReplayUrl$lambda$11.setText(string2);
        Intrinsics.checkNotNullExpressionValue(setupSessionReplayUrl$lambda$11, "setupSessionReplayUrl$lambda$11");
        setupSessionReplayUrl$lambda$11.addTextChangedListener(new C2897u6(c2797k6));
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(@Nullable AdapterView<?> adapterView) {
    }
}
