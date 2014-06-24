package com.jori.dwai.util;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class MapReader {
	
	
	 private static int getRed(int rgbValue) {
		 return (rgbValue >> 16) & 0xFF;
	 }
	   

	 private static int getGreen(int rgbValue) {
		 return (rgbValue >> 8) & 0xFF;
	 }

	 private static int getBlue(int rgbValue) {
		 return (rgbValue >> 0) & 0xFF;
	 }
	 
	private static BufferedImage loadImage(File f) throws Exception{

		BufferedImage paintImage = ImageIO.read(f);
		
		if(paintImage.getHeight() != 32 && paintImage.getWidth() != 32){
			throw new Exception("Image dimensions incorrect!");
		}
		return paintImage;
	}
	public static Tile[][] read(File file){
		
		BufferedImage paintImage = null;
		try{
			paintImage = loadImage(file);
		}catch(Exception e){
		
			Logger.logErr("Was not able to read image located at " + file.getAbsolutePath() + "\n Cause: " + e.getCause(),MapReader.class);
		}
		Tile[][] tileMap = new Tile[paintImage.getHeight()][paintImage.getWidth()];
		for(int x = 0; x < paintImage.getWidth();x++){
			for(int y = 0 ; y < paintImage.getHeight();y++){
				
				Tile workingTile = new Tile(x,y);
				int rgbValue = paintImage.getRGB(x, y);
				
				int red = getRed(rgbValue);
				int blue = getBlue(rgbValue);
				int green = getGreen(rgbValue);
				
				if(green == 255 && blue + red == 0){
					workingTile.setLandType(LANDTYPE.GRASS);
				}
				//							  V -----V-----V---DENOTES WHITE COLOR
				else if(green + red + blue == 255 + 255 + 255){
					workingTile.setLandType(LANDTYPE.CLEAR);
				}
				
				//          				  V---V---V---DENOTES BLACK COLOR
				else if(green + red + blue == 0 + 0 + 0){
					workingTile.setLandType(LANDTYPE.WALL);
				}
				tileMap[x][y] = workingTile;
			}
		}
		
		return tileMap;
		
	}
		
	
	
	public enum LANDTYPE {
		

		GRASS,
		WALL,
		CLEAR
		//TODO: add more types of land
		
	}
	
}
