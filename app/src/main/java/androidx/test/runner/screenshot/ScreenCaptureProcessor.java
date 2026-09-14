package androidx.test.runner.screenshot;

import androidx.test.annotation.Beta;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@Beta
public interface ScreenCaptureProcessor {
    String process(ScreenCapture screenCapture) throws IOException;
}
