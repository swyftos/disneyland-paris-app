package org.apache.commons.lang3;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.function.FailableBiConsumer;
import org.apache.commons.lang3.function.Predicates;
import org.apache.commons.lang3.time.DurationUtils;

/* JADX INFO: loaded from: classes6.dex */
public class ThreadUtils {

    @Deprecated
    public static final AlwaysTruePredicate ALWAYS_TRUE_PREDICATE = new AlwaysTruePredicate();

    @FunctionalInterface
    @Deprecated
    public interface ThreadGroupPredicate {
        boolean test(ThreadGroup threadGroup);
    }

    @FunctionalInterface
    @Deprecated
    public interface ThreadPredicate {
        boolean test(Thread thread);
    }

    private static final class AlwaysTruePredicate implements ThreadPredicate, ThreadGroupPredicate {
        @Override // org.apache.commons.lang3.ThreadUtils.ThreadPredicate
        public boolean test(Thread thread) {
            return true;
        }

        @Override // org.apache.commons.lang3.ThreadUtils.ThreadGroupPredicate
        public boolean test(ThreadGroup threadGroup) {
            return true;
        }

        private AlwaysTruePredicate() {
        }
    }

    @Deprecated
    public static class NamePredicate implements ThreadPredicate, ThreadGroupPredicate {
        private final String name;

        public NamePredicate(String str) {
            Objects.requireNonNull(str, "name");
            this.name = str;
        }

        @Override // org.apache.commons.lang3.ThreadUtils.ThreadPredicate
        public boolean test(Thread thread) {
            return thread != null && thread.getName().equals(this.name);
        }

        @Override // org.apache.commons.lang3.ThreadUtils.ThreadGroupPredicate
        public boolean test(ThreadGroup threadGroup) {
            return threadGroup != null && threadGroup.getName().equals(this.name);
        }
    }

    @Deprecated
    public static class ThreadIdPredicate implements ThreadPredicate {
        private final long threadId;

        public ThreadIdPredicate(long j) {
            if (j <= 0) {
                throw new IllegalArgumentException("The thread id must be greater than zero");
            }
            this.threadId = j;
        }

        @Override // org.apache.commons.lang3.ThreadUtils.ThreadPredicate
        public boolean test(Thread thread) {
            return thread != null && thread.getId() == this.threadId;
        }
    }

