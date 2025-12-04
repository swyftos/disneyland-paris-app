package io.cucumber.junit;

import android.app.Instrumentation;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.test.platform.app.InstrumentationRegistry;
import cucumber.api.event.TestRunFinished;
import cucumber.api.event.TestRunStarted;
import cucumber.runner.EventBus;
import cucumber.runner.Runner;
import cucumber.runner.ThreadLocalRunnerSupplier;
import cucumber.runner.TimeService;
import cucumber.runner.TimeServiceEventBus;
import cucumber.runtime.ClassFinder;
import cucumber.runtime.CucumberException;
import cucumber.runtime.FeaturePathFeatureSupplier;
import cucumber.runtime.UndefinedStepsTracker;
import cucumber.runtime.Utils;
import cucumber.runtime.filter.Filters;
import cucumber.runtime.formatter.PluginFactory;
import cucumber.runtime.formatter.Plugins;
import cucumber.runtime.formatter.Stats;
import cucumber.runtime.java.AndroidJavaBackendFactory;
import cucumber.runtime.model.CucumberFeature;
import cucumber.runtime.model.FeatureLoader;
import dalvik.system.DexFile;
import gherkin.GherkinLanguageConstants;
import gherkin.ast.Examples;
import gherkin.ast.Feature;
import gherkin.ast.ScenarioDefinition;
import gherkin.ast.ScenarioOutline;
import gherkin.ast.TableRow;
import gherkin.events.PickleEvent;
import io.cucumber.core.options.RuntimeOptions;
import io.cucumber.junit.AndroidJunitRuntimeOptionsFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

/* loaded from: classes5.dex */
public class CucumberJUnitRunner extends ParentRunner<AndroidFeatureRunner> implements Filterable {
    private EventBus bus;
    private List children;

