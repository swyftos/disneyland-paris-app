package androidx.test.runner.screenshot;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.test.InstrumentationRegistry;
import androidx.test.annotation.Beta;
import androidx.test.internal.util.Checks;
import androidx.test.runner.screenshot.TakeScreenshotCallable;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Beta
/* loaded from: classes2.dex */
public final class Screenshot {
    private static int androidRuntimeVersion = Build.VERSION.SDK_INT;
    private static UiAutomationWrapper uiWrapper = new UiAutomationWrapper();
    private static Set screenCaptureProcessorSet = new HashSet();
    private static TakeScreenshotCallable.Factory takeScreenshotCallableFactory = new TakeScreenshotCallable.Factory();

    public static ScreenCapture capture() throws ScreenShotException {
        try {
            return captureImpl(null);
        } catch (IOException e) {
            throw new ScreenShotException(e);
        } catch (InterruptedException e2) {
            throw new ScreenShotException(e2);
        } catch (NullPointerException e3) {
            throw new IllegalStateException(e3);
        } catch (ExecutionException e4) {
            throw new ScreenShotException(e4);
        }
    }

    public static ScreenCapture capture(@NonNull Activity activity) throws ScreenShotException {
        Checks.checkNotNull(activity, "activity cannot be null!");
        try {
            return captureImpl(activity.getWindow().getDecorView().getRootView());
        } catch (IOException e) {
            throw new ScreenShotException(e);
        } catch (InterruptedException e2) {
            throw new ScreenShotException(e2);
        } catch (ExecutionException e3) {
            throw new ScreenShotException(e3);
        }
    }

    public static ScreenCapture capture(@NonNull View view) throws ScreenShotException {
        Checks.checkNotNull(view, "view cannot be null!");
        try {
            return captureImpl(view);
        } catch (IOException e) {
            throw new ScreenShotException(e);
        } catch (InterruptedException e2) {
            throw new ScreenShotException(e2);
        } catch (ExecutionException e3) {
            throw new ScreenShotException(e3);
        }
    }

    public static void addScreenCaptureProcessors(Set<ScreenCaptureProcessor> set) {
        screenCaptureProcessorSet.addAll(set);
    }

    public static void setScreenshotProcessors(Set<ScreenCaptureProcessor> set) {
        screenCaptureProcessorSet = set;
    }

    private static ScreenCapture captureImpl(View view) {
        Bitmap bitmapCaptureViewBasedImpl;
        if (view == null && androidRuntimeVersion >= 18) {
            bitmapCaptureViewBasedImpl = captureUiAutomatorImpl();
        } else {
            bitmapCaptureViewBasedImpl = captureViewBasedImpl(view);
        }
        return new ScreenCapture(bitmapCaptureViewBasedImpl).setProcessors(screenCaptureProcessorSet);
    }

    private static Bitmap captureUiAutomatorImpl() {
        return uiWrapper.takeScreenshot();
    }

    private static Bitmap captureViewBasedImpl(View view) {
        Checks.checkNotNull(view, "Taking view based screenshot requires using either takeScreenshot(view) or takeScreenshot(activity) where view and activity are non-null.");
        FutureTask futureTask = new FutureTask(takeScreenshotCallableFactory.create(view));
        if (Looper.myLooper() == Looper.getMainLooper()) {
            futureTask.run();
        } else {
            InstrumentationRegistry.getInstrumentation().runOnMainSync(futureTask);
        }
        return (Bitmap) futureTask.get();
    }

    static final class ScreenShotException extends RuntimeException {
        ScreenShotException(Throwable th) {
            super(th);
        }
    }
}
