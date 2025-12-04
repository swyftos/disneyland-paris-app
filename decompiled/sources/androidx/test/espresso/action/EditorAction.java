package androidx.test.espresso.action;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.remote.annotation.RemoteMsgConstructor;
import androidx.test.espresso.util.HumanReadables;
import java.util.Locale;
import org.hamcrest.Matcher;

/* loaded from: classes2.dex */
public final class EditorAction implements ViewAction {
    @RemoteMsgConstructor
    public EditorAction() {
    }

    @Override // androidx.test.espresso.ViewAction
    public Matcher<View> getConstraints() {
        return ViewMatchers.isDisplayed();
    }

    @Override // androidx.test.espresso.ViewAction
    public String getDescription() {
        return "input method editor";
    }

    @Override // androidx.test.espresso.ViewAction
    public void perform(UiController uiController, View view) {
        EditorInfo editorInfo = new EditorInfo();
        InputConnection inputConnectionOnCreateInputConnection = view.onCreateInputConnection(editorInfo);
        if (inputConnectionOnCreateInputConnection == null) {
            throw new PerformException.Builder().withActionDescription(toString()).withViewDescription(HumanReadables.describe(view)).withCause(new IllegalStateException("View does not support input methods")).build();
        }
        int i = editorInfo.actionId;
        if (i == 0) {
            i = editorInfo.imeOptions & 255;
        }
        if (i == 1) {
            throw new PerformException.Builder().withActionDescription(getDescription()).withViewDescription(HumanReadables.describe(view)).withCause(new IllegalStateException("No available action on view")).build();
        }
        if (!inputConnectionOnCreateInputConnection.performEditorAction(i)) {
            throw new PerformException.Builder().withActionDescription(getDescription()).withViewDescription(HumanReadables.describe(view)).withCause(new RuntimeException(String.format(Locale.ROOT, "Failed to perform action %#x. Input connection no longer valid", Integer.valueOf(i)))).build();
        }
    }
}
