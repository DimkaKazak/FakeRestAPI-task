package com.qaprosoft.carina.azure.api.photos;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetCoverBookMethod extends AbstractApiMethodV2 {
    public GetCoverBookMethod(Integer idBook) {
        super(null, null, new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("azure_api_url"));
        replaceUrlPlaceholder("idBook", idBook.toString());
    }
}
