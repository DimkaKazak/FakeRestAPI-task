package com.qaprosoft.carina.azure.api.authors;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetAuthorBookMethod extends AbstractApiMethodV2 {
    public GetAuthorBookMethod(Integer idBook) {
        super(null, null, new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("azure_api_url"));
        replaceUrlPlaceholder("idBook", idBook.toString());
    }
}
