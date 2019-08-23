package com.mcbodik.travbot.villages;

import java.util.Queue;

public class VillageModel {
    private String name;
    private int lumber;
    private int clay;
    private int iron;
    private int crop;

    private Queue<BuildingPlan> plannedBuildQueue;
    private ResourcesStrategy resourcesStrategy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLumber() {
        return lumber;
    }

    public void setLumber(int lumber) {
        this.lumber = lumber;
    }

    public int getClay() {
        return clay;
    }

    public void setClay(int clay) {
        this.clay = clay;
    }

    public int getIron() {
        return iron;
    }

    public void setIron(int iron) {
        this.iron = iron;
    }

    public int getCrop() {
        return crop;
    }

    public void setCrop(int crop) {
        this.crop = crop;
    }

    public Queue<?> getPlannedBuildQueue() {
        return plannedBuildQueue;
    }

    public void setPlannedBuildQueue(Queue<BuildingPlan> plannedBuildQueue) {
        this.plannedBuildQueue = plannedBuildQueue;
    }

    public ResourcesStrategy getResourcesStrategy() {
        return resourcesStrategy;
    }

    public void setResourcesStrategy(ResourcesStrategy resourcesStrategy) {
        this.resourcesStrategy = resourcesStrategy;
    }
}
