package ch.qos.logback.core.joran;

import ch.qos.logback.core.joran.action.ActionConst;
import ch.qos.logback.core.joran.action.AppenderAction;
import ch.qos.logback.core.joran.action.AppenderRefAction;
import ch.qos.logback.core.joran.action.ConversionRuleAction;
import ch.qos.logback.core.joran.action.DefinePropertyAction;
import ch.qos.logback.core.joran.action.NestedBasicPropertyIA;
import ch.qos.logback.core.joran.action.NestedComplexPropertyIA;
import ch.qos.logback.core.joran.action.NewRuleAction;
import ch.qos.logback.core.joran.action.ParamAction;
import ch.qos.logback.core.joran.action.PropertyAction;
import ch.qos.logback.core.joran.action.ShutdownHookAction;
import ch.qos.logback.core.joran.action.StatusListenerAction;
import ch.qos.logback.core.joran.action.TimestampAction;
import ch.qos.logback.core.joran.spi.ElementSelector;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.joran.spi.Interpreter;
import ch.qos.logback.core.joran.spi.RuleStore;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class JoranConfiguratorBase<E> extends GenericConfigurator {
    @Override // ch.qos.logback.core.joran.GenericConfigurator
    protected void addImplicitRules(Interpreter interpreter) {
        NestedComplexPropertyIA nestedComplexPropertyIA = new NestedComplexPropertyIA();
        nestedComplexPropertyIA.setContext(this.context);
        interpreter.addImplicitAction(nestedComplexPropertyIA);
        NestedBasicPropertyIA nestedBasicPropertyIA = new NestedBasicPropertyIA();
        nestedBasicPropertyIA.setContext(this.context);
        interpreter.addImplicitAction(nestedBasicPropertyIA);
    }

    @Override // ch.qos.logback.core.joran.GenericConfigurator
    protected void addInstanceRules(RuleStore ruleStore) {
        ruleStore.addRule(new ElementSelector("configuration/property"), new PropertyAction());
        ruleStore.addRule(new ElementSelector("configuration/substitutionProperty"), new PropertyAction());
        ruleStore.addRule(new ElementSelector("configuration/timestamp"), new TimestampAction());
        ruleStore.addRule(new ElementSelector("configuration/shutdownHook"), new ShutdownHookAction());
        ruleStore.addRule(new ElementSelector("configuration/define"), new DefinePropertyAction());
        ruleStore.addRule(new ElementSelector("configuration/conversionRule"), new ConversionRuleAction());
        ruleStore.addRule(new ElementSelector("configuration/statusListener"), new StatusListenerAction());
        ruleStore.addRule(new ElementSelector("configuration/appender"), new AppenderAction());
        ruleStore.addRule(new ElementSelector("configuration/appender/appender-ref"), new AppenderRefAction());
        ruleStore.addRule(new ElementSelector("configuration/newRule"), new NewRuleAction());
        ruleStore.addRule(new ElementSelector("*/param"), new ParamAction());
    }

    @Override // ch.qos.logback.core.joran.GenericConfigurator
    protected void buildInterpreter() {
        super.buildInterpreter();
        this.interpreter.getInterpretationContext().getObjectMap().put(ActionConst.APPENDER_BAG, new HashMap());
    }

    public List getErrorList() {
        return null;
    }

    public InterpretationContext getInterpretationContext() {
        return this.interpreter.getInterpretationContext();
    }
}
