package io.cucumber.core.options;

import cucumber.api.SnippetType;
import cucumber.runtime.order.PickleOrder;
import cucumber.runtime.order.StandardPickleOrders;
import io.cucumber.core.model.FeatureWithLines;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public final class RuntimeOptions implements FeatureOptions, FilterOptions, PluginOptions, RunnerOptions {
    private boolean dryRun;
    private final List glue = new ArrayList();
    private final List tagFilters = new ArrayList();
    private final List nameFilters = new ArrayList();
    private final List featurePaths = new ArrayList();
    private final List junitOptions = new ArrayList();
    private boolean strict = false;
    private boolean monochrome = false;
    private boolean wip = false;
    private SnippetType snippetType = SnippetType.UNDERSCORE;
    private int threads = 1;
    private PickleOrder pickleOrder = StandardPickleOrders.lexicalUriOrder();
    private int count = 0;
    private final List pluginFormatterNames = new ArrayList();
    private final List pluginStepDefinitionReporterNames = new ArrayList();
    private final List pluginSummaryPrinterNames = new ArrayList();

    private RuntimeOptions() {
    }

    public static RuntimeOptions defaultOptions() {
        return new RuntimeOptions();
    }

    public void addUndefinedStepsPrinterIfSummaryNotDefined() {
        if (this.pluginSummaryPrinterNames.isEmpty()) {
            this.pluginSummaryPrinterNames.add("undefined");
        }
    }

    public int getCount() {
        return this.count;
    }

    List getPluginFormatterNames() {
        return this.pluginFormatterNames;
    }

    List getPluginStepDefinitionReporterNames() {
        return this.pluginStepDefinitionReporterNames;
    }

    List getPluginSummaryPrinterNames() {
        return this.pluginSummaryPrinterNames;
    }

    public boolean isMultiThreaded() {
        return getThreads() > 1;
    }

    @Override // io.cucumber.core.options.PluginOptions
    public List<String> getPluginNames() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getPluginFormatterNames());
        arrayList.addAll(getPluginStepDefinitionReporterNames());
        arrayList.addAll(getPluginSummaryPrinterNames());
        return arrayList;
    }

    @Override // io.cucumber.core.options.RunnerOptions
    public List<URI> getGlue() {
        return Collections.unmodifiableList(this.glue);
    }

    @Override // io.cucumber.core.options.PluginOptions
    public boolean isStrict() {
        return this.strict;
    }

    @Override // io.cucumber.core.options.RunnerOptions
    public boolean isDryRun() {
        return this.dryRun;
    }

    public boolean isWip() {
        return this.wip;
    }

    @Override // io.cucumber.core.options.FeatureOptions
    public List<URI> getFeaturePaths() {
        HashSet hashSet = new HashSet();
        Iterator it = this.featurePaths.iterator();
        while (it.hasNext()) {
            hashSet.add(((FeatureWithLines) it.next()).uri());
        }
        ArrayList arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    @Override // io.cucumber.core.options.FilterOptions
    public List<Pattern> getNameFilters() {
        return Collections.unmodifiableList(this.nameFilters);
    }

    @Override // io.cucumber.core.options.FilterOptions
    public List<String> getTagFilters() {
        return Collections.unmodifiableList(this.tagFilters);
    }

    void setCount(int i) {
        this.count = i;
    }

    void setFeaturePaths(List list) {
        this.featurePaths.clear();
        this.featurePaths.addAll(list);
    }

    void setGlue(List list) {
        this.glue.clear();
        this.glue.addAll(list);
    }

    void setJunitOptions(List list) {
        this.junitOptions.clear();
        this.junitOptions.addAll(list);
    }

    void setNameFilters(List list) {
        this.nameFilters.clear();
        this.nameFilters.addAll(list);
    }

    void setPickleOrder(PickleOrder pickleOrder) {
        this.pickleOrder = pickleOrder;
    }

    void setTagFilters(List list) {
        this.tagFilters.clear();
        this.tagFilters.addAll(list);
    }

    @Override // io.cucumber.core.options.FilterOptions
    public Map<URI, Set<Integer>> getLineFilters() {
        HashMap map = new HashMap();
        for (FeatureWithLines featureWithLines : this.featurePaths) {
            SortedSet<Integer> sortedSetLines = featureWithLines.lines();
            URI uri = featureWithLines.uri();
            if (!sortedSetLines.isEmpty()) {
                if (!map.containsKey(uri)) {
                    map.put(uri, new TreeSet());
                }
                ((Set) map.get(uri)).addAll(sortedSetLines);
            }
        }
        return Collections.unmodifiableMap(map);
    }

    @Override // io.cucumber.core.options.FilterOptions
    public int getLimitCount() {
        return getCount();
    }

    @Override // io.cucumber.core.options.PluginOptions
    public boolean isMonochrome() {
        return this.monochrome;
    }

    @Override // io.cucumber.core.options.RunnerOptions
    public SnippetType getSnippetType() {
        return this.snippetType;
    }

    public List<String> getJunitOptions() {
        return Collections.unmodifiableList(this.junitOptions);
    }

    public int getThreads() {
        return this.threads;
    }

    public PickleOrder getPickleOrder() {
        return this.pickleOrder;
    }

    void setDryRun(boolean z) {
        this.dryRun = z;
    }

    void setMonochrome(boolean z) {
        this.monochrome = z;
    }

    void setSnippetType(SnippetType snippetType) {
        this.snippetType = snippetType;
    }

    void setStrict(boolean z) {
        this.strict = z;
    }

    void setThreads(int i) {
        this.threads = i;
    }

    void setWip(boolean z) {
        this.wip = z;
    }
}
