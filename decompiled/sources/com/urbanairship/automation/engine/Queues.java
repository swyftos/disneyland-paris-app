package com.urbanairship.automation.engine;

import com.urbanairship.automation.utils.RetryingQueue;
import com.urbanairship.base.Supplier;
import com.urbanairship.remoteconfig.RetryingQueueConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010R\u0018\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/automation/engine/Queues;", "", "configSupplier", "Lcom/urbanairship/base/Supplier;", "Lcom/urbanairship/remoteconfig/RetryingQueueConfig;", "(Lcom/urbanairship/base/Supplier;)V", "defaultQueue", "Lcom/urbanairship/automation/utils/RetryingQueue;", "getDefaultQueue", "()Lcom/urbanairship/automation/utils/RetryingQueue;", "defaultQueue$delegate", "Lkotlin/Lazy;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "queues", "", "", "queue", "name", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAutomationPreparer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationPreparer.kt\ncom/urbanairship/automation/engine/Queues\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,402:1\n372#2,7:403\n*S KotlinDebug\n*F\n+ 1 AutomationPreparer.kt\ncom/urbanairship/automation/engine/Queues\n*L\n393#1:403,7\n*E\n"})
/* loaded from: classes5.dex */
public final class Queues {
    private final Supplier configSupplier;

    /* renamed from: defaultQueue$delegate, reason: from kotlin metadata */
    private final Lazy defaultQueue = LazyKt.lazy(new Function0() { // from class: com.urbanairship.automation.engine.Queues$defaultQueue$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final RetryingQueue invoke() {
            Supplier supplier = this.this$0.configSupplier;
            return new RetryingQueue(supplier != null ? (RetryingQueueConfig) supplier.get() : null, null, 2, null);
        }
    });
    private Map queues = new LinkedHashMap();
    private final ReentrantLock lock = new ReentrantLock();

    public Queues(@Nullable Supplier<RetryingQueueConfig> supplier) {
        this.configSupplier = supplier;
    }

    private final RetryingQueue getDefaultQueue() {
        return (RetryingQueue) this.defaultQueue.getValue();
    }

    @NotNull
    public final RetryingQueue queue(@Nullable String name) {
        if (name == null) {
            return getDefaultQueue();
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Map map = this.queues;
            Object retryingQueue = map.get(name);
            if (retryingQueue == null) {
                Supplier supplier = this.configSupplier;
                retryingQueue = new RetryingQueue(supplier != null ? (RetryingQueueConfig) supplier.get() : null, null, 2, null);
                map.put(name, retryingQueue);
            }
            RetryingQueue retryingQueue2 = (RetryingQueue) retryingQueue;
            reentrantLock.unlock();
            return retryingQueue2;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
