package gherkin.ast;

/* loaded from: classes5.dex */
public abstract class Node {
    private final Location location;
    private final String type = getClass().getSimpleName();

    protected Node(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return this.location;
    }
}
