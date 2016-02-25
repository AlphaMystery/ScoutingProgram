package falconrobotics.scoutingprogram;

/**
 * Created by 842 on 2/25/2016.
 */
public enum Enum_Weight {
    ZERO (0),
    FORTY (1),
    FIFTY (2),
    SIXTY (3),
    SEVENTY (4),
    EIGHTY (5),
    NINETY (6),
    HUNDRED (7),
    HUNDRED_TEN (8),
    HUNDRED_TWENTY (9);

    private byte value;

    Enum_Weight(int _value)
    {
        value = (byte)_value;
    }

    public String getResult()
    {
        switch (value)
        {
            case 0:
                return "UNKNOWN";
            case 1:
                return "SUB 50";
            case 2:
                return "50-59";
            case 3:
                return "60-69";
            case 4:
                return "70-79";
            case 5:
                return "80-89";
            case 6:
                return "90-99";
            case 7:
                return "100-109";
            case 8:
                return "110-119";
            case 9:
                return "120";
            default:
                return "UNDEFINED";
        }
    }

}
