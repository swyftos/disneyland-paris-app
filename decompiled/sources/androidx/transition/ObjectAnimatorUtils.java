package androidx.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.util.Property;
import androidx.annotation.DoNotInline;

/* loaded from: classes2.dex */
abstract class ObjectAnimatorUtils {
    static ObjectAnimator ofPointF(Object obj, Property property, Path path) {
        return Api21Impl.ofObject(obj, property, path);
    }

    static class Api21Impl {
        @DoNotInline
        static <T, V> ObjectAnimator ofObject(T t, Property<T, V> property, Path path) {
            return ObjectAnimator.ofObject(t, property, (TypeConverter) null, path);
        }
    }
}
