package helicopterbattle;

import java.awt.Graphics2D;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Enemy {
	
	private Random random = new Random();
	private ArrayList<EnemyHelicopter> enemyHelicopterList = new ArrayList<EnemyHelicopter>();
	private ArrayList<Obstacle> obstacleList = new ArrayList<Obstacle>();
	private ArrayList<Boss> bossList = new ArrayList<Boss>();
	private ArrayList<Boss2> boss2List = new ArrayList<Boss2>();
	private ArrayList<King> kingList = new ArrayList<King>();
	private ArrayList<ItemLife> itemLifeList = new ArrayList<ItemLife>();
	
	
	private void LoadContent() {
		try {
			// Load images for enemy helicopter
			URL helicopterBodyImgUrl = this.getClass()
					.getResource("/helicopterbattle/resources/images/2_helicopter_body.png");
			EnemyHelicopter.helicopterBodyImg = ImageIO.read(helicopterBodyImgUrl);
			URL helicopterFrontPropellerAnimImgUrl = this.getClass()
					.getResource("/helicopterbattle/resources/images/2_front_propeller_anim.png");
			EnemyHelicopter.helicopterFrontPropellerAnimImg = ImageIO.read(helicopterFrontPropellerAnimImgUrl);
			URL helicopterRearPropellerAnimImgUrl = this.getClass()
					.getResource("/helicopterbattle/resources/images/2_rear_propeller_anim.png");
			EnemyHelicopter.helicopterRearPropellerAnimImg = ImageIO.read(helicopterRearPropellerAnimImgUrl);

			// Load images for Boss, King
			URL BossImgUrl = this.getClass().getResource("/helicopterbattle/resources/images/boss.png");
			Boss.BossImg = ImageIO.read(BossImgUrl);
			URL Boss2ImgUrl = this.getClass().getResource("/helicopterbattle/resources/images/boss2.png");
			Boss2.Boss2Img = ImageIO.read(Boss2ImgUrl);
			URL KingImgUrl = this.getClass().getResource("/helicopterbattle/resources/images/king.png");
			King.KingImg = ImageIO.read(KingImgUrl);
			
			// Load images for bird
			URL birdImgUrl = this.getClass().getResource("/helicopterbattle/resources/images/bird.png");
			Obstacle.birdImg = ImageIO.read(birdImgUrl);

			// Load images for bird
			URL itemLifeImgUrl = this.getClass().getResource("/helicopterbattle/resources/images/item_life.png");
			ItemLife.itemLifeImg = ImageIO.read(itemLifeImgUrl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void createEnemyHelicopter(long gameTime) {
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

	public void createObstacle(long gameTime) {
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

	public void createBoss(long gameTime) {
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

	public void createBoss2(long gameTime) {
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

	public void createKing(long gameTime) {
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

	public void createItemLife(long gameTime) {
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
	
	Graphics2D g;
	public void drawEnemys(Graphics2D g2d2, long gameTime) {
		g = g2d2;
		int sec = (int) (gameTime / Framework.milisecInNanosec / 1000);
		int min = sec / 60;
		int stage = (min*60+sec)/5;
		int difficult = 5;
		sec = sec - (min * 60);
		
		for (int i = 0; i < enemyHelicopterList.size(); i++) {
			enemyHelicopterList.get(i).Draw(g2d2);
			g2d2.drawImage(enemyHelicopterList.get(i).helicopterBodyImg, enemyHelicopterList.get(i).xCoordinate,
					enemyHelicopterList.get(i).yCoordinate,
					enemyHelicopterList.get(i).helicopterBodyImg.getWidth() - ((stage - 1) * difficult * 2),
					enemyHelicopterList.get(i).helicopterBodyImg.getHeight() - ((stage - 1) * difficult), null);
		}
	}

	public Random getRandom() {return random;}
	public ArrayList<EnemyHelicopter> getEnemyHelicopterList() {return enemyHelicopterList;}
	public ArrayList<Obstacle> getObstacleList() {return obstacleList;}
	public ArrayList<Boss> getBossList() {return bossList;}
	public ArrayList<Boss2> getBoss2List() {return boss2List;}
	public ArrayList<King> getKingList() {return kingList;}
	public ArrayList<ItemLife> getItemLifeList() {	return itemLifeList;}

	
}
