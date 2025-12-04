package ch.qos.logback.core.joran.action;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.OptionHelper;
import java.util.HashMap;
import java.util.Map;
import org.xml.sax.Attributes;

/* loaded from: classes2.dex */
public class ConversionRuleAction extends Action {
    boolean inError = false;

    @Override // ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
        this.inError = false;
        String value = attributes.getValue(ActionConst.CONVERSION_WORD_ATTRIBUTE);
        String value2 = attributes.getValue(ActionConst.CONVERTER_CLASS_ATTRIBUTE);
        if (OptionHelper.isEmpty(value)) {
            this.inError = true;
            addError("No 'conversionWord' attribute in <conversionRule>");
            return;
        }
        if (OptionHelper.isEmpty(value2)) {
            this.inError = true;
            interpretationContext.addError("No 'converterClass' attribute in <conversionRule>");
            return;
        }
        try {
            Map map = (Map) this.context.getObject(CoreConstants.PATTERN_RULE_REGISTRY);
            if (map == null) {
                map = new HashMap();
                this.context.putObject(CoreConstants.PATTERN_RULE_REGISTRY, map);
            }
            addInfo("registering conversion word " + value + " with class [" + value2 + "]");
            map.put(value, value2);
        } catch (Exception unused) {
            this.inError = true;
            addError("Could not add conversion rule to PatternLayout.");
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext interpretationContext, String str) {
    }

    public void finish(InterpretationContext interpretationContext) {
    }
}
