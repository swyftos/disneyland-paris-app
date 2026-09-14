package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.Utils;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.base.Ascii;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
class MotionConstrainedPoint implements Comparable {
    static String[] names = {ViewProps.POSITION, "x", "y", "width", "height", "pathRotate"};
    private float height;
    private float position;
    int visibility;
    private float width;

    /* JADX INFO: renamed from: x */
    private float f33x;

    /* JADX INFO: renamed from: y */
    private float f34y;
    private float alpha = 1.0f;
    int mVisibilityMode = 0;
    private boolean applyElevation = false;
    private float elevation = BitmapDescriptorFactory.HUE_RED;
    private float rotation = BitmapDescriptorFactory.HUE_RED;
    private float rotationX = BitmapDescriptorFactory.HUE_RED;
    public float rotationY = BitmapDescriptorFactory.HUE_RED;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float translationX = BitmapDescriptorFactory.HUE_RED;
    private float translationY = BitmapDescriptorFactory.HUE_RED;
    private float translationZ = BitmapDescriptorFactory.HUE_RED;
    private int mDrawPath = 0;
    private float mPathRotate = Float.NaN;
    private float mProgress = Float.NaN;
    private int mAnimateRelativeTo = -1;
    LinkedHashMap mCustomVariable = new LinkedHashMap();
    int mMode = 0;
    double[] mTempValue = new double[18];
    double[] mTempDelta = new double[18];

    private boolean diff(float f, float f2) {
        if (Float.isNaN(f) || Float.isNaN(f2)) {
            return Float.isNaN(f) != Float.isNaN(f2);
        }
        return Math.abs(f - f2) > 1.0E-6f;
    }

