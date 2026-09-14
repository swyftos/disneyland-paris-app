package com.appdynamics.eumagent.runtime;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.eumagent.runtime.p192private.C2063am;
import com.appdynamics.eumagent.runtime.p192private.C2068ar;
import com.appdynamics.eumagent.runtime.p192private.C2069as;
import com.appdynamics.eumagent.runtime.p192private.C2075ay;
import com.appdynamics.eumagent.runtime.p192private.C2079bb;
import com.appdynamics.eumagent.runtime.p192private.C2082be;
import com.appdynamics.eumagent.runtime.p192private.C2101bx;
import com.appdynamics.eumagent.runtime.p192private.C2102by;
import com.appdynamics.eumagent.runtime.p192private.C2103bz;
import com.appdynamics.eumagent.runtime.p192private.C2105ca;
import com.appdynamics.eumagent.runtime.p192private.C2106cb;
import com.appdynamics.eumagent.runtime.p192private.C2108cd;
import com.appdynamics.eumagent.runtime.p192private.C2112ch;
import com.appdynamics.eumagent.runtime.p192private.C2119co;
import com.appdynamics.eumagent.runtime.p192private.C2123cs;
import com.appdynamics.eumagent.runtime.p192private.C2124ct;
import com.appdynamics.eumagent.runtime.p192private.C2138q;
import com.appdynamics.eumagent.runtime.p192private.C2144w;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.ArrayList;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes2.dex */
public class InstrumentationCallbacks {
    public static WeakReference<Activity> currentActivity;

    public static void webViewCrashed(Object obj, Throwable th) {
        try {
            C2144w c2144w = Instrumentation.f399b;
            if (c2144w != null) {
                c2144w.m717a(Thread.currentThread(), th);
            } else {
                ADLog.logInfo("Crash Reporting has been disabled, not reporting crash");
            }
        } catch (Throwable th2) {
            ADLog.logAgentError("Exception while reporting crash", th2);
        }
    }

    public static void onCreateCalled(Activity activity, Bundle bundle) {
        reportActivityLifecycleEvent(activity, 0);
    }

    public static void onStartCalled(Activity activity) {
        reportActivityLifecycleEvent(activity, 1);
    }

    public static void onResumeCalled(Activity activity) {
        reportActivityLifecycleEvent(activity, 2);
        currentActivity = new WeakReference<>(activity);
        if (Instrumentation.initializationStarted) {
            try {
                C2112ch c2112ch = Instrumentation.f401d;
                if (activity.getWindow() != null && c2112ch != null) {
                    c2112ch.m647a(activity.getWindow().getDecorView());
                }
                C2063am c2063am = Instrumentation.f398a;
                if (c2063am != null) {
                    View viewM622a = C2103bz.m622a(activity);
                    if (viewM622a == null) {
                        viewM622a = activity.getWindow().getDecorView().getRootView();
                    }
                    c2063am.m562a(new C2082be(viewM622a));
                }
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while trying to watch root view", th);
            }
        }
    }

    public static void onPauseCalled(Activity activity) {
        reportActivityLifecycleEvent(activity, 3);
    }

    public static void onStopCalled(Activity activity) {
        reportActivityLifecycleEvent(activity, 4);
    }

    public static void onDestroyCalled(Activity activity) {
        reportActivityLifecycleEvent(activity, 6);
    }

    public static void onRestartCalled(Activity activity) {
        reportActivityLifecycleEvent(activity, 5);
    }

    public static void onConfigurationChangedCalled(Activity activity, Configuration configuration) {
        if (Instrumentation.initializationStarted) {
            try {
                if (Instrumentation.f405h != null) {
                    Instrumentation.f398a.m562a(new C2082be(C2103bz.m622a(activity)));
                }
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while dispatching orientation changed event", th);
            }
        }
    }

