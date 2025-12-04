package androidx.test.espresso.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.test.espresso.IdlingPolicies;
import androidx.test.espresso.IdlingPolicy;
import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.ImmutableList;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* loaded from: classes2.dex */
public final class IdlingResourceRegistry {
    private static final String TAG = "IdlingResourceRegistry";
    private final Dispatcher dispatcher;
    private final Handler handler;
    private final Looper looper;
    private static final Object TIMEOUT_MESSAGE_TAG = new Object();
    private static final IdleNotificationCallback NO_OP_CALLBACK = new IdleNotificationCallback() { // from class: androidx.test.espresso.base.IdlingResourceRegistry.1
        @Override // androidx.test.espresso.base.IdlingResourceRegistry.IdleNotificationCallback
        public void allResourcesIdle() {
        }

        @Override // androidx.test.espresso.base.IdlingResourceRegistry.IdleNotificationCallback
        public void resourcesHaveTimedOut(List list) {
        }

        @Override // androidx.test.espresso.base.IdlingResourceRegistry.IdleNotificationCallback
        public void resourcesStillBusyWarning(List list) {
        }
    };
    private final List idlingStates = new ArrayList();
    private IdleNotificationCallback idleNotificationCallback = NO_OP_CALLBACK;

    private class Dispatcher implements Handler.Callback {
        private Dispatcher() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void deregister() {
            IdlingResourceRegistry.this.handler.removeCallbacksAndMessages(IdlingResourceRegistry.TIMEOUT_MESSAGE_TAG);
            IdlingResourceRegistry.this.idleNotificationCallback = IdlingResourceRegistry.NO_OP_CALLBACK;
        }

        private void handleRaceCondition(Message message) {
            for (IdlingState idlingState : (List) message.obj) {
                if (!idlingState.idle) {
                    throw new IllegalStateException(String.format(Locale.ROOT, "Resource %s isIdleNow() is returning true, but a message indicating that the resource has transitioned from busy to idle was never sent.", idlingState.resource.getName()));
                }
            }
        }

        private void handleResourceIdled(Message message) {
            IdlingState idlingState = (IdlingState) message.obj;
            idlingState.idle = true;
            boolean z = true;
            boolean z2 = true;
            for (IdlingState idlingState2 : IdlingResourceRegistry.this.idlingStates) {
                z = z && idlingState2.idle;
                if (!z2 && !z) {
                    break;
                } else if (z2 && idlingState2 == idlingState) {
                    z2 = false;
                }
            }
            if (!z2) {
                if (z) {
                    try {
                        IdlingResourceRegistry.this.idleNotificationCallback.allResourcesIdle();
                        return;
                    } finally {
                        deregister();
                    }
                }
                return;
            }
            String str = IdlingResourceRegistry.TAG;
            String strValueOf = String.valueOf(idlingState.resource);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 45);
            sb.append("Ignoring message from unregistered resource: ");
            sb.append(strValueOf);
            Log.i(str, sb.toString());
        }

        private void handleTimeout() {
            List busyResources = IdlingResourceRegistry.this.getBusyResources();
            if (busyResources == null) {
                IdlingResourceRegistry.this.handler.sendMessage(IdlingResourceRegistry.this.handler.obtainMessage(2, IdlingResourceRegistry.TIMEOUT_MESSAGE_TAG));
                return;
            }
            try {
                IdlingResourceRegistry.this.idleNotificationCallback.resourcesHaveTimedOut(busyResources);
            } finally {
                deregister();
            }
        }

