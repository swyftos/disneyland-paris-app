package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstall;
import com.google.android.gms.common.moduleinstall.ModuleInstallRequest;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_common.zzaf;
import com.google.android.gms.internal.mlkit_common.zzah;
import com.google.android.gms.internal.mlkit_common.zzai;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Tasks;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@KeepForSdk
/* loaded from: classes4.dex */
public class OptionalModuleUtils {

    @NonNull
    @KeepForSdk
    public static final String BARCODE = "barcode";

    @NonNull
    @KeepForSdk
    public static final String BARCODE_MODULE_ID = "com.google.android.gms.vision.barcode";

    @NonNull
    @KeepForSdk
    public static final String CUSTOM_ICA = "custom_ica";

    @NonNull
    @KeepForSdk
    public static final String CUSTOM_ICA_MODULE_ID = "com.google.android.gms.vision.custom.ica";

    @NonNull
    @KeepForSdk
    public static final String DEPRECATED_DYNAMITE_MODULE_ID = "com.google.android.gms.vision.dynamite";

    @NonNull
    @KeepForSdk
    public static final String DOCSCAN_CROP_MODULE_ID = "com.google.android.gms.mlkit_docscan_crop";

    @NonNull
    @KeepForSdk
    public static final String DOCSCAN_DETECT_MODULE_ID = "com.google.android.gms.mlkit_docscan_detect";

    @NonNull
    @KeepForSdk
    public static final String DOCSCAN_ENHANCE_MODULE_ID = "com.google.android.gms.mlkit_docscan_enhance";

    @NonNull
    @KeepForSdk
    public static final String DOCSCAN_SHADOW_REMOVAL_MODULE_ID = "com.google.android.gms.mlkit_docscan_shadow";

    @NonNull
    @KeepForSdk
    public static final String DOCSCAN_STAIN_REMOVAL_MODULE_ID = "com.google.android.gms.mlkit_docscan_stain";

    @NonNull
    @KeepForSdk
    public static final Feature[] EMPTY_FEATURES = new Feature[0];

    @NonNull
    @KeepForSdk
    public static final String FACE = "face";

    @NonNull
    @KeepForSdk
    public static final String FACE_MODULE_ID = "com.google.android.gms.vision.face";

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_BARCODE;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_CUSTOM_ICA;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_DOCSCAN_CROP;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_DOCSCAN_DETECT;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_DOCSCAN_ENHANCE;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_DOCSCAN_SHADOW_REMOVAL;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_DOCSCAN_STAIN_REMOVAL;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_DOCSCAN_UI;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_FACE;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_ICA;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_IMAGE_CAPTION;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_IMAGE_QUALITY_AESTHETIC;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_IMAGE_QUALITY_TECHNICAL;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_LANGID;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_MLKIT_BARCODE_UI;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_NLCLASSIFIER;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_OCR;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_OCR_CHINESE;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_OCR_COMMON;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_OCR_DEVANAGARI;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_OCR_JAPANESE;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_OCR_KOREAN;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_SMART_REPLY;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_SUBJECT_SEGMENTATION;

    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_TFLITE_DYNAMITE;

    @NonNull
    @KeepForSdk
    public static final String ICA = "ica";

    @NonNull
    @KeepForSdk
    public static final String ICA_MODULE_ID = "com.google.android.gms.vision.ica";

    @NonNull
    @KeepForSdk
    public static final String IMAGE_CAPTION_MODULE_ID = "com.google.android.gms.mlkit_image_caption";

    @NonNull
    @KeepForSdk
    public static final String IMAGE_QUALITY_AESTHETIC_MODULE_ID = "com.google.android.gms.mlkit_quality_aesthetic";

    @NonNull
    @KeepForSdk
    public static final String IMAGE_QUALITY_TECHNICAL_MODULE_ID = "com.google.android.gms.mlkit_quality_technical";

    @NonNull
    @KeepForSdk
    public static final String LANGID = "langid";

    @NonNull
    @KeepForSdk
    public static final String LANGID_MODULE_ID = "com.google.android.gms.mlkit.langid";

    @NonNull
    @KeepForSdk
    public static final String MLKIT_BARCODE_UI = "barcode_ui";

    @NonNull
    @KeepForSdk
    public static final String NLCLASSIFIER = "nlclassifier";

    @NonNull
    @KeepForSdk
    public static final String NLCLASSIFIER_MODULE_ID = "com.google.android.gms.mlkit.nlclassifier";

    @NonNull
    @KeepForSdk
    public static final String OCR = "ocr";

    @NonNull
    @KeepForSdk
    public static final String OCR_CHINESE_MODULE_ID = "com.google.android.gms.mlkit_ocr_chinese";

