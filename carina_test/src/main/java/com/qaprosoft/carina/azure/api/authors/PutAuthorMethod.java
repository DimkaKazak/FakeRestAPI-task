package com.qaprosoft.carina.azure.api.authors;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class PutAuthorMethod extends AbstractApiMethodV2 {
    public PutAuthorMethod(Integer id) {
        super("api/authors/_put/rq.json", "api/authors/_put/rs.json", "api/authors/author.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("azure_api_url"));
        replaceUrlPlaceholder("id", id.toString());
    }
}
