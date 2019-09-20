package helicopterbattle;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Actual game.
 * 
 * @author www.gametutorial.net
 */

public class Game {

	// Use this to generate a random number.
	private Random random;

	// We will use this for seting mouse position.
	private Robot robot;

	// Player - helicopter that is managed by player.
	private PlayerHelicopter player;

	// Enemy helicopters.
	private ArrayList<EnemyHelicopter> enemyHelicopterList = new ArrayList<EnemyHelicopter>();

	// Obstacle
	private ArrayList<Obstacle> obstacleList = new ArrayList<Obstacle>();

	// Boss,King
	private ArrayList<Boss> bossList = new ArrayList<Boss>();
	private ArrayList<Boss2> boss2List = new ArrayList<Boss2>();
	private ArrayList<King> kingList = new ArrayList<King>();

	// Items
	private ArrayList<ItemLife> itemLifeList = new ArrayList<ItemLife>();
	private ItemLife itemLife;

	// Explosions
	private ArrayList<Animation> explosionsList;
	private BufferedImage explosionAnimImg;

	// List of all the machine gun bullets.
	private ArrayList<Bullet> bulletsList;
	private ArrayList<EnemyBullet> enemybulletsList;
	
	// List of all the rockets.
	private ArrayList<Rocket> rocketsList;
	// List of all the rockets smoke.
	private ArrayList<RocketSmoke> rocketSmokeList;

	// Objects of moving images.
	private MovingBackground cloudLayer1Moving;
	private MovingBackground cloudLayer2Moving;
	private MovingBackground mountainsMoving;
	private MovingBackground groundMoving;

	// Font that we will use to write statistic to the screen.
	private Font font;

	// Statistics (destroyed enemies, run away enemies)
	private int runAwayEnemies;
	private int destroyedEnemies;
	private int Life;
	static int stage;
	static int difficult;
	private static boolean canSetStage = true;

	private int countOfAmmo;
	private boolean canReload;
	private static boolean canShootNow = true;

	private Sound sound;

	private loadGameContents gameContents = new loadGameContents();
	public Game() {
		Framework.gameState = Framework.GameState.GAME_CONTENT_LOADING;
		gameContents.loadContent();
		Thread threadForInitGame = new Thread() {
			@Override
			public void run() {
				// Sets variables and objects for the game.
				Initialize();
				// Load game files (images, sounds, ...)
				LoadContent();

				Framework.gameState = Framework.GameState.PLAYING;
			}
		};
		threadForInitGame.start();
		
	}

	/**
	 * Set variables and objects for the game.
	 */
	private void Initialize() {
		random = new Random();

		try {
			robot = new Robot();
		} catch (AWTException ex) {
			Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
		}

		player = new PlayerHelicopter(Framework.frameWidth / 4, Framework.frameHeight / 4);

		enemyHelicopterList = new ArrayList<EnemyHelicopter>();

		obstacleList = new ArrayList<Obstacle>();

		explosionsList = new ArrayList<Animation>();

		bulletsList = new ArrayList<Bullet>();

		enemybulletsList = new ArrayList<EnemyBullet>();
		
		rocketsList = new ArrayList<Rocket>();
		rocketSmokeList = new ArrayList<RocketSmoke>();

		// Moving images.
		cloudLayer1Moving = new MovingBackground();
		cloudLayer2Moving = new MovingBackground();
		mountainsMoving = new MovingBackground();
		groundMoving = new MovingBackground();

		font = new Font("monospaced", Font.BOLD, 18);
		
		
		Life = 10;
		stage = 0;
		difficult = 5;
		runAwayEnemies = 0;
		destroyedEnemies = 0;

		countOfAmmo = 20;
		canReload = true;

		sound = new Sound();

	}
	
	/**
	 * Load game files (images).
	 */
	private void LoadContent() {
			sound.backgroundSound();
		// Now that we have images we initialize moving images.
		cloudLayer1Moving.Initialize(gameContents.getCloudLayer1Img(), -6, 0);
		cloudLayer2Moving.Initialize(gameContents.getCloudLayer2Img(), -2, 0);
		mountainsMoving.Initialize(gameContents.getMountainsImg(), -1,
				Framework.frameHeight - gameContents.getGroundImg().getHeight() - gameContents.getMountainsImg().getHeight() + 40);
		groundMoving.Initialize(gameContents.getGroundImg(), -1.2, Framework.frameHeight - gameContents.getGroundImg().getHeight());
	}

	/**
	 * Restart game - reset some variables.
	 */
	public void RestartGame() {
		stage = 0;
		countOfAmmo = 20;
		DrawCurrentBullet();

		player.Reset(Framework.frameWidth / 4, Framework.frameHeight / 4);

		EnemyHelicopter.restartEnemy();

		Bullet.timeOfLastCreatedBullet = 0;
		Rocket.timeOfLastCreatedRocket = 0;

		// Empty all the lists.
		enemyHelicopterList.clear();
		obstacleList.clear();
		bulletsList.clear();
		enemybulletsList.clear();
		rocketsList.clear();
		rocketSmokeList.clear();
		explosionsList.clear();
		itemLifeList.clear();
		bossList.clear();
		boss2List.clear();
		kingList.clear();

		// Statistics
		Life = 10;
		runAwayEnemies = 0;
		destroyedEnemies = 0;
	}

