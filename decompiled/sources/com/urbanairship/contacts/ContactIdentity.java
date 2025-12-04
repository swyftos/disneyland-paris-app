package com.urbanairship.contacts;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.annotation.OpenForTesting;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@OpenForTesting
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0091\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B)\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0012J:\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\t\u0010 \u001a\u00020\u0006HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0016\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, d2 = {"Lcom/urbanairship/contacts/ContactIdentity;", "Lcom/urbanairship/json/JsonSerializable;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "(Lcom/urbanairship/json/JsonValue;)V", "contactId", "", "isAnonymous", "", "namedUserId", "resolveDateMs", "", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Long;)V", "getContactId", "()Ljava/lang/String;", "()Z", "getNamedUserId", "getResolveDateMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Long;)Lcom/urbanairship/contacts/ContactIdentity;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "toString", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nContactIdentity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactIdentity.kt\ncom/urbanairship/contacts/ContactIdentity\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,45:1\n44#2,15:46\n79#2,16:61\n79#2,16:77\n79#2,16:93\n*S KotlinDebug\n*F\n+ 1 ContactIdentity.kt\ncom/urbanairship/contacts/ContactIdentity\n*L\n25#1:46,15\n26#1:61,16\n27#1:77,16\n28#1:93,16\n*E\n"})
/* loaded from: classes5.dex */
public /* data */ class ContactIdentity implements JsonSerializable {
    private final String contactId;
    private final boolean isAnonymous;
    private final String namedUserId;
    private final Long resolveDateMs;

    public static /* synthetic */ ContactIdentity copy$default(ContactIdentity contactIdentity, String str, boolean z, String str2, Long l, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        if ((i & 1) != 0) {
            str = contactIdentity.getContactId();
        }
        if ((i & 2) != 0) {
            z = contactIdentity.getIsAnonymous();
        }
        if ((i & 4) != 0) {
            str2 = contactIdentity.getNamedUserId();
        }
        if ((i & 8) != 0) {
            l = contactIdentity.getResolveDateMs();
        }
        return contactIdentity.copy(str, z, str2, l);
    }

    @NotNull
    public final String component1() {
        return getContactId();
    }

    public final boolean component2() {
        return getIsAnonymous();
    }

    @Nullable
    public final String component3() {
        return getNamedUserId();
    }

    @Nullable
    public final Long component4() {
        return getResolveDateMs();
    }

    @NotNull
    public final ContactIdentity copy(@NotNull String contactId, boolean isAnonymous, @Nullable String namedUserId, @Nullable Long resolveDateMs) {
        Intrinsics.checkNotNullParameter(contactId, "contactId");
        return new ContactIdentity(contactId, isAnonymous, namedUserId, resolveDateMs);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContactIdentity)) {
            return false;
        }
        ContactIdentity contactIdentity = (ContactIdentity) other;
        return Intrinsics.areEqual(getContactId(), contactIdentity.getContactId()) && getIsAnonymous() == contactIdentity.getIsAnonymous() && Intrinsics.areEqual(getNamedUserId(), contactIdentity.getNamedUserId()) && Intrinsics.areEqual(getResolveDateMs(), contactIdentity.getResolveDateMs());
    }

    public int hashCode() {
        return (((((getContactId().hashCode() * 31) + Boolean.hashCode(getIsAnonymous())) * 31) + (getNamedUserId() == null ? 0 : getNamedUserId().hashCode())) * 31) + (getResolveDateMs() != null ? getResolveDateMs().hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ContactIdentity(contactId=" + getContactId() + ", isAnonymous=" + getIsAnonymous() + ", namedUserId=" + getNamedUserId() + ", resolveDateMs=" + getResolveDateMs() + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ContactIdentity(@NotNull String contactId, boolean z, @Nullable String str, @Nullable Long l) {
        Intrinsics.checkNotNullParameter(contactId, "contactId");
        this.contactId = contactId;
        this.isAnonymous = z;
        this.namedUserId = str;
        this.resolveDateMs = l;
    }

    @NotNull
    public String getContactId() {
        return this.contactId;
    }

    /* renamed from: isAnonymous, reason: from getter */
    public boolean getIsAnonymous() {
        return this.isAnonymous;
    }

    @Nullable
    public String getNamedUserId() {
        return this.namedUserId;
    }

    @Nullable
    public Long getResolveDateMs() {
        return this.resolveDateMs;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ContactIdentity(@NotNull JsonValue jsonValue) throws JsonException {
        String strOptString;
        String str;
        Boolean boolValueOf;
        String strOptString2;
        Long lValueOf;
        Long l;
        Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
        JsonMap jsonMapRequireMap = jsonValue.requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
        JsonValue jsonValue2 = jsonMapRequireMap.get(DeferredApiClient.KEY_CONTACT_ID);
        if (jsonValue2 == null) {
            throw new JsonException("Missing required field: '" + DeferredApiClient.KEY_CONTACT_ID + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        Intrinsics.checkNotNull(jsonValue2);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            strOptString = jsonValue2.optString();
            if (strOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            strOptString = jsonValue2.optString();
            if (strOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            strOptString = (String) Boolean.valueOf(jsonValue2.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            strOptString = (String) Long.valueOf(jsonValue2.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue2.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            strOptString = (String) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            strOptString = (String) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            strOptString = (String) Integer.valueOf(jsonValue2.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            Object objOptList = jsonValue2.optList();
            if (objOptList == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString = (String) objOptList;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            Object objOptMap = jsonValue2.optMap();
            if (objOptMap == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString = (String) objOptMap;
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field '" + DeferredApiClient.KEY_CONTACT_ID + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Object jsonValue3 = jsonValue2.getJsonValue();
            if (jsonValue3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString = (String) jsonValue3;
        }
        JsonMap jsonMapRequireMap2 = jsonValue.requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap2, "requireMap(...)");
        JsonValue jsonValue4 = jsonMapRequireMap2.get("is_anonymous");
        if (jsonValue4 == null) {
            str = "' for field '";
            boolValueOf = null;
        } else {
            Intrinsics.checkNotNull(jsonValue4);
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Boolean.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                boolValueOf = (Boolean) jsonValue4.optString();
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                boolValueOf = Boolean.valueOf(jsonValue4.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                str = "' for field '";
                boolValueOf = (Boolean) Long.valueOf(jsonValue4.getLong(0L));
            } else {
                str = "' for field '";
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    boolValueOf = (Boolean) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    boolValueOf = (Boolean) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    boolValueOf = (Boolean) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    boolValueOf = (Boolean) Integer.valueOf(jsonValue4.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    boolValueOf = (Boolean) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    boolValueOf = (Boolean) jsonValue4.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    boolValueOf = (Boolean) jsonValue4.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + str + "is_anonymous" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    boolValueOf = (Boolean) jsonValue4.getJsonValue();
                }
            }
            str = "' for field '";
        }
        boolean zBooleanValue = boolValueOf != null ? boolValueOf.booleanValue() : false;
        JsonMap jsonMapRequireMap3 = jsonValue.requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap3, "requireMap(...)");
        JsonValue jsonValue5 = jsonMapRequireMap3.get("named_user_id");
        if (jsonValue5 == null) {
            strOptString2 = null;
        } else {
            Intrinsics.checkNotNull(jsonValue5);
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString2 = jsonValue5.optString();
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString2 = (String) Boolean.valueOf(jsonValue5.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString2 = (String) Long.valueOf(jsonValue5.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString2 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue5.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString2 = (String) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString2 = (String) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                strOptString2 = (String) Integer.valueOf(jsonValue5.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString2 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue5.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                strOptString2 = (String) jsonValue5.optList();
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                strOptString2 = (String) jsonValue5.optMap();
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "named_user_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                strOptString2 = (String) jsonValue5.getJsonValue();
            }
        }
        JsonMap jsonMapRequireMap4 = jsonValue.requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap4, "requireMap(...)");
        JsonValue jsonValue6 = jsonMapRequireMap4.get("resolve_date_ms");
        if (jsonValue6 == null) {
            l = null;
        } else {
            Intrinsics.checkNotNull(jsonValue6);
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Long.class);
            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                lValueOf = (Long) jsonValue6.optString();
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                lValueOf = (Long) Boolean.valueOf(jsonValue6.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                lValueOf = Long.valueOf(jsonValue6.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                lValueOf = (Long) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue6.getLong(0L)));
            } else {
                String str2 = str;
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    lValueOf = (Long) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    lValueOf = (Long) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    lValueOf = (Long) Integer.valueOf(jsonValue6.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    lValueOf = (Long) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue6.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    lValueOf = (Long) jsonValue6.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    lValueOf = (Long) jsonValue6.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Long.class.getSimpleName() + str2 + "resolve_date_ms" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    lValueOf = (Long) jsonValue6.getJsonValue();
                }
            }
            l = lValueOf;
        }
        this(strOptString, zBooleanValue, strOptString2, l);
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to(DeferredApiClient.KEY_CONTACT_ID, getContactId()), TuplesKt.to("is_anonymous", Boolean.valueOf(getIsAnonymous())), TuplesKt.to("named_user_id", getNamedUserId()), TuplesKt.to("resolve_date_ms", getResolveDateMs())).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
