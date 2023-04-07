package org.acme;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.oidc.server.OidcWiremockTestResource;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@QuarkusTestResource(OidcWiremockTestResource.class)
class ClientTest {

    @Inject
    @RestClient
    TestClient testClient;

    @Test
    void testTokenFailure() {
            Response response = testClient.callHello(); //This should fail

                //Given an existing valid realm
                //And a failure on token creation (wrong credentials etc.)
                //When we call the testClient
                //Then Actual url NEVER been called (correct)
 //THE PROBLEM: //BUT We get valid Response (not failure) with status code = 0 (WRONG STATE)

 //--------------------------------------
 //Expected:    //Instead the testClient should fail with an Exception

            System.out.println("Status code: " + response.getStatus()); //Gives 0
    }
}
