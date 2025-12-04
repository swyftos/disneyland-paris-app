package cucumber.runtime.model;

import cucumber.runtime.io.Resource;
import cucumber.runtime.model.CucumberFeature;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class FeatureBuilder {
    private final Logger log = LoggerFactory.getLogger(FeatureBuilder.class);
    private final Map sourceToFeature = new HashMap();

    public List<CucumberFeature> build() {
        ArrayList arrayList = new ArrayList(this.sourceToFeature.values());
        Collections.sort(arrayList, new CucumberFeature.CucumberFeatureUriComparator());
        return arrayList;
    }

    public void parse(Resource resource) {
        CucumberFeature resource2 = FeatureParser.parseResource(resource);
        CucumberFeature cucumberFeature = (CucumberFeature) this.sourceToFeature.get(resource2.getSource());
        if (cucumberFeature != null) {
            this.log.warn("Duplicate feature ignored. " + resource2.getUri() + " was identical to " + cucumberFeature.getUri());
            return;
        }
        this.sourceToFeature.put(resource2.getSource(), resource2);
    }
}