	/**
	 * Update game logic.
	 * 
	 * @param gameTime
	 *            The elapsed game time in nanoseconds.
	 * @param mousePosition
	 *            current mouse position.
	 */
	public void UpdateGame(long gameTime, Point mousePosition) {
		/* Player */
		// When player is destroyed and all explosions are finished showing we change
		// game status.
		if (!isPlayerAlive() && explosionsList.isEmpty()) {
			Framework.gameState = Framework.GameState.GAMEOVER;
			return; // If player is destroyed, we don't need to do thing below.
		}
		if (Life <= 0) {
			Framework.gameState = Framework.GameState.GAMEOVER;
		}
		// When a player is out of rockets and machine gun bullets, and all lists
		// of bullets, rockets and explosions are empyt(end showing) we finish the game.
		if (player.numberOfAmmo <= 0 && player.numberOfRockets <= 0 && bulletsList.isEmpty() && rocketsList.isEmpty()
				&& explosionsList.isEmpty()) {
			Framework.gameState = Framework.GameState.GAMEOVER;
			return;
		}
		// If player is alive we update him.
		if (isPlayerAlive()) {
			isPlayerShooting(gameTime, mousePosition);
			isEnemyShooting(gameTime);
			didPlayerFiredRocket(gameTime);
			player.isMoving();
			player.Update();
		}

		/* Mouse */
		limitMousePosition(mousePosition);

		/* Bullets */
		updateBullets();
		updateEnemyBullets();
		
		/* Rockets */
		updateRockets(gameTime); // It also checks for collisions (if any of the rockets hit any of the enemy
									// helicopter).
		updateRocketSmoke(gameTime);

		/* Enemies */
		createEnemyHelicopter(gameTime);
		updateEnemies();

		/* obstacle */
		createObstacle(gameTime);
		updateObstacles();

		if (destroyedEnemies >= 5) {
			createBoss(gameTime);
			updateBoss();
		}
		if (destroyedEnemies >= 10) {
			createBoss2(gameTime);
			updateBoss2();
		}
		if (destroyedEnemies >= 20) {
			createKing(gameTime);
			updateKing();
		}

		/* Item Life */
		createItemLife(gameTime);
		updateItemLife();

		/* Explosions */
		updateExplosions();
	}

	// Image for current Bullet
	public void DrawCurrentBullet() {

		if (countOfAmmo > 10) {
			for (int i = 0; i < 10; i++)
				g2d2.drawImage(Bullet.nowBullet, 10 + (10 * i), 120, 10, 20, null);

			for (int i = 0; i < 10 - (20 - countOfAmmo); i++)
				g2d2.drawImage(Bullet.nowBullet, 10 + (10 * i), 140, 10, 20, null);
		}
		else {
			for (int i = 0; i < countOfAmmo; i++)
				g2d2.drawImage(Bullet.nowBullet, 10 + (10 * i), 120, 10, 20, null);
		}
	}
	/**
	 * Draw the game to the screen.
	 * 
	 * @param g2d
	 *            Graphics2D
	 * @param mousePosition
	 *            current mouse position.
	 */
	Graphics2D g2d2;

	public void Draw(Graphics2D g2d, Point mousePosition, long gameTime) {
		g2d2 = g2d;

		// Image for background sky color.
		g2d.drawImage(gameContents.getSkyColorImg(), 0, 0, Framework.frameWidth, Framework.frameHeight, null);

		// Image for Bullet in Ammo
		DrawCurrentBullet();

		// Moving images.
		mountainsMoving.Draw(g2d);
		groundMoving.Draw(g2d);
		cloudLayer2Moving.Draw(g2d);

		if (isPlayerAlive())
			player.Draw(g2d);

		// Draws all the enemies.
		for (int i = 0; i < enemyHelicopterList.size(); i++) {
			enemyHelicopterList.get(i).Draw(g2d);
			g2d.drawImage(enemyHelicopterList.get(i).helicopterBodyImg, enemyHelicopterList.get(i).xCoordinate,
					enemyHelicopterList.get(i).yCoordinate,
					enemyHelicopterList.get(i).helicopterBodyImg.getWidth() - ((stage - 1) * difficult * 2),
					enemyHelicopterList.get(i).helicopterBodyImg.getHeight() - ((stage - 1) * difficult), null);
		}

		// Draws all the obstacles.
		for (int i = 0; i < obstacleList.size(); i++) {
			obstacleList.get(i).Draw(g2d);
		}

		// Draws all the items
		for (int i = 0; i < itemLifeList.size(); i++) {
			itemLifeList.get(i).Draw(g2d);
		}

		// Draws all the bullets.
		for (int i = 0; i < bulletsList.size(); i++) {
			bulletsList.get(i).Draw(g2d);
		}
		
		for (int i = 0; i < enemybulletsList.size(); i++) {
			enemybulletsList.get(i).Draw(g2d);
		}

		// Draws all the rockets.
		for (int i = 0; i < rocketsList.size(); i++) {
			rocketsList.get(i).Draw(g2d);
		}
		// Draws smoke of all the rockets.
		for (int i = 0; i < rocketSmokeList.size(); i++) {
			rocketSmokeList.get(i).Draw(g2d);
		}

		// Draw all explosions.
		for (int i = 0; i < explosionsList.size(); i++) {
			explosionsList.get(i).Draw(g2d);
		}

		for (int i = 0; i < bossList.size(); i++) {
			bossList.get(i).Draw(g2d);
		}
		for (int i = 0; i < boss2List.size(); i++) {
			boss2List.get(i).Draw(g2d);
		}
		for (int i = 0; i < kingList.size(); i++) {
			kingList.get(i).Draw(g2d);
		}

		// Draw statistics
		g2d.setFont(font);
		g2d.setColor(Color.darkGray);

		g2d.drawString(formatTime(gameTime), Framework.frameWidth / 2 - 45, 21);
		g2d.drawString("DESTROYED: " + destroyedEnemies, 10, 21);
		g2d.drawString("RUNAWAY: " + runAwayEnemies, 10, 41);
		g2d.drawString("LIFE: " + Life, 10, 61);
		g2d.drawString("ROCKETS: " + player.numberOfRockets, 10, 81);
		g2d.drawString("AMMO: " + player.numberOfAmmo, 10, 101);
		g2d.setColor(Color.WHITE);
		g2d.drawString("STAGE: " + stage, Framework.frameWidth / 2 - 50, 40);

		// Moving images. We draw this cloud in front of the helicopter.
		cloudLayer1Moving.Draw(g2d);

		// Mouse cursor
		if (isPlayerAlive())
			drawRotatedMouseCursor(g2d, mousePosition);
	}

	/**
	 * Draws some game statistics when game is over.
	 * 
	 * @param g2d
	 *            Graphics2D
	 * @param gameTime
	 *            Elapsed game time.
	 */
	public void DrawStatistic(Graphics2D g2d, long gameTime) {
		g2d.drawString("Time: " + formatTime(gameTime), Framework.frameWidth / 2 - 50, Framework.frameHeight / 3 + 80);
		g2d.drawString("Rockets left: " + player.numberOfRockets, Framework.frameWidth / 2 - 55,
				Framework.frameHeight / 3 + 105);
		g2d.drawString("Ammo left: " + player.numberOfAmmo, Framework.frameWidth / 2 - 55,
				Framework.frameHeight / 3 + 125);
		g2d.drawString("Destroyed enemies: " + destroyedEnemies, Framework.frameWidth / 2 - 65,
				Framework.frameHeight / 3 + 150);
		g2d.drawString("Runaway enemies: " + runAwayEnemies, Framework.frameWidth / 2 - 65,
				Framework.frameHeight / 3 + 170);
		g2d.setFont(font);
		g2d.drawString("Statistics: ", Framework.frameWidth / 2 - 75, Framework.frameHeight / 3 + 60);
	}

