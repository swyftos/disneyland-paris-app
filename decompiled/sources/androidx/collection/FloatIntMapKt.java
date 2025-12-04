package androidx.collection;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\u001a\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0016\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"EmptyFloatIntMap", "Landroidx/collection/MutableFloatIntMap;", "emptyFloatIntMap", "Landroidx/collection/FloatIntMap;", "floatIntMapOf", "key1", "", "value1", "", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableFloatIntMapOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FloatIntMapKt {
    private static final MutableFloatIntMap EmptyFloatIntMap = new MutableFloatIntMap(0);

    @NotNull
    public static final FloatIntMap emptyFloatIntMap() {
        return EmptyFloatIntMap;
    }

    @NotNull
    public static final FloatIntMap floatIntMapOf() {
        return EmptyFloatIntMap;
    }

    @NotNull
    public static final FloatIntMap floatIntMapOf(float f, int i) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, null);
        mutableFloatIntMap.set(f, i);
        return mutableFloatIntMap;
    }

    @NotNull
    public static final FloatIntMap floatIntMapOf(float f, int i, float f2, int i2) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, null);
        mutableFloatIntMap.set(f, i);
        mutableFloatIntMap.set(f2, i2);
        return mutableFloatIntMap;
    }

    @NotNull
    public static final FloatIntMap floatIntMapOf(float f, int i, float f2, int i2, float f3, int i3) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, null);
        mutableFloatIntMap.set(f, i);
        mutableFloatIntMap.set(f2, i2);
        mutableFloatIntMap.set(f3, i3);
        return mutableFloatIntMap;
    }

    @NotNull
    public static final FloatIntMap floatIntMapOf(float f, int i, float f2, int i2, float f3, int i3, float f4, int i4) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, null);
        mutableFloatIntMap.set(f, i);
        mutableFloatIntMap.set(f2, i2);
        mutableFloatIntMap.set(f3, i3);
        mutableFloatIntMap.set(f4, i4);
        return mutableFloatIntMap;
    }

    @NotNull
    public static final FloatIntMap floatIntMapOf(float f, int i, float f2, int i2, float f3, int i3, float f4, int i4, float f5, int i5) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, null);
        mutableFloatIntMap.set(f, i);
        mutableFloatIntMap.set(f2, i2);
        mutableFloatIntMap.set(f3, i3);
        mutableFloatIntMap.set(f4, i4);
        mutableFloatIntMap.set(f5, i5);
        return mutableFloatIntMap;
    }

    @NotNull
    public static final MutableFloatIntMap mutableFloatIntMapOf() {
        return new MutableFloatIntMap(0, 1, null);
    }

    @NotNull
    public static final MutableFloatIntMap mutableFloatIntMapOf(float f, int i) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, null);
        mutableFloatIntMap.set(f, i);
        return mutableFloatIntMap;
    }

    @NotNull
    public static final MutableFloatIntMap mutableFloatIntMapOf(float f, int i, float f2, int i2) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, null);
        mutableFloatIntMap.set(f, i);
        mutableFloatIntMap.set(f2, i2);
        return mutableFloatIntMap;
    }

    @NotNull
    public static final MutableFloatIntMap mutableFloatIntMapOf(float f, int i, float f2, int i2, float f3, int i3) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, null);
        mutableFloatIntMap.set(f, i);
        mutableFloatIntMap.set(f2, i2);
        mutableFloatIntMap.set(f3, i3);
        return mutableFloatIntMap;
    }

    @NotNull
    public static final MutableFloatIntMap mutableFloatIntMapOf(float f, int i, float f2, int i2, float f3, int i3, float f4, int i4) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, null);
        mutableFloatIntMap.set(f, i);
        mutableFloatIntMap.set(f2, i2);
        mutableFloatIntMap.set(f3, i3);
        mutableFloatIntMap.set(f4, i4);
        return mutableFloatIntMap;
    }

    @NotNull
    public static final MutableFloatIntMap mutableFloatIntMapOf(float f, int i, float f2, int i2, float f3, int i3, float f4, int i4, float f5, int i5) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, null);
        mutableFloatIntMap.set(f, i);
        mutableFloatIntMap.set(f2, i2);
        mutableFloatIntMap.set(f3, i3);
        mutableFloatIntMap.set(f4, i4);
        mutableFloatIntMap.set(f5, i5);
        return mutableFloatIntMap;
    }
}
