package androidx.test.uiautomator;

import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
class ByMatcher {
    private static final String TAG = "ByMatcher";
    private UiDevice mDevice;
    private BySelector mSelector;
    private boolean mShortCircuit;

    private ByMatcher(UiDevice uiDevice, BySelector bySelector, boolean z) {
        this.mDevice = uiDevice;
        this.mSelector = bySelector;
        this.mShortCircuit = z;
    }

    static AccessibilityNodeInfo findMatch(UiDevice uiDevice, BySelector bySelector, AccessibilityNodeInfo... accessibilityNodeInfoArr) {
        ByMatcher byMatcher = new ByMatcher(uiDevice, bySelector, true);
        for (AccessibilityNodeInfo accessibilityNodeInfo : accessibilityNodeInfoArr) {
            List listFindMatches = byMatcher.findMatches(accessibilityNodeInfo);
            if (!listFindMatches.isEmpty()) {
                return (AccessibilityNodeInfo) listFindMatches.get(0);
            }
        }
        return null;
    }

    static List findMatches(UiDevice uiDevice, BySelector bySelector, AccessibilityNodeInfo... accessibilityNodeInfoArr) {
        ArrayList arrayList = new ArrayList();
        ByMatcher byMatcher = new ByMatcher(uiDevice, bySelector, false);
        for (AccessibilityNodeInfo accessibilityNodeInfo : accessibilityNodeInfoArr) {
            arrayList.addAll(byMatcher.findMatches(accessibilityNodeInfo));
        }
        return arrayList;
    }

    private List findMatches(AccessibilityNodeInfo accessibilityNodeInfo) {
        List listFindMatches = findMatches(accessibilityNodeInfo, 0, 0, new SinglyLinkedList());
        if (!listFindMatches.isEmpty()) {
            return listFindMatches;
        }
        this.mDevice.runWatchers();
        return findMatches(accessibilityNodeInfo, 0, 0, new SinglyLinkedList());
    }