	/**
	 * Draws rotated mouse cursor. It rotates the cursor image on the basis of the
	 * player helicopter machine gun.
	 * 
	 * @param g2d
	 *            Graphics2D
	 * @param mousePosition
	 *            Position of the mouse.
	 */
	private void drawRotatedMouseCursor(Graphics2D g2d, Point mousePosition) {
		double RIGHT_ANGLE_RADIANS = Math.PI / 2;

		// Positon of the player helicopter machine gun.
		int pivotX = player.machineGunXcoordinate;
		int pivotY = player.machineGunYcoordinate;

		int a = pivotX - mousePosition.x;
		int b = pivotY - mousePosition.y;
		double ab = (double) a / (double) b;
		double alfaAngleRadians = Math.atan(ab);

		if (mousePosition.y < pivotY) // Above the helicopter.
			alfaAngleRadians = RIGHT_ANGLE_RADIANS - alfaAngleRadians - RIGHT_ANGLE_RADIANS * 2;
		else if (mousePosition.y > pivotY) // Under the helicopter.
			alfaAngleRadians = RIGHT_ANGLE_RADIANS - alfaAngleRadians;
		else
			alfaAngleRadians = 0;

		AffineTransform origXform = g2d.getTransform();
		AffineTransform newXform = (AffineTransform) (origXform.clone());

		newXform.rotate(alfaAngleRadians, mousePosition.x, mousePosition.y);
		g2d.setTransform(newXform);

		g2d.drawImage(gameContents.getMouseCursorImg(), mousePosition.x, mousePosition.y - gameContents.getMouseCursorImg().getHeight() / 2, null);
		// We substract half of the cursor image so that will be drawn in
		// center of the y mouse coordinate.

		g2d.setTransform(origXform);
	}

	/**
	 * Format given time into 00:00 format.
	 * 
	 * @param time
	 *            Time that is in nanoseconds.
	 * @return Time in 00:00 format.
	 */

	private static String formatTime(long time) {
		// Given time in seconds.
		int sec = (int) (time / Framework.milisecInNanosec / 1000);
		
		// Given time in minutes and seconds.
		int min = sec / 60;
		sec = sec - (min * 60);

		String minString;
		String secString;

		if (min <= 9)
			minString = "0" + Integer.toString(min);
		else
			minString = "" + Integer.toString(min);

		if (sec <= 9)
			secString = "0" + Integer.toString(sec);
		else
			secString = "" + Integer.toString(sec);

		if ((sec % 10) == 0 && canSetStage == true && stage < 10) {
			canSetStage = false;
			stage++;
		}
		if ((sec % 10) == 1)
			canSetStage = true;

		return minString + ":" + secString;
	}

	/*
	 * 
	 * Methods for updating the game.
	 * 
	 */

	/**
	 * Check if player is alive. If not, set game over status.
	 * 
	 * @return True if player is alive, false otherwise.
	 */
	private boolean isPlayerAlive() {
		if (player.health <= 0)
			return false;

		return true;
	}

	/**
	 * Checks if the player is shooting with the machine gun and creates bullets if
	 * he shooting.
	 * 
	 * @param gameTime
	 *            Game time.
	 */
	private void isPlayerShooting(long gameTime, Point mousePosition) {
		if (player.isShooting(gameTime) && countOfAmmo > 0 && canShootNow) {
			Bullet.timeOfLastCreatedBullet = gameTime;
			sound.fireSound();
			player.numberOfAmmo--;
			Bullet b = new Bullet(player.machineGunXcoordinate, player.machineGunYcoordinate, mousePosition);
			bulletsList.add(b);

			countOfAmmo--;
			if (countOfAmmo == 0)
				sound.lastShot();
		}
	}
	
	private void isEnemyShooting(long gameTime) {
		for (int i = 0; i < enemyHelicopterList.size(); i++) {
			EnemyHelicopter eh = enemyHelicopterList.get(i);
			
			if (eh.isEnemyShooting(gameTime)) {
				EnemyBullet.timeOfLastCreatedBullet = gameTime;
				sound.fireSound();
			
				EnemyBullet eb = new EnemyBullet(eh.xCoordinate, eh.yCoordinate + eh.machineGunYcoordinate - ((stage - 1) * difficult));
				enemybulletsList.add(eb);
			}
		}
		
	}

	// canShootNow false >> true for reload
	
