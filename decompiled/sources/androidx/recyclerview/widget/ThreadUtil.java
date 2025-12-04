package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.TileList;

/* loaded from: classes2.dex */
interface ThreadUtil {

    public interface BackgroundCallback<T> {
        void loadTile(int i, int i2);

        @SuppressLint({"UnknownNullness"})
        void recycleTile(TileList.Tile<T> tile);

        void refresh(int i);

        void updateRange(int i, int i2, int i3, int i4, int i5);
    }

    public interface MainThreadCallback<T> {
        @SuppressLint({"UnknownNullness"})
        void addTile(int i, TileList.Tile<T> tile);

        void removeTile(int i, int i2);

        void updateItemCount(int i, int i2);
    }

    BackgroundCallback getBackgroundProxy(BackgroundCallback backgroundCallback);

    MainThreadCallback getMainThreadProxy(MainThreadCallback mainThreadCallback);
}
