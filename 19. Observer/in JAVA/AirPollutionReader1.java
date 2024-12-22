interface AirPollutionObserver {
    void update(int pollution);
    void show();
}

public class AirPollutionReader1 implements Runnable, AirPollutionObserver {
    //private AirPollutionServer1 server; // 서버 객체를 받음

    private int sleepDuration;
    private boolean stop = false;
    private int num;
    
    public AirPollutionReader1( int num, int duration) {
        //this.server = server;
        this.sleepDuration = duration;
        this.num = num;
        //server.registObserver(this);
    }

    @Override
    public void update(int pollution) {
        System.out.printf("readerNumber = %d, pollution = %d\n",num, pollution);
    }

    @Override
    public  void show() {
        System.out.printf("this oberver num is %d", num);
    }

    @Override
    public void run() {

        // reader가
        // run은 하나의 Thread에서 동작 (server가 동작중)
        // 다른 함수는 이외의 Thread에서 동작 (전혀 다른 함수를 호출해도 상관없음, 별개의 과정)
        while (!stop) {
            try {
                //이전 방식 : server의 오염 정보를 직접 받아옴
                //System.out.printf("readerNumber = %d, pollution = %d\n", num, server.getPollution());
                Thread.sleep(sleepDuration); // sleepDuration밀리초 멈춤
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void stopThread() { stop = true; }    
}