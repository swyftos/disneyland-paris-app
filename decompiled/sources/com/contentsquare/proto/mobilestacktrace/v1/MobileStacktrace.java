package com.contentsquare.proto.mobilestacktrace.v1;

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
public final class MobileStacktrace {

    /* renamed from: com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace$1, reason: invalid class name */
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

    public static final class AndroidThreadReport extends GeneratedMessageLite<AndroidThreadReport, Builder> implements AndroidThreadReportOrBuilder {
        public static final int APPLICATION_VERSION_FIELD_NUMBER = 2;
        private static final AndroidThreadReport DEFAULT_INSTANCE;
        public static final int ERROR_STACKTRACE_FIELD_NUMBER = 4;
        public static final int MAPPING_VERSION_FIELD_NUMBER = 3;
        public static final int PACKAGE_NAME_FIELD_NUMBER = 1;
        private static volatile Parser<AndroidThreadReport> PARSER = null;
        public static final int THREADS_FIELD_NUMBER = 5;
        private int bitField0_;
        private ErrorStacktrace errorStacktrace_;
        private String packageName_ = "";
        private String applicationVersion_ = "";
        private String mappingVersion_ = "";
        private Internal.ProtobufList<Thread> threads_ = GeneratedMessageLite.emptyProtobufList();

        public static final class Builder extends GeneratedMessageLite.Builder<AndroidThreadReport, Builder> implements AndroidThreadReportOrBuilder {
            private Builder() {
                super(AndroidThreadReport.DEFAULT_INSTANCE);
            }

            public Builder addAllThreads(Iterable<? extends Thread> iterable) {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).addAllThreads(iterable);
                return this;
            }

            public Builder addThreads(int i, Thread.Builder builder) {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).addThreads(i, builder.build());
                return this;
            }