    @NonNull
    @KeepForSdk
    public static final String OCR_COMMON_MODULE_ID = "com.google.android.gms.mlkit_ocr_common";

    @NonNull
    @KeepForSdk
    public static final String OCR_DEVANAGARI_MODULE_ID = "com.google.android.gms.mlkit_ocr_devanagari";

    @NonNull
    @KeepForSdk
    public static final String OCR_JAPANESE_MODULE_ID = "com.google.android.gms.mlkit_ocr_japanese";

    @NonNull
    @KeepForSdk
    public static final String OCR_KOREAN_MODULE_ID = "com.google.android.gms.mlkit_ocr_korean";

    @NonNull
    @KeepForSdk
    public static final String OCR_MODULE_ID = "com.google.android.gms.vision.ocr";

    @NonNull
    @KeepForSdk
    public static final String SMART_REPLY = "smart_reply";

    @NonNull
    @KeepForSdk
    public static final String SMART_REPLY_MODULE_ID = "com.google.android.gms.mlkit_smartreply";

    @NonNull
    @KeepForSdk
    public static final String SUBJECT_SEGMENTATION_MODULE_ID = "com.google.android.gms.mlkit_subject_segmentation";

    @NonNull
    @KeepForSdk
    public static final String TFLITE_DYNAMITE = "tflite_dynamite";

    @NonNull
    @KeepForSdk
    public static final String TFLITE_DYNAMITE_MODULE_ID = "com.google.android.gms.tflite_dynamite";
    private static final zzai zza;
    private static final zzai zzb;

    static {
        Feature feature = new Feature("vision.barcode", 1L);
        FEATURE_BARCODE = feature;
        Feature feature2 = new Feature("vision.custom.ica", 1L);
        FEATURE_CUSTOM_ICA = feature2;
        Feature feature3 = new Feature("vision.face", 1L);
        FEATURE_FACE = feature3;
        Feature feature4 = new Feature("vision.ica", 1L);
        FEATURE_ICA = feature4;
        Feature feature5 = new Feature("vision.ocr", 1L);
        FEATURE_OCR = feature5;
        FEATURE_OCR_CHINESE = new Feature("mlkit.ocr.chinese", 1L);
        FEATURE_OCR_COMMON = new Feature("mlkit.ocr.common", 1L);
        FEATURE_OCR_DEVANAGARI = new Feature("mlkit.ocr.devanagari", 1L);
        FEATURE_OCR_JAPANESE = new Feature("mlkit.ocr.japanese", 1L);
        FEATURE_OCR_KOREAN = new Feature("mlkit.ocr.korean", 1L);
        Feature feature6 = new Feature("mlkit.langid", 1L);
        FEATURE_LANGID = feature6;
        Feature feature7 = new Feature("mlkit.nlclassifier", 1L);
        FEATURE_NLCLASSIFIER = feature7;
        Feature feature8 = new Feature(TFLITE_DYNAMITE, 1L);
        FEATURE_TFLITE_DYNAMITE = feature8;
        Feature feature9 = new Feature("mlkit.barcode.ui", 1L);
        FEATURE_MLKIT_BARCODE_UI = feature9;
        Feature feature10 = new Feature("mlkit.smartreply", 1L);
        FEATURE_SMART_REPLY = feature10;
        FEATURE_IMAGE_CAPTION = new Feature("mlkit.image.caption", 1L);
        FEATURE_DOCSCAN_DETECT = new Feature("mlkit.docscan.detect", 1L);
        FEATURE_DOCSCAN_CROP = new Feature("mlkit.docscan.crop", 1L);
        FEATURE_DOCSCAN_ENHANCE = new Feature("mlkit.docscan.enhance", 1L);
        FEATURE_DOCSCAN_UI = new Feature("mlkit.docscan.ui", 1L);
        FEATURE_DOCSCAN_STAIN_REMOVAL = new Feature("mlkit.docscan.stain", 1L);
        FEATURE_DOCSCAN_SHADOW_REMOVAL = new Feature("mlkit.docscan.shadow", 1L);
        FEATURE_IMAGE_QUALITY_AESTHETIC = new Feature("mlkit.quality.aesthetic", 1L);
        FEATURE_IMAGE_QUALITY_TECHNICAL = new Feature("mlkit.quality.technical", 1L);
        FEATURE_SUBJECT_SEGMENTATION = new Feature("mlkit.segmentation.subject", 1L);
        zzah zzahVar = new zzah();
        zzahVar.zza(BARCODE, feature);
        zzahVar.zza(CUSTOM_ICA, feature2);
        zzahVar.zza(FACE, feature3);
        zzahVar.zza(ICA, feature4);
        zzahVar.zza(OCR, feature5);
        zzahVar.zza(LANGID, feature6);
        zzahVar.zza(NLCLASSIFIER, feature7);
        zzahVar.zza(TFLITE_DYNAMITE, feature8);
        zzahVar.zza(MLKIT_BARCODE_UI, feature9);
        zzahVar.zza(SMART_REPLY, feature10);
        zza = zzahVar.zzb();
        zzah zzahVar2 = new zzah();
        zzahVar2.zza(BARCODE_MODULE_ID, feature);
        zzahVar2.zza(CUSTOM_ICA_MODULE_ID, feature2);
        zzahVar2.zza(FACE_MODULE_ID, feature3);
        zzahVar2.zza(ICA_MODULE_ID, feature4);
        zzahVar2.zza(OCR_MODULE_ID, feature5);
        zzahVar2.zza(LANGID_MODULE_ID, feature6);
        zzahVar2.zza(NLCLASSIFIER_MODULE_ID, feature7);
        zzahVar2.zza(TFLITE_DYNAMITE_MODULE_ID, feature8);
        zzahVar2.zza(SMART_REPLY_MODULE_ID, feature10);
        zzb = zzahVar2.zzb();
    }

