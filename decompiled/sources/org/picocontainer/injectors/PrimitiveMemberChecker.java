package org.picocontainer.injectors;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class PrimitiveMemberChecker {
    public static boolean isPrimitiveArgument(AccessibleObject accessibleObject, int i) throws UnsupportedOperationException, ArrayIndexOutOfBoundsException {
        Class<?>[] parameterTypes;
        if (accessibleObject instanceof Constructor) {
            parameterTypes = ((Constructor) accessibleObject).getParameterTypes();
        } else if (accessibleObject instanceof Method) {
            parameterTypes = ((Method) accessibleObject).getParameterTypes();
        } else if (accessibleObject instanceof Field) {
            parameterTypes = new Class[]{((Field) accessibleObject).getType()};
        } else {
            throw new UnsupportedOperationException("Unsupported member type: " + accessibleObject.getClass());
        }
        if (i < parameterTypes.length) {
            return parameterTypes[i].isPrimitive();
        }
        throw new ArrayIndexOutOfBoundsException("Index i > types array length " + parameterTypes.length + " for member " + accessibleObject);
    }
}
