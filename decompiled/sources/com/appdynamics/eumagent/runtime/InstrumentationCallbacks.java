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
import com.appdynamics.eumagent.runtime.p000private.am;
import com.appdynamics.eumagent.runtime.p000private.ar;
import com.appdynamics.eumagent.runtime.p000private.as;
import com.appdynamics.eumagent.runtime.p000private.ay;
import com.appdynamics.eumagent.runtime.p000private.bb;
import com.appdynamics.eumagent.runtime.p000private.be;
import com.appdynamics.eumagent.runtime.p000private.bx;
import com.appdynamics.eumagent.runtime.p000private.by;
import com.appdynamics.eumagent.runtime.p000private.bz;
import com.appdynamics.eumagent.runtime.p000private.ca;
import com.appdynamics.eumagent.runtime.p000private.cb;
import com.appdynamics.eumagent.runtime.p000private.cd;
import com.appdynamics.eumagent.runtime.p000private.ch;
import com.appdynamics.eumagent.runtime.p000private.co;
import com.appdynamics.eumagent.runtime.p000private.cs;
import com.appdynamics.eumagent.runtime.p000private.ct;
import com.appdynamics.eumagent.runtime.p000private.q;
import com.appdynamics.eumagent.runtime.p000private.w;
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

/* loaded from: classes2.dex */
public class InstrumentationCallbacks {
    public static WeakReference<Activity> currentActivity;

