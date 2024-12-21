class AirMain1 {
	
	public int list = 0;
	
    public static void main(String[] args) {
        final int DURATION = 300;
        final int SLEEP_TIME = 10000;
        final int CLIENT_COUNT = 2;
        final int[] CLIENT_SLEEP_TIME = { 300, 600 };        
        
        // 미세먼지 농도 변경 쓰레드 실행
        AirPollutionServer1 server = new AirPollutionServer1(DURATION);
        Thread serverThread = new Thread(server);
        serverThread.start();

        AirPollutionReader1[] readers = new AirPollutionReader1[CLIENT_COUNT];
        Thread[] threads = new Thread[CLIENT_COUNT];

        // Reader가 Server를 구독한하는 코드 구현 해야함
        for (int i = 0; i < CLIENT_COUNT; i++) {
            readers[i] = new AirPollutionReader1(i + 1, CLIENT_SLEEP_TIME[i]);
            threads[i] = new Thread(readers[i]);
            server.registObserver(readers[i]);
        }

        // 모두 등록을 마치고 쓰레드 실행
        for (int i = 0; i < CLIENT_COUNT; i++) {
            threads[i].start();
        }

        try {
            Thread.sleep(SLEEP_TIME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 미세먼지 농도 변경 쓰레드 종료
        server.stopThread();
        for (int i = 0; i < CLIENT_COUNT; i++) {
            readers[i].stopThread();
        }

    }
}