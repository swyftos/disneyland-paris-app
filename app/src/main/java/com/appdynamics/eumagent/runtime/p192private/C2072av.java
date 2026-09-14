package com.appdynamics.eumagent.runtime.p192private;

import ch.qos.logback.core.CoreConstants;
import java.util.List;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.av */
/* JADX INFO: loaded from: classes2.dex */
public final class C2072av {

    /* JADX INFO: renamed from: a */
    public final String f595a;

    /* JADX INFO: renamed from: b */
    public final String f596b;

    /* JADX INFO: renamed from: c */
    public final List<a> f597c;

    /* JADX INFO: renamed from: d */
    public final String f598d;

    /* JADX INFO: renamed from: e */
    public final boolean f599e;

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.av$a */
    public static class a {

        /* JADX INFO: renamed from: a */
        public final String f600a;

        /* JADX INFO: renamed from: b */
        public final long f601b;

        /* JADX INFO: renamed from: c */
        public final long f602c;

        a(String str, Long l, Long l2) {
            this.f600a = str;
            this.f601b = l.longValue();
            this.f602c = l2.longValue();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BT ID: ");
            sb.append(this.f600a);
            if (this.f601b >= 0) {
                sb.append(" Average Response Time: ");
                sb.append(this.f601b);
            }
            if (this.f602c >= 0) {
                sb.append(" Actual Response Time: ");
                sb.append(this.f602c);
            }
            return sb.toString();
        }
    }

    C2072av(String str, String str2, List<a> list, String str3, boolean z) {
        this.f595a = str;
        this.f596b = str2;
        this.f597c = list;
        this.f598d = str3;
        this.f599e = z;
    }

    public final String toString() {
        return "CorrelationContext{clientRequestGUID=" + this.f595a + CoreConstants.SINGLE_QUOTE_CHAR + ", serverSnapshotType='" + this.f596b + CoreConstants.SINGLE_QUOTE_CHAR + ", hasServerEntryPointErrors='" + this.f599e + CoreConstants.SINGLE_QUOTE_CHAR + ", btGlobalAccountName='" + this.f598d + CoreConstants.SINGLE_QUOTE_CHAR + ", relatedBTs='" + this.f597c + CoreConstants.SINGLE_QUOTE_CHAR + '}';
    }
}
