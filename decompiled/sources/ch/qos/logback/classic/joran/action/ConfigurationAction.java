package ch.qos.logback.classic.joran.action;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.ReconfigureOnChangeTask;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
import ch.qos.logback.core.status.OnConsoleStatusListener;
import ch.qos.logback.core.util.ContextUtil;
import ch.qos.logback.core.util.Duration;
import ch.qos.logback.core.util.OptionHelper;
import ch.qos.logback.core.util.StatusListenerConfigHelper;
import java.net.URL;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.xml.sax.Attributes;

/* loaded from: classes2.dex */
public class ConfigurationAction extends Action {
    static final Duration SCAN_PERIOD_DEFAULT = Duration.buildByMinutes(1.0d);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [ch.qos.logback.core.util.Duration] */
    /* JADX WARN: Type inference failed for: r7v1, types: [ch.qos.logback.core.util.Duration] */
    private Duration getDurationOfScanPeriodAttribute(String str, Duration duration) {
        Throwable thValueOf;
        Throwable th = null;
        if (!OptionHelper.isEmpty(str)) {
            try {
                thValueOf = Duration.valueOf(str);
            } catch (IllegalArgumentException | IllegalStateException e) {
                th = e;
                thValueOf = null;
            }
            if (th != null) {
                addWarn("Failed to parse 'scanPeriod' attribute [" + str + "]", th);
            }
            th = thValueOf;
        }
        if (th != null) {
            return th;
        }
        addInfo("No 'scanPeriod' specified. Defaulting to " + duration.toString());
        return duration;
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
        String systemProperty = OptionHelper.getSystemProperty("logback.debug");
        if (systemProperty == null) {
            systemProperty = interpretationContext.subst(attributes.getValue("debug"));
        }
        if (OptionHelper.isEmpty(systemProperty) || systemProperty.equalsIgnoreCase("false") || systemProperty.equalsIgnoreCase("null")) {
            addInfo("debug attribute not set");
        } else {
            StatusListenerConfigHelper.addOnConsoleListenerInstance(this.context, new OnConsoleStatusListener());
        }
        processScanAttrib(interpretationContext, attributes);
        new ContextUtil(this.context).addHostNameAsProperty();
        interpretationContext.pushObject(getContext());
        ((LoggerContext) this.context).setPackagingDataEnabled(OptionHelper.toBoolean(interpretationContext.subst(attributes.getValue("packagingData")), false));
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext interpretationContext, String str) {
        addInfo("End of configuration.");
        interpretationContext.popObject();
    }

    void processScanAttrib(InterpretationContext interpretationContext, Attributes attributes) {
        String strSubst = interpretationContext.subst(attributes.getValue("scan"));
        if (OptionHelper.isEmpty(strSubst) || "false".equalsIgnoreCase(strSubst)) {
            return;
        }
        ScheduledExecutorService scheduledExecutorService = this.context.getScheduledExecutorService();
        URL mainWatchURL = ConfigurationWatchListUtil.getMainWatchURL(this.context);
        if (mainWatchURL == null) {
            addWarn("Due to missing top level configuration file, reconfiguration on change (configuration file scanning) cannot be done.");
            return;
        }
        ReconfigureOnChangeTask reconfigureOnChangeTask = new ReconfigureOnChangeTask();
        reconfigureOnChangeTask.setContext(this.context);
        this.context.putObject(CoreConstants.RECONFIGURE_ON_CHANGE_TASK, reconfigureOnChangeTask);
        Duration durationOfScanPeriodAttribute = getDurationOfScanPeriodAttribute(interpretationContext.subst(attributes.getValue("scanPeriod")), SCAN_PERIOD_DEFAULT);
        addInfo("Will scan for changes in [" + mainWatchURL + "] ");
        StringBuilder sb = new StringBuilder();
        sb.append("Setting ReconfigureOnChangeTask scanning period to ");
        sb.append(durationOfScanPeriodAttribute);
        addInfo(sb.toString());
        this.context.addScheduledFuture(scheduledExecutorService.scheduleAtFixedRate(reconfigureOnChangeTask, durationOfScanPeriodAttribute.getMilliseconds(), durationOfScanPeriodAttribute.getMilliseconds(), TimeUnit.MILLISECONDS));
    }
}
