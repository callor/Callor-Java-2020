package helicopterbattle;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * Helicopter machine gun bullet.
 * 
 * @author www.gametutorial.net
 */

public class EnemyBullet {
    
    // For creating new bullets.
    public final static long timeBetweenNewBullets = Framework.secInNanosec / 1;
    public static long timeOfLastCreatedBullet = 0;
    
   /* // Damage that is made to an enemy helicopter when it is hit with a bullet.
    public static int damagePower = 20;*/
    
    // Position of the bullet on the screen. Must be of type double because movingXspeed and movingYspeed will not be a whole number.
    public double xCoordinate;
    public double yCoordinate;
    
    // Moving speed and direction.
    private static int bulletSpeed = 20;
    private double movingXspeed;
    private double movingYspeed;
    
    // Images of helicopter machine gun bullet. Image is loaded and set in Game class in LoadContent() method.
    public static BufferedImage enemybulletImg;
    public BufferedImage nowBullet[] = new BufferedImage[20];
    
    //for remove Image
	public BufferedImage noImage;
    
	
	
    /**
     * Creates new machine gun bullet.
     * 
     * @param xCoordinate From which x coordinate was bullet fired?
     * @param yCoordinate From which y coordinate was bullet fired?
     * @param mousePosition Position of the mouse at the time of the shot.
     */
    public EnemyBullet(int xCoordinate, int yCoordinate)
    {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        
        setDirectionAndSpeed();
    }
    public EnemyBullet() {
    	
    }
    
    /**
     * Calculate the speed on a x and y coordinate.
     * 
     * @param mousePosition 
     */
    private void setDirectionAndSpeed()
    {
        // Unit direction vector of the bullet.
        double directionVx = this.xCoordinate;
        double directionVy = this.yCoordinate;
        double lengthOfVector = Math.sqrt(directionVx * directionVx + directionVy * directionVy);
        directionVx = directionVx / lengthOfVector; // Unit vector
        directionVy = directionVy / lengthOfVector; // Unit vector
        
        // Set speed.
        this.movingXspeed = bulletSpeed;
        this.movingYspeed = bulletSpeed;
    }    
    /**
     * Checks if the bullet is left the screen.
     * 
     * @return true if the bullet left the screen, false otherwise.
     */
    public boolean isItLeftScreen()
    {
        if(xCoordinate > 0 && xCoordinate < Framework.frameWidth &&
           yCoordinate > 0 && yCoordinate < Framework.frameHeight)
            return false;
        else
            return true;
    }    
    /**
     * Moves the bullet.
     */
    public void Update()
    {
        xCoordinate -= movingXspeed;
        //yCoordinate -= movingYspeed;
      
    }    
    /**
     * Draws the bullet to the screen.
     * 
     * @param g2d Graphics2D
     */
    public void Draw(Graphics2D g2d)
    {
        g2d.drawImage(enemybulletImg, (int)xCoordinate, (int)yCoordinate, null);
    }
}
