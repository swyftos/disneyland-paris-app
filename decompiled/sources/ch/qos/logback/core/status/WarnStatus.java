package ch.qos.logback.core.status;

/* loaded from: classes2.dex */
public class WarnStatus extends StatusBase {
    public WarnStatus(String str, Object obj) {
        super(1, str, obj);
    }

    public WarnStatus(String str, Object obj, Throwable th) {
        super(1, str, obj, th);
    }
}
