import com.badlogic.gdx.math.Vector2;

/**
 * An object that moves by the specified amount in a frame
 */
public interface Movable {

	/*
	 * The distance which the object will move in the following frame
	 */
	public Vector2 getDistance();
	public void setDistance(float x, float y);
	
}
