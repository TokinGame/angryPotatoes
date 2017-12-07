//https://github.com/tuskeb/mester
package hu.tokingame.potatoeskill.Global;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;

public class Assets {
	// https://github.com/libgdx/libgdx/wiki/Managing-your-assets
	// http://www.jacobplaster.net/using-libgdx-asset-manager
	// https://www.youtube.com/watch?v=JXThbQir2gU
	// https://github.com/Matsemann/libgdx-loading-screen/blob/master/Main/src/com/matsemann/libgdxloadingscreen/screen/LoadingScreen.java

	public static AssetManager manager;
	public static final String CHARS = "0123456789öüóqwertzuiopőúasdfghjkléáűíyxcvbnm'+!%/=()ÖÜÓQWERTZUIOPŐÚASDFGHJKLÉÁŰÍYXCVBNM?:_*<>#&@{}[],-.";


	static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
	static {
		fontParameter.fontFileName = "calibril.ttf";
		fontParameter.fontParameters.size = 50;
		fontParameter.fontParameters.characters = CHARS;
		fontParameter.fontParameters.color = Color.WHITE;
	}
	public static final AssetDescriptor<BitmapFont> CALIBRIL_FONT = new AssetDescriptor<BitmapFont>(fontParameter.fontFileName, BitmapFont.class, fontParameter);

	public static final AssetDescriptor<TextureAtlas> EXPLOSION_TEXTUREATLAS = new AssetDescriptor<TextureAtlas>("GameTextures/explosion.txt", TextureAtlas.class);


	public static final AssetDescriptor<Texture> BADLOGIC_TEXTURE = new AssetDescriptor<Texture>("badlogic.jpg", Texture.class);
	public static final AssetDescriptor<Texture> CANNON = new AssetDescriptor<Texture>("GameTextures/cannon.png", Texture.class);
	public static final AssetDescriptor<Texture> POTATO = new AssetDescriptor<Texture>("GameTextures/potato.png", Texture.class);
	public static final AssetDescriptor<Texture> CRATE = new AssetDescriptor<Texture>("GameTextures/wooden-crate.png", Texture.class);
	public static final AssetDescriptor<Texture> ZOLISCREENSHOT = new AssetDescriptor<Texture>("GameTextures/empty.png", Texture.class);
    public static final AssetDescriptor<Texture> ENEMY = new AssetDescriptor<Texture>("GameTextures/enemy.png", Texture.class);
	public static final AssetDescriptor<Texture> BACKGROUND_1 = new AssetDescriptor<Texture>("GameTextures/bg_1.png", Texture.class);
	public static final AssetDescriptor<Texture> BACKGROUND_2 = new AssetDescriptor<Texture>("GameTextures/bg_2.jpg", Texture.class);
	public static final AssetDescriptor<Texture> BACKGROUND_3 = new AssetDescriptor<Texture>("GameTextures/bg_3.jpg", Texture.class);
	public static final AssetDescriptor<Texture> POWERBAR_BG = new AssetDescriptor<Texture>("GameTextures/powerbar_bg.png", Texture.class);
	public static final AssetDescriptor<Texture> POWERBAR = new AssetDescriptor<Texture>("GameTextures/powerbar.png", Texture.class);
	public static final AssetDescriptor<Texture> PREV_POWERBAR = new AssetDescriptor<Texture>("GameTextures/prevpowerbar.png", Texture.class);
	public static final AssetDescriptor<Texture> BANANA= new AssetDescriptor<Texture>("GameTextures/banana_for_scale.png", Texture.class);



    public static final AssetDescriptor<Sound> LAUNCH_SOUND = new AssetDescriptor<Sound>("Sounds/rpg_cut.wav", Sound.class);
    public static final AssetDescriptor<Sound> EXPLOSION_SOUND1 = new AssetDescriptor<Sound>("Sounds/blast.wav", Sound.class);
    public static final AssetDescriptor<Sound> EXPLOSION_SOUND2 = new AssetDescriptor<Sound>("Sounds/grenade_explosion_alt.wav", Sound.class);
    public static final AssetDescriptor<Sound> EXPLOSION_SOUND3 = new AssetDescriptor<Sound>("Sounds/grenade_explosion.wav", Sound.class);

    public static void prepare() {
		manager = new AssetManager();
		Texture.setAssetManager(manager);
	}

	public static void load() {
		FileHandleResolver resolver = new InternalFileHandleResolver();
		manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
		manager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));

		manager.load(BADLOGIC_TEXTURE);


		manager.load(CANNON);
		manager.load(POTATO);
		manager.load(CRATE);
        manager.load(ENEMY);
		manager.load(BACKGROUND_1);
		manager.load(BACKGROUND_2);
		manager.load(BACKGROUND_3);
		manager.load(POWERBAR);
		manager.load(POWERBAR_BG);
        manager.load(PREV_POWERBAR);
		manager.load(BANANA);

        manager.load(LAUNCH_SOUND);
        manager.load(EXPLOSION_SOUND1);
        manager.load(EXPLOSION_SOUND2);
        manager.load(EXPLOSION_SOUND3);

		manager.load(EXPLOSION_TEXTUREATLAS);


		manager.load(CALIBRIL_FONT);
		manager.load(ZOLISCREENSHOT);
	}

    public static void afterLoaded() {
		if(Globals.music){
			// TODO: 12/7/2017 MUzzzixxx
		}
        //manager.get(MUSIC).setLooping(true);
    }

	public static void unload() {
		manager.dispose();
	}

}