            public Builder clearApplicationVersion() {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).clearApplicationVersion();
                return this;
            }

            public Builder clearErrorStacktrace() {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).clearErrorStacktrace();
                return this;
            }

            public Builder clearMappingVersion() {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).clearMappingVersion();
                return this;
            }

            public Builder clearPackageName() {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).clearPackageName();
                return this;
            }

            public Builder clearThreads() {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).clearThreads();
                return this;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
            public String getApplicationVersion() {
                return ((AndroidThreadReport) this.instance).getApplicationVersion();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
            public ByteString getApplicationVersionBytes() {
                return ((AndroidThreadReport) this.instance).getApplicationVersionBytes();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
            public ErrorStacktrace getErrorStacktrace() {
                return ((AndroidThreadReport) this.instance).getErrorStacktrace();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
            public String getMappingVersion() {
                return ((AndroidThreadReport) this.instance).getMappingVersion();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
            public ByteString getMappingVersionBytes() {
                return ((AndroidThreadReport) this.instance).getMappingVersionBytes();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
            public String getPackageName() {
                return ((AndroidThreadReport) this.instance).getPackageName();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
            public ByteString getPackageNameBytes() {
                return ((AndroidThreadReport) this.instance).getPackageNameBytes();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
            public Thread getThreads(int i) {
                return ((AndroidThreadReport) this.instance).getThreads(i);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
            public int getThreadsCount() {
                return ((AndroidThreadReport) this.instance).getThreadsCount();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
            public List<Thread> getThreadsList() {
                return Collections.unmodifiableList(((AndroidThreadReport) this.instance).getThreadsList());
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
            public boolean hasErrorStacktrace() {
                return ((AndroidThreadReport) this.instance).hasErrorStacktrace();
            }

            public Builder mergeErrorStacktrace(ErrorStacktrace errorStacktrace) {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).mergeErrorStacktrace(errorStacktrace);
                return this;
            }

            public Builder removeThreads(int i) {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).removeThreads(i);
                return this;
            }

            public Builder setApplicationVersion(String str) {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).setApplicationVersion(str);
                return this;
            }

            public Builder setApplicationVersionBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).setApplicationVersionBytes(byteString);
                return this;
            }

            public Builder setErrorStacktrace(ErrorStacktrace.Builder builder) {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).setErrorStacktrace(builder.build());
                return this;
            }

            public Builder setMappingVersion(String str) {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).setMappingVersion(str);
                return this;
            }

            public Builder setMappingVersionBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).setMappingVersionBytes(byteString);
                return this;
            }

            public Builder setPackageName(String str) {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).setPackageName(str);
                return this;
            }

            public Builder setPackageNameBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).setPackageNameBytes(byteString);
                return this;
            }

            public Builder setThreads(int i, Thread.Builder builder) {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).setThreads(i, builder.build());
                return this;
            }

            public Builder addThreads(int i, Thread thread) {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).addThreads(i, thread);
                return this;
            }

            public Builder setErrorStacktrace(ErrorStacktrace errorStacktrace) {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).setErrorStacktrace(errorStacktrace);
                return this;
            }

            public Builder setThreads(int i, Thread thread) {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).setThreads(i, thread);
                return this;
            }

            public Builder addThreads(Thread.Builder builder) {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).addThreads(builder.build());
                return this;
            }

            public Builder addThreads(Thread thread) {
                copyOnWrite();
                ((AndroidThreadReport) this.instance).addThreads(thread);
                return this;
            }
        }

        public static final class ErrorStacktrace extends GeneratedMessageLite<ErrorStacktrace, Builder> implements ErrorStacktraceOrBuilder {
            public static final int CAUSE_FIELD_NUMBER = 4;
            private static final ErrorStacktrace DEFAULT_INSTANCE;
            public static final int EXCEPTION_FIELD_NUMBER = 3;
            public static final int FRAMES_FIELD_NUMBER = 5;
            public static final int OVERFLOW_COUNT_FIELD_NUMBER = 2;
            private static volatile Parser<ErrorStacktrace> PARSER = null;
            public static final int THREAD_ID_FIELD_NUMBER = 1;
            private int bitField0_;
            private ErrorStacktrace cause_;
            private Throwable exception_;
            private Internal.ProtobufList<Frame> frames_ = GeneratedMessageLite.emptyProtobufList();
            private int overflowCount_;
            private int threadId_;

            public static final class Builder extends GeneratedMessageLite.Builder<ErrorStacktrace, Builder> implements ErrorStacktraceOrBuilder {
                private Builder() {
                    super(ErrorStacktrace.DEFAULT_INSTANCE);
                }

                public Builder addAllFrames(Iterable<? extends Frame> iterable) {
                    copyOnWrite();
                    ((ErrorStacktrace) this.instance).addAllFrames(iterable);
                    return this;
                }

                public Builder addFrames(int i, Frame.Builder builder) {
                    copyOnWrite();
                    ((ErrorStacktrace) this.instance).addFrames(i, builder.build());
                    return this;
                }

                public Builder clearCause() {
                    copyOnWrite();
                    ((ErrorStacktrace) this.instance).clearCause();
                    return this;
                }

                public Builder clearException() {
                    copyOnWrite();
                    ((ErrorStacktrace) this.instance).clearException();
                    return this;
                }

                public Builder clearFrames() {
                    copyOnWrite();
                    ((ErrorStacktrace) this.instance).clearFrames();
                    return this;
                }

                public Builder clearOverflowCount() {
                    copyOnWrite();
                    ((ErrorStacktrace) this.instance).clearOverflowCount();
                    return this;
                }

                public Builder clearThreadId() {
                    copyOnWrite();
                    ((ErrorStacktrace) this.instance).clearThreadId();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktraceOrBuilder
                public ErrorStacktrace getCause() {
                    return ((ErrorStacktrace) this.instance).getCause();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktraceOrBuilder
                public Throwable getException() {
                    return ((ErrorStacktrace) this.instance).getException();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktraceOrBuilder
                public Frame getFrames(int i) {
                    return ((ErrorStacktrace) this.instance).getFrames(i);
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktraceOrBuilder
                public int getFramesCount() {
                    return ((ErrorStacktrace) this.instance).getFramesCount();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktraceOrBuilder
                public List<Frame> getFramesList() {
                    return Collections.unmodifiableList(((ErrorStacktrace) this.instance).getFramesList());
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktraceOrBuilder
                public int getOverflowCount() {
                    return ((ErrorStacktrace) this.instance).getOverflowCount();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktraceOrBuilder
                public int getThreadId() {
                    return ((ErrorStacktrace) this.instance).getThreadId();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktraceOrBuilder
                public boolean hasCause() {
                    return ((ErrorStacktrace) this.instance).hasCause();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktraceOrBuilder
                public boolean hasException() {
                    return ((ErrorStacktrace) this.instance).hasException();
                }

                public Builder mergeCause(ErrorStacktrace errorStacktrace) {
                    copyOnWrite();
                    ((ErrorStacktrace) this.instance).mergeCause(errorStacktrace);
                    return this;
                }

                public Builder mergeException(Throwable throwable) {
                    copyOnWrite();
                    ((ErrorStacktrace) this.instance).mergeException(throwable);
                    return this;
                }

                public Builder removeFrames(int i) {
                    copyOnWrite();
                    ((ErrorStacktrace) this.instance).removeFrames(i);
                    return this;
                }

                public Builder setCause(Builder builder) {
                    copyOnWrite();
                    ((ErrorStacktrace) this.instance).setCause(builder.build());
                    return this;
                }

                public Builder setException(Throwable.Builder builder) {
                    copyOnWrite();
                    ((ErrorStacktrace) this.instance).setException(builder.build());
                    return this;
                }

                public Builder setFrames(int i, Frame.Builder builder) {
                    copyOnWrite();
                    ((ErrorStacktrace) this.instance).setFrames(i, builder.build());
                    return this;
                }

                public Builder setOverflowCount(int i) {
                    copyOnWrite();
                    ((ErrorStacktrace) this.instance).setOverflowCount(i);
                    return this;
                }

                public Builder setThreadId(int i) {
                    copyOnWrite();
                    ((ErrorStacktrace) this.instance).setThreadId(i);
                    return this;
                }

                public Builder addFrames(int i, Frame frame) {
                    copyOnWrite();
                    ((ErrorStacktrace) this.instance).addFrames(i, frame);
                    return this;
                }

                public Builder setCause(ErrorStacktrace errorStacktrace) {
                    copyOnWrite();
                    ((ErrorStacktrace) this.instance).setCause(errorStacktrace);
                    return this;
                }

                public Builder setException(Throwable throwable) {
                    copyOnWrite();
                    ((ErrorStacktrace) this.instance).setException(throwable);
                    return this;
                }

                public Builder setFrames(int i, Frame frame) {
                    copyOnWrite();
                    ((ErrorStacktrace) this.instance).setFrames(i, frame);
                    return this;
                }

                public Builder addFrames(Frame.Builder builder) {
                    copyOnWrite();
                    ((ErrorStacktrace) this.instance).addFrames(builder.build());
                    return this;
                }

                public Builder addFrames(Frame frame) {
                    copyOnWrite();
                    ((ErrorStacktrace) this.instance).addFrames(frame);
                    return this;
                }
            }

            public static final class Throwable extends GeneratedMessageLite<Throwable, Builder> implements ThrowableOrBuilder {
                public static final int CLASS_FIELD_NUMBER = 2;
                private static final Throwable DEFAULT_INSTANCE;
                public static final int MESSAGE_FIELD_NUMBER = 1;
                private static volatile Parser<Throwable> PARSER;
                private String message_ = "";
                private String class__ = "";

                public static final class Builder extends GeneratedMessageLite.Builder<Throwable, Builder> implements ThrowableOrBuilder {
                    private Builder() {
                        super(Throwable.DEFAULT_INSTANCE);
                    }

                    public Builder clearClass_() {
                        copyOnWrite();
                        ((Throwable) this.instance).clearClass_();
                        return this;
                    }

                    public Builder clearMessage() {
                        copyOnWrite();
                        ((Throwable) this.instance).clearMessage();
                        return this;
                    }

                    @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktrace.ThrowableOrBuilder
                    public String getClass_() {
                        return ((Throwable) this.instance).getClass_();
                    }

                    @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktrace.ThrowableOrBuilder
                    public ByteString getClass_Bytes() {
                        return ((Throwable) this.instance).getClass_Bytes();
                    }

                    @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktrace.ThrowableOrBuilder
                    public String getMessage() {
                        return ((Throwable) this.instance).getMessage();
                    }

                    @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktrace.ThrowableOrBuilder
                    public ByteString getMessageBytes() {
                        return ((Throwable) this.instance).getMessageBytes();
                    }

                    public Builder setClass_(String str) {
                        copyOnWrite();
                        ((Throwable) this.instance).setClass_(str);
                        return this;
                    }

                    public Builder setClass_Bytes(ByteString byteString) throws IllegalArgumentException {
                        copyOnWrite();
                        ((Throwable) this.instance).setClass_Bytes(byteString);
                        return this;
                    }

                    public Builder setMessage(String str) {
                        copyOnWrite();
                        ((Throwable) this.instance).setMessage(str);
                        return this;
                    }

                    public Builder setMessageBytes(ByteString byteString) throws IllegalArgumentException {
                        copyOnWrite();
                        ((Throwable) this.instance).setMessageBytes(byteString);
                        return this;
                    }
                }

                static {
                    Throwable throwable = new Throwable();
                    DEFAULT_INSTANCE = throwable;
                    GeneratedMessageLite.registerDefaultInstance(Throwable.class, throwable);
                }

                private Throwable() {
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearClass_() {
                    this.class__ = getDefaultInstance().getClass_();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearMessage() {
                    this.message_ = getDefaultInstance().getMessage();
                }

                public static Throwable getDefaultInstance() {
                    return DEFAULT_INSTANCE;
                }

                public static Builder newBuilder() {
                    return DEFAULT_INSTANCE.createBuilder();
                }

                public static Throwable parseDelimitedFrom(InputStream inputStream) {
                    return (Throwable) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static Throwable parseFrom(ByteString byteString) {
                    return (Throwable) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                }

                public static Parser<Throwable> parser() {
                    return DEFAULT_INSTANCE.getParserForType();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setClass_(String str) {
                    str.getClass();
                    this.class__ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setClass_Bytes(ByteString byteString) throws IllegalArgumentException {
                    AbstractMessageLite.checkByteStringIsUtf8(byteString);
                    this.class__ = byteString.toStringUtf8();
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

                @Override // com.google.protobuf.GeneratedMessageLite
                public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                    int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                    switch (i) {
                        case 1:
                            return new Throwable();
                        case 2:
                            return new Builder();
                        case 3:
                            return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"message_", "class__"});
                        case 4:
                            return DEFAULT_INSTANCE;
                        case 5:
                            Parser<Throwable> defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                synchronized (Throwable.class) {
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

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktrace.ThrowableOrBuilder
                public String getClass_() {
                    return this.class__;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktrace.ThrowableOrBuilder
                public ByteString getClass_Bytes() {
                    return ByteString.copyFromUtf8(this.class__);
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktrace.ThrowableOrBuilder
                public String getMessage() {
                    return this.message_;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktrace.ThrowableOrBuilder
                public ByteString getMessageBytes() {
                    return ByteString.copyFromUtf8(this.message_);
                }

                public static Builder newBuilder(Throwable throwable) {
                    return DEFAULT_INSTANCE.createBuilder(throwable);
                }

                public static Throwable parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return (Throwable) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static Throwable parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                    return (Throwable) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                }

                public static Throwable parseFrom(CodedInputStream codedInputStream) {
                    return (Throwable) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                }

                public static Throwable parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return (Throwable) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                }

                public static Throwable parseFrom(InputStream inputStream) {
                    return (Throwable) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static Throwable parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return (Throwable) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static Throwable parseFrom(ByteBuffer byteBuffer) {
                    return (Throwable) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                }

                public static Throwable parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                    return (Throwable) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                }

                public static Throwable parseFrom(byte[] bArr) {
                    return (Throwable) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                }

                public static Throwable parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                    return (Throwable) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                }
            }

            public interface ThrowableOrBuilder extends MessageLiteOrBuilder {
                String getClass_();

                ByteString getClass_Bytes();

                String getMessage();

                ByteString getMessageBytes();
            }

            static {
                ErrorStacktrace errorStacktrace = new ErrorStacktrace();
                DEFAULT_INSTANCE = errorStacktrace;
                GeneratedMessageLite.registerDefaultInstance(ErrorStacktrace.class, errorStacktrace);
            }

            private ErrorStacktrace() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllFrames(Iterable<? extends Frame> iterable) {
                ensureFramesIsMutable();
                AbstractMessageLite.addAll(iterable, this.frames_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addFrames(int i, Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.add(i, frame);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCause() {
                this.cause_ = null;
                this.bitField0_ &= -3;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearException() {
                this.exception_ = null;
                this.bitField0_ &= -2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFrames() {
                this.frames_ = GeneratedMessageLite.emptyProtobufList();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearOverflowCount() {
                this.overflowCount_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearThreadId() {
                this.threadId_ = 0;
            }

            private void ensureFramesIsMutable() {
                Internal.ProtobufList<Frame> protobufList = this.frames_;
                if (protobufList.isModifiable()) {
                    return;
                }
                this.frames_ = GeneratedMessageLite.mutableCopy(protobufList);
            }

            public static ErrorStacktrace getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeCause(ErrorStacktrace errorStacktrace) {
                errorStacktrace.getClass();
                ErrorStacktrace errorStacktrace2 = this.cause_;
                if (errorStacktrace2 != null && errorStacktrace2 != getDefaultInstance()) {
                    errorStacktrace = newBuilder(this.cause_).mergeFrom((Builder) errorStacktrace).buildPartial();
                }
                this.cause_ = errorStacktrace;
                this.bitField0_ |= 2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeException(Throwable throwable) {
                throwable.getClass();
                Throwable throwable2 = this.exception_;
                if (throwable2 != null && throwable2 != Throwable.getDefaultInstance()) {
                    throwable = Throwable.newBuilder(this.exception_).mergeFrom((Throwable.Builder) throwable).buildPartial();
                }
                this.exception_ = throwable;
                this.bitField0_ |= 1;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static ErrorStacktrace parseDelimitedFrom(InputStream inputStream) {
                return (ErrorStacktrace) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ErrorStacktrace parseFrom(ByteString byteString) {
                return (ErrorStacktrace) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<ErrorStacktrace> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void removeFrames(int i) {
                ensureFramesIsMutable();
                this.frames_.remove(i);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCause(ErrorStacktrace errorStacktrace) {
                errorStacktrace.getClass();
                this.cause_ = errorStacktrace;
                this.bitField0_ |= 2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setException(Throwable throwable) {
                throwable.getClass();
                this.exception_ = throwable;
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFrames(int i, Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.set(i, frame);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOverflowCount(int i) {
                this.overflowCount_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setThreadId(int i) {
                this.threadId_ = i;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new ErrorStacktrace();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u000b\u0002\u000b\u0003ဉ\u0000\u0004ဉ\u0001\u0005\u001b", new Object[]{"bitField0_", "threadId_", "overflowCount_", "exception_", "cause_", "frames_", Frame.class});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ErrorStacktrace> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (ErrorStacktrace.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktraceOrBuilder
            public ErrorStacktrace getCause() {
                ErrorStacktrace errorStacktrace = this.cause_;
                return errorStacktrace == null ? getDefaultInstance() : errorStacktrace;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktraceOrBuilder
            public Throwable getException() {
                Throwable throwable = this.exception_;
                return throwable == null ? Throwable.getDefaultInstance() : throwable;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktraceOrBuilder
            public Frame getFrames(int i) {
                return this.frames_.get(i);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktraceOrBuilder
            public int getFramesCount() {
                return this.frames_.size();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktraceOrBuilder
            public List<Frame> getFramesList() {
                return this.frames_;
            }

            public FrameOrBuilder getFramesOrBuilder(int i) {
                return this.frames_.get(i);
            }

            public List<? extends FrameOrBuilder> getFramesOrBuilderList() {
                return this.frames_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktraceOrBuilder
            public int getOverflowCount() {
                return this.overflowCount_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktraceOrBuilder
            public int getThreadId() {
                return this.threadId_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktraceOrBuilder
            public boolean hasCause() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ErrorStacktraceOrBuilder
            public boolean hasException() {
                return (this.bitField0_ & 1) != 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addFrames(Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.add(frame);
            }

            public static Builder newBuilder(ErrorStacktrace errorStacktrace) {
                return DEFAULT_INSTANCE.createBuilder(errorStacktrace);
            }

            public static ErrorStacktrace parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (ErrorStacktrace) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ErrorStacktrace parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (ErrorStacktrace) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ErrorStacktrace parseFrom(CodedInputStream codedInputStream) {
                return (ErrorStacktrace) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ErrorStacktrace parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (ErrorStacktrace) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static ErrorStacktrace parseFrom(InputStream inputStream) {
                return (ErrorStacktrace) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ErrorStacktrace parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (ErrorStacktrace) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ErrorStacktrace parseFrom(ByteBuffer byteBuffer) {
                return (ErrorStacktrace) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static ErrorStacktrace parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (ErrorStacktrace) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static ErrorStacktrace parseFrom(byte[] bArr) {
                return (ErrorStacktrace) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static ErrorStacktrace parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (ErrorStacktrace) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface ErrorStacktraceOrBuilder extends MessageLiteOrBuilder {
            ErrorStacktrace getCause();

            ErrorStacktrace.Throwable getException();

            Frame getFrames(int i);

            int getFramesCount();

            List<Frame> getFramesList();

            int getOverflowCount();

            int getThreadId();

            boolean hasCause();

            boolean hasException();
        }

        public static final class Frame extends GeneratedMessageLite<Frame, Builder> implements FrameOrBuilder {
            private static final Frame DEFAULT_INSTANCE;
            public static final int JAVA_FRAME_FIELD_NUMBER = 1;
            private static volatile Parser<Frame> PARSER;
            private int frameCase_ = 0;
            private Object frame_;

            public static final class Builder extends GeneratedMessageLite.Builder<Frame, Builder> implements FrameOrBuilder {
                private Builder() {
                    super(Frame.DEFAULT_INSTANCE);
                }

                public Builder clearFrame() {
                    copyOnWrite();
                    ((Frame) this.instance).clearFrame();
                    return this;
                }

                public Builder clearJavaFrame() {
                    copyOnWrite();
                    ((Frame) this.instance).clearJavaFrame();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.FrameOrBuilder
                public FrameCase getFrameCase() {
                    return ((Frame) this.instance).getFrameCase();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.FrameOrBuilder
                public JavaFrame getJavaFrame() {
                    return ((Frame) this.instance).getJavaFrame();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.FrameOrBuilder
                public boolean hasJavaFrame() {
                    return ((Frame) this.instance).hasJavaFrame();
                }

                public Builder mergeJavaFrame(JavaFrame javaFrame) {
                    copyOnWrite();
                    ((Frame) this.instance).mergeJavaFrame(javaFrame);
                    return this;
                }

                public Builder setJavaFrame(JavaFrame.Builder builder) {
                    copyOnWrite();
                    ((Frame) this.instance).setJavaFrame(builder.build());
                    return this;
                }

                public Builder setJavaFrame(JavaFrame javaFrame) {
                    copyOnWrite();
                    ((Frame) this.instance).setJavaFrame(javaFrame);
                    return this;
                }
            }

            public enum FrameCase {
                JAVA_FRAME(1),
                FRAME_NOT_SET(0);

                private final int value;

                FrameCase(int i) {
                    this.value = i;
                }

                public static FrameCase forNumber(int i) {
                    if (i == 0) {
                        return FRAME_NOT_SET;
                    }
                    if (i != 1) {
                        return null;
                    }
                    return JAVA_FRAME;
                }

                @Deprecated
                public static FrameCase valueOf(int i) {
                    return forNumber(i);
                }

                public int getNumber() {
                    return this.value;
                }
            }

            static {
                Frame frame = new Frame();
                DEFAULT_INSTANCE = frame;
                GeneratedMessageLite.registerDefaultInstance(Frame.class, frame);
            }

            private Frame() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFrame() {
                this.frameCase_ = 0;
                this.frame_ = null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearJavaFrame() {
                if (this.frameCase_ == 1) {
                    this.frameCase_ = 0;
                    this.frame_ = null;
                }
            }

            public static Frame getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeJavaFrame(JavaFrame javaFrame) {
                javaFrame.getClass();
                if (this.frameCase_ == 1 && this.frame_ != JavaFrame.getDefaultInstance()) {
                    javaFrame = JavaFrame.newBuilder((JavaFrame) this.frame_).mergeFrom((JavaFrame.Builder) javaFrame).buildPartial();
                }
                this.frame_ = javaFrame;
                this.frameCase_ = 1;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Frame parseDelimitedFrom(InputStream inputStream) {
                return (Frame) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Frame parseFrom(ByteString byteString) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<Frame> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setJavaFrame(JavaFrame javaFrame) {
                javaFrame.getClass();
                this.frame_ = javaFrame;
                this.frameCase_ = 1;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new Frame();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001<\u0000", new Object[]{"frame_", "frameCase_", JavaFrame.class});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Frame> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Frame.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.FrameOrBuilder
            public FrameCase getFrameCase() {
                return FrameCase.forNumber(this.frameCase_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.FrameOrBuilder
            public JavaFrame getJavaFrame() {
                return this.frameCase_ == 1 ? (JavaFrame) this.frame_ : JavaFrame.getDefaultInstance();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.FrameOrBuilder
            public boolean hasJavaFrame() {
                return this.frameCase_ == 1;
            }

            public static Builder newBuilder(Frame frame) {
                return DEFAULT_INSTANCE.createBuilder(frame);
            }

            public static Frame parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Frame parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Frame parseFrom(CodedInputStream codedInputStream) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Frame parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Frame parseFrom(InputStream inputStream) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Frame parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Frame parseFrom(ByteBuffer byteBuffer) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Frame parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Frame parseFrom(byte[] bArr) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Frame parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface FrameOrBuilder extends MessageLiteOrBuilder {
            Frame.FrameCase getFrameCase();

            JavaFrame getJavaFrame();

            boolean hasJavaFrame();
        }

        public static final class JavaFrame extends GeneratedMessageLite<JavaFrame, Builder> implements JavaFrameOrBuilder {
            public static final int CLASS_FIELD_NUMBER = 3;
            public static final int C_FRAME_TYPE_FIELD_NUMBER = 6;
            private static final JavaFrame DEFAULT_INSTANCE;
            public static final int FILE_FIELD_NUMBER = 2;
            public static final int FRAME_ID_FIELD_NUMBER = 1;
            public static final int LINE_FIELD_NUMBER = 5;
            public static final int METHOD_FIELD_NUMBER = 4;
            private static volatile Parser<JavaFrame> PARSER = null;
            public static final int REPEATED_COUNT_FIELD_NUMBER = 7;
            private int cFrameType_;
            private int frameId_;
            private int line_;
            private int repeatedCount_;
            private String file_ = "";
            private String class__ = "";
            private String method_ = "";

            public static final class Builder extends GeneratedMessageLite.Builder<JavaFrame, Builder> implements JavaFrameOrBuilder {
                private Builder() {
                    super(JavaFrame.DEFAULT_INSTANCE);
                }

                public Builder clearCFrameType() {
                    copyOnWrite();
                    ((JavaFrame) this.instance).clearCFrameType();
                    return this;
                }

                public Builder clearClass_() {
                    copyOnWrite();
                    ((JavaFrame) this.instance).clearClass_();
                    return this;
                }

                public Builder clearFile() {
                    copyOnWrite();
                    ((JavaFrame) this.instance).clearFile();
                    return this;
                }

                public Builder clearFrameId() {
                    copyOnWrite();
                    ((JavaFrame) this.instance).clearFrameId();
                    return this;
                }

                public Builder clearLine() {
                    copyOnWrite();
                    ((JavaFrame) this.instance).clearLine();
                    return this;
                }

                public Builder clearMethod() {
                    copyOnWrite();
                    ((JavaFrame) this.instance).clearMethod();
                    return this;
                }

                public Builder clearRepeatedCount() {
                    copyOnWrite();
                    ((JavaFrame) this.instance).clearRepeatedCount();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
                public ModuleType getCFrameType() {
                    return ((JavaFrame) this.instance).getCFrameType();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
                public int getCFrameTypeValue() {
                    return ((JavaFrame) this.instance).getCFrameTypeValue();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
                public String getClass_() {
                    return ((JavaFrame) this.instance).getClass_();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
                public ByteString getClass_Bytes() {
                    return ((JavaFrame) this.instance).getClass_Bytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
                public String getFile() {
                    return ((JavaFrame) this.instance).getFile();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
                public ByteString getFileBytes() {
                    return ((JavaFrame) this.instance).getFileBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
                public int getFrameId() {
                    return ((JavaFrame) this.instance).getFrameId();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
                public int getLine() {
                    return ((JavaFrame) this.instance).getLine();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
                public String getMethod() {
                    return ((JavaFrame) this.instance).getMethod();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
                public ByteString getMethodBytes() {
                    return ((JavaFrame) this.instance).getMethodBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
                public int getRepeatedCount() {
                    return ((JavaFrame) this.instance).getRepeatedCount();
                }

                public Builder setCFrameType(ModuleType moduleType) {
                    copyOnWrite();
                    ((JavaFrame) this.instance).setCFrameType(moduleType);
                    return this;
                }

                public Builder setCFrameTypeValue(int i) {
                    copyOnWrite();
                    ((JavaFrame) this.instance).setCFrameTypeValue(i);
                    return this;
                }

                public Builder setClass_(String str) {
                    copyOnWrite();
                    ((JavaFrame) this.instance).setClass_(str);
                    return this;
                }

                public Builder setClass_Bytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((JavaFrame) this.instance).setClass_Bytes(byteString);
                    return this;
                }

                public Builder setFile(String str) {
                    copyOnWrite();
                    ((JavaFrame) this.instance).setFile(str);
                    return this;
                }

                public Builder setFileBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((JavaFrame) this.instance).setFileBytes(byteString);
                    return this;
                }

                public Builder setFrameId(int i) {
                    copyOnWrite();
                    ((JavaFrame) this.instance).setFrameId(i);
                    return this;
                }

                public Builder setLine(int i) {
                    copyOnWrite();
                    ((JavaFrame) this.instance).setLine(i);
                    return this;
                }

                public Builder setMethod(String str) {
                    copyOnWrite();
                    ((JavaFrame) this.instance).setMethod(str);
                    return this;
                }

                public Builder setMethodBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((JavaFrame) this.instance).setMethodBytes(byteString);
                    return this;
                }

                public Builder setRepeatedCount(int i) {
                    copyOnWrite();
                    ((JavaFrame) this.instance).setRepeatedCount(i);
                    return this;
                }
            }

            static {
                JavaFrame javaFrame = new JavaFrame();
                DEFAULT_INSTANCE = javaFrame;
                GeneratedMessageLite.registerDefaultInstance(JavaFrame.class, javaFrame);
            }

            private JavaFrame() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCFrameType() {
                this.cFrameType_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearClass_() {
                this.class__ = getDefaultInstance().getClass_();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFile() {
                this.file_ = getDefaultInstance().getFile();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFrameId() {
                this.frameId_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLine() {
                this.line_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMethod() {
                this.method_ = getDefaultInstance().getMethod();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearRepeatedCount() {
                this.repeatedCount_ = 0;
            }

            public static JavaFrame getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static JavaFrame parseDelimitedFrom(InputStream inputStream) {
                return (JavaFrame) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static JavaFrame parseFrom(ByteString byteString) {
                return (JavaFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<JavaFrame> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCFrameType(ModuleType moduleType) {
                this.cFrameType_ = moduleType.getNumber();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCFrameTypeValue(int i) {
                this.cFrameType_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setClass_(String str) {
                str.getClass();
                this.class__ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setClass_Bytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.class__ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFile(String str) {
                str.getClass();
                this.file_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFileBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.file_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFrameId(int i) {
                this.frameId_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLine(int i) {
                this.line_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMethod(String str) {
                str.getClass();
                this.method_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMethodBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.method_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setRepeatedCount(int i) {
                this.repeatedCount_ = i;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new JavaFrame();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u000b\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\u000b\u0006\f\u0007\u000b", new Object[]{"frameId_", "file_", "class__", "method_", "line_", "cFrameType_", "repeatedCount_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<JavaFrame> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (JavaFrame.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
            public ModuleType getCFrameType() {
                ModuleType moduleTypeForNumber = ModuleType.forNumber(this.cFrameType_);
                return moduleTypeForNumber == null ? ModuleType.UNRECOGNIZED : moduleTypeForNumber;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
            public int getCFrameTypeValue() {
                return this.cFrameType_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
            public String getClass_() {
                return this.class__;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
            public ByteString getClass_Bytes() {
                return ByteString.copyFromUtf8(this.class__);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
            public String getFile() {
                return this.file_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
            public ByteString getFileBytes() {
                return ByteString.copyFromUtf8(this.file_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
            public int getFrameId() {
                return this.frameId_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
            public int getLine() {
                return this.line_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
            public String getMethod() {
                return this.method_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
            public ByteString getMethodBytes() {
                return ByteString.copyFromUtf8(this.method_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.JavaFrameOrBuilder
            public int getRepeatedCount() {
                return this.repeatedCount_;
            }

            public static Builder newBuilder(JavaFrame javaFrame) {
                return DEFAULT_INSTANCE.createBuilder(javaFrame);
            }

            public static JavaFrame parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (JavaFrame) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static JavaFrame parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (JavaFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static JavaFrame parseFrom(CodedInputStream codedInputStream) {
                return (JavaFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static JavaFrame parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (JavaFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static JavaFrame parseFrom(InputStream inputStream) {
                return (JavaFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static JavaFrame parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (JavaFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static JavaFrame parseFrom(ByteBuffer byteBuffer) {
                return (JavaFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static JavaFrame parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (JavaFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static JavaFrame parseFrom(byte[] bArr) {
                return (JavaFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static JavaFrame parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (JavaFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface JavaFrameOrBuilder extends MessageLiteOrBuilder {
            ModuleType getCFrameType();

            int getCFrameTypeValue();

            String getClass_();

            ByteString getClass_Bytes();

            String getFile();

            ByteString getFileBytes();

            int getFrameId();

            int getLine();

            String getMethod();

            ByteString getMethodBytes();

            int getRepeatedCount();
        }

        public static final class Thread extends GeneratedMessageLite<Thread, Builder> implements ThreadOrBuilder {
            private static final Thread DEFAULT_INSTANCE;
            public static final int FRAMES_FIELD_NUMBER = 3;
            private static volatile Parser<Thread> PARSER = null;
            public static final int THREAD_ID_FIELD_NUMBER = 1;
            public static final int THREAD_NAME_FIELD_NUMBER = 2;
            private int threadId_;
            private String threadName_ = "";
            private Internal.ProtobufList<Frame> frames_ = GeneratedMessageLite.emptyProtobufList();

            public static final class Builder extends GeneratedMessageLite.Builder<Thread, Builder> implements ThreadOrBuilder {
                private Builder() {
                    super(Thread.DEFAULT_INSTANCE);
                }

                public Builder addAllFrames(Iterable<? extends Frame> iterable) {
                    copyOnWrite();
                    ((Thread) this.instance).addAllFrames(iterable);
                    return this;
                }

                public Builder addFrames(int i, Frame.Builder builder) {
                    copyOnWrite();
                    ((Thread) this.instance).addFrames(i, builder.build());
                    return this;
                }

                public Builder clearFrames() {
                    copyOnWrite();
                    ((Thread) this.instance).clearFrames();
                    return this;
                }

                public Builder clearThreadId() {
                    copyOnWrite();
                    ((Thread) this.instance).clearThreadId();
                    return this;
                }

                public Builder clearThreadName() {
                    copyOnWrite();
                    ((Thread) this.instance).clearThreadName();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ThreadOrBuilder
                public Frame getFrames(int i) {
                    return ((Thread) this.instance).getFrames(i);
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ThreadOrBuilder
                public int getFramesCount() {
                    return ((Thread) this.instance).getFramesCount();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ThreadOrBuilder
                public List<Frame> getFramesList() {
                    return Collections.unmodifiableList(((Thread) this.instance).getFramesList());
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ThreadOrBuilder
                public int getThreadId() {
                    return ((Thread) this.instance).getThreadId();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ThreadOrBuilder
                public String getThreadName() {
                    return ((Thread) this.instance).getThreadName();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ThreadOrBuilder
                public ByteString getThreadNameBytes() {
                    return ((Thread) this.instance).getThreadNameBytes();
                }

                public Builder removeFrames(int i) {
                    copyOnWrite();
                    ((Thread) this.instance).removeFrames(i);
                    return this;
                }

                public Builder setFrames(int i, Frame.Builder builder) {
                    copyOnWrite();
                    ((Thread) this.instance).setFrames(i, builder.build());
                    return this;
                }

                public Builder setThreadId(int i) {
                    copyOnWrite();
                    ((Thread) this.instance).setThreadId(i);
                    return this;
                }

                public Builder setThreadName(String str) {
                    copyOnWrite();
                    ((Thread) this.instance).setThreadName(str);
                    return this;
                }

                public Builder setThreadNameBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((Thread) this.instance).setThreadNameBytes(byteString);
                    return this;
                }

                public Builder addFrames(int i, Frame frame) {
                    copyOnWrite();
                    ((Thread) this.instance).addFrames(i, frame);
                    return this;
                }

                public Builder setFrames(int i, Frame frame) {
                    copyOnWrite();
                    ((Thread) this.instance).setFrames(i, frame);
                    return this;
                }

                public Builder addFrames(Frame.Builder builder) {
                    copyOnWrite();
                    ((Thread) this.instance).addFrames(builder.build());
                    return this;
                }

                public Builder addFrames(Frame frame) {
                    copyOnWrite();
                    ((Thread) this.instance).addFrames(frame);
                    return this;
                }
            }

            static {
                Thread thread = new Thread();
                DEFAULT_INSTANCE = thread;
                GeneratedMessageLite.registerDefaultInstance(Thread.class, thread);
            }

            private Thread() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllFrames(Iterable<? extends Frame> iterable) {
                ensureFramesIsMutable();
                AbstractMessageLite.addAll(iterable, this.frames_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addFrames(int i, Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.add(i, frame);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFrames() {
                this.frames_ = GeneratedMessageLite.emptyProtobufList();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearThreadId() {
                this.threadId_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearThreadName() {
                this.threadName_ = getDefaultInstance().getThreadName();
            }

            private void ensureFramesIsMutable() {
                Internal.ProtobufList<Frame> protobufList = this.frames_;
                if (protobufList.isModifiable()) {
                    return;
                }
                this.frames_ = GeneratedMessageLite.mutableCopy(protobufList);
            }

            public static Thread getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Thread parseDelimitedFrom(InputStream inputStream) {
                return (Thread) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Thread parseFrom(ByteString byteString) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<Thread> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void removeFrames(int i) {
                ensureFramesIsMutable();
                this.frames_.remove(i);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFrames(int i, Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.set(i, frame);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setThreadId(int i) {
                this.threadId_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setThreadName(String str) {
                str.getClass();
                this.threadName_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setThreadNameBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.threadName_ = byteString.toStringUtf8();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new Thread();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u000b\u0002Ȉ\u0003\u001b", new Object[]{"threadId_", "threadName_", "frames_", Frame.class});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Thread> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Thread.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ThreadOrBuilder
            public Frame getFrames(int i) {
                return this.frames_.get(i);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ThreadOrBuilder
            public int getFramesCount() {
                return this.frames_.size();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ThreadOrBuilder
            public List<Frame> getFramesList() {
                return this.frames_;
            }

            public FrameOrBuilder getFramesOrBuilder(int i) {
                return this.frames_.get(i);
            }

            public List<? extends FrameOrBuilder> getFramesOrBuilderList() {
                return this.frames_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ThreadOrBuilder
            public int getThreadId() {
                return this.threadId_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ThreadOrBuilder
            public String getThreadName() {
                return this.threadName_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReport.ThreadOrBuilder
            public ByteString getThreadNameBytes() {
                return ByteString.copyFromUtf8(this.threadName_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addFrames(Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.add(frame);
            }

            public static Builder newBuilder(Thread thread) {
                return DEFAULT_INSTANCE.createBuilder(thread);
            }

            public static Thread parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Thread parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Thread parseFrom(CodedInputStream codedInputStream) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Thread parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Thread parseFrom(InputStream inputStream) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Thread parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Thread parseFrom(ByteBuffer byteBuffer) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Thread parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Thread parseFrom(byte[] bArr) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Thread parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface ThreadOrBuilder extends MessageLiteOrBuilder {
            Frame getFrames(int i);

            int getFramesCount();

            List<Frame> getFramesList();

            int getThreadId();

            String getThreadName();

            ByteString getThreadNameBytes();
        }

        static {
            AndroidThreadReport androidThreadReport = new AndroidThreadReport();
            DEFAULT_INSTANCE = androidThreadReport;
            GeneratedMessageLite.registerDefaultInstance(AndroidThreadReport.class, androidThreadReport);
        }

        private AndroidThreadReport() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllThreads(Iterable<? extends Thread> iterable) {
            ensureThreadsIsMutable();
            AbstractMessageLite.addAll(iterable, this.threads_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addThreads(int i, Thread thread) {
            thread.getClass();
            ensureThreadsIsMutable();
            this.threads_.add(i, thread);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearApplicationVersion() {
            this.applicationVersion_ = getDefaultInstance().getApplicationVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearErrorStacktrace() {
            this.errorStacktrace_ = null;
            this.bitField0_ &= -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMappingVersion() {
            this.mappingVersion_ = getDefaultInstance().getMappingVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPackageName() {
            this.packageName_ = getDefaultInstance().getPackageName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearThreads() {
            this.threads_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureThreadsIsMutable() {
            Internal.ProtobufList<Thread> protobufList = this.threads_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.threads_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static AndroidThreadReport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeErrorStacktrace(ErrorStacktrace errorStacktrace) {
            errorStacktrace.getClass();
            ErrorStacktrace errorStacktrace2 = this.errorStacktrace_;
            if (errorStacktrace2 != null && errorStacktrace2 != ErrorStacktrace.getDefaultInstance()) {
                errorStacktrace = ErrorStacktrace.newBuilder(this.errorStacktrace_).mergeFrom((ErrorStacktrace.Builder) errorStacktrace).buildPartial();
            }
            this.errorStacktrace_ = errorStacktrace;
            this.bitField0_ |= 1;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static AndroidThreadReport parseDelimitedFrom(InputStream inputStream) {
            return (AndroidThreadReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AndroidThreadReport parseFrom(ByteString byteString) {
            return (AndroidThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<AndroidThreadReport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeThreads(int i) {
            ensureThreadsIsMutable();
            this.threads_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setApplicationVersion(String str) {
            str.getClass();
            this.applicationVersion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setApplicationVersionBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.applicationVersion_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrorStacktrace(ErrorStacktrace errorStacktrace) {
            errorStacktrace.getClass();
            this.errorStacktrace_ = errorStacktrace;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMappingVersion(String str) {
            str.getClass();
            this.mappingVersion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMappingVersionBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.mappingVersion_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPackageName(String str) {
            str.getClass();
            this.packageName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPackageNameBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.packageName_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setThreads(int i, Thread thread) {
            thread.getClass();
            ensureThreadsIsMutable();
            this.threads_.set(i, thread);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new AndroidThreadReport();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004ဉ\u0000\u0005\u001b", new Object[]{"bitField0_", "packageName_", "applicationVersion_", "mappingVersion_", "errorStacktrace_", "threads_", Thread.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<AndroidThreadReport> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (AndroidThreadReport.class) {
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

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
        public String getApplicationVersion() {
            return this.applicationVersion_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
        public ByteString getApplicationVersionBytes() {
            return ByteString.copyFromUtf8(this.applicationVersion_);
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
        public ErrorStacktrace getErrorStacktrace() {
            ErrorStacktrace errorStacktrace = this.errorStacktrace_;
            return errorStacktrace == null ? ErrorStacktrace.getDefaultInstance() : errorStacktrace;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
        public String getMappingVersion() {
            return this.mappingVersion_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
        public ByteString getMappingVersionBytes() {
            return ByteString.copyFromUtf8(this.mappingVersion_);
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
        public String getPackageName() {
            return this.packageName_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
        public ByteString getPackageNameBytes() {
            return ByteString.copyFromUtf8(this.packageName_);
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
        public Thread getThreads(int i) {
            return this.threads_.get(i);
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
        public int getThreadsCount() {
            return this.threads_.size();
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
        public List<Thread> getThreadsList() {
            return this.threads_;
        }

        public ThreadOrBuilder getThreadsOrBuilder(int i) {
            return this.threads_.get(i);
        }

        public List<? extends ThreadOrBuilder> getThreadsOrBuilderList() {
            return this.threads_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.AndroidThreadReportOrBuilder
        public boolean hasErrorStacktrace() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addThreads(Thread thread) {
            thread.getClass();
            ensureThreadsIsMutable();
            this.threads_.add(thread);
        }

        public static Builder newBuilder(AndroidThreadReport androidThreadReport) {
            return DEFAULT_INSTANCE.createBuilder(androidThreadReport);
        }

        public static AndroidThreadReport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AndroidThreadReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AndroidThreadReport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (AndroidThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AndroidThreadReport parseFrom(CodedInputStream codedInputStream) {
            return (AndroidThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AndroidThreadReport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AndroidThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static AndroidThreadReport parseFrom(InputStream inputStream) {
            return (AndroidThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AndroidThreadReport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (AndroidThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AndroidThreadReport parseFrom(ByteBuffer byteBuffer) {
            return (AndroidThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static AndroidThreadReport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (AndroidThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static AndroidThreadReport parseFrom(byte[] bArr) {
            return (AndroidThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AndroidThreadReport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (AndroidThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface AndroidThreadReportOrBuilder extends MessageLiteOrBuilder {
        String getApplicationVersion();

        ByteString getApplicationVersionBytes();

        AndroidThreadReport.ErrorStacktrace getErrorStacktrace();

        String getMappingVersion();

        ByteString getMappingVersionBytes();

        String getPackageName();

        ByteString getPackageNameBytes();

        AndroidThreadReport.Thread getThreads(int i);

        int getThreadsCount();

        List<AndroidThreadReport.Thread> getThreadsList();

        boolean hasErrorStacktrace();
    }

    public static final class Context extends GeneratedMessageLite<Context, Builder> implements ContextOrBuilder {
        private static final Context DEFAULT_INSTANCE;
        public static final int ERROR_SOURCE_FIELD_NUMBER = 5;
        private static volatile Parser<Context> PARSER = null;
        public static final int PROJECT_ID_FIELD_NUMBER = 1;
        public static final int SESSION_NUMBER_FIELD_NUMBER = 2;
        public static final int USER_ID_FIELD_NUMBER = 4;
        public static final int VIEW_NUMBER_FIELD_NUMBER = 3;
        private int bitField0_;
        private int projectId_;
        private int sessionNumber_;
        private int viewNumber_;
        private String userId_ = "";
        private String errorSource_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<Context, Builder> implements ContextOrBuilder {
            private Builder() {
                super(Context.DEFAULT_INSTANCE);
            }

            public Builder clearErrorSource() {
                copyOnWrite();
                ((Context) this.instance).clearErrorSource();
                return this;
            }

            public Builder clearProjectId() {
                copyOnWrite();
                ((Context) this.instance).clearProjectId();
                return this;
            }

            public Builder clearSessionNumber() {
                copyOnWrite();
                ((Context) this.instance).clearSessionNumber();
                return this;
            }

            public Builder clearUserId() {
                copyOnWrite();
                ((Context) this.instance).clearUserId();
                return this;
            }

            public Builder clearViewNumber() {
                copyOnWrite();
                ((Context) this.instance).clearViewNumber();
                return this;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ContextOrBuilder
            public String getErrorSource() {
                return ((Context) this.instance).getErrorSource();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ContextOrBuilder
            public ByteString getErrorSourceBytes() {
                return ((Context) this.instance).getErrorSourceBytes();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ContextOrBuilder
            public int getProjectId() {
                return ((Context) this.instance).getProjectId();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ContextOrBuilder
            public int getSessionNumber() {
                return ((Context) this.instance).getSessionNumber();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ContextOrBuilder
            public String getUserId() {
                return ((Context) this.instance).getUserId();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ContextOrBuilder
            public ByteString getUserIdBytes() {
                return ((Context) this.instance).getUserIdBytes();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ContextOrBuilder
            public int getViewNumber() {
                return ((Context) this.instance).getViewNumber();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ContextOrBuilder
            public boolean hasErrorSource() {
                return ((Context) this.instance).hasErrorSource();
            }

            public Builder setErrorSource(String str) {
                copyOnWrite();
                ((Context) this.instance).setErrorSource(str);
                return this;
            }

            public Builder setErrorSourceBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((Context) this.instance).setErrorSourceBytes(byteString);
                return this;
            }

            public Builder setProjectId(int i) {
                copyOnWrite();
                ((Context) this.instance).setProjectId(i);
                return this;
            }

            public Builder setSessionNumber(int i) {
                copyOnWrite();
                ((Context) this.instance).setSessionNumber(i);
                return this;
            }

            public Builder setUserId(String str) {
                copyOnWrite();
                ((Context) this.instance).setUserId(str);
                return this;
            }

            public Builder setUserIdBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((Context) this.instance).setUserIdBytes(byteString);
                return this;
            }

            public Builder setViewNumber(int i) {
                copyOnWrite();
                ((Context) this.instance).setViewNumber(i);
                return this;
            }
        }

        static {
            Context context = new Context();
            DEFAULT_INSTANCE = context;
            GeneratedMessageLite.registerDefaultInstance(Context.class, context);
        }

        private Context() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearErrorSource() {
            this.bitField0_ &= -2;
            this.errorSource_ = getDefaultInstance().getErrorSource();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearProjectId() {
            this.projectId_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSessionNumber() {
            this.sessionNumber_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUserId() {
            this.userId_ = getDefaultInstance().getUserId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearViewNumber() {
            this.viewNumber_ = 0;
        }

        public static Context getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Context parseDelimitedFrom(InputStream inputStream) {
            return (Context) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Context parseFrom(ByteString byteString) {
            return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<Context> parser() {
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
        public void setProjectId(int i) {
            this.projectId_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionNumber(int i) {
            this.sessionNumber_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserId(String str) {
            str.getClass();
            this.userId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserIdBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.userId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setViewNumber(int i) {
            this.viewNumber_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new Context();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u000b\u0002\u000b\u0003\u000b\u0004Ȉ\u0005ለ\u0000", new Object[]{"bitField0_", "projectId_", "sessionNumber_", "viewNumber_", "userId_", "errorSource_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Context> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (Context.class) {
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

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ContextOrBuilder
        public String getErrorSource() {
            return this.errorSource_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ContextOrBuilder
        public ByteString getErrorSourceBytes() {
            return ByteString.copyFromUtf8(this.errorSource_);
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ContextOrBuilder
        public int getProjectId() {
            return this.projectId_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ContextOrBuilder
        public int getSessionNumber() {
            return this.sessionNumber_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ContextOrBuilder
        public String getUserId() {
            return this.userId_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ContextOrBuilder
        public ByteString getUserIdBytes() {
            return ByteString.copyFromUtf8(this.userId_);
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ContextOrBuilder
        public int getViewNumber() {
            return this.viewNumber_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ContextOrBuilder
        public boolean hasErrorSource() {
            return (this.bitField0_ & 1) != 0;
        }

        public static Builder newBuilder(Context context) {
            return DEFAULT_INSTANCE.createBuilder(context);
        }

        public static Context parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Context) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Context parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Context parseFrom(CodedInputStream codedInputStream) {
            return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Context parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Context parseFrom(InputStream inputStream) {
            return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Context parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Context parseFrom(ByteBuffer byteBuffer) {
            return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Context parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Context parseFrom(byte[] bArr) {
            return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Context parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Context) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface ContextOrBuilder extends MessageLiteOrBuilder {
        String getErrorSource();

        ByteString getErrorSourceBytes();

        int getProjectId();

        int getSessionNumber();

        String getUserId();

        ByteString getUserIdBytes();

        int getViewNumber();

        boolean hasErrorSource();
    }

    public static final class Crash extends GeneratedMessageLite<Crash, Builder> implements CrashOrBuilder {
        public static final int CONTEXT_FIELD_NUMBER = 1;
        public static final int CRASH_ID_FIELD_NUMBER = 3;
        private static final Crash DEFAULT_INSTANCE;
        public static final int OS_FIELD_NUMBER = 2;
        private static volatile Parser<Crash> PARSER = null;
        public static final int RELATIVE_TIME_FIELD_NUMBER = 4;
        public static final int THREAD_REPORT_FIELD_NUMBER = 5;
        private int bitField0_;
        private Context context_;
        private long crashId_;
        private int os_;
        private long relativeTime_;
        private ThreadReport threadReport_;

        public static final class Builder extends GeneratedMessageLite.Builder<Crash, Builder> implements CrashOrBuilder {
            private Builder() {
                super(Crash.DEFAULT_INSTANCE);
            }

            public Builder clearContext() {
                copyOnWrite();
                ((Crash) this.instance).clearContext();
                return this;
            }

            public Builder clearCrashId() {
                copyOnWrite();
                ((Crash) this.instance).clearCrashId();
                return this;
            }

            public Builder clearOs() {
                copyOnWrite();
                ((Crash) this.instance).clearOs();
                return this;
            }

            public Builder clearRelativeTime() {
                copyOnWrite();
                ((Crash) this.instance).clearRelativeTime();
                return this;
            }

            public Builder clearThreadReport() {
                copyOnWrite();
                ((Crash) this.instance).clearThreadReport();
                return this;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashOrBuilder
            public Context getContext() {
                return ((Crash) this.instance).getContext();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashOrBuilder
            public long getCrashId() {
                return ((Crash) this.instance).getCrashId();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashOrBuilder
            public OS getOs() {
                return ((Crash) this.instance).getOs();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashOrBuilder
            public int getOsValue() {
                return ((Crash) this.instance).getOsValue();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashOrBuilder
            public long getRelativeTime() {
                return ((Crash) this.instance).getRelativeTime();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashOrBuilder
            public ThreadReport getThreadReport() {
                return ((Crash) this.instance).getThreadReport();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashOrBuilder
            public boolean hasContext() {
                return ((Crash) this.instance).hasContext();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashOrBuilder
            public boolean hasThreadReport() {
                return ((Crash) this.instance).hasThreadReport();
            }

            public Builder mergeContext(Context context) {
                copyOnWrite();
                ((Crash) this.instance).mergeContext(context);
                return this;
            }

            public Builder mergeThreadReport(ThreadReport threadReport) {
                copyOnWrite();
                ((Crash) this.instance).mergeThreadReport(threadReport);
                return this;
            }

            public Builder setContext(Context.Builder builder) {
                copyOnWrite();
                ((Crash) this.instance).setContext(builder.build());
                return this;
            }

            public Builder setCrashId(long j) {
                copyOnWrite();
                ((Crash) this.instance).setCrashId(j);
                return this;
            }

            public Builder setOs(OS os) {
                copyOnWrite();
                ((Crash) this.instance).setOs(os);
                return this;
            }

            public Builder setOsValue(int i) {
                copyOnWrite();
                ((Crash) this.instance).setOsValue(i);
                return this;
            }

            public Builder setRelativeTime(long j) {
                copyOnWrite();
                ((Crash) this.instance).setRelativeTime(j);
                return this;
            }

            public Builder setThreadReport(ThreadReport.Builder builder) {
                copyOnWrite();
                ((Crash) this.instance).setThreadReport(builder.build());
                return this;
            }

            public Builder setContext(Context context) {
                copyOnWrite();
                ((Crash) this.instance).setContext(context);
                return this;
            }

            public Builder setThreadReport(ThreadReport threadReport) {
                copyOnWrite();
                ((Crash) this.instance).setThreadReport(threadReport);
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
        public void clearContext() {
            this.context_ = null;
            this.bitField0_ &= -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCrashId() {
            this.crashId_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOs() {
            this.os_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRelativeTime() {
            this.relativeTime_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearThreadReport() {
            this.threadReport_ = null;
            this.bitField0_ &= -3;
        }

        public static Crash getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeContext(Context context) {
            context.getClass();
            Context context2 = this.context_;
            if (context2 != null && context2 != Context.getDefaultInstance()) {
                context = Context.newBuilder(this.context_).mergeFrom((Context.Builder) context).buildPartial();
            }
            this.context_ = context;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeThreadReport(ThreadReport threadReport) {
            threadReport.getClass();
            ThreadReport threadReport2 = this.threadReport_;
            if (threadReport2 != null && threadReport2 != ThreadReport.getDefaultInstance()) {
                threadReport = ThreadReport.newBuilder(this.threadReport_).mergeFrom((ThreadReport.Builder) threadReport).buildPartial();
            }
            this.threadReport_ = threadReport;
            this.bitField0_ |= 2;
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
        public void setContext(Context context) {
            context.getClass();
            this.context_ = context;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCrashId(long j) {
            this.crashId_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOs(OS os) {
            this.os_ = os.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOsValue(int i) {
            this.os_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRelativeTime(long j) {
            this.relativeTime_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setThreadReport(ThreadReport threadReport) {
            threadReport.getClass();
            this.threadReport_ = threadReport;
            this.bitField0_ |= 2;
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
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u0003\u0004\u0003\u0005ဉ\u0001", new Object[]{"bitField0_", "context_", "os_", "crashId_", "relativeTime_", "threadReport_"});
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

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashOrBuilder
        public Context getContext() {
            Context context = this.context_;
            return context == null ? Context.getDefaultInstance() : context;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashOrBuilder
        public long getCrashId() {
            return this.crashId_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashOrBuilder
        public OS getOs() {
            OS osForNumber = OS.forNumber(this.os_);
            return osForNumber == null ? OS.UNRECOGNIZED : osForNumber;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashOrBuilder
        public int getOsValue() {
            return this.os_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashOrBuilder
        public long getRelativeTime() {
            return this.relativeTime_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashOrBuilder
        public ThreadReport getThreadReport() {
            ThreadReport threadReport = this.threadReport_;
            return threadReport == null ? ThreadReport.getDefaultInstance() : threadReport;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashOrBuilder
        public boolean hasContext() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashOrBuilder
        public boolean hasThreadReport() {
            return (this.bitField0_ & 2) != 0;
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
        Context getContext();

        long getCrashId();

        OS getOs();

        int getOsValue();

        long getRelativeTime();

        ThreadReport getThreadReport();

        boolean hasContext();

        boolean hasThreadReport();
    }

    public static final class CrashWrapped extends GeneratedMessageLite<CrashWrapped, Builder> implements CrashWrappedOrBuilder {
        public static final int CRASH_FIELD_NUMBER = 2;
        public static final int CS_LOG_REQUEST_FIELD_NUMBER = 3;
        private static final CrashWrapped DEFAULT_INSTANCE;
        private static volatile Parser<CrashWrapped> PARSER = null;
        public static final int TIMESTAMP_FIELD_NUMBER = 1;
        private ByteString crash_ = ByteString.EMPTY;
        private boolean csLogRequest_;
        private long timestamp_;

        public static final class Builder extends GeneratedMessageLite.Builder<CrashWrapped, Builder> implements CrashWrappedOrBuilder {
            private Builder() {
                super(CrashWrapped.DEFAULT_INSTANCE);
            }

            public Builder clearCrash() {
                copyOnWrite();
                ((CrashWrapped) this.instance).clearCrash();
                return this;
            }

            public Builder clearCsLogRequest() {
                copyOnWrite();
                ((CrashWrapped) this.instance).clearCsLogRequest();
                return this;
            }

            public Builder clearTimestamp() {
                copyOnWrite();
                ((CrashWrapped) this.instance).clearTimestamp();
                return this;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashWrappedOrBuilder
            public ByteString getCrash() {
                return ((CrashWrapped) this.instance).getCrash();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashWrappedOrBuilder
            public boolean getCsLogRequest() {
                return ((CrashWrapped) this.instance).getCsLogRequest();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashWrappedOrBuilder
            public long getTimestamp() {
                return ((CrashWrapped) this.instance).getTimestamp();
            }

            public Builder setCrash(ByteString byteString) {
                copyOnWrite();
                ((CrashWrapped) this.instance).setCrash(byteString);
                return this;
            }

            public Builder setCsLogRequest(boolean z) {
                copyOnWrite();
                ((CrashWrapped) this.instance).setCsLogRequest(z);
                return this;
            }

            public Builder setTimestamp(long j) {
                copyOnWrite();
                ((CrashWrapped) this.instance).setTimestamp(j);
                return this;
            }
        }

        static {
            CrashWrapped crashWrapped = new CrashWrapped();
            DEFAULT_INSTANCE = crashWrapped;
            GeneratedMessageLite.registerDefaultInstance(CrashWrapped.class, crashWrapped);
        }

        private CrashWrapped() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCrash() {
            this.crash_ = getDefaultInstance().getCrash();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCsLogRequest() {
            this.csLogRequest_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimestamp() {
            this.timestamp_ = 0L;
        }

        public static CrashWrapped getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static CrashWrapped parseDelimitedFrom(InputStream inputStream) {
            return (CrashWrapped) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CrashWrapped parseFrom(ByteString byteString) {
            return (CrashWrapped) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<CrashWrapped> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCrash(ByteString byteString) {
            byteString.getClass();
            this.crash_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCsLogRequest(boolean z) {
            this.csLogRequest_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimestamp(long j) {
            this.timestamp_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new CrashWrapped();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0003\u0002\n\u0003\u0007", new Object[]{"timestamp_", "crash_", "csLogRequest_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<CrashWrapped> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (CrashWrapped.class) {
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

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashWrappedOrBuilder
        public ByteString getCrash() {
            return this.crash_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashWrappedOrBuilder
        public boolean getCsLogRequest() {
            return this.csLogRequest_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.CrashWrappedOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        public static Builder newBuilder(CrashWrapped crashWrapped) {
            return DEFAULT_INSTANCE.createBuilder(crashWrapped);
        }

        public static CrashWrapped parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CrashWrapped) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CrashWrapped parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (CrashWrapped) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CrashWrapped parseFrom(CodedInputStream codedInputStream) {
            return (CrashWrapped) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CrashWrapped parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CrashWrapped) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static CrashWrapped parseFrom(InputStream inputStream) {
            return (CrashWrapped) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CrashWrapped parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CrashWrapped) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CrashWrapped parseFrom(ByteBuffer byteBuffer) {
            return (CrashWrapped) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static CrashWrapped parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (CrashWrapped) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static CrashWrapped parseFrom(byte[] bArr) {
            return (CrashWrapped) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CrashWrapped parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (CrashWrapped) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface CrashWrappedOrBuilder extends MessageLiteOrBuilder {
        ByteString getCrash();

        boolean getCsLogRequest();

        long getTimestamp();
    }

    public static final class EmptyThreadReport extends GeneratedMessageLite<EmptyThreadReport, Builder> implements EmptyThreadReportOrBuilder {
        private static final EmptyThreadReport DEFAULT_INSTANCE;
        private static volatile Parser<EmptyThreadReport> PARSER;

        public static final class Builder extends GeneratedMessageLite.Builder<EmptyThreadReport, Builder> implements EmptyThreadReportOrBuilder {
            private Builder() {
                super(EmptyThreadReport.DEFAULT_INSTANCE);
            }
        }

        static {
            EmptyThreadReport emptyThreadReport = new EmptyThreadReport();
            DEFAULT_INSTANCE = emptyThreadReport;
            GeneratedMessageLite.registerDefaultInstance(EmptyThreadReport.class, emptyThreadReport);
        }

        private EmptyThreadReport() {
        }

        public static EmptyThreadReport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static EmptyThreadReport parseDelimitedFrom(InputStream inputStream) {
            return (EmptyThreadReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EmptyThreadReport parseFrom(ByteString byteString) {
            return (EmptyThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<EmptyThreadReport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new EmptyThreadReport();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EmptyThreadReport> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (EmptyThreadReport.class) {
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

        public static Builder newBuilder(EmptyThreadReport emptyThreadReport) {
            return DEFAULT_INSTANCE.createBuilder(emptyThreadReport);
        }

        public static EmptyThreadReport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EmptyThreadReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EmptyThreadReport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (EmptyThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EmptyThreadReport parseFrom(CodedInputStream codedInputStream) {
            return (EmptyThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EmptyThreadReport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EmptyThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static EmptyThreadReport parseFrom(InputStream inputStream) {
            return (EmptyThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EmptyThreadReport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EmptyThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EmptyThreadReport parseFrom(ByteBuffer byteBuffer) {
            return (EmptyThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static EmptyThreadReport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (EmptyThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static EmptyThreadReport parseFrom(byte[] bArr) {
            return (EmptyThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static EmptyThreadReport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (EmptyThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface EmptyThreadReportOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class FlutterThreadReport extends GeneratedMessageLite<FlutterThreadReport, Builder> implements FlutterThreadReportOrBuilder {
        public static final int APP_INFO_FIELD_NUMBER = 1;
        public static final int CONTEXT_FIELD_NUMBER = 4;
        private static final FlutterThreadReport DEFAULT_INSTANCE;
        public static final int EXCEPTION_FIELD_NUMBER = 2;
        public static final int LIBRARY_FIELD_NUMBER = 5;
        private static volatile Parser<FlutterThreadReport> PARSER = null;
        public static final int SUMMARY_FIELD_NUMBER = 6;
        public static final int THREADS_FIELD_NUMBER = 3;
        public static final int TIMESTAMP_FIELD_NUMBER = 7;
        private FlutterAppInfo appInfo_;
        private int bitField0_;
        private FlutterException exception_;
        private long timestamp_;
        private Internal.ProtobufList<Thread> threads_ = GeneratedMessageLite.emptyProtobufList();
        private String context_ = "";
        private String library_ = "";
        private String summary_ = "";

        public static final class Builder extends GeneratedMessageLite.Builder<FlutterThreadReport, Builder> implements FlutterThreadReportOrBuilder {
            private Builder() {
                super(FlutterThreadReport.DEFAULT_INSTANCE);
            }

            public Builder addAllThreads(Iterable<? extends Thread> iterable) {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).addAllThreads(iterable);
                return this;
            }

            public Builder addThreads(int i, Thread.Builder builder) {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).addThreads(i, builder.build());
                return this;
            }

            public Builder clearAppInfo() {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).clearAppInfo();
                return this;
            }

            public Builder clearContext() {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).clearContext();
                return this;
            }

            public Builder clearException() {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).clearException();
                return this;
            }

            public Builder clearLibrary() {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).clearLibrary();
                return this;
            }

            public Builder clearSummary() {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).clearSummary();
                return this;
            }

            public Builder clearThreads() {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).clearThreads();
                return this;
            }

            public Builder clearTimestamp() {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).clearTimestamp();
                return this;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
            public FlutterAppInfo getAppInfo() {
                return ((FlutterThreadReport) this.instance).getAppInfo();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
            public String getContext() {
                return ((FlutterThreadReport) this.instance).getContext();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
            public ByteString getContextBytes() {
                return ((FlutterThreadReport) this.instance).getContextBytes();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
            public FlutterException getException() {
                return ((FlutterThreadReport) this.instance).getException();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
            public String getLibrary() {
                return ((FlutterThreadReport) this.instance).getLibrary();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
            public ByteString getLibraryBytes() {
                return ((FlutterThreadReport) this.instance).getLibraryBytes();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
            public String getSummary() {
                return ((FlutterThreadReport) this.instance).getSummary();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
            public ByteString getSummaryBytes() {
                return ((FlutterThreadReport) this.instance).getSummaryBytes();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
            public Thread getThreads(int i) {
                return ((FlutterThreadReport) this.instance).getThreads(i);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
            public int getThreadsCount() {
                return ((FlutterThreadReport) this.instance).getThreadsCount();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
            public List<Thread> getThreadsList() {
                return Collections.unmodifiableList(((FlutterThreadReport) this.instance).getThreadsList());
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
            public long getTimestamp() {
                return ((FlutterThreadReport) this.instance).getTimestamp();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
            public boolean hasAppInfo() {
                return ((FlutterThreadReport) this.instance).hasAppInfo();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
            public boolean hasException() {
                return ((FlutterThreadReport) this.instance).hasException();
            }

            public Builder mergeAppInfo(FlutterAppInfo flutterAppInfo) {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).mergeAppInfo(flutterAppInfo);
                return this;
            }

            public Builder mergeException(FlutterException flutterException) {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).mergeException(flutterException);
                return this;
            }

            public Builder removeThreads(int i) {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).removeThreads(i);
                return this;
            }

            public Builder setAppInfo(FlutterAppInfo.Builder builder) {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).setAppInfo(builder.build());
                return this;
            }

            public Builder setContext(String str) {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).setContext(str);
                return this;
            }

            public Builder setContextBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).setContextBytes(byteString);
                return this;
            }

            public Builder setException(FlutterException.Builder builder) {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).setException(builder.build());
                return this;
            }

            public Builder setLibrary(String str) {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).setLibrary(str);
                return this;
            }

            public Builder setLibraryBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).setLibraryBytes(byteString);
                return this;
            }

            public Builder setSummary(String str) {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).setSummary(str);
                return this;
            }

            public Builder setSummaryBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).setSummaryBytes(byteString);
                return this;
            }

            public Builder setThreads(int i, Thread.Builder builder) {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).setThreads(i, builder.build());
                return this;
            }

            public Builder setTimestamp(long j) {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).setTimestamp(j);
                return this;
            }

            public Builder addThreads(int i, Thread thread) {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).addThreads(i, thread);
                return this;
            }

            public Builder setAppInfo(FlutterAppInfo flutterAppInfo) {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).setAppInfo(flutterAppInfo);
                return this;
            }

            public Builder setException(FlutterException flutterException) {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).setException(flutterException);
                return this;
            }

            public Builder setThreads(int i, Thread thread) {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).setThreads(i, thread);
                return this;
            }

            public Builder addThreads(Thread.Builder builder) {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).addThreads(builder.build());
                return this;
            }

            public Builder addThreads(Thread thread) {
                copyOnWrite();
                ((FlutterThreadReport) this.instance).addThreads(thread);
                return this;
            }
        }

        public static final class FlutterAppInfo extends GeneratedMessageLite<FlutterAppInfo, Builder> implements FlutterAppInfoOrBuilder {
            public static final int BUILD_NUMBER_FIELD_NUMBER = 3;
            private static final FlutterAppInfo DEFAULT_INSTANCE;
            public static final int PACKAGE_NAME_FIELD_NUMBER = 1;
            private static volatile Parser<FlutterAppInfo> PARSER = null;
            public static final int PUB_NAME_FIELD_NUMBER = 5;
            public static final int SYMBOL_FILE_ID_FIELD_NUMBER = 4;
            public static final int VERSION_FIELD_NUMBER = 2;
            private int bitField0_;
            private String packageName_ = "";
            private String version_ = "";
            private String buildNumber_ = "";
            private String symbolFileId_ = "";
            private String pubName_ = "";

            public static final class Builder extends GeneratedMessageLite.Builder<FlutterAppInfo, Builder> implements FlutterAppInfoOrBuilder {
                private Builder() {
                    super(FlutterAppInfo.DEFAULT_INSTANCE);
                }

                public Builder clearBuildNumber() {
                    copyOnWrite();
                    ((FlutterAppInfo) this.instance).clearBuildNumber();
                    return this;
                }

                public Builder clearPackageName() {
                    copyOnWrite();
                    ((FlutterAppInfo) this.instance).clearPackageName();
                    return this;
                }

                public Builder clearPubName() {
                    copyOnWrite();
                    ((FlutterAppInfo) this.instance).clearPubName();
                    return this;
                }

                public Builder clearSymbolFileId() {
                    copyOnWrite();
                    ((FlutterAppInfo) this.instance).clearSymbolFileId();
                    return this;
                }

                public Builder clearVersion() {
                    copyOnWrite();
                    ((FlutterAppInfo) this.instance).clearVersion();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
                public String getBuildNumber() {
                    return ((FlutterAppInfo) this.instance).getBuildNumber();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
                public ByteString getBuildNumberBytes() {
                    return ((FlutterAppInfo) this.instance).getBuildNumberBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
                public String getPackageName() {
                    return ((FlutterAppInfo) this.instance).getPackageName();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
                public ByteString getPackageNameBytes() {
                    return ((FlutterAppInfo) this.instance).getPackageNameBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
                public String getPubName() {
                    return ((FlutterAppInfo) this.instance).getPubName();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
                public ByteString getPubNameBytes() {
                    return ((FlutterAppInfo) this.instance).getPubNameBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
                public String getSymbolFileId() {
                    return ((FlutterAppInfo) this.instance).getSymbolFileId();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
                public ByteString getSymbolFileIdBytes() {
                    return ((FlutterAppInfo) this.instance).getSymbolFileIdBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
                public String getVersion() {
                    return ((FlutterAppInfo) this.instance).getVersion();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
                public ByteString getVersionBytes() {
                    return ((FlutterAppInfo) this.instance).getVersionBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
                public boolean hasSymbolFileId() {
                    return ((FlutterAppInfo) this.instance).hasSymbolFileId();
                }

                public Builder setBuildNumber(String str) {
                    copyOnWrite();
                    ((FlutterAppInfo) this.instance).setBuildNumber(str);
                    return this;
                }

                public Builder setBuildNumberBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((FlutterAppInfo) this.instance).setBuildNumberBytes(byteString);
                    return this;
                }

                public Builder setPackageName(String str) {
                    copyOnWrite();
                    ((FlutterAppInfo) this.instance).setPackageName(str);
                    return this;
                }

                public Builder setPackageNameBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((FlutterAppInfo) this.instance).setPackageNameBytes(byteString);
                    return this;
                }

                public Builder setPubName(String str) {
                    copyOnWrite();
                    ((FlutterAppInfo) this.instance).setPubName(str);
                    return this;
                }

                public Builder setPubNameBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((FlutterAppInfo) this.instance).setPubNameBytes(byteString);
                    return this;
                }

                public Builder setSymbolFileId(String str) {
                    copyOnWrite();
                    ((FlutterAppInfo) this.instance).setSymbolFileId(str);
                    return this;
                }

                public Builder setSymbolFileIdBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((FlutterAppInfo) this.instance).setSymbolFileIdBytes(byteString);
                    return this;
                }

                public Builder setVersion(String str) {
                    copyOnWrite();
                    ((FlutterAppInfo) this.instance).setVersion(str);
                    return this;
                }

                public Builder setVersionBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((FlutterAppInfo) this.instance).setVersionBytes(byteString);
                    return this;
                }
            }

            static {
                FlutterAppInfo flutterAppInfo = new FlutterAppInfo();
                DEFAULT_INSTANCE = flutterAppInfo;
                GeneratedMessageLite.registerDefaultInstance(FlutterAppInfo.class, flutterAppInfo);
            }

            private FlutterAppInfo() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearBuildNumber() {
                this.buildNumber_ = getDefaultInstance().getBuildNumber();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPackageName() {
                this.packageName_ = getDefaultInstance().getPackageName();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPubName() {
                this.pubName_ = getDefaultInstance().getPubName();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearSymbolFileId() {
                this.bitField0_ &= -2;
                this.symbolFileId_ = getDefaultInstance().getSymbolFileId();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearVersion() {
                this.version_ = getDefaultInstance().getVersion();
            }

            public static FlutterAppInfo getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static FlutterAppInfo parseDelimitedFrom(InputStream inputStream) {
                return (FlutterAppInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static FlutterAppInfo parseFrom(ByteString byteString) {
                return (FlutterAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<FlutterAppInfo> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBuildNumber(String str) {
                str.getClass();
                this.buildNumber_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBuildNumberBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.buildNumber_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPackageName(String str) {
                str.getClass();
                this.packageName_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPackageNameBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.packageName_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPubName(String str) {
                str.getClass();
                this.pubName_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPubNameBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.pubName_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setSymbolFileId(String str) {
                str.getClass();
                this.bitField0_ |= 1;
                this.symbolFileId_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setSymbolFileIdBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.symbolFileId_ = byteString.toStringUtf8();
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVersion(String str) {
                str.getClass();
                this.version_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVersionBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.version_ = byteString.toStringUtf8();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new FlutterAppInfo();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004ለ\u0000\u0005Ȉ", new Object[]{"bitField0_", "packageName_", "version_", "buildNumber_", "symbolFileId_", "pubName_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<FlutterAppInfo> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (FlutterAppInfo.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
            public String getBuildNumber() {
                return this.buildNumber_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
            public ByteString getBuildNumberBytes() {
                return ByteString.copyFromUtf8(this.buildNumber_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
            public String getPackageName() {
                return this.packageName_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
            public ByteString getPackageNameBytes() {
                return ByteString.copyFromUtf8(this.packageName_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
            public String getPubName() {
                return this.pubName_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
            public ByteString getPubNameBytes() {
                return ByteString.copyFromUtf8(this.pubName_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
            public String getSymbolFileId() {
                return this.symbolFileId_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
            public ByteString getSymbolFileIdBytes() {
                return ByteString.copyFromUtf8(this.symbolFileId_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
            public String getVersion() {
                return this.version_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
            public ByteString getVersionBytes() {
                return ByteString.copyFromUtf8(this.version_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterAppInfoOrBuilder
            public boolean hasSymbolFileId() {
                return (this.bitField0_ & 1) != 0;
            }

            public static Builder newBuilder(FlutterAppInfo flutterAppInfo) {
                return DEFAULT_INSTANCE.createBuilder(flutterAppInfo);
            }

            public static FlutterAppInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (FlutterAppInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static FlutterAppInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (FlutterAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static FlutterAppInfo parseFrom(CodedInputStream codedInputStream) {
                return (FlutterAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static FlutterAppInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (FlutterAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static FlutterAppInfo parseFrom(InputStream inputStream) {
                return (FlutterAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static FlutterAppInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (FlutterAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static FlutterAppInfo parseFrom(ByteBuffer byteBuffer) {
                return (FlutterAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static FlutterAppInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (FlutterAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static FlutterAppInfo parseFrom(byte[] bArr) {
                return (FlutterAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static FlutterAppInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (FlutterAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface FlutterAppInfoOrBuilder extends MessageLiteOrBuilder {
            String getBuildNumber();

            ByteString getBuildNumberBytes();

            String getPackageName();

            ByteString getPackageNameBytes();

            String getPubName();

            ByteString getPubNameBytes();

            String getSymbolFileId();

            ByteString getSymbolFileIdBytes();

            String getVersion();

            ByteString getVersionBytes();

            boolean hasSymbolFileId();
        }

        public static final class FlutterException extends GeneratedMessageLite<FlutterException, Builder> implements FlutterExceptionOrBuilder {
            private static final FlutterException DEFAULT_INSTANCE;
            public static final int DESCRIPTION_FIELD_NUMBER = 2;
            public static final int FRAMES_FIELD_NUMBER = 3;
            private static volatile Parser<FlutterException> PARSER = null;
            public static final int TYPE_FIELD_NUMBER = 1;
            private String type_ = "";
            private String description_ = "";
            private Internal.ProtobufList<Frame> frames_ = GeneratedMessageLite.emptyProtobufList();

            public static final class Builder extends GeneratedMessageLite.Builder<FlutterException, Builder> implements FlutterExceptionOrBuilder {
                private Builder() {
                    super(FlutterException.DEFAULT_INSTANCE);
                }

                public Builder addAllFrames(Iterable<? extends Frame> iterable) {
                    copyOnWrite();
                    ((FlutterException) this.instance).addAllFrames(iterable);
                    return this;
                }

                public Builder addFrames(int i, Frame.Builder builder) {
                    copyOnWrite();
                    ((FlutterException) this.instance).addFrames(i, builder.build());
                    return this;
                }

                public Builder clearDescription() {
                    copyOnWrite();
                    ((FlutterException) this.instance).clearDescription();
                    return this;
                }

                public Builder clearFrames() {
                    copyOnWrite();
                    ((FlutterException) this.instance).clearFrames();
                    return this;
                }

                public Builder clearType() {
                    copyOnWrite();
                    ((FlutterException) this.instance).clearType();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterExceptionOrBuilder
                public String getDescription() {
                    return ((FlutterException) this.instance).getDescription();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterExceptionOrBuilder
                public ByteString getDescriptionBytes() {
                    return ((FlutterException) this.instance).getDescriptionBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterExceptionOrBuilder
                public Frame getFrames(int i) {
                    return ((FlutterException) this.instance).getFrames(i);
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterExceptionOrBuilder
                public int getFramesCount() {
                    return ((FlutterException) this.instance).getFramesCount();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterExceptionOrBuilder
                public List<Frame> getFramesList() {
                    return Collections.unmodifiableList(((FlutterException) this.instance).getFramesList());
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterExceptionOrBuilder
                public String getType() {
                    return ((FlutterException) this.instance).getType();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterExceptionOrBuilder
                public ByteString getTypeBytes() {
                    return ((FlutterException) this.instance).getTypeBytes();
                }

                public Builder removeFrames(int i) {
                    copyOnWrite();
                    ((FlutterException) this.instance).removeFrames(i);
                    return this;
                }

                public Builder setDescription(String str) {
                    copyOnWrite();
                    ((FlutterException) this.instance).setDescription(str);
                    return this;
                }

                public Builder setDescriptionBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((FlutterException) this.instance).setDescriptionBytes(byteString);
                    return this;
                }

                public Builder setFrames(int i, Frame.Builder builder) {
                    copyOnWrite();
                    ((FlutterException) this.instance).setFrames(i, builder.build());
                    return this;
                }

                public Builder setType(String str) {
                    copyOnWrite();
                    ((FlutterException) this.instance).setType(str);
                    return this;
                }

                public Builder setTypeBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((FlutterException) this.instance).setTypeBytes(byteString);
                    return this;
                }

                public Builder addFrames(int i, Frame frame) {
                    copyOnWrite();
                    ((FlutterException) this.instance).addFrames(i, frame);
                    return this;
                }

                public Builder setFrames(int i, Frame frame) {
                    copyOnWrite();
                    ((FlutterException) this.instance).setFrames(i, frame);
                    return this;
                }

                public Builder addFrames(Frame.Builder builder) {
                    copyOnWrite();
                    ((FlutterException) this.instance).addFrames(builder.build());
                    return this;
                }

                public Builder addFrames(Frame frame) {
                    copyOnWrite();
                    ((FlutterException) this.instance).addFrames(frame);
                    return this;
                }
            }

            static {
                FlutterException flutterException = new FlutterException();
                DEFAULT_INSTANCE = flutterException;
                GeneratedMessageLite.registerDefaultInstance(FlutterException.class, flutterException);
            }

            private FlutterException() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllFrames(Iterable<? extends Frame> iterable) {
                ensureFramesIsMutable();
                AbstractMessageLite.addAll(iterable, this.frames_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addFrames(int i, Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.add(i, frame);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearDescription() {
                this.description_ = getDefaultInstance().getDescription();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFrames() {
                this.frames_ = GeneratedMessageLite.emptyProtobufList();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearType() {
                this.type_ = getDefaultInstance().getType();
            }

            private void ensureFramesIsMutable() {
                Internal.ProtobufList<Frame> protobufList = this.frames_;
                if (protobufList.isModifiable()) {
                    return;
                }
                this.frames_ = GeneratedMessageLite.mutableCopy(protobufList);
            }

            public static FlutterException getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static FlutterException parseDelimitedFrom(InputStream inputStream) {
                return (FlutterException) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static FlutterException parseFrom(ByteString byteString) {
                return (FlutterException) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<FlutterException> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void removeFrames(int i) {
                ensureFramesIsMutable();
                this.frames_.remove(i);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDescription(String str) {
                str.getClass();
                this.description_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDescriptionBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.description_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFrames(int i, Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.set(i, frame);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setType(String str) {
                str.getClass();
                this.type_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setTypeBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.type_ = byteString.toStringUtf8();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new FlutterException();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b", new Object[]{"type_", "description_", "frames_", Frame.class});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<FlutterException> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (FlutterException.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterExceptionOrBuilder
            public String getDescription() {
                return this.description_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterExceptionOrBuilder
            public ByteString getDescriptionBytes() {
                return ByteString.copyFromUtf8(this.description_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterExceptionOrBuilder
            public Frame getFrames(int i) {
                return this.frames_.get(i);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterExceptionOrBuilder
            public int getFramesCount() {
                return this.frames_.size();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterExceptionOrBuilder
            public List<Frame> getFramesList() {
                return this.frames_;
            }

            public FrameOrBuilder getFramesOrBuilder(int i) {
                return this.frames_.get(i);
            }

            public List<? extends FrameOrBuilder> getFramesOrBuilderList() {
                return this.frames_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterExceptionOrBuilder
            public String getType() {
                return this.type_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FlutterExceptionOrBuilder
            public ByteString getTypeBytes() {
                return ByteString.copyFromUtf8(this.type_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addFrames(Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.add(frame);
            }

            public static Builder newBuilder(FlutterException flutterException) {
                return DEFAULT_INSTANCE.createBuilder(flutterException);
            }

            public static FlutterException parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (FlutterException) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static FlutterException parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (FlutterException) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static FlutterException parseFrom(CodedInputStream codedInputStream) {
                return (FlutterException) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static FlutterException parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (FlutterException) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static FlutterException parseFrom(InputStream inputStream) {
                return (FlutterException) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static FlutterException parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (FlutterException) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static FlutterException parseFrom(ByteBuffer byteBuffer) {
                return (FlutterException) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static FlutterException parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (FlutterException) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static FlutterException parseFrom(byte[] bArr) {
                return (FlutterException) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static FlutterException parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (FlutterException) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface FlutterExceptionOrBuilder extends MessageLiteOrBuilder {
            String getDescription();

            ByteString getDescriptionBytes();

            Frame getFrames(int i);

            int getFramesCount();

            List<Frame> getFramesList();

            String getType();

            ByteString getTypeBytes();
        }

        public static final class Frame extends GeneratedMessageLite<Frame, Builder> implements FrameOrBuilder {
            public static final int CLASS_NAME_FIELD_NUMBER = 5;
            public static final int COLUMN_FIELD_NUMBER = 2;
            public static final int C_FRAME_TYPE_FIELD_NUMBER = 11;
            private static final Frame DEFAULT_INSTANCE;
            public static final int IS_CONSTRUCTOR_FIELD_NUMBER = 3;
            public static final int LINE_FIELD_NUMBER = 1;
            public static final int METHOD_FIELD_NUMBER = 4;
            public static final int NUMBER_FIELD_NUMBER = 10;
            public static final int PACKAGE_FIELD_NUMBER = 6;
            public static final int PACKAGE_PATH_FIELD_NUMBER = 7;
            public static final int PACKAGE_SCHEME_FIELD_NUMBER = 8;
            private static volatile Parser<Frame> PARSER = null;
            public static final int SOURCE_FIELD_NUMBER = 9;
            private int bitField0_;
            private int cFrameType_;
            private int column_;
            private boolean isConstructor_;
            private int line_;
            private int number_;
            private String method_ = "";
            private String className_ = "";
            private String package_ = "";
            private String packagePath_ = "";
            private String packageScheme_ = "";
            private String source_ = "";

            public static final class Builder extends GeneratedMessageLite.Builder<Frame, Builder> implements FrameOrBuilder {
                private Builder() {
                    super(Frame.DEFAULT_INSTANCE);
                }

                public Builder clearCFrameType() {
                    copyOnWrite();
                    ((Frame) this.instance).clearCFrameType();
                    return this;
                }

                public Builder clearClassName() {
                    copyOnWrite();
                    ((Frame) this.instance).clearClassName();
                    return this;
                }

                public Builder clearColumn() {
                    copyOnWrite();
                    ((Frame) this.instance).clearColumn();
                    return this;
                }

                public Builder clearIsConstructor() {
                    copyOnWrite();
                    ((Frame) this.instance).clearIsConstructor();
                    return this;
                }

                public Builder clearLine() {
                    copyOnWrite();
                    ((Frame) this.instance).clearLine();
                    return this;
                }

                public Builder clearMethod() {
                    copyOnWrite();
                    ((Frame) this.instance).clearMethod();
                    return this;
                }

                public Builder clearNumber() {
                    copyOnWrite();
                    ((Frame) this.instance).clearNumber();
                    return this;
                }

                public Builder clearPackage() {
                    copyOnWrite();
                    ((Frame) this.instance).clearPackage();
                    return this;
                }

                public Builder clearPackagePath() {
                    copyOnWrite();
                    ((Frame) this.instance).clearPackagePath();
                    return this;
                }

                public Builder clearPackageScheme() {
                    copyOnWrite();
                    ((Frame) this.instance).clearPackageScheme();
                    return this;
                }

                public Builder clearSource() {
                    copyOnWrite();
                    ((Frame) this.instance).clearSource();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
                public ModuleType getCFrameType() {
                    return ((Frame) this.instance).getCFrameType();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
                public int getCFrameTypeValue() {
                    return ((Frame) this.instance).getCFrameTypeValue();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
                public String getClassName() {
                    return ((Frame) this.instance).getClassName();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
                public ByteString getClassNameBytes() {
                    return ((Frame) this.instance).getClassNameBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
                public int getColumn() {
                    return ((Frame) this.instance).getColumn();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
                public boolean getIsConstructor() {
                    return ((Frame) this.instance).getIsConstructor();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
                public int getLine() {
                    return ((Frame) this.instance).getLine();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
                public String getMethod() {
                    return ((Frame) this.instance).getMethod();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
                public ByteString getMethodBytes() {
                    return ((Frame) this.instance).getMethodBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
                public int getNumber() {
                    return ((Frame) this.instance).getNumber();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
                public String getPackage() {
                    return ((Frame) this.instance).getPackage();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
                public ByteString getPackageBytes() {
                    return ((Frame) this.instance).getPackageBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
                public String getPackagePath() {
                    return ((Frame) this.instance).getPackagePath();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
                public ByteString getPackagePathBytes() {
                    return ((Frame) this.instance).getPackagePathBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
                public String getPackageScheme() {
                    return ((Frame) this.instance).getPackageScheme();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
                public ByteString getPackageSchemeBytes() {
                    return ((Frame) this.instance).getPackageSchemeBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
                public String getSource() {
                    return ((Frame) this.instance).getSource();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
                public ByteString getSourceBytes() {
                    return ((Frame) this.instance).getSourceBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
                public boolean hasCFrameType() {
                    return ((Frame) this.instance).hasCFrameType();
                }

                public Builder setCFrameType(ModuleType moduleType) {
                    copyOnWrite();
                    ((Frame) this.instance).setCFrameType(moduleType);
                    return this;
                }

                public Builder setCFrameTypeValue(int i) {
                    copyOnWrite();
                    ((Frame) this.instance).setCFrameTypeValue(i);
                    return this;
                }

                public Builder setClassName(String str) {
                    copyOnWrite();
                    ((Frame) this.instance).setClassName(str);
                    return this;
                }

                public Builder setClassNameBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((Frame) this.instance).setClassNameBytes(byteString);
                    return this;
                }

                public Builder setColumn(int i) {
                    copyOnWrite();
                    ((Frame) this.instance).setColumn(i);
                    return this;
                }

                public Builder setIsConstructor(boolean z) {
                    copyOnWrite();
                    ((Frame) this.instance).setIsConstructor(z);
                    return this;
                }

                public Builder setLine(int i) {
                    copyOnWrite();
                    ((Frame) this.instance).setLine(i);
                    return this;
                }

                public Builder setMethod(String str) {
                    copyOnWrite();
                    ((Frame) this.instance).setMethod(str);
                    return this;
                }

                public Builder setMethodBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((Frame) this.instance).setMethodBytes(byteString);
                    return this;
                }

                public Builder setNumber(int i) {
                    copyOnWrite();
                    ((Frame) this.instance).setNumber(i);
                    return this;
                }

                public Builder setPackage(String str) {
                    copyOnWrite();
                    ((Frame) this.instance).setPackage(str);
                    return this;
                }

                public Builder setPackageBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((Frame) this.instance).setPackageBytes(byteString);
                    return this;
                }

                public Builder setPackagePath(String str) {
                    copyOnWrite();
                    ((Frame) this.instance).setPackagePath(str);
                    return this;
                }

                public Builder setPackagePathBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((Frame) this.instance).setPackagePathBytes(byteString);
                    return this;
                }

                public Builder setPackageScheme(String str) {
                    copyOnWrite();
                    ((Frame) this.instance).setPackageScheme(str);
                    return this;
                }

                public Builder setPackageSchemeBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((Frame) this.instance).setPackageSchemeBytes(byteString);
                    return this;
                }

                public Builder setSource(String str) {
                    copyOnWrite();
                    ((Frame) this.instance).setSource(str);
                    return this;
                }

                public Builder setSourceBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((Frame) this.instance).setSourceBytes(byteString);
                    return this;
                }
            }

            static {
                Frame frame = new Frame();
                DEFAULT_INSTANCE = frame;
                GeneratedMessageLite.registerDefaultInstance(Frame.class, frame);
            }

            private Frame() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCFrameType() {
                this.bitField0_ &= -2;
                this.cFrameType_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearClassName() {
                this.className_ = getDefaultInstance().getClassName();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearColumn() {
                this.column_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearIsConstructor() {
                this.isConstructor_ = false;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLine() {
                this.line_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMethod() {
                this.method_ = getDefaultInstance().getMethod();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearNumber() {
                this.number_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPackage() {
                this.package_ = getDefaultInstance().getPackage();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPackagePath() {
                this.packagePath_ = getDefaultInstance().getPackagePath();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPackageScheme() {
                this.packageScheme_ = getDefaultInstance().getPackageScheme();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearSource() {
                this.source_ = getDefaultInstance().getSource();
            }

            public static Frame getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Frame parseDelimitedFrom(InputStream inputStream) {
                return (Frame) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Frame parseFrom(ByteString byteString) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<Frame> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCFrameType(ModuleType moduleType) {
                this.cFrameType_ = moduleType.getNumber();
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCFrameTypeValue(int i) {
                this.bitField0_ |= 1;
                this.cFrameType_ = i;
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
            public void setColumn(int i) {
                this.column_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setIsConstructor(boolean z) {
                this.isConstructor_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLine(int i) {
                this.line_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMethod(String str) {
                str.getClass();
                this.method_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMethodBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.method_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNumber(int i) {
                this.number_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPackage(String str) {
                str.getClass();
                this.package_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPackageBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.package_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPackagePath(String str) {
                str.getClass();
                this.packagePath_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPackagePathBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.packagePath_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPackageScheme(String str) {
                str.getClass();
                this.packageScheme_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPackageSchemeBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.packageScheme_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setSource(String str) {
                str.getClass();
                this.source_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setSourceBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.source_ = byteString.toStringUtf8();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new Frame();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001\u000b\u0002\u000b\u0003\u0007\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\tȈ\n\u000b\u000bဌ\u0000", new Object[]{"bitField0_", "line_", "column_", "isConstructor_", "method_", "className_", "package_", "packagePath_", "packageScheme_", "source_", "number_", "cFrameType_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Frame> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Frame.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
            public ModuleType getCFrameType() {
                ModuleType moduleTypeForNumber = ModuleType.forNumber(this.cFrameType_);
                return moduleTypeForNumber == null ? ModuleType.UNRECOGNIZED : moduleTypeForNumber;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
            public int getCFrameTypeValue() {
                return this.cFrameType_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
            public String getClassName() {
                return this.className_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
            public ByteString getClassNameBytes() {
                return ByteString.copyFromUtf8(this.className_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
            public int getColumn() {
                return this.column_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
            public boolean getIsConstructor() {
                return this.isConstructor_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
            public int getLine() {
                return this.line_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
            public String getMethod() {
                return this.method_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
            public ByteString getMethodBytes() {
                return ByteString.copyFromUtf8(this.method_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
            public int getNumber() {
                return this.number_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
            public String getPackage() {
                return this.package_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
            public ByteString getPackageBytes() {
                return ByteString.copyFromUtf8(this.package_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
            public String getPackagePath() {
                return this.packagePath_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
            public ByteString getPackagePathBytes() {
                return ByteString.copyFromUtf8(this.packagePath_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
            public String getPackageScheme() {
                return this.packageScheme_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
            public ByteString getPackageSchemeBytes() {
                return ByteString.copyFromUtf8(this.packageScheme_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
            public String getSource() {
                return this.source_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
            public ByteString getSourceBytes() {
                return ByteString.copyFromUtf8(this.source_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.FrameOrBuilder
            public boolean hasCFrameType() {
                return (this.bitField0_ & 1) != 0;
            }

            public static Builder newBuilder(Frame frame) {
                return DEFAULT_INSTANCE.createBuilder(frame);
            }

            public static Frame parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Frame parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Frame parseFrom(CodedInputStream codedInputStream) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Frame parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Frame parseFrom(InputStream inputStream) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Frame parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Frame parseFrom(ByteBuffer byteBuffer) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Frame parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Frame parseFrom(byte[] bArr) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Frame parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface FrameOrBuilder extends MessageLiteOrBuilder {
            ModuleType getCFrameType();

            int getCFrameTypeValue();

            String getClassName();

            ByteString getClassNameBytes();

            int getColumn();

            boolean getIsConstructor();

            int getLine();

            String getMethod();

            ByteString getMethodBytes();

            int getNumber();

            String getPackage();

            ByteString getPackageBytes();

            String getPackagePath();

            ByteString getPackagePathBytes();

            String getPackageScheme();

            ByteString getPackageSchemeBytes();

            String getSource();

            ByteString getSourceBytes();

            boolean hasCFrameType();
        }

        public static final class Thread extends GeneratedMessageLite<Thread, Builder> implements ThreadOrBuilder {
            private static final Thread DEFAULT_INSTANCE;
            public static final int FRAMES_FIELD_NUMBER = 1;
            private static volatile Parser<Thread> PARSER;
            private Internal.ProtobufList<Frame> frames_ = GeneratedMessageLite.emptyProtobufList();

            public static final class Builder extends GeneratedMessageLite.Builder<Thread, Builder> implements ThreadOrBuilder {
                private Builder() {
                    super(Thread.DEFAULT_INSTANCE);
                }

                public Builder addAllFrames(Iterable<? extends Frame> iterable) {
                    copyOnWrite();
                    ((Thread) this.instance).addAllFrames(iterable);
                    return this;
                }

                public Builder addFrames(int i, Frame.Builder builder) {
                    copyOnWrite();
                    ((Thread) this.instance).addFrames(i, builder.build());
                    return this;
                }

                public Builder clearFrames() {
                    copyOnWrite();
                    ((Thread) this.instance).clearFrames();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.ThreadOrBuilder
                public Frame getFrames(int i) {
                    return ((Thread) this.instance).getFrames(i);
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.ThreadOrBuilder
                public int getFramesCount() {
                    return ((Thread) this.instance).getFramesCount();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.ThreadOrBuilder
                public List<Frame> getFramesList() {
                    return Collections.unmodifiableList(((Thread) this.instance).getFramesList());
                }

                public Builder removeFrames(int i) {
                    copyOnWrite();
                    ((Thread) this.instance).removeFrames(i);
                    return this;
                }

                public Builder setFrames(int i, Frame.Builder builder) {
                    copyOnWrite();
                    ((Thread) this.instance).setFrames(i, builder.build());
                    return this;
                }

                public Builder addFrames(int i, Frame frame) {
                    copyOnWrite();
                    ((Thread) this.instance).addFrames(i, frame);
                    return this;
                }

                public Builder setFrames(int i, Frame frame) {
                    copyOnWrite();
                    ((Thread) this.instance).setFrames(i, frame);
                    return this;
                }

                public Builder addFrames(Frame.Builder builder) {
                    copyOnWrite();
                    ((Thread) this.instance).addFrames(builder.build());
                    return this;
                }

                public Builder addFrames(Frame frame) {
                    copyOnWrite();
                    ((Thread) this.instance).addFrames(frame);
                    return this;
                }
            }

            static {
                Thread thread = new Thread();
                DEFAULT_INSTANCE = thread;
                GeneratedMessageLite.registerDefaultInstance(Thread.class, thread);
            }

            private Thread() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllFrames(Iterable<? extends Frame> iterable) {
                ensureFramesIsMutable();
                AbstractMessageLite.addAll(iterable, this.frames_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addFrames(int i, Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.add(i, frame);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFrames() {
                this.frames_ = GeneratedMessageLite.emptyProtobufList();
            }

            private void ensureFramesIsMutable() {
                Internal.ProtobufList<Frame> protobufList = this.frames_;
                if (protobufList.isModifiable()) {
                    return;
                }
                this.frames_ = GeneratedMessageLite.mutableCopy(protobufList);
            }

            public static Thread getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Thread parseDelimitedFrom(InputStream inputStream) {
                return (Thread) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Thread parseFrom(ByteString byteString) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<Thread> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void removeFrames(int i) {
                ensureFramesIsMutable();
                this.frames_.remove(i);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFrames(int i, Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.set(i, frame);
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new Thread();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"frames_", Frame.class});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Thread> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Thread.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.ThreadOrBuilder
            public Frame getFrames(int i) {
                return this.frames_.get(i);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.ThreadOrBuilder
            public int getFramesCount() {
                return this.frames_.size();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReport.ThreadOrBuilder
            public List<Frame> getFramesList() {
                return this.frames_;
            }

            public FrameOrBuilder getFramesOrBuilder(int i) {
                return this.frames_.get(i);
            }

            public List<? extends FrameOrBuilder> getFramesOrBuilderList() {
                return this.frames_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addFrames(Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.add(frame);
            }

            public static Builder newBuilder(Thread thread) {
                return DEFAULT_INSTANCE.createBuilder(thread);
            }

            public static Thread parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Thread parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Thread parseFrom(CodedInputStream codedInputStream) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Thread parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Thread parseFrom(InputStream inputStream) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Thread parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Thread parseFrom(ByteBuffer byteBuffer) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Thread parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Thread parseFrom(byte[] bArr) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Thread parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface ThreadOrBuilder extends MessageLiteOrBuilder {
            Frame getFrames(int i);

            int getFramesCount();

            List<Frame> getFramesList();
        }

        static {
            FlutterThreadReport flutterThreadReport = new FlutterThreadReport();
            DEFAULT_INSTANCE = flutterThreadReport;
            GeneratedMessageLite.registerDefaultInstance(FlutterThreadReport.class, flutterThreadReport);
        }

        private FlutterThreadReport() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllThreads(Iterable<? extends Thread> iterable) {
            ensureThreadsIsMutable();
            AbstractMessageLite.addAll(iterable, this.threads_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addThreads(int i, Thread thread) {
            thread.getClass();
            ensureThreadsIsMutable();
            this.threads_.add(i, thread);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppInfo() {
            this.appInfo_ = null;
            this.bitField0_ &= -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearContext() {
            this.context_ = getDefaultInstance().getContext();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearException() {
            this.exception_ = null;
            this.bitField0_ &= -3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLibrary() {
            this.library_ = getDefaultInstance().getLibrary();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSummary() {
            this.summary_ = getDefaultInstance().getSummary();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearThreads() {
            this.threads_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimestamp() {
            this.timestamp_ = 0L;
        }

        private void ensureThreadsIsMutable() {
            Internal.ProtobufList<Thread> protobufList = this.threads_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.threads_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static FlutterThreadReport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAppInfo(FlutterAppInfo flutterAppInfo) {
            flutterAppInfo.getClass();
            FlutterAppInfo flutterAppInfo2 = this.appInfo_;
            if (flutterAppInfo2 != null && flutterAppInfo2 != FlutterAppInfo.getDefaultInstance()) {
                flutterAppInfo = FlutterAppInfo.newBuilder(this.appInfo_).mergeFrom((FlutterAppInfo.Builder) flutterAppInfo).buildPartial();
            }
            this.appInfo_ = flutterAppInfo;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeException(FlutterException flutterException) {
            flutterException.getClass();
            FlutterException flutterException2 = this.exception_;
            if (flutterException2 != null && flutterException2 != FlutterException.getDefaultInstance()) {
                flutterException = FlutterException.newBuilder(this.exception_).mergeFrom((FlutterException.Builder) flutterException).buildPartial();
            }
            this.exception_ = flutterException;
            this.bitField0_ |= 2;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static FlutterThreadReport parseDelimitedFrom(InputStream inputStream) {
            return (FlutterThreadReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FlutterThreadReport parseFrom(ByteString byteString) {
            return (FlutterThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<FlutterThreadReport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeThreads(int i) {
            ensureThreadsIsMutable();
            this.threads_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppInfo(FlutterAppInfo flutterAppInfo) {
            flutterAppInfo.getClass();
            this.appInfo_ = flutterAppInfo;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContext(String str) {
            str.getClass();
            this.context_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContextBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.context_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setException(FlutterException flutterException) {
            flutterException.getClass();
            this.exception_ = flutterException;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLibrary(String str) {
            str.getClass();
            this.library_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLibraryBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.library_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSummary(String str) {
            str.getClass();
            this.summary_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSummaryBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.summary_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setThreads(int i, Thread thread) {
            thread.getClass();
            ensureThreadsIsMutable();
            this.threads_.set(i, thread);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimestamp(long j) {
            this.timestamp_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new FlutterThreadReport();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007\u0003", new Object[]{"bitField0_", "appInfo_", "exception_", "threads_", Thread.class, "context_", "library_", "summary_", "timestamp_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FlutterThreadReport> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (FlutterThreadReport.class) {
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

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
        public FlutterAppInfo getAppInfo() {
            FlutterAppInfo flutterAppInfo = this.appInfo_;
            return flutterAppInfo == null ? FlutterAppInfo.getDefaultInstance() : flutterAppInfo;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
        public String getContext() {
            return this.context_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
        public ByteString getContextBytes() {
            return ByteString.copyFromUtf8(this.context_);
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
        public FlutterException getException() {
            FlutterException flutterException = this.exception_;
            return flutterException == null ? FlutterException.getDefaultInstance() : flutterException;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
        public String getLibrary() {
            return this.library_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
        public ByteString getLibraryBytes() {
            return ByteString.copyFromUtf8(this.library_);
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
        public String getSummary() {
            return this.summary_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
        public ByteString getSummaryBytes() {
            return ByteString.copyFromUtf8(this.summary_);
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
        public Thread getThreads(int i) {
            return this.threads_.get(i);
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
        public int getThreadsCount() {
            return this.threads_.size();
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
        public List<Thread> getThreadsList() {
            return this.threads_;
        }

        public ThreadOrBuilder getThreadsOrBuilder(int i) {
            return this.threads_.get(i);
        }

        public List<? extends ThreadOrBuilder> getThreadsOrBuilderList() {
            return this.threads_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
        public boolean hasAppInfo() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.FlutterThreadReportOrBuilder
        public boolean hasException() {
            return (this.bitField0_ & 2) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addThreads(Thread thread) {
            thread.getClass();
            ensureThreadsIsMutable();
            this.threads_.add(thread);
        }

        public static Builder newBuilder(FlutterThreadReport flutterThreadReport) {
            return DEFAULT_INSTANCE.createBuilder(flutterThreadReport);
        }

        public static FlutterThreadReport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FlutterThreadReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FlutterThreadReport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (FlutterThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FlutterThreadReport parseFrom(CodedInputStream codedInputStream) {
            return (FlutterThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FlutterThreadReport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FlutterThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static FlutterThreadReport parseFrom(InputStream inputStream) {
            return (FlutterThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FlutterThreadReport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FlutterThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FlutterThreadReport parseFrom(ByteBuffer byteBuffer) {
            return (FlutterThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static FlutterThreadReport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (FlutterThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static FlutterThreadReport parseFrom(byte[] bArr) {
            return (FlutterThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static FlutterThreadReport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (FlutterThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface FlutterThreadReportOrBuilder extends MessageLiteOrBuilder {
        FlutterThreadReport.FlutterAppInfo getAppInfo();

        String getContext();

        ByteString getContextBytes();

        FlutterThreadReport.FlutterException getException();

        String getLibrary();

        ByteString getLibraryBytes();

        String getSummary();

        ByteString getSummaryBytes();

        FlutterThreadReport.Thread getThreads(int i);

        int getThreadsCount();

        List<FlutterThreadReport.Thread> getThreadsList();

        long getTimestamp();

        boolean hasAppInfo();

        boolean hasException();
    }

    public static final class IOSThreadReport extends GeneratedMessageLite<IOSThreadReport, Builder> implements IOSThreadReportOrBuilder {
        public static final int APPLICATION_INFO_FIELD_NUMBER = 2;
        public static final int BINARIES_FIELD_NUMBER = 8;
        private static final IOSThreadReport DEFAULT_INSTANCE;
        public static final int LAST_EXCEPTION_BACKTRACE_FIELD_NUMBER = 6;
        public static final int MACHINE_INFO_FIELD_NUMBER = 5;
        private static volatile Parser<IOSThreadReport> PARSER = null;
        public static final int PROCESS_INFO_FIELD_NUMBER = 4;
        public static final int SIGNAL_FIELD_NUMBER = 3;
        public static final int SYSTEM_INFO_FIELD_NUMBER = 1;
        public static final int THREADS_FIELD_NUMBER = 7;
        private ApplicationInfo applicationInfo_;
        private int bitField0_;
        private Exception lastExceptionBacktrace_;
        private MachineInfo machineInfo_;
        private ProcessInfo processInfo_;
        private Signal signal_;
        private SystemInfo systemInfo_;
        private MapFieldLite<Integer, Binary> binaries_ = MapFieldLite.emptyMapField();
        private Internal.ProtobufList<Thread> threads_ = GeneratedMessageLite.emptyProtobufList();

        public static final class ApplicationInfo extends GeneratedMessageLite<ApplicationInfo, Builder> implements ApplicationInfoOrBuilder {
            private static final ApplicationInfo DEFAULT_INSTANCE;
            public static final int IDENTIFIER_FIELD_NUMBER = 1;
            public static final int MARKETING_VERSION_FIELD_NUMBER = 3;
            private static volatile Parser<ApplicationInfo> PARSER = null;
            public static final int VERSION_FIELD_NUMBER = 2;
            private int bitField0_;
            private String identifier_ = "";
            private String version_ = "";
            private String marketingVersion_ = "";

            public static final class Builder extends GeneratedMessageLite.Builder<ApplicationInfo, Builder> implements ApplicationInfoOrBuilder {
                private Builder() {
                    super(ApplicationInfo.DEFAULT_INSTANCE);
                }

                public Builder clearIdentifier() {
                    copyOnWrite();
                    ((ApplicationInfo) this.instance).clearIdentifier();
                    return this;
                }

                public Builder clearMarketingVersion() {
                    copyOnWrite();
                    ((ApplicationInfo) this.instance).clearMarketingVersion();
                    return this;
                }

                public Builder clearVersion() {
                    copyOnWrite();
                    ((ApplicationInfo) this.instance).clearVersion();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ApplicationInfoOrBuilder
                public String getIdentifier() {
                    return ((ApplicationInfo) this.instance).getIdentifier();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ApplicationInfoOrBuilder
                public ByteString getIdentifierBytes() {
                    return ((ApplicationInfo) this.instance).getIdentifierBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ApplicationInfoOrBuilder
                public String getMarketingVersion() {
                    return ((ApplicationInfo) this.instance).getMarketingVersion();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ApplicationInfoOrBuilder
                public ByteString getMarketingVersionBytes() {
                    return ((ApplicationInfo) this.instance).getMarketingVersionBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ApplicationInfoOrBuilder
                public String getVersion() {
                    return ((ApplicationInfo) this.instance).getVersion();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ApplicationInfoOrBuilder
                public ByteString getVersionBytes() {
                    return ((ApplicationInfo) this.instance).getVersionBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ApplicationInfoOrBuilder
                public boolean hasMarketingVersion() {
                    return ((ApplicationInfo) this.instance).hasMarketingVersion();
                }

                public Builder setIdentifier(String str) {
                    copyOnWrite();
                    ((ApplicationInfo) this.instance).setIdentifier(str);
                    return this;
                }

                public Builder setIdentifierBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((ApplicationInfo) this.instance).setIdentifierBytes(byteString);
                    return this;
                }

                public Builder setMarketingVersion(String str) {
                    copyOnWrite();
                    ((ApplicationInfo) this.instance).setMarketingVersion(str);
                    return this;
                }

                public Builder setMarketingVersionBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((ApplicationInfo) this.instance).setMarketingVersionBytes(byteString);
                    return this;
                }

                public Builder setVersion(String str) {
                    copyOnWrite();
                    ((ApplicationInfo) this.instance).setVersion(str);
                    return this;
                }

                public Builder setVersionBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((ApplicationInfo) this.instance).setVersionBytes(byteString);
                    return this;
                }
            }

            static {
                ApplicationInfo applicationInfo = new ApplicationInfo();
                DEFAULT_INSTANCE = applicationInfo;
                GeneratedMessageLite.registerDefaultInstance(ApplicationInfo.class, applicationInfo);
            }

            private ApplicationInfo() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearIdentifier() {
                this.identifier_ = getDefaultInstance().getIdentifier();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMarketingVersion() {
                this.bitField0_ &= -2;
                this.marketingVersion_ = getDefaultInstance().getMarketingVersion();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearVersion() {
                this.version_ = getDefaultInstance().getVersion();
            }

            public static ApplicationInfo getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static ApplicationInfo parseDelimitedFrom(InputStream inputStream) {
                return (ApplicationInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ApplicationInfo parseFrom(ByteString byteString) {
                return (ApplicationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<ApplicationInfo> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setIdentifier(String str) {
                str.getClass();
                this.identifier_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setIdentifierBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.identifier_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMarketingVersion(String str) {
                str.getClass();
                this.bitField0_ |= 1;
                this.marketingVersion_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMarketingVersionBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.marketingVersion_ = byteString.toStringUtf8();
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVersion(String str) {
                str.getClass();
                this.version_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVersionBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.version_ = byteString.toStringUtf8();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new ApplicationInfo();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003ለ\u0000", new Object[]{"bitField0_", "identifier_", "version_", "marketingVersion_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ApplicationInfo> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (ApplicationInfo.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ApplicationInfoOrBuilder
            public String getIdentifier() {
                return this.identifier_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ApplicationInfoOrBuilder
            public ByteString getIdentifierBytes() {
                return ByteString.copyFromUtf8(this.identifier_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ApplicationInfoOrBuilder
            public String getMarketingVersion() {
                return this.marketingVersion_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ApplicationInfoOrBuilder
            public ByteString getMarketingVersionBytes() {
                return ByteString.copyFromUtf8(this.marketingVersion_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ApplicationInfoOrBuilder
            public String getVersion() {
                return this.version_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ApplicationInfoOrBuilder
            public ByteString getVersionBytes() {
                return ByteString.copyFromUtf8(this.version_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ApplicationInfoOrBuilder
            public boolean hasMarketingVersion() {
                return (this.bitField0_ & 1) != 0;
            }

            public static Builder newBuilder(ApplicationInfo applicationInfo) {
                return DEFAULT_INSTANCE.createBuilder(applicationInfo);
            }

            public static ApplicationInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (ApplicationInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ApplicationInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (ApplicationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ApplicationInfo parseFrom(CodedInputStream codedInputStream) {
                return (ApplicationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ApplicationInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (ApplicationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static ApplicationInfo parseFrom(InputStream inputStream) {
                return (ApplicationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ApplicationInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (ApplicationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ApplicationInfo parseFrom(ByteBuffer byteBuffer) {
                return (ApplicationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static ApplicationInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (ApplicationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static ApplicationInfo parseFrom(byte[] bArr) {
                return (ApplicationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static ApplicationInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (ApplicationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface ApplicationInfoOrBuilder extends MessageLiteOrBuilder {
            String getIdentifier();

            ByteString getIdentifierBytes();

            String getMarketingVersion();

            ByteString getMarketingVersionBytes();

            String getVersion();

            ByteString getVersionBytes();

            boolean hasMarketingVersion();
        }

        public enum Architecture implements Internal.EnumLite {
            ARCHITECTURE_UNSPECIFIED(0),
            ARCHITECTURE_ARM64(1),
            ARCHITECTURE_ARM64E(2),
            ARCHITECTURE_ARMV8(3),
            ARCHITECTURE_X86_64(4),
            ARCHITECTURE_X86(5),
            UNRECOGNIZED(-1);

            public static final int ARCHITECTURE_ARM64E_VALUE = 2;
            public static final int ARCHITECTURE_ARM64_VALUE = 1;
            public static final int ARCHITECTURE_ARMV8_VALUE = 3;
            public static final int ARCHITECTURE_UNSPECIFIED_VALUE = 0;
            public static final int ARCHITECTURE_X86_64_VALUE = 4;
            public static final int ARCHITECTURE_X86_VALUE = 5;
            private static final Internal.EnumLiteMap<Architecture> internalValueMap = new Internal.EnumLiteMap<Architecture>() { // from class: com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Architecture.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Architecture findValueByNumber(int i) {
                    return Architecture.forNumber(i);
                }
            };
            private final int value;

            public static final class ArchitectureVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new ArchitectureVerifier();

                private ArchitectureVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return Architecture.forNumber(i) != null;
                }
            }

            Architecture(int i) {
                this.value = i;
            }

            public static Architecture forNumber(int i) {
                if (i == 0) {
                    return ARCHITECTURE_UNSPECIFIED;
                }
                if (i == 1) {
                    return ARCHITECTURE_ARM64;
                }
                if (i == 2) {
                    return ARCHITECTURE_ARM64E;
                }
                if (i == 3) {
                    return ARCHITECTURE_ARMV8;
                }
                if (i == 4) {
                    return ARCHITECTURE_X86_64;
                }
                if (i != 5) {
                    return null;
                }
                return ARCHITECTURE_X86;
            }

            public static Internal.EnumLiteMap<Architecture> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return ArchitectureVerifier.INSTANCE;
            }

            @Deprecated
            public static Architecture valueOf(int i) {
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

        public static final class BinariesDefaultEntryHolder {
            static final MapEntryLite<Integer, Binary> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, Binary.getDefaultInstance());

            private BinariesDefaultEntryHolder() {
            }
        }

        public static final class Binary extends GeneratedMessageLite<Binary, Builder> implements BinaryOrBuilder {
            public static final int BASE_ADDRESS_FIELD_NUMBER = 2;
            public static final int CODE_TYPE_FIELD_NUMBER = 6;
            public static final int C_ARCHITECTURE_FIELD_NUMBER = 8;
            public static final int C_TYPE_FIELD_NUMBER = 7;
            private static final Binary DEFAULT_INSTANCE;
            public static final int ID_FIELD_NUMBER = 1;
            public static final int NAME_FIELD_NUMBER = 5;
            private static volatile Parser<Binary> PARSER = null;
            public static final int SIZE_FIELD_NUMBER = 3;
            public static final int UUID_FIELD_NUMBER = 4;
            private long baseAddress_;
            private int bitField0_;
            private int cArchitecture_;
            private int cType_;
            private Processor codeType_;
            private int id_;
            private long size_;
            private ByteString uuid_ = ByteString.EMPTY;
            private String name_ = "";

            public static final class Builder extends GeneratedMessageLite.Builder<Binary, Builder> implements BinaryOrBuilder {
                private Builder() {
                    super(Binary.DEFAULT_INSTANCE);
                }

                public Builder clearBaseAddress() {
                    copyOnWrite();
                    ((Binary) this.instance).clearBaseAddress();
                    return this;
                }

                public Builder clearCArchitecture() {
                    copyOnWrite();
                    ((Binary) this.instance).clearCArchitecture();
                    return this;
                }

                public Builder clearCType() {
                    copyOnWrite();
                    ((Binary) this.instance).clearCType();
                    return this;
                }

                public Builder clearCodeType() {
                    copyOnWrite();
                    ((Binary) this.instance).clearCodeType();
                    return this;
                }

                public Builder clearId() {
                    copyOnWrite();
                    ((Binary) this.instance).clearId();
                    return this;
                }

                public Builder clearName() {
                    copyOnWrite();
                    ((Binary) this.instance).clearName();
                    return this;
                }

                public Builder clearSize() {
                    copyOnWrite();
                    ((Binary) this.instance).clearSize();
                    return this;
                }

                public Builder clearUuid() {
                    copyOnWrite();
                    ((Binary) this.instance).clearUuid();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
                public long getBaseAddress() {
                    return ((Binary) this.instance).getBaseAddress();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
                public Architecture getCArchitecture() {
                    return ((Binary) this.instance).getCArchitecture();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
                public int getCArchitectureValue() {
                    return ((Binary) this.instance).getCArchitectureValue();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
                public ModuleType getCType() {
                    return ((Binary) this.instance).getCType();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
                public int getCTypeValue() {
                    return ((Binary) this.instance).getCTypeValue();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
                public Processor getCodeType() {
                    return ((Binary) this.instance).getCodeType();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
                public int getId() {
                    return ((Binary) this.instance).getId();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
                public String getName() {
                    return ((Binary) this.instance).getName();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
                public ByteString getNameBytes() {
                    return ((Binary) this.instance).getNameBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
                public long getSize() {
                    return ((Binary) this.instance).getSize();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
                public ByteString getUuid() {
                    return ((Binary) this.instance).getUuid();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
                public boolean hasCodeType() {
                    return ((Binary) this.instance).hasCodeType();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
                public boolean hasUuid() {
                    return ((Binary) this.instance).hasUuid();
                }

                public Builder mergeCodeType(Processor processor) {
                    copyOnWrite();
                    ((Binary) this.instance).mergeCodeType(processor);
                    return this;
                }

                public Builder setBaseAddress(long j) {
                    copyOnWrite();
                    ((Binary) this.instance).setBaseAddress(j);
                    return this;
                }

                public Builder setCArchitecture(Architecture architecture) {
                    copyOnWrite();
                    ((Binary) this.instance).setCArchitecture(architecture);
                    return this;
                }

                public Builder setCArchitectureValue(int i) {
                    copyOnWrite();
                    ((Binary) this.instance).setCArchitectureValue(i);
                    return this;
                }

                public Builder setCType(ModuleType moduleType) {
                    copyOnWrite();
                    ((Binary) this.instance).setCType(moduleType);
                    return this;
                }

                public Builder setCTypeValue(int i) {
                    copyOnWrite();
                    ((Binary) this.instance).setCTypeValue(i);
                    return this;
                }

                public Builder setCodeType(Processor.Builder builder) {
                    copyOnWrite();
                    ((Binary) this.instance).setCodeType(builder.build());
                    return this;
                }

                public Builder setId(int i) {
                    copyOnWrite();
                    ((Binary) this.instance).setId(i);
                    return this;
                }

                public Builder setName(String str) {
                    copyOnWrite();
                    ((Binary) this.instance).setName(str);
                    return this;
                }

                public Builder setNameBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((Binary) this.instance).setNameBytes(byteString);
                    return this;
                }

                public Builder setSize(long j) {
                    copyOnWrite();
                    ((Binary) this.instance).setSize(j);
                    return this;
                }

                public Builder setUuid(ByteString byteString) {
                    copyOnWrite();
                    ((Binary) this.instance).setUuid(byteString);
                    return this;
                }

                public Builder setCodeType(Processor processor) {
                    copyOnWrite();
                    ((Binary) this.instance).setCodeType(processor);
                    return this;
                }
            }

            static {
                Binary binary = new Binary();
                DEFAULT_INSTANCE = binary;
                GeneratedMessageLite.registerDefaultInstance(Binary.class, binary);
            }

            private Binary() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearBaseAddress() {
                this.baseAddress_ = 0L;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCArchitecture() {
                this.cArchitecture_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCType() {
                this.cType_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCodeType() {
                this.codeType_ = null;
                this.bitField0_ &= -3;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearId() {
                this.id_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearName() {
                this.name_ = getDefaultInstance().getName();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearSize() {
                this.size_ = 0L;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearUuid() {
                this.bitField0_ &= -2;
                this.uuid_ = getDefaultInstance().getUuid();
            }

            public static Binary getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeCodeType(Processor processor) {
                processor.getClass();
                Processor processor2 = this.codeType_;
                if (processor2 != null && processor2 != Processor.getDefaultInstance()) {
                    processor = Processor.newBuilder(this.codeType_).mergeFrom((Processor.Builder) processor).buildPartial();
                }
                this.codeType_ = processor;
                this.bitField0_ |= 2;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Binary parseDelimitedFrom(InputStream inputStream) {
                return (Binary) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Binary parseFrom(ByteString byteString) {
                return (Binary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<Binary> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBaseAddress(long j) {
                this.baseAddress_ = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCArchitecture(Architecture architecture) {
                this.cArchitecture_ = architecture.getNumber();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCArchitectureValue(int i) {
                this.cArchitecture_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCType(ModuleType moduleType) {
                this.cType_ = moduleType.getNumber();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCTypeValue(int i) {
                this.cType_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCodeType(Processor processor) {
                processor.getClass();
                this.codeType_ = processor;
                this.bitField0_ |= 2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setId(int i) {
                this.id_ = i;
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
            public void setSize(long j) {
                this.size_ = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUuid(ByteString byteString) {
                byteString.getClass();
                this.bitField0_ |= 1;
                this.uuid_ = byteString;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new Binary();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u000b\u0002\u0003\u0003\u0003\u0004ည\u0000\u0005Ȉ\u0006ဉ\u0001\u0007\f\b\f", new Object[]{"bitField0_", "id_", "baseAddress_", "size_", "uuid_", "name_", "codeType_", "cType_", "cArchitecture_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Binary> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Binary.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
            public long getBaseAddress() {
                return this.baseAddress_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
            public Architecture getCArchitecture() {
                Architecture architectureForNumber = Architecture.forNumber(this.cArchitecture_);
                return architectureForNumber == null ? Architecture.UNRECOGNIZED : architectureForNumber;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
            public int getCArchitectureValue() {
                return this.cArchitecture_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
            public ModuleType getCType() {
                ModuleType moduleTypeForNumber = ModuleType.forNumber(this.cType_);
                return moduleTypeForNumber == null ? ModuleType.UNRECOGNIZED : moduleTypeForNumber;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
            public int getCTypeValue() {
                return this.cType_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
            public Processor getCodeType() {
                Processor processor = this.codeType_;
                return processor == null ? Processor.getDefaultInstance() : processor;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
            public int getId() {
                return this.id_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
            public String getName() {
                return this.name_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
            public ByteString getNameBytes() {
                return ByteString.copyFromUtf8(this.name_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
            public long getSize() {
                return this.size_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
            public ByteString getUuid() {
                return this.uuid_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
            public boolean hasCodeType() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.BinaryOrBuilder
            public boolean hasUuid() {
                return (this.bitField0_ & 1) != 0;
            }

            public static Builder newBuilder(Binary binary) {
                return DEFAULT_INSTANCE.createBuilder(binary);
            }

            public static Binary parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Binary) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Binary parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (Binary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Binary parseFrom(CodedInputStream codedInputStream) {
                return (Binary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Binary parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Binary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Binary parseFrom(InputStream inputStream) {
                return (Binary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Binary parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Binary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Binary parseFrom(ByteBuffer byteBuffer) {
                return (Binary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Binary parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (Binary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Binary parseFrom(byte[] bArr) {
                return (Binary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Binary parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (Binary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface BinaryOrBuilder extends MessageLiteOrBuilder {
            long getBaseAddress();

            Architecture getCArchitecture();

            int getCArchitectureValue();

            ModuleType getCType();

            int getCTypeValue();

            Processor getCodeType();

            int getId();

            String getName();

            ByteString getNameBytes();

            long getSize();

            ByteString getUuid();

            boolean hasCodeType();

            boolean hasUuid();
        }

        public static final class Builder extends GeneratedMessageLite.Builder<IOSThreadReport, Builder> implements IOSThreadReportOrBuilder {
            private Builder() {
                super(IOSThreadReport.DEFAULT_INSTANCE);
            }

            public Builder addAllThreads(Iterable<? extends Thread> iterable) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).addAllThreads(iterable);
                return this;
            }

            public Builder addThreads(int i, Thread.Builder builder) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).addThreads(i, builder.build());
                return this;
            }

            public Builder clearApplicationInfo() {
                copyOnWrite();
                ((IOSThreadReport) this.instance).clearApplicationInfo();
                return this;
            }

            public Builder clearBinaries() {
                copyOnWrite();
                ((IOSThreadReport) this.instance).getMutableBinariesMap().clear();
                return this;
            }

            public Builder clearLastExceptionBacktrace() {
                copyOnWrite();
                ((IOSThreadReport) this.instance).clearLastExceptionBacktrace();
                return this;
            }

            public Builder clearMachineInfo() {
                copyOnWrite();
                ((IOSThreadReport) this.instance).clearMachineInfo();
                return this;
            }

            public Builder clearProcessInfo() {
                copyOnWrite();
                ((IOSThreadReport) this.instance).clearProcessInfo();
                return this;
            }

            public Builder clearSignal() {
                copyOnWrite();
                ((IOSThreadReport) this.instance).clearSignal();
                return this;
            }

            public Builder clearSystemInfo() {
                copyOnWrite();
                ((IOSThreadReport) this.instance).clearSystemInfo();
                return this;
            }

            public Builder clearThreads() {
                copyOnWrite();
                ((IOSThreadReport) this.instance).clearThreads();
                return this;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
            public boolean containsBinaries(int i) {
                return ((IOSThreadReport) this.instance).getBinariesMap().containsKey(Integer.valueOf(i));
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
            public ApplicationInfo getApplicationInfo() {
                return ((IOSThreadReport) this.instance).getApplicationInfo();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
            @Deprecated
            public Map<Integer, Binary> getBinaries() {
                return getBinariesMap();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
            public int getBinariesCount() {
                return ((IOSThreadReport) this.instance).getBinariesMap().size();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
            public Map<Integer, Binary> getBinariesMap() {
                return Collections.unmodifiableMap(((IOSThreadReport) this.instance).getBinariesMap());
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
            public Binary getBinariesOrDefault(int i, Binary binary) {
                Map<Integer, Binary> binariesMap = ((IOSThreadReport) this.instance).getBinariesMap();
                return binariesMap.containsKey(Integer.valueOf(i)) ? binariesMap.get(Integer.valueOf(i)) : binary;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
            public Binary getBinariesOrThrow(int i) {
                Map<Integer, Binary> binariesMap = ((IOSThreadReport) this.instance).getBinariesMap();
                if (binariesMap.containsKey(Integer.valueOf(i))) {
                    return binariesMap.get(Integer.valueOf(i));
                }
                throw new IllegalArgumentException();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
            public Exception getLastExceptionBacktrace() {
                return ((IOSThreadReport) this.instance).getLastExceptionBacktrace();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
            public MachineInfo getMachineInfo() {
                return ((IOSThreadReport) this.instance).getMachineInfo();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
            public ProcessInfo getProcessInfo() {
                return ((IOSThreadReport) this.instance).getProcessInfo();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
            public Signal getSignal() {
                return ((IOSThreadReport) this.instance).getSignal();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
            public SystemInfo getSystemInfo() {
                return ((IOSThreadReport) this.instance).getSystemInfo();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
            public Thread getThreads(int i) {
                return ((IOSThreadReport) this.instance).getThreads(i);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
            public int getThreadsCount() {
                return ((IOSThreadReport) this.instance).getThreadsCount();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
            public List<Thread> getThreadsList() {
                return Collections.unmodifiableList(((IOSThreadReport) this.instance).getThreadsList());
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
            public boolean hasApplicationInfo() {
                return ((IOSThreadReport) this.instance).hasApplicationInfo();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
            public boolean hasLastExceptionBacktrace() {
                return ((IOSThreadReport) this.instance).hasLastExceptionBacktrace();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
            public boolean hasMachineInfo() {
                return ((IOSThreadReport) this.instance).hasMachineInfo();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
            public boolean hasProcessInfo() {
                return ((IOSThreadReport) this.instance).hasProcessInfo();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
            public boolean hasSignal() {
                return ((IOSThreadReport) this.instance).hasSignal();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
            public boolean hasSystemInfo() {
                return ((IOSThreadReport) this.instance).hasSystemInfo();
            }

            public Builder mergeApplicationInfo(ApplicationInfo applicationInfo) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).mergeApplicationInfo(applicationInfo);
                return this;
            }

            public Builder mergeLastExceptionBacktrace(Exception exception) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).mergeLastExceptionBacktrace(exception);
                return this;
            }

            public Builder mergeMachineInfo(MachineInfo machineInfo) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).mergeMachineInfo(machineInfo);
                return this;
            }

            public Builder mergeProcessInfo(ProcessInfo processInfo) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).mergeProcessInfo(processInfo);
                return this;
            }

            public Builder mergeSignal(Signal signal) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).mergeSignal(signal);
                return this;
            }

            public Builder mergeSystemInfo(SystemInfo systemInfo) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).mergeSystemInfo(systemInfo);
                return this;
            }

            public Builder putAllBinaries(Map<Integer, Binary> map) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).getMutableBinariesMap().putAll(map);
                return this;
            }

            public Builder putBinaries(int i, Binary binary) {
                binary.getClass();
                copyOnWrite();
                ((IOSThreadReport) this.instance).getMutableBinariesMap().put(Integer.valueOf(i), binary);
                return this;
            }

            public Builder removeBinaries(int i) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).getMutableBinariesMap().remove(Integer.valueOf(i));
                return this;
            }

            public Builder removeThreads(int i) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).removeThreads(i);
                return this;
            }

            public Builder setApplicationInfo(ApplicationInfo.Builder builder) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).setApplicationInfo(builder.build());
                return this;
            }

            public Builder setLastExceptionBacktrace(Exception.Builder builder) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).setLastExceptionBacktrace(builder.build());
                return this;
            }

            public Builder setMachineInfo(MachineInfo.Builder builder) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).setMachineInfo(builder.build());
                return this;
            }

            public Builder setProcessInfo(ProcessInfo.Builder builder) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).setProcessInfo(builder.build());
                return this;
            }

            public Builder setSignal(Signal.Builder builder) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).setSignal(builder.build());
                return this;
            }

            public Builder setSystemInfo(SystemInfo.Builder builder) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).setSystemInfo(builder.build());
                return this;
            }

            public Builder setThreads(int i, Thread.Builder builder) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).setThreads(i, builder.build());
                return this;
            }

            public Builder addThreads(int i, Thread thread) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).addThreads(i, thread);
                return this;
            }

            public Builder setApplicationInfo(ApplicationInfo applicationInfo) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).setApplicationInfo(applicationInfo);
                return this;
            }

            public Builder setLastExceptionBacktrace(Exception exception) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).setLastExceptionBacktrace(exception);
                return this;
            }

            public Builder setMachineInfo(MachineInfo machineInfo) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).setMachineInfo(machineInfo);
                return this;
            }

            public Builder setProcessInfo(ProcessInfo processInfo) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).setProcessInfo(processInfo);
                return this;
            }

            public Builder setSignal(Signal signal) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).setSignal(signal);
                return this;
            }

            public Builder setSystemInfo(SystemInfo systemInfo) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).setSystemInfo(systemInfo);
                return this;
            }

            public Builder setThreads(int i, Thread thread) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).setThreads(i, thread);
                return this;
            }

            public Builder addThreads(Thread.Builder builder) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).addThreads(builder.build());
                return this;
            }

            public Builder addThreads(Thread thread) {
                copyOnWrite();
                ((IOSThreadReport) this.instance).addThreads(thread);
                return this;
            }
        }

        public static final class Exception extends GeneratedMessageLite<Exception, Builder> implements ExceptionOrBuilder {
            private static final Exception DEFAULT_INSTANCE;
            public static final int FRAMES_FIELD_NUMBER = 3;
            public static final int NAME_FIELD_NUMBER = 1;
            private static volatile Parser<Exception> PARSER = null;
            public static final int REASON_FIELD_NUMBER = 2;
            private String name_ = "";
            private String reason_ = "";
            private Internal.ProtobufList<Frame> frames_ = GeneratedMessageLite.emptyProtobufList();

            public static final class Builder extends GeneratedMessageLite.Builder<Exception, Builder> implements ExceptionOrBuilder {
                private Builder() {
                    super(Exception.DEFAULT_INSTANCE);
                }

                public Builder addAllFrames(Iterable<? extends Frame> iterable) {
                    copyOnWrite();
                    ((Exception) this.instance).addAllFrames(iterable);
                    return this;
                }

                public Builder addFrames(int i, Frame.Builder builder) {
                    copyOnWrite();
                    ((Exception) this.instance).addFrames(i, builder.build());
                    return this;
                }

                public Builder clearFrames() {
                    copyOnWrite();
                    ((Exception) this.instance).clearFrames();
                    return this;
                }

                public Builder clearName() {
                    copyOnWrite();
                    ((Exception) this.instance).clearName();
                    return this;
                }

                public Builder clearReason() {
                    copyOnWrite();
                    ((Exception) this.instance).clearReason();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ExceptionOrBuilder
                public Frame getFrames(int i) {
                    return ((Exception) this.instance).getFrames(i);
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ExceptionOrBuilder
                public int getFramesCount() {
                    return ((Exception) this.instance).getFramesCount();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ExceptionOrBuilder
                public List<Frame> getFramesList() {
                    return Collections.unmodifiableList(((Exception) this.instance).getFramesList());
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ExceptionOrBuilder
                public String getName() {
                    return ((Exception) this.instance).getName();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ExceptionOrBuilder
                public ByteString getNameBytes() {
                    return ((Exception) this.instance).getNameBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ExceptionOrBuilder
                public String getReason() {
                    return ((Exception) this.instance).getReason();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ExceptionOrBuilder
                public ByteString getReasonBytes() {
                    return ((Exception) this.instance).getReasonBytes();
                }

                public Builder removeFrames(int i) {
                    copyOnWrite();
                    ((Exception) this.instance).removeFrames(i);
                    return this;
                }

                public Builder setFrames(int i, Frame.Builder builder) {
                    copyOnWrite();
                    ((Exception) this.instance).setFrames(i, builder.build());
                    return this;
                }

                public Builder setName(String str) {
                    copyOnWrite();
                    ((Exception) this.instance).setName(str);
                    return this;
                }

                public Builder setNameBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((Exception) this.instance).setNameBytes(byteString);
                    return this;
                }

                public Builder setReason(String str) {
                    copyOnWrite();
                    ((Exception) this.instance).setReason(str);
                    return this;
                }

                public Builder setReasonBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((Exception) this.instance).setReasonBytes(byteString);
                    return this;
                }

                public Builder addFrames(int i, Frame frame) {
                    copyOnWrite();
                    ((Exception) this.instance).addFrames(i, frame);
                    return this;
                }

                public Builder setFrames(int i, Frame frame) {
                    copyOnWrite();
                    ((Exception) this.instance).setFrames(i, frame);
                    return this;
                }

                public Builder addFrames(Frame.Builder builder) {
                    copyOnWrite();
                    ((Exception) this.instance).addFrames(builder.build());
                    return this;
                }

                public Builder addFrames(Frame frame) {
                    copyOnWrite();
                    ((Exception) this.instance).addFrames(frame);
                    return this;
                }
            }

            static {
                Exception exception = new Exception();
                DEFAULT_INSTANCE = exception;
                GeneratedMessageLite.registerDefaultInstance(Exception.class, exception);
            }

            private Exception() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllFrames(Iterable<? extends Frame> iterable) {
                ensureFramesIsMutable();
                AbstractMessageLite.addAll(iterable, this.frames_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addFrames(int i, Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.add(i, frame);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFrames() {
                this.frames_ = GeneratedMessageLite.emptyProtobufList();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearName() {
                this.name_ = getDefaultInstance().getName();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearReason() {
                this.reason_ = getDefaultInstance().getReason();
            }

            private void ensureFramesIsMutable() {
                Internal.ProtobufList<Frame> protobufList = this.frames_;
                if (protobufList.isModifiable()) {
                    return;
                }
                this.frames_ = GeneratedMessageLite.mutableCopy(protobufList);
            }

            public static Exception getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Exception parseDelimitedFrom(InputStream inputStream) {
                return (Exception) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Exception parseFrom(ByteString byteString) {
                return (Exception) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<Exception> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void removeFrames(int i) {
                ensureFramesIsMutable();
                this.frames_.remove(i);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFrames(int i, Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.set(i, frame);
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
            public void setReason(String str) {
                str.getClass();
                this.reason_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setReasonBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.reason_ = byteString.toStringUtf8();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new Exception();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b", new Object[]{"name_", "reason_", "frames_", Frame.class});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Exception> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Exception.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ExceptionOrBuilder
            public Frame getFrames(int i) {
                return this.frames_.get(i);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ExceptionOrBuilder
            public int getFramesCount() {
                return this.frames_.size();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ExceptionOrBuilder
            public List<Frame> getFramesList() {
                return this.frames_;
            }

            public FrameOrBuilder getFramesOrBuilder(int i) {
                return this.frames_.get(i);
            }

            public List<? extends FrameOrBuilder> getFramesOrBuilderList() {
                return this.frames_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ExceptionOrBuilder
            public String getName() {
                return this.name_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ExceptionOrBuilder
            public ByteString getNameBytes() {
                return ByteString.copyFromUtf8(this.name_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ExceptionOrBuilder
            public String getReason() {
                return this.reason_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ExceptionOrBuilder
            public ByteString getReasonBytes() {
                return ByteString.copyFromUtf8(this.reason_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addFrames(Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.add(frame);
            }

            public static Builder newBuilder(Exception exception) {
                return DEFAULT_INSTANCE.createBuilder(exception);
            }

            public static Exception parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Exception) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Exception parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (Exception) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Exception parseFrom(CodedInputStream codedInputStream) {
                return (Exception) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Exception parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Exception) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Exception parseFrom(InputStream inputStream) {
                return (Exception) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Exception parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Exception) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Exception parseFrom(ByteBuffer byteBuffer) {
                return (Exception) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Exception parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (Exception) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Exception parseFrom(byte[] bArr) {
                return (Exception) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Exception parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (Exception) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface ExceptionOrBuilder extends MessageLiteOrBuilder {
            Frame getFrames(int i);

            int getFramesCount();

            List<Frame> getFramesList();

            String getName();

            ByteString getNameBytes();

            String getReason();

            ByteString getReasonBytes();
        }

        public static final class Frame extends GeneratedMessageLite<Frame, Builder> implements FrameOrBuilder {
            public static final int BINARY_ID_FIELD_NUMBER = 2;
            public static final int C_BINARY_INFORMATION_FIELD_NUMBER = 5;
            public static final int C_BYTE_OFFSET_FIELD_NUMBER = 6;
            public static final int C_SOURCE_LOCATION_FIELD_NUMBER = 4;
            private static final Frame DEFAULT_INSTANCE;
            public static final int FRAME_ID_FIELD_NUMBER = 1;
            public static final int INSTRUCTION_ADDRESS_FIELD_NUMBER = 3;
            private static volatile Parser<Frame> PARSER = null;
            public static final int REPEATED_COUNT_FIELD_NUMBER = 7;
            private int binaryId_;
            private int bitField0_;
            private BinaryInformation cBinaryInformation_;
            private long cByteOffset_;
            private SourceLocation cSourceLocation_;
            private int frameId_;
            private long instructionAddress_;
            private int repeatedCount_;

            public static final class BinaryInformation extends GeneratedMessageLite<BinaryInformation, Builder> implements BinaryInformationOrBuilder {
                private static final BinaryInformation DEFAULT_INSTANCE;
                public static final int NAME_FIELD_NUMBER = 1;
                private static volatile Parser<BinaryInformation> PARSER = null;
                public static final int TYPE_FIELD_NUMBER = 2;
                private String name_ = "";
                private int type_;

                public static final class Builder extends GeneratedMessageLite.Builder<BinaryInformation, Builder> implements BinaryInformationOrBuilder {
                    private Builder() {
                        super(BinaryInformation.DEFAULT_INSTANCE);
                    }

                    public Builder clearName() {
                        copyOnWrite();
                        ((BinaryInformation) this.instance).clearName();
                        return this;
                    }

                    public Builder clearType() {
                        copyOnWrite();
                        ((BinaryInformation) this.instance).clearType();
                        return this;
                    }

                    @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Frame.BinaryInformationOrBuilder
                    public String getName() {
                        return ((BinaryInformation) this.instance).getName();
                    }

                    @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Frame.BinaryInformationOrBuilder
                    public ByteString getNameBytes() {
                        return ((BinaryInformation) this.instance).getNameBytes();
                    }

                    @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Frame.BinaryInformationOrBuilder
                    public ModuleType getType() {
                        return ((BinaryInformation) this.instance).getType();
                    }

                    @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Frame.BinaryInformationOrBuilder
                    public int getTypeValue() {
                        return ((BinaryInformation) this.instance).getTypeValue();
                    }

                    public Builder setName(String str) {
                        copyOnWrite();
                        ((BinaryInformation) this.instance).setName(str);
                        return this;
                    }

                    public Builder setNameBytes(ByteString byteString) throws IllegalArgumentException {
                        copyOnWrite();
                        ((BinaryInformation) this.instance).setNameBytes(byteString);
                        return this;
                    }

                    public Builder setType(ModuleType moduleType) {
                        copyOnWrite();
                        ((BinaryInformation) this.instance).setType(moduleType);
                        return this;
                    }

                    public Builder setTypeValue(int i) {
                        copyOnWrite();
                        ((BinaryInformation) this.instance).setTypeValue(i);
                        return this;
                    }
                }

                static {
                    BinaryInformation binaryInformation = new BinaryInformation();
                    DEFAULT_INSTANCE = binaryInformation;
                    GeneratedMessageLite.registerDefaultInstance(BinaryInformation.class, binaryInformation);
                }

                private BinaryInformation() {
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearName() {
                    this.name_ = getDefaultInstance().getName();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearType() {
                    this.type_ = 0;
                }

                public static BinaryInformation getDefaultInstance() {
                    return DEFAULT_INSTANCE;
                }

                public static Builder newBuilder() {
                    return DEFAULT_INSTANCE.createBuilder();
                }

                public static BinaryInformation parseDelimitedFrom(InputStream inputStream) {
                    return (BinaryInformation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static BinaryInformation parseFrom(ByteString byteString) {
                    return (BinaryInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                }

                public static Parser<BinaryInformation> parser() {
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
                public void setType(ModuleType moduleType) {
                    this.type_ = moduleType.getNumber();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setTypeValue(int i) {
                    this.type_ = i;
                }

                @Override // com.google.protobuf.GeneratedMessageLite
                public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                    int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                    switch (i) {
                        case 1:
                            return new BinaryInformation();
                        case 2:
                            return new Builder();
                        case 3:
                            return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\f", new Object[]{"name_", "type_"});
                        case 4:
                            return DEFAULT_INSTANCE;
                        case 5:
                            Parser<BinaryInformation> defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                synchronized (BinaryInformation.class) {
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

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Frame.BinaryInformationOrBuilder
                public String getName() {
                    return this.name_;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Frame.BinaryInformationOrBuilder
                public ByteString getNameBytes() {
                    return ByteString.copyFromUtf8(this.name_);
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Frame.BinaryInformationOrBuilder
                public ModuleType getType() {
                    ModuleType moduleTypeForNumber = ModuleType.forNumber(this.type_);
                    return moduleTypeForNumber == null ? ModuleType.UNRECOGNIZED : moduleTypeForNumber;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Frame.BinaryInformationOrBuilder
                public int getTypeValue() {
                    return this.type_;
                }

                public static Builder newBuilder(BinaryInformation binaryInformation) {
                    return DEFAULT_INSTANCE.createBuilder(binaryInformation);
                }

                public static BinaryInformation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return (BinaryInformation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static BinaryInformation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                    return (BinaryInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                }

                public static BinaryInformation parseFrom(CodedInputStream codedInputStream) {
                    return (BinaryInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                }

                public static BinaryInformation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return (BinaryInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                }

                public static BinaryInformation parseFrom(InputStream inputStream) {
                    return (BinaryInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static BinaryInformation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return (BinaryInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static BinaryInformation parseFrom(ByteBuffer byteBuffer) {
                    return (BinaryInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                }

                public static BinaryInformation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                    return (BinaryInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                }

                public static BinaryInformation parseFrom(byte[] bArr) {
                    return (BinaryInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                }

                public static BinaryInformation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                    return (BinaryInformation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                }
            }

            public interface BinaryInformationOrBuilder extends MessageLiteOrBuilder {
                String getName();

                ByteString getNameBytes();

                ModuleType getType();

                int getTypeValue();
            }

            public static final class Builder extends GeneratedMessageLite.Builder<Frame, Builder> implements FrameOrBuilder {
                private Builder() {
                    super(Frame.DEFAULT_INSTANCE);
                }

                public Builder clearBinaryId() {
                    copyOnWrite();
                    ((Frame) this.instance).clearBinaryId();
                    return this;
                }

                public Builder clearCBinaryInformation() {
                    copyOnWrite();
                    ((Frame) this.instance).clearCBinaryInformation();
                    return this;
                }

                public Builder clearCByteOffset() {
                    copyOnWrite();
                    ((Frame) this.instance).clearCByteOffset();
                    return this;
                }

                public Builder clearCSourceLocation() {
                    copyOnWrite();
                    ((Frame) this.instance).clearCSourceLocation();
                    return this;
                }

                public Builder clearFrameId() {
                    copyOnWrite();
                    ((Frame) this.instance).clearFrameId();
                    return this;
                }

                public Builder clearInstructionAddress() {
                    copyOnWrite();
                    ((Frame) this.instance).clearInstructionAddress();
                    return this;
                }

                public Builder clearRepeatedCount() {
                    copyOnWrite();
                    ((Frame) this.instance).clearRepeatedCount();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.FrameOrBuilder
                public int getBinaryId() {
                    return ((Frame) this.instance).getBinaryId();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.FrameOrBuilder
                public BinaryInformation getCBinaryInformation() {
                    return ((Frame) this.instance).getCBinaryInformation();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.FrameOrBuilder
                public long getCByteOffset() {
                    return ((Frame) this.instance).getCByteOffset();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.FrameOrBuilder
                public SourceLocation getCSourceLocation() {
                    return ((Frame) this.instance).getCSourceLocation();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.FrameOrBuilder
                public int getFrameId() {
                    return ((Frame) this.instance).getFrameId();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.FrameOrBuilder
                public long getInstructionAddress() {
                    return ((Frame) this.instance).getInstructionAddress();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.FrameOrBuilder
                public int getRepeatedCount() {
                    return ((Frame) this.instance).getRepeatedCount();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.FrameOrBuilder
                public boolean hasCBinaryInformation() {
                    return ((Frame) this.instance).hasCBinaryInformation();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.FrameOrBuilder
                public boolean hasCByteOffset() {
                    return ((Frame) this.instance).hasCByteOffset();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.FrameOrBuilder
                public boolean hasCSourceLocation() {
                    return ((Frame) this.instance).hasCSourceLocation();
                }

                public Builder mergeCBinaryInformation(BinaryInformation binaryInformation) {
                    copyOnWrite();
                    ((Frame) this.instance).mergeCBinaryInformation(binaryInformation);
                    return this;
                }

                public Builder mergeCSourceLocation(SourceLocation sourceLocation) {
                    copyOnWrite();
                    ((Frame) this.instance).mergeCSourceLocation(sourceLocation);
                    return this;
                }

                public Builder setBinaryId(int i) {
                    copyOnWrite();
                    ((Frame) this.instance).setBinaryId(i);
                    return this;
                }

                public Builder setCBinaryInformation(BinaryInformation.Builder builder) {
                    copyOnWrite();
                    ((Frame) this.instance).setCBinaryInformation(builder.build());
                    return this;
                }

                public Builder setCByteOffset(long j) {
                    copyOnWrite();
                    ((Frame) this.instance).setCByteOffset(j);
                    return this;
                }

                public Builder setCSourceLocation(SourceLocation.Builder builder) {
                    copyOnWrite();
                    ((Frame) this.instance).setCSourceLocation(builder.build());
                    return this;
                }

                public Builder setFrameId(int i) {
                    copyOnWrite();
                    ((Frame) this.instance).setFrameId(i);
                    return this;
                }

                public Builder setInstructionAddress(long j) {
                    copyOnWrite();
                    ((Frame) this.instance).setInstructionAddress(j);
                    return this;
                }

                public Builder setRepeatedCount(int i) {
                    copyOnWrite();
                    ((Frame) this.instance).setRepeatedCount(i);
                    return this;
                }

                public Builder setCBinaryInformation(BinaryInformation binaryInformation) {
                    copyOnWrite();
                    ((Frame) this.instance).setCBinaryInformation(binaryInformation);
                    return this;
                }

                public Builder setCSourceLocation(SourceLocation sourceLocation) {
                    copyOnWrite();
                    ((Frame) this.instance).setCSourceLocation(sourceLocation);
                    return this;
                }
            }

            public static final class SourceLocation extends GeneratedMessageLite<SourceLocation, Builder> implements SourceLocationOrBuilder {
                public static final int C_FILE_FIELD_NUMBER = 1;
                public static final int C_FUNCTION_NAME_FIELD_NUMBER = 2;
                public static final int C_LINE_FIELD_NUMBER = 3;
                private static final SourceLocation DEFAULT_INSTANCE;
                private static volatile Parser<SourceLocation> PARSER;
                private String cFile_ = "";
                private String cFunctionName_ = "";
                private int cLine_;

                public static final class Builder extends GeneratedMessageLite.Builder<SourceLocation, Builder> implements SourceLocationOrBuilder {
                    private Builder() {
                        super(SourceLocation.DEFAULT_INSTANCE);
                    }

                    public Builder clearCFile() {
                        copyOnWrite();
                        ((SourceLocation) this.instance).clearCFile();
                        return this;
                    }

                    public Builder clearCFunctionName() {
                        copyOnWrite();
                        ((SourceLocation) this.instance).clearCFunctionName();
                        return this;
                    }

                    public Builder clearCLine() {
                        copyOnWrite();
                        ((SourceLocation) this.instance).clearCLine();
                        return this;
                    }

                    @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Frame.SourceLocationOrBuilder
                    public String getCFile() {
                        return ((SourceLocation) this.instance).getCFile();
                    }

                    @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Frame.SourceLocationOrBuilder
                    public ByteString getCFileBytes() {
                        return ((SourceLocation) this.instance).getCFileBytes();
                    }

                    @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Frame.SourceLocationOrBuilder
                    public String getCFunctionName() {
                        return ((SourceLocation) this.instance).getCFunctionName();
                    }

                    @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Frame.SourceLocationOrBuilder
                    public ByteString getCFunctionNameBytes() {
                        return ((SourceLocation) this.instance).getCFunctionNameBytes();
                    }

                    @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Frame.SourceLocationOrBuilder
                    public int getCLine() {
                        return ((SourceLocation) this.instance).getCLine();
                    }

                    public Builder setCFile(String str) {
                        copyOnWrite();
                        ((SourceLocation) this.instance).setCFile(str);
                        return this;
                    }

                    public Builder setCFileBytes(ByteString byteString) throws IllegalArgumentException {
                        copyOnWrite();
                        ((SourceLocation) this.instance).setCFileBytes(byteString);
                        return this;
                    }

                    public Builder setCFunctionName(String str) {
                        copyOnWrite();
                        ((SourceLocation) this.instance).setCFunctionName(str);
                        return this;
                    }

                    public Builder setCFunctionNameBytes(ByteString byteString) throws IllegalArgumentException {
                        copyOnWrite();
                        ((SourceLocation) this.instance).setCFunctionNameBytes(byteString);
                        return this;
                    }

                    public Builder setCLine(int i) {
                        copyOnWrite();
                        ((SourceLocation) this.instance).setCLine(i);
                        return this;
                    }
                }

                static {
                    SourceLocation sourceLocation = new SourceLocation();
                    DEFAULT_INSTANCE = sourceLocation;
                    GeneratedMessageLite.registerDefaultInstance(SourceLocation.class, sourceLocation);
                }

                private SourceLocation() {
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearCFile() {
                    this.cFile_ = getDefaultInstance().getCFile();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearCFunctionName() {
                    this.cFunctionName_ = getDefaultInstance().getCFunctionName();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearCLine() {
                    this.cLine_ = 0;
                }

                public static SourceLocation getDefaultInstance() {
                    return DEFAULT_INSTANCE;
                }

                public static Builder newBuilder() {
                    return DEFAULT_INSTANCE.createBuilder();
                }

                public static SourceLocation parseDelimitedFrom(InputStream inputStream) {
                    return (SourceLocation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static SourceLocation parseFrom(ByteString byteString) {
                    return (SourceLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                }

                public static Parser<SourceLocation> parser() {
                    return DEFAULT_INSTANCE.getParserForType();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setCFile(String str) {
                    str.getClass();
                    this.cFile_ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setCFileBytes(ByteString byteString) throws IllegalArgumentException {
                    AbstractMessageLite.checkByteStringIsUtf8(byteString);
                    this.cFile_ = byteString.toStringUtf8();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setCFunctionName(String str) {
                    str.getClass();
                    this.cFunctionName_ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setCFunctionNameBytes(ByteString byteString) throws IllegalArgumentException {
                    AbstractMessageLite.checkByteStringIsUtf8(byteString);
                    this.cFunctionName_ = byteString.toStringUtf8();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setCLine(int i) {
                    this.cLine_ = i;
                }

                @Override // com.google.protobuf.GeneratedMessageLite
                public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                    int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                    switch (i) {
                        case 1:
                            return new SourceLocation();
                        case 2:
                            return new Builder();
                        case 3:
                            return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b", new Object[]{"cFile_", "cFunctionName_", "cLine_"});
                        case 4:
                            return DEFAULT_INSTANCE;
                        case 5:
                            Parser<SourceLocation> defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                synchronized (SourceLocation.class) {
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

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Frame.SourceLocationOrBuilder
                public String getCFile() {
                    return this.cFile_;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Frame.SourceLocationOrBuilder
                public ByteString getCFileBytes() {
                    return ByteString.copyFromUtf8(this.cFile_);
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Frame.SourceLocationOrBuilder
                public String getCFunctionName() {
                    return this.cFunctionName_;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Frame.SourceLocationOrBuilder
                public ByteString getCFunctionNameBytes() {
                    return ByteString.copyFromUtf8(this.cFunctionName_);
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Frame.SourceLocationOrBuilder
                public int getCLine() {
                    return this.cLine_;
                }

                public static Builder newBuilder(SourceLocation sourceLocation) {
                    return DEFAULT_INSTANCE.createBuilder(sourceLocation);
                }

                public static SourceLocation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return (SourceLocation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static SourceLocation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                    return (SourceLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                }

                public static SourceLocation parseFrom(CodedInputStream codedInputStream) {
                    return (SourceLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                }

                public static SourceLocation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return (SourceLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                }

                public static SourceLocation parseFrom(InputStream inputStream) {
                    return (SourceLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static SourceLocation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return (SourceLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static SourceLocation parseFrom(ByteBuffer byteBuffer) {
                    return (SourceLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                }

                public static SourceLocation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                    return (SourceLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                }

                public static SourceLocation parseFrom(byte[] bArr) {
                    return (SourceLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                }

                public static SourceLocation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                    return (SourceLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                }
            }

            public interface SourceLocationOrBuilder extends MessageLiteOrBuilder {
                String getCFile();

                ByteString getCFileBytes();

                String getCFunctionName();

                ByteString getCFunctionNameBytes();

                int getCLine();
            }

            static {
                Frame frame = new Frame();
                DEFAULT_INSTANCE = frame;
                GeneratedMessageLite.registerDefaultInstance(Frame.class, frame);
            }

            private Frame() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearBinaryId() {
                this.binaryId_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCBinaryInformation() {
                this.cBinaryInformation_ = null;
                this.bitField0_ &= -3;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCByteOffset() {
                this.bitField0_ &= -5;
                this.cByteOffset_ = 0L;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCSourceLocation() {
                this.cSourceLocation_ = null;
                this.bitField0_ &= -2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFrameId() {
                this.frameId_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearInstructionAddress() {
                this.instructionAddress_ = 0L;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearRepeatedCount() {
                this.repeatedCount_ = 0;
            }

            public static Frame getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeCBinaryInformation(BinaryInformation binaryInformation) {
                binaryInformation.getClass();
                BinaryInformation binaryInformation2 = this.cBinaryInformation_;
                if (binaryInformation2 != null && binaryInformation2 != BinaryInformation.getDefaultInstance()) {
                    binaryInformation = BinaryInformation.newBuilder(this.cBinaryInformation_).mergeFrom((BinaryInformation.Builder) binaryInformation).buildPartial();
                }
                this.cBinaryInformation_ = binaryInformation;
                this.bitField0_ |= 2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeCSourceLocation(SourceLocation sourceLocation) {
                sourceLocation.getClass();
                SourceLocation sourceLocation2 = this.cSourceLocation_;
                if (sourceLocation2 != null && sourceLocation2 != SourceLocation.getDefaultInstance()) {
                    sourceLocation = SourceLocation.newBuilder(this.cSourceLocation_).mergeFrom((SourceLocation.Builder) sourceLocation).buildPartial();
                }
                this.cSourceLocation_ = sourceLocation;
                this.bitField0_ |= 1;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Frame parseDelimitedFrom(InputStream inputStream) {
                return (Frame) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Frame parseFrom(ByteString byteString) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<Frame> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBinaryId(int i) {
                this.binaryId_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCBinaryInformation(BinaryInformation binaryInformation) {
                binaryInformation.getClass();
                this.cBinaryInformation_ = binaryInformation;
                this.bitField0_ |= 2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCByteOffset(long j) {
                this.bitField0_ |= 4;
                this.cByteOffset_ = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCSourceLocation(SourceLocation sourceLocation) {
                sourceLocation.getClass();
                this.cSourceLocation_ = sourceLocation;
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFrameId(int i) {
                this.frameId_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setInstructionAddress(long j) {
                this.instructionAddress_ = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setRepeatedCount(int i) {
                this.repeatedCount_ = i;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new Frame();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u000b\u0002\u000b\u0003\u0003\u0004ဉ\u0000\u0005ဉ\u0001\u0006ဃ\u0002\u0007\u000b", new Object[]{"bitField0_", "frameId_", "binaryId_", "instructionAddress_", "cSourceLocation_", "cBinaryInformation_", "cByteOffset_", "repeatedCount_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Frame> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Frame.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.FrameOrBuilder
            public int getBinaryId() {
                return this.binaryId_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.FrameOrBuilder
            public BinaryInformation getCBinaryInformation() {
                BinaryInformation binaryInformation = this.cBinaryInformation_;
                return binaryInformation == null ? BinaryInformation.getDefaultInstance() : binaryInformation;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.FrameOrBuilder
            public long getCByteOffset() {
                return this.cByteOffset_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.FrameOrBuilder
            public SourceLocation getCSourceLocation() {
                SourceLocation sourceLocation = this.cSourceLocation_;
                return sourceLocation == null ? SourceLocation.getDefaultInstance() : sourceLocation;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.FrameOrBuilder
            public int getFrameId() {
                return this.frameId_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.FrameOrBuilder
            public long getInstructionAddress() {
                return this.instructionAddress_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.FrameOrBuilder
            public int getRepeatedCount() {
                return this.repeatedCount_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.FrameOrBuilder
            public boolean hasCBinaryInformation() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.FrameOrBuilder
            public boolean hasCByteOffset() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.FrameOrBuilder
            public boolean hasCSourceLocation() {
                return (this.bitField0_ & 1) != 0;
            }

            public static Builder newBuilder(Frame frame) {
                return DEFAULT_INSTANCE.createBuilder(frame);
            }

            public static Frame parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Frame parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Frame parseFrom(CodedInputStream codedInputStream) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Frame parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Frame parseFrom(InputStream inputStream) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Frame parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Frame parseFrom(ByteBuffer byteBuffer) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Frame parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Frame parseFrom(byte[] bArr) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Frame parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface FrameOrBuilder extends MessageLiteOrBuilder {
            int getBinaryId();

            Frame.BinaryInformation getCBinaryInformation();

            long getCByteOffset();

            Frame.SourceLocation getCSourceLocation();

            int getFrameId();

            long getInstructionAddress();

            int getRepeatedCount();

            boolean hasCBinaryInformation();

            boolean hasCByteOffset();

            boolean hasCSourceLocation();
        }

        public static final class MachineInfo extends GeneratedMessageLite<MachineInfo, Builder> implements MachineInfoOrBuilder {
            public static final int C_ARCHITECTURE_FIELD_NUMBER = 5;
            private static final MachineInfo DEFAULT_INSTANCE;
            public static final int LOGICAL_PROCESSOR_COUNT_FIELD_NUMBER = 4;
            public static final int MODEL_FIELD_NUMBER = 1;
            private static volatile Parser<MachineInfo> PARSER = null;
            public static final int PROCESSOR_COUNT_FIELD_NUMBER = 3;
            public static final int PROCESSOR_FIELD_NUMBER = 2;
            private int bitField0_;
            private int cArchitecture_;
            private int logicalProcessorCount_;
            private String model_ = "";
            private int processorCount_;
            private Processor processor_;

            public static final class Builder extends GeneratedMessageLite.Builder<MachineInfo, Builder> implements MachineInfoOrBuilder {
                private Builder() {
                    super(MachineInfo.DEFAULT_INSTANCE);
                }

                public Builder clearCArchitecture() {
                    copyOnWrite();
                    ((MachineInfo) this.instance).clearCArchitecture();
                    return this;
                }

                public Builder clearLogicalProcessorCount() {
                    copyOnWrite();
                    ((MachineInfo) this.instance).clearLogicalProcessorCount();
                    return this;
                }

                public Builder clearModel() {
                    copyOnWrite();
                    ((MachineInfo) this.instance).clearModel();
                    return this;
                }

                public Builder clearProcessor() {
                    copyOnWrite();
                    ((MachineInfo) this.instance).clearProcessor();
                    return this;
                }

                public Builder clearProcessorCount() {
                    copyOnWrite();
                    ((MachineInfo) this.instance).clearProcessorCount();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.MachineInfoOrBuilder
                public Architecture getCArchitecture() {
                    return ((MachineInfo) this.instance).getCArchitecture();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.MachineInfoOrBuilder
                public int getCArchitectureValue() {
                    return ((MachineInfo) this.instance).getCArchitectureValue();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.MachineInfoOrBuilder
                public int getLogicalProcessorCount() {
                    return ((MachineInfo) this.instance).getLogicalProcessorCount();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.MachineInfoOrBuilder
                public String getModel() {
                    return ((MachineInfo) this.instance).getModel();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.MachineInfoOrBuilder
                public ByteString getModelBytes() {
                    return ((MachineInfo) this.instance).getModelBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.MachineInfoOrBuilder
                public Processor getProcessor() {
                    return ((MachineInfo) this.instance).getProcessor();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.MachineInfoOrBuilder
                public int getProcessorCount() {
                    return ((MachineInfo) this.instance).getProcessorCount();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.MachineInfoOrBuilder
                public boolean hasModel() {
                    return ((MachineInfo) this.instance).hasModel();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.MachineInfoOrBuilder
                public boolean hasProcessor() {
                    return ((MachineInfo) this.instance).hasProcessor();
                }

                public Builder mergeProcessor(Processor processor) {
                    copyOnWrite();
                    ((MachineInfo) this.instance).mergeProcessor(processor);
                    return this;
                }

                public Builder setCArchitecture(Architecture architecture) {
                    copyOnWrite();
                    ((MachineInfo) this.instance).setCArchitecture(architecture);
                    return this;
                }

                public Builder setCArchitectureValue(int i) {
                    copyOnWrite();
                    ((MachineInfo) this.instance).setCArchitectureValue(i);
                    return this;
                }

                public Builder setLogicalProcessorCount(int i) {
                    copyOnWrite();
                    ((MachineInfo) this.instance).setLogicalProcessorCount(i);
                    return this;
                }

                public Builder setModel(String str) {
                    copyOnWrite();
                    ((MachineInfo) this.instance).setModel(str);
                    return this;
                }

                public Builder setModelBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((MachineInfo) this.instance).setModelBytes(byteString);
                    return this;
                }

                public Builder setProcessor(Processor.Builder builder) {
                    copyOnWrite();
                    ((MachineInfo) this.instance).setProcessor(builder.build());
                    return this;
                }

                public Builder setProcessorCount(int i) {
                    copyOnWrite();
                    ((MachineInfo) this.instance).setProcessorCount(i);
                    return this;
                }

                public Builder setProcessor(Processor processor) {
                    copyOnWrite();
                    ((MachineInfo) this.instance).setProcessor(processor);
                    return this;
                }
            }

            static {
                MachineInfo machineInfo = new MachineInfo();
                DEFAULT_INSTANCE = machineInfo;
                GeneratedMessageLite.registerDefaultInstance(MachineInfo.class, machineInfo);
            }

            private MachineInfo() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCArchitecture() {
                this.cArchitecture_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLogicalProcessorCount() {
                this.logicalProcessorCount_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearModel() {
                this.bitField0_ &= -2;
                this.model_ = getDefaultInstance().getModel();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearProcessor() {
                this.processor_ = null;
                this.bitField0_ &= -3;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearProcessorCount() {
                this.processorCount_ = 0;
            }

            public static MachineInfo getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeProcessor(Processor processor) {
                processor.getClass();
                Processor processor2 = this.processor_;
                if (processor2 != null && processor2 != Processor.getDefaultInstance()) {
                    processor = Processor.newBuilder(this.processor_).mergeFrom((Processor.Builder) processor).buildPartial();
                }
                this.processor_ = processor;
                this.bitField0_ |= 2;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static MachineInfo parseDelimitedFrom(InputStream inputStream) {
                return (MachineInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static MachineInfo parseFrom(ByteString byteString) {
                return (MachineInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<MachineInfo> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCArchitecture(Architecture architecture) {
                this.cArchitecture_ = architecture.getNumber();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCArchitectureValue(int i) {
                this.cArchitecture_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLogicalProcessorCount(int i) {
                this.logicalProcessorCount_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setModel(String str) {
                str.getClass();
                this.bitField0_ |= 1;
                this.model_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setModelBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.model_ = byteString.toStringUtf8();
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setProcessor(Processor processor) {
                processor.getClass();
                this.processor_ = processor;
                this.bitField0_ |= 2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setProcessorCount(int i) {
                this.processorCount_ = i;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new MachineInfo();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ለ\u0000\u0002ဉ\u0001\u0003\u000b\u0004\u000b\u0005\f", new Object[]{"bitField0_", "model_", "processor_", "processorCount_", "logicalProcessorCount_", "cArchitecture_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<MachineInfo> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (MachineInfo.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.MachineInfoOrBuilder
            public Architecture getCArchitecture() {
                Architecture architectureForNumber = Architecture.forNumber(this.cArchitecture_);
                return architectureForNumber == null ? Architecture.UNRECOGNIZED : architectureForNumber;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.MachineInfoOrBuilder
            public int getCArchitectureValue() {
                return this.cArchitecture_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.MachineInfoOrBuilder
            public int getLogicalProcessorCount() {
                return this.logicalProcessorCount_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.MachineInfoOrBuilder
            public String getModel() {
                return this.model_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.MachineInfoOrBuilder
            public ByteString getModelBytes() {
                return ByteString.copyFromUtf8(this.model_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.MachineInfoOrBuilder
            public Processor getProcessor() {
                Processor processor = this.processor_;
                return processor == null ? Processor.getDefaultInstance() : processor;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.MachineInfoOrBuilder
            public int getProcessorCount() {
                return this.processorCount_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.MachineInfoOrBuilder
            public boolean hasModel() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.MachineInfoOrBuilder
            public boolean hasProcessor() {
                return (this.bitField0_ & 2) != 0;
            }

            public static Builder newBuilder(MachineInfo machineInfo) {
                return DEFAULT_INSTANCE.createBuilder(machineInfo);
            }

            public static MachineInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (MachineInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static MachineInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (MachineInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static MachineInfo parseFrom(CodedInputStream codedInputStream) {
                return (MachineInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static MachineInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (MachineInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static MachineInfo parseFrom(InputStream inputStream) {
                return (MachineInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static MachineInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (MachineInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static MachineInfo parseFrom(ByteBuffer byteBuffer) {
                return (MachineInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static MachineInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (MachineInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static MachineInfo parseFrom(byte[] bArr) {
                return (MachineInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static MachineInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (MachineInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface MachineInfoOrBuilder extends MessageLiteOrBuilder {
            Architecture getCArchitecture();

            int getCArchitectureValue();

            int getLogicalProcessorCount();

            String getModel();

            ByteString getModelBytes();

            Processor getProcessor();

            int getProcessorCount();

            boolean hasModel();

            boolean hasProcessor();
        }

        public static final class ProcessInfo extends GeneratedMessageLite<ProcessInfo, Builder> implements ProcessInfoOrBuilder {
            private static final ProcessInfo DEFAULT_INSTANCE;
            public static final int NATIVE_FIELD_NUMBER = 6;
            public static final int PARENT_PROCESS_ID_FIELD_NUMBER = 5;
            public static final int PARENT_PROCESS_NAME_FIELD_NUMBER = 4;
            private static volatile Parser<ProcessInfo> PARSER = null;
            public static final int PROCESS_ID_FIELD_NUMBER = 2;
            public static final int PROCESS_NAME_FIELD_NUMBER = 1;
            public static final int PROCESS_PATH_FIELD_NUMBER = 3;
            public static final int START_TIME_FIELD_NUMBER = 7;
            private int bitField0_;
            private boolean native_;
            private int parentProcessId_;
            private int processId_;
            private long startTime_;
            private String processName_ = "";
            private String processPath_ = "";
            private String parentProcessName_ = "";

            public static final class Builder extends GeneratedMessageLite.Builder<ProcessInfo, Builder> implements ProcessInfoOrBuilder {
                private Builder() {
                    super(ProcessInfo.DEFAULT_INSTANCE);
                }

                public Builder clearNative() {
                    copyOnWrite();
                    ((ProcessInfo) this.instance).clearNative();
                    return this;
                }

                public Builder clearParentProcessId() {
                    copyOnWrite();
                    ((ProcessInfo) this.instance).clearParentProcessId();
                    return this;
                }

                public Builder clearParentProcessName() {
                    copyOnWrite();
                    ((ProcessInfo) this.instance).clearParentProcessName();
                    return this;
                }

                public Builder clearProcessId() {
                    copyOnWrite();
                    ((ProcessInfo) this.instance).clearProcessId();
                    return this;
                }

                public Builder clearProcessName() {
                    copyOnWrite();
                    ((ProcessInfo) this.instance).clearProcessName();
                    return this;
                }

                public Builder clearProcessPath() {
                    copyOnWrite();
                    ((ProcessInfo) this.instance).clearProcessPath();
                    return this;
                }

                public Builder clearStartTime() {
                    copyOnWrite();
                    ((ProcessInfo) this.instance).clearStartTime();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
                public boolean getNative() {
                    return ((ProcessInfo) this.instance).getNative();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
                public int getParentProcessId() {
                    return ((ProcessInfo) this.instance).getParentProcessId();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
                public String getParentProcessName() {
                    return ((ProcessInfo) this.instance).getParentProcessName();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
                public ByteString getParentProcessNameBytes() {
                    return ((ProcessInfo) this.instance).getParentProcessNameBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
                public int getProcessId() {
                    return ((ProcessInfo) this.instance).getProcessId();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
                public String getProcessName() {
                    return ((ProcessInfo) this.instance).getProcessName();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
                public ByteString getProcessNameBytes() {
                    return ((ProcessInfo) this.instance).getProcessNameBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
                public String getProcessPath() {
                    return ((ProcessInfo) this.instance).getProcessPath();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
                public ByteString getProcessPathBytes() {
                    return ((ProcessInfo) this.instance).getProcessPathBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
                public long getStartTime() {
                    return ((ProcessInfo) this.instance).getStartTime();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
                public boolean hasParentProcessName() {
                    return ((ProcessInfo) this.instance).hasParentProcessName();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
                public boolean hasProcessName() {
                    return ((ProcessInfo) this.instance).hasProcessName();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
                public boolean hasProcessPath() {
                    return ((ProcessInfo) this.instance).hasProcessPath();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
                public boolean hasStartTime() {
                    return ((ProcessInfo) this.instance).hasStartTime();
                }

                public Builder setNative(boolean z) {
                    copyOnWrite();
                    ((ProcessInfo) this.instance).setNative(z);
                    return this;
                }

                public Builder setParentProcessId(int i) {
                    copyOnWrite();
                    ((ProcessInfo) this.instance).setParentProcessId(i);
                    return this;
                }

                public Builder setParentProcessName(String str) {
                    copyOnWrite();
                    ((ProcessInfo) this.instance).setParentProcessName(str);
                    return this;
                }

                public Builder setParentProcessNameBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((ProcessInfo) this.instance).setParentProcessNameBytes(byteString);
                    return this;
                }

                public Builder setProcessId(int i) {
                    copyOnWrite();
                    ((ProcessInfo) this.instance).setProcessId(i);
                    return this;
                }

                public Builder setProcessName(String str) {
                    copyOnWrite();
                    ((ProcessInfo) this.instance).setProcessName(str);
                    return this;
                }

                public Builder setProcessNameBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((ProcessInfo) this.instance).setProcessNameBytes(byteString);
                    return this;
                }

                public Builder setProcessPath(String str) {
                    copyOnWrite();
                    ((ProcessInfo) this.instance).setProcessPath(str);
                    return this;
                }

                public Builder setProcessPathBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((ProcessInfo) this.instance).setProcessPathBytes(byteString);
                    return this;
                }

                public Builder setStartTime(long j) {
                    copyOnWrite();
                    ((ProcessInfo) this.instance).setStartTime(j);
                    return this;
                }
            }

            static {
                ProcessInfo processInfo = new ProcessInfo();
                DEFAULT_INSTANCE = processInfo;
                GeneratedMessageLite.registerDefaultInstance(ProcessInfo.class, processInfo);
            }

            private ProcessInfo() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearNative() {
                this.native_ = false;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearParentProcessId() {
                this.parentProcessId_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearParentProcessName() {
                this.bitField0_ &= -5;
                this.parentProcessName_ = getDefaultInstance().getParentProcessName();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearProcessId() {
                this.processId_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearProcessName() {
                this.bitField0_ &= -2;
                this.processName_ = getDefaultInstance().getProcessName();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearProcessPath() {
                this.bitField0_ &= -3;
                this.processPath_ = getDefaultInstance().getProcessPath();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearStartTime() {
                this.bitField0_ &= -9;
                this.startTime_ = 0L;
            }

            public static ProcessInfo getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static ProcessInfo parseDelimitedFrom(InputStream inputStream) {
                return (ProcessInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ProcessInfo parseFrom(ByteString byteString) {
                return (ProcessInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<ProcessInfo> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNative(boolean z) {
                this.native_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setParentProcessId(int i) {
                this.parentProcessId_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setParentProcessName(String str) {
                str.getClass();
                this.bitField0_ |= 4;
                this.parentProcessName_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setParentProcessNameBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.parentProcessName_ = byteString.toStringUtf8();
                this.bitField0_ |= 4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setProcessId(int i) {
                this.processId_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setProcessName(String str) {
                str.getClass();
                this.bitField0_ |= 1;
                this.processName_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setProcessNameBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.processName_ = byteString.toStringUtf8();
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setProcessPath(String str) {
                str.getClass();
                this.bitField0_ |= 2;
                this.processPath_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setProcessPathBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.processPath_ = byteString.toStringUtf8();
                this.bitField0_ |= 2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setStartTime(long j) {
                this.bitField0_ |= 8;
                this.startTime_ = j;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new ProcessInfo();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ለ\u0000\u0002\u000b\u0003ለ\u0001\u0004ለ\u0002\u0005\u000b\u0006\u0007\u0007ဃ\u0003", new Object[]{"bitField0_", "processName_", "processId_", "processPath_", "parentProcessName_", "parentProcessId_", "native_", "startTime_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ProcessInfo> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (ProcessInfo.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
            public boolean getNative() {
                return this.native_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
            public int getParentProcessId() {
                return this.parentProcessId_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
            public String getParentProcessName() {
                return this.parentProcessName_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
            public ByteString getParentProcessNameBytes() {
                return ByteString.copyFromUtf8(this.parentProcessName_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
            public int getProcessId() {
                return this.processId_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
            public String getProcessName() {
                return this.processName_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
            public ByteString getProcessNameBytes() {
                return ByteString.copyFromUtf8(this.processName_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
            public String getProcessPath() {
                return this.processPath_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
            public ByteString getProcessPathBytes() {
                return ByteString.copyFromUtf8(this.processPath_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
            public long getStartTime() {
                return this.startTime_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
            public boolean hasParentProcessName() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
            public boolean hasProcessName() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
            public boolean hasProcessPath() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessInfoOrBuilder
            public boolean hasStartTime() {
                return (this.bitField0_ & 8) != 0;
            }

            public static Builder newBuilder(ProcessInfo processInfo) {
                return DEFAULT_INSTANCE.createBuilder(processInfo);
            }

            public static ProcessInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (ProcessInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ProcessInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (ProcessInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ProcessInfo parseFrom(CodedInputStream codedInputStream) {
                return (ProcessInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ProcessInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (ProcessInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static ProcessInfo parseFrom(InputStream inputStream) {
                return (ProcessInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ProcessInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (ProcessInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ProcessInfo parseFrom(ByteBuffer byteBuffer) {
                return (ProcessInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static ProcessInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (ProcessInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static ProcessInfo parseFrom(byte[] bArr) {
                return (ProcessInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static ProcessInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (ProcessInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface ProcessInfoOrBuilder extends MessageLiteOrBuilder {
            boolean getNative();

            int getParentProcessId();

            String getParentProcessName();

            ByteString getParentProcessNameBytes();

            int getProcessId();

            String getProcessName();

            ByteString getProcessNameBytes();

            String getProcessPath();

            ByteString getProcessPathBytes();

            long getStartTime();

            boolean hasParentProcessName();

            boolean hasProcessName();

            boolean hasProcessPath();

            boolean hasStartTime();
        }

        public static final class Processor extends GeneratedMessageLite<Processor, Builder> implements ProcessorOrBuilder {
            private static final Processor DEFAULT_INSTANCE;
            public static final int ENCODING_FIELD_NUMBER = 1;
            private static volatile Parser<Processor> PARSER = null;
            public static final int SUBTYPE_FIELD_NUMBER = 3;
            public static final int TYPE_FIELD_NUMBER = 2;
            private int encoding_;
            private long subtype_;
            private long type_;

            public static final class Builder extends GeneratedMessageLite.Builder<Processor, Builder> implements ProcessorOrBuilder {
                private Builder() {
                    super(Processor.DEFAULT_INSTANCE);
                }

                public Builder clearEncoding() {
                    copyOnWrite();
                    ((Processor) this.instance).clearEncoding();
                    return this;
                }

                public Builder clearSubtype() {
                    copyOnWrite();
                    ((Processor) this.instance).clearSubtype();
                    return this;
                }

                public Builder clearType() {
                    copyOnWrite();
                    ((Processor) this.instance).clearType();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessorOrBuilder
                public TypeEncoding getEncoding() {
                    return ((Processor) this.instance).getEncoding();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessorOrBuilder
                public int getEncodingValue() {
                    return ((Processor) this.instance).getEncodingValue();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessorOrBuilder
                public long getSubtype() {
                    return ((Processor) this.instance).getSubtype();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessorOrBuilder
                public long getType() {
                    return ((Processor) this.instance).getType();
                }

                public Builder setEncoding(TypeEncoding typeEncoding) {
                    copyOnWrite();
                    ((Processor) this.instance).setEncoding(typeEncoding);
                    return this;
                }

                public Builder setEncodingValue(int i) {
                    copyOnWrite();
                    ((Processor) this.instance).setEncodingValue(i);
                    return this;
                }

                public Builder setSubtype(long j) {
                    copyOnWrite();
                    ((Processor) this.instance).setSubtype(j);
                    return this;
                }

                public Builder setType(long j) {
                    copyOnWrite();
                    ((Processor) this.instance).setType(j);
                    return this;
                }
            }

            public enum TypeEncoding implements Internal.EnumLite {
                TYPE_ENCODING_UNSPECIFIED(0),
                TYPE_ENCODING_MACH(1),
                UNRECOGNIZED(-1);

                public static final int TYPE_ENCODING_MACH_VALUE = 1;
                public static final int TYPE_ENCODING_UNSPECIFIED_VALUE = 0;
                private static final Internal.EnumLiteMap<TypeEncoding> internalValueMap = new Internal.EnumLiteMap<TypeEncoding>() { // from class: com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Processor.TypeEncoding.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public TypeEncoding findValueByNumber(int i) {
                        return TypeEncoding.forNumber(i);
                    }
                };
                private final int value;

                public static final class TypeEncodingVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new TypeEncodingVerifier();

                    private TypeEncodingVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int i) {
                        return TypeEncoding.forNumber(i) != null;
                    }
                }

                TypeEncoding(int i) {
                    this.value = i;
                }

                public static TypeEncoding forNumber(int i) {
                    if (i == 0) {
                        return TYPE_ENCODING_UNSPECIFIED;
                    }
                    if (i != 1) {
                        return null;
                    }
                    return TYPE_ENCODING_MACH;
                }

                public static Internal.EnumLiteMap<TypeEncoding> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return TypeEncodingVerifier.INSTANCE;
                }

                @Deprecated
                public static TypeEncoding valueOf(int i) {
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
                Processor processor = new Processor();
                DEFAULT_INSTANCE = processor;
                GeneratedMessageLite.registerDefaultInstance(Processor.class, processor);
            }

            private Processor() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearEncoding() {
                this.encoding_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearSubtype() {
                this.subtype_ = 0L;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearType() {
                this.type_ = 0L;
            }

            public static Processor getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Processor parseDelimitedFrom(InputStream inputStream) {
                return (Processor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Processor parseFrom(ByteString byteString) {
                return (Processor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<Processor> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setEncoding(TypeEncoding typeEncoding) {
                this.encoding_ = typeEncoding.getNumber();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setEncodingValue(int i) {
                this.encoding_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setSubtype(long j) {
                this.subtype_ = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setType(long j) {
                this.type_ = j;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new Processor();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\u0003\u0003\u0003", new Object[]{"encoding_", "type_", "subtype_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Processor> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Processor.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessorOrBuilder
            public TypeEncoding getEncoding() {
                TypeEncoding typeEncodingForNumber = TypeEncoding.forNumber(this.encoding_);
                return typeEncodingForNumber == null ? TypeEncoding.UNRECOGNIZED : typeEncodingForNumber;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessorOrBuilder
            public int getEncodingValue() {
                return this.encoding_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessorOrBuilder
            public long getSubtype() {
                return this.subtype_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ProcessorOrBuilder
            public long getType() {
                return this.type_;
            }

            public static Builder newBuilder(Processor processor) {
                return DEFAULT_INSTANCE.createBuilder(processor);
            }

            public static Processor parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Processor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Processor parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (Processor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Processor parseFrom(CodedInputStream codedInputStream) {
                return (Processor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Processor parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Processor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Processor parseFrom(InputStream inputStream) {
                return (Processor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Processor parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Processor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Processor parseFrom(ByteBuffer byteBuffer) {
                return (Processor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Processor parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (Processor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Processor parseFrom(byte[] bArr) {
                return (Processor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Processor parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (Processor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface ProcessorOrBuilder extends MessageLiteOrBuilder {
            Processor.TypeEncoding getEncoding();

            int getEncodingValue();

            long getSubtype();

            long getType();
        }

        public static final class Signal extends GeneratedMessageLite<Signal, Builder> implements SignalOrBuilder {
            public static final int ADDRESS_FIELD_NUMBER = 3;
            public static final int CODE_FIELD_NUMBER = 2;
            private static final Signal DEFAULT_INSTANCE;
            public static final int MACH_EXCEPTION_FIELD_NUMBER = 4;
            public static final int NAME_FIELD_NUMBER = 1;
            private static volatile Parser<Signal> PARSER;
            private long address_;
            private int bitField0_;
            private MachException machException_;
            private String name_ = "";
            private String code_ = "";

            public static final class Builder extends GeneratedMessageLite.Builder<Signal, Builder> implements SignalOrBuilder {
                private Builder() {
                    super(Signal.DEFAULT_INSTANCE);
                }

                public Builder clearAddress() {
                    copyOnWrite();
                    ((Signal) this.instance).clearAddress();
                    return this;
                }

                public Builder clearCode() {
                    copyOnWrite();
                    ((Signal) this.instance).clearCode();
                    return this;
                }

                public Builder clearMachException() {
                    copyOnWrite();
                    ((Signal) this.instance).clearMachException();
                    return this;
                }

                public Builder clearName() {
                    copyOnWrite();
                    ((Signal) this.instance).clearName();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SignalOrBuilder
                public long getAddress() {
                    return ((Signal) this.instance).getAddress();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SignalOrBuilder
                public String getCode() {
                    return ((Signal) this.instance).getCode();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SignalOrBuilder
                public ByteString getCodeBytes() {
                    return ((Signal) this.instance).getCodeBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SignalOrBuilder
                public MachException getMachException() {
                    return ((Signal) this.instance).getMachException();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SignalOrBuilder
                public String getName() {
                    return ((Signal) this.instance).getName();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SignalOrBuilder
                public ByteString getNameBytes() {
                    return ((Signal) this.instance).getNameBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SignalOrBuilder
                public boolean hasMachException() {
                    return ((Signal) this.instance).hasMachException();
                }

                public Builder mergeMachException(MachException machException) {
                    copyOnWrite();
                    ((Signal) this.instance).mergeMachException(machException);
                    return this;
                }

                public Builder setAddress(long j) {
                    copyOnWrite();
                    ((Signal) this.instance).setAddress(j);
                    return this;
                }

                public Builder setCode(String str) {
                    copyOnWrite();
                    ((Signal) this.instance).setCode(str);
                    return this;
                }

                public Builder setCodeBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((Signal) this.instance).setCodeBytes(byteString);
                    return this;
                }

                public Builder setMachException(MachException.Builder builder) {
                    copyOnWrite();
                    ((Signal) this.instance).setMachException(builder.build());
                    return this;
                }

                public Builder setName(String str) {
                    copyOnWrite();
                    ((Signal) this.instance).setName(str);
                    return this;
                }

                public Builder setNameBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((Signal) this.instance).setNameBytes(byteString);
                    return this;
                }

                public Builder setMachException(MachException machException) {
                    copyOnWrite();
                    ((Signal) this.instance).setMachException(machException);
                    return this;
                }
            }

            public static final class MachException extends GeneratedMessageLite<MachException, Builder> implements MachExceptionOrBuilder {
                public static final int CODES_FIELD_NUMBER = 2;
                private static final MachException DEFAULT_INSTANCE;
                private static volatile Parser<MachException> PARSER = null;
                public static final int TYPE_FIELD_NUMBER = 1;
                private int codesMemoizedSerializedSize = -1;
                private Internal.LongList codes_ = GeneratedMessageLite.emptyLongList();
                private long type_;

                public static final class Builder extends GeneratedMessageLite.Builder<MachException, Builder> implements MachExceptionOrBuilder {
                    private Builder() {
                        super(MachException.DEFAULT_INSTANCE);
                    }

                    public Builder addAllCodes(Iterable<? extends Long> iterable) {
                        copyOnWrite();
                        ((MachException) this.instance).addAllCodes(iterable);
                        return this;
                    }

                    public Builder addCodes(long j) {
                        copyOnWrite();
                        ((MachException) this.instance).addCodes(j);
                        return this;
                    }

                    public Builder clearCodes() {
                        copyOnWrite();
                        ((MachException) this.instance).clearCodes();
                        return this;
                    }

                    public Builder clearType() {
                        copyOnWrite();
                        ((MachException) this.instance).clearType();
                        return this;
                    }

                    @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Signal.MachExceptionOrBuilder
                    public long getCodes(int i) {
                        return ((MachException) this.instance).getCodes(i);
                    }

                    @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Signal.MachExceptionOrBuilder
                    public int getCodesCount() {
                        return ((MachException) this.instance).getCodesCount();
                    }

                    @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Signal.MachExceptionOrBuilder
                    public List<Long> getCodesList() {
                        return Collections.unmodifiableList(((MachException) this.instance).getCodesList());
                    }

                    @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Signal.MachExceptionOrBuilder
                    public long getType() {
                        return ((MachException) this.instance).getType();
                    }

                    public Builder setCodes(int i, long j) {
                        copyOnWrite();
                        ((MachException) this.instance).setCodes(i, j);
                        return this;
                    }

                    public Builder setType(long j) {
                        copyOnWrite();
                        ((MachException) this.instance).setType(j);
                        return this;
                    }
                }

                static {
                    MachException machException = new MachException();
                    DEFAULT_INSTANCE = machException;
                    GeneratedMessageLite.registerDefaultInstance(MachException.class, machException);
                }

                private MachException() {
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllCodes(Iterable<? extends Long> iterable) {
                    ensureCodesIsMutable();
                    AbstractMessageLite.addAll(iterable, this.codes_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addCodes(long j) {
                    ensureCodesIsMutable();
                    this.codes_.addLong(j);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearCodes() {
                    this.codes_ = GeneratedMessageLite.emptyLongList();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearType() {
                    this.type_ = 0L;
                }

                private void ensureCodesIsMutable() {
                    Internal.LongList longList = this.codes_;
                    if (longList.isModifiable()) {
                        return;
                    }
                    this.codes_ = GeneratedMessageLite.mutableCopy(longList);
                }

                public static MachException getDefaultInstance() {
                    return DEFAULT_INSTANCE;
                }

                public static Builder newBuilder() {
                    return DEFAULT_INSTANCE.createBuilder();
                }

                public static MachException parseDelimitedFrom(InputStream inputStream) {
                    return (MachException) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static MachException parseFrom(ByteString byteString) {
                    return (MachException) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                }

                public static Parser<MachException> parser() {
                    return DEFAULT_INSTANCE.getParserForType();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setCodes(int i, long j) {
                    ensureCodesIsMutable();
                    this.codes_.setLong(i, j);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setType(long j) {
                    this.type_ = j;
                }

                @Override // com.google.protobuf.GeneratedMessageLite
                public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                    int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                    switch (i) {
                        case 1:
                            return new MachException();
                        case 2:
                            return new Builder();
                        case 3:
                            return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0003\u0002&", new Object[]{"type_", "codes_"});
                        case 4:
                            return DEFAULT_INSTANCE;
                        case 5:
                            Parser<MachException> defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                synchronized (MachException.class) {
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

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Signal.MachExceptionOrBuilder
                public long getCodes(int i) {
                    return this.codes_.getLong(i);
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Signal.MachExceptionOrBuilder
                public int getCodesCount() {
                    return this.codes_.size();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Signal.MachExceptionOrBuilder
                public List<Long> getCodesList() {
                    return this.codes_;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Signal.MachExceptionOrBuilder
                public long getType() {
                    return this.type_;
                }

                public static Builder newBuilder(MachException machException) {
                    return DEFAULT_INSTANCE.createBuilder(machException);
                }

                public static MachException parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return (MachException) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static MachException parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                    return (MachException) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                }

                public static MachException parseFrom(CodedInputStream codedInputStream) {
                    return (MachException) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                }

                public static MachException parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return (MachException) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                }

                public static MachException parseFrom(InputStream inputStream) {
                    return (MachException) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static MachException parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return (MachException) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static MachException parseFrom(ByteBuffer byteBuffer) {
                    return (MachException) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                }

                public static MachException parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                    return (MachException) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                }

                public static MachException parseFrom(byte[] bArr) {
                    return (MachException) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                }

                public static MachException parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                    return (MachException) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                }
            }

            public interface MachExceptionOrBuilder extends MessageLiteOrBuilder {
                long getCodes(int i);

                int getCodesCount();

                List<Long> getCodesList();

                long getType();
            }

            static {
                Signal signal = new Signal();
                DEFAULT_INSTANCE = signal;
                GeneratedMessageLite.registerDefaultInstance(Signal.class, signal);
            }

            private Signal() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearAddress() {
                this.address_ = 0L;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCode() {
                this.code_ = getDefaultInstance().getCode();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMachException() {
                this.machException_ = null;
                this.bitField0_ &= -2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearName() {
                this.name_ = getDefaultInstance().getName();
            }

            public static Signal getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeMachException(MachException machException) {
                machException.getClass();
                MachException machException2 = this.machException_;
                if (machException2 != null && machException2 != MachException.getDefaultInstance()) {
                    machException = MachException.newBuilder(this.machException_).mergeFrom((MachException.Builder) machException).buildPartial();
                }
                this.machException_ = machException;
                this.bitField0_ |= 1;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Signal parseDelimitedFrom(InputStream inputStream) {
                return (Signal) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Signal parseFrom(ByteString byteString) {
                return (Signal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<Signal> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setAddress(long j) {
                this.address_ = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCode(String str) {
                str.getClass();
                this.code_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCodeBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.code_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMachException(MachException machException) {
                machException.getClass();
                this.machException_ = machException;
                this.bitField0_ |= 1;
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

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new Signal();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0003\u0004ဉ\u0000", new Object[]{"bitField0_", "name_", "code_", "address_", "machException_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Signal> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Signal.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SignalOrBuilder
            public long getAddress() {
                return this.address_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SignalOrBuilder
            public String getCode() {
                return this.code_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SignalOrBuilder
            public ByteString getCodeBytes() {
                return ByteString.copyFromUtf8(this.code_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SignalOrBuilder
            public MachException getMachException() {
                MachException machException = this.machException_;
                return machException == null ? MachException.getDefaultInstance() : machException;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SignalOrBuilder
            public String getName() {
                return this.name_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SignalOrBuilder
            public ByteString getNameBytes() {
                return ByteString.copyFromUtf8(this.name_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SignalOrBuilder
            public boolean hasMachException() {
                return (this.bitField0_ & 1) != 0;
            }

            public static Builder newBuilder(Signal signal) {
                return DEFAULT_INSTANCE.createBuilder(signal);
            }

            public static Signal parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Signal) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Signal parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (Signal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Signal parseFrom(CodedInputStream codedInputStream) {
                return (Signal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Signal parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Signal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Signal parseFrom(InputStream inputStream) {
                return (Signal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Signal parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Signal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Signal parseFrom(ByteBuffer byteBuffer) {
                return (Signal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Signal parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (Signal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Signal parseFrom(byte[] bArr) {
                return (Signal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Signal parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (Signal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface SignalOrBuilder extends MessageLiteOrBuilder {
            long getAddress();

            String getCode();

            ByteString getCodeBytes();

            Signal.MachException getMachException();

            String getName();

            ByteString getNameBytes();

            boolean hasMachException();
        }

        public static final class SystemInfo extends GeneratedMessageLite<SystemInfo, Builder> implements SystemInfoOrBuilder {
            private static final SystemInfo DEFAULT_INSTANCE;
            public static final int OPERATING_SYSTEM_FIELD_NUMBER = 1;
            public static final int OS_BUILD_FIELD_NUMBER = 4;
            public static final int OS_VERSION_FIELD_NUMBER = 2;
            private static volatile Parser<SystemInfo> PARSER = null;
            public static final int TIMESTAMP_FIELD_NUMBER = 3;
            private int bitField0_;
            private int operatingSystem_;
            private long timestamp_;
            private String osVersion_ = "";
            private String osBuild_ = "";

            public static final class Builder extends GeneratedMessageLite.Builder<SystemInfo, Builder> implements SystemInfoOrBuilder {
                private Builder() {
                    super(SystemInfo.DEFAULT_INSTANCE);
                }

                public Builder clearOperatingSystem() {
                    copyOnWrite();
                    ((SystemInfo) this.instance).clearOperatingSystem();
                    return this;
                }

                public Builder clearOsBuild() {
                    copyOnWrite();
                    ((SystemInfo) this.instance).clearOsBuild();
                    return this;
                }

                public Builder clearOsVersion() {
                    copyOnWrite();
                    ((SystemInfo) this.instance).clearOsVersion();
                    return this;
                }

                public Builder clearTimestamp() {
                    copyOnWrite();
                    ((SystemInfo) this.instance).clearTimestamp();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SystemInfoOrBuilder
                public OperatingSystem getOperatingSystem() {
                    return ((SystemInfo) this.instance).getOperatingSystem();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SystemInfoOrBuilder
                public int getOperatingSystemValue() {
                    return ((SystemInfo) this.instance).getOperatingSystemValue();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SystemInfoOrBuilder
                public String getOsBuild() {
                    return ((SystemInfo) this.instance).getOsBuild();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SystemInfoOrBuilder
                public ByteString getOsBuildBytes() {
                    return ((SystemInfo) this.instance).getOsBuildBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SystemInfoOrBuilder
                public String getOsVersion() {
                    return ((SystemInfo) this.instance).getOsVersion();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SystemInfoOrBuilder
                public ByteString getOsVersionBytes() {
                    return ((SystemInfo) this.instance).getOsVersionBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SystemInfoOrBuilder
                public long getTimestamp() {
                    return ((SystemInfo) this.instance).getTimestamp();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SystemInfoOrBuilder
                public boolean hasOsBuild() {
                    return ((SystemInfo) this.instance).hasOsBuild();
                }

                public Builder setOperatingSystem(OperatingSystem operatingSystem) {
                    copyOnWrite();
                    ((SystemInfo) this.instance).setOperatingSystem(operatingSystem);
                    return this;
                }

                public Builder setOperatingSystemValue(int i) {
                    copyOnWrite();
                    ((SystemInfo) this.instance).setOperatingSystemValue(i);
                    return this;
                }

                public Builder setOsBuild(String str) {
                    copyOnWrite();
                    ((SystemInfo) this.instance).setOsBuild(str);
                    return this;
                }

                public Builder setOsBuildBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((SystemInfo) this.instance).setOsBuildBytes(byteString);
                    return this;
                }

                public Builder setOsVersion(String str) {
                    copyOnWrite();
                    ((SystemInfo) this.instance).setOsVersion(str);
                    return this;
                }

                public Builder setOsVersionBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((SystemInfo) this.instance).setOsVersionBytes(byteString);
                    return this;
                }

                public Builder setTimestamp(long j) {
                    copyOnWrite();
                    ((SystemInfo) this.instance).setTimestamp(j);
                    return this;
                }
            }

            public enum OperatingSystem implements Internal.EnumLite {
                OPERATING_SYSTEM_UNSPECIFIED(0),
                OPERATING_SYSTEM_IPHONE_OS(1),
                OPERATING_SYSTEM_IPHONE_SIMULATOR(2),
                UNRECOGNIZED(-1);

                public static final int OPERATING_SYSTEM_IPHONE_OS_VALUE = 1;
                public static final int OPERATING_SYSTEM_IPHONE_SIMULATOR_VALUE = 2;
                public static final int OPERATING_SYSTEM_UNSPECIFIED_VALUE = 0;
                private static final Internal.EnumLiteMap<OperatingSystem> internalValueMap = new Internal.EnumLiteMap<OperatingSystem>() { // from class: com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SystemInfo.OperatingSystem.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public OperatingSystem findValueByNumber(int i) {
                        return OperatingSystem.forNumber(i);
                    }
                };
                private final int value;

                public static final class OperatingSystemVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new OperatingSystemVerifier();

                    private OperatingSystemVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int i) {
                        return OperatingSystem.forNumber(i) != null;
                    }
                }

                OperatingSystem(int i) {
                    this.value = i;
                }

                public static OperatingSystem forNumber(int i) {
                    if (i == 0) {
                        return OPERATING_SYSTEM_UNSPECIFIED;
                    }
                    if (i == 1) {
                        return OPERATING_SYSTEM_IPHONE_OS;
                    }
                    if (i != 2) {
                        return null;
                    }
                    return OPERATING_SYSTEM_IPHONE_SIMULATOR;
                }

                public static Internal.EnumLiteMap<OperatingSystem> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return OperatingSystemVerifier.INSTANCE;
                }

                @Deprecated
                public static OperatingSystem valueOf(int i) {
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
                SystemInfo systemInfo = new SystemInfo();
                DEFAULT_INSTANCE = systemInfo;
                GeneratedMessageLite.registerDefaultInstance(SystemInfo.class, systemInfo);
            }

            private SystemInfo() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearOperatingSystem() {
                this.operatingSystem_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearOsBuild() {
                this.bitField0_ &= -2;
                this.osBuild_ = getDefaultInstance().getOsBuild();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearOsVersion() {
                this.osVersion_ = getDefaultInstance().getOsVersion();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearTimestamp() {
                this.timestamp_ = 0L;
            }

            public static SystemInfo getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static SystemInfo parseDelimitedFrom(InputStream inputStream) {
                return (SystemInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static SystemInfo parseFrom(ByteString byteString) {
                return (SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<SystemInfo> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOperatingSystem(OperatingSystem operatingSystem) {
                this.operatingSystem_ = operatingSystem.getNumber();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOperatingSystemValue(int i) {
                this.operatingSystem_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOsBuild(String str) {
                str.getClass();
                this.bitField0_ |= 1;
                this.osBuild_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOsBuildBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.osBuild_ = byteString.toStringUtf8();
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOsVersion(String str) {
                str.getClass();
                this.osVersion_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOsVersionBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.osVersion_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setTimestamp(long j) {
                this.timestamp_ = j;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new SystemInfo();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003\u0003\u0004ለ\u0000", new Object[]{"bitField0_", "operatingSystem_", "osVersion_", "timestamp_", "osBuild_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<SystemInfo> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (SystemInfo.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SystemInfoOrBuilder
            public OperatingSystem getOperatingSystem() {
                OperatingSystem operatingSystemForNumber = OperatingSystem.forNumber(this.operatingSystem_);
                return operatingSystemForNumber == null ? OperatingSystem.UNRECOGNIZED : operatingSystemForNumber;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SystemInfoOrBuilder
            public int getOperatingSystemValue() {
                return this.operatingSystem_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SystemInfoOrBuilder
            public String getOsBuild() {
                return this.osBuild_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SystemInfoOrBuilder
            public ByteString getOsBuildBytes() {
                return ByteString.copyFromUtf8(this.osBuild_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SystemInfoOrBuilder
            public String getOsVersion() {
                return this.osVersion_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SystemInfoOrBuilder
            public ByteString getOsVersionBytes() {
                return ByteString.copyFromUtf8(this.osVersion_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SystemInfoOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.SystemInfoOrBuilder
            public boolean hasOsBuild() {
                return (this.bitField0_ & 1) != 0;
            }

            public static Builder newBuilder(SystemInfo systemInfo) {
                return DEFAULT_INSTANCE.createBuilder(systemInfo);
            }

            public static SystemInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (SystemInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static SystemInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static SystemInfo parseFrom(CodedInputStream codedInputStream) {
                return (SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static SystemInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static SystemInfo parseFrom(InputStream inputStream) {
                return (SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static SystemInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static SystemInfo parseFrom(ByteBuffer byteBuffer) {
                return (SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static SystemInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static SystemInfo parseFrom(byte[] bArr) {
                return (SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static SystemInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface SystemInfoOrBuilder extends MessageLiteOrBuilder {
            SystemInfo.OperatingSystem getOperatingSystem();

            int getOperatingSystemValue();

            String getOsBuild();

            ByteString getOsBuildBytes();

            String getOsVersion();

            ByteString getOsVersionBytes();

            long getTimestamp();

            boolean hasOsBuild();
        }

        public static final class Thread extends GeneratedMessageLite<Thread, Builder> implements ThreadOrBuilder {
            private static final Thread DEFAULT_INSTANCE;
            public static final int FRAMES_FIELD_NUMBER = 2;
            public static final int IS_CRASHING_THREAD_FIELD_NUMBER = 3;
            private static volatile Parser<Thread> PARSER = null;
            public static final int REGISTERS_FIELD_NUMBER = 4;
            public static final int THREAD_ID_FIELD_NUMBER = 1;
            private boolean isCrashingThread_;
            private int threadId_;
            private Internal.ProtobufList<Frame> frames_ = GeneratedMessageLite.emptyProtobufList();
            private Internal.ProtobufList<Register> registers_ = GeneratedMessageLite.emptyProtobufList();

            public static final class Builder extends GeneratedMessageLite.Builder<Thread, Builder> implements ThreadOrBuilder {
                private Builder() {
                    super(Thread.DEFAULT_INSTANCE);
                }

                public Builder addAllFrames(Iterable<? extends Frame> iterable) {
                    copyOnWrite();
                    ((Thread) this.instance).addAllFrames(iterable);
                    return this;
                }

                public Builder addAllRegisters(Iterable<? extends Register> iterable) {
                    copyOnWrite();
                    ((Thread) this.instance).addAllRegisters(iterable);
                    return this;
                }

                public Builder addFrames(int i, Frame.Builder builder) {
                    copyOnWrite();
                    ((Thread) this.instance).addFrames(i, builder.build());
                    return this;
                }

                public Builder addRegisters(int i, Register.Builder builder) {
                    copyOnWrite();
                    ((Thread) this.instance).addRegisters(i, builder.build());
                    return this;
                }

                public Builder clearFrames() {
                    copyOnWrite();
                    ((Thread) this.instance).clearFrames();
                    return this;
                }

                public Builder clearIsCrashingThread() {
                    copyOnWrite();
                    ((Thread) this.instance).clearIsCrashingThread();
                    return this;
                }

                public Builder clearRegisters() {
                    copyOnWrite();
                    ((Thread) this.instance).clearRegisters();
                    return this;
                }

                public Builder clearThreadId() {
                    copyOnWrite();
                    ((Thread) this.instance).clearThreadId();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ThreadOrBuilder
                public Frame getFrames(int i) {
                    return ((Thread) this.instance).getFrames(i);
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ThreadOrBuilder
                public int getFramesCount() {
                    return ((Thread) this.instance).getFramesCount();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ThreadOrBuilder
                public List<Frame> getFramesList() {
                    return Collections.unmodifiableList(((Thread) this.instance).getFramesList());
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ThreadOrBuilder
                public boolean getIsCrashingThread() {
                    return ((Thread) this.instance).getIsCrashingThread();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ThreadOrBuilder
                public Register getRegisters(int i) {
                    return ((Thread) this.instance).getRegisters(i);
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ThreadOrBuilder
                public int getRegistersCount() {
                    return ((Thread) this.instance).getRegistersCount();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ThreadOrBuilder
                public List<Register> getRegistersList() {
                    return Collections.unmodifiableList(((Thread) this.instance).getRegistersList());
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ThreadOrBuilder
                public int getThreadId() {
                    return ((Thread) this.instance).getThreadId();
                }

                public Builder removeFrames(int i) {
                    copyOnWrite();
                    ((Thread) this.instance).removeFrames(i);
                    return this;
                }

                public Builder removeRegisters(int i) {
                    copyOnWrite();
                    ((Thread) this.instance).removeRegisters(i);
                    return this;
                }

                public Builder setFrames(int i, Frame.Builder builder) {
                    copyOnWrite();
                    ((Thread) this.instance).setFrames(i, builder.build());
                    return this;
                }

                public Builder setIsCrashingThread(boolean z) {
                    copyOnWrite();
                    ((Thread) this.instance).setIsCrashingThread(z);
                    return this;
                }

                public Builder setRegisters(int i, Register.Builder builder) {
                    copyOnWrite();
                    ((Thread) this.instance).setRegisters(i, builder.build());
                    return this;
                }

                public Builder setThreadId(int i) {
                    copyOnWrite();
                    ((Thread) this.instance).setThreadId(i);
                    return this;
                }

                public Builder addFrames(int i, Frame frame) {
                    copyOnWrite();
                    ((Thread) this.instance).addFrames(i, frame);
                    return this;
                }

                public Builder addRegisters(int i, Register register) {
                    copyOnWrite();
                    ((Thread) this.instance).addRegisters(i, register);
                    return this;
                }

                public Builder setFrames(int i, Frame frame) {
                    copyOnWrite();
                    ((Thread) this.instance).setFrames(i, frame);
                    return this;
                }

                public Builder setRegisters(int i, Register register) {
                    copyOnWrite();
                    ((Thread) this.instance).setRegisters(i, register);
                    return this;
                }

                public Builder addFrames(Frame.Builder builder) {
                    copyOnWrite();
                    ((Thread) this.instance).addFrames(builder.build());
                    return this;
                }

                public Builder addRegisters(Register.Builder builder) {
                    copyOnWrite();
                    ((Thread) this.instance).addRegisters(builder.build());
                    return this;
                }

                public Builder addFrames(Frame frame) {
                    copyOnWrite();
                    ((Thread) this.instance).addFrames(frame);
                    return this;
                }

                public Builder addRegisters(Register register) {
                    copyOnWrite();
                    ((Thread) this.instance).addRegisters(register);
                    return this;
                }
            }

            public static final class Register extends GeneratedMessageLite<Register, Builder> implements RegisterOrBuilder {
                private static final Register DEFAULT_INSTANCE;
                public static final int NAME_FIELD_NUMBER = 1;
                private static volatile Parser<Register> PARSER = null;
                public static final int VALUE_FIELD_NUMBER = 2;
                private String name_ = "";
                private long value_;

                public static final class Builder extends GeneratedMessageLite.Builder<Register, Builder> implements RegisterOrBuilder {
                    private Builder() {
                        super(Register.DEFAULT_INSTANCE);
                    }

                    public Builder clearName() {
                        copyOnWrite();
                        ((Register) this.instance).clearName();
                        return this;
                    }

                    public Builder clearValue() {
                        copyOnWrite();
                        ((Register) this.instance).clearValue();
                        return this;
                    }

                    @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Thread.RegisterOrBuilder
                    public String getName() {
                        return ((Register) this.instance).getName();
                    }

                    @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Thread.RegisterOrBuilder
                    public ByteString getNameBytes() {
                        return ((Register) this.instance).getNameBytes();
                    }

                    @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Thread.RegisterOrBuilder
                    public long getValue() {
                        return ((Register) this.instance).getValue();
                    }

                    public Builder setName(String str) {
                        copyOnWrite();
                        ((Register) this.instance).setName(str);
                        return this;
                    }

                    public Builder setNameBytes(ByteString byteString) throws IllegalArgumentException {
                        copyOnWrite();
                        ((Register) this.instance).setNameBytes(byteString);
                        return this;
                    }

                    public Builder setValue(long j) {
                        copyOnWrite();
                        ((Register) this.instance).setValue(j);
                        return this;
                    }
                }

                static {
                    Register register = new Register();
                    DEFAULT_INSTANCE = register;
                    GeneratedMessageLite.registerDefaultInstance(Register.class, register);
                }

                private Register() {
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearName() {
                    this.name_ = getDefaultInstance().getName();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearValue() {
                    this.value_ = 0L;
                }

                public static Register getDefaultInstance() {
                    return DEFAULT_INSTANCE;
                }

                public static Builder newBuilder() {
                    return DEFAULT_INSTANCE.createBuilder();
                }

                public static Register parseDelimitedFrom(InputStream inputStream) {
                    return (Register) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static Register parseFrom(ByteString byteString) {
                    return (Register) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                }

                public static Parser<Register> parser() {
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
                public void setValue(long j) {
                    this.value_ = j;
                }

                @Override // com.google.protobuf.GeneratedMessageLite
                public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                    int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                    switch (i) {
                        case 1:
                            return new Register();
                        case 2:
                            return new Builder();
                        case 3:
                            return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0003", new Object[]{"name_", "value_"});
                        case 4:
                            return DEFAULT_INSTANCE;
                        case 5:
                            Parser<Register> defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                synchronized (Register.class) {
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

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Thread.RegisterOrBuilder
                public String getName() {
                    return this.name_;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Thread.RegisterOrBuilder
                public ByteString getNameBytes() {
                    return ByteString.copyFromUtf8(this.name_);
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.Thread.RegisterOrBuilder
                public long getValue() {
                    return this.value_;
                }

                public static Builder newBuilder(Register register) {
                    return DEFAULT_INSTANCE.createBuilder(register);
                }

                public static Register parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return (Register) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static Register parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                    return (Register) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                }

                public static Register parseFrom(CodedInputStream codedInputStream) {
                    return (Register) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                }

                public static Register parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return (Register) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                }

                public static Register parseFrom(InputStream inputStream) {
                    return (Register) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static Register parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return (Register) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static Register parseFrom(ByteBuffer byteBuffer) {
                    return (Register) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                }

                public static Register parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                    return (Register) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                }

                public static Register parseFrom(byte[] bArr) {
                    return (Register) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                }

                public static Register parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                    return (Register) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                }
            }

            public interface RegisterOrBuilder extends MessageLiteOrBuilder {
                String getName();

                ByteString getNameBytes();

                long getValue();
            }

            static {
                Thread thread = new Thread();
                DEFAULT_INSTANCE = thread;
                GeneratedMessageLite.registerDefaultInstance(Thread.class, thread);
            }

            private Thread() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllFrames(Iterable<? extends Frame> iterable) {
                ensureFramesIsMutable();
                AbstractMessageLite.addAll(iterable, this.frames_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllRegisters(Iterable<? extends Register> iterable) {
                ensureRegistersIsMutable();
                AbstractMessageLite.addAll(iterable, this.registers_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addFrames(int i, Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.add(i, frame);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addRegisters(int i, Register register) {
                register.getClass();
                ensureRegistersIsMutable();
                this.registers_.add(i, register);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFrames() {
                this.frames_ = GeneratedMessageLite.emptyProtobufList();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearIsCrashingThread() {
                this.isCrashingThread_ = false;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearRegisters() {
                this.registers_ = GeneratedMessageLite.emptyProtobufList();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearThreadId() {
                this.threadId_ = 0;
            }

            private void ensureFramesIsMutable() {
                Internal.ProtobufList<Frame> protobufList = this.frames_;
                if (protobufList.isModifiable()) {
                    return;
                }
                this.frames_ = GeneratedMessageLite.mutableCopy(protobufList);
            }

            private void ensureRegistersIsMutable() {
                Internal.ProtobufList<Register> protobufList = this.registers_;
                if (protobufList.isModifiable()) {
                    return;
                }
                this.registers_ = GeneratedMessageLite.mutableCopy(protobufList);
            }

            public static Thread getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Thread parseDelimitedFrom(InputStream inputStream) {
                return (Thread) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Thread parseFrom(ByteString byteString) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<Thread> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void removeFrames(int i) {
                ensureFramesIsMutable();
                this.frames_.remove(i);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void removeRegisters(int i) {
                ensureRegistersIsMutable();
                this.registers_.remove(i);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFrames(int i, Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.set(i, frame);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setIsCrashingThread(boolean z) {
                this.isCrashingThread_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setRegisters(int i, Register register) {
                register.getClass();
                ensureRegistersIsMutable();
                this.registers_.set(i, register);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setThreadId(int i) {
                this.threadId_ = i;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new Thread();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0002\u0000\u0001\u000b\u0002\u001b\u0003\u0007\u0004\u001b", new Object[]{"threadId_", "frames_", Frame.class, "isCrashingThread_", "registers_", Register.class});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Thread> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Thread.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ThreadOrBuilder
            public Frame getFrames(int i) {
                return this.frames_.get(i);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ThreadOrBuilder
            public int getFramesCount() {
                return this.frames_.size();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ThreadOrBuilder
            public List<Frame> getFramesList() {
                return this.frames_;
            }

            public FrameOrBuilder getFramesOrBuilder(int i) {
                return this.frames_.get(i);
            }

            public List<? extends FrameOrBuilder> getFramesOrBuilderList() {
                return this.frames_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ThreadOrBuilder
            public boolean getIsCrashingThread() {
                return this.isCrashingThread_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ThreadOrBuilder
            public Register getRegisters(int i) {
                return this.registers_.get(i);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ThreadOrBuilder
            public int getRegistersCount() {
                return this.registers_.size();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ThreadOrBuilder
            public List<Register> getRegistersList() {
                return this.registers_;
            }

            public RegisterOrBuilder getRegistersOrBuilder(int i) {
                return this.registers_.get(i);
            }

            public List<? extends RegisterOrBuilder> getRegistersOrBuilderList() {
                return this.registers_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReport.ThreadOrBuilder
            public int getThreadId() {
                return this.threadId_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addFrames(Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.add(frame);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addRegisters(Register register) {
                register.getClass();
                ensureRegistersIsMutable();
                this.registers_.add(register);
            }

            public static Builder newBuilder(Thread thread) {
                return DEFAULT_INSTANCE.createBuilder(thread);
            }

            public static Thread parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Thread parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Thread parseFrom(CodedInputStream codedInputStream) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Thread parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Thread parseFrom(InputStream inputStream) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Thread parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Thread parseFrom(ByteBuffer byteBuffer) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Thread parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Thread parseFrom(byte[] bArr) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Thread parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface ThreadOrBuilder extends MessageLiteOrBuilder {
            Frame getFrames(int i);

            int getFramesCount();

            List<Frame> getFramesList();

            boolean getIsCrashingThread();

            Thread.Register getRegisters(int i);

            int getRegistersCount();

            List<Thread.Register> getRegistersList();

            int getThreadId();
        }

        static {
            IOSThreadReport iOSThreadReport = new IOSThreadReport();
            DEFAULT_INSTANCE = iOSThreadReport;
            GeneratedMessageLite.registerDefaultInstance(IOSThreadReport.class, iOSThreadReport);
        }

        private IOSThreadReport() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllThreads(Iterable<? extends Thread> iterable) {
            ensureThreadsIsMutable();
            AbstractMessageLite.addAll(iterable, this.threads_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addThreads(int i, Thread thread) {
            thread.getClass();
            ensureThreadsIsMutable();
            this.threads_.add(i, thread);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearApplicationInfo() {
            this.applicationInfo_ = null;
            this.bitField0_ &= -3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLastExceptionBacktrace() {
            this.lastExceptionBacktrace_ = null;
            this.bitField0_ &= -33;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMachineInfo() {
            this.machineInfo_ = null;
            this.bitField0_ &= -17;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearProcessInfo() {
            this.processInfo_ = null;
            this.bitField0_ &= -9;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSignal() {
            this.signal_ = null;
            this.bitField0_ &= -5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSystemInfo() {
            this.systemInfo_ = null;
            this.bitField0_ &= -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearThreads() {
            this.threads_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureThreadsIsMutable() {
            Internal.ProtobufList<Thread> protobufList = this.threads_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.threads_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static IOSThreadReport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<Integer, Binary> getMutableBinariesMap() {
            return internalGetMutableBinaries();
        }

        private MapFieldLite<Integer, Binary> internalGetBinaries() {
            return this.binaries_;
        }

        private MapFieldLite<Integer, Binary> internalGetMutableBinaries() {
            if (!this.binaries_.isMutable()) {
                this.binaries_ = this.binaries_.mutableCopy();
            }
            return this.binaries_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeApplicationInfo(ApplicationInfo applicationInfo) {
            applicationInfo.getClass();
            ApplicationInfo applicationInfo2 = this.applicationInfo_;
            if (applicationInfo2 != null && applicationInfo2 != ApplicationInfo.getDefaultInstance()) {
                applicationInfo = ApplicationInfo.newBuilder(this.applicationInfo_).mergeFrom((ApplicationInfo.Builder) applicationInfo).buildPartial();
            }
            this.applicationInfo_ = applicationInfo;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeLastExceptionBacktrace(Exception exception) {
            exception.getClass();
            Exception exception2 = this.lastExceptionBacktrace_;
            if (exception2 != null && exception2 != Exception.getDefaultInstance()) {
                exception = Exception.newBuilder(this.lastExceptionBacktrace_).mergeFrom((Exception.Builder) exception).buildPartial();
            }
            this.lastExceptionBacktrace_ = exception;
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeMachineInfo(MachineInfo machineInfo) {
            machineInfo.getClass();
            MachineInfo machineInfo2 = this.machineInfo_;
            if (machineInfo2 != null && machineInfo2 != MachineInfo.getDefaultInstance()) {
                machineInfo = MachineInfo.newBuilder(this.machineInfo_).mergeFrom((MachineInfo.Builder) machineInfo).buildPartial();
            }
            this.machineInfo_ = machineInfo;
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeProcessInfo(ProcessInfo processInfo) {
            processInfo.getClass();
            ProcessInfo processInfo2 = this.processInfo_;
            if (processInfo2 != null && processInfo2 != ProcessInfo.getDefaultInstance()) {
                processInfo = ProcessInfo.newBuilder(this.processInfo_).mergeFrom((ProcessInfo.Builder) processInfo).buildPartial();
            }
            this.processInfo_ = processInfo;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSignal(Signal signal) {
            signal.getClass();
            Signal signal2 = this.signal_;
            if (signal2 != null && signal2 != Signal.getDefaultInstance()) {
                signal = Signal.newBuilder(this.signal_).mergeFrom((Signal.Builder) signal).buildPartial();
            }
            this.signal_ = signal;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSystemInfo(SystemInfo systemInfo) {
            systemInfo.getClass();
            SystemInfo systemInfo2 = this.systemInfo_;
            if (systemInfo2 != null && systemInfo2 != SystemInfo.getDefaultInstance()) {
                systemInfo = SystemInfo.newBuilder(this.systemInfo_).mergeFrom((SystemInfo.Builder) systemInfo).buildPartial();
            }
            this.systemInfo_ = systemInfo;
            this.bitField0_ |= 1;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IOSThreadReport parseDelimitedFrom(InputStream inputStream) {
            return (IOSThreadReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IOSThreadReport parseFrom(ByteString byteString) {
            return (IOSThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<IOSThreadReport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeThreads(int i) {
            ensureThreadsIsMutable();
            this.threads_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setApplicationInfo(ApplicationInfo applicationInfo) {
            applicationInfo.getClass();
            this.applicationInfo_ = applicationInfo;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLastExceptionBacktrace(Exception exception) {
            exception.getClass();
            this.lastExceptionBacktrace_ = exception;
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMachineInfo(MachineInfo machineInfo) {
            machineInfo.getClass();
            this.machineInfo_ = machineInfo;
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProcessInfo(ProcessInfo processInfo) {
            processInfo.getClass();
            this.processInfo_ = processInfo;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSignal(Signal signal) {
            signal.getClass();
            this.signal_ = signal;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSystemInfo(SystemInfo systemInfo) {
            systemInfo.getClass();
            this.systemInfo_ = systemInfo;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setThreads(int i, Thread thread) {
            thread.getClass();
            ensureThreadsIsMutable();
            this.threads_.set(i, thread);
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
        public boolean containsBinaries(int i) {
            return internalGetBinaries().containsKey(Integer.valueOf(i));
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new IOSThreadReport();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0001\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007\u001b\b2", new Object[]{"bitField0_", "systemInfo_", "applicationInfo_", "signal_", "processInfo_", "machineInfo_", "lastExceptionBacktrace_", "threads_", Thread.class, "binaries_", BinariesDefaultEntryHolder.defaultEntry});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<IOSThreadReport> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (IOSThreadReport.class) {
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

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
        public ApplicationInfo getApplicationInfo() {
            ApplicationInfo applicationInfo = this.applicationInfo_;
            return applicationInfo == null ? ApplicationInfo.getDefaultInstance() : applicationInfo;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
        @Deprecated
        public Map<Integer, Binary> getBinaries() {
            return getBinariesMap();
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
        public int getBinariesCount() {
            return internalGetBinaries().size();
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
        public Map<Integer, Binary> getBinariesMap() {
            return Collections.unmodifiableMap(internalGetBinaries());
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
        public Binary getBinariesOrDefault(int i, Binary binary) {
            MapFieldLite<Integer, Binary> mapFieldLiteInternalGetBinaries = internalGetBinaries();
            return mapFieldLiteInternalGetBinaries.containsKey(Integer.valueOf(i)) ? mapFieldLiteInternalGetBinaries.get(Integer.valueOf(i)) : binary;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
        public Binary getBinariesOrThrow(int i) {
            MapFieldLite<Integer, Binary> mapFieldLiteInternalGetBinaries = internalGetBinaries();
            if (mapFieldLiteInternalGetBinaries.containsKey(Integer.valueOf(i))) {
                return mapFieldLiteInternalGetBinaries.get(Integer.valueOf(i));
            }
            throw new IllegalArgumentException();
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
        public Exception getLastExceptionBacktrace() {
            Exception exception = this.lastExceptionBacktrace_;
            return exception == null ? Exception.getDefaultInstance() : exception;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
        public MachineInfo getMachineInfo() {
            MachineInfo machineInfo = this.machineInfo_;
            return machineInfo == null ? MachineInfo.getDefaultInstance() : machineInfo;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
        public ProcessInfo getProcessInfo() {
            ProcessInfo processInfo = this.processInfo_;
            return processInfo == null ? ProcessInfo.getDefaultInstance() : processInfo;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
        public Signal getSignal() {
            Signal signal = this.signal_;
            return signal == null ? Signal.getDefaultInstance() : signal;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
        public SystemInfo getSystemInfo() {
            SystemInfo systemInfo = this.systemInfo_;
            return systemInfo == null ? SystemInfo.getDefaultInstance() : systemInfo;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
        public Thread getThreads(int i) {
            return this.threads_.get(i);
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
        public int getThreadsCount() {
            return this.threads_.size();
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
        public List<Thread> getThreadsList() {
            return this.threads_;
        }

        public ThreadOrBuilder getThreadsOrBuilder(int i) {
            return this.threads_.get(i);
        }

        public List<? extends ThreadOrBuilder> getThreadsOrBuilderList() {
            return this.threads_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
        public boolean hasApplicationInfo() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
        public boolean hasLastExceptionBacktrace() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
        public boolean hasMachineInfo() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
        public boolean hasProcessInfo() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
        public boolean hasSignal() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.IOSThreadReportOrBuilder
        public boolean hasSystemInfo() {
            return (this.bitField0_ & 1) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addThreads(Thread thread) {
            thread.getClass();
            ensureThreadsIsMutable();
            this.threads_.add(thread);
        }

        public static Builder newBuilder(IOSThreadReport iOSThreadReport) {
            return DEFAULT_INSTANCE.createBuilder(iOSThreadReport);
        }

        public static IOSThreadReport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (IOSThreadReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static IOSThreadReport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (IOSThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static IOSThreadReport parseFrom(CodedInputStream codedInputStream) {
            return (IOSThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static IOSThreadReport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (IOSThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static IOSThreadReport parseFrom(InputStream inputStream) {
            return (IOSThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IOSThreadReport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (IOSThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static IOSThreadReport parseFrom(ByteBuffer byteBuffer) {
            return (IOSThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static IOSThreadReport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (IOSThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static IOSThreadReport parseFrom(byte[] bArr) {
            return (IOSThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IOSThreadReport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (IOSThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface IOSThreadReportOrBuilder extends MessageLiteOrBuilder {
        boolean containsBinaries(int i);

        IOSThreadReport.ApplicationInfo getApplicationInfo();

        @Deprecated
        Map<Integer, IOSThreadReport.Binary> getBinaries();

        int getBinariesCount();

        Map<Integer, IOSThreadReport.Binary> getBinariesMap();

        IOSThreadReport.Binary getBinariesOrDefault(int i, IOSThreadReport.Binary binary);

        IOSThreadReport.Binary getBinariesOrThrow(int i);

        IOSThreadReport.Exception getLastExceptionBacktrace();

        IOSThreadReport.MachineInfo getMachineInfo();

        IOSThreadReport.ProcessInfo getProcessInfo();

        IOSThreadReport.Signal getSignal();

        IOSThreadReport.SystemInfo getSystemInfo();

        IOSThreadReport.Thread getThreads(int i);

        int getThreadsCount();

        List<IOSThreadReport.Thread> getThreadsList();

        boolean hasApplicationInfo();

        boolean hasLastExceptionBacktrace();

        boolean hasMachineInfo();

        boolean hasProcessInfo();

        boolean hasSignal();

        boolean hasSystemInfo();
    }

    public enum ModuleType implements Internal.EnumLite {
        MODULE_TYPE_UNSPECIFIED(0),
        MODULE_TYPE_APP(1),
        MODULE_TYPE_SYSTEM(2),
        MODULE_TYPE_THIRD_PARTY(3),
        UNRECOGNIZED(-1);

        public static final int MODULE_TYPE_APP_VALUE = 1;
        public static final int MODULE_TYPE_SYSTEM_VALUE = 2;
        public static final int MODULE_TYPE_THIRD_PARTY_VALUE = 3;
        public static final int MODULE_TYPE_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<ModuleType> internalValueMap = new Internal.EnumLiteMap<ModuleType>() { // from class: com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ModuleType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ModuleType findValueByNumber(int i) {
                return ModuleType.forNumber(i);
            }
        };
        private final int value;

        public static final class ModuleTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new ModuleTypeVerifier();

            private ModuleTypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return ModuleType.forNumber(i) != null;
            }
        }

        ModuleType(int i) {
            this.value = i;
        }

        public static ModuleType forNumber(int i) {
            if (i == 0) {
                return MODULE_TYPE_UNSPECIFIED;
            }
            if (i == 1) {
                return MODULE_TYPE_APP;
            }
            if (i == 2) {
                return MODULE_TYPE_SYSTEM;
            }
            if (i != 3) {
                return null;
            }
            return MODULE_TYPE_THIRD_PARTY;
        }

        public static Internal.EnumLiteMap<ModuleType> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return ModuleTypeVerifier.INSTANCE;
        }

        @Deprecated
        public static ModuleType valueOf(int i) {
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

    public enum OS implements Internal.EnumLite {
        OS_UNSPECIFIED(0),
        OS_IOS(1),
        OS_ANDROID(2),
        UNRECOGNIZED(-1);

        public static final int OS_ANDROID_VALUE = 2;
        public static final int OS_IOS_VALUE = 1;
        public static final int OS_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<OS> internalValueMap = new Internal.EnumLiteMap<OS>() { // from class: com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.OS.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public OS findValueByNumber(int i) {
                return OS.forNumber(i);
            }
        };
        private final int value;

        public static final class OSVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new OSVerifier();

            private OSVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return OS.forNumber(i) != null;
            }
        }

        OS(int i) {
            this.value = i;
        }

        public static OS forNumber(int i) {
            if (i == 0) {
                return OS_UNSPECIFIED;
            }
            if (i == 1) {
                return OS_IOS;
            }
            if (i != 2) {
                return null;
            }
            return OS_ANDROID;
        }

        public static Internal.EnumLiteMap<OS> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return OSVerifier.INSTANCE;
        }

        @Deprecated
        public static OS valueOf(int i) {
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

    public static final class ReactNativeThreadReport extends GeneratedMessageLite<ReactNativeThreadReport, Builder> implements ReactNativeThreadReportOrBuilder {
        public static final int APP_INFO_FIELD_NUMBER = 1;
        private static final ReactNativeThreadReport DEFAULT_INSTANCE;
        public static final int EXCEPTION_FIELD_NUMBER = 2;
        public static final int MAPPING_FILE_ID_FIELD_NUMBER = 5;
        private static volatile Parser<ReactNativeThreadReport> PARSER = null;
        public static final int THREADS_FIELD_NUMBER = 3;
        public static final int TIMESTAMP_FIELD_NUMBER = 4;
        private AppInfo appInfo_;
        private int bitField0_;
        private Exception exception_;
        private long timestamp_;
        private Internal.ProtobufList<Thread> threads_ = GeneratedMessageLite.emptyProtobufList();
        private String mappingFileId_ = "";

        public static final class AppInfo extends GeneratedMessageLite<AppInfo, Builder> implements AppInfoOrBuilder {
            public static final int BUILD_NUMBER_FIELD_NUMBER = 1;
            private static final AppInfo DEFAULT_INSTANCE;
            public static final int JS_VERSION_FIELD_NUMBER = 2;
            public static final int PACKAGE_NAME_FIELD_NUMBER = 3;
            private static volatile Parser<AppInfo> PARSER = null;
            public static final int VERSION_FIELD_NUMBER = 4;
            private int bitField0_;
            private String buildNumber_ = "";
            private String jsVersion_ = "";
            private String packageName_ = "";
            private String version_ = "";

            public static final class Builder extends GeneratedMessageLite.Builder<AppInfo, Builder> implements AppInfoOrBuilder {
                private Builder() {
                    super(AppInfo.DEFAULT_INSTANCE);
                }

                public Builder clearBuildNumber() {
                    copyOnWrite();
                    ((AppInfo) this.instance).clearBuildNumber();
                    return this;
                }

                public Builder clearJsVersion() {
                    copyOnWrite();
                    ((AppInfo) this.instance).clearJsVersion();
                    return this;
                }

                public Builder clearPackageName() {
                    copyOnWrite();
                    ((AppInfo) this.instance).clearPackageName();
                    return this;
                }

                public Builder clearVersion() {
                    copyOnWrite();
                    ((AppInfo) this.instance).clearVersion();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.AppInfoOrBuilder
                public String getBuildNumber() {
                    return ((AppInfo) this.instance).getBuildNumber();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.AppInfoOrBuilder
                public ByteString getBuildNumberBytes() {
                    return ((AppInfo) this.instance).getBuildNumberBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.AppInfoOrBuilder
                public String getJsVersion() {
                    return ((AppInfo) this.instance).getJsVersion();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.AppInfoOrBuilder
                public ByteString getJsVersionBytes() {
                    return ((AppInfo) this.instance).getJsVersionBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.AppInfoOrBuilder
                public String getPackageName() {
                    return ((AppInfo) this.instance).getPackageName();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.AppInfoOrBuilder
                public ByteString getPackageNameBytes() {
                    return ((AppInfo) this.instance).getPackageNameBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.AppInfoOrBuilder
                public String getVersion() {
                    return ((AppInfo) this.instance).getVersion();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.AppInfoOrBuilder
                public ByteString getVersionBytes() {
                    return ((AppInfo) this.instance).getVersionBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.AppInfoOrBuilder
                public boolean hasJsVersion() {
                    return ((AppInfo) this.instance).hasJsVersion();
                }

                public Builder setBuildNumber(String str) {
                    copyOnWrite();
                    ((AppInfo) this.instance).setBuildNumber(str);
                    return this;
                }

                public Builder setBuildNumberBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((AppInfo) this.instance).setBuildNumberBytes(byteString);
                    return this;
                }

                public Builder setJsVersion(String str) {
                    copyOnWrite();
                    ((AppInfo) this.instance).setJsVersion(str);
                    return this;
                }

                public Builder setJsVersionBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((AppInfo) this.instance).setJsVersionBytes(byteString);
                    return this;
                }

                public Builder setPackageName(String str) {
                    copyOnWrite();
                    ((AppInfo) this.instance).setPackageName(str);
                    return this;
                }

                public Builder setPackageNameBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((AppInfo) this.instance).setPackageNameBytes(byteString);
                    return this;
                }

                public Builder setVersion(String str) {
                    copyOnWrite();
                    ((AppInfo) this.instance).setVersion(str);
                    return this;
                }

                public Builder setVersionBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((AppInfo) this.instance).setVersionBytes(byteString);
                    return this;
                }
            }

            static {
                AppInfo appInfo = new AppInfo();
                DEFAULT_INSTANCE = appInfo;
                GeneratedMessageLite.registerDefaultInstance(AppInfo.class, appInfo);
            }

            private AppInfo() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearBuildNumber() {
                this.buildNumber_ = getDefaultInstance().getBuildNumber();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearJsVersion() {
                this.bitField0_ &= -2;
                this.jsVersion_ = getDefaultInstance().getJsVersion();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPackageName() {
                this.packageName_ = getDefaultInstance().getPackageName();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearVersion() {
                this.version_ = getDefaultInstance().getVersion();
            }

            public static AppInfo getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static AppInfo parseDelimitedFrom(InputStream inputStream) {
                return (AppInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static AppInfo parseFrom(ByteString byteString) {
                return (AppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<AppInfo> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBuildNumber(String str) {
                str.getClass();
                this.buildNumber_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBuildNumberBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.buildNumber_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setJsVersion(String str) {
                str.getClass();
                this.bitField0_ |= 1;
                this.jsVersion_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setJsVersionBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.jsVersion_ = byteString.toStringUtf8();
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPackageName(String str) {
                str.getClass();
                this.packageName_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPackageNameBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.packageName_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVersion(String str) {
                str.getClass();
                this.version_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVersionBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.version_ = byteString.toStringUtf8();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new AppInfo();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002ለ\u0000\u0003Ȉ\u0004Ȉ", new Object[]{"bitField0_", "buildNumber_", "jsVersion_", "packageName_", "version_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<AppInfo> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (AppInfo.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.AppInfoOrBuilder
            public String getBuildNumber() {
                return this.buildNumber_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.AppInfoOrBuilder
            public ByteString getBuildNumberBytes() {
                return ByteString.copyFromUtf8(this.buildNumber_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.AppInfoOrBuilder
            public String getJsVersion() {
                return this.jsVersion_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.AppInfoOrBuilder
            public ByteString getJsVersionBytes() {
                return ByteString.copyFromUtf8(this.jsVersion_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.AppInfoOrBuilder
            public String getPackageName() {
                return this.packageName_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.AppInfoOrBuilder
            public ByteString getPackageNameBytes() {
                return ByteString.copyFromUtf8(this.packageName_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.AppInfoOrBuilder
            public String getVersion() {
                return this.version_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.AppInfoOrBuilder
            public ByteString getVersionBytes() {
                return ByteString.copyFromUtf8(this.version_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.AppInfoOrBuilder
            public boolean hasJsVersion() {
                return (this.bitField0_ & 1) != 0;
            }

            public static Builder newBuilder(AppInfo appInfo) {
                return DEFAULT_INSTANCE.createBuilder(appInfo);
            }

            public static AppInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (AppInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static AppInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (AppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static AppInfo parseFrom(CodedInputStream codedInputStream) {
                return (AppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static AppInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (AppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static AppInfo parseFrom(InputStream inputStream) {
                return (AppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static AppInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (AppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static AppInfo parseFrom(ByteBuffer byteBuffer) {
                return (AppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static AppInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (AppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static AppInfo parseFrom(byte[] bArr) {
                return (AppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static AppInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (AppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface AppInfoOrBuilder extends MessageLiteOrBuilder {
            String getBuildNumber();

            ByteString getBuildNumberBytes();

            String getJsVersion();

            ByteString getJsVersionBytes();

            String getPackageName();

            ByteString getPackageNameBytes();

            String getVersion();

            ByteString getVersionBytes();

            boolean hasJsVersion();
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ReactNativeThreadReport, Builder> implements ReactNativeThreadReportOrBuilder {
            private Builder() {
                super(ReactNativeThreadReport.DEFAULT_INSTANCE);
            }

            public Builder addAllThreads(Iterable<? extends Thread> iterable) {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).addAllThreads(iterable);
                return this;
            }

            public Builder addThreads(int i, Thread.Builder builder) {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).addThreads(i, builder.build());
                return this;
            }

            public Builder clearAppInfo() {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).clearAppInfo();
                return this;
            }

            public Builder clearException() {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).clearException();
                return this;
            }

            public Builder clearMappingFileId() {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).clearMappingFileId();
                return this;
            }

            public Builder clearThreads() {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).clearThreads();
                return this;
            }

            public Builder clearTimestamp() {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).clearTimestamp();
                return this;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
            public AppInfo getAppInfo() {
                return ((ReactNativeThreadReport) this.instance).getAppInfo();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
            public Exception getException() {
                return ((ReactNativeThreadReport) this.instance).getException();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
            public String getMappingFileId() {
                return ((ReactNativeThreadReport) this.instance).getMappingFileId();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
            public ByteString getMappingFileIdBytes() {
                return ((ReactNativeThreadReport) this.instance).getMappingFileIdBytes();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
            public Thread getThreads(int i) {
                return ((ReactNativeThreadReport) this.instance).getThreads(i);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
            public int getThreadsCount() {
                return ((ReactNativeThreadReport) this.instance).getThreadsCount();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
            public List<Thread> getThreadsList() {
                return Collections.unmodifiableList(((ReactNativeThreadReport) this.instance).getThreadsList());
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
            public long getTimestamp() {
                return ((ReactNativeThreadReport) this.instance).getTimestamp();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
            public boolean hasAppInfo() {
                return ((ReactNativeThreadReport) this.instance).hasAppInfo();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
            public boolean hasException() {
                return ((ReactNativeThreadReport) this.instance).hasException();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
            public boolean hasMappingFileId() {
                return ((ReactNativeThreadReport) this.instance).hasMappingFileId();
            }

            public Builder mergeAppInfo(AppInfo appInfo) {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).mergeAppInfo(appInfo);
                return this;
            }

            public Builder mergeException(Exception exception) {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).mergeException(exception);
                return this;
            }

            public Builder removeThreads(int i) {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).removeThreads(i);
                return this;
            }

            public Builder setAppInfo(AppInfo.Builder builder) {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).setAppInfo(builder.build());
                return this;
            }

            public Builder setException(Exception.Builder builder) {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).setException(builder.build());
                return this;
            }

            public Builder setMappingFileId(String str) {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).setMappingFileId(str);
                return this;
            }

            public Builder setMappingFileIdBytes(ByteString byteString) throws IllegalArgumentException {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).setMappingFileIdBytes(byteString);
                return this;
            }

            public Builder setThreads(int i, Thread.Builder builder) {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).setThreads(i, builder.build());
                return this;
            }

            public Builder setTimestamp(long j) {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).setTimestamp(j);
                return this;
            }

            public Builder addThreads(int i, Thread thread) {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).addThreads(i, thread);
                return this;
            }

            public Builder setAppInfo(AppInfo appInfo) {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).setAppInfo(appInfo);
                return this;
            }

            public Builder setException(Exception exception) {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).setException(exception);
                return this;
            }

            public Builder setThreads(int i, Thread thread) {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).setThreads(i, thread);
                return this;
            }

            public Builder addThreads(Thread.Builder builder) {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).addThreads(builder.build());
                return this;
            }

            public Builder addThreads(Thread thread) {
                copyOnWrite();
                ((ReactNativeThreadReport) this.instance).addThreads(thread);
                return this;
            }
        }

        public static final class Exception extends GeneratedMessageLite<Exception, Builder> implements ExceptionOrBuilder {
            private static final Exception DEFAULT_INSTANCE;
            public static final int DESCRIPTION_FIELD_NUMBER = 1;
            public static final int FRAMES_FIELD_NUMBER = 2;
            private static volatile Parser<Exception> PARSER = null;
            public static final int TYPE_FIELD_NUMBER = 3;
            private String description_ = "";
            private Internal.ProtobufList<Frame> frames_ = GeneratedMessageLite.emptyProtobufList();
            private String type_ = "";

            public static final class Builder extends GeneratedMessageLite.Builder<Exception, Builder> implements ExceptionOrBuilder {
                private Builder() {
                    super(Exception.DEFAULT_INSTANCE);
                }

                public Builder addAllFrames(Iterable<? extends Frame> iterable) {
                    copyOnWrite();
                    ((Exception) this.instance).addAllFrames(iterable);
                    return this;
                }

                public Builder addFrames(int i, Frame.Builder builder) {
                    copyOnWrite();
                    ((Exception) this.instance).addFrames(i, builder.build());
                    return this;
                }

                public Builder clearDescription() {
                    copyOnWrite();
                    ((Exception) this.instance).clearDescription();
                    return this;
                }

                public Builder clearFrames() {
                    copyOnWrite();
                    ((Exception) this.instance).clearFrames();
                    return this;
                }

                public Builder clearType() {
                    copyOnWrite();
                    ((Exception) this.instance).clearType();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.ExceptionOrBuilder
                public String getDescription() {
                    return ((Exception) this.instance).getDescription();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.ExceptionOrBuilder
                public ByteString getDescriptionBytes() {
                    return ((Exception) this.instance).getDescriptionBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.ExceptionOrBuilder
                public Frame getFrames(int i) {
                    return ((Exception) this.instance).getFrames(i);
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.ExceptionOrBuilder
                public int getFramesCount() {
                    return ((Exception) this.instance).getFramesCount();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.ExceptionOrBuilder
                public List<Frame> getFramesList() {
                    return Collections.unmodifiableList(((Exception) this.instance).getFramesList());
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.ExceptionOrBuilder
                public String getType() {
                    return ((Exception) this.instance).getType();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.ExceptionOrBuilder
                public ByteString getTypeBytes() {
                    return ((Exception) this.instance).getTypeBytes();
                }

                public Builder removeFrames(int i) {
                    copyOnWrite();
                    ((Exception) this.instance).removeFrames(i);
                    return this;
                }

                public Builder setDescription(String str) {
                    copyOnWrite();
                    ((Exception) this.instance).setDescription(str);
                    return this;
                }

                public Builder setDescriptionBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((Exception) this.instance).setDescriptionBytes(byteString);
                    return this;
                }

                public Builder setFrames(int i, Frame.Builder builder) {
                    copyOnWrite();
                    ((Exception) this.instance).setFrames(i, builder.build());
                    return this;
                }

                public Builder setType(String str) {
                    copyOnWrite();
                    ((Exception) this.instance).setType(str);
                    return this;
                }

                public Builder setTypeBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((Exception) this.instance).setTypeBytes(byteString);
                    return this;
                }

                public Builder addFrames(int i, Frame frame) {
                    copyOnWrite();
                    ((Exception) this.instance).addFrames(i, frame);
                    return this;
                }

                public Builder setFrames(int i, Frame frame) {
                    copyOnWrite();
                    ((Exception) this.instance).setFrames(i, frame);
                    return this;
                }

                public Builder addFrames(Frame.Builder builder) {
                    copyOnWrite();
                    ((Exception) this.instance).addFrames(builder.build());
                    return this;
                }

                public Builder addFrames(Frame frame) {
                    copyOnWrite();
                    ((Exception) this.instance).addFrames(frame);
                    return this;
                }
            }

            static {
                Exception exception = new Exception();
                DEFAULT_INSTANCE = exception;
                GeneratedMessageLite.registerDefaultInstance(Exception.class, exception);
            }

            private Exception() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllFrames(Iterable<? extends Frame> iterable) {
                ensureFramesIsMutable();
                AbstractMessageLite.addAll(iterable, this.frames_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addFrames(int i, Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.add(i, frame);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearDescription() {
                this.description_ = getDefaultInstance().getDescription();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFrames() {
                this.frames_ = GeneratedMessageLite.emptyProtobufList();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearType() {
                this.type_ = getDefaultInstance().getType();
            }

            private void ensureFramesIsMutable() {
                Internal.ProtobufList<Frame> protobufList = this.frames_;
                if (protobufList.isModifiable()) {
                    return;
                }
                this.frames_ = GeneratedMessageLite.mutableCopy(protobufList);
            }

            public static Exception getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Exception parseDelimitedFrom(InputStream inputStream) {
                return (Exception) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Exception parseFrom(ByteString byteString) {
                return (Exception) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<Exception> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void removeFrames(int i) {
                ensureFramesIsMutable();
                this.frames_.remove(i);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDescription(String str) {
                str.getClass();
                this.description_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDescriptionBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.description_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFrames(int i, Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.set(i, frame);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setType(String str) {
                str.getClass();
                this.type_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setTypeBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.type_ = byteString.toStringUtf8();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new Exception();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003Ȉ", new Object[]{"description_", "frames_", Frame.class, "type_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Exception> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Exception.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.ExceptionOrBuilder
            public String getDescription() {
                return this.description_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.ExceptionOrBuilder
            public ByteString getDescriptionBytes() {
                return ByteString.copyFromUtf8(this.description_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.ExceptionOrBuilder
            public Frame getFrames(int i) {
                return this.frames_.get(i);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.ExceptionOrBuilder
            public int getFramesCount() {
                return this.frames_.size();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.ExceptionOrBuilder
            public List<Frame> getFramesList() {
                return this.frames_;
            }

            public FrameOrBuilder getFramesOrBuilder(int i) {
                return this.frames_.get(i);
            }

            public List<? extends FrameOrBuilder> getFramesOrBuilderList() {
                return this.frames_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.ExceptionOrBuilder
            public String getType() {
                return this.type_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.ExceptionOrBuilder
            public ByteString getTypeBytes() {
                return ByteString.copyFromUtf8(this.type_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addFrames(Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.add(frame);
            }

            public static Builder newBuilder(Exception exception) {
                return DEFAULT_INSTANCE.createBuilder(exception);
            }

            public static Exception parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Exception) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Exception parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (Exception) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Exception parseFrom(CodedInputStream codedInputStream) {
                return (Exception) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Exception parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Exception) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Exception parseFrom(InputStream inputStream) {
                return (Exception) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Exception parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Exception) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Exception parseFrom(ByteBuffer byteBuffer) {
                return (Exception) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Exception parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (Exception) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Exception parseFrom(byte[] bArr) {
                return (Exception) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Exception parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (Exception) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface ExceptionOrBuilder extends MessageLiteOrBuilder {
            String getDescription();

            ByteString getDescriptionBytes();

            Frame getFrames(int i);

            int getFramesCount();

            List<Frame> getFramesList();

            String getType();

            ByteString getTypeBytes();
        }

        public static final class Frame extends GeneratedMessageLite<Frame, Builder> implements FrameOrBuilder {
            public static final int COLUMN_FIELD_NUMBER = 1;
            public static final int C_CONTEXT_LINE_FIELD_NUMBER = 6;
            private static final Frame DEFAULT_INSTANCE;
            public static final int FILE_FIELD_NUMBER = 2;
            public static final int FRAME_ID_FIELD_NUMBER = 3;
            public static final int LINE_NUMBER_FIELD_NUMBER = 4;
            public static final int METHOD_NAME_FIELD_NUMBER = 5;
            private static volatile Parser<Frame> PARSER;
            private int bitField0_;
            private int column_;
            private int frameId_;
            private int lineNumber_;
            private String file_ = "";
            private String methodName_ = "";
            private String cContextLine_ = "";

            public static final class Builder extends GeneratedMessageLite.Builder<Frame, Builder> implements FrameOrBuilder {
                private Builder() {
                    super(Frame.DEFAULT_INSTANCE);
                }

                public Builder clearCContextLine() {
                    copyOnWrite();
                    ((Frame) this.instance).clearCContextLine();
                    return this;
                }

                public Builder clearColumn() {
                    copyOnWrite();
                    ((Frame) this.instance).clearColumn();
                    return this;
                }

                public Builder clearFile() {
                    copyOnWrite();
                    ((Frame) this.instance).clearFile();
                    return this;
                }

                public Builder clearFrameId() {
                    copyOnWrite();
                    ((Frame) this.instance).clearFrameId();
                    return this;
                }

                public Builder clearLineNumber() {
                    copyOnWrite();
                    ((Frame) this.instance).clearLineNumber();
                    return this;
                }

                public Builder clearMethodName() {
                    copyOnWrite();
                    ((Frame) this.instance).clearMethodName();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.FrameOrBuilder
                public String getCContextLine() {
                    return ((Frame) this.instance).getCContextLine();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.FrameOrBuilder
                public ByteString getCContextLineBytes() {
                    return ((Frame) this.instance).getCContextLineBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.FrameOrBuilder
                public int getColumn() {
                    return ((Frame) this.instance).getColumn();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.FrameOrBuilder
                public String getFile() {
                    return ((Frame) this.instance).getFile();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.FrameOrBuilder
                public ByteString getFileBytes() {
                    return ((Frame) this.instance).getFileBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.FrameOrBuilder
                public int getFrameId() {
                    return ((Frame) this.instance).getFrameId();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.FrameOrBuilder
                public int getLineNumber() {
                    return ((Frame) this.instance).getLineNumber();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.FrameOrBuilder
                public String getMethodName() {
                    return ((Frame) this.instance).getMethodName();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.FrameOrBuilder
                public ByteString getMethodNameBytes() {
                    return ((Frame) this.instance).getMethodNameBytes();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.FrameOrBuilder
                public boolean hasCContextLine() {
                    return ((Frame) this.instance).hasCContextLine();
                }

                public Builder setCContextLine(String str) {
                    copyOnWrite();
                    ((Frame) this.instance).setCContextLine(str);
                    return this;
                }

                public Builder setCContextLineBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((Frame) this.instance).setCContextLineBytes(byteString);
                    return this;
                }

                public Builder setColumn(int i) {
                    copyOnWrite();
                    ((Frame) this.instance).setColumn(i);
                    return this;
                }

                public Builder setFile(String str) {
                    copyOnWrite();
                    ((Frame) this.instance).setFile(str);
                    return this;
                }

                public Builder setFileBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((Frame) this.instance).setFileBytes(byteString);
                    return this;
                }

                public Builder setFrameId(int i) {
                    copyOnWrite();
                    ((Frame) this.instance).setFrameId(i);
                    return this;
                }

                public Builder setLineNumber(int i) {
                    copyOnWrite();
                    ((Frame) this.instance).setLineNumber(i);
                    return this;
                }

                public Builder setMethodName(String str) {
                    copyOnWrite();
                    ((Frame) this.instance).setMethodName(str);
                    return this;
                }

                public Builder setMethodNameBytes(ByteString byteString) throws IllegalArgumentException {
                    copyOnWrite();
                    ((Frame) this.instance).setMethodNameBytes(byteString);
                    return this;
                }
            }

            static {
                Frame frame = new Frame();
                DEFAULT_INSTANCE = frame;
                GeneratedMessageLite.registerDefaultInstance(Frame.class, frame);
            }

            private Frame() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCContextLine() {
                this.bitField0_ &= -2;
                this.cContextLine_ = getDefaultInstance().getCContextLine();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearColumn() {
                this.column_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFile() {
                this.file_ = getDefaultInstance().getFile();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFrameId() {
                this.frameId_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLineNumber() {
                this.lineNumber_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMethodName() {
                this.methodName_ = getDefaultInstance().getMethodName();
            }

            public static Frame getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Frame parseDelimitedFrom(InputStream inputStream) {
                return (Frame) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Frame parseFrom(ByteString byteString) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<Frame> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCContextLine(String str) {
                str.getClass();
                this.bitField0_ |= 1;
                this.cContextLine_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCContextLineBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.cContextLine_ = byteString.toStringUtf8();
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setColumn(int i) {
                this.column_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFile(String str) {
                str.getClass();
                this.file_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFileBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.file_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFrameId(int i) {
                this.frameId_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLineNumber(int i) {
                this.lineNumber_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMethodName(String str) {
                str.getClass();
                this.methodName_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMethodNameBytes(ByteString byteString) throws IllegalArgumentException {
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.methodName_ = byteString.toStringUtf8();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new Frame();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u000b\u0002Ȉ\u0003\u000b\u0004\u000b\u0005Ȉ\u0006ለ\u0000", new Object[]{"bitField0_", "column_", "file_", "frameId_", "lineNumber_", "methodName_", "cContextLine_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Frame> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Frame.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.FrameOrBuilder
            public String getCContextLine() {
                return this.cContextLine_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.FrameOrBuilder
            public ByteString getCContextLineBytes() {
                return ByteString.copyFromUtf8(this.cContextLine_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.FrameOrBuilder
            public int getColumn() {
                return this.column_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.FrameOrBuilder
            public String getFile() {
                return this.file_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.FrameOrBuilder
            public ByteString getFileBytes() {
                return ByteString.copyFromUtf8(this.file_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.FrameOrBuilder
            public int getFrameId() {
                return this.frameId_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.FrameOrBuilder
            public int getLineNumber() {
                return this.lineNumber_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.FrameOrBuilder
            public String getMethodName() {
                return this.methodName_;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.FrameOrBuilder
            public ByteString getMethodNameBytes() {
                return ByteString.copyFromUtf8(this.methodName_);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.FrameOrBuilder
            public boolean hasCContextLine() {
                return (this.bitField0_ & 1) != 0;
            }

            public static Builder newBuilder(Frame frame) {
                return DEFAULT_INSTANCE.createBuilder(frame);
            }

            public static Frame parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Frame parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Frame parseFrom(CodedInputStream codedInputStream) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Frame parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Frame parseFrom(InputStream inputStream) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Frame parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Frame parseFrom(ByteBuffer byteBuffer) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Frame parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Frame parseFrom(byte[] bArr) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Frame parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (Frame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface FrameOrBuilder extends MessageLiteOrBuilder {
            String getCContextLine();

            ByteString getCContextLineBytes();

            int getColumn();

            String getFile();

            ByteString getFileBytes();

            int getFrameId();

            int getLineNumber();

            String getMethodName();

            ByteString getMethodNameBytes();

            boolean hasCContextLine();
        }

        public static final class Thread extends GeneratedMessageLite<Thread, Builder> implements ThreadOrBuilder {
            private static final Thread DEFAULT_INSTANCE;
            public static final int FRAMES_FIELD_NUMBER = 1;
            private static volatile Parser<Thread> PARSER;
            private Internal.ProtobufList<Frame> frames_ = GeneratedMessageLite.emptyProtobufList();

            public static final class Builder extends GeneratedMessageLite.Builder<Thread, Builder> implements ThreadOrBuilder {
                private Builder() {
                    super(Thread.DEFAULT_INSTANCE);
                }

                public Builder addAllFrames(Iterable<? extends Frame> iterable) {
                    copyOnWrite();
                    ((Thread) this.instance).addAllFrames(iterable);
                    return this;
                }

                public Builder addFrames(int i, Frame.Builder builder) {
                    copyOnWrite();
                    ((Thread) this.instance).addFrames(i, builder.build());
                    return this;
                }

                public Builder clearFrames() {
                    copyOnWrite();
                    ((Thread) this.instance).clearFrames();
                    return this;
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.ThreadOrBuilder
                public Frame getFrames(int i) {
                    return ((Thread) this.instance).getFrames(i);
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.ThreadOrBuilder
                public int getFramesCount() {
                    return ((Thread) this.instance).getFramesCount();
                }

                @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.ThreadOrBuilder
                public List<Frame> getFramesList() {
                    return Collections.unmodifiableList(((Thread) this.instance).getFramesList());
                }

                public Builder removeFrames(int i) {
                    copyOnWrite();
                    ((Thread) this.instance).removeFrames(i);
                    return this;
                }

                public Builder setFrames(int i, Frame.Builder builder) {
                    copyOnWrite();
                    ((Thread) this.instance).setFrames(i, builder.build());
                    return this;
                }

                public Builder addFrames(int i, Frame frame) {
                    copyOnWrite();
                    ((Thread) this.instance).addFrames(i, frame);
                    return this;
                }

                public Builder setFrames(int i, Frame frame) {
                    copyOnWrite();
                    ((Thread) this.instance).setFrames(i, frame);
                    return this;
                }

                public Builder addFrames(Frame.Builder builder) {
                    copyOnWrite();
                    ((Thread) this.instance).addFrames(builder.build());
                    return this;
                }

                public Builder addFrames(Frame frame) {
                    copyOnWrite();
                    ((Thread) this.instance).addFrames(frame);
                    return this;
                }
            }

            static {
                Thread thread = new Thread();
                DEFAULT_INSTANCE = thread;
                GeneratedMessageLite.registerDefaultInstance(Thread.class, thread);
            }

            private Thread() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllFrames(Iterable<? extends Frame> iterable) {
                ensureFramesIsMutable();
                AbstractMessageLite.addAll(iterable, this.frames_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addFrames(int i, Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.add(i, frame);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFrames() {
                this.frames_ = GeneratedMessageLite.emptyProtobufList();
            }

            private void ensureFramesIsMutable() {
                Internal.ProtobufList<Frame> protobufList = this.frames_;
                if (protobufList.isModifiable()) {
                    return;
                }
                this.frames_ = GeneratedMessageLite.mutableCopy(protobufList);
            }

            public static Thread getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Thread parseDelimitedFrom(InputStream inputStream) {
                return (Thread) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Thread parseFrom(ByteString byteString) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Parser<Thread> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void removeFrames(int i) {
                ensureFramesIsMutable();
                this.frames_.remove(i);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFrames(int i, Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.set(i, frame);
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
                switch (i) {
                    case 1:
                        return new Thread();
                    case 2:
                        return new Builder();
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"frames_", Frame.class});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Thread> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Thread.class) {
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

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.ThreadOrBuilder
            public Frame getFrames(int i) {
                return this.frames_.get(i);
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.ThreadOrBuilder
            public int getFramesCount() {
                return this.frames_.size();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReport.ThreadOrBuilder
            public List<Frame> getFramesList() {
                return this.frames_;
            }

            public FrameOrBuilder getFramesOrBuilder(int i) {
                return this.frames_.get(i);
            }

            public List<? extends FrameOrBuilder> getFramesOrBuilderList() {
                return this.frames_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addFrames(Frame frame) {
                frame.getClass();
                ensureFramesIsMutable();
                this.frames_.add(frame);
            }

            public static Builder newBuilder(Thread thread) {
                return DEFAULT_INSTANCE.createBuilder(thread);
            }

            public static Thread parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Thread parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Thread parseFrom(CodedInputStream codedInputStream) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Thread parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Thread parseFrom(InputStream inputStream) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Thread parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Thread parseFrom(ByteBuffer byteBuffer) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Thread parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Thread parseFrom(byte[] bArr) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Thread parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (Thread) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }
        }

        public interface ThreadOrBuilder extends MessageLiteOrBuilder {
            Frame getFrames(int i);

            int getFramesCount();

            List<Frame> getFramesList();
        }

        static {
            ReactNativeThreadReport reactNativeThreadReport = new ReactNativeThreadReport();
            DEFAULT_INSTANCE = reactNativeThreadReport;
            GeneratedMessageLite.registerDefaultInstance(ReactNativeThreadReport.class, reactNativeThreadReport);
        }

        private ReactNativeThreadReport() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllThreads(Iterable<? extends Thread> iterable) {
            ensureThreadsIsMutable();
            AbstractMessageLite.addAll(iterable, this.threads_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addThreads(int i, Thread thread) {
            thread.getClass();
            ensureThreadsIsMutable();
            this.threads_.add(i, thread);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppInfo() {
            this.appInfo_ = null;
            this.bitField0_ &= -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearException() {
            this.exception_ = null;
            this.bitField0_ &= -3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMappingFileId() {
            this.bitField0_ &= -5;
            this.mappingFileId_ = getDefaultInstance().getMappingFileId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearThreads() {
            this.threads_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimestamp() {
            this.timestamp_ = 0L;
        }

        private void ensureThreadsIsMutable() {
            Internal.ProtobufList<Thread> protobufList = this.threads_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.threads_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static ReactNativeThreadReport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAppInfo(AppInfo appInfo) {
            appInfo.getClass();
            AppInfo appInfo2 = this.appInfo_;
            if (appInfo2 != null && appInfo2 != AppInfo.getDefaultInstance()) {
                appInfo = AppInfo.newBuilder(this.appInfo_).mergeFrom((AppInfo.Builder) appInfo).buildPartial();
            }
            this.appInfo_ = appInfo;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeException(Exception exception) {
            exception.getClass();
            Exception exception2 = this.exception_;
            if (exception2 != null && exception2 != Exception.getDefaultInstance()) {
                exception = Exception.newBuilder(this.exception_).mergeFrom((Exception.Builder) exception).buildPartial();
            }
            this.exception_ = exception;
            this.bitField0_ |= 2;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ReactNativeThreadReport parseDelimitedFrom(InputStream inputStream) {
            return (ReactNativeThreadReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReactNativeThreadReport parseFrom(ByteString byteString) {
            return (ReactNativeThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<ReactNativeThreadReport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeThreads(int i) {
            ensureThreadsIsMutable();
            this.threads_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppInfo(AppInfo appInfo) {
            appInfo.getClass();
            this.appInfo_ = appInfo;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setException(Exception exception) {
            exception.getClass();
            this.exception_ = exception;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMappingFileId(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.mappingFileId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMappingFileIdBytes(ByteString byteString) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.mappingFileId_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setThreads(int i, Thread thread) {
            thread.getClass();
            ensureThreadsIsMutable();
            this.threads_.set(i, thread);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimestamp(long j) {
            this.timestamp_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new ReactNativeThreadReport();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b\u0004\u0003\u0005ለ\u0002", new Object[]{"bitField0_", "appInfo_", "exception_", "threads_", Thread.class, "timestamp_", "mappingFileId_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ReactNativeThreadReport> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (ReactNativeThreadReport.class) {
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

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
        public AppInfo getAppInfo() {
            AppInfo appInfo = this.appInfo_;
            return appInfo == null ? AppInfo.getDefaultInstance() : appInfo;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
        public Exception getException() {
            Exception exception = this.exception_;
            return exception == null ? Exception.getDefaultInstance() : exception;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
        public String getMappingFileId() {
            return this.mappingFileId_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
        public ByteString getMappingFileIdBytes() {
            return ByteString.copyFromUtf8(this.mappingFileId_);
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
        public Thread getThreads(int i) {
            return this.threads_.get(i);
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
        public int getThreadsCount() {
            return this.threads_.size();
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
        public List<Thread> getThreadsList() {
            return this.threads_;
        }

        public ThreadOrBuilder getThreadsOrBuilder(int i) {
            return this.threads_.get(i);
        }

        public List<? extends ThreadOrBuilder> getThreadsOrBuilderList() {
            return this.threads_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
        public boolean hasAppInfo() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
        public boolean hasException() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ReactNativeThreadReportOrBuilder
        public boolean hasMappingFileId() {
            return (this.bitField0_ & 4) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addThreads(Thread thread) {
            thread.getClass();
            ensureThreadsIsMutable();
            this.threads_.add(thread);
        }

        public static Builder newBuilder(ReactNativeThreadReport reactNativeThreadReport) {
            return DEFAULT_INSTANCE.createBuilder(reactNativeThreadReport);
        }

        public static ReactNativeThreadReport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReactNativeThreadReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReactNativeThreadReport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ReactNativeThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReactNativeThreadReport parseFrom(CodedInputStream codedInputStream) {
            return (ReactNativeThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReactNativeThreadReport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReactNativeThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ReactNativeThreadReport parseFrom(InputStream inputStream) {
            return (ReactNativeThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReactNativeThreadReport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReactNativeThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReactNativeThreadReport parseFrom(ByteBuffer byteBuffer) {
            return (ReactNativeThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ReactNativeThreadReport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ReactNativeThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ReactNativeThreadReport parseFrom(byte[] bArr) {
            return (ReactNativeThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ReactNativeThreadReport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ReactNativeThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface ReactNativeThreadReportOrBuilder extends MessageLiteOrBuilder {
        ReactNativeThreadReport.AppInfo getAppInfo();

        ReactNativeThreadReport.Exception getException();

        String getMappingFileId();

        ByteString getMappingFileIdBytes();

        ReactNativeThreadReport.Thread getThreads(int i);

        int getThreadsCount();

        List<ReactNativeThreadReport.Thread> getThreadsList();

        long getTimestamp();

        boolean hasAppInfo();

        boolean hasException();

        boolean hasMappingFileId();
    }

    public static final class ThreadReport extends GeneratedMessageLite<ThreadReport, Builder> implements ThreadReportOrBuilder {
        public static final int ANDROID_FIELD_NUMBER = 2;
        private static final ThreadReport DEFAULT_INSTANCE;
        public static final int EMPTY_REPORT_FIELD_NUMBER = 3;
        public static final int FLUTTER_FIELD_NUMBER = 4;
        public static final int IOS_FIELD_NUMBER = 1;
        private static volatile Parser<ThreadReport> PARSER = null;
        public static final int REACT_NATIVE_FIELD_NUMBER = 5;
        private int reportCase_ = 0;
        private Object report_;

        public static final class Builder extends GeneratedMessageLite.Builder<ThreadReport, Builder> implements ThreadReportOrBuilder {
            private Builder() {
                super(ThreadReport.DEFAULT_INSTANCE);
            }

            public Builder clearAndroid() {
                copyOnWrite();
                ((ThreadReport) this.instance).clearAndroid();
                return this;
            }

            public Builder clearEmptyReport() {
                copyOnWrite();
                ((ThreadReport) this.instance).clearEmptyReport();
                return this;
            }

            public Builder clearFlutter() {
                copyOnWrite();
                ((ThreadReport) this.instance).clearFlutter();
                return this;
            }

            public Builder clearIos() {
                copyOnWrite();
                ((ThreadReport) this.instance).clearIos();
                return this;
            }

            public Builder clearReactNative() {
                copyOnWrite();
                ((ThreadReport) this.instance).clearReactNative();
                return this;
            }

            public Builder clearReport() {
                copyOnWrite();
                ((ThreadReport) this.instance).clearReport();
                return this;
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
            public AndroidThreadReport getAndroid() {
                return ((ThreadReport) this.instance).getAndroid();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
            public EmptyThreadReport getEmptyReport() {
                return ((ThreadReport) this.instance).getEmptyReport();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
            public FlutterThreadReport getFlutter() {
                return ((ThreadReport) this.instance).getFlutter();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
            public IOSThreadReport getIos() {
                return ((ThreadReport) this.instance).getIos();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
            public ReactNativeThreadReport getReactNative() {
                return ((ThreadReport) this.instance).getReactNative();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
            public ReportCase getReportCase() {
                return ((ThreadReport) this.instance).getReportCase();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
            public boolean hasAndroid() {
                return ((ThreadReport) this.instance).hasAndroid();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
            public boolean hasEmptyReport() {
                return ((ThreadReport) this.instance).hasEmptyReport();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
            public boolean hasFlutter() {
                return ((ThreadReport) this.instance).hasFlutter();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
            public boolean hasIos() {
                return ((ThreadReport) this.instance).hasIos();
            }

            @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
            public boolean hasReactNative() {
                return ((ThreadReport) this.instance).hasReactNative();
            }

            public Builder mergeAndroid(AndroidThreadReport androidThreadReport) {
                copyOnWrite();
                ((ThreadReport) this.instance).mergeAndroid(androidThreadReport);
                return this;
            }

            public Builder mergeEmptyReport(EmptyThreadReport emptyThreadReport) {
                copyOnWrite();
                ((ThreadReport) this.instance).mergeEmptyReport(emptyThreadReport);
                return this;
            }

            public Builder mergeFlutter(FlutterThreadReport flutterThreadReport) {
                copyOnWrite();
                ((ThreadReport) this.instance).mergeFlutter(flutterThreadReport);
                return this;
            }

            public Builder mergeIos(IOSThreadReport iOSThreadReport) {
                copyOnWrite();
                ((ThreadReport) this.instance).mergeIos(iOSThreadReport);
                return this;
            }

            public Builder mergeReactNative(ReactNativeThreadReport reactNativeThreadReport) {
                copyOnWrite();
                ((ThreadReport) this.instance).mergeReactNative(reactNativeThreadReport);
                return this;
            }

            public Builder setAndroid(AndroidThreadReport.Builder builder) {
                copyOnWrite();
                ((ThreadReport) this.instance).setAndroid(builder.build());
                return this;
            }

            public Builder setEmptyReport(EmptyThreadReport.Builder builder) {
                copyOnWrite();
                ((ThreadReport) this.instance).setEmptyReport(builder.build());
                return this;
            }

            public Builder setFlutter(FlutterThreadReport.Builder builder) {
                copyOnWrite();
                ((ThreadReport) this.instance).setFlutter(builder.build());
                return this;
            }

            public Builder setIos(IOSThreadReport.Builder builder) {
                copyOnWrite();
                ((ThreadReport) this.instance).setIos(builder.build());
                return this;
            }

            public Builder setReactNative(ReactNativeThreadReport.Builder builder) {
                copyOnWrite();
                ((ThreadReport) this.instance).setReactNative(builder.build());
                return this;
            }

            public Builder setAndroid(AndroidThreadReport androidThreadReport) {
                copyOnWrite();
                ((ThreadReport) this.instance).setAndroid(androidThreadReport);
                return this;
            }

            public Builder setEmptyReport(EmptyThreadReport emptyThreadReport) {
                copyOnWrite();
                ((ThreadReport) this.instance).setEmptyReport(emptyThreadReport);
                return this;
            }

            public Builder setFlutter(FlutterThreadReport flutterThreadReport) {
                copyOnWrite();
                ((ThreadReport) this.instance).setFlutter(flutterThreadReport);
                return this;
            }

            public Builder setIos(IOSThreadReport iOSThreadReport) {
                copyOnWrite();
                ((ThreadReport) this.instance).setIos(iOSThreadReport);
                return this;
            }

            public Builder setReactNative(ReactNativeThreadReport reactNativeThreadReport) {
                copyOnWrite();
                ((ThreadReport) this.instance).setReactNative(reactNativeThreadReport);
                return this;
            }
        }

        public enum ReportCase {
            IOS(1),
            ANDROID(2),
            EMPTY_REPORT(3),
            FLUTTER(4),
            REACT_NATIVE(5),
            REPORT_NOT_SET(0);

            private final int value;

            ReportCase(int i) {
                this.value = i;
            }

            public static ReportCase forNumber(int i) {
                if (i == 0) {
                    return REPORT_NOT_SET;
                }
                if (i == 1) {
                    return IOS;
                }
                if (i == 2) {
                    return ANDROID;
                }
                if (i == 3) {
                    return EMPTY_REPORT;
                }
                if (i == 4) {
                    return FLUTTER;
                }
                if (i != 5) {
                    return null;
                }
                return REACT_NATIVE;
            }

            @Deprecated
            public static ReportCase valueOf(int i) {
                return forNumber(i);
            }

            public int getNumber() {
                return this.value;
            }
        }

        static {
            ThreadReport threadReport = new ThreadReport();
            DEFAULT_INSTANCE = threadReport;
            GeneratedMessageLite.registerDefaultInstance(ThreadReport.class, threadReport);
        }

        private ThreadReport() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAndroid() {
            if (this.reportCase_ == 2) {
                this.reportCase_ = 0;
                this.report_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEmptyReport() {
            if (this.reportCase_ == 3) {
                this.reportCase_ = 0;
                this.report_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFlutter() {
            if (this.reportCase_ == 4) {
                this.reportCase_ = 0;
                this.report_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIos() {
            if (this.reportCase_ == 1) {
                this.reportCase_ = 0;
                this.report_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReactNative() {
            if (this.reportCase_ == 5) {
                this.reportCase_ = 0;
                this.report_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReport() {
            this.reportCase_ = 0;
            this.report_ = null;
        }

        public static ThreadReport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAndroid(AndroidThreadReport androidThreadReport) {
            androidThreadReport.getClass();
            if (this.reportCase_ == 2 && this.report_ != AndroidThreadReport.getDefaultInstance()) {
                androidThreadReport = AndroidThreadReport.newBuilder((AndroidThreadReport) this.report_).mergeFrom((AndroidThreadReport.Builder) androidThreadReport).buildPartial();
            }
            this.report_ = androidThreadReport;
            this.reportCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeEmptyReport(EmptyThreadReport emptyThreadReport) {
            emptyThreadReport.getClass();
            if (this.reportCase_ == 3 && this.report_ != EmptyThreadReport.getDefaultInstance()) {
                emptyThreadReport = EmptyThreadReport.newBuilder((EmptyThreadReport) this.report_).mergeFrom((EmptyThreadReport.Builder) emptyThreadReport).buildPartial();
            }
            this.report_ = emptyThreadReport;
            this.reportCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeFlutter(FlutterThreadReport flutterThreadReport) {
            flutterThreadReport.getClass();
            if (this.reportCase_ == 4 && this.report_ != FlutterThreadReport.getDefaultInstance()) {
                flutterThreadReport = FlutterThreadReport.newBuilder((FlutterThreadReport) this.report_).mergeFrom((FlutterThreadReport.Builder) flutterThreadReport).buildPartial();
            }
            this.report_ = flutterThreadReport;
            this.reportCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeIos(IOSThreadReport iOSThreadReport) {
            iOSThreadReport.getClass();
            if (this.reportCase_ == 1 && this.report_ != IOSThreadReport.getDefaultInstance()) {
                iOSThreadReport = IOSThreadReport.newBuilder((IOSThreadReport) this.report_).mergeFrom((IOSThreadReport.Builder) iOSThreadReport).buildPartial();
            }
            this.report_ = iOSThreadReport;
            this.reportCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeReactNative(ReactNativeThreadReport reactNativeThreadReport) {
            reactNativeThreadReport.getClass();
            if (this.reportCase_ == 5 && this.report_ != ReactNativeThreadReport.getDefaultInstance()) {
                reactNativeThreadReport = ReactNativeThreadReport.newBuilder((ReactNativeThreadReport) this.report_).mergeFrom((ReactNativeThreadReport.Builder) reactNativeThreadReport).buildPartial();
            }
            this.report_ = reactNativeThreadReport;
            this.reportCase_ = 5;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ThreadReport parseDelimitedFrom(InputStream inputStream) {
            return (ThreadReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ThreadReport parseFrom(ByteString byteString) {
            return (ThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Parser<ThreadReport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAndroid(AndroidThreadReport androidThreadReport) {
            androidThreadReport.getClass();
            this.report_ = androidThreadReport;
            this.reportCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEmptyReport(EmptyThreadReport emptyThreadReport) {
            emptyThreadReport.getClass();
            this.report_ = emptyThreadReport;
            this.reportCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFlutter(FlutterThreadReport flutterThreadReport) {
            flutterThreadReport.getClass();
            this.report_ = flutterThreadReport;
            this.reportCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIos(IOSThreadReport iOSThreadReport) {
            iOSThreadReport.getClass();
            this.report_ = iOSThreadReport;
            this.reportCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReactNative(ReactNativeThreadReport reactNativeThreadReport) {
            reactNativeThreadReport.getClass();
            this.report_ = reactNativeThreadReport;
            this.reportCase_ = 5;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            switch (i) {
                case 1:
                    return new ThreadReport();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0001\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000", new Object[]{"report_", "reportCase_", IOSThreadReport.class, AndroidThreadReport.class, EmptyThreadReport.class, FlutterThreadReport.class, ReactNativeThreadReport.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ThreadReport> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (ThreadReport.class) {
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

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
        public AndroidThreadReport getAndroid() {
            return this.reportCase_ == 2 ? (AndroidThreadReport) this.report_ : AndroidThreadReport.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
        public EmptyThreadReport getEmptyReport() {
            return this.reportCase_ == 3 ? (EmptyThreadReport) this.report_ : EmptyThreadReport.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
        public FlutterThreadReport getFlutter() {
            return this.reportCase_ == 4 ? (FlutterThreadReport) this.report_ : FlutterThreadReport.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
        public IOSThreadReport getIos() {
            return this.reportCase_ == 1 ? (IOSThreadReport) this.report_ : IOSThreadReport.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
        public ReactNativeThreadReport getReactNative() {
            return this.reportCase_ == 5 ? (ReactNativeThreadReport) this.report_ : ReactNativeThreadReport.getDefaultInstance();
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
        public ReportCase getReportCase() {
            return ReportCase.forNumber(this.reportCase_);
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
        public boolean hasAndroid() {
            return this.reportCase_ == 2;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
        public boolean hasEmptyReport() {
            return this.reportCase_ == 3;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
        public boolean hasFlutter() {
            return this.reportCase_ == 4;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
        public boolean hasIos() {
            return this.reportCase_ == 1;
        }

        @Override // com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace.ThreadReportOrBuilder
        public boolean hasReactNative() {
            return this.reportCase_ == 5;
        }

        public static Builder newBuilder(ThreadReport threadReport) {
            return DEFAULT_INSTANCE.createBuilder(threadReport);
        }

        public static ThreadReport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ThreadReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ThreadReport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ThreadReport parseFrom(CodedInputStream codedInputStream) {
            return (ThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ThreadReport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ThreadReport parseFrom(InputStream inputStream) {
            return (ThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ThreadReport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ThreadReport parseFrom(ByteBuffer byteBuffer) {
            return (ThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ThreadReport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ThreadReport parseFrom(byte[] bArr) {
            return (ThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ThreadReport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ThreadReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }
    }

    public interface ThreadReportOrBuilder extends MessageLiteOrBuilder {
        AndroidThreadReport getAndroid();

        EmptyThreadReport getEmptyReport();

        FlutterThreadReport getFlutter();

        IOSThreadReport getIos();

        ReactNativeThreadReport getReactNative();

        ThreadReport.ReportCase getReportCase();

        boolean hasAndroid();

        boolean hasEmptyReport();

        boolean hasFlutter();

        boolean hasIos();

        boolean hasReactNative();
    }

    private MobileStacktrace() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
