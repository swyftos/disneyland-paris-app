package com.urbanairship.meteredusage;

import androidx.annotation.OpenForTesting;
import androidx.annotation.RestrictTo;
import androidx.room.Entity;
import androidx.room.TypeConverters;
import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.utils.UriBuilder;
import com.disney.id.android.lightbox.LightboxActivity;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonTypeConverters;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.util.DateUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@TypeConverters({UsageTypeConverter.class, JsonTypeConverters.class})
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\\\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\"J\u0015\u0010#\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0003H\u0000¢\u0006\u0002\b$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\r\u0010*\u001a\u00020\tH\u0000¢\u0006\u0002\b+J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\r\u0010-\u001a\u00020\u0000H\u0000¢\u0006\u0002\b.R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006/"}, d2 = {"Lcom/urbanairship/meteredusage/MeteredUsageEventEntity;", "", LightboxActivity.EVENT_ID_EXTRA, "", "entityId", "type", "Lcom/urbanairship/meteredusage/MeteredUsageType;", TCEventPropertiesNames.TCI_PRODUCT, "reportingContext", "Lcom/urbanairship/json/JsonValue;", "timestamp", "", "contactId", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/meteredusage/MeteredUsageType;Ljava/lang/String;Lcom/urbanairship/json/JsonValue;Ljava/lang/Long;Ljava/lang/String;)V", "getContactId", "()Ljava/lang/String;", "getEntityId", "getEventId", "getProduct", "getReportingContext", "()Lcom/urbanairship/json/JsonValue;", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getType", "()Lcom/urbanairship/meteredusage/MeteredUsageType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/meteredusage/MeteredUsageType;Ljava/lang/String;Lcom/urbanairship/json/JsonValue;Ljava/lang/Long;Ljava/lang/String;)Lcom/urbanairship/meteredusage/MeteredUsageEventEntity;", "copyWithContactId", "copyWithContactId$urbanairship_core_release", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toJson", "toJson$urbanairship_core_release", "toString", "withAnalyticsDisabled", "withAnalyticsDisabled$urbanairship_core_release", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Entity(tableName = UriBuilder.ANALYTICS_EVENT_ENDPOINT)
@OpenForTesting
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nMeteredUsageEventEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MeteredUsageEventEntity.kt\ncom/urbanairship/meteredusage/MeteredUsageEventEntity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,94:1\n1#2:95\n*E\n"})
/* loaded from: classes5.dex */
public final /* data */ class MeteredUsageEventEntity {
    private final String contactId;
    private final String entityId;
    private final String eventId;
    private final String product;
    private final JsonValue reportingContext;
    private final Long timestamp;
    private final MeteredUsageType type;

    public static /* synthetic */ MeteredUsageEventEntity copy$default(MeteredUsageEventEntity meteredUsageEventEntity, String str, String str2, MeteredUsageType meteredUsageType, String str3, JsonValue jsonValue, Long l, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = meteredUsageEventEntity.eventId;
        }
        if ((i & 2) != 0) {
            str2 = meteredUsageEventEntity.entityId;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            meteredUsageType = meteredUsageEventEntity.type;
        }
        MeteredUsageType meteredUsageType2 = meteredUsageType;
        if ((i & 8) != 0) {
            str3 = meteredUsageEventEntity.product;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            jsonValue = meteredUsageEventEntity.reportingContext;
        }
        JsonValue jsonValue2 = jsonValue;
        if ((i & 32) != 0) {
            l = meteredUsageEventEntity.timestamp;
        }
        Long l2 = l;
        if ((i & 64) != 0) {
            str4 = meteredUsageEventEntity.contactId;
        }
        return meteredUsageEventEntity.copy(str, str5, meteredUsageType2, str6, jsonValue2, l2, str4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getEventId() {
        return this.eventId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getEntityId() {
        return this.entityId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final MeteredUsageType getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getProduct() {
        return this.product;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final JsonValue getReportingContext() {
        return this.reportingContext;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Long getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getContactId() {
        return this.contactId;
    }

    @NotNull
    public final MeteredUsageEventEntity copy(@NotNull String eventId, @Nullable String entityId, @NotNull MeteredUsageType type, @NotNull String product, @Nullable JsonValue reportingContext, @Nullable Long timestamp, @Nullable String contactId) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(product, "product");
        return new MeteredUsageEventEntity(eventId, entityId, type, product, reportingContext, timestamp, contactId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MeteredUsageEventEntity)) {
            return false;
        }
        MeteredUsageEventEntity meteredUsageEventEntity = (MeteredUsageEventEntity) other;
        return Intrinsics.areEqual(this.eventId, meteredUsageEventEntity.eventId) && Intrinsics.areEqual(this.entityId, meteredUsageEventEntity.entityId) && this.type == meteredUsageEventEntity.type && Intrinsics.areEqual(this.product, meteredUsageEventEntity.product) && Intrinsics.areEqual(this.reportingContext, meteredUsageEventEntity.reportingContext) && Intrinsics.areEqual(this.timestamp, meteredUsageEventEntity.timestamp) && Intrinsics.areEqual(this.contactId, meteredUsageEventEntity.contactId);
    }

    public int hashCode() {
        int iHashCode = this.eventId.hashCode() * 31;
        String str = this.entityId;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.type.hashCode()) * 31) + this.product.hashCode()) * 31;
        JsonValue jsonValue = this.reportingContext;
        int iHashCode3 = (iHashCode2 + (jsonValue == null ? 0 : jsonValue.hashCode())) * 31;
        Long l = this.timestamp;
        int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.contactId;
        return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MeteredUsageEventEntity(eventId=" + this.eventId + ", entityId=" + this.entityId + ", type=" + this.type + ", product=" + this.product + ", reportingContext=" + this.reportingContext + ", timestamp=" + this.timestamp + ", contactId=" + this.contactId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public MeteredUsageEventEntity(@NotNull String eventId, @Nullable String str, @NotNull MeteredUsageType type, @NotNull String product, @Nullable JsonValue jsonValue, @Nullable Long l, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(product, "product");
        this.eventId = eventId;
        this.entityId = str;
        this.type = type;
        this.product = product;
        this.reportingContext = jsonValue;
        this.timestamp = l;
        this.contactId = str2;
    }

    @NotNull
    public final String getEventId() {
        return this.eventId;
    }

    @Nullable
    public final String getEntityId() {
        return this.entityId;
    }

    @NotNull
    public final MeteredUsageType getType() {
        return this.type;
    }

    @NotNull
    public final String getProduct() {
        return this.product;
    }

    @Nullable
    public final JsonValue getReportingContext() {
        return this.reportingContext;
    }

    @Nullable
    public final Long getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    public final String getContactId() {
        return this.contactId;
    }

    @NotNull
    public final MeteredUsageEventEntity withAnalyticsDisabled$urbanairship_core_release() {
        return new MeteredUsageEventEntity(this.eventId, null, this.type, this.product, null, null, null);
    }

    @NotNull
    public final MeteredUsageEventEntity copyWithContactId$urbanairship_core_release(@NotNull String contactId) {
        Intrinsics.checkNotNullParameter(contactId, "contactId");
        return new MeteredUsageEventEntity(this.eventId, this.entityId, this.type, this.product, this.reportingContext, this.timestamp, contactId);
    }

    @NotNull
    public final JsonValue toJson$urbanairship_core_release() {
        Pair pair = TuplesKt.to(TCEventPropertiesNames.TCE_EVENTID, this.eventId);
        Pair pair2 = TuplesKt.to("usage_type", this.type.getValue());
        Pair pair3 = TuplesKt.to(TCEventPropertiesNames.TCI_PRODUCT, this.product);
        Pair pair4 = TuplesKt.to("reporting_context", this.reportingContext);
        Long l = this.timestamp;
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(pair, pair2, pair3, pair4, TuplesKt.to("occurred", l != null ? DateUtils.createIso8601TimeStamp(l.longValue()) : null), TuplesKt.to("entity_id", this.entityId), TuplesKt.to(DeferredApiClient.KEY_CONTACT_ID, this.contactId)).toJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
