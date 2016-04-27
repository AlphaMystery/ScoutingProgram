package falconrobotics.scoutingprogram;

/**
 * Created on 2/24/2016.
 *
 * Structure for how the data is going to be inputted into the match table.
 */
public class Model_Match {
    private int _id,
            teamNum,
            autoLowMiss,
            autoLowHit,
            autoHighMiss,
            autoHighHit,
            autoLowBarMiss,
            autoLowBarHit,
            autoCMiss,
            autoCHit,
            teleLowBarMiss,
            teleLowBarHit,
            teleCMiss,
            teleCHit,
            teleSector1Miss,
            teleSector1Hit,
            teleSector2Miss,
            teleSector2Hit,
            teleSector3Miss,
            teleSector3Hit,
            teleSector4Miss,
            teleSector4Hit,
            teleSector5Miss,
            teleSector5Hit,
            teleSector6Miss,
            teleSector6Hit,
            postClimb,
            syncNum;
    private String postComments;

    public Model_Match(
            int _id,
            int teamNum,
            int autoLowMiss,
            int autoLowHit,
            int autoHighMiss,
            int autoHighHit,
            int autoLowBarMiss,
            int autoLowBarHit,
            int autoCMiss,
            int autoCHit,
            int teleLowBarMiss,
            int teleLowBarHit,
            int teleCMiss,
            int teleCHit,
            int teleSector1Miss,
            int teleSector1Hit,
            int teleSector2Miss,
            int teleSector2Hit,
            int teleSector3Miss,
            int teleSector3Hit,
            int teleSector4Miss,
            int teleSector4Hit,
            int teleSector5Miss,
            int teleSector5Hit,
            int teleSector6Miss,
            int teleSector6Hit,
            int postClimb,
            String postComments,
            int syncNum)
    {
        this._id =  _id;
        this.teamNum = teamNum;
        this.autoLowMiss = autoLowMiss;
        this.autoLowHit = autoLowHit;
        this.autoHighMiss = autoHighMiss;
        this.autoHighHit = autoHighHit;
        this.autoLowBarMiss = autoLowBarMiss;
        this.autoLowBarHit = autoLowBarHit;
        this.autoCMiss = autoCMiss;
        this.autoCHit = autoCHit;
        this.teleLowBarMiss = teleLowBarMiss;
        this.teleLowBarHit = teleLowBarHit;
        this.teleCMiss = teleCMiss;
        this.teleCHit = teleCHit;
        this.teleSector1Miss = teleSector1Miss;
        this.teleSector1Hit = teleSector1Hit;
        this.teleSector2Miss = teleSector2Miss;
        this.teleSector2Hit = teleSector2Hit;
        this.teleSector3Miss = teleSector3Miss;
        this.teleSector3Hit = teleSector3Hit;
        this.teleSector4Miss = teleSector4Miss;
        this.teleSector4Hit = teleSector4Hit;
        this.teleSector5Miss = teleSector5Miss;
        this.teleSector5Hit = teleSector5Hit;
        this.teleSector6Miss = teleSector6Miss;
        this.teleSector6Hit = teleSector6Hit;
        this.postClimb =  postClimb;
        this.postComments = postComments;
        this.syncNum = syncNum;
    }

    public int get_id() {
        return _id;
    }

    public int getTeamNum() {
        return teamNum;
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

    public int getAutoLowBarMiss() {
        return autoLowBarMiss;
    }

    public int getAutoLowBarHit() {
        return autoLowBarHit;
    }

    public int getAutoCMiss() {
        return autoCMiss;
    }

    public int getAutoCHit() {
        return autoCHit;
    }

    public int getTeleLowBarMiss() {
        return teleLowBarMiss;
    }

    public int getTeleLowBarHit() {
        return teleLowBarHit;
    }

    public int getTeleCMiss() {
        return teleCMiss;
    }

    public int getTeleCHit() {
        return teleCHit;
    }

    public int getTeleSector1Miss() {
        return teleSector1Miss;
    }

    public int getTeleSector1Hit() {
        return teleSector1Hit;
    }

    public int getTeleSector2Miss() {
        return teleSector2Miss;
    }

    public int getTeleSector2Hit() {
        return teleSector2Hit;
    }

    public int getTeleSector3Miss() {
        return teleSector3Miss;
    }

    public int getTeleSector3Hit() {
        return teleSector3Hit;
    }

    public int getTeleSector4Miss() {
        return teleSector4Miss;
    }

    public int getTeleSector4Hit() {
        return teleSector4Hit;
    }

    public int getTeleSector5Miss() {
        return teleSector5Miss;
    }

    public int getTeleSector5Hit() {
        return teleSector5Hit;
    }

    public int getTeleSector6Miss() {
        return teleSector6Miss;
    }

    public int getTeleSector6Hit() {
        return teleSector6Hit;
    }

    public int getPostClimb() {
        return postClimb;
    }

    public int getSyncNum() {
        return syncNum;
    }

    public String getPostComments() {
        return postComments;
    }
}