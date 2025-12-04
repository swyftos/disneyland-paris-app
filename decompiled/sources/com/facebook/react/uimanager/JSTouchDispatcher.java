package com.facebook.react.uimanager;

import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.TouchEvent;
import com.facebook.react.uimanager.events.TouchEventCoalescingKeyHelper;
import com.facebook.react.uimanager.events.TouchEventType;

@Nullsafe(Nullsafe.Mode.LOCAL)
/* loaded from: classes3.dex */
public class JSTouchDispatcher {
    private final ViewGroup mViewGroup;
    private int mTargetTag = -1;
    private final float[] mTargetCoordinates = new float[2];
    private boolean mChildIsHandlingNativeGesture = false;
    private long mGestureStartTime = Long.MIN_VALUE;
    private final TouchEventCoalescingKeyHelper mTouchEventCoalescingKeyHelper = new TouchEventCoalescingKeyHelper();

    public JSTouchDispatcher(ViewGroup viewGroup) {
        this.mViewGroup = viewGroup;
    }

    public void onChildStartedNativeGesture(MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        if (this.mChildIsHandlingNativeGesture) {
            return;
        }
        dispatchCancelEvent(motionEvent, eventDispatcher);
        this.mChildIsHandlingNativeGesture = true;
        this.mTargetTag = -1;
    }

    public void onChildEndedNativeGesture(MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        this.mChildIsHandlingNativeGesture = false;
    }

    public void handleTouchEvent(MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        handleTouchEvent(motionEvent, eventDispatcher, null);
    }

