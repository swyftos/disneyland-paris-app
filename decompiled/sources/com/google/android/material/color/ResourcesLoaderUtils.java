package com.google.android.material.color;

import android.content.Context;
import android.content.res.loader.ResourcesLoader;
import java.util.Map;

/* loaded from: classes4.dex */
abstract class ResourcesLoaderUtils {
    static boolean isColorResource(int i) {
        return 28 <= i && i <= 31;
    }

    static boolean addResourcesLoaderToContext(Context context, Map map) throws Throwable {
        ResourcesLoader resourcesLoaderCreate = ColorResourcesLoaderCreator.create(context, map);
        if (resourcesLoaderCreate == null) {
            return false;
        }
        context.getResources().addLoaders(resourcesLoaderCreate);
        return true;
    }
}
