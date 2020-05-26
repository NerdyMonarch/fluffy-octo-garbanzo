import java.awt.image.BufferedImage;

public abstract class Tile {
    protected BufferedImage tile;
    protected TileID id;

    public Tile(BufferedImage tile, TileID id) {
        this.tile = tile;
        this.id = id;
    }

    public BufferedImage getImage() {
        return tile;
    }
}