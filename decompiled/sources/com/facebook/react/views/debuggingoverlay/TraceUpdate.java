package com.facebook.react.views.debuggingoverlay;

import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/facebook/react/views/debuggingoverlay/TraceUpdate;", "", "id", "", "rectangle", "Landroid/graphics/RectF;", "color", "<init>", "(ILandroid/graphics/RectF;I)V", "getId", "()I", "getRectangle", "()Landroid/graphics/RectF;", "getColor", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TraceUpdate {
    private final int color;
    private final int id;

    @NotNull
    private final RectF rectangle;

    public TraceUpdate(int i, @NotNull RectF rectangle, int i2) {
        Intrinsics.checkNotNullParameter(rectangle, "rectangle");
        this.id = i;
        this.rectangle = rectangle;
        this.color = i2;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final RectF getRectangle() {
        return this.rectangle;
    }
}
