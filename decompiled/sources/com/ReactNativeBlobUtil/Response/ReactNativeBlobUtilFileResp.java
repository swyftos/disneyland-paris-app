package com.ReactNativeBlobUtil.Response;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilProgressConfig;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilReq;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

/* loaded from: classes2.dex */
public class ReactNativeBlobUtilFileResp extends ResponseBody {
    long bytesDownloaded = 0;
    boolean isEndMarkerReceived = false;
    String mPath;
    String mTaskId;
    FileOutputStream ofStream;
    ResponseBody originalBody;
    ReactApplicationContext rctContext;

    public ReactNativeBlobUtilFileResp(ReactApplicationContext reactApplicationContext, String str, ResponseBody responseBody, String str2, boolean z) throws IOException {
        this.rctContext = reactApplicationContext;
        this.mTaskId = str;
        this.originalBody = responseBody;
        this.mPath = str2;
        if (str2 != null) {
            boolean z2 = !z;
            String strReplace = str2.replace("?append=true", "");
            this.mPath = strReplace;
            File file = new File(strReplace);
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IllegalStateException("Couldn't create dir: " + parentFile);
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            this.ofStream = new FileOutputStream(new File(strReplace), z2);
        }
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: contentType */
    public MediaType get$contentType() {
        return this.originalBody.get$contentType();
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: contentLength */
    public long getContentLength() {
        return this.originalBody.getContentLength();
    }

    public boolean isDownloadComplete() {
        return this.bytesDownloaded == getContentLength() || (getContentLength() == -1 && this.isEndMarkerReceived);
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: source */
    public BufferedSource getSource() {
        return Okio.buffer(new ProgressReportingSource());
    }

    private class ProgressReportingSource implements Source {
        @Override // okio.Source
        /* renamed from: timeout */
        public Timeout getTimeout() {
            return null;
        }

        private ProgressReportingSource() {
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            float contentLength;
            int i = (int) j;
            try {
                byte[] bArr = new byte[i];
                long j2 = ReactNativeBlobUtilFileResp.this.originalBody.byteStream().read(bArr, 0, i);
                ReactNativeBlobUtilFileResp reactNativeBlobUtilFileResp = ReactNativeBlobUtilFileResp.this;
                reactNativeBlobUtilFileResp.bytesDownloaded += j2 > 0 ? j2 : 0L;
                if (j2 > 0) {
                    reactNativeBlobUtilFileResp.ofStream.write(bArr, 0, (int) j2);
                } else if (reactNativeBlobUtilFileResp.getContentLength() == -1 && j2 == -1) {
                    ReactNativeBlobUtilFileResp.this.isEndMarkerReceived = true;
                }
                ReactNativeBlobUtilProgressConfig reportProgress = ReactNativeBlobUtilReq.getReportProgress(ReactNativeBlobUtilFileResp.this.mTaskId);
                if (ReactNativeBlobUtilFileResp.this.getContentLength() != 0) {
                    if (ReactNativeBlobUtilFileResp.this.getContentLength() != -1) {
                        ReactNativeBlobUtilFileResp reactNativeBlobUtilFileResp2 = ReactNativeBlobUtilFileResp.this;
                        contentLength = reactNativeBlobUtilFileResp2.bytesDownloaded / reactNativeBlobUtilFileResp2.getContentLength();
                    } else {
                        contentLength = ReactNativeBlobUtilFileResp.this.isEndMarkerReceived ? 1.0f : 0.0f;
                    }
                    if (reportProgress != null && reportProgress.shouldReport(contentLength)) {
                        if (ReactNativeBlobUtilFileResp.this.getContentLength() != -1) {
                            ReactNativeBlobUtilFileResp reactNativeBlobUtilFileResp3 = ReactNativeBlobUtilFileResp.this;
                            reportProgress(reactNativeBlobUtilFileResp3.mTaskId, reactNativeBlobUtilFileResp3.bytesDownloaded, reactNativeBlobUtilFileResp3.getContentLength());
                        } else {
                            ReactNativeBlobUtilFileResp reactNativeBlobUtilFileResp4 = ReactNativeBlobUtilFileResp.this;
                            if (!reactNativeBlobUtilFileResp4.isEndMarkerReceived) {
                                reportProgress(reactNativeBlobUtilFileResp4.mTaskId, 0L, reactNativeBlobUtilFileResp4.getContentLength());
                            } else {
                                String str = reactNativeBlobUtilFileResp4.mTaskId;
                                long j3 = reactNativeBlobUtilFileResp4.bytesDownloaded;
                                reportProgress(str, j3, j3);
                            }
                        }
                    }
                }
                return j2;
            } catch (Exception unused) {
                return -1L;
            }
        }

        private void reportProgress(String str, long j, long j2) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("taskId", str);
            writableMapCreateMap.putString("written", String.valueOf(j));
            writableMapCreateMap.putString("total", String.valueOf(j2));
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilFileResp.this.rctContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_PROGRESS, writableMapCreateMap);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            ReactNativeBlobUtilFileResp.this.ofStream.close();
        }
    }
}
