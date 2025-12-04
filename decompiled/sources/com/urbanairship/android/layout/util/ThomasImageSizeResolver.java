package com.urbanairship.android.layout.util;

import android.content.Context;
import android.util.Size;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.urbanairship.android.layout.property.Size;
import com.urbanairship.images.ImageSizeResolver;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J1\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000eH\u0002¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u0012J!\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u0012R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/android/layout/util/ThomasImageSizeResolver;", "Lcom/urbanairship/images/ImageSizeResolver;", "thomasSize", "Lcom/urbanairship/android/layout/property/Size;", "imageSize", "Landroid/util/Size;", "(Lcom/urbanairship/android/layout/property/Size;Landroid/util/Size;)V", "calculateFallbackSize", "", "context", "Landroid/content/Context;", TypedValues.Custom.S_DIMENSION, "Lcom/urbanairship/android/layout/property/Size$Dimension;", "autoSize", "Lkotlin/Function0;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/property/Size$Dimension;Lkotlin/jvm/functions/Function0;)Ljava/lang/Integer;", "resolveHeight", "measuredWidth", "(Landroid/content/Context;Ljava/lang/Integer;)Ljava/lang/Integer;", "resolveWidth", "measuredHeight", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ThomasImageSizeResolver implements ImageSizeResolver {
    private final Size imageSize;
    private final com.urbanairship.android.layout.property.Size thomasSize;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Size.DimensionType.values().length];
            try {
                iArr[Size.DimensionType.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Size.DimensionType.PERCENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Size.DimensionType.ABSOLUTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ThomasImageSizeResolver(@Nullable com.urbanairship.android.layout.property.Size size, @Nullable android.util.Size size2) {
        this.thomasSize = size;
        this.imageSize = size2;
    }

    @Override // com.urbanairship.images.ImageSizeResolver
    @Nullable
    public Integer resolveHeight(@NotNull Context context, @Nullable final Integer measuredWidth) {
        Intrinsics.checkNotNullParameter(context, "context");
        com.urbanairship.android.layout.property.Size size = this.thomasSize;
        return calculateFallbackSize(context, size != null ? size.getHeight() : null, new Function0() { // from class: com.urbanairship.android.layout.util.ThomasImageSizeResolver.resolveHeight.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                if (measuredWidth == null || this.imageSize == null) {
                    return null;
                }
                return Integer.valueOf((int) ((measuredWidth.intValue() * this.imageSize.getHeight()) / this.imageSize.getWidth()));
            }
        });
    }

    @Override // com.urbanairship.images.ImageSizeResolver
    @Nullable
    public Integer resolveWidth(@NotNull Context context, @Nullable final Integer measuredHeight) {
        Intrinsics.checkNotNullParameter(context, "context");
        com.urbanairship.android.layout.property.Size size = this.thomasSize;
        return calculateFallbackSize(context, size != null ? size.getWidth() : null, new Function0() { // from class: com.urbanairship.android.layout.util.ThomasImageSizeResolver.resolveWidth.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                if (measuredHeight == null || this.imageSize == null) {
                    return null;
                }
                return Integer.valueOf((int) ((measuredHeight.intValue() * this.imageSize.getWidth()) / this.imageSize.getHeight()));
            }
        });
    }

    private final Integer calculateFallbackSize(Context context, Size.Dimension dimension, Function0 autoSize) {
        Size.DimensionType type = dimension != null ? dimension.getType() : null;
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == -1) {
            return null;
        }
        if (i == 1) {
            return (Integer) autoSize.invoke();
        }
        if (i == 2) {
            return null;
        }
        if (i == 3) {
            return Integer.valueOf((int) ResourceUtils.dpToPx(context, dimension.getInt()));
        }
        throw new NoWhenBranchMatchedException();
    }
}
