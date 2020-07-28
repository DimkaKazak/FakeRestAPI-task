package com.qaprosoft.carina.azure.api.photos;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostPhotoMethod extends AbstractApiMethodV2 {
    public PostPhotoMethod() {
        super("api/photos/_post/rq.json", null, "api/photos/photo.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("azure_api_url"));
    }
}
