package com.qaprosoft.carina.azure.api.activities;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostActivityMethod extends AbstractApiMethodV2 {
    public PostActivityMethod() {
        super("api/activities/_post/rq.json", null, "api/activities/activity.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("azure_api_url"));
    }
}
