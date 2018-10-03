package messenger.webapi.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("injectdemo")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class InjectDemoResource {


    @GET
    @Path("annotations")
    public String getParamUsingAnnotation (@MatrixParam("param") String matrixParam,
                                           @HeaderParam("customHeaderValue") String headerParam,
                                           @CookieParam("cookieName") String cookie
                                           /*@FormParam()*/) {
        return "MatrixParam: " + matrixParam + " Header param: " + headerParam + " Cookie param: " + cookie;
    }

    @GET
    @Path("context")
    public String getParamUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {

        return "Path: " + uriInfo.getAbsolutePath() + " HttpHeader cookies: " + headers.getCookies().toString();
    }
}
