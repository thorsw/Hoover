package de.hoover.control;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.hoover.Hoover;
import de.hoover.HooverFactory;

@Path("/")
public class HooverRestService {

	private static Hoover hoover;

	private static Hoover getHoover() {
		if (hoover == null) {
			hoover = HooverFactory.createHoover();
		}
		return hoover;
	}

	@GET
	@Path("forward")
	@Produces({ MediaType.TEXT_PLAIN })
	public String forward() {
		getHoover().forward();
		return "success";
	}

	@GET
	@Path("backward")
	@Produces({ MediaType.TEXT_PLAIN })
	public String backward() {
		getHoover().backward();
		return "success";
	}

	@GET
	@Path("stop")
	@Produces({ MediaType.TEXT_PLAIN })
	public String stop() {
		getHoover().stop();
		return "success";
	}

	@GET
	@Path("leftForward")
	@Produces({ MediaType.TEXT_PLAIN })
	public String leftforward() {
		getHoover().leftForward();
		return "success";
	}

	@GET
	@Path("rightForward")
	@Produces({ MediaType.TEXT_PLAIN })
	public String rightForward() {
		getHoover().rightForward();
		return "success";
	}

	@GET
	@Path("leftBackward")
	@Produces({ MediaType.TEXT_PLAIN })
	public String left() {
		getHoover().leftBackward();
		return "success";
	}

	@GET
	@Path("rightBackward")
	@Produces({ MediaType.TEXT_PLAIN })
	public String right() {
		getHoover().rightBackward();
		return "success";
	}

	@GET
	@Path("rotateLeft")
	@Produces({ MediaType.TEXT_PLAIN })
	public String rotateLeft() {
		getHoover().rotateLeft();
		return "success";
	}

	@GET
	@Path("rotateRight")
	@Produces({ MediaType.TEXT_PLAIN })
	public String rotateRight() {
		getHoover().rotateRight();
		return "success";
	}

}
