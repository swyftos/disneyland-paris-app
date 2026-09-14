package org.apache.commons.lang3.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.util.IterableStringTokenizer;

/* JADX INFO: loaded from: classes6.dex */
public class ExceptionUtils {
    private static final String[] CAUSE_METHOD_NAMES = {"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};

    public static <T extends RuntimeException> T asRuntimeException(Throwable th) {
        return (T) eraseType(th);
    }

    private static Object eraseType(Throwable th) throws Throwable {
        throw th;
    }

    public static void forEach(Throwable th, Consumer<Throwable> consumer) {
        stream(th).forEach(consumer);
    }

    @Deprecated
    public static Throwable getCause(Throwable th) {
        return getCause(th, null);
    }

    @Deprecated
    public static Throwable getCause(final Throwable th, String[] strArr) {
        if (th == null) {
            return null;
        }
        if (strArr == null) {
            Throwable cause = th.getCause();
            if (cause != null) {
                return cause;
            }
            strArr = CAUSE_METHOD_NAMES;
        }
        return (Throwable) Stream.of((Object[]) strArr).map(new Function() { // from class: org.apache.commons.lang3.exception.ExceptionUtils$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ExceptionUtils.getCauseUsingMethodName(th, (String) obj);
            }
        }).filter(new Predicate() { // from class: org.apache.commons.lang3.exception.ExceptionUtils$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.nonNull((Throwable) obj);
            }
        }).findFirst().orElse(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Throwable getCauseUsingMethodName(Throwable th, String str) {
        Method methodObject;
        if (str == null || (methodObject = MethodUtils.getMethodObject(th.getClass(), str, new Class[0])) == null || !Throwable.class.isAssignableFrom(methodObject.getReturnType())) {
            return null;
        }
        try {
            return (Throwable) methodObject.invoke(th, new Object[0]);
        } catch (ReflectiveOperationException unused) {
            return null;
        }
    }

    @Deprecated
    public static String[] getDefaultCauseMethodNames() {
        return (String[]) ArrayUtils.clone(CAUSE_METHOD_NAMES);
    }

    public static String getMessage(Throwable th) {
        if (th == null) {
            return "";
        }
        return ClassUtils.getShortClassName(th, null) + ": " + StringUtils.defaultString(th.getMessage());
    }

    public static Throwable getRootCause(Throwable th) {
        List<Throwable> throwableList = getThrowableList(th);
        if (throwableList.isEmpty()) {
            return null;
        }
        return throwableList.get(throwableList.size() - 1);
    }

    public static String getRootCauseMessage(Throwable th) {
        Throwable rootCause = getRootCause(th);
        if (rootCause != null) {
            th = rootCause;
        }
        return getMessage(th);
    }

    public static String[] getRootCauseStackTrace(Throwable th) {
        return (String[]) getRootCauseStackTraceList(th).toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    public static List<String> getRootCauseStackTraceList(Throwable th) {
        List stackFrameList;
        if (th == null) {
            return Collections.emptyList();
        }
        Throwable[] throwables = getThrowables(th);
        int length = throwables.length;
        ArrayList arrayList = new ArrayList();
        int i = length - 1;
        List stackFrameList2 = getStackFrameList(throwables[i]);
        while (true) {
            int i2 = length - 1;
            if (i2 < 0) {
                return arrayList;
            }
            if (i2 != 0) {
                stackFrameList = getStackFrameList(throwables[length - 2]);
                removeCommonFrames(stackFrameList2, stackFrameList);
            } else {
                stackFrameList = stackFrameList2;
            }
            if (i2 == i) {
                arrayList.add(throwables[i2].toString());
            } else {
                arrayList.add(" [wrapped] " + throwables[i2].toString());
            }
            arrayList.addAll(stackFrameList2);
            stackFrameList2 = stackFrameList;
            length = i2;
        }
    }

    static List getStackFrameList(Throwable th) {
        StringTokenizer stringTokenizer = new StringTokenizer(getStackTrace(th), System.lineSeparator());
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            int iIndexOf = strNextToken.indexOf("at");
            if (iIndexOf != -1 && strNextToken.substring(0, iIndexOf).trim().isEmpty()) {
                arrayList.add(strNextToken);
                z = true;
            } else if (z) {
                break;
            }
        }
        return arrayList;
    }

    static String[] getStackFrames(String str) {
        return new IterableStringTokenizer(str, System.lineSeparator()).toArray();
    }

    public static String[] getStackFrames(Throwable th) {
        if (th == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        return getStackFrames(getStackTrace(th));
    }

    public static String getStackTrace(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        return stringWriter.toString();
    }

    public static int getThrowableCount(Throwable th) {
        return getThrowableList(th).size();
    }

    public static List<Throwable> getThrowableList(Throwable th) {
        ArrayList arrayList = new ArrayList();
        while (th != null && !arrayList.contains(th)) {
            arrayList.add(th);
            th = th.getCause();
        }
        return arrayList;
    }

    public static Throwable[] getThrowables(Throwable th) {
        return (Throwable[]) getThrowableList(th).toArray(ArrayUtils.EMPTY_THROWABLE_ARRAY);
    }

    public static boolean hasCause(Throwable th, Class<? extends Throwable> cls) {
        if (th instanceof UndeclaredThrowableException) {
            th = th.getCause();
        }
        return cls.isInstance(th);
    }

    private static int indexOf(Throwable th, Class cls, int i, boolean z) {
        if (th != null && cls != null) {
            if (i < 0) {
                i = 0;
            }
            Throwable[] throwables = getThrowables(th);
            if (i >= throwables.length) {
                return -1;
            }
            if (z) {
                while (i < throwables.length) {
                    if (cls.isAssignableFrom(throwables[i].getClass())) {
                        return i;
                    }
                    i++;
                }
            } else {
                while (i < throwables.length) {
                    if (cls.equals(throwables[i].getClass())) {
                        return i;
                    }
                    i++;
                }
            }
        }
        return -1;
    }

    public static int indexOfThrowable(Throwable th, Class<? extends Throwable> cls) {
        return indexOf(th, cls, 0, false);
    }

    public static int indexOfThrowable(Throwable th, Class<? extends Throwable> cls, int i) {
        return indexOf(th, cls, i, false);
    }

    public static int indexOfType(Throwable th, Class<? extends Throwable> cls) {
        return indexOf(th, cls, 0, true);
    }

    public static int indexOfType(Throwable th, Class<? extends Throwable> cls, int i) {
        return indexOf(th, cls, i, true);
    }

    public static boolean isChecked(Throwable th) {
        return (th == null || (th instanceof Error) || (th instanceof RuntimeException)) ? false : true;
    }

    public static boolean isUnchecked(Throwable th) {
        return th != null && ((th instanceof Error) || (th instanceof RuntimeException));
    }

    public static void printRootCauseStackTrace(Throwable th) {
        printRootCauseStackTrace(th, System.err);
    }

    public static void printRootCauseStackTrace(Throwable th, final PrintStream printStream) {
        if (th == null) {
            return;
        }
        Objects.requireNonNull(printStream, "printStream");
        getRootCauseStackTraceList(th).forEach(new Consumer() { // from class: org.apache.commons.lang3.exception.ExceptionUtils$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                printStream.println((String) obj);
            }
        });
        printStream.flush();
    }

    public static void printRootCauseStackTrace(Throwable th, final PrintWriter printWriter) {
        if (th == null) {
            return;
        }
        Objects.requireNonNull(printWriter, "printWriter");
        getRootCauseStackTraceList(th).forEach(new Consumer() { // from class: org.apache.commons.lang3.exception.ExceptionUtils$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                printWriter.println((String) obj);
            }
        });
        printWriter.flush();
    }