    public static Thread findThreadById(final long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("The thread id must be greater than zero");
        }
        Collection<Thread> collectionFindThreads = findThreads((Predicate<Thread>) new Predicate() { // from class: org.apache.commons.lang3.ThreadUtils$$ExternalSyntheticLambda3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ThreadUtils.lambda$findThreadById$0(j, (Thread) obj);
            }
        });
        if (collectionFindThreads.isEmpty()) {
            return null;
        }
        return collectionFindThreads.iterator().next();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findThreadById$0(long j, Thread thread) {
        return thread != null && thread.getId() == j;
    }

    public static Thread findThreadById(long j, String str) {
        Objects.requireNonNull(str, "threadGroupName");
        Thread threadFindThreadById = findThreadById(j);
        if (threadFindThreadById == null || threadFindThreadById.getThreadGroup() == null || !threadFindThreadById.getThreadGroup().getName().equals(str)) {
            return null;
        }
        return threadFindThreadById;
    }

    public static Thread findThreadById(long j, ThreadGroup threadGroup) {
        Objects.requireNonNull(threadGroup, "threadGroup");
        Thread threadFindThreadById = findThreadById(j);
        if (threadFindThreadById == null || !threadGroup.equals(threadFindThreadById.getThreadGroup())) {
            return null;
        }
        return threadFindThreadById;
    }

    public static Collection<ThreadGroup> findThreadGroups(Predicate<ThreadGroup> predicate) {
        return findThreadGroups(getSystemThreadGroup(), true, predicate);
    }

    public static Collection<ThreadGroup> findThreadGroups(ThreadGroup threadGroup, boolean z, Predicate<ThreadGroup> predicate) {
        Objects.requireNonNull(threadGroup, "threadGroup");
        Objects.requireNonNull(predicate, "predicate");
        int iActiveGroupCount = threadGroup.activeGroupCount();
        while (true) {
            int i = iActiveGroupCount + (iActiveGroupCount / 2) + 1;
            ThreadGroup[] threadGroupArr = new ThreadGroup[i];
            int iEnumerate = threadGroup.enumerate(threadGroupArr, z);
            if (iEnumerate < i) {
                return Collections.unmodifiableCollection((Collection) Stream.of((Object[]) threadGroupArr).limit(iEnumerate).filter(predicate).collect(Collectors.toList()));
            }
            iActiveGroupCount = iEnumerate;
        }
    }

    @Deprecated
    public static Collection<ThreadGroup> findThreadGroups(ThreadGroup threadGroup, boolean z, final ThreadGroupPredicate threadGroupPredicate) {
        Objects.requireNonNull(threadGroupPredicate);
        return findThreadGroups(threadGroup, z, (Predicate<ThreadGroup>) new Predicate() { // from class: org.apache.commons.lang3.ThreadUtils$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return threadGroupPredicate.test((ThreadGroup) obj);
            }
        });
    }

    @Deprecated
    public static Collection<ThreadGroup> findThreadGroups(ThreadGroupPredicate threadGroupPredicate) {
        return findThreadGroups(getSystemThreadGroup(), true, threadGroupPredicate);
    }

    public static Collection<ThreadGroup> findThreadGroupsByName(String str) {
        return findThreadGroups((Predicate<ThreadGroup>) predicateThreadGroup(str));
    }

    public static Collection<Thread> findThreads(Predicate<Thread> predicate) {
        return findThreads(getSystemThreadGroup(), true, predicate);
    }

    public static Collection<Thread> findThreads(ThreadGroup threadGroup, boolean z, Predicate<Thread> predicate) {
        Objects.requireNonNull(threadGroup, "The group must not be null");
        Objects.requireNonNull(predicate, "The predicate must not be null");
        int iActiveCount = threadGroup.activeCount();
        while (true) {
            int i = iActiveCount + (iActiveCount / 2) + 1;
            Thread[] threadArr = new Thread[i];
            int iEnumerate = threadGroup.enumerate(threadArr, z);
            if (iEnumerate < i) {
                return Collections.unmodifiableCollection((Collection) Stream.of((Object[]) threadArr).limit(iEnumerate).filter(predicate).collect(Collectors.toList()));
            }
            iActiveCount = iEnumerate;
        }
    }

    @Deprecated
    public static Collection<Thread> findThreads(ThreadGroup threadGroup, boolean z, final ThreadPredicate threadPredicate) {
        Objects.requireNonNull(threadPredicate);
        return findThreads(threadGroup, z, (Predicate<Thread>) new Predicate() { // from class: org.apache.commons.lang3.ThreadUtils$$ExternalSyntheticLambda6
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return threadPredicate.test((Thread) obj);
            }
        });
    }

    @Deprecated
    public static Collection<Thread> findThreads(ThreadPredicate threadPredicate) {
        return findThreads(getSystemThreadGroup(), true, threadPredicate);
    }

    public static Collection<Thread> findThreadsByName(String str) {
        return findThreads((Predicate<Thread>) predicateThread(str));
    }

    public static Collection<Thread> findThreadsByName(final String str, String str2) {
        Objects.requireNonNull(str, "threadName");
        Objects.requireNonNull(str2, "threadGroupName");
        return Collections.unmodifiableCollection((Collection) findThreadGroups((Predicate<ThreadGroup>) predicateThreadGroup(str2)).stream().flatMap(new Function() { // from class: org.apache.commons.lang3.ThreadUtils$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ThreadUtils.lambda$findThreadsByName$0(str, (ThreadGroup) obj);
            }
        }).collect(Collectors.toList()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$findThreadsByName$0(String str, ThreadGroup threadGroup) {
        return findThreads(threadGroup, false, (Predicate<Thread>) predicateThread(str)).stream();
    }

    public static Collection<Thread> findThreadsByName(String str, ThreadGroup threadGroup) {
        return findThreads(threadGroup, false, (Predicate<Thread>) predicateThread(str));
    }

    public static Collection<ThreadGroup> getAllThreadGroups() {
        return findThreadGroups((Predicate<ThreadGroup>) Predicates.truePredicate());
    }

    public static Collection<Thread> getAllThreads() {
        return findThreads((Predicate<Thread>) Predicates.truePredicate());
    }

    public static ThreadGroup getSystemThreadGroup() {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while (threadGroup != null && threadGroup.getParent() != null) {
            threadGroup = threadGroup.getParent();
        }
        return threadGroup;
    }

    public static void join(final Thread thread, Duration duration) throws Throwable {
        Objects.requireNonNull(thread);
        DurationUtils.accept(new FailableBiConsumer() { // from class: org.apache.commons.lang3.ThreadUtils$$ExternalSyntheticLambda2
            @Override // org.apache.commons.lang3.function.FailableBiConsumer
            public final void accept(Object obj, Object obj2) throws InterruptedException {
                thread.join(((Long) obj).longValue(), ((Integer) obj2).intValue());
            }
        }, duration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$namePredicate$0(Function function, String str, Object obj) {
        if (obj != null) {
            Object objApply = function.apply(obj);
            Objects.requireNonNull(str);
            if (Objects.equals(objApply, str)) {
                return true;
            }
        }
        return false;
    }

    private static Predicate namePredicate(final String str, final Function function) {
        return new Predicate() { // from class: org.apache.commons.lang3.ThreadUtils$$ExternalSyntheticLambda8
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ThreadUtils.lambda$namePredicate$0(function, str, obj);
            }
        };
    }

    private static Predicate predicateThread(String str) {
        return namePredicate(str, new Function() { // from class: org.apache.commons.lang3.ThreadUtils$$ExternalSyntheticLambda7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Thread) obj).getName();
            }
        });
    }

    private static Predicate predicateThreadGroup(String str) {
        return namePredicate(str, new Function() { // from class: org.apache.commons.lang3.ThreadUtils$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ThreadGroup) obj).getName();
            }
        });
    }

    public static void sleep(Duration duration) throws Throwable {
        DurationUtils.accept(new FailableBiConsumer() { // from class: org.apache.commons.lang3.ThreadUtils$$ExternalSyntheticLambda1
            @Override // org.apache.commons.lang3.function.FailableBiConsumer
            public final void accept(Object obj, Object obj2) throws InterruptedException {
                Thread.sleep(((Long) obj).longValue(), ((Integer) obj2).intValue());
            }
        }, duration);
    }

    public static void sleepQuietly(Duration duration) throws Throwable {
        try {
            sleep(duration);
        } catch (InterruptedException unused) {
        }
    }

    @Deprecated
    public ThreadUtils() {
    }
}
