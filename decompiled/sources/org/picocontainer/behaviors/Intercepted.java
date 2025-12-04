package org.picocontainer.behaviors;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.PicoContainer;

/* loaded from: classes6.dex */
public class Intercepted<T> extends HiddenImplementation {
    private Controller controller;
    private final Map posts;
    private final Map pres;

    public interface Controller {
        void clear();

        Object getInstance();

        Object getOriginalRetVal();

        void instance(Object obj);

        boolean isOverridden();

        boolean isVetoed();

        void override();

        void setOriginalRetVal(Object obj);

        void veto();
    }

    public Intercepted(ComponentAdapter componentAdapter) {
        super(componentAdapter);
        this.pres = new HashMap();
        this.posts = new HashMap();
        this.controller = new ControllerWrapper(new InterceptorThreadLocal());
    }

    public void addPreInvocation(Class cls, Object obj) {
        this.pres.put(cls, obj);
    }

    public void addPostInvocation(Class cls, Object obj) {
        this.posts.put(cls, obj);
    }

    @Override // org.picocontainer.behaviors.HiddenImplementation
    protected Object invokeMethod(Object obj, Method method, Object[] objArr, PicoContainer picoContainer) throws Throwable {
        try {
            this.controller.clear();
            this.controller.instance(obj);
            Object obj2 = this.pres.get(method.getDeclaringClass());
            if (obj2 != null) {
                Object objInvoke = method.invoke(obj2, objArr);
                if (this.controller.isVetoed()) {
                    return objInvoke;
                }
            }
            Object objInvoke2 = method.invoke(obj, objArr);
            this.controller.setOriginalRetVal(objInvoke2);
            Object obj3 = this.posts.get(method.getDeclaringClass());
            if (obj3 != null) {
                Object objInvoke3 = method.invoke(obj3, objArr);
                if (this.controller.isOverridden()) {
                    return objInvoke3;
                }
            }
            return objInvoke2;
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }

    public Controller getController() {
        return this.controller;
    }

    public static class InterceptorThreadLocal extends ThreadLocal implements Serializable {
        @Override // java.lang.ThreadLocal
        protected Object initialValue() {
            return new ControllerImpl();
        }
    }

    public static class ControllerImpl implements Controller {
        private Object instance;
        private boolean overridden;
        private Object retVal;
        private boolean vetoed;

        @Override // org.picocontainer.behaviors.Intercepted.Controller
        public void veto() {
            this.vetoed = true;
        }

        @Override // org.picocontainer.behaviors.Intercepted.Controller
        public void clear() {
            this.vetoed = false;
            this.overridden = false;
            this.retVal = null;
            this.instance = null;
        }

        @Override // org.picocontainer.behaviors.Intercepted.Controller
        public boolean isVetoed() {
            return this.vetoed;
        }

        @Override // org.picocontainer.behaviors.Intercepted.Controller
        public void setOriginalRetVal(Object obj) {
            this.retVal = obj;
        }

        @Override // org.picocontainer.behaviors.Intercepted.Controller
        public Object getOriginalRetVal() {
            return this.retVal;
        }

        @Override // org.picocontainer.behaviors.Intercepted.Controller
        public boolean isOverridden() {
            return this.overridden;
        }

        @Override // org.picocontainer.behaviors.Intercepted.Controller
        public void instance(Object obj) {
            this.instance = obj;
        }

        @Override // org.picocontainer.behaviors.Intercepted.Controller
        public Object getInstance() {
            return this.instance;
        }

        @Override // org.picocontainer.behaviors.Intercepted.Controller
        public void override() {
            this.overridden = true;
        }
    }

    public class ControllerWrapper implements Controller {
        private final ThreadLocal threadLocal;

        public ControllerWrapper(ThreadLocal<Controller> threadLocal) {
            this.threadLocal = threadLocal;
        }

        @Override // org.picocontainer.behaviors.Intercepted.Controller
        public void veto() {
            ((Controller) this.threadLocal.get()).veto();
        }

        @Override // org.picocontainer.behaviors.Intercepted.Controller
        public void clear() {
            ((Controller) this.threadLocal.get()).clear();
        }

        @Override // org.picocontainer.behaviors.Intercepted.Controller
        public boolean isVetoed() {
            return ((Controller) this.threadLocal.get()).isVetoed();
        }

        @Override // org.picocontainer.behaviors.Intercepted.Controller
        public void setOriginalRetVal(Object obj) {
            ((Controller) this.threadLocal.get()).setOriginalRetVal(obj);
        }

        @Override // org.picocontainer.behaviors.Intercepted.Controller
        public Object getOriginalRetVal() {
            return ((Controller) this.threadLocal.get()).getOriginalRetVal();
        }

        @Override // org.picocontainer.behaviors.Intercepted.Controller
        public boolean isOverridden() {
            return ((Controller) this.threadLocal.get()).isOverridden();
        }

        @Override // org.picocontainer.behaviors.Intercepted.Controller
        public void instance(Object obj) {
            ((Controller) this.threadLocal.get()).instance(obj);
        }

        @Override // org.picocontainer.behaviors.Intercepted.Controller
        public Object getInstance() {
            return ((Controller) this.threadLocal.get()).getInstance();
        }

        @Override // org.picocontainer.behaviors.Intercepted.Controller
        public void override() {
            ((Controller) this.threadLocal.get()).override();
        }
    }

    @Override // org.picocontainer.behaviors.HiddenImplementation, org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "Intercepted";
    }
}
