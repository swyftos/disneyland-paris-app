package com.contentsquare.android.error.analysis.apierror;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/NetworkEventCounter;", "", "()V", "eventCounter", "", "isMaxNetworkEventLimitReached", "", "()Z", "incrementCounter", "resetCounter", "", "Companion", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkEventCounter {
    private static final int MAX_NETWORK_EVENT_BY_SCREEN = 20;
    private int eventCounter;

    public final int incrementCounter() {
        int i = this.eventCounter;
        this.eventCounter = i + 1;
        return i;
    }

    public final boolean isMaxNetworkEventLimitReached() {
        return this.eventCounter >= 20;
    }

    public final void resetCounter() {
        this.eventCounter = 0;
    }
}
