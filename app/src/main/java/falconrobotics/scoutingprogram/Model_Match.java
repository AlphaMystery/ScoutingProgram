package falconrobotics.scoutingprogram;

/**
 * Created on 2/24/2016.
 *
 * Structure for how the data is going to be inputted into the match table.
 */
public class Model_Match {
    private int _id,
            teamNum,
            autoDef1Miss,
            autoDef1Hit,
            autoDef2Miss,
            autoDef2Hit,
            autoDef3Miss,
            autoDef3Hit,
            autoDef4Miss,
            autoDef4Hit,
            autoDef5Miss,
            autoDef5Hit,
            autoLowMiss,
            autoLowHit,
            autoHighMiss,
            autoHighHit,
            teleLowMiss,
            teleLowHit,
            teleHighMiss,
            teleHighHit,
            teleLowBarMiss,
            teleLowBarHit,
            teleDrawbridgeMiss,
            teleDrawbridgeHit,
            teleSallyPortMiss,
            teleSallyPortHit,
            safeSpot,
            climb,
            syncNum;

    public Model_Match(
            int _id,            //1
            int teamNum,        //2
            int autoDef1Miss,   //3
            int autoDef1Hit,    //4
            int autoDef2Miss,   //5
            int autoDef2Hit,    //6
            int autoDef3Miss,   //7
            int autoDef3Hit,    //8
            int autoDef4Miss,   //9
            int autoDef4Hit,    //10
            int autoDef5Miss,   //11
            int autoDef5Hit,    //12
            int autoLowMiss,    //13
            int autoLowHit,     //14
            int autoHighMiss,   //15
            int autoHighHit,    //16
            int teleLowMiss,    //17
            int teleLowHit,     //18
            int teleHighMiss,   //19
            int teleHighHit,    //20
            int teleLowBarMiss,     //21
            int teleLowBarHit,
            int teleDrawbridgeMiss, //22
            int teleDrawbridgeHit,
            int teleSallyPortMiss,  //23
            int teleSallyPortHit,
            int safeSpot,
            int climb,          //25
            int syncNum)        //27
    {
        this._id = _id;
        this.teamNum = teamNum;
        this.autoDef1Miss = autoDef1Miss;
        this.autoDef1Hit = autoDef1Hit;
        this.autoDef2Miss = autoDef2Miss;
        this.autoDef2Hit = autoDef2Hit;
        this.autoDef3Miss = autoDef3Miss;
        this.autoDef3Hit = autoDef3Hit;
        this.autoDef4Miss = autoDef4Miss;
        this.autoDef4Hit = autoDef4Hit;
        this.autoDef5Miss = autoDef5Miss;
        this.autoDef5Hit = autoDef5Hit;
        this.autoLowMiss = autoLowMiss;
        this.autoLowHit = autoLowHit;
        this.autoHighMiss = autoHighMiss;
        this.autoHighHit = autoHighHit;
        this.teleLowMiss = teleLowMiss;
        this.teleLowHit = teleLowHit;
        this.teleHighMiss = teleHighMiss;
        this.teleHighHit = teleHighHit;
        this.teleLowBarMiss = teleLowBarMiss;
        this.teleLowBarHit = teleLowBarHit;
        this.teleDrawbridgeMiss = teleDrawbridgeMiss;
        this.teleDrawbridgeHit = teleDrawbridgeHit;
        this.teleSallyPortMiss = teleSallyPortMiss;
        this.teleSallyPortHit = teleSallyPortHit;
        this.safeSpot = safeSpot;
        this.climb = climb;
        this.syncNum = syncNum;
    }

    public int get_id() {
        return _id;
    }

    public int getTeamNum() {
        return teamNum;
    }

    public int getAutoDef1Miss() {
        return autoDef1Miss;
    }

    public int getAutoDef1Hit() {
        return autoDef1Hit;
    }

    public int getAutoDef2Miss() {
        return autoDef2Miss;
    }

    public int getAutoDef2Hit() {
        return autoDef2Hit;
    }

    public int getAutoDef3Miss() {
        return autoDef3Miss;
    }

    public int getAutoDef3Hit() {
        return autoDef3Hit;
    }

    public int getAutoDef4Miss() {
        return autoDef4Miss;
    }

    public int getAutoDef4Hit() {
        return autoDef4Hit;
    }

    public int getAutoDef5Miss() {
        return autoDef5Miss;
    }

    public int getAutoDef5Hit() {
        return autoDef5Hit;
    }

    public int getAutoLowMiss() {
        return autoLowMiss;
    }

