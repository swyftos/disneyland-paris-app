package org.picocontainer.behaviors;

import com.urbanairship.channel.AttributeMutation;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Map;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.PicoClassNotFoundException;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;

/* loaded from: classes6.dex */
public class PropertyApplicator<T> extends AbstractBehavior<T> {
    private Map properties;
    private transient Map setters;

    public PropertyApplicator(ComponentAdapter<T> componentAdapter) throws PicoCompositionException {
        super(componentAdapter);
        this.setters = null;
    }

    @Override // org.picocontainer.behaviors.AbstractBehavior, org.picocontainer.ComponentAdapter
    public T getComponentInstance(PicoContainer picoContainer, Type type) throws IllegalAccessException, IllegalArgumentException, PicoCompositionException, InvocationTargetException {
        T t = (T) super.getComponentInstance(picoContainer, type);
        if (this.setters == null) {
            this.setters = getSetters(getComponentImplementation());
        }
        if (this.properties != null) {
            ComponentMonitor componentMonitorCurrentMonitor = currentMonitor();
            for (String str : this.properties.keySet()) {
                Object obj = this.properties.get(str);
                Method method = (Method) this.setters.get(str);
                Object setterParameter = getSetterParameter(str, obj, t, picoContainer);
                try {
                    componentMonitorCurrentMonitor.invoking(picoContainer, this, method, t, new Object[]{setterParameter});
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    method.invoke(t, setterParameter);
                    componentMonitorCurrentMonitor.invoked(picoContainer, this, method, t, System.currentTimeMillis() - jCurrentTimeMillis, new Object[]{setterParameter}, null);
                } catch (Exception e) {
                    componentMonitorCurrentMonitor.invocationFailed(method, t, e);
                    throw new PicoCompositionException("Failed to set property " + str + " to " + obj + ": " + e.getMessage(), e);
                }
            }
        }
        return t;
    }

    @Override // org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "PropertyApplied";
    }

    private Map getSetters(Class cls) {
        HashMap map = new HashMap();
        for (Method method : getMethods(cls)) {
            if (isSetter(method)) {
                map.put(getPropertyName(method), method);
            }
        }
        return map;
    }

    private Method[] getMethods(final Class cls) {
        return (Method[]) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.picocontainer.behaviors.PropertyApplicator.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                return cls.getMethods();
            }
        });
    }

    private String getPropertyName(Method method) {
        String strSubstring = method.getName().substring(3);
        if (strSubstring.length() <= 1 || Character.isUpperCase(strSubstring.charAt(1))) {
            return strSubstring.length() == 1 ? strSubstring.toLowerCase() : strSubstring;
        }
        return "" + Character.toLowerCase(strSubstring.charAt(0)) + strSubstring.substring(1);
    }

    private boolean isSetter(Method method) {
        String name = method.getName();
        return name.length() > 3 && name.startsWith(AttributeMutation.ATTRIBUTE_ACTION_SET) && method.getParameterTypes().length == 1;
    }

    private Object convertType(PicoContainer picoContainer, Method method, String str) {
        Object component;
        if (str == null) {
            return null;
        }
        Class<?> cls = method.getParameterTypes()[0];
        Object objConvert = convert(cls.getName(), str, Thread.currentThread().getContextClassLoader());
        return (objConvert != null || picoContainer == null || (component = picoContainer.getComponent(str)) == null || !cls.isAssignableFrom(component.getClass())) ? objConvert : component;
    }

    public static Object convert(String str, String str2, ClassLoader classLoader) {
        if (str.equals(Boolean.class.getName()) || str.equals(Boolean.TYPE.getName())) {
            return Boolean.valueOf(str2);
        }
        if (str.equals(Byte.class.getName()) || str.equals(Byte.TYPE.getName())) {
            return Byte.valueOf(str2);
        }
        if (str.equals(Short.class.getName()) || str.equals(Short.TYPE.getName())) {
            return Short.valueOf(str2);
        }
        if (str.equals(Integer.class.getName()) || str.equals(Integer.TYPE.getName())) {
            return Integer.valueOf(str2);
        }
        if (str.equals(Long.class.getName()) || str.equals(Long.TYPE.getName())) {
            return Long.valueOf(str2);
        }
        if (str.equals(Float.class.getName()) || str.equals(Float.TYPE.getName())) {
            return Float.valueOf(str2);
        }
        if (str.equals(Double.class.getName()) || str.equals(Double.TYPE.getName())) {
            return Double.valueOf(str2);
        }
        if (str.equals(Character.class.getName()) || str.equals(Character.TYPE.getName())) {
            return Character.valueOf(str2.toCharArray()[0]);
        }
        if (str.equals(String.class.getName()) || str.equals("string")) {
            return str2;
        }
        if (str.equals(File.class.getName()) || str.equals("file")) {
            return new File(str2);
        }
        if (str.equals(URL.class.getName()) || str.equals("url")) {
            try {
                return new URL(str2);
            } catch (MalformedURLException e) {
                throw new PicoCompositionException(e);
            }
        }
        if (str.equals(Class.class.getName()) || str.equals("class")) {
            return loadClass(classLoader, str2);
        }
        PropertyEditor propertyEditorFindEditor = PropertyEditorManager.findEditor(loadClass(classLoader, str));
        if (propertyEditorFindEditor == null) {
            return null;
        }
        propertyEditorFindEditor.setAsText(str2);
        return propertyEditorFindEditor.getValue();
    }

    private static Class loadClass(ClassLoader classLoader, String str) {
        try {
            return classLoader.loadClass(str);
        } catch (ClassNotFoundException e) {
            throw new PicoClassNotFoundException(str, e);
        }
    }

    public void setProperties(Map<String, String> map) {
        this.properties = map;
    }

    private Object getSetterParameter(String str, Object obj, Object obj2, PicoContainer picoContainer) {
        if (obj == null) {
            return null;
        }
        Method method = (Method) this.setters.get(str);
        Class<?> cls = method.getParameterTypes()[0];
        Class<?> cls2 = obj.getClass();
        Object objConvertType = convertType(picoContainer, method, obj.toString());
        if (objConvertType != null) {
            return objConvertType;
        }
        if (cls.isAssignableFrom(cls2)) {
            return obj;
        }
        throw new ClassCastException("Setter: " + method.getName() + " for addComponent: " + obj2.toString() + " can only take objects of: " + cls.getName() + " instead got: " + cls2.getName());
    }

    public void setProperty(String str, String str2) {
        if (this.properties == null) {
            this.properties = new HashMap();
        }
        this.properties.put(str, str2);
    }
}
