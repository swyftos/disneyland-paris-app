package cucumber.runtime.java;

import cucumber.api.java.ObjectFactory;
import cucumber.runtime.ClassFinder;
import cucumber.runtime.CucumberException;
import cucumber.runtime.NoInstancesException;
import cucumber.runtime.Reflections;
import cucumber.runtime.TooManyInstancesException;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.ServiceLoader;

/* loaded from: classes5.dex */
public final class ObjectFactoryLoader {
    private static final Logger LOG = LoggerFactory.getLogger(ObjectFactoryLoader.class);

    public static ObjectFactory loadObjectFactory(ClassFinder classFinder, String str, String str2) {
        try {
            Reflections reflections = new Reflections(classFinder);
            if (str == null && str2 == null) {
                return loadSingleObjectFactory(reflections);
            }
            if (str != null) {
                return loadSelectedObjectFactory(reflections, classFinder, str);
            }
            return loadSelectedDeprecatedObjectFactory(reflections, classFinder, str2);
        } catch (NoInstancesException unused) {
            return new DefaultJavaObjectFactory();
        } catch (TooManyInstancesException e) {
            Logger logger = LOG;
            logger.warn(e.getMessage());
            logger.warn(getMultipleObjectFactoryLogMessage());
            return new DefaultJavaObjectFactory();
        } catch (ClassNotFoundException e2) {
            throw new CucumberException("Couldn't instantiate custom ObjectFactory", e2);
        }
    }

    private static ObjectFactory loadSingleObjectFactory(Reflections reflections) {
        Iterator it = ServiceLoader.load(io.cucumber.core.backend.ObjectFactory.class).iterator();
        if (it.hasNext()) {
            HashSet hashSet = new HashSet();
            do {
                hashSet.add(it.next());
            } while (it.hasNext());
            if (hashSet.size() > 1) {
                throw new TooManyInstancesException(hashSet);
            }
            io.cucumber.core.backend.ObjectFactory objectFactory = (io.cucumber.core.backend.ObjectFactory) hashSet.iterator().next();
            LOG.info("Loading ObjectFactory via service loader: " + objectFactory.getClass().getName());
            return new ObjectFactoryAdapter(objectFactory);
        }
        ObjectFactory objectFactory2 = (ObjectFactory) reflections.instantiateExactlyOneSubclass(ObjectFactory.class, Arrays.asList(URI.create("classpath:cucumber/runtime")), new Class[0], new Object[0], null);
        if (objectFactory2 != null) {
            LOG.warn("Loading deprecated ObjectFactory from runtime via reflection: " + objectFactory2.getClass().getName());
        }
        return objectFactory2;
    }

    private static ObjectFactory loadSelectedObjectFactory(Reflections reflections, ClassFinder classFinder, String str) {
        Iterator it = ServiceLoader.load(classFinder.loadClass(str)).iterator();
        if (it.hasNext()) {
            io.cucumber.core.backend.ObjectFactory objectFactory = (io.cucumber.core.backend.ObjectFactory) it.next();
            LOG.info("Loading ObjectFactory via service loader: " + objectFactory.getClass().getName());
            return new ObjectFactoryAdapter(objectFactory);
        }
        LOG.info("Loading ObjectFactory via reflection: " + str);
        return new ObjectFactoryAdapter((io.cucumber.core.backend.ObjectFactory) reflections.newInstance(new Class[0], new Object[0], classFinder.loadClass(str)));
    }

    private static ObjectFactory loadSelectedDeprecatedObjectFactory(Reflections reflections, ClassFinder classFinder, String str) {
        Iterator it = ServiceLoader.load(classFinder.loadClass(str)).iterator();
        if (it.hasNext()) {
            ObjectFactory objectFactory = (ObjectFactory) it.next();
            LOG.warn("Loading deprecated ObjectFactory via service loader: " + objectFactory.getClass().getName());
            return objectFactory;
        }
        LOG.warn("Loading deprecated ObjectFactory via reflection: " + str);
        return (ObjectFactory) reflections.newInstance(new Class[0], new Object[0], classFinder.loadClass(str));
    }

    private static String getMultipleObjectFactoryLogMessage() {
        return "More than one Cucumber ObjectFactory was found in the classpath\n\nYou probably may have included, for instance, cucumber-spring AND cucumber-guice as part of\nyour dependencies. When this happens, Cucumber falls back to instantiating the\nDefaultJavaObjectFactory implementation which doesn't provide IoC.\nIn order to enjoy IoC features, please remove the unnecessary dependencies from your classpath.\n";
    }

    private static class ObjectFactoryAdapter implements ObjectFactory {
        private final io.cucumber.core.backend.ObjectFactory delegate;

        public ObjectFactoryAdapter(io.cucumber.core.backend.ObjectFactory objectFactory) {
            Objects.requireNonNull(objectFactory);
            this.delegate = objectFactory;
        }

        @Override // cucumber.api.java.ObjectFactory
        public void start() {
            this.delegate.start();
        }

        @Override // cucumber.api.java.ObjectFactory
        public void stop() {
            this.delegate.stop();
        }

        @Override // cucumber.api.java.ObjectFactory
        public boolean addClass(Class cls) {
            return this.delegate.addClass(cls);
        }

        @Override // cucumber.api.java.ObjectFactory
        public Object getInstance(Class cls) {
            return this.delegate.getInstance(cls);
        }
    }
}
