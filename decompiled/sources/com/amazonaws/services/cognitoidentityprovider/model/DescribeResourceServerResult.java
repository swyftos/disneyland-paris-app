package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class DescribeResourceServerResult implements Serializable {
    private ResourceServerType resourceServer;

    public ResourceServerType getResourceServer() {
        return this.resourceServer;
    }

    public void setResourceServer(ResourceServerType resourceServerType) {
        this.resourceServer = resourceServerType;
    }

    public DescribeResourceServerResult withResourceServer(ResourceServerType resourceServerType) {
        this.resourceServer = resourceServerType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getResourceServer() != null) {
            sb.append("ResourceServer: " + getResourceServer());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getResourceServer() == null ? 0 : getResourceServer().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeResourceServerResult)) {
            return false;
        }
        DescribeResourceServerResult describeResourceServerResult = (DescribeResourceServerResult) obj;
        if ((describeResourceServerResult.getResourceServer() == null) ^ (getResourceServer() == null)) {
            return false;
        }
        return describeResourceServerResult.getResourceServer() == null || describeResourceServerResult.getResourceServer().equals(getResourceServer());
    }
}
