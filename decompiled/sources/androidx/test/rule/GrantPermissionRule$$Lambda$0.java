package androidx.test.rule;

import androidx.test.internal.platform.ServiceLoaderWrapper;
import androidx.test.runner.permission.PermissionRequester;

/* loaded from: classes2.dex */
final /* synthetic */ class GrantPermissionRule$$Lambda$0 implements ServiceLoaderWrapper.Factory {
    static final ServiceLoaderWrapper.Factory $instance = new GrantPermissionRule$$Lambda$0();

    private GrantPermissionRule$$Lambda$0() {
    }

    @Override // androidx.test.internal.platform.ServiceLoaderWrapper.Factory
    public Object create() {
        return new PermissionRequester();
    }
}
