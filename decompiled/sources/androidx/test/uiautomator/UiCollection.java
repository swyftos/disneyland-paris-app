package androidx.test.uiautomator;

/* loaded from: classes2.dex */
public class UiCollection extends UiObject {
    public UiCollection(UiSelector uiSelector) {
        super(uiSelector);
    }

    public UiObject getChildByDescription(UiSelector uiSelector, String str) throws UiObjectNotFoundException {
        Tracer.trace(uiSelector, str);
        if (str != null) {
            int childCount = getChildCount(uiSelector);
            for (int i = 0; i < childCount; i++) {
                UiObject childByInstance = getChildByInstance(uiSelector, i);
                String contentDescription = childByInstance.getContentDescription();
                if ((contentDescription != null && contentDescription.contains(str)) || childByInstance.getChild(new UiSelector().descriptionContains(str)).exists()) {
                    return childByInstance;
                }
            }
        }
        throw new UiObjectNotFoundException("for description= \"" + str + "\"");
    }

    public UiObject getChildByInstance(UiSelector uiSelector, int i) throws UiObjectNotFoundException {
        Tracer.trace(uiSelector, Integer.valueOf(i));
        return new UiObject(UiSelector.patternBuilder(getSelector(), UiSelector.patternBuilder(uiSelector).instance(i)));
    }

    public UiObject getChildByText(UiSelector uiSelector, String str) throws UiObjectNotFoundException {
        Tracer.trace(uiSelector, str);
        if (str != null) {
            int childCount = getChildCount(uiSelector);
            for (int i = 0; i < childCount; i++) {
                UiObject childByInstance = getChildByInstance(uiSelector, i);
                if (str.equals(childByInstance.getText()) || childByInstance.getChild(new UiSelector().text(str)).exists()) {
                    return childByInstance;
                }
            }
        }
        throw new UiObjectNotFoundException("for text= \"" + str + "\"");
    }

    public int getChildCount(UiSelector uiSelector) {
        Tracer.trace(uiSelector);
        return getQueryController().getPatternCount(UiSelector.patternBuilder(getSelector(), UiSelector.patternBuilder(uiSelector)));
    }
}
