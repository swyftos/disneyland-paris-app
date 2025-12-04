package gherkin.pickles;

/* loaded from: classes5.dex */
public class PickleTag {
    private final PickleLocation location;
    private final String name;

    public PickleTag(PickleLocation pickleLocation, String str) {
        this.location = pickleLocation;
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
