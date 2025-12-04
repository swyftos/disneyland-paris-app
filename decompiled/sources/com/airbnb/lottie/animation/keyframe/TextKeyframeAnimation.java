package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes2.dex */
public class TextKeyframeAnimation extends KeyframeAnimation {
    public TextKeyframeAnimation(List<Keyframe<DocumentData>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public DocumentData getValue(Keyframe keyframe, float f) {
        T t;
        LottieValueCallback<A> lottieValueCallback = this.valueCallback;
        if (lottieValueCallback == 0) {
            if (f != 1.0f || (t = keyframe.endValue) == 0) {
                return (DocumentData) keyframe.startValue;
            }
            return (DocumentData) t;
        }
        float f2 = keyframe.startFrame;
        Float f3 = keyframe.endFrame;
        float fFloatValue = f3 == null ? Float.MAX_VALUE : f3.floatValue();
        T t2 = keyframe.startValue;
        DocumentData documentData = (DocumentData) t2;
        T t3 = keyframe.endValue;
        return (DocumentData) lottieValueCallback.getValueInternal(f2, fFloatValue, documentData, t3 == 0 ? (DocumentData) t2 : (DocumentData) t3, f, getInterpolatedCurrentKeyframeProgress(), getProgress());
    }

    public void setStringValueCallback(final LottieValueCallback<String> lottieValueCallback) {
        final LottieFrameInfo lottieFrameInfo = new LottieFrameInfo();
        final DocumentData documentData = new DocumentData();
        super.setValueCallback(new LottieValueCallback() { // from class: com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation.1
            @Override // com.airbnb.lottie.value.LottieValueCallback
            public DocumentData getValue(LottieFrameInfo lottieFrameInfo2) {
                lottieFrameInfo.set(lottieFrameInfo2.getStartFrame(), lottieFrameInfo2.getEndFrame(), ((DocumentData) lottieFrameInfo2.getStartValue()).text, ((DocumentData) lottieFrameInfo2.getEndValue()).text, lottieFrameInfo2.getLinearKeyframeProgress(), lottieFrameInfo2.getInterpolatedKeyframeProgress(), lottieFrameInfo2.getOverallProgress());
                String str = (String) lottieValueCallback.getValue(lottieFrameInfo);
                DocumentData documentData2 = (DocumentData) (lottieFrameInfo2.getInterpolatedKeyframeProgress() == 1.0f ? lottieFrameInfo2.getEndValue() : lottieFrameInfo2.getStartValue());
                documentData.set(str, documentData2.fontName, documentData2.size, documentData2.justification, documentData2.tracking, documentData2.lineHeight, documentData2.baselineShift, documentData2.color, documentData2.strokeColor, documentData2.strokeWidth, documentData2.strokeOverFill, documentData2.boxPosition, documentData2.boxSize);
                return documentData;
            }
        });
    }
}
