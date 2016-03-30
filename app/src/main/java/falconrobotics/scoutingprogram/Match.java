package falconrobotics.scoutingprogram;

/**
 * Created by Rodrigo on 3/3/2016.
 */
public class Match {
//    public Match(int _id,int teamNum,int autoDef1,int autoDef2,int autoDef3,int autoDef4,int autoDef5,int autoBoulder,int autoLowMiss,int autoLowMake,int autoHighMiss,
//                 int autoHighMake,int teleDef1,int teleDef2,int teleDef3,int teleDef4,int teleDef5,int teleBoulder,int teleLowMiss,int teleLowMake,int teleHighMiss,
//                 int teleHighMake,int telePush,int teleBlock, int climb,int scoreTotal,int scoreAuto,int scoreFould,int carded,int stopped,String comments,int syncNum)
//    {
//    }

    //Game Column Names
    //auto
    public int _id;
    private int teamNum;
    private int autoDef1;
    private int autoDef2;
    private int autoDef3;
    private int autoDef4;
    private int autoDef5;
    private int autoBoulder;
    private int autoLowMiss;
    private int autoLowMake;
    private int autoHighMiss;
    private int autoHighMake;
    //tele
    private int teleDef1;
    private int teleDef2;
    private int teleDef3;
    private int teleDef4;
    private int teleDef5;
    private int teleBoulderPass;
    private int teleLowMiss;
    private int teleLowMake;
    private int teleHighMiss;
    private int teleHighMake;
    private int telePush;
    private int teleBlock;
    //
    private int climb;
    private int scoreTotal;
    private int scoreAuto;
    private int scoreFould;
    private int carded;
    private int stopped;
    private String comments;
    private int syncNum;

    private Match() {
    }

    private void set_id(int _id) {
        this._id = _id;
    }

    private int get_id(int _id) {
        return _id;
    }

    private int getTeamNum() {
        return teamNum;
    }

    private void setTeamNum(int teamNum) {
        this.teamNum = teamNum;
    }

    private int getAutoDef1() {
        return autoDef1;
    }

    private void setAutoDef1(int autoDef1) {
        this.autoDef1 = autoDef1;
    }

    private int getAutoDef2() {
        return autoDef2;
    }

    private void setAutoDef2(int autoDef2) {
        this.autoDef2 = autoDef2;
    }

    private int getAutoDef3() {
        return autoDef3;
    }

    private void setAutoDef3(int autoDef3) {
        this.autoDef3 = autoDef3;
    }

    private int getAutoDef4() {
        return autoDef4;
    }

    private void setAutoDef4(int autoDef4) {
        this.autoDef4 = autoDef4;
    }

    private int getAutoDef5() {
        return autoDef5;
    }

    private void setAutoDef5(int autoDef5) {
        this.autoDef5 = autoDef5;
    }

    private int getAutoBoulder() {
        return autoBoulder;
    }

    private void setAutoBoulder(int autoBoulder) {
        this.autoBoulder = autoBoulder;
    }

    private int getAutoLowMiss() {
        return autoLowMiss;
    }

    private void setAutoLowMiss(int autoLowMiss) {
        this.autoLowMiss = autoLowMiss;
    }

    private int getAutoLowMake() {
        return autoLowMake;
    }

    private void setAutoLowMake(int autoLowMake) {
        this.autoLowMake = autoLowMake;
    }

    private int getAutoHighMiss() {
        return autoHighMiss;
    }

    private void setAutoHighMiss(int autoHighMiss) {
        this.autoHighMiss = autoHighMiss;
    }

    private int getAutoHighMake() {
        return autoHighMake;
    }

    private void setAutoHighMake(int autoHighMake) {
        this.autoHighMake = autoHighMake;
    }

    private int getTeleDef1() {
        return teleDef1;
    }

    private void setTeleDef1(int teleDef1) {
        this.teleDef1 = teleDef1;
    }

    private int getTeleDef2() {
        return teleDef2;
    }

    private void setTeleDef2(int teleDef2) {
        this.teleDef2 = teleDef2;
    }

    private int getTeleDef3() {
        return teleDef3;
    }

    private void setTeleDef3(int teleDef3) {
        this.teleDef3 = teleDef3;
    }

    private int getTeleDef4() {
        return teleDef4;
    }

    private void setTeleDef4(int teleDef4) {
        this.teleDef4 = teleDef4;
    }

    private int getTeleDef5() {
        return teleDef5;
    }

    private void setTeleDef5(int teleDef5) {
        this.teleDef5 = teleDef5;
    }

    private int getTeleBoulder() {
        return teleBoulderPass;
    }

    private void setTeleBoulder(int teleBoulderPass) {
        this.teleBoulderPass = teleBoulderPass;
    }

    private int getTeleLowMiss() {
        return teleLowMiss;
    }

    private void setTeleLowMiss(int teleLowMiss) {
        this.teleLowMiss = teleLowMiss;
    }

    private int getTeleLowMake() {
        return teleLowMake;
    }

    private void setTeleLowMake(int teleLowMake) {
        this.teleLowMake = teleLowMake;
    }

    private int getTeleHighMiss() {
        return teleHighMiss;
    }

    private void setTeleHighMiss(int teleHighMiss) {
        this.teleHighMiss = teleHighMiss;
    }

    private int getTeleHighMake() {
        return teleHighMake;
    }

    private void setTeleHighMake(int teleHighMake) {
        this.teleHighMake = teleHighMake;
    }

    private int getTelePush() {
        return telePush;
    }

    private void setTelePush(int telePush) {
        this.telePush = telePush;
    }

    private int getTeleBlock() {
        return teleBlock;
    }

    private void setTeleBlock(int teleBlock) {
        this.teleBlock = teleBlock;
    }

    private int getClimb() {
        return climb;
    }

    private void setClimb(int climb) {
        this.climb = climb;
    }

    private int getScoreTotal() {
        return scoreTotal;
    }

    private void setScoreTotal(int scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    private int getScoreAuto() {
        return scoreAuto;
    }

    private void setScoreAuto(int scoreAuto) {
        this.scoreAuto = scoreAuto;
    }

    private int getScoreFould() {
        return scoreFould;
    }

    private void setScoreFould(int scoreFould) {
        this.scoreFould = scoreFould;
    }

    private int getCarded() {
        return carded;
    }

    private void setCarded(int carded) {
        this.carded = carded;
    }

    private int getStopped() {
        return stopped;
    }

    private void setStopped(int stopped) {
        this.stopped = stopped;
    }

    private String getComments() {
        return comments;
    }

    private void setComments(String comments) {
        this.comments = comments;
    }

    private int getSyncNum() {
        return syncNum;
    }

    private void setSyncNum(int syncNum) {
        this.syncNum = syncNum;
    }


    //Table Names
//    public int GAME_SCOUTING = "game";
//    public int PIT_SCOUTING = "pit";
//    public int API_SCOUTING = "first";


}
