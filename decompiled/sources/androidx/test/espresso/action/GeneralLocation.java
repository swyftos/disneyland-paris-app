package androidx.test.espresso.action;

import android.graphics.Rect;
import android.view.View;

/* loaded from: classes2.dex */
public enum GeneralLocation implements CoordinatesProvider {
    TOP_LEFT { // from class: androidx.test.espresso.action.GeneralLocation.1
        @Override // androidx.test.espresso.action.CoordinatesProvider
        public float[] calculateCoordinates(View view) {
            Position position = Position.BEGIN;
            return GeneralLocation.getCoordinates(view, position, position);
        }
    },
    TOP_CENTER { // from class: androidx.test.espresso.action.GeneralLocation.2
        @Override // androidx.test.espresso.action.CoordinatesProvider
        public float[] calculateCoordinates(View view) {
            return GeneralLocation.getCoordinates(view, Position.BEGIN, Position.MIDDLE);
        }
    },
    TOP_RIGHT { // from class: androidx.test.espresso.action.GeneralLocation.3
        @Override // androidx.test.espresso.action.CoordinatesProvider
        public float[] calculateCoordinates(View view) {
            return GeneralLocation.getCoordinates(view, Position.BEGIN, Position.END);
        }
    },
    CENTER_LEFT { // from class: androidx.test.espresso.action.GeneralLocation.4
        @Override // androidx.test.espresso.action.CoordinatesProvider
        public float[] calculateCoordinates(View view) {
            return GeneralLocation.getCoordinates(view, Position.MIDDLE, Position.BEGIN);
        }
    },
    CENTER { // from class: androidx.test.espresso.action.GeneralLocation.5
        @Override // androidx.test.espresso.action.CoordinatesProvider
        public float[] calculateCoordinates(View view) {
            Position position = Position.MIDDLE;
            return GeneralLocation.getCoordinates(view, position, position);
        }
    },
    CENTER_RIGHT { // from class: androidx.test.espresso.action.GeneralLocation.6
        @Override // androidx.test.espresso.action.CoordinatesProvider
        public float[] calculateCoordinates(View view) {
            return GeneralLocation.getCoordinates(view, Position.MIDDLE, Position.END);
        }
    },
    BOTTOM_LEFT { // from class: androidx.test.espresso.action.GeneralLocation.7
        @Override // androidx.test.espresso.action.CoordinatesProvider
        public float[] calculateCoordinates(View view) {
            return GeneralLocation.getCoordinates(view, Position.END, Position.BEGIN);
        }
    },
    BOTTOM_CENTER { // from class: androidx.test.espresso.action.GeneralLocation.8
        @Override // androidx.test.espresso.action.CoordinatesProvider
        public float[] calculateCoordinates(View view) {
            return GeneralLocation.getCoordinates(view, Position.END, Position.MIDDLE);
        }
    },
    BOTTOM_RIGHT { // from class: androidx.test.espresso.action.GeneralLocation.9
        @Override // androidx.test.espresso.action.CoordinatesProvider
        public float[] calculateCoordinates(View view) {
            Position position = Position.END;
            return GeneralLocation.getCoordinates(view, position, position);
        }
    },
    VISIBLE_CENTER { // from class: androidx.test.espresso.action.GeneralLocation.10
        @Override // androidx.test.espresso.action.CoordinatesProvider
        public float[] calculateCoordinates(View view) {
            Position position = Position.MIDDLE;
            return GeneralLocation.getCoordinatesOfVisiblePart(view, position, position);
        }
    };

    private enum Position {
        BEGIN { // from class: androidx.test.espresso.action.GeneralLocation.Position.1
            @Override // androidx.test.espresso.action.GeneralLocation.Position
            public float getPosition(int i, int i2) {
                return i;
            }
        },
        MIDDLE { // from class: androidx.test.espresso.action.GeneralLocation.Position.2
            @Override // androidx.test.espresso.action.GeneralLocation.Position
            public float getPosition(int i, int i2) {
                return i + ((i2 - 1) / 2.0f);
            }
        },
        END { // from class: androidx.test.espresso.action.GeneralLocation.Position.3
            @Override // androidx.test.espresso.action.GeneralLocation.Position
            public float getPosition(int i, int i2) {
                return (i + i2) - 1;
            }
        };

        abstract float getPosition(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float[] getCoordinates(View view, Position position, Position position2) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new float[]{position2.getPosition(iArr[0], view.getWidth()), position.getPosition(iArr[1], view.getHeight())};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float[] getCoordinatesOfVisiblePart(View view, Position position, Position position2) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return new float[]{position2.getPosition(iArr[0], rect.width()), position.getPosition(iArr[1], rect.height())};
    }

    static CoordinatesProvider translate(CoordinatesProvider coordinatesProvider, float f, float f2) {
        return new TranslatedCoordinatesProvider(coordinatesProvider, f, f2);
    }
}