    void different(MotionConstrainedPoint motionConstrainedPoint, HashSet hashSet) {
        if (diff(this.alpha, motionConstrainedPoint.alpha)) {
            hashSet.add("alpha");
        }
        if (diff(this.elevation, motionConstrainedPoint.elevation)) {
            hashSet.add("translationZ");
        }
        int i = this.visibility;
        int i2 = motionConstrainedPoint.visibility;
        if (i != i2 && this.mVisibilityMode == 0 && (i == 4 || i2 == 4)) {
            hashSet.add("alpha");
        }
        if (diff(this.rotation, motionConstrainedPoint.rotation)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.mPathRotate) || !Float.isNaN(motionConstrainedPoint.mPathRotate)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.mProgress) || !Float.isNaN(motionConstrainedPoint.mProgress)) {
            hashSet.add("progress");
        }
        if (diff(this.rotationX, motionConstrainedPoint.rotationX)) {
            hashSet.add("rotationX");
        }
        if (diff(this.rotationY, motionConstrainedPoint.rotationY)) {
            hashSet.add("rotationY");
        }
        if (diff(this.mPivotX, motionConstrainedPoint.mPivotX)) {
            hashSet.add("pivotX");
        }
        if (diff(this.mPivotY, motionConstrainedPoint.mPivotY)) {
            hashSet.add("pivotY");
        }
        if (diff(this.scaleX, motionConstrainedPoint.scaleX)) {
            hashSet.add("scaleX");
        }
        if (diff(this.scaleY, motionConstrainedPoint.scaleY)) {
            hashSet.add("scaleY");
        }
        if (diff(this.translationX, motionConstrainedPoint.translationX)) {
            hashSet.add("translationX");
        }
        if (diff(this.translationY, motionConstrainedPoint.translationY)) {
            hashSet.add("translationY");
        }
        if (diff(this.translationZ, motionConstrainedPoint.translationZ)) {
            hashSet.add("translationZ");
        }
        if (diff(this.elevation, motionConstrainedPoint.elevation)) {
            hashSet.add("elevation");
        }
    }

    void setBounds(float f, float f2, float f3, float f4) {
        this.f33x = f;
        this.f34y = f2;
        this.width = f3;
        this.height = f4;
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.position, motionConstrainedPoint.position);
    }

    public void applyParameters(MotionWidget motionWidget) {
        this.visibility = motionWidget.getVisibility();
        this.alpha = motionWidget.getVisibility() != 4 ? BitmapDescriptorFactory.HUE_RED : motionWidget.getAlpha();
        this.applyElevation = false;
        this.rotation = motionWidget.getRotationZ();
        this.rotationX = motionWidget.getRotationX();
        this.rotationY = motionWidget.getRotationY();
        this.scaleX = motionWidget.getScaleX();
        this.scaleY = motionWidget.getScaleY();
        this.mPivotX = motionWidget.getPivotX();
        this.mPivotY = motionWidget.getPivotY();
        this.translationX = motionWidget.getTranslationX();
        this.translationY = motionWidget.getTranslationY();
        this.translationZ = motionWidget.getTranslationZ();
        for (String str : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(str);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.mCustomVariable.put(str, customAttribute);
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void addValues(HashMap map, int i) {
        for (String str : map.keySet()) {
            SplineSet splineSet = (SplineSet) map.get(str);
            str.hashCode();
            float f = BitmapDescriptorFactory.HUE_RED;
            byte b = -1;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        b = 0;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        b = 1;
                    }
                    break;
                case -1249320804:
                    if (str.equals("rotationZ")) {
                        b = 2;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        b = 3;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        b = 4;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        b = 5;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        b = 6;
                    }
                    break;
                case -987906986:
                    if (str.equals("pivotX")) {
                        b = 7;
                    }
                    break;
                case -987906985:
                    if (str.equals("pivotY")) {
                        b = 8;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        b = 9;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        b = 10;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        b = Ascii.f3535VT;
                    }
                    break;
                case 803192288:
                    if (str.equals("pathRotate")) {
                        b = Ascii.f3524FF;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    if (!Float.isNaN(this.rotationX)) {
                        f = this.rotationX;
                    }
                    splineSet.setPoint(i, f);
                    break;
                case 1:
                    if (!Float.isNaN(this.rotationY)) {
                        f = this.rotationY;
                    }
                    splineSet.setPoint(i, f);
                    break;
                case 2:
                    if (!Float.isNaN(this.rotation)) {
                        f = this.rotation;
                    }
                    splineSet.setPoint(i, f);
                    break;
                case 3:
                    if (!Float.isNaN(this.translationX)) {
                        f = this.translationX;
                    }
                    splineSet.setPoint(i, f);
                    break;
                case 4:
                    if (!Float.isNaN(this.translationY)) {
                        f = this.translationY;
                    }
                    splineSet.setPoint(i, f);
                    break;
                case 5:
                    if (!Float.isNaN(this.translationZ)) {
                        f = this.translationZ;
                    }
                    splineSet.setPoint(i, f);
                    break;
                case 6:
                    if (!Float.isNaN(this.mProgress)) {
                        f = this.mProgress;
                    }
                    splineSet.setPoint(i, f);
                    break;
                case 7:
                    if (!Float.isNaN(this.mPivotX)) {
                        f = this.mPivotX;
                    }
                    splineSet.setPoint(i, f);
                    break;
                case 8:
                    if (!Float.isNaN(this.mPivotY)) {
                        f = this.mPivotY;
                    }
                    splineSet.setPoint(i, f);
                    break;
                case 9:
                    splineSet.setPoint(i, Float.isNaN(this.scaleX) ? 1.0f : this.scaleX);
                    break;
                case 10:
                    splineSet.setPoint(i, Float.isNaN(this.scaleY) ? 1.0f : this.scaleY);
                    break;
                case 11:
                    splineSet.setPoint(i, Float.isNaN(this.alpha) ? 1.0f : this.alpha);
                    break;
                case 12:
                    if (!Float.isNaN(this.mPathRotate)) {
                        f = this.mPathRotate;
                    }
                    splineSet.setPoint(i, f);
                    break;
                default:
                    if (!str.startsWith("CUSTOM")) {
                        Utils.loge(MotionPaths.TAG, "UNKNOWN spline " + str);
                    } else {
                        String str2 = str.split(",")[1];
                        if (this.mCustomVariable.containsKey(str2)) {
                            CustomVariable customVariable = (CustomVariable) this.mCustomVariable.get(str2);
                            if (splineSet instanceof SplineSet.CustomSpline) {
                                ((SplineSet.CustomSpline) splineSet).setPoint(i, customVariable);
                            } else {
                                Utils.loge(MotionPaths.TAG, str + " ViewSpline not a CustomSet frame = " + i + ", value" + customVariable.getValueToInterpolate() + splineSet);
                            }
                        }
                    }
                    break;
            }
        }
    }

    public void setState(MotionWidget motionWidget) {
        setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        applyParameters(motionWidget);
    }

    public void setState(Rect rect, MotionWidget motionWidget, int i, float f) {
        setBounds(rect.left, rect.top, rect.width(), rect.height());
        applyParameters(motionWidget);
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        if (i == 1) {
            this.rotation = f - 90.0f;
        } else {
            if (i != 2) {
                return;
            }
            this.rotation = f + 90.0f;
        }
    }
}
