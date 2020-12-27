package util;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class TexturePackerTool {

	public static void main(String[] args) {
		
		TexturePacker.process(	"res/Characters/Cony/unpacked/", 
								"res/Characters/Cony/packed/", 
								"textures");
	}
}
