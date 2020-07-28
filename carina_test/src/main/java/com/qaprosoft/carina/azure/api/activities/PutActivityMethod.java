package com.qaprosoft.carina.azure.api.activities;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class PutActivityMethod extends AbstractApiMethodV2 {
    public PutActivityMethod(Integer id) {
        super("api/activities/_put/rq.json", "api/activities/_put/rs.json", "api/activities/activity.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("azure_api_url"));
        replaceUrlPlaceholder("id", id.toString());
    }
}
