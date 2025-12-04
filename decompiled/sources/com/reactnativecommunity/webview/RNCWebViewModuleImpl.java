package com.reactnativecommunity.webview;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.util.Pair;
import androidx.media3.common.MimeTypes;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public class RNCWebViewModuleImpl implements ActivityEventListener {
    public static final int FILE_DOWNLOAD_PERMISSION_REQUEST = 1;
    public static final String NAME = "RNCWebViewModule";
    public static final int PICKER = 1;
    public static final int PICKER_LEGACY = 3;
    protected static final ShouldOverrideUrlLoadingLock shouldOverrideUrlLoadingLock = new ShouldOverrideUrlLoadingLock();
    private final ReactApplicationContext mContext;
    private DownloadManager.Request mDownloadRequest;
    private ValueCallback<Uri[]> mFilePathCallback;
    private ValueCallback<Uri> mFilePathCallbackLegacy;
    private File mOutputImage;
    private File mOutputVideo;

    public boolean isFileUploadSupported() {
        return true;
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    public RNCWebViewModuleImpl(ReactApplicationContext reactApplicationContext) {
        this.mContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(this);
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (this.mFilePathCallback == null && this.mFilePathCallbackLegacy == null) {
            return;
        }
        File file = this.mOutputImage;
        boolean z = false;
        boolean z2 = file != null && file.length() > 0;
        File file2 = this.mOutputVideo;
        if (file2 != null && file2.length() > 0) {
            z = true;
        }
        if (i != 1) {
            if (i == 3) {
                if (i2 != -1) {
                    this.mFilePathCallbackLegacy.onReceiveValue(null);
                } else if (z2) {
                    this.mFilePathCallbackLegacy.onReceiveValue(getOutputUri(this.mOutputImage));
                } else if (z) {
                    this.mFilePathCallbackLegacy.onReceiveValue(getOutputUri(this.mOutputVideo));
                } else {
                    this.mFilePathCallbackLegacy.onReceiveValue(intent.getData());
                }
            }
        } else if (i2 != -1) {
            ValueCallback<Uri[]> valueCallback = this.mFilePathCallback;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
        } else if (z2) {
            this.mFilePathCallback.onReceiveValue(new Uri[]{getOutputUri(this.mOutputImage)});
        } else if (z) {
            this.mFilePathCallback.onReceiveValue(new Uri[]{getOutputUri(this.mOutputVideo)});
        } else {
            this.mFilePathCallback.onReceiveValue(getSelectedFiles(intent, i2));
        }
        File file3 = this.mOutputImage;
        if (file3 != null && !z2) {
            file3.delete();
        }
        File file4 = this.mOutputVideo;
        if (file4 != null && !z) {
            file4.delete();
        }
        this.mFilePathCallback = null;
        this.mFilePathCallbackLegacy = null;
        this.mOutputImage = null;
        this.mOutputVideo = null;
    }

    protected static class ShouldOverrideUrlLoadingLock {
        private double nextLockIdentifier = 1.0d;
        private final HashMap<Double, AtomicReference<ShouldOverrideCallbackState>> shouldOverrideLocks = new HashMap<>();

        protected enum ShouldOverrideCallbackState {
            UNDECIDED,
            SHOULD_OVERRIDE,
            DO_NOT_OVERRIDE
        }

        protected ShouldOverrideUrlLoadingLock() {
        }

        public synchronized Pair<Double, AtomicReference<ShouldOverrideCallbackState>> getNewLock() {
            double d;
            AtomicReference<ShouldOverrideCallbackState> atomicReference;
            d = this.nextLockIdentifier;
            this.nextLockIdentifier = 1.0d + d;
            atomicReference = new AtomicReference<>(ShouldOverrideCallbackState.UNDECIDED);
            this.shouldOverrideLocks.put(Double.valueOf(d), atomicReference);
            return new Pair<>(Double.valueOf(d), atomicReference);
        }

        @Nullable
        public synchronized AtomicReference<ShouldOverrideCallbackState> getLock(Double d) {
            return this.shouldOverrideLocks.get(d);
        }

        public synchronized void removeLock(Double d) {
            this.shouldOverrideLocks.remove(d);
        }
    }

    private enum MimeType {
        DEFAULT("*/*"),
        IMAGE(MimeTypes.BASE_TYPE_IMAGE),
        VIDEO(MimeTypes.BASE_TYPE_VIDEO);

        private final String value;

        MimeType(String str) {
            this.value = str;
        }
    }

    private PermissionListener getWebviewFileDownloaderPermissionListener(final String str, final String str2) {
        return new PermissionListener() { // from class: com.reactnativecommunity.webview.RNCWebViewModuleImpl.1
            @Override // com.facebook.react.modules.core.PermissionListener
            public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                if (i != 1) {
                    return false;
                }
                if (iArr.length > 0 && iArr[0] == 0) {
                    if (RNCWebViewModuleImpl.this.mDownloadRequest != null) {
                        RNCWebViewModuleImpl.this.downloadFile(str);
                    }
                } else {
                    Toast.makeText(RNCWebViewModuleImpl.this.mContext, str2, 1).show();
                }
                return true;
            }
        };
    }

    public void shouldStartLoadWithLockIdentifier(boolean z, double d) {
        AtomicReference<ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState> lock = shouldOverrideUrlLoadingLock.getLock(Double.valueOf(d));
        if (lock != null) {
            synchronized (lock) {
                try {
                    lock.set(z ? ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.DO_NOT_OVERRIDE : ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.SHOULD_OVERRIDE);
                    lock.notify();
                } finally {
                }
            }
        }
    }

    public Uri[] getSelectedFiles(Intent intent, int i) {
        if (intent == null) {
            return null;
        }
        if (intent.getClipData() != null) {
            int itemCount = intent.getClipData().getItemCount();
            Uri[] uriArr = new Uri[itemCount];
            for (int i2 = 0; i2 < itemCount; i2++) {
                uriArr[i2] = intent.getClipData().getItemAt(i2).getUri();
            }
            return uriArr;
        }
        if (intent.getData() == null || i != -1) {
            return null;
        }
        return WebChromeClient.FileChooserParams.parseResult(i, intent);
    }

    public void startPhotoPickerIntent(String str, ValueCallback<Uri> valueCallback) {
        Intent videoIntent;
        Intent photoIntent;
        this.mFilePathCallbackLegacy = valueCallback;
        Activity currentActivity = this.mContext.getCurrentActivity();
        Intent intentCreateChooser = Intent.createChooser(getFileChooserIntent(str), "");
        ArrayList arrayList = new ArrayList();
        if (acceptsImages(str).booleanValue() && (photoIntent = getPhotoIntent()) != null) {
            arrayList.add(photoIntent);
        }
        if (acceptsVideo(str).booleanValue() && (videoIntent = getVideoIntent()) != null) {
            arrayList.add(videoIntent);
        }
        intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        if (intentCreateChooser.resolveActivity(currentActivity.getPackageManager()) != null) {
            currentActivity.startActivityForResult(intentCreateChooser, 3);
        } else {
            Log.w("RNCWebViewModule", "there is no Activity to handle this Intent");
        }
    }

    public boolean startPhotoPickerIntent(String[] strArr, boolean z, ValueCallback<Uri[]> valueCallback, boolean z2) {
        Intent videoIntent;
        this.mFilePathCallback = valueCallback;
        Activity currentActivity = this.mContext.getCurrentActivity();
        ArrayList arrayList = new ArrayList();
        Intent photoIntent = null;
        if (!needsCameraPermission()) {
            if (acceptsImages(strArr).booleanValue() && (photoIntent = getPhotoIntent()) != null) {
                arrayList.add(photoIntent);
            }
            if (acceptsVideo(strArr).booleanValue() && (videoIntent = getVideoIntent()) != null) {
                arrayList.add(videoIntent);
            }
        }
        Intent intent = new Intent("android.intent.action.CHOOSER");
        if (!z2) {
            intent.putExtra("android.intent.extra.INTENT", getFileChooserIntent(strArr, z));
            intent.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
            photoIntent = intent;
        }
        if (photoIntent == null) {
            Log.w("RNCWebViewModule", "there is no Camera permission");
        } else if (photoIntent.resolveActivity(currentActivity.getPackageManager()) == null) {
            Log.w("RNCWebViewModule", "there is no Activity to handle this Intent");
        } else {
            currentActivity.startActivityForResult(photoIntent, 1);
        }
        return true;
    }

    public void setDownloadRequest(DownloadManager.Request request) {
        this.mDownloadRequest = request;
    }

    public void downloadFile(String str) {
        try {
            ((DownloadManager) this.mContext.getSystemService("download")).enqueue(this.mDownloadRequest);
            Toast.makeText(this.mContext, str, 1).show();
        } catch (IllegalArgumentException | SecurityException e) {
            Log.w("RNCWebViewModule", "Unsupported URI, aborting download", e);
        }
    }

    public boolean grantFileDownloaderPermissions(String str, String str2) {
        this.mContext.getCurrentActivity();
        return true;
    }

    protected boolean needsCameraPermission() {
        Activity currentActivity = this.mContext.getCurrentActivity();
        try {
            if (Arrays.asList(currentActivity.getPackageManager().getPackageInfo(currentActivity.getApplicationContext().getPackageName(), 4096).requestedPermissions).contains("android.permission.CAMERA")) {
                if (ContextCompat.checkSelfPermission(currentActivity, "android.permission.CAMERA") != 0) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public Intent getPhotoIntent() {
        Intent intent = null;
        try {
            File capturedFile = getCapturedFile(MimeType.IMAGE);
            this.mOutputImage = capturedFile;
            Uri outputUri = getOutputUri(capturedFile);
            Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
            try {
                intent2.putExtra("output", outputUri);
                return intent2;
            } catch (IOException | IllegalArgumentException e) {
                e = e;
                intent = intent2;
                Log.e("CREATE FILE", "Error occurred while creating the File", e);
                e.printStackTrace();
                return intent;
            }
        } catch (IOException | IllegalArgumentException e2) {
            e = e2;
        }
    }

    public Intent getVideoIntent() {
        Intent intent = null;
        try {
            File capturedFile = getCapturedFile(MimeType.VIDEO);
            this.mOutputVideo = capturedFile;
            Uri outputUri = getOutputUri(capturedFile);
            Intent intent2 = new Intent("android.media.action.VIDEO_CAPTURE");
            try {
                intent2.putExtra("output", outputUri);
                return intent2;
            } catch (IOException | IllegalArgumentException e) {
                e = e;
                intent = intent2;
                Log.e("CREATE FILE", "Error occurred while creating the File", e);
                e.printStackTrace();
                return intent;
            }
        } catch (IOException | IllegalArgumentException e2) {
            e = e2;
        }
    }

    private Intent getFileChooserIntent(String str) {
        String mimeTypeFromExtension = str.isEmpty() ? MimeType.DEFAULT.value : str;
        if (str.matches("\\.\\w+")) {
            mimeTypeFromExtension = getMimeTypeFromExtension(str.replace(InstructionFileId.DOT, ""));
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(mimeTypeFromExtension);
        return intent;
    }

    private Intent getFileChooserIntent(String[] strArr, boolean z) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(MimeType.DEFAULT.value);
        intent.putExtra("android.intent.extra.MIME_TYPES", getAcceptedMimeType(strArr));
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", z);
        return intent;
    }

    private Boolean acceptsImages(String str) {
        if (str.matches("\\.\\w+")) {
            str = getMimeTypeFromExtension(str.replace(InstructionFileId.DOT, ""));
        }
        return Boolean.valueOf(str.isEmpty() || str.toLowerCase().contains(MimeType.IMAGE.value));
    }

    private Boolean acceptsImages(String[] strArr) {
        String[] acceptedMimeType = getAcceptedMimeType(strArr);
        return Boolean.valueOf(arrayContainsString(acceptedMimeType, MimeType.DEFAULT.value).booleanValue() || arrayContainsString(acceptedMimeType, MimeType.IMAGE.value).booleanValue());
    }

    private Boolean acceptsVideo(String str) {
        if (str.matches("\\.\\w+")) {
            str = getMimeTypeFromExtension(str.replace(InstructionFileId.DOT, ""));
        }
        return Boolean.valueOf(str.isEmpty() || str.toLowerCase().contains(MimeType.VIDEO.value));
    }

    private Boolean acceptsVideo(String[] strArr) {
        String[] acceptedMimeType = getAcceptedMimeType(strArr);
        return Boolean.valueOf(arrayContainsString(acceptedMimeType, MimeType.DEFAULT.value).booleanValue() || arrayContainsString(acceptedMimeType, MimeType.VIDEO.value).booleanValue());
    }

    private Boolean arrayContainsString(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.contains(str)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private String[] getAcceptedMimeType(String[] strArr) {
        if (noAcceptTypesSet(strArr).booleanValue()) {
            return new String[]{MimeType.DEFAULT.value};
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (str.matches("\\.\\w+")) {
                String mimeTypeFromExtension = getMimeTypeFromExtension(str.replace(InstructionFileId.DOT, ""));
                if (mimeTypeFromExtension != null) {
                    strArr2[i] = mimeTypeFromExtension;
                } else {
                    strArr2[i] = str;
                }
            } else {
                strArr2[i] = str;
            }
        }
        return strArr2;
    }

    private String getMimeTypeFromExtension(String str) {
        if (str != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        return null;
    }

    public Uri getOutputUri(File file) {
        String packageName = this.mContext.getPackageName();
        return FileProvider.getUriForFile(this.mContext, packageName + ".fileprovider", file);
    }

    /* renamed from: com.reactnativecommunity.webview.RNCWebViewModuleImpl$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$reactnativecommunity$webview$RNCWebViewModuleImpl$MimeType;

        static {
            int[] iArr = new int[MimeType.values().length];
            $SwitchMap$com$reactnativecommunity$webview$RNCWebViewModuleImpl$MimeType = iArr;
            try {
                iArr[MimeType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$reactnativecommunity$webview$RNCWebViewModuleImpl$MimeType[MimeType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public File getCapturedFile(MimeType mimeType) throws IOException {
        String str;
        String str2;
        int i = AnonymousClass2.$SwitchMap$com$reactnativecommunity$webview$RNCWebViewModuleImpl$MimeType[mimeType.ordinal()];
        if (i == 1) {
            String str3 = Environment.DIRECTORY_PICTURES;
            str = "image-";
            str2 = ".jpg";
        } else if (i != 2) {
            str = "";
            str2 = "";
        } else {
            String str4 = Environment.DIRECTORY_MOVIES;
            str = "video-";
            str2 = ".mp4";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(String.valueOf(System.currentTimeMillis()));
        sb.append(str2);
        return File.createTempFile(str, str2, this.mContext.getExternalFilesDir(null));
    }

    private Boolean noAcceptTypesSet(String[] strArr) {
        String str;
        boolean z = true;
        if (strArr.length != 0 && (strArr.length != 1 || (str = strArr[0]) == null || str.length() != 0)) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    private PermissionAwareActivity getPermissionAwareActivity() {
        ComponentCallbacks2 currentActivity = this.mContext.getCurrentActivity();
        if (currentActivity == null) {
            throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.");
        }
        if (!(currentActivity instanceof PermissionAwareActivity)) {
            throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.");
        }
        return (PermissionAwareActivity) currentActivity;
    }
}
