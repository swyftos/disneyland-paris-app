package ch.qos.logback.classic.joran.action;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.action.ActionConst;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.OptionHelper;
import org.xml.sax.Attributes;

/* loaded from: classes2.dex */
public class LoggerAction extends Action {
    public static final String LEVEL_ATTRIBUTE = "level";
    boolean inError = false;
    Logger logger;

    @Override // ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
        this.inError = false;
        this.logger = null;
        LoggerContext loggerContext = (LoggerContext) this.context;
        String strSubst = interpretationContext.subst(attributes.getValue("name"));
        if (OptionHelper.isEmpty(strSubst)) {
            this.inError = true;
            addError("No 'name' attribute in element " + str + ", around " + getLineColStr(interpretationContext));
            return;
        }
        this.logger = loggerContext.getLogger(strSubst);
        String strSubst2 = interpretationContext.subst(attributes.getValue("level"));
        if (!OptionHelper.isEmpty(strSubst2)) {
            if (ActionConst.INHERITED.equalsIgnoreCase(strSubst2) || ActionConst.NULL.equalsIgnoreCase(strSubst2)) {
                addInfo("Setting level of logger [" + strSubst + "] to null, i.e. INHERITED");
                this.logger.setLevel(null);
            } else {
                Level level = Level.toLevel(strSubst2);
                addInfo("Setting level of logger [" + strSubst + "] to " + level);
                this.logger.setLevel(level);
            }
        }
        String strSubst3 = interpretationContext.subst(attributes.getValue(ActionConst.ADDITIVITY_ATTRIBUTE));
        if (!OptionHelper.isEmpty(strSubst3)) {
            boolean zBooleanValue = Boolean.valueOf(strSubst3).booleanValue();
            addInfo("Setting additivity of logger [" + strSubst + "] to " + zBooleanValue);
            this.logger.setAdditive(zBooleanValue);
        }
        interpretationContext.pushObject(this.logger);
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext interpretationContext, String str) {
        if (this.inError) {
            return;
        }
        Object objPeekObject = interpretationContext.peekObject();
        if (objPeekObject == this.logger) {
            interpretationContext.popObject();
            return;
        }
        addWarn("The object on the top the of the stack is not " + this.logger + " pushed earlier");
        StringBuilder sb = new StringBuilder();
        sb.append("It is: ");
        sb.append(objPeekObject);
        addWarn(sb.toString());
    }

    public void finish(InterpretationContext interpretationContext) {
    }
}
