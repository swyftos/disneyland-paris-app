package androidx.media3.session.legacy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.amazonaws.internal.ListWithAutoConstructFlag;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
@UnstableApi
public final class LegacyParcelableUtil {
    public static <T extends Parcelable, U extends Parcelable> T convert(U u, Parcelable.Creator<T> creator) {
        if (u == null) {
            return null;
        }
        Parcelable parcelable = (Parcelable) maybeApplyMediaDescriptionParcelableBugWorkaround(u);
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            parcelObtain.setDataPosition(0);
            return (T) maybeApplyMediaDescriptionParcelableBugWorkaround(creator.createFromParcel(parcelObtain));
        } finally {
            parcelObtain.recycle();
        }
    }

    public static <T extends Parcelable, U extends Parcelable> ArrayList<T> convertList(List<U> list, Parcelable.Creator<T> creator) {
        if (list == null) {
            return null;
        }
        ListWithAutoConstructFlag listWithAutoConstructFlag = (ArrayList<T>) new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            listWithAutoConstructFlag.add(convert(list.get(i), creator));
        }
        return listWithAutoConstructFlag;
    }

    private static Object maybeApplyMediaDescriptionParcelableBugWorkaround(Object obj) {
        int i = Util.SDK_INT;
        if (i < 21 || i >= 23) {
            return obj;
        }
        if (!(obj instanceof android.support.v4.media.MediaBrowserCompat.MediaItem)) {
            return obj instanceof android.support.v4.media.MediaDescriptionCompat ? rebuildMediaDescriptionCompat((android.support.v4.media.MediaDescriptionCompat) obj) : obj;
        }
        android.support.v4.media.MediaBrowserCompat.MediaItem mediaItem = (android.support.v4.media.MediaBrowserCompat.MediaItem) obj;
        return new android.support.v4.media.MediaBrowserCompat.MediaItem(rebuildMediaDescriptionCompat(mediaItem.getDescription()), mediaItem.getFlags());
    }

    private static android.support.v4.media.MediaDescriptionCompat rebuildMediaDescriptionCompat(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat) {
        return new android.support.v4.media.MediaDescriptionCompat.Builder().setMediaId(mediaDescriptionCompat.getMediaId()).setTitle(mediaDescriptionCompat.getTitle()).setSubtitle(mediaDescriptionCompat.getSubtitle()).setDescription(mediaDescriptionCompat.getDescription()).setIconBitmap(mediaDescriptionCompat.getIconBitmap()).setIconUri(mediaDescriptionCompat.getIconUri()).setExtras(mediaDescriptionCompat.getExtras()).setMediaUri(mediaDescriptionCompat.getMediaUri()).build();
    }
}
