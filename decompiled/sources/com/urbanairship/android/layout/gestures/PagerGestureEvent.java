package com.urbanairship.android.layout.gestures;

import ch.qos.logback.core.CoreConstants;
import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.android.layout.property.GestureDirection;
import com.urbanairship.android.layout.property.GestureLocation;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/urbanairship/android/layout/gestures/PagerGestureEvent;", "", "()V", "Hold", "Swipe", "Tap", "Lcom/urbanairship/android/layout/gestures/PagerGestureEvent$Hold;", "Lcom/urbanairship/android/layout/gestures/PagerGestureEvent$Swipe;", "Lcom/urbanairship/android/layout/gestures/PagerGestureEvent$Tap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class PagerGestureEvent {
    public /* synthetic */ PagerGestureEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/android/layout/gestures/PagerGestureEvent$Tap;", "Lcom/urbanairship/android/layout/gestures/PagerGestureEvent;", "location", "Lcom/urbanairship/android/layout/property/GestureLocation;", "(Lcom/urbanairship/android/layout/property/GestureLocation;)V", "getLocation", "()Lcom/urbanairship/android/layout/property/GestureLocation;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Tap extends PagerGestureEvent {
        private final GestureLocation location;

        public static /* synthetic */ Tap copy$default(Tap tap, GestureLocation gestureLocation, int i, Object obj) {
            if ((i & 1) != 0) {
                gestureLocation = tap.location;
            }
            return tap.copy(gestureLocation);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final GestureLocation getLocation() {
            return this.location;
        }

        @NotNull
        public final Tap copy(@NotNull GestureLocation location) {
            Intrinsics.checkNotNullParameter(location, "location");
            return new Tap(location);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Tap) && this.location == ((Tap) other).location;
        }

        public int hashCode() {
            return this.location.hashCode();
        }

        @NotNull
        public String toString() {
            return "Tap(location=" + this.location + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Tap(@NotNull GestureLocation location) {
            super(null);
            Intrinsics.checkNotNullParameter(location, "location");
            this.location = location;
        }

        @NotNull
        public final GestureLocation getLocation() {
            return this.location;
        }
    }

    private PagerGestureEvent() {
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/android/layout/gestures/PagerGestureEvent$Hold;", "Lcom/urbanairship/android/layout/gestures/PagerGestureEvent;", "action", "Lcom/urbanairship/android/layout/gestures/PagerGestureEvent$Hold$Action;", "(Lcom/urbanairship/android/layout/gestures/PagerGestureEvent$Hold$Action;)V", "getAction", "()Lcom/urbanairship/android/layout/gestures/PagerGestureEvent$Hold$Action;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", JsonDocumentFields.ACTION, "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Hold extends PagerGestureEvent {
        private final Action action;

        public static /* synthetic */ Hold copy$default(Hold hold, Action action, int i, Object obj) {
            if ((i & 1) != 0) {
                action = hold.action;
            }
            return hold.copy(action);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final Action getAction() {
            return this.action;
        }

        @NotNull
        public final Hold copy(@NotNull Action action) {
            Intrinsics.checkNotNullParameter(action, "action");
            return new Hold(action);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Hold) && this.action == ((Hold) other).action;
        }

        public int hashCode() {
            return this.action.hashCode();
        }

        @NotNull
        public String toString() {
            return "Hold(action=" + this.action + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/urbanairship/android/layout/gestures/PagerGestureEvent$Hold$Action;", "", "(Ljava/lang/String;I)V", "PRESS", "RELEASE", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Action {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Action[] $VALUES;
            public static final Action PRESS = new Action("PRESS", 0);
            public static final Action RELEASE = new Action("RELEASE", 1);

            private static final /* synthetic */ Action[] $values() {
                return new Action[]{PRESS, RELEASE};
            }

            @NotNull
            public static EnumEntries<Action> getEntries() {
                return $ENTRIES;
            }

            public static Action valueOf(String str) {
                return (Action) Enum.valueOf(Action.class, str);
            }

            public static Action[] values() {
                return (Action[]) $VALUES.clone();
            }

            static {
                Action[] actionArr$values = $values();
                $VALUES = actionArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(actionArr$values);
            }

            private Action(String str, int i) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Hold(@NotNull Action action) {
            super(null);
            Intrinsics.checkNotNullParameter(action, "action");
            this.action = action;
        }

        @NotNull
        public final Action getAction() {
            return this.action;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/android/layout/gestures/PagerGestureEvent$Swipe;", "Lcom/urbanairship/android/layout/gestures/PagerGestureEvent;", "direction", "Lcom/urbanairship/android/layout/property/GestureDirection;", "(Lcom/urbanairship/android/layout/property/GestureDirection;)V", "getDirection", "()Lcom/urbanairship/android/layout/property/GestureDirection;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Swipe extends PagerGestureEvent {
        private final GestureDirection direction;

        public static /* synthetic */ Swipe copy$default(Swipe swipe, GestureDirection gestureDirection, int i, Object obj) {
            if ((i & 1) != 0) {
                gestureDirection = swipe.direction;
            }
            return swipe.copy(gestureDirection);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final GestureDirection getDirection() {
            return this.direction;
        }

        @NotNull
        public final Swipe copy(@NotNull GestureDirection direction) {
            Intrinsics.checkNotNullParameter(direction, "direction");
            return new Swipe(direction);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Swipe) && this.direction == ((Swipe) other).direction;
        }

        public int hashCode() {
            return this.direction.hashCode();
        }

        @NotNull
        public String toString() {
            return "Swipe(direction=" + this.direction + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Swipe(@NotNull GestureDirection direction) {
            super(null);
            Intrinsics.checkNotNullParameter(direction, "direction");
            this.direction = direction;
        }

        @NotNull
        public final GestureDirection getDirection() {
            return this.direction;
        }
    }
}
