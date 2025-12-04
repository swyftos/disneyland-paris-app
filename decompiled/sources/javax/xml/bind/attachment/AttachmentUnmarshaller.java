package javax.xml.bind.attachment;

import javax.activation.DataHandler;

/* loaded from: classes5.dex */
public abstract class AttachmentUnmarshaller {
    public abstract byte[] getAttachmentAsByteArray(String str);

    public abstract DataHandler getAttachmentAsDataHandler(String str);

    public boolean isXOPPackage() {
        return false;
    }
}
