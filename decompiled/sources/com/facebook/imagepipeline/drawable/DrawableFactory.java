package com.facebook.imagepipeline.drawable;

import android.graphics.drawable.Drawable;
import androidx.media3.common.MimeTypes;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/facebook/imagepipeline/drawable/DrawableFactory;", "", "supportsImageType", "", MimeTypes.BASE_TYPE_IMAGE, "Lcom/facebook/imagepipeline/image/CloseableImage;", "createDrawable", "Landroid/graphics/drawable/Drawable;", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface DrawableFactory {
    @Nullable
    Drawable createDrawable(@NotNull CloseableImage image);

    boolean supportsImageType(@NotNull CloseableImage image);
}
