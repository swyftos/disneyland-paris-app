package com.urbanairship.featureflag;

import com.urbanairship.featureflag.FeatureFlagInfo;
import com.urbanairship.json.JsonMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
/* synthetic */ class FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$3 extends FunctionReferenceImpl implements Function1 {
    FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$3(Object obj) {
        super(1, obj, FeatureFlagInfo.Companion.class, "fromJson", "fromJson$urbanairship_feature_flag_release(Lcom/urbanairship/json/JsonMap;)Lcom/urbanairship/featureflag/FeatureFlagInfo;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FeatureFlagInfo invoke(JsonMap p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((FeatureFlagInfo.Companion) this.receiver).fromJson$urbanairship_feature_flag_release(p0);
    }
}
