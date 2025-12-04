package com.facebook.binaryresource;

import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/facebook/binaryresource/BinaryResource;", "", "openStream", "Ljava/io/InputStream;", "read", "", TCEventPropertiesNames.TCP_SIZE, "", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface BinaryResource {
    @NotNull
    InputStream openStream() throws IOException;

    @NotNull
    byte[] read() throws IOException;

    long size();
}
