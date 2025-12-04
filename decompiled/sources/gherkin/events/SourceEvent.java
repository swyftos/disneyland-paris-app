package gherkin.events;

/* loaded from: classes5.dex */
public class SourceEvent implements CucumberEvent {
    public final String data;
    public final String uri;
    private final String type = "source";
    private final Media media = new Media();

    public static class Media {
        private final String encoding = "utf-8";
        private final String type = "text/x.cucumber.gherkin+plain";
    }

    public SourceEvent(String str, String str2) {
        this.uri = str;
        this.data = str2;
    }
}
