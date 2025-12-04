package com.amazonaws.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public class LegacyErrorUnmarshaller implements Unmarshaller<AmazonServiceException, Node> {
    private final Class exceptionClass;

    public LegacyErrorUnmarshaller() {
        this(AmazonServiceException.class);
    }

    protected LegacyErrorUnmarshaller(Class<? extends AmazonServiceException> cls) {
        this.exceptionClass = cls;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(Node node) throws Exception {
        String errorCode = parseErrorCode(node);
        String strAsString = XpathUtils.asString("Response/Errors/Error/Message", node);
        String strAsString2 = XpathUtils.asString("Response/RequestID", node);
        String strAsString3 = XpathUtils.asString("Response/Errors/Error/Type", node);
        AmazonServiceException amazonServiceException = (AmazonServiceException) this.exceptionClass.getConstructor(String.class).newInstance(strAsString);
        amazonServiceException.setErrorCode(errorCode);
        amazonServiceException.setRequestId(strAsString2);
        if (strAsString3 == null) {
            amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Unknown);
        } else if ("server".equalsIgnoreCase(strAsString3)) {
            amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Service);
        } else if ("client".equalsIgnoreCase(strAsString3)) {
            amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Client);
        }
        return amazonServiceException;
    }

    public String parseErrorCode(Node node) throws Exception {
        return XpathUtils.asString("Response/Errors/Error/Code", node);
    }

    public String getErrorPropertyPath(String str) {
        return "Response/Errors/Error/" + str;
    }
}
