package androidx.test.uiautomator;

import android.app.Instrumentation;
import android.os.Bundle;

/* loaded from: classes2.dex */
class InstrumentationAutomationSupport implements IAutomationSupport {
    private Instrumentation mInstrumentation;

    InstrumentationAutomationSupport(Instrumentation instrumentation) {
        this.mInstrumentation = instrumentation;
    }

    @Override // androidx.test.uiautomator.IAutomationSupport
    public void sendStatus(int i, Bundle bundle) {
        this.mInstrumentation.sendStatus(i, bundle);
    }
}
