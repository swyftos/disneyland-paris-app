package gherkin.pickles;

/* loaded from: classes5.dex */
public class PickleString implements Argument {
    private final String content;
    private final String contentType;
    private final PickleLocation location;

    public PickleString(PickleLocation pickleLocation, String str, String str2) {
        this.location = pickleLocation;
        this.content = str;
        this.contentType = str2;
    }

    public PickleString(PickleLocation pickleLocation, String str) {
        this(pickleLocation, str, null);
    }

    @Override // gherkin.pickles.Argument
    public PickleLocation getLocation() {
        return this.location;
    }

    public String getContent() {
        return this.content;
    }

    public String getContentType() {
        return this.contentType;
    }
}
