package com.facebook.binaryresource;

import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m1836d2 = {"Lcom/facebook/binaryresource/BinaryResource;", "", "openStream", "Ljava/io/InputStream;", "read", "", TCEventPropertiesNames.TCP_SIZE, "", "imagepipeline-base_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface BinaryResource {
    @NotNull
    InputStream openStream() throws IOException;

    @NotNull
    byte[] read() throws IOException;

    long size();
}
