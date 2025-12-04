package com.urbanairship.android.layout;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/android/layout/AirshipCustomViewArguments;", "", "name", "", CustomEvent.PROPERTIES, "Lcom/urbanairship/json/JsonMap;", "sizeInfo", "Lcom/urbanairship/android/layout/AirshipCustomViewArguments$SizeInfo;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonMap;Lcom/urbanairship/android/layout/AirshipCustomViewArguments$SizeInfo;)V", "getName", "()Ljava/lang/String;", "getProperties", "()Lcom/urbanairship/json/JsonMap;", "getSizeInfo", "()Lcom/urbanairship/android/layout/AirshipCustomViewArguments$SizeInfo;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "SizeInfo", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AirshipCustomViewArguments {
    private final String name;
    private final JsonMap properties;
    private final SizeInfo sizeInfo;

    public AirshipCustomViewArguments(@NotNull String name, @NotNull JsonMap properties, @NotNull SizeInfo sizeInfo) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(sizeInfo, "sizeInfo");
        this.name = name;
        this.properties = properties;
        this.sizeInfo = sizeInfo;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final JsonMap getProperties() {
        return this.properties;
    }

    @NotNull
    public final SizeInfo getSizeInfo() {
        return this.sizeInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AirshipCustomViewArguments.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.android.layout.AirshipCustomViewArguments");
        return Intrinsics.areEqual(this.properties, ((AirshipCustomViewArguments) other).properties);
    }

    public int hashCode() {
        return this.properties.hashCode();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/urbanairship/android/layout/AirshipCustomViewArguments$SizeInfo;", "", "isAutoHeight", "", "isAutoWidth", "(ZZ)V", "()Z", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SizeInfo {
        private final boolean isAutoHeight;
        private final boolean isAutoWidth;

        public SizeInfo(boolean z, boolean z2) {
            this.isAutoHeight = z;
            this.isAutoWidth = z2;
        }

        /* renamed from: isAutoHeight, reason: from getter */
        public final boolean getIsAutoHeight() {
            return this.isAutoHeight;
        }

        /* renamed from: isAutoWidth, reason: from getter */
        public final boolean getIsAutoWidth() {
            return this.isAutoWidth;
        }

        @NotNull
        public String toString() {
            return "SizeInfo(isAutoHeight=" + this.isAutoHeight + ", isAutoWidth=" + this.isAutoWidth + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }
}
