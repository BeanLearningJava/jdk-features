
import java.util.concurrent.Semaphore;

class LoginExample {

    private final Semaphore semaphore;

    LoginExample(int slotLimit) {
        semaphore = new Semaphore(slotLimit);
    }

    synchronized boolean test() throws InterruptedException {
        wait();
        return false;
    }

    boolean tryLogin() {
        return semaphore.tryAcquire();
    }

    void logout() {
        semaphore.release();
    }

    int availableSlots() {
        return semaphore.availablePermits();
    }

}
