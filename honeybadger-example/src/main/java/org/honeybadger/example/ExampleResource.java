package org.honeybadger.example;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.honeybadger.core.jaxrs.Resource;

/**
 * Created by rickt on 03-Sep-15.
 */
@Path("/example")
//@Api("/example")
public class ExampleResource implements Resource {

	@GET
//	@ApiOperation(value ="/", notes = "Hoi")
//	@ApiResponses(value = { @ApiResponse(code = 200, message ="Hoi", response = List.class)})
	public Response getExample() {
		return Response.ok().entity("Hoi").build();
	}
}
