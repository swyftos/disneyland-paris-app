package io.cucumber.datatable.dependency.difflib.myers;

/* loaded from: classes5.dex */
public final class DiffNode extends PathNode {
    @Override // io.cucumber.datatable.dependency.difflib.myers.PathNode
    public boolean isSnake() {
        return false;
    }

    public DiffNode(int i, int i2, PathNode pathNode) {
        super(i, i2, pathNode == null ? null : pathNode.previousSnake());
    }
}
