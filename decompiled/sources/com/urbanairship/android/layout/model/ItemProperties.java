package com.urbanairship.android.layout.model;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.property.Size;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/android/layout/model/ItemProperties;", "", TCEventPropertiesNames.TCP_SIZE, "Lcom/urbanairship/android/layout/property/Size;", "(Lcom/urbanairship/android/layout/property/Size;)V", "getSize", "()Lcom/urbanairship/android/layout/property/Size;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ItemProperties {
    private final Size size;

    public static /* synthetic */ ItemProperties copy$default(ItemProperties itemProperties, Size size, int i, Object obj) {
        if ((i & 1) != 0) {
            size = itemProperties.size;
        }
        return itemProperties.copy(size);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    @NotNull
    public final ItemProperties copy(@Nullable Size size) {
        return new ItemProperties(size);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ItemProperties) && Intrinsics.areEqual(this.size, ((ItemProperties) other).size);
    }

    public int hashCode() {
        Size size = this.size;
        if (size == null) {
            return 0;
        }
        return size.hashCode();
    }

    @NotNull
    public String toString() {
        return "ItemProperties(size=" + this.size + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ItemProperties(@Nullable Size size) {
        this.size = size;
    }

    @Nullable
    public final Size getSize() {
        return this.size;
    }
}
