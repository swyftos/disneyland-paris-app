package ch.qos.logback.core.joran.action;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.boolex.EventEvaluator;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.OptionHelper;
import java.util.Map;
import org.xml.sax.Attributes;

/* loaded from: classes2.dex */
public abstract class AbstractEventEvaluatorAction extends Action {
    EventEvaluator evaluator;
    boolean inError = false;

    @Override // ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
        String str2;
        this.inError = false;
        this.evaluator = null;
        String value = attributes.getValue("class");
        if (OptionHelper.isEmpty(value)) {
            value = defaultClassName();
            addInfo("Assuming default evaluator class [" + value + "]");
        }
        if (OptionHelper.isEmpty(value)) {
            defaultClassName();
            this.inError = true;
            str2 = "Mandatory \"class\" attribute not set for <evaluator>";
        } else {
            String value2 = attributes.getValue("name");
            if (!OptionHelper.isEmpty(value2)) {
                try {
                    EventEvaluator eventEvaluator = (EventEvaluator) OptionHelper.instantiateByClassName(value, (Class<?>) EventEvaluator.class, this.context);
                    this.evaluator = eventEvaluator;
                    eventEvaluator.setContext(this.context);
                    this.evaluator.setName(value2);
                    interpretationContext.pushObject(this.evaluator);
                    addInfo("Adding evaluator named [" + value2 + "] to the object stack");
                    return;
                } catch (Exception e) {
                    this.inError = true;
                    addError("Could not create evaluator of type " + value + "].", e);
                    return;
                }
            }
            this.inError = true;
            str2 = "Mandatory \"name\" attribute not set for <evaluator>";
        }
        addError(str2);
    }

    protected abstract String defaultClassName();

    @Override // ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext interpretationContext, String str) {
        if (this.inError) {
            return;
        }
        if (this.evaluator != null) {
            this.evaluator.start();
            addInfo("Starting evaluator named [" + this.evaluator.getName() + "]");
        }
        if (interpretationContext.peekObject() != this.evaluator) {
            addWarn("The object on the top the of the stack is not the evaluator pushed earlier.");
            return;
        }
        interpretationContext.popObject();
        try {
            Map map = (Map) this.context.getObject(CoreConstants.EVALUATOR_MAP);
            if (map == null) {
                addError("Could not find EvaluatorMap");
            } else {
                map.put(this.evaluator.getName(), this.evaluator);
            }
        } catch (Exception e) {
            addError("Could not set evaluator named [" + this.evaluator + "].", e);
        }
    }

    public void finish(InterpretationContext interpretationContext) {
    }
}
