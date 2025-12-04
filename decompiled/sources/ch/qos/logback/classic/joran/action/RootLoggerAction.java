package ch.qos.logback.classic.joran.action;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.OptionHelper;
import org.xml.sax.Attributes;

/* loaded from: classes2.dex */
public class RootLoggerAction extends Action {
    boolean inError = false;
    Logger root;

    @Override // ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
        this.inError = false;
        this.root = ((LoggerContext) this.context).getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        String strSubst = interpretationContext.subst(attributes.getValue("level"));
        if (!OptionHelper.isEmpty(strSubst)) {
            Level level = Level.toLevel(strSubst);
            addInfo("Setting level of ROOT logger to " + level);
            this.root.setLevel(level);
        }
        interpretationContext.pushObject(this.root);
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext interpretationContext, String str) {
        if (this.inError) {
            return;
        }
        Object objPeekObject = interpretationContext.peekObject();
        if (objPeekObject == this.root) {
            interpretationContext.popObject();
            return;
        }
        addWarn("The object on the top the of the stack is not the root logger");
        addWarn("It is: " + objPeekObject);
    }

    public void finish(InterpretationContext interpretationContext) {
    }
}
