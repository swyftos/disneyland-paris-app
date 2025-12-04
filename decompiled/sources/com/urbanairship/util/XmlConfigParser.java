package com.urbanairship.util;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.io.Closeable;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class XmlConfigParser extends AttributeSetConfigParser implements Closeable {
    private final XmlResourceParser parser;

    private XmlConfigParser(Context context, AttributeSet attributeSet, XmlResourceParser xmlResourceParser) {
        super(context, attributeSet);
        this.parser = xmlResourceParser;
    }

    @NonNull
    public static XmlConfigParser parseElement(@NonNull Context context, int i, @NonNull String str) throws XmlPullParserException, Resources.NotFoundException, IOException {
        AttributeSet attributeSetAsAttributeSet;
        XmlResourceParser xml = context.getResources().getXml(i);
        while (true) {
            try {
                int next = xml.next();
                if (next == 2 && xml.getName().equals(str)) {
                    attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                    break;
                }
                if (next == 1) {
                    attributeSetAsAttributeSet = null;
                    break;
                }
            } catch (IOException | XmlPullParserException e) {
                xml.close();
                throw e;
            }
        }
        if (attributeSetAsAttributeSet == null) {
            xml.close();
            throw new IOException("Element " + str + " not found");
        }
        return new XmlConfigParser(context, attributeSetAsAttributeSet, xml);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        XmlResourceParser xmlResourceParser = this.parser;
        if (xmlResourceParser != null) {
            xmlResourceParser.close();
        }
    }
}
