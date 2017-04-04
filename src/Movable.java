import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * An object that moves by the specified amount in a frame.
 */
public interface Movable {

	/**
	 * The distance which the object will move in the following frame.
	 * 
	 * @param	dT	the time between this and last frame
	 * @return		the delta between the object's current and projected positions
	 * @see			Vector2
	 */
	public Vector2 getDistance(float dT);
	
	/**
	 * The rough hitbox of the object. 
	 * Usually should not be used for collision detection.
	 * 
	 * @return		the rough hitbox which represents the object.
	 */
	public Rectangle hitbox();
	
}
