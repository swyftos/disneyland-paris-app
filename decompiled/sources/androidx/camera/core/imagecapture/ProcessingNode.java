package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureResult;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.imagecapture.Bitmap2JpegBytes;
import androidx.camera.core.imagecapture.DngImage2Disk;
import androidx.camera.core.imagecapture.Image2JpegBytes;
import androidx.camera.core.imagecapture.JpegBytes2Disk;
import androidx.camera.core.imagecapture.ProcessingNode;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk;
import androidx.camera.core.internal.compat.quirk.LowMemoryQuirk;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.Edge;
import androidx.camera.core.processing.InternalImageProcessor;
import androidx.camera.core.processing.Node;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class ProcessingNode implements Node<In, Void> {
    private Operation mBitmap2JpegBytes;
    private Operation mBitmapEffect;
    final Executor mBlockingExecutor;
    private final CameraCharacteristics mCameraCharacteristics;
    DngImage2Disk mDngImage2Disk;
    private final boolean mHasIncorrectJpegMetadataQuirk;
    private Operation mImage2Bitmap;
    private Operation mImage2JpegBytes;
    final InternalImageProcessor mImageProcessor;
    private Operation mInput2Packet;
    private In mInputEdge;
    private Operation mJpegBytes2CroppedBitmap;
    private Operation mJpegBytes2Disk;
    private Operation mJpegBytes2Image;
    private Operation mJpegImage2Result;
    private final Quirks mQuirks;

    @Override // androidx.camera.core.processing.Node
    public void release() {
    }

    ProcessingNode(Executor executor, CameraCharacteristics cameraCharacteristics, InternalImageProcessor internalImageProcessor) {
        this(executor, cameraCharacteristics, internalImageProcessor, DeviceQuirks.getAll());
    }

    ProcessingNode(Executor executor, CameraCharacteristics cameraCharacteristics, InternalImageProcessor internalImageProcessor, Quirks quirks) {
        if (DeviceQuirks.get(LowMemoryQuirk.class) != null) {
            this.mBlockingExecutor = CameraXExecutors.newSequentialExecutor(executor);
        } else {
            this.mBlockingExecutor = executor;
        }
        this.mImageProcessor = internalImageProcessor;
        this.mCameraCharacteristics = cameraCharacteristics;
        this.mQuirks = quirks;
        this.mHasIncorrectJpegMetadataQuirk = quirks.contains(IncorrectJpegMetadataQuirk.class);
    }

    @Override // androidx.camera.core.processing.Node
    @NonNull
    public Void transform(@NonNull In in) {
        this.mInputEdge = in;
        in.getEdge().setListener(new Consumer() { // from class: androidx.camera.core.imagecapture.ProcessingNode$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$transform$1((ProcessingNode.InputPacket) obj);
            }
        });
        in.getPostviewEdge().setListener(new Consumer() { // from class: androidx.camera.core.imagecapture.ProcessingNode$$ExternalSyntheticLambda1
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$transform$3((ProcessingNode.InputPacket) obj);
            }
        });
        this.mInput2Packet = new ProcessingInput2Packet();
        this.mImage2JpegBytes = new Image2JpegBytes(this.mQuirks);
        this.mJpegBytes2CroppedBitmap = new JpegBytes2CroppedBitmap();
        this.mBitmap2JpegBytes = new Bitmap2JpegBytes();
        this.mJpegBytes2Disk = new JpegBytes2Disk();
        this.mJpegImage2Result = new JpegImage2Result();
        this.mImage2Bitmap = new Image2Bitmap();
        if (in.getInputFormat() == 35 || this.mImageProcessor != null || this.mHasIncorrectJpegMetadataQuirk) {
            this.mJpegBytes2Image = new JpegBytes2Image();
        }
        InternalImageProcessor internalImageProcessor = this.mImageProcessor;
        if (internalImageProcessor == null) {
            return null;
        }
        this.mBitmapEffect = new BitmapEffect(internalImageProcessor);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$transform$1(final InputPacket inputPacket) {
        if (inputPacket.getProcessingRequest().isAborted()) {
            inputPacket.getImageProxy().close();
        } else {
            this.mBlockingExecutor.execute(new Runnable() { // from class: androidx.camera.core.imagecapture.ProcessingNode$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$transform$0(inputPacket);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$transform$3(final InputPacket inputPacket) {
        if (inputPacket.getProcessingRequest().isAborted()) {
            Logger.w("ProcessingNode", "The postview image is closed due to request aborted");
            inputPacket.getImageProxy().close();
        } else {
            this.mBlockingExecutor.execute(new Runnable() { // from class: androidx.camera.core.imagecapture.ProcessingNode$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$transform$2(inputPacket);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: processInputPacket, reason: merged with bridge method [inline-methods] */
    public void lambda$transform$0(InputPacket inputPacket) {
        final ProcessingRequest processingRequest = inputPacket.getProcessingRequest();
        try {
            boolean z = true;
            if (this.mInputEdge.getOutputFormats().size() <= 1) {
                z = false;
            }
            if (inputPacket.getProcessingRequest().isInMemoryCapture()) {
                final ImageProxy imageProxyProcessInMemoryCapture = processInMemoryCapture(inputPacket);
                CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.ProcessingNode$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        processingRequest.onFinalResult(imageProxyProcessInMemoryCapture);
                    }
                });
            } else {
                final ImageCapture.OutputFileResults outputFileResultsProcessOnDiskCapture = processOnDiskCapture(inputPacket);
                if (!z || processingRequest.getTakePictureRequest().isFormatProcessedInSimultaneousCapture()) {
                    CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.ProcessingNode$$ExternalSyntheticLambda5
                        @Override // java.lang.Runnable
                        public final void run() {
                            processingRequest.onFinalResult(outputFileResultsProcessOnDiskCapture);
                        }
                    });
                }
            }
        } catch (ImageCaptureException e) {
            sendError(processingRequest, e);
        } catch (OutOfMemoryError e2) {
            sendError(processingRequest, new ImageCaptureException(0, "Processing failed due to low memory.", e2));
        } catch (RuntimeException e3) {
            sendError(processingRequest, new ImageCaptureException(0, "Processing failed.", e3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: processPostviewInputPacket, reason: merged with bridge method [inline-methods] */
    public void lambda$transform$2(InputPacket inputPacket) {
        List outputFormats = this.mInputEdge.getOutputFormats();
        boolean z = true;
        Preconditions.checkArgument(!outputFormats.isEmpty());
        Integer num = (Integer) outputFormats.get(0);
        int iIntValue = num.intValue();
        if (iIntValue != 35 && iIntValue != 256) {
            z = false;
        }
        Preconditions.checkArgument(z, String.format("Postview only support YUV and JPEG output formats. Output format: %s", num));
        final ProcessingRequest processingRequest = inputPacket.getProcessingRequest();
        try {
            final Bitmap bitmap = (Bitmap) this.mImage2Bitmap.apply((Packet) this.mInput2Packet.apply(inputPacket));
            CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.ProcessingNode$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    processingRequest.onPostviewBitmapAvailable(bitmap);
                }
            });
        } catch (Exception e) {
            inputPacket.getImageProxy().close();
            Logger.e("ProcessingNode", "process postview input packet failed.", e);
        }
    }

    ImageCapture.OutputFileResults processOnDiskCapture(InputPacket inputPacket) throws ImageCaptureException {
        List outputFormats = this.mInputEdge.getOutputFormats();
        Preconditions.checkArgument(!outputFormats.isEmpty());
        boolean z = false;
        Integer num = (Integer) outputFormats.get(0);
        int iIntValue = num.intValue();
        Preconditions.checkArgument(ImageUtil.isJpegFormats(iIntValue) || ImageUtil.isRawFormats(iIntValue), String.format("On-disk capture only support JPEG and JPEG/R and RAW output formats. Output format: %s", num));
        ProcessingRequest processingRequest = inputPacket.getProcessingRequest();
        Preconditions.checkArgument(processingRequest.getOutputFileOptions() != null, "OutputFileOptions cannot be empty");
        Packet packet = (Packet) this.mInput2Packet.apply(inputPacket);
        if (outputFormats.size() <= 1) {
            if (iIntValue == 32) {
                ImageCapture.OutputFileOptions outputFileOptions = processingRequest.getOutputFileOptions();
                Objects.requireNonNull(outputFileOptions);
                return saveRawToDisk(packet, outputFileOptions);
            }
            ImageCapture.OutputFileOptions outputFileOptions2 = processingRequest.getOutputFileOptions();
            Objects.requireNonNull(outputFileOptions2);
            return saveJpegToDisk(packet, outputFileOptions2, processingRequest.getJpegQuality());
        }
        if (processingRequest.getOutputFileOptions() != null && processingRequest.getSecondaryOutputFileOptions() != null) {
            z = true;
        }
        Preconditions.checkArgument(z, "The number of OutputFileOptions for simultaneous capture should be at least two");
        if (packet.getFormat() == 32) {
            ImageCapture.OutputFileOptions outputFileOptions3 = processingRequest.getOutputFileOptions();
            Objects.requireNonNull(outputFileOptions3);
            ImageCapture.OutputFileResults outputFileResultsSaveRawToDisk = saveRawToDisk(packet, outputFileOptions3);
            processingRequest.getTakePictureRequest().markFormatProcessStatusInSimultaneousCapture(32, true);
            return outputFileResultsSaveRawToDisk;
        }
        ImageCapture.OutputFileOptions secondaryOutputFileOptions = processingRequest.getSecondaryOutputFileOptions();
        Objects.requireNonNull(secondaryOutputFileOptions);
        ImageCapture.OutputFileResults outputFileResultsSaveJpegToDisk = saveJpegToDisk(packet, secondaryOutputFileOptions, processingRequest.getJpegQuality());
        processingRequest.getTakePictureRequest().markFormatProcessStatusInSimultaneousCapture(256, true);
        return outputFileResultsSaveJpegToDisk;
    }

    private ImageCapture.OutputFileResults saveRawToDisk(Packet packet, ImageCapture.OutputFileOptions outputFileOptions) throws ImageCaptureException {
        if (this.mDngImage2Disk == null) {
            if (this.mCameraCharacteristics == null) {
                throw new ImageCaptureException(0, "CameraCharacteristics is null, DngCreator cannot be created", null);
            }
            if (packet.getCameraCaptureResult().getCaptureResult() == null) {
                throw new ImageCaptureException(0, "CameraCaptureResult is null, DngCreator cannot be created", null);
            }
            CameraCharacteristics cameraCharacteristics = this.mCameraCharacteristics;
            Objects.requireNonNull(cameraCharacteristics);
            CaptureResult captureResult = packet.getCameraCaptureResult().getCaptureResult();
            Objects.requireNonNull(captureResult);
            this.mDngImage2Disk = new DngImage2Disk(cameraCharacteristics, captureResult);
        }
        DngImage2Disk dngImage2Disk = this.mDngImage2Disk;
        ImageProxy imageProxy = (ImageProxy) packet.getData();
        int rotationDegrees = packet.getRotationDegrees();
        Objects.requireNonNull(outputFileOptions);
        return dngImage2Disk.apply(DngImage2Disk.In.of(imageProxy, rotationDegrees, outputFileOptions));
    }

    private ImageCapture.OutputFileResults saveJpegToDisk(Packet packet, ImageCapture.OutputFileOptions outputFileOptions, int i) {
        Packet packetCropAndMaybeApplyEffect = (Packet) this.mImage2JpegBytes.apply(Image2JpegBytes.In.of(packet, i));
        if (packetCropAndMaybeApplyEffect.hasCropping() || this.mBitmapEffect != null) {
            packetCropAndMaybeApplyEffect = cropAndMaybeApplyEffect(packetCropAndMaybeApplyEffect, i);
        }
        Operation operation = this.mJpegBytes2Disk;
        Objects.requireNonNull(outputFileOptions);
        return (ImageCapture.OutputFileResults) operation.apply(JpegBytes2Disk.In.of(packetCropAndMaybeApplyEffect, outputFileOptions));
    }

    ImageProxy processInMemoryCapture(InputPacket inputPacket) {
        ProcessingRequest processingRequest = inputPacket.getProcessingRequest();
        Packet packet = (Packet) this.mInput2Packet.apply(inputPacket);
        List outputFormats = this.mInputEdge.getOutputFormats();
        Preconditions.checkArgument(!outputFormats.isEmpty());
        int iIntValue = ((Integer) outputFormats.get(0)).intValue();
        if ((packet.getFormat() == 35 || this.mBitmapEffect != null || this.mHasIncorrectJpegMetadataQuirk) && iIntValue == 256) {
            Packet packetCropAndMaybeApplyEffect = (Packet) this.mImage2JpegBytes.apply(Image2JpegBytes.In.of(packet, processingRequest.getJpegQuality()));
            if (this.mBitmapEffect != null) {
                packetCropAndMaybeApplyEffect = cropAndMaybeApplyEffect(packetCropAndMaybeApplyEffect, processingRequest.getJpegQuality());
            }
            packet = (Packet) this.mJpegBytes2Image.apply(packetCropAndMaybeApplyEffect);
        }
        ImageProxy imageProxy = (ImageProxy) this.mJpegImage2Result.apply(packet);
        if (outputFormats.size() > 1) {
            processingRequest.getTakePictureRequest().markFormatProcessStatusInSimultaneousCapture(imageProxy.getFormat(), true);
        }
        return imageProxy;
    }

    private Packet cropAndMaybeApplyEffect(Packet packet, int i) {
        Preconditions.checkState(ImageUtil.isJpegFormats(packet.getFormat()));
        Packet packet2 = (Packet) this.mJpegBytes2CroppedBitmap.apply(packet);
        Operation operation = this.mBitmapEffect;
        if (operation != null) {
            packet2 = (Packet) operation.apply(packet2);
        }
        return (Packet) this.mBitmap2JpegBytes.apply(Bitmap2JpegBytes.In.of(packet2, i));
    }

    private void sendError(final ProcessingRequest processingRequest, final ImageCaptureException imageCaptureException) {
        CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.ProcessingNode$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                processingRequest.onProcessFailure(imageCaptureException);
            }
        });
    }

    static abstract class InputPacket {
        abstract ImageProxy getImageProxy();

        abstract ProcessingRequest getProcessingRequest();

        InputPacket() {
        }

        static InputPacket of(ProcessingRequest processingRequest, ImageProxy imageProxy) {
            return new AutoValue_ProcessingNode_InputPacket(processingRequest, imageProxy);
        }
    }

    static abstract class In {
        abstract Edge getEdge();

        abstract int getInputFormat();

        abstract List getOutputFormats();

        abstract Edge getPostviewEdge();

        In() {
        }

        static In of(int i, List list) {
            return new AutoValue_ProcessingNode_In(new Edge(), new Edge(), i, list);
        }
    }
}
