package com.fasterxml.jackson.dataformat.cbor;

import com.fasterxml.jackson.core.TSFBuilder;
import com.fasterxml.jackson.dataformat.cbor.CBORGenerator;
import com.fasterxml.jackson.dataformat.cbor.CBORParser;

/* loaded from: classes3.dex */
public class CBORFactoryBuilder extends TSFBuilder<CBORFactory, CBORFactoryBuilder> {
    protected int _formatGeneratorFeatures;
    protected int _formatParserFeatures;

    protected CBORFactoryBuilder() {
        this._formatParserFeatures = CBORFactory.DEFAULT_CBOR_PARSER_FEATURE_FLAGS;
        this._formatGeneratorFeatures = CBORFactory.DEFAULT_CBOR_GENERATOR_FEATURE_FLAGS;
    }

    public CBORFactoryBuilder(CBORFactory cBORFactory) {
        super(cBORFactory);
        this._formatParserFeatures = cBORFactory._formatParserFeatures;
        this._formatGeneratorFeatures = cBORFactory._formatGeneratorFeatures;
    }

    public CBORFactoryBuilder enable(CBORParser.Feature feature) {
        this._formatParserFeatures = feature.getMask() | this._formatParserFeatures;
        return _this();
    }

    public CBORFactoryBuilder enable(CBORParser.Feature feature, CBORParser.Feature... featureArr) {
        this._formatParserFeatures = feature.getMask() | this._formatParserFeatures;
        for (CBORParser.Feature feature2 : featureArr) {
            this._formatParserFeatures = feature2.getMask() | this._formatParserFeatures;
        }
        return _this();
    }

    public CBORFactoryBuilder disable(CBORParser.Feature feature) {
        this._formatParserFeatures = (~feature.getMask()) & this._formatParserFeatures;
        return _this();
    }

    public CBORFactoryBuilder disable(CBORParser.Feature feature, CBORParser.Feature... featureArr) {
        this._formatParserFeatures = (~feature.getMask()) & this._formatParserFeatures;
        for (CBORParser.Feature feature2 : featureArr) {
            this._formatParserFeatures = (~feature2.getMask()) & this._formatParserFeatures;
        }
        return _this();
    }

    public CBORFactoryBuilder configure(CBORParser.Feature feature, boolean z) {
        return z ? enable(feature) : disable(feature);
    }

    public CBORFactoryBuilder enable(CBORGenerator.Feature feature) {
        this._formatGeneratorFeatures = feature.getMask() | this._formatGeneratorFeatures;
        return _this();
    }

    public CBORFactoryBuilder enable(CBORGenerator.Feature feature, CBORGenerator.Feature... featureArr) {
        this._formatGeneratorFeatures = feature.getMask() | this._formatGeneratorFeatures;
        for (CBORGenerator.Feature feature2 : featureArr) {
            this._formatGeneratorFeatures = feature2.getMask() | this._formatGeneratorFeatures;
        }
        return _this();
    }

    public CBORFactoryBuilder disable(CBORGenerator.Feature feature) {
        this._formatGeneratorFeatures = (~feature.getMask()) & this._formatGeneratorFeatures;
        return _this();
    }

    public CBORFactoryBuilder disable(CBORGenerator.Feature feature, CBORGenerator.Feature... featureArr) {
        this._formatGeneratorFeatures = (~feature.getMask()) & this._formatGeneratorFeatures;
        for (CBORGenerator.Feature feature2 : featureArr) {
            this._formatGeneratorFeatures = (~feature2.getMask()) & this._formatGeneratorFeatures;
        }
        return _this();
    }

    public CBORFactoryBuilder configure(CBORGenerator.Feature feature, boolean z) {
        return z ? enable(feature) : disable(feature);
    }

    public int formatParserFeaturesMask() {
        return this._formatParserFeatures;
    }

    public int formatGeneratorFeaturesMask() {
        return this._formatGeneratorFeatures;
    }

    @Override // com.fasterxml.jackson.core.TSFBuilder
    public CBORFactory build() {
        return new CBORFactory(this);
    }
}
