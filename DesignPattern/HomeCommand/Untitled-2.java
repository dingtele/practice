public interface Command{
    public void execute();
}

public class LightOnCommand implements Command{
    Light light;

    public lightOnCommand(Light light){
        this.light = light;
    }

    public void execute(){
        light.on();
    }
}

public class SimpleRemoteControl{
    Command slot;

    public simpleRemoteControl(){}

    public void setCommand(Command command){
        slot = command;
    }

    public void buttonWasPressed(){
        slot.execute();
    }
}

public class RemoteControlTest{
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOn = new LightOnCommand(light);

        remote.setCommand(lightOn);
        remote.buttonWasPressed;
    }
}




public class GarageDoorOpenCommand implements Command{
    GarageDoor garageDoor;

    public GarageDoor(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }

    public void execute(){
        garageDoor.up();
        garageDoor.lightOn();
    }
}

public class SimpleRemoteControl{
    Command slot;

    public simpleRemoteControl(){}

    public void setCommand(Command command){
        slot = command;
    }

    public void buttonWasPressed(){
        slot.execute();
    }
}


public class RemoteControl{
    Command[] onCommand;
    Command[] offCommand;

    public remoteCommand(){
        onCommand = new Command[7];
        offCommand = new Command[7];

        Command[] noCommand = new Nocommand();
        for(int i = 0, i<7; i++){
            onCommand[i] = noCommand;
            offCommand[i] = noCommand; 
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand){
        onCommand[slot] = onCommand;
        offCommand[slot] = offCommand; 
    }

    public void onButtonWasPushed(int slot){
        onCommand[slot].execute();
    }

    public void offButtonWasPushed(int slot){
        offCommand[slot].execute();
    }

    public String toString(){
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n----RemoteControl----\n");
        for(int i=0; i<onCommand.length; i++){
            stringBuff.append("[slot"+i+"]"+onCommand[i].getClass().getName()+" "
                                +offCommand[i].getClass().getName()+"\n");
        }
        return stringBuff.toString();
    }
}


public class RemoteLoader{
    public static void main(String[] args){
        RemoteControl remote = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenRoomLight = new Light("Kitchen Room");

        Command onCommand = new Command(livingRoomLight);

        remote.setCommand

    }
}

public class MacroCommand implements Command{
    Command[] commands;

    public macroCommand(Command command){
        this.command = command;
    }

    public void execute(){
        for(int i = 0; i < command.length; i++){
            command[i].execute();
        }
    }

    public void undo(){
        for(int i = 0; i < command.length; i++){
            command[i].undo();
        }
    }
}