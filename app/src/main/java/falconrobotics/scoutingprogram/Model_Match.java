package falconrobotics.scoutingprogram;

/**
 * Created on 2/24/2016.
 */
public class Model_Match {
    private int _id = 0,
            teamNum = 0,
            autoDef1 = 0,
            autoDef2 = 0,
            autoDef3 = 0,
            autoDef4 = 0,
            autoDef5 = 0,
            autoBoulder = 0,
            autoLowMiss = 0,
            autoLowMake = 0,
            autoHighMiss = 0,
            autoHighMake = 0,
            teleDef1Miss = 0,
            teleDef1Make = 0,
            teleDef2Miss = 0,
            teleDef2Make = 0,
            teleDef3Miss = 0,
            teleDef3Make = 0,
            teleDef4Miss = 0,
            teleDef4Make = 0,
            teleDef5Miss = 0,
            teleDef5Make = 0,
            teleLowMiss = 0,
            teleLowMake = 0,
            teleHighMiss = 0,
            teleHighMake = 0,
            boulderPass = 0,
            teleBlock1 = 0,
            teleBlock2 = 0,
            teleBlock3 = 0,
            climb = 0,
            challenged = 0,
            scoreTotal = 0,
            scoreAuto = 0,
            scoreFoul = 0,
            carded = 0,
            stopped = 0,
            syncNum = 0;

    private String comments;

    public int getAutoDef1() {
        return autoDef1;
    }

    public void setAutoDef1(int autoDef1) {
        this.autoDef1 = autoDef1;
    }

    public int getAutoDef2() {
        return autoDef2;
    }

    public void setAutoDef2(int autoDef2) {
        this.autoDef2 = autoDef2;
    }

    public int getAutoDef3() {
        return autoDef3;
    }

    public void setAutoDef3(int autoDef3) {
        this.autoDef3 = autoDef3;
    }

    public int getAutoDef4() {
        return autoDef4;
    }

    public void setAutoDef4(int autoDef4) {
        this.autoDef4 = autoDef4;
    }

    public int getAutoDef5() {
        return autoDef5;
    }

    public void setAutoDef5(int autoDef5) {
        this.autoDef5 = autoDef5;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getTeamNum() {
        return teamNum;
    }

    public void setTeamNum(int teamNum) {
        this.teamNum = teamNum;
    }

    public int getAutoBoulder() {
        return autoBoulder;
    }

    public void setAutoBoulder(int autoBoulder) {
        this.autoBoulder = autoBoulder;
    }

    public int getAutoHighMake() {
        return autoHighMake;
    }

    public void setAutoHighMake(int autoHighMake) {
        this.autoHighMake = autoHighMake;
    }

    public int getAutoHighMiss() {
        return autoHighMiss;
    }

    public void setAutoHighMiss(int autoHighMiss) {
        this.autoHighMiss = autoHighMiss;
    }

    public int getAutoLowMake() {
        return autoLowMake;
    }

    public void setAutoLowMake(int autoLowMake) {
        this.autoLowMake = autoLowMake;
    }

    public int getAutoLowMiss() {
        return autoLowMiss;
    }

    public void setAutoLowMiss(int autoLowMiss) {
        this.autoLowMiss = autoLowMiss;
    }

    public int getBoulderPass() {
        return boulderPass;
    }

    public void setBoulderPass(int boulderPass) {
        this.boulderPass = boulderPass;
    }

    public int getCarded() {
        return carded;
    }

    public void setCarded(int carded) {
        this.carded = carded;
    }

    public int getChallenged() {
        return challenged;
    }

    public void setChallenged(int challenged) {
        this.challenged = challenged;
    }

    public int getClimb() {
        return climb;
    }

    public void setClimb(int climb) {
        this.climb = climb;
    }

    public int getScoreAuto() {
        return scoreAuto;
    }

    public void setScoreAuto(int scoreAuto) {
        this.scoreAuto = scoreAuto;
    }

    public int getScoreFoul() {
        return scoreFoul;
    }

    public void setScoreFoul(int scoreFoul) {
        this.scoreFoul = scoreFoul;
    }

    public int getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(int scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    public int getStopped() {
        return stopped;
    }

    public void setStopped(int stopped) {
        this.stopped = stopped;
    }

    public int getSyncNum() {
        return syncNum;
    }

    public void setSyncNum(int syncNum) {
        this.syncNum = syncNum;
    }

    public int getTeleBlock1() {
        return teleBlock1;
    }

    public void setTeleBlock1(int teleBlock1) {
        this.teleBlock1 = teleBlock1;
    }

    public int getTeleBlock2() {
        return teleBlock2;
    }

    public void setTeleBlock2(int teleBlock2) {
        this.teleBlock2 = teleBlock2;
    }

    public int getTeleBlock3() {
        return teleBlock3;
    }

    public void setTeleBlock3(int teleBlock3) {
        this.teleBlock3 = teleBlock3;
    }

    public int getTeleDef1Make() {
        return teleDef1Make;
    }

    public void setTeleDef1Make(int teleDef1Make) {
        this.teleDef1Make = teleDef1Make;
    }

    public int getTeleDef1Miss() {
        return teleDef1Miss;
    }

    public void setTeleDef1Miss(int teleDef1Miss) {
        this.teleDef1Miss = teleDef1Miss;
    }

    public int getTeleDef2Make() {
        return teleDef2Make;
    }

    public void setTeleDef2Make(int teleDef2Make) {
        this.teleDef2Make = teleDef2Make;
    }

    public int getTeleDef2Miss() {
        return teleDef2Miss;
    }

    public void setTeleDef2Miss(int teleDef2Miss) {
        this.teleDef2Miss = teleDef2Miss;
    }

    public int getTeleDef3Make() {
        return teleDef3Make;
    }

    public void setTeleDef3Make(int teleDef3Make) {
        this.teleDef3Make = teleDef3Make;
    }

    public int getTeleDef3Miss() {
        return teleDef3Miss;
    }

    public void setTeleDef3Miss(int teleDef3Miss) {
        this.teleDef3Miss = teleDef3Miss;
    }

    public int getTeleDef4Make() {
        return teleDef4Make;
    }

    public void setTeleDef4Make(int teleDef4Make) {
        this.teleDef4Make = teleDef4Make;
    }

    public int getTeleDef4Miss() {
        return teleDef4Miss;
    }

    public void setTeleDef4Miss(int teleDef4Miss) {
        this.teleDef4Miss = teleDef4Miss;
    }

    public int getTeleDef5Make() {
        return teleDef5Make;
    }

    public void setTeleDef5Make(int teleDef5Make) {
        this.teleDef5Make = teleDef5Make;
    }

    public int getTeleDef5Miss() {
        return teleDef5Miss;
    }

    public void setTeleDef5Miss(int teleDef5Miss) {
        this.teleDef5Miss = teleDef5Miss;
    }

    public int getTeleHighMake() {
        return teleHighMake;
    }

    public void setTeleHighMake(int teleHighMake) {
        this.teleHighMake = teleHighMake;
    }

    public int getTeleHighMiss() {
        return teleHighMiss;
    }

    public void setTeleHighMiss(int teleHighMiss) {
        this.teleHighMiss = teleHighMiss;
    }

    public int getTeleLowMake() {
        return teleLowMake;
    }

    public void setTeleLowMake(int teleLowMake) {
        this.teleLowMake = teleLowMake;
    }

    public int getTeleLowMiss() {
        return teleLowMiss;
    }

    public void setTeleLowMiss(int teleLowMiss) {
        this.teleLowMiss = teleLowMiss;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}






























