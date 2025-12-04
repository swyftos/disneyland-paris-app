package androidx.test.espresso.action;

import android.app.Activity;
import android.view.View;
import androidx.test.espresso.UiController;
import androidx.test.espresso.action.EspressoKey;
import org.hamcrest.Matcher;

/* loaded from: classes2.dex */
public final class PressBackAction extends KeyEventActionBase {
    private final boolean conditional;

    public PressBackAction(boolean z) {
        this(z, new EspressoKey.Builder().withKeyCode(4).build());
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
        KeyEventActionBase.waitForStageChangeInitialActivity(uiController, currentActivity);
        KeyEventActionBase.waitForPendingForegroundActivities(uiController, this.conditional);
    }

    public PressBackAction(boolean z, EspressoKey espressoKey) {
        super(espressoKey);
        this.conditional = z;
    }
}
