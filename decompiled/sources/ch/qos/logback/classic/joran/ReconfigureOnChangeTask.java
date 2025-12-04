package ch.qos.logback.classic.joran;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.joran.event.SaxEvent;
import ch.qos.logback.core.joran.spi.ConfigurationWatchList;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.status.StatusUtil;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ReconfigureOnChangeTask extends ContextAwareBase implements Runnable {
    public static final String DETECTED_CHANGE_IN_CONFIGURATION_FILES = "Detected change in configuration files.";
    long birthdate = System.currentTimeMillis();
    List listeners;

    private void fallbackConfiguration(LoggerContext loggerContext, List list, URL url) {
        List<SaxEvent> listRemoveIncludeEvents = removeIncludeEvents(list);
        JoranConfigurator joranConfigurator = new JoranConfigurator();
        joranConfigurator.setContext(this.context);
        ConfigurationWatchList configurationWatchListBuildClone = ConfigurationWatchListUtil.getConfigurationWatchList(this.context).buildClone();
        if (listRemoveIncludeEvents == null || listRemoveIncludeEvents.isEmpty()) {
            addWarn("No previous configuration to fall back on.");
            return;
        }
        addWarn("Given previous errors, falling back to previously registered safe configuration.");
        try {
            loggerContext.reset();
            ConfigurationWatchListUtil.registerConfigurationWatchList(this.context, configurationWatchListBuildClone);
            joranConfigurator.doConfigure(listRemoveIncludeEvents);
            addInfo("Re-registering previous fallback configuration once more as a fallback configuration point");
            joranConfigurator.registerSafeConfiguration(list);
            addInfo("after registerSafeConfiguration: " + list);
        } catch (JoranException e) {
            addError("Unexpected exception thrown by a configuration considered safe.", e);
        }
    }

    private void fireChangeDetected() {
        List list = this.listeners;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ReconfigureOnChangeTaskListener) it.next()).changeDetected();
        }
    }

    private void fireDoneReconfiguring() {
        List list = this.listeners;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ReconfigureOnChangeTaskListener) it.next()).doneReconfiguring();
        }
    }

    private void fireEnteredRunMethod() {
        List list = this.listeners;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ReconfigureOnChangeTaskListener) it.next()).enteredRunMethod();
        }
    }

    private void performXMLConfiguration(LoggerContext loggerContext, URL url) throws IOException {
        JoranConfigurator joranConfigurator = new JoranConfigurator();
        joranConfigurator.setContext(this.context);
        StatusUtil statusUtil = new StatusUtil(this.context);
        List<SaxEvent> listRecallSafeConfiguration = joranConfigurator.recallSafeConfiguration();
        URL mainWatchURL = ConfigurationWatchListUtil.getMainWatchURL(this.context);
        loggerContext.reset();
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            joranConfigurator.doConfigure(url);
            if (statusUtil.hasXMLParsingErrors(jCurrentTimeMillis)) {
                fallbackConfiguration(loggerContext, listRecallSafeConfiguration, mainWatchURL);
            }
        } catch (JoranException unused) {
            fallbackConfiguration(loggerContext, listRecallSafeConfiguration, mainWatchURL);
        }
    }

    private List removeIncludeEvents(List list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SaxEvent saxEvent = (SaxEvent) it.next();
            if (!"include".equalsIgnoreCase(saxEvent.getLocalName())) {
                arrayList.add(saxEvent);
            }
        }
        return arrayList;
    }

    @Override // java.lang.Runnable
    public void run() throws IOException {
        fireEnteredRunMethod();
        ConfigurationWatchList configurationWatchList = ConfigurationWatchListUtil.getConfigurationWatchList(this.context);
        if (configurationWatchList == null) {
            addWarn("Empty ConfigurationWatchList in context");
            return;
        }
        List<File> copyOfFileWatchList = configurationWatchList.getCopyOfFileWatchList();
        if (copyOfFileWatchList == null || copyOfFileWatchList.isEmpty()) {
            addInfo("Empty watch file list. Disabling ");
            return;
        }
        if (configurationWatchList.changeDetected()) {
            fireChangeDetected();
            URL mainURL = configurationWatchList.getMainURL();
            addInfo(DETECTED_CHANGE_IN_CONFIGURATION_FILES);
            addInfo("Will reset and reconfigure context named [" + this.context.getName() + "]");
            LoggerContext loggerContext = (LoggerContext) this.context;
            if (mainURL.toString().endsWith("xml")) {
                performXMLConfiguration(loggerContext, mainURL);
            } else if (mainURL.toString().endsWith("groovy")) {
                addError("Groovy classes are not available on the class path. ABORTING INITIALIZATION.");
            }
            fireDoneReconfiguring();
        }
    }

    public String toString() {
        return "ReconfigureOnChangeTask(born:" + this.birthdate + ")";
    }
}
