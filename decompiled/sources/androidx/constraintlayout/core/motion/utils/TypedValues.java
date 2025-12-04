package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes.dex */
public interface TypedValues {
    public static final int BOOLEAN_MASK = 1;
    public static final int FLOAT_MASK = 4;
    public static final int INT_MASK = 2;
    public static final int STRING_MASK = 8;
    public static final String S_CUSTOM = "CUSTOM";
    public static final int TYPE_FRAME_POSITION = 100;
    public static final int TYPE_TARGET = 101;

    public interface OnSwipe {
        public static final String AUTOCOMPLETE_MODE = "autocompletemode";
        public static final String DRAG_DIRECTION = "dragdirection";
        public static final String DRAG_SCALE = "dragscale";
        public static final String DRAG_THRESHOLD = "dragthreshold";
        public static final String LIMIT_BOUNDS_TO = "limitboundsto";
        public static final String MAX_ACCELERATION = "maxacceleration";
        public static final String MAX_VELOCITY = "maxvelocity";
        public static final String MOVE_WHEN_SCROLLAT_TOP = "movewhenscrollattop";
        public static final String NESTED_SCROLL_FLAGS = "nestedscrollflags";
        public static final String ON_TOUCH_UP = "ontouchup";
        public static final String ROTATION_CENTER_ID = "rotationcenterid";
        public static final String SPRINGS_TOP_THRESHOLD = "springstopthreshold";
        public static final String SPRING_BOUNDARY = "springboundary";
        public static final String SPRING_DAMPING = "springdamping";
        public static final String SPRING_MASS = "springmass";
        public static final String SPRING_STIFFNESS = "springstiffness";
        public static final String TOUCH_ANCHOR_ID = "touchanchorid";
        public static final String TOUCH_ANCHOR_SIDE = "touchanchorside";
        public static final String TOUCH_REGION_ID = "touchregionid";
        public static final String[] ON_TOUCH_UP_ENUM = {"autoComplete", "autoCompleteToStart", "autoCompleteToEnd", "stop", "decelerate", "decelerateAndComplete", "neverCompleteToStart", "neverCompleteToEnd"};
        public static final String[] SPRING_BOUNDARY_ENUM = {"overshoot", "bounceStart", "bounceEnd", "bounceBoth"};
        public static final String[] AUTOCOMPLETE_MODE_ENUM = {"continuousVelocity", "spring"};
        public static final String[] NESTED_SCROLL_FLAGS_ENUM = {"none", "disablePostScroll", "disableScroll", "supportScrollUp"};
    }

    int getId(String str);

    boolean setValue(int i, float f);

    boolean setValue(int i, int i2);

    boolean setValue(int i, String str);

    boolean setValue(int i, boolean z);

    public interface AttributesType {
        public static final String NAME = "KeyAttributes";
        public static final String S_ALPHA = "alpha";
        public static final String S_CURVE_FIT = "curveFit";
        public static final String S_CUSTOM = "CUSTOM";
        public static final String S_EASING = "easing";
        public static final String S_ELEVATION = "elevation";
        public static final String S_PATH_ROTATE = "pathRotate";
        public static final String S_PIVOT_X = "pivotX";
        public static final String S_PIVOT_Y = "pivotY";
        public static final String S_PROGRESS = "progress";
        public static final String S_ROTATION_X = "rotationX";
        public static final String S_ROTATION_Y = "rotationY";
        public static final String S_ROTATION_Z = "rotationZ";
        public static final String S_SCALE_X = "scaleX";
        public static final String S_SCALE_Y = "scaleY";
        public static final String S_TRANSLATION_X = "translationX";
        public static final String S_TRANSLATION_Y = "translationY";
        public static final String S_TRANSLATION_Z = "translationZ";
        public static final String S_VISIBILITY = "visibility";
        public static final int TYPE_ALPHA = 303;
        public static final int TYPE_CURVE_FIT = 301;
        public static final int TYPE_EASING = 317;
        public static final int TYPE_ELEVATION = 307;
        public static final int TYPE_PATH_ROTATE = 316;
        public static final int TYPE_PIVOT_TARGET = 318;
        public static final int TYPE_PIVOT_X = 313;
        public static final int TYPE_PIVOT_Y = 314;
        public static final int TYPE_PROGRESS = 315;
        public static final int TYPE_ROTATION_X = 308;
        public static final int TYPE_ROTATION_Y = 309;
        public static final int TYPE_ROTATION_Z = 310;
        public static final int TYPE_SCALE_X = 311;
        public static final int TYPE_SCALE_Y = 312;
        public static final int TYPE_TRANSLATION_X = 304;
        public static final int TYPE_TRANSLATION_Y = 305;
        public static final int TYPE_TRANSLATION_Z = 306;
        public static final int TYPE_VISIBILITY = 302;
        public static final String S_FRAME = "frame";
        public static final String S_TARGET = "target";
        public static final String S_PIVOT_TARGET = "pivotTarget";
        public static final String[] KEY_WORDS = {"curveFit", "visibility", "alpha", "translationX", "translationY", "translationZ", "elevation", "rotationX", "rotationY", "rotationZ", "scaleX", "scaleY", "pivotX", "pivotY", "progress", "pathRotate", "easing", "CUSTOM", S_FRAME, S_TARGET, S_PIVOT_TARGET};