    public int getAutoLowHit() {
        return autoLowHit;
    }

    public int getAutoHighMiss() {
        return autoHighMiss;
    }

    public int getAutoHighHit() {
        return autoHighHit;
    }

    public int getTeleLowMiss() {
        return teleLowMiss;
    }

    public int getTeleLowHit() {
        return teleLowHit;
    }

    public int getTeleHighMiss() {
        return teleHighMiss;
    }

    public int getTeleHighHit() {
        return teleHighHit;
    }

    public int getTeleLowBarMiss() {
        return teleLowBarMiss;
    }

    public int getTeleLowBarHit() {
        return teleLowBarHit;
    }

    public int getTeleDrawbridgeMiss() {
        return teleDrawbridgeMiss;
    }

    public int getTeleDrawbridgeHit() {
        return teleDrawbridgeHit;
    }

    public int getTeleSallyPortMiss() {
        return teleSallyPortMiss;
    }

    public int getTeleSallyPortHit() {
        return teleSallyPortHit;
    }

    public int getSafeSpot() {
        return safeSpot;
    }

    public int getClimb() {
        return climb;
    }

    public int getSyncNum() {
        return syncNum;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setTeamNum(int teamNum) {
        this.teamNum = teamNum;
    }

    public void setAutoDef1Miss(int autoDef1Miss) {
        this.autoDef1Miss = autoDef1Miss;
    }

    public void setAutoDef1Hit(int autoDef1Hit) {
        this.autoDef1Hit = autoDef1Hit;
    }

    public void setAutoDef2Miss(int autoDef2Miss) {
        this.autoDef2Miss = autoDef2Miss;
    }

    public void setAutoDef2Hit(int autoDef2Hit) {
        this.autoDef2Hit = autoDef2Hit;
    }

    public void setAutoDef3Miss(int autoDef3Miss) {
        this.autoDef3Miss = autoDef3Miss;
    }

    public void setAutoDef3Hit(int autoDef3Hit) {
        this.autoDef3Hit = autoDef3Hit;
    }

    public void setAutoDef4Miss(int autoDef4Miss) {
        this.autoDef4Miss = autoDef4Miss;
    }

    public void setAutoDef4Hit(int autoDef4Hit) {
        this.autoDef4Hit = autoDef4Hit;
    }

    public void setAutoDef5Miss(int autoDef5Miss) {
        this.autoDef5Miss = autoDef5Miss;
    }

    public void setAutoDef5Hit(int autoDef5Hit) {
        this.autoDef5Hit = autoDef5Hit;
    }

    public void setAutoLowMiss(int autoLowMiss) {
        this.autoLowMiss = autoLowMiss;
    }

    public void setAutoLowHit(int autoLowHit) {
        this.autoLowHit = autoLowHit;
    }

    public void setAutoHighMiss(int autoHighMiss) {
        this.autoHighMiss = autoHighMiss;
    }

    public void setAutoHighHit(int autoHighHit) {
        this.autoHighHit = autoHighHit;
    }

    public void setTeleLowMiss(int teleLowMiss) {
        this.teleLowMiss = teleLowMiss;
    }

    public void setTeleLowHit(int teleLowHit) {
        this.teleLowHit = teleLowHit;
    }

    public void setTeleHighMiss(int teleHighMiss) {
        this.teleHighMiss = teleHighMiss;
    }

    public void setTeleHighHit(int teleHighHit) {
        this.teleHighHit = teleHighHit;
    }

    public void setTeleLowBarMiss(int teleLowBarMiss) {
        this.teleLowBarMiss = teleLowBarMiss;
    }

    public void setTeleLowBarHit(int teleLowBarHit) {
        this.teleLowBarHit = teleLowBarHit;
    }

    public void setTeleDrawbridgeMiss(int teleDrawbridgeMiss) {
        this.teleDrawbridgeMiss = teleDrawbridgeMiss;
    }

    public void setTeleDrawbridgeHit(int teleDrawbridgeHit) {
        this.teleDrawbridgeHit = teleDrawbridgeHit;
    }

    public void setTeleSallyPortMiss(int teleSallyPortMiss) {
        this.teleSallyPortMiss = teleSallyPortMiss;
    }

    public void setTeleSallyPortHit(int teleSallyPortHit) {
        this.teleSallyPortHit = teleSallyPortHit;
    }

    public void setSafeSpot(int safeSpot) {
        this.safeSpot = safeSpot;
    }

    public void setClimb(int climb) {
        this.climb = climb;
    }

    public void setSyncNum(int syncNum) {
        this.syncNum = syncNum;
    }
}