package io.cucumber.junit;

import android.os.Debug;

/* loaded from: classes5.dex */
public final class DebuggerWaiter {
    private final Arguments arguments;

    public DebuggerWaiter(Arguments arguments) {
        this.arguments = arguments;
    }

    public void requestWaitForDebugger() {
        if (this.arguments.isDebugEnabled()) {
            Debug.waitForDebugger();
        }
    }
}
