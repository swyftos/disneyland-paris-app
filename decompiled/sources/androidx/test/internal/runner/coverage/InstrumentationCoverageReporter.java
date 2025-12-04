package androidx.test.internal.runner.coverage;

import android.app.Instrumentation;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.test.internal.runner.storage.RunnerIO;
import androidx.test.internal.runner.storage.RunnerTestStorageIO;
import androidx.test.runner.internal.deps.desugar.ThrowableExtension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes2.dex */
public class InstrumentationCoverageReporter {
    private static final String TAG = "InstrumentationCoverageReporter";
    private final Instrumentation instrumentation;
    private final RunnerIO runnerIO;

    public InstrumentationCoverageReporter(Instrumentation instrumentation, RunnerIO runnerIO) {
        this.instrumentation = instrumentation;
        this.runnerIO = runnerIO;
    }

    public String generateCoverageReport(@Nullable String str, PrintStream printStream) {
        String strDumpCoverageToFile;
        if (this.runnerIO instanceof RunnerTestStorageIO) {
            strDumpCoverageToFile = dumpCoverageToTestStorage(str, printStream);
        } else {
            strDumpCoverageToFile = dumpCoverageToFile(str, printStream);
        }
        String str2 = TAG;
        String strValueOf = String.valueOf(strDumpCoverageToFile);
        Log.d(str2, strValueOf.length() != 0 ? "Coverage file was generated to ".concat(strValueOf) : new String("Coverage file was generated to "));
        printStream.format("\nGenerated code coverage data to %s", strDumpCoverageToFile);
        return strDumpCoverageToFile;
    }

    private String dumpCoverageToFile(String str, PrintStream printStream) {
        if (str == null) {
            Log.d(TAG, "No coverage file path was specified. Dumps to the default file path.");
            String absolutePath = this.instrumentation.getTargetContext().getFilesDir().getAbsolutePath();
            String str2 = File.separator;
            StringBuilder sb = new StringBuilder(String.valueOf(absolutePath).length() + 11 + String.valueOf(str2).length());
            sb.append(absolutePath);
            sb.append(str2);
            sb.append("coverage.ec");
            str = sb.toString();
        }
        if (!generateCoverageInternal(str, printStream)) {
            Log.w(TAG, "Failed to generate the coverage data file. Please refer to the instrumentation result for more info.");
        }
        return str;
    }

    private String dumpCoverageToTestStorage(String str, PrintStream printStream) {
        if (str == null) {
            Log.d(TAG, "No coverage file path was specified. Dumps to the default coverage file using test storage.");
            str = "coverage.ec";
        }
        String absolutePath = this.instrumentation.getTargetContext().getFilesDir().getAbsolutePath();
        String str2 = File.separator;
        StringBuilder sb = new StringBuilder(String.valueOf(absolutePath).length() + 11 + String.valueOf(str2).length());
        sb.append(absolutePath);
        sb.append(str2);
        sb.append("coverage.ec");
        String string = sb.toString();
        if (!generateCoverageInternal(string, printStream)) {
            Log.w(TAG, "Failed to generate the coverage data file. Please refer to the instrumentation result for more info.");
        }
        try {
            Log.d(TAG, "Test service is available. Moving the coverage data file to be managed by the storage service.");
            moveFileToTestStorage(string, str);
            return str;
        } catch (IOException e) {
            reportEmmaError(printStream, e);
            return null;
        }
    }

    private void moveFileToTestStorage(String str, String str2) throws IOException {
        File file = new File(str);
        if (file.exists()) {
            String str3 = TAG;
            Log.d(str3, String.format("Moving coverage file [%s] to the internal test storage [%s].", str, str2));
            OutputStream outputStreamOpenOutputStream = this.runnerIO.openOutputStream(str2);
            try {
                FileChannel channel = new FileInputStream(str).getChannel();
                try {
                    WritableByteChannel writableByteChannelNewChannel = Channels.newChannel(outputStreamOpenOutputStream);
                    try {
                        channel.transferTo(0L, channel.size(), writableByteChannelNewChannel);
                        if (writableByteChannelNewChannel != null) {
                            writableByteChannelNewChannel.close();
                        }
                        channel.close();
                        if (outputStreamOpenOutputStream != null) {
                            outputStreamOpenOutputStream.close();
                        }
                        if (file.delete()) {
                            return;
                        }
                        Log.e(str3, String.format("Failed to delete original coverage file [%s]", file.getAbsolutePath()));
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                if (outputStreamOpenOutputStream != null) {
                    try {
                        outputStreamOpenOutputStream.close();
                    } catch (Throwable th2) {
                        ThrowableExtension.addSuppressed(th, th2);
                    }
                }
                throw th;
            }
        }
    }

    @VisibleForTesting
    public boolean generateCoverageInternal(String str, PrintStream printStream) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls;
        File file = new File(str);
        try {
            try {
                try {
                    cls = Class.forName("com.vladium.emma.rt.RT", true, this.instrumentation.getTargetContext().getClassLoader());
                } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
                    reportEmmaError(printStream, e);
                    return false;
                }
            } catch (ClassNotFoundException e2) {
                reportEmmaError(printStream, "Is Emma/JaCoCo jar on classpath?", e2);
                return false;
            }
        } catch (ClassNotFoundException unused) {
            cls = Class.forName("com.vladium.emma.rt.RT", true, this.instrumentation.getContext().getClassLoader());
            Log.w(TAG, "Generating coverage for alternate test context.");
            printStream.format("\nWarning: %s", "Generating coverage for alternate test context.");
        }
        Class<?> cls2 = file.getClass();
        Class cls3 = Boolean.TYPE;
        Method method = cls.getMethod("dumpCoverageData", cls2, cls3, cls3);
        Boolean bool = Boolean.FALSE;
        method.invoke(null, file, bool, bool);
        return true;
    }

    private void reportEmmaError(PrintStream printStream, Exception exc) {
        reportEmmaError(printStream, "", exc);
    }

    private void reportEmmaError(PrintStream printStream, String str, Exception exc) {
        String strValueOf = String.valueOf(str);
        String strConcat = strValueOf.length() != 0 ? "Failed to generate Emma/JaCoCo coverage. ".concat(strValueOf) : new String("Failed to generate Emma/JaCoCo coverage. ");
        Log.e(TAG, strConcat, exc);
        printStream.format("\nError: %s", strConcat);
    }
}
