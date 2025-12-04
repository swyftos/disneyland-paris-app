package com.urbanairship.android.layout.environment;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.preferencecenter.data.PreferenceCenterPayload;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/urbanairship/android/layout/environment/FormType;", "", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "toString", "Form", "Nps", "Lcom/urbanairship/android/layout/environment/FormType$Form;", "Lcom/urbanairship/android/layout/environment/FormType$Nps;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class FormType {
    private final String value;

    public /* synthetic */ FormType(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private FormType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/environment/FormType$Form;", "Lcom/urbanairship/android/layout/environment/FormType;", "()V", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Form extends FormType {

        @NotNull
        public static final Form INSTANCE = new Form();

        private Form() {
            super(PreferenceCenterPayload.KEY_FORM, null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/android/layout/environment/FormType$Nps;", "Lcom/urbanairship/android/layout/environment/FormType;", "scoreId", "", "(Ljava/lang/String;)V", "getScoreId", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Nps extends FormType {
        private final String scoreId;

        public static /* synthetic */ Nps copy$default(Nps nps, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = nps.scoreId;
            }
            return nps.copy(str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getScoreId() {
            return this.scoreId;
        }

        @NotNull
        public final Nps copy(@NotNull String scoreId) {
            Intrinsics.checkNotNullParameter(scoreId, "scoreId");
            return new Nps(scoreId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Nps) && Intrinsics.areEqual(this.scoreId, ((Nps) other).scoreId);
        }

        public int hashCode() {
            return this.scoreId.hashCode();
        }

        @Override // com.urbanairship.android.layout.environment.FormType
        @NotNull
        public String toString() {
            return "Nps(scoreId=" + this.scoreId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Nps(@NotNull String scoreId) {
            super("nps", null);
            Intrinsics.checkNotNullParameter(scoreId, "scoreId");
            this.scoreId = scoreId;
        }

        @NotNull
        public final String getScoreId() {
            return this.scoreId;
        }
    }

    @NotNull
    public String toString() {
        return this.value;
    }
}