    public static void dispatchTouchEventCalled(Activity activity, MotionEvent motionEvent) {
        if (Instrumentation.initializationStarted) {
            try {
                Instrumentation instrumentation = Instrumentation.f405h;
                if (instrumentation != null) {
                    C2138q c2138q = instrumentation.f415l;
                    if (c2138q.f903b.screenshotsEnabled && c2138q.f902a.f906a.booleanValue() && !Instrumentation.screenshotsBlocked() && c2138q.f902a.f908c.booleanValue()) {
                        Instrumentation.f398a.m562a(MotionEvent.obtain(motionEvent));
                    }
                }
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while capturing touch", th);
            }
        }
    }

    private static void reportActivityLifecycleEvent(Activity activity, int i) {
        String name;
        if (activity != null) {
            try {
                name = activity.getClass().getName();
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while reporting Activity lifecycle event", th);
                return;
            }
        } else {
            name = "null";
        }
        Instrumentation.f398a.m562a(new C2102by(name, i));
    }

    public static void onStartCalled(Fragment fragment) {
        reportFragmentLifecycleEvent(fragment, 0);
    }

    public static void onStopCalled(Fragment fragment) {
        reportFragmentLifecycleEvent(fragment, 1);
    }

    private static void reportFragmentLifecycleEvent(Fragment fragment, int i) {
        String name;
        if (fragment != null) {
            try {
                name = fragment.getClass().getName();
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while reporting Fragment lifecycle event", th);
                return;
            }
        } else {
            name = "Unknown";
        }
        Instrumentation.f398a.m562a(new C2108cd(name, fragment != null ? System.identityHashCode(fragment) : -1, i, new C2123cs()));
    }

    public static void onPauseCalled(androidx.fragment.app.Fragment fragment) {
        reportFragmentLifecycleEvent(fragment, 2);
    }

    public static void onResumeCalled(androidx.fragment.app.Fragment fragment) {
        reportFragmentLifecycleEvent(fragment, 3);
    }

    public static void onStartCalled(androidx.fragment.app.Fragment fragment) {
        reportFragmentLifecycleEvent(fragment, 0);
    }

    public static void onStopCalled(androidx.fragment.app.Fragment fragment) {
        reportFragmentLifecycleEvent(fragment, 1);
    }

    private static void reportFragmentLifecycleEvent(androidx.fragment.app.Fragment fragment, int i) {
        String name;
        if (fragment != null) {
            try {
                name = fragment.getClass().getName();
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while reporting Fragment lifecycle event", th);
                return;
            }
        } else {
            name = "Unknown";
        }
        Instrumentation.f398a.m562a(new C2108cd(name, fragment != null ? System.identityHashCode(fragment) : -1, i, new C2123cs()));
    }

