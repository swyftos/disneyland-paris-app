package com.contentsquare.android.core.features.config.model;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import com.contentsquare.android.error.analysis.apierror.v2.EventProcessorPerformanceManager;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\u0018\u0000 \u00062\u00020\u0001:\u000e\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig;", "", "()V", "ApiErrors", "ApiErrorsV2", "ClientMode", "Companion", "FeatureFlag", "InAppConfig", "MaskingRules", "MaskingRulesFullMasking", "ProjectConfiguration", "ProjectConfigurations", "RootConfig", "SessionReplay", "StaticResourceManager", "WebView", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class JsonConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<Logger> logger$delegate = LazyKt.lazy(new Function0<Logger>() { // from class: com.contentsquare.android.core.features.config.model.JsonConfig$Companion$logger$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Logger invoke() {
            return new Logger("JsonConfig");
        }
    });

    @NotNull
    private static final Json format = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.contentsquare.android.core.features.config.model.JsonConfig$Companion$format$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
            invoke2(jsonBuilder);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.setIgnoreUnknownKeys(true);
            Json.setEncodeDefaults(true);
        }
    }, 1, null);

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000223Be\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\u0005\u0012\u0010\b\u0001\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0010\b\u0001\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBM\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\u0010J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JQ\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010'\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\u000bHÖ\u0001J!\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201HÇ\u0001R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u001d¨\u00064"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrors;", "", "seen1", "", "collectStandardHeaders", "", "collectQueryParams", "collectRequestBody", "collectResponseBody", "validUrls", "", "", "validCustomHeaders", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZZZZLjava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ZZZZLjava/util/List;Ljava/util/List;)V", "getCollectQueryParams$annotations", "()V", "getCollectQueryParams", "()Z", "getCollectRequestBody$annotations", "getCollectRequestBody", "getCollectResponseBody$annotations", "getCollectResponseBody", "getCollectStandardHeaders$annotations", "getCollectStandardHeaders", "getValidCustomHeaders$annotations", "getValidCustomHeaders", "()Ljava/util/List;", "getValidUrls$annotations", "getValidUrls", "component1", "component2", "component3", "component4", "component5", "component6", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ApiErrors {

        @JvmField
        @NotNull
        private static final KSerializer<Object>[] $childSerializers;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final boolean collectQueryParams;
        private final boolean collectRequestBody;
        private final boolean collectResponseBody;
        private final boolean collectStandardHeaders;

        @NotNull
        private final List<String> validCustomHeaders;

        @NotNull
        private final List<String> validUrls;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrors$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrors;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<ApiErrors> serializer() {
                return JsonConfig$ApiErrors$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            $childSerializers = new KSerializer[]{null, null, null, null, new ArrayListSerializer(stringSerializer), new ArrayListSerializer(stringSerializer)};
        }

        public ApiErrors() {
            this(false, false, false, false, (List) null, (List) null, 63, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ApiErrors copy$default(ApiErrors apiErrors, boolean z, boolean z2, boolean z3, boolean z4, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = apiErrors.collectStandardHeaders;
            }
            if ((i & 2) != 0) {
                z2 = apiErrors.collectQueryParams;
            }
            boolean z5 = z2;
            if ((i & 4) != 0) {
                z3 = apiErrors.collectRequestBody;
            }
            boolean z6 = z3;
            if ((i & 8) != 0) {
                z4 = apiErrors.collectResponseBody;
            }
            boolean z7 = z4;
            if ((i & 16) != 0) {
                list = apiErrors.validUrls;
            }
            List list3 = list;
            if ((i & 32) != 0) {
                list2 = apiErrors.validCustomHeaders;
            }
            return apiErrors.copy(z, z5, z6, z7, list3, list2);
        }

        @SerialName("collect_query_params")
        public static /* synthetic */ void getCollectQueryParams$annotations() {
        }

        @SerialName("collect_request_body")
        public static /* synthetic */ void getCollectRequestBody$annotations() {
        }

        @SerialName("collect_response_body")
        public static /* synthetic */ void getCollectResponseBody$annotations() {
        }

        @SerialName("collect_standard_headers")
        public static /* synthetic */ void getCollectStandardHeaders$annotations() {
        }

        @SerialName("valid_custom_headers")
        public static /* synthetic */ void getValidCustomHeaders$annotations() {
        }

        @SerialName("valid_urls")
        public static /* synthetic */ void getValidUrls$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self(ApiErrors self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.collectStandardHeaders) {
                output.encodeBooleanElement(serialDesc, 0, self.collectStandardHeaders);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.collectQueryParams) {
                output.encodeBooleanElement(serialDesc, 1, self.collectQueryParams);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.collectRequestBody) {
                output.encodeBooleanElement(serialDesc, 2, self.collectRequestBody);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.collectResponseBody) {
                output.encodeBooleanElement(serialDesc, 3, self.collectResponseBody);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.validUrls, CollectionsKt.emptyList())) {
                output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.validUrls);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 5) && Intrinsics.areEqual(self.validCustomHeaders, CollectionsKt.emptyList())) {
                return;
            }
            output.encodeSerializableElement(serialDesc, 5, kSerializerArr[5], self.validCustomHeaders);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getCollectStandardHeaders() {
            return this.collectStandardHeaders;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getCollectQueryParams() {
            return this.collectQueryParams;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getCollectRequestBody() {
            return this.collectRequestBody;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getCollectResponseBody() {
            return this.collectResponseBody;
        }

        @NotNull
        public final List<String> component5() {
            return this.validUrls;
        }

        @NotNull
        public final List<String> component6() {
            return this.validCustomHeaders;
        }

        @NotNull
        public final ApiErrors copy(boolean collectStandardHeaders, boolean collectQueryParams, boolean collectRequestBody, boolean collectResponseBody, List<String> validUrls, List<String> validCustomHeaders) {
            Intrinsics.checkNotNullParameter(validUrls, "validUrls");
            Intrinsics.checkNotNullParameter(validCustomHeaders, "validCustomHeaders");
            return new ApiErrors(collectStandardHeaders, collectQueryParams, collectRequestBody, collectResponseBody, validUrls, validCustomHeaders);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ApiErrors)) {
                return false;
            }
            ApiErrors apiErrors = (ApiErrors) other;
            return this.collectStandardHeaders == apiErrors.collectStandardHeaders && this.collectQueryParams == apiErrors.collectQueryParams && this.collectRequestBody == apiErrors.collectRequestBody && this.collectResponseBody == apiErrors.collectResponseBody && Intrinsics.areEqual(this.validUrls, apiErrors.validUrls) && Intrinsics.areEqual(this.validCustomHeaders, apiErrors.validCustomHeaders);
        }

        public final boolean getCollectQueryParams() {
            return this.collectQueryParams;
        }

        public final boolean getCollectRequestBody() {
            return this.collectRequestBody;
        }

        public final boolean getCollectResponseBody() {
            return this.collectResponseBody;
        }

        public final boolean getCollectStandardHeaders() {
            return this.collectStandardHeaders;
        }

        @NotNull
        public final List<String> getValidCustomHeaders() {
            return this.validCustomHeaders;
        }

        @NotNull
        public final List<String> getValidUrls() {
            return this.validUrls;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
        public int hashCode() {
            boolean z = this.collectStandardHeaders;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.collectQueryParams;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            ?? r22 = this.collectRequestBody;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            boolean z2 = this.collectResponseBody;
            return this.validCustomHeaders.hashCode() + ((this.validUrls.hashCode() + ((i5 + (z2 ? 1 : z2 ? 1 : 0)) * 31)) * 31);
        }

        @NotNull
        public String toString() {
            return "ApiErrors(collectStandardHeaders=" + this.collectStandardHeaders + ", collectQueryParams=" + this.collectQueryParams + ", collectRequestBody=" + this.collectRequestBody + ", collectResponseBody=" + this.collectResponseBody + ", validUrls=" + this.validUrls + ", validCustomHeaders=" + this.validCustomHeaders + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ ApiErrors(int i, @SerialName("collect_standard_headers") boolean z, @SerialName("collect_query_params") boolean z2, @SerialName("collect_request_body") boolean z3, @SerialName("collect_response_body") boolean z4, @SerialName("valid_urls") List list, @SerialName("valid_custom_headers") List list2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.collectStandardHeaders = false;
            } else {
                this.collectStandardHeaders = z;
            }
            if ((i & 2) == 0) {
                this.collectQueryParams = false;
            } else {
                this.collectQueryParams = z2;
            }
            if ((i & 4) == 0) {
                this.collectRequestBody = false;
            } else {
                this.collectRequestBody = z3;
            }
            if ((i & 8) == 0) {
                this.collectResponseBody = false;
            } else {
                this.collectResponseBody = z4;
            }
            if ((i & 16) == 0) {
                this.validUrls = CollectionsKt.emptyList();
            } else {
                this.validUrls = list;
            }
            if ((i & 32) == 0) {
                this.validCustomHeaders = CollectionsKt.emptyList();
            } else {
                this.validCustomHeaders = list2;
            }
        }

        public ApiErrors(boolean z, boolean z2, boolean z3, boolean z4, List<String> validUrls, List<String> validCustomHeaders) {
            Intrinsics.checkNotNullParameter(validUrls, "validUrls");
            Intrinsics.checkNotNullParameter(validCustomHeaders, "validCustomHeaders");
            this.collectStandardHeaders = z;
            this.collectQueryParams = z2;
            this.collectRequestBody = z3;
            this.collectResponseBody = z4;
            this.validUrls = validUrls;
            this.validCustomHeaders = validCustomHeaders;
        }

        public /* synthetic */ ApiErrors(boolean z, boolean z2, boolean z3, boolean z4, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? CollectionsKt.emptyList() : list, (i & 32) != 0 ? CollectionsKt.emptyList() : list2);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0005#$%&'B5\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0001\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J#\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J!\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÇ\u0001R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2;", "", "seen1", "", "collectStandardHeaders", "", "collectionRules", "", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2$CollectionRule;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ZLjava/util/List;)V", "getCollectStandardHeaders$annotations", "()V", "getCollectStandardHeaders", "()Z", "getCollectionRules$annotations", "getCollectionRules", "()Ljava/util/List;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "BodyAttributePath", "CollectionRule", "Companion", "CustomHeader", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ApiErrorsV2 {
        private final boolean collectStandardHeaders;

        @NotNull
        private final List<CollectionRule> collectionRules;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @JvmField
        @NotNull
        private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(JsonConfig$ApiErrorsV2$CollectionRule$$serializer.INSTANCE)};

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B=\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J!\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#HÇ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006&"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2$BodyAttributePath;", "", "seen1", "", "path", "", "encrypted", "", "primary", "type", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ZZLjava/lang/String;)V", "getEncrypted", "()Z", "getPath", "()Ljava/lang/String;", "getPrimary", "getType", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @Serializable
        public static final /* data */ class BodyAttributePath {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);
            private final boolean encrypted;

            @NotNull
            private final String path;
            private final boolean primary;

            @NotNull
            private final String type;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2$BodyAttributePath$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2$BodyAttributePath;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @NotNull
                public final KSerializer<BodyAttributePath> serializer() {
                    return JsonConfig$ApiErrorsV2$BodyAttributePath$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ BodyAttributePath(int i, String str, boolean z, boolean z2, String str2, SerializationConstructorMarker serializationConstructorMarker) {
                if (15 != (i & 15)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 15, JsonConfig$ApiErrorsV2$BodyAttributePath$$serializer.INSTANCE.getDescriptor());
                }
                this.path = str;
                this.encrypted = z;
                this.primary = z2;
                this.type = str2;
            }

            public static /* synthetic */ BodyAttributePath copy$default(BodyAttributePath bodyAttributePath, String str, boolean z, boolean z2, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = bodyAttributePath.path;
                }
                if ((i & 2) != 0) {
                    z = bodyAttributePath.encrypted;
                }
                if ((i & 4) != 0) {
                    z2 = bodyAttributePath.primary;
                }
                if ((i & 8) != 0) {
                    str2 = bodyAttributePath.type;
                }
                return bodyAttributePath.copy(str, z, z2, str2);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self(BodyAttributePath self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeStringElement(serialDesc, 0, self.path);
                output.encodeBooleanElement(serialDesc, 1, self.encrypted);
                output.encodeBooleanElement(serialDesc, 2, self.primary);
                output.encodeStringElement(serialDesc, 3, self.type);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getPath() {
                return this.path;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getEncrypted() {
                return this.encrypted;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getPrimary() {
                return this.primary;
            }

            @NotNull
            /* renamed from: component4, reason: from getter */
            public final String getType() {
                return this.type;
            }

            @NotNull
            public final BodyAttributePath copy(String path, boolean encrypted, boolean primary, String type) {
                Intrinsics.checkNotNullParameter(path, "path");
                Intrinsics.checkNotNullParameter(type, "type");
                return new BodyAttributePath(path, encrypted, primary, type);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof BodyAttributePath)) {
                    return false;
                }
                BodyAttributePath bodyAttributePath = (BodyAttributePath) other;
                return Intrinsics.areEqual(this.path, bodyAttributePath.path) && this.encrypted == bodyAttributePath.encrypted && this.primary == bodyAttributePath.primary && Intrinsics.areEqual(this.type, bodyAttributePath.type);
            }

            public final boolean getEncrypted() {
                return this.encrypted;
            }

            @NotNull
            public final String getPath() {
                return this.path;
            }

            public final boolean getPrimary() {
                return this.primary;
            }

            @NotNull
            public final String getType() {
                return this.type;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int iHashCode = this.path.hashCode() * 31;
                boolean z = this.encrypted;
                int i = z;
                if (z != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean z2 = this.primary;
                return this.type.hashCode() + ((i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31);
            }

            @NotNull
            public String toString() {
                return "BodyAttributePath(path=" + this.path + ", encrypted=" + this.encrypted + ", primary=" + this.primary + ", type=" + this.type + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public BodyAttributePath(String path, boolean z, boolean z2, String type) {
                Intrinsics.checkNotNullParameter(path, "path");
                Intrinsics.checkNotNullParameter(type, "type");
                this.path = path;
                this.encrypted = z;
                this.primary = z2;
                this.type = type;
            }
        }

        @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 @2\u00020\u0001:\u0002?@B}\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\t\u0012\b\b\u0001\u0010\u000b\u001a\u00020\t\u0012\u0010\b\u0001\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0010\b\u0001\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013Bg\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r¢\u0006\u0002\u0010\u0014J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\t\u0010/\u001a\u00020\tHÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00100\rHÆ\u0003Jp\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rHÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u00020\t2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0003HÖ\u0001J\t\u00107\u001a\u00020\u0005HÖ\u0001J!\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>HÇ\u0001R\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u001eR\u001c\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u001eR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u0018R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010(\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010'R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001b¨\u0006A"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2$CollectionRule;", "", "seen1", "", "url", "", "statusCode", "bodyContent", "collectQueryParams", "", "collectRequestBody", "collectResponseBody", "bodyAttributePaths", "", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2$BodyAttributePath;", "customHeaders", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2$CustomHeader;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZZZLjava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZZZLjava/util/List;Ljava/util/List;)V", "getBodyAttributePaths$annotations", "()V", "getBodyAttributePaths", "()Ljava/util/List;", "getBodyContent$annotations", "getBodyContent", "()Ljava/lang/String;", "getCollectQueryParams$annotations", "getCollectQueryParams", "()Z", "getCollectRequestBody$annotations", "getCollectRequestBody", "getCollectResponseBody$annotations", "getCollectResponseBody", "getCustomHeaders$annotations", "getCustomHeaders", "getStatusCode$annotations", "getStatusCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZZZLjava/util/List;Ljava/util/List;)Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2$CollectionRule;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @Serializable
        public static final /* data */ class CollectionRule {

            @NotNull
            private final List<BodyAttributePath> bodyAttributePaths;

            @Nullable
            private final String bodyContent;
            private final boolean collectQueryParams;
            private final boolean collectRequestBody;
            private final boolean collectResponseBody;

            @NotNull
            private final List<CustomHeader> customHeaders;

            @Nullable
            private final Integer statusCode;

            @Nullable
            private final String url;

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @JvmField
            @NotNull
            private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, new ArrayListSerializer(JsonConfig$ApiErrorsV2$BodyAttributePath$$serializer.INSTANCE), new ArrayListSerializer(JsonConfig$ApiErrorsV2$CustomHeader$$serializer.INSTANCE)};

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2$CollectionRule$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2$CollectionRule;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @NotNull
                public final KSerializer<CollectionRule> serializer() {
                    return JsonConfig$ApiErrorsV2$CollectionRule$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public CollectionRule() {
                this((String) null, (Integer) null, (String) null, false, false, false, (List) null, (List) null, 255, (DefaultConstructorMarker) null);
            }

            @SerialName("body_attribute_paths")
            public static /* synthetic */ void getBodyAttributePaths$annotations() {
            }

            @SerialName("body_content")
            public static /* synthetic */ void getBodyContent$annotations() {
            }

            @SerialName("collect_query_params")
            public static /* synthetic */ void getCollectQueryParams$annotations() {
            }

            @SerialName("collect_request_body")
            public static /* synthetic */ void getCollectRequestBody$annotations() {
            }

            @SerialName("collect_response_body")
            public static /* synthetic */ void getCollectResponseBody$annotations() {
            }

            @SerialName("custom_headers")
            public static /* synthetic */ void getCustomHeaders$annotations() {
            }

            @SerialName("status_code")
            public static /* synthetic */ void getStatusCode$annotations() {
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self(CollectionRule self, CompositeEncoder output, SerialDescriptor serialDesc) {
                KSerializer<Object>[] kSerializerArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.url != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.url);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.statusCode != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.statusCode);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.bodyContent != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.bodyContent);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.collectQueryParams) {
                    output.encodeBooleanElement(serialDesc, 3, self.collectQueryParams);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.collectRequestBody) {
                    output.encodeBooleanElement(serialDesc, 4, self.collectRequestBody);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.collectResponseBody) {
                    output.encodeBooleanElement(serialDesc, 5, self.collectResponseBody);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.bodyAttributePaths, CollectionsKt.emptyList())) {
                    output.encodeSerializableElement(serialDesc, 6, kSerializerArr[6], self.bodyAttributePaths);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 7) && Intrinsics.areEqual(self.customHeaders, CollectionsKt.emptyList())) {
                    return;
                }
                output.encodeSerializableElement(serialDesc, 7, kSerializerArr[7], self.customHeaders);
            }

            @Nullable
            /* renamed from: component1, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            @Nullable
            /* renamed from: component2, reason: from getter */
            public final Integer getStatusCode() {
                return this.statusCode;
            }

            @Nullable
            /* renamed from: component3, reason: from getter */
            public final String getBodyContent() {
                return this.bodyContent;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getCollectQueryParams() {
                return this.collectQueryParams;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getCollectRequestBody() {
                return this.collectRequestBody;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getCollectResponseBody() {
                return this.collectResponseBody;
            }

            @NotNull
            public final List<BodyAttributePath> component7() {
                return this.bodyAttributePaths;
            }

            @NotNull
            public final List<CustomHeader> component8() {
                return this.customHeaders;
            }

            @NotNull
            public final CollectionRule copy(String url, Integer statusCode, String bodyContent, boolean collectQueryParams, boolean collectRequestBody, boolean collectResponseBody, List<BodyAttributePath> bodyAttributePaths, List<CustomHeader> customHeaders) {
                Intrinsics.checkNotNullParameter(bodyAttributePaths, "bodyAttributePaths");
                Intrinsics.checkNotNullParameter(customHeaders, "customHeaders");
                return new CollectionRule(url, statusCode, bodyContent, collectQueryParams, collectRequestBody, collectResponseBody, bodyAttributePaths, customHeaders);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CollectionRule)) {
                    return false;
                }
                CollectionRule collectionRule = (CollectionRule) other;
                return Intrinsics.areEqual(this.url, collectionRule.url) && Intrinsics.areEqual(this.statusCode, collectionRule.statusCode) && Intrinsics.areEqual(this.bodyContent, collectionRule.bodyContent) && this.collectQueryParams == collectionRule.collectQueryParams && this.collectRequestBody == collectionRule.collectRequestBody && this.collectResponseBody == collectionRule.collectResponseBody && Intrinsics.areEqual(this.bodyAttributePaths, collectionRule.bodyAttributePaths) && Intrinsics.areEqual(this.customHeaders, collectionRule.customHeaders);
            }

            @NotNull
            public final List<BodyAttributePath> getBodyAttributePaths() {
                return this.bodyAttributePaths;
            }

            @Nullable
            public final String getBodyContent() {
                return this.bodyContent;
            }

            public final boolean getCollectQueryParams() {
                return this.collectQueryParams;
            }

            public final boolean getCollectRequestBody() {
                return this.collectRequestBody;
            }

            public final boolean getCollectResponseBody() {
                return this.collectResponseBody;
            }

            @NotNull
            public final List<CustomHeader> getCustomHeaders() {
                return this.customHeaders;
            }

            @Nullable
            public final Integer getStatusCode() {
                return this.statusCode;
            }

            @Nullable
            public final String getUrl() {
                return this.url;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                String str = this.url;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                Integer num = this.statusCode;
                int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
                String str2 = this.bodyContent;
                int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
                boolean z = this.collectQueryParams;
                int i = z;
                if (z != 0) {
                    i = 1;
                }
                int i2 = (iHashCode3 + i) * 31;
                boolean z2 = this.collectRequestBody;
                int i3 = z2;
                if (z2 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z3 = this.collectResponseBody;
                return this.customHeaders.hashCode() + ((this.bodyAttributePaths.hashCode() + ((i4 + (z3 ? 1 : z3 ? 1 : 0)) * 31)) * 31);
            }

            @NotNull
            public String toString() {
                return "CollectionRule(url=" + this.url + ", statusCode=" + this.statusCode + ", bodyContent=" + this.bodyContent + ", collectQueryParams=" + this.collectQueryParams + ", collectRequestBody=" + this.collectRequestBody + ", collectResponseBody=" + this.collectResponseBody + ", bodyAttributePaths=" + this.bodyAttributePaths + ", customHeaders=" + this.customHeaders + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ CollectionRule(int i, String str, @SerialName("status_code") Integer num, @SerialName("body_content") String str2, @SerialName("collect_query_params") boolean z, @SerialName("collect_request_body") boolean z2, @SerialName("collect_response_body") boolean z3, @SerialName("body_attribute_paths") List list, @SerialName("custom_headers") List list2, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.url = null;
                } else {
                    this.url = str;
                }
                if ((i & 2) == 0) {
                    this.statusCode = null;
                } else {
                    this.statusCode = num;
                }
                if ((i & 4) == 0) {
                    this.bodyContent = null;
                } else {
                    this.bodyContent = str2;
                }
                if ((i & 8) == 0) {
                    this.collectQueryParams = false;
                } else {
                    this.collectQueryParams = z;
                }
                if ((i & 16) == 0) {
                    this.collectRequestBody = false;
                } else {
                    this.collectRequestBody = z2;
                }
                if ((i & 32) == 0) {
                    this.collectResponseBody = false;
                } else {
                    this.collectResponseBody = z3;
                }
                if ((i & 64) == 0) {
                    this.bodyAttributePaths = CollectionsKt.emptyList();
                } else {
                    this.bodyAttributePaths = list;
                }
                if ((i & 128) == 0) {
                    this.customHeaders = CollectionsKt.emptyList();
                } else {
                    this.customHeaders = list2;
                }
            }

            public CollectionRule(String str, Integer num, String str2, boolean z, boolean z2, boolean z3, List<BodyAttributePath> bodyAttributePaths, List<CustomHeader> customHeaders) {
                Intrinsics.checkNotNullParameter(bodyAttributePaths, "bodyAttributePaths");
                Intrinsics.checkNotNullParameter(customHeaders, "customHeaders");
                this.url = str;
                this.statusCode = num;
                this.bodyContent = str2;
                this.collectQueryParams = z;
                this.collectRequestBody = z2;
                this.collectResponseBody = z3;
                this.bodyAttributePaths = bodyAttributePaths;
                this.customHeaders = customHeaders;
            }

            public /* synthetic */ CollectionRule(String str, Integer num, String str2, boolean z, boolean z2, boolean z3, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? CollectionsKt.emptyList() : list, (i & 128) != 0 ? CollectionsKt.emptyList() : list2);
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<ApiErrorsV2> serializer() {
                return JsonConfig$ApiErrorsV2$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B7\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J!\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÇ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006%"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2$CustomHeader;", "", "seen1", "", "headerName", "", "encrypted", "", "type", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ZLjava/lang/String;)V", "getEncrypted", "()Z", "getHeaderName$annotations", "()V", "getHeaderName", "()Ljava/lang/String;", "getType", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @Serializable
        public static final /* data */ class CustomHeader {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);
            private final boolean encrypted;

            @NotNull
            private final String headerName;

            @NotNull
            private final String type;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2$CustomHeader$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2$CustomHeader;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @NotNull
                public final KSerializer<CustomHeader> serializer() {
                    return JsonConfig$ApiErrorsV2$CustomHeader$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ CustomHeader(int i, @SerialName("header_name") String str, boolean z, String str2, SerializationConstructorMarker serializationConstructorMarker) {
                if (7 != (i & 7)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 7, JsonConfig$ApiErrorsV2$CustomHeader$$serializer.INSTANCE.getDescriptor());
                }
                this.headerName = str;
                this.encrypted = z;
                this.type = str2;
            }

            public static /* synthetic */ CustomHeader copy$default(CustomHeader customHeader, String str, boolean z, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = customHeader.headerName;
                }
                if ((i & 2) != 0) {
                    z = customHeader.encrypted;
                }
                if ((i & 4) != 0) {
                    str2 = customHeader.type;
                }
                return customHeader.copy(str, z, str2);
            }

            @SerialName("header_name")
            public static /* synthetic */ void getHeaderName$annotations() {
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self(CustomHeader self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeStringElement(serialDesc, 0, self.headerName);
                output.encodeBooleanElement(serialDesc, 1, self.encrypted);
                output.encodeStringElement(serialDesc, 2, self.type);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getHeaderName() {
                return this.headerName;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getEncrypted() {
                return this.encrypted;
            }

            @NotNull
            /* renamed from: component3, reason: from getter */
            public final String getType() {
                return this.type;
            }

            @NotNull
            public final CustomHeader copy(String headerName, boolean encrypted, String type) {
                Intrinsics.checkNotNullParameter(headerName, "headerName");
                Intrinsics.checkNotNullParameter(type, "type");
                return new CustomHeader(headerName, encrypted, type);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CustomHeader)) {
                    return false;
                }
                CustomHeader customHeader = (CustomHeader) other;
                return Intrinsics.areEqual(this.headerName, customHeader.headerName) && this.encrypted == customHeader.encrypted && Intrinsics.areEqual(this.type, customHeader.type);
            }

            public final boolean getEncrypted() {
                return this.encrypted;
            }

            @NotNull
            public final String getHeaderName() {
                return this.headerName;
            }

            @NotNull
            public final String getType() {
                return this.type;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int iHashCode = this.headerName.hashCode() * 31;
                boolean z = this.encrypted;
                int i = z;
                if (z != 0) {
                    i = 1;
                }
                return this.type.hashCode() + ((iHashCode + i) * 31);
            }

            @NotNull
            public String toString() {
                return "CustomHeader(headerName=" + this.headerName + ", encrypted=" + this.encrypted + ", type=" + this.type + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public CustomHeader(String headerName, boolean z, String type) {
                Intrinsics.checkNotNullParameter(headerName, "headerName");
                Intrinsics.checkNotNullParameter(type, "type");
                this.headerName = headerName;
                this.encrypted = z;
                this.type = type;
            }
        }

        public ApiErrorsV2() {
            this(false, (List) null, 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ApiErrorsV2 copy$default(ApiErrorsV2 apiErrorsV2, boolean z, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                z = apiErrorsV2.collectStandardHeaders;
            }
            if ((i & 2) != 0) {
                list = apiErrorsV2.collectionRules;
            }
            return apiErrorsV2.copy(z, list);
        }

        @SerialName("collect_standard_headers")
        public static /* synthetic */ void getCollectStandardHeaders$annotations() {
        }

        @SerialName("collection_rules")
        public static /* synthetic */ void getCollectionRules$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self(ApiErrorsV2 self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.collectStandardHeaders) {
                output.encodeBooleanElement(serialDesc, 0, self.collectStandardHeaders);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && Intrinsics.areEqual(self.collectionRules, CollectionsKt.emptyList())) {
                return;
            }
            output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.collectionRules);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getCollectStandardHeaders() {
            return this.collectStandardHeaders;
        }

        @NotNull
        public final List<CollectionRule> component2() {
            return this.collectionRules;
        }

        @NotNull
        public final ApiErrorsV2 copy(boolean collectStandardHeaders, List<CollectionRule> collectionRules) {
            Intrinsics.checkNotNullParameter(collectionRules, "collectionRules");
            return new ApiErrorsV2(collectStandardHeaders, collectionRules);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ApiErrorsV2)) {
                return false;
            }
            ApiErrorsV2 apiErrorsV2 = (ApiErrorsV2) other;
            return this.collectStandardHeaders == apiErrorsV2.collectStandardHeaders && Intrinsics.areEqual(this.collectionRules, apiErrorsV2.collectionRules);
        }

        public final boolean getCollectStandardHeaders() {
            return this.collectStandardHeaders;
        }

        @NotNull
        public final List<CollectionRule> getCollectionRules() {
            return this.collectionRules;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4 */
        public int hashCode() {
            boolean z = this.collectStandardHeaders;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            return this.collectionRules.hashCode() + (r0 * 31);
        }

        @NotNull
        public String toString() {
            return "ApiErrorsV2(collectStandardHeaders=" + this.collectStandardHeaders + ", collectionRules=" + this.collectionRules + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ ApiErrorsV2(int i, @SerialName("collect_standard_headers") boolean z, @SerialName("collection_rules") List list, SerializationConstructorMarker serializationConstructorMarker) {
            this.collectStandardHeaders = (i & 1) == 0 ? false : z;
            if ((i & 2) == 0) {
                this.collectionRules = CollectionsKt.emptyList();
            } else {
                this.collectionRules = list;
            }
        }

        public ApiErrorsV2(boolean z, List<CollectionRule> collectionRules) {
            Intrinsics.checkNotNullParameter(collectionRules, "collectionRules");
            this.collectStandardHeaders = z;
            this.collectionRules = collectionRules;
        }

        public /* synthetic */ ApiErrorsV2(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002 !B-\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J!\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÇ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$ClientMode;", "", "seen1", "", "snapshot", "", "snapshotEndpoint", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ZLjava/lang/String;)V", "getSnapshot", "()Z", "getSnapshotEndpoint$annotations", "()V", "getSnapshotEndpoint", "()Ljava/lang/String;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ClientMode {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final boolean snapshot;

        @NotNull
        private final String snapshotEndpoint;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$ClientMode$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ClientMode;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<ClientMode> serializer() {
                return JsonConfig$ClientMode$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ ClientMode(int i, boolean z, @SerialName("snapshot_endpoint") String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, JsonConfig$ClientMode$$serializer.INSTANCE.getDescriptor());
            }
            this.snapshot = z;
            this.snapshotEndpoint = str;
        }

        public static /* synthetic */ ClientMode copy$default(ClientMode clientMode, boolean z, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z = clientMode.snapshot;
            }
            if ((i & 2) != 0) {
                str = clientMode.snapshotEndpoint;
            }
            return clientMode.copy(z, str);
        }

        @SerialName("snapshot_endpoint")
        public static /* synthetic */ void getSnapshotEndpoint$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self(ClientMode self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeBooleanElement(serialDesc, 0, self.snapshot);
            output.encodeStringElement(serialDesc, 1, self.snapshotEndpoint);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getSnapshot() {
            return this.snapshot;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getSnapshotEndpoint() {
            return this.snapshotEndpoint;
        }

        @NotNull
        public final ClientMode copy(boolean snapshot, String snapshotEndpoint) {
            Intrinsics.checkNotNullParameter(snapshotEndpoint, "snapshotEndpoint");
            return new ClientMode(snapshot, snapshotEndpoint);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClientMode)) {
                return false;
            }
            ClientMode clientMode = (ClientMode) other;
            return this.snapshot == clientMode.snapshot && Intrinsics.areEqual(this.snapshotEndpoint, clientMode.snapshotEndpoint);
        }

        public final boolean getSnapshot() {
            return this.snapshot;
        }

        @NotNull
        public final String getSnapshotEndpoint() {
            return this.snapshotEndpoint;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4 */
        public int hashCode() {
            boolean z = this.snapshot;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            return this.snapshotEndpoint.hashCode() + (r0 * 31);
        }

        @NotNull
        public String toString() {
            return "ClientMode(snapshot=" + this.snapshot + ", snapshotEndpoint=" + this.snapshotEndpoint + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public ClientMode(boolean z, String snapshotEndpoint) {
            Intrinsics.checkNotNullParameter(snapshotEndpoint, "snapshotEndpoint");
            this.snapshot = z;
            this.snapshotEndpoint = snapshotEndpoint;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u000eH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$Companion;", "", "()V", "format", "Lkotlinx/serialization/json/Json;", "getFormat", "()Lkotlinx/serialization/json/Json;", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "getLogger", "()Lcom/contentsquare/android/core/features/logging/Logger;", "logger$delegate", "Lkotlin/Lazy;", "decodeFromString", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$RootConfig;", "jsonString", "", "encodeToString", "config", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @Nullable
        public final RootConfig decodeFromString(String jsonString) {
            Logger logger;
            String str;
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            try {
                RootConfig rootConfig = (RootConfig) getFormat().decodeFromString(RootConfig.INSTANCE.serializer(), jsonString);
                rootConfig.getProjectConfigurations().getProjectConfig().setCsProjectId(rootConfig.getCsProjectId());
                return rootConfig;
            } catch (SerializationException e) {
                e = e;
                logger = getLogger();
                str = "Failed to parse project configuration as String";
                logger.e(e, str);
                return null;
            } catch (IllegalArgumentException e2) {
                e = e2;
                logger = getLogger();
                str = "Failed to parse JSON project configuration as String";
                logger.e(e, str);
                return null;
            }
        }

        @JvmStatic
        @Nullable
        public final String encodeToString(RootConfig config) {
            Intrinsics.checkNotNullParameter(config, "config");
            try {
                return getFormat().encodeToString(RootConfig.INSTANCE.serializer(), config);
            } catch (SerializationException | IllegalArgumentException e) {
                this.getLogger().e(e, "Failed to serialise JSON project configuration as Json");
                return null;
            }
        }

        @NotNull
        public final Json getFormat() {
            return JsonConfig.format;
        }

        @NotNull
        public final Logger getLogger() {
            return (Logger) JsonConfig.logger$delegate.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B7\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J!\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÇ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006%"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$FeatureFlag;", "", "seen1", "", "name", "", "minVersion", "enabled", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getEnabled", "()Z", "getMinVersion$annotations", "()V", "getMinVersion", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable
    public static final /* data */ class FeatureFlag {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final boolean enabled;

        @NotNull
        private final String minVersion;

        @NotNull
        private final String name;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$FeatureFlag$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$FeatureFlag;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<FeatureFlag> serializer() {
                return JsonConfig$FeatureFlag$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ FeatureFlag(int i, String str, @SerialName("min_version") String str2, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, JsonConfig$FeatureFlag$$serializer.INSTANCE.getDescriptor());
            }
            this.name = str;
            this.minVersion = str2;
            this.enabled = z;
        }

        public static /* synthetic */ FeatureFlag copy$default(FeatureFlag featureFlag, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = featureFlag.name;
            }
            if ((i & 2) != 0) {
                str2 = featureFlag.minVersion;
            }
            if ((i & 4) != 0) {
                z = featureFlag.enabled;
            }
            return featureFlag.copy(str, str2, z);
        }

        @SerialName("min_version")
        public static /* synthetic */ void getMinVersion$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self(FeatureFlag self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.name);
            output.encodeStringElement(serialDesc, 1, self.minVersion);
            output.encodeBooleanElement(serialDesc, 2, self.enabled);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getMinVersion() {
            return this.minVersion;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getEnabled() {
            return this.enabled;
        }

        @NotNull
        public final FeatureFlag copy(String name, String minVersion, boolean enabled) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(minVersion, "minVersion");
            return new FeatureFlag(name, minVersion, enabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FeatureFlag)) {
                return false;
            }
            FeatureFlag featureFlag = (FeatureFlag) other;
            return Intrinsics.areEqual(this.name, featureFlag.name) && Intrinsics.areEqual(this.minVersion, featureFlag.minVersion) && this.enabled == featureFlag.enabled;
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        @NotNull
        public final String getMinVersion() {
            return this.minVersion;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iHashCode = (this.minVersion.hashCode() + (this.name.hashCode() * 31)) * 31;
            boolean z = this.enabled;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        @NotNull
        public String toString() {
            return "FeatureFlag(name=" + this.name + ", minVersion=" + this.minVersion + ", enabled=" + this.enabled + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public FeatureFlag(String name, String minVersion, boolean z) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(minVersion, "minVersion");
            this.name = name;
            this.minVersion = minVersion;
            this.enabled = z;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002 !B-\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0019\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J!\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÇ\u0001R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$InAppConfig;", "", "seen1", "", "activationKey", "", "enabled", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Z)V", "getActivationKey$annotations", "()V", "getActivationKey", "()Ljava/lang/String;", "getEnabled", "()Z", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable
    public static final /* data */ class InAppConfig {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final String activationKey;
        private final boolean enabled;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$InAppConfig$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$InAppConfig;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<InAppConfig> serializer() {
                return JsonConfig$InAppConfig$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public InAppConfig() {
            this((String) null, false, 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ InAppConfig copy$default(InAppConfig inAppConfig, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = inAppConfig.activationKey;
            }
            if ((i & 2) != 0) {
                z = inAppConfig.enabled;
            }
            return inAppConfig.copy(str, z);
        }

        @SerialName("activation_key")
        public static /* synthetic */ void getActivationKey$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self(InAppConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.activationKey, "")) {
                output.encodeStringElement(serialDesc, 0, self.activationKey);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.enabled) {
                output.encodeBooleanElement(serialDesc, 1, self.enabled);
            }
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getActivationKey() {
            return this.activationKey;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getEnabled() {
            return this.enabled;
        }

        @NotNull
        public final InAppConfig copy(String activationKey, boolean enabled) {
            Intrinsics.checkNotNullParameter(activationKey, "activationKey");
            return new InAppConfig(activationKey, enabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InAppConfig)) {
                return false;
            }
            InAppConfig inAppConfig = (InAppConfig) other;
            return Intrinsics.areEqual(this.activationKey, inAppConfig.activationKey) && this.enabled == inAppConfig.enabled;
        }

        @NotNull
        public final String getActivationKey() {
            return this.activationKey;
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iHashCode = this.activationKey.hashCode() * 31;
            boolean z = this.enabled;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        @NotNull
        public String toString() {
            return "InAppConfig(activationKey=" + this.activationKey + ", enabled=" + this.enabled + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ InAppConfig(int i, @SerialName("activation_key") String str, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
            this.activationKey = (i & 1) == 0 ? "" : str;
            if ((i & 2) == 0) {
                this.enabled = false;
            } else {
                this.enabled = z;
            }
        }

        public InAppConfig(String activationKey, boolean z) {
            Intrinsics.checkNotNullParameter(activationKey, "activationKey");
            this.activationKey = activationKey;
            this.enabled = z;
        }

        public /* synthetic */ InAppConfig(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J!\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cHÇ\u0001R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$MaskingRules;", "", "seen1", "", "fullMasking", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$MaskingRulesFullMasking;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/contentsquare/android/core/features/config/model/JsonConfig$MaskingRulesFullMasking;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/contentsquare/android/core/features/config/model/JsonConfig$MaskingRulesFullMasking;)V", "getFullMasking$annotations", "()V", "getFullMasking", "()Lcom/contentsquare/android/core/features/config/model/JsonConfig$MaskingRulesFullMasking;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable
    public static final /* data */ class MaskingRules {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final MaskingRulesFullMasking fullMasking;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$MaskingRules$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$MaskingRules;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<MaskingRules> serializer() {
                return JsonConfig$MaskingRules$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public MaskingRules() {
            this((MaskingRulesFullMasking) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ MaskingRules copy$default(MaskingRules maskingRules, MaskingRulesFullMasking maskingRulesFullMasking, int i, Object obj) {
            if ((i & 1) != 0) {
                maskingRulesFullMasking = maskingRules.fullMasking;
            }
            return maskingRules.copy(maskingRulesFullMasking);
        }

        @SerialName("full_masking")
        public static /* synthetic */ void getFullMasking$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self(MaskingRules self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (!output.shouldEncodeElementDefault(serialDesc, 0)) {
                if (Intrinsics.areEqual(self.fullMasking, new MaskingRulesFullMasking((List) null, (List) null, (List) null, 7, (DefaultConstructorMarker) null))) {
                    return;
                }
            }
            output.encodeSerializableElement(serialDesc, 0, JsonConfig$MaskingRulesFullMasking$$serializer.INSTANCE, self.fullMasking);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final MaskingRulesFullMasking getFullMasking() {
            return this.fullMasking;
        }

        @NotNull
        public final MaskingRules copy(MaskingRulesFullMasking fullMasking) {
            Intrinsics.checkNotNullParameter(fullMasking, "fullMasking");
            return new MaskingRules(fullMasking);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MaskingRules) && Intrinsics.areEqual(this.fullMasking, ((MaskingRules) other).fullMasking);
        }

        @NotNull
        public final MaskingRulesFullMasking getFullMasking() {
            return this.fullMasking;
        }

        public int hashCode() {
            return this.fullMasking.hashCode();
        }

        @NotNull
        public String toString() {
            return "MaskingRules(fullMasking=" + this.fullMasking + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ MaskingRules(int i, @SerialName("full_masking") MaskingRulesFullMasking maskingRulesFullMasking, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) != 0) {
                this.fullMasking = maskingRulesFullMasking;
                return;
            }
            this.fullMasking = new MaskingRulesFullMasking((List) null, (List) null, (List) null, 7, (DefaultConstructorMarker) null);
        }

        public MaskingRules(MaskingRulesFullMasking fullMasking) {
            Intrinsics.checkNotNullParameter(fullMasking, "fullMasking");
            this.fullMasking = fullMasking;
        }

        public /* synthetic */ MaskingRules(MaskingRulesFullMasking maskingRulesFullMasking, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                maskingRulesFullMasking = new MaskingRulesFullMasking((List) null, (List) null, (List) null, 7, (DefaultConstructorMarker) null);
            }
            this(maskingRulesFullMasking);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$BK\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB5\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\fJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J!\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÇ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006%"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$MaskingRulesFullMasking;", "", "seen1", "", TCEventPropertiesNames.TCA_APP, "", "", "sdk", "flutterPlugin", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getApp", "()Ljava/util/List;", "getFlutterPlugin$annotations", "()V", "getFlutterPlugin", "getSdk", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable
    public static final /* data */ class MaskingRulesFullMasking {

        @JvmField
        @NotNull
        private static final KSerializer<Object>[] $childSerializers;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final List<String> app;

        @NotNull
        private final List<String> flutterPlugin;

        @NotNull
        private final List<String> sdk;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$MaskingRulesFullMasking$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$MaskingRulesFullMasking;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<MaskingRulesFullMasking> serializer() {
                return JsonConfig$MaskingRulesFullMasking$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            $childSerializers = new KSerializer[]{new ArrayListSerializer(stringSerializer), new ArrayListSerializer(stringSerializer), new ArrayListSerializer(stringSerializer)};
        }

        public MaskingRulesFullMasking() {
            this((List) null, (List) null, (List) null, 7, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MaskingRulesFullMasking copy$default(MaskingRulesFullMasking maskingRulesFullMasking, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = maskingRulesFullMasking.app;
            }
            if ((i & 2) != 0) {
                list2 = maskingRulesFullMasking.sdk;
            }
            if ((i & 4) != 0) {
                list3 = maskingRulesFullMasking.flutterPlugin;
            }
            return maskingRulesFullMasking.copy(list, list2, list3);
        }

        @SerialName("flutter_plugin")
        public static /* synthetic */ void getFlutterPlugin$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self(MaskingRulesFullMasking self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.app, CollectionsKt.emptyList())) {
                output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.app);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.sdk, CollectionsKt.emptyList())) {
                output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.sdk);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && Intrinsics.areEqual(self.flutterPlugin, CollectionsKt.emptyList())) {
                return;
            }
            output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.flutterPlugin);
        }

        @NotNull
        public final List<String> component1() {
            return this.app;
        }

        @NotNull
        public final List<String> component2() {
            return this.sdk;
        }

        @NotNull
        public final List<String> component3() {
            return this.flutterPlugin;
        }

        @NotNull
        public final MaskingRulesFullMasking copy(List<String> app, List<String> sdk, List<String> flutterPlugin) {
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(sdk, "sdk");
            Intrinsics.checkNotNullParameter(flutterPlugin, "flutterPlugin");
            return new MaskingRulesFullMasking(app, sdk, flutterPlugin);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MaskingRulesFullMasking)) {
                return false;
            }
            MaskingRulesFullMasking maskingRulesFullMasking = (MaskingRulesFullMasking) other;
            return Intrinsics.areEqual(this.app, maskingRulesFullMasking.app) && Intrinsics.areEqual(this.sdk, maskingRulesFullMasking.sdk) && Intrinsics.areEqual(this.flutterPlugin, maskingRulesFullMasking.flutterPlugin);
        }

        @NotNull
        public final List<String> getApp() {
            return this.app;
        }

        @NotNull
        public final List<String> getFlutterPlugin() {
            return this.flutterPlugin;
        }

        @NotNull
        public final List<String> getSdk() {
            return this.sdk;
        }

        public int hashCode() {
            return this.flutterPlugin.hashCode() + ((this.sdk.hashCode() + (this.app.hashCode() * 31)) * 31);
        }

        @NotNull
        public String toString() {
            return "MaskingRulesFullMasking(app=" + this.app + ", sdk=" + this.sdk + ", flutterPlugin=" + this.flutterPlugin + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ MaskingRulesFullMasking(int i, List list, List list2, @SerialName("flutter_plugin") List list3, SerializationConstructorMarker serializationConstructorMarker) {
            this.app = (i & 1) == 0 ? CollectionsKt.emptyList() : list;
            if ((i & 2) == 0) {
                this.sdk = CollectionsKt.emptyList();
            } else {
                this.sdk = list2;
            }
            if ((i & 4) == 0) {
                this.flutterPlugin = CollectionsKt.emptyList();
            } else {
                this.flutterPlugin = list3;
            }
        }

        public MaskingRulesFullMasking(List<String> app, List<String> sdk, List<String> flutterPlugin) {
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(sdk, "sdk");
            Intrinsics.checkNotNullParameter(flutterPlugin, "flutterPlugin");
            this.app = app;
            this.sdk = sdk;
            this.flutterPlugin = flutterPlugin;
        }

        public /* synthetic */ MaskingRulesFullMasking(List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt.emptyList() : list3);
        }
    }

    @Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bM\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 x2\u00020\u0001:\u0002wxBã\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u0012\b\b\u0001\u0010\r\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0001\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\u0006\u0010!\u001a\u00020\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\u0002\u0010$Bµ\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020 \u0012\b\b\u0002\u0010!\u001a\u00020\u0003¢\u0006\u0002\u0010%J\t\u0010X\u001a\u00020\u0005HÆ\u0003J\t\u0010Y\u001a\u00020\u0013HÆ\u0003J\u000f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015HÆ\u0003J\u0010\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010>J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010]\u001a\u00020\u001aHÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010_\u001a\u00020\u001eHÆ\u0003J\t\u0010`\u001a\u00020 HÆ\u0003J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\t\u0010b\u001a\u00020\u0007HÆ\u0003J\t\u0010c\u001a\u00020\tHÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0005HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0005HÆ\u0003J\t\u0010h\u001a\u00020\u000fHÆ\u0003J\t\u0010i\u001a\u00020\u0011HÆ\u0003JÎ\u0001\u0010j\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010kJ\u0013\u0010l\u001a\u00020\u00052\b\u0010m\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010n\u001a\u00020\u0003HÖ\u0001J\t\u0010o\u001a\u00020\u0007HÖ\u0001J!\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020\u00002\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020vHÇ\u0001R\u001c\u0010\u0019\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010'\u001a\u0004\b+\u0010,R\u001c\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010'\u001a\u0004\b.\u0010/R\u001c\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010'\u001a\u0004\b1\u00102R\u001c\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010'\u001a\u0004\b4\u00105R\u001a\u0010!\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010/\"\u0004\b7\u00108R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010'\u001a\u0004\b:\u0010;R \u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010?\u0012\u0004\b<\u0010'\u001a\u0004\b=\u0010>R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b@\u0010;R\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010'\u001a\u0004\bB\u0010CR\u001c\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u0010'\u001a\u0004\bE\u0010FR\u001c\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bG\u0010'\u001a\u0004\bH\u00105R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u001c\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bK\u0010'\u001a\u0004\bL\u0010MR\u001c\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bN\u0010'\u001a\u0004\bO\u0010/R\u001c\u0010\u001f\u001a\u00020 8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bP\u0010'\u001a\u0004\bQ\u0010RR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bS\u0010'\u001a\u0004\bT\u00105R\u001c\u0010\u001d\u001a\u00020\u001e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bU\u0010'\u001a\u0004\bV\u0010W¨\u0006y"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$ProjectConfiguration;", "", "seen1", "", "trackingEnabled", "", EventProcessorPerformanceManager.LOG_EVENT_ENDPOINT, "", "sample", "", "bucketSize", "crashHandler", "sessionTimeout", "optOutByDefault", "clientMode", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ClientMode;", "inAppConfig", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$InAppConfig;", "sessionReplay", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$SessionReplay;", "featureFlags", "", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$FeatureFlag;", "encryptionPublicKeyId", "encryptionPublicKey", "apiErrors", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrors;", "apiErrorsV2", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2;", "webView", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$WebView;", "staticResourceManager", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$StaticResourceManager;", "csProjectId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;FIZIZLcom/contentsquare/android/core/features/config/model/JsonConfig$ClientMode;Lcom/contentsquare/android/core/features/config/model/JsonConfig$InAppConfig;Lcom/contentsquare/android/core/features/config/model/JsonConfig$SessionReplay;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrors;Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2;Lcom/contentsquare/android/core/features/config/model/JsonConfig$WebView;Lcom/contentsquare/android/core/features/config/model/JsonConfig$StaticResourceManager;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ZLjava/lang/String;FIZIZLcom/contentsquare/android/core/features/config/model/JsonConfig$ClientMode;Lcom/contentsquare/android/core/features/config/model/JsonConfig$InAppConfig;Lcom/contentsquare/android/core/features/config/model/JsonConfig$SessionReplay;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrors;Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2;Lcom/contentsquare/android/core/features/config/model/JsonConfig$WebView;Lcom/contentsquare/android/core/features/config/model/JsonConfig$StaticResourceManager;I)V", "getApiErrors$annotations", "()V", "getApiErrors", "()Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrors;", "getApiErrorsV2$annotations", "getApiErrorsV2", "()Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2;", "getBucketSize$annotations", "getBucketSize", "()I", "getClientMode$annotations", "getClientMode", "()Lcom/contentsquare/android/core/features/config/model/JsonConfig$ClientMode;", "getCrashHandler$annotations", "getCrashHandler", "()Z", "getCsProjectId", "setCsProjectId", "(I)V", "getEncryptionPublicKey$annotations", "getEncryptionPublicKey", "()Ljava/lang/String;", "getEncryptionPublicKeyId$annotations", "getEncryptionPublicKeyId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEndpoint", "getFeatureFlags$annotations", "getFeatureFlags", "()Ljava/util/List;", "getInAppConfig$annotations", "getInAppConfig", "()Lcom/contentsquare/android/core/features/config/model/JsonConfig$InAppConfig;", "getOptOutByDefault$annotations", "getOptOutByDefault", "getSample", "()F", "getSessionReplay$annotations", "getSessionReplay", "()Lcom/contentsquare/android/core/features/config/model/JsonConfig$SessionReplay;", "getSessionTimeout$annotations", "getSessionTimeout", "getStaticResourceManager$annotations", "getStaticResourceManager", "()Lcom/contentsquare/android/core/features/config/model/JsonConfig$StaticResourceManager;", "getTrackingEnabled$annotations", "getTrackingEnabled", "getWebView$annotations", "getWebView", "()Lcom/contentsquare/android/core/features/config/model/JsonConfig$WebView;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZLjava/lang/String;FIZIZLcom/contentsquare/android/core/features/config/model/JsonConfig$ClientMode;Lcom/contentsquare/android/core/features/config/model/JsonConfig$InAppConfig;Lcom/contentsquare/android/core/features/config/model/JsonConfig$SessionReplay;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrors;Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2;Lcom/contentsquare/android/core/features/config/model/JsonConfig$WebView;Lcom/contentsquare/android/core/features/config/model/JsonConfig$StaticResourceManager;I)Lcom/contentsquare/android/core/features/config/model/JsonConfig$ProjectConfiguration;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ProjectConfiguration {

        @NotNull
        private final ApiErrors apiErrors;

        @Nullable
        private final ApiErrorsV2 apiErrorsV2;
        private final int bucketSize;

        @NotNull
        private final ClientMode clientMode;
        private final boolean crashHandler;
        private int csProjectId;

        @Nullable
        private final String encryptionPublicKey;

        @Nullable
        private final Integer encryptionPublicKeyId;

        @NotNull
        private final String endpoint;

        @NotNull
        private final List<FeatureFlag> featureFlags;

        @NotNull
        private final InAppConfig inAppConfig;
        private final boolean optOutByDefault;
        private final float sample;

        @NotNull
        private final SessionReplay sessionReplay;
        private final int sessionTimeout;

        @NotNull
        private final StaticResourceManager staticResourceManager;
        private final boolean trackingEnabled;

        @NotNull
        private final WebView webView;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @JvmField
        @NotNull
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, new ArrayListSerializer(JsonConfig$FeatureFlag$$serializer.INSTANCE), null, null, null, null, null, null, null};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$ProjectConfiguration$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ProjectConfiguration;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<ProjectConfiguration> serializer() {
                return JsonConfig$ProjectConfiguration$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ ProjectConfiguration(int i, @SerialName("enabled") boolean z, String str, float f, @SerialName("bucket") int i2, @SerialName("crash_handler") boolean z2, @SerialName("session_timeout") int i3, @SerialName("opt_out_by_default") boolean z3, @SerialName("client_mode") ClientMode clientMode, @SerialName("in_app_config") InAppConfig inAppConfig, @SerialName("session_replay") SessionReplay sessionReplay, @SerialName(AirshipConfigOptions.FEATURE_FEATURE_FLAGS) List list, @SerialName("encryption_public_key_id") Integer num, @SerialName("encryption_public_key") String str2, @SerialName(JsonConfigFeatureFlagNames.API_ERRORS) ApiErrors apiErrors, @SerialName("api_errors_troubleshooting_v2") ApiErrorsV2 apiErrorsV2, @SerialName("webview") WebView webView, @SerialName("static_resource_manager") StaticResourceManager staticResourceManager, int i4, SerializationConstructorMarker serializationConstructorMarker) {
            if (255 != (i & 255)) {
                PluginExceptionsKt.throwMissingFieldException(i, 255, JsonConfig$ProjectConfiguration$$serializer.INSTANCE.getDescriptor());
            }
            this.trackingEnabled = z;
            this.endpoint = str;
            this.sample = f;
            this.bucketSize = i2;
            this.crashHandler = z2;
            this.sessionTimeout = i3;
            this.optOutByDefault = z3;
            this.clientMode = clientMode;
            int i5 = 3;
            boolean z4 = false;
            byte b = 0;
            byte b2 = 0;
            byte b3 = 0;
            byte b4 = 0;
            this.inAppConfig = (i & 256) == 0 ? new InAppConfig((String) null, z4, i5, (DefaultConstructorMarker) (0 == true ? 1 : 0)) : inAppConfig;
            this.sessionReplay = (i & 512) == 0 ? new SessionReplay((String) null, BitmapDescriptorFactory.HUE_RED, false, (String) null, (String) null, (List) null, false, (String) null, false, false, (MaskingRules) null, 2047, (DefaultConstructorMarker) null) : sessionReplay;
            this.featureFlags = (i & 1024) == 0 ? CollectionsKt.emptyList() : list;
            if ((i & 2048) == 0) {
                this.encryptionPublicKeyId = null;
            } else {
                this.encryptionPublicKeyId = num;
            }
            if ((i & 4096) == 0) {
                this.encryptionPublicKey = null;
            } else {
                this.encryptionPublicKey = str2;
            }
            this.apiErrors = (i & 8192) == 0 ? new ApiErrors(false, false, false, false, (List) null, (List) null, 63, (DefaultConstructorMarker) null) : apiErrors;
            if ((i & 16384) == 0) {
                this.apiErrorsV2 = null;
            } else {
                this.apiErrorsV2 = apiErrorsV2;
            }
            this.webView = (32768 & i) == 0 ? new WebView((String) (b4 == true ? 1 : 0), 1, (DefaultConstructorMarker) (b3 == true ? 1 : 0)) : webView;
            this.staticResourceManager = (65536 & i) == 0 ? new StaticResourceManager(z4, (String) (b2 == true ? 1 : 0), i5, (DefaultConstructorMarker) (b == true ? 1 : 0)) : staticResourceManager;
            if ((i & 131072) == 0) {
                this.csProjectId = 0;
            } else {
                this.csProjectId = i4;
            }
        }

        @SerialName(JsonConfigFeatureFlagNames.API_ERRORS)
        public static /* synthetic */ void getApiErrors$annotations() {
        }

        @SerialName("api_errors_troubleshooting_v2")
        public static /* synthetic */ void getApiErrorsV2$annotations() {
        }

        @SerialName("bucket")
        public static /* synthetic */ void getBucketSize$annotations() {
        }

        @SerialName("client_mode")
        public static /* synthetic */ void getClientMode$annotations() {
        }

        @SerialName("crash_handler")
        public static /* synthetic */ void getCrashHandler$annotations() {
        }

        @SerialName("encryption_public_key")
        public static /* synthetic */ void getEncryptionPublicKey$annotations() {
        }

        @SerialName("encryption_public_key_id")
        public static /* synthetic */ void getEncryptionPublicKeyId$annotations() {
        }

        @SerialName(AirshipConfigOptions.FEATURE_FEATURE_FLAGS)
        public static /* synthetic */ void getFeatureFlags$annotations() {
        }

        @SerialName("in_app_config")
        public static /* synthetic */ void getInAppConfig$annotations() {
        }

        @SerialName("opt_out_by_default")
        public static /* synthetic */ void getOptOutByDefault$annotations() {
        }

        @SerialName("session_replay")
        public static /* synthetic */ void getSessionReplay$annotations() {
        }

        @SerialName("session_timeout")
        public static /* synthetic */ void getSessionTimeout$annotations() {
        }

        @SerialName("static_resource_manager")
        public static /* synthetic */ void getStaticResourceManager$annotations() {
        }

        @SerialName("enabled")
        public static /* synthetic */ void getTrackingEnabled$annotations() {
        }

        @SerialName("webview")
        public static /* synthetic */ void getWebView$annotations() {
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0101  */
        @kotlin.jvm.JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static final /* synthetic */ void write$Self(com.contentsquare.android.core.features.config.model.JsonConfig.ProjectConfiguration r25, kotlinx.serialization.encoding.CompositeEncoder r26, kotlinx.serialization.descriptors.SerialDescriptor r27) {
            /*
                Method dump skipped, instructions count: 362
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.core.features.config.model.JsonConfig.ProjectConfiguration.write$Self(com.contentsquare.android.core.features.config.model.JsonConfig$ProjectConfiguration, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getTrackingEnabled() {
            return this.trackingEnabled;
        }

        @NotNull
        /* renamed from: component10, reason: from getter */
        public final SessionReplay getSessionReplay() {
            return this.sessionReplay;
        }

        @NotNull
        public final List<FeatureFlag> component11() {
            return this.featureFlags;
        }

        @Nullable
        /* renamed from: component12, reason: from getter */
        public final Integer getEncryptionPublicKeyId() {
            return this.encryptionPublicKeyId;
        }

        @Nullable
        /* renamed from: component13, reason: from getter */
        public final String getEncryptionPublicKey() {
            return this.encryptionPublicKey;
        }

        @NotNull
        /* renamed from: component14, reason: from getter */
        public final ApiErrors getApiErrors() {
            return this.apiErrors;
        }

        @Nullable
        /* renamed from: component15, reason: from getter */
        public final ApiErrorsV2 getApiErrorsV2() {
            return this.apiErrorsV2;
        }

        @NotNull
        /* renamed from: component16, reason: from getter */
        public final WebView getWebView() {
            return this.webView;
        }

        @NotNull
        /* renamed from: component17, reason: from getter */
        public final StaticResourceManager getStaticResourceManager() {
            return this.staticResourceManager;
        }

        /* renamed from: component18, reason: from getter */
        public final int getCsProjectId() {
            return this.csProjectId;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getEndpoint() {
            return this.endpoint;
        }

        /* renamed from: component3, reason: from getter */
        public final float getSample() {
            return this.sample;
        }

        /* renamed from: component4, reason: from getter */
        public final int getBucketSize() {
            return this.bucketSize;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getCrashHandler() {
            return this.crashHandler;
        }

        /* renamed from: component6, reason: from getter */
        public final int getSessionTimeout() {
            return this.sessionTimeout;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getOptOutByDefault() {
            return this.optOutByDefault;
        }

        @NotNull
        /* renamed from: component8, reason: from getter */
        public final ClientMode getClientMode() {
            return this.clientMode;
        }

        @NotNull
        /* renamed from: component9, reason: from getter */
        public final InAppConfig getInAppConfig() {
            return this.inAppConfig;
        }

        @NotNull
        public final ProjectConfiguration copy(boolean trackingEnabled, String endpoint, float sample, int bucketSize, boolean crashHandler, int sessionTimeout, boolean optOutByDefault, ClientMode clientMode, InAppConfig inAppConfig, SessionReplay sessionReplay, List<FeatureFlag> featureFlags, Integer encryptionPublicKeyId, String encryptionPublicKey, ApiErrors apiErrors, ApiErrorsV2 apiErrorsV2, WebView webView, StaticResourceManager staticResourceManager, int csProjectId) {
            Intrinsics.checkNotNullParameter(endpoint, "endpoint");
            Intrinsics.checkNotNullParameter(clientMode, "clientMode");
            Intrinsics.checkNotNullParameter(inAppConfig, "inAppConfig");
            Intrinsics.checkNotNullParameter(sessionReplay, "sessionReplay");
            Intrinsics.checkNotNullParameter(featureFlags, "featureFlags");
            Intrinsics.checkNotNullParameter(apiErrors, "apiErrors");
            Intrinsics.checkNotNullParameter(webView, "webView");
            Intrinsics.checkNotNullParameter(staticResourceManager, "staticResourceManager");
            return new ProjectConfiguration(trackingEnabled, endpoint, sample, bucketSize, crashHandler, sessionTimeout, optOutByDefault, clientMode, inAppConfig, sessionReplay, featureFlags, encryptionPublicKeyId, encryptionPublicKey, apiErrors, apiErrorsV2, webView, staticResourceManager, csProjectId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ProjectConfiguration)) {
                return false;
            }
            ProjectConfiguration projectConfiguration = (ProjectConfiguration) other;
            return this.trackingEnabled == projectConfiguration.trackingEnabled && Intrinsics.areEqual(this.endpoint, projectConfiguration.endpoint) && Float.compare(this.sample, projectConfiguration.sample) == 0 && this.bucketSize == projectConfiguration.bucketSize && this.crashHandler == projectConfiguration.crashHandler && this.sessionTimeout == projectConfiguration.sessionTimeout && this.optOutByDefault == projectConfiguration.optOutByDefault && Intrinsics.areEqual(this.clientMode, projectConfiguration.clientMode) && Intrinsics.areEqual(this.inAppConfig, projectConfiguration.inAppConfig) && Intrinsics.areEqual(this.sessionReplay, projectConfiguration.sessionReplay) && Intrinsics.areEqual(this.featureFlags, projectConfiguration.featureFlags) && Intrinsics.areEqual(this.encryptionPublicKeyId, projectConfiguration.encryptionPublicKeyId) && Intrinsics.areEqual(this.encryptionPublicKey, projectConfiguration.encryptionPublicKey) && Intrinsics.areEqual(this.apiErrors, projectConfiguration.apiErrors) && Intrinsics.areEqual(this.apiErrorsV2, projectConfiguration.apiErrorsV2) && Intrinsics.areEqual(this.webView, projectConfiguration.webView) && Intrinsics.areEqual(this.staticResourceManager, projectConfiguration.staticResourceManager) && this.csProjectId == projectConfiguration.csProjectId;
        }

        @NotNull
        public final ApiErrors getApiErrors() {
            return this.apiErrors;
        }

        @Nullable
        public final ApiErrorsV2 getApiErrorsV2() {
            return this.apiErrorsV2;
        }

        public final int getBucketSize() {
            return this.bucketSize;
        }

        @NotNull
        public final ClientMode getClientMode() {
            return this.clientMode;
        }

        public final boolean getCrashHandler() {
            return this.crashHandler;
        }

        public final int getCsProjectId() {
            return this.csProjectId;
        }

        @Nullable
        public final String getEncryptionPublicKey() {
            return this.encryptionPublicKey;
        }

        @Nullable
        public final Integer getEncryptionPublicKeyId() {
            return this.encryptionPublicKeyId;
        }

        @NotNull
        public final String getEndpoint() {
            return this.endpoint;
        }

        @NotNull
        public final List<FeatureFlag> getFeatureFlags() {
            return this.featureFlags;
        }

        @NotNull
        public final InAppConfig getInAppConfig() {
            return this.inAppConfig;
        }

        public final boolean getOptOutByDefault() {
            return this.optOutByDefault;
        }

        public final float getSample() {
            return this.sample;
        }

        @NotNull
        public final SessionReplay getSessionReplay() {
            return this.sessionReplay;
        }

        public final int getSessionTimeout() {
            return this.sessionTimeout;
        }

        @NotNull
        public final StaticResourceManager getStaticResourceManager() {
            return this.staticResourceManager;
        }

        public final boolean getTrackingEnabled() {
            return this.trackingEnabled;
        }

        @NotNull
        public final WebView getWebView() {
            return this.webView;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v33 */
        /* JADX WARN: Type inference failed for: r0v34 */
        /* JADX WARN: Type inference failed for: r0v7, types: [boolean] */
        public int hashCode() {
            boolean z = this.trackingEnabled;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int iHashCode = (Integer.hashCode(this.bucketSize) + ((Float.hashCode(this.sample) + ((this.endpoint.hashCode() + (r0 * 31)) * 31)) * 31)) * 31;
            ?? r02 = this.crashHandler;
            int i = r02;
            if (r02 != 0) {
                i = 1;
            }
            int iHashCode2 = (Integer.hashCode(this.sessionTimeout) + ((iHashCode + i) * 31)) * 31;
            boolean z2 = this.optOutByDefault;
            int iHashCode3 = (this.featureFlags.hashCode() + ((this.sessionReplay.hashCode() + ((this.inAppConfig.hashCode() + ((this.clientMode.hashCode() + ((iHashCode2 + (z2 ? 1 : z2 ? 1 : 0)) * 31)) * 31)) * 31)) * 31)) * 31;
            Integer num = this.encryptionPublicKeyId;
            int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.encryptionPublicKey;
            int iHashCode5 = (this.apiErrors.hashCode() + ((iHashCode4 + (str == null ? 0 : str.hashCode())) * 31)) * 31;
            ApiErrorsV2 apiErrorsV2 = this.apiErrorsV2;
            return Integer.hashCode(this.csProjectId) + ((this.staticResourceManager.hashCode() + ((this.webView.hashCode() + ((iHashCode5 + (apiErrorsV2 != null ? apiErrorsV2.hashCode() : 0)) * 31)) * 31)) * 31);
        }

        public final void setCsProjectId(int i) {
            this.csProjectId = i;
        }

        @NotNull
        public String toString() {
            return "ProjectConfiguration(trackingEnabled=" + this.trackingEnabled + ", endpoint=" + this.endpoint + ", sample=" + this.sample + ", bucketSize=" + this.bucketSize + ", crashHandler=" + this.crashHandler + ", sessionTimeout=" + this.sessionTimeout + ", optOutByDefault=" + this.optOutByDefault + ", clientMode=" + this.clientMode + ", inAppConfig=" + this.inAppConfig + ", sessionReplay=" + this.sessionReplay + ", featureFlags=" + this.featureFlags + ", encryptionPublicKeyId=" + this.encryptionPublicKeyId + ", encryptionPublicKey=" + this.encryptionPublicKey + ", apiErrors=" + this.apiErrors + ", apiErrorsV2=" + this.apiErrorsV2 + ", webView=" + this.webView + ", staticResourceManager=" + this.staticResourceManager + ", csProjectId=" + this.csProjectId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public ProjectConfiguration(boolean z, String endpoint, float f, int i, boolean z2, int i2, boolean z3, ClientMode clientMode, InAppConfig inAppConfig, SessionReplay sessionReplay, List<FeatureFlag> featureFlags, Integer num, String str, ApiErrors apiErrors, ApiErrorsV2 apiErrorsV2, WebView webView, StaticResourceManager staticResourceManager, int i3) {
            Intrinsics.checkNotNullParameter(endpoint, "endpoint");
            Intrinsics.checkNotNullParameter(clientMode, "clientMode");
            Intrinsics.checkNotNullParameter(inAppConfig, "inAppConfig");
            Intrinsics.checkNotNullParameter(sessionReplay, "sessionReplay");
            Intrinsics.checkNotNullParameter(featureFlags, "featureFlags");
            Intrinsics.checkNotNullParameter(apiErrors, "apiErrors");
            Intrinsics.checkNotNullParameter(webView, "webView");
            Intrinsics.checkNotNullParameter(staticResourceManager, "staticResourceManager");
            this.trackingEnabled = z;
            this.endpoint = endpoint;
            this.sample = f;
            this.bucketSize = i;
            this.crashHandler = z2;
            this.sessionTimeout = i2;
            this.optOutByDefault = z3;
            this.clientMode = clientMode;
            this.inAppConfig = inAppConfig;
            this.sessionReplay = sessionReplay;
            this.featureFlags = featureFlags;
            this.encryptionPublicKeyId = num;
            this.encryptionPublicKey = str;
            this.apiErrors = apiErrors;
            this.apiErrorsV2 = apiErrorsV2;
            this.webView = webView;
            this.staticResourceManager = staticResourceManager;
            this.csProjectId = i3;
        }

        public /* synthetic */ ProjectConfiguration(boolean z, String str, float f, int i, boolean z2, int i2, boolean z3, ClientMode clientMode, InAppConfig inAppConfig, SessionReplay sessionReplay, List list, Integer num, String str2, ApiErrors apiErrors, ApiErrorsV2 apiErrorsV2, WebView webView, StaticResourceManager staticResourceManager, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            InAppConfig inAppConfig2;
            int i5 = 3;
            boolean z4 = false;
            String str3 = null;
            byte b = 0;
            byte b2 = 0;
            byte b3 = 0;
            byte b4 = 0;
            byte b5 = 0;
            if ((i4 & 256) != 0) {
                inAppConfig2 = new InAppConfig(str3, z4, i5, (DefaultConstructorMarker) (b5 == true ? 1 : 0));
            } else {
                inAppConfig2 = inAppConfig;
            }
            this(z, str, f, i, z2, i2, z3, clientMode, inAppConfig2, (i4 & 512) != 0 ? new SessionReplay((String) null, BitmapDescriptorFactory.HUE_RED, false, (String) null, (String) null, (List) null, false, (String) null, false, false, (MaskingRules) null, 2047, (DefaultConstructorMarker) null) : sessionReplay, (i4 & 1024) != 0 ? CollectionsKt.emptyList() : list, (i4 & 2048) != 0 ? null : num, (i4 & 4096) != 0 ? null : str2, (i4 & 8192) != 0 ? new ApiErrors(false, false, false, false, (List) null, (List) null, 63, (DefaultConstructorMarker) null) : apiErrors, (i4 & 16384) != 0 ? null : apiErrorsV2, (32768 & i4) != 0 ? new WebView((String) (b4 == true ? 1 : 0), 1, (DefaultConstructorMarker) (b3 == true ? 1 : 0)) : webView, (65536 & i4) != 0 ? new StaticResourceManager(z4, (String) (b2 == true ? 1 : 0), i5, (DefaultConstructorMarker) (b == true ? 1 : 0)) : staticResourceManager, (i4 & 131072) != 0 ? 0 : i3);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J!\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cHÇ\u0001R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$ProjectConfigurations;", "", "seen1", "", "projectConfig", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ProjectConfiguration;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/contentsquare/android/core/features/config/model/JsonConfig$ProjectConfiguration;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/contentsquare/android/core/features/config/model/JsonConfig$ProjectConfiguration;)V", "getProjectConfig$annotations", "()V", "getProjectConfig", "()Lcom/contentsquare/android/core/features/config/model/JsonConfig$ProjectConfiguration;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ProjectConfigurations {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final ProjectConfiguration projectConfig;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$ProjectConfigurations$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ProjectConfigurations;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<ProjectConfigurations> serializer() {
                return JsonConfig$ProjectConfigurations$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ ProjectConfigurations(int i, @SerialName("project_config") ProjectConfiguration projectConfiguration, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, JsonConfig$ProjectConfigurations$$serializer.INSTANCE.getDescriptor());
            }
            this.projectConfig = projectConfiguration;
        }

        public static /* synthetic */ ProjectConfigurations copy$default(ProjectConfigurations projectConfigurations, ProjectConfiguration projectConfiguration, int i, Object obj) {
            if ((i & 1) != 0) {
                projectConfiguration = projectConfigurations.projectConfig;
            }
            return projectConfigurations.copy(projectConfiguration);
        }

        @SerialName("project_config")
        public static /* synthetic */ void getProjectConfig$annotations() {
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final ProjectConfiguration getProjectConfig() {
            return this.projectConfig;
        }

        @NotNull
        public final ProjectConfigurations copy(ProjectConfiguration projectConfig) {
            Intrinsics.checkNotNullParameter(projectConfig, "projectConfig");
            return new ProjectConfigurations(projectConfig);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ProjectConfigurations) && Intrinsics.areEqual(this.projectConfig, ((ProjectConfigurations) other).projectConfig);
        }

        @NotNull
        public final ProjectConfiguration getProjectConfig() {
            return this.projectConfig;
        }

        public int hashCode() {
            return this.projectConfig.hashCode();
        }

        @NotNull
        public String toString() {
            return "ProjectConfigurations(projectConfig=" + this.projectConfig + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public ProjectConfigurations(ProjectConfiguration projectConfig) {
            Intrinsics.checkNotNullParameter(projectConfig, "projectConfig");
            this.projectConfig = projectConfig;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B/\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J!\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!HÇ\u0001R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$RootConfig;", "", "seen1", "", "csProjectId", "projectConfigurations", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ProjectConfigurations;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILcom/contentsquare/android/core/features/config/model/JsonConfig$ProjectConfigurations;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ILcom/contentsquare/android/core/features/config/model/JsonConfig$ProjectConfigurations;)V", "getCsProjectId$annotations", "()V", "getCsProjectId", "()I", "getProjectConfigurations$annotations", "getProjectConfigurations", "()Lcom/contentsquare/android/core/features/config/model/JsonConfig$ProjectConfigurations;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable
    public static final /* data */ class RootConfig {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final int csProjectId;

        @NotNull
        private final ProjectConfigurations projectConfigurations;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$RootConfig$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$RootConfig;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<RootConfig> serializer() {
                return JsonConfig$RootConfig$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ RootConfig(int i, @SerialName("cs_project_id") int i2, @SerialName("project_configurations") ProjectConfigurations projectConfigurations, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, JsonConfig$RootConfig$$serializer.INSTANCE.getDescriptor());
            }
            this.csProjectId = i2;
            this.projectConfigurations = projectConfigurations;
        }

        public static /* synthetic */ RootConfig copy$default(RootConfig rootConfig, int i, ProjectConfigurations projectConfigurations, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = rootConfig.csProjectId;
            }
            if ((i2 & 2) != 0) {
                projectConfigurations = rootConfig.projectConfigurations;
            }
            return rootConfig.copy(i, projectConfigurations);
        }

        @SerialName("cs_project_id")
        public static /* synthetic */ void getCsProjectId$annotations() {
        }

        @SerialName("project_configurations")
        public static /* synthetic */ void getProjectConfigurations$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self(RootConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeIntElement(serialDesc, 0, self.csProjectId);
            output.encodeSerializableElement(serialDesc, 1, JsonConfig$ProjectConfigurations$$serializer.INSTANCE, self.projectConfigurations);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCsProjectId() {
            return this.csProjectId;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final ProjectConfigurations getProjectConfigurations() {
            return this.projectConfigurations;
        }

        @NotNull
        public final RootConfig copy(int csProjectId, ProjectConfigurations projectConfigurations) {
            Intrinsics.checkNotNullParameter(projectConfigurations, "projectConfigurations");
            return new RootConfig(csProjectId, projectConfigurations);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RootConfig)) {
                return false;
            }
            RootConfig rootConfig = (RootConfig) other;
            return this.csProjectId == rootConfig.csProjectId && Intrinsics.areEqual(this.projectConfigurations, rootConfig.projectConfigurations);
        }

        public final int getCsProjectId() {
            return this.csProjectId;
        }

        @NotNull
        public final ProjectConfigurations getProjectConfigurations() {
            return this.projectConfigurations;
        }

        public int hashCode() {
            return this.projectConfigurations.hashCode() + (Integer.hashCode(this.csProjectId) * 31);
        }

        @NotNull
        public String toString() {
            return "RootConfig(csProjectId=" + this.csProjectId + ", projectConfigurations=" + this.projectConfigurations + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public RootConfig(int i, ProjectConfigurations projectConfigurations) {
            Intrinsics.checkNotNullParameter(projectConfigurations, "projectConfigurations");
            this.csProjectId = i;
            this.projectConfigurations = projectConfigurations;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 K2\u00020\u0001:\u0002JKB\u0097\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r\u0012\b\b\u0001\u0010\u000e\u001a\u00020\t\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0010\u001a\u00020\t\u0012\b\b\u0001\u0010\u0011\u001a\u00020\t\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016By\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0017J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\t\u00105\u001a\u00020\u0013HÆ\u0003J\t\u00106\u001a\u00020\u0007HÆ\u0003J\t\u00107\u001a\u00020\tHÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050\rHÆ\u0003J\t\u0010;\u001a\u00020\tHÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\tHÆ\u0003J}\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001J\u0013\u0010?\u001a\u00020\t2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u0003HÖ\u0001J\t\u0010B\u001a\u00020\u0005HÖ\u0001J!\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IHÇ\u0001R\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0011\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010#R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010 R\u001c\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010\u001dR\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0019\u001a\u0004\b)\u0010\u001dR\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010,R\u001c\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0019\u001a\u0004\b.\u0010 R\u001c\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\u0019\u001a\u0004\b0\u0010\u001dR\u001c\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u0019\u001a\u0004\b2\u0010 ¨\u0006L"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$SessionReplay;", "", "seen1", "", EventProcessorPerformanceManager.LOG_EVENT_ENDPOINT, "", "recordingRate", "", "recordViaCellularNetwork", "", "recordingQualityWifi", "recordingQualityCellular", "blockedAppVersions", "", "srmEnabled", "srmEndpoint", "userIdentifier", "etrEnabled", "maskingRules", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$MaskingRules;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;FZLjava/lang/String;Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;ZZLcom/contentsquare/android/core/features/config/model/JsonConfig$MaskingRules;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;FZLjava/lang/String;Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;ZZLcom/contentsquare/android/core/features/config/model/JsonConfig$MaskingRules;)V", "getBlockedAppVersions$annotations", "()V", "getBlockedAppVersions", "()Ljava/util/List;", "getEndpoint", "()Ljava/lang/String;", "getEtrEnabled$annotations", "getEtrEnabled", "()Z", "getMaskingRules$annotations", "getMaskingRules", "()Lcom/contentsquare/android/core/features/config/model/JsonConfig$MaskingRules;", "getRecordViaCellularNetwork$annotations", "getRecordViaCellularNetwork", "getRecordingQualityCellular$annotations", "getRecordingQualityCellular", "getRecordingQualityWifi$annotations", "getRecordingQualityWifi", "getRecordingRate$annotations", "getRecordingRate", "()F", "getSrmEnabled$annotations", "getSrmEnabled", "getSrmEndpoint$annotations", "getSrmEndpoint", "getUserIdentifier$annotations", "getUserIdentifier", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable
    public static final /* data */ class SessionReplay {

        @NotNull
        private final List<String> blockedAppVersions;

        @NotNull
        private final String endpoint;
        private final boolean etrEnabled;

        @NotNull
        private final MaskingRules maskingRules;
        private final boolean recordViaCellularNetwork;

        @NotNull
        private final String recordingQualityCellular;

        @NotNull
        private final String recordingQualityWifi;
        private final float recordingRate;
        private final boolean srmEnabled;

        @NotNull
        private final String srmEndpoint;
        private final boolean userIdentifier;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @JvmField
        @NotNull
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null, null, null};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$SessionReplay$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$SessionReplay;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<SessionReplay> serializer() {
                return JsonConfig$SessionReplay$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public SessionReplay() {
            this((String) null, BitmapDescriptorFactory.HUE_RED, false, (String) null, (String) null, (List) null, false, (String) null, false, false, (MaskingRules) null, 2047, (DefaultConstructorMarker) null);
        }

        @SerialName("blocked_app_versions")
        public static /* synthetic */ void getBlockedAppVersions$annotations() {
        }

        @SerialName("etr_enabled")
        public static /* synthetic */ void getEtrEnabled$annotations() {
        }

        @SerialName("masking_rules")
        public static /* synthetic */ void getMaskingRules$annotations() {
        }

        @SerialName("record_via_cellular_network")
        public static /* synthetic */ void getRecordViaCellularNetwork$annotations() {
        }

        @SerialName("recording_quality_cellular")
        public static /* synthetic */ void getRecordingQualityCellular$annotations() {
        }

        @SerialName("recording_quality_wifi")
        public static /* synthetic */ void getRecordingQualityWifi$annotations() {
        }

        @SerialName("recording_rate")
        public static /* synthetic */ void getRecordingRate$annotations() {
        }

        @SerialName("srm_enabled")
        public static /* synthetic */ void getSrmEnabled$annotations() {
        }

        @SerialName("srm_endpoint")
        public static /* synthetic */ void getSrmEndpoint$annotations() {
        }

        @SerialName("user_identifier")
        public static /* synthetic */ void getUserIdentifier$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self(SessionReplay self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.endpoint, "")) {
                output.encodeStringElement(serialDesc, 0, self.endpoint);
            }
            int i = 1;
            if (output.shouldEncodeElementDefault(serialDesc, 1) || Float.compare(self.recordingRate, BitmapDescriptorFactory.HUE_RED) != 0) {
                output.encodeFloatElement(serialDesc, 1, self.recordingRate);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.recordViaCellularNetwork) {
                output.encodeBooleanElement(serialDesc, 2, self.recordViaCellularNetwork);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.recordingQualityWifi, QualityLevel.INSTANCE.getDEFAULT_RECORDING_QUALITY())) {
                output.encodeStringElement(serialDesc, 3, self.recordingQualityWifi);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.recordingQualityCellular, QualityLevel.INSTANCE.getDEFAULT_RECORDING_QUALITY())) {
                output.encodeStringElement(serialDesc, 4, self.recordingQualityCellular);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.blockedAppVersions, CollectionsKt.emptyList())) {
                output.encodeSerializableElement(serialDesc, 5, kSerializerArr[5], self.blockedAppVersions);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.srmEnabled) {
                output.encodeBooleanElement(serialDesc, 6, self.srmEnabled);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.srmEndpoint, "")) {
                output.encodeStringElement(serialDesc, 7, self.srmEndpoint);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.userIdentifier) {
                output.encodeBooleanElement(serialDesc, 8, self.userIdentifier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.etrEnabled) {
                output.encodeBooleanElement(serialDesc, 9, self.etrEnabled);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 10) && Intrinsics.areEqual(self.maskingRules, new MaskingRules((MaskingRulesFullMasking) null, i, (DefaultConstructorMarker) (0 == true ? 1 : 0)))) {
                return;
            }
            output.encodeSerializableElement(serialDesc, 10, JsonConfig$MaskingRules$$serializer.INSTANCE, self.maskingRules);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getEndpoint() {
            return this.endpoint;
        }

        /* renamed from: component10, reason: from getter */
        public final boolean getEtrEnabled() {
            return this.etrEnabled;
        }

        @NotNull
        /* renamed from: component11, reason: from getter */
        public final MaskingRules getMaskingRules() {
            return this.maskingRules;
        }

        /* renamed from: component2, reason: from getter */
        public final float getRecordingRate() {
            return this.recordingRate;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getRecordViaCellularNetwork() {
            return this.recordViaCellularNetwork;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final String getRecordingQualityWifi() {
            return this.recordingQualityWifi;
        }

        @NotNull
        /* renamed from: component5, reason: from getter */
        public final String getRecordingQualityCellular() {
            return this.recordingQualityCellular;
        }

        @NotNull
        public final List<String> component6() {
            return this.blockedAppVersions;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getSrmEnabled() {
            return this.srmEnabled;
        }

        @NotNull
        /* renamed from: component8, reason: from getter */
        public final String getSrmEndpoint() {
            return this.srmEndpoint;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getUserIdentifier() {
            return this.userIdentifier;
        }

        @NotNull
        public final SessionReplay copy(String endpoint, float recordingRate, boolean recordViaCellularNetwork, String recordingQualityWifi, String recordingQualityCellular, List<String> blockedAppVersions, boolean srmEnabled, String srmEndpoint, boolean userIdentifier, boolean etrEnabled, MaskingRules maskingRules) {
            Intrinsics.checkNotNullParameter(endpoint, "endpoint");
            Intrinsics.checkNotNullParameter(recordingQualityWifi, "recordingQualityWifi");
            Intrinsics.checkNotNullParameter(recordingQualityCellular, "recordingQualityCellular");
            Intrinsics.checkNotNullParameter(blockedAppVersions, "blockedAppVersions");
            Intrinsics.checkNotNullParameter(srmEndpoint, "srmEndpoint");
            Intrinsics.checkNotNullParameter(maskingRules, "maskingRules");
            return new SessionReplay(endpoint, recordingRate, recordViaCellularNetwork, recordingQualityWifi, recordingQualityCellular, blockedAppVersions, srmEnabled, srmEndpoint, userIdentifier, etrEnabled, maskingRules);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SessionReplay)) {
                return false;
            }
            SessionReplay sessionReplay = (SessionReplay) other;
            return Intrinsics.areEqual(this.endpoint, sessionReplay.endpoint) && Float.compare(this.recordingRate, sessionReplay.recordingRate) == 0 && this.recordViaCellularNetwork == sessionReplay.recordViaCellularNetwork && Intrinsics.areEqual(this.recordingQualityWifi, sessionReplay.recordingQualityWifi) && Intrinsics.areEqual(this.recordingQualityCellular, sessionReplay.recordingQualityCellular) && Intrinsics.areEqual(this.blockedAppVersions, sessionReplay.blockedAppVersions) && this.srmEnabled == sessionReplay.srmEnabled && Intrinsics.areEqual(this.srmEndpoint, sessionReplay.srmEndpoint) && this.userIdentifier == sessionReplay.userIdentifier && this.etrEnabled == sessionReplay.etrEnabled && Intrinsics.areEqual(this.maskingRules, sessionReplay.maskingRules);
        }

        @NotNull
        public final List<String> getBlockedAppVersions() {
            return this.blockedAppVersions;
        }

        @NotNull
        public final String getEndpoint() {
            return this.endpoint;
        }

        public final boolean getEtrEnabled() {
            return this.etrEnabled;
        }

        @NotNull
        public final MaskingRules getMaskingRules() {
            return this.maskingRules;
        }

        public final boolean getRecordViaCellularNetwork() {
            return this.recordViaCellularNetwork;
        }

        @NotNull
        public final String getRecordingQualityCellular() {
            return this.recordingQualityCellular;
        }

        @NotNull
        public final String getRecordingQualityWifi() {
            return this.recordingQualityWifi;
        }

        public final float getRecordingRate() {
            return this.recordingRate;
        }

        public final boolean getSrmEnabled() {
            return this.srmEnabled;
        }

        @NotNull
        public final String getSrmEndpoint() {
            return this.srmEndpoint;
        }

        public final boolean getUserIdentifier() {
            return this.userIdentifier;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iHashCode = (Float.hashCode(this.recordingRate) + (this.endpoint.hashCode() * 31)) * 31;
            boolean z = this.recordViaCellularNetwork;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int iHashCode2 = (this.blockedAppVersions.hashCode() + ((this.recordingQualityCellular.hashCode() + ((this.recordingQualityWifi.hashCode() + ((iHashCode + i) * 31)) * 31)) * 31)) * 31;
            boolean z2 = this.srmEnabled;
            int i2 = z2;
            if (z2 != 0) {
                i2 = 1;
            }
            int iHashCode3 = (this.srmEndpoint.hashCode() + ((iHashCode2 + i2) * 31)) * 31;
            boolean z3 = this.userIdentifier;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (iHashCode3 + i3) * 31;
            boolean z4 = this.etrEnabled;
            return this.maskingRules.hashCode() + ((i4 + (z4 ? 1 : z4 ? 1 : 0)) * 31);
        }

        @NotNull
        public String toString() {
            return "SessionReplay(endpoint=" + this.endpoint + ", recordingRate=" + this.recordingRate + ", recordViaCellularNetwork=" + this.recordViaCellularNetwork + ", recordingQualityWifi=" + this.recordingQualityWifi + ", recordingQualityCellular=" + this.recordingQualityCellular + ", blockedAppVersions=" + this.blockedAppVersions + ", srmEnabled=" + this.srmEnabled + ", srmEndpoint=" + this.srmEndpoint + ", userIdentifier=" + this.userIdentifier + ", etrEnabled=" + this.etrEnabled + ", maskingRules=" + this.maskingRules + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ SessionReplay(int i, String str, @SerialName("recording_rate") float f, @SerialName("record_via_cellular_network") boolean z, @SerialName("recording_quality_wifi") String str2, @SerialName("recording_quality_cellular") String str3, @SerialName("blocked_app_versions") List list, @SerialName("srm_enabled") boolean z2, @SerialName("srm_endpoint") String str4, @SerialName("user_identifier") boolean z3, @SerialName("etr_enabled") boolean z4, @SerialName("masking_rules") MaskingRules maskingRules, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.endpoint = "";
            } else {
                this.endpoint = str;
            }
            if ((i & 2) == 0) {
                this.recordingRate = BitmapDescriptorFactory.HUE_RED;
            } else {
                this.recordingRate = f;
            }
            if ((i & 4) == 0) {
                this.recordViaCellularNetwork = false;
            } else {
                this.recordViaCellularNetwork = z;
            }
            if ((i & 8) == 0) {
                this.recordingQualityWifi = QualityLevel.INSTANCE.getDEFAULT_RECORDING_QUALITY();
            } else {
                this.recordingQualityWifi = str2;
            }
            if ((i & 16) == 0) {
                this.recordingQualityCellular = QualityLevel.INSTANCE.getDEFAULT_RECORDING_QUALITY();
            } else {
                this.recordingQualityCellular = str3;
            }
            if ((i & 32) == 0) {
                this.blockedAppVersions = CollectionsKt.emptyList();
            } else {
                this.blockedAppVersions = list;
            }
            if ((i & 64) == 0) {
                this.srmEnabled = false;
            } else {
                this.srmEnabled = z2;
            }
            if ((i & 128) == 0) {
                this.srmEndpoint = "";
            } else {
                this.srmEndpoint = str4;
            }
            if ((i & 256) == 0) {
                this.userIdentifier = false;
            } else {
                this.userIdentifier = z3;
            }
            if ((i & 512) == 0) {
                this.etrEnabled = false;
            } else {
                this.etrEnabled = z4;
            }
            if ((i & 1024) == 0) {
                this.maskingRules = new MaskingRules((MaskingRulesFullMasking) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
            } else {
                this.maskingRules = maskingRules;
            }
        }

        public SessionReplay(String endpoint, float f, boolean z, String recordingQualityWifi, String recordingQualityCellular, List<String> blockedAppVersions, boolean z2, String srmEndpoint, boolean z3, boolean z4, MaskingRules maskingRules) {
            Intrinsics.checkNotNullParameter(endpoint, "endpoint");
            Intrinsics.checkNotNullParameter(recordingQualityWifi, "recordingQualityWifi");
            Intrinsics.checkNotNullParameter(recordingQualityCellular, "recordingQualityCellular");
            Intrinsics.checkNotNullParameter(blockedAppVersions, "blockedAppVersions");
            Intrinsics.checkNotNullParameter(srmEndpoint, "srmEndpoint");
            Intrinsics.checkNotNullParameter(maskingRules, "maskingRules");
            this.endpoint = endpoint;
            this.recordingRate = f;
            this.recordViaCellularNetwork = z;
            this.recordingQualityWifi = recordingQualityWifi;
            this.recordingQualityCellular = recordingQualityCellular;
            this.blockedAppVersions = blockedAppVersions;
            this.srmEnabled = z2;
            this.srmEndpoint = srmEndpoint;
            this.userIdentifier = z3;
            this.etrEnabled = z4;
            this.maskingRules = maskingRules;
        }

        public /* synthetic */ SessionReplay(String str, float f, boolean z, String str2, String str3, List list, boolean z2, String str4, boolean z3, boolean z4, MaskingRules maskingRules, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? BitmapDescriptorFactory.HUE_RED : f, (i & 4) != 0 ? false : z, (i & 8) != 0 ? QualityLevel.INSTANCE.getDEFAULT_RECORDING_QUALITY() : str2, (i & 16) != 0 ? QualityLevel.INSTANCE.getDEFAULT_RECORDING_QUALITY() : str3, (i & 32) != 0 ? CollectionsKt.emptyList() : list, (i & 64) != 0 ? false : z2, (i & 128) != 0 ? "" : str4, (i & 256) != 0 ? false : z3, (i & 512) != 0 ? false : z4, (i & 1024) != 0 ? new MaskingRules((MaskingRulesFullMasking) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0)) : maskingRules);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB+\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0019\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J!\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dHÇ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$StaticResourceManager;", "", "seen1", "", "enabled", "", EventProcessorPerformanceManager.LOG_EVENT_ENDPOINT, "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ZLjava/lang/String;)V", "getEnabled", "()Z", "getEndpoint", "()Ljava/lang/String;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable
    public static final /* data */ class StaticResourceManager {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final boolean enabled;

        @NotNull
        private final String endpoint;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$StaticResourceManager$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$StaticResourceManager;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<StaticResourceManager> serializer() {
                return JsonConfig$StaticResourceManager$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public StaticResourceManager() {
            this(false, (String) null, 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ StaticResourceManager copy$default(StaticResourceManager staticResourceManager, boolean z, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z = staticResourceManager.enabled;
            }
            if ((i & 2) != 0) {
                str = staticResourceManager.endpoint;
            }
            return staticResourceManager.copy(z, str);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self(StaticResourceManager self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.enabled) {
                output.encodeBooleanElement(serialDesc, 0, self.enabled);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && Intrinsics.areEqual(self.endpoint, "")) {
                return;
            }
            output.encodeStringElement(serialDesc, 1, self.endpoint);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getEnabled() {
            return this.enabled;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getEndpoint() {
            return this.endpoint;
        }

        @NotNull
        public final StaticResourceManager copy(boolean enabled, String endpoint) {
            Intrinsics.checkNotNullParameter(endpoint, "endpoint");
            return new StaticResourceManager(enabled, endpoint);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StaticResourceManager)) {
                return false;
            }
            StaticResourceManager staticResourceManager = (StaticResourceManager) other;
            return this.enabled == staticResourceManager.enabled && Intrinsics.areEqual(this.endpoint, staticResourceManager.endpoint);
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        @NotNull
        public final String getEndpoint() {
            return this.endpoint;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4 */
        public int hashCode() {
            boolean z = this.enabled;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            return this.endpoint.hashCode() + (r0 * 31);
        }

        @NotNull
        public String toString() {
            return "StaticResourceManager(enabled=" + this.enabled + ", endpoint=" + this.endpoint + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ StaticResourceManager(int i, boolean z, String str, SerializationConstructorMarker serializationConstructorMarker) {
            this.enabled = (i & 1) == 0 ? false : z;
            if ((i & 2) == 0) {
                this.endpoint = "";
            } else {
                this.endpoint = str;
            }
        }

        public StaticResourceManager(boolean z, String endpoint) {
            Intrinsics.checkNotNullParameter(endpoint, "endpoint");
            this.enabled = z;
            this.endpoint = endpoint;
        }

        public /* synthetic */ StaticResourceManager(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J!\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bHÇ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$WebView;", "", "seen1", "", "tagId", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;)V", "getTagId$annotations", "()V", "getTagId", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable
    public static final /* data */ class WebView {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @Nullable
        private final String tagId;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/JsonConfig$WebView$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$WebView;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<WebView> serializer() {
                return JsonConfig$WebView$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public WebView() {
            this((String) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ WebView copy$default(WebView webView, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = webView.tagId;
            }
            return webView.copy(str);
        }

        @SerialName("tag_id")
        public static /* synthetic */ void getTagId$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self(WebView self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.tagId == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.tagId);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final String getTagId() {
            return this.tagId;
        }

        @NotNull
        public final WebView copy(String tagId) {
            return new WebView(tagId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WebView) && Intrinsics.areEqual(this.tagId, ((WebView) other).tagId);
        }

        @Nullable
        public final String getTagId() {
            return this.tagId;
        }

        public int hashCode() {
            String str = this.tagId;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        @NotNull
        public String toString() {
            return "WebView(tagId=" + this.tagId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ WebView(int i, @SerialName("tag_id") String str, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.tagId = null;
            } else {
                this.tagId = str;
            }
        }

        public WebView(String str) {
            this.tagId = str;
        }

        public /* synthetic */ WebView(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }
    }

    @JvmStatic
    @Nullable
    public static final RootConfig decodeFromString(String str) {
        return INSTANCE.decodeFromString(str);
    }

    @JvmStatic
    @Nullable
    public static final String encodeToString(RootConfig rootConfig) {
        return INSTANCE.encodeToString(rootConfig);
    }
}
