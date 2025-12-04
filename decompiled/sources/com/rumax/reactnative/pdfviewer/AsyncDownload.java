package com.rumax.reactnative.pdfviewer;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.urbanairship.actions.RateAppAction;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes4.dex */
class AsyncDownload extends AsyncTask {
    private Context context;
    private Exception exception;
    private File file;
    private TaskCompleted listener;
    private String url;
    private final ReadableMap urlProps;

    public interface TaskCompleted {
        void onComplete(Exception exc);
    }

    AsyncDownload(Context context, String str, File file, ReadableMap readableMap, TaskCompleted taskCompleted) {
        this.context = context;
        this.listener = taskCompleted;
        this.file = file;
        this.url = str;
        this.urlProps = readableMap;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.exception = null;
    }

    private void copyAndFlush(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                outputStream.write(bArr, 0, i);
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    private Void handleContentUri(Uri uri) throws IOException {
        try {
            InputStream inputStreamOpenInputStream = this.context.getContentResolver().openInputStream(uri);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.file);
                try {
                    copyAndFlush(inputStreamOpenInputStream, fileOutputStream);
                    fileOutputStream.close();
                    if (inputStreamOpenInputStream == null) {
                        return null;
                    }
                    inputStreamOpenInputStream.close();
                    return null;
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
            this.exception = e;
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Void doInBackground(Void... voidArr) throws IOException {
        BufferedInputStream bufferedInputStream;
        Uri uri = Uri.parse(this.url);
        if (uri.getScheme().equalsIgnoreCase("content")) {
            return handleContentUri(uri);
        }
        try {
            URL url = new URL(this.url);
            String protocol = url.getProtocol();
            if (!protocol.equalsIgnoreCase("http") && !protocol.equalsIgnoreCase("https")) {
                this.exception = new IOException("Protocol \"" + protocol + "\" is not supported");
                return null;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            enrichWithUrlProps(httpURLConnection);
            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
            try {
                httpURLConnection.connect();
                InstrumentationCallbacks.requestSent(httpURLConnection);
                try {
                    bufferedInputStream = new BufferedInputStream(InstrumentationCallbacks.getInputStream(httpURLConnection), 8192);
                } catch (IOException e) {
                    this.exception = e;
                }
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.file);
                    try {
                        copyAndFlush(bufferedInputStream, fileOutputStream);
                        fileOutputStream.close();
                        bufferedInputStream.close();
                        return null;
                    } finally {
                    }
                } finally {
                }
            } catch (IOException e2) {
                InstrumentationCallbacks.networkError(httpURLConnection, e2);
                throw e2;
            }
        } catch (Exception e3) {
            this.exception = e3;
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Void r1) {
        this.listener.onComplete(this.exception);
    }

    private void enrichWithUrlProps(HttpURLConnection httpURLConnection) throws IOException {
        if (this.urlProps == null) {
            return;
        }
        setRequestMethod(httpURLConnection);
        setRequestHeaders(httpURLConnection);
        setRequestBody(httpURLConnection);
    }

    private void setRequestMethod(HttpURLConnection httpURLConnection) throws IOException {
        String string;
        if (!this.urlProps.hasKey("method")) {
            string = "GET";
        } else {
            if (this.urlProps.getType("method") != ReadableType.String) {
                throw new IOException("Invalid method type. String is expected");
            }
            string = this.urlProps.getString("method");
        }
        httpURLConnection.setRequestMethod(string);
    }

    private void setRequestHeaders(HttpURLConnection httpURLConnection) throws IOException {
        ReadableMap map;
        if (this.urlProps.hasKey("headers") && (map = this.urlProps.getMap("headers")) != null) {
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map.keySetIterator();
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                if (map.getType(strNextKey) == ReadableType.String) {
                    httpURLConnection.setRequestProperty(strNextKey, map.getString(strNextKey));
                } else {
                    throw new IOException("Invalid header key type. String is expected for " + strNextKey);
                }
            }
        }
    }

    private void setRequestBody(HttpURLConnection httpURLConnection) throws IOException {
        if (this.urlProps.hasKey(RateAppAction.BODY_KEY)) {
            if (this.urlProps.getType(RateAppAction.BODY_KEY) != ReadableType.String) {
                throw new IOException("Invalid body type. String is expected");
            }
            String string = this.urlProps.getString(RateAppAction.BODY_KEY);
            if (string.getBytes().length > 0) {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestProperty("Content-Length", "" + string.getBytes().length);
                InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    InstrumentationCallbacks.requestSent(httpURLConnection);
                    try {
                        outputStream.write(string.getBytes());
                        outputStream.flush();
                        outputStream.close();
                    } catch (Throwable th) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e) {
                    InstrumentationCallbacks.networkError(httpURLConnection, e);
                    throw e;
                }
            }
        }
    }
}
