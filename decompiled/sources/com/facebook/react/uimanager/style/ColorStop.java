package com.facebook.react.uimanager.style;

import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/facebook/react/uimanager/style/ColorStop;", "", "color", "", ViewProps.POSITION, "Lcom/facebook/react/uimanager/LengthPercentage;", "<init>", "(Ljava/lang/Integer;Lcom/facebook/react/uimanager/LengthPercentage;)V", "getColor", "()Ljava/lang/Integer;", "setColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPosition", "()Lcom/facebook/react/uimanager/LengthPercentage;", "component1", "component2", "copy", "(Ljava/lang/Integer;Lcom/facebook/react/uimanager/LengthPercentage;)Lcom/facebook/react/uimanager/style/ColorStop;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* data */ class ColorStop {

    @Nullable
    private Integer color;

    @Nullable
    private final LengthPercentage position;

    public ColorStop() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ColorStop copy$default(ColorStop colorStop, Integer num, LengthPercentage lengthPercentage, int i, Object obj) {
        if ((i & 1) != 0) {
            num = colorStop.color;
        }
        if ((i & 2) != 0) {
            lengthPercentage = colorStop.position;
        }
        return colorStop.copy(num, lengthPercentage);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getColor() {
        return this.color;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final LengthPercentage getPosition() {
        return this.position;
    }

    @NotNull
    public final ColorStop copy(@Nullable Integer color, @Nullable LengthPercentage position) {
        return new ColorStop(color, position);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorStop)) {
            return false;
        }
        ColorStop colorStop = (ColorStop) other;
        return Intrinsics.areEqual(this.color, colorStop.color) && Intrinsics.areEqual(this.position, colorStop.position);
    }

    public int hashCode() {
        Integer num = this.color;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        LengthPercentage lengthPercentage = this.position;
        return iHashCode + (lengthPercentage != null ? lengthPercentage.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ColorStop(color=" + this.color + ", position=" + this.position + ")";
    }

    public ColorStop(@Nullable Integer num, @Nullable LengthPercentage lengthPercentage) {
        this.color = num;
        this.position = lengthPercentage;
    }

    public /* synthetic */ ColorStop(Integer num, LengthPercentage lengthPercentage, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : lengthPercentage);
    }

    @Nullable
    public final Integer getColor() {
        return this.color;
    }

    @Nullable
    public final LengthPercentage getPosition() {
        return this.position;
    }

    public final void setColor(@Nullable Integer num) {
        this.color = num;
    }
}
