package androidx.test.uiautomator;

/* loaded from: classes2.dex */
public enum Direction {
    LEFT,
    RIGHT,
    UP,
    DOWN;

    private Direction mOpposite;

    static {
        Direction direction = LEFT;
        Direction direction2 = RIGHT;
        Direction direction3 = UP;
        Direction direction4 = DOWN;
        direction.mOpposite = direction2;
        direction2.mOpposite = direction;
        direction3.mOpposite = direction4;
        direction4.mOpposite = direction3;
    }

    public static Direction reverse(Direction direction) {
        return direction.mOpposite;
    }
}
