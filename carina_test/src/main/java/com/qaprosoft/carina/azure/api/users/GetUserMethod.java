package com.qaprosoft.carina.azure.api.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetUserMethod extends AbstractApiMethodV2 {
    public GetUserMethod(Integer id) {
        super(null, null, new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("azure_api_url"));
        replaceUrlPlaceholder("id", id.toString());
    }
}
