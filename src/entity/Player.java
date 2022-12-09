package entity;

import controller.Controller;
import gfx.SpriteLibrary;

public class Player extends MovingEntity {
    private double experience;
    private double Objectcoins;
    private int daysPlaying;
    private int level;
    private String farmerType;
    private int farmerTypeInt;
    private int bonusEarning;
    private int seedCostReduction;
    private int waterBonusLimit;
    private int fertilizerBonusLimit;
    public Player(Controller controller, SpriteLibrary spriteLibrary) {
        super(controller, spriteLibrary);
        this.objectName = "player";
        experience = 0;
        Objectcoins = 100;
        level = 0;
        daysPlaying = 1;
        farmerType = "Farmer";
        farmerTypeInt = 1;
        bonusEarning = 0;
        seedCostReduction = 0;
        waterBonusLimit = 0;
        fertilizerBonusLimit = 0;
    }
    @Override
    public void update() {
        super.update();
    }

    /**
     * Update player's farmer type
     *
     * @param type the type of farmer represented in int
     */
    public void updateFarmerType(int type) {
        if (type == 1 && Objectcoins >= 200 && farmerTypeInt == 1 && level >= 5) {
            Objectcoins -= 200;
            farmerType = "Registered Farmer";
            bonusEarning = 1;
            seedCostReduction = 1;
            farmerTypeInt = 2;
            System.out.printf("\nCongratulations for being a Registered Farmer! You have now access to +%d bonus earning per produce and -%d seed cost reduction.\n", bonusEarning, seedCostReduction);
        } else if (type == 2 && Objectcoins >= 300 && farmerTypeInt <= 2 && level >= 10) {
            Objectcoins -= 300;
            bonusEarning = 2;
            farmerType = "Distinguished Farmer";
            seedCostReduction = 2;
            waterBonusLimit = 1;
            farmerTypeInt = 3;
            System.out.printf("\nCongratulations for being a Distinguished Farmer! You have now access to +%d bonus earning per produce, -%d seed cost reduction, and +%d water bonus limit increase.\n" , bonusEarning, seedCostReduction, waterBonusLimit);
        } else if (type == 3 && Objectcoins >= 400 && farmerTypeInt <= 3 && level >= 15) {
            Objectcoins -= 400;
            bonusEarning = 4;
            farmerType = "Legendary Farmer";
            seedCostReduction = 3;
            waterBonusLimit = 2;
            fertilizerBonusLimit = 1;
            farmerTypeInt = 4;
            System.out.printf("\nCongratulations for being a Legendary Farmer! You have now access to +%d bonus earning per produce, -%d seed cost reduction, +%d water bonus limit increase, and +%d fertilizer bonus limit increase.\n" , bonusEarning, seedCostReduction, waterBonusLimit, fertilizerBonusLimit);
        } else if ((type == 1 && Objectcoins < 200) || (type == 2 && Objectcoins < 300) || (type == 3 && Objectcoins < 400)) {
            System.out.println("You don't have enough Objectcoins.");
        } else {
            System.out.println("Unknown command: " + type);
        }
    }

    /**
     * Update player's level
     */
    public void updateLevel() {
        if ((int) (experience / 100) == level + 1) {
            System.out.println("\nYou have leveled up!");
            level++;
        }
    }

    //Getters and Setters
    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public double getObjectcoins() {
        return Objectcoins;
    }

    public void setObjectcoins(double objectcoins) {
        this.Objectcoins = objectcoins;
    }

    public int getDaysPlaying() {
        return daysPlaying;
    }

    public void setDaysPlaying(int daysPlaying) {
        this.daysPlaying = daysPlaying;
    }

    public int getLevel() {
        return level;
    }

    public int getBonusEarning() {
        return bonusEarning;
    }

    public int getSeedCostReduction() {
        return seedCostReduction;
    }

    public int getWaterBonusLimit() {
        return waterBonusLimit;
    }

    public int getFertilizerBonusLimit() {
        return fertilizerBonusLimit;
    }

    public int getFarmerTypeInt() {
        return farmerTypeInt;
    }
}
