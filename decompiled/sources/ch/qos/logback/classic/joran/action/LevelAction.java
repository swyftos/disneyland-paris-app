package ch.qos.logback.classic.joran.action;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.action.ActionConst;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import org.xml.sax.Attributes;

@Deprecated
/* loaded from: classes2.dex */
public class LevelAction extends Action {
    boolean inError = false;

    @Override // ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
        Object objPeekObject = interpretationContext.peekObject();
        if (!(objPeekObject instanceof Logger)) {
            this.inError = true;
            addError("For element <level>, could not find a logger at the top of execution stack.");
            return;
        }
        Logger logger = (Logger) objPeekObject;
        String name = logger.getName();
        String strSubst = interpretationContext.subst(attributes.getValue("value"));
        logger.setLevel((ActionConst.INHERITED.equalsIgnoreCase(strSubst) || ActionConst.NULL.equalsIgnoreCase(strSubst)) ? null : Level.toLevel(strSubst, Level.DEBUG));
        addInfo(name + " level set to " + logger.getLevel());
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext interpretationContext, String str) {
    }

    public void finish(InterpretationContext interpretationContext) {
    }
}
