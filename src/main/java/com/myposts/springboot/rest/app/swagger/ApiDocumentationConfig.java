package com.myposts.springboot.rest.app.swagger;

import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(info = @Info(description = "My Posts App Resources", version = "1.0", title = "My Posts App Resource API", contact = @Contact(name = "Ranga Karanam", email = "amira.wst@gmail.com", url = ""), license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0")), consumes = {
		"application/json", "application/xml" }, produces = { "application/json",
				"application/xml" }, schemes = { SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS })
public interface ApiDocumentationConfig {

}
