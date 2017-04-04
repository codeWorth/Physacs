import java.awt.Point;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class PhysicsCircle extends Circle implements Movable {

	private Vector2 distance = new Vector2();
	
	public double intersectTime(PhysicsCircle other) {
		//This circle's starting position is going to be (0,0)
		//This circle's path is this.distance
		//Other circle's path is other.distance
		//otherPos is the other circle's position
		
		/*<x1,y1> = t*distance
		 * <x2,y2> = t*other.distance + otherPos
		 * dx = td2 + x2 - x1
		 * dy = td2 + y2 - y1
		 * sqrt((x2-x1)^2 + (y2-y1)^2) = r
		 * (x2-x1)^2 + (y2-y1)^2 = r^2
		 * x2^2 - 2x1x2 + x1^2 + 
		 */
		
		Vector2 otherPos = new Vector2(other.x - this.x, other.y - this.y);
		float r = this.radius + other.radius;
	}

	@Override
	public Vector2 getDistance() {
		return distance;
	}

	@Override
	public void setDistance(float x, float y) {
		distance.x = x;
		distance.y = y;
	}
	
	
}
