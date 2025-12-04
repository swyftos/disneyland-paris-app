package androidx.test.espresso.util;

import android.content.res.Resources;
import android.database.Cursor;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.test.espresso.core.internal.deps.guava.base.Function;
import androidx.test.espresso.core.internal.deps.guava.base.Joiner;
import androidx.test.espresso.core.internal.deps.guava.base.MoreObjects;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Strings;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.util.TreeIterables;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class HumanReadables {
    public static String describe(Cursor cursor) {
        if (cursor.isBeforeFirst()) {
            return "Cursor positioned before first element.";
        }
        if (cursor.isAfterLast()) {
            return "Cursor positioned after last element.";
        }
        StringBuilder sb = new StringBuilder("Row ");
        sb.append(cursor.getPosition());
        sb.append(": {");
        String[] columnNames = cursor.getColumnNames();
        for (int i = 0; i < columnNames.length; i++) {
            sb.append(columnNames[i]);
            sb.append(":");
            int type = cursor.getType(i);
            if (type == 0) {
                sb.append("null");
            } else if (type == 1) {
                sb.append(cursor.getLong(i));
            } else if (type == 2) {
                sb.append(cursor.getDouble(i));
                sb.append("f");
            } else if (type == 3) {
                sb.append("\"");
                sb.append(cursor.getString(i));
                sb.append("\"");
            } else if (type != 4) {
                sb.append("\"");
                sb.append(cursor.getString(i));
                sb.append("\"");
            } else {
                byte[] blob = cursor.getBlob(i);
                sb.append("[");
                for (int i2 = 0; i2 < 5 && i2 < blob.length; i2++) {
                    sb.append((int) blob[i2]);
                    sb.append(",");
                }
                if (blob.length > 5) {
                    sb.append("... (");
                    sb.append(blob.length - 5);
                    sb.append(" more elements)");
                }
                sb.append("]");
            }
            sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

    public static String getViewHierarchyErrorMessage(View view, final List<View> list, String str, final String str2) {
        Preconditions.checkArgument(list == null || str2 != null);
        StringBuilder sb = new StringBuilder(str);
        if (str2 != null) {
            sb.append(String.format(Locale.ROOT, "\nProblem views are marked with '%s' below.", str2));
        }
        String strJoin = Joiner.on("\n|\n").join(Iterables.transform(TreeIterables.depthFirstViewTraversalWithDistance(view), new Function<TreeIterables.ViewAndDistance, String>() { // from class: androidx.test.espresso.util.HumanReadables.1
            @Override // androidx.test.espresso.core.internal.deps.guava.base.Function
            public String apply(TreeIterables.ViewAndDistance viewAndDistance) {
                List list2 = list;
                String strConcat = "+%s%s ";
                if (list2 != null && list2.contains(viewAndDistance.getView())) {
                    String strValueOf = String.valueOf(str2);
                    strConcat = strValueOf.length() != 0 ? "+%s%s ".concat(strValueOf) : new String("+%s%s ");
                }
                return String.format(Locale.ROOT, strConcat, Strings.padStart(">", viewAndDistance.getDistanceFromRoot() + 1, '-'), HumanReadables.describe(viewAndDistance.getView()));
            }
        }));
        sb.append("\n\nView Hierarchy:\n");
        sb.append(strJoin);
        return sb.toString();
    }

    private static void innerDescribe(ViewGroup viewGroup, MoreObjects.ToStringHelper toStringHelper) {
        toStringHelper.add("child-count", viewGroup.getChildCount());
    }

    private static boolean isViewIdGenerated(int i) {
        return ((-16777216) & i) == 0 && (i & ViewCompat.MEASURED_SIZE_MASK) != 0;
    }

    private static void innerDescribe(Checkable checkable, MoreObjects.ToStringHelper toStringHelper) {
        toStringHelper.add("is-checked", checkable.isChecked());
    }

    private static void innerDescribe(TextView textView, MoreObjects.ToStringHelper toStringHelper) {
        if (textView.getText() != null) {
            toStringHelper.add("text", textView.getText());
        }
        if (textView.getError() != null) {
            toStringHelper.add("error-text", textView.getError());
        }
        if (textView.getHint() != null) {
            toStringHelper.add("hint", textView.getHint());
        }
        toStringHelper.add("input-type", textView.getInputType());
        toStringHelper.add("ime-target", textView.isInputMethodTarget());
        toStringHelper.add("has-links", textView.getUrls().length > 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String describe(View view) {
        if (view == 0) {
            return "null";
        }
        MoreObjects.ToStringHelper toStringHelperAdd = MoreObjects.toStringHelper(view).add("id", view.getId());
        if (view.getId() != -1 && view.getResources() != null && !isViewIdGenerated(view.getId())) {
            try {
                toStringHelperAdd.add("res-name", view.getResources().getResourceEntryName(view.getId()));
            } catch (Resources.NotFoundException unused) {
            }
        }
        if (view.getContentDescription() != null) {
            toStringHelperAdd.add("desc", view.getContentDescription());
        }
        int visibility = view.getVisibility();
        if (visibility == 0) {
            toStringHelperAdd.add("visibility", "VISIBLE");
        } else if (visibility == 4) {
            toStringHelperAdd.add("visibility", "INVISIBLE");
        } else if (visibility == 8) {
            toStringHelperAdd.add("visibility", "GONE");
        } else {
            toStringHelperAdd.add("visibility", view.getVisibility());
        }
        toStringHelperAdd.add("width", view.getWidth()).add("height", view.getHeight()).add("has-focus", view.hasFocus()).add("has-focusable", view.hasFocusable()).add("has-window-focus", view.hasWindowFocus()).add("is-clickable", view.isClickable()).add("is-enabled", view.isEnabled()).add("is-focused", view.isFocused()).add("is-focusable", view.isFocusable()).add("is-layout-requested", view.isLayoutRequested()).add("is-selected", view.isSelected()).add("layout-params", view.getLayoutParams()).add("tag", view.getTag());
        if (view.getRootView() != null) {
            toStringHelperAdd.add("root-is-layout-requested", view.getRootView().isLayoutRequested());
        }
        EditorInfo editorInfo = new EditorInfo();
        boolean z = view.onCreateInputConnection(editorInfo) != null;
        toStringHelperAdd.add("has-input-connection", z);
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            editorInfo.dump(new StringBuilderPrinter(sb), "");
            sb.append("]");
            toStringHelperAdd.add("editor-info", sb.toString().replace("\n", " "));
        }
        toStringHelperAdd.add("x", view.getX()).add("y", view.getY());
        if (view instanceof TextView) {
            innerDescribe((TextView) view, toStringHelperAdd);
        }
        if (view instanceof Checkable) {
            innerDescribe((Checkable) view, toStringHelperAdd);
        }
        if (view instanceof ViewGroup) {
            innerDescribe((ViewGroup) view, toStringHelperAdd);
        }
        return toStringHelperAdd.toString();
    }
}
