package com.qaprosoft.carina.azure.api.activities;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetActivitiesMethod extends AbstractApiMethodV2 {
    public GetActivitiesMethod() {
        super(null, null, new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("azure_api_url"));
    }
}
