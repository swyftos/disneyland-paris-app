package androidx.test.services.events.internal;

import androidx.test.runner.internal.deps.desugar.ThrowableExtension;
import ch.qos.logback.core.CoreConstants;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
abstract class Throwables {
    private static final String[] TEST_FRAMEWORK_METHOD_NAME_PREFIXES = {"org.junit.runner.", "org.junit.runners.", "org.junit.experimental.runners.", "org.junit.internal.", "junit."};
    private static final String[] TEST_FRAMEWORK_TEST_METHOD_NAME_PREFIXES = {"org.junit.internal.StackTracesTest"};
    private static final String[] REFLECTION_METHOD_NAME_PREFIXES = {"sun.reflect.", "java.lang.reflect.", "jdk.internal.reflect.", "org.junit.rules.RunRules.<init>(", "org.junit.rules.RunRules.applyAll(", "org.junit.runners.BlockJUnit4ClassRunner.withMethodRules(", "junit.framework.TestCase.runBare("};

    public static String getTrimmedStackTrace(Throwable th) {
        List trimmedStackTraceLines = getTrimmedStackTraceLines(th);
        if (trimmedStackTraceLines.isEmpty()) {
            return getFullStackTrace(th);
        }
        StringBuilder sb = new StringBuilder(th.toString());
        appendStackTraceLines(trimmedStackTraceLines, sb);
        appendStackTraceLines(getCauseStackTraceLines(th), sb);
        return sb.toString();
    }

    private static List getTrimmedStackTraceLines(Throwable th) {
        List listAsList = Arrays.asList(th.getStackTrace());
        int size = listAsList.size();
        State stateProcessStackTraceElement = State.PROCESSING_OTHER_CODE;
        Iterator it = asReversedList(listAsList).iterator();
        while (it.hasNext()) {
            stateProcessStackTraceElement = stateProcessStackTraceElement.processStackTraceElement((StackTraceElement) it.next());
            if (stateProcessStackTraceElement == State.DONE) {
                ArrayList arrayList = new ArrayList(size + 2);
                arrayList.add("");
                Iterator it2 = listAsList.subList(0, size).iterator();
                while (it2.hasNext()) {
                    String strValueOf = String.valueOf((StackTraceElement) it2.next());
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 4);
                    sb.append("\tat ");
                    sb.append(strValueOf);
                    arrayList.add(sb.toString());
                }
                if (th.getCause() != null) {
                    int size2 = listAsList.size() - arrayList.size();
                    StringBuilder sb2 = new StringBuilder(24);
                    sb2.append("\t... ");
                    sb2.append(size2);
                    sb2.append(" trimmed");
                    arrayList.add(sb2.toString());
                }
                return arrayList;
            }
            size--;
        }
        return Collections.emptyList();
    }

    private static List getCauseStackTraceLines(Throwable th) throws IOException {
        String line;
        if (th.getCause() != null) {
            BufferedReader bufferedReader = new BufferedReader(new StringReader(getFullStackTrace(th).substring(th.toString().length())));
            ArrayList arrayList = new ArrayList();
            do {
                try {
                    line = bufferedReader.readLine();
                    if (line != null) {
                    }
                } catch (IOException unused) {
                }
            } while (!line.startsWith(CoreConstants.CAUSED_BY));
            arrayList.add(line);
            while (true) {
                String line2 = bufferedReader.readLine();
                if (line2 == null) {
                    return arrayList;
                }
                arrayList.add(line2);
            }
        }
        return Collections.emptyList();
    }

    private static String getFullStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        ThrowableExtension.printStackTrace(th, new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private static void appendStackTraceLines(List list, StringBuilder sb) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            sb.append(String.format("%s%n", (String) it.next()));
        }
    }

    private static List asReversedList(final List list) {
        return new AbstractList<Object>() { // from class: androidx.test.services.events.internal.Throwables.1
            @Override // java.util.AbstractList, java.util.List
            public Object get(int i) {
                return list.get((r1.size() - i) - 1);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return list.size();
            }
        };
    }

    private enum State {
        PROCESSING_OTHER_CODE { // from class: androidx.test.services.events.internal.Throwables.State.1
            @Override // androidx.test.services.events.internal.Throwables.State
            public State processLine(String str) {
                return Throwables.isTestFrameworkMethod(str) ? State.PROCESSING_TEST_FRAMEWORK_CODE : this;
            }
        },
        PROCESSING_TEST_FRAMEWORK_CODE { // from class: androidx.test.services.events.internal.Throwables.State.2
            @Override // androidx.test.services.events.internal.Throwables.State
            public State processLine(String str) {
                if (Throwables.isReflectionMethod(str)) {
                    return State.PROCESSING_REFLECTION_CODE;
                }
                return Throwables.isTestFrameworkMethod(str) ? this : State.PROCESSING_OTHER_CODE;
            }
        },
        PROCESSING_REFLECTION_CODE { // from class: androidx.test.services.events.internal.Throwables.State.3
            @Override // androidx.test.services.events.internal.Throwables.State
            public State processLine(String str) {
                if (Throwables.isReflectionMethod(str)) {
                    return this;
                }
                if (Throwables.isTestFrameworkMethod(str)) {
                    return State.PROCESSING_TEST_FRAMEWORK_CODE;
                }
                return State.DONE;
            }
        },
        DONE { // from class: androidx.test.services.events.internal.Throwables.State.4
            @Override // androidx.test.services.events.internal.Throwables.State
            public State processLine(String str) {
                return this;
            }
        };

        protected abstract State processLine(String str);

        public final State processStackTraceElement(StackTraceElement stackTraceElement) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            StringBuilder sb = new StringBuilder(String.valueOf(className).length() + 3 + String.valueOf(methodName).length());
            sb.append(className);
            sb.append(InstructionFileId.DOT);
            sb.append(methodName);
            sb.append("()");
            return processLine(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isTestFrameworkMethod(String str) {
        return isMatchingMethod(str, TEST_FRAMEWORK_METHOD_NAME_PREFIXES) && !isMatchingMethod(str, TEST_FRAMEWORK_TEST_METHOD_NAME_PREFIXES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isReflectionMethod(String str) {
        return isMatchingMethod(str, REFLECTION_METHOD_NAME_PREFIXES);
    }

    private static boolean isMatchingMethod(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }
}
