package com.contentsquare.android.sdk;

import android.view.View;
import android.widget.LinearLayout;
import com.contentsquare.android.C2362R;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.O1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2578O1 extends Lambda implements Function1<Boolean, Unit> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2568N1 f1910a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ View f1911b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2578O1(C2568N1 c2568n1, View view) {
        super(1);
        this.f1910a = c2568n1;
        this.f1911b = view;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean bool) {
        boolean zBooleanValue = bool.booleanValue();
        C2678Y5 c2678y5 = this.f1910a.f1879a;
        C2678Y5 c2678y6 = null;
        if (c2678y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            c2678y5 = null;
        }
        c2678y5.f2301a.putBoolean(PreferencesKey.DEVELOPER_OVERRIDE_FEATURE_FLAGS_ENABLED, zBooleanValue);
        LinearLayout linearLayout = (LinearLayout) this.f1911b.findViewById(C2362R.id.contentsquare_override_feature_flags_list);
        if (zBooleanValue) {
            C2568N1 c2568n1 = this.f1910a;
            C2678Y5 c2678y7 = c2568n1.f1879a;
            if (c2678y7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                c2678y7 = null;
            }
            List<String> list = c2678y7.f2309i;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                String name = (String) obj;
                C2678Y5 c2678y8 = c2568n1.f1879a;
                if (c2678y8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                    c2678y8 = null;
                }
                c2678y8.getClass();
                Intrinsics.checkNotNullParameter(name, "name");
                if (c2678y8.f2304d.isFeatureFlagEnabled(name)) {
                    arrayList.add(obj);
                }
            }
            Set<String> value = CollectionsKt.toSet(arrayList);
            C2678Y5 c2678y9 = c2568n1.f1879a;
            if (c2678y9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            } else {
                c2678y6 = c2678y9;
            }
            c2678y6.getClass();
            Intrinsics.checkNotNullParameter(value, "value");
            c2678y6.f2301a.putStringSet(PreferencesKey.DEVELOPER_OVERRIDE_FEATURE_FLAGS_STATES, value);
            this.f1910a.m990a(this.f1911b);
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        return Unit.INSTANCE;
    }
}
