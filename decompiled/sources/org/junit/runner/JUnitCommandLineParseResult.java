package org.junit.runner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.internal.Classes;
import org.junit.runner.FilterFactory;
import org.junit.runners.model.InitializationError;

/* loaded from: classes6.dex */
class JUnitCommandLineParseResult {
    private final List filterSpecs = new ArrayList();
    private final List classes = new ArrayList();
    private final List parserErrors = new ArrayList();

    JUnitCommandLineParseResult() {
    }

    public static JUnitCommandLineParseResult parse(String[] strArr) {
        JUnitCommandLineParseResult jUnitCommandLineParseResult = new JUnitCommandLineParseResult();
        jUnitCommandLineParseResult.parseArgs(strArr);
        return jUnitCommandLineParseResult;
    }

    private void parseArgs(String[] strArr) {
        parseParameters(parseOptions(strArr));
    }

    String[] parseOptions(String... strArr) {
        String strSubstring;
        int i = 0;
        while (true) {
            if (i == strArr.length) {
                break;
            }
            String str = strArr[i];
            if (str.equals("--")) {
                return copyArray(strArr, i + 1, strArr.length);
            }
            if (str.startsWith("--")) {
                if (str.startsWith("--filter=") || str.equals("--filter")) {
                    if (str.equals("--filter")) {
                        i++;
                        if (i < strArr.length) {
                            strSubstring = strArr[i];
                        } else {
                            this.parserErrors.add(new CommandLineParserError(str + " value not specified"));
                            break;
                        }
                    } else {
                        strSubstring = str.substring(str.indexOf(61) + 1);
                    }
                    this.filterSpecs.add(strSubstring);
                } else {
                    this.parserErrors.add(new CommandLineParserError("JUnit knows nothing about the " + str + " option"));
                }
                i++;
            } else {
                return copyArray(strArr, i, strArr.length);
            }
        }
        return new String[0];
    }

    private String[] copyArray(String[] strArr, int i, int i2) {
        String[] strArr2 = new String[i2 - i];
        for (int i3 = i; i3 != i2; i3++) {
            strArr2[i3 - i] = strArr[i3];
        }
        return strArr2;
    }

    void parseParameters(String[] strArr) {
        for (String str : strArr) {
            try {
                this.classes.add(Classes.getClass(str));
            } catch (ClassNotFoundException e) {
                this.parserErrors.add(new IllegalArgumentException("Could not find class [" + str + "]", e));
            }
        }
    }

    private Request errorReport(Throwable th) {
        return Request.errorReport(JUnitCommandLineParseResult.class, th);
    }

    public Request createRequest(Computer computer) {
        if (this.parserErrors.isEmpty()) {
            List list = this.classes;
            return applyFilterSpecs(Request.classes(computer, (Class[]) list.toArray(new Class[list.size()])));
        }
        return errorReport(new InitializationError((List<Throwable>) this.parserErrors));
    }

    private Request applyFilterSpecs(Request request) {
        try {
            Iterator it = this.filterSpecs.iterator();
            while (it.hasNext()) {
                request = request.filterWith(FilterFactories.createFilterFromFilterSpec(request, (String) it.next()));
            }
            return request;
        } catch (FilterFactory.FilterNotCreatedException e) {
            return errorReport(e);
        }
    }

    public static class CommandLineParserError extends Exception {
        private static final long serialVersionUID = 1;

        public CommandLineParserError(String str) {
            super(str);
        }
    }
}
