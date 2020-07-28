package com.qaprosoft.carina.azure.api.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostUserMethod extends AbstractApiMethodV2 {
    public PostUserMethod() {
        super("api/users/_post/rq.json", null, "api/users/user.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("azure_api_url"));
    }
}
