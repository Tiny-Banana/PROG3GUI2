package gfx;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SpriteLibrary {

    private Map<String, SpriteSet> units;
    private Map<String, Image> tiles;

    public SpriteLibrary() {
        units = new HashMap<>();
        tiles = new HashMap<>();
        loadSpritesFromDisk();
    }

    private void loadSpritesFromDisk() {
        loadUnits("/sprites/units");
        loadTiles("/sprites/tiles");
    }

    private void loadTiles(String path) {
        String[] imagesInFolder = getImagesInFolder(path);

        for(String filename: imagesInFolder) {
            tiles.put(
                    filename.substring(0, filename.length() - 4),
                    ImageUtils.loadImage(path + "/" + filename));
        }
    }

    private void loadUnits(String path) {
        String[] folderNames = getFolderNames(path);

        for(String folderName: folderNames) {
            SpriteSet spriteSet = new SpriteSet();
            String pathToFolder = path + "/" + folderName;
            String[] imagesInFolder = getImagesInFolder(pathToFolder);

            for(String fileName: imagesInFolder) {
                spriteSet.addSheet(
                        fileName.substring(0, fileName.length() - 4),
                        ImageUtils.loadImage(pathToFolder + "/" + fileName));
            }

            units.put(folderName, spriteSet);
        }
    }

    private String[] getImagesInFolder(String basePath) {
        URL resource = SpriteLibrary.class.getResource(basePath);
        File file;
        try
        {
            file = new File(resource.toURI());
        } catch (java.net.URISyntaxException e) {
            return new String[0];
        }
        return file.list((current, name) -> new File(current, name).isFile());
    }

    private String[] getFolderNames(String basePath) {
        URL resource = SpriteLibrary.class.getResource(basePath);
        File file;
        try
        {
            file = new File(resource.toURI());
        } catch (java.net.URISyntaxException e) {
            return new String[0];
        }
        return file.list((current, name) -> new File(current, name).isDirectory());
    }

    public SpriteSet getUnit(String name) {
        return units.get(name);
    }

    public Image getTile(String name) {
        return tiles.get(name);
    }
}
