package com.contentsquare.android.sdk;

import android.text.Editable;
import android.text.TextWatcher;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$3\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 4 SrSettingsFragment.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/settings/SrSettingsFragment\n*L\n1#1,97:1\n78#2:98\n71#3:99\n173#4,2:100\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.u6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0826u6 implements TextWatcher {
    public final /* synthetic */ C0727k6 a;

    public C0826u6(C0727k6 c0727k6) {
        this.a = c0727k6;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(@Nullable Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
        Y5 y5 = this.a.a;
        if (y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            y5 = null;
        }
        String value = String.valueOf(charSequence);
        y5.getClass();
        Intrinsics.checkNotNullParameter(value, "value");
        y5.a.putString(PreferencesKey.DEVELOPER_SESSION_REPLAY_URL, value);
    }
}
