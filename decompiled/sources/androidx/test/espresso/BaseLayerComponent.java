package androidx.test.espresso;

import androidx.test.espresso.base.ActiveRootLister;
import androidx.test.espresso.base.BaseLayerModule;
import androidx.test.espresso.base.IdlingResourceRegistry;
import androidx.test.espresso.base.MainThread;
import androidx.test.internal.platform.os.ControlledLooper;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public interface BaseLayerComponent {
    ActiveRootLister activeRootLister();

    ControlledLooper controlledLooper();

    FailureHandler failureHandler();

    BaseLayerModule.FailureHandlerHolder failureHolder();

    IdlingResourceRegistry idlingResourceRegistry();

    @MainThread
    Executor mainThreadExecutor();

    ViewInteractionComponent plus(ViewInteractionModule viewInteractionModule);

    UiController uiController();
}
