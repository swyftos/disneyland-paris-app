package ch.qos.logback.core.status;

/* JADX INFO: loaded from: classes2.dex */
public class ErrorStatus extends StatusBase {
    public ErrorStatus(String str, Object obj) {
        super(2, str, obj);
    }

    public ErrorStatus(String str, Object obj, Throwable th) {
        super(2, str, obj, th);
    }
}
