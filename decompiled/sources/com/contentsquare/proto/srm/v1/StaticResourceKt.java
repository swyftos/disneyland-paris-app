package com.contentsquare.proto.srm.v1;

import com.contentsquare.proto.srm.v1.SrmPutV1;
import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.cms.CMSAttributeTableGenerator;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/srm/v1/StaticResourceKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StaticResourceKt {

    @NotNull
    public static final StaticResourceKt INSTANCE = new StaticResourceKt();

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010*\u001a\u00020+H\u0001J\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020-J\u0006\u0010/\u001a\u00020-J\u0006\u00100\u001a\u00020-J\u0006\u00101\u001a\u00020-R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R$\u0010!\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR$\u0010%\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00063"}, d2 = {"Lcom/contentsquare/proto/srm/v1/StaticResourceKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/srm/v1/SrmPutV1$StaticResource$Builder;", "(Lcom/contentsquare/proto/srm/v1/SrmPutV1$StaticResource$Builder;)V", "value", "", CMSAttributeTableGenerator.CONTENT_TYPE, "getContentType", "()Ljava/lang/String;", "setContentType", "(Ljava/lang/String;)V", "Lcom/contentsquare/proto/srm/v1/SrmPutV1$EncodingType;", "encodingType", "getEncodingType", "()Lcom/contentsquare/proto/srm/v1/SrmPutV1$EncodingType;", "setEncodingType", "(Lcom/contentsquare/proto/srm/v1/SrmPutV1$EncodingType;)V", "", "encodingTypeValue", "getEncodingTypeValue", "()I", "setEncodingTypeValue", "(I)V", "Lcom/contentsquare/proto/srm/v1/SrmPutV1$DataFormat;", "format", "getFormat", "()Lcom/contentsquare/proto/srm/v1/SrmPutV1$DataFormat;", "setFormat", "(Lcom/contentsquare/proto/srm/v1/SrmPutV1$DataFormat;)V", "formatValue", "getFormatValue", "setFormatValue", "hash", "getHash", "setHash", "Lcom/google/protobuf/ByteString;", "resource", "getResource", "()Lcom/google/protobuf/ByteString;", "setResource", "(Lcom/google/protobuf/ByteString;)V", "_build", "Lcom/contentsquare/proto/srm/v1/SrmPutV1$StaticResource;", "clearContentType", "", "clearEncodingType", "clearFormat", "clearHash", "clearResource", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final SrmPutV1.StaticResource.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/srm/v1/StaticResourceKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/srm/v1/StaticResourceKt$Dsl;", "builder", "Lcom/contentsquare/proto/srm/v1/SrmPutV1$StaticResource$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(SrmPutV1.StaticResource.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Dsl(SrmPutV1.StaticResource.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ SrmPutV1.StaticResource _build() {
            SrmPutV1.StaticResource staticResourceBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(staticResourceBuild, "_builder.build()");
            return staticResourceBuild;
        }

        public final void clearContentType() {
            this._builder.clearContentType();
        }

        public final void clearEncodingType() {
            this._builder.clearEncodingType();
        }

        public final void clearFormat() {
            this._builder.clearFormat();
        }

        public final void clearHash() {
            this._builder.clearHash();
        }

        public final void clearResource() {
            this._builder.clearResource();
        }

        @JvmName(name = "getContentType")
        @NotNull
        public final String getContentType() {
            String contentType = this._builder.getContentType();
            Intrinsics.checkNotNullExpressionValue(contentType, "_builder.getContentType()");
            return contentType;
        }

        @JvmName(name = "getEncodingType")
        @NotNull
        public final SrmPutV1.EncodingType getEncodingType() {
            SrmPutV1.EncodingType encodingType = this._builder.getEncodingType();
            Intrinsics.checkNotNullExpressionValue(encodingType, "_builder.getEncodingType()");
            return encodingType;
        }

        @JvmName(name = "getEncodingTypeValue")
        public final int getEncodingTypeValue() {
            return this._builder.getEncodingTypeValue();
        }

        @JvmName(name = "getFormat")
        @NotNull
        public final SrmPutV1.DataFormat getFormat() {
            SrmPutV1.DataFormat format = this._builder.getFormat();
            Intrinsics.checkNotNullExpressionValue(format, "_builder.getFormat()");
            return format;
        }

        @JvmName(name = "getFormatValue")
        public final int getFormatValue() {
            return this._builder.getFormatValue();
        }

        @JvmName(name = "getHash")
        @NotNull
        public final String getHash() {
            String hash = this._builder.getHash();
            Intrinsics.checkNotNullExpressionValue(hash, "_builder.getHash()");
            return hash;
        }

        @JvmName(name = "getResource")
        @NotNull
        public final ByteString getResource() {
            ByteString resource = this._builder.getResource();
            Intrinsics.checkNotNullExpressionValue(resource, "_builder.getResource()");
            return resource;
        }

        @JvmName(name = "setContentType")
        public final void setContentType(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setContentType(value);
        }

        @JvmName(name = "setEncodingType")
        public final void setEncodingType(SrmPutV1.EncodingType value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setEncodingType(value);
        }

        @JvmName(name = "setEncodingTypeValue")
        public final void setEncodingTypeValue(int i) {
            this._builder.setEncodingTypeValue(i);
        }

        @JvmName(name = "setFormat")
        public final void setFormat(SrmPutV1.DataFormat value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setFormat(value);
        }

        @JvmName(name = "setFormatValue")
        public final void setFormatValue(int i) {
            this._builder.setFormatValue(i);
        }

        @JvmName(name = "setHash")
        public final void setHash(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setHash(value);
        }

        @JvmName(name = "setResource")
        public final void setResource(ByteString value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setResource(value);
        }

        public /* synthetic */ Dsl(SrmPutV1.StaticResource.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    private StaticResourceKt() {
    }
}
