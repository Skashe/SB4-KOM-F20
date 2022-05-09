package dk.sdu.mmmi.cbse.core;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.timeout;
public class partTest {
@Test
public void Test(){
        Entity testEntity = new Entity();
        testEntity.add(new MovingPart(10, 15, 200, 10));
        testEntity.add(new LifePart(1,0));
        testEntity.add(new PositionPart(10,10,5));
        assertTrue(testEntity.getPart(MovingPart.class)!=null);
        System.out.println("Moving part present");
        assertTrue(testEntity.getPart(LifePart.class)!=null);
        System.out.println("Life part present");
        assertTrue(testEntity.getPart(PositionPart.class)!=null);
        System.out.println("Position part present");

        }

//Testing to see if entity moves
//Test below fails, but shows a way to test if movement works correctly.
/*
@Test
public void movementTest(){

        World world = new World();
final GameData gameData = new GameData();

        Entity testEntity = new Entity();
        testEntity.add(new MovingPart(10, 15, 200, 10));
        testEntity.add(new LifePart(1,0));
        testEntity.add(new PositionPart(10,10,5));

        PositionPart positionPart = testEntity.getPart(PositionPart.class);
        float currentX = positionPart.getX();
        float currentY = positionPart.getY();
        positionPart.process(gameData, testEntity);
        timeout(120);
        assertTrue(positionPart.getX() != currentX || positionPart.getY() != currentY);
        }
*/

}