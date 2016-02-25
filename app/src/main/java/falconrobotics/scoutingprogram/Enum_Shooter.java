package falconrobotics.scoutingprogram;

/**
 * Created by 842 on 2/25/2016.
 */
public enum Enum_Shooter {
    UNKOWN (0),
    NONE (1),
    WHEELS (2),
    CATAPULT (3),
    TURRET (4),
    SLINGSHOT (5),
    OTHER(6);

    private byte value;

    Enum_Shooter(int _value)
    {
        value = (byte)_value;
    }

    public String getResult()
    {
        switch (value)
        {
            case 0:
                return "Unknown";
            case 1:
                return "None";
            case 2:
                return "Wheels";
            case 3:
                return "Catapult";
            case 4:
                return "Turret";
            case 5:
                return "Slingshot";
            case 6:
                return "Other";
            default:
                return "UNDEFINED";
        }
    }
}
