package ch.qos.logback.classic.turbo;

import ch.qos.logback.core.spi.FilterReply;

/* loaded from: classes2.dex */
public abstract class MatchingFilter extends TurboFilter {
    protected FilterReply onMatch;
    protected FilterReply onMismatch;

    public MatchingFilter() {
        FilterReply filterReply = FilterReply.NEUTRAL;
        this.onMatch = filterReply;
        this.onMismatch = filterReply;
    }

    public final void setOnMatch(String str) {
        FilterReply filterReply;
        if ("NEUTRAL".equals(str)) {
            filterReply = FilterReply.NEUTRAL;
        } else if ("ACCEPT".equals(str)) {
            filterReply = FilterReply.ACCEPT;
        } else if (!"DENY".equals(str)) {
            return;
        } else {
            filterReply = FilterReply.DENY;
        }
        this.onMatch = filterReply;
    }

    public final void setOnMismatch(String str) {
        FilterReply filterReply;
        if ("NEUTRAL".equals(str)) {
            filterReply = FilterReply.NEUTRAL;
        } else if ("ACCEPT".equals(str)) {
            filterReply = FilterReply.ACCEPT;
        } else if (!"DENY".equals(str)) {
            return;
        } else {
            filterReply = FilterReply.DENY;
        }
        this.onMismatch = filterReply;
    }
}
