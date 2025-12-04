package com.urbanairship.android.layout.info;

import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonPredicate;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007B\u0019\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\rJ,\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0015\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/android/layout/info/ViewPropertyOverride;", ExifInterface.GPS_DIRECTION_TRUE, "", "json", "Lcom/urbanairship/json/JsonValue;", "valueParser", "Lkotlin/Function1;", "(Lcom/urbanairship/json/JsonValue;Lkotlin/jvm/functions/Function1;)V", "whenStateMatcher", "Lcom/urbanairship/json/JsonPredicate;", "value", "(Lcom/urbanairship/json/JsonPredicate;Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getWhenStateMatcher", "()Lcom/urbanairship/json/JsonPredicate;", "component1", "component2", "copy", "(Lcom/urbanairship/json/JsonPredicate;Ljava/lang/Object;)Lcom/urbanairship/android/layout/info/ViewPropertyOverride;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/ViewPropertyOverride\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,944:1\n1#2:945\n*E\n"})
/* loaded from: classes5.dex */
public final /* data */ class ViewPropertyOverride<T> {
    private final Object value;
    private final JsonPredicate whenStateMatcher;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertyOverride copy$default(ViewPropertyOverride viewPropertyOverride, JsonPredicate jsonPredicate, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            jsonPredicate = viewPropertyOverride.whenStateMatcher;
        }
        if ((i & 2) != 0) {
            obj = viewPropertyOverride.value;
        }
        return viewPropertyOverride.copy(jsonPredicate, obj);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final JsonPredicate getWhenStateMatcher() {
        return this.whenStateMatcher;
    }

    @Nullable
    public final T component2() {
        return (T) this.value;
    }

    @NotNull
    public final ViewPropertyOverride<T> copy(@Nullable JsonPredicate whenStateMatcher, @Nullable T value) {
        return new ViewPropertyOverride<>(whenStateMatcher, value);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewPropertyOverride)) {
            return false;
        }
        ViewPropertyOverride viewPropertyOverride = (ViewPropertyOverride) other;
        return Intrinsics.areEqual(this.whenStateMatcher, viewPropertyOverride.whenStateMatcher) && Intrinsics.areEqual(this.value, viewPropertyOverride.value);
    }

    public int hashCode() {
        JsonPredicate jsonPredicate = this.whenStateMatcher;
        int iHashCode = (jsonPredicate == null ? 0 : jsonPredicate.hashCode()) * 31;
        Object obj = this.value;
        return iHashCode + (obj != null ? obj.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ViewPropertyOverride(whenStateMatcher=" + this.whenStateMatcher + ", value=" + this.value + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ViewPropertyOverride(@Nullable JsonPredicate jsonPredicate, @Nullable T t) {
        this.whenStateMatcher = jsonPredicate;
        this.value = t;
    }

    @Nullable
    public final JsonPredicate getWhenStateMatcher() {
        return this.whenStateMatcher;
    }

    @Nullable
    public final T getValue() {
        return (T) this.value;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ViewPropertyOverride(@NotNull JsonValue json, @NotNull Function1<? super JsonValue, ? extends T> valueParser) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(valueParser, "valueParser");
        JsonValue jsonValue = json.requireMap().get("when_state_matches");
        JsonPredicate jsonPredicate = jsonValue != null ? JsonPredicate.parse(jsonValue) : null;
        JsonValue jsonValue2 = json.requireMap().get("value");
        this(jsonPredicate, jsonValue2 != null ? valueParser.invoke(jsonValue2) : null);
    }
}
