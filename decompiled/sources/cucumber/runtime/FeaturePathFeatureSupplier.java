package cucumber.runtime;

import cucumber.runtime.model.CucumberFeature;
import cucumber.runtime.model.FeatureLoader;
import cucumber.util.FixJava;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.core.options.FeatureOptions;
import java.net.URI;
import java.util.List;

/* loaded from: classes5.dex */
public class FeaturePathFeatureSupplier implements FeatureSupplier {
    private static final Logger log = LoggerFactory.getLogger(FeaturePathFeatureSupplier.class);
    private final FeatureLoader featureLoader;
    private final FeatureOptions featureOptions;

    public FeaturePathFeatureSupplier(FeatureLoader featureLoader, FeatureOptions featureOptions) {
        this.featureLoader = featureLoader;
        this.featureOptions = featureOptions;
    }

    @Override // cucumber.runtime.FeatureSupplier
    public List<CucumberFeature> get() {
        List<URI> featurePaths = this.featureOptions.getFeaturePaths();
        Logger logger = log;
        logger.debug("Loading features from " + FixJava.join(featurePaths, ", "));
        List<CucumberFeature> listLoad = this.featureLoader.load(featurePaths);
        if (listLoad.isEmpty()) {
            if (featurePaths.isEmpty()) {
                logger.warn("Got no path to feature directory or feature file");
            } else {
                logger.warn("No features found at " + FixJava.join(featurePaths, ", "));
            }
        }
        return listLoad;
    }
}
