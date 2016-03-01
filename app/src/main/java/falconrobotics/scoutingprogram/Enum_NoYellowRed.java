package falconrobotics.scoutingprogram;

/**
 * Created on 2/25/2016.
 */
public enum Enum_NoYellowRed {
    NO (0),
    YELLOW (1),
    RED (2);

    private byte value;

    Enum_NoYellowRed(int _value)
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
                return "Yellow";
            case 2:
                return "Red";
            default:
                return "UNDEFINED";
        }
    }
}
