package androidx.test.uiautomator;

import android.graphics.Point;
import java.util.ArrayDeque;
import java.util.Deque;

/* loaded from: classes2.dex */
class PointerGesture {
    private Deque mActions;
    private long mDelay;
    private long mDuration;

    public PointerGesture(Point point) {
        this(point, 0L);
    }

    public PointerGesture(Point point, long j) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.mActions = arrayDeque;
        if (j < 0) {
            throw new IllegalArgumentException("initialDelay cannot be negative");
        }
        arrayDeque.addFirst(new PointerPauseAction(point, 0L));
        this.mDelay = j;
    }

    public PointerGesture pause(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("time cannot be negative");
        }
        Deque deque = this.mActions;
        deque.addLast(new PointerPauseAction(((PointerAction) deque.peekLast()).end, j));
        this.mDuration += ((PointerAction) this.mActions.peekLast()).duration;
        return this;
    }

    public PointerGesture move(Point point, int i) {
        Deque deque = this.mActions;
        deque.addLast(new PointerLinearMoveAction(((PointerAction) deque.peekLast()).end, point, i));
        this.mDuration += ((PointerAction) this.mActions.peekLast()).duration;
        return this;
    }

    public Point start() {
        return ((PointerAction) this.mActions.peekFirst()).start;
    }

    public Point end() {
        return ((PointerAction) this.mActions.peekLast()).end;
    }

    public long duration() {
        return this.mDuration;
    }

    public long delay() {
        return this.mDelay;
    }

    public Point pointAt(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Time cannot be negative");
        }
        long j2 = j - this.mDelay;
        for (PointerAction pointerAction : this.mActions) {
            long j3 = pointerAction.duration;
            if (j2 < j3) {
                return pointerAction.interpolate(j2 / j3);
            }
            j2 -= j3;
        }
        return ((PointerAction) this.mActions.peekLast()).end;
    }

    private static abstract class PointerAction {
        final long duration;
        final Point end;
        final Point start;

        public abstract Point interpolate(float f);

        public PointerAction(Point point, Point point2, long j) {
            this.start = point;
            this.end = point2;
            this.duration = j;
        }
    }

    private static class PointerPauseAction extends PointerAction {
        public PointerPauseAction(Point point, long j) {
            super(point, point, j);
        }

        @Override // androidx.test.uiautomator.PointerGesture.PointerAction
        public Point interpolate(float f) {
            return new Point(this.start);
        }
    }

    private static class PointerLinearMoveAction extends PointerAction {
        public PointerLinearMoveAction(Point point, Point point2, int i) {
            super(point, point2, (long) ((calcDistance(point, point2) * 1000.0d) / i));
        }

        @Override // androidx.test.uiautomator.PointerGesture.PointerAction
        public Point interpolate(float f) {
            Point point = new Point(this.start);
            int i = this.end.x;
            Point point2 = this.start;
            point.offset((int) ((i - point2.x) * f), (int) (f * (r1.y - point2.y)));
            return point;
        }

        private static double calcDistance(Point point, Point point2) {
            int i = point2.x;
            int i2 = point.x;
            int i3 = point2.y;
            int i4 = point.y;
            return Math.sqrt(((i - i2) * (i - i2)) + ((i3 - i4) * (i3 - i4)));
        }
    }
}
