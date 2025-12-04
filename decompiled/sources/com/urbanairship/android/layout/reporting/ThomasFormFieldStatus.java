package com.urbanairship.android.layout.reporting;

import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.ETCPurchaseStatus;
import com.urbanairship.android.layout.reporting.ThomasFormField;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u0010*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0005\u0010\u0011\u0012\u0013\u0014B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006\u0082\u0001\u0004\u0015\u0016\u000b\u0017¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "isError", "", "()Z", "isInvalid", "isPending", "isValid", "makePending", "Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus$Pending;", "toJson", "Lcom/urbanairship/json/JsonValue;", "type", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$Type;", "Companion", "Error", "Invalid", "Pending", "Valid", "Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus$Error;", "Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus$Invalid;", "Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus$Valid;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ThomasFormFieldStatus<T> {
    private static final Companion Companion = new Companion(null);

    public /* synthetic */ ThomasFormFieldStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004HÆ\u0003J\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus$Valid;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus;", "result", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$Result;", "(Lcom/urbanairship/android/layout/reporting/ThomasFormField$Result;)V", "getResult", "()Lcom/urbanairship/android/layout/reporting/ThomasFormField$Result;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Valid<T> extends ThomasFormFieldStatus<T> {
        private final ThomasFormField.Result result;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Valid copy$default(Valid valid, ThomasFormField.Result result, int i, Object obj) {
            if ((i & 1) != 0) {
                result = valid.result;
            }
            return valid.copy(result);
        }

        @NotNull
        public final ThomasFormField.Result<T> component1() {
            return this.result;
        }

        @NotNull
        public final Valid<T> copy(@NotNull ThomasFormField.Result<T> result) {
            Intrinsics.checkNotNullParameter(result, "result");
            return new Valid<>(result);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Valid) && Intrinsics.areEqual(this.result, ((Valid) other).result);
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        @NotNull
        public String toString() {
            return "Valid(result=" + this.result + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Valid(@NotNull ThomasFormField.Result<T> result) {
            super(null);
            Intrinsics.checkNotNullParameter(result, "result");
            this.result = result;
        }

        @NotNull
        public final ThomasFormField.Result<T> getResult() {
            return this.result;
        }
    }

    private ThomasFormFieldStatus() {
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus$Invalid;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus;", "()V", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Invalid<T> extends ThomasFormFieldStatus<T> {
        public Invalid() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus$Pending;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus;", "()V", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Pending<T> extends ThomasFormFieldStatus<T> {
        public Pending() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus$Error;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus;", "()V", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Error<T> extends ThomasFormFieldStatus<T> {
        public Error() {
            super(null);
        }
    }

    public final boolean isPending() {
        return this instanceof Pending;
    }

    public final boolean isValid() {
        return this instanceof Valid;
    }

    public final boolean isError() {
        return this instanceof Error;
    }

    public final boolean isInvalid() {
        return this instanceof Invalid;
    }

    @NotNull
    public final Pending<T> makePending() {
        return new Pending<>();
    }

    @NotNull
    public final JsonValue toJson(@NotNull ThomasFormField.Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        JsonMap.Builder builderNewBuilder = JsonMap.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder(...)");
        if (this instanceof Error) {
            builderNewBuilder.put("type", Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        } else if (this instanceof Invalid) {
            builderNewBuilder.put("type", com.facebook.hermes.intl.Constants.COLLATION_INVALID);
        } else if (this instanceof Pending) {
            builderNewBuilder.put("type", ETCPurchaseStatus.PENDING);
        } else if (this instanceof Valid) {
            builderNewBuilder.put("type", "valid");
            builderNewBuilder.put("result", JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", type), TuplesKt.to("value", JsonValue.wrap(((Valid) this).getResult().getValue()))));
        }
        JsonValue jsonValue = builderNewBuilder.build().getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
