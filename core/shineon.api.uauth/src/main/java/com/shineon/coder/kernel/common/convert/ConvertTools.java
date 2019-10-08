package com.shineon.coder.kernel.common.convert;

import java.util.List;

public class ConvertTools {


    public PropertyItem getItem(PropertyItem item, List<PropertyItem> items)
    {
        for(PropertyItem ci:items)
        {
            if(ci.status)continue;;

            if(ci.name.equals(item.name)&&ci.type.equals(item.type)) {

                return ci;
            }
        }

        PropertyItem result = getSimaliar(item,items);

        return  result;
    }

    public PropertyItem getFirstType(PropertyItem item, List<PropertyItem> items)
    {

        for(PropertyItem ci:items)
        {
            if(ci.status)continue;;
            if(ci.type.equals(item.type)) {

                return ci;
            }
        }

        return  null;
    }

    public PropertyItem getSimaliar(PropertyItem item, List<PropertyItem> items)
    {
        int score = 0;
        PropertyItem result =null;
        for(PropertyItem ci:items)
        {
            if(ci.status)continue;;
            if(ci.type.equals(item.type)) {

               int count = getScore(item.name,ci.name);
               if(score<count)
               {
                   score = count;
                   result = ci;
               }
            }
        }

        return result;
    }

    public int getScore(String str , String next)
    {
        char[] chs = str.toCharArray();

        int score = 0;

        for(char c : chs)
        {
            if(next.indexOf(c)>0)
            {
                score++;
            }
        }

        return  score;
    }

    public  String getFileName(String fn)
    {

        String name =  fn.substring(0,fn.lastIndexOf(".") );

        return name;
    }
}
