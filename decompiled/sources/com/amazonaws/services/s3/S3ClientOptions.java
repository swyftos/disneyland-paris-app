package com.amazonaws.services.s3;

/* loaded from: classes2.dex */
public class S3ClientOptions {
    public static final boolean DEFAULT_ACCELERATE_MODE_ENABLED = false;
    public static final boolean DEFAULT_CHUNKED_ENCODING_DISABLED = false;
    public static final boolean DEFAULT_DUALSTACK_ENABLED = false;
    public static final boolean DEFAULT_PATH_STYLE_ACCESS = false;
    public static final boolean DEFAULT_PAYLOAD_SIGNING_ENABLED = false;
    public static final boolean DEFAULT_SKIP_CONTENT_MD5_CHECK = false;
    private final boolean accelerateModeEnabled;
    private final boolean chunkedEncodingDisabled;
    private final boolean dualstackEnabled;
    private boolean pathStyleAccess;
    private final boolean payloadSigningEnabled;
    private boolean skipContentMd5Check;

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private boolean accelerateModeEnabled;
        private boolean chunkedEncodingDisabled;
        private boolean dualstackEnabled;
        private boolean pathStyleAccess;
        private boolean payloadSigningEnabled;
        private boolean skipContentMd5Check;

        private Builder() {
            this.skipContentMd5Check = false;
            this.pathStyleAccess = false;
            this.chunkedEncodingDisabled = false;
            this.accelerateModeEnabled = false;
            this.payloadSigningEnabled = false;
            this.dualstackEnabled = false;
        }

        public S3ClientOptions build() {
            return new S3ClientOptions(this.skipContentMd5Check, this.pathStyleAccess, this.chunkedEncodingDisabled, this.accelerateModeEnabled, this.payloadSigningEnabled, this.dualstackEnabled);
        }

        public Builder skipContentMd5Check(boolean z) {
            this.skipContentMd5Check = z;
            return this;
        }

        public Builder setPathStyleAccess(boolean z) {
            this.pathStyleAccess = z;
            return this;
        }

        public Builder setAccelerateModeEnabled(boolean z) {
            this.accelerateModeEnabled = z;
            return this;
        }

        public Builder setPayloadSigningEnabled(boolean z) {
            this.payloadSigningEnabled = z;
            return this;
        }

        public Builder disableChunkedEncoding() {
            this.chunkedEncodingDisabled = true;
            return this;
        }

        public Builder enableDualstack() {
            this.dualstackEnabled = true;
            return this;
        }
    }

    @Deprecated
    public S3ClientOptions() {
        this.skipContentMd5Check = false;
        this.pathStyleAccess = false;
        this.chunkedEncodingDisabled = false;
        this.accelerateModeEnabled = false;
        this.payloadSigningEnabled = false;
        this.dualstackEnabled = false;
    }

    @Deprecated
    public S3ClientOptions(S3ClientOptions s3ClientOptions) {
        this.skipContentMd5Check = s3ClientOptions.skipContentMd5Check;
        this.pathStyleAccess = s3ClientOptions.pathStyleAccess;
        this.chunkedEncodingDisabled = s3ClientOptions.chunkedEncodingDisabled;
        this.accelerateModeEnabled = s3ClientOptions.accelerateModeEnabled;
        this.payloadSigningEnabled = s3ClientOptions.payloadSigningEnabled;
        this.dualstackEnabled = s3ClientOptions.dualstackEnabled;
    }

    private S3ClientOptions(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.skipContentMd5Check = z;
        this.pathStyleAccess = z2;
        this.chunkedEncodingDisabled = z3;
        this.accelerateModeEnabled = z4;
        this.payloadSigningEnabled = z5;
        this.dualstackEnabled = z6;
    }

    public boolean isContentMd5CheckSkipped() {
        return this.skipContentMd5Check;
    }

    public boolean isPathStyleAccess() {
        return this.pathStyleAccess;
    }

    public boolean isChunkedEncodingDisabled() {
        return this.chunkedEncodingDisabled;
    }

    public boolean isAccelerateModeEnabled() {
        return this.accelerateModeEnabled;
    }

    public boolean isPayloadSigningEnabled() {
        return this.payloadSigningEnabled;
    }

    public void skipContentMd5Check(boolean z) {
        this.skipContentMd5Check = z;
    }

    @Deprecated
    public void setPathStyleAccess(boolean z) {
        this.pathStyleAccess = z;
    }

    public boolean isDualstackEnabled() {
        return this.dualstackEnabled;
    }

    @Deprecated
    public S3ClientOptions withPathStyleAccess(boolean z) {
        setPathStyleAccess(z);
        return this;
    }
}
