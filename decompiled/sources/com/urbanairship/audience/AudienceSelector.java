package com.urbanairship.audience;

import androidx.annotation.RestrictTo;
import androidx.core.os.LocaleListCompat;
import androidx.core.util.ObjectsCompat;
import com.facebook.hermes.intl.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.UALog;
import com.urbanairship.actions.FetchDeviceInfoAction;
import com.urbanairship.audience.AudienceHashSelector;
import com.urbanairship.audience.DeviceTagSelector;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonPredicate;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.ValueMatcher;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.util.UAStringUtil;
import com.urbanairship.util.VersionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 N2\u00020\u0001:\u0003MNOB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u00112\u0006\u0010.\u001a\u00020/H\u0002J\u0016\u00101\u001a\u00020\u00112\u0006\u0010.\u001a\u00020/H\u0082@¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020/H\u0002J\u0018\u00105\u001a\u00020\u00112\u0006\u0010.\u001a\u00020/2\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020\u00112\u0006\u00104\u001a\u00020/H\u0002J\u0016\u00109\u001a\u00020\u00112\u0006\u0010.\u001a\u00020/H\u0082@¢\u0006\u0002\u00102J\u0010\u0010:\u001a\u00020\u00112\u0006\u0010.\u001a\u00020/H\u0002J\u0016\u0010;\u001a\u00020\u00112\u0006\u0010.\u001a\u00020/H\u0082@¢\u0006\u0002\u00102J\u0010\u0010<\u001a\u00020\u00112\u0006\u0010.\u001a\u00020/H\u0002J\u0013\u0010=\u001a\u00020\u00112\b\u0010>\u001a\u0004\u0018\u00010?H\u0096\u0002J&\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u0002072\u0006\u0010.\u001a\u00020/2\u0006\u0010C\u001a\u00020DH\u0086@¢\u0006\u0002\u0010EJ\b\u0010F\u001a\u00020GH\u0016J\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00070I2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010J\u001a\u00020KH\u0016J\b\u0010L\u001a\u00020\u0007H\u0016R\u001c\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001a\u0010\u0013R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0015\u0010!\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\"\u0010\u0013R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\tR\u0013\u0010+\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 ¨\u0006P"}, d2 = {"Lcom/urbanairship/audience/AudienceSelector;", "Lcom/urbanairship/json/JsonSerializable;", "builder", "Lcom/urbanairship/audience/AudienceSelector$Builder;", "(Lcom/urbanairship/audience/AudienceSelector$Builder;)V", "deviceTypes", "", "", "getDeviceTypes$urbanairship_core_release", "()Ljava/util/List;", "hashSelector", "Lcom/urbanairship/audience/AudienceHashSelector;", "getHashSelector$urbanairship_core_release", "()Lcom/urbanairship/audience/AudienceHashSelector;", "languageTags", "getLanguageTags", "locationOptIn", "", "getLocationOptIn", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "missBehavior", "Lcom/urbanairship/audience/AudienceSelector$MissBehavior;", "getMissBehavior", "()Lcom/urbanairship/audience/AudienceSelector$MissBehavior;", "newUser", "getNewUser", "notificationsOptIn", "getNotificationsOptIn", "permissionsPredicate", "Lcom/urbanairship/json/JsonPredicate;", "getPermissionsPredicate", "()Lcom/urbanairship/json/JsonPredicate;", "requiresAnalytics", "getRequiresAnalytics", "tagSelector", "Lcom/urbanairship/audience/DeviceTagSelector;", "getTagSelector", "()Lcom/urbanairship/audience/DeviceTagSelector;", "setTagSelector", "(Lcom/urbanairship/audience/DeviceTagSelector;)V", "testDevices", "getTestDevices", "versionPredicate", "getVersionPredicate", "checkAnalytics", "infoProvider", "Lcom/urbanairship/audience/DeviceInfoProvider;", "checkDeviceType", "checkHash", "(Lcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkLocale", "dataProvider", "checkNewUser", "cutOffDate", "", "checkNotificationOptInStatus", "checkPermissions", "checkTags", "checkTestDevice", "checkVersion", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "evaluate", "Lcom/urbanairship/audience/AirshipDeviceAudienceResult;", "newEvaluationDate", "hashChecker", "Lcom/urbanairship/audience/HashChecker;", "(JLcom/urbanairship/audience/DeviceInfoProvider;Lcom/urbanairship/audience/HashChecker;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hashCode", "", "sanitizedLanguageTags", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Builder", "Companion", "MissBehavior", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nAudienceSelector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudienceSelector.kt\ncom/urbanairship/audience/AudienceSelector\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,664:1\n125#2:665\n152#2,3:666\n1603#3,9:669\n1855#3:678\n1856#3:680\n1612#3:681\n1#4:679\n*S KotlinDebug\n*F\n+ 1 AudienceSelector.kt\ncom/urbanairship/audience/AudienceSelector\n*L\n622#1:665\n622#1:666,3\n654#1:669,9\n654#1:678\n654#1:680\n654#1:681\n654#1:679\n*E\n"})
/* loaded from: classes5.dex */
public final class AudienceSelector implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final List deviceTypes;

    /* renamed from: hashSelector, reason: from kotlin metadata and from toString */
    private final AudienceHashSelector audienceHash;
    private final List languageTags;
    private final Boolean locationOptIn;
    private final MissBehavior missBehavior;
    private final Boolean newUser;
    private final Boolean notificationsOptIn;
    private final JsonPredicate permissionsPredicate;
    private final Boolean requiresAnalytics;
    private DeviceTagSelector tagSelector;
    private final List testDevices;
    private final JsonPredicate versionPredicate;

    /* renamed from: com.urbanairship.audience.AudienceSelector$checkHash$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AudienceSelector.this.checkHash(null, this);
        }
    }

    /* renamed from: com.urbanairship.audience.AudienceSelector$checkPermissions$1, reason: invalid class name and case insensitive filesystem */
    static final class C09791 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09791(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AudienceSelector.this.checkPermissions(null, this);
        }
    }

    /* renamed from: com.urbanairship.audience.AudienceSelector$checkTestDevice$1, reason: invalid class name and case insensitive filesystem */
    static final class C09801 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09801(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AudienceSelector.this.checkTestDevice(null, this);
        }
    }

    /* renamed from: com.urbanairship.audience.AudienceSelector$evaluate$1, reason: invalid class name and case insensitive filesystem */
    static final class C09811 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C09811(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AudienceSelector.this.evaluate(0L, null, null, this);
        }
    }

    public /* synthetic */ AudienceSelector(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private AudienceSelector(Builder builder) {
        this.newUser = builder.getNewUser();
        this.notificationsOptIn = builder.getNotificationsOptIn();
        this.locationOptIn = builder.getLocationOptIn();
        this.requiresAnalytics = builder.getRequiresAnalytics();
        this.languageTags = builder.getLanguageTags$urbanairship_core_release();
        this.versionPredicate = builder.getVersionPredicate();
        this.testDevices = builder.getTestDevices$urbanairship_core_release();
        this.missBehavior = builder.getMissBehavior();
        this.permissionsPredicate = builder.getPermissionsPredicate();
        this.tagSelector = builder.getTagSelector();
        this.audienceHash = builder.getHashSelector();
        this.deviceTypes = builder.getDeviceTypes$urbanairship_core_release();
    }

    @Nullable
    public final Boolean getNewUser() {
        return this.newUser;
    }

    @Nullable
    public final Boolean getNotificationsOptIn() {
        return this.notificationsOptIn;
    }

    @Nullable
    public final Boolean getLocationOptIn() {
        return this.locationOptIn;
    }

    @Nullable
    public final Boolean getRequiresAnalytics() {
        return this.requiresAnalytics;
    }

    @Nullable
    public final JsonPredicate getVersionPredicate() {
        return this.versionPredicate;
    }

    @Nullable
    public final JsonPredicate getPermissionsPredicate() {
        return this.permissionsPredicate;
    }

    @NotNull
    public final MissBehavior getMissBehavior() {
        return this.missBehavior;
    }

    @Nullable
    public final DeviceTagSelector getTagSelector() {
        return this.tagSelector;
    }

    public final void setTagSelector(@Nullable DeviceTagSelector deviceTagSelector) {
        this.tagSelector = deviceTagSelector;
    }

    @NotNull
    public final List<String> getLanguageTags() {
        return this.languageTags;
    }

    @NotNull
    public final List<String> getTestDevices() {
        return this.testDevices;
    }

    @Nullable
    /* renamed from: getHashSelector$urbanairship_core_release, reason: from getter */
    public final AudienceHashSelector getAudienceHash() {
        return this.audienceHash;
    }

    @Nullable
    public final List<String> getDeviceTypes$urbanairship_core_release() {
        return this.deviceTypes;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonMap.Builder builderPut = JsonMap.newBuilder().putOpt("new_user", this.newUser).putOpt("notification_opt_in", this.notificationsOptIn).putOpt("location_opt_in", this.locationOptIn).putOpt("requires_analytics", this.requiresAnalytics).put(Constants.LOCALE, this.languageTags.isEmpty() ? null : JsonValue.wrapOpt(this.languageTags)).put("test_devices", this.testDevices.isEmpty() ? null : JsonValue.wrapOpt(this.testDevices)).put(FetchDeviceInfoAction.TAGS_KEY, this.tagSelector);
        AudienceHashSelector audienceHashSelector = this.audienceHash;
        JsonValue jsonValue = builderPut.put("hash", audienceHashSelector != null ? audienceHashSelector.getJsonValue() : null).put("app_version", this.versionPredicate).put("miss_behavior", this.missBehavior).put("permissions", this.permissionsPredicate).putOpt("device_types", this.deviceTypes).build().getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/audience/AudienceSelector$Companion;", "", "()V", "APP_VERSION_KEY", "", "DEVICE_TYPES_KEY", "HASH_KEY", "LOCALE_KEY", "LOCATION_OPT_IN_KEY", "MISS_BEHAVIOR_KEY", "NEW_USER_KEY", "NOTIFICATION_OPT_IN_KEY", "PERMISSIONS_KEY", "REQUIRES_ANALYTICS_KEY", "TAGS_KEY", "TEST_DEVICES_KEY", "fromJson", "Lcom/urbanairship/audience/AudienceSelector;", "value", "Lcom/urbanairship/json/JsonValue;", "newBuilder", "Lcom/urbanairship/audience/AudienceSelector$Builder;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAudienceSelector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudienceSelector.kt\ncom/urbanairship/audience/AudienceSelector$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,664:1\n1549#2:665\n1620#2,3:666\n*S KotlinDebug\n*F\n+ 1 AudienceSelector.kt\ncom/urbanairship/audience/AudienceSelector$Companion\n*L\n231#1:665\n231#1:666,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Builder newBuilder() {
            return new Builder();
        }

        @NotNull
        public final AudienceSelector fromJson(@NotNull JsonValue value) throws JsonException {
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapOptMap = value.optMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
            Builder builderNewBuilder = newBuilder();
            if (jsonMapOptMap.containsKey("new_user")) {
                if (!jsonMapOptMap.opt("new_user").isBoolean()) {
                    throw new JsonException("new_user must be a boolean: " + jsonMapOptMap.get("new_user"));
                }
                builderNewBuilder.setNewUser(jsonMapOptMap.opt("new_user").getBoolean(false));
            }
            if (jsonMapOptMap.containsKey("notification_opt_in")) {
                if (!jsonMapOptMap.opt("notification_opt_in").isBoolean()) {
                    throw new JsonException("notification_opt_in must be a boolean: " + jsonMapOptMap.get("notification_opt_in"));
                }
                builderNewBuilder.setNotificationsOptIn(jsonMapOptMap.opt("notification_opt_in").getBoolean(false));
            }
            if (jsonMapOptMap.containsKey("location_opt_in")) {
                if (!jsonMapOptMap.opt("location_opt_in").isBoolean()) {
                    throw new JsonException("location_opt_in must be a boolean: " + jsonMapOptMap.get("location_opt_in"));
                }
                builderNewBuilder.setLocationOptIn(jsonMapOptMap.opt("location_opt_in").getBoolean(false));
            }
            if (jsonMapOptMap.containsKey("requires_analytics")) {
                if (!jsonMapOptMap.opt("requires_analytics").isBoolean()) {
                    throw new JsonException("requires_analytics must be a boolean: " + jsonMapOptMap.get("requires_analytics"));
                }
                builderNewBuilder.setRequiresAnalytics(jsonMapOptMap.opt("requires_analytics").getBoolean(false));
            }
            if (jsonMapOptMap.containsKey(Constants.LOCALE)) {
                if (!jsonMapOptMap.opt(Constants.LOCALE).isJsonList()) {
                    throw new JsonException("locales must be an array: " + jsonMapOptMap.get(Constants.LOCALE));
                }
                Iterator<JsonValue> it = jsonMapOptMap.opt(Constants.LOCALE).optList().iterator();
                while (it.hasNext()) {
                    JsonValue next = it.next();
                    String string = next.getString();
                    if (string == null) {
                        throw new JsonException("Invalid locale: " + next);
                    }
                    builderNewBuilder.addLanguageTag(string);
                }
            }
            if (jsonMapOptMap.containsKey("app_version")) {
                builderNewBuilder.setVersionPredicate(JsonPredicate.parse(jsonMapOptMap.get("app_version")));
            }
            if (jsonMapOptMap.containsKey("permissions")) {
                JsonPredicate jsonPredicate = JsonPredicate.parse(jsonMapOptMap.get("permissions"));
                Intrinsics.checkNotNullExpressionValue(jsonPredicate, "parse(...)");
                builderNewBuilder.setPermissionsPredicate(jsonPredicate);
            }
            if (jsonMapOptMap.containsKey(FetchDeviceInfoAction.TAGS_KEY)) {
                DeviceTagSelector.Companion companion = DeviceTagSelector.INSTANCE;
                JsonValue jsonValueOpt = jsonMapOptMap.opt(FetchDeviceInfoAction.TAGS_KEY);
                Intrinsics.checkNotNullExpressionValue(jsonValueOpt, "opt(...)");
                builderNewBuilder.setTagSelector(companion.fromJson(jsonValueOpt));
            }
            if (jsonMapOptMap.containsKey("test_devices")) {
                if (!jsonMapOptMap.opt("test_devices").isJsonList()) {
                    throw new JsonException("test devices must be an array: " + jsonMapOptMap.get(Constants.LOCALE));
                }
                Iterator<JsonValue> it2 = jsonMapOptMap.opt("test_devices").optList().iterator();
                while (it2.hasNext()) {
                    JsonValue next2 = it2.next();
                    if (!next2.isString()) {
                        throw new JsonException("Invalid test device: " + next2);
                    }
                    String string2 = next2.getString();
                    Intrinsics.checkNotNull(string2);
                    builderNewBuilder.addTestDevice(string2);
                }
            }
            if (jsonMapOptMap.containsKey("miss_behavior")) {
                if (!jsonMapOptMap.opt("miss_behavior").isString()) {
                    throw new JsonException("miss_behavior must be a string: " + jsonMapOptMap.get("miss_behavior"));
                }
                MissBehavior.Companion companion2 = MissBehavior.INSTANCE;
                String strOptString = jsonMapOptMap.opt("miss_behavior").optString();
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                MissBehavior missBehavior = companion2.parse(strOptString);
                if (missBehavior == null) {
                    throw new JsonException("Invalid miss behavior: " + jsonMapOptMap.opt("miss_behavior"));
                }
                builderNewBuilder.setMissBehavior(missBehavior);
            }
            if (jsonMapOptMap.containsKey("hash")) {
                if (!jsonMapOptMap.opt("hash").isJsonMap()) {
                    throw new JsonException("hash must be a json map: " + jsonMapOptMap.get("hash"));
                }
                AudienceHashSelector.Companion companion3 = AudienceHashSelector.INSTANCE;
                JsonMap jsonMapOptMap2 = jsonMapOptMap.opt("hash").optMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapOptMap2, "optMap(...)");
                AudienceHashSelector audienceHashSelectorFromJson$urbanairship_core_release = companion3.fromJson$urbanairship_core_release(jsonMapOptMap2);
                if (audienceHashSelectorFromJson$urbanairship_core_release == null) {
                    throw new JsonException("failed to parse audience hash from: " + jsonMapOptMap.get("hash"));
                }
                builderNewBuilder.setAudienceHashSelector$urbanairship_core_release(audienceHashSelectorFromJson$urbanairship_core_release);
            }
            if (jsonMapOptMap.containsKey("device_types")) {
                if (!jsonMapOptMap.opt("device_types").isJsonList()) {
                    throw new JsonException("device types must be a json list: " + jsonMapOptMap.get("device_types"));
                }
                JsonList jsonListOptList = jsonMapOptMap.opt("device_types").optList();
                Intrinsics.checkNotNullExpressionValue(jsonListOptList, "optList(...)");
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptList, 10));
                Iterator<JsonValue> it3 = jsonListOptList.iterator();
                while (it3.hasNext()) {
                    arrayList.add(it3.next().requireString());
                }
                builderNewBuilder.setDeviceTypes$urbanairship_core_release(arrayList);
            }
            return builderNewBuilder.build();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/audience/AudienceSelector$MissBehavior;", "", "Lcom/urbanairship/json/JsonSerializable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "CANCEL", "SKIP", "PENALIZE", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class MissBehavior implements JsonSerializable {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ MissBehavior[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        private final String value;
        public static final MissBehavior CANCEL = new MissBehavior("CANCEL", 0, "cancel");
        public static final MissBehavior SKIP = new MissBehavior("SKIP", 1, "skip");
        public static final MissBehavior PENALIZE = new MissBehavior("PENALIZE", 2, "penalize");

        private static final /* synthetic */ MissBehavior[] $values() {
            return new MissBehavior[]{CANCEL, SKIP, PENALIZE};
        }

        @NotNull
        public static EnumEntries<MissBehavior> getEntries() {
            return $ENTRIES;
        }

        public static MissBehavior valueOf(String str) {
            return (MissBehavior) Enum.valueOf(MissBehavior.class, str);
        }

        public static MissBehavior[] values() {
            return (MissBehavior[]) $VALUES.clone();
        }

        private MissBehavior(String str, int i, String str2) {
            this.value = str2;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        static {
            MissBehavior[] missBehaviorArr$values = $values();
            $VALUES = missBehaviorArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(missBehaviorArr$values);
            INSTANCE = new Companion(null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/audience/AudienceSelector$MissBehavior$Companion;", "", "()V", "parse", "Lcom/urbanairship/audience/AudienceSelector$MissBehavior;", "input", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @SourceDebugExtension({"SMAP\nAudienceSelector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudienceSelector.kt\ncom/urbanairship/audience/AudienceSelector$MissBehavior$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,664:1\n288#2,2:665\n*S KotlinDebug\n*F\n+ 1 AudienceSelector.kt\ncom/urbanairship/audience/AudienceSelector$MissBehavior$Companion\n*L\n260#1:665,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            @Nullable
            public final MissBehavior parse(@NotNull String input) {
                MissBehavior next;
                Intrinsics.checkNotNullParameter(input, "input");
                Iterator<MissBehavior> it = MissBehavior.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(next.getValue(), input)) {
                        break;
                    }
                }
                return next;
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValueWrap = JsonValue.wrap(this.value);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            return jsonValueWrap;
        }
    }

    @NotNull
    public String toString() {
        return "AudienceSelector{newUser=" + this.newUser + ", notificationsOptIn=" + this.notificationsOptIn + ", locationOptIn=" + this.locationOptIn + ", requiresAnalytics=" + this.requiresAnalytics + ", languageTags=" + this.languageTags + ", testDevices=" + this.testDevices + ", tagSelector=" + this.tagSelector + ", audienceHash=" + this.audienceHash + ", versionPredicate=" + this.versionPredicate + ", permissionsPredicate=" + this.permissionsPredicate + ", missBehavior='" + this.missBehavior + "'}";
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(AudienceSelector.class, other.getClass())) {
            return false;
        }
        AudienceSelector audienceSelector = (AudienceSelector) other;
        return ObjectsCompat.equals(this.newUser, audienceSelector.newUser) && ObjectsCompat.equals(this.notificationsOptIn, audienceSelector.notificationsOptIn) && ObjectsCompat.equals(this.locationOptIn, audienceSelector.locationOptIn) && ObjectsCompat.equals(this.requiresAnalytics, audienceSelector.requiresAnalytics) && ObjectsCompat.equals(this.languageTags, audienceSelector.languageTags) && ObjectsCompat.equals(this.testDevices, audienceSelector.testDevices) && ObjectsCompat.equals(this.tagSelector, audienceSelector.tagSelector) && ObjectsCompat.equals(this.versionPredicate, audienceSelector.versionPredicate) && ObjectsCompat.equals(this.permissionsPredicate, audienceSelector.permissionsPredicate) && ObjectsCompat.equals(this.missBehavior, audienceSelector.missBehavior);
    }

    public int hashCode() {
        return ObjectsCompat.hash(this.newUser, this.notificationsOptIn, this.locationOptIn, this.requiresAnalytics, this.languageTags, this.testDevices, this.tagSelector, this.versionPredicate, this.permissionsPredicate, this.missBehavior);
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u0005J\u0010\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u0005H\u0007J\u0006\u0010>\u001a\u00020?J\u0015\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\u000bH\u0000¢\u0006\u0002\bBJ\u0016\u0010C\u001a\u00020\u00002\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u000e\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020\u0014J\u000e\u0010G\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010H\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0014H\u0007J\u000e\u0010I\u001a\u00020\u00002\u0006\u0010F\u001a\u00020\u0014J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020'J\u000e\u0010L\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0014J\u0010\u0010M\u001a\u00020\u00002\b\u0010/\u001a\u0004\u0018\u000100J\u0010\u0010N\u001a\u00020\u00002\b\u0010O\u001a\u0004\u0018\u00010PJ\u0010\u0010Q\u001a\u00020\u00002\b\u0010K\u001a\u0004\u0018\u00010'R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001e\u0010#\u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b$\u0010\u0016\"\u0004\b%\u0010\u0018R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010,\u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0007R\u001c\u00107\u001a\u0004\u0018\u00010'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010)\"\u0004\b9\u0010+¨\u0006R"}, d2 = {"Lcom/urbanairship/audience/AudienceSelector$Builder;", "", "()V", "deviceTypes", "", "", "getDeviceTypes$urbanairship_core_release", "()Ljava/util/List;", "setDeviceTypes$urbanairship_core_release", "(Ljava/util/List;)V", "hashSelector", "Lcom/urbanairship/audience/AudienceHashSelector;", "getHashSelector$urbanairship_core_release", "()Lcom/urbanairship/audience/AudienceHashSelector;", "setHashSelector$urbanairship_core_release", "(Lcom/urbanairship/audience/AudienceHashSelector;)V", "languageTags", "", "getLanguageTags$urbanairship_core_release", "locationOptIn", "", "getLocationOptIn$urbanairship_core_release", "()Ljava/lang/Boolean;", "setLocationOptIn$urbanairship_core_release", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "missBehavior", "Lcom/urbanairship/audience/AudienceSelector$MissBehavior;", "getMissBehavior$urbanairship_core_release", "()Lcom/urbanairship/audience/AudienceSelector$MissBehavior;", "setMissBehavior$urbanairship_core_release", "(Lcom/urbanairship/audience/AudienceSelector$MissBehavior;)V", "newUser", "getNewUser$urbanairship_core_release", "setNewUser$urbanairship_core_release", "notificationsOptIn", "getNotificationsOptIn$urbanairship_core_release", "setNotificationsOptIn$urbanairship_core_release", "permissionsPredicate", "Lcom/urbanairship/json/JsonPredicate;", "getPermissionsPredicate$urbanairship_core_release", "()Lcom/urbanairship/json/JsonPredicate;", "setPermissionsPredicate$urbanairship_core_release", "(Lcom/urbanairship/json/JsonPredicate;)V", "requiresAnalytics", "getRequiresAnalytics$urbanairship_core_release", "setRequiresAnalytics$urbanairship_core_release", "tagSelector", "Lcom/urbanairship/audience/DeviceTagSelector;", "getTagSelector$urbanairship_core_release", "()Lcom/urbanairship/audience/DeviceTagSelector;", "setTagSelector$urbanairship_core_release", "(Lcom/urbanairship/audience/DeviceTagSelector;)V", "testDevices", "getTestDevices$urbanairship_core_release", "versionPredicate", "getVersionPredicate$urbanairship_core_release", "setVersionPredicate$urbanairship_core_release", "addLanguageTag", "languageTag", "addTestDevice", "hash", "build", "Lcom/urbanairship/audience/AudienceSelector;", "setAudienceHashSelector", "selector", "setAudienceHashSelector$urbanairship_core_release", "setDeviceTypes", "types", "setLocationOptIn", "optIn", "setMissBehavior", "setNewUser", "setNotificationsOptIn", "setPermissionsPredicate", "predicate", "setRequiresAnalytics", "setTagSelector", "setVersionMatcher", "valueMatcher", "Lcom/urbanairship/json/ValueMatcher;", "setVersionPredicate", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Builder {
        private List deviceTypes;
        private AudienceHashSelector hashSelector;
        private Boolean locationOptIn;
        private Boolean newUser;
        private Boolean notificationsOptIn;
        private JsonPredicate permissionsPredicate;
        private Boolean requiresAnalytics;
        private DeviceTagSelector tagSelector;
        private JsonPredicate versionPredicate;
        private final List languageTags = new ArrayList();
        private final List testDevices = new ArrayList();
        private MissBehavior missBehavior = MissBehavior.PENALIZE;

        @Nullable
        /* renamed from: getNewUser$urbanairship_core_release, reason: from getter */
        public final Boolean getNewUser() {
            return this.newUser;
        }

        public final void setNewUser$urbanairship_core_release(@Nullable Boolean bool) {
            this.newUser = bool;
        }

        @Nullable
        /* renamed from: getNotificationsOptIn$urbanairship_core_release, reason: from getter */
        public final Boolean getNotificationsOptIn() {
            return this.notificationsOptIn;
        }

        public final void setNotificationsOptIn$urbanairship_core_release(@Nullable Boolean bool) {
            this.notificationsOptIn = bool;
        }

        @Nullable
        /* renamed from: getLocationOptIn$urbanairship_core_release, reason: from getter */
        public final Boolean getLocationOptIn() {
            return this.locationOptIn;
        }

        public final void setLocationOptIn$urbanairship_core_release(@Nullable Boolean bool) {
            this.locationOptIn = bool;
        }

        @Nullable
        /* renamed from: getRequiresAnalytics$urbanairship_core_release, reason: from getter */
        public final Boolean getRequiresAnalytics() {
            return this.requiresAnalytics;
        }

        public final void setRequiresAnalytics$urbanairship_core_release(@Nullable Boolean bool) {
            this.requiresAnalytics = bool;
        }

        @NotNull
        public final List<String> getLanguageTags$urbanairship_core_release() {
            return this.languageTags;
        }

        @NotNull
        public final List<String> getTestDevices$urbanairship_core_release() {
            return this.testDevices;
        }

        @NotNull
        /* renamed from: getMissBehavior$urbanairship_core_release, reason: from getter */
        public final MissBehavior getMissBehavior() {
            return this.missBehavior;
        }

        public final void setMissBehavior$urbanairship_core_release(@NotNull MissBehavior missBehavior) {
            Intrinsics.checkNotNullParameter(missBehavior, "<set-?>");
            this.missBehavior = missBehavior;
        }

        @Nullable
        /* renamed from: getVersionPredicate$urbanairship_core_release, reason: from getter */
        public final JsonPredicate getVersionPredicate() {
            return this.versionPredicate;
        }

        public final void setVersionPredicate$urbanairship_core_release(@Nullable JsonPredicate jsonPredicate) {
            this.versionPredicate = jsonPredicate;
        }

        @Nullable
        /* renamed from: getPermissionsPredicate$urbanairship_core_release, reason: from getter */
        public final JsonPredicate getPermissionsPredicate() {
            return this.permissionsPredicate;
        }

        public final void setPermissionsPredicate$urbanairship_core_release(@Nullable JsonPredicate jsonPredicate) {
            this.permissionsPredicate = jsonPredicate;
        }

        @Nullable
        /* renamed from: getTagSelector$urbanairship_core_release, reason: from getter */
        public final DeviceTagSelector getTagSelector() {
            return this.tagSelector;
        }

        public final void setTagSelector$urbanairship_core_release(@Nullable DeviceTagSelector deviceTagSelector) {
            this.tagSelector = deviceTagSelector;
        }

        @Nullable
        /* renamed from: getHashSelector$urbanairship_core_release, reason: from getter */
        public final AudienceHashSelector getHashSelector() {
            return this.hashSelector;
        }

        public final void setHashSelector$urbanairship_core_release(@Nullable AudienceHashSelector audienceHashSelector) {
            this.hashSelector = audienceHashSelector;
        }

        @Nullable
        public final List<String> getDeviceTypes$urbanairship_core_release() {
            return this.deviceTypes;
        }

        public final void setDeviceTypes$urbanairship_core_release(@Nullable List<String> list) {
            this.deviceTypes = list;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public final Builder setNewUser(boolean newUser) {
            this.newUser = Boolean.valueOf(newUser);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public final Builder addTestDevice(@NotNull String hash) {
            Intrinsics.checkNotNullParameter(hash, "hash");
            this.testDevices.add(hash);
            return this;
        }

        @NotNull
        public final Builder setAudienceHashSelector$urbanairship_core_release(@NotNull AudienceHashSelector selector) {
            Intrinsics.checkNotNullParameter(selector, "selector");
            this.hashSelector = selector;
            return this;
        }

        @NotNull
        public final Builder setLocationOptIn(boolean optIn) {
            this.locationOptIn = Boolean.valueOf(optIn);
            return this;
        }

        @NotNull
        public final Builder setRequiresAnalytics(boolean requiresAnalytics) {
            this.requiresAnalytics = Boolean.valueOf(requiresAnalytics);
            return this;
        }

        @NotNull
        public final Builder setNotificationsOptIn(boolean optIn) {
            this.notificationsOptIn = Boolean.valueOf(optIn);
            return this;
        }

        @NotNull
        public final Builder addLanguageTag(@NotNull String languageTag) {
            Intrinsics.checkNotNullParameter(languageTag, "languageTag");
            this.languageTags.add(languageTag);
            return this;
        }

        @NotNull
        public final Builder setVersionPredicate(@Nullable JsonPredicate predicate) {
            this.versionPredicate = predicate;
            return this;
        }

        @NotNull
        public final Builder setPermissionsPredicate(@NotNull JsonPredicate predicate) {
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            this.permissionsPredicate = predicate;
            return this;
        }

        @NotNull
        public final Builder setVersionMatcher(@Nullable ValueMatcher valueMatcher) {
            return setVersionPredicate(valueMatcher == null ? null : VersionUtils.createVersionPredicate(valueMatcher));
        }

        @NotNull
        public final Builder setTagSelector(@Nullable DeviceTagSelector tagSelector) {
            this.tagSelector = tagSelector;
            return this;
        }

        @NotNull
        public final Builder setMissBehavior(@NotNull MissBehavior missBehavior) {
            Intrinsics.checkNotNullParameter(missBehavior, "missBehavior");
            this.missBehavior = missBehavior;
            return this;
        }

        @NotNull
        public final Builder setDeviceTypes(@Nullable List<String> types) {
            this.deviceTypes = types;
            return this;
        }

        @NotNull
        public final AudienceSelector build() {
            return new AudienceSelector(this, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0116 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object evaluate(long r9, @org.jetbrains.annotations.NotNull com.urbanairship.audience.DeviceInfoProvider r11, @org.jetbrains.annotations.NotNull com.urbanairship.audience.HashChecker r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.audience.AirshipDeviceAudienceResult> r13) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.audience.AudienceSelector.evaluate(long, com.urbanairship.audience.DeviceInfoProvider, com.urbanairship.audience.HashChecker, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean checkDeviceType(DeviceInfoProvider infoProvider) {
        List list = this.deviceTypes;
        if (list != null) {
            return list.contains(infoProvider.getPlatform());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object checkTestDevice(com.urbanairship.audience.DeviceInfoProvider r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.urbanairship.audience.AudienceSelector.C09801
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.audience.AudienceSelector$checkTestDevice$1 r0 = (com.urbanairship.audience.AudienceSelector.C09801) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.audience.AudienceSelector$checkTestDevice$1 r0 = new com.urbanairship.audience.AudienceSelector$checkTestDevice$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            java.lang.Object r5 = r0.L$0
            com.urbanairship.audience.AudienceSelector r5 = (com.urbanairship.audience.AudienceSelector) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5c
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r7)
            java.util.List r7 = r5.testDevices
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L46
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r5
        L46:
            boolean r7 = r6.getChannelCreated()
            if (r7 != 0) goto L51
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        L51:
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r7 = r6.getChannelId(r0)
            if (r7 != r1) goto L5c
            return r1
        L5c:
            java.lang.String r7 = (java.lang.String) r7
            byte[] r6 = com.urbanairship.util.UAStringUtil.sha256Digest(r7)
            if (r6 == 0) goto L94
            int r7 = r6.length
            r0 = 16
            if (r7 >= r0) goto L6a
            goto L94
        L6a:
            byte[] r6 = java.util.Arrays.copyOf(r6, r0)
            java.util.List r5 = r5.testDevices
            java.util.Iterator r5 = r5.iterator()
        L74:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L8f
            java.lang.Object r7 = r5.next()
            java.lang.String r7 = (java.lang.String) r7
            byte[] r7 = com.urbanairship.util.UAStringUtil.base64Decode(r7)
            boolean r7 = java.util.Arrays.equals(r6, r7)
            if (r7 == 0) goto L74
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r5
        L8f:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        L94:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.audience.AudienceSelector.checkTestDevice(com.urbanairship.audience.DeviceInfoProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean checkNotificationOptInStatus(DeviceInfoProvider dataProvider) {
        Boolean bool = this.notificationsOptIn;
        return bool == null || bool.booleanValue() == dataProvider.isNotificationsOptedIn();
    }

    private final boolean checkLocale(DeviceInfoProvider dataProvider) {
        if (this.languageTags.isEmpty()) {
            return true;
        }
        Locale locale = dataProvider.getLocale();
        try {
            String strJoin = UAStringUtil.join(sanitizedLanguageTags(this.languageTags), ",");
            Intrinsics.checkNotNullExpressionValue(strJoin, "join(...)");
            LocaleListCompat localeListCompatForLanguageTags = LocaleListCompat.forLanguageTags(strJoin);
            Intrinsics.checkNotNullExpressionValue(localeListCompatForLanguageTags, "forLanguageTags(...)");
            int size = localeListCompatForLanguageTags.size();
            for (int i = 0; i < size; i++) {
                Locale locale2 = localeListCompatForLanguageTags.get(i);
                String language = locale.getLanguage();
                Intrinsics.checkNotNull(locale2);
                if (Intrinsics.areEqual(language, locale2.getLanguage()) && (UAStringUtil.isEmpty(locale2.getCountry()) || Intrinsics.areEqual(locale2.getCountry(), locale.getCountry()))) {
                    return true;
                }
            }
        } catch (Exception e) {
            UALog.e("Unable to construct locale list: ", e);
        }
        return false;
    }

    private final boolean checkTags(DeviceInfoProvider infoProvider) {
        DeviceTagSelector deviceTagSelector = this.tagSelector;
        if (deviceTagSelector == null) {
            return true;
        }
        return deviceTagSelector.apply(infoProvider.getChannelTags());
    }

    private final boolean checkAnalytics(DeviceInfoProvider infoProvider) {
        Boolean bool = this.requiresAnalytics;
        if (bool == null || !bool.booleanValue()) {
            return true;
        }
        return infoProvider.getAnalyticsEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object checkPermissions(com.urbanairship.audience.DeviceInfoProvider r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.urbanairship.audience.AudienceSelector.C09791
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.audience.AudienceSelector$checkPermissions$1 r0 = (com.urbanairship.audience.AudienceSelector.C09791) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.audience.AudienceSelector$checkPermissions$1 r0 = new com.urbanairship.audience.AudienceSelector$checkPermissions$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            com.urbanairship.audience.AudienceSelector r4 = (com.urbanairship.audience.AudienceSelector) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L50
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.Boolean r6 = r4.locationOptIn
            if (r6 != 0) goto L45
            com.urbanairship.json.JsonPredicate r6 = r4.permissionsPredicate
            if (r6 != 0) goto L45
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r4
        L45:
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r5.getPermissionStatuses(r0)
            if (r6 != r1) goto L50
            return r1
        L50:
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Boolean r5 = r4.locationOptIn
            r0 = 0
            if (r5 == 0) goto L7b
            com.urbanairship.permission.Permission r5 = com.urbanairship.permission.Permission.LOCATION
            java.lang.Object r5 = r6.get(r5)
            com.urbanairship.permission.PermissionStatus r5 = (com.urbanairship.permission.PermissionStatus) r5
            if (r5 != 0) goto L63
            com.urbanairship.permission.PermissionStatus r5 = com.urbanairship.permission.PermissionStatus.NOT_DETERMINED
        L63:
            com.urbanairship.permission.PermissionStatus r1 = com.urbanairship.permission.PermissionStatus.GRANTED
            if (r1 != r5) goto L69
            r5 = r3
            goto L6a
        L69:
            r5 = r0
        L6a:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            java.lang.Boolean r1 = r4.locationOptIn
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r1)
            if (r5 != 0) goto L7b
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r4
        L7b:
            com.urbanairship.json.JsonPredicate r5 = r4.permissionsPredicate
            if (r5 == 0) goto Lcd
            java.util.ArrayList r5 = new java.util.ArrayList
            int r1 = r6.size()
            r5.<init>(r1)
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L90:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto Lb8
            java.lang.Object r1 = r6.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            com.urbanairship.permission.Permission r2 = (com.urbanairship.permission.Permission) r2
            java.lang.String r2 = r2.getValue()
            java.lang.Object r1 = r1.getValue()
            com.urbanairship.permission.PermissionStatus r1 = (com.urbanairship.permission.PermissionStatus) r1
            java.lang.String r1 = r1.getValue()
            kotlin.Pair r1 = kotlin.TuplesKt.to(r2, r1)
            r5.add(r1)
            goto L90
        Lb8:
            java.util.Map r5 = kotlin.collections.MapsKt.toMap(r5)
            com.urbanairship.json.JsonPredicate r4 = r4.permissionsPredicate
            com.urbanairship.json.JsonValue r5 = com.urbanairship.json.JsonValue.wrap(r5)
            boolean r4 = r4.apply(r5)
            if (r4 != 0) goto Lcd
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r4
        Lcd:
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.audience.AudienceSelector.checkPermissions(com.urbanairship.audience.DeviceInfoProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean checkVersion(DeviceInfoProvider infoProvider) {
        JsonPredicate jsonPredicate = this.versionPredicate;
        if (jsonPredicate == null) {
            return true;
        }
        JsonSerializable jsonSerializableCreateVersionObject = VersionUtils.createVersionObject(infoProvider.getAppVersionCode());
        Intrinsics.checkNotNullExpressionValue(jsonSerializableCreateVersionObject, "createVersionObject(...)");
        return jsonPredicate.apply(jsonSerializableCreateVersionObject);
    }

    private final boolean checkNewUser(DeviceInfoProvider infoProvider, long cutOffDate) {
        Boolean bool = this.newUser;
        if (bool != null) {
            return bool.booleanValue() == ((infoProvider.getInstallDateMilliseconds() > cutOffDate ? 1 : (infoProvider.getInstallDateMilliseconds() == cutOffDate ? 0 : -1)) >= 0);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object checkHash(com.urbanairship.audience.DeviceInfoProvider r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.urbanairship.audience.AudienceSelector.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.urbanairship.audience.AudienceSelector$checkHash$1 r0 = (com.urbanairship.audience.AudienceSelector.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.audience.AudienceSelector$checkHash$1 r0 = new com.urbanairship.audience.AudienceSelector$checkHash$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r0.L$0
            com.urbanairship.audience.AudienceHashSelector r7 = (com.urbanairship.audience.AudienceHashSelector) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L74
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            java.lang.Object r6 = r0.L$1
            com.urbanairship.audience.AudienceHashSelector r6 = (com.urbanairship.audience.AudienceHashSelector) r6
            java.lang.Object r7 = r0.L$0
            com.urbanairship.audience.DeviceInfoProvider r7 = (com.urbanairship.audience.DeviceInfoProvider) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L61
        L48:
            kotlin.ResultKt.throwOnFailure(r8)
            com.urbanairship.audience.AudienceHashSelector r6 = r6.audienceHash
            if (r6 != 0) goto L54
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r6
        L54:
            r0.L$0 = r7
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r8 = r7.getChannelId(r0)
            if (r8 != r1) goto L61
            return r1
        L61:
            java.lang.String r8 = (java.lang.String) r8
            r0.L$0 = r6
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r7 = r7.getStableContactInfo(r0)
            if (r7 != r1) goto L70
            return r1
        L70:
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L74:
            com.urbanairship.contacts.StableContactInfo r8 = (com.urbanairship.contacts.StableContactInfo) r8
            java.lang.String r8 = r8.getContactId()
            boolean r6 = r7.evaluate$urbanairship_core_release(r6, r8)
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.audience.AudienceSelector.checkHash(com.urbanairship.audience.DeviceInfoProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Set sanitizedLanguageTags(List languageTags) {
        ArrayList arrayList = new ArrayList();
        Iterator it = languageTags.iterator();
        while (it.hasNext()) {
            String strDropLast = (String) it.next();
            if (strDropLast.length() == 0) {
                strDropLast = null;
            } else if (StringsKt.endsWith$default(strDropLast, "_", false, 2, (Object) null) || StringsKt.endsWith$default(strDropLast, "-", false, 2, (Object) null)) {
                strDropLast = StringsKt.dropLast(strDropLast, 1);
            }
            if (strDropLast != null) {
                arrayList.add(strDropLast);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }
}
