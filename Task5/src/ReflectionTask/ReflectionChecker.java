package ReflectionTask;

public class ReflectionChecker {
    private String name;

    private void privateMethod1(){
    }

    private void privateMethod2(){
    }

    public void publicMethod1(){

    }

    public ReflectionChecker(String name) {
        this.name = name;
    }

    public ReflectionChecker() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
