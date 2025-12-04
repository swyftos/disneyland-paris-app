package ch.qos.logback.core.joran;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.event.SaxEvent;
import ch.qos.logback.core.joran.event.SaxEventRecorder;
import ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import ch.qos.logback.core.joran.spi.ElementPath;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.joran.spi.Interpreter;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.joran.spi.RuleStore;
import ch.qos.logback.core.joran.spi.SimpleRuleStore;
import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.status.StatusUtil;
import ch.qos.logback.core.util.CloseUtil;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* loaded from: classes2.dex */
public abstract class GenericConfigurator extends ContextAwareBase {
    protected Interpreter interpreter;

    private final void doConfigure(InputSource inputSource) throws SAXException, JoranException, IOException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        SaxEventRecorder saxEventRecorder = new SaxEventRecorder(this.context);
        saxEventRecorder.recordEvents(inputSource);
        doConfigure(saxEventRecorder.getSaxEventList());
        if (new StatusUtil(this.context).noXMLParsingErrorsOccurred(jCurrentTimeMillis)) {
            addInfo("Registering current configuration as safe fallback point");
            registerSafeConfiguration(saxEventRecorder.getSaxEventList());
        }
    }

    public static void informContextOfURLUsedForConfiguration(Context context, URL url) {
        ConfigurationWatchListUtil.setMainWatchURL(context, url);
    }

    protected void addDefaultNestedComponentRegistryRules(DefaultNestedComponentRegistry defaultNestedComponentRegistry) {
    }

    protected abstract void addImplicitRules(Interpreter interpreter);

    protected abstract void addInstanceRules(RuleStore ruleStore);

    protected void buildInterpreter() {
        SimpleRuleStore simpleRuleStore = new SimpleRuleStore(this.context);
        addInstanceRules(simpleRuleStore);
        Interpreter interpreter = new Interpreter(this.context, simpleRuleStore, initialElementPath());
        this.interpreter = interpreter;
        InterpretationContext interpretationContext = interpreter.getInterpretationContext();
        interpretationContext.setContext(this.context);
        addImplicitRules(this.interpreter);
        addDefaultNestedComponentRegistryRules(interpretationContext.getDefaultNestedComponentRegistry());
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0021: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:8:0x0021 */
    public final void doConfigure(File file) throws Throwable {
        IOException e;
        Closeable closeable;
        URL url;
        FileInputStream fileInputStream;
        Closeable closeable2 = null;
        try {
            try {
                url = file.toURI().toURL();
                informContextOfURLUsedForConfiguration(getContext(), url);
                fileInputStream = new FileInputStream(file);
            } catch (IOException e2) {
                e = e2;
            } catch (Throwable th) {
                th = th;
                CloseUtil.closeQuietly(closeable2);
                throw th;
            }
            try {
                doConfigure(fileInputStream, url.toExternalForm());
                CloseUtil.closeQuietly(fileInputStream);
            } catch (IOException e3) {
                e = e3;
                String str = "Could not open [" + file.getPath() + "].";
                addError(str, e);
                throw new JoranException(str, e);
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            CloseUtil.closeQuietly(closeable2);
            throw th;
        }
    }

    public final void doConfigure(InputStream inputStream) throws JoranException, IOException {
        try {
            doConfigure(new InputSource(inputStream));
            try {
                inputStream.close();
            } catch (IOException e) {
                addError("Could not close the stream", e);
                throw new JoranException("Could not close the stream", e);
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
                throw th;
            } catch (IOException e2) {
                addError("Could not close the stream", e2);
                throw new JoranException("Could not close the stream", e2);
            }
        }
    }

    public final void doConfigure(InputStream inputStream, String str) throws SAXException, JoranException, IOException {
        InputSource inputSource = new InputSource(inputStream);
        inputSource.setSystemId(str);
        doConfigure(inputSource);
    }

    public final void doConfigure(String str) throws Throwable {
        doConfigure(new File(str));
    }

    public final void doConfigure(URL url) throws JoranException, IOException {
        InputStream inputStream = null;
        try {
            try {
                informContextOfURLUsedForConfiguration(getContext(), url);
                URLConnection uRLConnectionOpenConnection = url.openConnection();
                uRLConnectionOpenConnection.setUseCaches(false);
                inputStream = InstrumentationCallbacks.getInputStream(uRLConnectionOpenConnection);
                doConfigure(inputStream, url.toExternalForm());
            } catch (IOException e) {
                String str = "Could not open URL [" + url + "].";
                addError(str, e);
                throw new JoranException(str, e);
            }
        } finally {
            CloseUtil.closeQuietly(inputStream);
        }
    }

    public void doConfigure(List<SaxEvent> list) throws JoranException {
        buildInterpreter();
        synchronized (this.context.getConfigurationLock()) {
            this.interpreter.getEventPlayer().play(list);
        }
    }

    protected ElementPath initialElementPath() {
        return new ElementPath();
    }

    public List<SaxEvent> recallSafeConfiguration() {
        return (List) this.context.getObject(CoreConstants.SAFE_JORAN_CONFIGURATION);
    }

    public void registerSafeConfiguration(List<SaxEvent> list) {
        this.context.putObject(CoreConstants.SAFE_JORAN_CONFIGURATION, list);
    }
}
