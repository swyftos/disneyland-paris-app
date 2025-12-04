package io.cucumber.datatable.dependency.difflib.myers;

/* loaded from: classes5.dex */
public final class Snake extends PathNode {
    @Override // io.cucumber.datatable.dependency.difflib.myers.PathNode
    public boolean isSnake() {
        return true;
    }

    public Snake(int i, int i2, PathNode pathNode) {
        super(i, i2, pathNode);
    }
}
