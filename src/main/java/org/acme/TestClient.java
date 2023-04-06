package org.acme;

import io.quarkus.oidc.client.reactive.filter.OidcClientRequestReactiveFilter;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/hello")
@RegisterRestClient(configKey = "test-client")
@RegisterProvider(OidcClientRequestReactiveFilter.class)
public interface TestClient {
    @GET
    Response callHello();
}
