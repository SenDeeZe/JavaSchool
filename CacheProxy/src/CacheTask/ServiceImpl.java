package CacheTask;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ServiceImpl  implements Service{
    @Override
    public List<String> doHardWork(String item, double value, Date date){
        return Arrays.asList(item,String.valueOf(value),date.toString());
    }
}