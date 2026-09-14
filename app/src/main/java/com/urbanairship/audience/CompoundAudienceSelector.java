package com.urbanairship.audience;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonPredicate;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00102\u00020\u0001:\u0006\u000e\u000f\u0010\u0011\u0012\u0013B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016\u0082\u0001\u0004\u0014\u0015\u0016\u0017¨\u0006\u0018"}, m1836d2 = {"Lcom/urbanairship/audience/CompoundAudienceSelector;", "Lcom/urbanairship/json/JsonSerializable;", "()V", "evaluate", "Lcom/urbanairship/audience/AirshipDeviceAudienceResult;", "newEvaluationDate", "", "infoProvider", "Lcom/urbanairship/audience/DeviceInfoProvider;", "hashChecker", "Lcom/urbanairship/audience/HashChecker;", "(JLcom/urbanairship/audience/DeviceInfoProvider;Lcom/urbanairship/audience/HashChecker;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "And", "Atomic", "Companion", "Not", "Or", "SelectorType", "Lcom/urbanairship/audience/CompoundAudienceSelector$And;", "Lcom/urbanairship/audience/CompoundAudienceSelector$Atomic;", "Lcom/urbanairship/audience/CompoundAudienceSelector$Not;", "Lcom/urbanairship/audience/CompoundAudienceSelector$Or;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class CompoundAudienceSelector implements JsonSerializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.urbanairship.audience.CompoundAudienceSelector$evaluate$1 */
    static final class C49601 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C49601(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CompoundAudienceSelector.this.evaluate(0L, null, null, this);
        }
    }

    public /* synthetic */ CompoundAudienceSelector(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CompoundAudienceSelector() {
    }

    @Metadata(m1835d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m1836d2 = {"Lcom/urbanairship/audience/CompoundAudienceSelector$Atomic;", "Lcom/urbanairship/audience/CompoundAudienceSelector;", "audience", "Lcom/urbanairship/audience/AudienceSelector;", "(Lcom/urbanairship/audience/AudienceSelector;)V", "getAudience", "()Lcom/urbanairship/audience/AudienceSelector;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final /* data */ class Atomic extends CompoundAudienceSelector {
        private final AudienceSelector audience;

        public static /* synthetic */ Atomic copy$default(Atomic atomic, AudienceSelector audienceSelector, int i, Object obj) {
            if ((i & 1) != 0) {
                audienceSelector = atomic.audience;
            }
            return atomic.copy(audienceSelector);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AudienceSelector getAudience() {
            return this.audience;
        }

        @NotNull
        public final Atomic copy(@NotNull AudienceSelector audience) {
            Intrinsics.checkNotNullParameter(audience, "audience");
            return new Atomic(audience);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Atomic) && Intrinsics.areEqual(this.audience, ((Atomic) other).audience);
        }

        public int hashCode() {
            return this.audience.hashCode();
        }

        @NotNull
        public String toString() {
            return "Atomic(audience=" + this.audience + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Atomic(@NotNull AudienceSelector audience) {
            super(null);
            Intrinsics.checkNotNullParameter(audience, "audience");
            this.audience = audience;
        }

        @NotNull
        public final AudienceSelector getAudience() {
            return this.audience;
        }
    }

    @Metadata(m1835d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\t\u0010\u0006\u001a\u00020\u0001HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, m1836d2 = {"Lcom/urbanairship/audience/CompoundAudienceSelector$Not;", "Lcom/urbanairship/audience/CompoundAudienceSelector;", "selector", "(Lcom/urbanairship/audience/CompoundAudienceSelector;)V", "getSelector", "()Lcom/urbanairship/audience/CompoundAudienceSelector;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final /* data */ class Not extends CompoundAudienceSelector {
        private final CompoundAudienceSelector selector;

        public static /* synthetic */ Not copy$default(Not not, CompoundAudienceSelector compoundAudienceSelector, int i, Object obj) {
            if ((i & 1) != 0) {
                compoundAudienceSelector = not.selector;
            }
            return not.copy(compoundAudienceSelector);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CompoundAudienceSelector getSelector() {
            return this.selector;
        }

        @NotNull
        public final Not copy(@NotNull CompoundAudienceSelector selector) {
            Intrinsics.checkNotNullParameter(selector, "selector");
            return new Not(selector);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Not) && Intrinsics.areEqual(this.selector, ((Not) other).selector);
        }

        public int hashCode() {
            return this.selector.hashCode();
        }

        @NotNull
        public String toString() {
            return "Not(selector=" + this.selector + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Not(@NotNull CompoundAudienceSelector selector) {
            super(null);
            Intrinsics.checkNotNullParameter(selector, "selector");
            this.selector = selector;
        }

        @NotNull
        public final CompoundAudienceSelector getSelector() {
            return this.selector;
        }
    }

    @Metadata(m1835d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\u0019\u0010\b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m1836d2 = {"Lcom/urbanairship/audience/CompoundAudienceSelector$And;", "Lcom/urbanairship/audience/CompoundAudienceSelector;", "selectors", "", "(Ljava/util/List;)V", "getSelectors", "()Ljava/util/List;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final /* data */ class And extends CompoundAudienceSelector {
        private final List selectors;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ And copy$default(And and, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = and.selectors;
            }
            return and.copy(list);
        }

        @NotNull
        public final List<CompoundAudienceSelector> component1() {
            return this.selectors;
        }

        @NotNull
        public final And copy(@NotNull List<? extends CompoundAudienceSelector> selectors) {
            Intrinsics.checkNotNullParameter(selectors, "selectors");
            return new And(selectors);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof And) && Intrinsics.areEqual(this.selectors, ((And) other).selectors);
        }

        public int hashCode() {
            return this.selectors.hashCode();
        }

        @NotNull
        public String toString() {
            return "And(selectors=" + this.selectors + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public And(@NotNull List<? extends CompoundAudienceSelector> selectors) {
            super(null);
            Intrinsics.checkNotNullParameter(selectors, "selectors");
            this.selectors = selectors;
        }

        @NotNull
        public final List<CompoundAudienceSelector> getSelectors() {
            return this.selectors;
        }
    }

    @Metadata(m1835d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\u0019\u0010\b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m1836d2 = {"Lcom/urbanairship/audience/CompoundAudienceSelector$Or;", "Lcom/urbanairship/audience/CompoundAudienceSelector;", "selectors", "", "(Ljava/util/List;)V", "getSelectors", "()Ljava/util/List;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final /* data */ class Or extends CompoundAudienceSelector {
        private final List selectors;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Or copy$default(Or or, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = or.selectors;
            }
            return or.copy(list);
        }

        @NotNull
        public final List<CompoundAudienceSelector> component1() {
            return this.selectors;
        }

        @NotNull
        public final Or copy(@NotNull List<? extends CompoundAudienceSelector> selectors) {
            Intrinsics.checkNotNullParameter(selectors, "selectors");
            return new Or(selectors);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Or) && Intrinsics.areEqual(this.selectors, ((Or) other).selectors);
        }

        public int hashCode() {
            return this.selectors.hashCode();
        }

        @NotNull
        public String toString() {
            return "Or(selectors=" + this.selectors + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Or(@NotNull List<? extends CompoundAudienceSelector> selectors) {
            super(null);
            Intrinsics.checkNotNullParameter(selectors, "selectors");
            this.selectors = selectors;
        }

        @NotNull
        public final List<CompoundAudienceSelector> getSelectors() {
            return this.selectors;
        }
    }

    private enum SelectorType implements JsonSerializable {
        ATOMIC("atomic"),
        NOT(JsonPredicate.NOT_PREDICATE_TYPE),
        AND(JsonPredicate.AND_PREDICATE_TYPE),
        OR(JsonPredicate.OR_PREDICATE_TYPE);

        private final String jsonValue;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        public static final Companion Companion = new Companion(null);

        public static EnumEntries getEntries() {
            return $ENTRIES;
        }

        SelectorType(String str) {
            this.jsonValue = str;
        }

        public final String getJsonValue() {
            return this.jsonValue;
        }

        @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/audience/CompoundAudienceSelector$SelectorType$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/audience/CompoundAudienceSelector$SelectorType;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
        @SourceDebugExtension({"SMAP\nCompoundAudienceSelector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompoundAudienceSelector.kt\ncom/urbanairship/audience/CompoundAudienceSelector$SelectorType$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,179:1\n288#2,2:180\n*S KotlinDebug\n*F\n+ 1 CompoundAudienceSelector.kt\ncom/urbanairship/audience/CompoundAudienceSelector$SelectorType$Companion\n*L\n59#1:180,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final SelectorType fromJson(@NotNull JsonValue value) throws JsonException {
                Object next;
                Intrinsics.checkNotNullParameter(value, "value");
                String strRequireString = value.requireString();
                Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                Iterator<E> it = SelectorType.getEntries().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((SelectorType) next).getJsonValue(), strRequireString));
                SelectorType selectorType = (SelectorType) next;
                if (selectorType != null) {
                    return selectorType;
                }
                throw new JsonException("Invalid button layout " + strRequireString);
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        /* JADX INFO: renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValueWrap = JsonValue.wrap(this.jsonValue);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            return jsonValueWrap;
        }
    }

    @Metadata(m1835d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1836d2 = {"Lcom/urbanairship/audience/CompoundAudienceSelector$Companion;", "", "()V", "AUDIENCE", "", "SELECTOR", "SELECTORS", "TYPE", "combine", "Lcom/urbanairship/audience/CompoundAudienceSelector;", "compoundAudienceSelector", "deviceAudience", "Lcom/urbanairship/audience/AudienceSelector;", "fromJson", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nCompoundAudienceSelector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompoundAudienceSelector.kt\ncom/urbanairship/audience/CompoundAudienceSelector$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,179:1\n1549#2:180\n1620#2,3:181\n1549#2:184\n1620#2,3:185\n*S KotlinDebug\n*F\n+ 1 CompoundAudienceSelector.kt\ncom/urbanairship/audience/CompoundAudienceSelector$Companion\n*L\n81#1:180\n81#1:181,3\n82#1:184\n82#1:185,3\n*E\n"})
    public static final class Companion {

        @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SelectorType.values().length];
                try {
                    iArr[SelectorType.ATOMIC.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SelectorType.NOT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SelectorType.AND.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[SelectorType.OR.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
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
        public final CompoundAudienceSelector fromJson(@NotNull JsonValue value) throws JsonException {
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            SelectorType.Companion companion = SelectorType.Companion;
            JsonValue jsonValueRequire = jsonMapRequireMap.require("type");
            Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
            int i = WhenMappings.$EnumSwitchMapping$0[companion.fromJson(jsonValueRequire).ordinal()];
            if (i == 1) {
                AudienceSelector.Companion companion2 = AudienceSelector.INSTANCE;
                JsonValue jsonValueRequire2 = jsonMapRequireMap.require("audience");
                Intrinsics.checkNotNullExpressionValue(jsonValueRequire2, "require(...)");
                return new Atomic(companion2.fromJson(jsonValueRequire2));
            }
            if (i == 2) {
                JsonValue jsonValueRequire3 = jsonMapRequireMap.require("selector");
                Intrinsics.checkNotNullExpressionValue(jsonValueRequire3, "require(...)");
                return new Not(fromJson(jsonValueRequire3));
            }
            if (i == 3) {
                JsonList jsonListRequireList = JsonExtensionsKt.requireList(jsonMapRequireMap, "selectors");
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
                Iterator<JsonValue> it = jsonListRequireList.iterator();
                while (it.hasNext()) {
                    arrayList.add(fromJson(it.next()));
                }
                return new And(arrayList);
            }
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            JsonList jsonListRequireList2 = JsonExtensionsKt.requireList(jsonMapRequireMap, "selectors");
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList2, 10));
            Iterator<JsonValue> it2 = jsonListRequireList2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(fromJson(it2.next()));
            }
            return new Or(arrayList2);
        }

        @Nullable
        public final CompoundAudienceSelector combine(@Nullable CompoundAudienceSelector compoundAudienceSelector, @Nullable AudienceSelector deviceAudience) {
            if (compoundAudienceSelector != null && deviceAudience != null) {
                return new And(CollectionsKt.listOf((Object[]) new CompoundAudienceSelector[]{new Atomic(deviceAudience), compoundAudienceSelector}));
            }
            if (compoundAudienceSelector != null) {
                return compoundAudienceSelector;
            }
            if (deviceAudience != null) {
                return new Atomic(deviceAudience);
            }
            return null;
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* JADX INFO: renamed from: toJsonValue */
    public JsonValue getJsonValue() throws JsonException {
        JsonMap jsonMapJsonMapOf;
        if (this instanceof And) {
            jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("type", SelectorType.AND), TuplesKt.m1842to("selectors", ((And) this).getSelectors()));
        } else if (this instanceof Atomic) {
            jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("type", SelectorType.ATOMIC), TuplesKt.m1842to("audience", ((Atomic) this).getAudience()));
        } else if (this instanceof Not) {
            jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("type", SelectorType.NOT), TuplesKt.m1842to("selector", ((Not) this).getSelector()));
        } else if (this instanceof Or) {
            jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("type", SelectorType.OR), TuplesKt.m1842to("selectors", ((Or) this).getSelectors()));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        JsonValue jsonValue = jsonMapJsonMapOf.getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    /* JADX WARN: Code duplicated, block: B:57:0x0147 A[PHI: r0 r3 r5 r6 r7
  0x0147: PHI (r0v23 long) = (r0v5 long), (r0v24 long) binds: [B:56:0x0134, B:63:0x0176] A[DONT_GENERATE, DONT_INLINE]
  0x0147: PHI (r3v7 com.urbanairship.audience.DeviceInfoProvider) = (r3v1 com.urbanairship.audience.DeviceInfoProvider), (r3v8 com.urbanairship.audience.DeviceInfoProvider) binds: [B:56:0x0134, B:63:0x0176] A[DONT_GENERATE, DONT_INLINE]
  0x0147: PHI (r5v2 com.urbanairship.audience.HashChecker) = (r5v1 com.urbanairship.audience.HashChecker), (r5v3 com.urbanairship.audience.HashChecker) binds: [B:56:0x0134, B:63:0x0176] A[DONT_GENERATE, DONT_INLINE]
  0x0147: PHI (r6v7 java.util.Iterator<com.urbanairship.audience.CompoundAudienceSelector>) = 
  (r6v1 java.util.Iterator<com.urbanairship.audience.CompoundAudienceSelector>)
  (r6v8 java.util.Iterator<com.urbanairship.audience.CompoundAudienceSelector>)
 binds: [B:56:0x0134, B:63:0x0176] A[DONT_GENERATE, DONT_INLINE]
  0x0147: PHI (r7v9 java.util.List<com.urbanairship.audience.AirshipDeviceAudienceResult>) = 
  (r7v1 java.util.List<com.urbanairship.audience.AirshipDeviceAudienceResult>)
  (r7v10 java.util.List<com.urbanairship.audience.AirshipDeviceAudienceResult>)
 binds: [B:56:0x0134, B:63:0x0176] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:59:0x014d  */
    /* JADX WARN: Code duplicated, block: B:61:0x016c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:8:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0106 -> B:46:0x0109). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x016a -> B:62:0x016d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object evaluate(long r13, @org.jetbrains.annotations.NotNull com.urbanairship.audience.DeviceInfoProvider r15, @org.jetbrains.annotations.NotNull com.urbanairship.audience.HashChecker r16, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.audience.AirshipDeviceAudienceResult> r17) {
        /*
            Method dump skipped, instruction units count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.audience.CompoundAudienceSelector.evaluate(long, com.urbanairship.audience.DeviceInfoProvider, com.urbanairship.audience.HashChecker, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
