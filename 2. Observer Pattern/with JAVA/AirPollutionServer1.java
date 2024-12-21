import java.util.ArrayList;

interface AirPollutionSubject {
    void registObserver(AirPollutionObserver o);
    void unRegistObserver(AirPollutionObserver o);
    void notifyObserver(int pollution);
}

public class AirPollutionServer1 implements Runnable, AirPollutionSubject {
    private int pollution = 50;
    private boolean stop = false;
    private int sleepDuration;
    private ArrayList<AirPollutionObserver> observers = new ArrayList<>();

    public AirPollutionServer1(int duration) {
        sleepDuration = duration;
    }

    @Override
    public void registObserver(AirPollutionObserver o) {
        observers.add(o);
        o.show();
    }

    @Override
    public void unRegistObserver(AirPollutionObserver o) {
        // Later...
    }

    public void notifyObserver(int pollution) {
        int length = observers.size();
        for (int i = 0; i < length; i++) {
            // 알려주면 된다.
            AirPollutionObserver obs = observers.get(i);
            obs.update(pollution);
            //System.out.print("Hello Somthing Changed...\n");
        }
    }

    @Override
    public void run() {
        while (!stop) {
            int plusMinus = RandIntInRange.nextInt(0, 1);
            int pollutionDiff = RandIntInRange.nextInt(1, 10);
            // 반드시 정보의 변화가 생김
            if (plusMinus == 1) {
                pollution += pollutionDiff;
            }
            else {
                pollution -= pollutionDiff;
                if (pollution < 0) {
                    pollution = 0;
                }
            }
            System.out.printf("Server: pollution = %d\n", pollution);
            // Oberver들에게 알려주는 코드 작성
            notifyObserver(pollution);

            try {
                Thread.sleep(sleepDuration); // sleepDuration밀리초 멈춤
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getPollution() { return pollution; }
    public void stopThread() { stop = true; }
}