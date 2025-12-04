package com.facebook.react.uimanager.style;

import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/facebook/react/uimanager/style/ProcessedColorStop;", "", "color", "", ViewProps.POSITION, "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Float;)V", "getColor", "()Ljava/lang/Integer;", "setColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPosition", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Float;)Lcom/facebook/react/uimanager/style/ProcessedColorStop;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* data */ class ProcessedColorStop {

    @Nullable
    private Integer color;

    @Nullable
    private final Float position;

    public ProcessedColorStop() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ProcessedColorStop copy$default(ProcessedColorStop processedColorStop, Integer num, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            num = processedColorStop.color;
        }
        if ((i & 2) != 0) {
            f = processedColorStop.position;
        }
        return processedColorStop.copy(num, f);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getColor() {
        return this.color;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Float getPosition() {
        return this.position;
    }

    @NotNull
    public final ProcessedColorStop copy(@Nullable Integer color, @Nullable Float position) {
        return new ProcessedColorStop(color, position);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProcessedColorStop)) {
            return false;
        }
        ProcessedColorStop processedColorStop = (ProcessedColorStop) other;
        return Intrinsics.areEqual(this.color, processedColorStop.color) && Intrinsics.areEqual((Object) this.position, (Object) processedColorStop.position);
    }

    public int hashCode() {
        Integer num = this.color;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Float f = this.position;
        return iHashCode + (f != null ? f.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ProcessedColorStop(color=" + this.color + ", position=" + this.position + ")";
    }

    public ProcessedColorStop(@Nullable Integer num, @Nullable Float f) {
        this.color = num;
        this.position = f;
    }

    public /* synthetic */ ProcessedColorStop(Integer num, Float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : f);
    }

    @Nullable
    public final Integer getColor() {
        return this.color;
    }

    @Nullable
    public final Float getPosition() {
        return this.position;
    }

    public final void setColor(@Nullable Integer num) {
        this.color = num;
    }
}
