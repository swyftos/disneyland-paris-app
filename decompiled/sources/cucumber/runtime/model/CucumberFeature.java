package cucumber.runtime.model;

import cucumber.api.event.TestSourceRead;
import cucumber.runner.EventBus;
import gherkin.ast.GherkinDocument;
import gherkin.events.PickleEvent;
import java.net.URI;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes5.dex */
public class CucumberFeature {
    private GherkinDocument gherkinDocument;
    private String gherkinSource;
    private final List pickles;
    private final URI uri;

    public CucumberFeature(GherkinDocument gherkinDocument, URI uri, String str, List<PickleEvent> list) {
        this.gherkinDocument = gherkinDocument;
        this.uri = uri;
        this.gherkinSource = str;
        this.pickles = list;
    }

    public List<PickleEvent> getPickles() {
        return this.pickles;
    }

    public String getName() {
        return this.gherkinDocument.getFeature().getName();
    }

    public GherkinDocument getGherkinFeature() {
        return this.gherkinDocument;
    }

    public URI getUri() {
        return this.uri;
    }

    public void sendTestSourceRead(EventBus eventBus) {
        eventBus.send(new TestSourceRead(eventBus.getTime(), eventBus.getTimeMillis().longValue(), getUri().toString(), this.gherkinSource));
    }

    String getSource() {
        return this.gherkinSource;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.uri.equals(((CucumberFeature) obj).uri);
    }

    public int hashCode() {
        return Objects.hash(this.uri);
    }

    public static class CucumberFeatureUriComparator implements Comparator<CucumberFeature> {
        @Override // java.util.Comparator
        public int compare(CucumberFeature cucumberFeature, CucumberFeature cucumberFeature2) {
            return cucumberFeature.getUri().compareTo(cucumberFeature2.getUri());
        }
    }
}
