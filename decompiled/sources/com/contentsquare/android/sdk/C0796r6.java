package com.contentsquare.android.sdk;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.AppCompatEditText;
import com.contentsquare.android.R;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.r6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0796r6 implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ C0727k6 a;
    public final /* synthetic */ List<String> b;
    public final /* synthetic */ View c;

    public C0796r6(C0727k6 c0727k6, List<String> list, View view) {
        this.a = c0727k6;
        this.b = list;
        this.c = view;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(@Nullable AdapterView<?> adapterView, @Nullable View view, int i, long j) {
        Y5 y5 = this.a.a;
        Y5 y52 = null;
        if (y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            y5 = null;
        }
        String str = this.b.get(i);
        Intrinsics.checkNotNullExpressionValue(str, "presets[position]");
        String value = str;
        y5.getClass();
        Intrinsics.checkNotNullParameter(value, "value");
        PreferencesStore preferencesStore = y5.a;
        PreferencesKey preferencesKey = PreferencesKey.DEVELOPER_SESSION_REPLAY_PRESET_URL;
        preferencesStore.putString(preferencesKey, value);
        boolean z = i == 1;
        C0727k6 c0727k6 = this.a;
        View view2 = this.c;
        String str2 = this.b.get(i);
        Intrinsics.checkNotNullExpressionValue(str2, "presets[position]");
        String value2 = str2;
        c0727k6.getClass();
        AppCompatEditText setupSessionReplayUrl$lambda$11 = (AppCompatEditText) view2.findViewById(R.id.contentsquare_session_replay_url_preference);
        setupSessionReplayUrl$lambda$11.setEnabled(z);
        if (!z) {
            setupSessionReplayUrl$lambda$11.setText(value2);
            Y5 y53 = c0727k6.a;
            if (y53 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            } else {
                y52 = y53;
            }
            y52.getClass();
            Intrinsics.checkNotNullParameter(value2, "value");
            y52.a.putString(PreferencesKey.DEVELOPER_SESSION_REPLAY_URL, value2);
            return;
        }
        Y5 y54 = c0727k6.a;
        if (y54 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
        } else {
            y52 = y54;
        }
        PreferencesStore preferencesStore2 = y52.a;
        PreferencesKey preferencesKey2 = PreferencesKey.DEVELOPER_SESSION_REPLAY_URL;
        String string = preferencesStore2.getString(preferencesKey, PreferencesStore.DefaultValue.SR_URL_PRESET_FROM_CONFIG);
        Intrinsics.checkNotNull(string);
        String string2 = preferencesStore2.getString(preferencesKey2, string);
        Intrinsics.checkNotNull(string2);
        setupSessionReplayUrl$lambda$11.setText(string2);
        Intrinsics.checkNotNullExpressionValue(setupSessionReplayUrl$lambda$11, "setupSessionReplayUrl$lambda$11");
        setupSessionReplayUrl$lambda$11.addTextChangedListener(new C0826u6(c0727k6));
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(@Nullable AdapterView<?> adapterView) {
    }
}
