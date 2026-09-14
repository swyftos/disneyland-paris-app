package gherkin.events;

import gherkin.pickles.Pickle;

/* JADX INFO: loaded from: classes5.dex */
public class PickleEvent implements CucumberEvent {
    public final Pickle pickle;
    private final String type = "pickle";
    public final String uri;

    public PickleEvent(String str, Pickle pickle) {
        this.uri = str;
        this.pickle = pickle;
    }
}
