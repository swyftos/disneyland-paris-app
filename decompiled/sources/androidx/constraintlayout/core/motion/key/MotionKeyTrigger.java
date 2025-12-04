package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public class MotionKeyTrigger extends MotionKey {
    public static final String CROSS = "CROSS";
    public static final int KEY_TYPE = 5;
    public static final String NEGATIVE_CROSS = "negativeCross";
    public static final String POSITIVE_CROSS = "positiveCross";
    public static final String POST_LAYOUT = "postLayout";
    public static final String TRIGGER_COLLISION_ID = "triggerCollisionId";
    public static final String TRIGGER_COLLISION_VIEW = "triggerCollisionView";
    public static final String TRIGGER_ID = "triggerID";
    public static final String TRIGGER_RECEIVER = "triggerReceiver";
    public static final String TRIGGER_SLACK = "triggerSlack";
    public static final int TYPE_CROSS = 312;
    public static final int TYPE_NEGATIVE_CROSS = 310;
    public static final int TYPE_POSITIVE_CROSS = 309;
    public static final int TYPE_POST_LAYOUT = 304;
    public static final int TYPE_TRIGGER_COLLISION_ID = 307;
    public static final int TYPE_TRIGGER_COLLISION_VIEW = 306;
    public static final int TYPE_TRIGGER_ID = 308;
    public static final int TYPE_TRIGGER_RECEIVER = 311;
    public static final int TYPE_TRIGGER_SLACK = 305;
    public static final int TYPE_VIEW_TRANSITION_ON_CROSS = 301;
    public static final int TYPE_VIEW_TRANSITION_ON_NEGATIVE_CROSS = 303;
    public static final int TYPE_VIEW_TRANSITION_ON_POSITIVE_CROSS = 302;
    public static final String VIEW_TRANSITION_ON_CROSS = "viewTransitionOnCross";
    public static final String VIEW_TRANSITION_ON_NEGATIVE_CROSS = "viewTransitionOnNegativeCross";
    public static final String VIEW_TRANSITION_ON_POSITIVE_CROSS = "viewTransitionOnPositiveCross";
    FloatRect mCollisionRect;
    private boolean mFireCrossReset;
    private float mFireLastPos;
    private boolean mFireNegativeReset;
    private boolean mFirePositiveReset;
    private float mFireThreshold;
    private String mNegativeCross;
    private String mPositiveCross;
    private boolean mPostLayout;
    FloatRect mTargetRect;
    private int mTriggerCollisionId;
    private int mTriggerID;
    private int mTriggerReceiver;
    float mTriggerSlack;
    int mViewTransitionOnCross;
    int mViewTransitionOnNegativeCross;
    int mViewTransitionOnPositiveCross;
    private int mCurveFit = -1;
    private String mCross = null;

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> map) {
    }

    public void conditionallyFire(float f, MotionWidget motionWidget) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> hashSet) {
    }

    public MotionKeyTrigger() {
        int i = MotionKey.UNSET;
        this.mTriggerReceiver = i;
        this.mNegativeCross = null;
        this.mPositiveCross = null;
        this.mTriggerID = i;
        this.mTriggerCollisionId = i;
        this.mTriggerSlack = 0.1f;
        this.mFireCrossReset = true;
        this.mFireNegativeReset = true;
        this.mFirePositiveReset = true;
        this.mFireThreshold = Float.NaN;
        this.mPostLayout = false;
        this.mViewTransitionOnNegativeCross = i;
        this.mViewTransitionOnPositiveCross = i;
        this.mViewTransitionOnCross = i;
        this.mCollisionRect = new FloatRect();
        this.mTargetRect = new FloatRect();
        this.mType = 5;
        this.mCustom = new HashMap<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getId(java.lang.String r2) {
        /*
            r1 = this;
            r2.hashCode()
            r1 = -1
            int r0 = r2.hashCode()
            switch(r0) {
                case -1594793529: goto L82;
                case -966421266: goto L77;
                case -786670827: goto L6c;
                case -648752941: goto L61;
                case -638126837: goto L56;
                case -76025313: goto L4b;
                case -9754574: goto L40;
                case 364489912: goto L35;
                case 1301930599: goto L28;
                case 1401391082: goto L1b;
                case 1535404999: goto Le;
                default: goto Lb;
            }
        Lb:
            r2 = r1
            goto L8c
        Le:
            java.lang.String r0 = "triggerReceiver"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L17
            goto Lb
        L17:
            r2 = 10
            goto L8c
        L1b:
            java.lang.String r0 = "postLayout"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L24
            goto Lb
        L24:
            r2 = 9
            goto L8c
        L28:
            java.lang.String r0 = "viewTransitionOnCross"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L31
            goto Lb
        L31:
            r2 = 8
            goto L8c
        L35:
            java.lang.String r0 = "triggerSlack"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L3e
            goto Lb
        L3e:
            r2 = 7
            goto L8c
        L40:
            java.lang.String r0 = "viewTransitionOnNegativeCross"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L49
            goto Lb
        L49:
            r2 = 6
            goto L8c
        L4b:
            java.lang.String r0 = "triggerCollisionView"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L54
            goto Lb
        L54:
            r2 = 5
            goto L8c
        L56:
            java.lang.String r0 = "negativeCross"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L5f
            goto Lb
        L5f:
            r2 = 4
            goto L8c
        L61:
            java.lang.String r0 = "triggerID"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L6a
            goto Lb
        L6a:
            r2 = 3
            goto L8c
        L6c:
            java.lang.String r0 = "triggerCollisionId"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L75
            goto Lb
        L75:
            r2 = 2
            goto L8c
        L77:
            java.lang.String r0 = "viewTransitionOnPositiveCross"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L80
            goto Lb
        L80:
            r2 = 1
            goto L8c
        L82:
            java.lang.String r0 = "positiveCross"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L8b
            goto Lb
        L8b:
            r2 = 0
        L8c:
            switch(r2) {
                case 0: goto Lae;
                case 1: goto Lab;
                case 2: goto La8;
                case 3: goto La5;
                case 4: goto La2;
                case 5: goto L9f;
                case 6: goto L9c;
                case 7: goto L99;
                case 8: goto L96;
                case 9: goto L93;
                case 10: goto L90;
                default: goto L8f;
            }
        L8f:
            return r1
        L90:
            r1 = 311(0x137, float:4.36E-43)
            return r1
        L93:
            r1 = 304(0x130, float:4.26E-43)
            return r1
        L96:
            r1 = 301(0x12d, float:4.22E-43)
            return r1
        L99:
            r1 = 305(0x131, float:4.27E-43)
            return r1
        L9c:
            r1 = 303(0x12f, float:4.25E-43)
            return r1
        L9f:
            r1 = 306(0x132, float:4.29E-43)
            return r1
        La2:
            r1 = 310(0x136, float:4.34E-43)
            return r1
        La5:
            r1 = 308(0x134, float:4.32E-43)
            return r1
        La8:
            r1 = 307(0x133, float:4.3E-43)
            return r1
        Lab:
            r1 = 302(0x12e, float:4.23E-43)
            return r1
        Lae:
            r1 = 309(0x135, float:4.33E-43)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.key.MotionKeyTrigger.getId(java.lang.String):int");
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKeyTrigger copy(MotionKey motionKey) {
        super.copy(motionKey);
        MotionKeyTrigger motionKeyTrigger = (MotionKeyTrigger) motionKey;
        this.mCurveFit = motionKeyTrigger.mCurveFit;
        this.mCross = motionKeyTrigger.mCross;
        this.mTriggerReceiver = motionKeyTrigger.mTriggerReceiver;
        this.mNegativeCross = motionKeyTrigger.mNegativeCross;
        this.mPositiveCross = motionKeyTrigger.mPositiveCross;
        this.mTriggerID = motionKeyTrigger.mTriggerID;
        this.mTriggerCollisionId = motionKeyTrigger.mTriggerCollisionId;
        this.mTriggerSlack = motionKeyTrigger.mTriggerSlack;
        this.mFireCrossReset = motionKeyTrigger.mFireCrossReset;
        this.mFireNegativeReset = motionKeyTrigger.mFireNegativeReset;
        this.mFirePositiveReset = motionKeyTrigger.mFirePositiveReset;
        this.mFireThreshold = motionKeyTrigger.mFireThreshold;
        this.mFireLastPos = motionKeyTrigger.mFireLastPos;
        this.mPostLayout = motionKeyTrigger.mPostLayout;
        this.mCollisionRect = motionKeyTrigger.mCollisionRect;
        this.mTargetRect = motionKeyTrigger.mTargetRect;
        return this;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* renamed from: clone */
    public MotionKey mo198clone() {
        return new MotionKeyTrigger().copy((MotionKey) this);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i2) {
        if (i == 307) {
            this.mTriggerCollisionId = i2;
            return true;
        }
        if (i == 308) {
            this.mTriggerID = toInt(Integer.valueOf(i2));
            return true;
        }
        if (i == 311) {
            this.mTriggerReceiver = i2;
            return true;
        }
        switch (i) {
            case 301:
                this.mViewTransitionOnCross = i2;
                return true;
            case 302:
                this.mViewTransitionOnPositiveCross = i2;
                return true;
            case 303:
                this.mViewTransitionOnNegativeCross = i2;
                return true;
            default:
                return super.setValue(i, i2);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        if (i == 305) {
            this.mTriggerSlack = f;
            return true;
        }
        return super.setValue(i, f);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (i == 309) {
            this.mPositiveCross = str;
            return true;
        }
        if (i == 310) {
            this.mNegativeCross = str;
            return true;
        }
        if (i == 312) {
            this.mCross = str;
            return true;
        }
        return super.setValue(i, str);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, boolean z) {
        if (i == 304) {
            this.mPostLayout = z;
            return true;
        }
        return super.setValue(i, z);
    }
}
