package com.anish.screen;

import java.awt.Color;
import java.awt.event.KeyEvent;

import com.anish.monsters.BubbleSorter;
import com.anish.monsters.Monster;
import com.anish.monsters.World;

import asciiPanel.AsciiPanel;

import  com.anish.monsters.ColorGenerator;
public class WorldScreen implements Screen {
    public static final int MATRIXROW = 8;
    public static final int MATRIXCOL = 8;

    private World world;
    private Monster[][] monsters;
    String[] sortSteps;

    public WorldScreen() {
        world = new World();
        var it = ColorGenerator.iterator();
        monsters = new Monster[MATRIXROW][MATRIXCOL];
        int beginX = 8;
        int beginY = 8;
        for(int i = 0; i < MATRIXROW; i++)
            for(int j = 0; j < MATRIXCOL; j++){
                monsters[i][j] = new Monster(it.next(), world);
                world.put(monsters[i][j], beginX + j * 2, beginY + i * 2);
            }

        BubbleSorter<Monster> b = new BubbleSorter<>();

        b.load(monsters);
        b.sort();

        sortSteps = this.parsePlan(b.getPlan());
    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(Monster[][] monsters, String step) {
        String[] couple = step.split("<->");
        getBroByRank(monsters, Integer.parseInt(couple[0])).swap(getBroByRank(monsters, Integer.parseInt(couple[1])));
    }

    private Monster getBroByRank(Monster[][] monsters, int rank) {
        for (Monster[] monster1 : monsters) {
            for(Monster monster : monster1)
                    if (monster.getRank() == rank) {
                        return monster;
                }
            }
        return null;
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {

        for (int x = 0; x < World.WIDTH; x++) {
            for (int y = 0; y < World.HEIGHT; y++) {

                terminal.write(world.get(x, y).getGlyph(), x, y, world.get(x, y).getColor());

            }
        }
    }

    int i = 0;

    @Override
    public Screen respondToUserInput(KeyEvent key) {

        if (i < this.sortSteps.length) {
            this.execute(monsters, sortSteps[i]);
            i++;
        }

        return this;
    }

}
