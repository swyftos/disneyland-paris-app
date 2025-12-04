package androidx.test.espresso.action;

import android.view.View;
import android.widget.EditText;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.remote.annotation.RemoteMsgConstructor;
import java.util.Locale;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

/* loaded from: classes2.dex */
public final class ReplaceTextAction implements ViewAction {
    final String stringToBeSet;

    @RemoteMsgConstructor
    public ReplaceTextAction(String str) {
        Preconditions.checkNotNull(str);
        this.stringToBeSet = str;
    }

    @Override // androidx.test.espresso.ViewAction
    public Matcher<View> getConstraints() {
        return Matchers.allOf(ViewMatchers.isDisplayed(), ViewMatchers.isAssignableFrom(EditText.class));
    }

    @Override // androidx.test.espresso.ViewAction
    public String getDescription() {
        return String.format(Locale.ROOT, "replace text(%s)", this.stringToBeSet);
    }

    @Override // androidx.test.espresso.ViewAction
    public void perform(UiController uiController, View view) {
        ((EditText) view).setText(this.stringToBeSet);
    }
}
