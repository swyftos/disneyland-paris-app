package androidx.test.espresso.action;

import android.view.KeyEvent;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class EspressoKey {
    private final int keyCode;
    private final int metaState;

    public static class Builder {
        private int builderKeyCode = -1;
        private boolean isAltPressed;
        private boolean isCtrlPressed;
        private boolean isShiftPressed;

        public EspressoKey build() {
            int i = this.builderKeyCode;
            Preconditions.checkState(i > 0 && i < KeyEvent.getMaxKeyCode(), "Invalid key code: %s", this.builderKeyCode);
            return new EspressoKey(this);
        }

        public Builder withAltPressed(boolean z) {
            this.isAltPressed = z;
            return this;
        }

        public Builder withCtrlPressed(boolean z) {
            this.isCtrlPressed = z;
            return this;
        }

        public Builder withKeyCode(int i) {
            this.builderKeyCode = i;
            return this;
        }

        public Builder withShiftPressed(boolean z) {
            this.isShiftPressed = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int getMetaState() {
            boolean z = this.isShiftPressed;
            ?? r0 = z;
            if (this.isAltPressed) {
                r0 = (z ? 1 : 0) | 2;
            }
            return this.isCtrlPressed ? r0 | 4096 : r0;
        }
    }

    EspressoKey(int i, int i2) {
        this.keyCode = i;
        this.metaState = i2;
    }

    public int getKeyCode() {
        return this.keyCode;
    }

    public int getMetaState() {
        return this.metaState;
    }

    public String toString() {
        return String.format(Locale.ROOT, "keyCode: %s, metaState: %s", Integer.valueOf(this.keyCode), Integer.valueOf(this.metaState));
    }

    private EspressoKey(Builder builder) {
        this(builder.builderKeyCode, builder.getMetaState());
    }
}
