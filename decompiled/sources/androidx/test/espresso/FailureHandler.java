package androidx.test.espresso;

import android.view.View;
import org.hamcrest.Matcher;

/* loaded from: classes2.dex */
public interface FailureHandler {
    void handle(Throwable th, Matcher<View> matcher);
}
