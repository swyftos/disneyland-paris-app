package ch.qos.logback.core.pattern.util;

/* JADX INFO: loaded from: classes2.dex */
public class AsIsEscapeUtil implements IEscapeUtil {
    @Override // ch.qos.logback.core.pattern.util.IEscapeUtil
    public void escape(String str, StringBuffer stringBuffer, char c, int i) {
        stringBuffer.append("\\");
        stringBuffer.append(c);
    }
}
