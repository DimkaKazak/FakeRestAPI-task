package com.qaprosoft.carina.azure.api.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class PutUserMethod extends AbstractApiMethodV2 {
    public PutUserMethod(Integer id) {
        super("api/users/_put/rq.json", "api/users/_put/rs.json", "api/users/user.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("azure_api_url"));
        replaceUrlPlaceholder("id", id.toString());
    }
}
