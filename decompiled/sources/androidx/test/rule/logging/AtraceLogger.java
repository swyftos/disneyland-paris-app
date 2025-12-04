package androidx.test.rule.logging;

import android.app.Instrumentation;
import android.app.UiAutomation;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.test.annotation.Beta;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Beta
/* loaded from: classes2.dex */
public class AtraceLogger {
    private static volatile AtraceLogger loggerInstance;
    private List atraceDataList;
    private boolean atraceRunning = false;
    private File destAtraceDirectory;
    private IOException dumpIOException;
    private Thread dumpThread;
    private String traceFileName;
    private UiAutomation uiAutomation;

    private AtraceLogger(Instrumentation instrumentation) {
        this.uiAutomation = instrumentation.getUiAutomation();
    }

    public static AtraceLogger getAtraceLoggerInstance(Instrumentation instrumentation) {
        if (loggerInstance == null) {
            synchronized (AtraceLogger.class) {
                try {
                    if (loggerInstance == null) {
                        loggerInstance = new AtraceLogger(instrumentation);
                    }
                } finally {
                }
            }
        }
        return loggerInstance;
    }

    public void atraceStart(Set<String> set, int i, int i2, File file, String str) throws IOException {
        if (this.atraceRunning) {
            throw new IllegalStateException("Attempted multiple atrace start");
        }
        if (set.isEmpty()) {
            throw new IllegalArgumentException("Empty categories. Should contain atleast one category");
        }
        if (file == null) {
            throw new IllegalArgumentException("Destination directory cannot be null");
        }
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException("Unable to create the destination directory");
        }
        this.destAtraceDirectory = file;
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            stringBuffer.append(" ");
        }
        if (str != null && !str.isEmpty()) {
            this.traceFileName = str;
        }
        String str2 = String.format("atrace --async_start -b %d -c %s", Integer.valueOf(i), stringBuffer.toString());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            writeDataToByteStream(this.uiAutomation.executeShellCommand(str2), byteArrayOutputStream);
            byteArrayOutputStream.close();
            this.atraceRunning = true;
            this.dumpIOException = null;
            this.atraceDataList = new ArrayList();
            Thread thread = new Thread(new DumpTraceRunnable(stringBuffer.toString(), i, i2));
            this.dumpThread = thread;
            thread.start();
        } catch (Throwable th) {
            byteArrayOutputStream.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeDataToByteStream(ParcelFileDescriptor parcelFileDescriptor, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int i = autoCloseInputStream.read(bArr);
                if (i < 0) {
                    return;
                } else {
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            }
        } finally {
            autoCloseInputStream.close();
        }
    }

    public void atraceStop() throws InterruptedException, IOException {
        if (!this.atraceRunning) {
            throw new IllegalStateException("ATrace is not running currently. Start atrace beforestopping.");
        }
        try {
            this.dumpThread.interrupt();
            this.dumpThread.join();
            IOException iOException = this.dumpIOException;
            if (iOException != null) {
                throw iOException;
            }
            atraceWrite();
        } finally {
            Iterator it = this.atraceDataList.iterator();
            while (it.hasNext()) {
                ((ByteArrayOutputStream) it.next()).close();
            }
            this.atraceRunning = false;
            this.traceFileName = null;
        }
    }

    private void atraceWrite() throws IOException {
        File file;
        int i = 0;
        for (ByteArrayOutputStream byteArrayOutputStream : this.atraceDataList) {
            if (this.traceFileName != null) {
                file = new File(this.destAtraceDirectory, String.format("%s-atrace-%d.txt", this.traceFileName, Integer.valueOf(i)));
            } else {
                file = new File(this.destAtraceDirectory, String.format("atrace-%d.txt", Integer.valueOf(i)));
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.close();
                i++;
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        }
    }

    private class DumpTraceRunnable implements Runnable {
        private int bufferSize;
        private int dumpIntervalInSecs;
        private String traceCategories;

        DumpTraceRunnable(String str, int i, int i2) {
            this.traceCategories = str;
            this.bufferSize = i;
            this.dumpIntervalInSecs = i2;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    try {
                        Thread.sleep(this.dumpIntervalInSecs * 1000);
                        String str = String.format("atrace --async_dump -b %d -z %s", Integer.valueOf(this.bufferSize), this.traceCategories);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        AtraceLogger atraceLogger = AtraceLogger.this;
                        atraceLogger.writeDataToByteStream(atraceLogger.uiAutomation.executeShellCommand(str), byteArrayOutputStream);
                        AtraceLogger.this.atraceDataList.add(byteArrayOutputStream);
                        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                        StringBuilder sb = new StringBuilder(54);
                        sb.append("Time taken by - DumpTraceRunnable ");
                        sb.append(jCurrentTimeMillis2);
                        Log.i("AtraceLogger", sb.toString());
                    } catch (InterruptedException unused) {
                    }
                } catch (IOException e) {
                    AtraceLogger.this.dumpIOException = e;
                    return;
                }
            }
            String str2 = String.format("atrace --async_stop -b %d -z %s", Integer.valueOf(this.bufferSize), this.traceCategories);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            AtraceLogger atraceLogger2 = AtraceLogger.this;
            atraceLogger2.writeDataToByteStream(atraceLogger2.uiAutomation.executeShellCommand(str2), byteArrayOutputStream2);
            AtraceLogger.this.atraceDataList.add(byteArrayOutputStream2);
        }
    }
}
