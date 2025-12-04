package com.allegion.accesssdk.interfaces;

import com.urbanairship.channel.AttributeMutation;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/allegion/accesssdk/interfaces/IModelPersistenceManager;", "TModelFormat", "", "src", "", "store", "(Ljava/lang/Object;)V", "retrieve", "()Ljava/lang/Object;", "", "contains", "()Z", AttributeMutation.ATTRIBUTE_ACTION_REMOVE, "()V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public interface IModelPersistenceManager<TModelFormat> {
    boolean contains();

    void remove();

    @Nullable
    TModelFormat retrieve();

    void store(TModelFormat src);
}