    @KeepForSdk
    @WorkerThread
    @Deprecated
    public static boolean areAllRequiredModulesAvailable(@NonNull Context context, @NonNull List<String> list) throws Throwable {
        if (GoogleApiAvailabilityLight.getInstance().getApkVersion(context) >= 221500000) {
            return areAllRequiredModulesAvailable(context, zza(zzb, list));
        }
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, it.next());
            }
            return true;
        } catch (DynamiteModule.LoadingException unused) {
            return false;
        }
    }

    @KeepForSdk
    @Deprecated
    public static void requestDownload(@NonNull Context context, @NonNull String str) {
        requestDownload(context, zzaf.zzh(str));
    }

    private static Feature[] zza(Map map, List list) {
        Feature[] featureArr = new Feature[list.size()];
        for (int i = 0; i < list.size(); i++) {
            featureArr[i] = (Feature) Preconditions.checkNotNull((Feature) map.get(list.get(i)));
        }
        return featureArr;
    }

    @KeepForSdk
    @Deprecated
    public static void requestDownload(@NonNull Context context, @NonNull List<String> list) {
        if (GoogleApiAvailabilityLight.getInstance().getApkVersion(context) >= 221500000) {
            requestDownload(context, zza(zza, list));
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
        intent.setAction("com.google.android.gms.vision.DEPENDENCY");
        intent.putExtra("com.google.android.gms.vision.DEPENDENCIES", TextUtils.join(",", list));
        intent.putExtra("requester_app_package", context.getApplicationInfo().packageName);
        context.sendBroadcast(intent);
    }

    @KeepForSdk
    @WorkerThread
    public static boolean areAllRequiredModulesAvailable(@NonNull Context context, @NonNull final Feature[] featureArr) {
        try {
            return ((ModuleAvailabilityResponse) Tasks.await(ModuleInstall.getClient(context).areModulesAvailable(new OptionalModuleApi() { // from class: com.google.mlkit.common.sdkinternal.zzq
                @Override // com.google.android.gms.common.api.OptionalModuleApi
                public final Feature[] getOptionalFeatures() {
                    Feature[] featureArr2 = OptionalModuleUtils.EMPTY_FEATURES;
                    return featureArr;
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.google.mlkit.common.sdkinternal.zzr
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    Log.e("OptionalModuleUtils", "Failed to check feature availability", exc);
                }
            }))).areModulesAvailable();
        } catch (InterruptedException | ExecutionException e) {
            Log.e("OptionalModuleUtils", "Failed to complete the task of features availability check", e);
            return false;
        }
    }

    @KeepForSdk
    public static void requestDownload(@NonNull Context context, @NonNull final Feature[] featureArr) {
        ModuleInstall.getClient(context).installModules(ModuleInstallRequest.newBuilder().addApi(new OptionalModuleApi() { // from class: com.google.mlkit.common.sdkinternal.zzo
            @Override // com.google.android.gms.common.api.OptionalModuleApi
            public final Feature[] getOptionalFeatures() {
                Feature[] featureArr2 = OptionalModuleUtils.EMPTY_FEATURES;
                return featureArr;
            }
        }).build()).addOnFailureListener(new OnFailureListener() { // from class: com.google.mlkit.common.sdkinternal.zzp
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                Log.e("OptionalModuleUtils", "Failed to request modules install request", exc);
            }
        });
    }
}
