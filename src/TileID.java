public enum TileID {
    // List of IDs
    FLOOR0(0), FLOOR1(1), FLOOR2(2), FLOOR3(3), 
    FLOOR4(4), FLOOR5(5), FLOOR6(6), FLOOR7(7);

    // Holds ID Value of Tile
    private int value;

    private TileID(int value) {
        this.value = value;
    }

    // Returns Integer Assosiated with Tile
    public int getValue() {
        return value;
    }
}