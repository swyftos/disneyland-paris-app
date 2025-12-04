package gherkin.pickles;

/* loaded from: classes5.dex */
public class PickleCell {
    private final PickleLocation location;
    private final String value;

    public PickleCell(PickleLocation pickleLocation, String str) {
        this.location = pickleLocation;
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public PickleLocation getLocation() {
        return this.location;
    }
}
