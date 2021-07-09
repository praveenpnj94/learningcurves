public class Child extends Base {

    Child() {
        System.out.println("In child class constructor");
        overrideMe();
        populate();
    }

    @Override
    void overrideMe() {
        System.out.println("In child class overrideMe method");
    }

    @Override
    void populate() {
        System.out.println("In child class populate method");
    }
}