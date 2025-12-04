package androidx.test.runner.screenshot;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import androidx.test.InstrumentationRegistry;

/* loaded from: classes2.dex */
public class UiAutomationWrapper {
    @VisibleForTesting
    UiAutomationWrapper() {
    }

    public Bitmap takeScreenshot() {
        return InstrumentationRegistry.getInstrumentation().getUiAutomation().takeScreenshot();
    }
}
