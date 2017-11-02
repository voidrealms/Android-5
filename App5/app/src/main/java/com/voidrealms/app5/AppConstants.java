package com.voidrealms.app5;

/**
 * Created by rootshell on 2/16/17.
 */

public class AppConstants {
    public static String tag = "voidrealms.com";

    public static enum CalcType
    {
        None(0),
        Dog(9),
        Cat(6),
        Fish(3);

        private int id;

        CalcType (int i)
        {
            this.id = i;
        }

        public int getNumericType()
        {
            return this.id;
        }

        public static CalcType fromId(int value)
        {
            for(CalcType type : CalcType.values())
            {
                if(type.getNumericType() == value)
                {
                    return type;
                }
            }
            return null;
        }

    }
}
