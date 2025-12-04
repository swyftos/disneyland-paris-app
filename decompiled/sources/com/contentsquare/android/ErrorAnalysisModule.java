package com.contentsquare.android;

import android.content.Context;
import com.contentsquare.android.core.communication.StartableModule;
import com.contentsquare.android.core.communication.error.ErrorAnalysisInterface;
import com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface;
import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.features.http.HttpConnection;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.error.analysis.ErrorAnalysis;
import com.contentsquare.android.error.analysis.apierror.NetworkEventController;
import com.contentsquare.android.error.analysis.apierror.NetworkEventCounter;
import com.contentsquare.android.error.analysis.apierror.encryption.AsymmetricCryptor;
import com.contentsquare.android.error.analysis.apierror.encryption.SymmetricCryptor;
import com.contentsquare.android.error.analysis.apierror.v1.NativeNetworkEventProcessorV1;
import com.contentsquare.android.error.analysis.apierror.v1.WebViewNetworkEventProcessor;
import com.contentsquare.android.error.analysis.apierror.v1.processors.NetworkEventCompressor;
import com.contentsquare.android.error.analysis.apierror.v1.processors.NetworkEventConfigurator;
import com.contentsquare.android.error.analysis.apierror.v1.processors.NetworkEventEncryptor;
import com.contentsquare.android.error.analysis.apierror.v1.processors.NetworkEventPIIAnonymizer;
import com.contentsquare.android.error.analysis.apierror.v1.processors.NetworkEventUrlProcessor;
import com.contentsquare.android.error.analysis.apierror.v2.NativeNetworkEventProcessorV2;
import com.contentsquare.android.error.analysis.crash.CrashDataUploader;
import com.contentsquare.android.error.analysis.crash.CrashEventReporter;
import com.contentsquare.android.error.analysis.crash.CrashHandlerController;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B5\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/contentsquare/android/ErrorAnalysisModule;", "Lcom/contentsquare/android/core/communication/StartableModule;", "Lcom/contentsquare/android/core/communication/error/ErrorAnalysisInterface;", "Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface$ConfigurationChangedListener;", "Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;", "libraryInterface", "Lcom/contentsquare/android/error/analysis/crash/CrashHandlerController;", "crashHandlerController", "Lcom/contentsquare/android/error/analysis/apierror/NetworkEventController;", "networkEventController", "Lcom/contentsquare/android/error/analysis/apierror/NetworkEventCounter;", "networkEventCounter", "<init>", "(Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;Lcom/contentsquare/android/error/analysis/crash/CrashHandlerController;Lcom/contentsquare/android/error/analysis/apierror/NetworkEventController;Lcom/contentsquare/android/error/analysis/apierror/NetworkEventCounter;)V", "(Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;)V", "error-analysis_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nErrorAnalysisModule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ErrorAnalysisModule.kt\ncom/contentsquare/android/ErrorAnalysisModule\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,205:1\n1#2:206\n*E\n"})
/* loaded from: classes2.dex */
public final class ErrorAnalysisModule implements StartableModule, ErrorAnalysisInterface, ErrorAnalysisLibraryInterface.ConfigurationChangedListener {

    @NotNull
    public final ErrorAnalysisLibraryInterface a;

    @NotNull
    public final Logger b;

    @NotNull
    public final CrashHandlerController c;

    @NotNull
    public final NetworkEventController d;

