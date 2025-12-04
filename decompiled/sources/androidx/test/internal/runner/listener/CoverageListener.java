package androidx.test.internal.runner.listener;

import android.app.Instrumentation;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.test.internal.runner.coverage.InstrumentationCoverageReporter;
import androidx.test.internal.runner.storage.RunnerFileIO;
import androidx.test.internal.runner.storage.RunnerIO;
import java.io.PrintStream;
import org.junit.runner.Result;

/* loaded from: classes2.dex */
public class CoverageListener extends InstrumentationRunListener {
    private final String coverageFilePath;
    private InstrumentationCoverageReporter coverageReporter;
    private RunnerIO runnerIO;

    public CoverageListener(@Nullable String str) {
        this(str, new RunnerFileIO());
    }

    public CoverageListener(@Nullable String str, RunnerIO runnerIO) {
        this.coverageFilePath = str;
        this.runnerIO = runnerIO;
    }

    @Override // androidx.test.internal.runner.listener.InstrumentationRunListener
    public void setInstrumentation(Instrumentation instrumentation) {
        super.setInstrumentation(instrumentation);
        this.coverageReporter = new InstrumentationCoverageReporter(getInstrumentation(), this.runnerIO);
    }

    @Override // androidx.test.internal.runner.listener.InstrumentationRunListener
    public void instrumentationRunFinished(PrintStream printStream, Bundle bundle, Result result) {
        bundle.putString("coverageFilePath", this.coverageReporter.generateCoverageReport(this.coverageFilePath, printStream));
    }
}
