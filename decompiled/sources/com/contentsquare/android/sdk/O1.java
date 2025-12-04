package com.contentsquare.android.sdk;

import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import com.contentsquare.android.R;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class O1 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ N1 a;
    public final /* synthetic */ View b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O1(N1 n1, View view) {
        super(1);
        this.a = n1;
        this.b = view;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean bool) throws Resources.NotFoundException {
        boolean zBooleanValue = bool.booleanValue();
        Y5 y5 = this.a.a;
        Y5 y52 = null;
        if (y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            y5 = null;
        }
        y5.a.putBoolean(PreferencesKey.DEVELOPER_OVERRIDE_FEATURE_FLAGS_ENABLED, zBooleanValue);
        LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.contentsquare_override_feature_flags_list);
        if (zBooleanValue) {
            N1 n1 = this.a;
            Y5 y53 = n1.a;
            if (y53 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                y53 = null;
            }
            List<String> list = y53.i;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                String name = (String) obj;
                Y5 y54 = n1.a;
                if (y54 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
                    y54 = null;
                }
                y54.getClass();
                Intrinsics.checkNotNullParameter(name, "name");
                if (y54.d.isFeatureFlagEnabled(name)) {
                    arrayList.add(obj);
                }
            }
            Set<String> value = CollectionsKt.toSet(arrayList);
            Y5 y55 = n1.a;
            if (y55 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            } else {
                y52 = y55;
            }
            y52.getClass();
            Intrinsics.checkNotNullParameter(value, "value");
            y52.a.putStringSet(PreferencesKey.DEVELOPER_OVERRIDE_FEATURE_FLAGS_STATES, value);
            this.a.a(this.b);
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        return Unit.INSTANCE;
    }
}
