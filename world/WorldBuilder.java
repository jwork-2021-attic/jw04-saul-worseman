package world;

import maze.MazeGenerator;
import screen.PlayScreen;
/*
 * Copyright (C) 2015 s-zhouj
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
/**
 *
 * @author s-zhouj
 */
public class WorldBuilder {

    private int col;
    private int row;
    private Tile[][] tiles;
    public WorldBuilder(int dim) {
        this.col = dim;
        this.row = dim;
        this.tiles = new Tile[row][col];
    }

    public World build() {
        return new World(tiles);
    }

    public WorldBuilder SetTiles() {
        MazeGenerator mazeGenerator = new MazeGenerator(14);
        //mazeGenerator.solve();
        mazeGenerator.draw();
        char[][]maze = mazeGenerator.getRawMaze();
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                if (maze[i * 2][j] == 'X') {
                    tiles[i][j] = Tile.WALL;
                }
                else if(maze[i * 2][j] == ' '){
                    tiles[i][j] = Tile.FLOOR;
                }
                else{
                    tiles[i][j] = Tile.PATH;
                }
            }
        }
        return this;
    }

}
