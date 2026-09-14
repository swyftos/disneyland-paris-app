package com.amazonaws.mobileconnectors.p016s3.transferutility;

import com.amazonaws.services.p017s3.AmazonS3;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
abstract class S3ClientReference {
    private static Map map = new ConcurrentHashMap();

    public static void put(Integer num, AmazonS3 amazonS3) {
        map.put(num, amazonS3);
    }

    public static AmazonS3 get(Integer num) {
        return (AmazonS3) map.get(num);
    }

    public static void remove(Integer num) {
        map.remove(num);
    }
}
