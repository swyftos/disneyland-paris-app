package androidx.test.uiautomator;

import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes2.dex */
public abstract class EventCondition<R> extends Condition<AccessibilityEvent, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.test.uiautomator.Condition
    public abstract Boolean apply(AccessibilityEvent accessibilityEvent);

    abstract Object getResult();
}
