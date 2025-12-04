package androidx.test.uiautomator;

import android.os.Bundle;
import android.os.SystemClock;
import android.test.InstrumentationTestCase;

@Deprecated
/* loaded from: classes2.dex */
public class UiAutomatorTestCase extends InstrumentationTestCase {
    private IAutomationSupport mAutomationSupport;
    private UiDevice mDevice;
    private Bundle mParams;

    public UiDevice getUiDevice() {
        return this.mDevice;
    }

    public Bundle getParams() {
        return this.mParams;
    }

    @Deprecated
    public IAutomationSupport getAutomationSupport() {
        if (this.mAutomationSupport == null) {
            this.mAutomationSupport = new InstrumentationAutomationSupport(getInstrumentation());
        }
        return this.mAutomationSupport;
    }

    void initialize(Bundle bundle) {
        this.mParams = bundle;
        this.mDevice = UiDevice.getInstance(getInstrumentation());
        String string = this.mParams.getString("monkey");
        if (string != null) {
            getUiDevice().getUiAutomation().setRunAsMonkey(Boolean.valueOf(string).booleanValue());
        }
    }

    @Deprecated
    public void sleep(long j) {
        SystemClock.sleep(j);
    }
}
