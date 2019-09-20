package helicopterbattle;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ItemLife {
	
	 // For creating new items.
    private static final long timeBetweenNewItemLifesInit = Framework.secInNanosec * 30;
    public static long timeBetweenNewItemLifes = timeBetweenNewItemLifesInit;
    public static long timeOfLastCreatedItemLife = 0;
    
    // Health of the Item.
    public int health;

    // Position of the Item on the screen.
    public int xCoordinate;
    public int yCoordinate;
    
    // Moving speed and direction.
    private static final double movingXspeedInit = -2;
    private static double movingXspeed = movingXspeedInit;
    
    // Images of enemy helicopter. Images are loaded and set in Game class in LoadContent() method.
    public static BufferedImage itemLifeImg;
	private static int timeOfLastCreatedItemLifes;
	private static long timeBetweenNewLifeItems;
    
    public void Initialize(int xCoordinate, int yCoordinate)
    {
        
        // Sets enemy position.
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        
        // Initialize animation object.
               
        // Moving speed and direction of enemy.
        ItemLife.movingXspeed = -1;
    }
    
    /**
     * It sets speed and time between enemies to the initial properties.
     */
    public static void restartEnemy()
    {
    	ItemLife.timeBetweenNewItemLifes = timeBetweenNewItemLifesInit;
    	ItemLife.timeOfLastCreatedItemLifes = 0;
    	ItemLife.movingXspeed = movingXspeedInit;
    }
    
    
    /**
     * It increase enemy speed and decrease time between new enemies.
     */
    public static void speedUp()
    {
        if(ItemLife.timeBetweenNewLifeItems > Framework.secInNanosec)
        	ItemLife.timeBetweenNewLifeItems -= Framework.secInNanosec / 100;
        
        ItemLife.movingXspeed -= 0.1;
    }
    
    
    /**
     * Checks if the enemy is left the screen.
     * 
     * @return true if the enemy is left the screen, false otherwise.
     */
    public boolean isLeftScreen()
    {
        if(xCoordinate < 0 - itemLifeImg.getWidth()) // When the entire helicopter is out of the screen.
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
        
        g2d.drawImage(itemLifeImg, xCoordinate, yCoordinate, null);
        
    }
   
}


