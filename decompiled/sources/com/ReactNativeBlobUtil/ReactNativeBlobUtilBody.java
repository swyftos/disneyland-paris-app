package com.ReactNativeBlobUtil;

import android.net.Uri;
import android.util.Base64;
import androidx.work.Data;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilReq;
import com.amazonaws.services.s3.util.Mimetypes;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* loaded from: classes2.dex */
class ReactNativeBlobUtilBody extends RequestBody {
    private File bodyCache;
    private ReadableArray form;
    private String mTaskId;
    private MediaType mime;
    private String rawBody;
    private InputStream requestStream;
    private ReactNativeBlobUtilReq.RequestType requestType;
    private long contentLength = 0;
    int reported = 0;
    private Boolean chunkedEncoding = Boolean.FALSE;

    ReactNativeBlobUtilBody(String str) {
        this.mTaskId = str;
    }

    ReactNativeBlobUtilBody chunkedEncoding(boolean z) {
        this.chunkedEncoding = Boolean.valueOf(z);
        return this;
    }

    ReactNativeBlobUtilBody setMIME(MediaType mediaType) {
        this.mime = mediaType;
        return this;
    }

    ReactNativeBlobUtilBody setRequestType(ReactNativeBlobUtilReq.RequestType requestType) {
        this.requestType = requestType;
        return this;
    }

