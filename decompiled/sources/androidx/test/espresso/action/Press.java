package androidx.test.espresso.action;

/* loaded from: classes2.dex */
public enum Press implements PrecisionDescriber {
    PINPOINT { // from class: androidx.test.espresso.action.Press.1
        @Override // androidx.test.espresso.action.PrecisionDescriber
        public float[] describePrecision() {
            return new float[]{1.0f, 1.0f};
        }
    },
    FINGER { // from class: androidx.test.espresso.action.Press.2
        @Override // androidx.test.espresso.action.PrecisionDescriber
        public float[] describePrecision() {
            return new float[]{16.0f, 16.0f};
        }
    },
    THUMB { // from class: androidx.test.espresso.action.Press.3
        @Override // androidx.test.espresso.action.PrecisionDescriber
        public float[] describePrecision() {
            return new float[]{25.0f, 25.0f};
        }
    }
}
