package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AccountRecoverySettingType;
import com.amazonaws.services.cognitoidentityprovider.model.RecoveryOptionType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;
import java.util.List;

/* loaded from: classes2.dex */
class AccountRecoverySettingTypeJsonMarshaller {
    private static AccountRecoverySettingTypeJsonMarshaller instance;

    AccountRecoverySettingTypeJsonMarshaller() {
    }

    public void marshall(AccountRecoverySettingType accountRecoverySettingType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (accountRecoverySettingType.getRecoveryMechanisms() != null) {
            List<RecoveryOptionType> recoveryMechanisms = accountRecoverySettingType.getRecoveryMechanisms();
            awsJsonWriter.name("RecoveryMechanisms");
            awsJsonWriter.beginArray();
            for (RecoveryOptionType recoveryOptionType : recoveryMechanisms) {
                if (recoveryOptionType != null) {
                    RecoveryOptionTypeJsonMarshaller.getInstance().marshall(recoveryOptionType, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        awsJsonWriter.endObject();
    }

    public static AccountRecoverySettingTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new AccountRecoverySettingTypeJsonMarshaller();
        }
        return instance;
    }
}
