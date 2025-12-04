package com.facebook.react.bridge;

import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaValue;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/facebook/react/bridge/DimensionPropConverter;", "", "<init>", "()V", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DimensionPropConverter {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    @Nullable
    public static final YogaValue getDimension(@Nullable Object obj) {
        return INSTANCE.getDimension(obj);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/bridge/DimensionPropConverter$Companion;", "", "<init>", "()V", "getDimension", "Lcom/facebook/yoga/YogaValue;", "value", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @Nullable
        public final YogaValue getDimension(@Nullable Object value) {
            if (value == null) {
                return null;
            }
            if (value instanceof Double) {
                return new YogaValue((float) ((Number) value).doubleValue(), YogaUnit.POINT);
            }
            if (value instanceof String) {
                return YogaValue.parse((String) value);
            }
            throw new JSApplicationCausedNativeException("DimensionValue: the value must be a number or string.");
        }
    }
}
