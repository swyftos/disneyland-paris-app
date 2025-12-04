package com.contentsquare.proto.srm.v1;

import com.contentsquare.proto.srm.v1.SrmPutV1;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import com.urbanairship.channel.AttributeMutation;
import com.urbanairship.deferred.DeferredApiClient;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/srm/v1/StaticResourcesKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StaticResourcesKt {

    @NotNull
    public static final StaticResourcesKt INSTANCE = new StaticResourcesKt();

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u001c\n\u0002\b\f\b\u0007\u0018\u0000 =2\u00020\u0001:\u0002=>B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010'\u001a\u00020(H\u0001J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020*J\u0006\u0010,\u001a\u00020*J\u0006\u0010-\u001a\u00020*J\u0006\u0010.\u001a\u00020*J%\u0010/\u001a\u00020**\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c2\u0006\u0010\u0005\u001a\u00020\u001dH\u0007¢\u0006\u0002\b0J+\u00101\u001a\u00020**\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001d03H\u0007¢\u0006\u0002\b4J\u001d\u00105\u001a\u00020**\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cH\u0007¢\u0006\u0002\b6J&\u00107\u001a\u00020**\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c2\u0006\u0010\u0005\u001a\u00020\u001dH\u0087\n¢\u0006\u0002\b8J,\u00107\u001a\u00020**\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001d03H\u0087\n¢\u0006\u0002\b9J.\u0010:\u001a\u00020**\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c2\u0006\u0010;\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u001dH\u0087\u0002¢\u0006\u0002\b<R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R$\u0010!\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR$\u0010$\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000b¨\u0006?"}, d2 = {"Lcom/contentsquare/proto/srm/v1/StaticResourcesKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/srm/v1/SrmPutV1$StaticResources$Builder;", "(Lcom/contentsquare/proto/srm/v1/SrmPutV1$StaticResources$Builder;)V", "value", "", "appVersion", "getAppVersion", "()Ljava/lang/String;", "setAppVersion", "(Ljava/lang/String;)V", "Lcom/contentsquare/proto/srm/v1/SrmPutV1$Platform;", DeferredApiClient.KEY_PLATFORM, "getPlatform", "()Lcom/contentsquare/proto/srm/v1/SrmPutV1$Platform;", "setPlatform", "(Lcom/contentsquare/proto/srm/v1/SrmPutV1$Platform;)V", "", "platformValue", "getPlatformValue", "()I", "setPlatformValue", "(I)V", "projectId", "getProjectId", "setProjectId", "resources", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/contentsquare/proto/srm/v1/SrmPutV1$StaticResource;", "Lcom/contentsquare/proto/srm/v1/StaticResourcesKt$Dsl$ResourcesProxy;", "getResources", "()Lcom/google/protobuf/kotlin/DslList;", "sdkMetadata", "getSdkMetadata", "setSdkMetadata", "sdkVersion", "getSdkVersion", "setSdkVersion", "_build", "Lcom/contentsquare/proto/srm/v1/SrmPutV1$StaticResources;", "clearAppVersion", "", "clearPlatform", "clearProjectId", "clearSdkMetadata", "clearSdkVersion", "add", "addResources", "addAll", "values", "", "addAllResources", "clear", "clearResources", "plusAssign", "plusAssignResources", "plusAssignAllResources", AttributeMutation.ATTRIBUTE_ACTION_SET, "index", "setResources", "Companion", "ResourcesProxy", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final SrmPutV1.StaticResources.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/srm/v1/StaticResourcesKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/srm/v1/StaticResourcesKt$Dsl;", "builder", "Lcom/contentsquare/proto/srm/v1/SrmPutV1$StaticResources$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(SrmPutV1.StaticResources.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/srm/v1/StaticResourcesKt$Dsl$ResourcesProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class ResourcesProxy extends DslProxy {
            private ResourcesProxy() {
            }
        }

        private Dsl(SrmPutV1.StaticResources.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ SrmPutV1.StaticResources _build() {
            SrmPutV1.StaticResources staticResourcesBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(staticResourcesBuild, "_builder.build()");
            return staticResourcesBuild;
        }

        @JvmName(name = "addAllResources")
        public final /* synthetic */ void addAllResources(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllResources(values);
        }

        @JvmName(name = "addResources")
        public final /* synthetic */ void addResources(DslList dslList, SrmPutV1.StaticResource value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addResources(value);
        }

        public final void clearAppVersion() {
            this._builder.clearAppVersion();
        }

        public final void clearPlatform() {
            this._builder.clearPlatform();
        }

        public final void clearProjectId() {
            this._builder.clearProjectId();
        }

        @JvmName(name = "clearResources")
        public final /* synthetic */ void clearResources(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearResources();
        }

        public final void clearSdkMetadata() {
            this._builder.clearSdkMetadata();
        }

        public final void clearSdkVersion() {
            this._builder.clearSdkVersion();
        }

        @JvmName(name = "getAppVersion")
        @NotNull
        public final String getAppVersion() {
            String appVersion = this._builder.getAppVersion();
            Intrinsics.checkNotNullExpressionValue(appVersion, "_builder.getAppVersion()");
            return appVersion;
        }

        @JvmName(name = "getPlatform")
        @NotNull
        public final SrmPutV1.Platform getPlatform() {
            SrmPutV1.Platform platform = this._builder.getPlatform();
            Intrinsics.checkNotNullExpressionValue(platform, "_builder.getPlatform()");
            return platform;
        }

        @JvmName(name = "getPlatformValue")
        public final int getPlatformValue() {
            return this._builder.getPlatformValue();
        }

        @JvmName(name = "getProjectId")
        public final int getProjectId() {
            return this._builder.getProjectId();
        }

        public final /* synthetic */ DslList getResources() {
            List<SrmPutV1.StaticResource> resourcesList = this._builder.getResourcesList();
            Intrinsics.checkNotNullExpressionValue(resourcesList, "_builder.getResourcesList()");
            return new DslList(resourcesList);
        }

        @JvmName(name = "getSdkMetadata")
        @NotNull
        public final String getSdkMetadata() {
            String sdkMetadata = this._builder.getSdkMetadata();
            Intrinsics.checkNotNullExpressionValue(sdkMetadata, "_builder.getSdkMetadata()");
            return sdkMetadata;
        }

        @JvmName(name = "getSdkVersion")
        @NotNull
        public final String getSdkVersion() {
            String sdkVersion = this._builder.getSdkVersion();
            Intrinsics.checkNotNullExpressionValue(sdkVersion, "_builder.getSdkVersion()");
            return sdkVersion;
        }

        @JvmName(name = "plusAssignAllResources")
        public final /* synthetic */ void plusAssignAllResources(DslList<SrmPutV1.StaticResource, ResourcesProxy> dslList, Iterable<SrmPutV1.StaticResource> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllResources(dslList, values);
        }

        @JvmName(name = "plusAssignResources")
        public final /* synthetic */ void plusAssignResources(DslList<SrmPutV1.StaticResource, ResourcesProxy> dslList, SrmPutV1.StaticResource value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addResources(dslList, value);
        }

        @JvmName(name = "setAppVersion")
        public final void setAppVersion(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setAppVersion(value);
        }

        @JvmName(name = "setPlatform")
        public final void setPlatform(SrmPutV1.Platform value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setPlatform(value);
        }

        @JvmName(name = "setPlatformValue")
        public final void setPlatformValue(int i) {
            this._builder.setPlatformValue(i);
        }

        @JvmName(name = "setProjectId")
        public final void setProjectId(int i) {
            this._builder.setProjectId(i);
        }

        @JvmName(name = "setResources")
        public final /* synthetic */ void setResources(DslList dslList, int i, SrmPutV1.StaticResource value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setResources(i, value);
        }

        @JvmName(name = "setSdkMetadata")
        public final void setSdkMetadata(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setSdkMetadata(value);
        }

        @JvmName(name = "setSdkVersion")
        public final void setSdkVersion(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setSdkVersion(value);
        }

        public /* synthetic */ Dsl(SrmPutV1.StaticResources.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    private StaticResourcesKt() {
    }
}
