package game;
import com.badlogic.gdx.math.Vector2;

/**
 * An object which will respond to forces.
 */
public interface PhysicsObject {
	
	/**
	 * Apply a force which will only translate the object.
	 * 
	 * @param	force	the force which will move the object.
	 */
	public void applyForce(Vector2 force);
	
	/**
	 * Apply a force which will translate and rotate the object.
	 * 
	 * @param	force	the force which will be applied at the point.
	 * @param	point	the point at which to apply the force relative to the world.
	 */
	public void appyForceAtWorldPoint(Vector2 force, Vector2 point);
	
	/**
	 * Apply a torque which will only rotate the object.
	 * 
	 * @param	torque	the amount of torque to apply, positive for CCW, negative for CW.
	 * @param	radius	the distance from the center of the object where the torque should be applied.
	 */
	public void applyTorque(float torque, float radius);
	
	/**
	 * Update the position and rotation of the object based on the time passed since last update.
	 * 
	 * @param	dT	the time difference between this and last update.
	 */
	public void update(float dT);
	
}
