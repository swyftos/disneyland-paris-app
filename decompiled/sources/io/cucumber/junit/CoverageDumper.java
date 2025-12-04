package io.cucumber.junit;

import android.os.Bundle;
import android.util.Log;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class CoverageDumper {
    private final Arguments arguments;

    public CoverageDumper(Arguments arguments) {
        this.arguments = arguments;
    }

    public void requestDump(Bundle bundle) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.arguments.isCoverageEnabled()) {
            String strCoverageDataFilePath = this.arguments.coverageDataFilePath();
            File file = new File(strCoverageDataFilePath);
            try {
                Class<?> cls = Class.forName("com.vladium.emma.rt.RT");
                Class<?> cls2 = file.getClass();
                Class cls3 = Boolean.TYPE;
                Method method = cls.getMethod("dumpCoverageData", cls2, cls3, cls3);
                Boolean bool = Boolean.FALSE;
                method.invoke(null, file, bool, bool);
                bundle.putString("coverageFilePath", strCoverageDataFilePath);
                appendNewLineToResultStream(bundle, String.format("Generated code coverage data to %s", strCoverageDataFilePath));
            } catch (ClassNotFoundException e) {
                reportError(bundle, e);
            } catch (IllegalAccessException e2) {
                reportError(bundle, e2);
            } catch (NoSuchMethodException e3) {
                reportError(bundle, e3);
            } catch (SecurityException e4) {
                reportError(bundle, e4);
            } catch (InvocationTargetException e5) {
                reportError(bundle, e5);
            }
        }
    }

    private void reportError(Bundle bundle, Exception exc) {
        Log.e("cucumber-android", "Failed to generate coverage.", exc);
        appendNewLineToResultStream(bundle, "Error: Failed to generate coverage. Check logcat for details.");
    }

    private void appendNewLineToResultStream(Bundle bundle, String str) {
        bundle.putString("stream", bundle.getString("stream") + "\n" + str);
    }
}
