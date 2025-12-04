package io.cucumber.core.model;

import cucumber.runtime.CucumberException;
import cucumber.runtime.io.Resource;
import cucumber.runtime.io.ResourceLoader;
import cucumber.util.FixJava;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class RerunLoader {
    private static final Pattern RERUN_PATH_SPECIFICATION = Pattern.compile("(?m:^| |)(.*?\\.feature(?:(?::\\d+)*))");
    private final ResourceLoader resourceLoader;

    public RerunLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public List<FeatureWithLines> load(URI uri) {
        Iterable<Resource> iterableResources = this.resourceLoader.resources(uri, null);
        if (!iterableResources.iterator().hasNext()) {
            throw new CucumberException("Rerun file did not exist: " + uri);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Resource> it = iterableResources.iterator();
        while (it.hasNext()) {
            String str = read(it.next());
            if (!str.isEmpty()) {
                Matcher matcher = RERUN_PATH_SPECIFICATION.matcher(str);
                while (matcher.find()) {
                    arrayList.add(FeatureWithLines.parse(matcher.group(1)));
                }
            }
        }
        return arrayList;
    }

    private static String read(Resource resource) {
        try {
            return FixJava.readReader(new InputStreamReader(resource.getInputStream()));
        } catch (IOException e) {
            throw new CucumberException("Failed to read resource:" + resource.getPath(), e);
        }
    }
}
