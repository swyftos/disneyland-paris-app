package io.cucumber.junit;

import android.content.Context;
import android.content.res.AssetManager;
import cucumber.runtime.CucumberException;
import cucumber.runtime.io.ResourceLoader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
final class AndroidResourceLoader implements ResourceLoader {
    private final Context context;

    AndroidResourceLoader(Context context) {
        this.context = context;
    }

    @Override // cucumber.runtime.io.ResourceLoader
    public Iterable resources(URI uri, String str) {
        try {
            ArrayList arrayList = new ArrayList();
            addResourceRecursive(arrayList, this.context.getAssets(), uri, str);
            return arrayList;
        } catch (IOException e) {
            throw new CucumberException("Error loading resources from " + uri + " with suffix " + str, e);
        }
    }

    private void addResourceRecursive(List list, AssetManager assetManager, URI uri, String str) throws IOException {
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        if (schemeSpecificPart.endsWith(str)) {
            list.add(new AndroidResource(this.context, uri));
            return;
        }
        String[] list2 = assetManager.list(schemeSpecificPart);
        if (list2 != null) {
            for (String str2 : list2) {
                addResourceRecursive(list, assetManager, URI.create(String.format("%s/%s", uri.toString(), str2)), str);
            }
        }
    }
}
