package org.junit.runner.manipulation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.junit.runner.Description;

/* loaded from: classes6.dex */
public abstract class Ordering {

    public interface Factory {
        Ordering create(Context context);
    }

    protected abstract List<Description> orderItems(Collection<Description> collection);

    boolean validateOrderingIsCorrect() {
        return true;
    }

    public static Ordering shuffledBy(final Random random) {
        return new Ordering() { // from class: org.junit.runner.manipulation.Ordering.1
            @Override // org.junit.runner.manipulation.Ordering
            boolean validateOrderingIsCorrect() {
                return false;
            }

            @Override // org.junit.runner.manipulation.Ordering
            protected List orderItems(Collection collection) {
                ArrayList arrayList = new ArrayList(collection);
                Collections.shuffle(arrayList, random);
                return arrayList;
            }
        };
    }

    public static Ordering definedBy(Class<? extends Factory> cls, Description description) throws InvalidOrderingException {
        if (cls == null) {
            throw new NullPointerException("factoryClass cannot be null");
        }
        if (description == null) {
            throw new NullPointerException("annotatedTestClass cannot be null");
        }
        try {
            return definedBy(cls.getConstructor(new Class[0]).newInstance(new Object[0]), description);
        } catch (NoSuchMethodException unused) {
            throw new InvalidOrderingException(String.format("Ordering class %s should have a public constructor with signature %s(Ordering.Context context)", getClassName(cls), cls.getSimpleName()));
        } catch (Exception e) {
            throw new InvalidOrderingException("Could not create ordering for " + description, e);
        }
    }

    public static Ordering definedBy(Factory factory, Description description) throws InvalidOrderingException {
        if (factory == null) {
            throw new NullPointerException("factory cannot be null");
        }
        if (description == null) {
            throw new NullPointerException("annotatedTestClass cannot be null");
        }
        return factory.create(new Context(description));
    }

    private static String getClassName(Class cls) {
        String canonicalName = cls.getCanonicalName();
        return canonicalName == null ? cls.getName() : canonicalName;
    }

    public void apply(Object obj) throws InvalidOrderingException {
        if (obj instanceof Orderable) {
            ((Orderable) obj).order(new Orderer(this));
        }
    }

    public static class Context {
        private final Description description;

        public Description getTarget() {
            return this.description;
        }

        private Context(Description description) {
            this.description = description;
        }
    }
}
