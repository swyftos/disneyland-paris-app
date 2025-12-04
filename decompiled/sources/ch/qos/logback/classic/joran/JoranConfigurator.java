package ch.qos.logback.classic.joran;

import ch.qos.logback.classic.joran.action.ConditionalIncludeAction;
import ch.qos.logback.classic.joran.action.ConfigurationAction;
import ch.qos.logback.classic.joran.action.ContextNameAction;
import ch.qos.logback.classic.joran.action.FindIncludeAction;
import ch.qos.logback.classic.joran.action.LevelAction;
import ch.qos.logback.classic.joran.action.LoggerAction;
import ch.qos.logback.classic.joran.action.LoggerContextListenerAction;
import ch.qos.logback.classic.joran.action.ReceiverAction;
import ch.qos.logback.classic.joran.action.RootLoggerAction;
import ch.qos.logback.classic.sift.SiftAction;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.util.DefaultNestedComponentRules;
import ch.qos.logback.core.joran.JoranConfiguratorBase;
import ch.qos.logback.core.joran.action.AppenderRefAction;
import ch.qos.logback.core.joran.action.IncludeAction;
import ch.qos.logback.core.joran.action.NOPAction;
import ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import ch.qos.logback.core.joran.spi.ElementSelector;
import ch.qos.logback.core.joran.spi.RuleStore;

/* loaded from: classes2.dex */
public class JoranConfigurator extends JoranConfiguratorBase<ILoggingEvent> {
    @Override // ch.qos.logback.core.joran.GenericConfigurator
    protected void addDefaultNestedComponentRegistryRules(DefaultNestedComponentRegistry defaultNestedComponentRegistry) {
        DefaultNestedComponentRules.addDefaultNestedComponentRegistryRules(defaultNestedComponentRegistry);
    }

    @Override // ch.qos.logback.core.joran.JoranConfiguratorBase, ch.qos.logback.core.joran.GenericConfigurator
    public void addInstanceRules(RuleStore ruleStore) {
        super.addInstanceRules(ruleStore);
        ruleStore.addRule(new ElementSelector("configuration"), new ConfigurationAction());
        ruleStore.addRule(new ElementSelector("configuration/contextName"), new ContextNameAction());
        ruleStore.addRule(new ElementSelector("configuration/contextListener"), new LoggerContextListenerAction());
        ruleStore.addRule(new ElementSelector("configuration/appender/sift"), new SiftAction());
        ruleStore.addRule(new ElementSelector("configuration/appender/sift/*"), new NOPAction());
        ruleStore.addRule(new ElementSelector("configuration/logger"), new LoggerAction());
        ruleStore.addRule(new ElementSelector("configuration/logger/level"), new LevelAction());
        ruleStore.addRule(new ElementSelector("configuration/root"), new RootLoggerAction());
        ruleStore.addRule(new ElementSelector("configuration/root/level"), new LevelAction());
        ruleStore.addRule(new ElementSelector("configuration/logger/appender-ref"), new AppenderRefAction());
        ruleStore.addRule(new ElementSelector("configuration/root/appender-ref"), new AppenderRefAction());
        ruleStore.addRule(new ElementSelector("configuration/include"), new IncludeAction());
        ruleStore.addRule(new ElementSelector("configuration/includes"), new FindIncludeAction());
        ruleStore.addRule(new ElementSelector("configuration/includes/include"), new ConditionalIncludeAction());
        ruleStore.addRule(new ElementSelector("configuration/receiver"), new ReceiverAction());
    }
}
