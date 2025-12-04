package com.airbnb.lottie.parser;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTextRangeSelector;
import com.airbnb.lottie.model.animatable.AnimatableTextStyle;
import com.airbnb.lottie.model.content.TextRangeUnits;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.Collections;

/* loaded from: classes2.dex */
public class AnimatableTextPropertiesParser {
    private static final JsonReader.Options PROPERTIES_NAMES = JsonReader.Options.of(CmcdData.Factory.STREAMING_FORMAT_SS, CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY);
    private static final JsonReader.Options ANIMATABLE_RANGE_PROPERTIES_NAMES = JsonReader.Options.of(CmcdData.Factory.STREAMING_FORMAT_SS, "e", "o", "r");
    private static final JsonReader.Options ANIMATABLE_PROPERTIES_NAMES = JsonReader.Options.of("fc", "sc", "sw", "t", "o");

    public static AnimatableTextProperties parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        AnimatableTextStyle animatableTextStyle = null;
        AnimatableTextRangeSelector animatableTextRangeSelector = null;
        while (jsonReader.hasNext()) {
            int iSelectName = jsonReader.selectName(PROPERTIES_NAMES);
            if (iSelectName == 0) {
                animatableTextRangeSelector = parseAnimatableTextRangeSelector(jsonReader, lottieComposition);
            } else if (iSelectName == 1) {
                animatableTextStyle = parseAnimatableTextStyle(jsonReader, lottieComposition);
            } else {
                jsonReader.skipName();
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new AnimatableTextProperties(animatableTextStyle, animatableTextRangeSelector);
    }

    private static AnimatableTextRangeSelector parseAnimatableTextRangeSelector(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatableIntegerValue integer = null;
        AnimatableIntegerValue integer2 = null;
        TextRangeUnits textRangeUnits = null;
        while (jsonReader.hasNext()) {
            int iSelectName = jsonReader.selectName(ANIMATABLE_RANGE_PROPERTIES_NAMES);
            if (iSelectName == 0) {
                animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
            } else if (iSelectName == 1) {
                integer = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
            } else if (iSelectName == 2) {
                integer2 = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
            } else if (iSelectName == 3) {
                int iNextInt = jsonReader.nextInt();
                if (iNextInt != 1 && iNextInt != 2) {
                    lottieComposition.addWarning("Unsupported text range units: " + iNextInt);
                    textRangeUnits = TextRangeUnits.INDEX;
                } else {
                    textRangeUnits = iNextInt == 1 ? TextRangeUnits.PERCENT : TextRangeUnits.INDEX;
                }
            } else {
                jsonReader.skipName();
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        if (animatableIntegerValue == null && integer != null) {
            animatableIntegerValue = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(0)));
        }
        return new AnimatableTextRangeSelector(animatableIntegerValue, integer, integer2, textRangeUnits);
    }

    private static AnimatableTextStyle parseAnimatableTextStyle(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        AnimatableColorValue color = null;
        AnimatableColorValue color2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableIntegerValue integer = null;
        while (jsonReader.hasNext()) {
            int iSelectName = jsonReader.selectName(ANIMATABLE_PROPERTIES_NAMES);
            if (iSelectName == 0) {
                color = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
            } else if (iSelectName == 1) {
                color2 = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
            } else if (iSelectName == 2) {
                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
            } else if (iSelectName == 3) {
                animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
            } else if (iSelectName == 4) {
                integer = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
            } else {
                jsonReader.skipName();
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new AnimatableTextStyle(color, color2, animatableFloatValue, animatableFloatValue2, integer);
    }
}
