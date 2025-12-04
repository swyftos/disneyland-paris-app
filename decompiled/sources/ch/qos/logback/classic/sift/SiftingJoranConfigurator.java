package ch.qos.logback.classic.sift;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.util.DefaultNestedComponentRules;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.joran.action.ActionConst;
import ch.qos.logback.core.joran.action.AppenderAction;
import ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import ch.qos.logback.core.joran.spi.ElementPath;
import ch.qos.logback.core.joran.spi.ElementSelector;
import ch.qos.logback.core.joran.spi.RuleStore;
import ch.qos.logback.core.sift.SiftingJoranConfiguratorBase;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class SiftingJoranConfigurator extends SiftingJoranConfiguratorBase<ILoggingEvent> {
    SiftingJoranConfigurator(String str, String str2, Map map) {
        super(str, str2, map);
    }

    @Override // ch.qos.logback.core.joran.GenericConfigurator
    protected void addDefaultNestedComponentRegistryRules(DefaultNestedComponentRegistry defaultNestedComponentRegistry) {
        DefaultNestedComponentRules.addDefaultNestedComponentRegistryRules(defaultNestedComponentRegistry);
    }

    @Override // ch.qos.logback.core.sift.SiftingJoranConfiguratorBase, ch.qos.logback.core.joran.GenericConfigurator
    protected void addInstanceRules(RuleStore ruleStore) {
        super.addInstanceRules(ruleStore);
        ruleStore.addRule(new ElementSelector("configuration/appender"), new AppenderAction());
    }

    @Override // ch.qos.logback.core.joran.GenericConfigurator
    protected void buildInterpreter() {
        super.buildInterpreter();
        this.interpreter.getInterpretationContext().getObjectMap().put(ActionConst.APPENDER_BAG, new HashMap());
        HashMap map = new HashMap();
        map.putAll(this.parentPropertyMap);
        map.put(this.key, this.value);
        this.interpreter.setInterpretationContextPropertiesMap(map);
    }

    @Override // ch.qos.logback.core.sift.SiftingJoranConfiguratorBase
    public Appender<ILoggingEvent> getAppender() {
        HashMap map = (HashMap) this.interpreter.getInterpretationContext().getObjectMap().get(ActionConst.APPENDER_BAG);
        oneAndOnlyOneCheck(map);
        Collection collectionValues = map.values();
        if (collectionValues.size() == 0) {
            return null;
        }
        return (Appender) collectionValues.iterator().next();
    }

    @Override // ch.qos.logback.core.joran.GenericConfigurator
    protected ElementPath initialElementPath() {
        return new ElementPath("configuration");
    }
}
