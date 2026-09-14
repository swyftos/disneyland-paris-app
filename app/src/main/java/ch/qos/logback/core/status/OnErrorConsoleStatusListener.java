package ch.qos.logback.core.status;

import java.io.PrintStream;

/* JADX INFO: loaded from: classes2.dex */
public class OnErrorConsoleStatusListener extends OnPrintStreamStatusListenerBase {
    @Override // ch.qos.logback.core.status.OnPrintStreamStatusListenerBase
    protected PrintStream getPrintStream() {
        return System.err;
    }
}
