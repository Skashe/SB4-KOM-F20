package dk.sdu.mmmi.OSGiAsteroids;

import dk.sdu.mmmi.OSGiCommon.data.Entity;
import dk.sdu.mmmi.OSGiCommon.data.entityparts.MovingPart;

import java.util.Random;


public class Asteroid extends Entity {

    private final AsteroidType type;
    private final int extraPoints;
    float angle;

    public Asteroid(AsteroidType type) {
        this.type = type;
        this.extraPoints = new Random().nextInt(3);
        this.angle = (float) Math.random() * (float) Math.random();
    }

    public int getSize() {
        return type.getSize();
    }

    public int getPoints(){
        return type.getPoints() + extraPoints;
    }

    public float getSpeed(){
        return type.getSpeed();
    }

    public int getLife(){
        return type.getLife();
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }
}
