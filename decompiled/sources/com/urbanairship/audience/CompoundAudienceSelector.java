package com.urbanairship.audience;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.audience.AudienceSelector;
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

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00102\u00020\u0001:\u0006\u000e\u000f\u0010\u0011\u0012\u0013B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016\u0082\u0001\u0004\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/audience/CompoundAudienceSelector;", "Lcom/urbanairship/json/JsonSerializable;", "()V", "evaluate", "Lcom/urbanairship/audience/AirshipDeviceAudienceResult;", "newEvaluationDate", "", "infoProvider", "Lcom/urbanairship/audience/DeviceInfoProvider;", "hashChecker", "Lcom/urbanairship/audience/HashChecker;", "(JLcom/urbanairship/audience/DeviceInfoProvider;Lcom/urbanairship/audience/HashChecker;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "And", "Atomic", "Companion", "Not", "Or", "SelectorType", "Lcom/urbanairship/audience/CompoundAudienceSelector$And;", "Lcom/urbanairship/audience/CompoundAudienceSelector$Atomic;", "Lcom/urbanairship/audience/CompoundAudienceSelector$Not;", "Lcom/urbanairship/audience/CompoundAudienceSelector$Or;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public abstract class CompoundAudienceSelector implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: com.urbanairship.audience.CompoundAudienceSelector$evaluate$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
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

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/audience/CompoundAudienceSelector$Atomic;", "Lcom/urbanairship/audience/CompoundAudienceSelector;", "audience", "Lcom/urbanairship/audience/AudienceSelector;", "(Lcom/urbanairship/audience/AudienceSelector;)V", "getAudience", "()Lcom/urbanairship/audience/AudienceSelector;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
        /* renamed from: component1, reason: from getter */
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

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\t\u0010\u0006\u001a\u00020\u0001HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/audience/CompoundAudienceSelector$Not;", "Lcom/urbanairship/audience/CompoundAudienceSelector;", "selector", "(Lcom/urbanairship/audience/CompoundAudienceSelector;)V", "getSelector", "()Lcom/urbanairship/audience/CompoundAudienceSelector;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
        /* renamed from: component1, reason: from getter */
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

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\u0019\u0010\b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/audience/CompoundAudienceSelector$And;", "Lcom/urbanairship/audience/CompoundAudienceSelector;", "selectors", "", "(Ljava/util/List;)V", "getSelectors", "()Ljava/util/List;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\u0019\u0010\b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/audience/CompoundAudienceSelector$Or;", "Lcom/urbanairship/audience/CompoundAudienceSelector;", "selectors", "", "(Ljava/util/List;)V", "getSelectors", "()Ljava/util/List;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static final class SelectorType implements JsonSerializable {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SelectorType[] $VALUES;
        public static final Companion Companion;
        private final String jsonValue;
        public static final SelectorType ATOMIC = new SelectorType("ATOMIC", 0, "atomic");
        public static final SelectorType NOT = new SelectorType("NOT", 1, JsonPredicate.NOT_PREDICATE_TYPE);
        public static final SelectorType AND = new SelectorType("AND", 2, JsonPredicate.AND_PREDICATE_TYPE);
        public static final SelectorType OR = new SelectorType("OR", 3, JsonPredicate.OR_PREDICATE_TYPE);

        private static final /* synthetic */ SelectorType[] $values() {
            return new SelectorType[]{ATOMIC, NOT, AND, OR};
        }

        public static EnumEntries getEntries() {
            return $ENTRIES;
        }

        public static SelectorType valueOf(String str) {
            return (SelectorType) Enum.valueOf(SelectorType.class, str);
        }

        public static SelectorType[] values() {
            return (SelectorType[]) $VALUES.clone();
        }

        private SelectorType(String str, int i, String str2) {
            this.jsonValue = str2;
        }

        public final String getJsonValue() {
            return this.jsonValue;
        }

        static {
            SelectorType[] selectorTypeArr$values = $values();
            $VALUES = selectorTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(selectorTypeArr$values);
            Companion = new Companion(null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/audience/CompoundAudienceSelector$SelectorType$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/audience/CompoundAudienceSelector$SelectorType;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(((SelectorType) next).getJsonValue(), strRequireString)) {
                        break;
                    }
                }
                SelectorType selectorType = (SelectorType) next;
                if (selectorType != null) {
                    return selectorType;
                }
                throw new JsonException("Invalid button layout " + strRequireString);
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValueWrap = JsonValue.wrap(this.jsonValue);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            return jsonValueWrap;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/audience/CompoundAudienceSelector$Companion;", "", "()V", "AUDIENCE", "", "SELECTOR", "SELECTORS", "TYPE", "combine", "Lcom/urbanairship/audience/CompoundAudienceSelector;", "compoundAudienceSelector", "deviceAudience", "Lcom/urbanairship/audience/AudienceSelector;", "fromJson", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nCompoundAudienceSelector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompoundAudienceSelector.kt\ncom/urbanairship/audience/CompoundAudienceSelector$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,179:1\n1549#2:180\n1620#2,3:181\n1549#2:184\n1620#2,3:185\n*S KotlinDebug\n*F\n+ 1 CompoundAudienceSelector.kt\ncom/urbanairship/audience/CompoundAudienceSelector$Companion\n*L\n81#1:180\n81#1:181,3\n82#1:184\n82#1:185,3\n*E\n"})
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
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
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() throws JsonException {
        JsonMap jsonMapJsonMapOf;
        if (this instanceof And) {
            jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", SelectorType.AND), TuplesKt.to("selectors", ((And) this).getSelectors()));
        } else if (this instanceof Atomic) {
            jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", SelectorType.ATOMIC), TuplesKt.to("audience", ((Atomic) this).getAudience()));
        } else if (this instanceof Not) {
            jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", SelectorType.NOT), TuplesKt.to("selector", ((Not) this).getSelector()));
        } else if (this instanceof Or) {
            jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", SelectorType.OR), TuplesKt.to("selectors", ((Or) this).getSelectors()));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        JsonValue jsonValue = jsonMapJsonMapOf.getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e3 A[PHI: r0 r3 r4 r6 r7
  0x00e3: PHI (r0v19 long) = (r0v11 long), (r0v20 long) binds: [B:40:0x00d0, B:47:0x0112] A[DONT_GENERATE, DONT_INLINE]
  0x00e3: PHI (r3v5 com.urbanairship.audience.DeviceInfoProvider) = (r3v2 com.urbanairship.audience.DeviceInfoProvider), (r3v6 com.urbanairship.audience.DeviceInfoProvider) binds: [B:40:0x00d0, B:47:0x0112] A[DONT_GENERATE, DONT_INLINE]
  0x00e3: PHI (r4v4 com.urbanairship.audience.HashChecker) = (r4v1 com.urbanairship.audience.HashChecker), (r4v5 com.urbanairship.audience.HashChecker) binds: [B:40:0x00d0, B:47:0x0112] A[DONT_GENERATE, DONT_INLINE]
  0x00e3: PHI (r6v5 java.util.Iterator<com.urbanairship.audience.CompoundAudienceSelector>) = 
  (r6v2 java.util.Iterator<com.urbanairship.audience.CompoundAudienceSelector>)
  (r6v6 java.util.Iterator<com.urbanairship.audience.CompoundAudienceSelector>)
 binds: [B:40:0x00d0, B:47:0x0112] A[DONT_GENERATE, DONT_INLINE]
  0x00e3: PHI (r7v6 java.util.ArrayList) = (r7v2 java.util.ArrayList), (r7v7 java.util.ArrayList) binds: [B:40:0x00d0, B:47:0x0112] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0147 A[PHI: r0 r3 r5 r6 r7
  0x0147: PHI (r0v23 long) = (r0v5 long), (r0v24 long) binds: [B:56:0x0134, B:63:0x0176] A[DONT_GENERATE, DONT_INLINE]
  0x0147: PHI (r3v7 com.urbanairship.audience.DeviceInfoProvider) = (r3v1 com.urbanairship.audience.DeviceInfoProvider), (r3v8 com.urbanairship.audience.DeviceInfoProvider) binds: [B:56:0x0134, B:63:0x0176] A[DONT_GENERATE, DONT_INLINE]
  0x0147: PHI (r5v2 com.urbanairship.audience.HashChecker) = (r5v1 com.urbanairship.audience.HashChecker), (r5v3 com.urbanairship.audience.HashChecker) binds: [B:56:0x0134, B:63:0x0176] A[DONT_GENERATE, DONT_INLINE]
  0x0147: PHI (r6v7 java.util.Iterator<com.urbanairship.audience.CompoundAudienceSelector>) = 
  (r6v1 java.util.Iterator<com.urbanairship.audience.CompoundAudienceSelector>)
  (r6v8 java.util.Iterator<com.urbanairship.audience.CompoundAudienceSelector>)
 binds: [B:56:0x0134, B:63:0x0176] A[DONT_GENERATE, DONT_INLINE]
  0x0147: PHI (r7v9 java.util.ArrayList) = (r7v1 java.util.ArrayList), (r7v10 java.util.ArrayList) binds: [B:56:0x0134, B:63:0x0176] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0106 -> B:46:0x0109). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x016a -> B:62:0x016d). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object evaluate(long r13, @org.jetbrains.annotations.NotNull com.urbanairship.audience.DeviceInfoProvider r15, @org.jetbrains.annotations.NotNull com.urbanairship.audience.HashChecker r16, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.audience.AirshipDeviceAudienceResult> r17) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.audience.CompoundAudienceSelector.evaluate(long, com.urbanairship.audience.DeviceInfoProvider, com.urbanairship.audience.HashChecker, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
