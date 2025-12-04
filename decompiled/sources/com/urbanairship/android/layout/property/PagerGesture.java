package com.urbanairship.android.layout.property;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.android.layout.info.Identifiable;
import com.urbanairship.android.layout.property.GestureType;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00072\u00020\u0001:\u0004\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/android/layout/property/PagerGesture;", "Lcom/urbanairship/android/layout/info/Identifiable;", "()V", "reportingMetadata", "Lcom/urbanairship/json/JsonValue;", "getReportingMetadata", "()Lcom/urbanairship/json/JsonValue;", "Companion", "Hold", "Swipe", "Tap", "Lcom/urbanairship/android/layout/property/PagerGesture$Hold;", "Lcom/urbanairship/android/layout/property/PagerGesture$Swipe;", "Lcom/urbanairship/android/layout/property/PagerGesture$Tap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class PagerGesture implements Identifiable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ PagerGesture(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Nullable
    public abstract JsonValue getReportingMetadata();

    private PagerGesture() {
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/urbanairship/android/layout/property/PagerGesture$Tap;", "Lcom/urbanairship/android/layout/property/PagerGesture;", "identifier", "", "reportingMetadata", "Lcom/urbanairship/json/JsonValue;", "location", "Lcom/urbanairship/android/layout/property/GestureLocation;", "behavior", "Lcom/urbanairship/android/layout/property/PagerGestureBehavior;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonValue;Lcom/urbanairship/android/layout/property/GestureLocation;Lcom/urbanairship/android/layout/property/PagerGestureBehavior;)V", "getBehavior", "()Lcom/urbanairship/android/layout/property/PagerGestureBehavior;", "getIdentifier", "()Ljava/lang/String;", "getLocation", "()Lcom/urbanairship/android/layout/property/GestureLocation;", "getReportingMetadata", "()Lcom/urbanairship/json/JsonValue;", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Tap extends PagerGesture {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final PagerGestureBehavior behavior;
        private final String identifier;
        private final GestureLocation location;
        private final JsonValue reportingMetadata;

        public static /* synthetic */ Tap copy$default(Tap tap, String str, JsonValue jsonValue, GestureLocation gestureLocation, PagerGestureBehavior pagerGestureBehavior, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tap.identifier;
            }
            if ((i & 2) != 0) {
                jsonValue = tap.reportingMetadata;
            }
            if ((i & 4) != 0) {
                gestureLocation = tap.location;
            }
            if ((i & 8) != 0) {
                pagerGestureBehavior = tap.behavior;
            }
            return tap.copy(str, jsonValue, gestureLocation, pagerGestureBehavior);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final JsonValue getReportingMetadata() {
            return this.reportingMetadata;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final GestureLocation getLocation() {
            return this.location;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final PagerGestureBehavior getBehavior() {
            return this.behavior;
        }

        @NotNull
        public final Tap copy(@NotNull String identifier, @Nullable JsonValue reportingMetadata, @NotNull GestureLocation location, @NotNull PagerGestureBehavior behavior) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(location, "location");
            Intrinsics.checkNotNullParameter(behavior, "behavior");
            return new Tap(identifier, reportingMetadata, location, behavior);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Tap)) {
                return false;
            }
            Tap tap = (Tap) other;
            return Intrinsics.areEqual(this.identifier, tap.identifier) && Intrinsics.areEqual(this.reportingMetadata, tap.reportingMetadata) && this.location == tap.location && Intrinsics.areEqual(this.behavior, tap.behavior);
        }

        public int hashCode() {
            int iHashCode = this.identifier.hashCode() * 31;
            JsonValue jsonValue = this.reportingMetadata;
            return ((((iHashCode + (jsonValue == null ? 0 : jsonValue.hashCode())) * 31) + this.location.hashCode()) * 31) + this.behavior.hashCode();
        }

        @NotNull
        public String toString() {
            return "Tap(identifier=" + this.identifier + ", reportingMetadata=" + this.reportingMetadata + ", location=" + this.location + ", behavior=" + this.behavior + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Override // com.urbanairship.android.layout.info.Identifiable
        @NotNull
        public String getIdentifier() {
            return this.identifier;
        }

        @Override // com.urbanairship.android.layout.property.PagerGesture
        @Nullable
        public JsonValue getReportingMetadata() {
            return this.reportingMetadata;
        }

        @NotNull
        public final GestureLocation getLocation() {
            return this.location;
        }

        @NotNull
        public final PagerGestureBehavior getBehavior() {
            return this.behavior;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/PagerGesture$Tap$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/property/PagerGesture$Tap;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nPagerGestures.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerGestures.kt\ncom/urbanairship/android/layout/property/PagerGesture$Tap$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,163:1\n44#2,15:164\n79#2,16:179\n44#2,15:195\n44#2,15:210\n*S KotlinDebug\n*F\n+ 1 PagerGestures.kt\ncom/urbanairship/android/layout/property/PagerGesture$Tap$Companion\n*L\n23#1:164,15\n24#1:179,16\n25#1:195,15\n26#1:210,15\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Removed duplicated region for block: B:121:0x02b0  */
            /* JADX WARN: Removed duplicated region for block: B:177:0x03f3  */
            /* JADX WARN: Removed duplicated region for block: B:237:0x0557  */
            /* JADX WARN: Removed duplicated region for block: B:243:0x059e  */
            @org.jetbrains.annotations.NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.urbanairship.android.layout.property.PagerGesture.Tap from(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r24) throws java.lang.IllegalArgumentException, com.urbanairship.json.JsonException {
                /*
                    Method dump skipped, instructions count: 1580
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.property.PagerGesture.Tap.Companion.from(com.urbanairship.json.JsonMap):com.urbanairship.android.layout.property.PagerGesture$Tap");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Tap(@NotNull String identifier, @Nullable JsonValue jsonValue, @NotNull GestureLocation location, @NotNull PagerGestureBehavior behavior) {
            super(null);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(location, "location");
            Intrinsics.checkNotNullParameter(behavior, "behavior");
            this.identifier = identifier;
            this.reportingMetadata = jsonValue;
            this.location = location;
            this.behavior = behavior;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/urbanairship/android/layout/property/PagerGesture$Swipe;", "Lcom/urbanairship/android/layout/property/PagerGesture;", "identifier", "", "reportingMetadata", "Lcom/urbanairship/json/JsonValue;", "direction", "Lcom/urbanairship/android/layout/property/GestureDirection;", "behavior", "Lcom/urbanairship/android/layout/property/PagerGestureBehavior;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonValue;Lcom/urbanairship/android/layout/property/GestureDirection;Lcom/urbanairship/android/layout/property/PagerGestureBehavior;)V", "getBehavior", "()Lcom/urbanairship/android/layout/property/PagerGestureBehavior;", "getDirection", "()Lcom/urbanairship/android/layout/property/GestureDirection;", "getIdentifier", "()Ljava/lang/String;", "getReportingMetadata", "()Lcom/urbanairship/json/JsonValue;", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Swipe extends PagerGesture {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final PagerGestureBehavior behavior;
        private final GestureDirection direction;
        private final String identifier;
        private final JsonValue reportingMetadata;

        public static /* synthetic */ Swipe copy$default(Swipe swipe, String str, JsonValue jsonValue, GestureDirection gestureDirection, PagerGestureBehavior pagerGestureBehavior, int i, Object obj) {
            if ((i & 1) != 0) {
                str = swipe.identifier;
            }
            if ((i & 2) != 0) {
                jsonValue = swipe.reportingMetadata;
            }
            if ((i & 4) != 0) {
                gestureDirection = swipe.direction;
            }
            if ((i & 8) != 0) {
                pagerGestureBehavior = swipe.behavior;
            }
            return swipe.copy(str, jsonValue, gestureDirection, pagerGestureBehavior);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final JsonValue getReportingMetadata() {
            return this.reportingMetadata;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final GestureDirection getDirection() {
            return this.direction;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final PagerGestureBehavior getBehavior() {
            return this.behavior;
        }

        @NotNull
        public final Swipe copy(@NotNull String identifier, @Nullable JsonValue reportingMetadata, @NotNull GestureDirection direction, @NotNull PagerGestureBehavior behavior) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(direction, "direction");
            Intrinsics.checkNotNullParameter(behavior, "behavior");
            return new Swipe(identifier, reportingMetadata, direction, behavior);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Swipe)) {
                return false;
            }
            Swipe swipe = (Swipe) other;
            return Intrinsics.areEqual(this.identifier, swipe.identifier) && Intrinsics.areEqual(this.reportingMetadata, swipe.reportingMetadata) && this.direction == swipe.direction && Intrinsics.areEqual(this.behavior, swipe.behavior);
        }

        public int hashCode() {
            int iHashCode = this.identifier.hashCode() * 31;
            JsonValue jsonValue = this.reportingMetadata;
            return ((((iHashCode + (jsonValue == null ? 0 : jsonValue.hashCode())) * 31) + this.direction.hashCode()) * 31) + this.behavior.hashCode();
        }

        @NotNull
        public String toString() {
            return "Swipe(identifier=" + this.identifier + ", reportingMetadata=" + this.reportingMetadata + ", direction=" + this.direction + ", behavior=" + this.behavior + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Override // com.urbanairship.android.layout.info.Identifiable
        @NotNull
        public String getIdentifier() {
            return this.identifier;
        }

        @Override // com.urbanairship.android.layout.property.PagerGesture
        @Nullable
        public JsonValue getReportingMetadata() {
            return this.reportingMetadata;
        }

        @NotNull
        public final GestureDirection getDirection() {
            return this.direction;
        }

        @NotNull
        public final PagerGestureBehavior getBehavior() {
            return this.behavior;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/PagerGesture$Swipe$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/property/PagerGesture$Swipe;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nPagerGestures.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerGestures.kt\ncom/urbanairship/android/layout/property/PagerGesture$Swipe$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,163:1\n44#2,15:164\n79#2,16:179\n44#2,15:195\n44#2,15:210\n*S KotlinDebug\n*F\n+ 1 PagerGestures.kt\ncom/urbanairship/android/layout/property/PagerGesture$Swipe$Companion\n*L\n39#1:164,15\n40#1:179,16\n41#1:195,15\n42#1:210,15\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Removed duplicated region for block: B:121:0x02b0  */
            /* JADX WARN: Removed duplicated region for block: B:177:0x03f3  */
            /* JADX WARN: Removed duplicated region for block: B:237:0x0557  */
            /* JADX WARN: Removed duplicated region for block: B:243:0x059e  */
            @org.jetbrains.annotations.NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.urbanairship.android.layout.property.PagerGesture.Swipe from(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r24) throws java.lang.IllegalArgumentException, com.urbanairship.json.JsonException {
                /*
                    Method dump skipped, instructions count: 1580
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.property.PagerGesture.Swipe.Companion.from(com.urbanairship.json.JsonMap):com.urbanairship.android.layout.property.PagerGesture$Swipe");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Swipe(@NotNull String identifier, @Nullable JsonValue jsonValue, @NotNull GestureDirection direction, @NotNull PagerGestureBehavior behavior) {
            super(null);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(direction, "direction");
            Intrinsics.checkNotNullParameter(behavior, "behavior");
            this.identifier = identifier;
            this.reportingMetadata = jsonValue;
            this.direction = direction;
            this.behavior = behavior;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/urbanairship/android/layout/property/PagerGesture$Hold;", "Lcom/urbanairship/android/layout/property/PagerGesture;", "identifier", "", "reportingMetadata", "Lcom/urbanairship/json/JsonValue;", "pressBehavior", "Lcom/urbanairship/android/layout/property/PagerGestureBehavior;", "releaseBehavior", "(Ljava/lang/String;Lcom/urbanairship/json/JsonValue;Lcom/urbanairship/android/layout/property/PagerGestureBehavior;Lcom/urbanairship/android/layout/property/PagerGestureBehavior;)V", "getIdentifier", "()Ljava/lang/String;", "getPressBehavior", "()Lcom/urbanairship/android/layout/property/PagerGestureBehavior;", "getReleaseBehavior", "getReportingMetadata", "()Lcom/urbanairship/json/JsonValue;", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Hold extends PagerGesture {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final String identifier;
        private final PagerGestureBehavior pressBehavior;
        private final PagerGestureBehavior releaseBehavior;
        private final JsonValue reportingMetadata;

        public static /* synthetic */ Hold copy$default(Hold hold, String str, JsonValue jsonValue, PagerGestureBehavior pagerGestureBehavior, PagerGestureBehavior pagerGestureBehavior2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = hold.identifier;
            }
            if ((i & 2) != 0) {
                jsonValue = hold.reportingMetadata;
            }
            if ((i & 4) != 0) {
                pagerGestureBehavior = hold.pressBehavior;
            }
            if ((i & 8) != 0) {
                pagerGestureBehavior2 = hold.releaseBehavior;
            }
            return hold.copy(str, jsonValue, pagerGestureBehavior, pagerGestureBehavior2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final JsonValue getReportingMetadata() {
            return this.reportingMetadata;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final PagerGestureBehavior getPressBehavior() {
            return this.pressBehavior;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final PagerGestureBehavior getReleaseBehavior() {
            return this.releaseBehavior;
        }

        @NotNull
        public final Hold copy(@NotNull String identifier, @Nullable JsonValue reportingMetadata, @NotNull PagerGestureBehavior pressBehavior, @NotNull PagerGestureBehavior releaseBehavior) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(pressBehavior, "pressBehavior");
            Intrinsics.checkNotNullParameter(releaseBehavior, "releaseBehavior");
            return new Hold(identifier, reportingMetadata, pressBehavior, releaseBehavior);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Hold)) {
                return false;
            }
            Hold hold = (Hold) other;
            return Intrinsics.areEqual(this.identifier, hold.identifier) && Intrinsics.areEqual(this.reportingMetadata, hold.reportingMetadata) && Intrinsics.areEqual(this.pressBehavior, hold.pressBehavior) && Intrinsics.areEqual(this.releaseBehavior, hold.releaseBehavior);
        }

        public int hashCode() {
            int iHashCode = this.identifier.hashCode() * 31;
            JsonValue jsonValue = this.reportingMetadata;
            return ((((iHashCode + (jsonValue == null ? 0 : jsonValue.hashCode())) * 31) + this.pressBehavior.hashCode()) * 31) + this.releaseBehavior.hashCode();
        }

        @NotNull
        public String toString() {
            return "Hold(identifier=" + this.identifier + ", reportingMetadata=" + this.reportingMetadata + ", pressBehavior=" + this.pressBehavior + ", releaseBehavior=" + this.releaseBehavior + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Override // com.urbanairship.android.layout.info.Identifiable
        @NotNull
        public String getIdentifier() {
            return this.identifier;
        }

        @Override // com.urbanairship.android.layout.property.PagerGesture
        @Nullable
        public JsonValue getReportingMetadata() {
            return this.reportingMetadata;
        }

        @NotNull
        public final PagerGestureBehavior getPressBehavior() {
            return this.pressBehavior;
        }

        @NotNull
        public final PagerGestureBehavior getReleaseBehavior() {
            return this.releaseBehavior;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/PagerGesture$Hold$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/property/PagerGesture$Hold;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nPagerGestures.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerGestures.kt\ncom/urbanairship/android/layout/property/PagerGesture$Hold$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,163:1\n44#2,15:164\n79#2,16:179\n44#2,15:195\n44#2,15:210\n*S KotlinDebug\n*F\n+ 1 PagerGestures.kt\ncom/urbanairship/android/layout/property/PagerGesture$Hold$Companion\n*L\n55#1:164,15\n56#1:179,16\n57#1:195,15\n58#1:210,15\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Removed duplicated region for block: B:120:0x02af  */
            /* JADX WARN: Removed duplicated region for block: B:179:0x03f6  */
            /* JADX WARN: Removed duplicated region for block: B:239:0x0556  */
            /* JADX WARN: Removed duplicated region for block: B:245:0x059e  */
            @org.jetbrains.annotations.NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.urbanairship.android.layout.property.PagerGesture.Hold from(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r27) throws com.urbanairship.json.JsonException {
                /*
                    Method dump skipped, instructions count: 1577
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.property.PagerGesture.Hold.Companion.from(com.urbanairship.json.JsonMap):com.urbanairship.android.layout.property.PagerGesture$Hold");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Hold(@NotNull String identifier, @Nullable JsonValue jsonValue, @NotNull PagerGestureBehavior pressBehavior, @NotNull PagerGestureBehavior releaseBehavior) {
            super(null);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(pressBehavior, "pressBehavior");
            Intrinsics.checkNotNullParameter(releaseBehavior, "releaseBehavior");
            this.identifier = identifier;
            this.reportingMetadata = jsonValue;
            this.pressBehavior = pressBehavior;
            this.releaseBehavior = releaseBehavior;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0005\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/urbanairship/android/layout/property/PagerGesture$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/property/PagerGesture;", "json", "Lcom/urbanairship/json/JsonMap;", "fromList", "", "Lcom/urbanairship/json/JsonList;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPagerGestures.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerGestures.kt\ncom/urbanairship/android/layout/property/PagerGesture$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,163:1\n44#2,15:164\n1549#3:179\n1620#3,3:180\n*S KotlinDebug\n*F\n+ 1 PagerGestures.kt\ncom/urbanairship/android/layout/property/PagerGesture$Companion\n*L\n66#1:164,15\n75#1:179\n75#1:180,3\n*E\n"})
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[GestureType.values().length];
                try {
                    iArr[GestureType.TAP.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[GestureType.SWIPE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[GestureType.HOLD.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final PagerGesture from(@NotNull JsonMap json) throws IllegalArgumentException, JsonException {
            String strOptString;
            Intrinsics.checkNotNullParameter(json, "json");
            GestureType.Companion companion = GestureType.INSTANCE;
            JsonValue jsonValue = json.get("type");
            if (jsonValue == null) {
                throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString = jsonValue.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList = jsonValue.optList();
                if (objOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap = jsonValue.optMap();
                if (objOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue2 = jsonValue.getJsonValue();
                if (jsonValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue2;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[companion.from(strOptString).ordinal()];
            if (i == 1) {
                return Tap.INSTANCE.from(json);
            }
            if (i == 2) {
                return Swipe.INSTANCE.from(json);
            }
            if (i == 3) {
                return Hold.INSTANCE.from(json);
            }
            throw new NoWhenBranchMatchedException();
        }

        @NotNull
        public final List<PagerGesture> fromList(@NotNull JsonList json) throws JsonException {
            Intrinsics.checkNotNullParameter(json, "json");
            if (json.isEmpty()) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(json, 10));
            for (JsonValue jsonValue : json) {
                Companion companion = PagerGesture.INSTANCE;
                JsonMap jsonMapOptMap = jsonValue.optMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
                arrayList.add(companion.from(jsonMapOptMap));
            }
            return arrayList;
        }
    }
}
