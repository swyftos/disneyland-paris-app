package com.mrousavy.camera.core;

import android.media.Image;
import android.util.Log;
import androidx.annotation.OptIn;
import androidx.camera.core.ExperimentalGetImage;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import com.mrousavy.camera.core.CameraConfiguration;
import com.mrousavy.camera.core.CameraSession;
import com.mrousavy.camera.core.types.CodeType;
import com.urbanairship.reactnative.ReactMessageView;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\b\u0010\u0013\u001a\u00020\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/mrousavy/camera/core/CodeScannerPipeline;", "Ljava/io/Closeable;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "configuration", "Lcom/mrousavy/camera/core/CameraConfiguration$CodeScanner;", "callback", "Lcom/mrousavy/camera/core/CameraSession$Callback;", "<init>", "(Lcom/mrousavy/camera/core/CameraConfiguration$CodeScanner;Lcom/mrousavy/camera/core/CameraSession$Callback;)V", "getConfiguration", "()Lcom/mrousavy/camera/core/CameraConfiguration$CodeScanner;", "getCallback", "()Lcom/mrousavy/camera/core/CameraSession$Callback;", "scanner", "Lcom/google/mlkit/vision/barcode/BarcodeScanner;", "analyze", "", "imageProxy", "Landroidx/camera/core/ImageProxy;", ReactMessageView.EVENT_CLOSE, "Companion", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCodeScannerPipeline.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CodeScannerPipeline.kt\ncom/mrousavy/camera/core/CodeScannerPipeline\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,59:1\n1557#2:60\n1628#2,3:61\n*S KotlinDebug\n*F\n+ 1 CodeScannerPipeline.kt\ncom/mrousavy/camera/core/CodeScannerPipeline\n*L\n23#1:60\n23#1:61,3\n*E\n"})
/* loaded from: classes4.dex */
public final class CodeScannerPipeline implements Closeable, ImageAnalysis.Analyzer {
    private final CameraSession.Callback callback;
    private final CameraConfiguration.CodeScanner configuration;
    private final BarcodeScanner scanner;

    public CodeScannerPipeline(@NotNull CameraConfiguration.CodeScanner configuration, @NotNull CameraSession.Callback callback) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.configuration = configuration;
        this.callback = callback;
        List<CodeType> codeTypes = configuration.getCodeTypes();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(codeTypes, 10));
        Iterator<T> it = codeTypes.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((CodeType) it.next()).toBarcodeType()));
        }
        BarcodeScannerOptions.Builder builder = new BarcodeScannerOptions.Builder();
        int iIntValue = ((Number) arrayList.get(0)).intValue();
        int[] intArray = CollectionsKt.toIntArray(arrayList);
        BarcodeScannerOptions barcodeScannerOptionsBuild = builder.setBarcodeFormats(iIntValue, Arrays.copyOf(intArray, intArray.length)).build();
        Intrinsics.checkNotNullExpressionValue(barcodeScannerOptionsBuild, "build(...)");
        this.scanner = BarcodeScanning.getClient(barcodeScannerOptionsBuild);
    }

    @NotNull
    public final CameraSession.Callback getCallback() {
        return this.callback;
    }

    @NotNull
    public final CameraConfiguration.CodeScanner getConfiguration() {
        return this.configuration;
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    @OptIn(markerClass = {ExperimentalGetImage.class})
    public void analyze(@NotNull final ImageProxy imageProxy) throws InvalidImageTypeError {
        Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
        Image image = imageProxy.getImage();
        if (image == null) {
            throw new InvalidImageTypeError();
        }
        try {
            final InputImage inputImageFromMediaImage = InputImage.fromMediaImage(image, imageProxy.getImageInfo().getRotationDegrees());
            Intrinsics.checkNotNullExpressionValue(inputImageFromMediaImage, "fromMediaImage(...)");
            Task<List<Barcode>> taskProcess = this.scanner.process(inputImageFromMediaImage);
            final Function1 function1 = new Function1() { // from class: com.mrousavy.camera.core.CodeScannerPipeline$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CodeScannerPipeline.analyze$lambda$1(this.f$0, inputImageFromMediaImage, (List) obj);
                }
            };
            taskProcess.addOnSuccessListener(new OnSuccessListener() { // from class: com.mrousavy.camera.core.CodeScannerPipeline$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    function1.invoke(obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.mrousavy.camera.core.CodeScannerPipeline$$ExternalSyntheticLambda2
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    CodeScannerPipeline.analyze$lambda$3(this.f$0, exc);
                }
            }).addOnCompleteListener(new OnCompleteListener() { // from class: com.mrousavy.camera.core.CodeScannerPipeline$$ExternalSyntheticLambda3
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    CodeScannerPipeline.analyze$lambda$4(imageProxy, task);
                }
            });
        } catch (Throwable th) {
            Log.e("CodeScannerPipeline", "Failed to process Image!", th);
            imageProxy.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit analyze$lambda$1(CodeScannerPipeline codeScannerPipeline, InputImage inputImage, List list) {
        Intrinsics.checkNotNull(list);
        if (!list.isEmpty()) {
            codeScannerPipeline.callback.onCodeScanned(list, new CodeScannerFrame(inputImage.getWidth(), inputImage.getHeight()));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void analyze$lambda$3(CodeScannerPipeline codeScannerPipeline, Exception error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Log.e("CodeScannerPipeline", "Failed to process Image!", error);
        codeScannerPipeline.callback.onError(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void analyze$lambda$4(ImageProxy imageProxy, Task it) {
        Intrinsics.checkNotNullParameter(it, "it");
        imageProxy.close();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.scanner.close();
    }
}
