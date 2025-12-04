package org.bouncycastle.mime;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.mime.encoding.Base64InputStream;
import org.bouncycastle.mime.encoding.QuotedPrintableInputStream;

/* loaded from: classes6.dex */
public class BasicMimeParser implements MimeParser {
    private final String boundary;
    private final String defaultContentTransferEncoding;
    private Headers headers;
    private boolean isMultipart;
    private final MimeParserContext parserContext;
    private final InputStream src;

    public BasicMimeParser(InputStream inputStream) throws IOException {
        this(null, new Headers(inputStream, "7bit"), inputStream);
    }

    public BasicMimeParser(Headers headers, InputStream inputStream) {
        this(null, headers, inputStream);
    }

    public BasicMimeParser(MimeParserContext mimeParserContext, InputStream inputStream) throws IOException {
        this(mimeParserContext, new Headers(inputStream, mimeParserContext.getDefaultContentTransferEncoding()), inputStream);
    }

    public BasicMimeParser(MimeParserContext mimeParserContext, Headers headers, InputStream inputStream) {
        String boundary;
        this.isMultipart = false;
        if (headers.isMultipart()) {
            this.isMultipart = true;
            boundary = headers.getBoundary();
        } else {
            boundary = null;
        }
        this.boundary = boundary;
        this.headers = headers;
        this.parserContext = mimeParserContext;
        this.src = inputStream;
        this.defaultContentTransferEncoding = mimeParserContext != null ? mimeParserContext.getDefaultContentTransferEncoding() : "7bit";
    }

    private InputStream processStream(Headers headers, InputStream inputStream) {
        return headers.getContentTransferEncoding().equals("base64") ? new Base64InputStream(inputStream) : headers.getContentTransferEncoding().equals("quoted-printable") ? new QuotedPrintableInputStream(inputStream) : inputStream;
    }

    public boolean isMultipart() {
        return this.isMultipart;
    }

    @Override // org.bouncycastle.mime.MimeParser
    public void parse(MimeParserListener mimeParserListener) throws IOException {
        MimeContext mimeContextCreateContext = mimeParserListener.createContext(this.parserContext, this.headers);
        if (!this.isMultipart) {
            InputStream inputStreamApplyContext = mimeContextCreateContext.applyContext(this.headers, this.src);
            MimeParserContext mimeParserContext = this.parserContext;
            Headers headers = this.headers;
            mimeParserListener.object(mimeParserContext, headers, processStream(headers, inputStreamApplyContext));
            return;
        }
        MimeMultipartContext mimeMultipartContext = (MimeMultipartContext) mimeContextCreateContext;
        String str = "--" + this.boundary;
        LineReader lineReader = new LineReader(this.src);
        boolean z = false;
        int i = 0;
        while (true) {
            String line = lineReader.readLine();
            if (line == null || "--".equals(line)) {
                return;
            }
            if (z) {
                BoundaryLimitedInputStream boundaryLimitedInputStream = new BoundaryLimitedInputStream(this.src, this.boundary);
                Headers headers2 = new Headers(boundaryLimitedInputStream, this.defaultContentTransferEncoding);
                int i2 = i + 1;
                InputStream inputStreamApplyContext2 = mimeMultipartContext.createContext(i).applyContext(headers2, boundaryLimitedInputStream);
                mimeParserListener.object(this.parserContext, headers2, processStream(headers2, inputStreamApplyContext2));
                if (inputStreamApplyContext2.read() >= 0) {
                    throw new IOException("MIME object not fully processed");
                }
                i = i2;
            } else if (str.equals(line)) {
                BoundaryLimitedInputStream boundaryLimitedInputStream2 = new BoundaryLimitedInputStream(this.src, this.boundary);
                Headers headers3 = new Headers(boundaryLimitedInputStream2, this.defaultContentTransferEncoding);
                int i3 = i + 1;
                InputStream inputStreamApplyContext3 = mimeMultipartContext.createContext(i).applyContext(headers3, boundaryLimitedInputStream2);
                mimeParserListener.object(this.parserContext, headers3, processStream(headers3, inputStreamApplyContext3));
                if (inputStreamApplyContext3.read() >= 0) {
                    throw new IOException("MIME object not fully processed");
                }
                z = true;
                i = i3;
            } else {
                continue;
            }
        }
    }
}
