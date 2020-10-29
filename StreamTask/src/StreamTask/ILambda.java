package StreamTask;

@FunctionalInterface
public interface ILambda<T> {
    T getSum(T a, T b);
}
