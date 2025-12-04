package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes4.dex */
public class Extensions implements Model {
    private AppExtension app;
    private DeviceExtension device;
    private LocExtension loc;
    private MetadataExtension metadata;

    /* renamed from: net, reason: collision with root package name */
    private NetExtension f12net;
    private OsExtension os;
    private ProtocolExtension protocol;
    private SdkExtension sdk;
    private UserExtension user;

    public MetadataExtension getMetadata() {
        return this.metadata;
    }

    public void setMetadata(MetadataExtension metadataExtension) {
        this.metadata = metadataExtension;
    }

    public ProtocolExtension getProtocol() {
        return this.protocol;
    }

    public void setProtocol(ProtocolExtension protocolExtension) {
        this.protocol = protocolExtension;
    }

    public UserExtension getUser() {
        return this.user;
    }

    public void setUser(UserExtension userExtension) {
        this.user = userExtension;
    }

    public DeviceExtension getDevice() {
        return this.device;
    }

    public void setDevice(DeviceExtension deviceExtension) {
        this.device = deviceExtension;
    }

    public OsExtension getOs() {
        return this.os;
    }

    public void setOs(OsExtension osExtension) {
        this.os = osExtension;
    }

    public AppExtension getApp() {
        return this.app;
    }

    public void setApp(AppExtension appExtension) {
        this.app = appExtension;
    }

    public NetExtension getNet() {
        return this.f12net;
    }

    public void setNet(NetExtension netExtension) {
        this.f12net = netExtension;
    }

    public SdkExtension getSdk() {
        return this.sdk;
    }

    public void setSdk(SdkExtension sdkExtension) {
        this.sdk = sdkExtension;
    }

    public LocExtension getLoc() {
        return this.loc;
    }

    public void setLoc(LocExtension locExtension) {
        this.loc = locExtension;
    }

