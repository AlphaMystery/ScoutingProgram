package falconrobotics.scoutingprogram;

/**
 * Created on 2/25/2016.
 */
public enum Enum_NoReachCross {
    NO (0),
    REACH (1),
    CROSS( 2);

    private byte value;

    Enum_NoReachCross(int _value)
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
                return "Reached";
        }
        if(value >= 2) return "Crossed";
        return "UNDEFINED";
    }
}
