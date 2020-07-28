package com.qaprosoft.carina.azure.api.authors;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetAuthorsMethod extends AbstractApiMethodV2 {
    public GetAuthorsMethod() {
        super(null, null, new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("azure_api_url"));
    }
}
