package ch.qos.logback.classic.joran.action;

import ch.qos.logback.classic.net.ReceiverBase;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.ActionException;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.OptionHelper;
import org.xml.sax.Attributes;

/* loaded from: classes2.dex */
public class ReceiverAction extends Action {
    private boolean inError;
    private ReceiverBase receiver;

    @Override // ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) throws ActionException {
        String value = attributes.getValue("class");
        if (OptionHelper.isEmpty(value)) {
            addError("Missing class name for receiver. Near [" + str + "] line " + getLineNumber(interpretationContext));
            this.inError = true;
            return;
        }
        try {
            addInfo("About to instantiate receiver of type [" + value + "]");
            ReceiverBase receiverBase = (ReceiverBase) OptionHelper.instantiateByClassName(value, (Class<?>) ReceiverBase.class, this.context);
            this.receiver = receiverBase;
            receiverBase.setContext(this.context);
            interpretationContext.pushObject(this.receiver);
        } catch (Exception e) {
            this.inError = true;
            addError("Could not create a receiver of type [" + value + "].", e);
            throw new ActionException(e);
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext interpretationContext, String str) throws ActionException {
        if (this.inError) {
            return;
        }
        interpretationContext.getContext().register(this.receiver);
        this.receiver.start();
        if (interpretationContext.peekObject() != this.receiver) {
            addWarn("The object at the of the stack is not the remote pushed earlier.");
        } else {
            interpretationContext.popObject();
        }
    }
}