    public CucumberJUnitRunner(Class<?> cls) throws InitializationError {
        String str;
        String str2;
        String str3;
        Filters filters;
        HashSet hashSet;
        ArrayList arrayList;
        super(cls);
        this.children = new ArrayList();
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        Bundle runnerBundle = getRunnerBundle(instrumentation);
        trySetCucumberOptionsToSystemProperties(new Arguments(runnerBundle));
        Context context = instrumentation.getContext();
        ClassLoader classLoader = context.getClassLoader();
        ClassFinder classFinderCreateDexClassFinder = createDexClassFinder(context);
        AndroidJunitRuntimeOptionsFactory.Options optionsCreateRuntimeOptions = AndroidJunitRuntimeOptionsFactory.createRuntimeOptions(context, classFinderCreateDexClassFinder, classLoader);
        TimeServiceEventBus timeServiceEventBus = new TimeServiceEventBus(TimeService.SYSTEM);
        this.bus = timeServiceEventBus;
        RuntimeOptions runtimeOptions = optionsCreateRuntimeOptions.runtimeOptions;
        Runner runner = new ThreadLocalRunnerSupplier(runtimeOptions, timeServiceEventBus, AndroidJavaBackendFactory.createBackend(runtimeOptions, classFinderCreateDexClassFinder)).get();
        FeaturePathFeatureSupplier featurePathFeatureSupplier = new FeaturePathFeatureSupplier(new FeatureLoader(new AndroidResourceLoader(context)), optionsCreateRuntimeOptions.runtimeOptions);
        Filters filters2 = new Filters(optionsCreateRuntimeOptions.runtimeOptions);
        UndefinedStepsTracker undefinedStepsTracker = new UndefinedStepsTracker();
        undefinedStepsTracker.setEventPublisher(this.bus);
        Stats stats = new Stats();
        stats.setEventPublisher(this.bus);
        Plugins plugins = new Plugins(classLoader, new PluginFactory(), optionsCreateRuntimeOptions.runtimeOptions);
        plugins.addPlugin(new AndroidLogcatReporter(stats, undefinedStepsTracker, "cucumber-android"));
        if (optionsCreateRuntimeOptions.runtimeOptions.isMultiThreaded()) {
            plugins.setSerialEventBusOnEventListenerPlugins(this.bus);
        } else {
            plugins.setEventBusOnEventListenerPlugins(this.bus);
        }
        String string = runnerBundle.getString("cucumberAndroidTestClass");
        if (string != null) {
            String[] strArrSplit = string.split(GherkinLanguageConstants.COMMENT_PREFIX);
            if (strArrSplit.length > 1) {
                str2 = strArrSplit[0];
                str = strArrSplit[1];
            } else {
                Log.e("cucumber-android", "CucumberJUnitRunner: invalid argument 'cucumberAndroidTestClass' = '" + string + "'");
                str = null;
                str2 = null;
            }
        } else {
            str = null;
            str2 = null;
        }
        List<CucumberFeature> list = featurePathFeatureSupplier.get();
        HashSet hashSet2 = new HashSet(list.size());
        StringBuilder sb = new StringBuilder();
        EventBus eventBus = this.bus;
        eventBus.send(new TestRunStarted(eventBus.getTime(), this.bus.getTimeMillis().longValue()));
        for (CucumberFeature cucumberFeature : list) {
            cucumberFeature.sendTestSourceRead(this.bus);
            String name = cucumberFeature.getName();
            if (str2 == null || str2.equals(name)) {
                List<PickleEvent> pickles = cucumberFeature.getPickles();
                ArrayList arrayList2 = new ArrayList(pickles.size());
                HashSet hashSet3 = new HashSet(pickles.size());
                for (PickleEvent pickleEvent : pickles) {
                    if (filters2.matchesFilters(pickleEvent)) {
                        String scenarioName = getScenarioName(pickleEvent, cucumberFeature.getGherkinFeature().getFeature());
                        if (hashSet3.contains(scenarioName)) {
                            addDuplicateScenarioMessage(sb, name, scenarioName);
                        }
                        hashSet3.add(scenarioName);
                        if (str != null) {
                            if (str.equals(scenarioName)) {
                                ArrayList arrayList3 = arrayList2;
                                arrayList3.add(new AndroidPickleRunner(runner, pickleEvent, optionsCreateRuntimeOptions.jUnitOptions, cucumberFeature, scenarioName));
                                this.children.add(new AndroidFeatureRunner(cls, cucumberFeature, arrayList3));
                                throwErrorIfDuplicateScenarios(sb);
                                return;
                            }
                            str3 = name;
                            filters = filters2;
                            arrayList = arrayList2;
                            hashSet = hashSet3;
                        } else {
                            str3 = name;
                            filters = filters2;
                            arrayList = arrayList2;
                            hashSet = hashSet3;
                            arrayList.add(new AndroidPickleRunner(runner, pickleEvent, optionsCreateRuntimeOptions.jUnitOptions, cucumberFeature, scenarioName));
                        }
                    } else {
                        str3 = name;
                        filters = filters2;
                        hashSet = hashSet3;
                        arrayList = arrayList2;
                    }
                    arrayList2 = arrayList;
                    hashSet3 = hashSet;
                    name = str3;
                    filters2 = filters;
                }
                StringBuilder sb2 = sb;
                addFeatureIfHasChildren(cls, hashSet2, sb2, cucumberFeature, name, arrayList2);
                filters2 = filters2;
                str2 = str2;
                sb = sb2;
                hashSet2 = hashSet2;
                str = str;
            }
        }
        throwErrorIfDuplicateScenarios(sb);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Bundle getRunnerBundle(Instrumentation instrumentation) throws InitializationError {
        if (!(instrumentation instanceof CucumberArgumentsProvider)) {
            Log.e("cucumber-android", "Runner must implement CucumberArgumentsProvider");
            throw new InitializationError("Use runner that implements CucumberArgumentsProvider class.");
        }
        return ((CucumberArgumentsProvider) instrumentation).getArguments().getRunnerArgs();
    }

    private void addFeatureIfHasChildren(Class cls, Collection collection, StringBuilder sb, CucumberFeature cucumberFeature, String str, List list) {
        if (list.isEmpty()) {
            return;
        }
        if (collection.contains(str)) {
            addDuplicateFeatureMessage(sb, str);
        }
        collection.add(str);
        this.children.add(new AndroidFeatureRunner(cls, cucumberFeature, list));
    }

    private static void throwErrorIfDuplicateScenarios(CharSequence charSequence) throws InitializationError {
        if (charSequence.length() <= 0) {
            return;
        }
        InitializationError initializationError = new InitializationError(charSequence.toString());
        Log.e("cucumber-android", "CucumberJUnitRunner: ", initializationError);
        throw initializationError;
    }

    private static void addDuplicateFeatureMessage(StringBuilder sb, String str) {
        sb.append('\n');
        sb.append("Duplicate feature name '");
        sb.append(str);
        sb.append("'");
    }

    private static void addDuplicateScenarioMessage(StringBuilder sb, String str, String str2) {
        sb.append('\n');
        sb.append("Duplicate scenario name '");
        sb.append(str2);
        sb.append("' in feature '");
        sb.append(str);
        sb.append("'");
    }

    private static String getScenarioName(PickleEvent pickleEvent, Feature feature) {
        int iFindExampleNumber = findExampleNumber(pickleEvent, feature);
        String name = pickleEvent.pickle.getName();
        return iFindExampleNumber > 0 ? Utils.getUniqueTestNameForScenarioExample(name, iFindExampleNumber) : name;
    }

    private static int findExampleNumber(PickleEvent pickleEvent, Feature feature) {
        int line = getLine(pickleEvent);
        Iterator<ScenarioDefinition> it = feature.getChildren().iterator();
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                return 0;
            }
            ScenarioDefinition next = it.next();
            if (next instanceof ScenarioOutline) {
                Iterator<Examples> it2 = ((ScenarioOutline) next).getExamples().iterator();
                while (it2.hasNext()) {
                    Iterator<TableRow> it3 = it2.next().getTableBody().iterator();
                    while (it3.hasNext()) {
                        if (it3.next().getLocation().getLine() == line) {
                            return i + 1;
                        }
                        i++;
                    }
                }
            }
        }
    }

    private static int getLine(PickleEvent pickleEvent) {
        return pickleEvent.pickle.getLocations().get(0).getLine();
    }

    @Override // org.junit.runners.ParentRunner
    protected List<AndroidFeatureRunner> getChildren() {
        return this.children;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.ParentRunner
    public Description describeChild(AndroidFeatureRunner androidFeatureRunner) {
        return androidFeatureRunner.getDescription();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.ParentRunner
    public void runChild(AndroidFeatureRunner androidFeatureRunner, RunNotifier runNotifier) {
        androidFeatureRunner.run(runNotifier);
    }

    private static void trySetCucumberOptionsToSystemProperties(Arguments arguments) {
        String cucumberOptions = arguments.getCucumberOptions();
        if (cucumberOptions.isEmpty()) {
            return;
        }
        Log.d("cucumber-android", "Setting cucumber.options from arguments: '" + cucumberOptions + "'");
        System.setProperty("cucumber.options", cucumberOptions);
    }

    private static ClassFinder createDexClassFinder(Context context) {
        return new DexClassFinder(newDexFile(context.getPackageCodePath()));
    }

    private static DexFile newDexFile(String str) {
        try {
            return new DexFile(str);
        } catch (IOException unused) {
            throw new CucumberException("Failed to open " + str);
        }
    }

    @Override // org.junit.runners.ParentRunner
    protected Statement childrenInvoker(RunNotifier runNotifier) {
        final Statement statementChildrenInvoker = super.childrenInvoker(runNotifier);
        return new Statement() { // from class: io.cucumber.junit.CucumberJUnitRunner.1
            @Override // org.junit.runners.model.Statement
            public void evaluate() throws Throwable {
                statementChildrenInvoker.evaluate();
                CucumberJUnitRunner.this.bus.send(new TestRunFinished(CucumberJUnitRunner.this.bus.getTime(), CucumberJUnitRunner.this.bus.getTimeMillis().longValue()));
            }
        };
    }
}
