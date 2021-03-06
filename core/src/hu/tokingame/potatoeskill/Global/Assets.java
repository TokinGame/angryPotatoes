//https://github.com/tuskeb/mester
package hu.tokingame.potatoeskill.Global;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
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


	public static final AssetDescriptor<Texture> TOKIN = new AssetDescriptor<Texture>("GameTextures/tokin.png", Texture.class);
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
	public static final AssetDescriptor<Texture> CAT= new AssetDescriptor<Texture>("GameTextures/cat_cut.png", Texture.class);
	public static final AssetDescriptor<Texture> REDX= new AssetDescriptor<Texture>("GameTextures/redx.png", Texture.class);
	public static final AssetDescriptor<Texture> REDBOX= new AssetDescriptor<Texture>("GameTextures/control_area.png", Texture.class);
	public static final AssetDescriptor<Texture> TILTARROW = new AssetDescriptor<Texture>("GameTextures/tilt_arrow.png", Texture.class);
	public static final AssetDescriptor<Texture> WIND_ARROW = new AssetDescriptor<Texture>("GameTextures/arrow.png", Texture.class);


	public static final AssetDescriptor<Texture> TABLET = new AssetDescriptor<Texture>("GameTextures/how_to_tablet.png", Texture.class);
	public static final AssetDescriptor<Texture> WOOD_BG = new AssetDescriptor<Texture>("GameTextures/woodd.jpg", Texture.class);


	public static final AssetDescriptor<Texture> NUKE = new AssetDescriptor<Texture>("GameTextures/nuke.png", Texture.class);
	public static final AssetDescriptor<Texture> POTATO_FAMILY = new AssetDescriptor<Texture>("GameTextures/potatoes.png", Texture.class);



	public static final AssetDescriptor<Texture>[] ICONS = new AssetDescriptor[]{
			new AssetDescriptor<Texture>("LevelIcons/1.png", Texture.class),
			new AssetDescriptor<Texture>("LevelIcons/2.png", Texture.class),
			new AssetDescriptor<Texture>("LevelIcons/3.png", Texture.class),
			new AssetDescriptor<Texture>("LevelIcons/4.png", Texture.class),
			new AssetDescriptor<Texture>("LevelIcons/5.png", Texture.class),
			new AssetDescriptor<Texture>("LevelIcons/6.png", Texture.class),
			new AssetDescriptor<Texture>("LevelIcons/7.png", Texture.class),
			new AssetDescriptor<Texture>("LevelIcons/8.png", Texture.class),
			new AssetDescriptor<Texture>("LevelIcons/9.png", Texture.class),
			new AssetDescriptor<Texture>("LevelIcons/10.png", Texture.class),
			new AssetDescriptor<Texture>("LevelIcons/11.png", Texture.class),
			new AssetDescriptor<Texture>("LevelIcons/12.png", Texture.class),
			new AssetDescriptor<Texture>("LevelIcons/13.png", Texture.class),
			new AssetDescriptor<Texture>("LevelIcons/14.png", Texture.class),
			new AssetDescriptor<Texture>("LevelIcons/15.png", Texture.class)
	};



    public static final AssetDescriptor<Sound> LAUNCH_SOUND = new AssetDescriptor<Sound>("Sounds/rpg_cut.wav", Sound.class);
    public static final AssetDescriptor<Sound> EXPLOSION_SOUND1 = new AssetDescriptor<Sound>("Sounds/blast.wav", Sound.class);
    public static final AssetDescriptor<Sound> EXPLOSION_SOUND2 = new AssetDescriptor<Sound>("Sounds/grenade_explosion_alt.wav", Sound.class);
    public static final AssetDescriptor<Sound> EXPLOSION_SOUND3 = new AssetDescriptor<Sound>("Sounds/grenade_explosion.wav", Sound.class);

	public static final AssetDescriptor<Music> MAIN_MUSIC = new AssetDescriptor<Music>("Sounds/bensound-instinct.mp3", Music.class);

    public static void prepare() {
		manager = new AssetManager();
		Texture.setAssetManager(manager);
	}

	public static void load() {
		FileHandleResolver resolver = new InternalFileHandleResolver();
		manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
		manager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));

		manager.load(TOKIN);


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
		manager.load(CAT);
		manager.load(REDX);
		manager.load(REDBOX);
		manager.load(TILTARROW);
		manager.load(TABLET);
		manager.load(WOOD_BG);

		manager.load(NUKE);
		manager.load(POTATO_FAMILY);

		manager.load(WIND_ARROW);

		for (AssetDescriptor<Texture> texture: ICONS) {
			manager.load(texture);
		}

        manager.load(LAUNCH_SOUND);
        manager.load(EXPLOSION_SOUND1);
        manager.load(EXPLOSION_SOUND2);
        manager.load(EXPLOSION_SOUND3);

		manager.load(MAIN_MUSIC);

		manager.load(EXPLOSION_TEXTUREATLAS);



		manager.load(CALIBRIL_FONT);
		manager.load(ZOLISCREENSHOT);



	}

    public static void afterLoaded() {
		manager.get(MAIN_MUSIC).setLooping(true);
		if(Globals.music){
			manager.get(MAIN_MUSIC).play();
		}
        //manager.get(MUSIC).setLooping(true);
    }

	public static void unload() {
		manager.dispose();
	}

}
