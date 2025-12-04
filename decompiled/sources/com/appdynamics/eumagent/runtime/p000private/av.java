package com.appdynamics.eumagent.runtime.p000private;

import ch.qos.logback.core.CoreConstants;
import java.util.List;

/* loaded from: classes2.dex */
public final class av {
    public final String a;
    public final String b;
    public final List<a> c;
    public final String d;
    public final boolean e;

    public static class a {
        public final String a;
        public final long b;
        public final long c;

        a(String str, Long l, Long l2) {
            this.a = str;
            this.b = l.longValue();
            this.c = l2.longValue();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BT ID: ");
            sb.append(this.a);
            if (this.b >= 0) {
                sb.append(" Average Response Time: ");
                sb.append(this.b);
            }
            if (this.c >= 0) {
                sb.append(" Actual Response Time: ");
                sb.append(this.c);
            }
            return sb.toString();
        }
    }

    av(String str, String str2, List<a> list, String str3, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = list;
        this.d = str3;
        this.e = z;
    }

    public final String toString() {
        return "CorrelationContext{clientRequestGUID=" + this.a + CoreConstants.SINGLE_QUOTE_CHAR + ", serverSnapshotType='" + this.b + CoreConstants.SINGLE_QUOTE_CHAR + ", hasServerEntryPointErrors='" + this.e + CoreConstants.SINGLE_QUOTE_CHAR + ", btGlobalAccountName='" + this.d + CoreConstants.SINGLE_QUOTE_CHAR + ", relatedBTs='" + this.c + CoreConstants.SINGLE_QUOTE_CHAR + '}';
    }
}