    @Nullable
    public Context e;
    public boolean f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ErrorAnalysisModule(ErrorAnalysisLibraryInterface libraryInterface) {
        this(libraryInterface, null, null, null, 12, null);
        Intrinsics.checkNotNullParameter(libraryInterface, "libraryInterface");
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisInterface
    public final boolean isApiErrorEnabled() {
        return this.d.isApiErrorEnabled();
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisInterface
    public final boolean isCrashReportingEnabled() {
        return this.c.isCrashReportingEnabled();
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface.ConfigurationChangedListener
    public final void onConfigurationChanged(PreferencesKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            if (this.f) {
                if (this.c.isCrashReportingEnabled()) {
                    Context context = this.e;
                    if (context != null) {
                        this.c.start(context);
                    }
                } else if (this.e != null) {
                    this.c.stop();
                }
                if (this.d.isApiErrorEnabled()) {
                    this.d.start();
                } else {
                    this.d.stop();
                }
                this.d.onConfigurationChanged();
            }
        } catch (Throwable th) {
            this.b.d(th, "Exception received while start/stop Error Analysis Module from onPreferenceChanged");
        }
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisInterface
    public final void sendNetworkEvent(NetworkEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            NetworkEventController.sendNetworkEvent$default(this.d, event, null, 2, null);
        } catch (Throwable th) {
            this.b.d(th, "Exception received while sending api error");
        }
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisInterface
    public final void sendReactNativeError(Map<String, ? extends Object> details) {
        Intrinsics.checkNotNullParameter(details, "details");
        this.c.sendReactNativeError(details);
    }

    @Override // com.contentsquare.android.core.communication.error.ErrorAnalysisInterface
    public final void setUrlMaskingPatterns(List<String> patterns) {
        Intrinsics.checkNotNullParameter(patterns, "patterns");
        this.d.setUrlMaskingPatterns(patterns);
        this.a.collectApiCall("set_url_masking_patterns");
    }

    @Override // com.contentsquare.android.core.communication.StartableModule
    public final void start(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            this.e = context;
            this.f = true;
            ErrorAnalysis.INSTANCE.getInstance().setErrorAnalysisModule(this);
            this.a.registerConfigurationChangedListener(this);
            if (this.c.isCrashReportingEnabled()) {
                Context context2 = this.e;
                if (context2 != null) {
                    this.c.start(context2);
                }
            } else if (this.e != null) {
                this.c.stop();
            }
            if (this.d.isApiErrorEnabled()) {
                this.d.start();
            } else {
                this.d.stop();
            }
        } catch (Throwable th) {
            this.b.d(th, "Exception received while starting Error Analysis Module");
        }
    }

    @Override // com.contentsquare.android.core.communication.StartableModule
    public final void stop(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            this.e = null;
            this.f = false;
            ErrorAnalysis.INSTANCE.getInstance().setErrorAnalysisModule(null);
            this.c.stop();
            this.d.stop();
        } catch (Throwable th) {
            this.b.d(th, "Exception received while stopping Error Analysis Module");
        }
    }

    public ErrorAnalysisModule(ErrorAnalysisLibraryInterface libraryInterface, CrashHandlerController crashHandlerController, NetworkEventController networkEventController, NetworkEventCounter networkEventCounter) {
        CrashHandlerController crashHandlerController2;
        NetworkEventController networkEventController2;
        Intrinsics.checkNotNullParameter(libraryInterface, "libraryInterface");
        this.a = libraryInterface;
        this.b = new Logger("ErrorAnalysisModule");
        HttpConnection httpConnection = null;
        byte b = 0;
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        byte b5 = 0;
        byte b6 = 0;
        if (crashHandlerController == null) {
            int i = 4;
            DefaultConstructorMarker defaultConstructorMarker = null;
            crashHandlerController2 = new CrashHandlerController(new CrashEventReporter(libraryInterface, new CrashDataUploader(httpConnection, 1, b6 == true ? 1 : 0), null, i, defaultConstructorMarker), libraryInterface, 0 == true ? 1 : 0, i, defaultConstructorMarker);
        } else {
            crashHandlerController2 = crashHandlerController;
        }
        this.c = crashHandlerController2;
        NetworkEventUrlProcessor networkEventUrlProcessor = new NetworkEventUrlProcessor();
        NetworkEventCompressor networkEventCompressor = new NetworkEventCompressor();
        SymmetricCryptor symmetricCryptor = new SymmetricCryptor(b5 == true ? 1 : 0, b4 == true ? 1 : 0, 3, b3 == true ? 1 : 0);
        AsymmetricCryptor asymmetricCryptor = new AsymmetricCryptor(libraryInterface, b2 == true ? 1 : 0, 2, b == true ? 1 : 0);
        NetworkEventEncryptor networkEventEncryptor = new NetworkEventEncryptor(symmetricCryptor, asymmetricCryptor, libraryInterface);
        if (networkEventController == null) {
            networkEventController2 = new NetworkEventController(new NativeNetworkEventProcessorV1(networkEventUrlProcessor, new NetworkEventConfigurator(), new NetworkEventPIIAnonymizer(), networkEventCompressor, networkEventEncryptor, libraryInterface), new NativeNetworkEventProcessorV2(libraryInterface, asymmetricCryptor, symmetricCryptor, null, 8, null), new WebViewNetworkEventProcessor(networkEventUrlProcessor, networkEventCompressor, networkEventEncryptor), networkEventCounter == null ? new NetworkEventCounter() : networkEventCounter, libraryInterface, null, 32, null);
        } else {
            networkEventController2 = networkEventController;
        }
        this.d = networkEventController2;
    }

    public /* synthetic */ ErrorAnalysisModule(ErrorAnalysisLibraryInterface errorAnalysisLibraryInterface, CrashHandlerController crashHandlerController, NetworkEventController networkEventController, NetworkEventCounter networkEventCounter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(errorAnalysisLibraryInterface, (i & 2) != 0 ? null : crashHandlerController, (i & 4) != 0 ? null : networkEventController, (i & 8) != 0 ? null : networkEventCounter);
    }
}
