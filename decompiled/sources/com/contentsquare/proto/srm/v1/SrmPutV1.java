package com.contentsquare.proto.srm.v1;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class SrmPutV1 {

    /* renamed from: com.contentsquare.proto.srm.v1.SrmPutV1$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public enum DataFormat implements Internal.EnumLite {
        DATA_FORMAT_UNSPECIFIED(0),
        DATA_FORMAT_PNG(1),
        DATA_FORMAT_JPEG(2),
        DATA_FORMAT_BMP(3),
        DATA_FORMAT_GIF(4),
        DATA_FORMAT_TIFF(5),
        UNRECOGNIZED(-1);

        public static final int DATA_FORMAT_BMP_VALUE = 3;
        public static final int DATA_FORMAT_GIF_VALUE = 4;
        public static final int DATA_FORMAT_JPEG_VALUE = 2;
        public static final int DATA_FORMAT_PNG_VALUE = 1;
        public static final int DATA_FORMAT_TIFF_VALUE = 5;
        public static final int DATA_FORMAT_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<DataFormat> internalValueMap = new Internal.EnumLiteMap<DataFormat>() { // from class: com.contentsquare.proto.srm.v1.SrmPutV1.DataFormat.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public DataFormat findValueByNumber(int i) {
                return DataFormat.forNumber(i);
            }
        };
        private final int value;

        public static final class DataFormatVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new DataFormatVerifier();

            private DataFormatVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return DataFormat.forNumber(i) != null;
            }
        }

        DataFormat(int i) {
            this.value = i;
        }

        public static DataFormat forNumber(int i) {
            if (i == 0) {
                return DATA_FORMAT_UNSPECIFIED;
            }
            if (i == 1) {
                return DATA_FORMAT_PNG;
            }
            if (i == 2) {
                return DATA_FORMAT_JPEG;
            }
            if (i == 3) {
                return DATA_FORMAT_BMP;
            }
            if (i == 4) {
                return DATA_FORMAT_GIF;
            }
            if (i != 5) {
                return null;
            }
            return DATA_FORMAT_TIFF;
        }

        public static Internal.EnumLiteMap<DataFormat> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return DataFormatVerifier.INSTANCE;
        }

        @Deprecated
        public static DataFormat valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public enum EncodingType implements Internal.EnumLite {
        ENCODING_TYPE_UNSPECIFIED(0),
        ENCODING_TYPE_GZIP(1),
        ENCODING_TYPE_BASE64(2),
        UNRECOGNIZED(-1);

        public static final int ENCODING_TYPE_BASE64_VALUE = 2;
        public static final int ENCODING_TYPE_GZIP_VALUE = 1;
        public static final int ENCODING_TYPE_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<EncodingType> internalValueMap = new Internal.EnumLiteMap<EncodingType>() { // from class: com.contentsquare.proto.srm.v1.SrmPutV1.EncodingType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public EncodingType findValueByNumber(int i) {
                return EncodingType.forNumber(i);
            }
        };
        private final int value;

        public static final class EncodingTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new EncodingTypeVerifier();

            private EncodingTypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return EncodingType.forNumber(i) != null;
            }
        }

        EncodingType(int i) {
            this.value = i;
        }

        public static EncodingType forNumber(int i) {
            if (i == 0) {
                return ENCODING_TYPE_UNSPECIFIED;
            }
            if (i == 1) {
                return ENCODING_TYPE_GZIP;
            }
            if (i != 2) {
                return null;
            }
            return ENCODING_TYPE_BASE64;
        }

        public static Internal.EnumLiteMap<EncodingType> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return EncodingTypeVerifier.INSTANCE;
        }

        @Deprecated
        public static EncodingType valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public enum Platform implements Internal.EnumLite {
        PLATFORM_UNSPECIFIED(0),
        PLATFORM_IOS(1),
        PLATFORM_ANDROID(2),
        PLATFORM_WEB(3),
        UNRECOGNIZED(-1);

        public static final int PLATFORM_ANDROID_VALUE = 2;
        public static final int PLATFORM_IOS_VALUE = 1;
        public static final int PLATFORM_UNSPECIFIED_VALUE = 0;
        public static final int PLATFORM_WEB_VALUE = 3;
        private static final Internal.EnumLiteMap<Platform> internalValueMap = new Internal.EnumLiteMap<Platform>() { // from class: com.contentsquare.proto.srm.v1.SrmPutV1.Platform.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Platform findValueByNumber(int i) {
                return Platform.forNumber(i);
            }
        };
        private final int value;

        public static final class PlatformVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new PlatformVerifier();

            private PlatformVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return Platform.forNumber(i) != null;
            }
        }

        Platform(int i) {
            this.value = i;
        }

        public static Platform forNumber(int i) {
            if (i == 0) {
                return PLATFORM_UNSPECIFIED;
            }
            if (i == 1) {
                return PLATFORM_IOS;
            }
            if (i == 2) {
                return PLATFORM_ANDROID;
            }
            if (i != 3) {
                return null;
            }
            return PLATFORM_WEB;
        }

        public static Internal.EnumLiteMap<Platform> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return PlatformVerifier.INSTANCE;
        }

        @Deprecated
        public static Platform valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public static final class StaticResource extends GeneratedMessageLite<StaticResource, Builder> implements StaticResourceOrBuilder {
        public static final int CONTENT_TYPE_FIELD_NUMBER = 5;
        private static final StaticResource DEFAULT_INSTANCE;
        public static final int ENCODING_TYPE_FIELD_NUMBER = 4;
        public static final int FORMAT_FIELD_NUMBER = 3;
        public static final int HASH_FIELD_NUMBER = 1;
        private static volatile Parser<StaticResource> PARSER = null;
        public static final int RESOURCE_FIELD_NUMBER = 2;
        private int encodingType_;
        private int format_;
        private String hash_ = "";
        private ByteString resource_ = ByteString.EMPTY;
        private String contentType_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<StaticResource, Builder> implements StaticResourceOrBuilder {
            private Builder() {
                super(StaticResource.DEFAULT_INSTANCE);
            }

            public Builder clearContentType() {
                copyOnWrite();
                ((StaticResource) this.instance).clearContentType();
                return this;
            }

            public Builder clearEncodingType() {
                copyOnWrite();
                ((StaticResource) this.instance).clearEncodingType();
                return this;
            }

            public Builder clearFormat() {
                copyOnWrite();
                ((StaticResource) this.instance).clearFormat();
                return this;
            }

            public Builder clearHash() {
                copyOnWrite();
                ((StaticResource) this.instance).clearHash();
                return this;
            }

            public Builder clearResource() {
                copyOnWrite();
                ((StaticResource) this.instance).clearResource();
                return this;
            }

            @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourceOrBuilder
            public String getContentType() {
                return ((StaticResource) this.instance).getContentType();
            }

            @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourceOrBuilder
            public ByteString getContentTypeBytes() {
                return ((StaticResource) this.instance).getContentTypeBytes();
            }

            @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourceOrBuilder
            public EncodingType getEncodingType() {
                return ((StaticResource) this.instance).getEncodingType();
            }

            @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourceOrBuilder
            public int getEncodingTypeValue() {
                return ((StaticResource) this.instance).getEncodingTypeValue();
            }

            @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourceOrBuilder
            public DataFormat getFormat() {
                return ((StaticResource) this.instance).getFormat();
            }

            @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourceOrBuilder
            public int getFormatValue() {
                return ((StaticResource) this.instance).getFormatValue();
            }

            @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourceOrBuilder
            public String getHash() {
                return ((StaticResource) this.instance).getHash();
            }

            @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourceOrBuilder
            public ByteString getHashBytes() {
                return ((StaticResource) this.instance).getHashBytes();
            }

            @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourceOrBuilder
            public ByteString getResource() {
                return ((StaticResource) this.instance).getResource();
            }

            public Builder setContentType(String str) {
                copyOnWrite();
                ((StaticResource) this.instance).setContentType(str);
                return this;
            }

            public Builder setContentTypeBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((StaticResource) this.instance).setContentTypeBytes(byteString);
                return this;
            }

            public Builder setEncodingType(EncodingType encodingType) {
                copyOnWrite();
                ((StaticResource) this.instance).setEncodingType(encodingType);
                return this;
            }

            public Builder setEncodingTypeValue(int i) {
                copyOnWrite();
                ((StaticResource) this.instance).setEncodingTypeValue(i);
                return this;
            }

            public Builder setFormat(DataFormat dataFormat) {
                copyOnWrite();
                ((StaticResource) this.instance).setFormat(dataFormat);
                return this;
            }

            public Builder setFormatValue(int i) {
                copyOnWrite();
                ((StaticResource) this.instance).setFormatValue(i);
                return this;
            }

            public Builder setHash(String str) {
                copyOnWrite();
                ((StaticResource) this.instance).setHash(str);
                return this;
            }

            public Builder setHashBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((StaticResource) this.instance).setHashBytes(byteString);
                return this;
            }

            public Builder setResource(ByteString byteString) {
                copyOnWrite();
                ((StaticResource) this.instance).setResource(byteString);
                return this;
            }
        }

        static {
            StaticResource staticResource = new StaticResource();
            DEFAULT_INSTANCE = staticResource;
            GeneratedMessageLite.registerDefaultInstance(StaticResource.class, staticResource);
        }

        private StaticResource() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearContentType() {
            this.contentType_ = getDefaultInstance().getContentType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEncodingType() {
            this.encodingType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFormat() {
            this.format_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHash() {
            this.hash_ = getDefaultInstance().getHash();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearResource() {
            this.resource_ = getDefaultInstance().getResource();
        }

        public static StaticResource getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static StaticResource parseDelimitedFrom(InputStream inputStream) {
            return (StaticResource) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StaticResource parseFrom(ByteString byteString) {
            return (StaticResource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<StaticResource> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContentType(String str) {
            str.getClass();
            this.contentType_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContentTypeBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.contentType_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEncodingType(EncodingType encodingType) {
            this.encodingType_ = encodingType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEncodingTypeValue(int i) {
            this.encodingType_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFormat(DataFormat dataFormat) {
            this.format_ = dataFormat.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFormatValue(int i) {
            this.format_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHash(String str) {
            str.getClass();
            this.hash_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHashBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.hash_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setResource(ByteString byteString) {
            byteString.getClass();
            this.resource_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new StaticResource();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f\u0004\f\u0005Ȉ", new Object[]{"hash_", "resource_", "format_", "encodingType_", "contentType_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StaticResource> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (StaticResource.class) {
                            try {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                            } finally {
                            }
                        }
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourceOrBuilder
        public String getContentType() {
            return this.contentType_;
        }

        @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourceOrBuilder
        public ByteString getContentTypeBytes() {
            return ByteString.copyFromUtf8(this.contentType_);
        }

        @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourceOrBuilder
        public EncodingType getEncodingType() {
            EncodingType encodingTypeForNumber = EncodingType.forNumber(this.encodingType_);
            return encodingTypeForNumber == null ? EncodingType.UNRECOGNIZED : encodingTypeForNumber;
        }

        @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourceOrBuilder
        public int getEncodingTypeValue() {
            return this.encodingType_;
        }

        @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourceOrBuilder
        public DataFormat getFormat() {
            DataFormat dataFormatForNumber = DataFormat.forNumber(this.format_);
            return dataFormatForNumber == null ? DataFormat.UNRECOGNIZED : dataFormatForNumber;
        }

        @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourceOrBuilder
        public int getFormatValue() {
            return this.format_;
        }

        @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourceOrBuilder
        public String getHash() {
            return this.hash_;
        }

        @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourceOrBuilder
        public ByteString getHashBytes() {
            return ByteString.copyFromUtf8(this.hash_);
        }

        @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourceOrBuilder
        public ByteString getResource() {
            return this.resource_;
        }

        public static Builder newBuilder(StaticResource staticResource) {
            return DEFAULT_INSTANCE.createBuilder(staticResource);
        }

        public static StaticResource parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (StaticResource) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StaticResource parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (StaticResource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StaticResource parseFrom(CodedInputStream codedInputStream) {
            return (StaticResource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StaticResource parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (StaticResource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static StaticResource parseFrom(InputStream inputStream) {
            return (StaticResource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StaticResource parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (StaticResource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StaticResource parseFrom(ByteBuffer byteBuffer) {
            return (StaticResource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StaticResource parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (StaticResource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StaticResource parseFrom(byte[] bArr) {
            return (StaticResource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StaticResource parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (StaticResource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface StaticResourceOrBuilder extends MessageLiteOrBuilder {
        String getContentType();

        ByteString getContentTypeBytes();

        EncodingType getEncodingType();

        int getEncodingTypeValue();

        DataFormat getFormat();

        int getFormatValue();

        String getHash();

        ByteString getHashBytes();

        ByteString getResource();
    }

    public static final class StaticResources extends GeneratedMessageLite<StaticResources, Builder> implements StaticResourcesOrBuilder {
        public static final int APP_VERSION_FIELD_NUMBER = 4;
        private static final StaticResources DEFAULT_INSTANCE;
        private static volatile Parser<StaticResources> PARSER = null;
        public static final int PLATFORM_FIELD_NUMBER = 2;
        public static final int PROJECT_ID_FIELD_NUMBER = 1;
        public static final int RESOURCES_FIELD_NUMBER = 6;
        public static final int SDK_METADATA_FIELD_NUMBER = 5;
        public static final int SDK_VERSION_FIELD_NUMBER = 3;
        private int platform_;
        private int projectId_;
        private String sdkVersion_ = "";
        private String appVersion_ = "";
        private String sdkMetadata_ = "";
        private Internal.ProtobufList<StaticResource> resources_ = GeneratedMessageLite.emptyProtobufList();

        public static final class Builder extends GeneratedMessageLite.Builder<StaticResources, Builder> implements StaticResourcesOrBuilder {
            private Builder() {
                super(StaticResources.DEFAULT_INSTANCE);
            }

            public Builder addAllResources(Iterable<? extends StaticResource> iterable) {
                copyOnWrite();
                ((StaticResources) this.instance).addAllResources(iterable);
                return this;
            }

            public Builder addResources(int i, StaticResource.Builder builder) {
                copyOnWrite();
                ((StaticResources) this.instance).addResources(i, builder.build());
                return this;
            }

            public Builder clearAppVersion() {
                copyOnWrite();
                ((StaticResources) this.instance).clearAppVersion();
                return this;
            }

            public Builder clearPlatform() {
                copyOnWrite();
                ((StaticResources) this.instance).clearPlatform();
                return this;
            }

            public Builder clearProjectId() {
                copyOnWrite();
                ((StaticResources) this.instance).clearProjectId();
                return this;
            }

            public Builder clearResources() {
                copyOnWrite();
                ((StaticResources) this.instance).clearResources();
                return this;
            }

            public Builder clearSdkMetadata() {
                copyOnWrite();
                ((StaticResources) this.instance).clearSdkMetadata();
                return this;
            }

            public Builder clearSdkVersion() {
                copyOnWrite();
                ((StaticResources) this.instance).clearSdkVersion();
                return this;
            }

            @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
            public String getAppVersion() {
                return ((StaticResources) this.instance).getAppVersion();
            }

            @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
            public ByteString getAppVersionBytes() {
                return ((StaticResources) this.instance).getAppVersionBytes();
            }

            @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
            public Platform getPlatform() {
                return ((StaticResources) this.instance).getPlatform();
            }

            @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
            public int getPlatformValue() {
                return ((StaticResources) this.instance).getPlatformValue();
            }

            @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
            public int getProjectId() {
                return ((StaticResources) this.instance).getProjectId();
            }

            @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
            public StaticResource getResources(int i) {
                return ((StaticResources) this.instance).getResources(i);
            }

            @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
            public int getResourcesCount() {
                return ((StaticResources) this.instance).getResourcesCount();
            }

            @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
            public List<StaticResource> getResourcesList() {
                return Collections.unmodifiableList(((StaticResources) this.instance).getResourcesList());
            }

            @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
            public String getSdkMetadata() {
                return ((StaticResources) this.instance).getSdkMetadata();
            }

            @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
            public ByteString getSdkMetadataBytes() {
                return ((StaticResources) this.instance).getSdkMetadataBytes();
            }

            @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
            public String getSdkVersion() {
                return ((StaticResources) this.instance).getSdkVersion();
            }

            @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
            public ByteString getSdkVersionBytes() {
                return ((StaticResources) this.instance).getSdkVersionBytes();
            }

            public Builder removeResources(int i) {
                copyOnWrite();
                ((StaticResources) this.instance).removeResources(i);
                return this;
            }

            public Builder setAppVersion(String str) {
                copyOnWrite();
                ((StaticResources) this.instance).setAppVersion(str);
                return this;
            }

            public Builder setAppVersionBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((StaticResources) this.instance).setAppVersionBytes(byteString);
                return this;
            }

            public Builder setPlatform(Platform platform) {
                copyOnWrite();
                ((StaticResources) this.instance).setPlatform(platform);
                return this;
            }

            public Builder setPlatformValue(int i) {
                copyOnWrite();
                ((StaticResources) this.instance).setPlatformValue(i);
                return this;
            }

            public Builder setProjectId(int i) {
                copyOnWrite();
                ((StaticResources) this.instance).setProjectId(i);
                return this;
            }

            public Builder setResources(int i, StaticResource.Builder builder) {
                copyOnWrite();
                ((StaticResources) this.instance).setResources(i, builder.build());
                return this;
            }

            public Builder setSdkMetadata(String str) {
                copyOnWrite();
                ((StaticResources) this.instance).setSdkMetadata(str);
                return this;
            }

            public Builder setSdkMetadataBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((StaticResources) this.instance).setSdkMetadataBytes(byteString);
                return this;
            }

            public Builder setSdkVersion(String str) {
                copyOnWrite();
                ((StaticResources) this.instance).setSdkVersion(str);
                return this;
            }

            public Builder setSdkVersionBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((StaticResources) this.instance).setSdkVersionBytes(byteString);
                return this;
            }

            public Builder addResources(int i, StaticResource staticResource) {
                copyOnWrite();
                ((StaticResources) this.instance).addResources(i, staticResource);
                return this;
            }

            public Builder setResources(int i, StaticResource staticResource) {
                copyOnWrite();
                ((StaticResources) this.instance).setResources(i, staticResource);
                return this;
            }

            public Builder addResources(StaticResource.Builder builder) {
                copyOnWrite();
                ((StaticResources) this.instance).addResources(builder.build());
                return this;
            }

            public Builder addResources(StaticResource staticResource) {
                copyOnWrite();
                ((StaticResources) this.instance).addResources(staticResource);
                return this;
            }
        }

        static {
            StaticResources staticResources = new StaticResources();
            DEFAULT_INSTANCE = staticResources;
            GeneratedMessageLite.registerDefaultInstance(StaticResources.class, staticResources);
        }

        private StaticResources() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllResources(Iterable<? extends StaticResource> iterable) {
            ensureResourcesIsMutable();
            AbstractMessageLite.addAll(iterable, this.resources_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addResources(int i, StaticResource staticResource) {
            staticResource.getClass();
            ensureResourcesIsMutable();
            this.resources_.add(i, staticResource);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppVersion() {
            this.appVersion_ = getDefaultInstance().getAppVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPlatform() {
            this.platform_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearProjectId() {
            this.projectId_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearResources() {
            this.resources_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSdkMetadata() {
            this.sdkMetadata_ = getDefaultInstance().getSdkMetadata();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSdkVersion() {
            this.sdkVersion_ = getDefaultInstance().getSdkVersion();
        }

        private void ensureResourcesIsMutable() {
            Internal.ProtobufList<StaticResource> protobufList = this.resources_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.resources_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static StaticResources getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static StaticResources parseDelimitedFrom(InputStream inputStream) {
            return (StaticResources) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StaticResources parseFrom(ByteString byteString) {
            return (StaticResources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<StaticResources> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeResources(int i) {
            ensureResourcesIsMutable();
            this.resources_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppVersion(String str) {
            str.getClass();
            this.appVersion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppVersionBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.appVersion_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlatform(Platform platform) {
            this.platform_ = platform.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlatformValue(int i) {
            this.platform_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProjectId(int i) {
            this.projectId_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setResources(int i, StaticResource staticResource) {
            staticResource.getClass();
            ensureResourcesIsMutable();
            this.resources_.set(i, staticResource);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSdkMetadata(String str) {
            str.getClass();
            this.sdkMetadata_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSdkMetadataBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.sdkMetadata_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSdkVersion(String str) {
            str.getClass();
            this.sdkVersion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSdkVersionBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.sdkVersion_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new StaticResources();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u000b\u0002\f\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\u001b", new Object[]{"projectId_", "platform_", "sdkVersion_", "appVersion_", "sdkMetadata_", "resources_", StaticResource.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StaticResources> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (StaticResources.class) {
                            try {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                            } finally {
                            }
                        }
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
        public String getAppVersion() {
            return this.appVersion_;
        }

        @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
        public ByteString getAppVersionBytes() {
            return ByteString.copyFromUtf8(this.appVersion_);
        }

        @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
        public Platform getPlatform() {
            Platform platformForNumber = Platform.forNumber(this.platform_);
            return platformForNumber == null ? Platform.UNRECOGNIZED : platformForNumber;
        }

        @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
        public int getPlatformValue() {
            return this.platform_;
        }

        @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
        public int getProjectId() {
            return this.projectId_;
        }

        @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
        public StaticResource getResources(int i) {
            return this.resources_.get(i);
        }

        @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
        public int getResourcesCount() {
            return this.resources_.size();
        }

        @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
        public List<StaticResource> getResourcesList() {
            return this.resources_;
        }

        public StaticResourceOrBuilder getResourcesOrBuilder(int i) {
            return this.resources_.get(i);
        }

        public List<? extends StaticResourceOrBuilder> getResourcesOrBuilderList() {
            return this.resources_;
        }

        @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
        public String getSdkMetadata() {
            return this.sdkMetadata_;
        }

        @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
        public ByteString getSdkMetadataBytes() {
            return ByteString.copyFromUtf8(this.sdkMetadata_);
        }

        @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
        public String getSdkVersion() {
            return this.sdkVersion_;
        }

        @Override // com.contentsquare.proto.srm.v1.SrmPutV1.StaticResourcesOrBuilder
        public ByteString getSdkVersionBytes() {
            return ByteString.copyFromUtf8(this.sdkVersion_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addResources(StaticResource staticResource) {
            staticResource.getClass();
            ensureResourcesIsMutable();
            this.resources_.add(staticResource);
        }

        public static Builder newBuilder(StaticResources staticResources) {
            return DEFAULT_INSTANCE.createBuilder(staticResources);
        }

        public static StaticResources parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (StaticResources) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StaticResources parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (StaticResources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StaticResources parseFrom(CodedInputStream codedInputStream) {
            return (StaticResources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StaticResources parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (StaticResources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static StaticResources parseFrom(InputStream inputStream) {
            return (StaticResources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StaticResources parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (StaticResources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StaticResources parseFrom(ByteBuffer byteBuffer) {
            return (StaticResources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StaticResources parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (StaticResources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StaticResources parseFrom(byte[] bArr) {
            return (StaticResources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StaticResources parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (StaticResources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface StaticResourcesOrBuilder extends MessageLiteOrBuilder {
        String getAppVersion();

        ByteString getAppVersionBytes();

        Platform getPlatform();

        int getPlatformValue();

        int getProjectId();

        StaticResource getResources(int i);

        int getResourcesCount();

        List<StaticResource> getResourcesList();

        String getSdkMetadata();

        ByteString getSdkMetadataBytes();

        String getSdkVersion();

        ByteString getSdkVersionBytes();
    }

    private SrmPutV1() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