        static int getType(int i) {
            if (i == 100) {
                return 2;
            }
            if (i == 101) {
                return 8;
            }
            switch (i) {
                case 301:
                case 302:
                    return 2;
                case 303:
                case 304:
                case 305:
                case 306:
                case 307:
                case 308:
                case 309:
                case 310:
                case 311:
                case 312:
                case 313:
                case 314:
                case 315:
                case TYPE_PATH_ROTATE /* 316 */:
                    return 4;
                case TYPE_EASING /* 317 */:
                case TYPE_PIVOT_TARGET /* 318 */:
                    return 8;
                default:
                    return -1;
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        static int getId(java.lang.String r2) {
            /*
                Method dump skipped, instructions count: 458
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.TypedValues.AttributesType.getId(java.lang.String):int");
        }
    }

    public interface CycleType {
        public static final String NAME = "KeyCycle";
        public static final String S_ALPHA = "alpha";
        public static final String S_CURVE_FIT = "curveFit";
        public static final String S_EASING = "easing";
        public static final String S_ELEVATION = "elevation";
        public static final String S_PATH_ROTATE = "pathRotate";
        public static final String S_PIVOT_X = "pivotX";
        public static final String S_PIVOT_Y = "pivotY";
        public static final String S_PROGRESS = "progress";
        public static final String S_ROTATION_X = "rotationX";
        public static final String S_ROTATION_Y = "rotationY";
        public static final String S_ROTATION_Z = "rotationZ";
        public static final String S_SCALE_X = "scaleX";
        public static final String S_SCALE_Y = "scaleY";
        public static final String S_TRANSLATION_X = "translationX";
        public static final String S_TRANSLATION_Y = "translationY";
        public static final String S_TRANSLATION_Z = "translationZ";
        public static final String S_VISIBILITY = "visibility";
        public static final String S_WAVE_SHAPE = "waveShape";
        public static final int TYPE_ALPHA = 403;
        public static final int TYPE_CURVE_FIT = 401;
        public static final int TYPE_CUSTOM_WAVE_SHAPE = 422;
        public static final int TYPE_EASING = 420;
        public static final int TYPE_ELEVATION = 307;
        public static final int TYPE_PATH_ROTATE = 416;
        public static final int TYPE_PIVOT_X = 313;
        public static final int TYPE_PIVOT_Y = 314;
        public static final int TYPE_PROGRESS = 315;
        public static final int TYPE_ROTATION_X = 308;
        public static final int TYPE_ROTATION_Y = 309;
        public static final int TYPE_ROTATION_Z = 310;
        public static final int TYPE_SCALE_X = 311;
        public static final int TYPE_SCALE_Y = 312;
        public static final int TYPE_TRANSLATION_X = 304;
        public static final int TYPE_TRANSLATION_Y = 305;
        public static final int TYPE_TRANSLATION_Z = 306;
        public static final int TYPE_VISIBILITY = 402;
        public static final int TYPE_WAVE_OFFSET = 424;
        public static final int TYPE_WAVE_PERIOD = 423;
        public static final int TYPE_WAVE_PHASE = 425;
        public static final int TYPE_WAVE_SHAPE = 421;
        public static final String S_CUSTOM_WAVE_SHAPE = "customWave";
        public static final String S_WAVE_PERIOD = "period";
        public static final String S_WAVE_OFFSET = "offset";
        public static final String S_WAVE_PHASE = "phase";
        public static final String[] KEY_WORDS = {"curveFit", "visibility", "alpha", "translationX", "translationY", "translationZ", "elevation", "rotationX", "rotationY", "rotationZ", "scaleX", "scaleY", "pivotX", "pivotY", "progress", "pathRotate", "easing", "waveShape", S_CUSTOM_WAVE_SHAPE, S_WAVE_PERIOD, S_WAVE_OFFSET, S_WAVE_PHASE};

        static int getType(int i) {
            if (i == 100) {
                return 2;
            }
            if (i == 101) {
                return 8;
            }
            if (i == 416) {
                return 4;
            }
            if (i == 420 || i == 421) {
                return 8;
            }
            switch (i) {
                case 304:
                case 305:
                case 306:
                case 307:
                case 308:
                case 309:
                case 310:
                case 311:
                case 312:
                case 313:
                case 314:
                case 315:
                    return 4;
                default:
                    switch (i) {
                        case TYPE_CURVE_FIT /* 401 */:
                        case TYPE_VISIBILITY /* 402 */:
                            return 2;
                        case 403:
                            return 4;
                        default:
                            switch (i) {
                                case TYPE_WAVE_PERIOD /* 423 */:
                                case TYPE_WAVE_OFFSET /* 424 */:
                                case TYPE_WAVE_PHASE /* 425 */:
                                    return 4;
                                default:
                                    return -1;
                            }
                    }
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        static int getId(java.lang.String r2) {
            /*
                Method dump skipped, instructions count: 366
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.TypedValues.CycleType.getId(java.lang.String):int");
        }
    }

    public interface TriggerType {
        public static final String CROSS = "CROSS";
        public static final String[] KEY_WORDS = {"viewTransitionOnCross", "viewTransitionOnPositiveCross", "viewTransitionOnNegativeCross", "postLayout", "triggerSlack", "triggerCollisionView", "triggerCollisionId", "triggerID", "positiveCross", "negativeCross", "triggerReceiver", "CROSS"};
        public static final String NAME = "KeyTrigger";
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

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        static int getId(java.lang.String r2) {
            /*
                Method dump skipped, instructions count: 274
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.TypedValues.TriggerType.getId(java.lang.String):int");
        }
    }

    public interface PositionType {
        public static final String[] KEY_WORDS = {"transitionEasing", "drawPath", "percentWidth", "percentHeight", "sizePercent", "percentX", "percentY"};
        public static final String NAME = "KeyPosition";
        public static final String S_DRAWPATH = "drawPath";
        public static final String S_PERCENT_HEIGHT = "percentHeight";
        public static final String S_PERCENT_WIDTH = "percentWidth";
        public static final String S_PERCENT_X = "percentX";
        public static final String S_PERCENT_Y = "percentY";
        public static final String S_SIZE_PERCENT = "sizePercent";
        public static final String S_TRANSITION_EASING = "transitionEasing";
        public static final int TYPE_CURVE_FIT = 508;
        public static final int TYPE_DRAWPATH = 502;
        public static final int TYPE_PATH_MOTION_ARC = 509;
        public static final int TYPE_PERCENT_HEIGHT = 504;
        public static final int TYPE_PERCENT_WIDTH = 503;
        public static final int TYPE_PERCENT_X = 506;
        public static final int TYPE_PERCENT_Y = 507;
        public static final int TYPE_POSITION_TYPE = 510;
        public static final int TYPE_SIZE_PERCENT = 505;
        public static final int TYPE_TRANSITION_EASING = 501;

        static int getType(int i) {
            if (i == 100) {
                return 2;
            }
            if (i == 101) {
                return 8;
            }
            switch (i) {
                case TYPE_TRANSITION_EASING /* 501 */:
                case TYPE_DRAWPATH /* 502 */:
                    return 8;
                case TYPE_PERCENT_WIDTH /* 503 */:
                case 504:
                case TYPE_SIZE_PERCENT /* 505 */:
                case TYPE_PERCENT_X /* 506 */:
                case TYPE_PERCENT_Y /* 507 */:
                    return 4;
                case TYPE_CURVE_FIT /* 508 */:
                    return 2;
                default:
                    return -1;
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        static int getId(java.lang.String r2) {
            /*
                r2.hashCode()
                r0 = -1
                int r1 = r2.hashCode()
                switch(r1) {
                    case -1812823328: goto L4f;
                    case -1127236479: goto L44;
                    case -1017587252: goto L39;
                    case -827014263: goto L2e;
                    case -200259324: goto L23;
                    case 428090547: goto L18;
                    case 428090548: goto Ld;
                    default: goto Lb;
                }
            Lb:
                r2 = r0
                goto L59
            Ld:
                java.lang.String r1 = "percentY"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L16
                goto Lb
            L16:
                r2 = 6
                goto L59
            L18:
                java.lang.String r1 = "percentX"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L21
                goto Lb
            L21:
                r2 = 5
                goto L59
            L23:
                java.lang.String r1 = "sizePercent"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L2c
                goto Lb
            L2c:
                r2 = 4
                goto L59
            L2e:
                java.lang.String r1 = "drawPath"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L37
                goto Lb
            L37:
                r2 = 3
                goto L59
            L39:
                java.lang.String r1 = "percentHeight"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L42
                goto Lb
            L42:
                r2 = 2
                goto L59
            L44:
                java.lang.String r1 = "percentWidth"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L4d
                goto Lb
            L4d:
                r2 = 1
                goto L59
            L4f:
                java.lang.String r1 = "transitionEasing"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L58
                goto Lb
            L58:
                r2 = 0
            L59:
                switch(r2) {
                    case 0: goto L6f;
                    case 1: goto L6c;
                    case 2: goto L69;
                    case 3: goto L66;
                    case 4: goto L63;
                    case 5: goto L60;
                    case 6: goto L5d;
                    default: goto L5c;
                }
            L5c:
                return r0
            L5d:
                r2 = 507(0x1fb, float:7.1E-43)
                return r2
            L60:
                r2 = 506(0x1fa, float:7.09E-43)
                return r2
            L63:
                r2 = 505(0x1f9, float:7.08E-43)
                return r2
            L66:
                r2 = 502(0x1f6, float:7.03E-43)
                return r2
            L69:
                r2 = 504(0x1f8, float:7.06E-43)
                return r2
            L6c:
                r2 = 503(0x1f7, float:7.05E-43)
                return r2
            L6f:
                r2 = 501(0x1f5, float:7.02E-43)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.TypedValues.PositionType.getId(java.lang.String):int");
        }
    }

    public interface MotionType {
        public static final String NAME = "Motion";
        public static final int TYPE_ANIMATE_CIRCLEANGLE_TO = 606;
        public static final int TYPE_ANIMATE_RELATIVE_TO = 605;
        public static final int TYPE_DRAW_PATH = 608;
        public static final int TYPE_EASING = 603;
        public static final int TYPE_PATHMOTION_ARC = 607;
        public static final int TYPE_PATH_ROTATE = 601;
        public static final int TYPE_POLAR_RELATIVETO = 609;
        public static final int TYPE_QUANTIZE_INTERPOLATOR = 604;
        public static final int TYPE_QUANTIZE_INTERPOLATOR_ID = 612;
        public static final int TYPE_QUANTIZE_INTERPOLATOR_TYPE = 611;
        public static final int TYPE_QUANTIZE_MOTIONSTEPS = 610;
        public static final int TYPE_QUANTIZE_MOTION_PHASE = 602;
        public static final int TYPE_STAGGER = 600;
        public static final String S_STAGGER = "Stagger";
        public static final String S_PATH_ROTATE = "PathRotate";
        public static final String S_QUANTIZE_MOTION_PHASE = "QuantizeMotionPhase";
        public static final String S_EASING = "TransitionEasing";
        public static final String S_QUANTIZE_INTERPOLATOR = "QuantizeInterpolator";
        public static final String S_ANIMATE_RELATIVE_TO = "AnimateRelativeTo";
        public static final String S_ANIMATE_CIRCLEANGLE_TO = "AnimateCircleAngleTo";
        public static final String S_PATHMOTION_ARC = "PathMotionArc";
        public static final String S_DRAW_PATH = "DrawPath";
        public static final String S_POLAR_RELATIVETO = "PolarRelativeTo";
        public static final String S_QUANTIZE_MOTIONSTEPS = "QuantizeMotionSteps";
        public static final String S_QUANTIZE_INTERPOLATOR_TYPE = "QuantizeInterpolatorType";
        public static final String S_QUANTIZE_INTERPOLATOR_ID = "QuantizeInterpolatorID";
        public static final String[] KEY_WORDS = {S_STAGGER, S_PATH_ROTATE, S_QUANTIZE_MOTION_PHASE, S_EASING, S_QUANTIZE_INTERPOLATOR, S_ANIMATE_RELATIVE_TO, S_ANIMATE_CIRCLEANGLE_TO, S_PATHMOTION_ARC, S_DRAW_PATH, S_POLAR_RELATIVETO, S_QUANTIZE_MOTIONSTEPS, S_QUANTIZE_INTERPOLATOR_TYPE, S_QUANTIZE_INTERPOLATOR_ID};

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        static int getId(java.lang.String r2) {
            /*
                Method dump skipped, instructions count: 296
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.TypedValues.MotionType.getId(java.lang.String):int");
        }
    }

    public interface Custom {
        public static final String NAME = "Custom";
        public static final String S_BOOLEAN = "boolean";
        public static final String S_COLOR = "color";
        public static final String S_INT = "integer";
        public static final String S_STRING = "string";
        public static final int TYPE_BOOLEAN = 904;
        public static final int TYPE_COLOR = 902;
        public static final int TYPE_DIMENSION = 905;
        public static final int TYPE_FLOAT = 901;
        public static final int TYPE_INT = 900;
        public static final int TYPE_REFERENCE = 906;
        public static final int TYPE_STRING = 903;
        public static final String S_FLOAT = "float";
        public static final String S_DIMENSION = "dimension";
        public static final String S_REFERENCE = "refrence";
        public static final String[] KEY_WORDS = {S_FLOAT, "color", "string", "boolean", S_DIMENSION, S_REFERENCE};

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        static int getId(java.lang.String r2) {
            /*
                r2.hashCode()
                r0 = -1
                int r1 = r2.hashCode()
                switch(r1) {
                    case -1095013018: goto L4f;
                    case -891985903: goto L44;
                    case -710953590: goto L39;
                    case 64711720: goto L2e;
                    case 94842723: goto L23;
                    case 97526364: goto L18;
                    case 1958052158: goto Ld;
                    default: goto Lb;
                }
            Lb:
                r2 = r0
                goto L59
            Ld:
                java.lang.String r1 = "integer"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L16
                goto Lb
            L16:
                r2 = 6
                goto L59
            L18:
                java.lang.String r1 = "float"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L21
                goto Lb
            L21:
                r2 = 5
                goto L59
            L23:
                java.lang.String r1 = "color"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L2c
                goto Lb
            L2c:
                r2 = 4
                goto L59
            L2e:
                java.lang.String r1 = "boolean"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L37
                goto Lb
            L37:
                r2 = 3
                goto L59
            L39:
                java.lang.String r1 = "refrence"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L42
                goto Lb
            L42:
                r2 = 2
                goto L59
            L44:
                java.lang.String r1 = "string"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L4d
                goto Lb
            L4d:
                r2 = 1
                goto L59
            L4f:
                java.lang.String r1 = "dimension"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L58
                goto Lb
            L58:
                r2 = 0
            L59:
                switch(r2) {
                    case 0: goto L6f;
                    case 1: goto L6c;
                    case 2: goto L69;
                    case 3: goto L66;
                    case 4: goto L63;
                    case 5: goto L60;
                    case 6: goto L5d;
                    default: goto L5c;
                }
            L5c:
                return r0
            L5d:
                r2 = 900(0x384, float:1.261E-42)
                return r2
            L60:
                r2 = 901(0x385, float:1.263E-42)
                return r2
            L63:
                r2 = 902(0x386, float:1.264E-42)
                return r2
            L66:
                r2 = 904(0x388, float:1.267E-42)
                return r2
            L69:
                r2 = 906(0x38a, float:1.27E-42)
                return r2
            L6c:
                r2 = 903(0x387, float:1.265E-42)
                return r2
            L6f:
                r2 = 905(0x389, float:1.268E-42)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.TypedValues.Custom.getId(java.lang.String):int");
        }
    }

    public interface MotionScene {
        public static final String NAME = "MotionScene";
        public static final int TYPE_DEFAULT_DURATION = 600;
        public static final int TYPE_LAYOUT_DURING_TRANSITION = 601;
        public static final String S_DEFAULT_DURATION = "defaultDuration";
        public static final String S_LAYOUT_DURING_TRANSITION = "layoutDuringTransition";
        public static final String[] KEY_WORDS = {S_DEFAULT_DURATION, S_LAYOUT_DURING_TRANSITION};

        static int getType(int i) {
            if (i != 600) {
                return i != 601 ? -1 : 1;
            }
            return 2;
        }

        static int getId(String str) {
            str.hashCode();
            if (str.equals(S_DEFAULT_DURATION)) {
                return 600;
            }
            return !str.equals(S_LAYOUT_DURING_TRANSITION) ? -1 : 601;
        }
    }

    public interface TransitionType {
        public static final String NAME = "Transitions";
        public static final String S_FROM = "from";
        public static final int TYPE_AUTO_TRANSITION = 704;
        public static final int TYPE_DURATION = 700;
        public static final int TYPE_FROM = 701;
        public static final int TYPE_INTERPOLATOR = 705;
        public static final int TYPE_PATH_MOTION_ARC = 509;
        public static final int TYPE_STAGGERED = 706;
        public static final int TYPE_TO = 702;
        public static final int TYPE_TRANSITION_FLAGS = 707;
        public static final String S_DURATION = "duration";
        public static final String S_TO = "to";
        public static final String S_PATH_MOTION_ARC = "pathMotionArc";
        public static final String S_AUTO_TRANSITION = "autoTransition";
        public static final String S_INTERPOLATOR = "motionInterpolator";
        public static final String S_STAGGERED = "staggered";
        public static final String S_TRANSITION_FLAGS = "transitionFlags";
        public static final String[] KEY_WORDS = {S_DURATION, "from", S_TO, S_PATH_MOTION_ARC, S_AUTO_TRANSITION, S_INTERPOLATOR, S_STAGGERED, "from", S_TRANSITION_FLAGS};

        static int getType(int i) {
            if (i == 509) {
                return 2;
            }
            switch (i) {
                case 700:
                    return 2;
                case TYPE_FROM /* 701 */:
                case 702:
                    return 8;
                default:
                    switch (i) {
                        case TYPE_INTERPOLATOR /* 705 */:
                        case TYPE_TRANSITION_FLAGS /* 707 */:
                            return 8;
                        case 706:
                            return 4;
                        default:
                            return -1;
                    }
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        static int getId(java.lang.String r2) {
            /*
                r2.hashCode()
                r0 = -1
                int r1 = r2.hashCode()
                switch(r1) {
                    case -1996906958: goto L5b;
                    case -1992012396: goto L50;
                    case -1357874275: goto L45;
                    case -1298065308: goto L3a;
                    case 3707: goto L2f;
                    case 3151786: goto L24;
                    case 1310733335: goto L19;
                    case 1839260940: goto Le;
                    default: goto Lb;
                }
            Lb:
                r2 = r0
                goto L65
            Le:
                java.lang.String r1 = "staggered"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L17
                goto Lb
            L17:
                r2 = 7
                goto L65
            L19:
                java.lang.String r1 = "pathMotionArc"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L22
                goto Lb
            L22:
                r2 = 6
                goto L65
            L24:
                java.lang.String r1 = "from"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L2d
                goto Lb
            L2d:
                r2 = 5
                goto L65
            L2f:
                java.lang.String r1 = "to"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L38
                goto Lb
            L38:
                r2 = 4
                goto L65
            L3a:
                java.lang.String r1 = "autoTransition"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L43
                goto Lb
            L43:
                r2 = 3
                goto L65
            L45:
                java.lang.String r1 = "motionInterpolator"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L4e
                goto Lb
            L4e:
                r2 = 2
                goto L65
            L50:
                java.lang.String r1 = "duration"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L59
                goto Lb
            L59:
                r2 = 1
                goto L65
            L5b:
                java.lang.String r1 = "transitionFlags"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L64
                goto Lb
            L64:
                r2 = 0
            L65:
                switch(r2) {
                    case 0: goto L7e;
                    case 1: goto L7b;
                    case 2: goto L78;
                    case 3: goto L75;
                    case 4: goto L72;
                    case 5: goto L6f;
                    case 6: goto L6c;
                    case 7: goto L69;
                    default: goto L68;
                }
            L68:
                return r0
            L69:
                r2 = 706(0x2c2, float:9.9E-43)
                return r2
            L6c:
                r2 = 509(0x1fd, float:7.13E-43)
                return r2
            L6f:
                r2 = 701(0x2bd, float:9.82E-43)
                return r2
            L72:
                r2 = 702(0x2be, float:9.84E-43)
                return r2
            L75:
                r2 = 704(0x2c0, float:9.87E-43)
                return r2
            L78:
                r2 = 705(0x2c1, float:9.88E-43)
                return r2
            L7b:
                r2 = 700(0x2bc, float:9.81E-43)
                return r2
            L7e:
                r2 = 707(0x2c3, float:9.91E-43)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.TypedValues.TransitionType.getId(java.lang.String):int");
        }
    }
}
