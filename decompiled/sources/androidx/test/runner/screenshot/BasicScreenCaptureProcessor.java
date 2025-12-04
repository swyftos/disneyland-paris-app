package androidx.test.runner.screenshot;

import android.os.Build;
import android.os.Environment;
import android.util.Log;
import androidx.test.annotation.Beta;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Beta
/* loaded from: classes2.dex */
public class BasicScreenCaptureProcessor implements ScreenCaptureProcessor {
    protected String mDefaultFilenamePrefix;
    protected File mDefaultScreenshotPath;
    protected String mFileNameDelimiter;
    protected String mTag;
    private static int sAndroidRuntimeVersion = Build.VERSION.SDK_INT;
    private static String sAndroidDeviceName = Build.DEVICE;

    public BasicScreenCaptureProcessor() {
        this(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "screenshots"));
    }

    BasicScreenCaptureProcessor(File file) {
        this.mTag = "BasicScreenCaptureProcessor";
        this.mFileNameDelimiter = "-";
        this.mDefaultFilenamePrefix = "screenshot";
        this.mDefaultScreenshotPath = file;
    }

    @Override // androidx.test.runner.screenshot.ScreenCaptureProcessor
    public String process(ScreenCapture screenCapture) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        String strValueOf = String.valueOf(screenCapture.getName() == null ? getDefaultFilename() : getFilename(screenCapture.getName()));
        String lowerCase = screenCapture.getFormat().toString().toLowerCase();
        StringBuilder sb = new StringBuilder(strValueOf.length() + 1 + String.valueOf(lowerCase).length());
        sb.append(strValueOf);
        sb.append(InstructionFileId.DOT);
        sb.append(lowerCase);
        String string = sb.toString();
        File file = this.mDefaultScreenshotPath;
        file.mkdirs();
        if (!file.isDirectory() && !file.canWrite()) {
            throw new IOException(String.format("The directory %s does not exist and could not be created or is not writable.", file));
        }
        File file2 = new File(file, string);
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
        } catch (Throwable th) {
            th = th;
        }
        try {
            screenCapture.getBitmap().compress(screenCapture.getFormat(), 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                Log.e(this.mTag, "Could not close output steam.", e);
            }
            return string;
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e2) {
                    Log.e(this.mTag, "Could not close output steam.", e2);
                }
            }
            throw th;
        }
    }

    protected String getDefaultFilename() {
        String str = this.mDefaultFilenamePrefix;
        String str2 = this.mFileNameDelimiter;
        String str3 = sAndroidDeviceName;
        int i = sAndroidRuntimeVersion;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str2).length());
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str2);
        sb.append(i);
        return getFilename(sb.toString());
    }

    protected String getFilename(String str) {
        String str2 = this.mFileNameDelimiter;
        String strValueOf = String.valueOf(UUID.randomUUID());
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + String.valueOf(str2).length() + strValueOf.length());
        sb.append(str);
        sb.append(str2);
        sb.append(strValueOf);
        return sb.toString();
    }
}
