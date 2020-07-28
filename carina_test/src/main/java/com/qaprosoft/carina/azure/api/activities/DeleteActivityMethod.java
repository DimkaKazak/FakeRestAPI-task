package com.qaprosoft.carina.azure.api.activities;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class DeleteActivityMethod extends AbstractApiMethodV2 {

    public DeleteActivityMethod(Integer id) {
        super(null, null, "api/activities/activity.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("azure_api_url"));
        replaceUrlPlaceholder("id", id.toString());
    }
}
