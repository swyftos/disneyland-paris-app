package com.amazonaws.util.json;

import java.io.Reader;
import java.io.Writer;

/* loaded from: classes2.dex */
public interface AwsJsonFactory {
    AwsJsonReader getJsonReader(Reader reader);

    AwsJsonWriter getJsonWriter(Writer writer);
}
