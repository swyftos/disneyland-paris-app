package ch.qos.logback.core.joran.action;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.hook.DefaultShutdownHook;
import ch.qos.logback.core.hook.ShutdownHookBase;
import ch.qos.logback.core.joran.spi.ActionException;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.OptionHelper;
import org.xml.sax.Attributes;

/* loaded from: classes2.dex */
public class ShutdownHookAction extends Action {
    ShutdownHookBase hook;
    private boolean inError;

    @Override // ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) throws ActionException {
        this.hook = null;
        this.inError = false;
        String value = attributes.getValue("class");
        if (OptionHelper.isEmpty(value)) {
            value = DefaultShutdownHook.class.getName();
            addInfo("Assuming className [" + value + "]");
        }
        try {
            addInfo("About to instantiate shutdown hook of type [" + value + "]");
            ShutdownHookBase shutdownHookBase = (ShutdownHookBase) OptionHelper.instantiateByClassName(value, (Class<?>) ShutdownHookBase.class, this.context);
            this.hook = shutdownHookBase;
            shutdownHookBase.setContext(this.context);
            interpretationContext.pushObject(this.hook);
        } catch (Exception e) {
            this.inError = true;
            addError("Could not create a shutdown hook of type [" + value + "].", e);
            throw new ActionException(e);
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext interpretationContext, String str) throws ActionException {
        if (this.inError) {
            return;
        }
        if (interpretationContext.peekObject() != this.hook) {
            addWarn("The object at the of the stack is not the hook pushed earlier.");
            return;
        }
        interpretationContext.popObject();
        Thread thread = new Thread(this.hook, "Logback shutdown hook [" + this.context.getName() + "]");
        addInfo("Registering shutdown hook with JVM runtime");
        this.context.putObject(CoreConstants.SHUTDOWN_HOOK_THREAD, thread);
        Runtime.getRuntime().addShutdownHook(thread);
    }
}