        private void handleTimeoutWarning() {
            List busyResources = IdlingResourceRegistry.this.getBusyResources();
            if (busyResources == null) {
                IdlingResourceRegistry.this.handler.sendMessage(IdlingResourceRegistry.this.handler.obtainMessage(3, IdlingResourceRegistry.TIMEOUT_MESSAGE_TAG));
                return;
            }
            IdlingPolicy dynamicIdlingResourceWarningPolicy = IdlingPolicies.getDynamicIdlingResourceWarningPolicy();
            IdlingResourceRegistry.this.idleNotificationCallback.resourcesStillBusyWarning(busyResources);
            IdlingResourceRegistry.this.handler.sendMessageDelayed(IdlingResourceRegistry.this.handler.obtainMessage(3, IdlingResourceRegistry.TIMEOUT_MESSAGE_TAG), dynamicIdlingResourceWarningPolicy.getIdleTimeoutUnit().toMillis(dynamicIdlingResourceWarningPolicy.getIdleTimeout()));
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                handleResourceIdled(message);
            } else if (i == 2) {
                handleTimeout();
            } else if (i == 3) {
                handleTimeoutWarning();
            } else {
                if (i != 4) {
                    String str = IdlingResourceRegistry.TAG;
                    String strValueOf = String.valueOf(message);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
                    sb.append("Unknown message type: ");
                    sb.append(strValueOf);
                    Log.w(str, sb.toString());
                    return false;
                }
                handleRaceCondition(message);
            }
            return true;
        }
    }

    interface IdleNotificationCallback {
        void allResourcesIdle();

        void resourcesHaveTimedOut(List list);

        void resourcesStillBusyWarning(List list);
    }

    private static class IdlingState implements IdlingResource.ResourceCallback {
        final Handler handler;
        boolean idle;
        final IdlingResource resource;

        private IdlingState(IdlingResource idlingResource, Handler handler) {
            this.resource = idlingResource;
            this.handler = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void registerSelf() {
            this.resource.registerIdleTransitionCallback(this);
            this.idle = this.resource.isIdleNow();
        }

        @Override // androidx.test.espresso.IdlingResource.ResourceCallback
        public void onTransitionToIdle() {
            Message messageObtainMessage = this.handler.obtainMessage(1);
            messageObtainMessage.obj = this;
            this.handler.sendMessage(messageObtainMessage);
        }
    }

    public IdlingResourceRegistry(Looper looper) {
        this.looper = looper;
        Dispatcher dispatcher = new Dispatcher();
        this.dispatcher = dispatcher;
        this.handler = new Handler(looper, dispatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List getBusyResources() {
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        ArrayList arrayListNewArrayList2 = Lists.newArrayList();
        for (IdlingState idlingState : this.idlingStates) {
            if (!idlingState.idle) {
                if (idlingState.resource.isIdleNow()) {
                    arrayListNewArrayList2.add(idlingState);
                } else {
                    arrayListNewArrayList.add(idlingState.resource.getName());
                }
            }
        }
        if (arrayListNewArrayList2.isEmpty()) {
            return arrayListNewArrayList;
        }
        Message messageObtainMessage = this.handler.obtainMessage(4, TIMEOUT_MESSAGE_TAG);
        messageObtainMessage.obj = arrayListNewArrayList2;
        this.handler.sendMessage(messageObtainMessage);
        return null;
    }

    private void logDuplicateRegistrationError(IdlingResource idlingResource, IdlingResource idlingResource2) {
        Log.e(TAG, String.format(Locale.ROOT, "Attempted to register resource with same names: %s. R1: %s R2: %s.\nDuplicate resource registration will be ignored.", idlingResource.getName(), idlingResource, idlingResource2));
    }

    private Object runSynchronouslyOnMainThread(Callable callable) {
        FutureTask futureTask = new FutureTask(callable);
        this.handler.post(futureTask);
        try {
            return futureTask.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (CancellationException e2) {
            throw new RuntimeException(e2);
        } catch (ExecutionException e3) {
            throw new RuntimeException(e3);
        }
    }

    private void scheduleTimeoutMessages() {
        IdlingPolicy dynamicIdlingResourceWarningPolicy = IdlingPolicies.getDynamicIdlingResourceWarningPolicy();
        Handler handler = this.handler;
        Object obj = TIMEOUT_MESSAGE_TAG;
        this.handler.sendMessageDelayed(handler.obtainMessage(3, obj), dynamicIdlingResourceWarningPolicy.getIdleTimeoutUnit().toMillis(dynamicIdlingResourceWarningPolicy.getIdleTimeout()));
        Message messageObtainMessage = this.handler.obtainMessage(2, obj);
        IdlingPolicy dynamicIdlingResourceErrorPolicy = IdlingPolicies.getDynamicIdlingResourceErrorPolicy();
        this.handler.sendMessageDelayed(messageObtainMessage, dynamicIdlingResourceErrorPolicy.getIdleTimeoutUnit().toMillis(dynamicIdlingResourceErrorPolicy.getIdleTimeout()));
    }

    boolean allResourcesAreIdle() {
        Preconditions.checkState(Looper.myLooper() == this.looper);
        for (IdlingState idlingState : this.idlingStates) {
            if (idlingState.idle) {
                idlingState.idle = idlingState.resource.isIdleNow();
            }
            if (!idlingState.idle) {
                return false;
            }
        }
        String str = TAG;
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "All idling resources are idle.");
        }
        return true;
    }

    IdleNotifier asIdleNotifier() {
        return new IdleNotifier<IdleNotificationCallback>() { // from class: androidx.test.espresso.base.IdlingResourceRegistry.6
            @Override // androidx.test.espresso.base.IdleNotifier
            public void cancelCallback() {
                IdlingResourceRegistry.this.cancelIdleMonitor();
            }

            @Override // androidx.test.espresso.base.IdleNotifier
            public boolean isIdleNow() {
                return IdlingResourceRegistry.this.allResourcesAreIdle();
            }

            @Override // androidx.test.espresso.base.IdleNotifier
            public void registerNotificationCallback(IdleNotificationCallback idleNotificationCallback) {
                IdlingResourceRegistry.this.notifyWhenAllResourcesAreIdle(idleNotificationCallback);
            }
        };
    }

    void cancelIdleMonitor() {
        this.dispatcher.deregister();
    }

    public List<IdlingResource> getResources() {
        if (Looper.myLooper() != this.looper) {
            return (List) runSynchronouslyOnMainThread(new Callable<List<IdlingResource>>() { // from class: androidx.test.espresso.base.IdlingResourceRegistry.5
                @Override // java.util.concurrent.Callable
                public List<IdlingResource> call() {
                    return IdlingResourceRegistry.this.getResources();
                }
            });
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        Iterator it = this.idlingStates.iterator();
        while (it.hasNext()) {
            builder.add((ImmutableList.Builder) ((IdlingState) it.next()).resource);
        }
        return builder.build();
    }

    void notifyWhenAllResourcesAreIdle(IdleNotificationCallback idleNotificationCallback) {
        Preconditions.checkNotNull(idleNotificationCallback);
        Preconditions.checkState(Looper.myLooper() == this.looper);
        Preconditions.checkState(this.idleNotificationCallback == NO_OP_CALLBACK, "Callback has already been registered.");
        if (allResourcesAreIdle()) {
            idleNotificationCallback.allResourcesIdle();
        } else {
            this.idleNotificationCallback = idleNotificationCallback;
            scheduleTimeoutMessages();
        }
    }

    public void registerLooper(Looper looper, boolean z) {
        Preconditions.checkNotNull(looper);
        Preconditions.checkArgument(Looper.getMainLooper() != looper, "Not intended for use with main looper!");
        registerResources(Lists.newArrayList(LooperIdlingResourceInterrogationHandler.forLooper(looper)));
    }

    public boolean registerResources(final List<? extends IdlingResource> list) {
        if (Looper.myLooper() != this.looper) {
            return ((Boolean) runSynchronouslyOnMainThread(new Callable<Boolean>() { // from class: androidx.test.espresso.base.IdlingResourceRegistry.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Boolean call() {
                    return Boolean.valueOf(IdlingResourceRegistry.this.registerResources(list));
                }
            })).booleanValue();
        }
        boolean z = true;
        for (IdlingResource idlingResource : list) {
            Preconditions.checkNotNull(idlingResource.getName(), "IdlingResource.getName() should not be null");
            Iterator it = this.idlingStates.iterator();
            while (true) {
                if (!it.hasNext()) {
                    IdlingState idlingState = new IdlingState(idlingResource, this.handler);
                    this.idlingStates.add(idlingState);
                    idlingState.registerSelf();
                    break;
                }
                IdlingState idlingState2 = (IdlingState) it.next();
                if (idlingResource.getName().equals(idlingState2.resource.getName())) {
                    logDuplicateRegistrationError(idlingResource, idlingState2.resource);
                    z = false;
                    break;
                }
            }
        }
        return z;
    }

    public void sync(final Iterable<IdlingResource> iterable, final Iterable<Looper> iterable2) {
        if (Looper.myLooper() != this.looper) {
            runSynchronouslyOnMainThread(new Callable<Void>() { // from class: androidx.test.espresso.base.IdlingResourceRegistry.2
                @Override // java.util.concurrent.Callable
                public Void call() {
                    IdlingResourceRegistry.this.sync(iterable, iterable2);
                    return null;
                }
            });
            return;
        }
        HashMap map = new HashMap();
        for (IdlingResource idlingResource : iterable) {
            if (map.containsKey(idlingResource.getName())) {
                logDuplicateRegistrationError(idlingResource, (IdlingResource) map.get(idlingResource.getName()));
            } else {
                map.put(idlingResource.getName(), idlingResource);
            }
        }
        Iterator<Looper> it = iterable2.iterator();
        while (it.hasNext()) {
            LooperIdlingResourceInterrogationHandler looperIdlingResourceInterrogationHandlerForLooper = LooperIdlingResourceInterrogationHandler.forLooper(it.next());
            if (map.containsKey(looperIdlingResourceInterrogationHandlerForLooper.getName())) {
                logDuplicateRegistrationError(looperIdlingResourceInterrogationHandlerForLooper, (IdlingResource) map.get(looperIdlingResourceInterrogationHandlerForLooper.getName()));
            } else {
                map.put(looperIdlingResourceInterrogationHandlerForLooper.getName(), looperIdlingResourceInterrogationHandlerForLooper);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (IdlingState idlingState : this.idlingStates) {
            IdlingResource idlingResource2 = (IdlingResource) map.remove(idlingState.resource.getName());
            if (idlingResource2 == null) {
                arrayList.add(idlingState.resource);
            } else {
                IdlingResource idlingResource3 = idlingState.resource;
                if (idlingResource3 != idlingResource2) {
                    arrayList.add(idlingResource3);
                    map.put(idlingResource2.getName(), idlingResource2);
                }
            }
        }
        unregisterResources(arrayList);
        registerResources(Lists.newArrayList(map.values()));
    }

    public boolean unregisterResources(final List<? extends IdlingResource> list) {
        if (Looper.myLooper() != this.looper) {
            return ((Boolean) runSynchronouslyOnMainThread(new Callable<Boolean>() { // from class: androidx.test.espresso.base.IdlingResourceRegistry.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Boolean call() {
                    return Boolean.valueOf(IdlingResourceRegistry.this.unregisterResources(list));
                }
            })).booleanValue();
        }
        boolean z = true;
        for (IdlingResource idlingResource : list) {
            int i = 0;
            while (true) {
                if (i >= this.idlingStates.size()) {
                    Log.e(TAG, String.format(Locale.ROOT, "Attempted to unregister resource that is not registered: '%s'. Resource list: %s", idlingResource.getName(), getResources()));
                    z = false;
                    break;
                }
                if (((IdlingState) this.idlingStates.get(i)).resource.getName().equals(idlingResource.getName())) {
                    this.idlingStates.remove(i);
                    break;
                }
                i++;
            }
        }
        return z;
    }
}
