package io.cucumber.datatable.dependency.difflib.myers;

/* loaded from: classes5.dex */
public abstract class PathNode {
    public final int i;
    public final int j;
    public final PathNode prev;

    public abstract boolean isSnake();

    public PathNode(int i, int i2, PathNode pathNode) {
        this.i = i;
        this.j = i2;
        this.prev = pathNode;
    }

    public boolean isBootstrap() {
        return this.i < 0 || this.j < 0;
    }

    public final PathNode previousSnake() {
        PathNode pathNode;
        if (isBootstrap()) {
            return null;
        }
        return (isSnake() || (pathNode = this.prev) == null) ? this : pathNode.previousSnake();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[");
        while (this != null) {
            stringBuffer.append("(");
            stringBuffer.append(Integer.toString(this.i));
            stringBuffer.append(",");
            stringBuffer.append(Integer.toString(this.j));
            stringBuffer.append(")");
            this = this.prev;
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
