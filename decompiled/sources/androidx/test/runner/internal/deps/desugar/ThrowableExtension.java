package androidx.test.runner.internal.deps.desugar;

import ch.qos.logback.core.CoreConstants;
import com.urbanairship.reactnative.ReactMessageView;
import java.io.Closeable;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class ThrowableExtension {
    static final int API_LEVEL;
    static final AbstractDesugaringStrategy STRATEGY;
    public static final String SYSTEM_PROPERTY_TWR_DISABLE_MIMIC = "androidx.test.runner.internal.deps.desugar.twr_disable_mimic";

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
            androidx.test.runner.internal.deps.desugar.ThrowableExtension$ReuseDesugaringStrategy r1 = new androidx.test.runner.internal.deps.desugar.ThrowableExtension$ReuseDesugaringStrategy     // Catch: java.lang.Throwable -> L14
            r1.<init>()     // Catch: java.lang.Throwable -> L14
            goto L5a
        L14:
            r1 = move-exception
            goto L2a
        L16:
            boolean r1 = useMimicStrategy()     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L22
            androidx.test.runner.internal.deps.desugar.ThrowableExtension$MimicDesugaringStrategy r1 = new androidx.test.runner.internal.deps.desugar.ThrowableExtension$MimicDesugaringStrategy     // Catch: java.lang.Throwable -> L14
            r1.<init>()     // Catch: java.lang.Throwable -> L14
            goto L5a
        L22:
            androidx.test.runner.internal.deps.desugar.ThrowableExtension$NullDesugaringStrategy r1 = new androidx.test.runner.internal.deps.desugar.ThrowableExtension$NullDesugaringStrategy     // Catch: java.lang.Throwable -> L14
            r1.<init>()     // Catch: java.lang.Throwable -> L14
            goto L5a
        L28:
            r1 = move-exception
            r0 = 0
        L2a:
            java.io.PrintStream r2 = java.lang.System.err
            java.lang.Class<androidx.test.runner.internal.deps.desugar.ThrowableExtension$NullDesugaringStrategy> r3 = androidx.test.runner.internal.deps.desugar.ThrowableExtension.NullDesugaringStrategy.class
            java.lang.String r3 = r3.getName()
            int r4 = r3.length()
            int r4 = r4 + 133
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy "
            r5.append(r4)
            r5.append(r3)
            java.lang.String r3 = "will be used. The error is: "
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r2.println(r3)
            r1.printStackTrace(r2)
            androidx.test.runner.internal.deps.desugar.ThrowableExtension$NullDesugaringStrategy r1 = new androidx.test.runner.internal.deps.desugar.ThrowableExtension$NullDesugaringStrategy
            r1.<init>()
        L5a:
            androidx.test.runner.internal.deps.desugar.ThrowableExtension.STRATEGY = r1
            if (r0 != 0) goto L60
            r0 = 1
            goto L64
        L60:
            int r0 = r0.intValue()
        L64:
            androidx.test.runner.internal.deps.desugar.ThrowableExtension.API_LEVEL = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.test.runner.internal.deps.desugar.ThrowableExtension.<clinit>():void");
    }

    public static AbstractDesugaringStrategy getStrategy() {
        return STRATEGY;
    }

    public static void addSuppressed(Throwable th, Throwable th2) {
        STRATEGY.addSuppressed(th, th2);
    }

    public static Throwable[] getSuppressed(Throwable th) {
        return STRATEGY.getSuppressed(th);
    }

    public static void printStackTrace(Throwable th) {
        STRATEGY.printStackTrace(th);
    }

    public static void printStackTrace(Throwable th, PrintWriter printWriter) {
        STRATEGY.printStackTrace(th, printWriter);
    }

    public static void printStackTrace(Throwable th, PrintStream printStream) {
        STRATEGY.printStackTrace(th, printStream);
    }

    public static void closeResource(Throwable th, Object obj) throws Throwable {
        if (obj == null) {
            return;
        }
        try {
            if (API_LEVEL >= 19) {
                ((AutoCloseable) obj).close();
                return;
            }
            if (obj instanceof Closeable) {
                ((Closeable) obj).close();
                return;
            }
            try {
                obj.getClass().getMethod(ReactMessageView.EVENT_CLOSE, new Class[0]).invoke(obj, new Object[0]);
            } catch (ExceptionInInitializerError | IllegalAccessException | IllegalArgumentException e) {
                String strValueOf = String.valueOf(obj.getClass());
                StringBuilder sb = new StringBuilder(strValueOf.length() + 24);
                sb.append("Fail to call close() on ");
                sb.append(strValueOf);
                throw new AssertionError(sb.toString(), e);
            } catch (NoSuchMethodException | SecurityException e2) {
                String strValueOf2 = String.valueOf(obj.getClass());
                StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 32);
                sb2.append(strValueOf2);
                sb2.append(" does not have a close() method.");
                throw new AssertionError(sb2.toString(), e2);
            } catch (InvocationTargetException e3) {
                throw e3.getCause();
            }
        } catch (Throwable th2) {
            if (th != null) {
                addSuppressed(th, th2);
                throw th;
            }
            throw th2;
        }
    }

    private static boolean useMimicStrategy() {
        return !Boolean.getBoolean(SYSTEM_PROPERTY_TWR_DISABLE_MIMIC);
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

    static abstract class AbstractDesugaringStrategy {
        protected static final Throwable[] EMPTY_THROWABLE_ARRAY = new Throwable[0];

        public abstract void addSuppressed(Throwable th, Throwable th2);

        public abstract Throwable[] getSuppressed(Throwable th);

        public abstract void printStackTrace(Throwable th);

        public abstract void printStackTrace(Throwable th, PrintStream printStream);

        public abstract void printStackTrace(Throwable th, PrintWriter printWriter);

        AbstractDesugaringStrategy() {
        }
    }

    static final class ReuseDesugaringStrategy extends AbstractDesugaringStrategy {
        ReuseDesugaringStrategy() {
        }

        @Override // androidx.test.runner.internal.deps.desugar.ThrowableExtension.AbstractDesugaringStrategy
        public void addSuppressed(Throwable th, Throwable th2) {
            th.addSuppressed(th2);
        }

        @Override // androidx.test.runner.internal.deps.desugar.ThrowableExtension.AbstractDesugaringStrategy
        public Throwable[] getSuppressed(Throwable th) {
            return th.getSuppressed();
        }

        @Override // androidx.test.runner.internal.deps.desugar.ThrowableExtension.AbstractDesugaringStrategy
        public void printStackTrace(Throwable th) {
            th.printStackTrace();
        }

        @Override // androidx.test.runner.internal.deps.desugar.ThrowableExtension.AbstractDesugaringStrategy
        public void printStackTrace(Throwable th, PrintStream printStream) {
            th.printStackTrace(printStream);
        }

        @Override // androidx.test.runner.internal.deps.desugar.ThrowableExtension.AbstractDesugaringStrategy
        public void printStackTrace(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    static final class MimicDesugaringStrategy extends AbstractDesugaringStrategy {
        private final ConcurrentWeakIdentityHashMap map = new ConcurrentWeakIdentityHashMap();

        MimicDesugaringStrategy() {
        }

        @Override // androidx.test.runner.internal.deps.desugar.ThrowableExtension.AbstractDesugaringStrategy
        public void addSuppressed(Throwable th, Throwable th2) {
            if (th2 == th) {
                throw new IllegalArgumentException("Self suppression is not allowed.", th2);
            }
            if (th2 == null) {
                throw new NullPointerException("The suppressed exception cannot be null.");
            }
            this.map.get(th, true).add(th2);
        }

        @Override // androidx.test.runner.internal.deps.desugar.ThrowableExtension.AbstractDesugaringStrategy
        public Throwable[] getSuppressed(Throwable th) {
            List list = this.map.get(th, false);
            if (list == null || list.isEmpty()) {
                return AbstractDesugaringStrategy.EMPTY_THROWABLE_ARRAY;
            }
            return (Throwable[]) list.toArray(AbstractDesugaringStrategy.EMPTY_THROWABLE_ARRAY);
        }

        @Override // androidx.test.runner.internal.deps.desugar.ThrowableExtension.AbstractDesugaringStrategy
        public void printStackTrace(Throwable th) {
            th.printStackTrace();
            List<Throwable> list = this.map.get(th, false);
            if (list == null) {
                return;
            }
            synchronized (list) {
                try {
                    for (Throwable th2 : list) {
                        System.err.print(CoreConstants.SUPPRESSED);
                        th2.printStackTrace();
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        @Override // androidx.test.runner.internal.deps.desugar.ThrowableExtension.AbstractDesugaringStrategy
        public void printStackTrace(Throwable th, PrintStream printStream) {
            th.printStackTrace(printStream);
            List<Throwable> list = this.map.get(th, false);
            if (list == null) {
                return;
            }
            synchronized (list) {
                try {
                    for (Throwable th2 : list) {
                        printStream.print(CoreConstants.SUPPRESSED);
                        th2.printStackTrace(printStream);
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        @Override // androidx.test.runner.internal.deps.desugar.ThrowableExtension.AbstractDesugaringStrategy
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

    static final class ConcurrentWeakIdentityHashMap {
        private final ConcurrentHashMap map = new ConcurrentHashMap(16, 0.75f, 10);
        private final ReferenceQueue referenceQueue = new ReferenceQueue();

        ConcurrentWeakIdentityHashMap() {
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

        private static final class WeakKey extends WeakReference<Throwable> {
            private final int hash;

            public WeakKey(Throwable th, ReferenceQueue referenceQueue) {
                super(th, referenceQueue);
                if (th == null) {
                    throw new NullPointerException("The referent cannot be null");
                }
                this.hash = System.identityHashCode(th);
            }

            public int hashCode() {
                return this.hash;
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
        }
    }

    static final class NullDesugaringStrategy extends AbstractDesugaringStrategy {
        @Override // androidx.test.runner.internal.deps.desugar.ThrowableExtension.AbstractDesugaringStrategy
        public void addSuppressed(Throwable th, Throwable th2) {
        }

        NullDesugaringStrategy() {
        }

        @Override // androidx.test.runner.internal.deps.desugar.ThrowableExtension.AbstractDesugaringStrategy
        public Throwable[] getSuppressed(Throwable th) {
            return AbstractDesugaringStrategy.EMPTY_THROWABLE_ARRAY;
        }

        @Override // androidx.test.runner.internal.deps.desugar.ThrowableExtension.AbstractDesugaringStrategy
        public void printStackTrace(Throwable th) {
            th.printStackTrace();
        }

        @Override // androidx.test.runner.internal.deps.desugar.ThrowableExtension.AbstractDesugaringStrategy
        public void printStackTrace(Throwable th, PrintStream printStream) {
            th.printStackTrace(printStream);
        }

        @Override // androidx.test.runner.internal.deps.desugar.ThrowableExtension.AbstractDesugaringStrategy
        public void printStackTrace(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }
}
