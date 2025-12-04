package com.amazonaws.mobileconnectors.s3.transfermanager;

import com.amazonaws.services.s3.model.ResponseHeaderOverrides;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonReader;
import com.amazonaws.util.json.JsonUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import org.bouncycastle.cms.CMSAttributeTableGenerator;

@Deprecated
/* loaded from: classes2.dex */
public abstract class PersistableTransfer {
    public abstract String serialize();

    public final void serialize(OutputStream outputStream) throws IOException {
        outputStream.write(serialize().getBytes(StringUtils.UTF8));
        outputStream.flush();
    }

    public static <T extends PersistableTransfer> T deserializeFrom(InputStream inputStream) throws NumberFormatException {
        AwsJsonReader jsonReader = JsonUtils.getJsonReader(new BufferedReader(new InputStreamReader(inputStream, StringUtils.UTF8)));
        try {
            jsonReader.beginObject();
            String strNextString = null;
            String strNextString2 = null;
            String strNextString3 = null;
            long[] jArr = null;
            String strNextString4 = null;
            ResponseHeaderOverrides responseHeaderOverrides = null;
            String strNextString5 = null;
            long j = -1;
            long j2 = -1;
            boolean z = false;
            String strNextString6 = null;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (strNextName.equals("pauseType")) {
                    strNextString = jsonReader.nextString();
                } else if (strNextName.equals("bucketName")) {
                    strNextString6 = jsonReader.nextString();
                } else if (strNextName.equals("key")) {
                    strNextString2 = jsonReader.nextString();
                } else if (strNextName.equals("file")) {
                    strNextString5 = jsonReader.nextString();
                } else if (strNextName.equals("multipartUploadId")) {
                    strNextString4 = jsonReader.nextString();
                } else if (strNextName.equals("partSize")) {
                    j = Long.parseLong(jsonReader.nextString());
                } else if (strNextName.equals("mutlipartUploadThreshold")) {
                    j2 = Long.parseLong(jsonReader.nextString());
                } else if (strNextName.equals("versionId")) {
                    strNextString3 = jsonReader.nextString();
                } else if (strNextName.equals("range")) {
                    jsonReader.beginArray();
                    long[] jArr2 = {Long.parseLong(jsonReader.nextString()), Long.parseLong(jsonReader.nextString())};
                    jsonReader.endArray();
                    jArr = jArr2;
                } else if (strNextName.equals("responseHeaders")) {
                    ResponseHeaderOverrides responseHeaderOverrides2 = new ResponseHeaderOverrides();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        if (strNextName2.equals(CMSAttributeTableGenerator.CONTENT_TYPE)) {
                            responseHeaderOverrides2.setContentType(jsonReader.nextString());
                        } else if (strNextName2.equals("contentLanguage")) {
                            responseHeaderOverrides2.setContentLanguage(jsonReader.nextString());
                        } else if (strNextName2.equals("expires")) {
                            responseHeaderOverrides2.setExpires(jsonReader.nextString());
                        } else if (strNextName2.equals("cacheControl")) {
                            responseHeaderOverrides2.setCacheControl(jsonReader.nextString());
                        } else if (strNextName2.equals("contentDisposition")) {
                            responseHeaderOverrides2.setContentDisposition(jsonReader.nextString());
                        } else if (strNextName2.equals("contentEncoding")) {
                            responseHeaderOverrides2.setContentEncoding(jsonReader.nextString());
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    responseHeaderOverrides = responseHeaderOverrides2;
                } else if (strNextName.equals("isRequesterPays")) {
                    z = Boolean.parseBoolean(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if ("download".equals(strNextString)) {
                return new PersistableDownload(strNextString6, strNextString2, strNextString3, jArr, responseHeaderOverrides, z, strNextString5);
            }
            if ("upload".equals(strNextString)) {
                return new PersistableUpload(strNextString6, strNextString2, strNextString5, strNextString4, j, j2);
            }
            throw new UnsupportedOperationException("Unsupported paused transfer type: " + strNextString);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static <T extends PersistableTransfer> T deserializeFrom(String str) throws IOException {
        if (str == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes(StringUtils.UTF8));
        try {
            return (T) deserializeFrom(byteArrayInputStream);
        } finally {
            try {
                byteArrayInputStream.close();
            } catch (IOException unused) {
            }
        }
    }
}
