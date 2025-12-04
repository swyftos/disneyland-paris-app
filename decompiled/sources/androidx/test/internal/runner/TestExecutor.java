package androidx.test.internal.runner;

import android.app.Instrumentation;
import android.os.Bundle;
import android.util.Log;
import androidx.test.internal.runner.listener.InstrumentationRunListener;
import androidx.test.internal.util.Checks;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/* loaded from: classes2.dex */
public final class TestExecutor {
    private final Instrumentation instr;
    private final List listeners;

    private TestExecutor(Builder builder) {
        this.listeners = (List) Checks.checkNotNull(builder.listeners);
        this.instr = builder.instr;
    }

    public Bundle execute(Request request) {
        String str;
        Bundle bundle = new Bundle();
        Result result = new Result();
        try {
            JUnitCore jUnitCore = new JUnitCore();
            setUpListeners(jUnitCore);
            Result resultRun = jUnitCore.run(request);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);
            reportRunEnded(this.listeners, printStream, bundle, resultRun);
            printStream.close();
            str = String.format("\n%s", byteArrayOutputStream.toString());
        } catch (Throwable th) {
            try {
                Log.e("TestExecutor", "Fatal exception when running tests", th);
                result.getFailures().add(new Failure(Description.createSuiteDescription("Fatal exception when running tests", new Annotation[0]), th));
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                PrintStream printStream2 = new PrintStream(byteArrayOutputStream2);
                reportRunEnded(this.listeners, printStream2, bundle, result);
                printStream2.close();
                str = String.format("\n%s", byteArrayOutputStream2.toString());
            } catch (Throwable th2) {
                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                PrintStream printStream3 = new PrintStream(byteArrayOutputStream3);
                reportRunEnded(this.listeners, printStream3, bundle, result);
                printStream3.close();
                bundle.putString("stream", String.format("\n%s", byteArrayOutputStream3.toString()));
                throw th2;
            }
        }
        bundle.putString("stream", str);
        return bundle;
    }

    private void setUpListeners(JUnitCore jUnitCore) {
        for (RunListener runListener : this.listeners) {
            String name = runListener.getClass().getName();
            Log.d("TestExecutor", name.length() != 0 ? "Adding listener ".concat(name) : new String("Adding listener "));
            jUnitCore.addListener(runListener);
            if (runListener instanceof InstrumentationRunListener) {
                ((InstrumentationRunListener) runListener).setInstrumentation(this.instr);
            }
        }
    }

    private void reportRunEnded(List list, PrintStream printStream, Bundle bundle, Result result) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            RunListener runListener = (RunListener) it.next();
            if (runListener instanceof InstrumentationRunListener) {
                ((InstrumentationRunListener) runListener).instrumentationRunFinished(printStream, bundle, result);
            }
        }
    }

    public static class Builder {
        private final Instrumentation instr;
        private final List listeners = new ArrayList();

        public Builder(Instrumentation instrumentation) {
            this.instr = instrumentation;
        }

        public Builder addRunListener(RunListener runListener) {
            this.listeners.add(runListener);
            return this;
        }

        public TestExecutor build() {
            return new TestExecutor(this);
        }
    }
}
