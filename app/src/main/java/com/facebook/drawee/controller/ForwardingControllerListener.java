package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.util.Log;
import com.facebook.fresco.p027ui.common.DimensionsInfo;
import com.facebook.fresco.p027ui.common.OnDrawControllerListener;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: classes3.dex */
@ThreadSafe
public class ForwardingControllerListener<INFO> implements ControllerListener<INFO>, OnDrawControllerListener<INFO> {
    private final List mListeners = new ArrayList(2);

    public static <INFO> ForwardingControllerListener<INFO> create() {
        return new ForwardingControllerListener<>();
    }

    /* JADX INFO: renamed from: of */
    public static <INFO> ForwardingControllerListener<INFO> m1351of(ControllerListener<? super INFO> controllerListener) {
        ForwardingControllerListener<INFO> forwardingControllerListenerCreate = create();
        forwardingControllerListenerCreate.addListener(controllerListener);
        return forwardingControllerListenerCreate;
    }

    /* JADX INFO: renamed from: of */
    public static <INFO> ForwardingControllerListener<INFO> m1352of(ControllerListener<? super INFO> controllerListener, ControllerListener<? super INFO> controllerListener2) {
        ForwardingControllerListener<INFO> forwardingControllerListenerCreate = create();
        forwardingControllerListenerCreate.addListener(controllerListener);
        forwardingControllerListenerCreate.addListener(controllerListener2);
        return forwardingControllerListenerCreate;
    }

    public synchronized void addListener(ControllerListener<? super INFO> controllerListener) {
        this.mListeners.add(controllerListener);
    }

    public synchronized void removeListener(ControllerListener<? super INFO> controllerListener) {
        int iIndexOf = this.mListeners.indexOf(controllerListener);
        if (iIndexOf != -1) {
            this.mListeners.set(iIndexOf, null);
        }
    }

    public synchronized void clearListeners() {
        this.mListeners.clear();
    }

    private synchronized void onException(String str, Throwable th) {
        Log.e("FdingControllerListener", str, th);
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void onSubmit(String str, Object obj) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener controllerListener = (ControllerListener) this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onSubmit(str, obj);
                }
            } catch (Exception e) {
                onException("InternalListener exception in onSubmit", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void onFinalImageSet(String str, @Nullable INFO info, @Nullable Animatable animatable) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener controllerListener = (ControllerListener) this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onFinalImageSet(str, info, animatable);
                }
            } catch (Exception e) {
                onException("InternalListener exception in onFinalImageSet", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageSet(String str, @Nullable INFO info) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener controllerListener = (ControllerListener) this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onIntermediateImageSet(str, info);
                }
            } catch (Exception e) {
                onException("InternalListener exception in onIntermediateImageSet", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageFailed(String str, Throwable th) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener controllerListener = (ControllerListener) this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onIntermediateImageFailed(str, th);
                }
            } catch (Exception e) {
                onException("InternalListener exception in onIntermediateImageFailed", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void onFailure(String str, Throwable th) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener controllerListener = (ControllerListener) this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onFailure(str, th);
                }
            } catch (Exception e) {
                onException("InternalListener exception in onFailure", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void onRelease(String str) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener controllerListener = (ControllerListener) this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onRelease(str);
                }
            } catch (Exception e) {
                onException("InternalListener exception in onRelease", e);
            }
        }
    }

    @Override // com.facebook.fresco.p027ui.common.OnDrawControllerListener
    public void onImageDrawn(String str, INFO info, DimensionsInfo dimensionsInfo) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener controllerListener = (ControllerListener) this.mListeners.get(i);
                if (controllerListener instanceof OnDrawControllerListener) {
                    ((OnDrawControllerListener) controllerListener).onImageDrawn(str, info, dimensionsInfo);
                }
            } catch (Exception e) {
                onException("InternalListener exception in onImageDrawn", e);
            }
        }
    }
}
