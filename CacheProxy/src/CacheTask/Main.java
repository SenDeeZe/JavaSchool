package CacheTask;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        CacheProxy cacheProxy = new CacheProxy("C:\\Users\\Sergey\\Documents\\SBTJavaSchool\\cache");
        Service service = cacheProxy.cache(new ServiceImpl());
        System.out.println(service.doHardWork("1",5,new Date()));
        System.out.println(service.doHardWork("1",6,new Date()));
        System.out.println(service.doHardWork("1",6,new Date()));
        System.out.println(service.doHardWork("1",5,new Date()));
    }
}
