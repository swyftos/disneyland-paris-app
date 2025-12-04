package org.hamcrest.beans;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/* loaded from: classes6.dex */
public class PropertyUtil {
    public static final Object[] NO_ARGUMENTS = new Object[0];

    public static PropertyDescriptor getPropertyDescriptor(String str, Object obj) throws IllegalArgumentException {
        for (PropertyDescriptor propertyDescriptor : propertyDescriptorsFor(obj, null)) {
            if (propertyDescriptor.getName().equals(str)) {
                return propertyDescriptor;
            }
        }
        return null;
    }

    public static PropertyDescriptor[] propertyDescriptorsFor(Object obj, Class<Object> cls) throws IllegalArgumentException {
        try {
            return Introspector.getBeanInfo(obj.getClass(), cls).getPropertyDescriptors();
        } catch (IntrospectionException e) {
            throw new IllegalArgumentException("Could not get property descriptors for " + obj.getClass(), e);
        }
    }
}
