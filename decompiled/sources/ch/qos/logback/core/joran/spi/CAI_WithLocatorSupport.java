package ch.qos.logback.core.joran.spi;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAwareImpl;
import gherkin.GherkinLanguageConstants;
import org.xml.sax.Locator;

/* loaded from: classes2.dex */
class CAI_WithLocatorSupport extends ContextAwareImpl {
    CAI_WithLocatorSupport(Context context, Interpreter interpreter) {
        super(context, interpreter);
    }

    @Override // ch.qos.logback.core.spi.ContextAwareImpl
    protected Object getOrigin() {
        Locator locator = ((Interpreter) super.getOrigin()).locator;
        if (locator == null) {
            return Interpreter.class.getName() + "@NA:NA";
        }
        return Interpreter.class.getName() + GherkinLanguageConstants.TAG_PREFIX + locator.getLineNumber() + ":" + locator.getColumnNumber();
    }
}
