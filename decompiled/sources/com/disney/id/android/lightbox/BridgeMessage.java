package com.disney.id.android.lightbox;

import androidx.annotation.Keep;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\b\u0010\u001a\u001a\u00020\u0004H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n8\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00108\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/disney/id/android/lightbox/BridgeMessage;", "", "()V", "callback", "", "getCallback$OneID_release", "()Ljava/lang/String;", "setCallback$OneID_release", "(Ljava/lang/String;)V", "data", "", "getData$OneID_release", "()Ljava/util/Map;", "setData$OneID_release", "(Ljava/util/Map;)V", "keys", "", "getKeys$OneID_release", "()Ljava/util/List;", "setKeys$OneID_release", "(Ljava/util/List;)V", "executeCallback", "", "jsExecutor", "Lcom/disney/id/android/lightbox/JavascriptExecutor;", "parameter", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBridgeMessage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BridgeMessage.kt\ncom/disney/id/android/lightbox/BridgeMessage\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,48:1\n215#2,2:49\n1855#3,2:51\n*S KotlinDebug\n*F\n+ 1 BridgeMessage.kt\ncom/disney/id/android/lightbox/BridgeMessage\n*L\n38#1:49,2\n43#1:51,2\n*E\n"})
/* loaded from: classes3.dex */
public final class BridgeMessage {

    @SerializedName("callback")
    @Expose
    @Nullable
    private String callback;

    @SerializedName("data")
    @Expose
    @Nullable
    private Map<String, ? extends Object> data;

    @SerializedName("keys")
    @Expose
    @Nullable
    private List<String> keys;

    @Nullable
    /* renamed from: getCallback$OneID_release, reason: from getter */
    public final String getCallback() {
        return this.callback;
    }

    public final void setCallback$OneID_release(@Nullable String str) {
        this.callback = str;
    }

    @Nullable
    public final Map<String, Object> getData$OneID_release() {
        return this.data;
    }

    public final void setData$OneID_release(@Nullable Map<String, ? extends Object> map) {
        this.data = map;
    }

    @Nullable
    public final List<String> getKeys$OneID_release() {
        return this.keys;
    }

    public final void setKeys$OneID_release(@Nullable List<String> list) {
        this.keys = list;
    }

    public static /* synthetic */ void executeCallback$default(BridgeMessage bridgeMessage, JavascriptExecutor javascriptExecutor, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        bridgeMessage.executeCallback(javascriptExecutor, str);
    }

    public final void executeCallback(@NotNull JavascriptExecutor jsExecutor, @Nullable String parameter) {
        Intrinsics.checkNotNullParameter(jsExecutor, "jsExecutor");
        String str = this.callback;
        if (str != null) {
            if (parameter == null) {
                parameter = "";
            }
            jsExecutor.executeJavascript("didNativeToWeb[\"" + str + "\"](" + parameter + ")");
        }
    }

    @NotNull
    public String toString() {
        String str = "callback: '" + this.callback + "'\n";
        if (this.data != null) {
            str = ((Object) str) + "data:\n";
            Map<String, ? extends Object> map = this.data;
            if (map != null) {
                for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    str = ((Object) str) + "   " + ((Object) key) + " = '" + entry.getValue() + "'\n";
                }
            }
        }
        if (this.keys == null) {
            return str;
        }
        String str2 = ((Object) str) + "keys:\n";
        List<String> list = this.keys;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                str2 = ((Object) str2) + "   " + ((String) it.next()) + "\n";
            }
        }
        return str2;
    }
}
