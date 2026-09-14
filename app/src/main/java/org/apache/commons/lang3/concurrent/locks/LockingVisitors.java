package org.apache.commons.lang3.concurrent.locks;

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;
import java.util.function.Supplier;
import org.apache.commons.lang3.builder.AbstractSupplier;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableFunction;
import org.apache.commons.lang3.function.Suppliers;

/* JADX INFO: loaded from: classes6.dex */
public class LockingVisitors {

    public static class LockVisitor<O, L> {
        private final Object lock;
        private final Object object;
        private final Supplier readLockSupplier;
        private final Supplier writeLockSupplier;

        public static class LVBuilder<O, L, B extends LVBuilder<O, L, B>> extends AbstractSupplier<LockVisitor<O, L>, B, RuntimeException> {
            Object lock;
            Object object;
            private Supplier readLockSupplier;
            private Supplier writeLockSupplier;

            @Override // org.apache.commons.lang3.function.FailableSupplier
            public LockVisitor<O, L> get() {
                return new LockVisitor<>(this);
            }

            public B setLock(L l) {
                this.lock = l;
                return asThis();
            }

            public B setObject(O o) {
                this.object = o;
                return asThis();
            }

            public B setReadLockSupplier(Supplier<Lock> supplier) {
                this.readLockSupplier = supplier;
                return asThis();
            }

            public B setWriteLockSupplier(Supplier<Lock> supplier) {
                this.writeLockSupplier = supplier;
                return asThis();
            }
        }

        private LockVisitor(LVBuilder lVBuilder) {
            Object obj = lVBuilder.object;
            Objects.requireNonNull(obj, "object");
            this.object = obj;
            Object obj2 = lVBuilder.lock;
            Objects.requireNonNull(obj2, "lock");
            this.lock = obj2;
            Supplier supplier = lVBuilder.readLockSupplier;
            Objects.requireNonNull(supplier, "readLockSupplier");
            this.readLockSupplier = supplier;
            Supplier supplier2 = lVBuilder.writeLockSupplier;
            Objects.requireNonNull(supplier2, "writeLockSupplier");
            this.writeLockSupplier = supplier2;
        }

        protected LockVisitor(O o, L l, Supplier<Lock> supplier, Supplier<Lock> supplier2) {
            Objects.requireNonNull(o, "object");
            this.object = o;
            Objects.requireNonNull(l, "lock");
            this.lock = l;
            Objects.requireNonNull(supplier, "readLockSupplier");
            this.readLockSupplier = supplier;
            Objects.requireNonNull(supplier2, "writeLockSupplier");
            this.writeLockSupplier = supplier2;
        }

        public void acceptReadLocked(FailableConsumer<O, ?> failableConsumer) {
            lockAcceptUnlock(this.readLockSupplier, failableConsumer);
        }

        public void acceptWriteLocked(FailableConsumer<O, ?> failableConsumer) {
            lockAcceptUnlock(this.writeLockSupplier, failableConsumer);
        }

        public <T> T applyReadLocked(FailableFunction<O, T, ?> failableFunction) {
            return (T) lockApplyUnlock(this.readLockSupplier, failableFunction);
        }

        public <T> T applyWriteLocked(FailableFunction<O, T, ?> failableFunction) {
            return (T) lockApplyUnlock(this.writeLockSupplier, failableFunction);
        }

        public L getLock() {
            return (L) this.lock;
        }

        public O getObject() {
            return (O) this.object;
        }

        protected void lockAcceptUnlock(Supplier<Lock> supplier, FailableConsumer<O, ?> failableConsumer) {
            Lock lock = (Lock) Suppliers.get(supplier);
            Objects.requireNonNull(lock, "lock");
            Lock lock2 = lock;
            lock2.lock();
            try {
                Failable.accept(failableConsumer, this.object);
            } finally {
                lock2.unlock();
            }
        }

        protected <T> T lockApplyUnlock(Supplier<Lock> supplier, FailableFunction<O, T, ?> failableFunction) {
            Lock lock = (Lock) Suppliers.get(supplier);
            Objects.requireNonNull(lock, "lock");
            Lock lock2 = lock;
            lock2.lock();
            try {
                return (T) Failable.apply(failableFunction, this.object);
            } finally {
                lock2.unlock();
            }
        }
    }

    public static class ReadWriteLockVisitor<O> extends LockVisitor<O, ReadWriteLock> {

        public static class Builder<O> extends LockVisitor.LVBuilder<O, ReadWriteLock, Builder<O>> {
            @Override // org.apache.commons.lang3.concurrent.locks.LockingVisitors.LockVisitor.LVBuilder, org.apache.commons.lang3.function.FailableSupplier
            public ReadWriteLockVisitor<O> get() {
                return new ReadWriteLockVisitor<>(this);
            }

            @Override // org.apache.commons.lang3.concurrent.locks.LockingVisitors.LockVisitor.LVBuilder
            public Builder<O> setLock(ReadWriteLock readWriteLock) {
                Objects.requireNonNull(readWriteLock);
                setReadLockSupplier(new LockingVisitors$ReadWriteLockVisitor$$ExternalSyntheticLambda0(readWriteLock));
                setWriteLockSupplier(new LockingVisitors$ReadWriteLockVisitor$$ExternalSyntheticLambda1(readWriteLock));
                return (Builder) super.setLock(readWriteLock);
            }
        }

        public static <O> Builder<O> builder() {
            return new Builder<>();
        }

