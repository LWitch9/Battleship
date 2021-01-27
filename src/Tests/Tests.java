package Tests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import Controller.Controller;
import Controller.Messages;
import GUI.View;
import Game.GameManagement;
import Game.WhichPlayer;
import ShipsManagement.ShipsManagement;
import org.junit.jupiter.api.Test;

public class Tests {

    private Controller controller;

    //Setting phase
    @Test
    public void settingShipOnOccupiedAreaShouldBeUnsuccessful(){
        ShipsManagement sm = new ShipsManagement(WhichPlayer.GRACZ1);
        sm.setShip(1,2,2,2);
        sm.setShip(1,2,2,2);
        assertEquals(Messages.UNAVAILABLE_COORDINATE_SET,sm.getResultCommunicat());
    }
    @Test
    public void settingShipOnAreaAroundSetShipShouldBeUnsuccessful(){
        ShipsManagement sm = new ShipsManagement(WhichPlayer.GRACZ1);
        sm.setShip(1,2,2,2);
        sm.setShip(1,3,2,3);
        assertEquals(Messages.UNAVAILABLE_COORDINATE_SET,sm.getResultCommunicat());
    }
    @Test
    public void settingShipInOrientationDifferentThenHorizontalVerticalShouldBeUnsuccessful(){
        ShipsManagement sm = new ShipsManagement(WhichPlayer.GRACZ1);
        sm.setShip(1,2,2,3);
        assertEquals(Messages.WRONG_ORIENTATION_SET,sm.getResultCommunicat());
        sm.setShip(1,3,2,2);
        assertEquals(Messages.WRONG_ORIENTATION_SET,sm.getResultCommunicat());
    }
    @Test
    public void settingShipOnAreaWhereShipOfSpecificLengthCouldntBeSetShouldBeSuccessfulForAvailableLength(){
        ShipsManagement sm = new ShipsManagement(WhichPlayer.GRACZ1);
        //Ships of length 1
        sm.setShip(6,5,6,5);
        sm.setShip(8,5,8,5);
        sm.setShip(10,5,10,5);
        sm.setShip(1,7,1,7);
        sm.setShip(10,1,10,1);
        assertEquals(Messages.WRONG_LENGTH,sm.getResultCommunicat());

        //Ships of length 2
        sm.setShip(10,1,10,2);
        assertEquals(Messages.SUCCESSFUL_SET,sm.getResultCommunicat());
    }
    @Test
    public void settingShipOfDifferentLengthThenIsAllowedShouldBeUnsuccessful(){
        ShipsManagement sm = new ShipsManagement(WhichPlayer.GRACZ1);
        sm.setShip(1,2,5,2);
        assertEquals(Messages.WRONG_LENGTH,sm.getResultCommunicat());

    }
    @Test
    public void settingOneMoreShipOfSpecificLengthThenRequiredShouldBeUnsuccessful(){
        ShipsManagement sm = new ShipsManagement(WhichPlayer.GRACZ1);
        //Ships of length 1
        sm.setShip(6,5,6,5);
        sm.setShip(8,5,8,5);
        sm.setShip(10,5,10,5);
        sm.setShip(1,7,1,7);
        sm.setShip(10,1,10,1);
        assertEquals(Messages.WRONG_LENGTH,sm.getResultCommunicat());

        //Ships of length 2
        sm.setShip(1,1,2,1);
        sm.setShip(4,1,5,1);
        sm.setShip(7,1,8,1);
        sm.setShip(10,1,10,2);
        assertEquals(Messages.WRONG_LENGTH,sm.getResultCommunicat());

        //Ships of length 3
        sm.setShip(1,3,3,3);
        sm.setShip(5,3,7,3);
        sm.setShip(10,1,10,3);
        assertEquals(Messages.WRONG_LENGTH,sm.getResultCommunicat());


    }
    @Test
    public void settingOneMoreShipThenRequiredShouldBeUnsuccessful(){
        ShipsManagement sm = new ShipsManagement(WhichPlayer.GRACZ1);
        //Ships of length 1
        sm.setShip(6,5,6,5);
        sm.setShip(8,5,8,5);
        sm.setShip(10,5,10,5);
        sm.setShip(1,7,1,7);

        //Ships of length 2
        sm.setShip(1,1,2,1);
        sm.setShip(4,1,5,1);
        sm.setShip(7,1,8,1);

        //Ships of length 3
        sm.setShip(1,3,3,3);
        sm.setShip(5,3,7,3);

        //Ships of length 4
        sm.setShip(1,5,4,5);
        sm.setShip(10,1,10,4);
        assertEquals(Messages.ALL_SHIPS_SET,sm.getResultCommunicat());

    }

    //Shooting phase
    @Test
    public void ShootFieldOccupiedByShipShouldGiveHitMessage(){
        ShipsManagement sm = this.settingUpForOnePlayer(WhichPlayer.GRACZ1);

        sm.hit(1,1);
        assertEquals(Messages.HIT_SHOOT,sm.getResultCommunicat());
    }
    @Test
    public void ShootLastFieldOccupiedByShipShouldGiveHitSunkMessage(){
        ShipsManagement sm = this.settingUpForOnePlayer(WhichPlayer.GRACZ1);

        sm.hit(6,5);
        assertEquals(Messages.HIT_SUNK_SHOOT,sm.getResultCommunicat());
    }
    @Test
    public void ShootNotOccupiedFieldShouldGiveMissMessage(){
        ShipsManagement sm = this.settingUpForOnePlayer(WhichPlayer.GRACZ1);

        sm.hit(7,5);
        assertEquals(Messages.MISS_SHOOT,sm.getResultCommunicat());
    }
    @Test
    public void ShootAllOpponentsShipsShouldGiveEndMessage(){
        ShipsManagement sm = this.settingUpForOnePlayer(WhichPlayer.GRACZ1);

        sm.hit(1,1);
        sm.hit(2,1);
        sm.hit(4,1);
        sm.hit(5,1);
        sm.hit(7,1);
        sm.hit(8,1);

        sm.hit(1,3);
        sm.hit(2,3);
        sm.hit(3,3);
        sm.hit(5,3);
        sm.hit(6,3);
        sm.hit(7,3);

        sm.hit(1,5);
        sm.hit(2,5);
        sm.hit(3,5);
        sm.hit(4,5);
        sm.hit(6,5);
        sm.hit(8,5);
        sm.hit(10,5);
        sm.hit(1,7);

        assertEquals(Messages.END,sm.getResultCommunicat());
    }

    private ShipsManagement settingUpForOnePlayer(WhichPlayer player){
        ShipsManagement sm = new ShipsManagement(player);
        //Ships of length 1
        sm.setShip(6,5,6,5);
        sm.setShip(8,5,8,5);
        sm.setShip(10,5,10,5);
        sm.setShip(1,7,1,7);

        //Ships of length 2
        sm.setShip(1,1,2,1);
        sm.setShip(4,1,5,1);
        sm.setShip(7,1,8,1);

        //Ships of length 3
        sm.setShip(1,3,3,3);
        sm.setShip(5,3,7,3);

        //Ships of length 4
        sm.setShip(1,5,4,5);
        sm.setShip(10,1,10,4);

        return sm;
    }



}
