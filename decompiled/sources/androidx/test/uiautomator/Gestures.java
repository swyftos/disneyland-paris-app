package androidx.test.uiautomator;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.ViewConfiguration;

/* loaded from: classes2.dex */
class Gestures {
    private static Gestures sInstance;
    private ViewConfiguration mViewConfig;

    private Gestures(ViewConfiguration viewConfiguration) {
        this.mViewConfig = viewConfiguration;
    }

    public static Gestures getInstance(UiDevice uiDevice) {
        if (sInstance == null) {
            sInstance = new Gestures(ViewConfiguration.get(uiDevice.getInstrumentation().getContext()));
        }
        return sInstance;
    }

    public PointerGesture click(Point point) {
        return click(point, 0L);
    }

    public PointerGesture click(Point point, long j) {
        return new PointerGesture(point).pause(j);
    }

    public PointerGesture longClick(Point point) {
        return click(point, ViewConfiguration.getLongPressTimeout());
    }

    public PointerGesture swipe(Point point, Point point2, int i) {
        return click(point).move(point2, i);
    }

    /* renamed from: androidx.test.uiautomator.Gestures$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$support$test$uiautomator$Direction;

        static {
            int[] iArr = new int[Direction.values().length];
            $SwitchMap$android$support$test$uiautomator$Direction = iArr;
            try {
                iArr[Direction.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$support$test$uiautomator$Direction[Direction.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$support$test$uiautomator$Direction[Direction.UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$support$test$uiautomator$Direction[Direction.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public PointerGesture swipeRect(Rect rect, Direction direction, float f, int i) {
        Point point;
        Point point2;
        int i2 = AnonymousClass1.$SwitchMap$android$support$test$uiautomator$Direction[direction.ordinal()];
        if (i2 == 1) {
            point = new Point(rect.right, rect.centerY());
            point2 = new Point(rect.right - ((int) (rect.width() * f)), rect.centerY());
        } else if (i2 == 2) {
            point = new Point(rect.left, rect.centerY());
            point2 = new Point(rect.left + ((int) (rect.width() * f)), rect.centerY());
        } else if (i2 == 3) {
            point = new Point(rect.centerX(), rect.bottom);
            point2 = new Point(rect.centerX(), rect.bottom - ((int) (rect.height() * f)));
        } else if (i2 == 4) {
            point = new Point(rect.centerX(), rect.top);
            point2 = new Point(rect.centerX(), rect.top + ((int) (rect.height() * f)));
        } else {
            throw new RuntimeException();
        }
        return swipe(point, point2, i);
    }

    public PointerGesture drag(Point point, Point point2, int i) {
        return longClick(point).move(point2, i);
    }

    public PointerGesture[] pinchClose(Rect rect, float f, int i) {
        Point[] pointArr = new Point[2];
        Point[] pointArr2 = new Point[2];
        calcPinchCoordinates(rect, f, pointArr, pointArr2);
        return new PointerGesture[]{swipe(pointArr[1], pointArr[0], i).pause(250L), swipe(pointArr2[1], pointArr2[0], i).pause(250L)};
    }

    public PointerGesture[] pinchOpen(Rect rect, float f, int i) {
        Point[] pointArr = new Point[2];
        Point[] pointArr2 = new Point[2];
        calcPinchCoordinates(rect, f, pointArr, pointArr2);
        return new PointerGesture[]{swipe(pointArr[0], pointArr[1], i), swipe(pointArr2[0], pointArr2[1], i)};
    }

    private void calcPinchCoordinates(Rect rect, float f, Point[] pointArr, Point[] pointArr2) {
        int iWidth = (int) (((rect.width() - 10) / 2) * f);
        int iHeight = (int) (((rect.height() - 10) / 2) * f);
        pointArr[1] = new Point(rect.left + 5, rect.bottom - 5);
        pointArr2[1] = new Point(rect.right - 5, rect.top + 5);
        Point point = new Point(pointArr[1]);
        pointArr[0] = point;
        point.offset(iWidth, -iHeight);
        Point point2 = new Point(pointArr2[1]);
        pointArr2[0] = point2;
        point2.offset(-iWidth, iHeight);
    }
}
