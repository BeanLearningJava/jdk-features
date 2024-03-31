//usr/bin/env jshell $0 $@; exit $?

/open PRINTING

public class BillPughSingleton {

    protected long epoch = 1234567890;

    private short machineId = 123;

    public short sequence = 0;

    protected BillPughSingleton(){}

    protected static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public long getEpoch() {
        return epoch;
    }

    public short getMachineId() {
        return machineId;
    }
}

public final class CustomEpoch extends BillPughSingleton {

    protected CustomEpoch(){
        epoch = 9876543210L;
    }

    protected static class SingletonHelper {
        private static final CustomEpoch INSTANCE = new CustomEpoch();
    }

    public static CustomEpoch getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

BillPughSingleton instance = BillPughSingleton.getInstance();

println("Epoch is " + instance.getEpoch());
println("Machine ID is " + instance.getMachineId());
println("Sequence is " + instance.sequence);
instance.sequence++;
println("Sequence is " + instance.sequence);

BillPughSingleton customEpoch = CustomEpoch.getInstance();
println("customEpoch is " + customEpoch.getEpoch());
println("Machine ID is " + customEpoch.getMachineId());
println("customEpoch Sequence is " + customEpoch.sequence);
customEpoch.sequence++;customEpoch.sequence++;customEpoch.sequence++;customEpoch.sequence++;customEpoch.sequence++;customEpoch.sequence++;
println("customEpoch Sequence is " + customEpoch.sequence);
println("Sequence is " + instance.sequence);

BillPughSingleton instance2 = BillPughSingleton.getInstance();
BillPughSingleton customEpoch2 = CustomEpoch.getInstance();
println("customEpoch 222 is " + customEpoch2.getEpoch());
println("Machine ID 222 is " + customEpoch2.getMachineId());
println("customEpoch Sequence 222 is " + customEpoch2.sequence);
 
println("customEpoch Sequence 222 is " + customEpoch2.sequence);
println("Sequence 222 is " + instance2.sequence);


/exit