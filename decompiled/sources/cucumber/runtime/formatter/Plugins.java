package cucumber.runtime.formatter;

import cucumber.api.Plugin;
import cucumber.api.StepDefinitionReporter;
import cucumber.api.event.ConcurrentEventListener;
import cucumber.api.event.Event;
import cucumber.api.event.EventHandler;
import cucumber.api.event.EventListener;
import cucumber.api.event.EventPublisher;
import cucumber.api.formatter.ColorAware;
import cucumber.api.formatter.StrictAware;
import cucumber.runner.CanonicalOrderEventPublisher;
import cucumber.runtime.Utils;
import io.cucumber.core.options.PluginOptions;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class Plugins {
    private final ClassLoader classLoader;
    private EventPublisher orderedEventPublisher;
    private final PluginFactory pluginFactory;
    private boolean pluginNamesInstantiated;
    private final PluginOptions pluginOptions;
    private final List plugins = createPlugins();

    public Plugins(ClassLoader classLoader, PluginFactory pluginFactory, PluginOptions pluginOptions) {
        this.classLoader = classLoader;
        this.pluginFactory = pluginFactory;
        this.pluginOptions = pluginOptions;
    }

    private EventPublisher getOrderedEventPublisher(EventPublisher eventPublisher) {
        if (this.orderedEventPublisher == null) {
            this.orderedEventPublisher = createCanonicalOrderEventPublisher(eventPublisher);
        }
        return this.orderedEventPublisher;
    }

    private static EventPublisher createCanonicalOrderEventPublisher(EventPublisher eventPublisher) {
        final CanonicalOrderEventPublisher canonicalOrderEventPublisher = new CanonicalOrderEventPublisher();
        eventPublisher.registerHandlerFor(Event.class, new EventHandler() { // from class: cucumber.runtime.formatter.Plugins.1
            @Override // cucumber.api.event.EventHandler
            public void receive(Event event) {
                canonicalOrderEventPublisher.handle(event);
            }
        });
        return canonicalOrderEventPublisher;
    }

    private List createPlugins() {
        ArrayList arrayList = new ArrayList();
        if (!this.pluginNamesInstantiated) {
            Iterator<String> it = this.pluginOptions.getPluginNames().iterator();
            while (it.hasNext()) {
                addPlugin(arrayList, this.pluginFactory.create(it.next()));
            }
            this.pluginNamesInstantiated = true;
        }
        return arrayList;
    }

    public List<Plugin> getPlugins() {
        return this.plugins;
    }

    public StepDefinitionReporter stepDefinitionReporter() {
        return (StepDefinitionReporter) pluginProxy(StepDefinitionReporter.class);
    }

    public void addPlugin(Plugin plugin) {
        addPlugin(this.plugins, plugin);
    }

    private void addPlugin(List list, Plugin plugin) {
        list.add(plugin);
        setMonochromeOnColorAwarePlugins(plugin);
        setStrictOnStrictAwarePlugins(plugin);
    }

    private void setMonochromeOnColorAwarePlugins(Plugin plugin) {
        if (plugin instanceof ColorAware) {
            ((ColorAware) plugin).setMonochrome(this.pluginOptions.isMonochrome());
        }
    }

    private void setStrictOnStrictAwarePlugins(Plugin plugin) {
        if (plugin instanceof StrictAware) {
            ((StrictAware) plugin).setStrict(this.pluginOptions.isStrict());
        }
    }

    public void setEventBusOnEventListenerPlugins(EventPublisher eventPublisher) {
        for (Plugin plugin : this.plugins) {
            if (plugin instanceof ConcurrentEventListener) {
                ((ConcurrentEventListener) plugin).setEventPublisher(eventPublisher);
            } else if (plugin instanceof EventListener) {
                ((EventListener) plugin).setEventPublisher(eventPublisher);
            }
        }
    }

    public void setSerialEventBusOnEventListenerPlugins(EventPublisher eventPublisher) {
        for (Plugin plugin : this.plugins) {
            if (plugin instanceof ConcurrentEventListener) {
                ((ConcurrentEventListener) plugin).setEventPublisher(eventPublisher);
            } else if (plugin instanceof EventListener) {
                ((EventListener) plugin).setEventPublisher(getOrderedEventPublisher(eventPublisher));
            }
        }
    }

    private Object pluginProxy(final Class cls) {
        return cls.cast(Proxy.newProxyInstance(this.classLoader, new Class[]{cls}, new InvocationHandler() { // from class: cucumber.runtime.formatter.Plugins.2
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) {
                boolean zEquals;
                boolean zEquals2;
                for (Plugin plugin : Plugins.this.getPlugins()) {
                    if (cls.isInstance(plugin)) {
                        try {
                            Utils.invoke(plugin, method, 0L, objArr);
                        } finally {
                            if (zEquals) {
                                continue;
                            }
                        }
                    }
                }
                return null;
            }
        }));
    }
}
