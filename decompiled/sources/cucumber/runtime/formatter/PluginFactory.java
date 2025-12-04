package cucumber.runtime.formatter;

import com.facebook.hermes.intl.Constants;
import cucumber.api.Plugin;
import cucumber.api.StepDefinitionReporter;
import cucumber.api.SummaryPrinter;
import cucumber.api.event.ConcurrentEventListener;
import cucumber.api.event.EventListener;
import cucumber.runtime.CucumberException;
import cucumber.runtime.Utils;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bouncycastle.i18n.ErrorBundle;

/* loaded from: classes5.dex */
public final class PluginFactory {
    private static final HashMap PLUGIN_CLASSES = new HashMap() { // from class: cucumber.runtime.formatter.PluginFactory.1
        {
            put("junit", JUnitFormatter.class);
            put("testng", TestNGFormatter.class);
            put("html", HTMLFormatter.class);
            put("pretty", PrettyFormatter.class);
            put("progress", ProgressFormatter.class);
            put("json", JSONFormatter.class);
            put(Constants.COLLATION_OPTION_USAGE, UsageFormatter.class);
            put("rerun", RerunFormatter.class);
            put("undefined", UndefinedStepsPrinter.class);
            put("default_summary", DefaultSummaryPrinter.class);
            put(ErrorBundle.SUMMARY_ENTRY, DefaultSummaryPrinter.class);
            put("null_summary", NullSummaryPrinter.class);
            put("unused", UnusedStepsSummaryPrinter.class);
            put("timeline", TimelineFormatter.class);
        }
    };
    private static final Pattern PLUGIN_WITH_ARGUMENT_PATTERN = Pattern.compile("([^:]+):(.*)");
    private final Class[] CTOR_PARAMETERS = {String.class, Appendable.class, URI.class, URL.class, File.class};
    private String defaultOutFormatter = null;
    private Appendable defaultOut = new PrintStream(System.out) { // from class: cucumber.runtime.formatter.PluginFactory.2
        @Override // java.io.PrintStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    };

    public Plugin create(String str) {
        String strGroup;
        String strGroup2;
        Matcher matcher = PLUGIN_WITH_ARGUMENT_PATTERN.matcher(str);
        if (matcher.matches()) {
            strGroup2 = matcher.group(1);
            strGroup = matcher.group(2);
        } else {
            strGroup = null;
            strGroup2 = str;
        }
        try {
            return instantiate(str, pluginClass(strGroup2), strGroup);
        } catch (IOException e) {
            throw new CucumberException(e);
        } catch (URISyntaxException e2) {
            throw new CucumberException(e2);
        }
    }

    private Plugin instantiate(String str, Class cls, String str2) throws NoSuchMethodException, SecurityException {
        Object objConvertOrNull;
        Constructor constructorFindSingleArgConstructor = findSingleArgConstructor(cls);
        Constructor constructorFindEmptyConstructor = findEmptyConstructor(cls);
        if (constructorFindSingleArgConstructor != null && (objConvertOrNull = convertOrNull(str2, constructorFindSingleArgConstructor.getParameterTypes()[0], str)) != null) {
            return newInstance(constructorFindSingleArgConstructor, objConvertOrNull);
        }
        if (str2 == null && constructorFindEmptyConstructor != null) {
            return newInstance(constructorFindEmptyConstructor, new Object[0]);
        }
        if (constructorFindSingleArgConstructor != null) {
            throw new CucumberException(String.format("You must supply an output argument to %s. Like so: %s:output", str, str));
        }
        throw new CucumberException(String.format("%s must have a constructor that is either empty or a single arg of one of: %s", cls, Arrays.asList(this.CTOR_PARAMETERS)));
    }

    private Plugin newInstance(Constructor constructor, Object... objArr) {
        try {
            return (Plugin) constructor.newInstance(objArr);
        } catch (IllegalAccessException e) {
            throw new CucumberException(e);
        } catch (InstantiationException e2) {
            throw new CucumberException(e2);
        } catch (InvocationTargetException e3) {
            throw new CucumberException(e3.getTargetException());
        }
    }

    private Object convertOrNull(String str, Class cls, String str2) {
        if (str == null) {
            if (cls.equals(Appendable.class)) {
                return defaultOutOrFailIfAlreadyUsed(str2);
            }
            return null;
        }
        if (cls.equals(URI.class)) {
            return new URI(str);
        }
        if (cls.equals(URL.class)) {
            return Utils.toURL(str);
        }
        if (cls.equals(File.class)) {
            return new File(str);
        }
        if (cls.equals(String.class)) {
            return str;
        }
        if (cls.equals(Appendable.class)) {
            return new UTF8OutputStreamWriter(new URLOutputStream(Utils.toURL(str)));
        }
        return null;
    }

    private Constructor findSingleArgConstructor(Class cls) throws NoSuchMethodException, SecurityException {
        Constructor constructor;
        Constructor constructor2 = null;
        for (Class cls2 : this.CTOR_PARAMETERS) {
            try {
                constructor = cls.getConstructor(cls2);
            } catch (NoSuchMethodException unused) {
            }
            if (constructor2 != null) {
                throw new CucumberException(String.format("Plugin %s should only define a single one-argument constructor", cls.getName()));
            }
            constructor2 = constructor;
        }
        return constructor2;
    }

    private Constructor findEmptyConstructor(Class cls) {
        try {
            return cls.getConstructor(new Class[0]);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static Class pluginClass(String str) {
        Class cls = (Class) PLUGIN_CLASSES.get(str);
        return cls == null ? loadClass(str) : cls;
    }

    private static Class loadClass(String str) throws ClassNotFoundException {
        try {
            Class<?> clsLoadClass = Thread.currentThread().getContextClassLoader().loadClass(str);
            if (Plugin.class.isAssignableFrom(clsLoadClass)) {
                return clsLoadClass;
            }
            throw new CucumberException("Couldn't load plugin class: " + str + ". It does not implement " + Plugin.class.getName());
        } catch (ClassNotFoundException e) {
            throw new CucumberException("Couldn't load plugin class: " + str, e);
        }
    }

    private Appendable defaultOutOrFailIfAlreadyUsed(String str) {
        try {
            Appendable appendable = this.defaultOut;
            if (appendable != null) {
                this.defaultOutFormatter = str;
                return appendable;
            }
            throw new CucumberException("Only one formatter can use STDOUT, now both " + this.defaultOutFormatter + " and " + str + " use it. If you use more than one formatter you must specify output path with PLUGIN:PATH_OR_URL");
        } finally {
            this.defaultOut = null;
        }
    }

    public static boolean isFormatterName(String str) {
        Class pluginClass = getPluginClass(str);
        return EventListener.class.isAssignableFrom(pluginClass) || ConcurrentEventListener.class.isAssignableFrom(pluginClass);
    }

    public static boolean isStepDefinitionReporterName(String str) {
        return StepDefinitionReporter.class.isAssignableFrom(getPluginClass(str));
    }

    public static boolean isSummaryPrinterName(String str) {
        return SummaryPrinter.class.isAssignableFrom(getPluginClass(str));
    }

    private static Class getPluginClass(String str) {
        Matcher matcher = PLUGIN_WITH_ARGUMENT_PATTERN.matcher(str);
        if (matcher.matches()) {
            str = matcher.group(1);
        }
        return pluginClass(str);
    }
}
