package com.qaprosoft.carina.azure.api.photos;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class DeletePhotoMethod extends AbstractApiMethodV2 {

    public DeletePhotoMethod(Integer id) {
        super(null, null, "api/photos/photo.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("azure_api_url"));
        replaceUrlPlaceholder("id", id.toString());
    }
}
