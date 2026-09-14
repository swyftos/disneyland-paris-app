package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.airbnb.lottie.C1806L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
abstract class KeyframeParser {
    private static SparseArrayCompat pathInterpolatorCache;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    static JsonReader.Options NAMES = JsonReader.Options.m434of("t", CmcdData.Factory.STREAMING_FORMAT_SS, "e", "o", "i", "h", TypedValues.TransitionType.S_TO, "ti");
    static JsonReader.Options INTERPOLATOR_NAMES = JsonReader.Options.m434of("x", "y");

    private static SparseArrayCompat pathInterpolatorCache() {
        if (pathInterpolatorCache == null) {
            pathInterpolatorCache = new SparseArrayCompat();
        }
        return pathInterpolatorCache;
    }

    private static WeakReference getInterpolator(int i) {
        WeakReference weakReference;
        synchronized (KeyframeParser.class) {
            weakReference = (WeakReference) pathInterpolatorCache().get(i);
        }
        return weakReference;
    }

    private static void putInterpolator(int i, WeakReference weakReference) {
        synchronized (KeyframeParser.class) {
            pathInterpolatorCache.put(i, weakReference);
        }
    }

    static Keyframe parse(JsonReader jsonReader, LottieComposition lottieComposition, float f, ValueParser valueParser, boolean z, boolean z2) {
        if (z && z2) {
            return parseMultiDimensionalKeyframe(lottieComposition, jsonReader, f, valueParser);
        }
        if (z) {
            return parseKeyframe(lottieComposition, jsonReader, f, valueParser);
        }
        return parseStaticValue(jsonReader, f, valueParser);
    }

    private static Keyframe parseKeyframe(LottieComposition lottieComposition, JsonReader jsonReader, float f, ValueParser valueParser) throws IOException {
        Interpolator interpolatorInterpolatorFor;
        Interpolator interpolator;
        Object obj;
        jsonReader.beginObject();
        PointF pointFJsonToPoint = null;
        Object obj2 = null;
        Object obj3 = null;
        PointF pointFJsonToPoint2 = null;
        PointF pointFJsonToPoint3 = null;
        float fNextDouble = 0.0f;
        boolean z = false;
        PointF pointFJsonToPoint4 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 1:
                    obj3 = valueParser.parse(jsonReader, f);
                    break;
                case 2:
                    obj2 = valueParser.parse(jsonReader, f);
                    break;
                case 3:
                    pointFJsonToPoint = JsonUtils.jsonToPoint(jsonReader, 1.0f);
                    break;
                case 4:
                    pointFJsonToPoint4 = JsonUtils.jsonToPoint(jsonReader, 1.0f);
                    break;
                case 5:
                    z = jsonReader.nextInt() == 1;
                    break;
                case 6:
                    pointFJsonToPoint2 = JsonUtils.jsonToPoint(jsonReader, f);
                    break;
                case 7:
                    pointFJsonToPoint3 = JsonUtils.jsonToPoint(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            interpolator = LINEAR_INTERPOLATOR;
            obj = obj3;
        } else {
            if (pointFJsonToPoint != null && pointFJsonToPoint4 != null) {
                interpolatorInterpolatorFor = interpolatorFor(pointFJsonToPoint, pointFJsonToPoint4);
            } else {
                interpolatorInterpolatorFor = LINEAR_INTERPOLATOR;
            }
            interpolator = interpolatorInterpolatorFor;
            obj = obj2;
        }
        Keyframe keyframe = new Keyframe(lottieComposition, obj3, obj, interpolator, fNextDouble, null);
        keyframe.pathCp1 = pointFJsonToPoint2;
        keyframe.pathCp2 = pointFJsonToPoint3;
        return keyframe;
    }

