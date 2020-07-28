package com.qaprosoft.carina.azure.api.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class DeleteUserMethod extends AbstractApiMethodV2 {

    public DeleteUserMethod(Integer id) {
        super(null, null, "api/users/user.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("azure_api_url"));
        replaceUrlPlaceholder("id", id.toString());
    }
}
