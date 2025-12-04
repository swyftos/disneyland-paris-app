package androidx.test.runner.screenshot;

import androidx.test.annotation.Beta;
import java.io.IOException;

@Beta
/* loaded from: classes2.dex */
public interface ScreenCaptureProcessor {
    String process(ScreenCapture screenCapture) throws IOException;
}
