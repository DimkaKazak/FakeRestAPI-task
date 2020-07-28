package com.qaprosoft.carina.azure.api.authors;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostAuthorMethod extends AbstractApiMethodV2 {
    public PostAuthorMethod() {
        super("api/authors/_post/rq.json", null, "api/authors/author.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("azure_api_url"));
    }
}
