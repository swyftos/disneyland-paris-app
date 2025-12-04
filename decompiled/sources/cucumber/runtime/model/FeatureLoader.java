package cucumber.runtime.model;

import cucumber.runtime.io.Resource;
import cucumber.runtime.io.ResourceLoader;
import io.cucumber.core.model.FeatureIdentifier;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class FeatureLoader {
    private final ResourceLoader resourceLoader;

    public FeatureLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public List<CucumberFeature> load(List<URI> list) {
        FeatureBuilder featureBuilder = new FeatureBuilder();
        Iterator<URI> it = list.iterator();
        while (it.hasNext()) {
            loadFromFeaturePath(featureBuilder, it.next());
        }
        return featureBuilder.build();
    }

    private void loadFromFeaturePath(FeatureBuilder featureBuilder, URI uri) {
        Iterator<Resource> it = this.resourceLoader.resources(uri, ".feature").iterator();
        if (FeatureIdentifier.isFeature(uri) && !it.hasNext()) {
            throw new IllegalArgumentException("Feature not found: " + uri);
        }
        while (it.hasNext()) {
            featureBuilder.parse(it.next());
        }
    }
}
