package androidx.test.uiautomator;

import android.view.accessibility.AccessibilityEvent;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class Until {
    public static SearchCondition<Boolean> gone(final BySelector bySelector) {
        return new SearchCondition<Boolean>() { // from class: androidx.test.uiautomator.Until.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.test.uiautomator.Condition
            public Boolean apply(Searchable searchable) {
                return Boolean.valueOf(!searchable.hasObject(bySelector));
            }
        };
    }

    public static SearchCondition<Boolean> hasObject(final BySelector bySelector) {
        return new SearchCondition<Boolean>() { // from class: androidx.test.uiautomator.Until.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.test.uiautomator.Condition
            public Boolean apply(Searchable searchable) {
                return Boolean.valueOf(searchable.hasObject(bySelector));
            }
        };
    }

    public static SearchCondition<UiObject2> findObject(final BySelector bySelector) {
        return new SearchCondition<UiObject2>() { // from class: androidx.test.uiautomator.Until.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.test.uiautomator.Condition
            public UiObject2 apply(Searchable searchable) {
                return searchable.findObject(bySelector);
            }
        };
    }

    public static SearchCondition<List<UiObject2>> findObjects(final BySelector bySelector) {
        return new SearchCondition<List<UiObject2>>() { // from class: androidx.test.uiautomator.Until.4
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.test.uiautomator.Condition
            public List apply(Searchable searchable) {
                List listFindObjects = searchable.findObjects(bySelector);
                if (listFindObjects.isEmpty()) {
                    return null;
                }
                return listFindObjects;
            }
        };
    }

    public static UiObject2Condition<Boolean> checkable(final boolean z) {
        return new UiObject2Condition<Boolean>() { // from class: androidx.test.uiautomator.Until.5
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.test.uiautomator.Condition
            public Boolean apply(UiObject2 uiObject2) {
                return Boolean.valueOf(uiObject2.isCheckable() == z);
            }
        };
    }

    public static UiObject2Condition<Boolean> checked(final boolean z) {
        return new UiObject2Condition<Boolean>() { // from class: androidx.test.uiautomator.Until.6
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.test.uiautomator.Condition
            public Boolean apply(UiObject2 uiObject2) {
                return Boolean.valueOf(uiObject2.isChecked() == z);
            }
        };
    }

    public static UiObject2Condition<Boolean> clickable(final boolean z) {
        return new UiObject2Condition<Boolean>() { // from class: androidx.test.uiautomator.Until.7
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.test.uiautomator.Condition
            public Boolean apply(UiObject2 uiObject2) {
                return Boolean.valueOf(uiObject2.isClickable() == z);
            }
        };
    }

    public static UiObject2Condition<Boolean> enabled(final boolean z) {
        return new UiObject2Condition<Boolean>() { // from class: androidx.test.uiautomator.Until.8
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.test.uiautomator.Condition
            public Boolean apply(UiObject2 uiObject2) {
                return Boolean.valueOf(uiObject2.isEnabled() == z);
            }
        };
    }

    public static UiObject2Condition<Boolean> focusable(final boolean z) {
        return new UiObject2Condition<Boolean>() { // from class: androidx.test.uiautomator.Until.9
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.test.uiautomator.Condition
            public Boolean apply(UiObject2 uiObject2) {
                return Boolean.valueOf(uiObject2.isFocusable() == z);
            }
        };
    }

    public static UiObject2Condition<Boolean> focused(final boolean z) {
        return new UiObject2Condition<Boolean>() { // from class: androidx.test.uiautomator.Until.10
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.test.uiautomator.Condition
            public Boolean apply(UiObject2 uiObject2) {
                return Boolean.valueOf(uiObject2.isFocused() == z);
            }
        };
    }

    public static UiObject2Condition<Boolean> longClickable(final boolean z) {
        return new UiObject2Condition<Boolean>() { // from class: androidx.test.uiautomator.Until.11
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.test.uiautomator.Condition
            public Boolean apply(UiObject2 uiObject2) {
                return Boolean.valueOf(uiObject2.isLongClickable() == z);
            }
        };
    }

    public static UiObject2Condition<Boolean> scrollable(final boolean z) {
        return new UiObject2Condition<Boolean>() { // from class: androidx.test.uiautomator.Until.12
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.test.uiautomator.Condition
            public Boolean apply(UiObject2 uiObject2) {
                return Boolean.valueOf(uiObject2.isScrollable() == z);
            }
        };
    }

    public static UiObject2Condition<Boolean> selected(final boolean z) {
        return new UiObject2Condition<Boolean>() { // from class: androidx.test.uiautomator.Until.13
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.test.uiautomator.Condition
            public Boolean apply(UiObject2 uiObject2) {
                return Boolean.valueOf(uiObject2.isSelected() == z);
            }
        };
    }

    public static UiObject2Condition<Boolean> descMatches(final Pattern pattern) {
        return new UiObject2Condition<Boolean>() { // from class: androidx.test.uiautomator.Until.14
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.test.uiautomator.Condition
            public Boolean apply(UiObject2 uiObject2) {
                String contentDescription = uiObject2.getContentDescription();
                Pattern pattern2 = pattern;
                if (contentDescription == null) {
                    contentDescription = "";
                }
                return Boolean.valueOf(pattern2.matcher(contentDescription).matches());
            }
        };
    }

    public static UiObject2Condition<Boolean> descMatches(String str) {
        return descMatches(Pattern.compile(str));
    }

    public static UiObject2Condition<Boolean> descEquals(String str) {
        return descMatches(Pattern.compile(Pattern.quote(str)));
    }

    public static UiObject2Condition<Boolean> descContains(String str) {
        return descMatches(Pattern.compile(String.format("^.*%s.*$", Pattern.quote(str))));
    }

    public static UiObject2Condition<Boolean> descStartsWith(String str) {
        return descMatches(Pattern.compile(String.format("^%s.*$", Pattern.quote(str))));
    }

    public static UiObject2Condition<Boolean> descEndsWith(String str) {
        return descMatches(Pattern.compile(String.format("^.*%s$", Pattern.quote(str))));
    }

    public static UiObject2Condition<Boolean> textMatches(final Pattern pattern) {
        return new UiObject2Condition<Boolean>() { // from class: androidx.test.uiautomator.Until.15
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.test.uiautomator.Condition
            public Boolean apply(UiObject2 uiObject2) {
                String text = uiObject2.getText();
                Pattern pattern2 = pattern;
                if (text == null) {
                    text = "";
                }
                return Boolean.valueOf(pattern2.matcher(text).matches());
            }
        };
    }

    public static UiObject2Condition<Boolean> textMatches(String str) {
        return textMatches(Pattern.compile(str));
    }

    public static UiObject2Condition<Boolean> textNotEquals(final String str) {
        return new UiObject2Condition<Boolean>() { // from class: androidx.test.uiautomator.Until.16
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.test.uiautomator.Condition
            public Boolean apply(UiObject2 uiObject2) {
                return Boolean.valueOf(!str.equals(uiObject2.getText()));
            }
        };
    }

    public static UiObject2Condition<Boolean> textEquals(String str) {
        return textMatches(Pattern.compile(Pattern.quote(str)));
    }

    public static UiObject2Condition<Boolean> textContains(String str) {
        return textMatches(Pattern.compile(String.format("^.*%s.*$", Pattern.quote(str))));
    }

    public static UiObject2Condition<Boolean> textStartsWith(String str) {
        return textMatches(Pattern.compile(String.format("^%s.*$", Pattern.quote(str))));
    }

    public static UiObject2Condition<Boolean> textEndsWith(String str) {
        return textMatches(Pattern.compile(String.format("^.*%s$", Pattern.quote(str))));
    }

    public static EventCondition<Boolean> newWindow() {
        return new EventCondition<Boolean>() { // from class: androidx.test.uiautomator.Until.17
            private int mMask = 2080;

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.test.uiautomator.EventCondition, androidx.test.uiautomator.Condition
            public Boolean apply(AccessibilityEvent accessibilityEvent) {
                int i = (~accessibilityEvent.getEventType()) & this.mMask;
                this.mMask = i;
                return Boolean.valueOf(i == 0);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.test.uiautomator.EventCondition
            public Boolean getResult() {
                return Boolean.valueOf(this.mMask == 0);
            }
        };
    }

    public static EventCondition<Boolean> scrollFinished(Direction direction) {
        return new EventCondition<Boolean>() { // from class: androidx.test.uiautomator.Until.18
            private Direction mDirection;
            private Boolean mResult = null;

            {
                this.mDirection = this.val$direction;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.test.uiautomator.EventCondition, androidx.test.uiautomator.Condition
            public Boolean apply(AccessibilityEvent accessibilityEvent) {
                if (accessibilityEvent.getFromIndex() != -1 && accessibilityEvent.getToIndex() != -1 && accessibilityEvent.getItemCount() != -1) {
                    int i = AnonymousClass19.$SwitchMap$android$support$test$uiautomator$Direction[this.mDirection.ordinal()];
                    if (i == 1) {
                        this.mResult = Boolean.valueOf(accessibilityEvent.getFromIndex() == 0);
                    } else if (i == 2) {
                        this.mResult = Boolean.valueOf(accessibilityEvent.getToIndex() == accessibilityEvent.getItemCount() - 1);
                    } else if (i == 3) {
                        this.mResult = Boolean.valueOf(accessibilityEvent.getFromIndex() == 0);
                    } else {
                        if (i != 4) {
                            throw new IllegalArgumentException("Invalid Direction");
                        }
                        this.mResult = Boolean.valueOf(accessibilityEvent.getToIndex() == accessibilityEvent.getItemCount() - 1);
                    }
                } else if (accessibilityEvent.getScrollX() != -1 && accessibilityEvent.getScrollY() != -1) {
                    int i2 = AnonymousClass19.$SwitchMap$android$support$test$uiautomator$Direction[this.mDirection.ordinal()];
                    if (i2 == 1) {
                        this.mResult = Boolean.valueOf(accessibilityEvent.getScrollY() == 0);
                    } else if (i2 == 2) {
                        this.mResult = Boolean.valueOf(accessibilityEvent.getScrollY() == accessibilityEvent.getMaxScrollY());
                    } else if (i2 == 3) {
                        this.mResult = Boolean.valueOf(accessibilityEvent.getScrollX() == 0);
                    } else {
                        if (i2 != 4) {
                            throw new IllegalArgumentException("Invalid Direction");
                        }
                        this.mResult = Boolean.valueOf(accessibilityEvent.getScrollX() == accessibilityEvent.getMaxScrollX());
                    }
                }
                return Boolean.valueOf(Boolean.TRUE.equals(this.mResult));
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.test.uiautomator.EventCondition
            public Boolean getResult() {
                Boolean bool = this.mResult;
                return Boolean.valueOf(bool == null || bool.booleanValue());
            }
        };
    }

    /* renamed from: androidx.test.uiautomator.Until$19, reason: invalid class name */
    static /* synthetic */ class AnonymousClass19 {
        static final /* synthetic */ int[] $SwitchMap$android$support$test$uiautomator$Direction;

        static {
            int[] iArr = new int[Direction.values().length];
            $SwitchMap$android$support$test$uiautomator$Direction = iArr;
            try {
                iArr[Direction.UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$support$test$uiautomator$Direction[Direction.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$support$test$uiautomator$Direction[Direction.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$support$test$uiautomator$Direction[Direction.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
