package ch.qos.logback.core.pattern.util;

/* JADX INFO: loaded from: classes2.dex */
public class AlmostAsIsEscapeUtil extends RestrictedEscapeUtil {
    @Override // ch.qos.logback.core.pattern.util.RestrictedEscapeUtil, ch.qos.logback.core.pattern.util.IEscapeUtil
    public void escape(String str, StringBuffer stringBuffer, char c, int i) {
        super.escape("%)", stringBuffer, c, i);
    }
}