    @Override // com.microsoft.appcenter.ingestion.models.Model
    public void read(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("metadata")) {
            MetadataExtension metadataExtension = new MetadataExtension();
            metadataExtension.read(jSONObject.getJSONObject("metadata"));
            setMetadata(metadataExtension);
        }
        if (jSONObject.has("protocol")) {
            ProtocolExtension protocolExtension = new ProtocolExtension();
            protocolExtension.read(jSONObject.getJSONObject("protocol"));
            setProtocol(protocolExtension);
        }
        if (jSONObject.has(TCEventPropertiesNames.TCE_USER)) {
            UserExtension userExtension = new UserExtension();
            userExtension.read(jSONObject.getJSONObject(TCEventPropertiesNames.TCE_USER));
            setUser(userExtension);
        }
        if (jSONObject.has("device")) {
            DeviceExtension deviceExtension = new DeviceExtension();
            deviceExtension.read(jSONObject.getJSONObject("device"));
            setDevice(deviceExtension);
        }
        if (jSONObject.has("os")) {
            OsExtension osExtension = new OsExtension();
            osExtension.read(jSONObject.getJSONObject("os"));
            setOs(osExtension);
        }
        if (jSONObject.has(TCEventPropertiesNames.TCA_APP)) {
            AppExtension appExtension = new AppExtension();
            appExtension.read(jSONObject.getJSONObject(TCEventPropertiesNames.TCA_APP));
            setApp(appExtension);
        }
        if (jSONObject.has("net")) {
            NetExtension netExtension = new NetExtension();
            netExtension.read(jSONObject.getJSONObject("net"));
            setNet(netExtension);
        }
        if (jSONObject.has("sdk")) {
            SdkExtension sdkExtension = new SdkExtension();
            sdkExtension.read(jSONObject.getJSONObject("sdk"));
            setSdk(sdkExtension);
        }
        if (jSONObject.has("loc")) {
            LocExtension locExtension = new LocExtension();
            locExtension.read(jSONObject.getJSONObject("loc"));
            setLoc(locExtension);
        }
    }

    @Override // com.microsoft.appcenter.ingestion.models.Model
    public void write(JSONStringer jSONStringer) throws JSONException {
        if (getMetadata() != null) {
            jSONStringer.key("metadata").object();
            getMetadata().write(jSONStringer);
            jSONStringer.endObject();
        }
        if (getProtocol() != null) {
            jSONStringer.key("protocol").object();
            getProtocol().write(jSONStringer);
            jSONStringer.endObject();
        }
        if (getUser() != null) {
            jSONStringer.key(TCEventPropertiesNames.TCE_USER).object();
            getUser().write(jSONStringer);
            jSONStringer.endObject();
        }
        if (getDevice() != null) {
            jSONStringer.key("device").object();
            getDevice().write(jSONStringer);
            jSONStringer.endObject();
        }
        if (getOs() != null) {
            jSONStringer.key("os").object();
            getOs().write(jSONStringer);
            jSONStringer.endObject();
        }
        if (getApp() != null) {
            jSONStringer.key(TCEventPropertiesNames.TCA_APP).object();
            getApp().write(jSONStringer);
            jSONStringer.endObject();
        }
        if (getNet() != null) {
            jSONStringer.key("net").object();
            getNet().write(jSONStringer);
            jSONStringer.endObject();
        }
        if (getSdk() != null) {
            jSONStringer.key("sdk").object();
            getSdk().write(jSONStringer);
            jSONStringer.endObject();
        }
        if (getLoc() != null) {
            jSONStringer.key("loc").object();
            getLoc().write(jSONStringer);
            jSONStringer.endObject();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Extensions extensions = (Extensions) obj;
        MetadataExtension metadataExtension = this.metadata;
        if (metadataExtension == null ? extensions.metadata != null : !metadataExtension.equals(extensions.metadata)) {
            return false;
        }
        ProtocolExtension protocolExtension = this.protocol;
        if (protocolExtension == null ? extensions.protocol != null : !protocolExtension.equals(extensions.protocol)) {
            return false;
        }
        UserExtension userExtension = this.user;
        if (userExtension == null ? extensions.user != null : !userExtension.equals(extensions.user)) {
            return false;
        }
        DeviceExtension deviceExtension = this.device;
        if (deviceExtension == null ? extensions.device != null : !deviceExtension.equals(extensions.device)) {
            return false;
        }
        OsExtension osExtension = this.os;
        if (osExtension == null ? extensions.os != null : !osExtension.equals(extensions.os)) {
            return false;
        }
        AppExtension appExtension = this.app;
        if (appExtension == null ? extensions.app != null : !appExtension.equals(extensions.app)) {
            return false;
        }
        NetExtension netExtension = this.f12net;
        if (netExtension == null ? extensions.f12net != null : !netExtension.equals(extensions.f12net)) {
            return false;
        }
        SdkExtension sdkExtension = this.sdk;
        if (sdkExtension == null ? extensions.sdk != null : !sdkExtension.equals(extensions.sdk)) {
            return false;
        }
        LocExtension locExtension = this.loc;
        return locExtension != null ? locExtension.equals(extensions.loc) : extensions.loc == null;
    }

    public int hashCode() {
        MetadataExtension metadataExtension = this.metadata;
        int iHashCode = (metadataExtension != null ? metadataExtension.hashCode() : 0) * 31;
        ProtocolExtension protocolExtension = this.protocol;
        int iHashCode2 = (iHashCode + (protocolExtension != null ? protocolExtension.hashCode() : 0)) * 31;
        UserExtension userExtension = this.user;
        int iHashCode3 = (iHashCode2 + (userExtension != null ? userExtension.hashCode() : 0)) * 31;
        DeviceExtension deviceExtension = this.device;
        int iHashCode4 = (iHashCode3 + (deviceExtension != null ? deviceExtension.hashCode() : 0)) * 31;
        OsExtension osExtension = this.os;
        int iHashCode5 = (iHashCode4 + (osExtension != null ? osExtension.hashCode() : 0)) * 31;
        AppExtension appExtension = this.app;
        int iHashCode6 = (iHashCode5 + (appExtension != null ? appExtension.hashCode() : 0)) * 31;
        NetExtension netExtension = this.f12net;
        int iHashCode7 = (iHashCode6 + (netExtension != null ? netExtension.hashCode() : 0)) * 31;
        SdkExtension sdkExtension = this.sdk;
        int iHashCode8 = (iHashCode7 + (sdkExtension != null ? sdkExtension.hashCode() : 0)) * 31;
        LocExtension locExtension = this.loc;
        return iHashCode8 + (locExtension != null ? locExtension.hashCode() : 0);
    }
}
