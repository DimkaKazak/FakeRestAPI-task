package com.qaprosoft.carina.azure.api.photos;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class PutPhotoMethod extends AbstractApiMethodV2 {
    public PutPhotoMethod(Integer id) {
        super("api/photos/_put/rq.json", "api/photos/_put/rs.json", "api/photos/photo.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("azure_api_url"));
        replaceUrlPlaceholder("id", id.toString());
    }
}