    public static void webViewCrashed(Object obj, Throwable th) {
        try {
            w wVar = Instrumentation.b;
            if (wVar != null) {
                wVar.a(Thread.currentThread(), th);
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
                ch chVar = Instrumentation.d;
                if (activity.getWindow() != null && chVar != null) {
                    chVar.a(activity.getWindow().getDecorView());
                }
                am amVar = Instrumentation.a;
                if (amVar != null) {
                    View viewA = bz.a(activity);
                    if (viewA == null) {
                        viewA = activity.getWindow().getDecorView().getRootView();
                    }
                    amVar.a(new be(viewA));
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
                if (Instrumentation.h != null) {
                    Instrumentation.a.a(new be(bz.a(activity)));
                }
            } catch (Throwable th) {
                ADLog.logAgentError("Exception while dispatching orientation changed event", th);
            }
        }
    }

    public static void dispatchTouchEventCalled(Activity activity, MotionEvent motionEvent) {
        if (Instrumentation.initializationStarted) {
            try {
                Instrumentation instrumentation = Instrumentation.h;
                if (instrumentation != null) {
                    q qVar = instrumentation.l;
                    if (qVar.b.screenshotsEnabled && qVar.a.a.booleanValue() && !Instrumentation.screenshotsBlocked() && qVar.a.c.booleanValue()) {
                        Instrumentation.a.a(MotionEvent.obtain(motionEvent));
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
        Instrumentation.a.a(new by(name, i));
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
        Instrumentation.a.a(new cd(name, fragment != null ? System.identityHashCode(fragment) : -1, i, new cs()));
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
        Instrumentation.a.a(new cd(name, fragment != null ? System.identityHashCode(fragment) : -1, i, new cs()));
    }

    public static void requestAboutToBeSent(URLConnection uRLConnection) {
        bb bbVar;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.requestAboutToBeSent called");
            Instrumentation instrumentation = Instrumentation.h;
            if (instrumentation == null || (bbVar = instrumentation.i) == null || !(uRLConnection instanceof HttpURLConnection)) {
                return;
            }
            bbVar.b((HttpURLConnection) uRLConnection);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception in pre-request handler", th);
        }
    }

    public static void requestSent(URLConnection uRLConnection) {
        bb bbVar;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.requestSent called");
            Instrumentation instrumentation = Instrumentation.h;
            if (instrumentation == null || (bbVar = instrumentation.i) == null || !(uRLConnection instanceof HttpURLConnection)) {
                return;
            }
            bbVar.c((HttpURLConnection) uRLConnection);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception in post-request handler", th);
        }
    }

    public static void requestHarvestable(URLConnection uRLConnection) {
        bb bbVar;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.requestHarvestable called");
            Instrumentation instrumentation = Instrumentation.h;
            if (instrumentation == null || (bbVar = instrumentation.i) == null || !(uRLConnection instanceof HttpURLConnection)) {
                return;
            }
            bbVar.c((HttpURLConnection) uRLConnection);
            instrumentation.i.a((HttpURLConnection) uRLConnection);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception in marking request as reportable", th);
        }
    }

    public static void networkError(URLConnection uRLConnection, IOException iOException) {
        bb bbVar;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.networkError called");
            Instrumentation instrumentation = Instrumentation.h;
            if (instrumentation == null || (bbVar = instrumentation.i) == null || !(uRLConnection instanceof HttpURLConnection)) {
                return;
            }
            bbVar.a((HttpURLConnection) uRLConnection, iOException);
        } catch (Throwable th) {
            ADLog.logAgentError("Exception in network request handler", th);
        }
    }

    public static InputStream getInputStream(URLConnection uRLConnection) {
        final bb bbVar;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.getInputStream called");
            Instrumentation instrumentation = Instrumentation.h;
            if (instrumentation != null && (bbVar = instrumentation.i) != null && (uRLConnection instanceof HttpURLConnection)) {
                final HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
                return new bb.a(bbVar) { // from class: com.appdynamics.eumagent.runtime.private.bb.3
                    {
                        byte b = 0;
                    }

                    @Override // com.appdynamics.eumagent.runtime.private.bb.a
                    final InputStream a() {
                        return httpURLConnection.getInputStream();
                    }
                }.a(httpURLConnection);
            }
        } catch (co e) {
            strip(e.getCause());
            e.a(IOException.class);
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
        final bb bbVar;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.getErrorStream called");
            Instrumentation instrumentation = Instrumentation.h;
            if (instrumentation != null && (bbVar = instrumentation.i) != null) {
                return new bb.a(bbVar) { // from class: com.appdynamics.eumagent.runtime.private.bb.2
                    {
                        byte b = 0;
                    }

                    @Override // com.appdynamics.eumagent.runtime.private.bb.a
                    final InputStream a() {
                        return httpURLConnection.getErrorStream();
                    }
                }.a(httpURLConnection);
            }
        } catch (co e) {
            strip(e.getCause());
            e.a();
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

    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest) throws T, IOException {
        ay ayVar;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.execute(HttpClient, HttpUriRequest) called");
            Instrumentation instrumentation = Instrumentation.h;
            if (instrumentation != null && (ayVar = instrumentation.j) != null) {
                return ayVar.a(httpClient, httpUriRequest);
            }
        } catch (co e) {
            strip(e.getCause());
            e.a(IOException.class);
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

    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext) throws T, IOException {
        ay ayVar;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.execute(HttpClient, HttpUriRequest, HttpContext) called");
            Instrumentation instrumentation = Instrumentation.h;
            if (instrumentation != null && (ayVar = instrumentation.j) != null) {
                return ayVar.a(httpClient, httpUriRequest, httpContext);
            }
        } catch (co e) {
            strip(e.getCause());
            e.a(IOException.class);
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

    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest) throws T, IOException {
        ay ayVar;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.execute(HttpClient, HttpHost, HttpRequest) called");
            Instrumentation instrumentation = Instrumentation.h;
            if (instrumentation != null && (ayVar = instrumentation.j) != null) {
                return ayVar.a(httpClient, httpHost, httpRequest);
            }
        } catch (co e) {
            strip(e.getCause());
            e.a(IOException.class);
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

    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws T, IOException {
        ay ayVar;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.execute(HttpClient, HttpHost, HttpRequest, HttpContext) called");
            Instrumentation instrumentation = Instrumentation.h;
            if (instrumentation != null && (ayVar = instrumentation.j) != null) {
                return ayVar.a(httpClient, httpHost, httpRequest, httpContext);
            }
        } catch (co e) {
            strip(e.getCause());
            e.a(IOException.class);
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

    public static Object execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler responseHandler) throws T, IOException {
        ay ayVar;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.execute(HttpClient, HttpUriRequest, ResponseHandler) called");
            Instrumentation instrumentation = Instrumentation.h;
            if (instrumentation != null && (ayVar = instrumentation.j) != null) {
                return ayVar.a(httpClient, httpUriRequest, responseHandler);
            }
        } catch (co e) {
            strip(e.getCause());
            e.a(IOException.class);
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

    public static Object execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler responseHandler, HttpContext httpContext) throws T, IOException {
        ay ayVar;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.execute(HttpClient, HttpUriRequest, ResponseHandler, HttpContext) called");
            Instrumentation instrumentation = Instrumentation.h;
            if (instrumentation != null && (ayVar = instrumentation.j) != null) {
                return ayVar.a(httpClient, httpUriRequest, responseHandler, httpContext);
            }
        } catch (co e) {
            strip(e.getCause());
            e.a(IOException.class);
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

    public static Object execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler) throws T, IOException {
        ay ayVar;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.execute(HttpClient, HttpHost, HttpRequest, ResponseHandler) called");
            Instrumentation instrumentation = Instrumentation.h;
            if (instrumentation != null && (ayVar = instrumentation.j) != null) {
                return ayVar.a(httpClient, httpHost, httpRequest, responseHandler);
            }
        } catch (co e) {
            strip(e.getCause());
            e.a(IOException.class);
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

    public static Object execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler, HttpContext httpContext) throws T, IOException {
        ay ayVar;
        try {
            ADLog.logVerbose("InstrumentationCallbacks.execute(HttpClient, HttpHost, HttpRequest, ResponseHandler, HttpContext) called");
            Instrumentation instrumentation = Instrumentation.h;
            if (instrumentation != null && (ayVar = instrumentation.j) != null) {
                return ayVar.a(httpClient, httpHost, httpRequest, responseHandler, httpContext);
            }
        } catch (co e) {
            strip(e.getCause());
            e.a(IOException.class);
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
            ch chVar = Instrumentation.d;
            if (Instrumentation.initializationStarted && chVar != null) {
                if (!chVar.c.get().booleanValue()) {
                    chVar.c.set(Boolean.TRUE);
                    if (onHierarchyChangeListener == chVar.b) {
                        chVar.c.set(Boolean.FALSE);
                        return;
                    }
                    if (onHierarchyChangeListener != null) {
                        chVar.a.put(viewGroup, onHierarchyChangeListener);
                    } else {
                        chVar.a.remove(viewGroup);
                    }
                    viewGroup.setOnHierarchyChangeListener(chVar.b);
                    chVar.c.set(Boolean.FALSE);
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
            ca caVar = Instrumentation.e;
            if (Instrumentation.initializationStarted && (view instanceof Button) && caVar != null) {
                caVar.a(view, onClickListener);
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
            bx bxVar = Instrumentation.f;
            if (Instrumentation.initializationStarted && bxVar != null) {
                bxVar.a(adapterView, onItemClickListener);
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
            cb cbVar = Instrumentation.g;
            if (Instrumentation.initializationStarted && (view instanceof EditText) && cbVar != null) {
                cbVar.a(view, onFocusChangeListener);
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
        Instrumentation instrumentation = Instrumentation.h;
        if (instrumentation != null) {
            as asVar = instrumentation.k;
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (jUptimeMillis > asVar.b + 60000) {
                asVar.d.a(new ar(str, th, asVar.c));
                asVar.c = 0;
                asVar.b = jUptimeMillis;
                return;
            }
            asVar.c++;
        }
    }

    public static void loadUrlCalled(WebView webView) {
        try {
            ADLog.logVerbose("loadUrl(String url) called");
            Instrumentation instrumentation = Instrumentation.h;
            if (webView == null || instrumentation == null) {
                return;
            }
            q qVar = instrumentation.l;
            if (qVar.b.jsAgentInjectionEnabled && qVar.a.e.booleanValue()) {
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
            Instrumentation instrumentation = Instrumentation.h;
            if (webView == null || instrumentation == null) {
                return;
            }
            q qVar = instrumentation.l;
            if (qVar.b.jsAgentInjectionEnabled && qVar.a.e.booleanValue()) {
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
                webView.loadUrl(ct.a(true));
                return;
            }
            Instrumentation instrumentation = Instrumentation.h;
            if (instrumentation != null) {
                q qVar = instrumentation.l;
                if (qVar.b.jsAgentInjectionEnabled && qVar.a.e.booleanValue()) {
                    ADLog.logVerbose("injecting JS Agent");
                    q qVar2 = instrumentation.l;
                    if (!qVar2.b.jsAgentInjectionEnabled || !qVar2.a.e.booleanValue() || !qVar2.a.g.booleanValue()) {
                        z = false;
                    }
                    webView.loadUrl(ct.a(z));
                }
            }
        } catch (Throwable th) {
            ADLog.logAgentError("Exception while injecting JS into WebView", th);
        }
    }
}
