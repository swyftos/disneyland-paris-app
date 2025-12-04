package com.fasterxml.jackson.dataformat.cbor.databind;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;
import com.fasterxml.jackson.dataformat.cbor.CBORFactory;
import com.fasterxml.jackson.dataformat.cbor.PackageVersion;

/* loaded from: classes3.dex */
public class CBORMapper extends ObjectMapper {
    private static final long serialVersionUID = 1;

    public static class Builder extends MapperBuilder<CBORMapper, Builder> {
        public Builder(CBORMapper cBORMapper) {
            super(cBORMapper);
        }
    }

    public CBORMapper() {
        this(new CBORFactory());
    }

    public CBORMapper(CBORFactory cBORFactory) {
        super(cBORFactory);
    }

    protected CBORMapper(CBORMapper cBORMapper) {
        super(cBORMapper);
    }

    public static Builder builder() {
        return new Builder(new CBORMapper());
    }

    public static Builder builder(CBORFactory cBORFactory) {
        return new Builder(new CBORMapper(cBORFactory));
    }

    @Override // com.fasterxml.jackson.databind.ObjectMapper
    public CBORMapper copy() {
        _checkInvalidCopy(CBORMapper.class);
        return new CBORMapper(this);
    }

    @Override // com.fasterxml.jackson.databind.ObjectMapper, com.fasterxml.jackson.core.ObjectCodec, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return PackageVersion.VERSION;
    }

    @Override // com.fasterxml.jackson.databind.ObjectMapper, com.fasterxml.jackson.core.ObjectCodec
    public CBORFactory getFactory() {
        return (CBORFactory) this._jsonFactory;
    }
}
