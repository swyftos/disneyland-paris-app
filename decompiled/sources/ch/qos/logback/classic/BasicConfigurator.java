package ch.qos.logback.classic;

import ch.qos.logback.classic.layout.TTLLLayout;
import ch.qos.logback.classic.spi.Configurator;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.encoder.LayoutWrappingEncoder;
import ch.qos.logback.core.spi.ContextAwareBase;

@Deprecated
/* loaded from: classes2.dex */
public class BasicConfigurator extends ContextAwareBase implements Configurator {
    @Override // ch.qos.logback.classic.spi.Configurator
    public void configure(LoggerContext loggerContext) {
        addInfo("Setting up default configuration.");
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setContext(loggerContext);
        consoleAppender.setName("console");
        LayoutWrappingEncoder layoutWrappingEncoder = new LayoutWrappingEncoder();
        layoutWrappingEncoder.setContext(loggerContext);
        TTLLLayout tTLLLayout = new TTLLLayout();
        tTLLLayout.setContext(loggerContext);
        tTLLLayout.start();
        layoutWrappingEncoder.setLayout(tTLLLayout);
        consoleAppender.setEncoder(layoutWrappingEncoder);
        consoleAppender.start();
        loggerContext.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME).addAppender(consoleAppender);
    }
}
