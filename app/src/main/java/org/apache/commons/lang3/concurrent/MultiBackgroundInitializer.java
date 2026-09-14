package org.apache.commons.lang3.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

/* JADX INFO: loaded from: classes6.dex */
public class MultiBackgroundInitializer extends BackgroundInitializer<MultiBackgroundInitializerResults> {
    private final Map childInitializers;

    public static class MultiBackgroundInitializerResults {
        private final Map exceptions;
        private final Map initializers;
        private final Map resultObjects;

        private MultiBackgroundInitializerResults(Map map, Map map2, Map map3) {
            this.initializers = map;
            this.resultObjects = map2;
            this.exceptions = map3;
        }

        private BackgroundInitializer checkName(String str) {
            BackgroundInitializer backgroundInitializer = (BackgroundInitializer) this.initializers.get(str);
            if (backgroundInitializer != null) {
                return backgroundInitializer;
            }
            throw new NoSuchElementException("No child initializer with name " + str);
        }

        public ConcurrentException getException(String str) {
            checkName(str);
            return (ConcurrentException) this.exceptions.get(str);
        }

        public BackgroundInitializer<?> getInitializer(String str) {
            return checkName(str);
        }

        public Object getResultObject(String str) {
            checkName(str);
            return this.resultObjects.get(str);
        }

        public Set<String> initializerNames() {
            return Collections.unmodifiableSet(this.initializers.keySet());
        }

        public boolean isException(String str) {
            checkName(str);
            return this.exceptions.containsKey(str);
        }

        public boolean isSuccessful() {
            return this.exceptions.isEmpty();
        }
    }

    public MultiBackgroundInitializer() {
        this.childInitializers = new HashMap();
    }

    public MultiBackgroundInitializer(ExecutorService executorService) {
        super(executorService);
        this.childInitializers = new HashMap();
    }

    public void addInitializer(String str, BackgroundInitializer<?> backgroundInitializer) {
        Objects.requireNonNull(str, "name");
        Objects.requireNonNull(backgroundInitializer, "backgroundInitializer");
        synchronized (this) {
            try {
                if (isStarted()) {
                    throw new IllegalStateException("addInitializer() must not be called after start()!");
                }
                this.childInitializers.put(str, backgroundInitializer);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer
    public void close() throws Throwable {
        Iterator it = this.childInitializers.values().iterator();
        ConcurrentException concurrentException = null;
        while (it.hasNext()) {
            try {
                ((BackgroundInitializer) it.next()).close();
            } catch (Exception e) {
                if (concurrentException == null) {
                    concurrentException = new ConcurrentException();
                }
                if (e instanceof ConcurrentException) {
                    concurrentException.addSuppressed(e.getCause());
                } else {
                    concurrentException.addSuppressed(e);
                }
            }
        }
        if (concurrentException != null) {
            throw concurrentException;
        }
    }

    @Override // org.apache.commons.lang3.concurrent.BackgroundInitializer
    protected int getTaskCount() {
        return this.childInitializers.values().stream().mapToInt(new ToIntFunction() { // from class: org.apache.commons.lang3.concurrent.MultiBackgroundInitializer$$ExternalSyntheticLambda2
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ((BackgroundInitializer) obj).getTaskCount();
            }
        }).sum() + 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer
    public MultiBackgroundInitializerResults initialize() throws Exception {
        HashMap map;
        synchronized (this) {
            map = new HashMap(this.childInitializers);
        }
        final ExecutorService activeExecutor = getActiveExecutor();
        map.values().forEach(new Consumer() { // from class: org.apache.commons.lang3.concurrent.MultiBackgroundInitializer$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                MultiBackgroundInitializer.lambda$initialize$0(activeExecutor, (BackgroundInitializer) obj);
            }
        });
        final HashMap map2 = new HashMap();
        final HashMap map3 = new HashMap();
        map.forEach(new BiConsumer() { // from class: org.apache.commons.lang3.concurrent.MultiBackgroundInitializer$$ExternalSyntheticLambda1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                MultiBackgroundInitializer.lambda$initialize$1(map2, map3, (String) obj, (BackgroundInitializer) obj2);
            }
        });
        return new MultiBackgroundInitializerResults(map, map2, map3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initialize$0(ExecutorService executorService, BackgroundInitializer backgroundInitializer) {
        if (backgroundInitializer.getExternalExecutor() == null) {
            backgroundInitializer.setExternalExecutor(executorService);
        }
        backgroundInitializer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initialize$1(Map map, Map map2, String str, BackgroundInitializer backgroundInitializer) {
        try {
            map.put(str, backgroundInitializer.get());
        } catch (ConcurrentException e) {
            map2.put(str, e);
        }
    }

    @Override // org.apache.commons.lang3.concurrent.BackgroundInitializer, org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer
    public boolean isInitialized() {
        if (this.childInitializers.isEmpty()) {
            return false;
        }
        return this.childInitializers.values().stream().allMatch(new Predicate() { // from class: org.apache.commons.lang3.concurrent.MultiBackgroundInitializer$$ExternalSyntheticLambda3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((BackgroundInitializer) obj).isInitialized();
            }
        });
    }
}
