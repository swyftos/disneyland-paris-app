package com.michaelflisar.lumberjack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class LogUtil {
    private static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");

    public static StackData getStackData(int i) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int i2 = i + 1;
        if (stackTrace.length <= i2) {
            throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
        }
        return getStackData(stackTrace[i2]);
    }

    private static StackData getStackData(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        Matcher matcher = ANONYMOUS_CLASS.matcher(className);
        if (matcher.find()) {
            className = matcher.replaceAll("");
        }
        return new StackData(className, stackTraceElement.getMethodName(), stackTraceElement.getLineNumber());
    }

    public static class StackData {
        private final String mClassName;
        private final int mLine;
        private final String mMethodName;
        private final String mSimpleClassName;

        public StackData(String str, String str2, int i) {
            this.mClassName = str;
            this.mSimpleClassName = str.substring(str.lastIndexOf(46) + 1);
            this.mMethodName = str2;
            this.mLine = i;
        }

        public String getStackTag() {
            return this.mSimpleClassName + ":" + this.mLine + " " + this.mMethodName;
        }

        public String getLink() {
            return this.mSimpleClassName + ".java:" + this.mLine;
        }

        public String appendLink(String str) {
            String[] strArrSplit = str.split("\r\n|\r|\n");
            if (strArrSplit.length <= 1) {
                return str + " (" + getLink() + ")";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(strArrSplit[0]);
            sb.append(" (");
            sb.append(getLink());
            sb.append(")");
            strArrSplit[0] = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            for (String str2 : strArrSplit) {
                sb2.append(str2);
                sb2.append("\n");
            }
            return sb2.toString();
        }
    }
}
