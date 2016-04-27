package falconrobotics.scoutingprogram;

/**
 * Created on 4/26/2016.
 */
public class Match_Model_Save {
    public static int _id = 0,
            teamNum = 0,
            autoLowMiss = 0,
            autoLowHit = 0,
            autoHighMiss = 0,
            autoHighHit = 0,
            autoLowBarMiss = 0,
            autoLowBarHit = 0,
            autoCMiss = -1,
            autoCHit = -1,
            teleLowBarMiss = 0,
            teleLowBarHit = 0,
            teleCMiss = -1,
            teleCHit = -1,
            teleSector1Miss = 0,
            teleSector1Hit = 0,
            teleSector2Miss = 0,
            teleSector2Hit = 0,
            teleSector3Miss = 0,
            teleSector3Hit = 0,
            teleSector4Miss = 0,
            teleSector4Hit = 0,
            teleSector5Miss = 0,
            teleSector5Hit = 0,
            teleSector6Miss = 0,
            teleSector6Hit = 0,
            postClimb = 0;
    public static String postComments = "";

    public static void reset()
    {
        _id = 0;
        teamNum = 0;
        autoLowMiss = 0;
        autoLowHit = 0;
        autoHighMiss = 0;
        autoHighHit = 0;
        autoLowBarMiss = 0;
        autoLowBarHit = 0;
        autoCMiss = 0;
        autoCHit = 0;
        teleLowBarMiss = 0;
        teleLowBarHit = 0;
        teleCMiss = 0;
        teleCHit = 0;
        teleSector1Miss = 0;
        teleSector1Hit = 0;
        teleSector2Miss = 0;
        teleSector2Hit = 0;
        teleSector3Miss = 0;
        teleSector3Hit = 0;
        teleSector4Miss = 0;
        teleSector4Hit = 0;
        teleSector5Miss = 0;
        teleSector5Hit = 0;
        teleSector6Miss = 0;
        teleSector6Hit = 0;
        postClimb = 0;

        postComments = "";
    }
}
