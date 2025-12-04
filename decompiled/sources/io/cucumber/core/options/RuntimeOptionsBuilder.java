package io.cucumber.core.options;

import cucumber.api.SnippetType;
import cucumber.runtime.CucumberException;
import cucumber.runtime.formatter.PluginFactory;
import cucumber.runtime.order.PickleOrder;
import io.cucumber.core.model.FeatureWithLines;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public final class RuntimeOptionsBuilder {
    private List parsedTagFilters = new ArrayList();
    private List parsedNameFilters = new ArrayList();
    private List parsedFeaturePaths = new ArrayList();
    private List parsedGlue = new ArrayList();
    private ParsedPluginData parsedPluginData = new ParsedPluginData();
    private List parsedRerunPaths = null;
    private List parsedJunitOptions = new ArrayList();
    private Integer parsedThreads = null;
    private Boolean parsedDryRun = null;
    private Boolean parsedStrict = null;
    private Boolean parsedMonochrome = null;
    private SnippetType parsedSnippetType = null;
    private Boolean parsedWip = null;
    private PickleOrder parsedPickleOrder = null;
    private Integer parsedCount = null;

    public RuntimeOptionsBuilder addRerun(Collection<FeatureWithLines> collection) {
        if (this.parsedRerunPaths == null) {
            this.parsedRerunPaths = new ArrayList();
        }
        this.parsedRerunPaths.addAll(collection);
        return this;
    }

    public RuntimeOptionsBuilder addFeature(FeatureWithLines featureWithLines) {
        this.parsedFeaturePaths.add(featureWithLines);
        return this;
    }

    public RuntimeOptionsBuilder addGlue(URI uri) {
        this.parsedGlue.add(uri);
        return this;
    }

    public RuntimeOptionsBuilder addJunitOption(String str) {
        this.parsedJunitOptions.add(str);
        return this;
    }

    public RuntimeOptionsBuilder addNameFilter(Pattern pattern) {
        this.parsedNameFilters.add(pattern);
        return this;
    }

    public RuntimeOptionsBuilder addPluginName(String str, boolean z) {
        this.parsedPluginData.addPluginName(str, z);
        return this;
    }

    public RuntimeOptionsBuilder addTagFilter(String str) {
        this.parsedTagFilters.add(str);
        return this;
    }

    public RuntimeOptions build() {
        return build(RuntimeOptions.defaultOptions());
    }

    public RuntimeOptions build(RuntimeOptions runtimeOptions) {
        Integer num = this.parsedThreads;
        if (num != null) {
            runtimeOptions.setThreads(num.intValue());
        }
        Boolean bool = this.parsedDryRun;
        if (bool != null) {
            runtimeOptions.setDryRun(bool.booleanValue());
        }
        Boolean bool2 = this.parsedStrict;
        if (bool2 != null) {
            runtimeOptions.setStrict(bool2.booleanValue());
        }
        Boolean bool3 = this.parsedMonochrome;
        if (bool3 != null) {
            runtimeOptions.setMonochrome(bool3.booleanValue());
        }
        SnippetType snippetType = this.parsedSnippetType;
        if (snippetType != null) {
            runtimeOptions.setSnippetType(snippetType);
        }
        Boolean bool4 = this.parsedWip;
        if (bool4 != null) {
            runtimeOptions.setWip(bool4.booleanValue());
        }
        PickleOrder pickleOrder = this.parsedPickleOrder;
        if (pickleOrder != null) {
            runtimeOptions.setPickleOrder(pickleOrder);
        }
        Integer num2 = this.parsedCount;
        if (num2 != null) {
            runtimeOptions.setCount(num2.intValue());
        }
        if (!this.parsedTagFilters.isEmpty() || !this.parsedNameFilters.isEmpty() || hasFeaturesWithLineFilters()) {
            runtimeOptions.setTagFilters(this.parsedTagFilters);
            runtimeOptions.setNameFilters(this.parsedNameFilters);
        }
        if (!this.parsedFeaturePaths.isEmpty() || this.parsedRerunPaths != null) {
            ArrayList arrayList = new ArrayList(this.parsedFeaturePaths);
            List list = this.parsedRerunPaths;
            if (list != null) {
                arrayList.addAll(list);
            }
            runtimeOptions.setFeaturePaths(arrayList);
        }
        if (!this.parsedGlue.isEmpty()) {
            runtimeOptions.setGlue(this.parsedGlue);
        }
        if (!this.parsedJunitOptions.isEmpty()) {
            runtimeOptions.setJunitOptions(this.parsedJunitOptions);
        }
        this.parsedPluginData.updatePluginFormatterNames(runtimeOptions.getPluginFormatterNames());
        this.parsedPluginData.updatePluginStepDefinitionReporterNames(runtimeOptions.getPluginStepDefinitionReporterNames());
        this.parsedPluginData.updatePluginSummaryPrinterNames(runtimeOptions.getPluginSummaryPrinterNames());
        return runtimeOptions;
    }

    private boolean hasFeaturesWithLineFilters() {
        if (this.parsedRerunPaths != null) {
            return true;
        }
        Iterator it = this.parsedFeaturePaths.iterator();
        while (it.hasNext()) {
            if (!((FeatureWithLines) it.next()).lines().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public RuntimeOptionsBuilder setCount(int i) {
        this.parsedCount = Integer.valueOf(i);
        return this;
    }

    public RuntimeOptionsBuilder setDryRun(boolean z) {
        this.parsedDryRun = Boolean.valueOf(z);
        return this;
    }

    public RuntimeOptionsBuilder setDryRun() {
        return setDryRun(true);
    }

    public RuntimeOptionsBuilder setMonochrome(boolean z) {
        this.parsedMonochrome = Boolean.valueOf(z);
        return this;
    }

    public RuntimeOptionsBuilder setMonochrome() {
        return setMonochrome(true);
    }

    public RuntimeOptionsBuilder setPickleOrder(PickleOrder pickleOrder) {
        this.parsedPickleOrder = pickleOrder;
        return this;
    }

    public RuntimeOptionsBuilder setSnippetType(SnippetType snippetType) {
        this.parsedSnippetType = snippetType;
        return this;
    }

    public RuntimeOptionsBuilder setStrict() {
        return setStrict(true);
    }

    public RuntimeOptionsBuilder setStrict(boolean z) {
        this.parsedStrict = Boolean.valueOf(z);
        return this;
    }

    public RuntimeOptionsBuilder setThreads(int i) {
        this.parsedThreads = Integer.valueOf(i);
        return this;
    }

    public RuntimeOptionsBuilder setWip(boolean z) {
        this.parsedWip = Boolean.valueOf(z);
        return this;
    }

    public RuntimeOptionsBuilder addDefaultSummaryPrinterIfNotPresent() {
        this.parsedPluginData.addDefaultSummaryPrinterIfNotPresent();
        return this;
    }

    public RuntimeOptionsBuilder addDefaultFormatterIfNotPresent() {
        this.parsedPluginData.addDefaultFormatterIfNotPresent();
        return this;
    }

    private static class ParsedPluginData {
        ParsedOptionNames formatterNames;
        ParsedOptionNames stepDefinitionReporterNames;
        ParsedOptionNames summaryPrinterNames;

        private ParsedPluginData() {
            this.formatterNames = new ParsedOptionNames();
            this.stepDefinitionReporterNames = new ParsedOptionNames();
            this.summaryPrinterNames = new ParsedOptionNames();
        }

        void addPluginName(String str, boolean z) {
            if (PluginFactory.isStepDefinitionReporterName(str)) {
                this.stepDefinitionReporterNames.addName(str, z);
                return;
            }
            if (PluginFactory.isSummaryPrinterName(str)) {
                this.summaryPrinterNames.addName(str, z);
            } else {
                if (PluginFactory.isFormatterName(str)) {
                    this.formatterNames.addName(str, z);
                    return;
                }
                throw new CucumberException("Unrecognized plugin: " + str);
            }
        }

        void updatePluginFormatterNames(List list) {
            this.formatterNames.updateNameList(list);
        }

        void updatePluginStepDefinitionReporterNames(List list) {
            this.stepDefinitionReporterNames.updateNameList(list);
        }

        void updatePluginSummaryPrinterNames(List list) {
            this.summaryPrinterNames.updateNameList(list);
        }

        void addDefaultSummaryPrinterIfNotPresent() {
            if (this.summaryPrinterNames.names.isEmpty()) {
                this.summaryPrinterNames.addName("default_summary", false);
            }
        }

        void addDefaultFormatterIfNotPresent() {
            if (this.formatterNames.names.isEmpty()) {
                this.formatterNames.addName("progress", false);
            }
        }
    }

    private static class ParsedOptionNames {
        private boolean clobber;
        private List names;

        private ParsedOptionNames() {
            this.names = new ArrayList();
            this.clobber = false;
        }

        void addName(String str, boolean z) {
            this.names.add(str);
            if (z) {
                return;
            }
            this.clobber = true;
        }

        void updateNameList(List list) {
            if (this.names.isEmpty()) {
                return;
            }
            if (this.clobber) {
                list.clear();
            }
            list.addAll(this.names);
        }
    }
}