    public static void removeCommonFrames(List<String> list, List<String> list2) {
        Objects.requireNonNull(list, "causeFrames");
        Objects.requireNonNull(list2, "wrapperFrames");
        int size = list.size() - 1;
        for (int size2 = list2.size() - 1; size >= 0 && size2 >= 0; size2--) {
            if (list.get(size).equals(list2.get(size2))) {
                list.remove(size);
            }
            size--;
        }
    }

    public static <T> T rethrow(Throwable th) {
        return (T) eraseType(th);
    }

    public static Stream<Throwable> stream(Throwable th) {
        return getThrowableList(th).stream();
    }

    private static Throwable throwableOf(Throwable th, Class cls, int i, boolean z) {
        if (th != null && cls != null) {
            if (i < 0) {
                i = 0;
            }
            Throwable[] throwables = getThrowables(th);
            if (i >= throwables.length) {
                return null;
            }
            if (z) {
                while (i < throwables.length) {
                    if (cls.isAssignableFrom(throwables[i].getClass())) {
                        return (Throwable) cls.cast(throwables[i]);
                    }
                    i++;
                }
            } else {
                while (i < throwables.length) {
                    if (cls.equals(throwables[i].getClass())) {
                        return (Throwable) cls.cast(throwables[i]);
                    }
                    i++;
                }
            }
        }
        return null;
    }

    public static <T extends Throwable> T throwableOfThrowable(Throwable th, Class<T> cls) {
        return (T) throwableOf(th, cls, 0, false);
    }

    public static <T extends Throwable> T throwableOfThrowable(Throwable th, Class<T> cls, int i) {
        return (T) throwableOf(th, cls, i, false);
    }

    public static <T extends Throwable> T throwableOfType(Throwable th, Class<T> cls) {
        return (T) throwableOf(th, cls, 0, true);
    }

    public static <T extends Throwable> T throwableOfType(Throwable th, Class<T> cls, int i) {
        return (T) throwableOf(th, cls, i, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public static <T> T throwUnchecked(T t) {
        if (t instanceof RuntimeException) {
            throw ((RuntimeException) t);
        }
        if (t instanceof Error) {
            throw ((Error) t);
        }
        return t;
    }

    public static <T extends Throwable> T throwUnchecked(T t) {
        if (isUnchecked(t)) {
            throw asRuntimeException(t);
        }
        return t;
    }

    public static <R> R wrapAndThrow(Throwable th) {
        throw new UndeclaredThrowableException(throwUnchecked(th));
    }

    @Deprecated
    public ExceptionUtils() {
    }
}
