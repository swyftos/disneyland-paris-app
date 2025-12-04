package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.p2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0773p2 extends Lambda implements Function0<L4> {
    public final /* synthetic */ PreferencesStore a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0773p2(PreferencesStore preferencesStore) {
        super(0);
        this.a = preferencesStore;
    }

    @Override // kotlin.jvm.functions.Function0
    public final L4 invoke() {
        return this.a.getBoolean(PreferencesKey.SESSION_REPLAY_FORCE_START, false) ? L4.PROPAGATE_START : L4.EVALUATE;
    }
}
