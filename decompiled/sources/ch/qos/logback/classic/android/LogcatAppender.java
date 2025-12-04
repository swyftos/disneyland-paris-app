package ch.qos.logback.classic.android;

import android.util.Log;
import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Layout;
import ch.qos.logback.core.UnsynchronizedAppenderBase;

/* loaded from: classes2.dex */
public class LogcatAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {
    private PatternLayoutEncoder encoder = null;
    private PatternLayoutEncoder tagEncoder = null;
    private boolean checkLoggable = false;

    @Override // ch.qos.logback.core.UnsynchronizedAppenderBase
    public void append(ILoggingEvent iLoggingEvent) {
        if (isStarted()) {
            String tag = getTag(iLoggingEvent);
            int i = iLoggingEvent.getLevel().levelInt;
            if (i == Integer.MIN_VALUE || i == 5000) {
                if (!this.checkLoggable || Log.isLoggable(tag, 2)) {
                    Log.v(tag, this.encoder.getLayout().doLayout(iLoggingEvent));
                    return;
                }
                return;
            }
            if (i == 10000) {
                if (!this.checkLoggable || Log.isLoggable(tag, 3)) {
                    Log.d(tag, this.encoder.getLayout().doLayout(iLoggingEvent));
                    return;
                }
                return;
            }
            if (i == 20000) {
                if (!this.checkLoggable || Log.isLoggable(tag, 4)) {
                    Log.i(tag, this.encoder.getLayout().doLayout(iLoggingEvent));
                    return;
                }
                return;
            }
            if (i == 30000) {
                if (!this.checkLoggable || Log.isLoggable(tag, 5)) {
                    Log.w(tag, this.encoder.getLayout().doLayout(iLoggingEvent));
                    return;
                }
                return;
            }
            if (i != 40000) {
                return;
            }
            if (!this.checkLoggable || Log.isLoggable(tag, 6)) {
                Log.e(tag, this.encoder.getLayout().doLayout(iLoggingEvent));
            }
        }
    }

    public boolean getCheckLoggable() {
        return this.checkLoggable;
    }

    public PatternLayoutEncoder getEncoder() {
        return this.encoder;
    }

    protected String getTag(ILoggingEvent iLoggingEvent) {
        PatternLayoutEncoder patternLayoutEncoder = this.tagEncoder;
        String strDoLayout = patternLayoutEncoder != null ? patternLayoutEncoder.getLayout().doLayout(iLoggingEvent) : iLoggingEvent.getLoggerName();
        if (!this.checkLoggable || strDoLayout.length() <= 23) {
            return strDoLayout;
        }
        return strDoLayout.substring(0, 22) + "*";
    }

    public PatternLayoutEncoder getTagEncoder() {
        return this.tagEncoder;
    }

    public void setCheckLoggable(boolean z) {
        this.checkLoggable = z;
    }

    public void setEncoder(PatternLayoutEncoder patternLayoutEncoder) {
        this.encoder = patternLayoutEncoder;
    }

    public void setTagEncoder(PatternLayoutEncoder patternLayoutEncoder) {
        this.tagEncoder = patternLayoutEncoder;
    }

    @Override // ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        StringBuilder sb;
        String str;
        PatternLayoutEncoder patternLayoutEncoder = this.encoder;
        if (patternLayoutEncoder != null && patternLayoutEncoder.getLayout() != null) {
            PatternLayoutEncoder patternLayoutEncoder2 = this.tagEncoder;
            if (patternLayoutEncoder2 != null) {
                Layout<ILoggingEvent> layout = patternLayoutEncoder2.getLayout();
                if (layout == null) {
                    sb = new StringBuilder();
                    str = "No tag layout set for the appender named [";
                } else if (layout instanceof PatternLayout) {
                    String pattern = this.tagEncoder.getPattern();
                    if (!pattern.contains("%nopex")) {
                        this.tagEncoder.stop();
                        this.tagEncoder.setPattern(pattern + "%nopex");
                        this.tagEncoder.start();
                    }
                    ((PatternLayout) layout).setPostCompileProcessor(null);
                }
            }
            super.start();
            return;
        }
        sb = new StringBuilder();
        str = "No layout set for the appender named [";
        sb.append(str);
        sb.append(this.name);
        sb.append("].");
        addError(sb.toString());
    }
}
