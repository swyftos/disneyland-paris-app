package com.urbanairship.javascript;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.urbanairship.AirshipExecutors;
import com.urbanairship.Cancelable;
import com.urbanairship.PendingResult;
import com.urbanairship.ResultCallback;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.actions.ActionArguments;
import com.urbanairship.actions.ActionCompletionCallback;
import com.urbanairship.actions.ActionResult;
import com.urbanairship.actions.ActionRunRequestExtender;
import com.urbanairship.actions.ActionRunner;
import com.urbanairship.actions.ActionValue;
import com.urbanairship.actions.DefaultActionRunner;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.UAStringUtil;
import com.urbanairship.util.UriUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class NativeBridge {

    @NonNull
    public static final String UA_ACTION_SCHEME = "uairship";
    private ActionCompletionCallback actionCompletionCallback;
    private final ActionRunner actionRunner;
    private final Executor executor;

    public interface CommandDelegate {
        void onAirshipCommand(@NonNull String str, @NonNull Uri uri);

        void onClose();
    }

    public NativeBridge() {
        this(DefaultActionRunner.INSTANCE, AirshipExecutors.newSerialExecutor());
    }

    public NativeBridge(@NonNull ActionRunner actionRunner) {
        this(actionRunner, AirshipExecutors.newSerialExecutor());
    }

    NativeBridge(ActionRunner actionRunner, Executor executor) {
        this.actionRunner = actionRunner;
        this.executor = executor;
    }

    @SuppressLint({"LambdaLast"})
    public boolean onHandleCommand(@Nullable String str, @NonNull JavaScriptExecutor javaScriptExecutor, @NonNull ActionRunRequestExtender actionRunRequestExtender, @NonNull CommandDelegate commandDelegate) {
        if (str == null) {
            return false;
        }
        Uri uri = Uri.parse(str);
        if (uri.getHost() == null || !"uairship".equals(uri.getScheme())) {
            return false;
        }
        UALog.v("Intercepting: %s", str);
        String host = uri.getHost();
        host.hashCode();
        switch (host) {
            case "run-actions":
                UALog.i("Running run actions command for URL: %s", str);
                runActions(actionRunRequestExtender, decodeActionArguments(uri, false));
                return true;
            case "run-action-cb":
                UALog.i("Running run actions command with callback for URL: %s", str);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments.size() == 3) {
                    UALog.i("Action: %s, Args: %s, Callback: %s", pathSegments.get(0), pathSegments.get(1), pathSegments.get(2));
                    runAction(actionRunRequestExtender, javaScriptExecutor, pathSegments.get(0), pathSegments.get(1), pathSegments.get(2));
                } else {
                    UALog.e("Unable to run action, invalid number of arguments.", new Object[0]);
                }
                return true;
            case "named_user":
                UALog.i("Running set Named User command for URL: %s", uri);
                Map<String, List<String>> queryParameters = UriUtils.getQueryParameters(uri);
                if (queryParameters.get("id") != null) {
                    setNamedUserCommand(queryParameters.get("id").get(0));
                } else if (queryParameters.get("id").get(0) == null) {
                    setNamedUserCommand(null);
                }
                return true;
            case "run-basic-actions":
                UALog.i("Running run basic actions command for URL: %s", str);
                runActions(actionRunRequestExtender, decodeActionArguments(uri, true));
                return true;
            case "close":
                UALog.i("Running close command for URL: %s", str);
                commandDelegate.onClose();
                return true;
            case "multi":
                for (String str2 : uri.getEncodedQuery().split("&")) {
                    onHandleCommand(Uri.decode(str2), javaScriptExecutor, actionRunRequestExtender, commandDelegate);
                }
                return true;
            default:
                commandDelegate.onAirshipCommand(uri.getHost(), uri);
                return true;
        }
    }

    public void setActionCompletionCallback(@Nullable ActionCompletionCallback actionCompletionCallback) {
        this.actionCompletionCallback = actionCompletionCallback;
    }

    @NonNull
    public Cancelable loadJavaScriptEnvironment(@NonNull final Context context, @NonNull final JavaScriptEnvironment javaScriptEnvironment, @NonNull final JavaScriptExecutor javaScriptExecutor) {
        UALog.i("Loading Airship Javascript interface.", new Object[0]);
        final PendingResult pendingResult = new PendingResult();
        pendingResult.addResultCallback(Looper.myLooper(), new ResultCallback() { // from class: com.urbanairship.javascript.NativeBridge$$ExternalSyntheticLambda0
            @Override // com.urbanairship.ResultCallback
            public final void onResult(Object obj) {
                NativeBridge.lambda$loadJavaScriptEnvironment$0(javaScriptExecutor, (String) obj);
            }
        });
        this.executor.execute(new Runnable() { // from class: com.urbanairship.javascript.NativeBridge$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                NativeBridge.lambda$loadJavaScriptEnvironment$1(pendingResult, javaScriptEnvironment, context);
            }
        });
        return pendingResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadJavaScriptEnvironment$0(JavaScriptExecutor javaScriptExecutor, String str) {
        if (str != null) {
            javaScriptExecutor.executeJavaScript(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadJavaScriptEnvironment$1(PendingResult pendingResult, JavaScriptEnvironment javaScriptEnvironment, Context context) {
        pendingResult.setResult(javaScriptEnvironment.getJavaScript(context));
    }

    private void runActions(ActionRunRequestExtender actionRunRequestExtender, Map map) {
        if (map == null) {
            return;
        }
        for (String str : map.keySet()) {
            List list = (List) map.get(str);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    this.actionRunner.run(str, (ActionValue) it.next(), 3, actionRunRequestExtender, this.actionCompletionCallback);
                }
            }
        }
    }

    private void runAction(ActionRunRequestExtender actionRunRequestExtender, final JavaScriptExecutor javaScriptExecutor, final String str, String str2, final String str3) {
        try {
            this.actionRunner.run(str, new ActionValue(JsonValue.parseString(str2)), 3, actionRunRequestExtender, new ActionCompletionCallback() { // from class: com.urbanairship.javascript.NativeBridge.1
                @Override // com.urbanairship.actions.ActionCompletionCallback
                public void onFinish(ActionArguments actionArguments, ActionResult actionResult) {
                    String message;
                    int status = actionResult.getStatus();
                    if (status == 2) {
                        message = String.format("Action %s rejected its arguments", str);
                    } else if (status == 3) {
                        message = String.format("Action %s not found", str);
                    } else if (status != 4) {
                        message = null;
                    } else if (actionResult.getException() != null) {
                        message = actionResult.getException().getMessage();
                    } else {
                        message = String.format("Action %s failed with unspecified error", str);
                    }
                    NativeBridge.this.triggerCallback(javaScriptExecutor, message, actionResult.getValue(), str3);
                    synchronized (this) {
                        try {
                            if (NativeBridge.this.actionCompletionCallback != null) {
                                NativeBridge.this.actionCompletionCallback.onFinish(actionArguments, actionResult);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            });
        } catch (JsonException e) {
            UALog.e(e, "Unable to parse action argument value: %s", str2);
            triggerCallback(javaScriptExecutor, "Unable to decode arguments payload", new ActionValue(), str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerCallback(JavaScriptExecutor javaScriptExecutor, String str, ActionValue actionValue, String str2) {
        String str3;
        String str4 = String.format("'%s'", str2);
        if (str == null) {
            str3 = "null";
        } else {
            str3 = String.format(Locale.US, "new Error(%s)", JSONObject.quote(str));
        }
        javaScriptExecutor.executeJavaScript(String.format(Locale.US, "UAirship.finishAction(%s, %s, %s);", str3, actionValue.toString(), str4));
    }

    private Map decodeActionArguments(Uri uri, boolean z) {
        JsonValue jsonValueWrap;
        Map<String, List<String>> queryParameters = UriUtils.getQueryParameters(uri);
        HashMap map = new HashMap();
        for (String str : queryParameters.keySet()) {
            ArrayList arrayList = new ArrayList();
            if (queryParameters.get(str) == null) {
                UALog.w("No arguments to decode for actionName: %s", str);
                return null;
            }
            List<String> list = queryParameters.get(str);
            if (list != null) {
                for (String str2 : list) {
                    if (z) {
                        try {
                            jsonValueWrap = JsonValue.wrap(str2);
                        } catch (JsonException e) {
                            UALog.w(e, "Invalid json. Unable to create action argument " + str + " with args: " + str2, new Object[0]);
                            return null;
                        }
                    } else {
                        jsonValueWrap = JsonValue.parseString(str2);
                    }
                    arrayList.add(new ActionValue(jsonValueWrap));
                }
                map.put(str, arrayList);
            }
        }
        if (!map.isEmpty()) {
            return map;
        }
        UALog.w("Error no action names are present in the actions key set", new Object[0]);
        return null;
    }

    private void setNamedUserCommand(String str) {
        if (str != null) {
            str = str.trim();
        }
        if (UAStringUtil.isEmpty(str)) {
            UAirship.shared().getContact().reset();
        } else {
            UAirship.shared().getContact().identify(str);
        }
    }
}
