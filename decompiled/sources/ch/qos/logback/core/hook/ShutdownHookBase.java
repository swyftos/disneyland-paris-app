package ch.qos.logback.core.hook;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.ContextBase;
import ch.qos.logback.core.spi.ContextAwareBase;

/* loaded from: classes2.dex */
public abstract class ShutdownHookBase extends ContextAwareBase implements ShutdownHook {
    protected void stop() {
        addInfo("Logback context being closed via shutdown hook");
        Context context = getContext();
        if (context instanceof ContextBase) {
            ((ContextBase) context).stop();
        }
    }
}
