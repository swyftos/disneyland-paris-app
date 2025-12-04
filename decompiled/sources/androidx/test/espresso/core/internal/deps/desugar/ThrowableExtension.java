package androidx.test.espresso.core.internal.deps.desugar;

import ch.qos.logback.core.CoreConstants;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class ThrowableExtension {
    static final int API_LEVEL;
    static final AbstractDesugaringStrategy STRATEGY;

    static abstract class AbstractDesugaringStrategy {
        protected static final Throwable[] EMPTY_THROWABLE_ARRAY = new Throwable[0];

        AbstractDesugaringStrategy() {
        }

        public abstract void printStackTrace(Throwable th, PrintWriter printWriter);
    }

    static final class ConcurrentWeakIdentityHashMap {
        private final ConcurrentHashMap map = new ConcurrentHashMap(16, 0.75f, 10);
        private final ReferenceQueue referenceQueue = new ReferenceQueue();

        private static final class WeakKey extends WeakReference<Throwable> {
            private final int hash;

            public WeakKey(Throwable th, ReferenceQueue referenceQueue) {
                super(th, referenceQueue);
                if (th == null) {
                    throw new NullPointerException("The referent cannot be null");
                }
                this.hash = System.identityHashCode(th);
            }

            public boolean equals(Object obj) {
                if (obj == null || obj.getClass() != WeakKey.class) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                WeakKey weakKey = (WeakKey) obj;
                return this.hash == weakKey.hash && get() == weakKey.get();
            }

            public int hashCode() {
                return this.hash;
            }
        }

        ConcurrentWeakIdentityHashMap() {
        }

        void deleteEmptyKeys() {
            while (true) {
                Reference referencePoll = this.referenceQueue.poll();
                if (referencePoll == null) {
                    return;
                } else {
                    this.map.remove(referencePoll);
                }
            }
        }

        public List get(Throwable th, boolean z) {
            deleteEmptyKeys();
            List list = (List) this.map.get(new WeakKey(th, null));
            if (!z || list != null) {
                return list;
            }
            Vector vector = new Vector(2);
            List list2 = (List) this.map.putIfAbsent(new WeakKey(th, this.referenceQueue), vector);
            return list2 == null ? vector : list2;
        }
    }

    static final class MimicDesugaringStrategy extends AbstractDesugaringStrategy {
        private final ConcurrentWeakIdentityHashMap map = new ConcurrentWeakIdentityHashMap();

        MimicDesugaringStrategy() {
        }

        @Override // androidx.test.espresso.core.internal.deps.desugar.ThrowableExtension.AbstractDesugaringStrategy
        public void printStackTrace(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
            List<Throwable> list = this.map.get(th, false);
            if (list == null) {
                return;
            }
            synchronized (list) {
                try {
                    for (Throwable th2 : list) {
                        printWriter.print(CoreConstants.SUPPRESSED);
                        th2.printStackTrace(printWriter);
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
    }

    static final class NullDesugaringStrategy extends AbstractDesugaringStrategy {
        NullDesugaringStrategy() {
        }

        @Override // androidx.test.espresso.core.internal.deps.desugar.ThrowableExtension.AbstractDesugaringStrategy
        public void printStackTrace(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    static final class ReuseDesugaringStrategy extends AbstractDesugaringStrategy {
        ReuseDesugaringStrategy() {
        }

        @Override // androidx.test.espresso.core.internal.deps.desugar.ThrowableExtension.AbstractDesugaringStrategy
        public void printStackTrace(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    public static void printStackTrace(Throwable th, PrintWriter printWriter) {
        STRATEGY.printStackTrace(th, printWriter);
    }

    private static Integer readApiLevelFromBuildVersion() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            PrintStream printStream = System.err;
            printStream.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(printStream);
            return null;
        }
    }

    private static boolean useMimicStrategy() {
        return !Boolean.getBoolean("androidx.test.espresso.core.internal.deps.desugar.twr_disable_mimic");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0006, B:6:0x000e, B:9:0x0016, B:11:0x001c, B:12:0x0022), top: B:24:0x0006 }] */
    static {
        /*
            java.lang.Integer r0 = readApiLevelFromBuildVersion()     // Catch: java.lang.Throwable -> L28
            if (r0 == 0) goto L16
            int r1 = r0.intValue()     // Catch: java.lang.Throwable -> L14
            r2 = 19
            if (r1 < r2) goto L16
            androidx.test.espresso.core.internal.deps.desugar.ThrowableExtension$ReuseDesugaringStrategy r1 = new androidx.test.espresso.core.internal.deps.desugar.ThrowableExtension$ReuseDesugaringStrategy     // Catch: java.lang.Throwable -> L14
            r1.<init>()     // Catch: java.lang.Throwable -> L14
            goto L5a
        L14:
            r1 = move-exception
            goto L2a
        L16:
            boolean r1 = useMimicStrategy()     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L22
            androidx.test.espresso.core.internal.deps.desugar.ThrowableExtension$MimicDesugaringStrategy r1 = new androidx.test.espresso.core.internal.deps.desugar.ThrowableExtension$MimicDesugaringStrategy     // Catch: java.lang.Throwable -> L14
            r1.<init>()     // Catch: java.lang.Throwable -> L14
            goto L5a
        L22:
            androidx.test.espresso.core.internal.deps.desugar.ThrowableExtension$NullDesugaringStrategy r1 = new androidx.test.espresso.core.internal.deps.desugar.ThrowableExtension$NullDesugaringStrategy     // Catch: java.lang.Throwable -> L14
            r1.<init>()     // Catch: java.lang.Throwable -> L14
            goto L5a
        L28:
            r1 = move-exception
            r0 = 0
        L2a:
            java.io.PrintStream r2 = java.lang.System.err
            java.lang.Class<androidx.test.espresso.core.internal.deps.desugar.ThrowableExtension$NullDesugaringStrategy> r3 = androidx.test.espresso.core.internal.deps.desugar.ThrowableExtension.NullDesugaringStrategy.class
            java.lang.String r3 = r3.getName()
            int r4 = r3.length()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            int r4 = r4 + 133
            r5.<init>(r4)
            java.lang.String r4 = "An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy "
            r5.append(r4)
            r5.append(r3)
            java.lang.String r3 = "will be used. The error is: "
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r2.println(r3)
            r1.printStackTrace(r2)
            androidx.test.espresso.core.internal.deps.desugar.ThrowableExtension$NullDesugaringStrategy r1 = new androidx.test.espresso.core.internal.deps.desugar.ThrowableExtension$NullDesugaringStrategy
            r1.<init>()
        L5a:
            androidx.test.espresso.core.internal.deps.desugar.ThrowableExtension.STRATEGY = r1
            if (r0 != 0) goto L60
            r0 = 1
            goto L64
        L60:
            int r0 = r0.intValue()
        L64:
            androidx.test.espresso.core.internal.deps.desugar.ThrowableExtension.API_LEVEL = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.desugar.ThrowableExtension.<clinit>():void");
    }
}
