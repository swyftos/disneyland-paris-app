package com.urbanairship.remotedata;

import androidx.annotation.RestrictTo;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
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
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B-\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\tHÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/urbanairship/remotedata/RemoteDataInfo;", "Lcom/urbanairship/json/JsonSerializable;", "json", "Lcom/urbanairship/json/JsonValue;", "(Lcom/urbanairship/json/JsonValue;)V", "url", "", "lastModified", "source", "Lcom/urbanairship/remotedata/RemoteDataSource;", "contactId", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/remotedata/RemoteDataSource;Ljava/lang/String;)V", "getContactId", "()Ljava/lang/String;", "getLastModified", "getSource", "()Lcom/urbanairship/remotedata/RemoteDataSource;", "getUrl", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nRemoteDataInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteDataInfo.kt\ncom/urbanairship/remotedata/RemoteDataInfo\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,46:1\n44#2,15:47\n79#2,16:62\n44#2,15:78\n79#2,16:93\n*S KotlinDebug\n*F\n+ 1 RemoteDataInfo.kt\ncom/urbanairship/remotedata/RemoteDataInfo\n*L\n27#1:47,15\n28#1:62,16\n29#1:78,15\n36#1:93,16\n*E\n"})
/* loaded from: classes5.dex */
public final /* data */ class RemoteDataInfo implements JsonSerializable {
    private final String contactId;
    private final String lastModified;
    private final RemoteDataSource source;
    private final String url;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RemoteDataInfo(@NotNull String url, @Nullable String str, @NotNull RemoteDataSource source) {
        this(url, str, source, null, 8, null);
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(source, "source");
    }

    public static /* synthetic */ RemoteDataInfo copy$default(RemoteDataInfo remoteDataInfo, String str, String str2, RemoteDataSource remoteDataSource, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = remoteDataInfo.url;
        }
        if ((i & 2) != 0) {
            str2 = remoteDataInfo.lastModified;
        }
        if ((i & 4) != 0) {
            remoteDataSource = remoteDataInfo.source;
        }
        if ((i & 8) != 0) {
            str3 = remoteDataInfo.contactId;
        }
        return remoteDataInfo.copy(str, str2, remoteDataSource, str3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getLastModified() {
        return this.lastModified;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final RemoteDataSource getSource() {
        return this.source;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getContactId() {
        return this.contactId;
    }

    @NotNull
    public final RemoteDataInfo copy(@NotNull String url, @Nullable String lastModified, @NotNull RemoteDataSource source, @Nullable String contactId) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(source, "source");
        return new RemoteDataInfo(url, lastModified, source, contactId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoteDataInfo)) {
            return false;
        }
        RemoteDataInfo remoteDataInfo = (RemoteDataInfo) other;
        return Intrinsics.areEqual(this.url, remoteDataInfo.url) && Intrinsics.areEqual(this.lastModified, remoteDataInfo.lastModified) && this.source == remoteDataInfo.source && Intrinsics.areEqual(this.contactId, remoteDataInfo.contactId);
    }

    public int hashCode() {
        int iHashCode = this.url.hashCode() * 31;
        String str = this.lastModified;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.source.hashCode()) * 31;
        String str2 = this.contactId;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "RemoteDataInfo(url=" + this.url + ", lastModified=" + this.lastModified + ", source=" + this.source + ", contactId=" + this.contactId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @JvmOverloads
    public RemoteDataInfo(@NotNull String url, @Nullable String str, @NotNull RemoteDataSource source, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(source, "source");
        this.url = url;
        this.lastModified = str;
        this.source = source;
        this.contactId = str2;
    }

    public /* synthetic */ RemoteDataInfo(String str, String str2, RemoteDataSource remoteDataSource, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, remoteDataSource, (i & 8) != 0 ? null : str3);
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final String getLastModified() {
        return this.lastModified;
    }

    @NotNull
    public final RemoteDataSource getSource() {
        return this.source;
    }

    @Nullable
    public final String getContactId() {
        return this.contactId;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public RemoteDataInfo(@NotNull JsonValue json) throws JsonException {
        String strOptString;
        String str;
        String strOptString2;
        String strOptString3;
        String strOptString4;
        String str2;
        Intrinsics.checkNotNullParameter(json, "json");
        JsonMap jsonMapRequireMap = json.requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
        JsonValue jsonValue = jsonMapRequireMap.get("url");
        if (jsonValue == null) {
            throw new JsonException("Missing required field: 'url" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        Intrinsics.checkNotNull(jsonValue);
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
                throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'url" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Object jsonValue2 = jsonValue.getJsonValue();
            if (jsonValue2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString = (String) jsonValue2;
        }
        JsonMap jsonMapRequireMap2 = json.requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap2, "requireMap(...)");
        JsonValue jsonValue3 = jsonMapRequireMap2.get("lastModified");
        if (jsonValue3 == null) {
            str = "' for field '";
            strOptString2 = null;
        } else {
            Intrinsics.checkNotNull(jsonValue3);
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString2 = jsonValue3.optString();
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString2 = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                str = "' for field '";
                strOptString2 = (String) Long.valueOf(jsonValue3.getLong(0L));
            } else {
                str = "' for field '";
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString2 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString2 = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString2 = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    strOptString2 = (String) Integer.valueOf(jsonValue3.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString2 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    strOptString2 = (String) jsonValue3.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    strOptString2 = (String) jsonValue3.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "lastModified" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    strOptString2 = (String) jsonValue3.getJsonValue();
                }
            }
            str = "' for field '";
        }
        JsonMap jsonMapRequireMap3 = json.requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap3, "requireMap(...)");
        JsonValue jsonValue4 = jsonMapRequireMap3.get("source");
        if (jsonValue4 == null) {
            throw new JsonException("Missing required field: 'source" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        Intrinsics.checkNotNull(jsonValue4);
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
            strOptString3 = jsonValue4.optString();
            if (strOptString3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            strOptString3 = jsonValue4.optString();
            if (strOptString3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            strOptString3 = (String) Boolean.valueOf(jsonValue4.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            strOptString3 = (String) Long.valueOf(jsonValue4.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
            strOptString3 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            strOptString3 = (String) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            strOptString3 = (String) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
            strOptString3 = (String) Integer.valueOf(jsonValue4.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
            strOptString3 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            Object objOptList2 = jsonValue4.optList();
            if (objOptList2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString3 = (String) objOptList2;
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            Object objOptMap2 = jsonValue4.optMap();
            if (objOptMap2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString3 = (String) objOptMap2;
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "source" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Object jsonValue5 = jsonValue4.getJsonValue();
            if (jsonValue5 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString3 = (String) jsonValue5;
        }
        try {
            RemoteDataSource remoteDataSourceValueOf = RemoteDataSource.valueOf(strOptString3);
            JsonMap jsonMapRequireMap4 = json.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap4, "requireMap(...)");
            JsonValue jsonValue6 = jsonMapRequireMap4.get("contactId");
            if (jsonValue6 == null) {
                str2 = null;
            } else {
                Intrinsics.checkNotNull(jsonValue6);
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString4 = jsonValue6.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString4 = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString4 = (String) Long.valueOf(jsonValue6.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString4 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue6.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString4 = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString4 = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    strOptString4 = (String) Integer.valueOf(jsonValue6.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString4 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue6.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    strOptString4 = (String) jsonValue6.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    strOptString4 = (String) jsonValue6.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "contactId" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    strOptString4 = (String) jsonValue6.getJsonValue();
                }
                str2 = strOptString4;
            }
            this(strOptString, strOptString2, remoteDataSourceValueOf, str2);
        } catch (Exception e) {
            throw new JsonException("Invalid source", e);
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("url", this.url), TuplesKt.to("lastModified", this.lastModified), TuplesKt.to("source", this.source.name()), TuplesKt.to("contactId", this.contactId)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
