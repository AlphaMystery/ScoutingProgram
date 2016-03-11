package falconrobotics.scoutingprogram;

/**
 * Created on 2/25/2016.
 */
public interface Interface_Pit {
    String[] NoAutoTeleBoth =
            {
                    "no",
                    "auto",
                    "tele",
                    "both"
            };
    String[] NoYes =
            {
                    "no",
                    "yes"
            };
        String[] Shooter =
            {
                    "unknown",
                    "none",
                    "wheels",
                    "catapult",
                    "turret",
                    "slingshot",
                    "other"
            };
        String[] Weight =
            {
                    "unknown",
                    "sub 50",
                    "50-59",
                    "60-69",
                    "70-79",
                    "80-89",
                    "90-99",
                    "100-109",
                    "110-119",
                    "120"
            };
        String[] Wheels =
            {
                    "traction",
                    "pneumatic",
                    "mecanum",
                    "swerve",
                    "omni",
                    "tank",
                    "hybrid"
            };
    String[] driverExperience =
            {
                    "<=1",
                    "<=2",
                    "<=3",
                    "<=4"
            };

    String[] climbSpeed =
            {
                    "1-10",
                    "11-10",
                    "21-30",
                    "31-40"
            };

}