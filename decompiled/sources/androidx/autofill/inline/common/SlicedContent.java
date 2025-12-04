package androidx.autofill.inline.common;

import android.app.PendingIntent;
import android.app.slice.Slice;
import android.app.slice.SliceSpec;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.autofill.inline.UiVersions;

@RequiresApi(api = 30)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public abstract class SlicedContent implements UiVersions.Content {
    static final Uri INLINE_SLICE_URI = Uri.parse("inline.slice");

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    protected final Slice mSlice;

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public abstract PendingIntent getAttributionIntent();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public abstract boolean isValid();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    protected SlicedContent(@NonNull Slice slice) {
        this.mSlice = slice;
    }

    @Override // androidx.autofill.inline.UiVersions.Content
    @NonNull
    public final Slice getSlice() {
        return this.mSlice;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String getVersion(@NonNull Slice slice) {
        return slice.getSpec().getType();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static abstract class Builder<T extends SlicedContent> {

        @NonNull
        protected final Slice.Builder mSliceBuilder;

        @NonNull
        public abstract T build();

        protected Builder(@NonNull String str) {
            this.mSliceBuilder = new Slice.Builder(SlicedContent.INLINE_SLICE_URI, new SliceSpec(str, 1));
        }
    }
}
