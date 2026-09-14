package com.contentsquare.android.sdk;

import android.text.Editable;
import android.text.TextWatcher;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.u6 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$3\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 4 SrSettingsFragment.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/settings/SrSettingsFragment\n*L\n1#1,97:1\n78#2:98\n71#3:99\n173#4,2:100\n*E\n"})
public final class C2897u6 implements TextWatcher {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2797k6 f3157a;

    public C2897u6(C2797k6 c2797k6) {
        this.f3157a = c2797k6;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(@Nullable Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
        C2678Y5 c2678y5 = this.f3157a.f2828a;
        if (c2678y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            c2678y5 = null;
        }
        String value = String.valueOf(charSequence);
        c2678y5.getClass();
        Intrinsics.checkNotNullParameter(value, "value");
        c2678y5.f2301a.putString(PreferencesKey.DEVELOPER_SESSION_REPLAY_URL, value);
    }
}
