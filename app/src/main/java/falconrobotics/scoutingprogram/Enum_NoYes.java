package falconrobotics.scoutingprogram;

/**
 * Created by 842 on 2/25/2016.
 */
public enum Enum_NoYes {
    NO (0),
    YES (1);

    private byte value;

    Enum_NoYes(int _value)
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
                return "Yes";
            default:
                return "UNDEFINED";
        }
    }
}
