package falconrobotics.scoutingprogram;

/**
 * Created by 842 on 2/25/2016.
 */
public enum Enum_NoTryYes {
    NO (0),
    TRY (1),
    YES (2);

    private byte value;

    Enum_NoTryYes(int _value)
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
                return "Try";
            case 2:
                return "Yes";
            default:
                return "UNDEFINED";
        }
    }
}