    /* JADX WARN: Code duplicated, block: B:93:0x01ea  */
    private static Keyframe parseMultiDimensionalKeyframe(LottieComposition lottieComposition, JsonReader jsonReader, float f, ValueParser valueParser) throws IOException {
        Interpolator interpolatorInterpolatorFor;
        Interpolator interpolatorInterpolatorFor2;
        Interpolator interpolatorInterpolatorFor3;
        Object obj;
        Keyframe keyframe;
        PointF pointF;
        float f2;
        PointF pointF2;
        jsonReader.beginObject();
        PointF pointFJsonToPoint = null;
        boolean z = false;
        PointF pointFJsonToPoint2 = null;
        PointF pointFJsonToPoint3 = null;
        PointF pointF3 = null;
        Object obj2 = null;
        PointF pointF4 = null;
        PointF pointF5 = null;
        PointF pointF6 = null;
        float fNextDouble = BitmapDescriptorFactory.HUE_RED;
        PointF pointFJsonToPoint4 = null;
        Object obj3 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    pointF = pointFJsonToPoint;
                    fNextDouble = (float) jsonReader.nextDouble();
                    pointFJsonToPoint = pointF;
                    break;
                case 1:
                    pointF = pointFJsonToPoint;
                    obj2 = valueParser.parse(jsonReader, f);
                    pointFJsonToPoint = pointF;
                    break;
                case 2:
                    pointF = pointFJsonToPoint;
                    obj3 = valueParser.parse(jsonReader, f);
                    pointFJsonToPoint = pointF;
                    break;
                case 3:
                    pointF = pointFJsonToPoint;
                    f2 = fNextDouble;
                    PointF pointF7 = pointFJsonToPoint4;
                    if (jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float fNextDouble2 = BitmapDescriptorFactory.HUE_RED;
                        float fNextDouble3 = BitmapDescriptorFactory.HUE_RED;
                        float fNextDouble4 = BitmapDescriptorFactory.HUE_RED;
                        float fNextDouble5 = BitmapDescriptorFactory.HUE_RED;
                        while (jsonReader.hasNext()) {
                            int iSelectName = jsonReader.selectName(INTERPOLATOR_NAMES);
                            if (iSelectName == 0) {
                                JsonReader.Token tokenPeek = jsonReader.peek();
                                JsonReader.Token token = JsonReader.Token.NUMBER;
                                if (tokenPeek == token) {
                                    fNextDouble4 = (float) jsonReader.nextDouble();
                                    fNextDouble2 = fNextDouble4;
                                } else {
                                    jsonReader.beginArray();
                                    fNextDouble2 = (float) jsonReader.nextDouble();
                                    fNextDouble4 = jsonReader.peek() == token ? (float) jsonReader.nextDouble() : fNextDouble2;
                                    jsonReader.endArray();
                                }
                            } else if (iSelectName == 1) {
                                JsonReader.Token tokenPeek2 = jsonReader.peek();
                                JsonReader.Token token2 = JsonReader.Token.NUMBER;
                                if (tokenPeek2 == token2) {
                                    fNextDouble5 = (float) jsonReader.nextDouble();
                                    fNextDouble3 = fNextDouble5;
                                } else {
                                    jsonReader.beginArray();
                                    fNextDouble3 = (float) jsonReader.nextDouble();
                                    fNextDouble5 = jsonReader.peek() == token2 ? (float) jsonReader.nextDouble() : fNextDouble3;
                                    jsonReader.endArray();
                                }
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        PointF pointF8 = new PointF(fNextDouble2, fNextDouble3);
                        PointF pointF9 = new PointF(fNextDouble4, fNextDouble5);
                        jsonReader.endObject();
                        pointF4 = pointF9;
                        pointF3 = pointF8;
                        pointFJsonToPoint4 = pointF7;
                        fNextDouble = f2;
                    } else {
                        pointFJsonToPoint2 = JsonUtils.jsonToPoint(jsonReader, f);
                        fNextDouble = f2;
                        pointFJsonToPoint4 = pointF7;
                    }
                    pointFJsonToPoint = pointF;
                    break;
                case 4:
                    if (jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float fNextDouble6 = BitmapDescriptorFactory.HUE_RED;
                        float f3 = BitmapDescriptorFactory.HUE_RED;
                        float fNextDouble7 = BitmapDescriptorFactory.HUE_RED;
                        float fNextDouble8 = BitmapDescriptorFactory.HUE_RED;
                        while (jsonReader.hasNext()) {
                            pointFJsonToPoint4 = pointFJsonToPoint4;
                            int iSelectName2 = jsonReader.selectName(INTERPOLATOR_NAMES);
                            if (iSelectName2 != 0) {
                                pointF2 = pointFJsonToPoint;
                                if (iSelectName2 == 1) {
                                    JsonReader.Token tokenPeek3 = jsonReader.peek();
                                    JsonReader.Token token3 = JsonReader.Token.NUMBER;
                                    if (tokenPeek3 == token3) {
                                        fNextDouble8 = (float) jsonReader.nextDouble();
                                        fNextDouble = fNextDouble;
                                        f3 = fNextDouble8;
                                    } else {
                                        float f4 = fNextDouble;
                                        jsonReader.beginArray();
                                        float fNextDouble9 = (float) jsonReader.nextDouble();
                                        float fNextDouble10 = jsonReader.peek() == token3 ? (float) jsonReader.nextDouble() : fNextDouble9;
                                        jsonReader.endArray();
                                        fNextDouble = f4;
                                        pointFJsonToPoint = pointF2;
                                        fNextDouble8 = fNextDouble10;
                                        f3 = fNextDouble9;
                                    }
                                } else {
                                    jsonReader.skipValue();
                                }
                            } else {
                                pointF2 = pointFJsonToPoint;
                                float f5 = fNextDouble;
                                JsonReader.Token tokenPeek4 = jsonReader.peek();
                                JsonReader.Token token4 = JsonReader.Token.NUMBER;
                                if (tokenPeek4 == token4) {
                                    fNextDouble7 = (float) jsonReader.nextDouble();
                                    fNextDouble = f5;
                                    fNextDouble6 = fNextDouble7;
                                } else {
                                    jsonReader.beginArray();
                                    fNextDouble6 = (float) jsonReader.nextDouble();
                                    fNextDouble7 = jsonReader.peek() == token4 ? (float) jsonReader.nextDouble() : fNextDouble6;
                                    jsonReader.endArray();
                                    fNextDouble = f5;
                                }
                            }
                            pointFJsonToPoint = pointF2;
                        }
                        pointF = pointFJsonToPoint;
                        f2 = fNextDouble;
                        PointF pointF10 = new PointF(fNextDouble6, f3);
                        PointF pointF11 = new PointF(fNextDouble7, fNextDouble8);
                        jsonReader.endObject();
                        pointF6 = pointF11;
                        pointF5 = pointF10;
                        fNextDouble = f2;
                    } else {
                        pointF = pointFJsonToPoint;
                        pointFJsonToPoint3 = JsonUtils.jsonToPoint(jsonReader, f);
                    }
                    pointFJsonToPoint = pointF;
                    break;
                case 5:
                    z = jsonReader.nextInt() == 1;
                    break;
                case 6:
                    pointFJsonToPoint4 = JsonUtils.jsonToPoint(jsonReader, f);
                    break;
                case 7:
                    pointFJsonToPoint = JsonUtils.jsonToPoint(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        PointF pointF12 = pointFJsonToPoint;
        float f6 = fNextDouble;
        PointF pointF13 = pointFJsonToPoint4;
        jsonReader.endObject();
        if (z) {
            interpolatorInterpolatorFor = LINEAR_INTERPOLATOR;
            obj = obj2;
        } else {
            if (pointFJsonToPoint2 != null && pointFJsonToPoint3 != null) {
                interpolatorInterpolatorFor = interpolatorFor(pointFJsonToPoint2, pointFJsonToPoint3);
            } else {
                if (pointF3 != null && pointF4 != null && pointF5 != null && pointF6 != null) {
                    interpolatorInterpolatorFor2 = interpolatorFor(pointF3, pointF5);
                    interpolatorInterpolatorFor3 = interpolatorFor(pointF4, pointF6);
                    obj = obj3;
                    interpolatorInterpolatorFor = null;
                } else {
                    interpolatorInterpolatorFor = LINEAR_INTERPOLATOR;
                }
                if (interpolatorInterpolatorFor2 == null && interpolatorInterpolatorFor3 != null) {
                    keyframe = new Keyframe(lottieComposition, obj2, obj, interpolatorInterpolatorFor2, interpolatorInterpolatorFor3, f6, null);
                } else {
                    keyframe = new Keyframe(lottieComposition, obj2, obj, interpolatorInterpolatorFor, f6, null);
                }
                keyframe.pathCp1 = pointF13;
                keyframe.pathCp2 = pointF12;
                return keyframe;
            }
            obj = obj3;
        }
        interpolatorInterpolatorFor2 = null;
        interpolatorInterpolatorFor3 = null;
        if (interpolatorInterpolatorFor2 == null) {
            keyframe = new Keyframe(lottieComposition, obj2, obj, interpolatorInterpolatorFor, f6, null);
        } else {
            keyframe = new Keyframe(lottieComposition, obj2, obj, interpolatorInterpolatorFor, f6, null);
        }
        keyframe.pathCp1 = pointF13;
        keyframe.pathCp2 = pointF12;
        return keyframe;
    }

    private static Interpolator interpolatorFor(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = MiscUtils.clamp(pointF.x, -1.0f, 1.0f);
        pointF.y = MiscUtils.clamp(pointF.y, -100.0f, 100.0f);
        pointF2.x = MiscUtils.clamp(pointF2.x, -1.0f, 1.0f);
        float fClamp = MiscUtils.clamp(pointF2.y, -100.0f, 100.0f);
        pointF2.y = fClamp;
        int iHashFor = Utils.hashFor(pointF.x, pointF.y, pointF2.x, fClamp);
        WeakReference interpolator = C1806L.getDisablePathInterpolatorCache() ? null : getInterpolator(iHashFor);
        Interpolator interpolator2 = interpolator != null ? (Interpolator) interpolator.get() : null;
        if (interpolator == null || interpolator2 == null) {
            try {
                linearInterpolator = PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e) {
                if ("The Path cannot loop back on itself.".equals(e.getMessage())) {
                    linearInterpolator = PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, BitmapDescriptorFactory.HUE_RED), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator2 = linearInterpolator;
            if (!C1806L.getDisablePathInterpolatorCache()) {
                try {
                    putInterpolator(iHashFor, new WeakReference(interpolator2));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
        }
        return interpolator2;
    }

    private static Keyframe parseStaticValue(JsonReader jsonReader, float f, ValueParser valueParser) {
        return new Keyframe(valueParser.parse(jsonReader, f));
    }
}
