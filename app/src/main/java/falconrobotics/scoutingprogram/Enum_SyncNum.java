package falconrobotics.scoutingprogram;

import java.util.PriorityQueue;

/**
 * Created by 842 on 2/25/2016.
 */
public enum Enum_SyncNum {
    NOT_YET_SCOUTED (-1),
    SCOUTED_LOCALLY (0),
    SCOUTED_BY_OTHERS(1);

    private byte value;

    Enum_SyncNum(int _value)
    {
        value = (byte)_value;
    }

    public String getResult()
    {
        switch (value)
        {
            case -1:
                return "Not Yet Scouted";
            case 0:
                return "Scouted Locally";
            case 1:
                return "Scouted By Others";
            default:
                return "UNDEFINED";
        }
    }
}
