package com.urbanairship.embedded;

import com.urbanairship.android.layout.property.ConstrainedSize;
import com.urbanairship.android.layout.property.Size;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002\u001a,\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002¨\u0006\u000b"}, d2 = {"toEmbeddedDimension", "Lcom/urbanairship/embedded/EmbeddedDimension;", "Lcom/urbanairship/android/layout/property/Size$Dimension;", "parentDimensionProvider", "Lkotlin/Function0;", "", "toEmbeddedSize", "Lcom/urbanairship/embedded/EmbeddedSize;", "Lcom/urbanairship/android/layout/property/ConstrainedSize;", "parentWidthProvider", "parentHeightProvider", "urbanairship-automation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AirshipEmbeddedViewKt {

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
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EmbeddedSize toEmbeddedSize(ConstrainedSize constrainedSize, Function0 function0, Function0 function02) {
        Size.Dimension width = constrainedSize.getWidth();
        Intrinsics.checkNotNullExpressionValue(width, "getWidth(...)");
        EmbeddedDimension embeddedDimension = toEmbeddedDimension(width, function0);
        Size.Dimension height = constrainedSize.getHeight();
        Intrinsics.checkNotNullExpressionValue(height, "getHeight(...)");
        return new EmbeddedSize(embeddedDimension, toEmbeddedDimension(height, function02));
    }

    private static final EmbeddedDimension toEmbeddedDimension(Size.Dimension dimension, Function0 function0) {
        EmbeddedDimension embeddedDimension;
        int i = WhenMappings.$EnumSwitchMapping$0[dimension.getType().ordinal()];
        if (i != 1) {
            embeddedDimension = null;
            if (i == 2 && function0 != null) {
                embeddedDimension = new EmbeddedDimension((int) Math.rint(dimension.getFloat() * ((Number) function0.invoke()).intValue()), true);
            }
        } else {
            embeddedDimension = new EmbeddedDimension(-2, false);
        }
        return embeddedDimension == null ? new EmbeddedDimension(-1, false) : embeddedDimension;
    }
}
