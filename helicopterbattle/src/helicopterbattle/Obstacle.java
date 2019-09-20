package helicopterbattle;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Obstacle.
 * 
 * @author www.gametutorial.net
 */

public class Obstacle {
    
    // For creating new enemies.
    private static final long timeBetweenNewObstacleInit = Framework.secInNanosec * 10;
    public static long timeBetweenNewObstacle = timeBetweenNewObstacleInit;
    public static long timeOfLastCreatedObstacle = 0;
    
    // Health of the helicopter.
    public int health;
    
    // Position of the helicopter on the screen.
    public int xCoordinate;
    public int yCoordinate;
    
    // Moving speed and direction.
    private static final double movingXspeedInit = -4;
    private static double movingXspeed = movingXspeedInit;
    
    // Images of enemy bird. Images are loaded and set in Game class in LoadContent() method.
    public static BufferedImage birdImg;
   
    
    // Animation of the helicopter propeller.
   
    // Offset for the propeler. We add offset to the position of the position of helicopter.



    /**
     * Initialize obstacle.
     * 
     * @param xCoordinate Starting x coordinate of helicopter.
     * @param yCoordinate Starting y coordinate of helicopter.
     * @param helicopterBodyImg Image of helicopter body.
     * @param helicopterFrontPropellerAnimImg Image of front helicopter propeller.
     * @param helicopterRearPropellerAnimImg Image of rear helicopter propeller.
     */
    public void Initialize(int xCoordinate, int yCoordinate)
    {
        health = 100;
        
        // Sets enemy position.
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        
        // Initialize animation object.
               
        // Moving speed and direction of enemy.
        Obstacle.movingXspeed = -8;
    }
    
    /**
     * It sets speed and time between enemies to the initial properties.
     */
    public static void restartEnemy()
    {
        Obstacle.timeBetweenNewObstacle = timeBetweenNewObstacleInit;
        Obstacle.timeOfLastCreatedObstacle = 0;
        Obstacle.movingXspeed = movingXspeedInit;
    }
    
    
    /**
     * It increase enemy speed and decrease time between new enemies.
     */
    public static void speedUp()
    {
        if(Obstacle.timeBetweenNewObstacle > Framework.secInNanosec)
            Obstacle.timeBetweenNewObstacle -= Framework.secInNanosec / 100;
        
        Obstacle.movingXspeed -= 0.25;
    }
    
    
    /**
     * Checks if the enemy is left the screen.
     * 
     * @return true if the enemy is left the screen, false otherwise.
     */
    public boolean isLeftScreen()
    {
        if(xCoordinate < 0 - birdImg.getWidth()) // When the entire helicopter is out of the screen.
            return true;
        else
            return false;
    }
    
        
    /**
     * Updates position of helicopter, animations.
     */
    public void Update()
    {
        // Move enemy on x coordinate.
        xCoordinate += movingXspeed;
        
        // Moves helicoper propeler animations with helicopter.        
    }
    
    
    /**
     * Draws helicopter to the screen.
     * 
     * @param g2d Graphics2D
     */
    public void Draw(Graphics2D g2d)
    { 
        
        g2d.drawImage(birdImg, xCoordinate, yCoordinate,null);
        
    }
    
}
