package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.classic.spi.ThrowableProxyUtil;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.boolex.EvaluationException;
import ch.qos.logback.core.boolex.EventEvaluator;
import ch.qos.logback.core.status.ErrorStatus;
import com.disney.p026id.android.Guest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ThrowableProxyConverter extends ThrowableHandlingConverter {
    protected static final int BUILDER_CAPACITY = 2048;
    int lengthOption;
    List evaluatorList = null;
    List ignoredStackTraceLines = null;
    int errorCount = 0;

    private void addEvaluator(EventEvaluator eventEvaluator) {
        if (this.evaluatorList == null) {
            this.evaluatorList = new ArrayList();
        }
        this.evaluatorList.add(eventEvaluator);
    }

    private void addIgnoreStackTraceLine(String str) {
        if (this.ignoredStackTraceLines == null) {
            this.ignoredStackTraceLines = new ArrayList();
        }
        this.ignoredStackTraceLines.add(str);
    }

    private boolean isIgnoredStackTraceLine(String str) {
        List list = this.ignoredStackTraceLines;
        if (list == null) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (str.contains((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private void printIgnoredCount(StringBuilder sb, int i) {
        sb.append(" [");
        sb.append(i);
        sb.append(" skipped]");
    }

    private void printStackLine(StringBuilder sb, int i, StackTraceElementProxy stackTraceElementProxy) {
        sb.append(stackTraceElementProxy);
        extraData(sb, stackTraceElementProxy);
        if (i > 0) {
            printIgnoredCount(sb, i);
        }
    }

    private void recursiveAppend(StringBuilder sb, String str, int i, IThrowableProxy iThrowableProxy) {
        if (iThrowableProxy == null) {
            return;
        }
        subjoinFirstLine(sb, str, i, iThrowableProxy);
        sb.append(CoreConstants.LINE_SEPARATOR);
        subjoinSTEPArray(sb, i, iThrowableProxy);
        IThrowableProxy[] suppressed = iThrowableProxy.getSuppressed();
        if (suppressed != null) {
            for (IThrowableProxy iThrowableProxy2 : suppressed) {
                recursiveAppend(sb, CoreConstants.SUPPRESSED, i + 1, iThrowableProxy2);
            }
        }
        recursiveAppend(sb, CoreConstants.CAUSED_BY, i, iThrowableProxy.getCause());
    }

    private void subjoinExceptionMessage(StringBuilder sb, IThrowableProxy iThrowableProxy) {
        sb.append(iThrowableProxy.getClassName());
        sb.append(": ");
        sb.append(iThrowableProxy.getMessage());
    }

    private void subjoinFirstLine(StringBuilder sb, String str, int i, IThrowableProxy iThrowableProxy) {
        ThrowableProxyUtil.indent(sb, i - 1);
        if (str != null) {
            sb.append(str);
        }
        subjoinExceptionMessage(sb, iThrowableProxy);
    }

    @Override // ch.qos.logback.core.pattern.Converter
    public String convert(ILoggingEvent iLoggingEvent) {
        IThrowableProxy throwableProxy = iLoggingEvent.getThrowableProxy();
        if (throwableProxy == null) {
            return "";
        }
        if (this.evaluatorList != null) {
            for (int i = 0; i < this.evaluatorList.size(); i++) {
                EventEvaluator eventEvaluator = (EventEvaluator) this.evaluatorList.get(i);
                try {
                    if (eventEvaluator.evaluate(iLoggingEvent)) {
                        return "";
                    }
                } catch (EvaluationException e) {
                    this.errorCount++;
                    if (this.errorCount < 4) {
                        addError("Exception thrown for evaluator named [" + eventEvaluator.getName() + "]", e);
                    } else if (this.errorCount == 4) {
                        ErrorStatus errorStatus = new ErrorStatus("Exception thrown for evaluator named [" + eventEvaluator.getName() + "].", this, e);
                        errorStatus.add(new ErrorStatus("This was the last warning about this evaluator's errors.We don't want the StatusManager to get flooded.", this));
                        addStatus(errorStatus);
                    }
                }
            }
        }
        return throwableProxyToString(throwableProxy);
    }

    protected void extraData(StringBuilder sb, StackTraceElementProxy stackTraceElementProxy) {
    }

    /* JADX WARN: Code duplicated, block: B:4:0x000a  */
    @Override // ch.qos.logback.core.pattern.DynamicConverter, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        String firstOption = getFirstOption();
        if (firstOption == null) {
            this.lengthOption = Integer.MAX_VALUE;
        } else {
            String lowerCase = firstOption.toLowerCase(Locale.US);
            if (Guest.PAYLOAD_FULL.equals(lowerCase)) {
                this.lengthOption = Integer.MAX_VALUE;
            } else if ("short".equals(lowerCase)) {
                this.lengthOption = 1;
            } else {
                try {
                    this.lengthOption = Integer.parseInt(lowerCase);
                } catch (NumberFormatException unused) {
                    addError("Could not parse [" + lowerCase + "] as an integer");
                    this.lengthOption = Integer.MAX_VALUE;
                }
            }
        }
        List<String> optionList = getOptionList();
        if (optionList != null && optionList.size() > 1) {
            int size = optionList.size();
            for (int i = 1; i < size; i++) {
                String str = optionList.get(i);
                EventEvaluator eventEvaluator = (EventEvaluator) ((Map) getContext().getObject(CoreConstants.EVALUATOR_MAP)).get(str);
                if (eventEvaluator != null) {
                    addEvaluator(eventEvaluator);
                } else {
                    addIgnoreStackTraceLine(str);
                }
            }
        }
        super.start();
    }

    @Override // ch.qos.logback.core.pattern.DynamicConverter, ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.evaluatorList = null;
        super.stop();
    }

    protected void subjoinSTEPArray(StringBuilder sb, int i, IThrowableProxy iThrowableProxy) {
        StackTraceElementProxy[] stackTraceElementProxyArray = iThrowableProxy.getStackTraceElementProxyArray();
        int commonFrames = iThrowableProxy.getCommonFrames();
        int length = this.lengthOption;
        boolean z = length > stackTraceElementProxyArray.length;
        if (z) {
            length = stackTraceElementProxyArray.length;
        }
        if (commonFrames > 0 && z) {
            length -= commonFrames;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            StackTraceElementProxy stackTraceElementProxy = stackTraceElementProxyArray[i3];
            if (isIgnoredStackTraceLine(stackTraceElementProxy.toString())) {
                i2++;
                if (length < stackTraceElementProxyArray.length) {
                    length++;
                }
            } else {
                ThrowableProxyUtil.indent(sb, i);
                printStackLine(sb, i2, stackTraceElementProxy);
                sb.append(CoreConstants.LINE_SEPARATOR);
                i2 = 0;
            }
        }
        if (i2 > 0) {
            printIgnoredCount(sb, i2);
            sb.append(CoreConstants.LINE_SEPARATOR);
        }
        if (commonFrames <= 0 || !z) {
            return;
        }
        ThrowableProxyUtil.indent(sb, i);
        sb.append("... ");
        sb.append(iThrowableProxy.getCommonFrames());
        sb.append(" common frames omitted");
        sb.append(CoreConstants.LINE_SEPARATOR);
    }

    protected String throwableProxyToString(IThrowableProxy iThrowableProxy) {
        StringBuilder sb = new StringBuilder(2048);
        recursiveAppend(sb, null, 1, iThrowableProxy);
        return sb.toString();
    }
}
