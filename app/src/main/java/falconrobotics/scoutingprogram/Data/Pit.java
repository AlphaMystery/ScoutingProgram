package falconrobotics.scoutingprogram.Data;

/**
 * Created by 842 on 2/25/2016.
 */
public interface Pit {
    String[] NoAutoTeleBoth =
            {
                    "NO",
                    "AUTO",
                    "TELE",
                    "BOTH"
            };
    String[] NoYes =
            {
                    "NO",
                    "YES"
            };
    String[] SHOOTER =
            {
                    "UNKNOWN",
                    "NONE",
                    "WHEELS",
                    "CATAPULT",
                    "TURRET",
                    "SLINGSHOT",
                    "OTHER"
            };
    String[] WEIGHT =
            {
                    "UNKNOWN",
                    "SUB 50",
                    "50-59",
                    "60-69",
                    "70-79",
                    "80-89",
                    "90-99",
                    "100-109",
                    "110-119",
                    "120"
            };
    String[] WHEELS =
            {
                    "TRACTION",
                    "PNEUMATIC",
                    "MECHANUM",
                    "SWERVE",
                    "OMNI",
                    "TANK",
                    "HYBRID"
            };
}