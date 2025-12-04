package ch.qos.logback.classic.joran.action;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.LoggerContextListener;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.ActionException;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.LifeCycle;
import ch.qos.logback.core.util.OptionHelper;
import org.xml.sax.Attributes;

/* loaded from: classes2.dex */
public class LoggerContextListenerAction extends Action {
    boolean inError = false;
    LoggerContextListener lcl;

    @Override // ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) throws ActionException {
        this.inError = false;
        String value = attributes.getValue("class");
        if (OptionHelper.isEmpty(value)) {
            addError("Mandatory \"class\" attribute not set for <loggerContextListener> element");
            this.inError = true;
            return;
        }
        try {
            LoggerContextListener loggerContextListener = (LoggerContextListener) OptionHelper.instantiateByClassName(value, (Class<?>) LoggerContextListener.class, this.context);
            this.lcl = loggerContextListener;
            if (loggerContextListener instanceof ContextAware) {
                ((ContextAware) loggerContextListener).setContext(this.context);
            }
            interpretationContext.pushObject(this.lcl);
            addInfo("Adding LoggerContextListener of type [" + value + "] to the object stack");
        } catch (Exception e) {
            this.inError = true;
            addError("Could not create LoggerContextListener of type " + value + "].", e);
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext interpretationContext, String str) throws ActionException {
        if (this.inError) {
            return;
        }
        Object objPeekObject = interpretationContext.peekObject();
        LoggerContextListener loggerContextListener = this.lcl;
        if (objPeekObject != loggerContextListener) {
            addWarn("The object on the top the of the stack is not the LoggerContextListener pushed earlier.");
            return;
        }
        if (loggerContextListener instanceof LifeCycle) {
            ((LifeCycle) loggerContextListener).start();
            addInfo("Starting LoggerContextListener");
        }
        ((LoggerContext) this.context).addListener(this.lcl);
        interpretationContext.popObject();
    }
}