        private ReadWriteLockVisitor(Builder builder) {
            super(builder);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        protected ReadWriteLockVisitor(O o, ReadWriteLock readWriteLock) {
            super(o, readWriteLock, new LockingVisitors$ReadWriteLockVisitor$$ExternalSyntheticLambda0(readWriteLock), new LockingVisitors$ReadWriteLockVisitor$$ExternalSyntheticLambda1(readWriteLock));
            Objects.requireNonNull(readWriteLock);
        }
    }

    public static class ReentrantLockVisitor<O> extends LockVisitor<O, ReentrantLock> {
        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Lock lambda$new$0(ReentrantLock reentrantLock) {
            return reentrantLock;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Lock lambda$new$1(ReentrantLock reentrantLock) {
            return reentrantLock;
        }

        public static class Builder<O> extends LockVisitor.LVBuilder<O, ReentrantLock, Builder<O>> {
            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ Lock lambda$setLock$0(ReentrantLock reentrantLock) {
                return reentrantLock;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ Lock lambda$setLock$1(ReentrantLock reentrantLock) {
                return reentrantLock;
            }

            @Override // org.apache.commons.lang3.concurrent.locks.LockingVisitors.LockVisitor.LVBuilder, org.apache.commons.lang3.function.FailableSupplier
            public ReentrantLockVisitor<O> get() {
                return new ReentrantLockVisitor<>(this);
            }

            @Override // org.apache.commons.lang3.concurrent.locks.LockingVisitors.LockVisitor.LVBuilder
            public Builder<O> setLock(final ReentrantLock reentrantLock) {
                setReadLockSupplier(new Supplier() { // from class: org.apache.commons.lang3.concurrent.locks.LockingVisitors$ReentrantLockVisitor$Builder$$ExternalSyntheticLambda0
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return LockingVisitors.ReentrantLockVisitor.Builder.lambda$setLock$0(reentrantLock);
                    }
                });
                setWriteLockSupplier(new Supplier() { // from class: org.apache.commons.lang3.concurrent.locks.LockingVisitors$ReentrantLockVisitor$Builder$$ExternalSyntheticLambda1
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return LockingVisitors.ReentrantLockVisitor.Builder.lambda$setLock$1(reentrantLock);
                    }
                });
                return (Builder) super.setLock(reentrantLock);
            }
        }

        public static <O> Builder<O> builder() {
            return new Builder<>();
        }

        private ReentrantLockVisitor(Builder builder) {
            super(builder);
        }

        protected ReentrantLockVisitor(O o, final ReentrantLock reentrantLock) {
            super(o, reentrantLock, new Supplier() { // from class: org.apache.commons.lang3.concurrent.locks.LockingVisitors$ReentrantLockVisitor$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return LockingVisitors.ReentrantLockVisitor.lambda$new$0(reentrantLock);
                }
            }, new Supplier() { // from class: org.apache.commons.lang3.concurrent.locks.LockingVisitors$ReentrantLockVisitor$$ExternalSyntheticLambda1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return LockingVisitors.ReentrantLockVisitor.lambda$new$1(reentrantLock);
                }
            });
        }
    }

    public static class StampedLockVisitor<O> extends LockVisitor<O, StampedLock> {

        public static class Builder<O> extends LockVisitor.LVBuilder<O, StampedLock, Builder<O>> {
            @Override // org.apache.commons.lang3.concurrent.locks.LockingVisitors.LockVisitor.LVBuilder, org.apache.commons.lang3.function.FailableSupplier
            public StampedLockVisitor<O> get() {
                return new StampedLockVisitor<>(this);
            }

            @Override // org.apache.commons.lang3.concurrent.locks.LockingVisitors.LockVisitor.LVBuilder
            public Builder<O> setLock(StampedLock stampedLock) {
                Objects.requireNonNull(stampedLock);
                setReadLockSupplier(new LockingVisitors$StampedLockVisitor$$ExternalSyntheticLambda0(stampedLock));
                setWriteLockSupplier(new LockingVisitors$StampedLockVisitor$$ExternalSyntheticLambda1(stampedLock));
                return (Builder) super.setLock(stampedLock);
            }
        }

        public static <O> Builder<O> builder() {
            return new Builder<>();
        }

        private StampedLockVisitor(Builder builder) {
            super(builder);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        protected StampedLockVisitor(O o, StampedLock stampedLock) {
            super(o, stampedLock, new LockingVisitors$StampedLockVisitor$$ExternalSyntheticLambda0(stampedLock), new LockingVisitors$StampedLockVisitor$$ExternalSyntheticLambda1(stampedLock));
            Objects.requireNonNull(stampedLock);
        }
    }

    public static <O> ReadWriteLockVisitor<O> create(O o, ReadWriteLock readWriteLock) {
        return new ReadWriteLockVisitor<>(o, readWriteLock);
    }

    public static <O> ReentrantLockVisitor<O> create(O o, ReentrantLock reentrantLock) {
        return new ReentrantLockVisitor<>(o, reentrantLock);
    }

    public static <O> ReentrantLockVisitor<O> reentrantLockVisitor(O o) {
        return create(o, new ReentrantLock());
    }

    public static <O> ReadWriteLockVisitor<O> reentrantReadWriteLockVisitor(O o) {
        return create(o, new ReentrantReadWriteLock());
    }

    public static <O> StampedLockVisitor<O> stampedLockVisitor(O o) {
        return new StampedLockVisitor<>(o, new StampedLock());
    }

    @Deprecated
    public LockingVisitors() {
    }
}
