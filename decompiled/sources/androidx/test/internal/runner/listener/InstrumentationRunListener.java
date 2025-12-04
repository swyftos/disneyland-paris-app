package androidx.test.internal.runner.listener;

import android.app.Instrumentation;
import android.os.Bundle;
import java.io.PrintStream;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

/* loaded from: classes2.dex */
public abstract class InstrumentationRunListener extends RunListener {
    private Instrumentation instr;

    public void instrumentationRunFinished(PrintStream printStream, Bundle bundle, Result result) {
    }

    public Instrumentation getInstrumentation() {
        return this.instr;
    }

    public void setInstrumentation(Instrumentation instrumentation) {
        this.instr = instrumentation;
    }

    public void sendStatus(int i, Bundle bundle) {
        getInstrumentation().sendStatus(i, bundle);
    }

    public void sendString(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("stream", str);
        sendStatus(0, bundle);
    }
}
