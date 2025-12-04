package androidx.test.espresso.base;

import android.os.Binder;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Log;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Throwables;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
abstract class Interrogator {
    private static final ThreadLocal interrogating = new ThreadLocal<Boolean>() { // from class: androidx.test.espresso.base.Interrogator.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    };
    private static final Field messageQueueHeadField;
    private static final Method messageQueueNextMethod;
    private static final Method recycleUncheckedMethod;

    interface InterrogationHandler<R> extends QueueInterrogationHandler<R> {
        boolean beforeTaskDispatch();

        void quitting();

        void setMessage(Message message);
    }

    interface QueueInterrogationHandler<R> {
        boolean barrierUp();

        Object get();

        boolean queueEmpty();

        boolean taskDueLong();

        boolean taskDueSoon();
    }

    static {
        Method declaredMethod;
        try {
            Method declaredMethod2 = MessageQueue.class.getDeclaredMethod("next", new Class[0]);
            messageQueueNextMethod = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Field declaredField = MessageQueue.class.getDeclaredField("mMessages");
            messageQueueHeadField = declaredField;
            declaredField.setAccessible(true);
            try {
                declaredMethod = Message.class.getDeclaredMethod("recycleUnchecked", new Class[0]);
                try {
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
            } catch (NoSuchMethodException unused2) {
                declaredMethod = null;
            }
            recycleUncheckedMethod = declaredMethod;
        } catch (IllegalArgumentException | NoSuchFieldException | NoSuchMethodException | SecurityException e) {
            Log.e("Interrogator", "Could not initialize interrogator!", e);
            throw new RuntimeException("Could not initialize interrogator!", e);
        }
    }

    private static void checkSanity() {
        Preconditions.checkState(Looper.myLooper() != null, "Calling non-looper thread!");
        Preconditions.checkState(Boolean.FALSE.equals(interrogating.get()), "Already interrogating!");
    }

    private static Message getNextMessage() {
        try {
            return (Message) messageQueueNextMethod.invoke(Looper.myQueue(), new Object[0]);
        } catch (IllegalAccessException | IllegalArgumentException | SecurityException | InvocationTargetException e) {
            Throwables.throwIfUnchecked(e);
            throw new RuntimeException(e);
        }
    }

    private static boolean interrogateQueueState(MessageQueue messageQueue, QueueInterrogationHandler queueInterrogationHandler) {
        synchronized (messageQueue) {
            try {
                try {
                    Message message = (Message) messageQueueHeadField.get(messageQueue);
                    if (message == null) {
                        return queueInterrogationHandler.queueEmpty();
                    }
                    if (message.getTarget() == null) {
                        if (Log.isLoggable("Interrogator", 3)) {
                            Log.d("Interrogator", "barrier is up");
                        }
                        return queueInterrogationHandler.barrierUp();
                    }
                    long when = message.getWhen();
                    long jUptimeMillis = SystemClock.uptimeMillis() + 15;
                    if (Log.isLoggable("Interrogator", 3)) {
                        boolean z = jUptimeMillis < when;
                        StringBuilder sb = new StringBuilder(75);
                        sb.append("headWhen: ");
                        sb.append(when);
                        sb.append(" nowFuz: ");
                        sb.append(jUptimeMillis);
                        sb.append(" due long: ");
                        sb.append(z);
                        Log.d("Interrogator", sb.toString());
                    }
                    if (jUptimeMillis > when) {
                        return queueInterrogationHandler.taskDueSoon();
                    }
                    return queueInterrogationHandler.taskDueLong();
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static Object loopAndInterrogate(InterrogationHandler interrogationHandler) {
        checkSanity();
        interrogating.set(Boolean.TRUE);
        MessageQueue messageQueueMyQueue = Looper.myQueue();
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            long jClearCallingIdentity2 = Binder.clearCallingIdentity();
            boolean zInterrogateQueueState = true;
            while (zInterrogateQueueState) {
                zInterrogateQueueState = interrogateQueueState(messageQueueMyQueue, interrogationHandler);
                if (zInterrogateQueueState) {
                    Message nextMessage = getNextMessage();
                    if (nextMessage == null) {
                        interrogationHandler.quitting();
                        return interrogationHandler.get();
                    }
                    boolean zBeforeTaskDispatch = interrogationHandler.beforeTaskDispatch();
                    interrogationHandler.setMessage(nextMessage);
                    nextMessage.getTarget().dispatchMessage(nextMessage);
                    long jClearCallingIdentity3 = Binder.clearCallingIdentity();
                    if (jClearCallingIdentity3 != jClearCallingIdentity2) {
                        String hexString = Long.toHexString(jClearCallingIdentity2);
                        String hexString2 = Long.toHexString(jClearCallingIdentity3);
                        String name = nextMessage.getTarget().getClass().getName();
                        String strValueOf = String.valueOf(nextMessage.getCallback());
                        int i = nextMessage.what;
                        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 77 + String.valueOf(hexString2).length() + name.length() + strValueOf.length());
                        sb.append("Thread identity changed from 0x");
                        sb.append(hexString);
                        sb.append(" to 0x");
                        sb.append(hexString2);
                        sb.append(" while dispatching to ");
                        sb.append(name);
                        sb.append(" ");
                        sb.append(strValueOf);
                        sb.append(" what=");
                        sb.append(i);
                        Log.wtf("Interrogator", sb.toString());
                    }
                    recycle(nextMessage);
                    zInterrogateQueueState = zBeforeTaskDispatch;
                }
            }
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            interrogating.set(Boolean.FALSE);
            return interrogationHandler.get();
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            interrogating.set(Boolean.FALSE);
        }
    }

    static Object peekAtQueueState(MessageQueue messageQueue, QueueInterrogationHandler queueInterrogationHandler) {
        Preconditions.checkNotNull(messageQueue);
        Preconditions.checkNotNull(queueInterrogationHandler);
        Preconditions.checkState(!interrogateQueueState(messageQueue, queueInterrogationHandler), "It is expected that %s would stop interrogation after a single peak at the queue.", queueInterrogationHandler);
        return queueInterrogationHandler.get();
    }

    private static void recycle(Message message) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = recycleUncheckedMethod;
        if (method == null) {
            message.recycle();
            return;
        }
        try {
            method.invoke(message, new Object[0]);
        } catch (IllegalAccessException | IllegalArgumentException | SecurityException e) {
            Throwables.throwIfUnchecked(e);
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() == null) {
                throw new RuntimeException(e2);
            }
            Throwables.throwIfUnchecked(e2.getCause());
            throw new RuntimeException(e2.getCause());
        }
    }
}
