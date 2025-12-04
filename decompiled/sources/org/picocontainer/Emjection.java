package org.picocontainer;

import java.lang.reflect.Field;
import org.picocontainer.containers.ImmutablePicoContainer;
import org.picocontainer.containers.TransientPicoContainer;
import org.picocontainer.injectors.ConstructorInjection;

/* loaded from: classes6.dex */
public class Emjection {
    private PicoContainer pico;

    public void setPico(ImmutablePicoContainer immutablePicoContainer) {
        if (this.pico != null) {
            throw new PicoCompositionException("Emjection can only be setup once per component");
        }
        this.pico = immutablePicoContainer;
    }

    public static <T> T neu(Class<T> cls, Emjection emjection, Object... objArr) throws NoSuchFieldException, SecurityException {
        if (emjection.pico == null) {
            throw new PicoCompositionException("blah");
        }
        TransientPicoContainer transientPicoContainer = new TransientPicoContainer(new ConstructorInjection(), emjection.pico);
        for (Object obj : objArr) {
            transientPicoContainer.addComponent(obj);
        }
        T t = (T) transientPicoContainer.getComponent((Class) cls);
        if (t == null) {
            transientPicoContainer.addComponent(cls);
            t = (T) transientPicoContainer.getComponent((Class) cls);
        }
        setPico(t, transientPicoContainer);
        return t;
    }

    private static void setPico(Object obj, PicoContainer picoContainer) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = obj.getClass().getDeclaredField("emjection");
            declaredField.setAccessible(true);
            ((Emjection) declaredField.get(obj)).setPico(new ImmutablePicoContainer(picoContainer));
        } catch (IllegalAccessException unused) {
            throw new PicoCompositionException("unable to access field called emjection on " + obj.getClass());
        } catch (NoSuchFieldException unused2) {
            throw new PicoCompositionException("Components created via emjection have to have a field 'private Emjection emjection'. " + obj.getClass() + " is missing that field");
        }
    }

    public static void setupEmjection(Object obj, PicoContainer picoContainer) {
        setPico(obj, picoContainer);
    }
}
