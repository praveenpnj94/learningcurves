abstract class Base {

    Base() {
        overrideMe();
        populate();
    }

    abstract void overrideMe();

    void populate() {
        System.out.println("in super class" + this.getClass().toString());
    }
}