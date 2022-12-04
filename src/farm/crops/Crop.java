package farm.crops;

import entity.GameObject;

/**
 * This class handles the crop that will be planted to the tile
 *
 * @author Jomar Delos Reyes
 * @version 1.0
 * @since 11/07/2022
 */
public abstract class Crop {
    protected String name;
    protected String cropType;
    protected int harvestTime;
    protected int seedCost;
    protected double experienceGain;
    protected int water;
    protected int waterNeeded;
    protected int waterLimit;
    protected int fertilizer;
    protected int fertilizerNeeded;
    protected int fertilizerLimit;
    protected boolean isWithered;
    protected int daysPlanted;
    protected int maxProduce;
    protected int basePrice;

    //Getters and Setters
    public String getName() {
        return name;
    }

    public String getCropType() {
        return cropType;
    }

    public double getHarvestTime() {
        return harvestTime;
    }

    public int getSeedCost() {
        return seedCost;
    }

    public double getExperienceGain() {
        return experienceGain;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getWaterNeeded() {
        return waterNeeded;
    }

    public int getFertilizer() {
        return fertilizer;
    }

    public void setFertilizer(int fertilizer) {
        this.fertilizer = fertilizer;
    }

    public int getFertilizerNeeded() {
        return fertilizerNeeded;
    }

    public boolean getIsWithered() {
        return isWithered;
    }

    public void setIsWithered(boolean isWithered) {
        this.isWithered = isWithered;
    }

    public int getDaysPlanted() {
        return daysPlanted;
    }

    public void setDaysPlanted(int daysPlanted) {
        this.daysPlanted = daysPlanted;
    }

    public int getWaterLimit() {
        return waterLimit;
    }

    public int getFertilizerLimit() {
        return fertilizerLimit;
    }

    public int getMaxProduce() {
        return maxProduce;
    }

    public int getBasePrice() {
        return basePrice;
    }
}