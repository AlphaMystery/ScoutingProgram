package falconrobotics.scoutingprogram;

/**
 * Created on 2/25/2016.
 */
public enum Enum_MatchLevel {
    QUALIFICATION (0),
    PLAYOFF (1);

    private byte value;

    Enum_MatchLevel(int _value)
    {
        value = (byte)_value;
    }


    public String getResult()
    {
        switch (value)
        {
            case 0:
                return "Qualifier";
            case 1:
                return "Playoff";
            default:
                return "UNDEFINED";
        }
    }

}
