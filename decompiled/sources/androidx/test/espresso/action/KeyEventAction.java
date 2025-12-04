package androidx.test.espresso.action;

import android.app.Activity;
import android.view.View;
import androidx.test.espresso.UiController;
import org.hamcrest.Matcher;

/* loaded from: classes2.dex */
public final class KeyEventAction extends KeyEventActionBase {
    public KeyEventAction(EspressoKey espressoKey) {
        super(espressoKey);
    }

    @Override // androidx.test.espresso.action.KeyEventActionBase, androidx.test.espresso.ViewAction
    public /* bridge */ /* synthetic */ Matcher getConstraints() {
        return super.getConstraints();
    }

    @Override // androidx.test.espresso.action.KeyEventActionBase, androidx.test.espresso.ViewAction
    public /* bridge */ /* synthetic */ String getDescription() {
        return super.getDescription();
    }

    @Override // androidx.test.espresso.action.KeyEventActionBase, androidx.test.espresso.ViewAction
    public void perform(UiController uiController, View view) {
        Activity currentActivity = KeyEventActionBase.getCurrentActivity();
        super.perform(uiController, view);
        if (this.espressoKey.getKeyCode() == 4) {
            KeyEventActionBase.waitForStageChangeInitialActivity(uiController, currentActivity);
            KeyEventActionBase.waitForPendingForegroundActivities(uiController, true);
        }
    }
}
