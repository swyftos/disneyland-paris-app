package com.contentsquare.proto.sessionreplay.v1;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class SessionRecordingV1 {

    /* renamed from: com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1$1, reason: invalid class name */
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

    public static final class AppStateChange extends GeneratedMessageLite<AppStateChange, Builder> implements AppStateChangeOrBuilder {
        private static final AppStateChange DEFAULT_INSTANCE;
        private static volatile Parser<AppStateChange> PARSER = null;
        public static final int STATE_TRANSITION_FIELD_NUMBER = 2;
        public static final int UNIX_TIMESTAMP_MS_FIELD_NUMBER = 1;
        private int stateTransition_;
        private long unixTimestampMs_;

        public static final class Builder extends GeneratedMessageLite.Builder<AppStateChange, Builder> implements AppStateChangeOrBuilder {
            private Builder() {
                super(AppStateChange.DEFAULT_INSTANCE);
            }

            public Builder clearStateTransition() {
                copyOnWrite();
                ((AppStateChange) this.instance).clearStateTransition();
                return this;
            }

            public Builder clearUnixTimestampMs() {
                copyOnWrite();
                ((AppStateChange) this.instance).clearUnixTimestampMs();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.AppStateChangeOrBuilder
            public Transition getStateTransition() {
                return ((AppStateChange) this.instance).getStateTransition();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.AppStateChangeOrBuilder
            public int getStateTransitionValue() {
                return ((AppStateChange) this.instance).getStateTransitionValue();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.AppStateChangeOrBuilder
            public long getUnixTimestampMs() {
                return ((AppStateChange) this.instance).getUnixTimestampMs();
            }

            public Builder setStateTransition(Transition transition) {
                copyOnWrite();
                ((AppStateChange) this.instance).setStateTransition(transition);
                return this;
            }

            public Builder setStateTransitionValue(int i) {
                copyOnWrite();
                ((AppStateChange) this.instance).setStateTransitionValue(i);
                return this;
            }

            public Builder setUnixTimestampMs(long j) {
                copyOnWrite();
                ((AppStateChange) this.instance).setUnixTimestampMs(j);
                return this;
            }
        }

        public enum Transition implements Internal.EnumLite {
            TRANSITION_UNSPECIFIED(0),
            TRANSITION_INACTIVE(1),
            TRANSITION_BACKGROUND(2),
            TRANSITION_FOREGROUND(3),
            TRANSITION_ACTIVE(4),
            UNRECOGNIZED(-1);

            public static final int TRANSITION_ACTIVE_VALUE = 4;
            public static final int TRANSITION_BACKGROUND_VALUE = 2;
            public static final int TRANSITION_FOREGROUND_VALUE = 3;
            public static final int TRANSITION_INACTIVE_VALUE = 1;
            public static final int TRANSITION_UNSPECIFIED_VALUE = 0;
            private static final Internal.EnumLiteMap<Transition> internalValueMap = new Internal.EnumLiteMap<Transition>() { // from class: com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.AppStateChange.Transition.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Transition findValueByNumber(int i) {
                    return Transition.forNumber(i);
                }
            };
            private final int value;

            public static final class TransitionVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new TransitionVerifier();

                private TransitionVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return Transition.forNumber(i) != null;
                }
            }

            Transition(int i) {
                this.value = i;
            }

            public static Transition forNumber(int i) {
                if (i == 0) {
                    return TRANSITION_UNSPECIFIED;
                }
                if (i == 1) {
                    return TRANSITION_INACTIVE;
                }
                if (i == 2) {
                    return TRANSITION_BACKGROUND;
                }
                if (i == 3) {
                    return TRANSITION_FOREGROUND;
                }
                if (i != 4) {
                    return null;
                }
                return TRANSITION_ACTIVE;
            }

            public static Internal.EnumLiteMap<Transition> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return TransitionVerifier.INSTANCE;
            }

            @Deprecated
            public static Transition valueOf(int i) {
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

        static {
            AppStateChange appStateChange = new AppStateChange();
            DEFAULT_INSTANCE = appStateChange;
            GeneratedMessageLite.registerDefaultInstance(AppStateChange.class, appStateChange);
        }

        private AppStateChange() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStateTransition() {
            this.stateTransition_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnixTimestampMs() {
            this.unixTimestampMs_ = 0L;
        }

        public static AppStateChange getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static AppStateChange parseDelimitedFrom(InputStream inputStream) {
            return (AppStateChange) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AppStateChange parseFrom(ByteString byteString) {
            return (AppStateChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<AppStateChange> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStateTransition(Transition transition) {
            this.stateTransition_ = transition.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStateTransitionValue(int i) {
            this.stateTransition_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnixTimestampMs(long j) {
            this.unixTimestampMs_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new AppStateChange();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0003\u0002\f", new Object[]{"unixTimestampMs_", "stateTransition_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<AppStateChange> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (AppStateChange.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.AppStateChangeOrBuilder
        public Transition getStateTransition() {
            Transition transitionForNumber = Transition.forNumber(this.stateTransition_);
            return transitionForNumber == null ? Transition.UNRECOGNIZED : transitionForNumber;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.AppStateChangeOrBuilder
        public int getStateTransitionValue() {
            return this.stateTransition_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.AppStateChangeOrBuilder
        public long getUnixTimestampMs() {
            return this.unixTimestampMs_;
        }

        public static Builder newBuilder(AppStateChange appStateChange) {
            return DEFAULT_INSTANCE.createBuilder(appStateChange);
        }

        public static AppStateChange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AppStateChange) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AppStateChange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (AppStateChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AppStateChange parseFrom(CodedInputStream codedInputStream) {
            return (AppStateChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AppStateChange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AppStateChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static AppStateChange parseFrom(InputStream inputStream) {
            return (AppStateChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AppStateChange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AppStateChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AppStateChange parseFrom(ByteBuffer byteBuffer) {
            return (AppStateChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static AppStateChange parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (AppStateChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static AppStateChange parseFrom(byte[] bArr) {
            return (AppStateChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AppStateChange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (AppStateChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface AppStateChangeOrBuilder extends MessageLiteOrBuilder {
        AppStateChange.Transition getStateTransition();

        int getStateTransitionValue();

        long getUnixTimestampMs();
    }

    public static final class AssetHash extends GeneratedMessageLite<AssetHash, Builder> implements AssetHashOrBuilder {
        public static final int ASSET_ID_FIELD_NUMBER = 1;
        private static final AssetHash DEFAULT_INSTANCE;
        public static final int HASH_FIELD_NUMBER = 2;
        private static volatile Parser<AssetHash> PARSER;
        private String assetId_ = "";
        private String hash_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<AssetHash, Builder> implements AssetHashOrBuilder {
            private Builder() {
                super(AssetHash.DEFAULT_INSTANCE);
            }

            public Builder clearAssetId() {
                copyOnWrite();
                ((AssetHash) this.instance).clearAssetId();
                return this;
            }

            public Builder clearHash() {
                copyOnWrite();
                ((AssetHash) this.instance).clearHash();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.AssetHashOrBuilder
            public String getAssetId() {
                return ((AssetHash) this.instance).getAssetId();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.AssetHashOrBuilder
            public ByteString getAssetIdBytes() {
                return ((AssetHash) this.instance).getAssetIdBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.AssetHashOrBuilder
            public String getHash() {
                return ((AssetHash) this.instance).getHash();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.AssetHashOrBuilder
            public ByteString getHashBytes() {
                return ((AssetHash) this.instance).getHashBytes();
            }

            public Builder setAssetId(String str) {
                copyOnWrite();
                ((AssetHash) this.instance).setAssetId(str);
                return this;
            }

            public Builder setAssetIdBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((AssetHash) this.instance).setAssetIdBytes(byteString);
                return this;
            }

            public Builder setHash(String str) {
                copyOnWrite();
                ((AssetHash) this.instance).setHash(str);
                return this;
            }

            public Builder setHashBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((AssetHash) this.instance).setHashBytes(byteString);
                return this;
            }
        }

        static {
            AssetHash assetHash = new AssetHash();
            DEFAULT_INSTANCE = assetHash;
            GeneratedMessageLite.registerDefaultInstance(AssetHash.class, assetHash);
        }

        private AssetHash() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAssetId() {
            this.assetId_ = getDefaultInstance().getAssetId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHash() {
            this.hash_ = getDefaultInstance().getHash();
        }

        public static AssetHash getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static AssetHash parseDelimitedFrom(InputStream inputStream) {
            return (AssetHash) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AssetHash parseFrom(ByteString byteString) {
            return (AssetHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<AssetHash> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAssetId(String str) {
            str.getClass();
            this.assetId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAssetIdBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.assetId_ = byteString.toStringUtf8();
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

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new AssetHash();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"assetId_", "hash_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<AssetHash> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (AssetHash.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.AssetHashOrBuilder
        public String getAssetId() {
            return this.assetId_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.AssetHashOrBuilder
        public ByteString getAssetIdBytes() {
            return ByteString.copyFromUtf8(this.assetId_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.AssetHashOrBuilder
        public String getHash() {
            return this.hash_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.AssetHashOrBuilder
        public ByteString getHashBytes() {
            return ByteString.copyFromUtf8(this.hash_);
        }

        public static Builder newBuilder(AssetHash assetHash) {
            return DEFAULT_INSTANCE.createBuilder(assetHash);
        }

        public static AssetHash parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AssetHash) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AssetHash parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (AssetHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AssetHash parseFrom(CodedInputStream codedInputStream) {
            return (AssetHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AssetHash parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AssetHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static AssetHash parseFrom(InputStream inputStream) {
            return (AssetHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AssetHash parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AssetHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AssetHash parseFrom(ByteBuffer byteBuffer) {
            return (AssetHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static AssetHash parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (AssetHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static AssetHash parseFrom(byte[] bArr) {
            return (AssetHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AssetHash parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (AssetHash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface AssetHashOrBuilder extends MessageLiteOrBuilder {
        String getAssetId();

        ByteString getAssetIdBytes();

        String getHash();

        ByteString getHashBytes();
    }

    public static final class AssetHashes extends GeneratedMessageLite<AssetHashes, Builder> implements AssetHashesOrBuilder {
        public static final int ASSET_HASHES_FIELD_NUMBER = 1;
        private static final AssetHashes DEFAULT_INSTANCE;
        private static volatile Parser<AssetHashes> PARSER;
        private Internal.ProtobufList<AssetHash> assetHashes_ = GeneratedMessageLite.emptyProtobufList();

        public static final class Builder extends GeneratedMessageLite.Builder<AssetHashes, Builder> implements AssetHashesOrBuilder {
            private Builder() {
                super(AssetHashes.DEFAULT_INSTANCE);
            }

            public Builder addAllAssetHashes(Iterable<? extends AssetHash> iterable) {
                copyOnWrite();
                ((AssetHashes) this.instance).addAllAssetHashes(iterable);
                return this;
            }

            public Builder addAssetHashes(int i, AssetHash.Builder builder) {
                copyOnWrite();
                ((AssetHashes) this.instance).addAssetHashes(i, builder.build());
                return this;
            }

            public Builder clearAssetHashes() {
                copyOnWrite();
                ((AssetHashes) this.instance).clearAssetHashes();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.AssetHashesOrBuilder
            public AssetHash getAssetHashes(int i) {
                return ((AssetHashes) this.instance).getAssetHashes(i);
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.AssetHashesOrBuilder
            public int getAssetHashesCount() {
                return ((AssetHashes) this.instance).getAssetHashesCount();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.AssetHashesOrBuilder
            public List<AssetHash> getAssetHashesList() {
                return Collections.unmodifiableList(((AssetHashes) this.instance).getAssetHashesList());
            }

            public Builder removeAssetHashes(int i) {
                copyOnWrite();
                ((AssetHashes) this.instance).removeAssetHashes(i);
                return this;
            }

            public Builder setAssetHashes(int i, AssetHash.Builder builder) {
                copyOnWrite();
                ((AssetHashes) this.instance).setAssetHashes(i, builder.build());
                return this;
            }

            public Builder addAssetHashes(int i, AssetHash assetHash) {
                copyOnWrite();
                ((AssetHashes) this.instance).addAssetHashes(i, assetHash);
                return this;
            }

            public Builder setAssetHashes(int i, AssetHash assetHash) {
                copyOnWrite();
                ((AssetHashes) this.instance).setAssetHashes(i, assetHash);
                return this;
            }

            public Builder addAssetHashes(AssetHash.Builder builder) {
                copyOnWrite();
                ((AssetHashes) this.instance).addAssetHashes(builder.build());
                return this;
            }

            public Builder addAssetHashes(AssetHash assetHash) {
                copyOnWrite();
                ((AssetHashes) this.instance).addAssetHashes(assetHash);
                return this;
            }
        }

        static {
            AssetHashes assetHashes = new AssetHashes();
            DEFAULT_INSTANCE = assetHashes;
            GeneratedMessageLite.registerDefaultInstance(AssetHashes.class, assetHashes);
        }

        private AssetHashes() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllAssetHashes(Iterable<? extends AssetHash> iterable) {
            ensureAssetHashesIsMutable();
            AbstractMessageLite.addAll(iterable, this.assetHashes_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAssetHashes(int i, AssetHash assetHash) {
            assetHash.getClass();
            ensureAssetHashesIsMutable();
            this.assetHashes_.add(i, assetHash);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAssetHashes() {
            this.assetHashes_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureAssetHashesIsMutable() {
            Internal.ProtobufList<AssetHash> protobufList = this.assetHashes_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.assetHashes_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static AssetHashes getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static AssetHashes parseDelimitedFrom(InputStream inputStream) {
            return (AssetHashes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AssetHashes parseFrom(ByteString byteString) {
            return (AssetHashes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<AssetHashes> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeAssetHashes(int i) {
            ensureAssetHashesIsMutable();
            this.assetHashes_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAssetHashes(int i, AssetHash assetHash) {
            assetHash.getClass();
            ensureAssetHashesIsMutable();
            this.assetHashes_.set(i, assetHash);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new AssetHashes();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"assetHashes_", AssetHash.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<AssetHashes> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (AssetHashes.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.AssetHashesOrBuilder
        public AssetHash getAssetHashes(int i) {
            return this.assetHashes_.get(i);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.AssetHashesOrBuilder
        public int getAssetHashesCount() {
            return this.assetHashes_.size();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.AssetHashesOrBuilder
        public List<AssetHash> getAssetHashesList() {
            return this.assetHashes_;
        }

        public AssetHashOrBuilder getAssetHashesOrBuilder(int i) {
            return this.assetHashes_.get(i);
        }

        public List<? extends AssetHashOrBuilder> getAssetHashesOrBuilderList() {
            return this.assetHashes_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAssetHashes(AssetHash assetHash) {
            assetHash.getClass();
            ensureAssetHashesIsMutable();
            this.assetHashes_.add(assetHash);
        }

        public static Builder newBuilder(AssetHashes assetHashes) {
            return DEFAULT_INSTANCE.createBuilder(assetHashes);
        }

        public static AssetHashes parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AssetHashes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AssetHashes parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (AssetHashes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AssetHashes parseFrom(CodedInputStream codedInputStream) {
            return (AssetHashes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AssetHashes parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AssetHashes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static AssetHashes parseFrom(InputStream inputStream) {
            return (AssetHashes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AssetHashes parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AssetHashes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AssetHashes parseFrom(ByteBuffer byteBuffer) {
            return (AssetHashes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static AssetHashes parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (AssetHashes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static AssetHashes parseFrom(byte[] bArr) {
            return (AssetHashes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AssetHashes parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (AssetHashes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface AssetHashesOrBuilder extends MessageLiteOrBuilder {
        AssetHash getAssetHashes(int i);

        int getAssetHashesCount();

        List<AssetHash> getAssetHashesList();
    }

    public static final class Crash extends GeneratedMessageLite<Crash, Builder> implements CrashOrBuilder {
        public static final int CRASH_ID_FIELD_NUMBER = 2;
        private static final Crash DEFAULT_INSTANCE;
        public static final int ERROR_SOURCE_FIELD_NUMBER = 4;
        private static volatile Parser<Crash> PARSER = null;
        public static final int RELATIVE_TIME_FIELD_NUMBER = 3;
        public static final int UNIX_TIMESTAMP_MS_FIELD_NUMBER = 1;
        private int bitField0_;
        private long crashId_;
        private String errorSource_ = "";
        private long relativeTime_;
        private long unixTimestampMs_;

        public static final class Builder extends GeneratedMessageLite.Builder<Crash, Builder> implements CrashOrBuilder {
            private Builder() {
                super(Crash.DEFAULT_INSTANCE);
            }

            public Builder clearCrashId() {
                copyOnWrite();
                ((Crash) this.instance).clearCrashId();
                return this;
            }

            public Builder clearErrorSource() {
                copyOnWrite();
                ((Crash) this.instance).clearErrorSource();
                return this;
            }

            public Builder clearRelativeTime() {
                copyOnWrite();
                ((Crash) this.instance).clearRelativeTime();
                return this;
            }

            public Builder clearUnixTimestampMs() {
                copyOnWrite();
                ((Crash) this.instance).clearUnixTimestampMs();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CrashOrBuilder
            public long getCrashId() {
                return ((Crash) this.instance).getCrashId();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CrashOrBuilder
            public String getErrorSource() {
                return ((Crash) this.instance).getErrorSource();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CrashOrBuilder
            public ByteString getErrorSourceBytes() {
                return ((Crash) this.instance).getErrorSourceBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CrashOrBuilder
            public long getRelativeTime() {
                return ((Crash) this.instance).getRelativeTime();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CrashOrBuilder
            public long getUnixTimestampMs() {
                return ((Crash) this.instance).getUnixTimestampMs();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CrashOrBuilder
            public boolean hasErrorSource() {
                return ((Crash) this.instance).hasErrorSource();
            }

            public Builder setCrashId(long j) {
                copyOnWrite();
                ((Crash) this.instance).setCrashId(j);
                return this;
            }

            public Builder setErrorSource(String str) {
                copyOnWrite();
                ((Crash) this.instance).setErrorSource(str);
                return this;
            }

            public Builder setErrorSourceBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((Crash) this.instance).setErrorSourceBytes(byteString);
                return this;
            }

            public Builder setRelativeTime(long j) {
                copyOnWrite();
                ((Crash) this.instance).setRelativeTime(j);
                return this;
            }

            public Builder setUnixTimestampMs(long j) {
                copyOnWrite();
                ((Crash) this.instance).setUnixTimestampMs(j);
                return this;
            }
        }

        static {
            Crash crash = new Crash();
            DEFAULT_INSTANCE = crash;
            GeneratedMessageLite.registerDefaultInstance(Crash.class, crash);
        }

        private Crash() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCrashId() {
            this.crashId_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearErrorSource() {
            this.bitField0_ &= -2;
            this.errorSource_ = getDefaultInstance().getErrorSource();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRelativeTime() {
            this.relativeTime_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnixTimestampMs() {
            this.unixTimestampMs_ = 0L;
        }

        public static Crash getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Crash parseDelimitedFrom(InputStream inputStream) {
            return (Crash) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Crash parseFrom(ByteString byteString) {
            return (Crash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<Crash> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCrashId(long j) {
            this.crashId_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrorSource(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.errorSource_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrorSourceBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.errorSource_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRelativeTime(long j) {
            this.relativeTime_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnixTimestampMs(long j) {
            this.unixTimestampMs_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new Crash();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0003\u0002\u0003\u0003\u0003\u0004ለ\u0000", new Object[]{"bitField0_", "unixTimestampMs_", "crashId_", "relativeTime_", "errorSource_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Crash> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (Crash.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CrashOrBuilder
        public long getCrashId() {
            return this.crashId_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CrashOrBuilder
        public String getErrorSource() {
            return this.errorSource_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CrashOrBuilder
        public ByteString getErrorSourceBytes() {
            return ByteString.copyFromUtf8(this.errorSource_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CrashOrBuilder
        public long getRelativeTime() {
            return this.relativeTime_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CrashOrBuilder
        public long getUnixTimestampMs() {
            return this.unixTimestampMs_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CrashOrBuilder
        public boolean hasErrorSource() {
            return (this.bitField0_ & 1) != 0;
        }

        public static Builder newBuilder(Crash crash) {
            return DEFAULT_INSTANCE.createBuilder(crash);
        }

        public static Crash parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Crash) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Crash parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Crash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Crash parseFrom(CodedInputStream codedInputStream) {
            return (Crash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Crash parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Crash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Crash parseFrom(InputStream inputStream) {
            return (Crash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Crash parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Crash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Crash parseFrom(ByteBuffer byteBuffer) {
            return (Crash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Crash parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (Crash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Crash parseFrom(byte[] bArr) {
            return (Crash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Crash parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Crash) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface CrashOrBuilder extends MessageLiteOrBuilder {
        long getCrashId();

        String getErrorSource();

        ByteString getErrorSourceBytes();

        long getRelativeTime();

        long getUnixTimestampMs();

        boolean hasErrorSource();
    }

    public static final class CustomError extends GeneratedMessageLite<CustomError, Builder> implements CustomErrorOrBuilder {
        public static final int CUSTOM_ATTRIBUTES_FIELD_NUMBER = 3;
        private static final CustomError DEFAULT_INSTANCE;
        public static final int ERROR_SOURCE_FIELD_NUMBER = 4;
        public static final int MESSAGE_FIELD_NUMBER = 1;
        private static volatile Parser<CustomError> PARSER = null;
        public static final int RELATIVE_TIME_FIELD_NUMBER = 2;
        public static final int UNIX_TIMESTAMP_MS_FIELD_NUMBER = 5;
        private int bitField0_;
        private long relativeTime_;
        private long unixTimestampMs_;
        private MapFieldLite<String, String> customAttributes_ = MapFieldLite.emptyMapField();
        private String message_ = "";
        private String errorSource_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<CustomError, Builder> implements CustomErrorOrBuilder {
            private Builder() {
                super(CustomError.DEFAULT_INSTANCE);
            }

            public Builder clearCustomAttributes() {
                copyOnWrite();
                ((CustomError) this.instance).getMutableCustomAttributesMap().clear();
                return this;
            }

            public Builder clearErrorSource() {
                copyOnWrite();
                ((CustomError) this.instance).clearErrorSource();
                return this;
            }

            public Builder clearMessage() {
                copyOnWrite();
                ((CustomError) this.instance).clearMessage();
                return this;
            }

            public Builder clearRelativeTime() {
                copyOnWrite();
                ((CustomError) this.instance).clearRelativeTime();
                return this;
            }

            public Builder clearUnixTimestampMs() {
                copyOnWrite();
                ((CustomError) this.instance).clearUnixTimestampMs();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
            public boolean containsCustomAttributes(String str) {
                str.getClass();
                return ((CustomError) this.instance).getCustomAttributesMap().containsKey(str);
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
            @Deprecated
            public Map<String, String> getCustomAttributes() {
                return getCustomAttributesMap();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
            public int getCustomAttributesCount() {
                return ((CustomError) this.instance).getCustomAttributesMap().size();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
            public Map<String, String> getCustomAttributesMap() {
                return Collections.unmodifiableMap(((CustomError) this.instance).getCustomAttributesMap());
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
            public String getCustomAttributesOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> customAttributesMap = ((CustomError) this.instance).getCustomAttributesMap();
                return customAttributesMap.containsKey(str) ? customAttributesMap.get(str) : str2;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
            public String getCustomAttributesOrThrow(String str) {
                str.getClass();
                Map<String, String> customAttributesMap = ((CustomError) this.instance).getCustomAttributesMap();
                if (customAttributesMap.containsKey(str)) {
                    return customAttributesMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
            public String getErrorSource() {
                return ((CustomError) this.instance).getErrorSource();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
            public ByteString getErrorSourceBytes() {
                return ((CustomError) this.instance).getErrorSourceBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
            public String getMessage() {
                return ((CustomError) this.instance).getMessage();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
            public ByteString getMessageBytes() {
                return ((CustomError) this.instance).getMessageBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
            public long getRelativeTime() {
                return ((CustomError) this.instance).getRelativeTime();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
            public long getUnixTimestampMs() {
                return ((CustomError) this.instance).getUnixTimestampMs();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
            public boolean hasErrorSource() {
                return ((CustomError) this.instance).hasErrorSource();
            }

            public Builder putAllCustomAttributes(Map<String, String> map) {
                copyOnWrite();
                ((CustomError) this.instance).getMutableCustomAttributesMap().putAll(map);
                return this;
            }

            public Builder putCustomAttributes(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((CustomError) this.instance).getMutableCustomAttributesMap().put(str, str2);
                return this;
            }

            public Builder removeCustomAttributes(String str) {
                str.getClass();
                copyOnWrite();
                ((CustomError) this.instance).getMutableCustomAttributesMap().remove(str);
                return this;
            }

            public Builder setErrorSource(String str) {
                copyOnWrite();
                ((CustomError) this.instance).setErrorSource(str);
                return this;
            }

            public Builder setErrorSourceBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((CustomError) this.instance).setErrorSourceBytes(byteString);
                return this;
            }

            public Builder setMessage(String str) {
                copyOnWrite();
                ((CustomError) this.instance).setMessage(str);
                return this;
            }

            public Builder setMessageBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((CustomError) this.instance).setMessageBytes(byteString);
                return this;
            }

            public Builder setRelativeTime(long j) {
                copyOnWrite();
                ((CustomError) this.instance).setRelativeTime(j);
                return this;
            }

            public Builder setUnixTimestampMs(long j) {
                copyOnWrite();
                ((CustomError) this.instance).setUnixTimestampMs(j);
                return this;
            }
        }

        public static final class CustomAttributesDefaultEntryHolder {
            static final MapEntryLite<String, String> defaultEntry;

            static {
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
            }

            private CustomAttributesDefaultEntryHolder() {
            }
        }

        static {
            CustomError customError = new CustomError();
            DEFAULT_INSTANCE = customError;
            GeneratedMessageLite.registerDefaultInstance(CustomError.class, customError);
        }

        private CustomError() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearErrorSource() {
            this.bitField0_ &= -2;
            this.errorSource_ = getDefaultInstance().getErrorSource();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMessage() {
            this.message_ = getDefaultInstance().getMessage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRelativeTime() {
            this.relativeTime_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnixTimestampMs() {
            this.unixTimestampMs_ = 0L;
        }

        public static CustomError getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableCustomAttributesMap() {
            return internalGetMutableCustomAttributes();
        }

        private MapFieldLite<String, String> internalGetCustomAttributes() {
            return this.customAttributes_;
        }

        private MapFieldLite<String, String> internalGetMutableCustomAttributes() {
            if (!this.customAttributes_.isMutable()) {
                this.customAttributes_ = this.customAttributes_.mutableCopy();
            }
            return this.customAttributes_;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static CustomError parseDelimitedFrom(InputStream inputStream) {
            return (CustomError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CustomError parseFrom(ByteString byteString) {
            return (CustomError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<CustomError> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrorSource(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.errorSource_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrorSourceBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.errorSource_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessage(String str) {
            str.getClass();
            this.message_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessageBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.message_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRelativeTime(long j) {
            this.relativeTime_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnixTimestampMs(long j) {
            this.unixTimestampMs_ = j;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
        public boolean containsCustomAttributes(String str) {
            str.getClass();
            return internalGetCustomAttributes().containsKey(str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new CustomError();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0001\u0000\u0000\u0001Ȉ\u0002\u0003\u00032\u0004ለ\u0000\u0005\u0003", new Object[]{"bitField0_", "message_", "relativeTime_", "customAttributes_", CustomAttributesDefaultEntryHolder.defaultEntry, "errorSource_", "unixTimestampMs_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<CustomError> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (CustomError.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
        @Deprecated
        public Map<String, String> getCustomAttributes() {
            return getCustomAttributesMap();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
        public int getCustomAttributesCount() {
            return internalGetCustomAttributes().size();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
        public Map<String, String> getCustomAttributesMap() {
            return Collections.unmodifiableMap(internalGetCustomAttributes());
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
        public String getCustomAttributesOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetCustomAttributes = internalGetCustomAttributes();
            return mapFieldLiteInternalGetCustomAttributes.containsKey(str) ? mapFieldLiteInternalGetCustomAttributes.get(str) : str2;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
        public String getCustomAttributesOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetCustomAttributes = internalGetCustomAttributes();
            if (mapFieldLiteInternalGetCustomAttributes.containsKey(str)) {
                return mapFieldLiteInternalGetCustomAttributes.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
        public String getErrorSource() {
            return this.errorSource_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
        public ByteString getErrorSourceBytes() {
            return ByteString.copyFromUtf8(this.errorSource_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
        public String getMessage() {
            return this.message_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
        public ByteString getMessageBytes() {
            return ByteString.copyFromUtf8(this.message_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
        public long getRelativeTime() {
            return this.relativeTime_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
        public long getUnixTimestampMs() {
            return this.unixTimestampMs_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.CustomErrorOrBuilder
        public boolean hasErrorSource() {
            return (this.bitField0_ & 1) != 0;
        }

        public static Builder newBuilder(CustomError customError) {
            return DEFAULT_INSTANCE.createBuilder(customError);
        }

        public static CustomError parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CustomError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CustomError parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (CustomError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CustomError parseFrom(CodedInputStream codedInputStream) {
            return (CustomError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CustomError parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CustomError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static CustomError parseFrom(InputStream inputStream) {
            return (CustomError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CustomError parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CustomError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CustomError parseFrom(ByteBuffer byteBuffer) {
            return (CustomError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static CustomError parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (CustomError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static CustomError parseFrom(byte[] bArr) {
            return (CustomError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CustomError parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (CustomError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface CustomErrorOrBuilder extends MessageLiteOrBuilder {
        boolean containsCustomAttributes(String str);

        @Deprecated
        Map<String, String> getCustomAttributes();

        int getCustomAttributesCount();

        Map<String, String> getCustomAttributesMap();

        String getCustomAttributesOrDefault(String str, String str2);

        String getCustomAttributesOrThrow(String str);

        String getErrorSource();

        ByteString getErrorSourceBytes();

        String getMessage();

        ByteString getMessageBytes();

        long getRelativeTime();

        long getUnixTimestampMs();

        boolean hasErrorSource();
    }

    public static final class EndOfScreenView extends GeneratedMessageLite<EndOfScreenView, Builder> implements EndOfScreenViewOrBuilder {
        private static final EndOfScreenView DEFAULT_INSTANCE;
        private static volatile Parser<EndOfScreenView> PARSER = null;
        public static final int UNIX_TIMESTAMP_MS_FIELD_NUMBER = 1;
        private long unixTimestampMs_;

        public static final class Builder extends GeneratedMessageLite.Builder<EndOfScreenView, Builder> implements EndOfScreenViewOrBuilder {
            private Builder() {
                super(EndOfScreenView.DEFAULT_INSTANCE);
            }

            public Builder clearUnixTimestampMs() {
                copyOnWrite();
                ((EndOfScreenView) this.instance).clearUnixTimestampMs();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EndOfScreenViewOrBuilder
            public long getUnixTimestampMs() {
                return ((EndOfScreenView) this.instance).getUnixTimestampMs();
            }

            public Builder setUnixTimestampMs(long j) {
                copyOnWrite();
                ((EndOfScreenView) this.instance).setUnixTimestampMs(j);
                return this;
            }
        }

        static {
            EndOfScreenView endOfScreenView = new EndOfScreenView();
            DEFAULT_INSTANCE = endOfScreenView;
            GeneratedMessageLite.registerDefaultInstance(EndOfScreenView.class, endOfScreenView);
        }

        private EndOfScreenView() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnixTimestampMs() {
            this.unixTimestampMs_ = 0L;
        }

        public static EndOfScreenView getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static EndOfScreenView parseDelimitedFrom(InputStream inputStream) {
            return (EndOfScreenView) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EndOfScreenView parseFrom(ByteString byteString) {
            return (EndOfScreenView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<EndOfScreenView> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnixTimestampMs(long j) {
            this.unixTimestampMs_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new EndOfScreenView();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0003", new Object[]{"unixTimestampMs_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EndOfScreenView> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (EndOfScreenView.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EndOfScreenViewOrBuilder
        public long getUnixTimestampMs() {
            return this.unixTimestampMs_;
        }

        public static Builder newBuilder(EndOfScreenView endOfScreenView) {
            return DEFAULT_INSTANCE.createBuilder(endOfScreenView);
        }

        public static EndOfScreenView parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EndOfScreenView) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EndOfScreenView parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (EndOfScreenView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EndOfScreenView parseFrom(CodedInputStream codedInputStream) {
            return (EndOfScreenView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EndOfScreenView parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EndOfScreenView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static EndOfScreenView parseFrom(InputStream inputStream) {
            return (EndOfScreenView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EndOfScreenView parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EndOfScreenView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EndOfScreenView parseFrom(ByteBuffer byteBuffer) {
            return (EndOfScreenView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static EndOfScreenView parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (EndOfScreenView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static EndOfScreenView parseFrom(byte[] bArr) {
            return (EndOfScreenView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static EndOfScreenView parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (EndOfScreenView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface EndOfScreenViewOrBuilder extends MessageLiteOrBuilder {
        long getUnixTimestampMs();
    }

    public static final class Etr extends GeneratedMessageLite<Etr, Builder> implements EtrOrBuilder {
        private static final Etr DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile Parser<Etr> PARSER = null;
        public static final int UNIX_TIMESTAMP_MS_FIELD_NUMBER = 2;
        private String name_ = "";
        private long unixTimestampMs_;

        public static final class Builder extends GeneratedMessageLite.Builder<Etr, Builder> implements EtrOrBuilder {
            private Builder() {
                super(Etr.DEFAULT_INSTANCE);
            }

            public Builder clearName() {
                copyOnWrite();
                ((Etr) this.instance).clearName();
                return this;
            }

            public Builder clearUnixTimestampMs() {
                copyOnWrite();
                ((Etr) this.instance).clearUnixTimestampMs();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EtrOrBuilder
            public String getName() {
                return ((Etr) this.instance).getName();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EtrOrBuilder
            public ByteString getNameBytes() {
                return ((Etr) this.instance).getNameBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EtrOrBuilder
            public long getUnixTimestampMs() {
                return ((Etr) this.instance).getUnixTimestampMs();
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((Etr) this.instance).setName(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((Etr) this.instance).setNameBytes(byteString);
                return this;
            }

            public Builder setUnixTimestampMs(long j) {
                copyOnWrite();
                ((Etr) this.instance).setUnixTimestampMs(j);
                return this;
            }
        }

        static {
            Etr etr = new Etr();
            DEFAULT_INSTANCE = etr;
            GeneratedMessageLite.registerDefaultInstance(Etr.class, etr);
        }

        private Etr() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnixTimestampMs() {
            this.unixTimestampMs_ = 0L;
        }

        public static Etr getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Etr parseDelimitedFrom(InputStream inputStream) {
            return (Etr) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Etr parseFrom(ByteString byteString) {
            return (Etr) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<Etr> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            str.getClass();
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.name_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnixTimestampMs(long j) {
            this.unixTimestampMs_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new Etr();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0003", new Object[]{"name_", "unixTimestampMs_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Etr> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (Etr.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EtrOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EtrOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EtrOrBuilder
        public long getUnixTimestampMs() {
            return this.unixTimestampMs_;
        }

        public static Builder newBuilder(Etr etr) {
            return DEFAULT_INSTANCE.createBuilder(etr);
        }

        public static Etr parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Etr) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Etr parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Etr) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Etr parseFrom(CodedInputStream codedInputStream) {
            return (Etr) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Etr parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Etr) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Etr parseFrom(InputStream inputStream) {
            return (Etr) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Etr parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Etr) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Etr parseFrom(ByteBuffer byteBuffer) {
            return (Etr) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Etr parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (Etr) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Etr parseFrom(byte[] bArr) {
            return (Etr) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Etr parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Etr) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface EtrOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();

        long getUnixTimestampMs();
    }

    public static final class Event extends GeneratedMessageLite<Event, Builder> implements EventOrBuilder {
        public static final int APP_STATE_CHANGE_FIELD_NUMBER = 7;
        public static final int ASSET_HASHES_FIELD_NUMBER = 18;
        public static final int CRASH_FIELD_NUMBER = 17;
        public static final int CUSTOM_ERROR_FIELD_NUMBER = 20;
        private static final Event DEFAULT_INSTANCE;
        public static final int END_OF_SCREEN_VIEW_FIELD_NUMBER = 9;
        public static final int ETR_SCREEN_FIELD_NUMBER = 21;
        public static final int ETR_SESSION_FIELD_NUMBER = 22;
        public static final int GESTURE_FIELD_NUMBER = 16;
        public static final int INSERTION_MUTATION_FIELD_NUMBER = 1;
        public static final int JS_ERROR_FIELD_NUMBER = 19;
        public static final int MOVE_MUTATION_FIELD_NUMBER = 3;
        public static final int NETWORK_REQUEST_METRIC_FIELD_NUMBER = 13;
        public static final int ONLINE_ASSETS_FIELD_NUMBER = 15;
        private static volatile Parser<Event> PARSER = null;
        public static final int QUALITY_SETTINGS_APPLIED_FIELD_NUMBER = 12;
        public static final int RECORDING_START_FIELD_NUMBER = 10;
        public static final int RECORDING_STOP_FIELD_NUMBER = 11;
        public static final int REMOVAL_MUTATION_FIELD_NUMBER = 2;
        public static final int SCREEN_VIEW_FIELD_NUMBER = 8;
        public static final int STYLE_MUTATION_FIELD_NUMBER = 4;
        public static final int TOUCH_GESTURE_FIELD_NUMBER = 5;
        public static final int WEBVIEW_EVENT_FIELD_NUMBER = 14;
        public static final int WINDOW_RESIZE_FIELD_NUMBER = 6;
        private int eventCase_ = 0;
        private Object event_;

        public static final class Builder extends GeneratedMessageLite.Builder<Event, Builder> implements EventOrBuilder {
            private Builder() {
                super(Event.DEFAULT_INSTANCE);
            }

            public Builder clearAppStateChange() {
                copyOnWrite();
                ((Event) this.instance).clearAppStateChange();
                return this;
            }

            public Builder clearAssetHashes() {
                copyOnWrite();
                ((Event) this.instance).clearAssetHashes();
                return this;
            }

            public Builder clearCrash() {
                copyOnWrite();
                ((Event) this.instance).clearCrash();
                return this;
            }

            public Builder clearCustomError() {
                copyOnWrite();
                ((Event) this.instance).clearCustomError();
                return this;
            }

            public Builder clearEndOfScreenView() {
                copyOnWrite();
                ((Event) this.instance).clearEndOfScreenView();
                return this;
            }

            public Builder clearEtrScreen() {
                copyOnWrite();
                ((Event) this.instance).clearEtrScreen();
                return this;
            }

            public Builder clearEtrSession() {
                copyOnWrite();
                ((Event) this.instance).clearEtrSession();
                return this;
            }

            public Builder clearEvent() {
                copyOnWrite();
                ((Event) this.instance).clearEvent();
                return this;
            }

            public Builder clearGesture() {
                copyOnWrite();
                ((Event) this.instance).clearGesture();
                return this;
            }

            public Builder clearInsertionMutation() {
                copyOnWrite();
                ((Event) this.instance).clearInsertionMutation();
                return this;
            }

            public Builder clearJsError() {
                copyOnWrite();
                ((Event) this.instance).clearJsError();
                return this;
            }

            public Builder clearMoveMutation() {
                copyOnWrite();
                ((Event) this.instance).clearMoveMutation();
                return this;
            }

            public Builder clearNetworkRequestMetric() {
                copyOnWrite();
                ((Event) this.instance).clearNetworkRequestMetric();
                return this;
            }

            public Builder clearOnlineAssets() {
                copyOnWrite();
                ((Event) this.instance).clearOnlineAssets();
                return this;
            }

            public Builder clearQualitySettingsApplied() {
                copyOnWrite();
                ((Event) this.instance).clearQualitySettingsApplied();
                return this;
            }

            public Builder clearRecordingStart() {
                copyOnWrite();
                ((Event) this.instance).clearRecordingStart();
                return this;
            }

            public Builder clearRecordingStop() {
                copyOnWrite();
                ((Event) this.instance).clearRecordingStop();
                return this;
            }

            public Builder clearRemovalMutation() {
                copyOnWrite();
                ((Event) this.instance).clearRemovalMutation();
                return this;
            }

            public Builder clearScreenView() {
                copyOnWrite();
                ((Event) this.instance).clearScreenView();
                return this;
            }

            public Builder clearStyleMutation() {
                copyOnWrite();
                ((Event) this.instance).clearStyleMutation();
                return this;
            }

            public Builder clearTouchGesture() {
                copyOnWrite();
                ((Event) this.instance).clearTouchGesture();
                return this;
            }

            public Builder clearWebviewEvent() {
                copyOnWrite();
                ((Event) this.instance).clearWebviewEvent();
                return this;
            }

            public Builder clearWindowResize() {
                copyOnWrite();
                ((Event) this.instance).clearWindowResize();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public AppStateChange getAppStateChange() {
                return ((Event) this.instance).getAppStateChange();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public AssetHashes getAssetHashes() {
                return ((Event) this.instance).getAssetHashes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public Crash getCrash() {
                return ((Event) this.instance).getCrash();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public CustomError getCustomError() {
                return ((Event) this.instance).getCustomError();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public EndOfScreenView getEndOfScreenView() {
                return ((Event) this.instance).getEndOfScreenView();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public Etr getEtrScreen() {
                return ((Event) this.instance).getEtrScreen();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public Etr getEtrSession() {
                return ((Event) this.instance).getEtrSession();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public EventCase getEventCase() {
                return ((Event) this.instance).getEventCase();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public Gesture getGesture() {
                return ((Event) this.instance).getGesture();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public InsertionMutation getInsertionMutation() {
                return ((Event) this.instance).getInsertionMutation();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public JsError getJsError() {
                return ((Event) this.instance).getJsError();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public MoveMutation getMoveMutation() {
                return ((Event) this.instance).getMoveMutation();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public NetworkRequestMetric getNetworkRequestMetric() {
                return ((Event) this.instance).getNetworkRequestMetric();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public OnlineAssets getOnlineAssets() {
                return ((Event) this.instance).getOnlineAssets();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public QualitySettingsApplied getQualitySettingsApplied() {
                return ((Event) this.instance).getQualitySettingsApplied();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public RecordingStart getRecordingStart() {
                return ((Event) this.instance).getRecordingStart();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public RecordingStop getRecordingStop() {
                return ((Event) this.instance).getRecordingStop();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public RemovalMutation getRemovalMutation() {
                return ((Event) this.instance).getRemovalMutation();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public ScreenView getScreenView() {
                return ((Event) this.instance).getScreenView();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public StyleMutation getStyleMutation() {
                return ((Event) this.instance).getStyleMutation();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public TouchGesture getTouchGesture() {
                return ((Event) this.instance).getTouchGesture();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public WebviewEvent getWebviewEvent() {
                return ((Event) this.instance).getWebviewEvent();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public WindowResize getWindowResize() {
                return ((Event) this.instance).getWindowResize();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasAppStateChange() {
                return ((Event) this.instance).hasAppStateChange();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasAssetHashes() {
                return ((Event) this.instance).hasAssetHashes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasCrash() {
                return ((Event) this.instance).hasCrash();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasCustomError() {
                return ((Event) this.instance).hasCustomError();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasEndOfScreenView() {
                return ((Event) this.instance).hasEndOfScreenView();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasEtrScreen() {
                return ((Event) this.instance).hasEtrScreen();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasEtrSession() {
                return ((Event) this.instance).hasEtrSession();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasGesture() {
                return ((Event) this.instance).hasGesture();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasInsertionMutation() {
                return ((Event) this.instance).hasInsertionMutation();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasJsError() {
                return ((Event) this.instance).hasJsError();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasMoveMutation() {
                return ((Event) this.instance).hasMoveMutation();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasNetworkRequestMetric() {
                return ((Event) this.instance).hasNetworkRequestMetric();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasOnlineAssets() {
                return ((Event) this.instance).hasOnlineAssets();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasQualitySettingsApplied() {
                return ((Event) this.instance).hasQualitySettingsApplied();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasRecordingStart() {
                return ((Event) this.instance).hasRecordingStart();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasRecordingStop() {
                return ((Event) this.instance).hasRecordingStop();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasRemovalMutation() {
                return ((Event) this.instance).hasRemovalMutation();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasScreenView() {
                return ((Event) this.instance).hasScreenView();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasStyleMutation() {
                return ((Event) this.instance).hasStyleMutation();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasTouchGesture() {
                return ((Event) this.instance).hasTouchGesture();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasWebviewEvent() {
                return ((Event) this.instance).hasWebviewEvent();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
            public boolean hasWindowResize() {
                return ((Event) this.instance).hasWindowResize();
            }

            public Builder mergeAppStateChange(AppStateChange appStateChange) {
                copyOnWrite();
                ((Event) this.instance).mergeAppStateChange(appStateChange);
                return this;
            }

            public Builder mergeAssetHashes(AssetHashes assetHashes) {
                copyOnWrite();
                ((Event) this.instance).mergeAssetHashes(assetHashes);
                return this;
            }

            public Builder mergeCrash(Crash crash) {
                copyOnWrite();
                ((Event) this.instance).mergeCrash(crash);
                return this;
            }

            public Builder mergeCustomError(CustomError customError) {
                copyOnWrite();
                ((Event) this.instance).mergeCustomError(customError);
                return this;
            }

            public Builder mergeEndOfScreenView(EndOfScreenView endOfScreenView) {
                copyOnWrite();
                ((Event) this.instance).mergeEndOfScreenView(endOfScreenView);
                return this;
            }

            public Builder mergeEtrScreen(Etr etr) {
                copyOnWrite();
                ((Event) this.instance).mergeEtrScreen(etr);
                return this;
            }

            public Builder mergeEtrSession(Etr etr) {
                copyOnWrite();
                ((Event) this.instance).mergeEtrSession(etr);
                return this;
            }

            public Builder mergeGesture(Gesture gesture) {
                copyOnWrite();
                ((Event) this.instance).mergeGesture(gesture);
                return this;
            }

            public Builder mergeInsertionMutation(InsertionMutation insertionMutation) {
                copyOnWrite();
                ((Event) this.instance).mergeInsertionMutation(insertionMutation);
                return this;
            }

            public Builder mergeJsError(JsError jsError) {
                copyOnWrite();
                ((Event) this.instance).mergeJsError(jsError);
                return this;
            }

            public Builder mergeMoveMutation(MoveMutation moveMutation) {
                copyOnWrite();
                ((Event) this.instance).mergeMoveMutation(moveMutation);
                return this;
            }

            public Builder mergeNetworkRequestMetric(NetworkRequestMetric networkRequestMetric) {
                copyOnWrite();
                ((Event) this.instance).mergeNetworkRequestMetric(networkRequestMetric);
                return this;
            }

            public Builder mergeOnlineAssets(OnlineAssets onlineAssets) {
                copyOnWrite();
                ((Event) this.instance).mergeOnlineAssets(onlineAssets);
                return this;
            }

            public Builder mergeQualitySettingsApplied(QualitySettingsApplied qualitySettingsApplied) {
                copyOnWrite();
                ((Event) this.instance).mergeQualitySettingsApplied(qualitySettingsApplied);
                return this;
            }

            public Builder mergeRecordingStart(RecordingStart recordingStart) {
                copyOnWrite();
                ((Event) this.instance).mergeRecordingStart(recordingStart);
                return this;
            }

            public Builder mergeRecordingStop(RecordingStop recordingStop) {
                copyOnWrite();
                ((Event) this.instance).mergeRecordingStop(recordingStop);
                return this;
            }

            public Builder mergeRemovalMutation(RemovalMutation removalMutation) {
                copyOnWrite();
                ((Event) this.instance).mergeRemovalMutation(removalMutation);
                return this;
            }

            public Builder mergeScreenView(ScreenView screenView) {
                copyOnWrite();
                ((Event) this.instance).mergeScreenView(screenView);
                return this;
            }

            public Builder mergeStyleMutation(StyleMutation styleMutation) {
                copyOnWrite();
                ((Event) this.instance).mergeStyleMutation(styleMutation);
                return this;
            }

            public Builder mergeTouchGesture(TouchGesture touchGesture) {
                copyOnWrite();
                ((Event) this.instance).mergeTouchGesture(touchGesture);
                return this;
            }

            public Builder mergeWebviewEvent(WebviewEvent webviewEvent) {
                copyOnWrite();
                ((Event) this.instance).mergeWebviewEvent(webviewEvent);
                return this;
            }

            public Builder mergeWindowResize(WindowResize windowResize) {
                copyOnWrite();
                ((Event) this.instance).mergeWindowResize(windowResize);
                return this;
            }

            public Builder setAppStateChange(AppStateChange.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setAppStateChange(builder.build());
                return this;
            }

            public Builder setAssetHashes(AssetHashes.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setAssetHashes(builder.build());
                return this;
            }

            public Builder setCrash(Crash.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setCrash(builder.build());
                return this;
            }

            public Builder setCustomError(CustomError.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setCustomError(builder.build());
                return this;
            }

            public Builder setEndOfScreenView(EndOfScreenView.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setEndOfScreenView(builder.build());
                return this;
            }

            public Builder setEtrScreen(Etr.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setEtrScreen(builder.build());
                return this;
            }

            public Builder setEtrSession(Etr.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setEtrSession(builder.build());
                return this;
            }

            public Builder setGesture(Gesture.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setGesture(builder.build());
                return this;
            }

            public Builder setInsertionMutation(InsertionMutation.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setInsertionMutation(builder.build());
                return this;
            }

            public Builder setJsError(JsError.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setJsError(builder.build());
                return this;
            }

            public Builder setMoveMutation(MoveMutation.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setMoveMutation(builder.build());
                return this;
            }

            public Builder setNetworkRequestMetric(NetworkRequestMetric.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setNetworkRequestMetric(builder.build());
                return this;
            }

            public Builder setOnlineAssets(OnlineAssets.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setOnlineAssets(builder.build());
                return this;
            }

            public Builder setQualitySettingsApplied(QualitySettingsApplied.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setQualitySettingsApplied(builder.build());
                return this;
            }

            public Builder setRecordingStart(RecordingStart.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setRecordingStart(builder.build());
                return this;
            }

            public Builder setRecordingStop(RecordingStop.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setRecordingStop(builder.build());
                return this;
            }

            public Builder setRemovalMutation(RemovalMutation.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setRemovalMutation(builder.build());
                return this;
            }

            public Builder setScreenView(ScreenView.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setScreenView(builder.build());
                return this;
            }

            public Builder setStyleMutation(StyleMutation.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setStyleMutation(builder.build());
                return this;
            }

            public Builder setTouchGesture(TouchGesture.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setTouchGesture(builder.build());
                return this;
            }

            public Builder setWebviewEvent(WebviewEvent.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setWebviewEvent(builder.build());
                return this;
            }

            public Builder setWindowResize(WindowResize.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setWindowResize(builder.build());
                return this;
            }

            public Builder setAppStateChange(AppStateChange appStateChange) {
                copyOnWrite();
                ((Event) this.instance).setAppStateChange(appStateChange);
                return this;
            }

            public Builder setAssetHashes(AssetHashes assetHashes) {
                copyOnWrite();
                ((Event) this.instance).setAssetHashes(assetHashes);
                return this;
            }

            public Builder setCrash(Crash crash) {
                copyOnWrite();
                ((Event) this.instance).setCrash(crash);
                return this;
            }

            public Builder setCustomError(CustomError customError) {
                copyOnWrite();
                ((Event) this.instance).setCustomError(customError);
                return this;
            }

            public Builder setEndOfScreenView(EndOfScreenView endOfScreenView) {
                copyOnWrite();
                ((Event) this.instance).setEndOfScreenView(endOfScreenView);
                return this;
            }

            public Builder setEtrScreen(Etr etr) {
                copyOnWrite();
                ((Event) this.instance).setEtrScreen(etr);
                return this;
            }

            public Builder setEtrSession(Etr etr) {
                copyOnWrite();
                ((Event) this.instance).setEtrSession(etr);
                return this;
            }

            public Builder setGesture(Gesture gesture) {
                copyOnWrite();
                ((Event) this.instance).setGesture(gesture);
                return this;
            }

            public Builder setInsertionMutation(InsertionMutation insertionMutation) {
                copyOnWrite();
                ((Event) this.instance).setInsertionMutation(insertionMutation);
                return this;
            }

            public Builder setJsError(JsError jsError) {
                copyOnWrite();
                ((Event) this.instance).setJsError(jsError);
                return this;
            }

            public Builder setMoveMutation(MoveMutation moveMutation) {
                copyOnWrite();
                ((Event) this.instance).setMoveMutation(moveMutation);
                return this;
            }

            public Builder setNetworkRequestMetric(NetworkRequestMetric networkRequestMetric) {
                copyOnWrite();
                ((Event) this.instance).setNetworkRequestMetric(networkRequestMetric);
                return this;
            }

            public Builder setOnlineAssets(OnlineAssets onlineAssets) {
                copyOnWrite();
                ((Event) this.instance).setOnlineAssets(onlineAssets);
                return this;
            }

            public Builder setQualitySettingsApplied(QualitySettingsApplied qualitySettingsApplied) {
                copyOnWrite();
                ((Event) this.instance).setQualitySettingsApplied(qualitySettingsApplied);
                return this;
            }

            public Builder setRecordingStart(RecordingStart recordingStart) {
                copyOnWrite();
                ((Event) this.instance).setRecordingStart(recordingStart);
                return this;
            }

            public Builder setRecordingStop(RecordingStop recordingStop) {
                copyOnWrite();
                ((Event) this.instance).setRecordingStop(recordingStop);
                return this;
            }

            public Builder setRemovalMutation(RemovalMutation removalMutation) {
                copyOnWrite();
                ((Event) this.instance).setRemovalMutation(removalMutation);
                return this;
            }

            public Builder setScreenView(ScreenView screenView) {
                copyOnWrite();
                ((Event) this.instance).setScreenView(screenView);
                return this;
            }

            public Builder setStyleMutation(StyleMutation styleMutation) {
                copyOnWrite();
                ((Event) this.instance).setStyleMutation(styleMutation);
                return this;
            }

            public Builder setTouchGesture(TouchGesture touchGesture) {
                copyOnWrite();
                ((Event) this.instance).setTouchGesture(touchGesture);
                return this;
            }

            public Builder setWebviewEvent(WebviewEvent webviewEvent) {
                copyOnWrite();
                ((Event) this.instance).setWebviewEvent(webviewEvent);
                return this;
            }

            public Builder setWindowResize(WindowResize windowResize) {
                copyOnWrite();
                ((Event) this.instance).setWindowResize(windowResize);
                return this;
            }
        }

        public enum EventCase {
            INSERTION_MUTATION(1),
            REMOVAL_MUTATION(2),
            MOVE_MUTATION(3),
            STYLE_MUTATION(4),
            TOUCH_GESTURE(5),
            WINDOW_RESIZE(6),
            APP_STATE_CHANGE(7),
            SCREEN_VIEW(8),
            END_OF_SCREEN_VIEW(9),
            RECORDING_START(10),
            RECORDING_STOP(11),
            QUALITY_SETTINGS_APPLIED(12),
            NETWORK_REQUEST_METRIC(13),
            WEBVIEW_EVENT(14),
            ONLINE_ASSETS(15),
            GESTURE(16),
            CRASH(17),
            ASSET_HASHES(18),
            JS_ERROR(19),
            CUSTOM_ERROR(20),
            ETR_SCREEN(21),
            ETR_SESSION(22),
            EVENT_NOT_SET(0);

            private final int value;

            EventCase(int i) {
                this.value = i;
            }

            public static EventCase forNumber(int i) {
                switch (i) {
                    case 0:
                        return EVENT_NOT_SET;
                    case 1:
                        return INSERTION_MUTATION;
                    case 2:
                        return REMOVAL_MUTATION;
                    case 3:
                        return MOVE_MUTATION;
                    case 4:
                        return STYLE_MUTATION;
                    case 5:
                        return TOUCH_GESTURE;
                    case 6:
                        return WINDOW_RESIZE;
                    case 7:
                        return APP_STATE_CHANGE;
                    case 8:
                        return SCREEN_VIEW;
                    case 9:
                        return END_OF_SCREEN_VIEW;
                    case 10:
                        return RECORDING_START;
                    case 11:
                        return RECORDING_STOP;
                    case 12:
                        return QUALITY_SETTINGS_APPLIED;
                    case 13:
                        return NETWORK_REQUEST_METRIC;
                    case 14:
                        return WEBVIEW_EVENT;
                    case 15:
                        return ONLINE_ASSETS;
                    case 16:
                        return GESTURE;
                    case 17:
                        return CRASH;
                    case 18:
                        return ASSET_HASHES;
                    case 19:
                        return JS_ERROR;
                    case 20:
                        return CUSTOM_ERROR;
                    case 21:
                        return ETR_SCREEN;
                    case 22:
                        return ETR_SESSION;
                    default:
                        return null;
                }
            }

            @Deprecated
            public static EventCase valueOf(int i) {
                return forNumber(i);
            }

            public int getNumber() {
                return this.value;
            }
        }

        static {
            Event event = new Event();
            DEFAULT_INSTANCE = event;
            GeneratedMessageLite.registerDefaultInstance(Event.class, event);
        }

        private Event() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppStateChange() {
            if (this.eventCase_ == 7) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAssetHashes() {
            if (this.eventCase_ == 18) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCrash() {
            if (this.eventCase_ == 17) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCustomError() {
            if (this.eventCase_ == 20) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEndOfScreenView() {
            if (this.eventCase_ == 9) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEtrScreen() {
            if (this.eventCase_ == 21) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEtrSession() {
            if (this.eventCase_ == 22) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEvent() {
            this.eventCase_ = 0;
            this.event_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGesture() {
            if (this.eventCase_ == 16) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInsertionMutation() {
            if (this.eventCase_ == 1) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearJsError() {
            if (this.eventCase_ == 19) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMoveMutation() {
            if (this.eventCase_ == 3) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNetworkRequestMetric() {
            if (this.eventCase_ == 13) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOnlineAssets() {
            if (this.eventCase_ == 15) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearQualitySettingsApplied() {
            if (this.eventCase_ == 12) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRecordingStart() {
            if (this.eventCase_ == 10) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRecordingStop() {
            if (this.eventCase_ == 11) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemovalMutation() {
            if (this.eventCase_ == 2) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearScreenView() {
            if (this.eventCase_ == 8) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStyleMutation() {
            if (this.eventCase_ == 4) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTouchGesture() {
            if (this.eventCase_ == 5) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWebviewEvent() {
            if (this.eventCase_ == 14) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWindowResize() {
            if (this.eventCase_ == 6) {
                this.eventCase_ = 0;
                this.event_ = null;
            }
        }

        public static Event getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAppStateChange(AppStateChange appStateChange) {
            appStateChange.getClass();
            if (this.eventCase_ == 7 && this.event_ != AppStateChange.getDefaultInstance()) {
                appStateChange = AppStateChange.newBuilder((AppStateChange) this.event_).mergeFrom((AppStateChange.Builder) appStateChange).buildPartial();
            }
            this.event_ = appStateChange;
            this.eventCase_ = 7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAssetHashes(AssetHashes assetHashes) {
            assetHashes.getClass();
            if (this.eventCase_ == 18 && this.event_ != AssetHashes.getDefaultInstance()) {
                assetHashes = AssetHashes.newBuilder((AssetHashes) this.event_).mergeFrom((AssetHashes.Builder) assetHashes).buildPartial();
            }
            this.event_ = assetHashes;
            this.eventCase_ = 18;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeCrash(Crash crash) {
            crash.getClass();
            if (this.eventCase_ == 17 && this.event_ != Crash.getDefaultInstance()) {
                crash = Crash.newBuilder((Crash) this.event_).mergeFrom((Crash.Builder) crash).buildPartial();
            }
            this.event_ = crash;
            this.eventCase_ = 17;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeCustomError(CustomError customError) {
            customError.getClass();
            if (this.eventCase_ == 20 && this.event_ != CustomError.getDefaultInstance()) {
                customError = CustomError.newBuilder((CustomError) this.event_).mergeFrom((CustomError.Builder) customError).buildPartial();
            }
            this.event_ = customError;
            this.eventCase_ = 20;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeEndOfScreenView(EndOfScreenView endOfScreenView) {
            endOfScreenView.getClass();
            if (this.eventCase_ == 9 && this.event_ != EndOfScreenView.getDefaultInstance()) {
                endOfScreenView = EndOfScreenView.newBuilder((EndOfScreenView) this.event_).mergeFrom((EndOfScreenView.Builder) endOfScreenView).buildPartial();
            }
            this.event_ = endOfScreenView;
            this.eventCase_ = 9;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeEtrScreen(Etr etr) {
            etr.getClass();
            if (this.eventCase_ == 21 && this.event_ != Etr.getDefaultInstance()) {
                etr = Etr.newBuilder((Etr) this.event_).mergeFrom((Etr.Builder) etr).buildPartial();
            }
            this.event_ = etr;
            this.eventCase_ = 21;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeEtrSession(Etr etr) {
            etr.getClass();
            if (this.eventCase_ == 22 && this.event_ != Etr.getDefaultInstance()) {
                etr = Etr.newBuilder((Etr) this.event_).mergeFrom((Etr.Builder) etr).buildPartial();
            }
            this.event_ = etr;
            this.eventCase_ = 22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeGesture(Gesture gesture) {
            gesture.getClass();
            if (this.eventCase_ == 16 && this.event_ != Gesture.getDefaultInstance()) {
                gesture = Gesture.newBuilder((Gesture) this.event_).mergeFrom((Gesture.Builder) gesture).buildPartial();
            }
            this.event_ = gesture;
            this.eventCase_ = 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeInsertionMutation(InsertionMutation insertionMutation) {
            insertionMutation.getClass();
            if (this.eventCase_ == 1 && this.event_ != InsertionMutation.getDefaultInstance()) {
                insertionMutation = InsertionMutation.newBuilder((InsertionMutation) this.event_).mergeFrom((InsertionMutation.Builder) insertionMutation).buildPartial();
            }
            this.event_ = insertionMutation;
            this.eventCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeJsError(JsError jsError) {
            jsError.getClass();
            if (this.eventCase_ == 19 && this.event_ != JsError.getDefaultInstance()) {
                jsError = JsError.newBuilder((JsError) this.event_).mergeFrom((JsError.Builder) jsError).buildPartial();
            }
            this.event_ = jsError;
            this.eventCase_ = 19;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeMoveMutation(MoveMutation moveMutation) {
            moveMutation.getClass();
            if (this.eventCase_ == 3 && this.event_ != MoveMutation.getDefaultInstance()) {
                moveMutation = MoveMutation.newBuilder((MoveMutation) this.event_).mergeFrom((MoveMutation.Builder) moveMutation).buildPartial();
            }
            this.event_ = moveMutation;
            this.eventCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeNetworkRequestMetric(NetworkRequestMetric networkRequestMetric) {
            networkRequestMetric.getClass();
            if (this.eventCase_ == 13 && this.event_ != NetworkRequestMetric.getDefaultInstance()) {
                networkRequestMetric = NetworkRequestMetric.newBuilder((NetworkRequestMetric) this.event_).mergeFrom((NetworkRequestMetric.Builder) networkRequestMetric).buildPartial();
            }
            this.event_ = networkRequestMetric;
            this.eventCase_ = 13;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeOnlineAssets(OnlineAssets onlineAssets) {
            onlineAssets.getClass();
            if (this.eventCase_ == 15 && this.event_ != OnlineAssets.getDefaultInstance()) {
                onlineAssets = OnlineAssets.newBuilder((OnlineAssets) this.event_).mergeFrom((OnlineAssets.Builder) onlineAssets).buildPartial();
            }
            this.event_ = onlineAssets;
            this.eventCase_ = 15;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeQualitySettingsApplied(QualitySettingsApplied qualitySettingsApplied) {
            qualitySettingsApplied.getClass();
            if (this.eventCase_ == 12 && this.event_ != QualitySettingsApplied.getDefaultInstance()) {
                qualitySettingsApplied = QualitySettingsApplied.newBuilder((QualitySettingsApplied) this.event_).mergeFrom((QualitySettingsApplied.Builder) qualitySettingsApplied).buildPartial();
            }
            this.event_ = qualitySettingsApplied;
            this.eventCase_ = 12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeRecordingStart(RecordingStart recordingStart) {
            recordingStart.getClass();
            if (this.eventCase_ == 10 && this.event_ != RecordingStart.getDefaultInstance()) {
                recordingStart = RecordingStart.newBuilder((RecordingStart) this.event_).mergeFrom((RecordingStart.Builder) recordingStart).buildPartial();
            }
            this.event_ = recordingStart;
            this.eventCase_ = 10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeRecordingStop(RecordingStop recordingStop) {
            recordingStop.getClass();
            if (this.eventCase_ == 11 && this.event_ != RecordingStop.getDefaultInstance()) {
                recordingStop = RecordingStop.newBuilder((RecordingStop) this.event_).mergeFrom((RecordingStop.Builder) recordingStop).buildPartial();
            }
            this.event_ = recordingStop;
            this.eventCase_ = 11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeRemovalMutation(RemovalMutation removalMutation) {
            removalMutation.getClass();
            if (this.eventCase_ == 2 && this.event_ != RemovalMutation.getDefaultInstance()) {
                removalMutation = RemovalMutation.newBuilder((RemovalMutation) this.event_).mergeFrom((RemovalMutation.Builder) removalMutation).buildPartial();
            }
            this.event_ = removalMutation;
            this.eventCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeScreenView(ScreenView screenView) {
            screenView.getClass();
            if (this.eventCase_ == 8 && this.event_ != ScreenView.getDefaultInstance()) {
                screenView = ScreenView.newBuilder((ScreenView) this.event_).mergeFrom((ScreenView.Builder) screenView).buildPartial();
            }
            this.event_ = screenView;
            this.eventCase_ = 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeStyleMutation(StyleMutation styleMutation) {
            styleMutation.getClass();
            if (this.eventCase_ == 4 && this.event_ != StyleMutation.getDefaultInstance()) {
                styleMutation = StyleMutation.newBuilder((StyleMutation) this.event_).mergeFrom((StyleMutation.Builder) styleMutation).buildPartial();
            }
            this.event_ = styleMutation;
            this.eventCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTouchGesture(TouchGesture touchGesture) {
            touchGesture.getClass();
            if (this.eventCase_ == 5 && this.event_ != TouchGesture.getDefaultInstance()) {
                touchGesture = TouchGesture.newBuilder((TouchGesture) this.event_).mergeFrom((TouchGesture.Builder) touchGesture).buildPartial();
            }
            this.event_ = touchGesture;
            this.eventCase_ = 5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeWebviewEvent(WebviewEvent webviewEvent) {
            webviewEvent.getClass();
            if (this.eventCase_ == 14 && this.event_ != WebviewEvent.getDefaultInstance()) {
                webviewEvent = WebviewEvent.newBuilder((WebviewEvent) this.event_).mergeFrom((WebviewEvent.Builder) webviewEvent).buildPartial();
            }
            this.event_ = webviewEvent;
            this.eventCase_ = 14;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeWindowResize(WindowResize windowResize) {
            windowResize.getClass();
            if (this.eventCase_ == 6 && this.event_ != WindowResize.getDefaultInstance()) {
                windowResize = WindowResize.newBuilder((WindowResize) this.event_).mergeFrom((WindowResize.Builder) windowResize).buildPartial();
            }
            this.event_ = windowResize;
            this.eventCase_ = 6;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Event parseDelimitedFrom(InputStream inputStream) {
            return (Event) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Event parseFrom(ByteString byteString) {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<Event> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppStateChange(AppStateChange appStateChange) {
            appStateChange.getClass();
            this.event_ = appStateChange;
            this.eventCase_ = 7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAssetHashes(AssetHashes assetHashes) {
            assetHashes.getClass();
            this.event_ = assetHashes;
            this.eventCase_ = 18;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCrash(Crash crash) {
            crash.getClass();
            this.event_ = crash;
            this.eventCase_ = 17;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCustomError(CustomError customError) {
            customError.getClass();
            this.event_ = customError;
            this.eventCase_ = 20;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndOfScreenView(EndOfScreenView endOfScreenView) {
            endOfScreenView.getClass();
            this.event_ = endOfScreenView;
            this.eventCase_ = 9;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEtrScreen(Etr etr) {
            etr.getClass();
            this.event_ = etr;
            this.eventCase_ = 21;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEtrSession(Etr etr) {
            etr.getClass();
            this.event_ = etr;
            this.eventCase_ = 22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGesture(Gesture gesture) {
            gesture.getClass();
            this.event_ = gesture;
            this.eventCase_ = 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInsertionMutation(InsertionMutation insertionMutation) {
            insertionMutation.getClass();
            this.event_ = insertionMutation;
            this.eventCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setJsError(JsError jsError) {
            jsError.getClass();
            this.event_ = jsError;
            this.eventCase_ = 19;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMoveMutation(MoveMutation moveMutation) {
            moveMutation.getClass();
            this.event_ = moveMutation;
            this.eventCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNetworkRequestMetric(NetworkRequestMetric networkRequestMetric) {
            networkRequestMetric.getClass();
            this.event_ = networkRequestMetric;
            this.eventCase_ = 13;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOnlineAssets(OnlineAssets onlineAssets) {
            onlineAssets.getClass();
            this.event_ = onlineAssets;
            this.eventCase_ = 15;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setQualitySettingsApplied(QualitySettingsApplied qualitySettingsApplied) {
            qualitySettingsApplied.getClass();
            this.event_ = qualitySettingsApplied;
            this.eventCase_ = 12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRecordingStart(RecordingStart recordingStart) {
            recordingStart.getClass();
            this.event_ = recordingStart;
            this.eventCase_ = 10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRecordingStop(RecordingStop recordingStop) {
            recordingStop.getClass();
            this.event_ = recordingStop;
            this.eventCase_ = 11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemovalMutation(RemovalMutation removalMutation) {
            removalMutation.getClass();
            this.event_ = removalMutation;
            this.eventCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setScreenView(ScreenView screenView) {
            screenView.getClass();
            this.event_ = screenView;
            this.eventCase_ = 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStyleMutation(StyleMutation styleMutation) {
            styleMutation.getClass();
            this.event_ = styleMutation;
            this.eventCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTouchGesture(TouchGesture touchGesture) {
            touchGesture.getClass();
            this.event_ = touchGesture;
            this.eventCase_ = 5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWebviewEvent(WebviewEvent webviewEvent) {
            webviewEvent.getClass();
            this.event_ = webviewEvent;
            this.eventCase_ = 14;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWindowResize(WindowResize windowResize) {
            windowResize.getClass();
            this.event_ = windowResize;
            this.eventCase_ = 6;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Event();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0016\u0001\u0000\u0001\u0016\u0016\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\t<\u0000\n<\u0000\u000b<\u0000\f<\u0000\r<\u0000\u000e<\u0000\u000f<\u0000\u0010<\u0000\u0011<\u0000\u0012<\u0000\u0013<\u0000\u0014<\u0000\u0015<\u0000\u0016<\u0000", new Object[]{"event_", "eventCase_", InsertionMutation.class, RemovalMutation.class, MoveMutation.class, StyleMutation.class, TouchGesture.class, WindowResize.class, AppStateChange.class, ScreenView.class, EndOfScreenView.class, RecordingStart.class, RecordingStop.class, QualitySettingsApplied.class, NetworkRequestMetric.class, WebviewEvent.class, OnlineAssets.class, Gesture.class, Crash.class, AssetHashes.class, JsError.class, CustomError.class, Etr.class, Etr.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Event> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (Event.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public AppStateChange getAppStateChange() {
            return this.eventCase_ == 7 ? (AppStateChange) this.event_ : AppStateChange.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public AssetHashes getAssetHashes() {
            return this.eventCase_ == 18 ? (AssetHashes) this.event_ : AssetHashes.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public Crash getCrash() {
            return this.eventCase_ == 17 ? (Crash) this.event_ : Crash.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public CustomError getCustomError() {
            return this.eventCase_ == 20 ? (CustomError) this.event_ : CustomError.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public EndOfScreenView getEndOfScreenView() {
            return this.eventCase_ == 9 ? (EndOfScreenView) this.event_ : EndOfScreenView.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public Etr getEtrScreen() {
            return this.eventCase_ == 21 ? (Etr) this.event_ : Etr.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public Etr getEtrSession() {
            return this.eventCase_ == 22 ? (Etr) this.event_ : Etr.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public EventCase getEventCase() {
            return EventCase.forNumber(this.eventCase_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public Gesture getGesture() {
            return this.eventCase_ == 16 ? (Gesture) this.event_ : Gesture.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public InsertionMutation getInsertionMutation() {
            return this.eventCase_ == 1 ? (InsertionMutation) this.event_ : InsertionMutation.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public JsError getJsError() {
            return this.eventCase_ == 19 ? (JsError) this.event_ : JsError.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public MoveMutation getMoveMutation() {
            return this.eventCase_ == 3 ? (MoveMutation) this.event_ : MoveMutation.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public NetworkRequestMetric getNetworkRequestMetric() {
            return this.eventCase_ == 13 ? (NetworkRequestMetric) this.event_ : NetworkRequestMetric.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public OnlineAssets getOnlineAssets() {
            return this.eventCase_ == 15 ? (OnlineAssets) this.event_ : OnlineAssets.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public QualitySettingsApplied getQualitySettingsApplied() {
            return this.eventCase_ == 12 ? (QualitySettingsApplied) this.event_ : QualitySettingsApplied.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public RecordingStart getRecordingStart() {
            return this.eventCase_ == 10 ? (RecordingStart) this.event_ : RecordingStart.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public RecordingStop getRecordingStop() {
            return this.eventCase_ == 11 ? (RecordingStop) this.event_ : RecordingStop.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public RemovalMutation getRemovalMutation() {
            return this.eventCase_ == 2 ? (RemovalMutation) this.event_ : RemovalMutation.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public ScreenView getScreenView() {
            return this.eventCase_ == 8 ? (ScreenView) this.event_ : ScreenView.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public StyleMutation getStyleMutation() {
            return this.eventCase_ == 4 ? (StyleMutation) this.event_ : StyleMutation.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public TouchGesture getTouchGesture() {
            return this.eventCase_ == 5 ? (TouchGesture) this.event_ : TouchGesture.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public WebviewEvent getWebviewEvent() {
            return this.eventCase_ == 14 ? (WebviewEvent) this.event_ : WebviewEvent.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public WindowResize getWindowResize() {
            return this.eventCase_ == 6 ? (WindowResize) this.event_ : WindowResize.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasAppStateChange() {
            return this.eventCase_ == 7;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasAssetHashes() {
            return this.eventCase_ == 18;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasCrash() {
            return this.eventCase_ == 17;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasCustomError() {
            return this.eventCase_ == 20;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasEndOfScreenView() {
            return this.eventCase_ == 9;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasEtrScreen() {
            return this.eventCase_ == 21;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasEtrSession() {
            return this.eventCase_ == 22;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasGesture() {
            return this.eventCase_ == 16;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasInsertionMutation() {
            return this.eventCase_ == 1;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasJsError() {
            return this.eventCase_ == 19;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasMoveMutation() {
            return this.eventCase_ == 3;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasNetworkRequestMetric() {
            return this.eventCase_ == 13;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasOnlineAssets() {
            return this.eventCase_ == 15;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasQualitySettingsApplied() {
            return this.eventCase_ == 12;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasRecordingStart() {
            return this.eventCase_ == 10;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasRecordingStop() {
            return this.eventCase_ == 11;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasRemovalMutation() {
            return this.eventCase_ == 2;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasScreenView() {
            return this.eventCase_ == 8;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasStyleMutation() {
            return this.eventCase_ == 4;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasTouchGesture() {
            return this.eventCase_ == 5;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasWebviewEvent() {
            return this.eventCase_ == 14;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventOrBuilder
        public boolean hasWindowResize() {
            return this.eventCase_ == 6;
        }

        public static Builder newBuilder(Event event) {
            return DEFAULT_INSTANCE.createBuilder(event);
        }

        public static Event parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Event) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Event parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Event parseFrom(CodedInputStream codedInputStream) {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Event parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Event parseFrom(InputStream inputStream) {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Event parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Event parseFrom(ByteBuffer byteBuffer) {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Event parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Event parseFrom(byte[] bArr) {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Event parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface EventOrBuilder extends MessageLiteOrBuilder {
        AppStateChange getAppStateChange();

        AssetHashes getAssetHashes();

        Crash getCrash();

        CustomError getCustomError();

        EndOfScreenView getEndOfScreenView();

        Etr getEtrScreen();

        Etr getEtrSession();

        Event.EventCase getEventCase();

        Gesture getGesture();

        InsertionMutation getInsertionMutation();

        JsError getJsError();

        MoveMutation getMoveMutation();

        NetworkRequestMetric getNetworkRequestMetric();

        OnlineAssets getOnlineAssets();

        QualitySettingsApplied getQualitySettingsApplied();

        RecordingStart getRecordingStart();

        RecordingStop getRecordingStop();

        RemovalMutation getRemovalMutation();

        ScreenView getScreenView();

        StyleMutation getStyleMutation();

        TouchGesture getTouchGesture();

        WebviewEvent getWebviewEvent();

        WindowResize getWindowResize();

        boolean hasAppStateChange();

        boolean hasAssetHashes();

        boolean hasCrash();

        boolean hasCustomError();

        boolean hasEndOfScreenView();

        boolean hasEtrScreen();

        boolean hasEtrSession();

        boolean hasGesture();

        boolean hasInsertionMutation();

        boolean hasJsError();

        boolean hasMoveMutation();

        boolean hasNetworkRequestMetric();

        boolean hasOnlineAssets();

        boolean hasQualitySettingsApplied();

        boolean hasRecordingStart();

        boolean hasRecordingStop();

        boolean hasRemovalMutation();

        boolean hasScreenView();

        boolean hasStyleMutation();

        boolean hasTouchGesture();

        boolean hasWebviewEvent();

        boolean hasWindowResize();
    }

    public static final class EventPayload extends GeneratedMessageLite<EventPayload, Builder> implements EventPayloadOrBuilder {
        private static final EventPayload DEFAULT_INSTANCE;
        public static final int EVENTS_FIELD_NUMBER = 2;
        private static volatile Parser<EventPayload> PARSER = null;
        public static final int POSITION_FIELD_NUMBER = 3;
        public static final int SCHEMA_VERSION_FIELD_NUMBER = 1;
        private int bitField0_;
        private int position_;
        private String schemaVersion_ = "";
        private Internal.ProtobufList<Event> events_ = GeneratedMessageLite.emptyProtobufList();

        public static final class Builder extends GeneratedMessageLite.Builder<EventPayload, Builder> implements EventPayloadOrBuilder {
            private Builder() {
                super(EventPayload.DEFAULT_INSTANCE);
            }

            public Builder addAllEvents(Iterable<? extends Event> iterable) {
                copyOnWrite();
                ((EventPayload) this.instance).addAllEvents(iterable);
                return this;
            }

            public Builder addEvents(int i, Event.Builder builder) {
                copyOnWrite();
                ((EventPayload) this.instance).addEvents(i, builder.build());
                return this;
            }

            public Builder clearEvents() {
                copyOnWrite();
                ((EventPayload) this.instance).clearEvents();
                return this;
            }

            public Builder clearPosition() {
                copyOnWrite();
                ((EventPayload) this.instance).clearPosition();
                return this;
            }

            public Builder clearSchemaVersion() {
                copyOnWrite();
                ((EventPayload) this.instance).clearSchemaVersion();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventPayloadOrBuilder
            public Event getEvents(int i) {
                return ((EventPayload) this.instance).getEvents(i);
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventPayloadOrBuilder
            public int getEventsCount() {
                return ((EventPayload) this.instance).getEventsCount();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventPayloadOrBuilder
            public List<Event> getEventsList() {
                return Collections.unmodifiableList(((EventPayload) this.instance).getEventsList());
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventPayloadOrBuilder
            public Position getPosition() {
                return ((EventPayload) this.instance).getPosition();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventPayloadOrBuilder
            public int getPositionValue() {
                return ((EventPayload) this.instance).getPositionValue();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventPayloadOrBuilder
            public String getSchemaVersion() {
                return ((EventPayload) this.instance).getSchemaVersion();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventPayloadOrBuilder
            public ByteString getSchemaVersionBytes() {
                return ((EventPayload) this.instance).getSchemaVersionBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventPayloadOrBuilder
            public boolean hasPosition() {
                return ((EventPayload) this.instance).hasPosition();
            }

            public Builder removeEvents(int i) {
                copyOnWrite();
                ((EventPayload) this.instance).removeEvents(i);
                return this;
            }

            public Builder setEvents(int i, Event.Builder builder) {
                copyOnWrite();
                ((EventPayload) this.instance).setEvents(i, builder.build());
                return this;
            }

            public Builder setPosition(Position position) {
                copyOnWrite();
                ((EventPayload) this.instance).setPosition(position);
                return this;
            }

            public Builder setPositionValue(int i) {
                copyOnWrite();
                ((EventPayload) this.instance).setPositionValue(i);
                return this;
            }

            public Builder setSchemaVersion(String str) {
                copyOnWrite();
                ((EventPayload) this.instance).setSchemaVersion(str);
                return this;
            }

            public Builder setSchemaVersionBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((EventPayload) this.instance).setSchemaVersionBytes(byteString);
                return this;
            }

            public Builder addEvents(int i, Event event) {
                copyOnWrite();
                ((EventPayload) this.instance).addEvents(i, event);
                return this;
            }

            public Builder setEvents(int i, Event event) {
                copyOnWrite();
                ((EventPayload) this.instance).setEvents(i, event);
                return this;
            }

            public Builder addEvents(Event.Builder builder) {
                copyOnWrite();
                ((EventPayload) this.instance).addEvents(builder.build());
                return this;
            }

            public Builder addEvents(Event event) {
                copyOnWrite();
                ((EventPayload) this.instance).addEvents(event);
                return this;
            }
        }

        public enum Position implements Internal.EnumLite {
            POSITION_ABSOLUTE(0),
            POSITION_RELATIVE(1),
            UNRECOGNIZED(-1);

            public static final int POSITION_ABSOLUTE_VALUE = 0;
            public static final int POSITION_RELATIVE_VALUE = 1;
            private static final Internal.EnumLiteMap<Position> internalValueMap = new Internal.EnumLiteMap<Position>() { // from class: com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventPayload.Position.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Position findValueByNumber(int i) {
                    return Position.forNumber(i);
                }
            };
            private final int value;

            public static final class PositionVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new PositionVerifier();

                private PositionVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return Position.forNumber(i) != null;
                }
            }

            Position(int i) {
                this.value = i;
            }

            public static Position forNumber(int i) {
                if (i == 0) {
                    return POSITION_ABSOLUTE;
                }
                if (i != 1) {
                    return null;
                }
                return POSITION_RELATIVE;
            }

            public static Internal.EnumLiteMap<Position> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return PositionVerifier.INSTANCE;
            }

            @Deprecated
            public static Position valueOf(int i) {
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

        static {
            EventPayload eventPayload = new EventPayload();
            DEFAULT_INSTANCE = eventPayload;
            GeneratedMessageLite.registerDefaultInstance(EventPayload.class, eventPayload);
        }

        private EventPayload() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllEvents(Iterable<? extends Event> iterable) {
            ensureEventsIsMutable();
            AbstractMessageLite.addAll(iterable, this.events_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEvents(int i, Event event) {
            event.getClass();
            ensureEventsIsMutable();
            this.events_.add(i, event);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEvents() {
            this.events_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPosition() {
            this.bitField0_ &= -2;
            this.position_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSchemaVersion() {
            this.schemaVersion_ = getDefaultInstance().getSchemaVersion();
        }

        private void ensureEventsIsMutable() {
            Internal.ProtobufList<Event> protobufList = this.events_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.events_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static EventPayload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static EventPayload parseDelimitedFrom(InputStream inputStream) {
            return (EventPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EventPayload parseFrom(ByteString byteString) {
            return (EventPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<EventPayload> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeEvents(int i) {
            ensureEventsIsMutable();
            this.events_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEvents(int i, Event event) {
            event.getClass();
            ensureEventsIsMutable();
            this.events_.set(i, event);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPosition(Position position) {
            this.position_ = position.getNumber();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPositionValue(int i) {
            this.bitField0_ |= 1;
            this.position_ = i;
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

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new EventPayload();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003ဌ\u0000", new Object[]{"bitField0_", "schemaVersion_", "events_", Event.class, "position_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EventPayload> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (EventPayload.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventPayloadOrBuilder
        public Event getEvents(int i) {
            return this.events_.get(i);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventPayloadOrBuilder
        public int getEventsCount() {
            return this.events_.size();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventPayloadOrBuilder
        public List<Event> getEventsList() {
            return this.events_;
        }

        public EventOrBuilder getEventsOrBuilder(int i) {
            return this.events_.get(i);
        }

        public List<? extends EventOrBuilder> getEventsOrBuilderList() {
            return this.events_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventPayloadOrBuilder
        public Position getPosition() {
            Position positionForNumber = Position.forNumber(this.position_);
            return positionForNumber == null ? Position.UNRECOGNIZED : positionForNumber;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventPayloadOrBuilder
        public int getPositionValue() {
            return this.position_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventPayloadOrBuilder
        public String getSchemaVersion() {
            return this.schemaVersion_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventPayloadOrBuilder
        public ByteString getSchemaVersionBytes() {
            return ByteString.copyFromUtf8(this.schemaVersion_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventPayloadOrBuilder
        public boolean hasPosition() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEvents(Event event) {
            event.getClass();
            ensureEventsIsMutable();
            this.events_.add(event);
        }

        public static Builder newBuilder(EventPayload eventPayload) {
            return DEFAULT_INSTANCE.createBuilder(eventPayload);
        }

        public static EventPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EventPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EventPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (EventPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EventPayload parseFrom(CodedInputStream codedInputStream) {
            return (EventPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EventPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EventPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static EventPayload parseFrom(InputStream inputStream) {
            return (EventPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EventPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EventPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EventPayload parseFrom(ByteBuffer byteBuffer) {
            return (EventPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static EventPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (EventPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static EventPayload parseFrom(byte[] bArr) {
            return (EventPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static EventPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (EventPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface EventPayloadOrBuilder extends MessageLiteOrBuilder {
        Event getEvents(int i);

        int getEventsCount();

        List<Event> getEventsList();

        EventPayload.Position getPosition();

        int getPositionValue();

        String getSchemaVersion();

        ByteString getSchemaVersionBytes();

        boolean hasPosition();
    }

    public static final class EventPayloadVersion extends GeneratedMessageLite<EventPayloadVersion, Builder> implements EventPayloadVersionOrBuilder {
        private static final EventPayloadVersion DEFAULT_INSTANCE;
        private static volatile Parser<EventPayloadVersion> PARSER = null;
        public static final int SCHEMA_VERSION_FIELD_NUMBER = 1;
        private String schemaVersion_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<EventPayloadVersion, Builder> implements EventPayloadVersionOrBuilder {
            private Builder() {
                super(EventPayloadVersion.DEFAULT_INSTANCE);
            }

            public Builder clearSchemaVersion() {
                copyOnWrite();
                ((EventPayloadVersion) this.instance).clearSchemaVersion();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventPayloadVersionOrBuilder
            public String getSchemaVersion() {
                return ((EventPayloadVersion) this.instance).getSchemaVersion();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventPayloadVersionOrBuilder
            public ByteString getSchemaVersionBytes() {
                return ((EventPayloadVersion) this.instance).getSchemaVersionBytes();
            }

            public Builder setSchemaVersion(String str) {
                copyOnWrite();
                ((EventPayloadVersion) this.instance).setSchemaVersion(str);
                return this;
            }

            public Builder setSchemaVersionBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((EventPayloadVersion) this.instance).setSchemaVersionBytes(byteString);
                return this;
            }
        }

        static {
            EventPayloadVersion eventPayloadVersion = new EventPayloadVersion();
            DEFAULT_INSTANCE = eventPayloadVersion;
            GeneratedMessageLite.registerDefaultInstance(EventPayloadVersion.class, eventPayloadVersion);
        }

        private EventPayloadVersion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSchemaVersion() {
            this.schemaVersion_ = getDefaultInstance().getSchemaVersion();
        }

        public static EventPayloadVersion getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static EventPayloadVersion parseDelimitedFrom(InputStream inputStream) {
            return (EventPayloadVersion) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EventPayloadVersion parseFrom(ByteString byteString) {
            return (EventPayloadVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<EventPayloadVersion> parser() {
            return DEFAULT_INSTANCE.getParserForType();
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

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new EventPayloadVersion();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"schemaVersion_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EventPayloadVersion> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (EventPayloadVersion.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventPayloadVersionOrBuilder
        public String getSchemaVersion() {
            return this.schemaVersion_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.EventPayloadVersionOrBuilder
        public ByteString getSchemaVersionBytes() {
            return ByteString.copyFromUtf8(this.schemaVersion_);
        }

        public static Builder newBuilder(EventPayloadVersion eventPayloadVersion) {
            return DEFAULT_INSTANCE.createBuilder(eventPayloadVersion);
        }

        public static EventPayloadVersion parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EventPayloadVersion) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EventPayloadVersion parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (EventPayloadVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EventPayloadVersion parseFrom(CodedInputStream codedInputStream) {
            return (EventPayloadVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EventPayloadVersion parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EventPayloadVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static EventPayloadVersion parseFrom(InputStream inputStream) {
            return (EventPayloadVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EventPayloadVersion parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EventPayloadVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EventPayloadVersion parseFrom(ByteBuffer byteBuffer) {
            return (EventPayloadVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static EventPayloadVersion parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (EventPayloadVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static EventPayloadVersion parseFrom(byte[] bArr) {
            return (EventPayloadVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static EventPayloadVersion parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (EventPayloadVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface EventPayloadVersionOrBuilder extends MessageLiteOrBuilder {
        String getSchemaVersion();

        ByteString getSchemaVersionBytes();
    }

    public static final class Gesture extends GeneratedMessageLite<Gesture, Builder> implements GestureOrBuilder {
        private static final Gesture DEFAULT_INSTANCE;
        public static final int DRAG_FIELD_NUMBER = 5;
        public static final int FLICK_FIELD_NUMBER = 6;
        public static final int LONG_PRESS_FIELD_NUMBER = 4;
        private static volatile Parser<Gesture> PARSER = null;
        public static final int TAP_FIELD_NUMBER = 3;
        public static final int UNIX_TIMESTAMP_MS_FIELD_NUMBER = 2;
        public static final int VIEW_ID_FIELD_NUMBER = 1;
        private int gestureCase_ = 0;
        private Object gesture_;
        private long unixTimestampMs_;
        private long viewId_;

        public static final class Builder extends GeneratedMessageLite.Builder<Gesture, Builder> implements GestureOrBuilder {
            private Builder() {
                super(Gesture.DEFAULT_INSTANCE);
            }

            public Builder clearDrag() {
                copyOnWrite();
                ((Gesture) this.instance).clearDrag();
                return this;
            }

            public Builder clearFlick() {
                copyOnWrite();
                ((Gesture) this.instance).clearFlick();
                return this;
            }

            public Builder clearGesture() {
                copyOnWrite();
                ((Gesture) this.instance).clearGesture();
                return this;
            }

            public Builder clearLongPress() {
                copyOnWrite();
                ((Gesture) this.instance).clearLongPress();
                return this;
            }

            public Builder clearTap() {
                copyOnWrite();
                ((Gesture) this.instance).clearTap();
                return this;
            }

            public Builder clearUnixTimestampMs() {
                copyOnWrite();
                ((Gesture) this.instance).clearUnixTimestampMs();
                return this;
            }

            public Builder clearViewId() {
                copyOnWrite();
                ((Gesture) this.instance).clearViewId();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
            public Drag getDrag() {
                return ((Gesture) this.instance).getDrag();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
            public Flick getFlick() {
                return ((Gesture) this.instance).getFlick();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
            public GestureCase getGestureCase() {
                return ((Gesture) this.instance).getGestureCase();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
            public LongPress getLongPress() {
                return ((Gesture) this.instance).getLongPress();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
            public Tap getTap() {
                return ((Gesture) this.instance).getTap();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
            public long getUnixTimestampMs() {
                return ((Gesture) this.instance).getUnixTimestampMs();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
            public long getViewId() {
                return ((Gesture) this.instance).getViewId();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
            public boolean hasDrag() {
                return ((Gesture) this.instance).hasDrag();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
            public boolean hasFlick() {
                return ((Gesture) this.instance).hasFlick();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
            public boolean hasLongPress() {
                return ((Gesture) this.instance).hasLongPress();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
            public boolean hasTap() {
                return ((Gesture) this.instance).hasTap();
            }

            public Builder mergeDrag(Drag drag) {
                copyOnWrite();
                ((Gesture) this.instance).mergeDrag(drag);
                return this;
            }

            public Builder mergeFlick(Flick flick) {
                copyOnWrite();
                ((Gesture) this.instance).mergeFlick(flick);
                return this;
            }

            public Builder mergeLongPress(LongPress longPress) {
                copyOnWrite();
                ((Gesture) this.instance).mergeLongPress(longPress);
                return this;
            }

            public Builder mergeTap(Tap tap) {
                copyOnWrite();
                ((Gesture) this.instance).mergeTap(tap);
                return this;
            }

            public Builder setDrag(Drag.Builder builder) {
                copyOnWrite();
                ((Gesture) this.instance).setDrag(builder.build());
                return this;
            }

            public Builder setFlick(Flick.Builder builder) {
                copyOnWrite();
                ((Gesture) this.instance).setFlick(builder.build());
                return this;
            }

            public Builder setLongPress(LongPress.Builder builder) {
                copyOnWrite();
                ((Gesture) this.instance).setLongPress(builder.build());
                return this;
            }

            public Builder setTap(Tap.Builder builder) {
                copyOnWrite();
                ((Gesture) this.instance).setTap(builder.build());
                return this;
            }

            public Builder setUnixTimestampMs(long j) {
                copyOnWrite();
                ((Gesture) this.instance).setUnixTimestampMs(j);
                return this;
            }

            public Builder setViewId(long j) {
                copyOnWrite();
                ((Gesture) this.instance).setViewId(j);
                return this;
            }

            public Builder setDrag(Drag drag) {
                copyOnWrite();
                ((Gesture) this.instance).setDrag(drag);
                return this;
            }

            public Builder setFlick(Flick flick) {
                copyOnWrite();
                ((Gesture) this.instance).setFlick(flick);
                return this;
            }

            public Builder setLongPress(LongPress longPress) {
                copyOnWrite();
                ((Gesture) this.instance).setLongPress(longPress);
                return this;
            }

            public Builder setTap(Tap tap) {
                copyOnWrite();
                ((Gesture) this.instance).setTap(tap);
                return this;
            }
        }

        public enum Direction implements Internal.EnumLite {
            DIRECTION_UNSPECIFIED(0),
            DIRECTION_UP(1),
            DIRECTION_DOWN(2),
            DIRECTION_LEFT(3),
            DIRECTION_RIGHT(4),
            UNRECOGNIZED(-1);

            public static final int DIRECTION_DOWN_VALUE = 2;
            public static final int DIRECTION_LEFT_VALUE = 3;
            public static final int DIRECTION_RIGHT_VALUE = 4;
            public static final int DIRECTION_UNSPECIFIED_VALUE = 0;
            public static final int DIRECTION_UP_VALUE = 1;
            private static final Internal.EnumLiteMap<Direction> internalValueMap = new Internal.EnumLiteMap<Direction>() { // from class: com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.Gesture.Direction.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Direction findValueByNumber(int i) {
                    return Direction.forNumber(i);
                }
            };
            private final int value;

            public static final class DirectionVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new DirectionVerifier();

                private DirectionVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return Direction.forNumber(i) != null;
                }
            }

            Direction(int i) {
                this.value = i;
            }

            public static Direction forNumber(int i) {
                if (i == 0) {
                    return DIRECTION_UNSPECIFIED;
                }
                if (i == 1) {
                    return DIRECTION_UP;
                }
                if (i == 2) {
                    return DIRECTION_DOWN;
                }
                if (i == 3) {
                    return DIRECTION_LEFT;
                }
                if (i != 4) {
                    return null;
                }
                return DIRECTION_RIGHT;
            }

            public static Internal.EnumLiteMap<Direction> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return DirectionVerifier.INSTANCE;
            }

            @Deprecated
            public static Direction valueOf(int i) {
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

        public static final class Drag extends GeneratedMessageLite<Drag, Builder> implements DragOrBuilder {
            private static final Drag DEFAULT_INSTANCE;
            public static final int DIRECTION_FIELD_NUMBER = 1;
            private static volatile Parser<Drag> PARSER;
            private int direction_;

            public static final class Builder extends GeneratedMessageLite.Builder<Drag, Builder> implements DragOrBuilder {
                private Builder() {
                    super(Drag.DEFAULT_INSTANCE);
                }

                public Builder clearDirection() {
                    copyOnWrite();
                    ((Drag) this.instance).clearDirection();
                    return this;
                }

                @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.Gesture.DragOrBuilder
                public Direction getDirection() {
                    return ((Drag) this.instance).getDirection();
                }

                @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.Gesture.DragOrBuilder
                public int getDirectionValue() {
                    return ((Drag) this.instance).getDirectionValue();
                }

                public Builder setDirection(Direction direction) {
                    copyOnWrite();
                    ((Drag) this.instance).setDirection(direction);
                    return this;
                }

                public Builder setDirectionValue(int i) {
                    copyOnWrite();
                    ((Drag) this.instance).setDirectionValue(i);
                    return this;
                }
            }

            static {
                Drag drag = new Drag();
                DEFAULT_INSTANCE = drag;
                GeneratedMessageLite.registerDefaultInstance(Drag.class, drag);
            }

            private Drag() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearDirection() {
                this.direction_ = 0;
            }

            public static Drag getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Drag parseDelimitedFrom(InputStream inputStream) {
                return (Drag) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Drag parseFrom(ByteString byteString) {
                return (Drag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<Drag> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDirection(Direction direction) {
                this.direction_ = direction.getNumber();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDirectionValue(int i) {
                this.direction_ = i;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new Drag();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"direction_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Drag> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Drag.class) {
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

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.Gesture.DragOrBuilder
            public Direction getDirection() {
                Direction directionForNumber = Direction.forNumber(this.direction_);
                return directionForNumber == null ? Direction.UNRECOGNIZED : directionForNumber;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.Gesture.DragOrBuilder
            public int getDirectionValue() {
                return this.direction_;
            }

            public static Builder newBuilder(Drag drag) {
                return DEFAULT_INSTANCE.createBuilder(drag);
            }

            public static Drag parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Drag) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Drag parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (Drag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Drag parseFrom(CodedInputStream codedInputStream) {
                return (Drag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Drag parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Drag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Drag parseFrom(InputStream inputStream) {
                return (Drag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Drag parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Drag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Drag parseFrom(ByteBuffer byteBuffer) {
                return (Drag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Drag parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (Drag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Drag parseFrom(byte[] bArr) {
                return (Drag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Drag parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (Drag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface DragOrBuilder extends MessageLiteOrBuilder {
            Direction getDirection();

            int getDirectionValue();
        }

        public static final class Flick extends GeneratedMessageLite<Flick, Builder> implements FlickOrBuilder {
            private static final Flick DEFAULT_INSTANCE;
            public static final int DIRECTION_FIELD_NUMBER = 1;
            private static volatile Parser<Flick> PARSER;
            private int direction_;

            public static final class Builder extends GeneratedMessageLite.Builder<Flick, Builder> implements FlickOrBuilder {
                private Builder() {
                    super(Flick.DEFAULT_INSTANCE);
                }

                public Builder clearDirection() {
                    copyOnWrite();
                    ((Flick) this.instance).clearDirection();
                    return this;
                }

                @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.Gesture.FlickOrBuilder
                public Direction getDirection() {
                    return ((Flick) this.instance).getDirection();
                }

                @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.Gesture.FlickOrBuilder
                public int getDirectionValue() {
                    return ((Flick) this.instance).getDirectionValue();
                }

                public Builder setDirection(Direction direction) {
                    copyOnWrite();
                    ((Flick) this.instance).setDirection(direction);
                    return this;
                }

                public Builder setDirectionValue(int i) {
                    copyOnWrite();
                    ((Flick) this.instance).setDirectionValue(i);
                    return this;
                }
            }

            static {
                Flick flick = new Flick();
                DEFAULT_INSTANCE = flick;
                GeneratedMessageLite.registerDefaultInstance(Flick.class, flick);
            }

            private Flick() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearDirection() {
                this.direction_ = 0;
            }

            public static Flick getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Flick parseDelimitedFrom(InputStream inputStream) {
                return (Flick) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Flick parseFrom(ByteString byteString) {
                return (Flick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<Flick> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDirection(Direction direction) {
                this.direction_ = direction.getNumber();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDirectionValue(int i) {
                this.direction_ = i;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new Flick();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"direction_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Flick> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Flick.class) {
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

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.Gesture.FlickOrBuilder
            public Direction getDirection() {
                Direction directionForNumber = Direction.forNumber(this.direction_);
                return directionForNumber == null ? Direction.UNRECOGNIZED : directionForNumber;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.Gesture.FlickOrBuilder
            public int getDirectionValue() {
                return this.direction_;
            }

            public static Builder newBuilder(Flick flick) {
                return DEFAULT_INSTANCE.createBuilder(flick);
            }

            public static Flick parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Flick) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Flick parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (Flick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Flick parseFrom(CodedInputStream codedInputStream) {
                return (Flick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Flick parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Flick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Flick parseFrom(InputStream inputStream) {
                return (Flick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Flick parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Flick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Flick parseFrom(ByteBuffer byteBuffer) {
                return (Flick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Flick parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (Flick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Flick parseFrom(byte[] bArr) {
                return (Flick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Flick parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (Flick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface FlickOrBuilder extends MessageLiteOrBuilder {
            Direction getDirection();

            int getDirectionValue();
        }

        public enum GestureCase {
            TAP(3),
            LONG_PRESS(4),
            DRAG(5),
            FLICK(6),
            GESTURE_NOT_SET(0);

            private final int value;

            GestureCase(int i) {
                this.value = i;
            }

            public static GestureCase forNumber(int i) {
                if (i == 0) {
                    return GESTURE_NOT_SET;
                }
                if (i == 3) {
                    return TAP;
                }
                if (i == 4) {
                    return LONG_PRESS;
                }
                if (i == 5) {
                    return DRAG;
                }
                if (i != 6) {
                    return null;
                }
                return FLICK;
            }

            @Deprecated
            public static GestureCase valueOf(int i) {
                return forNumber(i);
            }

            public int getNumber() {
                return this.value;
            }
        }

        public static final class LongPress extends GeneratedMessageLite<LongPress, Builder> implements LongPressOrBuilder {
            private static final LongPress DEFAULT_INSTANCE;
            private static volatile Parser<LongPress> PARSER;

            public static final class Builder extends GeneratedMessageLite.Builder<LongPress, Builder> implements LongPressOrBuilder {
                private Builder() {
                    super(LongPress.DEFAULT_INSTANCE);
                }
            }

            static {
                LongPress longPress = new LongPress();
                DEFAULT_INSTANCE = longPress;
                GeneratedMessageLite.registerDefaultInstance(LongPress.class, longPress);
            }

            private LongPress() {
            }

            public static LongPress getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static LongPress parseDelimitedFrom(InputStream inputStream) {
                return (LongPress) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static LongPress parseFrom(ByteString byteString) {
                return (LongPress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<LongPress> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new LongPress();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<LongPress> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (LongPress.class) {
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

            public static Builder newBuilder(LongPress longPress) {
                return DEFAULT_INSTANCE.createBuilder(longPress);
            }

            public static LongPress parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (LongPress) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static LongPress parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (LongPress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static LongPress parseFrom(CodedInputStream codedInputStream) {
                return (LongPress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static LongPress parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (LongPress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static LongPress parseFrom(InputStream inputStream) {
                return (LongPress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static LongPress parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (LongPress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static LongPress parseFrom(ByteBuffer byteBuffer) {
                return (LongPress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static LongPress parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (LongPress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static LongPress parseFrom(byte[] bArr) {
                return (LongPress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static LongPress parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (LongPress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface LongPressOrBuilder extends MessageLiteOrBuilder {
        }

        public static final class Tap extends GeneratedMessageLite<Tap, Builder> implements TapOrBuilder {
            private static final Tap DEFAULT_INSTANCE;
            private static volatile Parser<Tap> PARSER = null;
            public static final int X_FIELD_NUMBER = 1;
            public static final int Y_FIELD_NUMBER = 2;
            private int x_;
            private int y_;

            public static final class Builder extends GeneratedMessageLite.Builder<Tap, Builder> implements TapOrBuilder {
                private Builder() {
                    super(Tap.DEFAULT_INSTANCE);
                }

                public Builder clearX() {
                    copyOnWrite();
                    ((Tap) this.instance).clearX();
                    return this;
                }

                public Builder clearY() {
                    copyOnWrite();
                    ((Tap) this.instance).clearY();
                    return this;
                }

                @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.Gesture.TapOrBuilder
                public int getX() {
                    return ((Tap) this.instance).getX();
                }

                @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.Gesture.TapOrBuilder
                public int getY() {
                    return ((Tap) this.instance).getY();
                }

                public Builder setX(int i) {
                    copyOnWrite();
                    ((Tap) this.instance).setX(i);
                    return this;
                }

                public Builder setY(int i) {
                    copyOnWrite();
                    ((Tap) this.instance).setY(i);
                    return this;
                }
            }

            static {
                Tap tap = new Tap();
                DEFAULT_INSTANCE = tap;
                GeneratedMessageLite.registerDefaultInstance(Tap.class, tap);
            }

            private Tap() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearX() {
                this.x_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearY() {
                this.y_ = 0;
            }

            public static Tap getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Tap parseDelimitedFrom(InputStream inputStream) {
                return (Tap) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Tap parseFrom(ByteString byteString) {
                return (Tap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<Tap> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setX(int i) {
                this.x_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setY(int i) {
                this.y_ = i;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new Tap();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000f\u0002\u000f", new Object[]{"x_", "y_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Tap> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Tap.class) {
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

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.Gesture.TapOrBuilder
            public int getX() {
                return this.x_;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.Gesture.TapOrBuilder
            public int getY() {
                return this.y_;
            }

            public static Builder newBuilder(Tap tap) {
                return DEFAULT_INSTANCE.createBuilder(tap);
            }

            public static Tap parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Tap) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Tap parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (Tap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Tap parseFrom(CodedInputStream codedInputStream) {
                return (Tap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Tap parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Tap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Tap parseFrom(InputStream inputStream) {
                return (Tap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Tap parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Tap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Tap parseFrom(ByteBuffer byteBuffer) {
                return (Tap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Tap parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (Tap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Tap parseFrom(byte[] bArr) {
                return (Tap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Tap parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (Tap) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface TapOrBuilder extends MessageLiteOrBuilder {
            int getX();

            int getY();
        }

        static {
            Gesture gesture = new Gesture();
            DEFAULT_INSTANCE = gesture;
            GeneratedMessageLite.registerDefaultInstance(Gesture.class, gesture);
        }

        private Gesture() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDrag() {
            if (this.gestureCase_ == 5) {
                this.gestureCase_ = 0;
                this.gesture_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFlick() {
            if (this.gestureCase_ == 6) {
                this.gestureCase_ = 0;
                this.gesture_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGesture() {
            this.gestureCase_ = 0;
            this.gesture_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLongPress() {
            if (this.gestureCase_ == 4) {
                this.gestureCase_ = 0;
                this.gesture_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTap() {
            if (this.gestureCase_ == 3) {
                this.gestureCase_ = 0;
                this.gesture_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnixTimestampMs() {
            this.unixTimestampMs_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearViewId() {
            this.viewId_ = 0L;
        }

        public static Gesture getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDrag(Drag drag) {
            drag.getClass();
            if (this.gestureCase_ == 5 && this.gesture_ != Drag.getDefaultInstance()) {
                drag = Drag.newBuilder((Drag) this.gesture_).mergeFrom((Drag.Builder) drag).buildPartial();
            }
            this.gesture_ = drag;
            this.gestureCase_ = 5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeFlick(Flick flick) {
            flick.getClass();
            if (this.gestureCase_ == 6 && this.gesture_ != Flick.getDefaultInstance()) {
                flick = Flick.newBuilder((Flick) this.gesture_).mergeFrom((Flick.Builder) flick).buildPartial();
            }
            this.gesture_ = flick;
            this.gestureCase_ = 6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeLongPress(LongPress longPress) {
            longPress.getClass();
            if (this.gestureCase_ == 4 && this.gesture_ != LongPress.getDefaultInstance()) {
                longPress = LongPress.newBuilder((LongPress) this.gesture_).mergeFrom((LongPress.Builder) longPress).buildPartial();
            }
            this.gesture_ = longPress;
            this.gestureCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTap(Tap tap) {
            tap.getClass();
            if (this.gestureCase_ == 3 && this.gesture_ != Tap.getDefaultInstance()) {
                tap = Tap.newBuilder((Tap) this.gesture_).mergeFrom((Tap.Builder) tap).buildPartial();
            }
            this.gesture_ = tap;
            this.gestureCase_ = 3;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Gesture parseDelimitedFrom(InputStream inputStream) {
            return (Gesture) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Gesture parseFrom(ByteString byteString) {
            return (Gesture) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<Gesture> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDrag(Drag drag) {
            drag.getClass();
            this.gesture_ = drag;
            this.gestureCase_ = 5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFlick(Flick flick) {
            flick.getClass();
            this.gesture_ = flick;
            this.gestureCase_ = 6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLongPress(LongPress longPress) {
            longPress.getClass();
            this.gesture_ = longPress;
            this.gestureCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTap(Tap tap) {
            tap.getClass();
            this.gesture_ = tap;
            this.gestureCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnixTimestampMs(long j) {
            this.unixTimestampMs_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setViewId(long j) {
            this.viewId_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new Gesture();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0010\u0002\u0003\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"gesture_", "gestureCase_", "viewId_", "unixTimestampMs_", Tap.class, LongPress.class, Drag.class, Flick.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Gesture> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (Gesture.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
        public Drag getDrag() {
            return this.gestureCase_ == 5 ? (Drag) this.gesture_ : Drag.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
        public Flick getFlick() {
            return this.gestureCase_ == 6 ? (Flick) this.gesture_ : Flick.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
        public GestureCase getGestureCase() {
            return GestureCase.forNumber(this.gestureCase_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
        public LongPress getLongPress() {
            return this.gestureCase_ == 4 ? (LongPress) this.gesture_ : LongPress.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
        public Tap getTap() {
            return this.gestureCase_ == 3 ? (Tap) this.gesture_ : Tap.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
        public long getUnixTimestampMs() {
            return this.unixTimestampMs_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
        public long getViewId() {
            return this.viewId_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
        public boolean hasDrag() {
            return this.gestureCase_ == 5;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
        public boolean hasFlick() {
            return this.gestureCase_ == 6;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
        public boolean hasLongPress() {
            return this.gestureCase_ == 4;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GestureOrBuilder
        public boolean hasTap() {
            return this.gestureCase_ == 3;
        }

        public static Builder newBuilder(Gesture gesture) {
            return DEFAULT_INSTANCE.createBuilder(gesture);
        }

        public static Gesture parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Gesture) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Gesture parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Gesture) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Gesture parseFrom(CodedInputStream codedInputStream) {
            return (Gesture) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Gesture parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Gesture) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Gesture parseFrom(InputStream inputStream) {
            return (Gesture) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Gesture parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Gesture) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Gesture parseFrom(ByteBuffer byteBuffer) {
            return (Gesture) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Gesture parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (Gesture) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Gesture parseFrom(byte[] bArr) {
            return (Gesture) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Gesture parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Gesture) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface GestureOrBuilder extends MessageLiteOrBuilder {
        Gesture.Drag getDrag();

        Gesture.Flick getFlick();

        Gesture.GestureCase getGestureCase();

        Gesture.LongPress getLongPress();

        Gesture.Tap getTap();

        long getUnixTimestampMs();

        long getViewId();

        boolean hasDrag();

        boolean hasFlick();

        boolean hasLongPress();

        boolean hasTap();
    }

    public static final class GraphMetadata extends GeneratedMessageLite<GraphMetadata, Builder> implements GraphMetadataOrBuilder {
        public static final int CLASS_NAME_FIELD_NUMBER = 1;
        private static final GraphMetadata DEFAULT_INSTANCE;
        public static final int INCREMENTAL_PATH_FIELD_NUMBER = 2;
        private static volatile Parser<GraphMetadata> PARSER = null;
        public static final int RELIABLE_PATH_FIELD_NUMBER = 3;
        private int bitField0_;
        private String className_ = "";
        private String incrementalPath_ = "";
        private String reliablePath_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<GraphMetadata, Builder> implements GraphMetadataOrBuilder {
            private Builder() {
                super(GraphMetadata.DEFAULT_INSTANCE);
            }

            public Builder clearClassName() {
                copyOnWrite();
                ((GraphMetadata) this.instance).clearClassName();
                return this;
            }

            public Builder clearIncrementalPath() {
                copyOnWrite();
                ((GraphMetadata) this.instance).clearIncrementalPath();
                return this;
            }

            public Builder clearReliablePath() {
                copyOnWrite();
                ((GraphMetadata) this.instance).clearReliablePath();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GraphMetadataOrBuilder
            public String getClassName() {
                return ((GraphMetadata) this.instance).getClassName();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GraphMetadataOrBuilder
            public ByteString getClassNameBytes() {
                return ((GraphMetadata) this.instance).getClassNameBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GraphMetadataOrBuilder
            public String getIncrementalPath() {
                return ((GraphMetadata) this.instance).getIncrementalPath();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GraphMetadataOrBuilder
            public ByteString getIncrementalPathBytes() {
                return ((GraphMetadata) this.instance).getIncrementalPathBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GraphMetadataOrBuilder
            public String getReliablePath() {
                return ((GraphMetadata) this.instance).getReliablePath();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GraphMetadataOrBuilder
            public ByteString getReliablePathBytes() {
                return ((GraphMetadata) this.instance).getReliablePathBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GraphMetadataOrBuilder
            public boolean hasReliablePath() {
                return ((GraphMetadata) this.instance).hasReliablePath();
            }

            public Builder setClassName(String str) {
                copyOnWrite();
                ((GraphMetadata) this.instance).setClassName(str);
                return this;
            }

            public Builder setClassNameBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((GraphMetadata) this.instance).setClassNameBytes(byteString);
                return this;
            }

            public Builder setIncrementalPath(String str) {
                copyOnWrite();
                ((GraphMetadata) this.instance).setIncrementalPath(str);
                return this;
            }

            public Builder setIncrementalPathBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((GraphMetadata) this.instance).setIncrementalPathBytes(byteString);
                return this;
            }

            public Builder setReliablePath(String str) {
                copyOnWrite();
                ((GraphMetadata) this.instance).setReliablePath(str);
                return this;
            }

            public Builder setReliablePathBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((GraphMetadata) this.instance).setReliablePathBytes(byteString);
                return this;
            }
        }

        static {
            GraphMetadata graphMetadata = new GraphMetadata();
            DEFAULT_INSTANCE = graphMetadata;
            GeneratedMessageLite.registerDefaultInstance(GraphMetadata.class, graphMetadata);
        }

        private GraphMetadata() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClassName() {
            this.className_ = getDefaultInstance().getClassName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIncrementalPath() {
            this.incrementalPath_ = getDefaultInstance().getIncrementalPath();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReliablePath() {
            this.bitField0_ &= -2;
            this.reliablePath_ = getDefaultInstance().getReliablePath();
        }

        public static GraphMetadata getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static GraphMetadata parseDelimitedFrom(InputStream inputStream) {
            return (GraphMetadata) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GraphMetadata parseFrom(ByteString byteString) {
            return (GraphMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<GraphMetadata> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClassName(String str) {
            str.getClass();
            this.className_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClassNameBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.className_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIncrementalPath(String str) {
            str.getClass();
            this.incrementalPath_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIncrementalPathBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.incrementalPath_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReliablePath(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.reliablePath_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReliablePathBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.reliablePath_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new GraphMetadata();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003ለ\u0000", new Object[]{"bitField0_", "className_", "incrementalPath_", "reliablePath_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<GraphMetadata> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (GraphMetadata.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GraphMetadataOrBuilder
        public String getClassName() {
            return this.className_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GraphMetadataOrBuilder
        public ByteString getClassNameBytes() {
            return ByteString.copyFromUtf8(this.className_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GraphMetadataOrBuilder
        public String getIncrementalPath() {
            return this.incrementalPath_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GraphMetadataOrBuilder
        public ByteString getIncrementalPathBytes() {
            return ByteString.copyFromUtf8(this.incrementalPath_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GraphMetadataOrBuilder
        public String getReliablePath() {
            return this.reliablePath_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GraphMetadataOrBuilder
        public ByteString getReliablePathBytes() {
            return ByteString.copyFromUtf8(this.reliablePath_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.GraphMetadataOrBuilder
        public boolean hasReliablePath() {
            return (this.bitField0_ & 1) != 0;
        }

        public static Builder newBuilder(GraphMetadata graphMetadata) {
            return DEFAULT_INSTANCE.createBuilder(graphMetadata);
        }

        public static GraphMetadata parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (GraphMetadata) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GraphMetadata parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (GraphMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static GraphMetadata parseFrom(CodedInputStream codedInputStream) {
            return (GraphMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static GraphMetadata parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (GraphMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static GraphMetadata parseFrom(InputStream inputStream) {
            return (GraphMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GraphMetadata parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (GraphMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GraphMetadata parseFrom(ByteBuffer byteBuffer) {
            return (GraphMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static GraphMetadata parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (GraphMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static GraphMetadata parseFrom(byte[] bArr) {
            return (GraphMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static GraphMetadata parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (GraphMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface GraphMetadataOrBuilder extends MessageLiteOrBuilder {
        String getClassName();

        ByteString getClassNameBytes();

        String getIncrementalPath();

        ByteString getIncrementalPathBytes();

        String getReliablePath();

        ByteString getReliablePathBytes();

        boolean hasReliablePath();
    }

    public static final class InsertionMutation extends GeneratedMessageLite<InsertionMutation, Builder> implements InsertionMutationOrBuilder {
        private static final InsertionMutation DEFAULT_INSTANCE;
        public static final int INDEX_IN_PARENT_FIELD_NUMBER = 3;
        public static final int PARENT_VIEW_ID_FIELD_NUMBER = 2;
        private static volatile Parser<InsertionMutation> PARSER = null;
        public static final int UNIX_TIMESTAMP_MS_FIELD_NUMBER = 1;
        public static final int VIEW_FIELD_NUMBER = 4;
        private int bitField0_;
        private int indexInParent_;
        private long parentViewId_;
        private long unixTimestampMs_;
        private View view_;

        public static final class Builder extends GeneratedMessageLite.Builder<InsertionMutation, Builder> implements InsertionMutationOrBuilder {
            private Builder() {
                super(InsertionMutation.DEFAULT_INSTANCE);
            }

            public Builder clearIndexInParent() {
                copyOnWrite();
                ((InsertionMutation) this.instance).clearIndexInParent();
                return this;
            }

            public Builder clearParentViewId() {
                copyOnWrite();
                ((InsertionMutation) this.instance).clearParentViewId();
                return this;
            }

            public Builder clearUnixTimestampMs() {
                copyOnWrite();
                ((InsertionMutation) this.instance).clearUnixTimestampMs();
                return this;
            }

            public Builder clearView() {
                copyOnWrite();
                ((InsertionMutation) this.instance).clearView();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.InsertionMutationOrBuilder
            public int getIndexInParent() {
                return ((InsertionMutation) this.instance).getIndexInParent();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.InsertionMutationOrBuilder
            public long getParentViewId() {
                return ((InsertionMutation) this.instance).getParentViewId();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.InsertionMutationOrBuilder
            public long getUnixTimestampMs() {
                return ((InsertionMutation) this.instance).getUnixTimestampMs();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.InsertionMutationOrBuilder
            public View getView() {
                return ((InsertionMutation) this.instance).getView();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.InsertionMutationOrBuilder
            public boolean hasIndexInParent() {
                return ((InsertionMutation) this.instance).hasIndexInParent();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.InsertionMutationOrBuilder
            public boolean hasParentViewId() {
                return ((InsertionMutation) this.instance).hasParentViewId();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.InsertionMutationOrBuilder
            public boolean hasView() {
                return ((InsertionMutation) this.instance).hasView();
            }

            public Builder mergeView(View view) {
                copyOnWrite();
                ((InsertionMutation) this.instance).mergeView(view);
                return this;
            }

            public Builder setIndexInParent(int i) {
                copyOnWrite();
                ((InsertionMutation) this.instance).setIndexInParent(i);
                return this;
            }

            public Builder setParentViewId(long j) {
                copyOnWrite();
                ((InsertionMutation) this.instance).setParentViewId(j);
                return this;
            }

            public Builder setUnixTimestampMs(long j) {
                copyOnWrite();
                ((InsertionMutation) this.instance).setUnixTimestampMs(j);
                return this;
            }

            public Builder setView(View.Builder builder) {
                copyOnWrite();
                ((InsertionMutation) this.instance).setView(builder.build());
                return this;
            }

            public Builder setView(View view) {
                copyOnWrite();
                ((InsertionMutation) this.instance).setView(view);
                return this;
            }
        }

        static {
            InsertionMutation insertionMutation = new InsertionMutation();
            DEFAULT_INSTANCE = insertionMutation;
            GeneratedMessageLite.registerDefaultInstance(InsertionMutation.class, insertionMutation);
        }

        private InsertionMutation() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIndexInParent() {
            this.bitField0_ &= -3;
            this.indexInParent_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearParentViewId() {
            this.bitField0_ &= -2;
            this.parentViewId_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnixTimestampMs() {
            this.unixTimestampMs_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearView() {
            this.view_ = null;
            this.bitField0_ &= -5;
        }

        public static InsertionMutation getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeView(View view) {
            view.getClass();
            View view2 = this.view_;
            if (view2 != null && view2 != View.getDefaultInstance()) {
                view = View.newBuilder(this.view_).mergeFrom((View.Builder) view).buildPartial();
            }
            this.view_ = view;
            this.bitField0_ |= 4;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static InsertionMutation parseDelimitedFrom(InputStream inputStream) {
            return (InsertionMutation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static InsertionMutation parseFrom(ByteString byteString) {
            return (InsertionMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<InsertionMutation> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIndexInParent(int i) {
            this.bitField0_ |= 2;
            this.indexInParent_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setParentViewId(long j) {
            this.bitField0_ |= 1;
            this.parentViewId_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnixTimestampMs(long j) {
            this.unixTimestampMs_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setView(View view) {
            view.getClass();
            this.view_ = view;
            this.bitField0_ |= 4;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new InsertionMutation();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0003\u0002တ\u0000\u0003ဋ\u0001\u0004ဉ\u0002", new Object[]{"bitField0_", "unixTimestampMs_", "parentViewId_", "indexInParent_", "view_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<InsertionMutation> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (InsertionMutation.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.InsertionMutationOrBuilder
        public int getIndexInParent() {
            return this.indexInParent_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.InsertionMutationOrBuilder
        public long getParentViewId() {
            return this.parentViewId_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.InsertionMutationOrBuilder
        public long getUnixTimestampMs() {
            return this.unixTimestampMs_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.InsertionMutationOrBuilder
        public View getView() {
            View view = this.view_;
            return view == null ? View.getDefaultInstance() : view;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.InsertionMutationOrBuilder
        public boolean hasIndexInParent() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.InsertionMutationOrBuilder
        public boolean hasParentViewId() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.InsertionMutationOrBuilder
        public boolean hasView() {
            return (this.bitField0_ & 4) != 0;
        }

        public static Builder newBuilder(InsertionMutation insertionMutation) {
            return DEFAULT_INSTANCE.createBuilder(insertionMutation);
        }

        public static InsertionMutation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (InsertionMutation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static InsertionMutation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (InsertionMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static InsertionMutation parseFrom(CodedInputStream codedInputStream) {
            return (InsertionMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static InsertionMutation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (InsertionMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static InsertionMutation parseFrom(InputStream inputStream) {
            return (InsertionMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static InsertionMutation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (InsertionMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static InsertionMutation parseFrom(ByteBuffer byteBuffer) {
            return (InsertionMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static InsertionMutation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (InsertionMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static InsertionMutation parseFrom(byte[] bArr) {
            return (InsertionMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static InsertionMutation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (InsertionMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface InsertionMutationOrBuilder extends MessageLiteOrBuilder {
        int getIndexInParent();

        long getParentViewId();

        long getUnixTimestampMs();

        View getView();

        boolean hasIndexInParent();

        boolean hasParentViewId();

        boolean hasView();
    }

    public static final class JsError extends GeneratedMessageLite<JsError, Builder> implements JsErrorOrBuilder {
        public static final int COL_NUMBER_FIELD_NUMBER = 5;
        private static final JsError DEFAULT_INSTANCE;
        public static final int ERROR_SOURCE_FIELD_NUMBER = 6;
        public static final int FILENAME_FIELD_NUMBER = 3;
        public static final int LINE_NUMBER_FIELD_NUMBER = 4;
        public static final int MESSAGE_FIELD_NUMBER = 2;
        public static final int PAGE_URL_FIELD_NUMBER = 8;
        private static volatile Parser<JsError> PARSER = null;
        public static final int RELATIVE_TIME_FIELD_NUMBER = 1;
        public static final int UNIX_TIMESTAMP_MS_FIELD_NUMBER = 7;
        private int bitField0_;
        private int colNumber_;
        private int lineNumber_;
        private long relativeTime_;
        private long unixTimestampMs_;
        private String message_ = "";
        private String filename_ = "";
        private String errorSource_ = "";
        private String pageUrl_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<JsError, Builder> implements JsErrorOrBuilder {
            private Builder() {
                super(JsError.DEFAULT_INSTANCE);
            }

            public Builder clearColNumber() {
                copyOnWrite();
                ((JsError) this.instance).clearColNumber();
                return this;
            }

            public Builder clearErrorSource() {
                copyOnWrite();
                ((JsError) this.instance).clearErrorSource();
                return this;
            }

            public Builder clearFilename() {
                copyOnWrite();
                ((JsError) this.instance).clearFilename();
                return this;
            }

            public Builder clearLineNumber() {
                copyOnWrite();
                ((JsError) this.instance).clearLineNumber();
                return this;
            }

            public Builder clearMessage() {
                copyOnWrite();
                ((JsError) this.instance).clearMessage();
                return this;
            }

            public Builder clearPageUrl() {
                copyOnWrite();
                ((JsError) this.instance).clearPageUrl();
                return this;
            }

            public Builder clearRelativeTime() {
                copyOnWrite();
                ((JsError) this.instance).clearRelativeTime();
                return this;
            }

            public Builder clearUnixTimestampMs() {
                copyOnWrite();
                ((JsError) this.instance).clearUnixTimestampMs();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
            public int getColNumber() {
                return ((JsError) this.instance).getColNumber();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
            public String getErrorSource() {
                return ((JsError) this.instance).getErrorSource();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
            public ByteString getErrorSourceBytes() {
                return ((JsError) this.instance).getErrorSourceBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
            public String getFilename() {
                return ((JsError) this.instance).getFilename();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
            public ByteString getFilenameBytes() {
                return ((JsError) this.instance).getFilenameBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
            public int getLineNumber() {
                return ((JsError) this.instance).getLineNumber();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
            public String getMessage() {
                return ((JsError) this.instance).getMessage();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
            public ByteString getMessageBytes() {
                return ((JsError) this.instance).getMessageBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
            public String getPageUrl() {
                return ((JsError) this.instance).getPageUrl();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
            public ByteString getPageUrlBytes() {
                return ((JsError) this.instance).getPageUrlBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
            public long getRelativeTime() {
                return ((JsError) this.instance).getRelativeTime();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
            public long getUnixTimestampMs() {
                return ((JsError) this.instance).getUnixTimestampMs();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
            public boolean hasErrorSource() {
                return ((JsError) this.instance).hasErrorSource();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
            public boolean hasFilename() {
                return ((JsError) this.instance).hasFilename();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
            public boolean hasPageUrl() {
                return ((JsError) this.instance).hasPageUrl();
            }

            public Builder setColNumber(int i) {
                copyOnWrite();
                ((JsError) this.instance).setColNumber(i);
                return this;
            }

            public Builder setErrorSource(String str) {
                copyOnWrite();
                ((JsError) this.instance).setErrorSource(str);
                return this;
            }

            public Builder setErrorSourceBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((JsError) this.instance).setErrorSourceBytes(byteString);
                return this;
            }

            public Builder setFilename(String str) {
                copyOnWrite();
                ((JsError) this.instance).setFilename(str);
                return this;
            }

            public Builder setFilenameBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((JsError) this.instance).setFilenameBytes(byteString);
                return this;
            }

            public Builder setLineNumber(int i) {
                copyOnWrite();
                ((JsError) this.instance).setLineNumber(i);
                return this;
            }

            public Builder setMessage(String str) {
                copyOnWrite();
                ((JsError) this.instance).setMessage(str);
                return this;
            }

            public Builder setMessageBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((JsError) this.instance).setMessageBytes(byteString);
                return this;
            }

            public Builder setPageUrl(String str) {
                copyOnWrite();
                ((JsError) this.instance).setPageUrl(str);
                return this;
            }

            public Builder setPageUrlBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((JsError) this.instance).setPageUrlBytes(byteString);
                return this;
            }

            public Builder setRelativeTime(long j) {
                copyOnWrite();
                ((JsError) this.instance).setRelativeTime(j);
                return this;
            }

            public Builder setUnixTimestampMs(long j) {
                copyOnWrite();
                ((JsError) this.instance).setUnixTimestampMs(j);
                return this;
            }
        }

        static {
            JsError jsError = new JsError();
            DEFAULT_INSTANCE = jsError;
            GeneratedMessageLite.registerDefaultInstance(JsError.class, jsError);
        }

        private JsError() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearColNumber() {
            this.colNumber_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearErrorSource() {
            this.bitField0_ &= -3;
            this.errorSource_ = getDefaultInstance().getErrorSource();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFilename() {
            this.bitField0_ &= -2;
            this.filename_ = getDefaultInstance().getFilename();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLineNumber() {
            this.lineNumber_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMessage() {
            this.message_ = getDefaultInstance().getMessage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPageUrl() {
            this.bitField0_ &= -5;
            this.pageUrl_ = getDefaultInstance().getPageUrl();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRelativeTime() {
            this.relativeTime_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnixTimestampMs() {
            this.unixTimestampMs_ = 0L;
        }

        public static JsError getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static JsError parseDelimitedFrom(InputStream inputStream) {
            return (JsError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static JsError parseFrom(ByteString byteString) {
            return (JsError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<JsError> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setColNumber(int i) {
            this.colNumber_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrorSource(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.errorSource_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrorSourceBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.errorSource_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFilename(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.filename_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFilenameBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.filename_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLineNumber(int i) {
            this.lineNumber_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessage(String str) {
            str.getClass();
            this.message_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessageBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.message_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPageUrl(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.pageUrl_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPageUrlBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.pageUrl_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRelativeTime(long j) {
            this.relativeTime_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnixTimestampMs(long j) {
            this.unixTimestampMs_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new JsError();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u0003\u0002Ȉ\u0003ለ\u0000\u0004\u000b\u0005\u000b\u0006ለ\u0001\u0007\u0003\bለ\u0002", new Object[]{"bitField0_", "relativeTime_", "message_", "filename_", "lineNumber_", "colNumber_", "errorSource_", "unixTimestampMs_", "pageUrl_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<JsError> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (JsError.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
        public int getColNumber() {
            return this.colNumber_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
        public String getErrorSource() {
            return this.errorSource_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
        public ByteString getErrorSourceBytes() {
            return ByteString.copyFromUtf8(this.errorSource_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
        public String getFilename() {
            return this.filename_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
        public ByteString getFilenameBytes() {
            return ByteString.copyFromUtf8(this.filename_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
        public int getLineNumber() {
            return this.lineNumber_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
        public String getMessage() {
            return this.message_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
        public ByteString getMessageBytes() {
            return ByteString.copyFromUtf8(this.message_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
        public String getPageUrl() {
            return this.pageUrl_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
        public ByteString getPageUrlBytes() {
            return ByteString.copyFromUtf8(this.pageUrl_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
        public long getRelativeTime() {
            return this.relativeTime_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
        public long getUnixTimestampMs() {
            return this.unixTimestampMs_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
        public boolean hasErrorSource() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
        public boolean hasFilename() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.JsErrorOrBuilder
        public boolean hasPageUrl() {
            return (this.bitField0_ & 4) != 0;
        }

        public static Builder newBuilder(JsError jsError) {
            return DEFAULT_INSTANCE.createBuilder(jsError);
        }

        public static JsError parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (JsError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static JsError parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (JsError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static JsError parseFrom(CodedInputStream codedInputStream) {
            return (JsError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static JsError parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (JsError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static JsError parseFrom(InputStream inputStream) {
            return (JsError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static JsError parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (JsError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static JsError parseFrom(ByteBuffer byteBuffer) {
            return (JsError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static JsError parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (JsError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static JsError parseFrom(byte[] bArr) {
            return (JsError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static JsError parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (JsError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface JsErrorOrBuilder extends MessageLiteOrBuilder {
        int getColNumber();

        String getErrorSource();

        ByteString getErrorSourceBytes();

        String getFilename();

        ByteString getFilenameBytes();

        int getLineNumber();

        String getMessage();

        ByteString getMessageBytes();

        String getPageUrl();

        ByteString getPageUrlBytes();

        long getRelativeTime();

        long getUnixTimestampMs();

        boolean hasErrorSource();

        boolean hasFilename();

        boolean hasPageUrl();
    }

    public static final class MoveMutation extends GeneratedMessageLite<MoveMutation, Builder> implements MoveMutationOrBuilder {
        private static final MoveMutation DEFAULT_INSTANCE;
        public static final int INDEX_IN_PARENT_FIELD_NUMBER = 4;
        public static final int NEW_PARENT_VIEW_ID_FIELD_NUMBER = 3;
        private static volatile Parser<MoveMutation> PARSER = null;
        public static final int UNIX_TIMESTAMP_MS_FIELD_NUMBER = 1;
        public static final int VIEW_ID_FIELD_NUMBER = 2;
        private int indexInParent_;
        private long newParentViewId_;
        private long unixTimestampMs_;
        private long viewId_;

        public static final class Builder extends GeneratedMessageLite.Builder<MoveMutation, Builder> implements MoveMutationOrBuilder {
            private Builder() {
                super(MoveMutation.DEFAULT_INSTANCE);
            }

            public Builder clearIndexInParent() {
                copyOnWrite();
                ((MoveMutation) this.instance).clearIndexInParent();
                return this;
            }

            public Builder clearNewParentViewId() {
                copyOnWrite();
                ((MoveMutation) this.instance).clearNewParentViewId();
                return this;
            }

            public Builder clearUnixTimestampMs() {
                copyOnWrite();
                ((MoveMutation) this.instance).clearUnixTimestampMs();
                return this;
            }

            public Builder clearViewId() {
                copyOnWrite();
                ((MoveMutation) this.instance).clearViewId();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.MoveMutationOrBuilder
            public int getIndexInParent() {
                return ((MoveMutation) this.instance).getIndexInParent();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.MoveMutationOrBuilder
            public long getNewParentViewId() {
                return ((MoveMutation) this.instance).getNewParentViewId();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.MoveMutationOrBuilder
            public long getUnixTimestampMs() {
                return ((MoveMutation) this.instance).getUnixTimestampMs();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.MoveMutationOrBuilder
            public long getViewId() {
                return ((MoveMutation) this.instance).getViewId();
            }

            public Builder setIndexInParent(int i) {
                copyOnWrite();
                ((MoveMutation) this.instance).setIndexInParent(i);
                return this;
            }

            public Builder setNewParentViewId(long j) {
                copyOnWrite();
                ((MoveMutation) this.instance).setNewParentViewId(j);
                return this;
            }

            public Builder setUnixTimestampMs(long j) {
                copyOnWrite();
                ((MoveMutation) this.instance).setUnixTimestampMs(j);
                return this;
            }

            public Builder setViewId(long j) {
                copyOnWrite();
                ((MoveMutation) this.instance).setViewId(j);
                return this;
            }
        }

        static {
            MoveMutation moveMutation = new MoveMutation();
            DEFAULT_INSTANCE = moveMutation;
            GeneratedMessageLite.registerDefaultInstance(MoveMutation.class, moveMutation);
        }

        private MoveMutation() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIndexInParent() {
            this.indexInParent_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNewParentViewId() {
            this.newParentViewId_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnixTimestampMs() {
            this.unixTimestampMs_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearViewId() {
            this.viewId_ = 0L;
        }

        public static MoveMutation getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static MoveMutation parseDelimitedFrom(InputStream inputStream) {
            return (MoveMutation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MoveMutation parseFrom(ByteString byteString) {
            return (MoveMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<MoveMutation> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIndexInParent(int i) {
            this.indexInParent_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNewParentViewId(long j) {
            this.newParentViewId_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnixTimestampMs(long j) {
            this.unixTimestampMs_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setViewId(long j) {
            this.viewId_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new MoveMutation();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0003\u0002\u0010\u0003\u0010\u0004\u000b", new Object[]{"unixTimestampMs_", "viewId_", "newParentViewId_", "indexInParent_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MoveMutation> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (MoveMutation.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.MoveMutationOrBuilder
        public int getIndexInParent() {
            return this.indexInParent_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.MoveMutationOrBuilder
        public long getNewParentViewId() {
            return this.newParentViewId_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.MoveMutationOrBuilder
        public long getUnixTimestampMs() {
            return this.unixTimestampMs_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.MoveMutationOrBuilder
        public long getViewId() {
            return this.viewId_;
        }

        public static Builder newBuilder(MoveMutation moveMutation) {
            return DEFAULT_INSTANCE.createBuilder(moveMutation);
        }

        public static MoveMutation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (MoveMutation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MoveMutation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (MoveMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MoveMutation parseFrom(CodedInputStream codedInputStream) {
            return (MoveMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MoveMutation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (MoveMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static MoveMutation parseFrom(InputStream inputStream) {
            return (MoveMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MoveMutation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (MoveMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MoveMutation parseFrom(ByteBuffer byteBuffer) {
            return (MoveMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static MoveMutation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (MoveMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static MoveMutation parseFrom(byte[] bArr) {
            return (MoveMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static MoveMutation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (MoveMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface MoveMutationOrBuilder extends MessageLiteOrBuilder {
        int getIndexInParent();

        long getNewParentViewId();

        long getUnixTimestampMs();

        long getViewId();
    }

    public static final class NetworkRequestMetric extends GeneratedMessageLite<NetworkRequestMetric, Builder> implements NetworkRequestMetricOrBuilder {
        public static final int CUSTOM_REQUEST_HEADERS_FIELD_NUMBER = 9;
        public static final int CUSTOM_RESPONSE_HEADERS_FIELD_NUMBER = 10;
        private static final NetworkRequestMetric DEFAULT_INSTANCE;
        public static final int ENCRYPTED_SYMMETRIC_KEY_FIELD_NUMBER = 13;
        public static final int ENCYPTION_PUBLIC_KEY_ID_FIELD_NUMBER = 14;
        public static final int HTTP_METHOD_FIELD_NUMBER = 3;
        public static final int INITIALIZATION_VECTOR_FIELD_NUMBER = 12;
        private static volatile Parser<NetworkRequestMetric> PARSER = null;
        public static final int PLAIN_CUSTOM_REQUEST_HEADERS_FIELD_NUMBER = 18;
        public static final int PLAIN_CUSTOM_RESPONSE_HEADERS_FIELD_NUMBER = 19;
        public static final int PLAIN_REQUEST_BODY_ATTRIBUTES_FIELD_NUMBER = 20;
        public static final int PLAIN_RESPONSE_BODY_ATTRIBUTES_FIELD_NUMBER = 22;
        public static final int QUERY_PARAMETERS_FIELD_NUMBER = 11;
        public static final int REQUEST_BODY_ATTRIBUTES_FIELD_NUMBER = 21;
        public static final int REQUEST_BODY_FIELD_NUMBER = 15;
        public static final int REQUEST_TIME_FIELD_NUMBER = 4;
        public static final int RESPONSE_BODY_ATTRIBUTES_FIELD_NUMBER = 23;
        public static final int RESPONSE_BODY_FIELD_NUMBER = 16;
        public static final int RESPONSE_TIME_FIELD_NUMBER = 5;
        public static final int SOURCE_FIELD_NUMBER = 17;
        public static final int STANDARD_REQUEST_HEADERS_FIELD_NUMBER = 7;
        public static final int STANDARD_RESPONSE_HEADERS_FIELD_NUMBER = 8;
        public static final int STATUS_CODE_FIELD_NUMBER = 6;
        public static final int UNIX_TIMESTAMP_MS_FIELD_NUMBER = 1;
        public static final int URL_FIELD_NUMBER = 2;
        private int bitField0_;
        private ByteString customRequestHeaders_;
        private ByteString customResponseHeaders_;
        private ByteString encryptedSymmetricKey_;
        private long encyptionPublicKeyId_;
        private ByteString initializationVector_;
        private ByteString queryParameters_;
        private ByteString requestBodyAttributes_;
        private ByteString requestBody_;
        private long requestTime_;
        private ByteString responseBodyAttributes_;
        private ByteString responseBody_;
        private long responseTime_;
        private String source_;
        private int statusCode_;
        private long unixTimestampMs_;
        private MapFieldLite<String, String> standardRequestHeaders_ = MapFieldLite.emptyMapField();
        private MapFieldLite<String, String> standardResponseHeaders_ = MapFieldLite.emptyMapField();
        private MapFieldLite<String, String> plainCustomRequestHeaders_ = MapFieldLite.emptyMapField();
        private MapFieldLite<String, String> plainCustomResponseHeaders_ = MapFieldLite.emptyMapField();
        private MapFieldLite<String, String> plainRequestBodyAttributes_ = MapFieldLite.emptyMapField();
        private MapFieldLite<String, String> plainResponseBodyAttributes_ = MapFieldLite.emptyMapField();
        private String url_ = "";
        private String httpMethod_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<NetworkRequestMetric, Builder> implements NetworkRequestMetricOrBuilder {
            private Builder() {
                super(NetworkRequestMetric.DEFAULT_INSTANCE);
            }

            public Builder clearCustomRequestHeaders() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).clearCustomRequestHeaders();
                return this;
            }

            public Builder clearCustomResponseHeaders() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).clearCustomResponseHeaders();
                return this;
            }

            public Builder clearEncryptedSymmetricKey() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).clearEncryptedSymmetricKey();
                return this;
            }

            public Builder clearEncyptionPublicKeyId() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).clearEncyptionPublicKeyId();
                return this;
            }

            public Builder clearHttpMethod() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).clearHttpMethod();
                return this;
            }

            public Builder clearInitializationVector() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).clearInitializationVector();
                return this;
            }

            public Builder clearPlainCustomRequestHeaders() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutablePlainCustomRequestHeadersMap().clear();
                return this;
            }

            public Builder clearPlainCustomResponseHeaders() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutablePlainCustomResponseHeadersMap().clear();
                return this;
            }

            public Builder clearPlainRequestBodyAttributes() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutablePlainRequestBodyAttributesMap().clear();
                return this;
            }

            public Builder clearPlainResponseBodyAttributes() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutablePlainResponseBodyAttributesMap().clear();
                return this;
            }

            public Builder clearQueryParameters() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).clearQueryParameters();
                return this;
            }

            public Builder clearRequestBody() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).clearRequestBody();
                return this;
            }

            public Builder clearRequestBodyAttributes() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).clearRequestBodyAttributes();
                return this;
            }

            public Builder clearRequestTime() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).clearRequestTime();
                return this;
            }

            public Builder clearResponseBody() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).clearResponseBody();
                return this;
            }

            public Builder clearResponseBodyAttributes() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).clearResponseBodyAttributes();
                return this;
            }

            public Builder clearResponseTime() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).clearResponseTime();
                return this;
            }

            public Builder clearSource() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).clearSource();
                return this;
            }

            public Builder clearStandardRequestHeaders() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutableStandardRequestHeadersMap().clear();
                return this;
            }

            public Builder clearStandardResponseHeaders() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutableStandardResponseHeadersMap().clear();
                return this;
            }

            public Builder clearStatusCode() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).clearStatusCode();
                return this;
            }

            public Builder clearUnixTimestampMs() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).clearUnixTimestampMs();
                return this;
            }

            public Builder clearUrl() {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).clearUrl();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public boolean containsPlainCustomRequestHeaders(String str) {
                str.getClass();
                return ((NetworkRequestMetric) this.instance).getPlainCustomRequestHeadersMap().containsKey(str);
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public boolean containsPlainCustomResponseHeaders(String str) {
                str.getClass();
                return ((NetworkRequestMetric) this.instance).getPlainCustomResponseHeadersMap().containsKey(str);
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public boolean containsPlainRequestBodyAttributes(String str) {
                str.getClass();
                return ((NetworkRequestMetric) this.instance).getPlainRequestBodyAttributesMap().containsKey(str);
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public boolean containsPlainResponseBodyAttributes(String str) {
                str.getClass();
                return ((NetworkRequestMetric) this.instance).getPlainResponseBodyAttributesMap().containsKey(str);
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public boolean containsStandardRequestHeaders(String str) {
                str.getClass();
                return ((NetworkRequestMetric) this.instance).getStandardRequestHeadersMap().containsKey(str);
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public boolean containsStandardResponseHeaders(String str) {
                str.getClass();
                return ((NetworkRequestMetric) this.instance).getStandardResponseHeadersMap().containsKey(str);
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public ByteString getCustomRequestHeaders() {
                return ((NetworkRequestMetric) this.instance).getCustomRequestHeaders();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public ByteString getCustomResponseHeaders() {
                return ((NetworkRequestMetric) this.instance).getCustomResponseHeaders();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public ByteString getEncryptedSymmetricKey() {
                return ((NetworkRequestMetric) this.instance).getEncryptedSymmetricKey();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public long getEncyptionPublicKeyId() {
                return ((NetworkRequestMetric) this.instance).getEncyptionPublicKeyId();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public String getHttpMethod() {
                return ((NetworkRequestMetric) this.instance).getHttpMethod();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public ByteString getHttpMethodBytes() {
                return ((NetworkRequestMetric) this.instance).getHttpMethodBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public ByteString getInitializationVector() {
                return ((NetworkRequestMetric) this.instance).getInitializationVector();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            @Deprecated
            public Map<String, String> getPlainCustomRequestHeaders() {
                return getPlainCustomRequestHeadersMap();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public int getPlainCustomRequestHeadersCount() {
                return ((NetworkRequestMetric) this.instance).getPlainCustomRequestHeadersMap().size();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public Map<String, String> getPlainCustomRequestHeadersMap() {
                return Collections.unmodifiableMap(((NetworkRequestMetric) this.instance).getPlainCustomRequestHeadersMap());
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public String getPlainCustomRequestHeadersOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> plainCustomRequestHeadersMap = ((NetworkRequestMetric) this.instance).getPlainCustomRequestHeadersMap();
                return plainCustomRequestHeadersMap.containsKey(str) ? plainCustomRequestHeadersMap.get(str) : str2;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public String getPlainCustomRequestHeadersOrThrow(String str) {
                str.getClass();
                Map<String, String> plainCustomRequestHeadersMap = ((NetworkRequestMetric) this.instance).getPlainCustomRequestHeadersMap();
                if (plainCustomRequestHeadersMap.containsKey(str)) {
                    return plainCustomRequestHeadersMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            @Deprecated
            public Map<String, String> getPlainCustomResponseHeaders() {
                return getPlainCustomResponseHeadersMap();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public int getPlainCustomResponseHeadersCount() {
                return ((NetworkRequestMetric) this.instance).getPlainCustomResponseHeadersMap().size();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public Map<String, String> getPlainCustomResponseHeadersMap() {
                return Collections.unmodifiableMap(((NetworkRequestMetric) this.instance).getPlainCustomResponseHeadersMap());
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public String getPlainCustomResponseHeadersOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> plainCustomResponseHeadersMap = ((NetworkRequestMetric) this.instance).getPlainCustomResponseHeadersMap();
                return plainCustomResponseHeadersMap.containsKey(str) ? plainCustomResponseHeadersMap.get(str) : str2;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public String getPlainCustomResponseHeadersOrThrow(String str) {
                str.getClass();
                Map<String, String> plainCustomResponseHeadersMap = ((NetworkRequestMetric) this.instance).getPlainCustomResponseHeadersMap();
                if (plainCustomResponseHeadersMap.containsKey(str)) {
                    return plainCustomResponseHeadersMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            @Deprecated
            public Map<String, String> getPlainRequestBodyAttributes() {
                return getPlainRequestBodyAttributesMap();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public int getPlainRequestBodyAttributesCount() {
                return ((NetworkRequestMetric) this.instance).getPlainRequestBodyAttributesMap().size();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public Map<String, String> getPlainRequestBodyAttributesMap() {
                return Collections.unmodifiableMap(((NetworkRequestMetric) this.instance).getPlainRequestBodyAttributesMap());
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public String getPlainRequestBodyAttributesOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> plainRequestBodyAttributesMap = ((NetworkRequestMetric) this.instance).getPlainRequestBodyAttributesMap();
                return plainRequestBodyAttributesMap.containsKey(str) ? plainRequestBodyAttributesMap.get(str) : str2;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public String getPlainRequestBodyAttributesOrThrow(String str) {
                str.getClass();
                Map<String, String> plainRequestBodyAttributesMap = ((NetworkRequestMetric) this.instance).getPlainRequestBodyAttributesMap();
                if (plainRequestBodyAttributesMap.containsKey(str)) {
                    return plainRequestBodyAttributesMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            @Deprecated
            public Map<String, String> getPlainResponseBodyAttributes() {
                return getPlainResponseBodyAttributesMap();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public int getPlainResponseBodyAttributesCount() {
                return ((NetworkRequestMetric) this.instance).getPlainResponseBodyAttributesMap().size();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public Map<String, String> getPlainResponseBodyAttributesMap() {
                return Collections.unmodifiableMap(((NetworkRequestMetric) this.instance).getPlainResponseBodyAttributesMap());
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public String getPlainResponseBodyAttributesOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> plainResponseBodyAttributesMap = ((NetworkRequestMetric) this.instance).getPlainResponseBodyAttributesMap();
                return plainResponseBodyAttributesMap.containsKey(str) ? plainResponseBodyAttributesMap.get(str) : str2;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public String getPlainResponseBodyAttributesOrThrow(String str) {
                str.getClass();
                Map<String, String> plainResponseBodyAttributesMap = ((NetworkRequestMetric) this.instance).getPlainResponseBodyAttributesMap();
                if (plainResponseBodyAttributesMap.containsKey(str)) {
                    return plainResponseBodyAttributesMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public ByteString getQueryParameters() {
                return ((NetworkRequestMetric) this.instance).getQueryParameters();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public ByteString getRequestBody() {
                return ((NetworkRequestMetric) this.instance).getRequestBody();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public ByteString getRequestBodyAttributes() {
                return ((NetworkRequestMetric) this.instance).getRequestBodyAttributes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public long getRequestTime() {
                return ((NetworkRequestMetric) this.instance).getRequestTime();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public ByteString getResponseBody() {
                return ((NetworkRequestMetric) this.instance).getResponseBody();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public ByteString getResponseBodyAttributes() {
                return ((NetworkRequestMetric) this.instance).getResponseBodyAttributes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public long getResponseTime() {
                return ((NetworkRequestMetric) this.instance).getResponseTime();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public String getSource() {
                return ((NetworkRequestMetric) this.instance).getSource();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public ByteString getSourceBytes() {
                return ((NetworkRequestMetric) this.instance).getSourceBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            @Deprecated
            public Map<String, String> getStandardRequestHeaders() {
                return getStandardRequestHeadersMap();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public int getStandardRequestHeadersCount() {
                return ((NetworkRequestMetric) this.instance).getStandardRequestHeadersMap().size();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public Map<String, String> getStandardRequestHeadersMap() {
                return Collections.unmodifiableMap(((NetworkRequestMetric) this.instance).getStandardRequestHeadersMap());
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public String getStandardRequestHeadersOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> standardRequestHeadersMap = ((NetworkRequestMetric) this.instance).getStandardRequestHeadersMap();
                return standardRequestHeadersMap.containsKey(str) ? standardRequestHeadersMap.get(str) : str2;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public String getStandardRequestHeadersOrThrow(String str) {
                str.getClass();
                Map<String, String> standardRequestHeadersMap = ((NetworkRequestMetric) this.instance).getStandardRequestHeadersMap();
                if (standardRequestHeadersMap.containsKey(str)) {
                    return standardRequestHeadersMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            @Deprecated
            public Map<String, String> getStandardResponseHeaders() {
                return getStandardResponseHeadersMap();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public int getStandardResponseHeadersCount() {
                return ((NetworkRequestMetric) this.instance).getStandardResponseHeadersMap().size();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public Map<String, String> getStandardResponseHeadersMap() {
                return Collections.unmodifiableMap(((NetworkRequestMetric) this.instance).getStandardResponseHeadersMap());
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public String getStandardResponseHeadersOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> standardResponseHeadersMap = ((NetworkRequestMetric) this.instance).getStandardResponseHeadersMap();
                return standardResponseHeadersMap.containsKey(str) ? standardResponseHeadersMap.get(str) : str2;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public String getStandardResponseHeadersOrThrow(String str) {
                str.getClass();
                Map<String, String> standardResponseHeadersMap = ((NetworkRequestMetric) this.instance).getStandardResponseHeadersMap();
                if (standardResponseHeadersMap.containsKey(str)) {
                    return standardResponseHeadersMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public int getStatusCode() {
                return ((NetworkRequestMetric) this.instance).getStatusCode();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public long getUnixTimestampMs() {
                return ((NetworkRequestMetric) this.instance).getUnixTimestampMs();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public String getUrl() {
                return ((NetworkRequestMetric) this.instance).getUrl();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public ByteString getUrlBytes() {
                return ((NetworkRequestMetric) this.instance).getUrlBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public boolean hasCustomRequestHeaders() {
                return ((NetworkRequestMetric) this.instance).hasCustomRequestHeaders();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public boolean hasCustomResponseHeaders() {
                return ((NetworkRequestMetric) this.instance).hasCustomResponseHeaders();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public boolean hasEncryptedSymmetricKey() {
                return ((NetworkRequestMetric) this.instance).hasEncryptedSymmetricKey();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public boolean hasEncyptionPublicKeyId() {
                return ((NetworkRequestMetric) this.instance).hasEncyptionPublicKeyId();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public boolean hasInitializationVector() {
                return ((NetworkRequestMetric) this.instance).hasInitializationVector();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public boolean hasQueryParameters() {
                return ((NetworkRequestMetric) this.instance).hasQueryParameters();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public boolean hasRequestBody() {
                return ((NetworkRequestMetric) this.instance).hasRequestBody();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public boolean hasRequestBodyAttributes() {
                return ((NetworkRequestMetric) this.instance).hasRequestBodyAttributes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public boolean hasResponseBody() {
                return ((NetworkRequestMetric) this.instance).hasResponseBody();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public boolean hasResponseBodyAttributes() {
                return ((NetworkRequestMetric) this.instance).hasResponseBodyAttributes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
            public boolean hasSource() {
                return ((NetworkRequestMetric) this.instance).hasSource();
            }

            public Builder putAllPlainCustomRequestHeaders(Map<String, String> map) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutablePlainCustomRequestHeadersMap().putAll(map);
                return this;
            }

            public Builder putAllPlainCustomResponseHeaders(Map<String, String> map) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutablePlainCustomResponseHeadersMap().putAll(map);
                return this;
            }

            public Builder putAllPlainRequestBodyAttributes(Map<String, String> map) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutablePlainRequestBodyAttributesMap().putAll(map);
                return this;
            }

            public Builder putAllPlainResponseBodyAttributes(Map<String, String> map) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutablePlainResponseBodyAttributesMap().putAll(map);
                return this;
            }

            public Builder putAllStandardRequestHeaders(Map<String, String> map) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutableStandardRequestHeadersMap().putAll(map);
                return this;
            }

            public Builder putAllStandardResponseHeaders(Map<String, String> map) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutableStandardResponseHeadersMap().putAll(map);
                return this;
            }

            public Builder putPlainCustomRequestHeaders(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutablePlainCustomRequestHeadersMap().put(str, str2);
                return this;
            }

            public Builder putPlainCustomResponseHeaders(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutablePlainCustomResponseHeadersMap().put(str, str2);
                return this;
            }

            public Builder putPlainRequestBodyAttributes(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutablePlainRequestBodyAttributesMap().put(str, str2);
                return this;
            }

            public Builder putPlainResponseBodyAttributes(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutablePlainResponseBodyAttributesMap().put(str, str2);
                return this;
            }

            public Builder putStandardRequestHeaders(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutableStandardRequestHeadersMap().put(str, str2);
                return this;
            }

            public Builder putStandardResponseHeaders(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutableStandardResponseHeadersMap().put(str, str2);
                return this;
            }

            public Builder removePlainCustomRequestHeaders(String str) {
                str.getClass();
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutablePlainCustomRequestHeadersMap().remove(str);
                return this;
            }

            public Builder removePlainCustomResponseHeaders(String str) {
                str.getClass();
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutablePlainCustomResponseHeadersMap().remove(str);
                return this;
            }

            public Builder removePlainRequestBodyAttributes(String str) {
                str.getClass();
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutablePlainRequestBodyAttributesMap().remove(str);
                return this;
            }

            public Builder removePlainResponseBodyAttributes(String str) {
                str.getClass();
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutablePlainResponseBodyAttributesMap().remove(str);
                return this;
            }

            public Builder removeStandardRequestHeaders(String str) {
                str.getClass();
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutableStandardRequestHeadersMap().remove(str);
                return this;
            }

            public Builder removeStandardResponseHeaders(String str) {
                str.getClass();
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).getMutableStandardResponseHeadersMap().remove(str);
                return this;
            }

            public Builder setCustomRequestHeaders(ByteString byteString) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).setCustomRequestHeaders(byteString);
                return this;
            }

            public Builder setCustomResponseHeaders(ByteString byteString) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).setCustomResponseHeaders(byteString);
                return this;
            }

            public Builder setEncryptedSymmetricKey(ByteString byteString) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).setEncryptedSymmetricKey(byteString);
                return this;
            }

            public Builder setEncyptionPublicKeyId(long j) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).setEncyptionPublicKeyId(j);
                return this;
            }

            public Builder setHttpMethod(String str) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).setHttpMethod(str);
                return this;
            }

            public Builder setHttpMethodBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).setHttpMethodBytes(byteString);
                return this;
            }

            public Builder setInitializationVector(ByteString byteString) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).setInitializationVector(byteString);
                return this;
            }

            public Builder setQueryParameters(ByteString byteString) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).setQueryParameters(byteString);
                return this;
            }

            public Builder setRequestBody(ByteString byteString) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).setRequestBody(byteString);
                return this;
            }

            public Builder setRequestBodyAttributes(ByteString byteString) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).setRequestBodyAttributes(byteString);
                return this;
            }

            public Builder setRequestTime(long j) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).setRequestTime(j);
                return this;
            }

            public Builder setResponseBody(ByteString byteString) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).setResponseBody(byteString);
                return this;
            }

            public Builder setResponseBodyAttributes(ByteString byteString) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).setResponseBodyAttributes(byteString);
                return this;
            }

            public Builder setResponseTime(long j) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).setResponseTime(j);
                return this;
            }

            public Builder setSource(String str) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).setSource(str);
                return this;
            }

            public Builder setSourceBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).setSourceBytes(byteString);
                return this;
            }

            public Builder setStatusCode(int i) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).setStatusCode(i);
                return this;
            }

            public Builder setUnixTimestampMs(long j) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).setUnixTimestampMs(j);
                return this;
            }

            public Builder setUrl(String str) {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).setUrl(str);
                return this;
            }

            public Builder setUrlBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((NetworkRequestMetric) this.instance).setUrlBytes(byteString);
                return this;
            }
        }

        public static final class PlainCustomRequestHeadersDefaultEntryHolder {
            static final MapEntryLite<String, String> defaultEntry;

            static {
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
            }

            private PlainCustomRequestHeadersDefaultEntryHolder() {
            }
        }

        public static final class PlainCustomResponseHeadersDefaultEntryHolder {
            static final MapEntryLite<String, String> defaultEntry;

            static {
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
            }

            private PlainCustomResponseHeadersDefaultEntryHolder() {
            }
        }

        public static final class PlainRequestBodyAttributesDefaultEntryHolder {
            static final MapEntryLite<String, String> defaultEntry;

            static {
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
            }

            private PlainRequestBodyAttributesDefaultEntryHolder() {
            }
        }

        public static final class PlainResponseBodyAttributesDefaultEntryHolder {
            static final MapEntryLite<String, String> defaultEntry;

            static {
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
            }

            private PlainResponseBodyAttributesDefaultEntryHolder() {
            }
        }

        public static final class StandardRequestHeadersDefaultEntryHolder {
            static final MapEntryLite<String, String> defaultEntry;

            static {
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
            }

            private StandardRequestHeadersDefaultEntryHolder() {
            }
        }

        public static final class StandardResponseHeadersDefaultEntryHolder {
            static final MapEntryLite<String, String> defaultEntry;

            static {
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                defaultEntry = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
            }

            private StandardResponseHeadersDefaultEntryHolder() {
            }
        }

        static {
            NetworkRequestMetric networkRequestMetric = new NetworkRequestMetric();
            DEFAULT_INSTANCE = networkRequestMetric;
            GeneratedMessageLite.registerDefaultInstance(NetworkRequestMetric.class, networkRequestMetric);
        }

        private NetworkRequestMetric() {
            ByteString byteString = ByteString.EMPTY;
            this.customRequestHeaders_ = byteString;
            this.customResponseHeaders_ = byteString;
            this.queryParameters_ = byteString;
            this.initializationVector_ = byteString;
            this.encryptedSymmetricKey_ = byteString;
            this.requestBody_ = byteString;
            this.responseBody_ = byteString;
            this.source_ = "";
            this.requestBodyAttributes_ = byteString;
            this.responseBodyAttributes_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCustomRequestHeaders() {
            this.bitField0_ &= -2;
            this.customRequestHeaders_ = getDefaultInstance().getCustomRequestHeaders();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCustomResponseHeaders() {
            this.bitField0_ &= -3;
            this.customResponseHeaders_ = getDefaultInstance().getCustomResponseHeaders();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEncryptedSymmetricKey() {
            this.bitField0_ &= -17;
            this.encryptedSymmetricKey_ = getDefaultInstance().getEncryptedSymmetricKey();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEncyptionPublicKeyId() {
            this.bitField0_ &= -33;
            this.encyptionPublicKeyId_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHttpMethod() {
            this.httpMethod_ = getDefaultInstance().getHttpMethod();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInitializationVector() {
            this.bitField0_ &= -9;
            this.initializationVector_ = getDefaultInstance().getInitializationVector();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearQueryParameters() {
            this.bitField0_ &= -5;
            this.queryParameters_ = getDefaultInstance().getQueryParameters();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRequestBody() {
            this.bitField0_ &= -65;
            this.requestBody_ = getDefaultInstance().getRequestBody();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRequestBodyAttributes() {
            this.bitField0_ &= -513;
            this.requestBodyAttributes_ = getDefaultInstance().getRequestBodyAttributes();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRequestTime() {
            this.requestTime_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearResponseBody() {
            this.bitField0_ &= -129;
            this.responseBody_ = getDefaultInstance().getResponseBody();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearResponseBodyAttributes() {
            this.bitField0_ &= -1025;
            this.responseBodyAttributes_ = getDefaultInstance().getResponseBodyAttributes();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearResponseTime() {
            this.responseTime_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSource() {
            this.bitField0_ &= -257;
            this.source_ = getDefaultInstance().getSource();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStatusCode() {
            this.statusCode_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnixTimestampMs() {
            this.unixTimestampMs_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUrl() {
            this.url_ = getDefaultInstance().getUrl();
        }

        public static NetworkRequestMetric getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutablePlainCustomRequestHeadersMap() {
            return internalGetMutablePlainCustomRequestHeaders();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutablePlainCustomResponseHeadersMap() {
            return internalGetMutablePlainCustomResponseHeaders();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutablePlainRequestBodyAttributesMap() {
            return internalGetMutablePlainRequestBodyAttributes();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutablePlainResponseBodyAttributesMap() {
            return internalGetMutablePlainResponseBodyAttributes();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableStandardRequestHeadersMap() {
            return internalGetMutableStandardRequestHeaders();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableStandardResponseHeadersMap() {
            return internalGetMutableStandardResponseHeaders();
        }

        private MapFieldLite<String, String> internalGetMutablePlainCustomRequestHeaders() {
            if (!this.plainCustomRequestHeaders_.isMutable()) {
                this.plainCustomRequestHeaders_ = this.plainCustomRequestHeaders_.mutableCopy();
            }
            return this.plainCustomRequestHeaders_;
        }

        private MapFieldLite<String, String> internalGetMutablePlainCustomResponseHeaders() {
            if (!this.plainCustomResponseHeaders_.isMutable()) {
                this.plainCustomResponseHeaders_ = this.plainCustomResponseHeaders_.mutableCopy();
            }
            return this.plainCustomResponseHeaders_;
        }

        private MapFieldLite<String, String> internalGetMutablePlainRequestBodyAttributes() {
            if (!this.plainRequestBodyAttributes_.isMutable()) {
                this.plainRequestBodyAttributes_ = this.plainRequestBodyAttributes_.mutableCopy();
            }
            return this.plainRequestBodyAttributes_;
        }

        private MapFieldLite<String, String> internalGetMutablePlainResponseBodyAttributes() {
            if (!this.plainResponseBodyAttributes_.isMutable()) {
                this.plainResponseBodyAttributes_ = this.plainResponseBodyAttributes_.mutableCopy();
            }
            return this.plainResponseBodyAttributes_;
        }

        private MapFieldLite<String, String> internalGetMutableStandardRequestHeaders() {
            if (!this.standardRequestHeaders_.isMutable()) {
                this.standardRequestHeaders_ = this.standardRequestHeaders_.mutableCopy();
            }
            return this.standardRequestHeaders_;
        }

        private MapFieldLite<String, String> internalGetMutableStandardResponseHeaders() {
            if (!this.standardResponseHeaders_.isMutable()) {
                this.standardResponseHeaders_ = this.standardResponseHeaders_.mutableCopy();
            }
            return this.standardResponseHeaders_;
        }

        private MapFieldLite<String, String> internalGetPlainCustomRequestHeaders() {
            return this.plainCustomRequestHeaders_;
        }

        private MapFieldLite<String, String> internalGetPlainCustomResponseHeaders() {
            return this.plainCustomResponseHeaders_;
        }

        private MapFieldLite<String, String> internalGetPlainRequestBodyAttributes() {
            return this.plainRequestBodyAttributes_;
        }

        private MapFieldLite<String, String> internalGetPlainResponseBodyAttributes() {
            return this.plainResponseBodyAttributes_;
        }

        private MapFieldLite<String, String> internalGetStandardRequestHeaders() {
            return this.standardRequestHeaders_;
        }

        private MapFieldLite<String, String> internalGetStandardResponseHeaders() {
            return this.standardResponseHeaders_;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static NetworkRequestMetric parseDelimitedFrom(InputStream inputStream) {
            return (NetworkRequestMetric) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static NetworkRequestMetric parseFrom(ByteString byteString) {
            return (NetworkRequestMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<NetworkRequestMetric> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCustomRequestHeaders(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.customRequestHeaders_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCustomResponseHeaders(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.customResponseHeaders_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEncryptedSymmetricKey(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.encryptedSymmetricKey_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEncyptionPublicKeyId(long j) {
            this.bitField0_ |= 32;
            this.encyptionPublicKeyId_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHttpMethod(String str) {
            str.getClass();
            this.httpMethod_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHttpMethodBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.httpMethod_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInitializationVector(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.initializationVector_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setQueryParameters(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.queryParameters_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRequestBody(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 64;
            this.requestBody_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRequestBodyAttributes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 512;
            this.requestBodyAttributes_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRequestTime(long j) {
            this.requestTime_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setResponseBody(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 128;
            this.responseBody_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setResponseBodyAttributes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1024;
            this.responseBodyAttributes_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setResponseTime(long j) {
            this.responseTime_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSource(String str) {
            str.getClass();
            this.bitField0_ |= 256;
            this.source_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSourceBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.source_ = byteString.toStringUtf8();
            this.bitField0_ |= 256;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStatusCode(int i) {
            this.statusCode_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnixTimestampMs(long j) {
            this.unixTimestampMs_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUrl(String str) {
            str.getClass();
            this.url_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUrlBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.url_ = byteString.toStringUtf8();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public boolean containsPlainCustomRequestHeaders(String str) {
            str.getClass();
            return internalGetPlainCustomRequestHeaders().containsKey(str);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public boolean containsPlainCustomResponseHeaders(String str) {
            str.getClass();
            return internalGetPlainCustomResponseHeaders().containsKey(str);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public boolean containsPlainRequestBodyAttributes(String str) {
            str.getClass();
            return internalGetPlainRequestBodyAttributes().containsKey(str);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public boolean containsPlainResponseBodyAttributes(String str) {
            str.getClass();
            return internalGetPlainResponseBodyAttributes().containsKey(str);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public boolean containsStandardRequestHeaders(String str) {
            str.getClass();
            return internalGetStandardRequestHeaders().containsKey(str);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public boolean containsStandardResponseHeaders(String str) {
            str.getClass();
            return internalGetStandardResponseHeaders().containsKey(str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new NetworkRequestMetric();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0017\u0000\u0001\u0001\u0017\u0017\u0006\u0000\u0000\u0001\u0003\u0002Ȉ\u0003Ȉ\u0004\u0003\u0005\u0003\u0006\u000b\u00072\b2\tည\u0000\nည\u0001\u000bည\u0002\fည\u0003\rည\u0004\u000eတ\u0005\u000fည\u0006\u0010ည\u0007\u0011ለ\b\u00122\u00132\u00142\u0015ည\t\u00162\u0017ည\n", new Object[]{"bitField0_", "unixTimestampMs_", "url_", "httpMethod_", "requestTime_", "responseTime_", "statusCode_", "standardRequestHeaders_", StandardRequestHeadersDefaultEntryHolder.defaultEntry, "standardResponseHeaders_", StandardResponseHeadersDefaultEntryHolder.defaultEntry, "customRequestHeaders_", "customResponseHeaders_", "queryParameters_", "initializationVector_", "encryptedSymmetricKey_", "encyptionPublicKeyId_", "requestBody_", "responseBody_", "source_", "plainCustomRequestHeaders_", PlainCustomRequestHeadersDefaultEntryHolder.defaultEntry, "plainCustomResponseHeaders_", PlainCustomResponseHeadersDefaultEntryHolder.defaultEntry, "plainRequestBodyAttributes_", PlainRequestBodyAttributesDefaultEntryHolder.defaultEntry, "requestBodyAttributes_", "plainResponseBodyAttributes_", PlainResponseBodyAttributesDefaultEntryHolder.defaultEntry, "responseBodyAttributes_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<NetworkRequestMetric> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (NetworkRequestMetric.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public ByteString getCustomRequestHeaders() {
            return this.customRequestHeaders_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public ByteString getCustomResponseHeaders() {
            return this.customResponseHeaders_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public ByteString getEncryptedSymmetricKey() {
            return this.encryptedSymmetricKey_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public long getEncyptionPublicKeyId() {
            return this.encyptionPublicKeyId_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public String getHttpMethod() {
            return this.httpMethod_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public ByteString getHttpMethodBytes() {
            return ByteString.copyFromUtf8(this.httpMethod_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public ByteString getInitializationVector() {
            return this.initializationVector_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        @Deprecated
        public Map<String, String> getPlainCustomRequestHeaders() {
            return getPlainCustomRequestHeadersMap();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public int getPlainCustomRequestHeadersCount() {
            return internalGetPlainCustomRequestHeaders().size();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public Map<String, String> getPlainCustomRequestHeadersMap() {
            return Collections.unmodifiableMap(internalGetPlainCustomRequestHeaders());
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public String getPlainCustomRequestHeadersOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetPlainCustomRequestHeaders = internalGetPlainCustomRequestHeaders();
            return mapFieldLiteInternalGetPlainCustomRequestHeaders.containsKey(str) ? mapFieldLiteInternalGetPlainCustomRequestHeaders.get(str) : str2;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public String getPlainCustomRequestHeadersOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetPlainCustomRequestHeaders = internalGetPlainCustomRequestHeaders();
            if (mapFieldLiteInternalGetPlainCustomRequestHeaders.containsKey(str)) {
                return mapFieldLiteInternalGetPlainCustomRequestHeaders.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        @Deprecated
        public Map<String, String> getPlainCustomResponseHeaders() {
            return getPlainCustomResponseHeadersMap();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public int getPlainCustomResponseHeadersCount() {
            return internalGetPlainCustomResponseHeaders().size();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public Map<String, String> getPlainCustomResponseHeadersMap() {
            return Collections.unmodifiableMap(internalGetPlainCustomResponseHeaders());
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public String getPlainCustomResponseHeadersOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetPlainCustomResponseHeaders = internalGetPlainCustomResponseHeaders();
            return mapFieldLiteInternalGetPlainCustomResponseHeaders.containsKey(str) ? mapFieldLiteInternalGetPlainCustomResponseHeaders.get(str) : str2;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public String getPlainCustomResponseHeadersOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetPlainCustomResponseHeaders = internalGetPlainCustomResponseHeaders();
            if (mapFieldLiteInternalGetPlainCustomResponseHeaders.containsKey(str)) {
                return mapFieldLiteInternalGetPlainCustomResponseHeaders.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        @Deprecated
        public Map<String, String> getPlainRequestBodyAttributes() {
            return getPlainRequestBodyAttributesMap();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public int getPlainRequestBodyAttributesCount() {
            return internalGetPlainRequestBodyAttributes().size();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public Map<String, String> getPlainRequestBodyAttributesMap() {
            return Collections.unmodifiableMap(internalGetPlainRequestBodyAttributes());
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public String getPlainRequestBodyAttributesOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetPlainRequestBodyAttributes = internalGetPlainRequestBodyAttributes();
            return mapFieldLiteInternalGetPlainRequestBodyAttributes.containsKey(str) ? mapFieldLiteInternalGetPlainRequestBodyAttributes.get(str) : str2;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public String getPlainRequestBodyAttributesOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetPlainRequestBodyAttributes = internalGetPlainRequestBodyAttributes();
            if (mapFieldLiteInternalGetPlainRequestBodyAttributes.containsKey(str)) {
                return mapFieldLiteInternalGetPlainRequestBodyAttributes.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        @Deprecated
        public Map<String, String> getPlainResponseBodyAttributes() {
            return getPlainResponseBodyAttributesMap();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public int getPlainResponseBodyAttributesCount() {
            return internalGetPlainResponseBodyAttributes().size();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public Map<String, String> getPlainResponseBodyAttributesMap() {
            return Collections.unmodifiableMap(internalGetPlainResponseBodyAttributes());
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public String getPlainResponseBodyAttributesOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetPlainResponseBodyAttributes = internalGetPlainResponseBodyAttributes();
            return mapFieldLiteInternalGetPlainResponseBodyAttributes.containsKey(str) ? mapFieldLiteInternalGetPlainResponseBodyAttributes.get(str) : str2;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public String getPlainResponseBodyAttributesOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetPlainResponseBodyAttributes = internalGetPlainResponseBodyAttributes();
            if (mapFieldLiteInternalGetPlainResponseBodyAttributes.containsKey(str)) {
                return mapFieldLiteInternalGetPlainResponseBodyAttributes.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public ByteString getQueryParameters() {
            return this.queryParameters_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public ByteString getRequestBody() {
            return this.requestBody_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public ByteString getRequestBodyAttributes() {
            return this.requestBodyAttributes_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public long getRequestTime() {
            return this.requestTime_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public ByteString getResponseBody() {
            return this.responseBody_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public ByteString getResponseBodyAttributes() {
            return this.responseBodyAttributes_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public long getResponseTime() {
            return this.responseTime_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public String getSource() {
            return this.source_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public ByteString getSourceBytes() {
            return ByteString.copyFromUtf8(this.source_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        @Deprecated
        public Map<String, String> getStandardRequestHeaders() {
            return getStandardRequestHeadersMap();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public int getStandardRequestHeadersCount() {
            return internalGetStandardRequestHeaders().size();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public Map<String, String> getStandardRequestHeadersMap() {
            return Collections.unmodifiableMap(internalGetStandardRequestHeaders());
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public String getStandardRequestHeadersOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetStandardRequestHeaders = internalGetStandardRequestHeaders();
            return mapFieldLiteInternalGetStandardRequestHeaders.containsKey(str) ? mapFieldLiteInternalGetStandardRequestHeaders.get(str) : str2;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public String getStandardRequestHeadersOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetStandardRequestHeaders = internalGetStandardRequestHeaders();
            if (mapFieldLiteInternalGetStandardRequestHeaders.containsKey(str)) {
                return mapFieldLiteInternalGetStandardRequestHeaders.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        @Deprecated
        public Map<String, String> getStandardResponseHeaders() {
            return getStandardResponseHeadersMap();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public int getStandardResponseHeadersCount() {
            return internalGetStandardResponseHeaders().size();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public Map<String, String> getStandardResponseHeadersMap() {
            return Collections.unmodifiableMap(internalGetStandardResponseHeaders());
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public String getStandardResponseHeadersOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetStandardResponseHeaders = internalGetStandardResponseHeaders();
            return mapFieldLiteInternalGetStandardResponseHeaders.containsKey(str) ? mapFieldLiteInternalGetStandardResponseHeaders.get(str) : str2;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public String getStandardResponseHeadersOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetStandardResponseHeaders = internalGetStandardResponseHeaders();
            if (mapFieldLiteInternalGetStandardResponseHeaders.containsKey(str)) {
                return mapFieldLiteInternalGetStandardResponseHeaders.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public int getStatusCode() {
            return this.statusCode_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public long getUnixTimestampMs() {
            return this.unixTimestampMs_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public String getUrl() {
            return this.url_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public ByteString getUrlBytes() {
            return ByteString.copyFromUtf8(this.url_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public boolean hasCustomRequestHeaders() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public boolean hasCustomResponseHeaders() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public boolean hasEncryptedSymmetricKey() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public boolean hasEncyptionPublicKeyId() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public boolean hasInitializationVector() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public boolean hasQueryParameters() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public boolean hasRequestBody() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public boolean hasRequestBodyAttributes() {
            return (this.bitField0_ & 512) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public boolean hasResponseBody() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public boolean hasResponseBodyAttributes() {
            return (this.bitField0_ & 1024) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkRequestMetricOrBuilder
        public boolean hasSource() {
            return (this.bitField0_ & 256) != 0;
        }

        public static Builder newBuilder(NetworkRequestMetric networkRequestMetric) {
            return DEFAULT_INSTANCE.createBuilder(networkRequestMetric);
        }

        public static NetworkRequestMetric parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (NetworkRequestMetric) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static NetworkRequestMetric parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (NetworkRequestMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static NetworkRequestMetric parseFrom(CodedInputStream codedInputStream) {
            return (NetworkRequestMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static NetworkRequestMetric parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (NetworkRequestMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static NetworkRequestMetric parseFrom(InputStream inputStream) {
            return (NetworkRequestMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static NetworkRequestMetric parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (NetworkRequestMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static NetworkRequestMetric parseFrom(ByteBuffer byteBuffer) {
            return (NetworkRequestMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static NetworkRequestMetric parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (NetworkRequestMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static NetworkRequestMetric parseFrom(byte[] bArr) {
            return (NetworkRequestMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static NetworkRequestMetric parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (NetworkRequestMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface NetworkRequestMetricOrBuilder extends MessageLiteOrBuilder {
        boolean containsPlainCustomRequestHeaders(String str);

        boolean containsPlainCustomResponseHeaders(String str);

        boolean containsPlainRequestBodyAttributes(String str);

        boolean containsPlainResponseBodyAttributes(String str);

        boolean containsStandardRequestHeaders(String str);

        boolean containsStandardResponseHeaders(String str);

        ByteString getCustomRequestHeaders();

        ByteString getCustomResponseHeaders();

        ByteString getEncryptedSymmetricKey();

        long getEncyptionPublicKeyId();

        String getHttpMethod();

        ByteString getHttpMethodBytes();

        ByteString getInitializationVector();

        @Deprecated
        Map<String, String> getPlainCustomRequestHeaders();

        int getPlainCustomRequestHeadersCount();

        Map<String, String> getPlainCustomRequestHeadersMap();

        String getPlainCustomRequestHeadersOrDefault(String str, String str2);

        String getPlainCustomRequestHeadersOrThrow(String str);

        @Deprecated
        Map<String, String> getPlainCustomResponseHeaders();

        int getPlainCustomResponseHeadersCount();

        Map<String, String> getPlainCustomResponseHeadersMap();

        String getPlainCustomResponseHeadersOrDefault(String str, String str2);

        String getPlainCustomResponseHeadersOrThrow(String str);

        @Deprecated
        Map<String, String> getPlainRequestBodyAttributes();

        int getPlainRequestBodyAttributesCount();

        Map<String, String> getPlainRequestBodyAttributesMap();

        String getPlainRequestBodyAttributesOrDefault(String str, String str2);

        String getPlainRequestBodyAttributesOrThrow(String str);

        @Deprecated
        Map<String, String> getPlainResponseBodyAttributes();

        int getPlainResponseBodyAttributesCount();

        Map<String, String> getPlainResponseBodyAttributesMap();

        String getPlainResponseBodyAttributesOrDefault(String str, String str2);

        String getPlainResponseBodyAttributesOrThrow(String str);

        ByteString getQueryParameters();

        ByteString getRequestBody();

        ByteString getRequestBodyAttributes();

        long getRequestTime();

        ByteString getResponseBody();

        ByteString getResponseBodyAttributes();

        long getResponseTime();

        String getSource();

        ByteString getSourceBytes();

        @Deprecated
        Map<String, String> getStandardRequestHeaders();

        int getStandardRequestHeadersCount();

        Map<String, String> getStandardRequestHeadersMap();

        String getStandardRequestHeadersOrDefault(String str, String str2);

        String getStandardRequestHeadersOrThrow(String str);

        @Deprecated
        Map<String, String> getStandardResponseHeaders();

        int getStandardResponseHeadersCount();

        Map<String, String> getStandardResponseHeadersMap();

        String getStandardResponseHeadersOrDefault(String str, String str2);

        String getStandardResponseHeadersOrThrow(String str);

        int getStatusCode();

        long getUnixTimestampMs();

        String getUrl();

        ByteString getUrlBytes();

        boolean hasCustomRequestHeaders();

        boolean hasCustomResponseHeaders();

        boolean hasEncryptedSymmetricKey();

        boolean hasEncyptionPublicKeyId();

        boolean hasInitializationVector();

        boolean hasQueryParameters();

        boolean hasRequestBody();

        boolean hasRequestBodyAttributes();

        boolean hasResponseBody();

        boolean hasResponseBodyAttributes();

        boolean hasSource();
    }

    public enum NetworkStatus implements Internal.EnumLite {
        NETWORK_STATUS_UNSPECIFIED(0),
        NETWORK_STATUS_OFFLINE(1),
        NETWORK_STATUS_WIFI(2),
        NETWORK_STATUS_CELLULAR(3),
        UNRECOGNIZED(-1);

        public static final int NETWORK_STATUS_CELLULAR_VALUE = 3;
        public static final int NETWORK_STATUS_OFFLINE_VALUE = 1;
        public static final int NETWORK_STATUS_UNSPECIFIED_VALUE = 0;
        public static final int NETWORK_STATUS_WIFI_VALUE = 2;
        private static final Internal.EnumLiteMap<NetworkStatus> internalValueMap = new Internal.EnumLiteMap<NetworkStatus>() { // from class: com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.NetworkStatus.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public NetworkStatus findValueByNumber(int i) {
                return NetworkStatus.forNumber(i);
            }
        };
        private final int value;

        public static final class NetworkStatusVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new NetworkStatusVerifier();

            private NetworkStatusVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return NetworkStatus.forNumber(i) != null;
            }
        }

        NetworkStatus(int i) {
            this.value = i;
        }

        public static NetworkStatus forNumber(int i) {
            if (i == 0) {
                return NETWORK_STATUS_UNSPECIFIED;
            }
            if (i == 1) {
                return NETWORK_STATUS_OFFLINE;
            }
            if (i == 2) {
                return NETWORK_STATUS_WIFI;
            }
            if (i != 3) {
                return null;
            }
            return NETWORK_STATUS_CELLULAR;
        }

        public static Internal.EnumLiteMap<NetworkStatus> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return NetworkStatusVerifier.INSTANCE;
        }

        @Deprecated
        public static NetworkStatus valueOf(int i) {
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

    public static final class OnlineAssets extends GeneratedMessageLite<OnlineAssets, Builder> implements OnlineAssetsOrBuilder {
        private static final OnlineAssets DEFAULT_INSTANCE;
        private static volatile Parser<OnlineAssets> PARSER = null;
        public static final int URLS_FIELD_NUMBER = 1;
        private Internal.ProtobufList<String> urls_ = GeneratedMessageLite.emptyProtobufList();

        public static final class Builder extends GeneratedMessageLite.Builder<OnlineAssets, Builder> implements OnlineAssetsOrBuilder {
            private Builder() {
                super(OnlineAssets.DEFAULT_INSTANCE);
            }

            public Builder addAllUrls(Iterable<String> iterable) {
                copyOnWrite();
                ((OnlineAssets) this.instance).addAllUrls(iterable);
                return this;
            }

            public Builder addUrls(String str) {
                copyOnWrite();
                ((OnlineAssets) this.instance).addUrls(str);
                return this;
            }

            public Builder addUrlsBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((OnlineAssets) this.instance).addUrlsBytes(byteString);
                return this;
            }

            public Builder clearUrls() {
                copyOnWrite();
                ((OnlineAssets) this.instance).clearUrls();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.OnlineAssetsOrBuilder
            public String getUrls(int i) {
                return ((OnlineAssets) this.instance).getUrls(i);
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.OnlineAssetsOrBuilder
            public ByteString getUrlsBytes(int i) {
                return ((OnlineAssets) this.instance).getUrlsBytes(i);
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.OnlineAssetsOrBuilder
            public int getUrlsCount() {
                return ((OnlineAssets) this.instance).getUrlsCount();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.OnlineAssetsOrBuilder
            public List<String> getUrlsList() {
                return Collections.unmodifiableList(((OnlineAssets) this.instance).getUrlsList());
            }

            public Builder setUrls(int i, String str) {
                copyOnWrite();
                ((OnlineAssets) this.instance).setUrls(i, str);
                return this;
            }
        }

        static {
            OnlineAssets onlineAssets = new OnlineAssets();
            DEFAULT_INSTANCE = onlineAssets;
            GeneratedMessageLite.registerDefaultInstance(OnlineAssets.class, onlineAssets);
        }

        private OnlineAssets() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllUrls(Iterable<String> iterable) {
            ensureUrlsIsMutable();
            AbstractMessageLite.addAll(iterable, this.urls_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUrls(String str) {
            str.getClass();
            ensureUrlsIsMutable();
            this.urls_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUrlsBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensureUrlsIsMutable();
            this.urls_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUrls() {
            this.urls_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureUrlsIsMutable() {
            Internal.ProtobufList<String> protobufList = this.urls_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.urls_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static OnlineAssets getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static OnlineAssets parseDelimitedFrom(InputStream inputStream) {
            return (OnlineAssets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static OnlineAssets parseFrom(ByteString byteString) {
            return (OnlineAssets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<OnlineAssets> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUrls(int i, String str) {
            str.getClass();
            ensureUrlsIsMutable();
            this.urls_.set(i, str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new OnlineAssets();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"urls_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<OnlineAssets> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (OnlineAssets.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.OnlineAssetsOrBuilder
        public String getUrls(int i) {
            return this.urls_.get(i);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.OnlineAssetsOrBuilder
        public ByteString getUrlsBytes(int i) {
            return ByteString.copyFromUtf8(this.urls_.get(i));
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.OnlineAssetsOrBuilder
        public int getUrlsCount() {
            return this.urls_.size();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.OnlineAssetsOrBuilder
        public List<String> getUrlsList() {
            return this.urls_;
        }

        public static Builder newBuilder(OnlineAssets onlineAssets) {
            return DEFAULT_INSTANCE.createBuilder(onlineAssets);
        }

        public static OnlineAssets parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (OnlineAssets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OnlineAssets parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (OnlineAssets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static OnlineAssets parseFrom(CodedInputStream codedInputStream) {
            return (OnlineAssets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static OnlineAssets parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (OnlineAssets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static OnlineAssets parseFrom(InputStream inputStream) {
            return (OnlineAssets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static OnlineAssets parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (OnlineAssets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OnlineAssets parseFrom(ByteBuffer byteBuffer) {
            return (OnlineAssets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static OnlineAssets parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (OnlineAssets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static OnlineAssets parseFrom(byte[] bArr) {
            return (OnlineAssets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static OnlineAssets parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (OnlineAssets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface OnlineAssetsOrBuilder extends MessageLiteOrBuilder {
        String getUrls(int i);

        ByteString getUrlsBytes(int i);

        int getUrlsCount();

        List<String> getUrlsList();
    }

    public static final class QualitySettingsApplied extends GeneratedMessageLite<QualitySettingsApplied, Builder> implements QualitySettingsAppliedOrBuilder {
        private static final QualitySettingsApplied DEFAULT_INSTANCE;
        public static final int NETWORK_VALUES_FIELD_NUMBER = 4;
        private static volatile Parser<QualitySettingsApplied> PARSER = null;
        public static final int QUALITY_LEVELS_FIELD_NUMBER = 3;
        public static final int REASON_FIELD_NUMBER = 2;
        public static final int UNIX_TIMESTAMP_MS_FIELD_NUMBER = 1;
        private int bitField0_;
        private NetworkValues networkValues_;
        private QualityLevels qualityLevels_;
        private int reason_;
        private long unixTimestampMs_;

        public static final class Builder extends GeneratedMessageLite.Builder<QualitySettingsApplied, Builder> implements QualitySettingsAppliedOrBuilder {
            private Builder() {
                super(QualitySettingsApplied.DEFAULT_INSTANCE);
            }

            public Builder clearNetworkValues() {
                copyOnWrite();
                ((QualitySettingsApplied) this.instance).clearNetworkValues();
                return this;
            }

            public Builder clearQualityLevels() {
                copyOnWrite();
                ((QualitySettingsApplied) this.instance).clearQualityLevels();
                return this;
            }

            public Builder clearReason() {
                copyOnWrite();
                ((QualitySettingsApplied) this.instance).clearReason();
                return this;
            }

            public Builder clearUnixTimestampMs() {
                copyOnWrite();
                ((QualitySettingsApplied) this.instance).clearUnixTimestampMs();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsAppliedOrBuilder
            public NetworkValues getNetworkValues() {
                return ((QualitySettingsApplied) this.instance).getNetworkValues();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsAppliedOrBuilder
            public QualityLevels getQualityLevels() {
                return ((QualitySettingsApplied) this.instance).getQualityLevels();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsAppliedOrBuilder
            public Reason getReason() {
                return ((QualitySettingsApplied) this.instance).getReason();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsAppliedOrBuilder
            public int getReasonValue() {
                return ((QualitySettingsApplied) this.instance).getReasonValue();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsAppliedOrBuilder
            public long getUnixTimestampMs() {
                return ((QualitySettingsApplied) this.instance).getUnixTimestampMs();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsAppliedOrBuilder
            public boolean hasNetworkValues() {
                return ((QualitySettingsApplied) this.instance).hasNetworkValues();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsAppliedOrBuilder
            public boolean hasQualityLevels() {
                return ((QualitySettingsApplied) this.instance).hasQualityLevels();
            }

            public Builder mergeNetworkValues(NetworkValues networkValues) {
                copyOnWrite();
                ((QualitySettingsApplied) this.instance).mergeNetworkValues(networkValues);
                return this;
            }

            public Builder mergeQualityLevels(QualityLevels qualityLevels) {
                copyOnWrite();
                ((QualitySettingsApplied) this.instance).mergeQualityLevels(qualityLevels);
                return this;
            }

            public Builder setNetworkValues(NetworkValues.Builder builder) {
                copyOnWrite();
                ((QualitySettingsApplied) this.instance).setNetworkValues(builder.build());
                return this;
            }

            public Builder setQualityLevels(QualityLevels.Builder builder) {
                copyOnWrite();
                ((QualitySettingsApplied) this.instance).setQualityLevels(builder.build());
                return this;
            }

            public Builder setReason(Reason reason) {
                copyOnWrite();
                ((QualitySettingsApplied) this.instance).setReason(reason);
                return this;
            }

            public Builder setReasonValue(int i) {
                copyOnWrite();
                ((QualitySettingsApplied) this.instance).setReasonValue(i);
                return this;
            }

            public Builder setUnixTimestampMs(long j) {
                copyOnWrite();
                ((QualitySettingsApplied) this.instance).setUnixTimestampMs(j);
                return this;
            }

            public Builder setNetworkValues(NetworkValues networkValues) {
                copyOnWrite();
                ((QualitySettingsApplied) this.instance).setNetworkValues(networkValues);
                return this;
            }

            public Builder setQualityLevels(QualityLevels qualityLevels) {
                copyOnWrite();
                ((QualitySettingsApplied) this.instance).setQualityLevels(qualityLevels);
                return this;
            }
        }

        public static final class NetworkValues extends GeneratedMessageLite<NetworkValues, Builder> implements NetworkValuesOrBuilder {
            public static final int CURRENT_FIELD_NUMBER = 2;
            private static final NetworkValues DEFAULT_INSTANCE;
            private static volatile Parser<NetworkValues> PARSER = null;
            public static final int PREVIOUS_FIELD_NUMBER = 1;
            private int bitField0_;
            private int current_;
            private int previous_;

            public static final class Builder extends GeneratedMessageLite.Builder<NetworkValues, Builder> implements NetworkValuesOrBuilder {
                private Builder() {
                    super(NetworkValues.DEFAULT_INSTANCE);
                }

                public Builder clearCurrent() {
                    copyOnWrite();
                    ((NetworkValues) this.instance).clearCurrent();
                    return this;
                }

                public Builder clearPrevious() {
                    copyOnWrite();
                    ((NetworkValues) this.instance).clearPrevious();
                    return this;
                }

                @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsApplied.NetworkValuesOrBuilder
                public NetworkStatus getCurrent() {
                    return ((NetworkValues) this.instance).getCurrent();
                }

                @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsApplied.NetworkValuesOrBuilder
                public int getCurrentValue() {
                    return ((NetworkValues) this.instance).getCurrentValue();
                }

                @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsApplied.NetworkValuesOrBuilder
                public NetworkStatus getPrevious() {
                    return ((NetworkValues) this.instance).getPrevious();
                }

                @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsApplied.NetworkValuesOrBuilder
                public int getPreviousValue() {
                    return ((NetworkValues) this.instance).getPreviousValue();
                }

                @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsApplied.NetworkValuesOrBuilder
                public boolean hasPrevious() {
                    return ((NetworkValues) this.instance).hasPrevious();
                }

                public Builder setCurrent(NetworkStatus networkStatus) {
                    copyOnWrite();
                    ((NetworkValues) this.instance).setCurrent(networkStatus);
                    return this;
                }

                public Builder setCurrentValue(int i) {
                    copyOnWrite();
                    ((NetworkValues) this.instance).setCurrentValue(i);
                    return this;
                }

                public Builder setPrevious(NetworkStatus networkStatus) {
                    copyOnWrite();
                    ((NetworkValues) this.instance).setPrevious(networkStatus);
                    return this;
                }

                public Builder setPreviousValue(int i) {
                    copyOnWrite();
                    ((NetworkValues) this.instance).setPreviousValue(i);
                    return this;
                }
            }

            static {
                NetworkValues networkValues = new NetworkValues();
                DEFAULT_INSTANCE = networkValues;
                GeneratedMessageLite.registerDefaultInstance(NetworkValues.class, networkValues);
            }

            private NetworkValues() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCurrent() {
                this.current_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPrevious() {
                this.bitField0_ &= -2;
                this.previous_ = 0;
            }

            public static NetworkValues getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static NetworkValues parseDelimitedFrom(InputStream inputStream) {
                return (NetworkValues) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static NetworkValues parseFrom(ByteString byteString) {
                return (NetworkValues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<NetworkValues> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCurrent(NetworkStatus networkStatus) {
                this.current_ = networkStatus.getNumber();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCurrentValue(int i) {
                this.current_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPrevious(NetworkStatus networkStatus) {
                this.previous_ = networkStatus.getNumber();
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPreviousValue(int i) {
                this.bitField0_ |= 1;
                this.previous_ = i;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new NetworkValues();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002\f", new Object[]{"bitField0_", "previous_", "current_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<NetworkValues> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (NetworkValues.class) {
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

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsApplied.NetworkValuesOrBuilder
            public NetworkStatus getCurrent() {
                NetworkStatus networkStatusForNumber = NetworkStatus.forNumber(this.current_);
                return networkStatusForNumber == null ? NetworkStatus.UNRECOGNIZED : networkStatusForNumber;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsApplied.NetworkValuesOrBuilder
            public int getCurrentValue() {
                return this.current_;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsApplied.NetworkValuesOrBuilder
            public NetworkStatus getPrevious() {
                NetworkStatus networkStatusForNumber = NetworkStatus.forNumber(this.previous_);
                return networkStatusForNumber == null ? NetworkStatus.UNRECOGNIZED : networkStatusForNumber;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsApplied.NetworkValuesOrBuilder
            public int getPreviousValue() {
                return this.previous_;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsApplied.NetworkValuesOrBuilder
            public boolean hasPrevious() {
                return (this.bitField0_ & 1) != 0;
            }

            public static Builder newBuilder(NetworkValues networkValues) {
                return DEFAULT_INSTANCE.createBuilder(networkValues);
            }

            public static NetworkValues parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (NetworkValues) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static NetworkValues parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (NetworkValues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static NetworkValues parseFrom(CodedInputStream codedInputStream) {
                return (NetworkValues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static NetworkValues parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (NetworkValues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static NetworkValues parseFrom(InputStream inputStream) {
                return (NetworkValues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static NetworkValues parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (NetworkValues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static NetworkValues parseFrom(ByteBuffer byteBuffer) {
                return (NetworkValues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static NetworkValues parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (NetworkValues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static NetworkValues parseFrom(byte[] bArr) {
                return (NetworkValues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static NetworkValues parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (NetworkValues) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface NetworkValuesOrBuilder extends MessageLiteOrBuilder {
            NetworkStatus getCurrent();

            int getCurrentValue();

            NetworkStatus getPrevious();

            int getPreviousValue();

            boolean hasPrevious();
        }

        public static final class QualityLevels extends GeneratedMessageLite<QualityLevels, Builder> implements QualityLevelsOrBuilder {
            public static final int CURRENT_FIELD_NUMBER = 2;
            private static final QualityLevels DEFAULT_INSTANCE;
            private static volatile Parser<QualityLevels> PARSER = null;
            public static final int PREVIOUS_FIELD_NUMBER = 1;
            private int bitField0_;
            private int current_;
            private int previous_;

            public static final class Builder extends GeneratedMessageLite.Builder<QualityLevels, Builder> implements QualityLevelsOrBuilder {
                private Builder() {
                    super(QualityLevels.DEFAULT_INSTANCE);
                }

                public Builder clearCurrent() {
                    copyOnWrite();
                    ((QualityLevels) this.instance).clearCurrent();
                    return this;
                }

                public Builder clearPrevious() {
                    copyOnWrite();
                    ((QualityLevels) this.instance).clearPrevious();
                    return this;
                }

                @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsApplied.QualityLevelsOrBuilder
                public RecordingQuality getCurrent() {
                    return ((QualityLevels) this.instance).getCurrent();
                }

                @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsApplied.QualityLevelsOrBuilder
                public int getCurrentValue() {
                    return ((QualityLevels) this.instance).getCurrentValue();
                }

                @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsApplied.QualityLevelsOrBuilder
                public RecordingQuality getPrevious() {
                    return ((QualityLevels) this.instance).getPrevious();
                }

                @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsApplied.QualityLevelsOrBuilder
                public int getPreviousValue() {
                    return ((QualityLevels) this.instance).getPreviousValue();
                }

                @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsApplied.QualityLevelsOrBuilder
                public boolean hasPrevious() {
                    return ((QualityLevels) this.instance).hasPrevious();
                }

                public Builder setCurrent(RecordingQuality recordingQuality) {
                    copyOnWrite();
                    ((QualityLevels) this.instance).setCurrent(recordingQuality);
                    return this;
                }

                public Builder setCurrentValue(int i) {
                    copyOnWrite();
                    ((QualityLevels) this.instance).setCurrentValue(i);
                    return this;
                }

                public Builder setPrevious(RecordingQuality recordingQuality) {
                    copyOnWrite();
                    ((QualityLevels) this.instance).setPrevious(recordingQuality);
                    return this;
                }

                public Builder setPreviousValue(int i) {
                    copyOnWrite();
                    ((QualityLevels) this.instance).setPreviousValue(i);
                    return this;
                }
            }

            static {
                QualityLevels qualityLevels = new QualityLevels();
                DEFAULT_INSTANCE = qualityLevels;
                GeneratedMessageLite.registerDefaultInstance(QualityLevels.class, qualityLevels);
            }

            private QualityLevels() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCurrent() {
                this.current_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPrevious() {
                this.bitField0_ &= -2;
                this.previous_ = 0;
            }

            public static QualityLevels getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static QualityLevels parseDelimitedFrom(InputStream inputStream) {
                return (QualityLevels) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static QualityLevels parseFrom(ByteString byteString) {
                return (QualityLevels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<QualityLevels> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCurrent(RecordingQuality recordingQuality) {
                this.current_ = recordingQuality.getNumber();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCurrentValue(int i) {
                this.current_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPrevious(RecordingQuality recordingQuality) {
                this.previous_ = recordingQuality.getNumber();
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPreviousValue(int i) {
                this.bitField0_ |= 1;
                this.previous_ = i;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new QualityLevels();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002\f", new Object[]{"bitField0_", "previous_", "current_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<QualityLevels> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (QualityLevels.class) {
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

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsApplied.QualityLevelsOrBuilder
            public RecordingQuality getCurrent() {
                RecordingQuality recordingQualityForNumber = RecordingQuality.forNumber(this.current_);
                return recordingQualityForNumber == null ? RecordingQuality.UNRECOGNIZED : recordingQualityForNumber;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsApplied.QualityLevelsOrBuilder
            public int getCurrentValue() {
                return this.current_;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsApplied.QualityLevelsOrBuilder
            public RecordingQuality getPrevious() {
                RecordingQuality recordingQualityForNumber = RecordingQuality.forNumber(this.previous_);
                return recordingQualityForNumber == null ? RecordingQuality.UNRECOGNIZED : recordingQualityForNumber;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsApplied.QualityLevelsOrBuilder
            public int getPreviousValue() {
                return this.previous_;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsApplied.QualityLevelsOrBuilder
            public boolean hasPrevious() {
                return (this.bitField0_ & 1) != 0;
            }

            public static Builder newBuilder(QualityLevels qualityLevels) {
                return DEFAULT_INSTANCE.createBuilder(qualityLevels);
            }

            public static QualityLevels parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (QualityLevels) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static QualityLevels parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (QualityLevels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static QualityLevels parseFrom(CodedInputStream codedInputStream) {
                return (QualityLevels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static QualityLevels parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (QualityLevels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static QualityLevels parseFrom(InputStream inputStream) {
                return (QualityLevels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static QualityLevels parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (QualityLevels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static QualityLevels parseFrom(ByteBuffer byteBuffer) {
                return (QualityLevels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static QualityLevels parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (QualityLevels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static QualityLevels parseFrom(byte[] bArr) {
                return (QualityLevels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static QualityLevels parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (QualityLevels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface QualityLevelsOrBuilder extends MessageLiteOrBuilder {
            RecordingQuality getCurrent();

            int getCurrentValue();

            RecordingQuality getPrevious();

            int getPreviousValue();

            boolean hasPrevious();
        }

        public enum Reason implements Internal.EnumLite {
            REASON_UNSPECIFIED(0),
            REASON_CONFIG_APPLIED(1),
            REASON_NETWORK_CHANGED(2),
            REASON_CPU_USAGE_CHANGED(3),
            UNRECOGNIZED(-1);

            public static final int REASON_CONFIG_APPLIED_VALUE = 1;
            public static final int REASON_CPU_USAGE_CHANGED_VALUE = 3;
            public static final int REASON_NETWORK_CHANGED_VALUE = 2;
            public static final int REASON_UNSPECIFIED_VALUE = 0;
            private static final Internal.EnumLiteMap<Reason> internalValueMap = new Internal.EnumLiteMap<Reason>() { // from class: com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsApplied.Reason.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Reason findValueByNumber(int i) {
                    return Reason.forNumber(i);
                }
            };
            private final int value;

            public static final class ReasonVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new ReasonVerifier();

                private ReasonVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return Reason.forNumber(i) != null;
                }
            }

            Reason(int i) {
                this.value = i;
            }

            public static Reason forNumber(int i) {
                if (i == 0) {
                    return REASON_UNSPECIFIED;
                }
                if (i == 1) {
                    return REASON_CONFIG_APPLIED;
                }
                if (i == 2) {
                    return REASON_NETWORK_CHANGED;
                }
                if (i != 3) {
                    return null;
                }
                return REASON_CPU_USAGE_CHANGED;
            }

            public static Internal.EnumLiteMap<Reason> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return ReasonVerifier.INSTANCE;
            }

            @Deprecated
            public static Reason valueOf(int i) {
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

        static {
            QualitySettingsApplied qualitySettingsApplied = new QualitySettingsApplied();
            DEFAULT_INSTANCE = qualitySettingsApplied;
            GeneratedMessageLite.registerDefaultInstance(QualitySettingsApplied.class, qualitySettingsApplied);
        }

        private QualitySettingsApplied() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNetworkValues() {
            this.networkValues_ = null;
            this.bitField0_ &= -3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearQualityLevels() {
            this.qualityLevels_ = null;
            this.bitField0_ &= -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReason() {
            this.reason_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnixTimestampMs() {
            this.unixTimestampMs_ = 0L;
        }

        public static QualitySettingsApplied getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeNetworkValues(NetworkValues networkValues) {
            networkValues.getClass();
            NetworkValues networkValues2 = this.networkValues_;
            if (networkValues2 != null && networkValues2 != NetworkValues.getDefaultInstance()) {
                networkValues = NetworkValues.newBuilder(this.networkValues_).mergeFrom((NetworkValues.Builder) networkValues).buildPartial();
            }
            this.networkValues_ = networkValues;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeQualityLevels(QualityLevels qualityLevels) {
            qualityLevels.getClass();
            QualityLevels qualityLevels2 = this.qualityLevels_;
            if (qualityLevels2 != null && qualityLevels2 != QualityLevels.getDefaultInstance()) {
                qualityLevels = QualityLevels.newBuilder(this.qualityLevels_).mergeFrom((QualityLevels.Builder) qualityLevels).buildPartial();
            }
            this.qualityLevels_ = qualityLevels;
            this.bitField0_ |= 1;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static QualitySettingsApplied parseDelimitedFrom(InputStream inputStream) {
            return (QualitySettingsApplied) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static QualitySettingsApplied parseFrom(ByteString byteString) {
            return (QualitySettingsApplied) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<QualitySettingsApplied> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNetworkValues(NetworkValues networkValues) {
            networkValues.getClass();
            this.networkValues_ = networkValues;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setQualityLevels(QualityLevels qualityLevels) {
            qualityLevels.getClass();
            this.qualityLevels_ = qualityLevels;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReason(Reason reason) {
            this.reason_ = reason.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReasonValue(int i) {
            this.reason_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnixTimestampMs(long j) {
            this.unixTimestampMs_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new QualitySettingsApplied();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0003\u0002\f\u0003ဉ\u0000\u0004ဉ\u0001", new Object[]{"bitField0_", "unixTimestampMs_", "reason_", "qualityLevels_", "networkValues_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<QualitySettingsApplied> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (QualitySettingsApplied.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsAppliedOrBuilder
        public NetworkValues getNetworkValues() {
            NetworkValues networkValues = this.networkValues_;
            return networkValues == null ? NetworkValues.getDefaultInstance() : networkValues;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsAppliedOrBuilder
        public QualityLevels getQualityLevels() {
            QualityLevels qualityLevels = this.qualityLevels_;
            return qualityLevels == null ? QualityLevels.getDefaultInstance() : qualityLevels;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsAppliedOrBuilder
        public Reason getReason() {
            Reason reasonForNumber = Reason.forNumber(this.reason_);
            return reasonForNumber == null ? Reason.UNRECOGNIZED : reasonForNumber;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsAppliedOrBuilder
        public int getReasonValue() {
            return this.reason_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsAppliedOrBuilder
        public long getUnixTimestampMs() {
            return this.unixTimestampMs_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsAppliedOrBuilder
        public boolean hasNetworkValues() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.QualitySettingsAppliedOrBuilder
        public boolean hasQualityLevels() {
            return (this.bitField0_ & 1) != 0;
        }

        public static Builder newBuilder(QualitySettingsApplied qualitySettingsApplied) {
            return DEFAULT_INSTANCE.createBuilder(qualitySettingsApplied);
        }

        public static QualitySettingsApplied parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (QualitySettingsApplied) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static QualitySettingsApplied parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (QualitySettingsApplied) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static QualitySettingsApplied parseFrom(CodedInputStream codedInputStream) {
            return (QualitySettingsApplied) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static QualitySettingsApplied parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (QualitySettingsApplied) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static QualitySettingsApplied parseFrom(InputStream inputStream) {
            return (QualitySettingsApplied) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static QualitySettingsApplied parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (QualitySettingsApplied) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static QualitySettingsApplied parseFrom(ByteBuffer byteBuffer) {
            return (QualitySettingsApplied) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static QualitySettingsApplied parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (QualitySettingsApplied) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static QualitySettingsApplied parseFrom(byte[] bArr) {
            return (QualitySettingsApplied) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static QualitySettingsApplied parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (QualitySettingsApplied) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface QualitySettingsAppliedOrBuilder extends MessageLiteOrBuilder {
        QualitySettingsApplied.NetworkValues getNetworkValues();

        QualitySettingsApplied.QualityLevels getQualityLevels();

        QualitySettingsApplied.Reason getReason();

        int getReasonValue();

        long getUnixTimestampMs();

        boolean hasNetworkValues();

        boolean hasQualityLevels();
    }

    public enum RecordingQuality implements Internal.EnumLite {
        RECORDING_QUALITY_UNSPECIFIED(0),
        RECORDING_QUALITY_LOW(1),
        RECORDING_QUALITY_MEDIUM(2),
        RECORDING_QUALITY_HIGH(3),
        UNRECOGNIZED(-1);

        public static final int RECORDING_QUALITY_HIGH_VALUE = 3;
        public static final int RECORDING_QUALITY_LOW_VALUE = 1;
        public static final int RECORDING_QUALITY_MEDIUM_VALUE = 2;
        public static final int RECORDING_QUALITY_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<RecordingQuality> internalValueMap = new Internal.EnumLiteMap<RecordingQuality>() { // from class: com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.RecordingQuality.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public RecordingQuality findValueByNumber(int i) {
                return RecordingQuality.forNumber(i);
            }
        };
        private final int value;

        public static final class RecordingQualityVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new RecordingQualityVerifier();

            private RecordingQualityVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return RecordingQuality.forNumber(i) != null;
            }
        }

        RecordingQuality(int i) {
            this.value = i;
        }

        public static RecordingQuality forNumber(int i) {
            if (i == 0) {
                return RECORDING_QUALITY_UNSPECIFIED;
            }
            if (i == 1) {
                return RECORDING_QUALITY_LOW;
            }
            if (i == 2) {
                return RECORDING_QUALITY_MEDIUM;
            }
            if (i != 3) {
                return null;
            }
            return RECORDING_QUALITY_HIGH;
        }

        public static Internal.EnumLiteMap<RecordingQuality> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return RecordingQualityVerifier.INSTANCE;
        }

        @Deprecated
        public static RecordingQuality valueOf(int i) {
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

    public static final class RecordingStart extends GeneratedMessageLite<RecordingStart, Builder> implements RecordingStartOrBuilder {
        private static final RecordingStart DEFAULT_INSTANCE;
        public static final int IS_NEW_SESSION_FIELD_NUMBER = 3;
        private static volatile Parser<RecordingStart> PARSER = null;
        public static final int START_REASON_FIELD_NUMBER = 2;
        public static final int UNIX_TIMESTAMP_MS_FIELD_NUMBER = 1;
        private boolean isNewSession_;
        private int startReason_;
        private long unixTimestampMs_;

        public static final class Builder extends GeneratedMessageLite.Builder<RecordingStart, Builder> implements RecordingStartOrBuilder {
            private Builder() {
                super(RecordingStart.DEFAULT_INSTANCE);
            }

            public Builder clearIsNewSession() {
                copyOnWrite();
                ((RecordingStart) this.instance).clearIsNewSession();
                return this;
            }

            public Builder clearStartReason() {
                copyOnWrite();
                ((RecordingStart) this.instance).clearStartReason();
                return this;
            }

            public Builder clearUnixTimestampMs() {
                copyOnWrite();
                ((RecordingStart) this.instance).clearUnixTimestampMs();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.RecordingStartOrBuilder
            public boolean getIsNewSession() {
                return ((RecordingStart) this.instance).getIsNewSession();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.RecordingStartOrBuilder
            public StartReason getStartReason() {
                return ((RecordingStart) this.instance).getStartReason();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.RecordingStartOrBuilder
            public int getStartReasonValue() {
                return ((RecordingStart) this.instance).getStartReasonValue();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.RecordingStartOrBuilder
            public long getUnixTimestampMs() {
                return ((RecordingStart) this.instance).getUnixTimestampMs();
            }

            public Builder setIsNewSession(boolean z) {
                copyOnWrite();
                ((RecordingStart) this.instance).setIsNewSession(z);
                return this;
            }

            public Builder setStartReason(StartReason startReason) {
                copyOnWrite();
                ((RecordingStart) this.instance).setStartReason(startReason);
                return this;
            }

            public Builder setStartReasonValue(int i) {
                copyOnWrite();
                ((RecordingStart) this.instance).setStartReasonValue(i);
                return this;
            }

            public Builder setUnixTimestampMs(long j) {
                copyOnWrite();
                ((RecordingStart) this.instance).setUnixTimestampMs(j);
                return this;
            }
        }

        public enum StartReason implements Internal.EnumLite {
            START_REASON_UNSPECIFIED(0),
            START_REASON_REGULAR(1),
            START_REASON_FORCED(2),
            UNRECOGNIZED(-1);

            public static final int START_REASON_FORCED_VALUE = 2;
            public static final int START_REASON_REGULAR_VALUE = 1;
            public static final int START_REASON_UNSPECIFIED_VALUE = 0;
            private static final Internal.EnumLiteMap<StartReason> internalValueMap = new Internal.EnumLiteMap<StartReason>() { // from class: com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.RecordingStart.StartReason.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public StartReason findValueByNumber(int i) {
                    return StartReason.forNumber(i);
                }
            };
            private final int value;

            public static final class StartReasonVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new StartReasonVerifier();

                private StartReasonVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return StartReason.forNumber(i) != null;
                }
            }

            StartReason(int i) {
                this.value = i;
            }

            public static StartReason forNumber(int i) {
                if (i == 0) {
                    return START_REASON_UNSPECIFIED;
                }
                if (i == 1) {
                    return START_REASON_REGULAR;
                }
                if (i != 2) {
                    return null;
                }
                return START_REASON_FORCED;
            }

            public static Internal.EnumLiteMap<StartReason> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return StartReasonVerifier.INSTANCE;
            }

            @Deprecated
            public static StartReason valueOf(int i) {
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

        static {
            RecordingStart recordingStart = new RecordingStart();
            DEFAULT_INSTANCE = recordingStart;
            GeneratedMessageLite.registerDefaultInstance(RecordingStart.class, recordingStart);
        }

        private RecordingStart() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsNewSession() {
            this.isNewSession_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartReason() {
            this.startReason_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnixTimestampMs() {
            this.unixTimestampMs_ = 0L;
        }

        public static RecordingStart getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static RecordingStart parseDelimitedFrom(InputStream inputStream) {
            return (RecordingStart) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RecordingStart parseFrom(ByteString byteString) {
            return (RecordingStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<RecordingStart> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsNewSession(boolean z) {
            this.isNewSession_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartReason(StartReason startReason) {
            this.startReason_ = startReason.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartReasonValue(int i) {
            this.startReason_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnixTimestampMs(long j) {
            this.unixTimestampMs_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new RecordingStart();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0003\u0002\f\u0003\u0007", new Object[]{"unixTimestampMs_", "startReason_", "isNewSession_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<RecordingStart> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (RecordingStart.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.RecordingStartOrBuilder
        public boolean getIsNewSession() {
            return this.isNewSession_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.RecordingStartOrBuilder
        public StartReason getStartReason() {
            StartReason startReasonForNumber = StartReason.forNumber(this.startReason_);
            return startReasonForNumber == null ? StartReason.UNRECOGNIZED : startReasonForNumber;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.RecordingStartOrBuilder
        public int getStartReasonValue() {
            return this.startReason_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.RecordingStartOrBuilder
        public long getUnixTimestampMs() {
            return this.unixTimestampMs_;
        }

        public static Builder newBuilder(RecordingStart recordingStart) {
            return DEFAULT_INSTANCE.createBuilder(recordingStart);
        }

        public static RecordingStart parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RecordingStart) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RecordingStart parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (RecordingStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static RecordingStart parseFrom(CodedInputStream codedInputStream) {
            return (RecordingStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RecordingStart parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RecordingStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static RecordingStart parseFrom(InputStream inputStream) {
            return (RecordingStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RecordingStart parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RecordingStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RecordingStart parseFrom(ByteBuffer byteBuffer) {
            return (RecordingStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static RecordingStart parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (RecordingStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static RecordingStart parseFrom(byte[] bArr) {
            return (RecordingStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static RecordingStart parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (RecordingStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface RecordingStartOrBuilder extends MessageLiteOrBuilder {
        boolean getIsNewSession();

        RecordingStart.StartReason getStartReason();

        int getStartReasonValue();

        long getUnixTimestampMs();
    }

    public static final class RecordingStop extends GeneratedMessageLite<RecordingStop, Builder> implements RecordingStopOrBuilder {
        private static final RecordingStop DEFAULT_INSTANCE;
        private static volatile Parser<RecordingStop> PARSER = null;
        public static final int STOP_REASON_FIELD_NUMBER = 2;
        public static final int UNIX_TIMESTAMP_MS_FIELD_NUMBER = 1;
        private int stopReason_;
        private long unixTimestampMs_;

        public static final class Builder extends GeneratedMessageLite.Builder<RecordingStop, Builder> implements RecordingStopOrBuilder {
            private Builder() {
                super(RecordingStop.DEFAULT_INSTANCE);
            }

            public Builder clearStopReason() {
                copyOnWrite();
                ((RecordingStop) this.instance).clearStopReason();
                return this;
            }

            public Builder clearUnixTimestampMs() {
                copyOnWrite();
                ((RecordingStop) this.instance).clearUnixTimestampMs();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.RecordingStopOrBuilder
            public StopReason getStopReason() {
                return ((RecordingStop) this.instance).getStopReason();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.RecordingStopOrBuilder
            public int getStopReasonValue() {
                return ((RecordingStop) this.instance).getStopReasonValue();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.RecordingStopOrBuilder
            public long getUnixTimestampMs() {
                return ((RecordingStop) this.instance).getUnixTimestampMs();
            }

            public Builder setStopReason(StopReason stopReason) {
                copyOnWrite();
                ((RecordingStop) this.instance).setStopReason(stopReason);
                return this;
            }

            public Builder setStopReasonValue(int i) {
                copyOnWrite();
                ((RecordingStop) this.instance).setStopReasonValue(i);
                return this;
            }

            public Builder setUnixTimestampMs(long j) {
                copyOnWrite();
                ((RecordingStop) this.instance).setUnixTimestampMs(j);
                return this;
            }
        }

        public enum StopReason implements Internal.EnumLite {
            STOP_REASON_UNSPECIFIED(0),
            STOP_REASON_STORAGE_EXCEEDED(1),
            UNRECOGNIZED(-1);

            public static final int STOP_REASON_STORAGE_EXCEEDED_VALUE = 1;
            public static final int STOP_REASON_UNSPECIFIED_VALUE = 0;
            private static final Internal.EnumLiteMap<StopReason> internalValueMap = new Internal.EnumLiteMap<StopReason>() { // from class: com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.RecordingStop.StopReason.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public StopReason findValueByNumber(int i) {
                    return StopReason.forNumber(i);
                }
            };
            private final int value;

            public static final class StopReasonVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new StopReasonVerifier();

                private StopReasonVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return StopReason.forNumber(i) != null;
                }
            }

            StopReason(int i) {
                this.value = i;
            }

            public static StopReason forNumber(int i) {
                if (i == 0) {
                    return STOP_REASON_UNSPECIFIED;
                }
                if (i != 1) {
                    return null;
                }
                return STOP_REASON_STORAGE_EXCEEDED;
            }

            public static Internal.EnumLiteMap<StopReason> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return StopReasonVerifier.INSTANCE;
            }

            @Deprecated
            public static StopReason valueOf(int i) {
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

        static {
            RecordingStop recordingStop = new RecordingStop();
            DEFAULT_INSTANCE = recordingStop;
            GeneratedMessageLite.registerDefaultInstance(RecordingStop.class, recordingStop);
        }

        private RecordingStop() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStopReason() {
            this.stopReason_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnixTimestampMs() {
            this.unixTimestampMs_ = 0L;
        }

        public static RecordingStop getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static RecordingStop parseDelimitedFrom(InputStream inputStream) {
            return (RecordingStop) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RecordingStop parseFrom(ByteString byteString) {
            return (RecordingStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<RecordingStop> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStopReason(StopReason stopReason) {
            this.stopReason_ = stopReason.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStopReasonValue(int i) {
            this.stopReason_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnixTimestampMs(long j) {
            this.unixTimestampMs_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new RecordingStop();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0003\u0002\f", new Object[]{"unixTimestampMs_", "stopReason_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<RecordingStop> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (RecordingStop.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.RecordingStopOrBuilder
        public StopReason getStopReason() {
            StopReason stopReasonForNumber = StopReason.forNumber(this.stopReason_);
            return stopReasonForNumber == null ? StopReason.UNRECOGNIZED : stopReasonForNumber;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.RecordingStopOrBuilder
        public int getStopReasonValue() {
            return this.stopReason_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.RecordingStopOrBuilder
        public long getUnixTimestampMs() {
            return this.unixTimestampMs_;
        }

        public static Builder newBuilder(RecordingStop recordingStop) {
            return DEFAULT_INSTANCE.createBuilder(recordingStop);
        }

        public static RecordingStop parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RecordingStop) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RecordingStop parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (RecordingStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static RecordingStop parseFrom(CodedInputStream codedInputStream) {
            return (RecordingStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RecordingStop parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RecordingStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static RecordingStop parseFrom(InputStream inputStream) {
            return (RecordingStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RecordingStop parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RecordingStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RecordingStop parseFrom(ByteBuffer byteBuffer) {
            return (RecordingStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static RecordingStop parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (RecordingStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static RecordingStop parseFrom(byte[] bArr) {
            return (RecordingStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static RecordingStop parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (RecordingStop) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface RecordingStopOrBuilder extends MessageLiteOrBuilder {
        RecordingStop.StopReason getStopReason();

        int getStopReasonValue();

        long getUnixTimestampMs();
    }

    public static final class RemovalMutation extends GeneratedMessageLite<RemovalMutation, Builder> implements RemovalMutationOrBuilder {
        private static final RemovalMutation DEFAULT_INSTANCE;
        private static volatile Parser<RemovalMutation> PARSER = null;
        public static final int UNIX_TIMESTAMP_MS_FIELD_NUMBER = 1;
        public static final int VIEW_ID_FIELD_NUMBER = 2;
        private long unixTimestampMs_;
        private long viewId_;

        public static final class Builder extends GeneratedMessageLite.Builder<RemovalMutation, Builder> implements RemovalMutationOrBuilder {
            private Builder() {
                super(RemovalMutation.DEFAULT_INSTANCE);
            }

            public Builder clearUnixTimestampMs() {
                copyOnWrite();
                ((RemovalMutation) this.instance).clearUnixTimestampMs();
                return this;
            }

            public Builder clearViewId() {
                copyOnWrite();
                ((RemovalMutation) this.instance).clearViewId();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.RemovalMutationOrBuilder
            public long getUnixTimestampMs() {
                return ((RemovalMutation) this.instance).getUnixTimestampMs();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.RemovalMutationOrBuilder
            public long getViewId() {
                return ((RemovalMutation) this.instance).getViewId();
            }

            public Builder setUnixTimestampMs(long j) {
                copyOnWrite();
                ((RemovalMutation) this.instance).setUnixTimestampMs(j);
                return this;
            }

            public Builder setViewId(long j) {
                copyOnWrite();
                ((RemovalMutation) this.instance).setViewId(j);
                return this;
            }
        }

        static {
            RemovalMutation removalMutation = new RemovalMutation();
            DEFAULT_INSTANCE = removalMutation;
            GeneratedMessageLite.registerDefaultInstance(RemovalMutation.class, removalMutation);
        }

        private RemovalMutation() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnixTimestampMs() {
            this.unixTimestampMs_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearViewId() {
            this.viewId_ = 0L;
        }

        public static RemovalMutation getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static RemovalMutation parseDelimitedFrom(InputStream inputStream) {
            return (RemovalMutation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RemovalMutation parseFrom(ByteString byteString) {
            return (RemovalMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<RemovalMutation> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnixTimestampMs(long j) {
            this.unixTimestampMs_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setViewId(long j) {
            this.viewId_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new RemovalMutation();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0003\u0002\u0010", new Object[]{"unixTimestampMs_", "viewId_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<RemovalMutation> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (RemovalMutation.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.RemovalMutationOrBuilder
        public long getUnixTimestampMs() {
            return this.unixTimestampMs_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.RemovalMutationOrBuilder
        public long getViewId() {
            return this.viewId_;
        }

        public static Builder newBuilder(RemovalMutation removalMutation) {
            return DEFAULT_INSTANCE.createBuilder(removalMutation);
        }

        public static RemovalMutation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RemovalMutation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RemovalMutation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (RemovalMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static RemovalMutation parseFrom(CodedInputStream codedInputStream) {
            return (RemovalMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RemovalMutation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RemovalMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static RemovalMutation parseFrom(InputStream inputStream) {
            return (RemovalMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RemovalMutation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RemovalMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RemovalMutation parseFrom(ByteBuffer byteBuffer) {
            return (RemovalMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static RemovalMutation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (RemovalMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static RemovalMutation parseFrom(byte[] bArr) {
            return (RemovalMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static RemovalMutation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (RemovalMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface RemovalMutationOrBuilder extends MessageLiteOrBuilder {
        long getUnixTimestampMs();

        long getViewId();
    }

    public static final class ScreenView extends GeneratedMessageLite<ScreenView, Builder> implements ScreenViewOrBuilder {
        private static final ScreenView DEFAULT_INSTANCE;
        private static volatile Parser<ScreenView> PARSER = null;
        public static final int TITLE_FIELD_NUMBER = 2;
        public static final int UNIX_TIMESTAMP_MS_FIELD_NUMBER = 1;
        private String title_ = "";
        private long unixTimestampMs_;

        public static final class Builder extends GeneratedMessageLite.Builder<ScreenView, Builder> implements ScreenViewOrBuilder {
            private Builder() {
                super(ScreenView.DEFAULT_INSTANCE);
            }

            public Builder clearTitle() {
                copyOnWrite();
                ((ScreenView) this.instance).clearTitle();
                return this;
            }

            public Builder clearUnixTimestampMs() {
                copyOnWrite();
                ((ScreenView) this.instance).clearUnixTimestampMs();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ScreenViewOrBuilder
            public String getTitle() {
                return ((ScreenView) this.instance).getTitle();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ScreenViewOrBuilder
            public ByteString getTitleBytes() {
                return ((ScreenView) this.instance).getTitleBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ScreenViewOrBuilder
            public long getUnixTimestampMs() {
                return ((ScreenView) this.instance).getUnixTimestampMs();
            }

            public Builder setTitle(String str) {
                copyOnWrite();
                ((ScreenView) this.instance).setTitle(str);
                return this;
            }

            public Builder setTitleBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((ScreenView) this.instance).setTitleBytes(byteString);
                return this;
            }

            public Builder setUnixTimestampMs(long j) {
                copyOnWrite();
                ((ScreenView) this.instance).setUnixTimestampMs(j);
                return this;
            }
        }

        static {
            ScreenView screenView = new ScreenView();
            DEFAULT_INSTANCE = screenView;
            GeneratedMessageLite.registerDefaultInstance(ScreenView.class, screenView);
        }

        private ScreenView() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTitle() {
            this.title_ = getDefaultInstance().getTitle();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnixTimestampMs() {
            this.unixTimestampMs_ = 0L;
        }

        public static ScreenView getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ScreenView parseDelimitedFrom(InputStream inputStream) {
            return (ScreenView) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ScreenView parseFrom(ByteString byteString) {
            return (ScreenView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<ScreenView> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTitle(String str) {
            str.getClass();
            this.title_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTitleBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.title_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnixTimestampMs(long j) {
            this.unixTimestampMs_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new ScreenView();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0003\u0002Ȉ", new Object[]{"unixTimestampMs_", "title_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ScreenView> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (ScreenView.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ScreenViewOrBuilder
        public String getTitle() {
            return this.title_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ScreenViewOrBuilder
        public ByteString getTitleBytes() {
            return ByteString.copyFromUtf8(this.title_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ScreenViewOrBuilder
        public long getUnixTimestampMs() {
            return this.unixTimestampMs_;
        }

        public static Builder newBuilder(ScreenView screenView) {
            return DEFAULT_INSTANCE.createBuilder(screenView);
        }

        public static ScreenView parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ScreenView) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ScreenView parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ScreenView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ScreenView parseFrom(CodedInputStream codedInputStream) {
            return (ScreenView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ScreenView parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ScreenView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ScreenView parseFrom(InputStream inputStream) {
            return (ScreenView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ScreenView parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ScreenView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ScreenView parseFrom(ByteBuffer byteBuffer) {
            return (ScreenView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ScreenView parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ScreenView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ScreenView parseFrom(byte[] bArr) {
            return (ScreenView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ScreenView parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ScreenView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface ScreenViewOrBuilder extends MessageLiteOrBuilder {
        String getTitle();

        ByteString getTitleBytes();

        long getUnixTimestampMs();
    }

    public static final class StyleMutation extends GeneratedMessageLite<StyleMutation, Builder> implements StyleMutationOrBuilder {
        private static final StyleMutation DEFAULT_INSTANCE;
        private static volatile Parser<StyleMutation> PARSER = null;
        public static final int STYLE_CHANGES_FIELD_NUMBER = 3;
        public static final int UNIX_TIMESTAMP_MS_FIELD_NUMBER = 1;
        public static final int VIEW_ID_FIELD_NUMBER = 2;
        private int bitField0_;
        private ViewStyle styleChanges_;
        private long unixTimestampMs_;
        private long viewId_;

        public static final class Builder extends GeneratedMessageLite.Builder<StyleMutation, Builder> implements StyleMutationOrBuilder {
            private Builder() {
                super(StyleMutation.DEFAULT_INSTANCE);
            }

            public Builder clearStyleChanges() {
                copyOnWrite();
                ((StyleMutation) this.instance).clearStyleChanges();
                return this;
            }

            public Builder clearUnixTimestampMs() {
                copyOnWrite();
                ((StyleMutation) this.instance).clearUnixTimestampMs();
                return this;
            }

            public Builder clearViewId() {
                copyOnWrite();
                ((StyleMutation) this.instance).clearViewId();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.StyleMutationOrBuilder
            public ViewStyle getStyleChanges() {
                return ((StyleMutation) this.instance).getStyleChanges();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.StyleMutationOrBuilder
            public long getUnixTimestampMs() {
                return ((StyleMutation) this.instance).getUnixTimestampMs();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.StyleMutationOrBuilder
            public long getViewId() {
                return ((StyleMutation) this.instance).getViewId();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.StyleMutationOrBuilder
            public boolean hasStyleChanges() {
                return ((StyleMutation) this.instance).hasStyleChanges();
            }

            public Builder mergeStyleChanges(ViewStyle viewStyle) {
                copyOnWrite();
                ((StyleMutation) this.instance).mergeStyleChanges(viewStyle);
                return this;
            }

            public Builder setStyleChanges(ViewStyle.Builder builder) {
                copyOnWrite();
                ((StyleMutation) this.instance).setStyleChanges(builder.build());
                return this;
            }

            public Builder setUnixTimestampMs(long j) {
                copyOnWrite();
                ((StyleMutation) this.instance).setUnixTimestampMs(j);
                return this;
            }

            public Builder setViewId(long j) {
                copyOnWrite();
                ((StyleMutation) this.instance).setViewId(j);
                return this;
            }

            public Builder setStyleChanges(ViewStyle viewStyle) {
                copyOnWrite();
                ((StyleMutation) this.instance).setStyleChanges(viewStyle);
                return this;
            }
        }

        static {
            StyleMutation styleMutation = new StyleMutation();
            DEFAULT_INSTANCE = styleMutation;
            GeneratedMessageLite.registerDefaultInstance(StyleMutation.class, styleMutation);
        }

        private StyleMutation() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStyleChanges() {
            this.styleChanges_ = null;
            this.bitField0_ &= -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnixTimestampMs() {
            this.unixTimestampMs_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearViewId() {
            this.viewId_ = 0L;
        }

        public static StyleMutation getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeStyleChanges(ViewStyle viewStyle) {
            viewStyle.getClass();
            ViewStyle viewStyle2 = this.styleChanges_;
            if (viewStyle2 != null && viewStyle2 != ViewStyle.getDefaultInstance()) {
                viewStyle = ViewStyle.newBuilder(this.styleChanges_).mergeFrom((ViewStyle.Builder) viewStyle).buildPartial();
            }
            this.styleChanges_ = viewStyle;
            this.bitField0_ |= 1;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static StyleMutation parseDelimitedFrom(InputStream inputStream) {
            return (StyleMutation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StyleMutation parseFrom(ByteString byteString) {
            return (StyleMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<StyleMutation> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStyleChanges(ViewStyle viewStyle) {
            viewStyle.getClass();
            this.styleChanges_ = viewStyle;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnixTimestampMs(long j) {
            this.unixTimestampMs_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setViewId(long j) {
            this.viewId_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new StyleMutation();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0003\u0002\u0010\u0003ဉ\u0000", new Object[]{"bitField0_", "unixTimestampMs_", "viewId_", "styleChanges_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StyleMutation> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (StyleMutation.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.StyleMutationOrBuilder
        public ViewStyle getStyleChanges() {
            ViewStyle viewStyle = this.styleChanges_;
            return viewStyle == null ? ViewStyle.getDefaultInstance() : viewStyle;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.StyleMutationOrBuilder
        public long getUnixTimestampMs() {
            return this.unixTimestampMs_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.StyleMutationOrBuilder
        public long getViewId() {
            return this.viewId_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.StyleMutationOrBuilder
        public boolean hasStyleChanges() {
            return (this.bitField0_ & 1) != 0;
        }

        public static Builder newBuilder(StyleMutation styleMutation) {
            return DEFAULT_INSTANCE.createBuilder(styleMutation);
        }

        public static StyleMutation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (StyleMutation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StyleMutation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (StyleMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StyleMutation parseFrom(CodedInputStream codedInputStream) {
            return (StyleMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StyleMutation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (StyleMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static StyleMutation parseFrom(InputStream inputStream) {
            return (StyleMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StyleMutation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (StyleMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StyleMutation parseFrom(ByteBuffer byteBuffer) {
            return (StyleMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StyleMutation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (StyleMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StyleMutation parseFrom(byte[] bArr) {
            return (StyleMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StyleMutation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (StyleMutation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface StyleMutationOrBuilder extends MessageLiteOrBuilder {
        ViewStyle getStyleChanges();

        long getUnixTimestampMs();

        long getViewId();

        boolean hasStyleChanges();
    }

    public static final class TouchGesture extends GeneratedMessageLite<TouchGesture, Builder> implements TouchGestureOrBuilder {
        private static final TouchGesture DEFAULT_INSTANCE;
        private static volatile Parser<TouchGesture> PARSER = null;
        public static final int UNIX_TIMESTAMPS_MS_FIELD_NUMBER = 1;
        public static final int X_POSITIONS_FIELD_NUMBER = 2;
        public static final int Y_POSITIONS_FIELD_NUMBER = 3;
        private int unixTimestampsMsMemoizedSerializedSize = -1;
        private int xPositionsMemoizedSerializedSize = -1;
        private int yPositionsMemoizedSerializedSize = -1;
        private Internal.LongList unixTimestampsMs_ = GeneratedMessageLite.emptyLongList();
        private Internal.IntList xPositions_ = GeneratedMessageLite.emptyIntList();
        private Internal.IntList yPositions_ = GeneratedMessageLite.emptyIntList();

        public static final class Builder extends GeneratedMessageLite.Builder<TouchGesture, Builder> implements TouchGestureOrBuilder {
            private Builder() {
                super(TouchGesture.DEFAULT_INSTANCE);
            }

            public Builder addAllUnixTimestampsMs(Iterable<? extends Long> iterable) {
                copyOnWrite();
                ((TouchGesture) this.instance).addAllUnixTimestampsMs(iterable);
                return this;
            }

            public Builder addAllXPositions(Iterable<? extends Integer> iterable) {
                copyOnWrite();
                ((TouchGesture) this.instance).addAllXPositions(iterable);
                return this;
            }

            public Builder addAllYPositions(Iterable<? extends Integer> iterable) {
                copyOnWrite();
                ((TouchGesture) this.instance).addAllYPositions(iterable);
                return this;
            }

            public Builder addUnixTimestampsMs(long j) {
                copyOnWrite();
                ((TouchGesture) this.instance).addUnixTimestampsMs(j);
                return this;
            }

            public Builder addXPositions(int i) {
                copyOnWrite();
                ((TouchGesture) this.instance).addXPositions(i);
                return this;
            }

            public Builder addYPositions(int i) {
                copyOnWrite();
                ((TouchGesture) this.instance).addYPositions(i);
                return this;
            }

            public Builder clearUnixTimestampsMs() {
                copyOnWrite();
                ((TouchGesture) this.instance).clearUnixTimestampsMs();
                return this;
            }

            public Builder clearXPositions() {
                copyOnWrite();
                ((TouchGesture) this.instance).clearXPositions();
                return this;
            }

            public Builder clearYPositions() {
                copyOnWrite();
                ((TouchGesture) this.instance).clearYPositions();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.TouchGestureOrBuilder
            public long getUnixTimestampsMs(int i) {
                return ((TouchGesture) this.instance).getUnixTimestampsMs(i);
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.TouchGestureOrBuilder
            public int getUnixTimestampsMsCount() {
                return ((TouchGesture) this.instance).getUnixTimestampsMsCount();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.TouchGestureOrBuilder
            public List<Long> getUnixTimestampsMsList() {
                return Collections.unmodifiableList(((TouchGesture) this.instance).getUnixTimestampsMsList());
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.TouchGestureOrBuilder
            public int getXPositions(int i) {
                return ((TouchGesture) this.instance).getXPositions(i);
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.TouchGestureOrBuilder
            public int getXPositionsCount() {
                return ((TouchGesture) this.instance).getXPositionsCount();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.TouchGestureOrBuilder
            public List<Integer> getXPositionsList() {
                return Collections.unmodifiableList(((TouchGesture) this.instance).getXPositionsList());
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.TouchGestureOrBuilder
            public int getYPositions(int i) {
                return ((TouchGesture) this.instance).getYPositions(i);
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.TouchGestureOrBuilder
            public int getYPositionsCount() {
                return ((TouchGesture) this.instance).getYPositionsCount();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.TouchGestureOrBuilder
            public List<Integer> getYPositionsList() {
                return Collections.unmodifiableList(((TouchGesture) this.instance).getYPositionsList());
            }

            public Builder setUnixTimestampsMs(int i, long j) {
                copyOnWrite();
                ((TouchGesture) this.instance).setUnixTimestampsMs(i, j);
                return this;
            }

            public Builder setXPositions(int i, int i2) {
                copyOnWrite();
                ((TouchGesture) this.instance).setXPositions(i, i2);
                return this;
            }

            public Builder setYPositions(int i, int i2) {
                copyOnWrite();
                ((TouchGesture) this.instance).setYPositions(i, i2);
                return this;
            }
        }

        static {
            TouchGesture touchGesture = new TouchGesture();
            DEFAULT_INSTANCE = touchGesture;
            GeneratedMessageLite.registerDefaultInstance(TouchGesture.class, touchGesture);
        }

        private TouchGesture() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllUnixTimestampsMs(Iterable<? extends Long> iterable) {
            ensureUnixTimestampsMsIsMutable();
            AbstractMessageLite.addAll(iterable, this.unixTimestampsMs_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllXPositions(Iterable<? extends Integer> iterable) {
            ensureXPositionsIsMutable();
            AbstractMessageLite.addAll(iterable, this.xPositions_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllYPositions(Iterable<? extends Integer> iterable) {
            ensureYPositionsIsMutable();
            AbstractMessageLite.addAll(iterable, this.yPositions_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUnixTimestampsMs(long j) {
            ensureUnixTimestampsMsIsMutable();
            this.unixTimestampsMs_.addLong(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addXPositions(int i) {
            ensureXPositionsIsMutable();
            this.xPositions_.addInt(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addYPositions(int i) {
            ensureYPositionsIsMutable();
            this.yPositions_.addInt(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnixTimestampsMs() {
            this.unixTimestampsMs_ = GeneratedMessageLite.emptyLongList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXPositions() {
            this.xPositions_ = GeneratedMessageLite.emptyIntList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearYPositions() {
            this.yPositions_ = GeneratedMessageLite.emptyIntList();
        }

        private void ensureUnixTimestampsMsIsMutable() {
            Internal.LongList longList = this.unixTimestampsMs_;
            if (longList.isModifiable()) {
                return;
            }
            this.unixTimestampsMs_ = GeneratedMessageLite.mutableCopy(longList);
        }

        private void ensureXPositionsIsMutable() {
            Internal.IntList intList = this.xPositions_;
            if (intList.isModifiable()) {
                return;
            }
            this.xPositions_ = GeneratedMessageLite.mutableCopy(intList);
        }

        private void ensureYPositionsIsMutable() {
            Internal.IntList intList = this.yPositions_;
            if (intList.isModifiable()) {
                return;
            }
            this.yPositions_ = GeneratedMessageLite.mutableCopy(intList);
        }

        public static TouchGesture getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TouchGesture parseDelimitedFrom(InputStream inputStream) {
            return (TouchGesture) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TouchGesture parseFrom(ByteString byteString) {
            return (TouchGesture) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<TouchGesture> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnixTimestampsMs(int i, long j) {
            ensureUnixTimestampsMsIsMutable();
            this.unixTimestampsMs_.setLong(i, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXPositions(int i, int i2) {
            ensureXPositionsIsMutable();
            this.xPositions_.setInt(i, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setYPositions(int i, int i2) {
            ensureYPositionsIsMutable();
            this.yPositions_.setInt(i, i2);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new TouchGesture();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0003\u0000\u0001&\u0002/\u0003/", new Object[]{"unixTimestampsMs_", "xPositions_", "yPositions_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<TouchGesture> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (TouchGesture.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.TouchGestureOrBuilder
        public long getUnixTimestampsMs(int i) {
            return this.unixTimestampsMs_.getLong(i);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.TouchGestureOrBuilder
        public int getUnixTimestampsMsCount() {
            return this.unixTimestampsMs_.size();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.TouchGestureOrBuilder
        public List<Long> getUnixTimestampsMsList() {
            return this.unixTimestampsMs_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.TouchGestureOrBuilder
        public int getXPositions(int i) {
            return this.xPositions_.getInt(i);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.TouchGestureOrBuilder
        public int getXPositionsCount() {
            return this.xPositions_.size();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.TouchGestureOrBuilder
        public List<Integer> getXPositionsList() {
            return this.xPositions_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.TouchGestureOrBuilder
        public int getYPositions(int i) {
            return this.yPositions_.getInt(i);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.TouchGestureOrBuilder
        public int getYPositionsCount() {
            return this.yPositions_.size();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.TouchGestureOrBuilder
        public List<Integer> getYPositionsList() {
            return this.yPositions_;
        }

        public static Builder newBuilder(TouchGesture touchGesture) {
            return DEFAULT_INSTANCE.createBuilder(touchGesture);
        }

        public static TouchGesture parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TouchGesture) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TouchGesture parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (TouchGesture) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static TouchGesture parseFrom(CodedInputStream codedInputStream) {
            return (TouchGesture) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static TouchGesture parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TouchGesture) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static TouchGesture parseFrom(InputStream inputStream) {
            return (TouchGesture) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TouchGesture parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (TouchGesture) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TouchGesture parseFrom(ByteBuffer byteBuffer) {
            return (TouchGesture) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static TouchGesture parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (TouchGesture) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static TouchGesture parseFrom(byte[] bArr) {
            return (TouchGesture) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TouchGesture parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (TouchGesture) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface TouchGestureOrBuilder extends MessageLiteOrBuilder {
        long getUnixTimestampsMs(int i);

        int getUnixTimestampsMsCount();

        List<Long> getUnixTimestampsMsList();

        int getXPositions(int i);

        int getXPositionsCount();

        List<Integer> getXPositionsList();

        int getYPositions(int i);

        int getYPositionsCount();

        List<Integer> getYPositionsList();
    }

    public static final class View extends GeneratedMessageLite<View, Builder> implements ViewOrBuilder {
        public static final int CHILDREN_FIELD_NUMBER = 4;
        private static final View DEFAULT_INSTANCE;
        public static final int FORMAT_FIELD_NUMBER = 1;
        public static final int METADATA_FIELD_NUMBER = 5;
        private static volatile Parser<View> PARSER = null;
        public static final int RECORDING_ID_FIELD_NUMBER = 2;
        public static final int STYLE_FIELD_NUMBER = 3;
        private int bitField0_;
        private Internal.ProtobufList<View> children_ = GeneratedMessageLite.emptyProtobufList();
        private int format_;
        private GraphMetadata metadata_;
        private long recordingId_;
        private ViewStyle style_;

        public static final class Builder extends GeneratedMessageLite.Builder<View, Builder> implements ViewOrBuilder {
            private Builder() {
                super(View.DEFAULT_INSTANCE);
            }

            public Builder addAllChildren(Iterable<? extends View> iterable) {
                copyOnWrite();
                ((View) this.instance).addAllChildren(iterable);
                return this;
            }

            public Builder addChildren(int i, Builder builder) {
                copyOnWrite();
                ((View) this.instance).addChildren(i, builder.build());
                return this;
            }

            public Builder clearChildren() {
                copyOnWrite();
                ((View) this.instance).clearChildren();
                return this;
            }

            public Builder clearFormat() {
                copyOnWrite();
                ((View) this.instance).clearFormat();
                return this;
            }

            public Builder clearMetadata() {
                copyOnWrite();
                ((View) this.instance).clearMetadata();
                return this;
            }

            public Builder clearRecordingId() {
                copyOnWrite();
                ((View) this.instance).clearRecordingId();
                return this;
            }

            public Builder clearStyle() {
                copyOnWrite();
                ((View) this.instance).clearStyle();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewOrBuilder
            public View getChildren(int i) {
                return ((View) this.instance).getChildren(i);
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewOrBuilder
            public int getChildrenCount() {
                return ((View) this.instance).getChildrenCount();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewOrBuilder
            public List<View> getChildrenList() {
                return Collections.unmodifiableList(((View) this.instance).getChildrenList());
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewOrBuilder
            public Format getFormat() {
                return ((View) this.instance).getFormat();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewOrBuilder
            public int getFormatValue() {
                return ((View) this.instance).getFormatValue();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewOrBuilder
            public GraphMetadata getMetadata() {
                return ((View) this.instance).getMetadata();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewOrBuilder
            public long getRecordingId() {
                return ((View) this.instance).getRecordingId();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewOrBuilder
            public ViewStyle getStyle() {
                return ((View) this.instance).getStyle();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewOrBuilder
            public boolean hasMetadata() {
                return ((View) this.instance).hasMetadata();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewOrBuilder
            public boolean hasStyle() {
                return ((View) this.instance).hasStyle();
            }

            public Builder mergeMetadata(GraphMetadata graphMetadata) {
                copyOnWrite();
                ((View) this.instance).mergeMetadata(graphMetadata);
                return this;
            }

            public Builder mergeStyle(ViewStyle viewStyle) {
                copyOnWrite();
                ((View) this.instance).mergeStyle(viewStyle);
                return this;
            }

            public Builder removeChildren(int i) {
                copyOnWrite();
                ((View) this.instance).removeChildren(i);
                return this;
            }

            public Builder setChildren(int i, Builder builder) {
                copyOnWrite();
                ((View) this.instance).setChildren(i, builder.build());
                return this;
            }

            public Builder setFormat(Format format) {
                copyOnWrite();
                ((View) this.instance).setFormat(format);
                return this;
            }

            public Builder setFormatValue(int i) {
                copyOnWrite();
                ((View) this.instance).setFormatValue(i);
                return this;
            }

            public Builder setMetadata(GraphMetadata.Builder builder) {
                copyOnWrite();
                ((View) this.instance).setMetadata(builder.build());
                return this;
            }

            public Builder setRecordingId(long j) {
                copyOnWrite();
                ((View) this.instance).setRecordingId(j);
                return this;
            }

            public Builder setStyle(ViewStyle.Builder builder) {
                copyOnWrite();
                ((View) this.instance).setStyle(builder.build());
                return this;
            }

            public Builder addChildren(int i, View view) {
                copyOnWrite();
                ((View) this.instance).addChildren(i, view);
                return this;
            }

            public Builder setChildren(int i, View view) {
                copyOnWrite();
                ((View) this.instance).setChildren(i, view);
                return this;
            }

            public Builder setMetadata(GraphMetadata graphMetadata) {
                copyOnWrite();
                ((View) this.instance).setMetadata(graphMetadata);
                return this;
            }

            public Builder setStyle(ViewStyle viewStyle) {
                copyOnWrite();
                ((View) this.instance).setStyle(viewStyle);
                return this;
            }

            public Builder addChildren(Builder builder) {
                copyOnWrite();
                ((View) this.instance).addChildren(builder.build());
                return this;
            }

            public Builder addChildren(View view) {
                copyOnWrite();
                ((View) this.instance).addChildren(view);
                return this;
            }
        }

        public enum Format implements Internal.EnumLite {
            FORMAT_UNSPECIFIED(0),
            FORMAT_WEB_ELEMENT(1),
            FORMAT_NATIVE_VIEW(2),
            FORMAT_WEB_VIEW_CONTAINER(3),
            UNRECOGNIZED(-1);

            public static final int FORMAT_NATIVE_VIEW_VALUE = 2;
            public static final int FORMAT_UNSPECIFIED_VALUE = 0;
            public static final int FORMAT_WEB_ELEMENT_VALUE = 1;
            public static final int FORMAT_WEB_VIEW_CONTAINER_VALUE = 3;
            private static final Internal.EnumLiteMap<Format> internalValueMap = new Internal.EnumLiteMap<Format>() { // from class: com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.View.Format.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Format findValueByNumber(int i) {
                    return Format.forNumber(i);
                }
            };
            private final int value;

            public static final class FormatVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new FormatVerifier();

                private FormatVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return Format.forNumber(i) != null;
                }
            }

            Format(int i) {
                this.value = i;
            }

            public static Format forNumber(int i) {
                if (i == 0) {
                    return FORMAT_UNSPECIFIED;
                }
                if (i == 1) {
                    return FORMAT_WEB_ELEMENT;
                }
                if (i == 2) {
                    return FORMAT_NATIVE_VIEW;
                }
                if (i != 3) {
                    return null;
                }
                return FORMAT_WEB_VIEW_CONTAINER;
            }

            public static Internal.EnumLiteMap<Format> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return FormatVerifier.INSTANCE;
            }

            @Deprecated
            public static Format valueOf(int i) {
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

        static {
            View view = new View();
            DEFAULT_INSTANCE = view;
            GeneratedMessageLite.registerDefaultInstance(View.class, view);
        }

        private View() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllChildren(Iterable<? extends View> iterable) {
            ensureChildrenIsMutable();
            AbstractMessageLite.addAll(iterable, this.children_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addChildren(int i, View view) {
            view.getClass();
            ensureChildrenIsMutable();
            this.children_.add(i, view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChildren() {
            this.children_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFormat() {
            this.format_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMetadata() {
            this.metadata_ = null;
            this.bitField0_ &= -3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRecordingId() {
            this.recordingId_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStyle() {
            this.style_ = null;
            this.bitField0_ &= -2;
        }

        private void ensureChildrenIsMutable() {
            Internal.ProtobufList<View> protobufList = this.children_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.children_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static View getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeMetadata(GraphMetadata graphMetadata) {
            graphMetadata.getClass();
            GraphMetadata graphMetadata2 = this.metadata_;
            if (graphMetadata2 != null && graphMetadata2 != GraphMetadata.getDefaultInstance()) {
                graphMetadata = GraphMetadata.newBuilder(this.metadata_).mergeFrom((GraphMetadata.Builder) graphMetadata).buildPartial();
            }
            this.metadata_ = graphMetadata;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeStyle(ViewStyle viewStyle) {
            viewStyle.getClass();
            ViewStyle viewStyle2 = this.style_;
            if (viewStyle2 != null && viewStyle2 != ViewStyle.getDefaultInstance()) {
                viewStyle = ViewStyle.newBuilder(this.style_).mergeFrom((ViewStyle.Builder) viewStyle).buildPartial();
            }
            this.style_ = viewStyle;
            this.bitField0_ |= 1;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static View parseDelimitedFrom(InputStream inputStream) {
            return (View) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static View parseFrom(ByteString byteString) {
            return (View) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<View> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeChildren(int i) {
            ensureChildrenIsMutable();
            this.children_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChildren(int i, View view) {
            view.getClass();
            ensureChildrenIsMutable();
            this.children_.set(i, view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFormat(Format format) {
            this.format_ = format.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFormatValue(int i) {
            this.format_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMetadata(GraphMetadata graphMetadata) {
            graphMetadata.getClass();
            this.metadata_ = graphMetadata;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRecordingId(long j) {
            this.recordingId_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStyle(ViewStyle viewStyle) {
            viewStyle.getClass();
            this.style_ = viewStyle;
            this.bitField0_ |= 1;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new View();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\f\u0002\u0010\u0003ဉ\u0000\u0004\u001b\u0005ဉ\u0001", new Object[]{"bitField0_", "format_", "recordingId_", "style_", "children_", View.class, "metadata_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<View> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (View.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewOrBuilder
        public View getChildren(int i) {
            return this.children_.get(i);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewOrBuilder
        public int getChildrenCount() {
            return this.children_.size();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewOrBuilder
        public List<View> getChildrenList() {
            return this.children_;
        }

        public ViewOrBuilder getChildrenOrBuilder(int i) {
            return this.children_.get(i);
        }

        public List<? extends ViewOrBuilder> getChildrenOrBuilderList() {
            return this.children_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewOrBuilder
        public Format getFormat() {
            Format formatForNumber = Format.forNumber(this.format_);
            return formatForNumber == null ? Format.UNRECOGNIZED : formatForNumber;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewOrBuilder
        public int getFormatValue() {
            return this.format_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewOrBuilder
        public GraphMetadata getMetadata() {
            GraphMetadata graphMetadata = this.metadata_;
            return graphMetadata == null ? GraphMetadata.getDefaultInstance() : graphMetadata;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewOrBuilder
        public long getRecordingId() {
            return this.recordingId_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewOrBuilder
        public ViewStyle getStyle() {
            ViewStyle viewStyle = this.style_;
            return viewStyle == null ? ViewStyle.getDefaultInstance() : viewStyle;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewOrBuilder
        public boolean hasMetadata() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewOrBuilder
        public boolean hasStyle() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addChildren(View view) {
            view.getClass();
            ensureChildrenIsMutable();
            this.children_.add(view);
        }

        public static Builder newBuilder(View view) {
            return DEFAULT_INSTANCE.createBuilder(view);
        }

        public static View parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (View) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static View parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (View) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static View parseFrom(CodedInputStream codedInputStream) {
            return (View) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static View parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (View) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static View parseFrom(InputStream inputStream) {
            return (View) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static View parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (View) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static View parseFrom(ByteBuffer byteBuffer) {
            return (View) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static View parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (View) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static View parseFrom(byte[] bArr) {
            return (View) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static View parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (View) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public static final class ViewHtmlText extends GeneratedMessageLite<ViewHtmlText, Builder> implements ViewHtmlTextOrBuilder {
        public static final int CONTENT_FIELD_NUMBER = 1;
        private static final ViewHtmlText DEFAULT_INSTANCE;
        public static final int FONT_NAMES_FIELD_NUMBER = 3;
        public static final int NUMBER_OF_LINES_FIELD_NUMBER = 2;
        private static volatile Parser<ViewHtmlText> PARSER;
        private String content_ = "";
        private Internal.ProtobufList<String> fontNames_ = GeneratedMessageLite.emptyProtobufList();
        private int numberOfLines_;

        public static final class Builder extends GeneratedMessageLite.Builder<ViewHtmlText, Builder> implements ViewHtmlTextOrBuilder {
            private Builder() {
                super(ViewHtmlText.DEFAULT_INSTANCE);
            }

            public Builder addAllFontNames(Iterable<String> iterable) {
                copyOnWrite();
                ((ViewHtmlText) this.instance).addAllFontNames(iterable);
                return this;
            }

            public Builder addFontNames(String str) {
                copyOnWrite();
                ((ViewHtmlText) this.instance).addFontNames(str);
                return this;
            }

            public Builder addFontNamesBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((ViewHtmlText) this.instance).addFontNamesBytes(byteString);
                return this;
            }

            public Builder clearContent() {
                copyOnWrite();
                ((ViewHtmlText) this.instance).clearContent();
                return this;
            }

            public Builder clearFontNames() {
                copyOnWrite();
                ((ViewHtmlText) this.instance).clearFontNames();
                return this;
            }

            public Builder clearNumberOfLines() {
                copyOnWrite();
                ((ViewHtmlText) this.instance).clearNumberOfLines();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewHtmlTextOrBuilder
            public String getContent() {
                return ((ViewHtmlText) this.instance).getContent();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewHtmlTextOrBuilder
            public ByteString getContentBytes() {
                return ((ViewHtmlText) this.instance).getContentBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewHtmlTextOrBuilder
            public String getFontNames(int i) {
                return ((ViewHtmlText) this.instance).getFontNames(i);
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewHtmlTextOrBuilder
            public ByteString getFontNamesBytes(int i) {
                return ((ViewHtmlText) this.instance).getFontNamesBytes(i);
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewHtmlTextOrBuilder
            public int getFontNamesCount() {
                return ((ViewHtmlText) this.instance).getFontNamesCount();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewHtmlTextOrBuilder
            public List<String> getFontNamesList() {
                return Collections.unmodifiableList(((ViewHtmlText) this.instance).getFontNamesList());
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewHtmlTextOrBuilder
            public int getNumberOfLines() {
                return ((ViewHtmlText) this.instance).getNumberOfLines();
            }

            public Builder setContent(String str) {
                copyOnWrite();
                ((ViewHtmlText) this.instance).setContent(str);
                return this;
            }

            public Builder setContentBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((ViewHtmlText) this.instance).setContentBytes(byteString);
                return this;
            }

            public Builder setFontNames(int i, String str) {
                copyOnWrite();
                ((ViewHtmlText) this.instance).setFontNames(i, str);
                return this;
            }

            public Builder setNumberOfLines(int i) {
                copyOnWrite();
                ((ViewHtmlText) this.instance).setNumberOfLines(i);
                return this;
            }
        }

        static {
            ViewHtmlText viewHtmlText = new ViewHtmlText();
            DEFAULT_INSTANCE = viewHtmlText;
            GeneratedMessageLite.registerDefaultInstance(ViewHtmlText.class, viewHtmlText);
        }

        private ViewHtmlText() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllFontNames(Iterable<String> iterable) {
            ensureFontNamesIsMutable();
            AbstractMessageLite.addAll(iterable, this.fontNames_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFontNames(String str) {
            str.getClass();
            ensureFontNamesIsMutable();
            this.fontNames_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFontNamesBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            ensureFontNamesIsMutable();
            this.fontNames_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearContent() {
            this.content_ = getDefaultInstance().getContent();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFontNames() {
            this.fontNames_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNumberOfLines() {
            this.numberOfLines_ = 0;
        }

        private void ensureFontNamesIsMutable() {
            Internal.ProtobufList<String> protobufList = this.fontNames_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.fontNames_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static ViewHtmlText getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ViewHtmlText parseDelimitedFrom(InputStream inputStream) {
            return (ViewHtmlText) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ViewHtmlText parseFrom(ByteString byteString) {
            return (ViewHtmlText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<ViewHtmlText> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContent(String str) {
            str.getClass();
            this.content_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContentBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.content_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFontNames(int i, String str) {
            str.getClass();
            ensureFontNamesIsMutable();
            this.fontNames_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNumberOfLines(int i) {
            this.numberOfLines_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new ViewHtmlText();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u000b\u0003Ț", new Object[]{"content_", "numberOfLines_", "fontNames_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ViewHtmlText> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (ViewHtmlText.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewHtmlTextOrBuilder
        public String getContent() {
            return this.content_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewHtmlTextOrBuilder
        public ByteString getContentBytes() {
            return ByteString.copyFromUtf8(this.content_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewHtmlTextOrBuilder
        public String getFontNames(int i) {
            return this.fontNames_.get(i);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewHtmlTextOrBuilder
        public ByteString getFontNamesBytes(int i) {
            return ByteString.copyFromUtf8(this.fontNames_.get(i));
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewHtmlTextOrBuilder
        public int getFontNamesCount() {
            return this.fontNames_.size();
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewHtmlTextOrBuilder
        public List<String> getFontNamesList() {
            return this.fontNames_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewHtmlTextOrBuilder
        public int getNumberOfLines() {
            return this.numberOfLines_;
        }

        public static Builder newBuilder(ViewHtmlText viewHtmlText) {
            return DEFAULT_INSTANCE.createBuilder(viewHtmlText);
        }

        public static ViewHtmlText parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewHtmlText) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ViewHtmlText parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewHtmlText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ViewHtmlText parseFrom(CodedInputStream codedInputStream) {
            return (ViewHtmlText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ViewHtmlText parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewHtmlText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ViewHtmlText parseFrom(InputStream inputStream) {
            return (ViewHtmlText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ViewHtmlText parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewHtmlText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ViewHtmlText parseFrom(ByteBuffer byteBuffer) {
            return (ViewHtmlText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ViewHtmlText parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewHtmlText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ViewHtmlText parseFrom(byte[] bArr) {
            return (ViewHtmlText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ViewHtmlText parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewHtmlText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface ViewHtmlTextOrBuilder extends MessageLiteOrBuilder {
        String getContent();

        ByteString getContentBytes();

        String getFontNames(int i);

        ByteString getFontNamesBytes(int i);

        int getFontNamesCount();

        List<String> getFontNamesList();

        int getNumberOfLines();
    }

    public interface ViewOrBuilder extends MessageLiteOrBuilder {
        View getChildren(int i);

        int getChildrenCount();

        List<View> getChildrenList();

        View.Format getFormat();

        int getFormatValue();

        GraphMetadata getMetadata();

        long getRecordingId();

        ViewStyle getStyle();

        boolean hasMetadata();

        boolean hasStyle();
    }

    public static final class ViewShadow extends GeneratedMessageLite<ViewShadow, Builder> implements ViewShadowOrBuilder {
        private static final ViewShadow DEFAULT_INSTANCE;
        public static final int OFFSET_X_FIELD_NUMBER = 1;
        public static final int OFFSET_Y_FIELD_NUMBER = 2;
        public static final int OPACITY_FIELD_NUMBER = 3;
        private static volatile Parser<ViewShadow> PARSER = null;
        public static final int RADIUS_FIELD_NUMBER = 4;
        private float offsetX_;
        private float offsetY_;
        private float opacity_;
        private float radius_;

        public static final class Builder extends GeneratedMessageLite.Builder<ViewShadow, Builder> implements ViewShadowOrBuilder {
            private Builder() {
                super(ViewShadow.DEFAULT_INSTANCE);
            }

            public Builder clearOffsetX() {
                copyOnWrite();
                ((ViewShadow) this.instance).clearOffsetX();
                return this;
            }

            public Builder clearOffsetY() {
                copyOnWrite();
                ((ViewShadow) this.instance).clearOffsetY();
                return this;
            }

            public Builder clearOpacity() {
                copyOnWrite();
                ((ViewShadow) this.instance).clearOpacity();
                return this;
            }

            public Builder clearRadius() {
                copyOnWrite();
                ((ViewShadow) this.instance).clearRadius();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewShadowOrBuilder
            public float getOffsetX() {
                return ((ViewShadow) this.instance).getOffsetX();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewShadowOrBuilder
            public float getOffsetY() {
                return ((ViewShadow) this.instance).getOffsetY();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewShadowOrBuilder
            public float getOpacity() {
                return ((ViewShadow) this.instance).getOpacity();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewShadowOrBuilder
            public float getRadius() {
                return ((ViewShadow) this.instance).getRadius();
            }

            public Builder setOffsetX(float f) {
                copyOnWrite();
                ((ViewShadow) this.instance).setOffsetX(f);
                return this;
            }

            public Builder setOffsetY(float f) {
                copyOnWrite();
                ((ViewShadow) this.instance).setOffsetY(f);
                return this;
            }

            public Builder setOpacity(float f) {
                copyOnWrite();
                ((ViewShadow) this.instance).setOpacity(f);
                return this;
            }

            public Builder setRadius(float f) {
                copyOnWrite();
                ((ViewShadow) this.instance).setRadius(f);
                return this;
            }
        }

        static {
            ViewShadow viewShadow = new ViewShadow();
            DEFAULT_INSTANCE = viewShadow;
            GeneratedMessageLite.registerDefaultInstance(ViewShadow.class, viewShadow);
        }

        private ViewShadow() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOffsetX() {
            this.offsetX_ = BitmapDescriptorFactory.HUE_RED;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOffsetY() {
            this.offsetY_ = BitmapDescriptorFactory.HUE_RED;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOpacity() {
            this.opacity_ = BitmapDescriptorFactory.HUE_RED;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRadius() {
            this.radius_ = BitmapDescriptorFactory.HUE_RED;
        }

        public static ViewShadow getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ViewShadow parseDelimitedFrom(InputStream inputStream) {
            return (ViewShadow) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ViewShadow parseFrom(ByteString byteString) {
            return (ViewShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<ViewShadow> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOffsetX(float f) {
            this.offsetX_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOffsetY(float f) {
            this.offsetY_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOpacity(float f) {
            this.opacity_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRadius(float f) {
            this.radius_ = f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new ViewShadow();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0001\u0002\u0001\u0003\u0001\u0004\u0001", new Object[]{"offsetX_", "offsetY_", "opacity_", "radius_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ViewShadow> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (ViewShadow.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewShadowOrBuilder
        public float getOffsetX() {
            return this.offsetX_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewShadowOrBuilder
        public float getOffsetY() {
            return this.offsetY_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewShadowOrBuilder
        public float getOpacity() {
            return this.opacity_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewShadowOrBuilder
        public float getRadius() {
            return this.radius_;
        }

        public static Builder newBuilder(ViewShadow viewShadow) {
            return DEFAULT_INSTANCE.createBuilder(viewShadow);
        }

        public static ViewShadow parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewShadow) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ViewShadow parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ViewShadow parseFrom(CodedInputStream codedInputStream) {
            return (ViewShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ViewShadow parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ViewShadow parseFrom(InputStream inputStream) {
            return (ViewShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ViewShadow parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ViewShadow parseFrom(ByteBuffer byteBuffer) {
            return (ViewShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ViewShadow parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ViewShadow parseFrom(byte[] bArr) {
            return (ViewShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ViewShadow parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface ViewShadowOrBuilder extends MessageLiteOrBuilder {
        float getOffsetX();

        float getOffsetY();

        float getOpacity();

        float getRadius();
    }

    public static final class ViewStyle extends GeneratedMessageLite<ViewStyle, Builder> implements ViewStyleOrBuilder {
        public static final int ALPHA_FIELD_NUMBER = 9;
        public static final int BACKGROUND_COLOR_HEX_FIELD_NUMBER = 8;
        public static final int BITMAP_FIELD_NUMBER = 13;
        public static final int BITMAP_HASH_FIELD_NUMBER = 14;
        public static final int CLIP_CHILDREN_FIELD_NUMBER = 12;
        public static final int CONTENT_OFFSET_X_FIELD_NUMBER = 10;
        public static final int CONTENT_OFFSET_Y_FIELD_NUMBER = 11;
        public static final int CORNER_RADIUS_FIELD_NUMBER = 5;
        private static final ViewStyle DEFAULT_INSTANCE;
        public static final int HEIGHT_FIELD_NUMBER = 4;
        public static final int HTML_TEXT_FIELD_NUMBER = 17;
        public static final int INTERACTION_ENABLED_FIELD_NUMBER = 21;
        public static final int IS_BLUR_FIELD_NUMBER = 19;
        public static final int IS_VISIBLE_FIELD_NUMBER = 7;
        public static final int KEYBOARD_TYPE_FIELD_NUMBER = 18;
        private static volatile Parser<ViewStyle> PARSER = null;
        public static final int PLACEHOLDER_FIELD_NUMBER = 15;
        public static final int SERIALIZED_TEXT_FIELD_NUMBER = 22;
        public static final int SHADOW_FIELD_NUMBER = 6;
        public static final int TEXT_FIELD_NUMBER = 16;
        public static final int WIDTH_FIELD_NUMBER = 3;
        public static final int X_FIELD_NUMBER = 1;
        public static final int Y_FIELD_NUMBER = 2;
        public static final int Z_FIELD_NUMBER = 20;
        private float alpha_;
        private int bitField0_;
        private boolean clipChildren_;
        private int contentOffsetX_;
        private int contentOffsetY_;
        private float cornerRadius_;
        private int height_;
        private ViewHtmlText htmlText_;
        private boolean interactionEnabled_;
        private boolean isBlur_;
        private boolean isVisible_;
        private int placeholder_;
        private ViewHtmlText serializedText_;
        private ViewShadow shadow_;
        private ViewText text_;
        private int width_;
        private int x_;
        private int y_;
        private float z_;
        private String backgroundColorHex_ = "";
        private ByteString bitmap_ = ByteString.EMPTY;
        private String bitmapHash_ = "";
        private String keyboardType_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<ViewStyle, Builder> implements ViewStyleOrBuilder {
            private Builder() {
                super(ViewStyle.DEFAULT_INSTANCE);
            }

            public Builder clearAlpha() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearAlpha();
                return this;
            }

            public Builder clearBackgroundColorHex() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearBackgroundColorHex();
                return this;
            }

            public Builder clearBitmap() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearBitmap();
                return this;
            }

            public Builder clearBitmapHash() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearBitmapHash();
                return this;
            }

            public Builder clearClipChildren() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearClipChildren();
                return this;
            }

            public Builder clearContentOffsetX() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearContentOffsetX();
                return this;
            }

            public Builder clearContentOffsetY() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearContentOffsetY();
                return this;
            }

            public Builder clearCornerRadius() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearCornerRadius();
                return this;
            }

            public Builder clearHeight() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearHeight();
                return this;
            }

            public Builder clearHtmlText() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearHtmlText();
                return this;
            }

            public Builder clearInteractionEnabled() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearInteractionEnabled();
                return this;
            }

            public Builder clearIsBlur() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearIsBlur();
                return this;
            }

            public Builder clearIsVisible() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearIsVisible();
                return this;
            }

            public Builder clearKeyboardType() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearKeyboardType();
                return this;
            }

            public Builder clearPlaceholder() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearPlaceholder();
                return this;
            }

            public Builder clearSerializedText() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearSerializedText();
                return this;
            }

            public Builder clearShadow() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearShadow();
                return this;
            }

            public Builder clearText() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearText();
                return this;
            }

            public Builder clearWidth() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearWidth();
                return this;
            }

            public Builder clearX() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearX();
                return this;
            }

            public Builder clearY() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearY();
                return this;
            }

            public Builder clearZ() {
                copyOnWrite();
                ((ViewStyle) this.instance).clearZ();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public float getAlpha() {
                return ((ViewStyle) this.instance).getAlpha();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public String getBackgroundColorHex() {
                return ((ViewStyle) this.instance).getBackgroundColorHex();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public ByteString getBackgroundColorHexBytes() {
                return ((ViewStyle) this.instance).getBackgroundColorHexBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public ByteString getBitmap() {
                return ((ViewStyle) this.instance).getBitmap();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public String getBitmapHash() {
                return ((ViewStyle) this.instance).getBitmapHash();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public ByteString getBitmapHashBytes() {
                return ((ViewStyle) this.instance).getBitmapHashBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean getClipChildren() {
                return ((ViewStyle) this.instance).getClipChildren();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public int getContentOffsetX() {
                return ((ViewStyle) this.instance).getContentOffsetX();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public int getContentOffsetY() {
                return ((ViewStyle) this.instance).getContentOffsetY();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public float getCornerRadius() {
                return ((ViewStyle) this.instance).getCornerRadius();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public int getHeight() {
                return ((ViewStyle) this.instance).getHeight();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public ViewHtmlText getHtmlText() {
                return ((ViewStyle) this.instance).getHtmlText();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean getInteractionEnabled() {
                return ((ViewStyle) this.instance).getInteractionEnabled();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean getIsBlur() {
                return ((ViewStyle) this.instance).getIsBlur();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean getIsVisible() {
                return ((ViewStyle) this.instance).getIsVisible();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public String getKeyboardType() {
                return ((ViewStyle) this.instance).getKeyboardType();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public ByteString getKeyboardTypeBytes() {
                return ((ViewStyle) this.instance).getKeyboardTypeBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public Placeholder getPlaceholder() {
                return ((ViewStyle) this.instance).getPlaceholder();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public int getPlaceholderValue() {
                return ((ViewStyle) this.instance).getPlaceholderValue();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public ViewHtmlText getSerializedText() {
                return ((ViewStyle) this.instance).getSerializedText();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public ViewShadow getShadow() {
                return ((ViewStyle) this.instance).getShadow();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public ViewText getText() {
                return ((ViewStyle) this.instance).getText();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public int getWidth() {
                return ((ViewStyle) this.instance).getWidth();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public int getX() {
                return ((ViewStyle) this.instance).getX();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public int getY() {
                return ((ViewStyle) this.instance).getY();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public float getZ() {
                return ((ViewStyle) this.instance).getZ();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean hasAlpha() {
                return ((ViewStyle) this.instance).hasAlpha();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean hasBackgroundColorHex() {
                return ((ViewStyle) this.instance).hasBackgroundColorHex();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean hasBitmap() {
                return ((ViewStyle) this.instance).hasBitmap();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean hasBitmapHash() {
                return ((ViewStyle) this.instance).hasBitmapHash();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean hasClipChildren() {
                return ((ViewStyle) this.instance).hasClipChildren();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean hasContentOffsetX() {
                return ((ViewStyle) this.instance).hasContentOffsetX();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean hasContentOffsetY() {
                return ((ViewStyle) this.instance).hasContentOffsetY();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean hasCornerRadius() {
                return ((ViewStyle) this.instance).hasCornerRadius();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean hasHeight() {
                return ((ViewStyle) this.instance).hasHeight();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean hasHtmlText() {
                return ((ViewStyle) this.instance).hasHtmlText();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean hasIsBlur() {
                return ((ViewStyle) this.instance).hasIsBlur();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean hasIsVisible() {
                return ((ViewStyle) this.instance).hasIsVisible();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean hasKeyboardType() {
                return ((ViewStyle) this.instance).hasKeyboardType();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean hasPlaceholder() {
                return ((ViewStyle) this.instance).hasPlaceholder();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean hasSerializedText() {
                return ((ViewStyle) this.instance).hasSerializedText();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean hasShadow() {
                return ((ViewStyle) this.instance).hasShadow();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean hasText() {
                return ((ViewStyle) this.instance).hasText();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean hasWidth() {
                return ((ViewStyle) this.instance).hasWidth();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean hasX() {
                return ((ViewStyle) this.instance).hasX();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean hasY() {
                return ((ViewStyle) this.instance).hasY();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
            public boolean hasZ() {
                return ((ViewStyle) this.instance).hasZ();
            }

            public Builder mergeHtmlText(ViewHtmlText viewHtmlText) {
                copyOnWrite();
                ((ViewStyle) this.instance).mergeHtmlText(viewHtmlText);
                return this;
            }

            public Builder mergeSerializedText(ViewHtmlText viewHtmlText) {
                copyOnWrite();
                ((ViewStyle) this.instance).mergeSerializedText(viewHtmlText);
                return this;
            }

            public Builder mergeShadow(ViewShadow viewShadow) {
                copyOnWrite();
                ((ViewStyle) this.instance).mergeShadow(viewShadow);
                return this;
            }

            public Builder mergeText(ViewText viewText) {
                copyOnWrite();
                ((ViewStyle) this.instance).mergeText(viewText);
                return this;
            }

            public Builder setAlpha(float f) {
                copyOnWrite();
                ((ViewStyle) this.instance).setAlpha(f);
                return this;
            }

            public Builder setBackgroundColorHex(String str) {
                copyOnWrite();
                ((ViewStyle) this.instance).setBackgroundColorHex(str);
                return this;
            }

            public Builder setBackgroundColorHexBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((ViewStyle) this.instance).setBackgroundColorHexBytes(byteString);
                return this;
            }

            public Builder setBitmap(ByteString byteString) {
                copyOnWrite();
                ((ViewStyle) this.instance).setBitmap(byteString);
                return this;
            }

            public Builder setBitmapHash(String str) {
                copyOnWrite();
                ((ViewStyle) this.instance).setBitmapHash(str);
                return this;
            }

            public Builder setBitmapHashBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((ViewStyle) this.instance).setBitmapHashBytes(byteString);
                return this;
            }

            public Builder setClipChildren(boolean z) {
                copyOnWrite();
                ((ViewStyle) this.instance).setClipChildren(z);
                return this;
            }

            public Builder setContentOffsetX(int i) {
                copyOnWrite();
                ((ViewStyle) this.instance).setContentOffsetX(i);
                return this;
            }

            public Builder setContentOffsetY(int i) {
                copyOnWrite();
                ((ViewStyle) this.instance).setContentOffsetY(i);
                return this;
            }

            public Builder setCornerRadius(float f) {
                copyOnWrite();
                ((ViewStyle) this.instance).setCornerRadius(f);
                return this;
            }

            public Builder setHeight(int i) {
                copyOnWrite();
                ((ViewStyle) this.instance).setHeight(i);
                return this;
            }

            public Builder setHtmlText(ViewHtmlText.Builder builder) {
                copyOnWrite();
                ((ViewStyle) this.instance).setHtmlText(builder.build());
                return this;
            }

            public Builder setInteractionEnabled(boolean z) {
                copyOnWrite();
                ((ViewStyle) this.instance).setInteractionEnabled(z);
                return this;
            }

            public Builder setIsBlur(boolean z) {
                copyOnWrite();
                ((ViewStyle) this.instance).setIsBlur(z);
                return this;
            }

            public Builder setIsVisible(boolean z) {
                copyOnWrite();
                ((ViewStyle) this.instance).setIsVisible(z);
                return this;
            }

            public Builder setKeyboardType(String str) {
                copyOnWrite();
                ((ViewStyle) this.instance).setKeyboardType(str);
                return this;
            }

            public Builder setKeyboardTypeBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((ViewStyle) this.instance).setKeyboardTypeBytes(byteString);
                return this;
            }

            public Builder setPlaceholder(Placeholder placeholder) {
                copyOnWrite();
                ((ViewStyle) this.instance).setPlaceholder(placeholder);
                return this;
            }

            public Builder setPlaceholderValue(int i) {
                copyOnWrite();
                ((ViewStyle) this.instance).setPlaceholderValue(i);
                return this;
            }

            public Builder setSerializedText(ViewHtmlText.Builder builder) {
                copyOnWrite();
                ((ViewStyle) this.instance).setSerializedText(builder.build());
                return this;
            }

            public Builder setShadow(ViewShadow.Builder builder) {
                copyOnWrite();
                ((ViewStyle) this.instance).setShadow(builder.build());
                return this;
            }

            public Builder setText(ViewText.Builder builder) {
                copyOnWrite();
                ((ViewStyle) this.instance).setText(builder.build());
                return this;
            }

            public Builder setWidth(int i) {
                copyOnWrite();
                ((ViewStyle) this.instance).setWidth(i);
                return this;
            }

            public Builder setX(int i) {
                copyOnWrite();
                ((ViewStyle) this.instance).setX(i);
                return this;
            }

            public Builder setY(int i) {
                copyOnWrite();
                ((ViewStyle) this.instance).setY(i);
                return this;
            }

            public Builder setZ(float f) {
                copyOnWrite();
                ((ViewStyle) this.instance).setZ(f);
                return this;
            }

            public Builder setHtmlText(ViewHtmlText viewHtmlText) {
                copyOnWrite();
                ((ViewStyle) this.instance).setHtmlText(viewHtmlText);
                return this;
            }

            public Builder setSerializedText(ViewHtmlText viewHtmlText) {
                copyOnWrite();
                ((ViewStyle) this.instance).setSerializedText(viewHtmlText);
                return this;
            }

            public Builder setShadow(ViewShadow viewShadow) {
                copyOnWrite();
                ((ViewStyle) this.instance).setShadow(viewShadow);
                return this;
            }

            public Builder setText(ViewText viewText) {
                copyOnWrite();
                ((ViewStyle) this.instance).setText(viewText);
                return this;
            }
        }

        public enum Placeholder implements Internal.EnumLite {
            PLACEHOLDER_UNSPECIFIED(0),
            PLACEHOLDER_IMAGE(1),
            PLACEHOLDER_KEYBOARD(2),
            PLACEHOLDER_MAP(3),
            UNRECOGNIZED(-1);

            public static final int PLACEHOLDER_IMAGE_VALUE = 1;
            public static final int PLACEHOLDER_KEYBOARD_VALUE = 2;
            public static final int PLACEHOLDER_MAP_VALUE = 3;
            public static final int PLACEHOLDER_UNSPECIFIED_VALUE = 0;
            private static final Internal.EnumLiteMap<Placeholder> internalValueMap = new Internal.EnumLiteMap<Placeholder>() { // from class: com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyle.Placeholder.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Placeholder findValueByNumber(int i) {
                    return Placeholder.forNumber(i);
                }
            };
            private final int value;

            public static final class PlaceholderVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new PlaceholderVerifier();

                private PlaceholderVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return Placeholder.forNumber(i) != null;
                }
            }

            Placeholder(int i) {
                this.value = i;
            }

            public static Placeholder forNumber(int i) {
                if (i == 0) {
                    return PLACEHOLDER_UNSPECIFIED;
                }
                if (i == 1) {
                    return PLACEHOLDER_IMAGE;
                }
                if (i == 2) {
                    return PLACEHOLDER_KEYBOARD;
                }
                if (i != 3) {
                    return null;
                }
                return PLACEHOLDER_MAP;
            }

            public static Internal.EnumLiteMap<Placeholder> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return PlaceholderVerifier.INSTANCE;
            }

            @Deprecated
            public static Placeholder valueOf(int i) {
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

        static {
            ViewStyle viewStyle = new ViewStyle();
            DEFAULT_INSTANCE = viewStyle;
            GeneratedMessageLite.registerDefaultInstance(ViewStyle.class, viewStyle);
        }

        private ViewStyle() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAlpha() {
            this.bitField0_ &= -257;
            this.alpha_ = BitmapDescriptorFactory.HUE_RED;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBackgroundColorHex() {
            this.bitField0_ &= -129;
            this.backgroundColorHex_ = getDefaultInstance().getBackgroundColorHex();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBitmap() {
            this.bitField0_ &= -4097;
            this.bitmap_ = getDefaultInstance().getBitmap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBitmapHash() {
            this.bitField0_ &= -8193;
            this.bitmapHash_ = getDefaultInstance().getBitmapHash();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClipChildren() {
            this.bitField0_ &= -2049;
            this.clipChildren_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearContentOffsetX() {
            this.bitField0_ &= -513;
            this.contentOffsetX_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearContentOffsetY() {
            this.bitField0_ &= -1025;
            this.contentOffsetY_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCornerRadius() {
            this.bitField0_ &= -17;
            this.cornerRadius_ = BitmapDescriptorFactory.HUE_RED;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHeight() {
            this.bitField0_ &= -9;
            this.height_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHtmlText() {
            this.htmlText_ = null;
            this.bitField0_ &= -65537;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInteractionEnabled() {
            this.interactionEnabled_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsBlur() {
            this.bitField0_ &= -262145;
            this.isBlur_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsVisible() {
            this.bitField0_ &= -65;
            this.isVisible_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearKeyboardType() {
            this.bitField0_ &= -131073;
            this.keyboardType_ = getDefaultInstance().getKeyboardType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPlaceholder() {
            this.bitField0_ &= -16385;
            this.placeholder_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSerializedText() {
            this.serializedText_ = null;
            this.bitField0_ &= -1048577;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearShadow() {
            this.shadow_ = null;
            this.bitField0_ &= -33;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearText() {
            this.text_ = null;
            this.bitField0_ &= -32769;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWidth() {
            this.bitField0_ &= -5;
            this.width_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearX() {
            this.bitField0_ &= -2;
            this.x_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearY() {
            this.bitField0_ &= -3;
            this.y_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearZ() {
            this.bitField0_ &= -524289;
            this.z_ = BitmapDescriptorFactory.HUE_RED;
        }

        public static ViewStyle getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeHtmlText(ViewHtmlText viewHtmlText) {
            viewHtmlText.getClass();
            ViewHtmlText viewHtmlText2 = this.htmlText_;
            if (viewHtmlText2 != null && viewHtmlText2 != ViewHtmlText.getDefaultInstance()) {
                viewHtmlText = ViewHtmlText.newBuilder(this.htmlText_).mergeFrom((ViewHtmlText.Builder) viewHtmlText).buildPartial();
            }
            this.htmlText_ = viewHtmlText;
            this.bitField0_ |= 65536;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSerializedText(ViewHtmlText viewHtmlText) {
            viewHtmlText.getClass();
            ViewHtmlText viewHtmlText2 = this.serializedText_;
            if (viewHtmlText2 != null && viewHtmlText2 != ViewHtmlText.getDefaultInstance()) {
                viewHtmlText = ViewHtmlText.newBuilder(this.serializedText_).mergeFrom((ViewHtmlText.Builder) viewHtmlText).buildPartial();
            }
            this.serializedText_ = viewHtmlText;
            this.bitField0_ |= 1048576;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeShadow(ViewShadow viewShadow) {
            viewShadow.getClass();
            ViewShadow viewShadow2 = this.shadow_;
            if (viewShadow2 != null && viewShadow2 != ViewShadow.getDefaultInstance()) {
                viewShadow = ViewShadow.newBuilder(this.shadow_).mergeFrom((ViewShadow.Builder) viewShadow).buildPartial();
            }
            this.shadow_ = viewShadow;
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeText(ViewText viewText) {
            viewText.getClass();
            ViewText viewText2 = this.text_;
            if (viewText2 != null && viewText2 != ViewText.getDefaultInstance()) {
                viewText = ViewText.newBuilder(this.text_).mergeFrom((ViewText.Builder) viewText).buildPartial();
            }
            this.text_ = viewText;
            this.bitField0_ |= 32768;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ViewStyle parseDelimitedFrom(InputStream inputStream) {
            return (ViewStyle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ViewStyle parseFrom(ByteString byteString) {
            return (ViewStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<ViewStyle> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAlpha(float f) {
            this.bitField0_ |= 256;
            this.alpha_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBackgroundColorHex(String str) {
            str.getClass();
            this.bitField0_ |= 128;
            this.backgroundColorHex_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBackgroundColorHexBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.backgroundColorHex_ = byteString.toStringUtf8();
            this.bitField0_ |= 128;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBitmap(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4096;
            this.bitmap_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBitmapHash(String str) {
            str.getClass();
            this.bitField0_ |= 8192;
            this.bitmapHash_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBitmapHashBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.bitmapHash_ = byteString.toStringUtf8();
            this.bitField0_ |= 8192;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClipChildren(boolean z) {
            this.bitField0_ |= 2048;
            this.clipChildren_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContentOffsetX(int i) {
            this.bitField0_ |= 512;
            this.contentOffsetX_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContentOffsetY(int i) {
            this.bitField0_ |= 1024;
            this.contentOffsetY_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCornerRadius(float f) {
            this.bitField0_ |= 16;
            this.cornerRadius_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHeight(int i) {
            this.bitField0_ |= 8;
            this.height_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHtmlText(ViewHtmlText viewHtmlText) {
            viewHtmlText.getClass();
            this.htmlText_ = viewHtmlText;
            this.bitField0_ |= 65536;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInteractionEnabled(boolean z) {
            this.interactionEnabled_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsBlur(boolean z) {
            this.bitField0_ |= 262144;
            this.isBlur_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsVisible(boolean z) {
            this.bitField0_ |= 64;
            this.isVisible_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeyboardType(String str) {
            str.getClass();
            this.bitField0_ |= 131072;
            this.keyboardType_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeyboardTypeBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.keyboardType_ = byteString.toStringUtf8();
            this.bitField0_ |= 131072;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlaceholder(Placeholder placeholder) {
            this.placeholder_ = placeholder.getNumber();
            this.bitField0_ |= 16384;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlaceholderValue(int i) {
            this.bitField0_ |= 16384;
            this.placeholder_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSerializedText(ViewHtmlText viewHtmlText) {
            viewHtmlText.getClass();
            this.serializedText_ = viewHtmlText;
            this.bitField0_ |= 1048576;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setShadow(ViewShadow viewShadow) {
            viewShadow.getClass();
            this.shadow_ = viewShadow;
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setText(ViewText viewText) {
            viewText.getClass();
            this.text_ = viewText;
            this.bitField0_ |= 32768;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWidth(int i) {
            this.bitField0_ |= 4;
            this.width_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setX(int i) {
            this.bitField0_ |= 1;
            this.x_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setY(int i) {
            this.bitField0_ |= 2;
            this.y_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setZ(float f) {
            this.bitField0_ |= 524288;
            this.z_ = f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ViewStyle();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0016\u0000\u0001\u0001\u0016\u0016\u0000\u0000\u0000\u0001ဏ\u0000\u0002ဏ\u0001\u0003ဋ\u0002\u0004ဋ\u0003\u0005ခ\u0004\u0006ဉ\u0005\u0007ဇ\u0006\bለ\u0007\tခ\b\nဏ\t\u000bဏ\n\fဇ\u000b\rည\f\u000eለ\r\u000fဌ\u000e\u0010ဉ\u000f\u0011ဉ\u0010\u0012ለ\u0011\u0013ဇ\u0012\u0014ခ\u0013\u0015\u0007\u0016ဉ\u0014", new Object[]{"bitField0_", "x_", "y_", "width_", "height_", "cornerRadius_", "shadow_", "isVisible_", "backgroundColorHex_", "alpha_", "contentOffsetX_", "contentOffsetY_", "clipChildren_", "bitmap_", "bitmapHash_", "placeholder_", "text_", "htmlText_", "keyboardType_", "isBlur_", "z_", "interactionEnabled_", "serializedText_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ViewStyle> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (ViewStyle.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public float getAlpha() {
            return this.alpha_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public String getBackgroundColorHex() {
            return this.backgroundColorHex_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public ByteString getBackgroundColorHexBytes() {
            return ByteString.copyFromUtf8(this.backgroundColorHex_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public ByteString getBitmap() {
            return this.bitmap_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public String getBitmapHash() {
            return this.bitmapHash_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public ByteString getBitmapHashBytes() {
            return ByteString.copyFromUtf8(this.bitmapHash_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean getClipChildren() {
            return this.clipChildren_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public int getContentOffsetX() {
            return this.contentOffsetX_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public int getContentOffsetY() {
            return this.contentOffsetY_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public float getCornerRadius() {
            return this.cornerRadius_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public int getHeight() {
            return this.height_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public ViewHtmlText getHtmlText() {
            ViewHtmlText viewHtmlText = this.htmlText_;
            return viewHtmlText == null ? ViewHtmlText.getDefaultInstance() : viewHtmlText;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean getInteractionEnabled() {
            return this.interactionEnabled_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean getIsBlur() {
            return this.isBlur_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean getIsVisible() {
            return this.isVisible_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public String getKeyboardType() {
            return this.keyboardType_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public ByteString getKeyboardTypeBytes() {
            return ByteString.copyFromUtf8(this.keyboardType_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public Placeholder getPlaceholder() {
            Placeholder placeholderForNumber = Placeholder.forNumber(this.placeholder_);
            return placeholderForNumber == null ? Placeholder.UNRECOGNIZED : placeholderForNumber;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public int getPlaceholderValue() {
            return this.placeholder_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public ViewHtmlText getSerializedText() {
            ViewHtmlText viewHtmlText = this.serializedText_;
            return viewHtmlText == null ? ViewHtmlText.getDefaultInstance() : viewHtmlText;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public ViewShadow getShadow() {
            ViewShadow viewShadow = this.shadow_;
            return viewShadow == null ? ViewShadow.getDefaultInstance() : viewShadow;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public ViewText getText() {
            ViewText viewText = this.text_;
            return viewText == null ? ViewText.getDefaultInstance() : viewText;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public int getWidth() {
            return this.width_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public int getX() {
            return this.x_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public int getY() {
            return this.y_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public float getZ() {
            return this.z_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean hasAlpha() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean hasBackgroundColorHex() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean hasBitmap() {
            return (this.bitField0_ & 4096) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean hasBitmapHash() {
            return (this.bitField0_ & 8192) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean hasClipChildren() {
            return (this.bitField0_ & 2048) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean hasContentOffsetX() {
            return (this.bitField0_ & 512) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean hasContentOffsetY() {
            return (this.bitField0_ & 1024) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean hasCornerRadius() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean hasHeight() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean hasHtmlText() {
            return (this.bitField0_ & 65536) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean hasIsBlur() {
            return (this.bitField0_ & 262144) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean hasIsVisible() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean hasKeyboardType() {
            return (this.bitField0_ & 131072) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean hasPlaceholder() {
            return (this.bitField0_ & 16384) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean hasSerializedText() {
            return (this.bitField0_ & 1048576) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean hasShadow() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean hasText() {
            return (this.bitField0_ & 32768) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean hasWidth() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean hasX() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean hasY() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewStyleOrBuilder
        public boolean hasZ() {
            return (this.bitField0_ & 524288) != 0;
        }

        public static Builder newBuilder(ViewStyle viewStyle) {
            return DEFAULT_INSTANCE.createBuilder(viewStyle);
        }

        public static ViewStyle parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewStyle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ViewStyle parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ViewStyle parseFrom(CodedInputStream codedInputStream) {
            return (ViewStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ViewStyle parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ViewStyle parseFrom(InputStream inputStream) {
            return (ViewStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ViewStyle parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ViewStyle parseFrom(ByteBuffer byteBuffer) {
            return (ViewStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ViewStyle parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ViewStyle parseFrom(byte[] bArr) {
            return (ViewStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ViewStyle parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewStyle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface ViewStyleOrBuilder extends MessageLiteOrBuilder {
        float getAlpha();

        String getBackgroundColorHex();

        ByteString getBackgroundColorHexBytes();

        ByteString getBitmap();

        String getBitmapHash();

        ByteString getBitmapHashBytes();

        boolean getClipChildren();

        int getContentOffsetX();

        int getContentOffsetY();

        float getCornerRadius();

        int getHeight();

        ViewHtmlText getHtmlText();

        boolean getInteractionEnabled();

        boolean getIsBlur();

        boolean getIsVisible();

        String getKeyboardType();

        ByteString getKeyboardTypeBytes();

        ViewStyle.Placeholder getPlaceholder();

        int getPlaceholderValue();

        ViewHtmlText getSerializedText();

        ViewShadow getShadow();

        ViewText getText();

        int getWidth();

        int getX();

        int getY();

        float getZ();

        boolean hasAlpha();

        boolean hasBackgroundColorHex();

        boolean hasBitmap();

        boolean hasBitmapHash();

        boolean hasClipChildren();

        boolean hasContentOffsetX();

        boolean hasContentOffsetY();

        boolean hasCornerRadius();

        boolean hasHeight();

        boolean hasHtmlText();

        boolean hasIsBlur();

        boolean hasIsVisible();

        boolean hasKeyboardType();

        boolean hasPlaceholder();

        boolean hasSerializedText();

        boolean hasShadow();

        boolean hasText();

        boolean hasWidth();

        boolean hasX();

        boolean hasY();

        boolean hasZ();
    }

    public static final class ViewText extends GeneratedMessageLite<ViewText, Builder> implements ViewTextOrBuilder {
        public static final int ALIGNMENT_FIELD_NUMBER = 5;
        public static final int COLOR_HEX_FIELD_NUMBER = 4;
        private static final ViewText DEFAULT_INSTANCE;
        public static final int FONT_FAMILY_FIELD_NUMBER = 1;
        public static final int FONT_FIELD_NUMBER = 2;
        public static final int NUMBER_OF_LINES_FIELD_NUMBER = 6;
        private static volatile Parser<ViewText> PARSER = null;
        public static final int SIZE_FIELD_NUMBER = 3;
        public static final int TEXT_FIELD_NUMBER = 7;
        private int alignment_;
        private int numberOfLines_;
        private float size_;
        private String fontFamily_ = "";
        private String font_ = "";
        private String colorHex_ = "";
        private String text_ = "";

        public enum Alignment implements Internal.EnumLite {
            ALIGNMENT_UNSPECIFIED(0),
            ALIGNMENT_LEFT(1),
            ALIGNMENT_CENTER(2),
            ALIGNMENT_RIGHT(3),
            ALIGNMENT_JUSTIFIED(4),
            ALIGNMENT_NATURAL(5),
            UNRECOGNIZED(-1);

            public static final int ALIGNMENT_CENTER_VALUE = 2;
            public static final int ALIGNMENT_JUSTIFIED_VALUE = 4;
            public static final int ALIGNMENT_LEFT_VALUE = 1;
            public static final int ALIGNMENT_NATURAL_VALUE = 5;
            public static final int ALIGNMENT_RIGHT_VALUE = 3;
            public static final int ALIGNMENT_UNSPECIFIED_VALUE = 0;
            private static final Internal.EnumLiteMap<Alignment> internalValueMap = new Internal.EnumLiteMap<Alignment>() { // from class: com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewText.Alignment.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Alignment findValueByNumber(int i) {
                    return Alignment.forNumber(i);
                }
            };
            private final int value;

            public static final class AlignmentVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new AlignmentVerifier();

                private AlignmentVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return Alignment.forNumber(i) != null;
                }
            }

            Alignment(int i) {
                this.value = i;
            }

            public static Alignment forNumber(int i) {
                if (i == 0) {
                    return ALIGNMENT_UNSPECIFIED;
                }
                if (i == 1) {
                    return ALIGNMENT_LEFT;
                }
                if (i == 2) {
                    return ALIGNMENT_CENTER;
                }
                if (i == 3) {
                    return ALIGNMENT_RIGHT;
                }
                if (i == 4) {
                    return ALIGNMENT_JUSTIFIED;
                }
                if (i != 5) {
                    return null;
                }
                return ALIGNMENT_NATURAL;
            }

            public static Internal.EnumLiteMap<Alignment> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return AlignmentVerifier.INSTANCE;
            }

            @Deprecated
            public static Alignment valueOf(int i) {
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

        public static final class Builder extends GeneratedMessageLite.Builder<ViewText, Builder> implements ViewTextOrBuilder {
            private Builder() {
                super(ViewText.DEFAULT_INSTANCE);
            }

            public Builder clearAlignment() {
                copyOnWrite();
                ((ViewText) this.instance).clearAlignment();
                return this;
            }

            public Builder clearColorHex() {
                copyOnWrite();
                ((ViewText) this.instance).clearColorHex();
                return this;
            }

            public Builder clearFont() {
                copyOnWrite();
                ((ViewText) this.instance).clearFont();
                return this;
            }

            public Builder clearFontFamily() {
                copyOnWrite();
                ((ViewText) this.instance).clearFontFamily();
                return this;
            }

            public Builder clearNumberOfLines() {
                copyOnWrite();
                ((ViewText) this.instance).clearNumberOfLines();
                return this;
            }

            public Builder clearSize() {
                copyOnWrite();
                ((ViewText) this.instance).clearSize();
                return this;
            }

            public Builder clearText() {
                copyOnWrite();
                ((ViewText) this.instance).clearText();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
            public Alignment getAlignment() {
                return ((ViewText) this.instance).getAlignment();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
            public int getAlignmentValue() {
                return ((ViewText) this.instance).getAlignmentValue();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
            public String getColorHex() {
                return ((ViewText) this.instance).getColorHex();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
            public ByteString getColorHexBytes() {
                return ((ViewText) this.instance).getColorHexBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
            public String getFont() {
                return ((ViewText) this.instance).getFont();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
            public ByteString getFontBytes() {
                return ((ViewText) this.instance).getFontBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
            public String getFontFamily() {
                return ((ViewText) this.instance).getFontFamily();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
            public ByteString getFontFamilyBytes() {
                return ((ViewText) this.instance).getFontFamilyBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
            public int getNumberOfLines() {
                return ((ViewText) this.instance).getNumberOfLines();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
            public float getSize() {
                return ((ViewText) this.instance).getSize();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
            public String getText() {
                return ((ViewText) this.instance).getText();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
            public ByteString getTextBytes() {
                return ((ViewText) this.instance).getTextBytes();
            }

            public Builder setAlignment(Alignment alignment) {
                copyOnWrite();
                ((ViewText) this.instance).setAlignment(alignment);
                return this;
            }

            public Builder setAlignmentValue(int i) {
                copyOnWrite();
                ((ViewText) this.instance).setAlignmentValue(i);
                return this;
            }

            public Builder setColorHex(String str) {
                copyOnWrite();
                ((ViewText) this.instance).setColorHex(str);
                return this;
            }

            public Builder setColorHexBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((ViewText) this.instance).setColorHexBytes(byteString);
                return this;
            }

            public Builder setFont(String str) {
                copyOnWrite();
                ((ViewText) this.instance).setFont(str);
                return this;
            }

            public Builder setFontBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((ViewText) this.instance).setFontBytes(byteString);
                return this;
            }

            public Builder setFontFamily(String str) {
                copyOnWrite();
                ((ViewText) this.instance).setFontFamily(str);
                return this;
            }

            public Builder setFontFamilyBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((ViewText) this.instance).setFontFamilyBytes(byteString);
                return this;
            }

            public Builder setNumberOfLines(int i) {
                copyOnWrite();
                ((ViewText) this.instance).setNumberOfLines(i);
                return this;
            }

            public Builder setSize(float f) {
                copyOnWrite();
                ((ViewText) this.instance).setSize(f);
                return this;
            }

            public Builder setText(String str) {
                copyOnWrite();
                ((ViewText) this.instance).setText(str);
                return this;
            }

            public Builder setTextBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((ViewText) this.instance).setTextBytes(byteString);
                return this;
            }
        }

        static {
            ViewText viewText = new ViewText();
            DEFAULT_INSTANCE = viewText;
            GeneratedMessageLite.registerDefaultInstance(ViewText.class, viewText);
        }

        private ViewText() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAlignment() {
            this.alignment_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearColorHex() {
            this.colorHex_ = getDefaultInstance().getColorHex();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFont() {
            this.font_ = getDefaultInstance().getFont();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFontFamily() {
            this.fontFamily_ = getDefaultInstance().getFontFamily();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNumberOfLines() {
            this.numberOfLines_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSize() {
            this.size_ = BitmapDescriptorFactory.HUE_RED;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearText() {
            this.text_ = getDefaultInstance().getText();
        }

        public static ViewText getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ViewText parseDelimitedFrom(InputStream inputStream) {
            return (ViewText) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ViewText parseFrom(ByteString byteString) {
            return (ViewText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<ViewText> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAlignment(Alignment alignment) {
            this.alignment_ = alignment.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAlignmentValue(int i) {
            this.alignment_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setColorHex(String str) {
            str.getClass();
            this.colorHex_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setColorHexBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.colorHex_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFont(String str) {
            str.getClass();
            this.font_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFontBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.font_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFontFamily(String str) {
            str.getClass();
            this.fontFamily_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFontFamilyBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.fontFamily_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNumberOfLines(int i) {
            this.numberOfLines_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSize(float f) {
            this.size_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setText(String str) {
            str.getClass();
            this.text_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTextBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.text_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new ViewText();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0001\u0004Ȉ\u0005\f\u0006\u000b\u0007Ȉ", new Object[]{"fontFamily_", "font_", "size_", "colorHex_", "alignment_", "numberOfLines_", "text_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ViewText> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (ViewText.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
        public Alignment getAlignment() {
            Alignment alignmentForNumber = Alignment.forNumber(this.alignment_);
            return alignmentForNumber == null ? Alignment.UNRECOGNIZED : alignmentForNumber;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
        public int getAlignmentValue() {
            return this.alignment_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
        public String getColorHex() {
            return this.colorHex_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
        public ByteString getColorHexBytes() {
            return ByteString.copyFromUtf8(this.colorHex_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
        public String getFont() {
            return this.font_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
        public ByteString getFontBytes() {
            return ByteString.copyFromUtf8(this.font_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
        public String getFontFamily() {
            return this.fontFamily_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
        public ByteString getFontFamilyBytes() {
            return ByteString.copyFromUtf8(this.fontFamily_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
        public int getNumberOfLines() {
            return this.numberOfLines_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
        public float getSize() {
            return this.size_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
        public String getText() {
            return this.text_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.ViewTextOrBuilder
        public ByteString getTextBytes() {
            return ByteString.copyFromUtf8(this.text_);
        }

        public static Builder newBuilder(ViewText viewText) {
            return DEFAULT_INSTANCE.createBuilder(viewText);
        }

        public static ViewText parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewText) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ViewText parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ViewText parseFrom(CodedInputStream codedInputStream) {
            return (ViewText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ViewText parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ViewText parseFrom(InputStream inputStream) {
            return (ViewText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ViewText parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ViewText parseFrom(ByteBuffer byteBuffer) {
            return (ViewText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ViewText parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ViewText parseFrom(byte[] bArr) {
            return (ViewText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ViewText parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ViewText) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface ViewTextOrBuilder extends MessageLiteOrBuilder {
        ViewText.Alignment getAlignment();

        int getAlignmentValue();

        String getColorHex();

        ByteString getColorHexBytes();

        String getFont();

        ByteString getFontBytes();

        String getFontFamily();

        ByteString getFontFamilyBytes();

        int getNumberOfLines();

        float getSize();

        String getText();

        ByteString getTextBytes();
    }

    public static final class WebviewEvent extends GeneratedMessageLite<WebviewEvent, Builder> implements WebviewEventOrBuilder {
        private static final WebviewEvent DEFAULT_INSTANCE;
        public static final int EVENT_FIELD_NUMBER = 2;
        private static volatile Parser<WebviewEvent> PARSER = null;
        public static final int WEBVIEW_ID_FIELD_NUMBER = 1;
        private String event_ = "";
        private long webviewId_;

        public static final class Builder extends GeneratedMessageLite.Builder<WebviewEvent, Builder> implements WebviewEventOrBuilder {
            private Builder() {
                super(WebviewEvent.DEFAULT_INSTANCE);
            }

            public Builder clearEvent() {
                copyOnWrite();
                ((WebviewEvent) this.instance).clearEvent();
                return this;
            }

            public Builder clearWebviewId() {
                copyOnWrite();
                ((WebviewEvent) this.instance).clearWebviewId();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.WebviewEventOrBuilder
            public String getEvent() {
                return ((WebviewEvent) this.instance).getEvent();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.WebviewEventOrBuilder
            public ByteString getEventBytes() {
                return ((WebviewEvent) this.instance).getEventBytes();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.WebviewEventOrBuilder
            public long getWebviewId() {
                return ((WebviewEvent) this.instance).getWebviewId();
            }

            public Builder setEvent(String str) {
                copyOnWrite();
                ((WebviewEvent) this.instance).setEvent(str);
                return this;
            }

            public Builder setEventBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((WebviewEvent) this.instance).setEventBytes(byteString);
                return this;
            }

            public Builder setWebviewId(long j) {
                copyOnWrite();
                ((WebviewEvent) this.instance).setWebviewId(j);
                return this;
            }
        }

        static {
            WebviewEvent webviewEvent = new WebviewEvent();
            DEFAULT_INSTANCE = webviewEvent;
            GeneratedMessageLite.registerDefaultInstance(WebviewEvent.class, webviewEvent);
        }

        private WebviewEvent() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEvent() {
            this.event_ = getDefaultInstance().getEvent();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWebviewId() {
            this.webviewId_ = 0L;
        }

        public static WebviewEvent getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static WebviewEvent parseDelimitedFrom(InputStream inputStream) {
            return (WebviewEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WebviewEvent parseFrom(ByteString byteString) {
            return (WebviewEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<WebviewEvent> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEvent(String str) {
            str.getClass();
            this.event_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.event_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWebviewId(long j) {
            this.webviewId_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new WebviewEvent();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0010\u0002Ȉ", new Object[]{"webviewId_", "event_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<WebviewEvent> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (WebviewEvent.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.WebviewEventOrBuilder
        public String getEvent() {
            return this.event_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.WebviewEventOrBuilder
        public ByteString getEventBytes() {
            return ByteString.copyFromUtf8(this.event_);
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.WebviewEventOrBuilder
        public long getWebviewId() {
            return this.webviewId_;
        }

        public static Builder newBuilder(WebviewEvent webviewEvent) {
            return DEFAULT_INSTANCE.createBuilder(webviewEvent);
        }

        public static WebviewEvent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (WebviewEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WebviewEvent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (WebviewEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WebviewEvent parseFrom(CodedInputStream codedInputStream) {
            return (WebviewEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WebviewEvent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (WebviewEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static WebviewEvent parseFrom(InputStream inputStream) {
            return (WebviewEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WebviewEvent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (WebviewEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WebviewEvent parseFrom(ByteBuffer byteBuffer) {
            return (WebviewEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static WebviewEvent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (WebviewEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static WebviewEvent parseFrom(byte[] bArr) {
            return (WebviewEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WebviewEvent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (WebviewEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface WebviewEventOrBuilder extends MessageLiteOrBuilder {
        String getEvent();

        ByteString getEventBytes();

        long getWebviewId();
    }

    public static final class WindowResize extends GeneratedMessageLite<WindowResize, Builder> implements WindowResizeOrBuilder {
        private static final WindowResize DEFAULT_INSTANCE;
        public static final int HEIGHT_FIELD_NUMBER = 3;
        private static volatile Parser<WindowResize> PARSER = null;
        public static final int UNIX_TIMESTAMP_MS_FIELD_NUMBER = 1;
        public static final int WIDTH_FIELD_NUMBER = 2;
        private int height_;
        private long unixTimestampMs_;
        private int width_;

        public static final class Builder extends GeneratedMessageLite.Builder<WindowResize, Builder> implements WindowResizeOrBuilder {
            private Builder() {
                super(WindowResize.DEFAULT_INSTANCE);
            }

            public Builder clearHeight() {
                copyOnWrite();
                ((WindowResize) this.instance).clearHeight();
                return this;
            }

            public Builder clearUnixTimestampMs() {
                copyOnWrite();
                ((WindowResize) this.instance).clearUnixTimestampMs();
                return this;
            }

            public Builder clearWidth() {
                copyOnWrite();
                ((WindowResize) this.instance).clearWidth();
                return this;
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.WindowResizeOrBuilder
            public int getHeight() {
                return ((WindowResize) this.instance).getHeight();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.WindowResizeOrBuilder
            public long getUnixTimestampMs() {
                return ((WindowResize) this.instance).getUnixTimestampMs();
            }

            @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.WindowResizeOrBuilder
            public int getWidth() {
                return ((WindowResize) this.instance).getWidth();
            }

            public Builder setHeight(int i) {
                copyOnWrite();
                ((WindowResize) this.instance).setHeight(i);
                return this;
            }

            public Builder setUnixTimestampMs(long j) {
                copyOnWrite();
                ((WindowResize) this.instance).setUnixTimestampMs(j);
                return this;
            }

            public Builder setWidth(int i) {
                copyOnWrite();
                ((WindowResize) this.instance).setWidth(i);
                return this;
            }
        }

        static {
            WindowResize windowResize = new WindowResize();
            DEFAULT_INSTANCE = windowResize;
            GeneratedMessageLite.registerDefaultInstance(WindowResize.class, windowResize);
        }

        private WindowResize() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHeight() {
            this.height_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnixTimestampMs() {
            this.unixTimestampMs_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWidth() {
            this.width_ = 0;
        }

        public static WindowResize getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static WindowResize parseDelimitedFrom(InputStream inputStream) {
            return (WindowResize) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WindowResize parseFrom(ByteString byteString) {
            return (WindowResize) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<WindowResize> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHeight(int i) {
            this.height_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnixTimestampMs(long j) {
            this.unixTimestampMs_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWidth(int i) {
            this.width_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new WindowResize();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0003\u0002\u000b\u0003\u000b", new Object[]{"unixTimestampMs_", "width_", "height_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<WindowResize> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (WindowResize.class) {
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

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.WindowResizeOrBuilder
        public int getHeight() {
            return this.height_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.WindowResizeOrBuilder
        public long getUnixTimestampMs() {
            return this.unixTimestampMs_;
        }

        @Override // com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1.WindowResizeOrBuilder
        public int getWidth() {
            return this.width_;
        }

        public static Builder newBuilder(WindowResize windowResize) {
            return DEFAULT_INSTANCE.createBuilder(windowResize);
        }

        public static WindowResize parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (WindowResize) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WindowResize parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (WindowResize) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WindowResize parseFrom(CodedInputStream codedInputStream) {
            return (WindowResize) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WindowResize parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (WindowResize) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static WindowResize parseFrom(InputStream inputStream) {
            return (WindowResize) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WindowResize parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (WindowResize) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WindowResize parseFrom(ByteBuffer byteBuffer) {
            return (WindowResize) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static WindowResize parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (WindowResize) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static WindowResize parseFrom(byte[] bArr) {
            return (WindowResize) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WindowResize parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (WindowResize) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface WindowResizeOrBuilder extends MessageLiteOrBuilder {
        int getHeight();

        long getUnixTimestampMs();

        int getWidth();
    }

    private SessionRecordingV1() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
