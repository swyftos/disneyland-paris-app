package com.mrousavy.camera.frameprocessors;

import android.hardware.HardwareBuffer;
import android.media.Image;
import androidx.annotation.OptIn;
import androidx.camera.core.ExperimentalGetImage;
import androidx.camera.core.ImageProxy;
import com.facebook.proguard.annotations.DoNotStrip;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.mrousavy.camera.core.FrameInvalidError;
import com.mrousavy.camera.core.HardwareBuffersNotAvailableError;
import com.mrousavy.camera.core.types.Orientation;
import com.mrousavy.camera.core.types.PixelFormat;

/* loaded from: classes4.dex */
public class Frame {
    private final ImageProxy imageProxy;
    private int refCount = 0;

    public Frame(ImageProxy imageProxy) {
        this.imageProxy = imageProxy;
    }

    private void assertIsValid() throws FrameInvalidError {
        if (!getIsImageValid(this.imageProxy)) {
            throw new FrameInvalidError();
        }
    }

    public ImageProxy getImageProxy() throws FrameInvalidError {
        assertIsValid();
        return this.imageProxy;
    }

    @OptIn(markerClass = {ExperimentalGetImage.class})
    public Image getImage() throws FrameInvalidError {
        assertIsValid();
        Image image = this.imageProxy.getImage();
        if (image != null) {
            return image;
        }
        throw new FrameInvalidError();
    }

    @DoNotStrip
    public int getWidth() throws FrameInvalidError {
        assertIsValid();
        return this.imageProxy.getWidth();
    }

    @DoNotStrip
    public int getHeight() throws FrameInvalidError {
        assertIsValid();
        return this.imageProxy.getHeight();
    }

    @DoNotStrip
    public boolean getIsValid() {
        return getIsImageValid(this.imageProxy);
    }

    @DoNotStrip
    public boolean getIsMirrored() throws FrameInvalidError {
        assertIsValid();
        float[] fArr = new float[9];
        this.imageProxy.getImageInfo().getSensorToBufferTransformMatrix().getValues(fArr);
        return fArr[0] < BitmapDescriptorFactory.HUE_RED;
    }

    @DoNotStrip
    public long getTimestamp() throws FrameInvalidError {
        assertIsValid();
        return this.imageProxy.getImageInfo().getTimestamp();
    }

    @DoNotStrip
    public Orientation getOrientation() throws FrameInvalidError {
        assertIsValid();
        return Orientation.INSTANCE.fromRotationDegrees(this.imageProxy.getImageInfo().getRotationDegrees()).reversed();
    }

    @DoNotStrip
    public PixelFormat getPixelFormat() throws FrameInvalidError {
        assertIsValid();
        return PixelFormat.INSTANCE.fromImageFormat(this.imageProxy.getFormat());
    }

    @DoNotStrip
    public int getPlanesCount() throws FrameInvalidError {
        assertIsValid();
        return this.imageProxy.getPlanes().length;
    }

    @DoNotStrip
    public int getBytesPerRow() throws FrameInvalidError {
        assertIsValid();
        return this.imageProxy.getPlanes()[0].getRowStride();
    }

    @DoNotStrip
    private Object getHardwareBufferBoxed() throws HardwareBuffersNotAvailableError, FrameInvalidError {
        return getHardwareBuffer();
    }

    public HardwareBuffer getHardwareBuffer() throws HardwareBuffersNotAvailableError, FrameInvalidError {
        assertIsValid();
        return getImage().getHardwareBuffer();
    }

    private synchronized boolean getIsImageValid(ImageProxy imageProxy) {
        if (this.refCount <= 0) {
            return false;
        }
        try {
            imageProxy.getFormat();
            return true;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @DoNotStrip
    public synchronized void incrementRefCount() {
        this.refCount++;
    }

    @DoNotStrip
    public synchronized void decrementRefCount() {
        int i = this.refCount - 1;
        this.refCount = i;
        if (i <= 0) {
            close();
        }
    }

    private void close() {
        this.imageProxy.close();
    }
}