    public static void requestAboutToBeSent(URLConnection uRLConnection) {
        C2079bb c2079bb;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.requestAboutToBeSent called");
            Instrumentation instrumentation = Instrumentation.f405h;
            if (instrumentation == null || (c2079bb = instrumentation.f412i) == null || !(uRLConnection instanceof HttpURLConnection)) {
                return;
            }
            c2079bb.m588b((HttpURLConnection) uRLConnection);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception in pre-request handler", th);
        }
    }

    public static void requestSent(URLConnection uRLConnection) {
        C2079bb c2079bb;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.requestSent called");
            Instrumentation instrumentation = Instrumentation.f405h;
            if (instrumentation == null || (c2079bb = instrumentation.f412i) == null || !(uRLConnection instanceof HttpURLConnection)) {
                return;
            }
            c2079bb.m589c((HttpURLConnection) uRLConnection);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception in post-request handler", th);
        }
    }

    public static void requestHarvestable(URLConnection uRLConnection) {
        C2079bb c2079bb;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.requestHarvestable called");
            Instrumentation instrumentation = Instrumentation.f405h;
            if (instrumentation == null || (c2079bb = instrumentation.f412i) == null || !(uRLConnection instanceof HttpURLConnection)) {
                return;
            }
            c2079bb.m589c((HttpURLConnection) uRLConnection);
            instrumentation.f412i.m586a((HttpURLConnection) uRLConnection);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception in marking request as reportable", th);
        }
    }

    public static void networkError(URLConnection uRLConnection, IOException iOException) {
        C2079bb c2079bb;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.networkError called");
            Instrumentation instrumentation = Instrumentation.f405h;
            if (instrumentation == null || (c2079bb = instrumentation.f412i) == null || !(uRLConnection instanceof HttpURLConnection)) {
                return;
            }
            c2079bb.m587a((HttpURLConnection) uRLConnection, iOException);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception in network request handler", th);
        }
    }

    public static InputStream getInputStream(URLConnection uRLConnection) {
        final C2079bb c2079bb;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.getInputStream called");
            Instrumentation instrumentation = Instrumentation.f405h;
            if (instrumentation != null && (c2079bb = instrumentation.f412i) != null && (uRLConnection instanceof HttpURLConnection)) {
                final HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
                return new C2079bb.a(c2079bb) { // from class: com.appdynamics.eumagent.runtime.private.bb.3
                    {
                        byte b = 0;
                    }

                    @Override // com.appdynamics.eumagent.runtime.p192private.C2079bb.a
                    /* JADX INFO: renamed from: a */
                    final InputStream mo591a() {
                        return httpURLConnection.getInputStream();
                    }
                }.m592a(httpURLConnection);
            }
        } catch (C2119co e) {
            strip(e.getCause());
            e.m653a(IOException.class);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while fetching input stream", th);
        }
        try {
            return uRLConnection.getInputStream();
        } catch (IOException e2) {
            strip(e2);
            throw e2;
        } catch (RuntimeException e3) {
            strip(e3);
            throw e3;
        }
    }

    public static InputStream getErrorStream(final HttpURLConnection httpURLConnection) {
        final C2079bb c2079bb;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.getErrorStream called");
            Instrumentation instrumentation = Instrumentation.f405h;
            if (instrumentation != null && (c2079bb = instrumentation.f412i) != null) {
                return new C2079bb.a(c2079bb) { // from class: com.appdynamics.eumagent.runtime.private.bb.2
                    {
                        byte b = 0;
                    }

                    @Override // com.appdynamics.eumagent.runtime.p192private.C2079bb.a
                    /* JADX INFO: renamed from: a */
                    final InputStream mo591a() {
                        return httpURLConnection.getErrorStream();
                    }
                }.m592a(httpURLConnection);
            }
        } catch (C2119co e) {
            strip(e.getCause());
            e.m652a();
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while fetching error stream", th);
        }
        try {
            return httpURLConnection.getErrorStream();
        } catch (RuntimeException e2) {
            strip(e2);
            throw e2;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: T */
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest) throws T, IOException {
        C2075ay c2075ay;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.execute(HttpClient, HttpUriRequest) called");
            Instrumentation instrumentation = Instrumentation.f405h;
            if (instrumentation != null && (c2075ay = instrumentation.f413j) != null) {
                return c2075ay.m579a(httpClient, httpUriRequest);
            }
        } catch (C2119co e) {
            strip(e.getCause());
            e.m653a(IOException.class);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while executing http request", th);
        }
        try {
            return httpClient.execute(httpUriRequest);
        } catch (IOException e2) {
            strip(e2);
            throw e2;
        } catch (RuntimeException e3) {
            strip(e3);
            throw e3;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: T */
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext) throws T, IOException {
        C2075ay c2075ay;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.execute(HttpClient, HttpUriRequest, HttpContext) called");
            Instrumentation instrumentation = Instrumentation.f405h;
            if (instrumentation != null && (c2075ay = instrumentation.f413j) != null) {
                return c2075ay.m580a(httpClient, httpUriRequest, httpContext);
            }
        } catch (C2119co e) {
            strip(e.getCause());
            e.m653a(IOException.class);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while executing http request", th);
        }
        try {
            return httpClient.execute(httpUriRequest, httpContext);
        } catch (IOException e2) {
            strip(e2);
            throw e2;
        } catch (RuntimeException e3) {
            strip(e3);
            throw e3;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: T */
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest) throws T, IOException {
        C2075ay c2075ay;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.execute(HttpClient, HttpHost, HttpRequest) called");
            Instrumentation instrumentation = Instrumentation.f405h;
            if (instrumentation != null && (c2075ay = instrumentation.f413j) != null) {
                return c2075ay.m577a(httpClient, httpHost, httpRequest);
            }
        } catch (C2119co e) {
            strip(e.getCause());
            e.m653a(IOException.class);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while executing http request", th);
        }
        try {
            return httpClient.execute(httpHost, httpRequest);
        } catch (IOException e2) {
            strip(e2);
            throw e2;
        } catch (RuntimeException e3) {
            strip(e3);
            throw e3;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: T */
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws T, IOException {
        C2075ay c2075ay;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.execute(HttpClient, HttpHost, HttpRequest, HttpContext) called");
            Instrumentation instrumentation = Instrumentation.f405h;
            if (instrumentation != null && (c2075ay = instrumentation.f413j) != null) {
                return c2075ay.m578a(httpClient, httpHost, httpRequest, httpContext);
            }
        } catch (C2119co e) {
            strip(e.getCause());
            e.m653a(IOException.class);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while executing http request", th);
        }
        try {
            return httpClient.execute(httpHost, httpRequest, httpContext);
        } catch (IOException e2) {
            strip(e2);
            throw e2;
        } catch (RuntimeException e3) {
            strip(e3);
            throw e3;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: T */
    public static Object execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler responseHandler) throws T, IOException {
        C2075ay c2075ay;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.execute(HttpClient, HttpUriRequest, ResponseHandler) called");
            Instrumentation instrumentation = Instrumentation.f405h;
            if (instrumentation != null && (c2075ay = instrumentation.f413j) != null) {
                return c2075ay.m575a(httpClient, httpUriRequest, responseHandler);
            }
        } catch (C2119co e) {
            strip(e.getCause());
            e.m653a(IOException.class);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while executing http request", th);
        }
        try {
            return httpClient.execute(httpUriRequest, responseHandler);
        } catch (IOException e2) {
            strip(e2);
            throw e2;
        } catch (RuntimeException e3) {
            strip(e3);
            throw e3;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: T */
    public static Object execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler responseHandler, HttpContext httpContext) throws T, IOException {
        C2075ay c2075ay;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.execute(HttpClient, HttpUriRequest, ResponseHandler, HttpContext) called");
            Instrumentation instrumentation = Instrumentation.f405h;
            if (instrumentation != null && (c2075ay = instrumentation.f413j) != null) {
                return c2075ay.m576a(httpClient, httpUriRequest, responseHandler, httpContext);
            }
        } catch (C2119co e) {
            strip(e.getCause());
            e.m653a(IOException.class);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while executing http request", th);
        }
        try {
            return httpClient.execute(httpUriRequest, responseHandler, httpContext);
        } catch (IOException e2) {
            strip(e2);
            throw e2;
        } catch (RuntimeException e3) {
            strip(e3);
            throw e3;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: T */
    public static Object execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler) throws T, IOException {
        C2075ay c2075ay;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.execute(HttpClient, HttpHost, HttpRequest, ResponseHandler) called");
            Instrumentation instrumentation = Instrumentation.f405h;
            if (instrumentation != null && (c2075ay = instrumentation.f413j) != null) {
                return c2075ay.m573a(httpClient, httpHost, httpRequest, responseHandler);
            }
        } catch (C2119co e) {
            strip(e.getCause());
            e.m653a(IOException.class);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while executing http request", th);
        }
        try {
            return httpClient.execute(httpHost, httpRequest, responseHandler);
        } catch (IOException e2) {
            strip(e2);
            throw e2;
        } catch (RuntimeException e3) {
            strip(e3);
            throw e3;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: T */
    public static Object execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler, HttpContext httpContext) throws T, IOException {
        C2075ay c2075ay;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.execute(HttpClient, HttpHost, HttpRequest, ResponseHandler, HttpContext) called");
            Instrumentation instrumentation = Instrumentation.f405h;
            if (instrumentation != null && (c2075ay = instrumentation.f413j) != null) {
                return c2075ay.m574a(httpClient, httpHost, httpRequest, responseHandler, httpContext);
            }
        } catch (C2119co e) {
            strip(e.getCause());
            e.m653a(IOException.class);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while executing http request", th);
        }
        try {
            return httpClient.execute(httpHost, httpRequest, responseHandler, httpContext);
        } catch (IOException e2) {
            strip(e2);
            throw e2;
        } catch (RuntimeException e3) {
            strip(e3);
            throw e3;
        }
    }

    public static void setOnHierarchyChangeListenerCalled(ViewGroup viewGroup, ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        try {
            ADLog.logVerbose("InstrumentationCallbacks.OnSetOnHierarchyChangeListener(ViewGroup, OnHierarchyChangeListener) called");
            C2112ch c2112ch = Instrumentation.f401d;
            if (Instrumentation.initializationStarted && c2112ch != null) {
                if (!c2112ch.f793c.get().booleanValue()) {
                    c2112ch.f793c.set(Boolean.TRUE);
                    if (onHierarchyChangeListener == c2112ch.f792b) {
                        c2112ch.f793c.set(Boolean.FALSE);
                        return;
                    }
                    if (onHierarchyChangeListener != null) {
                        c2112ch.f791a.put(viewGroup, onHierarchyChangeListener);
                    } else {
                        c2112ch.f791a.remove(viewGroup);
                    }
                    viewGroup.setOnHierarchyChangeListener(c2112ch.f792b);
                    c2112ch.f793c.set(Boolean.FALSE);
                    return;
                }
                ADLog.logWarning("setOnHierarchyChangeListener detected recursion.");
                return;
            }
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while setting hierarchy change listener on view group", th);
        }
        try {
            viewGroup.setOnHierarchyChangeListener(onHierarchyChangeListener);
        } catch (RuntimeException e) {
            strip(e);
            throw e;
        }
    }

    public static void setOnClickListenerCalled(View view, View.OnClickListener onClickListener) {
        try {
            ADLog.logVerbose("InstrumentationCallbacks.setOnClickListenerCalled(View, OnClickListener) called");
            C2105ca c2105ca = Instrumentation.f402e;
            if (Instrumentation.initializationStarted && (view instanceof Button) && c2105ca != null) {
                c2105ca.m635a(view, onClickListener);
                return;
            }
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while setting click listener on view", th);
        }
        try {
            view.setOnClickListener(onClickListener);
        } catch (RuntimeException e) {
            strip(e);
            throw e;
        }
    }

    public static void setOnItemClickListenerCalled(AdapterView adapterView, AdapterView.OnItemClickListener onItemClickListener) {
        try {
            ADLog.logVerbose("InstrumentationCallbacks.setOnItemClickListenerCalled(AdapterView, OnItemClickListener) called");
            C2101bx c2101bx = Instrumentation.f403f;
            if (Instrumentation.initializationStarted && c2101bx != null) {
                c2101bx.m621a(adapterView, onItemClickListener);
                return;
            }
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while setting click listener on view", th);
        }
        try {
            adapterView.setOnItemClickListener(onItemClickListener);
        } catch (RuntimeException e) {
            strip(e);
            throw e;
        }
    }

    public static void setOnFocusChangeListenerCalled(View view, View.OnFocusChangeListener onFocusChangeListener) {
        try {
            ADLog.logVerbose("InstrumentationCallbacks.setOnFocusChangeListenerCalled(View, OnFocusChangeListener) called");
            C2106cb c2106cb = Instrumentation.f404g;
            if (Instrumentation.initializationStarted && (view instanceof EditText) && c2106cb != null) {
                c2106cb.m636a(view, onFocusChangeListener);
                return;
            }
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while setting focus change listener on view", th);
        }
        try {
            view.setOnFocusChangeListener(onFocusChangeListener);
        } catch (RuntimeException e) {
            strip(e);
            throw e;
        }
    }

    private static void strip(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement.getClassName() == null || !stackTraceElement.getClassName().startsWith("com.appdynamics.eumagent.runtime")) {
                    arrayList.add(stackTraceElement);
                } else {
                    z = true;
                }
            }
            if (z) {
                th.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]));
            }
        } catch (Throwable th2) {
            ADLog.logAgentError("Failed to strip stacktrace", th2);
        }
    }

    public static void reportAgentError(String str, Throwable th) {
        Instrumentation instrumentation = Instrumentation.f405h;
        if (instrumentation != null) {
            C2069as c2069as = instrumentation.f414k;
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (jUptimeMillis > c2069as.f574b + 60000) {
                c2069as.f576d.m562a(new C2068ar(str, th, c2069as.f575c));
                c2069as.f575c = 0;
                c2069as.f574b = jUptimeMillis;
                return;
            }
            c2069as.f575c++;
        }
    }

    public static void loadUrlCalled(WebView webView) {
        try {
            ADLog.logVerbose("loadUrl(String url) called");
            Instrumentation instrumentation = Instrumentation.f405h;
            if (webView == null || instrumentation == null) {
                return;
            }
            C2138q c2138q = instrumentation.f415l;
            if (c2138q.f903b.jsAgentInjectionEnabled && c2138q.f902a.f910e.booleanValue()) {
                ADLog.logVerbose("adding JS callback handler to WebView");
                webView.addJavascriptInterface(new JSAgentCallback(), "ADEUM_js_handler");
            }
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while setting JS callback on WebView", th);
        }
    }

    public static void postUrlCalled(WebView webView) {
        try {
            ADLog.logVerbose("postUrl(String url) called");
            Instrumentation instrumentation = Instrumentation.f405h;
            if (webView == null || instrumentation == null) {
                return;
            }
            C2138q c2138q = instrumentation.f415l;
            if (c2138q.f903b.jsAgentInjectionEnabled && c2138q.f902a.f910e.booleanValue()) {
                ADLog.logVerbose("adding JS callback handler to WebView");
                webView.addJavascriptInterface(new JSAgentCallback(), "ADEUM_js_handler");
            }
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while setting JS callback on WebView", th);
        }
    }

    public static void onPageFinishedCalled(WebViewClient webViewClient, WebView webView, String str) {
        try {
            ADLog.logVerbose("onPageFinishedCalled");
            if (webView == null) {
                return;
            }
            boolean z = true;
            if (webView.getClass().getName().contains("cordova")) {
                ADLog.logVerbose("injecting JS Agent into Cordova WebView");
                webView.loadUrl(C2124ct.m658a(true));
                return;
            }
            Instrumentation instrumentation = Instrumentation.f405h;
            if (instrumentation != null) {
                C2138q c2138q = instrumentation.f415l;
                if (c2138q.f903b.jsAgentInjectionEnabled && c2138q.f902a.f910e.booleanValue()) {
                    ADLog.logVerbose("injecting JS Agent");
                    C2138q c2138q2 = instrumentation.f415l;
                    if (!c2138q2.f903b.jsAgentInjectionEnabled || !c2138q2.f902a.f910e.booleanValue() || !c2138q2.f902a.f912g.booleanValue()) {
                        z = false;
                    }
                    webView.loadUrl(C2124ct.m658a(z));
                }
            }
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while injecting JS into WebView", th);
        }
    }
}
