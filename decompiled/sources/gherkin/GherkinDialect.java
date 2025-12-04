package gherkin;

import com.facebook.react.modules.appstate.AppStateModule;
import com.urbanairship.json.JsonPredicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class GherkinDialect {
    private final Map keywords;
    private String language;

    public GherkinDialect(String str, Map<String, List<String>> map) {
        this.language = str;
        this.keywords = map;
    }

    public List<String> getFeatureKeywords() {
        return (List) this.keywords.get("feature");
    }

    public List<String> getScenarioKeywords() {
        return (List) this.keywords.get("scenario");
    }

    public List<String> getStepKeywords() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getGivenKeywords());
        arrayList.addAll(getWhenKeywords());
        arrayList.addAll(getThenKeywords());
        arrayList.addAll(getAndKeywords());
        arrayList.addAll(getButKeywords());
        return arrayList;
    }

    public List<String> getBackgroundKeywords() {
        return (List) this.keywords.get(AppStateModule.APP_STATE_BACKGROUND);
    }

    public List<String> getScenarioOutlineKeywords() {
        return (List) this.keywords.get("scenarioOutline");
    }

    public List<String> getExamplesKeywords() {
        return (List) this.keywords.get("examples");
    }

    public List<String> getGivenKeywords() {
        return (List) this.keywords.get("given");
    }

    public List<String> getWhenKeywords() {
        return (List) this.keywords.get("when");
    }

    public List<String> getThenKeywords() {
        return (List) this.keywords.get("then");
    }

    public List<String> getAndKeywords() {
        return (List) this.keywords.get(JsonPredicate.AND_PREDICATE_TYPE);
    }

    public List<String> getButKeywords() {
        return (List) this.keywords.get("but");
    }

    public String getLanguage() {
        return this.language;
    }
}