    public void handleTouchEvent(MotionEvent motionEvent, EventDispatcher eventDispatcher, @Nullable ReactContext reactContext) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mTargetTag != -1) {
                FLog.e(ReactConstants.TAG, "Got DOWN touch before receiving UP or CANCEL from last gesture");
            }
            this.mChildIsHandlingNativeGesture = false;
            this.mGestureStartTime = motionEvent.getEventTime();
            this.mTargetTag = findTargetTagAndSetCoordinates(motionEvent);
            markActiveTouchForTag(UIManagerHelper.getSurfaceId(this.mViewGroup), this.mTargetTag, reactContext);
            int surfaceId = UIManagerHelper.getSurfaceId(this.mViewGroup);
            int i = this.mTargetTag;
            TouchEventType touchEventType = TouchEventType.START;
            long j = this.mGestureStartTime;
            float[] fArr = this.mTargetCoordinates;
            eventDispatcher.dispatchEvent(TouchEvent.obtain(surfaceId, i, touchEventType, motionEvent, j, fArr[0], fArr[1], this.mTouchEventCoalescingKeyHelper));
            return;
        }
        if (this.mChildIsHandlingNativeGesture) {
            return;
        }
        if (this.mTargetTag == -1) {
            FLog.e(ReactConstants.TAG, "Unexpected state: received touch event but didn't get starting ACTION_DOWN for this gesture before");
            return;
        }
        if (action == 1) {
            findTargetTagAndSetCoordinates(motionEvent);
            int surfaceId2 = UIManagerHelper.getSurfaceId(this.mViewGroup);
            int i2 = this.mTargetTag;
            TouchEventType touchEventType2 = TouchEventType.END;
            long j2 = this.mGestureStartTime;
            float[] fArr2 = this.mTargetCoordinates;
            eventDispatcher.dispatchEvent(TouchEvent.obtain(surfaceId2, i2, touchEventType2, motionEvent, j2, fArr2[0], fArr2[1], this.mTouchEventCoalescingKeyHelper));
            sweepActiveTouchForTag(surfaceId2, this.mTargetTag, reactContext);
            this.mTargetTag = -1;
            this.mGestureStartTime = Long.MIN_VALUE;
            return;
        }
        if (action == 2) {
            findTargetTagAndSetCoordinates(motionEvent);
            int surfaceId3 = UIManagerHelper.getSurfaceId(this.mViewGroup);
            int i3 = this.mTargetTag;
            TouchEventType touchEventType3 = TouchEventType.MOVE;
            long j3 = this.mGestureStartTime;
            float[] fArr3 = this.mTargetCoordinates;
            eventDispatcher.dispatchEvent(TouchEvent.obtain(surfaceId3, i3, touchEventType3, motionEvent, j3, fArr3[0], fArr3[1], this.mTouchEventCoalescingKeyHelper));
            return;
        }
        if (action == 5) {
            int surfaceId4 = UIManagerHelper.getSurfaceId(this.mViewGroup);
            int i4 = this.mTargetTag;
            TouchEventType touchEventType4 = TouchEventType.START;
            long j4 = this.mGestureStartTime;
            float[] fArr4 = this.mTargetCoordinates;
            eventDispatcher.dispatchEvent(TouchEvent.obtain(surfaceId4, i4, touchEventType4, motionEvent, j4, fArr4[0], fArr4[1], this.mTouchEventCoalescingKeyHelper));
            return;
        }
        if (action == 6) {
            int surfaceId5 = UIManagerHelper.getSurfaceId(this.mViewGroup);
            int i5 = this.mTargetTag;
            TouchEventType touchEventType5 = TouchEventType.END;
            long j5 = this.mGestureStartTime;
            float[] fArr5 = this.mTargetCoordinates;
            eventDispatcher.dispatchEvent(TouchEvent.obtain(surfaceId5, i5, touchEventType5, motionEvent, j5, fArr5[0], fArr5[1], this.mTouchEventCoalescingKeyHelper));
            return;
        }
        if (action == 3) {
            if (!this.mTouchEventCoalescingKeyHelper.hasCoalescingKey(motionEvent.getDownTime())) {
                FLog.e(ReactConstants.TAG, "Received an ACTION_CANCEL touch event for which we have no corresponding ACTION_DOWN");
            } else {
                dispatchCancelEvent(motionEvent, eventDispatcher);
            }
            sweepActiveTouchForTag(UIManagerHelper.getSurfaceId(this.mViewGroup), this.mTargetTag, reactContext);
            this.mTargetTag = -1;
            this.mGestureStartTime = Long.MIN_VALUE;
            return;
        }
        FLog.w(ReactConstants.TAG, "Warning : touch event was ignored. Action=" + action + " Target=" + this.mTargetTag);
    }

    private void markActiveTouchForTag(int i, int i2, @Nullable ReactContext reactContext) {
        UIManager uIManager;
        if (reactContext == null || (uIManager = UIManagerHelper.getUIManager(reactContext, 2)) == null) {
            return;
        }
        uIManager.markActiveTouchForTag(i, i2);
    }

    private void sweepActiveTouchForTag(int i, int i2, @Nullable ReactContext reactContext) {
        UIManager uIManager;
        if (reactContext == null || (uIManager = UIManagerHelper.getUIManager(reactContext, 2)) == null) {
            return;
        }
        uIManager.sweepActiveTouchForTag(i, i2);
    }

    private int findTargetTagAndSetCoordinates(MotionEvent motionEvent) {
        return TouchTargetHelper.findTargetTagAndCoordinatesForTouch(motionEvent.getX(), motionEvent.getY(), this.mViewGroup, this.mTargetCoordinates, null);
    }

    private void dispatchCancelEvent(MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        if (this.mTargetTag == -1) {
            FLog.w(ReactConstants.TAG, "Can't cancel already finished gesture. Is a child View trying to start a gesture from an UP/CANCEL event?");
            return;
        }
        Assertions.assertCondition(!this.mChildIsHandlingNativeGesture, "Expected to not have already sent a cancel for this gesture");
        EventDispatcher eventDispatcher2 = (EventDispatcher) Assertions.assertNotNull(eventDispatcher);
        int surfaceId = UIManagerHelper.getSurfaceId(this.mViewGroup);
        int i = this.mTargetTag;
        TouchEventType touchEventType = TouchEventType.CANCEL;
        long j = this.mGestureStartTime;
        float[] fArr = this.mTargetCoordinates;
        eventDispatcher2.dispatchEvent(TouchEvent.obtain(surfaceId, i, touchEventType, motionEvent, j, fArr[0], fArr[1], this.mTouchEventCoalescingKeyHelper));
    }
}
