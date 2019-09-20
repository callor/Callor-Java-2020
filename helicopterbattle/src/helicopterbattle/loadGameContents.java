package helicopterbattle;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class loadGameContents {
	// Image for the sky color.
	private BufferedImage skyColorImg;

	private BufferedImage explosionAnimImg;

	// Images for white spot on the sky.
	private BufferedImage cloudLayer1Img;
	private BufferedImage cloudLayer2Img;
	// Images for mountains and ground.
	private BufferedImage mountainsImg;
	private BufferedImage groundImg;

	// Image of mouse cursor.
	private BufferedImage mouseCursorImg;

	public void loadContent() {
		try {

			URL skyColorImgUrl = this.getClass().getResource("/helicopterbattle/resources/images/sky_color.jpg");
			skyColorImg = ImageIO.read(skyColorImgUrl);
			URL cloudLayer1ImgUrl = this.getClass().getResource("/helicopterbattle/resources/images/cloud_layer_1.png");
			cloudLayer1Img = ImageIO.read(cloudLayer1ImgUrl);
			URL cloudLayer2ImgUrl = this.getClass().getResource("/helicopterbattle/resources/images/cloud_layer_2.png");
			cloudLayer2Img = ImageIO.read(cloudLayer2ImgUrl);
			URL mountainsImgUrl = this.getClass().getResource("/helicopterbattle/resources/images/mountains.png");
			mountainsImg = ImageIO.read(mountainsImgUrl);
			URL groundImgUrl = this.getClass().getResource("/helicopterbattle/resources/images/ground.png");
			groundImg = ImageIO.read(groundImgUrl);

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

			// Images of rocket and its smoke.
			URL rocketImgUrl = this.getClass().getResource("/helicopterbattle/resources/images/rocket.png");
			Rocket.rocketImg = ImageIO.read(rocketImgUrl);
			URL rocketSmokeImgUrl = this.getClass().getResource("/helicopterbattle/resources/images/rocket_smoke.png");
			RocketSmoke.smokeImg = ImageIO.read(rocketSmokeImgUrl);

			// Imege of explosion animation.
			URL explosionAnimImgUrl = this.getClass()
					.getResource("/helicopterbattle/resources/images/explosion_anim.png");
			explosionAnimImg = ImageIO.read(explosionAnimImgUrl);

			// Image of mouse cursor.
			URL mouseCursorImgUrl = this.getClass().getResource("/helicopterbattle/resources/images/mouse_cursor.png");
			mouseCursorImg = ImageIO.read(mouseCursorImgUrl);

			// Helicopter machine gun bullet.
			URL bulletImgUrl = this.getClass().getResource("/helicopterbattle/resources/images/bullet.png");
			Bullet.bulletImg = ImageIO.read(bulletImgUrl);
			URL enemybulletImgUrl = this.getClass().getResource("/helicopterbattle/resources/images/enemybullet.png");
			EnemyBullet.enemybulletImg = ImageIO.read(enemybulletImgUrl);

			// Load images for bird
			URL birdImgUrl = this.getClass().getResource("/helicopterbattle/resources/images/bird.png");
			Obstacle.birdImg = ImageIO.read(birdImgUrl);

			// Load images for bird
			URL itemLifeImgUrl = this.getClass().getResource("/helicopterbattle/resources/images/item_life.png");
			ItemLife.itemLifeImg = ImageIO.read(itemLifeImgUrl);

			URL nowbulletImgUrl = this.getClass().getResource("/helicopterbattle/resources/images/bullet3.png");
			Bullet.nowBullet = ImageIO.read(nowbulletImgUrl);
		} catch (Exception e) {
			Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public BufferedImage getSkyColorImg() {return skyColorImg;}
	public void setSkyColorImg(BufferedImage skyColorImg) {this.skyColorImg = skyColorImg;}
	public BufferedImage getCloudLayer1Img() {return cloudLayer1Img;}
	public void setCloudLayer1Img(BufferedImage cloudLayer1Img) {this.cloudLayer1Img = cloudLayer1Img;}
	public BufferedImage getCloudLayer2Img() {return cloudLayer2Img;}
	public void setCloudLayer2Img(BufferedImage cloudLayer2Img) {this.cloudLayer2Img = cloudLayer2Img;}
	public BufferedImage getMountainsImg() {return mountainsImg;}
	public void setMountainsImg(BufferedImage mountainsImg) {this.mountainsImg = mountainsImg;}
	public BufferedImage getGroundImg() {return groundImg;}
	public void setGroundImg(BufferedImage groundImg) {this.groundImg = groundImg;}
	public BufferedImage getMouseCursorImg() {return mouseCursorImg;}
	public void setMouseCursorImg(BufferedImage mouseCursorImg) {this.mouseCursorImg = mouseCursorImg;}
	public BufferedImage getExplosionAnimImg() {return explosionAnimImg;}
	public void setExplosionAnimImg(BufferedImage explosionAnimImg) {this.explosionAnimImg = explosionAnimImg;}
	
}
