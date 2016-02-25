package falconrobotics.scoutingprogram;

/**
 * Created by 842 on 2/25/2016.
 */
public class Model_Teams {
    private int
    teamNum,
    syncNum;

    private String shortName;

    public int getTeamNum() {
        return teamNum;
    }

    public void setTeamNum(int teamNum) {
        this.teamNum = teamNum;
    }

    public int getSyncNum() {
        return syncNum;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setSyncNum(int syncNum) {
        this.syncNum = syncNum;
    }
}