    private List findMatches(AccessibilityNodeInfo accessibilityNodeInfo, int i, int i2, SinglyLinkedList singlyLinkedList) {
        ArrayList arrayList = new ArrayList();
        if (!accessibilityNodeInfo.isVisibleToUser()) {
            return arrayList;
        }
        Iterator it = singlyLinkedList.iterator();
        while (it.hasNext()) {
            singlyLinkedList = ((PartialMatch) it.next()).update(accessibilityNodeInfo, i, i2, singlyLinkedList);
        }
        PartialMatch partialMatchAccept = PartialMatch.accept(accessibilityNodeInfo, this.mSelector, i, i2);
        if (partialMatchAccept != null) {
            singlyLinkedList = SinglyLinkedList.prepend(partialMatchAccept, singlyLinkedList);
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i3);
            if (child == null) {
                if (!z) {
                    Log.w(TAG, String.format("Node returned null child: %s", accessibilityNodeInfo.toString()));
                }
                Log.w(TAG, String.format("Skipping null child (%s of %s)", Integer.valueOf(i3), Integer.valueOf(childCount)));
                z = true;
            } else {
                arrayList.addAll(findMatches(child, i3, 1 + i2, singlyLinkedList));
                child.recycle();
                if (!arrayList.isEmpty() && this.mShortCircuit) {
                    return arrayList;
                }
            }
        }
        if (partialMatchAccept != null && partialMatchAccept.finalizeMatch()) {
            arrayList.add(AccessibilityNodeInfo.obtain(accessibilityNodeInfo));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkCriteria(Pattern pattern, CharSequence charSequence) {
        if (pattern == null) {
            return true;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        return pattern.matcher(charSequence).matches();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkCriteria(Boolean bool, boolean z) {
        if (bool == null) {
            return true;
        }
        return bool.equals(Boolean.valueOf(z));
    }

    private static class PartialMatch {
        private final int matchDepth;
        private final BySelector matchSelector;
        private final List partialMatches = new ArrayList();

        private PartialMatch(BySelector bySelector, int i) {
            this.matchSelector = bySelector;
            this.matchDepth = i;
        }

        public static PartialMatch accept(AccessibilityNodeInfo accessibilityNodeInfo, BySelector bySelector, int i, int i2) {
            return accept(accessibilityNodeInfo, bySelector, i, i2, i2);
        }

        public static PartialMatch accept(AccessibilityNodeInfo accessibilityNodeInfo, BySelector bySelector, int i, int i2, int i3) {
            Integer num;
            Integer num2 = bySelector.mMinDepth;
            if ((num2 == null || i3 >= num2.intValue()) && (((num = bySelector.mMaxDepth) == null || i3 <= num.intValue()) && ByMatcher.checkCriteria(bySelector.mClazz, accessibilityNodeInfo.getClassName()) && ByMatcher.checkCriteria(bySelector.mDesc, accessibilityNodeInfo.getContentDescription()) && ByMatcher.checkCriteria(bySelector.mPkg, accessibilityNodeInfo.getPackageName()) && ByMatcher.checkCriteria(bySelector.mRes, accessibilityNodeInfo.getViewIdResourceName()) && ByMatcher.checkCriteria(bySelector.mText, accessibilityNodeInfo.getText()) && ByMatcher.checkCriteria(bySelector.mChecked, accessibilityNodeInfo.isChecked()) && ByMatcher.checkCriteria(bySelector.mCheckable, accessibilityNodeInfo.isCheckable()) && ByMatcher.checkCriteria(bySelector.mClickable, accessibilityNodeInfo.isClickable()) && ByMatcher.checkCriteria(bySelector.mEnabled, accessibilityNodeInfo.isEnabled()) && ByMatcher.checkCriteria(bySelector.mFocused, accessibilityNodeInfo.isFocused()) && ByMatcher.checkCriteria(bySelector.mFocusable, accessibilityNodeInfo.isFocusable()) && ByMatcher.checkCriteria(bySelector.mLongClickable, accessibilityNodeInfo.isLongClickable()) && ByMatcher.checkCriteria(bySelector.mScrollable, accessibilityNodeInfo.isScrollable()) && ByMatcher.checkCriteria(bySelector.mSelected, accessibilityNodeInfo.isSelected()))) {
                return new PartialMatch(bySelector, i2);
            }
            return null;
        }

        public SinglyLinkedList update(AccessibilityNodeInfo accessibilityNodeInfo, int i, int i2, SinglyLinkedList singlyLinkedList) {
            Iterator it = this.matchSelector.mChildSelectors.iterator();
            while (it.hasNext()) {
                PartialMatch partialMatchAccept = accept(accessibilityNodeInfo, (BySelector) it.next(), i, i2, i2 - this.matchDepth);
                if (partialMatchAccept != null) {
                    this.partialMatches.add(partialMatchAccept);
                    singlyLinkedList = SinglyLinkedList.prepend(partialMatchAccept, singlyLinkedList);
                }
            }
            return singlyLinkedList;
        }

        public boolean finalizeMatch() {
            HashSet hashSet = new HashSet();
            for (PartialMatch partialMatch : this.partialMatches) {
                if (partialMatch.finalizeMatch()) {
                    hashSet.add(partialMatch.matchSelector);
                }
            }
            return hashSet.containsAll(this.matchSelector.mChildSelectors);
        }
    }

    private static class SinglyLinkedList<T> implements Iterable<T> {
        private final Node mHead;

        public SinglyLinkedList() {
            this(null);
        }

        private SinglyLinkedList(Node node) {
            this.mHead = node;
        }

        public static SinglyLinkedList prepend(Object obj, SinglyLinkedList singlyLinkedList) {
            return new SinglyLinkedList(new Node(obj, singlyLinkedList.mHead));
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new Iterator<T>() { // from class: androidx.test.uiautomator.ByMatcher.SinglyLinkedList.1
                private Node mNext;

                {
                    this.mNext = SinglyLinkedList.this.mHead;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.mNext != null;
                }

                @Override // java.util.Iterator
                public Object next() {
                    Node node = this.mNext;
                    Object obj = node.data;
                    this.mNext = node.next;
                    return obj;
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        private static class Node<T> {
            public final Object data;
            public final Node next;

            public Node(Object obj, Node node) {
                this.data = obj;
                this.next = node;
            }
        }
    }
}
