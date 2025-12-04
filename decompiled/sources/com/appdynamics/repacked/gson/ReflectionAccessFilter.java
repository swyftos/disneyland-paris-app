package com.appdynamics.repacked.gson;

import com.appdynamics.repacked.gson.internal.ReflectionAccessFilterHelper;

/* loaded from: classes2.dex */
public interface ReflectionAccessFilter {
    public static final ReflectionAccessFilter BLOCK_INACCESSIBLE_JAVA = new ReflectionAccessFilter() { // from class: com.appdynamics.repacked.gson.ReflectionAccessFilter.1
        @Override // com.appdynamics.repacked.gson.ReflectionAccessFilter
        public FilterResult check(Class cls) {
            if (ReflectionAccessFilterHelper.isJavaType((Class<?>) cls)) {
                return FilterResult.BLOCK_INACCESSIBLE;
            }
            return FilterResult.INDECISIVE;
        }
    };
    public static final ReflectionAccessFilter BLOCK_ALL_JAVA = new ReflectionAccessFilter() { // from class: com.appdynamics.repacked.gson.ReflectionAccessFilter.2
        @Override // com.appdynamics.repacked.gson.ReflectionAccessFilter
        public FilterResult check(Class cls) {
            if (ReflectionAccessFilterHelper.isJavaType((Class<?>) cls)) {
                return FilterResult.BLOCK_ALL;
            }
            return FilterResult.INDECISIVE;
        }
    };
    public static final ReflectionAccessFilter BLOCK_ALL_ANDROID = new ReflectionAccessFilter() { // from class: com.appdynamics.repacked.gson.ReflectionAccessFilter.3
        @Override // com.appdynamics.repacked.gson.ReflectionAccessFilter
        public FilterResult check(Class cls) {
            if (ReflectionAccessFilterHelper.isAndroidType((Class<?>) cls)) {
                return FilterResult.BLOCK_ALL;
            }
            return FilterResult.INDECISIVE;
        }
    };
    public static final ReflectionAccessFilter BLOCK_ALL_PLATFORM = new ReflectionAccessFilter() { // from class: com.appdynamics.repacked.gson.ReflectionAccessFilter.4
        @Override // com.appdynamics.repacked.gson.ReflectionAccessFilter
        public FilterResult check(Class cls) {
            if (ReflectionAccessFilterHelper.isAnyPlatformType(cls)) {
                return FilterResult.BLOCK_ALL;
            }
            return FilterResult.INDECISIVE;
        }
    };

    public enum FilterResult {
        ALLOW,
        INDECISIVE,
        BLOCK_INACCESSIBLE,
        BLOCK_ALL
    }

    FilterResult check(Class<?> cls);
}
