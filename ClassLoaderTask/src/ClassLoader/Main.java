package ClassLoader;

import ClassLoader.Crypter.Crypter;
import ClassLoader.Plugin.Plugin;
import ClassLoader.Plugin.PluginManager;

public class Main {
    public static void main(String[] args) {
        String classPath = "C:\\Users\\Sergey\\Documents\\SBTJavaSchool\\JavaSchool\\ClassLoaderTask\\out\\production\\ClassLoaderTask\\ClassLoader\\Plugin\\";

        PluginManager pluginLoader = new PluginManager(classPath);
        Plugin plugin2 = (Plugin) pluginLoader.load("PluginImpl2.class");
        plugin2.doUseful();

        Crypter.crypt(classPath+"PluginImpl1.class",classPath+"PluginImplCrypted.class");
        Plugin plugin1CryptTest=(Plugin)pluginLoader.load("PluginImplCrypted.class",true);
        plugin1CryptTest.doUseful();
    }
}
