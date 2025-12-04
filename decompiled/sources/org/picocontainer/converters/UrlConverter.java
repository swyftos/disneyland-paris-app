package org.picocontainer.converters;

import java.net.MalformedURLException;
import java.net.URL;
import org.picocontainer.PicoCompositionException;

/* loaded from: classes6.dex */
public class UrlConverter implements Converter<URL> {
    @Override // org.picocontainer.converters.Converter
    public URL convert(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new PicoCompositionException(e);
        }
    }
}