	private void reloadBullet() {
		if (Canvas.keyboardKeyState(KeyEvent.VK_R) && canReload == true) {
			canReload = false;
			sound.reloadSound();
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						canShootNow = false;
						Thread.sleep(2000);
						countOfAmmo = 20;
						DrawCurrentBullet();
						canShootNow = true;
						canReload = true;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}

	/**
	 * Checks if the player is fired the rocket and creates it if he did. It also
	 * checks if player can fire the rocket.
	 * 
	 * @param gameTime
	 *            Game time.
	 */

	private void didPlayerFiredRocket(long gameTime) {
		if (player.isFiredRocket(gameTime)) {
			sound.rocketSound();
			Rocket.timeOfLastCreatedRocket = gameTime;
			player.numberOfRockets--;

			Rocket r = new Rocket();
			r.Initialize(player.rocketHolderXcoordinate, player.rocketHolderYcoordinate);
			rocketsList.add(r);
		}
	}

	/**
	 * Creates a new enemy if it's time.
	 * 
	 * @param gameTime
	 *            Game time.
	 */
	private void createEnemyHelicopter(long gameTime) {
		if (gameTime - EnemyHelicopter.timeOfLastCreatedEnemy >= EnemyHelicopter.timeBetweenNewEnemies) {
			EnemyHelicopter eh = new EnemyHelicopter();
			int xCoordinate = Framework.frameWidth;
			int yCoordinate = random.nextInt(Framework.frameHeight - EnemyHelicopter.helicopterBodyImg.getHeight());
			eh.Initialize(xCoordinate, yCoordinate);
			// Add created enemy to the list of enemies.
			enemyHelicopterList.add(eh);

			// Speed up enemy speed and aperence.
			EnemyHelicopter.speedUp();

			// Sets new time for last created enemy.
			EnemyHelicopter.timeOfLastCreatedEnemy = gameTime;
		}
	}

	private void createObstacle(long gameTime) {
		if (gameTime - Obstacle.timeOfLastCreatedObstacle >= Obstacle.timeBetweenNewObstacle) {
			Obstacle os = new Obstacle();
			int xCoordinate = Framework.frameWidth;

			int yCoordinate = random.nextInt(Framework.frameHeight - Obstacle.birdImg.getHeight());
			os.Initialize(xCoordinate, yCoordinate);
			// Add created enemy to the list of enemies.
			obstacleList.add(os);

			// Speed up enemy speed and aperence.
			Obstacle.speedUp();

			// Sets new time for last created enemy.
			Obstacle.timeOfLastCreatedObstacle = gameTime;
		}
	}

	private void createBoss(long gameTime) {
		if (gameTime - Boss.timeOfLastCreatedEnemy >= Boss.timeBetweenNewEnemies) {
			Boss boss = new Boss();
			int xCoordinate = Framework.frameWidth;
			int yCoordinate = random.nextInt(Framework.frameHeight - Boss.BossImg.getHeight());
			boss.Initialize(xCoordinate, yCoordinate);
			// Add created enemy to the list of enemies.
			bossList.add(boss);

			// Speed up enemy speed and aperence.
			Boss.speedUp();

			// Sets new time for last created enemy.
			Boss.timeOfLastCreatedEnemy = gameTime;
		}
	}

	private void createBoss2(long gameTime) {
		if (gameTime - Boss2.timeOfLastCreatedEnemy >= Boss2.timeBetweenNewEnemies) {
			Boss2 boss2 = new Boss2();
			int xCoordinate = Framework.frameWidth;
			int yCoordinate = random.nextInt(Framework.frameHeight - Boss2.Boss2Img.getHeight());
			boss2.Initialize(xCoordinate, yCoordinate);
			// Add created enemy to the list of enemies.
			boss2List.add(boss2);

			// Speed up enemy speed and aperence.
			Boss2.speedUp();

			// Sets new time for last created enemy.
			Boss2.timeOfLastCreatedEnemy = gameTime;
		}
	}

	private void createKing(long gameTime) {
		if (gameTime - King.timeOfLastCreatedEnemy >= King.timeBetweenNewEnemies) {
			King king = new King();
			int xCoordinate = Framework.frameWidth;
			int yCoordinate = random.nextInt(Framework.frameHeight - King.KingImg.getHeight());
			king.Initialize(xCoordinate, yCoordinate);
			// Add created enemy to the list of enemies.
			kingList.add(king);

			// Speed up enemy speed and aperence.
			King.speedUp();

			// Sets new time for last created enemy.
			King.timeOfLastCreatedEnemy = gameTime;
		}
	}

	private void createItemLife(long gameTime) {
		if (gameTime - ItemLife.timeOfLastCreatedItemLife >= ItemLife.timeBetweenNewItemLifes) {
			ItemLife tl = new ItemLife();
			int xCoordinate = Framework.frameWidth;
			int yCoordinate = random.nextInt(Framework.frameHeight - Obstacle.birdImg.getHeight());
			tl.Initialize(xCoordinate, yCoordinate);
			// Add created enemy to the list of enemies.
			itemLifeList.add(tl);

			// Speed up enemy speed and aperence.
			ItemLife.speedUp();

			// Sets new time for last created enemy.
			ItemLife.timeOfLastCreatedItemLife = gameTime;
		}
	}

	/**
	 * Updates all enemies. Move the helicopter and checks if he left the screen.
	 * Updates helicopter animations. Checks if enemy was destroyed. Checks if any
	 * enemy collision with player.
	 */
	private void updateEnemies() {
		for (int i = 0; i < enemyHelicopterList.size(); i++) {
			EnemyHelicopter eh = enemyHelicopterList.get(i);

			eh.Update();

			// Is chrashed with player?
			Rectangle playerRectangel = new Rectangle(player.xCoordinate, player.yCoordinate,
					player.helicopterBodyImg.getWidth(), player.helicopterBodyImg.getHeight());
			Rectangle enemyRectangel = new Rectangle(eh.xCoordinate, eh.yCoordinate,
					EnemyHelicopter.helicopterBodyImg.getWidth() - ((stage - 1) * difficult * 2),
					EnemyHelicopter.helicopterBodyImg.getHeight() - ((stage - 1) * difficult));
			if (playerRectangel.intersects(enemyRectangel)) {
				player.health = 0;
				sound.explosionSound();

				// Remove helicopter from the list.
				enemyHelicopterList.remove(i);

				// Add explosion of player helicopter.
				for (int exNum = 0; exNum < 3; exNum++) {
					Animation expAnim = new Animation(gameContents.getExplosionAnimImg(), 134, 134, 12, 45, false,
							player.xCoordinate + exNum * 60, player.yCoordinate - random.nextInt(100),
							exNum * 200 + random.nextInt(100));
					explosionsList.add(expAnim);
				}
				// Add explosion of enemy helicopter.
				for (int exNum = 0; exNum < 3; exNum++) {
					Animation expAnim = new Animation(gameContents.getExplosionAnimImg(), 134, 134, 12, 45, false,
							eh.xCoordinate + exNum * 60, eh.yCoordinate - random.nextInt(100),
							exNum * 200 + random.nextInt(100));
					explosionsList.add(expAnim);
				}

				// Because player crashed with enemy the game will be over so we don't need to
				// check other enemies.
				break;
			}

			// Check health.
			if (eh.health <= 0) {

				// Add explosion of helicopter.
				Animation expAnim = new Animation(gameContents.getExplosionAnimImg(), 134, 134, 12, 45, false, eh.xCoordinate,
						eh.yCoordinate - gameContents.getExplosionAnimImg().getHeight() / 3, 0); // Substring 1/3 explosion image height
																				// (explosionAnimImg.getHeight()/3) so
																				// that explosion is drawn more at the
																				// center of the helicopter.
				explosionsList.add(expAnim);

				sound.explosionSound();

				// Increase the destroyed enemies counter.
				destroyedEnemies++;

				// Remove helicopter from the list.
				enemyHelicopterList.remove(i);

				// Helicopter was destroyed so we can move to next helicopter.
				continue;
			}

			// If the current enemy is left the screen we remove him from the list and
			// update the runAwayEnemies variable.
			if (eh.isLeftScreen()) {
				enemyHelicopterList.remove(i);
				runAwayEnemies++;
				Life--;
			}
		}
	}

	private void updateObstacles() {
		for (int i = 0; i < obstacleList.size(); i++) {
			Obstacle os = obstacleList.get(i);

			os.Update();

			// Is chrashed with player?
			Rectangle playerRectangel = new Rectangle(player.xCoordinate, player.yCoordinate,
					player.helicopterBodyImg.getWidth(), player.helicopterBodyImg.getHeight());
			Rectangle obstacleRectangel = new Rectangle(os.xCoordinate, os.yCoordinate, Obstacle.birdImg.getWidth(),
					Obstacle.birdImg.getHeight());
			// crashed obstacle
			if (playerRectangel.intersects(obstacleRectangel)) {
				Life -= 3;
				sound.explosionSound();
				// Remove helicopter from the list.
				obstacleList.remove(i);

				// Add explosion of player helicopter.

				// Add explosion of enemy helicopter.

				// Because player crashed with enemy the game will be over so we don't need to
				// check other enemies.
				break;
			}

			// Check health.
			if (Life <= 0) {
				// Add explosion of helicopter.
				Animation expAnim = new Animation(explosionAnimImg, 134, 134, 12, 45, false, os.xCoordinate,
						os.yCoordinate - gameContents.getExplosionAnimImg().getHeight() / 3, 0); // Substring 1/3 explosion image height
																				// (explosionAnimImg.getHeight()/3) so
																				// that explosion is drawn more at the
																				// center of the helicopter.
				explosionsList.add(expAnim);

				sound.explosionSound();
				// Increase the destroyed enemies counter.

				// Remove helicopter from the list.
				obstacleList.remove(i);

				// Helicopter was destroyed so we can move to next helicopter.
				continue;
			}

			// If the current enemy is left the screen we remove him from the list and
			// update the runAwayEnemies variable.
			if (os.isLeftScreen()) {
				obstacleList.remove(i);
			}
		}
	}

	private void updateBoss() {
		for (int i = 0; i < bossList.size(); i++) {
			Boss boss = bossList.get(i);

			boss.Update();

			// Is chrashed with player?
			Rectangle playerRectangel = new Rectangle(player.xCoordinate, player.yCoordinate,
					player.helicopterBodyImg.getWidth(), player.helicopterBodyImg.getHeight());
			Rectangle bossRectangel = new Rectangle(boss.xCoordinate, boss.yCoordinate, Boss.BossImg.getWidth(),
					Boss.BossImg.getHeight());

			if (playerRectangel.intersects(bossRectangel)) {
				player.health = 0;
				sound.explosionSound();
				// Remove helicopter from the list.
				bossList.remove(i);

				// Add explosion of player helicopter.
				for (int exNum = 0; exNum < 3; exNum++) {
					Animation expAnim = new Animation(gameContents.getExplosionAnimImg(), 134, 134, 12, 45, false,
							player.xCoordinate + exNum * 60, player.yCoordinate - random.nextInt(100),
							exNum * 200 + random.nextInt(100));
					explosionsList.add(expAnim);
				}
				// Add explosion of enemy helicopter.
				for (int exNum = 0; exNum < 3; exNum++) {
					Animation expAnim = new Animation(gameContents.getExplosionAnimImg(), 134, 134, 12, 45, false,
							boss.xCoordinate + exNum * 60, boss.yCoordinate - random.nextInt(100),
							exNum * 200 + random.nextInt(100));
					explosionsList.add(expAnim);
				}

				// Because player crashed with enemy the game will be over so we don't need to
				// check other enemies.
				break;
			}

			// Check health.
			if (boss.health <= 0) {
				// Add explosion of helicopter.
				Animation expAnim = new Animation(gameContents.getExplosionAnimImg(), 134, 134, 12, 45, false, boss.xCoordinate,
						boss.yCoordinate - gameContents.getExplosionAnimImg().getHeight() / 3, 0); // Substring 1/3 explosion image height
																					// (explosionAnimImg.getHeight()/3)
																					// so that explosion is drawn more
																					// at the center of the helicopter.
				explosionsList.add(expAnim);

				sound.explosionSound();
				// Increase the destroyed enemies counter.
				destroyedEnemies += 2;

				// Remove helicopter from the list.
				bossList.remove(i);

				// Helicopter was destroyed so we can move to next helicopter.
				continue;
			}

			// If the current enemy is left the screen we remove him from the list and
			// update the runAwayEnemies variable.
			if (boss.isLeftScreen()) {
				bossList.remove(i);
				runAwayEnemies++;
				Life -= 5;
			}
		}
	}

	private void updateBoss2() {
		for (int i = 0; i < boss2List.size(); i++) {
			Boss2 boss2 = boss2List.get(i);

			boss2.Update();

			// Is chrashed with player?
			Rectangle playerRectangel = new Rectangle(player.xCoordinate, player.yCoordinate,
					player.helicopterBodyImg.getWidth(), player.helicopterBodyImg.getHeight());
			Rectangle bossRectangel = new Rectangle(boss2.xCoordinate, boss2.yCoordinate, Boss2.Boss2Img.getWidth(),
					Boss2.Boss2Img.getHeight());

			if (playerRectangel.intersects(bossRectangel)) {
				player.health = 0;
				sound.explosionSound();
				// Remove helicopter from the list.
				boss2List.remove(i);

				// Add explosion of player helicopter.
				for (int exNum = 0; exNum < 3; exNum++) {
					Animation expAnim = new Animation(gameContents.getExplosionAnimImg(), 134, 134, 12, 45, false,
							player.xCoordinate + exNum * 60, player.yCoordinate - random.nextInt(100),
							exNum * 200 + random.nextInt(100));
					explosionsList.add(expAnim);
				}
				// Add explosion of enemy helicopter.
				for (int exNum = 0; exNum < 3; exNum++) {
					Animation expAnim = new Animation(gameContents.getExplosionAnimImg(), 134, 134, 12, 45, false,
							boss2.xCoordinate + exNum * 60, boss2.yCoordinate - random.nextInt(100),
							exNum * 200 + random.nextInt(100));
					explosionsList.add(expAnim);
				}

				// Because player crashed with enemy the game will be over so we don't need to
				// check other enemies.
				break;
			}

			// Check health.
			if (boss2.health <= 0) {
				// Add explosion of helicopter.
				Animation expAnim = new Animation(gameContents.getExplosionAnimImg(), 134, 134, 12, 45, false, boss2.xCoordinate,
						boss2.yCoordinate - gameContents.getExplosionAnimImg().getHeight() / 3, 0);
				// Substring 1/3 explosion image
				// height
				// (explosionAnimImg.getHeight()/3)
				// so that explosion is drawn more
				// at the center of the helicopter.
				explosionsList.add(expAnim);

				sound.explosionSound();
				// Increase the destroyed enemies counter.
				destroyedEnemies += 4;

				// Remove helicopter from the list.
				boss2List.remove(i);

				// Helicopter was destroyed so we can move to next helicopter.
				continue;
			}

			// If the current enemy is left the screen we remove him from the list and
			// update the runAwayEnemies variable.
			if (boss2.isLeftScreen()) {
				boss2List.remove(i);
				runAwayEnemies++;
				Life -= 8;
			}
		}
	}

	private void updateKing() {
		for (int i = 0; i < kingList.size(); i++) {
			King king = kingList.get(i);

			king.Update();

			// Is chrashed with player?
			Rectangle playerRectangel = new Rectangle(player.xCoordinate, player.yCoordinate,
					player.helicopterBodyImg.getWidth(), player.helicopterBodyImg.getHeight());
			Rectangle kingRectangel = new Rectangle(king.xCoordinate, king.yCoordinate, King.KingImg.getWidth(),
					King.KingImg.getHeight());

			if (playerRectangel.intersects(kingRectangel)) {
				player.health = 0;
				sound.explosionSound();
				// Remove helicopter from the list.
				kingList.remove(i);

				// Add explosion of player helicopter.
				for (int exNum = 0; exNum < 3; exNum++) {
					Animation expAnim = new Animation(gameContents.getExplosionAnimImg(), 134, 134, 12, 45, false,
							player.xCoordinate + exNum * 60, player.yCoordinate - random.nextInt(100),
							exNum * 200 + random.nextInt(100));
					explosionsList.add(expAnim);
				}
				// Add explosion of enemy helicopter.
				for (int exNum = 0; exNum < 3; exNum++) {
					Animation expAnim = new Animation(gameContents.getExplosionAnimImg(), 134, 134, 12, 45, false,
							king.xCoordinate + exNum * 60, king.yCoordinate - random.nextInt(100),
							exNum * 200 + random.nextInt(100));
					explosionsList.add(expAnim);
				}

				// Because player crashed with enemy the game will be over so we don't need to
				// check other enemies.
				break;
			}

			// Check health.
			if (king.health <= 0) {
				// Add explosion of helicopter.
				Animation expAnim = new Animation(gameContents.getExplosionAnimImg(), 134, 134, 12, 45, false, king.xCoordinate,
						king.yCoordinate - gameContents.getExplosionAnimImg().getHeight() / 3, 0); // Substring 1/3 explosion image height
																					// (explosionAnimImg.getHeight()/3)
																					// so that explosion is drawn more
																					// at the center of the helicopter.
				explosionsList.add(expAnim);

				sound.explosionSound();
				// Increase the destroyed enemies counter.
				destroyedEnemies += 10;

				// Remove helicopter from the list.
				kingList.remove(i);

				// Helicopter was destroyed so we can move to next helicopter.
				continue;
			}

			// If the current enemy is left the screen we remove him from the list and
			// update the runAwayEnemies variable.
			if (king.isLeftScreen()) {
				kingList.remove(i);
				runAwayEnemies++;
				Life = 0;
			}
		}
	}

	private void updateItemLife() {
		for (int i = 0; i < itemLifeList.size(); i++) {
			ItemLife tl = itemLifeList.get(i);

			tl.Update();

			// Is chrashed with player?
			Rectangle playerRectangel = new Rectangle(player.xCoordinate, player.yCoordinate,
					player.helicopterBodyImg.getWidth(), player.helicopterBodyImg.getHeight());
			Rectangle itemLifeRectangel = new Rectangle(tl.xCoordinate, tl.yCoordinate, ItemLife.itemLifeImg.getWidth(),
					itemLife.itemLifeImg.getHeight());
			if (playerRectangel.intersects(itemLifeRectangel)) {
				Life += 1;
				sound.HeartItemSound();
				// Remove helicopter from the list.
				itemLifeList.remove(i);

				// Add explosion of player helicopter.

				// Add explosion of enemy helicopter.

				// Because player crashed with enemy the game will be over so we don't need to
				// check other enemies.
				break;
			}

			// If the current enemy is left the screen we remove him from the list and
			// update the runAwayEnemies variable.
			if (tl.isLeftScreen()) {
				itemLifeList.remove(i);
			}
		}
	}

	/**
	 * Update bullets. It moves bullets. Checks if the bullet is left the screen.
	 * Checks if any bullets is hit any enemy.
	 */
	private void updateBullets() {
		// Reload Ammo
		reloadBullet();

		for (int i = 0; i < bulletsList.size(); i++) {
			Bullet bullet = bulletsList.get(i);

			// Move the bullet.
			bullet.Update();

			// Is left the screen?
			if (bullet.isItLeftScreen()) {
				bulletsList.remove(i);
				// Bullet have left the screen so we removed it from the list and now we can
				// continue to the next bullet.
				continue;
			}

			// Did hit any enemy?
			// Rectangle of the bullet image.
			Rectangle bulletRectangle = new Rectangle((int) bullet.xCoordinate, (int) bullet.yCoordinate,
					Bullet.bulletImg.getWidth(), Bullet.bulletImg.getHeight());
			// Go trough all enemis.
			for (int j = 0; j < enemyHelicopterList.size(); j++) {
				EnemyHelicopter eh = enemyHelicopterList.get(j);

				// Current enemy rectangle.
				Rectangle enemyRectangel = new Rectangle(eh.xCoordinate, eh.yCoordinate,
						EnemyHelicopter.helicopterBodyImg.getWidth() - ((stage - 1) * difficult * 2),
						EnemyHelicopter.helicopterBodyImg.getHeight() - ((stage - 1) * difficult));

				// Is current bullet over currnet enemy?
				if (bulletRectangle.intersects(enemyRectangel)) {
					// Bullet hit the enemy so we reduce his health.
					eh.health -= Bullet.damagePower;

					// Bullet was also destroyed so we remove it.
					bulletsList.remove(i);

					// That bullet hit enemy so we don't need to check other enemies.
					break;
				}
			}
			for (int j = 0; j < bossList.size(); j++) {
				Boss boss = bossList.get(j);

				// Current enemy rectangle.
				Rectangle bossRectangel = new Rectangle(boss.xCoordinate, boss.yCoordinate, Boss.BossImg.getWidth(),
						Boss.BossImg.getHeight());

				// Is current bullet over currnet enemy?
				if (bulletRectangle.intersects(bossRectangel)) {
					// Bullet hit the enemy so we reduce his health.
					boss.health -= Bullet.damagePower;

					// Bullet was also destroyed so we remove it.
					bulletsList.remove(i);

					// That bullet hit enemy so we don't need to check other enemies.
					break;
				}
			}
			for (int j = 0; j < boss2List.size(); j++) {
				Boss2 boss2 = boss2List.get(j);

				// Current enemy rectangle.
				Rectangle bossRectangel = new Rectangle(boss2.xCoordinate, boss2.yCoordinate, Boss2.Boss2Img.getWidth(),
						Boss2.Boss2Img.getHeight());

				// Is current bullet over currnet enemy?
				if (bulletRectangle.intersects(bossRectangel)) {
					// Bullet hit the enemy so we reduce his health.
					boss2.health -= Bullet.damagePower;

					// Bullet was also destroyed so we remove it.
					bulletsList.remove(i);

					// That bullet hit enemy so we don't need to check other enemies.
					break;
				}
			}
			for (int j = 0; j < kingList.size(); j++) {
				King king = kingList.get(j);

				// Current enemy rectangle.
				Rectangle kingRectangel = new Rectangle(king.xCoordinate, king.yCoordinate, King.KingImg.getWidth(),
						King.KingImg.getHeight());

				// Is current bullet over currnet enemy?
				if (bulletRectangle.intersects(kingRectangel)) {
					// Bullet hit the enemy so we reduce his health.
					king.health -= Bullet.damagePower;

					// Bullet was also destroyed so we remove it.
					bulletsList.remove(i);

					// That bullet hit enemy so we don't need to check other enemies.
					break;
				}
			}
		}
	}
	private void updateEnemyBullets() {
			
			for (int i = 0; i < enemybulletsList.size(); i++) {
				EnemyBullet enemybullet = enemybulletsList.get(i);
	
				// Move the bullet.
				enemybullet.Update();
	
				// Is left the screen?
				if (enemybullet.isItLeftScreen()) {
					enemybulletsList.remove(i);
					// Bullet have left the screen so we removed it from the list and now we can
					// continue to the next bullet.
					continue;
				}
	
				// Did hit any player?
				// Rectangle of the bullet image.
				Rectangle enemybulletRectangle = new Rectangle((int) enemybullet.xCoordinate, (int) enemybullet.yCoordinate,
						EnemyBullet.enemybulletImg.getWidth(), EnemyBullet.enemybulletImg.getHeight());
				// Go trough all enemies.
				for (int j = 0; j < enemyHelicopterList.size(); j++) {
					EnemyHelicopter eh = enemyHelicopterList.get(j);
					// Current player rectangle.
					Rectangle playerRectangel = new Rectangle(player.xCoordinate, player.yCoordinate,
							player.helicopterBodyImg.getWidth(), player.helicopterBodyImg.getHeight());
					
					// Is current bullet over current player?
					if (enemybulletRectangle.intersects(playerRectangel)) {
						// Bullet hit the enemy so we reduce his health.
						Life--;
	
						// Bullet was also destroyed so we remove it.
						enemybulletsList.remove(i);
	
						// That bullet hit enemy so we don't need to check other enemies.
						break;
					}
				}			
			}
		}
	/**
	 * Update rockets. It moves rocket and add smoke behind it. Checks if the rocket
	 * is left the screen. Checks if any rocket is hit any enemy.
	 * 
	 * @param gameTime
	 *            Game time.
	 */
	private void updateRockets(long gameTime) {
		for (int i = 0; i < rocketsList.size(); i++) {
			Rocket rocket = rocketsList.get(i);

			// Moves the rocket.
			rocket.Update();

			// Checks if it is left the screen.
			if (rocket.isItLeftScreen()) {
				rocketsList.remove(i);
				// Rocket left the screen so we removed it from the list and now we can continue
				// to the next rocket.
				continue;
			}

			// Creates a rocket smoke.
			RocketSmoke rs = new RocketSmoke();
			int xCoordinate = rocket.xCoordinate - RocketSmoke.smokeImg.getWidth(); // Subtract the size of the rocket
																					// smoke image
																					// (rocketSmokeImg.getWidth()) so
																					// that smoke isn't drawn
																					// under/behind the image of rocket.
			int yCoordinte = rocket.yCoordinate - 5 + random.nextInt(6); // Subtract 5 so that smok will be at the
																			// middle of the rocket on y coordinate. We
																			// rendomly add a number between 0 and 6 so
																			// that the smoke line isn't straight line.
			rs.Initialize(xCoordinate, yCoordinte, gameTime, rocket.currentSmokeLifeTime);
			rocketSmokeList.add(rs);

			// Because the rocket is fast we get empty space between smokes so we need to
			// add more smoke.
			// The higher is the speed of rockets, the bigger are empty spaces.
			int smokePositionX = 5 + random.nextInt(8); // We will draw this smoke a little bit ahead of the one we draw
														// before.
			rs = new RocketSmoke();
			xCoordinate = rocket.xCoordinate - RocketSmoke.smokeImg.getWidth() + smokePositionX;
			// Here we need to addso that the smokewill not be onthe same xcoordinate
			// asprevious smoke.
			// First we need to add 5 because we add random number from 0 to 8 and if the
			// random umber is 0 it
			// would be on the same coordinate as smoke before.

			yCoordinte = rocket.yCoordinate - 5 + random.nextInt(6);

			// Subtract 5 so that smok will be at the middle of the rocket on y coordinate.
			// We rendomly add a
			// number between 0 and 6 so that the smoke line // isn't straight line.
			rs.Initialize(xCoordinate, yCoordinte, gameTime, rocket.currentSmokeLifeTime);
			rocketSmokeList.add(rs);

			// Increase the life time for the next piece of rocket smoke.
			rocket.currentSmokeLifeTime *= 1.02;

			// Checks if current rocket hit any enemy.
			if (checkIfRocketHitEnemy(rocket)) {
				sound.rClip.stop();
				// Rocket was also destroyed so we remove it.
				rocketsList.remove(i);
			}
		}
	}

	/**
	 * Checks if the given rocket is hit any of enemy helicopters.
	 * 
	 * @param rocket
	 *            Rocket to check.
	 * @return True if it hit any of enemy helicopters, false otherwise.
	 */
	private boolean checkIfRocketHitEnemy(Rocket rocket) {
		boolean didItHitEnemy = false;

		// Current rocket rectangle. // I inserted number 2 insted of
		// rocketImg.getWidth() because I wanted that rocket
		// is over helicopter when collision is detected, because actual image of
		// helicopter isn't a rectangle shape. (We could calculate/make 3 areas where
		// helicopter can be hit and checks these areas, but this is easier.)
		Rectangle rocketRectangle = new Rectangle(rocket.xCoordinate, rocket.yCoordinate, 2,
				Rocket.rocketImg.getHeight());

		// Go trough all enemis.
		for (int j = 0; j < enemyHelicopterList.size(); j++) {
			EnemyHelicopter eh = enemyHelicopterList.get(j);

			// Current enemy rectangle.
			Rectangle enemyRectangel = new Rectangle(eh.xCoordinate, eh.yCoordinate,
					EnemyHelicopter.helicopterBodyImg.getWidth() - ((stage - 1) * difficult * 2),
					EnemyHelicopter.helicopterBodyImg.getHeight() - ((stage - 1) * difficult));

			// Is current rocket over currnet enemy?
			if (rocketRectangle.intersects(enemyRectangel)) {
				didItHitEnemy = true;

				// Rocket hit the enemy so we reduce his health.
				eh.health -= Rocket.damagePower;

				// Rocket hit enemy so we don't need to check other enemies.
				break;
			}
		}
		for (int j = 0; j < bossList.size(); j++) {
			Boss boss = bossList.get(j);

			// Current enemy rectangle.
			Rectangle bossRectangel = new Rectangle(boss.xCoordinate, boss.yCoordinate, Boss.BossImg.getWidth(),
					Boss.BossImg.getHeight());

			// Is current rocket over currnet enemy?
			if (rocketRectangle.intersects(bossRectangel)) {
				didItHitEnemy = true;

				// Rocket hit the enemy so we reduce his health.
				boss.health -= Rocket.damagePower;

				// Rocket hit enemy so we don't need to check other enemies.
				break;
			}
		}
		for (int j = 0; j < boss2List.size(); j++) {
			Boss2 boss2 = boss2List.get(j);

			// Current enemy rectangle.
			Rectangle bossRectangel = new Rectangle(boss2.xCoordinate, boss2.yCoordinate, Boss2.Boss2Img.getWidth(),
					Boss2.Boss2Img.getHeight());

			// Is current rocket over currnet enemy?
			if (rocketRectangle.intersects(bossRectangel)) {
				didItHitEnemy = true;

				// Rocket hit the enemy so we reduce his health.
				boss2.health -= Rocket.damagePower;

				// Rocket hit enemy so we don't need to check other enemies.
				break;
			}
		}
		for (int j = 0; j < kingList.size(); j++) {
			King king = kingList.get(j);

			// Current enemy rectangle.
			Rectangle kingRectangel = new Rectangle(king.xCoordinate, king.yCoordinate, King.KingImg.getWidth(),
					King.KingImg.getHeight());

			// Is current rocket over currnet enemy?
			if (rocketRectangle.intersects(kingRectangel)) {
				didItHitEnemy = true;

				// Rocket hit the enemy so we reduce his health.
				king.health -= Rocket.damagePower;

				// Rocket hit enemy so we don't need to check other enemies.
				break;
			}
		}
		return didItHitEnemy;
	}

	/**
	 * Updates smoke of all the rockets. If the life time of the smoke is over then
	 * we delete it from list. It also changes a transparency of a smoke image, so
	 * that smoke slowly disappear.
	 * 
	 * @param gameTime
	 *            Game time.
	 */
	private void updateRocketSmoke(long gameTime) {
		for (int i = 0; i < rocketSmokeList.size(); i++) {
			RocketSmoke rs = rocketSmokeList.get(i);

			// Is it time to remove the smoke.
			if (rs.didSmokeDisapper(gameTime))
				rocketSmokeList.remove(i);

			// Set new transparency of rocket smoke image.
			rs.updateTransparency(gameTime);
		}
	}

	/**
	 * Updates all the animations of an explosion and remove the animation when is
	 * over.
	 */
	private void updateExplosions() {
		for (int i = 0; i < explosionsList.size(); i++) {
			// If the animation is over we remove it from the list.
			if (!explosionsList.get(i).active)
				explosionsList.remove(i);
		}
	}

	/**
	 * It limits the distance of the mouse from the player.
	 * 
	 * @param mousePosition
	 *            Position of the mouse.
	 */
	private void limitMousePosition(Point mousePosition) {
		// Max distance from the player on y coordinate above player helicopter.
		int maxYcoordinateDistanceFromPlayer_top = 30;
		// Max distance from the player on y coordinate under player helicopter.
		int maxYcoordinateDistanceFromPlayer_bottom = 120;

		// Mouse cursor will always be the same distance from the player helicopter
		// machine gun on the x coordinate.
		int mouseXcoordinate = player.machineGunXcoordinate + 250;

		// Here we will limit the distance of mouse cursor on the y coordinate.
		int mouseYcoordinate = mousePosition.y;
		if (mousePosition.y < player.machineGunYcoordinate) { // Above the helicopter machine gun.
			if (mousePosition.y < player.machineGunYcoordinate - maxYcoordinateDistanceFromPlayer_top)
				mouseYcoordinate = player.machineGunYcoordinate - maxYcoordinateDistanceFromPlayer_top;
		} else { // Under the helicopter.
			if (mousePosition.y > player.machineGunYcoordinate + maxYcoordinateDistanceFromPlayer_bottom)
				mouseYcoordinate = player.machineGunYcoordinate + maxYcoordinateDistanceFromPlayer_bottom;
		}

		// We move mouse on y coordinate with helicopter. That makes shooting easier.
		mouseYcoordinate += player.movingYspeed;

		// Move the mouse.
		robot.mouseMove(mouseXcoordinate, mouseYcoordinate);
	}
}
