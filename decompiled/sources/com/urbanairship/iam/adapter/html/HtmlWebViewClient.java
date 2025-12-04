package com.urbanairship.iam.adapter.html;

import android.net.Uri;
import android.webkit.WebView;
import androidx.annotation.RestrictTo;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.urbanairship.UALog;
import com.urbanairship.iam.InAppMessageWebViewClient;
import com.urbanairship.javascript.NativeBridge;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/iam/adapter/html/HtmlWebViewClient;", "Lcom/urbanairship/iam/InAppMessageWebViewClient;", "messageExtras", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "nativeBridge", "Lcom/urbanairship/javascript/NativeBridge;", "(Lcom/urbanairship/javascript/NativeBridge;Lcom/urbanairship/json/JsonMap;)V", "onAirshipCommand", "", "webView", "Landroid/webkit/WebView;", "command", "", ReactNativeBlobUtilConst.DATA_ENCODE_URI, "Landroid/net/Uri;", "onMessageDismissed", "argument", "Lcom/urbanairship/json/JsonValue;", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nHtmlWebViewClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HtmlWebViewClient.kt\ncom/urbanairship/iam/adapter/html/HtmlWebViewClient\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,69:1\n731#2,9:70\n37#3,2:79\n*S KotlinDebug\n*F\n+ 1 HtmlWebViewClient.kt\ncom/urbanairship/iam/adapter/html/HtmlWebViewClient\n*L\n48#1:70,9\n48#1:79,2\n*E\n"})
/* loaded from: classes5.dex */
public abstract class HtmlWebViewClient extends InAppMessageWebViewClient {
    public abstract void onMessageDismissed(@NotNull JsonValue argument);

    public HtmlWebViewClient(@Nullable JsonMap jsonMap) {
        super(jsonMap);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HtmlWebViewClient(@NotNull NativeBridge nativeBridge, @Nullable JsonMap jsonMap) {
        super(nativeBridge, jsonMap);
        Intrinsics.checkNotNullParameter(nativeBridge, "nativeBridge");
    }

    @Override // com.urbanairship.webkit.AirshipWebViewClient
    protected void onAirshipCommand(@NotNull WebView webView, @NotNull String command, @NotNull Uri uri) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (Intrinsics.areEqual(command, "dismiss")) {
            String encodedPath = uri.getEncodedPath();
            if (encodedPath == null) {
                UALog.e("Unable to decode message resolution, missing path", new Object[0]);
                return;
            }
            List<String> listSplit = new Regex("/").split(encodedPath, 0);
            if (!listSplit.isEmpty()) {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
            } else {
                listEmptyList = CollectionsKt.emptyList();
            }
            String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
            if (strArr.length <= 1) {
                UALog.e("Unable to decode message resolution, invalid path", new Object[0]);
                return;
            }
            try {
                JsonValue string = JsonValue.parseString(Uri.decode(strArr[1]));
                Intrinsics.checkNotNullExpressionValue(string, "parseString(...)");
                onMessageDismissed(string);
            } catch (JsonException e) {
                UALog.e("Unable to decode message resolution from JSON.", e);
            }
        }
    }
}
