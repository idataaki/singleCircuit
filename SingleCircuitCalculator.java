import java.util.ArrayList;

public class SingleCircuitCalculator {

    /**attributes*/
    private float voltageSource;
    private int resistorsCount;
    private float mainCurrent;
    private float equalRes;
    private ArrayList<Float> resistors;
    private ArrayList<Float> resV;

    /**constructors*/
    public SingleCircuitCalculator(){
        resistors = new ArrayList<>();
        resV = new ArrayList<>();
    }

    /**setter*/
    public void setVoltageSource(float voltageSource) {
        this.voltageSource = voltageSource;
    }

    public void setResistorsCount(int resistorsCount) {
        this.resistorsCount = resistorsCount;
    }

    public void setMainCurrent(float mainCurrent) {
        this.mainCurrent = mainCurrent;
    }

    public void setResistors(ArrayList<Float> resistors) {
        this.resistors = resistors;
        resistorsCount = resistors.size();
    }

    public void setResV(ArrayList<Float> resV) {
        this.resV = resV;
    }

    /**getter*/
    public float getVoltageSource() {
        return voltageSource;
    }

    public int getResistorsCount() {
        return resistorsCount;
    }

    public float getMainCurrent() {
        return mainCurrent;
    }

    public float getEqualRes() {
        return equalRes;
    }

    public ArrayList<Float> getResistors() {
        return resistors;
    }

    public ArrayList<Float> getResV() {
        return resV;
    }

    /**methods*/
    public void addResistor(float res){
        resistors.add(res);
        resistorsCount = resistors.size();
    }

    public void calcMainCurrent(){
        mainCurrent = voltageSource/equalRes;
    }

    public void calcResistorsVoltage(){
        for (float res:resistors) {
            resV.add(mainCurrent*res);
        }
    }

    public void calcEqualRes(){
        equalRes = 0;
        for (float res:resistors) {
            equalRes += res;
        }
    }

    public void calcVoltageSource(){
        voltageSource = equalRes * mainCurrent;
    }

    @Override
    public String toString() {
        super.toString();

        String returnValue = "";
        returnValue += "V= " + voltageSource + " i= " + mainCurrent + "\n";

        for (int i = 0; i <resistorsCount ; i++) {
            returnValue += "R" + (i+1) + "= " + resistors.get(i) + "  " + "Vr" + (i+1) + "= " + resV.get(i) + "\n";
        }

        return returnValue;

    }
}
