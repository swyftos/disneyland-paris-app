package androidx.transition;

/* loaded from: classes2.dex */
abstract class Styleable {
    static final int[] TRANSITION_TARGET = {android.R.attr.targetClass, android.R.attr.targetId, android.R.attr.excludeId, android.R.attr.excludeClass, android.R.attr.targetName, android.R.attr.excludeName};
    static final int[] TRANSITION_MANAGER = {android.R.attr.fromScene, android.R.attr.toScene, android.R.attr.transition};
    static final int[] TRANSITION = {android.R.attr.interpolator, android.R.attr.duration, android.R.attr.startDelay, android.R.attr.matchOrder};
    static final int[] CHANGE_BOUNDS = {android.R.attr.resizeClip};
    static final int[] VISIBILITY_TRANSITION = {android.R.attr.transitionVisibilityMode};
    static final int[] FADE = {android.R.attr.fadingMode};
    static final int[] CHANGE_TRANSFORM = {android.R.attr.reparent, android.R.attr.reparentWithOverlay};
    static final int[] SLIDE = {android.R.attr.slideEdge};
    static final int[] TRANSITION_SET = {android.R.attr.transitionOrdering};
    static final int[] ARC_MOTION = {android.R.attr.minimumHorizontalAngle, android.R.attr.minimumVerticalAngle, android.R.attr.maximumAngle};
    static final int[] PATTERN_PATH_MOTION = {android.R.attr.patternPathData};
}
