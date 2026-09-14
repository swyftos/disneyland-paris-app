package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PolystarContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private final boolean hidden;
    private final BaseKeyframeAnimation innerRadiusAnimation;
    private final BaseKeyframeAnimation innerRoundednessAnimation;
    private boolean isPathValid;
    private final boolean isReversed;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation outerRadiusAnimation;
    private final BaseKeyframeAnimation outerRoundednessAnimation;
    private final BaseKeyframeAnimation pointsAnimation;
    private final BaseKeyframeAnimation positionAnimation;
    private final BaseKeyframeAnimation rotationAnimation;
    private final PolystarShape.Type type;
    private final Path path = new Path();
    private final Path lastSegmentPath = new Path();
    private final PathMeasure lastSegmentPathMeasure = new PathMeasure();
    private final float[] lastSegmentPosition = new float[2];
    private final CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.lottieDrawable = lottieDrawable;
        this.name = polystarShape.getName();
        PolystarShape.Type type = polystarShape.getType();
        this.type = type;
        this.hidden = polystarShape.isHidden();
        this.isReversed = polystarShape.isReversed();
        FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation = polystarShape.getPoints().createAnimation();
        this.pointsAnimation = floatKeyframeAnimationCreateAnimation;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationCreateAnimation = polystarShape.getPosition().createAnimation();
        this.positionAnimation = baseKeyframeAnimationCreateAnimation;
        FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation2 = polystarShape.getRotation().createAnimation();
        this.rotationAnimation = floatKeyframeAnimationCreateAnimation2;
        FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation3 = polystarShape.getOuterRadius().createAnimation();
        this.outerRadiusAnimation = floatKeyframeAnimationCreateAnimation3;
        FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation4 = polystarShape.getOuterRoundedness().createAnimation();
        this.outerRoundednessAnimation = floatKeyframeAnimationCreateAnimation4;
        PolystarShape.Type type2 = PolystarShape.Type.STAR;
        if (type == type2) {
            this.innerRadiusAnimation = polystarShape.getInnerRadius().createAnimation();
            this.innerRoundednessAnimation = polystarShape.getInnerRoundedness().createAnimation();
        } else {
            this.innerRadiusAnimation = null;
            this.innerRoundednessAnimation = null;
        }
        baseLayer.addAnimation(floatKeyframeAnimationCreateAnimation);
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation);
        baseLayer.addAnimation(floatKeyframeAnimationCreateAnimation2);
        baseLayer.addAnimation(floatKeyframeAnimationCreateAnimation3);
        baseLayer.addAnimation(floatKeyframeAnimationCreateAnimation4);
        if (type == type2) {
            baseLayer.addAnimation(this.innerRadiusAnimation);
            baseLayer.addAnimation(this.innerRoundednessAnimation);
        }
        floatKeyframeAnimationCreateAnimation.addUpdateListener(this);
        baseKeyframeAnimationCreateAnimation.addUpdateListener(this);
        floatKeyframeAnimationCreateAnimation2.addUpdateListener(this);
        floatKeyframeAnimationCreateAnimation3.addUpdateListener(this);
        floatKeyframeAnimationCreateAnimation4.addUpdateListener(this);
        if (type == type2) {
            this.innerRadiusAnimation.addUpdateListener(this);
            this.innerRoundednessAnimation.addUpdateListener(this);
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        invalidate();
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.getType() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.trimPaths.addTrimPath(trimPathContent);
                    trimPathContent.addListener(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        int i = C18181.$SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[this.type.ordinal()];
        if (i == 1) {
            createStarPath();
        } else if (i == 2) {
            createPolygonPath();
        }
        this.path.close();
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    }

    /* JADX INFO: renamed from: com.airbnb.lottie.animation.content.PolystarContent$1 */
    static /* synthetic */ class C18181 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    private void createStarPath() {
        float f;
        float f2;
        double d;
        float fSin;
        float f3;
        float f4;
        float f5;
        float fFloatValue = ((Float) this.pointsAnimation.getValue()).floatValue();
        BaseKeyframeAnimation baseKeyframeAnimation = this.rotationAnimation;
        double radians = Math.toRadians((baseKeyframeAnimation == null ? AudioStats.AUDIO_AMPLITUDE_NONE : ((Float) baseKeyframeAnimation.getValue()).floatValue()) - 90.0d);
        double d2 = fFloatValue;
        float f6 = (float) (6.283185307179586d / d2);
        if (this.isReversed) {
            f6 *= -1.0f;
        }
        float f7 = f6 / 2.0f;
        float f8 = fFloatValue - ((int) fFloatValue);
        if (f8 != BitmapDescriptorFactory.HUE_RED) {
            radians += (double) ((1.0f - f8) * f7);
        }
        float fFloatValue2 = ((Float) this.outerRadiusAnimation.getValue()).floatValue();
        float fFloatValue3 = ((Float) this.innerRadiusAnimation.getValue()).floatValue();
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.innerRoundednessAnimation;
        float fFloatValue4 = baseKeyframeAnimation2 != null ? ((Float) baseKeyframeAnimation2.getValue()).floatValue() / 100.0f : 0.0f;
        BaseKeyframeAnimation baseKeyframeAnimation3 = this.outerRoundednessAnimation;
        float fFloatValue5 = baseKeyframeAnimation3 != null ? ((Float) baseKeyframeAnimation3.getValue()).floatValue() / 100.0f : 0.0f;
        if (f8 != BitmapDescriptorFactory.HUE_RED) {
            f3 = ((fFloatValue2 - fFloatValue3) * f8) + fFloatValue3;
            double d3 = f3;
            float fCos = (float) (d3 * Math.cos(radians));
            fSin = (float) (d3 * Math.sin(radians));
            this.path.moveTo(fCos, fSin);
            d = radians + ((double) ((f6 * f8) / 2.0f));
            f = fCos;
            f2 = f7;
        } else {
            double d4 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d4);
            float fSin2 = (float) (d4 * Math.sin(radians));
            this.path.moveTo(fCos2, fSin2);
            f = fCos2;
            f2 = f7;
            d = radians + ((double) f2);
            fSin = fSin2;
            f3 = BitmapDescriptorFactory.HUE_RED;
        }
        double dCeil = Math.ceil(d2) * 2.0d;
        int i = 0;
        float f9 = f2;
        float f10 = f;
        boolean z = false;
        while (true) {
            double d5 = i;
            if (d5 < dCeil) {
                float f11 = z ? fFloatValue2 : fFloatValue3;
                float f12 = (f3 == BitmapDescriptorFactory.HUE_RED || d5 != dCeil - 2.0d) ? f9 : (f6 * f8) / 2.0f;
                if (f3 == BitmapDescriptorFactory.HUE_RED || d5 != dCeil - 1.0d) {
                    f3 = f11;
                }
                double d6 = f3;
                double d7 = dCeil;
                float fCos3 = (float) (d6 * Math.cos(d));
                float fSin3 = (float) (d6 * Math.sin(d));
                if (fFloatValue4 == BitmapDescriptorFactory.HUE_RED && fFloatValue5 == BitmapDescriptorFactory.HUE_RED) {
                    this.path.lineTo(fCos3, fSin3);
                    f4 = fFloatValue4;
                    f5 = fFloatValue5;
                } else {
                    f4 = fFloatValue4;
                    double dAtan2 = (float) (Math.atan2(fSin, f10) - 1.5707963267948966d);
                    float fCos4 = (float) Math.cos(dAtan2);
                    float fSin4 = (float) Math.sin(dAtan2);
                    f5 = fFloatValue5;
                    double dAtan3 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                    float fCos5 = (float) Math.cos(dAtan3);
                    float fSin5 = (float) Math.sin(dAtan3);
                    float f13 = z ? f4 : f5;
                    float f14 = z ? f5 : f4;
                    float f15 = (z ? fFloatValue3 : fFloatValue2) * f13 * 0.47829f;
                    float f16 = fCos4 * f15;
                    float f17 = f15 * fSin4;
                    float f18 = (z ? fFloatValue2 : fFloatValue3) * f14 * 0.47829f;
                    float f19 = fCos5 * f18;
                    float f20 = f18 * fSin5;
                    if (f8 != BitmapDescriptorFactory.HUE_RED) {
                        if (i == 0) {
                            f16 *= f8;
                            f17 *= f8;
                        } else if (d5 == d7 - 1.0d) {
                            f19 *= f8;
                            f20 *= f8;
                        }
                    }
                    this.path.cubicTo(f10 - f16, fSin - f17, fCos3 + f19, fSin3 + f20, fCos3, fSin3);
                }
                d += (double) f12;
                z = !z;
                i++;
                f10 = fCos3;
                fSin = fSin3;
                fFloatValue5 = f5;
                fFloatValue4 = f4;
                f3 = f3;
                f6 = f6;
                dCeil = d7;
            } else {
                PointF pointF = (PointF) this.positionAnimation.getValue();
                this.path.offset(pointF.x, pointF.y);
                this.path.close();
                return;
            }
        }
    }

    private void createPolygonPath() {
        double d;
        float f;
        PolystarContent polystarContent;
        PolystarContent polystarContent2 = this;
        int iFloor = (int) Math.floor(((Float) polystarContent2.pointsAnimation.getValue()).floatValue());
        BaseKeyframeAnimation baseKeyframeAnimation = polystarContent2.rotationAnimation;
        double radians = Math.toRadians((baseKeyframeAnimation == null ? AudioStats.AUDIO_AMPLITUDE_NONE : ((Float) baseKeyframeAnimation.getValue()).floatValue()) - 90.0d);
        double d2 = iFloor;
        float fFloatValue = ((Float) polystarContent2.outerRoundednessAnimation.getValue()).floatValue() / 100.0f;
        float fFloatValue2 = ((Float) polystarContent2.outerRadiusAnimation.getValue()).floatValue();
        double d3 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d3);
        float fSin = (float) (Math.sin(radians) * d3);
        polystarContent2.path.moveTo(fCos, fSin);
        double d4 = (float) (6.283185307179586d / d2);
        double dCeil = Math.ceil(d2);
        double d5 = radians + d4;
        int i = 0;
        while (true) {
            double d6 = i;
            if (d6 < dCeil) {
                int i2 = i;
                float fCos2 = (float) (d3 * Math.cos(d5));
                double d7 = d4;
                float fSin2 = (float) (d3 * Math.sin(d5));
                if (fFloatValue != BitmapDescriptorFactory.HUE_RED) {
                    d = d3;
                    double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                    float fCos3 = (float) Math.cos(dAtan2);
                    float fSin3 = (float) Math.sin(dAtan2);
                    f = fSin2;
                    double dAtan3 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                    float f2 = fFloatValue2 * fFloatValue * 0.25f;
                    float f3 = fCos3 * f2;
                    float f4 = fSin3 * f2;
                    float fCos4 = ((float) Math.cos(dAtan3)) * f2;
                    float fSin4 = f2 * ((float) Math.sin(dAtan3));
                    if (d6 == dCeil - 1.0d) {
                        polystarContent = this;
                        polystarContent.lastSegmentPath.reset();
                        polystarContent.lastSegmentPath.moveTo(fCos, fSin);
                        float f5 = fCos - f3;
                        float f6 = fSin - f4;
                        float f7 = fCos2 + fCos4;
                        float f8 = fSin4 + f;
                        polystarContent.lastSegmentPath.cubicTo(f5, f6, f7, f8, fCos2, f);
                        polystarContent.lastSegmentPathMeasure.setPath(polystarContent.lastSegmentPath, false);
                        PathMeasure pathMeasure = polystarContent.lastSegmentPathMeasure;
                        pathMeasure.getPosTan(pathMeasure.getLength() * 0.9999f, polystarContent.lastSegmentPosition, null);
                        Path path = polystarContent.path;
                        float[] fArr = polystarContent.lastSegmentPosition;
                        path.cubicTo(f5, f6, f7, f8, fArr[0], fArr[1]);
                    } else {
                        polystarContent = this;
                        polystarContent.path.cubicTo(fCos - f3, fSin - f4, fCos2 + fCos4, f + fSin4, fCos2, f);
                    }
                } else {
                    d = d3;
                    f = fSin2;
                    polystarContent = polystarContent2;
                    if (d6 != dCeil - 1.0d) {
                        polystarContent.path.lineTo(fCos2, f);
                    }
                    fSin = f;
                    fCos = fCos2;
                    d4 = d7;
                    i = i2 + 1;
                    polystarContent2 = polystarContent;
                    d3 = d;
                }
                d5 += d7;
                fSin = f;
                fCos = fCos2;
                d4 = d7;
                i = i2 + 1;
                polystarContent2 = polystarContent;
                d3 = d;
            } else {
                PolystarContent polystarContent3 = polystarContent2;
                PointF pointF = (PointF) polystarContent3.positionAnimation.getValue();
                polystarContent3.path.offset(pointF.x, pointF.y);
                polystarContent3.path.close();
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation baseKeyframeAnimation;
        BaseKeyframeAnimation baseKeyframeAnimation2;
        if (t == LottieProperty.POLYSTAR_POINTS) {
            this.pointsAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POLYSTAR_ROTATION) {
            this.rotationAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POLYSTAR_INNER_RADIUS && (baseKeyframeAnimation2 = this.innerRadiusAnimation) != null) {
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POLYSTAR_OUTER_RADIUS) {
            this.outerRadiusAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS && (baseKeyframeAnimation = this.innerRoundednessAnimation) != null) {
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
            this.outerRoundednessAnimation.setValueCallback(lottieValueCallback);
        }
    }
}
