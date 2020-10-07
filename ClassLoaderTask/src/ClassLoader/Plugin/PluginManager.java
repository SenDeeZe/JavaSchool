package ClassLoader.Plugin;

import ClassLoader.Crypter.Crypter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PluginManager extends ClassLoader{
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    private byte[] loadClassAsBytesArray(String classPath) {
        try {
            return Files.readAllBytes(Paths.get(classPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected Class<?> findClass(String className) {
        byte[] classInBytesArray = loadClassAsBytesArray(className);
        if (classInBytesArray != null) {
            return defineClass(null, classInBytesArray, 0, classInBytesArray.length);
        }
        return null;
    }

    public Plugin load(String pluginClassName) {
        try {
            return (Plugin) findClass(pluginRootDirectory+pluginClassName).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Plugin load(String pluginClassName,boolean isCrypted){
        if(!isCrypted) return load(pluginClassName);
        String newPluginFileName=pluginClassName.split("\\.")[0]+"_decrypted_.class";
        Crypter.decrypt(pluginRootDirectory+pluginClassName,pluginRootDirectory+newPluginFileName);
        Plugin tmp =  load(newPluginFileName);
        try {
            Files.delete(Paths.get(pluginRootDirectory+newPluginFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tmp;
    }
}

