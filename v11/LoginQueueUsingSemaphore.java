
import java.util.concurrent.Semaphore;

class LoginQueueUsingSemaphore {

    private final Semaphore semaphore;

    LoginQueueUsingSemaphore(int slotLimit) {
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
