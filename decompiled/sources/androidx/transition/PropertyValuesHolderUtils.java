package androidx.transition;

import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.util.Property;
import androidx.annotation.DoNotInline;

/* loaded from: classes2.dex */
abstract class PropertyValuesHolderUtils {
    static PropertyValuesHolder ofPointF(Property property, Path path) {
        return Api21Impl.ofObject(property, path);
    }

    static class Api21Impl {
        @DoNotInline
        static <V> PropertyValuesHolder ofObject(Property<?, V> property, Path path) {
            return PropertyValuesHolder.ofObject(property, (TypeConverter) null, path);
        }
    }
}
