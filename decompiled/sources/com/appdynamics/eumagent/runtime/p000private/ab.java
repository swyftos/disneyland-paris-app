package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.crashes.ProcMapInfo;
import java.math.BigInteger;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ab {
    private static BigInteger c = new BigInteger("ffffffffffffffff", 16);
    final a[] a;
    final boolean b;

    static class b {
        public String a;
        public long b;

        b(String str, long j) {
            this.a = str;
            this.b = j;
        }

        public final String toString() {
            return this.a + " + " + this.b;
        }
    }

    class a {
        public final BigInteger a;
        public final ProcMapInfo.a b;
        public final long c;
        public b d;

        a(BigInteger bigInteger, ProcMapInfo.a aVar) {
            this.a = bigInteger;
            this.b = aVar;
            if (aVar != null) {
                this.c = bigInteger.subtract(aVar.a).longValue();
            } else {
                this.c = 0L;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0070, code lost:
    
        r7.b = r2;
        r7.a = r1;
        com.appdynamics.eumagent.runtime.logging.ADLog.log(1, "Native Stack frames found: %d", r1.length);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    ab(java.math.BigInteger[] r8, com.appdynamics.eumagent.runtime.crashes.ProcMapInfo r9) {
        /*
            r7 = this;
            r7.<init>()
            int r0 = r8.length
            com.appdynamics.eumagent.runtime.private.ab$a[] r1 = new com.appdynamics.eumagent.runtime.private.ab.a[r0]
            r2 = 0
            r3 = r2
        L8:
            r4 = 1
            if (r3 >= r0) goto L70
            r5 = r8[r3]
            java.math.BigInteger r6 = com.appdynamics.eumagent.runtime.p000private.ab.c
            boolean r6 = r6.equals(r5)
            if (r6 == 0) goto L32
            r8 = 31
            if (r3 != r8) goto L22
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r1, r3)
            r1 = r8
            com.appdynamics.eumagent.runtime.private.ab$a[] r1 = (com.appdynamics.eumagent.runtime.private.ab.a[]) r1
            r2 = r4
            goto L70
        L22:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Found truncation mark at position: "
            java.lang.String r9 = java.lang.String.valueOf(r3)
            java.lang.String r8 = r8.concat(r9)
            r7.<init>(r8)
            throw r7
        L32:
            if (r5 == 0) goto L65
            java.math.BigInteger r4 = java.math.BigInteger.ZERO
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L65
            java.math.BigInteger r4 = com.appdynamics.eumagent.runtime.p000private.ab.c
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L65
            java.util.TreeMap<java.math.BigInteger, com.appdynamics.eumagent.runtime.crashes.ProcMapInfo$a> r4 = r9.a
            java.util.Map$Entry r4 = r4.floorEntry(r5)
            if (r4 == 0) goto L65
            java.lang.Object r6 = r4.getKey()
            java.math.BigInteger r6 = (java.math.BigInteger) r6
            if (r6 == 0) goto L65
            java.lang.Object r4 = r4.getValue()
            com.appdynamics.eumagent.runtime.crashes.ProcMapInfo$a r4 = (com.appdynamics.eumagent.runtime.crashes.ProcMapInfo.a) r4
            if (r4 == 0) goto L65
            java.math.BigInteger r6 = r4.b
            int r6 = r5.compareTo(r6)
            if (r6 >= 0) goto L65
            goto L66
        L65:
            r4 = 0
        L66:
            com.appdynamics.eumagent.runtime.private.ab$a r6 = new com.appdynamics.eumagent.runtime.private.ab$a
            r6.<init>(r5, r4)
            r1[r3] = r6
            int r3 = r3 + 1
            goto L8
        L70:
            r7.b = r2
            r7.a = r1
            java.lang.String r7 = "Native Stack frames found: %d"
            int r8 = r1.length
            com.appdynamics.eumagent.runtime.logging.ADLog.log(r4, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appdynamics.eumagent.runtime.p000private.ab.<init>(java.math.BigInteger[], com.appdynamics.eumagent.runtime.crashes.ProcMapInfo):void");
    }

    public final String toString() {
        return "NativeStackInfo{stackFrames=" + Arrays.toString(this.a) + ", isTruncated=" + this.b + '}';
    }
}
