package io.cucumber.datatable.dependency.difflib.myers;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PathNode {

    /* JADX INFO: renamed from: i */
    public final int f3827i;

    /* JADX INFO: renamed from: j */
    public final int f3828j;
    public final PathNode prev;

    public abstract boolean isSnake();

    public PathNode(int i, int i2, PathNode pathNode) {
        this.f3827i = i;
        this.f3828j = i2;
        this.prev = pathNode;
    }

    public boolean isBootstrap() {
        return this.f3827i < 0 || this.f3828j < 0;
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
            stringBuffer.append(Integer.toString(this.f3827i));
            stringBuffer.append(",");
            stringBuffer.append(Integer.toString(this.f3828j));
            stringBuffer.append(")");
            this = this.prev;
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
