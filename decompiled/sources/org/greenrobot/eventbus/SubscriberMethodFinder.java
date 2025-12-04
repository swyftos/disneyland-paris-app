package org.greenrobot.eventbus;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.text.Typography;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

/* loaded from: classes6.dex */
class SubscriberMethodFinder {
    private final boolean ignoreGeneratedIndex;
    private final boolean strictMethodVerification;
    private List subscriberInfoIndexes;
    private static final Map METHOD_CACHE = new ConcurrentHashMap();
    private static final FindState[] FIND_STATE_POOL = new FindState[4];

    SubscriberMethodFinder(List list, boolean z, boolean z2) {
        this.subscriberInfoIndexes = list;
        this.strictMethodVerification = z;
        this.ignoreGeneratedIndex = z2;
    }

    List findSubscriberMethods(Class cls) throws SecurityException {
        List listFindUsingInfo;
        Map map = METHOD_CACHE;
        List list = (List) map.get(cls);
        if (list != null) {
            return list;
        }
        if (this.ignoreGeneratedIndex) {
            listFindUsingInfo = findUsingReflection(cls);
        } else {
            listFindUsingInfo = findUsingInfo(cls);
        }
        if (listFindUsingInfo.isEmpty()) {
            throw new EventBusException("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
        }
        map.put(cls, listFindUsingInfo);
        return listFindUsingInfo;
    }

    private List findUsingInfo(Class cls) throws SecurityException {
        FindState findStatePrepareFindState = prepareFindState();
        findStatePrepareFindState.initForSubscriber(cls);
        while (findStatePrepareFindState.clazz != null) {
            SubscriberInfo subscriberInfo = getSubscriberInfo(findStatePrepareFindState);
            findStatePrepareFindState.subscriberInfo = subscriberInfo;
            if (subscriberInfo != null) {
                for (SubscriberMethod subscriberMethod : subscriberInfo.getSubscriberMethods()) {
                    if (findStatePrepareFindState.checkAdd(subscriberMethod.method, subscriberMethod.eventType)) {
                        findStatePrepareFindState.subscriberMethods.add(subscriberMethod);
                    }
                }
            } else {
                findUsingReflectionInSingleClass(findStatePrepareFindState);
            }
            findStatePrepareFindState.moveToSuperclass();
        }
        return getMethodsAndRelease(findStatePrepareFindState);
    }

    private List getMethodsAndRelease(FindState findState) {
        ArrayList arrayList = new ArrayList(findState.subscriberMethods);
        findState.recycle();
        synchronized (FIND_STATE_POOL) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                }
                try {
                    FindState[] findStateArr = FIND_STATE_POOL;
                    if (findStateArr[i] == null) {
                        findStateArr[i] = findState;
                        break;
                    }
                    i++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return arrayList;
    }

    private FindState prepareFindState() {
        synchronized (FIND_STATE_POOL) {
            for (int i = 0; i < 4; i++) {
                try {
                    FindState[] findStateArr = FIND_STATE_POOL;
                    FindState findState = findStateArr[i];
                    if (findState != null) {
                        findStateArr[i] = null;
                        return findState;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return new FindState();
        }
    }

    private SubscriberInfo getSubscriberInfo(FindState findState) {
        SubscriberInfo subscriberInfo = findState.subscriberInfo;
        if (subscriberInfo != null && subscriberInfo.getSuperSubscriberInfo() != null) {
            SubscriberInfo superSubscriberInfo = findState.subscriberInfo.getSuperSubscriberInfo();
            if (findState.clazz == superSubscriberInfo.getSubscriberClass()) {
                return superSubscriberInfo;
            }
        }
        List list = this.subscriberInfoIndexes;
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SubscriberInfo subscriberInfo2 = ((SubscriberInfoIndex) it.next()).getSubscriberInfo(findState.clazz);
            if (subscriberInfo2 != null) {
                return subscriberInfo2;
            }
        }
        return null;
    }

    private List findUsingReflection(Class cls) throws SecurityException {
        FindState findStatePrepareFindState = prepareFindState();
        findStatePrepareFindState.initForSubscriber(cls);
        while (findStatePrepareFindState.clazz != null) {
            findUsingReflectionInSingleClass(findStatePrepareFindState);
            findStatePrepareFindState.moveToSuperclass();
        }
        return getMethodsAndRelease(findStatePrepareFindState);
    }

    private void findUsingReflectionInSingleClass(FindState findState) throws SecurityException {
        Method[] methods;
        try {
            methods = findState.clazz.getDeclaredMethods();
        } catch (Throwable unused) {
            methods = findState.clazz.getMethods();
            findState.skipSuperClasses = true;
        }
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    Subscribe subscribe = (Subscribe) method.getAnnotation(Subscribe.class);
                    if (subscribe != null) {
                        Class<?> cls = parameterTypes[0];
                        if (findState.checkAdd(method, cls)) {
                            findState.subscriberMethods.add(new SubscriberMethod(method, cls, subscribe.threadMode(), subscribe.priority(), subscribe.sticky()));
                        }
                    }
                } else if (this.strictMethodVerification && method.isAnnotationPresent(Subscribe.class)) {
                    throw new EventBusException("@Subscribe method " + (method.getDeclaringClass().getName() + InstructionFileId.DOT + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.strictMethodVerification && method.isAnnotationPresent(Subscribe.class)) {
                throw new EventBusException((method.getDeclaringClass().getName() + InstructionFileId.DOT + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }

    static void clearCaches() {
        METHOD_CACHE.clear();
    }

    static class FindState {
        Class clazz;
        boolean skipSuperClasses;
        Class subscriberClass;
        SubscriberInfo subscriberInfo;
        final List subscriberMethods = new ArrayList();
        final Map anyMethodByEventType = new HashMap();
        final Map subscriberClassByMethodKey = new HashMap();
        final StringBuilder methodKeyBuilder = new StringBuilder(128);

        FindState() {
        }

        void initForSubscriber(Class cls) {
            this.clazz = cls;
            this.subscriberClass = cls;
            this.skipSuperClasses = false;
            this.subscriberInfo = null;
        }

        void recycle() {
            this.subscriberMethods.clear();
            this.anyMethodByEventType.clear();
            this.subscriberClassByMethodKey.clear();
            this.methodKeyBuilder.setLength(0);
            this.subscriberClass = null;
            this.clazz = null;
            this.skipSuperClasses = false;
            this.subscriberInfo = null;
        }

        boolean checkAdd(Method method, Class cls) {
            Object objPut = this.anyMethodByEventType.put(cls, method);
            if (objPut == null) {
                return true;
            }
            if (objPut instanceof Method) {
                if (!checkAddWithMethodSignature((Method) objPut, cls)) {
                    throw new IllegalStateException();
                }
                this.anyMethodByEventType.put(cls, this);
            }
            return checkAddWithMethodSignature(method, cls);
        }

        private boolean checkAddWithMethodSignature(Method method, Class cls) {
            this.methodKeyBuilder.setLength(0);
            this.methodKeyBuilder.append(method.getName());
            StringBuilder sb = this.methodKeyBuilder;
            sb.append(Typography.greater);
            sb.append(cls.getName());
            String string = this.methodKeyBuilder.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class cls2 = (Class) this.subscriberClassByMethodKey.put(string, declaringClass);
            if (cls2 == null || cls2.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.subscriberClassByMethodKey.put(string, cls2);
            return false;
        }

        void moveToSuperclass() {
            if (this.skipSuperClasses) {
                this.clazz = null;
                return;
            }
            Class superclass = this.clazz.getSuperclass();
            this.clazz = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.clazz = null;
            }
        }
    }
}
