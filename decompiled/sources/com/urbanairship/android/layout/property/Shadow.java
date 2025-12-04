package com.urbanairship.android.layout.property;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/android/layout/property/Shadow;", "", "androidShadow", "Lcom/urbanairship/android/layout/property/Shadow$ElevationShadow;", "(Lcom/urbanairship/android/layout/property/Shadow$ElevationShadow;)V", "getAndroidShadow", "()Lcom/urbanairship/android/layout/property/Shadow$ElevationShadow;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "Companion", "ElevationShadow", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Shadow {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final ElevationShadow androidShadow;

    public static /* synthetic */ Shadow copy$default(Shadow shadow, ElevationShadow elevationShadow, int i, Object obj) {
        if ((i & 1) != 0) {
            elevationShadow = shadow.androidShadow;
        }
        return shadow.copy(elevationShadow);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final ElevationShadow getAndroidShadow() {
        return this.androidShadow;
    }

    @NotNull
    public final Shadow copy(@Nullable ElevationShadow androidShadow) {
        return new Shadow(androidShadow);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Shadow) && Intrinsics.areEqual(this.androidShadow, ((Shadow) other).androidShadow);
    }

    public int hashCode() {
        ElevationShadow elevationShadow = this.androidShadow;
        if (elevationShadow == null) {
            return 0;
        }
        return elevationShadow.hashCode();
    }

    @NotNull
    public String toString() {
        return "Shadow(androidShadow=" + this.androidShadow + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public Shadow(@Nullable ElevationShadow elevationShadow) {
        this.androidShadow = elevationShadow;
    }

    @Nullable
    public final ElevationShadow getAndroidShadow() {
        return this.androidShadow;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/Shadow$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/property/Shadow;", "json", "Lcom/urbanairship/json/JsonValue;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nShadow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Shadow.kt\ncom/urbanairship/android/layout/property/Shadow$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,37:1\n1#2:38\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Shadow fromJson(@NotNull JsonValue json) throws JsonException {
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue = json.requireMap().get("android_shadow");
            return new Shadow(jsonValue != null ? ElevationShadow.INSTANCE.fromJson(jsonValue) : null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/android/layout/property/Shadow$ElevationShadow;", "", "color", "Lcom/urbanairship/android/layout/property/Color;", "elevation", "", "(Lcom/urbanairship/android/layout/property/Color;F)V", "getColor", "()Lcom/urbanairship/android/layout/property/Color;", "getElevation", "()F", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ElevationShadow {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final Color color;
        private final float elevation;

        public static /* synthetic */ ElevationShadow copy$default(ElevationShadow elevationShadow, Color color, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                color = elevationShadow.color;
            }
            if ((i & 2) != 0) {
                f = elevationShadow.elevation;
            }
            return elevationShadow.copy(color, f);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final Color getColor() {
            return this.color;
        }

        /* renamed from: component2, reason: from getter */
        public final float getElevation() {
            return this.elevation;
        }

        @NotNull
        public final ElevationShadow copy(@NotNull Color color, float elevation) {
            Intrinsics.checkNotNullParameter(color, "color");
            return new ElevationShadow(color, elevation);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ElevationShadow)) {
                return false;
            }
            ElevationShadow elevationShadow = (ElevationShadow) other;
            return Intrinsics.areEqual(this.color, elevationShadow.color) && Float.compare(this.elevation, elevationShadow.elevation) == 0;
        }

        public int hashCode() {
            return (this.color.hashCode() * 31) + Float.hashCode(this.elevation);
        }

        @NotNull
        public String toString() {
            return "ElevationShadow(color=" + this.color + ", elevation=" + this.elevation + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public ElevationShadow(@NotNull Color color, float f) {
            Intrinsics.checkNotNullParameter(color, "color");
            this.color = color;
            this.elevation = f;
        }

        @NotNull
        public final Color getColor() {
            return this.color;
        }

        public final float getElevation() {
            return this.elevation;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/Shadow$ElevationShadow$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/property/Shadow$ElevationShadow;", "json", "Lcom/urbanairship/json/JsonValue;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nShadow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Shadow.kt\ncom/urbanairship/android/layout/property/Shadow$ElevationShadow$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,37:1\n44#2,15:38\n44#2,15:53\n*S KotlinDebug\n*F\n+ 1 Shadow.kt\ncom/urbanairship/android/layout/property/Shadow$ElevationShadow$Companion\n*L\n30#1:38,15\n31#1:53,15\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Removed duplicated region for block: B:121:0x02d9  */
            /* JADX WARN: Removed duplicated region for block: B:61:0x0177  */
            @org.jetbrains.annotations.NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.urbanairship.android.layout.property.Shadow.ElevationShadow fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonValue r20) throws com.urbanairship.json.JsonException {
                /*
                    Method dump skipped, instructions count: 823
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.property.Shadow.ElevationShadow.Companion.fromJson(com.urbanairship.json.JsonValue):com.urbanairship.android.layout.property.Shadow$ElevationShadow");
            }
        }
    }
}
