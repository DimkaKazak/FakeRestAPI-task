package com.qaprosoft.carina.azure.api.authors;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

 public class GetAuthorMethod extends AbstractApiMethodV2 {
     public GetAuthorMethod(Integer id) {
         super(null, null, new Properties());
         replaceUrlPlaceholder("base_url", Configuration.getEnvArg("azure_api_url"));
         replaceUrlPlaceholder("id", id.toString());
     }
 }
