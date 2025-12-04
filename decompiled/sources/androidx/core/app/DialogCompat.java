package androidx.core.app;

import android.app.Dialog;
import android.view.View;

/* loaded from: classes.dex */
public class DialogCompat {
    public static View requireViewById(Dialog dialog, int i) {
        return (View) Api28Impl.requireViewById(dialog, i);
    }

    static class Api28Impl {
        static Object requireViewById(Dialog dialog, int i) {
            return dialog.requireViewById(i);
        }
    }
}
