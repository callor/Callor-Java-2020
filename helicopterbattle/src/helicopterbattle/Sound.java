package helicopterbattle;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Sound {
	public void reloadSound() {
		  try {
	          AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/helicopterbattle/resources/sounds/Sound_Reload.wav").getAbsoluteFile());
	          Clip clip = AudioSystem.getClip();
	          clip.open(audioInputStream);
	          clip.start();
	          
	      } catch(Exception ex) {
	          System.out.println("Error with playing sound.");
	          ex.printStackTrace();
	      }
	}

	public void fireSound() {
		  try {
	          AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/helicopterbattle/resources/sounds/Sound_Shot.wav").getAbsoluteFile());
	          Clip clip = AudioSystem.getClip();
	          clip.open(audioInputStream);
	          clip.start();
	          
	      } catch(Exception ex) {
	          System.out.println("Error with playing sound.");
	          ex.printStackTrace();
	      }
	}

	public void lastShot() {
		  try {
	          AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/helicopterbattle/resources/sounds/Sound_FireLastShot.wav").getAbsoluteFile());
	          Clip clip = AudioSystem.getClip();
	          clip.open(audioInputStream);
	          clip.start();
	          
	      } catch(Exception ex) {
	          System.out.println("Error with playing sound.");
	          ex.printStackTrace();
	      }
	}
	
	public void backgroundSound() {
		  try {
	          AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/helicopterbattle/resources/sounds/Sound_Background.wav").getAbsoluteFile());
	          Clip clip = AudioSystem.getClip();
	          clip.open(audioInputStream);
	          clip.start();
	          
	      } catch(Exception ex) {
	          System.out.println("Error with playing sound.");
	          ex.printStackTrace();
	      }
	}
	public void explosionSound() {
		  try {
	          AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/helicopterbattle/resources/sounds/Sound_Explosion.wav").getAbsoluteFile());
	          Clip clip = AudioSystem.getClip();
	          clip.open(audioInputStream);
	          clip.start();
	          
	      } catch(Exception ex) {
	          System.out.println("Error with playing sound.");
	          ex.printStackTrace();
	      }
	}
	
	public void HeartItemSound() {
		  try {
	          AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/helicopterbattle/resources/sounds/Sound_HeartItem.wav").getAbsoluteFile());
	          Clip clip = AudioSystem.getClip();
	          clip.open(audioInputStream);
	          clip.start();
	          
	      } catch(Exception ex) {
	          System.out.println("Error with playing sound.");
	          ex.printStackTrace();
	      }
	}

	Clip rClip;
	public void rocketSound() {
		  try {
	          AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/helicopterbattle/resources/sounds/Sound_Rocket.wav").getAbsoluteFile());
	          rClip = AudioSystem.getClip();
	          rClip.open(audioInputStream);
	          rClip.start();
	          
	      } catch(Exception ex) {
	          System.out.println("Error with playing sound.");
	          ex.printStackTrace();
	      }
	}
	
	
}