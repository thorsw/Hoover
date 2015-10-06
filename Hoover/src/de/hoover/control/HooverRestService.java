package de.hoover.control;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.hoover.Hoover;
import de.hoover.HooverFactory;

@Path("/")
public class HooverRestService {

	private static Hoover hoover = HooverFactory.createHoover();

	@GET
	@Path("forward")
	@Produces({ MediaType.TEXT_PLAIN })
	public String forward() {
		hoover.forward();
		return "success";
	}

	@GET
	@Path("backward")
	@Produces({ MediaType.TEXT_PLAIN })
	public String backward() {
		hoover.backward();
		return "success";
	}

	@GET
	@Path("stop")
	@Produces({ MediaType.TEXT_PLAIN })
	public String stop() {
		hoover.stop();
		return "success";
	}

	@GET
	@Path("leftForward")
	@Produces({ MediaType.TEXT_PLAIN })
	public String leftforward() {
		hoover.leftForward();
		return "success";
	}

	@GET
	@Path("rightForward")
	@Produces({ MediaType.TEXT_PLAIN })
	public String rightForward() {
		hoover.rightForward();
		return "success";
	}

	@GET
	@Path("leftBackward")
	@Produces({ MediaType.TEXT_PLAIN })
	public String left() {
		hoover.leftBackward();
		return "success";
	}

	@GET
	@Path("rightBackward")
	@Produces({ MediaType.TEXT_PLAIN })
	public String right() {
		hoover.rightBackward();
		return "success";
	}

	@GET
	@Path("rotateLeft")
	@Produces({ MediaType.TEXT_PLAIN })
	public String rotateLeft() {
		hoover.rotateLeft();
		return "success";
	}

	@GET
	@Path("rotateRight")
	@Produces({ MediaType.TEXT_PLAIN })
	public String rotateRight() {
		hoover.rotateRight();
		return "success";
	}

}
