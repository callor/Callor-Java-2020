package helicopterbattle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Rank {

	private ArrayList<RankVO> rankList;
	private Rectangle rankingBoard;
	public Rectangle backButton;
	public Rectangle rankButton;

	private Image RankBoardImg;
	private Image backImg;

	private int frameWidth;
	private int frameHeight;

	public Rank() {
		super();
	}

	public Rank(int frameWidth, int frameHeight) {
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;

		backButton = new Rectangle(frameWidth / 2 - 100, frameHeight / 2 + 220, 190, 50);
		rankingBoard = new Rectangle(frameWidth / 2 - 200, frameHeight / 2 - 300, 400, 600);
		rankButton = new Rectangle(frameWidth / 2 - 100, frameHeight / 2 + 170, 190, 50);

		try {
			RankBoardImg = ImageIO.read(getClass().getResource("/helicopterbattle/resources/images/RankingBoard.png"));
			backImg = ImageIO.read(getClass().getResource("/helicopterbattle/resources/images/Back.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void writeRank(long time) {
			// Given time in minutes and seconds.
			int sec = (int) (time / Framework.milisecInNanosec / 1000);
			int min = sec / 60;
			int stage = (min * 60 + sec) / 10;

			sec = sec - (min * 60);

			// MAX stage 10 in Game.java
			if (stage > 10)
				stage = 10;

			String name = JOptionPane.showInputDialog("Player Name EX)'ABC'");
			while (true) {
				if (name == null) {
					return;
				} else if (name.length() > 3) {
					name = JOptionPane.showInputDialog("Player Name EX)'ABC'");
				} else
					break;
			}

			String filename = "src/helicopterbattle/ranking.txt";
			PrintWriter pw = null;
			try {
				readRank();

				boolean ranker = true;
				if (rankList.size() > 9) {
					ranker = rankerCheck(min, sec);
				}

				if (ranker) {
					pw = new PrintWriter(filename);
					rankList.add(new RankVO(name, String.valueOf(min), String.valueOf(sec), String.valueOf(stage)));
					Collections.sort(rankList, new compareSec());

					for (int i = 0; i < rankList.size(); i++) {
						if (i > 9)
							break;
						pw.print(rankList.get(i).getName());
						pw.print(":");
						pw.print(rankList.get(i).getMin());
						pw.print(":");
						pw.print(rankList.get(i).getSec());
						pw.print(":");
						pw.println(rankList.get(i).getStage());
					}

					pw.close();
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public boolean rankerCheck(int min, int sec) {
		return (min * 60 + sec > Integer.valueOf(rankList.get(9).getMin()) * 60
				+ Integer.valueOf(rankList.get(9).getSec()));
	}

	public void readRank() {
			try {
				String filename = "src/helicopterbattle/ranking.txt";
				FileReader fileReader = new FileReader(filename);
				BufferedReader buffer = new BufferedReader(fileReader);
				rankList = new ArrayList<RankVO>();
				String reader = new String();
				
				while (true) {
					reader = buffer.readLine();
					if (reader == null)
						break;
					String[] rank = reader.split(":");
					rankList.add(new RankVO(rank[0], rank[1], rank[2], rank[3]));
				}
				buffer.close();
				fileReader.close();
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			}
	}

	// compare R1 (min*60)+sec R2 (min*60)+sec
	class compareSec implements Comparator<RankVO> {
		@Override
		public int compare(RankVO R1, RankVO R2) {
			return Integer.valueOf(Integer.valueOf(R2.getMin()) * 60 + R2.getSec())
					.compareTo(Integer.valueOf(Integer.valueOf(R1.getMin()) * 60 + R1.getSec()));
		}
	}

	public void drawRanking(Graphics2D g2d) {
		g2d.draw(rankingBoard);
		g2d.drawImage(RankBoardImg, rankingBoard.x, rankingBoard.y, rankingBoard.width, rankingBoard.height, null);
		g2d.setFont(new Font("±Ã¼­", Font.BOLD, 35));
		g2d.setPaint(Color.white);
		g2d.drawString("NAME TIME STAGE", frameWidth / 2 - 180, frameHeight / 2 - 250);
		g2d.setFont(new Font("monospaced", Font.BOLD, 30));
		g2d.setPaint(Color.black);
		int Y = 0;
		int RANKING = 1;
		readRank();
		for (RankVO a : rankList) {
			g2d.drawString(RANKING + "." + a.toString(), frameWidth / 2 - 170, frameHeight / 2 - 200 + Y);
			RANKING++;
			Y += 40;
		}
		g2d.draw(backButton);
		g2d.drawImage(backImg, backButton.x, backButton.y, backButton.width, backButton.height, null);

	}

	int playCount = 0;

	public Rectangle getRankButton() {return rankButton;}
	public ArrayList<RankVO> getRankList() {return rankList;}

	class RankVO {

		private String name;
		private String min;
		private String sec;
		private String stage;

		public RankVO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public RankVO(String name, String min, String sec, String stage) {
			super();
			this.name = name;
			this.min = min;
			this.sec = sec;
			this.stage = stage;
		}

		public String getName() {return name;}
		public void setName(String name) {this.name = name;}
		public String getMin() {return min;}
		public void setMin(String min) {this.min = min;}
		public String getSec() {return sec;}
		public void setSec(String sec) {this.sec = sec;}
		public String getStage() {return stage;}
		public void setStage(String stage) {this.stage = stage;}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(this.name).append("    ");
			sb.append(this.min).append(":");
			sb.append(this.sec).append("      ");
			sb.append(this.stage);
			return sb.toString();
		}
	}
}
