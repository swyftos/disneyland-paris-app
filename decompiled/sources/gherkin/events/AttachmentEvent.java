package gherkin.events;

/* loaded from: classes5.dex */
public class AttachmentEvent implements CucumberEvent {
    private final String data;
    private final SourceRef source;
    private final String type = "attachment";
    private final Media media = new Media();

    public static class Media {
        private final String encoding = "utf-8";
        private final String type = "text/x.cucumber.stacktrace+plain";
    }

    public AttachmentEvent(SourceRef sourceRef, String str) {
        this.source = sourceRef;
        this.data = str;
    }

    public static class SourceRef {
        private final Location start;
        private final String uri;

        public SourceRef(String str, Location location) {
            this.uri = str;
            this.start = location;
        }
    }

    public static class Location {
        private final int column;
        private final int line;

        public Location(int i, int i2) {
            this.line = i;
            this.column = i2;
        }
    }
}
