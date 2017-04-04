package game;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * A circular physics object. Responds to forces being applied, and will spin even though it is a circle. 
 */
public class PhysicsCircle extends Circle implements Movable, PhysicsObject {

	private static final long serialVersionUID = -3624036740726649306L;
	private float mass = 1;
	
	/**
	 * The moment of inertia of the circle.
	 */
	private float moment = 1;
	
	public Vector2 position = new Vector2();
	private Vector2 velocity = new Vector2();
	
	/**
	 * The angle of the object in radians.
	 */
	public float rotation = 0;
	
	/**
	 * The rate of rotation of the circle.
	 */
	private float omega = 0;
	
	/**
	 * A rough outline of the circle.
	 */
	private Rectangle hitbox = new Rectangle();
		
	public PhysicsCircle(Vector2 pos, float r, float mass) {
		this(pos.x, pos.y, r, mass);
	}
	
	public PhysicsCircle(float x, float y, float r, float mass) {
		super(x, y, r);
		this.mass = mass;
		this.moment = this.mass * r*r / 2;
		
		this.position.x = x;
		this.position.y = y;
		
		this.hitbox.width = 2*r;
		this.hitbox.height = 2*r;
		this.hitbox.x =  -r;
		this.hitbox.y = -r;
	}

	@Override
	public Vector2 getDistance(float dT) {
		return this.velocity.scl(dT);
	}

	@Override
	public void applyForce(Vector2 force) {
		Vector2 a = force.scl(1/this.mass);
		
		this.velocity.add(a);
	}

	@Override
	public void appyForceAtWorldPoint(Vector2 force, Vector2 point) {
		Vector2 localPoint = point.sub(this.position);
		
		float dot = force.dot(localPoint);
		float len2 = localPoint.len2();
		Vector2 along = localPoint.scl(dot / len2); //the force towards the center
		
		Vector2 normal = force.sub(along); //the force normal to the center
		float torqueLen = normal.len();
		float direction = localPoint.crs(normal);
		if (direction < 0) {
			torqueLen *= -1;
		}
		
		this.applyForce(along);
		this.applyTorque(torqueLen, localPoint.len());
	}

	@Override
	public void applyTorque(float torque, float radius) {
		float a = torque * radius / this.moment;
		
		this.omega += a;
	}

	@Override
	public void update(float dT) {
		this.position.add(this.velocity.scl(dT));
		this.rotation += this.omega * dT;
	}

	@Override
	public Rectangle hitbox() {
		return this.hitbox;
	}
	
	
	
}
