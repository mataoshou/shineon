package build.alt;

public class MinNo {

    public int getMin(int[] nos)
    {
        int min =Integer.MAX_VALUE;

        int min_h = 0;

        int low = 0;

        for(Integer no :nos)
        {

            if(min -1 ==low)
            {
                low = min;
                min = Integer.MAX_VALUE;
            }
            if(no<=0)continue;
            if(no<low)continue;
            if(no.equals(low+1))
            {
                low++;
                continue;
            }
            if(min>no)
           {
               min =no;
           }

        }


        if(min -1 == low) low = min;

        return low+1 ;


    }

    public static  void main(String[] args)
    {
        MinNo no =new MinNo();
        System.out.println(no.getMin(new int[]{3,1,4, 7, 8, 2}));
    }

}
