package falconrobotics.scoutingprogram;

/**
 * Created on 2/25/2016.
 */
public enum Enum_Wheels {
    TRACTION(0),
    PNEUMATIC(1),
    MECHANUM(2),
    SWERVE(3),
    OMNI(4),
    TANK(5),
    HYBRID(6);

    private byte value;

    Enum_Wheels(int _value) {
        value = (byte) _value;
    }

    public String getResult() {
        switch (value) {
            case 0:
                return "Traction";
            case 1:
                return "Pneumatic";
            case 2:
                return "Mechanum";
            case 3:
                return "Swerve";
            case 4:
                return "Omni";
            case 5:
                return "Tank";
            case 6:
                return "Hybrid";
            default:
                return "UNDEFINED";
        }
    }
}
