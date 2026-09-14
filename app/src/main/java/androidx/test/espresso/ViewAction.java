package androidx.test.espresso;

import android.view.View;
import org.hamcrest.Matcher;

/* JADX INFO: loaded from: classes2.dex */
public interface ViewAction {
    Matcher<View> getConstraints();

    String getDescription();

    void perform(UiController uiController, View view);
}
