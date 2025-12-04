package com.contentsquare.proto.replayproperties.v1;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class ReplayPropertiesV1 {

    /* renamed from: com.contentsquare.proto.replayproperties.v1.ReplayPropertiesV1$1, reason: invalid class name */
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

    public static final class ReplayProperties extends GeneratedMessageLite<ReplayProperties, Builder> implements ReplayPropertiesOrBuilder {
        private static final ReplayProperties DEFAULT_INSTANCE;
        public static final int PAGEVIEW_NUMBER_FIELD_NUMBER = 5;
        private static volatile Parser<ReplayProperties> PARSER = null;
        public static final int PROJECT_ID_FIELD_NUMBER = 2;
        public static final int RELATIVE_TIME_MS_FIELD_NUMBER = 6;
        public static final int SCHEMA_VERSION_FIELD_NUMBER = 1;
        public static final int SESSION_NUMBER_FIELD_NUMBER = 4;
        public static final int VISITOR_ID_FIELD_NUMBER = 3;
        private int pageviewNumber_;
        private int projectId_;
        private long relativeTimeMs_;
        private int sessionNumber_;
        private String schemaVersion_ = "";
        private String visitorId_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<ReplayProperties, Builder> implements ReplayPropertiesOrBuilder {
            private Builder() {
                super(ReplayProperties.DEFAULT_INSTANCE);
            }

            public Builder clearPageviewNumber() {
                copyOnWrite();
                ((ReplayProperties) this.instance).clearPageviewNumber();
                return this;
            }

            public Builder clearProjectId() {
                copyOnWrite();
                ((ReplayProperties) this.instance).clearProjectId();
                return this;
            }

            public Builder clearRelativeTimeMs() {
                copyOnWrite();
                ((ReplayProperties) this.instance).clearRelativeTimeMs();
                return this;
            }

            public Builder clearSchemaVersion() {
                copyOnWrite();
                ((ReplayProperties) this.instance).clearSchemaVersion();
                return this;
            }

            public Builder clearSessionNumber() {
                copyOnWrite();
                ((ReplayProperties) this.instance).clearSessionNumber();
                return this;
            }

            public Builder clearVisitorId() {
                copyOnWrite();
                ((ReplayProperties) this.instance).clearVisitorId();
                return this;
            }

            @Override // com.contentsquare.proto.replayproperties.v1.ReplayPropertiesV1.ReplayPropertiesOrBuilder
            public int getPageviewNumber() {
                return ((ReplayProperties) this.instance).getPageviewNumber();
            }

            @Override // com.contentsquare.proto.replayproperties.v1.ReplayPropertiesV1.ReplayPropertiesOrBuilder
            public int getProjectId() {
                return ((ReplayProperties) this.instance).getProjectId();
            }

            @Override // com.contentsquare.proto.replayproperties.v1.ReplayPropertiesV1.ReplayPropertiesOrBuilder
            public long getRelativeTimeMs() {
                return ((ReplayProperties) this.instance).getRelativeTimeMs();
            }

            @Override // com.contentsquare.proto.replayproperties.v1.ReplayPropertiesV1.ReplayPropertiesOrBuilder
            public String getSchemaVersion() {
                return ((ReplayProperties) this.instance).getSchemaVersion();
            }

            @Override // com.contentsquare.proto.replayproperties.v1.ReplayPropertiesV1.ReplayPropertiesOrBuilder
            public ByteString getSchemaVersionBytes() {
                return ((ReplayProperties) this.instance).getSchemaVersionBytes();
            }

            @Override // com.contentsquare.proto.replayproperties.v1.ReplayPropertiesV1.ReplayPropertiesOrBuilder
            public int getSessionNumber() {
                return ((ReplayProperties) this.instance).getSessionNumber();
            }

            @Override // com.contentsquare.proto.replayproperties.v1.ReplayPropertiesV1.ReplayPropertiesOrBuilder
            public String getVisitorId() {
                return ((ReplayProperties) this.instance).getVisitorId();
            }

            @Override // com.contentsquare.proto.replayproperties.v1.ReplayPropertiesV1.ReplayPropertiesOrBuilder
            public ByteString getVisitorIdBytes() {
                return ((ReplayProperties) this.instance).getVisitorIdBytes();
            }

            public Builder setPageviewNumber(int i) {
                copyOnWrite();
                ((ReplayProperties) this.instance).setPageviewNumber(i);
                return this;
            }

            public Builder setProjectId(int i) {
                copyOnWrite();
                ((ReplayProperties) this.instance).setProjectId(i);
                return this;
            }

            public Builder setRelativeTimeMs(long j) {
                copyOnWrite();
                ((ReplayProperties) this.instance).setRelativeTimeMs(j);
                return this;
            }

            public Builder setSchemaVersion(String str) {
                copyOnWrite();
                ((ReplayProperties) this.instance).setSchemaVersion(str);
                return this;
            }

            public Builder setSchemaVersionBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((ReplayProperties) this.instance).setSchemaVersionBytes(byteString);
                return this;
            }

            public Builder setSessionNumber(int i) {
                copyOnWrite();
                ((ReplayProperties) this.instance).setSessionNumber(i);
                return this;
            }

            public Builder setVisitorId(String str) {
                copyOnWrite();
                ((ReplayProperties) this.instance).setVisitorId(str);
                return this;
            }

            public Builder setVisitorIdBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((ReplayProperties) this.instance).setVisitorIdBytes(byteString);
                return this;
            }
        }

        static {
            ReplayProperties replayProperties = new ReplayProperties();
            DEFAULT_INSTANCE = replayProperties;
            GeneratedMessageLite.registerDefaultInstance(ReplayProperties.class, replayProperties);
        }

        private ReplayProperties() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPageviewNumber() {
            this.pageviewNumber_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearProjectId() {
            this.projectId_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRelativeTimeMs() {
            this.relativeTimeMs_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSchemaVersion() {
            this.schemaVersion_ = getDefaultInstance().getSchemaVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSessionNumber() {
            this.sessionNumber_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVisitorId() {
            this.visitorId_ = getDefaultInstance().getVisitorId();
        }

        public static ReplayProperties getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ReplayProperties parseDelimitedFrom(InputStream inputStream) {
            return (ReplayProperties) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReplayProperties parseFrom(ByteString byteString) {
            return (ReplayProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<ReplayProperties> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPageviewNumber(int i) {
            this.pageviewNumber_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProjectId(int i) {
            this.projectId_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRelativeTimeMs(long j) {
            this.relativeTimeMs_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSchemaVersion(String str) {
            str.getClass();
            this.schemaVersion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSchemaVersionBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.schemaVersion_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionNumber(int i) {
            this.sessionNumber_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVisitorId(String str) {
            str.getClass();
            this.visitorId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVisitorIdBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.visitorId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new ReplayProperties();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002\u000b\u0003Ȉ\u0004\u000b\u0005\u000b\u0006\u0003", new Object[]{"schemaVersion_", "projectId_", "visitorId_", "sessionNumber_", "pageviewNumber_", "relativeTimeMs_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ReplayProperties> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (ReplayProperties.class) {
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

        @Override // com.contentsquare.proto.replayproperties.v1.ReplayPropertiesV1.ReplayPropertiesOrBuilder
        public int getPageviewNumber() {
            return this.pageviewNumber_;
        }

        @Override // com.contentsquare.proto.replayproperties.v1.ReplayPropertiesV1.ReplayPropertiesOrBuilder
        public int getProjectId() {
            return this.projectId_;
        }

        @Override // com.contentsquare.proto.replayproperties.v1.ReplayPropertiesV1.ReplayPropertiesOrBuilder
        public long getRelativeTimeMs() {
            return this.relativeTimeMs_;
        }

        @Override // com.contentsquare.proto.replayproperties.v1.ReplayPropertiesV1.ReplayPropertiesOrBuilder
        public String getSchemaVersion() {
            return this.schemaVersion_;
        }

        @Override // com.contentsquare.proto.replayproperties.v1.ReplayPropertiesV1.ReplayPropertiesOrBuilder
        public ByteString getSchemaVersionBytes() {
            return ByteString.copyFromUtf8(this.schemaVersion_);
        }

        @Override // com.contentsquare.proto.replayproperties.v1.ReplayPropertiesV1.ReplayPropertiesOrBuilder
        public int getSessionNumber() {
            return this.sessionNumber_;
        }

        @Override // com.contentsquare.proto.replayproperties.v1.ReplayPropertiesV1.ReplayPropertiesOrBuilder
        public String getVisitorId() {
            return this.visitorId_;
        }

        @Override // com.contentsquare.proto.replayproperties.v1.ReplayPropertiesV1.ReplayPropertiesOrBuilder
        public ByteString getVisitorIdBytes() {
            return ByteString.copyFromUtf8(this.visitorId_);
        }

        public static Builder newBuilder(ReplayProperties replayProperties) {
            return DEFAULT_INSTANCE.createBuilder(replayProperties);
        }

        public static ReplayProperties parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReplayProperties) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReplayProperties parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ReplayProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReplayProperties parseFrom(CodedInputStream codedInputStream) {
            return (ReplayProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReplayProperties parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReplayProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ReplayProperties parseFrom(InputStream inputStream) {
            return (ReplayProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReplayProperties parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReplayProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReplayProperties parseFrom(ByteBuffer byteBuffer) {
            return (ReplayProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ReplayProperties parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ReplayProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ReplayProperties parseFrom(byte[] bArr) {
            return (ReplayProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ReplayProperties parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ReplayProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface ReplayPropertiesOrBuilder extends MessageLiteOrBuilder {
        int getPageviewNumber();

        int getProjectId();

        long getRelativeTimeMs();

        String getSchemaVersion();

        ByteString getSchemaVersionBytes();

        int getSessionNumber();

        String getVisitorId();

        ByteString getVisitorIdBytes();
    }

    private ReplayPropertiesV1() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
