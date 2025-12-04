package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.ReplaceWith;

@Deprecated
/* loaded from: classes.dex */
public final class ListViewCompat {
    @ReplaceWith(expression = "listView.scrollListBy(y)")
    @Deprecated
    public static void scrollListBy(ListView listView, int i) {
        listView.scrollListBy(i);
    }

    @ReplaceWith(expression = "listView.canScrollList(direction)")
    @Deprecated
    public static boolean canScrollList(ListView listView, int i) {
        return listView.canScrollList(i);
    }
}
