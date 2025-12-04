package ch.qos.logback.core.pattern.util;

/* loaded from: classes2.dex */
public class RestrictedEscapeUtil implements IEscapeUtil {
    @Override // ch.qos.logback.core.pattern.util.IEscapeUtil
    public void escape(String str, StringBuffer stringBuffer, char c, int i) {
        if (str.indexOf(c) < 0) {
            stringBuffer.append("\\");
        }
        stringBuffer.append(c);
    }
}
