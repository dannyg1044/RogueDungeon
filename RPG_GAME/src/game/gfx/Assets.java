package game.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	//private static final int width=200, height=255;
	
	public static BufferedImage slime, mage, knight, wall, floor, door, chest, play, quit,title, dagger, lightsaber, sword ;
	
	public static void init() {
		mage = ImageLoader.loadImage("/textures/mage.png");
		slime = ImageLoader.loadImage("/textures/slime.png");
		knight = ImageLoader.loadImage("/textures/knight.png");
		wall = ImageLoader.loadImage("/textures/wall.jpg");
		floor = ImageLoader.loadImage("/textures/floor.png");
		door = ImageLoader.loadImage("/textures/doortile.png");
		chest = ImageLoader.loadImage("/textures/chest.png");
		play = ImageLoader.loadImage("/textures/playButton.png");
		quit = ImageLoader.loadImage("/textures/quit.png");
		title = ImageLoader.loadImage("/textures/title.png");
		dagger = ImageLoader.loadImage("/textures/dagger.png");
		lightsaber = ImageLoader.loadImage("/textures/lightsaber.png");
		sword = ImageLoader.loadImage("/textures/sword.png");
	}

}
