package com.facebook.react.devsupport;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
class MultipartStreamReader {
    private static final String CRLF = "\r\n";
    private final String mBoundary;
    private long mLastProgressEvent;
    private final BufferedSource mSource;

    public interface ChunkListener {
        void onChunkComplete(Map<String, String> map, Buffer buffer, boolean z) throws IOException;

        void onChunkProgress(Map<String, String> map, long j, long j2) throws IOException;
    }

    public MultipartStreamReader(BufferedSource bufferedSource, String str) {
        this.mSource = bufferedSource;
        this.mBoundary = str;
    }

    private Map<String, String> parseHeaders(Buffer buffer) {
        HashMap map = new HashMap();
        for (String str : buffer.readUtf8().split("\r\n")) {
            int iIndexOf = str.indexOf(":");
            if (iIndexOf != -1) {
                map.put(str.substring(0, iIndexOf).trim(), str.substring(iIndexOf + 1).trim());
            }
        }
        return map;
    }

    private void emitChunk(Buffer buffer, boolean z, ChunkListener chunkListener) throws IOException {
        ByteString byteStringEncodeUtf8 = ByteString.encodeUtf8("\r\n\r\n");
        long jIndexOf = buffer.indexOf(byteStringEncodeUtf8);
        if (jIndexOf == -1) {
            chunkListener.onChunkComplete(null, buffer, z);
            return;
        }
        Buffer buffer2 = new Buffer();
        Buffer buffer3 = new Buffer();
        buffer.read(buffer2, jIndexOf);
        buffer.skip(byteStringEncodeUtf8.size());
        buffer.readAll(buffer3);
        chunkListener.onChunkComplete(parseHeaders(buffer2), buffer3, z);
    }

    private void emitProgress(Map<String, String> map, long j, boolean z, ChunkListener chunkListener) throws IOException {
        if (map == null || chunkListener == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.mLastProgressEvent > 16 || z) {
            this.mLastProgressEvent = jCurrentTimeMillis;
            chunkListener.onChunkProgress(map, j, map.get("Content-Length") != null ? Long.parseLong(map.get("Content-Length")) : 0L);
        }
    }

    public boolean readAllParts(ChunkListener chunkListener) throws IOException {
        boolean z;
        ByteString byteStringEncodeUtf8 = ByteString.encodeUtf8("\r\n--" + this.mBoundary + "\r\n");
        ByteString byteStringEncodeUtf9 = ByteString.encodeUtf8("\r\n--" + this.mBoundary + "--\r\n");
        ByteString byteStringEncodeUtf10 = ByteString.encodeUtf8("\r\n\r\n");
        Buffer buffer = new Buffer();
        long j = 0L;
        long size = 0L;
        long size2 = 0L;
        Map<String, String> headers = null;
        while (true) {
            long jMax = Math.max(j - ((long) byteStringEncodeUtf9.size()), size);
            long jIndexOf = buffer.indexOf(byteStringEncodeUtf8, jMax);
            if (jIndexOf == -1) {
                jIndexOf = buffer.indexOf(byteStringEncodeUtf9, jMax);
                z = true;
            } else {
                z = false;
            }
            if (jIndexOf == -1) {
                long size3 = buffer.size();
                if (headers == null) {
                    long jIndexOf2 = buffer.indexOf(byteStringEncodeUtf10, jMax);
                    if (jIndexOf2 >= 0) {
                        this.mSource.read(buffer, jIndexOf2);
                        Buffer buffer2 = new Buffer();
                        buffer.copyTo(buffer2, jMax, jIndexOf2 - jMax);
                        size2 = buffer2.size() + ((long) byteStringEncodeUtf10.size());
                        headers = parseHeaders(buffer2);
                    }
                } else {
                    emitProgress(headers, buffer.size() - size2, false, chunkListener);
                }
                if (this.mSource.read(buffer, 4096) <= 0) {
                    return false;
                }
                j = size3;
                size = size;
            } else {
                long j2 = size;
                long j3 = jIndexOf - j2;
                if (j2 > 0) {
                    Buffer buffer3 = new Buffer();
                    buffer.skip(j2);
                    buffer.read(buffer3, j3);
                    emitProgress(headers, buffer3.size() - size2, true, chunkListener);
                    emitChunk(buffer3, z, chunkListener);
                    size2 = 0;
                    headers = null;
                } else {
                    buffer.skip(jIndexOf);
                }
                if (z) {
                    return true;
                }
                size = byteStringEncodeUtf8.size();
                j = size;
            }
        }
    }
}
