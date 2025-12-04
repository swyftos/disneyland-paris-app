package org.junit.runners.model;

import java.lang.reflect.Modifier;
import java.util.List;
import org.junit.runners.model.FrameworkMember;

/* loaded from: classes6.dex */
public abstract class FrameworkMember<T extends FrameworkMember<T>> implements Annotatable {
    public abstract Class<?> getDeclaringClass();

    protected abstract int getModifiers();

    public abstract String getName();

    public abstract Class<?> getType();

    abstract boolean isBridgeMethod();

    abstract boolean isShadowedBy(FrameworkMember frameworkMember);

    FrameworkMember handlePossibleBridgeMethod(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            FrameworkMember frameworkMember = (FrameworkMember) list.get(size);
            if (isShadowedBy(frameworkMember)) {
                if (!frameworkMember.isBridgeMethod()) {
                    return null;
                }
                list.remove(size);
                return frameworkMember;
            }
        }
        return this;
    }

    public boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }

    public boolean isPublic() {
        return Modifier.isPublic(getModifiers());
    }
}