    ReactNativeBlobUtilBody setBody(String str) {
        this.rawBody = str;
        if (str == null) {
            this.rawBody = "";
            this.requestType = ReactNativeBlobUtilReq.RequestType.AsIs;
        }
        try {
            int i = AnonymousClass1.$SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[this.requestType.ordinal()];
            if (i == 1) {
                this.requestStream = getRequestStream();
                this.contentLength = r3.available();
            } else if (i == 2) {
                this.contentLength = this.rawBody.getBytes().length;
                this.requestStream = new ByteArrayInputStream(this.rawBody.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
            ReactNativeBlobUtilUtils.emitWarningEvent("ReactNativeBlobUtil failed to create single content request body :" + e.getLocalizedMessage() + "\r\n");
        }
        return this;
    }

    /* renamed from: com.ReactNativeBlobUtil.ReactNativeBlobUtilBody$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType;

        static {
            int[] iArr = new int[ReactNativeBlobUtilReq.RequestType.values().length];
            $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType = iArr;
            try {
                iArr[ReactNativeBlobUtilReq.RequestType.SingleFile.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[ReactNativeBlobUtilReq.RequestType.AsIs.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[ReactNativeBlobUtilReq.RequestType.Others.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    ReactNativeBlobUtilBody setBody(ReadableArray readableArray) {
        this.form = readableArray;
        try {
            this.bodyCache = createMultipartBodyCache();
            this.requestStream = new FileInputStream(this.bodyCache);
            this.contentLength = this.bodyCache.length();
        } catch (Exception e) {
            e.printStackTrace();
            ReactNativeBlobUtilUtils.emitWarningEvent("ReactNativeBlobUtil failed to create request multipart body :" + e.getLocalizedMessage());
        }
        return this;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        if (this.chunkedEncoding.booleanValue()) {
            return -1L;
        }
        return this.contentLength;
    }

    @Override // okhttp3.RequestBody
    /* renamed from: contentType */
    public MediaType getContentType() {
        return this.mime;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) {
        try {
            pipeStreamToSink(this.requestStream, bufferedSink);
        } catch (Exception e) {
            ReactNativeBlobUtilUtils.emitWarningEvent(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    boolean clearRequestBody() {
        try {
            File file = this.bodyCache;
            if (file == null || !file.exists()) {
                return true;
            }
            this.bodyCache.delete();
            return true;
        } catch (Exception e) {
            ReactNativeBlobUtilUtils.emitWarningEvent(e.getLocalizedMessage());
            return false;
        }
    }

    private InputStream getRequestStream() throws Exception {
        if (this.rawBody.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX)) {
            String strNormalizePath = ReactNativeBlobUtilFS.normalizePath(this.rawBody.substring(27));
            if (ReactNativeBlobUtilFS.isAsset(strNormalizePath)) {
                try {
                    return ReactNativeBlobUtil.RCTContext.getAssets().open(strNormalizePath.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
                } catch (Exception e) {
                    throw new Exception("error when getting request stream from asset : " + e.getLocalizedMessage());
                }
            }
            File file = new File(ReactNativeBlobUtilFS.normalizePath(strNormalizePath));
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                return new FileInputStream(file);
            } catch (Exception e2) {
                throw new Exception("error when getting request stream: " + e2.getLocalizedMessage());
            }
        }
        if (this.rawBody.startsWith(ReactNativeBlobUtilConst.CONTENT_PREFIX)) {
            String strSubstring = this.rawBody.substring(30);
            try {
                return ReactNativeBlobUtil.RCTContext.getContentResolver().openInputStream(Uri.parse(strSubstring));
            } catch (Exception e3) {
                throw new Exception("error when getting request stream for content URI: " + strSubstring, e3);
            }
        }
        try {
            return new ByteArrayInputStream(Base64.decode(this.rawBody, 0));
        } catch (Exception e4) {
            throw new Exception("error when getting request stream: " + e4.getLocalizedMessage());
        }
    }

    private File createMultipartBodyCache() throws IOException {
        String str = "ReactNativeBlobUtil-" + this.mTaskId;
        File fileCreateTempFile = File.createTempFile("rnfb-form-tmp", "", ReactNativeBlobUtil.RCTContext.getCacheDir());
        FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
        ArrayList arrayListCountFormDataLength = countFormDataLength();
        ReactApplicationContext reactApplicationContext = ReactNativeBlobUtil.RCTContext;
        Iterator it = arrayListCountFormDataLength.iterator();
        while (it.hasNext()) {
            FormField formField = (FormField) it.next();
            String str2 = formField.data;
            String str3 = formField.name;
            if (str3 != null && str2 != null) {
                String str4 = "--" + str + "\r\n";
                Iterator it2 = it;
                if (formField.filename != null) {
                    fileOutputStream.write(((str4 + "Content-Disposition: form-data; name=\"" + str3 + "\"; filename=\"" + formField.filename + "\"\r\n") + "Content-Type: " + formField.mime + "\r\n\r\n").getBytes());
                    if (str2.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX)) {
                        String strNormalizePath = ReactNativeBlobUtilFS.normalizePath(str2.substring(27));
                        if (ReactNativeBlobUtilFS.isAsset(strNormalizePath)) {
                            try {
                                pipeStreamToFileStream(reactApplicationContext.getAssets().open(strNormalizePath.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "")), fileOutputStream);
                            } catch (IOException e) {
                                ReactNativeBlobUtilUtils.emitWarningEvent("Failed to create form data asset :" + strNormalizePath + ", " + e.getLocalizedMessage());
                            }
                        } else {
                            File file = new File(ReactNativeBlobUtilFS.normalizePath(strNormalizePath));
                            if (file.exists()) {
                                pipeStreamToFileStream(new FileInputStream(file), fileOutputStream);
                            } else {
                                ReactNativeBlobUtilUtils.emitWarningEvent("Failed to create form data from path :" + strNormalizePath + ", file not exists.");
                            }
                        }
                    } else if (str2.startsWith(ReactNativeBlobUtilConst.CONTENT_PREFIX)) {
                        String strSubstring = str2.substring(30);
                        InputStream inputStreamOpenInputStream = null;
                        try {
                            try {
                                inputStreamOpenInputStream = reactApplicationContext.getContentResolver().openInputStream(Uri.parse(strSubstring));
                                pipeStreamToFileStream(inputStreamOpenInputStream, fileOutputStream);
                            } finally {
                                if (inputStreamOpenInputStream != null) {
                                    inputStreamOpenInputStream.close();
                                }
                            }
                        } catch (Exception e2) {
                            ReactNativeBlobUtilUtils.emitWarningEvent("Failed to create form data from content URI:" + strSubstring + ", " + e2.getLocalizedMessage());
                            if (inputStreamOpenInputStream != null) {
                            }
                        }
                    } else {
                        fileOutputStream.write(Base64.decode(str2, 0));
                    }
                } else {
                    fileOutputStream.write(((str4 + "Content-Disposition: form-data; name=\"" + str3 + "\"\r\n") + "Content-Type: " + formField.mime + "\r\n\r\n").getBytes());
                    fileOutputStream.write(formField.data.getBytes());
                }
                fileOutputStream.write("\r\n".getBytes());
                it = it2;
            }
        }
        fileOutputStream.write(("--" + str + "--\r\n").getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
        return fileCreateTempFile;
    }

    private void pipeStreamToSink(InputStream inputStream, BufferedSink bufferedSink) throws IOException {
        byte[] bArr = new byte[Data.MAX_DATA_BYTES];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr, 0, Data.MAX_DATA_BYTES);
            if (i > 0) {
                bufferedSink.write(bArr, 0, i);
                j += i;
                emitUploadProgress(j);
            } else {
                inputStream.close();
                return;
            }
        }
    }

    private void pipeStreamToFileStream(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[Data.MAX_DATA_BYTES];
        while (true) {
            int i = inputStream.read(bArr);
            if (i > 0) {
                fileOutputStream.write(bArr, 0, i);
            } else {
                inputStream.close();
                return;
            }
        }
    }

    private ArrayList countFormDataLength() throws IOException {
        int length;
        long length2;
        ArrayList arrayList = new ArrayList();
        ReactApplicationContext reactApplicationContext = ReactNativeBlobUtil.RCTContext;
        long jAvailable = 0;
        for (int i = 0; i < this.form.size(); i++) {
            FormField formField = new FormField(this.form.getMap(i));
            arrayList.add(formField);
            String str = formField.data;
            if (str == null) {
                ReactNativeBlobUtilUtils.emitWarningEvent("ReactNativeBlobUtil multipart request builder has found a field without `data` property, the field `" + formField.name + "` will be removed implicitly.");
            } else {
                if (formField.filename != null) {
                    if (str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX)) {
                        String strNormalizePath = ReactNativeBlobUtilFS.normalizePath(str.substring(27));
                        if (ReactNativeBlobUtilFS.isAsset(strNormalizePath)) {
                            try {
                                length = reactApplicationContext.getAssets().open(strNormalizePath.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "")).available();
                            } catch (IOException e) {
                                ReactNativeBlobUtilUtils.emitWarningEvent(e.getLocalizedMessage());
                            }
                        } else {
                            length2 = new File(ReactNativeBlobUtilFS.normalizePath(strNormalizePath)).length();
                        }
                    } else if (str.startsWith(ReactNativeBlobUtilConst.CONTENT_PREFIX)) {
                        String strSubstring = str.substring(30);
                        InputStream inputStreamOpenInputStream = null;
                        try {
                            try {
                                inputStreamOpenInputStream = reactApplicationContext.getContentResolver().openInputStream(Uri.parse(strSubstring));
                                jAvailable += inputStreamOpenInputStream.available();
                            } catch (Exception e2) {
                                ReactNativeBlobUtilUtils.emitWarningEvent("Failed to estimate form data length from content URI:" + strSubstring + ", " + e2.getLocalizedMessage());
                                if (inputStreamOpenInputStream != null) {
                                }
                            }
                            inputStreamOpenInputStream.close();
                        } catch (Throwable th) {
                            if (inputStreamOpenInputStream != null) {
                                inputStreamOpenInputStream.close();
                            }
                            throw th;
                        }
                    } else {
                        length = Base64.decode(str, 0).length;
                    }
                    jAvailable += length2;
                } else {
                    length = str.getBytes().length;
                }
                length2 = length;
                jAvailable += length2;
            }
        }
        this.contentLength = jAvailable;
        return arrayList;
    }

    private class FormField {
        public String data;
        String filename;
        String mime;
        public String name;

        FormField(ReadableMap readableMap) {
            if (readableMap.hasKey("name")) {
                this.name = readableMap.getString("name");
            }
            if (readableMap.hasKey("filename")) {
                this.filename = readableMap.getString("filename");
            }
            if (readableMap.hasKey("type")) {
                this.mime = readableMap.getString("type");
            } else {
                this.mime = this.filename == null ? "text/plain" : Mimetypes.MIMETYPE_OCTET_STREAM;
            }
            if (readableMap.hasKey("data")) {
                this.data = readableMap.getString("data");
            }
        }
    }

    private void emitUploadProgress(long j) {
        ReactNativeBlobUtilProgressConfig reportUploadProgress = ReactNativeBlobUtilReq.getReportUploadProgress(this.mTaskId);
        if (reportUploadProgress != null) {
            long j2 = this.contentLength;
            if (j2 == 0 || !reportUploadProgress.shouldReport(j / j2)) {
                return;
            }
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("taskId", this.mTaskId);
            writableMapCreateMap.putString("written", String.valueOf(j));
            writableMapCreateMap.putString("total", String.valueOf(this.contentLength));
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtil.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_UPLOAD_PROGRESS, writableMapCreateMap);
        }
    }
}
