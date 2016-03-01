package falconrobotics.scoutingprogram;

/**
 * Created on 2/25/2016.
 */
public enum Enum_NoAutoTeleBoth
{
    NO (0),
    AUTO (1),
    TELE (2),
    BOTH (3);

    private byte value;

    Enum_NoAutoTeleBoth(int _value)
    {
        value = (byte)_value;
    }

    public String getResult()
    {
        switch (value)
        {
            case 0:
                return "No";
            case 1:
                return "Auto";
            case 2:
                return "Tele";
            case 3:
                return "Both";
            default:
                return "UNDEFINED";
        }
    }
}
