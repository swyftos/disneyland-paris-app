package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.eumagent.runtime.crashes.ProcMapInfo;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ab */
/* JADX INFO: loaded from: classes2.dex */
public final class C2052ab {

    /* JADX INFO: renamed from: c */
    private static BigInteger f495c = new BigInteger("ffffffffffffffff", 16);

    /* JADX INFO: renamed from: a */
    final a[] f496a;

    /* JADX INFO: renamed from: b */
    final boolean f497b;

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ab$b */
    static class b {

        /* JADX INFO: renamed from: a */
        public String f502a;

        /* JADX INFO: renamed from: b */
        public long f503b;

        b(String str, long j) {
            this.f502a = str;
            this.f503b = j;
        }

        public final String toString() {
            return this.f502a + " + " + this.f503b;
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ab$a */
    class a {

        /* JADX INFO: renamed from: a */
        public final BigInteger f498a;

        /* JADX INFO: renamed from: b */
        public final ProcMapInfo.C2048a f499b;

        /* JADX INFO: renamed from: c */
        public final long f500c;

        /* JADX INFO: renamed from: d */
        public b f501d;

        a(BigInteger bigInteger, ProcMapInfo.C2048a c2048a) {
            this.f498a = bigInteger;
            this.f499b = c2048a;
            if (c2048a != null) {
                this.f500c = bigInteger.subtract(c2048a.f457a).longValue();
            } else {
                this.f500c = 0L;
            }
        }
    }

    C2052ab(BigInteger[] bigIntegerArr, ProcMapInfo procMapInfo) {
        ProcMapInfo.C2048a value;
        Map.Entry<BigInteger, ProcMapInfo.C2048a> entryFloorEntry;
        int length = bigIntegerArr.length;
        a[] aVarArr = new a[length];
        boolean z = false;
        for (int i = 0; i < length; i++) {
            BigInteger bigInteger = bigIntegerArr[i];
            if (f495c.equals(bigInteger)) {
                if (i != 31) {
                    throw new IllegalArgumentException("Found truncation mark at position: ".concat(String.valueOf(i)));
                }
                aVarArr = (a[]) Arrays.copyOf(aVarArr, i);
                z = true;
                break;
            }
            if (bigInteger == null || BigInteger.ZERO.equals(bigInteger) || f495c.equals(bigInteger) || (entryFloorEntry = procMapInfo.f449a.floorEntry(bigInteger)) == null || entryFloorEntry.getKey() == null || (value = entryFloorEntry.getValue()) == null || bigInteger.compareTo(value.f458b) >= 0) {
                value = null;
            }
            aVarArr[i] = new a(bigInteger, value);
        }
        this.f497b = z;
        this.f496a = aVarArr;
        ADLog.log(1, "Native Stack frames found: %d", aVarArr.length);
    }

    public final String toString() {
        return "NativeStackInfo{stackFrames=" + Arrays.toString(this.f496a) + ", isTruncated=" + this.f497b + '}';
    }
}
