package coil3.size;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, m1836d2 = {"Lcoil3/size/Size;", "", "width", "Lcoil3/size/Dimension;", "height", "<init>", "(Lcoil3/size/Dimension;Lcoil3/size/Dimension;)V", "getWidth", "()Lcoil3/size/Dimension;", "getHeight", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "Companion", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final /* data */ class Size {

    @JvmField
    @NotNull
    public static final Size ORIGINAL;
    private final Dimension height;
    private final Dimension width;

    public static /* synthetic */ Size copy$default(Size size, Dimension dimension, Dimension dimension2, int i, Object obj) {
        if ((i & 1) != 0) {
            dimension = size.width;
        }
        if ((i & 2) != 0) {
            dimension2 = size.height;
        }
        return size.copy(dimension, dimension2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Dimension getWidth() {
        return this.width;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Dimension getHeight() {
        return this.height;
    }

    @NotNull
    public final Size copy(@NotNull Dimension width, @NotNull Dimension height) {
        return new Size(width, height);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Size)) {
            return false;
        }
        Size size = (Size) other;
        return Intrinsics.areEqual(this.width, size.width) && Intrinsics.areEqual(this.height, size.height);
    }

    public int hashCode() {
        return (this.width.hashCode() * 31) + this.height.hashCode();
    }

    @NotNull
    public String toString() {
        return "Size(width=" + this.width + ", height=" + this.height + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public Size(@NotNull Dimension dimension, @NotNull Dimension dimension2) {
        this.width = dimension;
        this.height = dimension2;
    }

    @NotNull
    public final Dimension getWidth() {
        return this.width;
    }

    @NotNull
    public final Dimension getHeight() {
        return this.height;
    }

    static {
        Dimension.Undefined undefined = Dimension.Undefined.INSTANCE;
        ORIGINAL = new Size(undefined, undefined);
    }
}
