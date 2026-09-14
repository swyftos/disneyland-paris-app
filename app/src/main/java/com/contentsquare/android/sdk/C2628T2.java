package com.contentsquare.android.sdk;

import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.communication.compose.ComposeInterface;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.T2 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nLongSnapshotComposeInterfaceProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongSnapshotComposeInterfaceProvider.kt\ncom/contentsquare/android/analytics/internal/uigestureinterceptor/compose/LongSnapshotComposeInterfaceProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,23:1\n16#1:24\n1#2:25\n*S KotlinDebug\n*F\n+ 1 LongSnapshotComposeInterfaceProvider.kt\ncom/contentsquare/android/analytics/internal/uigestureinterceptor/compose/LongSnapshotComposeInterfaceProvider\n*L\n19#1:24\n*E\n"})
public final class C2628T2 implements InterfaceC2735e4<ComposeInterface> {
    /* JADX WARN: Code duplicated, block: B:7:0x0012  */
    @Override // com.contentsquare.android.sdk.InterfaceC2735e4
    public final ComposeInterface get() {
        boolean z;
        CoreModule companion = CoreModule.INSTANCE.getInstance();
        if (companion != null) {
            z = C2921x0.m1230a(companion, JsonConfigFeatureFlagNames.LONG_SNAPSHOT_JETPACK_COMPOSE);
        }
        ComposeInterface composeInterface = (ComposeInterface) C2714c3.f2440c.getValue();
        if (z) {
            return composeInterface;
        }
        return null;
    }
}
