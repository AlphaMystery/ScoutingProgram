package falconrobotics.scoutingprogram;

import java.util.ArrayList;

/**
 * Created on 2/25/2016.
 *
 * Contains all the items that will fill spinners throughout the app.
 */
public interface Interface_Spinners {
        String[] ChallengeClimb =
                {
                        "NO DATA INPUT",
                        "NO",
                        "CHALLENGE",
                        "CLIMB"
                };
        String[] NoAutoTeleBoth =
                {
                        "NO DATA INPUT",
                        "NO",
                        "AUTO",
                        "TELE",
                        "BOTH"
                };
        String[] NoYes =
                {
                        "NO DATA INPUT",
                        "NO",
                        "YES"
                };
        String[] ShooterType =
                {
                        "UNKNOWN",
                        "NONE",
                        "WHEELS",
                        "CATAPULT",
                        "TURRET",
                        "SLINGSHOT",
                        "OTHER"
                };
        String[] ShootingType =
                {
                        "NO DATA INPUT",
                        "LOW",
                        "BOTH",
                        "HIGH"
                };
        String[] Weight =
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
        String[] DrivetrainType =
                {
                        "NO DATA INPUT",
                        "TRACTION",
                        "PNEUMATIC",
                        "MECHANUM",
                        "SWERVE",
                        "OMNI",
                        "TANK",
                        "HYBRID"
                };
        String[] EXPERIENCE =
                {
                        "NO DATA INPUT",
                        "First",
                        "Second",
                        "Third",
                        "Fourth",
                        "Fifth (VEX/FLL)",
                        "Sixth (VEX/FLL)",
                        "Seventh (VEX/FLL)"
                };
        String[] ClimbSpeed =
                {
                        "NO DATA INPUT",
                        "< 10",
                        "< 20",
                        "< 30",
                        "< 40",
                };
        String[] MatchLevel =
                {
                        "Qualifiers",
                        "Playoffs"
                };
        String[] numbers =
                {
                        "0",
                        "1",
                        "2",
                        "3",
                        "4",
                        "5",
                        "6"
                };
        ArrayList<Integer> Teams = new ArrayList<Integer>();
        ArrayList<Integer> Matches = new ArrayList<Integer>();
        ArrayList<Integer> MatchesWLevel = new ArrayList<Integer>();
}
